/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.CloseKt
 *  androidx.compose.material.icons.filled.DeleteKt
 *  androidx.compose.material.icons.filled.DownloadKt
 *  androidx.compose.material.icons.filled.KeyboardArrowDownKt
 *  androidx.compose.material.icons.filled.LyricsKt
 *  androidx.compose.material.icons.filled.SkipNextKt
 *  androidx.compose.material.icons.filled.SkipPreviousKt
 *  androidx.compose.material.icons.filled.SyncKt
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
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.DownloadKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.LyricsKt;
import androidx.compose.material.icons.filled.SkipNextKt;
import androidx.compose.material.icons.filled.SkipPreviousKt;
import androidx.compose.material.icons.filled.SyncKt;
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
@SourceDebugExtension(value={"SMAP\nNowPlayingScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NowPlayingScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$NowPlayingScreenKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n*L\n1#1,1136:1\n113#2:1137\n113#2:1138\n113#2:1139\n113#2:1140\n113#2:1174\n113#2:1215\n113#2:1220\n113#2:1221\n113#2:1222\n113#2:1223\n99#3,6:1141\n106#3:1178\n79#4,6:1147\n86#4,3:1162\n89#4,2:1171\n93#4:1177\n79#4,6:1188\n86#4,3:1203\n89#4,2:1212\n93#4:1218\n347#5,9:1153\n356#5:1173\n357#5,2:1175\n347#5,9:1194\n356#5:1214\n357#5,2:1216\n4206#6,6:1165\n4206#6,6:1206\n70#7:1179\n68#7,8:1180\n77#7:1219\n*S KotlinDebug\n*F\n+ 1 NowPlayingScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$NowPlayingScreenKt\n*L\n243#1:1137\n346#1:1138\n654#1:1139\n656#1:1140\n662#1:1174\n715#1:1215\n896#1:1220\n984#1:1221\n1076#1:1222\n1101#1:1223\n653#1:1141,6\n653#1:1178\n653#1:1147,6\n653#1:1162,3\n653#1:1171,2\n653#1:1177\n711#1:1188,6\n711#1:1203,3\n711#1:1212,2\n711#1:1218\n653#1:1153,9\n653#1:1173\n653#1:1175,2\n711#1:1194,9\n711#1:1214\n711#1:1216,2\n653#1:1165,6\n711#1:1206,6\n711#1:1179\n711#1:1180,8\n711#1:1219\n*E\n"})
public final class ComposableSingletons$NowPlayingScreenKt {
    @NotNull
    public static final ComposableSingletons$NowPlayingScreenKt INSTANCE = new ComposableSingletons$NowPlayingScreenKt();
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$1680239511 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)1680239511, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_1680239511$lambda$0);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$684392668 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)684392668, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_684392668$lambda$1);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-1772391718 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-1772391718, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda__1772391718$lambda$3);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-1479729362 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-1479729362, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda__1479729362$lambda$5);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$984031417 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)984031417, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_984031417$lambda$6);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$143497347 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)143497347, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_143497347$lambda$7);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$951722582 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)951722582, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_951722582$lambda$8);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$2118613989 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)2118613989, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda_2118613989$lambda$9);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-415136636 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-415136636, (boolean)false, ComposableSingletons$NowPlayingScreenKt::lambda__415136636$lambda$10);

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$1680239511$desktopApp() {
        return lambda$1680239511;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$684392668$desktopApp() {
        return lambda$684392668;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-1772391718$desktopApp() {
        return lambda$-1772391718;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-1479729362$desktopApp() {
        return lambda$-1479729362;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$984031417$desktopApp() {
        return lambda$984031417;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$143497347$desktopApp() {
        return lambda$143497347;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$951722582$desktopApp() {
        return lambda$951722582;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$2118613989$desktopApp() {
        return lambda$2118613989;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-415136636$desktopApp() {
        return lambda$-415136636;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda_1680239511$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C243@10711L11,239@10491L259:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1680239511, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$1680239511.<anonymous> (NowPlayingScreen.kt:239)");
            }
            int $this$dp$iv = 24;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)KeyboardArrowDownKt.getKeyboardArrowDown((Icons.Filled)Icons.INSTANCE.getDefault()), (String)"Collapse", (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface-0d7_KjU(), (Composer)$composer, (int)432, (int)0);
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
    private static final Unit lambda_684392668$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C344@15445L11,341@15281L271:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)684392668, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$684392668.<anonymous> (NowPlayingScreen.kt:341)");
            }
            ImageVector imageVector = CloseKt.getClose((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            int $this$dp$iv = 18;
            boolean $i$f$getDp = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Close", (Modifier)modifier, (long)l, (Composer)$composer, (int)432, (int)0);
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
    private static final Unit lambda__1772391718$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C652@29905L1126:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $changed$iv;
            void verticalAlignment$iv;
            void horizontalArrangement$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1772391718, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$-1772391718.<anonymous> (NowPlayingScreen.kt:652)");
            }
            int $this$dp$iv = 16;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            $this$dp$iv = 10;
            $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            int $this$dp$iv22 = 8;
            boolean $i$f$getDp22 = false;
            Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv22));
            Modifier $this$dp$iv22 = modifier;
            Arrangement.Horizontal $i$f$getDp22 = (Arrangement.Horizontal)horizontalOrVertical;
            Alignment.Vertical vertical2 = vertical;
            Composer composer = $composer;
            int n = 438;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var12_16 = modifier$iv;
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
            void var31_35 = $composer$iv2;
            RowScope $this$lambda__1772391718_u24lambda_u243_u24lambda_u242 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1978335672, (String)"C660@30464L11,657@30256L349,665@30774L10,667@30929L11,663@30642L355:NowPlayingScreen.kt#zg4hxr");
            ImageVector imageVector = SyncKt.getSync((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
            int $this$dp$iv3 = 16;
            boolean $i$f$getDp3 = false;
            Modifier modifier2 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier2, (long)l, (Composer)$composer2, (int)432, (int)0);
            imageVector = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getLabelLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
            TextKt.Text--4IGK_g((String)"Sync to lyric", null, (long)l2, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)imageVector, (Composer)$composer2, (int)196614, (int)0, (int)65498);
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
    private static final Unit lambda__1479729362$lambda$5(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C710@33095L505:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void contentAlignment$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1479729362, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$-1479729362.<anonymous> (NowPlayingScreen.kt:710)");
            }
            Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Alignment alignment = Alignment.Companion.getCenter();
            Composer composer = $composer;
            int $changed$iv = 54;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
            void var9_9 = modifier$iv;
            int n = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n2 = 6 | 0x380 & $changed$iv$iv << 6;
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
            int n3 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv2 = $composer$iv;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv >> 6;
            void var28_28 = $composer$iv2;
            BoxScope $this$lambda__1479729362_u24lambda_u245_u24lambda_u244 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1210763489, (String)"C715@33481L11,711@33198L368:NowPlayingScreen.kt#zg4hxr");
            int $this$dp$iv = 36;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)LyricsKt.getLyrics((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (float)0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer2, (int)432, (int)0);
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
    private static final Unit lambda_984031417$lambda$6(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C728@34196L57:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)984031417, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$984031417.<anonymous> (NowPlayingScreen.kt:728)");
            }
            TextKt.Text--4IGK_g((String)"Search Lyrics Again", null, (long)0L, (long)0L, null, (FontWeight)FontWeight.Companion.getBold(), null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)196614, (int)0, (int)131038);
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
    private static final Unit lambda_143497347$lambda$7(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C894@40866L55,895@40938L28,896@40983L57:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)143497347, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$143497347.<anonymous> (NowPlayingScreen.kt:894)");
            }
            IconKt.Icon-ww6aTOc((ImageVector)DownloadKt.getDownload((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)0L, (Composer)$composer, (int)48, (int)12);
            int $this$dp$iv = 8;
            boolean $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer, (int)6);
            TextKt.Text--4IGK_g((String)"Download This Track", null, (long)0L, (long)0L, null, (FontWeight)FontWeight.Companion.getBold(), null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)196614, (int)0, (int)131038);
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
    private static final Unit lambda_951722582$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C982@44700L11,979@44525L309:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)951722582, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$951722582.<anonymous> (NowPlayingScreen.kt:979)");
            }
            ImageVector imageVector = DeleteKt.getDelete((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (float)0.6f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            int $this$dp$iv = 18;
            boolean $i$f$getDp = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Remove from Queue", (Modifier)modifier, (long)l, (Composer)$composer, (int)432, (int)0);
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
    private static final Unit lambda_2118613989$lambda$9(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C1075@48019L87:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)2118613989, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$2118613989.<anonymous> (NowPlayingScreen.kt:1075)");
            }
            int $this$dp$iv = 32;
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
    private static final Unit lambda__415136636$lambda$10(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C1100@49314L79:NowPlayingScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-415136636, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$NowPlayingScreenKt.lambda$-415136636.<anonymous> (NowPlayingScreen.kt:1100)");
            }
            int $this$dp$iv = 32;
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

