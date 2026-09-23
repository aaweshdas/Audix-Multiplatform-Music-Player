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
 *  com.google.android.material.button.MaterialButton
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
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemShelfMediaCoverBinding;

public final class ItemShelfMediaBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ItemShelfMediaCoverBinding coverContainer;
    @NonNull
    public final MaterialButton more;
    @NonNull
    public final MaterialButton play;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemShelfMediaBinding(@NonNull LinearLayout rootView, @NonNull ItemShelfMediaCoverBinding coverContainer, @NonNull MaterialButton more, @NonNull MaterialButton play2, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.coverContainer = coverContainer;
        this.more = more;
        this.play = play2;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfMediaBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfMediaBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfMediaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_media, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfMediaBinding.bind(root);
    }

    @NonNull
    public static ItemShelfMediaBinding bind(@NonNull View rootView) {
        int id2 = R.id.coverContainer;
        View coverContainer = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (coverContainer != null) {
            TextView title;
            TextView subtitle2;
            MaterialButton play2;
            ItemShelfMediaCoverBinding binding_coverContainer = ItemShelfMediaCoverBinding.bind(coverContainer);
            id2 = R.id.more;
            MaterialButton more = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (more != null && (play2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.play))) != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
                return new ItemShelfMediaBinding((LinearLayout)rootView, binding_coverContainer, more, play2, subtitle2, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

