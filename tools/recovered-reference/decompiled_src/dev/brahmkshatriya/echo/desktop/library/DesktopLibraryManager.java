/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.library;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManagerKt;
import dev.brahmkshatriya.echo.desktop.library.LibraryData;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack;
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u000fJ\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020#2\b\b\u0002\u0010(\u001a\u00020#J\u000e\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020#J\u0016\u0010+\u001a\u00020!2\u0006\u0010*\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fJ\u0016\u0010,\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020#2\u0006\u0010\"\u001a\u00020#J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020\u001eJ\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013\u00a8\u00060"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/DesktopLibraryManager;", "", "platform", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AppPlatform;Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Lkotlinx/coroutines/CoroutineScope;)V", "json", "Lkotlinx/serialization/json/Json;", "_favorites", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "favorites", "Lkotlinx/coroutines/flow/StateFlow;", "getFavorites", "()Lkotlinx/coroutines/flow/StateFlow;", "_playlists", "Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist;", "playlists", "getPlaylists", "_history", "history", "getHistory", "getLibraryFile", "Ljava/io/File;", "loadData", "", "saveData", "isFavorite", "", "trackId", "", "toggleFavorite", "track", "createPlaylist", "title", "description", "deletePlaylist", "playlistId", "addTrackToPlaylist", "removeTrackFromPlaylist", "recordHistory", "clearHistory", "getRecommendedTracks", "desktopApp"})
@StabilityInferred(parameters=0)
@SourceDebugExtension(value={"SMAP\nDesktopLibraryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopLibraryManager.kt\ndev/brahmkshatriya/echo/desktop/library/DesktopLibraryManager\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,360:1\n222#2:361\n1563#3:362\n1634#3,3:363\n1563#3:366\n1634#3,3:367\n1761#3,3:370\n360#3,7:373\n360#3,7:381\n1761#3,3:388\n360#3,7:391\n827#3:398\n855#3,2:399\n1#4:380\n*S KotlinDebug\n*F\n+ 1 DesktopLibraryManager.kt\ndev/brahmkshatriya/echo/desktop/library/DesktopLibraryManager\n*L\n116#1:361\n117#1:362\n117#1:363,3\n119#1:366\n119#1:367,3\n145#1:370,3\n150#1:373,7\n193#1:381,7\n196#1:388,3\n210#1:391,7\n213#1:398\n213#1:399,2\n*E\n"})
public final class DesktopLibraryManager {
    @NotNull
    private final AppPlatform platform;
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Json json;
    @NotNull
    private final MutableStateFlow<List<Track>> _favorites;
    @NotNull
    private final StateFlow<List<Track>> favorites;
    @NotNull
    private final MutableStateFlow<List<UserPlaylist>> _playlists;
    @NotNull
    private final StateFlow<List<UserPlaylist>> playlists;
    @NotNull
    private final MutableStateFlow<List<Track>> _history;
    @NotNull
    private final StateFlow<List<Track>> history;
    public static final int $stable = 8;

    public DesktopLibraryManager(@NotNull AppPlatform platform, @NotNull ExtensionManager extensionManager, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.platform = platform;
        this.extensionManager = extensionManager;
        this.scope = scope;
        this.json = JsonKt.Json$default(null, DesktopLibraryManager::json$lambda$0, (int)1, null);
        this._favorites = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.favorites = FlowKt.asStateFlow(this._favorites);
        this._playlists = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.playlists = FlowKt.asStateFlow(this._playlists);
        this._history = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.history = FlowKt.asStateFlow(this._history);
        this.loadData();
    }

    public /* synthetic */ DesktopLibraryManager(AppPlatform appPlatform, ExtensionManager extensionManager, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(appPlatform, extensionManager, coroutineScope);
    }

    @NotNull
    public final StateFlow<List<Track>> getFavorites() {
        return this.favorites;
    }

    @NotNull
    public final StateFlow<List<UserPlaylist>> getPlaylists() {
        return this.playlists;
    }

    @NotNull
    public final StateFlow<List<Track>> getHistory() {
        return this.history;
    }

