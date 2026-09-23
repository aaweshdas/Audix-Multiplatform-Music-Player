/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  androidx.annotation.OptIn
 *  androidx.media3.common.util.UnstableApi
 *  androidx.media3.datasource.cache.SimpleCache
 *  kotlin.KotlinNothingValueException
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference0Impl
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.SharedFlowKt
 *  kotlinx.coroutines.flow.SharingStarted
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.OptIn;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.SimpleCache;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.TrackerExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.LoginClient;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.helpers.WebViewClient;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.NetworkConnection;
import dev.brahmkshatriya.echo.common.models.User;
import dev.brahmkshatriya.echo.common.providers.GlobalSettingsProvider;
import dev.brahmkshatriya.echo.common.providers.LyricsExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.MessageFlowProvider;
import dev.brahmkshatriya.echo.common.providers.MetadataProvider;
import dev.brahmkshatriya.echo.common.providers.MiscExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.MusicExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.NetworkConnectionProvider;
import dev.brahmkshatriya.echo.common.providers.TrackerExtensionsProvider;
import dev.brahmkshatriya.echo.common.providers.WebViewClientProvider;
import dev.brahmkshatriya.echo.di.App;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader$mapped$;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader$special$;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.WebViewClientFactory;
import dev.brahmkshatriya.echo.extensions.builtin.offline.OfflineExtension;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedExtension;
import dev.brahmkshatriya.echo.extensions.db.ExtensionDatabase;
import dev.brahmkshatriya.echo.extensions.db.models.CurrentUser;
import dev.brahmkshatriya.echo.extensions.db.models.ExtensionEntity;
import dev.brahmkshatriya.echo.extensions.exceptions.AppException;
import dev.brahmkshatriya.echo.extensions.exceptions.RequiredExtensionsMissingException;
import dev.brahmkshatriya.echo.extensions.repo.CombinedRepository;
import dev.brahmkshatriya.echo.extensions.repo.ExtensionParser;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u00106\u001a\u00020\u001bH\u0002J\u0016\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0019J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020>H\u0002J \u0010:\u001a\b\u0012\u0004\u0012\u00020@0?*\b\u0012\u0004\u0012\u00020@0\u001d2\u0006\u0010G\u001a\u00020>H\u0002JJ\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HJ0.0I\"\f\b\u0000\u0010J*\u0006\u0012\u0002\b\u00030K2\u0006\u0010L\u001a\u00020,2\u001e\u0010M\u001a\u001a\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?\u0012\u0004\u0012\u0002HJ0NH\u0002J:\u0010]\u001a\b\u0012\u0004\u0012\u0002HJ0.\"\u0004\b\u0000\u0010J*\b\u0012\u0004\u0012\u0002HJ0.2\u0006\u0010L\u001a\u00020,2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HJ\u0012\u0004\u0012\u00020/0_H\u0002J\"\u0010`\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020@0K0.0I2\u0006\u0010L\u001a\u00020,J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020@H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010*\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0-0+\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0019\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001030-\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R2\u0010:\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0?0=0<0.0;X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010A\u001a\u00020B\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001d\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030.0I\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001d\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0.0I\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010QR\u001d\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020V0.0I\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010QR\u001d\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0.0I\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010QR%\u0010[\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020@0K0.0I\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010Q\u00a8\u0006d"}, d2={"Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "", "app", "Ldev/brahmkshatriya/echo/di/App;", "cache", "Landroidx/media3/datasource/cache/SimpleCache;", "<init>", "(Ldev/brahmkshatriya/echo/di/App;Landroidx/media3/datasource/cache/SimpleCache;)V", "getApp", "()Ldev/brahmkshatriya/echo/di/App;", "getCache", "()Landroidx/media3/datasource/cache/SimpleCache;", "parser", "Ldev/brahmkshatriya/echo/extensions/repo/ExtensionParser;", "getParser", "()Ldev/brahmkshatriya/echo/extensions/repo/ExtensionParser;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "db", "Ldev/brahmkshatriya/echo/extensions/db/ExtensionDatabase;", "getDb", "()Ldev/brahmkshatriya/echo/extensions/db/ExtensionDatabase;", "permGrantedFlow", "", "setPermGranted", "", "unified", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedExtension;", "getUnified", "()Lkotlin/Lazy;", "fileIgnoreFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Ljava/io/File;", "getFileIgnoreFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "repository", "Ldev/brahmkshatriya/echo/extensions/repo/CombinedRepository;", "settings", "Landroid/content/SharedPreferences;", "priorityMap", "", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "getPriorityMap", "()Ljava/util/Map;", "current", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "getCurrent", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setCurrentExtension", "setupMusicExtension", "extension", "manual", "injected", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "webViewClientFactory", "Ldev/brahmkshatriya/echo/extensions/WebViewClientFactory;", "getWebViewClientFactory", "()Ldev/brahmkshatriya/echo/extensions/WebViewClientFactory;", "createWebClient", "Ldev/brahmkshatriya/echo/common/helpers/WebViewClient;", "metadata", "mapped", "Lkotlinx/coroutines/flow/StateFlow;", "T", "Ldev/brahmkshatriya/echo/common/Extension;", "type", "transform", "Lkotlin/Function2;", "music", "getMusic", "()Lkotlinx/coroutines/flow/StateFlow;", "tracker", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "getTracker", "lyrics", "Ldev/brahmkshatriya/echo/common/LyricsExtension;", "getLyrics", "misc", "Ldev/brahmkshatriya/echo/common/MiscExtension;", "getMisc", "all", "getAll", "sorted", "id", "Lkotlin/Function1;", "getFlow", "injectProviders", "client", "Companion", "app_debug"})
@OptIn(markerClass={UnstableApi.class})
@SourceDebugExtension(value={"SMAP\nExtensionLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionLoader.kt\ndev/brahmkshatriya/echo/extensions/ExtensionLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,264:1\n1285#2,2:265\n1299#2,4:267\n295#2,2:282\n1056#2:302\n49#3:271\n51#3:275\n49#3:276\n51#3:280\n49#3:297\n51#3:301\n46#4:272\n51#4:274\n46#4:277\n51#4:279\n46#4:298\n51#4:300\n105#5:273\n105#5:278\n105#5:299\n1#6:281\n40#7,13:284\n*S KotlinDebug\n*F\n+ 1 ExtensionLoader.kt\ndev/brahmkshatriya/echo/extensions/ExtensionLoader\n*L\n87#1:265,2\n87#1:267,4\n98#1:282,2\n215#1:302\n111#1:271\n111#1:275\n124#1:276\n124#1:280\n170#1:297\n170#1:301\n111#1:272\n111#1:274\n124#1:277\n124#1:279\n170#1:298\n170#1:300\n111#1:273\n124#1:278\n170#1:299\n104#1:284,13\n*E\n"})
public final class ExtensionLoader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final App app;
    @NotNull
    private final SimpleCache cache;
    @NotNull
    private final ExtensionParser parser;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final ExtensionDatabase db;
    private boolean permGrantedFlow;
    @NotNull
    private final Lazy<UnifiedExtension> unified;
    @NotNull
    private final MutableSharedFlow<File> fileIgnoreFlow;
    @NotNull
    private final CombinedRepository repository;
    @NotNull
    private final SharedPreferences settings;
    @NotNull
    private final Map<ExtensionType, MutableStateFlow<List<String>>> priorityMap;
    @NotNull
    private final MutableStateFlow<MusicExtension> current;
    @NotNull
    private final Flow<List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Injectable<ExtensionClient>>>>> injected;
    @NotNull
    private final WebViewClientFactory webViewClientFactory;
    @NotNull
    private final StateFlow<List<MusicExtension>> music;
    @NotNull
    private final StateFlow<List<TrackerExtension>> tracker;
    @NotNull
    private final StateFlow<List<LyricsExtension>> lyrics;
    @NotNull
    private final StateFlow<List<MiscExtension>> misc;
    @NotNull
    private final StateFlow<List<Extension<? extends ExtensionClient>>> all;
    @NotNull
    public static final String LAST_EXTENSION_KEY = "last_extension";

    /*
     * WARNING - void declaration
     */
    public ExtensionLoader(@NotNull App app, @NotNull SimpleCache cache) {
        void $this$associateWith\1;
        Intrinsics.checkNotNullParameter((Object)app, (String)"app");
        Intrinsics.checkNotNullParameter((Object)cache, (String)"cache");
        this.app = app;
        this.cache = cache;
        this.parser = new ExtensionParser((Context)this.app.getContext());
        this.scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getIO()));
        this.db = ExtensionDatabase.Companion.create(this.app.getContext());
        this.unified = LazyKt.lazy(() -> ExtensionLoader.unified$lambda$0(this));
        this.fileIgnoreFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)0, null, (int)7, null);
        Object object = new Pair[]{TuplesKt.to((Object)UnifiedExtension.Companion.getMetadata(), this.unified), TuplesKt.to((Object)OfflineExtension.Companion.getMetadata(), (Object)LazyKt.lazy(() -> ExtensionLoader.repository$lambda$1(this)))};
        this.repository = new CombinedRepository(this.scope, (Context)this.app.getContext(), (Flow<? extends File>)((Flow)this.fileIgnoreFlow), this.parser, (Pair<dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>)object);
        this.settings = this.app.getSettings();
        object = (Iterable)ExtensionType.getEntries();
        ExtensionLoader extensionLoader = this;
        boolean bl = false;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associateWith\1, (int)10)), (int)16));
        void $this$associateWithTo\2 = $this$associateWith\1;
        boolean bl2 = false;
        for (Object t : $this$associateWithTo\2) {
            void it\3;
            ExtensionType extensionType = (ExtensionType)((Object)t);
            Object t2 = t;
            Map map2 = linkedHashMap;
            boolean bl3 = false;
            String string2 = Companion.priorityKey((ExtensionType)it\3);
            String string3 = this.settings.getString(string2, null);
            if (string3 == null) {
                string3 = "";
            }
            char[] cArray = new char[]{','};
            List list2 = StringsKt.split$default((CharSequence)string3, (char[])cArray, (boolean)false, (int)0, (int)6, null);
            MutableStateFlow mutableStateFlow = StateFlowKt.MutableStateFlow((Object)list2);
            map2.put(t2, mutableStateFlow);
        }
        extensionLoader.priorityMap = linkedHashMap;
        this.current = StateFlowKt.MutableStateFlow(null);
        Flow flow2 = (Flow)this.repository.getFlow();
        boolean bl4 = false;
        Flow flow3 = flow2;
        boolean bl5 = false;
        boolean bl6 = false;
        Flow flow4 = FlowKt.flowCombine((Flow)((Flow)new Flow<List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>>(flow3){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = $receiver;
                    }

                    /*
                     * Could not resolve type clashes
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ special$$inlined$map$1$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list\1 = (List)value;
                                $i$a$-map-ExtensionLoader$injected$1\1\50\0 = false;
                                v0 = list\1;
                                if (v0 != null) {
                                    $this$groupBy\2 = v0;
                                    $i$f$groupBy\2\51 = false;
                                    var16_20 = $this$groupBy\2;
                                    destination\3 = new LinkedHashMap<K, V>();
                                    $i$f$groupByTo\3\52 = false;
                                    var19_23 = $this$groupByTo\3.iterator();
                                    while (var19_23.hasNext()) {
                                        element\3 = var19_23.next();
                                        it\4 = ((Result)element\3).unbox-impl();
                                        $i$a$-groupBy-ExtensionLoader$injected$1$1\4\54\1 = false;
                                        v1 = (Pair)(Result.isFailure-impl((Object)it\4) != false ? null : it\4);
                                        if (v1 != null && (v1 = (dev.brahmkshatriya.echo.common.models.Metadata)v1.getFirst()) != null) {
                                            $this$injected_u24lambda_u2410_u24lambda_u247_u24lambda_u246\5 = v1;
                                            $i$a$-run-ExtensionLoader$injected$1$1$1\5\51\6 = false;
                                            v2 = TuplesKt.to((Object)$this$injected_u24lambda_u2410_u24lambda_u247_u24lambda_u246\5.getType(), (Object)$this$injected_u24lambda_u2410_u24lambda_u247_u24lambda_u246\5.getId());
                                        } else {
                                            v2 = null;
                                        }
                                        key\3 = v2;
                                        $this$getOrPut\6 = destination\3;
                                        $i$f$getOrPut\6\56 = false;
                                        value\6 = $this$getOrPut\6.get(key\3);
                                        if (value\6 == null) {
                                            $i$a$-getOrPut-CollectionsKt___CollectionsKt$groupByTo$list$1\7\59\3 = false;
                                            answer\6 = new ArrayList<E>();
                                            $this$getOrPut\6.put(key\3, answer\6);
                                            v3 /* !! */  = answer\6;
                                        } else {
                                            v3 /* !! */  = value\6;
                                        }
                                        list\3 = (List)v3 /* !! */ ;
                                        list\3.add(element\3);
                                    }
                                    $this$map\8 = destination\3;
                                    $i$f$map\8\51 = false;
                                    $this$groupByTo\3 = $this$map\8;
                                    destination\9 = new ArrayList<E>($this$map\8.size());
                                    $i$f$mapTo\9\67 = false;
                                    for (Map.Entry item\9 : $this$mapTo\9.entrySet()) {
                                        list\3 = item\9;
                                        var30_39 = destination\9;
                                        $i$a$-map-ExtensionLoader$injected$1$2\10\69\1 = false;
                                        $this$minBy\11 = (Iterable)entry\10.getValue();
                                        $i$f$minByOrThrow\11\70 = false;
                                        iterator\11 = $this$minBy\11.iterator();
                                        if (!iterator\11.hasNext()) {
                                            throw new NoSuchElementException();
                                        }
                                        minElem\11 = iterator\11.next();
                                        if (!iterator\11.hasNext()) {
                                            v4 = minElem\11;
                                        } else {
                                            it\12 = ((Result)minElem\11).unbox-impl();
                                            $i$a$-minByOrThrow-ExtensionLoader$injected$1$2$1\12\75\10 = false;
                                            v5 = (Pair)(Result.isFailure-impl((Object)it\12) != false ? null : it\12);
                                            minValue\11 = v5 != null && (v5 = (dev.brahmkshatriya.echo.common.models.Metadata)v5.getFirst()) != null && (v5 = v5.getImportType()) != null ? v5.ordinal() : 0x7FFFFFFF;
                                            do {
                                                e\11 = iterator\11.next();
                                                it\13 = ((Result)e\11).unbox-impl();
                                                $i$a$-minByOrThrow-ExtensionLoader$injected$1$2$1\13\78\10 = false;
                                                v6 = (Pair)(Result.isFailure-impl((Object)it\13) != false ? null : it\13);
                                                v7 = v6 != null && (v6 = (dev.brahmkshatriya.echo.common.models.Metadata)v6.getFirst()) != null && (v6 = v6.getImportType()) != null ? v6.ordinal() : (v\11 = 0x7FFFFFFF);
                                                if (minValue\11 <= v\11) continue;
                                                minElem\11 = e\11;
                                                minValue\11 = v\11;
                                            } while (iterator\11.hasNext());
                                            v4 = minElem\11;
                                        }
                                        var30_39.add(Result.box-impl((Object)((Result)v4).unbox-impl()));
                                    }
                                    v8 = (List)destination\9;
                                } else {
                                    v8 = v9 = null;
                                }
                                if (v8 == null) {
                                    v9 = CollectionsKt.emptyList();
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                $continuation.label = 1;
                                v10 = var10_14.emit((Object)v9, (Continuation)$continuation);
                                if (v10 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl118
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v10 = $result;
lbl118:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        }), this.db.getExtensionEnabledFlow(), (Function3)((Function3)new Function3<List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>, List<? extends ExtensionEntity>, Continuation<? super List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                List list3 = (List)this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$mapTo\5;
                        void list4;
                        Pair pair;
                        void $this$associateTo\2;
                        void enabledList;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable iterable = (Iterable)enabledList;
                        boolean bl = false;
                        int capacity\22 = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)iterable, (int)10)), (int)16);
                        Iterable iterable2 = iterable;
                        Map map2 = new LinkedHashMap<K, V>(capacity\22);
                        boolean bl2 = false;
                        for (Object object2 : $this$associateTo\2) {
                            Map map3 = map2;
                            ExtensionEntity extensionEntity = (ExtensionEntity)object2;
                            boolean bl3 = false;
                            pair = TuplesKt.to((Object)TuplesKt.to((Object)((Object)extensionEntity.getType()), (Object)extensionEntity.getId()), (Object)Boxing.boxBoolean((boolean)extensionEntity.getEnabled()));
                            map3.put(pair.getFirst(), pair.getSecond());
                        }
                        Map enabledMap = map2;
                        Iterable iterable3 = (Iterable)list4;
                        boolean bl4 = false;
                        Iterable capacity\22 = iterable3;
                        Collection collection = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)iterable3, (int)10));
                        boolean bl5 = false;
                        for (T t : $this$mapTo\5) {
                            Object object;
                            void result\6;
                            Object object2;
                            object2 = ((Result)t).unbox-impl();
                            Collection collection2 = collection;
                            boolean bl6 = false;
                            pair = result\6;
                            if (Result.isSuccess-impl((Object)pair)) {
                                Object object3;
                                Pair pair2 = pair;
                                try {
                                    Pair pair3 = object3 = pair2;
                                    boolean bl7 = false;
                                    dev.brahmkshatriya.echo.common.models.Metadata metadata2 = (dev.brahmkshatriya.echo.common.models.Metadata)pair3.component1();
                                    Lazy lazy = (Lazy)pair3.component2();
                                    dev.brahmkshatriya.echo.common.models.Metadata metadata3 = metadata2;
                                    boolean bl8 = false;
                                    Pair pair4 = TuplesKt.to((Object)((Object)metadata3.getType()), (Object)metadata3.getId());
                                    Boolean bl9 = (Boolean)enabledMap.get(pair4);
                                    boolean bl10 = bl9 != null ? bl9.booleanValue() : metadata2.isEnabled();
                                    object3 = Result.constructor-impl((Object)TuplesKt.to((Object)dev.brahmkshatriya.echo.common.models.Metadata.copy$default(metadata2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, bl10, 16383, null), (Object)lazy));
                                }
                                catch (Throwable throwable) {
                                    object3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                                }
                                object = object3;
                            } else {
                                object = Result.constructor-impl((Object)pair);
                            }
                            collection2.add(Result.box-impl((Object)object));
                        }
                        return (List)collection;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<? extends Result<? extends Pair<dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>> p1, List<ExtensionEntity> p2, Continuation<? super List<? extends Result<? extends Pair<dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                var4_4.L$1 = p2;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }
        }));
        boolean bl7 = false;
        Flow flow5 = flow4;
        boolean bl8 = false;
        boolean bl9 = false;
        this.injected = FlowKt.flowCombine((Flow)((Flow)new Flow<List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Injectable<ExtensionClient>>>>>(flow5, this){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.this$0 = extensionLoader;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.this$0){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ ExtensionLoader this$0;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.this$0 = extensionLoader;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof special$$inlined$map$2$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ special$$inlined$map$2$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list\1 = (List)value;
                                $i$a$-map-ExtensionLoader$injected$3\1\50\0 = false;
                                $this$map\2 = list\1;
                                $i$f$map\2\51 = false;
                                var16_20 = $this$map\2;
                                destination\3 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map\2, (int)10));
                                $i$f$mapTo\3\52 = false;
                                for (T item\3 : $this$mapTo\3) {
                                    var21_25 = ((Result)item\3).unbox-impl();
                                    var22_26 = destination\3;
                                    $i$a$-map-ExtensionLoader$injected$3$1\4\54\1 = false;
                                    var24_28 = result\4;
                                    if (Result.isSuccess-impl((Object)var24_28)) {
                                        it\5 = (Pair)var24_28;
                                        $i$a$-map-ExtensionLoader$injected$3$1$1\5\55\4 = false;
                                        v0 = Result.constructor-impl((Object)TuplesKt.to((Object)it\5.getFirst(), (Object)ExtensionLoader.access$injected(this.this$0, (Lazy)it\5.getSecond(), (dev.brahmkshatriya.echo.common.models.Metadata)it\5.getFirst())));
                                    } else {
                                        v0 = Result.constructor-impl((Object)var24_28);
                                    }
                                    var22_26.add(Result.box-impl((Object)v0));
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                $continuation.label = 1;
                                v1 = var10_14.emit((Object)((List)destination\3), (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl59
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl59:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        }), this.db.getCurrentUsersFlow(), (Function3)((Function3)new Function3<List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Injectable<ExtensionClient>>>>, List<? extends CurrentUser>, Continuation<? super List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Injectable<ExtensionClient>>>>>, Object>(this, null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.this$0 = $receiver;
                super(3, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                List list3 = (List)this.L$1;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$onEach\1;
                        void var7_7;
                        void list4;
                        ResultKt.throwOnFailure((Object)$result);
                        Iterable iterable = (Iterable)list4;
                        ExtensionLoader extensionLoader = this.this$0;
                        boolean bl = false;
                        void $this$onEach_u24lambda_u2418\1 = var7_7 = $this$onEach\1;
                        boolean bl2 = false;
                        for (T t : $this$onEach_u24lambda_u2418\1) {
                            void users;
                            Object object = ((Result)t).unbox-impl();
                            boolean bl3 = false;
                            BuildersKt.launch$default((CoroutineScope)extensionLoader.getScope(), (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(object, (List<CurrentUser>)users, extensionLoader, null){
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                int I$0;
                                int label;
                                private /* synthetic */ Object L$0;
                                final /* synthetic */ Object $result;
                                final /* synthetic */ List<CurrentUser> $users;
                                final /* synthetic */ ExtensionLoader this$0;
                                {
                                    this.$result = $result;
                                    this.$users = $users;
                                    this.this$0 = $receiver;
                                    super(2, $completion);
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public final Object invokeSuspend(Object $result) {
                                    var2_2 = (CoroutineScope)this.L$0;
                                    var11_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)$result);
                                            var5_4 = this.$result;
                                            v0 = (Pair)(Result.isFailure-impl((Object)var5_4) != false ? null : var5_4);
                                            if (v0 == null) {
                                                return Unit.INSTANCE;
                                            }
                                            var3_6 = v0;
                                            metadata = (dev.brahmkshatriya.echo.common.models.Metadata)var3_6.component1();
                                            injectable = (Injectable)var3_6.component2();
                                            var6_9 /* !! */  = $this$launch;
                                            var7_11 = this.$users;
                                            var8_12 = this.this$0;
                                            $this$invokeSuspend_u24lambda_u240\1 /* !! */  = var6_9 /* !! */ ;
                                            $i$a$-runCatching-ExtensionLoader$injected$4$1$1$1\1\134\0 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                                            this.L$1 = metadata;
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)injectable);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240\1 /* !! */ );
                                            this.I$0 = $i$a$-runCatching-ExtensionLoader$injected$4$1$1$1\1\134\0;
                                            this.label = 1;
                                            v1 = injectable.injectOrRun("user", (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>((List<CurrentUser>)var7_11, metadata, (ExtensionLoader)var8_12, null){
                                                Object L$1;
                                                Object L$2;
                                                int I$0;
                                                int label;
                                                private /* synthetic */ Object L$0;
                                                final /* synthetic */ List<CurrentUser> $users;
                                                final /* synthetic */ dev.brahmkshatriya.echo.common.models.Metadata $metadata;
                                                final /* synthetic */ ExtensionLoader this$0;
                                                {
                                                    this.$users = $users;
                                                    this.$metadata = $metadata;
                                                    this.this$0 = $receiver;
                                                    super(2, $completion);
                                                }

                                                /*
                                                 * Unable to fully structure code
                                                 */
                                                public final Object invokeSuspend(Object $result) {
                                                    block6: {
                                                        var2_2 = (ExtensionClient)this.L$0;
                                                        var9_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch (this.label) {
                                                            case 0: {
                                                                ResultKt.throwOnFailure((Object)$result);
                                                                if (!($this$injectOrRun instanceof LoginClient)) {
                                                                    return Unit.INSTANCE;
                                                                }
                                                                v0 = newCurr = ExtensionLoader.Companion.getUser(this.$users, this.$metadata);
                                                                if (v0 == null) break;
                                                                var5_5 = v0;
                                                                var6_6 = this.this$0;
                                                                it\1 = var5_5;
                                                                $i$a$-let-ExtensionLoader$injected$4$1$1$1$1$user$1\1\138\0 = 0;
                                                                this.L$0 = $this$injectOrRun;
                                                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)newCurr);
                                                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it\1);
                                                                this.I$0 = $i$a$-let-ExtensionLoader$injected$4$1$1$1$1$user$1\1\138\0;
                                                                this.label = 1;
                                                                v1 = var6_6.getDb().getUser(it\1, (Continuation<? super User>)this);
                                                                if (v1 == var9_3) {
                                                                    return var9_3;
                                                                }
                                                                ** GOTO lbl29
                                                            }
                                                            case 1: {
                                                                $i$a$-let-ExtensionLoader$injected$4$1$1$1$1$user$1\1\138\0 = this.I$0;
                                                                it\1 = (CurrentUser)this.L$2;
                                                                newCurr = (CurrentUser)this.L$1;
                                                                ResultKt.throwOnFailure((Object)$result);
                                                                v1 = $result;
lbl29:
                                                                // 2 sources

                                                                v2 = (User)v1;
                                                                break block6;
                                                            }
                                                        }
                                                        v2 = null;
                                                    }
                                                    user = v2;
                                                    ((LoginClient)$this$injectOrRun).setLoginUser(user);
                                                    return Unit.INSTANCE;
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }

                                                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                                    var3_3.L$0 = value2;
                                                    return (Continuation)var3_3;
                                                }

                                                public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }, (Continuation<Unit>)this);
                                            ** if (v1 != var11_3) goto lbl30
lbl29:
                                            // 1 sources

                                            return var11_3;
lbl30:
                                            // 1 sources

                                            ** GOTO lbl40
                                        }
                                        case 1: {
                                            $i$a$-runCatching-ExtensionLoader$injected$4$1$1$1\1\134\0 = this.I$0;
                                            $this$invokeSuspend_u24lambda_u240\1 /* !! */  = (CoroutineScope)this.L$3;
                                            injectable = (Injectable)this.L$2;
                                            metadata = (dev.brahmkshatriya.echo.common.models.Metadata)this.L$1;
                                            try {
                                                ResultKt.throwOnFailure((Object)$result);
                                                v1 = $result;
lbl40:
                                                // 2 sources

                                                $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)Unit.INSTANCE);
                                            }
                                            catch (Throwable $i$a$-runCatching-ExtensionLoader$injected$4$1$1$1\1\134\0) {
                                                $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-ExtensionLoader$injected$4$1$1$1\1\134\0));
                                            }
                                            var6_9 /* !! */  = $this$invokeSuspend_u24lambda_u240\1 /* !! */ ;
                                            var7_11 = this.this$0;
                                            v2 = Result.exceptionOrNull-impl((Object)var6_9 /* !! */ );
                                            if (v2 == null) break;
                                            it\3 = var8_12 = v2;
                                            $i$a$-onFailure-ExtensionLoader$injected$4$1$1$2\3\141\0 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)metadata);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)injectable);
                                            this.L$3 = var6_9 /* !! */ ;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)it\3);
                                            this.I$0 = $i$a$-onFailure-ExtensionLoader$injected$4$1$1$2\3\141\0;
                                            this.label = 2;
                                            v3 = var7_11.getApp().getThrowFlow().emit((Object)AppException.Companion.toAppException((Throwable)it\3, metadata), (Continuation)this);
                                            if (v3 == var11_3) {
                                                return var11_3;
                                            }
                                            break;
                                        }
                                        case 2: {
                                            $i$a$-onFailure-ExtensionLoader$injected$4$1$1$2\3\141\0 = this.I$0;
                                            it\3 = (Throwable)this.L$4;
                                            var6_10 = this.L$3;
                                            injectable = (Injectable)this.L$2;
                                            metadata = (dev.brahmkshatriya.echo.common.models.Metadata)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v3 = $result;
                                            break;
                                        }
                                    }
                                    return Unit.INSTANCE;
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
                            }), (int)2, null);
                        }
                        return var7_7;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Injectable<ExtensionClient>>>> p1, List<CurrentUser> p2, Continuation<? super List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Injectable<ExtensionClient>>>>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                var4_4.L$1 = p2;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }
        }));
        this.webViewClientFactory = new WebViewClientFactory((Context)this.app.getContext());
        this.music = this.mapped(ExtensionType.MUSIC, ExtensionLoader::music$lambda$16);
        this.tracker = this.mapped(ExtensionType.TRACKER, ExtensionLoader::tracker$lambda$17);
        this.lyrics = this.mapped(ExtensionType.LYRICS, ExtensionLoader::lyrics$lambda$18);
        this.misc = this.mapped(ExtensionType.MISC, ExtensionLoader::misc$lambda$19);
        this.all = FlowKt.stateIn((Flow)FlowKt.combine((Flow)((Flow)this.music), (Flow)((Flow)this.tracker), (Flow)((Flow)this.lyrics), (Flow)((Flow)this.misc), (Function5)((Function5)new Function5<List<? extends MusicExtension>, List<? extends TrackerExtension>, List<? extends LyricsExtension>, List<? extends MiscExtension>, Continuation<? super List<? extends Extension<? extends ExtensionClient>>>, Object>(null){
            int label;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            /* synthetic */ Object L$3;

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                List list3 = (List)this.L$1;
                List list4 = (List)this.L$2;
                List list5 = (List)this.L$3;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void misc;
                        void lyrics;
                        void tracker;
                        void music;
                        ResultKt.throwOnFailure((Object)$result);
                        return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)((Collection)music), (Iterable)((Iterable)tracker)), (Iterable)((Iterable)lyrics)), (Iterable)((Iterable)misc));
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<MusicExtension> p1, List<TrackerExtension> p2, List<LyricsExtension> p3, List<MiscExtension> p4, Continuation<? super List<? extends Extension<? extends ExtensionClient>>> p5) {
                var var6_6 = new /* invalid duplicate definition of identical inner class */;
                var6_6.L$0 = p1;
                var6_6.L$1 = p2;
                var6_6.L$2 = p3;
                var6_6.L$3 = p4;
                return var6_6.invokeSuspend(Unit.INSTANCE);
            }
        })), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getLazily(), (Object)CollectionsKt.emptyList());
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.this$0 = $receiver;
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
                        this.label = 1;
                        Object object2 = this.this$0.getAll().collect(new FlowCollector(){

                            /*
                             * Unable to fully structure code
                             */
                            public final Object emit(List<? extends Extension<? extends ExtensionClient>> list, Continuation<? super Unit> $completion) {
                                if (!($completion instanceof emit.1)) ** GOTO lbl-1000
                                var11_3 = $completion;
                                if ((var11_3.label & -2147483648) != 0) {
                                    var11_3.label -= -2147483648;
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
                                        int I$0;
                                        int I$1;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ 1<T> this$0;
                                        int label;
                                        {
                                            this.this$0 = this$0;
                                            super($completion);
                                        }

                                        public final Object invokeSuspend(Object $result) {
                                            this.result = $result;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                $result = $continuation.result;
                                var12_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        var3_6 = list;
                                        var4_7 = this$0;
                                        $i$f$forEach\1\191 = 0;
                                        var6_9 = $this$forEach\1.iterator();
lbl16:
                                        // 4 sources

                                        while (var6_9.hasNext()) {
                                            element\1 = var6_9.next();
                                            it\2 = (Extension)element\1;
                                            $i$a$-forEach-ExtensionLoader$1$1$1\2\265\0 = 0;
                                            if (!it\2.isEnabled()) continue;
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)list);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach\1);
                                            $continuation.L$2 = var4_7;
                                            $continuation.L$3 = var6_9;
                                            $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)element\1);
                                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)it\2);
                                            $continuation.I$0 = $i$f$forEach\1\191;
                                            $continuation.I$1 = $i$a$-forEach-ExtensionLoader$1$1$1\2\265\0;
                                            $continuation.label = 1;
                                            v0 = ExtensionUtils.INSTANCE.inject(it\2, "providers", var4_7.getApp().getThrowFlow(), (Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(var4_7, null){
                                                int label;
                                                private /* synthetic */ Object L$0;
                                                final /* synthetic */ ExtensionLoader this$0;
                                                {
                                                    this.this$0 = $receiver;
                                                    super(2, $completion);
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Object invokeSuspend(Object $result) {
                                                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0: {
                                                            void $this$inject;
                                                            ResultKt.throwOnFailure((Object)$result);
                                                            ExtensionLoader.access$injectProviders(this.this$0, (ExtensionClient)$this$inject);
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

                                                public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }), (Continuation<? super Unit>)$continuation);
                                            if (v0 != var12_5) continue;
                                            return var12_5;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        $i$a$-forEach-ExtensionLoader$1$1$1\2\265\0 = $continuation.I$1;
                                        $i$f$forEach\1\191 = $continuation.I$0;
                                        it\2 = (Extension)$continuation.L$5;
                                        element\1 = $continuation.L$4;
                                        var6_9 = (Iterator)$continuation.L$3;
                                        var4_7 = (ExtensionLoader)$continuation.L$2;
                                        $this$forEach\1 = (Iterable)$continuation.L$1;
                                        list = (List)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
                                        ** GOTO lbl16
                                    }
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation)this);
                        if (object2 != object) throw new KotlinNothingValueException();
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = $result;
                        throw new KotlinNothingValueException();
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
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.this$0 = $receiver;
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
                        this.label = 1;
                        Object object2 = FlowKt.collectLatest((Flow)((Flow)this.this$0.getMusic()), (Function2)((Function2)new Function2<List<? extends MusicExtension>, Continuation<? super Unit>, Object>(this.this$0, null){
                            int label;
                            final /* synthetic */ ExtensionLoader this$0;
                            {
                                this.this$0 = $receiver;
                                super(2, $completion);
                            }

                            public final Object invokeSuspend(Object $result) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        this.this$0.setCurrentExtension();
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                return (Continuation)new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(List<MusicExtension> p1, Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }), (Continuation)((Continuation)this));
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = $result;
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
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.this$0 = $receiver;
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
                        this.label = 1;
                        Object object2 = FlowKt.flowCombine((Flow)((Flow)this.this$0.getApp().getNetworkFlow()), (Flow)((Flow)this.this$0.getAll()), (Function3)((Function3)new Function3<NetworkConnection, List<? extends Extension<? extends ExtensionClient>>, Continuation<? super Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>>>, Object>(null){
                            int label;
                            /* synthetic */ Object L$0;
                            /* synthetic */ Object L$1;

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                NetworkConnection networkConnection = (NetworkConnection)((Object)this.L$0);
                                List list2 = (List)this.L$1;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void b;
                                        void a;
                                        ResultKt.throwOnFailure((Object)$result);
                                        return TuplesKt.to((Object)a, (Object)b);
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Object invoke(NetworkConnection p1, List<? extends Extension<? extends ExtensionClient>> p2, Continuation<? super Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>>> p3) {
                                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                                var4_4.L$0 = p1;
                                var4_4.L$1 = p2;
                                return var4_4.invokeSuspend(Unit.INSTANCE);
                            }
                        })).collect(new FlowCollector(){

                            /*
                             * Unable to fully structure code
                             */
                            public final Object emit(Pair<? extends NetworkConnection, ? extends List<? extends Extension<? extends ExtensionClient>>> var1_1, Continuation<? super Unit> $completion) {
                                if (!($completion instanceof emit.1)) ** GOTO lbl-1000
                                var13_3 = $completion;
                                if ((var13_3.label & -2147483648) != 0) {
                                    var13_3.label -= -2147483648;
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
                                        int I$0;
                                        int I$1;
                                        /* synthetic */ Object result;
                                        final /* synthetic */ 2<T> this$0;
                                        int label;
                                        {
                                            this.this$0 = this$0;
                                            super($completion);
                                        }

                                        public final Object invokeSuspend(Object $result) {
                                            this.result = $result;
                                            this.label |= Integer.MIN_VALUE;
                                            return this.this$0.emit(null, (Continuation<Unit>)((Continuation)this));
                                        }
                                    };
                                }
                                $result = $continuation.result;
                                var14_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        conn = (NetworkConnection)var1_1.component1();
                                        all = (List)var1_1.component2();
                                        var5_8 = all;
                                        var6_9 = this$0;
                                        $i$f$forEach\1\202 = 0;
                                        var8_11 = $this$forEach\1.iterator();
lbl18:
                                        // 4 sources

                                        while (var8_11.hasNext()) {
                                            element\1 = var8_11.next();
                                            it\2 = (Extension)element\1;
                                            $i$a$-forEach-ExtensionLoader$3$2$1\2\265\0 = 0;
                                            if (!it\2.isEnabled()) continue;
                                            $continuation.L$0 = conn;
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)all);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$forEach\1);
                                            $continuation.L$3 = var6_9;
                                            $continuation.L$4 = var8_11;
                                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)element\1);
                                            $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)it\2);
                                            $continuation.I$0 = $i$f$forEach\1\202;
                                            $continuation.I$1 = $i$a$-forEach-ExtensionLoader$3$2$1\2\265\0;
                                            $continuation.label = 1;
                                            v0 = ExtensionUtils.INSTANCE.inject(it\2, "network", var6_9.getApp().getThrowFlow(), (Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)((Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(conn, null){
                                                int label;
                                                private /* synthetic */ Object L$0;
                                                final /* synthetic */ NetworkConnection $conn;
                                                {
                                                    this.$conn = $conn;
                                                    super(2, $completion);
                                                }

                                                /*
                                                 * WARNING - void declaration
                                                 */
                                                public final Object invokeSuspend(Object $result) {
                                                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch (this.label) {
                                                        case 0: {
                                                            void $this$inject;
                                                            ResultKt.throwOnFailure((Object)$result);
                                                            if (!($this$inject instanceof NetworkConnectionProvider)) {
                                                                return Unit.INSTANCE;
                                                            }
                                                            ((NetworkConnectionProvider)$this$inject).setNetworkConnection(this.$conn);
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

                                                public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                                }
                                            }), (Continuation<? super Unit>)$continuation);
                                            if (v0 != var14_5) continue;
                                            return var14_5;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        $i$a$-forEach-ExtensionLoader$3$2$1\2\265\0 = $continuation.I$1;
                                        $i$f$forEach\1\202 = $continuation.I$0;
                                        it\2 = (Extension)$continuation.L$6;
                                        element\1 = $continuation.L$5;
                                        var8_11 = (Iterator<T>)$continuation.L$4;
                                        var6_9 = (ExtensionLoader)$continuation.L$3;
                                        $this$forEach\1 = (Iterable)$continuation.L$2;
                                        all = (List)$continuation.L$1;
                                        conn = (NetworkConnection)$continuation.L$0;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v0 = $result;
                                        ** GOTO lbl18
                                    }
                                }
                                return Unit.INSTANCE;
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (Continuation)this);
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = $result;
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

    @NotNull
    public final App getApp() {
        return this.app;
    }

    @NotNull
    public final SimpleCache getCache() {
        return this.cache;
    }

    @NotNull
    public final ExtensionParser getParser() {
        return this.parser;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.scope;
    }

    @NotNull
    public final ExtensionDatabase getDb() {
        return this.db;
    }

    public final void setPermGranted() {
        String id2;
        if (this.permGrantedFlow) {
            return;
        }
        this.permGrantedFlow = true;
        MusicExtension musicExtension = (MusicExtension)this.current.getValue();
        String string2 = id2 = musicExtension != null ? musicExtension.getId() : null;
        if (Intrinsics.areEqual((Object)id2, (Object)OfflineExtension.Companion.getMetadata().getId()) || Intrinsics.areEqual((Object)id2, (Object)UnifiedExtension.Companion.getMetadata().getId())) {
            this.current.setValue(null);
            BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
                int label;
                final /* synthetic */ ExtensionLoader this$0;
                {
                    this.this$0 = $receiver;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            this.label = 1;
                            v0 = DelayKt.delay((long)1L, (Continuation)((Continuation)this));
                            if (v0 == var2_2) {
                                return var2_2;
                            }
                            ** GOTO lbl13
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            v0 = $result;
lbl13:
                            // 2 sources

                            ExtensionLoader.access$setCurrentExtension(this.this$0);
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
    }

    @NotNull
    public final Lazy<UnifiedExtension> getUnified() {
        return this.unified;
    }

    @NotNull
    public final MutableSharedFlow<File> getFileIgnoreFlow() {
        return this.fileIgnoreFlow;
    }

    @NotNull
    public final Map<ExtensionType, MutableStateFlow<List<String>>> getPriorityMap() {
        return this.priorityMap;
    }

    @NotNull
    public final MutableStateFlow<MusicExtension> getCurrent() {
        return this.current;
    }

    private final void setCurrentExtension() {
        MusicExtension musicExtension;
        Object object;
        List list2;
        block4: {
            String last = this.settings.getString(LAST_EXTENSION_KEY, null);
            list2 = (List)this.music.getValue();
            Iterable iterable = list2;
            for (Object object2 : iterable) {
                MusicExtension musicExtension2 = (MusicExtension)object2;
                boolean bl = false;
                if (!(Intrinsics.areEqual((Object)musicExtension2.getId(), (Object)last) && musicExtension2.isEnabled())) continue;
                object = object2;
                break block4;
            }
            object = null;
        }
        if ((musicExtension = (MusicExtension)object) == null) {
            Object v2;
            block5: {
                Iterable iterable = list2;
                boolean bl = false;
                for (Object e : iterable) {
                    MusicExtension musicExtension3 = (MusicExtension)e;
                    boolean bl2 = false;
                    if (!musicExtension3.isEnabled()) continue;
                    v2 = e;
                    break block5;
                }
                v2 = null;
            }
            if ((musicExtension = (MusicExtension)v2) == null) {
                return;
            }
        }
        MusicExtension extension2 = musicExtension;
        this.setupMusicExtension(extension2, false);
    }

    public final void setupMusicExtension(@NotNull MusicExtension extension2, boolean manual) {
        Intrinsics.checkNotNullParameter((Object)extension2, (String)"extension");
        if (manual) {
            SharedPreferences.Editor editor;
            SharedPreferences sharedPreferences = this.settings;
            boolean bl = false;
            boolean bl2 = false;
            SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
            boolean bl3 = false;
            editor2.putString(LAST_EXTENSION_KEY, extension2.getId());
            editor.apply();
        }
        this.current.setValue((Object)extension2);
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(extension2, this, null){
            Object L$0;
            int label;
            final /* synthetic */ MusicExtension $extension;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.$extension = $extension;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var3_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        var2_3 = ExtensionUtils.INSTANCE;
                        this.L$0 = var2_3;
                        this.label = 1;
                        v0 = ExtensionUtils.INSTANCE.get-0E7RQCE(this.$extension, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null){
                            int label;
                            private /* synthetic */ Object L$0;

                            /*
                             * WARNING - void declaration
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public final Object invokeSuspend(Object $result) {
                                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void $this$get;
                                        ResultKt.throwOnFailure((Object)$result);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.label = 1;
                                        Object object2 = $this$get.onExtensionSelected((Continuation<? super Unit>)((Continuation)this));
                                        if (object2 != object) return Unit.INSTANCE;
                                        return object;
                                    }
                                    case 1: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        Object object2 = $result;
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

                            public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, (Continuation)this);
                        if (v0 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        var2_3 = (ExtensionUtils)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = ((Result)$result).unbox-impl();
lbl16:
                        // 2 sources

                        this.L$0 = null;
                        this.label = 2;
                        v1 = var2_3.getOrThrow(v0, this.this$0.getApp().getThrowFlow(), (Continuation)this);
                        if (v1 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl25
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl25:
                        // 2 sources

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

    @NotNull
    public final WebViewClientFactory getWebViewClientFactory() {
        return this.webViewClientFactory;
    }

    private final WebViewClient createWebClient(dev.brahmkshatriya.echo.common.models.Metadata metadata2) {
        if (metadata2.getType() != ExtensionType.MUSIC) {
            throw new Exception("Webview client is not available for " + metadata2.getType() + " Extensions");
        }
        return this.webViewClientFactory.createFor(metadata2);
    }

    private final Injectable<ExtensionClient> injected(Lazy<? extends ExtensionClient> $this$injected, dev.brahmkshatriya.echo.common.models.Metadata metadata2) {
        Object[] objectArray = new Function2[]{new Function2<ExtensionClient, Continuation<? super Unit>, Object>(metadata2, this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ dev.brahmkshatriya.echo.common.models.Metadata $metadata;
            final /* synthetic */ ExtensionLoader this$0;
            {
                this.$metadata = $metadata;
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (ExtensionClient)this.L$0;
                var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        if ($this$mutableListOf instanceof MetadataProvider) {
                            ((MetadataProvider)$this$mutableListOf).setMetadata(this.$metadata);
                        }
                        if ($this$mutableListOf instanceof MessageFlowProvider) {
                            ((MessageFlowProvider)$this$mutableListOf).setMessageFlow(this.this$0.getApp().getMessageFlow());
                        }
                        if ($this$mutableListOf instanceof GlobalSettingsProvider) {
                            ((GlobalSettingsProvider)$this$mutableListOf).setGlobalSettings(ExtensionUtils.INSTANCE.getGlobalSettings((Context)this.this$0.getApp().getContext()));
                        }
                        $this$mutableListOf.setSettings(ExtensionUtils.INSTANCE.getSettings((Context)this.this$0.getApp().getContext(), this.$metadata));
                        if ($this$mutableListOf instanceof WebViewClientProvider) {
                            ((WebViewClientProvider)$this$mutableListOf).setWebViewClient(ExtensionLoader.access$createWebClient(this.this$0, this.$metadata));
                        }
                        this.L$0 = $this$mutableListOf;
                        this.label = 1;
                        v0 = $this$mutableListOf.onInitialize((Continuation<? super Unit>)((Continuation)this));
                        if (v0 == var3_3) {
                            return var3_3;
                        }
                        ** GOTO lbl24
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl24:
                        // 2 sources

                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$mutableListOf);
                        this.label = 2;
                        v1 = $this$mutableListOf.onExtensionSelected((Continuation<? super Unit>)((Continuation)this));
                        if (v1 == var3_3) {
                            return var3_3;
                        }
                        ** GOTO lbl33
                    }
                    case 2: {
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl33:
                        // 2 sources

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

            public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }};
        return new Injectable<ExtensionClient>((Function0)new PropertyReference0Impl($this$injected){

            public Object get() {
                return ((Lazy)this.receiver).getValue();
            }
        }, CollectionsKt.mutableListOf((Object[])objectArray));
    }

    private final <T extends Extension<?>> StateFlow<List<T>> mapped(ExtensionType type, Function2<? super dev.brahmkshatriya.echo.common.models.Metadata, ? super Injectable<ExtensionClient>, ? extends T> transform2) {
        Flow<List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Injectable<ExtensionClient>>>>> flow2 = this.injected;
        boolean bl = false;
        Flow<List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Injectable<ExtensionClient>>>>> flow3 = flow2;
        boolean bl2 = false;
        boolean bl3 = false;
        Flow flow4 = new Flow<List<? extends T>>(flow3, type, transform2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ ExtensionType $type$inlined;
            final /* synthetic */ Function2 $transform$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$type$inlined = extensionType;
                this.$transform$inlined = function2;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$type$inlined, this.$transform$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ ExtensionType $type$inlined;
                    final /* synthetic */ Function2 $transform$inlined$1;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$type$inlined = extensionType;
                        this.$transform$inlined$1 = function2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof mapped$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ mapped$$inlined$map$1$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list\1 = (List)value;
                                $i$a$-map-ExtensionLoader$mapped$1\1\50\0 = false;
                                $this$mapNotNull\2 = list\1;
                                $i$f$mapNotNull\2\51 = false;
                                var16_20 = $this$mapNotNull\2;
                                destination\3 = new ArrayList<E>();
                                $i$f$mapNotNullTo\3\52 = false;
                                $this$forEach\4 = $this$mapNotNullTo\3;
                                $i$f$forEach\4\60 = false;
                                var21_25 = $this$forEach\4.iterator();
                                while (var21_25.hasNext()) {
                                    element\5 = element\4 = var21_25.next();
                                    $i$a$-forEach-CollectionsKt___CollectionsKt$mapNotNullTo$1\5\61\3 = false;
                                    it\6 = ((Result)element\5).unbox-impl();
                                    $i$a$-mapNotNull-ExtensionLoader$mapped$1$1\6\60\1 = false;
                                    if ((Pair)(Result.isFailure-impl((Object)it\6) != false ? null : it\6) == null) {
                                        v0 = null;
                                    } else {
                                        meta\6 = (dev.brahmkshatriya.echo.common.models.Metadata)var27_31.component1();
                                        injectable\6 = (Injectable)var27_31.component2();
                                        v0 = meta\6.getType() != this.$type$inlined ? null : (Extension)this.$transform$inlined$1.invoke((Object)meta\6, (Object)injectable\6);
                                    }
                                    if (v0 == null) continue;
                                    it\5 = v0;
                                    $i$a$-let-CollectionsKt___CollectionsKt$mapNotNullTo$1$1\7\65\5 = false;
                                    destination\3.add(it\5);
                                }
                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                $continuation.label = 1;
                                v1 = var10_14.emit((Object)((List)destination\3), (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl63
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl63:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
        MutableStateFlow<List<String>> mutableStateFlow = this.priorityMap.get((Object)type);
        Intrinsics.checkNotNull(mutableStateFlow);
        return FlowKt.stateIn((Flow)FlowKt.flowCombine((Flow)flow4, (Flow)((Flow)mutableStateFlow), (Function3)new Function3<List<? extends T>, List<? extends String>, Continuation<? super List<? extends T>>, Object>(this, type, null){
            int label;
            /* synthetic */ Object L$0;
            final /* synthetic */ ExtensionLoader this$0;
            final /* synthetic */ ExtensionType $type;
            {
                this.this$0 = $receiver;
                this.$type = $type;
                super(3, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                List list2 = (List)this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void list3;
                        ResultKt.throwOnFailure((Object)$result);
                        return ExtensionLoader.access$sorted(this.this$0, (List)list3, this.$type, mapped.2::invokeSuspend$lambda$0);
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(List<? extends T> p1, List<String> p2, Continuation<? super List<? extends T>> p3) {
                var var4_4 = new /* invalid duplicate definition of identical inner class */;
                var4_4.L$0 = p1;
                return var4_4.invokeSuspend(Unit.INSTANCE);
            }

            private static final String invokeSuspend$lambda$0(Extension it) {
                return it.getId();
            }
        }), (CoroutineScope)this.scope, (SharingStarted)SharingStarted.Companion.getLazily(), (Object)CollectionsKt.emptyList());
    }

    @NotNull
    public final StateFlow<List<MusicExtension>> getMusic() {
        return this.music;
    }

    @NotNull
    public final StateFlow<List<TrackerExtension>> getTracker() {
        return this.tracker;
    }

    @NotNull
    public final StateFlow<List<LyricsExtension>> getLyrics() {
        return this.lyrics;
    }

    @NotNull
    public final StateFlow<List<MiscExtension>> getMisc() {
        return this.misc;
    }

    @NotNull
    public final StateFlow<List<Extension<? extends ExtensionClient>>> getAll() {
        return this.all;
    }

    private final <T> List<T> sorted(List<? extends T> $this$sorted, ExtensionType type, Function1<? super T, String> id2) {
        MutableStateFlow<List<String>> mutableStateFlow = this.priorityMap.get((Object)type);
        Intrinsics.checkNotNull(mutableStateFlow);
        List priority = (List)mutableStateFlow.getValue();
        Iterable iterable = $this$sorted;
        boolean bl = false;
        return CollectionsKt.sortedWith((Iterable)iterable, (Comparator)new Comparator(priority, id2){
            final /* synthetic */ List $priority$inlined;
            final /* synthetic */ Function1 $id$inlined;
            {
                this.$priority$inlined = list2;
                this.$id$inlined = function1;
            }

            /*
             * WARNING - void declaration
             */
            public final int compare(T a, T b) {
                void it\2;
                T t = a;
                boolean bl = false;
                Comparable comparable = Integer.valueOf(this.$priority$inlined.indexOf(this.$id$inlined.invoke(t)));
                t = b;
                Comparable comparable2 = comparable;
                boolean bl2 = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(this.$priority$inlined.indexOf(this.$id$inlined.invoke((Object)it\2))));
            }
        });
    }

    @NotNull
    public final StateFlow<List<Extension<? extends ExtensionClient>>> getFlow(@NotNull ExtensionType type) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        return switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1 -> this.music;
            case 2 -> this.tracker;
            case 3 -> this.lyrics;
            case 4 -> this.misc;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    private final void injectProviders(ExtensionClient client) {
        block3: {
            MusicExtensionsProvider musicExtensionsProvider = client instanceof MusicExtensionsProvider ? (MusicExtensionsProvider)((Object)client) : null;
            if (musicExtensionsProvider != null) {
                MusicExtensionsProvider musicExtensionsProvider2 = musicExtensionsProvider;
                boolean bl = false;
                ExtensionLoader.Companion.inject(musicExtensionsProvider2, musicExtensionsProvider2.getRequiredMusicExtensions(), (List)this.music.getValue(), ExtensionLoader::injectProviders$lambda$22$lambda$21);
            }
            TrackerExtensionsProvider trackerExtensionsProvider = client instanceof TrackerExtensionsProvider ? (TrackerExtensionsProvider)((Object)client) : null;
            if (trackerExtensionsProvider != null) {
                TrackerExtensionsProvider trackerExtensionsProvider2 = trackerExtensionsProvider;
                boolean bl = false;
                ExtensionLoader.Companion.inject(trackerExtensionsProvider2, trackerExtensionsProvider2.getRequiredTrackerExtensions(), (List)this.tracker.getValue(), ExtensionLoader::injectProviders$lambda$24$lambda$23);
            }
            LyricsExtensionsProvider lyricsExtensionsProvider = client instanceof LyricsExtensionsProvider ? (LyricsExtensionsProvider)((Object)client) : null;
            if (lyricsExtensionsProvider != null) {
                LyricsExtensionsProvider lyricsExtensionsProvider2 = lyricsExtensionsProvider;
                boolean bl = false;
                ExtensionLoader.Companion.inject(lyricsExtensionsProvider2, lyricsExtensionsProvider2.getRequiredLyricsExtensions(), (List)this.lyrics.getValue(), ExtensionLoader::injectProviders$lambda$26$lambda$25);
            }
            MiscExtensionsProvider miscExtensionsProvider = client instanceof MiscExtensionsProvider ? (MiscExtensionsProvider)((Object)client) : null;
            if (miscExtensionsProvider == null) break block3;
            MiscExtensionsProvider miscExtensionsProvider2 = miscExtensionsProvider;
            boolean bl = false;
            ExtensionLoader.Companion.inject(miscExtensionsProvider2, miscExtensionsProvider2.getRequiredMiscExtensions(), (List)this.misc.getValue(), ExtensionLoader::injectProviders$lambda$28$lambda$27);
        }
    }

    private static final UnifiedExtension unified$lambda$0(ExtensionLoader this$0) {
        return new UnifiedExtension(this$0.app, this$0.cache);
    }

    private static final OfflineExtension repository$lambda$1(ExtensionLoader this$0) {
        return new OfflineExtension((Context)this$0.app.getContext());
    }

    private static final MusicExtension music$lambda$16(dev.brahmkshatriya.echo.common.models.Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new MusicExtension(m, i);
    }

    private static final TrackerExtension tracker$lambda$17(dev.brahmkshatriya.echo.common.models.Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new TrackerExtension(m, i.casted());
    }

    private static final LyricsExtension lyrics$lambda$18(dev.brahmkshatriya.echo.common.models.Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new LyricsExtension(m, i.casted());
    }

    private static final MiscExtension misc$lambda$19(dev.brahmkshatriya.echo.common.models.Metadata m, Injectable i) {
        Intrinsics.checkNotNullParameter((Object)m, (String)"m");
        Intrinsics.checkNotNullParameter((Object)i, (String)"i");
        return new MiscExtension(m, i);
    }

    private static final Unit injectProviders$lambda$22$lambda$21(MusicExtensionsProvider $this$inject, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$inject, (String)"$this$inject");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$inject.setMusicExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$24$lambda$23(TrackerExtensionsProvider $this$inject, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$inject, (String)"$this$inject");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$inject.setTrackerExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$26$lambda$25(LyricsExtensionsProvider $this$inject, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$inject, (String)"$this$inject");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$inject.setLyricsExtensions(it);
        return Unit.INSTANCE;
    }

    private static final Unit injectProviders$lambda$28$lambda$27(MiscExtensionsProvider $this$inject, List it) {
        Intrinsics.checkNotNullParameter((Object)$this$inject, (String)"$this$inject");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $this$inject.setMiscExtensions(it);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ WebViewClient access$createWebClient(ExtensionLoader $this, dev.brahmkshatriya.echo.common.models.Metadata metadata2) {
        return $this.createWebClient(metadata2);
    }

    public static final /* synthetic */ List access$sorted(ExtensionLoader $this, List $receiver, ExtensionType type, Function1 id2) {
        return $this.sorted($receiver, type, id2);
    }

    public static final /* synthetic */ Injectable access$injected(ExtensionLoader $this, Lazy $receiver, dev.brahmkshatriya.echo.common.models.Metadata metadata2) {
        return $this.injected((Lazy<? extends ExtensionClient>)$receiver, metadata2);
    }

    public static final /* synthetic */ void access$injectProviders(ExtensionLoader $this, ExtensionClient client) {
        $this.injectProviders(client);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Jf\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0006\"\f\b\u0001\u0010\u0007*\u0006\u0012\u0002\b\u00030\b*\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2#\u0010\r\u001a\u001f\u0012\u0004\u0012\u0002H\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\n\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\u0002\b\u000fH\u0002\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0013\u001a\u00020\u0014J\n\u0010\u0015\u001a\u00020\u000b*\u00020\u0016R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/extensions/ExtensionLoader$Companion;", "", "<init>", "()V", "inject", "", "T", "R", "Ldev/brahmkshatriya/echo/common/Extension;", "required", "", "", "extensions", "set", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getUser", "Ldev/brahmkshatriya/echo/extensions/db/models/CurrentUser;", "ext", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "priorityKey", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "LAST_EXTENSION_KEY", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nExtensionLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionLoader.kt\ndev/brahmkshatriya/echo/extensions/ExtensionLoader$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,264:1\n774#2:265\n865#2,2:266\n1#3:268\n*S KotlinDebug\n*F\n+ 1 ExtensionLoader.kt\ndev/brahmkshatriya/echo/extensions/ExtensionLoader$Companion\n*L\n248#1:265\n248#1:266,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        private final <T, R extends Extension<?>> void inject(T $this$inject, List<String> required, List<? extends R> extensions2, Function2<? super T, ? super List<? extends R>, Unit> set) {
            if (required.isEmpty()) {
                set.invoke($this$inject, extensions2);
            } else {
                void $this$filterTo\2;
                Iterable iterable = extensions2;
                boolean bl = false;
                Iterable iterable2 = iterable;
                Collection collection = new ArrayList();
                boolean bl2 = false;
                for (Object t : $this$filterTo\2) {
                    Extension extension2 = (Extension)t;
                    boolean bl3 = false;
                    if (!required.contains(extension2.getMetadata().getId())) continue;
                    collection.add(t);
                }
                List filtered = (List)collection;
                if (filtered.size() == required.size()) {
                    set.invoke($this$inject, (Object)filtered);
                } else {
                    throw new RequiredExtensionsMissingException(required);
                }
            }
        }

        @Nullable
        public final CurrentUser getUser(@NotNull List<CurrentUser> $this$getUser, @NotNull dev.brahmkshatriya.echo.common.models.Metadata ext) {
            Object v0;
            block1: {
                Intrinsics.checkNotNullParameter($this$getUser, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)ext, (String)"ext");
                Iterable iterable = $this$getUser;
                for (Object t : iterable) {
                    CurrentUser currentUser = (CurrentUser)t;
                    boolean bl = false;
                    if (!(currentUser.getType() == ext.getType() && Intrinsics.areEqual((Object)currentUser.getExtId(), (Object)ext.getId()))) continue;
                    v0 = t;
                    break block1;
                }
                v0 = null;
            }
            CurrentUser curr = v0;
            return curr;
        }

        @NotNull
        public final String priorityKey(@NotNull ExtensionType $this$priorityKey) {
            Intrinsics.checkNotNullParameter((Object)((Object)$this$priorityKey), (String)"<this>");
            return "priority_" + $this$priorityKey.getFeature();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ExtensionType.values().length];
            try {
                nArray[ExtensionType.MUSIC.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.TRACKER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.LYRICS.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ExtensionType.MISC.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

