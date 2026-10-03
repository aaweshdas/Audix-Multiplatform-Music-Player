@echo off
setlocal enabledelayedexpansion

set "SCRIPT_DIR=%~dp0"
set "BASE_DIR=%SCRIPT_DIR%desktopApp\build\compose\binaries\main\app"
set "FLAVOR=audix"

:: Parse arguments
:parse_args
if "%~1"=="" goto after_args
set "ARG=%~1"
if /i "%ARG:~0,9%"=="--flavor=" (
    set "FLAVOR=%ARG:~9%"
) else if /i "%ARG%"=="--flavor" (
    if not "%~2"=="" (
        set "FLAVOR=%~2"
        shift
    )
)
shift
goto parse_args
:after_args

:: Validate flavor
if /i not "%FLAVOR%"=="audix" if /i not "%FLAVOR%"=="echo" (
    echo [Run] Warning: Unknown flavor "%FLAVOR%". Falling back to "audix".
    set "FLAVOR=audix"
)

echo [Run] Starting application with flavor: %FLAVOR%

:: Path security checks
if not exist "%SCRIPT_DIR%gradlew.bat" (
    echo [Run] Security check failed: gradlew.bat not found in "%SCRIPT_DIR%".
    exit /b 1
)

:: Flavor-based executable resolution
if /i "%FLAVOR%"=="echo" (
    set "PRIMARY_EXE=%BASE_DIR%\Echo\Echo.exe"
    set "PRIMARY_DIR=%BASE_DIR%\Echo"
    set "SECONDARY_EXE=%BASE_DIR%\Audix\Audix.exe"
    set "SECONDARY_DIR=%BASE_DIR%\Audix"
) else (
    set "PRIMARY_EXE=%BASE_DIR%\Audix\Audix.exe"
    set "PRIMARY_DIR=%BASE_DIR%\Audix"
    set "SECONDARY_EXE=%BASE_DIR%\Echo\Echo.exe"
    set "SECONDARY_DIR=%BASE_DIR%\Echo"
)

if exist "%PRIMARY_EXE%" (
    echo [Run] Launching primary binary: %PRIMARY_EXE%
    cd /d "%PRIMARY_DIR%"
    start "" "%PRIMARY_EXE%"
    exit /b 0
)

if exist "%SECONDARY_EXE%" (
    echo [Run] Launching secondary binary: %SECONDARY_EXE%
    cd /d "%SECONDARY_DIR%"
    start "" "%SECONDARY_EXE%"
    exit /b 0
)

if exist "%BASE_DIR%\SpotHub\SpotHub.exe" (
    echo [Run] Launching fallback binary: %BASE_DIR%\SpotHub\SpotHub.exe
    cd /d "%BASE_DIR%\SpotHub"
    start "" "SpotHub.exe"
    exit /b 0
)

echo [Run] No pre-packaged binary found. Running via Gradle...
cd /d "%SCRIPT_DIR%"
call .\gradlew.bat :desktopApp:run
exit /b %ERRORLEVEL%
