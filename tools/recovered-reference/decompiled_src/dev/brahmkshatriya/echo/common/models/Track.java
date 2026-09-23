/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.ObjectSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Album$;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.Artist$;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.Date$;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Streamable;
import dev.brahmkshatriya.echo.common.models.Streamable$;
import dev.brahmkshatriya.echo.common.models.Track$;
import dev.brahmkshatriya.echo.common.models.Track$Playable$No$;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bL\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 \u008b\u00012\u00020\u0001:\b\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001B\u00d3\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n\u0012\b\b\u0002\u0010$\u001a\u00020\u001c\u0012\b\b\u0002\u0010%\u001a\u00020\u001c\u0012\b\b\u0002\u0010&\u001a\u00020\u001c\u0012\b\b\u0002\u0010'\u001a\u00020\u001c\u0012\b\b\u0002\u0010(\u001a\u00020\u001c\u0012\b\b\u0002\u0010)\u001a\u00020\u001c\u00a2\u0006\u0004\b*\u0010+B\u00d7\u0002\b\u0010\u0012\u0006\u0010,\u001a\u00020-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\n\u0012\u0006\u0010$\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\u001c\u0012\u0006\u0010'\u001a\u00020\u001c\u0012\u0006\u0010(\u001a\u00020\u001c\u0012\u0006\u0010)\u001a\u00020\u001c\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\b\u00100\u001a\u0004\u0018\u000101\u00a2\u0006\u0004\b*\u00102J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\t\u0010_\u001a\u00020\u0003H\u00c6\u0003J\t\u0010`\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\rH\u00c6\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010e\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010f\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u000b\u0010g\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u00c6\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u0010\u0010m\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010?J\u000b\u0010n\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\t\u0010o\u001a\u00020\u001cH\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001fH\u00c6\u0003J\t\u0010r\u001a\u00020!H\u00c6\u0003J\u000f\u0010s\u001a\b\u0012\u0004\u0012\u00020#0\nH\u00c6\u0003J\t\u0010t\u001a\u00020\u001cH\u00c6\u0003J\t\u0010u\u001a\u00020\u001cH\u00c6\u0003J\t\u0010v\u001a\u00020\u001cH\u00c6\u0003J\t\u0010w\u001a\u00020\u001cH\u00c6\u0003J\t\u0010x\u001a\u00020\u001cH\u00c6\u0003J\t\u0010y\u001a\u00020\u001cH\u00c6\u0003J\u00de\u0002\u0010z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n2\b\b\u0002\u0010$\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020\u001c2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010)\u001a\u00020\u001cH\u00c6\u0001\u00a2\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020\u001c2\b\u0010}\u001a\u0004\u0018\u00010~H\u00d6\u0003J\t\u0010\u007f\u001a\u00020-H\u00d6\u0001J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00d6\u0001J-\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u00002\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0001\u00a2\u0006\u0003\b\u0088\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\b>\u0010?R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bA\u0010?R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bB\u0010?R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00109R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010;R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bI\u0010?R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010@\u001a\u0004\bJ\u0010?R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010DR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010LR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00104R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010PR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\n\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010;R\u0014\u0010$\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010LR\u0014\u0010%\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010LR\u0014\u0010&\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010LR\u0014\u0010'\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010LR\u0014\u0010(\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010LR\u0014\u0010)\u001a\u00020\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010LR!\u0010R\u001a\b\u0012\u0004\u0012\u00020#0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bS\u0010;R!\u0010V\u001a\b\u0012\u0004\u0012\u00020#0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010U\u001a\u0004\bW\u0010;R!\u0010Y\u001a\b\u0012\u0004\u0012\u00020#0\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010U\u001a\u0004\bZ\u0010;R\u0016\u0010.\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u00104R\u0016\u0010/\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u00104\u00a8\u0006\u008d\u0001"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "id", "", "title", "type", "Ldev/brahmkshatriya/echo/common/models/Track$Type;", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "artists", "", "Ldev/brahmkshatriya/echo/common/models/Artist;", "album", "Ldev/brahmkshatriya/echo/common/models/Album;", "duration", "", "playedDuration", "plays", "releaseDate", "Ldev/brahmkshatriya/echo/common/models/Date;", "description", "background", "genres", "isrc", "albumOrderNumber", "albumDiscNumber", "playlistAddedDate", "isExplicit", "", "subtitle", "extras", "", "isPlayable", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "streamables", "Ldev/brahmkshatriya/echo/common/models/Streamable;", "isRadioSupported", "isFollowable", "isSaveable", "isLikeable", "isHideable", "isShareable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ldev/brahmkshatriya/echo/common/models/Album;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;ZLjava/lang/String;Ljava/util/Map;Ldev/brahmkshatriya/echo/common/models/Track$Playable;Ljava/util/List;ZZZZZZ)V", "seen0", "", "subtitleWithOutE", "subtitleWithE", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ldev/brahmkshatriya/echo/common/models/Album;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;ZLjava/lang/String;Ljava/util/Map;Ldev/brahmkshatriya/echo/common/models/Track$Playable;Ljava/util/List;ZZZZZZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getType", "()Ldev/brahmkshatriya/echo/common/models/Track$Type;", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getArtists", "()Ljava/util/List;", "getAlbum", "()Ldev/brahmkshatriya/echo/common/models/Album;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlayedDuration", "getPlays", "getReleaseDate", "()Ldev/brahmkshatriya/echo/common/models/Date;", "getDescription", "getBackground", "getGenres", "getIsrc", "getAlbumOrderNumber", "getAlbumDiscNumber", "getPlaylistAddedDate", "()Z", "getSubtitle", "getExtras", "()Ljava/util/Map;", "()Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "getStreamables", "subtitles", "getSubtitles", "subtitles$delegate", "Lkotlin/Lazy;", "servers", "getServers", "servers$delegate", "backgrounds", "getBackgrounds", "backgrounds$delegate", "getSubtitleWithOutE", "getSubtitleWithE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Track$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ldev/brahmkshatriya/echo/common/models/Album;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;ZLjava/lang/String;Ljava/util/Map;Ldev/brahmkshatriya/echo/common/models/Track$Playable;Ljava/util/List;ZZZZZZ)Ldev/brahmkshatriya/echo/common/models/Track;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Type", "Playable", "Companion", "$serializer", "common"})
@SourceDebugExtension(value={"SMAP\nTrack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Track.kt\ndev/brahmkshatriya/echo/common/models/Track\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n1#2:152\n774#3:153\n865#3,2:154\n774#3:156\n865#3,2:157\n774#3:159\n865#3,2:160\n865#3,2:162\n774#3:164\n865#3,2:165\n774#3:167\n865#3,2:168\n*S KotlinDebug\n*F\n+ 1 Track.kt\ndev/brahmkshatriya/echo/common/models/Track\n*L\n105#1:153\n105#1:154,2\n114#1:156\n114#1:157,2\n123#1:159\n123#1:160,2\n105#1:162,2\n114#1:164\n114#1:165,2\n123#1:167\n123#1:168,2\n*E\n"})
public final class Track
implements EchoMediaItem {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final Type type;
    @Nullable
    private final ImageHolder cover;
    @NotNull
    private final List<Artist> artists;
    @Nullable
    private final Album album;
    @Nullable
    private final Long duration;
    @Nullable
    private final Long playedDuration;
    @Nullable
    private final Long plays;
    @Nullable
    private final Date releaseDate;
    @Nullable
    private final String description;
    @Nullable
    private final ImageHolder background;
    @NotNull
    private final List<String> genres;
    @Nullable
    private final String isrc;
    @Nullable
    private final Long albumOrderNumber;
    @Nullable
    private final Long albumDiscNumber;
    @Nullable
    private final Date playlistAddedDate;
    private final boolean isExplicit;
    @Nullable
    private final String subtitle;
    @NotNull
    private final Map<String, String> extras;
    @NotNull
    private final Playable isPlayable;
    @NotNull
    private final List<Streamable> streamables;
    private final boolean isRadioSupported;
    private final boolean isFollowable;
    private final boolean isSaveable;
    private final boolean isLikeable;
    private final boolean isHideable;
    private final boolean isShareable;
    @NotNull
    private final Lazy subtitles$delegate;
    @NotNull
    private final Lazy servers$delegate;
    @NotNull
    private final Lazy backgrounds$delegate;
    @Nullable
    private final String subtitleWithOutE;
    @Nullable
    private final String subtitleWithE;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    /*
     * WARNING - void declaration
     */
    public Track(@NotNull String id2, @NotNull String title, @NotNull Type type, @Nullable ImageHolder cover, @NotNull List<Artist> artists, @Nullable Album album, @Nullable Long duration, @Nullable Long playedDuration, @Nullable Long plays, @Nullable Date releaseDate, @Nullable String description, @Nullable ImageHolder background2, @NotNull List<String> genres, @Nullable String isrc, @Nullable Long albumOrderNumber, @Nullable Long albumDiscNumber, @Nullable Date playlistAddedDate, boolean isExplicit, @Nullable String subtitle2, @NotNull Map<String, String> extras, @NotNull Playable isPlayable, @NotNull List<Streamable> streamables, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        CharSequence charSequence;
        String string2;
        void $this$subtitleWithE_u24lambda_u249;
        CharSequence charSequence2;
        Track track2;
        CharSequence charSequence3;
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(genres, (String)"genres");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        Intrinsics.checkNotNullParameter((Object)isPlayable, (String)"isPlayable");
        Intrinsics.checkNotNullParameter(streamables, (String)"streamables");
        this.id = id2;
        this.title = title;
        this.type = type;
        this.cover = cover;
        this.artists = artists;
        this.album = album;
        this.duration = duration;
        this.playedDuration = playedDuration;
        this.plays = plays;
        this.releaseDate = releaseDate;
        this.description = description;
        this.background = background2;
        this.genres = genres;
        this.isrc = isrc;
        this.albumOrderNumber = albumOrderNumber;
        this.albumDiscNumber = albumDiscNumber;
        this.playlistAddedDate = playlistAddedDate;
        this.isExplicit = isExplicit;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.isPlayable = isPlayable;
        this.streamables = streamables;
        this.isRadioSupported = isRadioSupported;
        this.isFollowable = isFollowable;
        this.isSaveable = isSaveable2;
        this.isLikeable = isLikeable;
        this.isHideable = isHideable;
        this.isShareable = isShareable;
        this.subtitles$delegate = LazyKt.lazy(() -> Track.subtitles_delegate$lambda$1(this));
        this.servers$delegate = LazyKt.lazy(() -> Track.servers_delegate$lambda$3(this));
        this.backgrounds$delegate = LazyKt.lazy(() -> Track.backgrounds_delegate$lambda$5(this));
        Track track3 = this;
        String string3 = this.getSubtitle();
        if (string3 == null) {
            CharSequence charSequence4;
            String artists2;
            void $this$subtitleWithOutE_u24lambda_u247;
            StringBuilder stringBuilder = charSequence3 = new StringBuilder();
            track2 = track3;
            boolean bl = false;
            if (this.duration != null) {
                $this$subtitleWithOutE_u24lambda_u247.append(Companion.toDurationString(this.duration));
            }
            if (!StringsKt.isBlank((CharSequence)(artists2 = CollectionsKt.joinToString$default((Iterable)this.artists, (CharSequence)", ", null, null, (int)0, null, Track::subtitleWithOutE$lambda$7$lambda$6, (int)30, null)))) {
                if (this.duration != null) {
                    $this$subtitleWithOutE_u24lambda_u247.append(" \u2022 ");
                }
                $this$subtitleWithOutE_u24lambda_u247.append(artists2);
            }
            track3 = track2;
            charSequence3 = ((Object)StringsKt.trim((CharSequence)charSequence3.toString())).toString();
            if (StringsKt.isBlank((CharSequence)charSequence3)) {
                track2 = track3;
                boolean bl2 = false;
                charSequence4 = null;
                track3 = track2;
            } else {
                charSequence4 = charSequence3;
            }
            string3 = (String)charSequence4;
        }
        track3.subtitleWithOutE = string3;
        charSequence3 = charSequence2 = new StringBuilder();
        track2 = this;
        boolean bl = false;
        if (this.isExplicit()) {
            $this$subtitleWithE_u24lambda_u249.append("\ud83c\udd74 ");
        }
        if ((string2 = this.getSubtitleWithOutE()) == null) {
            string2 = "";
        }
        $this$subtitleWithE_u24lambda_u249.append(string2);
        Track track4 = track2;
        charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
        if (StringsKt.isBlank((CharSequence)charSequence2)) {
            track2 = track4;
            boolean bl3 = false;
            charSequence = null;
            track4 = track2;
        } else {
            charSequence = charSequence2;
        }
        track4.subtitleWithE = (String)charSequence;
    }

    public /* synthetic */ Track(String string2, String string3, Type type, ImageHolder imageHolder, List list2, Album album, Long l, Long l2, Long l3, Date date, String string4, ImageHolder imageHolder2, List list3, String string5, Long l4, Long l5, Date date2, boolean bl, String string6, Map map2, Playable playable, List list4, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            type = Type.Song;
        }
        if ((n & 8) != 0) {
            imageHolder = null;
        }
        if ((n & 0x10) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x20) != 0) {
            album = null;
        }
        if ((n & 0x40) != 0) {
            l = null;
        }
        if ((n & 0x80) != 0) {
            l2 = null;
        }
        if ((n & 0x100) != 0) {
            l3 = null;
        }
        if ((n & 0x200) != 0) {
            date = null;
        }
        if ((n & 0x400) != 0) {
            string4 = null;
        }
        if ((n & 0x800) != 0) {
            imageHolder2 = imageHolder;
        }
        if ((n & 0x1000) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        if ((n & 0x2000) != 0) {
            string5 = null;
        }
        if ((n & 0x4000) != 0) {
            l4 = null;
        }
        if ((n & 0x8000) != 0) {
            l5 = null;
        }
        if ((n & 0x10000) != 0) {
            date2 = null;
        }
        if ((n & 0x20000) != 0) {
            bl = false;
        }
        if ((n & 0x40000) != 0) {
            string6 = null;
        }
        if ((n & 0x80000) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x100000) != 0) {
            playable = Playable.Yes.INSTANCE;
        }
        if ((n & 0x200000) != 0) {
            list4 = CollectionsKt.emptyList();
        }
        if ((n & 0x400000) != 0) {
            bl2 = true;
        }
        if ((n & 0x800000) != 0) {
            bl3 = false;
        }
        if ((n & 0x1000000) != 0) {
            bl4 = true;
        }
        if ((n & 0x2000000) != 0) {
            bl5 = true;
        }
        if ((n & 0x4000000) != 0) {
            bl6 = true;
        }
        if ((n & 0x8000000) != 0) {
            bl7 = true;
        }
        this(string2, string3, type, imageHolder, list2, album, l, l2, l3, date, string4, imageHolder2, list3, string5, l4, l5, date2, bl, string6, map2, playable, list4, bl2, bl3, bl4, bl5, bl6, bl7);
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

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @Override
    @Nullable
    public ImageHolder getCover() {
        return this.cover;
    }

    @NotNull
    public final List<Artist> getArtists() {
        return this.artists;
    }

    @Nullable
    public final Album getAlbum() {
        return this.album;
    }

    @Nullable
    public final Long getDuration() {
        return this.duration;
    }

    @Nullable
    public final Long getPlayedDuration() {
        return this.playedDuration;
    }

    @Nullable
    public final Long getPlays() {
        return this.plays;
    }

    @Nullable
    public final Date getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    @Nullable
    public String getDescription() {
        return this.description;
    }

    @Override
    @Nullable
    public ImageHolder getBackground() {
        return this.background;
    }

    @NotNull
    public final List<String> getGenres() {
        return this.genres;
    }

    @Nullable
    public final String getIsrc() {
        return this.isrc;
    }

    @Nullable
    public final Long getAlbumOrderNumber() {
        return this.albumOrderNumber;
    }

    @Nullable
    public final Long getAlbumDiscNumber() {
        return this.albumDiscNumber;
    }

    @Nullable
    public final Date getPlaylistAddedDate() {
        return this.playlistAddedDate;
    }

    @Override
    public boolean isExplicit() {
        return this.isExplicit;
    }

    @Override
    @Nullable
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override
    @NotNull
    public Map<String, String> getExtras() {
        return this.extras;
    }

    @NotNull
    public final Playable isPlayable() {
        return this.isPlayable;
    }

    @NotNull
    public final List<Streamable> getStreamables() {
        return this.streamables;
    }

    @Override
    public boolean isRadioSupported() {
        return this.isRadioSupported;
    }

    @Override
    public boolean isFollowable() {
        return this.isFollowable;
    }

    @Override
    public boolean isSaveable() {
        return this.isSaveable;
    }

    @Override
    public boolean isLikeable() {
        return this.isLikeable;
    }

    @Override
    public boolean isHideable() {
        return this.isHideable;
    }

    @Override
    public boolean isShareable() {
        return this.isShareable;
    }

    @NotNull
    public final List<Streamable> getSubtitles() {
        Lazy lazy = this.subtitles$delegate;
        return (List)lazy.getValue();
    }

    @NotNull
    public final List<Streamable> getServers() {
        Lazy lazy = this.servers$delegate;
        return (List)lazy.getValue();
    }

    @NotNull
    public final List<Streamable> getBackgrounds() {
        Lazy lazy = this.backgrounds$delegate;
        return (List)lazy.getValue();
    }

    @Override
    @Nullable
    public String getSubtitleWithOutE() {
        return this.subtitleWithOutE;
    }

    @Override
    @Nullable
    public String getSubtitleWithE() {
        return this.subtitleWithE;
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
    public final Type component3() {
        return this.type;
    }

    @Nullable
    public final ImageHolder component4() {
        return this.cover;
    }

    @NotNull
    public final List<Artist> component5() {
        return this.artists;
    }

    @Nullable
    public final Album component6() {
        return this.album;
    }

    @Nullable
    public final Long component7() {
        return this.duration;
    }

    @Nullable
    public final Long component8() {
        return this.playedDuration;
    }

    @Nullable
    public final Long component9() {
        return this.plays;
    }

    @Nullable
    public final Date component10() {
        return this.releaseDate;
    }

    @Nullable
    public final String component11() {
        return this.description;
    }

    @Nullable
    public final ImageHolder component12() {
        return this.background;
    }

    @NotNull
    public final List<String> component13() {
        return this.genres;
    }

    @Nullable
    public final String component14() {
        return this.isrc;
    }

    @Nullable
    public final Long component15() {
        return this.albumOrderNumber;
    }

    @Nullable
    public final Long component16() {
        return this.albumDiscNumber;
    }

    @Nullable
    public final Date component17() {
        return this.playlistAddedDate;
    }

    public final boolean component18() {
        return this.isExplicit;
    }

    @Nullable
    public final String component19() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> component20() {
        return this.extras;
    }

    @NotNull
    public final Playable component21() {
        return this.isPlayable;
    }

    @NotNull
    public final List<Streamable> component22() {
        return this.streamables;
    }

    public final boolean component23() {
        return this.isRadioSupported;
    }

    public final boolean component24() {
        return this.isFollowable;
    }

    public final boolean component25() {
        return this.isSaveable;
    }

    public final boolean component26() {
        return this.isLikeable;
    }

    public final boolean component27() {
        return this.isHideable;
    }

    public final boolean component28() {
        return this.isShareable;
    }

    @NotNull
    public final Track copy(@NotNull String id2, @NotNull String title, @NotNull Type type, @Nullable ImageHolder cover, @NotNull List<Artist> artists, @Nullable Album album, @Nullable Long duration, @Nullable Long playedDuration, @Nullable Long plays, @Nullable Date releaseDate, @Nullable String description, @Nullable ImageHolder background2, @NotNull List<String> genres, @Nullable String isrc, @Nullable Long albumOrderNumber, @Nullable Long albumDiscNumber, @Nullable Date playlistAddedDate, boolean isExplicit, @Nullable String subtitle2, @NotNull Map<String, String> extras, @NotNull Playable isPlayable, @NotNull List<Streamable> streamables, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(genres, (String)"genres");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        Intrinsics.checkNotNullParameter((Object)isPlayable, (String)"isPlayable");
        Intrinsics.checkNotNullParameter(streamables, (String)"streamables");
        return new Track(id2, title, type, cover, artists, album, duration, playedDuration, plays, releaseDate, description, background2, genres, isrc, albumOrderNumber, albumDiscNumber, playlistAddedDate, isExplicit, subtitle2, extras, isPlayable, streamables, isRadioSupported, isFollowable, isSaveable2, isLikeable, isHideable, isShareable);
    }

    public static /* synthetic */ Track copy$default(Track track2, String string2, String string3, Type type, ImageHolder imageHolder, List list2, Album album, Long l, Long l2, Long l3, Date date, String string4, ImageHolder imageHolder2, List list3, String string5, Long l4, Long l5, Date date2, boolean bl, String string6, Map map2, Playable playable, List list4, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = track2.id;
        }
        if ((n & 2) != 0) {
            string3 = track2.title;
        }
        if ((n & 4) != 0) {
            type = track2.type;
        }
        if ((n & 8) != 0) {
            imageHolder = track2.cover;
        }
        if ((n & 0x10) != 0) {
            list2 = track2.artists;
        }
        if ((n & 0x20) != 0) {
            album = track2.album;
        }
        if ((n & 0x40) != 0) {
            l = track2.duration;
        }
        if ((n & 0x80) != 0) {
            l2 = track2.playedDuration;
        }
        if ((n & 0x100) != 0) {
            l3 = track2.plays;
        }
        if ((n & 0x200) != 0) {
            date = track2.releaseDate;
        }
        if ((n & 0x400) != 0) {
            string4 = track2.description;
        }
        if ((n & 0x800) != 0) {
            imageHolder2 = track2.background;
        }
        if ((n & 0x1000) != 0) {
            list3 = track2.genres;
        }
        if ((n & 0x2000) != 0) {
            string5 = track2.isrc;
        }
        if ((n & 0x4000) != 0) {
            l4 = track2.albumOrderNumber;
        }
        if ((n & 0x8000) != 0) {
            l5 = track2.albumDiscNumber;
        }
        if ((n & 0x10000) != 0) {
            date2 = track2.playlistAddedDate;
        }
        if ((n & 0x20000) != 0) {
            bl = track2.isExplicit;
        }
        if ((n & 0x40000) != 0) {
            string6 = track2.subtitle;
        }
        if ((n & 0x80000) != 0) {
            map2 = track2.extras;
        }
        if ((n & 0x100000) != 0) {
            playable = track2.isPlayable;
        }
        if ((n & 0x200000) != 0) {
            list4 = track2.streamables;
        }
        if ((n & 0x400000) != 0) {
            bl2 = track2.isRadioSupported;
        }
        if ((n & 0x800000) != 0) {
            bl3 = track2.isFollowable;
        }
        if ((n & 0x1000000) != 0) {
            bl4 = track2.isSaveable;
        }
        if ((n & 0x2000000) != 0) {
            bl5 = track2.isLikeable;
        }
        if ((n & 0x4000000) != 0) {
            bl6 = track2.isHideable;
        }
        if ((n & 0x8000000) != 0) {
            bl7 = track2.isShareable;
        }
        return track2.copy(string2, string3, type, imageHolder, list2, album, l, l2, l3, date, string4, imageHolder2, list3, string5, l4, l5, date2, bl, string6, map2, playable, list4, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    @NotNull
    public String toString() {
        return "Track(id=" + this.id + ", title=" + this.title + ", type=" + this.type + ", cover=" + this.cover + ", artists=" + this.artists + ", album=" + this.album + ", duration=" + this.duration + ", playedDuration=" + this.playedDuration + ", plays=" + this.plays + ", releaseDate=" + this.releaseDate + ", description=" + this.description + ", background=" + this.background + ", genres=" + this.genres + ", isrc=" + this.isrc + ", albumOrderNumber=" + this.albumOrderNumber + ", albumDiscNumber=" + this.albumDiscNumber + ", playlistAddedDate=" + this.playlistAddedDate + ", isExplicit=" + this.isExplicit + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", isPlayable=" + this.isPlayable + ", streamables=" + this.streamables + ", isRadioSupported=" + this.isRadioSupported + ", isFollowable=" + this.isFollowable + ", isSaveable=" + this.isSaveable + ", isLikeable=" + this.isLikeable + ", isHideable=" + this.isHideable + ", isShareable=" + this.isShareable + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + this.type.hashCode();
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + ((Object)this.artists).hashCode();
        result2 = result2 * 31 + (this.album == null ? 0 : this.album.hashCode());
        result2 = result2 * 31 + (this.duration == null ? 0 : ((Object)this.duration).hashCode());
        result2 = result2 * 31 + (this.playedDuration == null ? 0 : ((Object)this.playedDuration).hashCode());
        result2 = result2 * 31 + (this.plays == null ? 0 : ((Object)this.plays).hashCode());
        result2 = result2 * 31 + (this.releaseDate == null ? 0 : this.releaseDate.hashCode());
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        result2 = result2 * 31 + (this.background == null ? 0 : this.background.hashCode());
        result2 = result2 * 31 + ((Object)this.genres).hashCode();
        result2 = result2 * 31 + (this.isrc == null ? 0 : this.isrc.hashCode());
        result2 = result2 * 31 + (this.albumOrderNumber == null ? 0 : ((Object)this.albumOrderNumber).hashCode());
        result2 = result2 * 31 + (this.albumDiscNumber == null ? 0 : ((Object)this.albumDiscNumber).hashCode());
        result2 = result2 * 31 + (this.playlistAddedDate == null ? 0 : this.playlistAddedDate.hashCode());
        result2 = result2 * 31 + Boolean.hashCode(this.isExplicit);
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
        result2 = result2 * 31 + this.isPlayable.hashCode();
        result2 = result2 * 31 + ((Object)this.streamables).hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.isRadioSupported);
        result2 = result2 * 31 + Boolean.hashCode(this.isFollowable);
        result2 = result2 * 31 + Boolean.hashCode(this.isSaveable);
        result2 = result2 * 31 + Boolean.hashCode(this.isLikeable);
        result2 = result2 * 31 + Boolean.hashCode(this.isHideable);
        result2 = result2 * 31 + Boolean.hashCode(this.isShareable);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Track)) {
            return false;
        }
        Track track2 = (Track)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)track2.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)track2.title)) {
            return false;
        }
        if (this.type != track2.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)track2.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.artists, track2.artists)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.album, (Object)track2.album)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.duration, (Object)track2.duration)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.playedDuration, (Object)track2.playedDuration)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.plays, (Object)track2.plays)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.releaseDate, (Object)track2.releaseDate)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)track2.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.background, (Object)track2.background)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.genres, track2.genres)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.isrc, (Object)track2.isrc)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.albumOrderNumber, (Object)track2.albumOrderNumber)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.albumDiscNumber, (Object)track2.albumDiscNumber)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.playlistAddedDate, (Object)track2.playlistAddedDate)) {
            return false;
        }
        if (this.isExplicit != track2.isExplicit) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)track2.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, track2.extras)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.isPlayable, (Object)track2.isPlayable)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.streamables, track2.streamables)) {
            return false;
        }
        if (this.isRadioSupported != track2.isRadioSupported) {
            return false;
        }
        if (this.isFollowable != track2.isFollowable) {
            return false;
        }
        if (this.isSaveable != track2.isSaveable) {
            return false;
        }
        if (this.isLikeable != track2.isLikeable) {
            return false;
        }
        if (this.isHideable != track2.isHideable) {
            return false;
        }
        return this.isShareable == track2.isShareable;
    }

    @Override
    public boolean isPrivate() {
        return EchoMediaItem.super.isPrivate();
    }

    @Override
    public boolean sameAs(@NotNull EchoMediaItem other) {
        return EchoMediaItem.super.sameAs(other);
    }

    @Override
    @NotNull
    public Shelf.Item toShelf() {
        return EchoMediaItem.super.toShelf();
    }

    @Override
    @NotNull
    public EchoMediaItem copyMediaItem(@NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2) {
        return EchoMediaItem.super.copyMediaItem(id2, title, cover, description, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Track self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        String string2;
        CharSequence charSequence;
        boolean bl2;
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getTitle());
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.type != Type.Song) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getCover() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.getCover());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.artists, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.artists);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.album != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)Album$.serializer.INSTANCE, (Object)self.album);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.duration != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.duration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.playedDuration != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.playedDuration);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.plays != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.plays);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.releaseDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.releaseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : !Intrinsics.areEqual((Object)self.getBackground(), (Object)self.getCover())) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy)lazyArray[11].getValue(), (Object)self.getBackground());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : !Intrinsics.areEqual(self.genres, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 12, (SerializationStrategy)lazyArray[12].getValue(), self.genres);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : self.isrc != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.isrc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : self.albumOrderNumber != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.albumOrderNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : self.albumDiscNumber != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.albumDiscNumber);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) ? true : self.playlistAddedDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.playlistAddedDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) ? true : self.isExplicit()) {
            output.encodeBooleanElement(serialDesc, 17, self.isExplicit());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) ? true : self.getSubtitle() != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 19, (SerializationStrategy)lazyArray[19].getValue(), self.getExtras());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) ? true : !Intrinsics.areEqual((Object)self.isPlayable, (Object)Playable.Yes.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 20, (SerializationStrategy)lazyArray[20].getValue(), (Object)self.isPlayable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21) ? true : !Intrinsics.areEqual(self.streamables, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 21, (SerializationStrategy)lazyArray[21].getValue(), self.streamables);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 22) ? true : !self.isRadioSupported()) {
            output.encodeBooleanElement(serialDesc, 22, self.isRadioSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 23) ? true : self.isFollowable()) {
            output.encodeBooleanElement(serialDesc, 23, self.isFollowable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 24) ? true : !self.isSaveable()) {
            output.encodeBooleanElement(serialDesc, 24, self.isSaveable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 25) ? true : !self.isLikeable()) {
            output.encodeBooleanElement(serialDesc, 25, self.isLikeable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 26) ? true : !self.isHideable()) {
            output.encodeBooleanElement(serialDesc, 26, self.isHideable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 27) ? true : !self.isShareable()) {
            output.encodeBooleanElement(serialDesc, 27, self.isShareable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 28)) {
            bl2 = true;
        } else {
            String string3 = self.getSubtitleWithOutE();
            String string4 = self.getSubtitle();
            if (string4 == null) {
                CharSequence charSequence2;
                String artists;
                void $this$write_Self_u24lambda_u2412;
                StringBuilder stringBuilder = charSequence = new StringBuilder();
                string2 = string3;
                boolean bl3 = false;
                if (self.duration != null) {
                    $this$write_Self_u24lambda_u2412.append(Companion.toDurationString(self.duration));
                }
                if (!StringsKt.isBlank((CharSequence)(artists = CollectionsKt.joinToString$default((Iterable)self.artists, (CharSequence)", ", null, null, (int)0, null, Track::write_Self$lambda$12$lambda$11, (int)30, null)))) {
                    if (self.duration != null) {
                        $this$write_Self_u24lambda_u2412.append(" \u2022 ");
                    }
                    $this$write_Self_u24lambda_u2412.append(artists);
                }
                string3 = string2;
                charSequence = ((Object)StringsKt.trim((CharSequence)charSequence.toString())).toString();
                if (StringsKt.isBlank((CharSequence)charSequence)) {
                    string2 = string3;
                    boolean bl4 = false;
                    charSequence2 = null;
                    string3 = string2;
                } else {
                    charSequence2 = charSequence;
                }
                string4 = (String)charSequence2;
            }
            bl2 = !Intrinsics.areEqual((Object)string3, (Object)string4);
        }
        if (bl2) {
            output.encodeNullableSerializableElement(serialDesc, 28, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitleWithOutE());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 29)) {
            bl = true;
        } else {
            CharSequence charSequence3;
            String string5;
            void $this$write_Self_u24lambda_u2414;
            CharSequence charSequence4;
            charSequence = charSequence4 = new StringBuilder();
            string2 = self.getSubtitleWithE();
            boolean bl5 = false;
            if (self.isExplicit()) {
                $this$write_Self_u24lambda_u2414.append("\ud83c\udd74 ");
            }
            if ((string5 = self.getSubtitleWithOutE()) == null) {
                string5 = "";
            }
            $this$write_Self_u24lambda_u2414.append(string5);
            String string6 = string2;
            charSequence4 = ((Object)StringsKt.trim((CharSequence)charSequence4.toString())).toString();
            if (StringsKt.isBlank((CharSequence)charSequence4)) {
                string2 = string6;
                boolean bl6 = false;
                charSequence3 = null;
                string6 = string2;
            } else {
                charSequence3 = charSequence4;
            }
            bl = !Intrinsics.areEqual((Object)string6, (Object)charSequence3);
        }
        if (bl) {
            output.encodeNullableSerializableElement(serialDesc, 29, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitleWithE());
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ Track(int seen0, String id2, String title, Type type, ImageHolder cover, List artists, Album album, Long duration, Long playedDuration, Long plays, Date releaseDate, String description, ImageHolder background2, List genres, String isrc, Long albumOrderNumber, Long albumDiscNumber, Date playlistAddedDate, boolean isExplicit, String subtitle2, Map extras, Playable isPlayable, List streamables, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable, String subtitleWithOutE, String subtitleWithE, SerializationConstructorMarker serializationConstructorMarker) {
        Track track2;
        CharSequence charSequence;
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.type = (seen0 & 4) == 0 ? Type.Song : type;
        this.cover = (seen0 & 8) == 0 ? null : cover;
        this.artists = (seen0 & 0x10) == 0 ? CollectionsKt.emptyList() : artists;
        this.album = (seen0 & 0x20) == 0 ? null : album;
        this.duration = (seen0 & 0x40) == 0 ? null : duration;
        this.playedDuration = (seen0 & 0x80) == 0 ? null : playedDuration;
        this.plays = (seen0 & 0x100) == 0 ? null : plays;
        this.releaseDate = (seen0 & 0x200) == 0 ? null : releaseDate;
        this.description = (seen0 & 0x400) == 0 ? null : description;
        this.background = (seen0 & 0x800) == 0 ? this.getCover() : background2;
        this.genres = (seen0 & 0x1000) == 0 ? CollectionsKt.emptyList() : genres;
        this.isrc = (seen0 & 0x2000) == 0 ? null : isrc;
        this.albumOrderNumber = (seen0 & 0x4000) == 0 ? null : albumOrderNumber;
        this.albumDiscNumber = (seen0 & 0x8000) == 0 ? null : albumDiscNumber;
        this.playlistAddedDate = (seen0 & 0x10000) == 0 ? null : playlistAddedDate;
        this.isExplicit = (seen0 & 0x20000) == 0 ? false : isExplicit;
        this.subtitle = (seen0 & 0x40000) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x80000) == 0 ? MapsKt.emptyMap() : extras;
        this.isPlayable = (seen0 & 0x100000) == 0 ? (Playable)Playable.Yes.INSTANCE : isPlayable;
        this.streamables = (seen0 & 0x200000) == 0 ? CollectionsKt.emptyList() : streamables;
        this.isRadioSupported = (seen0 & 0x400000) == 0 ? true : isRadioSupported;
        this.isFollowable = (seen0 & 0x800000) == 0 ? false : isFollowable;
        this.isSaveable = (seen0 & 0x1000000) == 0 ? true : isSaveable2;
        this.isLikeable = (seen0 & 0x2000000) == 0 ? true : isLikeable;
        this.isHideable = (seen0 & 0x4000000) == 0 ? true : isHideable;
        this.isShareable = (seen0 & 0x8000000) == 0 ? true : isShareable;
        this.subtitles$delegate = LazyKt.lazy(() -> Track._init_$lambda$17(this));
        this.servers$delegate = LazyKt.lazy(() -> Track._init_$lambda$19(this));
        this.backgrounds$delegate = LazyKt.lazy(() -> Track._init_$lambda$21(this));
        if ((seen0 & 0x10000000) == 0) {
            Track track3 = this;
            String string2 = this.getSubtitle();
            if (string2 == null) {
                CharSequence charSequence2;
                String artists2;
                void $this$_init__u24lambda_u2423;
                StringBuilder stringBuilder = charSequence = new StringBuilder();
                track2 = track3;
                boolean bl = false;
                if (this.duration != null) {
                    $this$_init__u24lambda_u2423.append(Companion.toDurationString(this.duration));
                }
                if (!StringsKt.isBlank((CharSequence)(artists2 = CollectionsKt.joinToString$default((Iterable)this.artists, (CharSequence)", ", null, null, (int)0, null, Track::_init_$lambda$23$lambda$22, (int)30, null)))) {
                    if (this.duration != null) {
                        $this$_init__u24lambda_u2423.append(" \u2022 ");
                    }
                    $this$_init__u24lambda_u2423.append(artists2);
                }
                track3 = track2;
                charSequence = ((Object)StringsKt.trim((CharSequence)charSequence.toString())).toString();
                if (StringsKt.isBlank((CharSequence)charSequence)) {
                    track2 = track3;
                    boolean bl2 = false;
                    charSequence2 = null;
                    track3 = track2;
                } else {
                    charSequence2 = charSequence;
                }
                string2 = (String)charSequence2;
            }
            track3.subtitleWithOutE = string2;
        } else {
            this.subtitleWithOutE = subtitleWithOutE;
        }
        if ((seen0 & 0x20000000) == 0) {
            CharSequence charSequence3;
            String string3;
            void $this$_init__u24lambda_u2425;
            CharSequence charSequence4;
            charSequence = charSequence4 = new StringBuilder();
            track2 = this;
            boolean bl = false;
            if (this.isExplicit()) {
                $this$_init__u24lambda_u2425.append("\ud83c\udd74 ");
            }
            if ((string3 = this.getSubtitleWithOutE()) == null) {
                string3 = "";
            }
            $this$_init__u24lambda_u2425.append(string3);
            Track track4 = track2;
            charSequence4 = ((Object)StringsKt.trim((CharSequence)charSequence4.toString())).toString();
            if (StringsKt.isBlank((CharSequence)charSequence4)) {
                track2 = track4;
                boolean bl3 = false;
                charSequence3 = null;
                track4 = track2;
            } else {
                charSequence3 = charSequence4;
            }
            track4.subtitleWithE = (String)charSequence3;
        } else {
            this.subtitleWithE = subtitleWithE;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final List subtitles_delegate$lambda$1(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Subtitle)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final List servers_delegate$lambda$3(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Server)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final List backgrounds_delegate$lambda$5(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Background)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final CharSequence subtitleWithOutE$lambda$7$lambda$6(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final CharSequence write_Self$lambda$12$lambda$11(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$17(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Subtitle)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$19(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Server)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$21(Track this$0) {
        void $this$filterTo$iv$iv;
        Iterable $this$filter$iv = this$0.streamables;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            Streamable it = (Streamable)element$iv$iv;
            boolean bl = false;
            if (!(it.getType() == Streamable.MediaType.Background)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    private static final CharSequence _init_$lambda$23$lambda$22(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Track.Type", (Enum[])Type.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> Playable.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Streamable$.serializer.INSTANCE)), null, null, null, null, null, null, null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Companion;", "", "<init>", "()V", "toDurationString", "", "", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Track;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String toDurationString(long $this$toDurationString) {
            Object[] objectArray;
            String string2;
            Locale locale;
            StringBuilder stringBuilder;
            long seconds = $this$toDurationString / (long)1000;
            long minutes = seconds / (long)60;
            long hours = minutes / (long)60;
            StringBuilder $this$toDurationString_u24lambda_u240 = stringBuilder = new StringBuilder();
            boolean bl = false;
            if (hours > 0L) {
                locale = Locale.getDefault();
                string2 = "%02d:";
                objectArray = new Object[]{hours};
                String string3 = String.format(locale, string2, Arrays.copyOf(objectArray, objectArray.length));
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
                $this$toDurationString_u24lambda_u240.append(string3);
            }
            locale = Locale.getDefault();
            string2 = "%02d:%02d";
            objectArray = new Object[]{minutes % (long)60, seconds % (long)60};
            String string4 = String.format(locale, string2, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"format(...)");
            $this$toDurationString_u24lambda_u240.append(string4);
            return ((Object)StringsKt.trim((CharSequence)stringBuilder.toString())).toString();
        }

        @NotNull
        public final KSerializer<Track> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00062\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "", "Yes", "RegionLocked", "Unreleased", "No", "Companion", "Ldev/brahmkshatriya/echo/common/models/Track$Playable$No;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable$RegionLocked;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable$Unreleased;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable$Yes;", "common"})
    public static sealed interface Playable {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "common"})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;

            private Companion() {
            }

            @NotNull
            public final KSerializer<Playable> serializer() {
                KClass[] kClassArray = new KClass[]{Reflection.getOrCreateKotlinClass(No.class), Reflection.getOrCreateKotlinClass(RegionLocked.class), Reflection.getOrCreateKotlinClass(Unreleased.class), Reflection.getOrCreateKotlinClass(Yes.class)};
                KClass[] kClassArray2 = kClassArray;
                kClassArray = new KSerializer[]{Playable$No$$serializer.INSTANCE, new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.RegionLocked", (Object)RegionLocked.INSTANCE, new Annotation[0]), new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.Unreleased", (Object)Unreleased.INSTANCE, new Annotation[0]), new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.Yes", (Object)Yes.INSTANCE, new Annotation[0])};
                return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable", Reflection.getOrCreateKotlinClass(Playable.class), kClassArray2, (KSerializer[])kClassArray, new Annotation[0]);
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001\u00a2\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001f"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$No;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "reason", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
        public static final class No
        implements Playable {
            @NotNull
            public static final Companion Companion = new Companion(null);
            @NotNull
            private final String reason;

            public No(@NotNull String reason) {
                Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
                this.reason = reason;
            }

            @NotNull
            public final String getReason() {
                return this.reason;
            }

            @NotNull
            public final String component1() {
                return this.reason;
            }

            @NotNull
            public final No copy(@NotNull String reason) {
                Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
                return new No(reason);
            }

            public static /* synthetic */ No copy$default(No no, String string2, int n, Object object) {
                if ((n & 1) != 0) {
                    string2 = no.reason;
                }
                return no.copy(string2);
            }

            @NotNull
            public String toString() {
                return "No(reason=" + this.reason + ")";
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof No)) {
                    return false;
                }
                No no = (No)other;
                return Intrinsics.areEqual((Object)this.reason, (Object)no.reason);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$common(No self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.reason);
            }

            public /* synthetic */ No(int seen0, String reason, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (1 & seen0)) {
                    PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)Playable$No$$serializer.INSTANCE.getDescriptor());
                }
                this.reason = reason;
            }

            @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$No$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable$No;", "common"})
            public static final class Companion {
                private Companion() {
                }

                @NotNull
                public final KSerializer<No> serializer() {
                    return (KSerializer)Playable$No$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                    this();
                }
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rH\u00d6\u0001\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$RegionLocked;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "common"})
        public static final class RegionLocked
        implements Playable {
            @NotNull
            public static final RegionLocked INSTANCE = new RegionLocked();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate;

            private RegionLocked() {
            }

            @NotNull
            public final KSerializer<RegionLocked> serializer() {
                return this.get$cachedSerializer();
            }

            @NotNull
            public String toString() {
                return "RegionLocked";
            }

            public int hashCode() {
                return 653342410;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RegionLocked)) {
                    return false;
                }
                RegionLocked cfr_ignored_0 = (RegionLocked)other;
                return true;
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            static {
                $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.RegionLocked", (Object)INSTANCE, new Annotation[0]));
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rH\u00d6\u0001\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$Unreleased;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "common"})
        public static final class Unreleased
        implements Playable {
            @NotNull
            public static final Unreleased INSTANCE = new Unreleased();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate;

            private Unreleased() {
            }

            @NotNull
            public final KSerializer<Unreleased> serializer() {
                return this.get$cachedSerializer();
            }

            @NotNull
            public String toString() {
                return "Unreleased";
            }

            public int hashCode() {
                return -1480576638;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Unreleased)) {
                    return false;
                }
                Unreleased cfr_ignored_0 = (Unreleased)other;
                return true;
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            static {
                $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.Unreleased", (Object)INSTANCE, new Annotation[0]));
            }
        }

        @Serializable
        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rH\u00d6\u0001\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Playable$Yes;", "Ldev/brahmkshatriya/echo/common/models/Track$Playable;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "common"})
        public static final class Yes
        implements Playable {
            @NotNull
            public static final Yes INSTANCE = new Yes();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate;

            private Yes() {
            }

            @NotNull
            public final KSerializer<Yes> serializer() {
                return this.get$cachedSerializer();
            }

            @NotNull
            public String toString() {
                return "Yes";
            }

            public int hashCode() {
                return 923158971;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Yes)) {
                    return false;
                }
                Yes cfr_ignored_0 = (Yes)other;
                return true;
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer)$cachedSerializer$delegate.getValue();
            }

            static {
                $cachedSerializer$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ObjectSerializer("dev.brahmkshatriya.echo.common.models.Track.Playable.Yes", (Object)INSTANCE, new Annotation[0]));
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/common/models/Track$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Song", "Podcast", "VideoSong", "Video", "HorizontalVideo", "common"})
    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type Song = new Type();
        public static final /* enum */ Type Podcast = new Type();
        public static final /* enum */ Type VideoSong = new Type();
        public static final /* enum */ Type Video = new Type();
        public static final /* enum */ Type HorizontalVideo = new Type();
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
            $VALUES = typeArray = new Type[]{Type.Song, Type.Podcast, Type.VideoSong, Type.Video, Type.HorizontalVideo};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

