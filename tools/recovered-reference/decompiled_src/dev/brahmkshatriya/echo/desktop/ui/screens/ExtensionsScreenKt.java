/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.OverscrollEffect
 *  androidx.compose.foundation.gestures.FlingBehavior
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.PaddingValues
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.lazy.LazyDslKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.foundation.lazy.LazyListScope
 *  androidx.compose.foundation.lazy.LazyListState
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.ExtensionKt
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.CardColors
 *  androidx.compose.material3.CardDefaults
 *  androidx.compose.material3.CardKt
 *  androidx.compose.material3.IconButtonKt
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
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  coil3.compose.SingletonAsyncImageKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.Nullable
 *  org.koin.compose.KoinApplicationKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 */
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ExtensionKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import coil3.compose.SingletonAsyncImageKt;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.TrackerExtension;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$ExtensionsScreenKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreenKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreenKt$ExtensionsScreen$lambda$19$lambda$18$lambda$17$;
import dev.brahmkshatriya.echo.desktop.viewmodel.ExtensionsViewModel;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@kotlin.Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0003\u00a2\u0006\u0002\u0010\b\u001a9\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0003\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012\u00b2\u0006\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014X\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014X\u008a\u0084\u0002\u00b2\u0006\f\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002"}, d2={"ExtensionsScreen", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/ExtensionsViewModel;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/ExtensionsViewModel;Landroidx/compose/runtime/Composer;II)V", "SectionHeader", "title", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "ExtensionItem", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "isActive", "", "onActivate", "Lkotlin/Function0;", "onUninstall", "(Ldev/brahmkshatriya/echo/common/models/Metadata;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "musicExtensions", "", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "trackerExtensions", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "lyricsExtensions", "Ldev/brahmkshatriya/echo/common/LyricsExtension;", "currentExtension"})
@SourceDebugExtension(value={"SMAP\nExtensionsScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionsScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ExtensionsScreenKt\n+ 2 Inject.kt\norg/koin/compose/InjectKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 9 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 10 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 11 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,230:1\n88#2,4:231\n92#2:238\n1247#3,3:235\n1250#3,3:239\n1247#3,6:352\n1247#3,6:366\n87#4:242\n84#4,9:243\n94#4:375\n87#4:458\n84#4,9:459\n94#4:498\n79#5,6:252\n86#5,3:267\n89#5,2:276\n79#5,6:286\n86#5,3:301\n89#5,2:310\n79#5,6:325\n86#5,3:340\n89#5,2:349\n93#5:360\n93#5:364\n93#5:374\n79#5,6:429\n86#5,3:444\n89#5,2:453\n79#5,6:468\n86#5,3:483\n89#5,2:492\n93#5:497\n93#5:501\n347#6,9:258\n356#6:278\n347#6,9:292\n356#6:312\n347#6,9:331\n356#6:351\n357#6,2:358\n357#6,2:362\n357#6,2:372\n347#6,9:435\n356#6:455\n347#6,9:474\n356#6,3:494\n357#6,2:499\n4206#7,6:270\n4206#7,6:304\n4206#7,6:343\n4206#7,6:447\n4206#7,6:486\n113#8:279\n113#8:313\n113#8:376\n113#8:377\n113#8:421\n113#8:422\n113#8:456\n113#8:457\n99#9,6:280\n99#9:314\n95#9,10:315\n106#9:361\n106#9:365\n99#9,6:423\n106#9:502\n85#10:378\n85#10:379\n85#10:380\n85#10:381\n168#11,13:382\n168#11,13:395\n168#11,13:408\n*S KotlinDebug\n*F\n+ 1 ExtensionsScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/ExtensionsScreenKt\n*L\n45#1:231,4\n45#1:238\n45#1:235,3\n45#1:239,3\n61#1:352,6\n70#1:366,6\n52#1:242\n52#1:243,9\n52#1:375\n188#1:458\n188#1:459,9\n188#1:498\n52#1:252,6\n52#1:267,3\n52#1:276,2\n54#1:286,6\n54#1:301,3\n54#1:310,2\n60#1:325,6\n60#1:340,3\n60#1:349,2\n60#1:360\n54#1:364\n52#1:374\n163#1:429,6\n163#1:444,3\n163#1:453,2\n188#1:468,6\n188#1:483,3\n188#1:492,2\n188#1:497\n163#1:501\n52#1:258,9\n52#1:278\n54#1:292,9\n54#1:312\n60#1:331,9\n60#1:351\n60#1:358,2\n54#1:362,2\n52#1:372,2\n163#1:435,9\n163#1:455\n188#1:474,9\n188#1:494,3\n163#1:499,2\n52#1:270,6\n54#1:304,6\n60#1:343,6\n163#1:447,6\n188#1:486,6\n55#1:279\n60#1:313\n145#1:376\n157#1:377\n164#1:421\n166#1:422\n177#1:456\n183#1:457\n54#1:280,6\n60#1:314\n60#1:315,10\n60#1:361\n54#1:365\n163#1:423,6\n163#1:502\n47#1:378\n48#1:379\n49#1:380\n50#1:381\n75#1:382,13\n87#1:395,13\n99#1:408,13\n*E\n"})
public final class ExtensionsScreenKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void ExtensionsScreen(@Nullable ExtensionsViewModel viewModel2, @Nullable Composer $composer, int $changed, int n) {
        block27: {
            $composer = $composer.startRestartGroup(-308547475);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(ExtensionsScreen)46@2001L16,47@2065L16,48@2127L16,49@2199L16,51@2221L3590:ExtensionsScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= (n & 1) == 0 && $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if ($composer.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                Object object2;
                void $this$cache$iv2;
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void horizontalArrangement$iv;
                void $composer$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv;
                void $changed$iv;
                void verticalAlignment$iv;
                void horizontalArrangement$iv2;
                void $composer$iv2;
                void $composer4;
                void $changed$iv$iv$iv3;
                void $changed$iv$iv3;
                void modifier$iv$iv3;
                void modifier$iv2;
                void $composer$iv3;
                Object value$iv$iv;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"44@1941L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    if ((n & 1) != 0) {
                        Object object3;
                        void $this$cache$iv$iv;
                        void $composer$iv4;
                        Composer composer = $composer;
                        boolean $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv4.startReplaceGroup(-1168520582);
                        Qualifier qualifier$iv = null;
                        Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv4, (int)0);
                        $composer$iv4.startReplaceGroup(-1633490746);
                        void var10_12 = $composer$iv4;
                        boolean invalid$iv$iv = $composer$iv4.changed(qualifier$iv) | $composer$iv4.changed((Object)scope$iv);
                        boolean $i$f$cache = false;
                        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        boolean bl = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            boolean bl2 = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(ExtensionsViewModel.class), qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object3 = value$iv$iv;
                        } else {
                            object3 = it$iv$iv;
                        }
                        Object object4 = object3;
                        $composer$iv4.endReplaceGroup();
                        Object object5 = object4;
                        $composer$iv4.endReplaceGroup();
                        viewModel2 = (ExtensionsViewModel)object5;
                        $dirty &= 0xFFFFFFF1;
                    }
                } else {
                    $composer.skipToGroupEnd();
                    if ((n & 1) != 0) {
                        $dirty &= 0xFFFFFFF1;
                    }
                }
                $composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-308547475, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionsScreen (ExtensionsScreen.kt:45)");
                }
                State musicExtensions$delegate = SnapshotStateKt.collectAsState(viewModel2.getMusic(), null, (Composer)$composer, (int)0, (int)1);
                State trackerExtensions$delegate = SnapshotStateKt.collectAsState(viewModel2.getTracker(), null, (Composer)$composer, (int)0, (int)1);
                State lyricsExtensions$delegate = SnapshotStateKt.collectAsState(viewModel2.getLyrics(), null, (Composer)$composer, (int)0, (int)1);
                State currentExtension$delegate = SnapshotStateKt.collectAsState(viewModel2.getCurrentExtension(), null, (Composer)$composer, (int)0, (int)1);
                Modifier $i$f$koinInject = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                Composer $i$f$cache = $composer;
                int $changed$iv3 = 6;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
                value$iv$iv = modifier$iv2;
                int n2 = 0x70 & $changed$iv3 << 3;
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
                boolean bl3 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl4 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n4 = 0xE & $changed$iv$iv$iv3 >> 6;
                void $composer$iv5 = $composer$iv3;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n5 = 6 | 0x70 & $changed$iv3 >> 6;
                void var35_43 = $composer$iv5;
                ColumnScope $this$ExtensionsScreen_u24lambda_u2419 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl6 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-1984903505, (String)"C53@2300L610,69@2955L2850,69@2920L2885:ExtensionsScreen.kt#zg4hxr");
                int $this$dp$iv22 = 16;
                boolean $i$f$getDp22 = false;
                Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv22));
                Arrangement.Horizontal $i$f$getDp22 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
                void var41_52 = $composer4;
                int n6 = 438;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var45_59 = modifier$iv;
                int n7 = 0x70 & $changed$iv << 3;
                boolean $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
                int n8 = 6 | 0x380 & $changed$iv$iv2 << 6;
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
                int n9 = 0xE & $changed$iv$iv$iv2 >> 6;
                void $composer$iv6 = $composer$iv2;
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n10 = 6 | 0x70 & $changed$iv >> 6;
                void var64_78 = $composer$iv6;
                RowScope $this$ExtensionsScreen_u24lambda_u2419_u24lambda_u247 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-221732914, (String)"C58@2543L10,58@2502L67,59@2582L318:ExtensionsScreen.kt#zg4hxr");
                TextKt.Text--4IGK_g((String)"Extensions", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getHeadlineMedium(), (Composer)$composer3, (int)6, (int)0, (int)65534);
                int $this$dp$iv32 = 8;
                boolean $i$f$getDp = false;
                Arrangement.Horizontal $this$dp$iv32 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv32));
                void var69_85 = $composer3;
                int $changed$iv4 = 48;
                boolean $i$f$Row2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Modifier modifier$iv3 = (Modifier)Modifier.Companion;
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
                Modifier modifier = modifier$iv3;
                int n11 = 0x70 & $changed$iv4 << 3;
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
                void $composer$iv7 = $composer$iv;
                $i$a$-Layout-RowKt$Row$1$iv = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n14 = 6 | 0x70 & $changed$iv4 >> 6;
                void var93_109 = $composer$iv7;
                RowScope $this$ExtensionsScreen_u24lambda_u2419_u24lambda_u247_u24lambda_u246 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-749609198, (String)"C60@2681L87,60@2656L230:ExtensionsScreen.kt#zg4hxr");
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1132558942, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                void var96_112 = $composer2;
                boolean invalid$iv = false;
                boolean $i$f$cache2 = false;
                Object it$iv = $this$cache$iv2.rememberedValue();
                boolean bl10 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl11 = false;
                    Function0 value$iv = ExtensionsScreenKt::ExtensionsScreen$lambda$19$lambda$7$lambda$6$lambda$5$lambda$4;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv;
                }
                Function0 function04 = (Function0)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ButtonKt.OutlinedButton((Function0)function04, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$-1599991011$desktopApp(), (Composer)$composer2, (int)0x30000006, (int)510);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                Modifier modifier2 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                LazyListState lazyListState = null;
                PaddingValues paddingValues = null;
                boolean bl12 = false;
                Arrangement.Vertical vertical2 = null;
                Alignment.Horizontal horizontal = null;
                FlingBehavior flingBehavior = null;
                boolean bl13 = false;
                OverscrollEffect overscrollEffect = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1460011813, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                horizontalArrangement$iv2 = $composer4;
                boolean invalid$iv2 = $composer.changed((Object)musicExtensions$delegate) | $composer.changed((Object)currentExtension$delegate) | $composer.changedInstance((Object)viewModel2) | $composer.changed((Object)trackerExtensions$delegate) | $composer.changed((Object)lyricsExtensions$delegate);
                boolean $i$f$cache3 = false;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    OverscrollEffect overscrollEffect2 = overscrollEffect;
                    boolean bl14 = bl13;
                    FlingBehavior flingBehavior2 = flingBehavior;
                    Alignment.Horizontal horizontal2 = horizontal;
                    Arrangement.Vertical vertical3 = vertical2;
                    boolean bl15 = bl12;
                    PaddingValues paddingValues2 = paddingValues;
                    LazyListState lazyListState2 = lazyListState;
                    Modifier modifier3 = modifier2;
                    boolean bl16 = false;
                    Function1 function1 = arg_0 -> ExtensionsScreenKt.ExtensionsScreen$lambda$19$lambda$18$lambda$17(musicExtensions$delegate, viewModel2, currentExtension$delegate, trackerExtensions$delegate, lyricsExtensions$delegate, arg_0);
                    modifier2 = modifier3;
                    lazyListState = lazyListState2;
                    paddingValues = paddingValues2;
                    bl12 = bl15;
                    vertical2 = vertical3;
                    horizontal = horizontal2;
                    flingBehavior = flingBehavior2;
                    bl13 = bl14;
                    overscrollEffect = overscrollEffect2;
                    Function1 value$iv = function1;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv2;
                }
                Function1 function1 = (Function1)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                LazyDslKt.LazyColumn((Modifier)modifier2, lazyListState, paddingValues, (boolean)bl12, vertical2, horizontal, flingBehavior, (boolean)bl13, overscrollEffect, (Function1)function1, (Composer)$composer4, (int)6, (int)510);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block27;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> ExtensionsScreenKt.ExtensionsScreen$lambda$20(viewModel2, $changed, n, arg_0, arg_1));
        }
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void SectionHeader(String title, Composer $composer, int $changed) {
        block5: {
            $composer = $composer.startRestartGroup(1349234862);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(SectionHeader)141@5932L10,143@6023L11,139@5874L248:ExtensionsScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed((Object)title) ? 4 : 2;
            }
            if ($composer.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1349234862, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SectionHeader (ExtensionsScreen.kt:138)");
                }
                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleSmall();
                FontWeight fontWeight = FontWeight.Companion.getBold();
                long l = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                int $this$dp$iv = 16;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 8;
                $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                TextKt.Text--4IGK_g((String)title, (Modifier)modifier, (long)l, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)(0x30030 | 0xE & $dirty), (int)0, (int)65496);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block5;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> ExtensionsScreenKt.SectionHeader$lambda$21(title, $changed, arg_0, arg_1));
        }
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void ExtensionItem(Metadata metadata2, boolean isActive, Function0<Unit> onActivate, Function0<Unit> onUninstall, Composer $composer, int $changed) {
        block10: {
            $composer = $composer.startRestartGroup(-2079072772);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(ExtensionItem)P(1)157@6402L181,161@6590L2487,155@6277L2800:ExtensionsScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)metadata2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed(isActive) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changedInstance(onActivate) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changedInstance(onUninstall) ? 2048 : 1024;
            }
            if ($composer.shouldExecute(($dirty & 0x493) != 1170, $dirty & 1)) {
                long l;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-2079072772, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionItem (ExtensionsScreen.kt:154)");
                }
                int $this$dp$iv = 16;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 4;
                $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                if (isActive) {
                    $composer.startReplaceGroup(-829129812);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"158@6471L11");
                    long l2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                    $composer.endReplaceGroup();
                    l = l2;
                } else {
                    $composer.startReplaceGroup(-829127382);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"159@6547L11");
                    long l3 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU();
                    $composer.endReplaceGroup();
                    l = l3;
                }
                CardKt.Card((Modifier)modifier, null, (CardColors)CardDefaults.INSTANCE.cardColors-ro_MJ88(l, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)-837565714, (boolean)true, (arg_0, arg_1, arg_2) -> ExtensionsScreenKt.ExtensionItem$lambda$25(metadata2, isActive, onActivate, onUninstall, arg_0, arg_1, arg_2), (Composer)$composer, (int)54)), (Composer)$composer, (int)196614, (int)26);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block10;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> ExtensionsScreenKt.ExtensionItem$lambda$26(metadata2, isActive, onActivate, onUninstall, $changed, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final List<MusicExtension> ExtensionsScreen$lambda$0(State<? extends List<MusicExtension>> $musicExtensions$delegate) {
        void $this$getValue$iv;
        State<? extends List<MusicExtension>> state = $musicExtensions$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List<TrackerExtension> ExtensionsScreen$lambda$1(State<? extends List<TrackerExtension>> $trackerExtensions$delegate) {
        void $this$getValue$iv;
        State<? extends List<TrackerExtension>> state = $trackerExtensions$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List<LyricsExtension> ExtensionsScreen$lambda$2(State<? extends List<LyricsExtension>> $lyricsExtensions$delegate) {
        void $this$getValue$iv;
        State<? extends List<LyricsExtension>> state = $lyricsExtensions$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final MusicExtension ExtensionsScreen$lambda$3(State<MusicExtension> $currentExtension$delegate) {
        void $this$getValue$iv;
        State<MusicExtension> state = $currentExtension$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (MusicExtension)$this$getValue$iv.getValue();
    }

    private static final Unit ExtensionsScreen$lambda$19$lambda$7$lambda$6$lambda$5$lambda$4() {
        return Unit.INSTANCE;
    }

    private static final Unit ExtensionsScreen$lambda$19$lambda$18$lambda$17(State $musicExtensions$delegate, ExtensionsViewModel $viewModel, State $currentExtension$delegate, State $trackerExtensions$delegate, State $lyricsExtensions$delegate, LazyListScope $this$LazyColumn) {
        LazyListScope $this$items_u24default$iv;
        boolean $i$f$items;
        Function1 contentType$iv;
        Object key$iv;
        List<Extension> items$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        if (!((Collection)ExtensionsScreenKt.ExtensionsScreen$lambda$0((State<? extends List<MusicExtension>>)$musicExtensions$delegate)).isEmpty()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$-1998342637$desktopApp(), (int)3, null);
            LazyListScope lazyListScope = $this$LazyColumn;
            items$iv = ExtensionsScreenKt.ExtensionsScreen$lambda$0((State<? extends List<MusicExtension>>)$musicExtensions$delegate);
            key$iv = null;
            contentType$iv = ExtensionsScreen$lambda$19$lambda$18$lambda$17$$inlined$items$default$1.INSTANCE;
            $i$f$items = false;
            $this$items_u24default$iv.items(items$iv.size(), null, (Function1)new Function1<Integer, Object>(contentType$iv, items$iv){
                final /* synthetic */ Function1 $contentType;
                final /* synthetic */ List $items;
                {
                    this.$contentType = $contentType;
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    return this.$contentType.invoke(this.$items.get(index));
                }
            }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $viewModel, $currentExtension$delegate){
                final /* synthetic */ List $items;
                final /* synthetic */ ExtensionsViewModel $viewModel$inlined;
                final /* synthetic */ State $currentExtension$delegate$inlined;
                {
                    this.$items = $items;
                    this.$viewModel$inlined = extensionsViewModel;
                    this.$currentExtension$delegate$inlined = state;
                }

                /*
                 * WARNING - void declaration
                 */
                @Composable
                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter((Object)$this$items, (String)"$this$items");
                    ComposerKt.sourceInformation((Composer)$composer, (String)"C178@8826L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed((Object)$this$items) ? 4 : 2;
                    }
                    if (($changed & 0x30) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if (($dirty & 0x93) != 146 || !$composer.getSkipping()) {
                        Object object;
                        Object object2;
                        Function0 value$iv;
                        Function0 function0;
                        Metadata metadata2;
                        boolean bl;
                        void $this$cache$iv;
                        Object object3;
                        void ext;
                        void $composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        int n = 0xE & $dirty;
                        Composer composer = $composer;
                        MusicExtension musicExtension = (MusicExtension)this.$items.get(it);
                        LazyItemScope $this$ExtensionsScreen_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417_u24lambda_u2410 = $this$items;
                        boolean bl2 = false;
                        $composer2.startReplaceGroup(-636867580);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"C*78@3355L34,79@3429L37,75@3168L320:ExtensionsScreen.kt#zg4hxr");
                        Metadata metadata3 = ext.getMetadata();
                        boolean bl3 = Intrinsics.areEqual((Object)ext.getMetadata().getId(), (object3 = ExtensionsScreenKt.access$ExtensionsScreen$lambda$3(this.$currentExtension$delegate$inlined)) != null && (object3 = ((MusicExtension)object3).getMetadata()) != null ? ((Metadata)object3).getId() : null);
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1544559071, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        void var11_11 = $composer2;
                        boolean invalid$iv = $composer2.changedInstance((Object)this.$viewModel$inlined) | $composer2.changedInstance((Object)ext);
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl4 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl5 = false;
                            function0 = (Function0)new Function0<Unit>(this.$viewModel$inlined, (MusicExtension)ext){
                                final /* synthetic */ ExtensionsViewModel $viewModel;
                                final /* synthetic */ MusicExtension $ext;
                                {
                                    this.$viewModel = $viewModel;
                                    this.$ext = $ext;
                                }

                                public final void invoke() {
                                    this.$viewModel.selectExtension(this.$ext);
                                }
                            };
                            metadata3 = metadata2;
                            bl3 = bl;
                            value$iv = function0;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv;
                        }
                        Function0 function02 = (Function0)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        Function0 function03 = function02;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1544556700, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        $this$cache$iv = $composer2;
                        invalid$iv = $composer2.changedInstance((Object)this.$viewModel$inlined) | $composer2.changedInstance((Object)ext);
                        $i$f$cache = false;
                        it$iv = $this$cache$iv.rememberedValue();
                        bl4 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function0 = function03;
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl6 = false;
                            Function0 function04 = (Function0)new Function0<Unit>(this.$viewModel$inlined, (MusicExtension)ext){
                                final /* synthetic */ ExtensionsViewModel $viewModel;
                                final /* synthetic */ MusicExtension $ext;
                                {
                                    this.$viewModel = $viewModel;
                                    this.$ext = $ext;
                                }

                                public final void invoke() {
                                    this.$viewModel.uninstall(this.$ext.getMetadata());
                                }
                            };
                            metadata3 = metadata2;
                            bl3 = bl;
                            function03 = function0;
                            value$iv = function04;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object = value$iv;
                        } else {
                            object = it$iv;
                        }
                        function02 = (Function0)object;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        ExtensionsScreenKt.access$ExtensionItem(metadata3, bl3, function03, function02, (Composer)$composer2, 0);
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        $composer.skipToGroupEnd();
                    }
                }
            }));
        }
        if (!((Collection)ExtensionsScreenKt.ExtensionsScreen$lambda$1((State<? extends List<TrackerExtension>>)$trackerExtensions$delegate)).isEmpty()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$352980746$desktopApp(), (int)3, null);
            $this$items_u24default$iv = $this$LazyColumn;
            items$iv = ExtensionsScreenKt.ExtensionsScreen$lambda$1((State<? extends List<TrackerExtension>>)$trackerExtensions$delegate);
            key$iv = null;
            contentType$iv = ExtensionsScreen$lambda$19$lambda$18$lambda$17$$inlined$items$default$5.INSTANCE;
            $i$f$items = false;
            $this$items_u24default$iv.items(items$iv.size(), null, (Function1)new Function1<Integer, Object>(contentType$iv, items$iv){
                final /* synthetic */ Function1 $contentType;
                final /* synthetic */ List $items;
                {
                    this.$contentType = $contentType;
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    return this.$contentType.invoke(this.$items.get(index));
                }
            }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $viewModel){
                final /* synthetic */ List $items;
                final /* synthetic */ ExtensionsViewModel $viewModel$inlined;
                {
                    this.$items = $items;
                    this.$viewModel$inlined = extensionsViewModel;
                }

                /*
                 * WARNING - void declaration
                 */
                @Composable
                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter((Object)$this$items, (String)"$this$items");
                    ComposerKt.sourceInformation((Composer)$composer, (String)"C178@8826L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed((Object)$this$items) ? 4 : 2;
                    }
                    if (($changed & 0x30) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if (($dirty & 0x93) != 146 || !$composer.getSkipping()) {
                        Object object;
                        Object object2;
                        Function0 function0;
                        Metadata metadata2;
                        boolean bl;
                        void $this$cache$iv;
                        void ext;
                        void $composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        int n = 0xE & $dirty;
                        Composer composer = $composer;
                        TrackerExtension trackerExtension = (TrackerExtension)this.$items.get(it);
                        LazyItemScope $this$ExtensionsScreen_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417_u24lambda_u2413 = $this$items;
                        boolean bl2 = false;
                        $composer2.startReplaceGroup(1003787980);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"C*90@3846L2,91@3888L37,87@3703L244:ExtensionsScreen.kt#zg4hxr");
                        Metadata metadata3 = ext.getMetadata();
                        boolean bl3 = false;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1833499909, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        void var11_11 = $composer2;
                        boolean invalid$iv = false;
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl4 = false;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl5 = false;
                            function0 = ExtensionsScreen.1.2.1.2.1.1.INSTANCE;
                            metadata3 = metadata2;
                            bl3 = bl;
                            Function0 value$iv = function0;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv;
                        }
                        Function0 function02 = (Function0)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        Function0 function03 = function02;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1833501288, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        $this$cache$iv = $composer2;
                        invalid$iv = $composer2.changedInstance((Object)this.$viewModel$inlined) | $composer2.changedInstance((Object)ext);
                        $i$f$cache = false;
                        it$iv = $this$cache$iv.rememberedValue();
                        bl4 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function0 = function03;
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl6 = false;
                            Function0 function04 = (Function0)new Function0<Unit>(this.$viewModel$inlined, (TrackerExtension)ext){
                                final /* synthetic */ ExtensionsViewModel $viewModel;
                                final /* synthetic */ TrackerExtension $ext;
                                {
                                    this.$viewModel = $viewModel;
                                    this.$ext = $ext;
                                }

                                public final void invoke() {
                                    this.$viewModel.uninstall(this.$ext.getMetadata());
                                }
                            };
                            metadata3 = metadata2;
                            bl3 = bl;
                            function03 = function0;
                            Function0 value$iv = function04;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object = value$iv;
                        } else {
                            object = it$iv;
                        }
                        function02 = (Function0)object;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        ExtensionsScreenKt.access$ExtensionItem(metadata3, bl3, function03, function02, (Composer)$composer2, 432);
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        $composer.skipToGroupEnd();
                    }
                }
            }));
        }
        if (!((Collection)ExtensionsScreenKt.ExtensionsScreen$lambda$2((State<? extends List<LyricsExtension>>)$lyricsExtensions$delegate)).isEmpty()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$1906068107$desktopApp(), (int)3, null);
            $this$items_u24default$iv = $this$LazyColumn;
            items$iv = ExtensionsScreenKt.ExtensionsScreen$lambda$2((State<? extends List<LyricsExtension>>)$lyricsExtensions$delegate);
            key$iv = null;
            contentType$iv = ExtensionsScreen$lambda$19$lambda$18$lambda$17$$inlined$items$default$9.INSTANCE;
            $i$f$items = false;
            $this$items_u24default$iv.items(items$iv.size(), null, (Function1)new Function1<Integer, Object>(contentType$iv, items$iv){
                final /* synthetic */ Function1 $contentType;
                final /* synthetic */ List $items;
                {
                    this.$contentType = $contentType;
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    return this.$contentType.invoke(this.$items.get(index));
                }
            }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $viewModel){
                final /* synthetic */ List $items;
                final /* synthetic */ ExtensionsViewModel $viewModel$inlined;
                {
                    this.$items = $items;
                    this.$viewModel$inlined = extensionsViewModel;
                }

                /*
                 * WARNING - void declaration
                 */
                @Composable
                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter((Object)$this$items, (String)"$this$items");
                    ComposerKt.sourceInformation((Composer)$composer, (String)"C178@8826L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed((Object)$this$items) ? 4 : 2;
                    }
                    if (($changed & 0x30) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if (($dirty & 0x93) != 146 || !$composer.getSkipping()) {
                        Object object;
                        Object object2;
                        Function0 function0;
                        Metadata metadata2;
                        boolean bl;
                        void $this$cache$iv;
                        void ext;
                        void $composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        int n = 0xE & $dirty;
                        Composer composer = $composer;
                        LyricsExtension lyricsExtension = (LyricsExtension)this.$items.get(it);
                        LazyItemScope $this$ExtensionsScreen_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417_u24lambda_u2416 = $this$items;
                        boolean bl2 = false;
                        $composer2.startReplaceGroup(-331483297);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"C*102@4302L2,103@4344L37,99@4159L244:ExtensionsScreen.kt#zg4hxr");
                        Metadata metadata3 = ext.getMetadata();
                        boolean bl3 = false;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1790426642, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        void var11_11 = $composer2;
                        boolean invalid$iv = false;
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl4 = false;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl5 = false;
                            function0 = ExtensionsScreen.1.2.1.3.1.1.INSTANCE;
                            metadata3 = metadata2;
                            bl3 = bl;
                            Function0 value$iv = function0;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv;
                        }
                        Function0 function02 = (Function0)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        Function0 function03 = function02;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1790428021, (String)"CC(remember):ExtensionsScreen.kt#9igjgp");
                        $this$cache$iv = $composer2;
                        invalid$iv = $composer2.changedInstance((Object)this.$viewModel$inlined) | $composer2.changedInstance((Object)ext);
                        $i$f$cache = false;
                        it$iv = $this$cache$iv.rememberedValue();
                        bl4 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function0 = function03;
                            bl = bl3;
                            metadata2 = metadata3;
                            boolean bl6 = false;
                            Function0 function04 = (Function0)new Function0<Unit>(this.$viewModel$inlined, (LyricsExtension)ext){
                                final /* synthetic */ ExtensionsViewModel $viewModel;
                                final /* synthetic */ LyricsExtension $ext;
                                {
                                    this.$viewModel = $viewModel;
                                    this.$ext = $ext;
                                }

                                public final void invoke() {
                                    this.$viewModel.uninstall(this.$ext.getMetadata());
                                }
                            };
                            metadata3 = metadata2;
                            bl3 = bl;
                            function03 = function0;
                            Function0 value$iv = function04;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object = value$iv;
                        } else {
                            object = it$iv;
                        }
                        function02 = (Function0)object;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        ExtensionsScreenKt.access$ExtensionItem(metadata3, bl3, function03, function02, (Composer)$composer2, 432);
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        $composer.skipToGroupEnd();
                    }
                }
            }));
        }
        if (ExtensionsScreenKt.ExtensionsScreen$lambda$0((State<? extends List<MusicExtension>>)$musicExtensions$delegate).isEmpty() && ExtensionsScreenKt.ExtensionsScreen$lambda$1((State<? extends List<TrackerExtension>>)$trackerExtensions$delegate).isEmpty() && ExtensionsScreenKt.ExtensionsScreen$lambda$2((State<? extends List<LyricsExtension>>)$lyricsExtensions$delegate).isEmpty()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$-835811828$desktopApp(), (int)3, null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ExtensionsScreen$lambda$20(ExtensionsViewModel $viewModel, int $$changed, int $$default, Composer $composer, int $force) {
        ExtensionsScreenKt.ExtensionsScreen($viewModel, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit SectionHeader$lambda$21(String $title, int $$changed, Composer $composer, int $force) {
        ExtensionsScreenKt.SectionHeader($title, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit ExtensionItem$lambda$25(Metadata $metadata, boolean $isActive, Function0 $onActivate, Function0 $onUninstall, ColumnScope $this$Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Card, (String)"$this$Card");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C162@6600L2471:ExtensionsScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $composer$iv;
            String iconUrl;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv2;
            void $changed$iv;
            void verticalAlignment$iv;
            void horizontalArrangement$iv;
            void $composer$iv2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-837565714, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ExtensionItem.<anonymous> (ExtensionsScreen.kt:162)");
            }
            int $this$dp$iv = 12;
            boolean $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            int $this$dp$iv22 = 12;
            boolean $i$f$getDp22 = false;
            Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv22));
            Modifier $this$dp$iv22 = modifier;
            Arrangement.Horizontal $i$f$getDp22 = (Arrangement.Horizontal)horizontalOrVertical;
            Alignment.Vertical vertical2 = vertical;
            Composer composer = $composer;
            int n = 438;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var17_21 = modifier$iv2;
            int n2 = 0x70 & $changed$iv << 3;
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
            int n5 = 6 | 0x70 & $changed$iv >> 6;
            void var36_40 = $composer$iv3;
            RowScope $this$ExtensionItem_u24lambda_u2425_u24lambda_u2424 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)335642849, (String)"C187@7648L829,219@8838L223:ExtensionsScreen.kt#zg4hxr");
            ImageHolder icon = $metadata.getIcon();
            String string2 = icon instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)icon).getRequest().getUrl() : (iconUrl = icon instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)icon).getUri() : null);
            if (iconUrl != null) {
                $composer3.startReplaceGroup(335920825);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"173@7166L215");
                $this$dp$iv = 40;
                $i$f$getDp = false;
                Modifier modifier2 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
                $this$dp$iv = 8;
                $i$f$getDp = false;
                SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)iconUrl, (String)($metadata.getName() + " icon"), (Modifier)ClipKt.clip((Modifier)modifier2, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv)))), null, null, null, null, (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer3, (int)0, (int)0, (int)2040);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(336170747);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"179@7419L181");
                $this$dp$iv = 40;
                $i$f$getDp = false;
                IconKt.Icon-ww6aTOc((ImageVector)ExtensionKt.getExtension((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)0L, (Composer)$composer3, (int)432, (int)8);
                $composer3.endReplaceGroup();
            }
            Modifier $this$dp$iv3 = RowScope.weight$default((RowScope)$this$ExtensionItem_u24lambda_u2425_u24lambda_u2424, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
            void var42_49 = $composer3;
            int $changed$iv2 = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var47_54 = modifier$iv;
            int n6 = 0x70 & $changed$iv2 << 3;
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
            int n9 = 6 | 0x70 & $changed$iv2 >> 6;
            void var66_73 = $composer$iv4;
            ColumnScope $this$ExtensionItem_u24lambda_u2425_u24lambda_u2424_u24lambda_u2423 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)304497306, (String)"C190@7784L10,188@7694L182,195@8027L10,196@8091L11,193@7893L244:ExtensionsScreen.kt#zg4hxr");
            Object object = $metadata.getName();
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyLarge();
            FontWeight fontWeight = FontWeight.Companion.getSemiBold();
            TextKt.Text--4IGK_g((String)object, null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196608, (int)0, (int)65502);
            String string3 = $metadata.getVersion();
            String string4 = $metadata.getAuthor();
            if (string4 == null) {
                string4 = "Unknown";
            }
            object = "v" + string3 + " by " + string4;
            textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)object, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
            object = $metadata.getDescription();
            if (object == null) {
                $composer2.startReplaceGroup(304960506);
                $composer2.endReplaceGroup();
                v4 = null;
            } else {
                $composer2.startReplaceGroup(304960507);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"*201@8289L10,202@8357L11,199@8202L243");
                Object it = object;
                boolean bl8 = false;
                TextStyle textStyle2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)it, null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)2, (int)0, null, (TextStyle)textStyle2, (Composer)$composer2, (int)0, (int)3072, (int)57338);
                $composer2.endReplaceGroup();
                v4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            if (!$isActive) {
                $composer3.startReplaceGroup(337285476);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"210@8547L44");
                ButtonKt.Button((Function0)$onActivate, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$533450644$desktopApp(), (Composer)$composer3, (int)0x30000000, (int)510);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(337371067);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"214@8707L10,215@8773L11,212@8629L181");
                TextStyle textStyle3 = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelMedium();
                long l3 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                TextKt.Text--4IGK_g((String)"Active", null, (long)l3, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle3, (Composer)$composer3, (int)6, (int)0, (int)65530);
                $composer3.endReplaceGroup();
            }
            IconButtonKt.IconButton((Function0)$onUninstall, null, (boolean)false, null, null, ComposableSingletons$ExtensionsScreenKt.INSTANCE.getLambda$-711551377$desktopApp(), (Composer)$composer3, (int)196608, (int)30);
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

    private static final Unit ExtensionItem$lambda$26(Metadata $metadata, boolean $isActive, Function0 $onActivate, Function0 $onUninstall, int $$changed, Composer $composer, int $force) {
        ExtensionsScreenKt.ExtensionItem($metadata, $isActive, (Function0<Unit>)$onActivate, (Function0<Unit>)$onUninstall, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$SectionHeader(String title, Composer $composer, int $changed) {
        ExtensionsScreenKt.SectionHeader(title, $composer, $changed);
    }

    public static final /* synthetic */ void access$ExtensionItem(Metadata metadata2, boolean isActive, Function0 onActivate, Function0 onUninstall, Composer $composer, int $changed) {
        ExtensionsScreenKt.ExtensionItem(metadata2, isActive, (Function0<Unit>)onActivate, (Function0<Unit>)onUninstall, $composer, $changed);
    }

    public static final /* synthetic */ MusicExtension access$ExtensionsScreen$lambda$3(State $currentExtension$delegate) {
        return ExtensionsScreenKt.ExtensionsScreen$lambda$3((State<MusicExtension>)$currentExtension$delegate);
    }
}

