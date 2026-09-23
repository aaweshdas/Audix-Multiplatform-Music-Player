/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
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
 *  kotlinx.serialization.internal.BooleanSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions;

import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.extensions.MediaState$Loaded$;
import dev.brahmkshatriya.echo.extensions.MediaState$Unloaded$;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u0011*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003\u000f\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0012\u0013\u00a8\u0006\u0014\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState;", "T", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "", "extensionId", "", "getExtensionId", "()Ljava/lang/String;", "item", "getItem", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "loaded", "", "getLoaded", "()Z", "Loaded", "Unloaded", "Companion", "Ldev/brahmkshatriya/echo/extensions/MediaState$Loaded;", "Ldev/brahmkshatriya/echo/extensions/MediaState$Unloaded;", "app_debug"})
public sealed interface MediaState<T extends EchoMediaItem> {
    @NotNull
    public static final Companion Companion = dev.brahmkshatriya.echo.extensions.MediaState$Companion.$$INSTANCE;

    @NotNull
    public String getExtensionId();

    @NotNull
    public T getItem();

    public boolean getLoaded();

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/extensions/MediaState;", "T", "typeSerial0", "app_debug"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final <T> KSerializer<MediaState<T>> serializer(@NotNull KSerializer<T> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, (String)"typeSerial0");
            KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(Loaded.class), Reflection.getOrCreateKotlinClass(Unloaded.class)};
            KClass[] kClassArray2 = kClassArray;
            kClassArray = new KSerializer[]{new Loaded$$serializer<T>(typeSerial0), new Unloaded$$serializer<T>(typeSerial0)};
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.extensions.MediaState", Reflection.getOrCreateKotlinClass(MediaState.class), kClassArray2, (KSerializer[])kClassArray, new Annotation[0]);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 2*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u000212BY\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011By\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0017JE\u0010&\u001a\u00020'\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00010/H\u0001\u00a2\u0006\u0002\b0R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0007\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u000b\u0010\u001dR\u0015\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\f\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\r\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0014\u0010\u0014\u001a\u00020\bX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010#\u00a8\u00063"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState$Loaded;", "T", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "Ldev/brahmkshatriya/echo/extensions/MediaState;", "extensionId", "", "item", "isFollowed", "", "followers", "", "isSaved", "isLiked", "isHidden", "showRadio", "showShare", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZ)V", "seen0", "", "loaded", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExtensionId", "()Ljava/lang/String;", "getItem", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFollowers", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowRadio", "()Z", "getShowShare", "getLoaded", "write$Self", "", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
    public static final class Loaded<T extends EchoMediaItem>
    implements MediaState<T> {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String extensionId;
        @NotNull
        private final T item;
        @Nullable
        private final Boolean isFollowed;
        @Nullable
        private final Long followers;
        @Nullable
        private final Boolean isSaved;
        @Nullable
        private final Boolean isLiked;
        @Nullable
        private final Boolean isHidden;
        private final boolean showRadio;
        private final boolean showShare;
        private final boolean loaded;
        @JvmField
        @NotNull
        private static final SerialDescriptor $cachedDescriptor;

        public Loaded(@NotNull String extensionId, @NotNull T item2, @Nullable Boolean isFollowed2, @Nullable Long followers2, @Nullable Boolean isSaved2, @Nullable Boolean isLiked2, @Nullable Boolean isHidden2, boolean showRadio, boolean showShare) {
            Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
            Intrinsics.checkNotNullParameter(item2, (String)"item");
            this.extensionId = extensionId;
            this.item = item2;
            this.isFollowed = isFollowed2;
            this.followers = followers2;
            this.isSaved = isSaved2;
            this.isLiked = isLiked2;
            this.isHidden = isHidden2;
            this.showRadio = showRadio;
            this.showShare = showShare;
            this.loaded = true;
        }

        @Override
        @NotNull
        public String getExtensionId() {
            return this.extensionId;
        }

        @Override
        @NotNull
        public T getItem() {
            return this.item;
        }

        @Nullable
        public final Boolean isFollowed() {
            return this.isFollowed;
        }

        @Nullable
        public final Long getFollowers() {
            return this.followers;
        }

        @Nullable
        public final Boolean isSaved() {
            return this.isSaved;
        }

        @Nullable
        public final Boolean isLiked() {
            return this.isLiked;
        }

        @Nullable
        public final Boolean isHidden() {
            return this.isHidden;
        }

        public final boolean getShowRadio() {
            return this.showRadio;
        }

        public final boolean getShowShare() {
            return this.showShare;
        }

        @Override
        public boolean getLoaded() {
            return this.loaded;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_debug(Loaded self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
            output.encodeStringElement(serialDesc, 0, self.getExtensionId());
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)typeSerial0, self.getItem());
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)BooleanSerializer.INSTANCE, (Object)self.isFollowed);
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.followers);
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)BooleanSerializer.INSTANCE, (Object)self.isSaved);
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)BooleanSerializer.INSTANCE, (Object)self.isLiked);
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)BooleanSerializer.INSTANCE, (Object)self.isHidden);
            output.encodeBooleanElement(serialDesc, 7, self.showRadio);
            output.encodeBooleanElement(serialDesc, 8, self.showShare);
            if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : !self.getLoaded()) {
                output.encodeBooleanElement(serialDesc, 9, self.getLoaded());
            }
        }

        public /* synthetic */ Loaded(int seen0, String extensionId, EchoMediaItem item2, Boolean isFollowed2, Long followers2, Boolean isSaved2, Boolean isLiked2, Boolean isHidden2, boolean showRadio, boolean showShare, boolean loaded, SerializationConstructorMarker serializationConstructorMarker) {
            if (511 != (0x1FF & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)511, (SerialDescriptor)$cachedDescriptor);
            }
            this.extensionId = extensionId;
            this.item = item2;
            this.isFollowed = isFollowed2;
            this.followers = followers2;
            this.isSaved = isSaved2;
            this.isLiked = isLiked2;
            this.isHidden = isHidden2;
            this.showRadio = showRadio;
            this.showShare = showShare;
            this.loaded = (seen0 & 0x200) == 0 ? true : loaded;
        }

        static {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dev.brahmkshatriya.echo.extensions.MediaState.Loaded", null, 10);
            pluginGeneratedSerialDescriptor.addElement("extensionId", false);
            pluginGeneratedSerialDescriptor.addElement("item", false);
            pluginGeneratedSerialDescriptor.addElement("isFollowed", false);
            pluginGeneratedSerialDescriptor.addElement("followers", false);
            pluginGeneratedSerialDescriptor.addElement("isSaved", false);
            pluginGeneratedSerialDescriptor.addElement("isLiked", false);
            pluginGeneratedSerialDescriptor.addElement("isHidden", false);
            pluginGeneratedSerialDescriptor.addElement("showRadio", false);
            pluginGeneratedSerialDescriptor.addElement("showShare", false);
            pluginGeneratedSerialDescriptor.addElement("loaded", true);
            $cachedDescriptor = (SerialDescriptor)pluginGeneratedSerialDescriptor;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0002\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState$Loaded$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/extensions/MediaState$Loaded;", "T", "typeSerial0", "app_debug"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final <T> KSerializer<Loaded<T>> serializer(@NotNull KSerializer<T> typeSerial0) {
                Intrinsics.checkNotNullParameter(typeSerial0, (String)"typeSerial0");
                return (KSerializer)new Loaded$$serializer<T>(typeSerial0);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002*+B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0007\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000e\u0010\u0018\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00028\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\nH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001JE\u0010 \u001a\u00020!\"\n\b\u0002\u0010\u0001*\u0004\u0018\u00010\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00010(H\u0001\u00a2\u0006\u0002\b)R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00028\u0001X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006,"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState$Unloaded;", "T", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "Ldev/brahmkshatriya/echo/extensions/MediaState;", "extensionId", "", "item", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;)V", "seen0", "", "loaded", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getExtensionId", "()Ljava/lang/String;", "getItem", "()Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getLoaded", "()Z", "component1", "component2", "copy", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;)Ldev/brahmkshatriya/echo/extensions/MediaState$Unloaded;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
    public static final class Unloaded<T extends EchoMediaItem>
    implements MediaState<T> {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String extensionId;
        @NotNull
        private final T item;
        private final boolean loaded;
        @JvmField
        @NotNull
        private static final SerialDescriptor $cachedDescriptor;

        public Unloaded(@NotNull String extensionId, @NotNull T item2) {
            Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
            Intrinsics.checkNotNullParameter(item2, (String)"item");
            this.extensionId = extensionId;
            this.item = item2;
        }

        @Override
        @NotNull
        public String getExtensionId() {
            return this.extensionId;
        }

        @Override
        @NotNull
        public T getItem() {
            return this.item;
        }

        @Override
        public boolean getLoaded() {
            return this.loaded;
        }

        @NotNull
        public final String component1() {
            return this.extensionId;
        }

        @NotNull
        public final T component2() {
            return this.item;
        }

        @NotNull
        public final Unloaded<T> copy(@NotNull String extensionId, @NotNull T item2) {
            Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
            Intrinsics.checkNotNullParameter(item2, (String)"item");
            return new Unloaded<T>(extensionId, item2);
        }

        public static /* synthetic */ Unloaded copy$default(Unloaded unloaded, String string2, EchoMediaItem echoMediaItem, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = unloaded.extensionId;
            }
            if ((n & 2) != 0) {
                echoMediaItem = unloaded.item;
            }
            return unloaded.copy(string2, echoMediaItem);
        }

        @NotNull
        public String toString() {
            return "Unloaded(extensionId=" + this.extensionId + ", item=" + this.item + ")";
        }

        public int hashCode() {
            int result2 = this.extensionId.hashCode();
            result2 = result2 * 31 + this.item.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unloaded)) {
                return false;
            }
            Unloaded unloaded = (Unloaded)other;
            if (!Intrinsics.areEqual((Object)this.extensionId, (Object)unloaded.extensionId)) {
                return false;
            }
            return Intrinsics.areEqual(this.item, unloaded.item);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$app_debug(Unloaded self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
            output.encodeStringElement(serialDesc, 0, self.getExtensionId());
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)typeSerial0, self.getItem());
            if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.getLoaded()) {
                output.encodeBooleanElement(serialDesc, 2, self.getLoaded());
            }
        }

        public /* synthetic */ Unloaded(int seen0, String extensionId, EchoMediaItem item2, boolean loaded, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$cachedDescriptor);
            }
            this.extensionId = extensionId;
            this.item = item2;
            this.loaded = (seen0 & 4) == 0 ? false : loaded;
        }

        static {
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dev.brahmkshatriya.echo.extensions.MediaState.Unloaded", null, 3);
            pluginGeneratedSerialDescriptor.addElement("extensionId", false);
            pluginGeneratedSerialDescriptor.addElement("item", false);
            pluginGeneratedSerialDescriptor.addElement("loaded", true);
            $cachedDescriptor = (SerialDescriptor)pluginGeneratedSerialDescriptor;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0002\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/extensions/MediaState$Unloaded$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/extensions/MediaState$Unloaded;", "T", "typeSerial0", "app_debug"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final <T> KSerializer<Unloaded<T>> serializer(@NotNull KSerializer<T> typeSerial0) {
                Intrinsics.checkNotNullParameter(typeSerial0, (String)"typeSerial0");
                return (KSerializer)new Unloaded$$serializer<T>(typeSerial0);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

