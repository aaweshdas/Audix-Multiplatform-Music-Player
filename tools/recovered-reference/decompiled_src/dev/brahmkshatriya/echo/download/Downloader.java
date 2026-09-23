/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Constraints
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.NetworkType
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.OneTimeWorkRequest$Builder
 *  androidx.work.WorkManager
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
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
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineName
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.SharingStarted
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.sync.Mutex
 *  kotlinx.coroutines.sync.MutexKt
 *  kotlinx.serialization.SerializationStrategy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.di.App;
import dev.brahmkshatriya.echo.download.DownloadWorker;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.Downloader$1$invokeSuspend$;
import dev.brahmkshatriya.echo.download.db.DownloadDao;
import dev.brahmkshatriya.echo.download.db.DownloadDatabase;
import dev.brahmkshatriya.echo.download.db.models.ContextEntity;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.exceptions.DownloaderExtensionNotFoundException;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.TaskManager;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 P2\u00020\u0001:\u0002OPB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0014\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001fJ\b\u00105\u001a\u000206H\u0002J\u001e\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010CJ\u000e\u0010D\u001a\u0002062\u0006\u0010A\u001a\u000209J\u000e\u0010E\u001a\u0002062\u0006\u0010A\u001a\u000209J\u0006\u0010F\u001a\u000206J\u000e\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020IJ\u000e\u0010J\u001a\u0002062\u0006\u0010H\u001a\u00020IR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u001f0\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R \u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:08X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b;\u0010<R \u0010=\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020>08X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b?\u0010<R\u001d\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u001f0L\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010N\u00a8\u0006Q"}, d2={"Ldev/brahmkshatriya/echo/download/Downloader;", "", "app", "Ldev/brahmkshatriya/echo/di/App;", "extensionLoader", "Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "database", "Ldev/brahmkshatriya/echo/download/db/DownloadDatabase;", "<init>", "(Ldev/brahmkshatriya/echo/di/App;Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;Ldev/brahmkshatriya/echo/download/db/DownloadDatabase;)V", "getApp", "()Ldev/brahmkshatriya/echo/di/App;", "getExtensionLoader", "()Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "unified", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension;", "getUnified", "()Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension;", "downloadExtension", "Ldev/brahmkshatriya/echo/common/MiscExtension;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "dao", "Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "getDao", "()Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "downloadFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "getDownloadFlow", "()Lkotlinx/coroutines/flow/Flow;", "contextFlow", "Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "downloadInfoFlow", "Ldev/brahmkshatriya/echo/download/Downloader$Info;", "taskManager", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager;", "getTaskManager", "()Ldev/brahmkshatriya/echo/download/tasks/TaskManager;", "add", "Lkotlinx/coroutines/Job;", "downloads", "Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "workManager", "Landroidx/work/WorkManager;", "getWorkManager", "()Landroidx/work/WorkManager;", "workManager$delegate", "Lkotlin/Lazy;", "ensureWorker", "", "servers", "Ljava/util/WeakHashMap;", "", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "getServers$annotations", "()V", "mutexes", "Lkotlinx/coroutines/sync/Mutex;", "getMutexes$annotations", "getServer", "trackId", "download", "(JLdev/brahmkshatriya/echo/download/db/models/DownloadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "restart", "cancelAll", "deleteDownload", "id", "", "deleteContext", "flow", "Lkotlinx/coroutines/flow/StateFlow;", "getFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Info", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nDownloader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Downloader.kt\ndev/brahmkshatriya/echo/download/Downloader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n+ 4 OneTimeWorkRequest.kt\nandroidx/work/OneTimeWorkRequestKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,227:1\n1#2:228\n74#3:229\n33#3,5:249\n105#4:230\n382#5,7:231\n382#5,3:246\n385#5,4:254\n116#6,8:238\n125#6,2:258\n*S KotlinDebug\n*F\n+ 1 Downloader.kt\ndev/brahmkshatriya/echo/download/Downloader\n*L\n50#1:229\n115#1:249,5\n95#1:230\n109#1:231,7\n110#1:246,3\n110#1:254,4\n109#1:238,8\n109#1:258,2\n*E\n"})
public final class Downloader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final App app;
    @NotNull
    private final ExtensionLoader extensionLoader;
    @NotNull
    private final UnifiedExtension unified;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final DownloadDao dao;
    @NotNull
    private final Flow<List<DownloadEntity>> downloadFlow;
    @NotNull
    private final Flow<List<ContextEntity>> contextFlow;
    @NotNull
    private final Flow<List<Info>> downloadInfoFlow;
    @NotNull
    private final TaskManager taskManager;
    @NotNull
    private final Lazy workManager$delegate;
    @NotNull
    private final WeakHashMap<Long, Streamable.Media.Server> servers;
    @NotNull
    private final WeakHashMap<Long, Mutex> mutexes;
    @NotNull
    private final StateFlow<List<Info>> flow;
    @NotNull
    private static final String TAG = "Downloader";

    public Downloader(@NotNull App app, @NotNull ExtensionLoader extensionLoader, @NotNull DownloadDatabase database) {
        Intrinsics.checkNotNullParameter((Object)app, (String)"app");
        Intrinsics.checkNotNullParameter((Object)extensionLoader, (String)"extensionLoader");
        Intrinsics.checkNotNullParameter((Object)((Object)database), (String)"database");
        this.app = app;
        this.extensionLoader = extensionLoader;
        this.unified = (UnifiedExtension)this.extensionLoader.getUnified().getValue();
        this.scope = CoroutineScopeKt.plus((CoroutineScope)CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getIO())), (CoroutineContext)((CoroutineContext)new CoroutineName(TAG)));
        this.dao = database.downloadDao();
        this.downloadFlow = this.dao.getDownloadsFlow();
        this.contextFlow = this.dao.getContextFlow();
        this.downloadInfoFlow = FlowKt.flowCombine(this.downloadFlow, this.contextFlow, (Function3)((Function3)new Function3<List<? extends DownloadEntity>, List<? extends ContextEntity>, Continuation<? super List<? extends Info>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (List)this.L$0;
                var3_3 = (List)this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        $this$map\1 = (Iterable)downloads;
                        $i$f$map\1\59 = false;
                        var6_6 = $this$map\1;
                        destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                        $i$f$mapTo\2\228 = false;
                        for (T item\2 : $this$mapTo\2) {
                            var11_11 = (DownloadEntity)item\2;
                            var21_20 = destination\2;
                            $i$a$-map-Downloader$downloadInfoFlow$1$1\3\230\0 = false;
                            var13_13 = (Iterable)contexts;
                            for (T var15_15 : var13_13) {
                                it\4 = (ContextEntity)var15_15;
                                $i$a$-find-Downloader$downloadInfoFlow$1$1$context$1\4\60\3 = false;
                                v0 = download\3.getContextId();
                                var18_18 = it\4.getId();
                                if (!(v0 != null && v0 == var18_18)) continue;
                                v1 = var15_15;
                                ** GOTO lbl27
                            }
                            v1 = null;
lbl27:
                            // 2 sources

                            context\3 = v1;
                            var21_20.add(new Info((DownloadEntity)download\3, context\3, CollectionsKt.emptyList()));
                        }
                        return (List)destination\2;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<DownloadEntity> p1, List<ContextEntity> p2, Continuation<? super List<Info>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                var4_4.L$1 = p2;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }
        }));
        this.taskManager = new TaskManager(this);
        this.workManager$delegate = LazyKt.lazy(() -> Downloader.workManager_delegate$lambda$1(this));
        this.servers = new WeakHashMap();
        this.mutexes = new WeakHashMap();
        this.flow = FlowKt.stateIn((Flow)FlowKt.flowCombine(this.downloadInfoFlow, (Flow)((Flow)this.taskManager.getProgressFlow()), (Function3)((Function3)new Function3<List<? extends Info>, Pair<? extends BaseTask, ? extends Progress>[], Continuation<? super List<? extends Info>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                Pair[] pairArray = (Pair[])this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$sortedByDescending\10;
                        void $this$mapTo\2;
                        void downloads;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable iterable = (Iterable)downloads;
                        boolean bl = false;
                        Iterable iterable2 = iterable;
                        Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                        boolean bl2 = false;
                        for (T t : $this$mapTo\2) {
                            void $this$mapTo\8;
                            void $this$map\7;
                            void $this$filterTo\5;
                            void info;
                            Info info2 = (Info)t;
                            Collection collection2 = collection;
                            boolean bl3 = false;
                            DownloadEntity downloadEntity = info2.component1();
                            ContextEntity contextEntity = info2.component2();
                            Iterable iterable3 = info;
                            boolean bl4 = false;
                            void var17_17 = iterable3;
                            Collection collection3 = new ArrayList<E>();
                            boolean bl5 = false;
                            int n = ((void)$this$filterTo\5).length;
                            for (int i = 0; i < n; ++i) {
                                void element\5;
                                void it\6 = element\5 = $this$filterTo\5[i];
                                boolean bl6 = false;
                                if (!(((BaseTask)it\6.getFirst()).getTrackId() == downloadEntity.getId())) continue;
                                collection3.add(element\5);
                            }
                            iterable3 = (List)collection3;
                            boolean bl7 = false;
                            $this$filterTo\5 = $this$map\7;
                            Collection collection4 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
                            boolean bl8 = false;
                            for (T t2 : $this$mapTo\8) {
                                Pair pair = (Pair)t2;
                                Collection collection5 = collection4;
                                boolean bl9 = false;
                                BaseTask baseTask = (BaseTask)pair.component1();
                                Progress progress = (Progress)pair.component2();
                                collection5.add(TuplesKt.to((Object)((Object)baseTask.getType()), (Object)progress));
                            }
                            List list3 = (List)collection4;
                            collection2.add(new Info(downloadEntity, contextEntity, list3));
                        }
                        iterable = (List)collection;
                        boolean bl10 = false;
                        return CollectionsKt.sortedWith((Iterable)$this$sortedByDescending\10, (Comparator)new Comparator(){

                            /*
                             * WARNING - void declaration
                             */
                            public final int compare(T a, T b) {
                                void it\2;
                                Info info = (Info)b;
                                boolean bl = false;
                                Comparable comparable = Integer.valueOf(info.getWorkers().size());
                                info = (Info)a;
                                Comparable comparable2 = comparable;
                                boolean bl2 = false;
                                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(it\2.getWorkers().size()));
                            }
                        });
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<Info> p1, Pair<BaseTask, Progress>[] p2, Continuation<? super List<Info>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                var4_4.L$1 = p2;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }
        })), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getEagerly(), (Object)CollectionsKt.emptyList());
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ Downloader this$0;
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
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$map\1;
                        ResultKt.throwOnFailure((Object)$result);
                        Flow flow2 = this.this$0.downloadInfoFlow;
                        Downloader downloader = this.this$0;
                        boolean bl = false;
                        void $this$unsafeTransform\2 = $this$map\1;
                        boolean bl2 = false;
                        boolean bl3 = false;
                        this.label = 1;
                        Object object2 = ((Flow)new Flow<List<? extends EchoMediaItem>>((Flow)$this$unsafeTransform\2, downloader){
                            final /* synthetic */ Flow $this_unsafeTransform$inlined;
                            final /* synthetic */ Downloader this$0;
                            {
                                this.$this_unsafeTransform$inlined = flow2;
                                this.this$0 = downloader;
                            }

                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Continuation continuation = $completion;
                                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                                boolean bl = false;
                                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.this$0){
                                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                                    final /* synthetic */ Downloader this$0;
                                    {
                                        this.$this_unsafeFlow = $receiver;
                                        this.this$0 = downloader;
                                    }

                                    /*
                                     * Unable to fully structure code
                                     * Could not resolve type clashes
                                     */
                                    public final Object emit(Object value, Continuation $completion) {
                                        if (!($completion instanceof 1$invokeSuspend$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                                                final /* synthetic */ 1$invokeSuspend$$inlined$map$1$2 this$0;
                                                Object L$1;
                                                Object L$2;
                                                Object L$3;
                                                Object L$4;
                                                Object L$5;
                                                Object L$6;
                                                Object L$7;
                                                Object L$8;
                                                Object L$9;
                                                Object L$10;
                                                Object L$11;
                                                Object L$12;
                                                Object L$13;
                                                Object L$14;
                                                int I$0;
                                                int I$1;
                                                int I$2;
                                                int I$3;
                                                int I$4;
                                                int I$5;
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
                                                info\1 = (List)value;
                                                $i$a$-map-Downloader$1$1\1\50\0 = 0;
                                                $this$filter\2 = info\1;
                                                $i$f$filter\2\51 = false;
                                                var16_20 = $this$filter\2;
                                                destination\3 = new ArrayList<E>();
                                                $i$f$filterTo\3\52 = false;
                                                for (E element\3 : $this$filterTo\3) {
                                                    it\4 = (Info)element\3;
                                                    $i$a$-filter-Downloader$1$1$1\4\53\1 = false;
                                                    if (!it\4.getDownload().getFullyDownloaded()) continue;
                                                    destination\3.add(element\3);
                                                }
                                                $this$filter\2 = (List)destination\3;
                                                $i$f$groupBy\5\51 = false;
                                                $this$filterTo\3 = $this$groupBy\5;
                                                destination\6 = new LinkedHashMap<K, V>();
                                                $i$f$groupByTo\6\55 = false;
                                                var19_23 = $this$groupByTo\6.iterator();
                                                while (var19_23.hasNext()) {
                                                    element\6 = var19_23.next();
                                                    it\7 = (Info)element\6;
                                                    $i$a$-groupBy-Downloader$1$1$2\7\57\1 = false;
                                                    v0 = it\7.getContext();
                                                    key\6 = v0 != null ? Boxing.boxLong((long)v0.getId()) : null;
                                                    $this$getOrPut\8 = destination\6;
                                                    $i$f$getOrPut\8\59 = false;
                                                    value\8 = $this$getOrPut\8.get(key\6);
                                                    if (value\8 == null) {
                                                        $i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1\9\62\6 = false;
                                                        answer\8 = new ArrayList<E>();
                                                        $this$getOrPut\8.put(key\6, answer\8);
                                                        v1 /* !! */  = answer\8;
                                                    } else {
                                                        v1 /* !! */  = value\8;
                                                    }
                                                    list\6 = (List)v1 /* !! */ ;
                                                    list\6.add(element\6);
                                                }
                                                $this$groupBy\5 = destination\6;
                                                $i$f$flatMap\10\70 = 0;
                                                $this$groupByTo\6 = $this$flatMap\10;
                                                destination\11 = new ArrayList<E>();
                                                $i$f$flatMapTo\11\71 = 0;
                                                var19_23 = $this$flatMapTo\11.entrySet().iterator();
lbl68:
                                                // 2 sources

                                                while (var19_23.hasNext()) {
                                                    element\11 = (Map.Entry)var19_23.next();
                                                    list\6 = element\11;
                                                    $i$a$-flatMap-Downloader$1$1$3\12\73\1 = 0;
                                                    id\12 = (Long)list\6.getKey();
                                                    infos\12 = (List)list\6.getValue();
                                                    if (id\12 != null) ** GOTO lbl99
                                                    $this$mapNotNull\13 = infos\12;
                                                    $i$f$mapNotNull\13\74 = false;
                                                    answer\8 = $this$mapNotNull\13;
                                                    destination\14 = new ArrayList<E>();
                                                    $i$f$mapNotNullTo\14\75 = false;
                                                    $this$forEach\15 = $this$mapNotNullTo\14;
                                                    $i$f$forEach\15\83 = false;
                                                    var32_43 = $this$forEach\15.iterator();
                                                    while (var32_43.hasNext()) {
                                                        element\16 = element\15 = var32_43.next();
                                                        $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\16\84\14 = false;
                                                        it\17 = (Info)element\16;
                                                        $i$a$-mapNotNull-Downloader$1$1$3$1\17\83\12 = false;
                                                        var38_49 = it\17.getDownload().getTrack-d1pmJ48();
                                                        var39_50 = (Track)(Result.isFailure-impl((Object)var38_49) != false ? null : var38_49);
                                                        if ((var39_50 != null ? UnifiedExtension.Companion.withExtensionId$default(UnifiedExtension.Companion, var39_50, it\17.getDownload().getExtensionId(), Boxing.boxBoolean((boolean)false), false, 4, null) : null) == null) continue;
                                                        it\16 = it\16;
                                                        $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\18\87\16 = false;
                                                        destination\14.add(it\16);
                                                    }
                                                    v2 = (List)destination\14;
                                                    ** GOTO lbl172
lbl99:
                                                    // 1 sources

                                                    var25_30 = CollectionsKt.first((List)infos\12);
                                                    $this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243\19 = (Info)var25_30;
                                                    $i$a$-runCatching-Downloader$1$1$3$2\19\90\12 = 0;
                                                    v3 = this.this$0.getUnified().getDb();
                                                    v4 = $this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243\19.getContext();
                                                    v5 /* !! */  = v4 != null ? Result.box-impl((Object)v4.getMediaItem-d1pmJ48()) : null;
                                                    Intrinsics.checkNotNull((Object)v5 /* !! */ );
                                                    var28_39 = v5 /* !! */ .unbox-impl();
                                                    ResultKt.throwOnFailure((Object)var28_39);
                                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                                    $continuation.L$4 = var10_14;
                                                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)info\1);
                                                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMap\10);
                                                    $continuation.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMapTo\11);
                                                    $continuation.L$9 = destination\11;
                                                    $continuation.L$10 = var19_23;
                                                    $continuation.L$11 = SpillingKt.nullOutSpilledVariable((Object)element\11);
                                                    $continuation.L$12 = SpillingKt.nullOutSpilledVariable((Object)id\12);
                                                    $continuation.L$13 = SpillingKt.nullOutSpilledVariable((Object)infos\12);
                                                    $continuation.L$14 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243\19);
                                                    $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                                    $continuation.I$1 = $i$a$-map-Downloader$1$1\1\50\0;
                                                    $continuation.I$2 = $i$f$flatMap\10\70;
                                                    $continuation.I$3 = $i$f$flatMapTo\11\71;
                                                    $continuation.I$4 = $i$a$-flatMap-Downloader$1$1$3\12\73\1;
                                                    $continuation.I$5 = $i$a$-runCatching-Downloader$1$1$3$2\19\90\12;
                                                    $continuation.label = 1;
                                                    v6 = v3.getPlaylist((EchoMediaItem)var28_39, (Continuation<? super Playlist>)$continuation);
                                                    ** if (v6 != var5_5) goto lbl136
lbl135:
                                                    // 1 sources

                                                    return var5_5;
lbl136:
                                                    // 1 sources

                                                    ** GOTO lbl164
                                                }
                                                break;
                                            }
                                            case 1: {
                                                $i$a$-runCatching-Downloader$1$1$3$2\19\90\12 = $continuation.I$5;
                                                $i$a$-flatMap-Downloader$1$1$3\12\73\1 = $continuation.I$4;
                                                $i$f$flatMapTo\11\71 = $continuation.I$3;
                                                $i$f$flatMap\10\70 = $continuation.I$2;
                                                $i$a$-map-Downloader$1$1\1\50\0 = $continuation.I$1;
                                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                                $this$invokeSuspend_u24lambda_u245_u24lambda_u244_u24lambda_u243\19 = (Info)$continuation.L$14;
                                                infos\12 = (List)$continuation.L$13;
                                                id\12 = (Long)$continuation.L$12;
                                                element\11 = (Map.Entry)$continuation.L$11;
                                                var19_23 = (Iterator<T>)$continuation.L$10;
                                                destination\11 = (Collection)$continuation.L$9;
                                                $this$flatMapTo\11 = (Map)$continuation.L$8;
                                                $this$flatMap\10 = (Map)$continuation.L$7;
                                                info\1 = (List)$continuation.L$6;
                                                $completion\1 = (Continuation)$continuation.L$5;
                                                var10_14 = (FlowCollector)$continuation.L$4;
                                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                                value = $continuation.L$2;
                                                $completion = $continuation.L$1;
                                                value = $continuation.L$0;
                                                try {
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v6 = $result;
lbl164:
                                                    // 2 sources

                                                    var26_33 = Result.constructor-impl((Object)((Playlist)v6));
                                                }
                                                catch (Throwable var27_38) {
                                                    var26_33 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var27_38));
                                                }
                                                var25_30 = var26_33;
                                                v2 = CollectionsKt.listOfNotNull((Object)(Result.isFailure-impl((Object)var25_30) != false ? null : var25_30));
