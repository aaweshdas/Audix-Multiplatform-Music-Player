/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.Page;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010 J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000f\u00a8\u0006'"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/HomeViewModel;", "", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Lkotlinx/coroutines/CoroutineScope;)V", "_feed", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "feed", "Lkotlinx/coroutines/flow/StateFlow;", "getFeed", "()Lkotlinx/coroutines/flow/StateFlow;", "_shelves", "", "shelves", "getShelves", "_isLoading", "", "isLoading", "_error", "", "error", "getError", "_selectedTab", "Ldev/brahmkshatriya/echo/common/models/Tab;", "selectedTab", "getSelectedTab", "currentExtension", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "getCurrentExtension", "loadFeed", "", "extension", "selectTab", "tab", "desktopApp"})
@StabilityInferred(parameters=0)
public final class HomeViewModel {
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableStateFlow<Feed<Shelf>> _feed;
    @NotNull
    private final StateFlow<Feed<Shelf>> feed;
    @NotNull
    private final MutableStateFlow<List<Shelf>> _shelves;
    @NotNull
    private final StateFlow<List<Shelf>> shelves;
    @NotNull
    private final MutableStateFlow<Boolean> _isLoading;
    @NotNull
    private final StateFlow<Boolean> isLoading;
    @NotNull
    private final MutableStateFlow<Throwable> _error;
    @NotNull
    private final StateFlow<Throwable> error;
    @NotNull
    private final MutableStateFlow<Tab> _selectedTab;
    @NotNull
    private final StateFlow<Tab> selectedTab;
    @NotNull
    private final StateFlow<MusicExtension> currentExtension;
    public static final int $stable = 8;

    public HomeViewModel(@NotNull ExtensionManager extensionManager, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.extensionManager = extensionManager;
        this.scope = scope;
        this._feed = StateFlowKt.MutableStateFlow(null);
        this.feed = FlowKt.asStateFlow(this._feed);
        this._shelves = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.shelves = FlowKt.asStateFlow(this._shelves);
        this._isLoading = StateFlowKt.MutableStateFlow((Object)false);
        this.isLoading = FlowKt.asStateFlow(this._isLoading);
        this._error = StateFlowKt.MutableStateFlow(null);
        this.error = FlowKt.asStateFlow(this._error);
        this._selectedTab = StateFlowKt.MutableStateFlow(null);
        this.selectedTab = FlowKt.asStateFlow(this._selectedTab);
        this.currentExtension = (StateFlow)this.extensionManager.getCurrent();
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ HomeViewModel this$0;
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
                        Object object2 = this.this$0.extensionManager.getCurrent().collect(new FlowCollector(){

                            public final Object emit(MusicExtension ext, Continuation<? super Unit> $completion) {
                                if (ext != null) {
                                    this$0.loadFeed(ext);
                                }
                                return Unit.INSTANCE;
                            }
                        }, (Continuation)this);
                        if (object2 != object) throw new KotlinNothingValueException();
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = $result;
                        throw new KotlinNothingValueException();
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
    }

    public /* synthetic */ HomeViewModel(ExtensionManager extensionManager, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(extensionManager, coroutineScope);
    }

    @NotNull
    public final StateFlow<Feed<Shelf>> getFeed() {
        return this.feed;
    }

    @NotNull
    public final StateFlow<List<Shelf>> getShelves() {
        return this.shelves;
    }

    @NotNull
    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    @NotNull
    public final StateFlow<Throwable> getError() {
        return this.error;
    }

    @NotNull
    public final StateFlow<Tab> getSelectedTab() {
        return this.selectedTab;
    }

    @NotNull
    public final StateFlow<MusicExtension> getCurrentExtension() {
        return this.currentExtension;
    }

