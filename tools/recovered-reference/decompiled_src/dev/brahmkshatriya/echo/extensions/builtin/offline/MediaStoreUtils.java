/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentUris
 *  android.content.ContentValues
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build$VERSION
 *  android.provider.MediaStore$Audio$Media
 *  android.provider.MediaStore$Audio$Playlists
 *  android.provider.MediaStore$Audio$Playlists$Members
 *  android.util.Log
 *  androidx.annotation.RequiresApi
 *  dev.brahmkshatriya.echo.R$string
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.offline;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.RequiresApi;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.extensions.builtin.offline.OfflineExtension;
import java.io.Closeable;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\tdefghijklB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0002J=\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002\u00a2\u0006\u0002\u0010\u0014J0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u001e\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00130\u001e0\u0013H\u0002J\u0080\u0001\u0010 \u001a\u00020\f*\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050'2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010)\u001a\u00020\u001a2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\f0/H\u0002JS\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u00010#2\u0014\u00105\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u0002060+2\u0014\u00107\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u0002080+2\u0006\u00109\u001a\u00020\u001aH\u0002\u00a2\u0006\u0002\u0010:Jd\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00132\u0014\u00105\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u0002060+2>\u0010>\u001a:\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\b0\u001e\u0018\u00010?j\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\b0\u001e\u0018\u0001`AH\u0002J\u001e\u0010B\u001a\u00020C2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0086@\u00a2\u0006\u0002\u0010DJ \u0010E\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013H\u0002J\u0018\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0005H\u0002J\f\u0010J\u001a\u00020\u001a*\u00020\u001cH\u0007J\b\u0010K\u001a\u00020\u001aH\u0002J\b\u0010L\u001a\u00020\u001aH\u0002J\u0019\u0010M\u001a\u0004\u0018\u00010\u0010*\u00020\u001c2\u0006\u0010I\u001a\u00020\u0005\u00a2\u0006\u0002\u0010NJ\u001a\u0010O\u001a\u00020\f*\u00020\u001c2\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0005J\u0012\u0010P\u001a\u00020\f*\u00020\u001c2\u0006\u0010H\u001a\u00020\u0010J\"\u0010Q\u001a\u00020\f*\u00020\u001c2\u0006\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020#J\u001a\u0010U\u001a\u00020\f*\u00020\u001c2\u0006\u0010R\u001a\u00020\u00102\u0006\u0010T\u001a\u00020#J*\u0010V\u001a\u00020\f*\u00020\u001c2\u0006\u0010R\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u0010W\u001a\u00020#2\u0006\u0010X\u001a\u00020#JL\u0010Y\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002HZ0\u001e0'\"\u0004\b\u0000\u0010Z*\b\u0012\u0004\u0012\u0002HZ0'2\u0006\u0010[\u001a\u00020\u00052\u001a\u0010.\u001a\u0016\u0012\u0004\u0012\u0002HZ\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050'0/J\u0018\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0005H\u0002J&\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050'*\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050%H\u0002J\u0010\u0010a\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0005H\u0002J$\u0010b\u001a\b\u0012\u0004\u0012\u00020c0'*\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050%H\u0002J\n\u0010H\u001a\u00020\u0010*\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0018R\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00050'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006m"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils;", "", "<init>", "()V", "TAG", "", "ARTIST_EXCLUSIONS", "handleMediaFolder", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;", "path", "rootNode", "handleShallowTrack", "", "mediaItem", "Ldev/brahmkshatriya/echo/common/models/Track;", "albumId", "", "shallowFolder", "folderArray", "", "(Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Long;Ljava/lang/String;Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;Ljava/util/List;)V", "selection", "projection", "", "[Ljava/lang/String;", "playlistContent", "", "context", "Landroid/content/Context;", "playlists", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "parseSongQuery", "Landroid/database/Cursor;", "limitValue", "", "folderFilter", "", "blacklistKeywords", "", "songs", "foundPlaylistContent", "idMap", "", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "block", "Lkotlin/Function1;", "coverUri", "Landroid/net/Uri;", "songAlbumMap", "song", "year", "albumMap", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$AlbumImpl;", "artistMap", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "haveImgPerm", "(Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;Z)V", "allowedCoverExtensions", "albumMapToAlbumList", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "coverCache", "Ljava/util/HashMap;", "Ljava/io/File;", "Lkotlin/collections/HashMap;", "getAllSongs", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$LibraryStoreClass;", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/common/settings/Settings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikedPlaylist", "playlistsFinal", "dummyTrack", "id", "title", "hasImagePermission", "hasImprovedMediaStore", "hasScopedStorage", "createPlaylist", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Long;", "editPlaylist", "deletePlaylist", "addSongToPlaylist", "playlistId", "songId", "index", "removeSongFromPlaylist", "moveSongInPlaylist", "from", "to", "searchBy", "E", "query", "wagnerFischer", "s", "t", "splitArtists", "exclusions", "fixWin1252", "toArtists", "Ldev/brahmkshatriya/echo/common/models/Artist;", "Item", "MAlbum", "AlbumImpl", "MArtist", "Genre", "Date", "MPlaylist", "LibraryStoreClass", "FileNode", "app_debug"})
@SourceDebugExtension(value={"SMAP\nMediaStoreUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaStoreUtils.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Cursor.kt\nandroidx/core/database/CursorKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 Uri.kt\nandroidx/core/net/UriKt\n+ 7 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,743:1\n1#2:744\n1#2:755\n1#2:794\n1#2:817\n1#2:853\n1617#3,9:745\n1869#3:754\n1870#3:756\n1626#3:757\n1761#3,3:760\n1563#3:776\n1634#3,3:777\n1869#3:780\n1870#3:788\n2756#3:793\n1869#3,2:795\n1563#3:798\n1634#3,2:799\n1374#3:801\n1460#3,5:802\n1617#3,9:807\n1869#3:816\n1870#3:818\n1626#3:819\n1563#3:820\n1634#3,3:821\n2393#3,14:824\n1636#3:838\n774#3:839\n865#3,2:840\n1056#3:842\n1617#3,9:843\n1869#3:852\n1870#3:854\n1626#3:855\n1563#3:856\n1634#3,3:857\n104#4:758\n80#4:759\n80#4:763\n104#4:764\n104#4:765\n104#4:766\n104#4:767\n68#4:768\n68#4:769\n80#4:770\n104#4:771\n80#4:772\n382#5,3:773\n382#5,7:781\n385#5,4:789\n36#6:797\n29#6:864\n37#7:860\n36#7,3:861\n*S KotlinDebug\n*F\n+ 1 MediaStoreUtils.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils\n*L\n301#1:755\n401#1:794\n666#1:817\n716#1:853\n301#1:745,9\n301#1:754\n301#1:756\n301#1:757\n311#1:760,3\n381#1:776\n381#1:777,3\n386#1:780\n386#1:788\n401#1:793\n402#1:795,2\n662#1:798\n662#1:799,2\n664#1:801\n664#1:802,5\n666#1:807,9\n666#1:816\n666#1:818\n666#1:819\n669#1:820\n669#1:821,3\n676#1:824,14\n662#1:838\n678#1:839\n678#1:840,2\n678#1:842\n716#1:843,9\n716#1:852\n716#1:854\n716#1:855\n738#1:856\n738#1:857,3\n306#1:758\n307#1:759\n314#1:763\n319#1:764\n322#1:765\n325#1:766\n326#1:767\n327#1:768\n328#1:769\n329#1:770\n330#1:771\n331#1:772\n379#1:773,3\n387#1:781,7\n379#1:789,4\n439#1:797\n368#1:864\n216#1:860\n216#1:861,3\n*E\n"})
public final class MediaStoreUtils {
    @NotNull
    public static final MediaStoreUtils INSTANCE = new MediaStoreUtils();
    @NotNull
    private static final String TAG = "MediaStoreUtils";
    @NotNull
    private static final String ARTIST_EXCLUSIONS = "artist_exclusions";
    @NotNull
    private static final String selection;
    @NotNull
    private static final String[] projection;
    @NotNull
    private static final Uri coverUri;
    @NotNull
    private static final List<String> allowedCoverExtensions;

    private MediaStoreUtils() {
    }

