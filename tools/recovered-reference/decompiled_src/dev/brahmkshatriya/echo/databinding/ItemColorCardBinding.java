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
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.card.MaterialCardView
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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import dev.brahmkshatriya.echo.R;

public final class ItemColorCardBinding
implements ViewBinding {
    @NonNull
    private final MaterialCardView rootView;
    @NonNull
    public final FrameLayout colorSelected;

    private ItemColorCardBinding(@NonNull MaterialCardView rootView, @NonNull FrameLayout colorSelected) {
        this.rootView = rootView;
        this.colorSelected = colorSelected;
    }

    @NonNull
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemColorCardBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemColorCardBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemColorCardBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_color_card, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemColorCardBinding.bind(root);
    }

    @NonNull
    public static ItemColorCardBinding bind(@NonNull View rootView) {
        int id2 = R.id.colorSelected;
        FrameLayout colorSelected = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (colorSelected != null) {
            return new ItemColorCardBinding((MaterialCardView)rootView, colorSelected);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

