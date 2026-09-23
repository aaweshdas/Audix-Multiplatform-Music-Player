/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  androidx.annotation.OptIn
 *  androidx.media3.common.util.UnstableApi
 *  dev.brahmkshatriya.echo.R$drawable
 *  dev.brahmkshatriya.echo.R$string
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.sync.Mutex
 *  kotlinx.coroutines.sync.MutexKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.offline;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.OptIn;
import androidx.media3.common.util.UnstableApi;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.clients.AlbumClient;
import dev.brahmkshatriya.echo.common.clients.ArtistClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.clients.LibraryFeedClient;
import dev.brahmkshatriya.echo.common.clients.LikeClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistEditorListenerClient;
import dev.brahmkshatriya.echo.common.clients.RadioClient;
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient;
import dev.brahmkshatriya.echo.common.clients.SettingsChangeListenerClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.SettingMultipleChoice;
import dev.brahmkshatriya.echo.common.settings.SettingSlider;
import dev.brahmkshatriya.echo.common.settings.SettingSwitch;
import dev.brahmkshatriya.echo.common.settings.SettingTextInput;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.builtin.offline.ConvertorsKt;
import dev.brahmkshatriya.echo.extensions.builtin.offline.MediaStoreUtils;
import dev.brahmkshatriya.echo.extensions.builtin.offline.OfflineExtension;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0001|B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010%\u001a\u00020$H\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001d\u001a\u00020\u0012H\u0082@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0082@\u00a2\u0006\u0002\u0010*J\u0018\u0010&\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0082@\u00a2\u0006\u0002\u0010.J\u0018\u0010&\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H\u0082@\u00a2\u0006\u0002\u00102J$\u00103\u001a\b\u0012\u0004\u0012\u00020504*\b\u0012\u0004\u0012\u0002060\u00192\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0002J\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020504H\u0096@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010=\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010CJ\u001e\u0010D\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0006\u0010<\u001a\u00020;H\u0096@\u00a2\u0006\u0002\u0010EJ\u0016\u0010F\u001a\u00020-2\u0006\u0010,\u001a\u00020-H\u0096@\u00a2\u0006\u0002\u0010.J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020;042\u0006\u0010,\u001a\u00020-H\u0096@\u00a2\u0006\u0002\u0010.J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010,\u001a\u00020-H\u0096@\u00a2\u0006\u0002\u0010.J6\u0010H\u001a\b\u0012\u0004\u0012\u000205042\f\u0010I\u001a\b\u0012\u0004\u0012\u00020)0\u00192\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u001e0KH\u0082@\u00a2\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020)2\u0006\u0010(\u001a\u00020)H\u0096@\u00a2\u0006\u0002\u0010*J\u001c\u0010D\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010(\u001a\u00020)H\u0096@\u00a2\u0006\u0002\u0010*J\u0016\u0010N\u001a\u0002012\u0006\u00100\u001a\u000201H\u0096@\u00a2\u0006\u0002\u00102J\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020;042\u0006\u00100\u001a\u000201H\u0096@\u00a2\u0006\u0002\u00102J\u001e\u0010D\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001042\u0006\u00100\u001a\u000201H\u0096@\u00a2\u0006\u0002\u00102J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020PH\u0096@\u00a2\u0006\u0002\u0010RJ\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020;042\u0006\u0010Q\u001a\u00020PH\u0096@\u00a2\u0006\u0002\u0010RJ \u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u0002062\b\u0010\r\u001a\u0004\u0018\u000106H\u0096@\u00a2\u0006\u0002\u0010TJ\u0018\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0019*\b\u0012\u0004\u0012\u0002060\u0019H\u0002J$\u0010W\u001a\b\u0012\u0004\u0012\u0002050X*\b\u0012\u0004\u0012\u0002050\u00192\n\b\u0002\u00107\u001a\u0004\u0018\u000108H\u0002J$\u0010Y\u001a\b\u0012\u0004\u0012\u0002050X*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u0019\u0012\u0004\u0012\u00020\u001e0ZH\u0002J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u000205042\u0006\u0010\\\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010]J\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020504H\u0096@\u00a2\u0006\u0002\u0010\u001bJ*\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u001e0Z0\u00192\b\u0010<\u001a\u0004\u0018\u00010;H\u0096@\u00a2\u0006\u0002\u0010EJ\u001e\u0010`\u001a\u00020\u00122\u0006\u0010S\u001a\u0002062\u0006\u0010a\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010bJ\u0016\u0010c\u001a\u00020\u001e2\u0006\u0010S\u001a\u000206H\u0096@\u00a2\u0006\u0002\u0010dJ \u0010e\u001a\u0002012\u0006\u0010f\u001a\u00020\u00162\b\u0010g\u001a\u0004\u0018\u00010\u0016H\u0096@\u00a2\u0006\u0002\u0010hJ\u0016\u0010i\u001a\u00020\u00122\u0006\u00100\u001a\u000201H\u0096@\u00a2\u0006\u0002\u00102J(\u0010j\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\u0006\u0010f\u001a\u00020\u00162\b\u0010g\u001a\u0004\u0018\u00010\u0016H\u0096@\u00a2\u0006\u0002\u0010kJ:\u0010l\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0\u00192\u0006\u0010n\u001a\u00020o2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020;0\u0019H\u0096@\u00a2\u0006\u0002\u0010qJ2\u0010r\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0\u00192\f\u0010s\u001a\b\u0012\u0004\u0012\u00020o0\u0019H\u0096@\u00a2\u0006\u0002\u0010tJ4\u0010u\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0\u00192\u0006\u0010v\u001a\u00020o2\u0006\u0010w\u001a\u00020oH\u0096@\u00a2\u0006\u0002\u0010xJ$\u0010y\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0\u0019H\u0096@\u00a2\u0006\u0002\u0010zJ$\u0010{\u001a\u00020\u00122\u0006\u00100\u001a\u0002012\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0\u0019H\u0096@\u00a2\u0006\u0002\u0010zR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006}"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/OfflineExtension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/clients/HomeFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "Ldev/brahmkshatriya/echo/common/clients/AlbumClient;", "Ldev/brahmkshatriya/echo/common/clients/ArtistClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistClient;", "Ldev/brahmkshatriya/echo/common/clients/RadioClient;", "Ldev/brahmkshatriya/echo/common/clients/LibraryFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/LikeClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistEditorListenerClient;", "Ldev/brahmkshatriya/echo/common/clients/SearchFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/SettingsChangeListenerClient;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onSettingsChanged", "", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "key", "", "(Ldev/brahmkshatriya/echo/common/settings/Settings;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "refreshLibrary", "", "getRefreshLibrary", "()Z", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "_library", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$LibraryStoreClass;", "getLibrary", "find", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MArtist;", "artist", "Ldev/brahmkshatriya/echo/common/models/Artist;", "(Ldev/brahmkshatriya/echo/common/models/Artist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MAlbum;", "album", "Ldev/brahmkshatriya/echo/common/models/Album;", "(Ldev/brahmkshatriya/echo/common/models/Album;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ldev/brahmkshatriya/echo/extensions/builtin/offline/MediaStoreUtils$MPlaylist;", "playlist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toShelves", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "buttons", "Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "loadHomeFeed", "loadTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "track", "isDownload", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeed", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAlbum", "loadTracks", "getArtistsWithCategories", "artists", "filter", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadArtist", "loadPlaylist", "loadRadio", "Ldev/brahmkshatriya/echo/common/models/Radio;", "radio", "(Ldev/brahmkshatriya/echo/common/models/Radio;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "item", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sorted", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "toPair", "Ldev/brahmkshatriya/echo/common/models/Feed$Data;", "toFeed", "Lkotlin/Pair;", "loadSearchFeed", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLibraryFeed", "listEditablePlaylists", "likeItem", "shouldLike", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemLiked", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPlaylist", "title", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "editPlaylistMetadata", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTracksToPlaylist", "tracks", "index", "", "new", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTracksFromPlaylist", "indexes", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTrackInPlaylist", "fromIndex", "toIndex", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onEnterPlaylistEditor", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onExitPlaylistEditor", "Companion", "app_debug"})
@OptIn(markerClass={UnstableApi.class})
@SourceDebugExtension(value={"SMAP\nOfflineExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OfflineExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/OfflineExtension\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 6 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,485:1\n116#2,11:486\n1#3:497\n1563#4:498\n1634#4,3:499\n1563#4:502\n1634#4,2:503\n774#4:505\n865#4,2:506\n1563#4:508\n1634#4,3:509\n1636#4:512\n1563#4:513\n1634#4,3:514\n1563#4:517\n1634#4,3:518\n1056#4:523\n1563#4:524\n1634#4,3:525\n1563#4:528\n1634#4,3:529\n1563#4:532\n1634#4,3:533\n1563#4:536\n1634#4,2:537\n1761#4,3:539\n1636#4:542\n346#4,8:543\n1869#4,2:551\n1869#4,2:553\n19#5:521\n205#6:522\n*S KotlinDebug\n*F\n+ 1 OfflineExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/offline/OfflineExtension\n*L\n136#1:486,11\n155#1:498\n155#1:499,3\n220#1:502\n220#1:503,2\n222#1:505\n222#1:506,2\n224#1:508\n224#1:509,3\n220#1:512\n241#1:513\n241#1:514,3\n254#1:517\n254#1:518,3\n336#1:523\n336#1:524\n336#1:525,3\n346#1:528\n346#1:529,3\n406#1:532\n406#1:533,3\n421#1:536\n421#1:537,2\n422#1:539,3\n421#1:542\n432#1:543,8\n461#1:551,2\n469#1:553,2\n331#1:521\n331#1:522\n*E\n"})
public final class OfflineExtension
implements ExtensionClient,
HomeFeedClient,
TrackClient,
AlbumClient,
ArtistClient,
PlaylistClient,
RadioClient,
LibraryFeedClient,
LikeClient,
PlaylistEditorListenerClient,
SearchFeedClient,
SettingsChangeListenerClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Context context;
    @NotNull
    private final Settings settings;
    @NotNull
    private final Mutex mutex;
    @Nullable
    private MediaStoreUtils.LibraryStoreClass _library;
    @NotNull
    private static final dev.brahmkshatriya.echo.common.models.Metadata metadata;

    public OfflineExtension(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.context = context;
        this.settings = ExtensionUtils.INSTANCE.getSettings(this.context, metadata);
        this.mutex = MutexKt.Mutex$default((boolean)false, (int)1, null);
    }

    @Override
    @Nullable
    public Object onSettingsChanged(@NotNull Settings settings, @Nullable String key, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.refreshLibrary($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object getSettingItems(@NotNull Continuation<? super List<? extends Setting>> $completion) {
        if (!($completion instanceof getSettingItems.1)) ** GOTO lbl-1000
        var5_2 = $completion;
        if ((var5_2.label & -2147483648) != 0) {
            var5_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getSettingItems((Continuation<? super List<? extends Setting>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var6_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var6_4) {
                    return var6_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                folders = ((MediaStoreUtils.LibraryStoreClass)v0).getFolders();
                var3_6 = new Setting[5];
                v1 = this.context.getString(R.string.refresh_library_on_reload);
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getString(...)");
                var3_6[0] = new SettingSwitch(v1, "refresh_library", this.context.getString(R.string.refresh_library_on_reload_summary), false);
                v2 = this.context.getString(R.string.duration_filter);
                Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getString(...)");
                var3_6[1] = new SettingSlider(v2, "limit_value", this.context.getString(R.string.duration_filter_summary), Boxing.boxInt((int)10), 0, 120, Boxing.boxInt((int)10), false, 128, null);
                v3 = this.context.getString(R.string.blacklist_folders);
                Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getString(...)");
                var3_6[2] = new SettingMultipleChoice(v3, "blacklist_folders", this.context.getString(R.string.blacklist_folders_summary), CollectionsKt.toList((Iterable)folders), CollectionsKt.toList((Iterable)folders), null, 32, null);
                v4 = this.context.getString(R.string.blacklist_folder_keywords);
                Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getString(...)");
                var3_6[3] = new SettingTextInput(v4, "blacklist_keywords", this.context.getString(R.string.blacklist_folder_keywords_summary), null, 8, null);
                v5 = this.context.getString(R.string.artist_exclusions);
                Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"getString(...)");
                var3_6[4] = new SettingTextInput(v5, "artist_exclusions", this.context.getString(R.string.artist_exclusions_summary), null, 8, null);
                return CollectionsKt.listOf((Object[])var3_6);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    public void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
    }

    private final boolean getRefreshLibrary() {
        Boolean bl = this.settings.getBoolean("refresh_library");
        return bl != null ? bl : true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    private final Object getLibrary(Continuation<? super MediaStoreUtils.LibraryStoreClass> $completion) {
        if (!($completion instanceof getLibrary.1)) ** GOTO lbl-1000
        var9_2 = $completion;
        if ((var9_2.label & -2147483648) != 0) {
            var9_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$withLock_u24default\1 = this.mutex;
                owner\1 = null;
                $i$f$withLock\1\136 = 0;
                $continuation.L$0 = $this$withLock_u24default\1;
                $continuation.I$0 = $i$f$withLock\1\136;
                $continuation.label = 1;
                v0 = $this$withLock_u24default\1.lock(owner\1, (Continuation)$continuation);
                if (v0 == var10_4) {
                    return var10_4;
                }
                ** GOTO lbl29
            }
            case 1: {
                $i$f$withLock\1\136 = $continuation.I$0;
                owner\1 = null;
                $this$withLock_u24default\1 = (Mutex)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl29:
                // 3 sources

                $i$a$-withLock$default-OfflineExtension$getLibrary$2\2\493\0 = 0;
                if (this._library != null) ** GOTO lbl53
                var6_12 = this;
                $continuation.L$0 = $this$withLock_u24default\1;
                $continuation.L$1 = var6_12;
                $continuation.I$0 = $i$f$withLock\1\136;
                $continuation.I$1 = $i$a$-withLock$default-OfflineExtension$getLibrary$2\2\493\0;
                $continuation.label = 2;
                v1 = MediaStoreUtils.INSTANCE.getAllSongs(this.context, this.settings, (Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                ** if (v1 != var10_4) goto lbl41
lbl40:
                // 1 sources

                return var10_4;
lbl41:
                // 1 sources

                ** GOTO lbl52
            }
            case 2: {
                $i$a$-withLock$default-OfflineExtension$getLibrary$2\2\493\0 = $continuation.I$1;
                $i$f$withLock\1\136 = $continuation.I$0;
                var6_12 = (OfflineExtension)$continuation.L$1;
                owner\1 = null;
                $this$withLock_u24default\1 = (Mutex)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl52:
                    // 2 sources

                    var6_12._library = (MediaStoreUtils.LibraryStoreClass)v1;
lbl53:
                    // 2 sources

                    v2 = this._library;
                    Intrinsics.checkNotNull((Object)v2);
                    var7_13 = v2;
                }
                catch (Throwable var5_11) {
                    throw var5_11;
                }
                finally {
                    $this$withLock_u24default\1.unlock(owner\1);
                }
                return var7_13;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object refreshLibrary(Continuation<? super Unit> $completion) {
        if (!($completion instanceof refreshLibrary.1)) ** GOTO lbl-1000
        var4_2 = $completion;
        if ((var4_2.label & -2147483648) != 0) {
            var4_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$refreshLibrary(this.this$0, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var2_5 = this;
                $continuation.L$0 = var2_5;
                $continuation.label = 1;
                v0 = MediaStoreUtils.INSTANCE.getAllSongs(this.context, this.settings, (Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl23
            }
            case 1: {
                var2_5 = (OfflineExtension)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl23:
                // 2 sources

                var2_5._library = (MediaStoreUtils.LibraryStoreClass)v0;
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object find(Artist artist, Continuation<? super MediaStoreUtils.MArtist> $completion) {
        if (!($completion instanceof find.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$find(this.this$0, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = artist;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                return ((MediaStoreUtils.LibraryStoreClass)v0).getArtistMap().get(StringsKt.toLongOrNull((String)artist.getId()));
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object find(Album album, Continuation<? super MediaStoreUtils.MAlbum> $completion) {
        if (!($completion instanceof find.2)) ** GOTO lbl-1000
        var11_3 = $completion;
        if ((var11_3.label & -2147483648) != 0) {
            var11_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$find(this.this$0, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var12_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = album;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var12_5) {
                    return var12_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                var3_6 = ((MediaStoreUtils.LibraryStoreClass)v0).getAlbumList();
                for (T var5_8 : var3_6) {
                    it\2 = (MediaStoreUtils.MAlbum)var5_8;
                    $i$a$-find-OfflineExtension$find$3\2\149\0 = false;
                    v1 = it\2.getId();
                    var8_11 = Long.parseLong(album.getId());
                    if (!(v1 != null && v1 == var8_11)) continue;
                    v2 = var5_8;
                    ** GOTO lbl32
                }
                v2 = null;
lbl32:
                // 2 sources

                return v2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object find(Playlist playlist, Continuation<? super MediaStoreUtils.MPlaylist> $completion) {
        if (!($completion instanceof find.4)) ** GOTO lbl-1000
        var9_3 = $completion;
        if ((var9_3.label & -2147483648) != 0) {
            var9_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$find(this.this$0, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = playlist;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var10_5) {
                    return var10_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                var3_6 = ((MediaStoreUtils.LibraryStoreClass)v0).getPlaylistList();
                for (T var5_8 : var3_6) {
                    it\2 = (MediaStoreUtils.MPlaylist)var5_8;
                    $i$a$-find-OfflineExtension$find$5\2\152\0 = false;
                    if (!(it\2.getId() == Long.parseLong(playlist.getId()))) continue;
                    v1 = var5_8;
                    ** GOTO lbl30
                }
                v1 = null;
lbl30:
                // 2 sources

                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    private final Feed<Shelf> toShelves(List<? extends EchoMediaItem> $this$toShelves, Feed.Buttons buttons2) {
        void $this$mapTo\2;
        void $this$map\1;
        Iterable iterable = $this$toShelves;
        Feed.Companion companion = Feed.Companion;
        boolean bl = false;
        void var5_6 = $this$map\1;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
        boolean bl2 = false;
        for (Object t : $this$mapTo\2) {
            void it\3;
            EchoMediaItem echoMediaItem = (EchoMediaItem)t;
            Collection collection2 = collection;
            boolean bl3 = false;
            collection2.add(it\3.toShelf());
        }
        return Feed.Companion.toFeed$default(companion, (List)collection, buttons2, null, 2, null);
    }

    static /* synthetic */ Feed toShelves$default(OfflineExtension offlineExtension, List list2, Feed.Buttons buttons2, int n, Object object) {
        if ((n & 1) != 0) {
            buttons2 = null;
        }
        return offlineExtension.toShelves(list2, buttons2);
    }

    @Override
    @Nullable
    public Object loadHomeFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        return new Feed(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this, null){
            int label;
            final /* synthetic */ OfflineExtension this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var49_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        if (OfflineExtension.access$getRefreshLibrary(this.this$0)) {
                            this.label = 1;
                            v0 = OfflineExtension.access$refreshLibrary(this.this$0, (Continuation)this);
                            if (v0 == var49_2) {
                                return var49_2;
                            }
                        }
                        ** GOTO lbl14
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl14:
                        // 2 sources

                        this.label = 2;
                        v1 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                        if (v1 == var49_2) {
                            return var49_2;
                        }
                        ** GOTO lbl22
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl22:
                        // 2 sources

                        library = (MediaStoreUtils.LibraryStoreClass)v1;
                        $this$sortedByDescending\1 = library.getSongList();
                        $i$f$sortedByDescending\1\160 = false;
                        $this$sortedByDescending\1 = CollectionsKt.sortedWith((Iterable)$this$sortedByDescending\1, (Comparator)new Comparator(){

                            /*
                             * WARNING - void declaration
                             */
                            public final int compare(T a, T b) {
                                void it\2;
                                Track track2 = (Track)b;
                                boolean bl = false;
                                String string2 = track2.getExtras().get("addDate");
                                track2 = (Track)a;
                                Comparable comparable = string2 != null ? StringsKt.toLongOrNull((String)string2) : null;
                                boolean bl2 = false;
                                String string3 = it\2.getExtras().get("addDate");
                                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)(string3 != null ? StringsKt.toLongOrNull((String)string3) : null));
                            }
                        });
                        $i$f$map\2\162 = false;
                        var6_7 = $this$map\2;
                        destination\3 /* !! */  = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\2, (int)10));
                        $i$f$mapTo\3\487 = false;
                        for (Object item\3 : $this$mapTo\3) {
                            var11_26 = (Track)item\3;
                            var15_31 = destination\3 /* !! */ ;
                            $i$a$-map-OfflineExtension$loadHomeFeed$2$recentlyAdded$2\4\489\0 = false;
                            var15_31.add(it\4);
                        }
                        recentlyAdded = (List)destination\3 /* !! */ ;
                        $this$map\5 = library.getAlbumList();
                        $i$f$map\5\163 = false;
                        destination\3 /* !! */  = $this$map\5;
                        destination\6 /* !! */  = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5, (int)10));
                        $i$f$mapTo\6\491 = false;
                        for (Object item\6 : $this$mapTo\6) {
                            $i$a$-map-OfflineExtension$loadHomeFeed$2$recentlyAdded$2\4\489\0 = (MediaStoreUtils.MAlbum)item\6;
                            var15_31 = destination\6 /* !! */ ;
                            $i$a$-map-OfflineExtension$loadHomeFeed$2$albums$1\7\493\0 = false;
                            var15_31.add(ConvertorsKt.toAlbum((MediaStoreUtils.MAlbum)it\7));
                        }
                        albums = CollectionsKt.shuffled((Iterable)((List)destination\6 /* !! */ ));
                        $this$map\8 = library.getArtistMap().values();
                        $i$f$map\8\166 = false;
                        destination\6 /* !! */  = $this$map\8;
                        destination\9 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                        $i$f$mapTo\9\495 = false;
                        item\6 = $this$mapTo\9.iterator();
                        while (item\6.hasNext()) {
                            item\9 = item\6.next();
                            $i$a$-map-OfflineExtension$loadHomeFeed$2$albums$1\7\493\0 = (MediaStoreUtils.MArtist)item\9;
                            var15_31 = destination\9;
                            $i$a$-map-OfflineExtension$loadHomeFeed$2$artists$1\10\497\0 = false;
                            var15_31.add(ConvertorsKt.toArtist((MediaStoreUtils.MArtist)it\10));
                        }
                        artists = CollectionsKt.shuffled((Iterable)((List)destination\9));
                        if (((Collection)recentlyAdded).isEmpty() == false) {
                            v2 = OfflineExtension.access$getContext$p(this.this$0).getString(R.string.recently_added);
                            Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"getString(...)");
                            $this$mapTo\9 = $i$f$map\8\166 = OfflineExtension.toShelves$default(this.this$0, recentlyAdded, null, 1, null);
                            var20_36 = null;
                            var19_37 = null;
                            var18_38 = CollectionsKt.take((Iterable)recentlyAdded, (int)9);
                            var17_39 = v2;
                            var16_40 = "recents";
                            $i$a$-takeIf-OfflineExtension$loadHomeFeed$2$recent$1\11\174\0 = false;
                            var21_41 = recentlyAdded.size() > 9;
                            var22_42 = null;
                            var23_43 = 88;
                            var24_44 = null;
                            var25_45 = var21_41 != false ? $i$f$map\8\166 : null;
                            var26_46 = var20_36;
                            var27_47 = var19_37;
                            var28_48 = var18_38;
                            var29_49 = var17_39;
                            var30_50 = var16_40;
                            v3 = new Shelf.Lists.Tracks(var30_50, var29_49, var28_48, var27_47, var26_46, var25_45, var24_44, var23_43, var22_42);
                        } else {
                            v3 = recent = null;
                        }
                        if (((Collection)albums).isEmpty() == false) {
                            v4 = OfflineExtension.access$getContext$p(this.this$0).getString(R.string.albums);
                            Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getString(...)");
                            $i$a$-takeIf-OfflineExtension$loadHomeFeed$2$recent$1\11\174\0 = it\11 = OfflineExtension.toShelves$default(this.this$0, albums, null, 1, null);
                            var20_36 = null;
                            var19_37 = null;
                            var18_38 = CollectionsKt.take((Iterable)albums, (int)10);
                            var17_39 = v4;
                            var16_40 = "albums";
                            $i$a$-takeIf-OfflineExtension$loadHomeFeed$2$albumShelf$1\12\181\0 = false;
                            var21_41 = albums.size() > 10;
                            var31_51 = null;
                            var32_52 = 88;
                            var33_53 = null;
                            var34_54 = var21_41 != false ? it\11 : null;
                            var35_55 = var20_36;
                            var36_56 = var19_37;
                            var37_57 = var18_38;
                            var38_58 = var17_39;
                            var39_59 = var16_40;
                            v5 = new Shelf.Lists.Items(var39_59, var38_58, var37_57, var36_56, var35_55, var34_54, var33_53, var32_52, var31_51);
                        } else {
                            v5 = albumShelf = null;
                        }
                        if (((Collection)artists).isEmpty() == false) {
                            v6 = OfflineExtension.access$getContext$p(this.this$0).getString(R.string.artists);
                            Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"getString(...)");
                            $i$a$-takeIf-OfflineExtension$loadHomeFeed$2$albumShelf$1\12\181\0 = it\12 = OfflineExtension.toShelves$default(this.this$0, artists, null, 1, null);
                            var20_36 = null;
                            var19_37 = null;
                            var18_38 = CollectionsKt.take((Iterable)artists, (int)10);
                            var17_39 = v6;
                            var16_40 = "artists";
                            $i$a$-takeIf-OfflineExtension$loadHomeFeed$2$artistsShelf$1\13\188\0 = false;
                            var21_41 = artists.size() > 10;
                            var40_60 = null;
                            var41_61 = 88;
                            var42_62 = null;
                            var43_63 = var21_41 != false ? it\12 : null;
                            var44_64 = var20_36;
                            var45_65 = var19_37;
                            var46_66 = var18_38;
                            var47_67 = var17_39;
                            var48_68 = var16_40;
                            v7 = new Shelf.Lists.Items(var48_68, var47_67, var46_66, var45_65, var44_64, var43_63, var42_62, var41_61, var40_60);
                        } else {
                            v7 = null;
                        }
                        artistsShelf = v7;
                        data = new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(recent, albumShelf, artistsShelf, library, null){
                            int label;
                            final /* synthetic */ Shelf.Lists.Tracks $recent;
                            final /* synthetic */ Shelf.Lists.Items $albumShelf;
                            final /* synthetic */ Shelf.Lists.Items $artistsShelf;
                            final /* synthetic */ MediaStoreUtils.LibraryStoreClass $library;
                            {
                                this.$recent = $recent;
                                this.$albumShelf = $albumShelf;
                                this.$artistsShelf = $artistsShelf;
                                this.$library = $library;
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
                                        void $this$map\1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object = new Shelf.Lists[]{this.$recent, this.$albumShelf, this.$artistsShelf};
                                        Collection collection = CollectionsKt.listOfNotNull((Object[])object);
                                        object = this.$library.getSongList();
                                        Collection collection2 = collection;
                                        boolean bl = false;
                                        void var4_5 = $this$map\1;
                                        Collection collection3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                                        boolean bl2 = false;
                                        for (T t : $this$mapTo\2) {
                                            void it\3;
                                            Track track2 = (Track)t;
                                            Collection collection4 = collection3;
                                            boolean bl3 = false;
                                            collection4.add(it\3.toShelf());
                                        }
                                        return CollectionsKt.plus((Collection)collection2, (Iterable)((List)collection3));
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
                        });
                        return Feed.Companion.toFeedData$default(Feed.Companion, data, new Feed.Buttons(false, true, true, null, 8, null), null, 2, null);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Tab p1, Continuation<? super Feed.Data<Shelf>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        });
    }

    @Override
    @Nullable
    public Object loadTrack(@NotNull Track track2, boolean isDownload, @NotNull Continuation<? super Track> $completion) {
        return track2;
    }

    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable streamable, boolean isDownload, @NotNull Continuation<? super Streamable.Media.Server> $completion) {
        String string2 = Uri.fromFile((File)new File(streamable.getId())).toString();
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
        return Streamable.Media.Companion.toMedia(Streamable.Source.Companion.toSource$default(Streamable.Source.Companion, string2, null, null, false, false, 7, null));
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Track track2, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadAlbum(@NotNull Album album, @NotNull Continuation<? super Album> $completion) {
        if (!($completion instanceof loadAlbum.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadAlbum(null, (Continuation<? super Album>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)album);
                $continuation.label = 1;
                v0 = this.find(album, (Continuation<? super MediaStoreUtils.MAlbum>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                Intrinsics.checkNotNull((Object)v0);
                return ConvertorsKt.toAlbum((MediaStoreUtils.MAlbum)v0);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Album album, @NotNull Continuation<? super Feed<Track>> $completion) {
        return Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Track>>, Object>(this, album, null){
            int label;
            final /* synthetic */ OfflineExtension this$0;
            final /* synthetic */ Album $album;
            {
                this.this$0 = $receiver;
                this.$album = $album;
                super(1, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = OfflineExtension.access$find(this.this$0, this.$album, (Continuation)this);
                        if (v0 == var12_2) {
                            return var12_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        Intrinsics.checkNotNull((Object)v0);
                        $this$sortedBy\1 = ((MediaStoreUtils.MAlbum)v0).getSongList();
                        $i$f$sortedBy\1\212 = false;
                        $this$map\2 = CollectionsKt.sortedWith((Iterable)$this$sortedBy\1, (Comparator)new Comparator(){

                            /*
                             * WARNING - void declaration
                             */
                            public final int compare(T a, T b) {
                                void it\2;
                                Track track2 = (Track)a;
                                boolean bl = false;
                                String string2 = track2.getExtras().get("trackNumber");
                                track2 = (Track)b;
                                Comparable comparable = string2 != null ? StringsKt.toLongOrNull((String)string2) : null;
                                boolean bl2 = false;
                                String string3 = it\2.getExtras().get("trackNumber");
                                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)(string3 != null ? StringsKt.toLongOrNull((String)string3) : null));
                            }
                        });
                        $i$f$map\2\212 = false;
                        var4_5 = $this$map\2;
                        destination\3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\2, (int)10));
                        $i$f$mapTo\3\487 = false;
                        for (T item\3 : $this$mapTo\3) {
                            var9_10 = (Track)item\3;
                            var11_12 = destination\3;
                            $i$a$-map-OfflineExtension$loadTracks$2$2\4\489\0 = false;
                            var11_12.add(it\4);
                        }
                        return (List)destination\3;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Continuation<? super List<Track>> p1) {
                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }
        }), null, null, 3, null);
    }

    @Override
    @Nullable
    public Object loadFeed(@NotNull Album album, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        return this.getArtistsWithCategories(album.getArtists(), (Function1<? super Track, Boolean>)((Function1)arg_0 -> OfflineExtension.loadFeed$lambda$4(album, arg_0)), $completion);
    }

    /*
     * Unable to fully structure code
     */
    private final Object getArtistsWithCategories(List<Artist> artists, Function1<? super Track, Boolean> filter, Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof getArtistsWithCategories.1)) ** GOTO lbl-1000
        var30_4 = $completion;
        if ((var30_4.label & -2147483648) != 0) {
            var30_4.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return OfflineExtension.access$getArtistsWithCategories(this.this$0, null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var31_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = artists;
                var27_8 = Feed.Companion;
                $i$f$map\1\220 = 0;
                var6_10 = $this$map\1;
                destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\502 = 0;
                var9_13 = $this$mapTo\2.iterator();
lbl19:
                // 2 sources

                while (var9_13.hasNext()) {
                    item\2 = var9_13.next();
                    var11_15 = (Artist)item\2;
                    var28_40 = destination\2;
                    $i$a$-map-OfflineExtension$getArtistsWithCategories$2\3\504\0 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(artists);
                    $continuation.L$1 = filter;
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$map\1);
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\2);
                    $continuation.L$4 = destination\2;
                    $continuation.L$5 = var9_13;
                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)item\2);
                    $continuation.L$7 = small\3;
                    $continuation.L$8 = var27_8;
                    $continuation.L$9 = var28_40;
                    $continuation.I$0 = $i$f$map\1\220;
                    $continuation.I$1 = $i$f$mapTo\2\502;
                    $continuation.I$2 = $i$a$-map-OfflineExtension$getArtistsWithCategories$2\3\504\0;
                    $continuation.label = 1;
                    v0 = this.find(small\3, (Continuation<? super MediaStoreUtils.MArtist>)$continuation);
                    if (v0 == var31_6) {
                        return var31_6;
                    }
                    ** GOTO lbl59
                }
                break;
            }
            case 1: {
                $i$a$-map-OfflineExtension$getArtistsWithCategories$2\3\504\0 = $continuation.I$2;
                $i$f$mapTo\2\502 = $continuation.I$1;
                $i$f$map\1\220 = $continuation.I$0;
                var28_40 = (Collection)$continuation.L$9;
                var27_8 = (Feed.Companion)$continuation.L$8;
                small\3 = (Artist)$continuation.L$7;
                item\2 = $continuation.L$6;
                var9_13 = (Iterator)$continuation.L$5;
                destination\2 = (Collection)$continuation.L$4;
                $this$mapTo\2 = (Iterable)$continuation.L$3;
                $this$map\1 = (Iterable)$continuation.L$2;
                filter = (Function1)$continuation.L$1;
                artists = (List)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl59:
                // 2 sources

                if ((artist\3 = (MediaStoreUtils.MArtist)v0) == null || (var14_18 = artist\3.getSongList()) == null) ** GOTO lbl-1000
                $this$filter\4 = (Iterable)var14_18;
                $i$f$filter\4\222 = false;
                var17_22 = $this$filter\4;
                destination\5 = new ArrayList<E>();
                $i$f$filterTo\5\505 = false;
                for (T element\5 : $this$filterTo\5) {
                    it\6 = (Track)element\5;
                    $i$a$-filter-OfflineExtension$getArtistsWithCategories$2$category$1\6\506\3 = false;
                    if (!((Boolean)filter.invoke((Object)it\6)).booleanValue()) continue;
                    destination\5.add(element\5);
                }
                $i$f$filter\4\222 = (List)destination\5;
                $i$f$map\7\224 = false;
                destination\5 = $this$map\7;
                destination\8 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
                $i$f$mapTo\8\508 = false;
                for (T item\8 : $this$mapTo\8) {
                    $i$a$-filter-OfflineExtension$getArtistsWithCategories$2$category$1\6\506\3 = (Track)item\8;
                    var24_37 = destination\8;
                    $i$a$-map-OfflineExtension$getArtistsWithCategories$2$category$2\9\510\3 = false;
                    var24_37.add(it\9);
                }
                var17_22 = (List)destination\8;
                if (var17_22.isEmpty()) {
                    $i$a$-ifEmpty-OfflineExtension$getArtistsWithCategories$2$category$3\10\224\3 = false;
                    v1 = null;
                } else {
                    v1 = var17_22;
                }
                var16_20 = (List)v1;
                if (var16_20 != null) {
                    tracks\11 = var16_20;
                    $i$a$-let-OfflineExtension$getArtistsWithCategories$2$category$4\11\224\3 = false;
                    v2 = small\3.getId();
                    var20_32 = new Object[]{small\3.getName()};
                    v3 = this.context.getString(R.string.more_by_x, var20_32);
                    Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getString(...)");
                    v4 = new Shelf.Lists.Items(v2, v3, tracks\11, null, null, OfflineExtension.toShelves$default(this, tracks\11, null, 1, null), null, 88, null);
                } else lbl-1000:
                // 2 sources

                {
                    v4 = null;
                }
                category\3 = v4;
                var14_18 = new Shelf[]{ConvertorsKt.toArtist(artist\3).toShelf(), category\3};
                var28_40.add(CollectionsKt.listOfNotNull((Object[])var14_18));
                ** GOTO lbl19
            }
        }
        return Feed.Companion.toFeed$default(var27_8, CollectionsKt.flatten((Iterable)((List)destination\2)), null, null, 3, null);
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadArtist(@NotNull Artist artist, @NotNull Continuation<? super Artist> $completion) {
        if (!($completion instanceof loadArtist.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadArtist(null, (Continuation<? super Artist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)artist);
                $continuation.label = 1;
                v0 = this.find(artist, (Continuation<? super MediaStoreUtils.MArtist>)$continuation);
                if (v0 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                Intrinsics.checkNotNull((Object)v0);
                return ConvertorsKt.toArtist((MediaStoreUtils.MArtist)v0);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    @Nullable
    public Object loadFeed(@NotNull Artist artist, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof loadFeed.4)) ** GOTO lbl-1000
        var26_3 = $completion;
        if ((var26_3.label & -2147483648) != 0) {
            var26_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadFeed((Artist)null, (Continuation<? super Feed<Shelf>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var45_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = artist;
                $continuation.label = 1;
                v0 = this.find(artist, (Continuation<? super MediaStoreUtils.MArtist>)$continuation);
                if (v0 == var45_5) {
                    return var45_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                Intrinsics.checkNotNull((Object)v0);
                $this$loadFeed_u24lambda_u2418\1 = (MediaStoreUtils.MArtist)v0;
                $i$a$-run-OfflineExtension$loadFeed$5\1\239\0 = false;
                var5_8 /* !! */  = (Object[])$this$loadFeed_u24lambda_u2418\1.getSongList();
                if (var5_8 /* !! */ .isEmpty()) {
                    $i$a$-ifEmpty-OfflineExtension$loadFeed$5$tracks$1\2\240\1 = false;
                    v1 = null;
                } else {
                    v1 = var5_8 /* !! */ ;
                }
                v2 = (Set)v1;
                tracks\1 = v2 != null ? CollectionsKt.toList((Iterable)v2) : null;
                $this$map\3 = $this$loadFeed_u24lambda_u2418\1.getAlbumList();
                $i$f$map\3\241 = false;
                var8_11 = $this$map\3;
                destination\4 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\3, (int)10));
                $i$f$mapTo\4\513 = false;
                var11_20 = $this$mapTo\4.iterator();
                while (var11_20.hasNext()) {
                    item\4 /* !! */  = var11_20.next();
                    var13_24 = (MediaStoreUtils.MAlbum)item\4 /* !! */ ;
                    var14_25 = destination\4;
                    $i$a$-map-OfflineExtension$loadFeed$5$albums$1\5\515\1 = false;
                    var14_25.add(ConvertorsKt.toAlbum((MediaStoreUtils.MAlbum)it\5));
                }
                var5_8 /* !! */  = (List)destination\4;
                if (var5_8 /* !! */ .isEmpty()) {
                    $i$a$-ifEmpty-OfflineExtension$loadFeed$5$albums$2\6\241\1 = false;
                    v3 = null;
                } else {
                    v3 = var5_8 /* !! */ ;
                }
                albums\1 = (List)v3;
                v4 = Feed.Companion;
                v5 = var5_8 /* !! */  = new List[3];
                v6 = 0;
                v7 = tracks\1;
                if (v7 != null) {
                    $this$mapTo\4 = v7;
                    var17_31 = v6;
                    var18_32 = v5;
                    var14_25 = v4;
                    $i$a$-let-OfflineExtension$loadFeed$5$1\7\243\1 = false;
                    id\7 = artist.getId() + "_tracks";
                    var11_20 = OfflineExtension.toShelves$default(this, tracks\1, null, 1, null);
                    item\4 /* !! */  = var11_20;
                    var13_24 = null;
                    $i$a$-map-OfflineExtension$loadFeed$5$albums$1\5\515\1 = null;
                    var19_33 = CollectionsKt.emptyList();
                    var20_34 = this.context.getString(R.string.songs) + " (" + it\7.size() + ")";
                    var21_36 = id\7;
                    $i$a$-takeIf-OfflineExtension$loadFeed$5$1$1\8\250\7 = false;
                    var23_38 = tracks\1.size() >= 10;
                    var27_39 = null;
                    var28_40 = 88;
                    var29_41 = null;
                    var30_42 = var23_38 != false ? var11_20 : null;
                    var31_43 = var13_24;
                    var32_44 = $i$a$-map-OfflineExtension$loadFeed$5$albums$1\5\515\1;
                    var33_45 = var19_33;
                    var34_46 = var20_34;
                    var35_47 = var21_36;
                    var24_48 = CollectionsKt.listOf((Object)new Shelf.Lists.Items(var35_47, var34_46, (List)var33_45, var32_44, (Shelf.Lists.Type)var31_43, (Feed)var30_42, var29_41, var28_40, var27_39));
                    v4 = var14_25;
                    v5 = var18_32;
                    v6 = var17_31;
                    v8 = var24_48;
                } else {
                    v8 = null;
                }
                v5[v6] = v8;
                v9 = var5_8 /* !! */ ;
                v10 = 1;
                v11 = tracks\1;
                if (v11 != null && (v11 = CollectionsKt.take((Iterable)v11, (int)10)) != null) {
                    it\7 = v11;
                    var17_31 = v10;
                    var18_32 = v9;
                    var14_25 = v4;
                    $i$f$map\9\254 = false;
                    id\7 = $this$map\9;
                    destination\10 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\9, (int)10));
                    $i$f$mapTo\10\517 = false;
                    for (E item\10 : $this$mapTo\10) {
                        var19_33 = (Track)item\10;
                        var24_48 = destination\10;
                        $i$a$-map-OfflineExtension$loadFeed$5$2\11\519\1 = false;
                        var24_48.add(it\11.toShelf());
                    }
                    var24_48 = (List)destination\10;
                    v4 = var14_25;
                    v9 = var18_32;
                    v10 = var17_31;
                    v12 = var24_48;
                } else {
                    v12 = null;
                }
                v9[v10] = v12;
                v13 = var5_8 /* !! */ ;
                v14 = 2;
                v15 = albums\1;
                if (v15 != null) {
                    $this$map\9 = v15;
                    var17_31 = v14;
                    var18_32 = v13;
                    var14_25 = v4;
                    $i$a$-let-OfflineExtension$loadFeed$5$3\12\255\1 = false;
                    id\12 = artist.getId() + "_albums";
                    $i$f$mapTo\10\517 = var11_20 = OfflineExtension.toShelves$default(this, albums\1, null, 1, null);
                    var13_24 = null;
                    var15_29 = null;
                    var19_33 = it\12;
                    var20_34 = this.context.getString(R.string.albums) + " (" + it\12.size() + ")";
                    var21_36 = id\12;
                    $i$a$-takeIf-OfflineExtension$loadFeed$5$3$1\13\262\12 = false;
                    var23_38 = albums\1.size() >= 4;
                    var36_49 = null;
                    var37_50 = 88;
                    var38_51 = null;
                    var39_52 = var23_38 != false ? var11_20 : null;
                    var40_53 = var13_24;
                    var41_54 = var15_29;
                    var42_55 = var19_33;
                    var43_56 = var20_34;
                    var44_57 = var21_36;
                    var24_48 = CollectionsKt.listOf((Object)new Shelf.Lists.Items(var44_57, var43_56, (List)var42_55, var41_54, (Shelf.Lists.Type)var40_53, (Feed)var39_52, var38_51, var37_50, var36_49));
                    v4 = var14_25;
                    v13 = var18_32;
                    v14 = var17_31;
                    v16 = var24_48;
                } else {
                    v16 = null;
                }
                v13[v14] = v16;
                return Feed.Companion.toFeed$default((Feed.Companion)v4, CollectionsKt.flatten((Iterable)CollectionsKt.listOfNotNull((Object[])var5_8 /* !! */ )), new Feed.Buttons(false, false, true, tracks\1, 3, null), null, 2, null);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadPlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof loadPlaylist.1)) ** GOTO lbl-1000
        var4_3 = $completion;
        if ((var4_3.label & -2147483648) != 0) {
            var4_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
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
        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!Intrinsics.areEqual((Object)playlist.getId(), (Object)"cached")) ** GOTO lbl15
                v0 = playlist;
                ** GOTO lbl27
lbl15:
                // 1 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.label = 1;
                v1 = this.find(playlist, (Continuation<? super MediaStoreUtils.MPlaylist>)$continuation);
                if (v1 == var5_5) {
                    return var5_5;
                }
                ** GOTO lbl25
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl25:
                // 2 sources

                Intrinsics.checkNotNull((Object)v1);
                v0 = ConvertorsKt.toPlaylist((MediaStoreUtils.MPlaylist)v1);
lbl27:
                // 2 sources

                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object loadTracks(@NotNull Playlist playlist, @NotNull Continuation<? super Feed<Track>> $completion) {
        return Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Track>>, Object>(this, playlist, null){
            int label;
            final /* synthetic */ OfflineExtension this$0;
            final /* synthetic */ Playlist $playlist;
            {
                this.this$0 = $receiver;
                this.$playlist = $playlist;
                super(1, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        this.label = 1;
                        v0 = OfflineExtension.access$find(this.this$0, this.$playlist, (Continuation)this);
                        if (v0 == var12_2) {
                            return var12_2;
                        }
                        ** GOTO lbl13
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl13:
                        // 2 sources

                        Intrinsics.checkNotNull((Object)v0);
                        $this$map\1 = ((MediaStoreUtils.MPlaylist)v0).getSongList();
                        $i$f$map\1\274 = false;
                        var4_5 = $this$map\1;
                        destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                        $i$f$mapTo\2\486 = false;
                        for (T item\2 : $this$mapTo\2) {
                            var9_10 = (Track)item\2;
                            var11_12 = destination\2;
                            $i$a$-map-OfflineExtension$loadTracks$4$1\3\488\0 = false;
                            var11_12.add(it\3);
                        }
                        return (List)destination\2;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Continuation<? super List<Track>> p1) {
                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }
        }), null, null, 3, null);
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
        return Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Track>>, Object>(radio2, this, null){
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
            int label;
            final /* synthetic */ Radio $radio;
            final /* synthetic */ OfflineExtension this$0;
            {
                this.$radio = $radio;
                this.this$0 = $receiver;
                super(1, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                block47: {
                    block50: {
                        block52: {
                            block51: {
                                block49: {
                                    block48: {
                                        var19_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                var3_3 = Serializer.INSTANCE;
                                                v0 = this.$radio.getExtras().get("mediaItem");
                                                Intrinsics.checkNotNull((Object)v0);
                                                $this$toData_u2dIoAF18A\1 = v0;
                                                $i$f$toData-IoAF18A\1\282 = false;
                                                var6_10 = $this$toData_u2dIoAF18A\1;
                                                try {
                                                    $this$toData_IoAF18A_u24lambda_u241\2 = var6_10;
                                                    $i$a$-runCatching-Serializer$toData$1\2\486\1 = false;
                                                    var9_19 = Serializer.INSTANCE.getJson();
                                                    string\3 = $this$toData_IoAF18A_u24lambda_u241\2;
                                                    $i$f$decodeFromString\3\487 = false;
                                                    this_\3.getSerializersModule();
                                                    $this$toData_IoAF18A_u24lambda_u241\2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)EchoMediaItem.Companion.serializer(), (String)string\3));
                                                }
                                                catch (Throwable $i$a$-runCatching-Serializer$toData$1\2\486\1) {
                                                    $this$toData_IoAF18A_u24lambda_u241\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-Serializer$toData$1\2\486\1));
                                                }
                                                var6_10 = $this$toData_IoAF18A_u24lambda_u241\2;
                                                $this$toData_IoAF18A_u24lambda_u241\2 = Result.exceptionOrNull-impl((Object)var6_10);
                                                if ($this$toData_IoAF18A_u24lambda_u241\2 == null) {
                                                    v1 = var6_10;
                                                } else {
                                                    $i$a$-runCatching-Serializer$toData$1\2\486\1 = var6_10;
                                                    try {
                                                        it\4 = $this$toData_IoAF18A_u24lambda_u241\2;
                                                        $i$a$-recoverCatching-Serializer$toData$2\4\489\1 = false;
                                                        throw new Serializer.DecodingException($this$toData_u2dIoAF18A\1, (Throwable)it\4);
                                                    }
                                                    catch (Throwable $i$a$-recoverCatching-Serializer$toData$2\4\489\1) {
                                                        v1 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-recoverCatching-Serializer$toData$2\4\489\1));
                                                    }
                                                }
                                                this_\1 = v1;
                                                ResultKt.throwOnFailure((Object)this_\1);
                                                mediaItem = (EchoMediaItem)this_\1;
                                                this.L$0 = mediaItem;
                                                this.label = 1;
                                                v2 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                                                if (v2 == var19_2) {
                                                    return var19_2;
                                                }
                                                ** GOTO lbl56
                                            }
                                            case 1: {
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v2 = $result;
lbl56:
                                                // 2 sources

                                                library = (MediaStoreUtils.LibraryStoreClass)v2;
                                                var4_4 = mediaItem;
                                                if (!(var4_4 instanceof Album)) break;
                                                var18_42 = Feed.Companion;
                                                this.L$0 = mediaItem;
                                                this.L$1 = library;
                                                this.L$2 = var18_42;
                                                this.label = 2;
                                                v3 = this.this$0.loadTracks((Album)mediaItem, (Continuation<? super Feed<Track>>)((Continuation)this));
                                                if (v3 == var19_2) {
                                                    return var19_2;
                                                }
                                                ** GOTO lbl74
                                            }
                                            case 2: {
                                                var18_42 = (Feed.Companion)this.L$2;
                                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v3 = $result;
lbl74:
                                                // 2 sources

                                                this.L$0 = mediaItem;
                                                this.L$1 = library;
                                                this.L$2 = null;
                                                this.label = 3;
                                                v4 = var18_42.loadAll((Feed)v3, (Continuation)this);
                                                if (v4 == var19_2) {
                                                    return var19_2;
                                                }
                                                ** GOTO lbl87
                                            }
                                            case 3: {
                                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v4 = $result;
lbl87:
                                                // 2 sources

                                                tracks = SequencesKt.take((Sequence)SequencesKt.filter((Sequence)SequencesKt.flattenSequenceOfIterable((Sequence)SequencesKt.map((Sequence)SequencesKt.flattenSequenceOfIterable((Sequence)SequencesKt.map((Sequence)CollectionsKt.asSequence((Iterable)((Iterable)v4)), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$0(dev.brahmkshatriya.echo.common.models.Track ), (Ldev/brahmkshatriya/echo/common/models/Track;)Ljava/util/List;)())), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$2(dev.brahmkshatriya.echo.extensions.builtin.offline.MediaStoreUtils$LibraryStoreClass dev.brahmkshatriya.echo.common.models.Artist ), (Ldev/brahmkshatriya/echo/common/models/Artist;)Ljava/util/List;)((MediaStoreUtils.LibraryStoreClass)library))), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$3(dev.brahmkshatriya.echo.common.models.EchoMediaItem dev.brahmkshatriya.echo.common.models.Track ), (Ldev/brahmkshatriya/echo/common/models/Track;)Ljava/lang/Boolean;)((EchoMediaItem)mediaItem)), (int)25);
                                                $this$map\5 = CollectionsKt.take((Iterable)CollectionsKt.shuffled((Iterable)library.getSongList()), (int)25);
                                                $i$f$map\5\291 = false;
                                                it\4 = $this$map\5;
                                                destination\6 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5, (int)10));
                                                $i$f$mapTo\6\492 = false;
                                                for (T item\6 : $this$mapTo\6) {
                                                    var14_60 = (Track)item\6;
                                                    var18_42 = destination\6;
                                                    $i$a$-map-OfflineExtension$loadTracks$6$randomTracks$1\7\494\0 = false;
                                                    var18_42.add(it\7);
                                                }
                                                randomTracks = (List)destination\6;
                                                v5 = SequencesKt.toMutableList((Sequence)SequencesKt.distinctBy((Sequence)SequencesKt.plus((Sequence)tracks, (Iterable)randomTracks), (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$5(dev.brahmkshatriya.echo.common.models.Track ), (Ldev/brahmkshatriya/echo/common/models/Track;)Ljava/lang/String;)()));
                                                break block47;
                                            }
                                        }
                                        if (!(var4_4 instanceof Playlist)) break block48;
                                        var18_43 = Feed.Companion;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                        this.L$2 = var18_43;
                                        this.label = 4;
                                        v6 = this.this$0.loadTracks((Playlist)mediaItem, (Continuation<? super Feed<Track>>)((Continuation)this));
                                        if (v6 == var19_2) {
                                            return var19_2;
                                        }
                                        ** GOTO lbl119
                                        {
                                            case 4: {
                                                var18_43 = (Feed.Companion)this.L$2;
                                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v6 = $result;
lbl119:
                                                // 2 sources

                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                                this.L$2 = null;
                                                this.label = 5;
                                                v7 = var18_43.loadAll((Feed)v6, (Continuation)this);
                                                if (v7 == var19_2) {
                                                    return var19_2;
                                                }
                                                ** GOTO lbl132
                                            }
                                            case 5: {
                                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v7 = $result;
lbl132:
                                                // 2 sources

                                                tracks = (List)v7;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                                this.L$2 = tracks;
                                                this.label = 6;
                                                v8 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                                                if (v8 == var19_2) {
                                                    return var19_2;
                                                }
                                                ** GOTO lbl147
                                            }
                                            case 6: {
                                                tracks = (List)this.L$2;
                                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                                mediaItem = (EchoMediaItem)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                v8 = $result;
lbl147:
                                                // 2 sources

                                                $this$map\8 = CollectionsKt.take((Iterable)CollectionsKt.shuffled((Iterable)((MediaStoreUtils.LibraryStoreClass)v8).getSongList()), (int)25);
                                                $i$f$map\8\297 = false;
                                                $this$mapTo\6 = $this$map\8;
                                                destination\9 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                                                $i$f$mapTo\9\496 = false;
                                                for (T item\9 : $this$mapTo\9) {
                                                    it\7 = (Track)item\9;
                                                    var18_43 = destination\9;
                                                    $i$a$-map-OfflineExtension$loadTracks$6$randomTracks$2\10\498\0 = false;
                                                    var18_43.add(it\10);
                                                }
                                                randomTracks = (List)destination\9;
                                                $this$distinctBy\11 = CollectionsKt.plus((Collection)tracks, (Iterable)randomTracks);
                                                $i$f$distinctBy\11\298 = false;
                                                set\11 = new HashSet<String>();
                                                list\11 = new ArrayList<T>();
                                                for (T e\11 : $this$distinctBy\11) {
                                                    it\12 = (Track)e\11;
                                                    $i$a$-distinctBy-OfflineExtension$loadTracks$6$2\12\503\0 = false;
                                                    key\11 = it\12.getId();
                                                    if (!set\11.add(key\11)) continue;
                                                    list\11.add(e\11);
                                                }
                                                v5 = CollectionsKt.toMutableList((Collection)list\11);
                                                break block47;
                                            }
                                        }
                                    }
                                    if (!(var4_4 instanceof Artist)) break block49;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                    this.label = 7;
                                    v9 = OfflineExtension.access$find(this.this$0, (Artist)mediaItem, (Continuation)this);
                                    if (v9 == var19_2) {
                                        return var19_2;
                                    }
                                    ** GOTO lbl188
                                    {
                                        case 7: {
                                            library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                            mediaItem = (EchoMediaItem)this.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v9 = $result;
lbl188:
                                            // 2 sources

                                            if ((v10 = (MediaStoreUtils.MArtist)v9) != null && (v10 = v10.getSongList()) != null) {
                                                $this$map\13 = (Iterable)v10;
                                                $i$f$map\13\302 = false;
                                                $i$f$mapTo\9\496 = $this$map\13;
                                                destination\14 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\13, (int)10));
                                                $i$f$mapTo\14\508 = false;
                                                for (T item\14 : $this$mapTo\14) {
                                                    var16_74 = (Track)item\14;
                                                    var18_44 = destination\14;
                                                    $i$a$-map-OfflineExtension$loadTracks$6$tracks$4\15\510\0 = false;
                                                    var18_44.add(it\15);
                                                }
                                                v11 = (List)destination\14;
                                            } else {
                                                v11 = CollectionsKt.emptyList();
                                            }
                                            tracks = v11;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)mediaItem);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                            this.L$2 = tracks;
                                            this.label = 8;
                                            v12 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                                            if (v12 == var19_2) {
                                                return var19_2;
                                            }
                                            ** GOTO lbl220
                                        }
                                        case 8: {
                                            tracks = (List)this.L$2;
                                            library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                            mediaItem = (EchoMediaItem)this.L$0;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v12 = $result;
lbl220:
                                            // 2 sources

                                            $this$map\16 = CollectionsKt.take((Iterable)CollectionsKt.shuffled((Iterable)((MediaStoreUtils.LibraryStoreClass)v12).getSongList()), (int)25);
                                            $i$f$map\16\303 = false;
                                            $this$map\13 = $this$map\16;
                                            destination\17 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\16, (int)10));
                                            $i$f$mapTo\17\512 = false;
                                            for (E item\17 : $this$mapTo\17) {
                                                $i$a$-distinctBy-OfflineExtension$loadTracks$6$2\12\503\0 = (Track)item\17;
                                                var18_44 = destination\17;
                                                $i$a$-map-OfflineExtension$loadTracks$6$randomTracks$3\18\514\0 = false;
                                                var18_44.add(it\18);
                                            }
                                            randomTracks = (List)destination\17;
                                            $this$distinctBy\19 = CollectionsKt.plus((Collection)tracks, (Iterable)randomTracks);
                                            $i$f$distinctBy\19\304 = false;
                                            set\19 = new HashSet<String>();
                                            list\19 = new ArrayList<T>();
                                            $i$f$mapTo\17\512 = $this$distinctBy\19.iterator();
                                            while ($i$f$mapTo\17\512.hasNext()) {
                                                e\19 = $i$f$mapTo\17\512.next();
                                                it\20 = (Track)e\19;
                                                $i$a$-distinctBy-OfflineExtension$loadTracks$6$3\20\519\0 = false;
                                                key\19 = it\20.getId();
                                                if (!set\19.add(key\19)) continue;
                                                list\19.add(e\19);
                                            }
                                            v5 = CollectionsKt.toMutableList((Collection)list\19);
                                            break block47;
                                        }
                                    }
                                }
                                if (!(var4_4 instanceof Track)) break block50;
                                v13 = ((Track)mediaItem).getAlbum();
                                if (v13 == null) break block51;
                                $this$distinctBy\19 = v13;
                                $i$f$distinctBy\19\304 = this.this$0;
                                it\21 = $this$distinctBy\19;
                                $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0 = 0;
                                $i$f$mapTo\17\512 = Feed.Companion;
                                e\19 = $i$f$distinctBy\19\304;
                                this.L$0 = mediaItem;
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it\21);
                                this.L$3 = $i$f$mapTo\17\512;
                                this.L$4 = e\19;
                                this.I$0 = $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0;
                                this.label = 9;
                                v14 = $i$f$distinctBy\19\304.loadAlbum((Album)it\21, (Continuation<? super Album>)this);
                                if (v14 == var19_2) {
                                    return var19_2;
                                }
                                ** GOTO lbl279
                                {
                                    case 9: {
                                        $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0 = this.I$0;
                                        e\19 = (OfflineExtension)this.L$4;
                                        $i$f$mapTo\17\512 = (Feed.Companion)this.L$3;
                                        it\21 = (Album)this.L$2;
                                        library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                        mediaItem = (EchoMediaItem)this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v14 = $result;
lbl279:
                                        // 2 sources

                                        this.L$0 = mediaItem;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it\21);
                                        this.L$3 = $i$f$mapTo\17\512;
                                        this.L$4 = null;
                                        this.I$0 = $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0;
                                        this.label = 10;
                                        v15 = e\19.loadTracks((Album)v14, (Continuation<? super Feed<Track>>)this);
                                        if (v15 == var19_2) {
                                            return var19_2;
                                        }
                                        ** GOTO lbl298
                                    }
                                    case 10: {
                                        $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0 = this.I$0;
                                        $i$f$mapTo\17\512 = (Feed.Companion)this.L$3;
                                        it\21 = (Album)this.L$2;
                                        library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                        mediaItem = (EchoMediaItem)this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v15 = $result;
lbl298:
                                        // 2 sources

                                        this.L$0 = mediaItem;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it\21);
                                        this.L$3 = null;
                                        this.I$0 = $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0;
                                        this.label = 11;
                                        v16 = $i$f$mapTo\17\512.loadAll((Feed)v15, this);
                                        if (v16 == var19_2) {
                                            return var19_2;
                                        }
                                        ** GOTO lbl315
                                    }
                                    case 11: {
                                        $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0 = this.I$0;
                                        it\21 = (Album)this.L$2;
                                        library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                        mediaItem = (EchoMediaItem)this.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v16 = $result;
lbl315:
                                        // 2 sources

                                        v17 = (List)v16;
                                        break block52;
                                    }
                                }
                            }
                            v17 = null;
                        }
                        albumTracks = v17;
                        $this$distinctBy\19 = ((Track)mediaItem).getArtists();
                        $i$f$distinctBy\19\304 = this.this$0;
                        $i$f$map\22\309 = 0;
                        $i$a$-let-OfflineExtension$loadTracks$6$albumTracks$1\21\308\0 = $this$map\22;
                        destination\23 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\22, (int)10));
                        $i$f$mapTo\23\525 = 0;
                        key\19 = $this$mapTo\23.iterator();
lbl328:
                        // 2 sources

                        while (key\19.hasNext()) {
                            item\23 = key\19.next();
                            $i$a$-map-OfflineExtension$loadTracks$6$randomTracks$3\18\514\0 = (Artist)item\23;
                            var18_45 = destination\23;
                            $i$a$-map-OfflineExtension$loadTracks$6$artistTracks$1\24\527\0 = 0;
                            this.L$0 = mediaItem;
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                            this.L$2 = albumTracks;
                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map\22);
                            this.L$4 = $i$f$distinctBy\19\304;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\23);
                            this.L$6 = destination\23;
                            this.L$7 = key\19;
                            this.L$8 = SpillingKt.nullOutSpilledVariable((Object)item\23);
                            this.L$9 = SpillingKt.nullOutSpilledVariable((Object)artist\24);
                            this.L$10 = var18_45;
                            this.I$0 = $i$f$map\22\309;
                            this.I$1 = $i$f$mapTo\23\525;
                            this.I$2 = $i$a$-map-OfflineExtension$loadTracks$6$artistTracks$1\24\527\0;
                            this.label = 12;
                            v18 = OfflineExtension.access$find($i$f$distinctBy\19\304, artist\24, (Continuation)this);
                            if (v18 == var19_2) {
                                return var19_2;
                            }
                            ** GOTO lbl370
                        }
                        {
                            break;
                            case 12: {
                                $i$a$-map-OfflineExtension$loadTracks$6$artistTracks$1\24\527\0 = this.I$2;
                                $i$f$mapTo\23\525 = this.I$1;
                                $i$f$map\22\309 = this.I$0;
                                var18_45 = (Collection)this.L$10;
                                artist\24 = (Artist)this.L$9;
                                item\23 = this.L$8;
                                key\19 = (Iterator<T>)this.L$7;
                                destination\23 = (Collection)this.L$6;
                                $this$mapTo\23 = (Iterable)this.L$5;
                                $i$f$distinctBy\19\304 = (OfflineExtension)this.L$4;
                                $this$map\22 = (Iterable)this.L$3;
                                albumTracks = (List)this.L$2;
                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                mediaItem = (EchoMediaItem)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v18 = $result;
lbl370:
                                // 2 sources

                                var18_45.add((v19 = (MediaStoreUtils.MArtist)v18) != null && (v19 = v19.getSongList()) != null ? (Collection)v19 : (Collection)CollectionsKt.emptyList());
                                ** GOTO lbl328
                            }
                        }
                        $this$map\25 = CollectionsKt.flatten((Iterable)((List)destination\23));
                        $i$f$map\25\311 = false;
                        $i$f$map\22\309 = $this$map\25;
                        destination\26 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\25, (int)10));
                        $i$f$mapTo\26\529 = false;
                        for (T item\26 : $this$mapTo\26) {
                            item\23 = (Track)item\26;
                            var18_45 = destination\26;
                            $i$a$-map-OfflineExtension$loadTracks$6$artistTracks$2\27\531\0 = false;
                            var18_45.add(it\27);
                        }
                        artistTracks = (List)destination\26;
                        this.L$0 = mediaItem;
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                        this.L$2 = albumTracks;
                        this.L$3 = artistTracks;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.L$10 = null;
                        this.label = 13;
                        v20 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                        if (v20 == var19_2) {
                            return var19_2;
                        }
                        ** GOTO lbl409
                        {
                            case 13: {
                                artistTracks = (List)this.L$3;
                                albumTracks = (List)this.L$2;
                                library = (MediaStoreUtils.LibraryStoreClass)this.L$1;
                                mediaItem = (EchoMediaItem)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v20 = $result;
lbl409:
                                // 2 sources

                                $this$map\28 = CollectionsKt.take((Iterable)CollectionsKt.shuffled((Iterable)((MediaStoreUtils.LibraryStoreClass)v20).getSongList()), (int)25);
                                $i$f$map\28\312 = false;
                                destination\26 = $this$map\28;
                                destination\29 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\28, (int)10));
                                $i$f$mapTo\29\533 = false;
                                for (T item\29 : $this$mapTo\29) {
                                    $i$a$-map-OfflineExtension$loadTracks$6$artistTracks$2\27\531\0 = (Track)item\29;
                                    var18_45 = destination\29;
                                    $i$a$-map-OfflineExtension$loadTracks$6$randomTracks$4\30\535\0 = false;
                                    var18_45.add(it\30);
                                }
                                randomTracks = (List)destination\29;
                                $i$f$map\28\312 /* !! */  = new List[]{albumTracks, artistTracks, randomTracks};
                                $i$f$map\28\312 /* !! */  = CollectionsKt.flatten((Iterable)CollectionsKt.listOfNotNull((Object[])$i$f$map\28\312 /* !! */ ));
                                $i$f$distinctBy\31\315 = false;
                                set\31 = new HashSet<String>();
                                list\31 = new ArrayList<T>();
                                for (T e\31 : $this$distinctBy\31) {
                                    it\32 = (Track)e\31;
                                    $i$a$-distinctBy-OfflineExtension$loadTracks$6$allTracks$1\32\540\0 = false;
                                    key\31 = it\32.getId();
                                    if (!set\31.add(key\31)) continue;
                                    list\31.add(e\31);
                                }
                                allTracks = CollectionsKt.toMutableList((Collection)list\31);
                                allTracks.removeIf((Predicate<Object>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, invokeSuspend$lambda$17(kotlin.jvm.functions.Function1 java.lang.Object ), (Ljava/lang/Object;)Z)((Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$16(dev.brahmkshatriya.echo.common.models.EchoMediaItem dev.brahmkshatriya.echo.common.models.Track ), (Ldev/brahmkshatriya/echo/common/models/Track;)Ljava/lang/Boolean;)((EchoMediaItem)mediaItem)));
                                v5 = allTracks;
                                break block47;
                            }
                        }
                    }
                    throw new IllegalAccessException();
                }
                return CollectionsKt.shuffled((Iterable)v5);
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Continuation<? super List<Track>> p1) {
                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }

            private static final List invokeSuspend$lambda$0(Track it) {
                return it.getArtists();
            }

            /*
             * WARNING - void declaration
             */
            private static final List invokeSuspend$lambda$2(MediaStoreUtils.LibraryStoreClass $library, Artist artist) {
                List list2;
                Object object = $library.getArtistMap().get(StringsKt.toLongOrNull((String)artist.getId()));
                if (object != null && (object = ((MediaStoreUtils.MArtist)object).getSongList()) != null) {
                    void $this$mapTo\2;
                    Iterable iterable = (Iterable)object;
                    boolean bl = false;
                    Iterable iterable2 = iterable;
                    Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                    boolean bl2 = false;
                    for (T t : $this$mapTo\2) {
                        void it\3;
                        Track track2 = (Track)t;
                        Collection collection2 = collection;
                        boolean bl3 = false;
                        collection2.add(it\3);
                    }
                    list2 = (List)collection;
                } else {
                    list2 = null;
                }
                Intrinsics.checkNotNull(list2);
                return list2;
            }

            private static final boolean invokeSuspend$lambda$3(EchoMediaItem $mediaItem, Track it) {
                Album album = it.getAlbum();
                return !Intrinsics.areEqual((Object)(album != null ? album.getId() : null), (Object)((Album)$mediaItem).getId());
            }

            private static final String invokeSuspend$lambda$5(Track it) {
                return it.getId();
            }

            private static final boolean invokeSuspend$lambda$16(EchoMediaItem $mediaItem, Track it) {
                return Intrinsics.areEqual((Object)it.getId(), (Object)((Track)$mediaItem).getId());
            }

            private static final boolean invokeSuspend$lambda$17(Function1 $tmp0, Object p0) {
                return (Boolean)$tmp0.invoke(p0);
            }
        }), null, null, 3, null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object radio(@NotNull EchoMediaItem item2, @Nullable EchoMediaItem context, @NotNull Continuation<? super Radio> $completion) {
        void this_\2;
        void this_\1;
        String id2 = "radio_" + item2.hashCode();
        String title = item2.getTitle();
        Object[] objectArray = new Object[]{title};
        String string2 = this.context.getString(R.string.x_radio, objectArray);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
        Serializer serializer2 = Serializer.INSTANCE;
        EchoMediaItem echoMediaItem = item2;
        boolean bl = false;
        Json json = this_\1.getJson();
        EchoMediaItem echoMediaItem2 = echoMediaItem;
        boolean bl2 = false;
        this_\2.getSerializersModule();
        return new Radio(id2, string2, null, null, null, null, null, MapsKt.mapOf((Pair)TuplesKt.to((Object)"mediaItem", (Object)this_\2.encodeToString((SerializationStrategy)EchoMediaItem.Companion.serializer(), (Object)echoMediaItem2))), false, false, false, false, false, 8060, null);
    }

    /*
     * WARNING - void declaration
     */
    private final List<Shelf.Item> sorted(List<? extends EchoMediaItem> $this$sorted) {
        void $this$mapTo\3;
        Iterable iterable = $this$sorted;
        boolean bl = false;
        Iterable iterable2 = CollectionsKt.sortedWith((Iterable)iterable, (Comparator)new Comparator(){

            /*
             * WARNING - void declaration
             */
            public final int compare(T a, T b) {
                void it\2;
                EchoMediaItem echoMediaItem = (EchoMediaItem)a;
                boolean bl = false;
                String string2 = echoMediaItem.getTitle().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toLowerCase(...)");
                echoMediaItem = (EchoMediaItem)b;
                Comparable comparable = (Comparable)((Object)string2);
                boolean bl2 = false;
                String string3 = it\2.getTitle().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)((Comparable)((Object)string3)));
            }
        });
        boolean bl2 = false;
        Iterable iterable3 = iterable2;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, (int)10));
        boolean bl3 = false;
        for (Object t : $this$mapTo\3) {
            void it\4;
            EchoMediaItem echoMediaItem = (EchoMediaItem)t;
            Collection collection2 = collection;
            boolean bl4 = false;
            collection2.add(it\4.toShelf());
        }
        return (List)collection;
    }

    private final Feed.Data<Shelf> toPair(List<? extends Shelf> $this$toPair, Feed.Buttons buttons2) {
        return Feed.Companion.toFeedData$default(Feed.Companion, new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>($this$toPair, null){
            int label;
            final /* synthetic */ List<Shelf> $this_toPair;
            {
                this.$this_toPair = $receiver;
                super(1, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        return this.$this_toPair;
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
        }), buttons2, null, 2, null);
    }

    static /* synthetic */ Feed.Data toPair$default(OfflineExtension offlineExtension, List list2, Feed.Buttons buttons2, int n, Object object) {
        if ((n & 1) != 0) {
            buttons2 = null;
        }
        return offlineExtension.toPair(list2, buttons2);
    }

    private final Feed.Data<Shelf> toFeed(Pair<? extends List<? extends Shelf>, Boolean> $this$toFeed) {
        return this.toPair((List)$this$toFeed.getFirst(), (Boolean)$this$toFeed.getSecond() != false ? new Feed.Buttons(false, true, false, null, 12, null) : null);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object loadSearchFeed(@NotNull String query, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        void $this$mapTo\2;
        List list2;
        if (StringsKt.isBlank((CharSequence)query)) {
            var3_3 = new String[]{"Songs", "Albums", "Artists", "Genres"};
            list2 = CollectionsKt.listOf((Object[])var3_3);
        } else {
            var3_3 = new String[]{"All", "Songs", "Albums", "Artists"};
            list2 = CollectionsKt.listOf((Object[])var3_3);
        }
        Iterable iterable = list2;
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
        Function2 function2 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(query, this, null){
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ String $query;
            final /* synthetic */ OfflineExtension this$0;
            {
                this.$query = $query;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Exception decompiling
             */
            public final Object invokeSuspend(Object $result) {
                /*
                 * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                 * 
                 * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[CASE]], but top level block is 11[SWITCH]
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
                 *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:598)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperAnonymousInner.dumpWithArgs(ClassFileDumperAnonymousInner.java:87)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.ConstructorInvokationAnonymousInner.dumpInner(ConstructorInvokationAnonymousInner.java:82)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.CastExpression.dumpInner(CastExpression.java:114)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dumpWithOuterPrecedence(AbstractExpression.java:142)
                 *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.AbstractExpression.dump(AbstractExpression.java:98)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredAssignment.dump(StructuredAssignment.java:69)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.dump(Block.java:564)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.dump(Op04StructuredStatement.java:220)
                 *     at org.benf.cfr.reader.entities.attributes.AttributeCode.dump(AttributeCode.java:135)
                 *     at org.benf.cfr.reader.state.TypeUsageCollectingDumper.dump(TypeUsageCollectingDumper.java:194)
                 *     at org.benf.cfr.reader.entities.Method.dump(Method.java:627)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.AbstractClassFileDumper.dumpMethods(AbstractClassFileDumper.java:211)
                 *     at org.benf.cfr.reader.entities.classfilehelpers.ClassFileDumperNormal.dump(ClassFileDumperNormal.java:70)
                 *     at org.benf.cfr.reader.entities.ClassFile.dump(ClassFile.java:1167)
                 *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:952)
                 *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
                 *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
                 *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
                 *     at org.benf.cfr.reader.Main.main(Main.java:54)
                 */
                throw new IllegalStateException("Decompilation failed");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(Tab p1, Continuation<? super Feed.Data<Shelf>> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }

            /*
             * WARNING - void declaration
             */
            private static final List invokeSuspend$lambda$7(Track it) {
                void $this$mapTo\2;
                void $this$map\1;
                Object object = new String[2];
                object[0] = it.getTitle();
                Album album = it.getAlbum();
                object[1] = album != null ? album.getTitle() : null;
                Collection collection = CollectionsKt.listOf((Object[])object);
                object = it.getArtists();
                Collection collection2 = collection;
                boolean bl = false;
                void var3_4 = $this$map\1;
                Collection collection3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                boolean bl2 = false;
                for (T t : $this$mapTo\2) {
                    void artist\3;
                    Artist artist = (Artist)t;
                    Collection collection4 = collection3;
                    boolean bl3 = false;
                    collection4.add(artist\3.getName());
                }
                return CollectionsKt.plus((Collection)collection2, (Iterable)((List)collection3));
            }

            /*
             * WARNING - void declaration
             */
            private static final List invokeSuspend$lambda$10(Album it) {
                void $this$mapTo\2;
                void $this$map\1;
                Iterable iterable = it.getArtists();
                Collection collection = CollectionsKt.listOf((Object)it.getTitle());
                boolean bl = false;
                void var3_4 = $this$map\1;
                Collection collection2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                boolean bl2 = false;
                for (T t : $this$mapTo\2) {
                    void artist\3;
                    Artist artist = (Artist)t;
                    Collection collection3 = collection2;
                    boolean bl3 = false;
                    collection3.add(artist\3.getName());
                }
                return CollectionsKt.plus((Collection)collection, (Iterable)((List)collection2));
            }

            private static final List invokeSuspend$lambda$12(Artist it) {
                return CollectionsKt.listOf((Object)it.getName());
            }
        };
        List list3 = (List)collection;
        return new Feed(list3, function2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @Nullable
    public Object loadLibraryFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        void $this$mapTo\2;
        Object[] objectArray = new String[]{"Playlists", "Folders"};
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
            final /* synthetic */ OfflineExtension this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                block12: {
                    var2_2 = (Tab)this.L$0;
                    var11_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            if (OfflineExtension.access$getRefreshLibrary(this.this$0)) {
                                this.L$0 = tab;
                                this.label = 1;
                                v0 = OfflineExtension.access$refreshLibrary(this.this$0, (Continuation)this);
                                if (v0 == var11_3) {
                                    return var11_3;
                                }
                            }
                            ** GOTO lbl16
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl16:
                            // 2 sources

                            v1 = tab;
                            if (!Intrinsics.areEqual((Object)(v1 != null ? v1.getId() : null), (Object)"Folders")) break;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.label = 2;
                            v2 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                            if (v2 == var11_3) {
                                return var11_3;
                            }
                            ** GOTO lbl27
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)$result);
                            v2 = $result;
lbl27:
                            // 2 sources

                            v3 = ((MediaStoreUtils.LibraryStoreClass)v2).getFolderStructure().getFolderList().entrySet();
                            Intrinsics.checkNotNullExpressionValue(v3, (String)"<get-entries>(...)");
                            var4_4 = (Map.Entry)CollectionsKt.firstOrNull((Iterable)v3);
                            if (var4_4 == null || (var5_5 = (MediaStoreUtils.FileNode)var4_4.getValue()) == null || (var6_6 = ConvertorsKt.toShelf(var5_5, OfflineExtension.access$getContext$p(this.this$0), null)) == null || (var7_7 = var6_6.getFeed()) == null || (var8_8 = var7_7.getGetPagedData()) == null) ** GOTO lbl-1000
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.label = 3;
                            v4 = var8_8.invoke(null, (Object)this);
                            if (v4 == var11_3) {
                                return var11_3;
                            }
                            ** GOTO lbl40
                        }
                        case 3: {
                            ResultKt.throwOnFailure((Object)$result);
                            v4 = $result;
lbl40:
                            // 2 sources

                            if ((var9_9 = (Feed.Data)v4) != null && (var10_10 = var9_9.getPagedData()) != null) {
                                v5 = var10_10;
                            } else lbl-1000:
                            // 2 sources

                            {
                                v5 = new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(null){
                                    int label;

                                    public final Object invokeSuspend(Object $result) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                return CollectionsKt.emptyList();
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
                                });
                            }
                            break block12;
                        }
                    }
                    v5 = new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(this.this$0, null){
                        int label;
                        final /* synthetic */ OfflineExtension this$0;
                        {
                            this.this$0 = $receiver;
                            super(1, $completion);
                        }

                        /*
                         * Unable to fully structure code
                         */
                        public final Object invokeSuspend(Object $result) {
                            var12_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)$result);
                                    this.label = 1;
                                    v0 = OfflineExtension.access$getLibrary(this.this$0, (Continuation)this);
                                    if (v0 == var12_2) {
                                        return var12_2;
                                    }
                                    ** GOTO lbl13
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v0 = $result;
lbl13:
                                    // 2 sources

                                    $this$map\1 = ((MediaStoreUtils.LibraryStoreClass)v0).getPlaylistList();
                                    $i$f$map\1\415 = false;
                                    var4_5 = $this$map\1;
                                    destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                                    $i$f$mapTo\2\486 = false;
                                    for (T item\2 : $this$mapTo\2) {
                                        var9_10 = (MediaStoreUtils.MPlaylist)item\2;
                                        var11_12 = destination\2;
                                        $i$a$-map-OfflineExtension$loadLibraryFeed$3$pagedData$2$1\3\488\0 = false;
                                        var11_12.add(ConvertorsKt.toPlaylist((MediaStoreUtils.MPlaylist)it\3).toShelf());
                                    }
                                    return (List)destination\2;
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
                    });
                }
                pagedData = v5;
                return Feed.Companion.toFeedData$default(Feed.Companion, pagedData, new Feed.Buttons(false, false, false, null, 15, null), null, 2, null);
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

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object listEditablePlaylists(@Nullable Track track, @NotNull Continuation<? super List<Pair<Playlist, Boolean>>> $completion) {
        if (!($completion instanceof listEditablePlaylists.1)) ** GOTO lbl-1000
        var21_3 = $completion;
        if ((var21_3.label & -2147483648) != 0) {
            var21_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.listEditablePlaylists(null, (Continuation<? super List<Pair<Playlist, Boolean>>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = track;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var22_5) {
                    return var22_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                $this$map\1 = ((MediaStoreUtils.LibraryStoreClass)v0).getPlaylistList();
                $i$f$map\1\421 = false;
                var5_8 = $this$map\1;
                destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\536 = false;
                for (T item\2 : $this$mapTo\2) {
                    var10_13 = (MediaStoreUtils.MPlaylist)item\2;
                    var19_22 = destination\2;
                    $i$a$-map-OfflineExtension$listEditablePlaylists$2\3\538\0 = false;
                    $this$any\4 = it\3.getSongList();
                    $i$f$any\4\422 = false;
                    if (!($this$any\4 instanceof Collection) || !((Collection)$this$any\4).isEmpty()) ** GOTO lbl36
                    v1 = false;
                    ** GOTO lbl44
lbl36:
                    // 2 sources

                    for (T element\4 : $this$any\4) {
                        song\5 = (Track)element\4;
                        $i$a$-any-OfflineExtension$listEditablePlaylists$2$has$1\5\540\3 = false;
                        v2 = track;
                        if (!Intrinsics.areEqual((Object)song\5.getId(), (Object)(v2 != null ? v2.getId() : null))) continue;
                        v1 = true;
                        ** GOTO lbl44
                    }
                    v1 = false;
lbl44:
                    // 3 sources

                    has\3 = v1;
                    var19_22.add(TuplesKt.to((Object)ConvertorsKt.toPlaylist((MediaStoreUtils.MPlaylist)it\3), (Object)Boxing.boxBoolean((boolean)(has\3 != false))));
                }
                return (List)destination\2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object likeItem(@NotNull EchoMediaItem item, boolean shouldLike, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof likeItem.1)) ** GOTO lbl-1000
        var16_4 = $completion;
        if ((var16_4.label & -2147483648) != 0) {
            var16_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                boolean Z$0;
                long J$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.likeItem(null, false, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var17_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = item;
                $continuation.Z$0 = shouldLike;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var17_6) {
                    return var17_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                shouldLike = $continuation.Z$0;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                library = (MediaStoreUtils.LibraryStoreClass)v0;
                v1 = library.getLikedPlaylist();
                if (v1 == null) {
                    throw new ClientException.NotSupported("Couldn't create Liked Playlist");
                }
                playlist = v1.getId();
                if (!shouldLike) ** GOTO lbl32
                MediaStoreUtils.INSTANCE.addSongToPlaylist(this.context, playlist, Long.parseLong(item.getId()), 0);
                ** GOTO lbl48
lbl32:
                // 1 sources

                $this$indexOfFirst\1 = library.getLikedPlaylist().getSongList();
                $i$f$indexOfFirst\1\432 = false;
                index\1 = 0;
                for (T item\1 : $this$indexOfFirst\1) {
                    if (index\1 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    it\2 = (Track)item\1;
                    $i$a$-indexOfFirst-OfflineExtension$likeItem$index$1\2\546\0 = false;
                    if (!Intrinsics.areEqual((Object)it\2.getId(), (Object)item.getId())) ** GOTO lbl43
                    v2 = index\1;
                    ** GOTO lbl46
lbl43:
                    // 1 sources

                    ++index\1;
                }
                v2 = -1;
lbl46:
                // 2 sources

                index = v2;
                MediaStoreUtils.INSTANCE.removeSongFromPlaylist(this.context, playlist, index);
lbl48:
                // 2 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)library);
                $continuation.Z$0 = shouldLike;
                $continuation.J$0 = playlist;
                $continuation.label = 2;
                v3 = this.refreshLibrary((Continuation<? super Unit>)$continuation);
                if (v3 == var17_6) {
                    return var17_6;
                }
                ** GOTO lbl64
            }
            case 2: {
                playlist = $continuation.J$0;
                shouldLike = $continuation.Z$0;
                library = (MediaStoreUtils.LibraryStoreClass)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = $result;
lbl64:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object isItemLiked(@NotNull EchoMediaItem item, @NotNull Continuation<? super Boolean> $completion) {
        if (!($completion instanceof isItemLiked.1)) ** GOTO lbl-1000
        var9_3 = $completion;
        if ((var9_3.label & -2147483648) != 0) {
            var9_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.isItemLiked(null, (Continuation<? super Boolean>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = item;
                $continuation.label = 1;
                v0 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v0 == var10_5) {
                    return var10_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                if ((v1 = ((MediaStoreUtils.LibraryStoreClass)v0).getLikedPlaylist()) == null || (v1 = v1.getSongList()) == null) ** GOTO lbl33
                var3_6 = (Iterable)v1;
                for (T var5_8 : var3_6) {
                    it\2 = (Track)var5_8;
                    $i$a$-find-OfflineExtension$isItemLiked$2\2\439\0 = false;
                    if (!Intrinsics.areEqual((Object)it\2.getId(), (Object)item.getId())) continue;
                    v2 = var5_8;
                    ** GOTO lbl31
                }
                v2 = null;
lbl31:
                // 2 sources

                v3 = v2;
                ** GOTO lbl34
lbl33:
                // 1 sources

                v3 = null;
lbl34:
                // 2 sources

                return Boxing.boxBoolean((boolean)(v3 != null));
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object createPlaylist(@NotNull String title, @Nullable String description, @NotNull Continuation<? super Playlist> $completion) {
        if (!($completion instanceof createPlaylist.1)) ** GOTO lbl-1000
        var11_4 = $completion;
        if ((var11_4.label & -2147483648) != 0) {
            var11_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ OfflineExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.createPlaylist(null, null, (Continuation<? super Playlist>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var12_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = MediaStoreUtils.INSTANCE.createPlaylist(this.context, title);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)title);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)description);
                $continuation.L$2 = id;
                $continuation.label = 1;
                v0 = this.refreshLibrary((Continuation<? super Unit>)$continuation);
                if (v0 == var12_6) {
                    return var12_6;
                }
                ** GOTO lbl27
            }
            case 1: {
                id = (Long)$continuation.L$2;
                description = (String)$continuation.L$1;
                title = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl27:
                // 2 sources

                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)title);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)description);
                $continuation.L$2 = id;
                $continuation.label = 2;
                v1 = this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$continuation);
                if (v1 == var12_6) {
                    return var12_6;
                }
                ** GOTO lbl41
            }
            case 2: {
                id = (Long)$continuation.L$2;
                description = (String)$continuation.L$1;
                title = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl41:
                // 2 sources

                var5_8 = ((MediaStoreUtils.LibraryStoreClass)v1).getPlaylistList();
                for (T var7_10 : var5_8) {
                    it\2 = (MediaStoreUtils.MPlaylist)var7_10;
                    $i$a$-find-OfflineExtension$createPlaylist$2\2\444\0 = false;
                    v2 = id;
                    if (!(v2 != null && it\2.getId().longValue() == v2.longValue())) continue;
                    v3 = var7_10;
                    ** GOTO lbl50
                }
                v3 = null;
lbl50:
                // 2 sources

                Intrinsics.checkNotNull(v3);
                return ConvertorsKt.toPlaylist(v3);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object deletePlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Unit> $completion) {
        MediaStoreUtils.INSTANCE.deletePlaylist(this.context, Long.parseLong(playlist.getId()));
        Object object = this.refreshLibrary($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object editPlaylistMetadata(@NotNull Playlist playlist, @NotNull String title, @Nullable String description, @NotNull Continuation<? super Unit> $completion) {
        MediaStoreUtils.INSTANCE.editPlaylist(this.context, Long.parseLong(playlist.getId()), title);
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object addTracksToPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, int index, @NotNull List<Track> list2, @NotNull Continuation<? super Unit> $completion) {
        Iterable iterable = list2;
        boolean bl = false;
        for (Object t : iterable) {
            Track track2 = (Track)t;
            boolean bl2 = false;
            MediaStoreUtils.INSTANCE.addSongToPlaylist(this.context, Long.parseLong(playlist.getId()), Long.parseLong(track2.getId()), index);
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object removeTracksFromPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, @NotNull List<Integer> indexes2, @NotNull Continuation<? super Unit> $completion) {
        Iterable iterable = indexes2;
        boolean bl = false;
        for (Object t : iterable) {
            int n = ((Number)t).intValue();
            boolean bl2 = false;
            MediaStoreUtils.INSTANCE.removeSongFromPlaylist(this.context, Long.parseLong(playlist.getId()), n);
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object moveTrackInPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, int fromIndex, int toIndex, @NotNull Continuation<? super Unit> $completion) {
        long song = Long.parseLong(tracks.get(fromIndex).getId());
        MediaStoreUtils.INSTANCE.moveSongInPlaylist(this.context, Long.parseLong(playlist.getId()), song, fromIndex, toIndex);
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onEnterPlaylistEditor(@NotNull Playlist playlist, @NotNull List<Track> tracks, @NotNull Continuation<? super Unit> $completion) {
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onExitPlaylistEditor(@NotNull Playlist playlist, @NotNull List<Track> tracks, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.refreshLibrary($completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
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

    private static final boolean loadFeed$lambda$4(Album $album, Track it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Album album = it.getAlbum();
        return !Intrinsics.areEqual((Object)(album != null ? album.getId() : null), (Object)$album.getId());
    }

    public static final /* synthetic */ Object access$getLibrary(OfflineExtension $this, Continuation $completion) {
        return $this.getLibrary((Continuation<? super MediaStoreUtils.LibraryStoreClass>)$completion);
    }

    public static final /* synthetic */ Object access$refreshLibrary(OfflineExtension $this, Continuation $completion) {
        return $this.refreshLibrary((Continuation<? super Unit>)$completion);
    }

    public static final /* synthetic */ Object access$find(OfflineExtension $this, Artist artist, Continuation $completion) {
        return $this.find(artist, (Continuation<? super MediaStoreUtils.MArtist>)$completion);
    }

    public static final /* synthetic */ Object access$find(OfflineExtension $this, Album album, Continuation $completion) {
        return $this.find(album, (Continuation<? super MediaStoreUtils.MAlbum>)$completion);
    }

    public static final /* synthetic */ Object access$find(OfflineExtension $this, Playlist playlist, Continuation $completion) {
        return $this.find(playlist, (Continuation<? super MediaStoreUtils.MPlaylist>)$completion);
    }

    public static final /* synthetic */ boolean access$getRefreshLibrary(OfflineExtension $this) {
        return $this.getRefreshLibrary();
    }

    public static final /* synthetic */ Context access$getContext$p(OfflineExtension $this) {
        return $this.context;
    }

    public static final /* synthetic */ Object access$getArtistsWithCategories(OfflineExtension $this, List artists, Function1 filter, Continuation $completion) {
        return $this.getArtistsWithCategories(artists, (Function1<? super Track, Boolean>)filter, (Continuation<? super Feed<Shelf>>)$completion);
    }

    public static final /* synthetic */ Feed.Data access$toPair(OfflineExtension $this, List $receiver, Feed.Buttons buttons2) {
        return $this.toPair($receiver, buttons2);
    }

    public static final /* synthetic */ List access$sorted(OfflineExtension $this, List $receiver) {
        return $this.sorted($receiver);
    }

    public static final /* synthetic */ Feed.Data access$toFeed(OfflineExtension $this, Pair $receiver) {
        return $this.toFeed((Pair<? extends List<? extends Shelf>, Boolean>)$receiver);
    }

    static {
        ImportType importType = ImportType.BuiltIn;
        ExtensionType extensionType = ExtensionType.MUSIC;
        ImageHolder.ResourceIdImageHolder resourceIdImageHolder = ImageHolder.Companion.toResourceImageHolder$default(ImageHolder.Companion, R.drawable.ic_offline, false, 1, null);
        metadata = new dev.brahmkshatriya.echo.common.models.Metadata("OfflineExtension", "", importType, extensionType, "echo-offline", "Offline", "v1", "An extension for all your downloaded files.", "Echo", null, resourceIdImageHolder, null, null, null, false, 31232, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/offline/OfflineExtension$Companion;", "", "<init>", "()V", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final dev.brahmkshatriya.echo.common.models.Metadata getMetadata() {
            return metadata;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

