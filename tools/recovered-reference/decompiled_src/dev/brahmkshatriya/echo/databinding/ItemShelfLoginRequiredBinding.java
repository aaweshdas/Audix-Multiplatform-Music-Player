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

public final class ItemShelfLoginRequiredBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView error;
    @NonNull
    public final MaterialButton login;

    private ItemShelfLoginRequiredBinding(@NonNull LinearLayout rootView, @NonNull TextView error, @NonNull MaterialButton login) {
        this.rootView = rootView;
        this.error = error;
        this.login = login;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemShelfLoginRequiredBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemShelfLoginRequiredBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemShelfLoginRequiredBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_shelf_login_required, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemShelfLoginRequiredBinding.bind(root);
    }

    @NonNull
    public static ItemShelfLoginRequiredBinding bind(@NonNull View rootView) {
        MaterialButton login;
        int id2 = R.id.error;
        TextView error = (TextView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (error != null && (login = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.login))) != null) {
            return new ItemShelfLoginRequiredBinding((LinearLayout)rootView, error, login);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

