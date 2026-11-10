import os
import subprocess
import base64
from PIL import Image

edge_exe = r"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
base_dir = r"S:\All Code\Antigravity\echo-nightly\linkedin-showcase"
images_dir = os.path.join(base_dir, "images")
slides_dir = os.path.join(images_dir, "carousel_slides")
os.makedirs(images_dir, exist_ok=True)
os.makedirs(slides_dir, exist_ok=True)

brain_dir = r"C:\Users\dasab\.gemini\antigravity\brain\b909a816-beee-46d1-91b6-bdd98f1af904"
user_up_dir = os.path.join(brain_dir, ".user_uploaded")

def get_b64(path):
    with open(path, "rb") as f:
        return base64.b64encode(f.read()).decode("utf-8")

# LATEST NIGHTLY ASSETS
phone_b64 = get_b64(os.path.join(brain_dir, "phone_screen_updated.png"))
# Use the brand new latest desktop UI!
latest_desktop_path = os.path.join(images_dir, "latest_nightly_desktop_ui.png")
desktop_b64 = get_b64(latest_desktop_path)

cinema_b64 = get_b64(os.path.join(user_up_dir, "media_1793515096338_733c01cf.jpg"))
logo_b64 = get_b64(os.path.join(brain_dir, "nightly_app_logo_1793742061187.jpg"))
voice_b64 = get_b64(os.path.join(user_up_dir, "media_1793736510187_3fe70c95.png"))

def render_html(html_str, out_path, width=1200, height=675):
    temp_html = os.path.join(base_dir, "_temp_render.html")
    with open(temp_html, "w", encoding="utf-8") as f:
        f.write(html_str)
    
    cmd = [
        edge_exe,
        "--headless=new",
        "--disable-gpu",
        "--hide-scrollbars",
        f"--window-size={width},{height}",
        f"--screenshot={out_path}",
        f"file:///{temp_html}"
    ]
    subprocess.run(cmd, capture_output=True)
    if os.path.exists(temp_html):
        os.remove(temp_html)
    if os.path.exists(out_path):
        print(f"Rendered: {os.path.basename(out_path)} ({os.path.getsize(out_path)/1024:.1f} KB)")
    else:
        print(f"FAILED: {os.path.basename(out_path)}")

COMMON_HEAD = '''
<meta charset="utf-8">
<style>
  * { box-sizing: border-box; margin: 0; padding: 0; }
  body {
    background: #07090E;
    color: #F8FAFC;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", sans-serif;
    position: relative;
    overflow: hidden;
    -webkit-font-smoothing: antialiased;
  }
  .glow-purple {
    position: absolute;
    width: 650px; height: 450px;
    top: -120px; right: 80px;
    background: radial-gradient(circle, rgba(99, 102, 241, 0.16) 0%, rgba(139, 92, 246, 0.05) 45%, transparent 70%);
    pointer-events: none;
  }
  .glow-cyan {
    position: absolute;
    width: 550px; height: 400px;
    bottom: -120px; left: 80px;
    background: radial-gradient(circle, rgba(56, 189, 248, 0.08) 0%, transparent 65%);
    pointer-events: none;
  }
  .badge {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    padding: 5px 13px;
    border-radius: 9999px;
    background: rgba(255, 255, 255, 0.04);
    border: 1px solid rgba(255, 255, 255, 0.1);
    font-size: 11px;
    font-weight: 600;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #C7D2FE;
    width: fit-content;
  }
  .badge-dot {
    width: 6px; height: 6px;
    border-radius: 50%;
    background: #818CF8;
    box-shadow: 0 0 8px #818CF8;
  }
  .pill-chip {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    padding: 6px 14px;
    border-radius: 9999px;
    background: rgba(255, 255, 255, 0.03);
    border: 1px solid rgba(255, 255, 255, 0.08);
    font-size: 12px;
    font-weight: 500;
    color: #94A3B8;
  }
</style>
'''

