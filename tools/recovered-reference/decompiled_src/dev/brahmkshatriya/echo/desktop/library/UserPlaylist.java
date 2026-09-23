/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
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
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.library;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack$;
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist$;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JA\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u000eH\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001\u00a2\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006/"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist;", "", "id", "", "title", "description", "createdAt", "", "tracks", "", "Ldev/brahmkshatriya/echo/desktop/library/StoredTrack;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getDescription", "getCreatedAt", "()J", "getTracks", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$desktopApp", "$serializer", "Companion", "desktopApp"})
@StabilityInferred(parameters=0)
public final class UserPlaylist {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String id;
    @NotNull
    private final String title;
    @NotNull
    private final String description;
    private final long createdAt;
    @NotNull
    private final List<StoredTrack> tracks;
    public static final int $stable = 8;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public UserPlaylist(@NotNull String id2, @NotNull String title, @NotNull String description, long createdAt, @NotNull List<StoredTrack> tracks) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        this.id = id2;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.tracks = tracks;
    }

    public /* synthetic */ UserPlaylist(String string2, String string3, String string4, long l, List list2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            String string5 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"toString(...)");
            string2 = string5;
        }
        if ((n & 4) != 0) {
            string4 = "";
        }
        if ((n & 8) != 0) {
            l = System.currentTimeMillis();
        }
        if ((n & 0x10) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        this(string2, string3, string4, l, list2);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    @NotNull
    public final List<StoredTrack> getTracks() {
        return this.tracks;
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
    public final String component3() {
        return this.description;
    }

    public final long component4() {
        return this.createdAt;
    }

    @NotNull
    public final List<StoredTrack> component5() {
        return this.tracks;
    }

    @NotNull
    public final UserPlaylist copy(@NotNull String id2, @NotNull String title, @NotNull String description, long createdAt, @NotNull List<StoredTrack> tracks) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        return new UserPlaylist(id2, title, description, createdAt, tracks);
    }

    public static /* synthetic */ UserPlaylist copy$default(UserPlaylist userPlaylist, String string2, String string3, String string4, long l, List list2, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = userPlaylist.id;
        }
        if ((n & 2) != 0) {
            string3 = userPlaylist.title;
        }
        if ((n & 4) != 0) {
            string4 = userPlaylist.description;
        }
        if ((n & 8) != 0) {
            l = userPlaylist.createdAt;
        }
        if ((n & 0x10) != 0) {
            list2 = userPlaylist.tracks;
        }
        return userPlaylist.copy(string2, string3, string4, l, list2);
    }

    @NotNull
    public String toString() {
        return "UserPlaylist(id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", createdAt=" + this.createdAt + ", tracks=" + this.tracks + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.title.hashCode();
        result2 = result2 * 31 + this.description.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.createdAt);
        result2 = result2 * 31 + ((Object)this.tracks).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPlaylist)) {
            return false;
        }
        UserPlaylist userPlaylist = (UserPlaylist)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)userPlaylist.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.title, (Object)userPlaylist.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)userPlaylist.description)) {
            return false;
        }
        if (this.createdAt != userPlaylist.createdAt) {
            return false;
        }
        return Intrinsics.areEqual(this.tracks, userPlaylist.tracks);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$desktopApp(UserPlaylist self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean bl;
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
            bl = true;
        } else {
            String string2 = self.id;
            String string3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toString(...)");
            bl = !Intrinsics.areEqual((Object)string2, (Object)string3);
        }
        if (bl) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        output.encodeStringElement(serialDesc, 1, self.title);
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : !Intrinsics.areEqual((Object)self.description, (Object)"")) {
            output.encodeStringElement(serialDesc, 2, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.createdAt != System.currentTimeMillis()) {
            output.encodeLongElement(serialDesc, 3, self.createdAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : !Intrinsics.areEqual(self.tracks, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy)lazyArray[4].getValue(), self.tracks);
        }
    }

    public /* synthetic */ UserPlaylist(int seen0, String id2, String title, String description, long createdAt, List tracks, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (2 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)2, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            String string2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
            this.id = string2;
        } else {
            this.id = id2;
        }
        this.title = title;
        this.description = (seen0 & 4) == 0 ? "" : description;
        this.createdAt = (seen0 & 8) == 0 ? System.currentTimeMillis() : createdAt;
        this.tracks = (seen0 & 0x10) == 0 ? CollectionsKt.emptyList() : tracks;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StoredTrack$.serializer.INSTANCE))};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist;", "desktopApp"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<UserPlaylist> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

