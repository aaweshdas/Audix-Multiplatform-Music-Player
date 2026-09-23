/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.TrackerExtension;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.core.extensions.ExtensionInstallSource;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionRepository;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020 J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f\u00a8\u0006&"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/ExtensionsViewModel;", "", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "extensionRepository", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;Lkotlinx/coroutines/CoroutineScope;)V", "music", "Lkotlinx/coroutines/flow/StateFlow;", "", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "getMusic", "()Lkotlinx/coroutines/flow/StateFlow;", "tracker", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "getTracker", "lyrics", "Ldev/brahmkshatriya/echo/common/LyricsExtension;", "getLyrics", "misc", "Ldev/brahmkshatriya/echo/common/MiscExtension;", "getMisc", "currentExtension", "getCurrentExtension", "selectExtension", "", "extension", "installFromFile", "path", "", "installFromUrl", "url", "uninstall", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "desktopApp"})
@StabilityInferred(parameters=0)
public final class ExtensionsViewModel {
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final ExtensionRepository extensionRepository;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final StateFlow<List<MusicExtension>> music;
    @NotNull
    private final StateFlow<List<TrackerExtension>> tracker;
    @NotNull
    private final StateFlow<List<LyricsExtension>> lyrics;
    @NotNull
    private final StateFlow<List<MiscExtension>> misc;
    @NotNull
    private final StateFlow<MusicExtension> currentExtension;
    public static final int $stable = 8;

    public ExtensionsViewModel(@NotNull ExtensionManager extensionManager, @NotNull ExtensionRepository extensionRepository, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)extensionRepository, (String)"extensionRepository");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.extensionManager = extensionManager;
        this.extensionRepository = extensionRepository;
        this.scope = scope;
        this.music = this.extensionManager.getMusic();
        this.tracker = this.extensionManager.getTracker();
        this.lyrics = this.extensionManager.getLyrics();
        this.misc = this.extensionManager.getMisc();
        this.currentExtension = (StateFlow)this.extensionManager.getCurrent();
    }

    public /* synthetic */ ExtensionsViewModel(ExtensionManager extensionManager, ExtensionRepository extensionRepository, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(extensionManager, extensionRepository, coroutineScope);
    }

    @NotNull
    public final StateFlow<List<MusicExtension>> getMusic() {
        return this.music;
    }

    @NotNull
    public final StateFlow<List<TrackerExtension>> getTracker() {
        return this.tracker;
    }

    @NotNull
    public final StateFlow<List<LyricsExtension>> getLyrics() {
        return this.lyrics;
    }

    @NotNull
    public final StateFlow<List<MiscExtension>> getMisc() {
        return this.misc;
    }

    @NotNull
    public final StateFlow<MusicExtension> getCurrentExtension() {
        return this.currentExtension;
    }

    public final void selectExtension(@NotNull MusicExtension extension2) {
        Intrinsics.checkNotNullParameter((Object)extension2, (String)"extension");
        this.extensionManager.setupMusicExtension(extension2, true);
    }

    public final void installFromFile(@NotNull String path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, path, null){
            int label;
            final /* synthetic */ ExtensionsViewModel this$0;
            final /* synthetic */ String $path;
            {
                this.this$0 = $receiver;
                this.$path = $path;
                super(2, $completion);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        Object object2 = ExtensionsViewModel.access$getExtensionRepository$p(this.this$0).install-gIAlu-s(new ExtensionInstallSource.LocalFile(this.$path), (Continuation<? super Result<Metadata>>)((Continuation)this));
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = ((Result)$result).unbox-impl();
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)2, null);
    }

    public final void installFromUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, url, null){
            int label;
            final /* synthetic */ ExtensionsViewModel this$0;
            final /* synthetic */ String $url;
            {
                this.this$0 = $receiver;
                this.$url = $url;
                super(2, $completion);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        Object object2 = ExtensionsViewModel.access$getExtensionRepository$p(this.this$0).install-gIAlu-s(new ExtensionInstallSource.RemoteUrl(this.$url), (Continuation<? super Result<Metadata>>)((Continuation)this));
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = ((Result)$result).unbox-impl();
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)2, null);
    }

    public final void uninstall(@NotNull Metadata metadata2) {
        Intrinsics.checkNotNullParameter((Object)metadata2, (String)"metadata");
        BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, metadata2, null){
            int label;
            final /* synthetic */ ExtensionsViewModel this$0;
            final /* synthetic */ Metadata $metadata;
            {
                this.this$0 = $receiver;
                this.$metadata = $metadata;
                super(2, $completion);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        Object object2 = ExtensionsViewModel.access$getExtensionRepository$p(this.this$0).uninstall-0E7RQCE(this.$metadata.getId(), this.$metadata.getType(), (Continuation<? super Result<Unit>>)((Continuation)this));
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = ((Result)$result).unbox-impl();
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)2, null);
    }

    public static final /* synthetic */ ExtensionRepository access$getExtensionRepository$p(ExtensionsViewModel $this) {
        return $this.extensionRepository;
    }
}

