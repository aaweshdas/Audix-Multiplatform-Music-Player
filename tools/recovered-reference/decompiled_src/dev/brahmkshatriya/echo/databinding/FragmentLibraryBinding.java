/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import dev.brahmkshatriya.echo.R;

public final class FragmentLibraryBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final FrameLayout appBarOutline;
    @NonNull
    public final ExtendedFloatingActionButton createPlaylist;
    @NonNull
    public final FrameLayout createPlaylistContainer;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;

    private FragmentLibraryBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout appBarOutline, @NonNull ExtendedFloatingActionButton createPlaylist2, @NonNull FrameLayout createPlaylistContainer, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefresh) {
        this.rootView = rootView;
        this.appBarOutline = appBarOutline;
        this.createPlaylist = createPlaylist2;
        this.createPlaylistContainer = createPlaylistContainer;
        this.recyclerView = recyclerView;
        this.swipeRefresh = swipeRefresh;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentLibraryBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentLibraryBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentLibraryBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_library, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentLibraryBinding.bind(root);
    }

    @NonNull
    public static FragmentLibraryBinding bind(@NonNull View rootView) {
        SwipeRefreshLayout swipeRefresh;
        RecyclerView recyclerView;
        FrameLayout createPlaylistContainer;
        ExtendedFloatingActionButton createPlaylist2;
        int id2 = R.id.appBarOutline;
        FrameLayout appBarOutline = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarOutline != null && (createPlaylist2 = (ExtendedFloatingActionButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.createPlaylist))) != null && (createPlaylistContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.createPlaylistContainer))) != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recyclerView))) != null && (swipeRefresh = (SwipeRefreshLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.swipeRefresh))) != null) {
            return new FragmentLibraryBinding((FrameLayout)rootView, appBarOutline, createPlaylist2, createPlaylistContainer, recyclerView, swipeRefresh);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

