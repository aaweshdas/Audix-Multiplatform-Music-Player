/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.chip.ChipGroup
 *  com.google.android.material.progressindicator.LinearProgressIndicator
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class DialogPlayerQualitySelectionBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final LinearProgressIndicator progressIndicator;
    @NonNull
    public final ChipGroup streamableBackgroundGroup;
    @NonNull
    public final TextView streamableBackgrounds;
    @NonNull
    public final TextView streamableInfo;
    @NonNull
    public final TextView streamableServer;
    @NonNull
    public final ChipGroup streamableServerGroup;
    @NonNull
    public final TextView streamableSource;
    @NonNull
    public final ChipGroup streamableSourceGroup;
    @NonNull
    public final ChipGroup streamableSubtitleGroup;
    @NonNull
    public final TextView streamableSubtitles;
    @NonNull
    public final MaterialToolbar topAppBar;
    @NonNull
    public final TextView trackAudios;
    @NonNull
    public final ChipGroup trackAudiosGroup;
    @NonNull
    public final TextView trackSubtitles;
    @NonNull
    public final ChipGroup trackSubtitlesGroup;
    @NonNull
    public final TextView trackVideos;
    @NonNull
    public final ChipGroup trackVideosGroup;

    private DialogPlayerQualitySelectionBinding(@NonNull NestedScrollView rootView, @NonNull LinearProgressIndicator progressIndicator, @NonNull ChipGroup streamableBackgroundGroup, @NonNull TextView streamableBackgrounds, @NonNull TextView streamableInfo, @NonNull TextView streamableServer, @NonNull ChipGroup streamableServerGroup, @NonNull TextView streamableSource, @NonNull ChipGroup streamableSourceGroup, @NonNull ChipGroup streamableSubtitleGroup, @NonNull TextView streamableSubtitles, @NonNull MaterialToolbar topAppBar, @NonNull TextView trackAudios, @NonNull ChipGroup trackAudiosGroup, @NonNull TextView trackSubtitles, @NonNull ChipGroup trackSubtitlesGroup, @NonNull TextView trackVideos, @NonNull ChipGroup trackVideosGroup) {
        this.rootView = rootView;
        this.progressIndicator = progressIndicator;
        this.streamableBackgroundGroup = streamableBackgroundGroup;
        this.streamableBackgrounds = streamableBackgrounds;
        this.streamableInfo = streamableInfo;
        this.streamableServer = streamableServer;
        this.streamableServerGroup = streamableServerGroup;
        this.streamableSource = streamableSource;
        this.streamableSourceGroup = streamableSourceGroup;
        this.streamableSubtitleGroup = streamableSubtitleGroup;
        this.streamableSubtitles = streamableSubtitles;
        this.topAppBar = topAppBar;
        this.trackAudios = trackAudios;
        this.trackAudiosGroup = trackAudiosGroup;
        this.trackSubtitles = trackSubtitles;
        this.trackSubtitlesGroup = trackSubtitlesGroup;
        this.trackVideos = trackVideos;
        this.trackVideosGroup = trackVideosGroup;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogPlayerQualitySelectionBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogPlayerQualitySelectionBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogPlayerQualitySelectionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_player_quality_selection, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogPlayerQualitySelectionBinding.bind(root);
    }

    @NonNull
    public static DialogPlayerQualitySelectionBinding bind(@NonNull View rootView) {
        ChipGroup trackVideosGroup;
        TextView trackVideos;
        ChipGroup trackSubtitlesGroup;
        TextView trackSubtitles;
        ChipGroup trackAudiosGroup;
        TextView trackAudios;
        MaterialToolbar topAppBar;
        TextView streamableSubtitles;
        ChipGroup streamableSubtitleGroup;
        ChipGroup streamableSourceGroup;
        TextView streamableSource;
        ChipGroup streamableServerGroup;
        TextView streamableServer;
        TextView streamableInfo;
        TextView streamableBackgrounds;
        ChipGroup streamableBackgroundGroup;
        int id2 = R.id.progressIndicator;
        LinearProgressIndicator progressIndicator = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (progressIndicator != null && (streamableBackgroundGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableBackgroundGroup))) != null && (streamableBackgrounds = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableBackgrounds))) != null && (streamableInfo = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableInfo))) != null && (streamableServer = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamable_server))) != null && (streamableServerGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamable_server_group))) != null && (streamableSource = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableSource))) != null && (streamableSourceGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableSourceGroup))) != null && (streamableSubtitleGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableSubtitleGroup))) != null && (streamableSubtitles = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.streamableSubtitles))) != null && (topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.topAppBar))) != null && (trackAudios = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackAudios))) != null && (trackAudiosGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackAudiosGroup))) != null && (trackSubtitles = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackSubtitles))) != null && (trackSubtitlesGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackSubtitlesGroup))) != null && (trackVideos = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackVideos))) != null && (trackVideosGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.trackVideosGroup))) != null) {
            return new DialogPlayerQualitySelectionBinding((NestedScrollView)rootView, progressIndicator, streamableBackgroundGroup, streamableBackgrounds, streamableInfo, streamableServer, streamableServerGroup, streamableSource, streamableSourceGroup, streamableSubtitleGroup, streamableSubtitles, topAppBar, trackAudios, trackAudiosGroup, trackSubtitles, trackSubtitlesGroup, trackVideos, trackVideosGroup);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