lbl172:
                                                // 2 sources

                                                list\11 = v2;
                                                CollectionsKt.addAll((Collection)destination\11, (Iterable)list\11);
                                                ** GOTO lbl68
                                            }
                                        }
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                        $continuation.L$4 = null;
                                        $continuation.L$5 = null;
                                        $continuation.L$6 = null;
                                        $continuation.L$7 = null;
                                        $continuation.L$8 = null;
                                        $continuation.L$9 = null;
                                        $continuation.L$10 = null;
                                        $continuation.L$11 = null;
                                        $continuation.L$12 = null;
                                        $continuation.L$13 = null;
                                        $continuation.L$14 = null;
                                        $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                        $continuation.label = 2;
                                        v7 = var10_14.emit((Object)((List)destination\11), (Continuation)$continuation);
                                        if (v7 == var5_5) {
                                            return var5_5;
                                        }
                                        ** GOTO lbl205
                                        {
                                            case 2: {
                                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                                value = $continuation.L$2;
                                                $completion = $continuation.L$1;
                                                value = $continuation.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v7 = $result;
lbl205:
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
                        }).collect((FlowCollector)this.this$0.getUnified().getDownloadFeed(), (Continuation)this);
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
    public final App getApp() {
        return this.app;
    }

    @NotNull
    public final ExtensionLoader getExtensionLoader() {
        return this.extensionLoader;
    }

    @NotNull
    public final UnifiedExtension getUnified() {
        return this.unified;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final Object downloadExtension(@NotNull Continuation<? super MiscExtension> $completion) {
        block9: {
            if (!($completion instanceof downloadExtension.1)) ** GOTO lbl-1000
            var13_2 = $completion;
            if ((var13_2.label & -2147483648) != 0) {
                var13_2.label -= -2147483648;
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
                    final /* synthetic */ Downloader this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.downloadExtension((Continuation<? super MiscExtension>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var14_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    var2_5 = (Iterable)this.extensionLoader.getMisc().getValue();
                    var3_6 = var2_5.iterator();
lbl14:
                    // 2 sources

                    while (var3_6.hasNext()) {
                        var4_7 /* !! */  = var3_6.next();
                        it\2 = (MiscExtension)var4_7 /* !! */ ;
                        $i$a$-find-Downloader$downloadExtension$2\2\50\0 = 0;
                        var7_10 = ExtensionUtils.INSTANCE;
                        var8_11 = it\2;
                        $completion\3 = $continuation;
                        $i$f$isClient\3\50 = 0;
                        $continuation.L$0 = var3_6;
                        $continuation.L$1 = var4_7 /* !! */ ;
                        $continuation.L$2 = it\2;
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\3);
                        $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$isClient\3);
                        $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$completion\3);
                        $continuation.I$0 = $i$a$-find-Downloader$downloadExtension$2\2\50\0;
                        $continuation.I$1 = $i$f$isClient\3\50;
                        $continuation.label = 1;
                        v0 = $this$isClient\3.getInstance().value-IoAF18A($completion\3);
                        if (v0 == var14_4) {
                            return var14_4;
                        }
                        ** GOTO lbl47
                    }
                    break;
                }
                case 1: {
                    $i$f$isClient\3\50 = $continuation.I$1;
                    $i$a$-find-Downloader$downloadExtension$2\2\50\0 = $continuation.I$0;
                    $completion\3 = $continuation.L$5;
                    $this$isClient\3 = (Extension)$continuation.L$4;
                    this_\3 = (ExtensionUtils)$continuation.L$3;
                    it\2 = (MiscExtension)$continuation.L$2;
                    var4_7 /* !! */  = $continuation.L$1;
                    var3_6 = (Iterator)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = ((Result)$result).unbox-impl();
lbl47:
                    // 2 sources

                    v1 = Result.isFailure-impl((Object)(var11_14 = v0)) ? null : var11_14;
                    if (!(v1 instanceof DownloadClient != false && it\2.isEnabled() != false)) ** GOTO lbl14
                    v2 = var4_7 /* !! */ ;
                    break block9;
                }
            }
            v2 = null;
        }
        v3 = v2;
        if (v3 == null) {
            throw new DownloaderExtensionNotFoundException();
        }
        return v3;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public final DownloadDao getDao() {
        return this.dao;
    }

    @NotNull
    public final Flow<List<DownloadEntity>> getDownloadFlow() {
        return this.downloadFlow;
    }

    @NotNull
    public final TaskManager getTaskManager() {
        return this.taskManager;
    }

    @NotNull
    public final Job add(@NotNull List<DownloadContext> downloads) {
        Intrinsics.checkNotNullParameter(downloads, (String)"downloads");
        return BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, downloads, null){
            Object L$0;
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
            int I$4;
            int label;
            final /* synthetic */ Downloader this$0;
            final /* synthetic */ List<DownloadContext> $downloads;
            {
                this.this$0 = $receiver;
                this.$downloads = $downloads;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var23_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        var4_3 = ExtensionUtils.INSTANCE;
                        this.L$0 = var4_3;
                        this.label = 1;
                        v0 = this.this$0.downloadExtension((Continuation<? super MiscExtension>)((Continuation)this));
                        if (v0 == var23_2) {
                            return var23_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        var4_3 = (ExtensionUtils)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl16:
                        // 2 sources

                        var5_4 = (Extension)v0;
                        $i$f$getAs-0E7RQCE\1\71 = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\1);
                        this.I$0 = $i$f$getAs-0E7RQCE\1\71;
                        this.label = 2;
                        v1 = this_\1.get-0E7RQCE((Extension<?>)$this$getAs_u2d0E7RQCE\1, (Function2)new Function2<ExtensionClient, Continuation<? super Integer>, Object>(null){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void $this$get;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object v0 = $this$get;
                                        if (!(v0 instanceof DownloadClient)) {
                                            v0 = null;
                                        }
                                        DownloadClient downloadClient = v0;
                                        if (downloadClient == null) {
                                            String string2 = Reflection.getOrCreateKotlinClass(DownloadClient.class).getSimpleName();
                                            if (string2 == null) {
                                                string2 = "Unknown Class";
                                            }
                                            throw new ClientException.NotSupported(string2);
                                        }
                                        DownloadClient client = downloadClient;
                                        Continuation continuation = (Continuation)this;
                                        DownloadClient downloadClient2 = client;
                                        boolean bl = false;
                                        return Boxing.boxInt((int)downloadClient2.getConcurrentDownloads());
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super Integer> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, (Continuation)this);
                        if (v1 == var23_2) {
                            return var23_2;
                        }
                        ** GOTO lbl34
                    }
                    case 2: {
                        $i$f$getAs-0E7RQCE\1\71 = this.I$0;
                        $this$getAs_u2d0E7RQCE\1 = (Extension)this.L$1;
                        this_\1 = (ExtensionUtils)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = ((Result)$result).unbox-impl();
lbl34:
                        // 2 sources

                        this_\1 = v1;
                        var3_10 = (Integer)(Result.isFailure-impl((Object)this_\1) != false ? null : this_\1);
                        if (var3_10 == null) ** GOTO lbl-1000
                        $this$getAs_u2d0E7RQCE\1 = var3_10;
                        it\2 = ((Number)$this$getAs_u2d0E7RQCE\1).intValue();
                        $i$a$-takeIf-Downloader$add$1$concurrentDownloads$2\2\72\0 = false;
                        v2 = this_\1 = it\2 > 0 != false ? $this$getAs_u2d0E7RQCE\1 : null;
                        if (this_\1 != null) {
                            v3 = this_\1.intValue();
                        } else lbl-1000:
                        // 2 sources

                        {
                            v3 = 2;
                        }
                        concurrentDownloads = v3;
                        this.this$0.getTaskManager().setConcurrency(concurrentDownloads);
                        $this$mapNotNull\3 = this.$downloads;
                        $i$f$mapNotNull\3\74 = false;
                        it\2 = $this$mapNotNull\3;
                        destination\4 = new ArrayList<E>();
                        $i$f$mapNotNullTo\4\234 = false;
                        $this$forEach\5 = $this$mapNotNullTo\4;
                        $i$f$forEach\5\242 = false;
                        for (T element\5 : $this$forEach\5) {
                            element\6 /* !! */  = element\5;
                            $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\6\243\4 = false;
                            it\8 = (DownloadContext)element\6 /* !! */ ;
                            $i$a$-mapNotNull-Downloader$add$1$contexts$1\8\242\0 = false;
                            if (it\8.getContext() == null) continue;
                            $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\7\244\6 = false;
                            destination\4.add(it\6);
                        }
                        $this$mapNotNull\3 = (List)destination\4;
                        $i$f$distinctBy\9\74 = false;
                        set\9 = new HashSet<String>();
                        list\9 = new ArrayList<T>();
                        for (T e\9 : $this$distinctBy\9) {
                            it\10 = (EchoMediaItem)e\9;
                            $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0 = false;
                            key\9 = it\10.getId();
                            if (!set\9.add(key\9)) continue;
                            list\9.add(e\9);
                        }
                        $this$distinctBy\9 = list\9;
                        var5_6 = this.this$0;
                        $i$f$associate\11\74 = 0;
                        capacity\11 = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate\11, (int)10)), (int)16);
                        $i$f$mapNotNullTo\4\234 = $this$associate\11;
                        destination\12 = new LinkedHashMap<K, V>(capacity\11);
                        $i$f$associateTo\12\256 = 0;
                        $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0 = $this$associateTo\12.iterator();
