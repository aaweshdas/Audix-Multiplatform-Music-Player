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
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.player;

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
@SourceDebugExtension(value={"SMAP\nMiniPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniPlayer.kt\ndev/brahmkshatriya/echo/desktop/ui/player/ComposableSingletons$MiniPlayerKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,271:1\n113#2:272\n113#2:273\n*S KotlinDebug\n*F\n+ 1 MiniPlayer.kt\ndev/brahmkshatriya/echo/desktop/ui/player/ComposableSingletons$MiniPlayerKt\n*L\n194#1:272\n220#1:273\n*E\n"})
public final class ComposableSingletons$MiniPlayerKt {
    @NotNull
    public static final ComposableSingletons$MiniPlayerKt INSTANCE = new ComposableSingletons$MiniPlayerKt();
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$100345387 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)100345387, (boolean)false, ComposableSingletons$MiniPlayerKt::lambda_100345387$lambda$0);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-17291382 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-17291382, (boolean)false, ComposableSingletons$MiniPlayerKt::lambda__17291382$lambda$1);

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$100345387$desktopApp() {
        return lambda$100345387;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-17291382$desktopApp() {
        return lambda$-17291382;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_100345387$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C193@7257L66:MiniPlayer.kt#2fsrc7");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)100345387, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.ComposableSingletons$MiniPlayerKt.lambda$100345387.<anonymous> (MiniPlayer.kt:193)");
            }
            int $this$dp$iv = 28;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)SkipPreviousKt.getSkipPrevious((Icons.Filled)Icons.INSTANCE.getDefault()), (String)"Previous", (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)0L, (Composer)$composer, (int)432, (int)8);
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
    private static final Unit lambda__17291382$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C219@8184L58:MiniPlayer.kt#2fsrc7");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-17291382, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.ComposableSingletons$MiniPlayerKt.lambda$-17291382.<anonymous> (MiniPlayer.kt:219)");
            }
            int $this$dp$iv = 28;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)SkipNextKt.getSkipNext((Icons.Filled)Icons.INSTANCE.getDefault()), (String)"Next", (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)0L, (Composer)$composer, (int)432, (int)8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

