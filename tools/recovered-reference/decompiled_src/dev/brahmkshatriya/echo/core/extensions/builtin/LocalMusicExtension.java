/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions.builtin;

import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001+B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011H\u0002J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010(J\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u0017H\u0096@\u00a2\u0006\u0002\u0010*R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/clients/HomeFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "Ldev/brahmkshatriya/echo/common/clients/SearchFeedClient;", "platform", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "echoSettings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AppPlatform;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;)V", "currentSettings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "setSettings", "", "settings", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMusicDirectories", "Ljava/io/File;", "scanLocalTracks", "Ldev/brahmkshatriya/echo/common/models/Track;", "loadHomeFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "loadSearchFeed", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTrack", "track", "isDownload", "", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core"})
@SourceDebugExtension(value={"SMAP\nLocalMusicExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalMusicExtension.kt\ndev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,164:1\n774#2:165\n865#2,2:166\n1563#2:168\n1634#2,3:169\n774#2:172\n865#2,2:173\n1669#2,8:177\n1563#2:185\n1634#2,3:186\n774#2:189\n865#2,2:190\n1321#3,2:175\n*S KotlinDebug\n*F\n+ 1 LocalMusicExtension.kt\ndev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension\n*L\n68#1:165\n68#1:166,2\n69#1:168\n69#1:169,3\n72#1:172\n72#1:173,2\n85#1:177,8\n85#1:185\n85#1:186,3\n130#1:189\n130#1:190,2\n78#1:175,2\n*E\n"})
public final class LocalMusicExtension
implements ExtensionClient,
HomeFeedClient,
TrackClient,
SearchFeedClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AppPlatform platform;
    @Nullable
    private final EchoSettings echoSettings;
    @Nullable
    private Settings currentSettings;
    @NotNull
    public static final String ID = "desktop_local_music";
    @NotNull
    private static final Metadata METADATA;
    @NotNull
    private static final Set<String> AUDIO_EXTENSIONS;

    public LocalMusicExtension(@NotNull AppPlatform platform, @Nullable EchoSettings echoSettings) {
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        this.platform = platform;
        this.echoSettings = echoSettings;
    }

    public /* synthetic */ LocalMusicExtension(AppPlatform appPlatform, EchoSettings echoSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            echoSettings = null;
        }
        this(appPlatform, echoSettings);
    }

    @Override
    public void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.currentSettings = settings;
    }

    @Override
    @Nullable
    public Object getSettingItems(@NotNull Continuation<? super List<? extends Setting>> $completion) {
        return CollectionsKt.emptyList();
    }

    /*
     * WARNING - void declaration
     */
    private final List<File> getMusicDirectories() {
        void $this$filterTo$iv$iv;
        List list2;
        List list3;
        char[] cArray;
        Iterable iterable;
        String string2;
        String string3 = System.getProperty("user.home");
        if (string3 == null) {
            string3 = "";
        }
        String userHome = string3;
        Object[] objectArray = new File[]{new File(userHome, "Music"), this.platform.getDownloadsDir().toFile()};
        List dirs = CollectionsKt.mutableListOf((Object[])objectArray);
        EchoSettings echoSettings = this.echoSettings;
        if (echoSettings != null && (string2 = echoSettings.getString("custom_music_folders", null)) != null && (iterable = StringsKt.split$default((CharSequence)string2, (char[])(cArray = new char[]{';'}), (boolean)false, (int)0, (int)6, null)) != null) {
            void $this$mapTo$iv$iv;
            void $this$map$iv;
            String it;
            void $this$filterTo$iv$iv2;
            Iterable $this$filter$iv;
            Iterable iterable2 = iterable;
            boolean $i$f$filter = false;
            void var10_13 = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv2) {
                it = (String)element$iv$iv;
                boolean bl = false;
                boolean bl2 = !StringsKt.isBlank((CharSequence)it);
                if (!bl2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            $this$filter$iv = (List)destination$iv$iv;
            boolean $i$f$map = false;
            $this$filterTo$iv$iv2 = $this$map$iv;
            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                it = (String)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(new File(((Object)StringsKt.trim((CharSequence)it)).toString()));
            }
            list3 = (List)destination$iv$iv;
        } else {
            list3 = list2 = null;
        }
        if (list3 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List customFolders = list2;
        dirs.addAll(customFolders);
        Iterable $this$filter$iv = dirs;
        boolean $i$f$filter = false;
        iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            File it = (File)element$iv$iv;
            boolean bl = false;
            if (!(it.exists() && it.isDirectory())) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final List<Track> scanLocalTracks() {
        void $this$mapTo$iv$iv;
        List files = new ArrayList();
        for (File dir : this.getMusicDirectories()) {
            Sequence $this$forEach$iv = (Sequence)FilesKt.walkTopDown((File)dir).maxDepth(3);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                File file2 = (File)element$iv;
                boolean bl = false;
                if (!file2.isFile()) continue;
                String string2 = FilesKt.getExtension((File)file2).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
                if (!AUDIO_EXTENSIONS.contains(string2)) continue;
                files.add(file2);
            }
        }
        Iterable $this$distinctBy$iv = files;
        boolean $i$f$distinctBy = false;
        Iterable<String> set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            File it = (File)e$iv;
            boolean bl = false;
            String key$iv = it.getAbsolutePath();
            if (!((HashSet)set$iv).add(key$iv)) continue;
            list$iv.add(e$iv);
        }
        Iterable $this$map$iv = list$iv;
        boolean $i$f$map = false;
        set$iv = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void file3;
            File bl = (File)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl2 = false;
            String title = FilesKt.getNameWithoutExtension((File)file3);
            String string3 = file3.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getAbsolutePath(...)");
            List list2 = CollectionsKt.listOf((Object)new Artist("local_artist", "Local Audio", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
            String string4 = file3.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getAbsolutePath(...)");
            collection.add(new Track(string3, title, null, null, list2, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, CollectionsKt.listOf((Object)new Streamable(string4, 100, Streamable.MediaType.Server, "Local File", null, 16, null)), false, false, false, false, false, false, 266338284, null));
        }
        return (List)destination$iv$iv;
    }

    @Override
    @Nullable
    public Object loadHomeFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        List<Track> tracks = this.scanLocalTracks();
        List shelves = !((Collection)tracks).isEmpty() ? CollectionsKt.listOf((Object)new Shelf.Lists.Tracks("local_tracks_shelf", "Local Music (" + tracks.size() + " tracks)", tracks, null, Shelf.Lists.Type.Linear, null, null, 104, null)) : CollectionsKt.listOf((Object)new Shelf.Lists.Tracks("no_local_tracks", "No songs found in Music folder (" + System.getProperty("user.home") + "\\Music)", CollectionsKt.emptyList(), null, Shelf.Lists.Type.Linear, null, null, 104, null));
        return Feed.Companion.toFeed$default(Feed.Companion, shelves, null, null, 3, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object loadSearchFeed(@NotNull String query, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        List list2;
        List all2 = this.scanLocalTracks();
        if (StringsKt.isBlank((CharSequence)query)) {
            list2 = all2;
        } else {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = all2;
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Track it = (Track)element$iv$iv;
                boolean bl = false;
                if (!StringsKt.contains((CharSequence)it.getTitle(), (CharSequence)query, (boolean)true)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            list2 = (List)destination$iv$iv;
        }
        List filtered = list2;
        return Feed.Companion.toFeed$default(Feed.Companion, CollectionsKt.listOf((Object)new Shelf.Lists.Tracks("search_results", (String)(StringsKt.isBlank((CharSequence)query) ? "All Local Songs" : "Results for \"" + query + "\""), filtered, null, Shelf.Lists.Type.Linear, null, null, 104, null)), null, null, 3, null);
    }

    @Override
    @Nullable
    public Object loadTrack(@NotNull Track track2, boolean isDownload, @NotNull Continuation<? super Track> $completion) {
        return track2;
    }

    @Override
    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable streamable, boolean isDownload, @NotNull Continuation<? super Streamable.Media> $completion) {
        File file2 = new File(streamable.getId());
        String string2 = file2.toURI().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        String uri = string2;
        Streamable.Source.Http source = new Streamable.Source.Http(NetworkRequest.Companion.toGetRequest$default(NetworkRequest.Companion, uri, null, 1, null), null, null, 100, "Local File", false, false, 102, null);
        return new Streamable.Media.Server(CollectionsKt.listOf((Object)source), false);
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Track track2, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    @Override
    @Nullable
    public Object onExtensionSelected(@NotNull Continuation<? super Unit> $completion) {
        return ExtensionClient.super.onExtensionSelected($completion);
    }

    @Override
    @Nullable
    public Object onInitialize(@NotNull Continuation<? super Unit> $completion) {
        return ExtensionClient.super.onInitialize($completion);
    }

    static {
        String string2 = Reflection.getOrCreateKotlinClass(LocalMusicExtension.class).getQualifiedName();
        if (string2 == null) {
            string2 = "LocalMusicExtension";
        }
        METADATA = new Metadata(string2, "builtin:local", ImportType.File, ExtensionType.MUSIC, ID, "Local Music", "1.0.0", "Play songs directly from your Windows Music library and custom folders", "Echo Desktop", null, null, null, null, null, true, 15872, null);
        Object[] objectArray = new String[]{"mp3", "flac", "wav", "m4a", "ogg", "opus", "aac", "mp4", "wma", "webm"};
        AUDIO_EXTENSIONS = SetsKt.setOf((Object[])objectArray);
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension$Companion;", "", "<init>", "()V", "ID", "", "METADATA", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMETADATA", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "AUDIO_EXTENSIONS", "", "core"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Metadata getMETADATA() {
            return METADATA;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

