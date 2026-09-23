/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JI\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DownloadStatus;", "", "downloadId", "", "trackTitle", "status", "Ldev/brahmkshatriya/echo/core/platform/DownloadStatus$Status;", "progress", "", "filePath", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/core/platform/DownloadStatus$Status;FLjava/lang/String;Ljava/lang/String;)V", "getDownloadId", "()Ljava/lang/String;", "getTrackTitle", "getStatus", "()Ldev/brahmkshatriya/echo/core/platform/DownloadStatus$Status;", "getProgress", "()F", "getFilePath", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "core"})
public final class DownloadStatus {
    @NotNull
    private final String downloadId;
    @NotNull
    private final String trackTitle;
    @NotNull
    private final Status status;
    private final float progress;
    @Nullable
    private final String filePath;
    @Nullable
    private final String errorMessage;

    public DownloadStatus(@NotNull String downloadId, @NotNull String trackTitle, @NotNull Status status, float progress, @Nullable String filePath, @Nullable String errorMessage) {
        Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
        Intrinsics.checkNotNullParameter((Object)trackTitle, (String)"trackTitle");
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        this.downloadId = downloadId;
        this.trackTitle = trackTitle;
        this.status = status;
        this.progress = progress;
        this.filePath = filePath;
        this.errorMessage = errorMessage;
    }

    public /* synthetic */ DownloadStatus(String string2, String string3, Status status, float f, String string4, String string5, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x10) != 0) {
            string4 = null;
        }
        if ((n & 0x20) != 0) {
            string5 = null;
        }
        this(string2, string3, status, f, string4, string5);
    }

    @NotNull
    public final String getDownloadId() {
        return this.downloadId;
    }

    @NotNull
    public final String getTrackTitle() {
        return this.trackTitle;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    public final float getProgress() {
        return this.progress;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final String component1() {
        return this.downloadId;
    }

    @NotNull
    public final String component2() {
        return this.trackTitle;
    }

    @NotNull
    public final Status component3() {
        return this.status;
    }

    public final float component4() {
        return this.progress;
    }

    @Nullable
    public final String component5() {
        return this.filePath;
    }

    @Nullable
    public final String component6() {
        return this.errorMessage;
    }

    @NotNull
    public final DownloadStatus copy(@NotNull String downloadId, @NotNull String trackTitle, @NotNull Status status, float progress, @Nullable String filePath, @Nullable String errorMessage) {
        Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
        Intrinsics.checkNotNullParameter((Object)trackTitle, (String)"trackTitle");
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        return new DownloadStatus(downloadId, trackTitle, status, progress, filePath, errorMessage);
    }

    public static /* synthetic */ DownloadStatus copy$default(DownloadStatus downloadStatus, String string2, String string3, Status status, float f, String string4, String string5, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = downloadStatus.downloadId;
        }
        if ((n & 2) != 0) {
            string3 = downloadStatus.trackTitle;
        }
        if ((n & 4) != 0) {
            status = downloadStatus.status;
        }
        if ((n & 8) != 0) {
            f = downloadStatus.progress;
        }
        if ((n & 0x10) != 0) {
            string4 = downloadStatus.filePath;
        }
        if ((n & 0x20) != 0) {
            string5 = downloadStatus.errorMessage;
        }
        return downloadStatus.copy(string2, string3, status, f, string4, string5);
    }

    @NotNull
    public String toString() {
        return "DownloadStatus(downloadId=" + this.downloadId + ", trackTitle=" + this.trackTitle + ", status=" + this.status + ", progress=" + this.progress + ", filePath=" + this.filePath + ", errorMessage=" + this.errorMessage + ")";
    }

    public int hashCode() {
        int result2 = this.downloadId.hashCode();
        result2 = result2 * 31 + this.trackTitle.hashCode();
        result2 = result2 * 31 + this.status.hashCode();
        result2 = result2 * 31 + Float.hashCode(this.progress);
        result2 = result2 * 31 + (this.filePath == null ? 0 : this.filePath.hashCode());
        result2 = result2 * 31 + (this.errorMessage == null ? 0 : this.errorMessage.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadStatus)) {
            return false;
        }
        DownloadStatus downloadStatus = (DownloadStatus)other;
        if (!Intrinsics.areEqual((Object)this.downloadId, (Object)downloadStatus.downloadId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackTitle, (Object)downloadStatus.trackTitle)) {
            return false;
        }
        if (this.status != downloadStatus.status) {
            return false;
        }
        if (Float.compare(this.progress, downloadStatus.progress) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.filePath, (Object)downloadStatus.filePath)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.errorMessage, (Object)downloadStatus.errorMessage);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DownloadStatus$Status;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "LOADING", "DOWNLOADING", "MERGING", "TAGGING", "COMPLETED", "FAILED", "CANCELLED", "core"})
    public static final class Status
    extends Enum<Status> {
        public static final /* enum */ Status PENDING = new Status();
        public static final /* enum */ Status LOADING = new Status();
        public static final /* enum */ Status DOWNLOADING = new Status();
        public static final /* enum */ Status MERGING = new Status();
        public static final /* enum */ Status TAGGING = new Status();
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
            $VALUES = statusArray = new Status[]{Status.PENDING, Status.LOADING, Status.DOWNLOADING, Status.MERGING, Status.TAGGING, Status.COMPLETED, Status.FAILED, Status.CANCELLED};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

