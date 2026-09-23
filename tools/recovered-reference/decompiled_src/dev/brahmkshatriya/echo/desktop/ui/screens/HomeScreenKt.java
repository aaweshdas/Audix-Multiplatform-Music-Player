/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.OverscrollEffect
 *  androidx.compose.foundation.gestures.FlingBehavior
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.PaddingValues
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.lazy.LazyDslKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.foundation.lazy.LazyListScope
 *  androidx.compose.foundation.lazy.LazyListState
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.ProgressIndicatorKt
 *  androidx.compose.material3.TabKt
 *  androidx.compose.material3.TabRowKt
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
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
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
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TabKt;
import androidx.compose.material3.TabRowKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRowKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreenKt$HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18$;
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchAndOthersKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.HomeViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n\u00b2\u0006\u0012\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u008a\u0084\u0002\u00b2\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002"}, d2={"HomeScreen", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/HomeViewModel;", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onMediaSelected", "Lkotlin/Function1;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/HomeViewModel;Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "desktopApp", "feed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "shelves", "", "isLoading", "", "error", "", "selectedTab", "Ldev/brahmkshatriya/echo/common/models/Tab;"})
@SourceDebugExtension(value={"SMAP\nHomeScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/HomeScreenKt\n+ 2 Inject.kt\norg/koin/compose/InjectKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 9 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 10 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 11 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 12 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,95:1\n88#2,4:96\n92#2:103\n88#2,4:107\n92#2:114\n1247#3,3:100\n1250#3,3:104\n1247#3,3:111\n1250#3,3:115\n1247#3,6:118\n1247#3,6:206\n1247#3,6:213\n1247#3,6:234\n87#4:124\n84#4,9:125\n94#4:227\n79#5,6:134\n86#5,3:149\n89#5,2:158\n79#5,6:179\n86#5,3:194\n89#5,2:203\n93#5:222\n93#5:226\n347#6,9:140\n356#6:160\n347#6,9:185\n356#6:205\n357#6,2:220\n357#6,2:224\n4206#7,6:152\n4206#7,6:197\n360#8,7:161\n1869#8:233\n1870#8:240\n113#9:168\n113#9:212\n113#9:219\n70#10:169\n67#10,9:170\n77#10:223\n85#11:228\n85#11:229\n85#11:230\n85#11:231\n85#11:232\n168#12,13:241\n*S KotlinDebug\n*F\n+ 1 HomeScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/HomeScreenKt\n*L\n31#1:96,4\n31#1:103\n32#1:107,4\n32#1:114\n31#1:100,3\n31#1:104,3\n32#1:111,3\n32#1:115,3\n33#1:118,6\n67#1:206,6\n73#1:213,6\n53#1:234,6\n41#1:124\n41#1:125,9\n41#1:227\n41#1:134,6\n41#1:149,3\n41#1:158,2\n61#1:179,6\n61#1:194,3\n61#1:203,2\n61#1:222\n41#1:226\n41#1:140,9\n41#1:160\n61#1:185,9\n61#1:205\n61#1:220,2\n41#1:224,2\n41#1:152,6\n61#1:197,6\n46#1:161,7\n50#1:233\n50#1:240\n48#1:168\n72#1:212\n86#1:219\n61#1:169\n61#1:170,9\n61#1:223\n35#1:228\n36#1:229\n37#1:230\n38#1:231\n39#1:232\n74#1:241,13\n*E\n"})
public final class HomeScreenKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void HomeScreen(@Nullable HomeViewModel viewModel2, @Nullable PlayerViewModel playerViewModel, @Nullable Function1<? super EchoMediaItem, Unit> onMediaSelected, @Nullable Composer $composer, int $changed, int n) {
        block45: {
            $composer = $composer.startRestartGroup(-243487746);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(HomeScreen)P(2,1)34@1481L16,35@1535L16,36@1593L16,37@1643L16,38@1705L16,40@1727L2146:HomeScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= (n & 1) == 0 && $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= (n & 2) == 0 && $composer.changedInstance((Object)playerViewModel) ? 32 : 16;
            }
            if ((n & 4) != 0) {
                $dirty |= 0x180;
            } else if (($changed & 0x180) == 0) {
                $dirty |= $composer.changedInstance(onMediaSelected) ? 256 : 128;
            }
            if ($composer.shouldExecute(($dirty & 0x93) != 146, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $composer$iv;
                Iterator<Tab> iterator;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $composer$iv2;
                Object object;
                Object it$iv$iv;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"30@1329L12,31@1382L12,32@1443L2");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    Object object2;
                    Object value$iv$iv;
                    boolean bl;
                    boolean bl2;
                    Composer $this$cache$iv$iv;
                    boolean $i$f$cache;
                    boolean invalid$iv$iv;
                    Composer scope$iv;
                    Function1 qualifier$iv;
                    Composer $composer$iv3;
                    boolean $i$f$koinInject;
                    boolean $changed$iv;
                    if ((n & 1) != 0) {
                        Object object3;
                        Composer composer = $composer;
                        $changed$iv = false;
                        $i$f$koinInject = false;
                        $composer$iv3.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv3, (int)0);
                        $composer$iv3.startReplaceGroup(-1633490746);
                        Composer composer2 = $composer$iv3;
                        invalid$iv$iv = $composer$iv3.changed(qualifier$iv) | $composer$iv3.changed((Object)scope$iv);
                        $i$f$cache = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl2 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(HomeViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object3 = value$iv$iv;
                        } else {
                            object3 = it$iv$iv;
                        }
                        object = object3;
                        $composer$iv3.endReplaceGroup();
                        object2 = object;
                        $composer$iv3.endReplaceGroup();
                        viewModel2 = (HomeViewModel)object2;
                        $dirty &= 0xFFFFFFF1;
                    }
                    if ((n & 2) != 0) {
                        Object object4;
                        $composer$iv3 = $composer;
                        $changed$iv = false;
                        $i$f$koinInject = false;
                        $composer$iv3.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv3, (int)0);
                        $composer$iv3.startReplaceGroup(-1633490746);
                        $this$cache$iv$iv = $composer$iv3;
                        invalid$iv$iv = $composer$iv3.changed(qualifier$iv) | $composer$iv3.changed((Object)scope$iv);
                        $i$f$cache = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl2 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(PlayerViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object4 = value$iv$iv;
                        } else {
                            object4 = it$iv$iv;
                        }
                        object = object4;
                        $composer$iv3.endReplaceGroup();
                        object2 = object;
                        $composer$iv3.endReplaceGroup();
                        playerViewModel = (PlayerViewModel)object2;
                        $dirty &= 0xFFFFFF8F;
                    }
                    if ((n & 4) != 0) {
                        Object object5;
                        void $this$cache$iv;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-2063484384, (String)"CC(remember):HomeScreen.kt#9igjgp");
                        scope$iv = $composer;
                        boolean invalid$iv = false;
                        boolean $i$f$cache2 = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl3 = false;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            boolean bl4 = false;
                            Function1 value$iv = HomeScreenKt::HomeScreen$lambda$1$lambda$0;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object5 = value$iv;
                        } else {
                            object5 = it$iv;
                        }
                        qualifier$iv = (Function1)object5;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                        onMediaSelected = qualifier$iv;
                    }
                } else {
                    $composer.skipToGroupEnd();
                    if ((n & 1) != 0) {
                        $dirty &= 0xFFFFFFF1;
                    }
                    if ((n & 2) != 0) {
                        $dirty &= 0xFFFFFF8F;
                    }
                }
                $composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-243487746, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreen (HomeScreen.kt:33)");
                }
                State feed$delegate = SnapshotStateKt.collectAsState(viewModel2.getFeed(), null, (Composer)$composer, (int)0, (int)1);
                State shelves$delegate = SnapshotStateKt.collectAsState(viewModel2.getShelves(), null, (Composer)$composer, (int)0, (int)1);
                State isLoading$delegate = SnapshotStateKt.collectAsState(viewModel2.isLoading(), null, (Composer)$composer, (int)0, (int)1);
                State error$delegate = SnapshotStateKt.collectAsState(viewModel2.getError(), null, (Composer)$composer, (int)0, (int)1);
                State selectedTab$delegate = SnapshotStateKt.collectAsState(viewModel2.getSelectedTab(), null, (Composer)$composer, (int)0, (int)1);
                Modifier bl3 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                it$iv$iv = $composer;
                int $changed$iv = 6;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                object = modifier$iv2;
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
                boolean bl5 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl6 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n4 = 0xE & $changed$iv$iv$iv2 >> 6;
                void $composer$iv4 = $composer$iv2;
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n5 = 6 | 0x70 & $changed$iv >> 6;
                void var38_49 = $composer$iv4;
                ColumnScope $this$HomeScreen_u24lambda_u2421 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1096545568, (String)"C60@2415L1452:HomeScreen.kt#zg4hxr");
                Feed<Shelf> feed2 = HomeScreenKt.HomeScreen$lambda$2((State<Feed<Shelf>>)feed$delegate);
                List<Tab> tabs = feed2 != null ? feed2.getTabs() : null;
                Collection collection = tabs;
                if (!(collection == null || collection.isEmpty())) {
                    int n6;
                    block44: {
                        $composer3.startReplaceGroup(1096554433);
                        ComposerKt.sourceInformation((Composer)$composer3, (String)"48@2088L288,44@1875L501");
                        List<Tab> $this$indexOfFirst$iv = tabs;
                        boolean $i$f$indexOfFirst = false;
                        int index$iv = 0;
                        iterator = $this$indexOfFirst$iv.iterator();
                        while (iterator.hasNext()) {
                            Tab item$iv;
                            Tab it = item$iv = iterator.next();
                            boolean bl9 = false;
                            if (Intrinsics.areEqual((Object)it, (Object)HomeScreenKt.HomeScreen$lambda$6((State<Tab>)selectedTab$delegate))) {
                                n6 = index$iv;
                                break block44;
                            }
                            ++index$iv;
                        }
                        n6 = -1;
                    }
                    int $this$dp$iv = 24;
                    boolean $i$f$getDp = false;
                    TabRowKt.ScrollableTabRow-sKfQg0A((int)RangesKt.coerceAtLeast((int)n6, (int)0), (Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (long)0L, (long)0L, (float)Dp.constructor-impl((float)$this$dp$iv), null, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-617406673, (boolean)true, (arg_0, arg_1) -> HomeScreenKt.HomeScreen$lambda$21$lambda$12(tabs, viewModel2, selectedTab$delegate, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)12607536, (int)108);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1094691054);
                    $composer3.endReplaceGroup();
                }
                Modifier $this$dp$iv = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                iterator = $composer3;
                int $changed$iv2 = 6;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                void var49_66 = modifier$iv;
                int n7 = 0x70 & $changed$iv2 << 3;
                boolean $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
                int n8 = 6 | 0x380 & $changed$iv$iv << 6;
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
                int n9 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv5 = $composer$iv;
                boolean bl10 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n10 = 6 | 0x70 & $changed$iv2 >> 6;
                void var68_85 = $composer$iv5;
                BoxScope $this$HomeScreen_u24lambda_u2421_u24lambda_u2420 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl11 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1557796847, (String)"C:HomeScreen.kt#zg4hxr");
                if (HomeScreenKt.HomeScreen$lambda$4((State<Boolean>)isLoading$delegate) && HomeScreenKt.HomeScreen$lambda$3((State<? extends List<? extends Shelf>>)shelves$delegate).isEmpty()) {
                    $composer2.startReplaceGroup(-1557780635);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"63@2536L59");
                    ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w((Modifier)$this$HomeScreen_u24lambda_u2421_u24lambda_u2420.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter()), (long)0L, (float)0.0f, (long)0L, (int)0, (Composer)$composer2, (int)0, (int)30);
                    $composer2.endReplaceGroup();
                } else if (HomeScreenKt.HomeScreen$lambda$5((State<? extends Throwable>)error$delegate) != null && HomeScreenKt.HomeScreen$lambda$3((State<? extends List<? extends Shelf>>)shelves$delegate).isEmpty()) {
                    Object object6;
                    void $this$cache$iv;
                    $composer2.startReplaceGroup(-1557628022);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"66@2719L24,66@2690L54");
                    Throwable throwable = HomeScreenKt.HomeScreen$lambda$5((State<? extends Throwable>)error$delegate);
                    Throwable throwable2 = throwable;
                    Intrinsics.checkNotNull((Object)throwable);
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1335228818, (String)"CC(remember):HomeScreen.kt#9igjgp");
                    void var71_88 = $composer2;
                    boolean invalid$iv = $composer.changedInstance((Object)viewModel2);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl12 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Throwable throwable3 = throwable2;
                        boolean bl13 = false;
                        throwable2 = throwable3;
                        Function0 value$iv = () -> HomeScreenKt.HomeScreen$lambda$21$lambda$20$lambda$14$lambda$13(viewModel2);
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object6 = value$iv;
                    } else {
                        object6 = it$iv;
                    }
                    Function0 function03 = (Function0)object6;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    SearchAndOthersKt.ErrorView(throwable2, (Function0<Unit>)function03, (Composer)$composer2, 0);
                    $composer2.endReplaceGroup();
                } else if (!((Collection)HomeScreenKt.HomeScreen$lambda$3((State<? extends List<? extends Shelf>>)shelves$delegate)).isEmpty()) {
                    Object object7;
                    void $this$cache$iv;
                    $composer2.startReplaceGroup(-1557478106);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"72@3013L382,69@2825L570");
                    Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                    LazyListState lazyListState = null;
                    int $this$dp$iv22 = 96;
                    boolean $i$f$getDp22 = false;
                    PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default((float)0.0f, (float)0.0f, (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv22), (int)7, null);
                    boolean bl14 = false;
                    Arrangement.Vertical vertical = null;
                    Alignment.Horizontal horizontal = null;
                    FlingBehavior flingBehavior = null;
                    boolean bl15 = false;
                    OverscrollEffect overscrollEffect = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1335238584, (String)"CC(remember):HomeScreen.kt#9igjgp");
                    void $i$f$getDp22 = $composer2;
                    boolean invalid$iv = $composer.changed((Object)shelves$delegate) | ($dirty & 0x380) == 256 | $composer.changedInstance((Object)playerViewModel);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl16 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        OverscrollEffect overscrollEffect2 = overscrollEffect;
                        boolean bl17 = bl15;
                        FlingBehavior flingBehavior2 = flingBehavior;
                        Alignment.Horizontal horizontal2 = horizontal;
                        Arrangement.Vertical vertical2 = vertical;
                        boolean bl18 = bl14;
                        PaddingValues paddingValues2 = paddingValues;
                        LazyListState lazyListState2 = lazyListState;
                        Modifier modifier2 = modifier;
                        boolean bl19 = false;
                        Function1 function1 = arg_0 -> HomeScreenKt.HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18(shelves$delegate, onMediaSelected, playerViewModel, arg_0);
                        modifier = modifier2;
                        lazyListState = lazyListState2;
                        paddingValues = paddingValues2;
                        bl14 = bl18;
                        vertical = vertical2;
                        horizontal = horizontal2;
                        flingBehavior = flingBehavior2;
                        bl15 = bl17;
                        overscrollEffect = overscrollEffect2;
                        Function1 value$iv = function1;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object7 = value$iv;
                    } else {
                        object7 = it$iv;
                    }
                    Function1 $this$dp$iv22 = (Function1)object7;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    LazyDslKt.LazyColumn((Modifier)modifier, lazyListState, (PaddingValues)paddingValues, (boolean)bl14, vertical, horizontal, flingBehavior, (boolean)bl15, overscrollEffect, (Function1)$this$dp$iv22, (Composer)$composer2, (int)390, (int)506);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1556854541);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"86@3707L11,87@3783L10,83@3460L365");
                    int $this$dp$iv2 = 32;
                    boolean $i$f$getDp = false;
                    TextKt.Text--4IGK_g((String)"No extension selected or feed is empty.\nGo to the Extensions tab to configure a music source.", (Modifier)PaddingKt.padding-3ABfNKs((Modifier)$this$HomeScreen_u24lambda_u2421_u24lambda_u2420.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter()), (float)Dp.constructor-impl((float)$this$dp$iv2)), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyLarge(), (Composer)$composer2, (int)6, (int)0, (int)65528);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block45;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> HomeScreenKt.HomeScreen$lambda$22(viewModel2, playerViewModel, onMediaSelected, $changed, n, arg_0, arg_1));
        }
    }

    private static final Unit HomeScreen$lambda$1$lambda$0(EchoMediaItem it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Feed<Shelf> HomeScreen$lambda$2(State<Feed<Shelf>> $feed$delegate) {
        void $this$getValue$iv;
        State<Feed<Shelf>> state = $feed$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Feed)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List<Shelf> HomeScreen$lambda$3(State<? extends List<? extends Shelf>> $shelves$delegate) {
        void $this$getValue$iv;
        State<? extends List<? extends Shelf>> state = $shelves$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean HomeScreen$lambda$4(State<Boolean> $isLoading$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isLoading$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final Throwable HomeScreen$lambda$5(State<? extends Throwable> $error$delegate) {
        void $this$getValue$iv;
        State<? extends Throwable> state = $error$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Throwable)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final Tab HomeScreen$lambda$6(State<Tab> $selectedTab$delegate) {
        void $this$getValue$iv;
        State<Tab> state = $selectedTab$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Tab)$this$getValue$iv.getValue();
    }

    private static final Unit HomeScreen$lambda$21$lambda$12$lambda$11$lambda$9$lambda$8(HomeViewModel $viewModel, Tab $tab) {
        $viewModel.selectTab($tab);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit HomeScreen$lambda$21$lambda$12$lambda$11$lambda$10(Tab $tab, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C53@2305L15:HomeScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)861584595, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (HomeScreen.kt:53)");
            }
            TextKt.Text--4IGK_g((String)$tab.getTitle(), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)0, (int)0, (int)131070);
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
    private static final Unit HomeScreen$lambda$21$lambda$12(List $tabs, HomeViewModel $viewModel, State $selectedTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C*52@2242L28,53@2303L19,50@2148L196:HomeScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-617406673, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.HomeScreen.<anonymous>.<anonymous> (HomeScreen.kt:49)");
            }
            Iterable $this$forEach$iv = $tabs;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                void $this$cache$iv;
                Tab tab = (Tab)element$iv;
                boolean bl = false;
                boolean bl2 = Intrinsics.areEqual((Object)tab, (Object)HomeScreenKt.HomeScreen$lambda$6((State<Tab>)$selectedTab$delegate));
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1014274647, (String)"CC(remember):HomeScreen.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = $composer.changedInstance((Object)$viewModel) | $composer.changedInstance((Object)tab);
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl3 = false;
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    boolean bl4 = bl2;
                    boolean bl5 = false;
                    Function0 function0 = () -> HomeScreenKt.HomeScreen$lambda$21$lambda$12$lambda$11$lambda$9$lambda$8($viewModel, tab);
                    bl2 = bl4;
                    Function0 value$iv = function0;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function0 function0 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                TabKt.Tab-wqdebIU((boolean)bl2, (Function0)function0, null, (boolean)false, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)861584595, (boolean)true, (arg_0, arg_1) -> HomeScreenKt.HomeScreen$lambda$21$lambda$12$lambda$11$lambda$10(tab, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, null, (Composer)$composer, (int)24576, (int)492);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit HomeScreen$lambda$21$lambda$20$lambda$14$lambda$13(HomeViewModel $viewModel) {
        HomeViewModel.loadFeed$default($viewModel, null, 1, null);
        return Unit.INSTANCE;
    }

    private static final Object HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$15(Shelf it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getId();
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18(State $shelves$delegate, Function1 $onMediaSelected, PlayerViewModel $playerViewModel, LazyListScope $this$LazyColumn) {
        void items$iv;
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        LazyListScope lazyListScope = $this$LazyColumn;
        List<Shelf> list2 = HomeScreenKt.HomeScreen$lambda$3((State<? extends List<? extends Shelf>>)$shelves$delegate);
        Function1 key$iv = HomeScreenKt::HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18$lambda$15;
        Function1 contentType$iv = HomeScreen$lambda$21$lambda$20$lambda$19$lambda$18$$inlined$items$default$1.INSTANCE;
        boolean $i$f$items = false;
        $this$items_u24default$iv.items(items$iv.size(), key$iv != null ? (Function1)new Function1<Integer, Object>(key$iv, (List)items$iv){
            final /* synthetic */ Function1 $key;
            final /* synthetic */ List $items;
            {
                this.$key = $key;
                this.$items = $items;
            }

            public final Object invoke(int index) {
                return this.$key.invoke(this.$items.get(index));
            }
        } : null, (Function1)new Function1<Integer, Object>(contentType$iv, (List)items$iv){
            final /* synthetic */ Function1 $contentType;
            final /* synthetic */ List $items;
            {
                this.$contentType = $contentType;
                this.$items = $items;
            }

            public final Object invoke(int index) {
                return this.$contentType.invoke(this.$items.get(index));
            }
        }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>((List)items$iv, $onMediaSelected, $playerViewModel){
            final /* synthetic */ List $items;
            final /* synthetic */ Function1 $onMediaSelected$inlined;
            final /* synthetic */ PlayerViewModel $playerViewModel$inlined;
            {
                this.$items = $items;
                this.$onMediaSelected$inlined = function1;
                this.$playerViewModel$inlined = playerViewModel;
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
                    void $changed2;
                    Object object;
                    void $this$cache$iv;
                    void shelf;
                    void $composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int n = 0xE & $dirty;
                    Composer composer = $composer;
                    Shelf shelf2 = (Shelf)this.$items.get(it);
                    LazyItemScope $this$HomeScreen_u24lambda_u2421_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418_u24lambda_u2417 = $this$items;
                    boolean bl = false;
                    $composer2.startReplaceGroup(-693591645);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"C*77@3277L40,74@3110L237:HomeScreen.kt#zg4hxr");
                    void v0 = shelf;
                    Function1 function1 = this.$onMediaSelected$inlined;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)116178555, (String)"CC(remember):HomeScreen.kt#9igjgp");
                    void var11_11 = $composer2;
                    boolean invalid$iv = $composer2.changedInstance((Object)this.$playerViewModel$inlined);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl2 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Function1 function12 = function1;
                        void var17_17 = v0;
                        boolean bl3 = false;
                        Function1 function13 = (Function1)new Function1<Track, Unit>(this.$playerViewModel$inlined){
                            final /* synthetic */ PlayerViewModel $playerViewModel;
                            {
                                this.$playerViewModel = $playerViewModel;
                            }

                            public final void invoke(Track track2) {
                                Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
                                this.$playerViewModel.play(track2);
                            }
                        };
                        v0 = var17_17;
                        function1 = function12;
                        Function1 value$iv = function13;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object = value$iv;
                    } else {
                        object = it$iv;
                    }
                    Function1 function14 = (Function1)object;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    ShelfRowKt.ShelfRow((Shelf)v0, (Function1<? super EchoMediaItem, Unit>)function1, (Function1<? super Track, Unit>)function14, null, null, (Composer)$composer2, 0xE & $changed2 >> 3, 24);
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    $composer.skipToGroupEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    private static final Unit HomeScreen$lambda$22(HomeViewModel $viewModel, PlayerViewModel $playerViewModel, Function1 $onMediaSelected, int $$changed, int $$default, Composer $composer, int $force) {
        HomeScreenKt.HomeScreen($viewModel, $playerViewModel, (Function1<? super EchoMediaItem, Unit>)$onMediaSelected, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }
}

