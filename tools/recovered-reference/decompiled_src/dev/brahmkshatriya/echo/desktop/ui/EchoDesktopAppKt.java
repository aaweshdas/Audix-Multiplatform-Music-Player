/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.NavigationRailKt
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.RecomposeScopeImplKt
 *  androidx.compose.runtime.ScopeUpdateScope
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.NavigationRailKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.desktop.ui.ComposableSingletons$EchoDesktopAppKt;
import dev.brahmkshatriya.echo.desktop.ui.Screen;
import dev.brahmkshatriya.echo.desktop.ui.theme.EchoThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007\u00a2\u0006\u0002\u0010\u0002\u001a)\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"EchoDesktopApp", "", "(Landroidx/compose/runtime/Composer;I)V", "EchoNavigationRail", "selectedScreen", "Ldev/brahmkshatriya/echo/desktop/ui/Screen;", "onScreenSelected", "Lkotlin/Function1;", "(Ldev/brahmkshatriya/echo/desktop/ui/Screen;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nEchoDesktopApp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoDesktopApp.kt\ndev/brahmkshatriya/echo/desktop/ui/EchoDesktopAppKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,114:1\n113#2:115\n1869#3:116\n1870#3:123\n1247#4,6:117\n*S KotlinDebug\n*F\n+ 1 EchoDesktopApp.kt\ndev/brahmkshatriya/echo/desktop/ui/EchoDesktopAppKt\n*L\n101#1:115\n104#1:116\n104#1:123\n107#1:117,6\n*E\n"})
public final class EchoDesktopAppKt {
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void EchoDesktopApp(@Nullable Composer $composer, int $changed) {
        block4: {
            $composer = $composer.startRestartGroup(-913991518);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(EchoDesktopApp)56@2444L1449:EchoDesktopApp.kt#6s6986");
            if ($composer.shouldExecute($changed != 0, $changed & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-913991518, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.EchoDesktopApp (EchoDesktopApp.kt:55)");
                }
                EchoThemeKt.EchoTheme(false, ComposableSingletons$EchoDesktopAppKt.INSTANCE.getLambda$-1750845110$desktopApp(), $composer, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block4;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoDesktopAppKt.EchoDesktopApp$lambda$0($changed, arg_0, arg_1));
        }
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void EchoNavigationRail(@NotNull Screen selectedScreen, @NotNull Function1<? super Screen, Unit> onScreenSelected, @Nullable Composer $composer, int $changed) {
        block6: {
            Intrinsics.checkNotNullParameter((Object)((Object)selectedScreen), (String)"selectedScreen");
            Intrinsics.checkNotNullParameter(onScreenSelected, (String)"onScreenSelected");
            $composer = $composer.startRestartGroup(-59803830);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(EchoNavigationRail)P(1)101@4122L11,102@4149L358,99@4009L498:EchoDesktopApp.kt#6s6986");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(((Enum)selectedScreen).ordinal()) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onScreenSelected) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-59803830, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.EchoNavigationRail (EchoDesktopApp.kt:98)");
                }
                int $this$dp$iv = 80;
                boolean $i$f$getDp = false;
                NavigationRailKt.NavigationRail-qi6gXK8((Modifier)SizeKt.width-3ABfNKs((Modifier)SizeKt.fillMaxHeight$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface-0d7_KjU(), (long)0L, null, null, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)1843670242, (boolean)true, (arg_0, arg_1, arg_2) -> EchoDesktopAppKt.EchoNavigationRail$lambda$6(selectedScreen, onScreenSelected, arg_0, arg_1, arg_2), (Composer)$composer, (int)54)), (Composer)$composer, (int)196614, (int)28);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block6;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoDesktopAppKt.EchoNavigationRail$lambda$7(selectedScreen, onScreenSelected, $changed, arg_0, arg_1));
        }
    }

    private static final Unit EchoDesktopApp$lambda$0(int $$changed, Composer $composer, int $force) {
        EchoDesktopAppKt.EchoDesktopApp($composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    private static final Unit EchoNavigationRail$lambda$6$lambda$5$lambda$2$lambda$1(Function1 $onScreenSelected, Screen $screen) {
        $onScreenSelected.invoke((Object)$screen);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit EchoNavigationRail$lambda$6$lambda$5$lambda$3(Screen $screen, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C107@4360L52:EchoDesktopApp.kt#6s6986");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)51251039, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.EchoNavigationRail.<anonymous>.<anonymous>.<anonymous> (EchoDesktopApp.kt:107)");
            }
            IconKt.Icon-ww6aTOc((ImageVector)$screen.getIcon(), (String)$screen.getTitle(), null, (long)0L, (Composer)$composer, (int)0, (int)12);
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
    private static final Unit EchoNavigationRail$lambda$6$lambda$5$lambda$4(Screen $screen, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C108@4442L32:EchoDesktopApp.kt#6s6986");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)580235810, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.EchoNavigationRail.<anonymous>.<anonymous>.<anonymous> (EchoDesktopApp.kt:108)");
            }
            TextKt.Text--4IGK_g((String)$screen.getTitle(), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)1, (int)0, null, null, (Composer)$composer, (int)0, (int)3072, (int)122878);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit EchoNavigationRail$lambda$6(Screen $selectedScreen, Function1 $onScreenSelected, ColumnScope $this$NavigationRail, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$NavigationRail, (String)"$this$NavigationRail");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C*106@4305L28,107@4358L56,108@4440L36,104@4206L285:EchoDesktopApp.kt#6s6986");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1843670242, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.EchoNavigationRail.<anonymous> (EchoDesktopApp.kt:103)");
            }
            Iterable $this$forEach$iv = (Iterable)Screen.getEntries();
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                void $this$cache$iv;
                Screen screen = (Screen)((Object)element$iv);
                boolean bl = false;
                boolean bl2 = $selectedScreen == screen;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1608969069, (String)"CC(remember):EchoDesktopApp.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = $composer.changed((Object)$onScreenSelected) | $composer.changed(((Enum)screen).ordinal());
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl3 = false;
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    boolean bl4 = bl2;
                    boolean bl5 = false;
                    Function0 function0 = () -> EchoDesktopAppKt.EchoNavigationRail$lambda$6$lambda$5$lambda$2$lambda$1($onScreenSelected, screen);
                    bl2 = bl4;
                    Function0 value$iv = function0;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function0 function0 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                NavigationRailKt.NavigationRailItem((boolean)bl2, (Function0)function0, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)51251039, (boolean)true, (arg_0, arg_1) -> EchoDesktopAppKt.EchoNavigationRail$lambda$6$lambda$5$lambda$3(screen, arg_0, arg_1), (Composer)$composer, (int)54)), null, (boolean)false, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)580235810, (boolean)true, (arg_0, arg_1) -> EchoDesktopAppKt.EchoNavigationRail$lambda$6$lambda$5$lambda$4(screen, arg_0, arg_1), (Composer)$composer, (int)54)), (boolean)false, null, null, (Composer)$composer, (int)196992, (int)472);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit EchoNavigationRail$lambda$7(Screen $selectedScreen, Function1 $onScreenSelected, int $$changed, Composer $composer, int $force) {
        EchoDesktopAppKt.EchoNavigationRail($selectedScreen, (Function1<? super Screen, Unit>)$onScreenSelected, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }
}