lbl85:
                        // 2 sources

                        while ($i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0.hasNext()) {
                            element\12 = $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0.next();
                            element\6 /* !! */  = destination\12;
                            it\13 = (EchoMediaItem)element\12;
                            $i$a$-associate-Downloader$add$1$contexts$3\13\258\0 = 0;
                            $i$a$-mapNotNull-Downloader$add$1$contexts$1\8\242\0 = it\13.getId();
                            v4 = var5_6.getDao();
                            v5 = it\13.getId();
                            it\6 = Serializer.INSTANCE;
                            $this$toJson\14 = it\13;
                            $i$f$toJson\14\75 = false;
                            var20_39 = this_\14.getJson();
                            value\15 = $this$toJson\14;
                            $i$f$encodeToString\15\259 = false;
                            this_\15.getSerializersModule();
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$associate\11);
                            this.L$1 = var5_6;
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$associateTo\12);
                            this.L$3 = destination\12;
                            this.L$4 = $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)element\12);
                            this.L$6 = element\6 /* !! */ ;
                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)it\13);
                            this.L$8 = $i$a$-mapNotNull-Downloader$add$1$contexts$1\8\242\0;
                            this.I$0 = concurrentDownloads;
                            this.I$1 = $i$f$associate\11\74;
                            this.I$2 = capacity\11;
                            this.I$3 = $i$f$associateTo\12\256;
                            this.I$4 = $i$a$-associate-Downloader$add$1$contexts$3\13\258\0;
                            this.label = 3;
                            v6 = v4.insertContextEntity(new ContextEntity(0L, v5, this_\15.encodeToString((SerializationStrategy)EchoMediaItem.Companion.serializer(), (Object)value\15)), (Continuation<? super Long>)this);
                            if (v6 == var23_2) {
                                return var23_2;
                            }
                            ** GOTO lbl139
                        }
                        break;
                    }
                    case 3: {
                        $i$a$-associate-Downloader$add$1$contexts$3\13\258\0 = this.I$4;
                        $i$f$associateTo\12\256 = this.I$3;
                        capacity\11 = this.I$2;
                        $i$f$associate\11\74 = this.I$1;
                        concurrentDownloads = this.I$0;
                        $i$a$-mapNotNull-Downloader$add$1$contexts$1\8\242\0 = (String)this.L$8;
                        it\13 = (EchoMediaItem)this.L$7;
                        element\6 /* !! */  = (Map)this.L$6;
                        element\12 = this.L$5;
                        $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0 = (Iterator)this.L$4;
                        destination\12 = (Map)this.L$3;
                        $this$associateTo\12 = (Iterable)this.L$2;
                        var5_6 = (Downloader)this.L$1;
                        $this$associate\11 = (Iterable)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v6 = $result;
lbl139:
                        // 2 sources

                        it\13 = TuplesKt.to((Object)$i$a$-mapNotNull-Downloader$add$1$contexts$1\8\242\0, (Object)v6);
                        element\6 /* !! */ .put(it\13.getFirst(), it\13.getSecond());
                        ** GOTO lbl85
                    }
                }
                contexts = destination\12;
                $this$associate\11 = this.$downloads;
                var5_6 = this.this$0;
                $i$f$forEach\16\77 = 0;
                var7_14 = $this$forEach\16.iterator();
