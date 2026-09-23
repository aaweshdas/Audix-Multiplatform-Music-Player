/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class PreferenceCommonBinding
implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final FrameLayout iconFrame;
    @NonNull
    public final TextView summary;
    @NonNull
    public final TextView title;

    private PreferenceCommonBinding(@NonNull View rootView, @NonNull ImageView icon, @NonNull FrameLayout iconFrame, @NonNull TextView summary, @NonNull TextView title) {
        this.rootView = rootView;
        this.icon = icon;
        this.iconFrame = iconFrame;
        this.summary = summary;
        this.title = title;
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceCommonBinding inflate(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.preference_common, parent);
        return PreferenceCommonBinding.bind((View)parent);
    }

    @NonNull
    public static PreferenceCommonBinding bind(@NonNull View rootView) {
        TextView title;
        TextView summary;
        FrameLayout iconFrame;
        int id2 = 16908294;
        ImageView icon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (icon != null && (iconFrame = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = 16908350))) != null && (summary = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = 0x1020010))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = 16908310))) != null) {
            return new PreferenceCommonBinding(rootView, icon, iconFrame, summary, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

