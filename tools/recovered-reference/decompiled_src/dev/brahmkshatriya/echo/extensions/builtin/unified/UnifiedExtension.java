/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  androidx.annotation.OptIn
 *  androidx.media3.common.util.UnstableApi
 *  androidx.media3.datasource.cache.SimpleCache
 *  androidx.room.Room
 *  dev.brahmkshatriya.echo.R$string
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.JvmClassMappingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.unified;

import android.app.Application;
import android.content.Context;
import androidx.annotation.OptIn;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.room.Room;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.AlbumClient;
import dev.brahmkshatriya.echo.common.clients.ArtistClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.FollowClient;
import dev.brahmkshatriya.echo.common.clients.HideClient;
import dev.brahmkshatriya.echo.common.clients.HomeFeedClient;
import dev.brahmkshatriya.echo.common.clients.LibraryFeedClient;
import dev.brahmkshatriya.echo.common.clients.LikeClient;
import dev.brahmkshatriya.echo.common.clients.LyricsClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistEditClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistEditCoverClient;
import dev.brahmkshatriya.echo.common.clients.RadioClient;
import dev.brahmkshatriya.echo.common.clients.SaveClient;
import dev.brahmkshatriya.echo.common.clients.SearchFeedClient;
import dev.brahmkshatriya.echo.common.clients.ShareClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.clients.TrackerMarkClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Lyrics;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.TrackDetails;
import dev.brahmkshatriya.echo.common.providers.MusicExtensionsProvider;
import dev.brahmkshatriya.echo.common.settings.SettingSwitch;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.di.App;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension;
import dev.brahmkshatriya.echo.extensions.exceptions.AppException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00b6\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u0000 \u00ac\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u0013:\u0002\u00ac\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0016J\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u00100\u001a\u00020#2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u001dH\u0016JU\u00101\u001a\b\u0012\u0004\u0012\u00020302\"\u0006\b\u0000\u00104\u0018\u0001*\u0006\u0012\u0002\b\u0003052/\b\u0004\u00106\u001a)\b\u0001\u0012\u0004\u0012\u0002H4\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030908\u0012\u0006\u0012\u0004\u0018\u00010:07\u00a2\u0006\u0002\b;H\u0082H\u00a2\u0006\u0002\u0010<JM\u0010=\u001a\b\u0012\u0004\u0012\u00020309\"\u0006\b\u0000\u00104\u0018\u00012/\b\u0004\u00106\u001a)\b\u0001\u0012\u0004\u0012\u0002H4\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030908\u0012\u0006\u0012\u0004\u0018\u00010:07\u00a2\u0006\u0002\b;H\u0082H\u00a2\u0006\u0002\u0010>J\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020309H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u001c\u0010@\u001a\b\u0012\u0004\u0012\u000203092\u0006\u0010A\u001a\u00020)H\u0096@\u00a2\u0006\u0002\u0010BJ\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u001dH\u0082@\u00a2\u0006\u0002\u0010\u001fJ\n\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020309H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RH\u0096@\u00a2\u0006\u0002\u0010TJ\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020H092\u0006\u0010S\u001a\u00020RH\u0096@\u00a2\u0006\u0002\u0010TJ \u0010S\u001a\u00020R2\u0006\u0010V\u001a\u00020M2\b\u0010\u001a\u001a\u0004\u0018\u00010MH\u0096@\u00a2\u0006\u0002\u0010WJ\u001e\u0010X\u001a\u00020H2\u0006\u0010Y\u001a\u00020H2\u0006\u0010Z\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010[J\u001e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010Z\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010`J\u001e\u00106\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001092\u0006\u0010Y\u001a\u00020HH\u0096@\u00a2\u0006\u0002\u0010aJ\u0016\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020cH\u0096@\u00a2\u0006\u0002\u0010eJ\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020H\u0018\u0001092\u0006\u0010d\u001a\u00020cH\u0096@\u00a2\u0006\u0002\u0010eJ\u001e\u00106\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001092\u0006\u0010d\u001a\u00020cH\u0096@\u00a2\u0006\u0002\u0010eJ\u0016\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0096@\u00a2\u0006\u0002\u0010iJ\u001c\u00106\u001a\b\u0012\u0004\u0012\u000203092\u0006\u0010h\u001a\u00020gH\u0096@\u00a2\u0006\u0002\u0010iJ\u0016\u0010j\u001a\u00020K2\u0006\u0010k\u001a\u00020KH\u0096@\u00a2\u0006\u0002\u0010lJ\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020H092\u0006\u0010k\u001a\u00020KH\u0096@\u00a2\u0006\u0002\u0010lJ\u001e\u00106\u001a\n\u0012\u0004\u0012\u000203\u0018\u0001092\u0006\u0010k\u001a\u00020KH\u0096@\u00a2\u0006\u0002\u0010lJ\u001e\u0010m\u001a\u00020#2\u0006\u0010V\u001a\u00020M2\u0006\u0010n\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010oJ\u0016\u0010p\u001a\u00020%2\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qJ*\u0010r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020%0s0\u001d2\b\u0010Y\u001a\u0004\u0018\u00010HH\u0096@\u00a2\u0006\u0002\u0010aJ \u0010t\u001a\u00020K2\u0006\u0010u\u001a\u00020)2\b\u0010v\u001a\u0004\u0018\u00010)H\u0096@\u00a2\u0006\u0002\u0010wJ\u0016\u0010|\u001a\u00020#2\u0006\u0010k\u001a\u00020KH\u0096@\u00a2\u0006\u0002\u0010lJ(\u0010}\u001a\u00020#2\u0006\u0010k\u001a\u00020K2\u0006\u0010u\u001a\u00020)2\b\u0010v\u001a\u0004\u0018\u00010)H\u0096@\u00a2\u0006\u0002\u0010~J\"\u0010\u007f\u001a\u00020#2\u0006\u0010k\u001a\u00020K2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010yH\u0096@\u00a2\u0006\u0003\u0010\u0081\u0001J@\u0010\u0082\u0001\u001a\u00020#2\u0006\u0010k\u001a\u00020K2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020H0\u001d2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020H0\u001dH\u0096@\u00a2\u0006\u0003\u0010\u0087\u0001J7\u0010\u0088\u0001\u001a\u00020#2\u0006\u0010k\u001a\u00020K2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020H0\u001d2\u000e\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u001dH\u0096@\u00a2\u0006\u0003\u0010\u008a\u0001J;\u0010\u008b\u0001\u001a\u00020#2\u0006\u0010k\u001a\u00020K2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020H0\u001d2\b\u0010\u008c\u0001\u001a\u00030\u0085\u00012\b\u0010\u008d\u0001\u001a\u00030\u0085\u0001H\u0096@\u00a2\u0006\u0003\u0010\u008e\u0001J(\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u0001092\u0007\u0010\u0091\u0001\u001a\u00020)2\u0006\u0010Y\u001a\u00020HH\u0096@\u00a2\u0006\u0003\u0010\u0092\u0001J\u001b\u0010\u0093\u0001\u001a\u00030\u0090\u00012\b\u0010\u0094\u0001\u001a\u00030\u0090\u0001H\u0096@\u00a2\u0006\u0003\u0010\u0095\u0001J\u001c\u0010\u0097\u0001\u001a\u00020#2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0096@\u00a2\u0006\u0003\u0010\u009a\u0001J\u001a\u0010\u009b\u0001\u001a\u00020#2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0096@\u00a2\u0006\u0003\u0010\u009a\u0001J%\u0010\u009c\u0001\u001a\u00020#2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u009d\u0001\u001a\u00020%H\u0096@\u00a2\u0006\u0003\u0010\u009e\u0001J\u001d\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u00a0\u00012\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0096@\u00a2\u0006\u0003\u0010\u009a\u0001J\u0017\u0010\u00a1\u0001\u001a\u00020)2\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qJ\u0017\u0010\u00a2\u0001\u001a\u00020%2\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qJ\u001a\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a0\u00012\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qJ \u0010\u00a4\u0001\u001a\u00020#2\u0006\u0010V\u001a\u00020M2\u0007\u0010\u00a5\u0001\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010oJ \u0010\u00a6\u0001\u001a\u00020#2\u0006\u0010V\u001a\u00020M2\u0007\u0010\u00a7\u0001\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010oJ\u0017\u0010\u00a8\u0001\u001a\u00020%2\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qJ \u0010\u00a9\u0001\u001a\u00020#2\u0006\u0010V\u001a\u00020M2\u0007\u0010\u00aa\u0001\u001a\u00020%H\u0096@\u00a2\u0006\u0002\u0010oJ\u0017\u0010\u00ab\u0001\u001a\u00020%2\u0006\u0010V\u001a\u00020MH\u0096@\u00a2\u0006\u0002\u0010qR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001dX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001d0-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020D\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u001d0-\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010x\u001a\u00020y\u00a2\u0006\b\n\u0000\u001a\u0004\bz\u0010{R\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010HX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00ad\u0001"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Ldev/brahmkshatriya/echo/common/providers/MusicExtensionsProvider;", "Ldev/brahmkshatriya/echo/common/clients/HomeFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/SearchFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/LibraryFeedClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistClient;", "Ldev/brahmkshatriya/echo/common/clients/AlbumClient;", "Ldev/brahmkshatriya/echo/common/clients/ArtistClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackClient;", "Ldev/brahmkshatriya/echo/common/clients/FollowClient;", "Ldev/brahmkshatriya/echo/common/clients/RadioClient;", "Ldev/brahmkshatriya/echo/common/clients/LikeClient;", "Ldev/brahmkshatriya/echo/common/clients/SaveClient;", "Ldev/brahmkshatriya/echo/common/clients/HideClient;", "Ldev/brahmkshatriya/echo/common/clients/ShareClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistEditClient;", "Ldev/brahmkshatriya/echo/common/clients/PlaylistEditCoverClient;", "Ldev/brahmkshatriya/echo/common/clients/LyricsClient;", "Ldev/brahmkshatriya/echo/common/clients/TrackerMarkClient;", "app", "Ldev/brahmkshatriya/echo/di/App;", "cache", "Landroidx/media3/datasource/cache/SimpleCache;", "<init>", "(Ldev/brahmkshatriya/echo/di/App;Landroidx/media3/datasource/cache/SimpleCache;)V", "context", "Landroid/app/Application;", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/SettingSwitch;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "setSettings", "", "showTabs", "", "getShowTabs", "()Z", "requiredMusicExtensions", "", "getRequiredMusicExtensions", "()Ljava/util/List;", "extFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "extensions", "setMusicExtensions", "getFeedData", "Ldev/brahmkshatriya/echo/common/models/Feed$Data;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "T", "Ldev/brahmkshatriya/echo/common/Extension;", "loadFeed", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Ldev/brahmkshatriya/echo/common/models/Feed;", "", "Lkotlin/ExtensionFunctionType;", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feed", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHomeFeed", "loadSearchFeed", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "db", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase;", "getDb", "()Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase;", "getCached", "Ldev/brahmkshatriya/echo/common/models/Track;", "cachedTracks", "cachePlaylist", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "downloadFeed", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getDownloadFeed", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadLibraryFeed", "loadRadio", "Ldev/brahmkshatriya/echo/common/models/Radio;", "radio", "(Ldev/brahmkshatriya/echo/common/models/Radio;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTracks", "item", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTrack", "track", "isDownload", "(Ldev/brahmkshatriya/echo/common/models/Track;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStreamableMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "streamable", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "(Ldev/brahmkshatriya/echo/common/models/Streamable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAlbum", "Ldev/brahmkshatriya/echo/common/models/Album;", "album", "(Ldev/brahmkshatriya/echo/common/models/Album;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadArtist", "Ldev/brahmkshatriya/echo/common/models/Artist;", "artist", "(Ldev/brahmkshatriya/echo/common/models/Artist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPlaylist", "playlist", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveToLibrary", "shouldSave", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isItemSaved", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listEditablePlaylists", "Lkotlin/Pair;", "createPlaylist", "title", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coverDir", "Ljava/io/File;", "getCoverDir", "()Ljava/io/File;", "deletePlaylist", "editPlaylistMetadata", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "editPlaylistCover", "cover", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTracksToPlaylist", "tracks", "index", "", "new", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;ILjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeTracksFromPlaylist", "indexes", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveTrackInPlaylist", "fromIndex", "toIndex", "(Ldev/brahmkshatriya/echo/common/models/Playlist;Ljava/util/List;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTrackLyrics", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "clientId", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLyrics", "lyrics", "(Ldev/brahmkshatriya/echo/common/models/Lyrics;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "current", "onTrackChanged", "details", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onMarkAsPlayed", "onPlayingStateChanged", "isPlaying", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarkAsPlayedDuration", "", "onShare", "isFollowing", "getFollowersCount", "followItem", "shouldFollow", "likeItem", "shouldLike", "isItemLiked", "hideItem", "shouldHide", "isItemHidden", "Companion", "app_debug"})
@OptIn(markerClass={UnstableApi.class})
@SourceDebugExtension(value={"SMAP\nUnifiedExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 UnifiedExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension$Companion\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 CacheUtils.kt\ndev/brahmkshatriya/echo/utils/CacheUtils\n+ 6 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 7 Json.kt\nkotlinx/serialization/json/Json\n+ 8 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 9 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 10 Cached.kt\ndev/brahmkshatriya/echo/extensions/cache/Cached\n*L\n1#1,689:1\n346#1,4:714\n350#1,2:724\n352#1:730\n346#1,4:731\n350#1,2:741\n352#1:747\n774#2:690\n865#2,2:691\n1563#2:700\n1634#2,3:701\n1563#2:710\n1634#2,3:711\n1563#2:726\n1634#2,3:727\n1563#2:743\n1634#2,3:744\n1617#2,9:748\n1869#2:757\n1870#2:771\n1626#2:772\n1491#2:773\n1516#2,3:774\n1519#2,3:784\n1563#2:815\n1634#2,3:816\n1563#2:903\n1634#2,2:904\n1761#2,3:906\n1636#2:909\n360#2,7:965\n110#3,3:693\n113#3,2:697\n110#3,3:704\n113#3,2:708\n110#3,3:718\n113#3,2:722\n110#3,3:735\n113#3,2:739\n110#3,3:819\n113#3,2:823\n110#3,3:825\n113#3,2:829\n110#3,3:831\n113#3,2:835\n110#3,3:837\n113#3,2:841\n110#3,3:843\n113#3,2:847\n110#3,3:849\n113#3,2:853\n110#3,3:855\n113#3,2:859\n110#3,3:861\n113#3,2:865\n110#3,3:867\n113#3,2:871\n110#3,3:873\n113#3,2:877\n110#3,3:879\n113#3,2:883\n110#3,3:885\n113#3,2:889\n110#3,3:891\n113#3,2:895\n110#3,3:897\n113#3,2:901\n117#3,4:910\n110#3,3:915\n113#3,2:919\n117#3,4:921\n117#3,4:926\n117#3,4:931\n117#3,4:936\n110#3,3:941\n113#3,2:945\n110#3,3:947\n113#3,2:951\n110#3,3:953\n113#3,2:957\n110#3,3:959\n113#3,2:963\n110#3,3:972\n113#3,2:976\n110#3,3:978\n113#3,2:982\n1#4:696\n1#4:699\n1#4:707\n1#4:721\n1#4:738\n1#4:770\n1#4:812\n1#4:822\n1#4:828\n1#4:834\n1#4:840\n1#4:846\n1#4:852\n1#4:858\n1#4:864\n1#4:870\n1#4:876\n1#4:882\n1#4:888\n1#4:894\n1#4:900\n1#4:914\n1#4:918\n1#4:925\n1#4:930\n1#4:935\n1#4:940\n1#4:944\n1#4:950\n1#4:956\n1#4:962\n1#4:975\n1#4:981\n35#5,5:758\n40#5:769\n13#6,2:763\n15#6,3:766\n13#6,2:804\n15#6,3:807\n222#7:765\n222#7:806\n382#8,7:777\n136#9,9:787\n216#9:796\n217#9:813\n145#9:814\n63#10,4:797\n48#10,3:801\n51#10:810\n67#10:811\n*S KotlinDebug\n*F\n+ 1 UnifiedExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension\n*L\n359#1:714,4\n359#1:724,2\n359#1:730\n362#1:731,4\n362#1:741,2\n362#1:747\n308#1:690\n308#1:691,2\n316#1:700\n316#1:701,3\n351#1:710\n351#1:711,3\n359#1:726\n359#1:727,3\n362#1:743\n362#1:744,3\n369#1:748,9\n369#1:757\n369#1:771\n369#1:772\n372#1:773\n372#1:774,3\n372#1:784,3\n394#1:815\n394#1:816,3\n545#1:903\n545#1:904,2\n546#1:906,3\n545#1:909\n669#1:965,7\n314#1:693,3\n314#1:697,2\n349#1:704,3\n349#1:708,2\n359#1:718,3\n359#1:722,2\n362#1:735,3\n362#1:739,2\n422#1:819,3\n422#1:823,2\n430#1:825,3\n430#1:829,2\n437#1:831,3\n437#1:835,2\n446#1:837,3\n446#1:841,2\n455#1:843,3\n455#1:847,2\n463#1:849,3\n463#1:853,2\n470#1:855,3\n470#1:859,2\n478#1:861,3\n478#1:865,2\n486#1:867,3\n486#1:871,2\n493#1:873,3\n493#1:877,2\n501#1:879,3\n501#1:883,2\n510#1:885,3\n510#1:889,2\n523#1:891,3\n523#1:895,2\n532#1:897,3\n532#1:901,2\n602#1:910,4\n609#1:915,3\n609#1:919,2\n619#1:921,4\n625#1:926,4\n631#1:931,4\n636#1:936,4\n642#1:941,3\n642#1:945,2\n648#1:947,3\n648#1:951,2\n654#1:953,3\n654#1:957,2\n660#1:959,3\n660#1:963,2\n681#1:972,3\n681#1:976,2\n687#1:978,3\n687#1:982,2\n314#1:696\n349#1:707\n359#1:721\n362#1:738\n369#1:770\n372#1:812\n422#1:822\n430#1:828\n437#1:834\n446#1:840\n455#1:846\n463#1:852\n470#1:858\n478#1:864\n486#1:870\n493#1:876\n501#1:882\n510#1:888\n523#1:894\n532#1:900\n602#1:914\n609#1:918\n619#1:925\n625#1:930\n631#1:935\n636#1:940\n642#1:944\n648#1:950\n654#1:956\n660#1:962\n681#1:975\n687#1:981\n370#1:758,5\n370#1:769\n370#1:763,2\n370#1:766,3\n374#1:804,2\n374#1:807,3\n370#1:765\n374#1:806\n372#1:777,7\n372#1:787,9\n372#1:796\n372#1:813\n372#1:814\n374#1:797,4\n374#1:801,3\n374#1:810\n374#1:811\n*E\n"})
public final class UnifiedExtension
implements ExtensionClient,
MusicExtensionsProvider,
HomeFeedClient,
SearchFeedClient,
LibraryFeedClient,
PlaylistClient,
AlbumClient,
ArtistClient,
TrackClient,
FollowClient,
RadioClient,
LikeClient,
SaveClient,
HideClient,
ShareClient,
PlaylistEditClient,
PlaylistEditCoverClient,
LyricsClient,
TrackerMarkClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final App app;
    @NotNull
    private final SimpleCache cache;
    @NotNull
    private final Application context;
    private Settings settings;
    @NotNull
    private final List<String> requiredMusicExtensions;
    @NotNull
    private MutableStateFlow<List<MusicExtension>> extFlow;
    @NotNull
    private final UnifiedDatabase db;
    @NotNull
    private List<Track> cachedTracks;
    @NotNull
    private final MutableStateFlow<List<EchoMediaItem>> downloadFeed;
    @NotNull
    private final File coverDir;
    @Nullable
    private Track current;
    @NotNull
    public static final String UNIFIED_ID = "unified";
    @NotNull
    public static final String EXTENSION_ID = "extension_id";
    @NotNull
    private static final dev.brahmkshatriya.echo.common.models.Metadata metadata = new dev.brahmkshatriya.echo.common.models.Metadata("UnifiedExtension", "", ImportType.BuiltIn, ExtensionType.MUSIC, "unified", "Unified Extension", "v1", "All your extensions in one place!", "Echo", null, null, null, null, null, true, 15872, null);

    public UnifiedExtension(@NotNull App app, @NotNull SimpleCache cache) {
        Intrinsics.checkNotNullParameter((Object)app, (String)"app");
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        this.app = app;
        this.cache = cache;
        this.context = this.app.getContext();
        this.requiredMusicExtensions = CollectionsKt.emptyList();
        this.extFlow = StateFlowKt.MutableStateFlow(null);
        this.db = (UnifiedDatabase)Room.databaseBuilder((Context)((Context)this.context), UnifiedDatabase.class, (String)"unified-db").fallbackToDestructiveMigration(true).build();
        this.cachedTracks = CollectionsKt.emptyList();
        this.downloadFeed = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        File file2 = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue((Object)file2, (String)"getFilesDir(...)");
        this.coverDir = FilesKt.resolve((File)file2, (String)"unified-playlist-covers");
    }

    @Nullable
    public Object getSettingItems(@NotNull Continuation<? super List<SettingSwitch>> $completion) {
        String string2 = this.context.getString(R.string.show_tabs);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
        return CollectionsKt.listOf((Object)new SettingSwitch(string2, "show_tabs", this.context.getString(R.string.show_tab_summary), false));
    }

    @Override
    public void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        this.settings = settings;
    }

    private final boolean getShowTabs() {
        Settings settings = this.settings;
        if (settings == null) {
            Intrinsics.throwUninitializedPropertyAccessException((String)"settings");
            settings = null;
        }
        Boolean bl = settings.getBoolean("show_tabs");
        return bl != null ? bl : false;
    }

    @Override
    @NotNull
    public List<String> getRequiredMusicExtensions() {
        return this.requiredMusicExtensions;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object extensions(@NotNull Continuation<? super List<MusicExtension>> $completion) {
        if (!($completion instanceof extensions.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.extensions((Continuation<? super List<MusicExtension>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = FlowKt.first((Flow)((Flow)this.extFlow), (Function2)((Function2)new Function2<List<? extends MusicExtension>, Continuation<? super Boolean>, Object>(null){
                    int label;
                    /* synthetic */ Object L$0;

                    /*
                     * WARNING - void declaration
                     */
                    public final Object invokeSuspend(Object $result) {
                        List list2 = (List)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                void it;
                                ResultKt.throwOnFailure((Object)$result);
                                return Boxing.boxBoolean((it != null ? 1 : 0) != 0);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value2;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(List<MusicExtension> p1, Continuation<? super Boolean> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (Continuation)$continuation);
                if (v0 == var4_4) {
                    return var4_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                Intrinsics.checkNotNull((Object)v0);
                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setMusicExtensions(@NotNull List<MusicExtension> extensions2) {
        void $this$filterTo\2;
        void $this$filter\1;
        Intrinsics.checkNotNullParameter(extensions2, (String)"extensions");
        Iterable iterable = extensions2;
        MutableStateFlow<List<MusicExtension>> mutableStateFlow = this.extFlow;
        boolean bl = false;
        void var4_5 = $this$filter\1;
        Collection collection = new ArrayList();
        boolean bl2 = false;
        for (Object t : $this$filterTo\2) {
            MusicExtension musicExtension = (MusicExtension)t;
            boolean bl3 = false;
            if (!(!Intrinsics.areEqual((Object)musicExtension.getId(), (Object)UNIFIED_ID) && musicExtension.getMetadata().isEnabled())) continue;
            collection.add(t);
        }
        mutableStateFlow.setValue((Object)((List)collection));
    }

    /*
     * WARNING - void declaration
     */
    private final /* synthetic */ <T> Object getFeedData(Extension<?> $this$getFeedData, Function2<? super T, ? super Continuation<? super Feed<Shelf>>, ? extends Object> loadFeed2, Continuation<? super Feed.Data<Shelf>> $completion) {
        Feed.Data data2;
        void $this$mapTo\8;
        void $this$map\7;
        Feed feed2;
        Throwable throwable;
        Object object;
        Feed feed3;
        boolean $i$f$getFeedData = false;
        Companion companion = Companion;
        Extension<?> extension2 = $this$getFeedData;
        Object object2 = Companion;
        boolean bl = false;
        Object object3 = feed3;
        try {
            Iterator iterator;
            object = (Extension)object3;
            boolean bl2 = false;
            Injectable injectable = ((Extension)object).getInstance();
            InlineMarker.mark((int)3);
            InlineMarker.mark((int)0);
            Object object4 = injectable.value-IoAF18A(null);
            InlineMarker.mark((int)1);
            InlineMarker.mark((int)8);
            InlineMarker.mark((int)9);
            Iterator iterator2 = ((Result)object4).unbox-impl();
            ResultKt.throwOnFailure((Object)iterator2);
            Intrinsics.reifiedOperationMarker((int)2, (String)"T");
            Iterator iterator3 = iterator2;
            if (iterator3 == null) {
                Intrinsics.reifiedOperationMarker((int)4, (String)"T");
                KClass kClass = Reflection.getOrCreateKotlinClass(Object.class);
                KClass kClass2 = kClass;
                boolean bl3 = false;
                String string2 = kClass2.getSimpleName();
                if (string2 == null) {
                    string2 = JvmClassMappingKt.getJavaClass((KClass)kClass2).getName();
                }
                String string3 = string2;
                iterator2 = string3;
                Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"run(...)");
                String string4 = (String)((Object)iterator2);
                throw new ClientException.NotSupported(string4);
            }
            Iterator iterator4 = iterator = iterator3;
            boolean bl4 = false;
            InlineMarker.mark((int)3);
            object = Result.constructor-impl((Object)((Feed)loadFeed2.invoke((Object)iterator4, null)));
        }
        catch (Throwable bl2) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl2));
        }
        object3 = object;
        Throwable throwable2 = Result.exceptionOrNull-impl((Object)object3);
        if (throwable2 != null) {
            throwable = throwable2;
            boolean bl5 = false;
            throw AppException.Companion.toAppException(throwable, (Extension<?>)((Object)feed3));
        }
        Object object5 = object3;
        feed3 = feed2 = ((Companion)object2).injectExtensionId((Feed)object5, $this$getFeedData);
        Object object6 = feed3;
        boolean bl6 = false;
        Function2 function2 = ((Feed)object6).getGetPagedData();
        Object object7 = CollectionsKt.firstOrNull(((Feed)object6).getTabs());
        InlineMarker.mark((int)3);
        InlineMarker.mark((int)0);
        Object object8 = function2.invoke(object7, null);
        InlineMarker.mark((int)1);
        Feed.Data data3 = (Feed.Data)object8;
        object6 = CollectionsKt.drop((Iterable)feed2.getTabs(), (int)1);
        boolean bl7 = false;
        throwable = $this$map\7;
        Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
        boolean bl8 = false;
        for (Object t : $this$mapTo\8) {
            void tab\9;
            Tab kClass2 = (Tab)t;
            object2 = collection;
            boolean bl9 = false;
            object5 = new Shelf.Category(tab\9.getId(), tab\9.getTitle(), new Feed(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>((Feed<Shelf>)feed2, (Tab)tab\9, null){
                Object L$0;
                int I$0;
                int label;
                final /* synthetic */ Feed<Shelf> $feed;
                final /* synthetic */ Tab $tab;
                {
                    this.$feed = $feed;
                    this.$tab = $tab;
                    super(2, $completion);
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public final Object invokeSuspend(Object $result) {
                    Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            Feed<Shelf> feed2 = this.$feed;
                            Tab tab = this.$tab;
                            Feed<Shelf> feed3 = feed2;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(feed3);
                            this.I$0 = n;
                            this.label = 1;
                            Object object2 = feed3.getGetPagedData().invoke((Object)tab, (Object)((Object)this));
                            if (object2 != object) return (Feed.Data)object2;
                            return object;
                        }
                        case 1: {
                            int n = this.I$0;
                            Feed feed4 = (Feed)this.L$0;
                            ResultKt.throwOnFailure((Object)$result);
                            Object object2 = $result;
                            return (Feed.Data)object2;
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
            }), null, null, null, null, 120, null);
            object2.add(object5);
        }
        List otherTabs2 = (List)collection;
        if (feed2.getTabs().size() > 1 && this.getShowTabs()) {
            Object object9 = new PagedData[]{new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(this, (List<Shelf.Category>)otherTabs2, null){
                int label;
                final /* synthetic */ UnifiedExtension this$0;
                final /* synthetic */ List<Shelf.Category> $otherTabs;
                {
                    this.this$0 = $receiver;
                    this.$otherTabs = $otherTabs;
                    super(1, $completion);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            String string2 = UnifiedExtension.access$getContext$p(this.this$0).getString(R.string.tabs);
                            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
                            return CollectionsKt.listOf((Object)new Shelf.Lists.Categories("tabs", string2, this.$otherTabs, null, null, null, null, 120, null));
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
            }), data3.getPagedData()};
            PagedData pagedData2 = new PagedData.Concat(object9);
            object9 = data3.getButtons();
            Feed.Buttons buttons2 = object9 != null ? Companion.withExtensionId((Feed.Buttons)object9, $this$getFeedData) : null;
            data2 = new Feed.Data(pagedData2, buttons2, data3.getBackground());
        } else {
            data2 = data3;
        }
        return data2;
    }

    /*
     * WARNING - void declaration
     */
    private final /* synthetic */ <T> Object feed(Function2<? super T, ? super Continuation<? super Feed<Shelf>>, ? extends Object> loadFeed2, Continuation<? super Feed<Shelf>> $completion) {
        Feed feed2;
        boolean $i$f$feed = false;
        InlineMarker.mark((int)0);
        Object object = this.extensions($completion);
        InlineMarker.mark((int)1);
        List list2 = (List)object;
        if (list2.size() == 1) {
            Object object2;
            void $this$client\1;
            MusicExtension ext = (MusicExtension)CollectionsKt.first((List)list2);
            Companion companion = Companion;
            Extension extension2 = ext;
            Companion companion2 = Companion;
            boolean bl = false;
            Object object3 = $this$client\1;
            try {
                Object object4;
                object2 = (Extension)object3;
                boolean bl2 = false;
                Injectable injectable = ((Extension)object2).getInstance();
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                Object object5 = injectable.value-IoAF18A(null);
                InlineMarker.mark((int)1);
                InlineMarker.mark((int)8);
                InlineMarker.mark((int)9);
                Object object6 = ((Result)object5).unbox-impl();
                ResultKt.throwOnFailure((Object)object6);
                Intrinsics.reifiedOperationMarker((int)2, (String)"T");
                Object object7 = object6;
                if (object7 == null) {
                    Intrinsics.reifiedOperationMarker((int)4, (String)"T");
                    KClass kClass = Reflection.getOrCreateKotlinClass(Object.class);
                    KClass kClass2 = kClass;
                    boolean bl3 = false;
                    String string2 = kClass2.getSimpleName();
                    if (string2 == null) {
                        string2 = JvmClassMappingKt.getJavaClass((KClass)kClass2).getName();
                    }
                    String string3 = string2;
                    object6 = string3;
                    Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"run(...)");
                    String string4 = (String)object6;
                    throw new ClientException.NotSupported(string4);
                }
                Object object8 = object4 = object7;
                boolean bl4 = false;
                InlineMarker.mark((int)3);
                object2 = Result.constructor-impl((Object)((Feed)loadFeed2.invoke(object8, null)));
            }
            catch (Throwable bl2) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl2));
            }
            object3 = object2;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object3);
            if (throwable != null) {
                Throwable throwable2 = throwable;
                boolean bl5 = false;
                throw AppException.Companion.toAppException(throwable2, (Extension<?>)$this$client\1);
            }
            Object object9 = object3;
            feed2 = companion2.injectExtensionId((Feed)object9, (Extension)ext);
        } else {
            Collection<Tab> collection;
            void $this$mapTo\7;
            void $this$map\6;
            Iterable ext = list2;
            boolean bl = false;
            void $this$client\1 = $this$map\6;
            Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\6, (int)10));
            boolean bl6 = false;
            for (Object t : $this$mapTo\7) {
                void it\8;
                MusicExtension musicExtension = (MusicExtension)t;
                collection = collection2;
                boolean bl7 = false;
                Tab tab = Companion.injectId(new Tab(it\8.getId(), it\8.getName(), false, null, 12, null), it\8.getId());
                collection.add(tab);
            }
            collection = (List)collection2;
            Intrinsics.needClassReification();
            Function2 function2 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this, loadFeed2, null){
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
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ UnifiedExtension this$0;
                final /* synthetic */ Function2<T, Continuation<? super Feed<Shelf>>, Object> $loadFeed;
                {
                    this.this$0 = $receiver;
                    this.$loadFeed = $loadFeed;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var27_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            this.L$0 = tab;
                            this.label = 1;
                            v0 = this.this$0.extensions((Continuation<? super List<MusicExtension>>)((Continuation)this));
                            if (v0 == var27_3) {
                                return var27_3;
                            }
                            ** GOTO lbl15
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl15:
                            // 2 sources

                            extensions = (List)v0;
                            v1 = tab;
                            if (v1 == null || (v1 = v1.getExtras()) == null || (v1 = UnifiedExtension.Companion.getExtensionId((Map<String, String>)v1)) == null) {
                                v2 = (MusicExtension)CollectionsKt.firstOrNull((List)extensions);
                                v1 = v2 != null ? v2.getId() : null;
                            }
                            id = v1;
                            var5_6 = this.this$0;
                            var6_7 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(UnifiedExtension.Companion, extensions, (String)id);
                            loadFeed\1 = this.$loadFeed;
                            $i$f$getFeedData\1\355 = 0;
                            var9_10 = UnifiedExtension.Companion;
                            var10_11 = $this$getFeedData\1;
                            var11_12 = UnifiedExtension.Companion;
                            $i$f$client\2\690 = 0;
                            var13_15 = $this$client\2;
                            $this$client_u24lambda_u244\3 = var13_15;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$3 = this_\1;
                            this.L$4 = $this$getFeedData\1;
                            this.L$5 = loadFeed\1;
                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$7 = $this$client\2;
                            this.L$8 = var11_12;
                            this.L$9 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.label = 2;
                            v3 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A(this);
                            ** if (v3 != var27_3) goto lbl52
lbl51:
                            // 1 sources

                            return var27_3;
lbl52:
                            // 1 sources

                            ** GOTO lbl70
                        }
                        case 2: {
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$9;
                            var11_12 = (Companion)this.L$8;
                            $this$client\2 = (Extension)this.L$7;
                            this_\2 = (Companion)this.L$6;
                            loadFeed\1 = (Function2)this.L$5;
                            $this$getFeedData\1 = (Extension)this.L$4;
                            this_\1 = (UnifiedExtension)this.L$3;
                            id = (String)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = ((Result)$result).unbox-impl();
lbl70:
                            // 2 sources

                            var16_21 = v3;
                            ResultKt.throwOnFailure((Object)var16_21);
                            Intrinsics.reifiedOperationMarker((int)2, (String)"T");
                            v4 = var16_21;
                            if (v4 == null) {
                                Intrinsics.reifiedOperationMarker((int)4, (String)"T");
                                $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(Object.class);
                                $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\693\3 = false;
                                v5 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                                if (v5 == null) {
                                    v5 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                                }
                                Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"run(...)");
                                var26_26 = v5;
                                throw new ClientException.NotSupported(var26_26);
                            }
                            $this$getFeedData_u24lambda_u241\5 = client\3 = v4;
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$3 = this_\1;
                            this.L$4 = $this$getFeedData\1;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)loadFeed\1);
                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$7 = $this$client\2;
                            this.L$8 = var11_12;
                            this.L$9 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.L$10 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                            this.L$11 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u241\5);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.I$3 = $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1;
                            this.label = 3;
                            v6 = loadFeed\1.invoke($this$getFeedData_u24lambda_u241\5, (Object)this);
                            ** if (v6 != var27_3) goto lbl107
lbl106:
                            // 1 sources

                            return var27_3;
lbl107:
                            // 1 sources

                            ** GOTO lbl129
                        }
                        case 3: {
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = this.I$3;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$getFeedData_u24lambda_u241\5 = this.L$11;
                            client\3 = this.L$10;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$9;
                            var11_12 = (Companion)this.L$8;
                            $this$client\2 = (Extension)this.L$7;
                            this_\2 = (Companion)this.L$6;
                            loadFeed\1 = (Function2)this.L$5;
                            $this$getFeedData\1 = (Extension)this.L$4;
                            this_\1 = (UnifiedExtension)this.L$3;
                            id = (String)this.L$2;
                            extensions = (List)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v6 = $result;
lbl129:
                                // 2 sources

                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v6));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2) {
                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2));
                            }
                            var13_15 = $this$client_u24lambda_u244\3;
                            v7 = Result.exceptionOrNull-impl((Object)var13_15);
                            if (v7 != null) {
                                it\6 = v7;
                                $i$a$-getOrElse-UnifiedExtension$Companion$client$3\6\696\2 = false;
                                throw AppException.Companion.toAppException((Throwable)it\6, $this$client\2);
                            }
                            $this$getFeedData_u24lambda_u242\7 = feed\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId((Companion)var11_12, (Feed)var13_15, $this$getFeedData\1);
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$3 = this_\1;
                            this.L$4 = $this$getFeedData\1;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)loadFeed\1);
                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u242\7);
                            this.L$7 = feed\1;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.L$10 = null;
                            this.L$11 = null;
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1;
                            this.label = 4;
                            v8 = $this$getFeedData_u24lambda_u242\7.getGetPagedData().invoke(CollectionsKt.firstOrNull($this$getFeedData_u24lambda_u242\7.getTabs()), (Object)this);
                            if (v8 == var27_3) {
                                return var27_3;
                            }
                            ** GOTO lbl174
                        }
                        case 4: {
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            feed\1 = (Feed)this.L$7;
                            $this$getFeedData_u24lambda_u242\7 = (Feed)this.L$6;
                            loadFeed\1 = (Function2)this.L$5;
                            $this$getFeedData\1 = (Extension)this.L$4;
                            this_\1 = (UnifiedExtension)this.L$3;
                            id = (String)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v8 = $result;
lbl174:
                            // 2 sources

                            data\1 = (Feed.Data)v8;
                            $this$map\8 = CollectionsKt.drop((Iterable)feed\1.getTabs(), (int)1);
                            $i$f$map\8\698 = false;
                            it\6 = $this$map\8;
                            destination\9 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                            $i$f$mapTo\9\699 = false;
                            for (T item\9 : $this$mapTo\9) {
                                $this$client_u24lambda_u244_u24lambda_u243\4 = (Tab)item\9;
                                var11_12 = destination\9;
                                $i$a$-map-UnifiedExtension$getFeedData$otherTabs$1\10\701\1 = false;
                                var11_12.add(new Shelf.Category(tab\10.getId(), tab\10.getTitle(), new Feed<T>(CollectionsKt.emptyList(), (Function2)new /* invalid duplicate definition of identical inner class */), null, null, null, null, 120, null));
                            }
                            otherTabs\1 = (List)destination\9;
                            if (feed\1.getTabs().size() > 1 && UnifiedExtension.access$getShowTabs(this_\1)) {
                                var12_14 = new PagedData[]{new PagedData.Single<T>((Function1)new /* invalid duplicate definition of identical inner class */), data\1.getPagedData()};
                                v9 = new PagedData.Concat<T>(var12_14);
                                v10 = data\1.getButtons();
                                v11 = new Feed.Data<T>(v9, v10 != null ? UnifiedExtension.Companion.withExtensionId(v10, $this$getFeedData\1) : null, data\1.getBackground());
                            } else {
                                v11 = data\1;
                            }
                            return v11;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                /*
                 * WARNING - void declaration
                 */
                public final Object invokeSuspend$$forInline(Object $result) {
                    Feed.Data data2;
                    void this_\1;
                    void $this$mapTo\9;
                    void $this$map\8;
                    Feed feed2;
                    Throwable throwable;
                    Object object;
                    Feed feed3;
                    void $this$getFeedData\1;
                    Function2<T, Continuation<Feed<Shelf>>, Object> function2;
                    Object object2;
                    Object object3;
                    void tab;
                    Tab tab2 = (Tab)this.L$0;
                    InlineMarker.mark((int)10);
                    Continuation continuation = (Continuation)this;
                    InlineMarker.mark((int)0);
                    Object object4 = this.this$0.extensions((Continuation<? super List<MusicExtension>>)continuation);
                    InlineMarker.mark((int)1);
                    List extensions2 = (List)object4;
                    String id2 = tab != null && (object3 = tab.getExtras()) != null && (object2 = UnifiedExtension.Companion.getExtensionId((Map<String, String>)object3)) != null ? object2 : ((function2 = (Function2<T, Continuation<Feed<Shelf>>, Object>)CollectionsKt.firstOrNull((List)extensions2)) != null ? function2.getId() : null);
                    object3 = this.this$0;
                    object2 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(UnifiedExtension.Companion, extensions2, id2);
                    function2 = this.$loadFeed;
                    boolean bl = false;
                    Companion companion = UnifiedExtension.Companion;
                    void var10_10 = $this$getFeedData\1;
                    Object object5 = UnifiedExtension.Companion;
                    boolean bl2 = false;
                    Object object6 = feed3;
                    try {
                        void loadFeed\1;
                        Iterator<T> iterator;
                        object = (Extension)object6;
                        boolean bl3 = false;
                        Injectable<T> injectable = ((Extension)object).getInstance();
                        InlineMarker.mark((int)3);
                        InlineMarker.mark((int)0);
                        Object object7 = injectable.value-IoAF18A(null);
                        InlineMarker.mark((int)1);
                        InlineMarker.mark((int)8);
                        InlineMarker.mark((int)9);
                        Iterator<T> iterator2 = ((Result)object7).unbox-impl();
                        ResultKt.throwOnFailure((Object)iterator2);
                        Intrinsics.reifiedOperationMarker((int)2, (String)"T");
                        Iterator<T> iterator3 = iterator2;
                        if (iterator3 == null) {
                            Intrinsics.reifiedOperationMarker((int)4, (String)"T");
                            KClass kClass = Reflection.getOrCreateKotlinClass(Object.class);
                            KClass kClass2 = kClass;
                            boolean bl4 = false;
                            String string2 = kClass2.getSimpleName();
                            if (string2 == null) {
                                string2 = JvmClassMappingKt.getJavaClass((KClass)kClass2).getName();
                            }
                            String string3 = string2;
                            iterator2 = string3;
                            Intrinsics.checkNotNullExpressionValue((Object)iterator2, (String)"run(...)");
                            String string4 = (String)((Object)iterator2);
                            throw new ClientException.NotSupported(string4);
                        }
                        Iterator<T> iterator4 = iterator = iterator3;
                        boolean bl5 = false;
                        InlineMarker.mark((int)3);
                        object = Result.constructor-impl((Object)((Feed)loadFeed\1.invoke((Object)iterator4, null)));
                    }
                    catch (Throwable bl3) {
                        object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl3));
                    }
                    object6 = object;
                    Throwable throwable2 = Result.exceptionOrNull-impl((Object)object6);
                    if (throwable2 != null) {
                        throwable = throwable2;
                        boolean bl6 = false;
                        throw AppException.Companion.toAppException(throwable, (Extension<?>)((Object)feed3));
                    }
                    Object object8 = object6;
                    feed3 = feed2 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId((Companion)object5, (Feed)object8, (Extension)$this$getFeedData\1);
                    Object object9 = feed3;
                    boolean bl7 = false;
                    Function2<Tab, Continuation<Feed.Data<T>>, Object> function22 = ((Feed)object9).getGetPagedData();
                    Object object10 = CollectionsKt.firstOrNull(((Feed)object9).getTabs());
                    InlineMarker.mark((int)3);
                    InlineMarker.mark((int)0);
                    Object object11 = function22.invoke(object10, null);
                    InlineMarker.mark((int)1);
                    Feed.Data data3 = (Feed.Data)object11;
                    object9 = CollectionsKt.drop((Iterable)feed2.getTabs(), (int)1);
                    boolean bl8 = false;
                    throwable = $this$map\8;
                    Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                    boolean bl9 = false;
                    for (T t : $this$mapTo\9) {
                        void tab\10;
                        Tab kClass2 = (Tab)t;
                        object5 = collection;
                        boolean bl10 = false;
                        object8 = new Shelf.Category(tab\10.getId(), tab\10.getTitle(), new Feed<T>(CollectionsKt.emptyList(), (Function2)new /* invalid duplicate definition of identical inner class */), null, null, null, null, 120, null);
                        object5.add(object8);
                    }
                    List list2 = (List)collection;
                    if (feed2.getTabs().size() > 1 && UnifiedExtension.access$getShowTabs((UnifiedExtension)this_\1)) {
                        Object object12 = new PagedData[]{new PagedData.Single<T>((Function1)new /* invalid duplicate definition of identical inner class */), data3.getPagedData()};
                        PagedData pagedData2 = new PagedData.Concat<T>(object12);
                        object12 = data3.getButtons();
                        Feed.Buttons buttons2 = object12 != null ? UnifiedExtension.Companion.withExtensionId((Feed.Buttons)object12, (Extension<?>)$this$getFeedData\1) : null;
                        data2 = new Feed.Data<T>(pagedData2, buttons2, data3.getBackground());
                    } else {
                        data2 = data3;
                    }
                    return data2;
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
            List list3 = collection;
            feed2 = new Feed(list3, function2);
        }
        return feed2;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadHomeFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        block20: {
            if (!($completion instanceof loadHomeFeed.1)) ** GOTO lbl-1000
            var24_2 = $completion;
            if ((var24_2.label & -2147483648) != 0) {
                var24_2.label -= -2147483648;
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
                    Object L$10;
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    /* synthetic */ Object result;
                    final /* synthetic */ UnifiedExtension this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadHomeFeed((Continuation<? super Feed<Shelf>>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var28_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    this_\1 = this;
                    $i$f$feed\1\359 = 0;
                    $continuation.L$0 = this_\1;
                    $continuation.I$0 = $i$f$feed\1\359;
                    $continuation.label = 1;
                    v0 = this_\1.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                    if (v0 == var28_4) {
                        return var28_4;
                    }
                    ** GOTO lbl26
                }
                case 1: {
                    $i$f$feed\1\359 = $continuation.I$0;
                    this_\1 = (UnifiedExtension)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl26:
                    // 2 sources

                    if ((list\1 = (List)v0).size() != 1) break;
                    ext\1 = (MusicExtension)CollectionsKt.first((List)list\1);
                    var6_13 = UnifiedExtension.Companion;
                    var7_16 = ext\1;
                    var8_18 = UnifiedExtension.Companion;
                    $i$f$client\2\717 = 0;
                    var10_22 = $this$client\2;
                    $this$client_u24lambda_u244\3 = var10_22;
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)list\1);
                    $continuation.L$2 = ext\1;
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                    $continuation.L$4 = $this$client\2;
                    $continuation.L$5 = var8_18;
                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                    $continuation.I$0 = $i$f$feed\1\359;
                    $continuation.I$1 = $i$f$client\2\717;
                    $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2;
                    $continuation.label = 2;
                    v1 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A($continuation);
                    ** if (v1 != var28_4) goto lbl52
lbl51:
                    // 1 sources

                    return var28_4;
lbl52:
                    // 1 sources

                    ** GOTO lbl68
                }
                case 2: {
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2 = $continuation.I$2;
                    $i$f$client\2\717 = $continuation.I$1;
                    $i$f$feed\1\359 = $continuation.I$0;
                    $this$client_u24lambda_u244\3 = (Extension)$continuation.L$6;
                    var8_18 = (Companion)$continuation.L$5;
                    $this$client\2 = (Extension)$continuation.L$4;
                    this_\2 = (Companion)$continuation.L$3;
                    ext\1 = (MusicExtension)$continuation.L$2;
                    list\1 = (List)$continuation.L$1;
                    this_\1 = (UnifiedExtension)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = ((Result)$result).unbox-impl();
lbl68:
                    // 2 sources

                    var13_29 = v1;
                    ResultKt.throwOnFailure((Object)var13_29);
                    v2 = var13_29;
                    if (!(v2 instanceof HomeFeedClient)) {
                        v2 = null;
                    }
                    v3 = (HomeFeedClient)v2;
                    if (v3 == null) {
                        $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(HomeFeedClient.class);
                        $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\720\3 = false;
                        v4 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                        if (v4 == null) {
                            v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                        }
                        Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                        var25_33 = v4;
                        throw new ClientException.NotSupported(var25_33);
                    }
                    $this$feed_u24lambda_u244\5 = client\3 = v3;
                    $i$a$-client-UnifiedExtension$feed$2\5\722\1 = 0;
                    var20_40 = (Continuation)$continuation;
                    $this$loadHomeFeed_u24lambda_u246\10 = $this$feed_u24lambda_u244\5;
                    $i$a$-feed-UnifiedExtension$loadHomeFeed$2\10\717\0 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)list\1);
                    $continuation.L$2 = ext\1;
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                    $continuation.L$4 = $this$client\2;
                    $continuation.L$5 = var8_18;
                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                    $continuation.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$feed_u24lambda_u244\5);
                    $continuation.L$9 = SpillingKt.nullOutSpilledVariable((Object)$completion\10);
                    $continuation.L$10 = SpillingKt.nullOutSpilledVariable((Object)$this$loadHomeFeed_u24lambda_u246\10);
                    $continuation.I$0 = $i$f$feed\1\359;
                    $continuation.I$1 = $i$f$client\2\717;
                    $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2;
                    $continuation.I$3 = $i$a$-client-UnifiedExtension$feed$2\5\722\1;
                    $continuation.I$4 = $i$a$-feed-UnifiedExtension$loadHomeFeed$2\10\717\0;
                    $continuation.label = 3;
                    v5 = $this$loadHomeFeed_u24lambda_u246\10.loadHomeFeed((Continuation<? super Feed<Shelf>>)$continuation);
                    ** if (v5 != var28_4) goto lbl109
