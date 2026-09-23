/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.library;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.desktop.library.LibraryData$;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack$;
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist;
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0004\b\b\u0010\tBK\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J9\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001\u00a2\u0006\u0002\b$R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006'"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/LibraryData;", "", "favorites", "", "Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "playlists", "Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist;", "history", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFavorites", "()Ljava/util/List;", "getPlaylists", "getHistory", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$desktopApp", "$serializer", "Companion", "desktopApp"})
@StabilityInferred(parameters=0)
public final class LibraryData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<StoredTrack> favorites;
    @NotNull
    private final List<UserPlaylist> playlists;
    @NotNull
    private final List<StoredTrack> history;
    public static final int $stable = 8;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public LibraryData(@NotNull List<StoredTrack> favorites, @NotNull List<UserPlaylist> playlists, @NotNull List<StoredTrack> history) {
        Intrinsics.checkNotNullParameter(favorites, (String)"favorites");
        Intrinsics.checkNotNullParameter(playlists, (String)"playlists");
        Intrinsics.checkNotNullParameter(history, (String)"history");
        this.favorites = favorites;
        this.playlists = playlists;
        this.history = history;
    }

    public /* synthetic */ LibraryData(List list2, List list3, List list4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 2) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        if ((n & 4) != 0) {
            list4 = CollectionsKt.emptyList();
        }
        this(list2, list3, list4);
    }

    @NotNull
    public final List<StoredTrack> getFavorites() {
        return this.favorites;
    }

    @NotNull
    public final List<UserPlaylist> getPlaylists() {
        return this.playlists;
    }

    @NotNull
    public final List<StoredTrack> getHistory() {
        return this.history;
    }

    @NotNull
    public final List<StoredTrack> component1() {
        return this.favorites;
    }

    @NotNull
    public final List<UserPlaylist> component2() {
        return this.playlists;
    }

    @NotNull
    public final List<StoredTrack> component3() {
        return this.history;
    }

    @NotNull
    public final LibraryData copy(@NotNull List<StoredTrack> favorites, @NotNull List<UserPlaylist> playlists, @NotNull List<StoredTrack> history) {
        Intrinsics.checkNotNullParameter(favorites, (String)"favorites");
        Intrinsics.checkNotNullParameter(playlists, (String)"playlists");
        Intrinsics.checkNotNullParameter(history, (String)"history");
        return new LibraryData(favorites, playlists, history);
    }

    public static /* synthetic */ LibraryData copy$default(LibraryData libraryData, List list2, List list3, List list4, int n, Object object) {
        if ((n & 1) != 0) {
            list2 = libraryData.favorites;
        }
        if ((n & 2) != 0) {
            list3 = libraryData.playlists;
        }
        if ((n & 4) != 0) {
            list4 = libraryData.history;
        }
        return libraryData.copy(list2, list3, list4);
    }

    @NotNull
    public String toString() {
        return "LibraryData(favorites=" + this.favorites + ", playlists=" + this.playlists + ", history=" + this.history + ")";
    }

    public int hashCode() {
        int result2 = ((Object)this.favorites).hashCode();
        result2 = result2 * 31 + ((Object)this.playlists).hashCode();
        result2 = result2 * 31 + ((Object)this.history).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryData)) {
            return false;
        }
        LibraryData libraryData = (LibraryData)other;
        if (!Intrinsics.areEqual(this.favorites, libraryData.favorites)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.playlists, libraryData.playlists)) {
            return false;
        }
        return Intrinsics.areEqual(this.history, libraryData.history);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$desktopApp(LibraryData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !Intrinsics.areEqual(self.favorites, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), self.favorites);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual(self.playlists, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)lazyArray[1].getValue(), self.playlists);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual(self.history, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.history);
        }
    }

    public /* synthetic */ LibraryData(int seen0, List favorites, List playlists, List history, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.favorites = (seen0 & 1) == 0 ? CollectionsKt.emptyList() : favorites;
        this.playlists = (seen0 & 2) == 0 ? CollectionsKt.emptyList() : playlists;
        this.history = (seen0 & 4) == 0 ? CollectionsKt.emptyList() : history;
    }

    public LibraryData() {
        this(null, null, null, 7, null);
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StoredTrack$.serializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)UserPlaylist$.serializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StoredTrack$.serializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/LibraryData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/desktop/library/LibraryData;", "desktopApp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<LibraryData> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

