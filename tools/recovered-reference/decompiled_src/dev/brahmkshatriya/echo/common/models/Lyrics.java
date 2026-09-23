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
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Lyrics$;
import dev.brahmkshatriya.echo.common.models.Lyrics$Item$;
import dev.brahmkshatriya.echo.common.models.Lyrics$Simple$;
import dev.brahmkshatriya.echo.common.models.Lyrics$Timed$;
import dev.brahmkshatriya.echo.common.models.Lyrics$WordByWord$;
import java.lang.annotation.Annotation;
import java.util.List;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0007,-./012BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\u0004\b\n\u0010\u000bBY\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\rH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001\u00a2\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u00063"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics;", "", "id", "", "title", "subtitle", "lyrics", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSubtitle", "getLyrics", "()Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Lyric", "Simple", "Timed", "WordByWord", "Item", "$serializer", "Companion", "common"})
public final class Lyrics {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @Nullable
    private final String subtitle;
    @Nullable
    private final Lyric lyrics;
    @NotNull
    private final Map<String, String> extras;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Lyrics(@NotNull String id2, @NotNull String title, @Nullable String subtitle2, @Nullable Lyric lyrics, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.title = title;
        this.subtitle = subtitle2;
        this.lyrics = lyrics;
        this.extras = extras;
    }

    public /* synthetic */ Lyrics(String string2, String string3, String string4, Lyric lyric, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string4 = null;
        }
        if ((n & 8) != 0) {
            lyric = null;
        }
        if ((n & 0x10) != 0) {
            map2 = MapsKt.emptyMap();
        }
        this(string2, string3, string4, lyric, map2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final Lyric getLyrics() {
        return this.lyrics;
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
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    @Nullable
    public final Lyric component4() {
        return this.lyrics;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.extras;
    }

    @NotNull
    public final Lyrics copy(@NotNull String id2, @NotNull String title, @Nullable String subtitle2, @Nullable Lyric lyrics, @NotNull Map<String, String> extras) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Lyrics(id2, title, subtitle2, lyrics, extras);
    }

    public static /* synthetic */ Lyrics copy$default(Lyrics lyrics, String string2, String string3, String string4, Lyric lyric, Map map2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = lyrics.id;
        }
        if ((n & 2) != 0) {
            string3 = lyrics.title;
        }
        if ((n & 4) != 0) {
            string4 = lyrics.subtitle;
        }
        if ((n & 8) != 0) {
            lyric = lyrics.lyrics;
        }
        if ((n & 0x10) != 0) {
            map2 = lyrics.extras;
        }
        return lyrics.copy(string2, string3, string4, lyric, map2);
    }