# =========================================================================
# ASSET 1: 07_LinkedIn_Feature_Collage.png (Hero Banner - 1200 x 675)
# =========================================================================
def build_hero_collage():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    display: flex;
    align-items: center;
    padding: 0 65px;
  }}
  .left-col {{
    width: 480px;
    z-index: 10;
    display: flex;
    flex-direction: column;
    justify-content: center;
  }}
  h1 {{
    font-size: 52px;
    font-weight: 700;
    letter-spacing: -0.03em;
    line-height: 1.08;
    color: #FFFFFF;
    margin-top: 18px;
    margin-bottom: 14px;
  }}
  h1 span {{
    background: linear-gradient(135deg, #A78BFA 0%, #818CF8 50%, #38BDF8 100%);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
  }}
  p.subtitle {{
    font-size: 16px;
    line-height: 1.6;
    color: #94A3B8;
    margin-bottom: 28px;
  }}
  .feature-list {{
    display: flex;
    flex-direction: column;
    gap: 12px;
    margin-bottom: 30px;
  }}
  .feature-item {{
    display: flex;
    align-items: center;
    gap: 12px;
    font-size: 14px;
    color: #CBD5E1;
    font-weight: 500;
  }}
  .feature-icon {{
    width: 20px; height: 20px;
    border-radius: 6px;
    background: rgba(99, 102, 241, 0.12);
    border: 1px solid rgba(99, 102, 241, 0.25);
    display: flex; align-items: center; justify-content: center;
    color: #A78BFA;
    font-size: 10px;
  }}
  .meta-tag {{
    display: flex;
    align-items: center;
    gap: 12px;
    font-size: 12px;
    color: #64748B;
  }}
  .meta-tag strong {{
    color: #94A3B8;
    font-weight: 500;
  }}
  .right-col {{
    flex: 1;
    height: 100%;
    position: relative;
    display: flex;
    align-items: center;
    justify-content: flex-end;
  }}
  .desktop-frame {{
    width: 630px;
    height: 385px;
    background: #11141E;
    border-radius: 12px;
    border: 1px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 35px 80px -15px rgba(0, 0, 0, 0.85), 0 0 0 1px rgba(255, 255, 255, 0.05);
    overflow: hidden;
    position: absolute;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
    z-index: 2;
  }}
  .desktop-img {{
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: top center;
  }}
  .phone-frame {{
    width: 185px;
    height: 400px;
    background: #0E121B;
    border-radius: 36px;
    border: 3.5px solid #232A3B;
    box-shadow: 0 30px 70px -10px rgba(0, 0, 0, 0.95), 0 0 0 1px rgba(255, 255, 255, 0.12);
    overflow: hidden;
    position: absolute;
    right: -25px;
    bottom: 50px;
    z-index: 4;
    display: flex;
    flex-direction: column;
  }}
  .phone-island {{
    position: absolute;
    top: 8px; left: 50%;
    transform: translateX(-50%);
    width: 48px; height: 12px;
    background: #000000;
    border-radius: 9999px;
    z-index: 10;
  }}
  .phone-img {{
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: top center;
    border-radius: 32px;
  }}
</style>
</head>
<body>
  <div class="glow-purple"></div>
  <div class="glow-cyan"></div>
  <div class="left-col">
    <div class="badge">
      <div class="badge-dot"></div>
      Kotlin Multiplatform
    </div>
    <h1>Nightly <span>🌙</span></h1>
    <p class="subtitle">An open-source media & cinema player crafted for audiophiles and cinephiles. Fast, private, and native across Android and Desktop.</p>
    <div class="feature-list">
      <div class="feature-item"><div class="feature-icon">✦</div><span>100% Free & Open-Source (Zero Ads & Tracking)</span></div>
      <div class="feature-item"><div class="feature-icon">✦</div><span>In-App Cinema Theater with IMDb Smart Resolver</span></div>
      <div class="feature-item"><div class="feature-icon">✦</div><span>Audiophile 28-Band Real-Time FFT Visualizer</span></div>
      <div class="feature-item"><div class="feature-icon">✦</div><span>Dual AI Speech-to-Text Voice Search</span></div>
    </div>
    <div class="meta-tag">
      <span>Built by <strong>Aawesh Das</strong></span>
      <span>•</span>
      <span>github.com/aaweshdas/Audix-Multiplatform-Music-Player</span>
    </div>
  </div>
  <div class="right-col">
    <div class="desktop-frame">
      <img class="desktop-img" src="data:image/png;base64,{desktop_b64}" />
    </div>
    <div class="phone-frame">
      <div class="phone-island"></div>
      <img class="phone-img" src="data:image/png;base64,{phone_b64}" />
    </div>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "07_LinkedIn_Feature_Collage.png"))

# =========================================================================
# ASSET 2: 06_Architecture_Infographic.png (Architecture Blueprint - 1200 x 675)
# =========================================================================
def build_architecture():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    padding: 48px 65px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
  }}
  .arch-header {{
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
  }}
  .arch-title-area h2 {{
    font-size: 34px;
    font-weight: 700;
    letter-spacing: -0.02em;
    color: #FFFFFF;
    margin-top: 10px;
    margin-bottom: 6px;
  }}
  .arch-title-area p {{
    font-size: 15px;
    color: #94A3B8;
  }}
  .arch-cards {{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 24px;
    margin-top: 32px;
    margin-bottom: 28px;
    flex: 1;
  }}
  .arch-card {{
    background: rgba(15, 19, 29, 0.65);
    border: 1px solid rgba(255, 255, 255, 0.08);
    border-radius: 16px;
    padding: 26px 24px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    box-shadow: 0 20px 40px -10px rgba(0, 0, 0, 0.5);
    backdrop-filter: blur(12px);
  }}
  .card-top {{
    display: flex;
    flex-direction: column;
  }}
  .card-num {{
    font-size: 11px;
    font-weight: 600;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    margin-bottom: 8px;
  }}
  .card-title {{
    font-size: 20px;
    font-weight: 700;
    color: #FFFFFF;
    letter-spacing: -0.01em;
    margin-bottom: 18px;
  }}
  .card-bullets {{
    display: flex;
    flex-direction: column;
    gap: 12px;
  }}
  .bullet-row {{
    display: flex;
    align-items: flex-start;
    gap: 10px;
    font-size: 13.5px;
    line-height: 1.45;
    color: #94A3B8;
  }}
  .bullet-dot {{
    width: 5px; height: 5px;
    border-radius: 50%;
    margin-top: 6px;
    flex-shrink: 0;
  }}
  .bullet-row strong {{
    color: #E2E8F0;
    font-weight: 600;
  }}
  .arch-footer {{
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-top: 1px solid rgba(255, 255, 255, 0.06);
    padding-top: 18px;
    font-size: 12px;
    color: #64748B;
  }}
  .arch-footer span.repo {{
    color: #818CF8;
    font-weight: 500;
  }}
