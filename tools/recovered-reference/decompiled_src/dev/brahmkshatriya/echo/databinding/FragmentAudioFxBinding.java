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
 *  androidx.recyclerview.widget.RecyclerView
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  com.google.android.material.materialswitch.MaterialSwitch
 *  com.google.android.material.slider.Slider
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$layout
 *  me.zhanghai.android.fastscroll.FastScrollNestedScrollView
 */
package dev.brahmkshatriya.echo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.slider.Slider;
import dev.brahmkshatriya.echo.R;
import me.zhanghai.android.fastscroll.FastScrollNestedScrollView;

public final class FragmentAudioFxBinding
implements ViewBinding {
    @NonNull
    private final FastScrollNestedScrollView rootView;
    @NonNull
    public final Slider bassBoostSlider;
    @NonNull
    public final LinearLayout equalizer;
    @NonNull
    public final LinearLayout pitch;
    @NonNull
    public final MaterialSwitch pitchSwitch;
    @NonNull
    public final RecyclerView speedRecycler;
    @NonNull
    public final TextView speedValue;

    private FragmentAudioFxBinding(@NonNull FastScrollNestedScrollView rootView, @NonNull Slider bassBoostSlider, @NonNull LinearLayout equalizer, @NonNull LinearLayout pitch, @NonNull MaterialSwitch pitchSwitch, @NonNull RecyclerView speedRecycler, @NonNull TextView speedValue) {
        this.rootView = rootView;
        this.bassBoostSlider = bassBoostSlider;
        this.equalizer = equalizer;
        this.pitch = pitch;
        this.pitchSwitch = pitchSwitch;
        this.speedRecycler = speedRecycler;
        this.speedValue = speedValue;
    }

    @NonNull
    public FastScrollNestedScrollView getRoot() {
        return this.rootView;
    }

    @NonNull
    public static FragmentAudioFxBinding inflate(@NonNull LayoutInflater inflater) {
        return FragmentAudioFxBinding.inflate(inflater, null, false);
    }

    @NonNull
    public static FragmentAudioFxBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.fragment_audio_fx, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return FragmentAudioFxBinding.bind(root);
    }

    @NonNull
    public static FragmentAudioFxBinding bind(@NonNull View rootView) {
        TextView speedValue;
        RecyclerView speedRecycler;
        MaterialSwitch pitchSwitch;
        LinearLayout pitch;
        LinearLayout equalizer;
        int id2 = R.id.bassBoostSlider;
        Slider bassBoostSlider = (Slider)ViewBindings.findChildViewById((View)rootView, (int)id2);
        if (bassBoostSlider != null && (equalizer = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.equalizer))) != null && (pitch = (LinearLayout)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.pitch))) != null && (pitchSwitch = (MaterialSwitch)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.pitchSwitch))) != null && (speedRecycler = (RecyclerView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.speed_recycler))) != null && (speedValue = (TextView)ViewBindings.findChildViewById((View)rootView, (int)(id2 = R.id.speedValue))) != null) {
            return new FragmentAudioFxBinding((FastScrollNestedScrollView)rootView, bassBoostSlider, equalizer, pitch, pitchSwitch, speedRecycler, speedValue);
        }
        String missingId = rootView.getResources().getResourceName(id2);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}

