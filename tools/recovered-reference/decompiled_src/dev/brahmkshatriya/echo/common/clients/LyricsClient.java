/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.clients;

import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Lyrics;
import dev.brahmkshatriya.echo.common.models.Track;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u00a6@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LyricsClient;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "searchTrackLyrics", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "clientId", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLyrics", "lyrics", "(Ldev/brahmkshatriya/echo/common/models/Lyrics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface LyricsClient
extends ExtensionClient {
    @Nullable
    public Object searchTrackLyrics(@NotNull String var1, @NotNull Track var2, @NotNull Continuation<? super Feed<Lyrics>> var3);

    @Nullable
    public Object loadLyrics(@NotNull Lyrics var1, @NotNull Continuation<? super Lyrics> var2);

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object onExtensionSelected(@NotNull LyricsClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onExtensionSelected((Continuation<? super Unit>)$completion);
        }

        @Deprecated
        @Nullable
        public static Object onInitialize(@NotNull LyricsClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onInitialize((Continuation<? super Unit>)$completion);
        }
    }
}