lbl108:
                    // 1 sources

                    return var28_4;
lbl109:
                    // 1 sources

                    ** GOTO lbl133
                }
                case 3: {
                    $i$a$-feed-UnifiedExtension$loadHomeFeed$2\10\717\0 = $continuation.I$4;
                    $i$a$-client-UnifiedExtension$feed$2\5\722\1 = $continuation.I$3;
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2 = $continuation.I$2;
                    $i$f$client\2\717 = $continuation.I$1;
                    $i$f$feed\1\359 = $continuation.I$0;
                    $this$loadHomeFeed_u24lambda_u246\10 = (HomeFeedClient)$continuation.L$10;
                    $completion\10 = (Continuation)$continuation.L$9;
                    $this$feed_u24lambda_u244\5 = (HomeFeedClient)$continuation.L$8;
                    client\3 = (HomeFeedClient)$continuation.L$7;
                    $this$client_u24lambda_u244\3 = (Extension)$continuation.L$6;
                    var8_18 = (Companion)$continuation.L$5;
                    $this$client\2 = (Extension)$continuation.L$4;
                    this_\2 = (Companion)$continuation.L$3;
                    ext\1 = (MusicExtension)$continuation.L$2;
                    list\1 = (List)$continuation.L$1;
                    this_\1 = (UnifiedExtension)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v5 = $result;
lbl133:
                        // 2 sources

                        $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v5));
                    }
                    catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2) {
                        $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\718\2));
                    }
                    var10_22 = $this$client_u24lambda_u244\3;
                    v6 = Result.exceptionOrNull-impl((Object)var10_22);
                    if (v6 != null) {
                        it\6 = v6;
                        $i$a$-getOrElse-UnifiedExtension$Companion$client$3\6\723\2 = false;
                        throw AppException.Companion.toAppException(it\6, $this$client\2);
                    }
                    v7 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(var8_18, (Feed)var10_22, (Extension)ext\1);
                    break block20;
                }
            }
            $this$map\7 = list\1;
            $i$f$map\7\725 = false;
            $this$client\2 = $this$map\7;
            destination\8 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
            $i$f$mapTo\8\726 = false;
            for (T item\8 : $this$mapTo\8) {
                var13_30 = (MusicExtension)item\8;
                var20_42 = destination\8;
                $i$a$-map-UnifiedExtension$feed$3\9\728\1 = false;
                var20_42.add(UnifiedExtension.Companion.injectId(new Tab(it\9.getId(), it\9.getName(), false, null, 12, null), it\9.getId()));
            }
            var26_48 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this_\1, null){
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
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ UnifiedExtension this$0;
                Object L$12;
                int I$4;
                {
                    this.this$0 = $receiver;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            this.L$0 = tab;
                            this.label = 1;
                            v0 = this.this$0.extensions((Continuation<? super List<MusicExtension>>)((Continuation)this));
                            if (v0 == var3_3) {
                                return var3_3;
                            }
                            ** GOTO lbl15
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl15:
                            // 2 sources

                            extensions = (List)v0;
                            v1 = tab;
                            if (v1 == null || (v1 = v1.getExtras()) == null || (v1 = UnifiedExtension.Companion.getExtensionId((Map<String, String>)v1)) == null) {
                                v2 = var7_5 = (MusicExtension)CollectionsKt.firstOrNull((List)extensions);
                                v1 = v2 != null ? v2.getId() : null;
                            }
                            id = v1;
                            var5_7 = this.this$0;
                            $this$getFeedData\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(UnifiedExtension.Companion, extensions, (String)id);
                            $i$f$getFeedData\1\355 = 0;
                            var10_10 = UnifiedExtension.Companion;
                            var11_11 = $this$getFeedData\1;
                            var12_12 = UnifiedExtension.Companion;
                            $i$f$client\2\690 = 0;
                            var14_15 = $this$client\2;
                            $this$client_u24lambda_u244\3 = var14_15;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$6 = $this$client\2;
                            this.L$7 = var12_12;
                            this.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.label = 2;
                            v3 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A(this);
                            ** if (v3 != var3_3) goto lbl50
lbl49:
                            // 1 sources

                            return var3_3;
lbl50:
                            // 1 sources

                            ** GOTO lbl67
                        }
                        case 2: {
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$8;
                            var12_12 = (Companion)this.L$7;
                            $this$client\2 = (Extension)this.L$6;
                            this_\2 = (Companion)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = ((Result)$result).unbox-impl();
lbl67:
                            // 2 sources

                            var17_21 = v3;
                            ResultKt.throwOnFailure((Object)var17_21);
                            v4 = var17_21;
                            if (!(v4 instanceof HomeFeedClient)) {
                                v4 = null;
                            }
                            v5 = (HomeFeedClient)v4;
                            if (v5 == null) {
                                $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(HomeFeedClient.class);
                                $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\693\3 = false;
                                v6 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                                if (v6 == null) {
                                    v6 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                                }
                                Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"run(...)");
                                var22_26 = v6;
                                throw new ClientException.NotSupported(var22_26);
                            }
                            $this$getFeedData_u24lambda_u241\5 = client\3 = v5;
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = 0;
                            var26_30 = (Continuation)this;
                            $this$loadHomeFeed_u24lambda_u246\5 = $this$getFeedData_u24lambda_u241\5;
                            $i$a$-feed-UnifiedExtension$loadHomeFeed$2\5\690\0 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$6 = $this$client\2;
                            this.L$7 = var12_12;
                            this.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.L$9 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                            this.L$10 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u241\5);
                            this.L$11 = SpillingKt.nullOutSpilledVariable((Object)$completion\5);
                            this.L$12 = SpillingKt.nullOutSpilledVariable((Object)$this$loadHomeFeed_u24lambda_u246\5);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.I$3 = $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1;
                            this.I$4 = $i$a$-feed-UnifiedExtension$loadHomeFeed$2\5\690\0;
                            this.label = 3;
                            v7 = $this$loadHomeFeed_u24lambda_u246\5.loadHomeFeed((Continuation<? super Feed<Shelf>>)this);
                            ** if (v7 != var3_3) goto lbl110
