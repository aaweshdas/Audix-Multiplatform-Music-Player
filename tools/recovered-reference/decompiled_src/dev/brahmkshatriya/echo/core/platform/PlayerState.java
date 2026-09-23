/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "", "status", "Ldev/brahmkshatriya/echo/core/platform/PlayerState$Status;", "error", "", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/PlayerState$Status;Ljava/lang/Throwable;)V", "getStatus", "()Ldev/brahmkshatriya/echo/core/platform/PlayerState$Status;", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Status", "Companion", "core"})
public final class PlayerState {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Status status;
    @Nullable
    private final Throwable error;
    @NotNull
    private static final PlayerState IDLE = new PlayerState(Status.IDLE, null, 2, null);
    @NotNull
    private static final PlayerState LOADING = new PlayerState(Status.LOADING, null, 2, null);
    @NotNull
    private static final PlayerState PLAYING = new PlayerState(Status.PLAYING, null, 2, null);
    @NotNull
    private static final PlayerState PAUSED = new PlayerState(Status.PAUSED, null, 2, null);
    @NotNull
    private static final PlayerState BUFFERING = new PlayerState(Status.BUFFERING, null, 2, null);
    @NotNull
    private static final PlayerState ENDED = new PlayerState(Status.ENDED, null, 2, null);

    public PlayerState(@NotNull Status status, @Nullable Throwable error) {
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        this.status = status;
        this.error = error;
    }

    public /* synthetic */ PlayerState(Status status, Throwable throwable, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            throwable = null;
        }
        this(status, throwable);
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    @Nullable
    public final Throwable getError() {
        return this.error;
    }

    @NotNull
    public final Status component1() {
        return this.status;
    }

    @Nullable
    public final Throwable component2() {
        return this.error;
    }

    @NotNull
    public final PlayerState copy(@NotNull Status status, @Nullable Throwable error) {
        Intrinsics.checkNotNullParameter((Object)((Object)status), (String)"status");
        return new PlayerState(status, error);
    }

    public static /* synthetic */ PlayerState copy$default(PlayerState playerState, Status status, Throwable throwable, int n, Object object) {
        if ((n & 1) != 0) {
            status = playerState.status;
        }
        if ((n & 2) != 0) {
            throwable = playerState.error;
        }
        return playerState.copy(status, throwable);
    }

    @NotNull
    public String toString() {
        return "PlayerState(status=" + this.status + ", error=" + this.error + ")";
    }

    public int hashCode() {
        int result2 = this.status.hashCode();
        result2 = result2 * 31 + (this.error == null ? 0 : this.error.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerState)) {
            return false;
        }
        PlayerState playerState = (PlayerState)other;
        if (this.status != playerState.status) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.error, (Object)playerState.error);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0015"}, d2={"Ldev/brahmkshatriya/echo/core/platform/PlayerState$Companion;", "", "<init>", "()V", "IDLE", "Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "getIDLE", "()Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "LOADING", "getLOADING", "PLAYING", "getPLAYING", "PAUSED", "getPAUSED", "BUFFERING", "getBUFFERING", "ENDED", "getENDED", "error", "t", "", "core"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PlayerState getIDLE() {
            return IDLE;
        }

        @NotNull
        public final PlayerState getLOADING() {
            return LOADING;
        }

        @NotNull
        public final PlayerState getPLAYING() {
            return PLAYING;
        }

        @NotNull
        public final PlayerState getPAUSED() {
            return PAUSED;
        }

        @NotNull
        public final PlayerState getBUFFERING() {
            return BUFFERING;
        }

        @NotNull
        public final PlayerState getENDED() {
            return ENDED;
        }

        @NotNull
        public final PlayerState error(@NotNull Throwable t) {
            Intrinsics.checkNotNullParameter((Object)t, (String)"t");
            return new PlayerState(Status.ERROR, t);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Ldev/brahmkshatriya/echo/core/platform/PlayerState$Status;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "PLAYING", "PAUSED", "BUFFERING", "ENDED", "ERROR", "core"})
    public static final class Status
    extends Enum<Status> {
        public static final /* enum */ Status IDLE = new Status();
        public static final /* enum */ Status LOADING = new Status();
        public static final /* enum */ Status PLAYING = new Status();
        public static final /* enum */ Status PAUSED = new Status();
        public static final /* enum */ Status BUFFERING = new Status();
        public static final /* enum */ Status ENDED = new Status();
        public static final /* enum */ Status ERROR = new Status();
        private static final /* synthetic */ Status[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Status[] values() {
            return (Status[])$VALUES.clone();
        }

        public static Status valueOf(String value2) {
            return Enum.valueOf(Status.class, value2);
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = statusArray = new Status[]{Status.IDLE, Status.LOADING, Status.PLAYING, Status.PAUSED, Status.BUFFERING, Status.ENDED, Status.ERROR};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