    public final void loadFeed(@Nullable MusicExtension extension2) {
        MusicExtension musicExtension = extension2;
        if (musicExtension == null && (musicExtension = (MusicExtension)this.extensionManager.getCurrent().getValue()) == null) {
            return;
        }
        MusicExtension ext = musicExtension;
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, ext, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int I$0;
            int I$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ HomeViewModel this$0;
            final /* synthetic */ MusicExtension $ext;
            {
                this.this$0 = $receiver;
                this.$ext = $ext;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                var12_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        HomeViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)true));
                        HomeViewModel.access$get_error$p(this.this$0).setValue(null);
                        var3_4 = ExtensionUtils.INSTANCE;
                        $this$getAs_u2d0E7RQCE$iv = this.$ext;
                        $i$f$getAs-0E7RQCE = 0;
                        this.L$0 = $this$launch;
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE$iv);
                        this.I$0 = $i$f$getAs-0E7RQCE;
                        this.label = 1;
                        v0 = this_$iv.get-0E7RQCE($this$getAs_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super Feed<Shelf>>, Object>(null){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;
                            Object L$2;
                            Object L$3;
                            int I$0;

                            /*
                             * WARNING - void declaration
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public final Object invokeSuspend(Object $result) {
                                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void $completion;
                                        void $this$get;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object v0 = $this$get;
                                        if (!(v0 instanceof HomeFeedClient)) {
                                            v0 = null;
                                        }
                                        HomeFeedClient homeFeedClient = v0;
                                        if (homeFeedClient == null) {
                                            String string2 = Reflection.getOrCreateKotlinClass(HomeFeedClient.class).getSimpleName();
                                            if (string2 != null) throw new ClientException.NotSupported(string2);
                                            string2 = "Unknown";
                                            throw new ClientException.NotSupported(string2);
                                        }
                                        HomeFeedClient client = homeFeedClient;
                                        Continuation continuation = (Continuation)this;
                                        HomeFeedClient $this$invokeSuspend_u24lambda_u240 = client;
                                        int n = 0;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                                        this.I$0 = n;
                                        this.label = 1;
                                        Object object2 = $this$invokeSuspend_u24lambda_u240.loadHomeFeed((Continuation<? super Feed<Shelf>>)this);
                                        if (object2 != object) return object2;
                                        return object;
                                    }
                                    case 1: {
                                        int n = this.I$0;
                                        HomeFeedClient $this$invokeSuspend_u24lambda_u240 = (HomeFeedClient)this.L$3;
                                        Continuation $completion = (Continuation)this.L$2;
                                        HomeFeedClient client = (HomeFeedClient)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object2 = $result;
                                        return object2;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super Feed<Shelf>> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, (Continuation)this);
                        if (v0 == var12_3) {
                            return var12_3;
                        }
                        ** GOTO lbl27
                    }
                    case 1: {
                        $i$f$getAs-0E7RQCE = this.I$0;
                        $this$getAs_u2d0E7RQCE$iv = (Extension)this.L$2;
                        this_$iv = (ExtensionUtils)this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = ((Result)$result).unbox-impl();
lbl27:
                        // 2 sources

                        var3_4 = v0;
                        var4_5 = this.this$0;
                        if (!Result.isSuccess-impl((Object)var3_4)) ** GOTO lbl103
                        feed = (Feed)var3_4;
                        $i$a$-onSuccess-HomeViewModel$loadFeed$1$2 = 0;
                        HomeViewModel.access$get_feed$p(var4_5).setValue((Object)feed);
                        var7_11 = $this$launch;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = var7_11;
                        $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1 = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                        this.L$1 = var3_4;
                        this.L$2 = var4_5;
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */ );
                        this.I$0 = $i$a$-onSuccess-HomeViewModel$loadFeed$1$2;
                        this.I$1 = $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1;
                        this.label = 2;
                        v1 = feed.getGetPagedData().invoke(HomeViewModel.access$get_selectedTab$p(var4_5).getValue(), (Object)this);
                        ** if (v1 != var12_3) goto lbl50
lbl49:
                        // 1 sources

                        return var12_3;
lbl50:
                        // 1 sources

                        ** GOTO lbl62
                    }
                    case 2: {
                        $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1 = this.I$1;
                        $i$a$-onSuccess-HomeViewModel$loadFeed$1$2 = this.I$0;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = (CoroutineScope)this.L$4;
                        feed = (Feed)this.L$3;
                        var4_5 = (HomeViewModel)this.L$2;
                        var3_4 = this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl62:
                        // 2 sources

                        feedData = (Feed.Data)v1;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                        this.L$1 = var3_4;
                        this.L$2 = var4_5;
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */ );
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)feedData);
                        this.I$0 = $i$a$-onSuccess-HomeViewModel$loadFeed$1$2;
                        this.I$1 = $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1;
                        this.label = 3;
                        v2 = feedData.getPagedData().loadPage((String)null, this);
                        ** if (v2 != var12_3) goto lbl75
lbl74:
                        // 1 sources

                        return var12_3;
lbl75:
                        // 1 sources

                        ** GOTO lbl88
                    }
                    case 3: {
                        $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1 = this.I$1;
                        $i$a$-onSuccess-HomeViewModel$loadFeed$1$2 = this.I$0;
                        feedData = (Feed.Data)this.L$5;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = (CoroutineScope)this.L$4;
                        feed = (Feed)this.L$3;
                        var4_5 = (HomeViewModel)this.L$2;
                        var3_4 = this.L$1;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v2 = $result;
lbl88:
                            // 2 sources

                            initialPage = (Page)v2;
                            HomeViewModel.access$get_shelves$p(var4_5).setValue(initialPage.getData());
                            var8_13 = Result.constructor-impl((Object)Unit.INSTANCE);
                        }
                        catch (Throwable $i$a$-runCatching-HomeViewModel$loadFeed$1$2$1) {
                            var8_13 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-HomeViewModel$loadFeed$1$2$1));
                        }
                        var7_11 = var8_13;
                        v3 = Result.exceptionOrNull-impl((Object)var7_11);
                        if (v3 != null) {
                            err = var8_13 = v3;
                            $i$a$-onFailure-HomeViewModel$loadFeed$1$2$2 = false;
                            HomeViewModel.access$get_error$p(var4_5).setValue(err);
                        }
