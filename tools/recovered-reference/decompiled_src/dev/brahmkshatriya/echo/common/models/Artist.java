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
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Artist$;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLB\u00a9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u00cb\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u0015\u0010\u001eJ\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH\u00c6\u0003J\t\u00107\u001a\u00020\u000fH\u00c6\u0003J\t\u00108\u001a\u00020\u000fH\u00c6\u0003J\t\u00109\u001a\u00020\u000fH\u00c6\u0003J\t\u0010:\u001a\u00020\u000fH\u00c6\u0003J\t\u0010;\u001a\u00020\u000fH\u00c6\u0003J\t\u0010<\u001a\u00020\u000fH\u00c6\u0003J\u00af\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010@H\u00d6\u0003J\t\u0010A\u001a\u00020\u0018H\u00d6\u0001J\t\u0010B\u001a\u00020\u0003H\u00d6\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001\u00a2\u0006\u0002\bJR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010+R\u0014\u0010\u0010\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010+R\u0014\u0010\u0011\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010+R\u0014\u0010\u0012\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010+R\u0014\u0010\u0013\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010+R\u0014\u0010\u0014\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010+R\u0014\u0010\u0019\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010 \u00a8\u0006M"}, d2={"Ldev/brahmkshatriya/echo/common/models/Artist;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "id", "", "name", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "bio", "background", "banners", "", "subtitle", "extras", "", "isRadioSupported", "", "isFollowable", "isSaveable", "isLikeable", "isHideable", "isShareable", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;ZZZZZZ)V", "seen0", "", "title", "description", "subtitleWithOutE", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;ZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getBio", "getBackground", "getBanners", "()Ljava/util/List;", "getSubtitle", "getExtras", "()Ljava/util/Map;", "()Z", "getTitle", "getDescription", "getSubtitleWithOutE", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Artist
implements EchoMediaItem {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @Nullable
    private final ImageHolder cover;
    @Nullable
    private final String bio;
    @Nullable
    private final ImageHolder background;
    @NotNull
    private final List<ImageHolder> banners;
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
    private final String title;
    @Nullable
    private final String description;
    @Nullable
    private final String subtitleWithOutE;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Artist(@NotNull String id2, @NotNull String name, @Nullable ImageHolder cover, @Nullable String bio, @Nullable ImageHolder background2, @NotNull List<? extends ImageHolder> banners, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(banners, (String)"banners");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        this.id = id2;
        this.name = name;
        this.cover = cover;
        this.bio = bio;
        this.background = background2;
        this.banners = banners;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.isRadioSupported = isRadioSupported;
        this.isFollowable = isFollowable;
        this.isSaveable = isSaveable2;
        this.isLikeable = isLikeable;
        this.isHideable = isHideable;
        this.isShareable = isShareable;
        this.title = this.name;
        this.description = this.bio;
        this.subtitleWithOutE = this.getSubtitle();
    }

    public /* synthetic */ Artist(String string2, String string3, ImageHolder imageHolder, String string4, ImageHolder imageHolder2, List list2, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            imageHolder = null;
        }
        if ((n & 8) != 0) {
            string4 = null;
        }
        if ((n & 0x10) != 0) {
            imageHolder2 = imageHolder;
        }
        if ((n & 0x20) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x40) != 0) {
            string5 = null;
        }
        if ((n & 0x80) != 0) {
            map2 = MapsKt.emptyMap();
        }
        if ((n & 0x100) != 0) {
            bl = true;
        }
        if ((n & 0x200) != 0) {
            bl2 = true;
        }
        if ((n & 0x400) != 0) {
            bl3 = true;
        }
        if ((n & 0x800) != 0) {
            bl4 = false;
        }
        if ((n & 0x1000) != 0) {
            bl5 = false;
        }
        if ((n & 0x2000) != 0) {
            bl6 = true;
        }
        this(string2, string3, imageHolder, string4, imageHolder2, list2, string5, map2, bl, bl2, bl3, bl4, bl5, bl6);
    }

    @Override
    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Override
    @Nullable
    public ImageHolder getCover() {
        return this.cover;
    }

    @Nullable
    public final String getBio() {
        return this.bio;
    }

    @Override
    @Nullable
    public ImageHolder getBackground() {
        return this.background;
    }

    @NotNull
    public final List<ImageHolder> getBanners() {
        return this.banners;
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
    public String getTitle() {
        return this.title;
    }

    @Override
    @Nullable
    public String getDescription() {
        return this.description;
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
        return this.name;
    }

    @Nullable
    public final ImageHolder component3() {
        return this.cover;
    }

    @Nullable
    public final String component4() {
        return this.bio;
    }

    @Nullable
    public final ImageHolder component5() {
        return this.background;
    }

    @NotNull
    public final List<ImageHolder> component6() {
        return this.banners;
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
        return this.isRadioSupported;
    }

    public final boolean component10() {
        return this.isFollowable;
    }

    public final boolean component11() {
        return this.isSaveable;
    }

    public final boolean component12() {
        return this.isLikeable;
    }

    public final boolean component13() {
        return this.isHideable;
    }

    public final boolean component14() {
        return this.isShareable;
    }

    @NotNull
    public final Artist copy(@NotNull String id2, @NotNull String name, @Nullable ImageHolder cover, @Nullable String bio, @Nullable ImageHolder background2, @NotNull List<? extends ImageHolder> banners, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(banners, (String)"banners");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        return new Artist(id2, name, cover, bio, background2, banners, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, isLikeable, isHideable, isShareable);
    }

    public static /* synthetic */ Artist copy$default(Artist artist, String string2, String string3, ImageHolder imageHolder, String string4, ImageHolder imageHolder2, List list2, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = artist.id;
        }
        if ((n & 2) != 0) {
            string3 = artist.name;
        }
        if ((n & 4) != 0) {
            imageHolder = artist.cover;
        }
        if ((n & 8) != 0) {
            string4 = artist.bio;
        }
        if ((n & 0x10) != 0) {
            imageHolder2 = artist.background;
        }
        if ((n & 0x20) != 0) {
            list2 = artist.banners;
        }
        if ((n & 0x40) != 0) {
            string5 = artist.subtitle;
        }
        if ((n & 0x80) != 0) {
            map2 = artist.extras;
        }
        if ((n & 0x100) != 0) {
            bl = artist.isRadioSupported;
        }
        if ((n & 0x200) != 0) {
            bl2 = artist.isFollowable;
        }
        if ((n & 0x400) != 0) {
            bl3 = artist.isSaveable;
        }
        if ((n & 0x800) != 0) {
            bl4 = artist.isLikeable;
        }
        if ((n & 0x1000) != 0) {
            bl5 = artist.isHideable;
        }
        if ((n & 0x2000) != 0) {
            bl6 = artist.isShareable;
        }
        return artist.copy(string2, string3, imageHolder, string4, imageHolder2, list2, string5, map2, bl, bl2, bl3, bl4, bl5, bl6);
    }

    @NotNull
    public String toString() {
        return "Artist(id=" + this.id + ", name=" + this.name + ", cover=" + this.cover + ", bio=" + this.bio + ", background=" + this.background + ", banners=" + this.banners + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", isRadioSupported=" + this.isRadioSupported + ", isFollowable=" + this.isFollowable + ", isSaveable=" + this.isSaveable + ", isLikeable=" + this.isLikeable + ", isHideable=" + this.isHideable + ", isShareable=" + this.isShareable + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + (this.bio == null ? 0 : this.bio.hashCode());
        result2 = result2 * 31 + (this.background == null ? 0 : this.background.hashCode());
        result2 = result2 * 31 + ((Object)this.banners).hashCode();
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
        if (!(other instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)artist.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)artist.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)artist.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bio, (Object)artist.bio)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.background, (Object)artist.background)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.banners, artist.banners)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)artist.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.extras, artist.extras)) {
            return false;
        }
        if (this.isRadioSupported != artist.isRadioSupported) {
            return false;
        }
        if (this.isFollowable != artist.isFollowable) {
            return false;
        }
        if (this.isSaveable != artist.isSaveable) {
            return false;
        }
        if (this.isLikeable != artist.isLikeable) {
            return false;
        }
        if (this.isHideable != artist.isHideable) {
            return false;
        }
        return this.isShareable == artist.isShareable;
    }

    @Override
    public boolean isExplicit() {
        return EchoMediaItem.super.isExplicit();
    }

    @Override
    public boolean isPrivate() {
        return EchoMediaItem.super.isPrivate();
    }

    @Override
    @Nullable
    public String getSubtitleWithE() {
        return EchoMediaItem.super.getSubtitleWithE();
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

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Artist self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.getId());
        output.encodeStringElement(serialDesc, 1, self.name);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.getCover() != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.getCover());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.bio != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.bio);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual((Object)self.getBackground(), (Object)self.getCover())) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), (Object)self.getBackground());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : !Intrinsics.areEqual(self.banners, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy)lazyArray[5].getValue(), self.banners);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.getSubtitle() != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : !Intrinsics.areEqual(self.getExtras(), (Object)MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 7, (SerializationStrategy)lazyArray[7].getValue(), self.getExtras());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : !self.isRadioSupported()) {
            output.encodeBooleanElement(serialDesc, 8, self.isRadioSupported());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : !self.isFollowable()) {
            output.encodeBooleanElement(serialDesc, 9, self.isFollowable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : !self.isSaveable()) {
            output.encodeBooleanElement(serialDesc, 10, self.isSaveable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.isLikeable()) {
            output.encodeBooleanElement(serialDesc, 11, self.isLikeable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : self.isHideable()) {
            output.encodeBooleanElement(serialDesc, 12, self.isHideable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : !self.isShareable()) {
            output.encodeBooleanElement(serialDesc, 13, self.isShareable());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : !Intrinsics.areEqual((Object)self.getTitle(), (Object)self.name)) {
            output.encodeStringElement(serialDesc, 14, self.getTitle());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : !Intrinsics.areEqual((Object)self.getDescription(), (Object)self.bio)) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getDescription());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) ? true : !Intrinsics.areEqual((Object)self.getSubtitleWithOutE(), (Object)self.getSubtitle())) {
            output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.getSubtitleWithOutE());
        }
    }

    public /* synthetic */ Artist(int seen0, String id2, String name, ImageHolder cover, String bio, ImageHolder background2, List banners, String subtitle2, Map extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2, boolean isLikeable, boolean isHideable, boolean isShareable, String title, String description, String subtitleWithOutE, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (3 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)3, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.name = name;
        this.cover = (seen0 & 4) == 0 ? null : cover;
        this.bio = (seen0 & 8) == 0 ? null : bio;
        this.background = (seen0 & 0x10) == 0 ? this.getCover() : background2;
        this.banners = (seen0 & 0x20) == 0 ? CollectionsKt.emptyList() : banners;
        this.subtitle = (seen0 & 0x40) == 0 ? null : subtitle2;
        this.extras = (seen0 & 0x80) == 0 ? MapsKt.emptyMap() : extras;
        this.isRadioSupported = (seen0 & 0x100) == 0 ? true : isRadioSupported;
        this.isFollowable = (seen0 & 0x200) == 0 ? true : isFollowable;
        this.isSaveable = (seen0 & 0x400) == 0 ? true : isSaveable2;
        this.isLikeable = (seen0 & 0x800) == 0 ? false : isLikeable;
        this.isHideable = (seen0 & 0x1000) == 0 ? false : isHideable;
        this.isShareable = (seen0 & 0x2000) == 0 ? true : isShareable;
        this.title = (seen0 & 0x4000) == 0 ? this.name : title;
        this.description = (seen0 & 0x8000) == 0 ? this.bio : description;
        this.subtitleWithOutE = (seen0 & 0x10000) == 0 ? this.getSubtitle() : subtitleWithOutE;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer(ImageHolder.Companion.serializer())), null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new LinkedHashMapSerializer((KSerializer)StringSerializer.INSTANCE, (KSerializer)StringSerializer.INSTANCE)), null, null, null, null, null, null, null, null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Artist$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Artist;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Artist> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

