/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.content.Context;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.MergingTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/MergingTask;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "context", "Landroid/content/Context;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "trackId", "", "<init>", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/download/Downloader;J)V", "getTrackId", "()J", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "work", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MergingTask
extends BaseTask {
    private final long trackId;
    @NotNull
    private final TaskType type;

    public MergingTask(@NotNull Context context, @NotNull Downloader downloader, long trackId) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        super(context, downloader, trackId);
        this.trackId = trackId;
        this.type = TaskType.Merging;
    }

    @Override
    public long getTrackId() {
        return this.trackId;
    }

    @Override
    @NotNull
    public TaskType getType() {
        return this.type;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object work(long trackId, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof work.1)) ** GOTO lbl-1000
        var8_3 = $completion;
        if ((var8_3.label & -2147483648) != 0) {
            var8_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                long J$0;
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ MergingTask this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.work(0L, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var9_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.J$0 = trackId;
                $continuation.label = 1;
                v0 = this.getDownloadContext((Continuation<? super DownloadContext>)$continuation);
                if (v0 == var9_5) {
                    return var9_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                trackId = $continuation.J$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                downloadContext = (DownloadContext)v0;
                $continuation.L$0 = downloadContext;
                $continuation.J$0 = trackId;
                $continuation.label = 2;
                v1 = this.getDownload((Continuation<? super DownloadEntity>)$continuation);
                if (v1 == var9_5) {
                    return var9_5;
                }
                ** GOTO lbl35
            }
            case 2: {
                trackId = $continuation.J$0;
                downloadContext = (DownloadContext)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                download = (DownloadEntity)v1;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$1 = download;
                $continuation.J$0 = trackId;
                $continuation.label = 3;
                v2 = this.withDownloadExtension((Function2)new Function2<DownloadClient, Continuation<? super File>, Object>(this, downloadContext, download, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ MergingTask this$0;
                    final /* synthetic */ DownloadContext $downloadContext;
                    final /* synthetic */ DownloadEntity $download;
                    {
                        this.this$0 = $receiver;
                        this.$downloadContext = $downloadContext;
                        this.$download = $download;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object $result) {
                        DownloadClient downloadClient = (DownloadClient)this.L$0;
                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                Collection<File> collection;
                                void $this$mapTo\2;
                                void $this$map\1;
                                void $this$withDownloadExtension;
                                ResultKt.throwOnFailure((Object)$result);
                                Iterable iterable = this.$download.getToMergeFiles();
                                DownloadContext downloadContext = this.$downloadContext;
                                MutableStateFlow<Progress> mutableStateFlow = this.this$0.getProgressFlow();
                                void var12_7 = $this$withDownloadExtension;
                                boolean bl = false;
                                void var5_9 = $this$map\1;
                                Collection collection2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                                boolean bl2 = false;
                                for (T t : $this$mapTo\2) {
                                    void it\3;
                                    String string2 = (String)t;
                                    collection = collection2;
                                    boolean bl3 = false;
                                    collection.add(new File((String)it\3));
                                }
                                collection = (List)collection2;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$withDownloadExtension);
                                this.label = 1;
                                Object object2 = var12_7.merge(mutableStateFlow, downloadContext, (List<? extends File>)collection, (Continuation<? super File>)((Continuation)this));
                                if (object2 != object) return object2;
                                return object;
                            }
                            case 1: {
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

                    public final Object invoke(DownloadClient p1, Continuation<? super File> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }, $continuation);
                if (v2 == var9_5) {
                    return var9_5;
                }
                ** GOTO lbl50
            }
            case 3: {
                trackId = $continuation.J$0;
                download = (DownloadEntity)$continuation.L$1;
                downloadContext = (DownloadContext)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl50:
                // 2 sources

                file = (File)v2;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)file);
                $continuation.J$0 = trackId;
                $continuation.label = 4;
                v3 = this.getDao().insertDownloadEntity(DownloadEntity.copy$default(download, 0L, null, null, null, null, null, null, false, null, null, null, null, file.toString(), null, null, false, 61439, null), (Continuation<? super Long>)$continuation);
                if (v3 == var9_5) {
                    return var9_5;
                }
                ** GOTO lbl67
            }
            case 4: {
                trackId = $continuation.J$0;
                file = (File)$continuation.L$2;
                download = (DownloadEntity)$continuation.L$1;
                downloadContext = (DownloadContext)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl67:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

