@echo off
setlocal
call "%~dp0Run.bat" --flavor=audix %*
exit /b %ERRORLEVEL%
