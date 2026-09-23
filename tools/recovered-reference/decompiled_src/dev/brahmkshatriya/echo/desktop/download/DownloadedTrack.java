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
package dev.brahmkshatriya.echo.desktop.download;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.Track;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/DownloadedTrack;", "", "id", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "file", "Ljava/io/File;", "sizeBytes", "", "format", "dateAdded", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ljava/io/File;JLjava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getTrack", "()Ldev/brahmkshatriya/echo/common/models/Track;", "getFile", "()Ljava/io/File;", "getSizeBytes", "()J", "getFormat", "getDateAdded", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "desktopApp"})
@StabilityInferred(parameters=0)
public final class DownloadedTrack {
    @NotNull
    private final String id;
    @NotNull
    private final Track track;
    @NotNull
    private final File file;
    private final long sizeBytes;
    @NotNull
    private final String format;
    private final long dateAdded;
    public static final int $stable = 8;

    public DownloadedTrack(@NotNull String id2, @NotNull Track track2, @NotNull File file2, long sizeBytes, @NotNull String format, long dateAdded) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"file");
        Intrinsics.checkNotNullParameter((Object)format, (String)"format");
        this.id = id2;
        this.track = track2;
        this.file = file2;
        this.sizeBytes = sizeBytes;
        this.format = format;
        this.dateAdded = dateAdded;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Track getTrack() {
        return this.track;
    }

    @NotNull
    public final File getFile() {
        return this.file;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    @NotNull
    public final String getFormat() {
        return this.format;
    }

    public final long getDateAdded() {
        return this.dateAdded;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final Track component2() {
        return this.track;
    }

    @NotNull
    public final File component3() {
        return this.file;
    }

    public final long component4() {
        return this.sizeBytes;
    }

    @NotNull
    public final String component5() {
        return this.format;
    }

    public final long component6() {
        return this.dateAdded;
    }

    @NotNull
    public final DownloadedTrack copy(@NotNull String id2, @NotNull Track track2, @NotNull File file2, long sizeBytes, @NotNull String format, long dateAdded) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        Intrinsics.checkNotNullParameter((Object)file2, (String)"file");
        Intrinsics.checkNotNullParameter((Object)format, (String)"format");
        return new DownloadedTrack(id2, track2, file2, sizeBytes, format, dateAdded);
    }

    public static /* synthetic */ DownloadedTrack copy$default(DownloadedTrack downloadedTrack, String string2, Track track2, File file2, long l, String string3, long l2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = downloadedTrack.id;
        }
        if ((n & 2) != 0) {
            track2 = downloadedTrack.track;
        }
        if ((n & 4) != 0) {
            file2 = downloadedTrack.file;
        }
        if ((n & 8) != 0) {
            l = downloadedTrack.sizeBytes;
        }
        if ((n & 0x10) != 0) {
            string3 = downloadedTrack.format;
        }
        if ((n & 0x20) != 0) {
            l2 = downloadedTrack.dateAdded;
        }
        return downloadedTrack.copy(string2, track2, file2, l, string3, l2);
    }

    @NotNull
    public String toString() {
        return "DownloadedTrack(id=" + this.id + ", track=" + this.track + ", file=" + this.file + ", sizeBytes=" + this.sizeBytes + ", format=" + this.format + ", dateAdded=" + this.dateAdded + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.track.hashCode();
        result2 = result2 * 31 + this.file.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.sizeBytes);
        result2 = result2 * 31 + this.format.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.dateAdded);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadedTrack)) {
            return false;
        }
        DownloadedTrack downloadedTrack = (DownloadedTrack)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)downloadedTrack.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track, (Object)downloadedTrack.track)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.file, (Object)downloadedTrack.file)) {
            return false;
        }
        if (this.sizeBytes != downloadedTrack.sizeBytes) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.format, (Object)downloadedTrack.format)) {
            return false;
        }
        return this.dateAdded == downloadedTrack.dateAdded;
    }
}

