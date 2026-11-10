import os
from PIL import Image, ImageDraw, ImageFont

base_dir = r"S:\All Code\Antigravity\echo-nightly\linkedin-showcase"
images_dir = os.path.join(base_dir, "images")
pdf_out_path = os.path.join(base_dir, "Nightly_Showcase_Carousel.pdf")

# Standard LinkedIn Document 4:5 vertical resolution (1080 x 1350)
WIDTH = 1080
HEIGHT = 1350

font_title_large = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 52)
font_title = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 40)
font_sub = ImageFont.truetype(r"C:\Windows\Fonts\segoeui.ttf", 26)
font_h2 = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 30)
font_body = ImageFont.truetype(r"C:\Windows\Fonts\segoeui.ttf", 22)
font_body_bold = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 22)
font_badge = ImageFont.truetype(r"C:\Windows\Fonts\segoeuib.ttf", 18)
font_caption = ImageFont.truetype(r"C:\Windows\Fonts\consola.ttf", 18)

slides = []

def create_slide_base(slide_num, total_slides=6):
    img = Image.new("RGB", (WIDTH, HEIGHT), (11, 15, 25))
    draw = ImageDraw.Draw(img)

    # Ambient cyber glow in background
    for r in range(350, 0, -10):
        alpha = int(20 * (1 - r / 350))
        # Blue top-right glow
        draw.ellipse([WIDTH - 150 - r, 100 - r, WIDTH - 150 + r, 100 + r], fill=(124, 58, 237))
        # Cyan bottom-left glow
        draw.ellipse([100 - r, HEIGHT - 150 - r, 100 + r, HEIGHT - 150 + r], fill=(14, 165, 233))

    # Top brand bar
    draw.text((70, 60), "NIGHTLY  🌙", fill=(240, 246, 252), font=font_badge)
    draw.text((WIDTH - 180, 60), f"{slide_num} / {total_slides}", fill=(148, 163, 184), font=font_caption)
    draw.line([70, 100, WIDTH - 70, 100], fill=(30, 41, 59), width=2)

    # Bottom bar
    draw.line([70, HEIGHT - 90, WIDTH - 70, HEIGHT - 90], fill=(30, 41, 59), width=2)
    draw.text((70, HEIGHT - 65), "github.com/aaweshdas/Audix-Multiplatform-Music-Player", fill=(99, 102, 241), font=font_caption)
    if slide_num < total_slides:
        draw.text((WIDTH - 190, HEIGHT - 65), "Swipe Next ➡️", fill=(240, 246, 252), font=font_badge)

    return img, draw

# ================= SLIDE 1: COVER =================
def make_slide_1():
    img, draw = create_slide_base(1)
    
    # Hero badge
    draw.rounded_rectangle([70, 150, 410, 195], radius=8, fill=(30, 41, 59), outline=(139, 92, 246), width=2)
    draw.text((85, 160), "KOTLIN MULTIPLATFORM", fill=(192, 132, 252), font=font_badge)

    draw.text((70, 230), "Building Nightly 🌙", fill=(255, 255, 255), font=font_title_large)
    draw.text((70, 310), "The All-in-One Open-Source\nMusic & Cinema Player", fill=(148, 163, 184), font=font_title)

    # App Logo in center
    logo_path = os.path.join(images_dir, "01_Nightly_Hero_Brand.png")
    if os.path.exists(logo_path):
        with Image.open(logo_path) as l_img:
            l_resized = l_img.resize((360, 360), Image.Resampling.LANCZOS)
            # Center logo
            cx, cy = (WIDTH - 360) // 2, 430
            # Glowing border
            draw.rounded_rectangle([cx - 8, cy - 8, cx + 368, cy + 368], radius=32, outline=(99, 102, 241), width=4)
            img.paste(l_resized, (cx, cy))

    # Features pill highlights
    pills = ["Zero Ads & Tracking", "Android & Desktop", "In-App Cinema", "28-Band FFT Audio", "AI Voice Search"]
    px, py = 70, 860
    for p in pills:
        draw.rounded_rectangle([px, py, px + len(p)*14 + 30, py + 48], radius=10, fill=(22, 27, 34), outline=(56, 189, 248), width=1)
        draw.text((px + 15, py + 12), f"✨ {p}", fill=(240, 246, 252), font=font_body_bold)
        py += 62

    draw.text((70, 1200), "A Complete Engineering Case Study & Showcase", fill=(148, 163, 184), font=font_sub)
    return img

