/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.library;

import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2={"toTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "toStoredTrack", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nDesktopLibraryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopLibraryManager.kt\ndev/brahmkshatriya/echo/desktop/library/DesktopLibraryManagerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n1563#2:361\n1634#2,3:362\n1563#2:366\n1634#2,3:367\n1#3:365\n*S KotlinDebug\n*F\n+ 1 DesktopLibraryManager.kt\ndev/brahmkshatriya/echo/desktop/library/DesktopLibraryManagerKt\n*L\n39#1:361\n39#1:362,3\n61#1:366\n61#1:367,3\n*E\n"})
public final class DesktopLibraryManagerKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Track toTrack(@NotNull StoredTrack $this$toTrack) {
        ImageHolder.NetworkRequestImageHolder networkRequestImageHolder;
        Album album;
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$toTrack, (String)"<this>");
        String string2 = $this$toTrack.getId();
        String string3 = $this$toTrack.getTitle();
        Iterable $this$map$iv = $this$toTrack.getArtists();
        boolean $i$f$map = false;
        Object object = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            String string4 = (String)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(new Artist((String)it, (String)it, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
        }
        List list2 = (List)destination$iv$iv;
        String string5 = $this$toTrack.getAlbumTitle();
        if (string5 != null) {
            String it = string5;
            boolean bl = false;
            album = new Album(it, it, null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        } else {
            album = null;
        }
        Album album2 = album;
        String string6 = $this$toTrack.getCoverUrl();
        if (string6 != null) {
            String it = string6;
            boolean bl = false;
            networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest(it, null, null, null, 14, null), false);
        } else {
            networkRequestImageHolder = null;
        }
        ImageHolder.NetworkRequestImageHolder networkRequestImageHolder2 = networkRequestImageHolder;
        object = $this$toTrack.getDurationMs();
        Map<String, String> map2 = $this$toTrack.getExtras();
        return new Track(string2, string3, null, networkRequestImageHolder2, list2, album2, (Long)object, null, null, null, null, null, null, null, null, null, null, false, null, map2, null, null, false, false, false, false, false, false, 267911044, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final StoredTrack toStoredTrack(@NotNull Track $this$toStoredTrack) {
        Collection<String> collection;
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Object c;
        Intrinsics.checkNotNullParameter((Object)$this$toStoredTrack, (String)"<this>");
        ImageHolder imageHolder = $this$toStoredTrack.getCover();
        if (imageHolder == null) {
            Album album = $this$toStoredTrack.getAlbum();
            imageHolder = album != null ? album.getCover() : null;
        }
        String coverUrl = (c = imageHolder) instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)c).getRequest().getUrl() : (c instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)c).getUri() : null);
        c = $this$toStoredTrack.getArtists();
        String string2 = $this$toStoredTrack.getTitle();
        String string3 = $this$toStoredTrack.getId();
        boolean $i$f$map = false;
        void var4_6 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void it;
            Artist artist = (Artist)item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getName());
        }
        collection = (List)destination$iv$iv;
        Album album = $this$toStoredTrack.getAlbum();
        DefaultConstructorMarker defaultConstructorMarker = null;
        int n = 128;
        long l = 0L;
        Map<String, String> map2 = $this$toStoredTrack.getExtras();
        Long l2 = $this$toStoredTrack.getDuration();
        String string4 = coverUrl;
        String string5 = album != null ? album.getTitle() : null;
        List list2 = collection;
        String string6 = string2;
        String string7 = string3;
        return new StoredTrack(string7, string6, list2, string5, string4, l2, map2, l, n, defaultConstructorMarker);
    }
}

