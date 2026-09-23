/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.button.MaterialButtonToggleGroup
 *  com.google.android.material.progressindicator.CircularProgressIndicator
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class DialogExtensionsListBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final MaterialButton addExtension;
    @NonNull
    public final MaterialButtonToggleGroup buttonToggleGroup;
    @NonNull
    public final MaterialButton manageExtension;
    @NonNull
    public final CircularProgressIndicator progressIndicator;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogExtensionsListBinding(@NonNull NestedScrollView rootView, @NonNull MaterialButton addExtension, @NonNull MaterialButtonToggleGroup buttonToggleGroup, @NonNull MaterialButton manageExtension, @NonNull CircularProgressIndicator progressIndicator, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.addExtension = addExtension;
        this.buttonToggleGroup = buttonToggleGroup;
        this.manageExtension = manageExtension;
        this.progressIndicator = progressIndicator;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogExtensionsListBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogExtensionsListBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogExtensionsListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_extensions_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogExtensionsListBinding.bind(root);
    }

    @NonNull
    public static DialogExtensionsListBinding bind(@NonNull View rootView) {
        MaterialToolbar topAppBar;
        CircularProgressIndicator progressIndicator;
        MaterialButton manageExtension;
        MaterialButtonToggleGroup buttonToggleGroup;
        int id2 = R.id.addExtension;
        MaterialButton addExtension = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (addExtension != null && (buttonToggleGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.buttonToggleGroup))) != null && (manageExtension = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.manageExtension))) != null && (progressIndicator = (CircularProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.progressIndicator))) != null && (topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.topAppBar))) != null) {
            return new DialogExtensionsListBinding((NestedScrollView)rootView, addExtension, buttonToggleGroup, manageExtension, progressIndicator, topAppBar);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

