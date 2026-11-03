import os
from PIL import ImageGrab

artifact_dir = r'C:\Users\dasab\.gemini\antigravity\brain\b909a816-beee-46d1-91b6-bdd98f1af904'
screenshot_path = os.path.join(artifact_dir, 'nightly_live_active_window.png')

img = ImageGrab.grab()
img.save(screenshot_path)
print(f'Screenshot saved to {screenshot_path}')
