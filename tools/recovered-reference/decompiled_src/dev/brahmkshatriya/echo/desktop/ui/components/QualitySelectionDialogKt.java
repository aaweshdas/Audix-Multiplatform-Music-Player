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
 *  androidx.compose.material3.AlertDialog_skikoKt
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.SurfaceKt
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
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
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.semantics.Role
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.unit.TextUnitKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
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
import androidx.compose.material3.AlertDialog_skikoKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$QualitySelectionDialogKt;
import dev.brahmkshatriya.echo.desktop.ui.components.QualityOption;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\u001a#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007\u00a2\u0006\u0002\u0010\t\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n\u00b2\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u0084\u0002"}, d2={"QUALITY_OPTIONS", "", "Ldev/brahmkshatriya/echo/desktop/ui/components/QualityOption;", "QualitySelectionDialog", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onDismiss", "Lkotlin/Function0;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "currentQuality", ""})
@SourceDebugExtension(value={"SMAP\nQualitySelectionDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualitySelectionDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/QualitySelectionDialogKt\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 9 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 10 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,195:1\n85#2:196\n113#3:197\n113#3:198\n113#3:199\n113#3:274\n113#3:313\n113#3:318\n113#3:323\n113#3:324\n113#3:329\n113#3:330\n113#3:367\n113#3:369\n113#3:370\n113#3:371\n99#4:200\n96#4,9:201\n99#4:275\n95#4,10:276\n106#4:317\n106#4:328\n79#5,6:210\n86#5,3:225\n89#5,2:234\n79#5,6:247\n86#5,3:262\n89#5,2:271\n79#5,6:286\n86#5,3:301\n89#5,2:310\n93#5:316\n93#5:321\n93#5:327\n79#5,6:340\n86#5,3:355\n89#5,2:364\n93#5:381\n347#6,9:216\n356#6:236\n347#6,9:253\n356#6:273\n347#6,9:292\n356#6:312\n357#6,2:314\n357#6,2:319\n357#6,2:325\n347#6,9:346\n356#6:366\n357#6,2:379\n4206#7,6:228\n4206#7,6:265\n4206#7,6:304\n4206#7,6:358\n87#8:237\n84#8,9:238\n94#8:322\n87#8:331\n85#8,8:332\n94#8:382\n1869#9:368\n1870#9:378\n1247#10,6:372\n*S KotlinDebug\n*F\n+ 1 QualitySelectionDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/QualitySelectionDialogKt\n*L\n75#1:196\n188#1:197\n154#1:198\n130#1:199\n136#1:274\n144#1:313\n158#1:318\n166#1:323\n170#1:324\n106#1:329\n107#1:330\n110#1:367\n115#1:369\n118#1:370\n123#1:371\n129#1:200\n129#1:201,9\n134#1:275\n134#1:276,10\n134#1:317\n129#1:328\n129#1:210,6\n129#1:225,3\n129#1:234,2\n133#1:247,6\n133#1:262,3\n133#1:271,2\n134#1:286,6\n134#1:301,3\n134#1:310,2\n134#1:316\n133#1:321\n129#1:327\n103#1:340,6\n103#1:355,3\n103#1:364,2\n103#1:381\n129#1:216,9\n129#1:236\n133#1:253,9\n133#1:273\n134#1:292,9\n134#1:312\n134#1:314,2\n133#1:319,2\n129#1:325,2\n103#1:346,9\n103#1:366\n103#1:379,2\n129#1:228,6\n133#1:265,6\n134#1:304,6\n103#1:358,6\n133#1:237\n133#1:238,9\n133#1:322\n103#1:331\n103#1:332,8\n103#1:382\n112#1:368\n112#1:378\n124#1:372,6\n*E\n"})
public final class QualitySelectionDialogKt {
    @NotNull
    private static final List<QualityOption> QUALITY_OPTIONS;

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void QualitySelectionDialog(@NotNull PlayerViewModel viewModel2, @NotNull Function0<Unit> onDismiss, @Nullable Composer $composer, int $changed) {
        block6: {
            Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
            Intrinsics.checkNotNullParameter(onDismiss, (String)"onDismiss");
            $composer = $composer.startRestartGroup(-2050990049);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(QualitySelectionDialog)P(1)74@2705L16,184@8400L177,101@3749L4625,76@2727L5856:QualitySelectionDialog.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onDismiss) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-2050990049, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.QualitySelectionDialog (QualitySelectionDialog.kt:73)");
                }
                State currentQuality$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getStreamQuality(), null, (Composer)$composer, (int)0, (int)1);
                AlertDialog_skikoKt.AlertDialog-Oix01E0(onDismiss, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)2020102759, (boolean)true, (arg_0, arg_1) -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$1(onDismiss, arg_0, arg_1), (Composer)$composer, (int)54)), null, null, null, ComposableSingletons$QualitySelectionDialogKt.INSTANCE.getLambda$-1585208213$desktopApp(), (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-1412794132, (boolean)true, (arg_0, arg_1) -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$11(viewModel2, onDismiss, currentQuality$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, (long)0L, (long)0L, (float)0.0f, null, (Composer)$composer, (int)(0x1B0030 | 0xE & $dirty >> 3), (int)0, (int)16284);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block6;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$12(viewModel2, onDismiss, $changed, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final String QualitySelectionDialog$lambda$0(State<String> $currentQuality$delegate) {
        void $this$getValue$iv;
        State<String> state = $currentQuality$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit QualitySelectionDialog$lambda$1(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C185@8414L153:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)2020102759, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.QualitySelectionDialog.<anonymous> (QualitySelectionDialog.kt:185)");
            }
            int $this$dp$iv = 10;
            boolean $i$f$getDp = false;
            ButtonKt.Button((Function0)$onDismiss, null, (boolean)false, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))), null, null, null, null, null, ComposableSingletons$QualitySelectionDialogKt.INSTANCE.getLambda$-1435314601$desktopApp(), (Composer)$composer, (int)0x30000000, (int)502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$3$lambda$2(PlayerViewModel $viewModel, QualityOption $opt, Function0 $onDismiss) {
        $viewModel.setStreamQuality($opt.getId());
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(QualityOption $opt, boolean $isSelected, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C148@6476L10,146@6342L656:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)672512001, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.QualitySelectionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QualitySelectionDialog.kt:146)");
            }
            String string2 = $opt.getBadge();
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)TextUnitKt.getSp((int)9), (FontWeight)FontWeight.Companion.getExtraBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFF9, null);
            if ($isSelected) {
                $composer.startReplaceGroup(2038954312);
                ComposerKt.sourceInformation((Composer)$composer, (String)"152@6780L11");
                var8_6 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = var8_6;
            } else {
                $composer.startReplaceGroup(2038955569);
                ComposerKt.sourceInformation((Composer)$composer, (String)"152@6819L11");
                var8_6 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                $composer.endReplaceGroup();
                l = var8_6;
            }
            long l2 = l;
            int $this$dp$iv = 5;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            $this$dp$iv = 2;
            $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
            TextKt.Text--4IGK_g((String)string2, (Modifier)modifier, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)48, (int)0, (int)65528);
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
    private static final Unit QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$8(boolean $isSelected, QualityOption $opt, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C128@5107L3203:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            long l2;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void verticalAlignment$iv;
            void horizontalArrangement$iv;
            void $composer$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv;
            void $composer$iv2;
            void $composer4;
            void $changed$iv$iv$iv3;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv2;
            void $changed$iv2;
            void verticalAlignment$iv2;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)2039559354, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.QualitySelectionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QualitySelectionDialog.kt:128)");
            }
            int $this$dp$iv22 = 14;
            boolean $i$f$getDp = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var11_13 = modifier$iv2;
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
            int n4 = 0xE & $changed$iv$iv$iv3 >> 6;
            void $composer$iv4 = $composer$iv3;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv2 >> 6;
            void var30_32 = $composer$iv4;
            RowScope $this$QualitySelectionDialog_u24lambda_u2411_u24lambda_u2410_u24lambda_u249_u24lambda_u248_u24lambda_u247 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)959231020, (String)"C132@5307L2176:QualitySelectionDialog.kt#buhtxq");
            Modifier modifier = RowScope.weight$default((RowScope)$this$QualitySelectionDialog_u24lambda_u2411_u24lambda_u2410_u24lambda_u249_u24lambda_u248_u24lambda_u247, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
            void var34_38 = $composer4;
            int $changed$iv3 = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
            void var40_45 = modifier$iv;
            int n6 = 0x70 & $changed$iv3 << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n7 = 6 | 0x380 & $changed$iv$iv2 << 6;
            boolean $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv2.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n8 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv5 = $composer$iv2;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n9 = 6 | 0x70 & $changed$iv3 >> 6;
            void var59_64 = $composer$iv5;
            ColumnScope $this$QualitySelectionDialog_u24lambda_u2411_u24lambda_u2410_u24lambda_u249_u24lambda_u248_u24lambda_u247_u24lambda_u246 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)150290986, (String)"C133@5380L1690,157@7103L29,160@7286L10,161@7391L11,158@7165L288:QualitySelectionDialog.kt#buhtxq");
            Alignment.Vertical vertical2 = Alignment.Companion.getCenterVertically();
            int $this$dp$iv = 8;
            boolean $i$f$getDp22 = false;
            Arrangement.Horizontal $i$f$getDp22 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical vertical3 = vertical2;
            void var66_75 = $composer3;
            int n10 = 432;
            boolean $i$f$Row2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv3 = (Modifier)Modifier.Companion;
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            Modifier modifier2 = modifier$iv3;
            int n11 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function03 = ComposeUiNode.Companion.getConstructor();
            int n12 = 6 | 0x380 & $changed$iv$iv << 6;
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
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv3 = $this$Layout_u24lambda_u240$iv$iv3;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv3.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv3.rememberedValue(), (Object)compositeKeyHash$iv$iv3)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv3.updateRememberedValue((Object)compositeKeyHash$iv$iv3);
                $this$Layout_u24lambda_u240$iv$iv3.apply((Object)compositeKeyHash$iv$iv3, block$iv$iv$iv3);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)materialized$iv$iv3, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n13 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv6 = $composer$iv;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n14 = 6 | 0x70 & $changed$iv >> 6;
            void var89_98 = $composer$iv6;
            RowScope $this$QualitySelectionDialog_u24lambda_u2411_u24lambda_u2410_u24lambda_u249_u24lambda_u248_u24lambda_u247_u24lambda_u246_u24lambda_u245 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1398323577, (String)"C139@5754L10,137@5628L360,145@6300L736,142@6025L1011:QualitySelectionDialog.kt#buhtxq");
            String string2 = $opt.getTitle();
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            if ($isSelected) {
                $composer2.startReplaceGroup(231994819);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"140@5890L11");
                var94_105 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer2.endReplaceGroup();
                l2 = var94_105;
            } else {
                $composer2.startReplaceGroup(231996069);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"140@5929L11");
                var94_105 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                $composer2.endReplaceGroup();
                l2 = var94_105;
            }
            long l3 = l2;
            TextKt.Text--4IGK_g((String)string2, null, (long)l3, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
            int $this$dp$iv3 = 4;
            boolean $i$f$getDp3 = false;
            Shape shape = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv3));
            if ($isSelected) {
                $composer2.startReplaceGroup(232004558);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"144@6186L11");
                long l4 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.2f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                $composer2.endReplaceGroup();
                l = l4;
            } else {
                $composer2.startReplaceGroup(232005711);
                $composer2.endReplaceGroup();
                l = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            }
            SurfaceKt.Surface-T9BRK9s(null, (Shape)shape, (long)l, (long)0L, (float)0.0f, (float)0.0f, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)672512001, (boolean)true, (arg_0, arg_1) -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4($opt, $isSelected, arg_0, arg_1), (Composer)$composer2, (int)54)), (Composer)$composer2, (int)0xC00000, (int)121);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            int $this$dp$iv4 = 3;
            boolean $i$f$getDp4 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer3, (int)6);
            String string3 = $opt.getSubtitle();
            TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getBodySmall(), (long)0L, (long)TextUnitKt.getSp((double)11.5), null, null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFD, null);
            long l5 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)string3, null, (long)l5, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle2, (Composer)$composer3, (int)0, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            if ($isSelected) {
                $composer4.startReplaceGroup(961365400);
                ComposerKt.sourceInformation((Composer)$composer4, (String)"165@7562L29,168@7748L11,166@7624L630");
                int $this$dp$iv5 = 12;
                boolean $i$f$getDp5 = false;
                SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv5)), (Composer)$composer4, (int)6);
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.getCircleShape();
                long l6 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getPrimary-0d7_KjU();
                int $this$dp$iv6 = 24;
                boolean $i$f$getDp6 = false;
                SurfaceKt.Surface-T9BRK9s((Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6)), (Shape)((Shape)roundedCornerShape), (long)l6, (long)0L, (float)0.0f, (float)0.0f, null, ComposableSingletons$QualitySelectionDialogKt.INSTANCE.getLambda$750706656$desktopApp(), (Composer)$composer4, (int)0xC00006, (int)120);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(953873196);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
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

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit QualitySelectionDialog$lambda$11(PlayerViewModel $viewModel, Function0 $onDismiss, State $currentQuality$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C102@3763L4601:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void verticalArrangement$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1412794132, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.QualitySelectionDialog.<anonymous> (QualitySelectionDialog.kt:102)");
            }
            int $this$dp$iv22 = 4;
            boolean $i$f$getDp = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-VpY3zN4$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv22), (int)1, null);
            int $this$dp$iv32 = 10;
            boolean $i$f$getDp2 = false;
            Arrangement.Vertical $this$dp$iv32 = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv32));
            Composer composer = $composer;
            int n = 54;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var12_15 = modifier$iv;
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
            void var31_34 = $composer$iv2;
            ColumnScope $this$QualitySelectionDialog_u24lambda_u2411_u24lambda_u2410 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1859333417, (String)"C108@4028L11,108@3988L86,109@4091L29:QualitySelectionDialog.kt#buhtxq");
            DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), (float)0.3f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer2, (int)0, (int)3);
            int $this$dp$iv = 4;
            boolean $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer2, (int)6);
            $composer2.startReplaceGroup(1464047302);
            ComposerKt.sourceInformation((Composer)$composer2, (String)"*123@4916L142,127@5081L3251,113@4277L4055");
            Iterable $this$forEach$iv = QUALITY_OPTIONS;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                void $this$cache$iv;
                long l;
                long l2;
                QualityOption opt = (QualityOption)element$iv;
                boolean bl6 = false;
                boolean isSelected = StringsKt.equals((String)QualitySelectionDialogKt.QualitySelectionDialog$lambda$0((State<String>)$currentQuality$delegate), (String)opt.getId(), (boolean)true);
                int $this$dp$iv4 = 14;
                boolean $i$f$getDp4 = false;
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv4));
                if (isSelected) {
                    $composer2.startReplaceGroup(-1683966958);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"115@4407L11");
                    long l3 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.14f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer2.endReplaceGroup();
                    l2 = l3;
                } else {
                    $composer2.startReplaceGroup(-1683965774);
                    $composer2.endReplaceGroup();
                    l2 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                long l4 = l2;
                boolean $this$dp$iv5 = true;
                boolean $i$f$getDp5 = false;
                float f = Dp.constructor-impl((float)((float)$this$dp$iv5));
                if (isSelected) {
                    $composer2.startReplaceGroup(-1683960014);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"118@4624L11");
                    long l5 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.65f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer2.endReplaceGroup();
                    l = l5;
                } else {
                    $composer2.startReplaceGroup(-1683958830);
                    $composer2.endReplaceGroup();
                    l = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)f, (long)l);
                int $this$dp$iv6 = 14;
                boolean $i$f$getDp222 = false;
                Modifier modifier = ClipKt.clip((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv6))));
                boolean bl7 = false;
                String string2 = null;
                Role role = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1683951187, (String)"CC(remember):QualitySelectionDialog.kt#9igjgp");
                void $i$f$getDp222 = $composer2;
                boolean invalid$iv = $composer2.changedInstance((Object)$viewModel) | $composer2.changed((Object)opt) | $composer2.changed((Object)$onDismiss);
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl8 = false;
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Role role2 = role;
                    String string3 = string2;
                    boolean bl9 = bl7;
                    Modifier modifier2 = modifier;
                    boolean bl10 = false;
                    Function0 function02 = () -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$3$lambda$2($viewModel, opt, $onDismiss);
                    modifier = modifier2;
                    bl7 = bl9;
                    string2 = string3;
                    role = role2;
                    Function0 value$iv = function02;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function0 function03 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier, (boolean)bl7, string2, role, (Function0)function03, (int)7, null), (Shape)((Shape)roundedCornerShape), (long)l4, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)2039559354, (boolean)true, (arg_0, arg_1) -> QualitySelectionDialogKt.QualitySelectionDialog$lambda$11$lambda$10$lambda$9$lambda$8(isSelected, opt, arg_0, arg_1), (Composer)$composer2, (int)54)), (Composer)$composer2, (int)0xC00000, (int)56);
            }
            $composer2.endReplaceGroup();
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

    private static final Unit QualitySelectionDialog$lambda$12(PlayerViewModel $viewModel, Function0 $onDismiss, int $$changed, Composer $composer, int $force) {
        QualitySelectionDialogKt.QualitySelectionDialog($viewModel, (Function0<Unit>)$onDismiss, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    static {
        Object[] objectArray = new QualityOption[]{new QualityOption("high", "High Fidelity / Lossless", "320 kbps", "Studio master audio with pristine dynamic clarity and full frequency response (JioSaavn 320k, YouTube Opus/AAC HQ)", "STUDIO HQ"), new QualityOption("medium", "Standard Audio", "192 kbps", "Optimal balance of crisp acoustic definition and quick loading", "BALANCED"), new QualityOption("low", "Data Saver", "128 kbps", "Reduced stream bandwidth for metered or slower internet connections", "LIGHT")};
        QUALITY_OPTIONS = CollectionsKt.listOf((Object[])objectArray);
    }
}

