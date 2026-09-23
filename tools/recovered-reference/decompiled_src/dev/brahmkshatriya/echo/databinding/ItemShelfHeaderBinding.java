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

public final class ItemShelfHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialButton more;
    @NonNull
    public final MaterialButton shuffle;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ItemShelfHeaderBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton more, @NonNull MaterialButton shuffle2, @NonNull TextView subtitle2, @NonNull TextView title) {
        this.rootView = rootView;
        this.more = more;
        this.shuffle = shuffle2;
        this.subtitle = subtitle2;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemShelfHeaderBinding bind(@NonNull View rootView) {
        TextView title;
        TextView subtitle2;
        MaterialButton shuffle2;
        int id2 = R.id.more;
        MaterialButton more = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (more != null && (shuffle2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.shuffle))) != null && (subtitle2 = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.subtitle))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemShelfHeaderBinding((LinearLayout)rootView, more, shuffle2, subtitle2, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

