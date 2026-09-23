/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 *  kotlin.text.RegexOption
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Deferred
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonKt
 *  kotlinx.serialization.json.JsonObject
 *  kotlinx.serialization.json.JsonPrimitive
 *  okhttp3.OkHttpClient
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions.builtin;

import dev.brahmkshatriya.echo.common.clients.AlbumClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistClient;
import dev.brahmkshatriya.echo.common.clients.RadioClient;
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.io.Closeable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0002UVB\u001b\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010$\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010&J\u0018\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u0010(\u001a\u00020%H\u0082@\u00a2\u0006\u0002\u0010&J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020%H\u0002J$\u0010,\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00180-2\u0006\u0010/\u001a\u00020%H\u0002J$\u00100\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00180-2\u0006\u00101\u001a\u00020%H\u0002J\u0012\u00102\u001a\u0004\u0018\u00010.2\u0006\u00103\u001a\u00020%H\u0002J\u001c\u00104\u001a\u0004\u0018\u00010.2\u0006\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010%H\u0002J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020.0\u00182\u0006\u0010$\u001a\u00020%H\u0002J\u001e\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020;H\u0096@\u00a2\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010:\u001a\u00020;H\u0096@\u00a2\u0006\u0002\u0010AJ\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u00109\u001a\u00020.H\u0096@\u00a2\u0006\u0002\u0010CJ\u0016\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EH\u0096@\u00a2\u0006\u0002\u0010GJ\u001e\u0010H\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001c2\u0006\u0010F\u001a\u00020EH\u0096@\u00a2\u0006\u0002\u0010GJ\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010F\u001a\u00020EH\u0096@\u00a2\u0006\u0002\u0010GJ\u0016\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020.0\u001c2\u0006\u0010K\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010K\u001a\u00020JH\u0096@\u00a2\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020NH\u0096@\u00a2\u0006\u0002\u0010PJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020.0\u001c2\u0006\u0010O\u001a\u00020NH\u0096@\u00a2\u0006\u0002\u0010PJ \u0010O\u001a\u00020N2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010RH\u0096@\u00a2\u0006\u0002\u0010TR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006W"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/clients/HomeFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/SearchFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "Ldev/brahmkshatriya/echo/common/clients/AlbumClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistClient;", "Ldev/brahmkshatriya/echo/common/clients/RadioClient;", "platform", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "echoSettings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AppPlatform;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;)V", "json", "Lkotlinx/serialization/json/Json;", "client", "Lokhttp3/OkHttpClient;", "currentSettings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "setSettings", "", "settings", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cachedHomeFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "lastHomeFeedFetch", "", "featuredPlaylists", "Ldev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension$PlaylistSeed;", "loadHomeFeed", "loadSearchFeed", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveDirectSpotifyLink", "input", "fetchEmbedJson", "Lkotlinx/serialization/json/JsonObject;", "url", "fetchPlaylistTracks", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Track;", "playlistId", "fetchAlbumTracks", "albumId", "fetchTrackDetails", "trackId", "parseTrackItem", "obj", "defaultCover", "searchMusicCatalog", "loadTrack", "track", "isDownload", "", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAlbum", "Ldev/brahmkshatriya/echo/common/models/Album;", "album", "(Ldev/brahmkshatriya/echo/common/models/Album;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTracks", "loadPlaylist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "playlist", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRadio", "Ldev/brahmkshatriya/echo/common/models/Radio;", "radio", "(Ldev/brahmkshatriya/echo/common/models/Radio;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "context", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PlaylistSeed", "core"})
@SourceDebugExtension(value={"SMAP\nSpotifyExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpotifyExtension.kt\ndev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,575:1\n1617#2,9:576\n1869#2:585\n1870#2:587\n1626#2:588\n1617#2,9:589\n1869#2:598\n1870#2:600\n1626#2:601\n1563#2:602\n1634#2,3:603\n1617#2,9:607\n1869#2:616\n1870#2:618\n1626#2:619\n1#3:586\n1#3:599\n1#3:606\n1#3:617\n*S KotlinDebug\n*F\n+ 1 SpotifyExtension.kt\ndev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension\n*L\n325#1:576,9\n325#1:585\n325#1:587\n325#1:588\n350#1:589,9\n350#1:598\n350#1:600\n350#1:601\n389#1:602\n389#1:603,3\n442#1:607,9\n442#1:616\n442#1:618\n442#1:619\n325#1:586\n350#1:599\n442#1:617\n*E\n"})
public final class SpotifyExtension
implements ExtensionClient,
HomeFeedClient,
SearchFeedClient,
TrackClient,
AlbumClient,
PlaylistClient,
RadioClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AppPlatform platform;
    @Nullable
    private final EchoSettings echoSettings;
    @NotNull
    private final Json json;
    @NotNull
    private final OkHttpClient client;
    @Nullable
    private Settings currentSettings;
    @Nullable
    private Feed<Shelf> cachedHomeFeed;
    private long lastHomeFeedFetch;
    @NotNull
    private final List<PlaylistSeed> featuredPlaylists;
    @NotNull
    public static final String ID = "spotify";
    @NotNull
    private static final dev.brahmkshatriya.echo.common.models.Metadata METADATA;
    @NotNull
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36";

    public SpotifyExtension(@NotNull AppPlatform platform, @Nullable EchoSettings echoSettings) {
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        this.platform = platform;
        this.echoSettings = echoSettings;
        this.json = JsonKt.Json$default(null, SpotifyExtension::json$lambda$0, (int)1, null);
        this.client = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
        Object[] objectArray = new PlaylistSeed[]{new PlaylistSeed("37i9dQZF1DXcBWIGoYBM5M", "Today's Top Hits", "The biggest hits right now on Spotify"), new PlaylistSeed("37i9dQZEVXbMDoHDwVN2tF", "Top 50 - Global", "Most played tracks worldwide daily"), new PlaylistSeed("37i9dQZF1DX4o1oenSJRJd", "All Out 2000s", "The biggest songs of the 2000s"), new PlaylistSeed("37i9dQZF1DX0XUsuxWHRQd", "RapCaviar", "New hip-hop and rap releases"), new PlaylistSeed("37i9dQZF1DX4WYpdgoIcn6", "Chill Hits", "Kick back to the best new and recent chill tunes"), new PlaylistSeed("37i9dQZF1DWXRqgorJj26U", "Rock Classics", "Rock legends & epic songs that continue to inspire"), new PlaylistSeed("37i9dQZF1DWUa8ZRTfalHk", "Pop Rising", "The hits of tomorrow are here today"), new PlaylistSeed("37i9dQZF1DX4JAvHpjipBk", "New Music Friday", "The best new releases of the week")};
        this.featuredPlaylists = CollectionsKt.listOf((Object[])objectArray);
    }

    public /* synthetic */ SpotifyExtension(AppPlatform appPlatform, EchoSettings echoSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
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

    @Override
    @Nullable
    public Object loadHomeFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        long now = System.currentTimeMillis();
        Feed<Shelf> feed2 = this.cachedHomeFeed;
        if (feed2 != null) {
            Feed<Shelf> it = feed2;
            boolean bl = false;
            if (now - this.lastHomeFeedFetch < 300000L) {
                return it;
            }
        }
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Feed<Shelf>>, Object>(this, now, null){
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SpotifyExtension this$0;
            final /* synthetic */ long $now;
            {
                this.this$0 = $receiver;
                this.$now = $now;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var20_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        shelves = new ArrayList<E>();
                        $this$map$iv /* !! */  = SpotifyExtension.access$getFeaturedPlaylists$p(this.this$0);
                        $i$f$map = false;
                        var6_6 = $this$map$iv /* !! */ ;
                        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv /* !! */ , (int)10));
                        $i$f$mapTo = false;
                        for (T item$iv$iv : $this$mapTo$iv$iv) {
                            var11_11 = (PlaylistSeed)item$iv$iv;
                            var19_19 = destination$iv$iv;
                            $i$a$-map-SpotifyExtension$loadHomeFeed$3$playlistItems$1 = false;
                            var13_13 = seed.getId();
                            var14_14 = seed.getTitle();
                            var15_15 = seed.getSubtitle();
                            var16_16 = seed.getSubtitle();
                            var17_17 = ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://i.scdn.co/image/ab67706f00000002810d346", null, false, 3, null);
                            var18_18 = MapsKt.mapOf((Pair)TuplesKt.to((Object)"extension_id", (Object)"spotify"));
                            var19_19.add(new Playlist(var13_13, var14_14, false, false, var17_17, null, null, null, null, var16_16, null, var15_15, var18_18, false, false, false, false, false, false, 517608, null));
                        }
                        playlistItems = (List)destination$iv$iv;
                        $this$map$iv /* !! */  = Shelf.Lists.Type.Linear;
                        shelves.add(new Shelf.Lists.Items("spotify_featured_playlists", "Featured Spotify Playlists", playlistItems, "Official Spotify Editorial Playlists", (Shelf.Lists.Type)$this$map$iv /* !! */ , null, null, 96, null));
                        this.L$0 = shelves;
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)playlistItems);
                        this.label = 1;
                        v0 = CoroutineScopeKt.coroutineScope((Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((List<Shelf>)shelves, this.this$0, null){
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            Object L$7;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ List<Shelf> $shelves;
                            final /* synthetic */ SpotifyExtension this$0;
                            {
                                this.$shelves = $shelves;
                                this.this$0 = $receiver;
                                super(2, $completion);
                            }

                            /*
                             * Unable to fully structure code
                             * Could not resolve type clashes
                             */
                            public final Object invokeSuspend(Object $result) {
                                var2_2 = (CoroutineScope)this.L$0;
                                var16_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        tthDeferred = BuildersKt.async$default((CoroutineScope)$this$coroutineScope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends List<? extends Track>>>, Object>(this.this$0, null){
                                            int label;
                                            final /* synthetic */ SpotifyExtension this$0;
                                            {
                                                this.this$0 = $receiver;
                                                super(2, $completion);
                                            }

                                            public final Object invokeSuspend(Object $result) {
                                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0: {
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        return SpotifyExtension.access$fetchPlaylistTracks(this.this$0, "37i9dQZF1DXcBWIGoYBM5M");
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }

                                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final Object invoke(CoroutineScope p1, Continuation<? super Pair<String, ? extends List<Track>>> p2) {
                                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }), (int)3, null);
                                        top50Deferred = BuildersKt.async$default((CoroutineScope)$this$coroutineScope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends List<? extends Track>>>, Object>(this.this$0, null){
                                            int label;
                                            final /* synthetic */ SpotifyExtension this$0;
                                            {
                                                this.this$0 = $receiver;
                                                super(2, $completion);
                                            }

                                            public final Object invokeSuspend(Object $result) {
                                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0: {
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        return SpotifyExtension.access$fetchPlaylistTracks(this.this$0, "37i9dQZEVXbMDoHDwVN2tF");
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }

                                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final Object invoke(CoroutineScope p1, Continuation<? super Pair<String, ? extends List<Track>>> p2) {
                                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }), (int)3, null);
                                        allOutDeferred = BuildersKt.async$default((CoroutineScope)$this$coroutineScope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Pair<? extends String, ? extends List<? extends Track>>>, Object>(this.this$0, null){
                                            int label;
                                            final /* synthetic */ SpotifyExtension this$0;
                                            {
                                                this.this$0 = $receiver;
                                                super(2, $completion);
                                            }

                                            public final Object invokeSuspend(Object $result) {
                                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch (this.label) {
                                                    case 0: {
                                                        ResultKt.throwOnFailure((Object)$result);
                                                        return SpotifyExtension.access$fetchPlaylistTracks(this.this$0, "37i9dQZF1DX4o1oenSJRJd");
                                                    }
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }

                                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                            }

                                            public final Object invoke(CoroutineScope p1, Continuation<? super Pair<String, ? extends List<Track>>> p2) {
                                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                            }
                                        }), (int)3, null);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$coroutineScope);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)tthDeferred);
                                        this.L$2 = top50Deferred;
                                        this.L$3 = allOutDeferred;
                                        this.label = 1;
                                        v0 = tthDeferred.await((Continuation)this);
                                        if (v0 == var16_3) {
                                            return var16_3;
                                        }
                                        ** GOTO lbl24
                                    }
                                    case 1: {
                                        allOutDeferred = (Deferred)this.L$3;
                                        top50Deferred = (Deferred)this.L$2;
                                        tthDeferred = (Deferred)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
lbl24:
                                        // 2 sources

                                        var6_10 = (Pair)v0;
                                        tthCover = (String)var6_10.component1();
                                        tthTracks = (List)var6_10.component2();
                                        if (((Collection)tthTracks).isEmpty() == false) {
                                            var9_15 /* !! */  = Shelf.Lists.Type.Linear;
                                            this.$shelves.add(new Shelf.Lists.Tracks("spotify_todays_top_hits", "Today's Top Hits", tthTracks, "Spotify Global Chart", (Shelf.Lists.Type)var9_15 /* !! */ , null, null, 96, null));
                                        }
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$coroutineScope);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)tthDeferred);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)top50Deferred);
                                        this.L$3 = allOutDeferred;
                                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)tthCover);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)tthTracks);
                                        this.label = 2;
                                        v1 = top50Deferred.await((Continuation)this);
                                        if (v1 == var16_3) {
                                            return var16_3;
                                        }
                                        ** GOTO lbl50
                                    }
                                    case 2: {
                                        tthTracks = (List)this.L$5;
                                        tthCover = (String)this.L$4;
                                        allOutDeferred = (Deferred)this.L$3;
                                        top50Deferred = (Deferred)this.L$2;
                                        tthDeferred = (Deferred)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl50:
                                        // 2 sources

                                        var9_15 /* !! */  = (Pair)v1;
                                        top50Cover = (String)var9_15 /* !! */ .component1();
                                        top50Tracks = (List)var9_15 /* !! */ .component2();
                                        if (((Collection)top50Tracks).isEmpty() == false) {
                                            var12_20 = Shelf.Lists.Type.Linear;
                                            this.$shelves.add(new Shelf.Lists.Tracks("spotify_top_50_global", "Top 50 - Global", top50Tracks, "Daily Most Played Tracks Worldwide", var12_20, null, null, 96, null));
                                        }
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$coroutineScope);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)tthDeferred);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)top50Deferred);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)allOutDeferred);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)tthCover);
                                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)tthTracks);
                                        this.L$6 = SpillingKt.nullOutSpilledVariable((Object)top50Cover);
                                        this.L$7 = SpillingKt.nullOutSpilledVariable((Object)top50Tracks);
                                        this.label = 3;
                                        v2 = allOutDeferred.await((Continuation)this);
                                        if (v2 == var16_3) {
                                            return var16_3;
                                        }
                                        ** GOTO lbl80
                                    }
                                    case 3: {
                                        top50Tracks = (List)this.L$7;
                                        top50Cover = (String)this.L$6;
                                        tthTracks = (List)this.L$5;
                                        tthCover = (String)this.L$4;
                                        allOutDeferred = (Deferred)this.L$3;
                                        top50Deferred = (Deferred)this.L$2;
                                        tthDeferred = (Deferred)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v2 = $result;
lbl80:
                                        // 2 sources

                                        if (((Collection)(allOutTracks = (List)((Pair)v2).component2())).isEmpty() == false) {
                                            var14_22 = CollectionsKt.take((Iterable)allOutTracks, (int)30);
                                            var15_23 = Shelf.Lists.Type.Linear;
                                            this.$shelves.add(new Shelf.Lists.Tracks("spotify_all_out_2000s", "All Out 2000s Hits", var14_22, "Throwback Classics", var15_23, null, null, 96, null));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }), (Continuation)((Continuation)this));
                        if (v0 == var20_2) {
                            return var20_2;
                        }
                        ** GOTO lbl41
                    }
                    case 1: {
                        playlistItems = (List)this.L$1;
                        shelves = (List)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl41:
                        // 2 sources

                        feed = Feed.Companion.toFeed$default(Feed.Companion, shelves, null, null, 3, null);
                        SpotifyExtension.access$setCachedHomeFeed$p(this.this$0, feed);
                        SpotifyExtension.access$setLastHomeFeedFetch$p(this.this$0, this.$now);
                        return feed;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Feed<Shelf>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
    }

    @Override
    @Nullable
    public Object loadSearchFeed(@NotNull String query, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        String trimmed = ((Object)StringsKt.trim((CharSequence)query)).toString();
        if (((CharSequence)trimmed).length() == 0) {
            return this.loadHomeFeed($completion);
        }
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Feed<Shelf>>, Object>(trimmed, this, null){
            Object L$0;
            int label;
            final /* synthetic */ String $trimmed;
            final /* synthetic */ SpotifyExtension this$0;
            {
                this.$trimmed = $trimmed;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var20_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        shelves = new ArrayList<E>();
                        if (!StringsKt.contains$default((CharSequence)this.$trimmed, (CharSequence)"spotify.com/", (boolean)false, (int)2, null) && !StringsKt.startsWith$default((String)this.$trimmed, (String)"spotify:", (boolean)false, (int)2, null)) ** GOTO lbl19
                        this.L$0 = shelves;
                        this.label = 1;
                        v0 = SpotifyExtension.access$resolveDirectSpotifyLink(this.this$0, this.$trimmed, (Continuation)this);
                        if (v0 == var20_2) {
                            return var20_2;
                        }
                        ** GOTO lbl17
                    }
                    case 1: {
                        shelves = (List)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl17:
                        // 2 sources

                        if ((resolvedShelf = (Shelf)v0) != null) {
                            return Feed.Companion.toFeed$default(Feed.Companion, CollectionsKt.listOf((Object)resolvedShelf), null, null, 3, null);
                        }
lbl19:
                        // 3 sources

                        if (((Collection)(tracks = SpotifyExtension.access$searchMusicCatalog(this.this$0, this.$trimmed))).isEmpty() == false) {
                            shelves.add(new Shelf.Lists.Tracks("spotify_search_tracks", "Songs matching \"" + this.$trimmed + "\"", tracks, null, Shelf.Lists.Type.Linear, null, null, 104, null));
                            $this$mapNotNull$iv = tracks;
                            $i$f$mapNotNull = false;
                            var7_7 = $this$mapNotNull$iv;
                            destination$iv$iv = new ArrayList<E>();
                            $i$f$mapNotNullTo = false;
                            $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                            $i$f$forEach = false;
                            var12_14 = $this$forEach$iv$iv$iv.iterator();
                            while (var12_14.hasNext()) {
                                element$iv$iv = element$iv$iv$iv = var12_14.next();
                                $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1$iv$iv = false;
                                it = (Track)element$iv$iv;
                                $i$a$-mapNotNull-SpotifyExtension$loadSearchFeed$2$albums$1 = false;
                                if (it.getAlbum() == null) continue;
                                $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1$iv$iv = false;
                                destination$iv$iv.add(it$iv$iv);
                            }
                            $this$mapNotNull$iv = (List)destination$iv$iv;
                            $i$f$distinctBy = false;
                            set$iv = new HashSet<String>();
                            list$iv = new ArrayList<T>();
                            for (T e$iv : $this$distinctBy$iv) {
                                it = (Album)e$iv;
                                $i$a$-distinctBy-SpotifyExtension$loadSearchFeed$2$albums$2 = false;
                                key$iv = it.getId();
                                if (!set$iv.add(key$iv)) continue;
                                list$iv.add(e$iv);
                            }
                            albums = CollectionsKt.take((Iterable)list$iv, (int)10);
                            if (((Collection)albums).isEmpty() == false) {
                                shelves.add(new Shelf.Lists.Items("spotify_search_albums", "Albums", albums, null, Shelf.Lists.Type.Linear, null, null, 104, null));
                            }
                        } else {
                            Boxing.boxBoolean((boolean)shelves.add(new Shelf.Lists.Tracks("spotify_search_empty", "No songs found for \"" + this.$trimmed + "\"", CollectionsKt.emptyList(), null, Shelf.Lists.Type.Linear, null, null, 104, null)));
                        }
                        return Feed.Companion.toFeed$default(Feed.Companion, shelves, null, null, 3, null);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Feed<Shelf>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
    }

    private final Object resolveDirectSpotifyLink(String input, Continuation<? super Shelf> $completion) {
        Shelf shelf;
        String clean = StringsKt.substringBefore$default((String)input, (char)'?', null, (int)2, null);
        String id2 = StringsKt.substringAfterLast$default((String)StringsKt.substringAfterLast$default((String)clean, (char)'/', null, (int)2, null), (char)':', null, (int)2, null);
        if (StringsKt.contains$default((CharSequence)clean, (CharSequence)"/track", (boolean)false, (int)2, null) || StringsKt.startsWith$default((String)input, (String)"spotify:track:", (boolean)false, (int)2, null)) {
            Shelf.Lists.Tracks tracks;
            Track track2;
            Track track3 = track2 = this.fetchTrackDetails(id2);
            if (track3 != null) {
                Track it = track3;
                boolean bl = false;
                tracks = new Shelf.Lists.Tracks("spotify_direct_track", "Track", CollectionsKt.listOf((Object)it), null, Shelf.Lists.Type.Linear, null, null, 104, null);
            } else {
                tracks = null;
            }
            shelf = tracks;
        } else if (StringsKt.contains$default((CharSequence)clean, (CharSequence)"/playlist", (boolean)false, (int)2, null) || StringsKt.startsWith$default((String)input, (String)"spotify:playlist:", (boolean)false, (int)2, null)) {
            List tracks = (List)this.fetchPlaylistTracks(id2).component2();
            shelf = new Shelf.Lists.Tracks("spotify_direct_playlist", "Spotify Playlist (" + id2 + ")", tracks, null, Shelf.Lists.Type.Linear, null, null, 104, null);
        } else if (StringsKt.contains$default((CharSequence)clean, (CharSequence)"/album", (boolean)false, (int)2, null) || StringsKt.startsWith$default((String)input, (String)"spotify:album:", (boolean)false, (int)2, null)) {
            List tracks = (List)this.fetchAlbumTracks(id2).component2();
            shelf = new Shelf.Lists.Tracks("spotify_direct_album", "Spotify Album (" + id2 + ")", tracks, null, Shelf.Lists.Type.Linear, null, null, 104, null);
        } else {
            shelf = null;
        }
        return shelf;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final JsonObject fetchEmbedJson(String url) {
        JsonObject jsonObject;
        try {
            JsonObject jsonObject2;
            Request req = new Request.Builder().url(url).header("User-Agent", USER_AGENT).header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8").header("Accept-Language", "en-US,en;q=0.9").build();
            Closeable closeable = (Closeable)this.client.newCall(req).execute();
            Throwable throwable = null;
            try {
                MatchResult matchResult;
                Response resp = (Response)closeable;
                boolean bl = false;
                if (!resp.isSuccessful()) {
                    JsonObject jsonObject3 = null;
                    return jsonObject3;
                }
                Object object = resp.body();
                if (object == null || (object = object.string()) == null) {
                    JsonObject jsonObject4 = null;
                    return jsonObject4;
                }
                Object html = object;
                if (Regex.find$default((Regex)new Regex("<script id=\"__NEXT_DATA__\"[^>]*>(.*?)</script>", RegexOption.DOT_MATCHES_ALL), (CharSequence)((CharSequence)html), (int)0, (int)2, null) == null) {
                    JsonObject jsonObject5 = null;
                    return jsonObject5;
                }
                MatchResult match = matchResult;
                jsonObject2 = JsonElementKt.getJsonObject((JsonElement)this.json.parseToJsonElement((String)match.getGroupValues().get(1)));
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            jsonObject = jsonObject2;
        }
        catch (Exception e) {
            System.out.println((Object)("[SpotifyExtension] Error fetching embed " + url + ": " + e.getMessage()));
            jsonObject = null;
        }
        return jsonObject;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<String, List<Track>> fetchPlaylistTracks(String playlistId) {
        Pair pair;
        String url = "https://open.spotify.com/embed/playlist/" + playlistId;
        JsonObject jsonObject = this.fetchEmbedJson(url);
        if (jsonObject == null) {
            return TuplesKt.to(null, (Object)CollectionsKt.emptyList());
        }
        JsonObject root = jsonObject;
        try {
            void $this$mapNotNullTo$iv$iv;
            JsonObject jsonObject2;
            JsonElement jsonElement;
            JsonObject jsonObject3;
            JsonElement jsonElement2;
            Object object;
            JsonElement jsonElement3;
            JsonObject jsonObject4;
            JsonElement jsonElement4;
            JsonObject jsonObject5;
            JsonElement jsonElement5 = (JsonElement)root.get((Object)"props");
            if (jsonElement5 == null || (jsonObject5 = JsonElementKt.getJsonObject((JsonElement)jsonElement5)) == null || (jsonElement4 = (JsonElement)jsonObject5.get((Object)"pageProps")) == null || (jsonObject4 = JsonElementKt.getJsonObject((JsonElement)jsonElement4)) == null || (jsonElement3 = (JsonElement)jsonObject4.get((Object)"state")) == null || (object = JsonElementKt.getJsonObject((JsonElement)jsonElement3)) == null || (jsonElement2 = (JsonElement)object.get((Object)"data")) == null || (jsonObject3 = JsonElementKt.getJsonObject((JsonElement)jsonElement2)) == null || (jsonElement = (JsonElement)jsonObject3.get((Object)"entity")) == null || (jsonObject2 = JsonElementKt.getJsonObject((JsonElement)jsonElement)) == null) {
                return TuplesKt.to(null, (Object)CollectionsKt.emptyList());
            }
            JsonObject entity = jsonObject2;
            jsonObject5 = (JsonElement)entity.get((Object)"coverArt");
            String coverArtUrl = jsonObject5 != null && (jsonElement4 = JsonElementKt.getJsonObject((JsonElement)jsonObject5)) != null && (jsonObject4 = (JsonElement)jsonElement4.get((Object)"sources")) != null && (jsonElement3 = JsonElementKt.getJsonArray((JsonElement)jsonObject4)) != null && (object = (JsonElement)CollectionsKt.firstOrNull((List)((List)jsonElement3))) != null && (jsonElement2 = JsonElementKt.getJsonObject((JsonElement)object)) != null && (jsonObject3 = (JsonElement)jsonElement2.get((Object)"url")) != null && (jsonElement = JsonElementKt.getJsonPrimitive((JsonElement)jsonObject3)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement) : null;
            JsonElement jsonElement6 = (JsonElement)entity.get((Object)"trackList");
            if (jsonElement6 == null || (jsonElement6 = JsonElementKt.getJsonArray((JsonElement)jsonElement6)) == null) {
                return TuplesKt.to(coverArtUrl, (Object)CollectionsKt.emptyList());
            }
            JsonElement trackList = jsonElement6;
            Iterable $this$mapNotNull$iv = (Iterable)trackList;
            boolean $i$f$mapNotNull = false;
            object = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator = $this$forEach$iv$iv$iv.iterator();
            while (iterator.hasNext()) {
                Track it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator.next();
                boolean bl = false;
                JsonElement item2 = (JsonElement)element$iv$iv;
                boolean bl2 = false;
                if (this.parseTrackItem(JsonElementKt.getJsonObject((JsonElement)item2), coverArtUrl) == null) continue;
                boolean bl3 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            List tracks = (List)destination$iv$iv;
            pair = TuplesKt.to((Object)coverArtUrl, (Object)tracks);
        }
        catch (Exception e) {
            System.out.println((Object)("[SpotifyExtension] Error parsing playlist " + playlistId + ": " + e.getMessage()));
            pair = TuplesKt.to(null, (Object)CollectionsKt.emptyList());
        }
        return pair;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<String, List<Track>> fetchAlbumTracks(String albumId) {
        Pair pair;
        String url = "https://open.spotify.com/embed/album/" + albumId;
        JsonObject jsonObject = this.fetchEmbedJson(url);
        if (jsonObject == null) {
            return TuplesKt.to(null, (Object)CollectionsKt.emptyList());
        }
        JsonObject root = jsonObject;
        try {
            void $this$mapNotNullTo$iv$iv;
            JsonObject jsonObject2;
            JsonElement jsonElement;
            JsonObject jsonObject3;
            JsonElement jsonElement2;
            Object object;
            JsonElement jsonElement3;
            JsonObject jsonObject4;
            JsonElement jsonElement4;
            JsonObject jsonObject5;
            JsonElement jsonElement5 = (JsonElement)root.get((Object)"props");
            if (jsonElement5 == null || (jsonObject5 = JsonElementKt.getJsonObject((JsonElement)jsonElement5)) == null || (jsonElement4 = (JsonElement)jsonObject5.get((Object)"pageProps")) == null || (jsonObject4 = JsonElementKt.getJsonObject((JsonElement)jsonElement4)) == null || (jsonElement3 = (JsonElement)jsonObject4.get((Object)"state")) == null || (object = JsonElementKt.getJsonObject((JsonElement)jsonElement3)) == null || (jsonElement2 = (JsonElement)object.get((Object)"data")) == null || (jsonObject3 = JsonElementKt.getJsonObject((JsonElement)jsonElement2)) == null || (jsonElement = (JsonElement)jsonObject3.get((Object)"entity")) == null || (jsonObject2 = JsonElementKt.getJsonObject((JsonElement)jsonElement)) == null) {
                return TuplesKt.to(null, (Object)CollectionsKt.emptyList());
            }
            JsonObject entity = jsonObject2;
            jsonObject5 = (JsonElement)entity.get((Object)"coverArt");
            String coverArtUrl = jsonObject5 != null && (jsonElement4 = JsonElementKt.getJsonObject((JsonElement)jsonObject5)) != null && (jsonObject4 = (JsonElement)jsonElement4.get((Object)"sources")) != null && (jsonElement3 = JsonElementKt.getJsonArray((JsonElement)jsonObject4)) != null && (object = (JsonElement)CollectionsKt.firstOrNull((List)((List)jsonElement3))) != null && (jsonElement2 = JsonElementKt.getJsonObject((JsonElement)object)) != null && (jsonObject3 = (JsonElement)jsonElement2.get((Object)"url")) != null && (jsonElement = JsonElementKt.getJsonPrimitive((JsonElement)jsonObject3)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement) : null;
            JsonElement jsonElement6 = (JsonElement)entity.get((Object)"trackList");
            if (jsonElement6 == null || (jsonElement6 = JsonElementKt.getJsonArray((JsonElement)jsonElement6)) == null) {
                return TuplesKt.to(coverArtUrl, (Object)CollectionsKt.emptyList());
            }
            JsonElement trackList = jsonElement6;
            Iterable $this$mapNotNull$iv = (Iterable)trackList;
            boolean $i$f$mapNotNull = false;
            object = $this$mapNotNull$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator iterator = $this$forEach$iv$iv$iv.iterator();
            while (iterator.hasNext()) {
                Track it$iv$iv;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator.next();
                boolean bl = false;
                JsonElement item2 = (JsonElement)element$iv$iv;
                boolean bl2 = false;
                if (this.parseTrackItem(JsonElementKt.getJsonObject((JsonElement)item2), coverArtUrl) == null) continue;
                boolean bl3 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            List tracks = (List)destination$iv$iv;
            pair = TuplesKt.to((Object)coverArtUrl, (Object)tracks);
        }
        catch (Exception e) {
            System.out.println((Object)("[SpotifyExtension] Error parsing album " + albumId + ": " + e.getMessage()));
            pair = TuplesKt.to(null, (Object)CollectionsKt.emptyList());
        }
        return pair;
    }

    private final Track fetchTrackDetails(String trackId) {
        Track track2;
        String url = "https://open.spotify.com/embed/track/" + trackId;
        JsonObject jsonObject = this.fetchEmbedJson(url);
        if (jsonObject == null) {
            return null;
        }
        JsonObject root = jsonObject;
        try {
            JsonObject jsonObject2;
            JsonElement jsonElement;
            JsonObject jsonObject3;
            JsonElement jsonElement2;
            JsonObject jsonObject4;
            JsonElement jsonElement3;
            JsonObject jsonObject5;
            JsonElement jsonElement4;
            JsonObject jsonObject6;
            JsonElement jsonElement5 = (JsonElement)root.get((Object)"props");
            if (jsonElement5 == null || (jsonObject6 = JsonElementKt.getJsonObject((JsonElement)jsonElement5)) == null || (jsonElement4 = (JsonElement)jsonObject6.get((Object)"pageProps")) == null || (jsonObject5 = JsonElementKt.getJsonObject((JsonElement)jsonElement4)) == null || (jsonElement3 = (JsonElement)jsonObject5.get((Object)"state")) == null || (jsonObject4 = JsonElementKt.getJsonObject((JsonElement)jsonElement3)) == null || (jsonElement2 = (JsonElement)jsonObject4.get((Object)"data")) == null || (jsonObject3 = JsonElementKt.getJsonObject((JsonElement)jsonElement2)) == null || (jsonElement = (JsonElement)jsonObject3.get((Object)"entity")) == null || (jsonObject2 = JsonElementKt.getJsonObject((JsonElement)jsonElement)) == null) {
                return null;
            }
            JsonObject entity = jsonObject2;
            jsonObject6 = (JsonElement)entity.get((Object)"coverArt");
            String coverArtUrl = jsonObject6 != null && (jsonElement4 = JsonElementKt.getJsonObject((JsonElement)jsonObject6)) != null && (jsonObject5 = (JsonElement)jsonElement4.get((Object)"sources")) != null && (jsonElement3 = JsonElementKt.getJsonArray((JsonElement)jsonObject5)) != null && (jsonObject4 = (JsonElement)CollectionsKt.firstOrNull((List)((List)jsonElement3))) != null && (jsonElement2 = JsonElementKt.getJsonObject((JsonElement)jsonObject4)) != null && (jsonObject3 = (JsonElement)jsonElement2.get((Object)"url")) != null && (jsonElement = JsonElementKt.getJsonPrimitive((JsonElement)jsonObject3)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement) : null;
            track2 = this.parseTrackItem(entity, coverArtUrl);
        }
        catch (Exception e) {
            System.out.println((Object)("[SpotifyExtension] Error parsing track " + trackId + ": " + e.getMessage()));
            track2 = null;
        }
        return track2;
    }

    private final Track parseTrackItem(JsonObject obj, String defaultCover) {
        Object object;
        JsonElement jsonElement;
        Object object2;
        JsonElement jsonElement2;
        JsonObject jsonObject;
        List list2;
        Object object3;
        String string2;
        JsonObject it;
        Pair[] pairArray;
        Pair[] pairArray2;
        JsonElement $this$mapTo$iv$iv;
        Long duration;
        JsonElement jsonElement3;
        Object object4;
        Object uri;
        Object object5 = (JsonElement)obj.get((Object)"uri");
        if (object5 == null || (object5 = JsonElementKt.getJsonPrimitive((JsonElement)object5)) == null || (object5 = JsonElementKt.getContentOrNull((JsonPrimitive)object5)) == null) {
            object5 = "";
        }
        if (StringsKt.contains$default((CharSequence)((CharSequence)(uri = object5)), (char)':', (boolean)false, (int)2, null)) {
            object4 = StringsKt.substringAfterLast$default((String)uri, (char)':', null, (int)2, null);
        } else {
            object4 = (JsonElement)obj.get((Object)"id");
            if (object4 == null || (object4 = JsonElementKt.getJsonPrimitive((JsonElement)object4)) == null || (object4 = JsonElementKt.getContentOrNull((JsonPrimitive)object4)) == null) {
                return null;
            }
        }
        Object id2 = object4;
        Object object6 = (JsonElement)obj.get((Object)"title");
        if ((object6 == null || (object6 = JsonElementKt.getJsonPrimitive((JsonElement)object6)) == null || (object6 = JsonElementKt.getContentOrNull((JsonPrimitive)object6)) == null) && ((jsonElement3 = (JsonElement)obj.get((Object)"name")) != null && (jsonElement3 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement3)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement3) : (object6 = null)) == null) {
            return null;
        }
        Object title = object6;
        Object object7 = (JsonElement)obj.get((Object)"subtitle");
        if (object7 == null || (object7 = JsonElementKt.getJsonPrimitive((JsonElement)object7)) == null || (object7 = JsonElementKt.getContentOrNull((JsonPrimitive)object7)) == null) {
            object7 = "";
        }
        Object subtitle2 = object7;
        JsonElement jsonElement4 = (JsonElement)obj.get((Object)"duration");
        Long l = duration = jsonElement4 != null && (jsonElement4 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement4)) != null ? JsonElementKt.getLongOrNull((JsonPrimitive)jsonElement4) : null;
        if (!StringsKt.isBlank((CharSequence)((CharSequence)subtitle2))) {
            String[] stringArray = new String[]{", "};
            Iterable $this$map$iv = StringsKt.split$default((CharSequence)((CharSequence)subtitle2), (String[])stringArray, (boolean)false, (int)0, (int)6, null);
            boolean $i$f$map = false;
            Iterable iterable = $this$map$iv;
            Pair[] destination$iv$iv = (Pair[])new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            pairArray2 = $this$mapTo$iv$iv.iterator();
            while (pairArray2.hasNext()) {
                Object item$iv$iv = pairArray2.next();
                String string3 = (String)item$iv$iv;
                pairArray = destination$iv$iv;
                boolean bl = false;
                string2 = ((Object)StringsKt.trim((CharSequence)((CharSequence)it))).toString();
                object3 = "artist_" + ((Object)StringsKt.trim((CharSequence)((CharSequence)it))).toString();
                pairArray.add(new Artist((String)object3, string2, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
            }
            list2 = (List)destination$iv$iv;
        } else {
            list2 = CollectionsKt.listOf((Object)new Artist("spotify_artist", "Spotify Artist", null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
        }
        List artists = list2;
        JsonElement jsonElement5 = (JsonElement)obj.get((Object)"audioPreview");
        String previewUrl = jsonElement5 != null && (jsonElement5 = JsonElementKt.getJsonObject((JsonElement)jsonElement5)) != null && (jsonElement5 = (JsonElement)jsonElement5.get((Object)"url")) != null && (jsonElement5 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement5)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement5) : null;
        $this$mapTo$iv$iv = (JsonElement)obj.get((Object)"coverArt");
        String coverUrl = $this$mapTo$iv$iv != null && (jsonObject = JsonElementKt.getJsonObject((JsonElement)$this$mapTo$iv$iv)) != null && (jsonElement2 = (JsonElement)jsonObject.get((Object)"sources")) != null && (pairArray2 = JsonElementKt.getJsonArray((JsonElement)jsonElement2)) != null && (object2 = (JsonElement)CollectionsKt.firstOrNull((List)((List)pairArray2))) != null && (it = JsonElementKt.getJsonObject((JsonElement)object2)) != null && (jsonElement = (JsonElement)it.get((Object)"url")) != null && (string2 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement)) != null && (object3 = JsonElementKt.getContentOrNull((JsonPrimitive)string2)) != null ? object3 : defaultCover;
        List streamables = new ArrayList();
        if (previewUrl != null && StringsKt.startsWith$default((String)previewUrl, (String)"http", (boolean)false, (int)2, null)) {
            streamables.add(new Streamable(previewUrl, 96, Streamable.MediaType.Server, "Spotify Preview (MP3)", null, 16, null));
        }
        String string4 = coverUrl;
        jsonObject = string4 != null ? ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, string4, null, false, 3, null) : null;
        pairArray2 = new Pair[2];
        pairArray2[0] = TuplesKt.to((Object)"extension_id", (Object)ID);
        Pair[] pairArray3 = pairArray2;
        int n = 1;
        String string5 = "spotify_uri";
        object2 = (CharSequence)uri;
        if (object2.length() == 0) {
            String string6 = string5;
            int n2 = n;
            pairArray = pairArray3;
            boolean bl = false;
            String string7 = "spotify:track:" + (String)id2;
            pairArray3 = pairArray;
            n = n2;
            string5 = string6;
            object = string7;
        } else {
            object = object2;
        }
        pairArray3[n] = TuplesKt.to((Object)string5, (Object)object);
        Map map2 = MapsKt.mapOf((Pair[])pairArray2);
        return new Track((String)id2, (String)title, null, (ImageHolder)jsonObject, artists, null, duration, null, null, null, null, null, null, null, null, null, null, false, null, map2, null, streamables, false, false, false, false, false, false, 265813924, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private final List<Track> searchMusicCatalog(String query) {
        List list2;
        try {
            List list3;
            String encoded = URLEncoder.encode(query, "UTF-8");
            String url = "https://itunes.apple.com/search?term=" + encoded + "&entity=song&limit=25";
            Request req = new Request.Builder().url(url).header("User-Agent", USER_AGENT).build();
            Closeable closeable = (Closeable)this.client.newCall(req).execute();
            Throwable throwable = null;
            try {
                void $this$mapNotNullTo$iv$iv;
                Response resp = (Response)closeable;
                boolean bl = false;
                if (!resp.isSuccessful()) {
                    List list4 = CollectionsKt.emptyList();
                    return list4;
                }
                Object object = resp.body();
                if (object == null || (object = object.string()) == null) {
                    List list5 = CollectionsKt.emptyList();
                    return list5;
                }
                Object body = object;
                JsonObject root = JsonElementKt.getJsonObject((JsonElement)this.json.parseToJsonElement((String)body));
                JsonElement jsonElement = (JsonElement)root.get((Object)"results");
                if (jsonElement == null || (jsonElement = JsonElementKt.getJsonArray((JsonElement)jsonElement)) == null) {
                    List list6 = CollectionsKt.emptyList();
                    return list6;
                }
                JsonElement results2 = jsonElement;
                Iterable $this$mapNotNull$iv = (Iterable)results2;
                boolean $i$f$mapNotNull = false;
                Iterable iterable = $this$mapNotNull$iv;
                Collection destination$iv$iv = new ArrayList();
                boolean $i$f$mapNotNullTo = false;
                void $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
                boolean $i$f$forEach = false;
                Iterator iterator = $this$forEach$iv$iv$iv.iterator();
                while (iterator.hasNext()) {
                    Track track2;
                    Object element$iv$iv$iv;
                    Object element$iv$iv = element$iv$iv$iv = iterator.next();
                    boolean bl2 = false;
                    JsonElement item2 = (JsonElement)element$iv$iv;
                    boolean bl3 = false;
                    JsonObject obj = JsonElementKt.getJsonObject((JsonElement)item2);
                    Object object2 = (JsonElement)obj.get((Object)"trackId");
                    if (object2 == null || (object2 = JsonElementKt.getJsonPrimitive((JsonElement)object2)) == null || (object2 = JsonElementKt.getContentOrNull((JsonPrimitive)object2)) == null) {
                        track2 = null;
                    } else {
                        Object trackId = object2;
                        Object object3 = (JsonElement)obj.get((Object)"trackName");
                        if (object3 == null || (object3 = JsonElementKt.getJsonPrimitive((JsonElement)object3)) == null || (object3 = JsonElementKt.getContentOrNull((JsonPrimitive)object3)) == null) {
                            track2 = null;
                        } else {
                            Album album;
                            Object object4;
                            String previewUrl;
                            String artwork100;
                            Object trackName = object3;
                            Object object5 = (JsonElement)obj.get((Object)"artistName");
                            if (object5 == null || (object5 = JsonElementKt.getJsonPrimitive((JsonElement)object5)) == null || (object5 = JsonElementKt.getContentOrNull((JsonPrimitive)object5)) == null) {
                                object5 = "Unknown Artist";
                            }
                            JsonElement artistName = object5;
                            JsonElement jsonElement2 = (JsonElement)obj.get((Object)"collectionName");
                            String collectionName = jsonElement2 != null && (jsonElement2 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement2)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement2) : null;
                            JsonElement jsonElement3 = (JsonElement)obj.get((Object)"artworkUrl100");
                            String string2 = artwork100 = jsonElement3 != null && (jsonElement3 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement3)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement3) : null;
                            String artworkHighRes = string2 != null ? StringsKt.replace$default((String)string2, (String)"100x100bb", (String)"600x600bb", (boolean)false, (int)4, null) : null;
                            JsonElement jsonElement4 = (JsonElement)obj.get((Object)"trackTimeMillis");
                            Long durationMillis = jsonElement4 != null && (jsonElement4 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement4)) != null ? JsonElementKt.getLongOrNull((JsonPrimitive)jsonElement4) : null;
                            JsonElement jsonElement5 = (JsonElement)obj.get((Object)"previewUrl");
                            String string3 = jsonElement5 != null && (jsonElement5 = JsonElementKt.getJsonPrimitive((JsonElement)jsonElement5)) != null ? JsonElementKt.getContentOrNull((JsonPrimitive)jsonElement5) : (previewUrl = null);
                            if (collectionName != null) {
                                String it;
                                boolean bl4 = false;
                                String string4 = artworkHighRes;
                                object4 = "artist_" + artistName.hashCode();
                                Album album2 = new Album("album_" + (String)trackId, it, null, string4 != null ? ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, string4, null, false, 3, null) : null, CollectionsKt.listOf((Object)new Artist((String)object4, (String)artistName, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null)), null, null, null, null, null, null, false, null, null, false, false, false, false, false, false, 1048548, null);
                                album = album2;
                            } else {
                                album = null;
                            }
                            Album album3 = album;
                            List streamables = new ArrayList();
                            if (previewUrl != null && StringsKt.startsWith$default((String)previewUrl, (String)"http", (boolean)false, (int)2, null)) {
                                streamables.add(new Streamable(previewUrl, 128, Streamable.MediaType.Server, "Spotify Preview (AAC)", null, 16, null));
                            }
                            String string5 = "artist_" + artistName.hashCode();
                            List list7 = CollectionsKt.listOf((Object)new Artist(string5, (String)artistName, null, null, null, null, null, null, false, false, false, false, false, false, 16380, null));
                            String string6 = artworkHighRes;
                            string5 = string6 != null ? ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, string6, null, false, 3, null) : null;
                            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)"extension_id", (Object)ID), TuplesKt.to((Object)"spotify_uri", (Object)("spotify:track:" + (String)trackId)), TuplesKt.to((Object)"track_title", (Object)trackName), TuplesKt.to((Object)"artist_name", (Object)artistName)};
                            object4 = MapsKt.mapOf((Pair[])pairArray);
                            track2 = new Track((String)trackId, (String)trackName, null, (ImageHolder)((Object)string5), list7, album3, durationMillis, null, null, null, null, null, null, null, null, null, null, false, null, (Map)object4, null, streamables, false, false, false, false, false, false, 265813892, null);
                        }
                    }
                    if (track2 == null) continue;
                    Track it$iv$iv = track2;
                    boolean bl5 = false;
                    destination$iv$iv.add(it$iv$iv);
                }
                list3 = (List)destination$iv$iv;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            list2 = list3;
        }
        catch (Exception e) {
            System.out.println((Object)("[SpotifyExtension] Search error for '" + query + "': " + e.getMessage()));
            list2 = CollectionsKt.emptyList();
        }
        return list2;
    }

    @Override
    @Nullable
    public Object loadTrack(@NotNull Track track2, boolean isDownload, @NotNull Continuation<? super Track> $completion) {
        if (!StringsKt.isBlank((CharSequence)track2.getTitle()) && !((Collection)track2.getArtists()).isEmpty() && track2.getCover() != null) {
            return track2;
        }
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Track>, Object>(this, track2, null){
            int label;
            final /* synthetic */ SpotifyExtension this$0;
            final /* synthetic */ Track $track;
            {
                this.this$0 = $receiver;
                this.$track = $track;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        Track track2 = SpotifyExtension.access$fetchTrackDetails(this.this$0, this.$track.getId());
                        if (track2 == null) {
                            track2 = this.$track;
                        }
                        return track2;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Track> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
    }

    @Override
    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable streamable, boolean isDownload, @NotNull Continuation<? super Streamable.Media> $completion) {
        String url = streamable.getId();
        NetworkRequest networkRequest = NetworkRequest.Companion.toGetRequest$default(NetworkRequest.Companion, url, null, 1, null);
        int n = streamable.getQuality();
        String string2 = streamable.getTitle();
        if (string2 == null) {
            string2 = "Spotify Audio";
        }
        Streamable.Source.Http source = new Streamable.Source.Http(networkRequest, null, null, n, string2, false, false, 102, null);
        return new Streamable.Media.Server(CollectionsKt.listOf((Object)source), false);
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Track track2, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    @Override
    @Nullable
    public Object loadAlbum(@NotNull Album album, @NotNull Continuation<? super Album> $completion) {
        return album;
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Album album, @NotNull Continuation<? super Feed<Track>> $completion) {
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Feed<Track>>, Object>(this, album, null){
            int label;
            final /* synthetic */ SpotifyExtension this$0;
            final /* synthetic */ Album $album;
            {
                this.this$0 = $receiver;
                this.$album = $album;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        List tracks = (List)SpotifyExtension.access$fetchAlbumTracks(this.this$0, this.$album.getId()).component2();
                        return !((Collection)tracks).isEmpty() ? Feed.Companion.toFeed$default(Feed.Companion, tracks, null, null, 3, null) : null;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Feed<Track>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Album album, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    @Override
    @Nullable
    public Object loadPlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Playlist> $completion) {
        return playlist;
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Playlist playlist, @NotNull Continuation<? super Feed<Track>> $completion) {
        return BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Feed<Track>>, Object>(this, playlist, null){
            int label;
            final /* synthetic */ SpotifyExtension this$0;
            final /* synthetic */ Playlist $playlist;
            {
                this.this$0 = $receiver;
                this.$playlist = $playlist;
                super(2, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        List tracks = (List)SpotifyExtension.access$fetchPlaylistTracks(this.this$0, this.$playlist.getId()).component2();
                        return Feed.Companion.toFeed$default(Feed.Companion, tracks, null, null, 3, null);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Feed<Track>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), $completion);
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Playlist playlist, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    @Override
    @Nullable
    public Object loadRadio(@NotNull Radio radio2, @NotNull Continuation<? super Radio> $completion) {
        return radio2;
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Radio radio2, @NotNull Continuation<? super Feed<Track>> $completion) {
        List<Track> tracks = this.searchMusicCatalog(radio2.getTitle());
        return Feed.Companion.toFeed$default(Feed.Companion, tracks, null, null, 3, null);
    }

    @Override
    @Nullable
    public Object radio(@NotNull EchoMediaItem item2, @Nullable EchoMediaItem context, @NotNull Continuation<? super Radio> $completion) {
        String title = item2.getTitle();
        String string2 = "radio_" + item2.getId();
        String string3 = title + " Radio";
        String string4 = "Spotify Radio for " + title;
        ImageHolder imageHolder = item2.getCover();
        Map map2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)"extension_id", (Object)ID));
        return new Radio(string2, string3, imageHolder, null, null, string4, null, map2, false, false, false, false, false, 8024, null);
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

    private static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ List access$getFeaturedPlaylists$p(SpotifyExtension $this) {
        return $this.featuredPlaylists;
    }

    public static final /* synthetic */ Pair access$fetchPlaylistTracks(SpotifyExtension $this, String playlistId) {
        return $this.fetchPlaylistTracks(playlistId);
    }

    public static final /* synthetic */ void access$setCachedHomeFeed$p(SpotifyExtension $this, Feed feed2) {
        $this.cachedHomeFeed = feed2;
    }

    public static final /* synthetic */ void access$setLastHomeFeedFetch$p(SpotifyExtension $this, long l) {
        $this.lastHomeFeedFetch = l;
    }

    public static final /* synthetic */ Object access$resolveDirectSpotifyLink(SpotifyExtension $this, String input, Continuation $completion) {
        return $this.resolveDirectSpotifyLink(input, (Continuation<? super Shelf>)$completion);
    }

    public static final /* synthetic */ List access$searchMusicCatalog(SpotifyExtension $this, String query) {
        return $this.searchMusicCatalog(query);
    }

    public static final /* synthetic */ Track access$fetchTrackDetails(SpotifyExtension $this, String trackId) {
        return $this.fetchTrackDetails(trackId);
    }

    public static final /* synthetic */ Pair access$fetchAlbumTracks(SpotifyExtension $this, String albumId) {
        return $this.fetchAlbumTracks(albumId);
    }

    static {
        String string2 = Reflection.getOrCreateKotlinClass(SpotifyExtension.class).getQualifiedName();
        if (string2 == null) {
            string2 = "SpotifyExtension";
        }
        METADATA = new dev.brahmkshatriya.echo.common.models.Metadata(string2, "builtin:spotify", ImportType.File, ExtensionType.MUSIC, ID, "Spotify", "1.0.0", "Official Spotify Top 50 Global, Today's Top Hits, playlists, albums, and songs with high-fidelity streaming.", "SpotHub", null, null, null, null, null, true, 15872, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension$Companion;", "", "<init>", "()V", "ID", "", "METADATA", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMETADATA", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "USER_AGENT", "core"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final dev.brahmkshatriya.echo.common.models.Metadata getMETADATA() {
            return METADATA;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/builtin/SpotifyExtension$PlaylistSeed;", "", "id", "", "title", "subtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSubtitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "core"})
    private static final class PlaylistSeed {
        @NotNull
        private final String id;
        @NotNull
        private final String title;
        @NotNull
        private final String subtitle;

        public PlaylistSeed(@NotNull String id2, @NotNull String title, @NotNull String subtitle2) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            Intrinsics.checkNotNullParameter((Object)subtitle2, (String)"subtitle");
            this.id = id2;
            this.title = title;
            this.subtitle = subtitle2;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.subtitle;
        }

        @NotNull
        public final PlaylistSeed copy(@NotNull String id2, @NotNull String title, @NotNull String subtitle2) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            Intrinsics.checkNotNullParameter((Object)subtitle2, (String)"subtitle");
            return new PlaylistSeed(id2, title, subtitle2);
        }

        public static /* synthetic */ PlaylistSeed copy$default(PlaylistSeed playlistSeed, String string2, String string3, String string4, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = playlistSeed.id;
            }
            if ((n & 2) != 0) {
                string3 = playlistSeed.title;
            }
            if ((n & 4) != 0) {
                string4 = playlistSeed.subtitle;
            }
            return playlistSeed.copy(string2, string3, string4);
        }

        @NotNull
        public String toString() {
            return "PlaylistSeed(id=" + this.id + ", title=" + this.title + ", subtitle=" + this.subtitle + ")";
        }

        public int hashCode() {
            int result2 = this.id.hashCode();
            result2 = result2 * 31 + this.title.hashCode();
            result2 = result2 * 31 + this.subtitle.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaylistSeed)) {
                return false;
            }
            PlaylistSeed playlistSeed = (PlaylistSeed)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)playlistSeed.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)playlistSeed.title)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.subtitle, (Object)playlistSeed.subtitle);
        }
    }
}

