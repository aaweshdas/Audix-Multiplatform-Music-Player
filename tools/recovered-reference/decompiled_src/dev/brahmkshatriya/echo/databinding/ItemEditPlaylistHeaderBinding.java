/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.textfield.TextInputEditText
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import dev.brahmkshatriya.echo.R;

public final class ItemEditPlaylistHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView cover;
    @NonNull
    public final ConstraintLayout coverContainer;
    @NonNull
    public final TextInputEditText playlistDescription;
    @NonNull
    public final TextInputEditText playlistName;
    @NonNull
    public final MaterialButton removeCover;

    private ItemEditPlaylistHeaderBinding(@NonNull LinearLayout rootView, @NonNull ImageView cover, @NonNull ConstraintLayout coverContainer, @NonNull TextInputEditText playlistDescription, @NonNull TextInputEditText playlistName, @NonNull MaterialButton removeCover) {
        this.rootView = rootView;
        this.cover = cover;
        this.coverContainer = coverContainer;
        this.playlistDescription = playlistDescription;
        this.playlistName = playlistName;
        this.removeCover = removeCover;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemEditPlaylistHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemEditPlaylistHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemEditPlaylistHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_edit_playlist_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemEditPlaylistHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemEditPlaylistHeaderBinding bind(@NonNull View rootView) {
        MaterialButton removeCover;
        TextInputEditText playlistName;
        TextInputEditText playlistDescription;
        ConstraintLayout coverContainer;
        int id2 = R.id.cover;
        ImageView cover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (cover != null && (coverContainer = (ConstraintLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.coverContainer))) != null && (playlistDescription = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistDescription))) != null && (playlistName = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistName))) != null && (removeCover = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.removeCover))) != null) {
            return new ItemEditPlaylistHeaderBinding((LinearLayout)rootView, cover, coverContainer, playlistDescription, playlistName, removeCover);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

