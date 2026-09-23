/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.interaction.InteractionSourceKt
 *  androidx.compose.foundation.interaction.MutableInteractionSource
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.PauseKt
 *  androidx.compose.material.icons.filled.PlayArrowKt
 *  androidx.compose.material.icons.filled.RepeatKt
 *  androidx.compose.material.icons.filled.RepeatOneKt
 *  androidx.compose.material.icons.filled.ShuffleKt
 *  androidx.compose.material3.IconButtonKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.SliderKt
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
 *  androidx.compose.ui.layout.ContentScale
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.text.style.TextOverflow
 *  androidx.compose.ui.unit.Dp
 *  coil3.compose.SingletonAsyncImageKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KFunction
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.player;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.PauseKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material.icons.filled.RepeatKt;
import androidx.compose.material.icons.filled.RepeatOneKt;
import androidx.compose.material.icons.filled.ShuffleKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import coil3.compose.SingletonAsyncImageKt;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.core.platform.PlayerState;
import dev.brahmkshatriya.echo.core.platform.RepeatMode;
import dev.brahmkshatriya.echo.desktop.ui.player.ComposableSingletons$MiniPlayerKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a!\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u00a2\u0006\u0002\u0010\n\u001a}\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u00a2\u0006\u0002\u0010\u0019\u001aW\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020#0!2\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0003\u00a2\u0006\u0002\u0010$\u00a8\u0006%\u00b2\u0006\f\u0010&\u001a\u0004\u0018\u00010\tX\u008a\u0084\u0002\u00b2\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001d\u001a\u00020\u001cX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0010\u001a\u00020\rX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2={"MiniPlayer", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TrackInfo", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "(Ldev/brahmkshatriya/echo/common/models/Track;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PlaybackControls", "isPlaying", "", "state", "Ldev/brahmkshatriya/echo/core/platform/PlayerState;", "shuffleEnabled", "repeatMode", "Ldev/brahmkshatriya/echo/core/platform/RepeatMode;", "onPrevious", "Lkotlin/Function0;", "onPlayPause", "onNext", "onShuffleToggle", "onRepeatToggle", "(ZLdev/brahmkshatriya/echo/core/platform/PlayerState;ZLdev/brahmkshatriya/echo/core/platform/RepeatMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VolumeAndTime", "positionMs", "", "durationMs", "volume", "", "onVolumeChange", "Lkotlin/Function1;", "formatDuration", "", "(JJFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "desktopApp", "currentTrack"})
@SourceDebugExtension(value={"SMAP\nMiniPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MiniPlayer.kt\ndev/brahmkshatriya/echo/desktop/ui/player/MiniPlayerKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 8 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 9 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 10 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,271:1\n113#2:272\n113#2:316\n113#2:441\n113#2:442\n113#2:443\n113#2:529\n113#2:572\n113#2:614\n113#2:615\n87#3:273\n84#3,9:274\n94#3:403\n87#3:444\n83#3,10:445\n94#3:491\n79#4,6:283\n86#4,3:298\n89#4,2:307\n79#4,6:327\n86#4,3:342\n89#4,2:351\n93#4:398\n93#4:402\n79#4,6:414\n86#4,3:429\n89#4,2:438\n79#4,6:455\n86#4,3:470\n89#4,2:479\n93#4:490\n93#4:494\n79#4,6:502\n86#4,3:517\n89#4,2:526\n79#4,6:545\n86#4,3:560\n89#4,2:569\n93#4:575\n93#4:579\n79#4,6:587\n86#4,3:602\n89#4,2:611\n93#4:618\n347#5,9:289\n356#5:309\n347#5,9:333\n356#5:353\n357#5,2:396\n357#5,2:400\n347#5,9:420\n356#5:440\n347#5,9:461\n356#5:481\n357#5,2:488\n357#5,2:492\n347#5,9:508\n356#5:528\n347#5,9:551\n356#5:571\n357#5,2:573\n357#5,2:577\n347#5,9:593\n356#5:613\n357#5,2:616\n4206#6,6:301\n4206#6,6:345\n4206#6,6:432\n4206#6,6:473\n4206#6,6:520\n4206#6,6:563\n4206#6,6:605\n1247#7,6:310\n1247#7,6:354\n1247#7,6:360\n1247#7,6:366\n1247#7,6:372\n1247#7,6:378\n1247#7,6:384\n1247#7,6:390\n1247#7,6:482\n1247#7,6:530\n99#8:317\n96#8,9:318\n106#8:399\n99#8:404\n96#8,9:405\n106#8:495\n99#8,6:496\n106#8:580\n99#8,6:581\n106#8:619\n70#9:536\n68#9,8:537\n77#9:576\n85#10:620\n85#10:621\n85#10:622\n85#10:623\n85#10:624\n85#10:625\n85#10:626\n85#10:627\n*S KotlinDebug\n*F\n+ 1 MiniPlayer.kt\ndev/brahmkshatriya/echo/desktop/ui/player/MiniPlayerKt\n*L\n67#1:272\n75#1:316\n137#1:441\n138#1:442\n143#1:443\n200#1:529\n214#1:572\n261#1:614\n267#1:615\n63#1:273\n63#1:274,9\n63#1:403\n145#1:444\n145#1:445,10\n145#1:491\n63#1:283,6\n63#1:298,3\n63#1:307,2\n79#1:327,6\n79#1:342,3\n79#1:351,2\n79#1:398\n63#1:402\n126#1:414,6\n126#1:429,3\n126#1:438,2\n145#1:455,6\n145#1:470,3\n145#1:479,2\n145#1:490\n126#1:494\n177#1:502,6\n177#1:517,3\n177#1:526,2\n198#1:545,6\n198#1:560,3\n198#1:569,2\n198#1:575\n177#1:579\n249#1:587,6\n249#1:602,3\n249#1:611,2\n249#1:618\n63#1:289,9\n63#1:309\n79#1:333,9\n79#1:353\n79#1:396,2\n63#1:400,2\n126#1:420,9\n126#1:440\n145#1:461,9\n145#1:481\n145#1:488,2\n126#1:492,2\n177#1:508,9\n177#1:528\n198#1:551,9\n198#1:571\n198#1:573,2\n177#1:577,2\n249#1:593,9\n249#1:613\n249#1:616,2\n63#1:301,6\n79#1:345,6\n126#1:432,6\n145#1:473,6\n177#1:520,6\n198#1:563,6\n249#1:605,6\n74#1:310,6\n95#1:354,6\n96#1:360,6\n97#1:366,6\n98#1:372,6\n99#1:378,6\n116#1:384,6\n117#1:390,6\n154#1:482,6\n204#1:530,6\n79#1:317\n79#1:318,9\n79#1:399\n126#1:404\n126#1:405,9\n126#1:495\n177#1:496,6\n177#1:580\n249#1:581,6\n249#1:619\n198#1:536\n198#1:537,8\n198#1:576\n54#1:620\n55#1:621\n56#1:622\n57#1:623\n58#1:624\n59#1:625\n60#1:626\n61#1:627\n*E\n"})
public final class MiniPlayerKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void MiniPlayer(@NotNull PlayerViewModel viewModel2, @Nullable Modifier modifier, @Nullable Composer $composer, int $changed, int n) {
        block35: {
            Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
            $composer = $composer.startRestartGroup(-1431410551);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(MiniPlayer)P(1)53@2389L16,54@2447L16,55@2507L16,56@2567L16,57@2619L16,58@2679L16,59@2747L16,60@2797L16,65@2921L11,62@2819L2112:MiniPlayer.kt#2fsrc7");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if ((n & 2) != 0) {
                $dirty |= 0x30;
            } else if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                Object object;
                Object object2;
                long l;
                long l2;
                Object object3;
                Object object4;
                Function0 function0;
                Object object5;
                KFunction kFunction;
                Object object6;
                KFunction kFunction2;
                Object object7;
                KFunction value$iv;
                KFunction kFunction3;
                boolean bl;
                PlayerState playerState;
                boolean bl2;
                RepeatMode repeatMode;
                void $this$cache$iv;
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void verticalAlignment$iv;
                void $composer$iv;
                int $i$f$cache;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $changed$iv2;
                void $composer$iv2;
                if ((n & 2) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-1431410551, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.MiniPlayer (MiniPlayer.kt:52)");
                }
                State currentTrack$delegate = SnapshotStateKt.collectAsState(viewModel2.getCurrentTrack(), null, (Composer)$composer, (int)0, (int)1);
                State isPlaying$delegate = SnapshotStateKt.collectAsState(viewModel2.isPlaying(), null, (Composer)$composer, (int)0, (int)1);
                State positionMs$delegate = SnapshotStateKt.collectAsState(viewModel2.getPositionMs(), null, (Composer)$composer, (int)0, (int)1);
                State durationMs$delegate = SnapshotStateKt.collectAsState(viewModel2.getDurationMs(), null, (Composer)$composer, (int)0, (int)1);
                State volume$delegate = SnapshotStateKt.collectAsState(viewModel2.getVolume(), null, (Composer)$composer, (int)0, (int)1);
                State repeatMode$delegate = SnapshotStateKt.collectAsState(viewModel2.getRepeatMode(), null, (Composer)$composer, (int)0, (int)1);
                State shuffleEnabled$delegate = SnapshotStateKt.collectAsState(viewModel2.getShuffleEnabled(), null, (Composer)$composer, (int)0, (int)1);
                State state$delegate = SnapshotStateKt.collectAsState(viewModel2.getState(), null, (Composer)$composer, (int)0, (int)1);
                int $this$dp$iv = 16;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 8;
                $i$f$getDp = false;
                Modifier $this$dp$iv2 = PaddingKt.padding-VpY3zN4((Modifier)BackgroundKt.background-bw27NRU$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)modifier, (float)0.0f, (int)1, null), (long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface-0d7_KjU(), null, (int)2, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                Composer composer = $composer;
                boolean bl3 = false;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void var21_23 = modifier$iv2;
                int n2 = 0x70 & $changed$iv2 << 3;
                boolean $i$f$Layout = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
                CompositionLocalMap localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
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
                boolean bl4 = false;
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
                void $composer$iv3 = $composer$iv2;
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n5 = 6 | 0x70 & $changed$iv2 >> 6;
                void var40_42 = $composer$iv3;
                ColumnScope $this$MiniPlayer_u24lambda_u2420 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1699186521, (String)"C78@3376L1549:MiniPlayer.kt#2fsrc7");
                if (MiniPlayerKt.MiniPlayer$lambda$3((State<Long>)durationMs$delegate) > 0L) {
                    Object object8;
                    void $this$cache$iv2;
                    float progress;
                    $composer3.startReplaceGroup(-1699215631);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"73@3228L48,71@3154L202");
                    float f2 = progress = RangesKt.coerceIn((float)((float)MiniPlayerKt.MiniPlayer$lambda$2((State<Long>)positionMs$delegate) / (float)MiniPlayerKt.MiniPlayer$lambda$3((State<Long>)durationMs$delegate)), (float)0.0f, (float)1.0f);
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)499381039, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                    void var44_47 = $composer3;
                    boolean invalid$iv = $composer.changedInstance((Object)viewModel2) | $composer.changed((Object)durationMs$delegate);
                    $i$f$cache = 0;
                    Object it$iv = $this$cache$iv2.rememberedValue();
                    boolean bl9 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        float f3 = f2;
                        boolean bl10 = false;
                        Function1 function1 = arg_0 -> MiniPlayerKt.MiniPlayer$lambda$20$lambda$9$lambda$8(viewModel2, durationMs$delegate, arg_0);
                        f2 = f3;
                        Function1 value$iv2 = function1;
                        $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                        object8 = value$iv2;
                    } else {
                        object8 = it$iv;
                    }
                    Function1 function1 = (Function1)object8;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                    int $this$dp$iv3 = 16;
                    boolean $i$f$getDp2 = false;
                    SliderKt.Slider((float)f2, (Function1)function1, (Modifier)SizeKt.height-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv3)), (boolean)false, null, (int)0, null, null, null, (Composer)$composer3, (int)384, (int)504);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-1702261629);
                    $composer3.endReplaceGroup();
                }
                Modifier progress = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                Alignment.Vertical $i$f$getDp2 = Alignment.Companion.getCenterVertically();
                void invalid$iv = $composer3;
                $i$f$cache = 390;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void bl10 = modifier$iv;
                int value$iv2 = 0x70 & $changed$iv << 3;
                boolean $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                Function0 function03 = ComposeUiNode.Companion.getConstructor();
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
                boolean bl11 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n8 = 6 | 0x70 & $changed$iv >> 6;
                void var71_83 = $composer$iv4;
                RowScope $this$MiniPlayer_u24lambda_u2420_u24lambda_u2419 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl12 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)966204870, (String)"C83@3545L109,94@3917L23,95@3972L26,96@4025L19,97@4080L41,98@4156L341,89@3710L849,115@4773L20,116@4828L25,111@4610L305:MiniPlayer.kt#2fsrc7");
                MiniPlayerKt.TrackInfo(MiniPlayerKt.MiniPlayer$lambda$0((State<Track>)currentTrack$delegate), RowScope.weight$default((RowScope)$this$MiniPlayer_u24lambda_u2420_u24lambda_u2419, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Composer)$composer2, 0, 0);
                boolean bl13 = MiniPlayerKt.MiniPlayer$lambda$1((State<Boolean>)isPlaying$delegate);
                PlayerState playerState2 = MiniPlayerKt.MiniPlayer$lambda$7((State<PlayerState>)state$delegate);
                boolean bl14 = MiniPlayerKt.MiniPlayer$lambda$6((State<Boolean>)shuffleEnabled$delegate);
                RepeatMode repeatMode2 = MiniPlayerKt.MiniPlayer$lambda$5((State<? extends RepeatMode>)repeatMode$delegate);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047031526, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                void var74_86 = $composer2;
                boolean invalid$iv2 = $composer.changedInstance((Object)viewModel2);
                boolean $i$f$cache2 = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    repeatMode = repeatMode2;
                    bl2 = bl14;
                    playerState = playerState2;
                    bl = bl13;
                    boolean bl16 = false;
                    kFunction3 = (KFunction)new Function0<Unit>((Object)viewModel2){

                        public final void invoke() {
                            ((PlayerViewModel)this.receiver).skipPrevious();
                        }
                    };
                    bl13 = bl;
                    playerState2 = playerState;
                    bl14 = bl2;
                    repeatMode2 = repeatMode;
                    value$iv = kFunction3;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object7 = value$iv;
                } else {
                    object7 = it$iv;
                }
                KFunction kFunction4 = (KFunction)object7;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function0 function04 = (Function0)kFunction4;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047029763, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    kFunction3 = function04;
                    repeatMode = repeatMode2;
                    bl2 = bl14;
                    playerState = playerState2;
                    bl = bl13;
                    boolean bl17 = false;
                    kFunction2 = (KFunction)new Function0<Unit>((Object)viewModel2){

                        public final void invoke() {
                            ((PlayerViewModel)this.receiver).togglePlayPause();
                        }
                    };
                    bl13 = bl;
                    playerState2 = playerState;
                    bl14 = bl2;
                    repeatMode2 = repeatMode;
                    function04 = kFunction3;
                    value$iv = kFunction2;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object6 = value$iv;
                } else {
                    object6 = it$iv;
                }
                kFunction4 = (KFunction)object6;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function0 function05 = (Function0)kFunction4;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047028074, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    kFunction2 = function05;
                    kFunction3 = function04;
                    repeatMode = repeatMode2;
                    bl2 = bl14;
                    playerState = playerState2;
                    bl = bl13;
                    boolean bl18 = false;
                    kFunction = (KFunction)new Function0<Unit>((Object)viewModel2){

                        public final void invoke() {
                            ((PlayerViewModel)this.receiver).skipNext();
                        }
                    };
                    bl13 = bl;
                    playerState2 = playerState;
                    bl14 = bl2;
                    repeatMode2 = repeatMode;
                    function04 = kFunction3;
                    function05 = kFunction2;
                    value$iv = kFunction;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object5 = value$iv;
                } else {
                    object5 = it$iv;
                }
                kFunction4 = (KFunction)object5;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function0 function06 = (Function0)kFunction4;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047026292, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2) | $composer.changed((Object)shuffleEnabled$delegate);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    kFunction = function06;
                    kFunction2 = function05;
                    kFunction3 = function04;
                    repeatMode = repeatMode2;
                    bl2 = bl14;
                    playerState = playerState2;
                    bl = bl13;
                    boolean bl19 = false;
                    function0 = () -> MiniPlayerKt.MiniPlayer$lambda$20$lambda$19$lambda$14$lambda$13(viewModel2, shuffleEnabled$delegate);
                    bl13 = bl;
                    playerState2 = playerState;
                    bl14 = bl2;
                    repeatMode2 = repeatMode;
                    function04 = kFunction3;
                    function05 = kFunction2;
                    function06 = kFunction;
                    value$iv = function0;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object4 = value$iv;
                } else {
                    object4 = it$iv;
                }
                kFunction4 = (Function0)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                KFunction kFunction5 = kFunction4;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047023560, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2) | $composer.changed((Object)repeatMode$delegate);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    function0 = kFunction5;
                    kFunction = function06;
                    kFunction2 = function05;
                    kFunction3 = function04;
                    repeatMode = repeatMode2;
                    bl2 = bl14;
                    playerState = playerState2;
                    bl = bl13;
                    boolean bl20 = false;
                    Function0 function07 = () -> MiniPlayerKt.MiniPlayer$lambda$20$lambda$19$lambda$16$lambda$15(viewModel2, repeatMode$delegate);
                    bl13 = bl;
                    playerState2 = playerState;
                    bl14 = bl2;
                    repeatMode2 = repeatMode;
                    function04 = kFunction3;
                    function05 = kFunction2;
                    function06 = kFunction;
                    kFunction5 = function0;
                    value$iv = function07;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv;
                }
                kFunction4 = (Function0)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                MiniPlayerKt.PlaybackControls(bl13, playerState2, bl14, repeatMode2, (Function0<Unit>)function04, (Function0<Unit>)function05, (Function0<Unit>)function06, (Function0<Unit>)kFunction5, (Function0<Unit>)kFunction4, RowScope.weight$default((RowScope)$this$MiniPlayer_u24lambda_u2420_u24lambda_u2419, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Composer)$composer2, 0, 0);
                long l3 = MiniPlayerKt.MiniPlayer$lambda$2((State<Long>)positionMs$delegate);
                long l4 = MiniPlayerKt.MiniPlayer$lambda$3((State<Long>)durationMs$delegate);
                float f4 = MiniPlayerKt.MiniPlayer$lambda$4((State<Float>)volume$delegate);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047004137, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    float f5 = f4;
                    l2 = l4;
                    l = l3;
                    boolean bl21 = false;
                    kFunction2 = (KFunction)new Function1<Float, Unit>((Object)viewModel2){

                        public final void invoke(float p0) {
                            ((PlayerViewModel)this.receiver).setVolume(p0);
                        }
                    };
                    l3 = l;
                    l4 = l2;
                    f4 = f5;
                    value$iv = kFunction2;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv;
                }
                kFunction4 = (KFunction)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function1 function1 = (Function1)kFunction4;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2047002372, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2);
                $i$f$cache2 = false;
                it$iv = $this$cache$iv.rememberedValue();
                bl15 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    kFunction2 = function1;
                    float f6 = f4;
                    l2 = l4;
                    l = l3;
                    boolean bl22 = false;
                    kFunction = (KFunction)new Function1<Long, String>((Object)viewModel2){

                        public final String invoke(long p0) {
                            return ((PlayerViewModel)this.receiver).formatDuration(p0);
                        }
                    };
                    l3 = l;
                    l4 = l2;
                    f4 = f6;
                    function1 = kFunction2;
                    value$iv = kFunction;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                kFunction4 = (KFunction)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                MiniPlayerKt.VolumeAndTime(l3, l4, f4, (Function1<? super Float, Unit>)function1, (Function1<? super Long, String>)((Function1)kFunction4), RowScope.weight$default((RowScope)$this$MiniPlayer_u24lambda_u2420_u24lambda_u2419, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Composer)$composer2, 0, 0);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block35;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MiniPlayerKt.MiniPlayer$lambda$21(viewModel2, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void TrackInfo(Track track2, Modifier modifier, Composer $composer, int $changed, int n) {
        block23: {
            $composer = $composer.startRestartGroup(1172779292);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(TrackInfo)P(1)125@5021L1327:MiniPlayer.kt#2fsrc7");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)track2) ? 4 : 2;
            }
            if ((n & 2) != 0) {
                $dirty |= 0x30;
            } else if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                String string2;
                String string3;
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void $changed$iv;
                void $composer$iv;
                ImageHolder cover;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv;
                void verticalAlignment$iv;
                void $composer$iv2;
                if ((n & 2) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1172779292, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.TrackInfo (MiniPlayer.kt:124)");
                }
                Modifier modifier2 = modifier;
                Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
                Composer composer = $composer;
                int $changed$iv2 = 0x180 | 0xE & $dirty >> 3;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void var13_13 = modifier$iv;
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
                void var32_32 = $composer$iv3;
                RowScope $this$TrackInfo_u24lambda_u2425 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1053394762, (String)"C138@5593L11,132@5354L322,142@5686L29,144@5725L617:MiniPlayer.kt#2fsrc7");
                Track track3 = track2;
                ImageHolder imageHolder = cover = track3 != null ? track3.getCover() : null;
                String coverUrl = cover instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)cover).getRequest().getUrl() : (cover instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)cover).getUri() : null);
                int $this$dp$iv = 48;
                boolean $i$f$getDp = false;
                Modifier modifier3 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
                $this$dp$iv = 6;
                $i$f$getDp = false;
                SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)coverUrl, (String)"Album Art", (Modifier)BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)modifier3, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv)))), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), null, (int)2, null), null, null, null, (ContentScale)ContentScale.Companion.getCrop(), (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer3, (int)1572912, (int)0, (int)1976);
                $this$dp$iv = 12;
                $i$f$getDp = false;
                SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer3, (int)6);
                void var38_41 = $composer3;
                boolean bl6 = false;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Modifier modifier$iv2 = (Modifier)Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                Modifier modifier4 = modifier$iv2;
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
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n9 = 6 | 0x70 & $changed$iv >> 6;
                void var62_65 = $composer$iv4;
                ColumnScope $this$TrackInfo_u24lambda_u2425_u24lambda_u2424 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1848270089, (String)"C147@5850L10,145@5746L269,154@6150L10,155@6210L11,152@6028L304:MiniPlayer.kt#2fsrc7");
                Object object = track2;
                if (object == null || (object = ((Track)object).getTitle()) == null) {
                    object = "No track selected";
                }
                Object object2 = object;
                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
                Object object3 = FontWeight.Companion.getSemiBold();
                int n10 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                TextKt.Text--4IGK_g((String)object2, null, (long)0L, (long)0L, null, (FontWeight)object3, null, (long)0L, null, null, (long)0L, (int)n10, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196608, (int)3120, (int)55262);
                Track track4 = track2;
                Object object4 = object3 = track4 != null ? track4.getArtists() : null;
                if (object3 == null) {
                    $composer2.startReplaceGroup(-1847962912);
                    $composer2.endReplaceGroup();
                    string3 = null;
                } else {
                    Object object5;
                    void $this$cache$iv;
                    $composer2.startReplaceGroup(-198159039);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"153@6093L11");
                    Iterable iterable = (Iterable)object3;
                    CharSequence charSequence = " \u00b7 ";
                    CharSequence charSequence2 = null;
                    CharSequence charSequence3 = null;
                    int n11 = 0;
                    CharSequence charSequence4 = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-198158419, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                    void var69_73 = $composer2;
                    boolean invalid$iv = false;
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl9 = false;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        CharSequence charSequence5 = charSequence4;
                        int n12 = n11;
                        CharSequence charSequence6 = charSequence3;
                        CharSequence charSequence7 = charSequence2;
                        CharSequence charSequence8 = charSequence;
                        Iterable iterable2 = iterable;
                        boolean bl10 = false;
                        Function1 function1 = MiniPlayerKt::TrackInfo$lambda$25$lambda$24$lambda$23$lambda$22;
                        iterable = iterable2;
                        charSequence = charSequence8;
                        charSequence2 = charSequence7;
                        charSequence3 = charSequence6;
                        n11 = n12;
                        charSequence4 = charSequence5;
                        Function1 value$iv = function1;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object5 = value$iv;
                    } else {
                        object5 = it$iv;
                    }
                    Function1 function1 = (Function1)object5;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    String string4 = CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)charSequence, charSequence2, charSequence3, (int)n11, charSequence4, (Function1)function1, (int)30, null);
                    $composer2.endReplaceGroup();
                    string3 = string2 = string4;
                }
                if (string3 == null) {
                    string2 = "";
                }
                object2 = string2;
                textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                int n13 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                TextKt.Text--4IGK_g((String)object2, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)n13, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)3120, (int)55290);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block23;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MiniPlayerKt.TrackInfo$lambda$26(track2, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void PlaybackControls(boolean isPlaying2, PlayerState state, boolean shuffleEnabled, RepeatMode repeatMode, Function0<Unit> onPrevious, Function0<Unit> onPlayPause, Function0<Unit> onNext, Function0<Unit> onShuffleToggle, Function0<Unit> onRepeatToggle, Modifier modifier, Composer $composer, int $changed, int n) {
        block26: {
            $composer = $composer.startRestartGroup(-1692320413);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(PlaybackControls)P(!1,9,8,7,4,3,2,6,5)176@6688L2110:MiniPlayer.kt#2fsrc7");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(isPlaying2) ? 4 : 2;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(shuffleEnabled) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed(((Enum)repeatMode).ordinal()) ? 2048 : 1024;
            }
            if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changedInstance(onPrevious) ? 16384 : 8192;
            }
            if (($changed & 0x30000) == 0) {
                $dirty |= $composer.changedInstance(onPlayPause) ? 131072 : 65536;
            }
            if (($changed & 0x180000) == 0) {
                $dirty |= $composer.changedInstance(onNext) ? 0x100000 : 524288;
            }
            if (($changed & 0xC00000) == 0) {
                $dirty |= $composer.changedInstance(onShuffleToggle) ? 0x800000 : 0x400000;
            }
            if (($changed & 0x6000000) == 0) {
                $dirty |= $composer.changedInstance(onRepeatToggle) ? 0x4000000 : 0x2000000;
            }
            if ((n & 0x200) != 0) {
                $dirty |= 0x30000000;
            } else if (($changed & 0x30000000) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 0x20000000 : 0x10000000;
            }
            if ($composer.shouldExecute(($dirty & 0x12492483) != 306783362, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void $changed$iv;
                void modifier$iv;
                void contentAlignment$iv;
                void $composer$iv;
                Object object;
                Alignment $this$cache$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $changed$iv2;
                void verticalAlignment$iv;
                void horizontalArrangement$iv;
                void $composer$iv2;
                if ((n & 0x200) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-1692320413, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.PlaybackControls (MiniPlayer.kt:175)");
                }
                Modifier modifier2 = modifier;
                Arrangement.Horizontal horizontal = (Arrangement.Horizontal)Arrangement.INSTANCE.getCenter();
                Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
                Composer composer = $composer;
                int n2 = 0x1B0 | 0xE & $dirty >> 27;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void var21_21 = modifier$iv2;
                int n3 = 0x70 & $changed$iv2 << 3;
                boolean $i$f$Layout = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
                CompositionLocalMap localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
                Function0 function0 = ComposeUiNode.Companion.getConstructor();
                int n4 = 6 | 0x380 & $changed$iv$iv2 << 6;
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
                int n5 = 0xE & $changed$iv$iv$iv2 >> 6;
                void $composer$iv3 = $composer$iv2;
                boolean bl4 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n6 = 6 | 0x70 & $changed$iv2 >> 6;
                void var40_40 = $composer$iv3;
                RowScope $this$PlaybackControls_u24lambda_u2431 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-2072020228, (String)"C182@6902L278,182@6864L316,192@7210L123,201@7508L11,203@7597L39,197@7365L750,218@8141L111,223@8317L475,223@8280L512:MiniPlayer.kt#2fsrc7");
                IconButtonKt.IconButton(onShuffleToggle, null, (boolean)false, null, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)1842521794, (boolean)true, (arg_0, arg_1) -> MiniPlayerKt.PlaybackControls$lambda$31$lambda$27(shuffleEnabled, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)(0x30000 | 0xE & $dirty >> 21), (int)30);
                IconButtonKt.IconButton(onPrevious, null, (boolean)false, null, null, ComposableSingletons$MiniPlayerKt.INSTANCE.getLambda$100345387$desktopApp(), (Composer)$composer3, (int)(0x30000 | 0xE & $dirty >> 12), (int)30);
                int $this$dp$iv22 = 44;
                boolean $i$f$getDp22 = false;
                Modifier modifier3 = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22)), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), null, (int)2, null);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1318655526, (String)"CC(remember):MiniPlayer.kt#9igjgp");
                void $i$f$getDp22 = $composer3;
                boolean invalid$iv = false;
                boolean $i$f$cache22 = false;
                Object it$iv22 = $this$cache$iv.rememberedValue();
                boolean bl6 = false;
                if (it$iv22 == Composer.Companion.getEmpty()) {
                    Modifier modifier4 = modifier3;
                    boolean bl7 = false;
                    modifier3 = modifier4;
                    MutableInteractionSource value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv22;
                }
                MutableInteractionSource $this$dp$iv22 = (MutableInteractionSource)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                $this$dp$iv22 = ClickableKt.clickable-O2vRcR0$default((Modifier)modifier3, (MutableInteractionSource)$this$dp$iv22, null, (boolean)false, null, null, onPlayPause, (int)28, null);
                $this$cache$iv = Alignment.Companion.getCenter();
                void $i$f$cache22 = $composer3;
                int it$iv22 = 48;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                void var51_56 = modifier$iv;
                int n7 = 0x70 & $changed$iv << 3;
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
                void $composer$iv4 = $composer$iv;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n10 = 6 | 0x70 & $changed$iv >> 6;
                void var70_75 = $composer$iv4;
                BoxScope $this$PlaybackControls_u24lambda_u2431_u24lambda_u2429 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1407965475, (String)"C212@8021L11,209@7810L295:MiniPlayer.kt#2fsrc7");
                ImageVector imageVector = isPlaying2 ? PauseKt.getPause((Icons.Filled)Icons.INSTANCE.getDefault()) : PlayArrowKt.getPlayArrow((Icons.Filled)Icons.INSTANCE.getDefault());
                String string2 = isPlaying2 ? "Pause" : "Play";
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                int $this$dp$iv = 26;
                boolean $i$f$getDp = false;
                Modifier modifier5 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
                IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)string2, (Modifier)modifier5, (long)l, (Composer)$composer2, (int)384, (int)0);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                IconButtonKt.IconButton(onNext, null, (boolean)false, null, null, ComposableSingletons$MiniPlayerKt.INSTANCE.getLambda$-17291382$desktopApp(), (Composer)$composer3, (int)(0x30000 | 0xE & $dirty >> 18), (int)30);
                IconButtonKt.IconButton(onRepeatToggle, null, (boolean)false, null, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-134928151, (boolean)true, (arg_0, arg_1) -> MiniPlayerKt.PlaybackControls$lambda$31$lambda$30(repeatMode, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)(0x30000 | 0xE & $dirty >> 24), (int)30);
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block26;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MiniPlayerKt.PlaybackControls$lambda$32(isPlaying2, state, shuffleEnabled, repeatMode, onPrevious, onPlayPause, onNext, onShuffleToggle, onRepeatToggle, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void VolumeAndTime(long positionMs, long durationMs, float volume, Function1<? super Float, Unit> onVolumeChange, Function1<? super Long, String> formatDuration, Modifier modifier, Composer $composer, int $changed, int n) {
        block17: {
            $composer = $composer.startRestartGroup(-1627358144);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(VolumeAndTime)P(4!1,5,3)248@9022L610:MiniPlayer.kt#2fsrc7");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(positionMs) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed(durationMs) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(volume) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changedInstance(onVolumeChange) ? 2048 : 1024;
            }
            if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changedInstance(formatDuration) ? 16384 : 8192;
            }
            if ((n & 0x20) != 0) {
                $dirty |= 0x30000;
            } else if (($changed & 0x30000) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 131072 : 65536;
            }
            if ($composer.shouldExecute(($dirty & 0x12493) != 74898, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void verticalAlignment$iv;
                void horizontalArrangement$iv;
                void $composer$iv;
                if ((n & 0x20) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-1627358144, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.VolumeAndTime (MiniPlayer.kt:247)");
                }
                Modifier modifier2 = modifier;
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.getEnd();
                Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
                Composer composer = $composer;
                int n2 = 0x1B0 | 0xE & $dirty >> 15;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var19_17 = modifier$iv;
                int n3 = 0x70 & $changed$iv << 3;
                boolean $i$f$Layout = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                Function0 function0 = ComposeUiNode.Companion.getConstructor();
                int n4 = 6 | 0x380 & $changed$iv$iv << 6;
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
                int n5 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv2 = $composer$iv;
                boolean bl4 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n6 = 6 | 0x70 & $changed$iv >> 6;
                void var38_36 = $composer$iv2;
                RowScope $this$VolumeAndTime_u24lambda_u2433 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1606497155, (String)"C256@9324L10,257@9380L11,254@9200L218,260@9428L28,263@9491L135:MiniPlayer.kt#2fsrc7");
                String string2 = formatDuration.invoke((Object)positionMs) + " / " + formatDuration.invoke((Object)durationMs);
                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)string2, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
                int $this$dp$iv = 8;
                boolean $i$f$getDp = false;
                SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer2, (int)6);
                $this$dp$iv = 100;
                $i$f$getDp = false;
                SliderKt.Slider((float)volume, onVolumeChange, (Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (boolean)false, null, (int)0, null, null, null, (Composer)$composer2, (int)(0x180 | 0xE & $dirty >> 6 | 0x70 & $dirty >> 6), (int)504);
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
            if (scopeUpdateScope == null) break block17;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MiniPlayerKt.VolumeAndTime$lambda$34(positionMs, durationMs, volume, onVolumeChange, formatDuration, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final Track MiniPlayer$lambda$0(State<Track> $currentTrack$delegate) {
        void $this$getValue$iv;
        State<Track> state = $currentTrack$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Track)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean MiniPlayer$lambda$1(State<Boolean> $isPlaying$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isPlaying$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final long MiniPlayer$lambda$2(State<Long> $positionMs$delegate) {
        void $this$getValue$iv;
        State<Long> state = $positionMs$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).longValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final long MiniPlayer$lambda$3(State<Long> $durationMs$delegate) {
        void $this$getValue$iv;
        State<Long> state = $durationMs$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).longValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float MiniPlayer$lambda$4(State<Float> $volume$delegate) {
        void $this$getValue$iv;
        State<Float> state = $volume$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final RepeatMode MiniPlayer$lambda$5(State<? extends RepeatMode> $repeatMode$delegate) {
        void $this$getValue$iv;
        State<? extends RepeatMode> state = $repeatMode$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (RepeatMode)((Object)$this$getValue$iv.getValue());
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean MiniPlayer$lambda$6(State<Boolean> $shuffleEnabled$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $shuffleEnabled$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final PlayerState MiniPlayer$lambda$7(State<PlayerState> $state$delegate) {
        void $this$getValue$iv;
        State<PlayerState> state = $state$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (PlayerState)$this$getValue$iv.getValue();
    }

    private static final Unit MiniPlayer$lambda$20$lambda$9$lambda$8(PlayerViewModel $viewModel, State $durationMs$delegate, float it) {
        $viewModel.seekTo((long)(it * (float)MiniPlayerKt.MiniPlayer$lambda$3((State<Long>)$durationMs$delegate)));
        return Unit.INSTANCE;
    }

    private static final Unit MiniPlayer$lambda$20$lambda$19$lambda$14$lambda$13(PlayerViewModel $viewModel, State $shuffleEnabled$delegate) {
        $viewModel.setShuffle(!MiniPlayerKt.MiniPlayer$lambda$6((State<Boolean>)$shuffleEnabled$delegate));
        return Unit.INSTANCE;
    }

    private static final Unit MiniPlayer$lambda$20$lambda$19$lambda$16$lambda$15(PlayerViewModel $viewModel, State $repeatMode$delegate) {
        $viewModel.setRepeatMode(switch (WhenMappings.$EnumSwitchMapping$0[MiniPlayerKt.MiniPlayer$lambda$5((State<? extends RepeatMode>)$repeatMode$delegate).ordinal()]) {
            case 1 -> RepeatMode.ALL;
            case 2 -> RepeatMode.ONE;
            case 3 -> RepeatMode.NONE;
            default -> throw new NoWhenBranchMatchedException();
        });
        return Unit.INSTANCE;
    }

    private static final Unit MiniPlayer$lambda$21(PlayerViewModel $viewModel, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        MiniPlayerKt.MiniPlayer($viewModel, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final CharSequence TrackInfo$lambda$25$lambda$24$lambda$23$lambda$22(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final Unit TrackInfo$lambda$26(Track $track, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        MiniPlayerKt.TrackInfo($track, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit PlaybackControls$lambda$31$lambda$27(boolean $shuffleEnabled, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C183@6916L254:MiniPlayer.kt#2fsrc7");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1842521794, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.PlaybackControls.<anonymous>.<anonymous> (MiniPlayer.kt:183)");
            }
            ImageVector imageVector = ShuffleKt.getShuffle((Icons.Filled)Icons.INSTANCE.getDefault());
            if ($shuffleEnabled) {
                $composer.startReplaceGroup(1136923721);
                ComposerKt.sourceInformation((Composer)$composer, (String)"186@7066L11");
                long l2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = l2;
            } else {
                $composer.startReplaceGroup(1136925714);
                ComposerKt.sourceInformation((Composer)$composer, (String)"187@7128L11");
                long l3 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                $composer.endReplaceGroup();
                l = l3;
            }
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Shuffle", null, (long)l, (Composer)$composer, (int)48, (int)4);
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
    private static final Unit PlaybackControls$lambda$31$lambda$30(RepeatMode $repeatMode, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C224@8331L451:MiniPlayer.kt#2fsrc7");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-134928151, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.player.PlaybackControls.<anonymous>.<anonymous> (MiniPlayer.kt:224)");
            }
            ImageVector imageVector = WhenMappings.$EnumSwitchMapping$0[$repeatMode.ordinal()] == 3 ? RepeatOneKt.getRepeatOne((Icons.Filled)Icons.INSTANCE.getDefault()) : RepeatKt.getRepeat((Icons.Filled)Icons.INSTANCE.getDefault());
            if (WhenMappings.$EnumSwitchMapping$0[$repeatMode.ordinal()] == 1) {
                $composer.startReplaceGroup(-816922855);
                ComposerKt.sourceInformation((Composer)$composer, (String)"231@8660L11");
                long l2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                $composer.endReplaceGroup();
                l = l2;
            } else {
                $composer.startReplaceGroup(-816920592);
                ComposerKt.sourceInformation((Composer)$composer, (String)"232@8731L11");
                long l3 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = l3;
            }
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Repeat", null, (long)l, (Composer)$composer, (int)48, (int)4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit PlaybackControls$lambda$32(boolean $isPlaying, PlayerState $state, boolean $shuffleEnabled, RepeatMode $repeatMode, Function0 $onPrevious, Function0 $onPlayPause, Function0 $onNext, Function0 $onShuffleToggle, Function0 $onRepeatToggle, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        MiniPlayerKt.PlaybackControls($isPlaying, $state, $shuffleEnabled, $repeatMode, (Function0<Unit>)$onPrevious, (Function0<Unit>)$onPlayPause, (Function0<Unit>)$onNext, (Function0<Unit>)$onShuffleToggle, (Function0<Unit>)$onRepeatToggle, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit VolumeAndTime$lambda$34(long $positionMs, long $durationMs, float $volume, Function1 $onVolumeChange, Function1 $formatDuration, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        MiniPlayerKt.VolumeAndTime($positionMs, $durationMs, $volume, (Function1<? super Float, Unit>)$onVolumeChange, (Function1<? super Long, String>)$formatDuration, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[RepeatMode.values().length];
            try {
                nArray[RepeatMode.NONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RepeatMode.ALL.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[RepeatMode.ONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

