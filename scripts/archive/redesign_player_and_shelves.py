import os

ROOT = r"S:\All Code\Antigravity\echo-nightly\app\src\main\res\layout"

# 1. Redesign item_shelf_header.xml
shelf_header_path = os.path.join(ROOT, "item_shelf_header.xml")
shelf_header_content = """<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:gravity="center_vertical"
    android:layout_marginStart="-20dp"
    android:layout_marginEnd="-20dp"
    android:paddingHorizontal="20dp"
    android:clipToPadding="false"
    android:layout_marginVertical="6dp"
    android:minHeight="48dp">

    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="4dp"
        android:layout_marginVertical="6dp"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/subtitle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@color/audix_cyan_bright"
            android:textSize="10.5sp"
            android:textStyle="bold"
            android:letterSpacing="0.06"
            android:textAllCaps="true"
            android:visibility="gone"
            tools:text="STUDIO SOUNDTRACKS" />

        <TextView
            android:id="@+id/title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ellipsize="end"
            android:maxLines="1"
            android:textColor="@color/audix_white"
            android:textSize="20sp"
            android:textStyle="bold"
            android:letterSpacing="-0.02"
            tools:text="Movie Play &amp; Blockbusters" />

    </LinearLayout>

    <com.google.android.material.button.MaterialButton
        android:id="@+id/shuffle"
        style="@style/IconButtonSecondary"
        android:contentDescription="@string/shuffle"
        app:icon="@drawable/ic_shuffle"
        app:iconTint="@color/audix_cyan" />

    <com.google.android.material.button.MaterialButton
        android:id="@+id/more"
        android:layout_marginEnd="-8dp"
        style="@style/IconButtonTransparent"
        android:contentDescription="@string/more"
        android:scaleX="-1"
        app:icon="@drawable/ic_back"
        app:iconTint="@color/audix_text_secondary" />
</LinearLayout>
"""
with open(shelf_header_path, "w", encoding="utf-8") as f:
    f.write(shelf_header_content)
print("[OK] Redesigned item_shelf_header.xml")

# 2. Redesign item_shelf_lists_media.xml
lists_media_path = os.path.join(ROOT, "item_shelf_lists_media.xml")
lists_media_content = """<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    style="@style/Selectable"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:clipToPadding="false"
    android:orientation="vertical"
    android:padding="6dp">

    <include
        android:id="@+id/coverContainer"
        layout="@layout/item_shelf_media_cover_big" />

    <TextView
        android:id="@+id/title"
        android:layout_width="?itemCoverSize"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:ellipsize="end"
        android:gravity="center_vertical"
        android:maxLines="1"
        android:textColor="@color/audix_white"
        android:textSize="13sp"
        android:textStyle="bold"
        tools:text="@tools:sample/full_names" />

    <TextView
        android:id="@+id/subtitle"
        android:layout_width="?itemCoverSize"
        android:layout_height="wrap_content"
        android:ellipsize="end"
        android:gravity="center_vertical"
        android:maxLines="1"
        android:textColor="@color/audix_text_secondary"
        android:textSize="11.5sp"
        tools:text="@tools:sample/full_names" />

</LinearLayout>
"""
with open(lists_media_path, "w", encoding="utf-8") as f:
    f.write(lists_media_content)
print("[OK] Redesigned item_shelf_lists_media.xml")

# 3. Redesign item_player_collapsed_controls.xml
col_ctrl_path = os.path.join(ROOT, "item_player_collapsed_controls.xml")
col_ctrl_content = """<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/player_collapsed_container"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginHorizontal="10dp"
    android:layout_marginVertical="6dp"
    android:elevation="10dp"
    android:background="@drawable/bg_audix_miniplayer_dock">

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="@dimen/collapsed_cover_size"
        android:layout_gravity="end"
        android:gravity="center_vertical"
        android:paddingEnd="10dp">

        <FrameLayout
            android:id="@+id/collapsedPlayPauseContainer"
            android:layout_width="42dp"
            android:layout_height="42dp"
            android:layout_gravity="center"
            android:background="@drawable/bg_audix_play_neon">

            <com.google.android.material.progressindicator.CircularProgressIndicator
                android:id="@+id/collapsedPlayingIndicator"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_gravity="center"
                android:clickable="false"
                android:indeterminate="true"
                app:indicatorColor="@color/audix_white"
                app:indicatorSize="34dp" />

            <com.google.android.material.checkbox.MaterialCheckBox
                android:id="@+id/collapsedTrackPlayPause"
                android:layout_width="42dp"
                android:layout_height="42dp"
                android:background="@drawable/ripple_44dp"
                android:button="@drawable/anim_play_pause"
                android:contentDescription="@string/play"
                app:buttonTint="@color/audix_white" />

        </FrameLayout>

        <com.google.android.material.button.MaterialButton
            android:id="@+id/player_close"
            style="?attr/materialIconButtonStyle"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="4dp"
            android:contentDescription="@string/close"
            android:padding="8dp"
            android:background="@drawable/ripple_44dp"
            app:icon="@drawable/ic_close"
            app:iconTint="@color/audix_text_secondary" />
    </LinearLayout>

</FrameLayout>
"""
with open(col_ctrl_path, "w", encoding="utf-8") as f:
    f.write(col_ctrl_content)
