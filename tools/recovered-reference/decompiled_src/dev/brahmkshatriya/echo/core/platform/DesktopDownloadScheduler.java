/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import dev.brahmkshatriya.echo.core.platform.DownloadRequest;
import dev.brahmkshatriya.echo.core.platform.DownloadScheduler;
import dev.brahmkshatriya.echo.core.platform.DownloadStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DesktopDownloadScheduler;", "Ldev/brahmkshatriya/echo/core/platform/DownloadScheduler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "_downloads", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Ldev/brahmkshatriya/echo/core/platform/DownloadStatus;", "observeAll", "Lkotlinx/coroutines/flow/StateFlow;", "jobs", "", "", "Lkotlinx/coroutines/Job;", "enqueue", "", "request", "Ldev/brahmkshatriya/echo/core/platform/DownloadRequest;", "cancel", "downloadId", "retry", "clearCompleted", "updateDownload", "status", "core"})
@SourceDebugExtension(value={"SMAP\nDesktopDownloadScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopDownloadScheduler.kt\ndev/brahmkshatriya/echo/core/platform/DesktopDownloadScheduler\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,69:1\n1#2:70\n774#3:71\n865#3,2:72\n360#3,7:74\n*S KotlinDebug\n*F\n+ 1 DesktopDownloadScheduler.kt\ndev/brahmkshatriya/echo/core/platform/DesktopDownloadScheduler\n*L\n57#1:71\n57#1:72,2\n64#1:74,7\n*E\n"})
public final class DesktopDownloadScheduler
implements DownloadScheduler {
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableStateFlow<List<DownloadStatus>> _downloads;
    @NotNull
    private final Map<String, Job> jobs;

    public DesktopDownloadScheduler(@NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.scope = scope;
        this._downloads = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.jobs = new LinkedHashMap();
    }

    public /* synthetic */ DesktopDownloadScheduler(CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(coroutineScope);
    }

    @Override
    @NotNull
    public StateFlow<List<DownloadStatus>> observeAll() {
        return FlowKt.asStateFlow(this._downloads);
    }

    @Override
    public void enqueue(@NotNull DownloadRequest request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        DownloadStatus status = new DownloadStatus(request.getDownloadId(), request.getDownloadId(), DownloadStatus.Status.PENDING, 0.0f, null, null, 48, null);
        this.updateDownload(status);
        Job job2 = BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, status, null){
            int label;
            final /* synthetic */ DesktopDownloadScheduler this$0;
            final /* synthetic */ DownloadStatus $status;
            {
                this.this$0 = $receiver;
                this.$status = $status;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        try {
                            DesktopDownloadScheduler.access$updateDownload(this.this$0, DownloadStatus.copy$default(this.$status, null, null, DownloadStatus.Status.DOWNLOADING, 0.0f, null, null, 59, null));
                        }
                        catch (CancellationException e) {
                            DesktopDownloadScheduler.access$updateDownload(this.this$0, DownloadStatus.copy$default(this.$status, null, null, DownloadStatus.Status.CANCELLED, 0.0f, null, null, 59, null));
                        }
                        catch (Exception e) {
                            DesktopDownloadScheduler.access$updateDownload(this.this$0, DownloadStatus.copy$default(this.$status, null, null, DownloadStatus.Status.FAILED, 0.0f, null, e.getMessage(), 27, null));
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
        this.jobs.put(request.getDownloadId(), job2);
    }

    @Override
    public void cancel(@NotNull String downloadId) {
        Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
        Job job2 = this.jobs.get(downloadId);
        if (job2 != null) {
            Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
        }
        this.jobs.remove(downloadId);
    }

    @Override
    public void retry(@NotNull String downloadId) {
        Object v0;
        block3: {
            Intrinsics.checkNotNullParameter((Object)downloadId, (String)"downloadId");
            Iterable iterable = (Iterable)this._downloads.getValue();
            for (Object t : iterable) {
                DownloadStatus it = (DownloadStatus)t;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getDownloadId(), (Object)downloadId)) continue;
                v0 = t;
                break block3;
            }
            v0 = null;
        }
        DownloadStatus downloadStatus = v0;
        if (downloadStatus == null) {
            return;
        }
        DownloadStatus current = downloadStatus;
        if (current.getStatus() == DownloadStatus.Status.FAILED || current.getStatus() == DownloadStatus.Status.CANCELLED) {
            this.enqueue(new DownloadRequest(downloadId, "", "", ""));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void clearCompleted() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Iterable iterable = (Iterable)this._downloads.getValue();
        MutableStateFlow<List<DownloadStatus>> mutableStateFlow = this._downloads;
        boolean $i$f$filter = false;
        void var3_4 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            DownloadStatus it = (DownloadStatus)element$iv$iv;
            boolean bl = false;
            if (!(it.getStatus() != DownloadStatus.Status.COMPLETED)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        mutableStateFlow.setValue((Object)((List)destination$iv$iv));
    }

    private final void updateDownload(DownloadStatus status) {
        int idx;
        List current;
        block4: {
            int n;
            List $this$indexOfFirst$iv = current = CollectionsKt.toMutableList((Collection)((Collection)this._downloads.getValue()));
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                DownloadStatus it = (DownloadStatus)item$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)it.getDownloadId(), (Object)status.getDownloadId())) {
                    n = index$iv;
                    break block4;
                }
                ++index$iv;
            }
            n = idx = -1;
        }
        if (idx >= 0) {
            current.set(idx, status);
        } else {
            current.add(status);
        }
        this._downloads.setValue((Object)current);
    }

    public DesktopDownloadScheduler() {
        this(null, 1, null);
    }

    public static final /* synthetic */ void access$updateDownload(DesktopDownloadScheduler $this, DownloadStatus status) {
        $this.updateDownload(status);
    }
}

