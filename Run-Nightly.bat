@echo off
setlocal EnableDelayedExpansion
title Nightly Desktop

set "SCRIPT_DIR=%~dp0"
set "PORTABLE_DIR=%SCRIPT_DIR%release-artifacts\Audix-Windows-Portable"
set "EXT_DIR=%APPDATA%\Echo\extensions"

:: 1. Terminate any previous stale processes or zombie port holders
for /f "tokens=5" %%a in ('netstat -aon 2^>nul ^| findstr ":49876" ^| findstr "LISTENING"') do (
    taskkill /F /PID %%a >nul 2>&1
)
taskkill /F /IM Audix.exe >nul 2>&1
taskkill /F /IM Nightly.exe >nul 2>&1
if exist "%USERPROFILE%\.echo_nightly_data\session.token" (
    del /f /q "%USERPROFILE%\.echo_nightly_data\session.token" >nul 2>&1
)
if exist "%USERPROFILE%\.echo_audix_data\session.token" (
    del /f /q "%USERPROFILE%\.echo_audix_data\session.token" >nul 2>&1
)

:: 2. Ensure extension bundles are synchronized to AppData
if not exist "%EXT_DIR%" mkdir "%EXT_DIR%"
if exist "%PORTABLE_DIR%\app\resources\extensions\*.jar" (
    copy /y "%PORTABLE_DIR%\app\resources\extensions\*.jar" "%EXT_DIR%\" >nul 2>&1
)

:: 3. Setup bundled VLC Runtime and Skiko DLLs in PATH
set "PATH=%PORTABLE_DIR%\runtime\vlc;%PORTABLE_DIR%\app;%PORTABLE_DIR%;!PATH!"
set "VLC_PLUGIN_PATH=%PORTABLE_DIR%\runtime\vlc\plugins"

:: 4. Launch Nightly Desktop with Direct3D Hardware Acceleration & 1024MB Memory Pool
cd /d "%PORTABLE_DIR%"
if exist "%PORTABLE_DIR%\Nightly.exe" (
    start "" "%PORTABLE_DIR%\Nightly.exe"
) else if exist "%PORTABLE_DIR%\Audix.exe" (
    start "" "%PORTABLE_DIR%\Audix.exe"
) else (
    start "" "%PORTABLE_DIR%\runtime\bin\javaw.exe" -Xms128m -Xmx1024m -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:+ParallelRefProcEnabled -Dskiko.renderApi=DIRECT3D -Dsun.java2d.d3d=true -Dsun.java2d.noddraw=true -Dskiko.vsync.enabled=true "-Dcompose.application.resources.dir=%PORTABLE_DIR%\app\resources" "-Dskiko.library.path=%PORTABLE_DIR%\app" "-Dcompose.application.configure.swing.globals=true" -cp "app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar;app\*" dev.brahmkshatriya.echo.desktop.MainKt
)
exit /b 0
