/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
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
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.SupervisorKt
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
import dev.brahmkshatriya.echo.common.clients.QuickSearchClient;
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.Page;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.QuickSearchItem;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import java.util.List;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\nJ\u0010\u0010-\u001a\u00020+2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u001dJ\u0006\u00100\u001a\u00020+R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000eR\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000eR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000eR\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/SearchViewModel;", "", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Lkotlinx/coroutines/CoroutineScope;)V", "_query", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "query", "Lkotlinx/coroutines/flow/StateFlow;", "getQuery", "()Lkotlinx/coroutines/flow/StateFlow;", "_quickResults", "", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "quickResults", "getQuickResults", "_searchFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "searchFeed", "getSearchFeed", "_shelves", "shelves", "getShelves", "_selectedTab", "Ldev/brahmkshatriya/echo/common/models/Tab;", "selectedTab", "getSelectedTab", "_isLoading", "", "isLoading", "_error", "", "error", "getError", "quickSearchJob", "Lkotlinx/coroutines/Job;", "searchJob", "updateQuery", "", "newQuery", "search", "selectTab", "tab", "clearSearch", "desktopApp"})
@StabilityInferred(parameters=0)
public final class SearchViewModel {
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableStateFlow<String> _query;
    @NotNull
    private final StateFlow<String> query;
    @NotNull
    private final MutableStateFlow<List<QuickSearchItem>> _quickResults;
    @NotNull
    private final StateFlow<List<QuickSearchItem>> quickResults;
    @NotNull
    private final MutableStateFlow<Feed<Shelf>> _searchFeed;
    @NotNull
    private final StateFlow<Feed<Shelf>> searchFeed;
    @NotNull
    private final MutableStateFlow<List<Shelf>> _shelves;
    @NotNull
    private final StateFlow<List<Shelf>> shelves;
    @NotNull
    private final MutableStateFlow<Tab> _selectedTab;
    @NotNull
    private final StateFlow<Tab> selectedTab;
    @NotNull
    private final MutableStateFlow<Boolean> _isLoading;
    @NotNull
    private final StateFlow<Boolean> isLoading;
    @NotNull
    private final MutableStateFlow<Throwable> _error;
    @NotNull
    private final StateFlow<Throwable> error;
    @Nullable
    private Job quickSearchJob;
    @Nullable
    private Job searchJob;
    public static final int $stable = 8;

    public SearchViewModel(@NotNull ExtensionManager extensionManager, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.extensionManager = extensionManager;
        this.scope = scope;
        this._query = StateFlowKt.MutableStateFlow((Object)"");
        this.query = FlowKt.asStateFlow(this._query);
        this._quickResults = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.quickResults = FlowKt.asStateFlow(this._quickResults);
        this._searchFeed = StateFlowKt.MutableStateFlow(null);
        this.searchFeed = FlowKt.asStateFlow(this._searchFeed);
        this._shelves = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.shelves = FlowKt.asStateFlow(this._shelves);
        this._selectedTab = StateFlowKt.MutableStateFlow(null);
        this.selectedTab = FlowKt.asStateFlow(this._selectedTab);
        this._isLoading = StateFlowKt.MutableStateFlow((Object)false);
        this.isLoading = FlowKt.asStateFlow(this._isLoading);
        this._error = StateFlowKt.MutableStateFlow(null);
        this.error = FlowKt.asStateFlow(this._error);
    }

    public /* synthetic */ SearchViewModel(ExtensionManager extensionManager, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(extensionManager, coroutineScope);
    }

    @NotNull
    public final StateFlow<String> getQuery() {
        return this.query;
    }

    @NotNull
    public final StateFlow<List<QuickSearchItem>> getQuickResults() {
        return this.quickResults;
    }

    @NotNull
    public final StateFlow<Feed<Shelf>> getSearchFeed() {
        return this.searchFeed;
    }

    @NotNull
    public final StateFlow<List<Shelf>> getShelves() {
        return this.shelves;
    }

    @NotNull
    public final StateFlow<Tab> getSelectedTab() {
        return this.selectedTab;
    }

