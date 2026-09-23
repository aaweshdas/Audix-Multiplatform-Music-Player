/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.SealedClassSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.json.JsonClassDiscriminator
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Album$;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.Artist$;
import dev.brahmkshatriya.echo.common.models.Date;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Playlist$;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Radio$;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.Track$;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonClassDiscriminator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClassDiscriminator(discriminator="mediaItemType")
@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 *2\u00020\u0001:\u0002)*J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0000H\u0016J\b\u0010&\u001a\u00020'H\u0016Jt\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0017H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u001e\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0012\u0010\u001a\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0018R\u0012\u0010\u001c\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R\u0012\u0010\u001d\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0005\u0082\u0001\u0003+,-\u00a8\u0006.\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "", "id", "", "getId", "()Ljava/lang/String;", "title", "getTitle", "cover", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getCover", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "description", "getDescription", "background", "getBackground", "subtitle", "getSubtitle", "extras", "", "getExtras", "()Ljava/util/Map;", "isRadioSupported", "", "()Z", "isFollowable", "isSaveable", "isLikeable", "isHideable", "isShareable", "isExplicit", "isPrivate", "subtitleWithOutE", "getSubtitleWithOutE", "subtitleWithE", "getSubtitleWithE", "sameAs", "other", "toShelf", "Ldev/brahmkshatriya/echo/common/models/Shelf$Item;", "copyMediaItem", "Lists", "Companion", "Ldev/brahmkshatriya/echo/common/models/Artist;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "Ldev/brahmkshatriya/echo/common/models/Track;", "common"})
@SourceDebugExtension(value={"SMAP\nEchoMediaItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoMediaItem.kt\ndev/brahmkshatriya/echo/common/models/EchoMediaItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
public sealed interface EchoMediaItem
permits Artist, Lists, Track {
    @NotNull
    public static final Companion Companion = dev.brahmkshatriya.echo.common.models.EchoMediaItem$Companion.$$INSTANCE;

    @NotNull
    public String getId();

    @NotNull
    public String getTitle();

    @Nullable
    public ImageHolder getCover();

    @Nullable
    public String getDescription();

    @Nullable
    public ImageHolder getBackground();

    @Nullable
    public String getSubtitle();

    @NotNull
    public Map<String, String> getExtras();

    public boolean isRadioSupported();

    public boolean isFollowable();

    public boolean isSaveable();

    public boolean isLikeable();

    public boolean isHideable();

    public boolean isShareable();

    default public boolean isExplicit() {
        return false;
    }

    default public boolean isPrivate() {
        return false;
    }

    @Nullable
    public String getSubtitleWithOutE();

    @Nullable
    default public String getSubtitleWithE() {
        CharSequence charSequence;
        String string2;
        CharSequence charSequence2;
        StringBuilder $this$_get_subtitleWithE__u24lambda_u240 = charSequence2 = new StringBuilder();
        boolean bl = false;
        if (this.isExplicit()) {
            $this$_get_subtitleWithE__u24lambda_u240.append("\ud83c\udd74 ");
        }
        if ((string2 = this.getSubtitleWithOutE()) == null) {
            string2 = "";
        }
        $this$_get_subtitleWithE__u24lambda_u240.append(string2);
        charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
        if (StringsKt.isBlank((CharSequence)charSequence2)) {
            boolean bl2 = false;
            charSequence = null;
        } else {
            charSequence = charSequence2;
        }
        return (String)charSequence;
    }

    default public boolean sameAs(@NotNull EchoMediaItem other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return this.getClass() == other.getClass() && Intrinsics.areEqual((Object)this.getId(), (Object)other.getId());
    }

    @NotNull
    default public Shelf.Item toShelf() {
        return new Shelf.Item(this);
    }

    @NotNull
    default public EchoMediaItem copyMediaItem(@NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2) {
        EchoMediaItem echoMediaItem;
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(extras, (String)"extras");
        EchoMediaItem echoMediaItem2 = this;
        if (echoMediaItem2 instanceof Artist) {
            echoMediaItem = Artist.copy$default((Artist)this, id2, title, cover, description, null, null, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, false, false, false, 14384, null);
        } else if (echoMediaItem2 instanceof Album) {
            echoMediaItem = Album.copy$default((Album)this, id2, title, null, cover, null, null, null, null, description, null, null, false, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, false, false, false, 921332, null);
        } else if (echoMediaItem2 instanceof Playlist) {
            echoMediaItem = Playlist.copy$default((Playlist)this, id2, title, false, false, cover, null, null, null, null, description, null, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2, false, false, false, 460268, null);
        } else if (echoMediaItem2 instanceof Radio) {
            echoMediaItem = Radio.copy$default((Radio)this, id2, title, cover, null, null, description, subtitle2, extras, isFollowable, isSaveable2, false, false, false, 7192, null);
        } else if (echoMediaItem2 instanceof Track) {
            echoMediaItem = Track.copy$default((Track)this, id2, title, null, cover, null, null, null, null, null, null, description, null, null, null, null, null, null, false, subtitle2, extras, null, null, isRadioSupported, isFollowable, isSaveable2, false, false, false, 238287860, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return echoMediaItem;
    }

    public static /* synthetic */ EchoMediaItem copyMediaItem$default(EchoMediaItem echoMediaItem, String string2, String string3, ImageHolder imageHolder, String string4, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyMediaItem");
        }
        if ((n & 1) != 0) {
            string2 = echoMediaItem.getId();
        }
        if ((n & 2) != 0) {
            string3 = echoMediaItem.getTitle();
        }
        if ((n & 4) != 0) {
            imageHolder = echoMediaItem.getCover();
        }
        if ((n & 8) != 0) {
            string4 = echoMediaItem.getDescription();
        }
        if ((n & 0x10) != 0) {
            string5 = echoMediaItem.getSubtitle();
        }
        if ((n & 0x20) != 0) {
            map2 = echoMediaItem.getExtras();
        }
        if ((n & 0x40) != 0) {
            bl = echoMediaItem.isRadioSupported();
        }
        if ((n & 0x80) != 0) {
            bl2 = echoMediaItem.isFollowable();
        }
        if ((n & 0x100) != 0) {
            bl3 = echoMediaItem.isSaveable();
        }
        return echoMediaItem.copyMediaItem(string2, string3, imageHolder, string4, string5, map2, bl, bl2, bl3);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final KSerializer<EchoMediaItem> serializer() {
            Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Artist.class), Reflection.getOrCreateKotlinClass(Album.class), Reflection.getOrCreateKotlinClass(Playlist.class), Reflection.getOrCreateKotlinClass(Radio.class), Reflection.getOrCreateKotlinClass(Track.class)};
            KClass[] kClassArray = objectArray;
            objectArray = new KSerializer[]{Artist$.serializer.INSTANCE, Album$.serializer.INSTANCE, Playlist$.serializer.INSTANCE, Radio$.serializer.INSTANCE, Track$.serializer.INSTANCE};
            KClass[] kClassArray2 = objectArray;
            objectArray = new Annotation[]{new JsonClassDiscriminator("mediaItemType"){
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
            return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.EchoMediaItem", Reflection.getOrCreateKotlinClass(EchoMediaItem.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isExplicit(@NotNull EchoMediaItem $this) {
            return $this.isExplicit();
        }

        @Deprecated
        public static boolean isPrivate(@NotNull EchoMediaItem $this) {
            return $this.isPrivate();
        }

        @Deprecated
        @Nullable
        public static String getSubtitleWithE(@NotNull EchoMediaItem $this) {
            return $this.getSubtitleWithE();
        }

        @Deprecated
        public static boolean sameAs(@NotNull EchoMediaItem $this, @NotNull EchoMediaItem other) {
            Intrinsics.checkNotNullParameter((Object)other, (String)"other");
            return $this.sameAs(other);
        }

        @Deprecated
        @NotNull
        public static Shelf.Item toShelf(@NotNull EchoMediaItem $this) {
            return $this.toShelf();
        }

        @Deprecated
        @NotNull
        public static EchoMediaItem copyMediaItem(@NotNull EchoMediaItem $this, @NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            Intrinsics.checkNotNullParameter(extras, (String)"extras");
            return $this.copyMediaItem(id2, title, cover, description, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2);
        }

        public static /* synthetic */ EchoMediaItem copyMediaItem$default(EchoMediaItem echoMediaItem, String string2, String string3, ImageHolder imageHolder, String string4, String string5, Map map2, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
            return EchoMediaItem.copyMediaItem$default(echoMediaItem, string2, string3, imageHolder, string4, string5, map2, bl, bl2, bl3, n, object);
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014\u0082\u0001\u0003\u001c\u001d\u001e\u00a8\u0006\u001f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "artists", "", "Ldev/brahmkshatriya/echo/common/models/Artist;", "getArtists", "()Ljava/util/List;", "trackCount", "", "getTrackCount", "()Ljava/lang/Long;", "duration", "getDuration", "date", "Ldev/brahmkshatriya/echo/common/models/Date;", "getDate", "()Ldev/brahmkshatriya/echo/common/models/Date;", "label", "", "getLabel", "()Ljava/lang/String;", "type", "Ldev/brahmkshatriya/echo/common/models/Album$Type;", "getType", "()Ldev/brahmkshatriya/echo/common/models/Album$Type;", "subtitleWithOutE", "getSubtitleWithOutE", "Companion", "Ldev/brahmkshatriya/echo/common/models/Album;", "Ldev/brahmkshatriya/echo/common/models/Playlist;", "Ldev/brahmkshatriya/echo/common/models/Radio;", "common"})
    @SourceDebugExtension(value={"SMAP\nEchoMediaItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoMediaItem.kt\ndev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,164:1\n1#2:165\n*E\n"})
    public static sealed interface Lists
    extends EchoMediaItem
    permits Album, Playlist, Radio {
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @NotNull
        public List<Artist> getArtists();

        @Nullable
        public Long getTrackCount();

        @Nullable
        default public Long getDuration() {
            return null;
        }

        @Nullable
        default public Date getDate() {
            return null;
        }

        @Nullable
        default public String getLabel() {
            return null;
        }

        @Nullable
        default public Album.Type getType() {
            return null;
        }

        @Override
        @Nullable
        default public String getSubtitleWithOutE() {
            String string2 = this.getSubtitle();
            if (string2 == null) {
                CharSequence charSequence;
                CharSequence charSequence2;
                StringBuilder $this$_get_subtitleWithOutE__u24lambda_u241 = charSequence2 = new StringBuilder();
                boolean bl = false;
                $this$_get_subtitleWithOutE__u24lambda_u241.append(CollectionsKt.joinToString$default((Iterable)this.getArtists(), (CharSequence)", ", null, null, (int)0, null, Lists::_get_subtitleWithOutE_$lambda$1$lambda$0, (int)30, null));
                charSequence2 = ((Object)StringsKt.trim((CharSequence)charSequence2.toString())).toString();
                if (StringsKt.isBlank((CharSequence)charSequence2)) {
                    boolean bl2 = false;
                    charSequence = null;
                } else {
                    charSequence = charSequence2;
                }
                string2 = (String)charSequence;
            }
            return string2;
        }

        private static CharSequence _get_subtitleWithOutE_$lambda$1$lambda$0(Artist it) {
            Intrinsics.checkNotNullParameter((Object)it, (String)"it");
            return it.getName();
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem$Lists;", "common"})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE;

            private Companion() {
            }

            @NotNull
            public final KSerializer<Lists> serializer() {
                Object[] objectArray = new KClass[]{Reflection.getOrCreateKotlinClass(Album.class), Reflection.getOrCreateKotlinClass(Playlist.class), Reflection.getOrCreateKotlinClass(Radio.class)};
                KClass[] kClassArray = objectArray;
                objectArray = new KSerializer[]{Album$.serializer.INSTANCE, Playlist$.serializer.INSTANCE, Radio$.serializer.INSTANCE};
                KClass[] kClassArray2 = objectArray;
                objectArray = new Annotation[]{new /* invalid duplicate definition of identical inner class */};
                return (KSerializer)new SealedClassSerializer("dev.brahmkshatriya.echo.common.models.EchoMediaItem.Lists", Reflection.getOrCreateKotlinClass(Lists.class), kClassArray, (KSerializer[])kClassArray2, (Annotation[])objectArray);
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Deprecated
            @Nullable
            public static Long getDuration(@NotNull Lists $this) {
                return $this.getDuration();
            }

            @Deprecated
            @Nullable
            public static Date getDate(@NotNull Lists $this) {
                return $this.getDate();
            }

            @Deprecated
            @Nullable
            public static String getLabel(@NotNull Lists $this) {
                return $this.getLabel();
            }

            @Deprecated
            @Nullable
            public static Album.Type getType(@NotNull Lists $this) {
                return $this.getType();
            }

            @Deprecated
            @Nullable
            public static String getSubtitleWithOutE(@NotNull Lists $this) {
                return $this.getSubtitleWithOutE();
            }

            @Deprecated
            public static boolean isExplicit(@NotNull Lists $this) {
                return $this.isExplicit();
            }

            @Deprecated
            public static boolean isPrivate(@NotNull Lists $this) {
                return $this.isPrivate();
            }

            @Deprecated
            @Nullable
            public static String getSubtitleWithE(@NotNull Lists $this) {
                return $this.getSubtitleWithE();
            }

            @Deprecated
            public static boolean sameAs(@NotNull Lists $this, @NotNull EchoMediaItem other) {
                Intrinsics.checkNotNullParameter((Object)other, (String)"other");
                return $this.sameAs(other);
            }

            @Deprecated
            @NotNull
            public static Shelf.Item toShelf(@NotNull Lists $this) {
                return $this.toShelf();
            }

            @Deprecated
            @NotNull
            public static EchoMediaItem copyMediaItem(@NotNull Lists $this, @NotNull String id2, @NotNull String title, @Nullable ImageHolder cover, @Nullable String description, @Nullable String subtitle2, @NotNull Map<String, String> extras, boolean isRadioSupported, boolean isFollowable, boolean isSaveable2) {
                Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
                Intrinsics.checkNotNullParameter((Object)title, (String)"title");
                Intrinsics.checkNotNullParameter(extras, (String)"extras");
                return $this.copyMediaItem(id2, title, cover, description, subtitle2, extras, isRadioSupported, isFollowable, isSaveable2);
            }
        }
    }
}

