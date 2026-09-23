/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
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
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.User$;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0004\b\n\u0010\u000bBY\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\rH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2={"Ldev/brahmkshatriya/echo/common/models/User;", "", "id", "", "name", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "subtitle", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getSubtitle", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class User {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @Nullable
    private final ImageHolder cover;
    @Nullable
    private final String subtitle;
    @NotNull
    private final Map<String, String> extras;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public User(@NotNull String id2, @NotNull String name, @Nullable ImageHolder cover, @Nullable String subtitle2, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.name = name;
        this.cover = cover;
        this.subtitle = subtitle2;
        this.extras = extras;
    }

    public /* synthetic */ User(String string2, String string3, ImageHolder imageHolder, String string4, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            imageHolder = null;
        }
        if ((n & 8) != 0) {
            string4 = null;
        }
        if ((n & 0x10) != 0) {
            map2 = MapsKt.emptyMap();
        }
        this(string2, string3, imageHolder, string4, map2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ImageHolder getCover() {
        return this.cover;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> getExtras() {
        return this.extras;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final ImageHolder component3() {
        return this.cover;
    }

    @Nullable
    public final String component4() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.extras;
    }

    @NotNull
    public final User copy(@NotNull String id2, @NotNull String name, @Nullable ImageHolder cover, @Nullable String subtitle2, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new User(id2, name, cover, subtitle2, extras);
    }

    public static /* synthetic */ User copy$default(User user, String string2, String string3, ImageHolder imageHolder, String string4, Map map2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = user.id;
        }
        if ((n & 2) != 0) {
            string3 = user.name;
        }
        if ((n & 4) != 0) {
            imageHolder = user.cover;
        }
        if ((n & 8) != 0) {
            string4 = user.subtitle;
        }
        if ((n & 0x10) != 0) {
            map2 = user.extras;
        }
        return user.copy(string2, string3, imageHolder, string4, map2);
    }

    @NotNull
    public String toString() {
        return "User(id=" + this.id + ", name=" + this.name + ", cover=" + this.cover + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)user.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)user.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)user.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)user.subtitle)) {
            return false;
        }
        return Intrinsics.areEqual(this.extras, user.extras);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(User self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.subtitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.subtitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.extras, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.extras);
        }
    }

    public /* synthetic */ User(int seen0, String id2, String name, ImageHolder cover, String subtitle2, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.name = name;
        this.cover = (seen0 & 4) == 0 ? null : cover;
        this.subtitle = (seen0 & 8) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x10) == 0 ? MapsKt.emptyMap() : extras;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/User$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/User;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<User> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