</style>
</head>
<body>
  <div class="glow-purple"></div>
  <div class="glow-cyan"></div>

  <div class="arch-header">
    <div class="arch-title-area">
      <div class="badge"><div class="badge-dot"></div>System Architecture</div>
      <h2>Nightly 🌙 Engine Blueprint</h2>
      <p>Decoupled multiplatform media architecture with dual native audio engines.</p>
    </div>
    <div class="pill-chip">100% Kotlin Multiplatform</div>
  </div>

  <div class="arch-cards">
    <div class="arch-card">
      <div class="card-top">
        <div class="card-num" style="color: #A78BFA;">01 / PRESENTATION</div>
        <div class="card-title">Compose Multiplatform</div>
        <div class="card-bullets">
          <div class="bullet-row"><div class="bullet-dot" style="background:#A78BFA;"></div><div><strong>100% Shared UI:</strong> Declarative Compose for Android & Desktop.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#A78BFA;"></div><div><strong>28-Band FFT:</strong> Real-time logarithmic audio spectrum visualizer.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#A78BFA;"></div><div><strong>Material 3 & Shaders:</strong> Dynamic colors and frosted glass blurs.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#A78BFA;"></div><div><strong>Adaptive Breakpoints:</strong> Mobile single-pane to wide desktop multi-column.</div></div>
        </div>
      </div>
    </div>

    <div class="arch-card">
      <div class="card-top">
        <div class="card-num" style="color: #38BDF8;">02 / KMP SHARED CORE</div>
        <div class="card-title">State Machine & SPI</div>
        <div class="card-bullets">
          <div class="bullet-row"><div class="bullet-dot" style="background:#38BDF8;"></div><div><strong>MVI Architecture:</strong> Coroutines & StateFlow playback dispatcher.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#38BDF8;"></div><div><strong>Decoupled Extension SPI:</strong> Spotify, JioSaavn, YT Music, SoundCloud.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#38BDF8;"></div><div><strong>SQLDelight Database:</strong> Type-safe offline cache & playlist persistence.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#38BDF8;"></div><div><strong>Cinemeta IMDb Resolver:</strong> Metadata indexing (`tt...`) & fallback mirrors.</div></div>
        </div>
      </div>
    </div>

    <div class="arch-card">
      <div class="card-top">
        <div class="card-num" style="color: #34D399;">03 / HARDWARE & AI</div>
        <div class="card-title">Dual Media Engines</div>
        <div class="card-bullets">
          <div class="bullet-row"><div class="bullet-dot" style="background:#34D399;"></div><div><strong>Android (Media3 ExoPlayer):</strong> Foreground service & lock-screen session.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#34D399;"></div><div><strong>Desktop (VLCJ / libVLC):</strong> Low-latency C-bindings for gapless audio.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#34D399;"></div><div><strong>Dual AI Voice Search:</strong> Whisper Large V3 Turbo & Deepgram Nova-2.</div></div>
          <div class="bullet-row"><div class="bullet-dot" style="background:#34D399;"></div><div><strong>Sandboxed Cinema Shield:</strong> Zero ad popups, redirects, or malicious scripts.</div></div>
        </div>
      </div>
    </div>
  </div>

  <div class="arch-footer">
    <span>Architected by Aawesh Das  •  Free & Open-Source</span>
    <span class="repo">github.com/aaweshdas/Audix-Multiplatform-Music-Player</span>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "06_Architecture_Infographic.png"))

# =========================================================================
# ASSET 3: 02_Android_Mobile_Player.png (Studio Mobile Showcase - 1200 x 675)
# =========================================================================
def build_mobile_showcase():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 90px;
  }}
  .phone-wrap {{
    width: 250px;
    height: 540px;
    background: #0E121B;
    border-radius: 44px;
    border: 4.5px solid #232A3B;
    box-shadow: 0 40px 90px -15px rgba(0, 0, 0, 0.95), 0 0 0 1px rgba(255, 255, 255, 0.12);
    overflow: hidden;
    position: relative;
    display: flex;
    flex-direction: column;
  }}
  .phone-island {{
    position: absolute;
    top: 10px; left: 50%;
    transform: translateX(-50%);
    width: 60px; height: 14px;
    background: #000000;
    border-radius: 9999px;
    z-index: 10;
  }}
  .phone-img {{
    width: 100%; height: 100%;
    object-fit: cover;
    object-position: top center;
    border-radius: 40px;
  }}
  .info-wrap {{
    width: 680px;
    display: flex;
    flex-direction: column;
  }}
  h2 {{
    font-size: 42px;
    font-weight: 700;
    letter-spacing: -0.02em;
    color: #FFFFFF;
    margin-top: 16px;
    margin-bottom: 12px;
  }}
  p.lead {{
    font-size: 16px;
    color: #94A3B8;
    line-height: 1.6;
    margin-bottom: 30px;
  }}
  .rows {{
    display: flex;
    flex-direction: column;
    gap: 16px;
  }}
  .row-item {{
    background: rgba(15, 19, 29, 0.6);
    border: 1px solid rgba(255, 255, 255, 0.07);
    border-radius: 12px;
    padding: 16px 20px;
    display: flex;
    align-items: center;
    gap: 16px;
  }}
  .row-icon {{
    width: 32px; height: 32px;
    border-radius: 8px;
    background: rgba(56, 189, 248, 0.1);
    border: 1px solid rgba(56, 189, 248, 0.25);
    color: #38BDF8;
    display: flex; align-items: center; justify-content: center;
    font-size: 14px;
    font-weight: 700;
    flex-shrink: 0;
  }}
  .row-text h4 {{
    font-size: 15px;
    color: #FFFFFF;
    font-weight: 600;
    margin-bottom: 3px;
  }}
  .row-text p {{
    font-size: 13px;
    color: #94A3B8;
  }}
