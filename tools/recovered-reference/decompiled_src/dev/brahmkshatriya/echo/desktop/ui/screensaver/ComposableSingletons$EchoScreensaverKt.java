/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.SkipNextKt
 *  androidx.compose.material.icons.filled.SkipPreviousKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.graphics.ColorKt
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.screensaver;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SkipNextKt;
import androidx.compose.material.icons.filled.SkipPreviousKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
@SourceDebugExtension(value={"SMAP\nEchoScreensaver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoScreensaver.kt\ndev/brahmkshatriya/echo/desktop/ui/screensaver/ComposableSingletons$EchoScreensaverKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,963:1\n113#2:964\n113#2:965\n*S KotlinDebug\n*F\n+ 1 EchoScreensaver.kt\ndev/brahmkshatriya/echo/desktop/ui/screensaver/ComposableSingletons$EchoScreensaverKt\n*L\n561#1:964\n595#1:965\n*E\n"})
public final class ComposableSingletons$EchoScreensaverKt {
    @NotNull
    public static final ComposableSingletons$EchoScreensaverKt INSTANCE = new ComposableSingletons$EchoScreensaverKt();
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$547366796 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)547366796, (boolean)false, ComposableSingletons$EchoScreensaverKt::lambda_547366796$lambda$0);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-23893707 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-23893707, (boolean)false, ComposableSingletons$EchoScreensaverKt::lambda__23893707$lambda$1);

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$547366796$desktopApp() {
        return lambda$547366796;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-23893707$desktopApp() {
        return lambda$-23893707;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_547366796$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C556@24403L316:EchoScreensaver.kt#rzt5gx");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)547366796, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.ComposableSingletons$EchoScreensaverKt.lambda$547366796.<anonymous> (EchoScreensaver.kt:556)");
            }
            ImageVector imageVector = SkipPreviousKt.getSkipPrevious((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = ColorKt.Color((long)4293247099L);
            int $this$dp$iv = 18;
            boolean $i$f$getDp = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Previous", (Modifier)modifier, (long)l, (Composer)$composer, (int)3504, (int)0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__23893707$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C590@26192L308:EchoScreensaver.kt#rzt5gx");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-23893707, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.ComposableSingletons$EchoScreensaverKt.lambda$-23893707.<anonymous> (EchoScreensaver.kt:590)");
            }
            ImageVector imageVector = SkipNextKt.getSkipNext((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = ColorKt.Color((long)4293247099L);
            int $this$dp$iv = 18;
            boolean $i$f$getDp = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Next", (Modifier)modifier, (long)l, (Composer)$composer, (int)3504, (int)0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

