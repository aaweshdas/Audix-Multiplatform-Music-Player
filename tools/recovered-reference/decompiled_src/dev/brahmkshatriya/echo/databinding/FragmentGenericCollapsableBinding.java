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
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.MaterialToolbar
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
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class FragmentGenericCollapsableBinding
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
    public final FragmentContainerView genericFragmentContainer;
    @NonNull
    public final FrameLayout iconContainer;
    @NonNull
    public final ItemLoadingBinding loading;
    @NonNull
    public final MaterialToolbar toolBar;
    @NonNull
    public final View toolbarOutline;

    private FragmentGenericCollapsableBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView extensionIcon, @NonNull FragmentContainerView genericFragmentContainer, @NonNull FrameLayout iconContainer, @NonNull ItemLoadingBinding loading, @NonNull MaterialToolbar toolBar, @NonNull View toolbarOutline) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.extensionIcon = extensionIcon;
        this.genericFragmentContainer = genericFragmentContainer;
        this.iconContainer = iconContainer;
        this.loading = loading;
        this.toolBar = toolBar;
        this.toolbarOutline = toolbarOutline;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentGenericCollapsableBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentGenericCollapsableBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentGenericCollapsableBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_generic_collapsable, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentGenericCollapsableBinding.bind(root);
    }

    @NonNull
    public static FragmentGenericCollapsableBinding bind(@NonNull View rootView) {
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null) {
            View loading;
            FrameLayout iconContainer;
            FragmentContainerView genericFragmentContainer;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.extensionIcon;
            ImageView extensionIcon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (extensionIcon != null && (genericFragmentContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.genericFragmentContainer))) != null && (iconContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.iconContainer))) != null && (loading = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.loading))) != null) {
                View toolbarOutline;
                ItemLoadingBinding binding_loading = ItemLoadingBinding.bind(loading);
                id2 = R.id.toolBar;
                MaterialToolbar toolBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)id2);
                if (toolBar != null && (toolbarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbarOutline))) != null) {
                    return new FragmentGenericCollapsableBinding((CoordinatorLayout)rootView, appBarLayout, coordinatorLayout, extensionIcon, genericFragmentContainer, iconContainer, binding_loading, toolBar, toolbarOutline);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

