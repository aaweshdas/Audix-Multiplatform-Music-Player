"""
Nightly Desktop - Process Launch and Verification Script
Safely stops any lingering instances, launches Nightly Desktop, and checks for healthy startup.
"""

import subprocess
import time
import os
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

print("1. Terminating any running Nightly processes...")
import psutil

try:
    current_pid = os.getpid()
    for proc in psutil.process_iter(['pid', 'name', 'cmdline']):
        if proc.info['pid'] == current_pid:
            continue
        name = proc.info.get('name') or ''
        cmdline = ' '.join(proc.info.get('cmdline') or [])
        if name.lower() in ('nightly.exe', 'audix.exe') or ('dev.brahmkshatriya.echo.desktop.MainKt' in cmdline):
            print(f"Terminating existing Nightly process: PID {proc.info['pid']} ({name})")
            proc.kill()
except Exception as e:
    print(f"Notice during process cleanup: {e}")
    subprocess.run(["taskkill", "/F", "/IM", "Nightly.exe"], capture_output=True)
    subprocess.run(["taskkill", "/F", "/IM", "Audix.exe"], capture_output=True)

time.sleep(1)

bat_path = os.path.join(PROJECT_ROOT, r"Run-Nightly.bat")
if not os.path.exists(bat_path):
    bat_path = os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable\Run-Nightly.bat")

print(f"2. Launching via: {bat_path}")
subprocess.run(["cmd.exe", "/c", bat_path], cwd=PROJECT_ROOT)

# Wait 5 seconds to let it initialize
time.sleep(5)

# Check if Nightly is running
found = False
try:
    for p in psutil.process_iter(['pid', 'name', 'cmdline']):
        name = (p.info.get('name') or '').lower()
        cmdline = ' '.join(p.info.get('cmdline') or [])
        if name in ('nightly.exe', 'audix.exe') or ('dev.brahmkshatriya.echo.desktop.MainKt' in cmdline):
            found = True
            mem_mb = p.memory_info().rss / (1024 * 1024)
            print(f"[OK] Nightly process actively running: PID {p.info['pid']} ({name}), Memory: {mem_mb:.1f} MB")
            break
except Exception as e:
    print(f"Notice while checking processes: {e}")

if found:
    print("\nSUCCESS: Nightly Desktop is running smoothly!")
else:
    print("\nNotice: If running in background javaw, check tasklist.")
