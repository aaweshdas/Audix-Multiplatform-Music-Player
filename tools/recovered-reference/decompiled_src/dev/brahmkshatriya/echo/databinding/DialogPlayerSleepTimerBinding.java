/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.Button
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.core.widget.NestedScrollView
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.appbar.MaterialToolbar
 *  com.google.android.material.button.MaterialButton
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import dev.brahmkshatriya.echo.R;

public final class DialogPlayerSleepTimerBinding
implements ViewBinding {
    @NonNull
    private final NestedScrollView rootView;
    @NonNull
    public final MaterialButton endOfTrack;
    @NonNull
    public final Button hr1;
    @NonNull
    public final Button hr2;
    @NonNull
    public final Button min15;
    @NonNull
    public final Button min30;
    @NonNull
    public final Button min45;
    @NonNull
    public final MaterialButton okay;
    @NonNull
    public final TextView sleepTimerDescription;
    @NonNull
    public final RecyclerView sleepTimerRecycler;
    @NonNull
    public final TextView sleepTimerValue;
    @NonNull
    public final MaterialToolbar topAppBar;

    private DialogPlayerSleepTimerBinding(@NonNull NestedScrollView rootView, @NonNull MaterialButton endOfTrack, @NonNull Button hr1, @NonNull Button hr2, @NonNull Button min15, @NonNull Button min30, @NonNull Button min45, @NonNull MaterialButton okay, @NonNull TextView sleepTimerDescription, @NonNull RecyclerView sleepTimerRecycler, @NonNull TextView sleepTimerValue, @NonNull MaterialToolbar topAppBar) {
        this.rootView = rootView;
        this.endOfTrack = endOfTrack;
        this.hr1 = hr1;
        this.hr2 = hr2;
        this.min15 = min15;
        this.min30 = min30;
        this.min45 = min45;
        this.okay = okay;
        this.sleepTimerDescription = sleepTimerDescription;
        this.sleepTimerRecycler = sleepTimerRecycler;
        this.sleepTimerValue = sleepTimerValue;
        this.topAppBar = topAppBar;
    }

    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static DialogPlayerSleepTimerBinding inflate(@NonNull LayoutInflater inflater) {
        return DialogPlayerSleepTimerBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static DialogPlayerSleepTimerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.dialog_player_sleep_timer, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return DialogPlayerSleepTimerBinding.bind(root);
    }

    @NonNull
    public static DialogPlayerSleepTimerBinding bind(@NonNull View rootView) {
        MaterialToolbar topAppBar;
        TextView sleepTimerValue;
        RecyclerView sleepTimerRecycler;
        TextView sleepTimerDescription;
        MaterialButton okay;
        Button min45;
        Button min30;
        Button min15;
        Button hr2;
        Button hr1;
        int id2 = R.id.endOfTrack;
        MaterialButton endOfTrack = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (endOfTrack != null && (hr1 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.hr1))) != null && (hr2 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.hr2))) != null && (min15 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.min15))) != null && (min30 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.min30))) != null && (min45 = (Button)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.min45))) != null && (okay = (MaterialButton)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.okay))) != null && (sleepTimerDescription = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sleepTimerDescription))) != null && (sleepTimerRecycler = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sleepTimerRecycler))) != null && (sleepTimerValue = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.sleepTimerValue))) != null && (topAppBar = (MaterialToolbar)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.topAppBar))) != null) {
            return new DialogPlayerSleepTimerBinding((NestedScrollView)rootView, endOfTrack, hr1, hr2, min15, min30, min45, okay, sleepTimerDescription, sleepTimerRecycler, sleepTimerValue, topAppBar);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

