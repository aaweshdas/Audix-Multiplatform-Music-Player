/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.window.FrameWindowScope
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.window.FrameWindowScope;
import dev.brahmkshatriya.echo.desktop.ui.EchoDesktopAppKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
public final class ComposableSingletons$MainKt {
    @NotNull
    public static final ComposableSingletons$MainKt INSTANCE = new ComposableSingletons$MainKt();
    @NotNull
    private static Function3<FrameWindowScope, Composer, Integer, Unit> lambda$-1902202792 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1902202792, (boolean)false, ComposableSingletons$MainKt::lambda__1902202792$lambda$0);

    @NotNull
    public final Function3<FrameWindowScope, Composer, Integer, Unit> getLambda$-1902202792$desktopApp() {
        return lambda$-1902202792;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1902202792$lambda$0(FrameWindowScope $this$Window, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Window, (String)"$this$Window");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C150@5212L16:Main.kt#5dnh58");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1902202792, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ComposableSingletons$MainKt.lambda$-1902202792.<anonymous> (Main.kt:150)");
            }
            EchoDesktopAppKt.EchoDesktopApp($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

