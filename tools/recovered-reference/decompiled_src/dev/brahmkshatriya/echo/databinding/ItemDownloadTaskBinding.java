/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.progressindicator.CircularProgressIndicator
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class ItemDownloadTaskBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final CircularProgressIndicator progressBar;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemDownloadTaskBinding(@NonNull LinearLayout rootView, @NonNull CircularProgressIndicator progressBar, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.progressBar = progressBar;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemDownloadTaskBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemDownloadTaskBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemDownloadTaskBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_download_task, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemDownloadTaskBinding.bind(root);
    }

    @NonNull
    public static ItemDownloadTaskBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        int id2 = R.id.progressBar;
        CircularProgressIndicator progressBar = (CircularProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (progressBar != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemDownloadTaskBinding((LinearLayout)rootView, progressBar, subtitle2, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

