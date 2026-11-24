"""
Nightly Multiplatform Music Player — Automated GitHub Release Publisher
Creates or updates a GitHub Release with live-computed SHA-256 checksums and
uploads all verified Windows and Android distribution artifacts.
"""

import hashlib
import json
import os
import subprocess
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from pathlib import Path

ROOT_DIR = Path(__file__).resolve().parent.parent
RELEASE_DIR = ROOT_DIR / "release-artifacts"

OWNER = "aaweshdas"
REPO = "Audix-Multiplatform-Music-Player"
VERSION = "1.0.4"
TAG = f"v{VERSION}"
RELEASE_NAME = f"Nightly {TAG} — Real-Time WASAPI ECG Heartbeat Visualizer, Lyrics Studio & Sleep Timer"


def get_github_token() -> str:
    env_token = os.environ.get("GH_TOKEN") or os.environ.get("GITHUB_TOKEN")
    if env_token:
        return env_token.strip()
    proc = subprocess.Popen(
        ["git", "credential", "fill"],
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        text=True,
    )
    out, _ = proc.communicate("protocol=https\nhost=github.com\n\n")
    creds = dict(line.split("=", 1) for line in out.splitlines() if "=" in line)
    return creds.get("password", "").strip()


def sha256_file(path: Path) -> str:
    h = hashlib.sha256()
    with path.open("rb") as f:
        while True:
            chunk = f.read(1024 * 1024)
            if not chunk:
                break
            h.update(chunk)
    return h.hexdigest()


def size_mb(path: Path) -> str:
    return f"{path.stat().st_size / (1024 * 1024):.1f} MB"


def build_release_body(asset_entries: list[tuple[str, str, Path]]) -> str:
    rows = []
    for label, _, path in asset_entries:
        digest = sha256_file(path)
        rows.append(f"| {label} | `{path.name}` | **{size_mb(path)}** | `{digest}` |")
    checksum_table = "\n".join(rows)

    return f"""## Nightly {TAG} — Release Summary

We are excited to release **Nightly {TAG}**, introducing a **real-time Windows WASAPI Loopback ECG Heartbeat Visualizer**, a **GPU Skia Gaussian Neon rendering engine**, **Synchronized Karaoke Lyrics Studio**, **Nightly Sleep Timer with 30-second exponential audio fade-out**, **In-App Direct3D Cinema Theater**, and **Authenticode-signed Windows installers**.

---

### What's New in {TAG}

#### 1. Real-Time Music-Vibration ECG Heartbeat Visualizer
- **True Live Windows WASAPI Loopback Audio Tap**: Captures the live system playback PCM mix via JNA COM (`AUDCLNT_STREAMFLAGS_LOOPBACK`) without interfering with LibVLC's hardware output, equalizer, volume, or Bluetooth/headphone device switching.
- **Dual-Band Spectral-Flux Beat Detector & Adaptive AGC**: Isolates real kick drums, bass drops, and snare impacts across any listening volume (15%–100%), while settling calmly during silent intros or pauses.
- **Direct Acoustic Line Vibration**: Streams a lock-free 96-sample live PCM waveform snapshot into the glowing crimson beam so vocals, guitars, and bass physically vibrate the waveform in real time.
- **GPU Skia Gaussian Neon Bloom**: Hardware-accelerated `MaskFilter.makeBlur` outer and inner crimson glow layers, seamless elliptical radial backlight aura, razor-sharp miter-joined R/S needle apexes, and waveform-locked telemetry spark.
- **Zero-Recomposition / Zero-GC Performance**: Draw-phase `withFrameNanos` engine with pre-allocated Skia `Path`, `Paint`, and `Shader` resources (~1.3%–2.6% normalized CPU).

#### 2. Synchronized Karaoke Lyrics Studio
- Built-in **Lyrics Studio** modal accessible directly from the Soundstage Billboard header (`LYRICS` badge).
- Connects to LRCLIB synchronized lyrics with smooth auto-scrolling, active-line glow highlighting, click-to-seek timestamp navigation, and plain-lyrics fallback.

#### 3. Nightly Sleep Timer with Smooth Audio Fade-Out
- Dedicated **Nightly Sleep Timer** modal with quick presets (15m, 30m, 45m, 60m), live countdown indicator, optional auto-exit, and a 30-second exponential volume fade-out ramp before pausing (automatically restoring volume afterward).

#### 4. Complete Nightly Rebrand, In-App Cinema & Media Accuracy
- Unified **Nightly** desktop branding, logo assets, window title (`Nightly {TAG}-UNIFIED`), and high-resolution artwork resolution across all 10 bundled streaming and metadata extensions.
- Streamlined **Movie Play / In-App Direct3D Cinema** experience with 2-row command dock.

#### 5. Authenticode-Signed Windows Distribution & Trusted Setup
- All Windows `.exe` and `.msi` installers and `Nightly.exe` binaries are signed with SHA-256 Authenticode certificates and RFC3161 timestamps.
- Includes one-click **`Install-Nightly-Trusted.bat`** and **`Trust-Nightly-Certificate.bat`** inside the Trusted Setup bundle.

---

### Downloads & SHA-256 Checksums

| Platform / Format | Filename | Size | SHA-256 Checksum |
| :--- | :--- | :--- | :--- |
{checksum_table}

---

### Installation Guide

#### Windows 10 & 11 (Recommended — Trusted Setup)
1. Download **`Nightly-{TAG}-Windows-Trusted-Setup.zip`** and extract it.
2. Right-click **`Install-Nightly-Trusted.bat`** and select **Run as administrator** (or run `Trust-Nightly-Certificate.bat` followed by `Nightly-{TAG}-Windows-Installer.exe`).
3. Complete the setup wizard — Windows SmartScreen will recognize Nightly as a verified publisher.

#### Windows Portable (Zero Installation)
- Download **`Nightly-{TAG}-Windows-Portable.zip`**, extract anywhere, and run **`Nightly.exe`** (or `Run-Nightly.bat`).

#### Android (SDK 24+)
- Download **`Nightly-{TAG}-Android.apk`** on your Android device and install directly.
"""


