/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.text.TextStyle
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
public final class ComposableSingletons$ShelfRowKt {
    @NotNull
    public static final ComposableSingletons$ShelfRowKt INSTANCE = new ComposableSingletons$ShelfRowKt();
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-871005463 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-871005463, (boolean)false, ComposableSingletons$ShelfRowKt::lambda__871005463$lambda$0);

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-871005463$desktopApp() {
        return lambda$-871005463;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__871005463$lambda$0(RowScope $this$TextButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$TextButton, (String)"$this$TextButton");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C57@2282L10,57@2244L60:ShelfRow.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-871005463, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$ShelfRowKt.lambda$-871005463.<anonymous> (ShelfRow.kt:57)");
            }
            TextKt.Text--4IGK_g((String)"See all", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelLarge(), (Composer)$composer, (int)6, (int)0, (int)65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