    @NotNull
    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    @NotNull
    public final StateFlow<Throwable> getError() {
        return this.error;
    }

    public final void updateQuery(@NotNull String newQuery) {
        Intrinsics.checkNotNullParameter((Object)newQuery, (String)"newQuery");
        this._query.setValue((Object)newQuery);
        Job job2 = this.quickSearchJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
        }
        if (StringsKt.isBlank((CharSequence)newQuery)) {
            this._quickResults.setValue((Object)CollectionsKt.emptyList());
            return;
        }
        this.quickSearchJob = BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, newQuery, null){
            Object L$0;
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            final /* synthetic */ SearchViewModel this$0;
            final /* synthetic */ String $newQuery;
            {
                this.this$0 = $receiver;
                this.$newQuery = $newQuery;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var7_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = DelayKt.delay((long)300L, (Continuation)((Continuation)this));
                        if (v0 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        v1 = (MusicExtension)SearchViewModel.access$getExtensionManager$p(this.this$0).getCurrent().getValue();
                        if (v1 == null) {
                            return Unit.INSTANCE;
                        }
                        ext = v1;
                        var3_5 = ExtensionUtils.INSTANCE;
                        var4_6 = ext;
                        var5_7 = this.$newQuery;
                        $i$f$getIf-0E7RQCE = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$getIf_u2d0E7RQCE$iv);
                        this.I$0 = $i$f$getIf-0E7RQCE;
                        this.label = 2;
                        v2 = this_$iv.get-0E7RQCE($this$getIf_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super List<? extends QuickSearchItem>>, Object>(null, var5_7){
                            Object L$1;
                            Object L$2;
                            int I$0;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ String $newQuery$inlined;
                            Object L$3;
                            Object L$4;
                            int I$1;
                            {
                                this.$newQuery$inlined = string2;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                Object object;
                                block6: {
                                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            void $completion;
                                            QuickSearchClient client;
                                            void $this$get;
                                            ResultKt.throwOnFailure((Object)$result);
                                            Object v0 = $this$get;
                                            if (!(v0 instanceof QuickSearchClient)) {
                                                v0 = null;
                                            }
                                            QuickSearchClient quickSearchClient = client = (QuickSearchClient)v0;
                                            if (quickSearchClient == null) break;
                                            QuickSearchClient it = quickSearchClient;
                                            int n = 0;
                                            Continuation continuation = (Continuation)this;
                                            QuickSearchClient $this$invokeSuspend_u24lambda_u240 = it;
                                            int n2 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                                            this.I$0 = n;
                                            this.I$1 = n2;
                                            this.label = 1;
                                            object = $this$invokeSuspend_u24lambda_u240.quickSearch(this.$newQuery$inlined, (Continuation<? super List<? extends QuickSearchItem>>)this);
                                            if (object == object2) {
                                                return object2;
                                            }
                                            break block6;
                                        }
                                        case 1: {
                                            int n = this.I$1;
                                            int n3 = this.I$0;
                                            QuickSearchClient $this$invokeSuspend_u24lambda_u240 = (QuickSearchClient)this.L$4;
                                            Continuation $completion = (Continuation)this.L$3;
                                            QuickSearchClient it = (QuickSearchClient)this.L$2;
                                            QuickSearchClient client = (QuickSearchClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            object = $result;
                                            break block6;
                                        }
                                    }
                                    object = null;
                                }
                                return object;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super List<? extends QuickSearchItem>> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, (Continuation)this);
                        if (v2 == var7_2) {
                            return var7_2;
                        }
                        ** GOTO lbl38
                    }
                    case 2: {
                        $i$f$getIf-0E7RQCE = this.I$0;
                        $this$getIf_u2d0E7RQCE$iv = (Extension)this.L$2;
                        this_$iv = (ExtensionUtils)this.L$1;
                        ext = (MusicExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = ((Result)$result).unbox-impl();
lbl38:
                        // 2 sources

                        var3_5 = v2;
                        var4_6 = this.this$0;
                        if (Result.isSuccess-impl((Object)var3_5)) {
                            results = (List)var3_5;
                            $i$a$-onSuccess-SearchViewModel$updateQuery$1$2 = false;
                            v3 = SearchViewModel.access$get_quickResults$p((SearchViewModel)var4_6);
                            v4 = results;
                            if (v4 == null) {
                                v4 = CollectionsKt.emptyList();
                            }
                            v3.setValue((Object)v4);
                        }
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
    }

    public final void search(@NotNull String query) {
        Intrinsics.checkNotNullParameter((Object)query, (String)"query");
        if (StringsKt.isBlank((CharSequence)query)) {
            return;
        }
        this._query.setValue((Object)query);
        this._quickResults.setValue((Object)CollectionsKt.emptyList());
        Job job2 = this.searchJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
        }
        this.searchJob = BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, query, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int I$0;
            int I$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ SearchViewModel this$0;
            final /* synthetic */ String $query;
            {
                this.this$0 = $receiver;
                this.$query = $query;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                var13_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        SearchViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)true));
                        SearchViewModel.access$get_error$p(this.this$0).setValue(null);
                        v0 = (MusicExtension)SearchViewModel.access$getExtensionManager$p(this.this$0).getCurrent().getValue();
                        if (v0 == null) {
                            return Unit.INSTANCE;
                        }
                        ext = v0;
                        var4_6 = ExtensionUtils.INSTANCE;
                        var5_7 = ext;
                        var6_8 = this.$query;
                        $i$f$getAs-0E7RQCE = 0;
                        this.L$0 = $this$launch;
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE$iv);
                        this.I$0 = $i$f$getAs-0E7RQCE;
                        this.label = 1;
                        v1 = this_$iv.get-0E7RQCE($this$getAs_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super Feed<Shelf>>, Object>(null, (String)var6_8){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ String $query$inlined;
                            Object L$2;
                            Object L$3;
                            int I$0;
                            {
                                this.$query$inlined = string2;
                                super(2, $completion);
                            }

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
                                        if (!(v0 instanceof SearchFeedClient)) {
                                            v0 = null;
                                        }
                                        SearchFeedClient searchFeedClient = v0;
                                        if (searchFeedClient == null) {
                                            String string2 = Reflection.getOrCreateKotlinClass(SearchFeedClient.class).getSimpleName();
                                            if (string2 != null) throw new ClientException.NotSupported(string2);
                                            string2 = "Unknown";
                                            throw new ClientException.NotSupported(string2);
                                        }
                                        SearchFeedClient client = searchFeedClient;
                                        Continuation continuation = (Continuation)this;
                                        SearchFeedClient $this$invokeSuspend_u24lambda_u240 = client;
                                        int n = 0;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                                        this.I$0 = n;
                                        this.label = 1;
                                        Object object2 = $this$invokeSuspend_u24lambda_u240.loadSearchFeed(this.$query$inlined, (Continuation<? super Feed<Shelf>>)this);
                                        if (object2 != object) return object2;
                                        return object;
                                    }
                                    case 1: {
                                        int n = this.I$0;
                                        SearchFeedClient $this$invokeSuspend_u24lambda_u240 = (SearchFeedClient)this.L$3;
                                        Continuation $completion = (Continuation)this.L$2;
                                        SearchFeedClient client = (SearchFeedClient)this.L$1;
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
                        if (v1 == var13_3) {
                            return var13_3;
                        }
                        ** GOTO lbl34
                    }
                    case 1: {
                        $i$f$getAs-0E7RQCE = this.I$0;
                        $this$getAs_u2d0E7RQCE$iv = (Extension)this.L$3;
                        this_$iv = (ExtensionUtils)this.L$2;
                        ext = (MusicExtension)this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = ((Result)$result).unbox-impl();
lbl34:
                        // 2 sources

                        var4_6 = v1;
                        var5_7 = this.this$0;
                        if (!Result.isSuccess-impl((Object)var4_6)) ** GOTO lbl114
                        feed = (Feed)var4_6;
                        $i$a$-onSuccess-SearchViewModel$search$1$2 = 0;
                        SearchViewModel.access$get_searchFeed$p((SearchViewModel)var5_7).setValue((Object)feed);
                        var8_11 = $this$launch;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = var8_11;
                        $i$a$-runCatching-SearchViewModel$search$1$2$1 = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        this.L$2 = var4_6;
                        this.L$3 = var5_7;
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */ );
                        this.I$0 = $i$a$-onSuccess-SearchViewModel$search$1$2;
                        this.I$1 = $i$a$-runCatching-SearchViewModel$search$1$2$1;
                        this.label = 2;
                        v2 = feed.getGetPagedData().invoke(SearchViewModel.access$get_selectedTab$p((SearchViewModel)var5_7).getValue(), (Object)this);
                        ** if (v2 != var13_3) goto lbl58
lbl57:
                        // 1 sources

                        return var13_3;
lbl58:
                        // 1 sources

                        ** GOTO lbl71
                    }
                    case 2: {
                        $i$a$-runCatching-SearchViewModel$search$1$2$1 = this.I$1;
                        $i$a$-onSuccess-SearchViewModel$search$1$2 = this.I$0;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = (CoroutineScope)this.L$5;
                        feed = (Feed)this.L$4;
                        var5_7 = (SearchViewModel)this.L$3;
                        var4_6 = this.L$2;
                        ext = (MusicExtension)this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl71:
                        // 2 sources

                        feedData = (Feed.Data)v2;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        this.L$2 = var4_6;
                        this.L$3 = var5_7;
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */ );
                        this.L$6 = SpillingKt.nullOutSpilledVariable((Object)feedData);
                        this.I$0 = $i$a$-onSuccess-SearchViewModel$search$1$2;
                        this.I$1 = $i$a$-runCatching-SearchViewModel$search$1$2$1;
                        this.label = 3;
                        v3 = feedData.getPagedData().loadPage((String)null, this);
                        ** if (v3 != var13_3) goto lbl85
