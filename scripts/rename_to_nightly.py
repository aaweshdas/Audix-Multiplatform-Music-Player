import os
import re

PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
os.chdir(PROJECT_ROOT)

print(f"Working in: {PROJECT_ROOT}")

# 1. Update common/src/commonMain/kotlin/dev/brahmkshatriya/echo/common/config/FlavorConfig.kt
flavor_file = os.path.join(PROJECT_ROOT, r"common\src\commonMain\kotlin\dev\brahmkshatriya\echo\common\config\FlavorConfig.kt")
if os.path.exists(flavor_file):
    with open(flavor_file, "r", encoding="utf-8") as f:
        content = f.read()
    content = content.replace('const val FLAVOR_NAME = "Audix"', 'const val FLAVOR_NAME = "Nightly"')
    content = content.replace('Echo / Audix', 'Echo / Nightly')
    with open(flavor_file, "w", encoding="utf-8") as f:
        f.write(content)
    print("[OK] Updated FlavorConfig.kt")

# 2. Update Android strings and build.gradle.kts
app_strings = os.path.join(PROJECT_ROOT, r"app\src\main\res\values\strings.xml")
if os.path.exists(app_strings):
    with open(app_strings, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace('<string name="app_name" translatable="false">Audix</string>', '<string name="app_name" translatable="false">Nightly</string>')
    c = c.replace('open in Audix:', 'open in Nightly:')
    c = c.replace('Audix on your home screen!', 'Nightly on your home screen!')
    with open(app_strings, "w", encoding="utf-8") as f:
        f.write(c)
    print("[OK] Updated app/src/main/res/values/strings.xml")

app_strings_bn = os.path.join(PROJECT_ROOT, r"app\src\main\res\values-bn\strings.xml")
if os.path.exists(app_strings_bn):
    with open(app_strings_bn, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace('<string name="app_name" translatable="false">Audix</string>', '<string name="app_name" translatable="false">Nightly</string>')
    with open(app_strings_bn, "w", encoding="utf-8") as f:
        f.write(c)
    print("[OK] Updated app/src/main/res/values-bn/strings.xml")

app_header = os.path.join(PROJECT_ROOT, r"app\src\main\res\layout\item_main_header.xml")
if os.path.exists(app_header):
    with open(app_header, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace('android:text="Audix"', 'android:text="Nightly"')
    with open(app_header, "w", encoding="utf-8") as f:
        f.write(c)
    print("[OK] Updated item_main_header.xml")

app_gradle = os.path.join(PROJECT_ROOT, r"app\build.gradle.kts")
if os.path.exists(app_gradle):
    with open(app_gradle, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace('resValue("string", "app_name", "Audix")', 'resValue("string", "app_name", "Nightly")')
    with open(app_gradle, "w", encoding="utf-8") as f:
        f.write(c)
    print("[OK] Updated app/build.gradle.kts")

# 3. Update desktopApp/build.gradle.kts
desktop_gradle = os.path.join(PROJECT_ROOT, r"desktopApp\build.gradle.kts")
if os.path.exists(desktop_gradle):
    with open(desktop_gradle, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace('packageName = "Audix"', 'packageName = "Nightly"')
    c = c.replace('description = "Audix - High-Fidelity Music Player"', 'description = "Nightly - High-Fidelity Music Player"')
    c = c.replace('vendor = "Audix"', 'vendor = "Nightly"')
    c = c.replace('copyright = "© 2026 Audix"', 'copyright = "© 2026 Nightly"')
    c = c.replace('menuGroup = "Audix"', 'menuGroup = "Nightly"')
    with open(desktop_gradle, "w", encoding="utf-8") as f:
        f.write(c)
    print("[OK] Updated desktopApp/build.gradle.kts")

# 4. Helper for text replacements in source files
def replace_in_file(path, replacements):
    if not os.path.exists(path):
        return
    with open(path, "r", encoding="utf-8") as f:
        content = f.read()
    modified = content
    for old, new in replacements:
        modified = modified.replace(old, new)
    if modified != content:
        with open(path, "w", encoding="utf-8") as f:
            f.write(modified)
        print(f"[OK] Replaced in {os.path.basename(path)}")

# 5. Main.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\Main.kt"),
    [
        ('"audix_desktop.log"', '"nightly_desktop.log"'),
        ('"audix_desktop.log.1"', '"nightly_desktop.log.1"'),
        ('"Audix Desktop initializing..."', '"Nightly Desktop initializing..."'),
        ('".echo_audix_data"', '".echo_nightly_data"'),
        ('log("Existing Audix instance', 'log("Existing Nightly instance'),
        ('"Audix Music Error"', '"Nightly Music Error"'),
        ('"Audix-IPC-Worker"', '"Nightly-IPC-Worker"'),
        ('name = "Audix-SingleInstanceListener"', 'name = "Nightly-SingleInstanceListener"'),
        ('tooltip = "Audix Music"', 'tooltip = "Nightly Music"'),
        ('Item("Show Audix"', 'Item("Show Nightly"'),
        ('shutting down Audix on window close', 'shutting down Nightly on window close'),
        ('title = "Audix v1.0.4-UNIFIED"', 'title = "Nightly v1.0.4-UNIFIED"'),
        ('"Audix/1.0', '"Nightly/1.0'),
    ]
)

# 6. HomeScreen.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\HomeScreen.kt"),
    [
        ('fallback: String = "Audix Artist"', 'fallback: String = "Nightly Artist"'),
        ('name.equals("Audix Artist", true)', 'name.equals("Nightly Artist", true) || name.equals("Audix Artist", true)'),
        ('"Audix Editorial"', '"Nightly Editorial"'),
        ('"Audix Desi Beats"', '"Nightly Desi Beats"'),
        ('"Audix Rave"', '"Nightly Rave"'),
        ('"Audix Artist"', '"Nightly Artist"'),
        ('contentDescription = "Audix Logo"', 'contentDescription = "Nightly Logo"'),
        ('Audix Brand Logo', 'Nightly Brand Logo'),
        ('Audix Official Brand Logo', 'Nightly Official Brand Logo'),
    ]
)

# 7. SearchAndOthers.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\SearchAndOthers.kt"),
    [
        ('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"'),
        ('fallback: String = "Audix Hi-Res Audio"', 'fallback: String = "Nightly Hi-Res Audio"'),
        ('name.equals("Audix Artist", true)', 'name.equals("Nightly Artist", true) || name.equals("Audix Artist", true)'),
        ('"Audix Artist"', '"Nightly Artist"'),
        ('User-Agent", "Audix/', 'User-Agent", "Nightly/'),
        ('AI_INTELLIGENCE("Audix Intelligence"', 'AI_INTELLIGENCE("Nightly Intelligence"'),
        ('// Audix Intelligence state', '// Nightly Intelligence state'),
        ('=== AUDIX DESKTOP DIAGNOSTICS ===', '=== NIGHTLY DESKTOP DIAGNOSTICS ==='),
        ('title = "Audix Intelligence & Gemini AI Engine"', 'title = "Nightly Intelligence & Gemini AI Engine"'),
        ('"Audix AI works 100% offline', '"Nightly AI works 100% offline'),
        ('exits the Audix application window', 'exits the Nightly application window'),
        ('Audix scans these local directories', 'Nightly scans these local directories'),
        ('"Audix Downloads Directory [Always Scanned]"', '"Nightly Downloads Directory [Always Scanned]"'),
        ('closing the Audix window keeps the application playing', 'closing the Nightly window keeps the application playing'),
        ('Audix loads external modular JAR plugins', 'Nightly loads external modular JAR plugins'),
        ('title = "Audix Desktop Workstation"', 'title = "Nightly Desktop Workstation"'),
        ('Text("Audix Native Edition"', 'Text("Nightly Native Edition"'),
        ('Text("Audix v1.0.4-UNIFIED', 'Text("Nightly v1.0.4-UNIFIED'),
    ]
)

# 8. MiniPlayer.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\player\MiniPlayer.kt"),
    [
        ('fallback: String = "Audix Hi-Res Audio"', 'fallback: String = "Nightly Hi-Res Audio"'),
        ('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"'),
        ('"Audix Artist"', '"Nightly Artist"'),
        ('"Audix Music"', '"Nightly Music"'),
        ('".echo_audix_data"', '".echo_nightly_data"'),
        ('"Music/Audix"', '"Music/Nightly"'),
        ('AUDIX PRO STUDIO & AUDIO MASTER HUB', 'NIGHTLY PRO STUDIO & AUDIO MASTER HUB'),
        ('Text("Back to Audix"', 'Text("Back to Nightly"'),
        ('"Audix Studio & Audio Master"', '"Nightly Studio & Audio Master"'),
        ('"AUDIX HI-FI"', '"NIGHTLY HI-FI"'),
        ('"Audix Studio Collection"', '"Nightly Studio Collection"'),
        ('"Audix Local Engine"', '"Nightly Local Engine"'),
        ('(Audix Ambient Edit)', '(Nightly Ambient Edit)'),
        ('"Audix Binaural"', '"Nightly Binaural"'),
        ('"Audix Hi-Res"', '"Nightly Hi-Res"'),
        ('personal Audix library', 'personal Nightly library'),
        ('Music/Audix', 'Music/Nightly'),
        ('on Audix Studio', 'on Nightly Studio'),
        ('(Audix Studio Mix)', '(Nightly Studio Mix)'),
        ('"Audix Curated"', '"Nightly Curated"'),
        ('Text("Quit Audix on Complete"', 'Text("Quit Nightly on Complete"'),
        ('"User-Agent", "Audix/', '"User-Agent", "Nightly/'),
        ('"Audix Studio Master Engine"', '"Nightly Studio Master Engine"'),
    ]
)

# 9. AiStudioScreen.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\AiStudioScreen.kt"),
    [
        ('AUDIX INTELLIGENCE HERO MASTHEAD', 'NIGHTLY INTELLIGENCE HERO MASTHEAD'),
        ('text = "Audix Intelligence Studio"', 'text = "Nightly Intelligence Studio"'),
        ('"Audix Artist"', '"Nightly Artist"'),
        ('text = "AUDIX AI DJ COMMENTARY"', 'text = "NIGHTLY AI DJ COMMENTARY"'),
    ]
)

