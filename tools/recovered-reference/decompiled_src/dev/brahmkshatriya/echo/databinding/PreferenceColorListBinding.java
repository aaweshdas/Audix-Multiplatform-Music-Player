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
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.card.MaterialCardView
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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import dev.brahmkshatriya.echo.R;

public final class PreferenceColorListBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialCardView addColor;
    @NonNull
    public final RecyclerView recentColors;

    private PreferenceColorListBinding(@NonNull LinearLayout rootView, @NonNull MaterialCardView addColor, @NonNull RecyclerView recentColors) {
        this.rootView = rootView;
        this.addColor = addColor;
        this.recentColors = recentColors;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceColorListBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceColorListBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceColorListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference_color_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceColorListBinding.bind(root);
    }

    @NonNull
    public static PreferenceColorListBinding bind(@NonNull View rootView) {
        RecyclerView recentColors;
        int id2 = R.id.addColor;
        MaterialCardView addColor = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (addColor != null && (recentColors = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.recentColors))) != null) {
            return new PreferenceColorListBinding((LinearLayout)rootView, addColor, recentColors);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

