/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BorderStroke
 *  androidx.compose.foundation.BorderStrokeKt
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.foundation.shape.RoundedCornerShape
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.ProgressIndicatorKt
 *  androidx.compose.material3.SurfaceKt
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
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.Shape
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
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.graphics.Shape;
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
@SourceDebugExtension(value={"SMAP\nHomeScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$HomeScreenKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,564:1\n113#2:565\n113#2:606\n113#2:644\n113#2:649\n113#2:650\n113#2:651\n70#3:566\n68#3,8:567\n77#3:605\n79#4,6:575\n86#4,3:590\n89#4,2:599\n93#4:604\n79#4,6:617\n86#4,3:632\n89#4,2:641\n93#4:647\n347#5,9:581\n356#5,3:601\n347#5,9:623\n356#5:643\n357#5,2:645\n4206#6,6:593\n4206#6,6:635\n87#7:607\n84#7,9:608\n94#7:648\n*S KotlinDebug\n*F\n+ 1 HomeScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$HomeScreenKt\n*L\n210#1:565\n227#1:606\n236#1:644\n219#1:649\n221#1:650\n224#1:651\n209#1:566\n209#1:567,8\n209#1:605\n209#1:575,6\n209#1:590,3\n209#1:599,2\n209#1:604\n226#1:617,6\n226#1:632,3\n226#1:641,2\n226#1:647\n209#1:581,9\n209#1:601,3\n226#1:623,9\n226#1:643\n226#1:645,2\n209#1:593,6\n226#1:635,6\n226#1:607\n226#1:608,9\n226#1:648\n*E\n"})
public final class ComposableSingletons$HomeScreenKt {
    @NotNull
    public static final ComposableSingletons$HomeScreenKt INSTANCE = new ComposableSingletons$HomeScreenKt();
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1731399571 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)1731399571, (boolean)false, ComposableSingletons$HomeScreenKt::lambda_1731399571$lambda$1);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$535773646 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)535773646, (boolean)false, ComposableSingletons$HomeScreenKt::lambda_535773646$lambda$3);
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$-1259203789 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1259203789, (boolean)false, ComposableSingletons$HomeScreenKt::lambda__1259203789$lambda$4);

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1731399571$desktopApp() {
        return lambda$1731399571;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$535773646$desktopApp() {
        return lambda$535773646;
    }

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$-1259203789$desktopApp() {
        return lambda$-1259203789;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_1731399571$lambda$1(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C208@9525L298:HomeScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void modifier$iv;
            void contentAlignment$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1731399571, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$HomeScreenKt.lambda$1731399571.<anonymous> (HomeScreen.kt:208)");
            }
            int $this$dp$iv22 = 200;
            boolean $i$f$getDp22 = false;
            Modifier $this$dp$iv22 = SizeKt.height-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment $i$f$getDp22 = Alignment.Companion.getCenter();
            Composer composer = $composer;
            int n = 54;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
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
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv >> 6;
            void var29_31 = $composer$iv2;
            BoxScope $this$lambda_1731399571_u24lambda_u241_u24lambda_u240 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1604173126, (String)"C212@9777L11,212@9729L68:HomeScreen.kt#zg4hxr");
            ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w(null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.0f, (long)0L, (int)0, (Composer)$composer2, (int)0, (int)29);
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

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_535773646$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C225@10384L983:HomeScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void horizontalAlignment$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)535773646, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$HomeScreenKt.lambda$535773646.<anonymous> (HomeScreen.kt:225)");
            }
            int $this$dp$iv22 = 32;
            boolean $i$f$getDp = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var9_11 = modifier$iv;
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
            void var28_30 = $composer$iv2;
            ColumnScope $this$lambda_535773646_u24lambda_u243_u24lambda_u242 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1258634001, (String)"C231@10742L10,229@10607L314,235@10954L29,238@11206L10,236@11016L321:HomeScreen.kt#zg4hxr");
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleMedium();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            long l = Color.Companion.getWhite-0d7_KjU();
            TextKt.Text--4IGK_g((String)"No music content loaded in feed", null, (long)l, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196998, (int)0, (int)65498);
            int $this$dp$iv = 6;
            boolean $i$f$getDp2 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer2, (int)6);
            TextStyle textStyle2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
            long l2 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.7f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            TextKt.Text--4IGK_g((String)"Use the Search tab to discover recommended songs, or configure extensions in Settings.", null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle2, (Composer)$composer2, (int)390, (int)0, (int)65530);
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

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1259203789$lambda$4(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C217@9922L1471:HomeScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1259203789, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$HomeScreenKt.lambda$-1259203789.<anonymous> (HomeScreen.kt:217)");
            }
            int $this$dp$iv = 16;
            boolean $i$f$getDp = false;
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv));
            long l = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            boolean $this$dp$iv2 = true;
            boolean $i$f$getDp2 = false;
            BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)Dp.constructor-impl((float)((float)$this$dp$iv2)), (long)Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null));
            int $this$dp$iv3 = 28;
            boolean $i$f$getDp3 = false;
            float f = Dp.constructor-impl((float)$this$dp$iv3);
            $this$dp$iv3 = 16;
            $i$f$getDp3 = false;
            SurfaceKt.Surface-T9BRK9s((Modifier)PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv3)), (Shape)((Shape)roundedCornerShape), (long)l, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, lambda$535773646, (Composer)$composer, (int)14156166, (int)56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

