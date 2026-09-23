/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.serialization.SerializationStrategy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistEditClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.download.tasks.SaveToUnifiedTask;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension;
import dev.brahmkshatriya.echo.utils.Serializer;
import dev.brahmkshatriya.echo.utils.image.ImageUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/SaveToUnifiedTask;", "Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "app", "Landroid/content/Context;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "trackId", "", "<init>", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/download/Downloader;J)V", "getTrackId", "()J", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "work", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nSaveToUnifiedTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SaveToUnifiedTask.kt\ndev/brahmkshatriya/echo/download/tasks/SaveToUnifiedTask\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n19#2:60\n205#3:61\n33#4,5:62\n1740#5,3:67\n*S KotlinDebug\n*F\n+ 1 SaveToUnifiedTask.kt\ndev/brahmkshatriya/echo/download/tasks/SaveToUnifiedTask\n*L\n28#1:60\n28#1:61\n39#1:62,5\n55#1:67,3\n*E\n"})
public final class SaveToUnifiedTask
extends BaseTask {
    @NotNull
    private final Context app;
    private final long trackId;
    @NotNull
    private final TaskType type;

    public SaveToUnifiedTask(@NotNull Context app, @NotNull Downloader downloader, long trackId) {
        Intrinsics.checkNotNullParameter((Object)app, (String)"app");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        super(app, downloader, trackId);
        this.app = app;
        this.trackId = trackId;
        this.type = TaskType.Saving;
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
        var23_3 = $completion;
        if ((var23_3.label & -2147483648) != 0) {
            var23_3.label -= -2147483648;
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
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ SaveToUnifiedTask this$0;
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
        var24_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.J$0 = trackId;
                $continuation.label = 1;
                v0 = this.getDownload((Continuation<? super DownloadEntity>)$continuation);
                if (v0 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                trackId = $continuation.J$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                if ((old = (DownloadEntity)v0).getFinalFile() == null) {
                    return Unit.INSTANCE;
                }
                var6_7 = Serializer.INSTANCE;
                var7_8 = old.getTrack-d1pmJ48();
                ResultKt.throwOnFailure((Object)var7_8);
                $this$toJson\1 = UnifiedExtension.Companion.withExtensionId$default(UnifiedExtension.Companion, (Track)var7_8, old.getExtensionId(), Boxing.boxBoolean((boolean)false), false, 4, null);
                $i$f$toJson\1\28 = false;
                var9_11 = this_\1.getJson();
                value\2 = $this$toJson\1;
                $i$f$encodeToString\2\60 = false;
                this_\2.getSerializersModule();
                download = DownloadEntity.copy$default(old, 0L, null, null, null, null, this_\2.encodeToString((SerializationStrategy)Track.Companion.serializer(), value\2), null, false, null, null, null, null, null, null, null, false, 65503, null);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = download;
                $continuation.J$0 = trackId;
                $continuation.label = 2;
                v1 = this.getDao().insertDownloadEntity(download, (Continuation<? super Long>)$continuation);
                if (v1 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl50
            }
            case 2: {
                trackId = $continuation.J$0;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl50:
                // 2 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = download;
                $continuation.J$0 = trackId;
                $continuation.label = 3;
                v2 = this.getDownloadContext((Continuation<? super DownloadContext>)$continuation);
                if (v2 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl64
            }
            case 3: {
                trackId = $continuation.J$0;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl64:
                // 2 sources

                downloadContext = (DownloadContext)v2;
                context = downloadContext.getContext();
                allDownloads = this.getDao().getDownloadsForContext(download.getContextId());
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = download;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$3 = context;
                $continuation.L$4 = allDownloads;
                $continuation.J$0 = trackId;
                $continuation.label = 4;
                v3 = ExtensionUtils.INSTANCE.getExtensionOrThrow((Flow)this.getDownloader().getExtensionLoader().getMusic(), UnifiedExtension.Companion.getMetadata().getId(), $continuation);
                if (v3 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl87
            }
            case 4: {
                trackId = $continuation.J$0;
                allDownloads = (List)$continuation.L$4;
                context = (EchoMediaItem)$continuation.L$3;
                downloadContext = (DownloadContext)$continuation.L$2;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl87:
                // 2 sources

                unifiedExtension = (MusicExtension)v3;
                if (context == null) ** GOTO lbl123
                value\2 = ExtensionUtils.INSTANCE;
                $this$getAs_u2d0E7RQCE\3 = unifiedExtension;
                $i$f$getAs-0E7RQCE\3\39 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = download;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$3 = context;
                $continuation.L$4 = allDownloads;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)unifiedExtension);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)this_\3);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\3);
                $continuation.J$0 = trackId;
                $continuation.I$0 = $i$f$getAs-0E7RQCE\3\39;
                $continuation.label = 5;
                v4 = this_\3.get-0E7RQCE($this$getAs_u2d0E7RQCE\3, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null, this, context, allDownloads, download){
                    Object L$1;
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ SaveToUnifiedTask this$0;
                    final /* synthetic */ EchoMediaItem $context$inlined;
                    final /* synthetic */ List $allDownloads$inlined;
                    final /* synthetic */ DownloadEntity $download$inlined;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    Object L$7;
                    int I$0;
                    {
                        this.this$0 = saveToUnifiedTask;
                        this.$context$inlined = echoMediaItem;
                        this.$allDownloads$inlined = list2;
                        this.$download$inlined = downloadEntity;
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
                                if (!(v0 instanceof PlaylistEditClient)) {
                                    v0 = null;
                                }
                                v1 = v0;
                                if (v1 == null) {
                                    v2 = Reflection.getOrCreateKotlinClass(PlaylistEditClient.class).getSimpleName();
                                    if (v2 == null) {
                                        v2 = "Unknown Class";
                                    }
                                    throw new ClientException.NotSupported(v2);
                                }
                                client = v1;
                                var5_7 = (Continuation)this;
                                $this$work_u24lambda_u243\1 = client;
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = 0;
                                db\1 = ((UnifiedExtension)$this$work_u24lambda_u243\1).getDb();
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = $this$work_u24lambda_u243\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                                this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                                this.label = 1;
                                v3 = db\1.getOrCreate(SaveToUnifiedTask.access$getApp$p(this.this$0), this.$context$inlined, (Continuation<? super Playlist>)this);
                                if (v3 == var3_3) {
                                    return var3_3;
                                }
                                ** GOTO lbl39
                            }
                            case 1: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v3 = $result;
lbl39:
                                // 2 sources

                                playlist\1 = (Playlist)v3;
                                var10_22 = Feed.Companion;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = $this$work_u24lambda_u243\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                                this.L$5 = playlist\1;
                                this.L$6 = var10_22;
                                this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                                this.label = 2;
                                v4 = ((UnifiedExtension)$this$work_u24lambda_u243\1).loadTracks(playlist\1, (Continuation<? super Feed<Track>>)this);
                                if (v4 == var3_3) {
                                    return var3_3;
                                }
                                ** GOTO lbl64
                            }
                            case 2: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                var10_22 = (Feed.Companion)this.L$6;
                                playlist\1 = (Playlist)this.L$5;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v4 = $result;
lbl64:
                                // 2 sources

                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = $this$work_u24lambda_u243\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                                this.L$5 = playlist\1;
                                this.L$6 = null;
                                this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                                this.label = 3;
                                v5 = var10_22.loadAll((Feed)v4, this);
                                if (v5 == var3_3) {
                                    return var3_3;
                                }
                                ** GOTO lbl86
                            }
                            case 3: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                playlist\1 = (Playlist)this.L$5;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v5 = $result;
lbl86:
                                // 2 sources

                                tracks\1 = (List)v5;
                                $this$all\2 = this.$allDownloads$inlined;
                                $i$f$all\2\149 = false;
                                if (!($this$all\2 instanceof Collection) || !((Collection)$this$all\2).isEmpty()) ** GOTO lbl92
                                v6 = true;
                                ** GOTO lbl99
lbl92:
                                // 2 sources

                                for (T element\2 : $this$all\2) {
                                    it\3 = (DownloadEntity)element\2;
                                    $i$a$-all-SaveToUnifiedTask$work$2$1\3\155\1 = false;
                                    if (it\3.getFinalFile() != null) continue;
                                    v6 = false;
                                    ** GOTO lbl99
                                }
                                v6 = true;
lbl99:
                                // 3 sources

                                if (!v6) break;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = $this$work_u24lambda_u243\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                                this.L$5 = playlist\1;
                                this.L$6 = SpillingKt.nullOutSpilledVariable((Object)tracks\1);
                                this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                                this.label = 4;
                                v7 = ((UnifiedExtension)$this$work_u24lambda_u243\1).removeTracksFromPlaylist(playlist\1, tracks\1, CollectionsKt.toList((Iterable)((Iterable)CollectionsKt.getIndices((Collection)tracks\1))), (Continuation<? super Unit>)this);
                                if (v7 == var3_3) {
                                    return var3_3;
                                }
                                ** GOTO lbl123
                            }
                            case 4: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                tracks\1 = (List)this.L$6;
                                playlist\1 = (Playlist)this.L$5;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v7 = $result;
