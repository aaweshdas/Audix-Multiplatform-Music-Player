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
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import dev.brahmkshatriya.echo.R;

public final class FragmentDownloadBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ImageView extensionIcon;
    @NonNull
    public final ExtendedFloatingActionButton fabCancel;
    @NonNull
    public final FrameLayout fabContainer;
    @NonNull
    public final FrameLayout iconContainer;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final MaterialToolbar toolBar;
    @NonNull
    public final View toolbarOutline;

    private FragmentDownloadBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView extensionIcon, @NonNull ExtendedFloatingActionButton fabCancel, @NonNull FrameLayout fabContainer, @NonNull FrameLayout iconContainer, @NonNull RecyclerView recyclerView, @NonNull MaterialToolbar toolBar, @NonNull View toolbarOutline) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.extensionIcon = extensionIcon;
        this.fabCancel = fabCancel;
        this.fabContainer = fabContainer;
        this.iconContainer = iconContainer;
        this.recyclerView = recyclerView;
        this.toolBar = toolBar;
        this.toolbarOutline = toolbarOutline;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentDownloadBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentDownloadBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_download, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentDownloadBinding.bind(root);
    }

    @NonNull
    public static FragmentDownloadBinding bind(@NonNull View rootView) {
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null) {
            View toolbarOutline;
            MaterialToolbar toolBar;
            RecyclerView recyclerView;
            FrameLayout iconContainer;
            FrameLayout fabContainer;
            ExtendedFloatingActionButton fabCancel;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.extensionIcon;
            ImageView extensionIcon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (extensionIcon != null && (fabCancel = (ExtendedFloatingActionButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabCancel))) != null && (fabContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabContainer))) != null && (iconContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.iconContainer))) != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recyclerView))) != null && (toolBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolBar))) != null && (toolbarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbarOutline))) != null) {
                return new FragmentDownloadBinding((CoordinatorLayout)rootView, appBarLayout, coordinatorLayout, extensionIcon, fabCancel, fabContainer, iconContainer, recyclerView, toolBar, toolbarOutline);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

