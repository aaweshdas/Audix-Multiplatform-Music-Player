/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class ItemLyricBinding
implements ViewBinding {
    @NonNull
    private final TextView rootView;

    private ItemLyricBinding(@NonNull TextView rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemLyricBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemLyricBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemLyricBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_lyric, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemLyricBinding.bind(root);
    }

    @NonNull
    public static ItemLyricBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemLyricBinding((TextView)rootView);
    }
}

