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
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.checkbox.MaterialCheckBox
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
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.checkbox.MaterialCheckBox;
import dev.brahmkshatriya.echo.R;

public final class ItemExtensionAddHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialCheckBox selectAll;
    @NonNull
    public final MaterialToolbar toolBar;

    private ItemExtensionAddHeaderBinding(@NonNull LinearLayout rootView, @NonNull MaterialCheckBox selectAll, @NonNull MaterialToolbar toolBar) {
        this.rootView = rootView;
        this.selectAll = selectAll;
        this.toolBar = toolBar;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemExtensionAddHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemExtensionAddHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemExtensionAddHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_extension_add_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemExtensionAddHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemExtensionAddHeaderBinding bind(@NonNull View rootView) {
        MaterialToolbar toolBar;
        int id2 = R.id.selectAll;
        MaterialCheckBox selectAll = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (selectAll != null && (toolBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.toolBar))) != null) {
            return new ItemExtensionAddHeaderBinding((LinearLayout)rootView, selectAll, toolBar);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

