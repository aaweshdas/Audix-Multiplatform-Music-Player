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

import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/FollowClient;", "", "isFollowing", "", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFollowersCount", "", "followItem", "", "shouldFollow", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface FollowClient {
    @Nullable
    public Object isFollowing(@NotNull EchoMediaItem var1, @NotNull Continuation<? super Boolean> var2);

    @Nullable
    public Object getFollowersCount(@NotNull EchoMediaItem var1, @NotNull Continuation<? super Long> var2);

    @Nullable
    public Object followItem(@NotNull EchoMediaItem var1, boolean var2, @NotNull Continuation<? super Unit> var3);
}

