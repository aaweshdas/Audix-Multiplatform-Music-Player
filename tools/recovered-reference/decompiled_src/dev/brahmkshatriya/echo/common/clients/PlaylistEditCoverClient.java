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
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/PlaylistEditCoverClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistEditClient;", "editPlaylistCover", "", "playlist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "cover", "Ljava/io/File;", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface PlaylistEditCoverClient
extends PlaylistEditClient {
    @Nullable
    public Object editPlaylistCover(@NotNull Playlist var1, @Nullable File var2, @NotNull Continuation<? super Unit> var3);
}

