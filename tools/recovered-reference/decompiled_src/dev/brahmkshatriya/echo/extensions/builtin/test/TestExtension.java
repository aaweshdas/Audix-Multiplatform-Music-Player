/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.text.Regex
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuationImpl
 *  kotlinx.coroutines.DelayKt
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.OkHttpClient
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.test;

import dev.brahmkshatriya.echo.common.clients.ArtistClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.FollowClient;
import dev.brahmkshatriya.echo.common.clients.HideClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.clients.LibraryFeedClient;
import dev.brahmkshatriya.echo.common.clients.LikeClient;
import dev.brahmkshatriya.echo.common.clients.LoginClient;
import dev.brahmkshatriya.echo.common.clients.LyricsSearchClient;
import dev.brahmkshatriya.echo.common.clients.RadioClient;
import dev.brahmkshatriya.echo.common.clients.SaveClient;
import dev.brahmkshatriya.echo.common.clients.ShareClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.clients.TrackerMarkClient;
import dev.brahmkshatriya.echo.common.helpers.ContinuationCallback;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.helpers.WebViewClient;
import dev.brahmkshatriya.echo.common.helpers.WebViewRequest;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Lyrics;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.TrackDetails;
import dev.brahmkshatriya.echo.common.models.User;
import dev.brahmkshatriya.echo.common.providers.WebViewClientProvider;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.extensions.builtin.test.TestExtension;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DelayKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 v2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u0010:\u0002vwB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00142\u0006\u0010!\u001a\u00020\"2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\"0$H\u0096@\u00a2\u0006\u0002\u0010%J\u0012\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010,\u001a\u0004\u0018\u00010 H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0096@\u00a2\u0006\u0002\u00103J\u001e\u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u000208H\u0096@\u00a2\u0006\u0002\u00109J\u0010\u0010<\u001a\u00020\u00182\u0006\u0010:\u001a\u00020;H\u0016J\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020605H\u0096@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020?H\u0096@\u00a2\u0006\u0002\u0010AJ\u001c\u0010B\u001a\b\u0012\u0004\u0012\u000208052\u0006\u0010>\u001a\u00020?H\u0096@\u00a2\u0006\u0002\u0010AJ \u0010>\u001a\u00020?2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010DH\u0096@\u00a2\u0006\u0002\u0010FJ\u001c\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u0010G\u001a\u00020HH\u0096@\u00a2\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020H2\u0006\u0010G\u001a\u00020HH\u0096@\u00a2\u0006\u0002\u0010IJ\u001e\u0010L\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\u0006\u0010M\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010NJ\u0016\u0010O\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u001e\u0010R\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010NJ\u0016\u0010T\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u001e\u0010V\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\u0006\u0010W\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010NJ\u0016\u0010X\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u001e\u0010Y\u001a\u0002082\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010ZJ\u0018\u0010[\u001a\u00020\u00182\b\u0010\\\u001a\u0004\u0018\u00010]H\u0096@\u00a2\u0006\u0002\u0010^J \u0010_\u001a\u00020\u00182\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010`\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020c2\u0006\u0010\\\u001a\u00020]H\u0096@\u00a2\u0006\u0002\u0010^J\u0016\u0010d\u001a\u00020\u00182\u0006\u0010\\\u001a\u00020]H\u0096@\u00a2\u0006\u0002\u0010^J\u0016\u0010e\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u0016\u0010f\u001a\u00020c2\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u001e\u0010g\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\u0006\u0010h\u001a\u000202H\u0096@\u00a2\u0006\u0002\u0010NJ\u0016\u0010i\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0096@\u00a2\u0006\u0002\u0010PJ\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020k052\u0006\u0010n\u001a\u00020\"H\u0096@\u00a2\u0006\u0002\u0010oJ$\u0010p\u001a\b\u0012\u0004\u0012\u00020k052\u0006\u0010q\u001a\u00020\"2\u0006\u00107\u001a\u000208H\u0096@\u00a2\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020k2\u0006\u0010j\u001a\u00020kH\u0096@\u00a2\u0006\u0002\u0010tJ\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020605H\u0096@\u00a2\u0006\u0002\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR \u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00140'X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010:\u001a\u00020;X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010\u001e\u00a8\u0006x"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/TestExtension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$CustomInput;", "Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$WebView;", "Ldev/brahmkshatriya/echo/common/clients/HomeFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/FollowClient;", "Ldev/brahmkshatriya/echo/common/clients/RadioClient;", "Ldev/brahmkshatriya/echo/common/providers/WebViewClientProvider;", "Ldev/brahmkshatriya/echo/common/clients/ArtistClient;", "Ldev/brahmkshatriya/echo/common/clients/LyricsSearchClient;", "Ldev/brahmkshatriya/echo/common/clients/LibraryFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/SaveClient;", "Ldev/brahmkshatriya/echo/common/clients/LikeClient;", "Ldev/brahmkshatriya/echo/common/clients/HideClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackerMarkClient;", "Ldev/brahmkshatriya/echo/common/clients/ShareClient;", "<init>", "()V", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "forms", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$Form;", "getForms", "()Ljava/util/List;", "onLogin", "Ldev/brahmkshatriya/echo/common/models/User;", "key", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webViewRequest", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Cookie;", "getWebViewRequest", "()Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Cookie;", "setLoginUser", "user", "getCurrentUser", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "isDownload", "", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webViewClient", "Ldev/brahmkshatriya/echo/common/helpers/WebViewClient;", "setWebViewClient", "loadHomeFeed", "radio", "Ldev/brahmkshatriya/echo/common/models/Radio;", "loadRadio", "(Ldev/brahmkshatriya/echo/common/models/Radio;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTracks", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "context", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "artist", "Ldev/brahmkshatriya/echo/common/models/Artist;", "(Ldev/brahmkshatriya/echo/common/models/Artist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadArtist", "isSaved", "saveToLibrary", "shouldSave", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemSaved", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLiked", "likeItem", "shouldLike", "isItemLiked", "isHidden", "hideItem", "shouldHide", "isItemHidden", "loadTrack", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onTrackChanged", "details", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPlayingStateChanged", "isPlaying", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarkAsPlayedDuration", "", "onMarkAsPlayed", "isFollowing", "getFollowersCount", "followItem", "shouldFollow", "onShare", "lyrics", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "getLyrics", "searchLyrics", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTrackLyrics", "clientId", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLyrics", "(Ldev/brahmkshatriya/echo/common/models/Lyrics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLibraryFeed", "Companion", "Srcs", "app_debug"})
@SourceDebugExtension(value={"SMAP\nTestExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/TestExtension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1563#2:367\n1634#2,3:368\n1563#2:371\n1634#2,3:372\n1563#2:375\n1634#2,3:376\n*S KotlinDebug\n*F\n+ 1 TestExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/TestExtension\n*L\n187#1:367\n187#1:368,3\n344#1:371\n344#1:372,3\n362#1:375\n362#1:376,3\n*E\n"})
public final class TestExtension
implements ExtensionClient,
LoginClient.CustomInput,
TrackClient,
LoginClient.WebView,
HomeFeedClient,
FollowClient,
RadioClient,
WebViewClientProvider,
ArtistClient,
LyricsSearchClient,
LibraryFeedClient,
SaveClient,
LikeClient,
HideClient,
TrackerMarkClient,
ShareClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<LoginClient.Form> forms;
    @NotNull
    private final WebViewRequest.Cookie<List<User>> webViewRequest;
    private WebViewClient webViewClient;
    @NotNull
    private final Radio radio;
    private boolean isSaved;
    private boolean isLiked;
    private boolean isHidden;
    private boolean isFollowing;
    @NotNull
    private final List<Lyrics> lyrics;
    @NotNull
    private static final dev.brahmkshatriya.echo.common.models.Metadata metadata = new dev.brahmkshatriya.echo.common.models.Metadata("TestExtension", "", ImportType.BuiltIn, ExtensionType.MUSIC, "test", "Test Extension", "1.0.0", "Test extension for offline testing", "Test", null, ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://yt3.googleusercontent.com/UMGZZMPQkM3kGtyW4jNE1GtpSrydfNJdbG1UyWTp5zeqUYc6-rton70Imm7B11RulRRuK521NQ=s160-c-k-c0x00ffffff-no-rj", null, false, 3, null), null, null, null, false, 31232, null);
    @NotNull
    public static final String FUN = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4";
    @NotNull
    public static final String BUNNY = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    @NotNull
    public static final String M3U8 = "https://fl3.moveonjoy.com/CNBC/index.m3u8";
    @NotNull
    public static final String SUBTITLE = "https://raw.githubusercontent.com/brenopolanski/html5-video-webvtt-example/master/MIB2-subtitles-pt-BR.vtt";

    public TestExtension() {
        Object[] objectArray = new LoginClient.InputField[]{new LoginClient.InputField(LoginClient.InputField.Type.Username, "name", "Name", true, null, 16, null), new LoginClient.InputField(LoginClient.InputField.Type.Password, "password", "Password", false, null, 16, null), new LoginClient.InputField(LoginClient.InputField.Type.Email, "email", "EMail", false, null, 16, null), new LoginClient.InputField(LoginClient.InputField.Type.Misc, "text", "Text", false, null, 16, null), new LoginClient.InputField(LoginClient.InputField.Type.Number, "number", "Number", false, null, 16, null), new LoginClient.InputField(LoginClient.InputField.Type.Url, "url", "Url", false, null, 16, null)};
        this.forms = CollectionsKt.listOf((Object)new LoginClient.Form("bruh", "Test Form", LoginClient.InputField.Type.Username, CollectionsKt.listOf((Object[])objectArray)));
        this.webViewRequest = new WebViewRequest.Cookie<List<? extends User>>(){
            private final NetworkRequest initialUrl;
            private final Regex stopUrlRegex;
            {
                this.initialUrl = NetworkRequest.Companion.toGetRequest$default(NetworkRequest.Companion, "https://www.example.com/", null, 1, null);
                this.stopUrlRegex = new Regex("https://www\\.iana\\.org/.*");
            }

            public Object onStop(NetworkRequest url, String cookie, Continuation<? super List<User>> $completion) {
                return CollectionsKt.listOf((Object)new User("test_user", "WebView User", ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://picsum.photos/seed/test_user/200", null, false, 3, null), null, null, 24, null));
            }

            public NetworkRequest getInitialUrl() {
                return this.initialUrl;
            }

            public Regex getStopUrlRegex() {
                return this.stopUrlRegex;
            }

            public long getMaxTimeout() {
                return WebViewRequest.Cookie.super.getMaxTimeout();
            }

            public boolean getDontCache() {
                return WebViewRequest.Cookie.super.getDontCache();
            }
        };
        this.radio = new Radio("empty", "empty", null, null, null, null, null, null, false, false, false, false, false, 8188, null);
        objectArray = new Lyrics[3];
        objectArray[0] = new Lyrics("1", "Test Lyrics 1", null, new Lyrics.Simple("First line\nSecond line\nThird line"), null, 20, null);
        Object[] objectArray2 = new Lyrics.Item[]{new Lyrics.Item("First line", 0L, 1000L), new Lyrics.Item("Second line", 1000L, 2000L), new Lyrics.Item("Third line", 2000L, 3000L)};
        objectArray[1] = new Lyrics("2", "Test Lyrics 2", null, new Lyrics.Timed(CollectionsKt.listOf((Object[])objectArray2), false, 2, null), null, 20, null);
        objectArray2 = new List[3];
        Object[] objectArray3 = new Lyrics.Item[]{new Lyrics.Item("First", 0L, 500L), new Lyrics.Item("line", 500L, 1000L)};
        objectArray2[0] = CollectionsKt.listOf((Object[])objectArray3);
        objectArray3 = new Lyrics.Item[]{new Lyrics.Item("Second", 1000L, 1500L), new Lyrics.Item("line", 1500L, 2000L)};
        objectArray2[1] = CollectionsKt.listOf((Object[])objectArray3);
        objectArray3 = new Lyrics.Item[]{new Lyrics.Item("Third", 2000L, 2500L), new Lyrics.Item("line", 2500L, 3000L)};
        objectArray2[2] = CollectionsKt.listOf((Object[])objectArray3);
        objectArray[2] = new Lyrics("3", "Test Lyrics 3", null, new Lyrics.WordByWord(CollectionsKt.listOf((Object[])objectArray2), false, 2, null), null, 20, null);
        this.lyrics = CollectionsKt.listOf((Object[])objectArray);
    }

    @Override
    @Nullable
    public Object getSettingItems(@NotNull Continuation<? super List<? extends Setting>> $completion) {
        return CollectionsKt.emptyList();
    }

    @Override
    public void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
    }

    @Override
    @NotNull
    public List<LoginClient.Form> getForms() {
        return this.forms;
    }

    @Override
    @Nullable
    public Object onLogin(@NotNull String key, @NotNull Map<String, String> data2, @NotNull Continuation<? super List<User>> $completion) {
        return CollectionsKt.listOf((Object)new User(key, key + " User", ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://picsum.photos/seed/" + key + "/200", null, false, 3, null), null, null, 24, null));
    }

    @NotNull
    public WebViewRequest.Cookie<List<User>> getWebViewRequest() {
        return this.webViewRequest;
    }

    @Override
    public void setLoginUser(@Nullable User user) {
    }

    @Override
    @Nullable
    public Object getCurrentUser(@NotNull Continuation<? super User> $completion) {
        return null;
    }

    @Override
    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable streamable, boolean isDownload, @NotNull Continuation<? super Streamable.Media> $completion) {
        if (streamable.getQuality() == 3) {
            throw new Exception("Test exception for quality 3");
        }
        return switch (WhenMappings.$EnumSwitchMapping$1[streamable.getType().ordinal()]) {
            case 1 -> Streamable.Media.Companion.toBackgroundMedia$default(Streamable.Media.Companion, streamable.getId(), null, 1, null);
            case 2 -> {
                Srcs srcs = Srcs.valueOf(streamable.getId());
                Streamable.Media.Server v1 = switch (WhenMappings.$EnumSwitchMapping$0[srcs.ordinal()]) {
                    case 1 -> Streamable.Media.Companion.toServerMedia$default(Streamable.Media.Companion, FUN, null, null, false, 7, null);
                    case 2 -> {
                        Object[] var5_5 = new Streamable.Source.Http[]{Streamable.Source.Companion.toSource$default(Streamable.Source.Companion, BUNNY, null, null, false, false, 15, null), Streamable.Source.Companion.toSource$default(Streamable.Source.Companion, FUN, null, null, false, false, 15, null)};
                        Streamable.Media.Server v2 = new Streamable.Media.Server(CollectionsKt.listOf((Object[])var5_5), false);
                        yield v2;
                    }
                    case 3 -> Streamable.Media.Companion.toServerMedia$default(Streamable.Media.Companion, M3U8, null, Streamable.SourceType.HLS, false, 5, null);
                    default -> throw new NoWhenBranchMatchedException();
                };
                yield v1;
            }
            case 3 -> Streamable.Media.Companion.toSubtitleMedia(streamable.getId(), Streamable.SubtitleType.VTT);
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Track track2, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    @Override
    public void setWebViewClient(@NotNull WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter((Object)webViewClient, (String)"webViewClient");
        this.webViewClient = webViewClient;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object loadHomeFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        void $this$mapTo\2;
        Object[] objectArray = new String[]{"All", "Music", "Podcasts"};
        Iterable iterable = CollectionsKt.listOf((Object[])objectArray);
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        boolean bl2 = false;
        for (Object t : $this$mapTo\2) {
            void it\3;
            String string2 = (String)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(new Tab((String)it\3, (String)it\3, false, null, 12, null));
        }
        Function2 function2 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ TestExtension this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                Tab tab = (Tab)this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void tab2;
                        ResultKt.throwOnFailure((Object)$result);
                        void v0 = tab2;
                        if (Intrinsics.areEqual((Object)(v0 != null ? v0.getId() : null), (Object)"Podcasts")) {
                            throw new Exception("Test exception for Podcasts tab");
                        }
                        return Feed.Companion.toFeedData$default(Feed.Companion, new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>((Tab)tab2, this.this$0, null){
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
                            int I$0;
                            int I$1;
                            int I$2;
                            int I$3;
                            int label;
                            final /* synthetic */ Tab $tab;
                            final /* synthetic */ TestExtension this$0;
                            {
                                this.$tab = $tab;
                                this.this$0 = $receiver;
                                super(1, $completion);
                            }

                            /*
                             * Unable to fully structure code
                             * Could not resolve type clashes
                             */
                            public final Object invokeSuspend(Object $result) {
                                var57_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = this.$tab;
                                        if (Intrinsics.areEqual((Object)(v0 != null ? v0.getId() : null), (Object)"Music")) {
                                            this.label = 1;
                                            v1 = DelayKt.delay((long)5000L, (Continuation)((Continuation)this));
                                            if (v1 == var57_2) {
                                                return var57_2;
                                            }
                                        }
                                        ** GOTO lbl15
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        v1 = $result;
lbl15:
                                        // 2 sources

                                        var2_3 = ContinuationCallback.Companion;
                                        $this$await\1 /* !! */  = new OkHttpClient().newCall(new Request.Builder().url("https://example.com").build());
                                        $i$f$await\1\197 = 0;
                                        $i$f$suspendCancellableCoroutine\2\367 = 0;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                                        this.L$1 = $this$await\1 /* !! */ ;
                                        this.I$0 = $i$f$await\1\197;
                                        this.I$1 = $i$f$suspendCancellableCoroutine\2\367;
                                        this.label = 2;
                                        uCont\2 /* !! */  = (Continuation)this;
                                        $i$a$-suspendCoroutineUninterceptedOrReturn-CancellableContinuationKt$suspendCancellableCoroutine$2\3\368\2 = false;
                                        cancellable\3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted((Continuation)uCont\2 /* !! */ ), 1);
                                        cancellable\3.initCancellability();
                                        continuation\4 = (CancellableContinuation)cancellable\3;
                                        $i$a$-suspendCancellableCoroutine-ContinuationCallback$Companion$await$2\4\376\1 = false;
                                        callback\4 = new ContinuationCallback((Call)$this$await\1 /* !! */ , (CancellableContinuation<? super Response>)continuation\4);
                                        $this$await\1 /* !! */ .enqueue((Callback)callback\4);
                                        continuation\4.invokeOnCancellation((Function1)callback\4);
                                        v2 = cancellable\3.getResult();
                                        if (v2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                            DebugProbesKt.probeCoroutineSuspended((Continuation)((Continuation)this));
                                        }
                                        v3 = v2;
                                        if (v2 == var57_2) {
                                            return var57_2;
                                        }
                                        ** GOTO lbl52
                                    }
                                    case 2: {
                                        $i$f$suspendCancellableCoroutine\2\367 = this.I$1;
                                        $i$f$await\1\197 = this.I$0;
                                        $this$await\1 /* !! */  = (Object[])this.L$1;
                                        this_\1 = (ContinuationCallback.Companion)this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v3 = $result;
lbl52:
                                        // 2 sources

                                        ((Response)v3).body();
                                        var2_3 = new Shelf[8];
                                        v4 = this.$tab;
                                        $this$await\1 /* !! */  = new String[]{"Burhhhhhhh", "brjdksls", "sbajkxclllll", "a", "b", " b"};
                                        $this$await\1 /* !! */  = CollectionsKt.listOf((Object[])$this$await\1 /* !! */ );
                                        var4_6 = this.this$0;
                                        var19_18 = "Bruh " + (v4 != null ? v4.getTitle() : null);
                                        var18_19 = "bruh";
                                        var17_20 = 0;
                                        var16_21 = var2_3;
                                        $i$f$map\5\204 = 0;
                                        uCont\2 /* !! */  = $this$map\5 /* !! */ ;
                                        destination\6 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5 /* !! */ , (int)10));
                                        $i$f$mapTo\6\383 = 0;
                                        var9_13 = $this$mapTo\6.iterator();
lbl68:
                                        // 2 sources

                                        while (var9_13.hasNext()) {
                                            item\6 = var9_13.next();
                                            callback\4 = (String)item\6;
                                            var20_26 = destination\6;
                                            $i$a$-map-TestExtension$loadHomeFeed$3$1$1\7\385\0 = 0;
                                            var13_23 = it\7;
                                            var14_24 = it\7;
                                            this.L$0 = var2_3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$map\5 /* !! */ );
                                            this.L$2 = var4_6;
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\6);
                                            this.L$4 = destination\6;
                                            this.L$5 = var9_13;
                                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)item\6);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)it\7);
                                            this.L$8 = var13_23;
                                            this.L$9 = var14_24;
                                            this.L$10 = var16_21;
                                            this.L$11 = var18_19;
                                            this.L$12 = var19_18;
                                            this.L$13 = var20_26;
                                            this.I$0 = $i$f$map\5\204;
                                            this.I$1 = $i$f$mapTo\6\383;
                                            this.I$2 = $i$a$-map-TestExtension$loadHomeFeed$3$1$1\7\385\0;
                                            this.I$3 = var17_20;
                                            this.label = 3;
                                            v5 = var4_6.loadHomeFeed((Continuation<? super Feed<Shelf>>)this);
                                            if (v5 == var57_2) {
                                                return var57_2;
                                            }
                                            ** GOTO lbl120
                                        }
                                        break;
                                    }
                                    case 3: {
                                        var17_20 = this.I$3;
                                        $i$a$-map-TestExtension$loadHomeFeed$3$1$1\7\385\0 = this.I$2;
                                        $i$f$mapTo\6\383 = this.I$1;
                                        $i$f$map\5\204 = this.I$0;
                                        var20_26 = (Collection)this.L$13;
                                        var19_18 = (String)this.L$12;
                                        var18_19 = (String)this.L$11;
                                        var16_21 = (Shelf[])this.L$10;
                                        var14_24 = (String)this.L$9;
                                        var13_23 = (String)this.L$8;
                                        it\7 = (String)this.L$7;
                                        item\6 = this.L$6;
                                        var9_13 = (Iterator<T>)this.L$5;
                                        destination\6 = (Collection)this.L$4;
                                        $this$mapTo\6 = (Iterable)this.L$3;
                                        var4_6 = (TestExtension)this.L$2;
                                        $this$map\5 /* !! */  = (Object[])this.L$1;
                                        var2_3 = (Shelf[])this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v5 = $result;
lbl120:
                                        // 2 sources

                                        var15_25 = v5;
                                        var21_27 = null;
                                        var22_28 = 120;
                                        var23_29 = null;
                                        var24_30 = null;
                                        var25_31 = null;
                                        var26_32 = null;
                                        var27_33 = (Feed)var15_25;
                                        var28_34 = var13_23;
                                        var29_35 = var14_24;
                                        var20_26.add(new Shelf.Category(var29_35, var28_34, var27_33, var26_32, var25_31, var24_30, var23_29, var22_28, var21_27));
                                        ** GOTO lbl68
                                    }
                                }
                                var20_26 = (List)destination\6;
                                var30_36 = null;
                                var31_37 = 120;
                                var32_38 = null;
                                var33_39 = null;
                                var34_40 = null;
                                var35_41 = null;
                                var36_42 = var20_26;
                                var37_43 = var19_18;
                                var38_44 = var18_19;
                                var16_21[var17_20] = new Shelf.Lists.Categories(var38_44, (String)var37_43, (List)var36_42, var35_41, var34_40, var33_39, var32_38, var31_37, var30_36);
                                v6 = this.$tab;
                                $this$map\5 /* !! */  = new String[]{"Burhhhhhhh", "brjdksls", "sbajkxclllll", "a", "b", " b"};
                                $this$map\5 /* !! */  = CollectionsKt.listOf((Object[])$this$map\5 /* !! */ );
                                var4_6 = this.this$0;
                                var19_18 = "Bruh " + (v6 != null ? v6.getTitle() : null);
                                var18_19 = "bruh";
                                var17_20 = 1;
                                var16_21 = var2_3;
                                $i$f$map\8\211 = 0;
                                $this$mapTo\6 = $this$map\8;
                                destination\9 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                                $i$f$mapTo\9\387 = 0;
                                var9_13 = $this$mapTo\9.iterator();
