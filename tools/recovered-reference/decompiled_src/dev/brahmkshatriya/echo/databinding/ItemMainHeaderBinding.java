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
 *  com.google.android.material.card.MaterialCardView
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
import com.google.android.material.card.MaterialCardView;
import dev.brahmkshatriya.echo.R;

public final class ItemMainHeaderBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView accounts;
    @NonNull
    public final MaterialCardView accountsCont;
    @NonNull
    public final ImageView extensions;
    @NonNull
    public final MaterialCardView extensionsCont;
    @NonNull
    public final TextView title;

    private ItemMainHeaderBinding(@NonNull LinearLayout rootView, @NonNull ImageView accounts, @NonNull MaterialCardView accountsCont, @NonNull ImageView extensions2, @NonNull MaterialCardView extensionsCont, @NonNull TextView title) {
        this.rootView = rootView;
        this.accounts = accounts;
        this.accountsCont = accountsCont;
        this.extensions = extensions2;
        this.extensionsCont = extensionsCont;
        this.title = title;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemMainHeaderBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemMainHeaderBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemMainHeaderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_main_header, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemMainHeaderBinding.bind(root);
    }

    @NonNull
    public static ItemMainHeaderBinding bind(@NonNull View rootView) {
        TextView title;
        MaterialCardView extensionsCont;
        ImageView extensions2;
        MaterialCardView accountsCont;
        int id2 = R.id.accounts;
        ImageView accounts = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (accounts != null && (accountsCont = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.accountsCont))) != null && (extensions2 = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensions))) != null && (extensionsCont = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionsCont))) != null && (title = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
            return new ItemMainHeaderBinding((LinearLayout)rootView, accounts, accountsCont, extensions2, extensionsCont, title);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

