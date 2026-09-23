/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.clients;

import dev.brahmkshatriya.echo.common.clients.PlaylistClient;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Track;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00a6@\u00a2\u0006\u0002\u0010\u0014J:\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u001dJ4\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0018H\u00a6@\u00a2\u0006\u0002\u0010!\u00a8\u0006\"\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/PlaylistEditClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistClient;", "listEditablePlaylists", "", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "title", "", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "", "playlist", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editPlaylistMetadata", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTracksToPlaylist", "tracks", "index", "", "new", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTracksFromPlaylist", "indexes", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTrackInPlaylist", "fromIndex", "toIndex", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface PlaylistEditClient
extends PlaylistClient {
    @Nullable
    public Object listEditablePlaylists(@Nullable Track var1, @NotNull Continuation<? super List<Pair<Playlist, Boolean>>> var2);

    @Nullable
    public Object createPlaylist(@NotNull String var1, @Nullable String var2, @NotNull Continuation<? super Playlist> var3);

    @Nullable
    public Object deletePlaylist(@NotNull Playlist var1, @NotNull Continuation<? super Unit> var2);

    @Nullable
    public Object editPlaylistMetadata(@NotNull Playlist var1, @NotNull String var2, @Nullable String var3, @NotNull Continuation<? super Unit> var4);

    @Nullable
    public Object addTracksToPlaylist(@NotNull Playlist var1, @NotNull List<Track> var2, int var3, @NotNull List<Track> var4, @NotNull Continuation<? super Unit> var5);

    @Nullable
    public Object removeTracksFromPlaylist(@NotNull Playlist var1, @NotNull List<Track> var2, @NotNull List<Integer> var3, @NotNull Continuation<? super Unit> var4);

    @Nullable
    public Object moveTrackInPlaylist(@NotNull Playlist var1, @NotNull List<Track> var2, int var3, int var4, @NotNull Continuation<? super Unit> var5);
}

