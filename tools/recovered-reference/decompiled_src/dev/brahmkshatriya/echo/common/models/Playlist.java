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
 *  kotlinx.serialization.internal.LinkedHashMapSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.Artist$;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.Date$;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Playlist$;
import dev.brahmkshatriya.echo.common.models.Shelf;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ^2\u00020\u0001:\u0002]^B\u00df\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u00f5\u0001\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b\u001d\u0010%J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0006H\u00c6\u0003J\t\u0010>\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u0010\u0010B\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010/J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016H\u00c6\u0003J\t\u0010H\u001a\u00020\u0006H\u00c6\u0003J\t\u0010I\u001a\u00020\u0006H\u00c6\u0003J\t\u0010J\u001a\u00020\u0006H\u00c6\u0003J\t\u0010K\u001a\u00020\u0006H\u00c6\u0003J\t\u0010L\u001a\u00020\u0006H\u00c6\u0003J\t\u0010M\u001a\u00020\u0006H\u00c6\u0003J\u00ec\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u00062\b\u0010Q\u001a\u0004\u0018\u00010RH\u00d6\u0003J\t\u0010S\u001a\u00020 H\u00d6\u0001J\t\u0010T\u001a\u00020\u0003H\u00d6\u0001J%\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0001\u00a2\u0006\u0002\b\\R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010)R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010)R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0096\u0004\u00a2\u0006\n\n\u0002\u00100\u001a\u0004\b1\u0010/R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010'R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010+R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010'R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010)R\u0014\u0010\u0018\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010)R\u0014\u0010\u0019\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010)R\u0014\u0010\u001a\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010)R\u0014\u0010\u001b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010)R\u0014\u0010\u001c\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010)R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0016\u0010\"\u001a\u0004\u0018\u00010\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00103\u00a8\u0006_"}, d2={"Ldev/brahmkshatriya/echo/common/models/Playlist;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "id", "", "title", "isEditable", "", "isPrivate", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "authors", "", "Ldev/brahmkshatriya/echo/common/models/Artist;", "trackCount", "", "duration", "creationDate", "Ldev/brahmkshatriya/echo/common/models/Date;", "description", "background", "subtitle", "extras", "", "isRadioSupported", "isFollowable", "isSaveable", "isLikeable", "isHideable", "isShareable", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLdev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;ZZZZZZ)V", "seen0", "", "artists", "date", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZZLdev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;ZZZZZZLjava/util/List;Ldev/brahmkshatriya/echo/common/models/Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "()Z", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getAuthors", "()Ljava/util/List;", "getTrackCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDuration", "getCreationDate", "()Ldev/brahmkshatriya/echo/common/models/Date;", "getDescription", "getBackground", "getSubtitle", "getExtras", "()Ljava/util/Map;", "getArtists", "getDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLdev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Ldev/brahmkshatriya/echo/common/models/Date;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/util/Map;ZZZZZZ)Ldev/brahmkshatriya/echo/common/models/Playlist;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Playlist
implements EchoMediaItem.Lists {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    private final boolean isEditable;
    private final boolean isPrivate;
    @Nullable
    private final ImageHolder cover;
    @NotNull
    private final List<Artist> authors;
    @Nullable
    private final Long trackCount;
    @Nullable
    private final Long duration;
    @Nullable
    private final Date creationDate;
    @Nullable
    private final String description;
    @Nullable
    private final ImageHolder background;
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
    @NotNull
    private final List<Artist> artists;
    @Nullable
    private final Date date;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Playlist(@NotNull String id2, @NotNull String title, boolean isEditable, boolean isPrivate, @Nullable ImageHolder cover, @NotNull List<Artist> authors, @Nullable Long trackCount, @Nullable Long duration, @Nullable Date creationDate, @Nullable String description, @Nullable ImageHolder background2, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(authors, (String)"authors");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.title = title;
        this.isEditable = isEditable;
        this.isPrivate = isPrivate;
        this.cover = cover;
        this.authors = authors;
        this.trackCount = trackCount;
        this.duration = duration;
        this.creationDate = creationDate;
        this.description = description;
        this.background = background2;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.isRadioSupported = isRadioSupported;
        this.isFollowable = isFollowable;
        this.isSaveable = isSaveable2;
        this.isLikeable = isLikeable;
        this.isHideable = isHideable;
        this.isShareable = isShareable;
        this.artists = this.authors;
        this.date = this.creationDate;
    }

    public /* synthetic */ Playlist(String string2, String string3, boolean bl, boolean bl2, ImageHolder imageHolder, List list2, Long l, Long l2, Date date, String string4, ImageHolder imageHolder2, String string5, Map map2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            bl2 = true;
        }
        if ((n & 0x10) != 0) {
            imageHolder = null;
        }
        if ((n & 0x20) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x40) != 0) {
            l = null;
        }
        if ((n & 0x80) != 0) {
            l2 = null;
        }
        if ((n & 0x100) != 0) {
            date = null;
        }
        if ((n & 0x200) != 0) {
            string4 = null;
        }
        if ((n & 0x400) != 0) {
            imageHolder2 = imageHolder;
        }
        if ((n & 0x800) != 0) {
            string5 = null;
        }
        if ((n & 0x1000) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x2000) != 0) {
            bl3 = true;
        }
        if ((n & 0x4000) != 0) {
            bl4 = false;
        }
        if ((n & 0x8000) != 0) {
            bl5 = true;
        }
        if ((n & 0x10000) != 0) {
            bl6 = false;
        }
        if ((n & 0x20000) != 0) {
            bl7 = false;
        }
        if ((n & 0x40000) != 0) {
            bl8 = true;
        }
        this(string2, string3, bl, bl2, imageHolder, list2, l, l2, date, string4, imageHolder2, string5, map2, bl3, bl4, bl5, bl6, bl7, bl8);
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

    public final boolean isEditable() {
        return this.isEditable;
    }

    @Override
    public boolean isPrivate() {
        return this.isPrivate;
    }

    @Override
    @Nullable
    public ImageHolder getCover() {
        return this.cover;
    }

    @NotNull
    public final List<Artist> getAuthors() {
        return this.authors;
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
    public final Date getCreationDate() {
        return this.creationDate;
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
    @NotNull
    public List<Artist> getArtists() {
        return this.artists;
    }

    @Override
    @Nullable
    public Date getDate() {
        return this.date;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.isEditable;
    }

    public final boolean component4() {
        return this.isPrivate;
    }

    @Nullable
    public final ImageHolder component5() {
        return this.cover;
    }

    @NotNull
    public final List<Artist> component6() {
        return this.authors;
    }

    @Nullable
    public final Long component7() {
        return this.trackCount;
    }

    @Nullable
    public final Long component8() {
        return this.duration;
    }

    @Nullable
    public final Date component9() {
        return this.creationDate;
    }

    @Nullable
    public final String component10() {
        return this.description;
    }

    @Nullable
    public final ImageHolder component11() {
        return this.background;
    }

    @Nullable
    public final String component12() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> component13() {
        return this.extras;
    }

    public final boolean component14() {
        return this.isRadioSupported;
    }

    public final boolean component15() {
        return this.isFollowable;
    }

    public final boolean component16() {
        return this.isSaveable;
    }

    public final boolean component17() {
        return this.isLikeable;
    }

    public final boolean component18() {
        return this.isHideable;
    }

    public final boolean component19() {
        return this.isShareable;
    }

    @NotNull
    public final Playlist copy(@NotNull String id2, @NotNull String title, boolean isEditable, boolean isPrivate, @Nullable ImageHolder cover, @NotNull List<Artist> authors, @Nullable Long trackCount, @Nullable Long duration, @Nullable Date creationDate, @Nullable String description, @Nullable ImageHolder background2, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(authors, (String)"authors");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Playlist(id2, title, isEditable, isPrivate, cover, authors, trackCount, duration, creationDate, description, background2, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, isLikeable, isHideable, isShareable);
    }

    public static /* synthetic */ Playlist copy$default(Playlist playlist, String string2, String string3, boolean bl, boolean bl2, ImageHolder imageHolder, List list2, Long l, Long l2, Date date, String string4, ImageHolder imageHolder2, String string5, Map map2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = playlist.id;
        }
        if ((n & 2) != 0) {
            string3 = playlist.title;
        }
        if ((n & 4) != 0) {
            bl = playlist.isEditable;
        }
        if ((n & 8) != 0) {
            bl2 = playlist.isPrivate;
        }
        if ((n & 0x10) != 0) {
            imageHolder = playlist.cover;
        }
        if ((n & 0x20) != 0) {
            list2 = playlist.authors;
        }
        if ((n & 0x40) != 0) {
            l = playlist.trackCount;
        }
        if ((n & 0x80) != 0) {
            l2 = playlist.duration;
        }
        if ((n & 0x100) != 0) {
            date = playlist.creationDate;
        }
        if ((n & 0x200) != 0) {
            string4 = playlist.description;
        }
        if ((n & 0x400) != 0) {
            imageHolder2 = playlist.background;
        }
        if ((n & 0x800) != 0) {
            string5 = playlist.subtitle;
        }
        if ((n & 0x1000) != 0) {
            map2 = playlist.extras;
        }
        if ((n & 0x2000) != 0) {
            bl3 = playlist.isRadioSupported;
        }
        if ((n & 0x4000) != 0) {
            bl4 = playlist.isFollowable;
        }
        if ((n & 0x8000) != 0) {
            bl5 = playlist.isSaveable;
        }
        if ((n & 0x10000) != 0) {
            bl6 = playlist.isLikeable;
        }
        if ((n & 0x20000) != 0) {
            bl7 = playlist.isHideable;
        }
        if ((n & 0x40000) != 0) {
            bl8 = playlist.isShareable;
        }
        return playlist.copy(string2, string3, bl, bl2, imageHolder, list2, l, l2, date, string4, imageHolder2, string5, map2, bl3, bl4, bl5, bl6, bl7, bl8);
    }

    @NotNull
    public String toString() {
        return "Playlist(id=" + this.id + ", title=" + this.title + ", isEditable=" + this.isEditable + ", isPrivate=" + this.isPrivate + ", cover=" + this.cover + ", authors=" + this.authors + ", trackCount=" + this.trackCount + ", duration=" + this.duration + ", creationDate=" + this.creationDate + ", description=" + this.description + ", background=" + this.background + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", isRadioSupported=" + this.isRadioSupported + ", isFollowable=" + this.isFollowable + ", isSaveable=" + this.isSaveable + ", isLikeable=" + this.isLikeable + ", isHideable=" + this.isHideable + ", isShareable=" + this.isShareable + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.isEditable);
        result2 = result2 * 31 + Boolean.hashCode(this.isPrivate);
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + ((Object)this.authors).hashCode();
        result2 = result2 * 31 + (this.trackCount == null ? 0 : ((Object)this.trackCount).hashCode());
        result2 = result2 * 31 + (this.duration == null ? 0 : ((Object)this.duration).hashCode());
        result2 = result2 * 31 + (this.creationDate == null ? 0 : this.creationDate.hashCode());
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        result2 = result2 * 31 + (this.background == null ? 0 : this.background.hashCode());
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
        if (!(other instanceof Playlist)) {
            return false;
        }
        Playlist playlist = (Playlist)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)playlist.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)playlist.title)) {
            return false;
        }
        if (this.isEditable != playlist.isEditable) {
            return false;
        }
        if (this.isPrivate != playlist.isPrivate) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)playlist.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.authors, playlist.authors)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackCount, (Object)playlist.trackCount)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.duration, (Object)playlist.duration)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.creationDate, (Object)playlist.creationDate)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)playlist.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.background, (Object)playlist.background)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)playlist.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, playlist.extras)) {
            return false;
        }
        if (this.isRadioSupported != playlist.isRadioSupported) {
            return false;
        }
        if (this.isFollowable != playlist.isFollowable) {
            return false;
        }
        if (this.isSaveable != playlist.isSaveable) {
            return false;
        }
        if (this.isLikeable != playlist.isLikeable) {
            return false;
        }
        if (this.isHideable != playlist.isHideable) {
            return false;
        }
        return this.isShareable == playlist.isShareable;
    }

    @Override
    @Nullable
    public String getLabel() {
        return EchoMediaItem.Lists.super.getLabel();
    }

    @Override
    @Nullable
    public Album.Type getType() {
        return EchoMediaItem.Lists.super.getType();
    }

    @Override
    @Nullable
    public String getSubtitleWithOutE() {
        return EchoMediaItem.Lists.super.getSubtitleWithOutE();
    }

    @Override
    public boolean isExplicit() {
        return EchoMediaItem.Lists.super.isExplicit();
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

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Playlist self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getTitle());
        output.encodeBooleanElement(serialDesc, 2, self.isEditable);
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !self.isPrivate()) {
            output.encodeBooleanElement(serialDesc, 3, self.isPrivate());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getCover() != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), (Object)self.getCover());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.authors, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.authors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.getTrackCount() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.getTrackCount());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.getDuration() != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.getDuration());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.creationDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.creationDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : !Intrinsics.areEqual((Object)self.getBackground(), (Object)self.getCover())) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy)lazyArray[10].getValue(), (Object)self.getBackground());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.getSubtitle() != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 12, (SerializationStrategy)lazyArray[12].getValue(), self.getExtras());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : !self.isRadioSupported()) {
            output.encodeBooleanElement(serialDesc, 13, self.isRadioSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : self.isFollowable()) {
            output.encodeBooleanElement(serialDesc, 14, self.isFollowable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : !self.isSaveable()) {
            output.encodeBooleanElement(serialDesc, 15, self.isSaveable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) ? true : self.isLikeable()) {
            output.encodeBooleanElement(serialDesc, 16, self.isLikeable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) ? true : self.isHideable()) {
            output.encodeBooleanElement(serialDesc, 17, self.isHideable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) ? true : !self.isShareable()) {
            output.encodeBooleanElement(serialDesc, 18, self.isShareable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 19) ? true : !Intrinsics.areEqual(self.getArtists(), self.authors)) {
            output.encodeSerializableElement(serialDesc, 19, (SerializationStrategy)lazyArray[19].getValue(), self.getArtists());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 20) ? true : !Intrinsics.areEqual((Object)self.getDate(), (Object)self.creationDate)) {
            output.encodeNullableSerializableElement(serialDesc, 20, (SerializationStrategy)Date$.serializer.INSTANCE, (Object)self.getDate());
        }
    }

    public /* synthetic */ Playlist(int seen0, String id2, String title, boolean isEditable, boolean isPrivate, ImageHolder cover, List authors, Long trackCount, Long duration, Date creationDate, String description, ImageHolder background2, String subtitle2, Map extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable, List artists, Date date, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (7 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)7, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.isEditable = isEditable;
        this.isPrivate = (seen0 & 8) == 0 ? true : isPrivate;
        this.cover = (seen0 & 0x10) == 0 ? null : cover;
        this.authors = (seen0 & 0x20) == 0 ? CollectionsKt.emptyList() : authors;
        this.trackCount = (seen0 & 0x40) == 0 ? null : trackCount;
        this.duration = (seen0 & 0x80) == 0 ? null : duration;
        this.creationDate = (seen0 & 0x100) == 0 ? null : creationDate;
        this.description = (seen0 & 0x200) == 0 ? null : description;
        this.background = (seen0 & 0x400) == 0 ? this.getCover() : background2;
        this.subtitle = (seen0 & 0x800) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x1000) == 0 ? MapsKt.emptyMap() : extras;
        this.isRadioSupported = (seen0 & 0x2000) == 0 ? true : isRadioSupported;
        this.isFollowable = (seen0 & 0x4000) == 0 ? false : isFollowable;
        this.isSaveable = (seen0 & 0x8000) == 0 ? true : isSaveable2;
        this.isLikeable = (seen0 & 0x10000) == 0 ? false : isLikeable;
        this.isHideable = (seen0 & 0x20000) == 0 ? false : isHideable;
        this.isShareable = (seen0 & 0x40000) == 0 ? true : isShareable;
        this.artists = (seen0 & 0x80000) == 0 ? this.authors : artists;
        this.date = (seen0 & 0x100000) == 0 ? this.creationDate : date;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Playlist$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Playlist> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

