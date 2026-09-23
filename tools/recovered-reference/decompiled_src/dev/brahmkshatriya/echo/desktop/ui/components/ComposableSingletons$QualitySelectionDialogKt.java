/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.CheckKt
 *  androidx.compose.material.icons.filled.HighQualityKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.Updater
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Horizontal
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

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
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.HighQualityKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
@SourceDebugExtension(value={"SMAP\nQualitySelectionDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QualitySelectionDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$QualitySelectionDialogKt\n+ 2 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,195:1\n99#2:196\n95#2,10:197\n106#2:281\n79#3,6:207\n86#3,3:222\n89#3,2:231\n79#3,6:247\n86#3,3:262\n89#3,2:271\n93#3:276\n93#3:280\n347#4,9:213\n356#4:233\n347#4,9:253\n356#4,3:273\n357#4,2:278\n4206#5,6:225\n4206#5,6:265\n113#6:234\n113#6:235\n113#6:282\n87#7:236\n83#7,10:237\n94#7:277\n*S KotlinDebug\n*F\n+ 1 QualitySelectionDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$QualitySelectionDialogKt\n*L\n80#1:196\n80#1:197,10\n80#1:281\n80#1:207,6\n80#1:222,3\n80#1:231,2\n88#1:247,6\n88#1:262,3\n88#1:271,2\n88#1:276\n80#1:280\n80#1:213,9\n80#1:233\n88#1:253,9\n88#1:273,3\n80#1:278,2\n80#1:225,6\n88#1:265,6\n85#1:234\n87#1:235\n176#1:282\n88#1:236\n88#1:237,10\n88#1:277\n*E\n"})
public final class ComposableSingletons$QualitySelectionDialogKt {
    @NotNull
    public static final ComposableSingletons$QualitySelectionDialogKt INSTANCE = new ComposableSingletons$QualitySelectionDialogKt();
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-1435314601 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1435314601, (boolean)false, ComposableSingletons$QualitySelectionDialogKt::lambda__1435314601$lambda$0);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-1585208213 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-1585208213, (boolean)false, ComposableSingletons$QualitySelectionDialogKt::lambda__1585208213$lambda$3);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$750706656 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)750706656, (boolean)false, ComposableSingletons$QualitySelectionDialogKt::lambda_750706656$lambda$4);

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-1435314601$desktopApp() {
        return lambda$-1435314601;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-1585208213$desktopApp() {
        return lambda$-1585208213;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$750706656$desktopApp() {
        return lambda$750706656;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1435314601$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C189@8541L12:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1435314601, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$QualitySelectionDialogKt.lambda$-1435314601.<anonymous> (QualitySelectionDialog.kt:189)");
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

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1585208213$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C79@2808L914:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void $composer$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void verticalAlignment$iv;
            void $composer$iv2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1585208213, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$QualitySelectionDialogKt.lambda$-1585208213.<anonymous> (QualitySelectionDialog.kt:79)");
            }
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int $changed$iv2 = 384;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            Modifier modifier = modifier$iv;
            int n = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            boolean $i$f$ReusableComposeNode = false;
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
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv2);
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
            int n3 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv3 = $composer$iv2;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv2 >> 6;
            void var28_28 = $composer$iv3;
            RowScope $this$lambda__1585208213_u24lambda_u243_u24lambda_u242 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)52157974, (String)"C83@3033L11,80@2878L245,86@3140L29,87@3186L522:QualitySelectionDialog.kt#buhtxq");
            ImageVector imageVector = HighQualityKt.getHighQuality((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv = 28;
            boolean $i$f$getDp = false;
            Modifier modifier2 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier2, (long)l, (Composer)$composer3, (int)432, (int)0);
            int $this$dp$iv2 = 10;
            boolean $i$f$getDp2 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv2)), (Composer)$composer3, (int)6);
            modifier2 = $composer3;
            $this$dp$iv = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier modifier$iv2 = (Modifier)Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            Modifier modifier3 = modifier$iv2;
            int n5 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n6 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode2 = false;
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv);
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
            int n7 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv4 = $composer$iv;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n8 = 6 | 0x70 & $changed$iv >> 6;
            void var59_61 = $composer$iv4;
            ColumnScope $this$lambda__1585208213_u24lambda_u243_u24lambda_u242_u24lambda_u241 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)226541155, (String)"C90@3322L10,88@3215L204,95@3572L10,96@3640L11,93@3440L250:QualitySelectionDialog.kt#buhtxq");
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            TextKt.Text--4IGK_g((String)"Audio Stream Quality", null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196614, (int)0, (int)65502);
            textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)"Choose audio resolution and streaming bitrate", null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)6, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
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
    private static final Unit lambda_750706656$lambda$4(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C171@7909L311:QualitySelectionDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)750706656, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$QualitySelectionDialogKt.lambda$750706656.<anonymous> (QualitySelectionDialog.kt:171)");
            }
            ImageVector imageVector = CheckKt.getCheck((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = Color.Companion.getWhite-0d7_KjU();
            int $this$dp$iv = 4;
            boolean $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Selected", (Modifier)modifier, (long)l, (Composer)$composer, (int)3504, (int)0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