# ================= SLIDE 2: THE PROBLEM =================
def make_slide_2():
    img, draw = create_slide_base(2)

    draw.text((70, 150), "THE PROBLEM", fill=(244, 63, 94), font=font_badge)
    draw.text((70, 200), "Why Are Modern Media Apps\nSo Frustrating?", fill=(255, 255, 255), font=font_title)

    problems = [
        ("🚫 Invasive Ads & Clutter", "Unskippable video and audio commercials interrupting playlists every 10 minutes."),
        ("🔒 Paywalled Basic Features", "Background play, lyrics, offline downloads, and seeking locked behind subscriptions."),
        ("🧩 Fragmented Catalogs", "Forced to juggle Spotify for music, YouTube for indie tracks, and piracy-riddled sites for cinema."),
        ("💾 Resource Bloat & Telemetry", "Heavy Electron wrappers eating 2GB+ RAM with aggressive background tracking.")
    ]

    py = 360
    for title, desc in problems:
        draw.rounded_rectangle([70, py, WIDTH - 70, py + 140], radius=14, fill=(22, 27, 34), outline=(244, 63, 94), width=1)
        draw.text((105, py + 22), title, fill=(254, 205, 211), font=font_h2)
        draw.text((105, py + 72), desc, fill=(148, 163, 184), font=font_body)
        py += 175

    draw.rounded_rectangle([70, 1100, WIDTH - 70, 1220], radius=14, fill=(15, 23, 42), outline=(139, 92, 246), width=2)
    draw.text((105, 1125), "💡 The Solution:", fill=(167, 139, 250), font=font_h2)
    draw.text((105, 1170), "Build an open-source, privacy-first client that does it all under one roof.", fill=(240, 246, 252), font=font_body)
    return img

# ================= SLIDE 3: TRUE CROSS-PLATFORM =================
def make_slide_3():
    img, draw = create_slide_base(3)

    draw.text((70, 150), "ARCHITECTURE", fill=(56, 189, 248), font=font_badge)
    draw.text((70, 200), "One Codebase.\nNative Performance.", fill=(255, 255, 255), font=font_title)

    # 2 Comparison Columns
    col_w = (WIDTH - 180) // 2

    # Column 1: Mobile
    draw.rounded_rectangle([70, 360, 70 + col_w, 1020], radius=16, fill=(22, 27, 34), outline=(56, 189, 248), width=2)
    draw.text((100, 390), "📱 ANDROID CLIENT", fill=(56, 189, 248), font=font_h2)
    draw.line([100, 440, 70 + col_w - 30, 440], fill=(48, 54, 61), width=1)
    
    m_points = [
        "AndroidX Media3 (ExoPlayer)",
        "Foreground Service Playback",
        "Lock Screen Notifications",
        "Hardware Media Key Hooks",
        "Dynamic Material 3 You Theming",
        "Low Battery & Memory Profile",
        "Min SDK 24 up to Android 15"
    ]
    my = 470
    for p in m_points:
        draw.text((100, my), f"✔ {p}", fill=(226, 232, 240), font=font_body)
        my += 75

    # Column 2: Desktop
    cx = 70 + col_w + 40
    draw.rounded_rectangle([cx, 360, cx + col_w, 1020], radius=16, fill=(22, 27, 34), outline=(168, 85, 247), width=2)
    draw.text((cx + 30, 390), "💻 DESKTOP CLIENT", fill=(168, 85, 247), font=font_h2)
    draw.line([cx + 30, 440, cx + col_w - 30, 440], fill=(48, 54, 61), width=1)

    d_points = [
        "VLCJ Native libVLC C-Bindings",
        "Lossless Gapless Audio Engine",
        "Windows, macOS & Linux Support",
        "Multi-Window Video Playback",
        "28-Band Real-Time Visualizer",
        "Standalone Portable Zero-Install",
        "Hardware GPU Acceleration"
    ]
    dy = 470
    for p in d_points:
        draw.text((cx + 30, dy), f"✔ {p}", fill=(226, 232, 240), font=font_body)
        dy += 75

    # Bottom shared badge
    draw.rounded_rectangle([70, 1060, WIDTH - 70, 1220], radius=14, fill=(15, 23, 42), outline=(52, 211, 153), width=2)
    draw.text((105, 1085), "⚡ 90%+ Shared Kotlin Code", fill=(52, 211, 153), font=font_h2)
    draw.text((105, 1130), "State machines, SQLDelight database, network pipelines, and UI layouts are completely shared across platforms.", fill=(203, 213, 225), font=font_body)
    return img

