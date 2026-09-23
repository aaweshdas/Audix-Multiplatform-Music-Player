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

public final class ItemLyricsItemBinding
implements ViewBinding {
    @NonNull
    private final MaterialToolbar rootView;

    private ItemLyricsItemBinding(@NonNull MaterialToolbar rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public MaterialToolbar getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemLyricsItemBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemLyricsItemBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemLyricsItemBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_lyrics_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemLyricsItemBinding.bind(root);
    }

    @NonNull
    public static ItemLyricsItemBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemLyricsItemBinding((MaterialToolbar)rootView);
    }
}

