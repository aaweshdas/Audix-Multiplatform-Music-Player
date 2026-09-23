/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import dev.brahmkshatriya.echo.R;

public final class ItemLoginUserBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView currentUserAvatar;
    @NonNull
    public final TextView currentUserName;
    @NonNull
    public final TextView currentUserSubTitle;
    @NonNull
    public final Button incognito;
    @NonNull
    public final Button login;
    @NonNull
    public final Button logout;
    @NonNull
    public final TextView notLoggedIn;
    @NonNull
    public final LinearLayout notLoggedInContainer;
    @NonNull
    public final Button switchAccount;
    @NonNull
    public final LinearLayout userContainer;

    private ItemLoginUserBinding(@NonNull LinearLayout rootView, @NonNull ImageView currentUserAvatar, @NonNull TextView currentUserName, @NonNull TextView currentUserSubTitle, @NonNull Button incognito, @NonNull Button login, @NonNull Button logout2, @NonNull TextView notLoggedIn, @NonNull LinearLayout notLoggedInContainer, @NonNull Button switchAccount, @NonNull LinearLayout userContainer) {
        this.rootView = rootView;
        this.currentUserAvatar = currentUserAvatar;
        this.currentUserName = currentUserName;
        this.currentUserSubTitle = currentUserSubTitle;
        this.incognito = incognito;
        this.login = login;
        this.logout = logout2;
        this.notLoggedIn = notLoggedIn;
        this.notLoggedInContainer = notLoggedInContainer;
        this.switchAccount = switchAccount;
        this.userContainer = userContainer;
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static ItemLoginUserBinding inflate(@NonNull LayoutInflater inflater) {
        return ItemLoginUserBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static ItemLoginUserBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.item_login_user, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return ItemLoginUserBinding.bind(root);
    }

    @NonNull
    public static ItemLoginUserBinding bind(@NonNull View rootView) {
        LinearLayout userContainer;
        Button switchAccount;
        LinearLayout notLoggedInContainer;
        TextView notLoggedIn;
        Button logout2;
        Button login;
        Button incognito;
        TextView currentUserSubTitle;
        TextView currentUserName;
        int id2 = R.id.currentUserAvatar;
        ImageView currentUserAvatar = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (currentUserAvatar != null && (currentUserName = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.currentUserName))) != null && (currentUserSubTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.currentUserSubTitle))) != null && (incognito = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.incognito))) != null && (login = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.login))) != null && (logout2 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.logout))) != null && (notLoggedIn = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.notLoggedIn))) != null && (notLoggedInContainer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.notLoggedInContainer))) != null && (switchAccount = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.switchAccount))) != null && (userContainer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.userContainer))) != null) {
            return new ItemLoginUserBinding((LinearLayout)rootView, currentUserAvatar, currentUserName, currentUserSubTitle, incognito, login, logout2, notLoggedIn, notLoggedInContainer, switchAccount, userContainer);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

