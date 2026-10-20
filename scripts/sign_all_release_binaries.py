import os
import subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SIGNTOOL = Path(r"C:\Program Files (x86)\Windows Kits\10\bin\10.0.26100.0\x64\signtool.exe")
PFX = ROOT / "build" / "AudixCodeSigning.pfx"
PASSWORD = "AudixRelease2026!"

targets = [
    ROOT / "release-artifacts" / "Audix-v1.0.3-Windows-Installer.exe",
    ROOT / "release-artifacts" / "Audix-v1.0.3-Windows-Installer.msi",
    ROOT / "release-artifacts" / "Audix-Windows-Portable" / "Audix.exe",
    ROOT / "desktopApp" / "build" / "compose" / "binaries" / "main" / "app" / "Audix" / "Audix.exe",
    Path(os.path.expanduser(r"~\Downloads\Audix-v1.0.3-Windows-Installer.exe"))
]

print("============================================================")
print("  SIGNING AUDIX BINARIES WITH AUTHENTICODE SIGNATURE")
print("============================================================")

for t in targets:
    if not t.exists():
        print(f"[-] Target not found: {t}")
        continue
    
    print(f"\n[+] Signing: {t.name} ({t.parent})")
    cmd = [
        str(SIGNTOOL),
        "sign",
        "/f", str(PFX),
        "/p", PASSWORD,
        "/fd", "SHA256",
        "/d", "Audix - High-Fidelity Music Player",
        str(t)
    ]
    res = subprocess.run(cmd, capture_output=True, text=True)
    if res.returncode == 0:
        print(f"[OK] Successfully signed: {t.name}")
    else:
        print(f"[!] Signing error on {t.name}:\n{res.stdout}\n{res.stderr}")

print("\n============================================================")
print("  VERIFYING SIGNATURES")
print("============================================================")
for t in targets:
    if t.exists():
        vcmd = [str(SIGNTOOL), "verify", "/pa", str(t)]
        vres = subprocess.run(vcmd, capture_output=True, text=True)
        print(f"[{t.name}] -> {vres.stdout.strip()}")