lbl109:
                            // 1 sources

                            return var3_3;
lbl110:
                            // 1 sources

                            ** GOTO lbl135
                        }
                        case 3: {
                            $i$a$-feed-UnifiedExtension$loadHomeFeed$2\5\690\0 = this.I$4;
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = this.I$3;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$loadHomeFeed_u24lambda_u246\5 = (HomeFeedClient)this.L$12;
                            $completion\5 = (Continuation)this.L$11;
                            $this$getFeedData_u24lambda_u241\5 = (HomeFeedClient)this.L$10;
                            client\3 = (HomeFeedClient)this.L$9;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$8;
                            var12_12 = (Companion)this.L$7;
                            $this$client\2 = (Extension)this.L$6;
                            this_\2 = (Companion)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v7 = $result;
lbl135:
                                // 2 sources

                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v7));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2) {
                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2));
                            }
                            var14_15 = $this$client_u24lambda_u244\3;
                            v8 = Result.exceptionOrNull-impl((Object)var14_15);
                            if (v8 != null) {
                                it\7 = v8;
                                $i$a$-getOrElse-UnifiedExtension$Companion$client$3\7\697\3 = false;
                                throw AppException.Companion.toAppException((Throwable)it\7, $this$client\2);
                            }
                            $this$getFeedData_u24lambda_u242\8 = feed\2 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId((Companion)var12_12, (Feed)var14_15, $this$getFeedData\1);
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u242\8);
                            this.L$6 = feed\2;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.L$10 = null;
                            this.L$11 = null;
                            this.L$12 = null;
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2;
                            this.label = 4;
                            v9 = $this$getFeedData_u24lambda_u242\8.getGetPagedData().invoke(CollectionsKt.firstOrNull($this$getFeedData_u24lambda_u242\8.getTabs()), (Object)this);
                            if (v9 == var3_3) {
                                return var3_3;
                            }
                            ** GOTO lbl180
                        }
                        case 4: {
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            feed\2 = (Feed)this.L$6;
                            $this$getFeedData_u24lambda_u242\8 = (Feed)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v9 = $result;
lbl180:
                            // 2 sources

                            data\2 = (Feed.Data)v9;
                            $this$map\9 = CollectionsKt.drop((Iterable)feed\2.getTabs(), (int)1);
                            $i$f$map\9\699 = false;
                            it\7 = $this$map\9;
                            destination\10 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\9, (int)10));
                            $i$f$mapTo\10\700 = false;
                            for (T item\10 : $this$mapTo\10) {
                                $this$client_u24lambda_u244_u24lambda_u243\4 = (Tab)item\10;
                                var12_12 = destination\10;
                                $i$a$-map-UnifiedExtension$getFeedData$otherTabs$1\11\702\2 = false;
                                var12_12.add(new Shelf.Category(tab\11.getId(), tab\11.getTitle(), new Feed<T>(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(feed\2, (Tab)tab\11, null){
                                    Object L$0;
                                    int I$0;
                                    int label;
                                    final /* synthetic */ Feed $feed;
                                    final /* synthetic */ Tab $tab;
                                    {
                                        this.$feed = $feed;
                                        this.$tab = $tab;
                                        super(2, $completion);
                                    }

                                    /*
                                     * Enabled force condition propagation
                                     * Lifted jumps to return sites
                                     */
                                    public final Object invokeSuspend(Object $result) {
                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                Feed feed2 = this.$feed;
                                                Tab tab = this.$tab;
                                                Feed feed3 = feed2;
                                                int n = 0;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)feed3);
                                                this.I$0 = n;
                                                this.label = 1;
                                                Object object2 = feed3.getGetPagedData().invoke((Object)tab, (Object)((Object)this));
                                                Object object3 = object2;
                                                if (object2 != object) return (Feed.Data)object3;
                                                return object;
                                            }
                                            case 1: {
                                                int n = this.I$0;
                                                Feed feed4 = (Feed)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                Object object3 = $result;
                                                return (Feed.Data)object3;
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
                                }), null, null, null, null, 120, null));
                            }
                            otherTabs\2 = (List)destination\10;
                            if (feed\2.getTabs().size() > 1 && UnifiedExtension.access$getShowTabs(this_\1)) {
                                var13_14 = new PagedData[]{new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(this_\1, otherTabs\2, null){
                                    int label;
                                    final /* synthetic */ UnifiedExtension this$0;
                                    final /* synthetic */ List $otherTabs;
                                    {
                                        this.this$0 = $receiver;
                                        this.$otherTabs = $otherTabs;
                                        super(1, $completion);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                String string2 = UnifiedExtension.access$getContext$p(this.this$0).getString(R.string.tabs);
                                                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
                                                return CollectionsKt.listOf((Object)new Shelf.Lists.Categories("tabs", string2, this.$otherTabs, null, null, null, null, 120, null));
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
                                }), data\2.getPagedData()};
                                v10 = new PagedData.Concat<T>(var13_14);
                                v11 = data\2.getButtons();
                                v12 = new Feed.Data<T>(v10, v11 != null ? UnifiedExtension.Companion.withExtensionId(v11, $this$getFeedData\1) : null, data\2.getBackground());
                            } else {
                                v12 = data\2;
                            }
                            return v12;
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
            var27_49 = (List)destination\8;
            v7 = new Feed(var27_49, var26_48);
        }
        return v7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadSearchFeed(@NotNull String query, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        block20: {
            if (!($completion instanceof loadSearchFeed.1)) ** GOTO lbl-1000
            var25_3 = $completion;
            if ((var25_3.label & -2147483648) != 0) {
                var25_3.label -= -2147483648;
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
                    Object L$10;
                    Object L$11;
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    /* synthetic */ Object result;
                    final /* synthetic */ UnifiedExtension this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadSearchFeed(null, (Continuation<? super Feed<Shelf>>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var29_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    this_\1 = this;
                    $i$f$feed\1\362 = 0;
                    $continuation.L$0 = query;
                    $continuation.L$1 = this_\1;
                    $continuation.I$0 = $i$f$feed\1\362;
                    $continuation.label = 1;
                    v0 = this_\1.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                    if (v0 == var29_5) {
                        return var29_5;
                    }
                    ** GOTO lbl28
                }
                case 1: {
                    $i$f$feed\1\362 = $continuation.I$0;
                    this_\1 = (UnifiedExtension)$continuation.L$1;
                    query = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl28:
                    // 2 sources

                    if ((list\1 = (List)v0).size() != 1) break;
                    ext\1 = (MusicExtension)CollectionsKt.first((List)list\1);
                    var7_14 = UnifiedExtension.Companion;
                    var8_17 = ext\1;
                    var9_19 = UnifiedExtension.Companion;
                    $i$f$client\2\734 = 0;
                    var11_23 = $this$client\2;
                    $this$client_u24lambda_u244\3 = var11_23;
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2 = 0;
                    $continuation.L$0 = query;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)list\1);
                    $continuation.L$3 = ext\1;
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                    $continuation.L$5 = $this$client\2;
                    $continuation.L$6 = var9_19;
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                    $continuation.I$0 = $i$f$feed\1\362;
                    $continuation.I$1 = $i$f$client\2\734;
                    $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2;
                    $continuation.label = 2;
                    v1 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A($continuation);
                    ** if (v1 != var29_5) goto lbl55
lbl54:
                    // 1 sources

                    return var29_5;
lbl55:
                    // 1 sources

                    ** GOTO lbl72
                }
                case 2: {
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2 = $continuation.I$2;
                    $i$f$client\2\734 = $continuation.I$1;
                    $i$f$feed\1\362 = $continuation.I$0;
                    $this$client_u24lambda_u244\3 = (Extension)$continuation.L$7;
                    var9_19 = (Companion)$continuation.L$6;
                    $this$client\2 = (Extension)$continuation.L$5;
                    this_\2 = (Companion)$continuation.L$4;
                    ext\1 = (MusicExtension)$continuation.L$3;
                    list\1 = (List)$continuation.L$2;
                    this_\1 = (UnifiedExtension)$continuation.L$1;
                    query = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = ((Result)$result).unbox-impl();
lbl72:
                    // 2 sources

                    var14_30 = v1;
                    ResultKt.throwOnFailure((Object)var14_30);
                    v2 = var14_30;
                    if (!(v2 instanceof SearchFeedClient)) {
                        v2 = null;
                    }
                    v3 = (SearchFeedClient)v2;
                    if (v3 == null) {
                        $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(SearchFeedClient.class);
                        $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\737\3 = false;
                        v4 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                        if (v4 == null) {
                            v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                        }
                        Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                        var26_34 = v4;
                        throw new ClientException.NotSupported(var26_34);
                    }
                    $this$feed_u24lambda_u244\5 = client\3 = v3;
                    $i$a$-client-UnifiedExtension$feed$2\5\739\1 = 0;
                    var21_41 = (Continuation)$continuation;
                    $this$loadSearchFeed_u24lambda_u247\10 = $this$feed_u24lambda_u244\5;
                    $i$a$-feed-UnifiedExtension$loadSearchFeed$2\10\734\0 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)query);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)list\1);
                    $continuation.L$3 = ext\1;
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                    $continuation.L$5 = $this$client\2;
                    $continuation.L$6 = var9_19;
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                    $continuation.L$8 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                    $continuation.L$9 = SpillingKt.nullOutSpilledVariable((Object)$this$feed_u24lambda_u244\5);
                    $continuation.L$10 = SpillingKt.nullOutSpilledVariable((Object)$completion\10);
                    $continuation.L$11 = SpillingKt.nullOutSpilledVariable((Object)$this$loadSearchFeed_u24lambda_u247\10);
                    $continuation.I$0 = $i$f$feed\1\362;
                    $continuation.I$1 = $i$f$client\2\734;
                    $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2;
                    $continuation.I$3 = $i$a$-client-UnifiedExtension$feed$2\5\739\1;
                    $continuation.I$4 = $i$a$-feed-UnifiedExtension$loadSearchFeed$2\10\734\0;
                    $continuation.label = 3;
                    v5 = $this$loadSearchFeed_u24lambda_u247\10.loadSearchFeed(query, (Continuation<? super Feed<Shelf>>)$continuation);
                    ** if (v5 != var29_5) goto lbl114
lbl113:
                    // 1 sources

                    return var29_5;
lbl114:
                    // 1 sources

                    ** GOTO lbl139
                }
                case 3: {
                    $i$a$-feed-UnifiedExtension$loadSearchFeed$2\10\734\0 = $continuation.I$4;
                    $i$a$-client-UnifiedExtension$feed$2\5\739\1 = $continuation.I$3;
                    $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2 = $continuation.I$2;
                    $i$f$client\2\734 = $continuation.I$1;
                    $i$f$feed\1\362 = $continuation.I$0;
                    $this$loadSearchFeed_u24lambda_u247\10 = (SearchFeedClient)$continuation.L$11;
                    $completion\10 = (Continuation)$continuation.L$10;
                    $this$feed_u24lambda_u244\5 = (SearchFeedClient)$continuation.L$9;
                    client\3 = (SearchFeedClient)$continuation.L$8;
                    $this$client_u24lambda_u244\3 = (Extension)$continuation.L$7;
                    var9_19 = (Companion)$continuation.L$6;
                    $this$client\2 = (Extension)$continuation.L$5;
                    this_\2 = (Companion)$continuation.L$4;
                    ext\1 = (MusicExtension)$continuation.L$3;
                    list\1 = (List)$continuation.L$2;
                    this_\1 = (UnifiedExtension)$continuation.L$1;
                    query = (String)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v5 = $result;
lbl139:
                        // 2 sources

                        $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v5));
                    }
                    catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2) {
                        $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\735\2));
                    }
                    var11_23 = $this$client_u24lambda_u244\3;
                    v6 = Result.exceptionOrNull-impl((Object)var11_23);
                    if (v6 != null) {
                        it\6 = v6;
                        $i$a$-getOrElse-UnifiedExtension$Companion$client$3\6\740\2 = false;
                        throw AppException.Companion.toAppException(it\6, $this$client\2);
                    }
                    v7 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(var9_19, (Feed)var11_23, (Extension)ext\1);
                    break block20;
                }
            }
            $this$map\7 = list\1;
            $i$f$map\7\742 = false;
            $this$client\2 = $this$map\7;
            destination\8 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
            $i$f$mapTo\8\743 = false;
            for (T item\8 : $this$mapTo\8) {
                var14_31 = (MusicExtension)item\8;
                var21_43 = destination\8;
                $i$a$-map-UnifiedExtension$feed$3\9\745\1 = false;
                var21_43.add(UnifiedExtension.Companion.injectId(new Tab(it\9.getId(), it\9.getName(), false, null, 12, null), it\9.getId()));
            }
            var27_49 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this_\1, null, query){
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
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ UnifiedExtension this$0;
                final /* synthetic */ String $query$inlined;
                Object L$12;
                int I$4;
                {
                    this.this$0 = $receiver;
                    this.$query$inlined = string2;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            this.L$0 = tab;
                            this.label = 1;
                            v0 = this.this$0.extensions((Continuation<? super List<MusicExtension>>)((Continuation)this));
                            if (v0 == var3_3) {
                                return var3_3;
                            }
                            ** GOTO lbl15
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl15:
                            // 2 sources

                            extensions = (List)v0;
                            v1 = tab;
                            if (v1 == null || (v1 = v1.getExtras()) == null || (v1 = UnifiedExtension.Companion.getExtensionId((Map<String, String>)v1)) == null) {
                                v2 = var7_5 = (MusicExtension)CollectionsKt.firstOrNull((List)extensions);
                                v1 = v2 != null ? v2.getId() : null;
                            }
                            id = v1;
                            var5_7 = this.this$0;
                            $this$getFeedData\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(UnifiedExtension.Companion, extensions, (String)id);
                            $i$f$getFeedData\1\355 = 0;
                            var10_10 = UnifiedExtension.Companion;
                            var11_11 = $this$getFeedData\1;
                            var12_12 = UnifiedExtension.Companion;
                            $i$f$client\2\690 = 0;
                            var14_15 = $this$client\2;
                            $this$client_u24lambda_u244\3 = var14_15;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$6 = $this$client\2;
                            this.L$7 = var12_12;
                            this.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.label = 2;
                            v3 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A(this);
                            ** if (v3 != var3_3) goto lbl50
lbl49:
                            // 1 sources

                            return var3_3;
lbl50:
                            // 1 sources

                            ** GOTO lbl67
                        }
                        case 2: {
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$8;
                            var12_12 = (Companion)this.L$7;
                            $this$client\2 = (Extension)this.L$6;
                            this_\2 = (Companion)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = ((Result)$result).unbox-impl();
lbl67:
                            // 2 sources

                            var17_21 = v3;
                            ResultKt.throwOnFailure((Object)var17_21);
                            v4 = var17_21;
                            if (!(v4 instanceof SearchFeedClient)) {
                                v4 = null;
                            }
                            v5 = (SearchFeedClient)v4;
                            if (v5 == null) {
                                $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(SearchFeedClient.class);
                                $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\693\3 = false;
                                v6 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                                if (v6 == null) {
                                    v6 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                                }
                                Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"run(...)");
                                var22_26 = v6;
                                throw new ClientException.NotSupported(var22_26);
                            }
                            $this$getFeedData_u24lambda_u241\5 = client\3 = v5;
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = 0;
                            var26_30 = (Continuation)this;
                            $this$loadSearchFeed_u24lambda_u247\5 = $this$getFeedData_u24lambda_u241\5;
                            $i$a$-feed-UnifiedExtension$loadSearchFeed$2\5\690\0 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                            this.L$6 = $this$client\2;
                            this.L$7 = var12_12;
                            this.L$8 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                            this.L$9 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                            this.L$10 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u241\5);
                            this.L$11 = SpillingKt.nullOutSpilledVariable((Object)$completion\5);
                            this.L$12 = SpillingKt.nullOutSpilledVariable((Object)$this$loadSearchFeed_u24lambda_u247\5);
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$f$client\2\690;
                            this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                            this.I$3 = $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1;
                            this.I$4 = $i$a$-feed-UnifiedExtension$loadSearchFeed$2\5\690\0;
                            this.label = 3;
                            v7 = $this$loadSearchFeed_u24lambda_u247\5.loadSearchFeed(this.$query$inlined, (Continuation<? super Feed<Shelf>>)this);
                            ** if (v7 != var3_3) goto lbl110
lbl109:
                            // 1 sources

                            return var3_3;
