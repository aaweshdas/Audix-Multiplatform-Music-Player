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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u001a"}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingTextInput;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "summary", "defaultValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getKey", "getSummary", "getDefaultValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common"})
public final class SettingTextInput
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @Nullable
    private final String summary;
    @Nullable
    private final String defaultValue;

    public SettingTextInput(@NotNull String title, @NotNull String key, @Nullable String summary, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.title = title;
        this.key = key;
        this.summary = summary;
        this.defaultValue = defaultValue;
    }

    public /* synthetic */ SettingTextInput(String string2, String string3, String string4, String string5, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string4 = null;
        }
        if ((n & 8) != 0) {
            string5 = null;
        }
        this(string2, string3, string4, string5);
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
    public final String getDefaultValue() {
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

    @Nullable
    public final String component4() {
        return this.defaultValue;
    }

    @NotNull
    public final SettingTextInput copy(@NotNull String title, @NotNull String key, @Nullable String summary, @Nullable String defaultValue) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return new SettingTextInput(title, key, summary, defaultValue);
    }

    public static /* synthetic */ SettingTextInput copy$default(SettingTextInput settingTextInput, String string2, String string3, String string4, String string5, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = settingTextInput.title;
        }
        if ((n & 2) != 0) {
            string3 = settingTextInput.key;
        }
        if ((n & 4) != 0) {
            string4 = settingTextInput.summary;
        }
        if ((n & 8) != 0) {
            string5 = settingTextInput.defaultValue;
        }
        return settingTextInput.copy(string2, string3, string4, string5);
    }

    @NotNull
    public String toString() {
        return "SettingTextInput(title=" + this.title + ", key=" + this.key + ", summary=" + this.summary + ", defaultValue=" + this.defaultValue + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + (this.summary == null ? 0 : this.summary.hashCode());
        result2 = result2 * 31 + (this.defaultValue == null ? 0 : this.defaultValue.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingTextInput)) {
            return false;
        }
        SettingTextInput settingTextInput = (SettingTextInput)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingTextInput.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingTextInput.key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.summary, (Object)settingTextInput.summary)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.defaultValue, (Object)settingTextInput.defaultValue);
    }
}

