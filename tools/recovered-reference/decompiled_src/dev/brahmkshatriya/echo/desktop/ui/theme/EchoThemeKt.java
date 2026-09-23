/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.material3.ColorScheme
 *  androidx.compose.material3.ColorSchemeKt
 *  androidx.compose.material3.MaterialThemeKt
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableInferredTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.RecomposeScopeImplKt
 *  androidx.compose.runtime.ScopeUpdateScope
 *  androidx.compose.ui.graphics.ColorKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b\u00a2\u0006\u0002\b\tH\u0007\u00a2\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"EchoDarkColors", "Landroidx/compose/material3/ColorScheme;", "EchoLightColors", "EchoTheme", "", "darkTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "desktopApp"})
public final class EchoThemeKt {
    @NotNull
    private static final ColorScheme EchoDarkColors;
    @NotNull
    private static final ColorScheme EchoLightColors;

    @Composable
    @ComposableInferredTarget(scheme="[0[0]]")
    public static final void EchoTheme(boolean darkTheme, @NotNull Function2<? super Composer, ? super Integer, Unit> content, @Nullable Composer $composer, int $changed, int n) {
        block9: {
            Intrinsics.checkNotNullParameter(content, (String)"content");
            $composer = $composer.startRestartGroup(-438921474);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(EchoTheme)P(1)37@1169L81:EchoTheme.kt#rh5c7l");
            int $dirty = $changed;
            if ((n & 1) != 0) {
                $dirty |= 6;
            } else if (($changed & 6) == 0) {
                $dirty |= $composer.changed(darkTheme) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(content) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                if ((n & 1) != 0) {
                    darkTheme = true;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-438921474, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.theme.EchoTheme (EchoTheme.kt:34)");
                }
                ColorScheme colorScheme = darkTheme ? EchoDarkColors : EchoLightColors;
                MaterialThemeKt.MaterialTheme((ColorScheme)colorScheme, null, null, content, (Composer)$composer, (int)(0x1C00 & $dirty << 6), (int)6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block9;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoThemeKt.EchoTheme$lambda$0(darkTheme, content, $changed, n, arg_0, arg_1));
        }
    }

    private static final Unit EchoTheme$lambda$0(boolean $darkTheme, Function2 $content, int $$changed, int $$default, Composer $composer, int $force) {
        EchoThemeKt.EchoTheme($darkTheme, (Function2<? super Composer, ? super Integer, Unit>)$content, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    static {
        long l = ColorKt.Color((long)4284960932L);
        long l2 = ColorKt.Color((long)0xFFFFFFFFL);
        long l3 = ColorKt.Color((long)4283381643L);
        long l4 = ColorKt.Color((long)4284636017L);
        long l5 = ColorKt.Color((long)4280032031L);
        long l6 = ColorKt.Color((long)4279505432L);
        long l7 = ColorKt.Color((long)4293321189L);
        long l8 = ColorKt.Color((long)4293321189L);
        long l9 = ColorKt.Color((long)4282991951L);
        long l10 = ColorKt.Color((long)4291478736L);
        EchoDarkColors = ColorSchemeKt.darkColorScheme-C-Xl9yA$default((long)l, (long)l2, (long)l3, (long)0L, (long)0L, (long)l4, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)l6, (long)l7, (long)l5, (long)l8, (long)l9, (long)l10, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (int)-516136, (int)15, null);
        l = ColorKt.Color((long)4284960932L);
        l2 = ColorKt.Color((long)0xFFFFFFFFL);
        l3 = ColorKt.Color((long)4293582335L);
        l4 = ColorKt.Color((long)4284636017L);
        l5 = ColorKt.Color((long)0xFFFEF7FFL);
        l6 = ColorKt.Color((long)0xFFFEF7FFL);
        EchoLightColors = ColorSchemeKt.lightColorScheme-C-Xl9yA$default((long)l, (long)l2, (long)l3, (long)0L, (long)0L, (long)l4, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)l6, (long)0L, (long)l5, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (long)0L, (int)-41000, (int)15, null);
    }
}