print("[OK] Redesigned item_player_collapsed_controls.xml")

# 4. Redesign item_player_collapsed.xml
col_info_path = os.path.join(ROOT, "item_player_collapsed.xml")
col_info_content = """<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    style="@style/Selectable"
    android:layout_width="match_parent"
    android:layout_height="@dimen/collapsed_cover_size"
    android:layout_marginHorizontal="10dp"
    android:layout_marginVertical="6dp">

    <LinearLayout
        android:id="@+id/collapsedPlayerInfo"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:baselineAligned="false"
        android:gravity="center_vertical"
        android:orientation="horizontal"
        android:paddingStart="8dp">

        <View
            android:layout_width="@dimen/collapsed_cover_size"
            android:layout_height="@dimen/collapsed_cover_size" />

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_marginStart="14dp"
            android:layout_weight="1"
            android:baselineAligned="false"
            android:gravity="center_vertical"
            android:orientation="vertical">

            <TextView
                android:id="@+id/collapsedTrackTitle"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:ellipsize="marquee"
                android:maxLines="1"
                android:textColor="@color/audix_white"
                android:textSize="14sp"
                android:textStyle="bold"
                tools:text="Tum Hi Ho" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="2dp"
                android:gravity="center_vertical"
                android:orientation="horizontal">

                <TextView
                    android:id="@+id/collapsedTrackArtist"
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:ellipsize="marquee"
                    android:maxLines="1"
                    android:textColor="@color/audix_text_secondary"
                    android:textSize="11.5sp"
                    tools:text="Arijit Singh • Aashiqui 2" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="6dp"
                    android:background="@drawable/bg_audix_badge_lossless"
                    android:paddingHorizontal="6dp"
                    android:paddingVertical="1.5dp"
                    android:text="320K"
                    android:textColor="@color/audix_emerald"
                    android:textSize="8.5sp"
                    android:textStyle="bold" />
            </LinearLayout>
        </LinearLayout>

        <View
            android:layout_width="104dp"
            android:layout_height="@dimen/collapsed_cover_size" />
    </LinearLayout>
</FrameLayout>
"""
with open(col_info_path, "w", encoding="utf-8") as f:
    f.write(col_info_content)
print("[OK] Redesigned item_player_collapsed.xml")

# 5. Redesign item_player_controls.xml
controls_path = os.path.join(ROOT, "item_player_controls.xml")
with open(controls_path, "r", encoding="utf-8") as f:
    ctrl_text = f.read()

# Enhance playPauseContainer with neon glowing gradient
ctrl_text = ctrl_text.replace(
    'android:id="@+id/playPauseContainer"',
    'android:id="@+id/playPauseContainer"\n            android:background="@drawable/bg_audix_play_neon"'
)

# Enhance trackTitle with bold pure white
ctrl_text = ctrl_text.replace(
    'android:id="@+id/trackTitle"',
    'android:id="@+id/trackTitle"\n                android:textColor="@color/audix_white"\n                android:letterSpacing="-0.02"'
)

# Enhance trackArtist with muted slate
ctrl_text = ctrl_text.replace(
    'android:id="@+id/trackArtist"',
    'android:id="@+id/trackArtist"\n                android:textColor="@color/audix_text_secondary"'
)

# Enhance seekbar with Audix cyan accents
ctrl_text = ctrl_text.replace('app:thumbColor="?attr/colorTertiary"', 'app:thumbColor="@color/audix_cyan"')
ctrl_text = ctrl_text.replace('app:trackColorActive="?attr/colorTertiary"', 'app:trackColorActive="@color/audix_cyan"')
ctrl_text = ctrl_text.replace('app:indicatorColor="?attr/colorTertiary"', 'app:indicatorColor="@color/audix_cyan_bright"')

with open(controls_path, "w", encoding="utf-8") as f:
    f.write(ctrl_text)
print("[OK] Redesigned item_player_controls.xml with neon play button & cyan seekbar")
