/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.exceptions;

import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001d"}, d2={"Ldev/brahmkshatriya/echo/download/exceptions/DownloadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "downloadEntity", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "cause", "", "<init>", "(Ldev/brahmkshatriya/echo/download/db/models/TaskType;Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;Ljava/lang/Throwable;)V", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getDownloadEntity", "()Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
public final class DownloadException
extends Exception {
    @NotNull
    private final TaskType type;
    @NotNull
    private final DownloadEntity downloadEntity;
    @NotNull
    private final Throwable cause;

    public DownloadException(@NotNull TaskType type, @NotNull DownloadEntity downloadEntity, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)downloadEntity, (String)"downloadEntity");
        Intrinsics.checkNotNullParameter((Object)cause, (String)"cause");
        this.type = type;
        this.downloadEntity = downloadEntity;
        this.cause = cause;
    }

    @NotNull
    public final TaskType getType() {
        return this.type;
    }

    @NotNull
    public final DownloadEntity getDownloadEntity() {
        return this.downloadEntity;
    }

    @Override
    @NotNull
    public Throwable getCause() {
        return this.cause;
    }

    @NotNull
    public final TaskType component1() {
        return this.type;
    }

    @NotNull
    public final DownloadEntity component2() {
        return this.downloadEntity;
    }

    @NotNull
    public final Throwable component3() {
        return this.cause;
    }

    @NotNull
    public final DownloadException copy(@NotNull TaskType type, @NotNull DownloadEntity downloadEntity, @NotNull Throwable cause) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)downloadEntity, (String)"downloadEntity");
        Intrinsics.checkNotNullParameter((Object)cause, (String)"cause");
        return new DownloadException(type, downloadEntity, cause);
    }

    public static /* synthetic */ DownloadException copy$default(DownloadException downloadException, TaskType taskType, DownloadEntity downloadEntity, Throwable throwable, int n, Object object) {
        if ((n & 1) != 0) {
            taskType = downloadException.type;
        }
        if ((n & 2) != 0) {
            downloadEntity = downloadException.downloadEntity;
        }
        if ((n & 4) != 0) {
            throwable = downloadException.cause;
        }
        return downloadException.copy(taskType, downloadEntity, throwable);
    }

    @Override
    @NotNull
    public String toString() {
        return "DownloadException(type=" + this.type + ", downloadEntity=" + this.downloadEntity + ", cause=" + this.cause + ")";
    }

    public int hashCode() {
        int result2 = this.type.hashCode();
        result2 = result2 * 31 + this.downloadEntity.hashCode();
        result2 = result2 * 31 + this.cause.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadException)) {
            return false;
        }
        DownloadException downloadException = (DownloadException)other;
        if (this.type != downloadException.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.downloadEntity, (Object)downloadException.downloadEntity)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.cause, (Object)downloadException.cause);
    }
}