def api_request(url: str, token: str, method: str = "GET", data: bytes | None = None, content_type: str = "application/json") -> dict:
    headers = {
        "Authorization": f"Bearer {token}",
        "User-Agent": "Nightly-Release-Publisher",
        "Accept": "application/vnd.github+json",
    }
    if data is not None:
        headers["Content-Type"] = content_type
    req = urllib.request.Request(url, data=data, headers=headers, method=method)
    with urllib.request.urlopen(req, timeout=600) as resp:
        raw = resp.read().decode("utf-8")
        return json.loads(raw) if raw else {}


def upload_asset(upload_url_template: str, token: str, path: Path, existing_assets: dict[str, int]) -> None:
    # Delete existing asset with the same name so re-runs are idempotent
    if path.name in existing_assets:
        asset_id = existing_assets[path.name]
        del_url = f"https://api.github.com/repos/{OWNER}/{REPO}/releases/assets/{asset_id}"
        print(f"   [-] Removing stale asset {path.name} (id={asset_id})...")
        api_request(del_url, token, method="DELETE")

    base_upload = upload_url_template.split("{", 1)[0]
    upload_url = f"{base_upload}?name={urllib.parse.quote(path.name)}"
    file_size = path.stat().st_size

    for attempt in range(1, 4):
        try:
            print(f"   [+] Uploading {path.name} ({size_mb(path)}) [attempt {attempt}/3]...")
            # Use curl for reliable streamed large-file HTTP uploads (>400 MB) without loading full file into Python RAM
            cmd = [
                "curl.exe",
                "-f",
                "-sS",
                "-X", "POST",
                "-H", f"Authorization: Bearer {token}",
                "-H", "Accept: application/vnd.github+json",
                "-H", "Content-Type: application/octet-stream",
                "-H", "User-Agent: Nightly-Release-Publisher",
                "--data-binary", f"@{path}",
                upload_url,
            ]
            res = subprocess.run(cmd, capture_output=True, text=True, timeout=1800)
            if res.returncode == 0:
                info = json.loads(res.stdout) if res.stdout.strip() else {}
                print(f"   [OK] Uploaded {path.name} ({file_size:,} bytes) -> {info.get('browser_download_url', 'OK')}")
                return
            raise RuntimeError(f"curl exited {res.returncode}: {res.stderr.strip() or res.stdout[:300]}")
        except Exception as exc:
            print(f"   [!] Upload attempt {attempt} failed for {path.name}: {exc}")
            if attempt == 3:
                raise
            time.sleep(5)


