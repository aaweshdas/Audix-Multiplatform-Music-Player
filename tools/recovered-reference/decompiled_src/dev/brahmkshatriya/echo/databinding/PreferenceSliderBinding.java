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
 *  com.google.android.material.slider.Slider
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
import com.google.android.material.slider.Slider;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.PreferenceCommonBinding;

public final class PreferenceSliderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final PreferenceCommonBinding iconFrame;
    @NonNull
    public final Slider preferencesSlider;

    private PreferenceSliderBinding(@NonNull LinearLayout rootView, @NonNull PreferenceCommonBinding iconFrame, @NonNull Slider preferencesSlider) {
        this.rootView = rootView;
        this.iconFrame = iconFrame;
        this.preferencesSlider = preferencesSlider;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceSliderBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceSliderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceSliderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference_slider, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceSliderBinding.bind(root);
    }

    @NonNull
    public static PreferenceSliderBinding bind(@NonNull View rootView) {
        int id2 = 16908350;
        View iconFrame = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (iconFrame != null) {
            PreferenceCommonBinding binding_iconFrame = PreferenceCommonBinding.bind(iconFrame);
            id2 = R.id.preferences_slider;
            Slider preferencesSlider = (Slider)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (preferencesSlider != null) {
                return new PreferenceSliderBinding((LinearLayout)rootView, binding_iconFrame, preferencesSlider);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

