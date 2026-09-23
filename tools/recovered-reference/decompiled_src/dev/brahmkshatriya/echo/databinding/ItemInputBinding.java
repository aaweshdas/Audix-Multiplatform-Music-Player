/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.textfield.TextInputEditText
 *  com.google.android.material.textfield.TextInputLayout
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dev.brahmkshatriya.echo.R;

public final class ItemInputBinding
implements ViewBinding {
    @NonNull
    private final TextInputLayout rootView;
    @NonNull
    public final TextInputEditText editText;

    private ItemInputBinding(@NonNull TextInputLayout rootView, @NonNull TextInputEditText editText) {
        this.rootView = rootView;
        this.editText = editText;
    }

    @NonNull
    public TextInputLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemInputBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemInputBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemInputBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_input, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemInputBinding.bind(root);
    }

    @NonNull
    public static ItemInputBinding bind(@NonNull View rootView) {
        int id2 = R.id.editText;
        TextInputEditText editText = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (editText != null) {
            return new ItemInputBinding((TextInputLayout)rootView, editText);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

