"""
Audix Desktop - Process Launch and Verification Script
Safely stops any lingering instances, launches Audix Desktop, and checks for healthy startup.
"""

import subprocess
import time
import os
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

print("1. Terminating any running Audix processes...")
# Stop Audix launcher and any java/javaw running Audix
import psutil

try:
    current_pid = os.getpid()
    for proc in psutil.process_iter(['pid', 'name', 'cmdline']):
        if proc.info['pid'] == current_pid:
            continue
        name = proc.info.get('name') or ''
        cmdline = ' '.join(proc.info.get('cmdline') or [])
        if name.lower() in ('audix.exe',) or ('dev.brahmkshatriya.echo.desktop.MainKt' in cmdline):
            print(f"Terminating existing Audix process: PID {proc.info['pid']} ({name})")
            proc.kill()
except Exception as e:
    print(f"Notice during process cleanup: {e}")
    # Fallback to taskkill if psutil is not available
    subprocess.run(["taskkill", "/F", "/IM", "Audix.exe"], capture_output=True)

time.sleep(1)

bat_path = os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable\Run-Audix.bat")
if not os.path.exists(bat_path):
    print(f"Error: Run-Audix.bat not found at {bat_path}")
    sys.exit(1)

print(f"2. Launching via: {bat_path}")
subprocess.run(["cmd.exe", "/c", bat_path], cwd=os.path.dirname(bat_path))

# Wait 4 seconds to let it initialize
time.sleep(4)

# Check if Audix is running
found = False
try:
    for p in psutil.process_iter(['pid', 'name']):
        try:
            name = (p.info.get('name') or '').lower()
            if name in ('javaw.exe', 'java.exe', 'audix.exe'):
                cmdline = ' '.join(p.cmdline() or [])
                if 'dev.brahmkshatriya.echo.desktop.MainKt' in cmdline or name == 'audix.exe':
                    mem_mb = p.memory_info().rss / (1024 * 1024)
                    print(f"SUCCESS: Audix is actively running (PID {p.info['pid']}, {name}, Memory: {mem_mb:.1f} MB)!")
                    found = True
                    break
        except (psutil.NoSuchProcess, psutil.AccessDenied):
            continue
except Exception as e:
    print(f"Error checking processes: {e}")

if not found:
    print("Warning: Audix process not detected after launch. Checking logs...")
    sys.exit(1)


