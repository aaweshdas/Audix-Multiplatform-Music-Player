/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class ItemShelfVideoHorizontalBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView artistCover;
    @NonNull
    public final ImageView cover;
    @NonNull
    public final MaterialButton isPlaying;
    @NonNull
    public final MaterialButton more;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemShelfVideoHorizontalBinding(@NonNull LinearLayout rootView, @NonNull ImageView artistCover, @NonNull ImageView cover, @NonNull MaterialButton isPlaying2, @NonNull MaterialButton more, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.artistCover = artistCover;
        this.cover = cover;
        this.isPlaying = isPlaying2;
        this.more = more;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfVideoHorizontalBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfVideoHorizontalBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfVideoHorizontalBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_video_horizontal, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfVideoHorizontalBinding.bind(root);
    }

    @NonNull
    public static ItemShelfVideoHorizontalBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        MaterialButton more;
        MaterialButton isPlaying2;
        ImageView cover;
        int id2 = R.id.artistCover;
        ImageView artistCover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (artistCover != null && (cover = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.cover))) != null && (isPlaying2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.isPlaying))) != null && (more = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.more))) != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemShelfVideoHorizontalBinding((LinearLayout)rootView, artistCover, cover, isPlaying2, more, subtitle2, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

