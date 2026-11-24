import os
import stat
import subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SIGNTOOL = Path(r"C:\Program Files (x86)\Windows Kits\10\bin\10.0.26100.0\x64\signtool.exe")
PFX = ROOT / "build" / "AudixCodeSigning.pfx"
PASSWORD = "AudixRelease2026!"

# Terminate any running Nightly/Audix/java processes to release file locks
print("[+] Ensuring no active Nightly processes are locking binaries...")
try:
    import psutil
    for p in psutil.process_iter(['name', 'exe']):
        try:
            if p.info['name'] and p.info['name'].lower() in ['nightly.exe', 'audix.exe', 'java.exe', 'javaw.exe']:
                p.kill()
        except Exception:
            pass
except Exception:
    pass

targets = [
    ROOT / "release-artifacts" / "Nightly-v1.0.4-Windows-Installer.exe",
    ROOT / "release-artifacts" / "Nightly-v1.0.4-Windows-Installer.msi",
    ROOT / "release-artifacts" / "Nightly-Windows-Portable" / "Nightly.exe",
    ROOT / "desktopApp" / "build" / "compose" / "binaries" / "main" / "app" / "Nightly" / "Nightly.exe",
]

# Also search for any *.exe or *.msi in release-artifacts starting with Nightly
for f in (ROOT / "release-artifacts").glob("Nightly*.exe"):
    if f not in targets:
        targets.append(f)
for f in (ROOT / "release-artifacts").glob("Nightly*.msi"):
    if f not in targets:
        targets.append(f)

print("============================================================")
print("  SIGNING NIGHTLY BINARIES WITH AUTHENTICODE SIGNATURE")
print("============================================================")

for t in targets:
    if not t.exists():
        continue
    
    # Ensure write permissions
    try:
        os.chmod(t, stat.S_IWRITE | stat.S_IREAD | stat.S_IEXEC)
    except Exception:
        pass

    print(f"\n[+] Signing: {t.name} ({t.parent})")
    cmd = [
        str(SIGNTOOL),
        "sign",
        "/f", str(PFX),
        "/p", PASSWORD,
        "/fd", "SHA256",
        "/d", "Nightly - High-Fidelity Music Player",
        "/du", "https://github.com/brahmkshatriya/echo",
        "/tr", "http://timestamp.digicert.com",
        "/td", "SHA256",
        str(t)
    ]
    res = subprocess.run(cmd, capture_output=True, text=True)
    if res.returncode == 0:
        print(f"[OK] Successfully signed & timestamped: {t.name}")
    else:
        # Fallback without timestamp if network times out
        cmd_notime = [
            str(SIGNTOOL),
            "sign",
            "/f", str(PFX),
            "/p", PASSWORD,
            "/fd", "SHA256",
            "/d", "Nightly - High-Fidelity Music Player",
            str(t)
        ]
        res2 = subprocess.run(cmd_notime, capture_output=True, text=True)
        if res2.returncode == 0:
            print(f"[OK] Successfully signed (offline): {t.name}")
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
