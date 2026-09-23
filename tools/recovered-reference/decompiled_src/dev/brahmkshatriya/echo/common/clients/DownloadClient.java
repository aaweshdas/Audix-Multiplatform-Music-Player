/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.clients;

import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.common.models.Streamable;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u00a6@\u00a2\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0013H\u00a6@\u00a2\u0006\u0002\u0010\u001dJ2\u0010\u001e\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H\u00a6@\u00a2\u0006\u0002\u0010 J,\u0010!\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0018H\u00a6@\u00a2\u0006\u0002\u0010#R\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006$\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/DownloadClient;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "getDownloadTracks", "", "Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "extensionId", "", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "context", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "concurrentDownloads", "", "getConcurrentDownloads", "()I", "selectServer", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/DownloadContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSources", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "server", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "(Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "Ljava/io/File;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "source", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ldev/brahmkshatriya/echo/common/models/Streamable$Source;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "merge", "files", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tag", "file", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface DownloadClient
extends ExtensionClient {
    @Nullable
    public Object getDownloadTracks(@NotNull String var1, @NotNull EchoMediaItem var2, @Nullable EchoMediaItem var3, @NotNull Continuation<? super List<DownloadContext>> var4);

    public int getConcurrentDownloads();

    @Nullable
    public Object selectServer(@NotNull DownloadContext var1, @NotNull Continuation<? super Streamable> var2);

    @Nullable
    public Object selectSources(@NotNull DownloadContext var1, @NotNull Streamable.Media.Server var2, @NotNull Continuation<? super List<? extends Streamable.Source>> var3);

    @Nullable
    public Object download(@NotNull MutableStateFlow<Progress> var1, @NotNull DownloadContext var2, @NotNull Streamable.Source var3, @NotNull Continuation<? super File> var4);

    @Nullable
    public Object merge(@NotNull MutableStateFlow<Progress> var1, @NotNull DownloadContext var2, @NotNull List<? extends File> var3, @NotNull Continuation<? super File> var4);

    @Nullable
    public Object tag(@NotNull MutableStateFlow<Progress> var1, @NotNull DownloadContext var2, @NotNull File var3, @NotNull Continuation<? super File> var4);

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object onExtensionSelected(@NotNull DownloadClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onExtensionSelected((Continuation<? super Unit>)$completion);
        }

        @Deprecated
        @Nullable
        public static Object onInitialize(@NotNull DownloadClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onInitialize((Continuation<? super Unit>)$completion);
        }
    }
}

