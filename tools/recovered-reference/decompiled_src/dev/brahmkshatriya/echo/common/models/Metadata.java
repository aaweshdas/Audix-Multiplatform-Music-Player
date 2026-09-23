/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Metadata$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u00b5\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u0017\u0010\u001dJ\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0006H\u00c6\u0003J\t\u00105\u001a\u00020\bH\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u00c6\u0003J\t\u0010@\u001a\u00020\u0016H\u00c6\u0003J\u00ad\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u00c6\u0001J\u0013\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010D\u001a\u00020\u001aH\u00d6\u0001J\t\u0010E\u001a\u00020\u0003H\u00d6\u0001J%\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0001\u00a2\u0006\u0002\bMR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u00101\u00a8\u0006P"}, d2={"Ldev/brahmkshatriya/echo/common/models/Metadata;", "", "className", "", "path", "importType", "Ldev/brahmkshatriya/echo/common/models/ImportType;", "type", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "id", "name", "version", "description", "author", "authorUrl", "icon", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "repoUrl", "updateUrl", "preservedPackages", "", "isEnabled", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImportType;Ldev/brahmkshatriya/echo/common/models/ExtensionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImportType;Ldev/brahmkshatriya/echo/common/models/ExtensionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ImageHolder;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClassName", "()Ljava/lang/String;", "getPath", "getImportType", "()Ldev/brahmkshatriya/echo/common/models/ImportType;", "getType", "()Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "getId", "getName", "getVersion", "getDescription", "getAuthor", "getAuthorUrl", "getIcon", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "getRepoUrl", "getUpdateUrl", "getPreservedPackages", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Metadata {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String className;
    @NotNull
    private final String path;
    @NotNull
    private final ImportType importType;
    @NotNull
    private final ExtensionType type;
    @NotNull
    private final String id;
    @NotNull
    private final String name;
    @NotNull
    private final String version;
    @NotNull
    private final String description;
    @NotNull
    private final String author;
    @Nullable
    private final String authorUrl;
    @Nullable
    private final ImageHolder icon;
    @Nullable
    private final String repoUrl;
    @Nullable
    private final String updateUrl;
    @NotNull
    private final List<String> preservedPackages;
    private final boolean isEnabled;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public Metadata(@NotNull String className, @NotNull String path, @NotNull ImportType importType, @NotNull ExtensionType type, @NotNull String id2, @NotNull String name, @NotNull String version, @NotNull String description, @NotNull String author, @Nullable String authorUrl, @Nullable ImageHolder icon, @Nullable String repoUrl, @Nullable String updateUrl, @NotNull List<String> preservedPackages, boolean isEnabled) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)((Object)importType), (String)"importType");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter((Object)author, (String)"author");
        Intrinsics.checkNotNullParameter(preservedPackages, (String)"preservedPackages");
        this.className = className;
        this.path = path;
        this.importType = importType;
        this.type = type;
        this.id = id2;
        this.name = name;
        this.version = version;
        this.description = description;
        this.author = author;
        this.authorUrl = authorUrl;
        this.icon = icon;
        this.repoUrl = repoUrl;
        this.updateUrl = updateUrl;
        this.preservedPackages = preservedPackages;
        this.isEnabled = isEnabled;
    }

    public /* synthetic */ Metadata(String string2, String string3, ImportType importType, ExtensionType extensionType, String string4, String string5, String string6, String string7, String string8, String string9, ImageHolder imageHolder, String string10, String string11, List list2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x200) != 0) {
            string9 = null;
        }
        if ((n & 0x400) != 0) {
            imageHolder = null;
        }
        if ((n & 0x800) != 0) {
            string10 = null;
        }
        if ((n & 0x1000) != 0) {
            string11 = null;
        }
        if ((n & 0x2000) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        if ((n & 0x4000) != 0) {
            bl = true;
        }
        this(string2, string3, importType, extensionType, string4, string5, string6, string7, string8, string9, imageHolder, string10, string11, list2, bl);
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    @NotNull
    public final ImportType getImportType() {
        return this.importType;
    }

    @NotNull
    public final ExtensionType getType() {
        return this.type;
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
    public final String getVersion() {
        return this.version;
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
    public final String getAuthorUrl() {
        return this.authorUrl;
    }

    @Nullable
    public final ImageHolder getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getRepoUrl() {
        return this.repoUrl;
    }

    @Nullable
    public final String getUpdateUrl() {
        return this.updateUrl;
    }

    @NotNull
    public final List<String> getPreservedPackages() {
        return this.preservedPackages;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public final String component1() {
        return this.className;
    }

    @NotNull
    public final String component2() {
        return this.path;
    }

    @NotNull
    public final ImportType component3() {
        return this.importType;
    }

    @NotNull
    public final ExtensionType component4() {
        return this.type;
    }

    @NotNull
    public final String component5() {
        return this.id;
    }

    @NotNull
    public final String component6() {
        return this.name;
    }

    @NotNull
    public final String component7() {
        return this.version;
    }

    @NotNull
    public final String component8() {
        return this.description;
    }

    @NotNull
    public final String component9() {
        return this.author;
    }

    @Nullable
    public final String component10() {
        return this.authorUrl;
    }

    @Nullable
    public final ImageHolder component11() {
        return this.icon;
    }

    @Nullable
    public final String component12() {
        return this.repoUrl;
    }

    @Nullable
    public final String component13() {
        return this.updateUrl;
    }

    @NotNull
    public final List<String> component14() {
        return this.preservedPackages;
    }

    public final boolean component15() {
        return this.isEnabled;
    }

    @NotNull
    public final Metadata copy(@NotNull String className, @NotNull String path, @NotNull ImportType importType, @NotNull ExtensionType type, @NotNull String id2, @NotNull String name, @NotNull String version, @NotNull String description, @NotNull String author, @Nullable String authorUrl, @Nullable ImageHolder icon, @Nullable String repoUrl, @Nullable String updateUrl, @NotNull List<String> preservedPackages, boolean isEnabled) {
        Intrinsics.checkNotNullParameter((Object)className, (String)"className");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)((Object)importType), (String)"importType");
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)description, (String)"description");
        Intrinsics.checkNotNullParameter((Object)author, (String)"author");
        Intrinsics.checkNotNullParameter(preservedPackages, (String)"preservedPackages");
        return new Metadata(className, path, importType, type, id2, name, version, description, author, authorUrl, icon, repoUrl, updateUrl, preservedPackages, isEnabled);
    }

    public static /* synthetic */ Metadata copy$default(Metadata metadata2, String string2, String string3, ImportType importType, ExtensionType extensionType, String string4, String string5, String string6, String string7, String string8, String string9, ImageHolder imageHolder, String string10, String string11, List list2, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = metadata2.className;
        }
        if ((n & 2) != 0) {
            string3 = metadata2.path;
        }
        if ((n & 4) != 0) {
            importType = metadata2.importType;
        }
        if ((n & 8) != 0) {
            extensionType = metadata2.type;
        }
        if ((n & 0x10) != 0) {
            string4 = metadata2.id;
        }
        if ((n & 0x20) != 0) {
            string5 = metadata2.name;
        }
        if ((n & 0x40) != 0) {
            string6 = metadata2.version;
        }
        if ((n & 0x80) != 0) {
            string7 = metadata2.description;
        }
        if ((n & 0x100) != 0) {
            string8 = metadata2.author;
        }
        if ((n & 0x200) != 0) {
            string9 = metadata2.authorUrl;
        }
        if ((n & 0x400) != 0) {
            imageHolder = metadata2.icon;
        }
        if ((n & 0x800) != 0) {
            string10 = metadata2.repoUrl;
        }
        if ((n & 0x1000) != 0) {
            string11 = metadata2.updateUrl;
        }
        if ((n & 0x2000) != 0) {
            list2 = metadata2.preservedPackages;
        }
        if ((n & 0x4000) != 0) {
            bl = metadata2.isEnabled;
        }
        return metadata2.copy(string2, string3, importType, extensionType, string4, string5, string6, string7, string8, string9, imageHolder, string10, string11, list2, bl);
    }

    @NotNull
    public String toString() {
        return "Metadata(className=" + this.className + ", path=" + this.path + ", importType=" + this.importType + ", type=" + this.type + ", id=" + this.id + ", name=" + this.name + ", version=" + this.version + ", description=" + this.description + ", author=" + this.author + ", authorUrl=" + this.authorUrl + ", icon=" + this.icon + ", repoUrl=" + this.repoUrl + ", updateUrl=" + this.updateUrl + ", preservedPackages=" + this.preservedPackages + ", isEnabled=" + this.isEnabled + ")";
    }

    public int hashCode() {
        int result2 = this.className.hashCode();
        result2 = result2 * 31 + this.path.hashCode();
        result2 = result2 * 31 + this.importType.hashCode();
        result2 = result2 * 31 + this.type.hashCode();
        result2 = result2 * 31 + this.id.hashCode();
        result2 = result2 * 31 + this.name.hashCode();
        result2 = result2 * 31 + this.version.hashCode();
        result2 = result2 * 31 + this.description.hashCode();
        result2 = result2 * 31 + this.author.hashCode();
        result2 = result2 * 31 + (this.authorUrl == null ? 0 : this.authorUrl.hashCode());
        result2 = result2 * 31 + (this.icon == null ? 0 : this.icon.hashCode());
        result2 = result2 * 31 + (this.repoUrl == null ? 0 : this.repoUrl.hashCode());
        result2 = result2 * 31 + (this.updateUrl == null ? 0 : this.updateUrl.hashCode());
        result2 = result2 * 31 + ((Object)this.preservedPackages).hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.isEnabled);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata metadata2 = (Metadata)other;
        if (!Intrinsics.areEqual((Object)this.className, (Object)metadata2.className)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.path, (Object)metadata2.path)) {
            return false;
        }
        if (this.importType != metadata2.importType) {
            return false;
        }
        if (this.type != metadata2.type) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.id, (Object)metadata2.id)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.name, (Object)metadata2.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.version, (Object)metadata2.version)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.description, (Object)metadata2.description)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.author, (Object)metadata2.author)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.authorUrl, (Object)metadata2.authorUrl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.icon, (Object)metadata2.icon)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.repoUrl, (Object)metadata2.repoUrl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.updateUrl, (Object)metadata2.updateUrl)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.preservedPackages, metadata2.preservedPackages)) {
            return false;
        }
        return this.isEnabled == metadata2.isEnabled;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Metadata self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.className);
        output.encodeStringElement(serialDesc, 1, self.path);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy)lazyArray[2].getValue(), (Object)self.importType);
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), (Object)self.type);
        output.encodeStringElement(serialDesc, 4, self.id);
        output.encodeStringElement(serialDesc, 5, self.name);
        output.encodeStringElement(serialDesc, 6, self.version);
        output.encodeStringElement(serialDesc, 7, self.description);
        output.encodeStringElement(serialDesc, 8, self.author);
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.authorUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.authorUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy)lazyArray[10].getValue(), (Object)self.icon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.repoUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.repoUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : self.updateUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.updateUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : !Intrinsics.areEqual(self.preservedPackages, (Object)CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 13, (SerializationStrategy)lazyArray[13].getValue(), self.preservedPackages);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : !self.isEnabled) {
            output.encodeBooleanElement(serialDesc, 14, self.isEnabled);
        }
    }

    public /* synthetic */ Metadata(int seen0, String className, String path, ImportType importType, ExtensionType type, String id2, String name, String version, String description, String author, String authorUrl, ImageHolder icon, String repoUrl, String updateUrl, List preservedPackages, boolean isEnabled, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (0x1FF & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)511, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.className = className;
        this.path = path;
        this.importType = importType;
        this.type = type;
        this.id = id2;
        this.name = name;
        this.version = version;
        this.description = description;
        this.author = author;
        this.authorUrl = (seen0 & 0x200) == 0 ? null : authorUrl;
        this.icon = (seen0 & 0x400) == 0 ? null : icon;
        this.repoUrl = (seen0 & 0x800) == 0 ? null : repoUrl;
        this.updateUrl = (seen0 & 0x1000) == 0 ? null : updateUrl;
        this.preservedPackages = (seen0 & 0x2000) == 0 ? CollectionsKt.emptyList() : preservedPackages;
        this.isEnabled = (seen0 & 0x4000) == 0 ? true : isEnabled;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.ImportType", (Enum[])ImportType.values())), LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.common.models.ExtensionType", (Enum[])ExtensionType.values())), null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> ImageHolder.Companion.serializer()), null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE)), null};
        $childSerializers = lazyArray;
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Metadata$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Metadata> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

