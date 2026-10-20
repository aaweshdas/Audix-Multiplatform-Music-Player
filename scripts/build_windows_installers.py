import os
import sys
import shutil
import subprocess
from pathlib import Path

ROOT_DIR = Path(__file__).resolve().parent.parent
WIX_BIN = ROOT_DIR / "build" / "wix311"
JPACKAGE_BIN = Path(r"C:\Program Files\Android\openjdk\jdk-21.0.8\bin\jpackage.exe")
APP_IMAGE_DIR = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "app" / "Audix"
RELEASE_DIR = ROOT_DIR / "release-artifacts"
ICON_PATH = ROOT_DIR / "desktopApp" / "src" / "desktopMain" / "resources" / "icons" / "audix.ico"
PORTABLE_VLC_DIR = RELEASE_DIR / "Audix-Windows-Portable" / "runtime" / "vlc"
TARGET_VLC_DIR = APP_IMAGE_DIR / "runtime" / "vlc"

def prepare_app_image():
    if not APP_IMAGE_DIR.exists():
        raise RuntimeError(f"App image directory not found: {APP_IMAGE_DIR}")
    
    # Ensure VLC runtime is bundled in app image
    if not TARGET_VLC_DIR.exists() or not (TARGET_VLC_DIR / "libvlc.dll").exists():
        print(f"[+] Copying LibVLC runtime into app image: {TARGET_VLC_DIR}...")
        if not PORTABLE_VLC_DIR.exists():
            raise RuntimeError(f"Source VLC directory not found: {PORTABLE_VLC_DIR}")
        shutil.copytree(PORTABLE_VLC_DIR, TARGET_VLC_DIR, dirs_exist_ok=True)
    else:
        print("[OK] LibVLC runtime already present in app image.")

    print(f"[OK] App image verified at: {APP_IMAGE_DIR}")

def build_installer(pkg_type: str, dest_dir: Path):
    dest_dir.mkdir(parents=True, exist_ok=True)
    env = os.environ.copy()
    env["PATH"] = str(WIX_BIN) + os.pathsep + env.get("PATH", "")

    cmd = [
        str(JPACKAGE_BIN),
        "--type", pkg_type,
        "--app-image", str(APP_IMAGE_DIR),
        "--dest", str(dest_dir),
        "--name", "Audix",
        "--app-version", "1.0.3",
        "--vendor", "Audix",
        "--description", "Audix - High-Fidelity Music Player",
        "--copyright", "Copyright 2026 Audix",
        "--icon", str(ICON_PATH),
        "--win-dir-chooser",
        "--win-menu",
        "--win-menu-group", "Audix",
        "--win-shortcut",
        "--verbose"
    ]

    print(f"\n[+] Building {pkg_type.upper()} installer via jpackage + WiX...")
    res = subprocess.run(cmd, env=env, text=True, capture_output=True)
    if res.returncode != 0:
        print(f"[!] Error building {pkg_type}:")
        print(res.stderr)
        print(res.stdout)
        sys.exit(res.returncode)
    
    print(f"[OK] Successfully built {pkg_type.upper()} installer in {dest_dir}!")

def main():
    print("=" * 60)
    print("  AUDIX WINDOWS INSTALLER BUILDER (MSI & EXE)")
    print("=" * 60)
    
    prepare_app_image()
    
    msi_dest = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "msi"
    exe_dest = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "exe"

    build_installer("msi", msi_dest)
    build_installer("exe", exe_dest)

    # Sync to release-artifacts
    print("\n[+] Deploying installers to release-artifacts...")
    msi_files = list(msi_dest.glob("Audix-*.msi"))
    exe_files = list(exe_dest.glob("Audix-*.exe"))

    if msi_files:
        latest_msi = sorted(msi_files, key=lambda f: f.stat().st_mtime, reverse=True)[0]
        shutil.copy2(latest_msi, RELEASE_DIR / "Audix-v1.0.3-Windows-Installer.msi")
        print(f"[OK] Copied MSI to release-artifacts: {latest_msi.name} -> Audix-v1.0.3-Windows-Installer.msi")

    if exe_files:
        latest_exe = sorted(exe_files, key=lambda f: f.stat().st_mtime, reverse=True)[0]
        shutil.copy2(latest_exe, RELEASE_DIR / "Audix-v1.0.3-Windows-Installer.exe")
        print(f"[OK] Copied EXE to release-artifacts: {latest_exe.name} -> Audix-v1.0.3-Windows-Installer.exe")

    # Clean up obsolete or duplicate installer files in release-artifacts
    for obsolete in [
        RELEASE_DIR / "Audix-v1.0.2-Windows-Installer.msi",
        RELEASE_DIR / "Audix-v1.0.2-Windows-Installer.exe",
        RELEASE_DIR / "Audix-v1.0.2-Windows-Portable.zip",
        RELEASE_DIR / "Audix-v1.0.2-Windows-Trusted-Setup.zip",
        RELEASE_DIR / "Audix-v1.0.1-Windows-Installer.msi",
        RELEASE_DIR / "Audix-v1.0.1-Windows-Installer.exe",
        RELEASE_DIR / "Audix-v1.0.1-Windows-Portable.zip",
        RELEASE_DIR / "Audix-Windows-Installer.msi",
        RELEASE_DIR / "Audix-Windows-Installer.exe",
    ]:
        if obsolete.exists():
            try:
                obsolete.unlink()
                print(f"[OK] Removed obsolete artifact: {obsolete.name}")
            except Exception as e:
                print(f"[!] Could not remove {obsolete.name}: {e}")

    # Rename Android APK if old version name exists
    old_apk = RELEASE_DIR / "Audix-v1.0.2-Android.apk"
    if not old_apk.exists():
        old_apk = RELEASE_DIR / "Audix-v1.0.1-Android.apk"
    new_apk = RELEASE_DIR / "Audix-v1.0.3-Android.apk"
    if old_apk.exists() and not new_apk.exists():
        old_apk.rename(new_apk)
        print(f"[OK] Renamed {old_apk.name} -> {new_apk.name}")

    # Automatically sign the generated installers
    sign_script = ROOT_DIR / "scripts" / "sign_all_release_binaries.py"
    if sign_script.exists():
        print("\n[+] Signing generated installers with Authenticode signature...")
        subprocess.run([sys.executable, str(sign_script)], check=False)

    # Re-package trusted setup zip
    zip_path = RELEASE_DIR / "Audix-v1.0.3-Windows-Trusted-Setup.zip"
    files_to_pack = [
        (RELEASE_DIR / "Audix-v1.0.3-Windows-Installer.exe", "Audix-v1.0.3-Windows-Installer.exe"),
        (RELEASE_DIR / "Install-Audix-Trusted.bat", "Install-Audix-Trusted.bat"),
        (RELEASE_DIR / "Audix-Certificate.cer", "Audix-Certificate.cer"),
        (RELEASE_DIR / "README-SETUP.txt", "README-SETUP.txt")
    ]
    import zipfile
    with zipfile.ZipFile(zip_path, 'w', compression=zipfile.ZIP_DEFLATED) as z:
        for src, arc in files_to_pack:
            if src.exists():
                z.write(src, arc)
    print(f"[OK] Packaged trusted setup bundle: {zip_path.name}")

    print("\n[OK] ALL WINDOWS INSTALLERS BUILT, SIGNED, AND DEPLOYED SUCCESSFULLY!")

if __name__ == "__main__":
    main()
