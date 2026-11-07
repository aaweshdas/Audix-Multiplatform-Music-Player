import os
import math
import numpy as np
from PIL import Image, ImageDraw, ImageFilter

brain_dir = r"C:\Users\dasab\.gemini\antigravity\brain\9874cfda-efb5-4cf8-ab09-1bfb67f1f8ad"

def render_logo_4_cosmic_vinyl():
    size = 1024
    img = Image.new("RGBA", (size, size), (10, 11, 16, 255))
    draw = ImageDraw.Draw(img)

    # 1. Subtle radial ambient background glow (deep crimson & sapphire)
    center = size // 2
    glow_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    glow_draw = ImageDraw.Draw(glow_layer)
    for r in range(480, 0, -8):
        alpha = int(35 * (1.0 - (r / 480.0)))
        glow_draw.ellipse((center - r, center - r, center + r, center + r), fill=(225, 29, 72, alpha))
    for r in range(320, 0, -6):
        alpha = int(45 * (1.0 - (r / 320.0)))
        glow_draw.ellipse((center - r - 60, center - r - 60, center + r - 60, center + r - 60), fill=(99, 102, 241, alpha))
    glow_layer = glow_layer.filter(ImageFilter.GaussianBlur(30))
    img.alpha_composite(glow_layer)

    # 2. Vinyl disc body (dark titanium brushed metal)
    outer_radius = 420
    disc_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    disc_draw = ImageDraw.Draw(disc_layer)
    disc_draw.ellipse(
        (center - outer_radius, center - outer_radius, center + outer_radius, center + outer_radius),
        fill=(18, 20, 28, 250),
        outline=(225, 29, 72, 160),
        width=4
    )

    # Micro concentric vinyl grooves
    for r in range(160, 410, 4):
        lum = int(24 + 16 * math.sin(r * 0.4))
        disc_draw.ellipse((center - r, center - r, center + r, center + r), outline=(lum, lum + 4, lum + 10, 90), width=1)

    # 3. Anisotropic light reflection sheen across vinyl
    sheen = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    sheen_draw = ImageDraw.Draw(sheen)
    # Bow-tie / hourglass highlight reflections
    for angle in [-40, 50, 140, 230]:
        rad = math.radians(angle)
        for offset in range(-15, 16, 2):
            o_rad = rad + math.radians(offset)
            x2 = center + int(outer_radius * math.cos(o_rad))
            y2 = center + int(outer_radius * math.sin(o_rad))
            alpha = int(40 * (1.0 - abs(offset) / 16.0))
            sheen_draw.line((center, center, x2, y2), fill=(255, 255, 255, alpha), width=3)
    sheen = sheen.filter(ImageFilter.GaussianBlur(16))
    disc_layer.alpha_composite(sheen)

    # 4. Circular Neon Equalizer Pulse Ring
    eq_ring = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    eq_draw = ImageDraw.Draw(eq_ring)
    eq_radius = 250
    num_bars = 72
    for i in range(num_bars):
        theta = (2 * math.pi / num_bars) * i
        # Music frequency wave envelope
        wave = math.sin(i * 0.35) * math.cos(i * 0.2) + math.sin(i * 0.8) * 0.5
        bar_len = int(20 + 35 * abs(wave))
        r1 = eq_radius - bar_len // 2
        r2 = eq_radius + bar_len // 2
        x1 = center + int(r1 * math.cos(theta))
        y1 = center + int(r1 * math.sin(theta))
        x2 = center + int(r2 * math.cos(theta))
        y2 = center + int(r2 * math.sin(theta))
        # Gradient color: ruby crimson to electric cyan
        ratio = (i / num_bars)
        red = int(225 * (1 - ratio) + 56 * ratio)
        green = int(29 * (1 - ratio) + 189 * ratio)
        blue = int(72 * (1 - ratio) + 248 * ratio)
        eq_draw.line((x1, y1, x2, y2), fill=(red, green, blue, 240), width=4)

    # Glow for equalizer ring
    eq_glow = eq_ring.filter(ImageFilter.GaussianBlur(12))
    disc_layer.alpha_composite(eq_glow)
    disc_layer.alpha_composite(eq_ring)

    # 5. Center spindle label: Liquid glass core with Audix branding
    core_r = 110
    core_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    core_draw = ImageDraw.Draw(core_layer)
    core_draw.ellipse(
        (center - core_r, center - core_r, center + core_r, center + core_r),
        fill=(12, 14, 22, 240),
        outline=(244, 63, 94, 220),
        width=3
    )

    # Spindle hole
    hole_r = 22
    core_draw.ellipse(
        (center - hole_r, center - hole_r, center + hole_r, center + hole_r),
        fill=(5, 6, 9, 255),
        outline=(160, 160, 180, 180),
        width=2
    )

    # Play triangle icon inside core
    tri_r = 45
    pts = [
        (center - 15, center - 25),
        (center - 15, center + 25),
        (center + 20, center)
    ]
    core_draw.polygon(pts, fill=(244, 63, 94, 240))

    disc_layer.alpha_composite(core_layer)
    img.alpha_composite(disc_layer)

    # Rounded squircle border
    mask = Image.new("L", (size, size), 0)
    mask_draw = ImageDraw.Draw(mask)
    mask_draw.rounded_rectangle((32, 32, size - 32, size - 32), radius=220, fill=255)
    
    final_img = Image.new("RGB", (size, size), (7, 8, 12))
    final_img.paste(img, (0, 0), mask)

    # Glass border stroke
    stroke_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    stroke_draw = ImageDraw.Draw(stroke_layer)
    stroke_draw.rounded_rectangle((32, 32, size - 32, size - 32), radius=220, outline=(255, 255, 255, 60), width=4)
    stroke_draw.rounded_rectangle((36, 36, size - 36, size - 36), radius=216, outline=(225, 29, 72, 120), width=2)
    final_img.paste(stroke_layer, (0, 0), stroke_layer)

    out_path = os.path.join(brain_dir, "audix_logo_cosmic_vinyl_dial_1793784350000.jpg")
    final_img.save(out_path, quality=95)
    print(f"Rendered Logo 4: {out_path}")
    return out_path