lbl110:
                            // 1 sources

                            ** GOTO lbl135
                        }
                        case 3: {
                            $i$a$-feed-UnifiedExtension$loadSearchFeed$2\5\690\0 = this.I$4;
                            $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = this.I$3;
                            $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                            $i$f$client\2\690 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            $this$loadSearchFeed_u24lambda_u247\5 = (SearchFeedClient)this.L$12;
                            $completion\5 = (Continuation)this.L$11;
                            $this$getFeedData_u24lambda_u241\5 = (SearchFeedClient)this.L$10;
                            client\3 = (SearchFeedClient)this.L$9;
                            $this$client_u24lambda_u244\3 = (Extension)this.L$8;
                            var12_12 = (Companion)this.L$7;
                            $this$client\2 = (Extension)this.L$6;
                            this_\2 = (Companion)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v7 = $result;
lbl135:
                                // 2 sources

                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v7));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2) {
                                $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2));
                            }
                            var14_15 = $this$client_u24lambda_u244\3;
                            v8 = Result.exceptionOrNull-impl((Object)var14_15);
                            if (v8 != null) {
                                it\7 = v8;
                                $i$a$-getOrElse-UnifiedExtension$Companion$client$3\7\697\3 = false;
                                throw AppException.Companion.toAppException((Throwable)it\7, $this$client\2);
                            }
                            $this$getFeedData_u24lambda_u242\8 = feed\2 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId((Companion)var12_12, (Feed)var14_15, $this$getFeedData\1);
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extensions);
                            this.L$2 = this_\1;
                            this.L$3 = $this$getFeedData\1;
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)id);
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u242\8);
                            this.L$6 = feed\2;
                            this.L$7 = null;
                            this.L$8 = null;
                            this.L$9 = null;
                            this.L$10 = null;
                            this.L$11 = null;
                            this.L$12 = null;
                            this.I$0 = $i$f$getFeedData\1\355;
                            this.I$1 = $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2;
                            this.label = 4;
                            v9 = $this$getFeedData_u24lambda_u242\8.getGetPagedData().invoke(CollectionsKt.firstOrNull($this$getFeedData_u24lambda_u242\8.getTabs()), (Object)this);
                            if (v9 == var3_3) {
                                return var3_3;
                            }
                            ** GOTO lbl180
                        }
                        case 4: {
                            $i$a$-run-UnifiedExtension$getFeedData$data$1\8\698\2 = this.I$1;
                            $i$f$getFeedData\1\355 = this.I$0;
                            feed\2 = (Feed)this.L$6;
                            $this$getFeedData_u24lambda_u242\8 = (Feed)this.L$5;
                            id = (String)this.L$4;
                            $this$getFeedData\1 = (Extension)this.L$3;
                            this_\1 = (UnifiedExtension)this.L$2;
                            extensions = (List)this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v9 = $result;
lbl180:
                            // 2 sources

                            data\2 = (Feed.Data)v9;
                            $this$map\9 = CollectionsKt.drop((Iterable)feed\2.getTabs(), (int)1);
                            $i$f$map\9\699 = false;
                            it\7 = $this$map\9;
                            destination\10 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\9, (int)10));
                            $i$f$mapTo\10\700 = false;
                            for (T item\10 : $this$mapTo\10) {
                                $this$client_u24lambda_u244_u24lambda_u243\4 = (Tab)item\10;
                                var12_12 = destination\10;
                                $i$a$-map-UnifiedExtension$getFeedData$otherTabs$1\11\702\2 = false;
                                var12_12.add(new Shelf.Category(tab\11.getId(), tab\11.getTitle(), new Feed<T>(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(feed\2, (Tab)tab\11, null){
                                    Object L$0;
                                    int I$0;
                                    int label;
                                    final /* synthetic */ Feed $feed;
                                    final /* synthetic */ Tab $tab;
                                    {
                                        this.$feed = $feed;
                                        this.$tab = $tab;
                                        super(2, $completion);
                                    }

                                    /*
                                     * Enabled force condition propagation
                                     * Lifted jumps to return sites
                                     */
                                    public final Object invokeSuspend(Object $result) {
                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                Feed feed2 = this.$feed;
                                                Tab tab = this.$tab;
                                                Feed feed3 = feed2;
                                                int n = 0;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)feed3);
                                                this.I$0 = n;
                                                this.label = 1;
                                                Object object2 = feed3.getGetPagedData().invoke((Object)tab, (Object)((Object)this));
                                                Object object3 = object2;
                                                if (object2 != object) return (Feed.Data)object3;
                                                return object;
                                            }
                                            case 1: {
                                                int n = this.I$0;
                                                Feed feed4 = (Feed)this.L$0;
                                                ResultKt.throwOnFailure((Object)$result);
                                                Object object3 = $result;
                                                return (Feed.Data)object3;
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
                                }), null, null, null, null, 120, null));
                            }
                            otherTabs\2 = (List)destination\10;
                            if (feed\2.getTabs().size() > 1 && UnifiedExtension.access$getShowTabs(this_\1)) {
                                var13_14 = new PagedData[]{new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>(this_\1, otherTabs\2, null){
                                    int label;
                                    final /* synthetic */ UnifiedExtension this$0;
                                    final /* synthetic */ List $otherTabs;
                                    {
                                        this.this$0 = $receiver;
                                        this.$otherTabs = $otherTabs;
                                        super(1, $completion);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                String string2 = UnifiedExtension.access$getContext$p(this.this$0).getString(R.string.tabs);
                                                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
                                                return CollectionsKt.listOf((Object)new Shelf.Lists.Categories("tabs", string2, this.$otherTabs, null, null, null, null, 120, null));
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
                                }), data\2.getPagedData()};
                                v10 = new PagedData.Concat<T>(var13_14);
                                v11 = data\2.getButtons();
                                v12 = new Feed.Data<T>(v10, v11 != null ? UnifiedExtension.Companion.withExtensionId(v11, $this$getFeedData\1) : null, data\2.getBackground());
                            } else {
                                v12 = data\2;
                            }
                            return v12;
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
            var28_50 = (List)destination\8;
            v7 = new Feed<T>(var28_50, var27_49);
        }
        return v7;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final UnifiedDatabase getDb() {
        return this.db;
    }

    /*
     * Exception decompiling
     */
    private final Object getCached(Continuation<? super List<Track>> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private final Playlist cachePlaylist() {
        Playlist playlist;
        if (!((Collection)this.cachedTracks).isEmpty()) {
            String string2 = this.context.getString(R.string.cached_songs);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getString(...)");
            String string3 = string2;
            ImageHolder imageHolder = ((Track)CollectionsKt.first(this.cachedTracks)).getCover();
            String string4 = this.context.getString(R.string.cache_playlist_warning);
            long l = this.cachedTracks.size();
            Map map2 = MapsKt.mapOf((Pair)TuplesKt.to((Object)EXTENSION_ID, (Object)UNIFIED_ID));
            playlist = new Playlist("cached", string3, false, false, imageHolder, null, l, null, null, string4, null, null, map2, false, false, false, false, false, false, 519592, null);
        } else {
            playlist = null;
        }
        return playlist;
    }

    @NotNull
    public final MutableStateFlow<List<EchoMediaItem>> getDownloadFeed() {
        return this.downloadFeed;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadLibraryFeed(@NotNull Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof loadLibraryFeed.1)) ** GOTO lbl-1000
        var14_2 = $completion;
        if ((var14_2.label & -2147483648) != 0) {
            var14_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadLibraryFeed((Continuation<? super Feed<Shelf>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var17_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = this.context.getString(R.string.all);
                Intrinsics.checkNotNullExpressionValue((Object)v0, (String)"getString(...)");
                var11_5 = CollectionsKt.listOf((Object)new Tab("Unified", v0, false, null, 12, null));
                $continuation.L$0 = var11_5;
                $continuation.label = 1;
                v1 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v1 == var17_4) {
                    return var17_4;
                }
                ** GOTO lbl25
            }
            case 1: {
                var11_5 = (Collection)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl25:
                // 2 sources

                var2_6 = (Iterable)v1;
                $i$f$map\1\394 = false;
                var4_8 = $this$map\1;
                destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\815 = false;
                for (T item\2 : $this$mapTo\2) {
                    var9_13 = (MusicExtension)item\2;
                    var12_15 = destination\2;
                    $i$a$-map-UnifiedExtension$loadLibraryFeed$2\3\817\0 = false;
                    var12_15.add(new Tab(it\3.getId(), it\3.getName(), false, null, 12, null));
                }
                var15_16 = (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>(this, null){
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
                    int I$0;
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    int label;
                    /* synthetic */ Object L$0;
                    final /* synthetic */ UnifiedExtension this$0;
                    {
                        this.this$0 = $receiver;
                        super(2, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object invokeSuspend(Object $result) {
                        var2_2 = (Tab)this.L$0;
                        var30_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var28_4 = UnifiedExtension.Companion;
                                this.L$0 = tab;
                                this.L$1 = var28_4;
                                this.label = 1;
                                v0 = this.this$0.extensions((Continuation<? super List<MusicExtension>>)((Continuation)this));
                                if (v0 == var30_3) {
                                    return var30_3;
                                }
                                ** GOTO lbl18
                            }
                            case 1: {
                                var28_4 = (Companion)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl18:
                                // 2 sources

                                v1 = tab;
                                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$getOrNull(var28_4, (List)v0, v1 != null ? v1.getId() : null);
                                if (extension == null) ** GOTO lbl-1000
                                var5_6 = this.this$0;
                                $this$getFeedData\1 = extension;
                                $i$f$getFeedData\1\399 = 0;
                                var8_9 = UnifiedExtension.Companion;
                                var9_10 = $this$getFeedData\1;
                                var10_11 = UnifiedExtension.Companion;
                                $i$f$client\2\690 = 0;
                                var12_14 = $this$client\2;
                                $this$client_u24lambda_u244\3 = var12_14;
                                $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = 0;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                                this.L$2 = this_\1;
                                this.L$3 = $this$getFeedData\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                                this.L$5 = $this$client\2;
                                this.L$6 = var10_11;
                                this.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                                this.I$0 = $i$f$getFeedData\1\399;
                                this.I$1 = $i$f$client\2\690;
                                this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                                this.label = 2;
                                v2 = $this$client_u24lambda_u244\3.getInstance().value-IoAF18A(this);
                                ** if (v2 != var30_3) goto lbl49
lbl48:
                                // 1 sources

                                return var30_3;
lbl49:
                                // 1 sources

                                ** GOTO lbl65
                            }
                            case 2: {
                                $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                                $i$f$client\2\690 = this.I$1;
                                $i$f$getFeedData\1\399 = this.I$0;
                                $this$client_u24lambda_u244\3 = (Extension)this.L$7;
                                var10_11 = (Companion)this.L$6;
                                $this$client\2 = (Extension)this.L$5;
                                this_\2 = (Companion)this.L$4;
                                $this$getFeedData\1 = (Extension)this.L$3;
                                this_\1 = (UnifiedExtension)this.L$2;
                                extension = (Extension)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = ((Result)$result).unbox-impl();
lbl65:
                                // 2 sources

                                var15_20 = v2;
                                ResultKt.throwOnFailure((Object)var15_20);
                                v3 = var15_20;
                                if (!(v3 instanceof LibraryFeedClient)) {
                                    v3 = null;
                                }
                                v4 = (LibraryFeedClient)v3;
                                if (v4 == null) {
                                    $this$client_u24lambda_u244_u24lambda_u243\4 = Reflection.getOrCreateKotlinClass(LibraryFeedClient.class);
                                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\4\693\3 = false;
                                    v5 = $this$client_u24lambda_u244_u24lambda_u243\4.getSimpleName();
                                    if (v5 == null) {
                                        v5 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\4).getName();
                                    }
                                    Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"run(...)");
                                    var29_25 = v5;
                                    throw new ClientException.NotSupported(var29_25);
                                }
                                $this$getFeedData_u24lambda_u241\5 = client\3 = v4;
                                $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = 0;
                                var24_29 = (Continuation)this;
                                $this$invokeSuspend_u24lambda_u240\11 = $this$getFeedData_u24lambda_u241\5;
                                $i$a$-getFeedData-UnifiedExtension$loadLibraryFeed$3$1\11\690\0 = 0;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                                this.L$2 = this_\1;
                                this.L$3 = $this$getFeedData\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\2);
                                this.L$5 = $this$client\2;
                                this.L$6 = var10_11;
                                this.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\3);
                                this.L$8 = SpillingKt.nullOutSpilledVariable((Object)client\3);
                                this.L$9 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u241\5);
                                this.L$10 = SpillingKt.nullOutSpilledVariable((Object)$completion\11);
                                this.L$11 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240\11);
                                this.I$0 = $i$f$getFeedData\1\399;
                                this.I$1 = $i$f$client\2\690;
                                this.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2;
                                this.I$3 = $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1;
                                this.I$4 = $i$a$-getFeedData-UnifiedExtension$loadLibraryFeed$3$1\11\690\0;
                                this.label = 3;
                                v6 = $this$invokeSuspend_u24lambda_u240\11.loadLibraryFeed((Continuation<? super Feed<Shelf>>)this);
                                ** if (v6 != var30_3) goto lbl107
lbl106:
                                // 1 sources

                                return var30_3;
lbl107:
                                // 1 sources

                                ** GOTO lbl131
                            }
                            case 3: {
                                $i$a$-getFeedData-UnifiedExtension$loadLibraryFeed$3$1\11\690\0 = this.I$4;
                                $i$a$-client-UnifiedExtension$getFeedData$feed$1\5\695\1 = this.I$3;
                                $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2 = this.I$2;
                                $i$f$client\2\690 = this.I$1;
                                $i$f$getFeedData\1\399 = this.I$0;
                                $this$invokeSuspend_u24lambda_u240\11 = (LibraryFeedClient)this.L$11;
                                $completion\11 = (Continuation)this.L$10;
                                $this$getFeedData_u24lambda_u241\5 = (LibraryFeedClient)this.L$9;
                                client\3 = (LibraryFeedClient)this.L$8;
                                $this$client_u24lambda_u244\3 = (Extension)this.L$7;
                                var10_11 = (Companion)this.L$6;
                                $this$client\2 = (Extension)this.L$5;
                                this_\2 = (Companion)this.L$4;
                                $this$getFeedData\1 = (Extension)this.L$3;
                                this_\1 = (UnifiedExtension)this.L$2;
                                extension = (Extension)this.L$1;
                                try {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v6 = $result;
lbl131:
                                    // 2 sources

                                    $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)((Feed)v6));
                                }
                                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2) {
                                    $this$client_u24lambda_u244\3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\3\691\2));
                                }
                                var12_14 = $this$client_u24lambda_u244\3;
                                v7 = Result.exceptionOrNull-impl((Object)var12_14);
                                if (v7 != null) {
                                    it\6 = v7;
                                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\6\696\2 = false;
                                    throw AppException.Companion.toAppException((Throwable)it\6, $this$client\2);
                                }
                                $this$getFeedData_u24lambda_u242\7 = feed\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId((Companion)var10_11, (Feed)var12_14, $this$getFeedData\1);
                                $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1 = 0;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)extension);
                                this.L$2 = this_\1;
                                this.L$3 = $this$getFeedData\1;
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$getFeedData_u24lambda_u242\7);
                                this.L$5 = feed\1;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.L$8 = null;
                                this.L$9 = null;
                                this.L$10 = null;
                                this.L$11 = null;
                                this.I$0 = $i$f$getFeedData\1\399;
                                this.I$1 = $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1;
                                this.label = 4;
                                v8 = $this$getFeedData_u24lambda_u242\7.getGetPagedData().invoke(CollectionsKt.firstOrNull($this$getFeedData_u24lambda_u242\7.getTabs()), (Object)this);
                                if (v8 == var30_3) {
                                    return var30_3;
                                }
                                ** GOTO lbl174
                            }
                            case 4: {
                                $i$a$-run-UnifiedExtension$getFeedData$data$1\7\697\1 = this.I$1;
                                $i$f$getFeedData\1\399 = this.I$0;
                                feed\1 = (Feed)this.L$5;
                                $this$getFeedData_u24lambda_u242\7 = (Feed)this.L$4;
                                $this$getFeedData\1 = (Extension)this.L$3;
                                this_\1 = (UnifiedExtension)this.L$2;
                                extension = (Extension)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v8 = $result;
lbl174:
                                // 2 sources

                                data\1 = (Feed.Data)v8;
                                $this$map\8 = CollectionsKt.drop((Iterable)feed\1.getTabs(), (int)1);
                                $i$f$map\8\698 = false;
                                it\6 = $this$map\8;
                                destination\9 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                                $i$f$mapTo\9\699 = false;
                                for (T item\9 : $this$mapTo\9) {
                                    $this$client_u24lambda_u244_u24lambda_u243\4 = (Tab)item\9;
                                    var10_11 = destination\9;
                                    $i$a$-map-UnifiedExtension$getFeedData$otherTabs$1\10\701\1 = false;
                                    var10_11.add(new Shelf.Category(tab\10.getId(), tab\10.getTitle(), new Feed<T>(CollectionsKt.emptyList(), (Function2)new /* invalid duplicate definition of identical inner class */), null, null, null, null, 120, null));
                                }
                                otherTabs\1 = (List)destination\9;
                                if (feed\1.getTabs().size() > 1 && UnifiedExtension.access$getShowTabs(this_\1)) {
                                    var11_13 = new PagedData[]{new PagedData.Single<T>((Function1)new /* invalid duplicate definition of identical inner class */), data\1.getPagedData()};
                                    v9 = new PagedData.Concat<T>(var11_13);
                                    v10 = data\1.getButtons();
                                    v11 = new Feed.Data<T>(v9, v10 != null ? UnifiedExtension.Companion.withExtensionId(v10, $this$getFeedData\1) : null, data\1.getBackground());
                                } else {
                                    v11 = data\1;
                                }
                                if ((var4_36 = v11) != null) {
                                    v12 = var4_36;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    $this$invokeSuspend_u24lambda_u241\12 = this.this$0;
                                    $i$a$-run-UnifiedExtension$loadLibraryFeed$3$2\12\399\0 = false;
                                    v12 = Feed.Companion.toFeedData$default(Feed.Companion, new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Shelf>>, Object>($this$invokeSuspend_u24lambda_u241\12, null){
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        Object L$3;
                                        Object L$4;
                                        Object L$5;
                                        int I$0;
                                        int label;
                                        final /* synthetic */ UnifiedExtension $this_run;
                                        {
                                            this.$this_run = $receiver;
                                            super(1, $completion);
                                        }

                                        /*
                                         * Unable to fully structure code
                                         * Could not resolve type clashes
                                         */
                                        public final Object invokeSuspend(Object $result) {
                                            var27_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            switch (this.label) {
                                                case 0: {
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    var11_3 /* !! */  = this.$this_run;
                                                    this.L$0 = var11_3 /* !! */ ;
                                                    this.label = 1;
                                                    v0 = UnifiedExtension.access$getCached(this.$this_run, (Continuation)this);
                                                    if (v0 == var27_2) {
                                                        return var27_2;
                                                    }
                                                    ** GOTO lbl16
                                                }
                                                case 1: {
                                                    var11_3 /* !! */  = (UnifiedExtension)this.L$0;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v0 = $result;
lbl16:
                                                    // 2 sources

                                                    UnifiedExtension.access$setCachedTracks$p((UnifiedExtension)var11_3 /* !! */ , (List)v0);
                                                    var2_4 = new Shelf[3];
                                                    v1 = UnifiedExtension.access$getContext$p(this.$this_run).getString(R.string.saved);
                                                    Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"getString(...)");
                                                    var16_5 = (Context)UnifiedExtension.access$getContext$p(this.$this_run);
                                                    var15_6 = UnifiedExtension.Companion;
                                                    var14_7 = v1;
                                                    var13_8 = "saved";
                                                    var12_9 = 0;
                                                    var11_3 /* !! */  = var2_4;
                                                    this.L$0 = var2_4;
                                                    this.L$1 = var11_3 /* !! */ ;
                                                    this.L$2 = var13_8;
                                                    this.L$3 = var14_7;
                                                    this.L$4 = var15_6;
                                                    this.L$5 = var16_5;
                                                    this.I$0 = var12_9;
                                                    this.label = 2;
                                                    v2 = this.$this_run.getDb().getSaved((Continuation<? super List<? extends EchoMediaItem>>)((Continuation)this));
                                                    if (v2 == var27_2) {
                                                        return var27_2;
                                                    }
                                                    ** GOTO lbl48
                                                }
                                                case 2: {
                                                    var12_9 = this.I$0;
                                                    var16_5 = (Context)this.L$5;
                                                    var15_6 = (Companion)this.L$4;
                                                    var14_7 = (String)this.L$3;
                                                    var13_8 = (String)this.L$2;
                                                    var11_3 /* !! */  = (Shelf[])this.L$1;
                                                    var2_4 = (Shelf[])this.L$0;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v2 = $result;
lbl48:
                                                    // 2 sources

                                                    var17_11 = v2;
                                                    var18_12 = null;
                                                    var19_13 = 120;
                                                    var20_14 = null;
                                                    var21_15 = null;
                                                    var22_16 = null;
                                                    var23_17 = null;
                                                    var24_18 = var15_6.getFeed(var16_5, (List)var17_11);
                                                    var25_19 = var14_7;
                                                    var26_20 = var13_8;
                                                    var11_3 /* !! */ [var12_9] = new Shelf.Category(var26_20, var25_19, var24_18, var23_17, var22_16, var21_15, var20_14, var19_13, var18_12);
                                                    v3 = UnifiedExtension.access$getContext$p(this.$this_run).getString(R.string.downloads);
                                                    Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getString(...)");
                                                    var2_4[1] = new Shelf.Category("downloads", v3, UnifiedExtension.Companion.getFeed((Context)UnifiedExtension.access$getContext$p(this.$this_run), (List)this.$this_run.getDownloadFeed().getValue()), null, null, null, null, 120, null);
                                                    v4 = UnifiedExtension.access$cachePlaylist(this.$this_run);
                                                    var2_4[2] = v4 != null ? v4.toShelf() : null;
                                                    this.L$0 = var11_3 /* !! */  = (Collection)CollectionsKt.listOfNotNull((Object[])var2_4);
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.label = 3;
                                                    v5 = this.$this_run.getDb().getCreatedPlaylists((Continuation<? super List<Playlist>>)((Continuation)this));
                                                    if (v5 == var27_2) {
                                                        return var27_2;
                                                    }
                                                    ** GOTO lbl79
                                                }
                                                case 3: {
                                                    var11_3 /* !! */  = (Collection)this.L$0;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v5 = $result;
lbl79:
                                                    // 2 sources

                                                    var2_4 = (Object[])v5;
                                                    $i$f$map\1\414 = false;
                                                    var4_22 = $this$map\1;
                                                    destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                                                    $i$f$mapTo\2\690 = false;
                                                    for (T item\2 : $this$mapTo\2) {
                                                        var9_27 = (Playlist)item\2;
                                                        var12_10 = destination\2;
                                                        $i$a$-map-UnifiedExtension$loadLibraryFeed$3$2$1$1\3\692\0 = false;
                                                        var12_10.add(it\3.toShelf());
                                                    }
                                                    return CollectionsKt.plus((Collection)var11_3 /* !! */ , (Iterable)((List)destination\2));
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
                                return v12;
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
                var16_17 = CollectionsKt.plus((Collection)var11_5, (Iterable)((List)destination\2));
                return new Feed<T>(var16_17, var15_16);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadRadio(@NotNull Radio radio, @NotNull Continuation<? super Radio> $completion) {
        if (!($completion instanceof loadRadio.1)) ** GOTO lbl-1000
        var20_3 = $completion;
        if ((var20_3.label & -2147483648) != 0) {
            var20_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadRadio(null, (Continuation<? super Radio>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(radio.getExtras());
                var18_7 = UnifiedExtension.Companion;
                $continuation.L$0 = radio;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_7;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_5) {
                    return var22_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var18_7 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_7, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\422 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1 = 0;
                $continuation.L$0 = radio;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\422;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_5) goto lbl50
lbl49:
                // 1 sources

                return var22_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1 = $continuation.I$1;
                $i$f$client\1\422 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof RadioClient)) {
                    v2 = null;
                }
                v3 = (RadioClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(RadioClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\821\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_22 = v4;
                    throw new ClientException.NotSupported(var21_22);
                }
                $this$loadRadio_u24lambda_u2412\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadRadio$2\5\823\0 = 0;
                var17_28 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)radio);
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = $this$loadRadio_u24lambda_u2412\5;
                $continuation.L$8 = var17_28;
                $continuation.I$0 = $i$f$client\1\422;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadRadio$2\5\823\0;
                $continuation.label = 3;
                v5 = $this$loadRadio_u24lambda_u2412\5.loadRadio(radio, (Continuation<? super Radio>)$continuation);
                ** if (v5 != var22_5) goto lbl99
lbl98:
                // 1 sources

                return var22_5;
lbl99:
                // 1 sources

                ** GOTO lbl118
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadRadio$2\5\823\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1 = $continuation.I$1;
                $i$f$client\1\422 = $continuation.I$0;
                var17_28 = (Companion)$continuation.L$8;
                $this$loadRadio_u24lambda_u2412\5 = (RadioClient)$continuation.L$7;
                client\2 = (RadioClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl118:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var17_28, (Radio)v5, id, (Object)$this$loadRadio_u24lambda_u2412\5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\819\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\824\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadTracks(@NotNull Radio radio, @NotNull Continuation<? super Feed<Track>> $completion) {
        if (!($completion instanceof loadTracks.1)) ** GOTO lbl-1000
        var20_3 = $completion;
        if ((var20_3.label & -2147483648) != 0) {
            var20_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadTracks((Radio)null, (Continuation<? super Feed<Track>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(radio.getExtras());
                var18_8 = UnifiedExtension.Companion;
                $continuation.L$0 = radio;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_5) {
                    return var22_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var18_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\430 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1 = 0;
                $continuation.L$0 = radio;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\430;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_5) goto lbl50
lbl49:
                // 1 sources

                return var22_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1 = $continuation.I$1;
                $i$f$client\1\430 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof RadioClient)) {
                    v2 = null;
                }
                v3 = (RadioClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(RadioClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\827\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_22 = v4;
                    throw new ClientException.NotSupported(var21_22);
                }
                $this$loadTracks_u24lambda_u2413\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadTracks$2\5\829\0 = 0;
                var17_29 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)radio);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadTracks_u24lambda_u2413\5);
                $continuation.L$8 = var17_29;
                $continuation.I$0 = $i$f$client\1\430;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadTracks$2\5\829\0;
                $continuation.label = 3;
                v5 = $this$loadTracks_u24lambda_u2413\5.loadTracks(radio, (Continuation<? super Feed<Track>>)$continuation);
                ** if (v5 != var22_5) goto lbl99
lbl98:
                // 1 sources

                return var22_5;
lbl99:
                // 1 sources

                ** GOTO lbl118
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadTracks$2\5\829\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1 = $continuation.I$1;
                $i$f$client\1\430 = $continuation.I$0;
                var17_29 = (Companion)$continuation.L$8;
                $this$loadTracks_u24lambda_u2413\5 = (RadioClient)$continuation.L$7;
                client\2 = (RadioClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                radio = (Radio)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl118:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtension(var17_29, (Feed)v5, extension));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\825\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\830\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object radio(@NotNull EchoMediaItem item, @Nullable EchoMediaItem context, @NotNull Continuation<? super Radio> $completion) {
        if (!($completion instanceof radio.1)) ** GOTO lbl-1000
        var20_4 = $completion;
        if ((var20_4.label & -2147483648) != 0) {
            var20_4.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.radio(null, null, (Continuation<? super Radio>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var5_8 = UnifiedExtension.Companion;
                var18_10 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = context;
                $continuation.L$2 = id;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)var5_8);
                $continuation.L$4 = var18_10;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_6) {
                    return var22_6;
                }
                ** GOTO lbl33
            }
            case 1: {
                var18_10 = (Companion)$continuation.L$4;
                var5_8 = (Companion)$continuation.L$3;
                id = (String)$continuation.L$2;
                context = (EchoMediaItem)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl33:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_10, (List)v0, id);
                $i$f$client\1\437 = 0;
                var8_14 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_14;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = context;
                $continuation.L$2 = id;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\437;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_6) goto lbl53
lbl52:
                // 1 sources

                return var22_6;
lbl53:
                // 1 sources

                ** GOTO lbl67
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1 = $continuation.I$1;
                $i$f$client\1\437 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                id = (String)$continuation.L$2;
                context = (EchoMediaItem)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl67:
                // 2 sources

                var11_18 = v1;
                ResultKt.throwOnFailure((Object)var11_18);
                v2 = var11_18;
                if (!(v2 instanceof RadioClient)) {
                    v2 = null;
                }
                v3 = (RadioClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(RadioClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\833\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_21 = v4;
                    throw new ClientException.NotSupported(var21_21);
                }
                $this$radio_u24lambda_u2414\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$radio$2\5\835\0 = 0;
                var17_27 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)context);
                $continuation.L$2 = id;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = $this$radio_u24lambda_u2414\5;
                $continuation.L$8 = var17_27;
                $continuation.I$0 = $i$f$client\1\437;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$radio$2\5\835\0;
                $continuation.label = 3;
                v5 = $this$radio_u24lambda_u2414\5.radio(item, context, (Continuation<? super Radio>)$continuation);
                ** if (v5 != var22_6) goto lbl102
lbl101:
                // 1 sources

                return var22_6;
lbl102:
                // 1 sources

                ** GOTO lbl121
            }
            case 3: {
                $i$a$-client-UnifiedExtension$radio$2\5\835\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1 = $continuation.I$1;
                $i$f$client\1\437 = $continuation.I$0;
                var17_27 = (Companion)$continuation.L$8;
                $this$radio_u24lambda_u2414\5 = (RadioClient)$continuation.L$7;
                client\2 = (RadioClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                id = (String)$continuation.L$2;
                context = (EchoMediaItem)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl121:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var17_27, (Radio)v5, id, (Object)$this$radio_u24lambda_u2414\5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\831\1));
                }
                var8_14 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_14);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\836\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_14;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadTrack(@NotNull Track track, boolean isDownload, @NotNull Continuation<? super Track> $completion) {
        if (!($completion instanceof loadTrack.1)) ** GOTO lbl-1000
        var21_4 = $completion;
        if ((var21_4.label & -2147483648) != 0) {
            var21_4.label -= -2147483648;
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
                boolean Z$0;
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadTrack(null, false, (Continuation<? super Track>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var23_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = track.getExtras().get("cached");
                cached = (int)(v0 != null ? Boolean.parseBoolean(v0) : false);
                if (cached != 0) {
                    return track;
                }
                id = UnifiedExtension.Companion.getExtensionId(track.getExtras());
                var6_10 = UnifiedExtension.Companion;
                var19_12 = UnifiedExtension.Companion;
                $continuation.L$0 = track;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var6_10);
                $continuation.L$3 = var19_12;
                $continuation.Z$0 = isDownload;
                $continuation.I$0 = cached;
                $continuation.label = 1;
                v1 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v1 == var23_6) {
                    return var23_6;
                }
                ** GOTO lbl39
            }
            case 1: {
                cached = $continuation.I$0;
                isDownload = $continuation.Z$0;
                var19_12 = (Companion)$continuation.L$3;
                var6_10 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl39:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var19_12, (List)v1, id);
                $i$f$client\1\446 = 0;
                var9_16 = $this$client\1;
                $this$client_u24lambda_u244\2 = var9_16;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1 = 0;
                $continuation.L$0 = track;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.Z$0 = isDownload;
                $continuation.I$0 = cached;
                $continuation.I$1 = $i$f$client\1\446;
                $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1;
                $continuation.label = 2;
                v2 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v2 != var23_6) goto lbl60
lbl59:
                // 1 sources

                return var23_6;
lbl60:
                // 1 sources

                ** GOTO lbl75
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1 = $continuation.I$2;
                $i$f$client\1\446 = $continuation.I$1;
                cached = $continuation.I$0;
                isDownload = $continuation.Z$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = ((Result)$result).unbox-impl();
lbl75:
                // 2 sources

                var12_20 = v2;
                ResultKt.throwOnFailure((Object)var12_20);
                v3 = var12_20;
                if (!(v3 instanceof TrackClient)) {
                    v3 = null;
                }
                v4 = (TrackClient)v3;
                if (v4 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(TrackClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\839\2 = false;
                    v5 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v5 == null) {
                        v5 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v5, (String)"run(...)");
                    var22_23 = v5;
                    throw new ClientException.NotSupported(var22_23);
                }
                $this$loadTrack_u24lambda_u2415\5 = client\2 = v4;
                $i$a$-client-UnifiedExtension$loadTrack$2\5\841\0 = 0;
                var18_29 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)track);
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = $this$loadTrack_u24lambda_u2415\5;
                $continuation.L$7 = var18_29;
                $continuation.Z$0 = isDownload;
                $continuation.I$0 = cached;
                $continuation.I$1 = $i$f$client\1\446;
                $continuation.I$2 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1;
                $continuation.I$3 = $i$a$-client-UnifiedExtension$loadTrack$2\5\841\0;
                $continuation.label = 3;
                v6 = $this$loadTrack_u24lambda_u2415\5.loadTrack(track, isDownload != false, (Continuation<? super Track>)$continuation);
                ** if (v6 != var23_6) goto lbl111
