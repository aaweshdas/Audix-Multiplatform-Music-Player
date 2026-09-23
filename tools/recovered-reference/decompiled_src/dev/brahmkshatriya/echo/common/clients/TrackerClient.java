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
import dev.brahmkshatriya.echo.common.models.TrackDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/TrackerClient;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "onTrackChanged", "", "details", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlayingStateChanged", "isPlaying", "", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface TrackerClient
extends ExtensionClient {
    @Nullable
    public Object onTrackChanged(@Nullable TrackDetails var1, @NotNull Continuation<? super Unit> var2);

    @Nullable
    public Object onPlayingStateChanged(@Nullable TrackDetails var1, boolean var2, @NotNull Continuation<? super Unit> var3);

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object onExtensionSelected(@NotNull TrackerClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onExtensionSelected((Continuation<? super Unit>)$completion);
        }

        @Deprecated
        @Nullable
        public static Object onInitialize(@NotNull TrackerClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onInitialize((Continuation<? super Unit>)$completion);
        }
    }
}

