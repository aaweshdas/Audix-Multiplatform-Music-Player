/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class DialogMediaMoreBinding
implements ViewBinding {
    @NonNull
    private final RecyclerView rootView;

    private DialogMediaMoreBinding(@NonNull RecyclerView rootView) {
        this.rootView = rootView;
    }

    @NonNull
    public RecyclerView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogMediaMoreBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogMediaMoreBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogMediaMoreBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_media_more, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogMediaMoreBinding.bind(root);
    }

    @NonNull
    public static DialogMediaMoreBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new DialogMediaMoreBinding((RecyclerView)rootView);
    }
}

