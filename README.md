<div align="center">

<img src="tools/assets/audix_logo.jpg" alt="Audix Logo" width="140" style="border-radius: 28px; box-shadow: 0 8px 24px rgba(0,0,0,0.5); margin-bottom: 16px;" />

# Audix — Multiplatform Music Player

![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin-Multiplatform-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Compose Multiplatform](https://img.shields.io/badge/Compose-Multiplatform-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Android](https://img.shields.io/badge/Android-SDK%2024%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Desktop](https://img.shields.io/badge/Desktop-Windows%20%7C%20macOS%20%7C%20Linux-0078D6?style=for-the-badge&logo=windows&logoColor=white)
![License](https://img.shields.io/badge/License-GPL%20v3-blue?style=for-the-badge)

<p align="center">
  <b>A modern, high-performance, extension-based music player built for Android and Desktop (Audix).</b><br>
  Powered by Kotlin Multiplatform, Compose Multiplatform, SQLDelight, and VLC audio playback.
</p>

</div>

---

## 📖 Overview

**Audix** is an extensible, privacy-conscious audio player. Rather than hardcoding fixed streaming services, Audix features a decoupled **Extension SPI Architecture** that dynamically loads audio sources, metadata providers, synchronized lyrics engines, and social integrations at runtime.

The desktop client (**Audix**) provides an immersive, desktop-grade interface featuring smooth animations, hardware-accelerated playback, dynamic lyrics sync, visualizers, system tray minimization, and media key support.

> [!NOTE]
> Audix is designed as an offline player and extension host. The application itself hosts zero content and does not condone piracy. Users configure their own extensions and manage their own local libraries.

---

## 🏗️ Architecture & Modules

The workspace is organized into four modular Kotlin Multiplatform (KMP) modules:

```
┌─────────────────────────────────────────────────────────────────┐
│                           Audix Workspace                       │
├─────────────────┬─────────────────┬──────────────┬──────────────┤
│      :app       │   :desktopApp   │    :core     │   :common    │
│  (Android App)  │(Compose Desktop)│(DB & Engine) │ (Domain SPI) │
└─────────────────┴─────────────────┴──────────────┴──────────────┘
```

| Module | Target | Description |
| :--- | :--- | :--- |
| [**:app**](file:///s:/All%20Code/Antigravity/echo-nightly/app) | Android (SDK 24–36) | Android application with Material 3 UI, background playback services, home widgets, and Media3 ExoPlayer. App name: **Audix**. |
| [**:desktopApp**](file:///s:/All%20Code/Antigravity/echo-nightly/desktopApp) | JVM / Desktop | Modern Compose Multiplatform desktop client (**Audix**). Implements Decompose navigation, Koin DI, VLC audio playback, and Windows tray/media keys. |
| [**:core**](file:///s:/All%20Code/Antigravity/echo-nightly/core) | Common & JVM | Shared business logic, SQLDelight database (`EchoDatabase`), VLCJ playback engine, and dynamic JAR extension loader. |
| [**:common**](file:///s:/All%20Code/Antigravity/echo-nightly/common) | Kotlin Multiplatform | Core domain models (`Track`, `Album`, `Artist`, `Playlist`), client interfaces, and Extension SPI. |

---

## 📂 Directory Layout

The workspace has been organized cleanly order-wise at the root:

```
echo-nightly/
├── .github/                         # GitHub Actions workflows & issue templates
├── .gitignore                       # Git ignore specifications
├── AI_POLICY.md                     # Project AI and contribution policies
├── LICENSE.md                       # GNU General Public License v3.0
├── README.md                        # Master project documentation
├── Run-Audix.bat                    # Primary Windows desktop launcher script
├── Run-Echo.bat                     # Fallback Windows desktop launcher script
│
├── app/                             # [Module] Android Application (Audix)
│   ├── src/main/                    # Android source code & resources
│   └── build.gradle.kts             # Android build configuration
│
├── common/                          # [Module] KMP Extension SPI & Domain Models
│   ├── src/commonMain/kotlin/       # Shared interfaces (AlbumClient, TrackClient, etc.)
│   └── build.gradle.kts             # Common multiplatform build script
│
├── core/                            # [Module] Platform Engine, DB & Extensions
│   ├── src/commonMain/sqldelight/   # SQLDelight database schemas (Downloads, Extensions, Users)
│   ├── src/desktopMain/kotlin/      # VLC player, JarExtensionRepository, LocalMusicExtension
│   └── build.gradle.kts             # Core build script
│
├── desktopApp/                      # [Module] Audix Compose Desktop Application
│   ├── src/desktopMain/kotlin/      # Compose UI, screens, viewmodels, desktop entry
│   └── build.gradle.kts             # Compose Multiplatform packaging & native distribution
│
├── gradle/                          # Gradle wrapper & dependency version catalog
│   ├── libs.versions.toml           # Unified version catalog
│   └── wrapper/                     # Gradle wrapper JAR and properties
│
├── scripts/                         # Developer & maintenance utilities
│   └── scratch_capture.ps1          # Diagnostic window capture utility
│
├── tools/                           # Development tools and reference assets
│   ├── assets/                      # Official branding & logo artwork (audix_logo.jpg)
│   ├── sample-extensions/           # Sample extension packages and manifests
│   │   ├── test_ext.zip             # Dalvik/DEX sample Android extension APK
│   │   └── saavn-manifest/          # Unpacked Saavn Music extension manifest
│   └── recovered-reference/         # Decompiled source code & class reference archives
│
├── build.gradle.kts                 # Root Gradle build script
├── settings.gradle.kts              # Root Gradle settings (module registry & repos)
├── gradle.properties                # JVM, Kotlin & build configuration flags
├── gradlew / gradlew.bat            # Gradle wrapper scripts
├── jitpack.yml                      # JitPack build configuration
└── local.properties                 # Local Android SDK path configuration
```

---

## 🧩 Extension Ecosystem

Audix features a modular plugin architecture where capabilities are added through standalone extension JARs loaded at runtime:

| Extension | Category | Capability |
| :--- | :--- | :--- |
| **YouTube Music** (`youtube.jar`) | Audio Streaming | Search, browse charts, stream audio streams with adaptive bitrates. |
| **JioSaavn** (`saavn.jar`) | Audio Streaming | High-bitrate Bollywood, regional, and international catalog streaming. |
| **SoundCloud** (`soundcloud.jar`) | Audio Streaming | User tracks, indie releases, and playlists. |
| **Radio Browser** (`radiobrowser.jar`) | Radio Stations | Global directory of thousands of live internet radio streams. |
| **LRCLIB** (`lrclib.jar`) | Synchronized Lyrics | Time-synced scrolling lyrics database. |
| **Musixmatch** (`musixmatch.jar`) | Lyrics Provider | Comprehensive lyrics search and rich text lyrics. |
| **Genius** (`genius.jar`) | Lyrics & Annotations | Song lyrics, background notes, and track annotations. |
| **Discord RPC** (`discordrpc.jar`) | Social Integration | Live Discord Rich Presence with track title, artist, and playback status. |
| **Last.fm** (`lastfm.jar`) | Scrobbling | Automatic playback scrobbling and listening history synchronization. |

Extensions are stored locally under:
- **Windows**: `%APPDATA%\Echo\extensions\`

---

## 🚀 Getting Started

### Prerequisites

- **JDK 21** or higher (Java 21 LTS recommended)
- **Android SDK** (API 34+ build-tools) for building the Android application
- **VLC Media Player** (64-bit) installed for desktop playback via `vlcj`

### Launch Desktop (Audix)

To quickly run the desktop application on Windows:
```cmd
.\Run-Audix.bat
```

Or via Gradle directly:
```powershell
.\gradlew.bat :desktopApp:run
```

### Package Desktop Executable / Installer

Build a standalone native Windows distribution for Audix (bundled with JRE):
```powershell
.\gradlew.bat :desktopApp:packageDistributionForCurrentOS
```
The output executable will be created in:
`desktopApp/build/compose/binaries/main/app/Audix/Audix.exe`

### Build Android APK

Build a debug or nightly APK for Audix:
```powershell
.\gradlew.bat :app:assembleNightly
```

---

## 🛠️ Diagnostics & Developer Scripts

- **Inspect Project Modules**:
  ```powershell
  .\gradlew.bat projects
  ```
- **Capture Window Diagnostics**:
  ```powershell
  powershell -ExecutionPolicy Bypass -File scripts\scratch_capture.ps1
  ```
- **Sample Extensions & Manifests**:
  Inspect sample extension manifests in `tools/sample-extensions/saavn-manifest/META-INF/MANIFEST.MF`.

---

## 📜 Community & Support

Join the official community for news, extension development guides, and nightly updates:
- **Discord**: [Join Official Server](https://discord.gg/J3WvbBUU8Z)

---

## ⚖️ License

Audix is free software licensed under the **GNU General Public License v3.0** (GPL-3.0). See [LICENSE.md](file:///s:/All%20Code/Antigravity/echo-nightly/LICENSE.md) for full details.
