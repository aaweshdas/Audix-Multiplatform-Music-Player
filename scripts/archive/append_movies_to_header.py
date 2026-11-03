with open('app/src/main/res/layout/item_main_header.xml', 'r', encoding='utf-8') as f:
    content = f.read()

addition = '''    <!-- 4. MOVIE PLAY & BLOCKBUSTER SOUNDTRACKS (DESKTOP PARITY) -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center_vertical"
            android:orientation="horizontal">

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:background="@drawable/bg_audix_badge_cinema"
                android:paddingHorizontal="7dp"
                android:paddingVertical="2dp"
                android:text="CINEMA STUDIO • 331+ TITLES"
                android:textColor="@color/audix_crimson"
                android:textSize="9sp"
                android:textStyle="bold"
                android:letterSpacing="0.04" />

            <View
                android:layout_width="0dp"
                android:layout_height="1dp"
                android:layout_weight="1" />

            <TextView
                android:id="@+id/btnViewAllMovies"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="View All →"
                android:textColor="@color/audix_cyan_bright"
                android:textSize="11.5sp"
                android:textStyle="bold" />
        </LinearLayout>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="4dp"
            android:text="Movie Play &amp; Blockbuster Soundtracks"
            android:textColor="@color/audix_white"
            android:textSize="17sp"
            android:textStyle="bold"
            android:letterSpacing="-0.02" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="2dp"
            android:text="Stream Hollywood &amp; global blockbusters, 4K releases, and complete original motion picture soundtracks."
            android:textColor="@color/audix_text_secondary"
            android:textSize="11.5sp" />

        <!-- Horizontal Movie Carousel -->
        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/rvHeaderMovies"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:clipToPadding="false"
            android:orientation="horizontal"
            android:scrollbars="none"
            app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
            tools:listitem="@layout/item_movie_card" />
    </LinearLayout>

</LinearLayout>'''

last_idx = content.rfind('</LinearLayout>')
if last_idx != -1:
    new_content = content[:last_idx] + addition
    with open('app/src/main/res/layout/item_main_header.xml', 'w', encoding='utf-8') as f:
        f.write(new_content)
    print("Successfully added Movie Play section to item_main_header.xml")
else:
    print("Could not find </LinearLayout>")
