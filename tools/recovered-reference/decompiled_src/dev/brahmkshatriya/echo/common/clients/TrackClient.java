/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.clients;

import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "", "loadTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "track", "isDownload", "", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface TrackClient {
    @Nullable
    public Object loadTrack(@NotNull Track var1, boolean var2, @NotNull Continuation<? super Track> var3);

    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable var1, boolean var2, @NotNull Continuation<? super Streamable.Media> var3);

    @Nullable
    public Object loadFeed(@NotNull Track var1, @NotNull Continuation<? super Feed<Shelf>> var2);
}

