/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.cardview.widget.CardView
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemQuickSearchMediaBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView cover;
    @NonNull
    public final CardView coverContainer;
    @NonNull
    public final MaterialButton delete;
    @NonNull
    public final MaterialButton insert;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemQuickSearchMediaBinding(@NonNull LinearLayout rootView, @NonNull ImageView cover, @NonNull CardView coverContainer, @NonNull MaterialButton delete2, @NonNull MaterialButton insert, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.cover = cover;
        this.coverContainer = coverContainer;
        this.delete = delete2;
        this.insert = insert;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemQuickSearchMediaBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemQuickSearchMediaBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemQuickSearchMediaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_quick_search_media, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemQuickSearchMediaBinding.bind(root);
    }

    @NonNull
    public static ItemQuickSearchMediaBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        MaterialButton insert;
        MaterialButton delete2;
        CardView coverContainer;
        int id2 = R.id.cover;
        ImageView cover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (cover != null && (coverContainer = (CardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.coverContainer))) != null && (delete2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.delete))) != null && (insert = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.insert))) != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemQuickSearchMediaBinding((LinearLayout)rootView, cover, coverContainer, delete2, insert, subtitle2, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

