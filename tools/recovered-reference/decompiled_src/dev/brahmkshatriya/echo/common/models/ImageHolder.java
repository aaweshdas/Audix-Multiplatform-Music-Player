/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  kotlin.text.Regex
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.ImageHolder$HexColorImageHolder$;
import dev.brahmkshatriya.echo.common.models.ImageHolder$NetworkRequestImageHolder$;
import dev.brahmkshatriya.echo.common.models.ImageHolder$ResourceIdImageHolder$;
import dev.brahmkshatriya.echo.common.models.ImageHolder$ResourceUriImageHolder$;
import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import dev.brahmkshatriya.echo.common.models.NetworkRequest$;
import java.lang.annotation.Annotation;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00182\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u0012\u0010\t\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "crop", "", "getCrop", "()Z", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "NetworkRequestImageHolder", "ResourceUriImageHolder", "ResourceIdImageHolder", "HexColorImageHolder", "Companion", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$HexColorImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$NetworkRequestImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceIdImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceUriImageHolder;", "common"})
public abstract sealed class ImageHolder {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Regex hexPattern = new Regex("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$");
    @NotNull
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> {
        KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(HexColorImageHolder.class), Reflection.getOrCreateKotlinClass(NetworkRequestImageHolder.class), Reflection.getOrCreateKotlinClass(ResourceIdImageHolder.class), Reflection.getOrCreateKotlinClass(ResourceUriImageHolder.class)};
        KClass[] kClassArray2 = kClassArray;
        kClassArray = new KSerializer[]{HexColorImageHolder$$serializer.INSTANCE, NetworkRequestImageHolder$$serializer.INSTANCE, ResourceIdImageHolder$$serializer.INSTANCE, ResourceUriImageHolder$$serializer.INSTANCE};
        return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.ImageHolder", Reflection.getOrCreateKotlinClass(ImageHolder.class), kClassArray2, (KSerializer[])kClassArray, new Annotation[0]);
    });

    private ImageHolder() {
    }

    public abstract boolean getCrop();

    @JvmStatic
    public static final /* synthetic */ void write$Self(ImageHolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    public /* synthetic */ ImageHolder(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ ImageHolder(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u00020\u000e*\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\fJ\n\u0010\u0012\u001a\u00020\u0013*\u00020\bJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$Companion;", "", "<init>", "()V", "hexPattern", "Lkotlin/text/Regex;", "toImageHolder", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$NetworkRequestImageHolder;", "", "headers", "", "crop", "", "toResourceUriImageHolder", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceUriImageHolder;", "toResourceImageHolder", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceIdImageHolder;", "", "toHexColorImageHolder", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$HexColorImageHolder;", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final NetworkRequestImageHolder toImageHolder(@NotNull String $this$toImageHolder, @NotNull Map<String, String> headers, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)$this$toImageHolder, (String)"<this>");
            Intrinsics.checkNotNullParameter(headers, (String)"headers");
            return new NetworkRequestImageHolder(NetworkRequest.Companion.toGetRequest($this$toImageHolder, headers), crop);
        }

        public static /* synthetic */ NetworkRequestImageHolder toImageHolder$default(Companion companion, String string2, Map map2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                map2 = MapsKt.emptyMap();
            }
            if ((n & 2) != 0) {
                bl = false;
            }
            return companion.toImageHolder(string2, map2, bl);
        }

        @NotNull
        public final ResourceUriImageHolder toResourceUriImageHolder(@NotNull String $this$toResourceUriImageHolder, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)$this$toResourceUriImageHolder, (String)"<this>");
            return new ResourceUriImageHolder($this$toResourceUriImageHolder, crop);
        }

        public static /* synthetic */ ResourceUriImageHolder toResourceUriImageHolder$default(Companion companion, String string2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                bl = false;
            }
            return companion.toResourceUriImageHolder(string2, bl);
        }

        @NotNull
        public final ResourceIdImageHolder toResourceImageHolder(int $this$toResourceImageHolder, boolean crop) {
            return new ResourceIdImageHolder($this$toResourceImageHolder, crop);
        }

        public static /* synthetic */ ResourceIdImageHolder toResourceImageHolder$default(Companion companion, int n, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                bl = false;
            }
            return companion.toResourceImageHolder(n, bl);
        }

        @NotNull
        public final HexColorImageHolder toHexColorImageHolder(@NotNull String $this$toHexColorImageHolder) {
            Intrinsics.checkNotNullParameter((Object)$this$toHexColorImageHolder, (String)"<this>");
            return new HexColorImageHolder($this$toHexColorImageHolder);
        }

        @NotNull
        public final KSerializer<ImageHolder> serializer() {
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
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B-\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0004\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0001\u00a2\u0006\u0002\b\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$HexColorImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "hex", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "crop", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHex", "()Ljava/lang/String;", "getCrop", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class HexColorImageHolder
    extends ImageHolder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String hex;
        private final boolean crop;

        public HexColorImageHolder(@NotNull String hex) {
            Intrinsics.checkNotNullParameter((Object)hex, (String)"hex");
            super(null);
            this.hex = hex;
            if (!hexPattern.matches((CharSequence)this.hex)) {
                boolean bl = false;
                String string2 = "Invalid hex color format: " + this.hex + ". Use #RRGGBB or #AARRGGBB.";
                throw new IllegalArgumentException(string2.toString());
            }
        }

        @NotNull
        public final String getHex() {
            return this.hex;
        }

        @Override
        public boolean getCrop() {
            return this.crop;
        }

        @NotNull
        public final String component1() {
            return this.hex;
        }

        @NotNull
        public final HexColorImageHolder copy(@NotNull String hex) {
            Intrinsics.checkNotNullParameter((Object)hex, (String)"hex");
            return new HexColorImageHolder(hex);
        }

        public static /* synthetic */ HexColorImageHolder copy$default(HexColorImageHolder hexColorImageHolder, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = hexColorImageHolder.hex;
            }
            return hexColorImageHolder.copy(string2);
        }

        @NotNull
        public String toString() {
            return "HexColorImageHolder(hex=" + this.hex + ")";
        }

        public int hashCode() {
            return this.hex.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HexColorImageHolder)) {
                return false;
            }
            HexColorImageHolder hexColorImageHolder = (HexColorImageHolder)other;
            return Intrinsics.areEqual((Object)this.hex, (Object)hexColorImageHolder.hex);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(HexColorImageHolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ImageHolder.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.hex);
            if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.getCrop()) {
                output.encodeBooleanElement(serialDesc, 1, self.getCrop());
            }
        }

        public /* synthetic */ HexColorImageHolder(int seen0, String hex, boolean crop, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (1 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)HexColorImageHolder$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.hex = hex;
            if (!hexPattern.matches((CharSequence)this.hex)) {
                boolean bl = false;
                String string2 = "Invalid hex color format: " + this.hex + ". Use #RRGGBB or #AARRGGBB.";
                throw new IllegalArgumentException(string2.toString());
            }
            this.crop = (seen0 & 2) == 0 ? false : crop;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$HexColorImageHolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$HexColorImageHolder;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<HexColorImageHolder> serializer() {
                return (KSerializer)HexColorImageHolder$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001\u00a2\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$NetworkRequestImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "request", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "crop", "", "<init>", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILdev/brahmkshatriya/echo/common/models/NetworkRequest;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequest", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "getCrop", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class NetworkRequestImageHolder
    extends ImageHolder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final NetworkRequest request;
        private final boolean crop;

        public NetworkRequestImageHolder(@NotNull NetworkRequest request, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)request, (String)"request");
            super(null);
            this.request = request;
            this.crop = crop;
        }

        @NotNull
        public final NetworkRequest getRequest() {
            return this.request;
        }

        @Override
        public boolean getCrop() {
            return this.crop;
        }

        @NotNull
        public final NetworkRequest component1() {
            return this.request;
        }

        public final boolean component2() {
            return this.crop;
        }

        @NotNull
        public final NetworkRequestImageHolder copy(@NotNull NetworkRequest request, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)request, (String)"request");
            return new NetworkRequestImageHolder(request, crop);
        }

        public static /* synthetic */ NetworkRequestImageHolder copy$default(NetworkRequestImageHolder networkRequestImageHolder, NetworkRequest networkRequest, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                networkRequest = networkRequestImageHolder.request;
            }
            if ((n & 2) != 0) {
                bl = networkRequestImageHolder.crop;
            }
            return networkRequestImageHolder.copy(networkRequest, bl);
        }

        @NotNull
        public String toString() {
            return "NetworkRequestImageHolder(request=" + this.request + ", crop=" + this.crop + ")";
        }

        public int hashCode() {
            int result2 = this.request.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.crop);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkRequestImageHolder)) {
                return false;
            }
            NetworkRequestImageHolder networkRequestImageHolder = (NetworkRequestImageHolder)other;
            if (!Intrinsics.areEqual((Object)this.request, (Object)networkRequestImageHolder.request)) {
                return false;
            }
            return this.crop == networkRequestImageHolder.crop;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(NetworkRequestImageHolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ImageHolder.write$Self(self, output, serialDesc);
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)NetworkRequest$.serializer.INSTANCE, (Object)self.request);
            output.encodeBooleanElement(serialDesc, 1, self.getCrop());
        }

        public /* synthetic */ NetworkRequestImageHolder(int seen0, NetworkRequest request, boolean crop, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)NetworkRequestImageHolder$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.request = request;
            this.crop = crop;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$NetworkRequestImageHolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$NetworkRequestImageHolder;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<NetworkRequestImageHolder> serializer() {
                return (KSerializer)NetworkRequestImageHolder$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001\u00a2\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006#"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceIdImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "resId", "", "crop", "", "<init>", "(IZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResId", "()I", "getCrop", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class ResourceIdImageHolder
    extends ImageHolder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final int resId;
        private final boolean crop;

        public ResourceIdImageHolder(int resId, boolean crop) {
            super(null);
            this.resId = resId;
            this.crop = crop;
        }

        public final int getResId() {
            return this.resId;
        }

        @Override
        public boolean getCrop() {
            return this.crop;
        }

        public final int component1() {
            return this.resId;
        }

        public final boolean component2() {
            return this.crop;
        }

        @NotNull
        public final ResourceIdImageHolder copy(int resId, boolean crop) {
            return new ResourceIdImageHolder(resId, crop);
        }

        public static /* synthetic */ ResourceIdImageHolder copy$default(ResourceIdImageHolder resourceIdImageHolder, int n, boolean bl, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = resourceIdImageHolder.resId;
            }
            if ((n2 & 2) != 0) {
                bl = resourceIdImageHolder.crop;
            }
            return resourceIdImageHolder.copy(n, bl);
        }

        @NotNull
        public String toString() {
            return "ResourceIdImageHolder(resId=" + this.resId + ", crop=" + this.crop + ")";
        }

        public int hashCode() {
            int result2 = Integer.hashCode(this.resId);
            result2 = result2 * 31 + Boolean.hashCode(this.crop);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceIdImageHolder)) {
                return false;
            }
            ResourceIdImageHolder resourceIdImageHolder = (ResourceIdImageHolder)other;
            if (this.resId != resourceIdImageHolder.resId) {
                return false;
            }
            return this.crop == resourceIdImageHolder.crop;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(ResourceIdImageHolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ImageHolder.write$Self(self, output, serialDesc);
            output.encodeIntElement(serialDesc, 0, self.resId);
            output.encodeBooleanElement(serialDesc, 1, self.getCrop());
        }

        public /* synthetic */ ResourceIdImageHolder(int seen0, int resId, boolean crop, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)ResourceIdImageHolder$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.resId = resId;
            this.crop = crop;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceIdImageHolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceIdImageHolder;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ResourceIdImageHolder> serializer() {
                return (KSerializer)ResourceIdImageHolder$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001\u00a2\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceUriImageHolder;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "uri", "", "crop", "", "<init>", "(Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUri", "()Ljava/lang/String;", "getCrop", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
    public static final class ResourceUriImageHolder
    extends ImageHolder {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String uri;
        private final boolean crop;

        public ResourceUriImageHolder(@NotNull String uri, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
            super(null);
            this.uri = uri;
            this.crop = crop;
        }

        @NotNull
        public final String getUri() {
            return this.uri;
        }

        @Override
        public boolean getCrop() {
            return this.crop;
        }

        @NotNull
        public final String component1() {
            return this.uri;
        }

        public final boolean component2() {
            return this.crop;
        }

        @NotNull
        public final ResourceUriImageHolder copy(@NotNull String uri, boolean crop) {
            Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
            return new ResourceUriImageHolder(uri, crop);
        }

        public static /* synthetic */ ResourceUriImageHolder copy$default(ResourceUriImageHolder resourceUriImageHolder, String string2, boolean bl, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = resourceUriImageHolder.uri;
            }
            if ((n & 2) != 0) {
                bl = resourceUriImageHolder.crop;
            }
            return resourceUriImageHolder.copy(string2, bl);
        }

        @NotNull
        public String toString() {
            return "ResourceUriImageHolder(uri=" + this.uri + ", crop=" + this.crop + ")";
        }

        public int hashCode() {
            int result2 = this.uri.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.crop);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceUriImageHolder)) {
                return false;
            }
            ResourceUriImageHolder resourceUriImageHolder = (ResourceUriImageHolder)other;
            if (!Intrinsics.areEqual((Object)this.uri, (Object)resourceUriImageHolder.uri)) {
                return false;
            }
            return this.crop == resourceUriImageHolder.crop;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(ResourceUriImageHolder self, CompositeEncoder output, SerialDescriptor serialDesc) {
            ImageHolder.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.uri);
            output.encodeBooleanElement(serialDesc, 1, self.getCrop());
        }

        public /* synthetic */ ResourceUriImageHolder(int seen0, String uri, boolean crop, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (3 & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)ResourceUriImageHolder$$serializer.INSTANCE.getDescriptor());
            }
            super(seen0, serializationConstructorMarker);
            this.uri = uri;
            this.crop = crop;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceUriImageHolder$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/ImageHolder$ResourceUriImageHolder;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ResourceUriImageHolder> serializer() {
                return (KSerializer)ResourceUriImageHolder$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

