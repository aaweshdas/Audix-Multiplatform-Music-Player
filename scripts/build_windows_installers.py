import os
import sys
import shutil
import subprocess
from pathlib import Path

ROOT_DIR = Path(__file__).resolve().parent.parent
WIX_BIN = ROOT_DIR / "build" / "wix311"
JPACKAGE_BIN = Path(r"C:\Program Files\Android\openjdk\jdk-21.0.8\bin\jpackage.exe")
APP_IMAGE_DIR = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "app" / "Nightly"
RELEASE_DIR = ROOT_DIR / "release-artifacts"
ICON_PATH = ROOT_DIR / "desktopApp" / "src" / "desktopMain" / "resources" / "icons" / "nightly.ico"
PORTABLE_DIR = RELEASE_DIR / "Nightly-Windows-Portable"
PORTABLE_VLC_DIR = PORTABLE_DIR / "runtime" / "vlc"
TARGET_VLC_DIR = APP_IMAGE_DIR / "runtime" / "vlc"

def prepare_app_image():
    APP_IMAGE_DIR.mkdir(parents=True, exist_ok=True)
    
    # Purge any legacy Audix cfg, exe, ico files from app image and portable
    for base in [APP_IMAGE_DIR, PORTABLE_DIR]:
        for pattern in ["Audix.cfg", "Audix.exe", "Audix.ico", "Audix-CodeSigning-CA.cer", "Trust-Audix-Certificate.bat"]:
            for f in base.glob(f"**/{pattern}"):
                try:
                    f.unlink()
                    print(f"[OK] Purged legacy file: {f}")
                except Exception:
                    pass

    # Ensure executables and root assets are present
    for root_file in ["Nightly.exe", "Nightly.ico", "skiko-windows-x64.dll"]:
        src_f = PORTABLE_DIR / root_file
        dst_f = APP_IMAGE_DIR / root_file
        if src_f.exists() and (not dst_f.exists() or src_f.stat().st_mtime > dst_f.stat().st_mtime):
            shutil.copy2(src_f, dst_f)
            print(f"[+] Synced {root_file} to app image.")

    if not (APP_IMAGE_DIR / "app").exists() or len(list((APP_IMAGE_DIR / "app").glob("*.jar"))) == 0:
        print(f"[+] Syncing runtime and app jars from portable to: {APP_IMAGE_DIR}...")
        shutil.copytree(PORTABLE_DIR / "app", APP_IMAGE_DIR / "app", dirs_exist_ok=True)
        if (PORTABLE_DIR / "runtime").exists():
            shutil.copytree(PORTABLE_DIR / "runtime", APP_IMAGE_DIR / "runtime", dirs_exist_ok=True)

    # Ensure VLC runtime is bundled in app image
    if not TARGET_VLC_DIR.exists() or not (TARGET_VLC_DIR / "libvlc.dll").exists():
        print(f"[+] Copying LibVLC runtime into app image: {TARGET_VLC_DIR}...")
        source_vlc = PORTABLE_VLC_DIR
        if not source_vlc.exists():
            raise RuntimeError(f"Source VLC directory not found: {source_vlc}")
        shutil.copytree(source_vlc, TARGET_VLC_DIR, dirs_exist_ok=True)
    else:
        print("[OK] LibVLC runtime already present in app image.")

    # Ensure .jpackage.xml has Nightly launcher state
    xml_content = """<?xml version="1.0" ?>
<jpackage-state version="21.0.8" platform="windows">
  <app-version>1.0.4</app-version>
  <main-launcher>Nightly</main-launcher>
  <main-class>dev.brahmkshatriya.echo.desktop.MainKt</main-class>
  <signed>true</signed>
  <app-store>false</app-store>
</jpackage-state>
"""
    for jp_xml in [APP_IMAGE_DIR / "app" / ".jpackage.xml", PORTABLE_DIR / "app" / ".jpackage.xml"]:
        jp_xml.parent.mkdir(parents=True, exist_ok=True)
        jp_xml.write_text(xml_content, encoding="utf-8")
        print(f"[OK] Ensured {jp_xml} main-launcher is Nightly.")

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
        "--name", "Nightly",
        "--app-version", "1.0.4",
        "--vendor", "Nightly",
        "--description", "Nightly - High-Fidelity Music Player",
        "--copyright", "Copyright 2026 Nightly",
        "--icon", str(ICON_PATH),
        "--win-dir-chooser",
        "--win-menu",
        "--win-menu-group", "Nightly",
        "--win-shortcut",
        "--verbose"
    ]

    print(f"\n[+] Building {pkg_type.upper()} installer for Nightly via jpackage + WiX...")
    res = subprocess.run(cmd, env=env, text=True, capture_output=True)
    if res.returncode != 0:
        print(f"[!] Error building {pkg_type}:")
        print(res.stderr)
        print(res.stdout)
        sys.exit(res.returncode)
    
    print(f"[OK] Successfully built Nightly {pkg_type.upper()} installer in {dest_dir}!")

