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
 *  androidx.cardview.widget.CardView
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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ItemRulerBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final CardView rulerCard;
    @NonNull
    public final TextView rulerText;

    private ItemRulerBinding(@NonNull LinearLayout rootView, @NonNull CardView rulerCard, @NonNull TextView rulerText) {
        this.rootView = rootView;
        this.rulerCard = rulerCard;
        this.rulerText = rulerText;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemRulerBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemRulerBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemRulerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_ruler, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemRulerBinding.bind(root);
    }

    @NonNull
    public static ItemRulerBinding bind(@NonNull View rootView) {
        TextView rulerText;
        int id2 = R.id.rulerCard;
        CardView rulerCard = (CardView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (rulerCard != null && (rulerText = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.rulerText))) != null) {
            return new ItemRulerBinding((LinearLayout)rootView, rulerCard, rulerText);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