lbl148:
                // 3 sources

                while (var7_14.hasNext()) {
                    element\16 = var7_14.next();
                    it\17 = (DownloadContext)element\16;
                    $i$a$-forEach-Downloader$add$1$1\17\262\0 = 0;
                    v7 = var5_6.getDao();
                    v8 = it\17.getTrack().getExtras().get("extension_id");
                    if (v8 == null) {
                        v8 = it\17.getExtensionId();
                    }
                    v9 = it\17.getTrack().getId();
                    $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0 = contexts;
                    v10 = it\17.getContext();
                    v11 = (Long)$i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0.get(v10 != null ? v10.getId() : null);
                    v12 = it\17.getSortOrder();
                    $i$a$-distinctBy-Downloader$add$1$contexts$2\10\250\0 = Serializer.INSTANCE;
                    $this$toJson\18 = it\17.getTrack();
                    $i$f$toJson\18\85 = false;
                    it\13 = this_\18.getJson();
                    value\19 = $this$toJson\18;
                    $i$f$encodeToString\19\263 = false;
                    this_\19.getSerializersModule();
                    this.L$0 = contexts;
                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach\16);
                    this.L$2 = var5_6;
                    this.L$3 = var7_14;
                    this.L$4 = SpillingKt.nullOutSpilledVariable((Object)element\16);
                    this.L$5 = SpillingKt.nullOutSpilledVariable((Object)it\17);
                    this.L$6 = null;
                    this.L$7 = null;
                    this.L$8 = null;
                    this.I$0 = concurrentDownloads;
                    this.I$1 = $i$f$forEach\16\77;
                    this.I$2 = $i$a$-forEach-Downloader$add$1$1\17\262\0;
                    this.label = 4;
                    v13 = v7.insertDownloadEntity(new DownloadEntity(0L, v8, v9, v11, v12, this_\19.encodeToString((SerializationStrategy)Track.Companion.serializer(), (Object)value\19), TaskType.Loading, false, null, null, null, null, null, null, null, false, 65408, null), (Continuation<? super Long>)this);
                    if (v13 != var23_2) continue;
                    return var23_2;
                }
                {
                    break;
                    case 4: {
                        $i$a$-forEach-Downloader$add$1$1\17\262\0 = this.I$2;
                        $i$f$forEach\16\77 = this.I$1;
                        concurrentDownloads = this.I$0;
                        it\17 = (DownloadContext)this.L$5;
                        element\16 = this.L$4;
                        var7_14 = (Iterator<T>)this.L$3;
                        var5_6 = (Downloader)this.L$2;
                        $this$forEach\16 = (Iterable)this.L$1;
                        contexts = (Map)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v13 = $result;
                        ** GOTO lbl148
                    }
                }
                Downloader.access$ensureWorker(this.this$0);
                return Unit.INSTANCE;
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

    private final WorkManager getWorkManager() {
        Lazy lazy = this.workManager$delegate;
        return (WorkManager)lazy.getValue();
    }

    private final void ensureWorker() {
        boolean bl = false;
        OneTimeWorkRequest request = (OneTimeWorkRequest)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)new OneTimeWorkRequest.Builder(DownloadWorker.class).setConstraints(new Constraints(NetworkType.CONNECTED, false, false, true, 6, null))).addTag(TAG)).build();
        this.getWorkManager().enqueueUniqueWork(TAG, ExistingWorkPolicy.KEEP, request);
    }

    private static /* synthetic */ void getServers$annotations() {
    }

    private static /* synthetic */ void getMutexes$annotations() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public final Object getServer(long trackId, @NotNull DownloadEntity download, @NotNull Continuation<? super Streamable.Media.Server> $completion) {
        block19: {
            if (!($completion instanceof getServer.1)) ** GOTO lbl-1000
            var28_4 = $completion;
            if ((var28_4.label & -2147483648) != 0) {
                var28_4.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    long J$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    Object L$8;
                    Object L$9;
                    Object L$10;
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    /* synthetic */ Object result;
                    final /* synthetic */ Downloader this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.getServer(0L, null, (Continuation<? super Streamable.Media.Server>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var29_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    var7_7 = this.mutexes;
                    key\1 = Boxing.boxLong((long)trackId);
                    $i$f$getOrPut\1\109 = false;
                    value\1 /* !! */  = $this$getOrPut\1.get(key\1);
                    if (value\1 /* !! */  == null) {
                        $i$a$-getOrPut-Downloader$getServer$2\2\233\0 = false;
                        answer\1 = MutexKt.Mutex$default((boolean)false, (int)1, null);
                        $this$getOrPut\1.put(key\1, answer\1);
                        v0 /* !! */  = answer\1;
                    } else {
                        v0 /* !! */  = value\1 /* !! */ ;
                    }
                    Intrinsics.checkNotNullExpressionValue(v0 /* !! */ , (String)"getOrPut(...)");
                    $this$withLock_u24default\3 = (Mutex)v0 /* !! */ ;
                    owner\3 = null;
                    $i$f$withLock\3\109 = 0;
                    $continuation.L$0 = download;
                    $continuation.L$1 = $this$withLock_u24default\3;
                    $continuation.J$0 = trackId;
                    $continuation.I$0 = $i$f$withLock\3\109;
                    $continuation.label = 1;
                    v1 = $this$withLock_u24default\3.lock(owner\3, (Continuation)$continuation);
                    if (v1 == var29_6) {
                        return var29_6;
                    }
                    ** GOTO lbl47
                }
                case 1: {
                    $i$f$withLock\3\109 = $continuation.I$0;
                    trackId = $continuation.J$0;
                    owner\3 = null;
                    $this$withLock_u24default\3 = (Mutex)$continuation.L$1;
                    download = (DownloadEntity)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl47:
                    // 3 sources

                    $i$a$-withLock$default-Downloader$getServer$3\4\245\0 = 0;
                    value\1 /* !! */  = this.servers;
                    key\5 = Boxing.boxLong((long)trackId);
                    $i$f$getOrPut\5\110 = 0;
                    value\5 = $this$getOrPut\5.get(key\5);
                    if (value\5 != null) break;
                    $i$a$-getOrPut-Downloader$getServer$3$1\6\248\4 = 0;
                    extensionId\6 = download.getExtensionId();
                    $continuation.L$0 = download;
                    $continuation.L$1 = $this$withLock_u24default\3;
                    $continuation.L$2 = $this$getOrPut\5;
                    $continuation.L$3 = key\5;
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)value\5);
                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)extensionId\6);
                    $continuation.J$0 = trackId;
                    $continuation.I$0 = $i$f$withLock\3\109;
                    $continuation.I$1 = $i$a$-withLock$default-Downloader$getServer$3\4\245\0;
                    $continuation.I$2 = $i$f$getOrPut\5\110;
                    $continuation.I$3 = $i$a$-getOrPut-Downloader$getServer$3$1\6\248\4;
                    $continuation.label = 2;
                    v2 = ExtensionUtils.INSTANCE.getExtensionOrThrow((Flow)this.extensionLoader.getMusic(), extensionId\6, $continuation);
                    v3 = v2;
                    if (v2 == var29_6) {
                        return var29_6;
                    }
                    ** GOTO lbl92
                }
                case 2: {
                    $i$a$-getOrPut-Downloader$getServer$3$1\6\248\4 = $continuation.I$3;
                    $i$f$getOrPut\5\110 = $continuation.I$2;
                    $i$a$-withLock$default-Downloader$getServer$3\4\245\0 = $continuation.I$1;
                    $i$f$withLock\3\109 = $continuation.I$0;
                    trackId = $continuation.J$0;
                    extensionId\6 = (String)$continuation.L$5;
                    value\5 = $continuation.L$4;
                    key\5 = (Long)$continuation.L$3;
                    $this$getOrPut\5 = (Map)$continuation.L$2;
                    owner\3 = null;
                    $this$withLock_u24default\3 = (Mutex)$continuation.L$1;
                    download = (DownloadEntity)$continuation.L$0;
                    {
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl92:
                        // 2 sources

                        extension\6 = (MusicExtension)v3;
                        var17_27 = download.getTrack-d1pmJ48();
                        ResultKt.throwOnFailure((Object)var17_27);
                        var18_28 = ((Track)var17_27).getStreamables();
                        var19_30 = var18_28.iterator();
                        while (var19_30.hasNext()) {
                            var20_32 = var19_30.next();
                            it\7 = (Streamable)var20_32;
                            $i$a$-find-Downloader$getServer$3$1$streamable$1\7\114\6 = false;
                            if (!Intrinsics.areEqual((Object)it\7.getId(), (Object)download.getStreamableId())) continue;
                            v4 = var20_32;
                            ** GOTO lbl105
                        }
                        v4 = null;
lbl105:
                        // 2 sources

                        Intrinsics.checkNotNull(v4);
                        streamable\6 = v4;
                        var17_27 = ExtensionUtils.INSTANCE;
                        var18_28 = extension\6;
                        $completion\8 = $continuation;
                        $i$f$getAs-0E7RQCE\8\115 = 0;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                        $continuation.L$1 = $this$withLock_u24default\3;
                        $continuation.L$2 = $this$getOrPut\5;
                        $continuation.L$3 = key\5;
                        $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)value\5);
                        $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)extensionId\6);
                        $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)extension\6);
                        $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)this_\8);
                        $continuation.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\8);
                        $continuation.L$9 = SpillingKt.nullOutSpilledVariable((Object)$completion\8);
                        $continuation.L$10 = SpillingKt.nullOutSpilledVariable((Object)streamable\6);
                        $continuation.J$0 = trackId;
                        $continuation.I$0 = $i$f$withLock\3\109;
                        $continuation.I$1 = $i$a$-withLock$default-Downloader$getServer$3\4\245\0;
                        $continuation.I$2 = $i$f$getOrPut\5\110;
                        $continuation.I$3 = $i$a$-getOrPut-Downloader$getServer$3$1\6\248\4;
                        $continuation.I$4 = $i$f$getAs-0E7RQCE\8\115;
                        $continuation.label = 3;
                        v5 = this_\8.get-0E7RQCE((Extension<?>)$this$getAs_u2d0E7RQCE\8, (Function2)new Function2<ExtensionClient, Continuation<? super Streamable.Media.Server>, Object>(null, streamable\6, trackId){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ Streamable $streamable$inlined;
                            final /* synthetic */ long $trackId$inlined;
                            Object L$2;
                            Object L$3;
                            int I$0;
                            {
                                this.$streamable$inlined = streamable;
                                this.$trackId$inlined = l;
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
                                        v0 = $this$get;
                                        if (!(v0 instanceof TrackClient)) {
                                            v0 = null;
                                        }
                                        v1 = v0;
                                        if (v1 == null) {
                                            v2 = Reflection.getOrCreateKotlinClass(TrackClient.class).getSimpleName();
                                            if (v2 == null) {
                                                v2 = "Unknown Class";
                                            }
                                            throw new ClientException.NotSupported(v2);
                                        }
                                        client = v1;
                                        var5_6 = (Continuation)this;
                                        $this$getServer_u24lambda_u247_u24lambda_u246_u24lambda_u245\1 = client;
                                        $i$a$-getAs-0E7RQCE-Downloader$getServer$3$1$1\1\36\0 = 0;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getServer_u24lambda_u247_u24lambda_u246_u24lambda_u245\1);
                                        this.I$0 = $i$a$-getAs-0E7RQCE-Downloader$getServer$3$1$1\1\36\0;
                                        this.label = 1;
                                        v3 = $this$getServer_u24lambda_u247_u24lambda_u246_u24lambda_u245\1.loadStreamableMedia(this.$streamable$inlined, true, (Continuation<? super Streamable.Media>)this);
                                        if (v3 == var3_3) {
                                            return var3_3;
                                        }
                                        ** GOTO lbl36
                                    }
                                    case 1: {
                                        $i$a$-getAs-0E7RQCE-Downloader$getServer$3$1$1\1\36\0 = this.I$0;
                                        $this$getServer_u24lambda_u247_u24lambda_u246_u24lambda_u245\1 = (TrackClient)this.L$3;
                                        $completion\1 = (Continuation)this.L$2;
                                        client = (TrackClient)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v3 = $result;
lbl36:
                                        // 2 sources

                                        Intrinsics.checkNotNull((Object)v3, (String)"null cannot be cast to non-null type dev.brahmkshatriya.echo.common.models.Streamable.Media.Server");
                                        media\1 = (Streamable.Media.Server)v3;
                                        var8_13 = media\1.getSources();
                                        if (var8_13.isEmpty()) {
                                            $i$a$-ifEmpty-Downloader$getServer$3$1$1$1\2\149\1 = false;
                                            throw new Exception(this.$trackId$inlined + ": No sources found");
                                        }
                                        return media\1;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super Streamable.Media.Server> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, $completion\8);
                        ** if (v5 != var29_6) goto lbl132
                    }
