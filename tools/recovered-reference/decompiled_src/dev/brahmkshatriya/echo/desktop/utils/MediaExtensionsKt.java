/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.utils;

import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0006"}, d2={"withExtensionId", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "extId", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nMediaExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaExtensions.kt\ndev/brahmkshatriya/echo/desktop/utils/MediaExtensionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,35:1\n1563#2:36\n1634#2,3:37\n1563#2:40\n1634#2,3:41\n1563#2:44\n1634#2,3:45\n*S KotlinDebug\n*F\n+ 1 MediaExtensions.kt\ndev/brahmkshatriya/echo/desktop/utils/MediaExtensionsKt\n*L\n17#1:36\n17#1:37,3\n21#1:40\n21#1:41,3\n25#1:44\n25#1:45,3\n*E\n"})
public final class MediaExtensionsKt {
    @NotNull
    public static final EchoMediaItem withExtensionId(@NotNull EchoMediaItem $this$withExtensionId, @NotNull String extId) {
        Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        return EchoMediaItem.copyMediaItem$default($this$withExtensionId, null, null, null, null, null, MapsKt.plus($this$withExtensionId.getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), false, false, false, 479, null);
    }

    @NotNull
    public static final Track withExtensionId(@NotNull Track $this$withExtensionId, @NotNull String extId) {
        Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        return Track.copy$default($this$withExtensionId, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, MapsKt.plus($this$withExtensionId.getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), null, null, false, false, false, false, false, false, 0xFF7FFFF, null);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final Shelf withExtensionId(@NotNull Shelf $this$withExtensionId, @NotNull String extId) {
        Shelf shelf;
        Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Shelf shelf2 = $this$withExtensionId;
        if (shelf2 instanceof Shelf.Lists.Items) {
            Collection<EchoMediaItem> collection;
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            Iterable iterable = ((Shelf.Lists.Items)$this$withExtensionId).getList();
            String string2 = null;
            String string3 = null;
            Shelf.Lists.Items items2 = (Shelf.Lists.Items)$this$withExtensionId;
            boolean $i$f$map = false;
            void var5_18 = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                EchoMediaItem echoMediaItem = (EchoMediaItem)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                collection.add(MediaExtensionsKt.withExtensionId((EchoMediaItem)it, extId));
            }
            collection = (List)destination$iv$iv;
            shelf = Shelf.Lists.Items.copy$default(items2, string3, string2, collection, null, null, null, MapsKt.plus(((Shelf.Lists.Items)$this$withExtensionId).getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), 59, null);
        } else if (shelf2 instanceof Shelf.Lists.Tracks) {
            Collection<Track> collection;
            Iterable $this$map$iv = ((Shelf.Lists.Tracks)$this$withExtensionId).getList();
            String string4 = null;
            String string5 = null;
            Shelf.Lists.Tracks tracks = (Shelf.Lists.Tracks)$this$withExtensionId;
            boolean $i$f$map = false;
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Track it = (Track)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                collection.add(MediaExtensionsKt.withExtensionId(it, extId));
            }
            collection = (List)destination$iv$iv;
            shelf = Shelf.Lists.Tracks.copy$default(tracks, string5, string4, collection, null, null, null, MapsKt.plus(((Shelf.Lists.Tracks)$this$withExtensionId).getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), 59, null);
        } else if (shelf2 instanceof Shelf.Lists.Categories) {
            Collection<Shelf.Category> collection;
            Iterable $this$map$iv = ((Shelf.Lists.Categories)$this$withExtensionId).getList();
            String string6 = null;
            String string7 = null;
            Shelf.Lists.Categories categories = (Shelf.Lists.Categories)$this$withExtensionId;
            boolean $i$f$map = false;
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Shelf.Category it = (Shelf.Category)item$iv$iv;
                collection = destination$iv$iv;
                boolean bl = false;
                collection.add(Shelf.Category.copy$default(it, null, null, null, null, null, null, MapsKt.plus(it.getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), 63, null));
            }
            collection = (List)destination$iv$iv;
            shelf = Shelf.Lists.Categories.copy$default(categories, string7, string6, (List)collection, null, null, null, MapsKt.plus(((Shelf.Lists.Categories)$this$withExtensionId).getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), 59, null);
        } else if (shelf2 instanceof Shelf.Item) {
            shelf = new Shelf.Item(MediaExtensionsKt.withExtensionId(((Shelf.Item)$this$withExtensionId).getMedia(), extId));
        } else if (shelf2 instanceof Shelf.Category) {
            shelf = Shelf.Category.copy$default((Shelf.Category)$this$withExtensionId, null, null, null, null, null, null, MapsKt.plus(((Shelf.Category)$this$withExtensionId).getExtras(), (Pair)TuplesKt.to((Object)"extension_id", (Object)extId)), 63, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return shelf;
    }
}