# ================= SLIDE 4: UNIVERSAL CATALOG & CINEMA =================
def make_slide_4():
    img, draw = create_slide_base(4)

    draw.text((70, 150), "CAPABILITIES", fill=(168, 85, 247), font=font_badge)
    draw.text((70, 200), "Universal Music & In-App Cinema", fill=(255, 255, 255), font=font_title)

    features = [
        ("🎶 Decoupled Extension SPI", "Plug-and-play architecture pulling tracks directly from Spotify, YouTube Music, JioSaavn, SoundCloud, and RadioBrowser with automatic fallback mirrors."),
        ("🎬 In-App Cinema Theater", "Embedded streaming studio with automated Cinemeta IMDb resolution (`tt...`), episode indexes, and multi-server stream mirrors."),
        ("🛡️ Sandboxed Security Shield", "Custom WebView interceptor blocking unwanted ad redirects, popups, and intrusive third-party scripts."),
        ("📜 Synced Synchronized Lyrics", "Real-time scrolling karaoke lyrics powered by LRCLIB, Genius, and Musixmatch.")
    ]

    fy = 330
    for title, desc in features:
        draw.rounded_rectangle([70, fy, WIDTH - 70, fy + 175], radius=14, fill=(22, 27, 34), outline=(99, 102, 241), width=1)
        draw.text((105, fy + 24), title, fill=(224, 231, 255), font=font_h2)
        
        words = desc.split()
        line = ""
        lines = []
        for w in words:
            test = line + " " + w if line else w
            bbox = draw.textbbox((0, 0), test, font=font_body)
            if bbox[2] - bbox[0] > (WIDTH - 250):
                lines.append(line)
                line = w
            else:
                line = test
        if line:
            lines.append(line)
        
        cur_y = fy + 72
        for l in lines:
            draw.text((105, cur_y), l, fill=(148, 163, 184), font=font_body)
            cur_y += 30

        fy += 210

    return img

# ================= SLIDE 5: FFT VISUALIZER & AI VOICE =================
def make_slide_5():
    img, draw = create_slide_base(5)

    draw.text((70, 150), "DEEP TECH", fill=(52, 211, 153), font=font_badge)
    draw.text((70, 200), "Audiophile Visualizer & AI Voice", fill=(255, 255, 255), font=font_title)

    # Box 1: FFT
    draw.rounded_rectangle([70, 320, WIDTH - 70, 680], radius=16, fill=(22, 27, 34), outline=(52, 211, 153), width=2)
    draw.text((105, 350), "📊 28-Band Cooley-Tukey Radix-2 FFT", fill=(52, 211, 153), font=font_h2)
    draw.line([105, 400, WIDTH - 105, 400], fill=(48, 54, 61), width=1)
    
    fft_bullets = [
        "Mathematical Fast Fourier Transform computed over raw 512-point audio chunks.",
        "Hann windowing applied to eliminate edge spectral leakage.",
        "Logarithmic frequency scaling across 28 bands (20 Hz sub-bass to 20 kHz treble).",
        "Hardware-accelerated rendering at fluid 60fps."
    ]
    fty = 425
    for b in fft_bullets:
        draw.text((105, fty), f"• {b}", fill=(203, 213, 225), font=font_body)
        fty += 60

    # Box 2: AI Voice Search
    draw.rounded_rectangle([70, 720, WIDTH - 70, 1150], radius=16, fill=(22, 27, 34), outline=(56, 189, 248), width=2)
    draw.text((105, 750), "🎙️ Dual AI Speech-to-Text Engines", fill=(56, 189, 248), font=font_h2)
    draw.line([105, 800, WIDTH - 105, 800], fill=(48, 54, 61), width=1)

    ai_bullets = [
        "Whisper Large V3 Turbo running via Groq for ultra-low-latency transcription.",
        "Deepgram Nova-2 fallback with real-time Voice Activity Detection (VAD).",
        "Hands-free voice querying for songs, artists, albums, and cinema movies.",
        "Zero audio storage or tracking — privacy by design."
    ]
    aty = 825
    for b in ai_bullets:
        draw.text((105, aty), f"• {b}", fill=(203, 213, 225), font=font_body)
        aty += 60

    return img

