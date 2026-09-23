/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BorderStroke
 *  androidx.compose.foundation.BorderStrokeKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.shape.RoundedCornerShape
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.HourglassBottomKt
 *  androidx.compose.material.icons.filled.TimerKt
 *  androidx.compose.material3.AlertDialog_skikoKt
 *  androidx.compose.material3.ButtonColors
 *  androidx.compose.material3.ButtonDefaults
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.OutlinedTextFieldKt
 *  androidx.compose.material3.SurfaceKt
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.MutableState
 *  androidx.compose.runtime.RecomposeScopeImplKt
 *  androidx.compose.runtime.ScopeUpdateScope
 *  androidx.compose.runtime.SnapshotStateKt
 *  androidx.compose.runtime.State
 *  androidx.compose.runtime.Updater
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Horizontal
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.draw.ClipKt
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.ColorKt
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.semantics.Role
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.unit.TextUnitKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.HourglassBottomKt;
import androidx.compose.material.icons.filled.TimerKt;
import androidx.compose.material3.AlertDialog_skikoKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007\u00b2\u0006\f\u0010\b\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002\u00b2\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u0084\u0002\u00b2\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002"}, d2={"SleepTimerDialog", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onDismiss", "Lkotlin/Function0;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "remainingSec", "", "isEndOfSong", "", "customMinutesText", ""})
@SourceDebugExtension(value={"SMAP\nSleepTimerDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepTimerDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/SleepTimerDialogKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 10 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 12 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,312:1\n1247#2,6:313\n1247#2,6:367\n1247#2,6:512\n1247#2,6:528\n1247#2,6:574\n1247#2,6:581\n85#3:319\n85#3:320\n85#3:321\n113#3,2:322\n113#4:324\n113#4:325\n113#4:363\n113#4:364\n113#4:365\n113#4:366\n113#4:377\n113#4:415\n113#4:416\n113#4:427\n113#4:465\n113#4:466\n113#4:467\n113#4:468\n113#4:469\n113#4:471\n113#4:509\n113#4:510\n113#4:511\n113#4:523\n113#4:525\n113#4:526\n113#4:527\n113#4:534\n113#4:535\n113#4:573\n113#4:580\n113#4:588\n87#5:326\n84#5,9:327\n94#5:376\n87#5:428\n84#5,9:429\n94#5:596\n79#6,6:336\n86#6,3:351\n89#6,2:360\n93#6:375\n79#6,6:388\n86#6,3:403\n89#6,2:412\n93#6:419\n79#6,6:438\n86#6,3:453\n89#6,2:462\n79#6,6:481\n86#6,3:496\n89#6,2:505\n93#6:521\n79#6,6:546\n86#6,3:561\n89#6,2:570\n93#6:591\n93#6:595\n347#7,9:342\n356#7:362\n357#7,2:373\n347#7,9:394\n356#7:414\n357#7,2:417\n347#7,9:444\n356#7:464\n347#7,9:487\n356#7:507\n357#7,2:519\n347#7,9:552\n356#7:572\n357#7,2:589\n357#7,2:593\n4206#8,6:354\n4206#8,6:406\n4206#8,6:456\n4206#8,6:499\n4206#8,6:564\n99#9:378\n96#9,9:379\n106#9:420\n99#9:472\n97#9,8:473\n106#9:522\n99#9:536\n96#9,9:537\n106#9:592\n434#10:421\n507#10,5:422\n1869#11:470\n1869#11:508\n1870#11:518\n1870#11:524\n1#12:587\n*S KotlinDebug\n*F\n+ 1 SleepTimerDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/SleepTimerDialogKt\n*L\n56#1:313,6\n142#1:367,6\n190#1:512,6\n229#1:528,6\n279#1:574,6\n287#1:581,6\n54#1:319\n55#1:320\n56#1:321\n56#1:322,2\n305#1:324\n101#1:325\n108#1:363\n110#1:364\n140#1:365\n147#1:366\n196#1:377\n203#1:415\n205#1:416\n87#1:427\n90#1:465\n95#1:466\n97#1:467\n155#1:468\n166#1:469\n180#1:471\n184#1:509\n186#1:510\n189#1:511\n215#1:523\n220#1:525\n223#1:526\n228#1:527\n260#1:534\n271#1:535\n283#1:573\n285#1:580\n295#1:588\n100#1:326\n100#1:327,9\n100#1:376\n84#1:428\n84#1:429,9\n84#1:596\n100#1:336,6\n100#1:351,3\n100#1:360,2\n100#1:375\n195#1:388,6\n195#1:403,3\n195#1:412,2\n195#1:419\n84#1:438,6\n84#1:453,3\n84#1:462,2\n178#1:481,6\n178#1:496,3\n178#1:505,2\n178#1:521\n273#1:546,6\n273#1:561,3\n273#1:570,2\n273#1:591\n84#1:595\n100#1:342,9\n100#1:362\n100#1:373,2\n195#1:394,9\n195#1:414\n195#1:417,2\n84#1:444,9\n84#1:464\n178#1:487,9\n178#1:507\n178#1:519,2\n273#1:552,9\n273#1:572\n273#1:589,2\n84#1:593,2\n100#1:354,6\n195#1:406,6\n84#1:456,6\n178#1:499,6\n273#1:564,6\n195#1:378\n195#1:379,9\n195#1:420\n178#1:472\n178#1:473,8\n178#1:522\n273#1:536\n273#1:537,9\n273#1:592\n279#1:421\n279#1:422,5\n177#1:470\n182#1:508\n182#1:518\n177#1:524\n*E\n"})
public final class SleepTimerDialogKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void SleepTimerDialog(@NotNull PlayerViewModel viewModel2, @NotNull Function0<Unit> onDismiss, @Nullable Composer $composer, int $changed) {
        block8: {
            Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
            Intrinsics.checkNotNullParameter(onDismiss, (String)"onDismiss");
            $composer = $composer.startRestartGroup(-520854657);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(SleepTimerDialog)P(1)53@2327L16,54@2399L16,55@2445L31,301@14307L178,82@3489L10792,57@2482L12009:SleepTimerDialog.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onDismiss) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-520854657, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog (SleepTimerDialog.kt:52)");
                }
                State remainingSec$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getSleepTimerRemainingSec(), null, (Composer)$composer, (int)0, (int)1);
                State isEndOfSong$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.isSleepTimerEndOfSong(), null, (Composer)$composer, (int)0, (int)1);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1969856958, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl2 = false;
                    MutableState value$iv = SnapshotStateKt.mutableStateOf$default((Object)"", null, (int)2, null);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                MutableState mutableState = (MutableState)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableState customMinutesText$delegate = mutableState;
                AlertDialog_skikoKt.AlertDialog-Oix01E0(onDismiss, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)1551860167, (boolean)true, (arg_0, arg_1) -> SleepTimerDialogKt.SleepTimerDialog$lambda$5(onDismiss, arg_0, arg_1), (Composer)$composer, (int)54)), null, null, null, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$1050851787$desktopApp(), (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)1999341516, (boolean)true, (arg_0, arg_1) -> SleepTimerDialogKt.SleepTimerDialog$lambda$27(viewModel2, onDismiss, remainingSec$delegate, isEndOfSong$delegate, customMinutesText$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, (long)0L, (long)0L, (float)0.0f, null, (Composer)$composer, (int)(0x1B0030 | 0xE & $dirty >> 3), (int)0, (int)16284);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block8;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SleepTimerDialogKt.SleepTimerDialog$lambda$28(viewModel2, onDismiss, $changed, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final Long SleepTimerDialog$lambda$0(State<Long> $remainingSec$delegate) {
        void $this$getValue$iv;
        State<Long> state = $remainingSec$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Long)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean SleepTimerDialog$lambda$1(State<Boolean> $isEndOfSong$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isEndOfSong$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final String SleepTimerDialog$lambda$3(MutableState<String> $customMinutesText$delegate) {
        void $this$getValue$iv;
        State state = (State)$customMinutesText$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void SleepTimerDialog$lambda$4(MutableState<String> $customMinutesText$delegate, String string2) {
        void $this$setValue$iv;
        MutableState<String> mutableState = $customMinutesText$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        String value$iv = string2;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SleepTimerDialog$lambda$5(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C302@14321L154:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1551860167, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog.<anonymous> (SleepTimerDialog.kt:302)");
            }
            int $this$dp$iv = 10;
            boolean $i$f$getDp = false;
            ButtonKt.Button((Function0)$onDismiss, null, (boolean)false, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))), null, null, null, null, null, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$649883063$desktopApp(), (Composer)$composer, (int)0x30000000, (int)502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$9$lambda$8$lambda$7$lambda$6(PlayerViewModel $viewModel) {
        $viewModel.cancelSleepTimer();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$9(PlayerViewModel $viewModel, State $isEndOfSong$delegate, State $remainingSec$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C99@4273L3176:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void horizontalAlignment$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-869312136, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog.<anonymous>.<anonymous>.<anonymous> (SleepTimerDialog.kt:99)");
            }
            int $this$dp$iv22 = 16;
            boolean $i$f$getDp = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var12_14 = modifier$iv;
            int n2 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n3 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv);
            boolean bl = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl2 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
            boolean bl3 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n4 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv2 = $composer$iv;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv >> 6;
            void var31_33 = $composer$iv2;
            ColumnScope $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u249_u24lambda_u248 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1382748322, (String)"C106@4675L11,103@4480L309,109@4818L29,139@6625L30,142@6824L202,141@6734L32,140@6684L739:SleepTimerDialog.kt#buhtxq");
            ImageVector imageVector = HourglassBottomKt.getHourglassBottom((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv = 28;
            boolean $i$f$getDp2 = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier, (long)l, (Composer)$composer2, (int)432, (int)0);
            int $this$dp$iv32 = 8;
            boolean $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32)), (Composer)$composer2, (int)6);
            if (SleepTimerDialogKt.SleepTimerDialog$lambda$1((State<Boolean>)$isEndOfSong$delegate)) {
                $composer2.startReplaceGroup(1383088422);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"113@5063L10,114@5180L11,111@4927L306,118@5419L10,119@5499L11,116@5266L295");
                TextStyle $this$dp$iv32 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
                l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                TextKt.Text--4IGK_g((String)"Timer Active: End of Song", null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv32, (Composer)$composer2, (int)6, (int)0, (int)65530);
                $this$dp$iv32 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)"Playback will stop when current track ends", null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv32, (Composer)$composer2, (int)6, (int)0, (int)65530);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1383796121);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"127@5935L10,131@6196L11,125@5796L453,135@6424L10,136@6504L11,133@6282L284");
                Long l2 = SleepTimerDialogKt.SleepTimerDialog$lambda$0((State<Long>)$remainingSec$delegate);
                long rem = l2 != null ? l2 : 0L;
                long mins = rem / (long)60;
                long secs = rem % (long)60;
                String string2 = "%02d:%02d";
                Object[] objectArray = new Object[]{mins, secs};
                String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
                String string4 = string3;
                string2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getHeadlineMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBlack(), null, null, null, null, (long)TextUnitKt.getSp((int)1), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
                long l3 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                TextKt.Text--4IGK_g((String)string4, null, (long)l3, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)string2, (Composer)$composer2, (int)0, (int)0, (int)65530);
                string4 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                long l4 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)"remaining until playback pauses", null, (long)l4, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)string4, (Composer)$composer2, (int)6, (int)0, (int)65530);
                $composer2.endReplaceGroup();
            }
            int $this$dp$iv4 = 12;
            $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer2, (int)6);
            ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4293212469L), (float)0.85f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), Color.Companion.getWhite-0d7_KjU(), 0L, 0L, (Composer)$composer2, 0x36 | ButtonDefaults.$stable << 12, 12);
            int $this$dp$iv5 = 10;
            boolean $i$f$getDp222 = false;
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv5));
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)598863330, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
            void $i$f$getDp222 = $composer2;
            boolean invalid$iv = $composer2.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl6 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl7 = false;
                Function0 value$iv = () -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$9$lambda$8$lambda$7$lambda$6($viewModel);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function0 function02 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ButtonKt.Button((Function0)function02, null, (boolean)false, (Shape)((Shape)roundedCornerShape), (ButtonColors)buttonColors, null, null, null, null, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$-1462102318$desktopApp(), (Composer)$composer2, (int)0x30000000, (int)486);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$16$lambda$15$lambda$14$lambda$11$lambda$10(PlayerViewModel $viewModel, long $mins, Function0 $onDismiss) {
        $viewModel.setSleepTimer($mins);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$16$lambda$15$lambda$14$lambda$13(String $label, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C194@9234L1027:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void verticalAlignment$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-776885027, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SleepTimerDialog.kt:194)");
            }
            int $this$dp$iv = 12;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            $this$dp$iv = 10;
            $i$f$getDp = false;
            Modifier $this$dp$iv2 = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var10_12 = modifier$iv;
            int n2 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n3 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv);
            boolean bl = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl2 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
            boolean bl3 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n4 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv2 = $composer$iv;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv >> 6;
            void var29_31 = $composer$iv2;
            RowScope $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415_u24lambda_u2414_u24lambda_u2413_u24lambda_u2412 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)240367888, (String)"C201@9692L11,198@9497L325,204@9859L28,207@10046L10,208@10168L11,205@9924L303:SleepTimerDialog.kt#buhtxq");
            ImageVector imageVector = TimerKt.getTimer((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv3 = 16;
            boolean $i$f$getDp2 = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier, (long)l, (Composer)$composer2, (int)432, (int)0);
            int $this$dp$iv4 = 8;
            boolean $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer2, (int)6);
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getMedium(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            TextKt.Text--4IGK_g((String)$label, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$18$lambda$17(PlayerViewModel $viewModel, Function0 $onDismiss) {
        $viewModel.setSleepTimerEndOfSong();
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$25$lambda$21$lambda$20(MutableState $customMinutesText$delegate, String it) {
        void $this$filterTo$iv$iv;
        void $this$filter$iv;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string2 = it;
        MutableState mutableState = $customMinutesText$delegate;
        boolean $i$f$filter = false;
        CharSequence charSequence = (CharSequence)$this$filter$iv;
        Appendable destination$iv$iv = new StringBuilder();
        boolean $i$f$filterTo = false;
        int n = $this$filterTo$iv$iv.length();
        for (int index$iv$iv = 0; index$iv$iv < n; ++index$iv$iv) {
            char element$iv$iv;
            char ch = element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
            boolean bl = false;
            if (!Character.isDigit(ch)) continue;
            destination$iv$iv.append(element$iv$iv);
        }
        SleepTimerDialogKt.SleepTimerDialog$lambda$4((MutableState<String>)mutableState, ((StringBuilder)destination$iv$iv).toString());
        return Unit.INSTANCE;
    }

    private static final Unit SleepTimerDialog$lambda$27$lambda$26$lambda$25$lambda$23$lambda$22(PlayerViewModel $viewModel, Function0 $onDismiss, MutableState $customMinutesText$delegate) {
        Long mins = StringsKt.toLongOrNull((String)SleepTimerDialogKt.SleepTimerDialog$lambda$3((MutableState<String>)$customMinutesText$delegate));
        if (mins != null && mins > 0L) {
            $viewModel.setSleepTimer(mins);
            $onDismiss.invoke();
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SleepTimerDialog$lambda$27(PlayerViewModel $viewModel, Function0 $onDismiss, State $remainingSec$delegate, State $isEndOfSong$delegate, MutableState $customMinutesText$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C83@3503L10768:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            boolean bl;
            Object object;
            void $this$cache$iv;
            Object object2;
            String string2;
            void $this$cache$iv2;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void verticalAlignment$iv;
            void $composer$iv;
            Object object3;
            void $this$cache$iv3;
            long l;
            long l2;
            long mins;
            RowScope $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415;
            String $composer$iv2;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv;
            int $i$f$set-impl2;
            int $changed$iv$iv2;
            Function0 modifier$iv$iv2;
            long l3;
            boolean $i$f$getDp;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv2;
            void $changed$iv2;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1999341516, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SleepTimerDialog.<anonymous> (SleepTimerDialog.kt:83)");
            }
            int $this$dp$iv22 = 4;
            boolean $i$f$getDp2 = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-VpY3zN4$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv22), (int)1, null);
            Composer composer = $composer;
            int n = 6;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var14_16 = modifier$iv2;
            int n2 = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv3);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n3 = 6 | 0x380 & $changed$iv$iv3 << 6;
            boolean $i$f$ReusableComposeNode = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv3.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv3);
            boolean bl2 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl3 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv;
            boolean bl4 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n4 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv4 = $composer$iv3;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv2 >> 6;
            void var33_35 = $composer$iv4;
            ColumnScope $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)2128865757, (String)"C88@3701L11,88@3661L86,89@3764L30,159@7650L10,163@7844L11,157@7558L323,165@7898L29,228@11063L130,218@10464L2065,259@12547L30,264@12723L10,268@12917L11,262@12630L324,270@12971L29,272@13018L1239:SleepTimerDialog.kt#buhtxq");
            DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), (float)0.3f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer3, (int)0, (int)3);
            int $this$dp$iv32 = 14;
            boolean $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32)), (Composer)$composer3, (int)6);
            if (SleepTimerDialogKt.SleepTimerDialog$lambda$0((State<Long>)$remainingSec$delegate) != null) {
                $composer3.startReplaceGroup(2128869910);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"95@4018L11,96@4125L11,98@4247L3224,93@3904L3567,154@7492L30");
                int $this$dp$iv = 14;
                $i$f$getDp = false;
                RoundedCornerShape $this$dp$iv32 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv));
                l3 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.12f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                boolean $this$dp$iv4 = true;
                boolean $i$f$getDp4 = false;
                BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)Dp.constructor-impl((float)((float)$this$dp$iv4)), (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.4f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null));
                SurfaceKt.Surface-T9BRK9s((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (Shape)((Shape)$this$dp$iv32), (long)l3, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-869312136, (boolean)true, (arg_0, arg_1) -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$9($viewModel, $isEndOfSong$delegate, $remainingSec$delegate, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)0xC00006, (int)56);
                $this$dp$iv32 = 16;
                $i$f$getDp3 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32)), (Composer)$composer3, (int)6);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(2124904576);
                $composer3.endReplaceGroup();
            }
            TextStyle $this$dp$iv = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            l3 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"QUICK PRESETS", null, (long)l3, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv, (Composer)$composer3, (int)6, (int)0, (int)65530);
            int $this$dp$iv4 = 8;
            $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer3, (int)6);
            Object[] $i$f$getDp22 = new Pair[]{TuplesKt.to((Object)15L, (Object)"15 minutes"), TuplesKt.to((Object)30L, (Object)"30 minutes"), TuplesKt.to((Object)45L, (Object)"45 minutes"), TuplesKt.to((Object)60L, (Object)"1 hour"), TuplesKt.to((Object)120L, (Object)"2 hours")};
            List presets = CollectionsKt.listOf((Object[])$i$f$getDp22);
            $composer3.startReplaceGroup(1315737518);
            ComposerKt.sourceInformation((Composer)$composer3, (String)"*177@8295L2044,214@10360L29");
            Iterable $this$forEach$iv = CollectionsKt.chunked((Iterable)presets, (int)2);
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                void $composer4;
                void $changed$iv$iv$iv3;
                void modifier$iv3;
                void $changed$iv3;
                void horizontalArrangement$iv;
                void $composer$iv5;
                List rowPresets = (List)element$iv;
                boolean bl7 = false;
                Modifier modifier = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                int $this$dp$iv52 = 8;
                boolean $i$f$getDp5 = false;
                Arrangement.Horizontal $this$dp$iv52 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv52));
                void var48_72 = $composer3;
                int n6 = 54;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv5, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
                void var52_78 = modifier$iv3;
                int n7 = 0x70 & $changed$iv3 << 3;
                boolean $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv5, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv5, (Modifier)modifier$iv$iv2);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
                int n8 = 6 | 0x380 & $changed$iv$iv2 << 6;
                boolean $i$f$ReusableComposeNode2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer$iv5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv5.startReusableNode();
                if ($composer$iv5.getInserting()) {
                    void factory$iv$iv$iv;
                    $composer$iv5.createNode((Function0)factory$iv$iv$iv);
                } else {
                    $composer$iv5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv5);
                $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                $i$f$set-impl2 = 0;
                $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv2;
                $i$a$-with-Updater$set$1$iv$iv$iv = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                    $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n9 = 0xE & $changed$iv$iv$iv3 >> 6;
                $composer$iv2 = $composer$iv5;
                boolean $i$a$-Layout-RowKt$Row$1$iv2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n10 = 6 | 0x70 & $changed$iv3 >> 6;
                void var71_114 = $composer$iv2;
                $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-268295298, (String)"C:SleepTimerDialog.kt#buhtxq");
                $composer4.startReplaceGroup(129892986);
                ComposerKt.sourceInformation((Composer)$composer4, (String)"*189@9008L161,193@9200L1091,182@8549L1742");
                Iterable $this$forEach$iv2 = rowPresets;
                boolean $i$f$forEach2 = false;
                for (Object element$iv2 : $this$forEach$iv2) {
                    Object object4;
                    void $this$cache$iv4;
                    Pair pair = (Pair)element$iv2;
                    boolean bl9 = false;
                    mins = ((Number)pair.component1()).longValue();
                    String label = (String)pair.component2();
                    int $this$dp$iv6 = 10;
                    boolean $i$f$getDp6 = false;
                    RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv6));
                    long l4 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    boolean $this$dp$iv7 = true;
                    boolean $i$f$getDp7 = false;
                    BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)Dp.constructor-impl((float)((float)$this$dp$iv7)), (long)Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null));
                    int $this$dp$iv8 = 10;
                    boolean $i$f$getDp322 = false;
                    Modifier modifier2 = ClipKt.clip((Modifier)RowScope.weight$default((RowScope)$this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv8))));
                    boolean bl10 = false;
                    String string3 = null;
                    Role role = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)79910499, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
                    void $i$f$getDp322 = $composer4;
                    boolean invalid$iv = $composer4.changedInstance((Object)$viewModel) | $composer4.changed(mins) | $composer4.changed((Object)$onDismiss);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv4.rememberedValue();
                    boolean bl11 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Role role2 = role;
                        String string4 = string3;
                        boolean bl12 = bl10;
                        Modifier modifier3 = modifier2;
                        boolean bl13 = false;
                        Function0 function03 = () -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$16$lambda$15$lambda$14$lambda$11$lambda$10($viewModel, mins, $onDismiss);
                        modifier2 = modifier3;
                        bl10 = bl12;
                        string3 = string4;
                        role = role2;
                        Function0 value$iv = function03;
                        $this$cache$iv4.updateRememberedValue((Object)value$iv);
                        object4 = value$iv;
                    } else {
                        object4 = it$iv;
                    }
                    Function0 function04 = (Function0)object4;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier2, (boolean)bl10, string3, role, (Function0)function04, (int)7, null), (Shape)((Shape)roundedCornerShape), (long)l4, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-776885027, (boolean)true, (arg_0, arg_1) -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$16$lambda$15$lambda$14$lambda$13(label, arg_0, arg_1), (Composer)$composer4, (int)54)), (Composer)$composer4, (int)14156160, (int)56);
                }
                $composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                $composer$iv5.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                int $this$dp$iv9 = 6;
                boolean $i$f$getDp8 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv9)), (Composer)$composer3, (int)6);
            }
            $composer3.endReplaceGroup();
            int $this$dp$iv10 = 10;
            boolean $i$f$getDp52 = false;
            $this$forEach$iv = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv10));
            if (SleepTimerDialogKt.SleepTimerDialog$lambda$1((State<Boolean>)$isEndOfSong$delegate)) {
                $composer3.startReplaceGroup(1315810772);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"220@10587L11");
                long l5 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.2f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                $composer3.endReplaceGroup();
                l2 = l5;
            } else {
                $composer3.startReplaceGroup(1315811925);
                $composer3.endReplaceGroup();
                l2 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            }
            long l6 = l2;
            int $this$dp$iv11 = 1;
            boolean $i$f$getDp9 = false;
            float f = Dp.constructor-impl((float)$this$dp$iv11);
            if (SleepTimerDialogKt.SleepTimerDialog$lambda$1((State<Boolean>)$isEndOfSong$delegate)) {
                $composer3.startReplaceGroup(1315817332);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"223@10792L11");
                long l7 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.6f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                $composer3.endReplaceGroup();
                l = l7;
            } else {
                $composer3.startReplaceGroup(1315818485);
                $composer3.endReplaceGroup();
                l = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            }
            BorderStroke element$iv = BorderStrokeKt.BorderStroke-cXLIe8U((float)f, (long)l);
            int $this$dp$iv62 = 10;
            boolean $i$f$getDp42 = false;
            Modifier modifier = ClipKt.clip((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv62))));
            boolean bl14 = false;
            String string5 = null;
            Role role = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1315825476, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
            void $i$f$getDp42 = $composer3;
            boolean invalid$iv22 = $composer3.changedInstance((Object)$viewModel) | $composer3.changed((Object)$onDismiss);
            int $i$f$cache = 0;
            Object it$iv = $this$cache$iv3.rememberedValue();
            boolean bl15 = false;
            if (invalid$iv22 || it$iv == Composer.Companion.getEmpty()) {
                Role role3 = role;
                String string6 = string5;
                boolean bl16 = bl14;
                Modifier modifier4 = modifier;
                boolean bl17 = false;
                Function0 function05 = () -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$18$lambda$17($viewModel, $onDismiss);
                modifier = modifier4;
                bl14 = bl16;
                string5 = string6;
                role = role3;
                Function0 value$iv = function05;
                $this$cache$iv3.updateRememberedValue((Object)value$iv);
                object3 = value$iv;
            } else {
                object3 = it$iv;
            }
            Function0 $this$dp$iv62 = (Function0)object3;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier, (boolean)bl14, string5, role, (Function0)$this$dp$iv62, (int)7, null), (Shape)((Shape)$this$forEach$iv), (long)l6, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)element$iv, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$-1376532323$desktopApp(), (Composer)$composer3, (int)0xC00000, (int)56);
            int $this$dp$iv72 = 16;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv72)), (Composer)$composer3, (int)6);
            TextStyle $this$dp$iv72 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            l6 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"CUSTOM MINUTES", null, (long)l6, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv72, (Composer)$composer3, (int)6, (int)0, (int)65530);
            int $this$dp$iv82 = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv82)), (Composer)$composer3, (int)6);
            Modifier $this$dp$iv82 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Alignment.Vertical $i$f$getDp52 = Alignment.Companion.getCenterVertically();
            element$iv = $composer3;
            $this$dp$iv11 = 390;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void invalid$iv22 = modifier$iv;
            $i$f$cache = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            modifier$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv2 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl((Composer)$composer$iv);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)measurePolicy$iv3, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)localMap$iv$iv3, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl18 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv3 = $this$Layout_u24lambda_u240$iv$iv3;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv3.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv3.rememberedValue(), (Object)compositeKeyHash$iv$iv3)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv3.updateRememberedValue((Object)compositeKeyHash$iv$iv3);
                $this$Layout_u24lambda_u240$iv$iv3.apply((Object)compositeKeyHash$iv$iv3, block$iv$iv$iv3);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)materialized$iv$iv3, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $this$Layout_u24lambda_u240$iv$iv2 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv6 = $composer$iv;
            boolean bl19 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $i$f$set-impl2 = 6 | 0x70 & $changed$iv >> 6;
            $this$set_impl_u24lambda_u240$iv$iv$iv = $composer$iv6;
            RowScope $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl20 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)727768544, (String)"C278@13296L56,276@13186L405,284@13612L29,286@13704L295,285@13662L577:SleepTimerDialog.kt#buhtxq");
            $composer$iv2 = SleepTimerDialogKt.SleepTimerDialog$lambda$3((MutableState<String>)$customMinutesText$delegate);
            Modifier $i$a$-Layout-RowKt$Row$1$iv2 = RowScope.weight$default((RowScope)$this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
            int $this$dp$iv92 = 10;
            boolean $i$f$getDp62 = false;
            $this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv92));
            String string7 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1639089058, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
            void $i$f$getDp62 = $composer2;
            boolean invalid$iv = false;
            boolean $i$f$cache2 = false;
            Object it$iv2 = $this$cache$iv2.rememberedValue();
            $i$a$-let-ComposerKt$cache$1$iv = false;
            if (it$iv2 == Composer.Companion.getEmpty()) {
                string2 = string7;
                boolean bl21 = false;
                string7 = string2;
                Function1 value$iv = arg_0 -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$25$lambda$21$lambda$20($customMinutesText$delegate, arg_0);
                $this$cache$iv2.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv2;
            }
            Function1 $this$dp$iv92 = (Function1)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            OutlinedTextFieldKt.OutlinedTextField((String)string7, (Function1)$this$dp$iv92, (Modifier)$i$a$-Layout-RowKt$Row$1$iv2, (boolean)false, (boolean)false, null, null, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$2112781023$desktopApp(), null, null, null, null, null, (boolean)false, null, null, null, (boolean)true, (int)0, (int)0, null, (Shape)((Shape)$this$SleepTimerDialog_u24lambda_u2427_u24lambda_u2426_u24lambda_u2416_u24lambda_u2415), null, (Composer)$composer2, (int)0xC00030, (int)0xC00000, (int)0, (int)6160248);
            int $this$dp$iv1022 = 10;
            boolean $i$f$getDp72 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv1022)), (Composer)$composer2, (int)6);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1639075763, (String)"CC(remember):SleepTimerDialog.kt#9igjgp");
            void $i$f$getDp72 = $composer2;
            boolean invalid$iv3 = $composer2.changedInstance((Object)$viewModel) | $composer2.changed((Object)$onDismiss);
            boolean $i$f$cache3 = false;
            Object it$iv3 = $this$cache$iv.rememberedValue();
            $i$a$-let-ComposerKt$cache$1$iv = false;
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                boolean bl22 = false;
                Function0 value$iv = () -> SleepTimerDialogKt.SleepTimerDialog$lambda$27$lambda$26$lambda$25$lambda$23$lambda$22($viewModel, $onDismiss, $customMinutesText$delegate);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv3;
            }
            Function0 $this$dp$iv1022 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            Object object5 = $this$dp$iv1022;
            Modifier modifier5 = null;
            Long l8 = StringsKt.toLongOrNull((String)SleepTimerDialogKt.SleepTimerDialog$lambda$3((MutableState<String>)$customMinutesText$delegate));
            if (l8 != null) {
                void it;
                mins = ((Number)l8).longValue();
                Modifier modifier6 = modifier5;
                string2 = object5;
                boolean bl23 = false;
                boolean bl24 = it > 0L;
                object5 = string2;
                modifier5 = modifier6;
                bl = bl24;
            } else {
                bl = false;
            }
            int $this$dp$iv12 = 10;
            boolean $i$f$getDp10 = false;
            ButtonKt.Button((Function0)object5, modifier5, (boolean)bl, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv12))), null, null, null, null, null, ComposableSingletons$SleepTimerDialogKt.INSTANCE.getLambda$-1327592170$desktopApp(), (Composer)$composer2, (int)0x30000000, (int)498);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SleepTimerDialog$lambda$28(PlayerViewModel $viewModel, Function0 $onDismiss, int $$changed, Composer $composer, int $force) {
        SleepTimerDialogKt.SleepTimerDialog($viewModel, (Function0<Unit>)$onDismiss, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }
}

