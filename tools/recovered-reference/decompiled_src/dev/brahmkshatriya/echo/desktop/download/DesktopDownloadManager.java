/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
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
 *  okhttp3.Call
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.download;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import dev.brahmkshatriya.echo.desktop.download.DownloadTask;
import dev.brahmkshatriya.echo.desktop.download.DownloadedTrack;
import dev.brahmkshatriya.echo.desktop.download.OfflineTrackMetadata;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.awt.Desktop;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
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
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!J\u0006\u0010%\u001a\u00020#J\u000e\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020(J\u0014\u0010)\u001a\u00020#2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020(0\u0012J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001eJ\u0006\u0010-\u001a\u00020#J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0019J\u000e\u00100\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0019J\u000e\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020!J\u0006\u00103\u001a\u00020#J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00120\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/DesktopDownloadManager;", "", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "settings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "platform", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;Ldev/brahmkshatriya/echo/core/platform/AppPlatform;Lkotlinx/coroutines/CoroutineScope;)V", "json", "Lkotlinx/serialization/json/Json;", "httpClient", "Lokhttp3/OkHttpClient;", "_activeDownloads", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Ldev/brahmkshatriya/echo/desktop/download/DownloadTask;", "activeDownloads", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveDownloads", "()Lkotlinx/coroutines/flow/StateFlow;", "_completedDownloads", "Ldev/brahmkshatriya/echo/desktop/download/DownloadedTrack;", "completedDownloads", "getCompletedDownloads", "jobs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/Job;", "getDownloadDir", "Ljava/io/File;", "setDownloadDir", "", "dir", "refreshCompleted", "downloadTrack", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "downloadAlbum", "tracks", "cancel", "trackId", "clearCompleted", "deleteDownloaded", "item", "playOffline", "openInExplorer", "file", "openDownloadsFolder", "updateTask", "task", "sanitizeFileName", "name", "desktopApp"})
@StabilityInferred(parameters=0)
@SourceDebugExtension(value={"SMAP\nDesktopDownloadManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopDownloadManager.kt\ndev/brahmkshatriya/echo/desktop/download/DesktopDownloadManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,382:1\n1#2:383\n1869#3,2:384\n774#3:386\n865#3,2:387\n360#3,7:389\n*S KotlinDebug\n*F\n+ 1 DesktopDownloadManager.kt\ndev/brahmkshatriya/echo/desktop/download/DesktopDownloadManager\n*L\n312#1:384,2\n325#1:386\n325#1:387,2\n373#1:389,7\n*E\n"})
public final class DesktopDownloadManager {
    @NotNull
    private final PlayerViewModel playerViewModel;
    @NotNull
    private final EchoSettings settings;
    @NotNull
    private final AppPlatform platform;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final Json json;
    @NotNull
    private final OkHttpClient httpClient;
    @NotNull
    private final MutableStateFlow<List<DownloadTask>> _activeDownloads;
    @NotNull
    private final StateFlow<List<DownloadTask>> activeDownloads;
    @NotNull
    private final MutableStateFlow<List<DownloadedTrack>> _completedDownloads;
    @NotNull
    private final StateFlow<List<DownloadedTrack>> completedDownloads;
    @NotNull
    private final ConcurrentHashMap<String, Job> jobs;
    public static final int $stable = 8;