lbl84:
                        // 1 sources

                        return var13_3;
lbl85:
                        // 1 sources

                        ** GOTO lbl99
                    }
                    case 3: {
                        $i$a$-runCatching-SearchViewModel$search$1$2$1 = this.I$1;
                        $i$a$-onSuccess-SearchViewModel$search$1$2 = this.I$0;
                        feedData = (Feed.Data)this.L$6;
                        $this$invokeSuspend_u24lambda_u243_u24lambda_u241 /* !! */  = (CoroutineScope)this.L$5;
                        feed = (Feed)this.L$4;
                        var5_7 = (SearchViewModel)this.L$3;
                        var4_6 = this.L$2;
                        ext = (MusicExtension)this.L$1;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = $result;
lbl99:
                            // 2 sources

                            initialPage = (Page)v3;
                            SearchViewModel.access$get_shelves$p((SearchViewModel)var5_7).setValue(initialPage.getData());
                            var9_13 = Result.constructor-impl((Object)Unit.INSTANCE);
                        }
                        catch (Throwable $i$a$-runCatching-SearchViewModel$search$1$2$1) {
                            var9_13 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-SearchViewModel$search$1$2$1));
                        }
                        var8_11 = var9_13;
                        v4 = Result.exceptionOrNull-impl((Object)var8_11);
                        if (v4 != null) {
                            err = var9_13 = v4;
                            $i$a$-onFailure-SearchViewModel$search$1$2$2 = false;
                            SearchViewModel.access$get_error$p((SearchViewModel)var5_7).setValue(err);
                        }
