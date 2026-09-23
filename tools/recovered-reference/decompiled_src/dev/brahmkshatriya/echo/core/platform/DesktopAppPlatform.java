/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  okio.Path
 *  okio.Path$Companion
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import java.awt.Desktop;
import java.net.URI;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DesktopAppPlatform;", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "<init>", "()V", "os", "", "dataDir", "Lokio/Path;", "getDataDir", "()Lokio/Path;", "cacheDir", "getCacheDir", "downloadsDir", "getDownloadsDir", "openUrl", "", "url", "core"})
@SourceDebugExtension(value={"SMAP\nDesktopAppPlatform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopAppPlatform.kt\ndev/brahmkshatriya/echo/core/platform/DesktopAppPlatform\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class DesktopAppPlatform
implements AppPlatform {
    @NotNull
    private final String os;

    public DesktopAppPlatform() {
        String string2 = System.getProperty("os.name", "");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getProperty(...)");
        String string3 = string2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        this.os = string3;
    }

    @Override
    @NotNull
    public Path getDataDir() {
        String string2;
        block6: {
            block4: {
                block5: {
                    if (!StringsKt.contains$default((CharSequence)this.os, (CharSequence)"win", (boolean)false, (int)2, null)) break block4;
                    string2 = System.getenv("APPDATA");
                    if (string2 == null) break block5;
                    String it = string2;
                    boolean bl = false;
                    Path path = Path.Companion.get$default((Path.Companion)Path.Companion, (String)(it + "/Echo"), (boolean)false, (int)1, null);
                    string2 = path;
                    if (path != null) break block6;
                }
                String string3 = System.getProperty("user.home");
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getProperty(...)");
                string2 = Path.Companion.get$default((Path.Companion)Path.Companion, (String)string3, (boolean)false, (int)1, null).resolve("AppData").resolve("Roaming").resolve("Echo");
                break block6;
            }
            if (StringsKt.contains$default((CharSequence)this.os, (CharSequence)"mac", (boolean)false, (int)2, null)) {
                String string4 = System.getProperty("user.home");
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getProperty(...)");
                string2 = Path.Companion.get$default((Path.Companion)Path.Companion, (String)string4, (boolean)false, (int)1, null).resolve("Library").resolve("Application Support").resolve("Echo");
            } else {
                String string5 = System.getProperty("user.home");
                Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"getProperty(...)");
                string2 = Path.Companion.get$default((Path.Companion)Path.Companion, (String)string5, (boolean)false, (int)1, null).resolve(".config").resolve("echo");
            }
        }
        return string2;
    }

    @Override
    @NotNull
    public Path getCacheDir() {
        String string2;
        block6: {
            block4: {
                block5: {
                    if (!StringsKt.contains$default((CharSequence)this.os, (CharSequence)"win", (boolean)false, (int)2, null)) break block4;
                    string2 = System.getenv("LOCALAPPDATA");
                    if (string2 == null) break block5;
                    String it = string2;
                    boolean bl = false;
                    Path path = Path.Companion.get$default((Path.Companion)Path.Companion, (String)(it + "/Echo/cache"), (boolean)false, (int)1, null);
                    string2 = path;
                    if (path != null) break block6;
                }
                string2 = this.getDataDir().resolve("cache");
                break block6;
            }
            if (StringsKt.contains$default((CharSequence)this.os, (CharSequence)"mac", (boolean)false, (int)2, null)) {
                String string3 = System.getProperty("user.home");
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getProperty(...)");
                string2 = Path.Companion.get$default((Path.Companion)Path.Companion, (String)string3, (boolean)false, (int)1, null).resolve("Library").resolve("Caches").resolve("Echo");
            } else {
                String string4 = System.getProperty("user.home");
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getProperty(...)");
                string2 = Path.Companion.get$default((Path.Companion)Path.Companion, (String)string4, (boolean)false, (int)1, null).resolve(".cache").resolve("echo");
            }
        }
        return string2;
    }

    @Override
    @NotNull
    public Path getDownloadsDir() {
        String string2 = System.getProperty("user.home");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getProperty(...)");
        return Path.Companion.get$default((Path.Companion)Path.Companion, (String)string2, (boolean)false, (int)1, null).resolve("Music").resolve("Echo");
    }

    @Override
    public void openUrl(@NotNull String url) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        DesktopAppPlatform desktopAppPlatform = this;
        try {
            DesktopAppPlatform $this$openUrl_u24lambda_u242 = desktopAppPlatform;
            boolean bl = false;
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    @Override
    @NotNull
    public Path getExtensionsDir() {
        return AppPlatform.super.getExtensionsDir();
    }

    @Override
    @NotNull
    public String getAppVersion() {
        return AppPlatform.super.getAppVersion();
    }
}

