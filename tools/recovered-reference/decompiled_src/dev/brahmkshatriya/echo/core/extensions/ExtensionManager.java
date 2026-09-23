/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Lazy
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.SharedFlowKt
 *  kotlinx.coroutines.flow.SharingStarted
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.extensions;

import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.TrackerExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Message;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.common.models.NetworkConnection;
import dev.brahmkshatriya.echo.common.providers.GlobalSettingsProvider;
import dev.brahmkshatriya.echo.common.providers.LyricsExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.MessageFlowProvider;
import dev.brahmkshatriya.echo.common.providers.MetadataProvider;
import dev.brahmkshatriya.echo.common.providers.MiscExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.MusicExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.NetworkConnectionProvider;
import dev.brahmkshatriya.echo.common.providers.TrackerExtensionsProvider;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager$mapped$;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager$special$;
import dev.brahmkshatriya.echo.core.extensions.ExtensionRepository;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 K2\u00020\u0001:\u0001KB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(JJ\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H20\u001c01\"\f\b\u0000\u00102*\u0006\u0012\u0002\b\u0003032\u0006\u00104\u001a\u00020\u001b2\u001e\u00105\u001a\u001a\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.\u0012\u0004\u0012\u0002H206H\u0002J \u0010E\u001a\b\u0012\u0004\u0012\u00020/0.*\b\u0012\u0004\u0012\u00020/0F2\u0006\u0010G\u001a\u00020-H\u0002J\u0010\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020/H\u0002J\"\u0010J\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020/030\u001c012\u0006\u00104\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R)\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u00150\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R2\u0010)\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0,0+0\u001c0*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u001c01\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001d\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0\u001c01\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00109R\u001d\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u001c01\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00109R\u001d\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0\u001c01\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00109R%\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020/030\u001c01\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00109\u00a8\u0006L"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "", "repository", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;", "settings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "<init>", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "throwFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "getThrowFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "messageFlow", "Ldev/brahmkshatriya/echo/common/models/Message;", "getMessageFlow", "networkFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/NetworkConnection;", "getNetworkFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "priorityMap", "", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "", "", "getPriorityMap", "()Ljava/util/Map;", "current", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "getCurrent", "setCurrentExtension", "", "setupMusicExtension", "extension", "manual", "", "injected", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "mapped", "Lkotlinx/coroutines/flow/StateFlow;", "T", "Ldev/brahmkshatriya/echo/common/Extension;", "type", "transform", "Lkotlin/Function2;", "music", "getMusic", "()Lkotlinx/coroutines/flow/StateFlow;", "tracker", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "getTracker", "lyrics", "Ldev/brahmkshatriya/echo/common/LyricsExtension;", "getLyrics", "misc", "Ldev/brahmkshatriya/echo/common/MiscExtension;", "getMisc", "all", "getAll", "withInjections", "Lkotlin/Lazy;", "metadata", "injectProviders", "client", "getFlow", "Companion", "core"})
@SourceDebugExtension(value={"SMAP\nExtensionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionManager.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,227:1\n1285#2,2:228\n1299#2,2:230\n774#2:232\n865#2,2:233\n1302#2:235\n295#2,2:247\n49#3:236\n51#3:240\n49#3:241\n51#3:245\n49#3:249\n51#3:253\n46#4:237\n51#4:239\n46#4:242\n51#4:244\n46#4:250\n51#4:252\n105#5:238\n105#5:243\n105#5:251\n1#6:246\n*S KotlinDebug\n*F\n+ 1 ExtensionManager.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionManager\n*L\n66#1:228,2\n66#1:230,2\n68#1:232\n68#1:233,2\n66#1:235\n85#1:247,2\n107#1:236\n107#1:240\n115#1:241\n115#1:245\n127#1:249\n127#1:253\n107#1:237\n107#1:239\n115#1:242\n115#1:244\n127#1:250\n127#1:252\n107#1:238\n115#1:243\n127#1:251\n*E\n"})
public final class ExtensionManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ExtensionRepository repository;
    @NotNull
    private final EchoSettings settings;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableSharedFlow<Throwable> throwFlow;
    @NotNull
    private final MutableSharedFlow<Message> messageFlow;
    @NotNull
    private final MutableStateFlow<NetworkConnection> networkFlow;
    @NotNull
    private final Map<ExtensionType, MutableStateFlow<List<String>>> priorityMap;
    @NotNull
    private final MutableStateFlow<MusicExtension> current;
    @NotNull
    private final Flow<List<Result<Pair<Metadata, Injectable<ExtensionClient>>>>> injected;
    @NotNull
    private final StateFlow<List<MusicExtension>> music;
    @NotNull
    private final StateFlow<List<TrackerExtension>> tracker;
    @NotNull
    private final StateFlow<List<LyricsExtension>> lyrics;
    @NotNull
    private final StateFlow<List<MiscExtension>> misc;
    @NotNull
    private final StateFlow<List<Extension<? extends ExtensionClient>>> all;
    @NotNull
    public static final String LAST_EXTENSION_KEY = "last_extension";

    /*
     * WARNING - void declaration
     */
    public ExtensionManager(@NotNull ExtensionRepository repository, @NotNull EchoSettings settings) {
        void $this$associateWith$iv;
        Intrinsics.checkNotNullParameter((Object)repository, (String)"repository");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.repository = repository;
        this.settings = settings;
        this.scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getDefault().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        this.throwFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)10, null, (int)5, null);
        this.messageFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)10, null, (int)5, null);
        this.networkFlow = StateFlowKt.MutableStateFlow((Object)((Object)NetworkConnection.Unmetered));
        Iterable iterable = (Iterable)ExtensionType.getEntries();
        ExtensionManager extensionManager = this;
        boolean $i$f$associateWith = false;
        LinkedHashMap result$iv = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith$iv, (int)10)), (int)16));
        void $this$associateWithTo$iv$iv = $this$associateWith$iv;
        boolean $i$f$associateWithTo = false;
        for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
            void $this$filterTo$iv$iv;
            void type;
            ExtensionType extensionType = (ExtensionType)((Object)element$iv$iv);
            Object t = element$iv$iv;
            Map map2 = result$iv;
            boolean bl = false;
            String key = Companion.priorityKey((ExtensionType)type);
            String string2 = this.settings.getString(key, null);
            if (string2 == null) {
                string2 = "";
            }
            char[] cArray = new char[]{','};
            Iterable $this$filter$iv = StringsKt.split$default((CharSequence)string2, (char[])cArray, (boolean)false, (int)0, (int)6, null);
            boolean $i$f$filter = false;
            Iterable iterable2 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
                String it = (String)element$iv$iv2;
                boolean bl2 = false;
                boolean bl3 = !StringsKt.isBlank((CharSequence)it);
                if (!bl3) continue;
                destination$iv$iv.add(element$iv$iv2);
            }
            List list2 = (List)destination$iv$iv;
            MutableStateFlow mutableStateFlow = StateFlowKt.MutableStateFlow((Object)list2);
            map2.put(t, mutableStateFlow);
        }
        extensionManager.priorityMap = result$iv;
        this.current = StateFlowKt.MutableStateFlow(null);
        Flow $this$map$iv = this.repository.getFlow();
        boolean $i$f$map = false;
        Flow $this$unsafeTransform$iv$iv = $this$map$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        $this$map$iv = (Flow)new Flow<List<? extends Result<? extends Pair<? extends Metadata, ? extends Lazy<? extends ExtensionClient>>>>>($this$unsafeTransform$iv$iv){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ special$$inlined$map$1$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list = (List)value;
                                $i$a$-map-ExtensionManager$injected$1 = false;
                                $this$groupBy$iv = list;
                                $i$f$groupBy = false;
                                var16_20 = $this$groupBy$iv;
                                destination$iv$iv = new LinkedHashMap<K, V>();
                                $i$f$groupByTo = false;
                                for (T element$iv$iv : $this$groupByTo$iv$iv) {
                                    it = ((Result)element$iv$iv).unbox-impl();
                                    $i$a$-groupBy-ExtensionManager$injected$1$1 = false;
                                    v0 = (Pair)(Result.isFailure-impl((Object)it) != false ? null : it);
                                    if (v0 != null && (v0 = (Metadata)v0.getFirst()) != null) {
                                        $this$injected_u24lambda_u2411_u24lambda_u248_u24lambda_u247 = v0;
                                        $i$a$-run-ExtensionManager$injected$1$1$1 = false;
                                        v1 = TuplesKt.to((Object)$this$injected_u24lambda_u2411_u24lambda_u248_u24lambda_u247.getType(), (Object)$this$injected_u24lambda_u2411_u24lambda_u248_u24lambda_u247.getId());
                                    } else {
                                        v1 = null;
                                    }
                                    key$iv$iv = v1;
                                    $this$getOrPut$iv$iv$iv = destination$iv$iv;
                                    $i$f$getOrPut = false;
                                    value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
                                    if (value$iv$iv$iv == null) {
                                        $i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1$iv$iv = false;
                                        answer$iv$iv$iv = new ArrayList<E>();
                                        $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                                        v2 /* !! */  = answer$iv$iv$iv;
                                    } else {
                                        v2 /* !! */  = value$iv$iv$iv;
                                    }
                                    list$iv$iv = (List)v2 /* !! */ ;
                                    list$iv$iv.add(element$iv$iv);
                                }
                                $this$groupBy$iv = destination$iv$iv;
                                $i$f$map = false;
                                $this$groupByTo$iv$iv = $this$map$iv;
                                destination$iv$iv = new ArrayList<E>($this$map$iv.size());
                                $i$f$mapTo = false;
                                var19_23 = $this$mapTo$iv$iv.entrySet().iterator();
                                while (var19_23.hasNext()) {
                                    var21_25 = item$iv$iv = (Map.Entry)var19_23.next();
                                    var30_41 = destination$iv$iv;
                                    $i$a$-map-ExtensionManager$injected$1$2 = false;
                                    entries = (List)var21_25.getValue();
                                    $this$minBy$iv = entries;
                                    $i$f$minByOrThrow = false;
                                    iterator$iv = $this$minBy$iv.iterator();
                                    if (!iterator$iv.hasNext()) {
                                        throw new NoSuchElementException();
                                    }
                                    minElem$iv = iterator$iv.next();
                                    if (!iterator$iv.hasNext()) {
                                        v3 = minElem$iv;
                                    } else {
                                        it = ((Result)minElem$iv).unbox-impl();
                                        $i$a$-minByOrThrow-ExtensionManager$injected$1$2$1 = false;
                                        v4 = (Pair)(Result.isFailure-impl((Object)it) != false ? null : it);
                                        minValue$iv = v4 != null && (v4 = (Metadata)v4.getFirst()) != null && (v4 = v4.getImportType()) != null ? v4.ordinal() : 0x7FFFFFFF;
                                        do {
                                            e$iv = iterator$iv.next();
                                            it = ((Result)e$iv).unbox-impl();
                                            $i$a$-minByOrThrow-ExtensionManager$injected$1$2$1 = false;
                                            v5 = (Pair)(Result.isFailure-impl((Object)it) != false ? null : it);
                                            v6 = v5 != null && (v5 = (Metadata)v5.getFirst()) != null && (v5 = v5.getImportType()) != null ? v5.ordinal() : (v$iv = 0x7FFFFFFF);
                                            if (minValue$iv <= v$iv) continue;
                                            minElem$iv = e$iv;
                                            minValue$iv = v$iv;
                                        } while (iterator$iv.hasNext());
                                        v3 = minElem$iv;
                                    }
                                    var30_41.add(Result.box-impl((Object)((Result)v3).unbox-impl()));
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1;
                                $continuation.label = 1;
                                v7 = var10_14.emit((Object)((List)destination$iv$iv), (Continuation)$continuation);
                                if (v7 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl110
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v7 = $result;
lbl110:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        $i$f$map = false;
        $this$unsafeTransform$iv$iv = $this$map$iv;
        $i$f$unsafeTransform = false;
        $i$f$unsafeFlow = false;
        this.injected = (Flow)new Flow<List<? extends Result<? extends Pair<? extends Metadata, ? extends Injectable<ExtensionClient>>>>>($this$unsafeTransform$iv$iv, this){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ ExtensionManager this$0;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.this$0 = extensionManager;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.this$0){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ ExtensionManager this$0;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.this$0 = extensionManager;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof special$$inlined$map$2$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ special$$inlined$map$2$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list = (List)value;
                                $i$a$-map-ExtensionManager$injected$2 = false;
                                $this$map$iv = list;
                                $i$f$map = false;
                                var16_20 = $this$map$iv;
                                destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                                $i$f$mapTo = false;
                                for (T item$iv$iv : $this$mapTo$iv$iv) {
                                    var21_25 = ((Result)item$iv$iv).unbox-impl();
                                    var22_26 = destination$iv$iv;
                                    $i$a$-map-ExtensionManager$injected$2$1 = false;
                                    var24_28 = result;
                                    if (Result.isSuccess-impl((Object)var24_28)) {
                                        var25_29 = (Pair)var24_28;
                                        $i$a$-map-ExtensionManager$injected$2$1$1 = false;
                                        metadata = (Metadata)var25_29.component1();
                                        lazyClient = (Lazy)var25_29.component2();
                                        v0 = Result.constructor-impl((Object)TuplesKt.to((Object)metadata, (Object)ExtensionManager.access$withInjections(this.this$0, lazyClient, metadata)));
                                    } else {
                                        v0 = Result.constructor-impl((Object)var24_28);
                                    }
                                    var22_26.add(Result.box-impl((Object)v0));
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1;
                                $continuation.label = 1;
                                v1 = var10_14.emit((Object)((List)destination$iv$iv), (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl61
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl61:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        this.music = this.mapped(ExtensionType.MUSIC, ExtensionManager::music$lambda$17);
        this.tracker = this.mapped(ExtensionType.TRACKER, ExtensionManager::tracker$lambda$18);
        this.lyrics = this.mapped(ExtensionType.LYRICS, ExtensionManager::lyrics$lambda$19);
        this.misc = this.mapped(ExtensionType.MISC, ExtensionManager::misc$lambda$20);
        this.all = FlowKt.stateIn((Flow)FlowKt.combine((Flow)((Flow)this.music), (Flow)((Flow)this.tracker), (Flow)((Flow)this.lyrics), (Flow)((Flow)this.misc), (Function5)((Function5)new Function5<List<? extends MusicExtension>, List<? extends TrackerExtension>, List<? extends LyricsExtension>, List<? extends MiscExtension>, Continuation<? super List<? extends Extension<? extends ExtensionClient>>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            /* synthetic */ Object L$3;

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                List list3 = (List)this.L$1;
                List list4 = (List)this.L$2;
                List list5 = (List)this.L$3;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void mi;
                        void l;
                        void t;
                        void m;
                        ResultKt.throwOnFailure((Object)$result);
                        return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)((Collection)m), (Iterable)((Iterable)t)), (Iterable)((Iterable)l)), (Iterable)((Iterable)mi));
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<MusicExtension> p1, List<TrackerExtension> p2, List<LyricsExtension> p3, List<MiscExtension> p4, Continuation<? super List<? extends Extension<? extends ExtensionClient>>> p5) {
                var var6_6 = new /* invalid duplicate definition of identical inner class */;
                var6_6.L$0 = p1;
                var6_6.L$1 = p2;
                var6_6.L$2 = p3;
                var6_6.L$3 = p4;
                return var6_6.invokeSuspend(Unit.INSTANCE);
            }
        })), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getLazily(), (Object)CollectionsKt.emptyList());
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionManager this$0;
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
                        Object object2 = this.this$0.getAll().collect(new FlowCollector(){

                            /*
                             * Unable to fully structure code
                             */
                            public final Object emit(List<? extends Extension<? extends ExtensionClient>> list, Continuation<? super Unit> $completion) {
                                if (!($completion instanceof emit.1)) ** GOTO lbl-1000
                                var11_3 = $completion;
                                if ((var11_3.label & -2147483648) != 0) {
                                    var11_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, $completion){
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        Object L$3;
                                        Object L$4;
                                        Object L$5;
                                        int I$0;
                                        int I$1;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ 1<T> this$0;
                                        int label;
                                        {
                                            this.this$0 = this$0;
                                            super($completion);
                                        }

                                        public final Object invokeSuspend(Object $result) {
                                            this.result = $result;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                $result = $continuation.result;
                                var12_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        var3_6 = list;
                                        var4_7 = this$0;
                                        $i$f$forEach = 0;
                                        var6_9 = $this$forEach$iv.iterator();
lbl16:
                                        // 3 sources

                                        while (var6_9.hasNext()) {
                                            element$iv = var6_9.next();
                                            ext = (Extension)element$iv;
                                            $i$a$-forEach-ExtensionManager$1$1$1 = 0;
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)list);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach$iv);
                                            $continuation.L$2 = var4_7;
                                            $continuation.L$3 = var6_9;
                                            $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)element$iv);
                                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)ext);
                                            $continuation.I$0 = $i$f$forEach;
                                            $continuation.I$1 = $i$a$-forEach-ExtensionManager$1$1$1;
                                            $continuation.label = 1;
                                            v0 = ExtensionUtils.INSTANCE.inject(ext, "providers", var4_7.getThrowFlow(), (Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(var4_7, null){
                                                int label;
                                                private /* synthetic */ Object L$0;
                                                final /* synthetic */ ExtensionManager this$0;
                                                {
                                                    this.this$0 = $receiver;
                                                    super(2, $completion);
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Object invokeSuspend(Object $result) {
                                                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0: {
                                                            void $this$inject;
                                                            ResultKt.throwOnFailure((Object)$result);
                                                            ExtensionManager.access$injectProviders(this.this$0, (ExtensionClient)$this$inject);
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

                                                public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }), (Continuation<? super Unit>)$continuation);
                                            if (v0 != var12_5) continue;
                                            return var12_5;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        $i$a$-forEach-ExtensionManager$1$1$1 = $continuation.I$1;
                                        $i$f$forEach = $continuation.I$0;
                                        ext = (Extension)$continuation.L$5;
                                        element$iv = $continuation.L$4;
                                        var6_9 = (Iterator)$continuation.L$3;
                                        var4_7 = (ExtensionManager)$continuation.L$2;
                                        $this$forEach$iv = (Iterable)$continuation.L$1;
                                        list = (List)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
                                        ** GOTO lbl16
                                    }
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionManager this$0;
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
                        Object object2 = FlowKt.collectLatest((Flow)((Flow)this.this$0.getMusic()), (Function2)((Function2)new Function2<List<? extends MusicExtension>, Continuation<? super Unit>, Object>(this.this$0, null){
                            int label;
                            final /* synthetic */ ExtensionManager this$0;
                            {
                                this.this$0 = $receiver;
                                super(2, $completion);
                            }

                            public final Object invokeSuspend(Object $result) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        this.this$0.setCurrentExtension();
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(List<MusicExtension> p1, Continuation<? super Unit> p2) {
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
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionManager this$0;
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
                        Object object2 = FlowKt.flowCombine((Flow)((Flow)this.this$0.getNetworkFlow()), (Flow)((Flow)this.this$0.getAll()), (Function3)((Function3)new Function3<NetworkConnection, List<? extends Extension<? extends ExtensionClient>>, Continuation<? super Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>>>, Object>(null){
                            int label;
                            /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                NetworkConnection networkConnection = (NetworkConnection)((Object)this.L$0);
                                List list2 = (List)this.L$1;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void exts;
                                        void conn;
                                        ResultKt.throwOnFailure((Object)$result);
                                        return TuplesKt.to((Object)conn, (Object)exts);
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Object invoke(NetworkConnection p1, List<? extends Extension<? extends ExtensionClient>> p2, Continuation<? super Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>>> p3) {
                                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                                var4_4.L$0 = p1;
                                var4_4.L$1 = p2;
                                return var4_4.invokeSuspend(Unit.INSTANCE);
                            }
                        })).collect(new FlowCollector(){

                            /*
                             * Unable to fully structure code
                             */
                            public final Object emit(Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>> var1_1, Continuation<? super Unit> $completion) {
                                if (!($completion instanceof emit.1)) ** GOTO lbl-1000
                                var13_3 = $completion;
                                if ((var13_3.label & -2147483648) != 0) {
                                    var13_3.label -= -2147483648;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $continuation = new ContinuationImpl(this, $completion){
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        Object L$3;
                                        Object L$4;
                                        Object L$5;
                                        Object L$6;
                                        int I$0;
                                        int I$1;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ 2<T> this$0;
                                        int label;
                                        {
                                            this.this$0 = this$0;
                                            super($completion);
                                        }

                                        public final Object invokeSuspend(Object $result) {
                                            this.result = $result;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                $result = $continuation.result;
                                var14_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        conn = (NetworkConnection)var1_1.component1();
                                        exts = (List)var1_1.component2();
                                        var5_8 = exts;
                                        var6_9 = this$0;
                                        $i$f$forEach = 0;
                                        var8_11 = $this$forEach$iv.iterator();
lbl18:
                                        // 3 sources

                                        while (var8_11.hasNext()) {
                                            element$iv = var8_11.next();
                                            ext = (Extension)element$iv;
                                            $i$a$-forEach-ExtensionManager$3$2$1 = 0;
                                            $continuation.L$0 = conn;
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)exts);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach$iv);
                                            $continuation.L$3 = var6_9;
                                            $continuation.L$4 = var8_11;
                                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)element$iv);
                                            $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)ext);
                                            $continuation.I$0 = $i$f$forEach;
                                            $continuation.I$1 = $i$a$-forEach-ExtensionManager$3$2$1;
                                            $continuation.label = 1;
                                            v0 = ExtensionUtils.INSTANCE.inject(ext, "network", var6_9.getThrowFlow(), (Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(conn, null){
                                                int label;
                                                private /* synthetic */ Object L$0;
                                                final /* synthetic */ NetworkConnection $conn;
                                                {
                                                    this.$conn = $conn;
                                                    super(2, $completion);
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Object invokeSuspend(Object $result) {
                                                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0: {
                                                            void $this$inject;
                                                            ResultKt.throwOnFailure((Object)$result);
                                                            if (!($this$inject instanceof NetworkConnectionProvider)) {
                                                                return Unit.INSTANCE;
                                                            }
                                                            ((NetworkConnectionProvider)$this$inject).setNetworkConnection(this.$conn);
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

                                                public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }), (Continuation<? super Unit>)$continuation);
                                            if (v0 != var14_5) continue;
                                            return var14_5;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        $i$a$-forEach-ExtensionManager$3$2$1 = $continuation.I$1;
                                        $i$f$forEach = $continuation.I$0;
                                        ext = (Extension)$continuation.L$6;
                                        element$iv = $continuation.L$5;
                                        var8_11 = (Iterator<T>)$continuation.L$4;
                                        var6_9 = (ExtensionManager)$continuation.L$3;
                                        $this$forEach$iv = (Iterable)$continuation.L$2;
                                        exts = (List)$continuation.L$1;
                                        conn = (NetworkConnection)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
                                        ** GOTO lbl18
                                    }
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation)this);
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
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
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
    public final MutableStateFlow<NetworkConnection> getNetworkFlow() {
        return this.networkFlow;
    }

    @NotNull
    public final Map<ExtensionType, MutableStateFlow<List<String>>> getPriorityMap() {
        return this.priorityMap;
    }

    @NotNull
    public final MutableStateFlow<MusicExtension> getCurrent() {
        return this.current;
    }

    private final void setCurrentExtension() {
        MusicExtension musicExtension;
        Object object;
        Object object2;
        MusicExtension musicExtension2;
        Iterator<Object> iterator3;
        boolean isLocal;
        String last = this.settings.getString(LAST_EXTENSION_KEY, null);
        List list2 = (List)this.music.getValue();
        boolean bl = isLocal = Intrinsics.areEqual((Object)last, (Object)"local_music") || Intrinsics.areEqual((Object)last, (Object)"desktop_local_music");
        if (last != null && !isLocal) {
            Iterator<Object> iterator2;
            block12: {
                Iterable iterable = list2;
                for (Iterator<Object> iterator3 : iterable) {
                    MusicExtension it = (MusicExtension)((Object)iterator3);
                    boolean bl2 = false;
                    if (!(Intrinsics.areEqual((Object)it.getId(), (Object)last) && it.isEnabled())) continue;
                    iterator2 = iterator3;
                    break block12;
                }
                iterator2 = null;
            }
            musicExtension2 = (MusicExtension)((Object)iterator2);
        } else {
            Object v3;
            MusicExtension it;
            block13: {
                object2 = list2;
                iterator3 = object2.iterator();
                while (iterator3.hasNext()) {
                    object = iterator3.next();
                    it = (MusicExtension)object;
                    boolean bl3 = false;
                    if (!((StringsKt.equals((String)it.getId(), (String)"Youtube_music", (boolean)true) || StringsKt.equals((String)it.getId(), (String)"youtube", (boolean)true)) && it.isEnabled())) continue;
                    v3 = object;
                    break block13;
                }
                v3 = null;
            }
            if ((musicExtension2 = (MusicExtension)v3) == null) {
                Object v4;
                block14: {
                    object2 = list2;
                    iterator3 = object2.iterator();
                    while (iterator3.hasNext()) {
                        object = iterator3.next();
                        it = (MusicExtension)object;
                        boolean bl4 = false;
                        if (!(Intrinsics.areEqual((Object)it.getId(), (Object)last) && it.isEnabled())) continue;
                        v4 = object;
                        break block14;
                    }
                    v4 = null;
                }
                musicExtension2 = musicExtension = (MusicExtension)v4;
            }
        }
        if (musicExtension2 == null) {
            Object object3;
            block15: {
                object2 = list2;
                iterator3 = object2.iterator();
                while (iterator3.hasNext()) {
                    object = iterator3.next();
                    MusicExtension it = (MusicExtension)object;
                    boolean bl5 = false;
                    if (!((StringsKt.equals((String)it.getId(), (String)"Youtube_music", (boolean)true) || StringsKt.equals((String)it.getId(), (String)"youtube", (boolean)true)) && it.isEnabled())) continue;
                    object3 = object;
                    break block15;
                }
                object3 = null;
            }
            if ((musicExtension = (MusicExtension)object3) == null) {
                Object v7;
                block16: {
                    Iterable $this$firstOrNull$iv = list2;
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        MusicExtension it = (MusicExtension)element$iv;
                        boolean bl6 = false;
                        if (!it.isEnabled()) continue;
                        v7 = element$iv;
                        break block16;
                    }
                    v7 = null;
                }
                if ((musicExtension = (MusicExtension)v7) == null) {
                    return;
                }
            }
        }
        MusicExtension extension2 = musicExtension;
        MusicExtension musicExtension3 = (MusicExtension)this.current.getValue();
        if (Intrinsics.areEqual((Object)(musicExtension3 != null ? musicExtension3.getId() : null), (Object)extension2.getId())) {
            return;
        }
        System.out.println((Object)("[Echo ExtensionManager] Setting current music extension to: " + extension2.getMetadata().getName() + " (" + extension2.getId() + ")"));
        this.setupMusicExtension(extension2, false);
    }

    public final void setupMusicExtension(@NotNull MusicExtension extension2, boolean manual) {
        Intrinsics.checkNotNullParameter((Object)extension2, (String)"extension");
        if (manual) {
            this.settings.putString(LAST_EXTENSION_KEY, extension2.getId());
        }
        MusicExtension musicExtension = (MusicExtension)this.current.getValue();
        if (Intrinsics.areEqual((Object)(musicExtension != null ? musicExtension.getId() : null), (Object)extension2.getId())) {
            return;
        }
        this.current.setValue((Object)extension2);
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(extension2, this, null){
            Object L$0;
            int label;
            final /* synthetic */ MusicExtension $extension;
            final /* synthetic */ ExtensionManager this$0;
            {
                this.$extension = $extension;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var3_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        var2_3 = ExtensionUtils.INSTANCE;
                        this.L$0 = var2_3;
                        this.label = 1;
                        v0 = ExtensionUtils.INSTANCE.get-0E7RQCE(this.$extension, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null){
                            int label;
                            private /* synthetic */ Object L$0;

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
                                        void $this$get;
                                        ResultKt.throwOnFailure((Object)$result);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.label = 1;
                                        Object object2 = $this$get.onExtensionSelected((Continuation<? super Unit>)((Continuation)this));
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
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, (Continuation)this);
                        if (v0 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        var2_3 = (ExtensionUtils)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = ((Result)$result).unbox-impl();
lbl16:
                        // 2 sources

                        this.L$0 = null;
                        this.label = 2;
                        v1 = var2_3.getOrEmit(v0, this.this$0.getThrowFlow(), (Continuation)this);
                        if (v1 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl25
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl25:
                        // 2 sources

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

    private final <T extends Extension<?>> StateFlow<List<T>> mapped(ExtensionType type, Function2<? super Metadata, ? super Injectable<ExtensionClient>, ? extends T> transform2) {
        Flow<List<Result<Pair<Metadata, Injectable<ExtensionClient>>>>> $this$map$iv = this.injected;
        boolean $i$f$map = false;
        Flow<List<Result<Pair<Metadata, Injectable<ExtensionClient>>>>> $this$unsafeTransform$iv$iv = $this$map$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        Flow flow2 = new Flow<List<? extends T>>($this$unsafeTransform$iv$iv, type, transform2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ ExtensionType $type$inlined;
            final /* synthetic */ Function2 $transform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$type$inlined = extensionType;
                this.$transform$inlined = function2;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$type$inlined, this.$transform$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ ExtensionType $type$inlined;
                    final /* synthetic */ Function2 $transform$inlined$1;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$type$inlined = extensionType;
                        this.$transform$inlined$1 = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof mapped$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ mapped$$inlined$map$1$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list = (List)value;
                                $i$a$-map-ExtensionManager$mapped$1 = false;
                                $this$mapNotNull$iv = list;
                                $i$f$mapNotNull = false;
                                var16_20 = $this$mapNotNull$iv;
                                destination$iv$iv = new ArrayList<E>();
                                $i$f$mapNotNullTo = false;
                                $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                                $i$f$forEach = false;
                                var21_25 = $this$forEach$iv$iv$iv.iterator();
                                while (var21_25.hasNext()) {
                                    element$iv$iv = element$iv$iv$iv = var21_25.next();
                                    $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                                    result = ((Result)element$iv$iv).unbox-impl();
                                    $i$a$-mapNotNull-ExtensionManager$mapped$1$1 = false;
                                    if ((Pair)(Result.isFailure-impl((Object)result) != false ? null : result) == null) {
                                        v0 = null;
                                    } else {
                                        meta = (Metadata)var27_31.component1();
                                        injectable = (Injectable)var27_31.component2();
                                        v0 = meta.getType() != this.$type$inlined ? null : (meta.isEnabled() == false ? null : (Extension)this.$transform$inlined$1.invoke((Object)meta, (Object)injectable));
                                    }
                                    if (v0 == null) continue;
                                    it$iv$iv = v0;
                                    $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                                    destination$iv$iv.add(it$iv$iv);
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1;
                                $continuation.label = 1;
                                v1 = var10_14.emit((Object)((List)destination$iv$iv), (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl63
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl63:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        MutableStateFlow<List<String>> mutableStateFlow = this.priorityMap.get((Object)type);
        Intrinsics.checkNotNull(mutableStateFlow);
        return FlowKt.stateIn((Flow)FlowKt.flowCombine((Flow)flow2, (Flow)((Flow)mutableStateFlow), (Function3)new Function3<List<? extends T>, List<? extends String>, Continuation<? super List<? extends T>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                List list3 = (List)this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void priority;
                        void list4;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable $this$sortedBy$iv = (Iterable)list4;
                        boolean $i$f$sortedBy = false;
                        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator((List)priority){
                            final /* synthetic */ List $priority$inlined;
                            {
                                this.$priority$inlined = list2;
                            }

                            public final int compare(T a, T b) {
                                Extension ext = (Extension)a;
                                boolean bl = false;
                                Comparable comparable = Integer.valueOf(this.$priority$inlined.indexOf(ext.getMetadata().getId()));
                                ext = (Extension)b;
                                Comparable comparable2 = comparable;
                                bl = false;
                                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(this.$priority$inlined.indexOf(ext.getMetadata().getId())));
                            }
                        });
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<? extends T> p1, List<String> p2, Continuation<? super List<? extends T>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                var4_4.L$1 = p2;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }
        }), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getLazily(), (Object)CollectionsKt.emptyList());
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
    public final StateFlow<List<Extension<? extends ExtensionClient>>> getAll() {
        return this.all;
    }

    private final Injectable<ExtensionClient> withInjections(Lazy<? extends ExtensionClient> $this$withInjections, Metadata metadata2) {
        Object[] objectArray = new Function2[]{new Function2<ExtensionClient, Continuation<? super Unit>, Object>(metadata2, this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Metadata $metadata;
            final /* synthetic */ ExtensionManager this$0;
            {
                this.$metadata = $metadata;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (ExtensionClient)this.L$0;
                var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        if ($this$mutableListOf instanceof MetadataProvider) {
                            ((MetadataProvider)$this$mutableListOf).setMetadata(this.$metadata);
                        }
                        if ($this$mutableListOf instanceof MessageFlowProvider) {
                            ((MessageFlowProvider)$this$mutableListOf).setMessageFlow(this.this$0.getMessageFlow());
                        }
                        if ($this$mutableListOf instanceof GlobalSettingsProvider) {
                            ((GlobalSettingsProvider)$this$mutableListOf).setGlobalSettings(ExtensionManager.access$getSettings$p(this.this$0).toExtensionSettings("global_"));
                        }
                        $this$mutableListOf.setSettings(ExtensionManager.access$getSettings$p(this.this$0).toExtensionSettings("ext_" + this.$metadata.getType() + "_" + this.$metadata.getId() + "_"));
                        this.L$0 = $this$mutableListOf;
                        this.label = 1;
                        v0 = $this$mutableListOf.onInitialize((Continuation<? super Unit>)((Continuation)this));
                        if (v0 == var3_3) {
                            return var3_3;
                        }
                        ** GOTO lbl22
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl22:
                        // 2 sources

                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$mutableListOf);
                        this.label = 2;
                        v1 = $this$mutableListOf.onExtensionSelected((Continuation<? super Unit>)((Continuation)this));
                        if (v1 == var3_3) {
                            return var3_3;
                        }
                        ** GOTO lbl31
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl31:
                        // 2 sources

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

            public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }};
        return new Injectable<ExtensionClient>((Function0)new PropertyReference0Impl($this$withInjections){

            public Object get() {
                return ((Lazy)this.receiver).getValue();
            }
        }, CollectionsKt.mutableListOf((Object[])objectArray));
    }

    private final void injectProviders(ExtensionClient client) {
        block3: {
            MusicExtensionsProvider musicExtensionsProvider = client instanceof MusicExtensionsProvider ? (MusicExtensionsProvider)((Object)client) : null;
            if (musicExtensionsProvider != null) {
                MusicExtensionsProvider $this$injectProviders_u24lambda_u2422 = musicExtensionsProvider;
                boolean bl = false;
                ExtensionManager.Companion.injectRequired($this$injectProviders_u24lambda_u2422, $this$injectProviders_u24lambda_u2422.getRequiredMusicExtensions(), (List)this.music.getValue(), ExtensionManager::injectProviders$lambda$22$lambda$21);
            }
            TrackerExtensionsProvider trackerExtensionsProvider = client instanceof TrackerExtensionsProvider ? (TrackerExtensionsProvider)((Object)client) : null;
            if (trackerExtensionsProvider != null) {
                TrackerExtensionsProvider $this$injectProviders_u24lambda_u2424 = trackerExtensionsProvider;
                boolean bl = false;
                ExtensionManager.Companion.injectRequired($this$injectProviders_u24lambda_u2424, $this$injectProviders_u24lambda_u2424.getRequiredTrackerExtensions(), (List)this.tracker.getValue(), ExtensionManager::injectProviders$lambda$24$lambda$23);
            }
            LyricsExtensionsProvider lyricsExtensionsProvider = client instanceof LyricsExtensionsProvider ? (LyricsExtensionsProvider)((Object)client) : null;
            if (lyricsExtensionsProvider != null) {
                LyricsExtensionsProvider $this$injectProviders_u24lambda_u2426 = lyricsExtensionsProvider;
                boolean bl = false;
                ExtensionManager.Companion.injectRequired($this$injectProviders_u24lambda_u2426, $this$injectProviders_u24lambda_u2426.getRequiredLyricsExtensions(), (List)this.lyrics.getValue(), ExtensionManager::injectProviders$lambda$26$lambda$25);
            }
            MiscExtensionsProvider miscExtensionsProvider = client instanceof MiscExtensionsProvider ? (MiscExtensionsProvider)((Object)client) : null;
            if (miscExtensionsProvider == null) break block3;
            MiscExtensionsProvider $this$injectProviders_u24lambda_u2428 = miscExtensionsProvider;
            boolean bl = false;
            ExtensionManager.Companion.injectRequired($this$injectProviders_u24lambda_u2428, $this$injectProviders_u24lambda_u2428.getRequiredMiscExtensions(), (List)this.misc.getValue(), ExtensionManager::injectProviders$lambda$28$lambda$27);
        }
    }

    @NotNull
    public final StateFlow<List<Extension<? extends ExtensionClient>>> getFlow(@NotNull ExtensionType type) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        return switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1 -> this.music;
            case 2 -> this.tracker;
            case 3 -> this.lyrics;
            case 4 -> this.misc;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    private static final MusicExtension music$lambda$17(Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new MusicExtension(m, i);
    }

    private static final TrackerExtension tracker$lambda$18(Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new TrackerExtension(m, i.casted());
    }

    private static final LyricsExtension lyrics$lambda$19(Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new LyricsExtension(m, i.casted());
    }

    private static final MiscExtension misc$lambda$20(Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new MiscExtension(m, i);
    }

    private static final Unit injectProviders$lambda$22$lambda$21(MusicExtensionsProvider $this$injectRequired, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$injectRequired, (String)"$this$injectRequired");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$injectRequired.setMusicExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$24$lambda$23(TrackerExtensionsProvider $this$injectRequired, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$injectRequired, (String)"$this$injectRequired");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$injectRequired.setTrackerExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$26$lambda$25(LyricsExtensionsProvider $this$injectRequired, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$injectRequired, (String)"$this$injectRequired");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$injectRequired.setLyricsExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$28$lambda$27(MiscExtensionsProvider $this$injectRequired, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$injectRequired, (String)"$this$injectRequired");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$injectRequired.setMiscExtensions(it);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ EchoSettings access$getSettings$p(ExtensionManager $this) {
        return $this.settings;
    }

    public static final /* synthetic */ Injectable access$withInjections(ExtensionManager $this, Lazy $receiver, Metadata metadata2) {
        return $this.withInjections((Lazy<? extends ExtensionClient>)$receiver, metadata2);
    }

    public static final /* synthetic */ void access$injectProviders(ExtensionManager $this, ExtensionClient client) {
        $this.injectProviders(client);
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0007Jf\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\f\b\u0001\u0010\u000b*\u0006\u0012\u0002\b\u00030\f*\u0002H\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2#\u0010\u0010\u001a\u001f\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\u0002\b\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager$Companion;", "", "<init>", "()V", "LAST_EXTENSION_KEY", "", "priorityKey", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "injectRequired", "", "T", "R", "Ldev/brahmkshatriya/echo/common/Extension;", "required", "", "extensions", "set", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "core"})
    @SourceDebugExtension(value={"SMAP\nExtensionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionManager.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionManager$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,227:1\n774#2:228\n865#2,2:229\n1563#2:231\n1634#2,3:232\n*S KotlinDebug\n*F\n+ 1 ExtensionManager.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionManager$Companion\n*L\n217#1:228\n217#1:229,2\n220#1:231\n220#1:232,3\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String priorityKey(@NotNull ExtensionType $this$priorityKey) {
            Intrinsics.checkNotNullParameter((Object)((Object)$this$priorityKey), (String)"<this>");
            return "priority_" + $this$priorityKey.getFeature();
        }

        /*
         * WARNING - void declaration
         */
        private final <T, R extends Extension<?>> void injectRequired(T $this$injectRequired, List<String> required, List<? extends R> extensions2, Function2<? super T, ? super List<? extends R>, Unit> set) {
            if (required.isEmpty()) {
                set.invoke($this$injectRequired, extensions2);
            } else {
                void $this$filterTo$iv$iv;
                Iterable $this$filter$iv = extensions2;
                boolean $i$f$filter2 = false;
                Iterable iterable = $this$filter$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$filterTo = false;
                for (Object element$iv$iv : $this$filterTo$iv$iv) {
                    Extension it = (Extension)element$iv$iv;
                    boolean bl = false;
                    if (!required.contains(it.getMetadata().getId())) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                List filtered = (List)destination$iv$iv;
                if (filtered.size() == required.size()) {
                    set.invoke($this$injectRequired, (Object)filtered);
                } else {
                    void $this$mapTo$iv$iv;
                    void $this$map$iv;
                    Iterable $i$f$filter2 = filtered;
                    Iterable iterable2 = required;
                    boolean $i$f$map = false;
                    destination$iv$iv = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                        void it;
                        Extension bl = (Extension)item$iv$iv;
                        Collection collection = destination$iv$iv2;
                        boolean bl2 = false;
                        collection.add(it.getMetadata().getId());
                    }
                    List missing = CollectionsKt.minus((Iterable)iterable2, (Iterable)CollectionsKt.toSet((Iterable)((List)destination$iv$iv2)));
                    throw new IllegalStateException("Required extensions missing: " + missing);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ExtensionType.values().length];
            try {
                nArray[ExtensionType.MUSIC.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.TRACKER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.LYRICS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.MISC.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

