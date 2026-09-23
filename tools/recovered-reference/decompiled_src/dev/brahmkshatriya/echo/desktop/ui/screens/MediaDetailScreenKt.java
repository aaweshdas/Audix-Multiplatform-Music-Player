/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.HoverableKt
 *  androidx.compose.foundation.OverscrollEffect
 *  androidx.compose.foundation.gestures.FlingBehavior
 *  androidx.compose.foundation.interaction.HoverInteractionKt
 *  androidx.compose.foundation.interaction.InteractionSource
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
 *  androidx.compose.foundation.layout.PaddingValues
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.lazy.LazyDslKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.foundation.lazy.LazyListScope
 *  androidx.compose.foundation.lazy.LazyListState
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.MusicNoteKt
 *  androidx.compose.material.icons.filled.PlayArrowKt
 *  androidx.compose.material3.ButtonColors
 *  androidx.compose.material3.ButtonDefaults
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.IconButtonKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.SurfaceKt
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.EffectsKt
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
 *  androidx.compose.ui.graphics.Color
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
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.flow.StateFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.koin.compose.KoinApplicationKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 */
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MusicNoteKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.common.models.Radio;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRowKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.ComposableSingletons$MediaDetailScreenKt;
import dev.brahmkshatriya.echo.desktop.ui.screens.SearchAndOthersKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.MediaDetailState;
import dev.brahmkshatriya.echo.desktop.viewmodel.MediaViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\u0010\f\u001aO\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0007H\u0003\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a\u00b2\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002\u00b2\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0014\u001a\u00020\u0013X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001e\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2={"MediaDetailScreen", "", "media", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "onBack", "Lkotlin/Function0;", "onMediaSelected", "Lkotlin/Function1;", "viewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/MediaViewModel;", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ldev/brahmkshatriya/echo/desktop/viewmodel/MediaViewModel;Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Landroidx/compose/runtime/Composer;II)V", "TrackListItem", "index", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "isCurrent", "", "isPlaying", "onClick", "formatDuration", "", "", "(ILdev/brahmkshatriya/echo/common/models/Track;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "desktopApp", "state", "Ldev/brahmkshatriya/echo/desktop/viewmodel/MediaDetailState;", "activeTrack", "isHovered"})
@SourceDebugExtension(value={"SMAP\nMediaDetailScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaDetailScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/MediaDetailScreenKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Inject.kt\norg/koin/compose/InjectKt\n+ 4 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 5 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 6 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 7 Composer.kt\nandroidx/compose/runtime/Updater\n+ 8 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 9 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 10 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 11 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 12 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,411:1\n1247#2,6:412\n1247#2,3:422\n1250#2,3:426\n1247#2,3:433\n1250#2,3:437\n1247#2,6:440\n1247#2,6:446\n1247#2,6:533\n1247#2,6:543\n1247#2,6:672\n1247#2,6:854\n1247#2,6:860\n1247#2,6:878\n88#3,4:418\n92#3:425\n88#3,4:429\n92#3:436\n87#4:452\n84#4,9:453\n94#4:542\n87#4:635\n84#4,9:636\n94#4:681\n87#4:773\n84#4,9:774\n94#4:873\n79#5,6:462\n86#5,3:477\n89#5,2:486\n79#5,6:500\n86#5,3:515\n89#5,2:524\n93#5:530\n93#5:541\n79#5,6:562\n86#5,3:577\n89#5,2:586\n79#5,6:599\n86#5,3:614\n89#5,2:623\n93#5:630\n79#5,6:645\n86#5,3:660\n89#5,2:669\n93#5:680\n93#5:685\n79#5,6:702\n86#5,3:717\n89#5,2:726\n79#5,6:740\n86#5,3:755\n89#5,2:764\n93#5:770\n79#5,6:783\n86#5,3:798\n89#5,2:807\n79#5,6:827\n86#5,3:842\n89#5,2:851\n93#5:868\n93#5:872\n93#5:876\n347#6,9:468\n356#6:488\n347#6,9:506\n356#6:526\n357#6,2:528\n357#6,2:539\n347#6,9:568\n356#6:588\n347#6,9:605\n356#6:625\n357#6,2:628\n347#6,9:651\n356#6:671\n357#6,2:678\n357#6,2:683\n347#6,9:708\n356#6:728\n347#6,9:746\n356#6:766\n357#6,2:768\n347#6,9:789\n356#6:809\n347#6,9:833\n356#6:853\n357#6,2:866\n357#6,2:870\n357#6,2:874\n4206#7,6:480\n4206#7,6:518\n4206#7,6:580\n4206#7,6:617\n4206#7,6:663\n4206#7,6:720\n4206#7,6:758\n4206#7,6:801\n4206#7,6:845\n113#8:489\n113#8:527\n113#8:532\n113#8:549\n113#8:550\n113#8:551\n113#8:589\n113#8:626\n113#8:627\n113#8:632\n113#8:633\n113#8:634\n113#8:682\n113#8:690\n113#8:691\n113#8:729\n113#8:730\n113#8:767\n113#8:772\n113#8:810\n113#8:811\n113#8:812\n113#8:813\n113#8:814\n113#8:815\n99#9:490\n96#9,9:491\n106#9:531\n99#9:552\n96#9,9:553\n106#9:686\n99#9:692\n96#9,9:693\n99#9:816\n95#9,10:817\n106#9:869\n106#9:877\n70#10:590\n68#10,8:591\n77#10:631\n70#10:731\n68#10,8:732\n77#10:771\n85#11:687\n85#11:688\n85#11:689\n85#11:910\n204#12,13:884\n204#12,13:897\n*S KotlinDebug\n*F\n+ 1 MediaDetailScreen.kt\ndev/brahmkshatriya/echo/desktop/ui/screens/MediaDetailScreenKt\n*L\n68#1:412,6\n69#1:422,3\n69#1:426,3\n70#1:433,3\n70#1:437,3\n72#1:440,6\n81#1:446,6\n122#1:533,6\n307#1:543,6\n387#1:672,6\n206#1:854,6\n220#1:860,6\n252#1:878,6\n69#1:418,4\n69#1:425\n70#1:429,4\n70#1:436\n98#1:452\n98#1:453,9\n98#1:542\n377#1:635\n377#1:636,9\n377#1:681\n159#1:773\n159#1:774,9\n159#1:873\n98#1:462,6\n98#1:477,3\n98#1:486,2\n100#1:500,6\n100#1:515,3\n100#1:524,2\n100#1:530\n98#1:541\n316#1:562,6\n316#1:577,3\n316#1:586,2\n334#1:599,6\n334#1:614,3\n334#1:623,2\n334#1:630\n377#1:645,6\n377#1:660,3\n377#1:669,2\n377#1:680\n316#1:685\n125#1:702,6\n125#1:717,3\n125#1:726,2\n132#1:740,6\n132#1:755,3\n132#1:764,2\n132#1:770\n159#1:783,6\n159#1:798,3\n159#1:807,2\n204#1:827,6\n204#1:842,3\n204#1:851,2\n204#1:868\n159#1:872\n125#1:876\n98#1:468,9\n98#1:488\n100#1:506,9\n100#1:526\n100#1:528,2\n98#1:539,2\n316#1:568,9\n316#1:588\n334#1:605,9\n334#1:625\n334#1:628,2\n377#1:651,9\n377#1:671\n377#1:678,2\n316#1:683,2\n125#1:708,9\n125#1:728\n132#1:746,9\n132#1:766\n132#1:768,2\n159#1:789,9\n159#1:809\n204#1:833,9\n204#1:853\n204#1:866,2\n159#1:870,2\n125#1:874,2\n98#1:480,6\n100#1:518,6\n316#1:580,6\n334#1:617,6\n377#1:663,6\n125#1:720,6\n132#1:758,6\n159#1:801,6\n204#1:845,6\n101#1:489\n107#1:527\n121#1:532\n319#1:549\n320#1:550\n330#1:551\n335#1:589\n343#1:626\n350#1:627\n368#1:632\n369#1:633\n373#1:634\n406#1:682\n166#1:690\n128#1:691\n134#1:729\n135#1:730\n150#1:767\n156#1:772\n161#1:810\n173#1:811\n184#1:812\n193#1:813\n201#1:814\n204#1:815\n100#1:490\n100#1:491,9\n100#1:531\n316#1:552\n316#1:553,9\n316#1:686\n125#1:692\n125#1:693,9\n204#1:816\n204#1:817,10\n204#1:869\n125#1:877\n334#1:590\n334#1:591,8\n334#1:631\n132#1:731\n132#1:732,8\n132#1:771\n76#1:687\n77#1:688\n78#1:689\n308#1:910\n268#1:884,13\n285#1:897,13\n*E\n"})
public final class MediaDetailScreenKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void MediaDetailScreen(@NotNull EchoMediaItem media, @NotNull Function0<Unit> onBack, @Nullable Function1<? super EchoMediaItem, Unit> onMediaSelected, @Nullable MediaViewModel viewModel2, @Nullable PlayerViewModel playerViewModel, @Nullable Composer $composer, int $changed, int n) {
        block39: {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            Intrinsics.checkNotNullParameter(onBack, (String)"onBack");
            $composer = $composer.startRestartGroup(1574488759);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(MediaDetailScreen)P(!3,4)71@3293L37,71@3268L62,75@3367L16,76@3436L16,77@3500L16,80@3581L244,97@4056L8506:MediaDetailScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)media) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onBack) ? 32 : 16;
            }
            if ((n & 4) != 0) {
                $dirty |= 0x180;
            } else if (($changed & 0x180) == 0) {
                $dirty |= $composer.changedInstance(onMediaSelected) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= (n & 8) == 0 && $composer.changedInstance((Object)viewModel2) ? 2048 : 1024;
            }
            if (($changed & 0x6000) == 0) {
                $dirty |= (n & 0x10) == 0 && $composer.changedInstance((Object)playerViewModel) ? 16384 : 8192;
            }
            if ($composer.shouldExecute(($dirty & 0x2493) != 9362, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void modifier$iv;
                void $changed$iv;
                void verticalAlignment$iv;
                void $composer$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $composer$iv2;
                Object object2;
                ImageHolder c;
                void $this$cache$iv2;
                Object object3;
                Scope scope$iv;
                Function2 qualifier$iv;
                boolean bl5;
                Object it$iv;
                void $this$cache$iv3;
                boolean $i$f$cache;
                boolean invalid$iv2;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"67@3158L2,68@3194L12,69@3247L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    Object object4;
                    Object object5;
                    Object value$iv$iv;
                    boolean bl2;
                    boolean bl3;
                    Object it$iv$iv;
                    boolean $i$f$cache2;
                    boolean $changed$iv2;
                    if ((n & 4) != 0) {
                        Object object6;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1255213433, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                        Composer composer = $composer;
                        invalid$iv2 = false;
                        $i$f$cache = false;
                        it$iv = $this$cache$iv3.rememberedValue();
                        bl5 = false;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            boolean bl4 = false;
                            Function1 value$iv = MediaDetailScreenKt::MediaDetailScreen$lambda$1$lambda$0;
                            $this$cache$iv3.updateRememberedValue((Object)value$iv);
                            object6 = value$iv;
                        } else {
                            object6 = it$iv;
                        }
                        Function1 function1 = (Function1)object6;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                        onMediaSelected = function1;
                    }
                    if ((n & 8) != 0) {
                        Object object7;
                        void $this$cache$iv$iv;
                        void $composer$iv3;
                        Composer invalid$iv2 = $composer;
                        $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv3.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv3, (int)0);
                        $composer$iv3.startReplaceGroup(-1633490746);
                        void bl5 = $composer$iv3;
                        boolean invalid$iv$iv = $composer$iv3.changed(qualifier$iv) | $composer$iv3.changed((Object)scope$iv);
                        $i$f$cache2 = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl3 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl2 = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(MediaViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object7 = value$iv$iv;
                        } else {
                            object7 = it$iv$iv;
                        }
                        object5 = object7;
                        $composer$iv3.endReplaceGroup();
                        object4 = object5;
                        $composer$iv3.endReplaceGroup();
                        viewModel2 = (MediaViewModel)object4;
                        $dirty &= 0xFFFFE3FF;
                    }
                    if ((n & 0x10) != 0) {
                        Object object8;
                        Composer $composer$iv3 = $composer;
                        $changed$iv2 = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv3.startReplaceGroup(-1168520582);
                        qualifier$iv = null;
                        scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv3, (int)0);
                        $composer$iv3.startReplaceGroup(-1633490746);
                        Composer $this$cache$iv$iv = $composer$iv3;
                        boolean invalid$iv$iv = $composer$iv3.changed(qualifier$iv) | $composer$iv3.changed((Object)scope$iv);
                        $i$f$cache2 = false;
                        it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        bl3 = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            bl2 = false;
                            value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(PlayerViewModel.class), (Qualifier)qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object8 = value$iv$iv;
                        } else {
                            object8 = it$iv$iv;
                        }
                        object5 = object8;
                        $composer$iv3.endReplaceGroup();
                        object4 = object5;
                        $composer$iv3.endReplaceGroup();
                        playerViewModel = (PlayerViewModel)object4;
                        $dirty &= 0xFFFF1FFF;
                    }
                } else {
                    $composer.skipToGroupEnd();
                    if ((n & 8) != 0) {
                        $dirty &= 0xFFFFE3FF;
                    }
                    if ((n & 0x10) != 0) {
                        $dirty &= 0xFFFF1FFF;
                    }
                }
                $composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1574488759, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.MediaDetailScreen (MediaDetailScreen.kt:70)");
                }
                String string2 = media.getId();
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1255217788, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                scope$iv = $composer;
                invalid$iv2 = $composer.changedInstance((Object)viewModel2) | $composer.changedInstance((Object)media);
                $i$f$cache = false;
                it$iv = $this$cache$iv3.rememberedValue();
                bl5 = false;
                if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    String string3 = string2;
                    boolean bl6 = false;
                    string2 = string3;
                    Function2 value$iv = (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(viewModel2, media, null){
                        int label;
                        final /* synthetic */ MediaViewModel $viewModel;
                        final /* synthetic */ EchoMediaItem $media;
                        {
                            this.$viewModel = $viewModel;
                            this.$media = $media;
                            super(2, $completion);
                        }

                        public final Object invokeSuspend(Object $result) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)$result);
                                    this.$viewModel.load(this.$media);
                                    return Unit.INSTANCE;
                                }
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                            return (Continuation)new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                            return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                        }
                    };
                    $this$cache$iv3.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv;
                }
                qualifier$iv = (Function2)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                EffectsKt.LaunchedEffect((Object)string2, (Function2)qualifier$iv, (Composer)$composer, (int)0);
                State state$delegate = SnapshotStateKt.collectAsState((StateFlow)viewModel2.getUiState(), null, (Composer)$composer, (int)0, (int)1);
                State activeTrack$delegate = SnapshotStateKt.collectAsState(playerViewModel.getCurrentTrack(), null, (Composer)$composer, (int)0, (int)1);
                State isPlaying$delegate = SnapshotStateKt.collectAsState(playerViewModel.isPlaying(), null, (Composer)$composer, (int)0, (int)1);
                EchoMediaItem echoMediaItem = MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)state$delegate).getMedia();
                if (echoMediaItem == null) {
                    echoMediaItem = media;
                }
                EchoMediaItem currentMedia = echoMediaItem;
                ImageHolder $i$a$-let-ComposerKt$cache$1$iv2 = currentMedia.getCover();
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1255227211, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                Composer value$iv = $composer;
                boolean invalid$iv3 = $composer.changed((Object)$i$a$-let-ComposerKt$cache$1$iv2);
                boolean $i$f$cache22 = false;
                Object it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl7 = false;
                    c = currentMedia.getCover();
                    String value$iv2 = c instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)c).getRequest().getUrl() : (c instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)c).getUri() : null);
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object2 = value$iv2;
                } else {
                    object2 = it$iv2;
                }
                Object bl6 = (String)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                String coverUrl = bl6;
                bl6 = currentMedia;
                String mediaTypeLabel = bl6 instanceof Album ? "ALBUM" : (bl6 instanceof Playlist ? "PLAYLIST" : (bl6 instanceof Artist ? "ARTIST" : (bl6 instanceof Radio ? "RADIO" : (bl6 instanceof Track ? "SONG" : "MEDIA"))));
                bl6 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                Composer $i$f$cache22 = $composer;
                int $changed$iv3 = 6;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
                c = modifier$iv2;
                int value$iv2 = 0x70 & $changed$iv3 << 3;
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
                boolean bl8 = false;
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                boolean bl9 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl10 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n3 = 0xE & $changed$iv$iv$iv2 >> 6;
                void $composer$iv4 = $composer$iv2;
                boolean bl11 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n4 = 6 | 0x70 & $changed$iv3 >> 6;
                void var41_67 = $composer$iv4;
                ColumnScope $this$MediaDetailScreen_u24lambda_u2432 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl12 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)2037186914, (String)"C99@4140L617,116@4807L11,116@4767L86,121@4992L7564,118@4863L7693:MediaDetailScreen.kt#zg4hxr");
                int $this$dp$iv = 16;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 8;
                $i$f$getDp = false;
                Modifier $this$dp$iv2 = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
                void var47_80 = $composer3;
                int n5 = 390;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var51_87 = modifier$iv;
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
                void $composer$iv5 = $composer$iv;
                boolean bl13 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n9 = 6 | 0x70 & $changed$iv >> 6;
                void var70_106 = $composer$iv5;
                RowScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u247 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl14 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1442323940, (String)"C103@4321L119,106@4453L28,109@4581L10,107@4494L253:MediaDetailScreen.kt#zg4hxr");
                IconButtonKt.IconButton(onBack, null, (boolean)false, null, null, ComposableSingletons$MediaDetailScreenKt.INSTANCE.getLambda$525484128$desktopApp(), (Composer)$composer2, (int)(0x30000 | 0xE & $dirty >> 3), (int)30);
                int $this$dp$iv3 = 8;
                boolean $i$f$getDp2 = false;
                SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3)), (Composer)$composer2, (int)6);
                String string4 = currentMedia.getTitle();
                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleMedium();
                FontWeight fontWeight = FontWeight.Companion.getSemiBold();
                int n10 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                TextKt.Text--4IGK_g((String)string4, null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)n10, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196608, (int)3120, (int)55262);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), (float)0.3f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer3, (int)0, (int)3);
                Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                LazyListState lazyListState = null;
                $this$dp$iv = 120;
                $i$f$getDp22 = false;
                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default((float)0.0f, (float)0.0f, (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv), (int)7, null);
                boolean bl15 = false;
                Arrangement.Vertical vertical2 = null;
                Alignment.Horizontal horizontal = null;
                FlingBehavior flingBehavior = null;
                boolean bl16 = false;
                OverscrollEffect overscrollEffect = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1873920531, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                void $i$f$getDp22 = $composer3;
                boolean invalid$iv4 = $composer.changed((Object)coverUrl) | $composer.changedInstance((Object)currentMedia) | $composer.changed((Object)mediaTypeLabel) | $composer.changed((Object)state$delegate) | $composer.changedInstance((Object)playerViewModel) | $composer.changedInstance((Object)viewModel2) | $composer.changedInstance((Object)media) | $composer.changed((Object)activeTrack$delegate) | $composer.changed((Object)isPlaying$delegate) | ($dirty & 0x380) == 256;
                boolean $i$f$cache3 = false;
                Object it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv4 || it$iv3 == Composer.Companion.getEmpty()) {
                    OverscrollEffect overscrollEffect2 = overscrollEffect;
                    boolean bl17 = bl16;
                    FlingBehavior flingBehavior2 = flingBehavior;
                    Alignment.Horizontal horizontal2 = horizontal;
                    Arrangement.Vertical vertical3 = vertical2;
                    boolean bl18 = bl15;
                    PaddingValues paddingValues2 = paddingValues;
                    LazyListState lazyListState2 = lazyListState;
                    Modifier modifier2 = modifier;
                    boolean bl19 = false;
                    Function1 function1 = arg_0 -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30(coverUrl, currentMedia, mediaTypeLabel, state$delegate, playerViewModel, viewModel2, media, activeTrack$delegate, isPlaying$delegate, onMediaSelected, arg_0);
                    modifier = modifier2;
                    lazyListState = lazyListState2;
                    paddingValues = paddingValues2;
                    bl15 = bl18;
                    vertical2 = vertical3;
                    horizontal = horizontal2;
                    flingBehavior = flingBehavior2;
                    bl16 = bl17;
                    overscrollEffect = overscrollEffect2;
                    Function1 value$iv3 = function1;
                    $this$cache$iv.updateRememberedValue((Object)value$iv3);
                    object = value$iv3;
                } else {
                    object = it$iv3;
                }
                Function1 function1 = (Function1)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                LazyDslKt.LazyColumn((Modifier)modifier, lazyListState, (PaddingValues)paddingValues, (boolean)bl15, vertical2, horizontal, flingBehavior, (boolean)bl16, overscrollEffect, (Function1)function1, (Composer)$composer3, (int)390, (int)506);
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
            if (scopeUpdateScope == null) break block39;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MediaDetailScreenKt.MediaDetailScreen$lambda$33(media, onBack, onMediaSelected, viewModel2, playerViewModel, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void TrackListItem(int index, Track track2, boolean isCurrent, boolean isPlaying2, Function0<Unit> onClick2, Function1<? super Long, String> formatDuration, Composer $composer, int $changed) {
        block44: {
            $composer = $composer.startRestartGroup(880813967);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(TrackListItem)P(1,5,2,3,4)306@12781L39,307@12860L25,315@13093L3584:MediaDetailScreen.kt#zg4hxr");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(index) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance((Object)track2) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(isCurrent) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed(isPlaying2) ? 2048 : 1024;
            }
            if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changedInstance(onClick2) ? 16384 : 8192;
            }
            if (($changed & 0x30000) == 0) {
                $dirty |= $composer.changedInstance(formatDuration) ? 131072 : 65536;
            }
            if ($composer.shouldExecute(($dirty & 0x12493) != 74898, $dirty & 1)) {
                long dur;
                Object object;
                void $this$cache$iv;
                long l;
                FontWeight fontWeight;
                Object object2;
                void $composer2;
                int $changed$iv$iv$iv;
                Function0 factory$iv$iv$iv;
                int $changed$iv$iv;
                void modifier$iv$iv;
                int $changed$iv;
                void modifier$iv;
                void contentAlignment$iv;
                void $composer$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $changed$iv2;
                void verticalAlignment$iv;
                void $composer$iv2;
                long l2;
                Object object3;
                void $this$cache$iv2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)880813967, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.TrackListItem (MediaDetailScreen.kt:305)");
                }
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)353671894, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv2.rememberedValue();
                boolean $i$a$-let-ComposerKt$cache$1$iv22 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl = false;
                    MutableInteractionSource value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableInteractionSource interactionSource = mutableInteractionSource;
                State isHovered$delegate = HoverInteractionKt.collectIsHoveredAsState((InteractionSource)((InteractionSource)interactionSource), (Composer)$composer, (int)6);
                ImageHolder c = track2.getCover();
                String trackCoverUrl = c instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)c).getRequest().getUrl() : (c instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)c).getUri() : null);
                int $this$dp$iv = 16;
                boolean $i$f$getDp = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 2;
                $i$f$getDp = false;
                Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                $this$dp$iv = 8;
                $i$f$getDp = false;
                Modifier modifier2 = ClipKt.clip((Modifier)modifier, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))));
                if (isCurrent) {
                    $composer.startReplaceGroup(353691041);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"322@13351L11");
                    $this$dp$iv = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), (float)0.4f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer.endReplaceGroup();
                    l2 = $this$dp$iv;
                } else if (MediaDetailScreenKt.TrackListItem$lambda$35((State<Boolean>)isHovered$delegate)) {
                    $composer.startReplaceGroup(353694017);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"323@13446L11");
                    $this$dp$iv = Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), (float)0.6f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
                    $composer.endReplaceGroup();
                    l2 = $this$dp$iv;
                } else {
                    $composer.startReplaceGroup(353696342);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"324@13534L11");
                    $this$dp$iv = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface-0d7_KjU();
                    $composer.endReplaceGroup();
                    l2 = $this$dp$iv;
                }
                int $this$dp$iv2 = 12;
                $i$f$getDp = false;
                float f2 = Dp.constructor-impl((float)$this$dp$iv2);
                $this$dp$iv2 = 8;
                $i$f$getDp = false;
                Modifier $this$dp$iv22 = PaddingKt.padding-VpY3zN4((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)HoverableKt.hoverable$default((Modifier)BackgroundKt.background-bw27NRU$default((Modifier)modifier2, (long)l2, null, (int)2, null), (MutableInteractionSource)interactionSource, (boolean)false, (int)2, null), (boolean)false, null, null, onClick2, (int)7, null), (float)f2, (float)Dp.constructor-impl((float)$this$dp$iv2));
                it$iv = Alignment.Companion.getCenterVertically();
                Composer $i$a$-let-ComposerKt$cache$1$iv22 = $composer;
                int value$iv = 384;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void var19_28 = modifier$iv2;
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
                    void factory$iv$iv$iv2;
                    $composer$iv2.createNode((Function0)factory$iv$iv$iv2);
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
                void var38_47 = $composer$iv3;
                RowScope $this$TrackListItem_u24lambda_u2440 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)2092105799, (String)"C333@13846L1042,376@15416L894:MediaDetailScreen.kt#zg4hxr");
                int $this$dp$iv32 = 36;
                boolean $i$f$getDp22 = false;
                Modifier $this$dp$iv32 = SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32));
                Alignment $i$f$getDp22 = Alignment.Companion.getCenter();
                TextStyle textStyle = $composer3;
                int n5 = 54;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                void var48_64 = modifier$iv;
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
                    $composer$iv.createNode(factory$iv$iv$iv);
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
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n9 = 6 | 0x70 & $changed$iv >> 6;
                void var67_84 = $composer$iv4;
                BoxScope $this$TrackListItem_u24lambda_u2440_u24lambda_u2436 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)120190013, (String)"C:MediaDetailScreen.kt#zg4hxr");
                if (MediaDetailScreenKt.TrackListItem$lambda$35((State<Boolean>)isHovered$delegate)) {
                    $composer2.startReplaceGroup(120185300);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"341@14157L11,338@14002L245");
                    object2 = PlayArrowKt.getPlayArrow((Icons.Filled)Icons.INSTANCE.getDefault());
                    long l3 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    int $this$dp$iv4 = 20;
                    boolean $i$f$getDp3 = false;
                    Modifier modifier3 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4));
                    IconKt.Icon-ww6aTOc((ImageVector)object2, (String)"Play", (Modifier)modifier3, (long)l3, (Composer)$composer2, (int)432, (int)0);
                    $composer2.endReplaceGroup();
                } else if (isPlaying2) {
                    $composer2.startReplaceGroup(120481009);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"348@14458L11,345@14300L248");
                    object2 = MusicNoteKt.getMusicNote((Icons.Filled)Icons.INSTANCE.getDefault());
                    long l4 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    int $this$dp$iv5 = 18;
                    boolean $i$f$getDp4 = false;
                    Modifier modifier4 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv5));
                    IconKt.Icon-ww6aTOc((ImageVector)object2, (String)"Playing", (Modifier)modifier4, (long)l4, (Composer)$composer2, (int)432, (int)0);
                    $composer2.endReplaceGroup();
                } else {
                    long l5;
                    $composer2.startReplaceGroup(120765651);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"354@14671L10,352@14586L278");
                    object2 = String.valueOf(index);
                    TextStyle textStyle2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
                    if (isCurrent) {
                        $composer2.startReplaceGroup(973732928);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"355@14751L11");
                        var77_97 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        $composer2.endReplaceGroup();
                        l5 = var77_97;
                    } else {
                        $composer2.startReplaceGroup(973735081);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"356@14818L11");
                        var77_97 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                        $composer2.endReplaceGroup();
                        l5 = var77_97;
                    }
                    long l6 = l5;
                    TextKt.Text--4IGK_g((String)object2, null, (long)l6, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle2, (Composer)$composer2, (int)0, (int)0, (int)65530);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                if (trackCoverUrl != null) {
                    $composer3.startReplaceGroup(2093128550);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"369@15234L11,363@14966L359,372@15338L29");
                    int $this$dp$iv6 = 40;
                    boolean $i$f$getDp5 = false;
                    Modifier modifier5 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6));
                    $this$dp$iv6 = 4;
                    $i$f$getDp5 = false;
                    SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)trackCoverUrl, (String)track2.getTitle(), (Modifier)BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)modifier5, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv6)))), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), null, (int)2, null), null, null, null, (ContentScale)ContentScale.Companion.getCrop(), (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer3, (int)0x180000, (int)0, (int)1976);
                    $this$dp$iv6 = 12;
                    $i$f$getDp5 = false;
                    SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6)), (Composer)$composer3, (int)6);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(2078281999);
                    $composer3.endReplaceGroup();
                }
                Modifier $this$dp$iv7 = RowScope.weight$default((RowScope)$this$TrackListItem_u24lambda_u2440, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
                $composer$iv = $composer3;
                $changed$iv = 0;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                modifier$iv$iv = modifier$iv;
                $changed$iv$iv = 0x70 & $changed$iv << 3;
                $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                $changed$iv$iv$iv = 6 | 0x380 & $changed$iv$iv << 6;
                $i$f$ReusableComposeNode2 = false;
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
                $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv);
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
                int $changed$iv3 = 0xE & $changed$iv$iv$iv >> 6;
                $composer$iv4 = $composer$iv;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int $changed2 = 6 | 0x70 & $changed$iv >> 6;
                $composer2 = $composer$iv4;
                ColumnScope $this$TrackListItem_u24lambda_u2440_u24lambda_u2439 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1696438864, (String)"C379@15538L10,377@15458L418,386@15936L11:MediaDetailScreen.kt#zg4hxr");
                object2 = track2.getTitle();
                TextStyle textStyle3 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
                FontWeight fontWeight2 = fontWeight = isCurrent ? FontWeight.Companion.getBold() : FontWeight.Companion.getNormal();
                if (isCurrent) {
                    $composer2.startReplaceGroup(1469304048);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"381@15698L11");
                    var83_101 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU();
                    $composer2.endReplaceGroup();
                    l = var83_101;
                } else {
                    $composer2.startReplaceGroup(1469306066);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"382@15761L11");
                    var83_101 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurface-0d7_KjU();
                    $composer2.endReplaceGroup();
                    l = var83_101;
                }
                long l7 = l;
                int n10 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                TextKt.Text--4IGK_g((String)object2, null, (long)l7, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)n10, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle3, (Composer)$composer2, (int)0, (int)3120, (int)55258);
                Iterable iterable = track2.getArtists();
                CharSequence charSequence = ", ";
                CharSequence charSequence2 = null;
                CharSequence charSequence3 = null;
                int n11 = 0;
                CharSequence charSequence4 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1469311284, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                fontWeight = $composer2;
                boolean invalid$iv2 = false;
                boolean $i$f$cache2 = false;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                boolean bl10 = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    CharSequence charSequence5 = charSequence4;
                    int n12 = n11;
                    CharSequence charSequence6 = charSequence3;
                    CharSequence charSequence7 = charSequence2;
                    CharSequence charSequence8 = charSequence;
                    Iterable iterable2 = iterable;
                    boolean bl11 = false;
                    Function1 function1 = MediaDetailScreenKt::TrackListItem$lambda$40$lambda$39$lambda$38$lambda$37;
                    iterable = iterable2;
                    charSequence = charSequence8;
                    charSequence2 = charSequence7;
                    charSequence3 = charSequence6;
                    n11 = n12;
                    charSequence4 = charSequence5;
                    Function1 value$iv2 = function1;
                    $this$cache$iv.updateRememberedValue((Object)value$iv2);
                    object = value$iv2;
                } else {
                    object = it$iv2;
                }
                textStyle3 = (Function1)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                String artists = CollectionsKt.joinToString$default((Iterable)iterable, (CharSequence)charSequence, charSequence2, charSequence3, (int)n11, charSequence4, (Function1)textStyle3, (int)30, null);
                if (!StringsKt.isBlank((CharSequence)artists)) {
                    $composer2.startReplaceGroup(-1695931457);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"390@16088L10,391@16152L11,388@16004L282");
                    textStyle3 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                    long l8 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    int n13 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    TextKt.Text--4IGK_g((String)artists, null, (long)l8, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)n13, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle3, (Composer)$composer2, (int)0, (int)3120, (int)55290);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1711800295);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                Long l9 = track2.getDuration();
                long l10 = dur = l9 != null ? l9 : 0L;
                if (dur > 0L) {
                    $composer3.startReplaceGroup(2094553465);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"403@16495L10,404@16555L11,401@16407L254");
                    String string2 = (String)formatDuration.invoke((Object)dur);
                    textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getBodySmall();
                    long l11 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    int $this$dp$iv8 = 8;
                    boolean $i$f$getDp6 = false;
                    Modifier modifier6 = PaddingKt.padding-VpY3zN4$default((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv8), (float)0.0f, (int)2, null);
                    TextKt.Text--4IGK_g((String)string2, (Modifier)modifier6, (long)l11, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer3, (int)48, (int)0, (int)65528);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(2078281999);
                    $composer3.endReplaceGroup();
                }
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
            if (scopeUpdateScope == null) break block44;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MediaDetailScreenKt.TrackListItem$lambda$41(index, track2, isCurrent, isPlaying2, onClick2, formatDuration, $changed, arg_0, arg_1));
        }
    }

    private static final Unit MediaDetailScreen$lambda$1$lambda$0(EchoMediaItem it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final MediaDetailState MediaDetailScreen$lambda$3(State<MediaDetailState> $state$delegate) {
        void $this$getValue$iv;
        State<MediaDetailState> state = $state$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (MediaDetailState)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final Track MediaDetailScreen$lambda$4(State<Track> $activeTrack$delegate) {
        void $this$getValue$iv;
        State<Track> state = $activeTrack$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Track)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean MediaDetailScreen$lambda$5(State<Boolean> $isPlaying$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isPlaying$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$9(String $mediaTypeLabel, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C166@7021L10,168@7160L11,163@6809L411:MediaDetailScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1861585399, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.MediaDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaDetailScreen.kt:163)");
            }
            int $this$dp$iv = 8;
            boolean $i$f$getDp = false;
            float f = Dp.constructor-impl((float)$this$dp$iv);
            $this$dp$iv = 2;
            $i$f$getDp = false;
            Modifier modifier = PaddingKt.padding-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            long l = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
            TextKt.Text--4IGK_g((String)$mediaTypeLabel, (Modifier)modifier, (long)l, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer, (int)196656, (int)0, (int)65496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$15$lambda$12$lambda$11(PlayerViewModel $playerViewModel, State $state$delegate) {
        if (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty()) {
            $playerViewModel.play((Track)CollectionsKt.first(MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()), MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks());
        }
        return Unit.INSTANCE;
    }

    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14$lambda$13(PlayerViewModel $playerViewModel, State $state$delegate) {
        if (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty()) {
            List shuffled = CollectionsKt.shuffled((Iterable)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks());
            $playerViewModel.setShuffle(true);
            $playerViewModel.play((Track)CollectionsKt.first((List)shuffled), shuffled);
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18(String $coverUrl, EchoMediaItem $currentMedia, String $mediaTypeLabel, State $state$delegate, PlayerViewModel $playerViewModel, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C124@5059L5318:MediaDetailScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            Object object;
            Object object2;
            Function0 value$iv;
            void $this$cache$iv;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void horizontalArrangement$iv;
            void $composer$iv;
            boolean $i$f$getDp;
            int $this$dp$iv;
            void $composer3;
            int $changed$iv$iv$iv2;
            Function0 factory$iv$iv$iv;
            int $changed$iv$iv2;
            void modifier$iv$iv2;
            int $changed$iv;
            void modifier$iv;
            void contentAlignment$iv;
            void $composer$iv2;
            void $composer4;
            void $changed$iv$iv$iv3;
            void $changed$iv$iv3;
            void modifier$iv$iv3;
            void modifier$iv2;
            void $changed$iv2;
            void verticalAlignment$iv;
            void $composer$iv3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)1887743372, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.MediaDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaDetailScreen.kt:124)");
            }
            int $this$dp$iv22 = 24;
            boolean $i$f$getDp2 = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int n = 390;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var15_17 = modifier$iv2;
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
            void var34_36 = $composer$iv4;
            RowScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2418_u24lambda_u2417 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)749595925, (String)"C135@5535L11,131@5329L1113,155@6464L29,158@6549L3810:MediaDetailScreen.kt#zg4hxr");
            int $this$dp$iv3 = 180;
            boolean $i$f$getDp3 = false;
            Modifier modifier = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv3));
            $this$dp$iv3 = 12;
            $i$f$getDp3 = false;
            Modifier $this$dp$iv32 = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)modifier, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv3)))), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), null, (int)2, null);
            Alignment $i$f$getDp22 = Alignment.Companion.getCenter();
            void var39_47 = $composer4;
            int n6 = 48;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
            void var44_53 = modifier$iv;
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
            int n9 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv5 = $composer$iv2;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n10 = 6 | 0x70 & $changed$iv >> 6;
            void var63_72 = $composer$iv5;
            BoxScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2418_u24lambda_u2417_u24lambda_u248 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1243015883, (String)"C:MediaDetailScreen.kt#zg4hxr");
            if ($coverUrl != null) {
                $composer3.startReplaceGroup(-1243006336);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"139@5724L296");
                SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)$coverUrl, (String)$currentMedia.getTitle(), (Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, null, null, (ContentScale)ContentScale.Companion.getCrop(), (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer3, (int)0x180180, (int)0, (int)1976);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1242650704);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"150@6336L11,146@6082L312");
                $this$dp$iv = 64;
                $i$f$getDp = false;
                IconKt.Icon-ww6aTOc((ImageVector)MusicNoteKt.getMusicNote((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (Composer)$composer3, (int)432, (int)0);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $this$dp$iv4 = 24;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4)), (Composer)$composer4, (int)6);
            Modifier $this$dp$iv4 = RowScope.weight$default((RowScope)$this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2418_u24lambda_u2417, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
            $composer$iv2 = $composer4;
            $changed$iv = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
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
            boolean bl8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int $changed2 = 6 | 0x70 & $changed$iv >> 6;
            $composer3 = $composer$iv5;
            ColumnScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2418_u24lambda_u2417_u24lambda_u2416 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl9 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1199974203, (String)"C161@6724L11,162@6779L467,159@6603L643,172@7272L29,176@7438L10,174@7327L323,200@8524L30,203@8641L1696:MediaDetailScreen.kt#zg4hxr");
            $this$dp$iv = 4;
            $i$f$getDp = false;
            SurfaceKt.Surface-T9BRK9s(null, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv))), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), (long)0L, (float)0.0f, (float)0.0f, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)1861585399, (boolean)true, (arg_0, arg_1) -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$9($mediaTypeLabel, arg_0, arg_1), (Composer)$composer3, (int)54)), (Composer)$composer3, (int)0xC00000, (int)121);
            $this$dp$iv = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer3, (int)6);
            Object $this$dp$iv5 = $currentMedia.getTitle();
            TextStyle $i$f$getDp32 = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getHeadlineLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            int n11 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            TextKt.Text--4IGK_g((String)$this$dp$iv5, null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)n11, (boolean)false, (int)2, (int)0, null, (TextStyle)$i$f$getDp32, (Composer)$composer3, (int)196608, (int)3120, (int)55262);
            $this$dp$iv5 = $currentMedia.getSubtitle();
            if ($this$dp$iv5 == null) {
                $composer3.startReplaceGroup(1200956994);
                $composer3.endReplaceGroup();
                v1 = null;
            } else {
                $composer3.startReplaceGroup(1200956995);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"*183@7740L29,186@7902L10,187@7980L11,184@7798L240");
                String sub = $this$dp$iv5;
                boolean bl10 = false;
                int $this$dp$iv62 = 4;
                boolean $i$f$getDp4 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv62)), (Composer)$composer3, (int)6);
                TextStyle $this$dp$iv62 = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getTitleMedium();
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)sub, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv62, (Composer)$composer3, (int)0, (int)0, (int)65530);
                $composer3.endReplaceGroup();
                v1 = Unit.INSTANCE;
            }
            if (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty()) {
                $composer3.startReplaceGroup(1201375991);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"192@8151L29,195@8338L10,196@8414L11,193@8209L263");
                $this$dp$iv = 4;
                $i$f$getDp = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer3, (int)6);
                $this$dp$iv5 = MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks().size() + " songs";
                $i$f$getDp32 = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getBodySmall();
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                TextKt.Text--4IGK_g((String)$this$dp$iv5, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$i$f$getDp32, (Composer)$composer3, (int)0, (int)0, (int)65530);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1193307280);
                $composer3.endReplaceGroup();
            }
            $this$dp$iv = 16;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer3, (int)6);
            int $this$dp$iv72 = 12;
            boolean $i$f$getDp5 = false;
            Arrangement.Horizontal $this$dp$iv72 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv72));
            void bl10 = $composer3;
            int $changed$iv4 = 48;
            boolean $i$f$Row2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv3 = (Modifier)Modifier.Companion;
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
            Modifier modifier2 = modifier$iv3;
            int n12 = 0x70 & $changed$iv4 << 3;
            boolean $i$f$Layout3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function03 = ComposeUiNode.Companion.getConstructor();
            int n13 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv3;
                $composer$iv.createNode((Function0)factory$iv$iv$iv3);
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
            int n14 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv6 = $composer$iv;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n15 = 6 | 0x70 & $changed$iv4 >> 6;
            void var96_116 = $composer$iv6;
            RowScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2418_u24lambda_u2417_u24lambda_u2416_u24lambda_u2415 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl11 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-539375194, (String)"C205@8778L239,211@9188L11,211@9144L64,204@8728L763,219@9579L383,218@9521L790:MediaDetailScreen.kt#zg4hxr");
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)952432381, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
            void var99_119 = $composer2;
            boolean invalid$iv = $composer2.changed((Object)$state$delegate) | $composer2.changedInstance((Object)$playerViewModel);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl12 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl13 = false;
                value$iv = () -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$15$lambda$12$lambda$11($playerViewModel, $state$delegate);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv;
            }
            Function0 function04 = (Function0)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ButtonKt.Button((Function0)function04, null, (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty() ? 1 : 0) != 0, null, (ButtonColors)ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), 0L, 0L, 0L, (Composer)$composer2, ButtonDefaults.$stable << 12, 14), null, null, null, null, ComposableSingletons$MediaDetailScreenKt.INSTANCE.getLambda$1078695326$desktopApp(), (Composer)$composer2, (int)0x30000000, (int)490);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)952458157, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
            $this$cache$iv = $composer2;
            invalid$iv = $composer2.changed((Object)$state$delegate) | $composer2.changedInstance((Object)$playerViewModel);
            $i$f$cache = false;
            it$iv = $this$cache$iv.rememberedValue();
            bl12 = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                boolean bl14 = false;
                value$iv = () -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18$lambda$17$lambda$16$lambda$15$lambda$14$lambda$13($playerViewModel, $state$delegate);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            function04 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ButtonKt.OutlinedButton((Function0)function04, null, (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty() ? 1 : 0) != 0, null, null, null, null, null, null, ComposableSingletons$MediaDetailScreenKt.INSTANCE.getLambda$71230812$desktopApp(), (Composer)$composer2, (int)0x30000000, (int)506);
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

    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$21$lambda$20$lambda$19(MediaViewModel $viewModel, EchoMediaItem $media) {
        $viewModel.load($media);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$21(MediaViewModel $viewModel, EchoMediaItem $media, State $state$delegate, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C251@10891L25,249@10799L139:MediaDetailScreen.kt#zg4hxr");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            Object object;
            void $this$cache$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)350761594, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screens.MediaDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaDetailScreen.kt:249)");
            }
            Throwable throwable = MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getError();
            Throwable throwable2 = throwable;
            Intrinsics.checkNotNull((Object)throwable);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)2074446419, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
            Composer composer = $composer;
            boolean invalid$iv = $composer.changedInstance((Object)$viewModel) | $composer.changedInstance((Object)$media);
            boolean $i$f$cache = false;
            Object it$iv = $this$cache$iv.rememberedValue();
            boolean bl = false;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Throwable throwable3 = throwable2;
                boolean bl2 = false;
                throwable2 = throwable3;
                Function0 value$iv = () -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$21$lambda$20$lambda$19($viewModel, $media);
                $this$cache$iv.updateRememberedValue((Object)value$iv);
                object = value$iv;
            } else {
                object = it$iv;
            }
            Function0 function0 = (Function0)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
            SearchAndOthersKt.ErrorView(throwable2, (Function0<Unit>)function0, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Object MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$22(int idx, Track t) {
        Intrinsics.checkNotNullParameter((Object)t, (String)"t");
        return t.getId() + "_" + idx;
    }

    private static final Object MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$26(int n, Shelf s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        return s.getId();
    }

    private static final Unit MediaDetailScreen$lambda$32$lambda$31$lambda$30(String $coverUrl, EchoMediaItem $currentMedia, String $mediaTypeLabel, State $state$delegate, PlayerViewModel $playerViewModel, MediaViewModel $viewModel, EchoMediaItem $media, State $activeTrack$delegate, State $isPlaying$delegate, Function1 $onMediaSelected, LazyListScope $this$LazyColumn) {
        List<Shelf> items$iv;
        LazyListScope $this$itemsIndexed_u24default$iv;
        boolean $i$f$itemsIndexed;
        Function2 key$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, (Function3)((Function3)ComposableLambdaKt.composableLambdaInstance((int)1887743372, (boolean)true, (arg_0, arg_1, arg_2) -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$18($coverUrl, $currentMedia, $mediaTypeLabel, $state$delegate, $playerViewModel, arg_0, arg_1, arg_2))), (int)3, null);
        if (MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).isLoading()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$MediaDetailScreenKt.INSTANCE.getLambda$-1347986351$desktopApp(), (int)3, null);
        }
        if (MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getError() != null) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, (Function3)((Function3)ComposableLambdaKt.composableLambdaInstance((int)350761594, (boolean)true, (arg_0, arg_1, arg_2) -> MediaDetailScreenKt.MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$21($viewModel, $media, $state$delegate, arg_0, arg_1, arg_2))), (int)3, null);
        }
        if (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks()).isEmpty()) {
            LazyListScope.item$default((LazyListScope)$this$LazyColumn, null, null, ComposableSingletons$MediaDetailScreenKt.INSTANCE.getLambda$1551902937$desktopApp(), (int)3, null);
            LazyListScope lazyListScope = $this$LazyColumn;
            List<Track> list2 = MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getTracks();
            key$iv = MediaDetailScreenKt::MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$22;
            $i$f$itemsIndexed = false;
            $this$itemsIndexed_u24default$iv.items(items$iv.size(), key$iv != null ? (Function1)new Function1<Integer, Object>(key$iv, items$iv){
                final /* synthetic */ Function2 $key;
                final /* synthetic */ List $items;
                {
                    this.$key = $key;
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    return this.$key.invoke((Object)index, this.$items.get(index));
                }
            } : null, (Function1)new Function1<Integer, Object>(items$iv){
                final /* synthetic */ List $items;
                {
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    this.$items.get(index);
                    int n = index;
                    boolean bl = false;
                    return null;
                }
            }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)2039820996, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $playerViewModel, $state$delegate, $activeTrack$delegate, $isPlaying$delegate){
                final /* synthetic */ List $items;
                final /* synthetic */ PlayerViewModel $playerViewModel$inlined;
                final /* synthetic */ State $state$delegate$inlined;
                final /* synthetic */ State $activeTrack$delegate$inlined;
                final /* synthetic */ State $isPlaying$delegate$inlined;
                {
                    this.$items = $items;
                    this.$playerViewModel$inlined = playerViewModel;
                    this.$state$delegate$inlined = state;
                    this.$activeTrack$delegate$inlined = state2;
                    this.$isPlaying$delegate$inlined = state3;
                }

                /*
                 * WARNING - void declaration
                 */
                @Composable
                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter((Object)$this$items, (String)"$this$items");
                    ComposerKt.sourceInformation((Composer)$composer, (String)"C214@10657L26:LazyDsl.kt#428nma");
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
                        Object object2;
                        Function0 value$iv;
                        Function0 function0;
                        void var21_21;
                        void var20_20;
                        boolean bl;
                        boolean bl2;
                        void $this$cache$iv;
                        void index;
                        void track2;
                        void $composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)2039820996, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                        }
                        int n = 0xE & $dirty | 0x70 & $dirty;
                        Composer composer = $composer;
                        Track track3 = (Track)this.$items.get(it);
                        int n2 = it;
                        LazyItemScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2425 = $this$items;
                        boolean bl3 = false;
                        $composer2.startReplaceGroup(-358521475);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"C*274@11806L97,277@11946L38,269@11568L438:MediaDetailScreen.kt#zg4hxr");
                        Track track4 = MediaDetailScreenKt.access$MediaDetailScreen$lambda$4(this.$activeTrack$delegate$inlined);
                        boolean isCurrent = Intrinsics.areEqual((Object)(track4 != null ? track4.getId() : null), (Object)track2.getId());
                        void v1 = index + true;
                        void v2 = track2;
                        boolean bl4 = isCurrent;
                        boolean bl5 = isCurrent && MediaDetailScreenKt.access$MediaDetailScreen$lambda$5(this.$isPlaying$delegate$inlined);
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1119934607, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                        void var13_13 = $composer2;
                        boolean invalid$iv = $composer2.changedInstance((Object)this.$playerViewModel$inlined) | $composer2.changedInstance((Object)track2) | $composer2.changed((Object)this.$state$delegate$inlined);
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl6 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            bl2 = bl5;
                            bl = bl4;
                            var20_20 = v2;
                            var21_21 = v1;
                            boolean bl7 = false;
                            function0 = (Function0)new Function0<Unit>(this.$playerViewModel$inlined, (Track)track2, (State<MediaDetailState>)this.$state$delegate$inlined){
                                final /* synthetic */ PlayerViewModel $playerViewModel;
                                final /* synthetic */ Track $track;
                                final /* synthetic */ State<MediaDetailState> $state$delegate;
                                {
                                    this.$playerViewModel = $playerViewModel;
                                    this.$track = $track;
                                    this.$state$delegate = $state$delegate;
                                }

                                public final void invoke() {
                                    this.$playerViewModel.play(this.$track, MediaDetailScreenKt.access$MediaDetailScreen$lambda$3(this.$state$delegate).getTracks());
                                }
                            };
                            v1 = var21_21;
                            v2 = var20_20;
                            bl4 = bl;
                            bl5 = bl2;
                            value$iv = function0;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv;
                        }
                        Function0 function02 = (Function0)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        Function0 function03 = function02;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1119930186, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                        $this$cache$iv = $composer2;
                        invalid$iv = $composer2.changedInstance((Object)this.$playerViewModel$inlined);
                        $i$f$cache = false;
                        it$iv = $this$cache$iv.rememberedValue();
                        bl6 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function0 = function03;
                            bl2 = bl5;
                            bl = bl4;
                            var20_20 = v2;
                            var21_21 = v1;
                            boolean bl8 = false;
                            Function1 function1 = (Function1)new Function1<Long, String>(this.$playerViewModel$inlined){
                                final /* synthetic */ PlayerViewModel $playerViewModel;
                                {
                                    this.$playerViewModel = $playerViewModel;
                                }

                                public final String invoke(long it) {
                                    return this.$playerViewModel.formatDuration(it);
                                }
                            };
                            v1 = var21_21;
                            v2 = var20_20;
                            bl4 = bl;
                            bl5 = bl2;
                            function03 = function0;
                            value$iv = function1;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object = value$iv;
                        } else {
                            object = it$iv;
                        }
                        function02 = (Function1)object;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        MediaDetailScreenKt.access$TrackListItem((int)v1, (Track)v2, bl4, bl5, function03, (Function1)function02, (Composer)$composer2, 0x70 & $changed2 >> 3);
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
        if (!((Collection)MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getArtistShelves()).isEmpty()) {
            $this$itemsIndexed_u24default$iv = $this$LazyColumn;
            items$iv = MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate).getArtistShelves();
            key$iv = MediaDetailScreenKt::MediaDetailScreen$lambda$32$lambda$31$lambda$30$lambda$26;
            $i$f$itemsIndexed = false;
            $this$itemsIndexed_u24default$iv.items(items$iv.size(), key$iv != null ? (Function1)new Function1<Integer, Object>(key$iv, items$iv){
                final /* synthetic */ Function2 $key;
                final /* synthetic */ List $items;
                {
                    this.$key = $key;
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    return this.$key.invoke((Object)index, this.$items.get(index));
                }
            } : null, (Function1)new Function1<Integer, Object>(items$iv){
                final /* synthetic */ List $items;
                {
                    this.$items = $items;
                }

                public final Object invoke(int index) {
                    this.$items.get(index);
                    int n = index;
                    boolean bl = false;
                    return null;
                }
            }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)2039820996, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $onMediaSelected, $playerViewModel){
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
                    ComposerKt.sourceInformation((Composer)$composer, (String)"C214@10657L26:LazyDsl.kt#428nma");
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
                        Object object2;
                        Function1 value$iv;
                        Function1 function1;
                        void var17_17;
                        Function1 function12;
                        void $this$cache$iv;
                        void shelf;
                        void $composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)2039820996, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                        }
                        int n = 0xE & $dirty | 0x70 & $dirty;
                        Composer composer = $composer;
                        Shelf shelf2 = (Shelf)this.$items.get(it);
                        LazyItemScope $this$MediaDetailScreen_u24lambda_u2432_u24lambda_u2431_u24lambda_u2430_u24lambda_u2429 = $this$items;
                        boolean bl = false;
                        $composer2.startReplaceGroup(-975829525);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"C*288@12391L28,289@12459L33,285@12248L266:MediaDetailScreen.kt#zg4hxr");
                        void v0 = shelf;
                        Function1 function13 = this.$onMediaSelected$inlined;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-170021366, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                        void var11_11 = $composer2;
                        boolean invalid$iv = $composer2.changedInstance((Object)this.$playerViewModel$inlined);
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv.rememberedValue();
                        boolean bl2 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function12 = function13;
                            var17_17 = v0;
                            boolean bl3 = false;
                            function1 = (Function1)new Function1<Track, Unit>(this.$playerViewModel$inlined){
                                final /* synthetic */ PlayerViewModel $playerViewModel;
                                {
                                    this.$playerViewModel = $playerViewModel;
                                }

                                public final void invoke(Track it) {
                                    Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                                    PlayerViewModel.play$default((PlayerViewModel)this.$playerViewModel, (Track)it, null, (int)2, null);
                                }
                            };
                            v0 = var17_17;
                            function13 = function12;
                            value$iv = function1;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv;
                        }
                        Function1 function14 = (Function1)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        Function1 function15 = function14;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-170019185, (String)"CC(remember):MediaDetailScreen.kt#9igjgp");
                        $this$cache$iv = $composer2;
                        invalid$iv = $composer2.changedInstance((Object)this.$playerViewModel$inlined);
                        $i$f$cache = false;
                        it$iv = $this$cache$iv.rememberedValue();
                        bl2 = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            function1 = function15;
                            function12 = function13;
                            var17_17 = v0;
                            boolean bl4 = false;
                            Function1 function16 = (Function1)new Function1<EchoMediaItem, Unit>(this.$playerViewModel$inlined){
                                final /* synthetic */ PlayerViewModel $playerViewModel;
                                {
                                    this.$playerViewModel = $playerViewModel;
                                }

                                public final void invoke(EchoMediaItem it) {
                                    Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                                    this.$playerViewModel.playMedia(it);
                                }
                            };
                            v0 = var17_17;
                            function13 = function12;
                            function15 = function1;
                            value$iv = function16;
                            $this$cache$iv.updateRememberedValue((Object)value$iv);
                            object = value$iv;
                        } else {
                            object = it$iv;
                        }
                        function14 = (Function1)object;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        ShelfRowKt.ShelfRow((Shelf)v0, (Function1)function13, (Function1)function15, (Function1)function14, null, null, null, (Composer)$composer2, (int)(0xE & $changed2 >> 6), (int)112);
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
        return Unit.INSTANCE;
    }

    private static final Unit MediaDetailScreen$lambda$33(EchoMediaItem $media, Function0 $onBack, Function1 $onMediaSelected, MediaViewModel $viewModel, PlayerViewModel $playerViewModel, int $$changed, int $$default, Composer $composer, int $force) {
        MediaDetailScreenKt.MediaDetailScreen($media, (Function0<Unit>)$onBack, (Function1<? super EchoMediaItem, Unit>)$onMediaSelected, $viewModel, $playerViewModel, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean TrackListItem$lambda$35(State<Boolean> $isHovered$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isHovered$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    private static final CharSequence TrackListItem$lambda$40$lambda$39$lambda$38$lambda$37(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final Unit TrackListItem$lambda$41(int $index, Track $track, boolean $isCurrent, boolean $isPlaying, Function0 $onClick, Function1 $formatDuration, int $$changed, Composer $composer, int $force) {
        MediaDetailScreenKt.TrackListItem($index, $track, $isCurrent, $isPlaying, (Function0<Unit>)$onClick, (Function1<? super Long, String>)$formatDuration, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ MediaDetailState access$MediaDetailScreen$lambda$3(State $state$delegate) {
        return MediaDetailScreenKt.MediaDetailScreen$lambda$3((State<MediaDetailState>)$state$delegate);
    }

    public static final /* synthetic */ Track access$MediaDetailScreen$lambda$4(State $activeTrack$delegate) {
        return MediaDetailScreenKt.MediaDetailScreen$lambda$4((State<Track>)$activeTrack$delegate);
    }

    public static final /* synthetic */ void access$TrackListItem(int index, Track track2, boolean isCurrent, boolean isPlaying2, Function0 onClick2, Function1 formatDuration, Composer $composer, int $changed) {
        MediaDetailScreenKt.TrackListItem(index, track2, isCurrent, isPlaying2, (Function0<Unit>)onClick2, (Function1<? super Long, String>)formatDuration, $composer, $changed);
    }

    public static final /* synthetic */ boolean access$MediaDetailScreen$lambda$5(State $isPlaying$delegate) {
        return MediaDetailScreenKt.MediaDetailScreen$lambda$5((State<Boolean>)$isPlaying$delegate);
    }
}

