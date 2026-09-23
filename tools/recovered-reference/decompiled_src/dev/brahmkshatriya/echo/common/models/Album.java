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
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Album$;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.Artist$;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.Date$;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Shelf;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 e2\u00020\u0001:\u0003cdeB\u00ef\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001f\u0010 B\u00fb\u0001\b\u0010\u0012\u0006\u0010!\u001a\u00020\"\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b\u001f\u0010'J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u0010\u0010F\u001a\u0004\u0018\u00010\rH\u00c6\u0003\u00a2\u0006\u0002\u00102J\u000b\u0010G\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0015H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018H\u00c6\u0003J\t\u0010N\u001a\u00020\u0015H\u00c6\u0003J\t\u0010O\u001a\u00020\u0015H\u00c6\u0003J\t\u0010P\u001a\u00020\u0015H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0015H\u00c6\u0003J\t\u0010R\u001a\u00020\u0015H\u00c6\u0003J\t\u0010S\u001a\u00020\u0015H\u00c6\u0003J\u00fa\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u0015H\u00c6\u0001\u00a2\u0006\u0002\u0010UJ\u0013\u0010V\u001a\u00020\u00152\b\u0010W\u001a\u0004\u0018\u00010XH\u00d6\u0003J\t\u0010Y\u001a\u00020\"H\u00d6\u0001J\t\u0010Z\u001a\u00020\u0003H\u00d6\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001\u00a2\u0006\u0002\bbR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0096\u0004\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010:R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010)R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010\u0019\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010:R\u0014\u0010\u001a\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010:R\u0014\u0010\u001b\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010:R\u0014\u0010\u001c\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010:R\u0014\u0010\u001d\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010:R\u0014\u0010\u001e\u001a\u00020\u0015X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010:R\u0016\u0010#\u001a\u0004\u0018\u00010\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u00106R\u0016\u0010$\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010)\u00a8\u0006f"}, d2={"Ldev/brahmkshatriya/echo/common/models/Album;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "id", "", "title", "type", "Ldev/brahmkshatriya/echo/common/models/Album$Type;", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "artists", "", "Ldev/brahmkshatriya/echo/common/models/Artist;", "trackCount", "", "duration", "releaseDate", "Ldev/brahmkshatriya/echo/common/models/Date;", "description", "background", "label", "isExplicit", "", "subtitle", "extras", "", "isRadioSupported", "isFollowable", "isSaveable", "isLikeable", "isHideable", "isShareable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Album$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;ZZZZZZ)V", "seen0", "", "date", "subtitleWithOutE", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Album$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;ZZZZZZLdev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getType", "()Ldev/brahmkshatriya/echo/common/models/Album$Type;", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getArtists", "()Ljava/util/List;", "getTrackCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getReleaseDate", "()Ldev/brahmkshatriya/echo/common/models/Date;", "getDescription", "getBackground", "getLabel", "()Z", "getSubtitle", "getExtras", "()Ljava/util/Map;", "getDate", "getSubtitleWithOutE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Album$Type;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;ZZZZZZ)Ldev/brahmkshatriya/echo/common/models/Album;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Type", "$serializer", "Companion", "common"})
@SourceDebugExtension(value={"SMAP\nAlbum.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Album.kt\ndev/brahmkshatriya/echo/common/models/Album\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
public final class Album
implements EchoMediaItem.Lists {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @Nullable
    private final Type type;
    @Nullable
    private final ImageHolder cover;
    @NotNull
    private final List<Artist> artists;
    @Nullable
    private final Long trackCount;
    @Nullable
    private final Long duration;
    @Nullable
    private final Date releaseDate;
    @Nullable
    private final String description;
    @Nullable
    private final ImageHolder background;
    @Nullable
    private final String label;
    private final boolean isExplicit;
    @Nullable
    private final String subtitle;
    @NotNull
    private final Map<String, String> extras;
    private final boolean isRadioSupported;
    private final boolean isFollowable;
    private final boolean isSaveable;
    private final boolean isLikeable;
    private final boolean isHideable;
    private final boolean isShareable;
    @Nullable
    private final Date date;
    @Nullable
    private final String subtitleWithOutE;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    /*
     * WARNING - void declaration
     */
    public Album(@NotNull String id2, @NotNull String title, @Nullable Type type, @Nullable ImageHolder cover, @NotNull List<Artist> artists, @Nullable Long trackCount, @Nullable Long duration, @Nullable Date releaseDate, @Nullable String description, @Nullable ImageHolder background2, @Nullable String label, boolean isExplicit, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.title = title;
        this.type = type;
        this.cover = cover;
        this.artists = artists;
        this.trackCount = trackCount;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.background = background2;
        this.label = label;
        this.isExplicit = isExplicit;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.isRadioSupported = isRadioSupported;
        this.isFollowable = isFollowable;
        this.isSaveable = isSaveable2;
        this.isLikeable = isLikeable;
        this.isHideable = isHideable;
        this.isShareable = isShareable;
        this.date = this.releaseDate;
        Album album = this;
        String string2 = this.getSubtitle();
        if (string2 == null) {
            CharSequence charSequence;
            void $this$subtitleWithOutE_u24lambda_u241;
            CharSequence charSequence2;
            StringBuilder stringBuilder = charSequence2 = new StringBuilder();
            Album album2 = album;
            boolean bl = false;
            $this$subtitleWithOutE_u24lambda_u241.append(CollectionsKt.joinToString$default((Iterable)this.getArtists(), (CharSequence)", ", null, null, (int)0, null, Album::subtitleWithOutE$lambda$1$lambda$0, (int)30, null));
            album = album2;
            charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
            if (StringsKt.isBlank((CharSequence)charSequence2)) {
                album2 = album;
                boolean bl2 = false;
                charSequence = null;
                album = album2;
            } else {
                charSequence = charSequence2;
            }
            string2 = (String)charSequence;
        }
        album.subtitleWithOutE = string2;
    }

    public /* synthetic */ Album(String string2, String string3, Type type, ImageHolder imageHolder, List list2, Long l, Long l2, Date date, String string4, ImageHolder imageHolder2, String string5, boolean bl, String string6, Map map2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            type = null;
        }
        if ((n & 8) != 0) {
            imageHolder = null;
        }
        if ((n & 0x10) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x20) != 0) {
            l = null;
        }
        if ((n & 0x40) != 0) {
            l2 = null;
        }
        if ((n & 0x80) != 0) {
            date = null;
        }
        if ((n & 0x100) != 0) {
            string4 = null;
        }
        if ((n & 0x200) != 0) {
            imageHolder2 = imageHolder;
        }
        if ((n & 0x400) != 0) {
            string5 = null;
        }
        if ((n & 0x800) != 0) {
            bl = false;
        }
        if ((n & 0x1000) != 0) {
            string6 = null;
        }
        if ((n & 0x2000) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x4000) != 0) {
            bl2 = true;
        }
        if ((n & 0x8000) != 0) {
            bl3 = false;
        }
        if ((n & 0x10000) != 0) {
            bl4 = true;
        }
        if ((n & 0x20000) != 0) {
            bl5 = false;
        }
        if ((n & 0x40000) != 0) {
            bl6 = false;
        }
        if ((n & 0x80000) != 0) {
            bl7 = true;
        }
        this(string2, string3, type, imageHolder, list2, l, l2, date, string4, imageHolder2, string5, bl, string6, map2, bl2, bl3, bl4, bl5, bl6, bl7);
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
    @Nullable
    public Type getType() {
        return this.type;
    }

    @Override
    @Nullable
    public ImageHolder getCover() {
        return this.cover;
    }

    @Override
    @NotNull
    public List<Artist> getArtists() {
        return this.artists;
    }

    @Override
    @Nullable
    public Long getTrackCount() {
        return this.trackCount;
    }

    @Override
    @Nullable
    public Long getDuration() {
        return this.duration;
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

    @Override
    @Nullable
    public String getLabel() {
        return this.label;
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

    @Override
    @Nullable
    public Date getDate() {
        return this.date;
    }

    @Override
    @Nullable
    public String getSubtitleWithOutE() {
        return this.subtitleWithOutE;
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
    public final Long component6() {
        return this.trackCount;
    }

    @Nullable
    public final Long component7() {
        return this.duration;
    }

    @Nullable
    public final Date component8() {
        return this.releaseDate;
    }

    @Nullable
    public final String component9() {
        return this.description;
    }

    @Nullable
    public final ImageHolder component10() {
        return this.background;
    }

    @Nullable
    public final String component11() {
        return this.label;
    }

    public final boolean component12() {
        return this.isExplicit;
    }

    @Nullable
    public final String component13() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> component14() {
        return this.extras;
    }

    public final boolean component15() {
        return this.isRadioSupported;
    }

    public final boolean component16() {
        return this.isFollowable;
    }

    public final boolean component17() {
        return this.isSaveable;
    }

    public final boolean component18() {
        return this.isLikeable;
    }

    public final boolean component19() {
        return this.isHideable;
    }

    public final boolean component20() {
        return this.isShareable;
    }

    @NotNull
    public final Album copy(@NotNull String id2, @NotNull String title, @Nullable Type type, @Nullable ImageHolder cover, @NotNull List<Artist> artists, @Nullable Long trackCount, @Nullable Long duration, @Nullable Date releaseDate, @Nullable String description, @Nullable ImageHolder background2, @Nullable String label, boolean isExplicit, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(artists, (String)"artists");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Album(id2, title, type, cover, artists, trackCount, duration, releaseDate, description, background2, label, isExplicit, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, isLikeable, isHideable, isShareable);
    }

    public static /* synthetic */ Album copy$default(Album album, String string2, String string3, Type type, ImageHolder imageHolder, List list2, Long l, Long l2, Date date, String string4, ImageHolder imageHolder2, String string5, boolean bl, String string6, Map map2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = album.id;
        }
        if ((n & 2) != 0) {
            string3 = album.title;
        }
        if ((n & 4) != 0) {
            type = album.type;
        }
        if ((n & 8) != 0) {
            imageHolder = album.cover;
        }
        if ((n & 0x10) != 0) {
            list2 = album.artists;
        }
        if ((n & 0x20) != 0) {
            l = album.trackCount;
        }
        if ((n & 0x40) != 0) {
            l2 = album.duration;
        }
        if ((n & 0x80) != 0) {
            date = album.releaseDate;
        }
        if ((n & 0x100) != 0) {
            string4 = album.description;
        }
        if ((n & 0x200) != 0) {
            imageHolder2 = album.background;
        }
        if ((n & 0x400) != 0) {
            string5 = album.label;
        }
        if ((n & 0x800) != 0) {
            bl = album.isExplicit;
        }
        if ((n & 0x1000) != 0) {
            string6 = album.subtitle;
        }
        if ((n & 0x2000) != 0) {
            map2 = album.extras;
        }
        if ((n & 0x4000) != 0) {
            bl2 = album.isRadioSupported;
        }
        if ((n & 0x8000) != 0) {
            bl3 = album.isFollowable;
        }
        if ((n & 0x10000) != 0) {
            bl4 = album.isSaveable;
        }
        if ((n & 0x20000) != 0) {
            bl5 = album.isLikeable;
        }
        if ((n & 0x40000) != 0) {
            bl6 = album.isHideable;
        }
        if ((n & 0x80000) != 0) {
            bl7 = album.isShareable;
        }
        return album.copy(string2, string3, type, imageHolder, list2, l, l2, date, string4, imageHolder2, string5, bl, string6, map2, bl2, bl3, bl4, bl5, bl6, bl7);
    }

    @NotNull
    public String toString() {
        return "Album(id=" + this.id + ", title=" + this.title + ", type=" + this.type + ", cover=" + this.cover + ", artists=" + this.artists + ", trackCount=" + this.trackCount + ", duration=" + this.duration + ", releaseDate=" + this.releaseDate + ", description=" + this.description + ", background=" + this.background + ", label=" + this.label + ", isExplicit=" + this.isExplicit + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", isRadioSupported=" + this.isRadioSupported + ", isFollowable=" + this.isFollowable + ", isSaveable=" + this.isSaveable + ", isLikeable=" + this.isLikeable + ", isHideable=" + this.isHideable + ", isShareable=" + this.isShareable + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + (this.type == null ? 0 : this.type.hashCode());
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + ((Object)this.artists).hashCode();
        result2 = result2 * 31 + (this.trackCount == null ? 0 : ((Object)this.trackCount).hashCode());
        result2 = result2 * 31 + (this.duration == null ? 0 : ((Object)this.duration).hashCode());
        result2 = result2 * 31 + (this.releaseDate == null ? 0 : this.releaseDate.hashCode());
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        result2 = result2 * 31 + (this.background == null ? 0 : this.background.hashCode());
        result2 = result2 * 31 + (this.label == null ? 0 : this.label.hashCode());
        result2 = result2 * 31 + Boolean.hashCode(this.isExplicit);
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
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
        if (!(other instanceof Album)) {
            return false;
        }
        Album album = (Album)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)album.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)album.title)) {
            return false;
        }
        if (this.type != album.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)album.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.artists, album.artists)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackCount, (Object)album.trackCount)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.duration, (Object)album.duration)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.releaseDate, (Object)album.releaseDate)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)album.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.background, (Object)album.background)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.label, (Object)album.label)) {
            return false;
        }
        if (this.isExplicit != album.isExplicit) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)album.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, album.extras)) {
            return false;
        }
        if (this.isRadioSupported != album.isRadioSupported) {
            return false;
        }
        if (this.isFollowable != album.isFollowable) {
            return false;
        }
        if (this.isSaveable != album.isSaveable) {
            return false;
        }
        if (this.isLikeable != album.isLikeable) {
            return false;
        }
        if (this.isHideable != album.isHideable) {
            return false;
        }
        return this.isShareable == album.isShareable;
    }

    @Override
    public boolean isPrivate() {
        return EchoMediaItem.Lists.super.isPrivate();
    }

    @Override
    @Nullable
    public String getSubtitleWithE() {
        return EchoMediaItem.Lists.super.getSubtitleWithE();
    }

    @Override
    public boolean sameAs(@NotNull EchoMediaItem other) {
        return EchoMediaItem.Lists.super.sameAs(other);
    }

    @Override
    @NotNull
    public Shelf.Item toShelf() {
        return EchoMediaItem.Lists.super.toShelf();
    }

    @Override
    @NotNull
    public EchoMediaItem copyMediaItem(@NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2) {
        return EchoMediaItem.Lists.super.copyMediaItem(id2, title, cover, description, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2);
    }

    /*
     * WARNING - void declaration
     */
    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Album self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getTitle());
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.getType() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.getType());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.getCover() != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.getCover());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.getArtists(), (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.getArtists());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.getTrackCount() != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.getTrackCount());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.getDuration() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.getDuration());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.releaseDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.releaseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : !Intrinsics.areEqual((Object)self.getBackground(), (Object)self.getCover())) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)lazyArray[9].getValue(), (Object)self.getBackground());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : self.getLabel() != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getLabel());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.isExplicit()) {
            output.encodeBooleanElement(serialDesc, 11, self.isExplicit());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : self.getSubtitle() != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 13, (SerializationStrategy)lazyArray[13].getValue(), self.getExtras());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : !self.isRadioSupported()) {
            output.encodeBooleanElement(serialDesc, 14, self.isRadioSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : self.isFollowable()) {
            output.encodeBooleanElement(serialDesc, 15, self.isFollowable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) ? true : !self.isSaveable()) {
            output.encodeBooleanElement(serialDesc, 16, self.isSaveable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) ? true : self.isLikeable()) {
            output.encodeBooleanElement(serialDesc, 17, self.isLikeable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) ? true : self.isHideable()) {
            output.encodeBooleanElement(serialDesc, 18, self.isHideable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) ? true : !self.isShareable()) {
            output.encodeBooleanElement(serialDesc, 19, self.isShareable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) ? true : !Intrinsics.areEqual((Object)self.getDate(), (Object)self.releaseDate)) {
            output.encodeNullableSerializableElement(serialDesc, 20, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.getDate());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 21)) {
            bl = true;
        } else {
            String string2 = self.getSubtitleWithOutE();
            String string3 = self.getSubtitle();
            if (string3 == null) {
                CharSequence charSequence;
                void $this$write_Self_u24lambda_u244;
                CharSequence charSequence2;
                StringBuilder stringBuilder = charSequence2 = new StringBuilder();
                String string4 = string2;
                boolean bl2 = false;
                $this$write_Self_u24lambda_u244.append(CollectionsKt.joinToString$default((Iterable)self.getArtists(), (CharSequence)", ", null, null, (int)0, null, Album::write_Self$lambda$4$lambda$3, (int)30, null));
                string2 = string4;
                charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
                if (StringsKt.isBlank((CharSequence)charSequence2)) {
                    string4 = string2;
                    boolean bl3 = false;
                    charSequence = null;
                    string2 = string4;
                } else {
                    charSequence = charSequence2;
                }
                string3 = (String)charSequence;
            }
            bl = !Intrinsics.areEqual((Object)string2, (Object)string3);
        }
        if (bl) {
            output.encodeNullableSerializableElement(serialDesc, 21, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitleWithOutE());
        }
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ Album(int seen0, String id2, String title, Type type, ImageHolder cover, List artists, Long trackCount, Long duration, Date releaseDate, String description, ImageHolder background2, String label, boolean isExplicit, String subtitle2, Map extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable, Date date, String subtitleWithOutE, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.type = (seen0 & 4) == 0 ? null : type;
        this.cover = (seen0 & 8) == 0 ? null : cover;
        this.artists = (seen0 & 0x10) == 0 ? CollectionsKt.emptyList() : artists;
        this.trackCount = (seen0 & 0x20) == 0 ? null : trackCount;
        this.duration = (seen0 & 0x40) == 0 ? null : duration;
        this.releaseDate = (seen0 & 0x80) == 0 ? null : releaseDate;
        this.description = (seen0 & 0x100) == 0 ? null : description;
        this.background = (seen0 & 0x200) == 0 ? this.getCover() : background2;
        this.label = (seen0 & 0x400) == 0 ? null : label;
        this.isExplicit = (seen0 & 0x800) == 0 ? false : isExplicit;
        this.subtitle = (seen0 & 0x1000) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x2000) == 0 ? MapsKt.emptyMap() : extras;
        this.isRadioSupported = (seen0 & 0x4000) == 0 ? true : isRadioSupported;
        this.isFollowable = (seen0 & 0x8000) == 0 ? false : isFollowable;
        this.isSaveable = (seen0 & 0x10000) == 0 ? true : isSaveable2;
        this.isLikeable = (seen0 & 0x20000) == 0 ? false : isLikeable;
        this.isHideable = (seen0 & 0x40000) == 0 ? false : isHideable;
        this.isShareable = (seen0 & 0x80000) == 0 ? true : isShareable;
        this.date = (seen0 & 0x100000) == 0 ? this.releaseDate : date;
        if ((seen0 & 0x200000) == 0) {
            Album album = this;
            String string2 = this.getSubtitle();
            if (string2 == null) {
                CharSequence charSequence;
                void $this$_init__u24lambda_u247;
                CharSequence charSequence2;
                StringBuilder stringBuilder = charSequence2 = new StringBuilder();
                Album album2 = album;
                boolean bl = false;
                $this$_init__u24lambda_u247.append(CollectionsKt.joinToString$default((Iterable)this.getArtists(), (CharSequence)", ", null, null, (int)0, null, Album::_init_$lambda$7$lambda$6, (int)30, null));
                album = album2;
                charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
                if (StringsKt.isBlank((CharSequence)charSequence2)) {
                    album2 = album;
                    boolean bl2 = false;
                    charSequence = null;
                    album = album2;
                } else {
                    charSequence = charSequence2;
                }
                string2 = (String)charSequence;
            }
            album.subtitleWithOutE = string2;
        } else {
            this.subtitleWithOutE = subtitleWithOutE;
        }
    }

    private static final CharSequence subtitleWithOutE$lambda$1$lambda$0(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final CharSequence write_Self$lambda$4$lambda$3(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final CharSequence _init_$lambda$7$lambda$6(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.Album.Type", (Enum[])Type.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null, null, null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Album$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Album;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Album> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Ldev/brahmkshatriya/echo/common/models/Album$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PreRelease", "Single", "EP", "LP", "Compilation", "Show", "Book", "common"})
    public static final class Type
    extends Enum<Type> {
        public static final /* enum */ Type PreRelease = new Type();
        public static final /* enum */ Type Single = new Type();
        public static final /* enum */ Type EP = new Type();
        public static final /* enum */ Type LP = new Type();
        public static final /* enum */ Type Compilation = new Type();
        public static final /* enum */ Type Show = new Type();
        public static final /* enum */ Type Book = new Type();
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
            $VALUES = typeArray = new Type[]{Type.PreRelease, Type.Single, Type.EP, Type.LP, Type.Compilation, Type.Show, Type.Book};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

