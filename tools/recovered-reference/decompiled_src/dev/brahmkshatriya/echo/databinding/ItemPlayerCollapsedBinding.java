/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
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
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ItemPlayerCollapsedBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final LinearLayout collapsedPlayerInfo;
    @NonNull
    public final TextView collapsedTrackArtist;
    @NonNull
    public final TextView collapsedTrackTitle;

    private ItemPlayerCollapsedBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout collapsedPlayerInfo, @NonNull TextView collapsedTrackArtist, @NonNull TextView collapsedTrackTitle) {
        this.rootView = rootView;
        this.collapsedPlayerInfo = collapsedPlayerInfo;
        this.collapsedTrackArtist = collapsedTrackArtist;
        this.collapsedTrackTitle = collapsedTrackTitle;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlayerCollapsedBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlayerCollapsedBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlayerCollapsedBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_player_collapsed, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlayerCollapsedBinding.bind(root);
    }

    @NonNull
    public static ItemPlayerCollapsedBinding bind(@NonNull View rootView) {
        TextView collapsedTrackTitle;
        TextView collapsedTrackArtist;
        int id2 = R.id.collapsedPlayerInfo;
        LinearLayout collapsedPlayerInfo = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (collapsedPlayerInfo != null && (collapsedTrackArtist = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsedTrackArtist))) != null && (collapsedTrackTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.collapsedTrackTitle))) != null) {
            return new ItemPlayerCollapsedBinding((FrameLayout)rootView, collapsedPlayerInfo, collapsedTrackArtist, collapsedTrackTitle);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

