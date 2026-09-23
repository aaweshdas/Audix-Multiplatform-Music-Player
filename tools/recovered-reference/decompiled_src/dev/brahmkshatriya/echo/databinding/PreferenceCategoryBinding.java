/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class PreferenceCategoryBinding
implements ViewBinding {
    @NonNull
    private final TextView rootView;
    @NonNull
    public final TextView title;

    private PreferenceCategoryBinding(@NonNull TextView rootView, @NonNull TextView title) {
        this.rootView = rootView;
        this.title = title;
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static PreferenceCategoryBinding inflate(@NonNull LayoutInflater inflater) {
        return PreferenceCategoryBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static PreferenceCategoryBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.preference_category, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return PreferenceCategoryBinding.bind(root);
    }

    @NonNull
    public static PreferenceCategoryBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TextView title = (TextView)rootView;
        return new PreferenceCategoryBinding((TextView)rootView, title);
    }
}

