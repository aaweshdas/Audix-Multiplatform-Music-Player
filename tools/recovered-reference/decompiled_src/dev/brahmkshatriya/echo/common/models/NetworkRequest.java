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
 *  kotlin.io.encoding.Base64
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.NetworkRequest$;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 42\u00020\u0001:\u0003345B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\t\u0010\nB;\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\t\u0010\rBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\t\u0010\u0012J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J?\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020\u000fH\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001\u00a2\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u0016\u00a8\u00066"}, d2={"Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "", "url", "", "headers", "", "method", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;", "bodyBase64", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;Ljava/lang/String;)V", "body", "", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;Ljava/lang/String;Ljava/util/Map;[B)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Map;Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;", "getBodyBase64", "getBody", "()[B", "body$delegate", "Lkotlin/Lazy;", "lowerCaseHeaders", "getLowerCaseHeaders", "lowerCaseHeaders$delegate", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Method", "Companion", "$serializer", "common"})
@SourceDebugExtension(value={"SMAP\nNetworkRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkRequest.kt\ndev/brahmkshatriya/echo/common/models/NetworkRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,95:1\n1#2:96\n478#3:97\n424#3:98\n1252#4,4:99\n*S KotlinDebug\n*F\n+ 1 NetworkRequest.kt\ndev/brahmkshatriya/echo/common/models/NetworkRequest\n*L\n67#1:97\n67#1:98\n67#1:99,4\n*E\n"})
public final class NetworkRequest {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String url;
    @NotNull
    private final Map<String, String> headers;
    @NotNull
    private final Method method;
    @Nullable
    private final String bodyBase64;
    @NotNull
    private final Lazy body$delegate;
    @NotNull
    private final Lazy lowerCaseHeaders$delegate;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public NetworkRequest(@NotNull String url, @NotNull Map<String, String> headers, @NotNull Method method, @Nullable String bodyBase64) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        Intrinsics.checkNotNullParameter(headers, (String)"headers");
        Intrinsics.checkNotNullParameter((Object)((Object)method), (String)"method");
        this.url = url;
        this.headers = headers;
        this.method = method;
        this.bodyBase64 = bodyBase64;
        this.body$delegate = LazyKt.lazy(() -> NetworkRequest.body_delegate$lambda$1(this));
        this.lowerCaseHeaders$delegate = LazyKt.lazy(() -> NetworkRequest.lowerCaseHeaders_delegate$lambda$3(this));
    }

    public /* synthetic */ NetworkRequest(String string2, Map map2, Method method, String string3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 4) != 0) {
            method = Method.GET;
        }
        if ((n & 8) != 0) {
            string3 = null;
        }
        this(string2, map2, method, string3);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    @NotNull
    public final Method getMethod() {
        return this.method;
    }

    @Nullable
    public final String getBodyBase64() {
        return this.bodyBase64;
    }

    @Nullable
    public final byte[] getBody() {
        Lazy lazy = this.body$delegate;
        return (byte[])lazy.getValue();
    }

    @NotNull
    public final Map<String, String> getLowerCaseHeaders() {
        Lazy lazy = this.lowerCaseHeaders$delegate;
        return (Map)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    public NetworkRequest(@NotNull Method method, @NotNull String url, @NotNull Map<String, String> headers, @Nullable byte[] body) {
        String string2;
        Intrinsics.checkNotNullParameter((Object)((Object)method), (String)"method");
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        Intrinsics.checkNotNullParameter(headers, (String)"headers");
        NetworkRequest networkRequest = this;
        String string3 = url;
        Map<String, String> map2 = headers;
        Method method2 = method;
        if (body != null) {
            void it;
            byte[] byArray = body;
            Method method3 = method2;
            Map<String, String> map3 = map2;
            String string4 = string3;
            NetworkRequest networkRequest2 = networkRequest;
            boolean bl = false;
            String string5 = Base64.encode$default((Base64)((Base64)Base64.Default), (byte[])it, (int)0, (int)0, (int)6, null);
            networkRequest = networkRequest2;
            string3 = string4;
            map2 = map3;
            method2 = method3;
            string2 = string5;
        } else {
            string2 = null;
        }
        networkRequest(string3, map2, method2, string2);
    }

    public /* synthetic */ NetworkRequest(Method method, String string2, Map map2, byte[] byArray, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 8) != 0) {
            byArray = null;
        }
        this(method, string2, map2, byArray);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.headers;
    }

    @NotNull
    public final Method component3() {
        return this.method;
    }

    @Nullable
    public final String component4() {
        return this.bodyBase64;
    }

    @NotNull
    public final NetworkRequest copy(@NotNull String url, @NotNull Map<String, String> headers, @NotNull Method method, @Nullable String bodyBase64) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        Intrinsics.checkNotNullParameter(headers, (String)"headers");
        Intrinsics.checkNotNullParameter((Object)((Object)method), (String)"method");
        return new NetworkRequest(url, headers, method, bodyBase64);
    }

    public static /* synthetic */ NetworkRequest copy$default(NetworkRequest networkRequest, String string2, Map map2, Method method, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = networkRequest.url;
        }
        if ((n & 2) != 0) {
            map2 = networkRequest.headers;
        }
        if ((n & 4) != 0) {
            method = networkRequest.method;
        }
        if ((n & 8) != 0) {
            string3 = networkRequest.bodyBase64;
        }
        return networkRequest.copy(string2, map2, method, string3);
    }

    @NotNull
    public String toString() {
        return "NetworkRequest(url=" + this.url + ", headers=" + this.headers + ", method=" + this.method + ", bodyBase64=" + this.bodyBase64 + ")";
    }

    public int hashCode() {
        int result2 = this.url.hashCode();
        result2 = result2 * 31 + ((Object)this.headers).hashCode();
        result2 = result2 * 31 + this.method.hashCode();
        result2 = result2 * 31 + (this.bodyBase64 == null ? 0 : this.bodyBase64.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkRequest)) {
            return false;
        }
        NetworkRequest networkRequest = (NetworkRequest)other;
        if (!Intrinsics.areEqual((Object)this.url, (Object)networkRequest.url)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.headers, networkRequest.headers)) {
            return false;
        }
        if (this.method != networkRequest.method) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.bodyBase64, (Object)networkRequest.bodyBase64);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(NetworkRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.url);
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !Intrinsics.areEqual(self.headers, (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy)lazyArray[1].getValue(), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.method != Method.GET) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.method);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.bodyBase64 != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.bodyBase64);
        }
    }

    public /* synthetic */ NetworkRequest(int seen0, String url, Map headers, Method method, String bodyBase64, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.url = url;
        this.headers = (seen0 & 2) == 0 ? MapsKt.emptyMap() : headers;
        this.method = (seen0 & 4) == 0 ? Method.GET : method;
        this.bodyBase64 = (seen0 & 8) == 0 ? null : bodyBase64;
        this.body$delegate = LazyKt.lazy(() -> NetworkRequest._init_$lambda$6(this));
        this.lowerCaseHeaders$delegate = LazyKt.lazy(() -> NetworkRequest._init_$lambda$8(this));
    }

    private static final byte[] body_delegate$lambda$1(NetworkRequest this$0) {
        byte[] byArray;
        String string2 = this$0.bodyBase64;
        if (string2 != null) {
            String it = string2;
            boolean bl = false;
            byArray = Base64.decode$default((Base64)((Base64)Base64.Default), (CharSequence)it, (int)0, (int)0, (int)6, null);
        } else {
            byArray = null;
        }
        return byArray;
    }

    /*
     * WARNING - void declaration
     */
    private static final Map lowerCaseHeaders_delegate$lambda$3(NetworkRequest this$0) {
        void $this$mapKeysTo$iv$iv;
        Map<String, String> $this$mapKeys$iv = this$0.headers;
        boolean $i$f$mapKeys = false;
        Map<String, String> map2 = $this$mapKeys$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapKeys$iv.size()));
        boolean $i$f$mapKeysTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeysTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            String string2;
            void it$iv$iv;
            void it;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map3 = destination$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNullExpressionValue((Object)((String)it.getKey()).toLowerCase(Locale.ROOT), (String)"toLowerCase(...)");
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Map map4 = map3;
            boolean bl2 = false;
            entry = it$iv$iv.getValue();
            map4.put(string2, entry);
        }
        return destination$iv$iv;
    }

    private static final byte[] _init_$lambda$6(NetworkRequest this$0) {
        byte[] byArray;
        String string2 = this$0.bodyBase64;
        if (string2 != null) {
            String it = string2;
            boolean bl = false;
            byArray = Base64.decode$default((Base64)((Base64)Base64.Default), (CharSequence)it, (int)0, (int)0, (int)6, null);
        } else {
            byArray = null;
        }
        return byArray;
    }

    /*
     * WARNING - void declaration
     */
    private static final Map _init_$lambda$8(NetworkRequest this$0) {
        void $this$mapKeysTo$iv$iv;
        Map<String, String> $this$mapKeys$iv = this$0.headers;
        boolean $i$f$mapKeys = false;
        Map<String, String> map2 = $this$mapKeys$iv;
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapKeys$iv.size()));
        boolean $i$f$mapKeysTo = false;
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeysTo$iv$iv.entrySet();
        boolean $i$f$associateByTo = false;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            String string2;
            void it$iv$iv;
            void it;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map3 = destination$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNullExpressionValue((Object)((String)it.getKey()).toLowerCase(Locale.ROOT), (String)"toLowerCase(...)");
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            Map map4 = map3;
            boolean bl2 = false;
            entry = it$iv$iv.getValue();
            map4.put(string2, entry);
        }
        return destination$iv$iv;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.NetworkRequest.Method", (Enum[])Method.values())), null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u00a8\u0006\u000b"}, d2={"Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Companion;", "", "<init>", "()V", "toGetRequest", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "", "headers", "", "serializer", "Lkotlinx/serialization/KSerializer;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final NetworkRequest toGetRequest(@NotNull String $this$toGetRequest, @NotNull Map<String, String> headers) {
            Intrinsics.checkNotNullParameter((Object)$this$toGetRequest, (String)"<this>");
            Intrinsics.checkNotNullParameter(headers, (String)"headers");
            return new NetworkRequest($this$toGetRequest, headers, null, null, 12, null);
        }

        public static /* synthetic */ NetworkRequest toGetRequest$default(Companion companion, String string2, Map map2, int n, Object object) {
            if ((n & 1) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.toGetRequest(string2, map2);
        }

        @NotNull
        public final KSerializer<NetworkRequest> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Ldev/brahmkshatriya/echo/common/models/NetworkRequest$Method;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "PATCH", "HEAD", "OPTIONS", "TRACE", "CONNECT", "common"})
    public static final class Method
    extends Enum<Method> {
        public static final /* enum */ Method GET = new Method();
        public static final /* enum */ Method POST = new Method();
        public static final /* enum */ Method PUT = new Method();
        public static final /* enum */ Method DELETE = new Method();
        public static final /* enum */ Method PATCH = new Method();
        public static final /* enum */ Method HEAD = new Method();
        public static final /* enum */ Method OPTIONS = new Method();
        public static final /* enum */ Method TRACE = new Method();
        public static final /* enum */ Method CONNECT = new Method();
        private static final /* synthetic */ Method[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Method[] values() {
            return (Method[])$VALUES.clone();
        }

        public static Method valueOf(String value2) {
            return Enum.valueOf(Method.class, value2);
        }

        @NotNull
        public static EnumEntries<Method> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = methodArray = new Method[]{Method.GET, Method.POST, Method.PUT, Method.DELETE, Method.PATCH, Method.HEAD, Method.OPTIONS, Method.TRACE, Method.CONNECT};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

