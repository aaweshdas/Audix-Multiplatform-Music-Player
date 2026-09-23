@echo off
setlocal
set "BASE_DIR=%~dp0desktopApp\build\compose\binaries\main\app"

if exist "%BASE_DIR%\Audix\Audix.exe" (
    cd /d "%BASE_DIR%\Audix"
    start "" "Audix.exe"
    exit /b 0
)

if exist "%BASE_DIR%\SpotHub\SpotHub.exe" (
    cd /d "%BASE_DIR%\SpotHub"
    start "" "SpotHub.exe"
    exit /b 0
)

if exist "%BASE_DIR%\Echo\Echo.exe" (
    cd /d "%BASE_DIR%\Echo"
    start "" "Echo.exe"
    exit /b 0
)

cd /d "%~dp0"
call .\gradlew.bat :desktopApp:run
exit /b 0
