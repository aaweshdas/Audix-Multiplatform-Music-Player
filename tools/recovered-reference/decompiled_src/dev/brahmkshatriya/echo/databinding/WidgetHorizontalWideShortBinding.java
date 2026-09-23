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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class WidgetHorizontalWideShortBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final FrameLayout background;
    @NonNull
    public final ImageView likeButton;
    @NonNull
    public final ImageView nextButton;
    @NonNull
    public final ImageView playPauseButton;
    @NonNull
    public final ImageView previousButton;
    @NonNull
    public final ImageView repeatButton;
    @NonNull
    public final ImageView trackCover;

    private WidgetHorizontalWideShortBinding(@NonNull LinearLayout rootView, @NonNull FrameLayout background2, @NonNull ImageView likeButton, @NonNull ImageView nextButton, @NonNull ImageView playPauseButton, @NonNull ImageView previousButton, @NonNull ImageView repeatButton, @NonNull ImageView trackCover) {
        this.rootView = rootView;
        this.background = background2;
        this.likeButton = likeButton;
        this.nextButton = nextButton;
        this.playPauseButton = playPauseButton;
        this.previousButton = previousButton;
        this.repeatButton = repeatButton;
        this.trackCover = trackCover;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static WidgetHorizontalWideShortBinding inflate(@NonNull LayoutInflater inflater) {
        return WidgetHorizontalWideShortBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static WidgetHorizontalWideShortBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.widget_horizontal_wide_short, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return WidgetHorizontalWideShortBinding.bind(root);
    }

    @NonNull
    public static WidgetHorizontalWideShortBinding bind(@NonNull View rootView) {
        ImageView trackCover;
        ImageView repeatButton;
        ImageView previousButton;
        ImageView playPauseButton;
        ImageView nextButton;
        ImageView likeButton;
        int id2 = 0x1020000;
        FrameLayout background2 = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (background2 != null && (likeButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.likeButton))) != null && (nextButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.nextButton))) != null && (playPauseButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playPauseButton))) != null && (previousButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.previousButton))) != null && (repeatButton = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.repeatButton))) != null && (trackCover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackCover))) != null) {
            return new WidgetHorizontalWideShortBinding((LinearLayout)rootView, background2, likeButton, nextButton, playPauseButton, previousButton, repeatButton, trackCover);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

