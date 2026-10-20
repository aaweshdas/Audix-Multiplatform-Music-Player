@echo off
title Launch Audix Desktop
set "EXT_DIR=%APPDATA%\Echo\extensions"
if not exist "%EXT_DIR%" mkdir "%EXT_DIR%"
if exist "%~dp0release-artifacts\Audix-Windows-Portable\app\resources\extensions\*.jar" (
    copy /y "%~dp0release-artifacts\Audix-Windows-Portable\app\resources\extensions\*.jar" "%EXT_DIR%\" >nul 2>&1
)
if exist "%~dp0release-artifacts\Audix-Windows-Portable\runtime\vlc\libvlc.dll" (
    set "PATH=%~dp0release-artifacts\Audix-Windows-Portable\runtime\vlc;%PATH%"
    set "VLC_PLUGIN_PATH=%~dp0release-artifacts\Audix-Windows-Portable\runtime\vlc\plugins"
)
cd /d "%~dp0release-artifacts\Audix-Windows-Portable"
start "" "runtime\bin\javaw.exe" -Xms128m -Xmx768m -XX:+UseG1GC -XX:MaxGCPauseMillis=20 "-Dcompose.application.resources.dir=%~dp0release-artifacts\Audix-Windows-Portable\app\resources" "-Dcompose.application.configure.swing.globals=true" "-Dskiko.library.path=%~dp0release-artifacts\Audix-Windows-Portable\app" -cp "app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar;app\*" dev.brahmkshatriya.echo.desktop.MainKt
exit