# 10. AudixAiService.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ai\AudixAiService.kt"),
    [
        ('You are Audix AI DJ', 'You are Nightly AI DJ'),
        ('as if Audix DJ is introducing the track live', 'as if Nightly DJ is introducing the track live'),
        ('Next on Audix Studio Radio', 'Next on Nightly Studio Radio'),
        ('title = "Audix Signature Panorama"', 'title = "Nightly Signature Panorama"'),
        ('tuned into Audix Studio Master', 'tuned into Nightly Studio Master'),
    ]
)

# 11. AudixVoiceSearchService.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\voice\AudixVoiceSearchService.kt"),
    [
        ('AUDIX HIGH-FIDELITY VOICE SEARCH ENGINE', 'NIGHTLY HIGH-FIDELITY VOICE SEARCH ENGINE'),
        ('AI VOICE SEARCH • GROQ WHISPER V3', 'NIGHTLY VOICE SEARCH • GROQ WHISPER V3'),
        ('"----AudixVoiceBoundary"', '"----NightlyVoiceBoundary"'),
        ('"Audix-Desktop/1.0.3', '"Nightly-Desktop/1.0.3'),
        ('AUDIX FROSTED GLASS VOICE SEARCH MODAL', 'NIGHTLY FROSTED GLASS VOICE SEARCH MODAL'),
    ]
)