</style>
</head>
<body>
  <div class="glow-cyan"></div>
  <div class="glow-purple"></div>

  <div class="phone-wrap">
    <div class="phone-island"></div>
    <img class="phone-img" src="data:image/png;base64,{phone_b64}" />
  </div>

  <div class="info-wrap">
    <div class="badge"><div class="badge-dot"></div>Android Client</div>
    <h2>Nightly on Android</h2>
    <p class="lead">Native mobile listening with low memory footprint, adaptive Material 3 theming, and an uncompromising background playback service.</p>
    <div class="rows">
      <div class="row-item">
        <div class="row-icon">⚡</div>
        <div class="row-text">
          <h4>AndroidX Media3 (ExoPlayer) Pipeline</h4>
          <p>Foreground audio service with seamless lock-screen controls and audio focus ducking.</p>
        </div>
      </div>
      <div class="row-item">
        <div class="row-icon">✦</div>
        <div class="row-text">
          <h4>Persistent Mini-Player Dock</h4>
          <p>Unobtrusive bottom dock with gesture seeking, volume leveling, and queue inspection.</p>
        </div>
      </div>
      <div class="row-item">
        <div class="row-icon">🎨</div>
        <div class="row-text">
          <h4>Material 3 Dynamic Theming</h4>
          <p>Real-time palette extraction matching current track artwork with frosted glass shaders.</p>
        </div>
      </div>
    </div>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "02_Android_Mobile_Player.png"))

# =========================================================================
# ASSET 4: 03_Desktop_Player_Visualizer.png (LATEST NIGHTLY DESKTOP SHOWCASE)
# =========================================================================
def build_desktop_showcase():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 36px 65px;
  }}
  .top-bar {{
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
  }}
  h2 {{
    font-size: 32px;
    font-weight: 700;
    letter-spacing: -0.02em;
    color: #FFFFFF;
    margin-top: 10px;
  }}
  .window-card {{
    width: 100%;
    height: 455px;
    background: #11141E;
    border-radius: 14px;
    border: 1px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 40px 90px -20px rgba(0, 0, 0, 0.9), 0 0 0 1px rgba(255, 255, 255, 0.06);
    overflow: hidden;
    margin: 14px 0;
  }}
  .win-img {{
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: top center;
  }}
  .bottom-chips {{
    display: flex;
    gap: 16px;
  }}
</style>
</head>
<body>
  <div class="glow-purple"></div>
  <div class="top-bar">
    <div>
      <div class="badge"><div class="badge-dot"></div>Latest Desktop Release</div>
      <h2>Nightly Desktop Station — 28-Band FFT & Cinema</h2>
    </div>
    <div class="pill-chip">libVLC Native C-Bindings • 60 FPS Direct3D</div>
  </div>

  <div class="window-card">
    <img class="win-img" src="data:image/png;base64,{desktop_b64}" />
  </div>

  <div class="bottom-chips">
    <div class="pill-chip">✦ Mathematical 512-Point Radix-2 FFT</div>
    <div class="pill-chip">✦ In-App Cinema Theater (Movie Play)</div>
    <div class="pill-chip">✦ Native libVLC Low-Latency Pipeline</div>
    <div class="pill-chip">✦ Standalone Portable Zero-Install</div>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "03_Desktop_Player_Visualizer.png"))

