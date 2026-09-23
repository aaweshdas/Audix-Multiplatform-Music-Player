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
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class FragmentPlaylistEditBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final MaterialButton add;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final FrameLayout fabContainer;
    @NonNull
    public final ItemLoadingBinding loading;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final MaterialButton save;
    @NonNull
    public final MaterialToolbar toolbar;
    @NonNull
    public final FrameLayout toolbarIconContainer;
    @NonNull
    public final View toolbarOutline;

    private FragmentPlaylistEditBinding(@NonNull CoordinatorLayout rootView, @NonNull MaterialButton add2, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout fabContainer, @NonNull ItemLoadingBinding loading, @NonNull RecyclerView recyclerView, @NonNull MaterialButton save2, @NonNull MaterialToolbar toolbar, @NonNull FrameLayout toolbarIconContainer, @NonNull View toolbarOutline) {
        this.rootView = rootView;
        this.add = add2;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.fabContainer = fabContainer;
        this.loading = loading;
        this.recyclerView = recyclerView;
        this.save = save2;
        this.toolbar = toolbar;
        this.toolbarIconContainer = toolbarIconContainer;
        this.toolbarOutline = toolbarOutline;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlaylistEditBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlaylistEditBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlaylistEditBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_playlist_edit, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlaylistEditBinding.bind(root);
    }

    @NonNull
    public static FragmentPlaylistEditBinding bind(@NonNull View rootView) {
        AppBarLayout appBarLayout;
        int id2 = R.id.add;
        MaterialButton add2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (add2 != null && (appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.appBarLayout))) != null) {
            View loading;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.fabContainer;
            FrameLayout fabContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (fabContainer != null && (loading = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.loading))) != null) {
                View toolbarOutline;
                FrameLayout toolbarIconContainer;
                MaterialToolbar toolbar;
                MaterialButton save2;
                ItemLoadingBinding binding_loading = ItemLoadingBinding.bind(loading);
                id2 = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
                if (recyclerView != null && (save2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.save))) != null && (toolbar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbar))) != null && (toolbarIconContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbarIconContainer))) != null && (toolbarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbarOutline))) != null) {
                    return new FragmentPlaylistEditBinding((CoordinatorLayout)rootView, add2, appBarLayout, coordinatorLayout, fabContainer, binding_loading, recyclerView, save2, toolbar, toolbarIconContainer, toolbarOutline);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

