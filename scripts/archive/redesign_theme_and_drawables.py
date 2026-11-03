import os

ROOT = r"S:\All Code\Antigravity\echo-nightly\app\src\main\res"

# 1. Update values/colors.xml
colors_xml = os.path.join(ROOT, "values", "colors.xml")
colors_content = """<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Audix Cosmic Obsidian & Liquid Glass Palette -->
    <color name="audix_bg">#070A12</color>
    <color name="audix_bg_surface">#0D1322</color>
    <color name="audix_bg_card">#111A2E</color>
    <color name="audix_bg_overlay">#182238</color>
    <color name="audix_border">#1E2B45</color>
    <color name="audix_border_highlight">#38BDF8</color>

    <!-- Audix Signature Accents -->
    <color name="audix_cyan">#06B6D4</color>
    <color name="audix_cyan_bright">#38BDF8</color>
    <color name="audix_crimson">#E11D48</color>
    <color name="audix_purple">#8B5CF6</color>
    <color name="audix_gold">#FBBF24</color>
    <color name="audix_emerald">#10B981</color>

    <!-- High-Contrast Typography -->
    <color name="audix_white">#FFFFFF</color>
    <color name="audix_text_primary">#FFFFFF</color>
    <color name="audix_text_secondary">#94A3B8</color>
    <color name="audix_text_muted">#64748B</color>

    <!-- Base Compatibility Definitions -->
    <color name="black">#FF000000</color>
    <color name="white">#FFFFFFFF</color>
    <color name="app_color">#06B6D4</color>
    <color name="app_color_highlight">#38BDF8</color>
    <color name="app_color_shadow">#06B6D4</color>
    <color name="amoled_bg">#070A12</color>
    <color name="amoled_bg_semi">#80070A12</color>
    <color name="amoled_fg">#FFFFFFFF</color>
    <color name="amoled_fg_semi">#33FFFFFF</color>
</resources>
"""
with open(colors_xml, "w", encoding="utf-8") as f:
    f.write(colors_content)
print("[OK] Updated values/colors.xml with Audix Cosmic Obsidian palette")

# 2. Update values-night/colors.xml
colors_night_xml = os.path.join(ROOT, "values-night", "colors.xml")
colors_night_content = """<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="amoled_bg">#070A12</color>
    <color name="amoled_bg_semi">#80070A12</color>
    <color name="amoled_fg">#FFFFFFFF</color>
    <color name="amoled_fg_semi">#33FFFFFF</color>
    <color name="app_color">#06B6D4</color>
    <color name="app_color_highlight">#38BDF8</color>
    <color name="app_color_shadow">#06B6D4</color>
</resources>
"""
with open(colors_night_xml, "w", encoding="utf-8") as f:
    f.write(colors_night_content)
print("[OK] Updated values-night/colors.xml")

# 3. Update values/themes.xml
themes_xml = os.path.join(ROOT, "values", "themes.xml")
themes_content = """<resources xmlns:tools="http://schemas.android.com/tools">

    <style name="Base.Theme.Echo" parent="Theme.Material3Expressive.DynamicColors.DayNight.NoActionBar">
        <item name="android:windowSplashScreenBackground" tools:targetApi="s">
            @color/audix_bg
        </item>
        <item name="android:windowSplashScreenAnimatedIcon" tools:targetApi="s">
            @drawable/art_splash_anim
        </item>
        <item name="android:windowSplashScreenAnimationDuration" tools:targetApi="s">900</item>
        <item name="android:windowSplashScreenBehavior" tools:targetApi="TIRAMISU">
            icon_preferred
        </item>
        <item name="android:windowSplashScreenBrandingImage" tools:targetApi="s">
            @drawable/art_brand
        </item>
        <item name="android:colorBackground">@color/audix_bg</item>
        <item name="snackbarStyle">@style/EchoSnackBar</item>
        <item name="android:dialogTheme">@style/EchoDialog</item>
        <item name="materialAlertDialogTheme">@style/EchoAlertDialog</item>
        <item name="bottomSheetDialogTheme">@style/EchoBottomSheetDialog</item>
        <item name="appBarLayoutStyle">@style/EchoAppBarLayout</item>
        <item name="actionButtonStyle">@style/EchoActionButton</item>
        <item name="collapsingToolbarLayoutStyle">@style/EchoCollapsingBar</item>
        <item name="cardViewStyle">@style/EchoCardView</item>
        <item name="tabStyle">@style/EchoTabLayout</item>
        <item name="circularProgressIndicatorStyle">@style/EchoCircularProgressIndicator</item>
        <item name="linearProgressIndicatorStyle">@style/EchoLinearProgressIndicator</item>

        <item name="echoBackground">@color/audix_bg</item>
        <item name="navBackground">@color/audix_bg_surface</item>

        <item name="itemCoverSize">100dp</item>
        <item name="itemCorner">16dp</item>
    </style>

    <style name="Default" parent="Base.Theme.Echo">
        <item name="echoBackground">@color/audix_bg</item>
        <item name="navBackground">@color/audix_bg_surface</item>
        <item name="navBarForeground">@color/audix_cyan</item>
        <item name="navBarBackground">@color/audix_bg_card</item>
        <item name="android:colorBackground">@color/audix_bg</item>
    </style>

    <style name="Amoled" parent="Default">
        <item name="echoBackground">@color/audix_bg</item>
        <item name="navBackground">@color/audix_bg_surface</item>
    </style>

    <style name="BigCover" parent="Default">
        <item name="itemCoverSize">136dp</item>
    </style>

    <style name="AmoledBigCover" parent="Amoled">
        <item name="itemCoverSize">136dp</item>
    </style>
</resources>
"""
with open(themes_xml, "w", encoding="utf-8") as f:
    f.write(themes_content)
