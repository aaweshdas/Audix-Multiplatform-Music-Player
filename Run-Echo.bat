@echo off
setlocal
call "%~dp0Run.bat" --flavor=echo %*
exit /b %ERRORLEVEL%
