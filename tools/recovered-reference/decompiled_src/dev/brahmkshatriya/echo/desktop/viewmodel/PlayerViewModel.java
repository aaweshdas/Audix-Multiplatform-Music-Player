/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.clients.TrackClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.core.platform.AudioPlayer;
import dev.brahmkshatriya.echo.core.platform.PlayerState;
import dev.brahmkshatriya.echo.core.platform.RepeatMode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J\u000e\u0010(\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\u0006\u0010+\u001a\u00020%J\u000e\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001dJ\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020 J\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u001bJ\u0014\u00102\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013J\u000e\u00104\u001a\u00020%2\u0006\u00105\u001a\u000206J\u0016\u00107\u001a\u00020%2\u0006\u00108\u001a\u0002062\u0006\u00109\u001a\u000206J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0010J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00130\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u000e\u00a8\u0006?"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "", "player", "Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;", "extensionManager", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;Ldev/brahmkshatriya/echo/core/extensions/ExtensionManager;Lkotlinx/coroutines/CoroutineScope;)V", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "getCurrentTrack", "queue", "", "getQueue", "positionMs", "", "getPositionMs", "durationMs", "getDurationMs", "isPlaying", "", "volume", "", "getVolume", "repeatMode", "Ldev/brahmkshatriya/echo/core/platform/RepeatMode;", "getRepeatMode", "shuffleEnabled", "getShuffleEnabled", "togglePlayPause", "", "pause", "resume", "seekTo", "skipNext", "skipPrevious", "stop", "setVolume", "v", "setRepeatMode", "mode", "setShuffle", "enabled", "addToQueue", "tracks", "removeFromQueue", "index", "", "moveInQueue", "from", "to", "play", "track", "formatDuration", "", "ms", "desktopApp"})
@StabilityInferred(parameters=0)
public final class PlayerViewModel {
    @NotNull
    private final AudioPlayer player;
    @NotNull
    private final ExtensionManager extensionManager;
    @NotNull
    private final CoroutineScope scope;
    public static final int $stable = 8;

