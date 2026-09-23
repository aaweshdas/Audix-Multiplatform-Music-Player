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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003Js\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011\u00a8\u0006-"}, d2={"Ldev/brahmkshatriya/echo/core/db/Extensions;", "", "id", "", "type", "name", "version", "description", "author", "icon_url", "enabled", "", "path", "import_type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "getName", "getVersion", "getDescription", "getAuthor", "getIcon_url", "getEnabled", "()J", "getPath", "getImport_type", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "core"})
public final class Extensions {
    @NotNull
    private final String id;
    @NotNull
    private final String type;
    @NotNull
    private final String name;
    @NotNull
    private final String version;
    @Nullable
    private final String description;
    @Nullable
    private final String author;
    @Nullable
    private final String icon_url;
    private final long enabled;
    @NotNull
    private final String path;
    @NotNull
    private final String import_type;

    public Extensions(@NotNull String id2, @NotNull String type, @NotNull String name, @NotNull String version, @Nullable String description, @Nullable String author, @Nullable String icon_url, long enabled, @NotNull String path, @NotNull String import_type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)import_type, (String)"import_type");
        this.id = id2;
        this.type = type;
        this.name = name;
        this.version = version;
        this.description = description;
        this.author = author;
        this.icon_url = icon_url;
        this.enabled = enabled;
        this.path = path;
        this.import_type = import_type;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getAuthor() {
        return this.author;
    }

    @Nullable
    public final String getIcon_url() {
        return this.icon_url;
    }

    public final long getEnabled() {
        return this.enabled;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final String getImport_type() {
        return this.import_type;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.version;
    }

    @Nullable
    public final String component5() {
        return this.description;
    }

    @Nullable
    public final String component6() {
        return this.author;
    }

    @Nullable
    public final String component7() {
        return this.icon_url;
    }

    public final long component8() {
        return this.enabled;
    }

    @NotNull
    public final String component9() {
        return this.path;
    }

    @NotNull
    public final String component10() {
        return this.import_type;
    }

    @NotNull
    public final Extensions copy(@NotNull String id2, @NotNull String type, @NotNull String name, @NotNull String version, @Nullable String description, @Nullable String author, @Nullable String icon_url, long enabled, @NotNull String path, @NotNull String import_type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)import_type, (String)"import_type");
        return new Extensions(id2, type, name, version, description, author, icon_url, enabled, path, import_type);
    }

    public static /* synthetic */ Extensions copy$default(Extensions extensions2, String string2, String string3, String string4, String string5, String string6, String string7, String string8, long l, String string9, String string10, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = extensions2.id;
        }
        if ((n & 2) != 0) {
            string3 = extensions2.type;
        }
        if ((n & 4) != 0) {
            string4 = extensions2.name;
        }
        if ((n & 8) != 0) {
            string5 = extensions2.version;
        }
        if ((n & 0x10) != 0) {
            string6 = extensions2.description;
        }
        if ((n & 0x20) != 0) {
            string7 = extensions2.author;
        }
        if ((n & 0x40) != 0) {
            string8 = extensions2.icon_url;
        }
        if ((n & 0x80) != 0) {
            l = extensions2.enabled;
        }
        if ((n & 0x100) != 0) {
            string9 = extensions2.path;
        }
        if ((n & 0x200) != 0) {
            string10 = extensions2.import_type;
        }
        return extensions2.copy(string2, string3, string4, string5, string6, string7, string8, l, string9, string10);
    }

    @NotNull
    public String toString() {
        return "Extensions(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", version=" + this.version + ", description=" + this.description + ", author=" + this.author + ", icon_url=" + this.icon_url + ", enabled=" + this.enabled + ", path=" + this.path + ", import_type=" + this.import_type + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.type.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + this.version.hashCode();
        result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
        result2 = result2 * 31 + (this.author == null ? 0 : this.author.hashCode());
        result2 = result2 * 31 + (this.icon_url == null ? 0 : this.icon_url.hashCode());
        result2 = result2 * 31 + Long.hashCode(this.enabled);
        result2 = result2 * 31 + this.path.hashCode();
        result2 = result2 * 31 + this.import_type.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Extensions)) {
            return false;
        }
        Extensions extensions2 = (Extensions)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)extensions2.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.type, (Object)extensions2.type)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)extensions2.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.version, (Object)extensions2.version)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)extensions2.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.author, (Object)extensions2.author)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.icon_url, (Object)extensions2.icon_url)) {
            return false;
        }
        if (this.enabled != extensions2.enabled) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.path, (Object)extensions2.path)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.import_type, (Object)extensions2.import_type);
    }
}

