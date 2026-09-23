/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.bottomsheet.BottomSheetDragHandleView
 *  com.google.android.material.button.MaterialButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class FragmentPlaylistSearchBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final MaterialButton addTracks;
    @NonNull
    public final LinearLayout bottomSheet;
    @NonNull
    public final BottomSheetDragHandleView bottomSheetDragHandle;
    @NonNull
    public final FragmentContainerView playlistSearchContainer;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final TextView selectedSongs;
    @NonNull
    public final LinearLayout selectedSongsLayout;

    private FragmentPlaylistSearchBinding(@NonNull CoordinatorLayout rootView, @NonNull MaterialButton addTracks, @NonNull LinearLayout bottomSheet, @NonNull BottomSheetDragHandleView bottomSheetDragHandle, @NonNull FragmentContainerView playlistSearchContainer, @NonNull RecyclerView recyclerView, @NonNull TextView selectedSongs, @NonNull LinearLayout selectedSongsLayout) {
        this.rootView = rootView;
        this.addTracks = addTracks;
        this.bottomSheet = bottomSheet;
        this.bottomSheetDragHandle = bottomSheetDragHandle;
        this.playlistSearchContainer = playlistSearchContainer;
        this.recyclerView = recyclerView;
        this.selectedSongs = selectedSongs;
        this.selectedSongsLayout = selectedSongsLayout;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlaylistSearchBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlaylistSearchBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlaylistSearchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_playlist_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlaylistSearchBinding.bind(root);
    }

    @NonNull
    public static FragmentPlaylistSearchBinding bind(@NonNull View rootView) {
        LinearLayout selectedSongsLayout;
        TextView selectedSongs;
        RecyclerView recyclerView;
        FragmentContainerView playlistSearchContainer;
        BottomSheetDragHandleView bottomSheetDragHandle;
        LinearLayout bottomSheet;
        int id2 = R.id.addTracks;
        MaterialButton addTracks = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (addTracks != null && (bottomSheet = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bottomSheet))) != null && (bottomSheetDragHandle = (BottomSheetDragHandleView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bottomSheetDragHandle))) != null && (playlistSearchContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistSearchContainer))) != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recyclerView))) != null && (selectedSongs = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.selectedSongs))) != null && (selectedSongsLayout = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.selectedSongsLayout))) != null) {
            return new FragmentPlaylistSearchBinding((CoordinatorLayout)rootView, addTracks, bottomSheet, bottomSheetDragHandle, playlistSearchContainer, recyclerView, selectedSongs, selectedSongsLayout);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