    public PlayerViewModel(@NotNull AudioPlayer player, @NotNull ExtensionManager extensionManager, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)extensionManager, (String)"extensionManager");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.player = player;
        this.extensionManager = extensionManager;
        this.scope = scope;
    }

    public /* synthetic */ PlayerViewModel(AudioPlayer audioPlayer, ExtensionManager extensionManager, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
        }
        this(audioPlayer, extensionManager, coroutineScope);
    }

    @NotNull
    public final StateFlow<PlayerState> getState() {
        return this.player.getState();
    }

    @NotNull
    public final StateFlow<Track> getCurrentTrack() {
        return this.player.getCurrentTrack();
    }

    @NotNull
    public final StateFlow<List<Track>> getQueue() {
        return this.player.getQueue();
    }

    @NotNull
    public final StateFlow<Long> getPositionMs() {
        return this.player.getPositionMs();
    }

    @NotNull
    public final StateFlow<Long> getDurationMs() {
        return this.player.getDurationMs();
    }

    @NotNull
    public final StateFlow<Boolean> isPlaying() {
        return this.player.isPlaying();
    }

    @NotNull
    public final StateFlow<Float> getVolume() {
        return this.player.getVolume();
    }

    @NotNull
    public final StateFlow<RepeatMode> getRepeatMode() {
        return this.player.getRepeatMode();
    }

    @NotNull
    public final StateFlow<Boolean> getShuffleEnabled() {
        return this.player.getShuffleEnabled();
    }

    public final void togglePlayPause() {
        this.player.togglePlayPause();
    }

    public final void pause() {
        this.player.pause();
    }

    public final void resume() {
        this.player.resume();
    }

    public final void seekTo(long positionMs) {
        this.player.seekTo(positionMs);
    }

    public final void skipNext() {
        this.player.skipNext();
    }

    public final void skipPrevious() {
        this.player.skipPrevious();
    }

    public final void stop() {
        this.player.stop();
    }

    public final void setVolume(float v) {
        this.player.setVolume(v);
    }

    public final void setRepeatMode(@NotNull RepeatMode mode) {
        Intrinsics.checkNotNullParameter((Object)((Object)mode), (String)"mode");
        this.player.setRepeatMode(mode);
    }

    public final void setShuffle(boolean enabled) {
        this.player.setShuffle(enabled);
    }

    public final void addToQueue(@NotNull List<Track> tracks) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        AudioPlayer.addToQueue$default(this.player, tracks, 0, 2, null);
    }

    public final void removeFromQueue(int index) {
        this.player.removeFromQueue(index);
    }

    public final void moveInQueue(int from, int to) {
        this.player.moveInQueue(from, to);
    }

    public final void play(@NotNull Track track2) {
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, track2, null){
            Object L$0;
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            final /* synthetic */ PlayerViewModel this$0;
            final /* synthetic */ Track $track;
            {
                this.this$0 = $receiver;
                this.$track = $track;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$getAs_u2d0E7RQCE$iv;
                        void this_$iv;
                        ResultKt.throwOnFailure((Object)$result);
                        AudioPlayer.addToQueue$default(PlayerViewModel.access$getPlayer$p(this.this$0), CollectionsKt.listOf((Object)this.$track), 0, 2, null);
                        MusicExtension musicExtension = (MusicExtension)PlayerViewModel.access$getExtensionManager$p(this.this$0).getCurrent().getValue();
                        if (musicExtension == null) {
                            return Unit.INSTANCE;
                        }
                        MusicExtension ext = musicExtension;
                        ExtensionUtils extensionUtils = ExtensionUtils.INSTANCE;
                        Extension extension2 = ext;
                        Track track2 = this.$track;
                        PlayerViewModel playerViewModel = this.this$0;
                        int n = 0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)ext);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_$iv);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE$iv);
                        this.I$0 = n;
                        this.label = 1;
                        Object object2 = this_$iv.get-0E7RQCE((Extension<?>)$this$getAs_u2d0E7RQCE$iv, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(null, track2, playerViewModel){
                            Object L$1;
                            int label;
                            private /* synthetic */ Object L$0;
                            final /* synthetic */ Track $track$inlined;
                            final /* synthetic */ PlayerViewModel this$0;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            int I$0;
                            {
                                this.$track$inlined = track2;
                                this.this$0 = playerViewModel;
                                super(2, $completion);
                            }

                            /*
                             * Unable to fully structure code
                             */
                            public final Object invokeSuspend(Object $result) {
                                block12: {
                                    var2_2 = (ExtensionClient)this.L$0;
                                    var3_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)$result);
                                            v0 = $this$get;
                                            if (!(v0 instanceof TrackClient)) {
                                                v0 = null;
                                            }
                                            v1 = v0;
                                            if (v1 == null) {
                                                v2 = Reflection.getOrCreateKotlinClass(TrackClient.class).getSimpleName();
                                                if (v2 == null) {
                                                    v2 = "Unknown";
                                                }
                                                throw new ClientException.NotSupported(v2);
                                            }
                                            client = v1;
                                            var5_6 = (Continuation)this;
                                            $this$invokeSuspend_u24lambda_u240 = client;
                                            $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1 = 0;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = $this$invokeSuspend_u24lambda_u240;
                                            this.I$0 = $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1;
                                            this.label = 1;
                                            v3 = $this$invokeSuspend_u24lambda_u240.loadTrack(this.$track$inlined, false, (Continuation<? super Track>)this);
                                            if (v3 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl36
                                        }
                                        case 1: {
                                            $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1 = this.I$0;
                                            $this$invokeSuspend_u24lambda_u240 = (TrackClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (TrackClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v3 = $result;
lbl36:
                                            // 2 sources

                                            loadedTrack = (Track)v3;
                                            v4 = (Streamable)CollectionsKt.firstOrNull(loadedTrack.getServers());
                                            if (v4 != null) ** GOTO lbl41
                                            v5 = Unit.INSTANCE;
                                            break block12;
lbl41:
                                            // 1 sources

                                            server = v4;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                                            this.L$4 = loadedTrack;
                                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)server);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1;
                                            this.label = 2;
                                            v6 = $this$invokeSuspend_u24lambda_u240.loadStreamableMedia(server, false, (Continuation<? super Streamable.Media>)this);
                                            if (v6 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl63
                                        }
                                        case 2: {
                                            $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1 = this.I$0;
                                            server = (Streamable)this.L$5;
                                            loadedTrack = (Track)this.L$4;
                                            $this$invokeSuspend_u24lambda_u240 = (TrackClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (TrackClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v6 = $result;
lbl63:
                                            // 2 sources

                                            if (!((media = (Streamable.Media)v6) instanceof Streamable.Media.Server)) break;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object)loadedTrack);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable((Object)media);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable((Object)server);
                                            this.I$0 = $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1;
                                            this.label = 3;
                                            v7 = PlayerViewModel.access$getPlayer$p(this.this$0).play(loadedTrack, (Streamable.Media.Server)media, (Continuation<? super Unit>)this);
                                            if (v7 == var3_3) {
                                                return var3_3;
                                            }
                                            ** GOTO lbl87
                                        }
                                        case 3: {
                                            $i$a$-getAs-0E7RQCE-PlayerViewModel$play$1$1 = this.I$0;
                                            server = (Streamable)this.L$6;
                                            media = (Streamable.Media)this.L$5;
                                            loadedTrack = (Track)this.L$4;
                                            $this$invokeSuspend_u24lambda_u240 = (TrackClient)this.L$3;
                                            $completion = (Continuation)this.L$2;
                                            client = (TrackClient)this.L$1;
                                            ResultKt.throwOnFailure((Object)$result);
                                            v7 = $result;
lbl87:
                                            // 2 sources

                                            v5 = Unit.INSTANCE;
                                            break block12;
                                        }
                                    }
                                    v5 = Unit.INSTANCE;
                                }
                                return v5;
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
                        if (object2 != object) return Unit.INSTANCE;
                        return object;
                    }
                    case 1: {
                        int n = this.I$0;
                        Extension $this$getAs_u2d0E7RQCE$iv = (Extension)this.L$2;
                        ExtensionUtils this_$iv = (ExtensionUtils)this.L$1;
                        MusicExtension ext = (MusicExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object2 = ((Result)$result).unbox-impl();
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
    public final String formatDuration(long ms) {
        long totalSeconds = ms / (long)1000;
        long minutes = totalSeconds / (long)60;
        long seconds = totalSeconds % (long)60;
        String string2 = "%d:%02d";
        Object[] objectArray = new Object[]{minutes, seconds};
        String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
        return string3;
    }

    public static final /* synthetic */ AudioPlayer access$getPlayer$p(PlayerViewModel $this) {
        return $this.player;
    }

    public static final /* synthetic */ ExtensionManager access$getExtensionManager$p(PlayerViewModel $this) {
        return $this.extensionManager;
    }
}

