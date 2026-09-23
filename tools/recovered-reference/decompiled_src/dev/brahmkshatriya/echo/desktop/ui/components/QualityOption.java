/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u001c"}, d2={"Ldev/brahmkshatriya/echo/desktop/ui/components/QualityOption;", "", "id", "", "title", "bitrate", "subtitle", "badge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getBitrate", "getSubtitle", "getBadge", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "desktopApp"})
@StabilityInferred(parameters=1)
public final class QualityOption {
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final String bitrate;
    @NotNull
    private final String subtitle;
    @NotNull
    private final String badge;
    public static final int $stable;

    public QualityOption(@NotNull String id2, @NotNull String title, @NotNull String bitrate, @NotNull String subtitle2, @NotNull String badge) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)bitrate, (String)"bitrate");
        Intrinsics.checkNotNullParameter((Object)subtitle2, (String)"subtitle");
        Intrinsics.checkNotNullParameter((Object)badge, (String)"badge");
        this.id = id2;
        this.title = title;
        this.bitrate = bitrate;
        this.subtitle = subtitle2;
        this.badge = badge;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getBitrate() {
        return this.bitrate;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getBadge() {
        return this.badge;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.bitrate;
    }

    @NotNull
    public final String component4() {
        return this.subtitle;
    }

    @NotNull
    public final String component5() {
        return this.badge;
    }

    @NotNull
    public final QualityOption copy(@NotNull String id2, @NotNull String title, @NotNull String bitrate, @NotNull String subtitle2, @NotNull String badge) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)bitrate, (String)"bitrate");
        Intrinsics.checkNotNullParameter((Object)subtitle2, (String)"subtitle");
        Intrinsics.checkNotNullParameter((Object)badge, (String)"badge");
        return new QualityOption(id2, title, bitrate, subtitle2, badge);
    }

    public static /* synthetic */ QualityOption copy$default(QualityOption qualityOption, String string2, String string3, String string4, String string5, String string6, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = qualityOption.id;
        }
        if ((n & 2) != 0) {
            string3 = qualityOption.title;
        }
        if ((n & 4) != 0) {
            string4 = qualityOption.bitrate;
        }
        if ((n & 8) != 0) {
            string5 = qualityOption.subtitle;
        }
        if ((n & 0x10) != 0) {
            string6 = qualityOption.badge;
        }
        return qualityOption.copy(string2, string3, string4, string5, string6);
    }

    @NotNull
    public String toString() {
        return "QualityOption(id=" + this.id + ", title=" + this.title + ", bitrate=" + this.bitrate + ", subtitle=" + this.subtitle + ", badge=" + this.badge + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + this.bitrate.hashCode();
        result2 = result2 * 31 + this.subtitle.hashCode();
        result2 = result2 * 31 + this.badge.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QualityOption)) {
            return false;
        }
        QualityOption qualityOption = (QualityOption)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)qualityOption.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)qualityOption.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bitrate, (Object)qualityOption.bitrate)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)qualityOption.subtitle)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.badge, (Object)qualityOption.badge);
    }
}