lbl123:
                                // 2 sources

                                $this$sortedBy\4 = this.$allDownloads$inlined;
                                $i$f$sortedBy\4\151 = false;
                                sorted\1 = CollectionsKt.sortedWith((Iterable)$this$sortedBy\4, (Comparator)new Comparator(){

                                    /*
                                     * WARNING - void declaration
                                     */
                                    public final int compare(T a, T b) {
                                        void it\2;
                                        DownloadEntity downloadEntity = (DownloadEntity)a;
                                        boolean bl = false;
                                        Comparable comparable = downloadEntity.getSortOrder();
                                        downloadEntity = (DownloadEntity)b;
                                        Comparable comparable2 = comparable;
                                        boolean bl2 = false;
                                        return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)it\2.getSortOrder());
                                    }
                                });
                                $this$sortedBy\4 = sorted\1;
                                var19_35 = 0;
                                var20_36 = CollectionsKt.emptyList();
                                var11_37 = playlist\1;
                                var10_22 = (UnifiedExtension)$this$work_u24lambda_u243\1;
                                $i$f$map\5\152 = false;
                                element\2 = $this$map\5;
                                destination\6 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5, (int)10));
                                $i$f$mapTo\6\158 = false;
                                for (T item\6 : $this$mapTo\6) {
                                    var23_40 = (DownloadEntity)item\6;
                                    var24_41 = destination\6;
                                    $i$a$-map-SaveToUnifiedTask$work$2$2\7\160\1 = false;
                                    var26_43 = it\7.getTrack-d1pmJ48();
                                    ResultKt.throwOnFailure((Object)var26_43);
                                    var24_41.add((Track)var26_43);
                                }
                                var24_41 = (List)destination\6;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$work_u24lambda_u243\1);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                                this.L$5 = SpillingKt.nullOutSpilledVariable((Object)playlist\1);
                                this.L$6 = SpillingKt.nullOutSpilledVariable((Object)tracks\1);
                                this.L$7 = SpillingKt.nullOutSpilledVariable((Object)sorted\1);
                                this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                                this.label = 5;
                                v8 = var10_22.addTracksToPlaylist(var11_37, var20_36, var19_35, (List<Track>)var24_41, (Continuation<? super Unit>)this);
                                if (v8 == var3_3) {
                                    return var3_3;
                                }
                                ** GOTO lbl171
                            }
                            case 5: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                sorted\1 = (List)this.L$7;
                                tracks\1 = (List)this.L$6;
                                playlist\1 = (Playlist)this.L$5;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v8 = $result;
