/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.DisposableEffectResult
 *  androidx.compose.runtime.DisposableEffectScope
 *  androidx.compose.runtime.EffectsKt
 *  androidx.compose.runtime.MutableState
 *  androidx.compose.runtime.SnapshotStateKt
 *  androidx.compose.runtime.State
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.graphics.painter.Painter
 *  androidx.compose.ui.input.key.KeyShortcut
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.window.ApplicationScope
 *  androidx.compose.ui.window.Application_desktopKt
 *  androidx.compose.ui.window.MenuScope
 *  androidx.compose.ui.window.TrayState
 *  androidx.compose.ui.window.Tray_desktopKt
 *  androidx.compose.ui.window.WindowPlacement
 *  androidx.compose.ui.window.WindowState
 *  androidx.compose.ui.window.WindowState_desktopKt
 *  androidx.compose.ui.window.Window_desktopKt
 *  coil3.ComponentRegistry$Builder
 *  coil3.ImageLoader
 *  coil3.ImageLoader$Builder
 *  coil3.PlatformContext
 *  coil3.SingletonImageLoader
 *  coil3.Uri
 *  coil3.decode.Decoder$Factory
 *  coil3.disk.DiskCache
 *  coil3.disk.DiskCache$Builder
 *  coil3.fetch.Fetcher$Factory
 *  coil3.network.okhttp.OkHttpNetworkFetcher
 *  coil3.request.ImageRequestsKt
 *  coil3.svg.SvgDecoder$Factory
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KFunction
 *  okhttp3.Call$Factory
 *  okhttp3.OkHttpClient
 *  okio.Path
 *  okio.Path$Companion
 *  org.koin.core.Koin
 *  org.koin.core.KoinApplication
 *  org.koin.core.context.DefaultContextExtKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 *  org.koin.java.KoinJavaComponent
 */
