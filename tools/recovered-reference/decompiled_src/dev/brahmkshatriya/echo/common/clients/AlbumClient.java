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

import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/AlbumClient;", "", "loadAlbum", "Ldev/brahmkshatriya/echo/common/models/Album;", "album", "(Ldev/brahmkshatriya/echo/common/models/Album;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTracks", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Track;", "loadFeed", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "common"})
public interface AlbumClient {
    @Nullable
    public Object loadAlbum(@NotNull Album var1, @NotNull Continuation<? super Album> var2);

    @Nullable
    public Object loadTracks(@NotNull Album var1, @NotNull Continuation<? super Feed<Track>> var2);

    @Nullable
    public Object loadFeed(@NotNull Album var1, @NotNull Continuation<? super Feed<Shelf>> var2);
}