lbl171:
                                // 2 sources

                                v9 = Unit.INSTANCE;
                                ** GOTO lbl201
                            }
                        }
                        v10 = (UnifiedExtension)$this$work_u24lambda_u243\1;
                        v11 = tracks\1.size();
                        var13_26 = this.$download$inlined.getTrack-d1pmJ48();
                        ResultKt.throwOnFailure((Object)var13_26);
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$work_u24lambda_u243\1);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)db\1);
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)playlist\1);
                        this.L$6 = SpillingKt.nullOutSpilledVariable((Object)tracks\1);
                        this.I$0 = $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0;
                        this.label = 6;
                        v12 = v10.addTracksToPlaylist(playlist\1, tracks\1, v11, CollectionsKt.listOf((Object)var13_26), (Continuation<? super Unit>)this);
                        if (v12 == var3_3) {
                            return var3_3;
                        }
                        ** GOTO lbl200
                        {
                            case 6: {
                                $i$a$-getAs-0E7RQCE-SaveToUnifiedTask$work$2\1\36\0 = this.I$0;
                                tracks\1 = (List)this.L$6;
                                playlist\1 = (Playlist)this.L$5;
                                db\1 = (UnifiedDatabase)this.L$4;
                                $this$work_u24lambda_u243\1 = (PlaylistEditClient)this.L$3;
                                $completion\1 = (Continuation)this.L$2;
                                client = (PlaylistEditClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v12 = $result;
lbl200:
                                // 2 sources

                                v9 = Unit.INSTANCE;
lbl201:
                                // 2 sources

                                return v9;
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
                }, $continuation);
                if (v4 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl121
            }
            case 5: {
                $i$f$getAs-0E7RQCE\3\39 = $continuation.I$0;
                trackId = $continuation.J$0;
                $this$getAs_u2d0E7RQCE\3 = (Extension)$continuation.L$7;
                this_\3 = (ExtensionUtils)$continuation.L$6;
                unifiedExtension = (MusicExtension)$continuation.L$5;
                allDownloads = (List)$continuation.L$4;
                context = (EchoMediaItem)$continuation.L$3;
                downloadContext = (DownloadContext)$continuation.L$2;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = ((Result)$result).unbox-impl();
lbl121:
                // 2 sources

                this_\3 = v4;
                ResultKt.throwOnFailure((Object)this_\3);
lbl123:
                // 2 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = download;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$3 = context;
                $continuation.L$4 = allDownloads;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)unifiedExtension);
                $continuation.L$6 = null;
                $continuation.L$7 = null;
                $continuation.J$0 = trackId;
                $continuation.label = 6;
                v5 = this.getDao().insertDownloadEntity(DownloadEntity.copy$default(download, 0L, null, null, null, null, null, null, false, null, null, null, null, null, null, null, true, 32767, null), (Continuation<? super Long>)$continuation);
                if (v5 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl147
            }
            case 6: {
                trackId = $continuation.J$0;
                unifiedExtension = (MusicExtension)$continuation.L$5;
                allDownloads = (List)$continuation.L$4;
                context = (EchoMediaItem)$continuation.L$3;
                downloadContext = (DownloadContext)$continuation.L$2;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v5 = $result;
lbl147:
                // 2 sources

                if (context != null) ** GOTO lbl152
                $i$f$getAs-0E7RQCE\3\39 = download.getTrack-d1pmJ48();
                ResultKt.throwOnFailure((Object)$i$f$getAs-0E7RQCE\3\39);
                v6 = (EchoMediaItem)$i$f$getAs-0E7RQCE\3\39;
                ** GOTO lbl165
lbl152:
                // 1 sources

                $this$all\4 = allDownloads;
                $i$f$all\4\55 = false;
                if (!($this$all\4 instanceof Collection) || !((Collection)$this$all\4).isEmpty()) ** GOTO lbl157
                v7 = true;
                ** GOTO lbl164
lbl157:
                // 2 sources

                for (T element\4 : $this$all\4) {
                    it\5 = (DownloadEntity)element\4;
                    $i$a$-all-SaveToUnifiedTask$work$item$1\5\68\0 = false;
                    if (it\5.getFinalFile() != null) continue;
                    v7 = false;
                    ** GOTO lbl164
                }
                v7 = true;
lbl164:
                // 3 sources

                v6 = v7 != false ? context : null;
lbl165:
                // 2 sources

                if (v6 == null) {
                    return Unit.INSTANCE;
                }
                item = v6;
                var20_24 = item.getTitle();
                var19_25 = this.app;
                var18_26 = this;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)old);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)download);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)downloadContext);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)context);
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)allDownloads);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)unifiedExtension);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$7 = var18_26;
                $continuation.L$8 = var19_25;
                $continuation.L$9 = var20_24;
                $continuation.J$0 = trackId;
                $continuation.label = 7;
                v8 = ImageUtils.INSTANCE.loadDrawable(item.getCover(), this.app, (Continuation<? super Drawable>)$continuation);
                if (v8 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl201
            }
            case 7: {
                trackId = $continuation.J$0;
                var20_24 = (String)$continuation.L$9;
                var19_25 = (Context)$continuation.L$8;
                var18_26 = (SaveToUnifiedTask)$continuation.L$7;
                item = (EchoMediaItem)$continuation.L$6;
                unifiedExtension = (MusicExtension)$continuation.L$5;
                allDownloads = (List)$continuation.L$4;
                context = (EchoMediaItem)$continuation.L$3;
                downloadContext = (DownloadContext)$continuation.L$2;
                download = (DownloadEntity)$continuation.L$1;
                old = (DownloadEntity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v8 = $result;
lbl201:
                // 2 sources

                var21_27 = v8;
                var18_26.createCompleteNotification(var19_25, var20_24, (Drawable)var21_27);
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static final /* synthetic */ Context access$getApp$p(SaveToUnifiedTask $this) {
        return $this.app;
    }
}

