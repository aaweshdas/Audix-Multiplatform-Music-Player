/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.platform;

import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.platform.PlayerState;
import dev.brahmkshatriya.echo.core.platform.RepeatMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\u001e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u00a6@\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001dH&J\b\u0010$\u001a\u00020\u001dH&J\b\u0010%\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010'\u001a\u00020\u001dH&J\b\u0010(\u001a\u00020\u001dH&J\b\u0010)\u001a\u00020\u001dH&J \u0010*\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010,\u001a\u00020-H\u0016J \u0010.\u001a\u00020\u001d2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0002\u0010/\u001a\u00020-H&J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020-H&J\u0018\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020-H&J\u0010\u00104\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0018H&J\u0010\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0013H&J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u0015H\u0016J\u001a\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020\u001dH\u0016J\b\u0010C\u001a\u00020\u001dH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006\u00a8\u0006D\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;", "", "state", "Lkotlinx/coroutines/flow/StateFlow;", "Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "getCurrentTrack", "queue", "", "getQueue", "positionMs", "", "getPositionMs", "durationMs", "getDurationMs", "isPlaying", "", "volume", "", "getVolume", "repeatMode", "Ldev/brahmkshatriya/echo/core/platform/RepeatMode;", "getRepeatMode", "shuffleEnabled", "getShuffleEnabled", "prepareTrack", "", "track", "play", "media", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "(Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "resume", "togglePlayPause", "seekTo", "stop", "skipNext", "skipPrevious", "setQueue", "tracks", "startIndex", "", "addToQueue", "index", "removeFromQueue", "moveInQueue", "from", "to", "setVolume", "setRepeatMode", "mode", "setShuffle", "enabled", "setPlaybackRate", "rate", "setEqualizer", "bands", "", "preamp", "setEqualizerPreset", "preset", "", "disableEqualizer", "release", "core"})
public interface AudioPlayer {
    @NotNull
    public StateFlow<PlayerState> getState();

    @NotNull
    public StateFlow<Track> getCurrentTrack();

    @NotNull
    public StateFlow<List<Track>> getQueue();

    @NotNull
    public StateFlow<Long> getPositionMs();

    @NotNull
    public StateFlow<Long> getDurationMs();

    @NotNull
    public StateFlow<Boolean> isPlaying();

    @NotNull
    public StateFlow<Float> getVolume();

    @NotNull
    public StateFlow<RepeatMode> getRepeatMode();

    @NotNull
    public StateFlow<Boolean> getShuffleEnabled();

    default public void prepareTrack(@NotNull Track track2) {
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
    }

    @Nullable
    public Object play(@NotNull Track var1, @NotNull Streamable.Media.Server var2, @NotNull Continuation<? super Unit> var3);

    public void pause();

    public void resume();

    default public void togglePlayPause() {
        if (((Boolean)this.isPlaying().getValue()).booleanValue()) {
            this.pause();
        } else {
            this.resume();
        }
    }

    public void seekTo(long var1);

    public void stop();

    public void skipNext();

    public void skipPrevious();

    default public void setQueue(@NotNull List<Track> tracks, int startIndex) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        this.stop();
        AudioPlayer.addToQueue$default(this, tracks, 0, 2, null);
    }

    public static /* synthetic */ void setQueue$default(AudioPlayer audioPlayer, List list2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setQueue");
        }
        if ((n2 & 2) != 0) {
            n = 0;
        }
        audioPlayer.setQueue(list2, n);
    }

    public void addToQueue(@NotNull List<Track> var1, int var2);

    public static /* synthetic */ void addToQueue$default(AudioPlayer audioPlayer, List list2, int n, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addToQueue");
        }
        if ((n2 & 2) != 0) {
            n = -1;
        }
        audioPlayer.addToQueue(list2, n);
    }

    public void removeFromQueue(int var1);

    public void moveInQueue(int var1, int var2);

    public void setVolume(float var1);

    public void setRepeatMode(@NotNull RepeatMode var1);

    public void setShuffle(boolean var1);

    default public void setPlaybackRate(float rate) {
    }

    default public void setEqualizer(@NotNull float[] bands, float preamp) {
        Intrinsics.checkNotNullParameter((Object)bands, (String)"bands");
    }

    public static /* synthetic */ void setEqualizer$default(AudioPlayer audioPlayer, float[] fArray, float f, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setEqualizer");
        }
        if ((n & 2) != 0) {
            f = 0.0f;
        }
        audioPlayer.setEqualizer(fArray, f);
    }

    default public void setEqualizerPreset(@NotNull String preset) {
        Intrinsics.checkNotNullParameter((Object)preset, (String)"preset");
    }

    default public void disableEqualizer() {
    }

    default public void release() {
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        public static void prepareTrack(@NotNull AudioPlayer $this, @NotNull Track track2) {
            Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
            $this.prepareTrack(track2);
        }

        @Deprecated
        public static void togglePlayPause(@NotNull AudioPlayer $this) {
            $this.togglePlayPause();
        }

        @Deprecated
        public static void setQueue(@NotNull AudioPlayer $this, @NotNull List<Track> tracks, int startIndex) {
            Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
            $this.setQueue(tracks, startIndex);
        }

        public static /* synthetic */ void setQueue$default(AudioPlayer audioPlayer, List list2, int n, int n2, Object object) {
            AudioPlayer.setQueue$default(audioPlayer, list2, n, n2, object);
        }

        public static /* synthetic */ void addToQueue$default(AudioPlayer audioPlayer, List list2, int n, int n2, Object object) {
            AudioPlayer.addToQueue$default(audioPlayer, list2, n, n2, object);
        }

        @Deprecated
        public static void setPlaybackRate(@NotNull AudioPlayer $this, float rate) {
            $this.setPlaybackRate(rate);
        }

        @Deprecated
        public static void setEqualizer(@NotNull AudioPlayer $this, @NotNull float[] bands, float preamp) {
            Intrinsics.checkNotNullParameter((Object)bands, (String)"bands");
            $this.setEqualizer(bands, preamp);
        }

        public static /* synthetic */ void setEqualizer$default(AudioPlayer audioPlayer, float[] fArray, float f, int n, Object object) {
            AudioPlayer.setEqualizer$default(audioPlayer, fArray, f, n, object);
        }

        @Deprecated
        public static void setEqualizerPreset(@NotNull AudioPlayer $this, @NotNull String preset) {
            Intrinsics.checkNotNullParameter((Object)preset, (String)"preset");
            $this.setEqualizerPreset(preset);
        }

        @Deprecated
        public static void disableEqualizer(@NotNull AudioPlayer $this) {
            $this.disableEqualizer();
        }

        @Deprecated
        public static void release(@NotNull AudioPlayer $this) {
            $this.release();
        }
    }
}

