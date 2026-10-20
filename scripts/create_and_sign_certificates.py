import os
import sys
import subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
BUILD_DIR = ROOT / "build"
RELEASE_DIR = ROOT / "release-artifacts"
SIGNTOOL = Path(r"C:\Program Files (x86)\Windows Kits\10\bin\10.0.26100.0\x64\signtool.exe")

PFX_PATH = BUILD_DIR / "AudixCodeSigning.pfx"
CER_PATH = RELEASE_DIR / "Audix-Certificate.cer"
PFX_PASSWORD = "AudixRelease2026!"

def ensure_certificate():
    BUILD_DIR.mkdir(parents=True, exist_ok=True)
    RELEASE_DIR.mkdir(parents=True, exist_ok=True)

    if PFX_PATH.exists() and CER_PATH.exists():
        print(f"[OK] Existing certificate found: {PFX_PATH.name} and {CER_PATH.name}")
        return

    print("[+] Generating dedicated Audix Code Signing Certificate...")
    ps_script = f'''
    $cert = New-SelfSignedCertificate -Type CodeSigningCert `
        -Subject "CN=Audix, O=Audix Desktop Audio, OU=Software Development, C=US" `
        -KeyUsage DigitalSignature `
        -FriendlyName "Audix Official Code Signing Certificate" `
        -CertStoreLocation "Cert:\\CurrentUser\\My" `
        -NotAfter (Get-Date).AddYears(10)

    $pwd = ConvertTo-SecureString -String "{PFX_PASSWORD}" -Force -AsPlainText
    Export-PfxCertificate -Cert $cert -FilePath "{PFX_PATH}" -Password $pwd
    Export-Certificate -Cert $cert -FilePath "{CER_PATH}"
    '''

    res = subprocess.run(["powershell", "-NoProfile", "-Command", ps_script], capture_output=True, text=True)
    if res.returncode != 0:
        print(f"[!] Error creating certificate:\n{res.stderr}\n{res.stdout}")
        sys.exit(1)

    print(f"[OK] Certificate generated:\n  PFX: {PFX_PATH}\n  CER: {CER_PATH}")

def sign_file(target_file: Path, description: str = "Audix Music Player"):
    if not target_file.exists():
        print(f"[!] File not found for signing: {target_file}")
        return False

    print(f"\n[+] Digitally signing: {target_file.name}...")
    # Timestamp servers to try in order
    timestamp_urls = [
        "http://timestamp.digicert.com",
        "http://timestamp.sectigo.com",
        "http://tsa.starfieldtech.com"
    ]

    signed_successfully = False
    for ts in timestamp_urls:
        cmd = [
            str(SIGNTOOL),
            "sign",
            "/f", str(PFX_PATH),
            "/p", PFX_PASSWORD,
            "/fd", "SHA256",
            "/tr", ts,
            "/td", "SHA256",
            "/d", description,
            str(target_file)
        ]
        res = subprocess.run(cmd, capture_output=True, text=True)
        if res.returncode == 0:
            print(f"[OK] Successfully signed and timestamped via {ts}: {target_file.name}")
            signed_successfully = True
            break
        else:
            print(f"[-] Timestamp server {ts} failed, trying next: {res.stdout.strip()} {res.stderr.strip()}")

    if not signed_successfully:
        # Fallback to signing without timestamp if network times out
        cmd_fallback = [
            str(SIGNTOOL),
            "sign",
            "/f", str(PFX_PATH),
            "/p", PFX_PASSWORD,
            "/fd", "SHA256",
            "/d", description,
            str(target_file)
        ]
        res_fallback = subprocess.run(cmd_fallback, capture_output=True, text=True)
        if res_fallback.returncode == 0:
            print(f"[OK] Successfully signed (without timestamp): {target_file.name}")
            signed_successfully = True
        else:
            print(f"[!] Signing failed for {target_file.name}: {res_fallback.stderr}")
            return False

    # Verify signature
    vcmd = [str(SIGNTOOL), "verify", "/pa", str(target_file)]
    vres = subprocess.run(vcmd, capture_output=True, text=True)
    print(f"[Verify] {target_file.name}: {vres.stdout.strip()}")
    return True

def install_cert_locally():
    print("\n[+] Installing Audix Certificate into local machine Trusted Root and Trusted Publisher...")
    ps_cmd = f'''
    $certPath = "{CER_PATH}"
    if (Test-Path $certPath) {{
        Import-Certificate -FilePath $certPath -CertStoreLocation "Cert:\\CurrentUser\\Root" | Out-Null
        Import-Certificate -FilePath $certPath -CertStoreLocation "Cert:\\CurrentUser\\TrustedPublisher" | Out-Null
        Write-Output "Audix certificate imported into CurrentUser Root & TrustedPublisher successfully."
    }}
    '''
    res = subprocess.run(["powershell", "-NoProfile", "-Command", ps_cmd], capture_output=True, text=True)
    print(res.stdout.strip())

def main():
    print("=" * 60)
    print("  AUDIX AUTHENTICODE SIGNING & TRUST AUTOMATOR")
    print("=" * 60)

    if not SIGNTOOL.exists():
        print(f"[!] signtool.exe not found at {SIGNTOOL}")
        sys.exit(1)

    ensure_certificate()
    install_cert_locally()

    targets = [
        ROOT / "desktopApp" / "build" / "compose" / "binaries" / "main" / "app" / "Audix" / "Audix.exe",
        RELEASE_DIR / "Audix-Windows-Portable" / "Audix.exe",
        RELEASE_DIR / "Audix-v1.0.3-Windows-Installer.exe",
        RELEASE_DIR / "Audix-v1.0.3-Windows-Installer.msi",
        Path(os.path.expanduser(r"~\Downloads\Audix-v1.0.3-Windows-Installer.exe"))
    ]

    for t in targets:
        if t.exists():
            sign_file(t)

    print("\n[OK] All available targets signed successfully!")

if __name__ == "__main__":
    main()
