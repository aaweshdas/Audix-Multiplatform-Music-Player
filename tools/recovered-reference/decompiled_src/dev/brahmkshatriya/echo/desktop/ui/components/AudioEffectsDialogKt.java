/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.BorderStroke
 *  androidx.compose.foundation.BorderStrokeKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
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
 *  androidx.compose.foundation.shape.RoundedCornerShape
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.GraphicEqKt
 *  androidx.compose.material.icons.filled.SpeedKt
 *  androidx.compose.material3.AlertDialog_skikoKt
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.SliderColors
 *  androidx.compose.material3.SliderDefaults
 *  androidx.compose.material3.SliderKt
 *  androidx.compose.material3.SurfaceKt
 *  androidx.compose.material3.SwitchColors
 *  androidx.compose.material3.SwitchDefaults
 *  androidx.compose.material3.SwitchKt
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
 *  androidx.compose.ui.Modifier$Companion
 *  androidx.compose.ui.draw.ClipKt
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.GraphicsLayerModifierKt
 *  androidx.compose.ui.graphics.GraphicsLayerScope
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.graphics.TransformOrigin
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.semantics.Role
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.text.style.TextAlign
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.unit.TextUnitKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.GraphicEqKt;
import androidx.compose.material.icons.filled.SpeedKt;
import androidx.compose.material3.AlertDialog_skikoKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$AudioEffectsDialogKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0007\u00a2\u0006\u0002\u0010\f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r\u00b2\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0012\u001a\u00020\u0002X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0013\u001a\u00020\u0005X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0014\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2={"BAND_FREQUENCIES", "", "", "PRESETS", "PLAYBACK_SPEEDS", "", "AudioEffectsDialog", "", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onDismiss", "Lkotlin/Function0;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "enabled", "", "bands", "", "preset", "bassBoost", "playbackRate"})
@SourceDebugExtension(value={"SMAP\nAudioEffectsDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioEffectsDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/AudioEffectsDialogKt\n+ 2 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 5 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 10 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 11 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 12 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n*L\n1#1,407:1\n85#2:408\n85#2:409\n85#2:410\n85#2:411\n85#2:412\n113#3:413\n113#3:420\n113#3:492\n113#3:493\n113#3:578\n113#3:593\n113#3:594\n113#3:595\n113#3:596\n113#3:634\n113#3:635\n113#3:636\n113#3:674\n113#3:675\n113#3:676\n113#3:688\n113#3:689\n113#3:727\n113#3:728\n113#3:729\n113#3:741\n113#3:742\n113#3:743\n113#3:744\n113#3:818\n113#3:819\n113#3:820\n113#3:863\n113#3:864\n113#3:875\n113#3:885\n113#3:923\n113#3:930\n113#3:1002\n113#3:1003\n113#3:1012\n113#3:1013\n113#3:1051\n113#3:1052\n113#3:1053\n1247#4,6:414\n1247#4,6:579\n1247#4,6:677\n1247#4,6:730\n1247#4,6:857\n1247#4,6:865\n1247#4,6:924\n1247#4,6:1054\n99#5,6:421\n99#5:454\n95#5,10:455\n106#5:539\n99#5:540\n95#5,10:541\n106#5:588\n106#5:592\n99#5:637\n97#5,8:638\n106#5:687\n99#5:690\n97#5,8:691\n106#5:740\n99#5,6:745\n106#5:884\n99#5,6:886\n106#5:922\n99#5,6:931\n99#5:964\n95#5,10:965\n106#5:1007\n106#5:1011\n99#5:1014\n97#5,8:1015\n106#5:1064\n79#6,6:427\n86#6,3:442\n89#6,2:451\n79#6,6:465\n86#6,3:480\n89#6,2:489\n79#6,6:505\n86#6,3:520\n89#6,2:529\n93#6:534\n93#6:538\n79#6,6:551\n86#6,3:566\n89#6,2:575\n93#6:587\n93#6:591\n79#6,6:607\n86#6,3:622\n89#6,2:631\n79#6,6:646\n86#6,3:661\n89#6,2:670\n93#6:686\n79#6,6:699\n86#6,3:714\n89#6,2:723\n93#6:739\n79#6,6:751\n86#6,3:766\n89#6,2:775\n79#6,6:791\n86#6,3:806\n89#6,2:815\n79#6,6:830\n86#6,3:845\n89#6,2:854\n93#6:873\n93#6:878\n93#6:883\n79#6,6:892\n86#6,3:907\n89#6,2:916\n93#6:921\n79#6,6:937\n86#6,3:952\n89#6,2:961\n79#6,6:975\n86#6,3:990\n89#6,2:999\n93#6:1006\n93#6:1010\n79#6,6:1023\n86#6,3:1038\n89#6,2:1047\n93#6:1063\n93#6:1067\n347#7,9:433\n356#7:453\n347#7,9:471\n356#7:491\n347#7,9:511\n356#7,3:531\n357#7,2:536\n347#7,9:557\n356#7:577\n357#7,2:585\n357#7,2:589\n347#7,9:613\n356#7:633\n347#7,9:652\n356#7:672\n357#7,2:684\n347#7,9:705\n356#7:725\n357#7,2:737\n347#7,9:757\n356#7:777\n347#7,9:797\n356#7:817\n347#7,9:836\n356#7:856\n357#7,2:871\n357#7,2:876\n357#7,2:881\n347#7,9:898\n356#7,3:918\n347#7,9:943\n356#7:963\n347#7,9:981\n356#7:1001\n357#7,2:1004\n357#7,2:1008\n347#7,9:1029\n356#7:1049\n357#7,2:1061\n357#7,2:1065\n4206#8,6:445\n4206#8,6:483\n4206#8,6:523\n4206#8,6:569\n4206#8,6:625\n4206#8,6:664\n4206#8,6:717\n4206#8,6:769\n4206#8,6:809\n4206#8,6:848\n4206#8,6:910\n4206#8,6:955\n4206#8,6:993\n4206#8,6:1041\n87#9:494\n83#9,10:495\n94#9:535\n87#9:597\n84#9,9:598\n87#9:781\n84#9,9:782\n94#9:879\n94#9:1068\n1869#10:673\n1870#10:683\n1869#10:726\n1870#10:736\n1878#10,2:778\n1880#10:880\n1869#10:1050\n1870#10:1060\n1#11:780\n70#12:821\n68#12,8:822\n77#12:874\n*S KotlinDebug\n*F\n+ 1 AudioEffectsDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/AudioEffectsDialogKt\n*L\n67#1:408\n68#1:409\n69#1:410\n70#1:411\n71#1:412\n390#1:413\n398#1:420\n86#1:492\n88#1:493\n108#1:578\n167#1:593\n202#1:594\n379#1:595\n124#1:596\n127#1:634\n138#1:635\n141#1:636\n146#1:674\n149#1:675\n154#1:676\n173#1:688\n176#1:689\n181#1:727\n184#1:728\n189#1:729\n209#1:741\n220#1:742\n225#1:743\n226#1:744\n241#1:818\n244#1:819\n245#1:820\n261#1:863\n262#1:864\n270#1:875\n283#1:885\n305#1:923\n322#1:930\n335#1:1002\n337#1:1003\n353#1:1012\n356#1:1013\n361#1:1051\n364#1:1052\n369#1:1053\n397#1:414,6\n111#1:579,6\n155#1:677,6\n190#1:730,6\n257#1:857,6\n250#1:865,6\n308#1:924,6\n370#1:1054,6\n76#1:421,6\n81#1:454\n81#1:455,10\n81#1:539\n102#1:540\n102#1:541,10\n102#1:588\n76#1:592\n139#1:637\n139#1:638,8\n139#1:687\n174#1:690\n174#1:691,8\n174#1:740\n222#1:745,6\n222#1:884\n286#1:886,6\n286#1:922\n325#1:931,6\n330#1:964\n330#1:965,10\n330#1:1007\n325#1:1011\n354#1:1014\n354#1:1015,8\n354#1:1064\n76#1:427,6\n76#1:442,3\n76#1:451,2\n81#1:465,6\n81#1:480,3\n81#1:489,2\n89#1:505,6\n89#1:520,3\n89#1:529,2\n89#1:534\n81#1:538\n102#1:551,6\n102#1:566,3\n102#1:575,2\n102#1:587\n76#1:591\n121#1:607,6\n121#1:622,3\n121#1:631,2\n139#1:646,6\n139#1:661,3\n139#1:670,2\n139#1:686\n174#1:699,6\n174#1:714,3\n174#1:723,2\n174#1:739\n222#1:751,6\n222#1:766,3\n222#1:775,2\n232#1:791,6\n232#1:806,3\n232#1:815,2\n242#1:830,6\n242#1:845,3\n242#1:854,2\n242#1:873\n232#1:878\n222#1:883\n286#1:892,6\n286#1:907,3\n286#1:916,2\n286#1:921\n325#1:937,6\n325#1:952,3\n325#1:961,2\n330#1:975,6\n330#1:990,3\n330#1:999,2\n330#1:1006\n325#1:1010\n354#1:1023,6\n354#1:1038,3\n354#1:1047,2\n354#1:1063\n121#1:1067\n76#1:433,9\n76#1:453\n81#1:471,9\n81#1:491\n89#1:511,9\n89#1:531,3\n81#1:536,2\n102#1:557,9\n102#1:577\n102#1:585,2\n76#1:589,2\n121#1:613,9\n121#1:633\n139#1:652,9\n139#1:672\n139#1:684,2\n174#1:705,9\n174#1:725\n174#1:737,2\n222#1:757,9\n222#1:777\n232#1:797,9\n232#1:817\n242#1:836,9\n242#1:856\n242#1:871,2\n232#1:876,2\n222#1:881,2\n286#1:898,9\n286#1:918,3\n325#1:943,9\n325#1:963\n330#1:981,9\n330#1:1001\n330#1:1004,2\n325#1:1008,2\n354#1:1029,9\n354#1:1049\n354#1:1061,2\n121#1:1065,2\n76#1:445,6\n81#1:483,6\n89#1:523,6\n102#1:569,6\n121#1:625,6\n139#1:664,6\n174#1:717,6\n222#1:769,6\n232#1:809,6\n242#1:848,6\n286#1:910,6\n325#1:955,6\n330#1:993,6\n354#1:1041,6\n89#1:494\n89#1:495,10\n89#1:535\n121#1:597\n121#1:598,9\n232#1:781\n232#1:782,9\n232#1:879\n121#1:1068\n143#1:673\n143#1:683\n178#1:726\n178#1:736\n230#1:778,2\n230#1:880\n358#1:1050\n358#1:1060\n242#1:821\n242#1:822,8\n242#1:874\n*E\n"})
public final class AudioEffectsDialogKt {
    @NotNull
    private static final List<String> BAND_FREQUENCIES;
    @NotNull
    private static final List<String> PRESETS;
    @NotNull
    private static final List<Float> PLAYBACK_SPEEDS;

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void AudioEffectsDialog(@NotNull PlayerViewModel viewModel2, @NotNull Function0<Unit> onDismiss, @Nullable Composer $composer, int $changed) {
        block6: {
            Intrinsics.checkNotNullParameter((Object)viewModel2, (String)"viewModel");
            Intrinsics.checkNotNullParameter(onDismiss, (String)"onDismiss");
            $composer = $composer.startRestartGroup(1557796543);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(AudioEffectsDialog)P(1)66@2764L16,67@2823L16,68@2884L16,69@2942L16,70@3006L16,386@19029L177,394@19232L356,74@3095L2129,119@5241L13762,72@3028L16566:AudioEffectsDialog.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)viewModel2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onDismiss) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1557796543, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog (AudioEffectsDialog.kt:65)");
                }
                State enabled$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getEqualizerEnabled(), null, (Composer)$composer, (int)0, (int)1);
                State bands$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getEqualizerBands(), null, (Composer)$composer, (int)0, (int)1);
                State preset$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getEqualizerPreset(), null, (Composer)$composer, (int)0, (int)1);
                State bassBoost$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getBassBoost(), null, (Composer)$composer, (int)0, (int)1);
                State playbackRate$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getPlaybackRate(), null, (Composer)$composer, (int)0, (int)1);
                AlertDialog_skikoKt.AlertDialog-Oix01E0(onDismiss, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-979578617, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$5(onDismiss, arg_0, arg_1), (Composer)$composer, (int)54)), null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-593716215, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$8(viewModel2, arg_0, arg_1), (Composer)$composer, (int)54)), null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-207853813, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$15(viewModel2, enabled$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-14922612, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46(enabled$delegate, viewModel2, preset$delegate, bands$delegate, bassBoost$delegate, playbackRate$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, (long)0L, (long)0L, (float)0.0f, null, (Composer)$composer, (int)(0x1B0C30 | 0xE & $dirty >> 3), (int)0, (int)16276);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block6;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$47(viewModel2, onDismiss, $changed, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean AudioEffectsDialog$lambda$0(State<Boolean> $enabled$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $enabled$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float[] AudioEffectsDialog$lambda$1(State<float[]> $bands$delegate) {
        void $this$getValue$iv;
        State<float[]> state = $bands$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (float[])$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final String AudioEffectsDialog$lambda$2(State<String> $preset$delegate) {
        void $this$getValue$iv;
        State<String> state = $preset$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float AudioEffectsDialog$lambda$3(State<Float> $bassBoost$delegate) {
        void $this$getValue$iv;
        State<Float> state = $bassBoost$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float AudioEffectsDialog$lambda$4(State<Float> $playbackRate$delegate) {
        void $this$getValue$iv;
        State<Float> state = $playbackRate$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$5(Function0 $onDismiss, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C387@19043L153:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-979578617, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous> (AudioEffectsDialog.kt:387)");
            }
            int $this$dp$iv = 10;
            boolean $i$f$getDp = false;
            ButtonKt.Button((Function0)$onDismiss, null, (boolean)false, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))), null, null, null, null, null, ComposableSingletons$AudioEffectsDialogKt.INSTANCE.getLambda$245515511$desktopApp(), (Composer)$composer, (int)0x30000000, (int)502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$8$lambda$7$lambda$6(PlayerViewModel $viewModel) {
        $viewModel.resetEqualizer();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$8(PlayerViewModel $viewModel, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C396@19288L30,395@19246L332:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-593716215, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous> (AudioEffectsDialog.kt:395)");
            }
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)669369575, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = $composer.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl2 = false;
                Function0 value$iv = () -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$8$lambda$7$lambda$6($viewModel);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function0 function0 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            int $this$dp$iv = 10;
            boolean $i$f$getDp = false;
            ButtonKt.OutlinedButton((Function0)function0, null, (boolean)false, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))), null, null, null, null, null, ComposableSingletons$AudioEffectsDialogKt.INSTANCE.getLambda$-1906925061$desktopApp(), (Composer)$composer, (int)0x30000000, (int)502);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11(PlayerViewModel $viewModel, boolean it) {
        $viewModel.setEqualizerEnabled(it);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$15(PlayerViewModel $viewModel, State $enabled$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C75@3109L2105:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            long l;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $composer$iv;
            void $composer22;
            void $changed$iv$iv$iv2;
            void modifier$iv$iv2;
            void $changed$iv;
            void $composer$iv2;
            void $composer3;
            int $changed$iv$iv$iv22;
            Function0 factory$iv$iv$iv;
            int $changed$iv$iv2;
            Modifier modifier$iv$iv22;
            Alignment.Vertical verticalAlignment$iv;
            void $composer$iv22;
            void $composer4;
            void $changed$iv$iv$iv3;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv;
            void $changed$iv2;
            void verticalAlignment$iv2;
            void horizontalArrangement$iv;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-207853813, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous> (AudioEffectsDialog.kt:75)");
            }
            Modifier modifier = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVertical = Arrangement.INSTANCE.getSpaceBetween();
            Modifier modifier2 = modifier;
            Arrangement.Horizontal horizontal = (Arrangement.Horizontal)horizontalOrVertical;
            Alignment.Vertical vertical2 = vertical;
            Composer composer = $composer;
            int n = 438;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var14_14 = modifier$iv;
            int n2 = 0x70 & $changed$iv2 << 3;
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
                void factory$iv$iv$iv2;
                $composer$iv3.createNode((Function0)factory$iv$iv$iv2);
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
            int n4 = 0xE & $changed$iv$iv$iv3 >> 6;
            void $composer$iv4 = $composer$iv3;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n5 = 6 | 0x70 & $changed$iv2 >> 6;
            void var33_33 = $composer$iv4;
            RowScope $this$AudioEffectsDialog_u24lambda_u2415_u24lambda_u2414 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)277934531, (String)"C80@3327L996,101@4340L860:AudioEffectsDialog.kt#buhtxq");
            Alignment.Vertical vertical3 = Alignment.Companion.getCenterVertically();
            void var37_37 = $composer4;
            int $changed$iv3 = 384;
            boolean $i$f$Row2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv2 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv22, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
            Modifier modifier3 = modifier$iv2;
            int n6 = 0x70 & $changed$iv3 << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv22, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv22.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv22, (Modifier)modifier$iv$iv22);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n7 = 6 | 0x380 & $changed$iv$iv2 << 6;
            boolean $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv22.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv22.startReusableNode();
            if ($composer$iv22.getInserting()) {
                $composer$iv22.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv22.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv22);
            boolean bl6 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl7 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            boolean bl8 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n8 = 0xE & $changed$iv$iv$iv22 >> 6;
            void $composer$iv5 = $composer$iv22;
            boolean bl9 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n9 = 6 | 0x70 & $changed$iv3 >> 6;
            void var62_62 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2415_u24lambda_u2414_u24lambda_u2410 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl62 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1757066488, (String)"C84@3566L11,81@3401L263,87@3685L29,88@3735L570:AudioEffectsDialog.kt#buhtxq");
            ImageVector imageVector = GraphicEqKt.getGraphicEq((Icons.Filled)Icons.INSTANCE.getDefault());
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv = 26;
            boolean $i$f$getDp = false;
            Modifier modifier4 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier4, (long)l2, (Composer)$composer3, (int)432, (int)0);
            int $this$dp$iv2 = 10;
            boolean $i$f$getDp2 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv2)), (Composer)$composer3, (int)6);
            modifier4 = $composer3;
            $this$dp$iv = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Object modifier$iv3 = (Modifier)Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            Modifier modifier5 = modifier$iv3;
            int bl72 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function03 = ComposeUiNode.Companion.getConstructor();
            int n10 = 6 | 0x380 & bl72 << 6;
            boolean $i$f$ReusableComposeNode3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                void factory$iv$iv$iv3;
                $composer$iv2.createNode((Function0)factory$iv$iv$iv3);
            } else {
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl((Composer)$composer$iv2);
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
            int n11 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv6 = $composer$iv2;
            boolean bl82 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n12 = 6 | 0x70 & $changed$iv >> 6;
            void var93_102 = $composer$iv6;
            ColumnScope $this$AudioEffectsDialog_u24lambda_u2415_u24lambda_u2414_u24lambda_u2410_u24lambda_u249 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl92 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer22, (int)1138294711, (String)"C91@3883L10,89@3768L220,96@4157L10,97@4229L11,94@4013L270:AudioEffectsDialog.kt#buhtxq");
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer22, MaterialTheme.$stable).getTitleLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            TextKt.Text--4IGK_g((String)"Equalizer & Audio FX", null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer22, (int)196614, (int)0, (int)65502);
            textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer22, MaterialTheme.$stable).getBodySmall();
            long l3 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer22, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            TextKt.Text--4IGK_g((String)"Hardware-accelerated 10-Band EQ & Acoustic Tuning", null, (long)l3, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer22, (int)6, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer22);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv22.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            $composer$iv22 = $composer4;
            int $changed$iv4 = 384;
            boolean $i$f$Row3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv4 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv3, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
            modifier$iv$iv22 = modifier$iv4;
            $changed$iv$iv2 = 0x70 & $changed$iv4 << 3;
            boolean $i$f$Layout4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv4 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv22 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                $composer$iv.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl((Composer)$composer$iv);
            bl6 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)measurePolicy$iv4, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)localMap$iv$iv4, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            bl7 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv4 = $this$Layout_u24lambda_u240$iv$iv4;
            bl8 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv4.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv4.rememberedValue(), (Object)compositeKeyHash$iv$iv4)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv4.updateRememberedValue((Object)compositeKeyHash$iv$iv4);
                $this$Layout_u24lambda_u240$iv$iv4.apply((Object)compositeKeyHash$iv$iv4, block$iv$iv$iv4);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv4, (Object)materialized$iv$iv4, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed$iv42 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv7 = $composer$iv;
            bl9 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int $changed2 = 6 | 0x70 & $changed$iv4 >> 6;
            $composer3 = $composer$iv7;
            RowScope $this$AudioEffectsDialog_u24lambda_u2415_u24lambda_u2414_u24lambda_u2413 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl10 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)266524409, (String)"C104@4527L10,102@4414L320,107@4755L28,110@4897L37,113@5115L11,111@4984L176,108@4804L378:AudioEffectsDialog.kt#buhtxq");
            modifier$iv3 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate) ? "ON" : "OFF";
            TextStyle textStyle2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getLabelMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            if (AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate)) {
                $composer2.startReplaceGroup(562793905);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"105@4645L11");
                var101_111 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer2.endReplaceGroup();
                l = var101_111;
            } else {
                $composer2.startReplaceGroup(562795162);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"105@4684L11");
                var101_111 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                $composer2.endReplaceGroup();
                l = var101_111;
            }
            long l4 = l;
            TextKt.Text--4IGK_g((String)modifier$iv3, null, (long)l4, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle2, (Composer)$composer2, (int)0, (int)0, (int)65530);
            int $this$dp$iv3 = 8;
            boolean $i$f$getDp2232 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3)), (Composer)$composer2, (int)6);
            boolean bl11 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)562801615, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
            void $i$f$getDp2232 = $composer2;
            boolean invalid$iv = $composer2.changedInstance((Object)$viewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl12 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl13 = bl11;
                boolean bl132 = false;
                Function1 function1 = arg_0 -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11($viewModel, arg_0);
                bl11 = bl13;
                Function1 value$iv = function1;
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function1 function1 = (Function1)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            SwitchKt.Switch((boolean)bl11, (Function1)function1, null, null, (boolean)false, (SwitchColors)SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, (Composer)$composer2, 6, SwitchDefaults.$stable << 18, 65532), null, (Composer)$composer2, (int)0, (int)92);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
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

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$20$lambda$19$lambda$17$lambda$16(PlayerViewModel $viewModel, String $p, State $enabled$delegate) {
        if (!AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate)) {
            $viewModel.setEqualizerEnabled(true);
        }
        $viewModel.setEqualizerPreset($p);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$20$lambda$19$lambda$18(boolean $isSel, String $p, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C161@7290L10,159@7188L664:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)706476987, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AudioEffectsDialog.kt:159)");
            }
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), (long)0L, (long)TextUnitKt.getSp((double)11.5), (FontWeight)($isSel ? FontWeight.Companion.getBold() : FontWeight.Companion.getMedium()), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFF9, null);
            if ($isSel) {
                $composer.startReplaceGroup(319565378);
                ComposerKt.sourceInformation((Composer)$composer, (String)"165@7572L11");
                var7_5 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = var7_5;
            } else {
                $composer.startReplaceGroup(319566628);
                ComposerKt.sourceInformation((Composer)$composer, (String)"165@7611L11");
                var7_5 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                $composer.endReplaceGroup();
                l = var7_5;
            }
            long l2 = l;
            Modifier.Companion companion = Modifier.Companion;
            int $this$dp$iv = 6;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            int $this$dp$iv2 = 4;
            boolean $i$f$getDp2 = false;
            float f2 = Dp.constructor-impl((float)$this$dp$iv2);
            Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)companion), (float)f2, (float)f);
            int n = TextAlign.Companion.getCenter-e0LSkKk();
            TextKt.Text--4IGK_g((String)$p, (Modifier)modifier, (long)l2, (long)0L, null, null, null, (long)0L, null, (TextAlign)TextAlign.box-impl((int)n), (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)0, (int)0, (int)65016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$25$lambda$24$lambda$22$lambda$21(PlayerViewModel $viewModel, String $p, State $enabled$delegate) {
        if (!AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate)) {
            $viewModel.setEqualizerEnabled(true);
        }
        $viewModel.setEqualizerPreset($p);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$25$lambda$24$lambda$23(boolean $isSel, String $p, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C196@9293L10,194@9191L664:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1837221518, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AudioEffectsDialog.kt:194)");
            }
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), (long)0L, (long)TextUnitKt.getSp((double)11.5), (FontWeight)($isSel ? FontWeight.Companion.getBold() : FontWeight.Companion.getMedium()), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFF9, null);
            if ($isSel) {
                $composer.startReplaceGroup(-338306503);
                ComposerKt.sourceInformation((Composer)$composer, (String)"200@9575L11");
                var7_5 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = var7_5;
            } else {
                $composer.startReplaceGroup(-338305253);
                ComposerKt.sourceInformation((Composer)$composer, (String)"200@9614L11");
                var7_5 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                $composer.endReplaceGroup();
                l = var7_5;
            }
            long l2 = l;
            Modifier.Companion companion = Modifier.Companion;
            int $this$dp$iv = 6;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            int $this$dp$iv2 = 4;
            boolean $i$f$getDp2 = false;
            float f2 = Dp.constructor-impl((float)$this$dp$iv2);
            Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)companion), (float)f2, (float)f);
            int n = TextAlign.Companion.getCenter-e0LSkKk();
            TextKt.Text--4IGK_g((String)$p, (Modifier)modifier, (long)l2, (long)0L, null, null, null, (long)0L, null, (TextAlign)TextAlign.box-impl((int)n), (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)0, (int)0, (int)65016);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$34$lambda$33$lambda$32$lambda$31$lambda$28$lambda$27(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter((Object)$this$graphicsLayer, (String)"$this$graphicsLayer");
        $this$graphicsLayer.setRotationZ(270.0f);
        $this$graphicsLayer.setTransformOrigin-__ExYCQ(TransformOrigin.Companion.getCenter-SzJe1aQ());
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$34$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29(PlayerViewModel $viewModel, int $index, State $enabled$delegate, float newVal) {
        if (!AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate)) {
            $viewModel.setEqualizerEnabled(true);
        }
        $viewModel.setBandLevel($index, newVal);
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$37$lambda$36(PlayerViewModel $viewModel, State $enabled$delegate, float it) {
        if (!AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate)) {
            $viewModel.setEqualizerEnabled(true);
        }
        $viewModel.setBassBoost(it);
        return Unit.INSTANCE;
    }

    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$44$lambda$43$lambda$41$lambda$40(PlayerViewModel $viewModel, float $speed) {
        $viewModel.setPlaybackRate($speed);
        return Unit.INSTANCE;
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AudioEffectsDialog$lambda$46$lambda$45$lambda$44$lambda$43$lambda$42(float $speed, boolean $isSpeedSel, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C373@18360L10,371@18248L665:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            long l;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1351841087, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AudioEffectsDialog.kt:371)");
            }
            String string2 = $speed + "x";
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), (long)0L, (long)TextUnitKt.getSp((double)11.5), (FontWeight)($isSpeedSel ? FontWeight.Companion.getBold() : FontWeight.Companion.getMedium()), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFF9, null);
            if ($isSpeedSel) {
                $composer.startReplaceGroup(-2039146936);
                ComposerKt.sourceInformation((Composer)$composer, (String)"377@18652L11");
                var8_6 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                $composer.endReplaceGroup();
                l = var8_6;
            } else {
                $composer.startReplaceGroup(-2039145686);
                ComposerKt.sourceInformation((Composer)$composer, (String)"377@18691L11");
                var8_6 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                $composer.endReplaceGroup();
                l = var8_6;
            }
            long l2 = l;
            int $this$dp$iv = 6;
            boolean $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv), (int)1, null);
            int n = TextAlign.Companion.getCenter-e0LSkKk();
            TextKt.Text--4IGK_g((String)string2, (Modifier)modifier, (long)l2, (long)0L, null, null, null, (long)0L, null, (TextAlign)TextAlign.box-impl((int)n), (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)48, (int)0, (int)65016);
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
    private static final Unit AudioEffectsDialog$lambda$46(State $enabled$delegate, PlayerViewModel $viewModel, State $preset$delegate, State $bands$delegate, State $bassBoost$delegate, State $playbackRate$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C120@5255L13738:AudioEffectsDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void verticalAlignment$iv;
            void $composer$iv;
            Object object;
            void $this$cache$iv;
            Function0 horizontalAlignment$iv;
            int n;
            int n2;
            Function0 $this$dp$iv62;
            Function0 value$iv;
            Function0 function0;
            Modifier modifier;
            int n3;
            Function0 function02;
            Role role;
            boolean bl;
            Object it$iv;
            void $this$cache$iv2;
            boolean $i$f$cache;
            int invalid$iv;
            void $i$f$getDp22;
            BorderStroke borderStroke;
            long l;
            boolean $this$dp$iv;
            long l2;
            long l3;
            Object object2;
            boolean $i$f$getDp;
            int $this$dp$iv2;
            boolean isSel;
            String p;
            Object element$iv2;
            SliderColors $composer3;
            int $changed$iv$iv$iv2;
            Function0 factory$iv$iv$iv;
            int $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv;
            int $changed$iv;
            void horizontalArrangement$iv;
            SliderColors $composer$iv2;
            void $composer4;
            void $changed$iv$iv$iv3;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv2;
            void $changed$iv2;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-14922612, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AudioEffectsDialog.<anonymous> (AudioEffectsDialog.kt:120)");
            }
            int $this$dp$iv222 = 4;
            boolean $i$f$getDp3 = false;
            Modifier $this$dp$iv222 = PaddingKt.padding-VpY3zN4$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv222), (int)1, null);
            Composer composer = $composer;
            int n4 = 6;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv2, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var15_17 = modifier$iv2;
            int n5 = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv3);
            Function0 function03 = ComposeUiNode.Companion.getConstructor();
            int n6 = 6 | 0x380 & $changed$iv$iv3 << 6;
            boolean $i$f$ReusableComposeNode = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                void factory$iv$iv$iv2;
                $composer$iv3.createNode((Function0)factory$iv$iv$iv2);
            } else {
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv3);
            boolean bl2 = false;
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
            int n7 = 0xE & $changed$iv$iv$iv3 >> 6;
            void $composer$iv4 = $composer$iv3;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n8 = 6 | 0x70 & $changed$iv2 >> 6;
            void var34_36 = $composer$iv4;
            ColumnScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-2110644285, (String)"C125@5453L11,125@5413L86,126@5516L30,131@5684L10,135@5878L11,129@5595L320,137@5932L29,138@5978L1940,172@7935L29,173@7981L1940,208@9939L30,213@10156L10,217@10350L11,211@10032L355,219@10404L29,221@10451L3455,282@13924L30,285@14009L888,304@14914L29,314@15377L11,315@15455L11,313@15318L256,307@15043L148,305@14960L688,321@15666L30,324@15748L1351,352@17116L29,353@17162L1817:AudioEffectsDialog.kt#buhtxq");
            DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), (float)0.3f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer4, (int)0, (int)3);
            int $this$dp$iv32 = 14;
            boolean $i$f$getDp4 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32)), (Composer)$composer4, (int)6);
            TextStyle $this$dp$iv32 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer4, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            long l4 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"EQ PRESETS", null, (long)l4, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv32, (Composer)$composer4, (int)6, (int)0, (int)65530);
            int $this$dp$iv42 = 8;
            $i$f$getDp4 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv42)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv42 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            int $this$dp$iv52 = 6;
            boolean $i$f$getDp5 = false;
            Arrangement.Horizontal $this$dp$iv52 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv52));
            void var42_80 = $composer4;
            int n9 = 54;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var46_88 = modifier$iv;
            int n10 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function04 = ComposeUiNode.Companion.getConstructor();
            int n11 = 6 | 0x380 & $changed$iv$iv2 << 6;
            boolean $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
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
            int n12 = 0xE & $changed$iv$iv$iv2 >> 6;
            SliderColors $composer$iv5 = $composer$iv2;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n13 = 6 | 0x70 & $changed$iv >> 6;
            void var65_113 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2420 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1052470649, (String)"C:AudioEffectsDialog.kt#buhtxq");
            $composer3.startReplaceGroup(-1973612820);
            ComposerKt.sourceInformation((Composer)$composer3, (String)"*154@6942L189,158@7158L720,144@6277L1601");
            Iterable $this$forEach$iv = CollectionsKt.take((Iterable)PRESETS, (int)4);
            boolean $i$f$forEach = false;
            for (Object element$iv2 : $this$forEach$iv) {
                Object object3;
                long l5;
                long l6;
                p = (String)element$iv2;
                boolean bl9 = false;
                isSel = StringsKt.equals((String)AudioEffectsDialogKt.AudioEffectsDialog$lambda$2((State<String>)$preset$delegate), (String)p, (boolean)true);
                $this$dp$iv2 = 12;
                $i$f$getDp = false;
                object2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv2));
                if (isSel) {
                    $composer3.startReplaceGroup(-1872289847);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"146@6410L11");
                    l3 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.22f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l6 = l3;
                } else {
                    $composer3.startReplaceGroup(-1872288663);
                    $composer3.endReplaceGroup();
                    l6 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                l2 = l6;
                $this$dp$iv = true;
                boolean $i$f$getDp6 = false;
                float f = Dp.constructor-impl((float)((float)$this$dp$iv));
                if (isSel) {
                    $composer3.startReplaceGroup(-1872282679);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"149@6634L11");
                    l = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.65f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l5 = l;
                } else {
                    $composer3.startReplaceGroup(-1872281495);
                    $composer3.endReplaceGroup();
                    l5 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)f, (long)l5);
                int $this$dp$iv62 = 12;
                boolean $i$f$getDp22 = false;
                Modifier modifier2 = ClipKt.clip((Modifier)RowScope.weight$default((RowScope)$this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2420, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv62))));
                int n14 = 0;
                Function0 function05 = null;
                Role role2 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1872273293, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
                $i$f$getDp22 = $composer3;
                invalid$iv = $composer3.changed((Object)$enabled$delegate) | $composer3.changedInstance((Object)$viewModel) | $composer3.changed((Object)p);
                $i$f$cache = false;
                it$iv = $this$cache$iv2.rememberedValue();
                bl = false;
                if (invalid$iv != 0 || it$iv == Composer.Companion.getEmpty()) {
                    role = role2;
                    function02 = function05;
                    n3 = n14;
                    modifier = modifier2;
                    boolean bl10 = false;
                    function0 = () -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$20$lambda$19$lambda$17$lambda$16($viewModel, p, $enabled$delegate);
                    modifier2 = modifier;
                    n14 = n3;
                    function05 = function02;
                    role2 = role;
                    value$iv = function0;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv;
                }
                $this$dp$iv62 = (Function0)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier2, n14 != 0, function05, role2, (Function0)$this$dp$iv62, (int)7, null), (Shape)((Shape)object2), (long)l2, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)706476987, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$20$lambda$19$lambda$18(isSel, p, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)0xC00000, (int)56);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            int $this$dp$iv72 = 6;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv72)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv72 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            int $this$dp$iv82 = 6;
            $i$f$getDp = false;
            Arrangement.Horizontal $this$dp$iv82 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv82));
            $composer$iv2 = $composer4;
            $changed$iv = 54;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            verticalAlignment$iv = Alignment.Companion.getTop();
            measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            modifier$iv$iv2 = modifier$iv;
            $changed$iv$iv2 = 0x70 & $changed$iv << 3;
            $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed$iv3 = 0xE & $changed$iv$iv$iv2 >> 6;
            $composer$iv5 = $composer$iv2;
            bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int $changed2 = 6 | 0x70 & $changed$iv >> 6;
            $composer3 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2425 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl11 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1901364176, (String)"C:AudioEffectsDialog.kt#buhtxq");
            $composer3.startReplaceGroup(-754070493);
            ComposerKt.sourceInformation((Composer)$composer3, (String)"*189@8945L189,193@9161L720,179@8280L1601");
            $this$forEach$iv = CollectionsKt.drop((Iterable)PRESETS, (int)4);
            $i$f$forEach = false;
            for (Object element$iv2 : $this$forEach$iv) {
                Object object4;
                long l7;
                long l8;
                p = (String)element$iv2;
                n2 = 0;
                isSel = StringsKt.equals((String)AudioEffectsDialogKt.AudioEffectsDialog$lambda$2((State<String>)$preset$delegate), (String)p, (boolean)true);
                $this$dp$iv2 = 12;
                $i$f$getDp = false;
                object2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv2));
                if (isSel) {
                    $composer3.startReplaceGroup(2122975488);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"181@8413L11");
                    l3 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.22f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l8 = l3;
                } else {
                    $composer3.startReplaceGroup(2122976672);
                    $composer3.endReplaceGroup();
                    l8 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                l2 = l8;
                $this$dp$iv = true;
                boolean $i$f$getDp7 = false;
                float f = Dp.constructor-impl((float)((float)$this$dp$iv));
                if (isSel) {
                    $composer3.startReplaceGroup(2122982656);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"184@8637L11");
                    l = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.65f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l7 = l;
                } else {
                    $composer3.startReplaceGroup(2122983840);
                    $composer3.endReplaceGroup();
                    l7 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)f, (long)l7);
                int $this$dp$iv93 = 12;
                boolean $i$f$getDp8 = false;
                Modifier modifier3 = ClipKt.clip((Modifier)RowScope.weight$default((RowScope)$this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2425, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv93))));
                int n15 = 0;
                Function0 function06 = null;
                Role role3 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)2122992042, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
                $i$f$getDp22 = $composer3;
                invalid$iv = $composer3.changed((Object)$enabled$delegate) | $composer3.changedInstance((Object)$viewModel) | $composer3.changed((Object)p);
                $i$f$cache = false;
                it$iv = $this$cache$iv2.rememberedValue();
                bl = false;
                if (invalid$iv != 0 || it$iv == Composer.Companion.getEmpty()) {
                    role = role3;
                    function02 = function06;
                    n3 = n15;
                    modifier = modifier3;
                    boolean bl12 = false;
                    function0 = () -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$25$lambda$24$lambda$22$lambda$21($viewModel, p, $enabled$delegate);
                    modifier3 = modifier;
                    n15 = n3;
                    function06 = function02;
                    role3 = role;
                    value$iv = function0;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object4 = value$iv;
                } else {
                    object4 = it$iv;
                }
                $this$dp$iv62 = (Function0)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier3, n15 != 0, function06, role3, (Function0)$this$dp$iv62, (int)7, null), (Shape)((Shape)object2), (long)l2, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-1837221518, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$25$lambda$24$lambda$23(isSel, p, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)0xC00000, (int)56);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            int $this$dp$iv92 = 18;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv92)), (Composer)$composer4, (int)6);
            TextStyle $this$dp$iv92 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer4, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            l4 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"10-BAND FREQUENCY SPECTRUM (-12 dB to +12 dB)", null, (long)l4, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv92, (Composer)$composer4, (int)6, (int)0, (int)65530);
            int $this$dp$iv10 = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv10)), (Composer)$composer4, (int)6);
            $this$dp$iv10 = 12;
            $i$f$getDp = false;
            Modifier modifier4 = BackgroundKt.background-bw27NRU((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (long)Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.025f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv10))));
            $this$dp$iv10 = 8;
            $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv10);
            $this$dp$iv10 = 12;
            $i$f$getDp = false;
            Modifier $this$dp$iv102 = PaddingKt.padding-VpY3zN4((Modifier)modifier4, (float)f, (float)Dp.constructor-impl((float)$this$dp$iv10));
            Arrangement.Horizontal $i$f$getDp32 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            $composer$iv2 = $composer4;
            $changed$iv = 432;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            modifier$iv$iv2 = modifier$iv;
            $changed$iv$iv2 = 0x70 & $changed$iv << 3;
            $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv3 = 0xE & $changed$iv$iv$iv2 >> 6;
            $composer$iv5 = $composer$iv2;
            bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $changed2 = 6 | 0x70 & $changed$iv >> 6;
            $composer3 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2434 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl13 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)736533830, (String)"C:AudioEffectsDialog.kt#buhtxq");
            $composer3.startReplaceGroup(1409233004);
            ComposerKt.sourceInformation((Composer)$composer3, (String)"*231@11027L2839");
            Object $this$forEachIndexed$iv = BAND_FREQUENCIES;
            boolean $i$f$forEachIndexed22 = false;
            int index$iv = 0;
            element$iv2 = $this$forEachIndexed$iv.iterator();
            while (element$iv2.hasNext()) {
                void freq;
                Object object5;
                void $this$cache$iv3;
                Object object6;
                void $this$cache$iv4;
                void $composer5;
                void $changed$iv$iv$iv4;
                void $changed$iv$iv4;
                void modifier$iv$iv4;
                void $changed$iv4;
                void modifier$iv3;
                void contentAlignment$iv;
                void $composer$iv6;
                long l9;
                void $composer6;
                void $changed$iv$iv$iv5;
                void $changed$iv$iv5;
                void modifier$iv$iv5;
                void modifier$iv4;
                void $changed$iv5;
                void $composer$iv7;
                Object object7;
                Object item$iv = element$iv2.next();
                if ((n2 = index$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String isSel2 = (String)item$iv;
                int index = n2;
                n = 0;
                object2 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$1((State<float[]>)$bands$delegate);
                boolean bl14 = 0 <= index ? index < ((RoundedCornerShape)object2).length : false;
                if (bl14) {
                    object7 = object2[index];
                } else {
                    int it = index;
                    boolean bl15 = false;
                    object7 = 0.0f;
                }
                RoundedCornerShape currentLevel = object7;
                object2 = Alignment.Companion.getCenterHorizontally();
                Modifier bl15 = RowScope.weight$default((RowScope)$this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2434, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
                Object object8 = object2;
                void $this$dp$iv11 = $composer3;
                int $this$dp$iv93 = 384;
                boolean $i$f$Column2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv2, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv7, (int)(0xE & $changed$iv5 >> 3 | 0x70 & $changed$iv5 >> 3));
                $this$cache$iv2 = modifier$iv4;
                invalid$iv = 0x70 & $changed$iv5 << 3;
                boolean $i$f$Layout3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv7, (int)0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv7.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv7, (Modifier)modifier$iv$iv5);
                function02 = ComposeUiNode.Companion.getConstructor();
                n3 = 6 | 0x380 & $changed$iv$iv5 << 6;
                boolean $i$f$ReusableComposeNode3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer$iv7.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv7.startReusableNode();
                if ($composer$iv7.getInserting()) {
                    void factory$iv$iv$iv3;
                    $composer$iv7.createNode((Function0)factory$iv$iv$iv3);
                } else {
                    $composer$iv7.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl((Composer)$composer$iv7);
                $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv2 = false;
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
                int n16 = 0xE & $changed$iv$iv$iv5 >> 6;
                void $composer$iv8 = $composer$iv7;
                $i$a$-Layout-ColumnKt$Column$1$iv = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv8, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n17 = 6 | 0x70 & $changed$iv5 >> 6;
                void var112_215 = $composer$iv8;
                ColumnScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl16 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer6, (int)1458419287, (String)"C237@11394L10,235@11230L403,240@11662L29,241@11720L1629,269@13378L29,272@13541L10,276@13782L11,270@13436L404:AudioEffectsDialog.kt#buhtxq");
                String string2 = (currentLevel > 0.0f ? "+" : "") + (int)currentLevel + "dB";
                TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer6, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)TextUnitKt.getSp((int)9), null, null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFD, null);
                if (!(currentLevel == 0.0f)) {
                    $composer6.startReplaceGroup(739789409);
                    ComposerKt.sourceInformation((Composer)$composer6, (String)"238@11517L11");
                    var117_226 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer6, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    $composer6.endReplaceGroup();
                    l9 = var117_226;
                } else {
                    $composer6.startReplaceGroup(739791212);
                    ComposerKt.sourceInformation((Composer)$composer6, (String)"238@11556L11");
                    var117_226 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (float)0.6f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer6.endReplaceGroup();
                    l9 = var117_226;
                }
                long l10 = l9;
                TextKt.Text--4IGK_g((String)string2, null, (long)l10, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer6, (int)0, (int)0, (int)65530);
                int $this$dp$iv12 = 4;
                boolean $i$f$getDp9 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv12)), (Composer)$composer6, (int)6);
                $this$dp$iv12 = 16;
                $i$f$getDp9 = false;
                Modifier modifier5 = SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv12));
                $this$dp$iv12 = 110;
                $i$f$getDp9 = false;
                Modifier $this$dp$iv112 = SizeKt.height-3ABfNKs((Modifier)modifier5, (float)Dp.constructor-impl((float)$this$dp$iv12));
                Alignment $i$f$getDp42 = Alignment.Companion.getCenter();
                void var121_228 = $composer6;
                int n18 = 54;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                void var126_233 = modifier$iv3;
                int n19 = 0x70 & $changed$iv4 << 3;
                boolean $i$f$Layout4 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv6, (int)0);
                CompositionLocalMap localMap$iv$iv4 = $composer$iv6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier((Composer)$composer$iv6, (Modifier)modifier$iv$iv4);
                Function0 function07 = ComposeUiNode.Companion.getConstructor();
                int n20 = 6 | 0x380 & $changed$iv$iv4 << 6;
                boolean $i$f$ReusableComposeNode4 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer$iv6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv6.startReusableNode();
                if ($composer$iv6.getInserting()) {
                    void factory$iv$iv$iv4;
                    $composer$iv6.createNode((Function0)factory$iv$iv$iv4);
                } else {
                    $composer$iv6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl((Composer)$composer$iv6);
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
                int n21 = 0xE & $changed$iv$iv$iv4 >> 6;
                void $composer$iv9 = $composer$iv6;
                boolean bl17 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv9, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n22 = 6 | 0x70 & $changed$iv4 >> 6;
                void var145_252 = $composer$iv9;
                BoxScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432_u24lambda_u2431 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl18 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)1911669576, (String)"C256@12575L218,263@13040L11,264@13134L11,262@12965L320,249@12130L217,247@12012L1307:AudioEffectsDialog.kt#buhtxq");
                ClosedFloatingPointRange closedFloatingPointRange = RangesKt.rangeTo((float)-12.0f, (float)12.0f);
                boolean bl19 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate);
                Modifier modifier6 = (Modifier)Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-1462336966, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
                Function1 function1 = $composer5;
                boolean invalid$iv22 = false;
                boolean $i$f$cache2 = false;
                Object it$iv2 = $this$cache$iv4.rememberedValue();
                boolean bl20 = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Modifier modifier7 = modifier6;
                    boolean bl21 = false;
                    modifier6 = modifier7;
                    Function1 value$iv2 = AudioEffectsDialogKt::AudioEffectsDialog$lambda$46$lambda$45$lambda$34$lambda$33$lambda$32$lambda$31$lambda$28$lambda$27;
                    $this$cache$iv4.updateRememberedValue((Object)value$iv2);
                    object6 = value$iv2;
                } else {
                    object6 = it$iv2;
                }
                Function1 function12 = (Function1)object6;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
                int $this$dp$iv13 = 110;
                boolean $i$f$getDp10 = false;
                Modifier modifier8 = SizeKt.width-3ABfNKs((Modifier)GraphicsLayerModifierKt.graphicsLayer((Modifier)modifier6, (Function1)function12), (float)Dp.constructor-impl((float)$this$dp$iv13));
                $this$dp$iv13 = 16;
                $i$f$getDp10 = false;
                Modifier modifier9 = SizeKt.height-3ABfNKs((Modifier)modifier8, (float)Dp.constructor-impl((float)$this$dp$iv13));
                function12 = SliderDefaults.INSTANCE.colors-q0g_0yA(MaterialTheme.INSTANCE.getColorScheme((Composer)$composer5, MaterialTheme.$stable).getPrimary-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme((Composer)$composer5, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.12f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), 0L, 0L, 0L, 0L, 0L, 0L, (Composer)$composer5, 3072, 6, 1012);
                RoundedCornerShape roundedCornerShape = currentLevel;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-1462351207, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
                void invalid$iv22 = $composer5;
                boolean invalid$iv3 = $composer5.changed((Object)$enabled$delegate) | $composer5.changedInstance((Object)$viewModel) | $composer5.changed(index);
                boolean $i$f$cache3 = false;
                Object it$iv3 = $this$cache$iv3.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    RoundedCornerShape roundedCornerShape2 = roundedCornerShape;
                    boolean bl22 = false;
                    Function1 function13 = arg_0 -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$34$lambda$33$lambda$32$lambda$31$lambda$30$lambda$29($viewModel, index, $enabled$delegate, arg_0);
                    roundedCornerShape = roundedCornerShape2;
                    Function1 value$iv3 = function13;
                    $this$cache$iv3.updateRememberedValue((Object)value$iv3);
                    object5 = value$iv3;
                } else {
                    object5 = it$iv3;
                }
                function1 = (Function1)object5;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
                SliderKt.Slider((float)roundedCornerShape, (Function1)function1, (Modifier)modifier9, (boolean)bl19, (ClosedFloatingPointRange)closedFloatingPointRange, (int)0, null, (SliderColors)function12, null, (Composer)$composer5, (int)384, (int)352);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv9);
                $composer$iv6.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                $this$dp$iv = 4;
                $i$f$getDp = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer6, (int)6);
                string2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer6, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)TextUnitKt.getSp((double)9.5), (FontWeight)FontWeight.Companion.getSemiBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFF9, null);
                long l11 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer6, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)freq, null, (long)l11, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)string2, (Composer)$composer6, (int)0, (int)0, (int)65530);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer6);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv8);
                $composer$iv7.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $this$dp$iv12 = 16;
            $i$f$getDp52 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv12)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv12 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Arrangement.Horizontal $i$f$getDp52 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            $composer$iv2 = $composer4;
            $changed$iv = 438;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            modifier$iv$iv2 = modifier$iv;
            $changed$iv$iv2 = 0x70 & $changed$iv << 3;
            $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv3 = 0xE & $changed$iv$iv$iv2 >> 6;
            $composer$iv5 = $composer$iv2;
            bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $changed2 = 6 | 0x70 & $changed$iv >> 6;
            $composer3 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2435 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl23 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-920648052, (String)"C292@14344L10,296@14554L11,290@14247L348,300@14731L10,301@14836L11,298@14616L263:AudioEffectsDialog.kt#buhtxq");
            $this$forEachIndexed$iv = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            long l12 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"BASS BOOST", null, (long)l12, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$forEachIndexed$iv, (Composer)$composer3, (int)6, (int)0, (int)65530);
            $this$forEachIndexed$iv = (int)(AudioEffectsDialogKt.AudioEffectsDialog$lambda$3((State<Float>)$bassBoost$delegate) * (float)10) + "%";
            element$iv2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            long l13 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            TextKt.Text--4IGK_g((String)$this$forEachIndexed$iv, null, (long)l13, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)element$iv2, (Composer)$composer3, (int)0, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $this$dp$iv13 = 4;
            $i$f$getDp6 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv13)), (Composer)$composer4, (int)6);
            float $this$dp$iv13 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$3((State<Float>)$bassBoost$delegate);
            ClosedFloatingPointRange $i$f$getDp6 = RangesKt.rangeTo((float)0.0f, (float)10.0f);
            boolean verticalAlignment$iv32 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$0((State<Boolean>)$enabled$delegate);
            $composer$iv2 = SliderDefaults.INSTANCE.colors-q0g_0yA(MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getPrimary-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.12f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), 0L, 0L, 0L, 0L, 0L, 0L, (Composer)$composer4, 3072, 6, 1012);
            Modifier $changed$iv322 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            float f2 = $this$dp$iv13;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-483432554, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
            measurePolicy$iv2 = $composer4;
            boolean invalid$iv32 = $composer4.changed((Object)$enabled$delegate) | $composer4.changedInstance((Object)$viewModel);
            int $i$f$cache4 = 0;
            Object it$iv4 = $this$cache$iv.rememberedValue();
            boolean bl24 = false;
            if (invalid$iv32 || it$iv4 == Composer.Companion.getEmpty()) {
                float f3 = f2;
                boolean bl25 = false;
                Function1 function1 = arg_0 -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$37$lambda$36($viewModel, $enabled$delegate, arg_0);
                f2 = f3;
                Function1 value$iv4 = function1;
                $this$cache$iv.updateRememberedValue((Object)value$iv4);
                object = value$iv4;
            } else {
                object = it$iv4;
            }
            Function1 $i$f$Row2 = (Function1)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
            SliderKt.Slider((float)f2, (Function1)$i$f$Row2, (Modifier)$changed$iv322, (boolean)verticalAlignment$iv32, (ClosedFloatingPointRange)$i$f$getDp6, (int)0, null, (SliderColors)$composer$iv2, null, (Composer)$composer4, (int)384, (int)352);
            $this$dp$iv14 = 14;
            $i$f$getDp7 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv14)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv14 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Arrangement.Horizontal $i$f$getDp7 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getCenterVertically();
            $composer$iv2 = $composer4;
            int $changed$iv322 = 438;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv32, (Composer)$composer$iv2, (int)(0xE & $changed$iv322 >> 3 | 0x70 & $changed$iv322 >> 3));
            void invalid$iv32 = modifier$iv;
            $i$f$cache4 = 0x70 & $changed$iv322 << 3;
            $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv3 = 0xE & $changed$iv$iv$iv2 >> 6;
            $composer$iv5 = $composer$iv2;
            bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $changed2 = 6 | 0x70 & $changed$iv322 >> 6;
            $composer3 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2439 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl26 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1717225340, (String)"C329@15986L823,348@16933L10,349@17038L11,346@16830L251:AudioEffectsDialog.kt#buhtxq");
            $this$forEachIndexed$iv = Alignment.Companion.getCenterVertically();
            SliderColors $i$f$forEachIndexed22 = $composer3;
            int $changed$iv6 = 384;
            boolean $i$f$Row3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Object modifier$iv5 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv6 >> 3 | 0x70 & $changed$iv6 >> 3));
            Modifier index = modifier$iv5;
            n = 0x70 & $changed$iv6 << 3;
            boolean $i$f$Layout5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv5 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            horizontalAlignment$iv = ComposeUiNode.Companion.getConstructor();
            int $composer$iv7 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv5;
                $composer$iv.createNode((Function0)factory$iv$iv$iv5);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl((Composer)$composer$iv);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)measurePolicy$iv5, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)localMap$iv$iv5, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv5 = $this$Layout_u24lambda_u240$iv$iv5;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv5.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv5.rememberedValue(), (Object)compositeKeyHash$iv$iv5)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv5.updateRememberedValue((Object)compositeKeyHash$iv$iv5);
                $this$Layout_u24lambda_u240$iv$iv5.apply((Object)compositeKeyHash$iv$iv5, block$iv$iv$iv5);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)materialized$iv$iv5, (Function2)ComposeUiNode.Companion.getSetModifier());
            int compositeKeyHash$iv$iv3 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv10 = $composer$iv;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv10, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int factory$iv$iv$iv3 = 6 | 0x70 & $changed$iv6 >> 6;
            void $changed$iv$iv$iv5 = $composer$iv10;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2439_u24lambda_u2438 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl27 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-823952372, (String)"C333@16223L11,330@16064L265,336@16354L28,339@16516L10,343@16742L11,337@16407L380:AudioEffectsDialog.kt#buhtxq");
            ImageVector $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv2 = SpeedKt.getSpeed((Icons.Filled)Icons.INSTANCE.getDefault());
            long l14 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv15 = 16;
            boolean $i$f$getDp11 = false;
            Modifier modifier10 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv15));
            IconKt.Icon-ww6aTOc((ImageVector)$i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv2, null, (Modifier)modifier10, (long)l14, (Composer)$composer2, (int)432, (int)0);
            int $this$dp$iv16 = 6;
            boolean $i$f$getDp12 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv16)), (Composer)$composer2, (int)6);
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getLabelSmall(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)TextUnitKt.getSp((double)0.8), null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFF7B, null);
            l14 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
            TextKt.Text--4IGK_g((String)"PLAYBACK SPEED", null, (long)l14, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)6, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv10);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            modifier$iv5 = AudioEffectsDialogKt.AudioEffectsDialog$lambda$4((State<Float>)$playbackRate$delegate) + "x";
            horizontalArrangement$iv2 = TextStyle.copy-p1EtxEg$default((TextStyle)MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getLabelMedium(), (long)0L, (long)0L, (FontWeight)FontWeight.Companion.getBold(), null, null, null, null, (long)0L, null, null, null, (long)0L, null, null, null, (int)0, (int)0, (long)0L, null, null, null, (int)0, (int)0, null, (int)0xFFFFFB, null);
            long l15 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurface-0d7_KjU();
            TextKt.Text--4IGK_g((String)modifier$iv5, null, (long)l15, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)horizontalArrangement$iv2, (Composer)$composer3, (int)0, (int)0, (int)65530);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $this$dp$iv152 = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv152)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv152 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            int $this$dp$iv1622 = 6;
            $i$f$getDp = false;
            Arrangement.Horizontal $this$dp$iv1622 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv1622));
            $composer$iv2 = $composer4;
            $changed$iv322 = 54;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            verticalAlignment$iv = Alignment.Companion.getTop();
            measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv322 >> 3 | 0x70 & $changed$iv322 >> 3));
            modifier$iv$iv = modifier$iv;
            $changed$iv$iv2 = 0x70 & $changed$iv322 << 3;
            $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            localMap$iv$iv = $composer$iv2.getCurrentCompositionLocalMap();
            materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv2 = 6 | 0x380 & $changed$iv$iv2 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                $composer$iv2.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv2);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv3 = 0xE & $changed$iv$iv$iv2 >> 6;
            $composer$iv5 = $composer$iv2;
            bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $changed2 = 6 | 0x70 & $changed$iv322 >> 6;
            $composer3 = $composer$iv5;
            RowScope $this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2444 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl28 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)60133575, (String)"C:AudioEffectsDialog.kt#buhtxq");
            $composer3.startReplaceGroup(-690796372);
            ComposerKt.sourceInformation((Composer)$composer3, (String)"*369@18155L36,370@18218L721,359@17480L1459");
            $this$forEach$iv = PLAYBACK_SPEEDS;
            $i$f$forEach = false;
            for (Object element$iv3 : $this$forEach$iv) {
                Object object9;
                void $this$cache$iv5;
                long l16;
                long l17;
                float speed = ((Number)element$iv3).floatValue();
                boolean bl29 = false;
                boolean isSpeedSel = Math.abs(AudioEffectsDialogKt.AudioEffectsDialog$lambda$4((State<Float>)$playbackRate$delegate) - speed) < 0.05f;
                int $this$dp$iv17 = 10;
                $i$f$getDp = false;
                RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv17));
                if (isSpeedSel) {
                    $composer3.startReplaceGroup(-1267019207);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"361@17618L11");
                    l3 = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.22f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l17 = l3;
                } else {
                    $composer3.startReplaceGroup(-1267018023);
                    $composer3.endReplaceGroup();
                    l17 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.04f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                l2 = l17;
                boolean $this$dp$iv18 = true;
                boolean $i$f$getDp13 = false;
                float f4 = Dp.constructor-impl((float)((float)$this$dp$iv18));
                if (isSpeedSel) {
                    $composer3.startReplaceGroup(-1267011879);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"364@17847L11");
                    l = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU(), (float)0.65f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer3.endReplaceGroup();
                    l16 = l;
                } else {
                    $composer3.startReplaceGroup(-1267010695);
                    $composer3.endReplaceGroup();
                    l16 = Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.08f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                }
                borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U((float)f4, (long)l16);
                int $this$dp$iv19 = 10;
                boolean $i$f$getDp82 = false;
                Modifier modifier11 = ClipKt.clip((Modifier)RowScope.weight$default((RowScope)$this$AudioEffectsDialog_u24lambda_u2446_u24lambda_u2445_u24lambda_u2444, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv19))));
                boolean bl30 = false;
                String string3 = null;
                Role role4 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1267002646, (String)"CC(remember):AudioEffectsDialog.kt#9igjgp");
                SliderColors $i$f$getDp82 = $composer3;
                boolean invalid$iv4 = $composer3.changedInstance((Object)$viewModel) | $composer3.changed(speed);
                $i$f$cache = false;
                Object it$iv5 = $this$cache$iv5.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
                    Role role5 = role4;
                    String string4 = string3;
                    boolean bl31 = bl30;
                    Modifier modifier12 = modifier11;
                    boolean bl32 = false;
                    textStyle = () -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$44$lambda$43$lambda$41$lambda$40($viewModel, speed);
                    modifier11 = modifier12;
                    bl30 = bl31;
                    string3 = string4;
                    role4 = role5;
                    value$iv = textStyle;
                    $this$cache$iv5.updateRememberedValue((Object)value$iv);
                    object9 = value$iv;
                } else {
                    object9 = it$iv5;
                }
                Function0 function08 = (Function0)object9;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                SurfaceKt.Surface-T9BRK9s((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier11, (boolean)bl30, string3, role4, (Function0)function08, (int)7, null), (Shape)((Shape)roundedCornerShape), (long)l2, (long)0L, (float)0.0f, (float)0.0f, (BorderStroke)borderStroke, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-1351841087, (boolean)true, (arg_0, arg_1) -> AudioEffectsDialogKt.AudioEffectsDialog$lambda$46$lambda$45$lambda$44$lambda$43$lambda$42(speed, isSpeedSel, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)0xC00000, (int)56);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
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

    private static final Unit AudioEffectsDialog$lambda$47(PlayerViewModel $viewModel, Function0 $onDismiss, int $$changed, Composer $composer, int $force) {
        AudioEffectsDialogKt.AudioEffectsDialog($viewModel, (Function0<Unit>)$onDismiss, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    static {
        Object[] objectArray = new String[]{"31Hz", "62Hz", "125Hz", "250Hz", "500Hz", "1kHz", "2kHz", "4kHz", "8kHz", "16kHz"};
        BAND_FREQUENCIES = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new String[]{"Flat", "Bass Boost", "Rock", "Pop", "Classical", "Jazz", "Electronic", "Vocal Boost"};
        PRESETS = CollectionsKt.listOf((Object[])objectArray);
        objectArray = new Float[]{Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(2.0f)};
        PLAYBACK_SPEEDS = CollectionsKt.listOf((Object[])objectArray);
    }
}

