/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.Transient
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.JsonClassDiscriminator
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.NetworkRequest$;
import dev.brahmkshatriya.echo.common.models.Streamable$;
import dev.brahmkshatriya.echo.common.models.Streamable$Decryption$Widevine$;
import dev.brahmkshatriya.echo.common.models.Streamable$Media$Background$;
import dev.brahmkshatriya.echo.common.models.Streamable$Media$Server$;
import dev.brahmkshatriya.echo.common.models.Streamable$Media$Subtitle$;
import dev.brahmkshatriya.echo.common.models.Streamable$Source$Http$;
import dev.brahmkshatriya.echo.common.models.Streamable$Source$Raw$;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0087\b\u0018\u0000 12\u00020\u0001:\t-./012345BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\u0004\b\u000b\u0010\fBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001\u00a2\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00066"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable;", "", "id", "", "quality", "", "type", "Ldev/brahmkshatriya/echo/common/models/Streamable$MediaType;", "title", "extras", "", "<init>", "(Ljava/lang/String;ILdev/brahmkshatriya/echo/common/models/Streamable$MediaType;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILdev/brahmkshatriya/echo/common/models/Streamable$MediaType;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getQuality", "()I", "getType", "()Ldev/brahmkshatriya/echo/common/models/Streamable$MediaType;", "getTitle", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Media", "Decryption", "Source", "InputProvider", "Companion", "MediaType", "SubtitleType", "SourceType", "$serializer", "common"})
public final class Streamable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    private final int quality;
    @NotNull
    private final MediaType type;
    @Nullable
    private final String title;
    @NotNull
    private final Map<String, String> extras;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Streamable(@NotNull String id2, int quality, @NotNull MediaType type, @Nullable String title, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.quality = quality;
        this.type = type;
        this.title = title;
        this.extras = extras;
    }

    public /* synthetic */ Streamable(String string2, int n, MediaType mediaType, String string3, Map map2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 8) != 0) {
            string3 = null;
        }
        if ((n2 & 0x10) != 0) {
            map2 = MapsKt.emptyMap();
        }
        this(string2, n, mediaType, string3, map2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getQuality() {
        return this.quality;
    }

    @NotNull
    public final MediaType getType() {
        return this.type;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final Map<String, String> getExtras() {
        return this.extras;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.quality;
    }

    @NotNull
    public final MediaType component3() {
        return this.type;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.extras;
    }

    @NotNull
    public final Streamable copy(@NotNull String id2, int quality, @NotNull MediaType type, @Nullable String title, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Streamable(id2, quality, type, title, extras);
    }

    public static /* synthetic */ Streamable copy$default(Streamable streamable, String string2, int n, MediaType mediaType, String string3, Map map2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = streamable.id;
        }
        if ((n2 & 2) != 0) {
            n = streamable.quality;
        }
        if ((n2 & 4) != 0) {
            mediaType = streamable.type;
        }
        if ((n2 & 8) != 0) {
            string3 = streamable.title;
        }
        if ((n2 & 0x10) != 0) {
            map2 = streamable.extras;
        }
        return streamable.copy(string2, n, mediaType, string3, map2);
    }

    @NotNull
    public String toString() {
        return "Streamable(id=" + this.id + ", quality=" + this.quality + ", type=" + this.type + ", title=" + this.title + ", extras=" + this.extras + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + Integer.hashCode(this.quality);
        result2 = result2 * 31 + this.type.hashCode();
        result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Streamable)) {
            return false;
        }
        Streamable streamable = (Streamable)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)streamable.id)) {
            return false;
        }
        if (this.quality != streamable.quality) {
            return false;
        }
        if (this.type != streamable.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)streamable.title)) {
            return false;
        }
        return Intrinsics.areEqual(this.extras, streamable.extras);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Streamable self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeIntElement(serialDesc, 1, self.quality);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.type);
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.extras, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.extras);
        }
    }

    public /* synthetic */ Streamable(int seen0, String id2, int quality, MediaType type, String title, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.quality = quality;
        this.type = type;
        this.title = (seen0 & 8) == 0 ? null : title;
        this.extras = (seen0 & 0x10) == 0 ? MapsKt.emptyMap() : extras;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Streamable.MediaType", (Enum[])MediaType.values())), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fJ8\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fJ0\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Companion;", "", "<init>", "()V", "server", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "id", "", "quality", "", "title", "extras", "", "background", "subtitle", "serializer", "Lkotlinx/serialization/KSerializer;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Streamable server(@NotNull String id2, int quality, @Nullable String title, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return new Streamable(id2, quality, MediaType.Server, title, extras);
        }

        public static /* synthetic */ Streamable server$default(Companion companion, String string2, int n, String string3, Map map2, int n2, Object object) {
            if ((n2 & 4) != 0) {
                string3 = null;
            }
            if ((n2 & 8) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.server(string2, n, string3, map2);
        }

        @NotNull
        public final Streamable background(@NotNull String id2, int quality, @Nullable String title, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return new Streamable(id2, quality, MediaType.Background, title, extras);
        }

        public static /* synthetic */ Streamable background$default(Companion companion, String string2, int n, String string3, Map map2, int n2, Object object) {
            if ((n2 & 4) != 0) {
                string3 = null;
            }
            if ((n2 & 8) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.background(string2, n, string3, map2);
        }

        @NotNull
        public final Streamable subtitle(@NotNull String id2, @Nullable String title, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return new Streamable(id2, 0, MediaType.Subtitle, title, extras);
        }

        public static /* synthetic */ Streamable subtitle$default(Companion companion, String string2, String string3, Map map2, int n, Object object) {
            if ((n & 2) != 0) {
                string3 = null;
            }
            if ((n & 4) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.subtitle(string2, string3, map2);
        }

        @NotNull
        public final KSerializer<Streamable> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @JsonClassDiscriminator(discriminator="decryptionType")
    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u0082\u0001\u0001\u0012\u00a8\u0006\u0013"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Widevine", "Companion", "Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption$Widevine;", "common"})
    public static abstract sealed class Decryption {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
            Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Widevine.class)};
            KClass[] kClassArray = objectArray;
            objectArray = new KSerializer[]{Decryption$Widevine$$serializer.INSTANCE};
            KClass[] kClassArray2 = objectArray;
            objectArray = new Annotation[]{new JsonClassDiscriminator("decryptionType"){
                private final /* synthetic */ String discriminator;
                {
                    Intrinsics.checkNotNullParameter((Object)discriminator, (String)"discriminator");
                    this.discriminator = discriminator;
                }

                public final /* synthetic */ String discriminator() {
                    return this.discriminator;
                }

                public final boolean equals(@Nullable Object other) {
                    if (!(other instanceof JsonClassDiscriminator)) {
                        return false;
                    }
                    JsonClassDiscriminator jsonClassDiscriminator = (JsonClassDiscriminator)other;
                    return Intrinsics.areEqual((Object)((JsonClassDiscriminator)this).discriminator(), (Object)jsonClassDiscriminator.discriminator());
                }

                public final int hashCode() {
                    return "discriminator".hashCode() * 127 ^ this.discriminator.hashCode();
                }

                @NotNull
                public final String toString() {
                    return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ")";
                }

                public final /* synthetic */ Class annotationType() {
                    return JsonClassDiscriminator.class;
                }
            }};
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Streamable.Decryption", Reflection.getOrCreateKotlinClass(Decryption.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
        });

        private Decryption() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(Decryption self, CompositeEncoder output, SerialDescriptor serialDesc) {
        }

        public /* synthetic */ Decryption(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
        }

        public /* synthetic */ Decryption(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Decryption> serializer() {
                return this.get$cachedSerializer();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001\u00a2\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f\u00a8\u0006#"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption$Widevine;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;", "license", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "isMultiSession", "", "<init>", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/NetworkRequest;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLicense", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Widevine
        extends Decryption {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final NetworkRequest license;
            private final boolean isMultiSession;

            public Widevine(@NotNull NetworkRequest license, boolean isMultiSession) {
                Intrinsics.checkNotNullParameter((Object)license, (String)"license");
                super(null);
                this.license = license;
                this.isMultiSession = isMultiSession;
            }

            @NotNull
            public final NetworkRequest getLicense() {
                return this.license;
            }

            public final boolean isMultiSession() {
                return this.isMultiSession;
            }

            @NotNull
            public final NetworkRequest component1() {
                return this.license;
            }

            public final boolean component2() {
                return this.isMultiSession;
            }

            @NotNull
            public final Widevine copy(@NotNull NetworkRequest license, boolean isMultiSession) {
                Intrinsics.checkNotNullParameter((Object)license, (String)"license");
                return new Widevine(license, isMultiSession);
            }

            public static /* synthetic */ Widevine copy$default(Widevine widevine, NetworkRequest networkRequest, boolean bl, int n, Object object) {
                if ((n & 1) != 0) {
                    networkRequest = widevine.license;
                }
                if ((n & 2) != 0) {
                    bl = widevine.isMultiSession;
                }
                return widevine.copy(networkRequest, bl);
            }

            @NotNull
            public String toString() {
                return "Widevine(license=" + this.license + ", isMultiSession=" + this.isMultiSession + ")";
            }

            public int hashCode() {
                int result2 = this.license.hashCode();
                result2 = result2 * 31 + Boolean.hashCode(this.isMultiSession);
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Widevine)) {
                    return false;
                }
                Widevine widevine = (Widevine)other;
                if (!Intrinsics.areEqual((Object)this.license, (Object)widevine.license)) {
                    return false;
                }
                return this.isMultiSession == widevine.isMultiSession;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Widevine self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Decryption.write$Self(self, output, serialDesc);
                output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)NetworkRequest$.serializer.INSTANCE, (Object)self.license);
                output.encodeBooleanElement(serialDesc, 1, self.isMultiSession);
            }

            public /* synthetic */ Widevine(int seen0, NetworkRequest license, boolean isMultiSession, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (3 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Decryption$Widevine$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.license = license;
                this.isMultiSession = isMultiSession;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption$Widevine$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption$Widevine;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Widevine> serializer() {
                    return (KSerializer)Decryption$Widevine$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$InputProvider;", "", "provide", "Lkotlin/Pair;", "Ljava/io/InputStream;", "", "position", "length", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    public static interface InputProvider {
        @Nullable
        public Object provide(long var1, long var3, @NotNull Continuation<? super Pair<? extends InputStream, Long>> var5);
    }

    @JsonClassDiscriminator(discriminator="mediaType")
    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00132\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u0082\u0001\u0003\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Subtitle", "Server", "Background", "Companion", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Background;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Subtitle;", "common"})
    public static abstract sealed class Media {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
            Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Background.class), Reflection.getOrCreateKotlinClass(Server.class), Reflection.getOrCreateKotlinClass(Subtitle.class)};
            KClass[] kClassArray = objectArray;
            objectArray = new KSerializer[]{Media$Background$$serializer.INSTANCE, Media$Server$$serializer.INSTANCE, Media$Subtitle$$serializer.INSTANCE};
            KClass[] kClassArray2 = objectArray;
            objectArray = new Annotation[]{new /* invalid duplicate definition of identical inner class */};
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Streamable.Media", Reflection.getOrCreateKotlinClass(Media.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
        });

        private Media() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(Media self, CompositeEncoder output, SerialDescriptor serialDesc) {
        }

        public /* synthetic */ Media(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
        }

        public /* synthetic */ Media(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001\u00a2\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006 "}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Background;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "request", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "<init>", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/NetworkRequest;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequest", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Background
        extends Media {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final NetworkRequest request;

            public Background(@NotNull NetworkRequest request) {
                Intrinsics.checkNotNullParameter((Object)request, (String)"request");
                super(null);
                this.request = request;
            }

            @NotNull
            public final NetworkRequest getRequest() {
                return this.request;
            }

            @NotNull
            public final NetworkRequest component1() {
                return this.request;
            }

            @NotNull
            public final Background copy(@NotNull NetworkRequest request) {
                Intrinsics.checkNotNullParameter((Object)request, (String)"request");
                return new Background(request);
            }

            public static /* synthetic */ Background copy$default(Background background2, NetworkRequest networkRequest, int n, Object object) {
                if ((n & 1) != 0) {
                    networkRequest = background2.request;
                }
                return background2.copy(networkRequest);
            }

            @NotNull
            public String toString() {
                return "Background(request=" + this.request + ")";
            }

            public int hashCode() {
                return this.request.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Background)) {
                    return false;
                }
                Background background2 = (Background)other;
                return Intrinsics.areEqual((Object)this.request, (Object)background2.request);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Background self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Media.write$Self(self, output, serialDesc);
                output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)NetworkRequest$.serializer.INSTANCE, (Object)self.request);
            }

            public /* synthetic */ Background(int seen0, NetworkRequest request, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (1 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Media$Background$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.request = request;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Background$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Background;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Background> serializer() {
                    return (KSerializer)Media$Background$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J \u0010\u0007\u001a\u00020\b*\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000bJ4\u0010\f\u001a\u00020\u0005*\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\t2\u0006\u0010\r\u001a\u00020\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Companion;", "", "<init>", "()V", "toMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "toBackgroundMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Background;", "", "headers", "", "toServerMedia", "type", "Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;", "isVideo", "", "toSubtitleMedia", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Subtitle;", "Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Server toMedia(@NotNull Source $this$toMedia) {
                Intrinsics.checkNotNullParameter((Object)$this$toMedia, (String)"<this>");
                return new Server(CollectionsKt.listOf((Object)$this$toMedia), false);
            }

            @NotNull
            public final Background toBackgroundMedia(@NotNull String $this$toBackgroundMedia, @NotNull Map<String, String> headers) {
                Intrinsics.checkNotNullParameter((Object)$this$toBackgroundMedia, (String)"<this>");
                Intrinsics.checkNotNullParameter(headers, (String)"headers");
                return new Background(NetworkRequest.Companion.toGetRequest($this$toBackgroundMedia, headers));
            }

            public static /* synthetic */ Background toBackgroundMedia$default(Companion companion, String string2, Map map2, int n, Object object) {
                if ((n & 1) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                return companion.toBackgroundMedia(string2, map2);
            }

            @NotNull
            public final Server toServerMedia(@NotNull String $this$toServerMedia, @NotNull Map<String, String> headers, @NotNull SourceType type, boolean isVideo) {
                Intrinsics.checkNotNullParameter((Object)$this$toServerMedia, (String)"<this>");
                Intrinsics.checkNotNullParameter(headers, (String)"headers");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return this.toMedia(Source.Companion.toSource$default(Source.Companion, $this$toServerMedia, headers, type, isVideo, false, 8, null));
            }

            public static /* synthetic */ Server toServerMedia$default(Companion companion, String string2, Map map2, SourceType sourceType, boolean bl, int n, Object object) {
                if ((n & 1) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                if ((n & 2) != 0) {
                    sourceType = SourceType.Progressive;
                }
                if ((n & 4) != 0) {
                    bl = false;
                }
                return companion.toServerMedia(string2, map2, sourceType, bl);
            }

            @NotNull
            public final Subtitle toSubtitleMedia(@NotNull String $this$toSubtitleMedia, @NotNull SubtitleType type) {
                Intrinsics.checkNotNullParameter((Object)$this$toSubtitleMedia, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return new Subtitle($this$toSubtitleMedia, type);
            }

            @NotNull
            public final KSerializer<Media> serializer() {
                return this.get$cachedSerializer();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001\u00a2\u0006\u0002\b\"R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "sources", "", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "merged", "", "<init>", "(Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSources", "()Ljava/util/List;", "getMerged", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Server
        extends Media {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final List<Source> sources;
            private final boolean merged;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Server(@NotNull List<? extends Source> sources2, boolean merged) {
                Intrinsics.checkNotNullParameter(sources2, (String)"sources");
                super(null);
                this.sources = sources2;
                this.merged = merged;
            }

            @NotNull
            public final List<Source> getSources() {
                return this.sources;
            }

            public final boolean getMerged() {
                return this.merged;
            }

            @NotNull
            public final List<Source> component1() {
                return this.sources;
            }

            public final boolean component2() {
                return this.merged;
            }

            @NotNull
            public final Server copy(@NotNull List<? extends Source> sources2, boolean merged) {
                Intrinsics.checkNotNullParameter(sources2, (String)"sources");
                return new Server(sources2, merged);
            }

            public static /* synthetic */ Server copy$default(Server server2, List list2, boolean bl, int n, Object object) {
                if ((n & 1) != 0) {
                    list2 = server2.sources;
                }
                if ((n & 2) != 0) {
                    bl = server2.merged;
                }
                return server2.copy(list2, bl);
            }

            @NotNull
            public String toString() {
                return "Server(sources=" + this.sources + ", merged=" + this.merged + ")";
            }

            public int hashCode() {
                int result2 = ((Object)this.sources).hashCode();
                result2 = result2 * 31 + Boolean.hashCode(this.merged);
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Server)) {
                    return false;
                }
                Server server2 = (Server)other;
                if (!Intrinsics.areEqual(this.sources, server2.sources)) {
                    return false;
                }
                return this.merged == server2.merged;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Server self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Media.write$Self(self, output, serialDesc);
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), self.sources);
                output.encodeBooleanElement(serialDesc, 1, self.merged);
            }

            public /* synthetic */ Server(int seen0, List sources2, boolean merged, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (3 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Media$Server$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.sources = sources2;
                this.merged = merged;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer(Source.Companion.serializer())), null};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Server;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Server> serializer() {
                    return (KSerializer)Media$Server$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001\u00a2\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Subtitle;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media;", "url", "", "type", "Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getType", "()Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Subtitle
        extends Media {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final String url;
            @NotNull
            private final SubtitleType type;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Subtitle(@NotNull String url, @NotNull SubtitleType type) {
                Intrinsics.checkNotNullParameter((Object)url, (String)"url");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                super(null);
                this.url = url;
                this.type = type;
            }

            @NotNull
            public final String getUrl() {
                return this.url;
            }

            @NotNull
            public final SubtitleType getType() {
                return this.type;
            }

            @NotNull
            public final String component1() {
                return this.url;
            }

            @NotNull
            public final SubtitleType component2() {
                return this.type;
            }

            @NotNull
            public final Subtitle copy(@NotNull String url, @NotNull SubtitleType type) {
                Intrinsics.checkNotNullParameter((Object)url, (String)"url");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return new Subtitle(url, type);
            }

            public static /* synthetic */ Subtitle copy$default(Subtitle subtitle2, String string2, SubtitleType subtitleType, int n, Object object) {
                if ((n & 1) != 0) {
                    string2 = subtitle2.url;
                }
                if ((n & 2) != 0) {
                    subtitleType = subtitle2.type;
                }
                return subtitle2.copy(string2, subtitleType);
            }

            @NotNull
            public String toString() {
                return "Subtitle(url=" + this.url + ", type=" + this.type + ")";
            }

            public int hashCode() {
                int result2 = this.url.hashCode();
                result2 = result2 * 31 + this.type.hashCode();
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Subtitle)) {
                    return false;
                }
                Subtitle subtitle2 = (Subtitle)other;
                if (!Intrinsics.areEqual((Object)this.url, (Object)subtitle2.url)) {
                    return false;
                }
                return this.type == subtitle2.type;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Subtitle self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Media.write$Self(self, output, serialDesc);
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.url);
                output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)lazyArray[1].getValue(), (Object)self.type);
            }

            public /* synthetic */ Subtitle(int seen0, String url, SubtitleType type, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (3 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Media$Subtitle$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.url = url;
                this.type = type;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Streamable.SubtitleType", (Enum[])SubtitleType.values()))};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Subtitle$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Media$Subtitle;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Subtitle> serializer() {
                    return (KSerializer)Media$Subtitle$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "Background", "Server", "Subtitle", "common"})
    public static final class MediaType
    extends Enum<MediaType> {
        public static final /* enum */ MediaType Background = new MediaType();
        public static final /* enum */ MediaType Server = new MediaType();
        public static final /* enum */ MediaType Subtitle = new MediaType();
        private static final /* synthetic */ MediaType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static MediaType[] values() {
            return (MediaType[])$VALUES.clone();
        }

        public static MediaType valueOf(String value2) {
            return Enum.valueOf(MediaType.class, value2);
        }

        @NotNull
        public static EnumEntries<MediaType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = mediaTypeArray = new MediaType[]{MediaType.Background, MediaType.Server, MediaType.Subtitle};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @JsonClassDiscriminator(discriminator="sourceType")
    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u0012\u0010\t\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014\u0082\u0001\u0002 !\u00a8\u0006\""}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "id", "", "getId", "()Ljava/lang/String;", "quality", "getQuality", "()I", "title", "getTitle", "isVideo", "", "()Z", "isLive", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Http", "Raw", "Companion", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Http;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Raw;", "common"})
    public static abstract sealed class Source {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
            Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Http.class), Reflection.getOrCreateKotlinClass(Raw.class)};
            KClass[] kClassArray = objectArray;
            objectArray = new KSerializer[]{Source$Http$$serializer.INSTANCE, Source$Raw$$serializer.INSTANCE};
            KClass[] kClassArray2 = objectArray;
            objectArray = new Annotation[]{new /* invalid duplicate definition of identical inner class */};
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Streamable.Source", Reflection.getOrCreateKotlinClass(Source.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
        });

        private Source() {
        }

        @NotNull
        public abstract String getId();

        public abstract int getQuality();

        @Nullable
        public abstract String getTitle();

        public abstract boolean isVideo();

        public abstract boolean isLive();

        @JvmStatic
        public static final /* synthetic */ void write$Self(Source self, CompositeEncoder output, SerialDescriptor serialDesc) {
        }

        public /* synthetic */ Source(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
        }

        public /* synthetic */ Source(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fJ&\u0010\u0004\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Companion;", "", "<init>", "()V", "toSource", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Http;", "", "headers", "", "type", "Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;", "isVideo", "", "isLive", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Raw;", "Ldev/brahmkshatriya/echo/common/models/Streamable$InputProvider;", "id", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Http toSource(@NotNull String $this$toSource, @NotNull Map<String, String> headers, @NotNull SourceType type, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)$this$toSource, (String)"<this>");
                Intrinsics.checkNotNullParameter(headers, (String)"headers");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return new Http(NetworkRequest.Companion.toGetRequest($this$toSource, headers), type, null, 0, null, isVideo, isLive, 28, null);
            }

            public static /* synthetic */ Http toSource$default(Companion companion, String string2, Map map2, SourceType sourceType, boolean bl, boolean bl2, int n, Object object) {
                if ((n & 1) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                if ((n & 2) != 0) {
                    sourceType = SourceType.Progressive;
                }
                if ((n & 4) != 0) {
                    bl = false;
                }
                if ((n & 8) != 0) {
                    bl2 = false;
                }
                return companion.toSource(string2, map2, sourceType, bl, bl2);
            }

            @NotNull
            public final Raw toSource(@NotNull InputProvider $this$toSource, @NotNull String id2, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)$this$toSource, (String)"<this>");
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                return new Raw($this$toSource, id2, 0, null, isVideo, isLive, 12, null);
            }

            public static /* synthetic */ Raw toSource$default(Companion companion, InputProvider inputProvider, String string2, boolean bl, boolean bl2, int n, Object object) {
                if ((n & 2) != 0) {
                    bl = false;
                }
                if ((n & 4) != 0) {
                    bl2 = false;
                }
                return companion.toSource(inputProvider, string2, bl, bl2);
            }

            @NotNull
            public final KSerializer<Source> serializer() {
                return this.get$cachedSerializer();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010Be\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u000f\u0010\u0015J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010'\u001a\u00020\rH\u00c6\u0003J\t\u0010(\u001a\u00020\rH\u00c6\u0003JS\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u00c6\u0001J\u0013\u0010*\u001a\u00020\r2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\tH\u00d6\u0001J\t\u0010.\u001a\u00020\u000bH\u00d6\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001\u00a2\u0006\u0002\b6R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010 R\u0014\u0010\u000e\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010 R\u0014\u0010\u0012\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f\u00a8\u00069"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Http;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "request", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "type", "Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;", "decryption", "Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;", "quality", "", "title", "", "isVideo", "", "isLive", "<init>", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;ILjava/lang/String;ZZ)V", "seen0", "id", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/NetworkRequest;Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;ILjava/lang/String;ZZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequest", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "getType", "()Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;", "getDecryption", "()Ldev/brahmkshatriya/echo/common/models/Streamable$Decryption;", "getQuality", "()I", "getTitle", "()Ljava/lang/String;", "()Z", "getId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Http
        extends Source {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final NetworkRequest request;
            @NotNull
            private final SourceType type;
            @Nullable
            private final Decryption decryption;
            private final int quality;
            @Nullable
            private final String title;
            private final boolean isVideo;
            private final boolean isLive;
            @NotNull
            private final String id;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Http(@NotNull NetworkRequest request, @NotNull SourceType type, @Nullable Decryption decryption, int quality, @Nullable String title, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)request, (String)"request");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                super(null);
                this.request = request;
                this.type = type;
                this.decryption = decryption;
                this.quality = quality;
                this.title = title;
                this.isVideo = isVideo;
                this.isLive = isLive;
                this.id = this.request.getUrl();
            }

            public /* synthetic */ Http(NetworkRequest networkRequest, SourceType sourceType, Decryption decryption, int n, String string2, boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n2 & 2) != 0) {
                    sourceType = SourceType.Progressive;
                }
                if ((n2 & 4) != 0) {
                    decryption = null;
                }
                if ((n2 & 8) != 0) {
                    n = 0;
                }
                if ((n2 & 0x10) != 0) {
                    string2 = null;
                }
                if ((n2 & 0x20) != 0) {
                    bl = false;
                }
                if ((n2 & 0x40) != 0) {
                    bl2 = false;
                }
                this(networkRequest, sourceType, decryption, n, string2, bl, bl2);
            }

            @NotNull
            public final NetworkRequest getRequest() {
                return this.request;
            }

            @NotNull
            public final SourceType getType() {
                return this.type;
            }

            @Nullable
            public final Decryption getDecryption() {
                return this.decryption;
            }

            @Override
            public int getQuality() {
                return this.quality;
            }

            @Override
            @Nullable
            public String getTitle() {
                return this.title;
            }

            @Override
            public boolean isVideo() {
                return this.isVideo;
            }

            @Override
            public boolean isLive() {
                return this.isLive;
            }

            @Override
            @NotNull
            public String getId() {
                return this.id;
            }

            @NotNull
            public final NetworkRequest component1() {
                return this.request;
            }

            @NotNull
            public final SourceType component2() {
                return this.type;
            }

            @Nullable
            public final Decryption component3() {
                return this.decryption;
            }

            public final int component4() {
                return this.quality;
            }

            @Nullable
            public final String component5() {
                return this.title;
            }

            public final boolean component6() {
                return this.isVideo;
            }

            public final boolean component7() {
                return this.isLive;
            }

            @NotNull
            public final Http copy(@NotNull NetworkRequest request, @NotNull SourceType type, @Nullable Decryption decryption, int quality, @Nullable String title, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)request, (String)"request");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                return new Http(request, type, decryption, quality, title, isVideo, isLive);
            }

            public static /* synthetic */ Http copy$default(Http http, NetworkRequest networkRequest, SourceType sourceType, Decryption decryption, int n, String string2, boolean bl, boolean bl2, int n2, Object object) {
                if ((n2 & 1) != 0) {
                    networkRequest = http.request;
                }
                if ((n2 & 2) != 0) {
                    sourceType = http.type;
                }
                if ((n2 & 4) != 0) {
                    decryption = http.decryption;
                }
                if ((n2 & 8) != 0) {
                    n = http.quality;
                }
                if ((n2 & 0x10) != 0) {
                    string2 = http.title;
                }
                if ((n2 & 0x20) != 0) {
                    bl = http.isVideo;
                }
                if ((n2 & 0x40) != 0) {
                    bl2 = http.isLive;
                }
                return http.copy(networkRequest, sourceType, decryption, n, string2, bl, bl2);
            }

            @NotNull
            public String toString() {
                return "Http(request=" + this.request + ", type=" + this.type + ", decryption=" + this.decryption + ", quality=" + this.quality + ", title=" + this.title + ", isVideo=" + this.isVideo + ", isLive=" + this.isLive + ")";
            }

            public int hashCode() {
                int result2 = this.request.hashCode();
                result2 = result2 * 31 + this.type.hashCode();
                result2 = result2 * 31 + (this.decryption == null ? 0 : this.decryption.hashCode());
                result2 = result2 * 31 + Integer.hashCode(this.quality);
                result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
                result2 = result2 * 31 + Boolean.hashCode(this.isVideo);
                result2 = result2 * 31 + Boolean.hashCode(this.isLive);
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Http)) {
                    return false;
                }
                Http http = (Http)other;
                if (!Intrinsics.areEqual((Object)this.request, (Object)http.request)) {
                    return false;
                }
                if (this.type != http.type) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.decryption, (Object)http.decryption)) {
                    return false;
                }
                if (this.quality != http.quality) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.title, (Object)http.title)) {
                    return false;
                }
                if (this.isVideo != http.isVideo) {
                    return false;
                }
                return this.isLive == http.isLive;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Http self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Source.write$Self(self, output, serialDesc);
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)NetworkRequest$.serializer.INSTANCE, (Object)self.request);
                if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.type != SourceType.Progressive) {
                    output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)lazyArray[1].getValue(), (Object)self.type);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.decryption != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.decryption);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getQuality() != 0) {
                    output.encodeIntElement(serialDesc, 3, self.getQuality());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getTitle() != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getTitle());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.isVideo()) {
                    output.encodeBooleanElement(serialDesc, 5, self.isVideo());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.isLive()) {
                    output.encodeBooleanElement(serialDesc, 6, self.isLive());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : !Intrinsics.areEqual((Object)self.getId(), (Object)self.request.getUrl())) {
                    output.encodeStringElement(serialDesc, 7, self.getId());
                }
            }

            public /* synthetic */ Http(int seen0, NetworkRequest request, SourceType type, Decryption decryption, int quality, String title, boolean isVideo, boolean isLive, String id2, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (1 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Source$Http$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.request = request;
                this.type = (seen0 & 2) == 0 ? SourceType.Progressive : type;
                this.decryption = (seen0 & 4) == 0 ? null : decryption;
                this.quality = (seen0 & 8) == 0 ? 0 : quality;
                this.title = (seen0 & 0x10) == 0 ? null : title;
                this.isVideo = (seen0 & 0x20) == 0 ? false : isVideo;
                this.isLive = (seen0 & 0x40) == 0 ? false : isLive;
                this.id = (seen0 & 0x80) == 0 ? this.request.getUrl() : id2;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Streamable.SourceType", (Enum[])SourceType.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> Decryption.Companion.serializer()), null, null, null, null, null};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Http$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Http;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Http> serializer() {
                    return (KSerializer)Source$Http$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rBG\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\f\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\nH\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003JI\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010%H\u00d6\u0003J\t\u0010&\u001a\u00020\u0007H\u00d6\u0001J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001\u00a2\u0006\u0002\b/R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001b\u00a8\u00062"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Raw;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source;", "streamProvider", "Ldev/brahmkshatriya/echo/common/models/Streamable$InputProvider;", "id", "", "quality", "", "title", "isVideo", "", "isLive", "<init>", "(Ldev/brahmkshatriya/echo/common/models/Streamable$InputProvider;Ljava/lang/String;ILjava/lang/String;ZZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStreamProvider$annotations", "()V", "getStreamProvider", "()Ldev/brahmkshatriya/echo/common/models/Streamable$InputProvider;", "getId", "()Ljava/lang/String;", "getQuality", "()I", "getTitle", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Raw
        extends Source {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @Nullable
            private final InputProvider streamProvider;
            @NotNull
            private final String id;
            private final int quality;
            @Nullable
            private final String title;
            private final boolean isVideo;
            private final boolean isLive;

            public Raw(@Nullable InputProvider streamProvider, @NotNull String id2, int quality, @Nullable String title, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                super(null);
                this.streamProvider = streamProvider;
                this.id = id2;
                this.quality = quality;
                this.title = title;
                this.isVideo = isVideo;
                this.isLive = isLive;
            }

            public /* synthetic */ Raw(InputProvider inputProvider, String string2, int n, String string3, boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n2 & 1) != 0) {
                    inputProvider = null;
                }
                if ((n2 & 4) != 0) {
                    n = 0;
                }
                if ((n2 & 8) != 0) {
                    string3 = null;
                }
                if ((n2 & 0x10) != 0) {
                    bl = false;
                }
                if ((n2 & 0x20) != 0) {
                    bl2 = false;
                }
                this(inputProvider, string2, n, string3, bl, bl2);
            }

            @Nullable
            public final InputProvider getStreamProvider() {
                return this.streamProvider;
            }

            @Transient
            public static /* synthetic */ void getStreamProvider$annotations() {
            }

            @Override
            @NotNull
            public String getId() {
                return this.id;
            }

            @Override
            public int getQuality() {
                return this.quality;
            }

            @Override
            @Nullable
            public String getTitle() {
                return this.title;
            }

            @Override
            public boolean isVideo() {
                return this.isVideo;
            }

            @Override
            public boolean isLive() {
                return this.isLive;
            }

            @Nullable
            public final InputProvider component1() {
                return this.streamProvider;
            }

            @NotNull
            public final String component2() {
                return this.id;
            }

            public final int component3() {
                return this.quality;
            }

            @Nullable
            public final String component4() {
                return this.title;
            }

            public final boolean component5() {
                return this.isVideo;
            }

            public final boolean component6() {
                return this.isLive;
            }

            @NotNull
            public final Raw copy(@Nullable InputProvider streamProvider, @NotNull String id2, int quality, @Nullable String title, boolean isVideo, boolean isLive) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                return new Raw(streamProvider, id2, quality, title, isVideo, isLive);
            }

            public static /* synthetic */ Raw copy$default(Raw raw, InputProvider inputProvider, String string2, int n, String string3, boolean bl, boolean bl2, int n2, Object object) {
                if ((n2 & 1) != 0) {
                    inputProvider = raw.streamProvider;
                }
                if ((n2 & 2) != 0) {
                    string2 = raw.id;
                }
                if ((n2 & 4) != 0) {
                    n = raw.quality;
                }
                if ((n2 & 8) != 0) {
                    string3 = raw.title;
                }
                if ((n2 & 0x10) != 0) {
                    bl = raw.isVideo;
                }
                if ((n2 & 0x20) != 0) {
                    bl2 = raw.isLive;
                }
                return raw.copy(inputProvider, string2, n, string3, bl, bl2);
            }

            @NotNull
            public String toString() {
                return "Raw(streamProvider=" + this.streamProvider + ", id=" + this.id + ", quality=" + this.quality + ", title=" + this.title + ", isVideo=" + this.isVideo + ", isLive=" + this.isLive + ")";
            }

            public int hashCode() {
                int result2 = this.streamProvider == null ? 0 : this.streamProvider.hashCode();
                result2 = result2 * 31 + this.id.hashCode();
                result2 = result2 * 31 + Integer.hashCode(this.quality);
                result2 = result2 * 31 + (this.title == null ? 0 : this.title.hashCode());
                result2 = result2 * 31 + Boolean.hashCode(this.isVideo);
                result2 = result2 * 31 + Boolean.hashCode(this.isLive);
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Raw)) {
                    return false;
                }
                Raw raw = (Raw)other;
                if (!Intrinsics.areEqual((Object)this.streamProvider, (Object)raw.streamProvider)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.id, (Object)raw.id)) {
                    return false;
                }
                if (this.quality != raw.quality) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.title, (Object)raw.title)) {
                    return false;
                }
                if (this.isVideo != raw.isVideo) {
                    return false;
                }
                return this.isLive == raw.isLive;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Raw self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Source.write$Self(self, output, serialDesc);
                output.encodeStringElement(serialDesc, 0, self.getId());
                if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.getQuality() != 0) {
                    output.encodeIntElement(serialDesc, 1, self.getQuality());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.getTitle() != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getTitle());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.isVideo()) {
                    output.encodeBooleanElement(serialDesc, 3, self.isVideo());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.isLive()) {
                    output.encodeBooleanElement(serialDesc, 4, self.isLive());
                }
            }

            public /* synthetic */ Raw(int seen0, String id2, int quality, String title, boolean isVideo, boolean isLive, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (1 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Source$Raw$$serializer.INSTANCE.getDescriptor());
                }
                super(seen0, serializationConstructorMarker);
                this.streamProvider = null;
                this.id = id2;
                this.quality = (seen0 & 2) == 0 ? 0 : quality;
                this.title = (seen0 & 4) == 0 ? null : title;
                this.isVideo = (seen0 & 8) == 0 ? false : isVideo;
                this.isLive = (seen0 & 0x10) == 0 ? false : isLive;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Raw$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Streamable$Source$Raw;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Raw> serializer() {
                    return (KSerializer)Source$Raw$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$SourceType;", "", "<init>", "(Ljava/lang/String;I)V", "Progressive", "HLS", "DASH", "common"})
    public static final class SourceType
    extends Enum<SourceType> {
        public static final /* enum */ SourceType Progressive = new SourceType();
        public static final /* enum */ SourceType HLS = new SourceType();
        public static final /* enum */ SourceType DASH = new SourceType();
        private static final /* synthetic */ SourceType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static SourceType[] values() {
            return (SourceType[])$VALUES.clone();
        }

        public static SourceType valueOf(String value2) {
            return Enum.valueOf(SourceType.class, value2);
        }

        @NotNull
        public static EnumEntries<SourceType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = sourceTypeArray = new SourceType[]{SourceType.Progressive, SourceType.HLS, SourceType.DASH};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Streamable$SubtitleType;", "", "<init>", "(Ljava/lang/String;I)V", "VTT", "SRT", "ASS", "common"})
    public static final class SubtitleType
    extends Enum<SubtitleType> {
        public static final /* enum */ SubtitleType VTT = new SubtitleType();
        public static final /* enum */ SubtitleType SRT = new SubtitleType();
        public static final /* enum */ SubtitleType ASS = new SubtitleType();
        private static final /* synthetic */ SubtitleType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static SubtitleType[] values() {
            return (SubtitleType[])$VALUES.clone();
        }

        public static SubtitleType valueOf(String value2) {
            return Enum.valueOf(SubtitleType.class, value2);
        }

        @NotNull
        public static EnumEntries<SubtitleType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = subtitleTypeArray = new SubtitleType[]{SubtitleType.VTT, SubtitleType.SRT, SubtitleType.ASS};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

