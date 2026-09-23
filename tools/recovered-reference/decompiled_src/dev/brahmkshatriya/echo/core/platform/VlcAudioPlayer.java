/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.NativeLibrary
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
 *  uk.co.caprica.vlcj.factory.discovery.strategy.NativeDiscoveryStrategy
 *  uk.co.caprica.vlcj.player.base.Equalizer
 *  uk.co.caprica.vlcj.player.base.MediaPlayer
 *  uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
 *  uk.co.caprica.vlcj.player.base.MediaPlayerEventListener
 *  uk.co.caprica.vlcj.player.component.AudioPlayerComponent
 */
package dev.brahmkshatriya.echo.core.platform;

import com.sun.jna.NativeLibrary;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.platform.AudioPlayer;
import dev.brahmkshatriya.echo.core.platform.PlayerState;
import dev.brahmkshatriya.echo.core.platform.RepeatMode;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.factory.discovery.strategy.NativeDiscoveryStrategy;
import uk.co.caprica.vlcj.player.base.Equalizer;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.component.AudioPlayerComponent;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0010H\u0016J\u001e\u0010C\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00102\u0006\u0010D\u001a\u00020EH\u0096@\u00a2\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020AH\u0016J\b\u0010H\u001a\u00020AH\u0016J\u0010\u0010I\u001a\u00020A2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010J\u001a\u00020AH\u0016J\b\u0010K\u001a\u00020AH\u0016J\b\u0010L\u001a\u00020AH\u0016J\u001e\u0010M\u001a\u00020A2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010O\u001a\u00020-H\u0016J\u001e\u0010P\u001a\u00020A2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010Q\u001a\u00020-H\u0016J\u0010\u0010R\u001a\u00020A2\u0006\u0010Q\u001a\u00020-H\u0016J\u0018\u0010S\u001a\u00020A2\u0006\u0010T\u001a\u00020-2\u0006\u0010U\u001a\u00020-H\u0016J\u0010\u0010V\u001a\u00020A2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010W\u001a\u00020A2\u0006\u0010X\u001a\u00020&H\u0016J\u0010\u0010Y\u001a\u00020A2\u0006\u0010Z\u001a\u00020\u001fH\u0016J\u0010\u0010[\u001a\u00020A2\u0006\u0010\\\u001a\u00020\"H\u0016J\u0018\u0010]\u001a\u00020A2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\"H\u0016J\u0010\u0010a\u001a\u00020A2\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u00020AH\u0016J\b\u0010e\u001a\u00020AH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00180\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000eR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000eR\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001f0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000eR\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00102\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?\u00a8\u0006f"}, d2={"Ldev/brahmkshatriya/echo/core/platform/VlcAudioPlayer;", "Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;", "settings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "<init>", "(Ldev/brahmkshatriya/echo/core/settings/EchoSettings;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_currentTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "currentTrack", "getCurrentTrack", "_queue", "", "queue", "getQueue", "_positionMs", "", "positionMs", "getPositionMs", "_durationMs", "durationMs", "getDurationMs", "_isPlaying", "", "isPlaying", "_volume", "", "volume", "getVolume", "_repeatMode", "Ldev/brahmkshatriya/echo/core/platform/RepeatMode;", "repeatMode", "getRepeatMode", "_shuffleEnabled", "shuffleEnabled", "getShuffleEnabled", "queueIndex", "", "originalQueue", "currentPlaybackRate", "currentEqualizer", "Luk/co/caprica/vlcj/player/base/Equalizer;", "vlcAvailable", "getVlcAvailable", "()Z", "vlcAvailable$delegate", "Lkotlin/Lazy;", "audioComponent", "Luk/co/caprica/vlcj/player/component/AudioPlayerComponent;", "getAudioComponent", "()Luk/co/caprica/vlcj/player/component/AudioPlayerComponent;", "audioComponent$delegate", "player", "Luk/co/caprica/vlcj/player/base/MediaPlayer;", "getPlayer", "()Luk/co/caprica/vlcj/player/base/MediaPlayer;", "prepareTrack", "", "track", "play", "media", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "(Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "resume", "seekTo", "stop", "skipNext", "skipPrevious", "setQueue", "tracks", "startIndex", "addToQueue", "index", "removeFromQueue", "moveInQueue", "from", "to", "setVolume", "setRepeatMode", "mode", "setShuffle", "enabled", "setPlaybackRate", "rate", "setEqualizer", "bands", "", "preamp", "setEqualizerPreset", "preset", "", "disableEqualizer", "release", "core"})
@SourceDebugExtension(value={"SMAP\nVlcAudioPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VlcAudioPlayer.kt\ndev/brahmkshatriya/echo/core/platform/VlcAudioPlayer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,424:1\n1#2:425\n1999#3,14:426\n774#3:447\n865#3,2:448\n37#4:440\n36#4,3:441\n13587#5,3:444\n*S KotlinDebug\n*F\n+ 1 VlcAudioPlayer.kt\ndev/brahmkshatriya/echo/core/platform/VlcAudioPlayer\n*L\n205#1:426,14\n72#1:447\n72#1:448,2\n252#1:440\n252#1:441,3\n393#1:444,3\n*E\n"})
public final class VlcAudioPlayer
implements AudioPlayer {
    @Nullable
    private final EchoSettings settings;
    @NotNull
    private final CoroutineScope scope;
    @NotNull
    private final MutableStateFlow<PlayerState> _state;
    @NotNull
    private final StateFlow<PlayerState> state;
    @NotNull
    private final MutableStateFlow<Track> _currentTrack;
    @NotNull
    private final StateFlow<Track> currentTrack;
    @NotNull
    private final MutableStateFlow<List<Track>> _queue;
    @NotNull
    private final StateFlow<List<Track>> queue;
    @NotNull
    private final MutableStateFlow<Long> _positionMs;
    @NotNull
    private final StateFlow<Long> positionMs;
    @NotNull
    private final MutableStateFlow<Long> _durationMs;
    @NotNull
    private final StateFlow<Long> durationMs;
    @NotNull
    private final MutableStateFlow<Boolean> _isPlaying;
    @NotNull
    private final StateFlow<Boolean> isPlaying;
    @NotNull
    private final MutableStateFlow<Float> _volume;
    @NotNull
    private final StateFlow<Float> volume;
    @NotNull
    private final MutableStateFlow<RepeatMode> _repeatMode;
    @NotNull
    private final StateFlow<RepeatMode> repeatMode;
    @NotNull
    private final MutableStateFlow<Boolean> _shuffleEnabled;
    @NotNull
    private final StateFlow<Boolean> shuffleEnabled;
    private int queueIndex;
    @NotNull
    private List<Track> originalQueue;
    private float currentPlaybackRate;
    @Nullable
    private Equalizer currentEqualizer;
    @NotNull
    private final Lazy vlcAvailable$delegate;
    @NotNull
    private final Lazy audioComponent$delegate;

    public VlcAudioPlayer(@Nullable EchoSettings settings) {
        this.settings = settings;
        this.scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getIO().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        this._state = StateFlowKt.MutableStateFlow((Object)PlayerState.Companion.getIDLE());
        this.state = FlowKt.asStateFlow(this._state);
        this._currentTrack = StateFlowKt.MutableStateFlow(null);
        this.currentTrack = FlowKt.asStateFlow(this._currentTrack);
        this._queue = StateFlowKt.MutableStateFlow((Object)CollectionsKt.emptyList());
        this.queue = FlowKt.asStateFlow(this._queue);
        this._positionMs = StateFlowKt.MutableStateFlow((Object)0L);
        this.positionMs = FlowKt.asStateFlow(this._positionMs);
        this._durationMs = StateFlowKt.MutableStateFlow((Object)0L);
        this.durationMs = FlowKt.asStateFlow(this._durationMs);
        this._isPlaying = StateFlowKt.MutableStateFlow((Object)false);
        this.isPlaying = FlowKt.asStateFlow(this._isPlaying);
        this._volume = StateFlowKt.MutableStateFlow((Object)Float.valueOf(1.0f));
        this.volume = FlowKt.asStateFlow(this._volume);
        this._repeatMode = StateFlowKt.MutableStateFlow((Object)((Object)RepeatMode.NONE));
        this.repeatMode = FlowKt.asStateFlow(this._repeatMode);
        this._shuffleEnabled = StateFlowKt.MutableStateFlow((Object)false);
        this.shuffleEnabled = FlowKt.asStateFlow(this._shuffleEnabled);
        this.originalQueue = CollectionsKt.emptyList();
        this.currentPlaybackRate = 1.0f;
        this.vlcAvailable$delegate = LazyKt.lazy(VlcAudioPlayer::vlcAvailable_delegate$lambda$2);
        this.audioComponent$delegate = LazyKt.lazy(() -> VlcAudioPlayer.audioComponent_delegate$lambda$3(this));
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ VlcAudioPlayer this$0;
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
                        v0 = DelayKt.delay((long)100L, (Continuation)((Continuation)this));
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

                        if ((v1 = VlcAudioPlayer.access$getPlayer(this.this$0)) != null && (v1 = v1.events()) != null) {
                            v1.addMediaPlayerEventListener((MediaPlayerEventListener)new MediaPlayerEventAdapter(){

                                public void playing(MediaPlayer mp) {
                                    block7: {
                                        Object object;
                                        Object object2;
                                        VlcAudioPlayer vlcAudioPlayer;
                                        Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                        Track track2 = (Track)this$0._currentTrack.getValue();
                                        System.out.println((Object)("[VlcAudioPlayer] Event: PLAYING for " + (track2 != null ? track2.getTitle() : null)));
                                        this$0._state.setValue((Object)PlayerState.Companion.getPLAYING());
                                        this$0._isPlaying.setValue((Object)true);
                                        if (!(this$0.currentPlaybackRate == 1.0f)) {
                                            1 var2_2 = this;
                                            vlcAudioPlayer = this$0;
                                            try {
                                                1 $this$playing_u24lambda_u240 = var2_2;
                                                boolean bl = false;
                                                MediaPlayer mediaPlayer = vlcAudioPlayer.getPlayer();
                                                object2 = Result.constructor-impl(mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null ? Boolean.valueOf(mediaPlayer.setRate(vlcAudioPlayer.currentPlaybackRate)) : null);
                                            }
                                            catch (Throwable bl) {
                                                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
                                            }
                                        }
                                        Equalizer equalizer = this$0.currentEqualizer;
                                        if (equalizer == null) break block7;
                                        vlcAudioPlayer = equalizer;
                                        object2 = this$0;
                                        VlcAudioPlayer eq = vlcAudioPlayer;
                                        boolean bl = false;
                                        1 var7_9 = this;
                                        try {
                                            Unit unit;
                                            1 $this$playing_u24lambda_u242_u24lambda_u241 = var7_9;
                                            boolean bl2 = false;
                                            MediaPlayer mediaPlayer = ((VlcAudioPlayer)object2).getPlayer();
                                            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.audio()) != null) {
                                                mediaPlayer.setEqualizer((Equalizer)eq);
                                                unit = Unit.INSTANCE;
                                            } else {
                                                unit = null;
                                            }
                                            object = Result.constructor-impl(unit);
                                        }
                                        catch (Throwable throwable) {
                                            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                                        }
                                        Result.box-impl((Object)object);
                                    }
                                }

                                public void paused(MediaPlayer mp) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    System.out.println((Object)"[VlcAudioPlayer] Event: PAUSED");
                                    this$0._state.setValue((Object)PlayerState.Companion.getPAUSED());
                                    this$0._isPlaying.setValue((Object)false);
                                }

                                public void stopped(MediaPlayer mp) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    System.out.println((Object)"[VlcAudioPlayer] Event: STOPPED");
                                    this$0._state.setValue((Object)PlayerState.Companion.getIDLE());
                                    this$0._isPlaying.setValue((Object)false);
                                }

                                public void finished(MediaPlayer mp) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    Track track2 = (Track)this$0._currentTrack.getValue();
                                    System.out.println((Object)("[VlcAudioPlayer] Event: FINISHED for " + (track2 != null ? track2.getTitle() : null)));
                                    this$0._state.setValue((Object)PlayerState.Companion.getENDED());
                                    this$0._isPlaying.setValue((Object)false);
                                }

                                public void buffering(MediaPlayer mp, float newCache) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    if (newCache < 100.0f) {
                                        this$0._state.setValue((Object)PlayerState.Companion.getBUFFERING());
                                    } else if (Intrinsics.areEqual((Object)this$0._state.getValue(), (Object)PlayerState.Companion.getBUFFERING())) {
                                        this$0._state.setValue((Object)PlayerState.Companion.getPLAYING());
                                    }
                                }

                                public void error(MediaPlayer mp) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    Track track2 = (Track)this$0._currentTrack.getValue();
                                    System.err.println("[VlcAudioPlayer] Event: ERROR playing " + (track2 != null ? track2.getTitle() : null));
                                    this$0._state.setValue((Object)PlayerState.Companion.error(new Exception("VLC playback error")));
                                    this$0._isPlaying.setValue((Object)false);
                                }

                                public void timeChanged(MediaPlayer mp, long newTime) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    this$0._positionMs.setValue((Object)newTime);
                                }

                                public void lengthChanged(MediaPlayer mp, long newLength) {
                                    Intrinsics.checkNotNullParameter((Object)mp, (String)"mp");
                                    this$0._durationMs.setValue((Object)newLength);
                                }
                            });
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
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ VlcAudioPlayer this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (CoroutineScope)this.L$0;
                var12_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
