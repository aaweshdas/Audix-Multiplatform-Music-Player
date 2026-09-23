/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  com.google.android.material.search.SearchBar
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.search.SearchBar;
import dev.brahmkshatriya.echo.R;

public final class ItemSearchBarBinding
implements ViewBinding {
    @NonNull
    private final SearchBar rootView;
    @NonNull
    public final SearchBar searchBar;

    private ItemSearchBarBinding(@NonNull SearchBar rootView, @NonNull SearchBar searchBar) {
        this.rootView = rootView;
        this.searchBar = searchBar;
    }

    @NonNull
    public SearchBar getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemSearchBarBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemSearchBarBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemSearchBarBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_search_bar, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemSearchBarBinding.bind(root);
    }

    @NonNull
    public static ItemSearchBarBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        SearchBar searchBar = (SearchBar)rootView;
        return new ItemSearchBarBinding((SearchBar)rootView, searchBar);
    }
}

