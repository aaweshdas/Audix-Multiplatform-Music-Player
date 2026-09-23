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
 *  com.google.android.material.button.MaterialButton
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
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemExtensionBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialButton extensionDrag;
    @NonNull
    public final TextView extensionName;
    @NonNull
    public final MaterialButton extensionUse;
    @NonNull
    public final TextView extensionVersion;
    @NonNull
    public final FrameLayout itemContainer;
    @NonNull
    public final ImageView itemExtension;

    private ItemExtensionBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton extensionDrag, @NonNull TextView extensionName, @NonNull MaterialButton extensionUse, @NonNull TextView extensionVersion, @NonNull FrameLayout itemContainer, @NonNull ImageView itemExtension) {
        this.rootView = rootView;
        this.extensionDrag = extensionDrag;
        this.extensionName = extensionName;
        this.extensionUse = extensionUse;
        this.extensionVersion = extensionVersion;
        this.itemContainer = itemContainer;
        this.itemExtension = itemExtension;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemExtensionBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemExtensionBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemExtensionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_extension, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemExtensionBinding.bind(root);
    }

    @NonNull
    public static ItemExtensionBinding bind(@NonNull View rootView) {
        ImageView itemExtension;
        FrameLayout itemContainer;
        TextView extensionVersion;
        MaterialButton extensionUse;
        TextView extensionName;
        int id2 = R.id.extensionDrag;
        MaterialButton extensionDrag = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (extensionDrag != null && (extensionName = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionName))) != null && (extensionUse = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionUse))) != null && (extensionVersion = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionVersion))) != null && (itemContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.itemContainer))) != null && (itemExtension = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.itemExtension))) != null) {
            return new ItemExtensionBinding((LinearLayout)rootView, extensionDrag, extensionName, extensionUse, extensionVersion, itemContainer, itemExtension);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

