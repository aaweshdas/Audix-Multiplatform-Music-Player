import os
from PIL import ImageGrab

artifact_dir = r'C:\Users\dasab\.gemini\antigravity\brain\9874cfda-efb5-4cf8-ab09-1bfb67f1f8ad'
screenshot_path = os.path.join(artifact_dir, 'audix_live_active_window.png')

img = ImageGrab.grab()
img.save(screenshot_path)
print(f'Screenshot saved to {screenshot_path}')
