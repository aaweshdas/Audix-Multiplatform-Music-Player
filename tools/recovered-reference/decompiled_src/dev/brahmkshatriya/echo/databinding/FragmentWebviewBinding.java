/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.progressindicator.LinearProgressIndicator
 *  com.telefonica.nestedscrollwebview.NestedScrollWebView
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.telefonica.nestedscrollwebview.NestedScrollWebView;
import dev.brahmkshatriya.echo.R;

public final class FragmentWebviewBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final LinearProgressIndicator progress;
    @NonNull
    public final NestedScrollWebView webview;

    private FragmentWebviewBinding(@NonNull FrameLayout rootView, @NonNull LinearProgressIndicator progress, @NonNull NestedScrollWebView webview) {
        this.rootView = rootView;
        this.progress = progress;
        this.webview = webview;
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentWebviewBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentWebviewBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentWebviewBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_webview, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentWebviewBinding.bind(root);
    }

    @NonNull
    public static FragmentWebviewBinding bind(@NonNull View rootView) {
        NestedScrollWebView webview;
        int id2 = R.id.progress;
        LinearProgressIndicator progress = (LinearProgressIndicator)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (progress != null && (webview = (NestedScrollWebView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.webview))) != null) {
            return new FragmentWebviewBinding((FrameLayout)rootView, progress, webview);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

