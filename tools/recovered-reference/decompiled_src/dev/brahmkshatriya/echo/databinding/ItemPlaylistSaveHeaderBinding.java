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
 *  com.google.android.material.appbar.MaterialToolbar
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.MaterialToolbar;
import dev.brahmkshatriya.echo.R;

public final class ItemPlaylistSaveHeaderBinding
implements ViewBinding {
    @NonNull
    private final MaterialToolbar rootView;
    @NonNull
    public final MaterialToolbar topAppBar;

    private ItemPlaylistSaveHeaderBinding(@NonNull MaterialToolbar rootView, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public MaterialToolbar getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlaylistSaveHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlaylistSaveHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlaylistSaveHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_playlist_save_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlaylistSaveHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemPlaylistSaveHeaderBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        MaterialToolbar topAppBar = (MaterialToolbar)rootView;
        return new ItemPlaylistSaveHeaderBinding((MaterialToolbar)rootView, topAppBar);
    }
}

