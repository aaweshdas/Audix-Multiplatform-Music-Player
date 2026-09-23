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
 *  com.google.android.material.materialswitch.MaterialSwitch
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
import com.google.android.material.materialswitch.MaterialSwitch;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.PreferenceCommonBinding;

public final class PreferenceSwitchBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final PreferenceCommonBinding iconFrame;
    @NonNull
    public final MaterialSwitch switchWidget;

    private PreferenceSwitchBinding(@NonNull LinearLayout rootView, @NonNull PreferenceCommonBinding iconFrame, @NonNull MaterialSwitch switchWidget) {
        this.rootView = rootView;
        this.iconFrame = iconFrame;
        this.switchWidget = switchWidget;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceSwitchBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceSwitchBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceSwitchBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference_switch, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceSwitchBinding.bind(root);
    }

    @NonNull
    public static PreferenceSwitchBinding bind(@NonNull View rootView) {
        int id2 = 16908350;
        View iconFrame = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (iconFrame != null) {
            PreferenceCommonBinding binding_iconFrame = PreferenceCommonBinding.bind(iconFrame);
            id2 = R.id.switchWidget;
            MaterialSwitch switchWidget = (MaterialSwitch)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (switchWidget != null) {
                return new PreferenceSwitchBinding((LinearLayout)rootView, binding_iconFrame, switchWidget);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

