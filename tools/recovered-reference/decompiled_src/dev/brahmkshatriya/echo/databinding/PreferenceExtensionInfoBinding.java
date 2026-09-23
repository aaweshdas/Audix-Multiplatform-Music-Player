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
 *  com.google.android.material.materialswitch.MaterialSwitch
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
import com.google.android.material.materialswitch.MaterialSwitch;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoginUserBinding;

public final class PreferenceExtensionInfoBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView extensionDescription;
    @NonNull
    public final TextView extensionDetails;
    @NonNull
    public final LinearLayout extensionEnabled;
    @NonNull
    public final MaterialSwitch extensionEnabledSwitch;
    @NonNull
    public final TextView extensionEnabledText;
    @NonNull
    public final ItemLoginUserBinding extensionLoginUser;
    @NonNull
    public final View toolbarOutline;

    private PreferenceExtensionInfoBinding(@NonNull LinearLayout rootView, @NonNull TextView extensionDescription, @NonNull TextView extensionDetails, @NonNull LinearLayout extensionEnabled, @NonNull MaterialSwitch extensionEnabledSwitch, @NonNull TextView extensionEnabledText, @NonNull ItemLoginUserBinding extensionLoginUser, @NonNull View toolbarOutline) {
        this.rootView = rootView;
        this.extensionDescription = extensionDescription;
        this.extensionDetails = extensionDetails;
        this.extensionEnabled = extensionEnabled;
        this.extensionEnabledSwitch = extensionEnabledSwitch;
        this.extensionEnabledText = extensionEnabledText;
        this.extensionLoginUser = extensionLoginUser;
        this.toolbarOutline = toolbarOutline;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceExtensionInfoBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceExtensionInfoBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceExtensionInfoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference_extension_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceExtensionInfoBinding.bind(root);
    }

    @NonNull
    public static PreferenceExtensionInfoBinding bind(@NonNull View rootView) {
        View extensionLoginUser;
        TextView extensionEnabledText;
        MaterialSwitch extensionEnabledSwitch;
        LinearLayout extensionEnabled;
        TextView extensionDetails;
        int id2 = R.id.extensionDescription;
        TextView extensionDescription = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (extensionDescription != null && (extensionDetails = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionDetails))) != null && (extensionEnabled = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionEnabled))) != null && (extensionEnabledSwitch = (MaterialSwitch)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionEnabledSwitch))) != null && (extensionEnabledText = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionEnabledText))) != null && (extensionLoginUser = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionLoginUser))) != null) {
            ItemLoginUserBinding binding_extensionLoginUser = ItemLoginUserBinding.bind(extensionLoginUser);
            id2 = R.id.toolbarOutline;
            View toolbarOutline = ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (toolbarOutline != null) {
                return new PreferenceExtensionInfoBinding((LinearLayout)rootView, extensionDescription, extensionDetails, extensionEnabled, extensionEnabledSwitch, extensionEnabledText, binding_extensionLoginUser, toolbarOutline);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