lbl110:
                // 1 sources

                return var23_6;
lbl111:
                // 1 sources

                ** GOTO lbl131
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadTrack$2\5\841\0 = $continuation.I$3;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1 = $continuation.I$2;
                $i$f$client\1\446 = $continuation.I$1;
                cached = $continuation.I$0;
                isDownload = $continuation.Z$0;
                var18_29 = (Companion)$continuation.L$7;
                $this$loadTrack_u24lambda_u2415\5 = (TrackClient)$continuation.L$6;
                client\2 = (TrackClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v6 = $result;
lbl131:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.withExtensionId$default(var18_29, (Track)v6, id, $this$loadTrack_u24lambda_u2415\5, false, 4, null));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\837\1));
                }
                var9_16 = $this$client_u24lambda_u244\2;
                v7 = Result.exceptionOrNull-impl((Object)var9_16);
                if (v7 != null) {
                    it\4 = v7;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\842\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var9_16;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadStreamableMedia(@NotNull Streamable streamable, boolean isDownload, @NotNull Continuation<? super Streamable.Media> $completion) {
        if (!($completion instanceof loadStreamableMedia.1)) ** GOTO lbl-1000
        var19_4 = $completion;
        if ((var19_4.label & -2147483648) != 0) {
            var19_4.label -= -2147483648;
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
                boolean Z$0;
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadStreamableMedia(null, false, (Continuation<? super Streamable.Media>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(streamable.getExtras());
                var5_9 = UnifiedExtension.Companion;
                var17_11 = UnifiedExtension.Companion;
                $continuation.L$0 = streamable;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var5_9);
                $continuation.L$3 = var17_11;
                $continuation.Z$0 = isDownload;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_6) {
                    return var21_6;
                }
                ** GOTO lbl33
            }
            case 1: {
                isDownload = $continuation.Z$0;
                var17_11 = (Companion)$continuation.L$3;
                var5_9 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                streamable = (Streamable)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl33:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_11, (List)v0, id);
                $i$f$client\1\455 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1 = 0;
                $continuation.L$0 = streamable;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.Z$0 = isDownload;
                $continuation.I$0 = $i$f$client\1\455;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_6) goto lbl53
lbl52:
                // 1 sources

                return var21_6;
lbl53:
                // 1 sources

                ** GOTO lbl67
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1 = $continuation.I$1;
                $i$f$client\1\455 = $continuation.I$0;
                isDownload = $continuation.Z$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                streamable = (Streamable)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl67:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof TrackClient)) {
                    v2 = null;
                }
                v3 = (TrackClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(TrackClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\845\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_22 = v4;
                    throw new ClientException.NotSupported(var20_22);
                }
                $this$loadStreamableMedia_u24lambda_u2416\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadStreamableMedia$2\5\847\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)streamable);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)$this$loadStreamableMedia_u24lambda_u2416\5);
                $continuation.Z$0 = isDownload;
                $continuation.I$0 = $i$f$client\1\455;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadStreamableMedia$2\5\847\0;
                $continuation.label = 3;
                v5 = $this$loadStreamableMedia_u24lambda_u2416\5.loadStreamableMedia(streamable, isDownload != false, (Continuation<? super Streamable.Media>)$continuation);
                ** if (v5 != var21_6) goto lbl100
lbl99:
                // 1 sources

                return var21_6;
lbl100:
                // 1 sources

                ** GOTO lbl118
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadStreamableMedia$2\5\847\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1 = $continuation.I$1;
                $i$f$client\1\455 = $continuation.I$0;
                isDownload = $continuation.Z$0;
                $this$loadStreamableMedia_u24lambda_u2416\5 = (TrackClient)$continuation.L$6;
                client\2 = (TrackClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                streamable = (Streamable)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl118:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)((Streamable.Media)v5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\843\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\848\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadFeed(@NotNull Track track, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof loadFeed.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadFeed((Track)null, (Continuation<? super Feed<Shelf>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(track.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = track;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\463 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1 = 0;
                $continuation.L$0 = track;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\463;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1 = $continuation.I$1;
                $i$f$client\1\463 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof TrackClient)) {
                    v2 = null;
                }
                v3 = (TrackClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(TrackClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\851\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_22 = v4;
                    throw new ClientException.NotSupported(var20_22);
                }
                $this$loadFeed_u24lambda_u2417\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadFeed$2\5\853\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)track);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadFeed_u24lambda_u2417\5);
                $continuation.I$0 = $i$f$client\1\463;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadFeed$2\5\853\0;
                $continuation.label = 3;
                v5 = $this$loadFeed_u24lambda_u2417\5.loadFeed(track, (Continuation<? super Feed<Shelf>>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl114
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadFeed$2\5\853\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1 = $continuation.I$1;
                $i$f$client\1\463 = $continuation.I$0;
                $this$loadFeed_u24lambda_u2417\5 = (TrackClient)$continuation.L$7;
                client\2 = (TrackClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                track = (Track)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl114:
                    // 2 sources

                    v6 = (Feed)v5;
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)(v6 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, v6, extension) : null));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\849\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v7 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v7 != null) {
                    it\4 = v7;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\854\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadAlbum(@NotNull Album album, @NotNull Continuation<? super Album> $completion) {
        if (!($completion instanceof loadAlbum.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
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
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(album.getExtras());
                var4_7 = UnifiedExtension.Companion;
                var17_9 = UnifiedExtension.Companion;
                $continuation.L$0 = album;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var4_7);
                $continuation.L$3 = var17_9;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl31
            }
            case 1: {
                var17_9 = (Companion)$continuation.L$3;
                var4_7 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_9, (List)v0, id);
                $i$f$client\1\470 = 0;
                var7_13 = $this$client\1;
                $this$client_u24lambda_u244\2 = var7_13;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1 = 0;
                $continuation.L$0 = album;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\470;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl63
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1 = $continuation.I$1;
                $i$f$client\1\470 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl63:
                // 2 sources

                var10_17 = v1;
                ResultKt.throwOnFailure((Object)var10_17);
                v2 = var10_17;
                if (!(v2 instanceof AlbumClient)) {
                    v2 = null;
                }
                v3 = (AlbumClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(AlbumClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\857\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_20 = v4;
                    throw new ClientException.NotSupported(var20_20);
                }
                $this$loadAlbum_u24lambda_u2418\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadAlbum$2\5\859\0 = 0;
                var16_26 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)album);
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = $this$loadAlbum_u24lambda_u2418\5;
                $continuation.L$7 = var16_26;
                $continuation.I$0 = $i$f$client\1\470;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadAlbum$2\5\859\0;
                $continuation.label = 3;
                v5 = $this$loadAlbum_u24lambda_u2418\5.loadAlbum(album, (Continuation<? super Album>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadAlbum$2\5\859\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1 = $continuation.I$1;
                $i$f$client\1\470 = $continuation.I$0;
                var16_26 = (Companion)$continuation.L$7;
                $this$loadAlbum_u24lambda_u2418\5 = (AlbumClient)$continuation.L$6;
                client\2 = (AlbumClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var16_26, (Album)v5, id, (Object)$this$loadAlbum_u24lambda_u2418\5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\855\1));
                }
                var7_13 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var7_13);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\860\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var7_13;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadTracks(@NotNull Album album, @NotNull Continuation<? super Feed<Track>> $completion) {
        if (!($completion instanceof loadTracks.3)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadTracks((Album)null, (Continuation<? super Feed<Track>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(album.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = album;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\478 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1 = 0;
                $continuation.L$0 = album;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\478;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1 = $continuation.I$1;
                $i$f$client\1\478 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof AlbumClient)) {
                    v2 = null;
                }
                v3 = (AlbumClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(AlbumClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\863\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_22 = v4;
                    throw new ClientException.NotSupported(var20_22);
                }
                $this$loadTracks_u24lambda_u2419\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadTracks$4\5\865\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)album);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadTracks_u24lambda_u2419\5);
                $continuation.I$0 = $i$f$client\1\478;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadTracks$4\5\865\0;
                $continuation.label = 3;
                v5 = $this$loadTracks_u24lambda_u2419\5.loadTracks(album, (Continuation<? super Feed<Track>>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl114
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadTracks$4\5\865\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1 = $continuation.I$1;
                $i$f$client\1\478 = $continuation.I$0;
                $this$loadTracks_u24lambda_u2419\5 = (AlbumClient)$continuation.L$7;
                client\2 = (AlbumClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl114:
                    // 2 sources

                    v6 = (Feed)v5;
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)(v6 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtension(UnifiedExtension.Companion, v6, extension) : null));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\861\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v7 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v7 != null) {
                    it\4 = v7;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\866\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadFeed(@NotNull Album album, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof loadFeed.3)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadFeed((Album)null, (Continuation<? super Feed<Shelf>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(album.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = album;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\486 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1 = 0;
                $continuation.L$0 = album;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\486;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1 = $continuation.I$1;
                $i$f$client\1\486 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof AlbumClient)) {
                    v2 = null;
                }
                v3 = (AlbumClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(AlbumClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\869\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_22 = v4;
                    throw new ClientException.NotSupported(var20_22);
                }
                $this$loadFeed_u24lambda_u2420\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadFeed$4\5\871\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)album);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadFeed_u24lambda_u2420\5);
                $continuation.I$0 = $i$f$client\1\486;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadFeed$4\5\871\0;
                $continuation.label = 3;
                v5 = $this$loadFeed_u24lambda_u2420\5.loadFeed(album, (Continuation<? super Feed<Shelf>>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl114
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadFeed$4\5\871\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1 = $continuation.I$1;
                $i$f$client\1\486 = $continuation.I$0;
                $this$loadFeed_u24lambda_u2420\5 = (AlbumClient)$continuation.L$7;
                client\2 = (AlbumClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                album = (Album)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl114:
                    // 2 sources

                    v6 = (Feed)v5;
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)(v6 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, v6, extension) : null));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\867\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v7 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v7 != null) {
                    it\4 = v7;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\872\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadArtist(@NotNull Artist artist, @NotNull Continuation<? super Artist> $completion) {
        if (!($completion instanceof loadArtist.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
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
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(artist.getExtras());
                var4_7 = UnifiedExtension.Companion;
                var17_9 = UnifiedExtension.Companion;
                $continuation.L$0 = artist;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var4_7);
                $continuation.L$3 = var17_9;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl31
            }
            case 1: {
                var17_9 = (Companion)$continuation.L$3;
                var4_7 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_9, (List)v0, id);
                $i$f$client\1\493 = 0;
                var7_13 = $this$client\1;
                $this$client_u24lambda_u244\2 = var7_13;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1 = 0;
                $continuation.L$0 = artist;
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\493;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl63
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1 = $continuation.I$1;
                $i$f$client\1\493 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl63:
                // 2 sources

                var10_17 = v1;
                ResultKt.throwOnFailure((Object)var10_17);
                v2 = var10_17;
                if (!(v2 instanceof ArtistClient)) {
                    v2 = null;
                }
                v3 = (ArtistClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(ArtistClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\875\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_20 = v4;
                    throw new ClientException.NotSupported(var20_20);
                }
                $this$loadArtist_u24lambda_u2421\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadArtist$2\5\877\0 = 0;
                var16_26 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)artist);
                $continuation.L$1 = id;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = $this$loadArtist_u24lambda_u2421\5;
                $continuation.L$7 = var16_26;
                $continuation.I$0 = $i$f$client\1\493;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadArtist$2\5\877\0;
                $continuation.label = 3;
                v5 = $this$loadArtist_u24lambda_u2421\5.loadArtist(artist, (Continuation<? super Artist>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadArtist$2\5\877\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1 = $continuation.I$1;
                $i$f$client\1\493 = $continuation.I$0;
                var16_26 = (Companion)$continuation.L$7;
                $this$loadArtist_u24lambda_u2421\5 = (ArtistClient)$continuation.L$6;
                client\2 = (ArtistClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var16_26, (Artist)v5, id, (Object)$this$loadArtist_u24lambda_u2421\5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\873\1));
                }
                var7_13 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var7_13);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\878\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var7_13;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadFeed(@NotNull Artist artist, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        if (!($completion instanceof loadFeed.5)) ** GOTO lbl-1000
        var20_3 = $completion;
        if ((var20_3.label & -2147483648) != 0) {
            var20_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
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
        var22_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(artist.getExtras());
                var18_8 = UnifiedExtension.Companion;
                $continuation.L$0 = artist;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_5) {
                    return var22_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var18_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\501 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1 = 0;
                $continuation.L$0 = artist;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\501;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_5) goto lbl50
lbl49:
                // 1 sources

                return var22_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1 = $continuation.I$1;
                $i$f$client\1\501 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof ArtistClient)) {
                    v2 = null;
                }
                v3 = (ArtistClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(ArtistClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\881\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_22 = v4;
                    throw new ClientException.NotSupported(var21_22);
                }
                $this$loadFeed_u24lambda_u2422\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadFeed$6\5\883\0 = 0;
                var17_29 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)artist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadFeed_u24lambda_u2422\5);
                $continuation.L$8 = var17_29;
                $continuation.I$0 = $i$f$client\1\501;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadFeed$6\5\883\0;
                $continuation.label = 3;
                v5 = $this$loadFeed_u24lambda_u2422\5.loadFeed(artist, (Continuation<? super Feed<Shelf>>)$continuation);
                ** if (v5 != var22_5) goto lbl99
lbl98:
                // 1 sources

                return var22_5;
lbl99:
                // 1 sources

                ** GOTO lbl118
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadFeed$6\5\883\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1 = $continuation.I$1;
                $i$f$client\1\501 = $continuation.I$0;
                var17_29 = (Companion)$continuation.L$8;
                $this$loadFeed_u24lambda_u2422\5 = (ArtistClient)$continuation.L$7;
                client\2 = (ArtistClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                artist = (Artist)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl118:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(var17_29, (Feed)v5, extension));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\879\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\884\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
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
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
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
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                extId = UnifiedExtension.Companion.getExtensionId(playlist.getExtras());
                if (!Intrinsics.areEqual((Object)extId, (Object)"unified")) break;
                if (Intrinsics.areEqual((Object)playlist.getId(), (Object)"cached")) {
                    v0 = this.cachePlaylist();
                    if (v0 != null) break;
                    v0 = playlist;
                    break;
                }
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)extId);
                $continuation.label = 1;
                v1 = this.db.loadPlaylist(playlist, (Continuation<? super Playlist>)$continuation);
                if (v1 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl31
            }
            case 1: {
                extId = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl31:
                // 2 sources

                return v1;
            }
        }
        var4_8 = UnifiedExtension.Companion;
        var17_10 = UnifiedExtension.Companion;
        $continuation.L$0 = playlist;
        $continuation.L$1 = extId;
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var4_8);
        $continuation.L$3 = var17_10;
        $continuation.label = 2;
        v2 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
        if (v2 == var21_5) {
            return var21_5;
        }
        ** GOTO lbl50
        {
            case 2: {
                var17_10 = (Companion)$continuation.L$3;
                var4_8 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl50:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_10, (List)v2, extId);
                $i$f$client\1\510 = 0;
                var7_14 = $this$client\1;
                $this$client_u24lambda_u244\2 = var7_14;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1 = 0;
                $continuation.L$0 = playlist;
                $continuation.L$1 = extId;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\510;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1;
                $continuation.label = 3;
                v3 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v3 != var21_5) goto lbl69
lbl68:
                // 1 sources

                return var21_5;
lbl69:
                // 1 sources

                ** GOTO lbl82
            }
            case 3: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1 = $continuation.I$1;
                $i$f$client\1\510 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v3 = ((Result)$result).unbox-impl();
lbl82:
                // 2 sources

                var10_18 = v3;
                ResultKt.throwOnFailure((Object)var10_18);
                v4 = var10_18;
                if (!(v4 instanceof PlaylistClient)) {
                    v4 = null;
                }
                v5 = (PlaylistClient)v4;
                if (v5 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(PlaylistClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\887\2 = false;
                    v6 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v6 == null) {
                        v6 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v6, (String)"run(...)");
                    var20_21 = v6;
                    throw new ClientException.NotSupported(var20_21);
                }
                $this$loadPlaylist_u24lambda_u2423\5 = client\2 = v5;
                $i$a$-client-UnifiedExtension$loadPlaylist$2\5\889\0 = 0;
                var16_27 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = extId;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = $this$loadPlaylist_u24lambda_u2423\5;
                $continuation.L$7 = var16_27;
                $continuation.I$0 = $i$f$client\1\510;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadPlaylist$2\5\889\0;
                $continuation.label = 4;
                v7 = $this$loadPlaylist_u24lambda_u2423\5.loadPlaylist(playlist, (Continuation<? super Playlist>)$continuation);
                ** if (v7 != var21_5) goto lbl116
lbl115:
                // 1 sources

                return var21_5;
lbl116:
                // 1 sources

                ** GOTO lbl134
            }
            case 4: {
                $i$a$-client-UnifiedExtension$loadPlaylist$2\5\889\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1 = $continuation.I$1;
                $i$f$client\1\510 = $continuation.I$0;
                var16_27 = (Companion)$continuation.L$7;
                $this$loadPlaylist_u24lambda_u2423\5 = (PlaylistClient)$continuation.L$6;
                client\2 = (PlaylistClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v7 = $result;
lbl134:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var16_27, (Playlist)v7, extId, (Object)$this$loadPlaylist_u24lambda_u2423\5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\885\1));
                }
                var7_14 = $this$client_u24lambda_u244\2;
                v8 = Result.exceptionOrNull-impl((Object)var7_14);
                if (v8 != null) {
                    it\4 = v8;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\890\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var7_14;
            }
        }
        return v0;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadTracks(@NotNull Playlist playlist, @NotNull Continuation<? super Feed<Track>> $completion) {
        if (!($completion instanceof loadTracks.5)) ** GOTO lbl-1000
        var20_3 = $completion;
        if ((var20_3.label & -2147483648) != 0) {
            var20_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadTracks((Playlist)null, (Continuation<? super Feed<Track>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(playlist.getExtras());
                if (Intrinsics.areEqual((Object)id, (Object)"unified")) ** GOTO lbl131
                var18_8 = UnifiedExtension.Companion;
                $continuation.L$0 = playlist;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_5) {
                    return var22_5;
                }
                ** GOTO lbl29
            }
            case 1: {
                var18_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl29:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_8, (List)v0, id);
                var5_10 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\523 = 0;
                var8_15 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_15;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1 = 0;
                $continuation.L$0 = playlist;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\523;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_5) goto lbl51
lbl50:
                // 1 sources

                return var22_5;
lbl51:
                // 1 sources

                ** GOTO lbl65
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1 = $continuation.I$1;
                $i$f$client\1\523 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl65:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof PlaylistClient)) {
                    v2 = null;
                }
                v3 = (PlaylistClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(PlaylistClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\893\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_22 = v4;
                    throw new ClientException.NotSupported(var21_22);
                }
                $this$loadTracks_u24lambda_u2424\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadTracks$7\5\895\0 = 0;
                var17_29 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadTracks_u24lambda_u2424\5);
                $continuation.L$8 = var17_29;
                $continuation.I$0 = $i$f$client\1\523;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadTracks$7\5\895\0;
                $continuation.label = 3;
                v5 = $this$loadTracks_u24lambda_u2424\5.loadTracks(playlist, (Continuation<? super Feed<Track>>)$continuation);
                ** if (v5 != var22_5) goto lbl100
lbl99:
                // 1 sources

                return var22_5;
lbl100:
                // 1 sources

                ** GOTO lbl119
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadTracks$7\5\895\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1 = $continuation.I$1;
                $i$f$client\1\523 = $continuation.I$0;
                var17_29 = (Companion)$continuation.L$8;
                $this$loadTracks_u24lambda_u2424\5 = (PlaylistClient)$continuation.L$7;
                client\2 = (PlaylistClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl119:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtension(var17_29, (Feed)v5, extension));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\891\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\896\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