# 12. DesktopLibraryManager.kt & PlayerViewModel.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\library\DesktopLibraryManager.kt"),
    [
        ('"audix artist", "audix music", "audix hi-res audio"', '"nightly artist", "nightly music", "nightly hi-res audio"'),
        ('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"'),
    ]
)

replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\viewmodel\PlayerViewModel.kt"),
    [
        ('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"'),
    ]
)

# 13. EchoScreensaver.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screensaver\EchoScreensaver.kt"),
    [
        ('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"'),
        ('"Audix Artist"', '"Nightly Artist"'),
    ]
)

# 14. Core VlcAudioPlayer.kt & JarExtensionRepository.kt
replace_in_file(
    os.path.join(PROJECT_ROOT, r"core\src\desktopMain\kotlin\dev\brahmkshatriya\echo\core\platform\VlcAudioPlayer.kt"),
    [
        ('?: "Audix/1.0.0 (Windows; OpenJDK 21)"', '?: "Nightly/1.0.0 (Windows; OpenJDK 21)"'),
        ('"Audix/runtime/vlc"', '"Nightly/runtime/vlc"'),
        ('"Programs/Audix/runtime/vlc"', '"Programs/Nightly/runtime/vlc"'),
        ('C:\\\\Program Files\\\\Audix\\\\runtime\\\\vlc', 'C:\\\\Program Files\\\\Nightly\\\\runtime\\\\vlc'),
        ('C:\\\\Program Files (x86)\\\\Audix\\\\runtime\\\\vlc', 'C:\\\\Program Files (x86)\\\\Nightly\\\\runtime\\\\vlc'),
    ]
)

