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
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.button.MaterialButtonToggleGroup
 *  com.google.android.material.card.MaterialCardView
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
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.card.MaterialCardView;
import dev.brahmkshatriya.echo.R;

public final class FragmentPlayerMoreBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialButtonToggleGroup buttonToggleGroup;
    @NonNull
    public final MaterialButtonToggleGroup buttonToggleGroupBg;
    @NonNull
    public final MaterialButton info;
    @NonNull
    public final MaterialButton lyrics;
    @NonNull
    public final FragmentContainerView playerMoreFragmentContainer;
    @NonNull
    public final MaterialButton queue;
    @NonNull
    public final MaterialCardView viewCard;

    private FragmentPlayerMoreBinding(@NonNull LinearLayout rootView, @NonNull MaterialButtonToggleGroup buttonToggleGroup, @NonNull MaterialButtonToggleGroup buttonToggleGroupBg, @NonNull MaterialButton info, @NonNull MaterialButton lyrics, @NonNull FragmentContainerView playerMoreFragmentContainer, @NonNull MaterialButton queue, @NonNull MaterialCardView viewCard) {
        this.rootView = rootView;
        this.buttonToggleGroup = buttonToggleGroup;
        this.buttonToggleGroupBg = buttonToggleGroupBg;
        this.info = info;
        this.lyrics = lyrics;
        this.playerMoreFragmentContainer = playerMoreFragmentContainer;
        this.queue = queue;
        this.viewCard = viewCard;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentPlayerMoreBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentPlayerMoreBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentPlayerMoreBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_player_more, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentPlayerMoreBinding.bind(root);
    }

    @NonNull
    public static FragmentPlayerMoreBinding bind(@NonNull View rootView) {
        MaterialCardView viewCard;
        MaterialButton queue;
        FragmentContainerView playerMoreFragmentContainer;
        MaterialButton lyrics;
        MaterialButton info;
        MaterialButtonToggleGroup buttonToggleGroupBg;
        int id2 = R.id.buttonToggleGroup;
        MaterialButtonToggleGroup buttonToggleGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (buttonToggleGroup != null && (buttonToggleGroupBg = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.buttonToggleGroupBg))) != null && (info = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.info))) != null && (lyrics = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.lyrics))) != null && (playerMoreFragmentContainer = (FragmentContainerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player_more_fragment_container))) != null && (queue = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.queue))) != null && (viewCard = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.viewCard))) != null) {
            return new FragmentPlayerMoreBinding((LinearLayout)rootView, buttonToggleGroup, buttonToggleGroupBg, info, lyrics, playerMoreFragmentContainer, queue, viewCard);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

