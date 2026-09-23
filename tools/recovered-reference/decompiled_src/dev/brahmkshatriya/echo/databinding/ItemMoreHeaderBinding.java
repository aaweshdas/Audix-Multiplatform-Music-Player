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
 *  com.google.android.material.button.MaterialButton
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
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaCoverBigBinding;

public final class ItemMoreHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialButton closeButton;
    @NonNull
    public final ItemShelfMediaCoverBigBinding coverContainer;
    @NonNull
    public final TextView title;
    @NonNull
    public final TextView type;

    private ItemMoreHeaderBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton closeButton, @NonNull ItemShelfMediaCoverBigBinding coverContainer, @NonNull TextView title, @NonNull TextView type) {
        this.rootView = rootView;
        this.closeButton = closeButton;
        this.coverContainer = coverContainer;
        this.title = title;
        this.type = type;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemMoreHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemMoreHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemMoreHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_more_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemMoreHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemMoreHeaderBinding bind(@NonNull View rootView) {
        View coverContainer;
        int id2 = R.id.closeButton;
        MaterialButton closeButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (closeButton != null && (coverContainer = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.coverContainer))) != null) {
            TextView type;
            ItemShelfMediaCoverBigBinding binding_coverContainer = ItemShelfMediaCoverBigBinding.bind(coverContainer);
            id2 = R.id.title;
            TextView title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (title != null && (type = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.type))) != null) {
                return new ItemMoreHeaderBinding((LinearLayout)rootView, closeButton, binding_coverContainer, title, type);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

