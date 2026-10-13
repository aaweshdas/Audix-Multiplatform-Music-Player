# Audix Desktop - Build, Toolchain & Automation Scripts

This directory contains standardized automation scripts for compiling, packaging, bundling, and testing **Audix Desktop**.

---

## Toolchain Scripts Overview

| Script | Purpose | Command |
|---|---|---|
| [`compile_desktop_app.py`](./compile_desktop_app.py) | Compiles Kotlin/Compose Multiplatform desktop sources using embedded Kotlin compiler & Compose compiler plugin. | `python scripts/compile_desktop_app.py` |
| [`inject_classes_and_assets.py`](./inject_classes_and_assets.py) | Updates runtime JARs, bundles high-res images/icons, packages all extensions into classpath resources, and updates the portable distribution zip. | `python scripts/inject_classes_and_assets.py` |
| [`compile_and_package_extensions.py`](./compile_and_package_extensions.py) | Compiles and packages all 10 music and companion extension JARs, writing manifests and distributing to `%APPDATA%\Echo\extensions`. | `python scripts/compile_and_package_extensions.py` |
| [`bundle_portable_vlc.py`](./bundle_portable_vlc.py) | Bundles native LibVLC runtime libraries and Windows launcher scripts into the release zip (`Audix-v1.0.0-Windows-Portable.zip`). | `python scripts/bundle_portable_vlc.py` |
| [`launch_and_verify.py`](./launch_and_verify.py) | Terminates lingering instances, launches `Audix.exe`, and verifies process health and startup status. | `python scripts/launch_and_verify.py` |

---

## Development & Release Workflow

### 1. Rebuild Application & Update Distribution
To apply code changes to the portable distribution and development environment:
```powershell
python scripts/compile_desktop_app.py
python scripts/inject_classes_and_assets.py
```

### 2. Update Extension Bundles
To recompile or package extensions after making modifications to extension sources:
```powershell
python scripts/compile_and_package_extensions.py
python scripts/inject_classes_and_assets.py
```

### 3. Verify Live App Execution
To start the portable executable and verify that there are no runtime crashes:
```powershell
python scripts/launch_and_verify.py
```
