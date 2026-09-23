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

import dev.brahmkshatriya.echo.common.providers.SettingsProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H\u0096@\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0006\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/providers/SettingsProvider;", "onExtensionSelected", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onInitialize", "common"})
public interface ExtensionClient
extends SettingsProvider {
    @Nullable
    default public Object onExtensionSelected(@NotNull Continuation<? super Unit> $completion) {
        return ExtensionClient.onExtensionSelected$suspendImpl(this, $completion);
    }

    public static /* synthetic */ Object onExtensionSelected$suspendImpl(ExtensionClient $this, Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }

    @Nullable
    default public Object onInitialize(@NotNull Continuation<? super Unit> $completion) {
        return ExtensionClient.onInitialize$suspendImpl(this, $completion);
    }

    public static /* synthetic */ Object onInitialize$suspendImpl(ExtensionClient $this, Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object onExtensionSelected(@NotNull ExtensionClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onExtensionSelected((Continuation<? super Unit>)$completion);
        }

        @Deprecated
        @Nullable
        public static Object onInitialize(@NotNull ExtensionClient $this, @NotNull Continuation<? super Unit> $completion) {
            return $this.onInitialize((Continuation<? super Unit>)$completion);
        }
    }
}