    private final File getLibraryFile() {
        File dir = FilesKt.resolve((File)this.platform.getDataDir().toFile(), (String)"library");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return FilesKt.resolve((File)dir, (String)"library_data.json");
    }

    private final void loadData() {
        try {
            File file2 = this.getLibraryFile();
            if (file2.exists() && file2.length() > 0L) {
                StoredTrack it;
                Collection collection;
                Iterable $this$mapTo$iv$iv;
                Iterable $this$map$iv;
                Iterable this_$iv;
                String text = FilesKt.readText$default((File)file2, null, (int)1, null);
                Json json = this.json;
                String string$iv = text;
                boolean $i$f$decodeFromString22 = false;
                this_$iv.getSerializersModule();
                LibraryData data2 = (LibraryData)this_$iv.decodeFromString((DeserializationStrategy)LibraryData.Companion.serializer(), string$iv);
                this_$iv = data2.getFavorites();
                MutableStateFlow<List<Track>> mutableStateFlow = this._favorites;
                boolean $i$f$map = false;
                void $i$f$decodeFromString22 = $this$map$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    StoredTrack storedTrack = (StoredTrack)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl = false;
                    collection.add(DesktopLibraryManagerKt.toTrack(it));
                }
                mutableStateFlow.setValue((Object)((List)destination$iv$iv));
                this._playlists.setValue(data2.getPlaylists());
                $this$map$iv = data2.getHistory();
                mutableStateFlow = this._history;
                $i$f$map = false;
                $this$mapTo$iv$iv = $this$map$iv;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                $i$f$mapTo = false;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    it = (StoredTrack)item$iv$iv;
                    collection = destination$iv$iv;
                    boolean bl = false;
                    collection.add(DesktopLibraryManagerKt.toTrack(it));
                }
                mutableStateFlow.setValue((Object)((List)destination$iv$iv));
                System.out.println((Object)("[DesktopLibraryManager] Loaded " + ((List)this._favorites.getValue()).size() + " favorites, " + ((List)this._playlists.getValue()).size() + " playlists, " + ((List)this._history.getValue()).size() + " history."));
            }
        }
        catch (Throwable e) {
            System.err.println("[DesktopLibraryManager] Error loading library: " + e.getMessage());
        }
    }

    private final void saveData() {
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ DesktopLibraryManager this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        try {
                            void this_$iv;
                            Collection<StoredTrack> collection;
                            Track it;
                            Collection collection2;
                            Iterable $this$mapTo$iv$iv;
                            File file2 = DesktopLibraryManager.access$getLibraryFile(this.this$0);
                            Iterable $this$map$iv = (Iterable)DesktopLibraryManager.access$get_favorites$p(this.this$0).getValue();
                            boolean $i$f$map = false;
                            Iterable iterable = $this$map$iv;
                            Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                            boolean $i$f$mapTo = false;
                            for (T item$iv$iv : $this$mapTo$iv$iv) {
                                Track track2 = (Track)item$iv$iv;
                                collection2 = destination$iv$iv;
                                boolean bl = false;
                                collection2.add(DesktopLibraryManagerKt.toStoredTrack(it));
                            }
                            $this$map$iv = (Iterable)DesktopLibraryManager.access$get_history$p(this.this$0).getValue();
                            List list2 = (List)DesktopLibraryManager.access$get_playlists$p(this.this$0).getValue();
                            collection2 = (List)destination$iv$iv;
                            $i$f$map = false;
                            $this$mapTo$iv$iv = $this$map$iv;
                            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                            $i$f$mapTo = false;
                            for (T item$iv$iv : $this$mapTo$iv$iv) {
                                it = (Track)item$iv$iv;
                                collection = destination$iv$iv;
                                boolean bl = false;
                                collection.add(DesktopLibraryManagerKt.toStoredTrack(it));
                            }
                            collection = (List)destination$iv$iv;
                            List list3 = collection;
                            List list4 = list2;
                            Collection collection3 = collection2;
                            LibraryData data2 = new LibraryData((List<StoredTrack>)collection3, list4, list3);
                            $this$map$iv = DesktopLibraryManager.access$getJson$p(this.this$0);
                            LibraryData value$iv = data2;
                            boolean $i$f$encodeToString = false;
                            this_$iv.getSerializersModule();
                            FilesKt.writeText$default((File)file2, (String)this_$iv.encodeToString((SerializationStrategy)LibraryData.Companion.serializer(), (Object)value$iv), null, (int)2, null);
                        }
                        catch (Throwable e) {
                            System.err.println("[DesktopLibraryManager] Error saving library: " + e.getMessage());
                        }
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)3, null);
    }

    public final boolean isFavorite(@NotNull String trackId) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
            Iterable $this$any$iv = (Iterable)this._favorites.getValue();
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Track it = (Track)element$iv;
                    boolean bl2 = false;
                    if (!Intrinsics.areEqual((Object)it.getId(), (Object)trackId)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    public final boolean toggleFavorite(@NotNull Track track2) {
        int n;
        List current;
        block4: {
            Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
            List $this$indexOfFirst$iv = current = CollectionsKt.toMutableList((Collection)((Collection)this._favorites.getValue()));
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                Track it = (Track)item$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)it.getId(), (Object)track2.getId())) {
                    n = index$iv;
                    break block4;
                }
                ++index$iv;
            }
            n = -1;
        }
        int existingIndex = n;
        boolean isFav = false;
        if (existingIndex >= 0) {
            current.remove(existingIndex);
            isFav = false;
            System.out.println((Object)("[DesktopLibraryManager] Removed from favorites: " + track2.getTitle()));
        } else {
            current.add(0, track2);
            isFav = true;
            System.out.println((Object)("[DesktopLibraryManager] Added to favorites: " + track2.getTitle()));
        }
        this._favorites.setValue((Object)current);
        this.saveData();
        return isFav;
    }

    @NotNull
    public final UserPlaylist createPlaylist(@NotNull String title, @NotNull String description) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        String string2 = UUID.randomUUID().toString();
        String string3 = string2;
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        CharSequence charSequence2 = title;
        if (StringsKt.isBlank((CharSequence)charSequence2)) {
            String string4 = string3;
            boolean bl = false;
            charSequence = "My Playlist";
            string3 = string4;
        } else {
            charSequence = charSequence2;
        }
        List list2 = CollectionsKt.emptyList();
        long l = System.currentTimeMillis();
        String string5 = description;
        String string6 = (String)charSequence;
        String string7 = string3;
        UserPlaylist newPlaylist = new UserPlaylist(string7, string6, string5, l, list2);
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._playlists.getValue()));
        current.add(0, newPlaylist);
        this._playlists.setValue((Object)current);
        this.saveData();
        System.out.println((Object)("[DesktopLibraryManager] Created playlist: " + newPlaylist.getTitle() + " (" + newPlaylist.getId() + ")"));
        return newPlaylist;
    }

    public static /* synthetic */ UserPlaylist createPlaylist$default(DesktopLibraryManager desktopLibraryManager, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = "";
        }
        return desktopLibraryManager.createPlaylist(string2, string3);
    }

    public final void deletePlaylist(@NotNull String playlistId) {
        Intrinsics.checkNotNullParameter((Object)playlistId, (String)"playlistId");
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._playlists.getValue()));
        CollectionsKt.removeAll((List)current, arg_0 -> DesktopLibraryManager.deletePlaylist$lambda$6(playlistId, arg_0));
        this._playlists.setValue((Object)current);
        this.saveData();
        System.out.println((Object)("[DesktopLibraryManager] Deleted playlist: " + playlistId));
    }

    public final boolean addTrackToPlaylist(@NotNull String playlistId, @NotNull Track track2) {
        int index;
        Object it;
        List current;
        block7: {
            int n;
            Intrinsics.checkNotNullParameter((Object)playlistId, (String)"playlistId");
            Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
            List $this$indexOfFirst$iv = current = CollectionsKt.toMutableList((Collection)((Collection)this._playlists.getValue()));
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                it = (UserPlaylist)item$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)((UserPlaylist)it).getId(), (Object)playlistId)) {
                    n = index$iv;
                    break block7;
                }
                ++index$iv;
            }
            n = index = -1;
        }
        if (index >= 0) {
            boolean bl;
            UserPlaylist pl;
            block8: {
                pl = (UserPlaylist)current.get(index);
                Iterable $this$any$iv = pl.getTracks();
                boolean $i$f$any = false;
                if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                    bl = false;
                } else {
                    for (Object element$iv : $this$any$iv) {
                        it = (StoredTrack)element$iv;
                        boolean bl2 = false;
                        if (!Intrinsics.areEqual((Object)((StoredTrack)it).getId(), (Object)track2.getId())) continue;
                        bl = true;
                        break block8;
                    }
                    bl = false;
                }
            }
            if (!bl) {
                List updatedTracks = CollectionsKt.plus((Collection)pl.getTracks(), (Object)DesktopLibraryManagerKt.toStoredTrack(track2));
                current.set(index, UserPlaylist.copy$default(pl, null, null, null, 0L, updatedTracks, 15, null));
                this._playlists.setValue((Object)current);
                this.saveData();
                System.out.println((Object)("[DesktopLibraryManager] Added '" + track2.getTitle() + "' to playlist '" + pl.getTitle() + "'"));
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public final void removeTrackFromPlaylist(@NotNull String playlistId, @NotNull String trackId) {
        int index;
        List current;
        block4: {
            int n;
            Intrinsics.checkNotNullParameter((Object)playlistId, (String)"playlistId");
            Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
            List $this$indexOfFirst$iv = current = CollectionsKt.toMutableList((Collection)((Collection)this._playlists.getValue()));
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                UserPlaylist it = (UserPlaylist)item$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)it.getId(), (Object)playlistId)) {
                    n = index$iv;
                    break block4;
                }
                ++index$iv;
            }
            n = index = -1;
        }
        if (index >= 0) {
            void $this$filterNotTo$iv$iv;
            Object item$iv;
            UserPlaylist pl = (UserPlaylist)current.get(index);
            Iterable $this$filterNot$iv = pl.getTracks();
            boolean $i$f$filterNot = false;
            item$iv = $this$filterNot$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterNotTo = false;
            for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
                StoredTrack it = (StoredTrack)element$iv$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)it.getId(), (Object)trackId)) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List updatedTracks = (List)destination$iv$iv;
            current.set(index, UserPlaylist.copy$default(pl, null, null, null, 0L, updatedTracks, 15, null));
            this._playlists.setValue((Object)current);
            this.saveData();
            System.out.println((Object)("[DesktopLibraryManager] Removed track '" + trackId + "' from playlist '" + pl.getTitle() + "'"));
        }
    }

    public final void recordHistory(@NotNull Track track2) {
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._history.getValue()));
        CollectionsKt.removeAll((List)current, arg_0 -> DesktopLibraryManager.recordHistory$lambda$11(track2, arg_0));
        current.add(0, track2);
        if (current.size() > 200) {
            this._history.setValue((Object)CollectionsKt.take((Iterable)current, (int)200));
        } else {
            this._history.setValue((Object)current);
        }
        this.saveData();
    }

    public final void clearHistory() {
        this._history.setValue((Object)CollectionsKt.emptyList());
        this.saveData();
    }

    @NotNull
    public final List<Track> getRecommendedTracks() {
        List result2 = new ArrayList();
        Set seenIds = new LinkedHashSet();
        for (Track track2 : (List)this._favorites.getValue()) {
            if (!seenIds.add(track2.getId())) continue;
            result2.add(track2);
        }
        for (Track track2 : (List)this._history.getValue()) {
            if (!seenIds.add(track2.getId())) continue;
            result2.add(track2);
        }
        Track[] trackArray = new Track[8];
        Object object = new Artist[]{new Artist("Arijit Singh", "Arijit Singh", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Pritam", "Pritam", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        List list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Brahmastra", "Brahm\u0101stra", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        ImageHolder.NetworkRequestImageHolder networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/264/Kesariya-From-Brahmastra-Hindi-2022-20220717092820-500x500.jpg", null, null, null, 14, null), false);
        trackArray[0] = new Track("Kesariya", "Kesariya", null, networkRequestImageHolder, list2, (Album)object, 268000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Arijit Singh", "Arijit Singh", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Sachin-Jigar", "Sachin-Jigar", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Bhediya", "Bhediya", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/815/Bhediya-Hindi-2022-20230206141320-500x500.jpg", null, null, null, 14, null), false);
        trackArray[1] = new Track("ApnaBanaLe", "Apna Bana Le", null, networkRequestImageHolder, list2, (Album)object, 261000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Jasleen Royal", "Jasleen Royal", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Arijit Singh", "Arijit Singh", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Heeriye", "Heeriye", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/022/Heeriye-feat-Arijit-Singh-Hindi-2023-20230928050405-500x500.jpg", null, null, null, 14, null), false);
        trackArray[2] = new Track("Heeriye", "Heeriye (feat. Arijit Singh)", null, networkRequestImageHolder, list2, (Album)object, 194000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Arijit Singh", "Arijit Singh", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Pritam", "Pritam", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Ae Dil Hai Mushkil", "Ae Dil Hai Mushkil", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/257/Ae-Dil-Hai-Mushkil-Deluxe-Edition-Hindi-2016-500x500.jpg", null, null, null, 14, null), false);
        trackArray[3] = new Track("ChannaMereya", "Channa Mereya", null, networkRequestImageHolder, list2, (Album)object, 289000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Arijit Singh", "Arijit Singh", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Mithoon", "Mithoon", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Aashiqui 2", "Aashiqui 2", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/152/Aashiqui-2-Hindi-2013-500x500.jpg", null, null, null, 14, null), false);
        trackArray[4] = new Track("TumHiHo", "Tum Hi Ho", null, networkRequestImageHolder, list2, (Album)object, 262000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Jubin Nautiyal", "Jubin Nautiyal", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Asees Kaur", "Asees Kaur", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Shershaah", "Shershaah", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/238/Shershaah-Original-Motion-Picture-Soundtrack--Hindi-2021-20210815181610-500x500.jpg", null, null, null, 14, null), false);
        trackArray[5] = new Track("RaataanLambiyan", "Raataan Lambiyan", null, networkRequestImageHolder, list2, (Album)object, 230000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("Ali Sethi", "Ali Sethi", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Shae Gill", "Shae Gill", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Coke Studio Season 14", "Coke Studio Season 14", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/131/Pasoori-Punjabi-2022-20220207103233-500x500.jpg", null, null, null, 14, null), false);
        trackArray[6] = new Track("Pasoori", "Pasoori", null, networkRequestImageHolder, list2, (Album)object, 224000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        object = new Artist[]{new Artist("The Weeknd", "The Weeknd", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null), new Artist("Daft Punk", "Daft Punk", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)};
        list2 = CollectionsKt.listOf((Object[])object);
        object = new Album("Starboy", "Starboy", null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest("https://c.saavncdn.com/978/Starboy-English-2016-500x500.jpg", null, null, null, 14, null), false);
        trackArray[7] = new Track("Starboy", "Starboy", null, networkRequestImageHolder, list2, (Album)object, 230000L, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFF84, null);
        List curatedFallback = CollectionsKt.listOf((Object[])trackArray);
        for (Track fallback : curatedFallback) {
            if (!seenIds.add(fallback.getId())) continue;
            result2.add(fallback);
        }
        return result2;
    }

    private static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    private static final boolean deletePlaylist$lambda$6(String $playlistId, UserPlaylist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Intrinsics.areEqual((Object)it.getId(), (Object)$playlistId);
    }

    private static final boolean recordHistory$lambda$11(Track $track, Track it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Intrinsics.areEqual((Object)it.getId(), (Object)$track.getId());
    }

    public static final /* synthetic */ File access$getLibraryFile(DesktopLibraryManager $this) {
        return $this.getLibraryFile();
    }

    public static final /* synthetic */ MutableStateFlow access$get_favorites$p(DesktopLibraryManager $this) {
        return $this._favorites;
    }

    public static final /* synthetic */ MutableStateFlow access$get_playlists$p(DesktopLibraryManager $this) {
        return $this._playlists;
    }

    public static final /* synthetic */ MutableStateFlow access$get_history$p(DesktopLibraryManager $this) {
        return $this._history;
    }

    public static final /* synthetic */ Json access$getJson$p(DesktopLibraryManager $this) {
        return $this.json;
    }
}