package dev.brahmkshatriya.echo.desktop;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.key.KeyShortcut;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.ApplicationScope;
import androidx.compose.ui.window.Application_desktopKt;
import androidx.compose.ui.window.MenuScope;
import androidx.compose.ui.window.TrayState;
import androidx.compose.ui.window.Tray_desktopKt;
import androidx.compose.ui.window.WindowPlacement;
import androidx.compose.ui.window.WindowState;
import androidx.compose.ui.window.WindowState_desktopKt;
import androidx.compose.ui.window.Window_desktopKt;
import coil3.ComponentRegistry;
import coil3.ImageLoader;
import coil3.PlatformContext;
import coil3.SingletonImageLoader;
import coil3.Uri;
import coil3.decode.Decoder;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import coil3.request.ImageRequestsKt;
import coil3.svg.SvgDecoder;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.platform.AudioPlayer;
import dev.brahmkshatriya.echo.desktop.ComposableSingletons$MainKt;
import dev.brahmkshatriya.echo.desktop.EchoTrayPainter;
import dev.brahmkshatriya.echo.desktop.di.DesktopModuleKt;
import dev.brahmkshatriya.echo.desktop.platform.WindowsMediaKeys;
import java.io.File;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KFunction;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okio.Path;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.java.KoinJavaComponent;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u00a8\u0006\u0002\u00b2\u0006\n\u0010\u0003\u001a\u00020\u0004X\u008a\u008e\u0002"}, d2={"main", "", "desktopApp", "isWindowVisible", ""})
@SourceDebugExtension(value={"SMAP\nMain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Main.kt\ndev/brahmkshatriya/echo/desktop/MainKt\n+ 2 Koin.kt\norg/koin/core/Koin\n+ 3 Scope.kt\norg/koin/core/scope/Scope\n+ 4 ImageLoader.kt\ncoil3/ImageLoader$Builder\n+ 5 ComponentRegistry.kt\ncoil3/ComponentRegistry$Builder\n+ 6 Effects.kt\nandroidx/compose/runtime/DisposableEffectScope\n+ 7 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 8 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 9 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,155:1\n124#2,4:156\n124#2,4:161\n124#2,4:166\n142#3:160\n142#3:165\n142#3:170\n124#4:171\n165#5:172\n64#6,5:173\n85#7:178\n113#7,2:179\n1247#8,6:181\n1247#8,6:187\n1247#8,6:193\n1247#8,6:199\n1247#8,6:205\n1247#8,6:211\n1247#8,6:217\n1247#8,6:223\n1247#8,6:231\n113#9:229\n113#9:230\n*S KotlinDebug\n*F\n+ 1 Main.kt\ndev/brahmkshatriya/echo/desktop/MainKt\n*L\n78#1:156,4\n79#1:161,4\n80#1:166,4\n78#1:160\n79#1:165\n80#1:170\n86#1:171\n87#1:172\n109#1:173,5\n115#1:178\n115#1:179,2\n123#1:181,6\n124#1:187,6\n125#1:193,6\n126#1:199,6\n128#1:205,6\n106#1:211,6\n115#1:217,6\n121#1:223,6\n141#1:231,6\n134#1:229\n135#1:230\n*E\n"})
public final class MainKt {
    public static final void main() {
        Object object;
        Koin koin;
        File logFile = new File(System.getProperty("user.home"), "echo_desktop.log");
        MainKt.main$log(logFile, "Echo Desktop initializing...");
        Thread.setDefaultUncaughtExceptionHandler((arg_0, arg_1) -> MainKt.main$lambda$2(logFile, arg_0, arg_1));
        try {
            MainKt.main$log(logFile, "Starting Koin...");
            DefaultContextExtKt.startKoin(MainKt::main$lambda$3);
            MainKt.main$log(logFile, "Koin started successfully");
        }
        catch (Throwable e) {
            MainKt.main$log(logFile, "Koin initialization failed: " + ExceptionsKt.stackTraceToString((Throwable)e));
            throw e;
        }
        Koin $this$iv = koin = KoinJavaComponent.getKoin();
        Qualifier qualifier$iv = null;
        Function0 parameters$iv = null;
        boolean $i$f$get = false;
        Scope this_$iv$iv = $this$iv.getScopeRegistry().getRootScope();
        boolean $i$f$get2 = false;
        AppPlatform platform = (AppPlatform)this_$iv$iv.get(Reflection.getOrCreateKotlinClass(AppPlatform.class), qualifier$iv, parameters$iv);
        Koin $this$iv2 = koin;
        Qualifier qualifier$iv2 = null;
        Function0 parameters$iv2 = null;
        boolean $i$f$get3 = false;
        Scope this_$iv$iv2 = $this$iv2.getScopeRegistry().getRootScope();
        boolean $i$f$get4 = false;
        AudioPlayer audioPlayer = (AudioPlayer)this_$iv$iv2.get(Reflection.getOrCreateKotlinClass(AudioPlayer.class), qualifier$iv2, parameters$iv2);
        Koin $this$iv3 = koin;
        Qualifier qualifier$iv3 = null;
        Function0 parameters$iv3 = null;
        $i$f$get = false;
        Scope this_$iv$iv3 = $this$iv3.getScopeRegistry().getRootScope();
        boolean $i$f$get5 = false;
        WindowsMediaKeys mediaKeys = (WindowsMediaKeys)this_$iv$iv3.get(Reflection.getOrCreateKotlinClass(WindowsMediaKeys.class), qualifier$iv3, parameters$iv3);
        MainKt.main$log(logFile, "Initializing Coil...");
        try {
            boolean bl = false;
            SingletonImageLoader.setSafe(arg_0 -> MainKt.main$lambda$7$lambda$6(platform, arg_0));
            MainKt.main$log(logFile, "Coil initialized");
            object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        Throwable throwable = Result.exceptionOrNull-impl((Object)object);
        if (throwable != null) {
            Throwable throwable2;
            Throwable it = throwable2 = throwable;
            boolean bl = false;
            MainKt.main$log(logFile, "Coil initialization warning: " + ExceptionsKt.stackTraceToString((Throwable)it));
        }
        MainKt.main$log(logFile, "Launching Compose Desktop application...");
        Application_desktopKt.application((boolean)true, (Function3)((Function3)ComposableLambdaKt.composableLambdaInstance((int)-354295162, (boolean)true, (arg_0, arg_1, arg_2) -> MainKt.main$lambda$29(logFile, mediaKeys, audioPlayer, arg_0, arg_1, arg_2))));
    }

    public static /* synthetic */ void main(String[] args) {
        MainKt.main();
    }

    private static final void main$log(File logFile, String message2) {
        try {
            boolean bl = false;
            FilesKt.appendText$default((File)logFile, (String)("[" + LocalDateTime.now() + "] " + message2 + "\n"), null, (int)2, null);
            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    private static final void main$lambda$2(File $logFile, Thread thread, Throwable throwable) {
        String string2 = thread.getName();
        Intrinsics.checkNotNull((Object)throwable);
        MainKt.main$log($logFile, "FATAL uncaught exception in thread " + string2 + ": " + ExceptionsKt.stackTraceToString((Throwable)throwable));
        try {
            boolean bl = false;
            JOptionPane.showMessageDialog(null, "Error: " + throwable.getMessage() + "\n\nCheck log: " + $logFile.getAbsolutePath(), "Echo Music Error", 0);
            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable2) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable2));
        }
    }

