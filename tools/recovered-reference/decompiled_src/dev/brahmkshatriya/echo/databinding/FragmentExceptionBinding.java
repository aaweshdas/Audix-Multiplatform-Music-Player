/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.widget.NestedScrollView
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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import dev.brahmkshatriya.echo.R;

public final class FragmentExceptionBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final TextView exceptionDetails;
    @NonNull
    public final FrameLayout exceptionIconContainer;
    @NonNull
    public final MaterialToolbar exceptionMessage;
    @NonNull
    public final FrameLayout fabContainer;
    @NonNull
    public final ExtendedFloatingActionButton fabCopy;
    @NonNull
    public final NestedScrollView nestedScrollView;
    @NonNull
    public final View toolbarOutline;

    private FragmentExceptionBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView exceptionDetails, @NonNull FrameLayout exceptionIconContainer, @NonNull MaterialToolbar exceptionMessage, @NonNull FrameLayout fabContainer, @NonNull ExtendedFloatingActionButton fabCopy, @NonNull NestedScrollView nestedScrollView, @NonNull View toolbarOutline) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout;
        this.exceptionDetails = exceptionDetails;
        this.exceptionIconContainer = exceptionIconContainer;
        this.exceptionMessage = exceptionMessage;
        this.fabContainer = fabContainer;
        this.fabCopy = fabCopy;
        this.nestedScrollView = nestedScrollView;
        this.toolbarOutline = toolbarOutline;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentExceptionBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentExceptionBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentExceptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_exception, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentExceptionBinding.bind(root);
    }

    @NonNull
    public static FragmentExceptionBinding bind(@NonNull View rootView) {
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null) {
            View toolbarOutline;
            NestedScrollView nestedScrollView;
            ExtendedFloatingActionButton fabCopy;
            FrameLayout fabContainer;
            MaterialToolbar exceptionMessage;
            FrameLayout exceptionIconContainer;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)rootView;
            id2 = R.id.exceptionDetails;
            TextView exceptionDetails = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (exceptionDetails != null && (exceptionIconContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.exceptionIconContainer))) != null && (exceptionMessage = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.exceptionMessage))) != null && (fabContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabContainer))) != null && (fabCopy = (ExtendedFloatingActionButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fabCopy))) != null && (nestedScrollView = (NestedScrollView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.nestedScrollView))) != null && (toolbarOutline = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolbarOutline))) != null) {
                return new FragmentExceptionBinding((CoordinatorLayout)rootView, appBarLayout, coordinatorLayout, exceptionDetails, exceptionIconContainer, exceptionMessage, fabContainer, fabCopy, nestedScrollView, toolbarOutline);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

