/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.helpers;

import dev.brahmkshatriya.echo.common.helpers.Page$;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002$%B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001JE\u0010\u001a\u001a\u00020\u001b\"\n\b\u0001\u0010\u0001*\u0004\u0018\u00010\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00010\"H\u0001\u00a2\u0006\u0002\b#R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006&"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/Page;", "T", "", "data", "", "continuation", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData", "()Ljava/util/List;", "getContinuation", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeSerial0", "Lkotlinx/serialization/KSerializer;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Page<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<T> data;
    @Nullable
    private final String continuation;
    @JvmField
    @NotNull
    private static final SerialDescriptor $cachedDescriptor;

    public Page(@NotNull List<? extends T> data2, @Nullable String continuation) {
        Intrinsics.checkNotNullParameter(data2, (String)"data");
        this.data = data2;
        this.continuation = continuation;
    }

    @NotNull
    public final List<T> getData() {
        return this.data;
    }

    @Nullable
    public final String getContinuation() {
        return this.continuation;
    }

    @NotNull
    public final List<T> component1() {
        return this.data;
    }

    @Nullable
    public final String component2() {
        return this.continuation;
    }

    @NotNull
    public final Page<T> copy(@NotNull List<? extends T> data2, @Nullable String continuation) {
        Intrinsics.checkNotNullParameter(data2, (String)"data");
        return new Page<T>(data2, continuation);
    }

    public static /* synthetic */ Page copy$default(Page page, List list2, String string2, int n, Object object) {
        if ((n & 1) != 0) {
            list2 = page.data;
        }
        if ((n & 2) != 0) {
            string2 = page.continuation;
        }
        return page.copy(list2, string2);
    }

    @NotNull
    public String toString() {
        return "Page(data=" + this.data + ", continuation=" + this.continuation + ")";
    }

    public int hashCode() {
        int result2 = ((Object)this.data).hashCode();
        result2 = result2 * 31 + (this.continuation == null ? 0 : this.continuation.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Page)) {
            return false;
        }
        Page page = (Page)other;
        if (!Intrinsics.areEqual(this.data, page.data)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.continuation, (Object)page.continuation);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Page self, CompositeEncoder output, SerialDescriptor serialDesc, KSerializer typeSerial0) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy)new ArrayListSerializer(typeSerial0), self.data);
        output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.continuation);
    }

    public /* synthetic */ Page(int seen0, List data2, String continuation, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$cachedDescriptor);
        }
        this.data = data2;
        this.continuation = continuation;
    }

    static {
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dev.brahmkshatriya.echo.common.helpers.Page", null, 2);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.addElement("continuation", false);
        $cachedDescriptor = (SerialDescriptor)pluginGeneratedSerialDescriptor;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00060\u0005\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/Page$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "T", "typeSerial0", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T> KSerializer<Page<T>> serializer(@NotNull KSerializer<T> typeSerial0) {
            Intrinsics.checkNotNullParameter(typeSerial0, (String)"typeSerial0");
            return (KSerializer)new $serializer<T>(typeSerial0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

