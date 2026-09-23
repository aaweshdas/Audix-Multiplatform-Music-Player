/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015\u00a8\u0006#"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/MediaDetailState;", "", "isLoading", "", "error", "", "media", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "tracks", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "artistShelves", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "<init>", "(ZLjava/lang/Throwable;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ljava/util/List;Ljava/util/List;)V", "()Z", "getError", "()Ljava/lang/Throwable;", "getMedia", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getTracks", "()Ljava/util/List;", "getArtistShelves", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "desktopApp"})
@StabilityInferred(parameters=0)
public final class MediaDetailState {
    private final boolean isLoading;
    @Nullable
    private final Throwable error;
    @Nullable
    private final EchoMediaItem media;
    @NotNull
    private final List<Track> tracks;
    @NotNull
    private final List<Shelf> artistShelves;
    public static final int $stable = 8;

    public MediaDetailState(boolean isLoading, @Nullable Throwable error, @Nullable EchoMediaItem media, @NotNull List<Track> tracks, @NotNull List<? extends Shelf> artistShelves) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        Intrinsics.checkNotNullParameter(artistShelves, (String)"artistShelves");
        this.isLoading = isLoading;
        this.error = error;
        this.media = media;
        this.tracks = tracks;
        this.artistShelves = artistShelves;
    }

    public /* synthetic */ MediaDetailState(boolean bl, Throwable throwable, EchoMediaItem echoMediaItem, List list2, List list3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            throwable = null;
        }
        if ((n & 4) != 0) {
            echoMediaItem = null;
        }
        if ((n & 8) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x10) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        this(bl, throwable, echoMediaItem, list2, list3);
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    @Nullable
    public final Throwable getError() {
        return this.error;
    }

    @Nullable
    public final EchoMediaItem getMedia() {
        return this.media;
    }

    @NotNull
    public final List<Track> getTracks() {
        return this.tracks;
    }

    @NotNull
    public final List<Shelf> getArtistShelves() {
        return this.artistShelves;
    }

    public final boolean component1() {
        return this.isLoading;
    }

    @Nullable
    public final Throwable component2() {
        return this.error;
    }

    @Nullable
    public final EchoMediaItem component3() {
        return this.media;
    }

    @NotNull
    public final List<Track> component4() {
        return this.tracks;
    }

    @NotNull
    public final List<Shelf> component5() {
        return this.artistShelves;
    }

    @NotNull
    public final MediaDetailState copy(boolean isLoading, @Nullable Throwable error, @Nullable EchoMediaItem media, @NotNull List<Track> tracks, @NotNull List<? extends Shelf> artistShelves) {
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        Intrinsics.checkNotNullParameter(artistShelves, (String)"artistShelves");
        return new MediaDetailState(isLoading, error, media, tracks, artistShelves);
    }

    public static /* synthetic */ MediaDetailState copy$default(MediaDetailState mediaDetailState, boolean bl, Throwable throwable, EchoMediaItem echoMediaItem, List list2, List list3, int n, Object object) {
        if ((n & 1) != 0) {
            bl = mediaDetailState.isLoading;
        }
        if ((n & 2) != 0) {
            throwable = mediaDetailState.error;
        }
        if ((n & 4) != 0) {
            echoMediaItem = mediaDetailState.media;
        }
        if ((n & 8) != 0) {
            list2 = mediaDetailState.tracks;
        }
        if ((n & 0x10) != 0) {
            list3 = mediaDetailState.artistShelves;
        }
        return mediaDetailState.copy(bl, throwable, echoMediaItem, list2, list3);
    }

    @NotNull
    public String toString() {
        return "MediaDetailState(isLoading=" + this.isLoading + ", error=" + this.error + ", media=" + this.media + ", tracks=" + this.tracks + ", artistShelves=" + this.artistShelves + ")";
    }

    public int hashCode() {
        int result2 = Boolean.hashCode(this.isLoading);
        result2 = result2 * 31 + (this.error == null ? 0 : this.error.hashCode());
        result2 = result2 * 31 + (this.media == null ? 0 : this.media.hashCode());
        result2 = result2 * 31 + ((Object)this.tracks).hashCode();
        result2 = result2 * 31 + ((Object)this.artistShelves).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaDetailState)) {
            return false;
        }
        MediaDetailState mediaDetailState = (MediaDetailState)other;
        if (this.isLoading != mediaDetailState.isLoading) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.error, (Object)mediaDetailState.error)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.media, (Object)mediaDetailState.media)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.tracks, mediaDetailState.tracks)) {
            return false;
        }
        return Intrinsics.areEqual(this.artistShelves, mediaDetailState.artistShelves);
    }

    public MediaDetailState() {
        this(false, null, null, null, null, 31, null);
    }
}

