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
 *  kotlin.collections.MapsKt
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
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.library;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack$;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fB{\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u000e\u0010\u0014J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0003J\t\u0010*\u001a\u00020\nH\u00c6\u0003Jv\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\r\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0011H\u00d6\u0001J\t\u00101\u001a\u00020\u0003H\u00d6\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001\u00a2\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006<"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "", "id", "", "title", "artists", "", "albumTitle", "coverUrl", "durationMs", "", "extras", "", "timestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getArtists", "()Ljava/util/List;", "getAlbumTitle", "getCoverUrl", "getDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtras", "()Ljava/util/Map;", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;J)Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$desktopApp", "$serializer", "Companion", "desktopApp"})
@StabilityInferred(parameters=0)
public final class StoredTrack {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final List<String> artists;
    @Nullable
    private final String albumTitle;
    @Nullable
    private final String coverUrl;
    @Nullable
    private final Long durationMs;
    @NotNull
    private final Map<String, String> extras;
    private final long timestamp;
    public static final int $stable = 8;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public StoredTrack(@NotNull String id2, @NotNull String title, @NotNull List<String> artists, @Nullable String albumTitle, @Nullable String coverUrl, @Nullable Long durationMs, @NotNull Map<String, String> extras, long timestamp) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.title = title;
        this.artists = artists;
        this.albumTitle = albumTitle;
        this.coverUrl = coverUrl;
        this.durationMs = durationMs;
        this.extras = extras;
        this.timestamp = timestamp;
    }

    public /* synthetic */ StoredTrack(String string2, String string3, List list2, String string4, String string5, Long l, Map map2, long l2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 8) != 0) {
            string4 = null;
        }
        if ((n & 0x10) != 0) {
            string5 = null;
        }
        if ((n & 0x20) != 0) {
            l = null;
        }
        if ((n & 0x40) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x80) != 0) {
            l2 = System.currentTimeMillis();
        }
        this(string2, string3, list2, string4, string5, l, map2, l2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<String> getArtists() {
        return this.artists;
    }

    @Nullable
    public final String getAlbumTitle() {
        return this.albumTitle;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final Long getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<String> component3() {
        return this.artists;
    }

    @Nullable
    public final String component4() {
        return this.albumTitle;
    }

    @Nullable
    public final String component5() {
        return this.coverUrl;
    }

    @Nullable
    public final Long component6() {
        return this.durationMs;
    }

    @NotNull
    public final Map<String, String> component7() {
        return this.extras;
    }

    public final long component8() {
        return this.timestamp;
    }

    @NotNull
    public final StoredTrack copy(@NotNull String id2, @NotNull String title, @NotNull List<String> artists, @Nullable String albumTitle, @Nullable String coverUrl, @Nullable Long durationMs, @NotNull Map<String, String> extras, long timestamp) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new StoredTrack(id2, title, artists, albumTitle, coverUrl, durationMs, extras, timestamp);
    }

    public static /* synthetic */ StoredTrack copy$default(StoredTrack storedTrack, String string2, String string3, List list2, String string4, String string5, Long l, Map map2, long l2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = storedTrack.id;
        }
        if ((n & 2) != 0) {
            string3 = storedTrack.title;
        }
        if ((n & 4) != 0) {
            list2 = storedTrack.artists;
        }
        if ((n & 8) != 0) {
            string4 = storedTrack.albumTitle;
        }
        if ((n & 0x10) != 0) {
            string5 = storedTrack.coverUrl;
        }
        if ((n & 0x20) != 0) {
            l = storedTrack.durationMs;
        }
        if ((n & 0x40) != 0) {
            map2 = storedTrack.extras;
        }
        if ((n & 0x80) != 0) {
            l2 = storedTrack.timestamp;
        }
        return storedTrack.copy(string2, string3, list2, string4, string5, l, map2, l2);
    }

    @NotNull
    public String toString() {
        return "StoredTrack(id=" + this.id + ", title=" + this.title + ", artists=" + this.artists + ", albumTitle=" + this.albumTitle + ", coverUrl=" + this.coverUrl + ", durationMs=" + this.durationMs + ", extras=" + this.extras + ", timestamp=" + this.timestamp + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + ((Object)this.artists).hashCode();
        result2 = result2 * 31 + (this.albumTitle == null ? 0 : this.albumTitle.hashCode());
        result2 = result2 * 31 + (this.coverUrl == null ? 0 : this.coverUrl.hashCode());
        result2 = result2 * 31 + (this.durationMs == null ? 0 : ((Object)this.durationMs).hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
        result2 = result2 * 31 + Long.hashCode(this.timestamp);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoredTrack)) {
            return false;
        }
        StoredTrack storedTrack = (StoredTrack)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)storedTrack.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)storedTrack.title)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.artists, storedTrack.artists)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.albumTitle, (Object)storedTrack.albumTitle)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.coverUrl, (Object)storedTrack.coverUrl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.durationMs, (Object)storedTrack.durationMs)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, storedTrack.extras)) {
            return false;
        }
        return this.timestamp == storedTrack.timestamp;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$desktopApp(StoredTrack self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual(self.artists, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.artists);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.albumTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.albumTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.coverUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.coverUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.durationMs != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.durationMs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : !Intrinsics.areEqual(self.extras, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)lazyArray[6].getValue(), self.extras);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.timestamp != System.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 7, self.timestamp);
        }
    }

    public /* synthetic */ StoredTrack(int seen0, String id2, String title, List artists, String albumTitle, String coverUrl, Long durationMs, Map extras, long timestamp, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.artists = (seen0 & 4) == 0 ? CollectionsKt.emptyList() : artists;
        this.albumTitle = (seen0 & 8) == 0 ? null : albumTitle;
        this.coverUrl = (seen0 & 0x10) == 0 ? null : coverUrl;
        this.durationMs = (seen0 & 0x20) == 0 ? null : durationMs;
        this.extras = (seen0 & 0x40) == 0 ? MapsKt.emptyMap() : extras;
        this.timestamp = (seen0 & 0x80) == 0 ? System.currentTimeMillis() : timestamp;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)), null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/StoredTrack$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "desktopApp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<StoredTrack> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

