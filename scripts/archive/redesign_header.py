import os

ROOT = r"S:\All Code\Antigravity\echo-nightly\app\src\main"

# 1. Redesign item_main_header.xml
header_layout_path = os.path.join(ROOT, "res", "layout", "item_main_header.xml")
header_xml_content = """<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginStart="-20dp"
    android:layout_marginEnd="-20dp"
    android:layout_marginBottom="12dp"
    android:clipToPadding="false"
    android:orientation="vertical"
    android:paddingHorizontal="20dp">

    <!-- 1. TOP BRANDING & WORKSTATION BAR -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        android:orientation="horizontal"
        android:paddingVertical="8dp">

        <!-- Audix Studio Icon & Identity -->
        <com.google.android.material.card.MaterialCardView
            android:layout_width="38dp"
            android:layout_height="38dp"
            app:cardBackgroundColor="#131B2E"
            app:cardCornerRadius="12dp"
            app:strokeColor="#22334F"
            app:strokeWidth="1.2dp">

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:padding="5dp"
                android:src="@drawable/ic_audix_logo"
                android:importantForAccessibility="no" />
        </com.google.android.material.card.MaterialCardView>

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="10dp"
            android:layout_weight="1"
            android:orientation="vertical">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Audix"
                android:textColor="@color/audix_white"
                android:textSize="18sp"
                android:textStyle="bold"
                android:letterSpacing="-0.02" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="v1.0.4-UNIFIED • Hi-Res Studio"
                android:textColor="@color/audix_cyan_bright"
                android:textSize="10.5sp"
                android:textStyle="bold"
                android:letterSpacing="0.04" />
        </LinearLayout>

        <!-- Active Source / Extension Pill -->
        <com.google.android.material.card.MaterialCardView
            android:id="@+id/extensionsCont"
            android:layout_width="wrap_content"
            android:layout_height="36dp"
            android:layout_marginEnd="6dp"
            app:cardBackgroundColor="#111A2E"
            app:cardCornerRadius="18dp"
            app:strokeColor="#1E2B45"
            app:strokeWidth="1dp">

            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:gravity="center_vertical"
                android:paddingHorizontal="10dp">

                <ImageView
                    android:id="@+id/extensions"
                    android:layout_width="18dp"
                    android:layout_height="18dp"
                    android:contentDescription="@string/extensions"
                    android:src="@drawable/ic_extension_32dp"
                    app:tint="@color/audix_cyan" />

                <TextView
                    android:id="@+id/title"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="6dp"
                    android:ellipsize="end"
                    android:maxLines="1"
                    android:maxWidth="110dp"
                    android:text="@string/app_name"
                    android:textColor="@color/audix_white"
                    android:textSize="12sp"
                    android:textStyle="bold" />
            </LinearLayout>
        </com.google.android.material.card.MaterialCardView>

        <!-- Settings / Account Button -->
        <com.google.android.material.card.MaterialCardView
            android:id="@+id/accountsCont"
            android:layout_width="36dp"
            android:layout_height="36dp"
            app:cardBackgroundColor="#111A2E"
            app:cardCornerRadius="18dp"
            app:strokeColor="#1E2B45"
            app:strokeWidth="1dp">

            <ImageView
                android:id="@+id/accounts"
                android:layout_width="20dp"
                android:layout_height="20dp"
                android:layout_gravity="center"
                android:contentDescription="@string/extensions"
                android:src="@drawable/ic_settings_outline_32dp"
                app:tint="@color/audix_white" />
        </com.google.android.material.card.MaterialCardView>

    </LinearLayout>

    <!-- 2. FLAGSHIP DESKTOP-STYLE STUDIO HERO CARD -->
    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        android:background="@drawable/bg_audix_header_card"
        android:padding="16dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <!-- Top Quality & Soundstage Badges -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:gravity="center_vertical"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:background="@drawable/bg_audix_badge_lossless"
                    android:paddingHorizontal="8dp"
                    android:paddingVertical="3dp"
                    android:text="● 320 kbps Lossless"
                    android:textColor="@color/audix_emerald"
                    android:textSize="9.5sp"
                    android:textStyle="bold"
                    android:letterSpacing="0.04" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginStart="8dp"
                    android:background="@drawable/bg_audix_badge_soundstage"
                    android:paddingHorizontal="8dp"
                    android:paddingVertical="3dp"
                    android:text="STUDIO SOUNDSTAGE"
                    android:textColor="@color/audix_cyan_bright"
                    android:textSize="9.5sp"
                    android:textStyle="bold"
                    android:letterSpacing="0.04" />

                <View
                    android:layout_width="0dp"
                    android:layout_height="1dp"
                    android:layout_weight="1" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:background="@drawable/bg_audix_badge_cinema"
                    android:paddingHorizontal="8dp"
                    android:paddingVertical="3dp"
                    android:text="CINEMA 4K"
                    android:textColor="@color/audix_crimson"
                    android:textSize="9.5sp"
                    android:textStyle="bold"
                    android:letterSpacing="0.04" />
            </LinearLayout>

            <!-- Dynamic Greeting (Morning / Afternoon / Evening) -->
            <TextView
                android:id="@+id/headerGreeting"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="10dp"
                android:text="Good afternoon"
                android:textColor="@color/audix_white"
                android:textSize="22sp"
                android:textStyle="bold"
                android:letterSpacing="-0.03" />

            <!-- Subtitle -->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="2dp"
                android:text="Tuned to your affinity for High-Fidelity Lossless Sound • 320 kbps Studio Stream"
                android:textColor="@color/audix_text_secondary"
                android:textSize="12sp"
                android:lineSpacingExtra="2dp" />

            <!-- Quick Action Row -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="12dp"
                android:gravity="center_vertical"
                android:orientation="horizontal">

                <com.google.android.material.card.MaterialCardView
                    android:id="@+id/btnInstantMix"
                    android:layout_width="wrap_content"
                    android:layout_height="32dp"
                    app:cardBackgroundColor="@color/audix_white"
                    app:cardCornerRadius="16dp"
                    app:strokeWidth="0dp">

                    <LinearLayout
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center_vertical"
                        android:paddingHorizontal="12dp">

                        <ImageView
                            android:layout_width="14dp"
                            android:layout_height="14dp"
                            android:src="@drawable/ic_shuffle"
                            app:tint="@color/audix_bg"
                            android:importantForAccessibility="no" />

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="6dp"
                            android:text="Instant Mix"
                            android:textColor="@color/audix_bg"
                            android:textSize="11.5sp"
                            android:textStyle="bold" />
                    </LinearLayout>
                </com.google.android.material.card.MaterialCardView>

                <com.google.android.material.card.MaterialCardView
                    android:id="@+id/btnCinemaStudio"
                    android:layout_width="wrap_content"
                    android:layout_height="32dp"
                    android:layout_marginStart="8dp"
                    app:cardBackgroundColor="#1A2438"
                    app:cardCornerRadius="16dp"
                    app:strokeColor="#2E3F5E"
                    app:strokeWidth="1dp">

                    <LinearLayout
                        android:layout_width="wrap_content"
                        android:layout_height="match_parent"
                        android:gravity="center_vertical"
                        android:paddingHorizontal="12dp">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:text="🎬 Cinema Studio"
                            android:textColor="@color/audix_white"
                            android:textSize="11.5sp"
                            android:textStyle="bold" />
                    </LinearLayout>
                </com.google.android.material.card.MaterialCardView>
            </LinearLayout>
        </LinearLayout>
    </FrameLayout>

    <!-- 3. HORIZONTAL DISCOVERY VIBE RIBBON -->
    <HorizontalScrollView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:clipToPadding="false"
        android:scrollbars="none">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:gravity="center_vertical"
            android:orientation="horizontal">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="● Master Collection"
                android:textColor="@color/audix_white"
                android:textSize="11.5sp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginStart="6dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="For You"
                android:textColor="@color/audix_cyan_bright"
                android:textSize="11.5sp"
                android:textStyle="bold" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginStart="6dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="Top Charts"
                android:textColor="@color/audix_text_secondary"
                android:textSize="11.5sp" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginStart="6dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="Focus Sanctuary"
                android:textColor="@color/audix_text_secondary"
                android:textSize="11.5sp" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginStart="6dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="Midnight Lo-Fi"
                android:textColor="@color/audix_text_secondary"
                android:textSize="11.5sp" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="30dp"
                android:layout_marginStart="6dp"
                android:background="@drawable/bg_audix_pill_filter"
                android:gravity="center"
                android:paddingHorizontal="12dp"
                android:text="Hi-Res Masters"
                android:textColor="@color/audix_emerald"
                android:textSize="11.5sp"
                android:textStyle="bold" />
        </LinearLayout>
    </HorizontalScrollView>

</LinearLayout>
"""

with open(header_layout_path, "w", encoding="utf-8") as f:
    f.write(header_xml_content)
print("[OK] Redesigned item_main_header.xml with Desktop Flagship Studio Card")

# 2. Update HeaderAdapter.kt to bind dynamic greeting
adapter_path = os.path.join(ROOT, "java", "dev", "brahmkshatriya", "echo", "ui", "main", "HeaderAdapter.kt")
with open(adapter_path, "r", encoding="utf-8") as f:
    adapter_content = f.read()

# Add dynamic greeting binding in onBindViewHolder
if "headerGreeting.text" not in adapter_content:
    old_bind = "title.text = extension?.name ?: context.getString(R.string.app_name)"
    new_bind = """val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        val greetingStr = when (hour) {
            in 4..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            else -> "Good evening"
        }
        headerGreeting.text = greetingStr
        title.text = extension?.name ?: context.getString(R.string.app_name)"""
    adapter_content = adapter_content.replace(old_bind, new_bind)

with open(adapter_path, "w", encoding="utf-8") as f:
    f.write(adapter_content)
print("[OK] Updated HeaderAdapter.kt with dynamic time greeting")
