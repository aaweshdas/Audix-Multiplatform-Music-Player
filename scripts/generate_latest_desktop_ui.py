import os
import subprocess
import base64
from PIL import Image

edge_exe = r"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"
base_dir = r"S:\All Code\Antigravity\echo-nightly\linkedin-showcase"
images_dir = os.path.join(base_dir, "images")
os.makedirs(images_dir, exist_ok=True)

brain_dir = r"C:\Users\dasab\.gemini\antigravity\brain\b909a816-beee-46d1-91b6-bdd98f1af904"

# Load Nightly logo
logo_path = os.path.join(brain_dir, "nightly_app_logo_1793742061187.jpg")
with open(logo_path, "rb") as f:
    logo_b64 = base64.b64encode(f.read()).decode("utf-8")

# Resize background image to 1280x720 for fast embedding
bg_src = r"S:\All Code\Antigravity\echo-nightly\Background Image\Cyber-Industrial Ember Shards.png"
temp_bg = os.path.join(base_dir, "_temp_bg.jpg")
with Image.open(bg_src) as img:
    img.resize((1280, 720), Image.Resampling.LANCZOS).convert("RGB").save(temp_bg, quality=85)
with open(temp_bg, "rb") as f:
    bg_b64 = base64.b64encode(f.read()).decode("utf-8")
os.remove(temp_bg)

