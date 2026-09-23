/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.OverscrollEffect
 *  androidx.compose.foundation.gestures.FlingBehavior
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
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
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.DownloadKt
 *  androidx.compose.material.icons.filled.LibraryMusicKt
 *  androidx.compose.material.icons.filled.SearchKt
 *  androidx.compose.material.icons.filled.SettingsKt
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.IconButtonKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.ListItemKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.ProgressIndicatorKt
 *  androidx.compose.material3.SearchBarDefaults
 *  androidx.compose.material3.SearchBarKt
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
 *  androidx.compose.runtime.MutableState
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
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.semantics.Role
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.unit.Dp
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
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.koin.compose.KoinApplicationKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 */
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DownloadKt;
import androidx.compose.material.icons.filled.LibraryMusicKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SearchBarDefaults;
import androidx.compose.material3.SearchBarKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.QuickSearchItem;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRowKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$SearchAndOthersKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchAndOthersKt$SearchScreen$lambda$45$lambda$29$lambda$28$lambda$27$lambda$26$;
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchAndOthersKt$SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41$;
import dev.brahmkshatriya.echo.desktop.viewmodel.DownloadsViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.LibraryViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.SearchViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.SettingsViewModel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u00a2\u0006\u0002\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u000eH\u0007\u00a2\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0011H\u0007\u00a2\u0006\u0002\u0010\u0012\u001a#\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0007\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019\u00b2\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u008a\u0084\u0002\u00b2\u0006\u0012\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u008a\u0084\u0002\u00b2\u0006\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001dX\u008a\u0084\u0002\u00b2\u0006\f\u0010#\u001a\u0004\u0018\u00010$X\u008a\u0084\u0002\u00b2\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002\u00b2\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002\u00b2\u0006\n\u0010'\u001a\u00020&X\u008a\u008e\u0002"}, d2={"SearchScreen", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/SearchViewModel;", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onMediaSelected", "Lkotlin/Function1;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/SearchViewModel;Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LibraryScreen", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LibraryViewModel;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/LibraryViewModel;Landroidx/compose/runtime/Composer;II)V", "DownloadsScreen", "Ldev/brahmkshatriya/echo/desktop/viewmodel/DownloadsViewModel;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/DownloadsViewModel;Landroidx/compose/runtime/Composer;II)V", "SettingsScreen", "Ldev/brahmkshatriya/echo/desktop/viewmodel/SettingsViewModel;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/SettingsViewModel;Landroidx/compose/runtime/Composer;II)V", "ErrorView", "error", "", "onRetry", "Lkotlin/Function0;", "(Ljava/lang/Throwable;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "query", "", "quickResults", "", "Ldev/brahmkshatriya/echo/common/models/QuickSearchItem;", "searchFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "shelves", "selectedTab", "Ldev/brahmkshatriya/echo/common/models/Tab;", "isLoading", "", "expanded"})
@SourceDebugExtension(value={"SMAP\nSearchAndOthers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchAndOthers.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthersKt\n+ 2 Inject.kt\norg/koin/compose/InjectKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 9 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 11 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 12 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,233:1\n88#2,4:234\n92#2:241\n88#2,4:245\n92#2:252\n88#2,4:457\n92#2:464\n88#2,4:506\n92#2:513\n88#2,4:555\n92#2:562\n1247#3,3:238\n1250#3,3:242\n1247#3,3:249\n1250#3,3:253\n1247#3,6:256\n1247#3,6:262\n1247#3,6:343\n1247#3,6:398\n1247#3,6:405\n1247#3,3:461\n1250#3,3:465\n1247#3,3:510\n1250#3,3:514\n1247#3,3:559\n1250#3,3:563\n1247#3,6:652\n1247#3,6:658\n1247#3,6:664\n1247#3,6:670\n1247#3,6:689\n1247#3,6:696\n87#4:268\n84#4,9:269\n87#4,6:412\n94#4:448\n94#4:456\n87#4,6:469\n94#4:505\n87#4,6:518\n94#4:554\n87#4,6:567\n94#4:603\n87#4,6:605\n94#4:641\n79#5,6:278\n86#5,3:293\n89#5,2:302\n79#5,6:316\n86#5,3:331\n89#5,2:340\n93#5:351\n79#5,6:371\n86#5,3:386\n89#5,2:395\n79#5,6:418\n86#5,3:433\n89#5,2:442\n93#5:447\n93#5:451\n93#5:455\n79#5,6:475\n86#5,3:490\n89#5,2:499\n93#5:504\n79#5,6:524\n86#5,3:539\n89#5,2:548\n93#5:553\n79#5,6:573\n86#5,3:588\n89#5,2:597\n93#5:602\n79#5,6:611\n86#5,3:626\n89#5,2:635\n93#5:640\n347#6,9:284\n356#6:304\n347#6,9:322\n356#6:342\n357#6,2:349\n347#6,9:377\n356#6:397\n347#6,9:424\n356#6,3:444\n357#6,2:449\n357#6,2:453\n347#6,9:481\n356#6,3:501\n347#6,9:530\n356#6,3:550\n347#6,9:579\n356#6,3:599\n347#6,9:617\n356#6,3:637\n4206#7,6:296\n4206#7,6:334\n4206#7,6:389\n4206#7,6:436\n4206#7,6:493\n4206#7,6:542\n4206#7,6:591\n4206#7,6:629\n113#8:305\n113#8:360\n113#8:404\n113#8:411\n113#8:468\n113#8:517\n113#8:566\n113#8:604\n70#9:306\n67#9,9:307\n77#9:352\n70#9:361\n67#9,9:362\n77#9:452\n360#10,7:353\n1869#10:695\n1870#10:702\n85#11:642\n85#11:643\n85#11:644\n85#11:645\n85#11:646\n85#11:647\n85#11:648\n85#11:649\n113#11,2:650\n168#12,13:676\n168#12,13:703\n*S KotlinDebug\n*F\n+ 1 SearchAndOthers.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthersKt\n*L\n52#1:234,4\n52#1:241\n53#1:245,4\n53#1:252\n175#1:457,4\n175#1:464\n191#1:506,4\n191#1:513\n207#1:555,4\n207#1:562\n52#1:238,3\n52#1:242,3\n53#1:249,3\n53#1:253,3\n54#1:256,6\n64#1:262,6\n92#1:343,6\n135#1:398,6\n141#1:405,6\n175#1:461,3\n175#1:465,3\n191#1:510,3\n191#1:514,3\n207#1:559,3\n207#1:563,3\n84#1:652,6\n73#1:658,6\n74#1:664,6\n79#1:670,6\n96#1:689,6\n121#1:696,6\n66#1:268\n66#1:269,9\n152#1:412,6\n152#1:448\n66#1:456\n176#1:469,6\n176#1:505\n192#1:518,6\n192#1:554\n208#1:567,6\n208#1:603\n224#1:605,6\n224#1:641\n66#1:278,6\n66#1:293,3\n66#1:302,2\n68#1:316,6\n68#1:331,3\n68#1:340,2\n68#1:351\n129#1:371,6\n129#1:386,3\n129#1:395,2\n152#1:418,6\n152#1:433,3\n152#1:442,2\n152#1:447\n129#1:451\n66#1:455\n176#1:475,6\n176#1:490,3\n176#1:499,2\n176#1:504\n192#1:524,6\n192#1:539,3\n192#1:548,2\n192#1:553\n208#1:573,6\n208#1:588,3\n208#1:597,2\n208#1:602\n224#1:611,6\n224#1:626,3\n224#1:635,2\n224#1:640\n66#1:284,9\n66#1:304\n68#1:322,9\n68#1:342\n68#1:349,2\n129#1:377,9\n129#1:397\n152#1:424,9\n152#1:444,3\n129#1:449,2\n66#1:453,2\n176#1:481,9\n176#1:501,3\n192#1:530,9\n192#1:550,3\n208#1:579,9\n208#1:599,3\n224#1:617,9\n224#1:637,3\n66#1:296,6\n68#1:334,6\n129#1:389,6\n152#1:436,6\n176#1:493,6\n192#1:542,6\n208#1:591,6\n224#1:629,6\n68#1:305\n116#1:360\n140#1:404\n155#1:411\n177#1:468\n193#1:517\n209#1:566\n225#1:604\n68#1:306\n68#1:307,9\n68#1:352\n129#1:361\n129#1:362,9\n129#1:452\n114#1:353,7\n118#1:695\n118#1:702\n56#1:642\n57#1:643\n58#1:644\n59#1:645\n60#1:646\n61#1:647\n62#1:648\n64#1:649\n64#1:650,2\n97#1:676,13\n142#1:703,13\n*E\n"})
public final class SearchAndOthersKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void SearchScreen(@Nullable SearchViewModel viewModel2, @Nullable PlayerViewModel playerViewModel, @Nullable Function1<? super EchoMediaItem, Unit> onMediaSelected, @Nullable Composer $composer, int $changed, int n) {
        block57: {
            $composer = $composer.startRestartGroup(-1008301453);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(SearchScreen)P(2,1)55@2559L16,56@2623L16,57@2683L16,58@2737L16,59@2799L16,60@2857L16,61@2907L16,63@2945L34,65@2985L4429:SearchAndOthers.kt#zg4hxr");
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
                Object object;
                Function1 value$iv;
                Object object2;
                void $this$cache$iv;
                void $composer222;
                void $changed$iv$iv$iv22;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $composer$iv2;
                void $composer3;
                void $changed$iv$iv$iv3;
                void $changed$iv$iv3;
                void modifier$iv$iv3;
                void modifier$iv3;
                void $composer$iv3;
                Object object3;
                void $this$cache$iv2;
                Object it$iv$iv;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"51@2405L12,52@2458L12,53@2519L2");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    Object object4;
                    Object object5;
                    Object value$iv$iv;
                    boolean bl;
                    boolean bl2;
                    Composer $this$cache$iv$iv;
                    boolean $i$f$cache;
                    boolean invalid$iv$iv;
                    Composer scope$iv;
                    Function1 qualifier$iv;
                    Composer $composer$iv4;
                    boolean $i$f$koinInject;
                    boolean $changed$iv;
                    if ((n & 1) != 0) {
                        Object object6;
                        Composer composer = $composer;
                        $changed$iv = false;
                        $i$f$koinInject = false;
                        $composer$iv4.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv4, (int)0);
                        $composer$iv4.startReplaceGroup(-1633490746);
                        Composer composer2 = $composer$iv4;
                        invalid$iv$iv = $composer$iv4.changed(qualifier$iv) | $composer$iv4.changed((Object)scope$iv);
                        $i$f$cache = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl2 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(SearchViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object6 = value$iv$iv;
                        } else {
                            object6 = it$iv$iv;
                        }
                        object5 = object6;
                        $composer$iv4.endReplaceGroup();
                        object4 = object5;
                        $composer$iv4.endReplaceGroup();
                        viewModel2 = (SearchViewModel)object4;
                        $dirty &= 0xFFFFFFF1;
                    }
                    if ((n & 2) != 0) {
                        Object object7;
                        $composer$iv4 = $composer;
                        $changed$iv = false;
                        $i$f$koinInject = false;
                        $composer$iv4.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv4, (int)0);
                        $composer$iv4.startReplaceGroup(-1633490746);
                        $this$cache$iv$iv = $composer$iv4;
                        invalid$iv$iv = $composer$iv4.changed(qualifier$iv) | $composer$iv4.changed((Object)scope$iv);
                        $i$f$cache = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl2 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(PlayerViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object7 = value$iv$iv;
                        } else {
                            object7 = it$iv$iv;
                        }
                        object5 = object7;
                        $composer$iv4.endReplaceGroup();
                        object4 = object5;
                        $composer$iv4.endReplaceGroup();
                        playerViewModel = (PlayerViewModel)object4;
                        $dirty &= 0xFFFFFF8F;
                    }
                    if ((n & 4) != 0) {
                        Object object8;
                        void $this$cache$iv3;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1684919509, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                        scope$iv = $composer;
                        boolean invalid$iv = false;
                        boolean $i$f$cache2 = false;
                        Object it$iv = $this$cache$iv3.rememberedValue();
                        boolean bl3 = false;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            boolean bl4 = false;
                            Function1 value$iv2 = SearchAndOthersKt::SearchScreen$lambda$1$lambda$0;
                            $this$cache$iv3.updateRememberedValue((Object)value$iv2);
                            object8 = value$iv2;
                        } else {
                            object8 = it$iv;
                        }
                        qualifier$iv = (Function1)object8;
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
                    ComposerKt.traceEventStart((int)-1008301453, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen (SearchAndOthers.kt:54)");
                }
                State query$delegate = SnapshotStateKt.collectAsState(viewModel2.getQuery(), null, (Composer)$composer, (int)0, (int)1);
                State quickResults$delegate = SnapshotStateKt.collectAsState(viewModel2.getQuickResults(), null, (Composer)$composer, (int)0, (int)1);
                State searchFeed$delegate = SnapshotStateKt.collectAsState(viewModel2.getSearchFeed(), null, (Composer)$composer, (int)0, (int)1);
                State shelves$delegate = SnapshotStateKt.collectAsState(viewModel2.getShelves(), null, (Composer)$composer, (int)0, (int)1);
                State selectedTab$delegate = SnapshotStateKt.collectAsState(viewModel2.getSelectedTab(), null, (Composer)$composer, (int)0, (int)1);
                State isLoading$delegate = SnapshotStateKt.collectAsState(viewModel2.isLoading(), null, (Composer)$composer, (int)0, (int)1);
                State error$delegate = SnapshotStateKt.collectAsState(viewModel2.getError(), null, (Composer)$composer, (int)0, (int)1);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1684933173, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache22 = false;
                Object it$iv = $this$cache$iv2.rememberedValue();
                boolean bl = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl5 = false;
                    MutableState value$iv3 = SnapshotStateKt.mutableStateOf$default((Object)false, null, (int)2, null);
                    $this$cache$iv2.updateRememberedValue((Object)value$iv3);
                    object3 = value$iv3;
                } else {
                    object3 = it$iv;
                }
                it$iv$iv = (MutableState)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                Object expanded$delegate = it$iv$iv;
                it$iv$iv = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                Composer $i$f$cache22 = $composer;
                int $changed$iv = 6;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var22_39 = modifier$iv3;
                int n2 = 0x70 & $changed$iv << 3;
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
                boolean bl6 = false;
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                boolean bl7 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl8 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n4 = 0xE & $changed$iv$iv$iv3 >> 6;
                void $composer$iv5 = $composer$iv3;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n5 = 6 | 0x70 & $changed$iv >> 6;
                void var41_58 = $composer$iv5;
                ColumnScope $this$SearchScreen_u24lambda_u2445 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl10 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1863355934, (String)"C67@3048L1814,128@5536L1872:SearchAndOthers.kt#zg4hxr");
                int $this$dp$iv = 24;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 16;
                $i$f$getDp = false;
                Modifier $this$dp$iv2 = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                void var46_67 = $composer3;
                int $changed$iv22 = 6;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Object contentAlignment$iv = Alignment.Companion.getTopStart();
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                void var51_80 = modifier$iv2;
                int n6 = 0x70 & $changed$iv22 << 3;
                int $i$f$Layout2 = 0;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
                int n7 = 6 | 0x380 & $changed$iv$iv2 << 6;
                int $i$f$ReusableComposeNode2 = 0;
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
                int n8 = 0xE & $changed$iv$iv$iv22 >> 6;
                void $composer$iv222 = $composer$iv2;
                boolean bl11 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv222, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n9 = 6 | 0x70 & $changed$iv22 >> 6;
                void var70_112 = $composer$iv222;
                BoxScope $this$SearchScreen_u24lambda_u2445_u24lambda_u2429 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl12 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer222, (int)-1802581479, (String)"C69@3183L1005,91@4262L17,93@4346L506,68@3137L1715:SearchAndOthers.kt#zg4hxr");
                Function2 function2 = (Function2)ComposableLambdaKt.rememberComposableLambda((int)-140069879, (boolean)true, (arg_0, arg_1) -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21(viewModel2, query$delegate, (MutableState)expanded$delegate, arg_0, arg_1), (Composer)$composer222, (int)54);
                boolean bl13 = SearchAndOthersKt.SearchScreen$lambda$10((MutableState<Boolean>)expanded$delegate);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer222, (int)-335208152, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                void var73_117 = $composer222;
                boolean invalid$iv22 = false;
                boolean $i$f$cache = false;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl14 = bl13;
                    object2 = function2;
                    boolean bl15 = false;
                    Function1 function1 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$23$lambda$22((MutableState)expanded$delegate, arg_0);
                    function2 = object2;
                    bl13 = bl14;
                    value$iv = function1;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv2;
                }
                Function1 function1 = (Function1)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer222);
                SearchBarKt.DockedSearchBar-EQC0FA8((Function2)function2, (boolean)bl13, (Function1)function1, (Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, null, (float)0.0f, (float)0.0f, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)854268321, (boolean)true, (arg_0, arg_1, arg_2) -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$28(quickResults$delegate, viewModel2, (MutableState)expanded$delegate, arg_0, arg_1, arg_2), (Composer)$composer222, (int)54)), (Composer)$composer222, (int)100666758, (int)240);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer222);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv222);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                Feed<Shelf> feed2 = SearchAndOthersKt.SearchScreen$lambda$4((State<Feed<Shelf>>)searchFeed$delegate);
                List<Tab> tabs = feed2 != null ? feed2.getTabs() : null;
                contentAlignment$iv = tabs;
                if (!(contentAlignment$iv == null || contentAlignment$iv.isEmpty())) {
                    int n10;
                    block56: {
                        $composer3.startReplaceGroup(1865148632);
                        ComposerKt.sourceInformation((Composer)$composer3, (String)"116@5202L288,112@4989L501");
                        List<Tab> $this$indexOfFirst$iv = tabs;
                        boolean $i$f$indexOfFirst = false;
                        int index$iv = 0;
                        Iterator<Tab> $changed$iv22 = $this$indexOfFirst$iv.iterator();
                        while ($changed$iv22.hasNext()) {
                            Tab item$iv;
                            Tab it = item$iv = $changed$iv22.next();
                            boolean bl16 = false;
                            if (Intrinsics.areEqual((Object)it, (Object)SearchAndOthersKt.SearchScreen$lambda$6((State<Tab>)selectedTab$delegate))) {
                                n10 = index$iv;
                                break block56;
                            }
                            ++index$iv;
                        }
                        n10 = -1;
                    }
                    int $this$dp$iv3 = 24;
                    boolean $i$f$getDp2 = false;
                    TabRowKt.ScrollableTabRow-sKfQg0A((int)RangesKt.coerceAtLeast((int)n10, (int)0), (Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (long)0L, (long)0L, (float)Dp.constructor-impl((float)$this$dp$iv3), null, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)651173474, (boolean)true, (arg_0, arg_1) -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$35(tabs, viewModel2, selectedTab$delegate, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)12607536, (int)108);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1860196165);
                    $composer3.endReplaceGroup();
                }
                Modifier $this$dp$iv3 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                void $changed$iv22 = $composer3;
                int $changed$iv3 = 6;
                boolean $i$f$Box2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                boolean propagateMinConstraints$iv2 = false;
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv2, (boolean)propagateMinConstraints$iv2);
                $changed$iv$iv2 = modifier$iv;
                $i$f$Layout2 = 0x70 & $changed$iv3 << 3;
                boolean $i$f$Layout3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                Function0 $changed$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                $i$f$ReusableComposeNode2 = 6 | 0x380 & $changed$iv$iv << 6;
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
                int $composer$iv222 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv6 = $composer$iv;
                $i$a$-Layout-BoxKt$Box$1$iv = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int $composer222 = 6 | 0x70 & $changed$iv3 >> 6;
                $this$SearchScreen_u24lambda_u2445_u24lambda_u2429 = $composer$iv6;
                BoxScope $this$SearchScreen_u24lambda_u2445_u24lambda_u2444 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl17 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1925843321, (String)"C:SearchAndOthers.kt#zg4hxr");
                if (SearchAndOthersKt.SearchScreen$lambda$7((State<Boolean>)isLoading$delegate) && SearchAndOthersKt.SearchScreen$lambda$5((State<? extends List<? extends Shelf>>)shelves$delegate).isEmpty()) {
                    $composer2.startReplaceGroup(-1925840129);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"131@5657L59");
                    ProgressIndicatorKt.CircularProgressIndicator-LxG7B9w((Modifier)$this$SearchScreen_u24lambda_u2445_u24lambda_u2444.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter()), (long)0L, (float)0.0f, (long)0L, (int)0, (Composer)$composer2, (int)0, (int)30);
                    $composer2.endReplaceGroup();
                } else if (SearchAndOthersKt.SearchScreen$lambda$8((State<? extends Throwable>)error$delegate) != null && SearchAndOthersKt.SearchScreen$lambda$5((State<? extends List<? extends Shelf>>)shelves$delegate).isEmpty()) {
                    Object object9;
                    void $this$cache$iv4;
                    $composer2.startReplaceGroup(-1925687578);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"134@5840L22,134@5811L52");
                    Throwable throwable = SearchAndOthersKt.SearchScreen$lambda$8((State<? extends Throwable>)error$delegate);
                    Throwable throwable2 = throwable;
                    Intrinsics.checkNotNull((Object)throwable);
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2001780042, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                    void invalid$iv22 = $composer2;
                    invalid$iv = $composer.changedInstance((Object)viewModel2);
                    boolean $i$f$cache3 = false;
                    Object it$iv3 = $this$cache$iv4.rememberedValue();
                    $i$a$-let-ComposerKt$cache$1$iv = false;
                    if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                        object2 = throwable2;
                        boolean bl18 = false;
                        throwable2 = object2;
                        value$iv = () -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$44$lambda$37$lambda$36(viewModel2);
                        $this$cache$iv4.updateRememberedValue((Object)value$iv);
                        object9 = value$iv;
                    } else {
                        object9 = it$iv3;
                    }
                    value$iv = (Function0)object9;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    SearchAndOthersKt.ErrorView(throwable2, (Function0<Unit>)value$iv, (Composer)$composer2, 0);
                    $composer2.endReplaceGroup();
                } else if (!((Collection)SearchAndOthersKt.SearchScreen$lambda$5((State<? extends List<? extends Shelf>>)shelves$delegate)).isEmpty()) {
                    Object object10;
                    void $this$cache$iv5;
                    $composer2.startReplaceGroup(-1925540328);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"140@6108L382,137@5944L546");
                    Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                    LazyListState lazyListState = null;
                    int $this$dp$iv4 = 96;
                    boolean $i$f$getDp22 = false;
                    PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default((float)0.0f, (float)0.0f, (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv4), (int)7, null);
                    boolean bl19 = false;
                    Arrangement.Vertical vertical = null;
                    Alignment.Horizontal horizontal = null;
                    FlingBehavior flingBehavior = null;
                    boolean bl20 = false;
                    Function1 function12 = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2001771106, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                    void $i$f$getDp22 = $composer2;
                    invalid$iv = $composer.changed((Object)shelves$delegate) | ($dirty & 0x380) == 256 | $composer.changedInstance((Object)playerViewModel);
                    boolean $i$f$cache4 = false;
                    Object it$iv4 = $this$cache$iv5.rememberedValue();
                    $i$a$-let-ComposerKt$cache$1$iv = false;
                    if (invalid$iv || it$iv4 == Composer.Companion.getEmpty()) {
                        function1 = function12;
                        boolean bl21 = bl20;
                        FlingBehavior flingBehavior2 = flingBehavior;
                        Alignment.Horizontal horizontal2 = horizontal;
                        Arrangement.Vertical vertical2 = vertical;
                        boolean bl22 = bl19;
                        PaddingValues paddingValues2 = paddingValues;
                        LazyListState lazyListState2 = lazyListState;
                        object2 = modifier;
                        boolean bl23 = false;
                        Function1 function13 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41(shelves$delegate, onMediaSelected, playerViewModel, arg_0);
                        modifier = object2;
                        lazyListState = lazyListState2;
                        paddingValues = paddingValues2;
                        bl19 = bl22;
                        vertical = vertical2;
                        horizontal = horizontal2;
                        flingBehavior = flingBehavior2;
                        bl20 = bl21;
                        function12 = function1;
                        value$iv = function13;
                        $this$cache$iv5.updateRememberedValue((Object)value$iv);
                        object10 = value$iv;
                    } else {
                        object10 = it$iv4;
                    }
                    Function1 function14 = (Function1)object10;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    LazyDslKt.LazyColumn((Modifier)modifier, lazyListState, (PaddingValues)paddingValues, (boolean)bl19, vertical, horizontal, flingBehavior, (boolean)bl20, function12, (Function1)function14, (Composer)$composer2, (int)390, (int)506);
                    $composer2.endReplaceGroup();
                } else {
                    void $composer4;
                    void $changed$iv$iv$iv4;
                    void $changed$iv$iv4;
                    void modifier$iv$iv4;
                    void modifier$iv4;
                    void $changed$iv4;
                    void horizontalAlignment$iv2;
                    void verticalArrangement$iv2;
                    void $composer$iv7;
                    $composer2.startReplaceGroup(-1924926001);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"151@6555L811");
                    Modifier modifier = $this$SearchScreen_u24lambda_u2445_u24lambda_u2444.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter());
                    Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
                    int $this$dp$iv322 = 8;
                    boolean $i$f$getDp32 = false;
                    Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv322));
                    Modifier $this$dp$iv322 = modifier;
                    Arrangement.Vertical $i$f$getDp32 = (Arrangement.Vertical)horizontalOrVertical;
                    Alignment.Horizontal horizontal3 = horizontal;
                    void bl23 = $composer2;
                    int value$iv4 = 432;
                    boolean $i$f$Column2 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv2, (Alignment.Horizontal)horizontalAlignment$iv2, (Composer)$composer$iv7, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
                    void var94_155 = modifier$iv4;
                    int n11 = 0x70 & $changed$iv4 << 3;
                    boolean $i$f$Layout4 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv7, (int)0);
                    CompositionLocalMap localMap$iv$iv4 = $composer$iv7.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier((Composer)$composer$iv7, (Modifier)modifier$iv$iv4);
                    Function0 function03 = ComposeUiNode.Companion.getConstructor();
                    int n12 = 6 | 0x380 & $changed$iv$iv4 << 6;
                    boolean $i$f$ReusableComposeNode4 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!($composer$iv7.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv7.startReusableNode();
                    if ($composer$iv7.getInserting()) {
                        void factory$iv$iv$iv;
                        $composer$iv7.createNode((Function0)factory$iv$iv$iv);
                    } else {
                        $composer$iv7.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl((Composer)$composer$iv7);
                    $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
                    Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)measurePolicy$iv4, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)localMap$iv$iv4, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 block$iv$iv$iv4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    $i$f$set-impl = false;
                    Composer $this$set_impl_u24lambda_u240$iv$iv$iv4 = $this$Layout_u24lambda_u240$iv$iv4;
                    $i$a$-with-Updater$set$1$iv$iv$iv = false;
                    if ($this$set_impl_u24lambda_u240$iv$iv$iv4.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv4.rememberedValue(), (Object)compositeKeyHash$iv$iv4)) {
                        $this$set_impl_u24lambda_u240$iv$iv$iv4.updateRememberedValue((Object)compositeKeyHash$iv$iv4);
                        $this$Layout_u24lambda_u240$iv$iv4.apply((Object)compositeKeyHash$iv$iv4, block$iv$iv$iv4);
                    }
                    Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)materialized$iv$iv4, (Function2)ComposeUiNode.Companion.getSetModifier());
                    int n13 = 0xE & $changed$iv$iv$iv4 >> 6;
                    void $composer$iv8 = $composer$iv7;
                    $i$a$-Layout-ColumnKt$Column$1$iv = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv8, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                    int n14 = 6 | 0x70 & $changed$iv4 >> 6;
                    void var113_174 = $composer$iv8;
                    ColumnScope $this$SearchScreen_u24lambda_u2445_u24lambda_u2444_u24lambda_u2443 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                    boolean bl24 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)146204108, (String)"C159@6978L11,156@6818L233,164@7290L11,161@7076L268:SearchAndOthers.kt#zg4hxr");
                    IconKt.Icon-ww6aTOc((ImageVector)SearchKt.getSearch((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (float)0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer4, (int)48, (int)4);
                    TextKt.Text--4IGK_g((String)(StringsKt.isBlank((CharSequence)SearchAndOthersKt.SearchScreen$lambda$2((State<String>)query$delegate)) ? "Type in the search bar above to search" : "No results found for \"" + SearchAndOthersKt.SearchScreen$lambda$2((State<String>)query$delegate) + "\""), null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer4, (int)0, (int)0, (int)131066);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv8);
                    $composer$iv7.endNode();
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
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
            if (scopeUpdateScope == null) break block57;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SearchAndOthersKt.SearchScreen$lambda$46(viewModel2, playerViewModel, onMediaSelected, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void LibraryScreen(@Nullable LibraryViewModel viewModel2, @Nullable Composer $composer, int $changed, int n) {
        block14: {
            $composer = $composer.startRestartGroup(1073837905);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(LibraryScreen)175@7498L531:SearchAndOthers.kt#zg4hxr");
            int $dirty = $changed;
            if ($composer.shouldExecute(($dirty & 1) != 0, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void horizontalAlignment$iv;
                void verticalArrangement$iv;
                void $composer$iv;
                Alignment.Horizontal $this$cache$iv$iv;
                int $i$f$cache;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"174@7478L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    if ((n & 1) != 0) {
                        Object object;
                        void $composer$iv2;
                        Composer composer = $composer;
                        boolean $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv2.startReplaceGroup(-1168520582);
                        Qualifier qualifier$iv = null;
                        Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv2, (int)0);
                        $composer$iv2.startReplaceGroup(-1633490746);
                        void var10_16 = $composer$iv2;
                        boolean invalid$iv$iv = $composer$iv2.changed(qualifier$iv) | $composer$iv2.changed((Object)scope$iv);
                        $i$f$cache = 0;
                        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        boolean bl = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            boolean bl2 = false;
                            Object value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(LibraryViewModel.class), qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object = value$iv$iv;
                        } else {
                            object = it$iv$iv;
                        }
                        Object object2 = object;
                        $composer$iv2.endReplaceGroup();
                        Object object3 = object2;
                        $composer$iv2.endReplaceGroup();
                        viewModel2 = (LibraryViewModel)object3;
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
                    ComposerKt.traceEventStart((int)1073837905, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.LibraryScreen (SearchAndOthers.kt:174)");
                }
                int $this$dp$iv = 32;
                boolean $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.getCenter();
                Modifier $changed$iv2 = modifier;
                Arrangement.Vertical $i$f$koinInject = (Arrangement.Vertical)horizontalOrVertical;
                $this$cache$iv$iv = horizontal;
                Composer invalid$iv$iv = $composer;
                $i$f$cache = 438;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void bl2 = modifier$iv;
                int value$iv$iv = 0x70 & $changed$iv << 3;
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
                boolean bl3 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl4 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n3 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv3 = $composer$iv;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n4 = 6 | 0x70 & $changed$iv >> 6;
                void var34_47 = $composer$iv3;
                ColumnScope $this$LibraryScreen_u24lambda_u2447 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl6 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1040035057, (String)"C180@7759L11,180@7678L101,181@7831L10,181@7788L69,184@7985L11,182@7866L157:SearchAndOthers.kt#zg4hxr");
                IconKt.Icon-ww6aTOc((ImageVector)LibraryMusicKt.getLibraryMusic((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (Composer)$composer2, (int)48, (int)4);
                TextKt.Text--4IGK_g((String)"Your Library", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getHeadlineMedium(), (Composer)$composer2, (int)6, (int)0, (int)65534);
                TextKt.Text--4IGK_g((String)"Saved tracks, playlists, and followed artists will appear here.", null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer2, (int)6, (int)0, (int)131066);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block14;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SearchAndOthersKt.LibraryScreen$lambda$48(viewModel2, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void DownloadsScreen(@Nullable DownloadsViewModel viewModel2, @Nullable Composer $composer, int $changed, int n) {
        block14: {
            $composer = $composer.startRestartGroup(2005114801);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(DownloadsScreen)191@8117L514:SearchAndOthers.kt#zg4hxr");
            int $dirty = $changed;
            if ($composer.shouldExecute(($dirty & 1) != 0, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void horizontalAlignment$iv;
                void verticalArrangement$iv;
                void $composer$iv;
                Alignment.Horizontal $this$cache$iv$iv;
                int $i$f$cache;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"190@8097L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    if ((n & 1) != 0) {
                        Object object;
                        void $composer$iv2;
                        Composer composer = $composer;
                        boolean $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv2.startReplaceGroup(-1168520582);
                        Qualifier qualifier$iv = null;
                        Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv2, (int)0);
                        $composer$iv2.startReplaceGroup(-1633490746);
                        void var10_16 = $composer$iv2;
                        boolean invalid$iv$iv = $composer$iv2.changed(qualifier$iv) | $composer$iv2.changed((Object)scope$iv);
                        $i$f$cache = 0;
                        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        boolean bl = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            boolean bl2 = false;
                            Object value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(DownloadsViewModel.class), qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object = value$iv$iv;
                        } else {
                            object = it$iv$iv;
                        }
                        Object object2 = object;
                        $composer$iv2.endReplaceGroup();
                        Object object3 = object2;
                        $composer$iv2.endReplaceGroup();
                        viewModel2 = (DownloadsViewModel)object3;
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
                    ComposerKt.traceEventStart((int)2005114801, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.DownloadsScreen (SearchAndOthers.kt:190)");
                }
                int $this$dp$iv = 32;
                boolean $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.getCenter();
                Modifier $changed$iv2 = modifier;
                Arrangement.Vertical $i$f$koinInject = (Arrangement.Vertical)horizontalOrVertical;
                $this$cache$iv$iv = horizontal;
                Composer invalid$iv$iv = $composer;
                $i$f$cache = 438;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void bl2 = modifier$iv;
                int value$iv$iv = 0x70 & $changed$iv << 3;
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
                boolean bl3 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl4 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n3 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv3 = $composer$iv;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n4 = 6 | 0x70 & $changed$iv >> 6;
                void var34_47 = $composer$iv3;
                ColumnScope $this$DownloadsScreen_u24lambda_u2449 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl6 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1682038368, (String)"C196@8374L11,196@8297L97,197@8443L10,197@8403L66,200@8587L11,198@8478L147:SearchAndOthers.kt#zg4hxr");
                IconKt.Icon-ww6aTOc((ImageVector)DownloadKt.getDownload((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (Composer)$composer2, (int)48, (int)4);
                TextKt.Text--4IGK_g((String)"Downloads", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getHeadlineMedium(), (Composer)$composer2, (int)6, (int)0, (int)65534);
                TextKt.Text--4IGK_g((String)"Downloaded tracks and offline media will appear here.", null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer2, (int)6, (int)0, (int)131066);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block14;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SearchAndOthersKt.DownloadsScreen$lambda$50(viewModel2, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void SettingsScreen(@Nullable SettingsViewModel viewModel2, @Nullable Composer $composer, int $changed, int n) {
        block14: {
            $composer = $composer.startRestartGroup(2092802991);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(SettingsScreen)207@8717L532:SearchAndOthers.kt#zg4hxr");
            int $dirty = $changed;
            if ($composer.shouldExecute(($dirty & 1) != 0, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void horizontalAlignment$iv;
                void verticalArrangement$iv;
                void $composer$iv;
                Alignment.Horizontal $this$cache$iv$iv;
                int $i$f$cache;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"206@8697L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    if ((n & 1) != 0) {
                        Object object;
                        void $composer$iv2;
                        Composer composer = $composer;
                        boolean $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv2.startReplaceGroup(-1168520582);
                        Qualifier qualifier$iv = null;
                        Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv2, (int)0);
                        $composer$iv2.startReplaceGroup(-1633490746);
                        void var10_16 = $composer$iv2;
                        boolean invalid$iv$iv = $composer$iv2.changed(qualifier$iv) | $composer$iv2.changed((Object)scope$iv);
                        $i$f$cache = 0;
                        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        boolean bl = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            boolean bl2 = false;
                            Object value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(SettingsViewModel.class), qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object = value$iv$iv;
                        } else {
                            object = it$iv$iv;
                        }
                        Object object2 = object;
                        $composer$iv2.endReplaceGroup();
                        Object object3 = object2;
                        $composer$iv2.endReplaceGroup();
                        viewModel2 = (SettingsViewModel)object3;
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
                    ComposerKt.traceEventStart((int)2092802991, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SettingsScreen (SearchAndOthers.kt:206)");
                }
                int $this$dp$iv = 32;
                boolean $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.getCenter();
                Modifier $changed$iv2 = modifier;
                Arrangement.Vertical $i$f$koinInject = (Arrangement.Vertical)horizontalOrVertical;
                $this$cache$iv$iv = horizontal;
                Composer invalid$iv$iv = $composer;
                $i$f$cache = 438;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void bl2 = modifier$iv;
                int value$iv$iv = 0x70 & $changed$iv << 3;
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
                boolean bl3 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl4 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n3 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv3 = $composer$iv;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n4 = 6 | 0x70 & $changed$iv >> 6;
                void var34_47 = $composer$iv3;
                ColumnScope $this$SettingsScreen_u24lambda_u2451 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl6 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1317887120, (String)"C212@8974L11,212@8897L97,213@9042L10,213@9003L65,216@9205L11,214@9077L166:SearchAndOthers.kt#zg4hxr");
                IconKt.Icon-ww6aTOc((ImageVector)SettingsKt.getSettings((Icons.Filled)Icons.INSTANCE.getDefault()), null, null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), (Composer)$composer2, (int)48, (int)4);
                TextKt.Text--4IGK_g((String)"Settings", null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getHeadlineMedium(), (Composer)$composer2, (int)6, (int)0, (int)65534);
                TextKt.Text--4IGK_g((String)"Configure audio output, download directories, and extension preferences.", null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer2, (int)6, (int)0, (int)131066);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block14;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SearchAndOthersKt.SettingsScreen$lambda$52(viewModel2, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void ErrorView(@NotNull Throwable error, @NotNull Function0<Unit> onRetry, @Nullable Composer $composer, int $changed) {
        block10: {
            Intrinsics.checkNotNullParameter((Object)error, (String)"error");
            Intrinsics.checkNotNullParameter(onRetry, (String)"onRetry");
            $composer = $composer.startRestartGroup(-761288100);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(ErrorView)223@9324L314:SearchAndOthers.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)error) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onRetry) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void horizontalAlignment$iv;
                void verticalArrangement$iv;
                void $composer$iv;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-761288100, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.ErrorView (SearchAndOthers.kt:222)");
                }
                int $this$dp$iv = 32;
                boolean $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Horizontal horizontal = Alignment.Companion.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.getCenter();
                Modifier modifier2 = modifier;
                Arrangement.Vertical vertical = (Arrangement.Vertical)horizontalOrVertical;
                Alignment.Horizontal horizontal2 = horizontal;
                Composer composer = $composer;
                int n = 438;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var15_17 = modifier$iv;
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
                void var34_36 = $composer$iv2;
                ColumnScope $this$ErrorView_u24lambda_u2453 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1089318863, (String)"C228@9558L11,228@9504L72,229@9585L47:SearchAndOthers.kt#zg4hxr");
                TextKt.Text--4IGK_g((String)("Error: " + error.getMessage()), null, (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getError-0d7_KjU(), (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer2, (int)0, (int)0, (int)131066);
                ButtonKt.TextButton(onRetry, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$SearchAndOthersKt.INSTANCE.getLambda$-688894321$desktopApp(), (Composer)$composer2, (int)(0x30000000 | 0xE & $dirty >> 3), (int)510);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block10;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SearchAndOthersKt.ErrorView$lambda$54(error, onRetry, $changed, arg_0, arg_1));
        }
    }

    private static final Unit SearchScreen$lambda$1$lambda$0(EchoMediaItem it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final String SearchScreen$lambda$2(State<String> $query$delegate) {
        void $this$getValue$iv;
        State<String> state = $query$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List<QuickSearchItem> SearchScreen$lambda$3(State<? extends List<? extends QuickSearchItem>> $quickResults$delegate) {
        void $this$getValue$iv;
        State<? extends List<? extends QuickSearchItem>> state = $quickResults$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final Feed<Shelf> SearchScreen$lambda$4(State<Feed<Shelf>> $searchFeed$delegate) {
        void $this$getValue$iv;
        State<Feed<Shelf>> state = $searchFeed$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Feed)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final List<Shelf> SearchScreen$lambda$5(State<? extends List<? extends Shelf>> $shelves$delegate) {
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
    private static final Tab SearchScreen$lambda$6(State<Tab> $selectedTab$delegate) {
        void $this$getValue$iv;
        State<Tab> state = $selectedTab$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Tab)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean SearchScreen$lambda$7(State<Boolean> $isLoading$delegate) {
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
    private static final Throwable SearchScreen$lambda$8(State<? extends Throwable> $error$delegate) {
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
    private static final boolean SearchScreen$lambda$10(MutableState<Boolean> $expanded$delegate) {
        void $this$getValue$iv;
        State state = (State)$expanded$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void SearchScreen$lambda$11(MutableState<Boolean> $expanded$delegate, boolean bl) {
        void $this$setValue$iv;
        MutableState<Boolean> mutableState = $expanded$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        Boolean value$iv = bl;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21$lambda$13$lambda$12(SearchViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $viewModel.updateQuery(it);
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21$lambda$15$lambda$14(SearchViewModel $viewModel, MutableState $expanded$delegate, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        SearchAndOthersKt.SearchScreen$lambda$11((MutableState<Boolean>)$expanded$delegate, false);
        $viewModel.search(it);
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21$lambda$17$lambda$16(MutableState $expanded$delegate, boolean it) {
        SearchAndOthersKt.SearchScreen$lambda$11((MutableState<Boolean>)$expanded$delegate, it);
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21$lambda$20$lambda$19$lambda$18(SearchViewModel $viewModel, MutableState $expanded$delegate) {
        $viewModel.clearSearch();
        SearchAndOthersKt.SearchScreen$lambda$11((MutableState<Boolean>)$expanded$delegate, false);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21$lambda$20(SearchViewModel $viewModel, MutableState $expanded$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C83@3929L45,83@3908L174:SearchAndOthers.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-339596470, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SearchAndOthers.kt:83)");
            }
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)65308631, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = $composer.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl2 = false;
                Function0 value$iv = () -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21$lambda$20$lambda$19$lambda$18($viewModel, $expanded$delegate);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function0 function0 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            IconButtonKt.IconButton((Function0)function0, null, (boolean)false, null, null, ComposableSingletons$SearchAndOthersKt.INSTANCE.getLambda$-1609042713$desktopApp(), (Composer)$composer, (int)196608, (int)30);
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
    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$21(SearchViewModel $viewModel, State $query$delegate, MutableState $expanded$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C72@3314L29,73@3380L121,78@3591L17,70@3223L947:SearchAndOthers.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Function1 function1;
            Object object;
            Object object2;
            Function1 function12;
            Object object3;
            Function1 value$iv;
            Function1 function13;
            SearchBarDefaults searchBarDefaults;
            String string2;
            Composer $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-140069879, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous>.<anonymous> (SearchAndOthers.kt:70)");
            }
            SearchBarDefaults searchBarDefaults2 = SearchBarDefaults.INSTANCE;
            String string3 = SearchAndOthersKt.SearchScreen$lambda$2((State<String>)$query$delegate);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1463163322, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = $composer.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                string2 = string3;
                searchBarDefaults = searchBarDefaults2;
                boolean bl2 = false;
                function13 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21$lambda$13$lambda$12($viewModel, arg_0);
                searchBarDefaults2 = searchBarDefaults;
                string3 = string2;
                value$iv = function13;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object3 = value$iv;
            } else {
                object3 = it$iv;
            }
            Function1 function14 = (Function1)object3;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            Function1 function15 = function14;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1463161118, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = $composer.changedInstance((Object)$viewModel);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                function13 = function15;
                string2 = string3;
                searchBarDefaults = searchBarDefaults2;
                boolean bl3 = false;
                function12 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21$lambda$15$lambda$14($viewModel, $expanded$delegate, arg_0);
                searchBarDefaults2 = searchBarDefaults;
                string3 = string2;
                function15 = function13;
                value$iv = function12;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv;
            }
            function14 = (Function1)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            Function1 function16 = function14;
            boolean bl4 = SearchAndOthersKt.SearchScreen$lambda$10((MutableState<Boolean>)$expanded$delegate);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1463154470, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
            $this$cache$iv = $composer;
            invalid$iv = false;
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl = false;
            if (it$iv == Composer.Companion.getEmpty()) {
                boolean bl5 = bl4;
                function12 = function16;
                function13 = function15;
                string2 = string3;
                searchBarDefaults = searchBarDefaults2;
                boolean bl6 = false;
                Function1 function17 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21$lambda$17$lambda$16($expanded$delegate, arg_0);
                searchBarDefaults2 = searchBarDefaults;
                string3 = string2;
                function15 = function13;
                function16 = function12;
                bl4 = bl5;
                value$iv = function17;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            function14 = (Function1)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            Function2<Composer, Integer, Unit> function2 = ComposableSingletons$SearchAndOthersKt.INSTANCE.getLambda$-1507681043$desktopApp();
            Function2<Composer, Integer, Unit> function22 = ComposableSingletons$SearchAndOthersKt.INSTANCE.getLambda$-930485330$desktopApp();
            if (!StringsKt.isBlank((CharSequence)SearchAndOthersKt.SearchScreen$lambda$2((State<String>)$query$delegate))) {
                $composer.startReplaceGroup(1887111251);
                ComposerKt.sourceInformation((Composer)$composer, (String)"82@3874L238");
                function14 = (Function2)ComposableLambdaKt.rememberComposableLambda((int)-339596470, (boolean)true, (arg_0, arg_1) -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$21$lambda$20($viewModel, $expanded$delegate, arg_0, arg_1), (Composer)$composer, (int)54);
                $composer.endReplaceGroup();
                function1 = function14;
            } else {
                $composer.startReplaceGroup(1887399860);
                $composer.endReplaceGroup();
                function1 = null;
            }
            searchBarDefaults2.InputField(string3, function15, function16, bl4, function14, null, false, function2, function22, function1, null, null, $composer, 0x6C06000, SearchBarDefaults.$stable << 6, 3168);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$23$lambda$22(MutableState $expanded$delegate, boolean it) {
        SearchAndOthersKt.SearchScreen$lambda$11((MutableState<Boolean>)$expanded$delegate, it);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$28$lambda$27$lambda$26(State $quickResults$delegate, SearchViewModel $viewModel, MutableState $expanded$delegate, LazyListScope $this$LazyColumn) {
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        LazyListScope lazyListScope = $this$LazyColumn;
        List<QuickSearchItem> items$iv = SearchAndOthersKt.SearchScreen$lambda$3((State<? extends List<? extends QuickSearchItem>>)$quickResults$delegate);
        Object key$iv = null;
        Function1 contentType$iv = SearchScreen$lambda$45$lambda$29$lambda$28$lambda$27$lambda$26$$inlined$items$default$1.INSTANCE;
        boolean $i$f$items = false;
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
        }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $viewModel, $expanded$delegate){
            final /* synthetic */ List $items;
            final /* synthetic */ SearchViewModel $viewModel$inlined;
            final /* synthetic */ MutableState $expanded$delegate$inlined;
            {
                this.$items = $items;
                this.$viewModel$inlined = searchViewModel;
                this.$expanded$delegate$inlined = mutableState;
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
                    void $this$cache$iv;
                    void item2;
                    void $composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int n = 0xE & $dirty;
                    Composer composer = $composer;
                    QuickSearchItem quickSearchItem = (QuickSearchItem)this.$items.get(it);
                    LazyItemScope $this$SearchScreen_u24lambda_u2445_u24lambda_u2429_u24lambda_u2428_u24lambda_u2427_u24lambda_u2426_u24lambda_u2425 = $this$items;
                    boolean bl = false;
                    $composer2.startReplaceGroup(-1506449476);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"C*98@4551L20,99@4631L141,97@4495L303:SearchAndOthers.kt#zg4hxr");
                    Function2 function2 = (Function2)ComposableLambdaKt.rememberComposableLambda((int)-1698370794, (boolean)true, (Object)new Function2<Composer, Integer, Unit>((QuickSearchItem)item2){
                        final /* synthetic */ QuickSearchItem $item;
                        {
                            this.$item = $item;
                        }

                        @Composable
                        @ComposableTarget(applier="androidx.compose.ui.UiComposable")
                        public final void invoke(Composer $composer, int $changed) {
                            ComposerKt.sourceInformation((Composer)$composer, (String)"C98@4553L16:SearchAndOthers.kt#zg4hxr");
                            if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart((int)-1698370794, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SearchAndOthers.kt:98)");
                                }
                                TextKt.Text--4IGK_g((String)this.$item.getTitle(), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer, (int)0, (int)0, (int)131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                $composer.skipToGroupEnd();
                            }
                        }
                    }, (Composer)$composer2, (int)54);
                    Modifier modifier = (Modifier)Modifier.Companion;
                    boolean bl2 = false;
                    String string2 = null;
                    Role role = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-602780283, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                    void var11_11 = $composer2;
                    boolean invalid$iv = $composer2.changedInstance((Object)this.$viewModel$inlined) | $composer2.changedInstance((Object)item2);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl3 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Role role2 = role;
                        String string3 = string2;
                        boolean bl4 = bl2;
                        Modifier modifier2 = modifier;
                        Function2 function22 = function2;
                        boolean bl5 = false;
                        Function0 function0 = (Function0)new Function0<Unit>(this.$viewModel$inlined, (QuickSearchItem)item2, (MutableState<Boolean>)this.$expanded$delegate$inlined){
                            final /* synthetic */ SearchViewModel $viewModel;
                            final /* synthetic */ QuickSearchItem $item;
                            final /* synthetic */ MutableState<Boolean> $expanded$delegate;
                            {
                                this.$viewModel = $viewModel;
                                this.$item = $item;
                                this.$expanded$delegate = $expanded$delegate;
                            }

                            public final void invoke() {
                                this.$viewModel.search(this.$item.getTitle());
                                SearchAndOthersKt.access$SearchScreen$lambda$11(this.$expanded$delegate, false);
                            }
                        };
                        function2 = function22;
                        modifier = modifier2;
                        bl2 = bl4;
                        string2 = string3;
                        role = role2;
                        Function0 value$iv = function0;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object = value$iv;
                    } else {
                        object = it$iv;
                    }
                    Function0 function0 = (Function0)object;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    ListItemKt.ListItem-HXNGIdc((Function2)function2, (Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier, (boolean)bl2, string2, role, (Function0)function0, (int)7, null), null, null, null, null, null, (float)0.0f, (float)0.0f, (Composer)$composer2, (int)6, (int)508);
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

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SearchScreen$lambda$45$lambda$29$lambda$28(State $quickResults$delegate, SearchViewModel $viewModel, MutableState $expanded$delegate, ColumnScope $this$DockedSearchBar, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$DockedSearchBar, (String)"$this$DockedSearchBar");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C95@4419L419,95@4408L430:SearchAndOthers.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)854268321, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous>.<anonymous> (SearchAndOthers.kt:95)");
            }
            Modifier modifier = null;
            LazyListState lazyListState = null;
            PaddingValues paddingValues = null;
            boolean bl = false;
            Arrangement.Vertical vertical = null;
            Alignment.Horizontal horizontal = null;
            FlingBehavior flingBehavior = null;
            boolean bl2 = false;
            OverscrollEffect overscrollEffect = null;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)613105700, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = $composer.changed((Object)$quickResults$delegate) | $composer.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl3 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                OverscrollEffect overscrollEffect2 = overscrollEffect;
                boolean bl4 = bl2;
                FlingBehavior flingBehavior2 = flingBehavior;
                Alignment.Horizontal horizontal2 = horizontal;
                Arrangement.Vertical vertical2 = vertical;
                boolean bl5 = bl;
                PaddingValues paddingValues2 = paddingValues;
                LazyListState lazyListState2 = lazyListState;
                Modifier modifier2 = modifier;
                boolean bl6 = false;
                Function1 function1 = arg_0 -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$29$lambda$28$lambda$27$lambda$26($quickResults$delegate, $viewModel, $expanded$delegate, arg_0);
                modifier = modifier2;
                lazyListState = lazyListState2;
                paddingValues = paddingValues2;
                bl = bl5;
                vertical = vertical2;
                horizontal = horizontal2;
                flingBehavior = flingBehavior2;
                bl2 = bl4;
                overscrollEffect = overscrollEffect2;
                Function1 value$iv = function1;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function1 function1 = (Function1)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            LazyDslKt.LazyColumn(modifier, lazyListState, paddingValues, (boolean)bl, vertical, horizontal, flingBehavior, (boolean)bl2, overscrollEffect, (Function1)function1, (Composer)$composer, (int)0, (int)511);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$35$lambda$34$lambda$32$lambda$31(SearchViewModel $viewModel, Tab $tab) {
        $viewModel.selectTab($tab);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit SearchScreen$lambda$45$lambda$35$lambda$34$lambda$33(Tab $tab, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C121@5419L15:SearchAndOthers.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1812620994, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SearchAndOthers.kt:121)");
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
    private static final Unit SearchScreen$lambda$45$lambda$35(List $tabs, SearchViewModel $viewModel, State $selectedTab$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C*120@5356L28,121@5417L19,118@5262L196:SearchAndOthers.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)651173474, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.SearchScreen.<anonymous>.<anonymous> (SearchAndOthers.kt:117)");
            }
            Iterable $this$forEach$iv = $tabs;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Object object;
                void $this$cache$iv;
                Tab tab = (Tab)element$iv;
                boolean bl = false;
                boolean bl2 = Intrinsics.areEqual((Object)tab, (Object)SearchAndOthersKt.SearchScreen$lambda$6((State<Tab>)$selectedTab$delegate));
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)896502880, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = $composer.changedInstance((Object)$viewModel) | $composer.changedInstance((Object)tab);
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl3 = false;
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    boolean bl4 = bl2;
                    boolean bl5 = false;
                    Function0 function0 = () -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$35$lambda$34$lambda$32$lambda$31($viewModel, tab);
                    bl2 = bl4;
                    Function0 value$iv = function0;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function0 function0 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                TabKt.Tab-wqdebIU((boolean)bl2, (Function0)function0, null, (boolean)false, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-1812620994, (boolean)true, (arg_0, arg_1) -> SearchAndOthersKt.SearchScreen$lambda$45$lambda$35$lambda$34$lambda$33(tab, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, null, (Composer)$composer, (int)24576, (int)492);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit SearchScreen$lambda$45$lambda$44$lambda$37$lambda$36(SearchViewModel $viewModel) {
        SearchViewModel.search$default($viewModel, null, 1, null);
        return Unit.INSTANCE;
    }

    private static final Object SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41$lambda$38(Shelf it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getId();
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41(State $shelves$delegate, Function1 $onMediaSelected, PlayerViewModel $playerViewModel, LazyListScope $this$LazyColumn) {
        void items$iv;
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        LazyListScope lazyListScope = $this$LazyColumn;
        List<Shelf> list2 = SearchAndOthersKt.SearchScreen$lambda$5((State<? extends List<? extends Shelf>>)$shelves$delegate);
        Function1 key$iv = SearchAndOthersKt::SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41$lambda$38;
        Function1 contentType$iv = SearchScreen$lambda$45$lambda$44$lambda$42$lambda$41$$inlined$items$default$1.INSTANCE;
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
                    LazyItemScope $this$SearchScreen_u24lambda_u2445_u24lambda_u2444_u24lambda_u2442_u24lambda_u2441_u24lambda_u2440 = $this$items;
                    boolean bl = false;
                    $composer2.startReplaceGroup(1812973519);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"C*145@6372L40,142@6205L237:SearchAndOthers.kt#zg4hxr");
                    void v0 = shelf;
                    Function1 function1 = this.$onMediaSelected$inlined;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-634248497, (String)"CC(remember):SearchAndOthers.kt#9igjgp");
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

    private static final Unit SearchScreen$lambda$46(SearchViewModel $viewModel, PlayerViewModel $playerViewModel, Function1 $onMediaSelected, int $$changed, int $$default, Composer $composer, int $force) {
        SearchAndOthersKt.SearchScreen($viewModel, $playerViewModel, (Function1<? super EchoMediaItem, Unit>)$onMediaSelected, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit LibraryScreen$lambda$48(LibraryViewModel $viewModel, int $$changed, int $$default, Composer $composer, int $force) {
        SearchAndOthersKt.LibraryScreen($viewModel, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit DownloadsScreen$lambda$50(DownloadsViewModel $viewModel, int $$changed, int $$default, Composer $composer, int $force) {
        SearchAndOthersKt.DownloadsScreen($viewModel, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit SettingsScreen$lambda$52(SettingsViewModel $viewModel, int $$changed, int $$default, Composer $composer, int $force) {
        SearchAndOthersKt.SettingsScreen($viewModel, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit ErrorView$lambda$54(Throwable $error, Function0 $onRetry, int $$changed, Composer $composer, int $force) {
        SearchAndOthersKt.ErrorView($error, (Function0<Unit>)$onRetry, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$SearchScreen$lambda$11(MutableState $expanded$delegate, boolean bl) {
        SearchAndOthersKt.SearchScreen$lambda$11((MutableState<Boolean>)$expanded$delegate, bl);
    }
}

