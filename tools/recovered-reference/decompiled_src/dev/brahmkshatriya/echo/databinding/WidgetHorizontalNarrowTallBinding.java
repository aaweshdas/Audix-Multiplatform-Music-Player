/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class WidgetHorizontalNarrowTallBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final FrameLayout background;
    @NonNull
    public final ImageView nextButton;
    @NonNull
    public final ImageView playPauseButton;
    @NonNull
    public final ImageView previousButton;
    @NonNull
    public final TextView trackArtist;
    @NonNull
    public final ImageView trackCover;
    @NonNull
    public final TextView trackTitle;

    private WidgetHorizontalNarrowTallBinding(@NonNull LinearLayout rootView, @NonNull FrameLayout background2, @NonNull ImageView nextButton, @NonNull ImageView playPauseButton, @NonNull ImageView previousButton, @NonNull TextView trackArtist, @NonNull ImageView trackCover, @NonNull TextView trackTitle) {
        this.rootView = rootView;
        this.background = background2;
        this.nextButton = nextButton;
        this.playPauseButton = playPauseButton;
        this.previousButton = previousButton;
        this.trackArtist = trackArtist;
        this.trackCover = trackCover;
        this.trackTitle = trackTitle;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static WidgetHorizontalNarrowTallBinding inflate(@NonNull LayoutInflater inflater) {
        return WidgetHorizontalNarrowTallBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static WidgetHorizontalNarrowTallBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.widget_horizontal_narrow_tall, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return WidgetHorizontalNarrowTallBinding.bind(root);
    }

    @NonNull
    public static WidgetHorizontalNarrowTallBinding bind(@NonNull View rootView) {
        TextView trackTitle;
        ImageView trackCover;
        TextView trackArtist;
        ImageView previousButton;
        ImageView playPauseButton;
        ImageView nextButton;
        int id2 = 0x1020000;
        FrameLayout background2 = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (background2 != null && (nextButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.nextButton))) != null && (playPauseButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playPauseButton))) != null && (previousButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.previousButton))) != null && (trackArtist = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackArtist))) != null && (trackCover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackCover))) != null && (trackTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackTitle))) != null) {
            return new WidgetHorizontalNarrowTallBinding((LinearLayout)rootView, background2, nextButton, playPauseButton, previousButton, trackArtist, trackCover, trackTitle);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

