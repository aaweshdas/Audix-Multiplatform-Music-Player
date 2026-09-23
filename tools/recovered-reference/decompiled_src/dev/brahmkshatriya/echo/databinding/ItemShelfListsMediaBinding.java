/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaCoverBigBinding;

public final class ItemShelfListsMediaBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ItemShelfMediaCoverBigBinding coverContainer;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemShelfListsMediaBinding(@NonNull LinearLayout rootView, @NonNull ItemShelfMediaCoverBigBinding coverContainer, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.coverContainer = coverContainer;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfListsMediaBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfListsMediaBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfListsMediaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_lists_media, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfListsMediaBinding.bind(root);
    }

    @NonNull
    public static ItemShelfListsMediaBinding bind(@NonNull View rootView) {
        int id2 = R.id.coverContainer;
        View coverContainer = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (coverContainer != null) {
            TextView title;
            ItemShelfMediaCoverBigBinding binding_coverContainer = ItemShelfMediaCoverBigBinding.bind(coverContainer);
            id2 = R.id.subtitle;
            TextView subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (subtitle2 != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
                return new ItemShelfListsMediaBinding((LinearLayout)rootView, binding_coverContainer, subtitle2, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