    private static final Unit main$lambda$3(KoinApplication $this$startKoin) {
        Intrinsics.checkNotNullParameter((Object)$this$startKoin, (String)"$this$startKoin");
        $this$startKoin.modules(DesktopModuleKt.getDesktopModule());
        return Unit.INSTANCE;
    }

    private static final DiskCache main$lambda$7$lambda$6$lambda$5(AppPlatform $platform) {
        return new DiskCache.Builder().directory(Path.Companion.get$default((Path.Companion)Path.Companion, (File)Path.resolve$default((Path)$platform.getCacheDir(), (String)"images", (boolean)false, (int)2, null).toFile(), (boolean)false, (int)1, null)).maxSizeBytes(0x20000000L).build();
    }

    /*
     * WARNING - void declaration
     */
    private static final ImageLoader main$lambda$7$lambda$6(AppPlatform $platform, PlatformContext it) {
        void this_$iv;
        void $this$main_u24lambda_u247_u24lambda_u246_u24lambda_u244;
        ComponentRegistry.Builder builder;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        ImageLoader.Builder this_$iv2 = new ImageLoader.Builder(it);
        boolean $i$f$components = false;
        ComponentRegistry.Builder builder2 = builder = new ComponentRegistry.Builder();
        ImageLoader.Builder builder3 = this_$iv2;
        boolean bl = false;
        void var7_8 = $this$main_u24lambda_u247_u24lambda_u246_u24lambda_u244;
        Fetcher.Factory factory$iv = (Fetcher.Factory)OkHttpNetworkFetcher.factory((Call.Factory)((Call.Factory)new OkHttpClient()));
        boolean $i$f$add = false;
        this_$iv.add(factory$iv, Reflection.getOrCreateKotlinClass(Uri.class));
        $this$main_u24lambda_u247_u24lambda_u246_u24lambda_u244.add((Decoder.Factory)new SvgDecoder.Factory(false, false, false, 7, null));
        return ImageRequestsKt.crossfade((ImageLoader.Builder)builder3.components(builder.build()).diskCache(() -> MainKt.main$lambda$7$lambda$6$lambda$5($platform)), (boolean)true).build();
    }

