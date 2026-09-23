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
 *  androidx.compose.material.icons.filled.BedtimeKt
 *  androidx.compose.material.icons.filled.CloseKt
 *  androidx.compose.material.icons.filled.MusicNoteKt
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
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.unit.TextUnitKt
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
import androidx.compose.material.icons.filled.BedtimeKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.MusicNoteKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
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
@SourceDebugExtension(value={"SMAP\nSleepTimerDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SleepTimerDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$SleepTimerDialogKt\n+ 2 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 3 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 4 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 5 Composer.kt\nandroidx/compose/runtime/Updater\n+ 6 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,312:1\n99#2:313\n95#2,10:314\n106#2:398\n99#2:402\n96#2,9:403\n106#2:486\n79#3,6:324\n86#3,3:339\n89#3,2:348\n79#3,6:364\n86#3,3:379\n89#3,2:388\n93#3:393\n93#3:397\n79#3,6:412\n86#3,3:427\n89#3,2:436\n79#3,6:452\n86#3,3:467\n89#3,2:476\n93#3:481\n93#3:485\n347#4,9:330\n356#4:350\n347#4,9:370\n356#4,3:390\n357#4,2:395\n347#4,9:418\n356#4:438\n347#4,9:458\n356#4,3:478\n357#4,2:483\n4206#5,6:342\n4206#5,6:382\n4206#5,6:430\n4206#5,6:470\n113#6:351\n113#6:352\n113#6:399\n113#6:400\n113#6:401\n113#6:439\n113#6:440\n87#7:353\n83#7,10:354\n94#7:394\n87#7:441\n83#7,10:442\n94#7:482\n*S KotlinDebug\n*F\n+ 1 SleepTimerDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$SleepTimerDialogKt\n*L\n61#1:313\n61#1:314,10\n61#1:398\n234#1:402\n234#1:403,9\n234#1:486\n61#1:324,6\n61#1:339,3\n61#1:348,2\n69#1:364,6\n69#1:379,3\n69#1:388,2\n69#1:393\n61#1:397\n234#1:412,6\n234#1:427,3\n234#1:436,2\n245#1:452,6\n245#1:467,3\n245#1:476,2\n245#1:481\n234#1:485\n61#1:330,9\n61#1:350\n69#1:370,9\n69#1:390,3\n61#1:395,2\n234#1:418,9\n234#1:438\n245#1:458,9\n245#1:478,3\n234#1:483,2\n61#1:342,6\n69#1:382,6\n234#1:430,6\n245#1:470,6\n66#1:351\n68#1:352\n149#1:399\n150#1:400\n235#1:401\n242#1:439\n244#1:440\n69#1:353\n69#1:354,10\n69#1:394\n245#1:441\n245#1:442,10\n245#1:482\n*E\n"})
public final class ComposableSingletons$SleepTimerDialogKt {
    @NotNull
    public static final ComposableSingletons$SleepTimerDialogKt INSTANCE = new ComposableSingletons$SleepTimerDialogKt();
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$649883063 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)649883063, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda_649883063$lambda$0);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$1050851787 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)1050851787, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda_1050851787$lambda$3);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-1462102318 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1462102318, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda__1462102318$lambda$4);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-1376532323 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-1376532323, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda__1376532323$lambda$7);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$2112781023 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)2112781023, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda_2112781023$lambda$8);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-1327592170 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1327592170, (boolean)false, ComposableSingletons$SleepTimerDialogKt::lambda__1327592170$lambda$9);

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$649883063$desktopApp() {
        return lambda$649883063;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$1050851787$desktopApp() {
        return lambda$1050851787;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-1462102318$desktopApp() {
        return lambda$-1462102318;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-1376532323$desktopApp() {
        return lambda$-1376532323;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$2112781023$desktopApp() {
        return lambda$2112781023;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-1327592170$desktopApp() {
        return lambda$-1327592170;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_649883063$lambda$0(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C306@14448L13:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)649883063, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$649883063.<anonymous> (SleepTimerDialog.kt:306)");
            }
            TextKt.Text--4IGK_g((String)"Close", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
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
    private static final Unit lambda_1050851787$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C60@2563L899:SleepTimerDialog.kt#buhtxq");
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
                ComposerKt.traceEventStart((int)1050851787, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$1050851787.<anonymous> (SleepTimerDialog.kt:60)");
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
            RowScope $this$lambda_1050851787_u24lambda_u243_u24lambda_u242 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-2071161627, (String)"C64@2784L11,61@2633L241,67@2891L29,68@2937L511:SleepTimerDialog.kt#buhtxq");
            ImageVector imageVector = BedtimeKt.getBedtime((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv = 26;
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
            ColumnScope $this$lambda_1050851787_u24lambda_u243_u24lambda_u242_u24lambda_u241 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1006982318, (String)"C71@3064L10,69@2966L195,76@3312L10,77@3380L11,74@3182L248:SleepTimerDialog.kt#buhtxq");
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            TextKt.Text--4IGK_g((String)"Sleep Timer", null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196614, (int)0, (int)65502);
            textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)"Automatically pause playback after duration", null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)6, (int)0, (int)65530);
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
    private static final Unit lambda__1462102318$lambda$4(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C148@7158L85,149@7276L28,150@7337L56:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1462102318, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$-1462102318.<anonymous> (SleepTimerDialog.kt:148)");
            }
            int $this$dp$iv = 16;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)CloseKt.getClose((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)0L, (Composer)$composer, (int)432, (int)8);
            $this$dp$iv = 6;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer, (int)6);
            TextKt.Text--4IGK_g((String)"Cancel Sleep Timer", null, (long)0L, (long)0L, null, (FontWeight)FontWeight.Companion.getBold(), null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)196614, (int)0, (int)131038);
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
    private static final Unit lambda__1376532323$lambda$7(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C233@11234L1277:SleepTimerDialog.kt#buhtxq");
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
            void modifier$iv;
            void $changed$iv2;
            void verticalAlignment$iv;
            void $composer$iv2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1376532323, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$-1376532323.<anonymous> (SleepTimerDialog.kt:233)");
            }
            int $this$dp$iv = 14;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            $this$dp$iv = 10;
            $i$f$getDp = false;
            Modifier $this$dp$iv2 = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var9_11 = modifier$iv;
            int n2 = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n3 = 6 | 0x380 & $changed$iv$iv2 << 6;
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
            int n4 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv3 = $composer$iv2;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv2 >> 6;
            void var28_30 = $composer$iv3;
            RowScope $this$lambda__1376532323_u24lambda_u247_u24lambda_u246 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1985683366, (String)"C240@11612L11,237@11449L269,243@11743L29,244@11797L692:SleepTimerDialog.kt#buhtxq");
            ImageVector imageVector = MusicNoteKt.getMusicNote((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv3 = 18;
            boolean $i$f$getDp2 = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier, (long)l, (Composer)$composer3, (int)432, (int)0);
            int $this$dp$iv4 = 10;
            boolean $i$f$getDp3 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer3, (int)6);
            modifier = $composer3;
            $this$dp$iv3 = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier modifier$iv2 = (Modifier)Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            Modifier modifier2 = modifier$iv2;
            int n6 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n7 = 6 | 0x380 & $changed$iv$iv << 6;
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
            int n8 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv4 = $composer$iv;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n9 = 6 | 0x70 & $changed$iv >> 6;
            void var59_63 = $composer$iv4;
            ColumnScope $this$lambda__1376532323_u24lambda_u247_u24lambda_u246_u24lambda_u245 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-20258933, (String)"C247@11956L10,248@12072L11,245@11834L289,252@12306L10,253@12405L11,250@12152L311:SleepTimerDialog.kt#buhtxq");
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getSemiBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            TextKt.Text--4IGK_g((String)"End of current song", null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)6, (int)0, (int)65530);
            textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall(), (long)0L, (long)TextUnitKt.getSp((int)11), null, null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFD, null);
            l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)"Stop playing cleanly when the active track finishes", null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)6, (int)0, (int)65530);
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
    private static final Unit lambda_2112781023$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C279@13394L15:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)2112781023, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$2112781023.<anonymous> (SleepTimerDialog.kt:279)");
            }
            TextKt.Text--4IGK_g((String)"e.g. 25", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
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
    private static final Unit lambda__1327592170$lambda$9(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C296@14200L17:SleepTimerDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1327592170, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$SleepTimerDialogKt.lambda$-1327592170.<anonymous> (SleepTimerDialog.kt:296)");
            }
            TextKt.Text--4IGK_g((String)"Set Timer", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

