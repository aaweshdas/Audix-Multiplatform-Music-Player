/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.channels.ProducerScope
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.SharingStarted
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  kotlinx.coroutines.flow.internal.CombineKt
 *  kotlinx.coroutines.sync.Semaphore
 *  kotlinx.coroutines.sync.SemaphoreKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.app.Application;
import android.content.Context;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.LoadingTask;
import dev.brahmkshatriya.echo.download.tasks.TaskManager$awaitCompletion$;
import dev.brahmkshatriya.echo.download.tasks.TaskManager$progressFlow$1$2$invokeSuspend$lambda$4$lambda$3$;
import dev.brahmkshatriya.echo.download.tasks.TaskManager$progressFlow$1$invokeSuspend$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u0003/01B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\fJ\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0002J\u000e\u0010+\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'J\u0006\u0010.\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R)\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 0\u001f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00062"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/TaskManager;", "", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "<init>", "(Ldev/brahmkshatriya/echo/download/Downloader;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "downloadFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "context", "Landroid/app/Application;", "taskFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager$TaskItem;", "getTaskFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "taskSemaphores", "", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "Lkotlinx/coroutines/sync/Semaphore;", "setConcurrency", "", "limit", "", "progressFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "getProgressFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "enqueue", "trackId", "", "items", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager$QueueItem;", "enqueueLoadingWork", "awaitCompletion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "removeAll", "TaskItem", "QueueItem", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nTaskManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskManager.kt\ndev/brahmkshatriya/echo/download/tasks/TaskManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,102:1\n1285#2,2:103\n1299#2,4:105\n1285#2,2:109\n1299#2,4:111\n774#2:120\n865#2,2:121\n1869#2,2:123\n1869#2,2:125\n49#3:115\n51#3:119\n46#4:116\n51#4:118\n105#5:117\n*S KotlinDebug\n*F\n+ 1 TaskManager.kt\ndev/brahmkshatriya/echo/download/tasks/TaskManager\n*L\n26#1:103,2\n26#1:105,4\n28#1:109,2\n28#1:111,4\n91#1:120\n91#1:121,2\n92#1:123,2\n98#1:125,2\n81#1:115\n81#1:119\n81#1:116\n81#1:118\n81#1:117\n*E\n"})
public final class TaskManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Downloader downloader;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Flow<List<DownloadEntity>> downloadFlow;
    @NotNull
    private final Application context;
    @NotNull
    private final MutableStateFlow<List<TaskItem>> taskFlow;
    @NotNull
    private Map<TaskType, ? extends Semaphore> taskSemaphores;
    @NotNull
    private final StateFlow<Pair<BaseTask, Progress>[]> progressFlow;

    /*
     * WARNING - void declaration
     */
    public TaskManager(@NotNull Downloader downloader) {
        void $this$associateWith\1;
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        this.downloader = downloader;
        this.scope = this.downloader.getScope();
        this.downloadFlow = this.downloader.getDownloadFlow();
        this.context = this.downloader.getApp().getContext();
        this.taskFlow = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        Iterable iterable = (Iterable)TaskType.getEntries();
        TaskManager taskManager = this;
        boolean bl = false;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith\1, (int)10)), (int)16));
        void $this$associateWithTo\2 = $this$associateWith\1;
        boolean bl2 = false;
        for (Object t : $this$associateWithTo\2) {
            TaskType taskType = (TaskType)((Object)t);
            Object t2 = t;
            Map map2 = linkedHashMap;
            boolean bl3 = false;
            Semaphore semaphore = SemaphoreKt.Semaphore$default((int)2, (int)0, (int)2, null);
            map2.put(t2, semaphore);
        }
        taskManager.taskSemaphores = linkedHashMap;
        this.progressFlow = FlowKt.stateIn((Flow)FlowKt.channelFlow((Function2)((Function2)new Function2<ProducerScope<? super Pair<? extends BaseTask, ? extends Progress>[]>, Continuation<? super Unit>, Object>(this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ TaskManager this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                ProducerScope producerScope = (ProducerScope)this.L$0;
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$channelFlow;
                        ResultKt.throwOnFailure((Object)$result);
                        Flow flow2 = (Flow)this.this$0.getTaskFlow();
                        boolean bl = false;
                        Flow flow3 = flow2;
                        boolean bl2 = false;
                        boolean bl3 = false;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$channelFlow);
                        this.label = 1;
                        Object object2 = FlowKt.collectLatest((Flow)((Flow)new Flow<List<? extends BaseTask>>(flow3){
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
                                     */
                                    public final Object emit(Object value, Continuation $completion) {
                                        if (!($completion instanceof progressFlow$1$invokeSuspend$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                                                final /* synthetic */ progressFlow$1$invokeSuspend$$inlined$map$1$2 this$0;
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
                                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                                var10_14 = $this$map_u24lambda_u245;
                                                var11_15 = (Continuation)$continuation;
                                                items\1 = (List)value;
                                                $i$a$-map-TaskManager$progressFlow$1$1\1\50\0 = false;
                                                $this$flatMap\2 = items\1;
                                                $i$f$flatMap\2\51 = false;
                                                var16_20 = $this$flatMap\2;
                                                destination\3 = new ArrayList<E>();
                                                $i$f$flatMapTo\3\52 = false;
                                                for (T element\3 : $this$flatMapTo\3) {
                                                    it\4 = (TaskItem)element\3;
                                                    $i$a$-flatMap-TaskManager$progressFlow$1$1$1\4\54\1 = false;
                                                    list\3 = it\4.getQueue();
                                                    CollectionsKt.addAll((Collection)destination\3, (Iterable)list\3);
                                                }
                                                $this$flatMap\2 = (List)destination\3;
                                                $i$f$flatMap\5\51 = false;
                                                $this$flatMapTo\3 = $this$flatMap\5;
                                                destination\6 = new ArrayList<E>();
                                                $i$f$flatMapTo\6\52 = false;
                                                for (T element\6 : $this$flatMapTo\6) {
                                                    it\7 = (QueueItem)element\6;
                                                    $i$a$-flatMap-TaskManager$progressFlow$1$1$2\7\54\1 = false;
                                                    list\6 = it\7.getTasks();
                                                    CollectionsKt.addAll((Collection)destination\6, (Iterable)list\6);
                                                }
                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                                $continuation.label = 1;
                                                v0 = var10_14.emit((Object)((List)destination\6), (Continuation)$continuation);
                                                if (v0 == var5_5) {
                                                    return var5_5;
                                                }
                                                ** GOTO lbl63
                                            }
                                            case 1: {
                                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                                value = $continuation.L$2;
                                                $completion = $continuation.L$1;
                                                value = $continuation.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v0 = $result;
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
                        }), (Function2)((Function2)new Function2<List<? extends BaseTask>, Continuation<? super Unit>, Object>((ProducerScope<? super Pair<BaseTask, Progress>[]>)$this$channelFlow, null){
                            int label;
                            /* synthetic */ Object L$0;
                            final /* synthetic */ ProducerScope<Pair<? extends BaseTask, Progress>[]> $$this$channelFlow;
                            {
                                this.$$this$channelFlow = $$this$channelFlow;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - void declaration
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public final Object invokeSuspend(Object $result) {
                                void $this$mapTo\2;
                                void tasks;
                                List list2 = (List)this.L$0;
                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        if (!tasks.isEmpty()) break;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tasks);
                                        this.label = 1;
                                        Object object2 = this.$$this$channelFlow.send((Object)new Pair[0], (Continuation)this);
                                        if (object2 != object) return Unit.INSTANCE;
                                        return object;
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object2 = $result;
                                        return Unit.INSTANCE;
                                    }
                                }
                                Iterable iterable = (Iterable)tasks;
                                boolean bl = false;
                                Iterable iterable2 = iterable;
                                Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                                boolean bl2 = false;
                                for (T t : $this$mapTo\2) {
                                    void it\3;
                                    BaseTask baseTask = (BaseTask)t;
                                    Collection collection2 = collection;
                                    boolean bl3 = false;
                                    collection2.add(it\3.getRunning());
                                }
                                Iterable iterable3 = (List)collection;
                                boolean bl4 = false;
                                Collection collection3 = CollectionsKt.toList((Iterable)iterable3);
                                boolean bl5 = false;
                                Collection collection4 = collection3;
                                Flow[] flowArray = collection4.toArray(new Flow[0]);
                                boolean bl6 = false;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tasks);
                                this.label = 2;
                                Object object3 = FlowKt.collectLatest((Flow)((Flow)new Flow<List<? extends Flow<? extends Pair<? extends BaseTask, ? extends Progress>>>>(flowArray, (List)tasks){
                                    final /* synthetic */ Flow[] $flowArray$inlined;
                                    final /* synthetic */ List $tasks$inlined;
                                    {
                                        this.$flowArray$inlined = flowArray;
                                        this.$tasks$inlined = list2;
                                    }

                                    public Object collect(FlowCollector collector, Continuation $completion) {
                                        Continuation continuation = $completion;
                                        FlowCollector $this$combine_u24lambda_u2411 = collector;
                                        boolean bl = false;
                                        Object object = CombineKt.combineInternal((FlowCollector)$this$combine_u24lambda_u2411, (Flow[])this.$flowArray$inlined, (Function0)((Function0)new Function0<Boolean[]>(this.$flowArray$inlined){
                                            final /* synthetic */ Flow[] $flowArray;
                                            {
                                                this.$flowArray = $flowArray;
                                            }

                                            public final Boolean[] invoke() {
                                                return new Boolean[this.$flowArray.length];
                                            }
                                        }), (Function3)((Function3)new Function3<FlowCollector<? super List<? extends Flow<? extends Pair<? extends BaseTask, ? extends Progress>>>>, Boolean[], Continuation<? super Unit>, Object>(null, this.$tasks$inlined){
                                            int label;
                                            private /* synthetic */ Object L$0;
                                            /* synthetic */ Object L$1;
                                            final /* synthetic */ List $tasks$inlined;
                                            {
                                                this.$tasks$inlined = list2;
                                                super(3, $completion);
                                            }

                                            /*
                                             * WARNING - void declaration
                                             * Enabled force condition propagation
                                             * Lifted jumps to return sites
                                             */
                                            public final Object invokeSuspend(Object $result) {
                                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0: {
                                                        void $this$mapTo\6;
                                                        void $this$map\5;
                                                        BaseTask baseTask;
                                                        void $this$filterTo\3;
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                                        Object[] it = (Object[])this.L$1;
                                                        FlowCollector flowCollector = $this$combineInternal;
                                                        Continuation continuation = (Continuation)this;
                                                        Boolean[] cfr_ignored_0 = (Boolean[])it;
                                                        boolean bl = false;
                                                        Iterable iterable = this.$tasks$inlined;
                                                        boolean bl2 = false;
                                                        Iterable iterable2 = iterable;
                                                        Collection collection = new ArrayList<E>();
                                                        boolean bl3 = false;
                                                        for (T t : $this$filterTo\3) {
                                                            baseTask = (BaseTask)t;
                                                            boolean bl4 = false;
                                                            if (!((Boolean)baseTask.getRunning().getValue()).booleanValue()) continue;
                                                            collection.add(t);
                                                        }
                                                        iterable = (List)collection;
                                                        boolean bl5 = false;
                                                        $this$filterTo\3 = $this$map\5;
                                                        Collection collection2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5, (int)10));
                                                        boolean bl6 = false;
                                                        for (T t : $this$mapTo\6) {
                                                            void task\7;
                                                            baseTask = (BaseTask)t;
                                                            Collection collection3 = collection2;
                                                            boolean bl7 = false;
                                                            Flow<Progress> flow2 = task\7.getThrottledProgressFlow();
                                                            boolean bl8 = false;
                                                            Flow<Progress> flow3 = flow2;
                                                            boolean bl9 = false;
                                                            boolean bl10 = false;
                                                            collection3.add((Flow)new Flow<Pair<? extends BaseTask, ? extends Progress>>(flow3, (BaseTask)task\7){
                                                                final /* synthetic */ Flow $this_unsafeTransform$inlined;
                                                                final /* synthetic */ BaseTask $task$inlined;
                                                                {
                                                                    this.$this_unsafeTransform$inlined = flow2;
                                                                    this.$task$inlined = baseTask;
                                                                }

                                                                public Object collect(FlowCollector collector, Continuation $completion) {
                                                                    Continuation continuation = $completion;
                                                                    FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                                                                    boolean bl = false;
                                                                    Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$task$inlined){
                                                                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                                                                        final /* synthetic */ BaseTask $task$inlined;
                                                                        {
                                                                            this.$this_unsafeFlow = $receiver;
                                                                            this.$task$inlined = baseTask;
                                                                        }

                                                                        /*
                                                                         * Unable to fully structure code
                                                                         */
                                                                        public final Object emit(Object value, Continuation $completion) {
                                                                            if (!($completion instanceof progressFlow$1$2$invokeSuspend$lambda$4$lambda$3$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                                                                                    final /* synthetic */ progressFlow$1$2$invokeSuspend$lambda$4$lambda$3$$inlined$map$1$2 this$0;
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
                                                                                    $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                                                                    var10_14 = $this$map_u24lambda_u245;
                                                                                    var11_15 = (Continuation)$continuation;
                                                                                    it\1 = (Progress)value;
                                                                                    $i$a$-map-TaskManager$progressFlow$1$2$2$2$1\1\50\0 = false;
                                                                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                                                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                                                                    $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                                                                    $continuation.label = 1;
                                                                                    v0 = var10_14.emit((Object)TuplesKt.to((Object)this.$task$inlined, (Object)it\1), (Continuation)$continuation);
                                                                                    if (v0 == var5_5) {
                                                                                        return var5_5;
                                                                                    }
                                                                                    ** GOTO lbl38
                                                                                }
                                                                                case 1: {
                                                                                    $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                                                                    $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                                                                    value = $continuation.L$2;
                                                                                    $completion = $continuation.L$1;
                                                                                    value = $continuation.L$0;
                                                                                    ResultKt.throwOnFailure((Object)$result);
                                                                                    v0 = $result;
lbl38:
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
                                                            });
                                                        }
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$combineInternal);
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)it);
                                                        this.label = 1;
                                                        Object object2 = flowCollector.emit((Object)((List)collection2), (Continuation)this);
                                                        if (object2 != object) return Unit.INSTANCE;
                                                        return object;
                                                    }
                                                    case 1: {
                                                        Object[] it = (Object[])this.L$1;
                                                        FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        Object object2 = $result;
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }

                                            /*
                                             * Ignored method signature, as it can't be verified against descriptor
                                             */
                                            public final Object invoke(FlowCollector p1, Object[] p2, Continuation p3) {
                                                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                                                var4_4.L$0 = p1;
                                                var4_4.L$1 = p2;
                                                return var4_4.invokeSuspend(Unit.INSTANCE);
                                            }
                                        }), (Continuation)$completion);
                                        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                            return object;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }), (Function2)((Function2)new Function2<List<? extends Flow<? extends Pair<? extends BaseTask, ? extends Progress>>>, Continuation<? super Unit>, Object>(this.$$this$channelFlow, null){
                                    int label;
                                    /* synthetic */ Object L$0;
                                    final /* synthetic */ ProducerScope<Pair<? extends BaseTask, Progress>[]> $$this$channelFlow;
                                    {
                                        this.$$this$channelFlow = $$this$channelFlow;
                                        super(2, $completion);
                                    }

                                    /*
                                     * WARNING - void declaration
                                     * Enabled force condition propagation
                                     * Lifted jumps to return sites
                                     */
                                    public final Object invokeSuspend(Object $result) {
                                        void progressFlows;
                                        List list2 = (List)this.L$0;
                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                if (!progressFlows.isEmpty()) break;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)progressFlows);
                                                this.label = 1;
                                                Object object2 = this.$$this$channelFlow.send((Object)new Pair[0], (Continuation)this);
                                                if (object2 != object) return Unit.INSTANCE;
                                                return object;
                                            }
                                            case 1: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                Object object2 = $result;
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        Iterable iterable = (Iterable)progressFlows;
                                        boolean bl = false;
                                        Collection collection = CollectionsKt.toList((Iterable)iterable);
                                        boolean bl2 = false;
                                        Collection collection2 = collection;
                                        Flow[] flowArray = collection2.toArray(new Flow[0]);
                                        boolean bl3 = false;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)progressFlows);
                                        this.label = 2;
                                        Object object3 = FlowKt.collectLatest((Flow)((Flow)new Flow<Pair<? extends BaseTask, ? extends Progress>[]>(flowArray){
                                            final /* synthetic */ Flow[] $flowArray$inlined;
                                            {
                                                this.$flowArray$inlined = flowArray;
                                            }

                                            public Object collect(FlowCollector collector, Continuation $completion) {
                                                Continuation continuation = $completion;
                                                FlowCollector $this$combine_u24lambda_u2411 = collector;
                                                boolean bl = false;
                                                Object object = CombineKt.combineInternal((FlowCollector)$this$combine_u24lambda_u2411, (Flow[])this.$flowArray$inlined, (Function0)((Function0)new Function0<Pair<? extends BaseTask, ? extends Progress>[]>(this.$flowArray$inlined){
                                                    final /* synthetic */ Flow[] $flowArray;
                                                    {
                                                        this.$flowArray = $flowArray;
                                                    }

                                                    public final Pair<? extends BaseTask, ? extends Progress>[] invoke() {
                                                        return new Pair[this.$flowArray.length];
                                                    }
                                                }), (Function3)((Function3)new Function3<FlowCollector<? super Pair<? extends BaseTask, ? extends Progress>[]>, Pair<? extends BaseTask, ? extends Progress>[], Continuation<? super Unit>, Object>(null){
                                                    int label;
                                                    private /* synthetic */ Object L$0;
                                                    /* synthetic */ Object L$1;

                                                    /*
                                                     * Enabled force condition propagation
                                                     * Lifted jumps to return sites
                                                     */
                                                    public final Object invokeSuspend(Object $result) {
                                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0: {
                                                                ResultKt.throwOnFailure((Object)$result);
                                                                FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                                                Object[] it = (Object[])this.L$1;
                                                                FlowCollector flowCollector = $this$combineInternal;
                                                                Continuation continuation = (Continuation)this;
                                                                Pair[] pairArray = (Pair[])it;
                                                                boolean bl = false;
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$combineInternal);
                                                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)it);
                                                                this.label = 1;
                                                                Object object2 = flowCollector.emit((Object)pairArray, (Continuation)this);
                                                                if (object2 != object) return Unit.INSTANCE;
                                                                return object;
                                                            }
                                                            case 1: {
                                                                Object[] it = (Object[])this.L$1;
                                                                FlowCollector $this$combineInternal = (FlowCollector)this.L$0;
                                                                ResultKt.throwOnFailure((Object)$result);
                                                                Object object2 = $result;
                                                                return Unit.INSTANCE;
                                                            }
                                                        }
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }

                                                    /*
                                                     * Ignored method signature, as it can't be verified against descriptor
                                                     */
                                                    public final Object invoke(FlowCollector p1, Object[] p2, Continuation p3) {
                                                        var var4_4 = new /* invalid duplicate definition of identical inner class */;
                                                        var4_4.L$0 = p1;
                                                        var4_4.L$1 = p2;
                                                        return var4_4.invokeSuspend(Unit.INSTANCE);
                                                    }
                                                }), (Continuation)$completion);
                                                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                    return object;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }), (Function2)((Function2)new Function2<Pair<? extends BaseTask, ? extends Progress>[], Continuation<? super Unit>, Object>(this.$$this$channelFlow, null){
                                            int label;
                                            /* synthetic */ Object L$0;
                                            final /* synthetic */ ProducerScope<Pair<? extends BaseTask, Progress>[]> $$this$channelFlow;
                                            {
                                                this.$$this$channelFlow = $$this$channelFlow;
                                                super(2, $completion);
                                            }

                                            /*
                                             * WARNING - void declaration
                                             * Enabled force condition propagation
                                             * Lifted jumps to return sites
                                             */
                                            public final Object invokeSuspend(Object $result) {
                                                Pair[] pairArray = (Pair[])this.L$0;
                                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0: {
                                                        void it;
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)it);
                                                        this.label = 1;
                                                        Object object2 = this.$$this$channelFlow.send((Object)it, (Continuation)this);
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

                                            public final Object invoke(Pair<BaseTask, Progress>[] p1, Continuation<? super Unit> p2) {
                                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }), (Continuation)((Continuation)this));
                                        if (object3 != object) return Unit.INSTANCE;
                                        return object;
                                        {
                                            case 2: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                object3 = $result;
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

                                    public final Object invoke(List<? extends Flow<? extends Pair<? extends BaseTask, Progress>>> p1, Continuation<? super Unit> p2) {
                                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }), (Continuation)((Continuation)this));
                                if (object3 != object) return Unit.INSTANCE;
                                return object;
                                {
                                    case 2: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        object3 = $result;
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

                            public final Object invoke(List<? extends BaseTask> p1, Continuation<? super Unit> p2) {
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
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(ProducerScope<? super Pair<BaseTask, Progress>[]> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        })), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getEagerly(), (Object)new Pair[0]);
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public final MutableStateFlow<List<TaskItem>> getTaskFlow() {
        return this.taskFlow;
    }

    /*
     * WARNING - void declaration
     */
    public final void setConcurrency(int limit) {
        void $this$associateWith\1;
        Iterable iterable = (Iterable)TaskType.getEntries();
        TaskManager taskManager = this;
        boolean bl = false;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith\1, (int)10)), (int)16));
        void $this$associateWithTo\2 = $this$associateWith\1;
        boolean bl2 = false;
        for (Object t : $this$associateWithTo\2) {
            TaskType taskType = (TaskType)((Object)t);
            Object t2 = t;
            Map map2 = linkedHashMap;
            boolean bl3 = false;
            Semaphore semaphore = SemaphoreKt.Semaphore$default((int)limit, (int)0, (int)2, null);
            map2.put(t2, semaphore);
        }
        taskManager.taskSemaphores = linkedHashMap;
    }

    @NotNull
    public final StateFlow<Pair<BaseTask, Progress>[]> getProgressFlow() {
        return this.progressFlow;
    }

    public final void enqueue(long trackId, @NotNull List<QueueItem> items2) {
        Intrinsics.checkNotNullParameter(items2, (String)"items");
        List list2 = CollectionsKt.toMutableList((Collection)((Collection)this.taskFlow.getValue()));
        list2.add(new TaskItem(trackId, items2, BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, items2, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ TaskManager this$0;
            final /* synthetic */ List<QueueItem> $items;
            {
                this.this$0 = $receiver;
                this.$items = $items;
                super(2, $completion);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object $result) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 7[WHILELOOP]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:139)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.StaticFunctionInvokation.dumpInner(StaticFunctionInvokation.java:143)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationSimple.dumpInner(ConstructorInvokationSimple.java:88)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.bytecode.analysis.types.MethodPrototype.dumpAppropriatelyCastedArgumentString(MethodPrototype.java:562)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.MemberFunctionInvokation.dumpInner(MemberFunctionInvokation.java:63)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredExpressionStatement.dump(StructuredExpressionStatement.java:29)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }

            private static final boolean invokeSuspend$lambda$4(List $items, TaskItem it) {
                return Intrinsics.areEqual(it.getQueue(), (Object)$items);
            }
        }), (int)3, null)));
        this.taskFlow.setValue((Object)list2);
    }

    private final void enqueueLoadingWork(long trackId) {
        LoadingTask loadingWorker = new LoadingTask((Context)this.context, this.downloader, trackId);
        this.enqueue(trackId, CollectionsKt.listOf((Object)new QueueItem(CollectionsKt.listOf((Object)loadingWorker))));
    }

    @Nullable
    public final Object awaitCompletion(@NotNull Continuation<? super Unit> $completion) {
        Flow<List<DownloadEntity>> flow2 = this.downloadFlow;
        boolean bl = false;
        Flow<List<DownloadEntity>> flow3 = flow2;
        boolean bl2 = false;
        boolean bl3 = false;
        Object object = FlowKt.first((Flow)((Flow)new Flow<List<? extends DownloadEntity>>(flow3){
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
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof awaitCompletion$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                                final /* synthetic */ awaitCompletion$$inlined$map$1$2 this$0;
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
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                entities\1 = (List)value;
                                $i$a$-map-TaskManager$awaitCompletion$2\1\50\0 = false;
                                $this$filter\2 = entities\1;
                                $i$f$filter\2\51 = false;
                                var16_20 = $this$filter\2;
                                destination\3 = new ArrayList<E>();
                                $i$f$filterTo\3\52 = false;
                                for (T element\3 : $this$filterTo\3) {
                                    it\4 = (DownloadEntity)element\3;
                                    $i$a$-filter-TaskManager$awaitCompletion$2$1\4\53\1 = false;
                                    if (!(it\4.isFinal() == false)) continue;
                                    destination\3.add(element\3);
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                $continuation.label = 1;
                                v0 = var10_14.emit((Object)((List)destination\3), (Continuation)$continuation);
                                if (v0 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl50
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl50:
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
        }), (Function2)((Function2)new Function2<List<? extends DownloadEntity>, Continuation<? super Boolean>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ TaskManager this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$forEach\7;
                        void $this$filterTo\5;
                        void entities;
                        void $this$mapTo\2;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable iterable = (Iterable)this.this$0.getTaskFlow().getValue();
                        boolean bl = false;
                        Iterable iterable2 = iterable;
                        Iterable<E> iterable3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                        boolean bl2 = false;
                        for (Object object : $this$mapTo\2) {
                            void it\3;
                            TaskItem taskItem = (TaskItem)object;
                            Collection collection = iterable3;
                            boolean bl3 = false;
                            collection.add(Boxing.boxLong((long)it\3.getTrackId()));
                        }
                        List works = (List)iterable3;
                        Iterable iterable4 = (Iterable)entities;
                        boolean bl4 = false;
                        iterable3 = iterable4;
                        Collection collection = new ArrayList<E>();
                        boolean bl5 = false;
                        for (E e : $this$filterTo\5) {
                            DownloadEntity downloadEntity = (DownloadEntity)e;
                            boolean bl6 = false;
                            if (!(!works.contains(Boxing.boxLong((long)downloadEntity.getId())))) continue;
                            collection.add(e);
                        }
                        List notStarted = (List)collection;
                        iterable4 = notStarted;
                        TaskManager taskManager = this.this$0;
                        boolean bl7 = false;
                        for (T t : $this$forEach\7) {
                            DownloadEntity downloadEntity = (DownloadEntity)t;
                            boolean bl8 = false;
                            TaskManager.access$enqueueLoadingWork(taskManager, downloadEntity.getId());
                        }
                        return Boxing.boxBoolean((boolean)entities.isEmpty());
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(List<DownloadEntity> p1, Continuation<? super Boolean> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    public final void remove(long trackId) {
        void $this$filterTo\2;
        List list2 = CollectionsKt.toMutableList((Collection)((Collection)this.taskFlow.getValue()));
        Iterable iterable = list2;
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList();
        boolean bl2 = false;
        for (Object t : $this$filterTo\2) {
            TaskItem taskItem = (TaskItem)t;
            boolean bl3 = false;
            if (!(taskItem.getTrackId() == trackId)) continue;
            collection.add(t);
        }
        List works = (List)collection;
        Iterable iterable3 = works;
        boolean bl4 = false;
        for (Object e : iterable3) {
            TaskItem taskItem = (TaskItem)e;
            boolean bl5 = false;
            Job.DefaultImpls.cancel$default((Job)taskItem.getJob(), null, (int)1, null);
        }
        list2.removeAll(works);
        this.taskFlow.setValue((Object)list2);
    }

    public final void removeAll() {
        Iterable iterable = (Iterable)this.taskFlow.getValue();
        boolean bl = false;
        for (Object t : iterable) {
            TaskItem taskItem = (TaskItem)t;
            boolean bl2 = false;
            Job.DefaultImpls.cancel$default((Job)taskItem.getJob(), null, (int)1, null);
        }
        this.taskFlow.setValue((Object)CollectionsKt.emptyList());
    }

    public static final /* synthetic */ Map access$getTaskSemaphores$p(TaskManager $this) {
        return $this.taskSemaphores;
    }

    public static final /* synthetic */ void access$enqueueLoadingWork(TaskManager $this, long trackId) {
        $this.enqueueLoadingWork(trackId);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0010\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/TaskManager$Companion;", "", "<init>", "()V", "toQueueItem", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager$QueueItem;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final QueueItem toQueueItem(@NotNull BaseTask $this$toQueueItem) {
            Intrinsics.checkNotNullParameter((Object)$this$toQueueItem, (String)"<this>");
            return new QueueItem(CollectionsKt.listOf((Object)$this$toQueueItem));
        }

        @NotNull
        public final QueueItem toQueueItem(@NotNull List<? extends BaseTask> $this$toQueueItem) {
            Intrinsics.checkNotNullParameter($this$toQueueItem, (String)"<this>");
            return new QueueItem($this$toQueueItem);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/TaskManager$QueueItem;", "", "tasks", "", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "<init>", "(Ljava/util/List;)V", "getTasks", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class QueueItem {
        @NotNull
        private final List<BaseTask> tasks;

        public QueueItem(@NotNull List<? extends BaseTask> tasks) {
            Intrinsics.checkNotNullParameter(tasks, (String)"tasks");
            this.tasks = tasks;
        }

        @NotNull
        public final List<BaseTask> getTasks() {
            return this.tasks;
        }

        @NotNull
        public final List<BaseTask> component1() {
            return this.tasks;
        }

        @NotNull
        public final QueueItem copy(@NotNull List<? extends BaseTask> tasks) {
            Intrinsics.checkNotNullParameter(tasks, (String)"tasks");
            return new QueueItem(tasks);
        }

        public static /* synthetic */ QueueItem copy$default(QueueItem queueItem, List list2, int n, Object object) {
            if ((n & 1) != 0) {
                list2 = queueItem.tasks;
            }
            return queueItem.copy(list2);
        }

        @NotNull
        public String toString() {
            return "QueueItem(tasks=" + this.tasks + ")";
        }

        public int hashCode() {
            return ((Object)this.tasks).hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QueueItem)) {
                return false;
            }
            QueueItem queueItem = (QueueItem)other;
            return Intrinsics.areEqual(this.tasks, queueItem.tasks);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\bH\u00c6\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/TaskManager$TaskItem;", "", "trackId", "", "queue", "", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager$QueueItem;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(JLjava/util/List;Lkotlinx/coroutines/Job;)V", "getTrackId", "()J", "getQueue", "()Ljava/util/List;", "getJob", "()Lkotlinx/coroutines/Job;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class TaskItem {
        private final long trackId;
        @NotNull
        private final List<QueueItem> queue;
        @NotNull
        private final Job job;

        public TaskItem(long trackId, @NotNull List<QueueItem> queue, @NotNull Job job2) {
            Intrinsics.checkNotNullParameter(queue, (String)"queue");
            Intrinsics.checkNotNullParameter((Object)job2, (String)"job");
            this.trackId = trackId;
            this.queue = queue;
            this.job = job2;
        }

        public final long getTrackId() {
            return this.trackId;
        }

        @NotNull
        public final List<QueueItem> getQueue() {
            return this.queue;
        }

        @NotNull
        public final Job getJob() {
            return this.job;
        }

        public final long component1() {
            return this.trackId;
        }

        @NotNull
        public final List<QueueItem> component2() {
            return this.queue;
        }

        @NotNull
        public final Job component3() {
            return this.job;
        }

        @NotNull
        public final TaskItem copy(long trackId, @NotNull List<QueueItem> queue, @NotNull Job job2) {
            Intrinsics.checkNotNullParameter(queue, (String)"queue");
            Intrinsics.checkNotNullParameter((Object)job2, (String)"job");
            return new TaskItem(trackId, queue, job2);
        }

        public static /* synthetic */ TaskItem copy$default(TaskItem taskItem, long l, List list2, Job job2, int n, Object object) {
            if ((n & 1) != 0) {
                l = taskItem.trackId;
            }
            if ((n & 2) != 0) {
                list2 = taskItem.queue;
            }
            if ((n & 4) != 0) {
                job2 = taskItem.job;
            }
            return taskItem.copy(l, list2, job2);
        }

        @NotNull
        public String toString() {
            return "TaskItem(trackId=" + this.trackId + ", queue=" + this.queue + ", job=" + this.job + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.trackId);
            result2 = result2 * 31 + ((Object)this.queue).hashCode();
            result2 = result2 * 31 + this.job.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskItem)) {
                return false;
            }
            TaskItem taskItem = (TaskItem)other;
            if (this.trackId != taskItem.trackId) {
                return false;
            }
            if (!Intrinsics.areEqual(this.queue, taskItem.queue)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.job, (Object)taskItem.job);
        }
    }
}

