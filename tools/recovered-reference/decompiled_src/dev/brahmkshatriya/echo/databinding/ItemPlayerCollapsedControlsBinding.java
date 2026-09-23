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
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.checkbox.MaterialCheckBox
 *  com.google.android.material.progressindicator.CircularProgressIndicator
 *  com.google.android.material.progressindicator.LinearProgressIndicator
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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class ItemPlayerCollapsedControlsBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final LinearProgressIndicator collapsedBuffer;
    @NonNull
    public final FrameLayout collapsedPlayPauseContainer;
    @NonNull
    public final CircularProgressIndicator collapsedPlayingIndicator;
    @NonNull
    public final LinearProgressIndicator collapsedSeekbar;
    @NonNull
    public final MaterialCheckBox collapsedTrackPlayPause;
    @NonNull
    public final MaterialButton playerClose;
    @NonNull
    public final FrameLayout playerCollapsedContainer;

    private ItemPlayerCollapsedControlsBinding(@NonNull FrameLayout rootView, @NonNull LinearProgressIndicator collapsedBuffer, @NonNull FrameLayout collapsedPlayPauseContainer, @NonNull CircularProgressIndicator collapsedPlayingIndicator, @NonNull LinearProgressIndicator collapsedSeekbar, @NonNull MaterialCheckBox collapsedTrackPlayPause, @NonNull MaterialButton playerClose, @NonNull FrameLayout playerCollapsedContainer) {
        this.rootView = rootView;
        this.collapsedBuffer = collapsedBuffer;
        this.collapsedPlayPauseContainer = collapsedPlayPauseContainer;
        this.collapsedPlayingIndicator = collapsedPlayingIndicator;
        this.collapsedSeekbar = collapsedSeekbar;
        this.collapsedTrackPlayPause = collapsedTrackPlayPause;
        this.playerClose = playerClose;
        this.playerCollapsedContainer = playerCollapsedContainer;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlayerCollapsedControlsBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlayerCollapsedControlsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlayerCollapsedControlsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_player_collapsed_controls, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlayerCollapsedControlsBinding.bind(root);
    }

    @NonNull
    public static ItemPlayerCollapsedControlsBinding bind(@NonNull View rootView) {
        MaterialButton playerClose;
        MaterialCheckBox collapsedTrackPlayPause;
        LinearProgressIndicator collapsedSeekbar;
        CircularProgressIndicator collapsedPlayingIndicator;
        FrameLayout collapsedPlayPauseContainer;
        int id2 = R.id.collapsed_buffer;
        LinearProgressIndicator collapsedBuffer = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (collapsedBuffer != null && (collapsedPlayPauseContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsedPlayPauseContainer))) != null && (collapsedPlayingIndicator = (CircularProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsedPlayingIndicator))) != null && (collapsedSeekbar = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsed_seekbar))) != null && (collapsedTrackPlayPause = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsedTrackPlayPause))) != null && (playerClose = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_close))) != null) {
            FrameLayout playerCollapsedContainer = (FrameLayout)rootView;
            return new ItemPlayerCollapsedControlsBinding((FrameLayout)rootView, collapsedBuffer, collapsedPlayPauseContainer, collapsedPlayingIndicator, collapsedSeekbar, collapsedTrackPlayPause, playerClose, playerCollapsedContainer);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

