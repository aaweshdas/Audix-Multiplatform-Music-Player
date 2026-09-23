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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingSwitch;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "summary", "defaultValue", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "getKey", "getSummary", "getDefaultValue", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "common"})
public final class SettingSwitch
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @Nullable
    private final String summary;
    private final boolean defaultValue;

    public SettingSwitch(@NotNull String title, @NotNull String key, @Nullable String summary, boolean defaultValue) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.title = title;
        this.key = key;
        this.summary = summary;
        this.defaultValue = defaultValue;
    }

    public /* synthetic */ SettingSwitch(String string2, String string3, String string4, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string4 = null;
        }
        this(string2, string3, string4, bl);
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

    public final boolean getDefaultValue() {
        return this.defaultValue;
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

    public final boolean component4() {
        return this.defaultValue;
    }

    @NotNull
    public final SettingSwitch copy(@NotNull String title, @NotNull String key, @Nullable String summary, boolean defaultValue) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return new SettingSwitch(title, key, summary, defaultValue);
    }

    public static /* synthetic */ SettingSwitch copy$default(SettingSwitch settingSwitch, String string2, String string3, String string4, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = settingSwitch.title;
        }
        if ((n & 2) != 0) {
            string3 = settingSwitch.key;
        }
        if ((n & 4) != 0) {
            string4 = settingSwitch.summary;
        }
        if ((n & 8) != 0) {
            bl = settingSwitch.defaultValue;
        }
        return settingSwitch.copy(string2, string3, string4, bl);
    }

    @NotNull
    public String toString() {
        return "SettingSwitch(title=" + this.title + ", key=" + this.key + ", summary=" + this.summary + ", defaultValue=" + this.defaultValue + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + (this.summary == null ? 0 : this.summary.hashCode());
        result2 = result2 * 31 + Boolean.hashCode(this.defaultValue);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingSwitch)) {
            return false;
        }
        SettingSwitch settingSwitch = (SettingSwitch)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingSwitch.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingSwitch.key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.summary, (Object)settingSwitch.summary)) {
            return false;
        }
        return this.defaultValue == settingSwitch.defaultValue;
    }
}

