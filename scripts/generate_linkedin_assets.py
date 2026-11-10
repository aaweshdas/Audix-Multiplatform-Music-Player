import os
import shutil
from PIL import Image, ImageDraw, ImageFont, ImageFilter

base_dir = r"S:\All Code\Antigravity\echo-nightly\linkedin-showcase"
images_dir = os.path.join(base_dir, "images")
os.makedirs(images_dir, exist_ok=True)

brain_dir = r"C:\Users\dasab\.gemini\antigravity\brain\b909a816-beee-46d1-91b6-bdd98f1af904"
user_up_dir = os.path.join(brain_dir, ".user_uploaded")

# 1. 01_Nightly_Hero_Brand.png
logo_src = os.path.join(brain_dir, "nightly_app_logo_1793742061187.jpg")
logo_out = os.path.join(images_dir, "01_Nightly_Hero_Brand.png")
if os.path.exists(logo_src):
    with Image.open(logo_src) as img:
        img.save(logo_out, format="PNG", quality=100)
    print("Created 01_Nightly_Hero_Brand.png")

# 2. 02_Android_Mobile_Player.png
mobile_src = os.path.join(brain_dir, "phone_screen_updated.png")
mobile_out = os.path.join(images_dir, "02_Android_Mobile_Player.png")
if os.path.exists(mobile_src):
    shutil.copy2(mobile_src, mobile_out)
    print("Created 02_Android_Mobile_Player.png")

# 3. 03_Desktop_Player_Visualizer.png
desktop_src = os.path.join(user_up_dir, "media_1791816044789_27efbb28.jpg")
desktop_out = os.path.join(images_dir, "03_Desktop_Player_Visualizer.png")
if os.path.exists(desktop_src):
    with Image.open(desktop_src) as img:
        img.save(desktop_out, format="PNG", quality=100)
    print("Created 03_Desktop_Player_Visualizer.png")

# 4. 04_InApp_Cinema_Studio.png
cinema_src = os.path.join(user_up_dir, "media_1793515096338_733c01cf.jpg")
cinema_out = os.path.join(images_dir, "04_InApp_Cinema_Studio.png")
if os.path.exists(cinema_src):
    with Image.open(cinema_src) as img:
        img.save(cinema_out, format="PNG", quality=100)
    print("Created 04_InApp_Cinema_Studio.png")

# 5. 05_AI_Voice_Search_Modal.png
voice_src = os.path.join(user_up_dir, "media_1793736510187_3fe70c95.png")
voice_out = os.path.join(images_dir, "05_AI_Voice_Search_Modal.png")
if os.path.exists(voice_src):
    shutil.copy2(voice_src, voice_out)
    print("Created 05_AI_Voice_Search_Modal.png")

