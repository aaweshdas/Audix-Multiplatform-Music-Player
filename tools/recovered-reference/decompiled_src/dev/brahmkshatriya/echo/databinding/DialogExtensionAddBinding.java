/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.button.MaterialButtonToggleGroup
 *  com.google.android.material.textfield.TextInputEditText
 *  com.google.android.material.textfield.TextInputLayout
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class DialogExtensionAddBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final TextInputEditText editText;
    @NonNull
    public final Button fileAdd;
    @NonNull
    public final MaterialButton installButton;
    @NonNull
    public final MaterialButtonToggleGroup installationTypeGroup;
    @NonNull
    public final Button linkAdd;
    @NonNull
    public final ItemLoadingBinding loading;
    @NonNull
    public final NestedScrollView nestedScrollView;
    @NonNull
    public final TextInputLayout textInputLayout;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogExtensionAddBinding(@NonNull FrameLayout rootView, @NonNull TextInputEditText editText, @NonNull Button fileAdd, @NonNull MaterialButton installButton, @NonNull MaterialButtonToggleGroup installationTypeGroup, @NonNull Button linkAdd, @NonNull ItemLoadingBinding loading, @NonNull NestedScrollView nestedScrollView, @NonNull TextInputLayout textInputLayout, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.editText = editText;
        this.fileAdd = fileAdd;
        this.installButton = installButton;
        this.installationTypeGroup = installationTypeGroup;
        this.linkAdd = linkAdd;
        this.loading = loading;
        this.nestedScrollView = nestedScrollView;
        this.textInputLayout = textInputLayout;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogExtensionAddBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogExtensionAddBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogExtensionAddBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_extension_add, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogExtensionAddBinding.bind(root);
    }

    @NonNull
    public static DialogExtensionAddBinding bind(@NonNull View rootView) {
        View loading;
        Button linkAdd;
        MaterialButtonToggleGroup installationTypeGroup;
        MaterialButton installButton;
        Button fileAdd;
        int id2 = R.id.editText;
        TextInputEditText editText = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (editText != null && (fileAdd = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fileAdd))) != null && (installButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installButton))) != null && (installationTypeGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeGroup))) != null && (linkAdd = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.linkAdd))) != null && (loading = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.loading))) != null) {
            MaterialToolbar topAppBar;
            TextInputLayout textInputLayout;
            ItemLoadingBinding binding_loading = ItemLoadingBinding.bind(loading);
            id2 = R.id.nestedScrollView;
            NestedScrollView nestedScrollView = (NestedScrollView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (nestedScrollView != null && (textInputLayout = (TextInputLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.textInputLayout))) != null && (topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.topAppBar))) != null) {
                return new DialogExtensionAddBinding((FrameLayout)rootView, editText, fileAdd, installButton, installationTypeGroup, linkAdd, binding_loading, nestedScrollView, textInputLayout, topAppBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

