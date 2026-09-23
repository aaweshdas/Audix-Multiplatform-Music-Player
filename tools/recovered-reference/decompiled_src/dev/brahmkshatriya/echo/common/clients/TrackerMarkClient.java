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

import dev.brahmkshatriya.echo.common.clients.TrackerClient;
import dev.brahmkshatriya.echo.common.models.TrackDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\t\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/TrackerMarkClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackerClient;", "getMarkAsPlayedDuration", "", "details", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMarkAsPlayed", "", "common"})
public interface TrackerMarkClient
extends TrackerClient {
    @Nullable
    public Object getMarkAsPlayedDuration(@NotNull TrackDetails var1, @NotNull Continuation<? super Long> var2);

    @Nullable
    public Object onMarkAsPlayed(@NotNull TrackDetails var1, @NotNull Continuation<? super Unit> var2);

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object onExtensionSelected(@NotNull TrackerMarkClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onExtensionSelected((Continuation<? super Unit>)$completion);
        }

        @Deprecated
        @Nullable
        public static Object onInitialize(@NotNull TrackerMarkClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onInitialize((Continuation<? super Unit>)$completion);
        }
    }
}

