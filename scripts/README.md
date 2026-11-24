# Nightly Desktop — Build, Packaging, Signing & Release Scripts

This directory contains standardized automation scripts for compiling, packaging, code-signing, verifying, and publishing **Nightly Desktop (v1.0.4)**.

---

## Core Toolchain Scripts

| Script | Purpose | Command |
| :--- | :--- | :--- |
| [`compile_desktop_app.py`](./compile_desktop_app.py) | Compiles Kotlin/Compose Multiplatform desktop sources using the embedded Kotlin 2.2.10 compiler and Compose compiler plugin. | `python scripts/compile_desktop_app.py` |
| [`inject_classes_and_assets.py`](./inject_classes_and_assets.py) | Injects compiled JVM bytecode, high-res UI assets, cinema catalogs, and all 10 extension JARs into all runtime targets and portable ZIP. | `python scripts/inject_classes_and_assets.py` |
| [`compile_and_package_extensions.py`](./compile_and_package_extensions.py) | Compiles and packages all 10 music and companion extension JARs and syncs them to `%APPDATA%\Echo\extensions`. | `python scripts/compile_and_package_extensions.py` |
| [`build_windows_installers.py`](./build_windows_installers.py) | Builds standalone Windows `.msi` and `.exe` installers via `jpackage` + WiX, signs binaries, and bundles `Nightly-v1.0.4-Windows-Trusted-Setup.zip` and `Nightly-v1.0.4-Windows-Portable.zip`. | `python scripts/build_windows_installers.py` |
| [`sign_all_release_binaries.py`](./sign_all_release_binaries.py) | Applies SHA-256 Authenticode signatures with RFC3161 timestamps to `.exe` and `.msi` binaries and verifies signatures. | `python scripts/sign_all_release_binaries.py` |
| [`publish_github_release.py`](./publish_github_release.py) | Publishes a tagged GitHub Release with live-computed SHA-256 checksums and uploads all Windows and Android release artifacts. | `python scripts/publish_github_release.py` |
| [`launch_and_verify.py`](./launch_and_verify.py) | Cleanly stops stale instances, launches `Nightly.exe`, and verifies active runtime health. | `python scripts/launch_and_verify.py` |

---

## Standard Build & Release Workflow

### 1. Recompile & Inject Changes
```powershell
python scripts/compile_desktop_app.py
python scripts/inject_classes_and_assets.py
```

### 2. Build & Sign Production Windows Installers
```powershell
python scripts/build_windows_installers.py
```

### 3. Verify Runtime Launch
```powershell
python scripts/launch_and_verify.py
```

### 4. Publish Release to GitHub
```powershell
python scripts/publish_github_release.py
```

Historical migration and one-off maintenance scripts are preserved under [`archive/`](./archive/).
