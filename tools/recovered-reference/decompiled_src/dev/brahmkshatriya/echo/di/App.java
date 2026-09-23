/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.SharedPreferences
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  com.mayakapps.kache.FileKache
 *  com.mayakapps.kache.FileKache$Configuration
 *  com.mayakapps.kache.FileKacheKt
 *  com.mayakapps.kache.KacheStrategy
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.CoroutineStart
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.SharedFlowKt
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import com.mayakapps.kache.FileKache;
import com.mayakapps.kache.FileKacheKt;
import com.mayakapps.kache.KacheStrategy;
import dev.brahmkshatriya.echo.common.models.Message;
import dev.brahmkshatriya.echo.common.models.NetworkConnection;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0018\u001a\u00020\u0019H\u0082@\u00a2\u0006\u0002\u0010\u001aJ\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010,\u001a\u00020'2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u000201H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010(\u00a8\u00062"}, d2={"Ldev/brahmkshatriya/echo/di/App;", "", "context", "Landroid/app/Application;", "settings", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/app/Application;Landroid/content/SharedPreferences;)V", "getContext", "()Landroid/app/Application;", "getSettings", "()Landroid/content/SharedPreferences;", "throwFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getThrowFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "messageFlow", "Ldev/brahmkshatriya/echo/common/models/Message;", "getMessageFlow", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getCache", "Lcom/mayakapps/kache/FileKache;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fileCache", "Lkotlinx/coroutines/Deferred;", "getFileCache", "()Lkotlinx/coroutines/Deferred;", "_networkFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/NetworkConnection;", "networkFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getNetworkFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "isUnmetered", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"})
public final class App {
    @NotNull
    private final Application context;
    @NotNull
    private final SharedPreferences settings;
    @NotNull
    private final MutableSharedFlow<Throwable> throwFlow;
    @NotNull
    private final MutableSharedFlow<Message> messageFlow;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Deferred<FileKache> fileCache;
    @NotNull
    private final MutableStateFlow<NetworkConnection> _networkFlow;
    @NotNull
    private final StateFlow<NetworkConnection> networkFlow;

    public App(@NotNull Application context, @NotNull SharedPreferences settings) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.context = context;
        this.settings = settings;
        this.throwFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)0, null, (int)7, null);
        this.messageFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)0, null, (int)7, null);
        this.scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getIO()));
        this.fileCache = BuildersKt.async((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (CoroutineStart)CoroutineStart.LAZY, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super FileKache>, Object>(this, null){
            Object L$1;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ App this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                var7_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        var3_4 /* !! */  = $this$async;
                        var4_5 = this.this$0;
                        $this$invokeSuspend_u24lambda_u240\1 /* !! */  = var3_4 /* !! */ ;
                        $i$a$-runCatching-App$fileCache$1$1\1\38\0 = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$async);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240\1 /* !! */ );
                        this.I$0 = $i$a$-runCatching-App$fileCache$1$1\1\38\0;
                        this.label = 1;
                        v0 = App.access$getCache(var4_5, (Continuation)this);
                        ** if (v0 != var7_3) goto lbl20
lbl19:
                        // 1 sources

                        return var7_3;
lbl20:
                        // 1 sources

                        ** GOTO lbl28
                    }
                    case 1: {
                        $i$a$-runCatching-App$fileCache$1$1\1\38\0 = this.I$0;
                        $this$invokeSuspend_u24lambda_u240\1 /* !! */  = (CoroutineScope)this.L$1;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl28:
                            // 2 sources

                            $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)((FileKache)v0));
                        }
                        catch (Throwable $i$a$-runCatching-App$fileCache$1$1\1\38\0) {
                            $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-App$fileCache$1$1\1\38\0));
                        }
                        var3_4 /* !! */  = $this$invokeSuspend_u24lambda_u240\1 /* !! */ ;
                        var4_5 = this.this$0;
                        v1 = Result.exceptionOrNull-impl((Object)var3_4 /* !! */ );
                        if (v1 != null) ** GOTO lbl39
                        v2 = var3_4 /* !! */ ;
                        ** GOTO lbl60