lbl7:
                        // 2 sources

                        while (true) {
                            this.L$0 = $this$launch;
                            this.label = 1;
                            v0 = DelayKt.delay((long)50L, (Continuation)((Continuation)this));
                            if (v0 == var12_3) {
                                return var12_3;
                            }
                            ** GOTO lbl17
                            break;
                        }
                    }
                    case 1: {
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl17:
                        // 2 sources

                        var3_4 = $this$launch;
                        var4_5 = this.this$0;
                        try {
                            $this$invokeSuspend_u24lambda_u240 = var3_4;
                            $i$a$-runCatching-VlcAudioPlayer$2$1 = false;
                            if (VlcAudioPlayer.access$getPlayer(var4_5) != null && p.status().isPlaying()) {
                                t = p.status().time();
                                l = p.status().length();
                                if (t >= 0L) {
                                    VlcAudioPlayer.access$get_positionMs$p(var4_5).setValue((Object)Boxing.boxLong((long)t));
                                }
                                if (l > 0L) {
                                    VlcAudioPlayer.access$get_durationMs$p(var4_5).setValue((Object)Boxing.boxLong((long)l));
                                }
                            }
                            var5_6 = Result.constructor-impl((Object)Unit.INSTANCE);
                        }
                        catch (Throwable var6_8) {
                            var5_6 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var6_8));
                        }
                        ** continue;
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
        }), (int)3, null);
    }

    public /* synthetic */ VlcAudioPlayer(EchoSettings echoSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            echoSettings = null;
        }
        this(echoSettings);
    }

    @Override
    @NotNull
    public StateFlow<PlayerState> getState() {
        return this.state;
    }

    @Override
    @NotNull
    public StateFlow<Track> getCurrentTrack() {
        return this.currentTrack;
    }

    @Override
    @NotNull
    public StateFlow<List<Track>> getQueue() {
        return this.queue;
    }

    @Override
    @NotNull
    public StateFlow<Long> getPositionMs() {
        return this.positionMs;
    }

    @Override
    @NotNull
    public StateFlow<Long> getDurationMs() {
        return this.durationMs;
    }

    @Override
    @NotNull
    public StateFlow<Boolean> isPlaying() {
        return this.isPlaying;
    }

    @Override
    @NotNull
    public StateFlow<Float> getVolume() {
        return this.volume;
    }

    @Override
    @NotNull
    public StateFlow<RepeatMode> getRepeatMode() {
        return this.repeatMode;
    }

    @Override
    @NotNull
    public StateFlow<Boolean> getShuffleEnabled() {
        return this.shuffleEnabled;
    }

    private final boolean getVlcAvailable() {
        Lazy lazy = this.vlcAvailable$delegate;
        return (Boolean)lazy.getValue();
    }

    private final AudioPlayerComponent getAudioComponent() {
        Lazy lazy = this.audioComponent$delegate;
        return (AudioPlayerComponent)lazy.getValue();
    }

    private final MediaPlayer getPlayer() {
        AudioPlayerComponent audioPlayerComponent = this.getAudioComponent();
        return audioPlayerComponent != null ? audioPlayerComponent.mediaPlayer() : null;
    }

    @Override
    public void prepareTrack(@NotNull Track track2) {
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$prepareTrack_u24lambda_u244 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$prepareTrack_u24lambda_u244.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.stop();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        this._isPlaying.setValue((Object)false);
        this._currentTrack.setValue((Object)track2);
        this._state.setValue((Object)PlayerState.Companion.getLOADING());
        this._positionMs.setValue((Object)0L);
        this._durationMs.setValue((Object)0L);
    }

    @Override
    @Nullable
    public Object play(@NotNull Track track2, @NotNull Streamable.Media.Server media, @NotNull Continuation<? super Unit> $completion) {
        Object v1;
        this._state.setValue((Object)PlayerState.Companion.getLOADING());
        this._currentTrack.setValue((Object)track2);
        this._positionMs.setValue((Object)Boxing.boxLong((long)0L));
        this._durationMs.setValue((Object)Boxing.boxLong((long)0L));
        MediaPlayer mediaPlayer = this.getPlayer();
        if (mediaPlayer == null) {
            VlcAudioPlayer $this$play_u24lambda_u245 = this;
            boolean bl = false;
            System.err.println("[VlcAudioPlayer] VLC is not available!");
            $this$play_u24lambda_u245._state.setValue((Object)PlayerState.Companion.error(new Exception("VLC is not available. Please install VLC media player.")));
            return Unit.INSTANCE;
        }
        MediaPlayer p = mediaPlayer;
        Iterable $this$maxByOrNull$iv = media.getSources();
        boolean $i$f$maxByOrNull = false;
        Iterator iterator$iv = $this$maxByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v1 = null;
        } else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v1 = maxElem$iv;
            } else {
                Streamable.Source it = (Streamable.Source)maxElem$iv;
                boolean bl = false;
                int maxValue$iv = it.getQuality();
                do {
                    Object e$iv = iterator$iv.next();
                    Streamable.Source it2 = (Streamable.Source)e$iv;
                    $i$a$-maxByOrNull-VlcAudioPlayer$play$source$1 = false;
                    int v$iv = it2.getQuality();
                    if (maxValue$iv >= v$iv) continue;
                    maxElem$iv = e$iv;
                    maxValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v1 = maxElem$iv;
            }
        }
        Streamable.Source source = v1;
        if (source == null) {
            VlcAudioPlayer $this$play_u24lambda_u247 = this;
            boolean bl = false;
            System.err.println("[VlcAudioPlayer] No media source found in " + media.getSources().size() + " sources!");
            $this$play_u24lambda_u247._state.setValue((Object)PlayerState.Companion.error(new Exception("No media source available")));
            return Unit.INSTANCE;
        }
        Streamable.Source source2 = source;
        Streamable.Source source3 = source2;
        if (source3 instanceof Streamable.Source.Http) {
            Object object;
            String it;
            String string2;
            String url = ((Streamable.Source.Http)source2).getRequest().getUrl();
            System.out.println((Object)("[VlcAudioPlayer] Playing stream: " + url + " (quality: " + ((Streamable.Source.Http)source2).getQuality() + "kbps, mime: " + ((Streamable.Source.Http)source2).getTitle() + ")"));
            if (StringsKt.startsWith$default((String)url, (String)"file:", (boolean)false, (int)2, null) || new File(url).exists()) {
                Object $this$play_u24lambda_u248;
                Object $this$play_u24lambda_u247 = this;
                try {
                    $this$play_u24lambda_u248 = $this$play_u24lambda_u247;
                    boolean bl = false;
                    String[] maxValue$iv = new String[]{":no-video", ":audio-resampler=soxr", ":audio-replay-gain-mode=none"};
                    boolean ok = p.media().play(url, maxValue$iv);
                    System.out.println((Object)("[VlcAudioPlayer] Local playback p.media().play() returned: " + ok));
                    $this$play_u24lambda_u248 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable bl) {
                    $this$play_u24lambda_u248 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
                }
                $this$play_u24lambda_u247 = $this$play_u24lambda_u248;
                Throwable throwable = Result.exceptionOrNull-impl((Object)$this$play_u24lambda_u247);
                if (throwable != null) {
                    Object err = $this$play_u24lambda_u248 = throwable;
                    boolean bl = false;
                    this._state.setValue((Object)PlayerState.Companion.error((Throwable)err));
                }
                return Unit.INSTANCE;
            }
            EchoSettings echoSettings = this.settings;
            int latency = echoSettings != null ? RangesKt.coerceAtLeast((int)echoSettings.getInt("buffer_latency", 400), (int)150) : 400;
            EchoSettings echoSettings2 = this.settings;
            boolean skipSilence = echoSettings2 != null ? echoSettings2.getBoolean("skip_silence", true) : true;
            Object object2 = CollectionsKt.createListBuilder();
            List $this$play_u24lambda_u2412 = object2;
            boolean bl = false;
            $this$play_u24lambda_u2412.add(":http-caching=" + latency);
            $this$play_u24lambda_u2412.add(":network-caching=" + latency);
            $this$play_u24lambda_u2412.add(":live-caching=" + (latency + 100));
            $this$play_u24lambda_u2412.add(":http-reconnect=true");
            $this$play_u24lambda_u2412.add(":clock-jitter=0");
            $this$play_u24lambda_u2412.add(":drop-late-frames=true");
            $this$play_u24lambda_u2412.add(":no-video");
            $this$play_u24lambda_u2412.add(":audio-resampler=soxr");
            $this$play_u24lambda_u2412.add(":sout-audio");
            $this$play_u24lambda_u2412.add(":audio-replay-gain-mode=none");
            if (skipSilence) {
                $this$play_u24lambda_u2412.add(":audio-filter=normvol");
            }
            if ((string2 = ((Streamable.Source.Http)source2).getRequest().getHeaders().get("User-Agent")) == null) {
                string2 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36";
            }
            String ua = string2;
            $this$play_u24lambda_u2412.add(":http-user-agent=" + ua);
            String string3 = ((Streamable.Source.Http)source2).getRequest().getHeaders().get("Referer");
            if (string3 != null) {
                it = string3;
                boolean bl2 = false;
                Boxing.boxBoolean((boolean)$this$play_u24lambda_u2412.add(":http-referrer=" + it));
            }
            String string4 = ((Streamable.Source.Http)source2).getRequest().getHeaders().get("Origin");
            if (string4 != null) {
                it = string4;
                boolean bl3 = false;
                $this$play_u24lambda_u2412.add(":http-origin=" + it);
            }
            List options = CollectionsKt.build((List)object2);
            object2 = this;
            try {
                VlcAudioPlayer $this$play_u24lambda_u2413 = (VlcAudioPlayer)object2;
                boolean bl4 = false;
                Collection $this$toTypedArray$iv = options;
                boolean $i$f$toTypedArray = false;
                Collection thisCollection$iv = $this$toTypedArray$iv;
                String[] stringArray = thisCollection$iv.toArray(new String[0]);
                boolean ok = p.media().play(url, Arrays.copyOf(stringArray, stringArray.length));
                System.out.println((Object)("[VlcAudioPlayer] p.media().play() returned: " + ok));
                object = Result.constructor-impl((Object)Unit.INSTANCE);
            }
            catch (Throwable bl4) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl4));
            }
            object2 = object;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object2);
            if (throwable != null) {
                Object err = object = throwable;
                boolean bl5 = false;
                System.err.println("[VlcAudioPlayer] Error calling p.media().play(): " + ((Throwable)err).getMessage());
                this._state.setValue((Object)PlayerState.Companion.error((Throwable)err));
            }
            v10 = Result.box-impl((Object)object2);
        } else if (source3 instanceof Streamable.Source.Raw) {
            v10 = BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(source2, this, p, null){
                Object L$1;
                int label;
                private /* synthetic */ Object L$0;
                final /* synthetic */ Streamable.Source $source;
                final /* synthetic */ VlcAudioPlayer this$0;
                final /* synthetic */ MediaPlayer $p;
                {
                    this.$source = $source;
                    this.this$0 = $receiver;
                    this.$p = $p;
                    super(2, $completion);
                }

                /*
                 * WARNING - Removed try catching itself - possible behaviour change.
                 * Unable to fully structure code
                 * Could not resolve type clashes
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (CoroutineScope)this.L$0;
                    var16_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            tempFile = File.createTempFile("echo_stream_", ".tmp");
                            tempFile.deleteOnExit();
                            v0 = ((Streamable.Source.Raw)this.$source).getStreamProvider();
                            if (v0 == null) ** GOTO lbl55
                            this.L$0 = $this$launch;
                            this.L$1 = tempFile;
                            this.label = 1;
                            v1 = v0.provide(0L, -1L, (Continuation<? super Pair<? extends InputStream, Long>>)((Continuation)this));
                            ** if (v1 != var16_3) goto lbl18
lbl17:
                            // 1 sources

                            return var16_3;
lbl18:
                            // 1 sources

                            ** GOTO lbl25
                        }
                        case 1: {
                            tempFile = (File)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl25:
                                // 2 sources

                                if ((v0 = (Pair)v1) == null || (v0 = (InputStream)v0.getFirst()) == null) ** GOTO lbl55
                                var7_5 = (Closeable)v0;
                                var8_9 = null;
                                try {
                                    input = (InputStream)var7_5;
                                    $i$a$-use-VlcAudioPlayer$play$6$1 = false;
                                    Intrinsics.checkNotNull((Object)tempFile);
                                    var11_15 = new FileOutputStream(tempFile);
                                    var12_16 = null;
                                    try {
                                        it = (FileOutputStream)var11_15;
                                        $i$a$-use-VlcAudioPlayer$play$6$1$1 = false;
                                        var13_18 = ByteStreamsKt.copyTo$default((InputStream)input, (OutputStream)it, (int)0, (int)2, null);
                                    }
                                    catch (Throwable var15_20) {
                                        var12_16 = var15_20;
                                        throw var15_20;
                                    }
                                    finally {
                                        CloseableKt.closeFinally((Closeable)var11_15, (Throwable)var12_16);
                                    }
                                    var9_11 = Boxing.boxLong((long)var13_18);
                                }
                                catch (Throwable var10_13) {
                                    var8_9 = var10_13;
                                    throw var10_13;
                                }
                                finally {
                                    CloseableKt.closeFinally((Closeable)var7_5, (Throwable)var8_9);
                                }
lbl55:
                                // 3 sources

                                var4_22 = $this$launch;
                                var5_24 /* !! */  = this.$p;
                                try {
                                    $this$invokeSuspend_u24lambda_u242 = var4_22;
                                    $i$a$-runCatching-VlcAudioPlayer$play$6$2 = false;
                                    var6_25 = Result.constructor-impl((Object)Boxing.boxBoolean((boolean)var5_24 /* !! */ .media().play(tempFile.getAbsolutePath(), new String[0])));
                                }
                                catch (Throwable $i$a$-runCatching-VlcAudioPlayer$play$6$2) {
                                    var6_25 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-VlcAudioPlayer$play$6$2));
                                }
                                var4_22 = var6_25;
                                var5_24 /* !! */  = this.this$0;
                                v2 = Result.exceptionOrNull-impl((Object)var4_22);
                                if (v2 != null) {
                                    err = var6_25 = v2;
                                    $i$a$-onFailure-VlcAudioPlayer$play$6$3 = false;
                                    VlcAudioPlayer.access$get_state$p((VlcAudioPlayer)var5_24 /* !! */ ).setValue((Object)PlayerState.Companion.error((Throwable)err));
                                }
                            }
                            catch (Throwable e) {
                                VlcAudioPlayer.access$get_state$p(this.this$0).setValue((Object)PlayerState.Companion.error(e));
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
            }), (int)2, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    @Override
    public void pause() {
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$pause_u24lambda_u2415 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$pause_u24lambda_u2415.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.pause();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void resume() {
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$resume_u24lambda_u2416 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$resume_u24lambda_u2416.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.play();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void seekTo(long positionMs) {
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$seekTo_u24lambda_u2417 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$seekTo_u24lambda_u2417.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.setTime(positionMs);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        this._positionMs.setValue((Object)positionMs);
    }

    @Override
    public void stop() {
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$stop_u24lambda_u2418 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$stop_u24lambda_u2418.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.stop();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        this._currentTrack.setValue(null);
        this._positionMs.setValue((Object)0L);
        this._durationMs.setValue((Object)0L);
        this._queue.setValue((Object)CollectionsKt.emptyList());
        this.queueIndex = 0;
    }

    @Override
    public void skipNext() {
        List q = (List)this._queue.getValue();
        if (q.isEmpty()) {
            return;
        }
        this.queueIndex = switch (WhenMappings.$EnumSwitchMapping$0[((RepeatMode)((Object)this._repeatMode.getValue())).ordinal()]) {
            case 1 -> this.queueIndex;
            case 2 -> (this.queueIndex + 1) % q.size();
            case 3 -> RangesKt.coerceAtMost((int)(this.queueIndex + 1), (int)(q.size() - 1));
            default -> throw new NoWhenBranchMatchedException();
        };
        this._currentTrack.setValue(CollectionsKt.getOrNull((List)q, (int)this.queueIndex));
    }

    @Override
    public void skipPrevious() {
        if (((Number)this._positionMs.getValue()).longValue() > 3000L) {
            this.seekTo(0L);
            return;
        }
        List q = (List)this._queue.getValue();
        if (q.isEmpty()) {
            return;
        }
        this.queueIndex = RangesKt.coerceAtLeast((int)(this.queueIndex - 1), (int)0);
        this._currentTrack.setValue(CollectionsKt.getOrNull((List)q, (int)this.queueIndex));
    }

    @Override
    public void setQueue(@NotNull List<Track> tracks, int startIndex) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        this._queue.setValue(tracks);
        this.originalQueue = tracks;
        this.queueIndex = !((Collection)tracks).isEmpty() ? RangesKt.coerceIn((int)startIndex, (int)0, (int)(tracks.size() - 1)) : 0;
        this._currentTrack.setValue(CollectionsKt.getOrNull(tracks, (int)this.queueIndex));
    }

    @Override
    public void addToQueue(@NotNull List<Track> tracks, int index) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._queue.getValue()));
        boolean bl = index < 0 || index >= current.size() ? current.addAll((Collection)tracks) : current.addAll(index, (Collection)tracks);
        this._queue.setValue((Object)current);
        this.originalQueue = current;
    }

    @Override
    public void removeFromQueue(int index) {
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._queue.getValue()));
        boolean bl = 0 <= index ? index < ((Collection)current).size() : false;
        if (bl) {
            current.remove(index);
            if (index < this.queueIndex) {
                int n = this.queueIndex;
                this.queueIndex = n + -1;
            }
        }
        this._queue.setValue((Object)current);
    }

    @Override
    public void moveInQueue(int from, int to) {
        List current = CollectionsKt.toMutableList((Collection)((Collection)this._queue.getValue()));
        boolean bl = 0 <= from ? from < ((Collection)current).size() : false;
        if (bl) {
            boolean bl2 = 0 <= to ? to < ((Collection)current).size() : false;
            if (bl2) {
                Track item2 = (Track)current.remove(from);
                current.add(to, item2);
                this._queue.setValue((Object)current);
            }
        }
    }

    @Override
    public void setVolume(float volume) {
        float clamped = RangesKt.coerceIn((float)volume, (float)0.0f, (float)1.0f);
        this._volume.setValue((Object)Float.valueOf(clamped));
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            VlcAudioPlayer $this$setVolume_u24lambda_u2419 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$setVolume_u24lambda_u2419.getPlayer();
            Object object = Result.constructor-impl(mediaPlayer != null && (mediaPlayer = mediaPlayer.audio()) != null ? Boolean.valueOf(mediaPlayer.setVolume((int)(clamped * (float)100))) : null);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void setRepeatMode(@NotNull RepeatMode mode) {
        Intrinsics.checkNotNullParameter((Object)((Object)mode), (String)"mode");
        this._repeatMode.setValue((Object)mode);
    }

    @Override
    public void setShuffle(boolean enabled) {
        this._shuffleEnabled.setValue((Object)enabled);
        if (enabled) {
            List list2;
            List it = list2 = CollectionsKt.toMutableList((Collection)((Collection)this._queue.getValue()));
            boolean bl = false;
            Collections.shuffle(it);
            List shuffled = list2;
            this._queue.setValue((Object)shuffled);
        } else {
            this._queue.setValue(this.originalQueue);
        }
    }

    @Override
    public void setPlaybackRate(float rate) {
        float clamped;
        this.currentPlaybackRate = clamped = RangesKt.coerceIn((float)rate, (float)0.25f, (float)4.0f);
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            VlcAudioPlayer $this$setPlaybackRate_u24lambda_u2421 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = $this$setPlaybackRate_u24lambda_u2421.getPlayer();
            Object object = Result.constructor-impl(mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null ? Boolean.valueOf(mediaPlayer.setRate(clamped)) : null);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setEqualizer(@NotNull float[] bands, float preamp) {
        Intrinsics.checkNotNullParameter((Object)bands, (String)"bands");
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            VlcAudioPlayer $this$setEqualizer_u24lambda_u2423 = vlcAudioPlayer;
            boolean bl = false;
            AudioPlayerComponent audioPlayerComponent = $this$setEqualizer_u24lambda_u2423.getAudioComponent();
            if (audioPlayerComponent != null && (audioPlayerComponent = audioPlayerComponent.mediaPlayerFactory()) != null) {
                AudioPlayerComponent factory = audioPlayerComponent;
                Equalizer eq = factory.equalizer().newEqualizer();
                eq.setPreamp(RangesKt.coerceIn((float)preamp, (float)-20.0f, (float)20.0f));
                float[] $this$forEachIndexed$iv = bands;
                boolean $i$f$forEachIndexed = false;
                int index$iv = 0;
                for (float item$iv : $this$forEachIndexed$iv) {
                    void amp;
                    int n = index$iv++;
                    float f = item$iv;
                    int i = n;
                    boolean bl2 = false;
                    if (i >= eq.bandCount()) continue;
                    eq.setAmp(i, RangesKt.coerceIn((float)amp, (float)-20.0f, (float)20.0f));
                }
                $this$setEqualizer_u24lambda_u2423.currentEqualizer = eq;
                MediaPlayer mediaPlayer = $this$setEqualizer_u24lambda_u2423.getPlayer();
                if (mediaPlayer != null && (mediaPlayer = mediaPlayer.audio()) != null) {
                    mediaPlayer.setEqualizer(eq);
                }
            }
            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void setEqualizerPreset(@NotNull String preset) {
        Intrinsics.checkNotNullParameter((Object)preset, (String)"preset");
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            VlcAudioPlayer $this$setEqualizerPreset_u24lambda_u2424 = vlcAudioPlayer;
            boolean bl = false;
            AudioPlayerComponent audioPlayerComponent = $this$setEqualizerPreset_u24lambda_u2424.getAudioComponent();
            if (audioPlayerComponent != null && (audioPlayerComponent = audioPlayerComponent.mediaPlayerFactory()) != null) {
                Equalizer eq;
                AudioPlayerComponent factory = audioPlayerComponent;
                $this$setEqualizerPreset_u24lambda_u2424.currentEqualizer = eq = factory.equalizer().newEqualizer(preset);
                MediaPlayer mediaPlayer = $this$setEqualizerPreset_u24lambda_u2424.getPlayer();
                if (mediaPlayer != null && (mediaPlayer = mediaPlayer.audio()) != null) {
                    mediaPlayer.setEqualizer(eq);
                }
            }
            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void disableEqualizer() {
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$disableEqualizer_u24lambda_u2425 = vlcAudioPlayer;
            boolean bl = false;
            $this$disableEqualizer_u24lambda_u2425.currentEqualizer = null;
            MediaPlayer mediaPlayer = $this$disableEqualizer_u24lambda_u2425.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.audio()) != null) {
                mediaPlayer.setEqualizer(null);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Object object = Result.constructor-impl(unit);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void release() {
        Object object;
        Object $this$release_u24lambda_u2426;
        VlcAudioPlayer vlcAudioPlayer = this;
        try {
            Unit unit;
            $this$release_u24lambda_u2426 = vlcAudioPlayer;
            boolean bl = false;
            MediaPlayer mediaPlayer = super.getPlayer();
            if (mediaPlayer != null && (mediaPlayer = mediaPlayer.controls()) != null) {
                mediaPlayer.stop();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            $this$release_u24lambda_u2426 = Result.constructor-impl(unit);
        }
        catch (Throwable bl) {
            $this$release_u24lambda_u2426 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
        }
        vlcAudioPlayer = this;
        try {
            Unit unit;
            VlcAudioPlayer $this$release_u24lambda_u2427 = vlcAudioPlayer;
            boolean bl = false;
            AudioPlayerComponent audioPlayerComponent = $this$release_u24lambda_u2427.getAudioComponent();
            if (audioPlayerComponent != null) {
                audioPlayerComponent.release();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            object = Result.constructor-impl((Object)unit);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    public void togglePlayPause() {
        AudioPlayer.super.togglePlayPause();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean vlcAvailable_delegate$lambda$2() {
        boolean bl;
        try {
            void $this$filterTo$iv$iv;
            Object object;
            Object[] objectArray;
            block9: {
                block8: {
                    void it;
                    objectArray = new String[4];
                    objectArray[0] = "C:\\Program Files\\VideoLAN\\VLC";
                    objectArray[1] = "C:\\Program Files (x86)\\VideoLAN\\VLC";
                    String string2 = System.getenv("VLC_PLUGIN_PATH");
                    if (string2 == null) {
                        string2 = "";
                    }
                    objectArray[2] = string2;
                    Object[] objectArray2 = objectArray;
                    int n = 3;
                    object = System.getenv("PROGRAMFILES");
                    if (object == null) break block8;
                    String string3 = object;
                    int n2 = n;
                    Object[] objectArray3 = objectArray2;
                    boolean bl2 = false;
                    String string4 = (String)it + "\\VideoLAN\\VLC";
                    objectArray2 = objectArray3;
                    n = n2;
                    String string5 = string4;
                    object = string5;
                    if (string5 != null) break block9;
                }
                object = "";
            }
            objectArray2[n] = object;
            Iterable $this$filter$iv = CollectionsKt.listOf((Object[])objectArray);
            boolean $i$f$filter = false;
            Iterable iterable = $this$filter$iv;
            Collection destination$iv$iv = new ArrayList();
            boolean $i$f$filterTo = false;
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                String it = (String)element$iv$iv;
                boolean bl3 = false;
                boolean bl4 = !StringsKt.isBlank((CharSequence)it);
                if (!bl4) continue;
                destination$iv$iv.add(element$iv$iv);
            }
            List commonPaths = (List)destination$iv$iv;
            for (String path : commonPaths) {
                File dir = new File(path);
                if (!dir.exists() || !new File(dir, "libvlc.dll").exists()) continue;
                System.out.println((Object)("[VlcAudioPlayer] Found libvlc.dll at: " + dir.getAbsolutePath()));
                NativeLibrary.addSearchPath((String)"libvlc", (String)dir.getAbsolutePath());
                NativeLibrary.addSearchPath((String)"libvlccore", (String)dir.getAbsolutePath());
                System.setProperty("jna.library.path", dir.getAbsolutePath());
                break;
            }
            boolean discovered = new NativeDiscovery(new NativeDiscoveryStrategy[0]).discover();
            System.out.println((Object)("[VlcAudioPlayer] NativeDiscovery().discover() result: " + discovered));
            bl = discovered;
        }
        catch (Throwable e) {
            System.err.println("[VlcAudioPlayer] Error discovering VLC: " + e.getMessage());
            e.printStackTrace();
            bl = false;
        }
        return bl;
    }

    private static final AudioPlayerComponent audioComponent_delegate$lambda$3(VlcAudioPlayer this$0) {
        AudioPlayerComponent audioPlayerComponent;
        if (this$0.getVlcAvailable()) {
            AudioPlayerComponent audioPlayerComponent2;
            try {
                audioPlayerComponent2 = new AudioPlayerComponent();
            }
            catch (Throwable t) {
                System.err.println("[VlcAudioPlayer] Failed creating AudioPlayerComponent: " + t.getMessage());
                t.printStackTrace();
                audioPlayerComponent2 = null;
            }
            audioPlayerComponent = audioPlayerComponent2;
        } else {
            audioPlayerComponent = null;
        }
        return audioPlayerComponent;
    }

    public VlcAudioPlayer() {
        this(null, 1, null);
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[RepeatMode.values().length];
            try {
                nArray[RepeatMode.ONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RepeatMode.ALL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RepeatMode.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

