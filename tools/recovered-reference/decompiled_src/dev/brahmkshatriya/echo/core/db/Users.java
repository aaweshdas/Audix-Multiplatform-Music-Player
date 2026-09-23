/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u000bH\u00c6\u0003J]\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016\u00a8\u0006&"}, d2={"Ldev/brahmkshatriya/echo/core/db/Users;", "", "id", "", "extension_id", "extension_type", "name", "cover", "subtitle", "extras", "is_current", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getExtension_id", "getExtension_type", "getName", "getCover", "getSubtitle", "getExtras", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "core"})
public final class Users {
    @NotNull
    private final String id;
    @NotNull
    private final String extension_id;
    @NotNull
    private final String extension_type;
    @NotNull
    private final String name;
    @Nullable
    private final String cover;
    @Nullable
    private final String subtitle;
    @NotNull
    private final String extras;
    private final long is_current;

    public Users(@NotNull String id2, @NotNull String extension_id, @NotNull String extension_type, @NotNull String name, @Nullable String cover, @Nullable String subtitle2, @NotNull String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        this.id = id2;
        this.extension_id = extension_id;
        this.extension_type = extension_type;
        this.name = name;
        this.cover = cover;
        this.subtitle = subtitle2;
        this.extras = extras;
        this.is_current = is_current;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getExtension_id() {
        return this.extension_id;
    }

    @NotNull
    public final String getExtension_type() {
        return this.extension_type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getCover() {
        return this.cover;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final String getExtras() {
        return this.extras;
    }

    public final long is_current() {
        return this.is_current;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.extension_id;
    }

    @NotNull
    public final String component3() {
        return this.extension_type;
    }

    @NotNull
    public final String component4() {
        return this.name;
    }

    @Nullable
    public final String component5() {
        return this.cover;
    }

    @Nullable
    public final String component6() {
        return this.subtitle;
    }

    @NotNull
    public final String component7() {
        return this.extras;
    }

    public final long component8() {
        return this.is_current;
    }

    @NotNull
    public final Users copy(@NotNull String id2, @NotNull String extension_id, @NotNull String extension_type, @NotNull String name, @Nullable String cover, @Nullable String subtitle2, @NotNull String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        return new Users(id2, extension_id, extension_type, name, cover, subtitle2, extras, is_current);
    }

    public static /* synthetic */ Users copy$default(Users users, String string2, String string3, String string4, String string5, String string6, String string7, String string8, long l, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = users.id;
        }
        if ((n & 2) != 0) {
            string3 = users.extension_id;
        }
        if ((n & 4) != 0) {
            string4 = users.extension_type;
        }
        if ((n & 8) != 0) {
            string5 = users.name;
        }
        if ((n & 0x10) != 0) {
            string6 = users.cover;
        }
        if ((n & 0x20) != 0) {
            string7 = users.subtitle;
        }
        if ((n & 0x40) != 0) {
            string8 = users.extras;
        }
        if ((n & 0x80) != 0) {
            l = users.is_current;
        }
        return users.copy(string2, string3, string4, string5, string6, string7, string8, l);
    }

    @NotNull
    public String toString() {
        return "Users(id=" + this.id + ", extension_id=" + this.extension_id + ", extension_type=" + this.extension_type + ", name=" + this.name + ", cover=" + this.cover + ", subtitle=" + this.subtitle + ", extras=" + this.extras + ", is_current=" + this.is_current + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.extension_id.hashCode();
        result2 = result2 * 31 + this.extension_type.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + (this.cover == null ? 0 : this.cover.hashCode());
        result2 = result2 * 31 + (this.subtitle == null ? 0 : this.subtitle.hashCode());
        result2 = result2 * 31 + this.extras.hashCode();
        result2 = result2 * 31 + Long.hashCode(this.is_current);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Users)) {
            return false;
        }
        Users users = (Users)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)users.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.extension_id, (Object)users.extension_id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.extension_type, (Object)users.extension_type)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)users.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cover, (Object)users.cover)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.subtitle, (Object)users.subtitle)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.extras, (Object)users.extras)) {
            return false;
        }
        return this.is_current == users.is_current;
    }
}

