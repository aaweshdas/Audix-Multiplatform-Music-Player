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
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.MaterialToolbar
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.FragmentAudioFxBinding;

public final class DialogPlayerAudioFxBinding
implements ViewBinding {
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final TextView audioFxDescription;
    @NonNull
    public final FragmentAudioFxBinding audioFxFragment;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogPlayerAudioFxBinding(@NonNull CoordinatorLayout rootView, @NonNull AppBarLayout appBarLayout, @NonNull TextView audioFxDescription, @NonNull FragmentAudioFxBinding audioFxFragment, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.appBarLayout = appBarLayout;
        this.audioFxDescription = audioFxDescription;
        this.audioFxFragment = audioFxFragment;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogPlayerAudioFxBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogPlayerAudioFxBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogPlayerAudioFxBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_player_audio_fx, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogPlayerAudioFxBinding.bind(root);
    }

    @NonNull
    public static DialogPlayerAudioFxBinding bind(@NonNull View rootView) {
        View audioFxFragment;
        TextView audioFxDescription;
        int id2 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appBarLayout != null && (audioFxDescription = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.audioFxDescription))) != null && (audioFxFragment = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.audioFxFragment))) != null) {
            FragmentAudioFxBinding binding_audioFxFragment = FragmentAudioFxBinding.bind(audioFxFragment);
            id2 = R.id.topAppBar;
            MaterialToolbar topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (topAppBar != null) {
                return new DialogPlayerAudioFxBinding((CoordinatorLayout)rootView, appBarLayout, audioFxDescription, binding_audioFxFragment, topAppBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