lbl103:
                        // 4 sources

                        var4_5 = this.this$0;
                        v4 = Result.exceptionOrNull-impl((Object)var3_4);
                        if (v4 != null) {
                            err = var5_8 = v4;
                            $i$a$-onFailure-HomeViewModel$loadFeed$1$3 = false;
                            HomeViewModel.access$get_error$p(var4_5).setValue((Object)err);
                        }
                        HomeViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)false));
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

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)3, null);
    }

    public static /* synthetic */ void loadFeed$default(HomeViewModel homeViewModel, MusicExtension musicExtension, int n, Object object) {
        if ((n & 1) != 0) {
            musicExtension = null;
        }
        homeViewModel.loadFeed(musicExtension);
    }

    public final void selectTab(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter((Object)tab, (String)"tab");
        this._selectedTab.setValue((Object)tab);
        Feed currentFeed = (Feed)this._feed.getValue();
        if (currentFeed != null) {
            BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, (Feed<Shelf>)currentFeed, tab, null){
                Object L$1;
                Object L$2;
                Object L$3;
                int I$0;
                int label;
                private /* synthetic */ Object L$0;
                final /* synthetic */ HomeViewModel this$0;
                final /* synthetic */ Feed<Shelf> $currentFeed;
                final /* synthetic */ Tab $tab;
                {
                    this.this$0 = $receiver;
                    this.$currentFeed = $currentFeed;
                    this.$tab = $tab;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 * Could not resolve type clashes
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (CoroutineScope)this.L$0;
                    var11_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            HomeViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)true));
                            var3_4 /* !! */  = $this$launch;
                            var4_5 = this.$currentFeed;
                            var5_6 = this.$tab;
                            var6_7 = this.this$0;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = var3_4 /* !! */ ;
                            $i$a$-runCatching-HomeViewModel$selectTab$1$1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                            this.L$1 = var6_7;
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240 /* !! */ );
                            this.I$0 = $i$a$-runCatching-HomeViewModel$selectTab$1$1;
                            this.label = 1;
                            v0 = var4_5.getGetPagedData().invoke(var5_6, (Object)this);
                            ** if (v0 != var11_3) goto lbl24
lbl23:
                            // 1 sources

                            return var11_3;
lbl24:
                            // 1 sources

                            ** GOTO lbl33
                        }
                        case 1: {
                            $i$a$-runCatching-HomeViewModel$selectTab$1$1 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = (CoroutineScope)this.L$2;
                            var6_7 = (HomeViewModel)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl33:
                            // 2 sources

                            feedData = (Feed.Data)v0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                            this.L$1 = var6_7;
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240 /* !! */ );
                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)feedData);
                            this.I$0 = $i$a$-runCatching-HomeViewModel$selectTab$1$1;
                            this.label = 2;
                            v1 = feedData.getPagedData().loadPage((String)null, this);
                            ** if (v1 != var11_3) goto lbl43
lbl42:
                            // 1 sources

                            return var11_3;
lbl43:
                            // 1 sources

                            ** GOTO lbl53
                        }
                        case 2: {
                            $i$a$-runCatching-HomeViewModel$selectTab$1$1 = this.I$0;
                            feedData = (Feed.Data)this.L$3;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = (CoroutineScope)this.L$2;
                            var6_7 = (HomeViewModel)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl53:
                                // 2 sources

                                initialPage = (Page)v1;
                                HomeViewModel.access$get_shelves$p(var6_7).setValue(initialPage.getData());
                                $this$invokeSuspend_u24lambda_u240 /* !! */  = Result.constructor-impl((Object)Unit.INSTANCE);
                            }
                            catch (Throwable var8_11) {
                                $this$invokeSuspend_u24lambda_u240 /* !! */  = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var8_11));
                            }
                            var3_4 /* !! */  = $this$invokeSuspend_u24lambda_u240 /* !! */ ;
                            var4_5 = this.this$0;
                            v2 = Result.exceptionOrNull-impl((Object)var3_4 /* !! */ );
                            if (v2 != null) {
                                err = var5_6 = v2;
                                $i$a$-onFailure-HomeViewModel$selectTab$1$2 = false;
                                HomeViewModel.access$get_error$p((HomeViewModel)var4_5).setValue(err);
                            }
                            HomeViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)false));
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

                public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            }), (int)3, null);
        } else {
            HomeViewModel.loadFeed$default(this, null, 1, null);
        }
    }

    public static final /* synthetic */ MutableStateFlow access$get_isLoading$p(HomeViewModel $this) {
        return $this._isLoading;
    }

    public static final /* synthetic */ MutableStateFlow access$get_error$p(HomeViewModel $this) {
        return $this._error;
    }

    public static final /* synthetic */ MutableStateFlow access$get_selectedTab$p(HomeViewModel $this) {
        return $this._selectedTab;
    }

    public static final /* synthetic */ MutableStateFlow access$get_shelves$p(HomeViewModel $this) {
        return $this._shelves;
    }

    public static final /* synthetic */ MutableStateFlow access$get_feed$p(HomeViewModel $this) {
        return $this._feed;
    }
}

