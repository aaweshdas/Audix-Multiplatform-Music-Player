@echo off
setlocal EnableDelayedExpansion
title Audix Desktop

set "SCRIPT_DIR=%~dp0"
set "PORTABLE_DIR=%SCRIPT_DIR%release-artifacts\Audix-Windows-Portable"
set "EXT_DIR=%APPDATA%\Echo\extensions"

:: 1. Terminate any previous stale processes
taskkill /F /IM Audix.exe >nul 2>&1

:: 2. Ensure extension bundles are synchronized to AppData
if not exist "%EXT_DIR%" mkdir "%EXT_DIR%"
if exist "%PORTABLE_DIR%\app\resources\extensions\*.jar" (
    copy /y "%PORTABLE_DIR%\app\resources\extensions\*.jar" "%EXT_DIR%\" >nul 2>&1
)

:: 3. Setup bundled VLC Runtime and Skiko DLLs in PATH
set "PATH=%PORTABLE_DIR%\runtime\vlc;%PORTABLE_DIR%\app;%PORTABLE_DIR%;!PATH!"
set "VLC_PLUGIN_PATH=%PORTABLE_DIR%\runtime\vlc\plugins"

:: 4. Launch Audix Desktop with G1GC & 1024MB Memory Pool
cd /d "%PORTABLE_DIR%"
start "" "%PORTABLE_DIR%\runtime\bin\javaw.exe" -Xms128m -Xmx1024m -XX:+UseG1GC -XX:MaxGCPauseMillis=20 "-Dcompose.application.resources.dir=%PORTABLE_DIR%\app\resources" "-Dskiko.library.path=%PORTABLE_DIR%\app" "-Dcompose.application.configure.swing.globals=true" -cp "app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar;app\*" dev.brahmkshatriya.echo.desktop.MainKt
exit /b 0
