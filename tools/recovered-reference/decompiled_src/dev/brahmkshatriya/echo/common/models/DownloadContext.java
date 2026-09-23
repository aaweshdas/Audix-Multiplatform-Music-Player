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
 *  kotlinx.serialization.internal.IntSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.DownloadContext$;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.Track$;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u00c6\u0003J:\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2={"Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "", "extensionId", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "sortOrder", "", "context", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Integer;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Integer;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExtensionId", "()Ljava/lang/String;", "getTrack", "()Ldev/brahmkshatriya/echo/common/models/Track;", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContext", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track;Ljava/lang/Integer;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;)Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class DownloadContext {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String extensionId;
    @NotNull
    private final Track track;
    @Nullable
    private final Integer sortOrder;
    @Nullable
    private final EchoMediaItem context;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public DownloadContext(@NotNull String extensionId, @NotNull Track track2, @Nullable Integer sortOrder, @Nullable EchoMediaItem context) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        this.extensionId = extensionId;
        this.track = track2;
        this.sortOrder = sortOrder;
        this.context = context;
    }

    public /* synthetic */ DownloadContext(String string2, Track track2, Integer n, EchoMediaItem echoMediaItem, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            n = null;
        }
        if ((n2 & 8) != 0) {
            echoMediaItem = null;
        }
        this(string2, track2, n, echoMediaItem);
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
    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    @Nullable
    public final EchoMediaItem getContext() {
        return this.context;
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
    public final Integer component3() {
        return this.sortOrder;
    }

    @Nullable
    public final EchoMediaItem component4() {
        return this.context;
    }

    @NotNull
    public final DownloadContext copy(@NotNull String extensionId, @NotNull Track track2, @Nullable Integer sortOrder, @Nullable EchoMediaItem context) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
        return new DownloadContext(extensionId, track2, sortOrder, context);
    }

    public static /* synthetic */ DownloadContext copy$default(DownloadContext downloadContext, String string2, Track track2, Integer n, EchoMediaItem echoMediaItem, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = downloadContext.extensionId;
        }
        if ((n2 & 2) != 0) {
            track2 = downloadContext.track;
        }
        if ((n2 & 4) != 0) {
            n = downloadContext.sortOrder;
        }
        if ((n2 & 8) != 0) {
            echoMediaItem = downloadContext.context;
        }
        return downloadContext.copy(string2, track2, n, echoMediaItem);
    }

    @NotNull
    public String toString() {
        return "DownloadContext(extensionId=" + this.extensionId + ", track=" + this.track + ", sortOrder=" + this.sortOrder + ", context=" + this.context + ")";
    }

    public int hashCode() {
        int result2 = this.extensionId.hashCode();
        result2 = result2 * 31 + this.track.hashCode();
        result2 = result2 * 31 + (this.sortOrder == null ? 0 : ((Object)this.sortOrder).hashCode());
        result2 = result2 * 31 + (this.context == null ? 0 : this.context.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadContext)) {
            return false;
        }
        DownloadContext downloadContext = (DownloadContext)other;
        if (!Intrinsics.areEqual((Object)this.extensionId, (Object)downloadContext.extensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.track, (Object)downloadContext.track)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.sortOrder, (Object)downloadContext.sortOrder)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.context, (Object)downloadContext.context);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(DownloadContext self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.extensionId);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)Track$.serializer.INSTANCE, (Object)self.track);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.sortOrder != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)IntSerializer.INSTANCE, (Object)self.sortOrder);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.context != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.context);
        }
    }

    public /* synthetic */ DownloadContext(int seen0, String extensionId, Track track2, Integer sortOrder, EchoMediaItem context, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.extensionId = extensionId;
        this.track = track2;
        this.sortOrder = (seen0 & 4) == 0 ? null : sortOrder;
        this.context = (seen0 & 8) == 0 ? null : context;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EchoMediaItem.Companion.serializer())};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/DownloadContext$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<DownloadContext> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

