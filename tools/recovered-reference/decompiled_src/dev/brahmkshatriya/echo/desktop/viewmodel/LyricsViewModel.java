/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.LyricsClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.Page;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Lyrics;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import dev.brahmkshatriya.echo.desktop.utils.DevanagariTransliterator;
import dev.brahmkshatriya.echo.desktop.viewmodel.LyricsUiState;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u0018J \u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u0018H\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00108F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0012R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00108F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00108F\u00a2\u0006\u0006\u001a\u0004\b$\u0010\u0012R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsViewModel;", "", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "settings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;Lkotlinx/coroutines/CoroutineScope;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_activeLyricIndex", "", "activeLyricIndex", "getActiveLyricIndex", "_lyricsLanguage", "", "lyricsLanguage", "getLyricsLanguage", "rawLyrics", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "rawSourceName", "currentTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "getCurrentTrack", "positionMs", "", "getPositionMs", "isPlaying", "", "currentLoadJob", "Lkotlinx/coroutines/Job;", "lastLoadedTrackId", "reload", "", "seekTo", "startTimeMs", "setLyricsLanguage", "lang", "applyLyrics", "loadedLyrics", "sourceExtName", "loadLyrics", "track", "desktopApp"})
@StabilityInferred(parameters=0)
@SourceDebugExtension(value={"SMAP\nLyricsViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LyricsViewModel.kt\ndev/brahmkshatriya/echo/desktop/viewmodel/LyricsViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,247:1\n1#2:248\n1#2:266\n774#3:249\n865#3,2:250\n1563#3:252\n1634#3,3:253\n1617#3,9:256\n1869#3:265\n1870#3:267\n1626#3:268\n774#3:269\n865#3,2:270\n1563#3:272\n1634#3,3:273\n*S KotlinDebug\n*F\n+ 1 LyricsViewModel.kt\ndev/brahmkshatriya/echo/desktop/viewmodel/LyricsViewModel\n*L\n147#1:266\n115#1:249\n115#1:250,2\n118#1:252\n118#1:253,3\n147#1:256,9\n147#1:265\n147#1:267\n147#1:268\n152#1:269\n152#1:270,2\n155#1:272\n155#1:273,3\n*E\n"})
public final class LyricsViewModel {
    @NotNull
    private final PlayerViewModel playerViewModel;
    @NotNull
    private final ExtensionManager extensionManager;
    @Nullable
    private final EchoSettings settings;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableStateFlow<LyricsUiState> _uiState;
    @NotNull
    private final StateFlow<LyricsUiState> uiState;
    @NotNull
    private final MutableStateFlow<Integer> _activeLyricIndex;
    @NotNull
    private final StateFlow<Integer> activeLyricIndex;
    @NotNull
    private final MutableStateFlow<String> _lyricsLanguage;
    @NotNull
    private final StateFlow<String> lyricsLanguage;
    @Nullable
    private Lyrics rawLyrics;
    @NotNull
    private String rawSourceName;
    @Nullable
    private Job currentLoadJob;
    @Nullable
    private String lastLoadedTrackId;
    public static final int $stable = 8;

