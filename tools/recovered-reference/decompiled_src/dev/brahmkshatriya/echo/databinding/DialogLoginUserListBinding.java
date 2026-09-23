/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.button.MaterialButtonToggleGroup
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ItemLoadingBinding;

public final class DialogLoginUserListBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final ItemLoadingBinding accountListLoading;
    @NonNull
    public final MaterialButtonToggleGroup accountListToggleGroup;
    @NonNull
    public final MaterialButton addAccount;
    @NonNull
    public final MaterialButton logout;
    @NonNull
    public final MaterialToolbar title;

    private DialogLoginUserListBinding(@NonNull NestedScrollView rootView, @NonNull ItemLoadingBinding accountListLoading, @NonNull MaterialButtonToggleGroup accountListToggleGroup, @NonNull MaterialButton addAccount, @NonNull MaterialButton logout2, @NonNull MaterialToolbar title) {
        this.rootView = rootView;
        this.accountListLoading = accountListLoading;
        this.accountListToggleGroup = accountListToggleGroup;
        this.addAccount = addAccount;
        this.logout = logout2;
        this.title = title;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogLoginUserListBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogLoginUserListBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogLoginUserListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_login_user_list, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogLoginUserListBinding.bind(root);
    }

    @NonNull
    public static DialogLoginUserListBinding bind(@NonNull View rootView) {
        int id2 = R.id.accountListLoading;
        View accountListLoading = ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (accountListLoading != null) {
            MaterialToolbar title;
            MaterialButton logout2;
            MaterialButton addAccount;
            ItemLoadingBinding binding_accountListLoading = ItemLoadingBinding.bind(accountListLoading);
            id2 = R.id.accountListToggleGroup;
            MaterialButtonToggleGroup accountListToggleGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (accountListToggleGroup != null && (addAccount = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.addAccount))) != null && (logout2 = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.logout))) != null && (title = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.title))) != null) {
                return new DialogLoginUserListBinding((NestedScrollView)rootView, binding_accountListLoading, accountListToggleGroup, addAccount, logout2, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