desktop_html = f'''<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
  * {{ box-sizing: border-box; margin: 0; padding: 0; }}
  body {{
    width: 1280px; height: 720px;
    background: #07090E;
    color: #F8FAFC;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
    overflow: hidden;
    display: flex;
    flex-direction: column;
    -webkit-font-smoothing: antialiased;
  }}

  /* Top Window Titlebar */
  .titlebar {{
    height: 38px;
    background: #0B0E17;
    border-bottom: 1px solid rgba(255, 255, 255, 0.08);
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 16px;
    user-select: none;
    z-index: 100;
  }}
  .win-controls {{
    display: flex;
    align-items: center;
    gap: 8px;
  }}
  .win-dot {{
    width: 11px; height: 11px;
    border-radius: 50%;
  }}
  .dot-close {{ background: #FF5F56; }}
  .dot-min {{ background: #FFBD2E; }}
  .dot-max {{ background: #27C93F; }}
  .win-title {{
    display: flex;
    align-items: center;
    gap: 8px;
    font-size: 12px;
    color: #94A3B8;
    font-weight: 500;
  }}
  .win-logo {{
    width: 16px; height: 16px;
    border-radius: 4px;
    object-fit: cover;
  }}
  .win-actions {{
    font-size: 11px;
    color: #64748B;
  }}

  /* Main Workspace */
  .workspace {{
    flex: 1;
    display: flex;
    position: relative;
    overflow: hidden;
    background-image: url("data:image/jpeg;base64,{bg_b64}");
    background-size: cover;
    background-position: center;
  }}
  .bg-overlay {{
    position: absolute;
    inset: 0;
    background: rgba(7, 9, 14, 0.88);
    backdrop-filter: blur(18px);
    z-index: 1;
  }}

  /* Sidebar */
  .sidebar {{
    width: 230px;
    background: rgba(11, 14, 23, 0.82);
    border-right: 1px solid rgba(255, 255, 255, 0.07);
    padding: 20px 14px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    z-index: 10;
    backdrop-filter: blur(20px);
  }}
  .brand {{
    display: flex;
    align-items: center;
    gap: 12px;
    margin-bottom: 24px;
    padding: 0 6px;
  }}
  .brand-logo {{
    width: 34px; height: 34px;
    border-radius: 9px;
    object-fit: cover;
    box-shadow: 0 4px 12px rgba(139, 92, 246, 0.4);
    border: 1px solid rgba(255, 255, 255, 0.15);
  }}
  .brand-text h3 {{
    font-size: 16px;
    font-weight: 700;
    color: #FFFFFF;
    letter-spacing: -0.01em;
  }}
  .brand-text span {{
    font-size: 10px;
    color: #818CF8;
    font-weight: 600;
    letter-spacing: 0.06em;
    text-transform: uppercase;
  }}

  .nav-group {{
    display: flex;
    flex-direction: column;
    gap: 3px;
    margin-bottom: 20px;
  }}
  .nav-label {{
    font-size: 10px;
    font-weight: 700;
    letter-spacing: 0.08em;
    color: #475569;
    text-transform: uppercase;
    padding: 0 10px;
    margin-bottom: 6px;
  }}
  .nav-item {{
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 8px 12px;
    border-radius: 8px;
    font-size: 13px;
    color: #94A3B8;
    font-weight: 500;
    transition: all 0.2s;
  }}
  .nav-item.active {{
    background: rgba(139, 92, 246, 0.15);
    color: #FFFFFF;
    border: 1px solid rgba(139, 92, 246, 0.3);
  }}
  .nav-item .icon {{
    font-size: 14px;
    width: 18px;
    text-align: center;
  }}
  .nav-item .badge-new {{
    margin-left: auto;
    font-size: 9px;
    padding: 2px 6px;
    border-radius: 4px;
    background: #8B5CF6;
    color: #FFFFFF;
    font-weight: 700;
    letter-spacing: 0.05em;
  }}

  .engine-status {{
    background: rgba(15, 23, 42, 0.7);
    border: 1px solid rgba(255, 255, 255, 0.08);
    border-radius: 10px;
    padding: 10px 12px;
    display: flex;
    align-items: center;
    gap: 10px;
  }}
  .status-dot {{
    width: 8px; height: 8px;
    border-radius: 50%;
    background: #10B981;
    box-shadow: 0 0 8px #10B981;
  }}
  .status-info h5 {{
    font-size: 11px;
    color: #FFFFFF;
    font-weight: 600;
  }}
  .status-info span {{
    font-size: 10px;
    color: #64748B;
  }}

  /* Content Area */
  .content {{
    flex: 1;
    padding: 24px 32px;
    display: flex;
    flex-direction: column;
    gap: 20px;
    z-index: 10;
    overflow: hidden;
  }}

  /* Hero Card */
  .hero-card {{
    background: rgba(18, 24, 38, 0.7);
    border: 1px solid rgba(255, 255, 255, 0.09);
    border-radius: 14px;
    padding: 20px 24px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
  }}
  .hero-left h2 {{
    font-size: 22px;
    font-weight: 700;
    color: #FFFFFF;
    margin-bottom: 4px;
  }}
  .hero-left p {{
    font-size: 13px;
    color: #94A3B8;
  }}

  /* 28-band FFT Spectrum Visualizer */
  .fft-container {{
    display: flex;
    align-items: flex-end;
    gap: 3.5px;
    height: 48px;
    padding: 4px 8px;
    background: rgba(10, 14, 24, 0.6);
    border-radius: 8px;
    border: 1px solid rgba(255, 255, 255, 0.05);
  }}
  .fft-bar {{
    width: 5px;
    border-radius: 2px 2px 0 0;
    background: linear-gradient(to top, #38BDF8 0%, #818CF8 60%, #C084FC 100%);
  }}

  /* Shelves */
  .shelf-header {{
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 12px;
  }}
  .shelf-header h4 {{
    font-size: 15px;
    font-weight: 600;
    color: #FFFFFF;
    letter-spacing: -0.01em;
  }}
  .shelf-header span {{
    font-size: 12px;
    color: #818CF8;
    font-weight: 500;
    cursor: pointer;
  }}

  .shelf-grid {{
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 16px;
  }}
  .track-card {{
    background: rgba(15, 20, 32, 0.65);
    border: 1px solid rgba(255, 255, 255, 0.06);
    border-radius: 10px;
    padding: 10px;
    display: flex;
    flex-direction: column;
    gap: 10px;
  }}
  .track-thumb {{
    width: 100%;
    height: 110px;
    border-radius: 8px;
    background: linear-gradient(135deg, #1E1B4B, #0F172A);
    position: relative;
    overflow: hidden;
    display: flex;
    align-items: center;
    justify-content: center;
  }}
  .thumb-art {{
    width: 100%; height: 100%;
    object-fit: cover;
  }}
  .thumb-overlay {{
    position: absolute;
    inset: 0;
    background: rgba(0, 0, 0, 0.3);
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 24px;
    color: #FFFFFF;
    opacity: 0.9;
  }}
  .track-details h5 {{
    font-size: 13px;
    color: #FFFFFF;
    font-weight: 600;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
  }}
  .track-details p {{
    font-size: 11px;
    color: #94A3B8;
  }}

  /* Docked MiniPlayer */
  .miniplayer {{
    height: 72px;
    background: rgba(11, 14, 23, 0.92);
    border-top: 1px solid rgba(255, 255, 255, 0.08);
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 24px;
    z-index: 100;
    backdrop-filter: blur(24px);
  }}
  .player-track {{
    display: flex;
    align-items: center;
    gap: 14px;
    width: 280px;
  }}
  .player-thumb {{
    width: 48px; height: 48px;
    border-radius: 8px;
    object-fit: cover;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.5);
  }}
  .track-meta h4 {{
    font-size: 13.5px;
    font-weight: 600;
    color: #FFFFFF;
  }}
  .track-meta p {{
    font-size: 11.5px;
    color: #94A3B8;
  }}
  .heart-btn {{
    color: #EC4899;
    font-size: 15px;
    margin-left: 6px;
  }}

  /* Center Controls */
  .player-center {{
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 6px;
    width: 460px;
  }}
  .controls-row {{
    display: flex;
    align-items: center;
    gap: 20px;
  }}
  .ctl-btn {{
    font-size: 15px;
    color: #94A3B8;
    cursor: pointer;
  }}
  .play-btn {{
    width: 34px; height: 34px;
    border-radius: 50%;
    background: linear-gradient(135deg, #8B5CF6, #6366F1);
    color: #FFFFFF;
    display: flex; align-items: center; justify-content: center;
    font-size: 14px;
    box-shadow: 0 4px 14px rgba(139, 92, 246, 0.5);
  }}
  .scrubber-row {{
    display: flex;
    align-items: center;
    gap: 10px;
    width: 100%;
    font-size: 11px;
    color: #64748B;
  }}
  .progress-bar {{
    flex: 1;
    height: 4px;
    background: rgba(255, 255, 255, 0.1);
    border-radius: 2px;
    position: relative;
    overflow: hidden;
  }}
  .progress-fill {{
    width: 42%;
    height: 100%;
    background: linear-gradient(to right, #818CF8, #A78BFA);
    border-radius: 2px;
  }}

  /* Right Tools */
  .player-right {{
    display: flex;
    align-items: center;
    gap: 18px;
    width: 280px;
    justify-content: flex-end;
  }}
  .vol-row {{
    display: flex;
    align-items: center;
    gap: 8px;
  }}
  .vol-bar {{
    width: 80px; height: 4px;
    background: rgba(255, 255, 255, 0.1);
    border-radius: 2px;
    overflow: hidden;
  }}
  .vol-fill {{
    width: 75%; height: 100%;
    background: #94A3B8;
  }}
  .mini-fft {{
    display: flex;
    align-items: flex-end;
    gap: 2px;
    height: 16px;
  }}
  .m-bar {{
    width: 2.5px;
    background: #818CF8;
    border-radius: 1px;
  }}
</style>
</head>
<body>
  <!-- Window Titlebar -->
  <div class="titlebar">
    <div class="win-controls">
      <div class="win-dot dot-close"></div>
      <div class="win-dot dot-min"></div>
      <div class="win-dot dot-max"></div>
    </div>
    <div class="win-title">
      <img class="win-logo" src="data:image/jpeg;base64,{logo_b64}" />
      <span>Nightly — v1.0.4 • Kotlin Multiplatform Audio & Cinema</span>
    </div>
    <div class="win-actions">Direct3D 60 FPS</div>
  </div>

  <!-- Workspace -->
  <div class="workspace">
    <div class="bg-overlay"></div>

    <!-- Sidebar -->
    <div class="sidebar">
      <div>
        <div class="brand">
          <img class="brand-logo" src="data:image/jpeg;base64,{logo_b64}" />
          <div class="brand-text">
            <h3>NIGHTLY</h3>
            <span>Desktop Player</span>
          </div>
        </div>

        <div class="nav-group">
          <div class="nav-label">Discovery</div>
          <div class="nav-item active">
            <span class="icon">🏠</span>
            <span>Home</span>
          </div>
          <div class="nav-item">
            <span class="icon">🔍</span>
            <span>Search</span>
          </div>
          <div class="nav-item">
            <span class="icon">🎬</span>
            <span>Movie Play</span>
            <span class="badge-new">NEW</span>
          </div>
          <div class="nav-item">
            <span class="icon">📊</span>
            <span>Visualizer</span>
          </div>
        </div>

        <div class="nav-group">
          <div class="nav-label">Library</div>
          <div class="nav-item">
            <span class="icon">💖</span>
            <span>Liked Songs</span>
          </div>
          <div class="nav-item">
            <span class="icon">📁</span>
            <span>Local Tracks</span>
          </div>
          <div class="nav-item">
            <span class="icon">⬇️</span>
            <span>Downloads</span>
          </div>
        </div>
      </div>

      <!-- Engine Status -->
      <div class="engine-status">
        <div class="status-dot"></div>
        <div class="status-info">
          <h5>libVLC C-Engine Active</h5>
          <span>Gapless • 28-Band FFT</span>
        </div>
      </div>
    </div>

    <!-- Content Area -->
    <div class="content">
      <!-- Hero Discovery Card -->
      <div class="hero-card">
        <div class="hero-left">
          <h2>Good Evening, Audiophile 🌙</h2>
          <p>Active Engine: libVLC 3.x Native C-Bindings • Low-Latency Direct3D Pipeline</p>
        </div>

        <!-- 28-Band FFT Spectrum -->
        <div class="fft-container">
          <div class="fft-bar" style="height: 18px;"></div>
          <div class="fft-bar" style="height: 28px;"></div>
          <div class="fft-bar" style="height: 38px;"></div>
          <div class="fft-bar" style="height: 44px;"></div>
          <div class="fft-bar" style="height: 32px;"></div>
          <div class="fft-bar" style="height: 22px;"></div>
          <div class="fft-bar" style="height: 35px;"></div>
          <div class="fft-bar" style="height: 46px;"></div>
          <div class="fft-bar" style="height: 40px;"></div>
          <div class="fft-bar" style="height: 26px;"></div>
          <div class="fft-bar" style="height: 34px;"></div>
          <div class="fft-bar" style="height: 48px;"></div>
          <div class="fft-bar" style="height: 38px;"></div>
          <div class="fft-bar" style="height: 25px;"></div>
          <div class="fft-bar" style="height: 30px;"></div>
          <div class="fft-bar" style="height: 42px;"></div>
          <div class="fft-bar" style="height: 36px;"></div>
          <div class="fft-bar" style="height: 20px;"></div>
          <div class="fft-bar" style="height: 28px;"></div>
          <div class="fft-bar" style="height: 39px;"></div>
          <div class="fft-bar" style="height: 31px;"></div>
          <div class="fft-bar" style="height: 24px;"></div>
          <div class="fft-bar" style="height: 16px;"></div>
          <div class="fft-bar" style="height: 12px;"></div>
        </div>
      </div>

      <!-- Top Rotation Shelf -->
      <div>
        <div class="shelf-header">
          <h4>Top Rotation & Trending Now</h4>
          <span>View All (148) ➔</span>
        </div>
        <div class="shelf-grid">
          <!-- Track 1 -->
          <div class="track-card">
            <div class="track-thumb" style="background: linear-gradient(135deg, #312E81, #1E1B4B);">
              <div class="thumb-overlay">▶</div>
            </div>
            <div class="track-details">
              <h5>Die With A Smile</h5>
              <p>Lady Gaga & Bruno Mars</p>
            </div>
          </div>
          <!-- Track 2 -->
          <div class="track-card">
            <div class="track-thumb" style="background: linear-gradient(135deg, #1E3A8A, #0F172A);">
              <div class="thumb-overlay">▶</div>
            </div>
            <div class="track-details">
              <h5>Starboy</h5>
              <p>The Weeknd, Daft Punk</p>
            </div>
          </div>
          <!-- Track 3 -->
          <div class="track-card">
            <div class="track-thumb" style="background: linear-gradient(135deg, #4C1D95, #312E81);">
              <div class="thumb-overlay">▶</div>
            </div>
            <div class="track-details">
              <h5>Birds of a Feather</h5>
              <p>Billie Eilish</p>
            </div>
          </div>
          <!-- Track 4 (Movie Play highlight) -->
          <div class="track-card">
            <div class="track-thumb" style="background: linear-gradient(135deg, #701A75, #4A044E);">
              <div class="thumb-overlay">🎬</div>
            </div>
            <div class="track-details">
              <h5>Interstellar (Cinema)</h5>
              <p>Christopher Nolan • 4K HDR</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Docked MiniPlayer -->
  <div class="miniplayer">
    <div class="player-track">
      <img class="player-thumb" src="data:image/jpeg;base64,{logo_b64}" />
      <div class="track-meta">
        <h4>Die With A Smile</h4>
        <p>Lady Gaga & Bruno Mars</p>
      </div>
      <span class="heart-btn">♥</span>
    </div>

    <!-- Center Playback Controls -->
    <div class="player-center">
      <div class="controls-row">
        <span class="ctl-btn">🔀</span>
        <span class="ctl-btn">⏮</span>
        <div class="play-btn">⏸</div>
        <span class="ctl-btn">⏭</span>
        <span class="ctl-btn">🔁</span>
      </div>
      <div class="scrubber-row">
        <span>01:42</span>
        <div class="progress-bar">
          <div class="progress-fill"></div>
        </div>
        <span>04:12</span>
      </div>
    </div>

    <!-- Right Controls -->
    <div class="player-right">
      <div class="mini-fft">
        <div class="m-bar" style="height: 6px;"></div>
        <div class="m-bar" style="height: 14px;"></div>
        <div class="m-bar" style="height: 10px;"></div>
        <div class="m-bar" style="height: 16px;"></div>
        <div class="m-bar" style="height: 8px;"></div>
      </div>
      <div class="vol-row">
        <span style="font-size: 13px; color: #94A3B8;">🔊</span>
        <div class="vol-bar">
          <div class="vol-fill"></div>
        </div>
      </div>
      <span style="font-size: 13px; color: #94A3B8; cursor: pointer;">📜</span>
    </div>
  </div>
</body>
</html>'''

out_desktop = os.path.join(images_dir, "latest_nightly_desktop_ui.png")
temp_html = os.path.join(base_dir, "_temp_desktop.html")
with open(temp_html, "w", encoding="utf-8") as f:
    f.write(desktop_html)

cmd = [
    edge_exe,
    "--headless=new",
    "--disable-gpu",
    "--hide-scrollbars",
    "--window-size=1280,720",
    f"--screenshot={out_desktop}",
    f"file:///{temp_html}"
]
subprocess.run(cmd, capture_output=True)
if os.path.exists(temp_html):
    os.remove(temp_html)
print(f"Generated Latest Desktop UI: {out_desktop} ({os.path.getsize(out_desktop)/1024:.1f} KB)")
