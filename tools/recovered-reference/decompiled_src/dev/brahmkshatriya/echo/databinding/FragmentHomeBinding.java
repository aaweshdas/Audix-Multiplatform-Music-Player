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
import dev.brahmkshatriya.echo.R;

public final class FragmentHomeBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final FrameLayout appBarOutline;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;

    private FragmentHomeBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout appBarOutline, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefresh) {
        this.rootView = rootView;
        this.appBarOutline = appBarOutline;
        this.recyclerView = recyclerView;
        this.swipeRefresh = swipeRefresh;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentHomeBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_home, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentHomeBinding.bind(root);
    }

    @NonNull
    public static FragmentHomeBinding bind(@NonNull View rootView) {
        SwipeRefreshLayout swipeRefresh;
        RecyclerView recyclerView;
        int id2 = R.id.appBarOutline;
        FrameLayout appBarOutline = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarOutline != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recycler_view))) != null && (swipeRefresh = (SwipeRefreshLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.swipeRefresh))) != null) {
            return new FragmentHomeBinding((FrameLayout)rootView, appBarOutline, recyclerView, swipeRefresh);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

