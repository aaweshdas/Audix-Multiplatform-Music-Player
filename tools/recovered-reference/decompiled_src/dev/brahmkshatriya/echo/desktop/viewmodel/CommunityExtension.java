/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/CommunityExtension;", "", "id", "", "name", "type", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "description", "author", "iconUrl", "jarName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ExtensionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "getDescription", "getAuthor", "getIconUrl", "getJarName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "desktopApp"})
@StabilityInferred(parameters=1)
public final class CommunityExtension {
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final ExtensionType type;
    @NotNull
    private final String description;
    @NotNull
    private final String author;
    @Nullable
    private final String iconUrl;
    @NotNull
    private final String jarName;
    public static final int $stable;

    public CommunityExtension(@NotNull String id2, @NotNull String name, @NotNull ExtensionType type, @NotNull String description, @NotNull String author, @Nullable String iconUrl, @NotNull String jarName) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter((Object)author, (String)"author");
        Intrinsics.checkNotNullParameter((Object)jarName, (String)"jarName");
        this.id = id2;
        this.name = name;
        this.type = type;
        this.description = description;
        this.author = author;
        this.iconUrl = iconUrl;
        this.jarName = jarName;
    }

    public /* synthetic */ CommunityExtension(String string2, String string3, ExtensionType extensionType, String string4, String string5, String string6, String string7, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x20) != 0) {
            string6 = null;
        }
        this(string2, string3, extensionType, string4, string5, string6, string7);
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ExtensionType getType() {
        return this.type;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getAuthor() {
        return this.author;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getJarName() {
        return this.jarName;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final ExtensionType component3() {
        return this.type;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final String component5() {
        return this.author;
    }

    @Nullable
    public final String component6() {
        return this.iconUrl;
    }

    @NotNull
    public final String component7() {
        return this.jarName;
    }

    @NotNull
    public final CommunityExtension copy(@NotNull String id2, @NotNull String name, @NotNull ExtensionType type, @NotNull String description, @NotNull String author, @Nullable String iconUrl, @NotNull String jarName) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter((Object)author, (String)"author");
        Intrinsics.checkNotNullParameter((Object)jarName, (String)"jarName");
        return new CommunityExtension(id2, name, type, description, author, iconUrl, jarName);
    }

    public static /* synthetic */ CommunityExtension copy$default(CommunityExtension communityExtension, String string2, String string3, ExtensionType extensionType, String string4, String string5, String string6, String string7, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = communityExtension.id;
        }
        if ((n & 2) != 0) {
            string3 = communityExtension.name;
        }
        if ((n & 4) != 0) {
            extensionType = communityExtension.type;
        }
        if ((n & 8) != 0) {
            string4 = communityExtension.description;
        }
        if ((n & 0x10) != 0) {
            string5 = communityExtension.author;
        }
        if ((n & 0x20) != 0) {
            string6 = communityExtension.iconUrl;
        }
        if ((n & 0x40) != 0) {
            string7 = communityExtension.jarName;
        }
        return communityExtension.copy(string2, string3, extensionType, string4, string5, string6, string7);
    }

    @NotNull
    public String toString() {
        return "CommunityExtension(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", description=" + this.description + ", author=" + this.author + ", iconUrl=" + this.iconUrl + ", jarName=" + this.jarName + ")";
    }

    public int hashCode() {
        int result2 = this.id.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + this.type.hashCode();
        result2 = result2 * 31 + this.description.hashCode();
        result2 = result2 * 31 + this.author.hashCode();
        result2 = result2 * 31 + (this.iconUrl == null ? 0 : this.iconUrl.hashCode());
        result2 = result2 * 31 + this.jarName.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommunityExtension)) {
            return false;
        }
        CommunityExtension communityExtension = (CommunityExtension)other;
        if (!Intrinsics.areEqual((Object)this.id, (Object)communityExtension.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)communityExtension.name)) {
            return false;
        }
        if (this.type != communityExtension.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)communityExtension.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.author, (Object)communityExtension.author)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.iconUrl, (Object)communityExtension.iconUrl)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.jarName, (Object)communityExtension.jarName);
    }
}