lbl114:
                        // 4 sources

                        var5_7 = this.this$0;
                        v5 = Result.exceptionOrNull-impl((Object)var4_6);
                        if (v5 != null) {
                            err = var6_8 = v5;
                            $i$a$-onFailure-SearchViewModel$search$1$3 = false;
                            SearchViewModel.access$get_error$p((SearchViewModel)var5_7).setValue(err);
                        }
                        SearchViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)false));
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

    public static /* synthetic */ void search$default(SearchViewModel searchViewModel, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = (String)searchViewModel._query.getValue();
        }
        searchViewModel.search(string2);
    }

    public final void selectTab(@NotNull Tab tab) {
        Intrinsics.checkNotNullParameter((Object)tab, (String)"tab");
        this._selectedTab.setValue((Object)tab);
        Feed currentFeed = (Feed)this._searchFeed.getValue();
        if (currentFeed != null) {
            BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, (Feed<Shelf>)currentFeed, tab, null){
                Object L$1;
                Object L$2;
                Object L$3;
                int I$0;
                int label;
                private /* synthetic */ Object L$0;
                final /* synthetic */ SearchViewModel this$0;
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
                            SearchViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)true));
                            var3_4 /* !! */  = $this$launch;
                            var4_5 = this.$currentFeed;
                            var5_6 = this.$tab;
                            var6_7 = this.this$0;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = var3_4 /* !! */ ;
                            $i$a$-runCatching-SearchViewModel$selectTab$1$1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                            this.L$1 = var6_7;
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240 /* !! */ );
                            this.I$0 = $i$a$-runCatching-SearchViewModel$selectTab$1$1;
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
                            $i$a$-runCatching-SearchViewModel$selectTab$1$1 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = (CoroutineScope)this.L$2;
                            var6_7 = (SearchViewModel)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl33:
                            // 2 sources

                            feedData = (Feed.Data)v0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                            this.L$1 = var6_7;
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240 /* !! */ );
                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)feedData);
                            this.I$0 = $i$a$-runCatching-SearchViewModel$selectTab$1$1;
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
                            $i$a$-runCatching-SearchViewModel$selectTab$1$1 = this.I$0;
                            feedData = (Feed.Data)this.L$3;
                            $this$invokeSuspend_u24lambda_u240 /* !! */  = (CoroutineScope)this.L$2;
                            var6_7 = (SearchViewModel)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl53:
                                // 2 sources

                                initialPage = (Page)v1;
                                SearchViewModel.access$get_shelves$p(var6_7).setValue(initialPage.getData());
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
                                $i$a$-onFailure-SearchViewModel$selectTab$1$2 = false;
                                SearchViewModel.access$get_error$p((SearchViewModel)var4_5).setValue(err);
                            }
                            SearchViewModel.access$get_isLoading$p(this.this$0).setValue((Object)Boxing.boxBoolean((boolean)false));
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
            SearchViewModel.search$default(this, null, 1, null);
        }
    }

    public final void clearSearch() {
        block1: {
            this._query.setValue((Object)"");
            this._quickResults.setValue((Object)CollectionsKt.emptyList());
            this._searchFeed.setValue(null);
            this._shelves.setValue((Object)CollectionsKt.emptyList());
            Job job2 = this.searchJob;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
            }
            Job job3 = this.quickSearchJob;
            if (job3 == null) break block1;
            Job.DefaultImpls.cancel$default((Job)job3, null, (int)1, null);
        }
    }

    public static final /* synthetic */ ExtensionManager access$getExtensionManager$p(SearchViewModel $this) {
        return $this.extensionManager;
    }

    public static final /* synthetic */ MutableStateFlow access$get_quickResults$p(SearchViewModel $this) {
        return $this._quickResults;
    }

    public static final /* synthetic */ MutableStateFlow access$get_isLoading$p(SearchViewModel $this) {
        return $this._isLoading;
    }

    public static final /* synthetic */ MutableStateFlow access$get_error$p(SearchViewModel $this) {
        return $this._error;
    }

    public static final /* synthetic */ MutableStateFlow access$get_selectedTab$p(SearchViewModel $this) {
        return $this._selectedTab;
    }

    public static final /* synthetic */ MutableStateFlow access$get_shelves$p(SearchViewModel $this) {
        return $this._shelves;
    }

    public static final /* synthetic */ MutableStateFlow access$get_searchFeed$p(SearchViewModel $this) {
        return $this._searchFeed;
    }
}