lbl131:
            // 1 sources

            return Feed.Companion.toFeed$default(Feed.Companion, new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends Track>>, Object>(playlist, this, null){
                int label;
                final /* synthetic */ Playlist $playlist;
                final /* synthetic */ UnifiedExtension this$0;
                {
                    this.$playlist = $playlist;
                    this.this$0 = $receiver;
                    super(1, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            if (!Intrinsics.areEqual((Object)this.$playlist.getId(), (Object)"cached")) ** GOTO lbl8
                            v0 = UnifiedExtension.access$getCachedTracks$p(this.this$0);
                            ** GOTO lbl17
lbl8:
                            // 1 sources

                            this.label = 1;
                            v1 = this.this$0.getDb().getTracks(this.$playlist, (Continuation<? super List<Track>>)((Continuation)this));
                            if (v1 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl16
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v1 = $result;
lbl16:
                            // 2 sources

                            v0 = (List)v1;
lbl17:
                            // 2 sources

                            return v0;
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
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadFeed(@NotNull Playlist playlist, @NotNull Continuation<? super Feed<Shelf>> $completion) {
        block19: {
            if (!($completion instanceof loadFeed.7)) ** GOTO lbl-1000
            var19_3 = $completion;
            if ((var19_3.label & -2147483648) != 0) {
                var19_3.label -= -2147483648;
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
                    int I$0;
                    int I$1;
                    int I$2;
                    /* synthetic */ Object result;
                    final /* synthetic */ UnifiedExtension this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadFeed((Playlist)null, (Continuation<? super Feed<Shelf>>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    id = UnifiedExtension.Companion.getExtensionId(playlist.getExtras());
                    if (Intrinsics.areEqual((Object)id, (Object)"unified")) break;
                    var17_8 = UnifiedExtension.Companion;
                    $continuation.L$0 = playlist;
                    $continuation.L$1 = id;
                    $continuation.L$2 = var17_8;
                    $continuation.label = 1;
                    v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                    if (v0 == var21_5) {
                        return var21_5;
                    }
                    break block19;
                }
                case 1: {
                    var17_8 = (Companion)$continuation.L$2;
                    id = (String)$continuation.L$1;
                    playlist = (Playlist)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
                    break block19;
                }
            }
            return null;
        }
        extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
        var5_10 = UnifiedExtension.Companion;
        $this$client\1 = extension;
        $i$f$client\1\532 = 0;
        var8_15 = $this$client\1;
        $this$client_u24lambda_u244\2 = var8_15;
        $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1 = 0;
        $continuation.L$0 = playlist;
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
        $continuation.L$2 = extension;
        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
        $continuation.L$4 = $this$client\1;
        $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
        $continuation.I$0 = $i$f$client\1\532;
        $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1;
        $continuation.label = 2;
        v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
        ** if (v1 != var21_5) goto lbl54
lbl53:
        // 1 sources

        return var21_5;
lbl54:
        // 1 sources

        ** GOTO lbl68
        {
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1 = $continuation.I$1;
                $i$f$client\1\532 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl68:
                // 2 sources

                var11_19 = v1;
                ResultKt.throwOnFailure((Object)var11_19);
                v2 = var11_19;
                if (!(v2 instanceof PlaylistClient)) {
                    v2 = null;
                }
                v3 = (PlaylistClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(PlaylistClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\899\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_22 = v4;
                    throw new ClientException.NotSupported(var20_22);
                }
                $this$loadFeed_u24lambda_u2425\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadFeed$8\5\901\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)playlist);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = extension;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$loadFeed_u24lambda_u2425\5);
                $continuation.I$0 = $i$f$client\1\532;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadFeed$8\5\901\0;
                $continuation.label = 3;
                v5 = $this$loadFeed_u24lambda_u2425\5.loadFeed(playlist, (Continuation<? super Feed<Shelf>>)$continuation);
                ** if (v5 != var21_5) goto lbl101
lbl100:
                // 1 sources

                return var21_5;
lbl101:
                // 1 sources

                ** GOTO lbl118
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadFeed$8\5\901\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1 = $continuation.I$1;
                $i$f$client\1\532 = $continuation.I$0;
                $this$loadFeed_u24lambda_u2425\5 = (PlaylistClient)$continuation.L$7;
                client\2 = (PlaylistClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                playlist = (Playlist)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl118:
                    // 2 sources

                    v6 = (Feed)v5;
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)(v6 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, v6, extension) : null));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\897\1));
                }
                var8_15 = $this$client_u24lambda_u244\2;
                v7 = Result.exceptionOrNull-impl((Object)var8_15);
                if (v7 != null) {
                    it\4 = v7;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\902\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_15;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object saveToLibrary(@NotNull EchoMediaItem item2, boolean shouldSave, @NotNull Continuation<? super Unit> $completion) {
        if (shouldSave) {
            Object object = this.db.save(item2, $completion);
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return object;
            }
            return Unit.INSTANCE;
        }
        Object object = this.db.deleteSaved(item2, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object isItemSaved(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        return this.db.isSaved(item2, $completion);
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
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                Object L$7;
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
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
                v0 = this.db.getCreatedPlaylists((Continuation<? super List<Playlist>>)$continuation);
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

                $this$map\1 = (Iterable)v0;
                $i$f$map\1\545 = 0;
                var5_8 = $this$map\1;
                destination\2 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                $i$f$mapTo\2\903 = 0;
                var8_11 = $this$mapTo\2.iterator();
lbl28:
                // 2 sources

                while (var8_11.hasNext()) {
                    item\2 = var8_11.next();
                    var10_13 = (Playlist)item\2;
                    var19_22 = destination\2;
                    $i$a$-map-UnifiedExtension$listEditablePlaylists$2\3\905\0 = 0;
                    $continuation.L$0 = track;
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$map\1);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$mapTo\2);
                    $continuation.L$3 = destination\2;
                    $continuation.L$4 = var8_11;
                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)item\2);
                    $continuation.L$6 = it\3;
                    $continuation.L$7 = var19_22;
                    $continuation.I$0 = $i$f$map\1\545;
                    $continuation.I$1 = $i$f$mapTo\2\903;
                    $continuation.I$2 = $i$a$-map-UnifiedExtension$listEditablePlaylists$2\3\905\0;
                    $continuation.label = 2;
                    v1 = this.db.getTracks(it\3, (Continuation<? super List<Track>>)$continuation);
                    if (v1 == var22_5) {
                        return var22_5;
                    }
                    ** GOTO lbl64
                }
                break;
            }
            case 2: {
                $i$a$-map-UnifiedExtension$listEditablePlaylists$2\3\905\0 = $continuation.I$2;
                $i$f$mapTo\2\903 = $continuation.I$1;
                $i$f$map\1\545 = $continuation.I$0;
                var19_22 = (Collection)$continuation.L$7;
                it\3 = (Playlist)$continuation.L$6;
                item\2 = $continuation.L$5;
                var8_11 = (Iterator<T>)$continuation.L$4;
                destination\2 = (Collection)$continuation.L$3;
                $this$mapTo\2 = (Iterable)$continuation.L$2;
                $this$map\1 = (Iterable)$continuation.L$1;
                track = (Track)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl64:
                // 2 sources

                $this$any\4 = (Iterable)v1;
                $i$f$any\4\546 = false;
                if (!($this$any\4 instanceof Collection) || !((Collection)$this$any\4).isEmpty()) ** GOTO lbl69
                v2 = false;
                ** GOTO lbl77
lbl69:
                // 2 sources

                for (T element\4 : $this$any\4) {
                    t\5 = (Track)element\4;
                    $i$a$-any-UnifiedExtension$listEditablePlaylists$2$has$1\5\907\3 = false;
                    v3 = track;
                    if (!Intrinsics.areEqual((Object)t\5.getId(), (Object)(v3 != null ? v3.getId() : null))) continue;
                    v2 = true;
                    ** GOTO lbl77
                }
                v2 = false;
lbl77:
                // 3 sources

                has\3 = v2;
                var19_22.add(TuplesKt.to((Object)it\3, (Object)Boxing.boxBoolean((boolean)(has\3 != false))));
                ** GOTO lbl28
            }
        }
        return (List)destination\2;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object createPlaylist(@NotNull String title, @Nullable String description, @NotNull Continuation<? super Playlist> $completion) {
        return UnifiedDatabase.createPlaylist$default(this.db, title, description, null, null, $completion, 12, null);
    }

    @NotNull
    public final File getCoverDir() {
        return this.coverDir;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object deletePlaylist(@NotNull Playlist playlist, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof deletePlaylist.1)) ** GOTO lbl-1000
        var6_3 = $completion;
        if ((var6_3.label & -2147483648) != 0) {
            var6_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.deletePlaylist(null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = playlist;
                $continuation.label = 1;
                v0 = this.db.deletePlaylist(playlist, (Continuation<? super Unit>)$continuation);
                if (v0 == var7_5) {
                    return var7_5;
                }
                ** GOTO lbl22
            }
            case 1: {
                playlist = (Playlist)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl22:
                // 2 sources

                it\1 = new File(this.coverDir, playlist.getId());
                $i$a$-let-UnifiedExtension$deletePlaylist$2\1\557\0 = false;
                if (it\1.exists()) {
                    it\1.delete();
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object editPlaylistMetadata(@NotNull Playlist playlist, @NotNull String title, @Nullable String description, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.db.editPlaylistMetadata(playlist, title, description, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object editPlaylistCover(@NotNull Playlist playlist, @Nullable File cover, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.db.editPlaylistCover(playlist, cover, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object addTracksToPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, int index, @NotNull List<Track> list2, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.db.addTracksToPlaylist(playlist, index, list2, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object removeTracksFromPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, @NotNull List<Integer> indexes2, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.db.removeTracksFromPlaylist(playlist, tracks, indexes2, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object moveTrackInPlaylist(@NotNull Playlist playlist, @NotNull List<Track> tracks, int fromIndex, int toIndex, @NotNull Continuation<? super Unit> $completion) {
        Object object = this.db.moveTrack(playlist, fromIndex, toIndex, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object searchTrackLyrics(@NotNull String clientId, @NotNull Track track, @NotNull Continuation<? super Feed<Lyrics>> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[SWITCH], 7[CASE]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object loadLyrics(@NotNull Lyrics lyrics, @NotNull Continuation<? super Lyrics> $completion) {
        if (!($completion instanceof loadLyrics.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadLyrics(null, (Continuation<? super Lyrics>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                extId = UnifiedExtension.Companion.getExtensionId(lyrics.getExtras());
                var4_7 = UnifiedExtension.Companion;
                var17_9 = UnifiedExtension.Companion;
                $continuation.L$0 = lyrics;
                $continuation.L$1 = extId;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)var4_7);
                $continuation.L$3 = var17_9;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl31
            }
            case 1: {
                var17_9 = (Companion)$continuation.L$3;
                var4_7 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                lyrics = (Lyrics)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 2 sources

                $this$client\1 = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_9, (List)v0, extId);
                $i$f$client\1\609 = 0;
                var7_13 = $this$client\1;
                $this$client_u24lambda_u244\2 = var7_13;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1 = 0;
                $continuation.L$0 = lyrics;
                $continuation.L$1 = extId;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\609;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl63
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1 = $continuation.I$1;
                $i$f$client\1\609 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                lyrics = (Lyrics)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl63:
                // 2 sources

                var10_17 = v1;
                ResultKt.throwOnFailure((Object)var10_17);
                v2 = var10_17;
                if (!(v2 instanceof LyricsClient)) {
                    v2 = null;
                }
                v3 = (LyricsClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(LyricsClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\917\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_20 = v4;
                    throw new ClientException.NotSupported(var20_20);
                }
                $this$loadLyrics_u24lambda_u2430\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$loadLyrics$2\5\919\0 = 0;
                var16_27 = UnifiedExtension.Companion;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)lyrics);
                $continuation.L$1 = extId;
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$3 = $this$client\1;
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)$this$loadLyrics_u24lambda_u2430\5);
                $continuation.L$7 = var16_27;
                $continuation.I$0 = $i$f$client\1\609;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$loadLyrics$2\5\919\0;
                $continuation.label = 3;
                v5 = $this$loadLyrics_u24lambda_u2430\5.loadLyrics(lyrics, (Continuation<? super Lyrics>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$loadLyrics$2\5\919\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1 = $continuation.I$1;
                $i$f$client\1\609 = $continuation.I$0;
                var16_27 = (Companion)$continuation.L$7;
                $this$loadLyrics_u24lambda_u2430\5 = (LyricsClient)$continuation.L$6;
                client\2 = (LyricsClient)$continuation.L$5;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$4;
                $this$client\1 = (Extension)$continuation.L$3;
                this_\1 = (Companion)$continuation.L$2;
                extId = (String)$continuation.L$1;
                lyrics = (Lyrics)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(var16_27, (Lyrics)v5, extId));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\915\1));
                }
                var7_13 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var7_13);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\920\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var7_13;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object onTrackChanged(@Nullable TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[SWITCH], 7[CASE]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object onMarkAsPlayed(@NotNull TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[SWITCH], 7[CASE]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object onPlayingStateChanged(@Nullable TrackDetails details, boolean isPlaying, @NotNull Continuation<? super Unit> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[SWITCH], 7[CASE]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Exception decompiling
     */
    @Override
    @Nullable
    public Object getMarkAsPlayedDuration(@NotNull TrackDetails details, @NotNull Continuation<? super Long> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[CASE], 3[SWITCH]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object onShare(@NotNull EchoMediaItem item, @NotNull Continuation<? super String> $completion) {
        if (!($completion instanceof onShare.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.onShare(null, (Continuation<? super String>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_11 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\642 = 0;
                var8_16 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_16;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\642;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1 = $continuation.I$1;
                $i$f$client\1\642 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_20 = v1;
                ResultKt.throwOnFailure((Object)var11_20);
                v2 = var11_20;
                if (!(v2 instanceof ShareClient)) {
                    v2 = null;
                }
                v3 = (ShareClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(ShareClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\943\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_23 = v4;
                    throw new ClientException.NotSupported(var20_23);
                }
                $this$onShare_u24lambda_u2435\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$onShare$2\5\945\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$onShare_u24lambda_u2435\5);
                $continuation.I$0 = $i$f$client\1\642;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$onShare$2\5\945\0;
                $continuation.label = 3;
                v5 = $this$onShare_u24lambda_u2435\5.onShare(item, (Continuation<? super String>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$onShare$2\5\945\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1 = $continuation.I$1;
                $i$f$client\1\642 = $continuation.I$0;
                $this$onShare_u24lambda_u2435\5 = (ShareClient)$continuation.L$7;
                client\2 = (ShareClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)((String)v5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\941\1));
                }
                var8_16 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_16);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\946\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_16;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object isFollowing(@NotNull EchoMediaItem item, @NotNull Continuation<? super Boolean> $completion) {
        if (!($completion instanceof isFollowing.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.isFollowing(null, (Continuation<? super Boolean>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_11 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\648 = 0;
                var8_16 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_16;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\648;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1 = $continuation.I$1;
                $i$f$client\1\648 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_20 = v1;
                ResultKt.throwOnFailure((Object)var11_20);
                v2 = var11_20;
                if (!(v2 instanceof FollowClient)) {
                    v2 = null;
                }
                v3 = (FollowClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(FollowClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\949\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_23 = v4;
                    throw new ClientException.NotSupported(var20_23);
                }
                $this$isFollowing_u24lambda_u2436\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$isFollowing$2\5\951\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$isFollowing_u24lambda_u2436\5);
                $continuation.I$0 = $i$f$client\1\648;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$isFollowing$2\5\951\0;
                $continuation.label = 3;
                v5 = $this$isFollowing_u24lambda_u2436\5.isFollowing(item, (Continuation<? super Boolean>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$isFollowing$2\5\951\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1 = $continuation.I$1;
                $i$f$client\1\648 = $continuation.I$0;
                $this$isFollowing_u24lambda_u2436\5 = (FollowClient)$continuation.L$7;
                client\2 = (FollowClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)Boxing.boxBoolean((boolean)((Boolean)v5)));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\947\1));
                }
                var8_16 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_16);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\952\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_16;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object getFollowersCount(@NotNull EchoMediaItem item, @NotNull Continuation<? super Long> $completion) {
        if (!($completion instanceof getFollowersCount.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getFollowersCount(null, (Continuation<? super Long>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_11 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\654 = 0;
                var8_16 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_16;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\654;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1 = $continuation.I$1;
                $i$f$client\1\654 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_20 = v1;
                ResultKt.throwOnFailure((Object)var11_20);
                v2 = var11_20;
                if (!(v2 instanceof FollowClient)) {
                    v2 = null;
                }
                v3 = (FollowClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(FollowClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\955\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_23 = v4;
                    throw new ClientException.NotSupported(var20_23);
                }
                $this$getFollowersCount_u24lambda_u2437\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$getFollowersCount$2\5\957\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$getFollowersCount_u24lambda_u2437\5);
                $continuation.I$0 = $i$f$client\1\654;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$getFollowersCount$2\5\957\0;
                $continuation.label = 3;
                v5 = $this$getFollowersCount_u24lambda_u2437\5.getFollowersCount(item, (Continuation<? super Long>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$getFollowersCount$2\5\957\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1 = $continuation.I$1;
                $i$f$client\1\654 = $continuation.I$0;
                $this$getFollowersCount_u24lambda_u2437\5 = (FollowClient)$continuation.L$7;
                client\2 = (FollowClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)((Long)v5));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\953\1));
                }
                var8_16 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_16);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\958\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_16;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object followItem(@NotNull EchoMediaItem item, boolean shouldFollow, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof followItem.1)) ** GOTO lbl-1000
        var20_4 = $completion;
        if ((var20_4.label & -2147483648) != 0) {
            var20_4.label -= -2147483648;
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
                boolean Z$0;
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.followItem(null, false, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var18_9 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_9;
                $continuation.Z$0 = shouldFollow;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_6) {
                    return var22_6;
                }
                ** GOTO lbl30
            }
            case 1: {
                shouldFollow = $continuation.Z$0;
                var18_9 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl30:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_9, (List)v0, id);
                var6_12 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\660 = 0;
                var9_17 = $this$client\1;
                $this$client_u24lambda_u244\2 = var9_17;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.Z$0 = shouldFollow;
                $continuation.I$0 = $i$f$client\1\660;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_6) goto lbl53
lbl52:
                // 1 sources

                return var22_6;
lbl53:
                // 1 sources

                ** GOTO lbl68
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1 = $continuation.I$1;
                $i$f$client\1\660 = $continuation.I$0;
                shouldFollow = $continuation.Z$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl68:
                // 2 sources

                var12_21 = v1;
                ResultKt.throwOnFailure((Object)var12_21);
                v2 = var12_21;
                if (!(v2 instanceof FollowClient)) {
                    v2 = null;
                }
                v3 = (FollowClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(FollowClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\961\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_24 = v4;
                    throw new ClientException.NotSupported(var21_24);
                }
                $this$followItem_u24lambda_u2438\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$followItem$2\5\963\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$followItem_u24lambda_u2438\5);
                $continuation.Z$0 = shouldFollow;
                $continuation.I$0 = $i$f$client\1\660;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$followItem$2\5\963\0;
                $continuation.label = 3;
                v5 = $this$followItem_u24lambda_u2438\5.followItem(item, shouldFollow != false, (Continuation<? super Unit>)$continuation);
                ** if (v5 != var22_6) goto lbl102
lbl101:
                // 1 sources

                return var22_6;
lbl102:
                // 1 sources

                ** GOTO lbl121
            }
            case 3: {
                $i$a$-client-UnifiedExtension$followItem$2\5\963\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1 = $continuation.I$1;
                $i$f$client\1\660 = $continuation.I$0;
                shouldFollow = $continuation.Z$0;
                $this$followItem_u24lambda_u2438\5 = (FollowClient)$continuation.L$7;
                client\2 = (FollowClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl121:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\959\1));
                }
                var9_17 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var9_17);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\964\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
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
    public Object likeItem(@NotNull EchoMediaItem item, boolean shouldLike, @NotNull Continuation<? super Unit> $completion) {
        block18: {
            if (!($completion instanceof likeItem.1)) ** GOTO lbl-1000
            var18_4 = $completion;
            if ((var18_4.label & -2147483648) != 0) {
                var18_4.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    boolean Z$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ UnifiedExtension this$0;
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
            var19_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    if (!(item instanceof Track)) {
                        throw new ClientException.NotSupported("LikeItem only supports Track");
                    }
                    $continuation.L$0 = item;
                    $continuation.Z$0 = shouldLike;
                    $continuation.label = 1;
                    v0 = this.db.getLikedPlaylist((Context)this.context, (Continuation<? super Playlist>)$continuation);
                    if (v0 == var19_6) {
                        return var19_6;
                    }
                    ** GOTO lbl26
                }
                case 1: {
                    shouldLike = $continuation.Z$0;
                    item = (EchoMediaItem)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl26:
                    // 2 sources

                    likedPlaylist = (Playlist)v0;
                    var13_10 = Feed.Companion;
                    $continuation.L$0 = item;
                    $continuation.L$1 = likedPlaylist;
                    $continuation.L$2 = var13_10;
                    $continuation.Z$0 = shouldLike;
                    $continuation.label = 2;
                    v1 = this.loadTracks(likedPlaylist, (Continuation<? super Feed<Track>>)$continuation);
                    if (v1 == var19_6) {
                        return var19_6;
                    }
                    ** GOTO lbl44
                }
                case 2: {
                    shouldLike = $continuation.Z$0;
                    var13_10 = (Feed.Companion)$continuation.L$2;
                    likedPlaylist = (Playlist)$continuation.L$1;
                    item = (EchoMediaItem)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl44:
                    // 2 sources

                    $continuation.L$0 = item;
                    $continuation.L$1 = likedPlaylist;
                    $continuation.L$2 = null;
                    $continuation.Z$0 = shouldLike;
                    $continuation.label = 3;
                    v2 = var13_10.loadAll((Feed)v1, $continuation);
                    if (v2 == var19_6) {
                        return var19_6;
                    }
                    ** GOTO lbl59
                }
                case 3: {
                    shouldLike = $continuation.Z$0;
                    likedPlaylist = (Playlist)$continuation.L$1;
                    item = (EchoMediaItem)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = $result;
lbl59:
                    // 2 sources

                    tracks = (List)v2;
                    if (!shouldLike) break;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)likedPlaylist);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)tracks);
                    $continuation.Z$0 = shouldLike;
                    $continuation.label = 4;
                    v3 = this.addTracksToPlaylist(likedPlaylist, tracks, 0, CollectionsKt.listOf((Object)item), (Continuation<? super Unit>)$continuation);
                    if (v3 == var19_6) {
                        return var19_6;
                    }
                    ** GOTO lbl77
                }
                case 4: {
                    shouldLike = $continuation.Z$0;
                    tracks = (List)$continuation.L$2;
                    likedPlaylist = (Playlist)$continuation.L$1;
                    item = (EchoMediaItem)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v3 = $result;
lbl77:
                    // 2 sources

                    return Unit.INSTANCE;
                }
            }
            var6_14 = tracks;
            var15_15 = tracks;
            var14_16 = likedPlaylist;
            var13_10 = this;
            $i$f$indexOfFirst\1\669 = false;
            index\1 = 0;
            for (E item\1 : $this$indexOfFirst\1) {
                it\2 = (Track)item\1;
                $i$a$-indexOfFirst-UnifiedExtension$likeItem$2\2\967\0 = false;
                if (Intrinsics.areEqual((Object)it\2.getId(), (Object)((Track)item).getId())) {
                    v4 = index\1;
                    break block18;
                }
                ++index\1;
            }
            v4 = -1;
        }
        var16_23 = v4;
        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)likedPlaylist);
        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)tracks);
        $continuation.Z$0 = shouldLike;
        $continuation.label = 5;
        v5 = var13_10.removeTracksFromPlaylist(var14_16, var15_15, CollectionsKt.listOf((Object)Boxing.boxInt((int)var16_23)), (Continuation<? super Unit>)$continuation);
        if (v5 == var19_6) {
            return var19_6;
        }
        ** GOTO lbl111
        {
            case 5: {
                shouldLike = $continuation.Z$0;
                tracks = (List)$continuation.L$2;
                likedPlaylist = (Playlist)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v5 = $result;
lbl111:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    @Nullable
    public Object isItemLiked(@NotNull EchoMediaItem item2, @NotNull Continuation<? super Boolean> $completion) {
        if (!(item2 instanceof Track)) {
            throw new ClientException.NotSupported("IsItemLiked only supports Track");
        }
        return this.db.isLiked((Track)item2, $completion);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object hideItem(@NotNull EchoMediaItem item, boolean shouldHide, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof hideItem.1)) ** GOTO lbl-1000
        var20_4 = $completion;
        if ((var20_4.label & -2147483648) != 0) {
            var20_4.label -= -2147483648;
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
                boolean Z$0;
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.hideItem(null, false, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var22_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var18_9 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var18_9;
                $continuation.Z$0 = shouldHide;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var22_6) {
                    return var22_6;
                }
                ** GOTO lbl30
            }
            case 1: {
                shouldHide = $continuation.Z$0;
                var18_9 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl30:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var18_9, (List)v0, id);
                var6_12 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\681 = 0;
                var9_17 = $this$client\1;
                $this$client_u24lambda_u244\2 = var9_17;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.Z$0 = shouldHide;
                $continuation.I$0 = $i$f$client\1\681;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var22_6) goto lbl53
lbl52:
                // 1 sources

                return var22_6;
lbl53:
                // 1 sources

                ** GOTO lbl68
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1 = $continuation.I$1;
                $i$f$client\1\681 = $continuation.I$0;
                shouldHide = $continuation.Z$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl68:
                // 2 sources

                var12_21 = v1;
                ResultKt.throwOnFailure((Object)var12_21);
                v2 = var12_21;
                if (!(v2 instanceof HideClient)) {
                    v2 = null;
                }
                v3 = (HideClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(HideClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\974\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var21_24 = v4;
                    throw new ClientException.NotSupported(var21_24);
                }
                $this$hideItem_u24lambda_u2440\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$hideItem$2\5\976\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$hideItem_u24lambda_u2440\5);
                $continuation.Z$0 = shouldHide;
                $continuation.I$0 = $i$f$client\1\681;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$hideItem$2\5\976\0;
                $continuation.label = 3;
                v5 = $this$hideItem_u24lambda_u2440\5.hideItem(item, shouldHide != false, (Continuation<? super Unit>)$continuation);
                ** if (v5 != var22_6) goto lbl102
lbl101:
                // 1 sources

                return var22_6;
lbl102:
                // 1 sources

                ** GOTO lbl121
            }
            case 3: {
                $i$a$-client-UnifiedExtension$hideItem$2\5\976\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1 = $continuation.I$1;
                $i$f$client\1\681 = $continuation.I$0;
                shouldHide = $continuation.Z$0;
                $this$hideItem_u24lambda_u2440\5 = (HideClient)$continuation.L$7;
                client\2 = (HideClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl121:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\972\1));
                }
                var9_17 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var9_17);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\977\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
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
    public Object isItemHidden(@NotNull EchoMediaItem item, @NotNull Continuation<? super Boolean> $completion) {
        if (!($completion instanceof isItemHidden.1)) ** GOTO lbl-1000
        var19_3 = $completion;
        if ((var19_3.label & -2147483648) != 0) {
            var19_3.label -= -2147483648;
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
                int I$0;
                int I$1;
                int I$2;
                /* synthetic */ Object result;
                final /* synthetic */ UnifiedExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.isItemHidden(null, (Continuation<? super Boolean>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var21_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                id = UnifiedExtension.Companion.getExtensionId(item.getExtras());
                var17_8 = UnifiedExtension.Companion;
                $continuation.L$0 = item;
                $continuation.L$1 = id;
                $continuation.L$2 = var17_8;
                $continuation.label = 1;
                v0 = this.extensions((Continuation<? super List<MusicExtension>>)$continuation);
                if (v0 == var21_5) {
                    return var21_5;
                }
                ** GOTO lbl28
            }
            case 1: {
                var17_8 = (Companion)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl28:
                // 2 sources

                extension = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$get(var17_8, (List)v0, id);
                var5_11 = UnifiedExtension.Companion;
                $this$client\1 = extension;
                $i$f$client\1\687 = 0;
                var8_16 = $this$client\1;
                $this$client_u24lambda_u244\2 = var8_16;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1 = 0;
                $continuation.L$0 = item;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.I$0 = $i$f$client\1\687;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1;
                $continuation.label = 2;
                v1 = $this$client_u24lambda_u244\2.getInstance().value-IoAF18A($continuation);
                ** if (v1 != var21_5) goto lbl50
lbl49:
                // 1 sources

                return var21_5;
lbl50:
                // 1 sources

                ** GOTO lbl64
            }
            case 2: {
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1 = $continuation.I$1;
                $i$f$client\1\687 = $continuation.I$0;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl64:
                // 2 sources

                var11_20 = v1;
                ResultKt.throwOnFailure((Object)var11_20);
                v2 = var11_20;
                if (!(v2 instanceof HideClient)) {
                    v2 = null;
                }
                v3 = (HideClient)v2;
                if (v3 == null) {
                    $this$client_u24lambda_u244_u24lambda_u243\3 = Reflection.getOrCreateKotlinClass(HideClient.class);
                    $i$a$-run-UnifiedExtension$Companion$client$2$client$1\3\980\2 = false;
                    v4 = $this$client_u24lambda_u244_u24lambda_u243\3.getSimpleName();
                    if (v4 == null) {
                        v4 = JvmClassMappingKt.getJavaClass((KClass)$this$client_u24lambda_u244_u24lambda_u243\3).getName();
                    }
                    Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"run(...)");
                    var20_23 = v4;
                    throw new ClientException.NotSupported(var20_23);
                }
                $this$isItemHidden_u24lambda_u2441\5 = client\2 = v3;
                $i$a$-client-UnifiedExtension$isItemHidden$2\5\982\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)item);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)extension);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$4 = $this$client\1;
                $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$client_u24lambda_u244\2);
                $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)client\2);
                $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$isItemHidden_u24lambda_u2441\5);
                $continuation.I$0 = $i$f$client\1\687;
                $continuation.I$1 = $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1;
                $continuation.I$2 = $i$a$-client-UnifiedExtension$isItemHidden$2\5\982\0;
                $continuation.label = 3;
                v5 = $this$isItemHidden_u24lambda_u2441\5.isItemHidden(item, (Continuation<? super Boolean>)$continuation);
                ** if (v5 != var21_5) goto lbl97
