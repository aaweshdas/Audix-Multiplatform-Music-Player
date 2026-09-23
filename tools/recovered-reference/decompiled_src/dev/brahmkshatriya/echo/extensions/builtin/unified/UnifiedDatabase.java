/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  androidx.room.Dao
 *  androidx.room.Database
 *  androidx.room.Delete
 *  androidx.room.Entity
 *  androidx.room.Insert
 *  androidx.room.PrimaryKey
 *  androidx.room.Query
 *  androidx.room.RoomDatabase
 *  dev.brahmkshatriya.echo.R$string
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
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.builtins.BuiltinSerializersKt
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.json.Json
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.unified;

import android.content.Context;
import android.net.Uri;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b'\u0018\u00002\u00020\u0001:\u0004GHIJB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00a2\u0006\u0002\u0010\u001dJ6\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010(J(\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0086@\u00a2\u0006\u0002\u0010*J \u0010+\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010-H\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\r2\u0006\u0010'\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010(J\u001c\u00100\u001a\b\u0012\u0004\u0012\u0002010\f2\u0006\u0010'\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010(J,\u00102\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\r2\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u0002010\fH\u0086@\u00a2\u0006\u0002\u00106J2\u00107\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\r2\f\u00108\u001a\b\u0012\u0004\u0012\u0002010\f2\f\u00109\u001a\b\u0012\u0004\u0012\u0002040\fH\u0086@\u00a2\u0006\u0002\u0010:J&\u0010;\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\r2\u0006\u0010<\u001a\u0002042\u0006\u0010=\u001a\u000204H\u0086@\u00a2\u0006\u0002\u0010>J\u0016\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u000201H\u0086@\u00a2\u0006\u0002\u0010AJ\u001e\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u0004\u0018\u00010\r2\u0006\u0010F\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u001b\u0010\u0006\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006K"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "playlistDao", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistDao;", "dao", "getDao", "()Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistDao;", "dao$delegate", "Lkotlin/Lazy;", "getCreatedPlaylists", "", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSaved", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "isSaved", "", "item", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "deleteSaved", "getDateNow", "Ldev/brahmkshatriya/echo/common/models/Date;", "getLikedPlaylist", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "title", "", "description", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "actualId", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "playlist", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editPlaylistMetadata", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editPlaylistCover", "file", "Ljava/io/File;", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPlaylist", "getTracks", "Ldev/brahmkshatriya/echo/common/models/Track;", "addTracksToPlaylist", "index", "", "new", "(Ldev/brahmkshatriya/echo/common/models/Playlist;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTracksFromPlaylist", "tracks", "indexes", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTrack", "fromIndex", "toIndex", "(Ldev/brahmkshatriya/echo/common/models/Playlist;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLiked", "track", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrCreate", "app", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylist", "mediaItem", "PlaylistDao", "PlaylistEntity", "PlaylistTrackEntity", "SavedEntity", "app_debug"})
@Database(entities={PlaylistEntity.class, PlaylistTrackEntity.class, SavedEntity.class}, version=6, exportSchema=false)
@SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 5 Json.kt\nkotlinx/serialization/json/Json\n+ 6 Uri.kt\nandroidx/core/net/UriKt\n*L\n1#1,357:1\n774#2:358\n865#2,2:359\n1563#2:361\n1634#2,3:362\n1617#2,9:365\n1869#2:374\n1870#2:376\n1626#2:377\n1563#2:387\n1634#2,3:388\n1617#2,9:391\n1869#2:400\n1870#2:402\n1626#2:403\n1208#2,2:404\n1236#2,4:406\n1563#2:410\n1634#2,3:411\n1563#2:414\n1634#2,2:415\n1636#2:419\n1563#2:422\n1634#2,3:423\n1869#2,2:426\n1869#2,2:428\n1761#2,3:434\n1#3:375\n1#3:401\n19#4:378\n19#4:380\n19#4:382\n19#4:385\n19#4:417\n19#4:420\n19#4:430\n19#4:432\n205#5:379\n205#5:381\n205#5:383\n205#5:386\n205#5:418\n205#5:421\n205#5:431\n205#5:433\n36#6:384\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase\n*L\n47#1:358\n47#1:359,2\n47#1:361\n47#1:362,3\n51#1:365,9\n51#1:374\n51#1:376\n51#1:377\n132#1:387\n132#1:388,3\n134#1:391,9\n134#1:400\n134#1:402\n134#1:403\n144#1:404,2\n144#1:406,4\n146#1:410\n146#1:411,3\n154#1:414\n154#1:415,2\n154#1:419\n171#1:422\n171#1:423,3\n172#1:426,2\n176#1:428,2\n198#1:434,3\n51#1:375\n134#1:401\n82#1:378\n101#1:380\n104#1:382\n125#1:385\n156#1:417\n163#1:420\n180#1:430\n190#1:432\n82#1:379\n101#1:381\n104#1:383\n125#1:386\n156#1:418\n163#1:421\n180#1:431\n190#1:433\n123#1:384\n*E\n"})
public abstract class UnifiedDatabase
extends RoomDatabase {
    @NotNull
    private final Lazy dao$delegate = LazyKt.lazy(() -> UnifiedDatabase.dao_delegate$lambda$0(this));

    @NotNull
    public abstract PlaylistDao playlistDao();

    private final PlaylistDao getDao() {
        Lazy lazy = this.dao$delegate;
        return (PlaylistDao)lazy.getValue();
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getCreatedPlaylists(@NotNull Continuation<? super List<Playlist>> $completion) {
        if (!($completion instanceof getCreatedPlaylists.1)) ** GOTO lbl-1000
        var13_2 = $completion;
        if ((var13_2.label & -2147483648) != 0) {
            var13_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getCreatedPlaylists((Continuation<? super List<Playlist>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var14_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = this.getDao().getPlaylists((Continuation<? super List<PlaylistEntity>>)$continuation);
                if (v0 == var14_4) {
                    return var14_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                $this$filter\1 = (Iterable)v0;
                $i$f$filter\1\47 = false;
                var4_7 = $this$filter\1;
                destination\2 = new ArrayList<E>();
                $i$f$filterTo\2\358 = false;
                for (T element\2 : $this$filterTo\2) {
                    it\3 = (PlaylistEntity)element\2;
                    $i$a$-filter-UnifiedDatabase$getCreatedPlaylists$2\3\359\0 = false;
                    v1 = ((CharSequence)it\3.getActualId()).length() == 0;
                    if (!v1) continue;
                    destination\2.add(element\2);
                }
                $this$map\4 = (List)destination\2;
                $i$f$map\4\47 = false;
                $this$filterTo\2 = $this$map\4;
                destination\5 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\4, (int)10));
                $i$f$mapTo\5\361 = false;
                for (T item\5 : $this$mapTo\5) {
                    it\3 = (PlaylistEntity)item\5;
                    var11_14 = destination\5;
                    $i$a$-map-UnifiedDatabase$getCreatedPlaylists$3\6\363\0 = false;
                    var11_14.add(it\6.getPlaylist());
                }
                return (List)destination\5;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getSaved(@NotNull Continuation<? super List<? extends EchoMediaItem>> $completion) {
        if (!($completion instanceof getSaved.1)) ** GOTO lbl-1000
        var19_2 = $completion;
        if ((var19_2.label & -2147483648) != 0) {
            var19_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getSaved((Continuation<? super List<? extends EchoMediaItem>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var20_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = this.getDao().getSaved((Continuation<? super List<SavedEntity>>)$continuation);
                if (v0 == var20_4) {
                    return var20_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                $this$mapNotNull\1 = (Iterable)v0;
                $i$f$mapNotNull\1\51 = false;
                var4_7 = $this$mapNotNull\1;
                destination\2 = new ArrayList<E>();
                $i$f$mapNotNullTo\2\365 = false;
                $this$forEach\3 = $this$mapNotNullTo\2;
                $i$f$forEach\3\373 = false;
                var9_12 = $this$forEach\3.iterator();
                while (var9_12.hasNext()) {
                    element\4 = element\3 = var9_12.next();
                    $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\4\374\2 = false;
                    it\6 = (SavedEntity)element\4;
                    $i$a$-mapNotNull-UnifiedDatabase$getSaved$2\6\373\0 = false;
                    var15_18 = it\6.getItem-d1pmJ48();
                    if ((EchoMediaItem)(Result.isFailure-impl((Object)var15_18) != false ? null : var15_18) == null) continue;
                    $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\5\375\4 = false;
                    destination\2.add(it\4);
                }
                return (List)destination\2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object isSaved(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        String extId = UnifiedExtension.Companion.getExtensionId(item2.getExtras());
        return this.getDao().isSaved(item2.getId(), extId, $completion);
    }

    @Nullable
    public final Object save(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.getDao().insertSaved(SavedEntity.Companion.toEntity(item2), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object deleteSaved(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.getDao().deleteSaved(SavedEntity.Companion.toEntity(item2), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Date getDateNow() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());
        return new Date(calendar.get(1), (Integer)calendar.get(2), calendar.get(5));
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getLikedPlaylist(@NotNull Context context, @NotNull Continuation<? super Playlist> $completion) {
        block9: {
            if (!($completion instanceof getLikedPlaylist.1)) ** GOTO lbl-1000
            var12_3 = $completion;
            if ((var12_3.label & -2147483648) != 0) {
                var12_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    /* synthetic */ Object result;
                    final /* synthetic */ UnifiedDatabase this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.getLikedPlaylist(null, (Continuation<? super Playlist>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var13_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.L$0 = context;
                    $continuation.label = 1;
                    v0 = this.getDao().getPlaylist("Liked", (Continuation<? super PlaylistEntity>)$continuation);
                    if (v0 == var13_5) {
                        return var13_5;
                    }
                    ** GOTO lbl22
                }
                case 1: {
                    context = (Context)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl22:
                    // 2 sources

                    if ((liked = (PlaylistEntity)v0) != null) break;
                    var5_8 = Serializer.INSTANCE;
                    $this$toJson\1 = this.getDateNow();
                    $i$f$toJson\1\82 = false;
                    var8_12 = this_\1.getJson();
                    value\2 = $this$toJson\1;
                    $i$f$encodeToString\2\378 = false;
                    this_\2.getSerializersModule();
                    v1 = this_\2.encodeToString((SerializationStrategy)Date.Companion.serializer(), (Object)value\2);
                    v2 = context.getString(R.string.unified_liked_playlist_summary);
                    Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getString(...)");
                    playlist = new PlaylistEntity(0L, v1, "Liked", v2, null, "[]", null, 64, null);
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)context);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)liked);
                    $continuation.L$2 = playlist;
                    $continuation.label = 2;
                    v3 = this.getDao().insertPlaylist(playlist, (Continuation<? super Long>)$continuation);
                    if (v3 == var13_5) {
                        return var13_5;
                    }
                    ** GOTO lbl50
                }
                case 2: {
                    playlist = (PlaylistEntity)$continuation.L$2;
                    liked = (PlaylistEntity)$continuation.L$1;
                    context = (Context)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v3 = $result;
lbl50:
                    // 2 sources

                    id = ((Number)v3).longValue();
                    v4 = PlaylistEntity.copy$default(playlist, id, null, null, null, null, null, null, 126, null).getPlaylist();
                    break block9;
                }
            }
            v4 = liked.getPlaylist();
        }
        return v4;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object createPlaylist(@NotNull String title, @Nullable String description, @Nullable ImageHolder cover, @NotNull String actualId, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof createPlaylist.1)) ** GOTO lbl-1000
        var14_6 = $completion;
        if ((var14_6.label & -2147483648) != 0) {
            var14_6.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.createPlaylist(null, null, null, null, (Continuation<? super Playlist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var15_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var7_9 = Serializer.INSTANCE;
                $this$toJson\1 = this.getDateNow();
                $i$f$toJson\1\101 = false;
                var10_13 = this_\1.getJson();
                value\2 = $this$toJson\1;
                $i$f$encodeToString\2\380 = false;
                this_\2.getSerializersModule();
                v0 = this_\2.encodeToString((SerializationStrategy)Date.Companion.serializer(), (Object)value\2);
                v1 = description;
                if (v1 == null) {
                    v1 = "";
                }
                if (cover != null) {
                    this_\1 = Serializer.INSTANCE;
                    $this$toJson\3 = cover;
                    $i$f$toJson\3\104 = false;
                    this_\2 = this_\3.getJson();
                    value\4 = $this$toJson\3;
                    $i$f$encodeToString\4\382 = false;
                    this_\4.getSerializersModule();
                    v2 = this_\4.encodeToString((SerializationStrategy)ImageHolder.Companion.serializer(), (Object)value\4);
                } else {
                    v2 = null;
                }
                playlist = new PlaylistEntity(0L, v0, title, v1, v2, "[]", actualId);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)title);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)description);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)cover);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)actualId);
                $continuation.L$4 = playlist;
                $continuation.label = 1;
                v3 = this.getDao().insertPlaylist(playlist, (Continuation<? super Long>)$continuation);
                if (v3 == var15_8) {
                    return var15_8;
                }
                ** GOTO lbl57
            }
            case 1: {
                playlist = (PlaylistEntity)$continuation.L$4;
                actualId = (String)$continuation.L$3;
                cover = (ImageHolder)$continuation.L$2;
                description = (String)$continuation.L$1;
                title = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl57:
                // 2 sources

                id = ((Number)v3).longValue();
                return PlaylistEntity.copy$default(playlist, id, null, null, null, null, null, null, 126, null).getPlaylist();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static /* synthetic */ Object createPlaylist$default(UnifiedDatabase unifiedDatabase, String string2, String string3, ImageHolder imageHolder, String string4, Continuation continuation, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPlaylist");
        }
        if ((n & 4) != 0) {
            imageHolder = null;
        }
        if ((n & 8) != 0) {
            string4 = "";
        }
        return unifiedDatabase.createPlaylist(string2, string3, imageHolder, string4, (Continuation<? super Playlist>)continuation);
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object deletePlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof deletePlaylist.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.deletePlaylist(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = playlist;
                $continuation.label = 1;
                v0 = this.getDao().deleteAllTracks(Long.parseLong(playlist.getId()), (Continuation<? super Unit>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.label = 2;
                v1 = this.getDao().deletePlaylist(PlaylistEntity.Companion.toEntity(playlist), (Continuation<? super Unit>)$continuation);
                if (v1 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl32
            }
            case 2: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl32:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object editPlaylistMetadata(@NotNull Playlist playlist, @NotNull String title, @Nullable String description, @NotNull Continuation<? super Unit> $completion) {
        PlaylistEntity playlistEntity = PlaylistEntity.Companion.toEntity(playlist);
        String string2 = description;
        if (string2 == null) {
            string2 = "";
        }
        PlaylistEntity entity = PlaylistEntity.copy$default(playlistEntity, 0L, null, title, string2, null, null, null, 115, null);
        Object object = this.getDao().insertPlaylist(entity, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object editPlaylistCover(@NotNull Playlist playlist, @Nullable File file, @NotNull Continuation<? super Unit> $completion) {
        v0 = file;
        if (v0 == null) ** GOTO lbl-1000
        $this$toUri\1 = v0;
        $i$f$toUri\1\123 = false;
        v0 = Uri.fromFile((File)$this$toUri\1);
        if (v0 != null && (v0 = v0.toString()) != null) {
            v1 = ImageHolder.Companion.toResourceUriImageHolder((String)v0, true);
        } else lbl-1000:
        // 2 sources

        {
            v1 = null;
        }
        image = v1;
        v2 = PlaylistEntity.Companion.toEntity(playlist);
        if (image != null) {
            $this$toUri\1 = Serializer.INSTANCE;
            $this$toJson\2 = image;
            $i$f$toJson\2\125 = false;
            var9_9 = this_\2.getJson();
            value\3 = $this$toJson\2;
            $i$f$encodeToString\3\385 = false;
            this_\3.getSerializersModule();
            v3 = this_\3.encodeToString((SerializationStrategy)ImageHolder.Companion.serializer(), (Object)value\3);
        } else {
            v3 = null;
        }
        entity = PlaylistEntity.copy$default(v2, 0L, null, null, null, v3, null, null, 111, null);
        v4 = this.getDao().insertPlaylist(entity, $completion);
        if (v4 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return v4;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final Object loadPlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof loadPlaylist.1)) ** GOTO lbl-1000
        var23_3 = $completion;
        if ((var23_3.label & -2147483648) != 0) {
            var23_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadPlaylist(null, (Continuation<? super Playlist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var24_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = playlist;
                $continuation.label = 1;
                v0 = this.getDao().getPlaylist(PlaylistEntity.Companion.toEntity(playlist).getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                entity = (PlaylistEntity)v0;
                $continuation.L$0 = playlist;
                $continuation.L$1 = entity;
                $continuation.label = 2;
                v1 = this.getDao().getTracks(entity.getId(), (Continuation<? super List<PlaylistTrackEntity>>)$continuation);
                if (v1 == var24_5) {
                    return var24_5;
                }
                ** GOTO lbl35
            }
            case 2: {
                entity = (PlaylistEntity)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                $this$map\1 = (Iterable)v1;
                $i$f$map\1\132 = false;
                var7_11 = $this$map\1;
                destination\2 /* !! */  = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\387 = false;
                for (T item\2 : $this$mapTo\2) {
                    var12_19 = (PlaylistTrackEntity)item\2;
                    var21_23 = destination\2 /* !! */ ;
                    $i$a$-map-UnifiedDatabase$loadPlaylist$tracks$1\3\389\0 = false;
                    var21_23.add(it\3.getTrack());
                }
                tracks = (List)destination\2 /* !! */ ;
                if (tracks.isEmpty()) {
                    return Playlist.copy$default(playlist, null, null, false, false, null, null, Boxing.boxLong((long)0L), null, null, null, null, null, null, false, false, false, false, false, false, 524095, null);
                }
                $this$mapNotNull\4 = tracks;
                $i$f$mapNotNull\4\134 = false;
                destination\2 /* !! */  = $this$mapNotNull\4;
                destination\5 = new ArrayList<E>();
                $i$f$mapNotNullTo\5\391 = false;
                $this$forEach\6 = $this$mapNotNullTo\5;
                $i$f$forEach\6\399 = false;
                var13_22 = $this$forEach\6.iterator();
                while (var13_22.hasNext()) {
                    element\7 = element\6 = var13_22.next();
                    $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\7\400\5 = false;
                    it\9 = (Track)element\7;
                    $i$a$-mapNotNull-UnifiedDatabase$loadPlaylist$durations$1\9\399\0 = false;
                    if (it\9.getDuration() == null) continue;
                    $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\8\401\7 = false;
                    destination\5.add(it\7);
                }
                durations = (List)destination\5;
                average = (long)CollectionsKt.averageOfLong((Iterable)durations);
                return Playlist.copy$default(entity.getPlaylist(), null, null, false, false, null, null, Boxing.boxLong((long)tracks.size()), Boxing.boxLong((long)(average * (long)tracks.size())), null, null, null, null, null, false, false, false, false, false, false, 524095, null);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getTracks(@NotNull Playlist playlist, @NotNull Continuation<? super List<Track>> $completion) {
        if (!($completion instanceof getTracks.1)) ** GOTO lbl-1000
        var17_3 = $completion;
        if ((var17_3.label & -2147483648) != 0) {
            var17_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getTracks(null, (Continuation<? super List<Track>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var18_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.label = 1;
                v0 = this.getDao().getPlaylist(PlaylistEntity.Companion.toEntity(playlist).getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var18_5) {
                    return var18_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                entity = (PlaylistEntity)v0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = entity;
                $continuation.label = 2;
                v1 = this.getDao().getTracks(entity.getId(), (Continuation<? super List<PlaylistTrackEntity>>)$continuation);
                if (v1 == var18_5) {
                    return var18_5;
                }
                ** GOTO lbl35
            }
            case 2: {
                entity = (PlaylistEntity)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl35:
                // 2 sources

                $this$associateBy\1 = (Iterable)v1;
                $i$f$associateBy\1\144 = false;
                capacity\1 = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateBy\1, (int)10)), (int)16);
                var8_11 = $this$associateBy\1;
                destination\2 = new LinkedHashMap<K, V>(capacity\1);
                $i$f$associateByTo\2\405 = false;
                for (T element\2 : $this$associateByTo\2) {
                    var13_19 = (PlaylistTrackEntity)element\2;
                    var15_21 = destination\2;
                    $i$a$-associateBy-UnifiedDatabase$getTracks$tracks$1\3\407\0 = false;
                    var15_21.put(Boxing.boxLong((long)it\3.getEid()), element\2);
                }
                tracks = destination\2;
                if (tracks.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                $this$map\4 = entity.getList();
                $i$f$map\4\146 = false;
                capacity\1 = $this$map\4;
                destination\5 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\4, (int)10));
                $i$f$mapTo\5\410 = false;
                for (T item\5 : $this$mapTo\5) {
                    element\2 = ((Number)item\5).longValue();
                    var15_21 = destination\5;
                    $i$a$-map-UnifiedDatabase$getTracks$2\6\412\0 = false;
                    v2 = tracks.get(Boxing.boxLong((long)it\6));
                    Intrinsics.checkNotNull(v2);
                    var15_21.add(((PlaylistTrackEntity)v2).getTrack());
                }
                return (List)destination\5;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final Object addTracksToPlaylist(@NotNull Playlist playlist, int index, @NotNull List<Track> new, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof addTracksToPlaylist.1)) ** GOTO lbl-1000
        var32_5 = $completion;
        if ((var32_5.label & -2147483648) != 0) {
            var32_5.label -= -2147483648;
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
                Object L$7;
                Object L$8;
                Object L$9;
                Object L$10;
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.addTracksToPlaylist(null, 0, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var33_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (new.isEmpty()) {
                    return Unit.INSTANCE;
                }
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = new;
                $continuation.I$0 = index;
                $continuation.label = 1;
                v0 = this.getDao().getPlaylist(PlaylistEntity.Companion.toEntity(playlist).getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var33_7) {
                    return var33_7;
                }
                ** GOTO lbl28
            }
            case 1: {
                index = $continuation.I$0;
                new = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                entity = (PlaylistEntity)v0;
                $this$map\1 = new;
                $i$f$map\1\154 = 0;
                var9_14 = $this$map\1;
                destination\2 /* !! */  = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\414 = 0;
                var12_19 = $this$mapTo\2.iterator();
lbl35:
                // 2 sources

                while (var12_19.hasNext()) {
                    item\2 = var12_19.next();
                    var14_22 = (Track)item\2;
                    var23_31 = destination\2 /* !! */ ;
                    $i$a$-map-UnifiedDatabase$addTracksToPlaylist$newTracks$1\3\416\0 = 0;
                    v1 = entity.getId();
                    v2 = it\3.getId();
                    v3 = UnifiedExtension.Companion.getExtensionId(it\3.getExtras());
                    var16_24 = Serializer.INSTANCE;
                    $this$toJson\4 = it\3;
                    $i$f$toJson\4\156 = false;
                    var19_27 = this_\4.getJson();
                    value\5 = $this$toJson\4;
                    $i$f$encodeToString\5\417 = false;
                    this_\5.getSerializersModule();
                    trackEntity\3 = new PlaylistTrackEntity(0L, v1, v2, v3, this_\5.encodeToString((SerializationStrategy)Track.Companion.serializer(), (Object)value\5));
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)new);
                    $continuation.L$2 = entity;
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map\1);
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\2);
                    $continuation.L$5 = destination\2 /* !! */ ;
                    $continuation.L$6 = var12_19;
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)item\2);
                    $continuation.L$8 = SpillingKt.nullOutSpilledVariable((Object)it\3);
                    $continuation.L$9 = SpillingKt.nullOutSpilledVariable((Object)trackEntity\3);
                    $continuation.L$10 = var23_31;
                    $continuation.I$0 = index;
                    $continuation.I$1 = $i$f$map\1\154;
                    $continuation.I$2 = $i$f$mapTo\2\414;
                    $continuation.I$3 = $i$a$-map-UnifiedDatabase$addTracksToPlaylist$newTracks$1\3\416\0;
                    $continuation.label = 2;
                    v4 = this.getDao().insertPlaylistTrack(trackEntity\3, (Continuation<? super Long>)$continuation);
                    if (v4 == var33_7) {
                        return var33_7;
                    }
                    ** GOTO lbl92
                }
                break;
            }
            case 2: {
                $i$a$-map-UnifiedDatabase$addTracksToPlaylist$newTracks$1\3\416\0 = $continuation.I$3;
                $i$f$mapTo\2\414 = $continuation.I$2;
                $i$f$map\1\154 = $continuation.I$1;
                index = $continuation.I$0;
                var23_31 = (Collection)$continuation.L$10;
                trackEntity\3 = (PlaylistTrackEntity)$continuation.L$9;
                it\3 = (Track)$continuation.L$8;
                item\2 = $continuation.L$7;
                var12_19 = (Iterator<T>)$continuation.L$6;
                destination\2 /* !! */  = (Collection)$continuation.L$5;
                $this$mapTo\2 = (Iterable)$continuation.L$4;
                $this$map\1 = (Iterable)$continuation.L$3;
                entity = (PlaylistEntity)$continuation.L$2;
                new = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v4 = $result;
lbl92:
                // 2 sources

                var23_31.add(Boxing.boxLong((long)((Number)v4).longValue()));
                ** GOTO lbl35
            }
        }
        newTracks = (List)destination\2 /* !! */ ;
        $i$f$map\1\154 = Serializer.INSTANCE;
        $this$mapTo\2 = CollectionsKt.toMutableList((Collection)entity.getList());
        destination\2 /* !! */  = $this$mapTo\2;
        var29_34 = null;
        var28_35 = null;
        var27_36 = null;
        var26_37 = null;
        var24_38 = 0L;
        var23_31 = entity;
        $i$a$-apply-UnifiedDatabase$addTracksToPlaylist$newEntity$1\6\161\0 = false;
        $this$addTracksToPlaylist_u24lambda_u249\6.addAll(index, newTracks);
        var30_39 = Unit.INSTANCE;
        $i$f$toJson\7\163 = false;
        $i$a$-apply-UnifiedDatabase$addTracksToPlaylist$newEntity$1\6\161\0 = this_\7.getJson();
        value\8 = $this$toJson\7;
        $i$f$encodeToString\8\420 = false;
        this_\8.getSerializersModule();
        newEntity = PlaylistEntity.copy$default((PlaylistEntity)var23_31, var24_38, var26_37, var27_36, var28_35, var29_34, this_\8.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)LongSerializer.INSTANCE), (Object)value\8), null, 95, null);
        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)new);
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)entity);
        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)newTracks);
        $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)newEntity);
        $continuation.L$5 = null;
        $continuation.L$6 = null;
        $continuation.L$7 = null;
        $continuation.L$8 = null;
        $continuation.L$9 = null;
        $continuation.L$10 = null;
        $continuation.I$0 = index;
        $continuation.label = 3;
        v5 = this.getDao().insertPlaylist(newEntity, (Continuation<? super Long>)$continuation);
        if (v5 == var33_7) {
            return var33_7;
        }
        ** GOTO lbl145
        {
            case 3: {
                index = $continuation.I$0;
                newEntity = (PlaylistEntity)$continuation.L$4;
                newTracks = (List)$continuation.L$3;
                entity = (PlaylistEntity)$continuation.L$2;
                new = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v5 = $result;
lbl145:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object removeTracksFromPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, @NotNull List<Integer> indexes, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof removeTracksFromPlaylist.1)) ** GOTO lbl-1000
        var28_5 = $completion;
        if ((var28_5.label & -2147483648) != 0) {
            var28_5.label -= -2147483648;
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
                Object L$7;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.removeTracksFromPlaylist(null, null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var29_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$map\1 = indexes;
                $i$f$map\1\171 = false;
                var8_13 = $this$map\1;
                destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\422 = false;
                var11_19 = $this$mapTo\2.iterator();
                while (var11_19.hasNext()) {
                    item\2 = var11_19.next();
                    var13_24 = ((Number)item\2).intValue();
                    var19_27 = destination\2;
                    $i$a$-map-UnifiedDatabase$removeTracksFromPlaylist$entities$1\3\424\0 = false;
                    var19_27.add(PlaylistTrackEntity.Companion.toTrackEntity((Track)tracks.get((int)it\3)));
                }
                entities = (List)destination\2;
                $this$forEach\4 = entities;
                $i$f$forEach\4\172 = 0;
                $this$mapTo\2 = $this$forEach\4.iterator();
lbl30:
                // 3 sources

                while ($this$mapTo\2.hasNext()) {
                    element\4 = $this$mapTo\2.next();
                    it\5 = (PlaylistTrackEntity)element\4;
                    $i$a$-forEach-UnifiedDatabase$removeTracksFromPlaylist$2\5\426\0 = 0;
                    $continuation.L$0 = playlist;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)tracks);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)indexes);
                    $continuation.L$3 = entities;
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach\4);
                    $continuation.L$5 = $this$mapTo\2;
                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)element\4);
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)it\5);
                    $continuation.I$0 = $i$f$forEach\4\172;
                    $continuation.I$1 = $i$a$-forEach-UnifiedDatabase$removeTracksFromPlaylist$2\5\426\0;
                    $continuation.label = 1;
                    v0 = this.getDao().deletePlaylistTrack(it\5, (Continuation<? super Unit>)$continuation);
                    if (v0 != var29_7) continue;
                    return var29_7;
                }
                break;
            }
            case 1: {
                $i$a$-forEach-UnifiedDatabase$removeTracksFromPlaylist$2\5\426\0 = $continuation.I$1;
                $i$f$forEach\4\172 = $continuation.I$0;
                it\5 = (PlaylistTrackEntity)$continuation.L$7;
                element\4 = $continuation.L$6;
                $this$mapTo\2 = (Iterator)$continuation.L$5;
                $this$forEach\4 = (Iterable)$continuation.L$4;
                entities = (List)$continuation.L$3;
                indexes = (List)$continuation.L$2;
                tracks = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
                ** GOTO lbl30
            }
        }
        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)tracks);
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)indexes);
        $continuation.L$3 = entities;
        $continuation.L$4 = null;
        $continuation.L$5 = null;
        $continuation.L$6 = null;
        $continuation.L$7 = null;
        $continuation.label = 2;
        v1 = this.getDao().getPlaylist(PlaylistEntity.Companion.toEntity(playlist).getId(), (Continuation<? super PlaylistEntity>)$continuation);
        if (v1 == var29_7) {
            return var29_7;
        }
        ** GOTO lbl83
        {
            case 2: {
                entities = (List)$continuation.L$3;
                indexes = (List)$continuation.L$2;
                tracks = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl83:
                // 2 sources

                entity = (PlaylistEntity)v1;
                $this$mapTo\2 = Serializer.INSTANCE;
                it\5 = element\4 = CollectionsKt.toMutableList((Collection)entity.getList());
                var25_30 = null;
                var24_31 = null;
                var23_32 = null;
                var22_33 = null;
                var20_34 = 0L;
                var19_27 = entity;
                $i$a$-apply-UnifiedDatabase$removeTracksFromPlaylist$newEntity$1\6\175\0 = false;
                $this$forEach\7 = entities;
                $i$f$forEach\7\176 = false;
                for (T element\7 : $this$forEach\7) {
                    it\8 = (PlaylistTrackEntity)element\7;
                    $i$a$-forEach-UnifiedDatabase$removeTracksFromPlaylist$newEntity$1$1\8\428\6 = false;
                    index\8 = $this$removeTracksFromPlaylist_u24lambda_u2413\6.indexOf(Boxing.boxLong((long)it\8.getEid()));
                    if (index\8 == -1) continue;
                    $this$removeTracksFromPlaylist_u24lambda_u2413\6.remove(index\8);
                }
                var26_39 = Unit.INSTANCE;
                $i$f$toJson\9\180 = false;
                $i$a$-apply-UnifiedDatabase$removeTracksFromPlaylist$newEntity$1\6\175\0 = this_\9.getJson();
                value\10 = $this$toJson\9;
                $i$f$encodeToString\10\430 = false;
                this_\10.getSerializersModule();
                newEntity = PlaylistEntity.copy$default((PlaylistEntity)var19_27, var20_34, var22_33, var23_32, var24_31, var25_30, this_\10.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)LongSerializer.INSTANCE), (Object)value\10), null, 95, null);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)tracks);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)indexes);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)entities);
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)entity);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)newEntity);
                $continuation.label = 3;
                v2 = this.getDao().insertPlaylist(newEntity, (Continuation<? super Long>)$continuation);
                if (v2 == var29_7) {
                    return var29_7;
                }
                ** GOTO lbl134
            }
            case 3: {
                newEntity = (PlaylistEntity)$continuation.L$5;
                entity = (PlaylistEntity)$continuation.L$4;
                entities = (List)$continuation.L$3;
                indexes = (List)$continuation.L$2;
                tracks = (List)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl134:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object moveTrack(@NotNull Playlist playlist, int fromIndex, int toIndex, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof moveTrack.1)) ** GOTO lbl-1000
        var22_5 = $completion;
        if ((var22_5.label & -2147483648) != 0) {
            var22_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.moveTrack(null, 0, 0, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var23_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.I$0 = fromIndex;
                $continuation.I$1 = toIndex;
                $continuation.label = 1;
                v0 = this.getDao().getPlaylist(PlaylistEntity.Companion.toEntity(playlist).getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var23_7) {
                    return var23_7;
                }
                ** GOTO lbl26
            }
            case 1: {
                toIndex = $continuation.I$1;
                fromIndex = $continuation.I$0;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                entity = (PlaylistEntity)v0;
                var7_10 = Serializer.INSTANCE;
                var9_12 = var8_11 = CollectionsKt.toMutableList((Collection)entity.getList());
                var19_14 = null;
                var18_15 = null;
                var17_16 = null;
                var16_17 = null;
                var14_18 = 0L;
                var13_19 = entity;
                $i$a$-apply-UnifiedDatabase$moveTrack$newEntity$1\1\188\0 = false;
                $this$moveTrack_u24lambda_u2414\1.add(toIndex, $this$moveTrack_u24lambda_u2414\1.remove(fromIndex));
                var20_22 = Unit.INSTANCE;
                $i$f$toJson\2\190 = false;
                $i$a$-apply-UnifiedDatabase$moveTrack$newEntity$1\1\188\0 = this_\2.getJson();
                value\3 = $this$toJson\2;
                $i$f$encodeToString\3\432 = false;
                this_\3.getSerializersModule();
                newEntity = PlaylistEntity.copy$default(var13_19, var14_18, var16_17, var17_16, var18_15, var19_14, this_\3.encodeToString((SerializationStrategy)new ArrayListSerializer((KSerializer)LongSerializer.INSTANCE), (Object)value\3), null, 95, null);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)entity);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)newEntity);
                $continuation.I$0 = fromIndex;
                $continuation.I$1 = toIndex;
                $continuation.label = 2;
                v1 = this.getDao().insertPlaylist(newEntity, (Continuation<? super Long>)$continuation);
                if (v1 == var23_7) {
                    return var23_7;
                }
                ** GOTO lbl66
            }
            case 2: {
                toIndex = $continuation.I$1;
                fromIndex = $continuation.I$0;
                newEntity = (PlaylistEntity)$continuation.L$2;
                entity = (PlaylistEntity)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl66:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object isLiked(@NotNull Track track, @NotNull Continuation<? super Boolean> $completion) {
        if (!($completion instanceof isLiked.1)) ** GOTO lbl-1000
        var11_3 = $completion;
        if ((var11_3.label & -2147483648) != 0) {
            var11_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.isLiked(null, (Continuation<? super Boolean>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var12_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = track;
                $continuation.label = 1;
                v0 = this.getDao().getPlaylist("Liked", (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var12_5) {
                    return var12_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                v1 = (PlaylistEntity)v0;
                if (v1 == null) {
                    return Boxing.boxBoolean((boolean)false);
                }
                liked = v1;
                $continuation.L$0 = track;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)liked);
                $continuation.label = 2;
                v2 = this.getDao().getTracks(liked.getId(), (Continuation<? super List<PlaylistTrackEntity>>)$continuation);
                if (v2 == var12_5) {
                    return var12_5;
                }
                ** GOTO lbl38
            }
            case 2: {
                liked = (PlaylistEntity)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl38:
                // 2 sources

                var4_7 = (Iterable)v2;
                $i$f$any\1\198 = false;
                if (!($this$any\1 instanceof Collection) || !((Collection)$this$any\1).isEmpty()) ** GOTO lbl44
                v3 = false;
                ** GOTO lbl51
lbl44:
                // 2 sources

                for (T element\1 : $this$any\1) {
                    it\2 = (PlaylistTrackEntity)element\1;
                    $i$a$-any-UnifiedDatabase$isLiked$2\2\435\0 = false;
                    if (!(Intrinsics.areEqual((Object)it\2.getTrackId(), (Object)track.getId()) != false && Intrinsics.areEqual((Object)it\2.getExtId(), (Object)UnifiedExtension.Companion.getExtensionId(track.getExtras())) != false)) continue;
                    v3 = true;
                    ** GOTO lbl51
                }
                v3 = false;
lbl51:
                // 3 sources

                return Boxing.boxBoolean((boolean)v3);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getOrCreate(@NotNull Context app, @NotNull EchoMediaItem context, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof getOrCreate.1)) ** GOTO lbl-1000
        var6_4 = $completion;
        if ((var6_4.label & -2147483648) != 0) {
            var6_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getOrCreate(null, null, (Continuation<? super Playlist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var7_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = app;
                $continuation.L$1 = context;
                $continuation.label = 1;
                v0 = this.getDao().getPlaylistByActualId(context.getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                context = (EchoMediaItem)$continuation.L$1;
                app = (Context)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                if ((v1 = (PlaylistEntity)v0) != null && (v1 = v1.getPlaylist()) != null) break;
                var4_7 = new Object[]{""};
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)app);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)context);
                $continuation.label = 2;
                v2 = this.createPlaylist(context.getTitle(), app.getString(R.string.downloaded_x, var4_7), context.getCover(), context.getId(), (Continuation<? super Playlist>)$continuation);
                if (v2 == var7_6) {
                    return var7_6;
                }
                ** GOTO lbl38
            }
            case 2: {
                context = (EchoMediaItem)$continuation.L$1;
                app = (Context)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl38:
                // 2 sources

                return v2;
            }
        }
        return v1;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getPlaylist(@NotNull EchoMediaItem mediaItem, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof getPlaylist.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedDatabase this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getPlaylist(null, (Continuation<? super Playlist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                $continuation.label = 1;
                v0 = this.getDao().getPlaylistByActualId(mediaItem.getId(), (Continuation<? super PlaylistEntity>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                mediaItem = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                v1 = (PlaylistEntity)v0;
                return v1 != null ? v1.getPlaylist() : null;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final PlaylistDao dao_delegate$lambda$0(UnifiedDatabase this$0) {
        return this$0.playlistDao();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0016\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0015H\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010$J\u001a\u0010&\u001a\u0004\u0018\u00010\u00152\b\u0010'\u001a\u0004\u0018\u00010\bH\u00a7@\u00a2\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006*\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistDao;", "", "getPlaylists", "", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylist", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylistByActualId", "actualId", "insertPlaylist", "playlist", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "", "getTracks", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;", "playlistId", "insertPlaylistTrack", "playlistTrack", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylistTrack", "deleteAllTracks", "getSaved", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;", "isSaved", "", "extId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSaved", "saved", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSaved", "getTrack", "eid", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAfterTrack", "app_debug"})
    @Dao
    public static interface PlaylistDao {
        @Query(value="SELECT * FROM PlaylistEntity")
        @Nullable
        public Object getPlaylists(@NotNull Continuation<? super List<PlaylistEntity>> var1);

        @Query(value="SELECT * FROM PlaylistEntity WHERE id = :id")
        @Nullable
        public Object getPlaylist(long var1, @NotNull Continuation<? super PlaylistEntity> var3);

        @Query(value="SELECT * FROM PlaylistEntity WHERE name = :name")
        @Nullable
        public Object getPlaylist(@NotNull String var1, @NotNull Continuation<? super PlaylistEntity> var2);

        @Query(value="SELECT * FROM PlaylistEntity WHERE actualId = :actualId")
        @Nullable
        public Object getPlaylistByActualId(@NotNull String var1, @NotNull Continuation<? super PlaylistEntity> var2);

        @Insert(onConflict=1)
        @Nullable
        public Object insertPlaylist(@NotNull PlaylistEntity var1, @NotNull Continuation<? super Long> var2);

        @Delete
        @Nullable
        public Object deletePlaylist(@NotNull PlaylistEntity var1, @NotNull Continuation<? super Unit> var2);

        @Query(value="SELECT * FROM PlaylistTrackEntity WHERE playlistId = :playlistId")
        @Nullable
        public Object getTracks(long var1, @NotNull Continuation<? super List<PlaylistTrackEntity>> var3);

        @Insert(onConflict=1)
        @Nullable
        public Object insertPlaylistTrack(@NotNull PlaylistTrackEntity var1, @NotNull Continuation<? super Long> var2);

        @Delete
        @Nullable
        public Object deletePlaylistTrack(@NotNull PlaylistTrackEntity var1, @NotNull Continuation<? super Unit> var2);

        @Query(value="DELETE FROM PlaylistTrackEntity WHERE playlistId = :playlistId")
        @Nullable
        public Object deleteAllTracks(long var1, @NotNull Continuation<? super Unit> var3);

        @Query(value="SELECT * FROM SavedEntity")
        @Nullable
        public Object getSaved(@NotNull Continuation<? super List<SavedEntity>> var1);

        @Query(value="SELECT EXISTS(SELECT 1 FROM SavedEntity WHERE id = :id AND extId = :extId)")
        @Nullable
        public Object isSaved(@NotNull String var1, @NotNull String var2, @NotNull Continuation<? super Boolean> var3);

        @Insert(onConflict=1)
        @Nullable
        public Object insertSaved(@NotNull SavedEntity var1, @NotNull Continuation<? super Long> var2);

        @Delete
        @Nullable
        public Object deleteSaved(@NotNull SavedEntity var1, @NotNull Continuation<? super Unit> var2);

        @Query(value="SELECT * FROM PlaylistTrackEntity WHERE eid = :eid")
        @Nullable
        public Object getTrack(@Nullable Long var1, @NotNull Continuation<? super PlaylistTrackEntity> var2);

        @Query(value="SELECT * FROM PlaylistTrackEntity WHERE \"after\" = :eid")
        @Nullable
        public Object getAfterTrack(long var1, @NotNull Continuation<? super PlaylistTrackEntity> var3);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0001/BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003JQ\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001f\u00a8\u00060"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;", "", "id", "", "modified", "", "name", "description", "cover", "listData", "actualId", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getModified", "()Ljava/lang/String;", "getName", "getDescription", "getCover", "getListData", "getActualId", "list", "", "getList", "()Ljava/util/List;", "list$delegate", "Lkotlin/Lazy;", "playlist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "getPlaylist", "()Ldev/brahmkshatriya/echo/common/models/Playlist;", "playlist$delegate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_debug"})
    @Entity
    @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,357:1\n13#2,2:358\n15#2,3:361\n13#2,2:364\n15#2,3:367\n13#2,2:370\n15#2,3:373\n222#3:360\n222#3:366\n222#3:372\n1#4:376\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity\n*L\n277#1:358,2\n277#1:361,3\n285#1:364,2\n285#1:367,3\n286#1:370,2\n286#1:373,3\n277#1:360\n285#1:366\n286#1:372\n*E\n"})
    public static final class PlaylistEntity {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @PrimaryKey(autoGenerate=true)
        private final long id;
        @NotNull
        private final String modified;
        @NotNull
        private final String name;
        @NotNull
        private final String description;
        @Nullable
        private final String cover;
        @NotNull
        private final String listData;
        @NotNull
        private final String actualId;
        @NotNull
        private final Lazy list$delegate;
        @NotNull
        private final Lazy playlist$delegate;

        public PlaylistEntity(long id2, @NotNull String modified, @NotNull String name, @NotNull String description, @Nullable String cover, @NotNull String listData, @NotNull String actualId) {
            Intrinsics.checkNotNullParameter((Object)modified, (String)"modified");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)description, (String)"description");
            Intrinsics.checkNotNullParameter((Object)listData, (String)"listData");
            Intrinsics.checkNotNullParameter((Object)actualId, (String)"actualId");
            this.id = id2;
            this.modified = modified;
            this.name = name;
            this.description = description;
            this.cover = cover;
            this.listData = listData;
            this.actualId = actualId;
            this.list$delegate = LazyKt.lazy(() -> PlaylistEntity.list_delegate$lambda$0(this));
            this.playlist$delegate = LazyKt.lazy(() -> PlaylistEntity.playlist_delegate$lambda$2(this));
        }

        public /* synthetic */ PlaylistEntity(long l, String string2, String string3, String string4, String string5, String string6, String string7, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x40) != 0) {
                string7 = "";
            }
            this(l, string2, string3, string4, string5, string6, string7);
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getModified() {
            return this.modified;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getCover() {
            return this.cover;
        }

        @NotNull
        public final String getListData() {
            return this.listData;
        }

        @NotNull
        public final String getActualId() {
            return this.actualId;
        }

        @NotNull
        public final List<Long> getList() {
            Lazy lazy = this.list$delegate;
            return (List)lazy.getValue();
        }

        @NotNull
        public final Playlist getPlaylist() {
            Lazy lazy = this.playlist$delegate;
            return (Playlist)lazy.getValue();
        }

        public final long component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.modified;
        }

        @NotNull
        public final String component3() {
            return this.name;
        }

        @NotNull
        public final String component4() {
            return this.description;
        }

        @Nullable
        public final String component5() {
            return this.cover;
        }

        @NotNull
        public final String component6() {
            return this.listData;
        }

        @NotNull
        public final String component7() {
            return this.actualId;
        }

        @NotNull
        public final PlaylistEntity copy(long id2, @NotNull String modified, @NotNull String name, @NotNull String description, @Nullable String cover, @NotNull String listData, @NotNull String actualId) {
            Intrinsics.checkNotNullParameter((Object)modified, (String)"modified");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)description, (String)"description");
            Intrinsics.checkNotNullParameter((Object)listData, (String)"listData");
            Intrinsics.checkNotNullParameter((Object)actualId, (String)"actualId");
            return new PlaylistEntity(id2, modified, name, description, cover, listData, actualId);
        }

        public static /* synthetic */ PlaylistEntity copy$default(PlaylistEntity playlistEntity, long l, String string2, String string3, String string4, String string5, String string6, String string7, int n, Object object) {
            if ((n & 1) != 0) {
                l = playlistEntity.id;
            }
            if ((n & 2) != 0) {
                string2 = playlistEntity.modified;
            }
            if ((n & 4) != 0) {
                string3 = playlistEntity.name;
            }
            if ((n & 8) != 0) {
                string4 = playlistEntity.description;
            }
            if ((n & 0x10) != 0) {
                string5 = playlistEntity.cover;
            }
            if ((n & 0x20) != 0) {
                string6 = playlistEntity.listData;
            }
            if ((n & 0x40) != 0) {
                string7 = playlistEntity.actualId;
            }
            return playlistEntity.copy(l, string2, string3, string4, string5, string6, string7);
        }

        @NotNull
        public String toString() {
            return "PlaylistEntity(id=" + this.id + ", modified=" + this.modified + ", name=" + this.name + ", description=" + this.description + ", cover=" + this.cover + ", listData=" + this.listData + ", actualId=" + this.actualId + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.id);
            result2 = result2 * 31 + this.modified.hashCode();
            result2 = result2 * 31 + this.name.hashCode();
            result2 = result2 * 31 + this.description.hashCode();
            result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
            result2 = result2 * 31 + this.listData.hashCode();
            result2 = result2 * 31 + this.actualId.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaylistEntity)) {
                return false;
            }
            PlaylistEntity playlistEntity = (PlaylistEntity)other;
            if (this.id != playlistEntity.id) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.modified, (Object)playlistEntity.modified)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.name, (Object)playlistEntity.name)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.description, (Object)playlistEntity.description)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.cover, (Object)playlistEntity.cover)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.listData, (Object)playlistEntity.listData)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.actualId, (Object)playlistEntity.actualId);
        }

        /*
         * WARNING - void declaration
         */
        private static final List list_delegate$lambda$0(PlaylistEntity this$0) {
            Object object;
            Object object2;
            Object object3 = Serializer.INSTANCE;
            String string2 = this$0.listData;
            boolean bl = false;
            Object object4 = string2;
            try {
                void this_\3;
                String string3 = object4;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string4 = string3;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)new ArrayListSerializer((KSerializer)LongSerializer.INSTANCE), string4));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object4 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object4);
            if (object2 == null) {
                object = object4;
            } else {
                Object object5 = object4;
                try {
                    Object object6 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string2, (Throwable)object6);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            object3 = object;
            ResultKt.throwOnFailure((Object)object3);
            return (List)object3;
        }

        /*
         * WARNING - void declaration
         */
        private static final Playlist playlist_delegate$lambda$2(PlaylistEntity this$0) {
            void it\9;
            Object object;
            Object object2;
            Pair[] pairArray;
            Object object3;
            Object object4;
            Object object5;
            String string2;
            String string3;
            boolean bl;
            boolean bl2;
            Object object6;
            String string4 = String.valueOf(this$0.id);
            String string5 = this$0.name;
            boolean bl3 = true;
            boolean bl4 = false;
            Object object7 = this$0.cover;
            if (object7 != null) {
                Object object8;
                void $this$toData_u2dIoAF18A\1;
                Serializer serializer2 = Serializer.INSTANCE;
                object6 = object7;
                bl2 = bl4;
                bl = bl3;
                string3 = string5;
                string2 = string4;
                boolean bl5 = false;
                Object object9 = $this$toData_u2dIoAF18A\1;
                try {
                    void this_\3;
                    object5 = object9;
                    boolean bl6 = false;
                    Json json = Serializer.INSTANCE.getJson();
                    Object object10 = object5;
                    boolean bl7 = false;
                    this_\3.getSerializersModule();
                    object5 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)BuiltinSerializersKt.getNullable(ImageHolder.Companion.serializer()), (String)object10));
                }
                catch (Throwable bl6) {
                    object5 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl6));
                }
                object9 = object5;
                object5 = Result.exceptionOrNull-impl((Object)object9);
                if (object5 == null) {
                    object8 = object9;
                } else {
                    Object bl6 = object9;
                    try {
                        Object object11 = object5;
                        boolean bl8 = false;
                        throw new Serializer.DecodingException((String)$this$toData_u2dIoAF18A\1, (Throwable)object11);
                    }
                    catch (Throwable throwable) {
                        object8 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                }
                object4 = object8;
                string4 = string2;
                string5 = string3;
                bl3 = bl;
                bl4 = bl2;
                Object object12 = object4;
                ResultKt.throwOnFailure((Object)object12);
                object3 = (ImageHolder)object12;
            } else {
                object3 = null;
            }
            object7 = Serializer.INSTANCE;
            String string6 = this$0.modified;
            Long l = null;
            Long l2 = null;
            List list2 = null;
            object4 = object3;
            bl2 = bl4;
            bl = bl3;
            string3 = string5;
            string2 = string4;
            boolean bl9 = false;
            object6 = pairArray;
            try {
                void this_\7;
                String string7 = object6;
                boolean bl10 = false;
                object5 = Serializer.INSTANCE.getJson();
                String string8 = string7;
                boolean bl11 = false;
                this_\7.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\7.decodeFromString((DeserializationStrategy)Date.Companion.serializer(), string8));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object6 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object6);
            if (object2 == null) {
                object = object6;
            } else {
                Object object13 = object6;
                try {
                    Object object14 = object2;
                    boolean bl12 = false;
                    throw new Serializer.DecodingException((String)pairArray, (Throwable)object14);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            Object object15 = object;
            object7 = object15;
            Pair[] pairArray2 = Result.isFailure-impl((Object)object7) ? null : object7;
            pairArray = object7 = this$0.description;
            object15 = (Date)pairArray2;
            boolean bl13 = false;
            boolean bl14 = !StringsKt.isBlank((CharSequence)((CharSequence)it\9));
            Object object16 = bl14 ? object7 : null;
            object7 = new Pair[]{TuplesKt.to((Object)"extension_id", (Object)"unified"), TuplesKt.to((Object)"listData", (Object)this$0.listData), TuplesKt.to((Object)"actualId", (Object)this$0.actualId)};
            DefaultConstructorMarker defaultConstructorMarker = null;
            int n = 519400;
            boolean bl15 = false;
            boolean bl16 = false;
            boolean bl17 = false;
            boolean bl18 = false;
            boolean bl19 = false;
            boolean bl20 = false;
            Map map2 = MapsKt.mapOf((Pair[])object7);
            String string9 = null;
            ImageHolder imageHolder = null;
            Pair[] pairArray3 = object16;
            Object object17 = object15;
            Long l3 = l;
            Long l4 = l2;
            List list3 = list2;
            Object object18 = object4;
            boolean bl21 = bl2;
            boolean bl22 = bl;
            String string10 = string3;
            String string11 = string2;
            return new Playlist(string11, string10, bl22, bl21, (ImageHolder)object18, list3, l4, l3, (Date)object17, (String)pairArray3, imageHolder, string9, map2, bl20, bl19, bl18, bl17, bl16, bl15, n, defaultConstructorMarker);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity$Companion;", "", "<init>", "()V", "toEntity", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "app_debug"})
        @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity$Companion\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,357:1\n19#2:358\n19#2:360\n205#3:359\n205#3:361\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity$Companion\n*L\n300#1:358\n303#1:360\n300#1:359\n303#1:361\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final PlaylistEntity toEntity(@NotNull Playlist $this$toEntity) {
                String string2;
                String string3;
                String string4;
                void this_\2;
                void this_\1;
                Intrinsics.checkNotNullParameter((Object)$this$toEntity, (String)"<this>");
                long l = Long.parseLong($this$toEntity.getId());
                Object object = Serializer.INSTANCE;
                Object object2 = $this$toEntity.getCreationDate();
                boolean bl = false;
                Json json = this_\1.getJson();
                Date date = object2;
                boolean bl2 = false;
                this_\2.getSerializersModule();
                String string5 = this_\2.encodeToString((SerializationStrategy)BuiltinSerializersKt.getNullable(Date.Companion.serializer()), (Object)date);
                String string6 = $this$toEntity.getTitle();
                String string7 = $this$toEntity.getDescription();
                if (string7 == null) {
                    string7 = "";
                }
                if ((object = $this$toEntity.getCover()) != null) {
                    void this_\4;
                    void this_\3;
                    object2 = Serializer.INSTANCE;
                    Object object3 = object;
                    boolean bl3 = false;
                    date = this_\3.getJson();
                    Object object4 = object3;
                    boolean bl4 = false;
                    this_\4.getSerializersModule();
                    string4 = this_\4.encodeToString((SerializationStrategy)ImageHolder.Companion.serializer(), object4);
                } else {
                    string4 = null;
                }
                if ((string3 = $this$toEntity.getExtras().get("listData")) == null) {
                    string3 = "[]";
                }
                if ((string2 = $this$toEntity.getExtras().get("actualId")) == null) {
                    string2 = "";
                }
                return new PlaylistEntity(l, string5, string6, string7, string4, string3, string2);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;", "", "eid", "", "playlistId", "trackId", "", "extId", "data", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEid", "()J", "getPlaylistId", "getTrackId", "()Ljava/lang/String;", "getExtId", "getData", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "getTrack", "()Ldev/brahmkshatriya/echo/common/models/Track;", "track$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_debug"})
    @Entity
    @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,357:1\n13#2,2:358\n15#2,3:361\n222#3:360\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity\n*L\n321#1:358,2\n321#1:361,3\n321#1:360\n*E\n"})
    public static final class PlaylistTrackEntity {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @PrimaryKey(autoGenerate=true)
        private final long eid;
        private final long playlistId;
        @NotNull
        private final String trackId;
        @NotNull
        private final String extId;
        @NotNull
        private final String data;
        @NotNull
        private final Lazy track$delegate;

        public PlaylistTrackEntity(long eid, long playlistId, @NotNull String trackId, @NotNull String extId, @NotNull String data2) {
            Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
            this.eid = eid;
            this.playlistId = playlistId;
            this.trackId = trackId;
            this.extId = extId;
            this.data = data2;
            this.track$delegate = LazyKt.lazy(() -> PlaylistTrackEntity.track_delegate$lambda$1(this));
        }

        public final long getEid() {
            return this.eid;
        }

        public final long getPlaylistId() {
            return this.playlistId;
        }

        @NotNull
        public final String getTrackId() {
            return this.trackId;
        }

        @NotNull
        public final String getExtId() {
            return this.extId;
        }

        @NotNull
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final Track getTrack() {
            Lazy lazy = this.track$delegate;
            return (Track)lazy.getValue();
        }

        public final long component1() {
            return this.eid;
        }

        public final long component2() {
            return this.playlistId;
        }

        @NotNull
        public final String component3() {
            return this.trackId;
        }

        @NotNull
        public final String component4() {
            return this.extId;
        }

        @NotNull
        public final String component5() {
            return this.data;
        }

        @NotNull
        public final PlaylistTrackEntity copy(long eid, long playlistId, @NotNull String trackId, @NotNull String extId, @NotNull String data2) {
            Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
            return new PlaylistTrackEntity(eid, playlistId, trackId, extId, data2);
        }

        public static /* synthetic */ PlaylistTrackEntity copy$default(PlaylistTrackEntity playlistTrackEntity, long l, long l2, String string2, String string3, String string4, int n, Object object) {
            if ((n & 1) != 0) {
                l = playlistTrackEntity.eid;
            }
            if ((n & 2) != 0) {
                l2 = playlistTrackEntity.playlistId;
            }
            if ((n & 4) != 0) {
                string2 = playlistTrackEntity.trackId;
            }
            if ((n & 8) != 0) {
                string3 = playlistTrackEntity.extId;
            }
            if ((n & 0x10) != 0) {
                string4 = playlistTrackEntity.data;
            }
            return playlistTrackEntity.copy(l, l2, string2, string3, string4);
        }

        @NotNull
        public String toString() {
            return "PlaylistTrackEntity(eid=" + this.eid + ", playlistId=" + this.playlistId + ", trackId=" + this.trackId + ", extId=" + this.extId + ", data=" + this.data + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.eid);
            result2 = result2 * 31 + Long.hashCode(this.playlistId);
            result2 = result2 * 31 + this.trackId.hashCode();
            result2 = result2 * 31 + this.extId.hashCode();
            result2 = result2 * 31 + this.data.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaylistTrackEntity)) {
                return false;
            }
            PlaylistTrackEntity playlistTrackEntity = (PlaylistTrackEntity)other;
            if (this.eid != playlistTrackEntity.eid) {
                return false;
            }
            if (this.playlistId != playlistTrackEntity.playlistId) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.trackId, (Object)playlistTrackEntity.trackId)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.extId, (Object)playlistTrackEntity.extId)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.data, (Object)playlistTrackEntity.data);
        }

        /*
         * WARNING - void declaration
         */
        private static final Track track_delegate$lambda$1(PlaylistTrackEntity this$0) {
            Pair[] pairArray;
            Object object;
            Object object2 = Serializer.INSTANCE;
            String string2 = this$0.data;
            boolean bl = false;
            Pair[] pairArray2 = string2;
            try {
                void this_\3;
                String string3 = pairArray2;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string4 = string3;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)Track.Companion.serializer(), string4));
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            pairArray2 = object;
            object = Result.exceptionOrNull-impl((Object)pairArray2);
            if (object == null) {
                pairArray = pairArray2;
            } else {
                Pair[] pairArray3 = pairArray2;
                try {
                    Object object3 = object;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string2, (Throwable)object3);
                }
                catch (Throwable throwable) {
                    pairArray = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            object2 = pairArray;
            ResultKt.throwOnFailure((Object)object2);
            Track track2 = (Track)object2;
            boolean bl5 = false;
            pairArray2 = new Pair[]{TuplesKt.to((Object)"pId", (Object)String.valueOf(this$0.playlistId)), TuplesKt.to((Object)"eId", (Object)String.valueOf(this$0.eid))};
            return Track.copy$default(track2, null, null, track2.getType(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, MapsKt.plus(track2.getExtras(), (Map)MapsKt.mapOf((Pair[])pairArray2)), null, null, false, false, false, false, false, false, 0xFF7FFFB, null);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity$Companion;", "", "<init>", "()V", "toTrackEntity", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;", "Ldev/brahmkshatriya/echo/common/models/Track;", "app_debug"})
        @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity$Companion\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,357:1\n19#2:358\n205#3:359\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity$Companion\n*L\n336#1:358\n336#1:359\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final PlaylistTrackEntity toTrackEntity(@NotNull Track $this$toTrackEntity) {
                void this_\2;
                void this_\1;
                Intrinsics.checkNotNullParameter((Object)$this$toTrackEntity, (String)"<this>");
                String string2 = $this$toTrackEntity.getExtras().get("pId");
                Intrinsics.checkNotNull((Object)string2);
                long pId = Long.parseLong(string2);
                String string3 = $this$toTrackEntity.getExtras().get("eId");
                Intrinsics.checkNotNull((Object)string3);
                long eId = Long.parseLong(string3);
                String string4 = $this$toTrackEntity.getId();
                String string5 = UnifiedExtension.Companion.getExtensionId($this$toTrackEntity.getExtras());
                Serializer serializer2 = Serializer.INSTANCE;
                Track track2 = $this$toTrackEntity;
                boolean bl = false;
                Json json = this_\1.getJson();
                Track track3 = track2;
                boolean bl2 = false;
                this_\2.getSerializersModule();
                return new PlaylistTrackEntity(eId, pId, string4, string5, this_\2.encodeToString((SerializationStrategy)Track.Companion.serializer(), (Object)track3));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;", "", "id", "", "extId", "data", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getExtId", "getData", "item", "Lkotlin/Result;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getItem-d1pmJ48", "()Ljava/lang/Object;", "item$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_debug"})
    @Entity(primaryKeys={"id", "extId"})
    @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,357:1\n13#2,2:358\n15#2,3:361\n222#3:360\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity\n*L\n347#1:358,2\n347#1:361,3\n347#1:360\n*E\n"})
    public static final class SavedEntity {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String id;
        @NotNull
        private final String extId;
        @NotNull
        private final String data;
        @NotNull
        private final Lazy item$delegate;

        public SavedEntity(@NotNull String id2, @NotNull String extId, @NotNull String data2) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
            this.id = id2;
            this.extId = extId;
            this.data = data2;
            this.item$delegate = LazyKt.lazy(() -> SavedEntity.item_delegate$lambda$0(this));
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getExtId() {
            return this.extId;
        }

        @NotNull
        public final String getData() {
            return this.data;
        }

        @NotNull
        public final Object getItem-d1pmJ48() {
            Lazy lazy = this.item$delegate;
            return ((Result)lazy.getValue()).unbox-impl();
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.extId;
        }

        @NotNull
        public final String component3() {
            return this.data;
        }

        @NotNull
        public final SavedEntity copy(@NotNull String id2, @NotNull String extId, @NotNull String data2) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
            return new SavedEntity(id2, extId, data2);
        }

        public static /* synthetic */ SavedEntity copy$default(SavedEntity savedEntity, String string2, String string3, String string4, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = savedEntity.id;
            }
            if ((n & 2) != 0) {
                string3 = savedEntity.extId;
            }
            if ((n & 4) != 0) {
                string4 = savedEntity.data;
            }
            return savedEntity.copy(string2, string3, string4);
        }

        @NotNull
        public String toString() {
            return "SavedEntity(id=" + this.id + ", extId=" + this.extId + ", data=" + this.data + ")";
        }

        public int hashCode() {
            int result2 = this.id.hashCode();
            result2 = result2 * 31 + this.extId.hashCode();
            result2 = result2 * 31 + this.data.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SavedEntity)) {
                return false;
            }
            SavedEntity savedEntity = (SavedEntity)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)savedEntity.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.extId, (Object)savedEntity.extId)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.data, (Object)savedEntity.data);
        }

        /*
         * WARNING - void declaration
         */
        private static final Result item_delegate$lambda$0(SavedEntity this$0) {
            Object object;
            Object object2;
            Serializer serializer2 = Serializer.INSTANCE;
            String string2 = this$0.data;
            boolean bl = false;
            Object object3 = string2;
            try {
                void this_\3;
                String string3 = object3;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string4 = string3;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)EchoMediaItem.Companion.serializer(), string4));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object3 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object3);
            if (object2 == null) {
                object = object3;
            } else {
                Object object4 = object3;
                try {
                    Object object5 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string2, (Throwable)object5);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            return Result.box-impl((Object)object);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity$Companion;", "", "<init>", "()V", "toEntity", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "app_debug"})
        @SourceDebugExtension(value={"SMAP\nUnifiedDatabase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity$Companion\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,357:1\n19#2:358\n205#3:359\n*S KotlinDebug\n*F\n+ 1 UnifiedDatabase.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity$Companion\n*L\n352#1:358\n352#1:359\n*E\n"})
        public static final class Companion {
            private Companion() {
            }

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final SavedEntity toEntity(@NotNull EchoMediaItem $this$toEntity) {
                void this_\2;
                void this_\1;
                Intrinsics.checkNotNullParameter((Object)$this$toEntity, (String)"<this>");
                String extId = UnifiedExtension.Companion.getExtensionId($this$toEntity.getExtras());
                String string2 = $this$toEntity.getId();
                Serializer serializer2 = Serializer.INSTANCE;
                EchoMediaItem echoMediaItem = $this$toEntity;
                boolean bl = false;
                Json json = this_\1.getJson();
                EchoMediaItem echoMediaItem2 = echoMediaItem;
                boolean bl2 = false;
                this_\2.getSerializersModule();
                return new SavedEntity(string2, extId, this_\2.encodeToString((SerializationStrategy)EchoMediaItem.Companion.serializer(), (Object)echoMediaItem2));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

