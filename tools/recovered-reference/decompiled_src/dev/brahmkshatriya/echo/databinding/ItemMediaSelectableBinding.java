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
 *  androidx.cardview.widget.CardView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfListsMediaBinding;

public final class ItemMediaSelectableBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ItemShelfListsMediaBinding media;
    @NonNull
    public final CardView selected;

    private ItemMediaSelectableBinding(@NonNull FrameLayout rootView, @NonNull ItemShelfListsMediaBinding media, @NonNull CardView selected2) {
        this.rootView = rootView;
        this.media = media;
        this.selected = selected2;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemMediaSelectableBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemMediaSelectableBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemMediaSelectableBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_media_selectable, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemMediaSelectableBinding.bind(root);
    }

    @NonNull
    public static ItemMediaSelectableBinding bind(@NonNull View rootView) {
        int id2 = R.id.media;
        View media = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (media != null) {
            ItemShelfListsMediaBinding binding_media = ItemShelfListsMediaBinding.bind(media);
            id2 = R.id.selected;
            CardView selected2 = (CardView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (selected2 != null) {
                return new ItemMediaSelectableBinding((FrameLayout)rootView, binding_media, selected2);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

