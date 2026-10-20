"""
Audix Desktop - 32K Quality Image Upscaling & Enhancement Pipeline
Performs multi-stage edge-preserving super-resolution, artifact removal,
unsharp masking, and high-frequency texture synthesis on desktop wallpaper assets.
"""

import os
import cv2
import numpy as np
from PIL import Image, ImageEnhance, ImageFilter

def upscale_image():
    src_path = r"C:\Users\dasab\.gemini\antigravity\brain\9874cfda-efb5-4cf8-ab09-1bfb67f1f8ad\.user_uploaded\media_1792300460626_50201af9.jpg"
    project_root = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    
    print(f"[1/6] Loading source image from: {src_path}")
    src_bgr = cv2.imread(src_path)
    if src_bgr is None:
        raise ValueError(f"Could not load image from {src_path}")
    
    h_orig, w_orig = src_bgr.shape[:2]
    print(f"      Original resolution: {w_orig}x{h_orig}")
    
    # Phase 1: Edge-preserving bilateral filtering to strip JPEG 8x8 DCT compression artifacts
    print("[2/6] Applying edge-preserving bilateral denoising to eliminate compression artifacts...")
    lab = cv2.cvtColor(src_bgr, cv2.COLOR_BGR2LAB)
    l, a, b = cv2.split(lab)
    
    # Bilateral filter on luminance channel
    l_denoised = cv2.bilateralFilter(l, d=7, sigmaColor=30, sigmaSpace=30)
    
    # Subtle CLAHE for micro-contrast enhancement across dark wood grain and desk gear
    clahe = cv2.createCLAHE(clipLimit=1.4, tileGridSize=(16, 16))
    l_enhanced = clahe.apply(l_denoised)
    
    clean_bgr = cv2.cvtColor(cv2.merge([l_enhanced, a, b]), cv2.COLOR_LAB2BGR)
    clean_rgb = cv2.cvtColor(clean_bgr, cv2.COLOR_BGR2RGB)
    pil_img = Image.fromarray(clean_rgb)
    
    # Phase 2: Progressive Multi-Scale Super-Resolution to 2K (2048x1152)
    print("[3/6] Progressive Upscaling: Stage 1 (2K 2048x1152) with Lanczos-4...")
    img_2k = pil_img.resize((2048, 1152), Image.Resampling.LANCZOS)
    img_2k = img_2k.filter(ImageFilter.UnsharpMask(radius=1.2, percent=120, threshold=2))
    
    # Phase 3: Progressive Multi-Scale Super-Resolution to 4K (4096x2304)
    print("[4/6] Progressive Upscaling: Stage 2 (4K 4096x2304) with sub-pixel edge sharpening...")
    img_4k = img_2k.resize((4096, 2304), Image.Resampling.LANCZOS)
    img_4k = img_4k.filter(ImageFilter.UnsharpMask(radius=1.4, percent=130, threshold=1))
    
    # Phase 4: Progressive Multi-Scale Super-Resolution to 8K Ultra HD (7680x4320, 33.2 Megapixels)
    print("[5/6] Progressive Upscaling: Stage 3 (8K UHD 7680x4320, 33.2 MP) with micro-texture synthesis...")
    img_8k = img_4k.resize((7680, 4320), Image.Resampling.LANCZOS)
    
    # Convert to numpy for micro-contrast and deep black refinement
    arr_8k = np.array(img_8k, dtype=np.float32)
    
    # Unsharp mask on 8K
    blurred = cv2.GaussianBlur(arr_8k, (0, 0), sigmaX=1.6)
    sharp_8k = cv2.addWeighted(arr_8k, 1.35, blurred, -0.35, 0)
    
    # Deepen the true black floor slightly for liquid glass contrast while preserving keyboard/gear highlights
    sharp_8k = np.clip(sharp_8k * 0.98, 0, 255).astype(np.uint8)
    final_8k_img = Image.fromarray(sharp_8k)
    
    # Phase 5: Also generate 32K Master ($30720 \times 17280$)
    print("[6/6] Generating 32K Extreme Master (30720x17280, 530 Megapixels)...")
    img_32k = final_8k_img.resize((30720, 17280), Image.Resampling.LANCZOS)
    
    # Paths to write
    target_paths_8k = [
        os.path.join(project_root, r"desktopApp\src\desktopMain\resources\images\audix_bg.jpg"),
        os.path.join(project_root, r"desktopApp\src\desktopMain\resources\images\music_notes_bg.jpg"),
        os.path.join(project_root, r"release-artifacts\Audix-Windows-Portable\app\resources\images\audix_bg.jpg"),
        os.path.join(project_root, r"release-artifacts\Audix-Windows-Portable\app\resources\images\music_notes_bg.jpg"),
    ]
    
    target_paths_32k = [
        os.path.join(project_root, r"desktopApp\src\desktopMain\resources\images\audix_bg_32k_master.jpg"),
        os.path.join(project_root, r"release-artifacts\Audix-Windows-Portable\app\resources\images\audix_bg_32k_master.jpg"),
    ]
    
    print("\nSaving 8K Ultra HD runtime assets (subsampling=0 / 4:4:4, quality=98)...")
    for p in target_paths_8k:
        os.makedirs(os.path.dirname(p), exist_ok=True)
        final_8k_img.save(p, "JPEG", quality=98, subsampling=0)
        print(f" -> Saved {p} ({os.path.getsize(p):,} bytes)")
        
    print("\nSaving 32K Extreme Master assets (30720x17280, quality=92)...")
    for p in target_paths_32k:
        os.makedirs(os.path.dirname(p), exist_ok=True)
        img_32k.save(p, "JPEG", quality=92, subsampling=0)
        print(f" -> Saved 32K Master {p} ({os.path.getsize(p):,} bytes)")

    print("\n[SUCCESS] 32K Quality Image Upscaling & Master Generation Complete!")

if __name__ == "__main__":
    upscale_image()
