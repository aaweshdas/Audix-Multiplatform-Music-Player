/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class ItemShelfEmptyBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;

    private ItemShelfEmptyBinding(@NonNull LinearLayout rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfEmptyBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfEmptyBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfEmptyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_empty, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfEmptyBinding.bind(root);
    }

    @NonNull
    public static ItemShelfEmptyBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemShelfEmptyBinding((LinearLayout)rootView);
    }
}

