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
 *  com.google.android.material.loadingindicator.LoadingIndicator
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
import com.google.android.material.loadingindicator.LoadingIndicator;
import dev.brahmkshatriya.echo.R;

public final class ItemLoadingBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LoadingIndicator progress;
    @NonNull
    public final TextView textView;

    private ItemLoadingBinding(@NonNull LinearLayout rootView, @NonNull LoadingIndicator progress, @NonNull TextView textView) {
        this.rootView = rootView;
        this.progress = progress;
        this.textView = textView;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemLoadingBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemLoadingBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemLoadingBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_loading, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemLoadingBinding.bind(root);
    }

    @NonNull
    public static ItemLoadingBinding bind(@NonNull View rootView) {
        TextView textView;
        int id2 = R.id.progress;
        LoadingIndicator progress = (LoadingIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (progress != null && (textView = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.textView))) != null) {
            return new ItemLoadingBinding((LinearLayout)rootView, progress, textView);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

