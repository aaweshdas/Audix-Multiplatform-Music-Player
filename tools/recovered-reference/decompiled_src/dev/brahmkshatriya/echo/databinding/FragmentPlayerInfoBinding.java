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

public final class FragmentPlayerInfoBinding
implements ViewBinding {
    @NonNull
    private final FragmentContainerView rootView;
    @NonNull
    public final FragmentContainerView playerInfoContainer;

    private FragmentPlayerInfoBinding(@NonNull FragmentContainerView rootView, @NonNull FragmentContainerView playerInfoContainer) {
        this.rootView = rootView;
        this.playerInfoContainer = playerInfoContainer;
    }

    @NonNull
    public FragmentContainerView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlayerInfoBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlayerInfoBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlayerInfoBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_player_info, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlayerInfoBinding.bind(root);
    }

    @NonNull
    public static FragmentPlayerInfoBinding bind(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        FragmentContainerView playerInfoContainer = (FragmentContainerView)rootView;
        return new FragmentPlayerInfoBinding((FragmentContainerView)rootView, playerInfoContainer);
    }
}

