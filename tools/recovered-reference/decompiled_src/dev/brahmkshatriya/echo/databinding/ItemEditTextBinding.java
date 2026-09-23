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
 *  com.google.android.material.textfield.TextInputEditText
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
import com.google.android.material.textfield.TextInputEditText;
import dev.brahmkshatriya.echo.R;

public final class ItemEditTextBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextInputEditText editText;

    private ItemEditTextBinding(@NonNull LinearLayout rootView, @NonNull TextInputEditText editText) {
        this.rootView = rootView;
        this.editText = editText;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemEditTextBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemEditTextBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemEditTextBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_edit_text, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemEditTextBinding.bind(root);
    }

    @NonNull
    public static ItemEditTextBinding bind(@NonNull View rootView) {
        int id2 = R.id.edit_text;
        TextInputEditText editText = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (editText != null) {
            return new ItemEditTextBinding((LinearLayout)rootView, editText);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

