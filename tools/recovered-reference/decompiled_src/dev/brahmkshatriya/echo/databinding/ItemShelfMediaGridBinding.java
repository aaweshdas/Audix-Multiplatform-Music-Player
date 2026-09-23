/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaCoverBinding;

public final class ItemShelfMediaGridBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ItemShelfMediaCoverBinding coverContainer;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemShelfMediaGridBinding(@NonNull FrameLayout rootView, @NonNull ItemShelfMediaCoverBinding coverContainer, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.coverContainer = coverContainer;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfMediaGridBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfMediaGridBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfMediaGridBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_media_grid, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfMediaGridBinding.bind(root);
    }

    @NonNull
    public static ItemShelfMediaGridBinding bind(@NonNull View rootView) {
        int id2 = R.id.coverContainer;
        View coverContainer = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (coverContainer != null) {
            TextView title;
            ItemShelfMediaCoverBinding binding_coverContainer = ItemShelfMediaCoverBinding.bind(coverContainer);
            id2 = R.id.subtitle;
            TextView subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (subtitle2 != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
                return new ItemShelfMediaGridBinding((FrameLayout)rootView, binding_coverContainer, subtitle2, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