# 6. Generate 06_Architecture_Infographic.png (1200x675 standard 16:9 LinkedIn banner)
def generate_architecture_banner():
    width, height = 1200, 675
    img = Image.new("RGBA", (width, height), (13, 17, 23, 255))
    draw = ImageDraw.Draw(img)

    # Subtle glowing gradient background accents
    for r in range(180, 0, -5):
        alpha = int(35 * (1 - r / 180))
        draw.ellipse([width - 150 - r, 80 - r, width - 150 + r, 80 + r], fill=(138, 43, 226, alpha))
        draw.ellipse([100 - r, height - 100 - r, 100 + r, height - 100 + r], fill=(14, 165, 233, alpha))

    font_title = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 36)
    font_subtitle = ImageFont.truetype(r"C:\Windows\Fonts\segoeui.ttf", 17)
    font_box_header = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 19)
    font_body_bold = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 14)
    font_body = ImageFont.truetype(r"C:\Windows\Fonts\segoeui.ttf", 13)
    font_code = ImageFont.truetype(r"C:\Windows\Fonts\consola.ttf", 12)

    # Top Brand Header
    draw.text((45, 30), "NIGHTLY  //  SYSTEM ARCHITECTURE", fill=(240, 246, 252), font=font_title)
    draw.text((45, 78), "Cross-Platform Media Engine: Kotlin Multiplatform | Compose | VLCJ & ExoPlayer | AI Voice STT", fill=(148, 163, 184), font=font_subtitle)
    
    # Top badge
    draw.rounded_rectangle([width - 245, 35, width - 45, 75], radius=8, fill=(30, 41, 59), outline=(99, 102, 241), width=1)
    draw.text((width - 230, 45), "GITHUB OPEN SOURCE", fill=(165, 180, 252), font=font_code)

    # 3 Architecture Columns
    col_w = 345
    col_gap = 37
    start_x = 45
    start_y = 125
    col_h = 490

    columns = [
        {
            "tag": "PRESENTATION LAYER",
            "title": "Compose Multiplatform UI",
            "accent": (168, 85, 247), # Purple
            "bg": (22, 27, 34),
            "sections": [
                ("Unified Declarative UI", "100% shared Compose code across Android & Desktop with adaptive responsive breakpoints."),
                ("Audiophile Spectrum Visualizer", "Real-time 28-band logarithmic FFT audio visualizer (Hann windowing + Cooley-Tukey Radix-2)."),
                ("Dynamic Theming & Shaders", "Material 3 color extraction, Apple-inspired frosted glass blurs, ambient cyber glow."),
                ("In-App Cinema Theater", "Embedded sandboxed player with auto-resizing aspect ratio & gesture controls.")
            ]
        },
        {
            "tag": "DOMAIN & STATE LAYER",
            "title": "Kotlin Multiplatform Core",
            "accent": (56, 189, 248), # Cyan
            "bg": (22, 27, 34),
            "sections": [
                ("MVI State Architecture", "Unidirectional data flow with coroutines, StateFlow, and centralized playback dispatcher."),
                ("Decoupled Extension SPI", "Modular plugin system: Spotify, JioSaavn, YouTube Music, SoundCloud, Genius Lyrics."),
                ("SQLDelight Offline Cache", "Type-safe SQL schemas, LRU track metadata cache, and local playlist persistence."),
                ("Cinemeta IMDb Resolver", "Dynamic metadata mapping (`tt...`), episode indexing, and fallback stream mirrors.")
            ]
        },
        {
            "tag": "HARDWARE & RUNTIME LAYER",
            "title": "Dual Runtimes & AI Engine",
            "accent": (52, 211, 153), # Emerald
            "bg": (22, 27, 34),
            "sections": [
                ("Desktop Native Engine (VLCJ)", "Low-latency libVLC C-bindings, gapless playback, hardware decoding on Win/Mac/Linux."),
                ("Mobile Native Engine (ExoPlayer)", "AndroidX Media3 pipeline, background service, notification media session, lock screen."),
                ("Dual AI Speech-to-Text", "Whisper Large V3 Turbo (Groq) & Deepgram Nova-2 with real-time Voice Activity Detection."),
                ("Anti-Popup Security Shield", "Sandboxed WebView container intercepting rogue redirects, popups, and ad scripts.")
            ]
        }
    ]

    for i, col in enumerate(columns):
        cx = start_x + i * (col_w + col_gap)
        # Background box
        draw.rounded_rectangle([cx, start_y, cx + col_w, start_y + col_h], radius=12, fill=col["bg"], outline=col["accent"], width=2)
        
        # Tag header
        draw.rounded_rectangle([cx + 16, start_y + 16, cx + 180, start_y + 38], radius=6, fill=(30, 41, 59))
        draw.text((cx + 24, start_y + 20), col["tag"], fill=col["accent"], font=font_code)
        
        # Column title
        draw.text((cx + 16, start_y + 48), col["title"], fill=(240, 246, 252), font=font_box_header)
        draw.line([cx + 16, start_y + 78, cx + col_w - 16, start_y + 78], fill=(48, 54, 61), width=1)

        # Content blocks
        sec_y = start_y + 90
        for title, desc in col["sections"]:
            # bullet accent
            draw.ellipse([cx + 18, sec_y + 4, cx + 24, sec_y + 10], fill=col["accent"])
            draw.text((cx + 32, sec_y), title, fill=(226, 232, 240), font=font_body_bold)
            
            # Simple text wrap for description
            words = desc.split()
            line = ""
            lines = []
            for w in words:
                test = line + " " + w if line else w
                bbox = draw.textbbox((0, 0), test, font=font_body)
                if bbox[2] - bbox[0] > (col_w - 50):
                    lines.append(line)
                    line = w
                else:
                    line = test
            if line:
                lines.append(line)
            
            cur_desc_y = sec_y + 18
            for l in lines:
                draw.text((cx + 32, cur_desc_y), l, fill=(148, 163, 184), font=font_body)
                cur_desc_y += 16
            
            sec_y = cur_desc_y + 12

    # Bottom bar
    draw.text((45, height - 35), "Crafted with Kotlin Multiplatform  •  Open Source on GitHub  •  Built by Aawesh Das", fill=(100, 116, 139), font=font_body)
    draw.text((width - 320, height - 35), "github.com/aaweshdas/Audix-Multiplatform-Music-Player", fill=(129, 140, 248), font=font_body)

    out_path = os.path.join(images_dir, "06_Architecture_Infographic.png")
    img.save(out_path, format="PNG", quality=100)
    print("Created 06_Architecture_Infographic.png")