def render_logo_5_aurora_horizon():
    size = 1024
    img = Image.new("RGBA", (size, size), (8, 9, 14, 255))
    center = size // 2

    # 1. Dark sky aurora gradient
    aurora_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    aurora_draw = ImageDraw.Draw(aurora_layer)
    for y in range(size):
        ratio = y / size
        r = int(12 * (1 - ratio) + 8 * ratio)
        g = int(24 * (1 - ratio) + 12 * ratio)
        b = int(48 * (1 - ratio) + 22 * ratio)
        aurora_draw.line((0, y, size, y), fill=(r, g, b, 255))

    # Aurora energy curtains (flowing sine curves with gaussian blur)
    curtain = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    c_draw = ImageDraw.Draw(curtain)
    for x in range(size):
        # Aurora wave formula
        y_top = int(450 + 120 * math.sin(x * 0.006) + 60 * math.cos(x * 0.014))
        y_bot = y_top + int(180 + 50 * math.sin(x * 0.009))
        c_draw.line((x, y_top - 100, x, y_bot), fill=(225, 29, 72, 60), width=3)
        c_draw.line((x, y_top - 40, x, y_top + 80), fill=(168, 85, 247, 90), width=2)
        c_draw.line((x, y_top, x, y_top + 40), fill=(56, 189, 248, 120), width=2)
    curtain = curtain.filter(ImageFilter.GaussianBlur(35))
    aurora_layer.alpha_composite(curtain)
    img.alpha_composite(aurora_layer)

    # 2. Sleek Liquid-Glass Horizon Wavefront
    wave_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    wave_draw = ImageDraw.Draw(wave_layer)
    
    # Draw multiple harmonic acoustic soundwaves
    harmonics = [
        {"amp": 110, "freq": 0.008, "phase": 0.0, "color": (244, 63, 94, 230), "width": 5},
        {"amp": 80, "freq": 0.012, "phase": 1.2, "color": (192, 132, 252, 210), "width": 4},
        {"amp": 60, "freq": 0.018, "phase": 2.4, "color": (56, 189, 248, 220), "width": 3},
        {"amp": 40, "freq": 0.025, "phase": 3.6, "color": (255, 255, 255, 240), "width": 2}
    ]

    for h in harmonics:
        pts = []
        for x in range(80, size - 80, 4):
            # Window function (Tukey/cosine window) so waves taper smoothly at edges
            w_norm = (x - 80) / (size - 160)
            window = math.sin(w_norm * math.pi) ** 1.5
            y = int(center + (h["amp"] * math.sin(x * h["freq"] + h["phase"])) * window)
            pts.append((x, y))
        for p1, p2 in zip(pts[:-1], pts[1:]):
            wave_draw.line([p1, p2], fill=h["color"], width=h["width"])

    wave_glow = wave_layer.filter(ImageFilter.GaussianBlur(14))
    img.alpha_composite(wave_glow)
    img.alpha_composite(wave_layer)

    # 3. Translucent frosted glass squircle emblem in center
    glass_plate = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    gp_draw = ImageDraw.Draw(glass_plate)
    
    card_margin = 180
    gp_draw.rounded_rectangle(
        (card_margin, card_margin, size - card_margin, size - card_margin),
        radius=140,
        fill=(16, 20, 32, 140),
        outline=(255, 255, 255, 70),
        width=3
    )

    # Inner specular light gleam on glass
    gp_draw.rounded_rectangle(
        (card_margin + 6, card_margin + 6, size - card_margin - 6, size - card_margin - 6),
        radius=134,
        outline=(225, 29, 72, 90),
        width=2
    )

    # Center Audix emblem glyph inside the glass
    emblem_center_y = center
    glyph_pts = [
        (center, center - 80),
        (center + 60, center + 40),
        (center + 35, center + 40),
        (center + 18, center),
        (center - 18, center),
        (center - 35, center + 40),
        (center - 60, center + 40)
    ]
    gp_draw.polygon(glyph_pts, fill=(255, 255, 255, 230))
    # Horizontal sound bar inside 'A'
    gp_draw.line((center - 24, center + 12, center + 24, center + 12), fill=(225, 29, 72, 255), width=6)

    img.alpha_composite(glass_plate)

    # Rounded squircle app icon container
    mask = Image.new("L", (size, size), 0)
    mask_draw = ImageDraw.Draw(mask)
    mask_draw.rounded_rectangle((32, 32, size - 32, size - 32), radius=220, fill=255)

    final_img = Image.new("RGB", (size, size), (6, 7, 10))
    final_img.paste(img, (0, 0), mask)

    # Outer metallic & crimson rim
    stroke_layer = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    stroke_draw = ImageDraw.Draw(stroke_layer)
    stroke_draw.rounded_rectangle((32, 32, size - 32, size - 32), radius=220, outline=(255, 255, 255, 60), width=4)
    stroke_draw.rounded_rectangle((36, 36, size - 36, size - 36), radius=216, outline=(56, 189, 248, 110), width=2)
    final_img.paste(stroke_layer, (0, 0), stroke_layer)

    out_path = os.path.join(brain_dir, "audix_logo_aurora_soundwave_1793784360000.jpg")
    final_img.save(out_path, quality=95)
    print(f"Rendered Logo 5: {out_path}")
    return out_path

if __name__ == "__main__":
    render_logo_4_cosmic_vinyl()
    render_logo_5_aurora_horizon()
    print("Logos 4 and 5 generated successfully!")
