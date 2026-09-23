/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.textfield.TextInputEditText
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class DialogPlaylistCreateBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final NestedScrollView nestedScrollView;
    @NonNull
    public final MaterialButton playlistCreateButton;
    @NonNull
    public final TextInputEditText playlistDesc;
    @NonNull
    public final TextInputEditText playlistName;
    @NonNull
    public final ItemLoadingBinding saving;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogPlaylistCreateBinding(@NonNull FrameLayout rootView, @NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton playlistCreateButton, @NonNull TextInputEditText playlistDesc, @NonNull TextInputEditText playlistName, @NonNull ItemLoadingBinding saving, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.nestedScrollView = nestedScrollView;
        this.playlistCreateButton = playlistCreateButton;
        this.playlistDesc = playlistDesc;
        this.playlistName = playlistName;
        this.saving = saving;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogPlaylistCreateBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogPlaylistCreateBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogPlaylistCreateBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_playlist_create, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogPlaylistCreateBinding.bind(root);
    }

    @NonNull
    public static DialogPlaylistCreateBinding bind(@NonNull View rootView) {
        View saving;
        TextInputEditText playlistName;
        TextInputEditText playlistDesc;
        MaterialButton playlistCreateButton;
        int id2 = R.id.nestedScrollView;
        NestedScrollView nestedScrollView = (NestedScrollView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (nestedScrollView != null && (playlistCreateButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistCreateButton))) != null && (playlistDesc = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistDesc))) != null && (playlistName = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistName))) != null && (saving = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.saving))) != null) {
            ItemLoadingBinding binding_saving = ItemLoadingBinding.bind(saving);
            id2 = R.id.topAppBar;
            MaterialToolbar topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (topAppBar != null) {
                return new DialogPlaylistCreateBinding((FrameLayout)rootView, nestedScrollView, playlistCreateButton, playlistDesc, playlistName, binding_saving, topAppBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

