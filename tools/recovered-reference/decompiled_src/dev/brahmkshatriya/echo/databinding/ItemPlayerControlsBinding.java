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
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.checkbox.MaterialCheckBox
 *  com.google.android.material.progressindicator.CircularProgressIndicator
 *  com.google.android.material.progressindicator.LinearProgressIndicator
 *  com.google.android.material.slider.Slider
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.slider.Slider;
import dev.brahmkshatriya.echo.R;

public final class ItemPlayerControlsBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearProgressIndicator bufferBar;
    @NonNull
    public final FrameLayout playPauseContainer;
    @NonNull
    public final CircularProgressIndicator playingIndicator;
    @NonNull
    public final Slider seekBar;
    @NonNull
    public final TextView trackArtist;
    @NonNull
    public final View trackCoverPlaceHolder;
    @NonNull
    public final TextView trackCurrentTime;
    @NonNull
    public final MaterialCheckBox trackHeart;
    @NonNull
    public final MaterialButton trackNext;
    @NonNull
    public final MaterialCheckBox trackPlayPause;
    @NonNull
    public final MaterialButton trackPrevious;
    @NonNull
    public final MaterialButton trackRepeat;
    @NonNull
    public final MaterialCheckBox trackShuffle;
    @NonNull
    public final TextView trackSubtitle;
    @NonNull
    public final TextView trackTitle;
    @NonNull
    public final TextView trackTotalTime;

    private ItemPlayerControlsBinding(@NonNull LinearLayout rootView, @NonNull LinearProgressIndicator bufferBar, @NonNull FrameLayout playPauseContainer, @NonNull CircularProgressIndicator playingIndicator, @NonNull Slider seekBar, @NonNull TextView trackArtist, @NonNull View trackCoverPlaceHolder, @NonNull TextView trackCurrentTime, @NonNull MaterialCheckBox trackHeart, @NonNull MaterialButton trackNext, @NonNull MaterialCheckBox trackPlayPause, @NonNull MaterialButton trackPrevious, @NonNull MaterialButton trackRepeat, @NonNull MaterialCheckBox trackShuffle, @NonNull TextView trackSubtitle, @NonNull TextView trackTitle, @NonNull TextView trackTotalTime) {
        this.rootView = rootView;
        this.bufferBar = bufferBar;
        this.playPauseContainer = playPauseContainer;
        this.playingIndicator = playingIndicator;
        this.seekBar = seekBar;
        this.trackArtist = trackArtist;
        this.trackCoverPlaceHolder = trackCoverPlaceHolder;
        this.trackCurrentTime = trackCurrentTime;
        this.trackHeart = trackHeart;
        this.trackNext = trackNext;
        this.trackPlayPause = trackPlayPause;
        this.trackPrevious = trackPrevious;
        this.trackRepeat = trackRepeat;
        this.trackShuffle = trackShuffle;
        this.trackSubtitle = trackSubtitle;
        this.trackTitle = trackTitle;
        this.trackTotalTime = trackTotalTime;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlayerControlsBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlayerControlsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlayerControlsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_player_controls, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlayerControlsBinding.bind(root);
    }

    @NonNull
    public static ItemPlayerControlsBinding bind(@NonNull View rootView) {
        TextView trackTotalTime;
        TextView trackTitle;
        TextView trackSubtitle;
        MaterialCheckBox trackShuffle;
        MaterialButton trackRepeat;
        MaterialButton trackPrevious;
        MaterialCheckBox trackPlayPause;
        MaterialButton trackNext;
        MaterialCheckBox trackHeart;
        TextView trackCurrentTime;
        View trackCoverPlaceHolder;
        TextView trackArtist;
        Slider seekBar;
        CircularProgressIndicator playingIndicator;
        FrameLayout playPauseContainer;
        int id2 = R.id.bufferBar;
        LinearProgressIndicator bufferBar = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (bufferBar != null && (playPauseContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playPauseContainer))) != null && (playingIndicator = (CircularProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playingIndicator))) != null && (seekBar = (Slider)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.seekBar))) != null && (trackArtist = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackArtist))) != null && (trackCoverPlaceHolder = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackCoverPlaceHolder))) != null && (trackCurrentTime = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackCurrentTime))) != null && (trackHeart = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackHeart))) != null && (trackNext = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackNext))) != null && (trackPlayPause = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackPlayPause))) != null && (trackPrevious = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackPrevious))) != null && (trackRepeat = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackRepeat))) != null && (trackShuffle = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackShuffle))) != null && (trackSubtitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackSubtitle))) != null && (trackTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackTitle))) != null && (trackTotalTime = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackTotalTime))) != null) {
            return new ItemPlayerControlsBinding((LinearLayout)rootView, bufferBar, playPauseContainer, playingIndicator, seekBar, trackArtist, trackCoverPlaceHolder, trackCurrentTime, trackHeart, trackNext, trackPlayPause, trackPrevious, trackRepeat, trackShuffle, trackSubtitle, trackTitle, trackTotalTime);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

