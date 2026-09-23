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
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u00c6\u0003J[\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingMultipleChoice;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "summary", "entryTitles", "", "entryValues", "defaultEntryIndices", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Set;)V", "getTitle", "()Ljava/lang/String;", "getKey", "getSummary", "getEntryTitles", "()Ljava/util/List;", "getEntryValues", "getDefaultEntryIndices", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "common"})
public final class SettingMultipleChoice
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @Nullable
    private final String summary;
    @NotNull
    private final List<String> entryTitles;
    @NotNull
    private final List<String> entryValues;
    @Nullable
    private final Set<Integer> defaultEntryIndices;

    public SettingMultipleChoice(@NotNull String title, @NotNull String key, @Nullable String summary, @NotNull List<String> entryTitles, @NotNull List<String> entryValues, @Nullable Set<Integer> defaultEntryIndices) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(entryTitles, (String)"entryTitles");
        Intrinsics.checkNotNullParameter(entryValues, (String)"entryValues");
        this.title = title;
        this.key = key;
        this.summary = summary;
        this.entryTitles = entryTitles;
        this.entryValues = entryValues;
        this.defaultEntryIndices = defaultEntryIndices;
    }

    public /* synthetic */ SettingMultipleChoice(String string2, String string3, String string4, List list2, List list3, Set set, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string4 = null;
        }
        if ((n & 0x20) != 0) {
            set = null;
        }
        this(string2, string3, string4, list2, list3, set);
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

    @NotNull
    public final List<String> getEntryTitles() {
        return this.entryTitles;
    }

    @NotNull
    public final List<String> getEntryValues() {
        return this.entryValues;
    }

    @Nullable
    public final Set<Integer> getDefaultEntryIndices() {
        return this.defaultEntryIndices;
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

    @NotNull
    public final List<String> component4() {
        return this.entryTitles;
    }

    @NotNull
    public final List<String> component5() {
        return this.entryValues;
    }

    @Nullable
    public final Set<Integer> component6() {
        return this.defaultEntryIndices;
    }

    @NotNull
    public final SettingMultipleChoice copy(@NotNull String title, @NotNull String key, @Nullable String summary, @NotNull List<String> entryTitles, @NotNull List<String> entryValues, @Nullable Set<Integer> defaultEntryIndices) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(entryTitles, (String)"entryTitles");
        Intrinsics.checkNotNullParameter(entryValues, (String)"entryValues");
        return new SettingMultipleChoice(title, key, summary, entryTitles, entryValues, defaultEntryIndices);
    }

    public static /* synthetic */ SettingMultipleChoice copy$default(SettingMultipleChoice settingMultipleChoice, String string2, String string3, String string4, List list2, List list3, Set set, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = settingMultipleChoice.title;
        }
        if ((n & 2) != 0) {
            string3 = settingMultipleChoice.key;
        }
        if ((n & 4) != 0) {
            string4 = settingMultipleChoice.summary;
        }
        if ((n & 8) != 0) {
            list2 = settingMultipleChoice.entryTitles;
        }
        if ((n & 0x10) != 0) {
            list3 = settingMultipleChoice.entryValues;
        }
        if ((n & 0x20) != 0) {
            set = settingMultipleChoice.defaultEntryIndices;
        }
        return settingMultipleChoice.copy(string2, string3, string4, list2, list3, set);
    }

    @NotNull
    public String toString() {
        return "SettingMultipleChoice(title=" + this.title + ", key=" + this.key + ", summary=" + this.summary + ", entryTitles=" + this.entryTitles + ", entryValues=" + this.entryValues + ", defaultEntryIndices=" + this.defaultEntryIndices + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + (this.summary == null ? 0 : this.summary.hashCode());
        result2 = result2 * 31 + ((Object)this.entryTitles).hashCode();
        result2 = result2 * 31 + ((Object)this.entryValues).hashCode();
        result2 = result2 * 31 + (this.defaultEntryIndices == null ? 0 : ((Object)this.defaultEntryIndices).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingMultipleChoice)) {
            return false;
        }
        SettingMultipleChoice settingMultipleChoice = (SettingMultipleChoice)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingMultipleChoice.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingMultipleChoice.key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.summary, (Object)settingMultipleChoice.summary)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.entryTitles, settingMultipleChoice.entryTitles)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.entryValues, settingMultipleChoice.entryValues)) {
            return false;
        }
        return Intrinsics.areEqual(this.defaultEntryIndices, settingMultipleChoice.defaultEntryIndices);
    }
}