    public DesktopDownloadManager(@NotNull PlayerViewModel playerViewModel, @NotNull EchoSettings settings, @NotNull AppPlatform platform, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)playerViewModel, (String)"playerViewModel");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.playerViewModel = playerViewModel;
        this.settings = settings;
        this.platform = platform;
        this.scope = scope;
        this.json = JsonKt.Json$default(null, DesktopDownloadManager::json$lambda$0, (int)1, null);
        this.httpClient = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS).followRedirects(true).build();
        this._activeDownloads = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.activeDownloads = FlowKt.asStateFlow(this._activeDownloads);
        this._completedDownloads = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.completedDownloads = FlowKt.asStateFlow(this._completedDownloads);
        this.jobs = new ConcurrentHashMap();
        this.refreshCompleted();
    }

    public /* synthetic */ DesktopDownloadManager(PlayerViewModel playerViewModel, EchoSettings echoSettings, AppPlatform appPlatform, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(playerViewModel, echoSettings, appPlatform, coroutineScope);
    }

    @NotNull
    public final StateFlow<List<DownloadTask>> getActiveDownloads() {
        return this.activeDownloads;
    }

    @NotNull
    public final StateFlow<List<DownloadedTrack>> getCompletedDownloads() {
        return this.completedDownloads;
    }

    @NotNull
    public final File getDownloadDir() {
        File dir;
        String customPath = this.settings.getString("download_dir", null);
        CharSequence charSequence = customPath;
        File file2 = dir = !(charSequence == null || StringsKt.isBlank((CharSequence)charSequence)) ? new File(customPath) : this.platform.getDownloadsDir().toFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }

    public final void setDownloadDir(@NotNull File dir) {
        Intrinsics.checkNotNullParameter((Object)dir, (String)"dir");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        this.settings.putString("download_dir", dir.getAbsolutePath());
        this.refreshCompleted();
    }

    public final void refreshCompleted() {
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ DesktopDownloadManager this$0;
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
                        List list2 = new ArrayList<E>();
                        File dir = this.this$0.getDownloadDir();
                        File[] fileArray = dir.listFiles();
                        if (fileArray == null) {
                            fileArray = new File[]{};
                        }
                        for (File file2 : fileArray) {
                            Track track2;
                            File metaFile;
                            if (!file2.isFile()) continue;
                            String string2 = file2.getName();
                            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getName(...)");
                            if (!StringsKt.endsWith$default((String)string2, (String)".mp3", (boolean)false, (int)2, null)) {
                                String string3 = file2.getName();
                                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getName(...)");
                                if (!StringsKt.endsWith$default((String)string3, (String)".m4a", (boolean)false, (int)2, null)) {
                                    String string4 = file2.getName();
                                    Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getName(...)");
                                    if (!StringsKt.endsWith$default((String)string4, (String)".opus", (boolean)false, (int)2, null)) {
                                        String string5 = file2.getName();
                                        Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"getName(...)");
                                        if (!StringsKt.endsWith$default((String)string5, (String)".webm", (boolean)false, (int)2, null)) {
                                            String string6 = file2.getName();
                                            Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"getName(...)");
                                            if (!StringsKt.endsWith$default((String)string6, (String)".flac", (boolean)false, (int)2, null)) continue;
                                        }
                                    }
                                }
                            }
                            if ((metaFile = new File(file2.getAbsolutePath() + ".echo.json")).exists()) {
                                try {
                                    ImageHolder.NetworkRequestImageHolder networkRequestImageHolder;
                                    Album album;
                                    void $this$mapTo$iv$iv;
                                    void this_$iv;
                                    Json json = DesktopDownloadManager.access$getJson$p(this.this$0);
                                    String string$iv = FilesKt.readText$default((File)metaFile, null, (int)1, null);
                                    boolean $i$f$decodeFromString22 = false;
                                    this_$iv.getSerializersModule();
                                    OfflineTrackMetadata meta22 = (OfflineTrackMetadata)this_$iv.decodeFromString((DeserializationStrategy)OfflineTrackMetadata.Companion.serializer(), string$iv);
                                    string$iv = meta22.getId();
                                    String $i$f$decodeFromString22 = meta22.getTitle();
                                    Iterable $this$map$iv = meta22.getArtists();
                                    boolean $i$f$map = false;
                                    Object object = $this$map$iv;
                                    Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                                    boolean $i$f$mapTo = false;
                                    for (T item$iv$iv : $this$mapTo$iv$iv) {
                                        void it;
                                        String string7 = (String)item$iv$iv;
                                        Collection collection = destination$iv$iv;
                                        boolean bl = false;
                                        collection.add(new Artist((String)it, (String)it, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
                                    }
                                    List list3 = (List)destination$iv$iv;
                                    if (meta22.getAlbum() != null) {
                                        String it;
                                        boolean bl = false;
                                        v6 = new Album(it, it, null, null, null, null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048572, null);
                                    } else {
                                        v6 = album = null;
                                    }
                                    if (meta22.getCoverUrl() != null) {
                                        String it;
                                        boolean bl = false;
                                        networkRequestImageHolder = new ImageHolder.NetworkRequestImageHolder(new NetworkRequest(it, null, null, null, 14, null), false);
                                    } else {
                                        networkRequestImageHolder = null;
                                    }
                                    ImageHolder.NetworkRequestImageHolder networkRequestImageHolder2 = networkRequestImageHolder;
                                    object = meta22.getDurationMs();
                                    Map map2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)"local_file", (Object)file2.getAbsolutePath()));
                                    track2 = new Track(string$iv, $i$f$decodeFromString22, null, networkRequestImageHolder2, list3, album, (Long)object, null, null, null, null, null, null, null, null, null, null, false, null, map2, null, null, false, false, false, false, false, false, 267911044, null);
                                    String string8 = meta22.getId();
                                    Intrinsics.checkNotNull((Object)file2);
                                    boolean meta22 = list2.add(new DownloadedTrack(string8, track2, file2, file2.length(), meta22.getFormat(), meta22.getDownloadTime()));
                                }
                                catch (Throwable e) {
                                    Intrinsics.checkNotNull((Object)file2);
                                    String nameWithoutExt = FilesKt.getNameWithoutExtension((File)file2);
                                    String string9 = file2.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue((Object)string9, (String)"getAbsolutePath(...)");
                                    Track track3 = new Track(string9, nameWithoutExt, null, null, CollectionsKt.listOf((Object)new Artist("Local Artist", "Local Artist", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)), null, null, null, null, null, null, null, null, null, null, null, null, false, null, MapsKt.mapOf((Pair)TuplesKt.to((Object)"local_file", (Object)file2.getAbsolutePath())), null, null, false, false, false, false, false, false, 267911148, null);
                                    String string10 = file2.getAbsolutePath();
                                    Intrinsics.checkNotNullExpressionValue((Object)string10, (String)"getAbsolutePath(...)");
                                    long l = file2.length();
                                    String string11 = FilesKt.getExtension((File)file2).toUpperCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue((Object)string11, (String)"toUpperCase(...)");
                                    boolean meta22 = list2.add(new DownloadedTrack(string10, track3, file2, l, string11, file2.lastModified()));
                                }
                                continue;
                            }
                            Intrinsics.checkNotNull((Object)file2);
                            String nameWithoutExt = FilesKt.getNameWithoutExtension((File)file2);
                            String string12 = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue((Object)string12, (String)"getAbsolutePath(...)");
                            track2 = new Track(string12, nameWithoutExt, null, null, CollectionsKt.listOf((Object)new Artist("Offline Track", "Offline Track", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)), null, null, null, null, null, null, null, null, null, null, null, null, false, null, MapsKt.mapOf((Pair)TuplesKt.to((Object)"local_file", (Object)file2.getAbsolutePath())), null, null, false, false, false, false, false, false, 267911148, null);
                            String string13 = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue((Object)string13, (String)"getAbsolutePath(...)");
                            long l = file2.length();
                            String string14 = FilesKt.getExtension((File)file2).toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue((Object)string14, (String)"toUpperCase(...)");
                            list2.add(new DownloadedTrack(string13, track2, file2, l, string14, file2.lastModified()));
                        }
                        Iterable $this$sortedByDescending$iv = list2;
                        boolean $i$f$sortedByDescending = false;
                        DesktopDownloadManager.access$get_completedDownloads$p(this.this$0).setValue((Object)CollectionsKt.sortedWith((Iterable)$this$sortedByDescending$iv, (Comparator)new Comparator(){

                            public final int compare(T a, T b) {
                                DownloadedTrack it = (DownloadedTrack)b;
                                boolean bl = false;
                                Comparable comparable = Long.valueOf(it.getDateAdded());
                                it = (DownloadedTrack)a;
                                Comparable comparable2 = comparable;
                                bl = false;
                                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Long.valueOf(it.getDateAdded()));
                            }
                        }));
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

    public final void downloadTrack(@NotNull Track track2) {
        Object v0;
        block2: {
            Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
            Iterable iterable = (Iterable)this._activeDownloads.getValue();
            for (Object t : iterable) {
                DownloadTask it = (DownloadTask)t;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getId(), (Object)track2.getId())) continue;
                v0 = t;
                break block2;
            }
            v0 = null;
        }
        DownloadTask existing = v0;
        if (existing != null && (existing.getStatus() == DownloadTask.Status.DOWNLOADING || existing.getStatus() == DownloadTask.Status.CONNECTING)) {
            return;
        }
        DownloadTask task = new DownloadTask(track2.getId(), track2, DownloadTask.Status.QUEUED, 0.0f, 0L, 0L, null, 64, null);
        this.updateTask(task);
        Job job2 = BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, track2, task, null){
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
            Object L$11;
            Object L$12;
            Object L$13;
            Object L$14;
            Object L$15;
            long J$0;
            int label;
            final /* synthetic */ DesktopDownloadManager this$0;
            final /* synthetic */ Track $track;
            final /* synthetic */ DownloadTask $task;
            {
                this.this$0 = $receiver;
                this.$track = $track;
                this.$task = $task;
                super(2, $completion);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var45_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        dir = this.this$0.getDownloadDir();
                        tempFile = new File(dir, DesktopDownloadManager.access$sanitizeFileName(this.this$0, this.$track.getTitle()) + "_" + this.$track.getId().hashCode() + ".part");
                        DesktopDownloadManager.access$updateTask(this.this$0, DownloadTask.copy$default(this.$task, null, null, DownloadTask.Status.CONNECTING, 0.0f, 0L, 0L, null, 123, null));
                        System.out.println((Object)("[DesktopDownloadManager] Resolving stream for download: " + this.$track.getTitle()));
                        this.L$0 = dir;
                        this.L$1 = tempFile;
                        this.label = 1;
                        v0 = DesktopDownloadManager.access$getPlayerViewModel$p(this.this$0).resolveTrackStream(this.$track, (Continuation)this);
                        ** if (v0 != var45_2) goto lbl17
lbl16:
                        // 1 sources

                        return var45_2;
lbl17:
                        // 1 sources

                        ** GOTO lbl25
                    }
                    case 1: {
                        tempFile = (File)this.L$1;
                        dir = (File)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl25:
                        // 2 sources

                        v1 = (Pair)v0;
                        if (v1 == null) {
                            throw new Exception("Could not resolve audio stream for track: " + this.$track.getTitle());
                        }
                        streamResult = v1;
                        media = (Streamable.Media.Server)streamResult.component2();
                        downloadQuality = DesktopDownloadManager.access$getSettings$p(this.this$0).getString("download_quality", "high");
                        var9_11 = downloadQuality;
                        if (Intrinsics.areEqual((Object)var9_11, (Object)"medium")) {
                            $this$minByOrNull$iv = media.getSources();
                            $i$f$minByOrNull = false;
                            iterator$iv = $this$minByOrNull$iv.iterator();
                            if (!iterator$iv.hasNext()) {
                                v2 = null;
                            } else {
                                minElem$iv = iterator$iv.next();
                                if (!iterator$iv.hasNext()) {
                                    v2 = minElem$iv;
                                } else {
                                    it = (Streamable.Source)minElem$iv;
                                    $i$a$-minByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$1 = false;
                                    minValue$iv = Math.abs(it.getQuality() - 192);
                                    do {
                                        e$iv = iterator$iv.next();
                                        it = (Streamable.Source)e$iv;
                                        $i$a$-minByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$1 = false;
                                        v$iv = Math.abs(it.getQuality() - 192);
                                        if (minValue$iv <= v$iv) continue;
                                        minElem$iv = e$iv;
                                        minValue$iv = v$iv;
                                    } while (iterator$iv.hasNext());
                                    v2 = minElem$iv;
                                }
                            }
                            v3 = v2;
                        } else if (Intrinsics.areEqual((Object)var9_11, (Object)"low")) {
                            $this$minByOrNull$iv = media.getSources();
                            $i$f$minByOrNull = false;
                            iterator$iv = $this$minByOrNull$iv.iterator();
                            if (!iterator$iv.hasNext()) {
                                v4 = null;
                            } else {
                                minElem$iv = iterator$iv.next();
                                if (!iterator$iv.hasNext()) {
                                    v4 = minElem$iv;
                                } else {
                                    it = (Streamable.Source)minElem$iv;
                                    $i$a$-minByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$2 = false;
                                    minValue$iv = it.getQuality();
                                    do {
                                        e$iv = iterator$iv.next();
                                        it = (Streamable.Source)e$iv;
                                        $i$a$-minByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$2 = false;
                                        v$iv = it.getQuality();
                                        if (minValue$iv <= v$iv) continue;
                                        minElem$iv = e$iv;
                                        minValue$iv = v$iv;
                                    } while (iterator$iv.hasNext());
                                    v4 = minElem$iv;
                                }
                            }
                            v3 = v4;
                        } else {
                            $this$maxByOrNull$iv = media.getSources();
                            $i$f$maxByOrNull = false;
                            iterator$iv = $this$maxByOrNull$iv.iterator();
                            if (!iterator$iv.hasNext()) {
                                v5 = null;
                            } else {
                                maxElem$iv = iterator$iv.next();
                                if (!iterator$iv.hasNext()) {
                                    v5 = maxElem$iv;
                                } else {
                                    it = (Streamable.Source)maxElem$iv;
                                    $i$a$-maxByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$3 = false;
                                    maxValue$iv = it.getQuality();
                                    do {
                                        e$iv = iterator$iv.next();
                                        it = (Streamable.Source)e$iv;
                                        $i$a$-maxByOrNull-DesktopDownloadManager$downloadTrack$job$1$source$3 = false;
                                        v$iv = it.getQuality();
                                        if (maxValue$iv >= v$iv) continue;
                                        maxElem$iv = e$iv;
                                        maxValue$iv = v$iv;
                                    } while (iterator$iv.hasNext());
                                    v5 = maxElem$iv;
                                }
                            }
                            v3 = v6 = (Streamable.Source)v5;
                        }
                        if (v3 == null && (v6 = (Streamable.Source)CollectionsKt.firstOrNull(media.getSources())) == null) {
                            throw new Exception("No media source available for download");
                        }
                        source = v6;
                        if (!(source instanceof Streamable.Source.Http)) {
                            throw new Exception("Unsupported non-HTTP stream source for download");
                        }
                        url = ((Streamable.Source.Http)source).getRequest().getUrl();
                        DesktopDownloadManager.access$updateTask(this.this$0, DownloadTask.copy$default(this.$task, null, null, DownloadTask.Status.DOWNLOADING, 0.0f, 0L, 0L, null, 123, null));
                        requestBuilder = new Request.Builder().url(url);
                        v7 = ((Streamable.Source.Http)source).getRequest().getHeaders().get("User-Agent");
                        if (v7 == null) {
                            v7 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36";
                        }
                        ua = v7;
                        requestBuilder.header("User-Agent", ua);
                        v8 = ((Streamable.Source.Http)source).getRequest().getHeaders().get("Referer");
                        if (v8 != null) {
                            it = v8;
                            $i$a$-let-DesktopDownloadManager$downloadTrack$job$1$1 = false;
                            v9 = requestBuilder.header("Referer", it);
                        } else {
                            v9 = null;
                        }
                        v10 = ((Streamable.Source.Http)source).getRequest().getHeaders().get("Origin");
                        if (v10 != null) {
                            it = v10;
                            $i$a$-let-DesktopDownloadManager$downloadTrack$job$1$2 = false;
                            v11 = requestBuilder.header("Origin", it);
                        } else {
                            v11 = null;
                        }
                        call = DesktopDownloadManager.access$getHttpClient$p(this.this$0).newCall(requestBuilder.build());
                        this.L$0 = dir;
                        this.L$1 = tempFile;
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)streamResult);
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)media);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)downloadQuality);
                        this.L$5 = source;
                        this.L$6 = url;
                        this.L$7 = SpillingKt.nullOutSpilledVariable((Object)requestBuilder);
                        this.L$8 = SpillingKt.nullOutSpilledVariable((Object)ua);
                        this.L$9 = SpillingKt.nullOutSpilledVariable((Object)call);
                        this.label = 2;
                        v12 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Response>, Object>(call, null){
                            int label;
                            final /* synthetic */ Call $call;
                            {
                                this.$call = $call;
                                super(2, $completion);
                            }

                            public final Object invokeSuspend(Object $result) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        return this.$call.execute();
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(CoroutineScope p1, Continuation<? super Response> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }), (Continuation)((Continuation)this));
                        ** if (v12 != var45_2) goto lbl153
