/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemShelfMediaCoverBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ImageView cover;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final MaterialButton isPlaying;
    @NonNull
    public final View listBg1;
    @NonNull
    public final View listBg2;

    private ItemShelfMediaCoverBinding(@NonNull FrameLayout rootView, @NonNull ImageView cover, @NonNull ImageView icon, @NonNull MaterialButton isPlaying2, @NonNull View listBg1, @NonNull View listBg2) {
        this.rootView = rootView;
        this.cover = cover;
        this.icon = icon;
        this.isPlaying = isPlaying2;
        this.listBg1 = listBg1;
        this.listBg2 = listBg2;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfMediaCoverBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfMediaCoverBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfMediaCoverBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_media_cover, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfMediaCoverBinding.bind(root);
    }

    @NonNull
    public static ItemShelfMediaCoverBinding bind(@NonNull View rootView) {
        View listBg2;
        View listBg1;
        MaterialButton isPlaying2;
        ImageView icon;
        int id2 = R.id.cover;
        ImageView cover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (cover != null && (icon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.icon))) != null && (isPlaying2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.isPlaying))) != null && (listBg1 = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.listBg1))) != null && (listBg2 = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.listBg2))) != null) {
            return new ItemShelfMediaCoverBinding((FrameLayout)rootView, cover, icon, isPlaying2, listBg1, listBg2);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

