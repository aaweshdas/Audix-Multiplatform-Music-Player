/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlinx.coroutines.flow.Flow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions;

import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.core.extensions.ExtensionInstallSource;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u00a6@\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@\u00a2\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u0012H\u00a6@\u00a2\u0006\u0002\u0010\u001eR6\u0010\u0002\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u00050\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Result;", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "install", "source", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;", "install-gIAlu-s", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uninstall", "", "id", "", "type", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "uninstall-0E7RQCE", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ExtensionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnabled", "enabled", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core"})
public interface ExtensionRepository {
    @NotNull
    public Flow<List<Result<Pair<Metadata, Lazy<ExtensionClient>>>>> getFlow();

    @Nullable
    public Object install-gIAlu-s(@NotNull ExtensionInstallSource var1, @NotNull Continuation<? super Result<Metadata>> var2);

    @Nullable
    public Object uninstall-0E7RQCE(@NotNull String var1, @NotNull ExtensionType var2, @NotNull Continuation<? super Result<Unit>> var3);

    @Nullable
    default public Object setEnabled(@NotNull String id2, boolean enabled, @NotNull Continuation<? super Unit> $completion) {
        return ExtensionRepository.setEnabled$suspendImpl(this, id2, enabled, $completion);
    }

    public static /* synthetic */ Object setEnabled$suspendImpl(ExtensionRepository $this, String id2, boolean enabled, Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }

    @Nullable
    public Object reload(@NotNull Continuation<? super Unit> var1);

    @kotlin.Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static Object setEnabled(@NotNull ExtensionRepository $this, @NotNull String id2, boolean enabled, @NotNull Continuation<? super Unit> $completion) {
            return $this.setEnabled(id2, enabled, (Continuation<? super Unit>)$completion);
        }
    }
}

