"""
Nightly Brand Asset Pipeline
Generates all brand assets (PNG, JPG, ICO, WEBP) from the master high-resolution renders
and deploys them across Desktop, Android, and Packaging targets.
"""

import os
import shutil
from PIL import Image, ImageDraw, ImageFilter
import numpy as np

PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BRAIN_DIR = r"C:\Users\dasab\.gemini\antigravity\brain\b909a816-beee-46d1-91b6-bdd98f1af904"

EMBLEM_SRC = os.path.join(BRAIN_DIR, "nightly_app_icon_emblem_1793742115931.jpg")
BRAND_SRC = os.path.join(BRAIN_DIR, "nightly_app_logo_1793742061187.jpg")

print("[1/6] Loading source artwork...")
if not os.path.exists(EMBLEM_SRC):
    raise FileNotFoundError(f"Source emblem not found at: {EMBLEM_SRC}")

emblem_img = Image.open(EMBLEM_SRC).convert("RGBA")
brand_img = Image.open(BRAND_SRC).convert("RGB")

# Crop emblem to square badge
cx, cy = 512, 511
half_size = 400
crop_box = (cx - half_size, cy - half_size, cx + half_size, cy + half_size)
cropped_emblem = emblem_img.crop(crop_box).resize((512, 512), Image.Resampling.LANCZOS)

# Create transparent squircle version
w, h = 512, 512
mask_scale = 4
mask_img = Image.new("L", (w * mask_scale, h * mask_scale), 0)
draw = ImageDraw.Draw(mask_img)

pad = 12 * mask_scale
radius = 115 * mask_scale
draw.rounded_rectangle([pad, pad, w * mask_scale - pad, h * mask_scale - pad], radius=radius, fill=255)
mask_down = mask_img.resize((w, h), Image.Resampling.LANCZOS)

transparent_emblem = cropped_emblem.copy()
transparent_emblem.putalpha(mask_down)

# Create circular version for Android round icons
circle_mask = Image.new("L", (w * mask_scale, h * mask_scale), 0)
circle_draw = ImageDraw.Draw(circle_mask)
circle_draw.ellipse([pad, pad, w * mask_scale - pad, h * mask_scale - pad], fill=255)
circle_mask_down = circle_mask.resize((w, h), Image.Resampling.LANCZOS)
round_emblem = cropped_emblem.copy()
round_emblem.putalpha(circle_mask_down)

print("[2/6] Deploying Desktop resources...")
desktop_img_dir = os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\resources\images")
desktop_icon_dir = os.path.join(PROJECT_ROOT, r"desktopApp\src\desktopMain\resources\icons")
os.makedirs(desktop_img_dir, exist_ok=True)
os.makedirs(desktop_icon_dir, exist_ok=True)

# 1. Desktop images
transparent_emblem.save(os.path.join(desktop_img_dir, "nightly_logo.png"), "PNG")
cropped_emblem.save(os.path.join(desktop_img_dir, "nightly_logo_square.png"), "PNG")

# Backward compat duplicates for desktop resources
transparent_emblem.save(os.path.join(desktop_img_dir, "audix_logo.png"), "PNG")
cropped_emblem.save(os.path.join(desktop_img_dir, "audix_logo_square.png"), "PNG")
transparent_emblem.save(os.path.join(desktop_img_dir, "spothub_logo.png"), "PNG")

# 2. Multi-resolution Windows ICO
ico_sizes = [(16, 16), (24, 24), (32, 32), (48, 48), (64, 64), (128, 128), (256, 256)]
nightly_ico_path = os.path.join(desktop_icon_dir, "nightly.ico")
audix_ico_path = os.path.join(desktop_icon_dir, "audix.ico")
spothub_ico_path = os.path.join(desktop_icon_dir, "spothub.ico")

transparent_emblem.save(nightly_ico_path, format="ICO", sizes=ico_sizes)
transparent_emblem.save(audix_ico_path, format="ICO", sizes=ico_sizes)
transparent_emblem.save(spothub_ico_path, format="ICO", sizes=ico_sizes)
print("   Saved Windows ICO files.")

print("[3/6] Deploying Android drawables and mipmaps...")
res_dir = os.path.join(PROJECT_ROOT, r"app\src\main\res")
drawable_dir = os.path.join(res_dir, "drawable")
os.makedirs(drawable_dir, exist_ok=True)

transparent_emblem.save(os.path.join(drawable_dir, "ic_nightly_logo.png"), "PNG")
transparent_emblem.save(os.path.join(drawable_dir, "ic_audix_logo.png"), "PNG")

# Mipmap densities
densities = {
    "mipmap-mdpi": 48,
    "mipmap-hdpi": 72,
    "mipmap-xhdpi": 96,
    "mipmap-xxhdpi": 144,
    "mipmap-xxxhdpi": 192,
}

for folder, size in densities.items():
    mdir = os.path.join(res_dir, folder)
    os.makedirs(mdir, exist_ok=True)
    # Square / standard launcher icon
    square_icon = cropped_emblem.resize((size, size), Image.Resampling.LANCZOS)
    square_icon.save(os.path.join(mdir, "ic_launcher.webp"), "WEBP", quality=95)
    # Round launcher icon
    circ_icon = round_emblem.resize((size, size), Image.Resampling.LANCZOS)
    circ_icon.save(os.path.join(mdir, "ic_launcher_round.webp"), "WEBP", quality=95)

print("   Updated Android launcher mipmaps.")

print("[4/6] Deploying official tool assets & documentation...")
tools_assets_dir = os.path.join(PROJECT_ROOT, r"tools\assets")
os.makedirs(tools_assets_dir, exist_ok=True)
brand_img.save(os.path.join(tools_assets_dir, "nightly_logo.jpg"), "JPEG", quality=95)
brand_img.save(os.path.join(tools_assets_dir, "audix_logo.jpg"), "JPEG", quality=95)
transparent_emblem.save(os.path.join(tools_assets_dir, "nightly_logo.png"), "PNG")

print("[5/6] Deploying to portable release staging directories...")
portable_res_dir = os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable\app\resources\images")
if os.path.exists(portable_res_dir):
    transparent_emblem.save(os.path.join(portable_res_dir, "nightly_logo.png"), "PNG")
    cropped_emblem.save(os.path.join(portable_res_dir, "nightly_logo_square.png"), "PNG")
    transparent_emblem.save(os.path.join(portable_res_dir, "audix_logo.png"), "PNG")
    cropped_emblem.save(os.path.join(portable_res_dir, "audix_logo_square.png"), "PNG")
    transparent_emblem.save(os.path.join(portable_res_dir, "spothub_logo.png"), "PNG")

compose_res_dir = os.path.join(PROJECT_ROOT, r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images")
if os.path.exists(compose_res_dir):
    transparent_emblem.save(os.path.join(compose_res_dir, "nightly_logo.png"), "PNG")
    cropped_emblem.save(os.path.join(compose_res_dir, "nightly_logo_square.png"), "PNG")
    transparent_emblem.save(os.path.join(compose_res_dir, "audix_logo.png"), "PNG")
    cropped_emblem.save(os.path.join(compose_res_dir, "audix_logo_square.png"), "PNG")
    transparent_emblem.save(os.path.join(compose_res_dir, "spothub_logo.png"), "PNG")

print("[6/6] Brand asset generation and deployment complete!")
