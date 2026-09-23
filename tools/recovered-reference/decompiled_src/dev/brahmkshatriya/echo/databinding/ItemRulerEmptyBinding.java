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
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class ItemRulerEmptyBinding
implements ViewBinding {
    @NonNull
    private final View rootView;

    private ItemRulerEmptyBinding(@NonNull View rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemRulerEmptyBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemRulerEmptyBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemRulerEmptyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_ruler_empty, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemRulerEmptyBinding.bind(root);
    }

    @NonNull
    public static ItemRulerEmptyBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemRulerEmptyBinding(rootView);
    }
}

