/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.SurfaceKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.MutableState
 *  androidx.compose.runtime.SnapshotStateKt
 *  androidx.compose.runtime.State
 *  androidx.compose.runtime.Updater
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Horizontal
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.koin.compose.KoinApplicationKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 */
package dev.brahmkshatriya.echo.desktop.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import dev.brahmkshatriya.echo.desktop.ui.EchoDesktopAppKt;
import dev.brahmkshatriya.echo.desktop.ui.Screen;
import dev.brahmkshatriya.echo.desktop.ui.player.MiniPlayerKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreenKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreenKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchAndOthersKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=3, xi=48)
@SourceDebugExtension(value={"SMAP\nEchoDesktopApp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoDesktopApp.kt\ndev/brahmkshatriya/echo/desktop/ui/ComposableSingletons$EchoDesktopAppKt\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 9 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 10 Inject.kt\norg/koin/compose/InjectKt\n*L\n1#1,114:1\n85#2:115\n113#2,2:116\n87#3:118\n84#3,9:119\n94#3:263\n79#4,6:128\n86#4,3:143\n89#4,2:152\n79#4,6:165\n86#4,3:180\n89#4,2:189\n79#4,6:214\n86#4,3:229\n89#4,2:238\n93#4:243\n93#4:247\n93#4:262\n347#5,9:134\n356#5:154\n347#5,9:171\n356#5:191\n347#5,9:220\n356#5,3:240\n357#5,2:245\n357#5,2:260\n4206#6,6:146\n4206#6,6:183\n4206#6,6:232\n99#7:155\n96#7,9:156\n106#7:248\n1247#8,6:192\n1247#8,6:198\n1247#8,3:253\n1250#8,3:257\n70#9:204\n67#9,9:205\n77#9:244\n88#10,4:249\n92#10:256\n*S KotlinDebug\n*F\n+ 1 EchoDesktopApp.kt\ndev/brahmkshatriya/echo/desktop/ui/ComposableSingletons$EchoDesktopAppKt\n*L\n65#1:115\n65#1:116,2\n62#1:118\n62#1:119,9\n62#1:263\n62#1:128,6\n62#1:143,3\n62#1:152,2\n64#1:165,6\n64#1:180,3\n64#1:189,2\n74#1:214,6\n74#1:229,3\n74#1:238,2\n74#1:243\n64#1:247\n62#1:262\n62#1:134,9\n62#1:154\n64#1:171,9\n64#1:191\n74#1:220,9\n74#1:240,3\n64#1:245,2\n62#1:260,2\n62#1:146,6\n64#1:183,6\n74#1:232,6\n64#1:155\n64#1:156,9\n64#1:248\n65#1:192,6\n70#1:198,6\n88#1:253,3\n88#1:257,3\n74#1:204\n74#1:205,9\n74#1:244\n88#1:249,4\n88#1:256\n*E\n"})
public final class ComposableSingletons$EchoDesktopAppKt {
    @NotNull
    public static final ComposableSingletons$EchoDesktopAppKt INSTANCE = new ComposableSingletons$EchoDesktopAppKt();
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-966554779 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-966554779, (boolean)false, ComposableSingletons$EchoDesktopAppKt::lambda__966554779$lambda$8);
    @NotNull
    private static Function2<Composer, Integer, Unit> lambda$-1750845110 = (Function2)ComposableLambdaKt.composableLambdaInstance((int)-1750845110, (boolean)false, ComposableSingletons$EchoDesktopAppKt::lambda__1750845110$lambda$9);

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-966554779$desktopApp() {
        return lambda$-966554779;
    }

    @NotNull
    public final Function2<Composer, Integer, Unit> getLambda$-1750845110$desktopApp() {
        return lambda$-1750845110;
    }

    /*
     * WARNING - void declaration
     */
    private static final Screen lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$1(MutableState<Screen> $selectedScreen$delegate) {
        void $this$getValue$iv;
        State state = (State)$selectedScreen$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Screen)((Object)$this$getValue$iv.getValue());
    }

    /*
     * WARNING - void declaration
     */
    private static final void lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$2(MutableState<Screen> $selectedScreen$delegate, Screen screen) {
        void $this$setValue$iv;
        MutableState<Screen> mutableState = $selectedScreen$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        Screen value$iv = screen;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    private static final Unit lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$4$lambda$3(MutableState $selectedScreen$delegate, Screen it) {
        Intrinsics.checkNotNullParameter((Object)((Object)it), (String)"it");
        ComposableSingletons$EchoDesktopAppKt.lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$2((MutableState<Screen>)$selectedScreen$delegate, it);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__966554779$lambda$8(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C61@2601L1276:EchoDesktopApp.kt#6s6986");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Object object;
            void $this$cache$iv$iv;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $composer$iv;
            Object object2;
            Function1 value$iv;
            Object object3;
            void $this$cache$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv2;
            void $composer$iv2;
            void $composer4;
            void $changed$iv$iv$iv3;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv3;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-966554779, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.ComposableSingletons$EchoDesktopAppKt.lambda$-966554779.<anonymous> (EchoDesktopApp.kt:61)");
            }
            Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Composer composer = $composer;
            int $changed$iv = 6;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var9_9 = modifier$iv3;
            int n = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv3);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n2 = 6 | 0x380 & $changed$iv$iv3 << 6;
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
            int n3 = 0xE & $changed$iv$iv$iv3 >> 6;
            void $composer$iv4 = $composer$iv3;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv >> 6;
            void var28_28 = $composer$iv4;
            ColumnScope $this$lambda__966554779_u24lambda_u248_u24lambda_u247 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-1373790068, (String)"C63@2703L945,86@3720L19,87@3778L29,88@3824L39:EchoDesktopApp.kt#6s6986");
            Modifier modifier2 = SizeKt.fillMaxWidth$default((Modifier)ColumnScope.weight$default((ColumnScope)$this$lambda__966554779_u24lambda_u248_u24lambda_u247, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (float)0.0f, (int)1, null);
            void var32_32 = $composer4;
            int $changed$iv2 = 0;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var38_38 = modifier$iv2;
            int n5 = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Object object4 = ComposeUiNode.Companion.getConstructor();
            int n6 = 6 | 0x380 & $changed$iv$iv2 << 6;
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
            int n7 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv5 = $composer$iv2;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n8 = 6 | 0x70 & $changed$iv2 >> 6;
            void var57_61 = $composer$iv5;
            RowScope $this$lambda__966554779_u24lambda_u248_u24lambda_u247_u24lambda_u246 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-33561769, (String)"C64@2787L40,69@3013L23,67@2893L165,73@3116L514:EchoDesktopApp.kt#6s6986");
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1938579891, (String)"CC(remember):EchoDesktopApp.kt#9igjgp");
            void var60_64 = $composer3;
            boolean invalid$iv = false;
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl8 = false;
            if (it$iv == Composer.Companion.getEmpty()) {
                boolean bl9 = false;
                MutableState value$iv2 = SnapshotStateKt.mutableStateOf$default((Object)((Object)Screen.HOME), null, (int)2, null);
                $this$cache$iv.updateRememberedValue((Object)value$iv2);
                object3 = value$iv2;
            } else {
                object3 = it$iv;
            }
            MutableState mutableState = (MutableState)object3;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            MutableState selectedScreen$delegate = mutableState;
            Screen screen = ComposableSingletons$EchoDesktopAppKt.lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$1((MutableState<Screen>)selectedScreen$delegate);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1938587106, (String)"CC(remember):EchoDesktopApp.kt#9igjgp");
            $this$cache$iv = $composer3;
            invalid$iv = false;
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl8 = false;
            if (it$iv == Composer.Companion.getEmpty()) {
                Screen screen2 = screen;
                boolean bl10 = false;
                screen = screen2;
                value$iv = arg_0 -> ComposableSingletons$EchoDesktopAppKt.lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$4$lambda$3(selectedScreen$delegate, arg_0);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv;
            }
            mutableState = (Function1)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            EchoDesktopAppKt.EchoNavigationRail(screen, (Function1<? super Screen, Unit>)mutableState, (Composer)$composer3, 48);
            mutableState = SizeKt.fillMaxHeight$default((Modifier)RowScope.weight$default((RowScope)$this$lambda__966554779_u24lambda_u248_u24lambda_u247_u24lambda_u246, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (float)0.0f, (int)1, null);
            void $i$f$cache2 = $composer3;
            int $changed$iv3 = 0;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
            value$iv = modifier$iv;
            int n9 = 0x70 & $changed$iv3 << 3;
            boolean $i$f$Layout3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n10 = 6 | 0x380 & $changed$iv$iv << 6;
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
            int n11 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv6 = $composer$iv;
            boolean bl11 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n12 = 6 | 0x70 & $changed$iv3 >> 6;
            void var88_97 = $composer$iv6;
            BoxScope $this$lambda__966554779_u24lambda_u248_u24lambda_u247_u24lambda_u246_u24lambda_u245 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl12 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1314252267, (String)"C:EchoDesktopApp.kt#6s6986");
            switch (WhenMappings.$EnumSwitchMapping$0[ComposableSingletons$EchoDesktopAppKt.lambda__966554779$lambda$8$lambda$7$lambda$6$lambda$1((MutableState<Screen>)selectedScreen$delegate).ordinal()]) {
                case 1: {
                    $composer2.startReplaceGroup(511795825);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"75@3250L12");
                    HomeScreenKt.HomeScreen(null, null, null, (Composer)$composer2, 0, 7);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                case 2: {
                    $composer2.startReplaceGroup(511797683);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"76@3308L14");
                    SearchAndOthersKt.SearchScreen(null, null, null, (Composer)$composer2, 0, 7);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                case 3: {
                    $composer2.startReplaceGroup(511799636);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"77@3369L15");
                    SearchAndOthersKt.LibraryScreen(null, (Composer)$composer2, 0, 1);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                case 4: {
                    $composer2.startReplaceGroup(511801686);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"78@3433L17");
                    SearchAndOthersKt.DownloadsScreen(null, (Composer)$composer2, 0, 1);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                case 5: {
                    $composer2.startReplaceGroup(511803831);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"79@3500L18");
                    ExtensionsScreenKt.ExtensionsScreen(null, (Composer)$composer2, 0, 1);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                case 6: {
                    $composer2.startReplaceGroup(511805941);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"80@3566L16");
                    SearchAndOthersKt.SettingsScreen(null, (Composer)$composer2, 0, 1);
                    $composer2.endReplaceGroup();
                    Unit unit = Unit.INSTANCE;
                    break;
                }
                default: {
                    $composer2.startReplaceGroup(511794094);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)0L, (Composer)$composer4, (int)0, (int)7);
            $composer$iv2 = $composer4;
            $changed$iv2 = 0;
            boolean $i$f$koinInject = false;
            $composer$iv2.startReplaceGroup(-1168520582);
            Qualifier qualifier$iv = null;
            Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv2, (int)0);
            $composer$iv2.startReplaceGroup(-1633490746);
            measurePolicy$iv2 = $composer$iv2;
            boolean invalid$iv$iv = $composer$iv2.changed(qualifier$iv) | $composer$iv2.changed((Object)scope$iv);
            boolean $i$f$cache3 = false;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            boolean bl13 = false;
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                boolean bl14 = false;
                Object value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(PlayerViewModel.class), qualifier$iv, null, (int)4, null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                object = value$iv$iv;
            } else {
                object = it$iv$iv;
            }
            object4 = object;
            $composer$iv2.endReplaceGroup();
            Object object5 = object4;
            $composer$iv2.endReplaceGroup();
            PlayerViewModel playerViewModel = (PlayerViewModel)object5;
            MiniPlayerKt.MiniPlayer(playerViewModel, null, (Composer)$composer4, 0, 2);
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

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit lambda__1750845110$lambda$9(Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C59@2554L11,57@2464L1423:EchoDesktopApp.kt#6s6986");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1750845110, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.ComposableSingletons$EchoDesktopAppKt.lambda$-1750845110.<anonymous> (EchoDesktopApp.kt:57)");
            }
            SurfaceKt.Surface-T9BRK9s((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, (long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getBackground-0d7_KjU(), (long)0L, (float)0.0f, (float)0.0f, null, lambda$-966554779, (Composer)$composer, (int)0xC00006, (int)122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Screen.values().length];
            try {
                nArray[Screen.HOME.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Screen.SEARCH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Screen.LIBRARY.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Screen.DOWNLOADS.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Screen.EXTENSIONS.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Screen.SETTINGS.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

