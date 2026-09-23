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
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaBinding;

public final class ItemShelfListsThreeTracksBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ItemShelfMediaBinding track1;
    @NonNull
    public final ItemShelfMediaBinding track2;
    @NonNull
    public final ItemShelfMediaBinding track3;

    private ItemShelfListsThreeTracksBinding(@NonNull LinearLayout rootView, @NonNull ItemShelfMediaBinding track1, @NonNull ItemShelfMediaBinding track2, @NonNull ItemShelfMediaBinding track3) {
        this.rootView = rootView;
        this.track1 = track1;
        this.track2 = track2;
        this.track3 = track3;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfListsThreeTracksBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfListsThreeTracksBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfListsThreeTracksBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_lists_three_tracks, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfListsThreeTracksBinding.bind(root);
    }

    @NonNull
    public static ItemShelfListsThreeTracksBinding bind(@NonNull View rootView) {
        int id2 = R.id.track1;
        View track1 = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (track1 != null) {
            ItemShelfMediaBinding binding_track1 = ItemShelfMediaBinding.bind(track1);
            id2 = R.id.track2;
            View track2 = ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (track2 != null) {
                ItemShelfMediaBinding binding_track2 = ItemShelfMediaBinding.bind(track2);
                id2 = R.id.track3;
                View track3 = ViewBindings.findChildViewById((View)rootView, (int)id2);
                if (track3 != null) {
                    ItemShelfMediaBinding binding_track3 = ItemShelfMediaBinding.bind(track3);
                    return new ItemShelfListsThreeTracksBinding((LinearLayout)rootView, binding_track1, binding_track2, binding_track3);
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

