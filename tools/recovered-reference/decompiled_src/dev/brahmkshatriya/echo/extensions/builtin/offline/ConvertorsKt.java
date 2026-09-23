/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  dev.brahmkshatriya.echo.R$drawable
 *  dev.brahmkshatriya.echo.R$plurals
 *  dev.brahmkshatriya.echo.R$string
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
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.offline;

import android.content.Context;
import android.content.res.Resources;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.extensions.builtin.offline.MediaStoreUtils;
import dev.brahmkshatriya.echo.extensions.builtin.offline.OfflineExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a\n\u0010\u0010\u001a\u00020\u0016*\u00020\u0017\u00a8\u0006\u0018"}, d2={"toAlbum", "Ldev/brahmkshatriya/echo/common/models/Album;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "toArtist", "Ldev/brahmkshatriya/echo/common/models/Artist;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "toPlaylist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "toDate", "Ldev/brahmkshatriya/echo/common/models/Date;", "", "toSongList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;", "toShelf", "Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "context", "Landroid/content/Context;", "title", "", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Genre;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nConvertors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Convertors.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/ConvertorsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n1563#2:96\n1634#2,3:97\n1374#2:101\n1460#2,5:102\n1#3:100\n*S KotlinDebug\n*F\n+ 1 Convertors.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/ConvertorsKt\n*L\n24#1:96\n24#1:97,3\n55#1:101\n55#1:102,5\n*E\n"})
public final class ConvertorsKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Album toAlbum(@NotNull MediaStoreUtils.MAlbum $this$toAlbum) {
        long l;
        Collection<Artist> collection;
        void $this$mapTo\2;
        void $this$map\1;
        Intrinsics.checkNotNullParameter((Object)$this$toAlbum, (String)"<this>");
        String string2 = String.valueOf($this$toAlbum.getId());
        String string3 = $this$toAlbum.getTitle();
        if (string3 == null) {
            string3 = "Unknown";
        }
        Iterable iterable = $this$toAlbum.getArtists();
        ImageHolder imageHolder = ImageHolder.Companion.toResourceUriImageHolder$default(ImageHolder.Companion, String.valueOf($this$toAlbum.getCover()), false, 1, null);
        Album.Type type = null;
        String string4 = string3;
        String string5 = string2;
        boolean bl = false;
        void var3_8 = $this$map\1;
        Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
        boolean bl2 = false;
        for (Object t : $this$mapTo\2) {
            void it\3;
            MediaStoreUtils.MArtist mArtist = (MediaStoreUtils.MArtist)t;
            collection = collection2;
            boolean bl3 = false;
            collection.add(ConvertorsKt.toArtist((MediaStoreUtils.MArtist)it\3));
        }
        collection = (List)collection2;
        iterable = $this$toAlbum.getSongList();
        Long l2 = $this$toAlbum.getSongList().size();
        long l3 = 0L;
        for (Object t : iterable) {
            void it\4;
            Track track2 = (Track)t;
            l = l3;
            boolean bl4 = false;
            Long l4 = it\4.getDuration();
            long l5 = l4 != null ? l4 : 0L;
            l3 = l + l5;
        }
        l = l3;
        Integer n = $this$toAlbum.getAlbumYear();
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n2 = 1040128;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        boolean bl10 = false;
        Map map2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)"extension_id", (Object)OfflineExtension.Companion.getMetadata().getId()));
        String string6 = null;
        boolean bl11 = false;
        String string7 = null;
        ImageHolder imageHolder2 = null;
        String string8 = null;
        Date date = n != null ? Date.Companion.toYearDate(n) : null;
        Long l6 = l;
        Long l7 = l2;
        Collection<Artist> collection3 = collection;
        ImageHolder imageHolder3 = imageHolder;
        Album.Type type2 = type;
        String string9 = string4;
        String string10 = string5;
        return new Album(string10, string9, type2, imageHolder3, (List)collection3, l7, l6, date, string8, imageHolder2, string7, bl11, string6, map2, bl10, bl9, bl8, bl7, bl6, bl5, n2, defaultConstructorMarker);
    }

    @NotNull
    public static final Artist toArtist(@Nullable MediaStoreUtils.MArtist $this$toArtist) {
        Object object;
        MediaStoreUtils.MArtist mArtist = $this$toArtist;
        String string2 = String.valueOf(mArtist != null ? mArtist.getId() : null);
        Object object2 = $this$toArtist;
        if (object2 == null || (object2 = ((MediaStoreUtils.MArtist)object2).getTitle()) == null) {
            object2 = "Unknown";
        }
        return new Artist(string2, (String)object2, (object = $this$toArtist) != null && (object = ((MediaStoreUtils.MArtist)object).getSongList()) != null && (object = (Track)CollectionsKt.firstOrNull((Iterable)((Iterable)object))) != null ? ((Track)object).getCover() : null, null, null, null, null, MapsKt.mapOf((Pair)TuplesKt.to((Object)"extension_id", (Object)OfflineExtension.Companion.getMetadata().getId())), false, false, false, false, false, false, 16248, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Playlist toPlaylist(@NotNull MediaStoreUtils.MPlaylist $this$toPlaylist) {
        long l;
        Intrinsics.checkNotNullParameter((Object)$this$toPlaylist, (String)"<this>");
        String string2 = String.valueOf($this$toPlaylist.getId());
        String string3 = $this$toPlaylist.getTitle();
        if (string3 == null) {
            string3 = "Unknown";
        }
        Track track2 = (Track)CollectionsKt.firstOrNull((Iterable)$this$toPlaylist.getSongList());
        Iterable iterable = $this$toPlaylist.getSongList();
        Long l2 = $this$toPlaylist.getSongList().size();
        List list2 = CollectionsKt.emptyList();
        ImageHolder imageHolder = track2 != null ? track2.getCover() : null;
        boolean bl = true;
        boolean bl2 = true;
        String string4 = string3;
        String string5 = string2;
        long l3 = 0L;
        for (Object t : iterable) {
            void it\1;
            Track track3 = (Track)t;
            l = l3;
            boolean bl3 = false;
            Long l4 = it\1.getDuration();
            long l5 = l4 != null ? l4 : 0L;
            l3 = l + l5;
        }
        l = l3;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n = 519168;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        Map map2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)"extension_id", (Object)OfflineExtension.Companion.getMetadata().getId()));
        String string6 = null;
        ImageHolder imageHolder2 = null;
        String string7 = $this$toPlaylist.getDescription();
        Date date = ConvertorsKt.toDate($this$toPlaylist.getModifiedDate());
        Long l6 = l;
        Long l7 = l2;
        List list3 = list2;
        ImageHolder imageHolder3 = imageHolder;
        boolean bl10 = bl;
        boolean bl11 = bl2;
        String string8 = string4;
        String string9 = string5;
        return new Playlist(string9, string8, bl11, bl10, imageHolder3, list3, l7, l6, date, string7, imageHolder2, string6, map2, bl9, bl8, bl7, bl6, bl5, bl4, n, defaultConstructorMarker);
    }

    @NotNull
    public static final Date toDate(long $this$toDate) {
        return new Date($this$toDate);
    }

    /*
     * WARNING - void declaration
     */
    private static final List<Track> toSongList(MediaStoreUtils.FileNode $this$toSongList) {
        void $this$flatMapTo\2;
        void $this$flatMap\1;
        Collection collection = $this$toSongList.getSongList();
        Collection<MediaStoreUtils.FileNode> collection2 = $this$toSongList.getFolderList().values();
        Intrinsics.checkNotNullExpressionValue(collection2, (String)"<get-values>(...)");
        Iterable iterable = collection2;
        Collection collection3 = collection;
        boolean bl = false;
        void var3_4 = $this$flatMap\1;
        Collection collection4 = new ArrayList();
        boolean bl2 = false;
        for (Object t : $this$flatMapTo\2) {
            MediaStoreUtils.FileNode fileNode = (MediaStoreUtils.FileNode)t;
            boolean bl3 = false;
            Intrinsics.checkNotNull((Object)fileNode);
            Iterable iterable2 = ConvertorsKt.toSongList(fileNode);
            CollectionsKt.addAll((Collection)collection4, (Iterable)iterable2);
        }
        return CollectionsKt.plus((Collection)collection3, (Iterable)((List)collection4));
    }

    @NotNull
    public static final Shelf.Category toShelf(@NotNull MediaStoreUtils.FileNode $this$toShelf, @NotNull Context context, @Nullable String title) {
        Shelf.Category category;
        Intrinsics.checkNotNullParameter((Object)$this$toShelf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        MediaStoreUtils.FileNode fileNode = $this$toShelf;
        boolean bl = false;
        if (fileNode.getFolderList().size() == 1 && fileNode.getSongList().isEmpty()) {
            Set<Map.Entry<String, MediaStoreUtils.FileNode>> set = fileNode.getFolderList().entrySet();
            Intrinsics.checkNotNullExpressionValue(set, (String)"<get-entries>(...)");
            Map.Entry entry = (Map.Entry)CollectionsKt.first((Iterable)set);
            boolean bl2 = false;
            Object v = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(v, (String)"<get-value>(...)");
            MediaStoreUtils.FileNode fileNode2 = (MediaStoreUtils.FileNode)v;
            String string2 = title;
            if (string2 == null) {
                string2 = fileNode.getFolderName();
            }
            category = ConvertorsKt.toShelf(fileNode2, context, string2 + "/" + entry.getKey());
        } else {
            Object object;
            Object[] objectArray;
            int n = fileNode.getFolderList().size() + fileNode.getSongList().size();
            String string3 = fileNode.getFolderName();
            String string4 = title;
            if (string4 == null) {
                string4 = fileNode.getFolderName();
            }
            Track track2 = (Track)CollectionsKt.firstOrNull(fileNode.getSongList());
            Object object2 = context.getResources();
            Feed feed2 = Feed.Companion.toFeed(new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(fileNode, context, null){
                int label;
                final /* synthetic */ MediaStoreUtils.FileNode $this_run;
                final /* synthetic */ Context $context;
                {
                    this.$this_run = $receiver;
                    this.$context = $context;
                    super(1, $completion);
                }

                /*
                 * WARNING - void declaration
                 */
                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            void $this$mapTo\5;
                            void $this$map\4;
                            Collection collection;
                            void $this$mapTo\2;
                            Iterable iterable;
                            ResultKt.throwOnFailure((Object)$result);
                            Map map2 = this.$this_run.getFolderList();
                            Context context = this.$context;
                            boolean $i$f$map\1\7032 = false;
                            void var5_7 = iterable;
                            Collection collection2 = new ArrayList<E>(iterable.size());
                            boolean bl = false;
                            Iterator<Map.Entry<K, V>> iterator = $this$mapTo\2.entrySet().iterator();
                            while (iterator.hasNext()) {
                                void it\3;
                                Map.Entry<K, V> entry;
                                Map.Entry<K, V> entry2 = entry = iterator.next();
                                collection = collection2;
                                boolean bl2 = false;
                                collection.add(ConvertorsKt.toShelf((MediaStoreUtils.FileNode)it\3.getValue(), context, (String)it\3.getKey()));
                            }
                            iterable = this.$this_run.getSongList();
                            collection = (List)collection2;
                            boolean bl3 = false;
                            void $i$f$map\1\7032 = $this$map\4;
                            Collection collection3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\4, (int)10));
                            boolean bl4 = false;
                            for (T t : $this$mapTo\5) {
                                Track track2 = (Track)t;
                                Collection collection4 = collection3;
                                boolean bl5 = false;
                                collection4.add(track2.toShelf());
                            }
                            return CollectionsKt.plus((Collection)collection, (Iterable)((List)collection3));
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Continuation<? super List<? extends Shelf>> p1) {
                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                }
            }), new Feed.Buttons(false, false, true, ConvertorsKt.toSongList(fileNode), 3, null), track2 != null ? track2.getCover() : null);
            String string5 = string4;
            String string6 = string3;
            try {
                Resources resources = object2;
                boolean bl3 = false;
                Object[] objectArray2 = new Object[]{n};
                objectArray = Result.constructor-impl((Object)resources.getQuantityString(R.plurals.number_items, n, objectArray2));
            }
            catch (Throwable throwable) {
                objectArray = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            Object[] objectArray3 = objectArray;
            object2 = objectArray3;
            String string7 = (String)(Result.isFailure-impl((Object)object2) ? null : object2);
            if (string7 == null) {
                objectArray = new Object[]{n};
                String string8 = context.getString(R.string.n_items, objectArray);
                string7 = string8;
                Intrinsics.checkNotNullExpressionValue((Object)string8, (String)"getString(...)");
            }
            if ((object = (Track)CollectionsKt.firstOrNull(fileNode.getSongList())) == null || (object = ((Track)object).getCover()) == null) {
                object = ImageHolder.Companion.toResourceImageHolder$default(ImageHolder.Companion, R.drawable.ic_offline_files, false, 1, null);
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            int n2 = 96;
            Map map2 = null;
            String string9 = null;
            Object object3 = object;
            String string10 = string7;
            Feed feed3 = feed2;
            String string11 = string5;
            String string12 = string6;
            category = new Shelf.Category(string12, string11, feed3, string10, (ImageHolder)object3, string9, map2, n2, defaultConstructorMarker);
        }
        return category;
    }

    @NotNull
    public static final Shelf toShelf(@NotNull MediaStoreUtils.Genre $this$toShelf) {
        Intrinsics.checkNotNullParameter((Object)$this$toShelf, (String)"<this>");
        String id2 = String.valueOf($this$toShelf.getId());
        String string2 = $this$toShelf.getTitle();
        if (string2 == null) {
            string2 = "Unknown";
        }
        return new Shelf.Lists.Tracks(id2, string2, CollectionsKt.take((Iterable)$this$toShelf.getSongList(), (int)9), null, null, Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>($this$toShelf, null){
            int label;
            final /* synthetic */ MediaStoreUtils.Genre $this_toShelf;
            {
                this.$this_toShelf = $receiver;
                super(1, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$mapTo\2;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable iterable = this.$this_toShelf.getSongList();
                        boolean bl = false;
                        Iterable iterable2 = iterable;
                        Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                        boolean bl2 = false;
                        for (T t : $this$mapTo\2) {
                            void it\3;
                            Track track2 = (Track)t;
                            Collection collection2 = collection;
                            boolean bl3 = false;
                            collection2.add(it\3.toShelf());
                        }
                        return (List)collection;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Continuation<? super List<? extends Shelf>> p1) {
                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }
        }), null, null, 3, null), null, 88, null);
    }
}

