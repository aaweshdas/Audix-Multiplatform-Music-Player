/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.viewbinding.ViewBinding
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import dev.brahmkshatriya.echo.R;

public final class FragmentMainBinding
implements ViewBinding {
    @NonNull
    private final FragmentContainerView rootView;
    @NonNull
    public final FragmentContainerView mainFragmentContainerView;

    private FragmentMainBinding(@NonNull FragmentContainerView rootView, @NonNull FragmentContainerView mainFragmentContainerView) {
        this.rootView = rootView;
        this.mainFragmentContainerView = mainFragmentContainerView;
    }

    @NonNull
    public FragmentContainerView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentMainBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_main, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentMainBinding.bind(root);
    }

    @NonNull
    public static FragmentMainBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView mainFragmentContainerView = (FragmentContainerView)rootView;
        return new FragmentMainBinding((FragmentContainerView)rootView, mainFragmentContainerView);
    }
}

