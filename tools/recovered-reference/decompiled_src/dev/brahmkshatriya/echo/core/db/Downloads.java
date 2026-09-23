/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\bH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003Je\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006,"}, d2={"Ldev/brahmkshatriya/echo/core/db/Downloads;", "", "id", "", "track_id", "extension_id", "status", "progress", "", "file_path", "created_at", "", "track_json", "context_json", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTrack_id", "getExtension_id", "getStatus", "getProgress", "()D", "getFile_path", "getCreated_at", "()J", "getTrack_json", "getContext_json", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "core"})
public final class Downloads {
    @NotNull
    private final String id;
    @NotNull
    private final String track_id;
    @NotNull
    private final String extension_id;
    @NotNull
    private final String status;
    private final double progress;
    @Nullable
    private final String file_path;
    private final long created_at;
    @NotNull
    private final String track_json;
    @NotNull
    private final String context_json;

    public Downloads(@NotNull String id2, @NotNull String track_id, @NotNull String extension_id, @NotNull String status, double progress, @Nullable String file_path, long created_at, @NotNull String track_json, @NotNull String context_json) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track_id, (String)"track_id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)track_json, (String)"track_json");
        Intrinsics.checkNotNullParameter((Object)context_json, (String)"context_json");
        this.id = id2;
        this.track_id = track_id;
        this.extension_id = extension_id;
        this.status = status;
        this.progress = progress;
        this.file_path = file_path;
        this.created_at = created_at;
        this.track_json = track_json;
        this.context_json = context_json;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTrack_id() {
        return this.track_id;
    }

    @NotNull
    public final String getExtension_id() {
        return this.extension_id;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    public final double getProgress() {
        return this.progress;
    }

    @Nullable
    public final String getFile_path() {
        return this.file_path;
    }

    public final long getCreated_at() {
        return this.created_at;
    }

    @NotNull
    public final String getTrack_json() {
        return this.track_json;
    }

    @NotNull
    public final String getContext_json() {
        return this.context_json;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.track_id;
    }

    @NotNull
    public final String component3() {
        return this.extension_id;
    }

    @NotNull
    public final String component4() {
        return this.status;
    }

    public final double component5() {
        return this.progress;
    }

    @Nullable
    public final String component6() {
        return this.file_path;
    }

    public final long component7() {
        return this.created_at;
    }

    @NotNull
    public final String component8() {
        return this.track_json;
    }

    @NotNull
    public final String component9() {
        return this.context_json;
    }

    @NotNull
    public final Downloads copy(@NotNull String id2, @NotNull String track_id, @NotNull String extension_id, @NotNull String status, double progress, @Nullable String file_path, long created_at, @NotNull String track_json, @NotNull String context_json) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track_id, (String)"track_id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)track_json, (String)"track_json");
        Intrinsics.checkNotNullParameter((Object)context_json, (String)"context_json");
        return new Downloads(id2, track_id, extension_id, status, progress, file_path, created_at, track_json, context_json);
    }

    public static /* synthetic */ Downloads copy$default(Downloads downloads, String string2, String string3, String string4, String string5, double d, String string6, long l, String string7, String string8, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = downloads.id;
        }
        if ((n & 2) != 0) {
            string3 = downloads.track_id;
        }
        if ((n & 4) != 0) {
            string4 = downloads.extension_id;
        }
        if ((n & 8) != 0) {
            string5 = downloads.status;
        }
        if ((n & 0x10) != 0) {
            d = downloads.progress;
        }
        if ((n & 0x20) != 0) {
            string6 = downloads.file_path;
        }
        if ((n & 0x40) != 0) {
            l = downloads.created_at;
        }
        if ((n & 0x80) != 0) {
            string7 = downloads.track_json;
        }
        if ((n & 0x100) != 0) {
            string8 = downloads.context_json;
        }
        return downloads.copy(string2, string3, string4, string5, d, string6, l, string7, string8);
    }

    @NotNull
    public String toString() {
        return "Downloads(id=" + this.id + ", track_id=" + this.track_id + ", extension_id=" + this.extension_id + ", status=" + this.status + ", progress=" + this.progress + ", file_path=" + this.file_path + ", created_at=" + this.created_at + ", track_json=" + this.track_json + ", context_json=" + this.context_json + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.track_id.hashCode();
        result2 = result2 * 31 + this.extension_id.hashCode();
        result2 = result2 * 31 + this.status.hashCode();
        result2 = result2 * 31 + Double.hashCode(this.progress);
        result2 = result2 * 31 + (this.file_path == null ? 0 : this.file_path.hashCode());
        result2 = result2 * 31 + Long.hashCode(this.created_at);
        result2 = result2 * 31 + this.track_json.hashCode();
        result2 = result2 * 31 + this.context_json.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Downloads)) {
            return false;
        }
        Downloads downloads = (Downloads)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)downloads.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track_id, (Object)downloads.track_id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.extension_id, (Object)downloads.extension_id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.status, (Object)downloads.status)) {
            return false;
        }
        if (Double.compare(this.progress, downloads.progress) != 0) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.file_path, (Object)downloads.file_path)) {
            return false;
        }
        if (this.created_at != downloads.created_at) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track_json, (Object)downloads.track_json)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.context_json, (Object)downloads.context_json);
    }
}

