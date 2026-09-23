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
 *  androidx.viewbinding.ViewBindings
 *  dev.brahmkshatriya.echo.R$id
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
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ItemClickPanelsBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final View end;
    @NonNull
    public final View start;

    private ItemClickPanelsBinding(@NonNull LinearLayout rootView, @NonNull View end, @NonNull View start2) {
        this.rootView = rootView;
        this.end = end;
        this.start = start2;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemClickPanelsBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemClickPanelsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemClickPanelsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_click_panels, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemClickPanelsBinding.bind(root);
    }

    @NonNull
    public static ItemClickPanelsBinding bind(@NonNull View rootView) {
        View start2;
        int id2 = R.id.end;
        View end = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (end != null && (start2 = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.start))) != null) {
            return new ItemClickPanelsBinding((LinearLayout)rootView, end, start2);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