lbl131:
                    // 1 sources

                    return var29_6;
lbl132:
                    // 1 sources

                    ** GOTO lbl157
                }
                case 3: {
                    $i$f$getAs-0E7RQCE\8\115 = $continuation.I$4;
                    $i$a$-getOrPut-Downloader$getServer$3$1\6\248\4 = $continuation.I$3;
                    $i$f$getOrPut\5\110 = $continuation.I$2;
                    $i$a$-withLock$default-Downloader$getServer$3\4\245\0 = $continuation.I$1;
                    $i$f$withLock\3\109 = $continuation.I$0;
                    trackId = $continuation.J$0;
                    streamable\6 = (Streamable)$continuation.L$10;
                    $completion\8 = $continuation.L$9;
                    $this$getAs_u2d0E7RQCE\8 = (Extension)$continuation.L$8;
                    this_\8 = (ExtensionUtils)$continuation.L$7;
                    extension\6 = (MusicExtension)$continuation.L$6;
                    extensionId\6 = (String)$continuation.L$5;
                    value\5 = $continuation.L$4;
                    key\5 = (Long)$continuation.L$3;
                    $this$getOrPut\5 = (Map)$continuation.L$2;
                    owner\3 = null;
                    $this$withLock_u24default\3 = (Mutex)$continuation.L$1;
                    download = (DownloadEntity)$continuation.L$0;
                    ** try [egrp 2[TRYBLOCK] [2 : 992->1048)] { 
lbl153:
                    // 1 sources

                    ResultKt.throwOnFailure((Object)$result);
                    v5 = ((Result)$result).unbox-impl();
lbl157:
                    // 2 sources

                    var17_27 = v5;
                    ResultKt.throwOnFailure((Object)var17_27);
                    answer\5 = (Streamable.Media.Server)var17_27;
                    $this$getOrPut\5.put(key\5, answer\5);
                    v6 = answer\5;
                    break block19;
                }
            }
            v6 = value\5;
            break block19;
