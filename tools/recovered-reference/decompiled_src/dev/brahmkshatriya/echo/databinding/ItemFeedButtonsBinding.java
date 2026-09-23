/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.chip.ChipGroup
 *  com.google.android.material.textfield.TextInputEditText
 *  com.google.android.material.textfield.TextInputLayout
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dev.brahmkshatriya.echo.R;

public final class ItemFeedButtonsBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout buttonGroup;
    @NonNull
    public final View buttonPadding;
    @NonNull
    public final ChipGroup chipGroup;
    @NonNull
    public final MaterialButton playButton;
    @NonNull
    public final LinearLayout searchBarContainer;
    @NonNull
    public final TextInputEditText searchBarText;
    @NonNull
    public final MaterialButton searchClose;
    @NonNull
    public final FrameLayout searchContainer;
    @NonNull
    public final TextInputLayout searchLayout;
    @NonNull
    public final MaterialButton searchToggleButton;
    @NonNull
    public final MaterialButton shuffleButton;
    @NonNull
    public final MaterialButton sortToggleButton;

    private ItemFeedButtonsBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout buttonGroup, @NonNull View buttonPadding, @NonNull ChipGroup chipGroup, @NonNull MaterialButton playButton, @NonNull LinearLayout searchBarContainer, @NonNull TextInputEditText searchBarText, @NonNull MaterialButton searchClose, @NonNull FrameLayout searchContainer, @NonNull TextInputLayout searchLayout, @NonNull MaterialButton searchToggleButton, @NonNull MaterialButton shuffleButton, @NonNull MaterialButton sortToggleButton) {
        this.rootView = rootView;
        this.buttonGroup = buttonGroup;
        this.buttonPadding = buttonPadding;
        this.chipGroup = chipGroup;
        this.playButton = playButton;
        this.searchBarContainer = searchBarContainer;
        this.searchBarText = searchBarText;
        this.searchClose = searchClose;
        this.searchContainer = searchContainer;
        this.searchLayout = searchLayout;
        this.searchToggleButton = searchToggleButton;
        this.shuffleButton = shuffleButton;
        this.sortToggleButton = sortToggleButton;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemFeedButtonsBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemFeedButtonsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemFeedButtonsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_feed_buttons, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemFeedButtonsBinding.bind(root);
    }

    @NonNull
    public static ItemFeedButtonsBinding bind(@NonNull View rootView) {
        MaterialButton sortToggleButton;
        MaterialButton shuffleButton;
        MaterialButton searchToggleButton;
        TextInputLayout searchLayout;
        FrameLayout searchContainer;
        MaterialButton searchClose;
        TextInputEditText searchBarText;
        LinearLayout searchBarContainer;
        MaterialButton playButton;
        ChipGroup chipGroup;
        View buttonPadding;
        int id2 = R.id.buttonGroup;
        LinearLayout buttonGroup = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (buttonGroup != null && (buttonPadding = ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.buttonPadding))) != null && (chipGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.chipGroup))) != null && (playButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.playButton))) != null && (searchBarContainer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchBarContainer))) != null && (searchBarText = (TextInputEditText)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchBarText))) != null && (searchClose = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchClose))) != null && (searchContainer = (FrameLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchContainer))) != null && (searchLayout = (TextInputLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchLayout))) != null && (searchToggleButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.searchToggleButton))) != null && (shuffleButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.shuffleButton))) != null && (sortToggleButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sortToggleButton))) != null) {
            return new ItemFeedButtonsBinding((LinearLayout)rootView, buttonGroup, buttonPadding, chipGroup, playButton, searchBarContainer, searchBarText, searchClose, searchContainer, searchLayout, searchToggleButton, shuffleButton, sortToggleButton);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