lbl152:
                        // 1 sources

                        return var45_2;
lbl153:
                        // 1 sources

                        ** GOTO lbl169
                    }
                    case 2: {
                        call = (Call)this.L$9;
                        ua = (String)this.L$8;
                        requestBuilder = (Request.Builder)this.L$7;
                        url = (String)this.L$6;
                        source = (Streamable.Source)this.L$5;
                        downloadQuality = (String)this.L$4;
                        media = (Streamable.Media.Server)this.L$3;
                        streamResult = (Pair)this.L$2;
                        tempFile = (File)this.L$1;
                        dir = (File)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v12 = $result;
lbl169:
                        // 2 sources

                        if (!(response = (Response)v12).isSuccessful()) {
                            throw new Exception("HTTP download error: code " + response.code());
                        }
                        v13 = response.body();
                        if (v13 == null) {
                            throw new Exception("Empty response body from stream");
                        }
                        body = v13;
                        totalLength = body.contentLength();
                        v14 = ((Streamable.Source.Http)source).getTitle();
                        v15 = v14 != null ? StringsKt.contains((CharSequence)v14, (CharSequence)"mp4", (boolean)true) : false;
                        if (!v15 && !StringsKt.contains$default((CharSequence)url, (CharSequence)".m4a", (boolean)false, (int)2, null)) ** GOTO lbl182
                        v16 = "m4a";
                        ** GOTO lbl191
lbl182:
                        // 1 sources

                        v17 = ((Streamable.Source.Http)source).getTitle();
                        if (v17 != null ? StringsKt.contains((CharSequence)v17, (CharSequence)"webm", (boolean)true) : false) ** GOTO lbl-1000
                        v18 = ((Streamable.Source.Http)source).getTitle();
                        v19 = v18 != null ? StringsKt.contains((CharSequence)v18, (CharSequence)"opus", (boolean)true) : false;
                        if (v19) lbl-1000:
                        // 2 sources

                        {
                            v16 = "opus";
                        } else {
                            v20 = ((Streamable.Source.Http)source).getTitle();
                            v16 = (v20 != null ? StringsKt.contains((CharSequence)v20, (CharSequence)"flac", (boolean)true) : false) != false ? "flac" : "mp3";
                        }
lbl191:
                        // 3 sources

                        ext = v16;
                        artistPrefix = ((Collection)this.$track.getArtists()).isEmpty() == false != false ? CollectionsKt.joinToString$default((Iterable)this.$track.getArtists(), (CharSequence)", ", null, null, (int)0, null, (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$5(dev.brahmkshatriya.echo.common.models.Artist ), (Ldev/brahmkshatriya/echo/common/models/Artist;)Ljava/lang/CharSequence;)(), (int)30, null) + " - " : "";
                        cleanFileName = DesktopDownloadManager.access$sanitizeFileName(this.this$0, artistPrefix + this.$track.getTitle()) + "." + ext;
                        finalFile = new File(dir, (String)cleanFileName);
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)dir);
                        this.L$1 = tempFile;
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)streamResult);
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)media);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)downloadQuality);
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)source);
                        this.L$6 = SpillingKt.nullOutSpilledVariable((Object)url);
                        this.L$7 = SpillingKt.nullOutSpilledVariable((Object)requestBuilder);
                        this.L$8 = SpillingKt.nullOutSpilledVariable((Object)ua);
                        this.L$9 = SpillingKt.nullOutSpilledVariable((Object)call);
                        this.L$10 = SpillingKt.nullOutSpilledVariable((Object)response);
                        this.L$11 = SpillingKt.nullOutSpilledVariable((Object)body);
                        this.L$12 = ext;
                        this.L$13 = SpillingKt.nullOutSpilledVariable((Object)artistPrefix);
                        this.L$14 = SpillingKt.nullOutSpilledVariable((Object)cleanFileName);
                        this.L$15 = finalFile;
                        this.J$0 = totalLength;
                        this.label = 3;
                        v21 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(body, tempFile, totalLength, this.this$0, this.$task, null){
                            int label;
                            final /* synthetic */ ResponseBody $body;
                            final /* synthetic */ File $tempFile;
                            final /* synthetic */ long $totalLength;
                            final /* synthetic */ DesktopDownloadManager this$0;
                            final /* synthetic */ DownloadTask $task;
                            {
                                this.$body = $body;
                                this.$tempFile = $tempFile;
                                this.$totalLength = $totalLength;
                                this.this$0 = $receiver;
                                this.$task = $task;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - Removed try catching itself - possible behaviour change.
                             */
                            public final Object invokeSuspend(Object $result) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        Closeable closeable = this.$body.byteStream();
                                        File file2 = this.$tempFile;
                                        long l = this.$totalLength;
                                        DesktopDownloadManager desktopDownloadManager = this.this$0;
                                        DownloadTask downloadTask = this.$task;
                                        Throwable throwable = null;
                                        try {
                                            InputStream input = (InputStream)closeable;
                                            boolean bl = false;
                                            Closeable closeable2 = new FileOutputStream(file2);
                                            Throwable throwable2 = null;
                                            try {
                                                FileOutputStream output = (FileOutputStream)closeable2;
                                                boolean bl2 = false;
                                                byte[] buffer = new byte[32768];
                                                int bytesRead = 0;
                                                long totalRead = 0L;
                                                while (true) {
                                                    int n;
                                                    int it = n = input.read(buffer);
                                                    boolean bl3 = false;
                                                    bytesRead = it;
                                                    if (n == -1) break;
                                                    output.write(buffer, 0, bytesRead);
                                                    float progress = l > 0L ? RangesKt.coerceIn((float)((float)(totalRead += (long)bytesRead) / (float)l), (float)0.0f, (float)1.0f) : 0.0f;
                                                    DesktopDownloadManager.access$updateTask(desktopDownloadManager, DownloadTask.copy$default(downloadTask, null, null, DownloadTask.Status.DOWNLOADING, progress, totalRead, l, null, 67, null));
                                                }
                                                output.flush();
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            catch (Throwable throwable3) {
                                                throwable2 = throwable3;
                                                throw throwable3;
                                            }
                                            finally {
                                                CloseableKt.closeFinally((Closeable)closeable2, (Throwable)throwable2);
                                            }
                                            Unit unit = Unit.INSTANCE;
                                        }
                                        catch (Throwable throwable4) {
                                            throwable = throwable4;
                                            throw throwable4;
                                        }
                                        finally {
                                            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
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
                        }), (Continuation)((Continuation)this));
                        ** if (v21 != var45_2) goto lbl216
lbl215:
                        // 1 sources

                        return var45_2;
lbl216:
                        // 1 sources

                        ** GOTO lbl239
                    }
                    case 3: {
                        totalLength = this.J$0;
                        finalFile = (File)this.L$15;
                        cleanFileName = (String)this.L$14;
                        artistPrefix = (String)this.L$13;
                        ext = (String)this.L$12;
                        body = (ResponseBody)this.L$11;
                        response = (Response)this.L$10;
                        call = (Call)this.L$9;
                        ua = (String)this.L$8;
                        requestBuilder = (Request.Builder)this.L$7;
                        url = (String)this.L$6;
                        source = (Streamable.Source)this.L$5;
                        downloadQuality = (String)this.L$4;
                        media = (Streamable.Media.Server)this.L$3;
                        streamResult = (Pair)this.L$2;
                        tempFile = (File)this.L$1;
                        dir = (File)this.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v21 = $result;
lbl239:
                            // 2 sources

                            if (finalFile.exists()) {
                                finalFile.delete();
                            }
                            tempFile.renameTo(finalFile);
                            v22 = this.$track.getCover();
                            if (v22 == null) {
                                v23 = this.$track.getAlbum();
                                v22 = v23 != null ? v23.getCover() : null;
                            }
                            coverUrl = (c = v22) instanceof ImageHolder.NetworkRequestImageHolder != false ? ((ImageHolder.NetworkRequestImageHolder)c).getRequest().getUrl() : (c instanceof ImageHolder.ResourceUriImageHolder != false ? ((ImageHolder.ResourceUriImageHolder)c).getUri() : null);
                            var22_39 = this.$track.getArtists();
                            var32_40 = this.$track.getTitle();
                            var31_41 = this.$track.getId();
                            $i$f$map = false;
                            var24_44 = $this$map$iv;
                            destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                            $i$f$mapTo = false;
                            for (T item$iv$iv : $this$mapTo$iv$iv) {
                                var29_50 = (Artist)item$iv$iv;
                                var33_52 = destination$iv$iv;
                                $i$a$-map-DesktopDownloadManager$downloadTrack$job$1$meta$1 = false;
                                var33_52.add(it.getName());
                            }
                            var33_52 = (List)destination$iv$iv;
                            v24 = this.$track.getAlbum();
                            v25 = v24 != null ? v24.getTitle() : null;
                            v26 = this.$track.getDuration();
                            v27 = ext.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue((Object)v27, (String)"toUpperCase(...)");
                            var34_53 = null;
                            var35_54 = 128;
                            var36_55 = 0L;
                            var38_56 = v27;
                            var39_57 = v26;
                            var40_58 = coverUrl;
                            var41_59 = v25;
                            var42_60 = var33_52;
                            var43_61 = var32_40;
                            var44_62 = var31_41;
                            meta = new OfflineTrackMetadata(var44_62, var43_61, var42_60, var41_59, var40_58, var39_57, var38_56, var36_55, var35_54, var34_53);
                            metaFile = new File(finalFile.getAbsolutePath() + ".echo.json");
                            $i$f$map = DesktopDownloadManager.access$getJson$p(this.this$0);
                            value$iv = meta;
                            $i$f$encodeToString = false;
                            this_$iv.getSerializersModule();
                            FilesKt.writeText$default((File)metaFile, (String)this_$iv.encodeToString((SerializationStrategy)OfflineTrackMetadata.Companion.serializer(), (Object)value$iv), null, (int)2, null);
                            System.out.println((Object)("[DesktopDownloadManager] Successfully downloaded: " + finalFile.getAbsolutePath()));
                            DesktopDownloadManager.access$updateTask(this.this$0, DownloadTask.copy$default(this.$task, null, null, DownloadTask.Status.COMPLETED, 1.0f, 0L, 0L, null, 115, null));
                            this.this$0.refreshCompleted();
                        }
                        catch (CancellationException e) {
                            tempFile.delete();
                            DesktopDownloadManager.access$updateTask(this.this$0, DownloadTask.copy$default(this.$task, null, null, DownloadTask.Status.CANCELLED, 0.0f, 0L, 0L, null, 123, null));
                        }
                        catch (Throwable e) {
                            tempFile.delete();
                            System.err.println("[DesktopDownloadManager] Download failed for " + this.$track.getTitle() + ": " + e.getMessage());
                            v28 = e.getMessage();
                            if (v28 == null) {
                                v28 = "Download failed";
                            }
                            DesktopDownloadManager.access$updateTask(this.this$0, DownloadTask.copy$default(this.$task, null, null, DownloadTask.Status.FAILED, 0.0f, 0L, 0L, v28, 59, null));
                            DesktopDownloadManager.access$getJobs$p(this.this$0).remove(this.$track.getId());
                            {
                                catch (Throwable var4_8) {
                                    throw var4_8;
                                }
                            }
                        }
                        DesktopDownloadManager.access$getJobs$p(this.this$0).remove(this.$track.getId());
                        ** GOTO lbl317
                    }
                    {
                        finally {
                            DesktopDownloadManager.access$getJobs$p(this.this$0).remove(this.$track.getId());
                        }
                    }