lbl39:
                        // 1 sources

                        it\2 = v1;
                        $i$a$-getOrElse-App$fileCache$1$2\2\38\0 = 0;
                        v3 = var4_5.getContext().getCacheDir();
                        Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getCacheDir(...)");
                        FilesKt.deleteRecursively((File)FilesKt.resolve((File)v3, (String)"kache"));
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$async);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)it\2);
                        this.I$0 = $i$a$-getOrElse-App$fileCache$1$2\2\38\0;
                        this.label = 2;
                        v4 = App.access$getCache(var4_5, (Continuation)this);
                        if (v4 == var7_3) {
                            return var7_3;
                        }
                        ** GOTO lbl58
                    }
                    case 2: {
                        $i$a$-getOrElse-App$fileCache$1$2\2\38\0 = this.I$0;
                        it\2 = (Throwable)this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v4 = $result;
lbl58:
                        // 2 sources

                        v2 = (FileKache)v4;
lbl60:
                        // 2 sources

                        return v2;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super FileKache> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
        this._networkFlow = StateFlowKt.MutableStateFlow((Object)((Object)NetworkConnection.NotConnected));
        this.networkFlow = FlowKt.asStateFlow(this._networkFlow);
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ App this$0;
            {
                this.this$0 = $receiver;
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
                        Object object2 = FlowKt.collectLatest((Flow)((Flow)this.this$0.getThrowFlow()), (Function2)((Function2)new Function2<Throwable, Continuation<? super Unit>, Object>(null){
                            int label;
                            /* synthetic */ Object L$0;

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                Throwable throwable = (Throwable)this.L$0;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void it;
                                        ResultKt.throwOnFailure((Object)$result);
                                        it.printStackTrace();
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(Throwable p1, Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }), (Continuation)((Continuation)this));
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = $result;
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
        }), (int)3, null);
        Object object = this.context.getSystemService("connectivity");
        Intrinsics.checkNotNull((Object)object, (String)"null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager)object;
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback(connectivityManager, this){
            final /* synthetic */ ConnectivityManager $connectivityManager;
            final /* synthetic */ App this$0;
            {
                this.$connectivityManager = $connectivityManager;
                this.this$0 = $receiver;
            }

            public void onAvailable(Network network) {
                Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                boolean isMetered = this.$connectivityManager.isActiveNetworkMetered();
                App.access$get_networkFlow$p(this.this$0).setValue((Object)((Object)(isMetered ? NetworkConnection.Metered : NetworkConnection.Unmetered)));
            }

            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter((Object)network, (String)"network");
                App.access$get_networkFlow$p(this.this$0).setValue((Object)((Object)NetworkConnection.NotConnected));
            }
        };
        connectivityManager.registerDefaultNetworkCallback(networkCallback2);
    }

    @NotNull
    public final Application getContext() {
        return this.context;
    }

    @NotNull
    public final SharedPreferences getSettings() {
        return this.settings;
    }

    @NotNull
    public final MutableSharedFlow<Throwable> getThrowFlow() {
        return this.throwFlow;
    }

    @NotNull
    public final MutableSharedFlow<Message> getMessageFlow() {
        return this.messageFlow;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    private final Object getCache(Continuation<? super FileKache> $completion) {
        File file2 = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue((Object)file2, (String)"getCacheDir(...)");
        String string2 = FilesKt.resolve((File)file2, (String)"kache").toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        return FileKacheKt.FileKache((String)string2, (long)0x3200000L, App::getCache$lambda$0, $completion);
    }

    @NotNull
    public final Deferred<FileKache> getFileCache() {
        return this.fileCache;
    }

    @NotNull
    public final StateFlow<NetworkConnection> getNetworkFlow() {
        return this.networkFlow;
    }

    public final boolean isUnmetered() {
        return this.networkFlow.getValue() == NetworkConnection.Unmetered;
    }

    @NotNull
    public final Application component1() {
        return this.context;
    }

    @NotNull
    public final SharedPreferences component2() {
        return this.settings;
    }

    @NotNull
    public final App copy(@NotNull Application context, @NotNull SharedPreferences settings) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        return new App(context, settings);
    }

    public static /* synthetic */ App copy$default(App app, Application application, SharedPreferences sharedPreferences, int n, Object object) {
        if ((n & 1) != 0) {
            application = app.context;
        }
        if ((n & 2) != 0) {
            sharedPreferences = app.settings;
        }
        return app.copy(application, sharedPreferences);
    }

    @NotNull
    public String toString() {
        return "App(context=" + this.context + ", settings=" + this.settings + ")";
    }

    public int hashCode() {
        int result2 = this.context.hashCode();
        result2 = result2 * 31 + this.settings.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof App)) {
            return false;
        }
        App app = (App)other;
        if (!Intrinsics.areEqual((Object)this.context, (Object)app.context)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.settings, (Object)app.settings);
    }

    private static final Unit getCache$lambda$0(FileKache.Configuration $this$FileKache) {
        Intrinsics.checkNotNullParameter((Object)$this$FileKache, (String)"$this$FileKache");
        $this$FileKache.setStrategy(KacheStrategy.LRU);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$getCache(App $this, Continuation $completion) {
        return $this.getCache((Continuation<? super FileKache>)$completion);
    }

    public static final /* synthetic */ MutableStateFlow access$get_networkFlow$p(App $this) {
        return $this._networkFlow;
    }
}

