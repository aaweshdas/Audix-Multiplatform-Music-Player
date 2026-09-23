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
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.progressindicator.CircularProgressIndicator
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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class ItemPlaylistTrackBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final View playlistCurrentItem;
    @NonNull
    public final LinearLayout playlistItem;
    @NonNull
    public final TextView playlistItemAuthor;
    @NonNull
    public final MaterialButton playlistItemClose;
    @NonNull
    public final MaterialButton playlistItemDrag;
    @NonNull
    public final ImageView playlistItemImageView;
    @NonNull
    public final ImageView playlistItemNowPlaying;
    @NonNull
    public final TextView playlistItemTitle;
    @NonNull
    public final CircularProgressIndicator playlistProgressBar;

    private ItemPlaylistTrackBinding(@NonNull FrameLayout rootView, @NonNull View playlistCurrentItem, @NonNull LinearLayout playlistItem, @NonNull TextView playlistItemAuthor, @NonNull MaterialButton playlistItemClose, @NonNull MaterialButton playlistItemDrag, @NonNull ImageView playlistItemImageView, @NonNull ImageView playlistItemNowPlaying, @NonNull TextView playlistItemTitle, @NonNull CircularProgressIndicator playlistProgressBar) {
        this.rootView = rootView;
        this.playlistCurrentItem = playlistCurrentItem;
        this.playlistItem = playlistItem;
        this.playlistItemAuthor = playlistItemAuthor;
        this.playlistItemClose = playlistItemClose;
        this.playlistItemDrag = playlistItemDrag;
        this.playlistItemImageView = playlistItemImageView;
        this.playlistItemNowPlaying = playlistItemNowPlaying;
        this.playlistItemTitle = playlistItemTitle;
        this.playlistProgressBar = playlistProgressBar;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemPlaylistTrackBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemPlaylistTrackBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemPlaylistTrackBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_playlist_track, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemPlaylistTrackBinding.bind(root);
    }

    @NonNull
    public static ItemPlaylistTrackBinding bind(@NonNull View rootView) {
        CircularProgressIndicator playlistProgressBar;
        TextView playlistItemTitle;
        ImageView playlistItemNowPlaying;
        ImageView playlistItemImageView;
        MaterialButton playlistItemDrag;
        MaterialButton playlistItemClose;
        TextView playlistItemAuthor;
        LinearLayout playlistItem;
        int id2 = R.id.playlistCurrentItem;
        View playlistCurrentItem = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (playlistCurrentItem != null && (playlistItem = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItem))) != null && (playlistItemAuthor = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemAuthor))) != null && (playlistItemClose = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemClose))) != null && (playlistItemDrag = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemDrag))) != null && (playlistItemImageView = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemImageView))) != null && (playlistItemNowPlaying = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemNowPlaying))) != null && (playlistItemTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistItemTitle))) != null && (playlistProgressBar = (CircularProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playlistProgressBar))) != null) {
            return new ItemPlaylistTrackBinding((FrameLayout)rootView, playlistCurrentItem, playlistItem, playlistItemAuthor, playlistItemClose, playlistItemDrag, playlistItemImageView, playlistItemNowPlaying, playlistItemTitle, playlistProgressBar);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

