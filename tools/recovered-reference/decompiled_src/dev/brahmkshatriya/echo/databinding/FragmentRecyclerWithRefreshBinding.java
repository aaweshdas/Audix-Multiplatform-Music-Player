/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class FragmentRecyclerWithRefreshBinding
implements ViewBinding {
    @NonNull
    private final SwipeRefreshLayout rootView;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;

    private FragmentRecyclerWithRefreshBinding(@NonNull SwipeRefreshLayout rootView, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefresh) {
        this.rootView = rootView;
        this.recyclerView = recyclerView;
        this.swipeRefresh = swipeRefresh;
    }

    @NonNull
    public SwipeRefreshLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentRecyclerWithRefreshBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentRecyclerWithRefreshBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentRecyclerWithRefreshBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_recycler_with_refresh, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentRecyclerWithRefreshBinding.bind(root);
    }

    @NonNull
    public static FragmentRecyclerWithRefreshBinding bind(@NonNull View rootView) {
        int id2 = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (recyclerView != null) {
            SwipeRefreshLayout swipeRefresh = (SwipeRefreshLayout)rootView;
            return new FragmentRecyclerWithRefreshBinding((SwipeRefreshLayout)rootView, recyclerView, swipeRefresh);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

