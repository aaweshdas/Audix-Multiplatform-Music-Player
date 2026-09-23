/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.IntSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.content.Context;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.DownloadingTask;
import dev.brahmkshatriya.echo.download.tasks.LoadingTask;
import dev.brahmkshatriya.echo.download.tasks.MergingTask;
import dev.brahmkshatriya.echo.download.tasks.SaveToUnifiedTask;
import dev.brahmkshatriya.echo.download.tasks.TaggingTask;
import dev.brahmkshatriya.echo.download.tasks.TaskManager;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/LoadingTask;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "context", "Landroid/content/Context;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "trackId", "", "<init>", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/download/Downloader;J)V", "getTrackId", "()J", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "manager", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager;", "extensionsList", "Lkotlinx/coroutines/flow/StateFlow;", "", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "totalSize", "work", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nLoadingTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoadingTask.kt\ndev/brahmkshatriya/echo/download/tasks/LoadingTask\n+ 2 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 5 Json.kt\nkotlinx/serialization/json/Json\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n33#2,5:71\n1#3:76\n19#4:77\n19#4:83\n205#5:78\n205#5:84\n1563#6:79\n1634#6,3:80\n1563#6:85\n1634#6,3:86\n*S KotlinDebug\n*F\n+ 1 LoadingTask.kt\ndev/brahmkshatriya/echo/download/tasks/LoadingTask\n*L\n32#1:71,5\n36#1:77\n56#1:83\n36#1:78\n56#1:84\n53#1:79\n53#1:80,3\n61#1:85\n61#1:86,3\n*E\n"})
public final class LoadingTask
extends BaseTask {
    @NotNull
    private final Context context;
    private final long trackId;
    @NotNull
    private final TaskType type;
    @NotNull
    private final TaskManager manager;
    @NotNull
    private final StateFlow<List<MusicExtension>> extensionsList;
    private final long totalSize;

    public LoadingTask(@NotNull Context context, @NotNull Downloader downloader, long trackId) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        super(context, downloader, trackId);
        this.context = context;
        this.trackId = trackId;
        this.type = TaskType.Loading;
        this.manager = downloader.getTaskManager();
        this.extensionsList = downloader.getExtensionLoader().getMusic();
        this.totalSize = 3L;
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
        block29: {
            if (!($completion instanceof work.1)) ** GOTO lbl-1000
            var25_3 = $completion;
            if ((var25_3.label & -2147483648) != 0) {
                var25_3.label -= -2147483648;
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
                    int I$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ LoadingTask this$0;
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
            var26_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    this.getProgressFlow().setValue((Object)new Progress(this.totalSize, 0L, 0L, 4, null));
                    download = new Ref.ObjectRef();
                    var22_7 = download;
                    $continuation.L$0 = download;
                    $continuation.L$1 = var22_7;
                    $continuation.J$0 = trackId;
                    $continuation.label = 1;
                    v0 = this.getDao().getDownloadEntity(trackId, (Continuation<? super DownloadEntity>)$continuation);
                    if (v0 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl29
                }
                case 1: {
                    trackId = $continuation.J$0;
                    var22_7 = (Ref.ObjectRef)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl29:
                    // 2 sources

                    Intrinsics.checkNotNull((Object)v0);
                    var22_7.element = v0;
                    $continuation.L$0 = download;
                    $continuation.L$1 = null;
                    $continuation.J$0 = trackId;
                    $continuation.label = 2;
                    v1 = ExtensionUtils.INSTANCE.getExtensionOrThrow((Flow)this.extensionsList, ((DownloadEntity)download.element).getExtensionId(), $continuation);
                    if (v1 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl44
                }
                case 2: {
                    trackId = $continuation.J$0;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl44:
                    // 2 sources

                    extension = (MusicExtension)v1;
                    if (((DownloadEntity)download.element).getLoaded()) ** GOTO lbl105
                    var7_9 = ExtensionUtils.INSTANCE;
                    $this$getAs_u2d0E7RQCE\1 = extension;
                    $i$f$getAs-0E7RQCE\1\32 = 0;
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\1);
                    $continuation.J$0 = trackId;
                    $continuation.I$0 = $i$f$getAs-0E7RQCE\1\32;
                    $continuation.label = 3;
                    v2 = this_\1.get-0E7RQCE($this$getAs_u2d0E7RQCE\1, (Function2)new Function2<ExtensionClient, Continuation<? super Track>, Object>(null, download){
                        Object L$1;
                        int label;
                        private /* synthetic */ Object L$0;
                        final /* synthetic */ Ref.ObjectRef $download$inlined;
                        Object L$2;
                        Object L$3;
                        int I$0;
                        {
                            this.$download$inlined = objectRef;
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
                                    void $completion\1;
                                    void $this$get;
                                    ResultKt.throwOnFailure((Object)$result);
                                    Object v0 = $this$get;
                                    if (!(v0 instanceof TrackClient)) {
                                        v0 = null;
                                    }
                                    TrackClient trackClient = v0;
                                    if (trackClient == null) {
                                        String string2 = Reflection.getOrCreateKotlinClass(TrackClient.class).getSimpleName();
                                        if (string2 != null) throw new ClientException.NotSupported(string2);
                                        string2 = "Unknown Class";
                                        throw new ClientException.NotSupported(string2);
                                    }
                                    TrackClient client = trackClient;
                                    Continuation continuation = (Continuation)this;
                                    TrackClient trackClient2 = client;
                                    int n = 0;
                                    Object object2 = ((DownloadEntity)this.$download$inlined.element).getTrack-d1pmJ48();
                                    ResultKt.throwOnFailure((Object)object2);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                    this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable((Object)trackClient2);
                                    this.I$0 = n;
                                    this.label = 1;
                                    Object object3 = trackClient2.loadTrack((Track)object2, true, (Continuation<? super Track>)this);
                                    if (object3 != object) return object3;
                                    return object;
                                }
                                case 1: {
                                    int n = this.I$0;
                                    TrackClient trackClient = (TrackClient)this.L$3;
                                    Continuation continuation = (Continuation)this.L$2;
                                    TrackClient client = (TrackClient)this.L$1;
                                    ResultKt.throwOnFailure((Object)$result);
                                    Object object3 = $result;
                                    return object3;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                            var var3_3 = new /* invalid duplicate definition of identical inner class */;
                            var3_3.L$0 = value2;
                            return (Continuation)var3_3;
                        }

                        public final Object invoke(ExtensionClient p1, Continuation<? super Track> p2) {
                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                        }
                    }, $continuation);
                    if (v2 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl70
                }
                case 3: {
                    $i$f$getAs-0E7RQCE\1\32 = $continuation.I$0;
                    trackId = $continuation.J$0;
                    $this$getAs_u2d0E7RQCE\1 = (Extension)$continuation.L$3;
                    this_\1 = (ExtensionUtils)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = ((Result)$result).unbox-impl();
lbl70:
                    // 2 sources

                    this_\1 = v2;
                    ResultKt.throwOnFailure((Object)this_\1);
                    track = (Track)this_\1;
                    this_\1 = track.getServers();
                    if (this_\1.isEmpty()) {
                        $i$a$-ifEmpty-LoadingTask$work$2\2\35\0 = false;
                        throw new Exception(track.getTitle() + ": No servers found");
                    }
                    v3 = (DownloadEntity)download.element;
                    this_\1 = Serializer.INSTANCE;
                    $this$toJson\3 = track;
                    $i$f$toJson\3\36 = false;
                    var10_15 = this_\3.getJson();
                    value\4 = $this$toJson\3;
                    $i$f$encodeToString\4\77 = false;
                    this_\4.getSerializersModule();
                    download.element = DownloadEntity.copy$default(v3, 0L, null, null, null, null, this_\4.encodeToString((SerializationStrategy)Track.Companion.serializer(), (Object)value\4), null, true, null, null, null, null, null, null, null, false, 65375, null);
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)track);
                    $continuation.L$3 = null;
                    $continuation.J$0 = trackId;
                    $continuation.label = 4;
                    v4 = this.getDao().insertDownloadEntity((DownloadEntity)download.element, (Continuation<? super Long>)$continuation);
                    if (v4 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl105
                }
                case 4: {
                    trackId = $continuation.J$0;
                    track = (Track)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v4 = $result;
lbl105:
                    // 3 sources

                    this.getProgressFlow().setValue((Object)new Progress(this.totalSize, 1L, 0L, 4, null));
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = null;
                    $continuation.J$0 = trackId;
                    $continuation.label = 5;
                    v5 = this.getDownloadContext((Continuation<? super DownloadContext>)$continuation);
                    if (v5 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl121
                }
                case 5: {
                    trackId = $continuation.J$0;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl121:
                    // 2 sources

                    downloadContext = (DownloadContext)v5;
                    if (((DownloadEntity)download.element).getStreamableId() != null) ** GOTO lbl159
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = downloadContext;
                    $continuation.J$0 = trackId;
                    $continuation.label = 6;
                    v6 = this.withDownloadExtension((Function2)new Function2<DownloadClient, Continuation<? super Streamable>, Object>(downloadContext, null){
                        int label;
                        private /* synthetic */ Object L$0;
                        final /* synthetic */ DownloadContext $downloadContext;
                        {
                            this.$downloadContext = $downloadContext;
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
                                    Object object2 = $this$withDownloadExtension.selectServer(this.$downloadContext, (Continuation<? super Streamable>)((Continuation)this));
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

                        public final Object invoke(DownloadClient p1, Continuation<? super Streamable> p2) {
                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                        }
                    }, $continuation);
                    if (v6 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl139
                }
                case 6: {
                    trackId = $continuation.J$0;
                    downloadContext = (DownloadContext)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v6 = $result;
lbl139:
                    // 2 sources

                    selected = (Streamable)v6;
                    download.element = DownloadEntity.copy$default((DownloadEntity)download.element, 0L, null, null, null, null, null, null, false, null, selected.getId(), null, null, null, null, null, false, 65023, null);
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = downloadContext;
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)selected);
                    $continuation.J$0 = trackId;
                    $continuation.label = 7;
                    v7 = this.getDao().insertDownloadEntity((DownloadEntity)download.element, (Continuation<? super Long>)$continuation);
                    if (v7 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl159
                }
                case 7: {
                    trackId = $continuation.J$0;
                    selected = (Streamable)$continuation.L$3;
                    downloadContext = (DownloadContext)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v7 = $result;
lbl159:
                    // 3 sources

                    this.getProgressFlow().setValue((Object)new Progress(this.totalSize, 2L, 0L, 4, null));
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = downloadContext;
                    $continuation.L$3 = null;
                    $continuation.J$0 = trackId;
                    $continuation.label = 8;
                    v8 = this.getDownloader().getServer(trackId, (DownloadEntity)download.element, (Continuation<? super Streamable.Media.Server>)$continuation);
                    if (v8 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl177
                }
                case 8: {
                    trackId = $continuation.J$0;
                    downloadContext = (DownloadContext)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v8 = $result;
lbl177:
                    // 2 sources

                    server = (Streamable.Media.Server)v8;
                    $i$f$toJson\3\36 = ((DownloadEntity)download.element).getIndexes();
                    if (!$i$f$toJson\3\36.isEmpty()) break;
                    $i$a$-ifEmpty-LoadingTask$work$indexes$1\5\51\0 = 0;
                    $continuation.L$0 = download;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                    $continuation.L$3 = server;
                    $continuation.J$0 = trackId;
                    $continuation.I$0 = $i$a$-ifEmpty-LoadingTask$work$indexes$1\5\51\0;
                    $continuation.label = 9;
                    v9 = this.withDownloadExtension((Function2)new Function2<DownloadClient, Continuation<? super List<? extends Streamable.Source>>, Object>(downloadContext, server, null){
                        int label;
                        private /* synthetic */ Object L$0;
                        final /* synthetic */ DownloadContext $downloadContext;
                        final /* synthetic */ Streamable.Media.Server $server;
                        {
                            this.$downloadContext = $downloadContext;
                            this.$server = $server;
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
                                    Object object2 = $this$withDownloadExtension.selectSources(this.$downloadContext, this.$server, (Continuation<? super List<? extends Streamable.Source>>)((Continuation)this));
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

                        public final Object invoke(DownloadClient p1, Continuation<? super List<? extends Streamable.Source>> p2) {
                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                        }
                    }, $continuation);
                    if (v9 == var26_5) {
                        return var26_5;
                    }
                    ** GOTO lbl201
                }
                case 9: {
                    $i$a$-ifEmpty-LoadingTask$work$indexes$1\5\51\0 = $continuation.I$0;
                    trackId = $continuation.J$0;
                    server = (Streamable.Media.Server)$continuation.L$3;
                    downloadContext = (DownloadContext)$continuation.L$2;
                    extension = (MusicExtension)$continuation.L$1;
                    download = (Ref.ObjectRef)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v9 = $result;
lbl201:
                    // 2 sources

                    sources\5 = (List)v9;
                    $this$map\6 = sources\5;
                    $i$f$map\6\53 = false;
                    var14_26 = $this$map\6;
                    destination\7 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\6, (int)10));
                    $i$f$mapTo\7\79 = false;
                    for (T item\7 : $this$mapTo\7) {
                        var19_35 = (Streamable.Source)item\7;
                        var20_36 = destination\7;
                        $i$a$-map-LoadingTask$work$indexes$1$1\8\81\5 = false;
                        var20_36.add(Boxing.boxInt((int)server.getSources().indexOf(it\8)));
                    }
                    v10 = (List)destination\7;
                    break block29;
                }
            }
            v10 = $i$f$toJson\3\36;
        }
        indexes = (List)v10;
        if (indexes.isEmpty()) {
            throw new Exception("No files to download");
        }
        v11 = (DownloadEntity)download.element;
        $i$f$toJson\3\36 = Serializer.INSTANCE;
        $this$toJson\9 = indexes;
        $i$f$toJson\9\56 = false;
        $this$map\6 = this_\9.getJson();
        value\10 = $this$toJson\9;
        $i$f$encodeToString\10\83 = false;
        this_\10.getSerializersModule();
        download.element = DownloadEntity.copy$default(v11, 0L, null, null, null, null, null, null, false, null, null, this_\10.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)IntSerializer.INSTANCE), (Object)value\10), null, null, null, null, false, 64511, null);
        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)download);
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)server);
        $continuation.L$4 = indexes;
        $continuation.J$0 = trackId;
        $continuation.label = 10;
        v12 = this.getDao().insertDownloadEntity((DownloadEntity)download.element, (Continuation<? super Long>)$continuation);
        if (v12 == var26_5) {
            return var26_5;
        }
        ** GOTO lbl254
        {
            case 10: {
                trackId = $continuation.J$0;
                indexes = (List)$continuation.L$4;
                server = (Streamable.Media.Server)$continuation.L$3;
                downloadContext = (DownloadContext)$continuation.L$2;
                extension = (MusicExtension)$continuation.L$1;
                download = (Ref.ObjectRef)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v12 = $result;
lbl254:
                // 2 sources

                this.getProgressFlow().setValue((Object)new Progress(this.totalSize, 3L, 0L, 4, null));
                $this$toJson\9 = indexes;
                var22_7 = TaskManager.Companion;
                $i$f$map\11\61 = false;
                this_\10 = $this$map\11;
                destination\12 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\11, (int)10));
                $i$f$mapTo\12\85 = false;
                for (T item\12 : $this$mapTo\12) {
                    var17_32 = ((Number)item\12).intValue();
                    var23_38 = destination\12;
                    $i$a$-map-LoadingTask$work$requests$1\13\87\0 = false;
                    var23_38.add(new DownloadingTask(this.context, this.getDownloader(), trackId, (int)index\13));
                }
                requests = var22_7.toQueueItem((List)destination\12);
                mergeRequest = TaskManager.Companion.toQueueItem(new MergingTask(this.context, this.getDownloader(), trackId));
                taggingRequest = TaskManager.Companion.toQueueItem(new TaggingTask(this.context, this.getDownloader(), trackId));
                saveToUnified = TaskManager.Companion.toQueueItem(new SaveToUnifiedTask(this.context, this.getDownloader(), trackId));
                var13_25 = new TaskManager.QueueItem[]{requests, mergeRequest, taggingRequest, saveToUnified};
                this.manager.enqueue(trackId, CollectionsKt.listOf((Object[])var13_25));
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

