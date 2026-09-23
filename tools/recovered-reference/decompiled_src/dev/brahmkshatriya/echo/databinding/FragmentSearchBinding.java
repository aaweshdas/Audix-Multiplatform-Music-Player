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
 *  androidx.swiperefreshlayout.widget.SwipeRefreshLayout
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.search.SearchView
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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.search.SearchView;
import dev.brahmkshatriya.echo.R;

public final class FragmentSearchBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final FrameLayout appBarOutline;
    @NonNull
    public final RecyclerView quickSearchRecyclerView;
    @NonNull
    public final SearchView quickSearchView;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;

    private FragmentSearchBinding(@NonNull CoordinatorLayout rootView, @NonNull FrameLayout appBarOutline, @NonNull RecyclerView quickSearchRecyclerView, @NonNull SearchView quickSearchView, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefresh) {
        this.rootView = rootView;
        this.appBarOutline = appBarOutline;
        this.quickSearchRecyclerView = quickSearchRecyclerView;
        this.quickSearchView = quickSearchView;
        this.recyclerView = recyclerView;
        this.swipeRefresh = swipeRefresh;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentSearchBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentSearchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentSearchBinding.bind(root);
    }

    @NonNull
    public static FragmentSearchBinding bind(@NonNull View rootView) {
        SwipeRefreshLayout swipeRefresh;
        RecyclerView recyclerView;
        SearchView quickSearchView;
        RecyclerView quickSearchRecyclerView;
        int id2 = R.id.appBarOutline;
        FrameLayout appBarOutline = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarOutline != null && (quickSearchRecyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.quickSearchRecyclerView))) != null && (quickSearchView = (SearchView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.quickSearchView))) != null && (recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recycler_view))) != null && (swipeRefresh = (SwipeRefreshLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.swipeRefresh))) != null) {
            return new FragmentSearchBinding((CoordinatorLayout)rootView, appBarOutline, quickSearchRecyclerView, quickSearchView, recyclerView, swipeRefresh);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