lbl96:
                // 1 sources

                return var21_5;
lbl97:
                // 1 sources

                ** GOTO lbl115
            }
            case 3: {
                $i$a$-client-UnifiedExtension$isItemHidden$2\5\982\0 = $continuation.I$2;
                $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1 = $continuation.I$1;
                $i$f$client\1\687 = $continuation.I$0;
                $this$isItemHidden_u24lambda_u2441\5 = (HideClient)$continuation.L$7;
                client\2 = (HideClient)$continuation.L$6;
                $this$client_u24lambda_u244\2 = (Extension)$continuation.L$5;
                $this$client\1 = (Extension)$continuation.L$4;
                this_\1 = (Companion)$continuation.L$3;
                extension = (Extension)$continuation.L$2;
                id = (String)$continuation.L$1;
                item = (EchoMediaItem)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v5 = $result;
lbl115:
                    // 2 sources

                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)Boxing.boxBoolean((boolean)((Boolean)v5)));
                }
                catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1) {
                    $this$client_u24lambda_u244\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$client$2\2\978\1));
                }
                var8_16 = $this$client_u24lambda_u244\2;
                v6 = Result.exceptionOrNull-impl((Object)var8_16);
                if (v6 != null) {
                    it\4 = v6;
                    $i$a$-getOrElse-UnifiedExtension$Companion$client$3\4\983\1 = false;
                    throw AppException.Companion.toAppException(it\4, $this$client\1);
                }
                return var8_16;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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

    public static final /* synthetic */ Application access$getContext$p(UnifiedExtension $this) {
        return $this.context;
    }

    public static final /* synthetic */ Object access$getCached(UnifiedExtension $this, Continuation $completion) {
        return $this.getCached((Continuation<? super List<Track>>)$completion);
    }

    public static final /* synthetic */ void access$setCachedTracks$p(UnifiedExtension $this, List list2) {
        $this.cachedTracks = list2;
    }

    public static final /* synthetic */ Playlist access$cachePlaylist(UnifiedExtension $this) {
        return $this.cachePlaylist();
    }

    public static final /* synthetic */ List access$getCachedTracks$p(UnifiedExtension $this) {
        return $this.cachedTracks;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J=\u0010\u0012\u001a\u0002H\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0004\b\u0001\u0010\u0013*\u0006\u0012\u0002\b\u00030\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00130\u0017\u00a2\u0006\u0002\b\u0018H\u0086H\u00a2\u0006\u0002\u0010\u0019J?\u0010\u001a\u001a\u0004\u0018\u0001H\u0013\"\u0006\b\u0000\u0010\u0014\u0018\u0001\"\u0004\b\u0001\u0010\u0013*\u0006\u0012\u0002\b\u00030\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00130\u0017\u00a2\u0006\u0002\b\u0018H\u0086H\u00a2\u0006\u0002\u0010\u0019J$\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0015*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010\"\u001a\u00020#*\u00020#2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010$\u001a\u00020%J\u001e\u0010\"\u001a\u00020&*\u00020&2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\"\u001a\u00020'*\u00020'2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\"\u001a\u00020(*\u00020(2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\"\u001a\u00020)*\u00020)2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010\"\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\"\u001a\u00020**\u00020*2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001c\u0010\"\u001a\u00020+*\u00020+2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\"\u001a\u00020,*\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\f*\b\u0012\u0004\u0012\u00020\r0\f2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J$\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\f*\b\u0012\u0004\u0012\u00020#0\f2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\"\u00100\u001a\b\u0012\u0004\u0012\u00020*0\f*\b\u0012\u0004\u0012\u00020*0\f2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015J\u0018\u0010\"\u001a\u000201*\u0002012\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\r02*\b\u0012\u0004\u0012\u00020\r022\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\u0012\u00103\u001a\u000204*\u0002042\u0006\u0010\u001c\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u001e\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001f8F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u00065"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension$Companion;", "", "<init>", "()V", "UNIFIED_ID", "", "EXTENSION_ID", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "getFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "Landroid/content/Context;", "items", "", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "client", "T", "C", "Ldev/brahmkshatriya/echo/common/Extension;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clientOrNull", "get", "id", "getOrNull", "extensionId", "", "getExtensionId", "(Ljava/util/Map;)Ljava/lang/String;", "withExtensionId", "Ldev/brahmkshatriya/echo/common/models/Track;", "cached", "", "Ldev/brahmkshatriya/echo/common/models/Album;", "Ldev/brahmkshatriya/echo/common/models/Artist;", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "Ldev/brahmkshatriya/echo/common/models/Radio;", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "extension", "injectExtensionId", "injectExtension", "injectLyricsExtId", "Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "injectId", "Ldev/brahmkshatriya/echo/common/models/Tab;", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nUnifiedExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnifiedExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,689:1\n1491#2:690\n1516#2,3:691\n1519#2,3:701\n1563#2:705\n1634#2,3:706\n1563#2:709\n1634#2,3:710\n1563#2:713\n1634#2,3:714\n1563#2:717\n1634#2,3:718\n1563#2:721\n1634#2,3:722\n1563#2:725\n1634#2,3:726\n1563#2:729\n1634#2,3:730\n1563#2:733\n1634#2,3:734\n1563#2:737\n1634#2,3:738\n382#3,7:694\n1#4:704\n*S KotlinDebug\n*F\n+ 1 UnifiedExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension$Companion\n*L\n91#1:690\n91#1:691,3\n91#1:701,3\n102#1:705\n102#1:706,3\n135#1:709\n135#1:710,3\n136#1:713\n136#1:714,3\n148#1:717\n148#1:718,3\n170#1:721\n170#1:722,3\n208#1:725\n208#1:726,3\n214#1:729\n214#1:730,3\n225#1:733\n225#1:734,3\n239#1:737\n239#1:738,3\n91#1:694,7\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final dev.brahmkshatriya.echo.common.models.Metadata getMetadata() {
            return metadata;
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Feed<Shelf> getFeed(@NotNull Context $this$getFeed, @NotNull List<? extends EchoMediaItem> items2) {
            List list2;
            void $this$groupByTo\2;
            Intrinsics.checkNotNullParameter((Object)$this$getFeed, (String)"<this>");
            Intrinsics.checkNotNullParameter(items2, (String)"items");
            if (items2.isEmpty()) {
                return Feed.Companion.toFeed$default(Feed.Companion, CollectionsKt.emptyList(), null, null, 3, null);
            }
            Iterable iterable = items2;
            boolean bl6 = false;
            Iterable iterable2 = iterable;
            Map map2 = new LinkedHashMap();
            boolean bl2 = false;
            for (Object t : $this$groupByTo\2) {
                Object object;
                String string2;
                EchoMediaItem echoMediaItem = (EchoMediaItem)t;
                boolean bl3 = false;
                EchoMediaItem echoMediaItem2 = echoMediaItem;
                if (echoMediaItem2 instanceof Track) {
                    string2 = $this$getFeed.getString(R.string.track);
                } else if (echoMediaItem2 instanceof Album) {
                    string2 = $this$getFeed.getString(R.string.album);
                } else if (echoMediaItem2 instanceof Artist) {
                    string2 = $this$getFeed.getString(R.string.artists);
                } else if (echoMediaItem2 instanceof Playlist) {
                    string2 = $this$getFeed.getString(R.string.playlist);
                } else if (echoMediaItem2 instanceof Radio) {
                    string2 = $this$getFeed.getString(R.string.radio);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                String string3 = string2;
                Map map3 = map2;
                boolean bl4 = false;
                Object v = map3.get(string3);
                if (v == null) {
                    boolean bl5 = false;
                    List list3 = new ArrayList();
                    map3.put(string3, list3);
                    object = list3;
                } else {
                    object = v;
                }
                List list4 = (List)object;
                list4.add(t);
            }
            Map types = map2;
            if (types.keySet().size() == 1) {
                list2 = CollectionsKt.emptyList();
            } else {
                void $this$mapTo\8;
                void $this$map\7;
                String string4 = $this$getFeed.getString(R.string.all);
                boolean $i$a$-let-UnifiedExtension$Companion$getFeed$tabs$1\6\101\12 = false;
                Intrinsics.checkNotNull((Object)string4);
                Iterable bl6 = types.keySet();
                Collection collection = CollectionsKt.listOf((Object)new Tab(string4, string4, false, null, 12, null));
                boolean bl7 = false;
                void $i$a$-let-UnifiedExtension$Companion$getFeed$tabs$1\6\101\12 = $this$map\7;
                Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\7, (int)10));
                boolean bl8 = false;
                for (Object t : $this$mapTo\8) {
                    void it\9;
                    String bl3 = (String)t;
                    Collection collection3 = collection2;
                    boolean bl9 = false;
                    Intrinsics.checkNotNull((Object)it\9);
                    collection3.add(new Tab((String)it\9, (String)it\9, true, null, 8, null));
                }
                list2 = CollectionsKt.plus((Collection)collection, (Iterable)((List)collection2));
            }
            List tabs = list2;
            return new Feed<Shelf>(tabs, (Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>((Map<String, ? extends List<? extends EchoMediaItem>>)types, items2, null){
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Map<String, List<EchoMediaItem>> $types;
                final /* synthetic */ List<EchoMediaItem> $items;
                {
                    this.$types = $types;
                    this.$items = $items;
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
                            void $this$mapTo\2;
                            void $this$map\1;
                            void tab2;
                            ResultKt.throwOnFailure((Object)$result);
                            void v0 = tab2;
                            List<EchoMediaItem> list2 = this.$types.get(v0 != null ? v0.getId() : null);
                            if (list2 == null || (list2 = CollectionsKt.toList((Iterable)list2)) == null) {
                                list2 = this.$items;
                            }
                            List<EchoMediaItem> items2 = list2;
                            Iterable iterable = items2;
                            Feed.Companion companion = Feed.Companion;
                            boolean bl = false;
                            void var6_7 = $this$map\1;
                            Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                            boolean bl2 = false;
                            for (T t : $this$mapTo\2) {
                                void it\3;
                                EchoMediaItem echoMediaItem = (EchoMediaItem)t;
                                Collection collection2 = collection;
                                boolean bl3 = false;
                                collection2.add(it\3.toShelf());
                            }
                            return Feed.Companion.toFeedData$default(companion, (List)collection, null, null, 3, null);
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
            });
        }

        public final /* synthetic */ <C, T> Object client(Extension<?> $this$client, Function1<? super C, ? extends T> block, Continuation<? super T> $completion) {
            Object object;
            boolean $i$f$client = false;
            Object object2 = $this$client;
            try {
                object = object2;
                boolean bl = false;
                Injectable injectable = ((Extension)object).getInstance();
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                Object object3 = injectable.value-IoAF18A(null);
                InlineMarker.mark((int)1);
                InlineMarker.mark((int)8);
                InlineMarker.mark((int)9);
                Object object4 = ((Result)object3).unbox-impl();
                ResultKt.throwOnFailure((Object)object4);
                Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                Object object5 = object4;
                if (object5 == null) {
                    Intrinsics.reifiedOperationMarker((int)4, (String)"C");
                    KClass kClass = Reflection.getOrCreateKotlinClass(Object.class);
                    KClass kClass2 = kClass;
                    boolean bl2 = false;
                    String string2 = kClass2.getSimpleName();
                    if (string2 == null) {
                        string2 = JvmClassMappingKt.getJavaClass((KClass)kClass2).getName();
                    }
                    String string3 = string2;
                    object4 = string3;
                    Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"run(...)");
                    String string4 = (String)object4;
                    throw new ClientException.NotSupported(string4);
                }
                Object object6 = object5;
                object = Result.constructor-impl((Object)block.invoke(object6));
            }
            catch (Throwable bl) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            object2 = object;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object2);
            if (throwable != null) {
                Throwable throwable2 = throwable;
                boolean bl = false;
                throw AppException.Companion.toAppException(throwable2, $this$client);
            }
            return object2;
        }

        public final /* synthetic */ <C, T> Object clientOrNull(Extension<?> $this$clientOrNull, Function1<? super C, ? extends T> block, Continuation<? super T> $completion) {
            Object object;
            boolean $i$f$clientOrNull = false;
            Object object2 = $this$clientOrNull;
            try {
                object = object2;
                boolean bl = false;
                Injectable injectable = ((Extension)object).getInstance();
                InlineMarker.mark((int)3);
                InlineMarker.mark((int)0);
                Object object3 = injectable.value-IoAF18A(null);
                InlineMarker.mark((int)1);
                InlineMarker.mark((int)8);
                InlineMarker.mark((int)9);
                Object object4 = ((Result)object3).unbox-impl();
                ResultKt.throwOnFailure((Object)object4);
                Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                Object object5 = object4;
                object = Result.constructor-impl((Object)(object5 != null ? block.invoke(object5) : null));
            }
            catch (Throwable bl) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            object2 = object;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object2);
            if (throwable != null) {
                Throwable throwable2 = throwable;
                boolean bl = false;
                throw AppException.Companion.toAppException(throwable2, $this$clientOrNull);
            }
            return object2;
        }

        private final Extension<?> get(List<? extends Extension<?>> $this$get, String id2) {
            Object v0;
            block2: {
                Iterable iterable = $this$get;
                for (Object t : iterable) {
                    Extension extension2 = (Extension)t;
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)extension2.getId(), (Object)id2)) continue;
                    v0 = t;
                    break block2;
                }
                v0 = null;
            }
            Extension extension3 = v0;
            if (extension3 == null) {
                throw new Exception("Extension " + id2 + " not found");
            }
            return extension3;
        }

        private final Extension<?> getOrNull(List<? extends Extension<?>> $this$getOrNull, String id2) {
            Object v0;
            block1: {
                Iterable iterable = $this$getOrNull;
                for (Object t : iterable) {
                    Extension extension2 = (Extension)t;
                    boolean bl = false;
                    if (!Intrinsics.areEqual((Object)extension2.getId(), (Object)id2)) continue;
                    v0 = t;
                    break block1;
                }
                v0 = null;
            }
            return v0;
        }

        @NotNull
        public final String getExtensionId(@NotNull Map<String, String> $this$extensionId) {
            Intrinsics.checkNotNullParameter($this$extensionId, (String)"<this>");
            String string2 = $this$extensionId.get(UnifiedExtension.EXTENSION_ID);
            if (string2 == null) {
                throw new Exception("Extension id not found");
            }
            return string2;
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Track withExtensionId(@NotNull Track $this$withExtensionId, @NotNull String id2, @Nullable Object client, boolean cached) {
            void $this$mapTo\5;
            Collection collection;
            void $this$mapTo\2;
            Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2), TuplesKt.to((Object)"cached", (Object)String.valueOf(cached))};
            Map map2 = MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair[])pairArray));
            Album album = $this$withExtensionId.getAlbum();
            pairArray = album != null ? this.withExtensionId(album, id2, client) : null;
            Iterable iterable = $this$withExtensionId.getArtists();
            boolean bl = false;
            Iterable iterable2 = iterable;
            Iterable iterable3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Artist artist = (Artist)t;
                collection = iterable3;
                boolean bl3 = false;
                collection.add(Companion.withExtensionId((Artist)it\3, id2, client));
            }
            List list2 = (List)iterable3;
            Iterable iterable4 = $this$withExtensionId.getStreamables();
            boolean bl4 = false;
            iterable3 = iterable4;
            Collection collection2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable4, (int)10));
            boolean bl5 = false;
            for (Object t : $this$mapTo\5) {
                void it\6;
                Streamable bl3 = (Streamable)t;
                collection = collection2;
                boolean bl6 = false;
                collection.add(Streamable.copy$default((Streamable)it\6, null, 0, null, null, MapsKt.plus(it\6.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2))), 15, null));
            }
            List list3 = (List)collection2;
            boolean bl7 = client instanceof HideClient && $this$withExtensionId.isHideable();
            boolean bl8 = client instanceof RadioClient && $this$withExtensionId.isRadioSupported();
            boolean bl9 = client instanceof FollowClient && $this$withExtensionId.isFollowable();
            boolean bl10 = client instanceof ShareClient && $this$withExtensionId.isShareable();
            return Track.copy$default($this$withExtensionId, null, null, null, null, list2, (Album)pairArray, null, null, null, null, null, null, null, null, null, null, null, false, null, map2, null, list3, bl8, bl9, true, true, bl7, bl10, 1572815, null);
        }

        public static /* synthetic */ Track withExtensionId$default(Companion companion, Track track2, String string2, Object object, boolean bl, int n, Object object2) {
            if ((n & 4) != 0) {
                bl = false;
            }
            return companion.withExtensionId(track2, string2, object, bl);
        }

        /*
         * WARNING - void declaration
         */
        private final Album withExtensionId(Album $this$withExtensionId, String id2, Object client) {
            void $this$mapTo\2;
            Iterable iterable = $this$withExtensionId.getArtists();
            boolean bl = false;
            Iterable iterable2 = iterable;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Artist artist = (Artist)t;
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(Companion.withExtensionId((Artist)it\3, id2, client));
            }
            List list2 = (List)collection;
            Map map2 = MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2)));
            boolean bl4 = client instanceof HideClient && $this$withExtensionId.isHideable();
            boolean bl5 = client instanceof RadioClient && $this$withExtensionId.isRadioSupported();
            boolean bl6 = client instanceof FollowClient && $this$withExtensionId.isFollowable();
            boolean bl7 = client instanceof ShareClient && $this$withExtensionId.isShareable();
            return Album.copy$default($this$withExtensionId, null, null, null, null, list2, null, null, null, null, null, null, false, null, map2, bl5, bl6, true, false, bl4, bl7, 8175, null);
        }

        private final Artist withExtensionId(Artist $this$withExtensionId, String id2, Object client) {
            Map map2 = MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2)));
            boolean bl = client instanceof HideClient && $this$withExtensionId.isHideable();
            boolean bl2 = client instanceof RadioClient && $this$withExtensionId.isRadioSupported();
            boolean bl3 = client instanceof FollowClient && $this$withExtensionId.isFollowable();
            boolean bl4 = client instanceof ShareClient && $this$withExtensionId.isShareable();
            return Artist.copy$default($this$withExtensionId, null, null, null, null, null, null, null, map2, bl2, bl3, true, false, bl, bl4, 127, null);
        }

        /*
         * WARNING - void declaration
         */
        private final Playlist withExtensionId(Playlist $this$withExtensionId, String id2, Object client) {
            void $this$mapTo\2;
            Iterable iterable = $this$withExtensionId.getAuthors();
            boolean bl = false;
            Iterable iterable2 = iterable;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Artist artist = (Artist)t;
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(Companion.withExtensionId((Artist)it\3, id2, client));
            }
            List list2 = (List)collection;
            Map map2 = MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2)));
            boolean bl4 = client instanceof HideClient && $this$withExtensionId.isHideable();
            boolean bl5 = client instanceof RadioClient && $this$withExtensionId.isRadioSupported();
            boolean bl6 = client instanceof FollowClient && $this$withExtensionId.isFollowable();
            boolean bl7 = client instanceof ShareClient && $this$withExtensionId.isShareable();
            return Playlist.copy$default($this$withExtensionId, null, null, false, false, null, list2, null, null, null, null, null, null, map2, bl5, bl6, true, false, bl4, bl7, 4059, null);
        }

        private final Radio withExtensionId(Radio $this$withExtensionId, String id2, Object client) {
            Map map2 = MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2)));
            boolean bl = client instanceof HideClient && $this$withExtensionId.isHideable();
            boolean bl2 = client instanceof FollowClient && $this$withExtensionId.isFollowable();
            boolean bl3 = client instanceof ShareClient && $this$withExtensionId.isShareable();
            return Radio.copy$default($this$withExtensionId, null, null, null, null, null, null, null, map2, bl2, true, false, bl, bl3, 127, null);
        }

        private final EchoMediaItem withExtensionId(EchoMediaItem $this$withExtensionId, String id2, Object client) {
            EchoMediaItem echoMediaItem;
            EchoMediaItem echoMediaItem2 = $this$withExtensionId;
            if (echoMediaItem2 instanceof Artist) {
                echoMediaItem = this.withExtensionId((Artist)$this$withExtensionId, id2, client);
            } else if (echoMediaItem2 instanceof Album) {
                echoMediaItem = this.withExtensionId((Album)$this$withExtensionId, id2, client);
            } else if (echoMediaItem2 instanceof Playlist) {
                echoMediaItem = this.withExtensionId((Playlist)$this$withExtensionId, id2, client);
            } else if (echoMediaItem2 instanceof Radio) {
                echoMediaItem = this.withExtensionId((Radio)$this$withExtensionId, id2, client);
            } else if (echoMediaItem2 instanceof Track) {
                echoMediaItem = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.withExtensionId$default(this, (Track)$this$withExtensionId, id2, client, false, 4, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return echoMediaItem;
        }

        private final Lyrics withExtensionId(Lyrics $this$withExtensionId, String id2) {
            return Lyrics.copy$default($this$withExtensionId, null, null, null, null, MapsKt.plus($this$withExtensionId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2))), 15, null);
        }

        @NotNull
        public final Shelf.Item withExtensionId(@NotNull Shelf.Item $this$withExtensionId, @NotNull String id2, @Nullable Object client) {
            Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            return $this$withExtensionId.copy(this.withExtensionId($this$withExtensionId.getMedia(), id2, client));
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Feed.Buttons withExtensionId(@NotNull Feed.Buttons $this$withExtensionId, @NotNull Extension<?> extension2) {
            Collection<Track> collection;
            Intrinsics.checkNotNullParameter((Object)$this$withExtensionId, (String)"<this>");
            Intrinsics.checkNotNullParameter(extension2, (String)"extension");
            Feed.Buttons buttons2 = $this$withExtensionId;
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            List<Track> list2 = $this$withExtensionId.getCustomTrackList();
            if (list2 != null) {
                Collection<Track> collection2;
                void $this$mapTo\2;
                void $this$map\1;
                Iterable iterable = list2;
                boolean bl4 = bl3;
                boolean bl5 = bl2;
                boolean bl6 = bl;
                Feed.Buttons buttons3 = buttons2;
                boolean bl7 = false;
                void var5_9 = $this$map\1;
                Collection collection3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
                boolean bl8 = false;
                for (Object t : $this$mapTo\2) {
                    void it\3;
                    Track track2 = (Track)t;
                    collection2 = collection3;
                    boolean bl9 = false;
                    collection2.add(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.withExtensionId$default(Companion, (Track)it\3, extension2.getId(), extension2.getInstance().getValue(), false, 4, null));
                }
                collection2 = (List)collection3;
                buttons2 = buttons3;
                bl = bl6;
                bl2 = bl5;
                bl3 = bl4;
                collection = collection2;
            } else {
                collection = null;
            }
            return Feed.Buttons.copy$default(buttons2, bl, bl2, bl3, collection, 7, null);
        }

        /*
         * WARNING - void declaration
         */
        private final Feed<Shelf> injectExtensionId(Feed<Shelf> $this$injectExtensionId, Extension<?> extension2) {
            void $this$mapTo\2;
            void $this$map\1;
            Iterable iterable = $this$injectExtensionId.getTabs();
            Feed<Shelf> feed2 = $this$injectExtensionId;
            boolean bl = false;
            void var5_6 = $this$map\1;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Tab tab = (Tab)t;
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(Companion.injectId((Tab)it\3, extension2.getId()));
            }
            return feed2.copy((List)collection, (Function2<Tab, Continuation<Feed.Data<Shelf>>, Object>)((Function2)new Function2<Tab, Continuation<? super Feed.Data<Shelf>>, Object>($this$injectExtensionId, extension2, null){
                Object L$1;
                int I$0;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Feed<Shelf> $this_injectExtensionId;
                final /* synthetic */ Extension<?> $extension;
                {
                    this.$this_injectExtensionId = $receiver;
                    this.$extension = $extension;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var8_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            var4_4 = this.$this_injectExtensionId;
                            $this$invokeSuspend_u24lambda_u240\1 = var4_4;
                            $i$a$-runCatching-UnifiedExtension$Companion$injectExtensionId$2$1\1\216\0 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240\1);
                            this.I$0 = $i$a$-runCatching-UnifiedExtension$Companion$injectExtensionId$2$1\1\216\0;
                            this.label = 1;
                            v0 = $this$invokeSuspend_u24lambda_u240\1.getGetPagedData().invoke((Object)tab, (Object)this);
                            ** if (v0 != var8_3) goto lbl19
lbl18:
                            // 1 sources

                            return var8_3;
lbl19:
                            // 1 sources

                            ** GOTO lbl27
                        }
                        case 1: {
                            $i$a$-runCatching-UnifiedExtension$Companion$injectExtensionId$2$1\1\216\0 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240\1 = (Feed<Shelf>)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl27:
                                // 2 sources

                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)((Feed.Data)v0));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$injectExtensionId$2$1\1\216\0) {
                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$injectExtensionId$2$1\1\216\0));
                            }
                            var4_4 = $this$invokeSuspend_u24lambda_u240\1;
                            $this$invokeSuspend_u24lambda_u240\1 = this.$extension;
                            v1 = Result.exceptionOrNull-impl((Object)var4_4);
                            if (v1 != null) {
                                it\2 = v1;
                                $i$a$-getOrElse-UnifiedExtension$Companion$injectExtensionId$2$2\2\216\0 = false;
                                throw AppException.Companion.toAppException(it\2, $this$invokeSuspend_u24lambda_u240\1);
                            }
                            var3_11 = (Feed.Data)var4_4;
                            data = var3_11.component1();
                            buttons = var3_11.component2();
                            bg = var3_11.component3();
                            v2 = buttons;
                            return Feed.Companion.toFeedData(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, data, this.$extension), v2 != null ? UnifiedExtension.Companion.withExtensionId(v2, this.$extension) : null, bg);
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
            }));
        }

        /*
         * WARNING - void declaration
         */
        private final Feed<Track> injectExtension(Feed<Track> $this$injectExtension, Extension<?> extension2) {
            void $this$mapTo\2;
            void $this$map\1;
            Iterable iterable = $this$injectExtension.getTabs();
            Feed<Track> feed2 = $this$injectExtension;
            boolean bl = false;
            void var5_6 = $this$map\1;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Tab tab = (Tab)t;
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(Companion.injectId((Tab)it\3, extension2.getId()));
            }
            return feed2.copy((List)collection, (Function2<Tab, Continuation<Feed.Data<Track>>, Object>)((Function2)new Function2<Tab, Continuation<? super Feed.Data<Track>>, Object>(extension2, $this$injectExtension, null){
                Object L$1;
                Object L$2;
                int I$0;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Extension<?> $extension;
                final /* synthetic */ Feed<Track> $this_injectExtension;
                {
                    this.$extension = $extension;
                    this.$this_injectExtension = $receiver;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var9_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            id = this.$extension.getId();
                            var5_5 = this.$this_injectExtension;
                            $this$invokeSuspend_u24lambda_u240\1 = var5_5;
                            $i$a$-runCatching-UnifiedExtension$Companion$injectExtension$2$1\1\228\0 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = id;
                            this.L$2 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240\1);
                            this.I$0 = $i$a$-runCatching-UnifiedExtension$Companion$injectExtension$2$1\1\228\0;
                            this.label = 1;
                            v0 = $this$invokeSuspend_u24lambda_u240\1.getGetPagedData().invoke((Object)tab, (Object)this);
                            ** if (v0 != var9_3) goto lbl21
lbl20:
                            // 1 sources

                            return var9_3;
lbl21:
                            // 1 sources

                            ** GOTO lbl30
                        }
                        case 1: {
                            $i$a$-runCatching-UnifiedExtension$Companion$injectExtension$2$1\1\228\0 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240\1 = (Feed<Track>)this.L$2;
                            id = (String)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl30:
                                // 2 sources

                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)((Feed.Data)v0));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$injectExtension$2$1\1\228\0) {
                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$injectExtension$2$1\1\228\0));
                            }
                            var5_5 = $this$invokeSuspend_u24lambda_u240\1;
                            $this$invokeSuspend_u24lambda_u240\1 = this.$extension;
                            v1 = Result.exceptionOrNull-impl((Object)var5_5);
                            if (v1 != null) {
                                it\2 = v1;
                                $i$a$-getOrElse-UnifiedExtension$Companion$injectExtension$2$2\2\228\0 = false;
                                throw AppException.Companion.toAppException(it\2, $this$invokeSuspend_u24lambda_u240\1);
                            }
                            var4_12 = (Feed.Data)var5_5;
                            data = var4_12.component1();
                            buttons = var4_12.component2();
                            bg = var4_12.component3();
                            v2 = buttons;
                            return Feed.Companion.toFeedData(data.map((Function2)new Function2<Result<? extends List<? extends Track>>, Continuation<? super List<? extends Track>>, Object>(this.$extension, id, null){
                                int label;
                                /* synthetic */ Object L$0;
                                final /* synthetic */ Extension<?> $extension;
                                final /* synthetic */ String $id;
                                {
                                    this.$extension = $extension;
                                    this.$id = $id;
                                    super(2, $completion);
                                }

                                /*
                                 * WARNING - void declaration
                                 */
                                public final Object invokeSuspend(Object $result) {
                                    Object object = this.L$0;
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            void $this$mapTo\3;
                                            void $this$map\2;
                                            void result2;
                                            ResultKt.throwOnFailure((Object)$result);
                                            Iterable iterable = result2;
                                            Object object2 = this.$extension;
                                            Throwable throwable = Result.exceptionOrNull-impl((Object)iterable);
                                            if (throwable != null) {
                                                Throwable throwable2 = throwable;
                                                boolean bl = false;
                                                throw AppException.Companion.toAppException(throwable2, (Extension<?>)object2);
                                            }
                                            List list2 = (List)iterable;
                                            iterable = list2;
                                            object2 = this.$id;
                                            Extension<?> extension2 = this.$extension;
                                            boolean bl = false;
                                            void var8_10 = $this$map\2;
                                            Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\2, (int)10));
                                            boolean bl2 = false;
                                            for (T t : $this$mapTo\3) {
                                                void it\4;
                                                Track track2 = (Track)t;
                                                Collection collection2 = collection;
                                                boolean bl3 = false;
                                                collection2.add(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.withExtensionId$default(UnifiedExtension.Companion, (Track)it\4, (String)object2, extension2.getInstance().getValue(), false, 4, null));
                                            }
                                            return (List)collection;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                    var3_3.L$0 = ((Result)value2).unbox-impl();
                                    return (Continuation)var3_3;
                                }

                                public final Object invoke(Object p1, Continuation<? super List<Track>> p2) {
                                    return (this.create(Result.box-impl((Object)p1), p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            }), v2 != null ? UnifiedExtension.Companion.withExtensionId(v2, this.$extension) : null, bg);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                    var3_3.L$0 = value2;
                    return (Continuation)var3_3;
                }

                public final Object invoke(Tab p1, Continuation<? super Feed.Data<Track>> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            }));
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Feed<Lyrics> injectLyricsExtId(@NotNull Feed<Lyrics> $this$injectLyricsExtId, @NotNull Extension<?> extension2) {
            void $this$mapTo\2;
            void $this$map\1;
            Intrinsics.checkNotNullParameter($this$injectLyricsExtId, (String)"<this>");
            Intrinsics.checkNotNullParameter(extension2, (String)"extension");
            Iterable iterable = $this$injectLyricsExtId.getTabs();
            Feed<Lyrics> feed2 = $this$injectLyricsExtId;
            boolean bl = false;
            void var5_6 = $this$map\1;
            Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\1, (int)10));
            boolean bl2 = false;
            for (Object t : $this$mapTo\2) {
                void it\3;
                Tab tab = (Tab)t;
                Collection collection2 = collection;
                boolean bl3 = false;
                collection2.add(Companion.injectId((Tab)it\3, extension2.getId()));
            }
            return feed2.copy((List)collection, (Function2<Tab, Continuation<Feed.Data<Lyrics>>, Object>)((Function2)new Function2<Tab, Continuation<? super Feed.Data<Lyrics>>, Object>($this$injectLyricsExtId, extension2, null){
                Object L$1;
                int I$0;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Feed<Lyrics> $this_injectLyricsExtId;
                final /* synthetic */ Extension<?> $extension;
                {
                    this.$this_injectLyricsExtId = $receiver;
                    this.$extension = $extension;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (Tab)this.L$0;
                    var8_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            var4_4 = this.$this_injectLyricsExtId;
                            $this$invokeSuspend_u24lambda_u240\1 = var4_4;
                            $i$a$-runCatching-UnifiedExtension$Companion$injectLyricsExtId$2$1\1\241\0 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)tab);
                            this.L$1 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240\1);
                            this.I$0 = $i$a$-runCatching-UnifiedExtension$Companion$injectLyricsExtId$2$1\1\241\0;
                            this.label = 1;
                            v0 = $this$invokeSuspend_u24lambda_u240\1.getGetPagedData().invoke((Object)tab, (Object)this);
                            ** if (v0 != var8_3) goto lbl19
lbl18:
                            // 1 sources

                            return var8_3;
lbl19:
                            // 1 sources

                            ** GOTO lbl27
                        }
                        case 1: {
                            $i$a$-runCatching-UnifiedExtension$Companion$injectLyricsExtId$2$1\1\241\0 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240\1 = (Feed<Lyrics>)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl27:
                                // 2 sources

                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)((Feed.Data)v0));
                            }
                            catch (Throwable $i$a$-runCatching-UnifiedExtension$Companion$injectLyricsExtId$2$1\1\241\0) {
                                $this$invokeSuspend_u24lambda_u240\1 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-UnifiedExtension$Companion$injectLyricsExtId$2$1\1\241\0));
                            }
                            var4_4 = $this$invokeSuspend_u24lambda_u240\1;
                            $this$invokeSuspend_u24lambda_u240\1 = this.$extension;
                            v1 = Result.exceptionOrNull-impl((Object)var4_4);
                            if (v1 != null) {
                                it\2 = v1;
                                $i$a$-getOrElse-UnifiedExtension$Companion$injectLyricsExtId$2$2\2\241\0 = false;
                                throw AppException.Companion.toAppException(it\2, $this$invokeSuspend_u24lambda_u240\1);
                            }
                            var3_11 = (Feed.Data)var4_4;
                            data = var3_11.component1();
                            buttons = var3_11.component2();
                            bg = var3_11.component3();
                            v2 = buttons;
                            return Feed.Companion.toFeedData(data.map((Function2)new Function2<Result<? extends List<? extends Lyrics>>, Continuation<? super List<? extends Lyrics>>, Object>(this.$extension, null){
                                int label;
                                /* synthetic */ Object L$0;
                                final /* synthetic */ Extension<?> $extension;
                                {
                                    this.$extension = $extension;
                                    super(2, $completion);
                                }

                                /*
                                 * WARNING - void declaration
                                 */
                                public final Object invokeSuspend(Object $result) {
                                    Object object = this.L$0;
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            void $this$mapTo\3;
                                            void result2;
                                            ResultKt.throwOnFailure((Object)$result);
                                            String id2 = this.$extension.getId();
                                            void var5_4 = result2;
                                            Extension<?> extension2 = this.$extension;
                                            Throwable throwable = Result.exceptionOrNull-impl((Object)var5_4);
                                            if (throwable != null) {
                                                Throwable throwable2 = throwable;
                                                boolean bl = false;
                                                throw AppException.Companion.toAppException(throwable2, extension2);
                                            }
                                            List list2 = (List)var5_4;
                                            Iterable iterable = list2;
                                            boolean bl = false;
                                            Iterable throwable2 = iterable;
                                            Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10));
                                            boolean bl2 = false;
                                            for (T t : $this$mapTo\3) {
                                                void it\4;
                                                Lyrics lyrics = (Lyrics)t;
                                                Collection collection2 = collection;
                                                boolean bl3 = false;
                                                collection2.add(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(UnifiedExtension.Companion, (Lyrics)it\4, id2));
                                            }
                                            return (List)collection;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                    var3_3.L$0 = ((Result)value2).unbox-impl();
                                    return (Continuation)var3_3;
                                }

                                public final Object invoke(Object p1, Continuation<? super List<Lyrics>> p2) {
                                    return (this.create(Result.box-impl((Object)p1), p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            }), v2 != null ? UnifiedExtension.Companion.withExtensionId(v2, this.$extension) : null, bg);
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
            }));
        }

        private final Shelf.Category withExtensionId(Shelf.Category $this$withExtensionId, Extension<?> extension2) {
            Feed<Shelf> feed2 = $this$withExtensionId.getFeed();
            return Shelf.Category.copy$default($this$withExtensionId, null, null, feed2 != null ? this.injectExtensionId(feed2, extension2) : null, null, null, null, null, 123, null);
        }

        private final PagedData<Shelf> injectExtensionId(PagedData<Shelf> $this$injectExtensionId, Extension<?> extension2) {
            return $this$injectExtensionId.map((Function2)new Function2<Result<? extends List<? extends Shelf>>, Continuation<? super List<? extends Shelf>>, Object>(extension2, null){
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Extension<?> $extension;
                {
                    this.$extension = $extension;
                    super(2, $completion);
                }

                /*
                 * WARNING - void declaration
                 */
                public final Object invokeSuspend(Object $result) {
                    Object object = this.L$0;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            void $this$mapTo\3;
                            void $this$map\2;
                            void result2;
                            ResultKt.throwOnFailure((Object)$result);
                            String id2 = this.$extension.getId();
                            ExtensionClient client = (ExtensionClient)this.$extension.getInstance().getValue();
                            Iterable iterable = result2;
                            Extension<?> extension2 = this.$extension;
                            Throwable throwable = Result.exceptionOrNull-impl((Object)iterable);
                            if (throwable != null) {
                                Throwable throwable2 = throwable;
                                boolean bl2 = false;
                                throw AppException.Companion.toAppException(throwable2, extension2);
                            }
                            List list2 = (List)iterable;
                            iterable = list2;
                            extension2 = this.$extension;
                            boolean bl = false;
                            void bl2 = $this$map\2;
                            Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\2, (int)10));
                            boolean bl3 = false;
                            for (T t : $this$mapTo\3) {
                                Shelf shelf;
                                void it\4;
                                Shelf shelf2 = (Shelf)t;
                                Collection collection2 = collection;
                                boolean bl4 = false;
                                void var16_18 = it\4;
                                if (var16_18 instanceof Shelf.Category) {
                                    shelf = dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(UnifiedExtension.Companion, (Shelf.Category)it\4, extension2);
                                } else if (var16_18 instanceof Shelf.Item) {
                                    shelf = UnifiedExtension.Companion.withExtensionId((Shelf.Item)it\4, id2, (Object)client);
                                } else if (var16_18 instanceof Shelf.Lists.Categories) {
                                    Iterable iterable2 = ((Shelf.Lists.Categories)it\4).getList();
                                    var18_20 = null;
                                    var19_21 = null;
                                    var20_22 = (Shelf.Lists.Categories)it\4;
                                    boolean bl5 = false;
                                    Iterable iterable3 = $this$map\5;
                                    Collection collection3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\5, (int)10));
                                    boolean bl6 = false;
                                    for (T t2 : $this$mapTo\6) {
                                        Shelf.Category category = (Shelf.Category)t2;
                                        var28_30 = collection3;
                                        boolean bl7 = false;
                                        var28_30.add((EchoMediaItem)((Object)dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(UnifiedExtension.Companion, (Shelf.Category)((Object)category\7), extension2)));
                                    }
                                    var28_30 = (List)collection3;
                                    Feed<Shelf> feed2 = ((Shelf.Lists.Categories)it\4).getMore();
                                    shelf = Shelf.Lists.Categories.copy$default(var20_22, var19_21, var18_20, (List)var28_30, null, null, feed2 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, feed2, extension2) : null, null, 91, null);
                                } else if (var16_18 instanceof Shelf.Lists.Items) {
                                    $this$map\5 = ((Shelf.Lists.Items)it\4).getList();
                                    var18_20 = null;
                                    var19_21 = null;
                                    var20_22 = (Shelf.Lists.Items)it\4;
                                    boolean bl8 = false;
                                    $this$mapTo\6 = $this$map\8;
                                    Collection collection4 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\8, (int)10));
                                    boolean bl9 = false;
                                    for (T t3 : $this$mapTo\9) {
                                        category\7 = (EchoMediaItem)t3;
                                        var28_30 = collection4;
                                        boolean bl10 = false;
                                        var28_30.add(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$withExtensionId(UnifiedExtension.Companion, item\10, id2, (Object)client));
                                    }
                                    var28_30 = (List)collection4;
                                    Feed<Shelf> feed3 = ((Shelf.Lists.Items)it\4).getMore();
                                    shelf = Shelf.Lists.Items.copy$default((Shelf.Lists.Items)var20_22, var19_21, var18_20, (List)var28_30, null, null, feed3 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, feed3, extension2) : null, null, 91, null);
                                } else if (var16_18 instanceof Shelf.Lists.Tracks) {
                                    void $this$mapTo\12;
                                    void $this$map\11;
                                    $this$map\8 = ((Shelf.Lists.Tracks)it\4).getList();
                                    var18_20 = null;
                                    var19_21 = null;
                                    var20_22 = (Shelf.Lists.Tracks)it\4;
                                    boolean bl11 = false;
                                    $this$mapTo\9 = $this$map\11;
                                    Collection collection5 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\11, (int)10));
                                    boolean bl12 = false;
                                    for (T t4 : $this$mapTo\12) {
                                        void track\13;
                                        item\10 = (Track)t4;
                                        var28_30 = collection5;
                                        boolean bl13 = false;
                                        var28_30.add(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.withExtensionId$default(UnifiedExtension.Companion, (Track)track\13, id2, client, false, 4, null));
                                    }
                                    var28_30 = (List)collection5;
                                    Feed<Shelf> feed4 = ((Shelf.Lists.Tracks)it\4).getMore();
                                    shelf = Shelf.Lists.Tracks.copy$default((Shelf.Lists.Tracks)var20_22, var19_21, var18_20, var28_30, null, null, feed4 != null ? dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension$Companion.access$injectExtensionId(UnifiedExtension.Companion, feed4, extension2) : null, null, 91, null);
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                                collection2.add(shelf);
                            }
                            return (List)collection;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                    var3_3.L$0 = ((Result)value2).unbox-impl();
                    return (Continuation)var3_3;
                }

                public final Object invoke(Object p1, Continuation<? super List<? extends Shelf>> p2) {
                    return (this.create(Result.box-impl((Object)p1), p2)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        @NotNull
        public final Tab injectId(@NotNull Tab $this$injectId, @NotNull String id2) {
            Intrinsics.checkNotNullParameter((Object)$this$injectId, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            return Tab.copy$default($this$injectId, null, null, false, MapsKt.plus($this$injectId.getExtras(), (Map)MapsKt.mapOf((Pair)TuplesKt.to((Object)UnifiedExtension.EXTENSION_ID, (Object)id2))), 7, null);
        }

        public static final /* synthetic */ PagedData access$injectExtensionId(Companion $this, PagedData $receiver, Extension extension2) {
            return $this.injectExtensionId($receiver, extension2);
        }

        public static final /* synthetic */ Lyrics access$withExtensionId(Companion $this, Lyrics $receiver, String id2) {
            return $this.withExtensionId($receiver, id2);
        }

        public static final /* synthetic */ Shelf.Category access$withExtensionId(Companion $this, Shelf.Category $receiver, Extension extension2) {
            return $this.withExtensionId($receiver, extension2);
        }

        public static final /* synthetic */ EchoMediaItem access$withExtensionId(Companion $this, EchoMediaItem $receiver, String id2, Object client) {
            return $this.withExtensionId($receiver, id2, client);
        }

        public static final /* synthetic */ Extension access$get(Companion $this, List $receiver, String id2) {
            return $this.get($receiver, id2);
        }

        public static final /* synthetic */ Extension access$getOrNull(Companion $this, List $receiver, String id2) {
            return $this.getOrNull($receiver, id2);
        }

        public static final /* synthetic */ Radio access$withExtensionId(Companion $this, Radio $receiver, String id2, Object client) {
            return $this.withExtensionId($receiver, id2, client);
        }

        public static final /* synthetic */ Feed access$injectExtension(Companion $this, Feed $receiver, Extension extension2) {
            return $this.injectExtension($receiver, extension2);
        }

        public static final /* synthetic */ Album access$withExtensionId(Companion $this, Album $receiver, String id2, Object client) {
            return $this.withExtensionId($receiver, id2, client);
        }

        public static final /* synthetic */ Artist access$withExtensionId(Companion $this, Artist $receiver, String id2, Object client) {
            return $this.withExtensionId($receiver, id2, client);
        }

        public static final /* synthetic */ Playlist access$withExtensionId(Companion $this, Playlist $receiver, String id2, Object client) {
            return $this.withExtensionId($receiver, id2, client);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

