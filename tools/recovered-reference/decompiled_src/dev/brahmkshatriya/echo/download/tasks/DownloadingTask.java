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
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.content.Context;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.DownloadingTask;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import java.util.Collection;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/DownloadingTask;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "context", "Landroid/content/Context;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "trackId", "", "index", "", "<init>", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/download/Downloader;JI)V", "getTrackId", "()J", "getIndex", "()I", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "work", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nDownloadingTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadingTask.kt\ndev/brahmkshatriya/echo/download/tasks/DownloadingTask\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,27:1\n19#2:28\n205#3:29\n*S KotlinDebug\n*F\n+ 1 DownloadingTask.kt\ndev/brahmkshatriya/echo/download/tasks/DownloadingTask\n*L\n24#1:28\n24#1:29\n*E\n"})
public final class DownloadingTask
extends BaseTask {
    private final long trackId;
    private final int index;
    @NotNull
    private final TaskType type;

    public DownloadingTask(@NotNull Context context, @NotNull Downloader downloader, long trackId, int index) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        super(context, downloader, trackId);
        this.trackId = trackId;
        this.index = index;
        this.type = TaskType.Downloading;
    }

    @Override
    public long getTrackId() {
        return this.trackId;
    }

    public final int getIndex() {
        return this.index;
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
        var16_3 = $completion;
        if ((var16_3.label & -2147483648) != 0) {
            var16_3.label -= -2147483648;
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
                /* synthetic */ Object result;
                final /* synthetic */ DownloadingTask this$0;
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
        var17_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.J$0 = trackId;
                $continuation.label = 1;
                v0 = this.getDownload((Continuation<? super DownloadEntity>)$continuation);
                if (v0 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                trackId = $continuation.J$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                download = (DownloadEntity)v0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.J$0 = trackId;
                $continuation.label = 2;
                v1 = this.getDownloader().getServer(trackId, download, (Continuation<? super Streamable.Media.Server>)$continuation);
                if (v1 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl35
            }
            case 2: {
                trackId = $continuation.J$0;
                download = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                server = (Streamable.Media.Server)v1;
                source = server.getSources().get(this.index);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)server);
                $continuation.L$2 = source;
                $continuation.J$0 = trackId;
                $continuation.label = 3;
                v2 = this.getDownloadContext((Continuation<? super DownloadContext>)$continuation);
                if (v2 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl53
            }
            case 3: {
                trackId = $continuation.J$0;
                source = (Streamable.Source)$continuation.L$2;
                server = (Streamable.Media.Server)$continuation.L$1;
                download = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl53:
                // 2 sources

                downloadContext = (DownloadContext)v2;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)server);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)source);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.J$0 = trackId;
                $continuation.label = 4;
                v3 = this.withDownloadExtension((Function2)new Function2<DownloadClient, Continuation<? super File>, Object>(this, downloadContext, source, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ DownloadingTask this$0;
                    final /* synthetic */ DownloadContext $downloadContext;
                    final /* synthetic */ Streamable.Source $source;
                    {
                        this.this$0 = $receiver;
                        this.$downloadContext = $downloadContext;
                        this.$source = $source;
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
                                void $this$withDownloadExtension;
                                ResultKt.throwOnFailure((Object)$result);
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$withDownloadExtension);
                                this.label = 1;
                                Object object2 = $this$withDownloadExtension.download(this.this$0.getProgressFlow(), this.$downloadContext, this.$source, (Continuation<? super File>)((Continuation)this));
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
                if (v3 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl72
            }
            case 4: {
                trackId = $continuation.J$0;
                downloadContext = (DownloadContext)$continuation.L$3;
                source = (Streamable.Source)$continuation.L$2;
                server = (Streamable.Media.Server)$continuation.L$1;
                download = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl72:
                // 2 sources

                file = (File)v3;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)server);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)source);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$4 = file;
                $continuation.J$0 = trackId;
                $continuation.label = 5;
                v4 = this.getDownload((Continuation<? super DownloadEntity>)$continuation);
                if (v4 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl93
            }
            case 5: {
                trackId = $continuation.J$0;
                file = (File)$continuation.L$4;
                downloadContext = (DownloadContext)$continuation.L$3;
                source = (Streamable.Source)$continuation.L$2;
                server = (Streamable.Media.Server)$continuation.L$1;
                download = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = $result;
lbl93:
                // 2 sources

                download = (DownloadEntity)v4;
                var9_16 = Serializer.INSTANCE;
                $this$toJson\1 = CollectionsKt.plus((Collection)download.getToMergeFiles(), (Object)file.toString());
                $i$f$toJson\1\24 = false;
                var12_19 = this_\1.getJson();
                value\2 = $this$toJson\1;
                $i$f$encodeToString\2\28 = false;
                this_\2.getSerializersModule();
                download = DownloadEntity.copy$default(download, 0L, null, null, null, null, null, null, false, null, null, null, this_\2.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), (Object)value\2), null, null, null, false, 63487, null);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)server);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)source);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)file);
                $continuation.J$0 = trackId;
                $continuation.label = 6;
                v5 = this.getDao().insertDownloadEntity(download, (Continuation<? super Long>)$continuation);
                if (v5 == var17_5) {
                    return var17_5;
                }
                ** GOTO lbl124
            }
            case 6: {
                trackId = $continuation.J$0;
                file = (File)$continuation.L$4;
                downloadContext = (DownloadContext)$continuation.L$3;
                source = (Streamable.Source)$continuation.L$2;
                server = (Streamable.Media.Server)$continuation.L$1;
                download = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v5 = $result;
lbl124:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

