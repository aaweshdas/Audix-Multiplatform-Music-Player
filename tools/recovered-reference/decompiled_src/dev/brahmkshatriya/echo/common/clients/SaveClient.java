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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/SaveClient;", "", "saveToLibrary", "", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "shouldSave", "", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemSaved", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
public interface SaveClient {
    @Nullable
    public Object saveToLibrary(@NotNull EchoMediaItem var1, boolean var2, @NotNull Continuation<? super Unit> var3);

    @Nullable
    public Object isItemSaved(@NotNull EchoMediaItem var1, @NotNull Continuation<? super Boolean> var2);
}

