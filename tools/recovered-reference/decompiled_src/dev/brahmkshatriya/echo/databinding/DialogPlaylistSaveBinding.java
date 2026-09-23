/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.recyclerview.widget.RecyclerView
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
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class DialogPlaylistSaveBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ItemLoadingBinding loading;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final MaterialButton save;
    @NonNull
    public final FrameLayout saveCont;

    private DialogPlaylistSaveBinding(@NonNull FrameLayout rootView, @NonNull ItemLoadingBinding loading, @NonNull RecyclerView recyclerView, @NonNull MaterialButton save2, @NonNull FrameLayout saveCont) {
        this.rootView = rootView;
        this.loading = loading;
        this.recyclerView = recyclerView;
        this.save = save2;
        this.saveCont = saveCont;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogPlaylistSaveBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogPlaylistSaveBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogPlaylistSaveBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_playlist_save, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogPlaylistSaveBinding.bind(root);
    }

    @NonNull
    public static DialogPlaylistSaveBinding bind(@NonNull View rootView) {
        int id2 = R.id.loading;
        View loading = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (loading != null) {
            FrameLayout saveCont;
            MaterialButton save2;
            ItemLoadingBinding binding_loading = ItemLoadingBinding.bind(loading);
            id2 = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (recyclerView != null && (save2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.save))) != null && (saveCont = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.saveCont))) != null) {
                return new DialogPlaylistSaveBinding((FrameLayout)rootView, binding_loading, recyclerView, save2, saveCont);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

