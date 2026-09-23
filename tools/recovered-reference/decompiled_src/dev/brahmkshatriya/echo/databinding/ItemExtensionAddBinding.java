/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.checkbox.MaterialCheckBox;
import dev.brahmkshatriya.echo.R;

public final class ItemExtensionAddBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView extensionName;
    @NonNull
    public final TextView extensionSubtitle;
    @NonNull
    public final MaterialCheckBox extensionSwitch;
    @NonNull
    public final FrameLayout itemContainer;
    @NonNull
    public final ImageView itemExtension;

    private ItemExtensionAddBinding(@NonNull LinearLayout rootView, @NonNull TextView extensionName, @NonNull TextView extensionSubtitle, @NonNull MaterialCheckBox extensionSwitch, @NonNull FrameLayout itemContainer, @NonNull ImageView itemExtension) {
        this.rootView = rootView;
        this.extensionName = extensionName;
        this.extensionSubtitle = extensionSubtitle;
        this.extensionSwitch = extensionSwitch;
        this.itemContainer = itemContainer;
        this.itemExtension = itemExtension;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemExtensionAddBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemExtensionAddBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemExtensionAddBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_extension_add, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemExtensionAddBinding.bind(root);
    }

    @NonNull
    public static ItemExtensionAddBinding bind(@NonNull View rootView) {
        ImageView itemExtension;
        FrameLayout itemContainer;
        MaterialCheckBox extensionSwitch;
        TextView extensionSubtitle;
        int id2 = R.id.extensionName;
        TextView extensionName = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (extensionName != null && (extensionSubtitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionSubtitle))) != null && (extensionSwitch = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionSwitch))) != null && (itemContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.itemContainer))) != null && (itemExtension = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.itemExtension))) != null) {
            return new ItemExtensionAddBinding((LinearLayout)rootView, extensionName, extensionSubtitle, extensionSwitch, itemContainer, itemExtension);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

