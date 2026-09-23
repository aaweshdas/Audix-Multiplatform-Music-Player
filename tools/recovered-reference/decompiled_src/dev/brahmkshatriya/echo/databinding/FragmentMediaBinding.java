/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.cardview.widget.CardView
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.CollapsingToolbarLayout
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import dev.brahmkshatriya.echo.R;

public final class FragmentMediaBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final View appbarOutline;
    @NonNull
    public final CollapsingToolbarLayout collapsingToolbar;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ImageView cover;
    @NonNull
    public final CardView coverContainer;
    @NonNull
    public final ImageView endIcon;
    @NonNull
    public final FrameLayout fabContainer;
    @NonNull
    public final FloatingActionButton fabEditPlaylist;
    @NonNull
    public final FragmentContainerView mediaFragmentContainer;
    @NonNull
    public final MaterialToolbar toolBar;

    private FragmentMediaBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull View appbarOutline, @NonNull CollapsingToolbarLayout collapsingToolbar, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView cover, @NonNull CardView coverContainer, @NonNull ImageView endIcon, @NonNull FrameLayout fabContainer, @NonNull FloatingActionButton fabEditPlaylist, @NonNull FragmentContainerView mediaFragmentContainer, @NonNull MaterialToolbar toolBar) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.appbarOutline = appbarOutline;
        this.collapsingToolbar = collapsingToolbar;
        this.coordinatorLayout = coordinatorLayout;
        this.cover = cover;
        this.coverContainer = coverContainer;
        this.endIcon = endIcon;
        this.fabContainer = fabContainer;
        this.fabEditPlaylist = fabEditPlaylist;
        this.mediaFragmentContainer = mediaFragmentContainer;
        this.toolBar = toolBar;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentMediaBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentMediaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_media, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentMediaBinding.bind(root);
    }

    @NonNull
    public static FragmentMediaBinding bind(@NonNull View rootView) {
        CollapsingToolbarLayout collapsingToolbar;
        View appbarOutline;
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null && (appbarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.appbarOutline))) != null && (collapsingToolbar = (CollapsingToolbarLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsingToolbar))) != null) {
            MaterialToolbar toolBar;
            FragmentContainerView mediaFragmentContainer;
            FloatingActionButton fabEditPlaylist;
            FrameLayout fabContainer;
            ImageView endIcon;
            CardView coverContainer;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.cover;
            ImageView cover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (cover != null && (coverContainer = (CardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.coverContainer))) != null && (endIcon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.endIcon))) != null && (fabContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabContainer))) != null && (fabEditPlaylist = (FloatingActionButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabEditPlaylist))) != null && (mediaFragmentContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.mediaFragmentContainer))) != null && (toolBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolBar))) != null) {
                return new FragmentMediaBinding((CoordinatorLayout)rootView, appBarLayout, appbarOutline, collapsingToolbar, coordinatorLayout, cover, coverContainer, endIcon, fabContainer, fabEditPlaylist, mediaFragmentContainer, toolBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

