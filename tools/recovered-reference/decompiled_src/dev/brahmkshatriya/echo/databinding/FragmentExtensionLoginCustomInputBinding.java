/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class FragmentExtensionLoginCustomInputBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final LinearLayout customInput;
    @NonNull
    public final NestedScrollView customInputContainer;
    @NonNull
    public final Button loginCustomSubmit;

    private FragmentExtensionLoginCustomInputBinding(@NonNull NestedScrollView rootView, @NonNull LinearLayout customInput, @NonNull NestedScrollView customInputContainer, @NonNull Button loginCustomSubmit) {
        this.rootView = rootView;
        this.customInput = customInput;
        this.customInputContainer = customInputContainer;
        this.loginCustomSubmit = loginCustomSubmit;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentExtensionLoginCustomInputBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentExtensionLoginCustomInputBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentExtensionLoginCustomInputBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_extension_login_custom_input, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentExtensionLoginCustomInputBinding.bind(root);
    }

    @NonNull
    public static FragmentExtensionLoginCustomInputBinding bind(@NonNull View rootView) {
        int id2 = R.id.customInput;
        LinearLayout customInput = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (customInput != null) {
            NestedScrollView customInputContainer = (NestedScrollView)rootView;
            id2 = R.id.loginCustomSubmit;
            Button loginCustomSubmit = (Button)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (loginCustomSubmit != null) {
                return new FragmentExtensionLoginCustomInputBinding((NestedScrollView)rootView, customInput, customInputContainer, loginCustomSubmit);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

