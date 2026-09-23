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

public final class ItemExtensionButtonBinding
implements ViewBinding {
    @NonNull
    private final MaterialButton rootView;

    private ItemExtensionButtonBinding(@NonNull MaterialButton rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public MaterialButton getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemExtensionButtonBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemExtensionButtonBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemExtensionButtonBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_extension_button, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemExtensionButtonBinding.bind(root);
    }

    @NonNull
    public static ItemExtensionButtonBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemExtensionButtonBinding((MaterialButton)rootView);
    }
}

