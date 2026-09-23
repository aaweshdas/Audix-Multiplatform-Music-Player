/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Chapter$;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0003,-.B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nBA\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J8\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\fH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006/"}, d2={"Ldev/brahmkshatriya/echo/common/models/Chapter;", "", "name", "", "startTime", "", "endTime", "skipType", "Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;", "<init>", "(Ljava/lang/String;JLjava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getStartTime", "()J", "getEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSkipType", "()Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;)Ldev/brahmkshatriya/echo/common/models/Chapter;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "SkipType", "$serializer", "Companion", "common"})
public final class Chapter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String name;
    private final long startTime;
    @Nullable
    private final Long endTime;
    @NotNull
    private final SkipType skipType;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Chapter(@NotNull String name, long startTime, @Nullable Long endTime, @NotNull SkipType skipType) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)((Object)skipType), (String)"skipType");
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.skipType = skipType;
    }

    public /* synthetic */ Chapter(String string2, long l, Long l2, SkipType skipType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            l2 = null;
        }
        if ((n & 8) != 0) {
            skipType = SkipType.NONE;
        }
        this(string2, l, l2, skipType);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    @Nullable
    public final Long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final SkipType getSkipType() {
        return this.skipType;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final long component2() {
        return this.startTime;
    }

    @Nullable
    public final Long component3() {
        return this.endTime;
    }

    @NotNull
    public final SkipType component4() {
        return this.skipType;
    }

    @NotNull
    public final Chapter copy(@NotNull String name, long startTime, @Nullable Long endTime, @NotNull SkipType skipType) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)((Object)skipType), (String)"skipType");
        return new Chapter(name, startTime, endTime, skipType);
    }

    public static /* synthetic */ Chapter copy$default(Chapter chapter, String string2, long l, Long l2, SkipType skipType, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = chapter.name;
        }
        if ((n & 2) != 0) {
            l = chapter.startTime;
        }
        if ((n & 4) != 0) {
            l2 = chapter.endTime;
        }
        if ((n & 8) != 0) {
            skipType = chapter.skipType;
        }
        return chapter.copy(string2, l, l2, skipType);
    }

    @NotNull
    public String toString() {
        return "Chapter(name=" + this.name + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", skipType=" + this.skipType + ")";
    }

    public int hashCode() {
        int result2 = this.name.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.startTime);
        result2 = result2 * 31 + (this.endTime == null ? 0 : ((Object)this.endTime).hashCode());
        result2 = result2 * 31 + this.skipType.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Chapter)) {
            return false;
        }
        Chapter chapter = (Chapter)other;
        if (!Intrinsics.areEqual((Object)this.name, (Object)chapter.name)) {
            return false;
        }
        if (this.startTime != chapter.startTime) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.endTime, (Object)chapter.endTime)) {
            return false;
        }
        return this.skipType == chapter.skipType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Chapter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeLongElement(serialDesc, 1, self.startTime);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.endTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.endTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.skipType != SkipType.NONE) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.skipType);
        }
    }

    public /* synthetic */ Chapter(int seen0, String name, long startTime, Long endTime, SkipType skipType, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.name = name;
        this.startTime = startTime;
        this.endTime = (seen0 & 4) == 0 ? null : endTime;
        this.skipType = (seen0 & 8) == 0 ? SkipType.NONE : skipType;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Chapter.SkipType", (Enum[])SkipType.values()))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Chapter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Chapter;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Chapter> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Chapter$SkipType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SKIP", "ASK", "common"})
    public static final class SkipType
    extends Enum<SkipType> {
        public static final /* enum */ SkipType NONE = new SkipType();
        public static final /* enum */ SkipType SKIP = new SkipType();
        public static final /* enum */ SkipType ASK = new SkipType();
        private static final /* synthetic */ SkipType[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static SkipType[] values() {
            return (SkipType[])$VALUES.clone();
        }

        public static SkipType valueOf(String value2) {
            return Enum.valueOf(SkipType.class, value2);
        }

        @NotNull
        public static EnumEntries<SkipType> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = skipTypeArray = new SkipType[]{SkipType.NONE, SkipType.SKIP, SkipType.ASK};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

