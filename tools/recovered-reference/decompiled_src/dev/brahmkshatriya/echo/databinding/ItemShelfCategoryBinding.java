/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ItemShelfCategoryBinding
implements ViewBinding {
    @NonNull
    private final CardView rootView;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;
    @NonNull
    public final CardView titleCard;

    private ItemShelfCategoryBinding(@NonNull CardView rootView, @NonNull ImageView icon, @NonNull TextView subtitle2, @NonNull TextView title, @NonNull CardView titleCard) {
        this.rootView = rootView;
        this.icon = icon;
        this.subtitle = subtitle2;
        this.title = title;
        this.titleCard = titleCard;
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfCategoryBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfCategoryBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfCategoryBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_category, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfCategoryBinding.bind(root);
    }

    @NonNull
    public static ItemShelfCategoryBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        int id2 = R.id.icon;
        ImageView icon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (icon != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            CardView titleCard = (CardView)rootView;
            return new ItemShelfCategoryBinding((CardView)rootView, icon, subtitle2, title, titleCard);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

