/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import dev.brahmkshatriya.echo.core.platform.DownloadRequest;
import dev.brahmkshatriya.echo.core.platform.DownloadStatus;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH&J\b\u0010\u000e\u001a\u00020\u0003H&\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DownloadScheduler;", "", "enqueue", "", "request", "Ldev/brahmkshatriya/echo/core/platform/DownloadRequest;", "cancel", "downloadId", "", "retry", "observeAll", "Lkotlinx/coroutines/flow/StateFlow;", "", "Ldev/brahmkshatriya/echo/core/platform/DownloadStatus;", "clearCompleted", "core"})
public interface DownloadScheduler {
    public void enqueue(@NotNull DownloadRequest var1);

    public void cancel(@NotNull String var1);

    public void retry(@NotNull String var1);

    @NotNull
    public StateFlow<List<DownloadStatus>> observeAll();

    public void clearCompleted();
}