    private final FileNode handleMediaFolder(String path, FileNode rootNode) {
        String string2;
        if (StringsKt.endsWith$default((CharSequence)path, (char)'/', (boolean)false, (int)2, null)) {
            String string3 = path.substring(1, path.length() - 1);
            string2 = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"substring(...)");
        } else {
            String string4 = path.substring(1);
            string2 = string4;
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
        }
        String newPath = string2;
        char[] cArray = new char[]{'/'};
        List splitPath = StringsKt.split$default((CharSequence)newPath, (char[])cArray, (boolean)false, (int)0, (int)6, null);
        FileNode node = rootNode;
        for (String fld : splitPath.subList(0, splitPath.size() - 1)) {
            FileNode newNode = node.getFolderList().get(fld);
            if (newNode == null) {
                newNode = new FileNode(fld);
                ((Map)node.getFolderList()).put(newNode.getFolderName(), newNode);
            }
            node = newNode;
        }
        return node;
    }

    private final void handleShallowTrack(Track mediaItem2, Long albumId, String path, FileNode shallowFolder, List<String> folderArray) {
        String string2;
        if (StringsKt.endsWith$default((CharSequence)path, (char)'/', (boolean)false, (int)2, null)) {
            String string3 = path.substring(0, path.length() - 1);
            string2 = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"substring(...)");
        } else {
            string2 = path;
        }
        String newPath = string2;
        char[] cArray = new char[]{'/'};
        List splitPath = StringsKt.split$default((CharSequence)newPath, (char[])cArray, (boolean)false, (int)0, (int)6, null);
        if (splitPath.size() < 2) {
            throw new IllegalArgumentException("splitPath.size < 2: " + newPath);
        }
        String lastFolderName = (String)splitPath.get(splitPath.size() - 2);
        FileNode folder = shallowFolder.getFolderList().get(lastFolderName);
        if (folder == null) {
            folder = new FileNode(lastFolderName);
            ((Map)shallowFolder.getFolderList()).put(folder.getFolderName(), folder);
            String string4 = newPath.substring(0, ((String)splitPath.get(splitPath.size() - 1)).length() + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
            folderArray.add(string4);
        }
        folder.addSong(mediaItem2, albumId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final boolean playlistContent(Context context, List<Pair<MPlaylist, List<Long>>> playlists) {
        boolean foundPlaylistContent = false;
        Object object = new String[]{"_id", "name", "date_modified"};
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, object, null, null, null);
        if (cursor != null) {
            object = (Closeable)cursor;
            Throwable throwable = null;
            try {
                Cursor cursor2 = (Cursor)object;
                boolean bl = false;
                int n = cursor2.getColumnIndexOrThrow("_id");
                int n2 = cursor2.getColumnIndexOrThrow("name");
                int n3 = cursor2.getColumnIndexOrThrow("date_modified");
                while (cursor2.moveToNext()) {
                    String string2;
                    long l = cursor2.getLong(n);
                    String string3 = cursor2.getString(n2);
                    if (string3 != null) {
                        CharSequence charSequence;
                        CharSequence charSequence2 = string3;
                        if (charSequence2.length() == 0) {
                            boolean bl2 = false;
                            charSequence = null;
                        } else {
                            charSequence = charSequence2;
                        }
                        string2 = (String)charSequence;
                    } else {
                        string2 = null;
                    }
                    String string4 = string2;
                    long l2 = cursor2.getLong(n3);
                    List list2 = new ArrayList();
                    Object object2 = new String[]{"audio_id"};
                    Cursor cursor3 = context.getContentResolver().query(MediaStore.Audio.Playlists.Members.getContentUri((String)"external", (long)l), object2, null, null, "play_order ASC");
                    if (cursor3 != null) {
                        object2 = (Closeable)cursor3;
                        Throwable throwable2 = null;
                        try {
                            Cursor cursor4 = (Cursor)object2;
                            boolean bl3 = false;
                            int n4 = cursor4.getColumnIndexOrThrow("audio_id");
                            while (cursor4.moveToNext()) {
                                foundPlaylistContent = true;
                                list2.add(cursor4.getLong(n4));
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                        catch (Throwable throwable3) {
                            throwable2 = throwable3;
                            throw throwable3;
                        }
                        finally {
                            CloseableKt.closeFinally((Closeable)object2, (Throwable)throwable2);
                        }
                    }
                    MPlaylist mPlaylist = new MPlaylist(l, string4, new LinkedHashSet(), null, l2);
                    playlists.add((Pair<MPlaylist, List<Long>>)new Pair((Object)mPlaylist, (Object)list2));
                }
                Unit unit = Unit.INSTANCE;
            }
            catch (Throwable throwable4) {
                throwable = throwable4;
                throw throwable4;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
            }
        }
        return foundPlaylistContent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void parseSongQuery(Cursor $this$parseSongQuery, int limitValue, Set<String> folderFilter, List<String> blacklistKeywords, Context context, List<Track> songs, boolean foundPlaylistContent, Map<Long, Track> idMap, Settings settings, Function1<? super Track, Unit> block) {
        var11_11 = (Closeable)$this$parseSongQuery;
        var12_12 = null;
        try {
            cursor\1 = (Cursor)var11_11;
            $i$a$-use-MediaStoreUtils$parseSongQuery$1\1\282\0 = false;
            idColumn\1 = cursor\1.getColumnIndexOrThrow("_id");
            titleColumn\1 = cursor\1.getColumnIndexOrThrow("title");
            artistColumn\1 = cursor\1.getColumnIndexOrThrow("artist");
            albumColumn\1 = cursor\1.getColumnIndexOrThrow("album");
            albumArtistColumn\1 = cursor\1.getColumnIndexOrThrow("album_artist");
            trackNumberColumn\1 = cursor\1.getColumnIndexOrThrow("track");
            pathColumn\1 = cursor\1.getColumnIndexOrThrow("_data");
            yearColumn\1 = cursor\1.getColumnIndexOrThrow("year");
            albumIdColumn\1 = cursor\1.getColumnIndexOrThrow("album_id");
            genreColumn\1 = MediaStoreUtils.INSTANCE.hasImprovedMediaStore() != false ? Integer.valueOf(cursor\1.getColumnIndexOrThrow("genre")) : null;
            durationColumn\1 = cursor\1.getColumnIndexOrThrow("duration");
            addDateColumn\1 = cursor\1.getColumnIndexOrThrow("date_added");
            var27_29 = settings.getString("artist_exclusions");
            if (var27_29 == null || (var29_31 = StringsKt.split$default((CharSequence)var27_29, (char[])(var28_30 /* !! */  = new char[]{'|'}), (boolean)false, (int)0, (int)6, null)) == null) ** GOTO lbl-1000
            var30_32 = var29_31;
            $i$f$mapNotNull\2\301 = false;
            var32_36 = $this$mapNotNull\2;
            destination\3 = new ArrayList<E>();
            $i$f$mapNotNullTo\3\745 = false;
            $this$forEach\4 = $this$mapNotNullTo\3;
            $i$f$forEach\4\753 = false;
            var37_46 = $this$forEach\4.iterator();
            while (var37_46.hasNext()) {
                element\5 = element\4 = var37_46.next();
                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\5\754\3 = false;
                it\6 = (String)element\5;
                $i$a$-mapNotNull-MediaStoreUtils$parseSongQuery$1$artistExclusions$1\6\753\1 = false;
                s\7 = var43_59 = StringsKt.trim((CharSequence)it\6).toString();
                $i$a$-takeIf-MediaStoreUtils$parseSongQuery$1$artistExclusions$1$1\7\301\7 = false;
                if ((!StringsKt.isBlank((CharSequence)s\7) ? var43_59 : null) == null) continue;
                it\5 = it\5;
                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\8\755\5 = false;
                destination\3.add(it\5);
            }
            $this$mapNotNull\2 = CollectionsKt.toSet((Iterable)((List)destination\3));
            if ($this$mapNotNull\2 != null) {
                v0 = $this$mapNotNull\2;
            } else lbl-1000:
            // 2 sources

            {
                v0 = artistExclusions\1 = SetsKt.emptySet();
            }
            while (cursor\1.moveToNext()) {
                block22: {
                    var28_30 /* !! */  = (char[])cursor\1;
                    index\9 = pathColumn\1;
                    $i$f$getStringOrNull\9\306 = false;
                    if (($this$getStringOrNull\9.isNull(index\9) != false ? null : $this$getStringOrNull\9.getString(index\9)) == null) continue;
                    path\1 = path\1;
                    $this$getStringOrNull\9 = cursor\1;
                    index\10 = durationColumn\1;
                    $i$f$getLongOrNull\10\307 = false;
                    duration\1 = $this$getLongOrNull\10.isNull(index\10) != false ? null : Long.valueOf($this$getLongOrNull\10.getLong(index\10));
                    v1 = new File(path\1).getParentFile();
                    v2 = fldPath\1 = v1 != null ? v1.getAbsolutePath() : null;
                    if (duration\1 != null && duration\1 < (long)(limitValue * 1000) || CollectionsKt.contains((Iterable)folderFilter, (Object)fldPath\1)) ** GOTO lbl-1000
                    $this$any\11 = blacklistKeywords;
                    $i$f$any\11\311 = false;
                    if ($this$any\11 instanceof Collection && ((Collection)$this$any\11).isEmpty()) {
                        v3 = false;
                    } else {
                        for (E element\11 : $this$any\11) {
                            it\12 = (String)element\11;
                            $i$a$-any-MediaStoreUtils$parseSongQuery$1$skip$1\12\761\1 = false;
                            v4 = fldPath\1;
                            v5 = v4 != null ? StringsKt.contains((CharSequence)v4, (CharSequence)it\12, (boolean)true) : false;
                            if (!v5) continue;
                            v3 = true;
                            break block22;
                        }
                        v3 = false;
                    }
                }
                if (v3) lbl-1000:
                // 2 sources

                {
                    v6 = true;
                } else {
                    v6 = skip\1 = false;
                }
                if (skip\1 && !foundPlaylistContent) continue;
                destination\3 = cursor\1;
                index\13 = idColumn\1;
                $i$f$getLongOrNull\13\314 = false;
                v7 = $this$getLongOrNull\13.isNull(index\13) != false ? null : Long.valueOf($this$getLongOrNull\13.getLong(index\13));
                Intrinsics.checkNotNull(v7);
                id\1 = v7;
                $i$f$getLongOrNull\13\314 = cursor\1;
                index\14 = titleColumn\1;
                $i$f$getStringOrNull\14\319 = false;
                v8 = MediaStoreUtils.INSTANCE.fixWin1252($this$getStringOrNull\14.isNull(index\14) != false ? null : $this$getStringOrNull\14.getString(index\14));
                if (v8 == null) {
                    v8 = "";
                }
                title\1 = v8;
                $this$getStringOrNull\14 = cursor\1;
                index\15 = artistColumn\1;
                $i$f$getStringOrNull\15\322 = false;
                v\16 = MediaStoreUtils.INSTANCE.fixWin1252($this$getStringOrNull\15.isNull(index\15) != false ? null : $this$getStringOrNull\15.getString(index\15));
                $i$a$-let-MediaStoreUtils$parseSongQuery$1$artist$1\16\324\1 = false;
                artist\1 = Intrinsics.areEqual((Object)v\16, (Object)"<unknown>") ? null : v\16;
                v\16 = cursor\1;
                index\17 = albumColumn\1;
                $i$f$getStringOrNull\17\325 = false;
                albumName\1 = MediaStoreUtils.INSTANCE.fixWin1252($this$getStringOrNull\17.isNull(index\17) != false ? null : $this$getStringOrNull\17.getString(index\17));
                index\17 = cursor\1;
                index\18 = albumArtistColumn\1;
                $i$f$getStringOrNull\18\326 = false;
                albumArtist\1 = MediaStoreUtils.INSTANCE.fixWin1252($this$getStringOrNull\18.isNull(index\18) != false ? null : $this$getStringOrNull\18.getString(index\18));
                index\18 = cursor\1;
                index\19 = trackNumberColumn\1;
                $i$f$getIntOrNull\19\327 = false;
                trackNumber\1 = $this$getIntOrNull\19.isNull(index\19) != false ? null : Integer.valueOf($this$getIntOrNull\19.getInt(index\19));
                index\19 = cursor\1;
                index\20 = yearColumn\1;
                $i$f$getIntOrNull\20\328 = false;
                v\21 = $this$getIntOrNull\20.isNull(index\20) != false ? null : Integer.valueOf($this$getIntOrNull\20.getInt(index\20));
                $i$a$-let-MediaStoreUtils$parseSongQuery$1$year$1\21\328\1 = false;
                v9 = v\21;
                year\1 = v9 != null && v9 == 0 ? null : v\21;
                v\21 = cursor\1;
                index\22 = albumIdColumn\1;
                $i$f$getLongOrNull\22\329 = false;
                albumId\1 = $this$getLongOrNull\22.isNull(index\22) != false ? null : Long.valueOf($this$getLongOrNull\22.getLong(index\22));
                v10 = genreColumn\1;
                if (v10 != null) {
                    col\23 = ((Number)v10).intValue();
                    $i$a$-let-MediaStoreUtils$parseSongQuery$1$genre$1\23\330\1 = false;
                    s\7 = cursor\1;
                    index\24 = col\23;
                    $i$f$getStringOrNull\24\330 = false;
                    v11 = $this$getStringOrNull\24.isNull(index\24) ? null : $this$getStringOrNull\24.getString(index\24);
                } else {
                    v11 = null;
                }
                genre\1 = v11;
                col\23 = cursor\1;
                index\25 = addDateColumn\1;
                $i$f$getLongOrNull\25\331 = false;
                addDate\1 = $this$getLongOrNull\25.isNull(index\25) != false ? null : Long.valueOf($this$getLongOrNull\25.getLong(index\25));
                uri\26 = index\25 = ContentUris.appendId((Uri.Builder)MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.buildUpon(), (long)id\1).appendPath("albumart").build();
                $i$a$-takeIf-MediaStoreUtils$parseSongQuery$1$imgUri$1\26\334\1 = false;
                $i$f$getStringOrNull\24\330 = context.getContentResolver();
                try {
                    $this$parseSongQuery_u24lambda_u2414_u24lambda_u2412_u24lambda_u2411\27 /* !! */  = $i$f$getStringOrNull\24\330;
                    $i$a$-runCatching-MediaStoreUtils$parseSongQuery$1$imgUri$1$1\27\335\26 = false;
                    v12 = $this$parseSongQuery_u24lambda_u2414_u24lambda_u2412_u24lambda_u2411\27 /* !! */ .openInputStream(uri\26);
                    Intrinsics.checkNotNull((Object)v12);
                    v12.close();
                    $this$parseSongQuery_u24lambda_u2414_u24lambda_u2412_u24lambda_u2411\27 /* !! */  = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable var51_78) {
                    $this$parseSongQuery_u24lambda_u2414_u24lambda_u2412_u24lambda_u2411\27 /* !! */  = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var51_78));
                }
                imgUri\1 = Result.isSuccess-impl((Object)$this$parseSongQuery_u24lambda_u2414_u24lambda_u2412_u24lambda_u2411\27 /* !! */ ) != false ? index\25 : null;
                artists\1 = MediaStoreUtils.INSTANCE.toArtists(artist\1, artistExclusions\1);
                if (albumName\1 != null) {
                    $i$a$-let-MediaStoreUtils$parseSongQuery$1$album$1\28\339\1 = false;
                    v13 = new Album(String.valueOf(albumId\1), it\28, null, null, MediaStoreUtils.INSTANCE.toArtists(albumArtist\1, artistExclusions\1), null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048544, null);
                } else {
                    v13 = null;
                }
                album\1 = v13;
                var46_68 = String.valueOf(id\1);
                v14 /* !! */  = imgUri\1;
                var47_73 = v14 /* !! */  != null && (v14 /* !! */  = v14 /* !! */ .toString()) != null ? ImageHolder.Companion.toResourceUriImageHolder$default(ImageHolder.Companion, (String)v14 /* !! */ , false, 1, null) : null;
                v15 = year\1;
                var51_76 = v15 != null ? dev.brahmkshatriya.echo.common.models.Date.Companion.toYearDate(v15) : null;
                var52_79 = CollectionsKt.listOf((Object)Streamable.Companion.server$default(Streamable.Companion, path\1, 0, path\1, null, 8, null));
                var53_80 = new Pair[4];
                v16 = genre\1;
                if (v16 == null) {
                    v17 = context.getString(R.string.unknown);
                    v16 = v17;
                    Intrinsics.checkNotNullExpressionValue((Object)v17, (String)"getString(...)");
                }
                var53_80[0] = TuplesKt.to((Object)"genre", (Object)v16);
                var53_80[1] = TuplesKt.to((Object)"addDate", (Object)String.valueOf(addDate\1));
                var53_80[2] = TuplesKt.to((Object)"trackNumber", (Object)String.valueOf(trackNumber\1));
                var53_80[3] = TuplesKt.to((Object)"extension_id", (Object)OfflineExtension.Companion.getMetadata().getId());
                var54_81 = MapsKt.mapOf((Pair[])var53_80);
                song\1 = new Track(var46_68, title\1, null, var47_73, artists\1, album\1, duration\1, null, null, var51_76, null, null, null, null, null, null, null, false, null, var54_81, null, var52_79, false, false, false, false, false, false, 265813380, null);
                v18 = idMap;
                v19 = v18 != null ? v18.put(id\1, song\1) : null;
                if (skip\1) continue;
                songs.add(song\1);
                block.invoke((Object)song\1);
            }
            var13_13 = Unit.INSTANCE;
        }
        catch (Throwable var14_15) {
            var12_12 = var14_15;
            throw var14_15;
        }
        finally {
            CloseableKt.closeFinally((Closeable)var11_11, (Throwable)var12_12);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void songAlbumMap(Track song, Integer year, Map<Long, AlbumImpl> albumMap, Map<Long, MArtist> artistMap, boolean haveImgPerm) {
        Object object;
        void $this$getOrPut\1;
        Album album = song.getAlbum();
        if (album == null) {
            return;
        }
        Album album2 = album;
        long id2 = Long.parseLong(album2.getId());
        Map<Long, AlbumImpl> map2 = albumMap;
        Long l = id2;
        boolean bl = false;
        Object v = $this$getOrPut\1.get(l);
        if (v == null) {
            AlbumImpl albumImpl;
            void $this$mapTo\4;
            boolean bl2 = false;
            Uri uri = haveImgPerm ? null : ContentUris.withAppendedId((Uri)coverUri, (long)id2);
            Iterable iterable = album2.getArtists();
            boolean bl3 = false;
            Iterable iterable2 = iterable;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            boolean bl4 = false;
            for (Object t : $this$mapTo\4) {
                void it\5;
                Artist artist = (Artist)t;
                Collection collection2 = collection;
                boolean bl5 = false;
                collection2.add(new MArtist(StringsKt.toLongOrNull((String)it\5.getId()), it\5.getName(), new LinkedHashSet(), new ArrayList()));
            }
            List list2 = (List)collection;
            AlbumImpl albumImpl2 = albumImpl = new AlbumImpl(id2, album2.getTitle(), list2, year, uri, new LinkedHashSet());
            boolean bl6 = false;
            Iterable iterable3 = list2;
            boolean bl7 = false;
            for (Object t : iterable3) {
                Object object2;
                void $this$getOrPut\9;
                MArtist mArtist = (MArtist)t;
                boolean bl8 = false;
                Map<Long, MArtist> map3 = artistMap;
                Long l2 = mArtist.getId();
                boolean bl9 = false;
                Object v2 = $this$getOrPut\9.get(l2);
                if (v2 == null) {
                    boolean bl10 = false;
                    MArtist mArtist2 = new MArtist(mArtist.getId(), mArtist.getTitle(), new LinkedHashSet(), new ArrayList());
                    $this$getOrPut\9.put(l2, mArtist2);
                    object2 = mArtist2;
                } else {
                    object2 = v2;
                }
                MArtist mArtist3 = (MArtist)object2;
                mArtist3.getAlbumList().add(albumImpl2);
            }
            AlbumImpl albumImpl3 = albumImpl;
            $this$getOrPut\1.put(l, albumImpl3);
            object = albumImpl3;
        } else {
            object = v;
        }
        ((AlbumImpl)object).getSongList().add(song);
    }

    private final List<MAlbum> albumMapToAlbumList(Map<Long, AlbumImpl> albumMap, HashMap<Long, Pair<File, FileNode>> coverCache) {
        Iterable iterable;
        Iterable iterable2 = albumMap.values();
        boolean bl = false;
        Iterable iterable3 = iterable = iterable2;
        boolean bl2 = false;
        for (Object t : iterable3) {
            File file2;
            AlbumImpl albumImpl = (AlbumImpl)t;
            boolean bl3 = false;
            Iterable iterable4 = albumImpl.getArtists();
            boolean bl4 = false;
            for (Object t2 : iterable4) {
                MArtist mArtist = (MArtist)t2;
                boolean bl5 = false;
                Object object = mArtist;
                if (object == null || (object = ((MArtist)object).getAlbumList()) == null) continue;
                object.add(albumImpl);
            }
            Pair pair = coverCache;
            if (pair == null || (pair = (Pair)((Map)pair).get(albumImpl.getId())) == null) continue;
            Pair pair2 = pair;
            boolean bl6 = false;
            if (!Intrinsics.areEqual((Object)((FileNode)pair2.getSecond()).getAlbumId(), (Object)albumImpl.getId())) continue;
            int n = 0;
            File file3 = null;
            try {
                File[] fileArray;
                if (((File)pair2.getFirst()).listFiles() == null) continue;
                for (File file4 : fileArray) {
                    Intrinsics.checkNotNull((Object)file4);
                    if (!allowedCoverExtensions.contains(FilesKt.getExtension((File)file4))) continue;
                    int n2 = 1;
                    switch (FilesKt.getExtension((File)file4)) {
                        case "jpg": {
                            n2 += 3;
                            break;
                        }
                        case "png": {
                            n2 += 2;
                            break;
                        }
                        case "jpeg": {
                            ++n2;
                        }
                    }
                    if (Intrinsics.areEqual((Object)FilesKt.getNameWithoutExtension((File)file4), (Object)"albumart")) {
                        n2 += 24;
                    } else if (Intrinsics.areEqual((Object)FilesKt.getNameWithoutExtension((File)file4), (Object)"cover")) {
                        n2 += 20;
                    } else if (StringsKt.startsWith$default((String)FilesKt.getNameWithoutExtension((File)file4), (String)"albumart", (boolean)false, (int)2, null)) {
                        n2 += 16;
                    } else if (StringsKt.startsWith$default((String)FilesKt.getNameWithoutExtension((File)file4), (String)"cover", (boolean)false, (int)2, null)) {
                        n2 += 12;
                    } else if (StringsKt.contains$default((CharSequence)FilesKt.getNameWithoutExtension((File)file4), (CharSequence)"albumart", (boolean)false, (int)2, null)) {
                        n2 += 8;
                    } else if (StringsKt.contains$default((CharSequence)FilesKt.getNameWithoutExtension((File)file4), (CharSequence)"cover", (boolean)false, (int)2, null)) {
                        n2 += 4;
                    }
                    if (n >= n2) continue;
                    n = n2;
                    file3 = file4;
                }
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)Log.getStackTraceString((Throwable)exception));
            }
            if (n < 3) continue;
            if (file3 == null) continue;
            boolean bl7 = false;
            File file5 = file2;
            boolean bl8 = false;
            albumImpl.setCover(Uri.fromFile(file5));
        }
        return CollectionsKt.toMutableList((Collection)((Collection)iterable));
    }

    @Nullable
    public final Object getAllSongs(@NotNull Context context, @NotNull Settings settings, @NotNull Continuation<? super LibraryStoreClass> $completion) {
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super LibraryStoreClass>, Object>(settings, context, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Settings $settings;
            final /* synthetic */ Context $context;
            {
                this.$settings = $settings;
                this.$context = $context;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = this.$settings.getInt("limit_value");
                        limitValueSeconds = v0 != null ? v0 : 10;
                        haveImgPerm = MediaStoreUtils.access$hasScopedStorage(MediaStoreUtils.INSTANCE) != false ? MediaStoreUtils.INSTANCE.hasImagePermission(this.$context) : false;
                        v1 = this.$settings.getStringSet("blacklist_folders");
                        if (v1 == null) {
                            v1 = folderFilter = SetsKt.emptySet();
                        }
                        if ((var7_6 = this.$settings.getString("blacklist_keywords")) != null && (var8_8 = StringsKt.split$default((CharSequence)var7_6, (char[])(var9_7 /* !! */  = new char[]{','}), (boolean)false, (int)0, (int)6, null)) != null) {
                            var9_7 /* !! */  = (char[])((Iterable)var8_8);
                            $i$f$mapNotNull\1\458 = false;
                            var11_12 = $this$mapNotNull\1;
                            destination\2 = new ArrayList<E>();
                            $i$f$mapNotNullTo\2\744 = false;
                            $this$forEach\3 = $this$mapNotNullTo\2;
                            $i$f$forEach\3\752 = false;
                            for (T element\3 : $this$forEach\3) {
                                element\4 = element\3;
                                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\4\753\2 = false;
                                it\6 = (String)element\4;
                                $i$a$-mapNotNull-MediaStoreUtils$getAllSongs$2$blacklistKeywords$1\6\752\0 = false;
                                s\7 = var22_34 = StringsKt.trim((CharSequence)it\6).toString();
                                $i$a$-takeIf-MediaStoreUtils$getAllSongs$2$blacklistKeywords$1$1\7\458\6 = false;
                                if ((!StringsKt.isBlank((CharSequence)s\7) ? var22_34 : null) == null) continue;
                                it\4 = it\4;
                                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\5\755\4 = false;
                                destination\2.add(it\4);
                            }
                            v2 = (List)destination\2;
                        } else {
                            v2 = v3 = null;
                        }
                        if (v2 == null) {
                            v3 = blacklistKeywords = CollectionsKt.emptyList();
                        }
                        if ((var8_8 = this.$settings.getString("artist_exclusions")) == null || ($this$mapNotNull\1 = StringsKt.split$default((CharSequence)((CharSequence)var8_8), (char[])($i$f$mapNotNull\1\458 = new char[]{'|'}), (boolean)false, (int)0, (int)6, null)) == null) ** GOTO lbl-1000
                        $this$mapNotNullTo\2 = $this$mapNotNull\1;
                        $i$f$mapNotNull\8\462 = false;
                        $i$f$mapNotNullTo\2\744 = $this$mapNotNull\8;
                        destination\9 = new ArrayList<E>();
                        $i$f$mapNotNullTo\9\758 = false;
                        $this$forEach\10 = $this$mapNotNullTo\9;
                        $i$f$forEach\10\766 = false;
                        element\4 = $this$forEach\10.iterator();
                        while (element\4.hasNext()) {
                            element\11 = element\10 = element\4.next();
                            $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\11\767\9 = false;
                            it\13 = (String)element\11;
                            $i$a$-mapNotNull-MediaStoreUtils$getAllSongs$2$artistExclusions$1\13\766\0 = false;
                            s\14 = $i$a$-takeIf-MediaStoreUtils$getAllSongs$2$blacklistKeywords$1$1\7\458\6 = StringsKt.trim((CharSequence)((CharSequence)it\13)).toString();
                            $i$a$-takeIf-MediaStoreUtils$getAllSongs$2$artistExclusions$1$1\14\462\13 = false;
                            if ((!StringsKt.isBlank((CharSequence)s\14) ? $i$a$-takeIf-MediaStoreUtils$getAllSongs$2$blacklistKeywords$1$1\7\458\6 : null) == null) continue;
                            it\11 = it\11;
                            $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\12\768\11 = false;
                            destination\9.add(it\11);
                        }
                        $this$mapNotNull\8 = CollectionsKt.toSet((Iterable)((List)destination\9));
                        if ($this$mapNotNull\8 != null) {
                            v4 = $this$mapNotNull\8;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v4 = SetsKt.emptySet();
                        }
                        artistExclusions = v4;
                        coverCache = haveImgPerm != false ? new HashMap<K, V>() : null;
                        folders = new HashSet<E>();
                        folderArray = new ArrayList<E>();
                        root = new FileNode("storage");
                        shallowRoot = new FileNode("shallow");
                        songs = new ArrayList<E>();
                        albumMap = new LinkedHashMap<K, V>();
                        artistMap = new LinkedHashMap<K, V>();
                        albumArtistMap = new HashMap<K, V>();
                        genreMap = new HashMap<K, V>();
                        dateMap = new HashMap<K, V>();
                        playlists = new ArrayList<E>();
                        it\13 = $this$withContext;
                        $i$a$-mapNotNull-MediaStoreUtils$getAllSongs$2$artistExclusions$1\13\766\0 = this.$context;
                        try {
                            $this$invokeSuspend_u24lambda_u244\15 = it\13;
                            $i$a$-runCatching-MediaStoreUtils$getAllSongs$2$foundPlaylistContent$1\15\481\0 = false;
                            $this$invokeSuspend_u24lambda_u244\15 = Result.constructor-impl((Object)Boxing.boxBoolean((boolean)MediaStoreUtils.access$playlistContent(MediaStoreUtils.INSTANCE, $i$a$-mapNotNull-MediaStoreUtils$getAllSongs$2$artistExclusions$1\13\766\0, playlists)));
                        }
                        catch (Throwable $i$a$-runCatching-MediaStoreUtils$getAllSongs$2$foundPlaylistContent$1\15\481\0) {
                            $this$invokeSuspend_u24lambda_u244\15 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-MediaStoreUtils$getAllSongs$2$foundPlaylistContent$1\15\481\0));
                        }
                        it\13 = $this$invokeSuspend_u24lambda_u244\15;
                        v5 = (Boolean)(Result.isFailure-impl((Object)it\13) != false ? null : it\13);
                        foundPlaylistContent = v5 != null ? v5 : false;
                        idMap = new HashMap<K, V>();
                        uri = Build.VERSION.SDK_INT >= 29 ? MediaStore.Audio.Media.getContentUri((String)"external") : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        v6 = cursor = this.$context.getContentResolver().query(uri, MediaStoreUtils.access$getProjection$p(), MediaStoreUtils.access$getSelection$p(), null, "title COLLATE UNICODE ASC");
                        if (v6 != null) {
                            MediaStoreUtils.access$parseSongQuery(MediaStoreUtils.INSTANCE, v6, limitValueSeconds, folderFilter, blacklistKeywords, this.$context, songs, foundPlaylistContent != false, idMap, this.$settings, (Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$10(java.util.Map java.util.Map boolean dev.brahmkshatriya.echo.extensions.builtin.offline.MediaStoreUtils$FileNode java.util.HashMap dev.brahmkshatriya.echo.extensions.builtin.offline.MediaStoreUtils$FileNode java.util.List java.util.HashMap java.util.HashMap java.util.HashSet dev.brahmkshatriya.echo.common.models.Track ), (Ldev/brahmkshatriya/echo/common/models/Track;)Lkotlin/Unit;)((Map)albumMap, (Map)artistMap, (boolean)(haveImgPerm != false), (FileNode)root, coverCache, (FileNode)shallowRoot, (List)folderArray, genreMap, dateMap, folders));
                        }
                        albumList = MediaStoreUtils.access$albumMapToAlbumList(MediaStoreUtils.INSTANCE, albumMap, coverCache);
                        v7 = albumArtistMap.entrySet();
                        Intrinsics.checkNotNullExpressionValue(v7, (String)"<get-entries>(...)");
                        $this$forEach\16 = v7;
                        $i$f$forEach\16\536 = false;
                        for (E element\16 : $this$forEach\16) {
                            var29_52 = (Map.Entry)element\16;
                            $i$a$-forEach-MediaStoreUtils$getAllSongs$2$2\17\771\0 = false;
                            Intrinsics.checkNotNull((Object)var29_52);
                            artist\17 = (MArtist)var29_52.getKey();
                            v8 = var29_52.getValue();
                            Intrinsics.checkNotNullExpressionValue(v8, (String)"component2(...)");
                            pair\17 = (Pair)v8;
                            albums\17 = (Set)pair\17.getFirst();
                            song\17 = (Set)pair\17.getSecond();
                            v9 = artist\17;
                            v10 = artist\17;
                            new MArtist(v9 != null ? v9.getId() : null, v10 != null ? v10.getTitle() : null, song\17, CollectionsKt.toMutableList((Collection)albums\17));
                        }
                        v11 = genreMap.values();
                        Intrinsics.checkNotNullExpressionValue(v11, (String)"<get-values>(...)");
                        genreList = CollectionsKt.toMutableList(v11);
                        v12 = dateMap.values();
                        Intrinsics.checkNotNullExpressionValue(v12, (String)"<get-values>(...)");
                        dateList = CollectionsKt.toMutableList(v12);
                        $this$map\18 = playlists;
                        $i$f$map\18\544 = false;
                        $i$a$-forEach-MediaStoreUtils$getAllSongs$2$2\17\771\0 = $this$map\18;
                        destination\19 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\18, (int)10));
                        $i$f$mapTo\19\773 = false;
                        for (T item\19 : $this$mapTo\19) {
                            var35_62 = (Pair)item\19;
                            var52_78 = destination\19;
                            $i$a$-map-MediaStoreUtils$getAllSongs$2$playlistsFinal$1\20\775\0 = false;
                            var37_64 = it\20.getFirst();
                            playlist\21 = (MPlaylist)var37_64;
                            $i$a$-also-MediaStoreUtils$getAllSongs$2$playlistsFinal$1$1\21\545\20 = false;
                            var40_67 = (Iterable)it\20.getSecond();
                            var41_68 = playlist\21.getSongList();
                            $i$f$map\22\546 = false;
                            var43_70 = $this$map\22;
                            destination\23 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\22, (int)10));
                            $i$f$mapTo\23\776 = false;
                            for (T item\23 : $this$mapTo\23) {
                                var48_75 = ((Number)item\23).longValue();
                                var50_76 = destination\23;
                                $i$a$-map-MediaStoreUtils$getAllSongs$2$playlistsFinal$1$1$1\24\778\21 = false;
                                v13 = (Track)idMap.get(Boxing.boxLong((long)value\24));
                                if (v13 == null) {
                                    v13 = MediaStoreUtils.access$dummyTrack(MediaStoreUtils.INSTANCE, (long)value\24, "Unknown [" + (long)value\24 + "]");
                                }
                                var50_76.add(v13);
                            }
                            var41_68.addAll((List)destination\23);
                            var52_78.add((MPlaylist)var37_64);
                        }
                        playlistsFinal = CollectionsKt.toMutableList((Collection)((List)destination\19));
                        v14 = likedPlaylist = MediaStoreUtils.access$getLikedPlaylist(MediaStoreUtils.INSTANCE, this.$context, playlistsFinal);
                        if (v14 != null) {
                            it\25 = v14;
                            $i$a$-let-MediaStoreUtils$getAllSongs$2$3\25\553\0 = false;
                            playlistsFinal.add(0, it\25);
                        }
                        folders.addAll(folderFilter);
                        return new LibraryStoreClass(songs, albumList, artistMap, genreList, dateList, playlistsFinal, likedPlaylist, root, shallowRoot, (Set<String>)folders);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super LibraryStoreClass> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * WARNING - void declaration
             */
            private static final Unit invokeSuspend$lambda$10(Map $albumMap, Map $artistMap, boolean $haveImgPerm, FileNode $root, HashMap $coverCache, FileNode $shallowRoot, List $folderArray, HashMap $genreMap, HashMap $dateMap, HashSet $folders, Track song) {
                Object object;
                void $this$getOrPut\9;
                Object object2;
                Map map2;
                Object object3;
                void $this$mapTo\2;
                Iterable iterable = song.getArtists();
                boolean bl = false;
                Iterable iterable2 = iterable;
                Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                boolean bl2 = false;
                for (T t : $this$mapTo\2) {
                    Object object4;
                    void $this$getOrPut\4;
                    void it\3;
                    Artist artist = (Artist)t;
                    Collection collection2 = collection;
                    boolean bl3 = false;
                    Long l = StringsKt.toLongOrNull((String)it\3.getId());
                    Map map3 = $artistMap;
                    Long l2 = l;
                    boolean bl4 = false;
                    V v = $this$getOrPut\4.get(l2);
                    if (v == null) {
                        boolean bl5 = false;
                        MArtist mArtist = new MArtist(l, it\3.getName(), (Set<Track>)new LinkedHashSet<E>(), (List<MAlbum>)new ArrayList<E>());
                        $this$getOrPut\4.put(l2, mArtist);
                        object4 = mArtist;
                    } else {
                        object4 = v;
                    }
                    MArtist mArtist = (MArtist)object4;
                    mArtist.getSongList().add(song);
                    collection2.add(mArtist);
                }
                List cfr_ignored_0 = (List)collection;
                dev.brahmkshatriya.echo.common.models.Date date = song.getReleaseDate();
                Integer year = date != null ? Integer.valueOf(date.getYear()) : null;
                MediaStoreUtils.access$songAlbumMap(MediaStoreUtils.INSTANCE, song, year, $albumMap, $artistMap, $haveImgPerm);
                Object object5 = song.getAlbum();
                Long albumId = object5 != null && (object5 = ((Album)object5).getId()) != null ? Long.valueOf(Long.parseLong((String)object5)) : null;
                String path = ((Streamable)CollectionsKt.first(song.getStreamables())).getId();
                File parent = new File(path).getParentFile();
                Object object6 = parent;
                if (object6 != null && (object6 = ((File)object6).getAbsolutePath()) != null) {
                    object3 = object6;
                    boolean bl6 = false;
                    $folders.add(object3);
                }
                FileNode fn = MediaStoreUtils.access$handleMediaFolder(MediaStoreUtils.INSTANCE, path, $root);
                Object object7 = song.getAlbum();
                fn.addSong(song, object7 != null && (object7 = ((Album)object7).getId()) != null ? Long.valueOf(Long.parseLong((String)object7)) : null);
                if (albumId != null && parent != null) {
                    HashMap hashMap = $coverCache;
                    if (hashMap != null) {
                        hashMap.putIfAbsent(albumId, new Pair((Object)parent, (Object)fn));
                    }
                }
                MediaStoreUtils.access$handleShallowTrack(MediaStoreUtils.INSTANCE, song, albumId, path, $shallowRoot, $folderArray);
                String string2 = song.getExtras().get("genre");
                if (string2 == null) {
                    string2 = "Unknown";
                }
                String genre = string2;
                object3 = $genreMap;
                String string3 = genre;
                boolean bl7 = false;
                V v = map2.get(string3);
                if (v == null) {
                    boolean bl8 = false;
                    Genre genre2 = new Genre(MediaStoreUtils.INSTANCE.id(genre), genre, (Set<Track>)new LinkedHashSet<E>());
                    map2.put(string3, genre2);
                    object2 = genre2;
                } else {
                    object2 = v;
                }
                ((Genre)object2).getSongList().add(song);
                map2 = $dateMap;
                Integer n = year;
                boolean bl9 = false;
                V v2 = $this$getOrPut\9.get(n);
                if (v2 == null) {
                    boolean bl10 = false;
                    Integer n2 = year;
                    Integer n3 = year;
                    Date date2 = new Date(n2 != null ? (long)n2.intValue() : 0L, n3 != null ? n3.toString() : null, (Set<Track>)new LinkedHashSet<E>());
                    $this$getOrPut\9.put(n, date2);
                    object = date2;
                } else {
                    object = v2;
                }
                ((Date)object).getSongList().add(song);
                return Unit.INSTANCE;
            }
        }), $completion);
    }

    private final MPlaylist getLikedPlaylist(Context context, List<MPlaylist> playlistsFinal) {
        MPlaylist mPlaylist;
        MPlaylist mPlaylist2;
        Object v0;
        MediaStoreUtils mediaStoreUtils;
        block5: {
            mediaStoreUtils = this;
            boolean bl = false;
            Iterable iterable = playlistsFinal;
            for (Object t : iterable) {
                MPlaylist mPlaylist3 = (MPlaylist)t;
                boolean bl2 = false;
                if (!Intrinsics.areEqual((Object)mPlaylist3.getTitle(), (Object)"Liked")) continue;
                v0 = t;
                break block5;
            }
            v0 = null;
        }
        MPlaylist mPlaylist4 = mPlaylist2 = (MPlaylist)v0;
        Long l = mPlaylist4 != null ? Long.valueOf(mPlaylist4.getId()) : mediaStoreUtils.createPlaylist(context, "Liked");
        MPlaylist mPlaylist5 = mPlaylist2;
        if (mPlaylist5 != null) {
            MPlaylist mPlaylist6 = mPlaylist5;
            boolean bl = false;
            playlistsFinal.remove(mPlaylist6);
        }
        Long l2 = l;
        if (l2 == null) {
            mPlaylist = null;
        } else {
            long l3 = l2;
            String string2 = context.getString(R.string.playlist_liked);
            Object object = mPlaylist2;
            if (object == null || (object = ((MPlaylist)object).getSongList()) == null) {
                object = new LinkedHashSet();
            }
            MPlaylist mPlaylist7 = mPlaylist2;
            long l4 = mPlaylist7 != null ? mPlaylist7.getModifiedDate() : System.currentTimeMillis() / 1000L;
            String string3 = context.getString(R.string.playlist_liked_desc);
            Object object2 = object;
            String string4 = string2;
            long l5 = l3;
            mPlaylist = new MPlaylist(l5, string4, (Set<Track>)object2, string3, l4);
        }
        return mPlaylist;
    }

    private final Track dummyTrack(long id2, String title) {
        return new Track(String.valueOf(id2), title, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFFFC, null);
    }

    @RequiresApi(value=33)
    public final boolean hasImagePermission(@NotNull Context $this$hasImagePermission) {
        Intrinsics.checkNotNullParameter((Object)$this$hasImagePermission, (String)"<this>");
        return $this$hasImagePermission.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
    }

    private final boolean hasImprovedMediaStore() {
        return Build.VERSION.SDK_INT >= 30;
    }

    private final boolean hasScopedStorage() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Nullable
    public final Long createPlaylist(@NotNull Context $this$createPlaylist, @NotNull String title) {
        String string2;
        Intrinsics.checkNotNullParameter((Object)$this$createPlaylist, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        ContentValues values = new ContentValues();
        values.put("name", title);
        Uri uri = $this$createPlaylist.getContentResolver().insert(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, values);
        return uri != null && (string2 = uri.getLastPathSegment()) != null ? Long.valueOf(Long.parseLong(string2)) : null;
    }

    public final void editPlaylist(@NotNull Context $this$editPlaylist, long id2, @NotNull String title) {
        Intrinsics.checkNotNullParameter((Object)$this$editPlaylist, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        ContentValues values = new ContentValues();
        values.put("name", title);
        String[] stringArray = new String[]{String.valueOf(id2)};
        $this$editPlaylist.getContentResolver().update(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, values, "_id=?", stringArray);
    }

    public final void deletePlaylist(@NotNull Context $this$deletePlaylist, long id2) {
        Intrinsics.checkNotNullParameter((Object)$this$deletePlaylist, (String)"<this>");
        String[] stringArray = new String[]{String.valueOf(id2)};
        $this$deletePlaylist.getContentResolver().delete(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, "_id=?", stringArray);
    }

    public final void addSongToPlaylist(@NotNull Context $this$addSongToPlaylist, long playlistId, long songId, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$addSongToPlaylist, (String)"<this>");
        ContentValues values = new ContentValues();
        values.put("play_order", Integer.valueOf(index + 1));
        values.put("audio_id", Long.valueOf(songId));
        $this$addSongToPlaylist.getContentResolver().insert(MediaStore.Audio.Playlists.Members.getContentUri((String)"external", (long)playlistId), values);
    }

    public final void removeSongFromPlaylist(@NotNull Context $this$removeSongFromPlaylist, long playlistId, int index) {
        Intrinsics.checkNotNullParameter((Object)$this$removeSongFromPlaylist, (String)"<this>");
        String[] stringArray = new String[]{String.valueOf(index + 1)};
        $this$removeSongFromPlaylist.getContentResolver().delete(MediaStore.Audio.Playlists.Members.getContentUri((String)"external", (long)playlistId), "play_order=?", stringArray);
    }

    public final void moveSongInPlaylist(@NotNull Context $this$moveSongInPlaylist, long playlistId, long song, int from, int to) {
        Intrinsics.checkNotNullParameter((Object)$this$moveSongInPlaylist, (String)"<this>");
        this.removeSongFromPlaylist($this$moveSongInPlaylist, playlistId, from);
        this.addSongToPlaylist($this$moveSongInPlaylist, playlistId, song, to);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <E> List<Pair<Integer, E>> searchBy(@NotNull List<? extends E> $this$searchBy, @NotNull String query, @NotNull Function1<? super E, ? extends List<String>> block) {
        void $this$sortedBy\26;
        void $this$filterTo\24;
        Iterable iterable;
        void $this$mapTo\2;
        Intrinsics.checkNotNullParameter($this$searchBy, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)query, (String)"query");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        Iterable iterable2 = $this$searchBy;
        boolean bl = false;
        Iterable iterable3 = iterable2;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, (int)10));
        boolean bl2 = false;
        Iterator iterator = $this$mapTo\2.iterator();
        while (iterator.hasNext()) {
            Pair pair;
            Object t;
            Object t2 = t = iterator.next();
            Collection collection2 = collection;
            boolean bl3 = false;
            String string2 = query.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
            Object object = new String[]{" "};
            object = StringsKt.split$default((CharSequence)string2, (String[])object, (boolean)false, (int)0, (int)6, null);
            if (object.isEmpty()) {
                boolean bl4 = false;
                pair = TuplesKt.to((Object)5, (Object)item\3);
            } else {
                String string3;
                String string4;
                void $this$mapNotNullTo\9;
                Collection collection3;
                Object object2;
                void $this$flatMapTo\6;
                List list2 = (List)object;
                Iterable iterable4 = (Iterable)block.invoke((Object)item\3);
                boolean bl5 = false;
                Iterable iterable5 = iterable4;
                Collection collection4 = new ArrayList();
                boolean bl6 = false;
                for (Object t3 : $this$flatMapTo\6) {
                    String[] stringArray;
                    String string5 = (String)t3;
                    boolean bl7 = false;
                    Object object3 = string5;
                    if (object3 == null || (object3 = StringsKt.split$default((CharSequence)((CharSequence)object3), (String[])(stringArray = new String[]{" "}), (boolean)false, (int)0, (int)6, null)) == null) {
                        object3 = CollectionsKt.emptyList();
                    }
                    object2 = (Iterable)object3;
                    CollectionsKt.addAll((Collection)collection4, (Iterable)object2);
                }
                iterable4 = (List)collection4;
                boolean bl8 = false;
                $this$flatMapTo\6 = collection3;
                Iterable<String> iterable6 = new ArrayList();
                boolean bl9 = false;
                void $this$forEach\10 = $this$mapNotNullTo\9;
                boolean bl10 = false;
                object2 = $this$forEach\10.iterator();
                while (object2.hasNext()) {
                    String string6;
                    Object e;
                    Object e2 = e = object2.next();
                    boolean bl11 = false;
                    String string7 = (String)e2;
                    boolean bl12 = false;
                    string3 = string4 = string7;
                    boolean bl13 = false;
                    String string8 = !StringsKt.isBlank((CharSequence)string3) ? string4 : null;
                    if (string8 != null) {
                        String string9 = string8.toLowerCase(Locale.ROOT);
                        string6 = string9;
                        Intrinsics.checkNotNullExpressionValue((Object)string9, (String)"toLowerCase(...)");
                    } else {
                        string6 = null;
                    }
                    if (string6 == null) continue;
                    String string10 = string6;
                    boolean bl14 = false;
                    iterable6.add(string10);
                }
                collection3 = (List)iterable6;
                if (collection3.isEmpty()) {
                    boolean bl15 = false;
                    pair = TuplesKt.to((Object)5, (Object)item\3);
                } else {
                    Object t4;
                    void $this$minBy\20;
                    void $this$mapTo\17;
                    List list3 = (List)collection3;
                    Iterable iterable7 = list3;
                    boolean bl16 = false;
                    iterable6 = iterable7;
                    Collection collection5 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable7, (int)10));
                    boolean bl17 = false;
                    for (Object t5 : $this$mapTo\17) {
                        void t\18;
                        String e = (String)t5;
                        Collection collection6 = collection5;
                        boolean bl18 = false;
                        Iterable iterable8 = list2;
                        int n = 0;
                        Iterator iterator2 = iterable8.iterator();
                        while (iterator2.hasNext()) {
                            void it\19;
                            string3 = string4 = iterator2.next();
                            int n2 = n;
                            boolean bl19 = false;
                            int n3 = INSTANCE.wagnerFischer((String)t\18, (String)it\19);
                            int n4 = StringsKt.contains$default((CharSequence)((CharSequence)t\18), (CharSequence)((CharSequence)it\19), (boolean)false, (int)2, null) ? -t\18.length() : 0;
                            int n5 = n3 + n4;
                            n = n2 + n5;
                        }
                        int n6 = n / list2.size();
                        collection6.add(TuplesKt.to((Object)n6, (Object)t\18));
                    }
                    iterable7 = (List)collection5;
                    boolean bl20 = false;
                    Iterator iterator3 = $this$minBy\20.iterator();
                    if (!iterator3.hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Object t6 = iterator3.next();
                    if (!iterator3.hasNext()) {
                        t4 = t6;
                    } else {
                        Pair pair2 = (Pair)t6;
                        boolean bl21 = false;
                        int n = ((Number)pair2.getFirst()).intValue();
                        do {
                            Object t7 = iterator3.next();
                            Pair pair3 = (Pair)t7;
                            boolean bl22 = false;
                            int n7 = ((Number)pair3.getFirst()).intValue();
                            if (n <= n7) continue;
                            t6 = t7;
                            n = n7;
                        } while (iterator3.hasNext());
                        t4 = t6;
                    }
                    Pair pair4 = (Pair)t4;
                    pair = TuplesKt.to((Object)pair4.getFirst(), (Object)item\3);
                }
            }
            collection2.add(pair);
        }
        iterable2 = (List)collection;
        boolean bl23 = false;
        $this$mapTo\2 = iterable;
        Collection collection7 = new ArrayList();
        boolean bl24 = false;
        for (Object t : $this$filterTo\24) {
            Pair pair = (Pair)t;
            boolean bl25 = false;
            if (!(((Number)pair.getFirst()).intValue() <= 3)) continue;
            collection7.add(t);
        }
        iterable = (List)collection7;
        boolean bl26 = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy\26, (Comparator)new Comparator(){

            /*
             * WARNING - void declaration
             */
            public final int compare(T a, T b) {
                void it\2;
                Pair pair = (Pair)a;
                boolean bl = false;
                Comparable comparable = (Integer)pair.getFirst();
                pair = (Pair)b;
                Comparable comparable2 = comparable;
                boolean bl2 = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)((Integer)it\2.getFirst()));
            }
        });
    }

    private final int wagnerFischer(String s, String t) {
        int j;
        int m = s.length();
        int n = t.length();
        if (Intrinsics.areEqual((Object)s, (Object)t)) {
            return 0;
        }
        if (((CharSequence)s).length() == 0) {
            return n;
        }
        if (((CharSequence)t).length() == 0) {
            return m;
        }
        int n2 = 0;
        int n3 = m + 1;
        int[][] nArrayArray = new int[n3][];
        while (n2 < n3) {
            int n4 = n2++;
            nArrayArray[n4] = new int[n + 1];
        }
        int[][] d = nArrayArray;
        int i = 1;
        if (i <= m) {
            while (true) {
                d[i][0] = i;
                if (i == m) break;
                ++i;
            }
        }
        if ((j = 1) <= n) {
            while (true) {
                d[0][j] = j;
                if (j == n) break;
                ++j;
            }
        }
        if ((j = 1) <= n) {
            while (true) {
                int i2;
                if ((i2 = 1) <= m) {
                    while (true) {
                        int cost = s.charAt(i2 - 1) == t.charAt(j - 1) ? 0 : 1;
                        int delCost = d[i2 - 1][j] + 1;
                        int addCost = d[i2][j - 1] + 1;
                        int subCost = d[i2 - 1][j - 1] + cost;
                        d[i2][j] = Math.min(delCost, Math.min(addCost, subCost));
                        if (i2 == m) break;
                        ++i2;
                    }
                }
                if (j == n) break;
                ++j;
            }
        }
        return d[m][n];
    }

    /*
     * WARNING - void declaration
     */
    private final List<String> splitArtists(String $this$splitArtists, Set<String> exclusions) {
        String[] stringArray;
        List list2;
        List list3;
        if ($this$splitArtists != null && exclusions.contains(((Object)StringsKt.trim((CharSequence)$this$splitArtists)).toString())) {
            list3 = CollectionsKt.listOf((Object)((Object)StringsKt.trim((CharSequence)$this$splitArtists)).toString());
        } else if ($this$splitArtists != null && (list2 = StringsKt.split$default((CharSequence)$this$splitArtists, (String[])(stringArray = new String[]{",", "&", " and "}), (boolean)false, (int)0, (int)6, null)) != null) {
            void $this$mapNotNullTo\2;
            void $this$mapNotNull\1;
            Iterable iterable = list2;
            boolean bl = false;
            void var7_7 = $this$mapNotNull\1;
            Collection collection = new ArrayList();
            boolean bl2 = false;
            void $this$forEach\3 = $this$mapNotNullTo\2;
            boolean bl3 = false;
            Iterator iterator = $this$forEach\3.iterator();
            while (iterator.hasNext()) {
                String string2;
                String string3;
                Object t;
                Object t2 = t = iterator.next();
                boolean bl4 = false;
                String string4 = (String)t2;
                boolean bl5 = false;
                String string5 = string3 = ((Object)StringsKt.trim((CharSequence)string4)).toString();
                boolean bl6 = false;
                if ((!StringsKt.isBlank((CharSequence)string5) ? string3 : null) == null) continue;
                string2 = string2;
                boolean bl7 = false;
                collection.add(string2);
            }
            list3 = (List)collection;
        } else {
            list3 = CollectionsKt.listOf(null);
        }
        return list3;
    }

    static /* synthetic */ List splitArtists$default(MediaStoreUtils mediaStoreUtils, String string2, Set set, int n, Object object) {
        if ((n & 1) != 0) {
            set = SetsKt.emptySet();
        }
        return mediaStoreUtils.splitArtists(string2, set);
    }

    private final String fixWin1252(String $this$fixWin1252) {
        String string2;
        String string3 = $this$fixWin1252;
        if (string3 != null) {
            String string4 = string3;
            boolean bl = false;
            string2 = StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)string4, (String)"\u00e2\u20ac\u2122", (String)"\u2019", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\u201c", (String)"\u2013", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\u201d", (String)"\u2014", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\u0153", (String)"\u201c", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\ufffd", (String)"\u201d", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\u02dc", (String)"\u2018", (boolean)false, (int)4, null), (String)"\u00e2\u20ac\u00a6", (String)"\u2026", (boolean)false, (int)4, null);
        } else {
            string2 = null;
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     */
    private final List<Artist> toArtists(String $this$toArtists, Set<String> exclusions) {
        void $this$mapTo\3;
        String string2;
        String string3 = string2 = $this$toArtists;
        Object object = this;
        boolean $i$a$-takeIf-MediaStoreUtils$toArtists$1\1\736\12 = false;
        boolean bl = !Intrinsics.areEqual((Object)$this$toArtists, (Object)"null");
        Iterable iterable = ((MediaStoreUtils)object).splitArtists(bl ? string2 : null, exclusions);
        boolean bl2 = false;
        Iterable $i$a$-takeIf-MediaStoreUtils$toArtists$1\1\736\12 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        boolean bl3 = false;
        for (Object t : $this$mapTo\3) {
            void it\4;
            String string4 = (String)t;
            object = collection;
            boolean bl4 = false;
            void v0 = it\4;
            String string5 = String.valueOf(v0 != null ? Long.valueOf(INSTANCE.id((String)v0)) : null);
            String string6 = it\4;
            if (string6 == null) {
                string6 = "Unknown";
            }
            object.add(new Artist(string5, string6, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
        }
        return (List)collection;
    }

    static /* synthetic */ List toArtists$default(MediaStoreUtils mediaStoreUtils, String string2, Set set, int n, Object object) {
        if ((n & 1) != 0) {
            set = SetsKt.emptySet();
        }
        return mediaStoreUtils.toArtists(string2, set);
    }

    public final long id(@NotNull String $this$id) {
        Intrinsics.checkNotNullParameter((Object)$this$id, (String)"<this>");
        String string2 = $this$id.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
        return string2.hashCode();
    }

    private static final CharSequence selection$lambda$0(String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return " or mime_type = '" + it + "'";
    }

    public static final /* synthetic */ boolean access$hasScopedStorage(MediaStoreUtils $this) {
        return $this.hasScopedStorage();
    }

    public static final /* synthetic */ String[] access$getProjection$p() {
        return projection;
    }

    public static final /* synthetic */ String access$getSelection$p() {
        return selection;
    }

    public static final /* synthetic */ void access$parseSongQuery(MediaStoreUtils $this, Cursor $receiver, int limitValue, Set folderFilter, List blacklistKeywords, Context context, List songs, boolean foundPlaylistContent, Map idMap, Settings settings, Function1 block) {
        $this.parseSongQuery($receiver, limitValue, folderFilter, blacklistKeywords, context, songs, foundPlaylistContent, idMap, settings, (Function1<? super Track, Unit>)block);
    }

    public static final /* synthetic */ List access$albumMapToAlbumList(MediaStoreUtils $this, Map albumMap, HashMap coverCache) {
        return $this.albumMapToAlbumList(albumMap, coverCache);
    }

    public static final /* synthetic */ MPlaylist access$getLikedPlaylist(MediaStoreUtils $this, Context context, List playlistsFinal) {
        return $this.getLikedPlaylist(context, playlistsFinal);
    }

    public static final /* synthetic */ boolean access$playlistContent(MediaStoreUtils $this, Context context, List playlists) {
        return $this.playlistContent(context, playlists);
    }

    public static final /* synthetic */ void access$songAlbumMap(MediaStoreUtils $this, Track song, Integer year, Map albumMap, Map artistMap, boolean haveImgPerm) {
        $this.songAlbumMap(song, year, albumMap, artistMap, haveImgPerm);
    }

    public static final /* synthetic */ FileNode access$handleMediaFolder(MediaStoreUtils $this, String path, FileNode rootNode) {
        return $this.handleMediaFolder(path, rootNode);
    }

    public static final /* synthetic */ void access$handleShallowTrack(MediaStoreUtils $this, Track mediaItem2, Long albumId, String path, FileNode shallowFolder, List folderArray) {
        $this.handleShallowTrack(mediaItem2, albumId, path, shallowFolder, folderArray);
    }

    public static final /* synthetic */ Track access$dummyTrack(MediaStoreUtils $this, long id2, String title) {
        return $this.dummyTrack(id2, title);
    }

    static {
        Object object = new String[]{"audio/x-wav", "audio/ogg", "audio/aac", "audio/midi"};
        selection = "is_music != 0" + CollectionsKt.joinToString$default((Iterable)CollectionsKt.listOf((Object[])object), (CharSequence)"", null, null, (int)0, null, MediaStoreUtils::selection$lambda$0, (int)30, null);
        object = new String[]{"_id", "title", "artist", "artist_id", "album", "album_artist", "_data", "year", "album_id", "mime_type", "track", "duration", "date_added", "date_modified"};
        Object object2 = object = CollectionsKt.arrayListOf((Object[])object);
        boolean bl = false;
        if (INSTANCE.hasImprovedMediaStore()) {
            ((ArrayList)object2).add("genre");
            ((ArrayList)object2).add("genre_id");
            ((ArrayList)object2).add("cd_track_number");
            ((ArrayList)object2).add("compilation");
            ((ArrayList)object2).add("datetaken");
            ((ArrayList)object2).add("disc_number");
        }
        Collection collection = (Collection)object;
        boolean bl2 = false;
        Collection collection2 = collection;
        projection = collection2.toArray(new String[0]);
        String string2 = "content://media/external/audio/albumart";
        boolean bl3 = false;
        coverUri = Uri.parse((String)string2);
        object = new String[]{"jpg", "png", "jpeg", "bmp", "tiff", "tif", "webp"};
        allowedCoverExtensions = CollectionsKt.listOf((Object[])object);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u00c6\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003J`\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020\nH\u00d6\u0001J\t\u0010/\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!\u00a8\u00060"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$AlbumImpl;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "id", "", "title", "", "artists", "", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "albumYear", "", "cover", "Landroid/net/Uri;", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Landroid/net/Uri;Ljava/util/Set;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getArtists", "()Ljava/util/List;", "getAlbumYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCover", "()Landroid/net/Uri;", "setCover", "(Landroid/net/Uri;)V", "getSongList", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Landroid/net/Uri;Ljava/util/Set;)Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$AlbumImpl;", "equals", "", "other", "", "hashCode", "toString", "app_debug"})
    public static final class AlbumImpl
    implements MAlbum {
        @Nullable
        private final Long id;
        @Nullable
        private final String title;
        @NotNull
        private final List<MArtist> artists;
        @Nullable
        private final Integer albumYear;
        @Nullable
        private Uri cover;
        @NotNull
        private final Set<Track> songList;

        public AlbumImpl(@Nullable Long id2, @Nullable String title, @NotNull List<MArtist> artists, @Nullable Integer albumYear, @Nullable Uri cover, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(artists, (String)"artists");
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            this.id = id2;
            this.title = title;
            this.artists = artists;
            this.albumYear = albumYear;
            this.cover = cover;
            this.songList = songList;
        }

        @Override
        @Nullable
        public Long getId() {
            return this.id;
        }

        @Override
        @Nullable
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public List<MArtist> getArtists() {
            return this.artists;
        }

        @Override
        @Nullable
        public Integer getAlbumYear() {
            return this.albumYear;
        }

        @Override
        @Nullable
        public Uri getCover() {
            return this.cover;
        }

        public void setCover(@Nullable Uri uri) {
            this.cover = uri;
        }

        @Override
        @NotNull
        public Set<Track> getSongList() {
            return this.songList;
        }

        @Nullable
        public final Long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final List<MArtist> component3() {
            return this.artists;
        }

        @Nullable
        public final Integer component4() {
            return this.albumYear;
        }

        @Nullable
        public final Uri component5() {
            return this.cover;
        }

        @NotNull
        public final Set<Track> component6() {
            return this.songList;
        }

        @NotNull
        public final AlbumImpl copy(@Nullable Long id2, @Nullable String title, @NotNull List<MArtist> artists, @Nullable Integer albumYear, @Nullable Uri cover, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(artists, (String)"artists");
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            return new AlbumImpl(id2, title, artists, albumYear, cover, songList);
        }

        public static /* synthetic */ AlbumImpl copy$default(AlbumImpl albumImpl, Long l, String string2, List list2, Integer n, Uri uri, Set set, int n2, Object object) {
            if ((n2 & 1) != 0) {
                l = albumImpl.id;
            }
            if ((n2 & 2) != 0) {
                string2 = albumImpl.title;
            }
            if ((n2 & 4) != 0) {
                list2 = albumImpl.artists;
            }
            if ((n2 & 8) != 0) {
                n = albumImpl.albumYear;
            }
            if ((n2 & 0x10) != 0) {
                uri = albumImpl.cover;
            }
            if ((n2 & 0x20) != 0) {
                set = albumImpl.songList;
            }
            return albumImpl.copy(l, string2, list2, n, uri, set);
        }

        @NotNull
        public String toString() {
            return "AlbumImpl(id=" + this.id + ", title=" + this.title + ", artists=" + this.artists + ", albumYear=" + this.albumYear + ", cover=" + this.cover + ", songList=" + this.songList + ")";
        }

        public int hashCode() {
            int result2 = this.id == null ? 0 : ((Object)this.id).hashCode();
            result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
            result2 = result2 * 31 + ((Object)this.artists).hashCode();
            result2 = result2 * 31 + (this.albumYear == null ? 0 : ((Object)this.albumYear).hashCode());
            result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
            result2 = result2 * 31 + ((Object)this.songList).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlbumImpl)) {
                return false;
            }
            AlbumImpl albumImpl = (AlbumImpl)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)albumImpl.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)albumImpl.title)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.artists, albumImpl.artists)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.albumYear, (Object)albumImpl.albumYear)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.cover, (Object)albumImpl.cover)) {
                return false;
            }
            return Intrinsics.areEqual(this.songList, albumImpl.songList);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Date;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "id", "", "title", "", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "<init>", "(JLjava/lang/String;Ljava/util/Set;)V", "getId", "()Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getSongList", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Date
    implements Item {
        private final long id;
        @Nullable
        private final String title;
        @NotNull
        private final Set<Track> songList;

        public Date(long id2, @Nullable String title, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            this.id = id2;
            this.title = title;
            this.songList = songList;
        }

        @Override
        @NotNull
        public Long getId() {
            return this.id;
        }

        @Override
        @Nullable
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public Set<Track> getSongList() {
            return this.songList;
        }

        public final long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final Set<Track> component3() {
            return this.songList;
        }

        @NotNull
        public final Date copy(long id2, @Nullable String title, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            return new Date(id2, title, songList);
        }

        public static /* synthetic */ Date copy$default(Date date, long l, String string2, Set set, int n, Object object) {
            if ((n & 1) != 0) {
                l = date.id;
            }
            if ((n & 2) != 0) {
                string2 = date.title;
            }
            if ((n & 4) != 0) {
                set = date.songList;
            }
            return date.copy(l, string2, set);
        }

        @NotNull
        public String toString() {
            return "Date(id=" + this.id + ", title=" + this.title + ", songList=" + this.songList + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.id);
            result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
            result2 = result2 * 31 + ((Object)this.songList).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Date)) {
                return false;
            }
            Date date = (Date)other;
            if (this.id != date.id) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)date.title)) {
                return false;
            }
            return Intrinsics.areEqual(this.songList, date.songList);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\tj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0000`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;", "", "folderName", "", "<init>", "(Ljava/lang/String;)V", "getFolderName", "()Ljava/lang/String;", "folderList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getFolderList", "()Ljava/util/HashMap;", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "getSongList", "()Ljava/util/List;", "value", "", "albumId", "getAlbumId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "addSong", "", "item", "id", "(Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Long;)V", "app_debug"})
    public static final class FileNode {
        @NotNull
        private final String folderName;
        @NotNull
        private final HashMap<String, FileNode> folderList;
        @NotNull
        private final List<Track> songList;
        @Nullable
        private Long albumId;

        public FileNode(@NotNull String folderName) {
            Intrinsics.checkNotNullParameter((Object)folderName, (String)"folderName");
            this.folderName = folderName;
            this.folderList = new HashMap();
            this.songList = new ArrayList();
        }

        @NotNull
        public final String getFolderName() {
            return this.folderName;
        }

        @NotNull
        public final HashMap<String, FileNode> getFolderList() {
            return this.folderList;
        }

        @NotNull
        public final List<Track> getSongList() {
            return this.songList;
        }

        @Nullable
        public final Long getAlbumId() {
            return this.albumId;
        }

        public final void addSong(@NotNull Track item2, @Nullable Long id2) {
            Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
            if (this.albumId != null && !Intrinsics.areEqual((Object)id2, (Object)this.albumId)) {
                this.albumId = null;
            } else if (this.albumId == null && this.songList.isEmpty()) {
                this.albumId = id2;
            }
            this.songList.add(item2);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J6\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Genre;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "id", "", "title", "", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/Set;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getSongList", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/Set;)Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Genre;", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Genre
    implements Item {
        @Nullable
        private final Long id;
        @Nullable
        private final String title;
        @NotNull
        private final Set<Track> songList;

        public Genre(@Nullable Long id2, @Nullable String title, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            this.id = id2;
            this.title = title;
            this.songList = songList;
        }

        @Override
        @Nullable
        public Long getId() {
            return this.id;
        }

        @Override
        @Nullable
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public Set<Track> getSongList() {
            return this.songList;
        }

        @Nullable
        public final Long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final Set<Track> component3() {
            return this.songList;
        }

        @NotNull
        public final Genre copy(@Nullable Long id2, @Nullable String title, @NotNull Set<Track> songList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            return new Genre(id2, title, songList);
        }

        public static /* synthetic */ Genre copy$default(Genre genre, Long l, String string2, Set set, int n, Object object) {
            if ((n & 1) != 0) {
                l = genre.id;
            }
            if ((n & 2) != 0) {
                string2 = genre.title;
            }
            if ((n & 4) != 0) {
                set = genre.songList;
            }
            return genre.copy(l, string2, set);
        }

        @NotNull
        public String toString() {
            return "Genre(id=" + this.id + ", title=" + this.title + ", songList=" + this.songList + ")";
        }

        public int hashCode() {
            int result2 = this.id == null ? 0 : ((Object)this.id).hashCode();
            result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
            result2 = result2 * 31 + ((Object)this.songList).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Genre)) {
                return false;
            }
            Genre genre = (Genre)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)genre.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)genre.title)) {
                return false;
            }
            return Intrinsics.areEqual(this.songList, genre.songList);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "", "id", "", "getId", "()Ljava/lang/Long;", "title", "", "getTitle", "()Ljava/lang/String;", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "getSongList", "()Ljava/util/Set;", "app_debug"})
    public static interface Item {
        @Nullable
        public Long getId();

        @Nullable
        public String getTitle();

        @NotNull
        public Set<Track> getSongList();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001f\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(\u00a8\u0006)"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$LibraryStoreClass;", "", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "albumList", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "artistMap", "", "", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "genreList", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Genre;", "dateList", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Date;", "playlistList", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "likedPlaylist", "folderStructure", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;", "shallowFolder", "folders", "", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;Ljava/util/Set;)V", "getSongList", "()Ljava/util/List;", "getAlbumList", "getArtistMap", "()Ljava/util/Map;", "getGenreList", "getDateList", "getPlaylistList", "getLikedPlaylist", "()Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "getFolderStructure", "()Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$FileNode;", "getShallowFolder", "getFolders", "()Ljava/util/Set;", "app_debug"})
    public static final class LibraryStoreClass {
        @NotNull
        private final List<Track> songList;
        @NotNull
        private final List<MAlbum> albumList;
        @NotNull
        private final Map<Long, MArtist> artistMap;
        @NotNull
        private final List<Genre> genreList;
        @NotNull
        private final List<Date> dateList;
        @NotNull
        private final List<MPlaylist> playlistList;
        @Nullable
        private final MPlaylist likedPlaylist;
        @NotNull
        private final FileNode folderStructure;
        @NotNull
        private final FileNode shallowFolder;
        @NotNull
        private final Set<String> folders;

        public LibraryStoreClass(@NotNull List<Track> songList, @NotNull List<MAlbum> albumList, @NotNull Map<Long, MArtist> artistMap, @NotNull List<Genre> genreList, @NotNull List<Date> dateList, @NotNull List<MPlaylist> playlistList, @Nullable MPlaylist likedPlaylist, @NotNull FileNode folderStructure, @NotNull FileNode shallowFolder, @NotNull Set<String> folders) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            Intrinsics.checkNotNullParameter(albumList, (String)"albumList");
            Intrinsics.checkNotNullParameter(artistMap, (String)"artistMap");
            Intrinsics.checkNotNullParameter(genreList, (String)"genreList");
            Intrinsics.checkNotNullParameter(dateList, (String)"dateList");
            Intrinsics.checkNotNullParameter(playlistList, (String)"playlistList");
            Intrinsics.checkNotNullParameter((Object)folderStructure, (String)"folderStructure");
            Intrinsics.checkNotNullParameter((Object)shallowFolder, (String)"shallowFolder");
            Intrinsics.checkNotNullParameter(folders, (String)"folders");
            this.songList = songList;
            this.albumList = albumList;
            this.artistMap = artistMap;
            this.genreList = genreList;
            this.dateList = dateList;
            this.playlistList = playlistList;
            this.likedPlaylist = likedPlaylist;
            this.folderStructure = folderStructure;
            this.shallowFolder = shallowFolder;
            this.folders = folders;
        }

        @NotNull
        public final List<Track> getSongList() {
            return this.songList;
        }

        @NotNull
        public final List<MAlbum> getAlbumList() {
            return this.albumList;
        }

        @NotNull
        public final Map<Long, MArtist> getArtistMap() {
            return this.artistMap;
        }

        @NotNull
        public final List<Genre> getGenreList() {
            return this.genreList;
        }

        @NotNull
        public final List<Date> getDateList() {
            return this.dateList;
        }

        @NotNull
        public final List<MPlaylist> getPlaylistList() {
            return this.playlistList;
        }

        @Nullable
        public final MPlaylist getLikedPlaylist() {
            return this.likedPlaylist;
        }

        @NotNull
        public final FileNode getFolderStructure() {
            return this.folderStructure;
        }

        @NotNull
        public final FileNode getShallowFolder() {
            return this.shallowFolder;
        }

        @NotNull
        public final Set<String> getFolders() {
            return this.folders;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "id", "", "getId", "()Ljava/lang/Long;", "title", "", "getTitle", "()Ljava/lang/String;", "artists", "", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "getArtists", "()Ljava/util/List;", "albumYear", "", "getAlbumYear", "()Ljava/lang/Integer;", "cover", "Landroid/net/Uri;", "getCover", "()Landroid/net/Uri;", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "getSongList", "()Ljava/util/Set;", "app_debug"})
    public static interface MAlbum
    extends Item {
        @Override
        @Nullable
        public Long getId();

        @Override
        @Nullable
        public String getTitle();

        @NotNull
        public List<MArtist> getArtists();

        @Nullable
        public Integer getAlbumYear();

        @Nullable
        public Uri getCover();

        @Override
        @NotNull
        public Set<Track> getSongList();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003JF\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "id", "", "title", "", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "albumList", "", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getSongList", "()Ljava/util/Set;", "getAlbumList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;)Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class MArtist
    implements Item {
        @Nullable
        private final Long id;
        @Nullable
        private final String title;
        @NotNull
        private final Set<Track> songList;
        @NotNull
        private final List<MAlbum> albumList;

        public MArtist(@Nullable Long id2, @Nullable String title, @NotNull Set<Track> songList, @NotNull List<MAlbum> albumList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            Intrinsics.checkNotNullParameter(albumList, (String)"albumList");
            this.id = id2;
            this.title = title;
            this.songList = songList;
            this.albumList = albumList;
        }

        @Override
        @Nullable
        public Long getId() {
            return this.id;
        }

        @Override
        @Nullable
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public Set<Track> getSongList() {
            return this.songList;
        }

        @NotNull
        public final List<MAlbum> getAlbumList() {
            return this.albumList;
        }

        @Nullable
        public final Long component1() {
            return this.id;
        }

        @Nullable
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final Set<Track> component3() {
            return this.songList;
        }

        @NotNull
        public final List<MAlbum> component4() {
            return this.albumList;
        }

        @NotNull
        public final MArtist copy(@Nullable Long id2, @Nullable String title, @NotNull Set<Track> songList, @NotNull List<MAlbum> albumList) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            Intrinsics.checkNotNullParameter(albumList, (String)"albumList");
            return new MArtist(id2, title, songList, albumList);
        }

        public static /* synthetic */ MArtist copy$default(MArtist mArtist, Long l, String string2, Set set, List list2, int n, Object object) {
            if ((n & 1) != 0) {
                l = mArtist.id;
            }
            if ((n & 2) != 0) {
                string2 = mArtist.title;
            }
            if ((n & 4) != 0) {
                set = mArtist.songList;
            }
            if ((n & 8) != 0) {
                list2 = mArtist.albumList;
            }
            return mArtist.copy(l, string2, set, list2);
        }

        @NotNull
        public String toString() {
            return "MArtist(id=" + this.id + ", title=" + this.title + ", songList=" + this.songList + ", albumList=" + this.albumList + ")";
        }

        public int hashCode() {
            int result2 = this.id == null ? 0 : ((Object)this.id).hashCode();
            result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
            result2 = result2 * 31 + ((Object)this.songList).hashCode();
            result2 = result2 * 31 + ((Object)this.albumList).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MArtist)) {
                return false;
            }
            MArtist mArtist = (MArtist)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)mArtist.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)mArtist.title)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.songList, mArtist.songList)) {
                return false;
            }
            return Intrinsics.areEqual(this.albumList, mArtist.albumList);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$Item;", "id", "", "title", "", "songList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "description", "modifiedDate", "<init>", "(JLjava/lang/String;Ljava/util/Set;Ljava/lang/String;J)V", "getId", "()Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getSongList", "()Ljava/util/Set;", "getDescription", "getModifiedDate", "()J", "app_debug"})
    public static class MPlaylist
    implements Item {
        private final long id;
        @Nullable
        private final String title;
        @NotNull
        private final Set<Track> songList;
        @Nullable
        private final String description;
        private final long modifiedDate;

        public MPlaylist(long id2, @Nullable String title, @NotNull Set<Track> songList, @Nullable String description, long modifiedDate) {
            Intrinsics.checkNotNullParameter(songList, (String)"songList");
            this.id = id2;
            this.title = title;
            this.songList = songList;
            this.description = description;
            this.modifiedDate = modifiedDate;
        }

        @Override
        @NotNull
        public Long getId() {
            return this.id;
        }

        @Override
        @Nullable
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public Set<Track> getSongList() {
            return this.songList;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        public final long getModifiedDate() {
            return this.modifiedDate;
        }
    }
}

