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

public final class ItemDownloadBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView exception;
    @NonNull
    public final ImageView extensionIcon;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final MaterialButton remove;
    @NonNull
    public final MaterialButton retry;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemDownloadBinding(@NonNull LinearLayout rootView, @NonNull TextView exception, @NonNull ImageView extensionIcon, @NonNull ImageView imageView, @NonNull MaterialButton remove, @NonNull MaterialButton retry, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.exception = exception;
        this.extensionIcon = extensionIcon;
        this.imageView = imageView;
        this.remove = remove;
        this.retry = retry;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemDownloadBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemDownloadBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemDownloadBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_download, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemDownloadBinding.bind(root);
    }

    @NonNull
    public static ItemDownloadBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        MaterialButton retry;
        MaterialButton remove;
        ImageView imageView;
        ImageView extensionIcon;
        int id2 = R.id.exception;
        TextView exception = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (exception != null && (extensionIcon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionIcon))) != null && (imageView = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.imageView))) != null && (remove = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.remove))) != null && (retry = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.retry))) != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemDownloadBinding((LinearLayout)rootView, exception, extensionIcon, imageView, remove, retry, subtitle2, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

