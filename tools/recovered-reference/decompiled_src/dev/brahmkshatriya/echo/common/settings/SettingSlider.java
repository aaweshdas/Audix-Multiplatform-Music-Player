/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.settings;

import dev.brahmkshatriya.echo.common.settings.Setting;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\fH\u00c6\u0003Jd\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001\u00a2\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020\u0007H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006+"}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingSlider;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "summary", "defaultValue", "", "from", "to", "steps", "allowOverride", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILjava/lang/Integer;Z)V", "getTitle", "()Ljava/lang/String;", "getKey", "getSummary", "getDefaultValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrom", "()I", "getTo", "getSteps", "getAllowOverride", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IILjava/lang/Integer;Z)Ldev/brahmkshatriya/echo/common/settings/SettingSlider;", "equals", "other", "", "hashCode", "toString", "common"})
public final class SettingSlider
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @Nullable
    private final String summary;
    @Nullable
    private final Integer defaultValue;
    private final int from;
    private final int to;
    @Nullable
    private final Integer steps;
    private final boolean allowOverride;

    public SettingSlider(@NotNull String title, @NotNull String key, @Nullable String summary, @Nullable Integer defaultValue, int from, int to, @Nullable Integer steps, boolean allowOverride) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.title = title;
        this.key = key;
        this.summary = summary;
        this.defaultValue = defaultValue;
        this.from = from;
        this.to = to;
        this.steps = steps;
        this.allowOverride = allowOverride;
    }

    public /* synthetic */ SettingSlider(String string2, String string3, String string4, Integer n, int n2, int n3, Integer n4, boolean bl, int n5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n5 & 4) != 0) {
            string4 = null;
        }
        if ((n5 & 8) != 0) {
            n = null;
        }
        if ((n5 & 0x40) != 0) {
            n4 = null;
        }
        if ((n5 & 0x80) != 0) {
            bl = false;
        }
        this(string2, string3, string4, n, n2, n3, n4, bl);
    }

    @Override
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override
    @NotNull
    public String getKey() {
        return this.key;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final Integer getDefaultValue() {
        return this.defaultValue;
    }

    public final int getFrom() {
        return this.from;
    }

    public final int getTo() {
        return this.to;
    }

    @Nullable
    public final Integer getSteps() {
        return this.steps;
    }

    public final boolean getAllowOverride() {
        return this.allowOverride;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @Nullable
    public final String component3() {
        return this.summary;
    }

    @Nullable
    public final Integer component4() {
        return this.defaultValue;
    }

    public final int component5() {
        return this.from;
    }

    public final int component6() {
        return this.to;
    }

    @Nullable
    public final Integer component7() {
        return this.steps;
    }

    public final boolean component8() {
        return this.allowOverride;
    }

    @NotNull
    public final SettingSlider copy(@NotNull String title, @NotNull String key, @Nullable String summary, @Nullable Integer defaultValue, int from, int to, @Nullable Integer steps, boolean allowOverride) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return new SettingSlider(title, key, summary, defaultValue, from, to, steps, allowOverride);
    }

    public static /* synthetic */ SettingSlider copy$default(SettingSlider settingSlider, String string2, String string3, String string4, Integer n, int n2, int n3, Integer n4, boolean bl, int n5, Object object) {
        if ((n5 & 1) != 0) {
            string2 = settingSlider.title;
        }
        if ((n5 & 2) != 0) {
            string3 = settingSlider.key;
        }
        if ((n5 & 4) != 0) {
            string4 = settingSlider.summary;
        }
        if ((n5 & 8) != 0) {
            n = settingSlider.defaultValue;
        }
        if ((n5 & 0x10) != 0) {
            n2 = settingSlider.from;
        }
        if ((n5 & 0x20) != 0) {
            n3 = settingSlider.to;
        }
        if ((n5 & 0x40) != 0) {
            n4 = settingSlider.steps;
        }
        if ((n5 & 0x80) != 0) {
            bl = settingSlider.allowOverride;
        }
        return settingSlider.copy(string2, string3, string4, n, n2, n3, n4, bl);
    }

    @NotNull
    public String toString() {
        return "SettingSlider(title=" + this.title + ", key=" + this.key + ", summary=" + this.summary + ", defaultValue=" + this.defaultValue + ", from=" + this.from + ", to=" + this.to + ", steps=" + this.steps + ", allowOverride=" + this.allowOverride + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + (this.summary == null ? 0 : this.summary.hashCode());
        result2 = result2 * 31 + (this.defaultValue == null ? 0 : ((Object)this.defaultValue).hashCode());
        result2 = result2 * 31 + Integer.hashCode(this.from);
        result2 = result2 * 31 + Integer.hashCode(this.to);
        result2 = result2 * 31 + (this.steps == null ? 0 : ((Object)this.steps).hashCode());
        result2 = result2 * 31 + Boolean.hashCode(this.allowOverride);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingSlider)) {
            return false;
        }
        SettingSlider settingSlider = (SettingSlider)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingSlider.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingSlider.key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.summary, (Object)settingSlider.summary)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.defaultValue, (Object)settingSlider.defaultValue)) {
            return false;
        }
        if (this.from != settingSlider.from) {
            return false;
        }
        if (this.to != settingSlider.to) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.steps, (Object)settingSlider.steps)) {
            return false;
        }
        return this.allowOverride == settingSlider.allowOverride;
    }
}

