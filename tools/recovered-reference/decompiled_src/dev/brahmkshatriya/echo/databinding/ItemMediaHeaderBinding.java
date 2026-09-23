/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.HorizontalScrollView
 *  android.widget.LinearLayout
 *  android.widget.TextView
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemMediaHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final HorizontalScrollView buttonGroup;
    @NonNull
    public final TextView description;
    @NonNull
    public final TextView explicit;
    @NonNull
    public final MaterialButton followButton;
    @NonNull
    public final TextView followers;
    @NonNull
    public final MaterialButton hideButton;
    @NonNull
    public final MaterialButton likeButton;
    @NonNull
    public final MaterialButton playButton;
    @NonNull
    public final MaterialButton radioButton;
    @NonNull
    public final MaterialButton savedButton;
    @NonNull
    public final MaterialButton shareButton;

    private ItemMediaHeaderBinding(@NonNull LinearLayout rootView, @NonNull HorizontalScrollView buttonGroup, @NonNull TextView description, @NonNull TextView explicit, @NonNull MaterialButton followButton, @NonNull TextView followers2, @NonNull MaterialButton hideButton, @NonNull MaterialButton likeButton, @NonNull MaterialButton playButton, @NonNull MaterialButton radioButton, @NonNull MaterialButton savedButton, @NonNull MaterialButton shareButton) {
        this.rootView = rootView;
        this.buttonGroup = buttonGroup;
        this.description = description;
        this.explicit = explicit;
        this.followButton = followButton;
        this.followers = followers2;
        this.hideButton = hideButton;
        this.likeButton = likeButton;
        this.playButton = playButton;
        this.radioButton = radioButton;
        this.savedButton = savedButton;
        this.shareButton = shareButton;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemMediaHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemMediaHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemMediaHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_media_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemMediaHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemMediaHeaderBinding bind(@NonNull View rootView) {
        MaterialButton shareButton;
        MaterialButton savedButton;
        MaterialButton radioButton;
        MaterialButton playButton;
        MaterialButton likeButton;
        MaterialButton hideButton;
        TextView followers2;
        MaterialButton followButton;
        TextView explicit;
        TextView description;
        int id2 = R.id.buttonGroup;
        HorizontalScrollView buttonGroup = (HorizontalScrollView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (buttonGroup != null && (description = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.description))) != null && (explicit = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.explicit))) != null && (followButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.followButton))) != null && (followers2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.followers))) != null && (hideButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.hideButton))) != null && (likeButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.likeButton))) != null && (playButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playButton))) != null && (radioButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.radioButton))) != null && (savedButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.savedButton))) != null && (shareButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.shareButton))) != null) {
            return new ItemMediaHeaderBinding((LinearLayout)rootView, buttonGroup, description, explicit, followButton, followers2, hideButton, likeButton, playButton, radioButton, savedButton, shareButton);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