# ================= SLIDE 6: OPEN SOURCE & CALL TO ACTION =================
def make_slide_6():
    img, draw = create_slide_base(6)

    draw.text((70, 150), "GET STARTED", fill=(139, 92, 246), font=font_badge)
    draw.text((70, 200), "100% Free & Open-Source", fill=(255, 255, 255), font=font_title_large)

    draw.text((70, 290), "Nightly is ready for you to explore, test, and contribute.", fill=(148, 163, 184), font=font_sub)

    # Big CTA Card
    draw.rounded_rectangle([70, 370, WIDTH - 70, 800], radius=18, fill=(15, 23, 42), outline=(139, 92, 246), width=3)
    
    draw.text((105, 410), "🌟 Check Out The Repository", fill=(255, 255, 255), font=font_h2)
    draw.text((105, 460), "https://github.com/aaweshdas/Audix-Multiplatform-Music-Player", fill=(129, 140, 248), font=font_body_bold)

    ctas = [
        "⭐ Star the repo on GitHub if you love KMP & open source",
        "📦 Download the Android APK or Windows Portable Zip",
        "🛠️ Clone the project and run locally in Android Studio / IntelliJ",
        "💬 Connect with me on LinkedIn to discuss KMP & mobile tech!"
    ]
    cy = 530
    for c in ctas:
        draw.text((105, cy), c, fill=(226, 232, 240), font=font_body)
        cy += 58

    # Author card
    draw.rounded_rectangle([70, 840, WIDTH - 70, 1180], radius=18, fill=(22, 27, 34), outline=(56, 189, 248), width=1)
    draw.text((105, 880), "Crafted with passion by Aawesh Das", fill=(255, 255, 255), font=font_h2)
    draw.text((105, 930), "Software Engineer & Cross-Platform Enthusiast", fill=(148, 163, 184), font=font_sub)
    draw.text((105, 990), "Tech Stack: Kotlin Multiplatform • Compose • ExoPlayer • libVLC • AI/STT", fill=(56, 189, 248), font=font_body)
    draw.text((105, 1050), "Drop a comment or share this with anyone exploring Kotlin Multiplatform! 👇", fill=(203, 213, 225), font=font_body_bold)

    return img

print("Generating slides...")
s1 = make_slide_1()
s2 = make_slide_2()
s3 = make_slide_3()
s4 = make_slide_4()
s5 = make_slide_5()
s6 = make_slide_6()

slides = [s1, s2, s3, s4, s5, s6]

# Save as PDF
slides[0].save(pdf_out_path, save_all=True, append_images=slides[1:], quality=95)
print(f"Generated Carousel PDF: {pdf_out_path}")

# Also export individual slide images into a carousel_slides folder so user can post images if preferred!
slides_dir = os.path.join(images_dir, "carousel_slides")
os.makedirs(slides_dir, exist_ok=True)
for i, s in enumerate(slides):
    slide_file = os.path.join(slides_dir, f"Slide_{i+1}.png")
    s.save(slide_file, format="PNG")
    print(f"Exported {slide_file}")
