/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.test;

import android.content.Context;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.AlbumClient;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.PlaylistClient;
import dev.brahmkshatriya.echo.common.clients.RadioClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.providers.MusicExtensionsProvider;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.builtin.test.DownloadExtension;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u001dJ2\u0010\u001e\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012H\u0096@\u00a2\u0006\u0002\u0010 J,\u0010!\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010#J.\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010\u0003\u001a\u0004\u0018\u00010(H\u0096@\u00a2\u0006\u0002\u0010)J,\u0010*\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0082@\u00a2\u0006\u0002\u0010/J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0012H\u0096@\u00a2\u0006\u0002\u00102J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010<\u001a\u0002042\f\u0010=\u001a\b\u0012\u0004\u0012\u00020;0\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020&0\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/DownloadExtension;", "Ldev/brahmkshatriya/echo/common/clients/DownloadClient;", "Ldev/brahmkshatriya/echo/common/providers/MusicExtensionsProvider;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "concurrentDownloads", "", "getConcurrentDownloads", "()I", "selectServer", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "(Ldev/brahmkshatriya/echo/common/models/DownloadContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectSources", "", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "server", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "(Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "Ljava/io/File;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "source", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ldev/brahmkshatriya/echo/common/models/Streamable$Source;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "merge", "files", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tag", "file", "(Lkotlinx/coroutines/flow/MutableStateFlow;Ldev/brahmkshatriya/echo/common/models/DownloadContext;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadTracks", "extensionId", "", "item", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "test", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "type", "crash", "", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettingItems", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "requiredMusicExtensions", "getRequiredMusicExtensions", "()Ljava/util/List;", "exts", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "setMusicExtensions", "extensions", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nDownloadExtension.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/DownloadExtension\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n*L\n1#1,139:1\n230#2,2:140\n1573#2:157\n1604#2,4:158\n33#3,5:142\n33#3,5:147\n33#3,5:152\n*S KotlinDebug\n*F\n+ 1 DownloadExtension.kt\ndev/brahmkshatriya/echo/extensions/builtin/test/DownloadExtension\n*L\n86#1:140,2\n106#1:157\n106#1:158,4\n88#1:142,5\n94#1:147,5\n100#1:152,5\n*E\n"})
public final class DownloadExtension
implements DownloadClient,
MusicExtensionsProvider {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Context context;
    private final int concurrentDownloads;
    @NotNull
    private final List<String> requiredMusicExtensions;
    private List<MusicExtension> exts;
    @NotNull
    private static final Metadata metadata = new Metadata("DownloadExtension", "", ImportType.BuiltIn, ExtensionType.MISC, "test_download", "Test Download Extension", "1.0.0", "Test extension for download testing", "Test", null, null, null, null, null, false, 32256, null);

    public DownloadExtension(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.context = context;
        this.concurrentDownloads = 2;
        this.requiredMusicExtensions = CollectionsKt.emptyList();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Override
    public int getConcurrentDownloads() {
        return this.concurrentDownloads;
    }

    @Override
    @Nullable
    public Object selectServer(@NotNull DownloadContext context, @NotNull Continuation<? super Streamable> $completion) {
        return CollectionsKt.first(context.getTrack().getServers());
    }

    @Override
    @Nullable
    public Object selectSources(@NotNull DownloadContext context, @NotNull Streamable.Media.Server server2, @NotNull Continuation<? super List<? extends Streamable.Source>> $completion) {
        return server2.getSources();
    }

    @Override
    @Nullable
    public Object download(@NotNull MutableStateFlow<Progress> progressFlow2, @NotNull DownloadContext context, @NotNull Streamable.Source source, @NotNull Continuation<? super File> $completion) {
        return this.test((MutableSharedFlow<Progress>)((MutableSharedFlow)progressFlow2), "Downloading", 10000L, $completion);
    }

    @Override
    @Nullable
    public Object merge(@NotNull MutableStateFlow<Progress> progressFlow2, @NotNull DownloadContext context, @NotNull List<? extends File> files, @NotNull Continuation<? super File> $completion) {
        return this.test((MutableSharedFlow<Progress>)((MutableSharedFlow)progressFlow2), "Merging", 5000L, $completion);
    }

    @Override
    @Nullable
    public Object tag(@NotNull MutableStateFlow<Progress> progressFlow2, @NotNull DownloadContext context, @NotNull File file2, @NotNull Continuation<? super File> $completion) {
        return this.test((MutableSharedFlow<Progress>)((MutableSharedFlow)progressFlow2), "Tagging", 2000L, $completion);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object getDownloadTracks(@NotNull String extensionId, @NotNull EchoMediaItem item, @Nullable EchoMediaItem context, @NotNull Continuation<? super List<DownloadContext>> $completion) {
        block15: {
            block16: {
                block17: {
                    block19: {
                        block18: {
                            if (!($completion instanceof getDownloadTracks.1)) ** GOTO lbl-1000
                            var22_5 = $completion;
                            if ((var22_5.label & -2147483648) != 0) {
                                var22_5.label -= -2147483648;
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
                                    /* synthetic */ Object result;
                                    final /* synthetic */ DownloadExtension this$0;
                                    int label;
                                    {
                                        this.this$0 = this$0;
                                        super($completion);
                                    }

                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object $result) {
                                        this.result = $result;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.getDownloadTracks(null, null, null, (Continuation<? super List<DownloadContext>>)((Continuation)this));
                                    }
                                };
                            }
                            $result = $continuation.result;
                            var23_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)$result);
                                    var5_8 = item;
                                    if (!(var5_8 instanceof Track)) ** GOTO lbl16
                                    v0 = CollectionsKt.listOf((Object)new DownloadContext(extensionId, (Track)item, null, null, 12, null));
                                    break block15;
lbl16:
                                    // 1 sources

                                    if (!(var5_8 instanceof EchoMediaItem.Lists)) break block16;
                                    v1 = this.exts;
                                    if (v1 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException((String)"exts");
                                        v1 = null;
                                    }
                                    $this$first\1 = v1;
                                    $i$f$first\1\86 = false;
                                    for (T element\1 : $this$first\1) {
                                        it\2 = (MusicExtension)element\1;
                                        $i$a$-first-DownloadExtension$getDownloadTracks$ext$1\2\140\0 = false;
                                        if (!Intrinsics.areEqual((Object)it\2.getId(), (Object)extensionId)) continue;
                                        ** GOTO lbl29
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
lbl29:
                                    // 1 sources

                                    ext = (MusicExtension)element\1;
                                    $i$f$first\1\86 = (EchoMediaItem.Lists)item;
                                    if (!($i$f$first\1\86 instanceof Album)) break;
                                    var9_12 = ExtensionUtils.INSTANCE;
                                    $this$getAs_u2d0E7RQCE\3 = ext;
                                    $i$f$getAs-0E7RQCE\3\88 = 0;
                                    $continuation.L$0 = extensionId;
                                    $continuation.L$1 = item;
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)context);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)ext);
                                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\3);
                                    $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\3);
                                    $continuation.I$0 = $i$f$getAs-0E7RQCE\3\88;
                                    $continuation.label = 1;
                                    v2 = this_\3.get-0E7RQCE($this$getAs_u2d0E7RQCE\3, (Function2)new Function2<ExtensionClient, Continuation<? super List<? extends Track>>, Object>(null, item){
                                        Object L$1;
                                        int label;
                                        private /* synthetic */ Object L$0;
                                        final /* synthetic */ EchoMediaItem $item$inlined;
                                        Object L$2;
                                        Object L$3;
                                        Object L$4;
                                        Object L$5;
                                        int I$0;
                                        {
                                            this.$item$inlined = echoMediaItem;
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
                                                    v0 = $this$get;
                                                    if (!(v0 instanceof AlbumClient)) {
                                                        v0 = null;
                                                    }
                                                    v1 = v0;
                                                    if (v1 == null) {
                                                        v2 = Reflection.getOrCreateKotlinClass(AlbumClient.class).getSimpleName();
                                                        if (v2 == null) {
                                                            v2 = "Unknown Class";
                                                        }
                                                        throw new ClientException.NotSupported(v2);
                                                    }
                                                    client = v1;
                                                    var5_6 = (Continuation)this;
                                                    $this$getDownloadTracks_u24lambda_u241\1 = client;
                                                    $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0 = 0;
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                                    this.L$3 = $this$getDownloadTracks_u24lambda_u241\1;
                                                    this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0;
                                                    this.label = 1;
                                                    v3 = $this$getDownloadTracks_u24lambda_u241\1.loadAlbum((Album)this.$item$inlined, (Continuation<? super Album>)this);
                                                    if (v3 == var3_3) {
                                                        return var3_3;
                                                    }
                                                    ** GOTO lbl36
                                                }
                                                case 1: {
                                                    $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0 = this.I$0;
                                                    $this$getDownloadTracks_u24lambda_u241\1 = (AlbumClient)this.L$3;
                                                    $completion\1 = (Continuation)this.L$2;
                                                    client = (AlbumClient)this.L$1;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v3 = $result;
lbl36:
                                                    // 2 sources

                                                    album\1 = (Album)v3;
                                                    var9_14 = Feed.Companion;
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u241\1);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable((Object)album\1);
                                                    this.L$5 = var9_14;
                                                    this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0;
                                                    this.label = 2;
                                                    v4 = $this$getDownloadTracks_u24lambda_u241\1.loadTracks(album\1, (Continuation<? super Feed<Track>>)this);
                                                    if (v4 == var3_3) {
                                                        return var3_3;
                                                    }
                                                    ** GOTO lbl59
                                                }
                                                case 2: {
                                                    $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0 = this.I$0;
                                                    var9_14 = (Feed.Companion)this.L$5;
                                                    album\1 = (Album)this.L$4;
                                                    $this$getDownloadTracks_u24lambda_u241\1 = (AlbumClient)this.L$3;
                                                    $completion\1 = (Continuation)this.L$2;
                                                    client = (AlbumClient)this.L$1;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v4 = $result;
lbl59:
                                                    // 2 sources

                                                    Intrinsics.checkNotNull((Object)v4);
                                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                                    this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                                    this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                                    this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u241\1);
                                                    this.L$4 = SpillingKt.nullOutSpilledVariable((Object)album\1);
                                                    this.L$5 = null;
                                                    this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0;
                                                    this.label = 3;
                                                    v5 = var9_14.loadAll((Feed)v4, this);
                                                    if (v5 == var3_3) {
                                                        return var3_3;
                                                    }
                                                    ** GOTO lbl80
                                                }
                                                case 3: {
                                                    $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$1\1\36\0 = this.I$0;
                                                    album\1 = (Album)this.L$4;
                                                    $this$getDownloadTracks_u24lambda_u241\1 = (AlbumClient)this.L$3;
                                                    $completion\1 = (Continuation)this.L$2;
                                                    client = (AlbumClient)this.L$1;
                                                    ResultKt.throwOnFailure((Object)$result);
                                                    v5 = $result;
lbl80:
                                                    // 2 sources

                                                    tracks\1 = (List)v5;
                                                    return tracks\1;
                                                }
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }

                                        public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                            var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                            var3_3.L$0 = value2;
                                            return (Continuation)var3_3;
                                        }

                                        public final Object invoke(ExtensionClient p1, Continuation<? super List<? extends Track>> p2) {
                                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                        }
                                    }, $continuation);
                                    if (v2 == var23_7) {
                                        return var23_7;
                                    }
                                    break block17;
                                }
                                case 1: {
                                    $i$f$getAs-0E7RQCE\3\88 = $continuation.I$0;
                                    $this$getAs_u2d0E7RQCE\3 = (Extension)$continuation.L$5;
                                    this_\3 = (ExtensionUtils)$continuation.L$4;
                                    ext = (MusicExtension)$continuation.L$3;
                                    context = (EchoMediaItem)$continuation.L$2;
                                    item = (EchoMediaItem)$continuation.L$1;
                                    extensionId = (String)$continuation.L$0;
                                    ResultKt.throwOnFailure((Object)$result);
                                    v2 = ((Result)$result).unbox-impl();
                                    break block17;
                                }
                            }
                            if (!($i$f$first\1\86 instanceof Playlist)) break block18;
                            this_\3 = ExtensionUtils.INSTANCE;
                            $this$getAs_u2d0E7RQCE\4 = ext;
                            $i$f$getAs-0E7RQCE\4\94 = 0;
                            $continuation.L$0 = extensionId;
                            $continuation.L$1 = item;
                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)context);
                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)ext);
                            $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\4);
                            $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\4);
                            $continuation.I$0 = $i$f$getAs-0E7RQCE\4\94;
                            $continuation.label = 2;
                            v2 = this_\4.get-0E7RQCE($this$getAs_u2d0E7RQCE\4, (Function2)new Function2<ExtensionClient, Continuation<? super List<? extends Track>>, Object>(null, item){
                                Object L$1;
                                int label;
                                private /* synthetic */ Object L$0;
                                final /* synthetic */ EchoMediaItem $item$inlined;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                Object L$5;
                                int I$0;
                                {
                                    this.$item$inlined = echoMediaItem;
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
                                            v0 = $this$get;
                                            if (!(v0 instanceof PlaylistClient)) {
                                                v0 = null;
                                            }
                                            v1 = v0;
                                            if (v1 == null) {
                                                v2 = Reflection.getOrCreateKotlinClass(PlaylistClient.class).getSimpleName();
                                                if (v2 == null) {
                                                    v2 = "Unknown Class";
                                                }
                                                throw new ClientException.NotSupported(v2);
                                            }
                                            client = v1;
                                            var5_6 = (Continuation)this;
                                            $this$getDownloadTracks_u24lambda_u242\1 = client;
                                            $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                            this.L$3 = $this$getDownloadTracks_u24lambda_u242\1;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0;
                                            this.label = 1;
                                            v3 = $this$getDownloadTracks_u24lambda_u242\1.loadPlaylist((Playlist)this.$item$inlined, (Continuation<? super Playlist>)this);
                                            if (v3 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl36
                                        }
                                        case 1: {
                                            $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0 = this.I$0;
                                            $this$getDownloadTracks_u24lambda_u242\1 = (PlaylistClient)this.L$3;
                                            $completion\1 = (Continuation)this.L$2;
                                            client = (PlaylistClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v3 = $result;
lbl36:
                                            // 2 sources

                                            album\1 = (Playlist)v3;
                                            var9_14 = Feed.Companion;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u242\1);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)album\1);
                                            this.L$5 = var9_14;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0;
                                            this.label = 2;
                                            v4 = $this$getDownloadTracks_u24lambda_u242\1.loadTracks(album\1, (Continuation<? super Feed<Track>>)this);
                                            if (v4 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl59
                                        }
                                        case 2: {
                                            $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0 = this.I$0;
                                            var9_14 = (Feed.Companion)this.L$5;
                                            album\1 = (Playlist)this.L$4;
                                            $this$getDownloadTracks_u24lambda_u242\1 = (PlaylistClient)this.L$3;
                                            $completion\1 = (Continuation)this.L$2;
                                            client = (PlaylistClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v4 = $result;
lbl59:
                                            // 2 sources

                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u242\1);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)album\1);
                                            this.L$5 = null;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0;
                                            this.label = 3;
                                            v5 = var9_14.loadAll((Feed)v4, this);
                                            if (v5 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl79
                                        }
                                        case 3: {
                                            $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$2\1\36\0 = this.I$0;
                                            album\1 = (Playlist)this.L$4;
                                            $this$getDownloadTracks_u24lambda_u242\1 = (PlaylistClient)this.L$3;
                                            $completion\1 = (Continuation)this.L$2;
                                            client = (PlaylistClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v5 = $result;
lbl79:
                                            // 2 sources

                                            tracks\1 = (List)v5;
                                            return tracks\1;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                    var3_3.L$0 = value2;
                                    return (Continuation)var3_3;
                                }

                                public final Object invoke(ExtensionClient p1, Continuation<? super List<? extends Track>> p2) {
                                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                }
                            }, $continuation);
                            if (v2 == var23_7) {
                                return var23_7;
                            }
                            break block17;
                            {
                                case 2: {
                                    $i$f$getAs-0E7RQCE\4\94 = $continuation.I$0;
                                    $this$getAs_u2d0E7RQCE\4 = (Extension)$continuation.L$5;
                                    this_\4 = (ExtensionUtils)$continuation.L$4;
                                    ext = (MusicExtension)$continuation.L$3;
                                    context = (EchoMediaItem)$continuation.L$2;
                                    item = (EchoMediaItem)$continuation.L$1;
                                    extensionId = (String)$continuation.L$0;
                                    ResultKt.throwOnFailure((Object)$result);
                                    v2 = ((Result)$result).unbox-impl();
                                    break block17;
                                }
                            }
                        }
                        if (!($i$f$first\1\86 instanceof Radio)) break block19;
                        this_\4 = ExtensionUtils.INSTANCE;
                        $this$getAs_u2d0E7RQCE\5 = ext;
                        $i$f$getAs-0E7RQCE\5\100 = 0;
                        $continuation.L$0 = extensionId;
                        $continuation.L$1 = item;
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)context);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)this_\5);
                        $continuation.L$5 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\5);
                        $continuation.I$0 = $i$f$getAs-0E7RQCE\5\100;
                        $continuation.label = 3;
                        v2 = this_\5.get-0E7RQCE((Extension<?>)$this$getAs_u2d0E7RQCE\5, (Function2)new Function2<ExtensionClient, Continuation<? super List<? extends Track>>, Object>(null, item){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ EchoMediaItem $item$inlined;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            int I$0;
                            {
                                this.$item$inlined = echoMediaItem;
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
                                        v0 = $this$get;
                                        if (!(v0 instanceof RadioClient)) {
                                            v0 = null;
                                        }
                                        v1 = v0;
                                        if (v1 == null) {
                                            v2 = Reflection.getOrCreateKotlinClass(RadioClient.class).getSimpleName();
                                            if (v2 == null) {
                                                v2 = "Unknown Class";
                                            }
                                            throw new ClientException.NotSupported(v2);
                                        }
                                        client = v1;
                                        var5_6 = (Continuation)this;
                                        $this$getDownloadTracks_u24lambda_u243\1 = client;
                                        $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0 = 0;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                        this.L$3 = $this$getDownloadTracks_u24lambda_u243\1;
                                        this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0;
                                        this.label = 1;
                                        v3 = $this$getDownloadTracks_u24lambda_u243\1.loadRadio((Radio)this.$item$inlined, (Continuation<? super Radio>)this);
                                        if (v3 == var3_3) {
                                            return var3_3;
                                        }
                                        ** GOTO lbl36
                                    }
                                    case 1: {
                                        $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0 = this.I$0;
                                        $this$getDownloadTracks_u24lambda_u243\1 = (RadioClient)this.L$3;
                                        $completion\1 = (Continuation)this.L$2;
                                        client = (RadioClient)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v3 = $result;
lbl36:
                                        // 2 sources

                                        radio\1 = (Radio)v3;
                                        var9_14 = Feed.Companion;
                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u243\1);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)radio\1);
                                        this.L$5 = var9_14;
                                        this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0;
                                        this.label = 2;
                                        v4 = $this$getDownloadTracks_u24lambda_u243\1.loadTracks(radio\1, (Continuation<? super Feed<Track>>)this);
                                        if (v4 == var3_3) {
                                            return var3_3;
                                        }
                                        ** GOTO lbl59
                                    }
                                    case 2: {
                                        $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0 = this.I$0;
                                        var9_14 = (Feed.Companion)this.L$5;
                                        radio\1 = (Radio)this.L$4;
                                        $this$getDownloadTracks_u24lambda_u243\1 = (RadioClient)this.L$3;
                                        $completion\1 = (Continuation)this.L$2;
                                        client = (RadioClient)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v4 = $result;
lbl59:
                                        // 2 sources

                                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadTracks_u24lambda_u243\1);
                                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)radio\1);
                                        this.L$5 = null;
                                        this.I$0 = $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0;
                                        this.label = 3;
                                        v5 = var9_14.loadAll((Feed)v4, this);
                                        if (v5 == var3_3) {
                                            return var3_3;
                                        }
                                        ** GOTO lbl80
                                    }
                                    case 3: {
                                        $i$a$-getAs-0E7RQCE-DownloadExtension$getDownloadTracks$tracks$3\1\36\0 = this.I$0;
                                        radio\1 = (Radio)this.L$4;
                                        $this$getDownloadTracks_u24lambda_u243\1 = (RadioClient)this.L$3;
                                        $completion\1 = (Continuation)this.L$2;
                                        client = (RadioClient)this.L$1;
                                        ResultKt.throwOnFailure((Object)$result);
                                        v5 = $result;
lbl80:
                                        // 2 sources

                                        return v5;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.L$0 = value2;
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(ExtensionClient p1, Continuation<? super List<? extends Track>> p2) {
                                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                            }
                        }, $continuation);
                        if (v2 == var23_7) {
                            return var23_7;
                        }
                        break block17;
                        {
                            case 3: {
                                $i$f$getAs-0E7RQCE\5\100 = $continuation.I$0;
                                $this$getAs_u2d0E7RQCE\5 = (Extension)$continuation.L$5;
                                this_\5 = (ExtensionUtils)$continuation.L$4;
                                ext = (MusicExtension)$continuation.L$3;
                                context = (EchoMediaItem)$continuation.L$2;
                                item = (EchoMediaItem)$continuation.L$1;
                                extensionId = (String)$continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = ((Result)$result).unbox-impl();
                                break block17;
                            }
                        }
                    }
                    throw new NoWhenBranchMatchedException();
                }
                $i$f$first\1\86 = v2;
                ResultKt.throwOnFailure((Object)$i$f$first\1\86);
                tracks = (List)$i$f$first\1\86;
                $this$mapIndexed\6 = tracks;
                $i$f$mapIndexed\6\106 = false;
                $this$getAs_u2d0E7RQCE\5 = $this$mapIndexed\6;
                destination\7 = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault((Iterable)$this$mapIndexed\6, (int)10));
                $i$f$mapIndexedTo\7\157 = false;
                index\7 = 0;
                for (T item\7 : $this$mapIndexedTo\7) {
                    if ((var16_23 = index\7++) < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    var17_24 = (Track)item\7;
                    var18_25 = var16_23;
                    var20_27 = destination\7;
                    $i$a$-mapIndexed-DownloadExtension$getDownloadTracks$2\8\160\0 = false;
                    var20_27.add(new DownloadContext(extensionId, (Track)track\8, Boxing.boxInt((int)index\8), item));
                }
                v0 = (List)destination\7;
                break block15;
            }
            v0 = CollectionsKt.emptyList();
        }
        return v0;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    private final Object test(MutableSharedFlow<Progress> progressFlow, String type, long crash, Continuation<? super File> $completion) {
        if (!($completion instanceof test.1)) ** GOTO lbl-1000
        var11_5 = $completion;
        if ((var11_5.label & -2147483648) != 0) {
            var11_5.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                long J$0;
                long J$1;
                /* synthetic */ Object result;
                final /* synthetic */ DownloadExtension this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return DownloadExtension.access$test(this.this$0, null, null, 0L, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var12_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = progressFlow;
                $continuation.L$1 = type;
                $continuation.J$0 = crash;
                $continuation.label = 1;
                v0 = progressFlow.emit((Object)new Progress(crash, 0L, 0L, 4, null), (Continuation)$continuation);
                if (v0 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl26
            }
            case 1: {
                crash = $continuation.J$0;
                type = (String)$continuation.L$1;
                progressFlow = (MutableSharedFlow)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl26:
                // 2 sources

                it = 0L;
lbl27:
                // 2 sources

                while (it < crash) {
                    $continuation.L$0 = progressFlow;
                    $continuation.L$1 = type;
                    $continuation.J$0 = crash;
                    $continuation.J$1 = it;
                    $continuation.label = 2;
                    v1 = DelayKt.delay((long)1L, (Continuation)$continuation);
                    if (v1 == var12_7) {
                        return var12_7;
                    }
                    ** GOTO lbl45
                }
                break;
            }
            case 2: {
                it = $continuation.J$1;
                crash = $continuation.J$0;
                type = (String)$continuation.L$1;
                progressFlow = (MutableSharedFlow)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl45:
                // 2 sources

                $continuation.L$0 = progressFlow;
                $continuation.L$1 = type;
                $continuation.J$0 = crash;
                $continuation.J$1 = it;
                $continuation.label = 3;
                v2 = progressFlow.emit((Object)new Progress(crash, it, 0L, 4, null), (Continuation)$continuation);
                if (v2 == var12_7) {
                    return var12_7;
                }
                ** GOTO lbl61
            }
            case 3: {
                it = $continuation.J$1;
                crash = $continuation.J$0;
                type = (String)$continuation.L$1;
                progressFlow = (MutableSharedFlow)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl61:
                // 2 sources

                var8_9 = it;
                it = var8_9 + 1L;
                ** GOTO lbl27
            }
        }
        if (Intrinsics.areEqual((Object)type, (Object)"Tagging")) {
            throw new Exception("Test exception in " + type);
        }
        v3 = this.context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getCacheDir(...)");
        return v3;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
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
    public List<String> getRequiredMusicExtensions() {
        return this.requiredMusicExtensions;
    }

    @Override
    public void setMusicExtensions(@NotNull List<MusicExtension> extensions2) {
        Intrinsics.checkNotNullParameter(extensions2, (String)"extensions");
        this.exts = extensions2;
    }

    @Override
    @Nullable
    public Object onExtensionSelected(@NotNull Continuation<? super Unit> $completion) {
        return DownloadClient.super.onExtensionSelected($completion);
    }

    @Override
    @Nullable
    public Object onInitialize(@NotNull Continuation<? super Unit> $completion) {
        return DownloadClient.super.onInitialize($completion);
    }

    public static final /* synthetic */ Object access$test(DownloadExtension $this, MutableSharedFlow progressFlow2, String type, long crash, Continuation $completion) {
        return $this.test((MutableSharedFlow<Progress>)progressFlow2, type, crash, (Continuation<? super File>)$completion);
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/DownloadExtension$Companion;", "", "<init>", "()V", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Metadata getMetadata() {
            return metadata;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