lbl317:
                    // 3 sources

                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }

            private static final CharSequence invokeSuspend$lambda$5(Artist it) {
                return it.getName();
            }
        }), (int)3, null);
        ((Map)this.jobs).put(track2.getId(), job2);
    }

    public final void downloadAlbum(@NotNull List<Track> tracks) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        Iterable $this$forEach$iv = tracks;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Track it = (Track)element$iv;
            boolean bl = false;
            this.downloadTrack(it);
        }
    }

    public final void cancel(@NotNull String trackId) {
        Object v1;
        block3: {
            Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
            Job job2 = this.jobs.get(trackId);
            if (job2 != null) {
                Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
            }
            this.jobs.remove(trackId);
            Iterable iterable = (Iterable)this._activeDownloads.getValue();
            for (Object t : iterable) {
                DownloadTask it = (DownloadTask)t;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getId(), (Object)trackId)) continue;
                v1 = t;
                break block3;
            }
            v1 = null;
        }
        DownloadTask current = v1;
        if (current != null) {
            this.updateTask(DownloadTask.copy$default(current, null, null, DownloadTask.Status.CANCELLED, 0.0f, 0L, 0L, null, 123, null));
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void clearCompleted() {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Iterable iterable = (Iterable)this._activeDownloads.getValue();
        MutableStateFlow<List<DownloadTask>> mutableStateFlow = this._activeDownloads;
        boolean $i$f$filter = false;
        void var3_4 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            DownloadTask it = (DownloadTask)element$iv$iv;
            boolean bl = false;
            if (!(it.getStatus() != DownloadTask.Status.COMPLETED && it.getStatus() != DownloadTask.Status.CANCELLED)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        mutableStateFlow.setValue((Object)((List)destination$iv$iv));
    }

    public final void deleteDownloaded(@NotNull DownloadedTrack item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(item2, this, null){
            int label;
            final /* synthetic */ DownloadedTrack $item;
            final /* synthetic */ DesktopDownloadManager this$0;
            {
                this.$item = $item;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        File meta;
                        ResultKt.throwOnFailure((Object)$result);
                        if (this.$item.getFile().exists()) {
                            this.$item.getFile().delete();
                        }
                        if ((meta = new File(this.$item.getFile().getAbsolutePath() + ".echo.json")).exists()) {
                            meta.delete();
                        }
                        this.this$0.refreshCompleted();
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

    public final void playOffline(@NotNull DownloadedTrack item2) {
        Intrinsics.checkNotNullParameter((Object)item2, (String)"item");
        this.playerViewModel.playLocal(item2.getTrack(), item2.getFile());
    }

    public final void openInExplorer(@NotNull File file2) {
        Intrinsics.checkNotNullParameter((Object)file2, (String)"file");
        BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(file2, null){
            int label;
            final /* synthetic */ File $file;
            {
                this.$file = $file;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        try {
                            String string2 = System.getProperty("os.name", "");
                            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getProperty(...)");
                            String string3 = string2.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
                            String os = string3;
                            if (StringsKt.contains$default((CharSequence)os, (CharSequence)"win", (boolean)false, (int)2, null)) {
                                String[] stringArray = new String[]{"explorer.exe", "/select,", this.$file.getAbsolutePath()};
                                Runtime.getRuntime().exec(stringArray);
                            } else if (Desktop.isDesktopSupported()) {
                                Desktop desktop = Desktop.getDesktop();
                                File file2 = this.$file.getParentFile();
                                if (file2 == null) {
                                    file2 = this.$file;
                                }
                                desktop.open(file2);
                            }
                        }
                        catch (Throwable t) {
                            Desktop desktop = Desktop.getDesktop();
                            File file3 = this.$file.getParentFile();
                            if (file3 == null) {
                                file3 = this.$file;
                            }
                            desktop.open(file3);
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
        }), (int)2, null);
    }

    public final void openDownloadsFolder() {
        BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ DesktopDownloadManager this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        File dir = this.this$0.getDownloadDir();
                        try {
                            if (Desktop.isDesktopSupported()) {
                                Desktop.getDesktop().open(dir);
                            }
                        }
                        catch (Throwable t) {
                            t.printStackTrace();
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
        }), (int)2, null);
    }

    private final void updateTask(DownloadTask task) {
        int idx;
        List list2;
        block4: {
            int n;
            List $this$indexOfFirst$iv = list2 = CollectionsKt.toMutableList((Collection)((Collection)this._activeDownloads.getValue()));
            boolean $i$f$indexOfFirst = false;
            int index$iv = 0;
            for (Object item$iv : $this$indexOfFirst$iv) {
                DownloadTask it = (DownloadTask)item$iv;
                boolean bl = false;
                if (Intrinsics.areEqual((Object)it.getId(), (Object)task.getId())) {
                    n = index$iv;
                    break block4;
                }
                ++index$iv;
            }
            n = idx = -1;
        }
        if (idx >= 0) {
            list2.set(idx, task);
        } else {
            list2.add(task);
        }
        this._activeDownloads.setValue((Object)list2);
    }

    private final String sanitizeFileName(String name) {
        CharSequence charSequence = name;
        Regex regex = new Regex("[\\\\/:*?\"<>|]");
        String string2 = "_";
        return StringsKt.take((String)((Object)StringsKt.trim((CharSequence)regex.replace(charSequence, string2))).toString(), (int)100);
    }

    private static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setPrettyPrint(true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Json access$getJson$p(DesktopDownloadManager $this) {
        return $this.json;
    }

    public static final /* synthetic */ MutableStateFlow access$get_completedDownloads$p(DesktopDownloadManager $this) {
        return $this._completedDownloads;
    }

    public static final /* synthetic */ String access$sanitizeFileName(DesktopDownloadManager $this, String name) {
        return $this.sanitizeFileName(name);
    }

    public static final /* synthetic */ void access$updateTask(DesktopDownloadManager $this, DownloadTask task) {
        $this.updateTask(task);
    }

    public static final /* synthetic */ PlayerViewModel access$getPlayerViewModel$p(DesktopDownloadManager $this) {
        return $this.playerViewModel;
    }

    public static final /* synthetic */ EchoSettings access$getSettings$p(DesktopDownloadManager $this) {
        return $this.settings;
    }

    public static final /* synthetic */ OkHttpClient access$getHttpClient$p(DesktopDownloadManager $this) {
        return $this.httpClient;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getJobs$p(DesktopDownloadManager $this) {
        return $this.jobs;
    }
}

