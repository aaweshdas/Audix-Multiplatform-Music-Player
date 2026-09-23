/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ActivityMainBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final FragmentContainerView hiddenWebViewContainer;
    @NonNull
    public final FragmentContainerView navHostFragment;
    @NonNull
    public final View navView;
    @NonNull
    public final FragmentContainerView playerFragmentContainer;

    private ActivityMainBinding(@NonNull CoordinatorLayout rootView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FragmentContainerView hiddenWebViewContainer, @NonNull FragmentContainerView navHostFragment, @NonNull View navView, @NonNull FragmentContainerView playerFragmentContainer) {
        this.rootView = rootView;
        this.coordinatorLayout = coordinatorLayout;
        this.hiddenWebViewContainer = hiddenWebViewContainer;
        this.navHostFragment = navHostFragment;
        this.navView = navView;
        this.playerFragmentContainer = playerFragmentContainer;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
        return ActivityMainBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.activity_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ActivityMainBinding.bind(root);
    }

    @NonNull
    public static ActivityMainBinding bind(@NonNull View rootView) {
        FragmentContainerView playerFragmentContainer;
        View navView;
        FragmentContainerView navHostFragment;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
        int id2 = R.id.hiddenWebViewContainer;
        FragmentContainerView hiddenWebViewContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (hiddenWebViewContainer != null && (navHostFragment = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.navHostFragment))) != null && (navView = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.navView))) != null && (playerFragmentContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playerFragmentContainer))) != null) {
            return new ActivityMainBinding((CoordinatorLayout)rootView, coordinatorLayout, hiddenWebViewContainer, navHostFragment, navView, playerFragmentContainer);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

