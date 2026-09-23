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
 *  com.google.android.material.button.MaterialButtonToggleGroup
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
import com.google.android.material.button.MaterialButtonToggleGroup;
import dev.brahmkshatriya.echo.R;

public final class FragmentExtensionLoginSelectorBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final MaterialButtonToggleGroup loginToggleGroup;

    private FragmentExtensionLoginSelectorBinding(@NonNull NestedScrollView rootView, @NonNull MaterialButtonToggleGroup loginToggleGroup) {
        this.rootView = rootView;
        this.loginToggleGroup = loginToggleGroup;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentExtensionLoginSelectorBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentExtensionLoginSelectorBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentExtensionLoginSelectorBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_extension_login_selector, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentExtensionLoginSelectorBinding.bind(root);
    }

    @NonNull
    public static FragmentExtensionLoginSelectorBinding bind(@NonNull View rootView) {
        int id2 = R.id.loginToggleGroup;
        MaterialButtonToggleGroup loginToggleGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (loginToggleGroup != null) {
            return new FragmentExtensionLoginSelectorBinding((NestedScrollView)rootView, loginToggleGroup);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

