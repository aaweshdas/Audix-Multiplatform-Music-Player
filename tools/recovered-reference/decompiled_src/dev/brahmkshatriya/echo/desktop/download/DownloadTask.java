/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.download;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.Track;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001*BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006+"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/DownloadTask;", "", "id", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "status", "Ldev/brahmkshatriya/echo/desktop/download/DownloadTask$Status;", "progress", "", "bytesRead", "", "totalBytes", "errorMessage", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/desktop/download/DownloadTask$Status;FJJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTrack", "()Ldev/brahmkshatriya/echo/common/models/Track;", "getStatus", "()Ldev/brahmkshatriya/echo/desktop/download/DownloadTask$Status;", "getProgress", "()F", "getBytesRead", "()J", "getTotalBytes", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "desktopApp"})
@StabilityInferred(parameters=0)
public final class DownloadTask {
    @NotNull
    private final String id;
    @NotNull
    private final Track track;
    @NotNull
    private final Status status;
    private final float progress;
    private final long bytesRead;
    private final long totalBytes;
    @Nullable
    private final String errorMessage;
    public static final int $stable = 8;

    public DownloadTask(@NotNull String id2, @NotNull Track track2, @NotNull Status status, float progress, long bytesRead, long totalBytes, @Nullable String errorMessage) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        this.id = id2;
        this.track = track2;
        this.status = status;
        this.progress = progress;
        this.bytesRead = bytesRead;
        this.totalBytes = totalBytes;
        this.errorMessage = errorMessage;
    }

    public /* synthetic */ DownloadTask(String string2, Track track2, Status status, float f, long l, long l2, String string3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x40) != 0) {
            string3 = null;
        }
        this(string2, track2, status, f, l, l2, string3);
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
    public final Status getStatus() {
        return this.status;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final long getBytesRead() {
        return this.bytesRead;
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
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
    public final Status component3() {
        return this.status;
    }

    public final float component4() {
        return this.progress;
    }

    public final long component5() {
        return this.bytesRead;
    }

    public final long component6() {
        return this.totalBytes;
    }

    @Nullable
    public final String component7() {
        return this.errorMessage;
    }

    @NotNull
    public final DownloadTask copy(@NotNull String id2, @NotNull Track track2, @NotNull Status status, float progress, long bytesRead, long totalBytes, @Nullable String errorMessage) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        return new DownloadTask(id2, track2, status, progress, bytesRead, totalBytes, errorMessage);
    }

    public static /* synthetic */ DownloadTask copy$default(DownloadTask downloadTask, String string2, Track track2, Status status, float f, long l, long l2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = downloadTask.id;
        }
        if ((n & 2) != 0) {
            track2 = downloadTask.track;
        }
        if ((n & 4) != 0) {
            status = downloadTask.status;
        }
        if ((n & 8) != 0) {
            f = downloadTask.progress;
        }
        if ((n & 0x10) != 0) {
            l = downloadTask.bytesRead;
        }
        if ((n & 0x20) != 0) {
            l2 = downloadTask.totalBytes;
        }
        if ((n & 0x40) != 0) {
            string3 = downloadTask.errorMessage;
        }
        return downloadTask.copy(string2, track2, status, f, l, l2, string3);
    }

    @NotNull
    public String toString() {
        return "DownloadTask(id=" + this.id + ", track=" + this.track + ", status=" + this.status + ", progress=" + this.progress + ", bytesRead=" + this.bytesRead + ", totalBytes=" + this.totalBytes + ", errorMessage=" + this.errorMessage + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.track.hashCode();
        result2 = result2 * 31 + this.status.hashCode();
        result2 = result2 * 31 + Float.hashCode(this.progress);
        result2 = result2 * 31 + Long.hashCode(this.bytesRead);
        result2 = result2 * 31 + Long.hashCode(this.totalBytes);
        result2 = result2 * 31 + (this.errorMessage == null ? 0 : this.errorMessage.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadTask)) {
            return false;
        }
        DownloadTask downloadTask = (DownloadTask)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)downloadTask.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track, (Object)downloadTask.track)) {
            return false;
        }
        if (this.status != downloadTask.status) {
            return false;
        }
        if (Float.compare(this.progress, downloadTask.progress) != 0) {
            return false;
        }
        if (this.bytesRead != downloadTask.bytesRead) {
            return false;
        }
        if (this.totalBytes != downloadTask.totalBytes) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.errorMessage, (Object)downloadTask.errorMessage);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/DownloadTask$Status;", "", "<init>", "(Ljava/lang/String;I)V", "QUEUED", "CONNECTING", "DOWNLOADING", "COMPLETED", "FAILED", "CANCELLED", "desktopApp"})
    public static final class Status
    extends Enum<Status> {
        public static final /* enum */ Status QUEUED = new Status();
        public static final /* enum */ Status CONNECTING = new Status();
        public static final /* enum */ Status DOWNLOADING = new Status();
        public static final /* enum */ Status COMPLETED = new Status();
        public static final /* enum */ Status FAILED = new Status();
        public static final /* enum */ Status CANCELLED = new Status();
        private static final /* synthetic */ Status[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }

        public static Status valueOf(String value2) {
            return Enum.valueOf(Status.class, value2);
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = statusArray = new Status[]{Status.QUEUED, Status.CONNECTING, Status.DOWNLOADING, Status.COMPLETED, Status.FAILED, Status.CANCELLED};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