print("[OK] Updated values/themes.xml")

# 4. Update values-night/themes.xml
themes_night_xml = os.path.join(ROOT, "values-night", "themes.xml")
themes_night_content = """<resources>
    <style name="Default" parent="Base.Theme.Echo">
        <item name="echoBackground">@color/audix_bg</item>
        <item name="navBackground">@color/audix_bg_surface</item>
        <item name="navBarForeground">@color/audix_cyan</item>
        <item name="navBarBackground">@color/audix_bg_card</item>
        <item name="android:colorBackground">@color/audix_bg</item>
    </style>
</resources>
"""
with open(themes_night_xml, "w", encoding="utf-8") as f:
    f.write(themes_night_content)
print("[OK] Updated values-night/themes.xml")

# 5. Create new drawables in drawable/
drawables_dir = os.path.join(ROOT, "drawable")

# 5a. bg_audix_header_card.xml
with open(os.path.join(drawables_dir, "bg_audix_header_card.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:angle="315"
        android:startColor="#131B2E"
        android:centerColor="#0E1626"
        android:endColor="#080D1A"
        android:type="linear" />
    <corners android:radius="20dp" />
    <stroke android:width="1.2dp" android:color="#26354D" />
</shape>
""")

# 5b. bg_audix_badge_lossless.xml
with open(os.path.join(drawables_dir, "bg_audix_badge_lossless.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#0F241E" />
    <corners android:radius="12dp" />
    <stroke android:width="1dp" android:color="#10B981" />
</shape>
""")

# 5c. bg_audix_badge_soundstage.xml
with open(os.path.join(drawables_dir, "bg_audix_badge_soundstage.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#0F2038" />
    <corners android:radius="12dp" />
    <stroke android:width="1dp" android:color="#38BDF8" />
</shape>
""")

# 5d. bg_audix_badge_cinema.xml
with open(os.path.join(drawables_dir, "bg_audix_badge_cinema.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#2B0C15" />
    <corners android:radius="12dp" />
    <stroke android:width="1dp" android:color="#E11D48" />
</shape>
""")

# 5e. bg_audix_card_glass.xml
with open(os.path.join(drawables_dir, "bg_audix_card_glass.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#B30E1626" />
    <corners android:radius="16dp" />
    <stroke android:width="1dp" android:color="#1E2B45" />
</shape>
""")

# 5f. bg_audix_miniplayer_dock.xml
with open(os.path.join(drawables_dir, "bg_audix_miniplayer_dock.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <gradient
        android:angle="270"
        android:startColor="#F00F172A"
        android:endColor="#FA090D18"
        android:type="linear" />
    <corners android:radius="18dp" />
    <stroke android:width="1.2dp" android:color="#2A3D5E" />
</shape>
""")

# 5g. bg_audix_play_neon.xml
with open(os.path.join(drawables_dir, "bg_audix_play_neon.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <gradient
        android:angle="45"
        android:startColor="#06B6D4"
        android:centerColor="#3B82F6"
        android:endColor="#8B5CF6"
        android:type="linear" />
</shape>
""")

# 5h. bg_audix_pill_filter.xml
with open(os.path.join(drawables_dir, "bg_audix_pill_filter.xml"), "w", encoding="utf-8") as f:
    f.write("""<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android">
    <solid android:color="#0F172A" />
    <corners android:radius="16dp" />
    <stroke android:width="1dp" android:color="#1E2B45" />
</shape>
""")

print("[OK] Created custom Audix glass drawables in drawable/")
