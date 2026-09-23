/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
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

import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Shelf$Category$;
import dev.brahmkshatriya.echo.common.models.Shelf$Item$;
import dev.brahmkshatriya.echo.common.models.Shelf$Lists$Categories$;
import dev.brahmkshatriya.echo.common.models.Shelf$Lists$Items$;
import dev.brahmkshatriya.echo.common.models.Shelf$Lists$Tracks$;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.Track$;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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

@JsonClassDiscriminator(discriminator="shelfType")
@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000f2\u00020\u0001:\u0004\f\r\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u0010\u0011\u0012\u00a8\u0006\u0013\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf;", "", "id", "", "getId", "()Ljava/lang/String;", "title", "getTitle", "extras", "", "getExtras", "()Ljava/util/Map;", "Lists", "Item", "Category", "Companion", "Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "common"})
public sealed interface Shelf {
    @NotNull
    public static final Companion Companion = dev.brahmkshatriya.echo.common.models.Shelf$Companion.$$INSTANCE;

    @NotNull
    public String getId();

    @NotNull
    public String getTitle();

    @NotNull
    public Map<String, String> getExtras();

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\f\u00a2\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\r\u0010\u0013J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0003Ji\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fH\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0010H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001\u00a2\u0006\u0002\b6R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00069"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "id", "", "title", "feed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "subtitle", "image", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "backgroundColor", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Feed;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getFeed$annotations", "()V", "getFeed", "()Ldev/brahmkshatriya/echo/common/models/Feed;", "getSubtitle", "getImage", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getBackgroundColor", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Category
    implements Shelf {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String id;
        @NotNull
        private final String title;
        @Nullable
        private final Feed<Shelf> feed;
        @Nullable
        private final String subtitle;
        @Nullable
        private final ImageHolder image;
        @Nullable
        private final String backgroundColor;
        @NotNull
        private final Map<String, String> extras;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public Category(@NotNull String id2, @NotNull String title, @Nullable Feed<Shelf> feed2, @Nullable String subtitle2, @Nullable ImageHolder image, @Nullable String backgroundColor, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            this.id = id2;
            this.title = title;
            this.feed = feed2;
            this.subtitle = subtitle2;
            this.image = image;
            this.backgroundColor = backgroundColor;
            this.extras = extras;
        }

        public /* synthetic */ Category(String string2, String string3, Feed feed2, String string4, ImageHolder imageHolder, String string5, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                feed2 = null;
            }
            if ((n & 8) != 0) {
                string4 = null;
            }
            if ((n & 0x10) != 0) {
                imageHolder = null;
            }
            if ((n & 0x20) != 0) {
                string5 = null;
            }
            if ((n & 0x40) != 0) {
                map2 = MapsKt.emptyMap();
            }
            this(string2, string3, feed2, string4, imageHolder, string5, map2);
        }

        @Override
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Nullable
        public final Feed<Shelf> getFeed() {
            return this.feed;
        }

        @Transient
        public static /* synthetic */ void getFeed$annotations() {
        }

        @Nullable
        public final String getSubtitle() {
            return this.subtitle;
        }

        @Nullable
        public final ImageHolder getImage() {
            return this.image;
        }

        @Nullable
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        @Override
        @NotNull
        public Map<String, String> getExtras() {
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
        public final Feed<Shelf> component3() {
            return this.feed;
        }

        @Nullable
        public final String component4() {
            return this.subtitle;
        }

        @Nullable
        public final ImageHolder component5() {
            return this.image;
        }

        @Nullable
        public final String component6() {
            return this.backgroundColor;
        }

        @NotNull
        public final Map<String, String> component7() {
            return this.extras;
        }

        @NotNull
        public final Category copy(@NotNull String id2, @NotNull String title, @Nullable Feed<Shelf> feed2, @Nullable String subtitle2, @Nullable ImageHolder image, @Nullable String backgroundColor, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return new Category(id2, title, feed2, subtitle2, image, backgroundColor, extras);
        }

        public static /* synthetic */ Category copy$default(Category category, String string2, String string3, Feed feed2, String string4, ImageHolder imageHolder, String string5, Map map2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = category.id;
            }
            if ((n & 2) != 0) {
                string3 = category.title;
            }
            if ((n & 4) != 0) {
                feed2 = category.feed;
            }
            if ((n & 8) != 0) {
                string4 = category.subtitle;
            }
            if ((n & 0x10) != 0) {
                imageHolder = category.image;
            }
            if ((n & 0x20) != 0) {
                string5 = category.backgroundColor;
            }
            if ((n & 0x40) != 0) {
                map2 = category.extras;
            }
            return category.copy(string2, string3, feed2, string4, imageHolder, string5, map2);
        }