replace_in_file(
    os.path.join(PROJECT_ROOT, r"core\src\desktopMain\kotlin\dev\brahmkshatriya\echo\core\extensions\JarExtensionRepository.kt"),
    [
        ('c.setRequestProperty("User-Agent", "Audix/1.0 (Windows; Desktop)")', 'c.setRequestProperty("User-Agent", "Nightly/1.0 (Windows; Desktop)")'),
    ]
)

# 15. Extensions metadata & User-Agents
ext_dir = os.path.join(PROJECT_ROOT, "extensions")
for root, dirs, files in os.walk(ext_dir):
    for f in files:
        if f.endswith(".json") or f.endswith(".kt") or f.endswith(".gradle.kts"):
            fp = os.path.join(root, f)
            with open(fp, "r", encoding="utf-8") as file:
                txt = file.read()
            new_txt = txt.replace('"Audix"', '"Nightly"')
            new_txt = new_txt.replace('"Audix/1.0.0"', '"Nightly/1.0.0"')
            new_txt = new_txt.replace('"Audix/1.0.0 (Windows; OpenJDK 21)"', '"Nightly/1.0.0 (Windows; OpenJDK 21)"')
            new_txt = new_txt.replace('"Audix/1.0.0 (Audix Multiplatform Music Player)"', '"Nightly/1.0.0 (Nightly Multiplatform Music Player)"')
            new_txt = new_txt.replace('"audix music"', '"nightly music"')
            new_txt = new_txt.replace('"audix hi-res audio"', '"nightly hi-res audio"')
            new_txt = new_txt.replace('"Audix Hi-Res Audio"', '"Nightly Hi-Res Audio"')
            new_txt = new_txt.replace('"Extension-Author" to "Audix"', '"Extension-Author" to "Nightly"')
            if new_txt != txt:
                with open(fp, "w", encoding="utf-8") as file:
                    file.write(new_txt)
                print(f"[OK] Updated extension file: {os.path.relpath(fp, PROJECT_ROOT)}")

# 16. Update README.md
readme = os.path.join(PROJECT_ROOT, "README.md")
if os.path.exists(readme):
    with open(readme, "r", encoding="utf-8") as f:
        r = f.read()
    r = r.replace('# Audix — Multiplatform Music Player', '# Nightly — Multiplatform Music Player')
    r = r.replace('for Android and Desktop (Audix)', 'for Android and Desktop (Nightly)')
    r = r.replace('Audix-v1.0.1-Android.apk', 'Nightly-v1.0.4-Android.apk')
    r = r.replace('Audix-v1.0.1-Windows-Installer.exe', 'Nightly-v1.0.4-Windows-Installer.exe')
    r = r.replace('Audix-v1.0.1-Windows-Installer.msi', 'Nightly-v1.0.4-Windows-Installer.msi')
    r = r.replace('Audix-v1.0.1-Windows-Portable.zip', 'Nightly-v1.0.4-Windows-Portable.zip')
    r = r.replace('New to Audix?', 'New to Nightly?')
    r = r.replace('Add Extensions in Audix', 'Add Extensions in Nightly')
    r = r.replace('**Audix** is an extensible', '**Nightly** is an extensible')
    r = r.replace('Audix features a decoupled', 'Nightly features a decoupled')
    r = r.replace('client (**Audix**)', 'client (**Nightly**)')
    r = r.replace('Audix is designed as an offline player', 'Nightly is designed as an offline player')
    r = r.replace('Audix Workspace', 'Nightly Workspace')
    r = r.replace('App name: **Audix**', 'App name: **Nightly**')
    r = r.replace('Run-Audix.bat', 'Run-Nightly.bat')
    r = r.replace('Audix is free software', 'Nightly is free software')
    with open(readme, "w", encoding="utf-8") as f:
        f.write(r)
    print("[OK] Updated README.md")

