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
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.media3.ui.PlayerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  androidx.viewpager2.widget.ViewPager2
 *  com.flaviofaria.kenburnsview.KenBurnsView
 *  com.google.android.material.appbar.MaterialToolbar
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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.appbar.MaterialToolbar;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemClickPanelsBinding;
import dev.brahmkshatriya.echo.databinding.ItemPlayerCollapsedControlsBinding;
import dev.brahmkshatriya.echo.databinding.ItemPlayerControlsBinding;

public final class FragmentPlayerBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final View bgCollapsed;
    @NonNull
    public final FrameLayout bgContainer;
    @NonNull
    public final ImageView bgGradient;
    @NonNull
    public final KenBurnsView bgImage;
    @NonNull
    public final ItemClickPanelsBinding bgPanel;
    @NonNull
    public final ConstraintLayout constraintLayout;
    @NonNull
    public final MaterialToolbar expandedToolbar;
    @NonNull
    public final FrameLayout fgContainer;
    @NonNull
    public final ItemPlayerCollapsedControlsBinding playerCollapsedContainer;
    @NonNull
    public final ItemPlayerControlsBinding playerControls;
    @NonNull
    public final FragmentContainerView playerMoreContainer;
    @NonNull
    public final View playerTrackCoverPlaceholder;
    @NonNull
    public final PlayerView playerView;
    @NonNull
    public final ViewPager2 viewPager;

    private FragmentPlayerBinding(@NonNull CoordinatorLayout rootView, @NonNull View bgCollapsed, @NonNull FrameLayout bgContainer, @NonNull ImageView bgGradient, @NonNull KenBurnsView bgImage, @NonNull ItemClickPanelsBinding bgPanel, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialToolbar expandedToolbar, @NonNull FrameLayout fgContainer, @NonNull ItemPlayerCollapsedControlsBinding playerCollapsedContainer, @NonNull ItemPlayerControlsBinding playerControls, @NonNull FragmentContainerView playerMoreContainer, @NonNull View playerTrackCoverPlaceholder, @NonNull PlayerView playerView, @NonNull ViewPager2 viewPager) {
        this.rootView = rootView;
        this.bgCollapsed = bgCollapsed;
        this.bgContainer = bgContainer;
        this.bgGradient = bgGradient;
        this.bgImage = bgImage;
        this.bgPanel = bgPanel;
        this.constraintLayout = constraintLayout;
        this.expandedToolbar = expandedToolbar;
        this.fgContainer = fgContainer;
        this.playerCollapsedContainer = playerCollapsedContainer;
        this.playerControls = playerControls;
        this.playerMoreContainer = playerMoreContainer;
        this.playerTrackCoverPlaceholder = playerTrackCoverPlaceholder;
        this.playerView = playerView;
        this.viewPager = viewPager;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlayerBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlayerBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlayerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_player, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlayerBinding.bind(root);
    }

    @NonNull
    public static FragmentPlayerBinding bind(@NonNull View rootView) {
        View bgPanel;
        KenBurnsView bgImage;
        ImageView bgGradient;
        FrameLayout bgContainer;
        int id2 = R.id.bg_collapsed;
        View bgCollapsed = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (bgCollapsed != null && (bgContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bg_container))) != null && (bgGradient = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bg_gradient))) != null && (bgImage = (KenBurnsView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bg_image))) != null && (bgPanel = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.bgPanel))) != null) {
            View playerCollapsedContainer;
            FrameLayout fgContainer;
            MaterialToolbar expandedToolbar;
            ItemClickPanelsBinding binding_bgPanel = ItemClickPanelsBinding.bind(bgPanel);
            id2 = R.id.constraint_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (constraintLayout != null && (expandedToolbar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.expanded_toolbar))) != null && (fgContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fg_container))) != null && (playerCollapsedContainer = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_collapsed_container))) != null) {
                ItemPlayerCollapsedControlsBinding binding_playerCollapsedContainer = ItemPlayerCollapsedControlsBinding.bind(playerCollapsedContainer);
                id2 = R.id.player_controls;
                View playerControls = ViewBindings.findChildViewById((View)rootView, (int)id2);
                if (playerControls != null) {
                    ViewPager2 viewPager;
                    PlayerView playerView;
                    View playerTrackCoverPlaceholder;
                    ItemPlayerControlsBinding binding_playerControls = ItemPlayerControlsBinding.bind(playerControls);
                    id2 = R.id.player_more_container;
                    FragmentContainerView playerMoreContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
                    if (playerMoreContainer != null && (playerTrackCoverPlaceholder = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_track_cover_placeholder))) != null && (playerView = (PlayerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_view))) != null && (viewPager = (ViewPager2)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.view_pager))) != null) {
                        return new FragmentPlayerBinding((CoordinatorLayout)rootView, bgCollapsed, bgContainer, bgGradient, bgImage, binding_bgPanel, constraintLayout, expandedToolbar, fgContainer, binding_playerCollapsedContainer, binding_playerControls, playerMoreContainer, playerTrackCoverPlaceholder, playerView, viewPager);
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

