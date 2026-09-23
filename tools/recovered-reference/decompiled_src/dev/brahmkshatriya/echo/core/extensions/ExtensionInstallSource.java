/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;", "", "<init>", "()V", "LocalFile", "RemoteUrl", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource$LocalFile;", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource$RemoteUrl;", "core"})
public abstract sealed class ExtensionInstallSource {
    private ExtensionInstallSource() {
    }

    public /* synthetic */ ExtensionInstallSource(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource$LocalFile;", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core"})
    public static final class LocalFile
    extends ExtensionInstallSource {
        @NotNull
        private final String path;

        public LocalFile(@NotNull String path) {
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            super(null);
            this.path = path;
        }

        @NotNull
        public final String getPath() {
            return this.path;
        }

        @NotNull
        public final String component1() {
            return this.path;
        }

        @NotNull
        public final LocalFile copy(@NotNull String path) {
            Intrinsics.checkNotNullParameter((Object)path, (String)"path");
            return new LocalFile(path);
        }

        public static /* synthetic */ LocalFile copy$default(LocalFile localFile, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = localFile.path;
            }
            return localFile.copy(string2);
        }

        @NotNull
        public String toString() {
            return "LocalFile(path=" + this.path + ")";
        }

        public int hashCode() {
            return this.path.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalFile)) {
                return false;
            }
            LocalFile localFile = (LocalFile)other;
            return Intrinsics.areEqual((Object)this.path, (Object)localFile.path);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource$RemoteUrl;", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core"})
    public static final class RemoteUrl
    extends ExtensionInstallSource {
        @NotNull
        private final String url;

        public RemoteUrl(@NotNull String url) {
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            super(null);
            this.url = url;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String component1() {
            return this.url;
        }

        @NotNull
        public final RemoteUrl copy(@NotNull String url) {
            Intrinsics.checkNotNullParameter((Object)url, (String)"url");
            return new RemoteUrl(url);
        }

        public static /* synthetic */ RemoteUrl copy$default(RemoteUrl remoteUrl, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = remoteUrl.url;
            }
            return remoteUrl.copy(string2);
        }

        @NotNull
        public String toString() {
            return "RemoteUrl(url=" + this.url + ")";
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RemoteUrl)) {
                return false;
            }
            RemoteUrl remoteUrl = (RemoteUrl)other;
            return Intrinsics.areEqual((Object)this.url, (Object)remoteUrl.url);
        }
    }
}

