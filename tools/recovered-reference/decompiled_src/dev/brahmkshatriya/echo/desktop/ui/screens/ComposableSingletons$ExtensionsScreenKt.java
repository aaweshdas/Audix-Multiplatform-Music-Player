/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.AddKt
 *  androidx.compose.material.icons.filled.DeleteKt
 *  androidx.compose.material.icons.filled.ExtensionKt
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
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
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
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.ExtensionKt;
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
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreenKt;
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
@SourceDebugExtension(value={"SMAP\nExtensionsScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionsScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$ExtensionsScreenKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n*L\n1#1,230:1\n113#2:231\n113#2:306\n113#2:307\n113#2:308\n70#3:232\n68#3,8:233\n77#3:316\n79#4,6:241\n86#4,3:256\n89#4,2:265\n79#4,6:279\n86#4,3:294\n89#4,2:303\n93#4:311\n93#4:315\n347#5,9:247\n356#5:267\n347#5,9:285\n356#5:305\n357#5,2:309\n357#5,2:313\n4206#6,6:259\n4206#6,6:297\n87#7:268\n83#7,10:269\n94#7:312\n*S KotlinDebug\n*F\n+ 1 ExtensionsScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$ExtensionsScreenKt\n*L\n111#1:231\n116#1:306\n122#1:307\n128#1:308\n111#1:232\n111#1:233,8\n111#1:316\n111#1:241,6\n111#1:256,3\n111#1:265,2\n112#1:279,6\n112#1:294,3\n112#1:303,2\n112#1:311\n111#1:315\n111#1:247,9\n111#1:267\n112#1:285,9\n112#1:305\n112#1:309,2\n111#1:313,2\n111#1:259,6\n112#1:297,6\n112#1:268\n112#1:269,10\n112#1:312\n*E\n"})
public final class ComposableSingletons$ExtensionsScreenKt {
    @NotNull
    public static final ComposableSingletons$ExtensionsScreenKt INSTANCE = new ComposableSingletons$ExtensionsScreenKt();
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$-1599991011 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1599991011, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda__1599991011$lambda$0);
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$-1998342637 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-1998342637, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda__1998342637$lambda$1);
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$352980746 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)352980746, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda_352980746$lambda$2);
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$1906068107 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)1906068107, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda_1906068107$lambda$3);
    @NotNull
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$-835811828 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)-835811828, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda__835811828$lambda$6);
    @NotNull
    private static Function3<RowScope, Composer, Integer, Unit> lambda$533450644 = (Function3)ComposableLambdaKt.composableLambdaInstance((int)533450644, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda_533450644$lambda$7);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-711551377 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-711551377, (boolean)false, ComposableSingletons$ExtensionsScreenKt::lambda__711551377$lambda$8);

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$-1599991011$desktopApp() {
        return lambda$-1599991011;
    }

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$-1998342637$desktopApp() {
        return lambda$-1998342637;
    }

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$352980746$desktopApp() {
        return lambda$352980746;
    }

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$1906068107$desktopApp() {
        return lambda$1906068107;
    }

    @NotNull
    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$-835811828$desktopApp() {
        return lambda$-835811828;
    }

    @NotNull
    public final Function3<RowScope, Composer, Integer, Unit> getLambda$533450644$desktopApp() {
        return lambda$533450644;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-711551377$desktopApp() {
        return lambda$-711551377;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1599991011$lambda$0(RowScope $this$OutlinedButton, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$OutlinedButton, (String)"$this$OutlinedButton");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C63@2792L29,64@2842L26:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1599991011, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$-1599991011.<anonymous> (ExtensionsScreen.kt:63)");
            }
            IconKt.Icon-ww6aTOc((ImageVector)AddKt.getAdd((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)0L, (Composer)$composer, (int)48, (int)12);
            TextKt.Text--4IGK_g((String)" Install from File", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
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
    private static final Unit lambda__1998342637$lambda$1(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C72@3048L33:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1998342637, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$-1998342637.<anonymous> (ExtensionsScreen.kt:72)");
            }
            ExtensionsScreenKt.access$SectionHeader("Music Extensions", $composer, 6);
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
    private static final Unit lambda_352980746$lambda$2(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C85@3595L35:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)352980746, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$352980746.<anonymous> (ExtensionsScreen.kt:85)");
            }
            ExtensionsScreenKt.access$SectionHeader("Tracker Extensions", $composer, 6);
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
    private static final Unit lambda_1906068107$lambda$3(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C97@4053L34:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1906068107, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$1906068107.<anonymous> (ExtensionsScreen.kt:97)");
            }
            ExtensionsScreenKt.access$SectionHeader("Lyrics Extensions", $composer, 6);
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
    private static final Unit lambda__835811828$lambda$6(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C110@4586L1177:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void horizontalAlignment$iv;
            void $composer$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv;
            void contentAlignment$iv;
            void $composer$iv2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-835811828, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$-835811828.<anonymous> (ExtensionsScreen.kt:110)");
            }
            int $this$dp$iv22 = 64;
            boolean $i$f$getDp22 = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment $i$f$getDp22 = Alignment.Companion.getCenter();
            Composer composer = $composer;
            int $changed$iv = 54;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
            void var10_12 = modifier$iv;
            int n = 0x70 & $changed$iv << 3;
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
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv >> 6;
            void var29_31 = $composer$iv3;
            BoxScope $this$lambda__835811828_u24lambda_u246_u24lambda_u245 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-582943015, (String)"C111@4693L1048:ExtensionsScreen.kt#zg4hxr");
            Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
            void var33_35 = $composer3;
            int $changed$iv2 = 384;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier modifier$iv2 = (Modifier)Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            Modifier modifier = modifier$iv2;
            int n5 = 0x70 & $changed$iv2 << 3;
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
            int n8 = 6 | 0x70 & $changed$iv2 >> 6;
            void var58_60 = $composer$iv4;
            ColumnScope $this$lambda__835811828_u24lambda_u246_u24lambda_u245_u24lambda_u244 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1386718518, (String)"C116@4990L11,112@4782L266,120@5196L10,118@5077L245,125@5507L10,126@5584L11,123@5351L364:ExtensionsScreen.kt#zg4hxr");
            int $this$dp$iv = 64;
            boolean $i$f$getDp = false;
            IconKt.Icon-ww6aTOc((ImageVector)ExtensionKt.getExtension((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (Composer)$composer2, (int)432, (int)0);
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleMedium();
            int $this$dp$iv3 = 16;
            boolean $i$f$getDp3 = false;
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv3), (float)0.0f, (float)0.0f, (int)13, null);
            TextKt.Text--4IGK_g((String)"No extensions installed", (Modifier)modifier2, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)54, (int)0, (int)65532);
            textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            int $this$dp$iv4 = 8;
            boolean $i$f$getDp4 = false;
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv4), (float)0.0f, (float)0.0f, (int)13, null);
            TextKt.Text--4IGK_g((String)"Drop a .jar extension file here or click 'Install from File'", (Modifier)modifier3, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)54, (int)0, (int)65528);
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
    private static final Unit lambda_533450644$lambda$7(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Button, (String)"$this$Button");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C210@8578L11:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)533450644, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$533450644.<anonymous> (ExtensionsScreen.kt:210)");
            }
            TextKt.Text--4IGK_g((String)"Use", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)6, (int)0, (int)131070);
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
    private static final Unit lambda__711551377$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C223@9012L11,220@8890L157:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-711551377, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt.lambda$-711551377.<anonymous> (ExtensionsScreen.kt:220)");
            }
            IconKt.Icon-ww6aTOc((ImageVector)DeleteKt.getDelete((Icons.Filled)Icons.INSTANCE.getDefault()), (String)"Uninstall", null, (long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getError-0d7_KjU(), (Composer)$composer, (int)48, (int)4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