lbl169:
            // 1 sources

            finally {
                $this$withLock_u24default\3.unlock(owner\3);
            }
        }
        var25_40 = (Streamable.Media.Server)v6;
        var5_42 = var25_40;
        Intrinsics.checkNotNull((Object)var5_42);
        return var5_42;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final void cancel(long trackId) {
        this.taskManager.remove(trackId);
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, trackId, null){
            int label;
            final /* synthetic */ Downloader this$0;
            final /* synthetic */ long $trackId;
            {
                this.this$0 = $receiver;
                this.$trackId = $trackId;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = this.this$0.getDao().getDownloadEntity(this.$trackId, (Continuation<? super DownloadEntity>)((Continuation)this));
                        if (v0 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        v1 = (DownloadEntity)v0;
                        if (v1 == null) {
                            return Unit.INSTANCE;
                        }
                        entity = v1;
                        this.this$0.getDao().deleteDownloadEntity(entity);
                        v2 = entity.getExceptionFile();
                        if (v2 != null) {
                            it\1 = v2;
                            $i$a$-let-Downloader$cancel$1$1\1\131\0 = false;
                            file\1 = new File(it\1);
                            if (file\1.exists()) {
                                file\1.delete();
                            }
                        }
                        Downloader.access$getServers$p(this.this$0).remove(Boxing.boxLong((long)this.$trackId));
                        Downloader.access$getMutexes$p(this.this$0).remove(Boxing.boxLong((long)this.$trackId));
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

    public final void restart(long trackId) {
        this.taskManager.remove(trackId);
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, trackId, null){
            Object L$0;
            int label;
            final /* synthetic */ Downloader this$0;
            final /* synthetic */ long $trackId;
            {
                this.this$0 = $receiver;
                this.$trackId = $trackId;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = this.this$0.getDao().getDownloadEntity(this.$trackId, (Continuation<? super DownloadEntity>)((Continuation)this));
                        if (v0 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        v1 = (DownloadEntity)v0;
                        if (v1 == null) {
                            return Unit.INSTANCE;
                        }
                        download = v1;
                        this.L$0 = download;
                        this.label = 2;
                        v2 = this.this$0.getDao().insertDownloadEntity(DownloadEntity.copy$default(download, 0L, null, null, null, null, null, null, false, null, null, null, null, null, null, null, false, 8191, null), (Continuation<? super Long>)((Continuation)this));
                        if (v2 == var6_2) {
                            return var6_2;
                        }
                        ** GOTO lbl27
                    }
                    case 2: {
                        download = (DownloadEntity)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl27:
                        // 2 sources

                        v3 = download.getExceptionFile();
                        if (v3 != null) {
                            it\1 = v3;
                            $i$a$-let-Downloader$restart$1$1\1\147\0 = false;
                            file\1 = new File(it\1);
                            if (file\1.exists()) {
                                file\1.delete();
                            }
                        }
                        Downloader.access$getServers$p(this.this$0).remove(Boxing.boxLong((long)this.$trackId));
                        Downloader.access$getMutexes$p(this.this$0).remove(Boxing.boxLong((long)this.$trackId));
                        Downloader.access$ensureWorker(this.this$0);
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

    public final void cancelAll() {
        this.taskManager.removeAll();
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ Downloader this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = FlowKt.first(this.this$0.getDownloadFlow(), (Continuation)((Continuation)this));
                        if (v0 == var12_2) {
                            return var12_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        $this$filter\1 = (Iterable)v0;
                        $i$f$filter\1\160 = false;
                        var5_6 = $this$filter\1;
                        destination\2 = new ArrayList<E>();
                        $i$f$filterTo\2\228 = false;
                        for (T element\2 : $this$filterTo\2) {
                            it\3 = (DownloadEntity)element\2;
                            $i$a$-filter-Downloader$cancelAll$1$downloads$1\3\229\0 = false;
                            if (!(it\3.getFinalFile() == null)) continue;
                            destination\2.add(element\2);
                        }
                        downloads = (List)destination\2;
                        $this$filter\1 = downloads;
                        var4_5 = this.this$0;
                        $i$f$forEach\4\161 = false;
                        for (T element\4 : $this$forEach\4) {
                            download\5 = (DownloadEntity)element\4;
                            $i$a$-forEach-Downloader$cancelAll$1$1\5\231\0 = false;
                            var4_5.getDao().deleteDownloadEntity(download\5);
                            Downloader.access$getServers$p(var4_5).remove(Boxing.boxLong((long)download\5.getId()));
                            Downloader.access$getMutexes$p(var4_5).remove(Boxing.boxLong((long)download\5.getId()));
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

    public final void deleteDownload(@NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, id2, null){
            int label;
            final /* synthetic */ Downloader this$0;
            final /* synthetic */ String $id;
            {
                this.this$0 = $receiver;
                this.$id = $id;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var13_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = FlowKt.first(this.this$0.getDownloadFlow(), (Continuation)((Continuation)this));
                        if (v0 == var13_2) {
                            return var13_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        var3_3 = (Iterable)v0;
                        var4_4 = this.$id;
                        $i$f$filter\1\171 = false;
                        var6_6 = $this$filter\1;
                        destination\2 = new ArrayList<E>();
                        $i$f$filterTo\2\228 = false;
                        for (T element\2 : $this$filterTo\2) {
                            it\3 = (DownloadEntity)element\2;
                            $i$a$-filter-Downloader$deleteDownload$1$downloads$1\3\229\0 = false;
                            if (!Intrinsics.areEqual((Object)it\3.getTrackId(), (Object)var4_4)) continue;
                            destination\2.add(element\2);
                        }
                        downloads = (List)destination\2;
                        $this$filter\1 = downloads;
                        var4_4 = this.this$0;
                        $i$f$forEach\4\172 = false;
                        for (T element\4 : $this$forEach\4) {
                            download\5 = (DownloadEntity)element\4;
                            $i$a$-forEach-Downloader$deleteDownload$1$1\5\231\0 = false;
                            var4_4.getDao().deleteDownloadEntity(download\5);
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

    public final void deleteContext(@NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, id2, null){
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int I$0;
            int I$1;
            int label;
            final /* synthetic */ Downloader this$0;
            final /* synthetic */ String $id;
            {
                this.this$0 = $receiver;
                this.$id = $id;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var22_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = FlowKt.first((Flow)Downloader.access$getContextFlow$p(this.this$0), (Continuation)((Continuation)this));
                        if (v0 == var22_2) {
                            return var22_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        var3_3 = (Iterable)v0;
                        var4_4 = this.$id;
                        $i$f$filter\1\180 = false;
                        var6_6 = $this$filter\1;
                        destination\2 = new ArrayList<E>();
                        $i$f$filterTo\2\228 = false;
                        for (T element\2 : $this$filterTo\2) {
                            it\3 = (ContextEntity)element\2;
                            $i$a$-filter-Downloader$deleteContext$1$contexts$1\3\229\0 = false;
                            if (!Intrinsics.areEqual((Object)it\3.getItemId(), (Object)var4_4)) continue;
                            destination\2.add(element\2);
                        }
                        contexts = (List)destination\2;
                        $this$filter\1 = contexts;
                        var4_4 = this.this$0;
                        $i$f$forEach\4\181 = 0;
                        var6_6 = $this$forEach\4.iterator();
lbl31:
                        // 2 sources

                        while (var6_6.hasNext()) {
                            element\4 = var6_6.next();
                            context\5 = (ContextEntity)element\4;
                            $i$a$-forEach-Downloader$deleteContext$1$1\5\231\0 = 0;
                            var4_4.getDao().deleteContextEntity(context\5);
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)contexts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach\4);
                            this.L$2 = var4_4;
                            this.L$3 = var6_6;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)element\4);
                            this.L$5 = context\5;
                            this.I$0 = $i$f$forEach\4\181;
                            this.I$1 = $i$a$-forEach-Downloader$deleteContext$1$1\5\231\0;
                            this.label = 2;
                            v1 = FlowKt.first(var4_4.getDownloadFlow(), (Continuation)this);
                            if (v1 == var22_2) {
                                return var22_2;
                            }
                            ** GOTO lbl61
                        }
                        break;
                    }
                    case 2: {
                        $i$a$-forEach-Downloader$deleteContext$1$1\5\231\0 = this.I$1;
                        $i$f$forEach\4\181 = this.I$0;
                        context\5 = (ContextEntity)this.L$5;
                        element\4 = this.L$4;
                        var6_6 = (Iterator<T>)this.L$3;
                        var4_4 = (Downloader)this.L$2;
                        $this$forEach\4 = (Iterable)this.L$1;
                        contexts = (List)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl61:
                        // 2 sources

                        $this$filter\6 = (Iterable)v1;
                        $i$f$filter\6\183 = false;
                        $i$a$-filter-Downloader$deleteContext$1$contexts$1\3\229\0 = $this$filter\6;
                        destination\7 = new ArrayList<E>();
                        $i$f$filterTo\7\232 = false;
                        for (T element\7 : $this$filterTo\7) {
                            it\8 = (DownloadEntity)element\7;
                            $i$a$-filter-Downloader$deleteContext$1$1$downloads$1\8\233\5 = false;
                            v2 = it\8.getContextId();
                            var19_26 = context\5.getId();
                            if (!(v2 != null && v2 == var19_26)) continue;
                            destination\7.add(element\7);
                        }
                        downloads\5 = (List)destination\7;
                        $this$forEach\9 = downloads\5;
                        $i$f$forEach\9\186 = false;
                        for (T element\9 : $this$forEach\9) {
                            download\10 = (DownloadEntity)element\9;
                            $i$a$-forEach-Downloader$deleteContext$1$1$1\10\235\5 = false;
                            var4_4.getDao().deleteDownloadEntity(download\10);
                        }
                        ** GOTO lbl31
                    }
                }
                return Unit.INSTANCE;
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
    public final StateFlow<List<Info>> getFlow() {
        return this.flow;
    }

    private static final WorkManager workManager_delegate$lambda$1(Downloader this$0) {
        return WorkManager.Companion.getInstance((Context)this$0.app.getContext());
    }

    public static final /* synthetic */ void access$ensureWorker(Downloader $this) {
        $this.ensureWorker();
    }

    public static final /* synthetic */ WeakHashMap access$getServers$p(Downloader $this) {
        return $this.servers;
    }

    public static final /* synthetic */ WeakHashMap access$getMutexes$p(Downloader $this) {
        return $this.mutexes;
    }

    public static final /* synthetic */ Flow access$getContextFlow$p(Downloader $this) {
        return $this.contextFlow;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Ldev/brahmkshatriya/echo/download/Downloader$Companion;", "", "<init>", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/download/Downloader$Info;", "", "download", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "context", "Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "workers", "", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "<init>", "(Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;Ljava/util/List;)V", "getDownload", "()Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "getContext", "()Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "getWorkers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class Info {
        @NotNull
        private final DownloadEntity download;
        @Nullable
        private final ContextEntity context;
        @NotNull
        private final List<Pair<TaskType, Progress>> workers;

        public Info(@NotNull DownloadEntity download2, @Nullable ContextEntity context, @NotNull List<? extends Pair<? extends TaskType, Progress>> workers) {
            Intrinsics.checkNotNullParameter((Object)download2, (String)"download");
            Intrinsics.checkNotNullParameter(workers, (String)"workers");
            this.download = download2;
            this.context = context;
            this.workers = workers;
        }

        @NotNull
        public final DownloadEntity getDownload() {
            return this.download;
        }

        @Nullable
        public final ContextEntity getContext() {
            return this.context;
        }

        @NotNull
        public final List<Pair<TaskType, Progress>> getWorkers() {
            return this.workers;
        }

        @NotNull
        public final DownloadEntity component1() {
            return this.download;
        }

        @Nullable
        public final ContextEntity component2() {
            return this.context;
        }

        @NotNull
        public final List<Pair<TaskType, Progress>> component3() {
            return this.workers;
        }

        @NotNull
        public final Info copy(@NotNull DownloadEntity download2, @Nullable ContextEntity context, @NotNull List<? extends Pair<? extends TaskType, Progress>> workers) {
            Intrinsics.checkNotNullParameter((Object)download2, (String)"download");
            Intrinsics.checkNotNullParameter(workers, (String)"workers");
            return new Info(download2, context, workers);
        }

        public static /* synthetic */ Info copy$default(Info info, DownloadEntity downloadEntity, ContextEntity contextEntity, List list2, int n, Object object) {
            if ((n & 1) != 0) {
                downloadEntity = info.download;
            }
            if ((n & 2) != 0) {
                contextEntity = info.context;
            }
            if ((n & 4) != 0) {
                list2 = info.workers;
            }
            return info.copy(downloadEntity, contextEntity, list2);
        }

        @NotNull
        public String toString() {
            return "Info(download=" + this.download + ", context=" + this.context + ", workers=" + this.workers + ")";
        }

        public int hashCode() {
            int result2 = this.download.hashCode();
            result2 = result2 * 31 + (this.context == null ? 0 : this.context.hashCode());
            result2 = result2 * 31 + ((Object)this.workers).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Info)) {
                return false;
            }
            Info info = (Info)other;
            if (!Intrinsics.areEqual((Object)this.download, (Object)info.download)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.context, (Object)info.context)) {
                return false;
            }
            return Intrinsics.areEqual(this.workers, info.workers);
        }
    }
}

