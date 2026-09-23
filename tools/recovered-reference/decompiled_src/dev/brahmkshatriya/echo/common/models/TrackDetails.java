/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.Track$;
import dev.brahmkshatriya.echo.common.models.TrackDetails$;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000b\u0010\fBK\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\tH\u00c6\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJD\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u000eH\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001\u00a2\u0006\u0002\b0R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00063"}, d2={"Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "", "extensionId", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "context", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "currentPosition", "", "totalDuration", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;JLjava/lang/Long;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;JLjava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExtensionId", "()Ljava/lang/String;", "getTrack", "()Ldev/brahmkshatriya/echo/common/models/Track;", "getContext", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getCurrentPosition", "()J", "getTotalDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;JLjava/lang/Long;)Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class TrackDetails {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String extensionId;
    @NotNull
    private final Track track;
    @Nullable
    private final EchoMediaItem context;
    private final long currentPosition;
    @Nullable
    private final Long totalDuration;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public TrackDetails(@NotNull String extensionId, @NotNull Track track2, @Nullable EchoMediaItem context, long currentPosition, @Nullable Long totalDuration) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        this.extensionId = extensionId;
        this.track = track2;
        this.context = context;
        this.currentPosition = currentPosition;
        this.totalDuration = totalDuration;
    }

    @NotNull
    public final String getExtensionId() {
        return this.extensionId;
    }

    @NotNull
    public final Track getTrack() {
        return this.track;
    }

    @Nullable
    public final EchoMediaItem getContext() {
        return this.context;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    @Nullable
    public final Long getTotalDuration() {
        return this.totalDuration;
    }

    @NotNull
    public final String component1() {
        return this.extensionId;
    }

    @NotNull
    public final Track component2() {
        return this.track;
    }

    @Nullable
    public final EchoMediaItem component3() {
        return this.context;
    }

    public final long component4() {
        return this.currentPosition;
    }

    @Nullable
    public final Long component5() {
        return this.totalDuration;
    }

    @NotNull
    public final TrackDetails copy(@NotNull String extensionId, @NotNull Track track2, @Nullable EchoMediaItem context, long currentPosition, @Nullable Long totalDuration) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        return new TrackDetails(extensionId, track2, context, currentPosition, totalDuration);
    }

    public static /* synthetic */ TrackDetails copy$default(TrackDetails trackDetails, String string2, Track track2, EchoMediaItem echoMediaItem, long l, Long l2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = trackDetails.extensionId;
        }
        if ((n & 2) != 0) {
            track2 = trackDetails.track;
        }
        if ((n & 4) != 0) {
            echoMediaItem = trackDetails.context;
        }
        if ((n & 8) != 0) {
            l = trackDetails.currentPosition;
        }
        if ((n & 0x10) != 0) {
            l2 = trackDetails.totalDuration;
        }
        return trackDetails.copy(string2, track2, echoMediaItem, l, l2);
    }

    @NotNull
    public String toString() {
        return "TrackDetails(extensionId=" + this.extensionId + ", track=" + this.track + ", context=" + this.context + ", currentPosition=" + this.currentPosition + ", totalDuration=" + this.totalDuration + ")";
    }

    public int hashCode() {
        int result2 = this.extensionId.hashCode();
        result2 = result2 * 31 + this.track.hashCode();
        result2 = result2 * 31 + (this.context == null ? 0 : this.context.hashCode());
        result2 = result2 * 31 + Long.hashCode(this.currentPosition);
        result2 = result2 * 31 + (this.totalDuration == null ? 0 : ((Object)this.totalDuration).hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDetails)) {
            return false;
        }
        TrackDetails trackDetails = (TrackDetails)other;
        if (!Intrinsics.areEqual((Object)this.extensionId, (Object)trackDetails.extensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track, (Object)trackDetails.track)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.context, (Object)trackDetails.context)) {
            return false;
        }
        if (this.currentPosition != trackDetails.currentPosition) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.totalDuration, (Object)trackDetails.totalDuration);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(TrackDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.extensionId);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)Track$.serializer.INSTANCE, (Object)self.track);
        output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.context);
        output.encodeLongElement(serialDesc, 3, self.currentPosition);
        output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.totalDuration);
    }

    public /* synthetic */ TrackDetails(int seen0, String extensionId, Track track2, EchoMediaItem context, long currentPosition, Long totalDuration, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (0x1F & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)31, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.extensionId = extensionId;
        this.track = track2;
        this.context = context;
        this.currentPosition = currentPosition;
        this.totalDuration = totalDuration;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EchoMediaItem.Companion.serializer()), null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/TrackDetails$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<TrackDetails> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

