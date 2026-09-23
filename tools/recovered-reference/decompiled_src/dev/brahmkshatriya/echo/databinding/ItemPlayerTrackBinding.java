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
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemClickPanelsBinding;
import dev.brahmkshatriya.echo.databinding.ItemPlayerCollapsedBinding;

public final class ItemPlayerTrackBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ItemClickPanelsBinding clickPanel;
    @NonNull
    public final ConstraintLayout constraintLayout;
    @NonNull
    public final ItemPlayerCollapsedBinding playerCollapsed;
    @NonNull
    public final View playerControlsPlaceholder;
    @NonNull
    public final ImageView playerTrackCover;
    @NonNull
    public final FrameLayout playerTrackCoverContainer;

    private ItemPlayerTrackBinding(@NonNull FrameLayout rootView, @NonNull ItemClickPanelsBinding clickPanel, @NonNull ConstraintLayout constraintLayout, @NonNull ItemPlayerCollapsedBinding playerCollapsed, @NonNull View playerControlsPlaceholder, @NonNull ImageView playerTrackCover, @NonNull FrameLayout playerTrackCoverContainer) {
        this.rootView = rootView;
        this.clickPanel = clickPanel;
        this.constraintLayout = constraintLayout;
        this.playerCollapsed = playerCollapsed;
        this.playerControlsPlaceholder = playerControlsPlaceholder;
        this.playerTrackCover = playerTrackCover;
        this.playerTrackCoverContainer = playerTrackCoverContainer;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlayerTrackBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlayerTrackBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlayerTrackBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_player_track, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlayerTrackBinding.bind(root);
    }

    @NonNull
    public static ItemPlayerTrackBinding bind(@NonNull View rootView) {
        int id2 = R.id.click_panel;
        View clickPanel = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (clickPanel != null) {
            View playerCollapsed;
            ItemClickPanelsBinding binding_clickPanel = ItemClickPanelsBinding.bind(clickPanel);
            id2 = R.id.constraint_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (constraintLayout != null && (playerCollapsed = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_collapsed))) != null) {
                FrameLayout playerTrackCoverContainer;
                ImageView playerTrackCover;
                ItemPlayerCollapsedBinding binding_playerCollapsed = ItemPlayerCollapsedBinding.bind(playerCollapsed);
                id2 = R.id.player_controls_placeholder;
                View playerControlsPlaceholder = ViewBindings.findChildViewById((View)rootView, (int)id2);
                if (playerControlsPlaceholder != null && (playerTrackCover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_track_cover))) != null && (playerTrackCoverContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_track_cover_container))) != null) {
                    return new ItemPlayerTrackBinding((FrameLayout)rootView, binding_clickPanel, constraintLayout, binding_playerCollapsed, playerControlsPlaceholder, playerTrackCover, playerTrackCoverContainer);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

