/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.checkbox.MaterialCheckBox
 *  com.google.android.material.chip.ChipGroup
 *  com.google.android.material.materialswitch.MaterialSwitch
 *  com.google.android.material.progressindicator.LinearProgressIndicator
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import dev.brahmkshatriya.echo.R;

public final class DialogSortBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final MaterialButton apply;
    @NonNull
    public final TextView filter;
    @NonNull
    public final ChipGroup filterGroup;
    @NonNull
    public final LinearProgressIndicator progressIndicator;
    @NonNull
    public final LinearLayout reversedContainer;
    @NonNull
    public final MaterialSwitch reversedSwitch;
    @NonNull
    public final MaterialCheckBox saveCheckbox;
    @NonNull
    public final LinearLayout saveContainer;
    @NonNull
    public final TextView sort;
    @NonNull
    public final ChipGroup sortChipGroup;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogSortBinding(@NonNull NestedScrollView rootView, @NonNull MaterialButton apply, @NonNull TextView filter, @NonNull ChipGroup filterGroup, @NonNull LinearProgressIndicator progressIndicator, @NonNull LinearLayout reversedContainer, @NonNull MaterialSwitch reversedSwitch, @NonNull MaterialCheckBox saveCheckbox, @NonNull LinearLayout saveContainer, @NonNull TextView sort, @NonNull ChipGroup sortChipGroup, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.apply = apply;
        this.filter = filter;
        this.filterGroup = filterGroup;
        this.progressIndicator = progressIndicator;
        this.reversedContainer = reversedContainer;
        this.reversedSwitch = reversedSwitch;
        this.saveCheckbox = saveCheckbox;
        this.saveContainer = saveContainer;
        this.sort = sort;
        this.sortChipGroup = sortChipGroup;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogSortBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogSortBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogSortBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_sort, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogSortBinding.bind(root);
    }

    @NonNull
    public static DialogSortBinding bind(@NonNull View rootView) {
        MaterialToolbar topAppBar;
        ChipGroup sortChipGroup;
        TextView sort;
        LinearLayout saveContainer;
        MaterialCheckBox saveCheckbox;
        MaterialSwitch reversedSwitch;
        LinearLayout reversedContainer;
        LinearProgressIndicator progressIndicator;
        ChipGroup filterGroup;
        TextView filter;
        int id2 = R.id.apply;
        MaterialButton apply = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (apply != null && (filter = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.filter))) != null && (filterGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.filter_group))) != null && (progressIndicator = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.progressIndicator))) != null && (reversedContainer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.reversedContainer))) != null && (reversedSwitch = (MaterialSwitch)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.reversedSwitch))) != null && (saveCheckbox = (MaterialCheckBox)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.save_checkbox))) != null && (saveContainer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.save_container))) != null && (sort = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sort))) != null && (sortChipGroup = (ChipGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sort_chip_group))) != null && (topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.topAppBar))) != null) {
            return new DialogSortBinding((NestedScrollView)rootView, apply, filter, filterGroup, progressIndicator, reversedContainer, reversedSwitch, saveCheckbox, saveContainer, sort, sortChipGroup, topAppBar);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

