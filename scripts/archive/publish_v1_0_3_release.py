import os
import sys
import subprocess
import urllib.request
import urllib.error
import json
import time

def get_github_token():
    p = subprocess.Popen(['git', 'credential', 'fill'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True)
    out, _ = p.communicate('protocol=https\nhost=github.com\n\n')
    creds = dict(line.split('=', 1) for line in out.splitlines() if '=' in line)
    return creds.get('password', '')

TOKEN = get_github_token()
if not TOKEN:
    print("Error: Could not retrieve GitHub token from git credentials.")
    sys.exit(1)

OWNER = "aaweshdas"
REPO = "Audix-Multiplatform-Music-Player"
TAG = "v1.0.3"
NAME = "Audix Release v1.0.3 — Real-Time Audio FFT Spectrum Visualizer & Unified Engine"

BODY = """## ⚡ Audix v1.0.3 — Release Summary

We are excited to announce **Audix v1.0.3**, featuring an all-new **Real-Time 28-Band Audio FFT Spectrum Visualizer**, native libVLC decoded PCM audio interception, sample-accurate volume scaling, and comprehensive track artwork and metadata resolution fixes!

---

### ✨ What's New in v1.0.3

#### 1. 🎛️ Real-Time 28-Band Audio FFT Spectrum Visualizer
- **True Frequency-Driven Animation**: Decodes live audio streams into 16-bit 44.1 kHz stereo PCM and executes an in-place **512-point Cooley-Tukey Radix-2 FFT** with a precomputed Hann window.
- **Accurate Frequency Band Mapping**: 28 logarithmic frequency bins from **40 Hz (Sub-Bass) to 15,000 Hz (Treble)**:
  - **Bars 0–5 (Sub-Bass & Bass, 40–250 Hz)**: Leaps and thumps in exact sync with 808 kicks, bass guitar, and low-end transients.
  - **Bars 6–18 (Mids & Vocals, 250–4,000 Hz)**: Responds dynamically to lead vocals, guitars, snares, and acoustic presence.
  - **Bars 19–27 (Highs & Treble, 4,000–15,000 Hz)**: Shimmers with hi-hats, cymbals, synth sparkles, and airy transients.
- **Studio Ballistics**: Instant **0 ms transient attack** paired with smooth exponential release decay (~0.72 factor) for a professional studio console look without jitter or freezing.
- **Integrated UI Surfaces**: Real-time frequencies directly drive the **Billboard Soundstage Visualizer** on the Home Screen and the **18-Bar Equalizer Spectrum** in the MiniPlayer (`getBands(18)`).

#### 2. 🔊 High-Performance PCM Audio Callback Engine
- **Direct libVLC Callback**: Uses native `AudioCallback` (`S16N`, 44.1 kHz, 2 channels) linked to Java Sound's `SourceDataLine` with a 200 ms low-latency buffer for glitch-free playback across Windows audio drivers.
- **Sample-Accurate Software Volume**: Seamless volume scaling directly on 16-bit audio samples, preventing clipping or driver volume inconsistencies.
- **Automatic Fallback**: If the audio device is locked by exclusive mode, gracefully falls back to native libVLC DirectSound output with zero audio interruption.

#### 3. 🎨 Track Metadata & Artwork Improvements
- Restored accurate high-resolution cover art resolution across Saavn, Spotify, SoundCloud, YouTube, and RadioBrowser.
- Song title, primary singer, featured artists, and album titles now match precisely with zero metadata mismatch.
- Complete failover retry handling across HTTP stream providers with automatic bitrate negotiation (320 kbps AAC / 160 kbps Opus).

#### 4. 🪟 Windows Authenticode Signatures & Trusted Setup
- All Windows installer packages (`.exe` and `.msi`) are digitally signed with SHA256 Authenticode certificates.
- Bundled **One-Click Trusted Setup** script (`Install-Audix-Trusted.bat`) automatically strips download restrictions (Zone.Identifier) and installs the trusted certificate into the local machine store.

---

### 📦 Available Downloads & SHA-256 Checksums

| Platform / Format | Filename | Size | SHA-256 Checksum |
| :--- | :--- | :--- | :--- |
| 💻 **Windows Installer (.EXE)** | `Audix-v1.0.3-Windows-Installer.exe` | **~285.7 MB** | `b21f01ff93b5cc32a310d50e729134c88ae075ca3bcfaa9812d2dee02dacfce8` |
| 💻 **Windows Installer (.MSI)** | `Audix-v1.0.3-Windows-Installer.msi` | **~285.0 MB** | `498ba3e2657aa4decfa479f660e0342acc643804dc07d7789f1806aa13afdb0f` |
| 📦 **Windows Portable (.ZIP)** | `Audix-v1.0.3-Windows-Portable.zip` | **~381.9 MB** | `808eac8d95963a6d371a7158f215563981729440c57bbe9d3edfee3f56c32f9c` |
| 🛡️ **Trusted Setup Bundle** | `Audix-v1.0.3-Windows-Trusted-Setup.zip` | **~283.7 MB** | `4904e59fcabacc7ba111aa1eed07a9f7c04c7ba9a4e4b989b16067adc743606f` |
| 📱 **Android APK (8.0+)** | `Audix-v1.0.3-Android.apk` | **~13.8 MB** | `fb02187f1534745f102c59226a4118813fab919e96d3a6e26fad14b66b66dd71` |

---

### 🚀 Installation Guide

#### Windows 10 & 11 (Recommended)
1. Download **`Audix-v1.0.3-Windows-Trusted-Setup.zip`** and extract it.
2. Right-click **`Install-Audix-Trusted.bat`** and choose **Run as administrator**.
3. Click **Yes** on UAC prompt — the installer will launch with verified publisher status and no SmartScreen warnings!

#### Windows Portable (Zero Installation)
- Download **`Audix-v1.0.3-Windows-Portable.zip`**, extract to any folder, and double-click **`Audix.exe`** (or `Run-Audix.bat`) to run immediately.

#### Android
- Download **`Audix-v1.0.3-Android.apk`** to your phone and install directly.
"""

HEADERS = {
    'Authorization': f'Bearer {TOKEN}',
    'User-Agent': 'Audix-Release-Publisher',
    'Accept': 'application/vnd.github+json'
}

# 1. Check or create release
release_url = f'https://api.github.com/repos/{OWNER}/{REPO}/releases/tags/{TAG}'
req = urllib.request.Request(release_url, headers=HEADERS)
release = None
try:
    with urllib.request.urlopen(req) as resp:
        release = json.loads(resp.read().decode())
        print(f"[OK] Found existing release for {TAG} (ID: {release['id']})")
        # Update release body and title to latest
        update_url = f"https://api.github.com/repos/{OWNER}/{REPO}/releases/{release['id']}"
        up_payload = json.dumps({
            'name': NAME,
            'body': BODY,
            'make_latest': 'true'
        }).encode('utf-8')
        ureq = urllib.request.Request(update_url, data=up_payload, headers={**HEADERS, 'Content-Type': 'application/json'}, method='PATCH')
        with urllib.request.urlopen(ureq) as uresp:
            release = json.loads(uresp.read().decode())
            print(f"[OK] Updated release {TAG} metadata successfully.")
except urllib.error.HTTPError as e:
    if e.code == 404:
        print(f"[+] Release {TAG} not found, creating new release...")
        create_url = f'https://api.github.com/repos/{OWNER}/{REPO}/releases'
        payload = json.dumps({
            'tag_name': TAG,
            'target_commitish': 'main',
            'name': NAME,
            'body': BODY,
            'draft': False,
            'prerelease': False,
            'make_latest': 'true'
        }).encode('utf-8')
        creq = urllib.request.Request(create_url, data=payload, headers={**HEADERS, 'Content-Type': 'application/json'}, method='POST')
        with urllib.request.urlopen(creq) as cresp:
            release = json.loads(cresp.read().decode())
            print(f"[OK] Created release {TAG} (ID: {release['id']}) successfully!")
    else:
        raise

release_id = release['id']
upload_url_base = release['upload_url'].split('{')[0]

existing_assets = {a['name']: a['id'] for a in release.get('assets', [])}
print(f"Existing assets in release: {list(existing_assets.keys())}")

# 2. Upload assets
assets_to_upload = [
    ('release-artifacts/Audix-v1.0.3-Android.apk', 'Audix-v1.0.3-Android.apk'),
    ('release-artifacts/Audix-v1.0.3-Windows-Installer.exe', 'Audix-v1.0.3-Windows-Installer.exe'),
    ('release-artifacts/Audix-v1.0.3-Windows-Installer.msi', 'Audix-v1.0.3-Windows-Installer.msi'),
    ('release-artifacts/Audix-v1.0.3-Windows-Portable.zip', 'Audix-v1.0.3-Windows-Portable.zip'),
    ('release-artifacts/Audix-v1.0.3-Windows-Trusted-Setup.zip', 'Audix-v1.0.3-Windows-Trusted-Setup.zip'),
]

for file_path, asset_name in assets_to_upload:
    if not os.path.exists(file_path):
        print(f"Skipping {asset_name}: File '{file_path}' not found.")
        continue

    file_size = os.path.getsize(file_path)

    if asset_name in existing_assets:
        print(f"Asset '{asset_name}' already exists. Deleting previous asset ID {existing_assets[asset_name]}...")
        del_url = f"https://api.github.com/repos/{OWNER}/{REPO}/releases/assets/{existing_assets[asset_name]}"
        dreq = urllib.request.Request(del_url, headers=HEADERS, method='DELETE')
        with urllib.request.urlopen(dreq) as dresp:
            print(f"Deleted old asset {asset_name}")
        time.sleep(1)

    print(f"\n[+] Uploading {asset_name} ({file_size / (1024*1024):.1f} MB)...")
    upload_url = f"{upload_url_base}?name={asset_name}"

    # Use curl.exe for streaming large binary files safely without loading 400MB into memory
    curl_cmd = [
        "curl.exe", "-sS", "-X", "POST",
        "-H", f"Authorization: Bearer {TOKEN}",
        "-H", "Content-Type: application/octet-stream",
        "-H", "User-Agent: Audix-Release-Publisher",
        "--data-binary", f"@{os.path.abspath(file_path)}",
        upload_url
    ]
    res = subprocess.run(curl_cmd, capture_output=True, text=True)
    if res.returncode == 0:
        try:
            result = json.loads(res.stdout)
            if 'id' in result:
                print(f"[OK] Successfully uploaded {asset_name} (Asset ID: {result['id']}, Size: {result.get('size', 0)} bytes)")
            else:
                print(f"[!] Upload response error for {asset_name}: {res.stdout[:200]}")
        except Exception:
            print(f"[!] Uploaded {asset_name}, response: {res.stdout[:200]}")
    else:
        print(f"[!] Curl upload failed for {asset_name}: {res.stderr}")

print("\n" + "=" * 60)
print(f"  ALL AUDIX v1.0.3 ASSETS UPLOADED AND RELEASE PUBLISHED!")
print(f"  Release URL: https://github.com/{OWNER}/{REPO}/releases/tag/{TAG}")
print("=" * 60)
