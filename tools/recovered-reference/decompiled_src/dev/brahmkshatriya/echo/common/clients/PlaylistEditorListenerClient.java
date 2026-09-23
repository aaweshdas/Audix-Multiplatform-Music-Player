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

import dev.brahmkshatriya.echo.common.clients.PlaylistEditClient;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Track;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a6@\u00a2\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a6@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/PlaylistEditorListenerClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistEditClient;", "onEnterPlaylistEditor", "", "playlist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "tracks", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onExitPlaylistEditor", "common"})
public interface PlaylistEditorListenerClient
extends PlaylistEditClient {
    @Nullable
    public Object onEnterPlaylistEditor(@NotNull Playlist var1, @NotNull List<Track> var2, @NotNull Continuation<? super Unit> var3);

    @Nullable
    public Object onExitPlaylistEditor(@NotNull Playlist var1, @NotNull List<Track> var2, @NotNull Continuation<? super Unit> var3);
}

