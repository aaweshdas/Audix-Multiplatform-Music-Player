/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/MediaViewModel;", "", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Lkotlinx/coroutines/CoroutineScope;)V", "desktopApp"})
@StabilityInferred(parameters=0)
public final class MediaViewModel {
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final CoroutineScope scope;
    public static final int $stable = 8;

    public MediaViewModel(@NotNull ExtensionManager extensionManager, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.extensionManager = extensionManager;
        this.scope = scope;
    }

    public /* synthetic */ MediaViewModel(ExtensionManager extensionManager, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(extensionManager, coroutineScope);
    }
}

