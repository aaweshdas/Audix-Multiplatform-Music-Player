"""
Audix Desktop - Portable LibVLC Packaging Script
Ensures LibVLC native libraries and Windows launcher scripts are properly bundled into
the portable distribution ZIP (Audix-v1.0.0-Windows-Portable.zip).
"""

import os
import zipfile
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

zip_path = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-v1.0.0-Windows-Portable.zip')
vlc_dir = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\runtime\vlc')
bat_dir = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable')

if os.path.exists(zip_path) and os.path.exists(vlc_dir):
    print(f"Packing LibVLC and launcher scripts into {zip_path}...")
    with zipfile.ZipFile(zip_path, 'a', compression=zipfile.ZIP_DEFLATED) as zout:
        # Update Run-Audix.bat and Run-Audix-Debug.bat
        for b in ['Run-Audix.bat', 'Run-Audix-Debug.bat']:
            b_path = os.path.join(bat_dir, b)
            if os.path.exists(b_path):
                rel = f'Audix-Windows-Portable/{b}'
                zout.write(b_path, rel)
                print(f"Updated {rel} in ZIP")
                
        # Add VLC files
        for root, dirs, files in os.walk(vlc_dir):
            for f in files:
                full = os.path.join(root, f)
                rel_vlc = os.path.relpath(full, bat_dir).replace('\\', '/')
                arc_name = f'Audix-Windows-Portable/{rel_vlc}'
                zout.write(full, arc_name)
    print("Portable ZIP updated with bundled LibVLC successfully.")
else:
    print(f"Error: Either zip '{zip_path}' or VLC directory '{vlc_dir}' was not found.")
    sys.exit(1)