# 7. Generate 07_LinkedIn_Feature_Collage.png (Hero showcase with mobile + desktop mockups)
def generate_hero_collage():
    width, height = 1200, 675
    collage = Image.new("RGBA", (width, height), (15, 23, 42, 255))
    draw = ImageDraw.Draw(collage)

    # Ambient glows
    for r in range(250, 0, -8):
        alpha = int(25 * (1 - r / 250))
        draw.ellipse([width//2 - r, height//2 - r, width//2 + r, height//2 + r], fill=(124, 58, 237, alpha))
        draw.ellipse([200 - r, 150 - r, 200 + r, 150 + r], fill=(56, 189, 248, alpha))

    # Paste Desktop preview
    desktop_src = os.path.join(user_up_dir, "media_1791816044789_27efbb28.jpg")
    if os.path.exists(desktop_src):
        with Image.open(desktop_src) as d_img:
            # Resize desktop to fit nicely on the left/center
            d_w, d_h = 750, 420
            d_resized = d_img.resize((d_w, d_h), Image.Resampling.LANCZOS)
            # Create rounded shadow
            d_x, d_y = 50, 150
            draw.rounded_rectangle([d_x - 4, d_y - 4, d_x + d_w + 4, d_y + d_h + 4], radius=14, outline=(139, 92, 246), width=3)
            collage.paste(d_resized, (d_x, d_y))

    # Paste Mobile Phone preview on the right (overlapping slightly)
    mobile_src = os.path.join(brain_dir, "phone_screen_updated.png")
    if os.path.exists(mobile_src):
        with Image.open(mobile_src) as m_img:
            # Mobile is 1080x2400. Resize to fit nicely
            m_h = 510
            m_w = int(m_h * (1080 / 2400))
            m_resized = m_img.resize((m_w, m_h), Image.Resampling.LANCZOS)
            m_x = width - m_w - 70
            m_y = 100
            
            # Shadow around phone
            draw.rounded_rectangle([m_x - 6, m_y - 6, m_x + m_w + 6, m_y + m_h + 6], radius=22, fill=(10, 15, 30, 220), outline=(56, 189, 248), width=3)
            # Paste phone
            collage.paste(m_resized, (m_x, m_y))

    # Header text on top of collage
    font_hero = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 34)
    font_hero_sub = ImageFont.truetype(r"C:\Windows\Fonts\segoeui.ttf", 16)
    font_badge = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 12)

    draw.text((50, 35), "NIGHTLY  |  Music, Cinema & AI Experience", fill=(255, 255, 255), font=font_hero)
    draw.text((50, 80), "Unified Kotlin Multiplatform ecosystem for Android and Windows / Desktop", fill=(148, 163, 184), font=font_hero_sub)

    # Badges row
    badges = ["KOTLIN MULTIPLATFORM", "COMPOSE MP", "EXOPLAYER & VLCJ", "WHISPER AI", "IN-APP CINEMA"]
    bx = 50
    for b in badges:
        draw.rounded_rectangle([bx, 108, bx + len(b)*8 + 24, 132], radius=6, fill=(30, 41, 59), outline=(99, 102, 241), width=1)
        draw.text((bx + 12, 112), b, fill=(224, 231, 255), font=font_badge)
        bx += len(b)*8 + 36

    # Bottom caption
    draw.text((50, height - 40), "Dual Native Runtimes  •  Decoupled Plugin SPI  •  28-Band FFT Visualizer  •  Zero-Popup Player", fill=(100, 116, 139), font=font_hero_sub)

    out_path = os.path.join(images_dir, "07_LinkedIn_Feature_Collage.png")
    collage.save(out_path, format="PNG", quality=100)
    print("Created 07_LinkedIn_Feature_Collage.png")

generate_architecture_banner()
generate_hero_collage()
