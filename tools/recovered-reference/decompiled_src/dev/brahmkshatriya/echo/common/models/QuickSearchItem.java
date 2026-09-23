/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
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
import dev.brahmkshatriya.echo.common.models.QuickSearchItem$Media$;
import dev.brahmkshatriya.echo.common.models.QuickSearchItem$Query$;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonClassDiscriminator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClassDiscriminator(discriminator="quickSearchItemType")
@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001a\u001b\u001cB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0000J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u0012\u0010\t\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u001d\u001e\u00a8\u0006\u001f"}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "searched", "", "getSearched", "()Z", "title", "", "getTitle", "()Ljava/lang/String;", "sameAs", "other", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Query", "Media", "Companion", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Media;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Query;", "common"})
public abstract sealed class QuickSearchItem {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
        Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Media.class), Reflection.getOrCreateKotlinClass(Query.class)};
        KClass[] kClassArray = objectArray;
        objectArray = new KSerializer[]{Media$$serializer.INSTANCE, Query$$serializer.INSTANCE};
        KClass[] kClassArray2 = objectArray;
        objectArray = new Annotation[]{new JsonClassDiscriminator("quickSearchItemType"){
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
        return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.QuickSearchItem", Reflection.getOrCreateKotlinClass(QuickSearchItem.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
    });

    private QuickSearchItem() {
    }

    public abstract boolean getSearched();

    @NotNull
    public String getTitle() {
        String string2;
        QuickSearchItem quickSearchItem = this;
        if (quickSearchItem instanceof Query) {
            string2 = ((Query)this).getQuery();
        } else if (quickSearchItem instanceof Media) {
            string2 = ((Media)this).getMedia().getTitle();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return string2;
    }

    public final boolean sameAs(@NotNull QuickSearchItem other) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        QuickSearchItem quickSearchItem = this;
        if (quickSearchItem instanceof Query) {
            bl = other instanceof Query && Intrinsics.areEqual((Object)((Query)this).getQuery(), (Object)((Query)other).getQuery());
        } else if (quickSearchItem instanceof Media) {
            bl = other instanceof Media && ((Media)this).getMedia().sameAs(((Media)other).getMedia());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return bl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(QuickSearchItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public /* synthetic */ QuickSearchItem(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ QuickSearchItem(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<QuickSearchItem> serializer() {
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
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001\u00a2\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Media;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "media", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "searched", "", "<init>", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMedia", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getSearched", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Media
    extends QuickSearchItem {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final EchoMediaItem media;
        private final boolean searched;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public Media(@NotNull EchoMediaItem media, boolean searched) {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            super(null);
            this.media = media;
            this.searched = searched;
        }

        @NotNull
        public final EchoMediaItem getMedia() {
            return this.media;
        }

        @Override
        public boolean getSearched() {
            return this.searched;
        }

        @NotNull
        public final EchoMediaItem component1() {
            return this.media;
        }

        public final boolean component2() {
            return this.searched;
        }

        @NotNull
        public final Media copy(@NotNull EchoMediaItem media, boolean searched) {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            return new Media(media, searched);
        }

        public static /* synthetic */ Media copy$default(Media media, EchoMediaItem echoMediaItem, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                echoMediaItem = media.media;
            }
            if ((n & 2) != 0) {
                bl = media.searched;
            }
            return media.copy(echoMediaItem, bl);
        }

        @NotNull
        public String toString() {
            return "Media(media=" + this.media + ", searched=" + this.searched + ")";
        }

        public int hashCode() {
            int result2 = this.media.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.searched);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Media)) {
                return false;
            }
            Media media = (Media)other;
            if (!Intrinsics.areEqual((Object)this.media, (Object)media.media)) {
                return false;
            }
            return this.searched == media.searched;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Media self, CompositeEncoder output, SerialDescriptor serialDesc) {
            QuickSearchItem.write$Self(self, output, serialDesc);
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)lazyArray[0].getValue(), (Object)self.media);
            output.encodeBooleanElement(serialDesc, 1, self.getSearched());
        }

        public /* synthetic */ Media(int seen0, EchoMediaItem media, boolean searched, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Media$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.media = media;
            this.searched = searched;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EchoMediaItem.Companion.serializer()), null};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Media$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Media;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Media> serializer() {
                return (KSerializer)Media$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001\u00a2\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006("}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Query;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "query", "", "searched", "", "extras", "", "<init>", "(Ljava/lang/String;ZLjava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuery", "()Ljava/lang/String;", "getSearched", "()Z", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class Query
    extends QuickSearchItem {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String query;
        private final boolean searched;
        @NotNull
        private final Map<String, String> extras;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;

        public Query(@NotNull String query, boolean searched, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)query, (String)"query");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            super(null);
            this.query = query;
            this.searched = searched;
            this.extras = extras;
        }

        public /* synthetic */ Query(String string2, boolean bl, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                map2 = MapsKt.emptyMap();
            }
            this(string2, bl, map2);
        }

        @NotNull
        public final String getQuery() {
            return this.query;
        }

        @Override
        public boolean getSearched() {
            return this.searched;
        }

        @NotNull
        public final Map<String, String> getExtras() {
            return this.extras;
        }

        @NotNull
        public final String component1() {
            return this.query;
        }

        public final boolean component2() {
            return this.searched;
        }

        @NotNull
        public final Map<String, String> component3() {
            return this.extras;
        }

        @NotNull
        public final Query copy(@NotNull String query, boolean searched, @NotNull Map<String, String> extras) {
            Intrinsics.checkNotNullParameter((Object)query, (String)"query");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return new Query(query, searched, extras);
        }

        public static /* synthetic */ Query copy$default(Query query, String string2, boolean bl, Map map2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = query.query;
            }
            if ((n & 2) != 0) {
                bl = query.searched;
            }
            if ((n & 4) != 0) {
                map2 = query.extras;
            }
            return query.copy(string2, bl, map2);
        }

        @NotNull
        public String toString() {
            return "Query(query=" + this.query + ", searched=" + this.searched + ", extras=" + this.extras + ")";
        }

        public int hashCode() {
            int result2 = this.query.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.searched);
            result2 = result2 * 31 + ((Object)this.extras).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Query)) {
                return false;
            }
            Query query = (Query)other;
            if (!Intrinsics.areEqual((Object)this.query, (Object)query.query)) {
                return false;
            }
            if (this.searched != query.searched) {
                return false;
            }
            return Intrinsics.areEqual(this.extras, query.extras);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Query self, CompositeEncoder output, SerialDescriptor serialDesc) {
            QuickSearchItem.write$Self(self, output, serialDesc);
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.query);
            output.encodeBooleanElement(serialDesc, 1, self.getSearched());
            if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual(self.extras, (Object)MapsKt.emptyMap())) {
                output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), self.extras);
            }
        }

        public /* synthetic */ Query(int seen0, String query, boolean searched, Map extras, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)Query$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.query = query;
            this.searched = searched;
            this.extras = (seen0 & 4) == 0 ? MapsKt.emptyMap() : extras;
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE))};
            $childSerializers = lazyArray;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Query$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem$Query;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<Query> serializer() {
                return (KSerializer)Query$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

