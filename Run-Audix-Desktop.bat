@echo off
title Launch Audix Desktop
set "EXT_DIR=%APPDATA%\Echo\extensions"
if not exist "%EXT_DIR%" mkdir "%EXT_DIR%"
if not exist "%EXT_DIR%\saavn.jar" (
    if exist "%~dp0release-artifacts\Audix-Windows-Portable\app\resources\extensions\*.jar" (
        copy /y "%~dp0release-artifacts\Audix-Windows-Portable\app\resources\extensions\*.jar" "%EXT_DIR%\" >nul 2>&1
    )
)
cd /d "%~dp0release-artifacts\Audix-Windows-Portable"
start "" "runtime\bin\javaw.exe" -Xms128m -Xmx768m -XX:+UseG1GC -XX:MaxGCPauseMillis=20 "-Dcompose.application.resources.dir=%~dp0release-artifacts\Audix-Windows-Portable\app\resources" "-Dcompose.application.configure.swing.globals=true" "-Dskiko.library.path=%~dp0release-artifacts\Audix-Windows-Portable\app" -cp "app\*" dev.brahmkshatriya.echo.desktop.MainKt
exit
