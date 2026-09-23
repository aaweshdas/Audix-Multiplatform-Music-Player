/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.RefreshKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.TextKt
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
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
@SourceDebugExtension(value={"SMAP\nAudioEffectsDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioEffectsDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$AudioEffectsDialogKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,407:1\n113#2:408\n113#2:409\n*S KotlinDebug\n*F\n+ 1 AudioEffectsDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$AudioEffectsDialogKt\n*L\n400#1:408\n401#1:409\n*E\n"})
public final class ComposableSingletons$AudioEffectsDialogKt {
    @NotNull
    public static final ComposableSingletons$AudioEffectsDialogKt INSTANCE = new ComposableSingletons$AudioEffectsDialogKt();
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$245515511 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)245515511, (boolean)false, ComposableSingletons$AudioEffectsDialogKt::lambda_245515511$lambda$0);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-1906925061 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1906925061, (boolean)false, ComposableSingletons$AudioEffectsDialogKt::lambda__1906925061$lambda$1);

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$245515511$desktopApp() {
        return lambda$245515511;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-1906925061$desktopApp() {
        return lambda$-1906925061;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_245515511$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C391@19170L12:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)245515511, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$AudioEffectsDialogKt.lambda$245515511.<anonymous> (AudioEffectsDialog.kt:391)");
            }
            TextKt.Text--4IGK_g((String)"Done", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
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
    private static final Unit lambda__1906925061$lambda$1(RowScope $this$OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$OutlinedButton, (String)"$this$OutlinedButton");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C399@19402L87,400@19506L28,401@19551L13:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1906925061, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$AudioEffectsDialogKt.lambda$-1906925061.<anonymous> (AudioEffectsDialog.kt:399)");
            }
            int $this$dp$iv = 16;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)RefreshKt.getRefresh((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)0L, (Composer)$composer, (int)432, (int)8);
            $this$dp$iv = 6;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer, (int)6);
            TextKt.Text--4IGK_g((String)"Reset", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