    public LyricsViewModel(@NotNull PlayerViewModel playerViewModel, @NotNull ExtensionManager extensionManager, @Nullable EchoSettings settings, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)playerViewModel, (String)"playerViewModel");
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.playerViewModel = playerViewModel;
        this.extensionManager = extensionManager;
        this.settings = settings;
        this.scope = scope;
        this._uiState = StateFlowKt.MutableStateFlow((Object)LyricsUiState.Initial.INSTANCE);
        this.uiState = FlowKt.asStateFlow(this._uiState);
        this._activeLyricIndex = StateFlowKt.MutableStateFlow((Object)-1);
        this.activeLyricIndex = FlowKt.asStateFlow(this._activeLyricIndex);
        Object object = this.settings;
        if (object == null || (object = ((EchoSettings)object).getString("lyrics_language", "hindienglish")) == null) {
            object = "hindienglish";
        }
        this._lyricsLanguage = StateFlowKt.MutableStateFlow((Object)object);
        this.lyricsLanguage = FlowKt.asStateFlow(this._lyricsLanguage);
        this.rawSourceName = "Lyrics Service";
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ LyricsViewModel this$0;
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
                        Object object2 = FlowKt.collectLatest((Flow)((Flow)this.this$0.playerViewModel.getCurrentTrack()), (Function2)((Function2)new Function2<Track, Continuation<? super Unit>, Object>(this.this$0, null){
                            int label;
                            /* synthetic */ Object L$0;
                            final /* synthetic */ LyricsViewModel this$0;
                            {
                                this.this$0 = $receiver;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                Track track2 = (Track)this.L$0;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void track3;
                                        ResultKt.throwOnFailure((Object)$result);
                                        if (track3 == null) {
                                            this.this$0._uiState.setValue((Object)LyricsUiState.Initial.INSTANCE);
                                            this.this$0._activeLyricIndex.setValue((Object)Boxing.boxInt((int)-1));
                                            this.this$0.lastLoadedTrackId = null;
                                            return Unit.INSTANCE;
                                        }
                                        if (Intrinsics.areEqual((Object)track3.getId(), (Object)this.this$0.lastLoadedTrackId) && !(this.this$0._uiState.getValue() instanceof LyricsUiState.Initial)) {
                                            return Unit.INSTANCE;
                                        }
                                        this.this$0.lastLoadedTrackId = track3.getId();
                                        this.this$0.loadLyrics((Track)track3);
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

                            public final Object invoke(Track p1, Continuation<? super Unit> p2) {
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
            final /* synthetic */ LyricsViewModel this$0;
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
                        Object object2 = FlowKt.collectLatest((Flow)FlowKt.combine((Flow)((Flow)this.this$0.playerViewModel.getPositionMs()), (Flow)((Flow)this.this$0._uiState), (Function3)((Function3)new Function3<Long, LyricsUiState, Continuation<? super Integer>, Object>(null){
                            int label;
                            /* synthetic */ long J$0;
                            /* synthetic */ Object L$0;

                            /*
                             * Unable to fully structure code
                             */
                            public final Object invokeSuspend(Object $result) {
                                var2_2 = this.J$0;
                                var4_3 = (LyricsUiState)this.L$0;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        if (!(state instanceof LyricsUiState.Timed)) ** GOTO lbl21
                                        $this$indexOfLast$iv = ((LyricsUiState.Timed)state).getItems();
                                        $i$f$indexOfLast = false;
                                        iterator$iv = $this$indexOfLast$iv.listIterator($this$indexOfLast$iv.size());
                                        while (iterator$iv.hasPrevious()) {
                                            it = iterator$iv.previous();
                                            $i$a$-indexOfLast-LyricsViewModel$2$1$idx$1 = false;
                                            if (!(it.getStartTime() <= pos)) continue;
                                            v0 = iterator$iv.nextIndex();
                                            ** GOTO lbl19
                                        }
                                        v0 = -1;
lbl19:
                                        // 2 sources

                                        v1 = idx = v0;
                                        ** GOTO lbl22
lbl21:
                                        // 1 sources

                                        v1 = -1;
lbl22:
                                        // 2 sources

                                        return Boxing.boxInt((int)v1);
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Object invoke(long p1, LyricsUiState p2, Continuation<? super Integer> p3) {
                                var var5_4 = new /* invalid duplicate definition of identical inner class */;
                                var5_4.J$0 = p1;
                                var5_4.L$0 = p2;
                                return var5_4.invokeSuspend(Unit.INSTANCE);
                            }
                        })), (Function2)((Function2)new Function2<Integer, Continuation<? super Unit>, Object>(this.this$0, null){
                            int label;
                            /* synthetic */ int I$0;
                            final /* synthetic */ LyricsViewModel this$0;
                            {
                                this.this$0 = $receiver;
                                super(2, $completion);
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object $result) {
                                int n = this.I$0;
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        void idx;
                                        ResultKt.throwOnFailure((Object)$result);
                                        this.this$0._activeLyricIndex.setValue((Object)Boxing.boxInt((int)idx));
                                        return Unit.INSTANCE;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                                var3_3.I$0 = ((Number)value2).intValue();
                                return (Continuation)var3_3;
                            }

                            public final Object invoke(int p1, Continuation<? super Unit> p2) {
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
    }

    public /* synthetic */ LyricsViewModel(PlayerViewModel playerViewModel, ExtensionManager extensionManager, EchoSettings echoSettings, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            echoSettings = null;
        }
        if ((n & 8) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(playerViewModel, extensionManager, echoSettings, coroutineScope);
    }

    @NotNull
    public final StateFlow<LyricsUiState> getUiState() {
        return this.uiState;
    }

    @NotNull
    public final StateFlow<Integer> getActiveLyricIndex() {
        return this.activeLyricIndex;
    }

    @NotNull
    public final StateFlow<String> getLyricsLanguage() {
        return this.lyricsLanguage;
    }

    @NotNull
    public final StateFlow<Track> getCurrentTrack() {
        return this.playerViewModel.getCurrentTrack();
    }

    @NotNull
    public final StateFlow<Long> getPositionMs() {
        return this.playerViewModel.getPositionMs();
    }

    @NotNull
    public final StateFlow<Boolean> isPlaying() {
        return this.playerViewModel.isPlaying();
    }

    public final void reload() {
        block0: {
            Track track2 = (Track)this.playerViewModel.getCurrentTrack().getValue();
            if (track2 == null) break block0;
            Track it = track2;
            boolean bl = false;
            this.loadLyrics(it);
        }
    }

    public final void seekTo(long startTimeMs) {
        this.playerViewModel.seekTo(startTimeMs);
    }

    public final void setLyricsLanguage(@NotNull String lang) {
        Intrinsics.checkNotNullParameter((Object)lang, (String)"lang");
        this._lyricsLanguage.setValue((Object)lang);
        EchoSettings echoSettings = this.settings;
        if (echoSettings != null) {
            echoSettings.putString("lyrics_language", lang);
        }
        Lyrics raw = this.rawLyrics;
        if (raw != null) {
            this.applyLyrics(raw, this.rawSourceName, lang);
        }
    }

    /*
     * WARNING - void declaration
     */
    private final void applyLyrics(Lyrics loadedLyrics, String sourceExtName, String lang) {
        boolean shouldTransliterate = Intrinsics.areEqual((Object)lang, (Object)"hindienglish") || Intrinsics.areEqual((Object)lang, (Object)"english");
        Lyrics.Lyric lyric = loadedLyrics.getLyrics();
        if (lyric instanceof Lyrics.Timed) {
            void $this$filterTo$iv$iv;
            Iterable $this$filter$iv = ((Lyrics.Timed)lyric).getList();
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Iterable destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Lyrics.Item it = (Lyrics.Item)element$iv$iv;
                boolean bl = false;
                boolean bl2 = !StringsKt.isBlank((CharSequence)it.getText());
                if (!bl2) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List filtered = (List)destination$iv$iv;
            if (!((Collection)filtered).isEmpty()) {
                List list2;
                if (shouldTransliterate) {
                    void $this$mapTo$iv$iv;
                    Iterable $this$map$iv = filtered;
                    boolean $i$f$map = false;
                    destination$iv$iv = $this$map$iv;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                    boolean $i$f$mapTo = false;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                        void item2;
                        Lyrics.Item bl = (Lyrics.Item)item$iv$iv2;
                        Collection collection = destination$iv$iv2;
                        boolean bl3 = false;
                        String text = DevanagariTransliterator.INSTANCE.isDevanagari(item2.getText()) ? DevanagariTransliterator.INSTANCE.transliterate(item2.getText()) : item2.getText();
                        collection.add(Lyrics.Item.copy$default((Lyrics.Item)item2, text, 0L, 0L, 6, null));
                    }
                    list2 = (List)destination$iv$iv2;
                } else {
                    list2 = filtered;
                }
                List items2 = list2;
                this._uiState.setValue((Object)new LyricsUiState.Timed(items2, sourceExtName));
            } else {
                this._uiState.setValue((Object)new LyricsUiState.Empty("Lyrics content is empty."));
            }
        } else if (lyric instanceof Lyrics.Simple) {
            if (!StringsKt.isBlank((CharSequence)((Lyrics.Simple)lyric).getText())) {
                String text = shouldTransliterate && DevanagariTransliterator.INSTANCE.isDevanagari(((Lyrics.Simple)lyric).getText()) ? DevanagariTransliterator.INSTANCE.transliterate(((Lyrics.Simple)lyric).getText()) : ((Lyrics.Simple)lyric).getText();
                this._uiState.setValue((Object)new LyricsUiState.Simple(text, sourceExtName));
            } else {
                this._uiState.setValue((Object)new LyricsUiState.Empty("Lyrics content is empty."));
            }
        } else if (lyric instanceof Lyrics.WordByWord) {
            List list3;
            void $this$filterTo$iv$iv;
            void $this$filter$iv;
            void $this$mapNotNullTo$iv$iv;
            Iterable $this$mapNotNull$iv = ((Lyrics.WordByWord)lyric).getList();
            boolean $i$f$mapNotNull = false;
            Iterable $i$f$map = $this$mapNotNull$iv;
            Iterable destination$iv$iv = new ArrayList();
            boolean $i$f$mapNotNullTo = false;
            Iterator $this$forEach$iv$iv$iv = $this$mapNotNullTo$iv$iv;
            boolean $i$f$forEach = false;
            Iterator item$iv$iv2 = $this$forEach$iv$iv$iv.iterator();
            while (item$iv$iv2.hasNext()) {
                Lyrics.Item item3;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = item$iv$iv2.next();
                boolean bl = false;
                List wordList = (List)element$iv$iv;
                boolean bl4 = false;
                String rawText = CollectionsKt.joinToString$default((Iterable)wordList, (CharSequence)" ", null, null, (int)0, null, LyricsViewModel::applyLyrics$lambda$4$lambda$3, (int)30, null);
                Lyrics.Item item4 = (Lyrics.Item)CollectionsKt.firstOrNull((List)wordList);
                if (item4 == null) {
                    item3 = null;
                } else {
                    long start2 = item4.getStartTime();
                    Lyrics.Item item5 = (Lyrics.Item)CollectionsKt.lastOrNull((List)wordList);
                    long end = item5 != null ? item5.getEndTime() : start2 + 2000L;
                    item3 = new Lyrics.Item(rawText, start2, end);
                }
                if (item3 == null) continue;
                Lyrics.Item it$iv$iv = item3;
                boolean bl5 = false;
                destination$iv$iv.add(it$iv$iv);
            }
            $this$mapNotNull$iv = (List)destination$iv$iv;
            boolean $i$f$filter = false;
            $this$mapNotNullTo$iv$iv = $this$filter$iv;
            destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                Lyrics.Item it = (Lyrics.Item)element$iv$iv;
                boolean bl = false;
                boolean bl6 = !StringsKt.isBlank((CharSequence)it.getText());
                if (!bl6) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List flattened = (List)destination$iv$iv;
            if (shouldTransliterate) {
                void $this$mapTo$iv$iv;
                Iterable $this$map$iv = flattened;
                boolean $i$f$map2 = false;
                destination$iv$iv = $this$map$iv;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
                boolean $i$f$mapTo = false;
                for (Iterator item$iv$iv2 : $this$mapTo$iv$iv) {
                    void item6;
                    Lyrics.Item bl = (Lyrics.Item)((Object)item$iv$iv2);
                    Collection collection = destination$iv$iv3;
                    boolean bl7 = false;
                    String text = DevanagariTransliterator.INSTANCE.isDevanagari(item6.getText()) ? DevanagariTransliterator.INSTANCE.transliterate(item6.getText()) : item6.getText();
                    collection.add(Lyrics.Item.copy$default((Lyrics.Item)item6, text, 0L, 0L, 6, null));
                }
                list3 = (List)destination$iv$iv3;
            } else {
                list3 = flattened;
            }
            List items3 = list3;
            this._uiState.setValue((Object)new LyricsUiState.Timed(items3, sourceExtName));
        } else if (lyric == null) {
            this._uiState.setValue((Object)new LyricsUiState.Empty("No lyrics available for this track."));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void loadLyrics(Track track2) {
        Job job2 = this.currentLoadJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
        }
        this._uiState.setValue((Object)LyricsUiState.Loading.INSTANCE);
        this._activeLyricIndex.setValue((Object)-1);
        this.currentLoadJob = BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, track2, null){
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int I$0;
            int label;
            final /* synthetic */ LyricsViewModel this$0;
            final /* synthetic */ Track $track;
            {
                this.this$0 = $receiver;
                this.$track = $track;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object $result) {
                var13_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        $this$filter$iv = (Iterable)LyricsViewModel.access$getExtensionManager$p(this.this$0).getLyrics().getValue();
                        $i$f$filter = false;
                        var5_8 = $this$filter$iv;
                        destination$iv$iv /* !! */  = new ArrayList<E>();
                        $i$f$filterTo = false;
                        for (Object element$iv$iv : $this$filterTo$iv$iv) {
                            it = (LyricsExtension)element$iv$iv;
                            $i$a$-filter-LyricsViewModel$loadLyrics$1$lyricsExts$1 = false;
                            if (!it.isEnabled()) continue;
                            destination$iv$iv /* !! */ .add(element$iv$iv);
                        }
                        lyricsExts = (List)destination$iv$iv /* !! */ ;
                        $this$filter$iv = (Iterable)LyricsViewModel.access$getExtensionManager$p(this.this$0).getMusic().getValue();
                        $i$f$filter = false;
                        destination$iv$iv /* !! */  = $this$filter$iv;
                        destination$iv$iv = new ArrayList<E>();
                        $i$f$filterTo = false;
                        for (E element$iv$iv : $this$filterTo$iv$iv) {
                            it = (MusicExtension)element$iv$iv;
                            $i$a$-filter-LyricsViewModel$loadLyrics$1$musicExts$1 = false;
                            if (!it.isEnabled()) continue;
                            destination$iv$iv.add(element$iv$iv);
                        }
                        musicExts = (List)destination$iv$iv;
                        loadedLyrics = new Ref.ObjectRef();
                        sourceExtName = new Ref.ObjectRef();
                        sourceExtName.element = "Lyrics Service";
                        var6_12 = lyricsExts.iterator();
lbl37:
                        // 3 sources

                        while (var6_12.hasNext()) {
                            ext /* !! */  = (LyricsExtension)var6_12.next();
                            $i$f$filterTo = ExtensionUtils.INSTANCE;
                            element$iv$iv = ext /* !! */ ;
                            var10_22 = this.$track;
                            $i$f$getAs-0E7RQCE = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)lyricsExts);
                            this.L$1 = musicExts;
                            this.L$2 = loadedLyrics;
                            this.L$3 = sourceExtName;
                            this.L$4 = var6_12;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)ext /* !! */ );
                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE$iv);
                            this.I$0 = $i$f$getAs-0E7RQCE;
                            this.label = 1;
                            v0 = v1 = this_$iv.get-0E7RQCE($this$getAs_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null, ext /* !! */ , var10_22, loadedLyrics, sourceExtName){
                                Object L$1;
                                int label;
                                private /* synthetic */ Object L$0;
                                final /* synthetic */ LyricsExtension $ext$inlined;
                                final /* synthetic */ Track $track$inlined;
                                final /* synthetic */ Ref.ObjectRef $loadedLyrics$inlined;
                                final /* synthetic */ Ref.ObjectRef $sourceExtName$inlined;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                Object L$5;
                                Object L$6;
                                Object L$7;
                                Object L$8;
                                int I$0;
                                {
                                    this.$ext$inlined = lyricsExtension;
                                    this.$track$inlined = track2;
                                    this.$loadedLyrics$inlined = objectRef;
                                    this.$sourceExtName$inlined = objectRef2;
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
                                            if (!(v0 instanceof LyricsClient)) {
                                                v0 = null;
                                            }
                                            v1 = v0;
                                            if (v1 == null) {
                                                v2 = Reflection.getOrCreateKotlinClass(LyricsClient.class).getSimpleName();
                                                if (v2 == null) {
                                                    v2 = "Unknown";
                                                }
                                                throw new ClientException.NotSupported(v2);
                                            }
                                            client = v1;
                                            var5_6 = (Continuation)this;
                                            $this$invokeSuspend_u24lambda_u242 = client;
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u242;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1;
                                            this.label = 1;
                                            v3 = $this$invokeSuspend_u24lambda_u242.searchTrackLyrics(this.$ext$inlined.getId(), this.$track$inlined, (Continuation<? super Feed<Lyrics>>)this);
                                            if (v3 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl36
                                        }
                                        case 1: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1 = this.I$0;
                                            $this$invokeSuspend_u24lambda_u242 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v3 = $result;
lbl36:
                                            // 2 sources

                                            feed = (Feed)v3;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u242;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1;
                                            this.label = 2;
                                            v4 = feed.getGetPagedData().invoke(null, (Object)this);
                                            if (v4 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl56
                                        }
                                        case 2: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1 = this.I$0;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u242 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v4 = $result;
lbl56:
                                            // 2 sources

                                            paged = ((Feed.Data)v4).getPagedData();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u242;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(paged);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1;
                                            this.label = 3;
                                            v5 = paged.loadPage((String)null, this);
                                            if (v5 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl78
                                        }
                                        case 3: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1 = this.I$0;
                                            paged = (PagedData<T>)this.L$5;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u242 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v5 = $result;
lbl78:
                                            // 2 sources

                                            if ((first = (Lyrics)CollectionsKt.firstOrNull((page = (Page)v5).getData())) == null) ** GOTO lbl109
                                            var12_20 = this.$loadedLyrics$inlined;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u242);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(paged);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)page);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)first);
                                            this.L$8 = var12_20;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1;
                                            this.label = 4;
                                            v6 = $this$invokeSuspend_u24lambda_u242.loadLyrics(first, (Continuation<? super Lyrics>)this);
                                            if (v6 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl107
                                        }
                                        case 4: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$1 = this.I$0;
                                            var12_20 = (Ref.ObjectRef)this.L$8;
                                            first = (Lyrics)this.L$7;
                                            page = (Page)this.L$6;
                                            paged = (PagedData)this.L$5;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u242 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v6 = $result;
lbl107:
                                            // 2 sources

                                            var12_20.element = v6;
                                            this.$sourceExtName$inlined.element = this.$ext$inlined.getMetadata().getName();
lbl109:
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
                            }, (Continuation)this);
                        }
                        ** GOTO lbl81
                        {
                            if (v0 == var13_2) {
                                return var13_2;
                            }
                            ** GOTO lbl77
                            break;
                        }
                    }
                    case 1: {
                        $i$f$getAs-0E7RQCE = this.I$0;
                        $this$getAs_u2d0E7RQCE$iv = (Extension)this.L$7;
                        this_$iv = (ExtensionUtils)this.L$6;
                        ext /* !! */  = (LyricsExtension)this.L$5;
                        var6_12 = (Iterator<E>)this.L$4;
                        sourceExtName = (Ref.ObjectRef)this.L$3;
                        loadedLyrics = (Ref.ObjectRef)this.L$2;
                        musicExts = (List)this.L$1;
                        lyricsExts = (List)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = ((Result)$result).unbox-impl();
lbl77:
                        // 2 sources

                        if (loadedLyrics.element == null) ** GOTO lbl37
                        {
                            catch (Throwable this_$iv) {
                                ** GOTO lbl37
                            }
                        }
lbl81:
                        // 2 sources

                        if (loadedLyrics.element != null) ** GOTO lbl127
                        var6_12 = musicExts.iterator();
lbl83:
                        // 3 sources

                        while (var6_12.hasNext()) {
                            ext /* !! */  = (MusicExtension)var6_12.next();
                            this_$iv = ExtensionUtils.INSTANCE;
                            $this$getAs_u2d0E7RQCE$iv = ext /* !! */ ;
                            var10_22 = this.$track;
                            $i$f$getAs-0E7RQCE = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)lyricsExts);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)musicExts);
                            this.L$2 = loadedLyrics;
                            this.L$3 = sourceExtName;
                            this.L$4 = var6_12;
                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)ext /* !! */ );
                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE$iv);
                            this.I$0 = $i$f$getAs-0E7RQCE;
                            this.label = 2;
                            v2 = v3 = this_$iv.get-0E7RQCE($this$getAs_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null, (MusicExtension)ext /* !! */ , var10_22, loadedLyrics, sourceExtName){
                                Object L$1;
                                int label;
                                private /* synthetic */ Object L$0;
                                final /* synthetic */ MusicExtension $ext$inlined;
                                final /* synthetic */ Track $track$inlined;
                                final /* synthetic */ Ref.ObjectRef $loadedLyrics$inlined;
                                final /* synthetic */ Ref.ObjectRef $sourceExtName$inlined;
                                Object L$2;
                                Object L$3;
                                Object L$4;
                                Object L$5;
                                Object L$6;
                                Object L$7;
                                Object L$8;
                                int I$0;
                                {
                                    this.$ext$inlined = musicExtension;
                                    this.$track$inlined = track2;
                                    this.$loadedLyrics$inlined = objectRef;
                                    this.$sourceExtName$inlined = objectRef2;
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
                                            if (!(v0 instanceof LyricsClient)) {
                                                v0 = null;
                                            }
                                            v1 = v0;
                                            if (v1 == null) {
                                                v2 = Reflection.getOrCreateKotlinClass(LyricsClient.class).getSimpleName();
                                                if (v2 == null) {
                                                    v2 = "Unknown";
                                                }
                                                throw new ClientException.NotSupported(v2);
                                            }
                                            client = v1;
                                            var5_6 = (Continuation)this;
                                            $this$invokeSuspend_u24lambda_u243 = client;
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u243;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2;
                                            this.label = 1;
                                            v3 = $this$invokeSuspend_u24lambda_u243.searchTrackLyrics(this.$ext$inlined.getId(), this.$track$inlined, (Continuation<? super Feed<Lyrics>>)this);
                                            if (v3 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl36
                                        }
                                        case 1: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2 = this.I$0;
                                            $this$invokeSuspend_u24lambda_u243 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v3 = $result;
lbl36:
                                            // 2 sources

                                            feed = (Feed)v3;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u243;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2;
                                            this.label = 2;
                                            v4 = feed.getGetPagedData().invoke(null, (Object)this);
                                            if (v4 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl56
                                        }
                                        case 2: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2 = this.I$0;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u243 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v4 = $result;
lbl56:
                                            // 2 sources

                                            paged = ((Feed.Data)v4).getPagedData();
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u243;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(paged);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2;
                                            this.label = 3;
                                            v5 = paged.loadPage((String)null, this);
                                            if (v5 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl78
                                        }
                                        case 3: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2 = this.I$0;
                                            paged = (PagedData<T>)this.L$5;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u243 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v5 = $result;
lbl78:
                                            // 2 sources

                                            if ((first = (Lyrics)CollectionsKt.firstOrNull((page = (Page)v5).getData())) == null) ** GOTO lbl109
                                            var12_20 = this.$loadedLyrics$inlined;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u243);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)feed);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(paged);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)page);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable((Object)first);
                                            this.L$8 = var12_20;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2;
                                            this.label = 4;
                                            v6 = $this$invokeSuspend_u24lambda_u243.loadLyrics(first, (Continuation<? super Lyrics>)this);
                                            if (v6 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl107
                                        }
                                        case 4: {
                                            $i$a$-getAs-0E7RQCE-LyricsViewModel$loadLyrics$1$2 = this.I$0;
                                            var12_20 = (Ref.ObjectRef)this.L$8;
                                            first = (Lyrics)this.L$7;
                                            page = (Page)this.L$6;
                                            paged = (PagedData)this.L$5;
                                            feed = (Feed)this.L$4;
                                            $this$invokeSuspend_u24lambda_u243 = (LyricsClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (LyricsClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v6 = $result;
lbl107:
                                            // 2 sources

                                            var12_20.element = v6;
                                            this.$sourceExtName$inlined.element = this.$ext$inlined.getMetadata().getName();
lbl109:
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
                            }, (Continuation)this);
                        }
                        ** GOTO lbl127
                        {
                            if (v2 == var13_2) {
                                return var13_2;
                            }
                            ** GOTO lbl123
                            break;
                        }
                    }
                    case 2: {
                        $i$f$getAs-0E7RQCE = this.I$0;
                        $this$getAs_u2d0E7RQCE$iv = (Extension)this.L$7;
                        this_$iv = (ExtensionUtils)this.L$6;
                        ext /* !! */  = (MusicExtension)this.L$5;
                        var6_12 = (Iterator)this.L$4;
                        sourceExtName = (Ref.ObjectRef)this.L$3;
                        loadedLyrics = (Ref.ObjectRef)this.L$2;
                        musicExts = (List)this.L$1;
                        lyricsExts = (List)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = ((Result)$result).unbox-impl();
lbl123:
                        // 2 sources

                        if (loadedLyrics.element == null) ** GOTO lbl83
                        {
                            catch (Throwable var8_20) {
                                ** GOTO lbl83
                            }
                        }
lbl127:
                        // 3 sources

                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)lyricsExts);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)musicExts);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)loadedLyrics);
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)sourceExtName);
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.L$7 = null;
                        this.label = 3;
                        v4 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getMain()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Ref.ObjectRef<Lyrics>)loadedLyrics, this.this$0, (Ref.ObjectRef<String>)sourceExtName, null){
                            int label;
                            final /* synthetic */ Ref.ObjectRef<Lyrics> $loadedLyrics;
                            final /* synthetic */ LyricsViewModel this$0;
                            final /* synthetic */ Ref.ObjectRef<String> $sourceExtName;
                            {
                                this.$loadedLyrics = $loadedLyrics;
                                this.this$0 = $receiver;
                                this.$sourceExtName = $sourceExtName;
                                super(2, $completion);
                            }

                            public final Object invokeSuspend(Object $result) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0: {
                                        ResultKt.throwOnFailure((Object)$result);
                                        if (this.$loadedLyrics.element == null) {
                                            LyricsViewModel.access$setRawLyrics$p(this.this$0, null);
                                            LyricsViewModel.access$get_uiState$p(this.this$0).setValue((Object)new LyricsUiState.Empty("No synchronized lyrics found for this song."));
                                            return Unit.INSTANCE;
                                        }
                                        LyricsViewModel.access$setRawLyrics$p(this.this$0, (Lyrics)this.$loadedLyrics.element);
                                        LyricsViewModel.access$setRawSourceName$p(this.this$0, (String)this.$sourceExtName.element);
                                        Object object = this.$loadedLyrics.element;
                                        Intrinsics.checkNotNull((Object)object);
                                        LyricsViewModel.access$applyLyrics(this.this$0, (Lyrics)object, (String)this.$sourceExtName.element, (String)LyricsViewModel.access$get_lyricsLanguage$p(this.this$0).getValue());
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
                        ** if (v4 != var13_2) goto lbl139
lbl138:
                        // 1 sources

                        return var13_2;
lbl139:
                        // 1 sources

                        ** GOTO lbl170
                    }
                    case 3: {
                        sourceExtName = (Ref.ObjectRef)this.L$3;
                        loadedLyrics = (Ref.ObjectRef)this.L$2;
                        musicExts = (List)this.L$1;
                        lyricsExts = (List)this.L$0;
                        try {
                            ResultKt.throwOnFailure((Object)$result);
                            v4 = $result;
                            ** GOTO lbl170
                        }
                        catch (Throwable e) {
                            if (e instanceof CancellationException) {
                                return Unit.INSTANCE;
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)e);
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.L$7 = null;
                            this.label = 4;
                            v5 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getMain()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.this$0, e, null){
                                int label;
                                final /* synthetic */ LyricsViewModel this$0;
                                final /* synthetic */ Throwable $e;
                                {
                                    this.this$0 = $receiver;
                                    this.$e = $e;
                                    super(2, $completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)$result);
                                            MutableStateFlow mutableStateFlow = LyricsViewModel.access$get_uiState$p(this.this$0);
                                            String string2 = this.$e.getMessage();
                                            if (string2 == null) {
                                                string2 = "Unknown error";
                                            }
                                            mutableStateFlow.setValue((Object)new LyricsUiState.Empty("Unable to load lyrics: " + string2));
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
                            if (v5 == var13_2) {
                                return var13_2;
                            }
                            ** GOTO lbl170
                        }
                    }
                    case 4: {
                        e = (Throwable)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v5 = $result;
lbl170:
                        // 4 sources

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

    private static final CharSequence applyLyrics$lambda$4$lambda$3(Lyrics.Item it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getText();
    }

    public static final /* synthetic */ ExtensionManager access$getExtensionManager$p(LyricsViewModel $this) {
        return $this.extensionManager;
    }

    public static final /* synthetic */ void access$setRawLyrics$p(LyricsViewModel $this, Lyrics lyrics) {
        $this.rawLyrics = lyrics;
    }

    public static final /* synthetic */ void access$setRawSourceName$p(LyricsViewModel $this, String string2) {
        $this.rawSourceName = string2;
    }

    public static final /* synthetic */ void access$applyLyrics(LyricsViewModel $this, Lyrics loadedLyrics, String sourceExtName, String lang) {
        $this.applyLyrics(loadedLyrics, sourceExtName, lang);
    }

    public static final /* synthetic */ MutableStateFlow access$get_lyricsLanguage$p(LyricsViewModel $this) {
        return $this._lyricsLanguage;
    }
}

