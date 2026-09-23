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

public final class ItemShelfErrorBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView error;
    @NonNull
    public final MaterialButton errorView;
    @NonNull
    public final MaterialButton retry;

    private ItemShelfErrorBinding(@NonNull LinearLayout rootView, @NonNull TextView error, @NonNull MaterialButton errorView, @NonNull MaterialButton retry) {
        this.rootView = rootView;
        this.error = error;
        this.errorView = errorView;
        this.retry = retry;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfErrorBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfErrorBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfErrorBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_error, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfErrorBinding.bind(root);
    }

    @NonNull
    public static ItemShelfErrorBinding bind(@NonNull View rootView) {
        MaterialButton retry;
        MaterialButton errorView;
        int id2 = R.id.error;
        TextView error = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (error != null && (errorView = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.errorView))) != null && (retry = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.retry))) != null) {
            return new ItemShelfErrorBinding((LinearLayout)rootView, error, errorView, retry);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