        @NotNull
        public String toString() {
            return "Category(id=" + this.id + ", title=" + this.title + ", feed=" + this.feed + ", subtitle=" + this.subtitle + ", image=" + this.image + ", backgroundColor=" + this.backgroundColor + ", extras=" + this.extras + ")";
        }

        public int hashCode() {
            int result2 = this.id.hashCode();
            result2 = result2 * 31 + this.title.hashCode();
            result2 = result2 * 31 + (this.feed == null ? 0 : this.feed.hashCode());
            result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
            result2 = result2 * 31 + (this.image == null ? 0 : this.image.hashCode());
            result2 = result2 * 31 + (this.backgroundColor == null ? 0 : this.backgroundColor.hashCode());
            result2 = result2 * 31 + ((Object)this.extras).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Category)) {
                return false;
            }
            Category category = (Category)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)category.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.title, (Object)category.title)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.feed, category.feed)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.subtitle, (Object)category.subtitle)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.image, (Object)category.image)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.backgroundColor, (Object)category.backgroundColor)) {
                return false;
            }
            return Intrinsics.areEqual(this.extras, category.extras);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Category self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getId());
            output.encodeStringElement(serialDesc, 1, self.getTitle());
            if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.subtitle != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.subtitle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.image != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.image);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.backgroundColor != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.backgroundColor);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
                output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.getExtras());
            }
        }

        public /* synthetic */ Category(int seen0, String id2, String title, String subtitle2, ImageHolder image, String backgroundColor, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Category$$serializer.INSTANCE.getDescriptor());
            }
            this.id = id2;
            this.title = title;
            this.feed = null;
            this.subtitle = (seen0 & 4) == 0 ? null : subtitle2;
            this.image = (seen0 & 8) == 0 ? null : image;
            this.backgroundColor = (seen0 & 0x10) == 0 ? null : backgroundColor;
            this.extras = (seen0 & 0x20) == 0 ? MapsKt.emptyMap() : extras;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Category$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Category> serializer() {
                return (KSerializer)Category$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final KSerializer<Shelf> serializer() {
            Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Category.class), Reflection.getOrCreateKotlinClass(Item.class), Reflection.getOrCreateKotlinClass(Lists.Categories.class), Reflection.getOrCreateKotlinClass(Lists.Items.class), Reflection.getOrCreateKotlinClass(Lists.Tracks.class)};
            KClass[] kClassArray = objectArray;
            objectArray = new KSerializer[]{Category$$serializer.INSTANCE, Item$$serializer.INSTANCE, Lists$Categories$$serializer.INSTANCE, Lists$Items$$serializer.INSTANCE, Lists$Tracks$$serializer.INSTANCE};
            KClass[] kClassArray2 = objectArray;
            objectArray = new Annotation[]{new JsonClassDiscriminator("shelfType"){
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
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Shelf", Reflection.getOrCreateKotlinClass(Shelf.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005BO\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0004\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\tH\u00d6\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001\u00a2\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "media", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "<init>", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;)V", "seen0", "", "id", "", "title", "extras", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/EchoMediaItem;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMedia", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getId", "()Ljava/lang/String;", "getTitle", "getExtras", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Item
    implements Shelf {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final EchoMediaItem media;
        @NotNull
        private final String id;
        @NotNull
        private final String title;
        @NotNull
        private final Map<String, String> extras;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public Item(@NotNull EchoMediaItem media) {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            this.media = media;
            this.id = this.media.getId();
            this.title = this.media.getTitle();
            this.extras = this.media.getExtras();
        }

        @NotNull
        public final EchoMediaItem getMedia() {
            return this.media;
        }

        @Override
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override
        @NotNull
        public Map<String, String> getExtras() {
            return this.extras;
        }

        @NotNull
        public final EchoMediaItem component1() {
            return this.media;
        }

        @NotNull
        public final Item copy(@NotNull EchoMediaItem media) {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            return new Item(media);
        }

        public static /* synthetic */ Item copy$default(Item item2, EchoMediaItem echoMediaItem, int n, Object object) {
            if ((n & 1) != 0) {
                echoMediaItem = item2.media;
            }
            return item2.copy(echoMediaItem);
        }

        @NotNull
        public String toString() {
            return "Item(media=" + this.media + ")";
        }

        public int hashCode() {
            return this.media.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item2 = (Item)other;
            return Intrinsics.areEqual((Object)this.media, (Object)item2.media);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Item self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), (Object)self.media);
            if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual((Object)self.getId(), (Object)self.media.getId())) {
                output.encodeStringElement(serialDesc, 1, self.getId());
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual((Object)self.getTitle(), (Object)self.media.getTitle())) {
                output.encodeStringElement(serialDesc, 2, self.getTitle());
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual(self.getExtras(), self.media.getExtras())) {
                output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), self.getExtras());
            }
        }

        public /* synthetic */ Item(int seen0, EchoMediaItem media, String id2, String title, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Item$$serializer.INSTANCE.getDescriptor());
            }
            this.media = media;
            this.id = (seen0 & 2) == 0 ? this.media.getId() : id2;
            this.title = (seen0 & 4) == 0 ? this.media.getTitle() : title;
            this.extras = (seen0 & 8) == 0 ? this.media.getExtras() : extras;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EchoMediaItem.Companion.serializer()), null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Item$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "common"})
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

    @JsonClassDiscriminator(discriminator="shelfType")
    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0005\u0014\u0015\u0016\u0017\u0018R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0003\u0019\u001a\u001b\u00a8\u0006\u001c\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "T", "", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "list", "", "getList", "()Ljava/util/List;", "subtitle", "", "getSubtitle", "()Ljava/lang/String;", "type", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "getType", "()Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "more", "Ldev/brahmkshatriya/echo/common/models/Feed;", "getMore", "()Ldev/brahmkshatriya/echo/common/models/Feed;", "Type", "Items", "Tracks", "Categories", "Companion", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Categories;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Items;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Tracks;", "common"})
    public static sealed interface Lists<T>
    extends Shelf {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @NotNull
        public List<T> getList();

        @Nullable
        public String getSubtitle();

        @NotNull
        public Type getType();

        @Nullable
        public Feed<Shelf> getMore();

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002;<Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011Bi\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0016J\t\u0010%\u001a\u00020\u0004H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00c6\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0013H\u00d6\u0001J\t\u00102\u001a\u00020\u0004H\u00d6\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001\u00a2\u0006\u0002\b:R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u0006="}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Categories;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Category;", "id", "", "title", "list", "", "subtitle", "type", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "more", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ldev/brahmkshatriya/echo/common/models/Feed;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getList", "()Ljava/util/List;", "getSubtitle", "getType", "()Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "getMore$annotations", "()V", "getMore", "()Ldev/brahmkshatriya/echo/common/models/Feed;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Categories
        implements Lists<Category> {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final String id;
            @NotNull
            private final String title;
            @NotNull
            private final List<Category> list;
            @Nullable
            private final String subtitle;
            @NotNull
            private final Type type;
            @Nullable
            private final Feed<Shelf> more;
            @NotNull
            private final Map<String, String> extras;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Categories(@NotNull String id2, @NotNull String title, @NotNull List<Category> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = subtitle2;
                this.type = type;
                this.more = more;
                this.extras = extras;
            }

            public /* synthetic */ Categories(String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n & 8) != 0) {
                    string4 = null;
                }
                if ((n & 0x10) != 0) {
                    type = Type.Linear;
                }
                if ((n & 0x20) != 0) {
                    feed2 = null;
                }
                if ((n & 0x40) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                this(string2, string3, list2, string4, type, feed2, map2);
            }

            @Override
            @NotNull
            public String getId() {
                return this.id;
            }

            @Override
            @NotNull
            public String getTitle() {
                return this.title;
            }

            @Override
            @NotNull
            public List<Category> getList() {
                return this.list;
            }

            @Override
            @Nullable
            public String getSubtitle() {
                return this.subtitle;
            }

            @Override
            @NotNull
            public Type getType() {
                return this.type;
            }

            @Override
            @Nullable
            public Feed<Shelf> getMore() {
                return this.more;
            }

            @Transient
            public static /* synthetic */ void getMore$annotations() {
            }

            @Override
            @NotNull
            public Map<String, String> getExtras() {
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

            @NotNull
            public final List<Category> component3() {
                return this.list;
            }

            @Nullable
            public final String component4() {
                return this.subtitle;
            }

            @NotNull
            public final Type component5() {
                return this.type;
            }

            @Nullable
            public final Feed<Shelf> component6() {
                return this.more;
            }

            @NotNull
            public final Map<String, String> component7() {
                return this.extras;
            }

            @NotNull
            public final Categories copy(@NotNull String id2, @NotNull String title, @NotNull List<Category> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                return new Categories(id2, title, list2, subtitle2, type, more, extras);
            }

            public static /* synthetic */ Categories copy$default(Categories categories, String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, Object object) {
                if ((n & 1) != 0) {
                    string2 = categories.id;
                }
                if ((n & 2) != 0) {
                    string3 = categories.title;
                }
                if ((n & 4) != 0) {
                    list2 = categories.list;
                }
                if ((n & 8) != 0) {
                    string4 = categories.subtitle;
                }
                if ((n & 0x10) != 0) {
                    type = categories.type;
                }
                if ((n & 0x20) != 0) {
                    feed2 = categories.more;
                }
                if ((n & 0x40) != 0) {
                    map2 = categories.extras;
                }
                return categories.copy(string2, string3, list2, string4, type, feed2, map2);
            }

            @NotNull
            public String toString() {
                return "Categories(id=" + this.id + ", title=" + this.title + ", list=" + this.list + ", subtitle=" + this.subtitle + ", type=" + this.type + ", more=" + this.more + ", extras=" + this.extras + ")";
            }

            public int hashCode() {
                int result2 = this.id.hashCode();
                result2 = result2 * 31 + this.title.hashCode();
                result2 = result2 * 31 + ((Object)this.list).hashCode();
                result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
                result2 = result2 * 31 + this.type.hashCode();
                result2 = result2 * 31 + (this.more == null ? 0 : this.more.hashCode());
                result2 = result2 * 31 + ((Object)this.extras).hashCode();
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Categories)) {
                    return false;
                }
                Categories categories = (Categories)other;
                if (!Intrinsics.areEqual((Object)this.id, (Object)categories.id)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.title, (Object)categories.title)) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.list, categories.list)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.subtitle, (Object)categories.subtitle)) {
                    return false;
                }
                if (this.type != categories.type) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.more, categories.more)) {
                    return false;
                }
                return Intrinsics.areEqual(this.extras, categories.extras);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Categories self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.getId());
                output.encodeStringElement(serialDesc, 1, self.getTitle());
                output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.getList());
                if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getSubtitle() != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getType() != Type.Linear) {
                    output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), (Object)self.getType());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
                    output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.getExtras());
                }
            }

            public /* synthetic */ Categories(int seen0, String id2, String title, List list2, String subtitle2, Type type, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (7 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)Lists$Categories$$serializer.INSTANCE.getDescriptor());
                }
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = (seen0 & 8) == 0 ? null : subtitle2;
                this.type = (seen0 & 0x10) == 0 ? Type.Linear : type;
                this.more = null;
                this.extras = (seen0 & 0x20) == 0 ? MapsKt.emptyMap() : extras;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Category$$serializer.INSTANCE)), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Shelf.Lists.Type", (Enum[])Type.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Categories$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Categories;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Categories> serializer() {
                    return (KSerializer)Lists$Categories$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "T", "typeSerial0", "common"})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;

            private Companion() {
            }

            @NotNull
            public final <T> KSerializer<Lists<T>> serializer(@NotNull KSerializer<T> typeSerial0) {
                Intrinsics.checkNotNullParameter(typeSerial0, (String)"typeSerial0");
                Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Categories.class), Reflection.getOrCreateKotlinClass(Items.class), Reflection.getOrCreateKotlinClass(Tracks.class)};
                KClass[] kClassArray = objectArray;
                objectArray = new KSerializer[]{Lists$Categories$$serializer.INSTANCE, Lists$Items$$serializer.INSTANCE, Lists$Tracks$$serializer.INSTANCE};
                KClass[] kClassArray2 = objectArray;
                objectArray = new Annotation[]{new /* invalid duplicate definition of identical inner class */};
                return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Shelf.Lists", Reflection.getOrCreateKotlinClass(Lists.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002;<Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011Bi\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0016J\t\u0010%\u001a\u00020\u0004H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00c6\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0013H\u00d6\u0001J\t\u00102\u001a\u00020\u0004H\u00d6\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001\u00a2\u0006\u0002\b:R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u0006="}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Items;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "id", "", "title", "list", "", "subtitle", "type", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "more", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ldev/brahmkshatriya/echo/common/models/Feed;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getList", "()Ljava/util/List;", "getSubtitle", "getType", "()Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "getMore$annotations", "()V", "getMore", "()Ldev/brahmkshatriya/echo/common/models/Feed;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Items
        implements Lists<EchoMediaItem> {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final String id;
            @NotNull
            private final String title;
            @NotNull
            private final List<EchoMediaItem> list;
            @Nullable
            private final String subtitle;
            @NotNull
            private final Type type;
            @Nullable
            private final Feed<Shelf> more;
            @NotNull
            private final Map<String, String> extras;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Items(@NotNull String id2, @NotNull String title, @NotNull List<? extends EchoMediaItem> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = subtitle2;
                this.type = type;
                this.more = more;
                this.extras = extras;
            }

            public /* synthetic */ Items(String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n & 8) != 0) {
                    string4 = null;
                }
                if ((n & 0x10) != 0) {
                    type = Type.Linear;
                }
                if ((n & 0x20) != 0) {
                    feed2 = null;
                }
                if ((n & 0x40) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                this(string2, string3, list2, string4, type, feed2, map2);
            }

            @Override
            @NotNull
            public String getId() {
                return this.id;
            }

            @Override
            @NotNull
            public String getTitle() {
                return this.title;
            }

            @Override
            @NotNull
            public List<EchoMediaItem> getList() {
                return this.list;
            }

            @Override
            @Nullable
            public String getSubtitle() {
                return this.subtitle;
            }

            @Override
            @NotNull
            public Type getType() {
                return this.type;
            }

            @Override
            @Nullable
            public Feed<Shelf> getMore() {
                return this.more;
            }

            @Transient
            public static /* synthetic */ void getMore$annotations() {
            }

            @Override
            @NotNull
            public Map<String, String> getExtras() {
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

            @NotNull
            public final List<EchoMediaItem> component3() {
                return this.list;
            }

            @Nullable
            public final String component4() {
                return this.subtitle;
            }

            @NotNull
            public final Type component5() {
                return this.type;
            }

            @Nullable
            public final Feed<Shelf> component6() {
                return this.more;
            }

            @NotNull
            public final Map<String, String> component7() {
                return this.extras;
            }

            @NotNull
            public final Items copy(@NotNull String id2, @NotNull String title, @NotNull List<? extends EchoMediaItem> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                return new Items(id2, title, list2, subtitle2, type, more, extras);
            }

            public static /* synthetic */ Items copy$default(Items items2, String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, Object object) {
                if ((n & 1) != 0) {
                    string2 = items2.id;
                }
                if ((n & 2) != 0) {
                    string3 = items2.title;
                }
                if ((n & 4) != 0) {
                    list2 = items2.list;
                }
                if ((n & 8) != 0) {
                    string4 = items2.subtitle;
                }
                if ((n & 0x10) != 0) {
                    type = items2.type;
                }
                if ((n & 0x20) != 0) {
                    feed2 = items2.more;
                }
                if ((n & 0x40) != 0) {
                    map2 = items2.extras;
                }
                return items2.copy(string2, string3, list2, string4, type, feed2, map2);
            }

            @NotNull
            public String toString() {
                return "Items(id=" + this.id + ", title=" + this.title + ", list=" + this.list + ", subtitle=" + this.subtitle + ", type=" + this.type + ", more=" + this.more + ", extras=" + this.extras + ")";
            }

            public int hashCode() {
                int result2 = this.id.hashCode();
                result2 = result2 * 31 + this.title.hashCode();
                result2 = result2 * 31 + ((Object)this.list).hashCode();
                result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
                result2 = result2 * 31 + this.type.hashCode();
                result2 = result2 * 31 + (this.more == null ? 0 : this.more.hashCode());
                result2 = result2 * 31 + ((Object)this.extras).hashCode();
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Items)) {
                    return false;
                }
                Items items2 = (Items)other;
                if (!Intrinsics.areEqual((Object)this.id, (Object)items2.id)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.title, (Object)items2.title)) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.list, items2.list)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.subtitle, (Object)items2.subtitle)) {
                    return false;
                }
                if (this.type != items2.type) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.more, items2.more)) {
                    return false;
                }
                return Intrinsics.areEqual(this.extras, items2.extras);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Items self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.getId());
                output.encodeStringElement(serialDesc, 1, self.getTitle());
                output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.getList());
                if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getSubtitle() != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getType() != Type.Linear) {
                    output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), (Object)self.getType());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
                    output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.getExtras());
                }
            }

            public /* synthetic */ Items(int seen0, String id2, String title, List list2, String subtitle2, Type type, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (7 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)Lists$Items$$serializer.INSTANCE.getDescriptor());
                }
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = (seen0 & 8) == 0 ? null : subtitle2;
                this.type = (seen0 & 0x10) == 0 ? Type.Linear : type;
                this.more = null;
                this.extras = (seen0 & 0x20) == 0 ? MapsKt.emptyMap() : extras;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer(EchoMediaItem.Companion.serializer())), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Shelf.Lists.Type", (Enum[])Type.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Items$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Items;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Items> serializer() {
                    return (KSerializer)Lists$Items$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002;<Bc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0010\u0010\u0011Bi\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0010\u0010\u0016J\t\u0010%\u001a\u00020\u0004H\u00c6\u0003J\t\u0010&\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00c6\u0003J\u0015\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0003Jk\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0013H\u00d6\u0001J\t\u00102\u001a\u00020\u0004H\u00d6\u0001J%\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001\u00a2\u0006\u0002\b:R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0097\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u0006="}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Tracks;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists;", "Ldev/brahmkshatriya/echo/common/models/Track;", "id", "", "title", "list", "", "subtitle", "type", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "more", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ldev/brahmkshatriya/echo/common/models/Feed;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getList", "()Ljava/util/List;", "getSubtitle", "getType", "()Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "getMore$annotations", "()V", "getMore", "()Ldev/brahmkshatriya/echo/common/models/Feed;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class Tracks
        implements Lists<Track> {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final String id;
            @NotNull
            private final String title;
            @NotNull
            private final List<Track> list;
            @Nullable
            private final String subtitle;
            @NotNull
            private final Type type;
            @Nullable
            private final Feed<Shelf> more;
            @NotNull
            private final Map<String, String> extras;
            @JvmField
            @NotNull
            private static final Lazy<KSerializer<Object>>[] $childSerializers;

            public Tracks(@NotNull String id2, @NotNull String title, @NotNull List<Track> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = subtitle2;
                this.type = type;
                this.more = more;
                this.extras = extras;
            }

            public /* synthetic */ Tracks(String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
                if ((n & 8) != 0) {
                    string4 = null;
                }
                if ((n & 0x10) != 0) {
                    type = Type.Linear;
                }
                if ((n & 0x20) != 0) {
                    feed2 = null;
                }
                if ((n & 0x40) != 0) {
                    map2 = MapsKt.emptyMap();
                }
                this(string2, string3, list2, string4, type, feed2, map2);
            }

            @Override
            @NotNull
            public String getId() {
                return this.id;
            }

            @Override
            @NotNull
            public String getTitle() {
                return this.title;
            }

            @Override
            @NotNull
            public List<Track> getList() {
                return this.list;
            }

            @Override
            @Nullable
            public String getSubtitle() {
                return this.subtitle;
            }

            @Override
            @NotNull
            public Type getType() {
                return this.type;
            }

            @Override
            @Nullable
            public Feed<Shelf> getMore() {
                return this.more;
            }

            @Transient
            public static /* synthetic */ void getMore$annotations() {
            }

            @Override
            @NotNull
            public Map<String, String> getExtras() {
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

            @NotNull
            public final List<Track> component3() {
                return this.list;
            }

            @Nullable
            public final String component4() {
                return this.subtitle;
            }

            @NotNull
            public final Type component5() {
                return this.type;
            }

            @Nullable
            public final Feed<Shelf> component6() {
                return this.more;
            }

            @NotNull
            public final Map<String, String> component7() {
                return this.extras;
            }

            @NotNull
            public final Tracks copy(@NotNull String id2, @NotNull String title, @NotNull List<Track> list2, @Nullable String subtitle2, @NotNull Type type, @Nullable Feed<Shelf> more, @NotNull Map<String, String> extras) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(list2, (String)"list");
                Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                return new Tracks(id2, title, list2, subtitle2, type, more, extras);
            }

            public static /* synthetic */ Tracks copy$default(Tracks tracks, String string2, String string3, List list2, String string4, Type type, Feed feed2, Map map2, int n, Object object) {
                if ((n & 1) != 0) {
                    string2 = tracks.id;
                }
                if ((n & 2) != 0) {
                    string3 = tracks.title;
                }
                if ((n & 4) != 0) {
                    list2 = tracks.list;
                }
                if ((n & 8) != 0) {
                    string4 = tracks.subtitle;
                }
                if ((n & 0x10) != 0) {
                    type = tracks.type;
                }
                if ((n & 0x20) != 0) {
                    feed2 = tracks.more;
                }
                if ((n & 0x40) != 0) {
                    map2 = tracks.extras;
                }
                return tracks.copy(string2, string3, list2, string4, type, feed2, map2);
            }

            @NotNull
            public String toString() {
                return "Tracks(id=" + this.id + ", title=" + this.title + ", list=" + this.list + ", subtitle=" + this.subtitle + ", type=" + this.type + ", more=" + this.more + ", extras=" + this.extras + ")";
            }

            public int hashCode() {
                int result2 = this.id.hashCode();
                result2 = result2 * 31 + this.title.hashCode();
                result2 = result2 * 31 + ((Object)this.list).hashCode();
                result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
                result2 = result2 * 31 + this.type.hashCode();
                result2 = result2 * 31 + (this.more == null ? 0 : this.more.hashCode());
                result2 = result2 * 31 + ((Object)this.extras).hashCode();
                return result2;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Tracks)) {
                    return false;
                }
                Tracks tracks = (Tracks)other;
                if (!Intrinsics.areEqual((Object)this.id, (Object)tracks.id)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.title, (Object)tracks.title)) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.list, tracks.list)) {
                    return false;
                }
                if (!Intrinsics.areEqual((Object)this.subtitle, (Object)tracks.subtitle)) {
                    return false;
                }
                if (this.type != tracks.type) {
                    return false;
                }
                if (!Intrinsics.areEqual(this.more, tracks.more)) {
                    return false;
                }
                return Intrinsics.areEqual(this.extras, tracks.extras);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(Tracks self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
                output.encodeStringElement(serialDesc, 0, self.getId());
                output.encodeStringElement(serialDesc, 1, self.getTitle());
                output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.getList());
                if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getSubtitle() != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getType() != Type.Linear) {
                    output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), (Object)self.getType());
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
                    output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.getExtras());
                }
            }

            public /* synthetic */ Tracks(int seen0, String id2, String title, List list2, String subtitle2, Type type, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
                if (7 != (7 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)Lists$Tracks$$serializer.INSTANCE.getDescriptor());
                }
                this.id = id2;
                this.title = title;
                this.list = list2;
                this.subtitle = (seen0 & 8) == 0 ? null : subtitle2;
                this.type = (seen0 & 0x10) == 0 ? Type.Linear : type;
                this.more = null;
                this.extras = (seen0 & 0x20) == 0 ? MapsKt.emptyMap() : extras;
            }

            public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
                return $childSerializers;
            }

            static {
                Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Track$.serializer.INSTANCE)), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Shelf.Lists.Type", (Enum[])Type.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
                $childSerializers = lazyArray;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Tracks$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Tracks;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<Tracks> serializer() {
                    return (KSerializer)Lists$Tracks$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Ldev/brahmkshatriya/echo/common/models/Shelf$Lists$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Linear", "Grid", "common"})
        public static final class Type
        extends Enum<Type> {
            public static final /* enum */ Type Linear = new Type();
            public static final /* enum */ Type Grid = new Type();
            private static final /* synthetic */ Type[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            public static Type[] values() {
                return (Type[])$VALUES.clone();
            }

            public static Type valueOf(String value2) {
                return Enum.valueOf(Type.class, value2);
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = typeArray = new Type[]{Type.Linear, Type.Grid};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }
}