    private static final DisposableEffectResult main$lambda$29$lambda$11$lambda$10(WindowsMediaKeys $mediaKeys, File $logFile, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter((Object)$this$DisposableEffect, (String)"$this$DisposableEffect");
        MainKt.main$log($logFile, "Starting WindowsMediaKeys listener...");
        $mediaKeys.start();
        DisposableEffectScope this_$iv = $this$DisposableEffect;
        boolean $i$f$onDispose = false;
        return new DisposableEffectResult($mediaKeys, $logFile){
            final /* synthetic */ WindowsMediaKeys $mediaKeys$inlined;
            final /* synthetic */ File $logFile$inlined;
            {
                this.$mediaKeys$inlined = windowsMediaKeys;
                this.$logFile$inlined = file2;
            }

            public void dispose() {
                boolean bl = false;
                MainKt.access$main$log(this.$logFile$inlined, "Stopping WindowsMediaKeys listener...");
                this.$mediaKeys$inlined.stop();
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean main$lambda$29$lambda$13(MutableState<Boolean> $isWindowVisible$delegate) {
        void $this$getValue$iv;
        State state = (State)$isWindowVisible$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void main$lambda$29$lambda$14(MutableState<Boolean> $isWindowVisible$delegate, boolean bl) {
        void $this$setValue$iv;
        MutableState<Boolean> mutableState = $isWindowVisible$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        Boolean value$iv = bl;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    private static final Unit main$lambda$29$lambda$16$lambda$15(MutableState $isWindowVisible$delegate) {
        MainKt.main$lambda$29$lambda$14((MutableState<Boolean>)$isWindowVisible$delegate, true);
        return Unit.INSTANCE;
    }

    private static final Unit main$lambda$29$lambda$26$lambda$18$lambda$17(MutableState $isWindowVisible$delegate) {
        MainKt.main$lambda$29$lambda$14((MutableState<Boolean>)$isWindowVisible$delegate, true);
        return Unit.INSTANCE;
    }

    private static final Unit main$lambda$29$lambda$26$lambda$20$lambda$19(AudioPlayer $audioPlayer) {
        $audioPlayer.togglePlayPause();
        return Unit.INSTANCE;
    }

    private static final Unit main$lambda$29$lambda$26$lambda$22$lambda$21(AudioPlayer $audioPlayer) {
        $audioPlayer.skipNext();
        return Unit.INSTANCE;
    }

    private static final Unit main$lambda$29$lambda$26$lambda$24$lambda$23(AudioPlayer $audioPlayer) {
        $audioPlayer.skipPrevious();
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit main$lambda$29$lambda$26(AudioPlayer $audioPlayer, ApplicationScope $this_application, MutableState $isWindowVisible$delegate, MenuScope $this$Tray, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Tray, (String)"$this$Tray");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C122@4296L26,122@4268L55,123@4375L33,123@4344L65,124@4453L26,124@4430L50,125@4528L30,125@4501L58,126@4580L11,127@4635L17,127@4612L41:Main.kt#5dnh58");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= (($changed & 8) == 0 ? $composer.changed((Object)$this$Tray) : $composer.changedInstance((Object)$this$Tray)) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            Function0 value$iv;
            Function0 function0;
            MenuScope menuScope;
            String string2;
            Painter painter;
            boolean bl;
            Character c;
            KeyShortcut keyShortcut;
            Composer $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1842802575, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.main.<anonymous>.<anonymous> (Main.kt:122)");
            }
            MenuScope menuScope2 = $this$Tray;
            String string3 = "Show Echo";
            Painter painter2 = null;
            boolean bl2 = false;
            Character c2 = null;
            KeyShortcut keyShortcut2 = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1406750249, (String)"CC(remember):Main.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = false;
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl3 = false;
            if (it$iv == Composer.Companion.getEmpty()) {
                keyShortcut = keyShortcut2;
                c = c2;
                bl = bl2;
                painter = painter2;
                string2 = string3;
                menuScope = menuScope2;
                boolean bl4 = false;
                function0 = () -> MainKt.main$lambda$29$lambda$26$lambda$18$lambda$17($isWindowVisible$delegate);
                menuScope2 = menuScope;
                string3 = string2;
                painter2 = painter;
                bl2 = bl;
                c2 = c;
                keyShortcut2 = keyShortcut;
                value$iv = function0;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object5 = value$iv;
            } else {
                object5 = it$iv;
            }
            Function0 function02 = (Function0)object5;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            menuScope2.Item(string3, painter2, bl2, c2, keyShortcut2, function02, $composer, 0x30006 | MenuScope.$stable << 18 | 0x380000 & $dirty << 18, 30);
            MenuScope menuScope3 = $this$Tray;
            String string4 = "Play / Pause";
            Painter painter3 = null;
            boolean bl5 = false;
            Character c3 = null;
            KeyShortcut keyShortcut3 = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1406752784, (String)"CC(remember):Main.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = $composer.changedInstance((Object)$audioPlayer);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl3 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                keyShortcut = keyShortcut3;
                c = c3;
                bl = bl5;
                painter = painter3;
                string2 = string4;
                menuScope = menuScope3;
                boolean bl6 = false;
                function0 = () -> MainKt.main$lambda$29$lambda$26$lambda$20$lambda$19($audioPlayer);
                menuScope3 = menuScope;
                string4 = string2;
                painter3 = painter;
                bl5 = bl;
                c3 = c;
                keyShortcut3 = keyShortcut;
                value$iv = function0;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object4 = value$iv;
            } else {
                object4 = it$iv;
            }
            function02 = (Function0)object4;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            menuScope3.Item(string4, painter3, bl5, c3, keyShortcut3, function02, $composer, 6 | MenuScope.$stable << 18 | 0x380000 & $dirty << 18, 30);
            MenuScope menuScope4 = $this$Tray;
            String string5 = "Next";
            Painter painter4 = null;
            boolean bl7 = false;
            Character c4 = null;
            KeyShortcut keyShortcut4 = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1406755273, (String)"CC(remember):Main.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = $composer.changedInstance((Object)$audioPlayer);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl3 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                keyShortcut = keyShortcut4;
                c = c4;
                bl = bl7;
                painter = painter4;
                string2 = string5;
                menuScope = menuScope4;
                boolean bl8 = false;
                function0 = () -> MainKt.main$lambda$29$lambda$26$lambda$22$lambda$21($audioPlayer);
                menuScope4 = menuScope;
                string5 = string2;
                painter4 = painter;
                bl7 = bl;
                c4 = c;
                keyShortcut4 = keyShortcut;
                value$iv = function0;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object3 = value$iv;
            } else {
                object3 = it$iv;
            }
            function02 = (Function0)object3;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            menuScope4.Item(string5, painter4, bl7, c4, keyShortcut4, function02, $composer, 6 | MenuScope.$stable << 18 | 0x380000 & $dirty << 18, 30);
            MenuScope menuScope5 = $this$Tray;
            String string6 = "Previous";
            Painter painter5 = null;
            boolean bl9 = false;
            Character c5 = null;
            KeyShortcut keyShortcut5 = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1406757677, (String)"CC(remember):Main.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = $composer.changedInstance((Object)$audioPlayer);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl3 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                keyShortcut = keyShortcut5;
                c = c5;
                bl = bl9;
                painter = painter5;
                string2 = string6;
                menuScope = menuScope5;
                boolean bl10 = false;
                function0 = () -> MainKt.main$lambda$29$lambda$26$lambda$24$lambda$23($audioPlayer);
                menuScope5 = menuScope;
                string6 = string2;
                painter5 = painter;
                bl9 = bl;
                c5 = c;
                keyShortcut5 = keyShortcut;
                value$iv = function0;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv;
            }
            function02 = (Function0)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            menuScope5.Item(string6, painter5, bl9, c5, keyShortcut5, function02, $composer, 6 | MenuScope.$stable << 18 | 0x380000 & $dirty << 18, 30);
            $this$Tray.Separator($composer, MenuScope.$stable | 0xE & $dirty);
            MenuScope menuScope6 = $this$Tray;
            String string7 = "Exit";
            Painter painter6 = null;
            boolean bl11 = false;
            Character c6 = null;
            KeyShortcut keyShortcut6 = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1406761088, (String)"CC(remember):Main.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = $composer.changed((Object)$this_application);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl3 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                keyShortcut = keyShortcut6;
                c = c6;
                bl = bl11;
                painter = painter6;
                string2 = string7;
                menuScope = menuScope6;
                boolean bl12 = false;
                function0 = (KFunction)new Function0<Unit>((Object)$this_application){

                    public final void invoke() {
                        ((ApplicationScope)this.receiver).exitApplication();
                    }
                };
                menuScope6 = menuScope;
                string7 = string2;
                painter6 = painter;
                bl11 = bl;
                c6 = c;
                keyShortcut6 = keyShortcut;
                value$iv = function0;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            function02 = (KFunction)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            menuScope6.Item(string7, painter6, bl11, c6, keyShortcut6, function02, $composer, 6 | MenuScope.$stable << 18 | 0x380000 & $dirty << 18, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit main$lambda$29$lambda$28$lambda$27(ApplicationScope $this_application, MutableState $isWindowVisible$delegate) {
        if (Tray_desktopKt.isTraySupported()) {
            MainKt.main$lambda$29$lambda$14((MutableState<Boolean>)$isWindowVisible$delegate, false);
        } else {
            $this_application.exitApplication();
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit main$lambda$29(File $logFile, WindowsMediaKeys $mediaKeys, AudioPlayer $audioPlayer, ApplicationScope $this$application, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$application, (String)"$this$application");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C105@3741L230,105@3718L253,114@4004L33,132@4723L137,140@4946L179,138@4870L368:Main.kt#5dnh58");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed((Object)$this$application) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
            Object object;
            void $this$cache$iv;
            Object object2;
            Composer $this$cache$iv2;
            Object object3;
            Function1 value$iv;
            Unit unit;
            MutableState $this$cache$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-354295162, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.main.<anonymous> (Main.kt:105)");
            }
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1175233012, (String)"CC(remember):Main.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv22 = $composer.changedInstance((Object)$logFile) | $composer.changedInstance((Object)$mediaKeys);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv3.rememberedValue();
            boolean bl = false;
            if (invalid$iv22 || it$iv == Composer.Companion.getEmpty()) {
                unit = unit2;
                boolean bl2 = false;
                unit2 = unit;
                value$iv = arg_0 -> MainKt.main$lambda$29$lambda$11$lambda$10($mediaKeys, $logFile, arg_0);
                $this$cache$iv3.updateRememberedValue((Object)value$iv);
                object3 = value$iv;
            } else {
                object3 = it$iv;
            }
            Function1 function1 = (Function1)object3;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            EffectsKt.DisposableEffect((Object)unit2, (Function1)function1, (Composer)$composer, (int)6);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1175224793, (String)"CC(remember):Main.kt#9igjgp");
            Composer invalid$iv22 = $composer;
            boolean invalid$iv = false;
            boolean $i$f$cache2 = false;
            Object it$iv2 = $this$cache$iv2.rememberedValue();
            $i$a$-let-ComposerKt$cache$1$iv = false;
            if (it$iv2 == Composer.Companion.getEmpty()) {
                boolean bl3 = false;
                value$iv = SnapshotStateKt.mutableStateOf$default((Object)true, null, (int)2, null);
                $this$cache$iv2.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv2;
            }
            $this$cache$iv3 = (MutableState)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            MutableState isWindowVisible$delegate = $this$cache$iv3;
            if (Tray_desktopKt.isTraySupported()) {
                Object object4;
                $composer.startReplaceGroup(-2072148311);
                ComposerKt.sourceInformation((Composer)$composer, (String)"120@4195L26,121@4246L425,117@4082L603");
                ApplicationScope applicationScope = $this$application;
                Painter painter = EchoTrayPainter.INSTANCE;
                TrayState trayState = null;
                String string2 = "Echo Music";
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1175218688, (String)"CC(remember):Main.kt#9igjgp");
                $this$cache$iv2 = $composer;
                invalid$iv = false;
                $i$f$cache2 = false;
                it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    String string3 = string2;
                    TrayState trayState2 = trayState;
                    Painter painter2 = painter;
                    unit = applicationScope;
                    boolean bl4 = false;
                    Function0 function0 = () -> MainKt.main$lambda$29$lambda$16$lambda$15(isWindowVisible$delegate);
                    applicationScope = unit;
                    painter = painter2;
                    trayState = trayState2;
                    string2 = string3;
                    Function0 value$iv2 = function0;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object4 = value$iv2;
                } else {
                    object4 = it$iv2;
                }
                $this$cache$iv3 = (Function0)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                Tray_desktopKt.Tray((ApplicationScope)applicationScope, (Painter)painter, trayState, (String)string2, (Function0)$this$cache$iv3, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)1842802575, (boolean)true, (arg_0, arg_1, arg_2) -> MainKt.main$lambda$29$lambda$26($audioPlayer, $this$application, isWindowVisible$delegate, arg_0, arg_1, arg_2), (Composer)$composer, (int)54)), (Composer)$composer, (int)(0x36C00 | 0xE & $dirty), (int)2);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-2076204196);
                $composer.endReplaceGroup();
            }
            int $this$dp$iv = 1280;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            int $this$dp$iv22 = 800;
            boolean $i$f$getDp2 = false;
            float f2 = Dp.constructor-impl((float)$this$dp$iv22);
            WindowState windowState = WindowState_desktopKt.rememberWindowState-6PoWaU8((WindowPlacement)WindowPlacement.Floating, (boolean)false, null, (float)f, (float)f2, (Composer)$composer, (int)27654, (int)6);
            boolean bl5 = MainKt.main$lambda$29$lambda$13((MutableState<Boolean>)isWindowVisible$delegate);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1175194503, (String)"CC(remember):Main.kt#9igjgp");
            Composer $this$dp$iv22 = $composer;
            boolean invalid$iv3 = ($dirty & 0xE) == 4;
            boolean $i$f$cache3 = false;
            Object it$iv3 = $this$cache$iv.rememberedValue();
            $i$a$-let-ComposerKt$cache$1$iv = false;
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                boolean bl6 = false;
                Function0 value$iv3 = () -> MainKt.main$lambda$29$lambda$28$lambda$27($this$application, isWindowVisible$delegate);
                $this$cache$iv.updateRememberedValue((Object)value$iv3);
                object = value$iv3;
            } else {
                object = it$iv3;
            }
            Function0 function0 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            Window_desktopKt.Window((Function0)function0, (WindowState)windowState, (boolean)bl5, (String)"Echo", null, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, (boolean)false, null, null, ComposableSingletons$MainKt.INSTANCE.getLambda$-1902202792$desktopApp(), (Composer)$composer, (int)3072, (int)3072, (int)8176);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$main$log(File logFile, String message2) {
        MainKt.main$log(logFile, message2);
    }
}

