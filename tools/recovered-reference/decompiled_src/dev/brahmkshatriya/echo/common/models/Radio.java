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
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Radio$;
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
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017B\u00c7\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u0016\u0010\u001fJ\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010(J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u00c6\u0003J\t\u00109\u001a\u00020\u0011H\u00c6\u0003J\t\u0010:\u001a\u00020\u0011H\u00c6\u0003J\t\u0010;\u001a\u00020\u0011H\u00c6\u0003J\t\u0010<\u001a\u00020\u0011H\u00c6\u0003J\t\u0010=\u001a\u00020\u0011H\u00c6\u0003J\u00aa\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u00c6\u0001\u00a2\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u00112\b\u0010A\u001a\u0004\u0018\u00010BH\u00d6\u0003J\t\u0010C\u001a\u00020\u0019H\u00d6\u0001J\t\u0010D\u001a\u00020\u0003H\u00d6\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001\u00a2\u0006\u0002\bLR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004\u00a2\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010.R\u0014\u0010\u0012\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010.R\u0014\u0010\u0013\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010.R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010.R\u0014\u0010\u0015\u001a\u00020\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010.R\u0014\u0010\u001a\u001a\u00020\u0011X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010.R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010$\u00a8\u0006O"}, d2={"Ldev/brahmkshatriya/echo/common/models/Radio;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "id", "", "title", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "authors", "", "Ldev/brahmkshatriya/echo/common/models/Artist;", "trackCount", "", "description", "subtitle", "extras", "", "isFollowable", "", "isSaveable", "isLikeable", "isHideable", "isShareable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZZZZ)V", "seen0", "", "isRadioSupported", "artists", "background", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZZZZZLjava/util/List;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getAuthors", "()Ljava/util/List;", "getTrackCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDescription", "getSubtitle", "getExtras", "()Ljava/util/Map;", "()Z", "getArtists", "getBackground", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ZZZZZ)Ldev/brahmkshatriya/echo/common/models/Radio;", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Radio
implements EchoMediaItem.Lists {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @Nullable
    private final ImageHolder cover;
    @NotNull
    private final List<Artist> authors;
    @Nullable
    private final Long trackCount;
    @Nullable
    private final String description;
    @Nullable
    private final String subtitle;
    @NotNull
    private final Map<String, String> extras;
    private final boolean isFollowable;
    private final boolean isSaveable;
    private final boolean isLikeable;
    private final boolean isHideable;
    private final boolean isShareable;
    private final boolean isRadioSupported;
    @NotNull
    private final List<Artist> artists;
    @Nullable
    private final ImageHolder background;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Radio(@NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @NotNull List<Artist> authors, @Nullable Long trackCount, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(authors, (String)"authors");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.title = title;
        this.cover = cover;
        this.authors = authors;
        this.trackCount = trackCount;
        this.description = description;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.isFollowable = isFollowable;
        this.isSaveable = isSaveable2;
        this.isLikeable = isLikeable;
        this.isHideable = isHideable;
        this.isShareable = isShareable;
        this.artists = this.authors;
    }

    public /* synthetic */ Radio(String string2, String string3, ImageHolder imageHolder, List list2, Long l, String string4, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            imageHolder = null;
        }
        if ((n & 8) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x10) != 0) {
            l = null;
        }
        if ((n & 0x20) != 0) {
            string4 = null;
        }
        if ((n & 0x40) != 0) {
            string5 = null;
        }
        if ((n & 0x80) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x100) != 0) {
            bl = false;
        }
        if ((n & 0x200) != 0) {
            bl2 = false;
        }
        if ((n & 0x400) != 0) {
            bl3 = false;
        }
        if ((n & 0x800) != 0) {
            bl4 = false;
        }
        if ((n & 0x1000) != 0) {
            bl5 = true;
        }
        this(string2, string3, imageHolder, list2, l, string4, string5, map2, bl, bl2, bl3, bl4, bl5);
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
    public String getDescription() {
        return this.description;
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
    public boolean isRadioSupported() {
        return this.isRadioSupported;
    }

    @Override
    @NotNull
    public List<Artist> getArtists() {
        return this.artists;
    }

    @Override
    @Nullable
    public ImageHolder getBackground() {
        return this.background;
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
    public final ImageHolder component3() {
        return this.cover;
    }

    @NotNull
    public final List<Artist> component4() {
        return this.authors;
    }

    @Nullable
    public final Long component5() {
        return this.trackCount;
    }

    @Nullable
    public final String component6() {
        return this.description;
    }

    @Nullable
    public final String component7() {
        return this.subtitle;
    }

    @NotNull
    public final Map<String, String> component8() {
        return this.extras;
    }

    public final boolean component9() {
        return this.isFollowable;
    }

    public final boolean component10() {
        return this.isSaveable;
    }

    public final boolean component11() {
        return this.isLikeable;
    }

    public final boolean component12() {
        return this.isHideable;
    }

    public final boolean component13() {
        return this.isShareable;
    }

    @NotNull
    public final Radio copy(@NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @NotNull List<Artist> authors, @Nullable Long trackCount, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(authors, (String)"authors");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Radio(id2, title, cover, authors, trackCount, description, subtitle2, extras, isFollowable, isSaveable2, isLikeable, isHideable, isShareable);
    }

    public static /* synthetic */ Radio copy$default(Radio radio2, String string2, String string3, ImageHolder imageHolder, List list2, Long l, String string4, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = radio2.id;
        }
        if ((n & 2) != 0) {
            string3 = radio2.title;
        }
        if ((n & 4) != 0) {
            imageHolder = radio2.cover;
        }
        if ((n & 8) != 0) {
            list2 = radio2.authors;
        }
        if ((n & 0x10) != 0) {
            l = radio2.trackCount;
        }
        if ((n & 0x20) != 0) {
            string4 = radio2.description;
        }
        if ((n & 0x40) != 0) {
            string5 = radio2.subtitle;
        }
        if ((n & 0x80) != 0) {
            map2 = radio2.extras;
        }
        if ((n & 0x100) != 0) {
            bl = radio2.isFollowable;
        }
        if ((n & 0x200) != 0) {
            bl2 = radio2.isSaveable;
        }
        if ((n & 0x400) != 0) {
            bl3 = radio2.isLikeable;
        }
        if ((n & 0x800) != 0) {
            bl4 = radio2.isHideable;
        }
        if ((n & 0x1000) != 0) {
            bl5 = radio2.isShareable;
        }
        return radio2.copy(string2, string3, imageHolder, list2, l, string4, string5, map2, bl, bl2, bl3, bl4, bl5);
    }

    @NotNull
    public String toString() {
        return "Radio(id=" + this.id + ", title=" + this.title + ", cover=" + this.cover + ", authors=" + this.authors + ", trackCount=" + this.trackCount + ", description=" + this.description + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", isFollowable=" + this.isFollowable + ", isSaveable=" + this.isSaveable + ", isLikeable=" + this.isLikeable + ", isHideable=" + this.isHideable + ", isShareable=" + this.isShareable + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + ((Object)this.authors).hashCode();
        result2 = result2 * 31 + (this.trackCount == null ? 0 : ((Object)this.trackCount).hashCode());
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + ((Object)this.extras).hashCode();
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
        if (!(other instanceof Radio)) {
            return false;
        }
        Radio radio2 = (Radio)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)radio2.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)radio2.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)radio2.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.authors, radio2.authors)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackCount, (Object)radio2.trackCount)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)radio2.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)radio2.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, radio2.extras)) {
            return false;
        }
        if (this.isFollowable != radio2.isFollowable) {
            return false;
        }
        if (this.isSaveable != radio2.isSaveable) {
            return false;
        }
        if (this.isLikeable != radio2.isLikeable) {
            return false;
        }
        if (this.isHideable != radio2.isHideable) {
            return false;
        }
        return this.isShareable == radio2.isShareable;
    }

    @Override
    @Nullable
    public Long getDuration() {
        return EchoMediaItem.Lists.super.getDuration();
    }

    @Override
    @Nullable
    public Date getDate() {
        return EchoMediaItem.Lists.super.getDate();
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

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Radio self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.getTitle());
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.getCover() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.getCover());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : !Intrinsics.areEqual(self.authors, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), self.authors);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.getTrackCount() != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.getTrackCount());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.getDescription() != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.getSubtitle() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 7, (SerializationStrategy)lazyArray[7].getValue(), self.getExtras());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.isFollowable()) {
            output.encodeBooleanElement(serialDesc, 8, self.isFollowable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.isSaveable()) {
            output.encodeBooleanElement(serialDesc, 9, self.isSaveable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : self.isLikeable()) {
            output.encodeBooleanElement(serialDesc, 10, self.isLikeable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.isHideable()) {
            output.encodeBooleanElement(serialDesc, 11, self.isHideable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : !self.isShareable()) {
            output.encodeBooleanElement(serialDesc, 12, self.isShareable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : self.isRadioSupported()) {
            output.encodeBooleanElement(serialDesc, 13, self.isRadioSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : !Intrinsics.areEqual(self.getArtists(), self.authors)) {
            output.encodeSerializableElement(serialDesc, 14, (SerializationStrategy)lazyArray[14].getValue(), self.getArtists());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : self.getBackground() != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy)lazyArray[15].getValue(), (Object)self.getBackground());
        }
    }

    public /* synthetic */ Radio(int seen0, String id2, String title, ImageHolder cover, List authors, Long trackCount, String description, String subtitle2, Map extras, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable, boolean isRadioSupported, List artists, ImageHolder background2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.title = title;
        this.cover = (seen0 & 4) == 0 ? null : cover;
        this.authors = (seen0 & 8) == 0 ? CollectionsKt.emptyList() : authors;
        this.trackCount = (seen0 & 0x10) == 0 ? null : trackCount;
        this.description = (seen0 & 0x20) == 0 ? null : description;
        this.subtitle = (seen0 & 0x40) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x80) == 0 ? MapsKt.emptyMap() : extras;
        this.isFollowable = (seen0 & 0x100) == 0 ? false : isFollowable;
        this.isSaveable = (seen0 & 0x200) == 0 ? false : isSaveable2;
        this.isLikeable = (seen0 & 0x400) == 0 ? false : isLikeable;
        this.isHideable = (seen0 & 0x800) == 0 ? false : isHideable;
        this.isShareable = (seen0 & 0x1000) == 0 ? true : isShareable;
        this.isRadioSupported = (seen0 & 0x2000) == 0 ? false : isRadioSupported;
        this.artists = (seen0 & 0x4000) == 0 ? this.authors : artists;
        this.background = (seen0 & 0x8000) == 0 ? null : background2;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Artist$.serializer.INSTANCE)), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer())};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Radio$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Radio;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Radio> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

