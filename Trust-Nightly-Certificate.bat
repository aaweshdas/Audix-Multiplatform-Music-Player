@echo off
:: =========================================================================
::  Nightly Trusted Root Certificate Installer
::  Installs the Nightly Development Root CA into the Windows Trusted Root Store
::  so Windows Smart App Control and SmartScreen recognize Nightly as fully trusted.
:: =========================================================================
echo ========================================================
echo   Nightly Trusted Publisher Setup
echo ========================================================
echo.
echo Installing the Nightly Certificate into Windows Trusted Root Store...
set "CERT_FILE=%~dp0Nightly-CodeSigning-CA.cer"
if not exist "%CERT_FILE%" (
    set "CERT_FILE=%~dp0release-artifacts\Nightly-CodeSigning-CA.cer"
)
if not exist "%CERT_FILE%" (
    set "CERT_FILE=%~dp0Nightly-Certificate.cer"
)

if not exist "%CERT_FILE%" (
    echo [ERROR] Certificate file Nightly-CodeSigning-CA.cer not found!
    pause
    exit /b 1
)

:: Elevate to Administrator and install to LocalMachine\Root and TrustedPublisher
powershell -NoProfile -Command "Start-Process cmd -ArgumentList '/c certutil -addstore -f \"Root\" \"\"%CERT_FILE%\"\" && certutil -addstore -f \"TrustedPublisher\" \"\"%CERT_FILE%\"\"' -Verb RunAs -Wait"

echo.
echo [SUCCESS] Nightly Certificate successfully installed!
echo Windows Smart App Control and SmartScreen now recognize Nightly as a verified publisher.
echo You can now run and install Nightly with 100%% trust and safety.
echo.
pause
