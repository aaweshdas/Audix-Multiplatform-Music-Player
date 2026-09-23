/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.loadingindicator.LoadingIndicator;
import dev.brahmkshatriya.echo.R;

public final class ItemLoadingSmallBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LoadingIndicator progress;

    private ItemLoadingSmallBinding(@NonNull LinearLayout rootView, @NonNull LoadingIndicator progress) {
        this.rootView = rootView;
        this.progress = progress;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemLoadingSmallBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemLoadingSmallBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemLoadingSmallBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_loading_small, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemLoadingSmallBinding.bind(root);
    }

    @NonNull
    public static ItemLoadingSmallBinding bind(@NonNull View rootView) {
        int id2 = R.id.progress;
        LoadingIndicator progress = (LoadingIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (progress != null) {
            return new ItemLoadingSmallBinding((LinearLayout)rootView, progress);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

