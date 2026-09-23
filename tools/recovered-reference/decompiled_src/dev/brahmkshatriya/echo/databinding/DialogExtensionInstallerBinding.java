/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.ImageView
 *  android.widget.TextView
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import dev.brahmkshatriya.echo.R;

public final class DialogExtensionInstallerBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final Button appInstall;
    @NonNull
    public final TextView extensionDescription;
    @NonNull
    public final TextView extensionDetails;
    @NonNull
    public final ImageView extensionIcon;
    @NonNull
    public final TextView extensionTitle;
    @NonNull
    public final Button fileInstall;
    @NonNull
    public final MaterialButton installButton;
    @NonNull
    public final MaterialButtonToggleGroup installationTypeGroup;
    @NonNull
    public final TextView installationTypeLinks;
    @NonNull
    public final TextView installationTypeSummary;
    @NonNull
    public final TextView installationTypeTitle;
    @NonNull
    public final TextView installationTypeWarning;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogExtensionInstallerBinding(@NonNull NestedScrollView rootView, @NonNull Button appInstall, @NonNull TextView extensionDescription, @NonNull TextView extensionDetails, @NonNull ImageView extensionIcon, @NonNull TextView extensionTitle, @NonNull Button fileInstall, @NonNull MaterialButton installButton, @NonNull MaterialButtonToggleGroup installationTypeGroup, @NonNull TextView installationTypeLinks, @NonNull TextView installationTypeSummary, @NonNull TextView installationTypeTitle, @NonNull TextView installationTypeWarning, @NonNull NestedScrollView scrollView, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.appInstall = appInstall;
        this.extensionDescription = extensionDescription;
        this.extensionDetails = extensionDetails;
        this.extensionIcon = extensionIcon;
        this.extensionTitle = extensionTitle;
        this.fileInstall = fileInstall;
        this.installButton = installButton;
        this.installationTypeGroup = installationTypeGroup;
        this.installationTypeLinks = installationTypeLinks;
        this.installationTypeSummary = installationTypeSummary;
        this.installationTypeTitle = installationTypeTitle;
        this.installationTypeWarning = installationTypeWarning;
        this.scrollView = scrollView;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogExtensionInstallerBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogExtensionInstallerBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogExtensionInstallerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_extension_installer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogExtensionInstallerBinding.bind(root);
    }

    @NonNull
    public static DialogExtensionInstallerBinding bind(@NonNull View rootView) {
        TextView installationTypeWarning;
        TextView installationTypeTitle;
        TextView installationTypeSummary;
        TextView installationTypeLinks;
        MaterialButtonToggleGroup installationTypeGroup;
        MaterialButton installButton;
        Button fileInstall;
        TextView extensionTitle;
        ImageView extensionIcon;
        TextView extensionDetails;
        TextView extensionDescription;
        int id2 = R.id.appInstall;
        Button appInstall = (Button)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (appInstall != null && (extensionDescription = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionDescription))) != null && (extensionDetails = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionDetails))) != null && (extensionIcon = (ImageView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionIcon))) != null && (extensionTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.extensionTitle))) != null && (fileInstall = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.fileInstall))) != null && (installButton = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installButton))) != null && (installationTypeGroup = (MaterialButtonToggleGroup)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeGroup))) != null && (installationTypeLinks = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeLinks))) != null && (installationTypeSummary = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeSummary))) != null && (installationTypeTitle = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeTitle))) != null && (installationTypeWarning = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.installationTypeWarning))) != null) {
            NestedScrollView scrollView = (NestedScrollView)rootView;
            id2 = R.id.topAppBar;
            MaterialToolbar topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)id2);
            if (topAppBar != null) {
                return new DialogExtensionInstallerBinding((NestedScrollView)rootView, appInstall, extensionDescription, extensionDetails, extensionIcon, extensionTitle, fileInstall, installButton, installationTypeGroup, installationTypeLinks, installationTypeSummary, installationTypeTitle, installationTypeWarning, scrollView, topAppBar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

