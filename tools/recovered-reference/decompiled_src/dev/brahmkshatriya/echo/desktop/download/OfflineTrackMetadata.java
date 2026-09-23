/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
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
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.download;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.desktop.download.OfflineTrackMetadata$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eBo\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\r\u0010\u0013J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\nH\u00c6\u0003Jj\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\nH\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\u0010H\u00d6\u0001J\t\u0010/\u001a\u00020\u0003H\u00d6\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001\u00a2\u0006\u0002\b7R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006:"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/OfflineTrackMetadata;", "", "id", "", "title", "artists", "", "album", "coverUrl", "durationMs", "", "format", "downloadTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;J)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getArtists", "()Ljava/util/List;", "getAlbum", "getCoverUrl", "getDurationMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFormat", "getDownloadTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;J)Ldev/brahmkshatriya/echo/desktop/download/OfflineTrackMetadata;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$desktopApp", "$serializer", "Companion", "desktopApp"})
@StabilityInferred(parameters=0)
public final class OfflineTrackMetadata {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final List<String> artists;
    @Nullable
    private final String album;
    @Nullable
    private final String coverUrl;
    @Nullable
    private final Long durationMs;
    @NotNull
    private final String format;
    private final long downloadTime;
    public static final int $stable = 8;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public OfflineTrackMetadata(@NotNull String id2, @NotNull String title, @NotNull List<String> artists, @Nullable String album, @Nullable String coverUrl, @Nullable Long durationMs, @NotNull String format, long downloadTime) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter((Object)format, (String)"format");
        this.id = id2;
        this.title = title;
        this.artists = artists;
        this.album = album;
        this.coverUrl = coverUrl;
        this.durationMs = durationMs;
        this.format = format;
        this.downloadTime = downloadTime;
    }

    public /* synthetic */ OfflineTrackMetadata(String string2, String string3, List list2, String string4, String string5, Long l, String string6, long l2, int n, DefaultConstructorMarker defaultConstructorMarker) {
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
            string6 = "MP3";
        }
        if ((n & 0x80) != 0) {
            l2 = System.currentTimeMillis();
        }
        this(string2, string3, list2, string4, string5, l, string6, l2);
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
    public final String getAlbum() {
        return this.album;
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
    public final String getFormat() {
        return this.format;
    }

    public final long getDownloadTime() {
        return this.downloadTime;
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
        return this.album;
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
    public final String component7() {
        return this.format;
    }

    public final long component8() {
        return this.downloadTime;
    }

    @NotNull
    public final OfflineTrackMetadata copy(@NotNull String id2, @NotNull String title, @NotNull List<String> artists, @Nullable String album, @Nullable String coverUrl, @Nullable Long durationMs, @NotNull String format, long downloadTime) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter((Object)format, (String)"format");
        return new OfflineTrackMetadata(id2, title, artists, album, coverUrl, durationMs, format, downloadTime);
    }

    public static /* synthetic */ OfflineTrackMetadata copy$default(OfflineTrackMetadata offlineTrackMetadata, String string2, String string3, List list2, String string4, String string5, Long l, String string6, long l2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = offlineTrackMetadata.id;
        }
        if ((n & 2) != 0) {
            string3 = offlineTrackMetadata.title;
        }
        if ((n & 4) != 0) {
            list2 = offlineTrackMetadata.artists;
        }
        if ((n & 8) != 0) {
            string4 = offlineTrackMetadata.album;
        }
        if ((n & 0x10) != 0) {
            string5 = offlineTrackMetadata.coverUrl;
        }
        if ((n & 0x20) != 0) {
            l = offlineTrackMetadata.durationMs;
        }
        if ((n & 0x40) != 0) {
            string6 = offlineTrackMetadata.format;
        }
        if ((n & 0x80) != 0) {
            l2 = offlineTrackMetadata.downloadTime;
        }
        return offlineTrackMetadata.copy(string2, string3, list2, string4, string5, l, string6, l2);
    }

    @NotNull
    public String toString() {
        return "OfflineTrackMetadata(id=" + this.id + ", title=" + this.title + ", artists=" + this.artists + ", album=" + this.album + ", coverUrl=" + this.coverUrl + ", durationMs=" + this.durationMs + ", format=" + this.format + ", downloadTime=" + this.downloadTime + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + ((Object)this.artists).hashCode();
        result2 = result2 * 31 + (this.album == null ? 0 : this.album.hashCode());
        result2 = result2 * 31 + (this.coverUrl == null ? 0 : this.coverUrl.hashCode());
        result2 = result2 * 31 + (this.durationMs == null ? 0 : ((Object)this.durationMs).hashCode());
        result2 = result2 * 31 + this.format.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.downloadTime);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineTrackMetadata)) {
            return false;
        }
        OfflineTrackMetadata offlineTrackMetadata = (OfflineTrackMetadata)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)offlineTrackMetadata.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)offlineTrackMetadata.title)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.artists, offlineTrackMetadata.artists)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.album, (Object)offlineTrackMetadata.album)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.coverUrl, (Object)offlineTrackMetadata.coverUrl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.durationMs, (Object)offlineTrackMetadata.durationMs)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.format, (Object)offlineTrackMetadata.format)) {
            return false;
        }
        return this.downloadTime == offlineTrackMetadata.downloadTime;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$desktopApp(OfflineTrackMetadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.artists);
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.album != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.album);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.coverUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.coverUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.durationMs != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.durationMs);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : !Intrinsics.areEqual((Object)self.format, (Object)"MP3")) {
            output.encodeStringElement(serialDesc, 6, self.format);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.downloadTime != System.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 7, self.downloadTime);
        }
    }

    public /* synthetic */ OfflineTrackMetadata(int seen0, String id2, String title, List artists, String album, String coverUrl, Long durationMs, String format, long downloadTime, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.artists = artists;
        this.album = (seen0 & 8) == 0 ? null : album;
        this.coverUrl = (seen0 & 0x10) == 0 ? null : coverUrl;
        this.durationMs = (seen0 & 0x20) == 0 ? null : durationMs;
        this.format = (seen0 & 0x40) == 0 ? "MP3" : format;
        this.downloadTime = (seen0 & 0x80) == 0 ? System.currentTimeMillis() : downloadTime;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/desktop/download/OfflineTrackMetadata$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/desktop/download/OfflineTrackMetadata;", "desktopApp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<OfflineTrackMetadata> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