lbl157:
                                // 2 sources

                                while (var9_13.hasNext()) {
                                    item\9 = var9_13.next();
                                    it\7 = (String)item\9;
                                    var20_26 = destination\9;
                                    $i$a$-map-TestExtension$loadHomeFeed$3$1$2\10\389\0 = 0;
                                    var13_23 = it\10;
                                    var14_24 = it\10;
                                    this.L$0 = var2_3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$map\8);
                                    this.L$2 = var4_6;
                                    this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\9);
                                    this.L$4 = destination\9;
                                    this.L$5 = var9_13;
                                    this.L$6 = SpillingKt.nullOutSpilledVariable((Object)item\9);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable((Object)it\10);
                                    this.L$8 = var13_23;
                                    this.L$9 = var14_24;
                                    this.L$10 = var16_21;
                                    this.L$11 = var18_19;
                                    this.L$12 = var19_18;
                                    this.L$13 = var20_26;
                                    this.I$0 = $i$f$map\8\211;
                                    this.I$1 = $i$f$mapTo\9\387;
                                    this.I$2 = $i$a$-map-TestExtension$loadHomeFeed$3$1$2\10\389\0;
                                    this.I$3 = var17_20;
                                    this.label = 4;
                                    v7 = var4_6.loadHomeFeed((Continuation<? super Feed<Shelf>>)this);
                                    if (v7 == var57_2) {
                                        return var57_2;
                                    }
                                    ** GOTO lbl209
                                }
                                {
                                    break;
                                    case 4: {
                                        var17_20 = this.I$3;
                                        $i$a$-map-TestExtension$loadHomeFeed$3$1$2\10\389\0 = this.I$2;
                                        $i$f$mapTo\9\387 = this.I$1;
                                        $i$f$map\8\211 = this.I$0;
                                        var20_26 = (Collection)this.L$13;
                                        var19_18 = (String)this.L$12;
                                        var18_19 = (String)this.L$11;
                                        var16_21 = (Shelf[])this.L$10;
                                        var14_24 = (String)this.L$9;
                                        var13_23 = (String)this.L$8;
                                        it\10 = (String)this.L$7;
                                        item\9 = this.L$6;
                                        var9_13 = (Iterator)this.L$5;
                                        destination\9 = (Collection)this.L$4;
                                        $this$mapTo\9 = (Iterable)this.L$3;
                                        var4_6 = (TestExtension)this.L$2;
                                        $this$map\8 = (Iterable)this.L$1;
                                        var2_3 = (Shelf[])this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v7 = $result;
lbl209:
                                        // 2 sources

                                        var15_25 = v7;
                                        var39_45 = null;
                                        var40_46 = 120;
                                        var41_47 = null;
                                        var42_48 = null;
                                        var43_49 = null;
                                        var44_50 = null;
                                        var45_51 = (Feed)var15_25;
                                        var46_52 = var13_23;
                                        var47_53 = var14_24;
                                        var20_26.add(new Shelf.Category(var47_53, var46_52, var45_51, var44_50, var43_49, var42_48, var41_47, var40_46, var39_45));
                                        ** GOTO lbl157
                                    }
                                }
                                var20_26 = (List)destination\9;
                                var48_54 = null;
                                var49_55 = 104;
                                var50_56 = null;
                                var51_57 = null;
                                var52_58 = Shelf.Lists.Type.Grid;
                                var53_59 = null;
                                var54_60 = var20_26;
                                var55_61 = var19_18;
                                var56_62 = var18_19;
                                var16_21[var17_20] = new Shelf.Lists.Categories(var56_62, (String)var55_61, (List)var54_60, var53_59, var52_58, var51_57, var50_56, var49_55, var48_54);
                                var2_3[2] = new Artist("bruh", "Bruh", ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://www.easygifanimator.net/images/samples/video-to-gif-sample.gif", null, false, 3, null), null, null, null, null, null, false, false, false, false, false, false, 16376, null).toShelf();
                                var2_3[3] = new Track("not", "Not Playable", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, Track.Playable.Unreleased.INSTANCE, null, false, false, false, false, false, false, 0xFEFFFFC, null).toShelf();
                                var3_4 = new Streamable[]{Streamable.Companion.server$default(Streamable.Companion, "Single", 0, null, null, 12, null), Streamable.Companion.server$default(Streamable.Companion, "Merged", 0, null, null, 12, null), Streamable.Companion.server$default(Streamable.Companion, "M3U8", 0, null, null, 12, null), Streamable.Companion.subtitle$default(Streamable.Companion, "https://raw.githubusercontent.com/brenopolanski/html5-video-webvtt-example/master/MIB2-subtitles-pt-BR.vtt", null, null, 6, null)};
                                var2_3[4] = dev.brahmkshatriya.echo.extensions.builtin.test.TestExtension$Companion.access$createTrack(TestExtension.Companion, "all", "All", CollectionsKt.listOf((Object[])var3_4));
                                var2_3[5] = Srcs.Single.createTrack();
                                var2_3[6] = Srcs.Merged.createTrack();
                                var2_3[7] = Srcs.M3U8.createTrack();
                                return CollectionsKt.listOf((Object[])var2_3);
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Continuation<?> $completion) {
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(Continuation<? super List<? extends Shelf>> p1) {
                                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                            }
                        }), null, (ImageHolder)ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://picsum.photos/id/21/400/300", null, false, 3, null), 1, null);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(Tab p1, Continuation<? super Feed.Data<Shelf>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
        List list2 = (List)collection;
        return new Feed(list2, function2);
    }

    @Override
    @Nullable
    public Object loadRadio(@NotNull Radio radio2, @NotNull Continuation<? super Radio> $completion) {
        return radio2;
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Radio radio2, @NotNull Continuation<? super Feed<Track>> $completion) {
        return Feed.Companion.toFeed$default(Feed.Companion, CollectionsKt.listOf((Object)new Track("", "Bruh", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, false, false, false, false, false, false, 0xFFFFFFC, null)), null, null, 3, null);
    }

    @Override
    @Nullable
    public Object radio(@NotNull EchoMediaItem item2, @Nullable EchoMediaItem context, @NotNull Continuation<? super Radio> $completion) {
        return this.radio;
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Artist artist, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(artist, null){
            int label;
            final /* synthetic */ Artist $artist;
            {
                this.$artist = $artist;
                super(1, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object[] objectArray = new Shelf.Item[]{Srcs.Single.createTrack(), this.$artist.toShelf()};
                        return CollectionsKt.listOf((Object[])objectArray);
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
        }), null, null, 3, null);
    }

    @Override
    @Nullable
    public Object loadArtist(@NotNull Artist artist, @NotNull Continuation<? super Artist> $completion) {
        return artist;
    }

    @Override
    @Nullable
    public Object saveToLibrary(@NotNull EchoMediaItem item2, boolean shouldSave, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)item2.getExtras().get("loaded"));
        this.isSaved = shouldSave;
        System.out.println((Object)("save " + shouldSave));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object isItemSaved(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        System.out.println((Object)item2.getExtras().get("loaded"));
        System.out.println((Object)("isSaved : " + this.isSaved));
        return Boxing.boxBoolean((boolean)this.isSaved);
    }

    @Override
    @Nullable
    public Object likeItem(@NotNull EchoMediaItem item2, boolean shouldLike, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)item2.getExtras().get("loaded"));
        this.isLiked = shouldLike;
        System.out.println((Object)("like " + shouldLike));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object isItemLiked(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        System.out.println((Object)item2.getExtras().get("loaded"));
        System.out.println((Object)("isLiked : " + this.isLiked));
        return Boxing.boxBoolean((boolean)this.isLiked);
    }

    @Override
    @Nullable
    public Object hideItem(@NotNull EchoMediaItem item2, boolean shouldHide, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)"hide");
        this.isHidden = shouldHide;
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object isItemHidden(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        System.out.println((Object)("isHidden : " + this.isHidden));
        return Boxing.boxBoolean((boolean)this.isHidden);
    }

    @Override
    @Nullable
    public Object loadTrack(@NotNull Track track2, boolean isDownload, @NotNull Continuation<? super Track> $completion) {
        return Track.copy$default(track2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, MapsKt.mapOf((Pair)TuplesKt.to((Object)"loaded", (Object)"Loaded bro")), null, null, false, false, false, false, false, false, 0xFF7FFFF, null);
    }

    @Override
    @Nullable
    public Object onTrackChanged(@Nullable TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)("onTrackChanged : " + details));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onPlayingStateChanged(@Nullable TrackDetails details, boolean isPlaying2, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)("onPlayingStateChanged " + isPlaying2 + " : " + details));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object getMarkAsPlayedDuration(@NotNull TrackDetails details, @NotNull Continuation<? super Long> $completion) {
        return Boxing.boxLong((long)10000L);
    }

    @Override
    @Nullable
    public Object onMarkAsPlayed(@NotNull TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)("onMarkAsPlayed : " + details));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object isFollowing(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        return Boxing.boxBoolean((boolean)this.isFollowing);
    }

    @Override
    @Nullable
    public Object getFollowersCount(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Long> $completion) {
        return Boxing.boxLong((long)1000L);
    }

    @Override
    @Nullable
    public Object followItem(@NotNull EchoMediaItem item2, boolean shouldFollow, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)("followItem: " + item2 + ", follow: " + shouldFollow));
        this.isFollowing = shouldFollow;
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onShare(@NotNull EchoMediaItem item2, @NotNull Continuation<? super String> $completion) {
        return "https://example.com/" + item2.getId();
    }

    @NotNull
    public final List<Lyrics> getLyrics() {
        return this.lyrics;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object searchLyrics(@NotNull String query, @NotNull Continuation<? super Feed<Lyrics>> $completion) {
        void $this$mapTo\2;
        Object[] objectArray = new String[]{"Simple", "Timed", "WordByWord", "All"};
        Iterable iterable = CollectionsKt.listOf((Object[])objectArray);
        boolean bl = false;
        Iterable iterable2 = iterable;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
        boolean bl2 = false;
        for (Object t : $this$mapTo\2) {
            void it\3;
            String string2 = (String)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(new Tab((String)it\3, (String)it\3, false, null, 12, null));
        }
        Function2 function2 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Lyrics>>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ TestExtension this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (Tab)this.L$0;
                var14_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.L$0 = tab;
                        this.label = 1;
                        v0 = DelayKt.delay((long)3000L, (Continuation)((Continuation)this));
                        if (v0 == var14_3) {
                            return var14_3;
                        }
                        ** GOTO lbl15
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl15:
                        // 2 sources

                        v1 = tab;
                        v2 = var4_4 = v1 != null ? v1.getId() : null;
                        if (var4_4 == null) ** GOTO lbl73
                        switch (var4_4.hashCode()) {
                            case -1303845941: {
                                if (!var4_4.equals("WordByWord")) {
                                    ** break;
                                }
                                ** GOTO lbl58
                            }
                            case 80811799: {
                                if (var4_4.equals("Timed")) break;
                                ** break;
                            }
                            case -1818419758: {
                                if (!var4_4.equals("Simple")) ** break;
                                $this$filter\1 = this.this$0.getLyrics();
                                $i$f$filter\1\348 = false;
                                var7_7 = $this$filter\1;
                                destination\2 = new ArrayList<E>();
                                $i$f$filterTo\2\367 = false;
                                for (T element\2 : $this$filterTo\2) {
                                    it\3 = (Lyrics)element\2;
                                    $i$a$-filter-TestExtension$searchLyrics$3$burh$1\3\368\0 = false;
                                    if (!(it\3.getLyrics() instanceof Lyrics.Simple)) continue;
                                    destination\2.add(element\2);
                                }
                                v3 = (List)destination\2;
                                ** GOTO lbl74
                            }
                        }
                        $this$filter\4 = this.this$0.getLyrics();
                        $i$f$filter\4\349 = false;
                        $this$filterTo\2 = $this$filter\4;
                        destination\5 = new ArrayList<E>();
                        $i$f$filterTo\5\370 = false;
                        for (T element\5 : $this$filterTo\5) {
                            it\6 = (Lyrics)element\5;
                            $i$a$-filter-TestExtension$searchLyrics$3$burh$2\6\371\0 = false;
                            if (!(it\6.getLyrics() instanceof Lyrics.Timed)) continue;
                            destination\5.add(element\5);
                        }
                        v3 = (List)destination\5;
                        ** GOTO lbl74
lbl58:
                        // 1 sources

                        $this$filter\7 = this.this$0.getLyrics();
                        $i$f$filter\7\350 = false;
                        $this$filterTo\5 = $this$filter\7;
                        destination\8 = new ArrayList<E>();
                        $i$f$filterTo\8\373 = false;
                        for (T element\8 : $this$filterTo\8) {
                            it\9 = (Lyrics)element\8;
                            $i$a$-filter-TestExtension$searchLyrics$3$burh$3\9\374\0 = false;
                            if (!(it\9.getLyrics() instanceof Lyrics.WordByWord)) continue;
                            destination\8.add(element\8);
                        }
                        v3 = (List)destination\8;
                        ** GOTO lbl74
lbl73:
                        // 5 sources

                        v3 = this.this$0.getLyrics();
lbl74:
                        // 4 sources

                        burh = v3;
                        return Feed.Companion.toFeedData$default(Feed.Companion, burh, null, null, 3, null);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(Tab p1, Continuation<? super Feed.Data<Lyrics>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
        List list2 = (List)collection;
        return new Feed(list2, function2);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object searchTrackLyrics(@NotNull String clientId, @NotNull Track track, @NotNull Continuation<? super Feed<Lyrics>> $completion) {
        if (!($completion instanceof searchTrackLyrics.1)) ** GOTO lbl-1000
        var7_4 = $completion;
        if ((var7_4.label & -2147483648) != 0) {
            var7_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ TestExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.searchTrackLyrics(null, null, (Continuation<? super Feed<Lyrics>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var8_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$searchTrackLyrics_u24lambda_u242\1 = this;
                $i$a$-run-TestExtension$searchTrackLyrics$2\1\356\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)clientId);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)track);
                $continuation.L$2 = $this$searchTrackLyrics_u24lambda_u242\1;
                $continuation.I$0 = $i$a$-run-TestExtension$searchTrackLyrics$2\1\356\0;
                $continuation.label = 1;
                v0 = DelayKt.delay((long)5000L, (Continuation)$continuation);
                if (v0 == var8_6) {
                    return var8_6;
                }
                ** GOTO lbl31
            }
            case 1: {
                $i$a$-run-TestExtension$searchTrackLyrics$2\1\356\0 = $continuation.I$0;
                $this$searchTrackLyrics_u24lambda_u242\1 = (TestExtension)$continuation.L$2;
                track = (Track)$continuation.L$1;
                clientId = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 2 sources

                return Feed.Companion.toFeed$default(Feed.Companion, $this$searchTrackLyrics_u24lambda_u242\1.lyrics, null, null, 3, null);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object loadLyrics(@NotNull Lyrics lyrics, @NotNull Continuation<? super Lyrics> $completion) {
        return lyrics;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object loadLibraryFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        void $this$mapTo\2;
        void $this$map\1;
        Iterable iterable = (Iterable)new IntRange(0, 10);
        Feed.Companion companion = Feed.Companion;
        boolean bl = false;
        void var4_5 = $this$map\1;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
        boolean bl2 = false;
        Iterator iterator = $this$mapTo\2.iterator();
        while (iterator.hasNext()) {
            void it\3;
            int n;
            int n2 = n = ((IntIterator)iterator).nextInt();
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(TestExtension.Companion.createTrack("lib_" + (int)it\3, "Library Track " + (int)it\3, CollectionsKt.listOf((Object)Streamable.Companion.server$default(Streamable.Companion, "Single", 0, null, null, 12, null))));
        }
        return Feed.Companion.toFeed$default(companion, (List)collection, new Feed.Buttons(false, false, true, null, 11, null), null, 2, null);
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

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/TestExtension$Companion;", "", "<init>", "()V", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "FUN", "", "BUNNY", "M3U8", "SUBTITLE", "createTrack", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "id", "title", "streamables", "", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final dev.brahmkshatriya.echo.common.models.Metadata getMetadata() {
            return metadata;
        }

        private final Shelf.Item createTrack(String id2, String title, List<Streamable> streamables) {
            return new Track(id2, title, null, ImageHolder.Companion.toImageHolder$default(ImageHolder.Companion, "https://picsum.photos/seed/" + id2 + "/300", null, false, 3, null), null, null, null, null, null, null, null, null, null, null, null, null, null, Random.Default.nextBoolean(), null, null, null, streamables, false, false, false, false, false, false, 0xFDDFFF4, null).toShelf();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/TestExtension$Srcs;", "", "<init>", "(Ljava/lang/String;I)V", "Single", "Merged", "M3U8", "createTrack", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nTestExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/TestExtension$Srcs\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1563#2:367\n1634#2,3:368\n*S KotlinDebug\n*F\n+ 1 TestExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/TestExtension$Srcs\n*L\n175#1:367\n175#1:368,3\n*E\n"})
    public static final class Srcs
    extends Enum<Srcs> {
        public static final /* enum */ Srcs Single = new Srcs();
        public static final /* enum */ Srcs Merged = new Srcs();
        public static final /* enum */ Srcs M3U8 = new Srcs();
        private static final /* synthetic */ Srcs[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Shelf.Item createTrack() {
            Collection<Streamable> collection;
            void $this$mapTo\2;
            void $this$map\1;
            Iterable iterable = (Iterable)new IntRange(0, 5);
            Collection collection2 = CollectionsKt.listOf((Object)Streamable.Companion.subtitle$default(Streamable.Companion, TestExtension.SUBTITLE, null, null, 6, null));
            String string2 = this.name();
            String string3 = this.name();
            Companion companion = Companion;
            boolean bl = false;
            void var3_7 = $this$map\1;
            Collection collection3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
            boolean bl2 = false;
            Iterator iterator = $this$mapTo\2.iterator();
            while (iterator.hasNext()) {
                void i\3;
                int n;
                int n2 = n = ((IntIterator)iterator).nextInt();
                collection = collection3;
                boolean bl3 = false;
                collection.add(Streamable.Companion.server$default(Streamable.Companion, this.name(), (int)i\3, null, null, 12, null));
            }
            collection = (List)collection3;
            return companion.createTrack(string3, string2, CollectionsKt.plus((Collection)collection2, (Iterable)collection));
        }

        public static Srcs[] values() {
            return (Srcs[])$VALUES.clone();
        }

        public static Srcs valueOf(String value2) {
            return Enum.valueOf(Srcs.class, value2);
        }

        @NotNull
        public static EnumEntries<Srcs> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = srcsArray = new Srcs[]{Srcs.Single, Srcs.Merged, Srcs.M3U8};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[Srcs.values().length];
            try {
                nArray[Srcs.Single.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Srcs.Merged.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Srcs.M3U8.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[Streamable.MediaType.values().length];
            try {
                nArray[Streamable.MediaType.Background.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Streamable.MediaType.Server.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Streamable.MediaType.Subtitle.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

