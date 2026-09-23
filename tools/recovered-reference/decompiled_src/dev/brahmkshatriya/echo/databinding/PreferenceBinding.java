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
import dev.brahmkshatriya.echo.databinding.PreferenceCommonBinding;

public final class PreferenceBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final PreferenceCommonBinding iconFrame;

    private PreferenceBinding(@NonNull LinearLayout rootView, @NonNull PreferenceCommonBinding iconFrame) {
        this.rootView = rootView;
        this.iconFrame = iconFrame;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceBinding.bind(root);
    }

    @NonNull
    public static PreferenceBinding bind(@NonNull View rootView) {
        int id2 = 16908350;
        View iconFrame = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (iconFrame != null) {
            PreferenceCommonBinding binding_iconFrame = PreferenceCommonBinding.bind(iconFrame);
            return new PreferenceBinding((LinearLayout)rootView, binding_iconFrame);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

