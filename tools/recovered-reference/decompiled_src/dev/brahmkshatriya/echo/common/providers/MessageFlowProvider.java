/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common.providers;

import dev.brahmkshatriya.echo.common.models.Message;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/providers/MessageFlowProvider;", "", "setMessageFlow", "", "messageFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ldev/brahmkshatriya/echo/common/models/Message;", "common"})
public interface MessageFlowProvider {
    public void setMessageFlow(@NotNull MutableSharedFlow<Message> var1);
}

