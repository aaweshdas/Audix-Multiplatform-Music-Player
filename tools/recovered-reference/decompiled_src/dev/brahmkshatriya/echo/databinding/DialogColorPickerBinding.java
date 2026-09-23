/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.card.MaterialCardView
 *  com.madrapps.pikolo.HSLColorPicker
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.madrapps.pikolo.HSLColorPicker;
import dev.brahmkshatriya.echo.R;

public final class DialogColorPickerBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final Button addColorButton;
    @NonNull
    public final MaterialCardView colorCard;
    @NonNull
    public final HSLColorPicker colorPickerView;
    @NonNull
    public final Button randomColorButton;

    private DialogColorPickerBinding(@NonNull LinearLayout rootView, @NonNull Button addColorButton, @NonNull MaterialCardView colorCard, @NonNull HSLColorPicker colorPickerView, @NonNull Button randomColorButton) {
        this.rootView = rootView;
        this.addColorButton = addColorButton;
        this.colorCard = colorCard;
        this.colorPickerView = colorPickerView;
        this.randomColorButton = randomColorButton;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogColorPickerBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogColorPickerBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogColorPickerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_color_picker, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogColorPickerBinding.bind(root);
    }

    @NonNull
    public static DialogColorPickerBinding bind(@NonNull View rootView) {
        Button randomColorButton;
        HSLColorPicker colorPickerView;
        MaterialCardView colorCard;
        int id2 = R.id.addColorButton;
        Button addColorButton = (Button)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (addColorButton != null && (colorCard = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.colorCard))) != null && (colorPickerView = (HSLColorPicker)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.colorPickerView))) != null && (randomColorButton = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.randomColorButton))) != null) {
            return new DialogColorPickerBinding((LinearLayout)rootView, addColorButton, colorCard, colorPickerView, randomColorButton);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