# =========================================================================
# ASSET 5: 04_InApp_Cinema_Studio.png (Studio Cinema Showcase - 1200 x 675)
# =========================================================================
def build_cinema_showcase():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 36px 65px;
  }}
  .top-bar {{
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
  }}
  h2 {{
    font-size: 32px;
    font-weight: 700;
    letter-spacing: -0.02em;
    color: #FFFFFF;
    margin-top: 10px;
  }}
  .window-card {{
    width: 100%;
    height: 455px;
    background: #11141E;
    border-radius: 14px;
    border: 1px solid rgba(255, 255, 255, 0.1);
    box-shadow: 0 40px 90px -20px rgba(0, 0, 0, 0.9), 0 0 0 1px rgba(255, 255, 255, 0.06);
    overflow: hidden;
    margin: 14px 0;
  }}
  .win-header {{
    height: 36px;
    background: #161B26;
    border-bottom: 1px solid rgba(255, 255, 255, 0.06);
    display: flex;
    align-items: center;
    padding: 0 16px;
    gap: 8px;
  }}
  .dot {{ width: 10px; height: 10px; border-radius: 50%; }}
  .dot-red {{ background: #FF5F56; opacity: 0.85; }}
  .dot-yellow {{ background: #FFBD2E; opacity: 0.85; }}
  .dot-green {{ background: #27C93F; opacity: 0.85; }}
  .win-title {{
    margin-left: 12px;
    font-size: 12px;
    color: #64748B;
    font-weight: 500;
  }}
  .win-img {{
    width: 100%;
    height: 100%;
    object-fit: cover;
    object-position: top center;
  }}
  .bottom-chips {{
    display: flex;
    gap: 16px;
  }}
</style>
</head>
<body>
  <div class="glow-purple"></div>
  <div class="top-bar">
    <div>
      <div class="badge"><div class="badge-dot"></div>Cinema Studio</div>
      <h2>In-App Cinema & Movie Streaming</h2>
    </div>
    <div class="pill-chip">Cinemeta IMDb Resolver</div>
  </div>

  <div class="window-card">
    <div class="win-header">
      <div class="dot dot-red"></div><div class="dot dot-yellow"></div><div class="dot dot-green"></div>
      <span class="win-title">Nightly Cinema — Sandboxed Player & Zero-Ad Shield</span>
    </div>
    <img class="win-img" src="data:image/jpeg;base64,{cinema_b64}" />
  </div>

  <div class="bottom-chips">
    <div class="pill-chip">✦ Automated IMDb Resolution (`tt...`)</div>
    <div class="pill-chip">✦ Sandboxed WebView Pop-up Shield</div>
    <div class="pill-chip">✦ Multi-Server Mirror Redundancy</div>
    <div class="pill-chip">✦ Fullscreen Frosted Glass Backdrop</div>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "04_InApp_Cinema_Studio.png"))

# =========================================================================
# ASSET 6: 05_AI_Voice_Search_Modal.png (Studio AI Voice Showcase - 1200 x 675)
# =========================================================================
def build_voice_showcase():
    html = f'''<!DOCTYPE html>
<html>
<head>
{COMMON_HEAD}
<style>
  body {{
    width: 1200px; height: 675px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 90px;
  }}
  .voice-card {{
    width: 380px;
    height: 380px;
    background: #11141E;
    border-radius: 24px;
    border: 1px solid rgba(255, 255, 255, 0.12);
    box-shadow: 0 35px 80px -15px rgba(0, 0, 0, 0.9), 0 0 0 1px rgba(255, 255, 255, 0.06);
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
  }}
  .voice-img {{
    width: 100%; height: 100%;
    object-fit: cover;
  }}
  .info-wrap {{
    width: 580px;
    display: flex;
    flex-direction: column;
  }}
  h2 {{
    font-size: 40px;
    font-weight: 700;
    letter-spacing: -0.02em;
    color: #FFFFFF;
    margin-top: 16px;
    margin-bottom: 12px;
  }}
  p.lead {{
    font-size: 16px;
    color: #94A3B8;
    line-height: 1.6;
    margin-bottom: 28px;
  }}
  .rows {{
    display: flex;
    flex-direction: column;
    gap: 14px;
  }}
  .row-item {{
    background: rgba(15, 19, 29, 0.6);
    border: 1px solid rgba(255, 255, 255, 0.07);
    border-radius: 12px;
    padding: 16px 20px;
    display: flex;
    align-items: center;
    gap: 16px;
  }}
  .row-icon {{
    width: 32px; height: 32px;
    border-radius: 8px;
    background: rgba(168, 85, 247, 0.12);
    border: 1px solid rgba(168, 85, 247, 0.25);
    color: #A78BFA;
    display: flex; align-items: center; justify-content: center;
    font-size: 14px;
    font-weight: 700;
    flex-shrink: 0;
  }}
  .row-text h4 {{
    font-size: 15px;
    color: #FFFFFF;
    font-weight: 600;
    margin-bottom: 3px;
  }}
  .row-text p {{
    font-size: 13px;
    color: #94A3B8;
  }}
</style>
</head>
<body>
  <div class="glow-purple"></div>
  <div class="glow-cyan"></div>

  <div class="voice-card">
    <img class="voice-img" src="data:image/png;base64,{voice_b64}" />
  </div>

  <div class="info-wrap">
    <div class="badge"><div class="badge-dot"></div>Speech Recognition</div>
    <h2>AI-Powered Voice Search</h2>
    <p class="lead">Hands-free natural language queries for songs, artists, and movies with zero audio retention or telemetry.</p>
    <div class="rows">
      <div class="row-item">
        <div class="row-icon">🎙️</div>
        <div class="row-text">
          <h4>Whisper Large V3 Turbo</h4>
          <p>Ultra-low-latency speech transcription powered by Groq cloud inference.</p>
        </div>
      </div>
      <div class="row-item">
        <div class="row-icon">⚡</div>
        <div class="row-text">
          <h4>Deepgram Nova-2 Integration</h4>
          <p>Secondary high-accuracy engine with real-time Voice Activity Detection (VAD).</p>
        </div>
      </div>
      <div class="row-item">
        <div class="row-icon">🔒</div>
        <div class="row-text">
          <h4>Privacy-First Architecture</h4>
          <p>Audio is streamed ephemerally and discarded immediately after transcription.</p>
        </div>
      </div>
    </div>
  </div>
</body>
</html>'''
    render_html(html, os.path.join(images_dir, "05_AI_Voice_Search_Modal.png"))

# =========================================================================
# ASSET 7: CAROUSEL SLIDES (WITH LATEST DESKTOP UI ON EVERY RELEVANT SLIDE)
# =========================================================================
CAROUSEL_HEAD = '''
<meta charset="utf-8">
<style>
  * { box-sizing: border-box; margin: 0; padding: 0; }
  body {
    width: 1080px; height: 1350px;
    background: #07090E;
    color: #F8FAFC;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", sans-serif;
    position: relative;
    overflow: hidden;
    padding: 70px 75px 60px 75px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    -webkit-font-smoothing: antialiased;
  }
  .glow-top {
    position: absolute;
    width: 750px; height: 500px;
    top: -150px; right: 50px;
    background: radial-gradient(circle, rgba(99, 102, 241, 0.16) 0%, rgba(139, 92, 246, 0.05) 50%, transparent 70%);
    pointer-events: none;
  }
  .glow-bottom {
    position: absolute;
    width: 700px; height: 450px;
    bottom: -150px; left: 50px;
    background: radial-gradient(circle, rgba(56, 189, 248, 0.08) 0%, transparent 65%);
    pointer-events: none;
  }
  .slide-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  .badge {
    display: inline-flex;
    align-items: center;
    gap: 8px;
    padding: 6px 14px;
    border-radius: 9999px;
    background: rgba(255, 255, 255, 0.04);
    border: 1px solid rgba(255, 255, 255, 0.1);
    font-size: 13px;
    font-weight: 600;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #C7D2FE;
  }
  .badge-dot {
    width: 7px; height: 7px;
    border-radius: 50%;
    background: #818CF8;
    box-shadow: 0 0 10px #818CF8;
  }
  .page-num {
    font-size: 14px;
    font-weight: 500;
    color: #64748B;
    letter-spacing: 0.06em;
  }
  .slide-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-top: 1px solid rgba(255, 255, 255, 0.07);
    padding-top: 22px;
    font-size: 14px;
    color: #64748B;
  }
  .slide-footer .repo {
    color: #818CF8;
    font-weight: 500;
  }
  .slide-footer .next {
    color: #F8FAFC;
    font-weight: 600;
    display: flex;
    align-items: center;
    gap: 6px;
  }
</style>
'''

def render_carousel_slide(slide_num, title, badge_text, body_html, next_text="Swipe ➔"):
    html = f'''<!DOCTYPE html>
<html>
<head>
{CAROUSEL_HEAD}
</head>
<body>
  <div class="glow-top"></div>
  <div class="glow-bottom"></div>

  <div class="slide-header">
    <div class="badge"><div class="badge-dot"></div>{badge_text}</div>
    <div class="page-num">{slide_num} / 6</div>
  </div>

  <div style="flex: 1; display: flex; flex-direction: column; justify-content: center;">
    {body_html}
  </div>

  <div class="slide-footer">
    <span class="repo">github.com/aaweshdas/Audix-Multiplatform-Music-Player</span>
    <span class="next">{next_text}</span>
  </div>
</body>
</html>'''
    out_file = os.path.join(slides_dir, f"Slide_{slide_num}.png")
    render_html(html, out_file, width=1080, height=1350)
    return out_file

def build_carousel():
    # Slide 1: Cover with Latest Desktop Preview!
    s1_body = f'''
    <div style="display: flex; flex-direction: column; align-items: center; text-align: center;">
      <div style="width: 880px; height: 490px; border-radius: 16px; overflow: hidden; border: 1px solid rgba(255, 255, 255, 0.15); box-shadow: 0 35px 80px -15px rgba(99, 102, 241, 0.45); margin-bottom: 38px;">
        <img src="data:image/png;base64,{desktop_b64}" style="width: 100%; height: 100%; object-fit: cover; object-position: top center;" />
      </div>
      <h1 style="font-size: 60px; font-weight: 800; letter-spacing: -0.03em; color: #FFFFFF; line-height: 1.1; margin-bottom: 16px;">
        Nightly <span style="background: linear-gradient(135deg, #A78BFA, #38BDF8); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">🌙</span>
      </h1>
      <p style="font-size: 22px; color: #94A3B8; max-width: 780px; line-height: 1.5; margin-bottom: 32px;">
        The all-in-one open-source media & cinema player built with Kotlin Multiplatform.
      </p>
      <div style="display: flex; gap: 12px; flex-wrap: wrap; justify-content: center;">
        <span style="padding: 8px 18px; border-radius: 9999px; background: rgba(255, 255, 255, 0.04); border: 1px solid rgba(255, 255, 255, 0.1); font-size: 14px; color: #CBD5E1;">Android & Desktop</span>
        <span style="padding: 8px 18px; border-radius: 9999px; background: rgba(255, 255, 255, 0.04); border: 1px solid rgba(255, 255, 255, 0.1); font-size: 14px; color: #CBD5E1;">Zero Ads</span>
        <span style="padding: 8px 18px; border-radius: 9999px; background: rgba(255, 255, 255, 0.04); border: 1px solid rgba(255, 255, 255, 0.1); font-size: 14px; color: #CBD5E1;">In-App Cinema</span>
        <span style="padding: 8px 18px; border-radius: 9999px; background: rgba(255, 255, 255, 0.04); border: 1px solid rgba(255, 255, 255, 0.1); font-size: 14px; color: #CBD5E1;">FFT Visualizer</span>
      </div>
    </div>
    '''
    render_carousel_slide(1, "Cover", "KOTLIN MULTIPLATFORM", s1_body)

    # Slide 2: Why We Built Nightly
    s2_body = '''
    <div>
      <h2 style="font-size: 52px; font-weight: 700; letter-spacing: -0.02em; color: #FFFFFF; line-height: 1.15; margin-bottom: 20px;">
        Why Are Modern Media Apps So Frustrating?
      </h2>
      <p style="font-size: 20px; color: #94A3B8; line-height: 1.6; margin-bottom: 48px;">
        Modern streaming software has become bloated, ad-ridden, and fragmented across closed ecosystems.
      </p>
      <div style="display: flex; flex-direction: column; gap: 20px;">
        <div style="background: rgba(15, 19, 29, 0.6); border: 1px solid rgba(255, 255, 255, 0.07); border-radius: 16px; padding: 24px 28px;">
          <h3 style="font-size: 20px; color: #FDA4AF; font-weight: 600; margin-bottom: 6px;">🚫 Unskippable Ads & Commercials</h3>
          <p style="font-size: 16px; color: #94A3B8; line-height: 1.5;">Interrupting your music every 10 minutes and forcing invasive sponsor reads.</p>
        </div>
        <div style="background: rgba(15, 19, 29, 0.6); border: 1px solid rgba(255, 255, 255, 0.07); border-radius: 16px; padding: 24px 28px;">
          <h3 style="font-size: 20px; color: #FDA4AF; font-weight: 600; margin-bottom: 6px;">🔒 Paywalled Basic Features</h3>
          <p style="font-size: 16px; color: #94A3B8; line-height: 1.5;">Background playback, lyrics, seeking, and offline listening locked behind monthly subscriptions.</p>
        </div>
        <div style="background: rgba(15, 19, 29, 0.6); border: 1px solid rgba(255, 255, 255, 0.07); border-radius: 16px; padding: 24px 28px;">
          <h3 style="font-size: 20px; color: #FDA4AF; font-weight: 600; margin-bottom: 6px;">🧩 Fragmented Apps & High Memory</h3>
          <p style="font-size: 16px; color: #94A3B8; line-height: 1.5;">Juggling Spotify, YouTube, and pirated movie sites using 2GB+ RAM each.</p>
        </div>
      </div>
    </div>
    '''
    render_carousel_slide(2, "The Problem", "THE VISION", s2_body)

    # Slide 3: One Codebase. Two Native Engines. (With Latest Desktop & Mobile Showcase!)
    s3_body = f'''
    <div>
      <h2 style="font-size: 48px; font-weight: 700; letter-spacing: -0.02em; color: #FFFFFF; line-height: 1.15; margin-bottom: 16px;">
        One Codebase.<br>Two Native Engines.
      </h2>
      <p style="font-size: 18px; color: #94A3B8; line-height: 1.5; margin-bottom: 24px;">
        Over 90% of code is shared across Android and Desktop with zero compromises in audio performance.
      </p>

      <!-- Visual Showcase of Both Platforms -->
      <div style="width: 100%; height: 380px; border-radius: 14px; overflow: hidden; border: 1px solid rgba(255, 255, 255, 0.12); box-shadow: 0 25px 60px -10px rgba(0,0,0,0.8); margin-bottom: 28px;">
        <img src="data:image/png;base64,{desktop_b64}" style="width: 100%; height: 100%; object-fit: cover; object-position: top center;" />
      </div>

      <div style="display: grid; grid-template-columns: 1fr 1fr; gap: 20px;">
        <div style="background: rgba(15, 19, 29, 0.7); border: 1px solid rgba(56, 189, 248, 0.25); border-radius: 14px; padding: 20px 22px;">
          <div style="font-size: 11px; font-weight: 700; color: #38BDF8; letter-spacing: 0.08em; text-transform: uppercase; margin-bottom: 6px;">📱 ANDROID CLIENT</div>
          <h4 style="font-size: 18px; color: #FFFFFF; font-weight: 700; margin-bottom: 8px;">Media3 ExoPlayer</h4>
          <p style="font-size: 13.5px; color: #94A3B8; line-height: 1.5;">Foreground background service, lock-screen session, and dynamic Material 3 theming.</p>
        </div>
        <div style="background: rgba(15, 19, 29, 0.7); border: 1px solid rgba(168, 85, 247, 0.25); border-radius: 14px; padding: 20px 22px;">
          <div style="font-size: 11px; font-weight: 700; color: #A78BFA; letter-spacing: 0.08em; text-transform: uppercase; margin-bottom: 6px;">💻 DESKTOP CLIENT</div>
          <h4 style="font-size: 18px; color: #FFFFFF; font-weight: 700; margin-bottom: 8px;">VLCJ Native C-Bindings</h4>
          <p style="font-size: 13.5px; color: #94A3B8; line-height: 1.5;">Gapless audio, Direct3D 60fps acceleration, 28-band FFT, and standalone portable execution.</p>
        </div>
      </div>
    </div>
    '''
    render_carousel_slide(3, "Cross-Platform", "ARCHITECTURE", s3_body)

    # Slide 4: Universal Catalog & In-App Cinema
    s4_body = f'''
    <div>
      <h2 style="font-size: 48px; font-weight: 700; letter-spacing: -0.02em; color: #FFFFFF; line-height: 1.15; margin-bottom: 16px;">
        Music & In-App Cinema.<br>All Under One Roof.
      </h2>
      <p style="font-size: 18px; color: #94A3B8; line-height: 1.5; margin-bottom: 24px;">
        One universal library that aggregates streaming platforms into a clean, ad-free station.
      </p>

      <div style="width: 100%; height: 350px; border-radius: 14px; overflow: hidden; border: 1px solid rgba(255, 255, 255, 0.12); box-shadow: 0 25px 60px -10px rgba(0,0,0,0.8); margin-bottom: 24px;">
        <img src="data:image/png;base64,{desktop_b64}" style="width: 100%; height: 100%; object-fit: cover; object-position: top center;" />
      </div>

      <div style="display: flex; flex-direction: column; gap: 14px;">
        <div style="background: rgba(15, 19, 29, 0.6); border: 1px solid rgba(255, 255, 255, 0.07); border-radius: 12px; padding: 16px 22px;">
          <h4 style="font-size: 16px; color: #C7D2FE; font-weight: 600; margin-bottom: 4px;">🎶 Decoupled Extension SPI</h4>
          <p style="font-size: 14px; color: #94A3B8; line-height: 1.4;">Modular plugin system supporting Spotify, JioSaavn, YouTube Music, SoundCloud, and global radio.</p>
        </div>
        <div style="background: rgba(15, 19, 29, 0.6); border: 1px solid rgba(255, 255, 255, 0.07); border-radius: 12px; padding: 16px 22px;">
          <h4 style="font-size: 16px; color: #C7D2FE; font-weight: 600; margin-bottom: 4px;">🎬 In-App Cinema Theater & Security Shield</h4>
          <p style="font-size: 14px; color: #94A3B8; line-height: 1.4;">Automated Cinemeta IMDb metadata mapping (`tt...`) inside a strictly popup-shielded container.</p>
        </div>
      </div>
    </div>
    '''
    render_carousel_slide(4, "Capabilities", "FEATURES", s4_body)

    # Slide 5: FFT Visualizer & AI Voice
    s5_body = '''
    <div>
      <h2 style="font-size: 52px; font-weight: 700; letter-spacing: -0.02em; color: #FFFFFF; line-height: 1.15; margin-bottom: 20px;">
        Engineered for Audiophiles<br>& Built with AI.
      </h2>
      <p style="font-size: 20px; color: #94A3B8; line-height: 1.6; margin-bottom: 48px;">
        Deep technical capabilities designed for precision, beauty, and convenience.
      </p>
      <div style="display: flex; flex-direction: column; gap: 24px;">
        <div style="background: rgba(15, 19, 29, 0.7); border: 1px solid rgba(52, 211, 153, 0.25); border-radius: 18px; padding: 30px 28px;">
          <div style="font-size: 12px; font-weight: 700; color: #34D399; letter-spacing: 0.08em; text-transform: uppercase; margin-bottom: 10px;">📊 28-BAND FFT VISUALIZER</div>
          <h3 style="font-size: 22px; color: #FFFFFF; font-weight: 700; margin-bottom: 10px;">Cooley-Tukey Radix-2 FFT Algorithm</h3>
          <p style="font-size: 15px; color: #94A3B8; line-height: 1.6;">Computes mathematical Fast Fourier Transforms directly over raw 512-point audio chunks with Hann windowing across 28 logarithmic frequency bands.</p>
        </div>
        <div style="background: rgba(15, 19, 29, 0.7); border: 1px solid rgba(56, 189, 248, 0.25); border-radius: 18px; padding: 30px 28px;">
          <div style="font-size: 12px; font-weight: 700; color: #38BDF8; letter-spacing: 0.08em; text-transform: uppercase; margin-bottom: 10px;">🎙️ DUAL AI SPEECH-TO-TEXT</div>
          <h3 style="font-size: 22px; color: #FFFFFF; font-weight: 700; margin-bottom: 10px;">Whisper Large V3 Turbo & Deepgram</h3>
          <p style="font-size: 15px; color: #94A3B8; line-height: 1.6;">Ultra-low-latency voice querying for songs and movies with real-time Voice Activity Detection. 100% ephemeral and private.</p>
        </div>
      </div>
    </div>
    '''
    render_carousel_slide(5, "Deep Tech", "DEEP TECH", s5_body)

    # Slide 6: Open Source & Community
    s6_body = '''
    <div style="display: flex; flex-direction: column; align-items: center; text-align: center;">
      <div style="width: 72px; height: 72px; border-radius: 20px; background: rgba(99, 102, 241, 0.12); border: 1px solid rgba(99, 102, 241, 0.25); display: flex; align-items: center; justify-content: center; font-size: 32px; color: #A78BFA; margin-bottom: 28px;">
        ⭐
      </div>
      <h2 style="font-size: 52px; font-weight: 800; letter-spacing: -0.02em; color: #FFFFFF; line-height: 1.15; margin-bottom: 18px;">
        100% Free & Open-Source
      </h2>
      <p style="font-size: 20px; color: #94A3B8; max-width: 680px; line-height: 1.6; margin-bottom: 40px;">
        Nightly is built for the developer and media community. Star the repository, test the release, or contribute!
      </p>

      <div style="background: rgba(15, 19, 29, 0.8); border: 1px solid rgba(255, 255, 255, 0.12); border-radius: 18px; padding: 28px 36px; max-width: 750px; width: 100%; margin-bottom: 34px;">
        <div style="font-size: 13px; color: #64748B; margin-bottom: 8px;">GITHUB REPOSITORY</div>
        <div style="font-size: 18px; color: #818CF8; font-weight: 600;">github.com/aaweshdas/Audix-Multiplatform-Music-Player</div>
      </div>

      <div style="display: flex; flex-direction: column; gap: 12px; margin-bottom: 36px; font-size: 16px; color: #CBD5E1;">
        <div>📦 <strong>Android:</strong> Download the verified APK from GitHub Releases</div>
        <div>💻 <strong>Desktop:</strong> Portable Windows ZIP (no installer needed)</div>
        <div>🛠️ <strong>Source:</strong> Build directly with Gradle & Android Studio</div>
      </div>

      <div style="font-size: 15px; color: #64748B;">
        Crafted with passion by <strong>Aawesh Das</strong> • Drop a comment or connect!
      </div>
    </div>
    '''
    render_carousel_slide(6, "Get Started", "OPEN SOURCE", s6_body, next_text="Done ✔")

    # Re-compile PDF
    slide_files = [os.path.join(slides_dir, f"Slide_{i+1}.png") for i in range(6)]
    pdf_path = os.path.join(base_dir, "Nightly_Showcase_Carousel.pdf")
    pil_imgs = [Image.open(f).convert("RGB") for f in slide_files]
    pil_imgs[0].save(pdf_path, save_all=True, append_images=pil_imgs[1:], quality=95)
    print(f"Updated Carousel PDF: {pdf_path} ({os.path.getsize(pdf_path)/1024:.1f} KB)")

build_hero_collage()
build_architecture()
build_mobile_showcase()
build_desktop_showcase()
build_cinema_showcase()
build_voice_showcase()
build_carousel()
