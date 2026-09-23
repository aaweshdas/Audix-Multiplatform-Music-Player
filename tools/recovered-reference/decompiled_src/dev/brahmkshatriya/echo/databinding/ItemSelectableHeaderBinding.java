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
 *  com.google.android.material.checkbox.MaterialCheckBox
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
import com.google.android.material.checkbox.MaterialCheckBox;
import dev.brahmkshatriya.echo.R;

public final class ItemSelectableHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialCheckBox selectAll;
    @NonNull
    public final TextView selected;

    private ItemSelectableHeaderBinding(@NonNull LinearLayout rootView, @NonNull MaterialCheckBox selectAll, @NonNull TextView selected2) {
        this.rootView = rootView;
        this.selectAll = selectAll;
        this.selected = selected2;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemSelectableHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemSelectableHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemSelectableHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_selectable_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemSelectableHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemSelectableHeaderBinding bind(@NonNull View rootView) {
        TextView selected2;
        int id2 = R.id.selectAll;
        MaterialCheckBox selectAll = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (selectAll != null && (selected2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.selected))) != null) {
            return new ItemSelectableHeaderBinding((LinearLayout)rootView, selectAll, selected2);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

