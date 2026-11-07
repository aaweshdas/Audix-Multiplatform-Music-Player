import os
import sys
from PIL import Image, ImageDraw

def create_circular_mask(size):
    mask = Image.new('L', (size, size), 0)
    draw = ImageDraw.Draw(mask)
    draw.ellipse((0, 0, size, size), fill=255)
    return mask

def deploy_logo(source_image_path):
    print(f"[Deploy] Deploying logo from: {source_image_path}")
    if not os.path.exists(source_image_path):
        print(f"[Error] Source image does not exist: {source_image_path}")
        sys.exit(1)

    base_img = Image.open(source_image_path).convert('RGBA')
    # Ensure square 512x512
    img_512 = base_img.resize((512, 512), Image.Resampling.LANCZOS)

    # 1. Desktop Application Image Targets
    desktop_targets = [
        r"desktopApp\src\desktopMain\resources\images\audix_logo.png",
        r"desktopApp\src\desktopMain\resources\images\audix_logo_square.png",
        r"desktopApp\src\desktopMain\resources\images\nightly_logo.png",
        r"desktopApp\src\desktopMain\resources\images\nightly_logo_square.png",
        r"desktopApp\src\desktopMain\resources\images\spothub_logo.png",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\audix_logo.png",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\audix_logo_square.png",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\nightly_logo.png",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\nightly_logo_square.png",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\spothub_logo.png",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\audix_logo.png",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\audix_logo_square.png",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\nightly_logo.png",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\nightly_logo_square.png",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\spothub_logo.png",
        r"tools\assets\audix_logo.png",
        r"tools\assets\nightly_logo.png"
    ]

    for dt in desktop_targets:
        os.makedirs(os.path.dirname(dt), exist_ok=True)
        img_512.save(dt, format="PNG")
        print(f"  -> Updated: {dt}")

    # Generate multi-size Windows .ico files (16, 24, 32, 48, 64, 128, 256)
    ico_targets = [
        r"desktopApp\src\desktopMain\resources\images\audix_logo.ico",
        r"release-artifacts\Audix-Windows-Portable\Audix.ico",
        r"release-artifacts\Audix-Windows-Portable\app\resources\images\audix_logo.ico",
        r"desktopApp\build\compose\binaries\main\app\Audix\Audix.ico",
        r"desktopApp\build\compose\binaries\main\app\Audix\app\resources\images\audix_logo.ico"
    ]
    ico_sizes = [(16, 16), (24, 24), (32, 32), (48, 48), (64, 64), (128, 128), (256, 256)]
    for ico_path in ico_targets:
        os.makedirs(os.path.dirname(ico_path), exist_ok=True)
        img_512.save(ico_path, format="ICO", sizes=ico_sizes)
        print(f"  -> Updated Icon: {ico_path}")

    # 2. Android Application Targets
    android_playstore = [
        r"app\src\main\ic_launcher-playstore.png",
        r"app\src\nightly\ic_launcher-playstore.png",
        r"app\src\main\res\drawable\ic_audix_logo.png",
        r"app\src\main\res\drawable\ic_nightly_logo.png"
    ]
    for ap in android_playstore:
        os.makedirs(os.path.dirname(ap), exist_ok=True)
        img_512.save(ap, format="PNG")
        print(f"  -> Updated Android Playstore/Drawable: {ap}")

    # Android mipmap densities: mdpi=48, hdpi=72, xhdpi=96, xxhdpi=144, xxxhdpi=192
    densities = {
        "mipmap-mdpi": 48,
        "mipmap-hdpi": 72,
        "mipmap-xhdpi": 96,
        "mipmap-xxhdpi": 144,
        "mipmap-xxxhdpi": 192
    }

    flavor_res_dirs = [
        r"app\src\main\res",
        r"app\src\nightly\res"
    ]

    for res_dir in flavor_res_dirs:
        for folder, size in densities.items():
            dir_path = os.path.join(res_dir, folder)
            os.makedirs(dir_path, exist_ok=True)

            # Square/adaptive launcher
            resized = img_512.resize((size, size), Image.Resampling.LANCZOS)
            square_path = os.path.join(dir_path, "ic_launcher.webp")
            resized.save(square_path, format="WEBP")

            # Round launcher
            mask = create_circular_mask(size)
            round_img = Image.new('RGBA', (size, size), (0, 0, 0, 0))
            round_img.paste(resized, (0, 0), mask)
            round_path = os.path.join(dir_path, "ic_launcher_round.webp")
            round_img.save(round_path, format="WEBP")

            print(f"  -> Updated Android {folder} ({size}x{size}): {square_path} & {round_path}")

    print("\n[SUCCESS] Logo successfully deployed across all Android and Desktop targets!")

if __name__ == "__main__":
    if len(sys.argv) > 1:
        deploy_logo(sys.argv[1])
    else:
        print("Usage: python scripts/deploy_app_logo.py <path_to_source_image>")
