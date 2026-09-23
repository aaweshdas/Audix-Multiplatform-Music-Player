/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0019"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DownloadRequest;", "", "downloadId", "", "trackJson", "contextJson", "extensionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDownloadId", "()Ljava/lang/String;", "getTrackJson", "getContextJson", "getExtensionId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "core"})
public final class DownloadRequest {
    @NotNull
    private final String downloadId;
    @NotNull
    private final String trackJson;
    @NotNull
    private final String contextJson;
    @NotNull
    private final String extensionId;

    public DownloadRequest(@NotNull String downloadId, @NotNull String trackJson, @NotNull String contextJson, @NotNull String extensionId) {
        Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
        Intrinsics.checkNotNullParameter((Object)trackJson, (String)"trackJson");
        Intrinsics.checkNotNullParameter((Object)contextJson, (String)"contextJson");
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        this.downloadId = downloadId;
        this.trackJson = trackJson;
        this.contextJson = contextJson;
        this.extensionId = extensionId;
    }

    @NotNull
    public final String getDownloadId() {
        return this.downloadId;
    }

    @NotNull
    public final String getTrackJson() {
        return this.trackJson;
    }

    @NotNull
    public final String getContextJson() {
        return this.contextJson;
    }

    @NotNull
    public final String getExtensionId() {
        return this.extensionId;
    }

    @NotNull
    public final String component1() {
        return this.downloadId;
    }

    @NotNull
    public final String component2() {
        return this.trackJson;
    }

    @NotNull
    public final String component3() {
        return this.contextJson;
    }

    @NotNull
    public final String component4() {
        return this.extensionId;
    }

    @NotNull
    public final DownloadRequest copy(@NotNull String downloadId, @NotNull String trackJson, @NotNull String contextJson, @NotNull String extensionId) {
        Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
        Intrinsics.checkNotNullParameter((Object)trackJson, (String)"trackJson");
        Intrinsics.checkNotNullParameter((Object)contextJson, (String)"contextJson");
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        return new DownloadRequest(downloadId, trackJson, contextJson, extensionId);
    }

    public static /* synthetic */ DownloadRequest copy$default(DownloadRequest downloadRequest, String string2, String string3, String string4, String string5, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = downloadRequest.downloadId;
        }
        if ((n & 2) != 0) {
            string3 = downloadRequest.trackJson;
        }
        if ((n & 4) != 0) {
            string4 = downloadRequest.contextJson;
        }
        if ((n & 8) != 0) {
            string5 = downloadRequest.extensionId;
        }
        return downloadRequest.copy(string2, string3, string4, string5);
    }

    @NotNull
    public String toString() {
        return "DownloadRequest(downloadId=" + this.downloadId + ", trackJson=" + this.trackJson + ", contextJson=" + this.contextJson + ", extensionId=" + this.extensionId + ")";
    }

    public int hashCode() {
        int result2 = this.downloadId.hashCode();
        result2 = result2 * 31 + this.trackJson.hashCode();
        result2 = result2 * 31 + this.contextJson.hashCode();
        result2 = result2 * 31 + this.extensionId.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest)other;
        if (!Intrinsics.areEqual((Object)this.downloadId, (Object)downloadRequest.downloadId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackJson, (Object)downloadRequest.trackJson)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.contextJson, (Object)downloadRequest.contextJson)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.extensionId, (Object)downloadRequest.extensionId);
    }
}

