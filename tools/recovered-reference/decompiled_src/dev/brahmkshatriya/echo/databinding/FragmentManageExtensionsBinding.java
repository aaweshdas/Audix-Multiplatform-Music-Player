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
 *  com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
 *  com.google.android.material.tabs.TabLayout
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
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import dev.brahmkshatriya.echo.R;

public final class FragmentManageExtensionsBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final View appBarOutline;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ExtendedFloatingActionButton fabAddExtensions;
    @NonNull
    public final FrameLayout fabContainer;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final TabLayout tabLayout;
    @NonNull
    public final MaterialToolbar toolBar;

    private FragmentManageExtensionsBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull View appBarOutline, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton fabAddExtensions, @NonNull FrameLayout fabContainer, @NonNull RecyclerView recyclerView, @NonNull TabLayout tabLayout, @NonNull MaterialToolbar toolBar) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.appBarOutline = appBarOutline;
        this.coordinatorLayout = coordinatorLayout;
        this.fabAddExtensions = fabAddExtensions;
        this.fabContainer = fabContainer;
        this.recyclerView = recyclerView;
        this.tabLayout = tabLayout;
        this.toolBar = toolBar;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentManageExtensionsBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentManageExtensionsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentManageExtensionsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_manage_extensions, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentManageExtensionsBinding.bind(root);
    }

    @NonNull
    public static FragmentManageExtensionsBinding bind(@NonNull View rootView) {
        View appBarOutline;
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null && (appBarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.appBarOutline))) != null) {
            MaterialToolbar toolBar;
            TabLayout tabLayout;
            RecyclerView recyclerView;
            FrameLayout fabContainer;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.fabAddExtensions;
            ExtendedFloatingActionButton fabAddExtensions = (ExtendedFloatingActionButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (fabAddExtensions != null && (fabContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabContainer))) != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recyclerView))) != null && (tabLayout = (TabLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.tabLayout))) != null && (toolBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolBar))) != null) {
                return new FragmentManageExtensionsBinding((CoordinatorLayout)rootView, appBarLayout, appBarOutline, coordinatorLayout, fabAddExtensions, fabContainer, recyclerView, tabLayout, toolBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

