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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemQuickSearchQueryBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialButton delete;
    @NonNull
    public final CardView history;
    @NonNull
    public final MaterialButton insert;
    @NonNull
    public final TextView query;

    private ItemQuickSearchQueryBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton delete2, @NonNull CardView history, @NonNull MaterialButton insert, @NonNull TextView query) {
        this.rootView = rootView;
        this.delete = delete2;
        this.history = history;
        this.insert = insert;
        this.query = query;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemQuickSearchQueryBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemQuickSearchQueryBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemQuickSearchQueryBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_quick_search_query, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemQuickSearchQueryBinding.bind(root);
    }

    @NonNull
    public static ItemQuickSearchQueryBinding bind(@NonNull View rootView) {
        TextView query;
        MaterialButton insert;
        CardView history;
        int id2 = R.id.delete;
        MaterialButton delete2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (delete2 != null && (history = (CardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.history))) != null && (insert = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.insert))) != null && (query = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.query))) != null) {
            return new ItemQuickSearchQueryBinding((LinearLayout)rootView, delete2, history, insert, query);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