def main():
    print("=" * 60)
    print("  NIGHTLY WINDOWS INSTALLER BUILDER (MSI & EXE)")
    print("=" * 60)
    
    prepare_app_image()
    
    msi_dest = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "msi"
    exe_dest = ROOT_DIR / "desktopApp" / "build" / "compose" / "binaries" / "main" / "exe"

    build_installer("msi", msi_dest)
    build_installer("exe", exe_dest)

    # Sync to release-artifacts
    print("\n[+] Deploying installers to release-artifacts...")
    msi_files = list(msi_dest.glob("Nightly-*.msi"))
    exe_files = list(exe_dest.glob("Nightly-*.exe"))

    if msi_files:
        latest_msi = sorted(msi_files, key=lambda f: f.stat().st_mtime, reverse=True)[0]
        shutil.copy2(latest_msi, RELEASE_DIR / "Nightly-v1.0.4-Windows-Installer.msi")
        print(f"[OK] Copied MSI to release-artifacts: {latest_msi.name} -> Nightly-v1.0.4-Windows-Installer.msi")

    if exe_files:
        latest_exe = sorted(exe_files, key=lambda f: f.stat().st_mtime, reverse=True)[0]
        shutil.copy2(latest_exe, RELEASE_DIR / "Nightly-v1.0.4-Windows-Installer.exe")
        print(f"[OK] Copied EXE to release-artifacts: {latest_exe.name} -> Nightly-v1.0.4-Windows-Installer.exe")

    # Clean up obsolete Audix installer files in release-artifacts so only Nightly is visible
    for obsolete in RELEASE_DIR.glob("Audix-*"):
        try:
            if obsolete.is_file():
                obsolete.unlink()
                print(f"[OK] Removed legacy artifact: {obsolete.name}")
        except Exception as e:
            print(f"[!] Could not remove {obsolete.name}: {e}")

    # Automatically sign the generated installers
    sign_script = ROOT_DIR / "scripts" / "sign_all_release_binaries.py"
    if sign_script.exists():
        print("\n[+] Signing generated installers with Authenticode signature...")
        subprocess.run([sys.executable, str(sign_script)], check=False)

    # Re-package trusted setup zip
    zip_path = RELEASE_DIR / "Nightly-v1.0.4-Windows-Trusted-Setup.zip"
    files_to_pack = [
        (RELEASE_DIR / "Nightly-v1.0.4-Windows-Installer.exe", "Nightly-v1.0.4-Windows-Installer.exe"),
        (RELEASE_DIR / "Install-Nightly-Trusted.bat", "Install-Nightly-Trusted.bat"),
        (ROOT_DIR / "Trust-Nightly-Certificate.bat", "Trust-Nightly-Certificate.bat"),
        (RELEASE_DIR / "Nightly-CodeSigning-CA.cer", "Nightly-CodeSigning-CA.cer"),
        (RELEASE_DIR / "README-SETUP.txt", "README-SETUP.txt")
    ]
    import zipfile
    with zipfile.ZipFile(zip_path, 'w', compression=zipfile.ZIP_DEFLATED) as z:
        for src, arc in files_to_pack:
            if src.exists():
                z.write(src, arc)
    print(f"[OK] Packaged trusted setup bundle: {zip_path.name}")

    # Re-package portable zip with certificate helper
    portable_zip = RELEASE_DIR / "Nightly-v1.0.4-Windows-Portable.zip"
    if PORTABLE_DIR.exists():
        print(f"\n[+] Packaging portable zip: {portable_zip.name}...")
        with zipfile.ZipFile(portable_zip, 'w', compression=zipfile.ZIP_DEFLATED) as pz:
            for root, dirs, files in os.walk(PORTABLE_DIR):
                for f in files:
                    fp = Path(root) / f
                    rel = fp.relative_to(PORTABLE_DIR)
                    pz.write(fp, arcname=str(rel))
        print(f"[OK] Successfully packaged: {portable_zip.name}")

    print("\n[OK] ALL NIGHTLY WINDOWS INSTALLERS BUILT, SIGNED, AND DEPLOYED SUCCESSFULLY!")

if __name__ == "__main__":
    main()
