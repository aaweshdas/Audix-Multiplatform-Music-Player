/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.settings;

import dev.brahmkshatriya.echo.common.settings.Setting;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u00c6\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingCategory;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "items", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getKey", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common"})
public final class SettingCategory
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @NotNull
    private final List<Setting> items;

    public SettingCategory(@NotNull String title, @NotNull String key, @NotNull List<? extends Setting> items2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(items2, (String)"items");
        this.title = title;
        this.key = key;
        this.items = items2;
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

    @NotNull
    public final List<Setting> getItems() {
        return this.items;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @NotNull
    public final List<Setting> component3() {
        return this.items;
    }

    @NotNull
    public final SettingCategory copy(@NotNull String title, @NotNull String key, @NotNull List<? extends Setting> items2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(items2, (String)"items");
        return new SettingCategory(title, key, items2);
    }

    public static /* synthetic */ SettingCategory copy$default(SettingCategory settingCategory, String string2, String string3, List list2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = settingCategory.title;
        }
        if ((n & 2) != 0) {
            string3 = settingCategory.key;
        }
        if ((n & 4) != 0) {
            list2 = settingCategory.items;
        }
        return settingCategory.copy(string2, string3, list2);
    }

    @NotNull
    public String toString() {
        return "SettingCategory(title=" + this.title + ", key=" + this.key + ", items=" + this.items + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + ((Object)this.items).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingCategory)) {
            return false;
        }
        SettingCategory settingCategory = (SettingCategory)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingCategory.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingCategory.key)) {
            return false;
        }
        return Intrinsics.areEqual(this.items, settingCategory.items);
    }
}

