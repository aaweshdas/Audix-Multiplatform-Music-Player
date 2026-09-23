/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okio.Path
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "", "dataDir", "Lokio/Path;", "getDataDir", "()Lokio/Path;", "cacheDir", "getCacheDir", "extensionsDir", "getExtensionsDir", "downloadsDir", "getDownloadsDir", "openUrl", "", "url", "", "appVersion", "getAppVersion", "()Ljava/lang/String;", "core"})
public interface AppPlatform {
    @NotNull
    public Path getDataDir();

    @NotNull
    public Path getCacheDir();

    @NotNull
    default public Path getExtensionsDir() {
        return this.getDataDir().resolve("extensions");
    }

    @NotNull
    public Path getDownloadsDir();

    public void openUrl(@NotNull String var1);

    @NotNull
    default public String getAppVersion() {
        return "1.0.0";
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static Path getExtensionsDir(@NotNull AppPlatform $this) {
            return $this.getExtensionsDir();
        }

        @Deprecated
        @NotNull
        public static String getAppVersion(@NotNull AppPlatform $this) {
            return $this.getAppVersion();
        }
    }
}