    @NotNull
    public String toString() {
        return "Lyrics(id=" + this.id + ", title=" + this.title + ", subtitle=" + this.subtitle + ", lyrics=" + this.lyrics + ", extras=" + this.extras + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + (this.lyrics == null ? 0 : this.lyrics.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Lyrics)) {
            return false;
        }
        Lyrics lyrics = (Lyrics)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)lyrics.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)lyrics.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)lyrics.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.lyrics, (Object)lyrics.lyrics)) {
            return false;
        }
        return Intrinsics.areEqual(this.extras, lyrics.extras);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Lyrics self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.title);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.subtitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.subtitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.lyrics != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.lyrics);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.extras, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.extras);
        }
    }

    public /* synthetic */ Lyrics(int seen0, String id2, String title, String subtitle2, Lyric lyrics, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.subtitle = (seen0 & 4) == 0 ? null : subtitle2;
        this.lyrics = (seen0 & 8) == 0 ? null : lyrics;
        this.extras = (seen0 & 0x10) == 0 ? MapsKt.emptyMap() : extras;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> Lyric.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Lyrics> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001\u00a2\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011\u00a8\u0006&"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Item;", "", "text", "", "startTime", "", "endTime", "<init>", "(Ljava/lang/String;JJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getStartTime", "()J", "getEndTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Item {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String text;
        private final long startTime;
        private final long endTime;

        public Item(@NotNull String text, long startTime, long endTime) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            this.text = text;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final long getEndTime() {
            return this.endTime;
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        public final long component2() {
            return this.startTime;
        }

        public final long component3() {
            return this.endTime;
        }

        @NotNull
        public final Item copy(@NotNull String text, long startTime, long endTime) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            return new Item(text, startTime, endTime);
        }

        public static /* synthetic */ Item copy$default(Item item2, String string2, long l, long l2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = item2.text;
            }
            if ((n & 2) != 0) {
                l = item2.startTime;
            }
            if ((n & 4) != 0) {
                l2 = item2.endTime;
            }
            return item2.copy(string2, l, l2);
        }

        @NotNull
        public String toString() {
            return "Item(text=" + this.text + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
        }

        public int hashCode() {
            int result2 = this.text.hashCode();
            result2 = result2 * 31 + Long.hashCode(this.startTime);
            result2 = result2 * 31 + Long.hashCode(this.endTime);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item2 = (Item)other;
            if (!Intrinsics.areEqual((Object)this.text, (Object)item2.text)) {
                return false;
            }
            if (this.startTime != item2.startTime) {
                return false;
            }
            return this.endTime == item2.endTime;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Item self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.text);
            output.encodeLongElement(serialDesc, 1, self.startTime);
            output.encodeLongElement(serialDesc, 2, self.endTime);
        }

        public /* synthetic */ Item(int seen0, String text, long startTime, long endTime, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (7 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)Item$$serializer.INSTANCE.getDescriptor());
            }
            this.text = text;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Item$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Item;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Item> serializer() {
                return (KSerializer)Item$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u0082\u0001\u0003\u0011\u0012\u0013\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Simple;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Timed;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$WordByWord;", "common"})
    public static abstract sealed class Lyric
    permits Simple, Timed, WordByWord {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
            KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(Simple.class), Reflection.getOrCreateKotlinClass(Timed.class), Reflection.getOrCreateKotlinClass(WordByWord.class)};
            KClass[] kClassArray2 = kClassArray;
            kClassArray = new KSerializer[]{Simple$$serializer.INSTANCE, Timed$$serializer.INSTANCE, WordByWord$$serializer.INSTANCE};
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Lyrics.Lyric", Reflection.getOrCreateKotlinClass(Lyric.class), kClassArray2, (KSerializer[])kClassArray, new Annotation[0]);
        });

        private Lyric() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self(Lyric self, CompositeEncoder output, SerialDescriptor serialDesc) {
        }

        public /* synthetic */ Lyric(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
        }

        public /* synthetic */ Lyric(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Lyric> serializer() {
                return this.get$cachedSerializer();
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Simple;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "text", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Simple
    extends Lyric {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String text;

        public Simple(@NotNull String text) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            super(null);
            this.text = text;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final Simple copy(@NotNull String text) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            return new Simple(text);
        }

        public static /* synthetic */ Simple copy$default(Simple simple, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = simple.text;
            }
            return simple.copy(string2);
        }

        @NotNull
        public String toString() {
            return "Simple(text=" + this.text + ")";
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Simple)) {
                return false;
            }
            Simple simple = (Simple)other;
            return Intrinsics.areEqual((Object)this.text, (Object)simple.text);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Simple self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lyric.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.text);
        }

        public /* synthetic */ Simple(int seen0, String text, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Simple$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.text = text;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Simple$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Simple;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Simple> serializer() {
                return (KSerializer)Simple$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001\u00a2\u0006\u0002\b\"R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Timed;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "list", "", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Item;", "fillTimeGaps", "", "<init>", "(Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getList", "()Ljava/util/List;", "getFillTimeGaps", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Timed
    extends Lyric {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<Item> list;
        private final boolean fillTimeGaps;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public Timed(@NotNull List<Item> list2, boolean fillTimeGaps) {
            Intrinsics.checkNotNullParameter(list2, (String)"list");
            super(null);
            this.list = list2;
            this.fillTimeGaps = fillTimeGaps;
        }

        public /* synthetic */ Timed(List list2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                bl = true;
            }
            this(list2, bl);
        }

        @NotNull
        public final List<Item> getList() {
            return this.list;
        }

        public final boolean getFillTimeGaps() {
            return this.fillTimeGaps;
        }

        @NotNull
        public final List<Item> component1() {
            return this.list;
        }

        public final boolean component2() {
            return this.fillTimeGaps;
        }

        @NotNull
        public final Timed copy(@NotNull List<Item> list2, boolean fillTimeGaps) {
            Intrinsics.checkNotNullParameter(list2, (String)"list");
            return new Timed(list2, fillTimeGaps);
        }

        public static /* synthetic */ Timed copy$default(Timed timed, List list2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                list2 = timed.list;
            }
            if ((n & 2) != 0) {
                bl = timed.fillTimeGaps;
            }
            return timed.copy(list2, bl);
        }

        @NotNull
        public String toString() {
            return "Timed(list=" + this.list + ", fillTimeGaps=" + this.fillTimeGaps + ")";
        }

        public int hashCode() {
            int result2 = ((Object)this.list).hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.fillTimeGaps);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Timed)) {
                return false;
            }
            Timed timed = (Timed)other;
            if (!Intrinsics.areEqual(this.list, timed.list)) {
                return false;
            }
            return this.fillTimeGaps == timed.fillTimeGaps;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Timed self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lyric.write$Self(self, output, serialDesc);
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), self.list);
            if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !self.fillTimeGaps) {
                output.encodeBooleanElement(serialDesc, 1, self.fillTimeGaps);
            }
        }

        public /* synthetic */ Timed(int seen0, List list2, boolean fillTimeGaps, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Timed$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.list = list2;
            this.fillTimeGaps = (seen0 & 2) == 0 ? true : fillTimeGaps;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Item$$serializer.INSTANCE)), null};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$Timed$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Timed;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Timed> serializer() {
                return (KSerializer)Timed$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B%\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u0015\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J)\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001\u00a2\u0006\u0002\b\"R\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$WordByWord;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Lyric;", "list", "", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Item;", "fillTimeGaps", "", "<init>", "(Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getList", "()Ljava/util/List;", "getFillTimeGaps", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class WordByWord
    extends Lyric {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<List<Item>> list;
        private final boolean fillTimeGaps;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public WordByWord(@NotNull List<? extends List<Item>> list2, boolean fillTimeGaps) {
            Intrinsics.checkNotNullParameter(list2, (String)"list");
            super(null);
            this.list = list2;
            this.fillTimeGaps = fillTimeGaps;
        }

        public /* synthetic */ WordByWord(List list2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                bl = true;
            }
            this(list2, bl);
        }

        @NotNull
        public final List<List<Item>> getList() {
            return this.list;
        }

        public final boolean getFillTimeGaps() {
            return this.fillTimeGaps;
        }

        @NotNull
        public final List<List<Item>> component1() {
            return this.list;
        }

        public final boolean component2() {
            return this.fillTimeGaps;
        }

        @NotNull
        public final WordByWord copy(@NotNull List<? extends List<Item>> list2, boolean fillTimeGaps) {
            Intrinsics.checkNotNullParameter(list2, (String)"list");
            return new WordByWord(list2, fillTimeGaps);
        }

        public static /* synthetic */ WordByWord copy$default(WordByWord wordByWord, List list2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                list2 = wordByWord.list;
            }
            if ((n & 2) != 0) {
                bl = wordByWord.fillTimeGaps;
            }
            return wordByWord.copy(list2, bl);
        }

        @NotNull
        public String toString() {
            return "WordByWord(list=" + this.list + ", fillTimeGaps=" + this.fillTimeGaps + ")";
        }

        public int hashCode() {
            int result2 = ((Object)this.list).hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.fillTimeGaps);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WordByWord)) {
                return false;
            }
            WordByWord wordByWord = (WordByWord)other;
            if (!Intrinsics.areEqual(this.list, wordByWord.list)) {
                return false;
            }
            return this.fillTimeGaps == wordByWord.fillTimeGaps;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(WordByWord self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lyric.write$Self(self, output, serialDesc);
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), self.list);
            if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !self.fillTimeGaps) {
                output.encodeBooleanElement(serialDesc, 1, self.fillTimeGaps);
            }
        }

        public /* synthetic */ WordByWord(int seen0, List list2, boolean fillTimeGaps, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)WordByWord$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.list = list2;
            this.fillTimeGaps = (seen0 & 2) == 0 ? true : fillTimeGaps;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)new ArrayListSerializer((KSerializer)Item$$serializer.INSTANCE))), null};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Lyrics$WordByWord$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Lyrics$WordByWord;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<WordByWord> serializer() {
                return (KSerializer)WordByWord$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

