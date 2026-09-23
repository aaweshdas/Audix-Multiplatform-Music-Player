/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.search.SearchBar
 *  com.google.android.material.search.SearchView
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLyricsItemBinding;

public final class FragmentPlayerLyricsBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final ItemLyricsItemBinding lyricsItem;
    @NonNull
    public final RecyclerView lyricsRecyclerView;
    @NonNull
    public final TextView noLyrics;
    @NonNull
    public final SearchBar searchBarText;
    @NonNull
    public final RecyclerView searchRecyclerView;
    @NonNull
    public final SearchView searchView;

    private FragmentPlayerLyricsBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull ItemLyricsItemBinding lyricsItem, @NonNull RecyclerView lyricsRecyclerView, @NonNull TextView noLyrics, @NonNull SearchBar searchBarText, @NonNull RecyclerView searchRecyclerView, @NonNull SearchView searchView) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.lyricsItem = lyricsItem;
        this.lyricsRecyclerView = lyricsRecyclerView;
        this.noLyrics = noLyrics;
        this.searchBarText = searchBarText;
        this.searchRecyclerView = searchRecyclerView;
        this.searchView = searchView;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlayerLyricsBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlayerLyricsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlayerLyricsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_player_lyrics, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlayerLyricsBinding.bind(root);
    }

    @NonNull
    public static FragmentPlayerLyricsBinding bind(@NonNull View rootView) {
        View lyricsItem;
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null && (lyricsItem = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.lyricsItem))) != null) {
            SearchView searchView;
            RecyclerView searchRecyclerView;
            SearchBar searchBarText;
            TextView noLyrics;
            ItemLyricsItemBinding binding_lyricsItem = ItemLyricsItemBinding.bind(lyricsItem);
            id2 = R.id.lyricsRecyclerView;
            RecyclerView lyricsRecyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (lyricsRecyclerView != null && (noLyrics = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.noLyrics))) != null && (searchBarText = (SearchBar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchBarText))) != null && (searchRecyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchRecyclerView))) != null && (searchView = (SearchView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchView))) != null) {
                return new FragmentPlayerLyricsBinding((CoordinatorLayout)rootView, appBarLayout, binding_lyricsItem, lyricsRecyclerView, noLyrics, searchBarText, searchRecyclerView, searchView);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

