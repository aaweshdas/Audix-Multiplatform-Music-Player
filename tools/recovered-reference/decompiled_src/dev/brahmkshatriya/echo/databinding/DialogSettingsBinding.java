/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.button.MaterialButton
 *  com.google.android.material.card.MaterialCardView
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import dev.brahmkshatriya.echo.R;

public final class DialogSettingsBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ImageView accounts;
    @NonNull
    public final MaterialCardView accountsCont;
    @NonNull
    public final MaterialButton addExtension;
    @NonNull
    public final MaterialButton closeButton;
    @NonNull
    public final MaterialButton contributors;
    @NonNull
    public final MaterialButton currentAccountName;
    @NonNull
    public final MaterialButton currentExtensionSettings;
    @NonNull
    public final MaterialButton discord;
    @NonNull
    public final MaterialButton donate;
    @NonNull
    public final MaterialButton downloadSettings;
    @NonNull
    public final MaterialButton downloads;
    @NonNull
    public final LinearLayout extensionBar;
    @NonNull
    public final ImageView extensions;
    @NonNull
    public final MaterialCardView extensionsCont;
    @NonNull
    public final MaterialButton github;
    @NonNull
    public final MaterialButton language;
    @NonNull
    public final ImageView logoImage;
    @NonNull
    public final MaterialButton lookAndFeel;
    @NonNull
    public final MaterialButton manageExtension;
    @NonNull
    public final NestedScrollView nestedScrollView;
    @NonNull
    public final MaterialButton other;
    @NonNull
    public final MaterialButton player;
    @NonNull
    public final ImageView shivam;
    @NonNull
    public final MaterialButton telegram;
    @NonNull
    public final TextView version;
    @NonNull
    public final MaterialButton wiki;

    private DialogSettingsBinding(@NonNull FrameLayout rootView, @NonNull ImageView accounts, @NonNull MaterialCardView accountsCont, @NonNull MaterialButton addExtension, @NonNull MaterialButton closeButton, @NonNull MaterialButton contributors, @NonNull MaterialButton currentAccountName, @NonNull MaterialButton currentExtensionSettings, @NonNull MaterialButton discord, @NonNull MaterialButton donate, @NonNull MaterialButton downloadSettings, @NonNull MaterialButton downloads, @NonNull LinearLayout extensionBar, @NonNull ImageView extensions2, @NonNull MaterialCardView extensionsCont, @NonNull MaterialButton github, @NonNull MaterialButton language, @NonNull ImageView logoImage, @NonNull MaterialButton lookAndFeel, @NonNull MaterialButton manageExtension, @NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton other, @NonNull MaterialButton player, @NonNull ImageView shivam, @NonNull MaterialButton telegram, @NonNull TextView version, @NonNull MaterialButton wiki) {
        this.rootView = rootView;
        this.accounts = accounts;
        this.accountsCont = accountsCont;
        this.addExtension = addExtension;
        this.closeButton = closeButton;
        this.contributors = contributors;
        this.currentAccountName = currentAccountName;
        this.currentExtensionSettings = currentExtensionSettings;
        this.discord = discord;
        this.donate = donate;
        this.downloadSettings = downloadSettings;
        this.downloads = downloads;
        this.extensionBar = extensionBar;
        this.extensions = extensions2;
        this.extensionsCont = extensionsCont;
        this.github = github;
        this.language = language;
        this.logoImage = logoImage;
        this.lookAndFeel = lookAndFeel;
        this.manageExtension = manageExtension;
        this.nestedScrollView = nestedScrollView;
        this.other = other;
        this.player = player;
        this.shivam = shivam;
        this.telegram = telegram;
        this.version = version;
        this.wiki = wiki;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogSettingsBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogSettingsBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogSettingsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_settings, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogSettingsBinding.bind(root);
    }

    @NonNull
    public static DialogSettingsBinding bind(@NonNull View rootView) {
        MaterialButton wiki;
        TextView version;
        MaterialButton telegram;
        ImageView shivam;
        MaterialButton player;
        MaterialButton other;
        NestedScrollView nestedScrollView;
        MaterialButton manageExtension;
        MaterialButton lookAndFeel;
        ImageView logoImage;
        MaterialButton language;
        MaterialButton github;
        MaterialCardView extensionsCont;
        ImageView extensions2;
        LinearLayout extensionBar;
        MaterialButton downloads;
        MaterialButton downloadSettings;
        MaterialButton donate;
        MaterialButton discord;
        MaterialButton currentExtensionSettings;
        MaterialButton currentAccountName;
        MaterialButton contributors;
        MaterialButton closeButton;
        MaterialButton addExtension;
        MaterialCardView accountsCont;
        int id2 = R.id.accounts;
        ImageView accounts = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (accounts != null && (accountsCont = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.accountsCont))) != null && (addExtension = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.addExtension))) != null && (closeButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.closeButton))) != null && (contributors = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.contributors))) != null && (currentAccountName = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.currentAccountName))) != null && (currentExtensionSettings = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.currentExtensionSettings))) != null && (discord = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.discord))) != null && (donate = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.donate))) != null && (downloadSettings = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.downloadSettings))) != null && (downloads = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.downloads))) != null && (extensionBar = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionBar))) != null && (extensions2 = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensions))) != null && (extensionsCont = (MaterialCardView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionsCont))) != null && (github = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.github))) != null && (language = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.language))) != null && (logoImage = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.logoImage))) != null && (lookAndFeel = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.lookAndFeel))) != null && (manageExtension = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.manageExtension))) != null && (nestedScrollView = (NestedScrollView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.nestedScrollView))) != null && (other = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.other))) != null && (player = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.player))) != null && (shivam = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.shivam))) != null && (telegram = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.telegram))) != null && (version = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.version))) != null && (wiki = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.wiki))) != null) {
            return new DialogSettingsBinding((FrameLayout)rootView, accounts, accountsCont, addExtension, closeButton, contributors, currentAccountName, currentExtensionSettings, discord, donate, downloadSettings, downloads, extensionBar, extensions2, extensionsCont, github, language, logoImage, lookAndFeel, manageExtension, nestedScrollView, other, player, shivam, telegram, version, wiki);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