def main() -> None:
    token = get_github_token()
    if not token:
        print("Error: Could not obtain GitHub token from GH_TOKEN or git credential helper.")
        sys.exit(1)

    asset_specs = [
        ("Windows Installer (.EXE)", "application/octet-stream", RELEASE_DIR / f"Nightly-{TAG}-Windows-Installer.exe"),
        ("Windows Installer (.MSI)", "application/octet-stream", RELEASE_DIR / f"Nightly-{TAG}-Windows-Installer.msi"),
        ("Windows Portable (.ZIP)", "application/zip", RELEASE_DIR / f"Nightly-{TAG}-Windows-Portable.zip"),
        ("Trusted Setup Bundle (.ZIP)", "application/zip", RELEASE_DIR / f"Nightly-{TAG}-Windows-Trusted-Setup.zip"),
        ("Android APK (SDK 24+)", "application/vnd.android.package-archive", RELEASE_DIR / f"Nightly-{TAG}-Android.apk"),
    ]

    missing = [str(p) for _, _, p in asset_specs if not p.exists()]
    if missing:
        print("Error: Missing required release artifacts:\n  " + "\n  ".join(missing))
        sys.exit(1)

    print(f"[1/3] Computing SHA-256 checksums for {len(asset_specs)} artifacts...")
    body = build_release_body(asset_specs)

    print(f"[2/3] Creating or updating GitHub Release {TAG} on {OWNER}/{REPO}...")
    tag_url = f"https://api.github.com/repos/{OWNER}/{REPO}/releases/tags/{TAG}"
    try:
        release = api_request(tag_url, token, method="GET")
        release_id = release["id"]
        print(f"   [OK] Found existing release {TAG} (id={release_id}), updating metadata...")
        patch_payload = json.dumps({
            "name": RELEASE_NAME,
            "body": body,
            "draft": False,
            "prerelease": False,
            "make_latest": "true",
        }).encode("utf-8")
        release = api_request(
            f"https://api.github.com/repos/{OWNER}/{REPO}/releases/{release_id}",
            token,
            method="PATCH",
            data=patch_payload,
        )
    except urllib.error.HTTPError as err:
        if err.code != 404:
            raise
        create_payload = json.dumps({
            "tag_name": TAG,
            "target_commitish": "main",
            "name": RELEASE_NAME,
            "body": body,
            "draft": False,
            "prerelease": False,
            "make_latest": "true",
        }).encode("utf-8")
        release = api_request(
            f"https://api.github.com/repos/{OWNER}/{REPO}/releases",
            token,
            method="POST",
            data=create_payload,
        )
        print(f"   [OK] Created release {TAG} (id={release['id']})")

    existing_assets = {a["name"]: a["id"] for a in release.get("assets", [])}
    upload_url = release["upload_url"]

    print(f"[3/3] Uploading {len(asset_specs)} signed release artifacts...")
    for _, _, path in asset_specs:
        upload_asset(upload_url, token, path, existing_assets)

    print(f"\n[SUCCESS] Release {TAG} published cleanly at: {release.get('html_url')}")


if __name__ == "__main__":
    main()
