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
 *  com.google.android.material.button.MaterialButton
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemTabBinding
implements ViewBinding {
    @NonNull
    private final MaterialButton rootView;

    private ItemTabBinding(@NonNull MaterialButton rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public MaterialButton getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemTabBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemTabBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemTabBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_tab, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemTabBinding.bind(root);
    }

    @NonNull
    public static ItemTabBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemTabBinding((MaterialButton)rootView);
    }
}