# 17. Update Batch Launchers & create Run-Nightly.bat
run_nightly_content = """@echo off
setlocal EnableDelayedExpansion
title Nightly Desktop

set "SCRIPT_DIR=%~dp0"
set "PORTABLE_DIR=%SCRIPT_DIR%release-artifacts\\Audix-Windows-Portable"
set "EXT_DIR=%APPDATA%\\Echo\\extensions"

:: 1. Terminate any previous stale processes or zombie port holders
for /f "tokens=5" %%a in ('netstat -aon 2^>nul ^| findstr ":49876" ^| findstr "LISTENING"') do (
    taskkill /F /PID %%a >nul 2>&1
)
taskkill /F /IM Nightly.exe >nul 2>&1
taskkill /F /IM Audix.exe >nul 2>&1
if exist "%USERPROFILE%\\.echo_nightly_data\\session.token" (
    del /f /q "%USERPROFILE%\\.echo_nightly_data\\session.token" >nul 2>&1
)
if exist "%USERPROFILE%\\.echo_audix_data\\session.token" (
    del /f /q "%USERPROFILE%\\.echo_audix_data\\session.token" >nul 2>&1
)

:: 2. Ensure extension bundles are synchronized to AppData
if not exist "%EXT_DIR%" mkdir "%EXT_DIR%"
if exist "%PORTABLE_DIR%\\app\\resources\\extensions\\*.jar" (
    copy /y "%PORTABLE_DIR%\\app\\resources\\extensions\\*.jar" "%EXT_DIR%\\" >nul 2>&1
)

:: 3. Setup bundled VLC Runtime and Skiko DLLs in PATH
set "PATH=%PORTABLE_DIR%\\runtime\\vlc;%PORTABLE_DIR%\\app;%PORTABLE_DIR%;!PATH!"
set "VLC_PLUGIN_PATH=%PORTABLE_DIR%\\runtime\\vlc\\plugins"

:: 4. Launch Nightly Desktop with Direct3D Hardware Acceleration & 1024MB Memory Pool
cd /d "%PORTABLE_DIR%"
if exist "%PORTABLE_DIR%\\Nightly.exe" (
    start "" "%PORTABLE_DIR%\\Nightly.exe"
) else if exist "%PORTABLE_DIR%\\Audix.exe" (
    start "" "%PORTABLE_DIR%\\Audix.exe"
) else (
    start "" "%PORTABLE_DIR%\\runtime\\bin\\javaw.exe" -Xms128m -Xmx1024m -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:+ParallelRefProcEnabled -Dskiko.renderApi=DIRECT3D -Dsun.java2d.d3d=true -Dsun.java2d.noddraw=true -Dskiko.vsync.enabled=true "-Dcompose.application.resources.dir=%PORTABLE_DIR%\\app\\resources" "-Dskiko.library.path=%PORTABLE_DIR%\\app" "-Dcompose.application.configure.swing.globals=true" -cp "app\\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar;app\\*" dev.brahmkshatriya.echo.desktop.MainKt
)
exit /b 0
"""

with open(os.path.join(PROJECT_ROOT, "Run-Nightly-Desktop.bat"), "w", encoding="utf-8") as f:
    f.write(run_nightly_content)
with open(os.path.join(PROJECT_ROOT, "Run-Nightly.bat"), "w", encoding="utf-8") as f:
    f.write(run_nightly_content)
with open(os.path.join(PROJECT_ROOT, "Run.bat"), "w", encoding="utf-8") as f:
    f.write(run_nightly_content)
with open(os.path.join(PROJECT_ROOT, "Run-Audix-Desktop.bat"), "w", encoding="utf-8") as f:
    f.write(run_nightly_content)
with open(os.path.join(PROJECT_ROOT, "Run-Audix.bat"), "w", encoding="utf-8") as f:
    f.write(run_nightly_content)
print("[OK] Created and updated all batch launch scripts to Nightly")

# 18. Ensure Nightly.exe and Nightly.cfg exist alongside Audix.exe
portable_dir = os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable")
if os.path.exists(portable_dir):
    audix_exe = os.path.join(portable_dir, "Audix.exe")
    nightly_exe = os.path.join(portable_dir, "Nightly.exe")
    if os.path.exists(audix_exe) and not os.path.exists(nightly_exe):
        import shutil
        shutil.copy2(audix_exe, nightly_exe)
        print("[OK] Created Nightly.exe in portable directory")
    
    audix_cfg = os.path.join(portable_dir, r"app\Audix.cfg")
    nightly_cfg = os.path.join(portable_dir, r"app\Nightly.cfg")
    if os.path.exists(audix_cfg) and not os.path.exists(nightly_cfg):
        import shutil
        shutil.copy2(audix_cfg, nightly_cfg)
        print("[OK] Created Nightly.cfg in portable directory")

print("All renaming steps completed successfully!")
