/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.animation.core.AnimationSpecKt
 *  androidx.compose.animation.core.DurationBasedAnimationSpec
 *  androidx.compose.animation.core.Easing
 *  androidx.compose.animation.core.EasingKt
 *  androidx.compose.animation.core.InfiniteRepeatableSpec
 *  androidx.compose.animation.core.InfiniteTransition
 *  androidx.compose.animation.core.InfiniteTransitionKt
 *  androidx.compose.animation.core.RepeatMode
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.BorderKt
 *  androidx.compose.foundation.CanvasKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.ImageKt
 *  androidx.compose.foundation.interaction.InteractionSourceKt
 *  androidx.compose.foundation.interaction.MutableInteractionSource
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.BoxWithConstraintsKt
 *  androidx.compose.foundation.layout.BoxWithConstraintsScope
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.OffsetKt
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
 *  androidx.compose.material3.IconButtonKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.TextKt
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.EffectsKt
 *  androidx.compose.runtime.MutableState
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
 *  androidx.compose.ui.draw.RotateKt
 *  androidx.compose.ui.geometry.CornerRadius
 *  androidx.compose.ui.geometry.Offset
 *  androidx.compose.ui.geometry.Size
 *  androidx.compose.ui.graphics.Brush
 *  androidx.compose.ui.graphics.Brush$Companion
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.ColorKt
 *  androidx.compose.ui.graphics.DesktopImageConverters_desktopKt
 *  androidx.compose.ui.graphics.ImageBitmap
 *  androidx.compose.ui.graphics.Path
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.graphics.SkiaBackedPath_skikoKt
 *  androidx.compose.ui.graphics.StrokeCap
 *  androidx.compose.ui.graphics.drawscope.DrawContext
 *  androidx.compose.ui.graphics.drawscope.DrawScope
 *  androidx.compose.ui.graphics.drawscope.DrawStyle
 *  androidx.compose.ui.graphics.drawscope.DrawTransform
 *  androidx.compose.ui.graphics.drawscope.Stroke
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.input.pointer.AwaitPointerEventScope
 *  androidx.compose.ui.input.pointer.PointerEvent
 *  androidx.compose.ui.input.pointer.PointerEventPass
 *  androidx.compose.ui.input.pointer.PointerEventType
 *  androidx.compose.ui.input.pointer.SuspendingPointerInputFilter_skikoKt
 *  androidx.compose.ui.layout.ContentScale
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontFamily
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.text.font.GenericFontFamily
 *  androidx.compose.ui.text.style.TextOverflow
 *  androidx.compose.ui.unit.Dp
 *  androidx.compose.ui.unit.TextUnitKt
 *  coil3.compose.SingletonAsyncImageKt
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.DelayKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.screensaver;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.DesktopImageConverters_desktopKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SkiaBackedPath_skikoKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilter_skikoKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil3.compose.SingletonAsyncImageKt;
import dev.brahmkshatriya.echo.common.models.Album;
import dev.brahmkshatriya.echo.common.models.Artist;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.ui.screensaver.ComposableSingletons$EchoScreensaverKt;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.imageio.ImageIO;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\b\u001a#\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u00a2\u0006\u0002\u0010\"\u001a#\u0010#\u001a\u00020\u0001*\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b'\u0010\u0010\u001a/\u0010(\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003\u00a2\u0006\u0002\u0010)\u001a+\u0010*\u001a\u00020\u0001*\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b.\u0010/\u001a\u001b\u00100\u001a\u00020\u0001*\u00020\n2\u0006\u0010+\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b1\u00102\u001a\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0019H\u0002\u00a8\u00066\u00b2\u0006\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001a\u001a\u00020\u0019X\u008a\u0084\u0002\u00b2\u0006\u0012\u0010\u0012\u001a\n 7*\u0004\u0018\u00010\u00130\u0013X\u008a\u008e\u0002\u00b2\u0006\n\u0010\u001b\u001a\u00020\u000eX\u008a\u0084\u0002\u00b2\u0006\n\u00108\u001a\u00020\u000eX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001d\u001a\u00020\u000eX\u008a\u0084\u0002\u00b2\u0006\n\u0010\u001e\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2={"EchoScreensaver", "", "playerViewModel", "Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;", "onWakeUp", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ldev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawGothicAtmosphere", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "canvasSize", "Landroidx/compose/ui/geometry/Size;", "phase", "", "drawGothicAtmosphere-12SF9DM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "GothicButterflyBannerCapsule", "currentTime", "Ljava/time/LocalDateTime;", "currentTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "isPlaying", "", "positionMs", "", "durationMs", "wavePhase", "pulse", "vinylRotation", "glintPhase", "onPlayPause", "onPrevious", "onNext", "(Ljava/time/LocalDateTime;Ldev/brahmkshatriya/echo/common/models/Track;ZJJFFFFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "drawStarGlint", "center", "Landroidx/compose/ui/geometry/Offset;", "alpha", "drawStarGlint-d-4ec7I", "GothicSpectrumRow", "(ZFFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "drawGothicAnalogClock", "size", "time", "hasTrackCover", "drawGothicAnalogClock-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLjava/time/LocalDateTime;Z)V", "drawGothicCompassBackground", "drawGothicCompassBackground-d16Qtg0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "formatMs", "", "ms", "desktopApp", "kotlin.jvm.PlatformType", "visualizerPulse"})
@SourceDebugExtension(value={"SMAP\nEchoScreensaver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoScreensaver.kt\ndev/brahmkshatriya/echo/desktop/ui/screensaver/EchoScreensaverKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Size.kt\nandroidx/compose/ui/geometry/Size\n+ 8 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 9 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 10 Offset.kt\nandroidx/compose/ui/geometry/OffsetKt\n+ 11 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 12 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 13 Offset.kt\nandroidx/compose/ui/geometry/Offset\n+ 14 DrawScope.kt\nandroidx/compose/ui/graphics/drawscope/DrawScopeKt\n+ 15 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 16 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 17 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 18 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 19 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n+ 20 CornerRadius.kt\nandroidx/compose/ui/geometry/CornerRadiusKt\n*L\n1#1,963:1\n1247#2,6:964\n1247#2,6:970\n1247#2,6:976\n1247#2,6:982\n1247#2,6:988\n1247#2,6:994\n1247#2,6:1036\n1247#2,6:1042\n1247#2,6:1048\n1247#2,6:1054\n1247#2,3:1091\n1250#2,3:1095\n1247#2,6:1137\n1247#2,6:1554\n1247#2,6:1564\n1247#2,6:1614\n1247#2,6:1818\n1247#2,6:2049\n70#3:1000\n68#3,8:1001\n77#3:1063\n70#3:1441\n67#3,9:1442\n70#3:1482\n68#3,8:1483\n70#3:1518\n68#3,8:1519\n77#3:1563\n77#3:1573\n70#3:1578\n68#3,8:1579\n77#3:1625\n70#3:1627\n67#3,9:1628\n70#3:1904\n68#3,8:1905\n77#3:1944\n70#3:1990\n67#3,9:1991\n77#3:2031\n77#3:2048\n77#3:2058\n79#4,6:1009\n86#4,3:1024\n89#4,2:1033\n93#4:1062\n79#4,6:1451\n86#4,3:1466\n89#4,2:1475\n79#4,6:1491\n86#4,3:1506\n89#4,2:1515\n79#4,6:1527\n86#4,3:1542\n89#4,2:1551\n93#4:1562\n93#4:1572\n79#4,6:1587\n86#4,3:1602\n89#4,2:1611\n93#4:1624\n79#4,6:1637\n86#4,3:1652\n89#4,2:1661\n79#4,6:1673\n86#4,3:1688\n89#4,2:1697\n79#4,6:1706\n86#4,3:1721\n89#4,2:1730\n79#4,6:1744\n86#4,3:1759\n89#4,2:1768\n93#4:1774\n93#4:1778\n79#4,6:1790\n86#4,3:1805\n89#4,2:1814\n93#4:1826\n79#4,6:1835\n86#4,3:1850\n89#4,2:1859\n79#4,6:1874\n86#4,3:1889\n89#4,2:1898\n79#4,6:1913\n86#4,3:1928\n89#4,2:1937\n93#4:1943\n93#4:1948\n79#4,6:1961\n86#4,3:1976\n89#4,2:1985\n79#4,6:2000\n86#4,3:2015\n89#4,2:2024\n93#4:2030\n93#4:2035\n93#4:2039\n93#4:2043\n93#4:2047\n93#4:2057\n347#5,9:1015\n356#5:1035\n357#5,2:1060\n347#5,9:1457\n356#5:1477\n347#5,9:1497\n356#5:1517\n347#5,9:1533\n356#5:1553\n357#5,2:1560\n357#5,2:1570\n347#5,9:1593\n356#5:1613\n357#5,2:1622\n347#5,9:1643\n356#5:1663\n347#5,9:1679\n356#5:1699\n347#5,9:1712\n356#5:1732\n347#5,9:1750\n356#5:1770\n357#5,2:1772\n357#5,2:1776\n347#5,9:1796\n356#5:1816\n357#5,2:1824\n347#5,9:1841\n356#5:1861\n347#5,9:1880\n356#5:1900\n347#5,9:1919\n356#5:1939\n357#5,2:1941\n357#5,2:1946\n347#5,9:1967\n356#5:1987\n347#5,9:2006\n356#5:2026\n357#5,2:2028\n357#5,2:2033\n357#5,2:2037\n357#5,2:2041\n357#5,2:2045\n357#5,2:2055\n4206#6,6:1027\n4206#6,6:1469\n4206#6,6:1509\n4206#6,6:1545\n4206#6,6:1605\n4206#6,6:1655\n4206#6,6:1691\n4206#6,6:1724\n4206#6,6:1762\n4206#6,6:1808\n4206#6,6:1853\n4206#6,6:1892\n4206#6,6:1931\n4206#6,6:1979\n4206#6,6:2018\n57#7:1064\n61#7:1067\n57#7:1143\n61#7:1146\n57#7:1380\n61#7:1383\n57#7:2060\n61#7:2064\n60#8:1065\n70#8:1068\n53#8,3:1071\n53#8,3:1075\n53#8,3:1079\n53#8,3:1083\n53#8,3:1088\n60#8:1100\n70#8:1103\n53#8,3:1105\n60#8:1109\n70#8:1112\n53#8,3:1114\n60#8:1119\n70#8:1122\n53#8,3:1124\n60#8:1128\n70#8:1131\n53#8,3:1133\n60#8:1144\n70#8:1147\n53#8,3:1149\n60#8:1160\n70#8:1163\n60#8:1166\n70#8:1169\n53#8,3:1172\n53#8,3:1176\n60#8:1187\n70#8:1190\n53#8,3:1194\n53#8,3:1199\n53#8,3:1204\n60#8:1218\n70#8:1221\n60#8:1223\n70#8:1227\n60#8:1229\n70#8:1233\n60#8:1236\n70#8:1240\n60#8:1243\n70#8:1247\n70#8:1249\n70#8:1252\n60#8:1270\n70#8:1273\n60#8:1275\n70#8:1279\n60#8:1281\n70#8:1285\n60#8:1288\n70#8:1292\n60#8:1295\n70#8:1299\n70#8:1301\n70#8:1304\n60#8:1322\n70#8:1325\n53#8,3:1327\n60#8:1331\n70#8:1334\n53#8,3:1336\n70#8:1341\n70#8:1344\n60#8:1347\n70#8:1350\n53#8,3:1352\n60#8:1356\n70#8:1359\n53#8,3:1361\n60#8:1367\n70#8:1370\n53#8,3:1372\n60#8:1381\n70#8:1384\n53#8,3:1386\n60#8:1392\n70#8:1395\n53#8,3:1398\n53#8,3:1416\n53#8,3:1420\n53#8,3:1424\n53#8,3:1428\n60#8:2061\n70#8:2065\n53#8,3:2070\n53#8,3:2074\n53#8,3:2079\n22#9:1066\n22#9:1069\n22#9:1101\n22#9:1110\n22#9:1120\n22#9:1129\n22#9:1145\n22#9:1161\n22#9:1164\n22#9:1167\n22#9:1170\n22#9:1188\n22#9:1191\n22#9:1219\n22#9:1224\n22#9:1230\n22#9:1237\n22#9:1244\n22#9:1250\n22#9:1253\n22#9:1271\n22#9:1276\n22#9:1282\n22#9:1289\n22#9:1296\n22#9:1302\n22#9:1305\n22#9:1323\n22#9:1332\n22#9:1342\n22#9:1345\n22#9:1348\n22#9:1357\n22#9:1368\n22#9:1382\n22#9:1393\n22#9:1396\n22#9:2062\n22#9:2066\n30#10:1070\n30#10:1074\n30#10:1078\n30#10:1082\n30#10:1087\n30#10:1104\n30#10:1113\n30#10:1123\n30#10:1132\n30#10:1148\n30#10:1171\n30#10:1175\n30#10:1193\n30#10:1198\n30#10:1203\n30#10:1326\n30#10:1335\n30#10:1351\n30#10:1360\n30#10:1371\n30#10:1385\n30#10:1397\n30#10:1415\n30#10:1419\n30#10:1423\n30#10:1427\n30#10:2069\n123#11:1086\n113#11:1098\n118#11:1117\n118#11:1136\n113#11,6:1152\n113#11:1158\n113#11,6:1179\n113#11:1185\n118#11:1192\n118#11:1197\n118#11:1202\n113#11:1225\n118#11:1231\n113#11:1234\n118#11:1238\n113#11:1241\n113#11:1245\n113#11:1254\n113#11:1277\n118#11:1283\n113#11:1286\n118#11:1290\n113#11:1293\n113#11:1297\n113#11:1306\n118#11:1339\n118#11:1364\n113#11:1365\n118#11:1375\n113#11:1389\n113#11:1390\n113#11:1401\n113#11:1413\n113#11:1414\n113#11:1432\n113#11:1620\n113#11:1621\n113#11:1626\n113#11:1771\n113#11:1817\n113#11:1828\n113#11:1862\n113#11:1901\n113#11:1902\n113#11:1903\n113#11:1940\n113#11:1945\n113#11:1950\n113#11:1988\n113#11:1989\n113#11:2027\n113#11:2032\n113#11:2059\n113#11:2063\n113#11:2067\n113#11:2068\n118#11:2077\n1#12:1094\n65#13:1099\n69#13:1102\n65#13:1108\n69#13:1111\n65#13:1118\n69#13:1121\n65#13:1127\n69#13:1130\n65#13:1159\n69#13:1162\n65#13:1165\n69#13:1168\n65#13:1186\n69#13:1189\n65#13:1217\n69#13:1220\n65#13:1222\n69#13:1226\n65#13:1228\n69#13:1232\n65#13:1235\n69#13:1239\n65#13:1242\n69#13:1246\n69#13:1248\n69#13:1251\n65#13:1269\n69#13:1272\n65#13:1274\n69#13:1278\n65#13:1280\n69#13:1284\n65#13:1287\n69#13:1291\n65#13:1294\n69#13:1298\n69#13:1300\n69#13:1303\n65#13:1321\n69#13:1324\n65#13:1330\n69#13:1333\n69#13:1340\n69#13:1343\n65#13:1346\n69#13:1349\n65#13:1355\n69#13:1358\n65#13:1366\n69#13:1369\n65#13:1391\n69#13:1394\n138#14:1207\n249#14,9:1208\n259#14,4:1255\n138#14:1259\n249#14,9:1260\n259#14,4:1307\n138#14:1311\n249#14,9:1312\n259#14,4:1376\n85#15:1402\n85#15:1403\n85#15:1404\n85#15:1405\n85#15:1406\n113#15,2:1407\n85#15:1409\n85#15:1410\n85#15:1411\n85#15:1412\n66#16:1431\n66#16:1433\n66#16:1434\n66#16:1435\n66#16:1436\n66#16:1437\n66#16:1438\n66#16:1439\n66#16:1440\n58#16:1478\n52#16:1479\n58#16:1480\n52#16:1481\n58#16:1574\n52#16:1575\n58#16:1576\n52#16:1577\n87#17:1664\n85#17,8:1665\n87#17:1780\n84#17,9:1781\n94#17:1827\n94#17:2044\n99#18,6:1700\n99#18:1733\n95#18,10:1734\n106#18:1775\n106#18:1779\n99#18,6:1829\n99#18:1863\n95#18,10:1864\n106#18:1949\n99#18:1951\n96#18,9:1952\n106#18:2036\n106#18:2040\n33#19:2073\n33#20:2078\n*S KotlinDebug\n*F\n+ 1 EchoScreensaver.kt\ndev/brahmkshatriya/echo/desktop/ui/screensaver/EchoScreensaverKt\n*L\n113#1:964,6\n114#1:970,6\n165#1:976,6\n166#1:982,6\n167#1:988,6\n169#1:994,6\n176#1:1036,6\n191#1:1042,6\n195#1:1048,6\n199#1:1054,6\n281#1:1091,3\n281#1:1095,3\n706#1:1137,6\n374#1:1554,6\n396#1:1564,6\n429#1:1614,6\n517#1:1818,6\n646#1:2049,6\n161#1:1000\n161#1:1001,8\n161#1:1063\n334#1:1441\n334#1:1442,9\n342#1:1482\n342#1:1483,8\n361#1:1518\n361#1:1519,8\n361#1:1563\n342#1:1573\n419#1:1578\n419#1:1579,8\n419#1:1625\n452#1:1627\n452#1:1628,9\n566#1:1904\n566#1:1905,8\n566#1:1944\n610#1:1990\n610#1:1991,9\n610#1:2031\n452#1:2048\n334#1:2058\n161#1:1009,6\n161#1:1024,3\n161#1:1033,2\n161#1:1062\n334#1:1451,6\n334#1:1466,3\n334#1:1475,2\n342#1:1491,6\n342#1:1506,3\n342#1:1515,2\n361#1:1527,6\n361#1:1542,3\n361#1:1551,2\n361#1:1562\n342#1:1572\n419#1:1587,6\n419#1:1602,3\n419#1:1611,2\n419#1:1624\n452#1:1637,6\n452#1:1652,3\n452#1:1661,2\n458#1:1673,6\n458#1:1688,3\n458#1:1697,2\n463#1:1706,6\n463#1:1721,3\n463#1:1730,2\n469#1:1744,6\n469#1:1759,3\n469#1:1768,2\n469#1:1774\n463#1:1778\n503#1:1790,6\n503#1:1805,3\n503#1:1814,2\n503#1:1826\n543#1:1835,6\n543#1:1850,3\n543#1:1859,2\n549#1:1874,6\n549#1:1889,3\n549#1:1898,2\n566#1:1913,6\n566#1:1928,3\n566#1:1937,2\n566#1:1943\n549#1:1948\n601#1:1961,6\n601#1:1976,3\n601#1:1985,2\n610#1:2000,6\n610#1:2015,3\n610#1:2024,2\n610#1:2030\n601#1:2035\n543#1:2039\n458#1:2043\n452#1:2047\n334#1:2057\n161#1:1015,9\n161#1:1035\n161#1:1060,2\n334#1:1457,9\n334#1:1477\n342#1:1497,9\n342#1:1517\n361#1:1533,9\n361#1:1553\n361#1:1560,2\n342#1:1570,2\n419#1:1593,9\n419#1:1613\n419#1:1622,2\n452#1:1643,9\n452#1:1663\n458#1:1679,9\n458#1:1699\n463#1:1712,9\n463#1:1732\n469#1:1750,9\n469#1:1770\n469#1:1772,2\n463#1:1776,2\n503#1:1796,9\n503#1:1816\n503#1:1824,2\n543#1:1841,9\n543#1:1861\n549#1:1880,9\n549#1:1900\n566#1:1919,9\n566#1:1939\n566#1:1941,2\n549#1:1946,2\n601#1:1967,9\n601#1:1987\n610#1:2006,9\n610#1:2026\n610#1:2028,2\n601#1:2033,2\n543#1:2037,2\n458#1:2041,2\n452#1:2045,2\n334#1:2055,2\n161#1:1027,6\n334#1:1469,6\n342#1:1509,6\n361#1:1545,6\n419#1:1605,6\n452#1:1655,6\n458#1:1691,6\n463#1:1724,6\n469#1:1762,6\n503#1:1808,6\n543#1:1853,6\n549#1:1892,6\n566#1:1931,6\n601#1:1979,6\n610#1:2018,6\n212#1:1064\n213#1:1067\n755#1:1143\n755#1:1146\n922#1:1380\n922#1:1383\n710#1:2060\n711#1:2064\n212#1:1065\n213#1:1068\n222#1:1071,3\n226#1:1075,3\n233#1:1079,3\n237#1:1083,3\n254#1:1088,3\n683#1:1100\n683#1:1103\n683#1:1105,3\n684#1:1109\n684#1:1112\n684#1:1114,3\n690#1:1119\n690#1:1122\n690#1:1124,3\n691#1:1128\n691#1:1131\n691#1:1133,3\n755#1:1144\n755#1:1147\n755#1:1149,3\n773#1:1160\n774#1:1163\n775#1:1166\n776#1:1169\n781#1:1172,3\n782#1:1176,3\n792#1:1187\n793#1:1190\n809#1:1194,3\n818#1:1199,3\n824#1:1204,3\n831#1:1218\n831#1:1221\n832#1:1223\n832#1:1227\n833#1:1229\n833#1:1233\n834#1:1236\n834#1:1240\n835#1:1243\n835#1:1247\n848#1:1249\n849#1:1252\n859#1:1270\n859#1:1273\n860#1:1275\n860#1:1279\n861#1:1281\n861#1:1285\n862#1:1288\n862#1:1292\n863#1:1295\n863#1:1299\n876#1:1301\n877#1:1304\n890#1:1322\n890#1:1325\n890#1:1327,3\n891#1:1331\n891#1:1334\n891#1:1336,3\n899#1:1341\n900#1:1344\n902#1:1347\n902#1:1350\n902#1:1352,3\n903#1:1356\n903#1:1359\n903#1:1361,3\n911#1:1367\n911#1:1370\n911#1:1372,3\n922#1:1381\n922#1:1384\n922#1:1386,3\n941#1:1392\n942#1:1395\n947#1:1398,3\n655#1:1416,3\n656#1:1420,3\n657#1:1424,3\n658#1:1428,3\n710#1:2061\n711#1:2065\n738#1:2070,3\n739#1:2074,3\n740#1:2079,3\n212#1:1066\n213#1:1069\n683#1:1101\n684#1:1110\n690#1:1120\n691#1:1129\n755#1:1145\n773#1:1161\n774#1:1164\n775#1:1167\n776#1:1170\n792#1:1188\n793#1:1191\n831#1:1219\n832#1:1224\n833#1:1230\n834#1:1237\n835#1:1244\n848#1:1250\n849#1:1253\n859#1:1271\n860#1:1276\n861#1:1282\n862#1:1289\n863#1:1296\n876#1:1302\n877#1:1305\n890#1:1323\n891#1:1332\n899#1:1342\n900#1:1345\n902#1:1348\n903#1:1357\n911#1:1368\n922#1:1382\n941#1:1393\n942#1:1396\n710#1:2062\n711#1:2066\n222#1:1070\n226#1:1074\n233#1:1078\n237#1:1082\n254#1:1087\n683#1:1104\n684#1:1113\n690#1:1123\n691#1:1132\n755#1:1148\n781#1:1171\n782#1:1175\n809#1:1193\n818#1:1198\n824#1:1203\n890#1:1326\n891#1:1335\n902#1:1351\n903#1:1360\n911#1:1371\n922#1:1385\n947#1:1397\n655#1:1415\n656#1:1419\n657#1:1423\n658#1:1427\n738#1:2069\n253#1:1086\n673#1:1098\n685#1:1117\n692#1:1136\n769#1:1152,6\n770#1:1158\n783#1:1179,6\n789#1:1185\n797#1:1192\n817#1:1197\n824#1:1202\n832#1:1225\n833#1:1231\n833#1:1234\n834#1:1238\n834#1:1241\n835#1:1245\n849#1:1254\n860#1:1277\n861#1:1283\n861#1:1286\n862#1:1290\n862#1:1293\n863#1:1297\n877#1:1306\n892#1:1339\n904#1:1364\n910#1:1365\n912#1:1375\n928#1:1389\n933#1:1390\n948#1:1401\n389#1:1413\n653#1:1414\n319#1:1432\n440#1:1620\n447#1:1621\n456#1:1626\n474#1:1771\n516#1:1817\n539#1:1828\n551#1:1862\n555#1:1901\n568#1:1902\n575#1:1903\n583#1:1940\n589#1:1945\n603#1:1950\n613#1:1988\n614#1:1989\n620#1:2027\n629#1:2032\n708#1:2059\n710#1:2063\n720#1:2067\n722#1:2068\n740#1:2077\n683#1:1099\n683#1:1102\n684#1:1108\n684#1:1111\n690#1:1118\n690#1:1121\n691#1:1127\n691#1:1130\n773#1:1159\n774#1:1162\n775#1:1165\n776#1:1168\n792#1:1186\n793#1:1189\n831#1:1217\n831#1:1220\n832#1:1222\n832#1:1226\n833#1:1228\n833#1:1232\n834#1:1235\n834#1:1239\n835#1:1242\n835#1:1246\n848#1:1248\n849#1:1251\n859#1:1269\n859#1:1272\n860#1:1274\n860#1:1278\n861#1:1280\n861#1:1284\n862#1:1287\n862#1:1291\n863#1:1294\n863#1:1298\n876#1:1300\n877#1:1303\n890#1:1321\n890#1:1324\n891#1:1330\n891#1:1333\n899#1:1340\n900#1:1343\n902#1:1346\n902#1:1349\n903#1:1355\n903#1:1358\n911#1:1366\n911#1:1369\n941#1:1391\n942#1:1394\n829#1:1207\n829#1:1208,9\n829#1:1255,4\n857#1:1259\n857#1:1260,9\n857#1:1307,4\n886#1:1311\n886#1:1312,9\n886#1:1376,4\n107#1:1402\n108#1:1403\n109#1:1404\n110#1:1405\n113#1:1406\n113#1:1407,2\n124#1:1409\n133#1:1410\n142#1:1411\n151#1:1412\n319#1:1431\n320#1:1433\n324#1:1434\n325#1:1435\n326#1:1436\n329#1:1437\n330#1:1438\n331#1:1439\n332#1:1440\n345#1:1478\n345#1:1479\n346#1:1480\n346#1:1481\n422#1:1574\n422#1:1575\n423#1:1576\n423#1:1577\n458#1:1664\n458#1:1665,8\n503#1:1780\n503#1:1781,9\n503#1:1827\n458#1:2044\n463#1:1700,6\n469#1:1733\n469#1:1734,10\n469#1:1775\n463#1:1779\n543#1:1829,6\n549#1:1863\n549#1:1864,10\n549#1:1949\n601#1:1951\n601#1:1952,9\n601#1:2036\n543#1:2040\n739#1:2073\n740#1:2078\n*E\n"})
public final class EchoScreensaverKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void EchoScreensaver(@NotNull PlayerViewModel playerViewModel, @NotNull Function0<Unit> onWakeUp, @Nullable Modifier modifier, @Nullable Composer $composer, int $changed, int n) {
        block34: {
            Intrinsics.checkNotNullParameter((Object)playerViewModel, (String)"playerViewModel");
            Intrinsics.checkNotNullParameter(onWakeUp, (String)"onWakeUp");
            $composer = $composer.startRestartGroup(1810651311);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(EchoScreensaver)P(2,1)106@4785L16,107@4849L16,108@4915L16,109@4981L16,112@5097L48,113@5171L109,113@5150L130,121@5394L28,123@5464L246,132@5758L240,141@6044L233,150@6320L239,164@6794L14,165@6861L14,166@6929L14,168@7004L39,160@6640L1563:EchoScreensaver.kt#rzt5gx");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= (($changed & 8) == 0 ? $composer.changed((Object)playerViewModel) : $composer.changedInstance((Object)playerViewModel)) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onWakeUp) ? 32 : 16;
            }
            if ((n & 4) != 0) {
                $dirty |= 0x180;
            } else if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 256 : 128;
            }
            if ($composer.shouldExecute(($dirty & 0x93) != 146, $dirty & 1)) {
                Object object;
                Object object2;
                Function0 function0;
                Object object3;
                Function0 function02;
                Track track2;
                boolean bl;
                long l;
                long l2;
                float f;
                float f2;
                float f3;
                float f4;
                Object object4;
                Function1 value$iv;
                Object object5;
                void $this$cache$iv;
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void $changed$iv;
                void modifier$iv;
                void contentAlignment$iv;
                void $composer$iv;
                Object object6;
                Object object7;
                Object object8;
                Object object9;
                Function2 value$iv2;
                Function2 function2;
                int n2;
                PointerEventPass pointerEventPass;
                Composer $this$cache$iv2;
                Object object10;
                Unit unit;
                Object object11;
                Composer $this$cache$iv3;
                if ((n & 4) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1810651311, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.EchoScreensaver (EchoScreensaver.kt:105)");
                }
                State currentTrack$delegate = SnapshotStateKt.collectAsState(playerViewModel.getCurrentTrack(), null, (Composer)$composer, (int)0, (int)1);
                State isPlaying$delegate = SnapshotStateKt.collectAsState(playerViewModel.isPlaying(), null, (Composer)$composer, (int)0, (int)1);
                State positionMs$delegate = SnapshotStateKt.collectAsState(playerViewModel.getPositionMs(), null, (Composer)$composer, (int)0, (int)1);
                State durationMs$delegate = SnapshotStateKt.collectAsState(playerViewModel.getDurationMs(), null, (Composer)$composer, (int)0, (int)1);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574172319, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv3.rememberedValue();
                boolean bl2 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl3 = false;
                    MutableState value$iv3 = SnapshotStateKt.mutableStateOf$default((Object)LocalDateTime.now(), null, (int)2, null);
                    $this$cache$iv3.updateRememberedValue((Object)value$iv3);
                    object11 = value$iv3;
                } else {
                    object11 = it$iv;
                }
                MutableState mutableState = (MutableState)object11;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableState currentTime$delegate = mutableState;
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574174748, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv3 = $composer;
                invalid$iv = false;
                $i$f$cache = false;
                it$iv = $this$cache$iv3.rememberedValue();
                bl2 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    unit = unit2;
                    boolean bl4 = false;
                    unit2 = unit;
                    Function2 value$iv4 = (Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>((MutableState<LocalDateTime>)currentTime$delegate, null){
                        int label;
                        final /* synthetic */ MutableState<LocalDateTime> $currentTime$delegate;
                        {
                            this.$currentTime$delegate = $currentTime$delegate;
                            super(2, $completion);
                        }

                        /*
                         * Unable to fully structure code
                         */
                        public final Object invokeSuspend(Object $result) {
                            var2_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0: {
                                    ResultKt.throwOnFailure((Object)$result);
lbl6:
                                    // 2 sources

                                    while (true) {
                                        EchoScreensaverKt.access$EchoScreensaver$lambda$6(this.$currentTime$delegate, LocalDateTime.now());
                                        this.label = 1;
                                        v0 = DelayKt.delay((long)100L, (Continuation)((Continuation)this));
                                        if (v0 != var2_2) continue;
                                        return var2_2;
                                    }
                                }
                                case 1: {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v0 = $result;
                                    ** continue;
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
                    $this$cache$iv3.updateRememberedValue((Object)value$iv4);
                    object10 = value$iv4;
                } else {
                    object10 = it$iv;
                }
                mutableState = (Function2)object10;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                EffectsKt.LaunchedEffect((Object)unit2, (Function2)mutableState, (Composer)$composer, (int)6);
                InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, (Composer)$composer, (int)0, (int)1);
                State wavePhase$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)infiniteTransition, (float)0.0f, (float)((float)Math.PI * 2), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)6000, (int)0, (Easing)EasingKt.getLinearEasing(), (int)2, null)), (RepeatMode)RepeatMode.Restart, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State visualizerPulse$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)infiniteTransition, (float)0.35f, (float)1.0f, (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)1100, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x1B0 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State vinylRotation$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)infiniteTransition, (float)0.0f, (float)360.0f, (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)18000, (int)0, (Easing)EasingKt.getLinearEasing(), (int)2, null)), (RepeatMode)RepeatMode.Restart, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x1B0 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State glintPhase$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)infiniteTransition, (float)0.2f, (float)1.0f, (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)1800, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x1B0 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                Modifier modifier2 = BackgroundKt.background-bw27NRU$default((Modifier)SizeKt.fillMaxSize$default((Modifier)modifier, (float)0.0f, (int)1, null), (long)ColorKt.Color((long)4278584330L), null, (int)2, null);
                int n3 = PointerEventType.Companion.getMove-7fucELk();
                PointerEventPass pointerEventPass2 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574226589, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                Composer bl4 = $composer;
                boolean invalid$iv2 = ($dirty & 0x70) == 32;
                boolean $i$f$cache2 = false;
                Object it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    pointerEventPass = pointerEventPass2;
                    n2 = n3;
                    unit = modifier2;
                    boolean bl5 = false;
                    function2 = (arg_0, arg_1) -> EchoScreensaverKt.EchoScreensaver$lambda$13$lambda$12(onWakeUp, arg_0, arg_1);
                    modifier2 = unit;
                    n3 = n2;
                    pointerEventPass2 = pointerEventPass;
                    value$iv2 = function2;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object9 = value$iv2;
                } else {
                    object9 = it$iv2;
                }
                Function2 $i$a$-let-ComposerKt$cache$1$iv2 = (Function2)object9;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                Modifier modifier3 = SuspendingPointerInputFilter_skikoKt.onPointerEvent-88W8MhQ$default((Modifier)modifier2, (int)n3, pointerEventPass2, (Function2)$i$a$-let-ComposerKt$cache$1$iv2, (int)2, null);
                int n4 = PointerEventType.Companion.getPress-7fucELk();
                PointerEventPass pointerEventPass3 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574228733, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv2 = $composer;
                invalid$iv2 = ($dirty & 0x70) == 32;
                $i$f$cache2 = false;
                it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    pointerEventPass = pointerEventPass3;
                    n2 = n4;
                    unit = modifier3;
                    boolean bl6 = false;
                    function2 = (arg_0, arg_1) -> EchoScreensaverKt.EchoScreensaver$lambda$15$lambda$14(onWakeUp, arg_0, arg_1);
                    modifier3 = unit;
                    n4 = n2;
                    pointerEventPass3 = pointerEventPass;
                    value$iv2 = function2;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object8 = value$iv2;
                } else {
                    object8 = it$iv2;
                }
                $i$a$-let-ComposerKt$cache$1$iv2 = (Function2)object8;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                Modifier modifier4 = SuspendingPointerInputFilter_skikoKt.onPointerEvent-88W8MhQ$default((Modifier)modifier3, (int)n4, pointerEventPass3, (Function2)$i$a$-let-ComposerKt$cache$1$iv2, (int)2, null);
                int n5 = PointerEventType.Companion.getScroll-7fucELk();
                PointerEventPass pointerEventPass4 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574230909, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv2 = $composer;
                invalid$iv2 = ($dirty & 0x70) == 32;
                $i$f$cache2 = false;
                it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    pointerEventPass = pointerEventPass4;
                    n2 = n5;
                    unit = modifier4;
                    boolean bl7 = false;
                    function2 = (arg_0, arg_1) -> EchoScreensaverKt.EchoScreensaver$lambda$17$lambda$16(onWakeUp, arg_0, arg_1);
                    modifier4 = unit;
                    n5 = n2;
                    pointerEventPass4 = pointerEventPass;
                    value$iv2 = function2;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object7 = value$iv2;
                } else {
                    object7 = it$iv2;
                }
                $i$a$-let-ComposerKt$cache$1$iv2 = (Function2)object7;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                Modifier modifier5 = SuspendingPointerInputFilter_skikoKt.onPointerEvent-88W8MhQ$default((Modifier)modifier4, (int)n5, pointerEventPass4, (Function2)$i$a$-let-ComposerKt$cache$1$iv2, (int)2, null);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)574233334, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv2 = $composer;
                invalid$iv2 = false;
                $i$f$cache2 = false;
                it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    unit = modifier5;
                    boolean bl8 = false;
                    modifier5 = unit;
                    MutableInteractionSource value$iv5 = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv2.updateRememberedValue((Object)value$iv5);
                    object6 = value$iv5;
                } else {
                    object6 = it$iv2;
                }
                $i$a$-let-ComposerKt$cache$1$iv2 = (MutableInteractionSource)object6;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                $i$a$-let-ComposerKt$cache$1$iv2 = ClickableKt.clickable-O2vRcR0$default((Modifier)modifier5, (MutableInteractionSource)$i$a$-let-ComposerKt$cache$1$iv2, null, (boolean)false, null, null, onWakeUp, (int)28, null);
                $this$cache$iv2 = Alignment.Companion.getCenter();
                Composer $i$f$cache22 = $composer;
                int it$iv22 = 48;
                boolean $i$f$Box = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv);
                value$iv2 = modifier$iv;
                int n6 = 0x70 & $changed$iv << 3;
                boolean $i$f$Layout = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                Function0 function03 = ComposeUiNode.Companion.getConstructor();
                int n7 = 6 | 0x380 & $changed$iv$iv << 6;
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
                boolean bl9 = false;
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
                boolean bl10 = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
                boolean bl11 = false;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                    $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n8 = 0xE & $changed$iv$iv$iv >> 6;
                void $composer$iv2 = $composer$iv;
                boolean bl12 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n9 = 6 | 0x70 & $changed$iv >> 6;
                void var43_58 = $composer$iv2;
                BoxScope $this$EchoScreensaver_u24lambda_u2427 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl13 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1330629310, (String)"C175@7319L61,175@7277L103,190@7871L92,194@7990L89,198@8102L85,180@7451L746:EchoScreensaver.kt#rzt5gx");
                Modifier modifier6 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-874207034, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                void var46_61 = $composer2;
                boolean invalid$iv3 = $composer2.changed((Object)wavePhase$delegate);
                boolean $i$f$cache3 = false;
                Object it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    object5 = modifier6;
                    boolean bl14 = false;
                    modifier6 = object5;
                    value$iv = arg_0 -> EchoScreensaverKt.EchoScreensaver$lambda$27$lambda$20$lambda$19(wavePhase$delegate, arg_0);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object4 = value$iv;
                } else {
                    object4 = it$iv3;
                }
                Function1 function1 = (Function1)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                CanvasKt.Canvas((Modifier)modifier6, (Function1)function1, (Composer)$composer2, (int)6);
                LocalDateTime localDateTime = EchoScreensaverKt.EchoScreensaver$lambda$5((MutableState<LocalDateTime>)currentTime$delegate);
                LocalDateTime localDateTime2 = localDateTime;
                Intrinsics.checkNotNullExpressionValue((Object)localDateTime, (String)"EchoScreensaver$lambda$5(...)");
                Track track3 = EchoScreensaverKt.EchoScreensaver$lambda$0((State<Track>)currentTrack$delegate);
                boolean bl15 = EchoScreensaverKt.EchoScreensaver$lambda$1((State<Boolean>)isPlaying$delegate);
                long l3 = EchoScreensaverKt.EchoScreensaver$lambda$2((State<Long>)positionMs$delegate);
                long l4 = EchoScreensaverKt.EchoScreensaver$lambda$3((State<Long>)durationMs$delegate);
                float f5 = EchoScreensaverKt.EchoScreensaver$lambda$8((State<Float>)wavePhase$delegate);
                float f6 = EchoScreensaverKt.EchoScreensaver$lambda$9((State<Float>)visualizerPulse$delegate);
                float f7 = EchoScreensaverKt.EchoScreensaver$lambda$1((State<Boolean>)isPlaying$delegate) ? EchoScreensaverKt.EchoScreensaver$lambda$10((State<Float>)vinylRotation$delegate) : 0.0f;
                float f8 = EchoScreensaverKt.EchoScreensaver$lambda$11((State<Float>)glintPhase$delegate);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-874189339, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv3 = (($dirty & 0xE) == 4 || ($dirty & 8) != 0 && $composer.changedInstance((Object)playerViewModel)) | ($dirty & 0x70) == 32;
                $i$f$cache3 = false;
                it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    f4 = f8;
                    f3 = f7;
                    f2 = f6;
                    f = f5;
                    l2 = l4;
                    l = l3;
                    bl = bl15;
                    track2 = track3;
                    object5 = localDateTime2;
                    boolean bl16 = false;
                    function02 = () -> EchoScreensaverKt.EchoScreensaver$lambda$27$lambda$22$lambda$21(playerViewModel, onWakeUp);
                    localDateTime2 = object5;
                    track3 = track2;
                    bl15 = bl;
                    l3 = l;
                    l4 = l2;
                    f5 = f;
                    f6 = f2;
                    f7 = f3;
                    f8 = f4;
                    value$iv = function02;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv3;
                }
                function1 = (Function0)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function1 function12 = function1;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-874185534, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv3 = (($dirty & 0xE) == 4 || ($dirty & 8) != 0 && $composer.changedInstance((Object)playerViewModel)) | ($dirty & 0x70) == 32;
                $i$f$cache3 = false;
                it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    function02 = function12;
                    f4 = f8;
                    f3 = f7;
                    f2 = f6;
                    f = f5;
                    l2 = l4;
                    l = l3;
                    bl = bl15;
                    track2 = track3;
                    object5 = localDateTime2;
                    boolean bl17 = false;
                    function0 = () -> EchoScreensaverKt.EchoScreensaver$lambda$27$lambda$24$lambda$23(playerViewModel, onWakeUp);
                    localDateTime2 = object5;
                    track3 = track2;
                    bl15 = bl;
                    l3 = l;
                    l4 = l2;
                    f5 = f;
                    f6 = f2;
                    f7 = f3;
                    f8 = f4;
                    function12 = function02;
                    value$iv = function0;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv3;
                }
                function1 = (Function0)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                Function1 function13 = function1;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-874181954, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                $this$cache$iv = $composer2;
                invalid$iv3 = (($dirty & 0xE) == 4 || ($dirty & 8) != 0 && $composer.changedInstance((Object)playerViewModel)) | ($dirty & 0x70) == 32;
                $i$f$cache3 = false;
                it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    function0 = function13;
                    function02 = function12;
                    f4 = f8;
                    f3 = f7;
                    f2 = f6;
                    f = f5;
                    l2 = l4;
                    l = l3;
                    bl = bl15;
                    track2 = track3;
                    object5 = localDateTime2;
                    boolean bl18 = false;
                    Function0 function04 = () -> EchoScreensaverKt.EchoScreensaver$lambda$27$lambda$26$lambda$25(playerViewModel, onWakeUp);
                    localDateTime2 = object5;
                    track3 = track2;
                    bl15 = bl;
                    l3 = l;
                    l4 = l2;
                    f5 = f;
                    f6 = f2;
                    f7 = f3;
                    f8 = f4;
                    function12 = function02;
                    function13 = function0;
                    value$iv = function04;
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv3;
                }
                function1 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                EchoScreensaverKt.GothicButterflyBannerCapsule(localDateTime2, track3, bl15, l3, l4, f5, f6, f7, f8, (Function0<Unit>)function12, (Function0<Unit>)function13, (Function0<Unit>)function1, (Composer)$composer2, 0, 0);
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
            if (scopeUpdateScope == null) break block34;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoScreensaverKt.EchoScreensaver$lambda$28(playerViewModel, onWakeUp, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final void drawGothicAtmosphere-12SF9DM(DrawScope $this$drawGothicAtmosphere_u2d12SF9DM, long canvasSize, float phase) {
        float x$iv;
        long arg0$iv = canvasSize;
        boolean bl = false;
        long value$iv$iv = arg0$iv;
        boolean $i$f$unpackFloat1 = false;
        int bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        boolean $i$f$floatFromBits = false;
        float w = Float.intBitsToFloat(bits$iv$iv$iv);
        long arg0$iv322 = canvasSize;
        boolean bl2 = false;
        long value$iv$iv2 = arg0$iv322;
        boolean $i$f$unpackFloat2 = false;
        int bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        boolean $i$f$floatFromBits2 = false;
        float h = Float.intBitsToFloat(bits$iv$iv$iv2);
        DrawScope.drawRect-n-J9OG0$default((DrawScope)$this$drawGothicAtmosphere_u2d12SF9DM, (long)ColorKt.Color((long)4278584330L), (long)0L, (long)0L, (float)0.0f, null, null, (int)0, (int)126, null);
        Object[] arg0$iv322 = new Color[]{Color.box-impl((long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4292441862L), (float)0.16f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null)), Color.box-impl((long)Color.Companion.getTransparent-0d7_KjU())};
        float arg0$iv322 = w * 0.5f;
        float y$iv = h * 0.5f;
        boolean $i$f$Offset = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        Brush brush = Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])arg0$iv322), (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)(w * 0.45f), (int)0, (int)8, null);
        x$iv = w * 0.5f;
        y$iv = h * 0.5f;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        DrawScope.drawCircle-V9BoPsw$default((DrawScope)$this$drawGothicAtmosphere_u2d12SF9DM, (Brush)brush, (float)(w * 0.45f), (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)0.0f, null, null, (int)0, (int)120, null);
        Object[] x$iv32 = new Color[]{Color.box-impl((long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294286859L), (float)0.18f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null)), Color.box-impl((long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4283964551L), (float)0.12f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null)), Color.box-impl((long)Color.Companion.getTransparent-0d7_KjU())};
        float x$iv32 = w * 0.3f;
        y$iv = h * 0.5f;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv32);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        Brush brush2 = Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])x$iv32), (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)(w * 0.28f), (int)0, (int)8, null);
        x$iv32 = w * 0.3f;
        y$iv = h * 0.5f;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv32);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        DrawScope.drawCircle-V9BoPsw$default((DrawScope)$this$drawGothicAtmosphere_u2d12SF9DM, (Brush)brush2, (float)(w * 0.28f), (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)0.0f, null, null, (int)0, (int)120, null);
        for (int i = 0; i < 36; ++i) {
            void x$iv2;
            float seed = (float)i * 43.17f;
            float relX = seed * 17.3f % (float)1000 / 1000.0f;
            float relY = (seed * 31.7f + phase * 120.0f) % (float)1000 / 1000.0f;
            float px = w * relX;
            float py = h * (1.0f - relY);
            float particleRadius = 1.0f + (float)(i % 3) * 1.2f;
            float particleAlpha = RangesKt.coerceIn((float)(0.15f + 0.35f * (float)Math.sin(phase * 2.0f + seed)), (float)0.05f, (float)0.55f);
            float $this$dp$iv = particleRadius;
            boolean $i$f$getDp = false;
            float f = $this$drawGothicAtmosphere_u2d12SF9DM.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
            $this$dp$iv = px;
            float y$iv2 = py;
            boolean $i$f$Offset2 = false;
            boolean $i$f$packFloats2 = false;
            long v1$iv$iv2 = Float.floatToRawIntBits((float)x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawGothicAtmosphere_u2d12SF9DM, (long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294956367L), (float)particleAlpha, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)f, (long)Offset.constructor-impl((long)(v1$iv$iv2 << 32 | v2$iv$iv2 & 0xFFFFFFFFL)), (float)0.0f, null, null, (int)0, (int)120, null);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void GothicButterflyBannerCapsule(LocalDateTime currentTime, Track currentTrack, boolean isPlaying2, long positionMs, long durationMs, float wavePhase, float pulse, float vinylRotation, float glintPhase, Function0<Unit> onPlayPause, Function0<Unit> onPrevious, Function0<Unit> onNext, Composer $composer, int $changed, int $changed1) {
        block43: {
            $composer = $composer.startRestartGroup(425851896);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(GothicButterflyBannerCapsule)P(!2,4,8!1,11,9,10!1,6,7)280@10778L1982,316@12879L16800,313@12766L16913:EchoScreensaver.kt#rzt5gx");
            int $dirty = $changed;
            int $dirty1 = $changed1;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)currentTime) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance((Object)currentTrack) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(isPlaying2) ? 256 : 128;
            }
            if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed(positionMs) ? 2048 : 1024;
            }
            if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changed(durationMs) ? 16384 : 8192;
            }
            if (($changed & 0x30000) == 0) {
                $dirty |= $composer.changed(wavePhase) ? 131072 : 65536;
            }
            if (($changed & 0x180000) == 0) {
                $dirty |= $composer.changed(pulse) ? 0x100000 : 524288;
            }
            if (($changed & 0xC00000) == 0) {
                $dirty |= $composer.changed(vinylRotation) ? 0x800000 : 0x400000;
            }
            if (($changed & 0x6000000) == 0) {
                $dirty |= $composer.changed(glintPhase) ? 0x4000000 : 0x2000000;
            }
            if (($changed & 0x30000000) == 0) {
                $dirty |= $composer.changedInstance(onPlayPause) ? 0x20000000 : 0x10000000;
            }
            if (($changed1 & 6) == 0) {
                $dirty1 |= $composer.changedInstance(onPrevious) ? 4 : 2;
            }
            if (($changed1 & 0x30) == 0) {
                $dirty1 |= $composer.changedInstance(onNext) ? 32 : 16;
            }
            if ($composer.shouldExecute(($dirty & 0x12492493) != 306783378 || ($dirty1 & 0x13) != 18, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)425851896, (int)$dirty, (int)$dirty1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.GothicButterflyBannerCapsule (EchoScreensaver.kt:278)");
                }
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1221795990, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object object2;
                    boolean bl2 = false;
                    try {
                        ImageBitmap imageBitmap;
                        Object buffered;
                        InputStream stream;
                        Serializable serializable;
                        Object object3;
                        boolean bl3 = false;
                        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("images/gothic_screensaver_frame.png");
                        if (inputStream == null) {
                            object3 = new File("src/desktopMain/resources/images/gothic_screensaver_frame.png");
                            File it = object3;
                            boolean bl4 = false;
                            serializable = it.exists() ? object3 : null;
                            FileInputStream fileInputStream = serializable != null ? new FileInputStream((File)serializable) : null;
                            if (fileInputStream != null) {
                                inputStream = fileInputStream;
                            } else {
                                File it2 = it = new File("desktopApp/src/desktopMain/resources/images/gothic_screensaver_frame.png");
                                boolean bl5 = false;
                                object3 = it2.exists() ? it : null;
                                FileInputStream fileInputStream2 = object3 != null ? new FileInputStream((File)object3) : null;
                                if (fileInputStream2 != null) {
                                    inputStream = fileInputStream2;
                                } else {
                                    File it3 = it2 = new File("desktopApp/build/processedResources/desktop/main/images/gothic_screensaver_frame.png");
                                    boolean bl6 = false;
                                    it = it3.exists() ? it2 : null;
                                    FileInputStream fileInputStream3 = it != null ? new FileInputStream(it) : null;
                                    if (fileInputStream3 != null) {
                                        inputStream = fileInputStream3;
                                    } else {
                                        it3 = it2 = new File("images/gothic_screensaver_frame.png");
                                        boolean bl7 = false;
                                        it = it3.exists() ? it2 : null;
                                        inputStream = it != null ? new FileInputStream(it) : null;
                                    }
                                }
                            }
                        }
                        InputStream inputStream2 = stream = inputStream;
                        if (inputStream2 != null) {
                            Closeable closeable = inputStream2;
                            serializable = null;
                            try {
                                InputStream it = (InputStream)closeable;
                                boolean bl8 = false;
                                object3 = ImageIO.read(it);
                                v5 = object3;
                            }
                            catch (Throwable throwable) {
                                serializable = throwable;
                                throw throwable;
                            }
                            finally {
                                CloseableKt.closeFinally((Closeable)closeable, (Throwable)serializable);
                            }
                        } else {
                            v5 = buffered = null;
                        }
                        if (buffered != null) {
                            int n;
                            int cx = 267;
                            int cy = 209;
                            double maxRadius = 91.0;
                            int y = RangesKt.coerceAtLeast((int)(cy - 94), (int)0);
                            if (y <= (n = RangesKt.coerceAtMost((int)(cy + 94), (int)(((BufferedImage)buffered).getHeight() - 1)))) {
                                while (true) {
                                    int n2;
                                    int x;
                                    if ((x = RangesKt.coerceAtLeast((int)(cx - 94), (int)0)) <= (n2 = RangesKt.coerceAtMost((int)(cx + 94), (int)(((BufferedImage)buffered).getWidth() - 1)))) {
                                        while (true) {
                                            double dist;
                                            if ((dist = Math.hypot(x - cx, y - cy)) < maxRadius - 1.5) {
                                                ((BufferedImage)buffered).setRGB(x, y, 0);
                                            } else if (dist <= maxRadius) {
                                                double factor = (dist - (maxRadius - 1.5)) / 1.5;
                                                int origRgb = ((BufferedImage)buffered).getRGB(x, y);
                                                int origA = origRgb >>> 24 & 0xFF;
                                                int newA = (int)((double)origA * factor);
                                                ((BufferedImage)buffered).setRGB(x, y, newA << 24 | origRgb & 0xFFFFFF);
                                            }
                                            if (x == n2) break;
                                            ++x;
                                        }
                                    }
                                    if (y == n) break;
                                    ++y;
                                }
                            }
                            imageBitmap = DesktopImageConverters_desktopKt.toComposeImageBitmap((BufferedImage)buffered);
                        } else {
                            imageBitmap = null;
                        }
                        object2 = Result.constructor-impl(imageBitmap);
                    }
                    catch (Throwable throwable) {
                        object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                    ImageBitmap value$iv = (ImageBitmap)(Result.isFailure-impl((Object)object2) ? null : object2);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                ImageBitmap imageBitmap = (ImageBitmap)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                ImageBitmap frameBitmap = imageBitmap;
                BoxWithConstraintsKt.BoxWithConstraints((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (Alignment)Alignment.Companion.getCenter(), (boolean)false, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)567466210, (boolean)true, (arg_0, arg_1, arg_2) -> EchoScreensaverKt.GothicButterflyBannerCapsule$lambda$60(frameBitmap, glintPhase, currentTrack, vinylRotation, currentTime, isPlaying2, pulse, wavePhase, onPrevious, onPlayPause, onNext, positionMs, durationMs, arg_0, arg_1, arg_2), (Composer)$composer, (int)54)), (Composer)$composer, (int)3126, (int)4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block43;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoScreensaverKt.GothicButterflyBannerCapsule$lambda$61(currentTime, currentTrack, isPlaying2, positionMs, durationMs, wavePhase, pulse, vinylRotation, glintPhase, onPlayPause, onPrevious, onNext, $changed, $changed1, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final void drawStarGlint-d-4ec7I(DrawScope $this$drawStarGlint_u2dd_u2d4ec7I, long center, float alpha) {
        void x$iv;
        int $this$dp$iv = 7;
        boolean $i$f$getDp = false;
        float glintSize = $this$drawStarGlint_u2dd_u2d4ec7I.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
        long starColor = Color.copy-wmQWz5c$default((long)ColorKt.Color((long)0xFFFFFBEBL), (float)alpha, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
        long glowColor = Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294286859L), (float)(alpha * 0.4f), (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
        DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawStarGlint_u2dd_u2d4ec7I, (long)glowColor, (float)(glintSize * 1.4f), (long)center, (float)0.0f, null, null, (int)0, (int)120, null);
        long arg0$iv22 = center;
        boolean bl = false;
        long value$iv$iv = arg0$iv22;
        boolean $i$f$unpackFloat1 = false;
        int bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        boolean $i$f$floatFromBits = false;
        float arg0$iv22 = Float.intBitsToFloat(bits$iv$iv$iv);
        long arg0$iv = center;
        boolean bl2 = false;
        long value$iv$iv2 = arg0$iv;
        boolean $i$f$unpackFloat2 = false;
        int bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        boolean $i$f$floatFromBits2 = false;
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) - glintSize;
        boolean $i$f$Offset = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits((float)x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long l = Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
        long arg0$iv32 = center;
        bl = false;
        value$iv$iv = arg0$iv32;
        $i$f$unpackFloat1 = false;
        bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        $i$f$floatFromBits = false;
        float arg0$iv32 = Float.intBitsToFloat(bits$iv$iv$iv);
        arg0$iv = center;
        $i$f$getY-impl = false;
        value$iv$iv2 = arg0$iv;
        $i$f$unpackFloat2 = false;
        bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        $i$f$floatFromBits2 = false;
        y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) + glintSize;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits((float)x$iv);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        double $this$dp$iv2 = 1.2;
        boolean $i$f$getDp2 = false;
        DrawScope.drawLine-NGM6Ib0$default((DrawScope)$this$drawStarGlint_u2dd_u2d4ec7I, (long)starColor, (long)l, (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)$this$drawStarGlint_u2dd_u2d4ec7I.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv2))), (int)0, null, (float)0.0f, null, (int)0, (int)496, null);
        long arg0$iv42 = center;
        bl = false;
        value$iv$iv = arg0$iv42;
        $i$f$unpackFloat1 = false;
        bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        $i$f$floatFromBits = false;
        float arg0$iv42 = Float.intBitsToFloat(bits$iv$iv$iv) - glintSize;
        arg0$iv5 = center;
        $i$f$getY-impl = false;
        value$iv$iv2 = arg0$iv5;
        $i$f$unpackFloat2 = false;
        bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        $i$f$floatFromBits2 = false;
        float arg0$iv5 = Float.intBitsToFloat(bits$iv$iv$iv2);
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits((float)x$iv);
        v2$iv$iv = Float.floatToRawIntBits((float)y$iv);
        long l2 = Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
        long arg0$iv62 = center;
        bl = false;
        value$iv$iv = arg0$iv62;
        $i$f$unpackFloat1 = false;
        bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        $i$f$floatFromBits = false;
        float arg0$iv62 = Float.intBitsToFloat(bits$iv$iv$iv) + glintSize;
        arg0$iv7 = center;
        $i$f$getY-impl = false;
        value$iv$iv2 = arg0$iv7;
        $i$f$unpackFloat2 = false;
        bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        $i$f$floatFromBits2 = false;
        float arg0$iv7 = Float.intBitsToFloat(bits$iv$iv$iv2);
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits((float)x$iv);
        v2$iv$iv = Float.floatToRawIntBits((float)y$iv);
        $this$dp$iv = 1.2;
        $i$f$getDp2 = false;
        DrawScope.drawLine-NGM6Ib0$default((DrawScope)$this$drawStarGlint_u2dd_u2d4ec7I, (long)starColor, (long)l2, (long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)$this$drawStarGlint_u2dd_u2d4ec7I.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), (int)0, null, (float)0.0f, null, (int)0, (int)496, null);
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final void GothicSpectrumRow(boolean isPlaying2, float pulse, float phase, Modifier modifier, Composer $composer, int $changed, int n) {
        block13: {
            $composer = $composer.startRestartGroup(-484043865);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(GothicSpectrumRow)P(!1,3,2)705@30780L1463,705@30752L1491:EchoScreensaver.kt#rzt5gx");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(isPlaying2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed(pulse) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(phase) ? 256 : 128;
            }
            if ((n & 8) != 0) {
                $dirty |= 0xC00;
            } else if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 2048 : 1024;
            }
            if ($composer.shouldExecute(($dirty & 0x493) != 1170, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                if ((n & 8) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-484043865, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.GothicSpectrumRow (EchoScreensaver.kt:704)");
                }
                Modifier modifier2 = modifier;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)-1309679298, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv = ($dirty & 0x380) == 256 | ($dirty & 0xE) == 4 | ($dirty & 0x70) == 32;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                boolean bl = false;
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Modifier modifier3 = modifier2;
                    boolean bl2 = false;
                    modifier2 = modifier3;
                    Function1 value$iv = arg_0 -> EchoScreensaverKt.GothicSpectrumRow$lambda$63$lambda$62(phase, isPlaying2, pulse, arg_0);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function1 function1 = (Function1)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                CanvasKt.Canvas((Modifier)modifier2, (Function1)function1, (Composer)$composer, (int)(0xE & $dirty >> 9));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block13;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> EchoScreensaverKt.GothicSpectrumRow$lambda$64(isPlaying2, pulse, phase, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static final void drawGothicAnalogClock-x_KDEd0(DrawScope $this$drawGothicAnalogClock_u2dx_KDEd0, long size, LocalDateTime time, boolean hasTrackCover) {
        void $this$rotate_u2dRg1IO4c$iv;
        boolean $i$f$getDp;
        boolean $i$f$unpackFloat2;
        boolean $i$f$floatFromBits;
        int bits$iv$iv$iv;
        boolean $i$f$unpackFloat1;
        long value$iv$iv;
        void $this$rotate_u2dRg1IO4c$iv2;
        long value$iv$iv2;
        boolean $i$f$floatFromBits2;
        void $this$rotate_u2dRg1IO4c$iv3;
        void x$iv;
        void x$iv2;
        float r = Size.getMinDimension-impl((long)size) / 2.0f;
        long arg0$iv22 = size;
        boolean bl = false;
        long value$iv$iv3 = arg0$iv22;
        boolean $i$f$unpackFloat12 = false;
        int bits$iv$iv$iv2 = (int)(value$iv$iv3 >> 32);
        boolean $i$f$floatFromBits3 = false;
        float arg0$iv22 = Float.intBitsToFloat(bits$iv$iv$iv2) / 2.0f;
        long arg0$iv = size;
        boolean bl2 = false;
        long value$iv$iv4 = arg0$iv;
        boolean $i$f$unpackFloat22 = false;
        int bits$iv$iv$iv3 = (int)(value$iv$iv4 & 0xFFFFFFFFL);
        boolean $i$f$floatFromBits4 = false;
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv3) / 2.0f;
        boolean $i$f$Offset = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits((float)x$iv2);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long center = Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
        float seconds = (float)time.getSecond() + (float)time.getNano() / 1.0E9f;
        float minutes = (float)time.getMinute() + seconds / 60.0f;
        float hours = (float)(time.getHour() % 12) + minutes / 60.0f;
        for (int i = 0; i < 60; ++i) {
            float f;
            float x$iv3;
            boolean $i$f$getDp2;
            float f2;
            boolean isFive;
            float angleDeg = (float)i * 6.0f;
            double angleRad = Math.toRadians(angleDeg);
            boolean isMajor = i % 15 == 0;
            boolean bl3 = isFive = i % 5 == 0;
            if (isMajor) {
                int $this$dp$iv = 7;
                boolean $i$f$getDp3 = false;
                f2 = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
            } else if (isFive) {
                double $this$dp$iv = 4.5;
                $i$f$getDp2 = false;
                f2 = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv)));
            } else {
                double $this$dp$iv = 2.5;
                boolean $i$f$getDp4 = false;
                f2 = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv)));
            }
            float tickLen = f2;
            int $this$dp$iv = 4;
            $i$f$getDp2 = false;
            float startR = r - $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
            float endR = startR - tickLen;
            long arg0$iv3 = center;
            boolean bl4 = false;
            long value$iv$iv5 = arg0$iv3;
            boolean $i$f$unpackFloat13 = false;
            int bits$iv$iv$iv4 = (int)(value$iv$iv5 >> 32);
            boolean $i$f$floatFromBits5 = false;
            float cX = Float.intBitsToFloat(bits$iv$iv$iv4) + (float)(Math.cos(angleRad) * (double)startR);
            long arg0$iv4 = center;
            boolean bl5 = false;
            long value$iv$iv6 = arg0$iv4;
            boolean $i$f$unpackFloat23 = false;
            int bits$iv$iv$iv5 = (int)(value$iv$iv6 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits6 = false;
            float cY = Float.intBitsToFloat(bits$iv$iv$iv5) + (float)(Math.sin(angleRad) * (double)startR);
            long arg0$iv5 = center;
            $i$f$getX-impl2 = false;
            long value$iv$iv7 = arg0$iv5;
            boolean $i$f$unpackFloat14 = false;
            int bits$iv$iv$iv6 = (int)(value$iv$iv7 >> 32);
            boolean $i$f$floatFromBits7 = false;
            float eX = Float.intBitsToFloat(bits$iv$iv$iv6) + (float)(Math.cos(angleRad) * (double)endR);
            long arg0$iv6 = center;
            $i$f$getY-impl = false;
            long value$iv$iv8 = arg0$iv6;
            boolean $i$f$unpackFloat24 = false;
            int bits$iv$iv$iv7 = (int)(value$iv$iv8 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits8 = false;
            float eY = Float.intBitsToFloat(bits$iv$iv$iv7) + (float)(Math.sin(angleRad) * (double)endR);
            float tickAlpha = isMajor ? 0.9f : (isFive ? 0.6f : 0.3f);
            long l = Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294829706L), (float)tickAlpha, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            float $i$f$getX-impl2 = cX;
            float y$iv2 = cY;
            boolean $i$f$Offset2 = false;
            boolean $i$f$packFloats2 = false;
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv3);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            long l2 = Offset.constructor-impl((long)(v1$iv$iv2 << 32 | v2$iv$iv2 & 0xFFFFFFFFL));
            x$iv3 = eX;
            y$iv2 = eY;
            $i$f$Offset2 = false;
            $i$f$packFloats2 = false;
            v1$iv$iv2 = Float.floatToRawIntBits(x$iv3);
            v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            long l3 = Offset.constructor-impl((long)(v1$iv$iv2 << 32 | v2$iv$iv2 & 0xFFFFFFFFL));
            if (isMajor) {
                int $this$dp$iv2 = 2;
                boolean $i$f$getDp5 = false;
                f = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv2));
            } else {
                double $this$dp$iv3 = 1.2;
                boolean $i$f$getDp6 = false;
                f = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv3)));
            }
            DrawScope.drawLine-NGM6Ib0$default((DrawScope)$this$drawGothicAnalogClock_u2dx_KDEd0, (long)l, (long)l2, (long)l3, (float)f, (int)StrokeCap.Companion.getRound-KaPHkGw(), null, (float)0.0f, null, (int)0, (int)480, null);
        }
        int $this$dp$iv = 14;
        boolean $i$f$getDp7 = false;
        float markerR = r - $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
        for (int h = 0; h < 12; ++h) {
            void x$iv4;
            double angleRad = Math.toRadians((float)h * 30.0f - 90.0f);
            long arg0$iv7 = center;
            $i$f$getX-impl = false;
            long value$iv$iv9 = arg0$iv7;
            boolean $i$f$unpackFloat15 = false;
            int bits$iv$iv$iv8 = (int)(value$iv$iv9 >> 32);
            boolean $i$f$floatFromBits9 = false;
            float mx = Float.intBitsToFloat(bits$iv$iv$iv8) + (float)(Math.cos(angleRad) * (double)markerR);
            long arg0$iv8 = center;
            boolean $i$f$getY-impl222 = false;
            long value$iv$iv10 = arg0$iv8;
            boolean $i$f$unpackFloat25 = false;
            int bits$iv$iv$iv9 = (int)(value$iv$iv10 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits10 = false;
            float my = Float.intBitsToFloat(bits$iv$iv$iv9) + (float)(Math.sin(angleRad) * (double)markerR);
            if (h % 3 == 0) {
                void x$iv5;
                double $this$dp$iv4 = 4.5;
                boolean $i$f$getDp8 = false;
                float dSize = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv4)));
                Object[] $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465 = $i$f$getY-impl222 = SkiaBackedPath_skikoKt.Path();
                boolean bl6 = false;
                $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465.moveTo(mx, my - dSize);
                $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465.lineTo(mx + dSize * 0.65f, my);
                $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465.lineTo(mx, my + dSize);
                $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465.lineTo(mx - dSize * 0.65f, my);
                $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2465.close();
                Object[] dPath = $i$f$getY-impl222;
                Object[] $i$f$getY-impl222 = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFBEBL)), Color.box-impl((long)ColorKt.Color((long)4294286859L))};
                float $i$f$getY-impl222 = mx;
                float y$iv3 = my;
                boolean $i$f$Offset3 = false;
                boolean $i$f$packFloats3 = false;
                long v1$iv$iv3 = Float.floatToRawIntBits((float)x$iv5);
                long v2$iv$iv3 = Float.floatToRawIntBits(y$iv3);
                DrawScope.drawPath-GBMwjPU$default((DrawScope)$this$drawGothicAnalogClock_u2dx_KDEd0, (Path)dPath, (Brush)Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$i$f$getY-impl222), (long)Offset.constructor-impl((long)(v1$iv$iv3 << 32 | v2$iv$iv3 & 0xFFFFFFFFL)), (float)dSize, (int)0, (int)8, null), (float)0.0f, null, null, (int)0, (int)60, null);
                continue;
            }
            double $this$dp$iv22 = 1.6;
            boolean $i$f$getDp9 = false;
            float $this$dp$iv22 = mx;
            float y$iv4 = my;
            boolean $i$f$Offset4 = false;
            boolean $i$f$packFloats4 = false;
            long v1$iv$iv4 = Float.floatToRawIntBits((float)x$iv4);
            long v2$iv$iv4 = Float.floatToRawIntBits(y$iv4);
            DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawGothicAnalogClock_u2dx_KDEd0, (long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294829706L), (float)0.85f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)$this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv22))), (long)Offset.constructor-impl((long)(v1$iv$iv4 << 32 | v2$iv$iv4 & 0xFFFFFFFFL)), (float)0.0f, null, null, (int)0, (int)120, null);
        }
        double $this$dp$iv32 = 2.5;
        boolean $i$f$getDp10 = false;
        float $this$dp$iv32 = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv32)));
        double $this$dp$iv5 = 2.5;
        boolean $i$f$getDp11 = false;
        float y$iv5 = $this$drawGothicAnalogClock_u2dx_KDEd0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv5)));
        boolean $i$f$Offset22 = false;
        boolean $i$f$packFloats22 = false;
        long v1$iv$iv5 = Float.floatToRawIntBits((float)x$iv);
        long v2$iv$iv5 = Float.floatToRawIntBits(y$iv5);
        long shadowOffset = Offset.constructor-impl((long)(v1$iv$iv5 << 32 | v2$iv$iv5 & 0xFFFFFFFFL));
        float hourAngle = hours * 30.0f - 90.0f;
        float hourLen = r * 0.48f;
        DrawScope $i$f$Offset22 = $this$drawGothicAnalogClock_u2dx_KDEd0;
        float $i$f$packFloats22 = hourAngle + 90.0f;
        long pivot$iv22 = center;
        boolean bl7 = false;
        DrawScope $this$withTransform$iv$iv = $this$rotate_u2dRg1IO4c$iv3;
        boolean $i$f$withTransform = false;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        boolean bl8 = false;
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        try {
            Object[] v2$iv$iv6;
            void degrees$iv;
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
            boolean bl9 = false;
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.rotate-Uv8p0NA((float)degrees$iv, pivot$iv22);
            void $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468 = $this$withTransform$iv$iv;
            boolean bl10 = false;
            Object[] $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466 = v2$iv$iv6 = SkiaBackedPath_skikoKt.Path();
            boolean bl11 = false;
            long arg0$iv9 = center;
            $i$f$getX-impl = false;
            long value$iv$iv11 = arg0$iv9;
            boolean $i$f$unpackFloat16 = false;
            int bits$iv$iv$iv10 = (int)(value$iv$iv11 >> 32);
            $i$f$floatFromBits2 = false;
            float f = Float.intBitsToFloat(bits$iv$iv$iv10);
            arg0$iv9 = center;
            boolean bl12 = false;
            value$iv$iv11 = arg0$iv9;
            boolean $i$f$unpackFloat26 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.moveTo(f, Float.intBitsToFloat(bits$iv$iv$iv10) - hourLen);
            arg0$iv9 = center;
            $i$f$getX-impl = false;
            value$iv$iv11 = arg0$iv9;
            $i$f$unpackFloat16 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 >> 32);
            $i$f$floatFromBits2 = false;
            int $this$dp$iv6 = 3;
            boolean $i$f$getDp12 = false;
            float f3 = Float.intBitsToFloat(bits$iv$iv$iv10) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv6));
            arg0$iv9 = center;
            bl12 = false;
            value$iv$iv11 = arg0$iv9;
            $i$f$unpackFloat26 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.lineTo(f3, Float.intBitsToFloat(bits$iv$iv$iv10) - hourLen * 0.5f);
            arg0$iv9 = center;
            $i$f$getX-impl = false;
            value$iv$iv11 = arg0$iv9;
            $i$f$unpackFloat16 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 >> 32);
            $i$f$floatFromBits2 = false;
            double $this$dp$iv7 = 1.8;
            boolean $i$f$getDp13 = false;
            float f4 = Float.intBitsToFloat(bits$iv$iv$iv10) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv7)));
            arg0$iv = center;
            bl12 = false;
            value$iv$iv11 = arg0$iv;
            $i$f$unpackFloat26 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            $this$dp$iv6 = 6;
            $i$f$getDp12 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.lineTo(f4, Float.intBitsToFloat(bits$iv$iv$iv10) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv6)));
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv11 = arg0$iv;
            $i$f$unpackFloat16 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 >> 32);
            $i$f$floatFromBits2 = false;
            $this$dp$iv = 1.8;
            $i$f$getDp13 = false;
            float f5 = Float.intBitsToFloat(bits$iv$iv$iv10) - $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv)));
            arg0$iv = center;
            bl12 = false;
            value$iv$iv11 = arg0$iv;
            $i$f$unpackFloat26 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            $this$dp$iv6 = 6;
            $i$f$getDp12 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.lineTo(f5, Float.intBitsToFloat(bits$iv$iv$iv10) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv6)));
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv11 = arg0$iv;
            $i$f$unpackFloat16 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 >> 32);
            $i$f$floatFromBits2 = false;
            $this$dp$iv6 = 3;
            $i$f$getDp12 = false;
            float f6 = Float.intBitsToFloat(bits$iv$iv$iv10) - $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv6));
            arg0$iv = center;
            bl12 = false;
            value$iv$iv11 = arg0$iv;
            $i$f$unpackFloat26 = false;
            bits$iv$iv$iv10 = (int)(value$iv$iv11 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.lineTo(f6, Float.intBitsToFloat(bits$iv$iv$iv10) - hourLen * 0.5f);
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466.close();
            Object[] hourPath = v2$iv$iv6;
            Object[] $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2467 = $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466 = SkiaBackedPath_skikoKt.Path();
            boolean bl13 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2467.addPath-Uv8p0NA((Path)hourPath, shadowOffset);
            Object[] shadowPath = $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466;
            DrawScope.drawPath-LG529CI$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468, (Path)shadowPath, (long)Color.copy-wmQWz5c$default((long)Color.Companion.getBlack-0d7_KjU(), (float)0.55f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)0.0f, null, null, (int)0, (int)60, null);
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466 = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFBEBL)), Color.box-impl((long)ColorKt.Color((long)4292441862L))};
            long arg0$iv10 = center;
            $i$f$getY-impl = false;
            value$iv$iv2 = arg0$iv10;
            boolean $i$f$unpackFloat27 = false;
            int bits$iv$iv$iv11 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits11 = false;
            float f7 = Float.intBitsToFloat(bits$iv$iv$iv11) - hourLen;
            arg0$iv10 = center;
            $i$f$getY-impl = false;
            value$iv$iv2 = arg0$iv10;
            $i$f$unpackFloat27 = false;
            bits$iv$iv$iv11 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits11 = false;
            int $this$dp$iv8 = 6;
            boolean $i$f$getDp14 = false;
            DrawScope.drawPath-GBMwjPU$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468, (Path)hourPath, (Brush)Brush.Companion.verticalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468_u24lambda_u2466), (float)f7, (float)(Float.intBitsToFloat(bits$iv$iv$iv11) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2468.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv8))), (int)0, (int)8, null), (float)0.0f, null, null, (int)0, (int)60, null);
        }
        finally {
            $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv.setSize-uvyYCjk(previousSize$iv$iv);
        }
        float minAngle = minutes * 6.0f - 90.0f;
        float minLen = r * 0.72f;
        DrawScope pivot$iv22 = $this$drawGothicAnalogClock_u2dx_KDEd0;
        float $i$f$Offset4 = minAngle + 90.0f;
        long pivot$iv = center;
        $i$f$rotate-Rg1IO4c2 = false;
        void $this$withTransform$iv$iv2 = $this$rotate_u2dRg1IO4c$iv2;
        boolean $i$f$withTransform2 = false;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform$iv$iv2.getDrawContext();
        $i$a$-with-DrawScopeKt$withTransform$1$iv$iv = false;
        long previousSize$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv2.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().save();
        try {
            Object[] $i$f$getDp14;
            void degrees$iv;
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv2.getTransform();
            boolean bl14 = false;
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.rotate-Uv8p0NA((float)degrees$iv, pivot$iv);
            void $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471 = $this$withTransform$iv$iv2;
            boolean bl15 = false;
            Object[] $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469 = $i$f$getDp14 = SkiaBackedPath_skikoKt.Path();
            boolean bl16 = false;
            long arg0$iv11 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv11;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float f = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv11 = center;
            boolean bl17 = false;
            value$iv$iv = arg0$iv11;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.moveTo(f, Float.intBitsToFloat(bits$iv$iv$iv) - minLen);
            arg0$iv11 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv11;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            int $this$dp$iv9 = 2;
            boolean $i$f$getDp15 = false;
            float f8 = Float.intBitsToFloat(bits$iv$iv$iv) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv9));
            arg0$iv11 = center;
            bl17 = false;
            value$iv$iv = arg0$iv11;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.lineTo(f8, Float.intBitsToFloat(bits$iv$iv$iv) - minLen * 0.45f);
            arg0$iv11 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv11;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            double $this$dp$iv10 = 1.2;
            $i$f$getDp = false;
            float f9 = Float.intBitsToFloat(bits$iv$iv$iv) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv10)));
            arg0$iv = center;
            bl17 = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            $this$dp$iv9 = 7;
            $i$f$getDp15 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.lineTo(f9, Float.intBitsToFloat(bits$iv$iv$iv) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv9)));
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            $this$dp$iv = 1.2;
            $i$f$getDp = false;
            float f10 = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv)));
            arg0$iv13 = center;
            bl17 = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            $this$dp$iv9 = 7;
            $i$f$getDp15 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.lineTo(f10, Float.intBitsToFloat(bits$iv$iv$iv) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv9)));
            arg0$iv13 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            $this$dp$iv9 = 2;
            $i$f$getDp15 = false;
            float f11 = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv9));
            arg0$iv13 = center;
            bl17 = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.lineTo(f11, Float.intBitsToFloat(bits$iv$iv$iv) - minLen * 0.45f);
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469.close();
            Object[] minPath = $i$f$getDp14;
            Object[] $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2470 = $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469 = SkiaBackedPath_skikoKt.Path();
            boolean bl18 = false;
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2470.addPath-Uv8p0NA((Path)minPath, shadowOffset);
            Object[] minShadow = $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469;
            DrawScope.drawPath-LG529CI$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471, (Path)minShadow, (long)Color.copy-wmQWz5c$default((long)Color.Companion.getBlack-0d7_KjU(), (float)0.55f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)0.0f, null, null, (int)0, (int)60, null);
            $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469 = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFFFFL)), Color.box-impl((long)ColorKt.Color((long)4294286859L))};
            long arg0$iv12 = center;
            bl21 = false;
            long value$iv$iv12 = arg0$iv12;
            boolean $i$f$unpackFloat28 = false;
            int bits$iv$iv$iv12 = (int)(value$iv$iv12 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            float f12 = Float.intBitsToFloat(bits$iv$iv$iv12) - minLen;
            arg0$iv12 = center;
            bl21 = false;
            value$iv$iv12 = arg0$iv12;
            $i$f$unpackFloat28 = false;
            bits$iv$iv$iv12 = (int)(value$iv$iv12 & 0xFFFFFFFFL);
            $i$f$floatFromBits2 = false;
            int $this$dp$iv11 = 7;
            boolean $i$f$getDp16 = false;
            DrawScope.drawPath-GBMwjPU$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471, (Path)minPath, (Brush)Brush.Companion.verticalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471_u24lambda_u2469), (float)f12, (float)(Float.intBitsToFloat(bits$iv$iv$iv12) + $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2471.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv11))), (int)0, (int)8, null), (float)0.0f, null, null, (int)0, (int)60, null);
        }
        finally {
            $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv2.setSize-uvyYCjk(previousSize$iv$iv2);
        }
        float secAngle = seconds * 6.0f - 90.0f;
        float secLen = r * 0.82f;
        float secBack = r * 0.18f;
        $this$withTransform$iv$iv = $this$drawGothicAnalogClock_u2dx_KDEd0;
        float $i$f$rotate-Rg1IO4c2 = secAngle + 90.0f;
        long pivot$iv3 = center;
        $i$f$rotate-Rg1IO4c = false;
        void $this$withTransform$iv$iv3 = $this$rotate_u2dRg1IO4c$iv;
        boolean $i$f$withTransform3 = false;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv3 = $this$withTransform$iv$iv3.getDrawContext();
        $i$a$-with-DrawScopeKt$withTransform$1$iv$iv = false;
        long previousSize$iv$iv3 = $this$withTransform_u24lambda_u246$iv$iv3.getSize-NH-jbRc();
        $this$withTransform_u24lambda_u246$iv$iv3.getCanvas().save();
        try {
            float x$iv6;
            void degrees$iv;
            DrawTransform $this$rotate_Rg1IO4c_u24lambda_u240$iv = $this$withTransform_u24lambda_u246$iv$iv3.getTransform();
            boolean bl19 = false;
            $this$rotate_Rg1IO4c_u24lambda_u240$iv.rotate-Uv8p0NA((float)degrees$iv, pivot$iv3);
            void $this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472 = $this$withTransform$iv$iv3;
            boolean bl20 = false;
            long arg0$iv13 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float f = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv13 = shadowOffset;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float $this$dp$iv12 = f + Float.intBitsToFloat(bits$iv$iv$iv);
            long arg0$iv14 = center;
            boolean bl21 = false;
            value$iv$iv2 = arg0$iv14;
            boolean $i$f$unpackFloat29 = false;
            int bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits12 = false;
            float f13 = Float.intBitsToFloat(bits$iv$iv$iv13) - secLen;
            arg0$iv14 = shadowOffset;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            float y$iv6 = f13 + Float.intBitsToFloat(bits$iv$iv$iv13);
            boolean $i$f$Offset5 = false;
            boolean $i$f$packFloats5 = false;
            long v1$iv$iv6 = Float.floatToRawIntBits(x$iv6);
            long v2$iv$iv7 = Float.floatToRawIntBits(y$iv6);
            long l = Offset.constructor-impl((long)(v1$iv$iv6 << 32 | v2$iv$iv7 & 0xFFFFFFFFL));
            arg0$iv13 = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float f14 = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv13 = shadowOffset;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv13;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            x$iv6 = f14 + Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv14 = center;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            float f15 = Float.intBitsToFloat(bits$iv$iv$iv13) + secBack;
            arg0$iv14 = shadowOffset;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            y$iv6 = f15 + Float.intBitsToFloat(bits$iv$iv$iv13);
            $i$f$Offset5 = false;
            $i$f$packFloats5 = false;
            v1$iv$iv6 = Float.floatToRawIntBits(x$iv6);
            v2$iv$iv7 = Float.floatToRawIntBits(y$iv6);
            double $this$dp$iv13 = 1.2;
            $i$f$getDp = false;
            DrawScope.drawLine-NGM6Ib0$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472, (long)Color.copy-wmQWz5c$default((long)Color.Companion.getBlack-0d7_KjU(), (float)0.45f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (long)l, (long)Offset.constructor-impl((long)(v1$iv$iv6 << 32 | v2$iv$iv7 & 0xFFFFFFFFL)), (float)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv13))), (int)StrokeCap.Companion.getRound-KaPHkGw(), null, (float)0.0f, null, (int)0, (int)480, null);
            Object[] x$iv32 = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFBEBL)), Color.box-impl((long)ColorKt.Color((long)4294286859L)), Color.box-impl((long)ColorKt.Color((long)0xFFEF4444L))};
            arg0$iv = center;
            bl17 = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            float f16 = Float.intBitsToFloat(bits$iv$iv$iv) - secLen;
            arg0$iv = center;
            bl17 = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat2 = false;
            bits$iv$iv$iv = (int)(value$iv$iv & 0xFFFFFFFFL);
            $i$f$floatFromBits = false;
            Brush brush = Brush.Companion.verticalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])x$iv32), (float)f16, (float)(Float.intBitsToFloat(bits$iv$iv$iv) + secBack), (int)0, (int)8, null);
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float x$iv32 = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv14 = center;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            y$iv6 = Float.intBitsToFloat(bits$iv$iv$iv13) - secLen;
            $i$f$Offset5 = false;
            $i$f$packFloats5 = false;
            v1$iv$iv6 = Float.floatToRawIntBits(x$iv32);
            v2$iv$iv7 = Float.floatToRawIntBits(y$iv6);
            long l4 = Offset.constructor-impl((long)(v1$iv$iv6 << 32 | v2$iv$iv7 & 0xFFFFFFFFL));
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            x$iv32 = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv14 = center;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            y$iv6 = Float.intBitsToFloat(bits$iv$iv$iv13) + secBack;
            $i$f$Offset5 = false;
            $i$f$packFloats5 = false;
            v1$iv$iv6 = Float.floatToRawIntBits(x$iv32);
            v2$iv$iv7 = Float.floatToRawIntBits(y$iv6);
            $this$dp$iv = 1.3;
            $i$f$getDp = false;
            DrawScope.drawLine-1RTmtNc$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472, (Brush)brush, (long)l4, (long)Offset.constructor-impl((long)(v1$iv$iv6 << 32 | v2$iv$iv7 & 0xFFFFFFFFL)), (float)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), (int)StrokeCap.Companion.getRound-KaPHkGw(), null, (float)0.0f, null, (int)0, (int)480, null);
            int $this$dp$iv522 = 3;
            boolean $i$f$getDp17 = false;
            arg0$iv = center;
            $i$f$getX-impl = false;
            value$iv$iv = arg0$iv;
            $i$f$unpackFloat1 = false;
            bits$iv$iv$iv = (int)(value$iv$iv >> 32);
            $i$f$floatFromBits = false;
            float $this$dp$iv522 = Float.intBitsToFloat(bits$iv$iv$iv);
            arg0$iv14 = center;
            bl21 = false;
            value$iv$iv2 = arg0$iv14;
            $i$f$unpackFloat29 = false;
            bits$iv$iv$iv13 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
            $i$f$floatFromBits12 = false;
            y$iv = Float.intBitsToFloat(bits$iv$iv$iv13) + secBack * 0.65f;
            $i$f$Offset5 = false;
            $i$f$packFloats5 = false;
            v1$iv$iv6 = Float.floatToRawIntBits((float)x$iv);
            v2$iv$iv7 = Float.floatToRawIntBits(y$iv);
            $this$dp$iv = 1.2;
            $i$f$getDp = false;
            DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472, (long)ColorKt.Color((long)4294286859L), (float)$this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv522)), (long)Offset.constructor-impl((long)(v1$iv$iv6 << 32 | v2$iv$iv7 & 0xFFFFFFFFL)), (float)0.0f, (DrawStyle)((DrawStyle)new Stroke($this$drawGothicAnalogClock_x_KDEd0_u24lambda_u2472.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), 0.0f, 0, 0, null, 30, null)), null, (int)0, (int)104, null);
        }
        finally {
            $this$withTransform_u24lambda_u246$iv$iv3.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv3.setSize-uvyYCjk(previousSize$iv$iv3);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final void drawGothicCompassBackground-d16Qtg0(DrawScope $this$drawGothicCompassBackground_u2dd16Qtg0, long size) {
        void x$iv;
        float r = Size.getMinDimension-impl((long)size) / 2.0f;
        long arg0$iv22 = size;
        boolean bl = false;
        long value$iv$iv = arg0$iv22;
        boolean $i$f$unpackFloat1 = false;
        int bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        boolean $i$f$floatFromBits = false;
        float arg0$iv22 = Float.intBitsToFloat(bits$iv$iv$iv) / 2.0f;
        long arg0$iv = size;
        boolean bl2 = false;
        long value$iv$iv2 = arg0$iv;
        boolean $i$f$unpackFloat2 = false;
        int bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        boolean $i$f$floatFromBits2 = false;
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2) / 2.0f;
        boolean $i$f$Offset = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits((float)x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long c = Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
        boolean $this$dp$iv = true;
        boolean $i$f$getDp = false;
        DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawGothicCompassBackground_u2dd16Qtg0, (long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4292128567L), (float)0.18f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)(r * 0.85f), (long)0L, (float)0.0f, (DrawStyle)((DrawStyle)new Stroke($this$drawGothicCompassBackground_u2dd16Qtg0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), 0.0f, 0, 0, null, 30, null)), null, (int)0, (int)108, null);
        $this$dp$iv = true;
        $i$f$getDp = false;
        DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$drawGothicCompassBackground_u2dd16Qtg0, (long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4292128567L), (float)0.12f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)(r * 0.55f), (long)0L, (float)0.0f, (DrawStyle)((DrawStyle)new Stroke($this$drawGothicCompassBackground_u2dd16Qtg0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), 0.0f, 0, 0, null, 30, null)), null, (int)0, (int)108, null);
        for (int i = 0; i < 8; ++i) {
            void x$iv2;
            double angle = (float)i * 45.0f;
            double rad = Math.toRadians(angle);
            float len = i % 2 == 0 ? r * 0.65f : r * 0.4f;
            long arg0$iv3 = c;
            boolean bl3 = false;
            long value$iv$iv3 = arg0$iv3;
            boolean $i$f$unpackFloat12 = false;
            int bits$iv$iv$iv3 = (int)(value$iv$iv3 >> 32);
            boolean $i$f$floatFromBits3 = false;
            float ex = Float.intBitsToFloat(bits$iv$iv$iv3) + (float)(Math.cos(rad) * (double)len);
            long arg0$iv322 = c;
            boolean bl4 = false;
            long value$iv$iv4 = arg0$iv322;
            boolean $i$f$unpackFloat22 = false;
            int bits$iv$iv$iv4 = (int)(value$iv$iv4 & 0xFFFFFFFFL);
            boolean $i$f$floatFromBits4 = false;
            float ey = Float.intBitsToFloat(bits$iv$iv$iv4) + (float)(Math.sin(rad) * (double)len);
            float arg0$iv322 = ex;
            float y$iv2 = ey;
            boolean $i$f$Offset2 = false;
            boolean $i$f$packFloats2 = false;
            long v1$iv$iv2 = Float.floatToRawIntBits((float)x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            boolean $this$dp$iv2 = true;
            boolean $i$f$getDp2 = false;
            DrawScope.drawLine-NGM6Ib0$default((DrawScope)$this$drawGothicCompassBackground_u2dd16Qtg0, (long)Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4294829706L), (float)(i % 2 == 0 ? 0.4f : 0.22f), (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (long)c, (long)Offset.constructor-impl((long)(v1$iv$iv2 << 32 | v2$iv$iv2 & 0xFFFFFFFFL)), (float)$this$drawGothicCompassBackground_u2dd16Qtg0.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv2))), (int)0, null, (float)0.0f, null, (int)0, (int)496, null);
        }
    }

    private static final String formatMs(long ms) {
        if (ms <= 0L) {
            return "00:00";
        }
        long totalSec = ms / (long)1000;
        long m = totalSec / (long)60;
        long s = totalSec % (long)60;
        String string2 = "%02d:%02d";
        Object[] objectArray = new Object[]{m, s};
        String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
        return string3;
    }

    /*
     * WARNING - void declaration
     */
    private static final Track EchoScreensaver$lambda$0(State<Track> $currentTrack$delegate) {
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
    private static final boolean EchoScreensaver$lambda$1(State<Boolean> $isPlaying$delegate) {
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
    private static final long EchoScreensaver$lambda$2(State<Long> $positionMs$delegate) {
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
    private static final long EchoScreensaver$lambda$3(State<Long> $durationMs$delegate) {
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
    private static final LocalDateTime EchoScreensaver$lambda$5(MutableState<LocalDateTime> $currentTime$delegate) {
        void $this$getValue$iv;
        State state = (State)$currentTime$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (LocalDateTime)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void EchoScreensaver$lambda$6(MutableState<LocalDateTime> $currentTime$delegate, LocalDateTime localDateTime) {
        void $this$setValue$iv;
        MutableState<LocalDateTime> mutableState = $currentTime$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        LocalDateTime value$iv = localDateTime;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    /*
     * WARNING - void declaration
     */
    private static final float EchoScreensaver$lambda$8(State<Float> $wavePhase$delegate) {
        void $this$getValue$iv;
        State<Float> state = $wavePhase$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float EchoScreensaver$lambda$9(State<Float> $visualizerPulse$delegate) {
        void $this$getValue$iv;
        State<Float> state = $visualizerPulse$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float EchoScreensaver$lambda$10(State<Float> $vinylRotation$delegate) {
        void $this$getValue$iv;
        State<Float> state = $vinylRotation$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float EchoScreensaver$lambda$11(State<Float> $glintPhase$delegate) {
        void $this$getValue$iv;
        State<Float> state = $glintPhase$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    private static final Unit EchoScreensaver$lambda$13$lambda$12(Function0 $onWakeUp, AwaitPointerEventScope $this$onPointerEvent, PointerEvent it) {
        Intrinsics.checkNotNullParameter((Object)$this$onPointerEvent, (String)"$this$onPointerEvent");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$15$lambda$14(Function0 $onWakeUp, AwaitPointerEventScope $this$onPointerEvent, PointerEvent it) {
        Intrinsics.checkNotNullParameter((Object)$this$onPointerEvent, (String)"$this$onPointerEvent");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$17$lambda$16(Function0 $onWakeUp, AwaitPointerEventScope $this$onPointerEvent, PointerEvent it) {
        Intrinsics.checkNotNullParameter((Object)$this$onPointerEvent, (String)"$this$onPointerEvent");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$27$lambda$20$lambda$19(State $wavePhase$delegate, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        EchoScreensaverKt.drawGothicAtmosphere-12SF9DM($this$Canvas, $this$Canvas.getSize-NH-jbRc(), EchoScreensaverKt.EchoScreensaver$lambda$8((State<Float>)$wavePhase$delegate));
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$27$lambda$22$lambda$21(PlayerViewModel $playerViewModel, Function0 $onWakeUp) {
        $playerViewModel.togglePlayPause();
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$27$lambda$24$lambda$23(PlayerViewModel $playerViewModel, Function0 $onWakeUp) {
        $playerViewModel.skipPrevious();
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$27$lambda$26$lambda$25(PlayerViewModel $playerViewModel, Function0 $onWakeUp) {
        $playerViewModel.skipNext();
        $onWakeUp.invoke();
        return Unit.INSTANCE;
    }

    private static final Unit EchoScreensaver$lambda$28(PlayerViewModel $playerViewModel, Function0 $onWakeUp, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        EchoScreensaverKt.EchoScreensaver($playerViewModel, (Function0<Unit>)$onWakeUp, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    private static final Unit GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$41$lambda$38$lambda$37$lambda$36(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        float r = Size.getMinDimension-impl((long)$this$Canvas.getSize-NH-jbRc()) / 2.0f;
        Object[] objectArray = new Color[]{Color.box-impl((long)Color.Companion.getTransparent-0d7_KjU()), Color.box-impl((long)Color.copy-wmQWz5c$default((long)Color.Companion.getBlack-0d7_KjU(), (float)0.55f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null))};
        DrawScope.drawCircle-V9BoPsw$default((DrawScope)$this$Canvas, (Brush)Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])objectArray), (long)0L, (float)r, (int)0, (int)10, null), (float)r, (long)0L, (float)0.0f, null, null, (int)0, (int)124, null);
        for (int k = 2; k < 8; ++k) {
            boolean $this$dp$iv = true;
            boolean $i$f$getDp = false;
            DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$Canvas, (long)Color.copy-wmQWz5c$default((long)Color.Companion.getWhite-0d7_KjU(), (float)0.06f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (float)(r * ((float)k / 8.5f)), (long)0L, (float)0.0f, (DrawStyle)((DrawStyle)new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv))), 0.0f, 0, 0, null, 30, null)), null, (int)0, (int)108, null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$41$lambda$40$lambda$39(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        EchoScreensaverKt.drawGothicCompassBackground-d16Qtg0($this$Canvas, $this$Canvas.getSize-NH-jbRc());
        return Unit.INSTANCE;
    }

    private static final Unit GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$44$lambda$43$lambda$42(LocalDateTime $currentTime, Track $currentTrack, DrawScope $this$Canvas) {
        EchoMediaItem echoMediaItem;
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        Track track2 = $currentTrack;
        EchoScreensaverKt.drawGothicAnalogClock-x_KDEd0($this$Canvas, $this$Canvas.getSize-NH-jbRc(), $currentTime, (track2 != null ? track2.getCover() : null) != null || ((echoMediaItem = $currentTrack) != null && (echoMediaItem = ((Track)echoMediaItem).getAlbum()) != null ? ((Album)echoMediaItem).getCover() : null) != null);
        return Unit.INSTANCE;
    }

    private static final CharSequence GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$56$lambda$55$lambda$49$lambda$48$lambda$47(Artist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getName();
    }

    private static final Unit GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$58$lambda$57(float $circleSize, float $circleCenterX, float $circleCenterY, float $glintPhase, DrawScope $this$Canvas) {
        float x$iv;
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        float circleR = $this$Canvas.toPx-0680j_4($circleSize) / 2.0f;
        float ccX = $this$Canvas.toPx-0680j_4($circleCenterX);
        float ccY = $this$Canvas.toPx-0680j_4($circleCenterY);
        float glintAlpha = RangesKt.coerceIn((float)($glintPhase * 0.7f), (float)0.1f, (float)0.85f);
        int $this$dp$iv = 2;
        boolean $i$f$getDp = false;
        float starOffsetDist = circleR + $this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
        Object object = new Offset[4];
        float f = ccX;
        float y$iv = ccY - starOffsetDist;
        boolean $i$f$Offset = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        object[0] = Offset.box-impl((long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)));
        x$iv = ccX + starOffsetDist;
        y$iv = ccY;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        object[1] = Offset.box-impl((long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)));
        x$iv = ccX;
        y$iv = ccY + starOffsetDist;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        object[2] = Offset.box-impl((long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)));
        x$iv = ccX - starOffsetDist;
        y$iv = ccY;
        $i$f$Offset = false;
        $i$f$packFloats = false;
        v1$iv$iv = Float.floatToRawIntBits(x$iv);
        v2$iv$iv = Float.floatToRawIntBits(y$iv);
        object[3] = Offset.box-impl((long)Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)));
        List starPositions = CollectionsKt.listOf((Object[])object);
        object = starPositions.iterator();
        while (object.hasNext()) {
            long pos = ((Offset)object.next()).unbox-impl();
            EchoScreensaverKt.drawStarGlint-d-4ec7I($this$Canvas, pos, glintAlpha);
        }
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit GothicButterflyBannerCapsule$lambda$60(ImageBitmap $frameBitmap, float $glintPhase, Track $currentTrack, float $vinylRotation, LocalDateTime $currentTime, boolean $isPlaying, float $pulse, float $wavePhase, Function0 $onPrevious, Function0 $onPlayPause, Function0 $onNext, long $positionMs, long $durationMs, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$BoxWithConstraints, (String)"$this$BoxWithConstraints");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C333@13691L15982:EchoScreensaver.kt#rzt5gx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed((Object)$this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 0x13) != 18, $dirty & 1)) {
            Object object;
            void $this$cache$iv;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void modifier$iv;
            void $composer$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void $changed$iv2;
            void modifier$iv2;
            void contentAlignment$iv;
            void $composer$iv2;
            void $composer4;
            int $changed$iv$iv$iv3;
            Function0 factory$iv$iv$iv;
            int $changed$iv$iv3;
            void modifier$iv$iv3;
            int $changed$iv3;
            Alignment.Vertical verticalAlignment$iv;
            void horizontalArrangement$iv;
            void $composer$iv3;
            Album album3;
            EchoMediaItem echoMediaItem;
            String string2;
            FontWeight $this$cache$iv2;
            String string3;
            void $composer222;
            void $changed$iv$iv$iv42;
            CharSequence factory$iv$iv$iv2;
            void $changed$iv$iv4;
            Object modifier$iv$iv4;
            String verticalAlignment$iv22;
            Object $composer$iv4;
            void $composer5;
            int $changed$iv$iv$iv5;
            Function0 factory$iv$iv$iv3;
            int $changed$iv$iv5;
            Modifier modifier$iv$iv5;
            Modifier modifier$iv3;
            int $changed$iv4;
            void verticalAlignment$iv3;
            void horizontalArrangement$iv2;
            void $composer$iv5;
            void $composer6;
            void $changed$iv$iv$iv6;
            void $changed$iv$iv6;
            void modifier$iv$iv6;
            void modifier$iv4;
            void $changed$iv5;
            void verticalArrangement$iv;
            void $composer$iv6;
            Object object2;
            void modifier$iv5;
            void contentAlignment$iv2;
            Function1 value$iv;
            void $this$cache$iv3;
            boolean invalid$iv;
            Function1 value$iv2;
            Arrangement.Horizontal $this$cache$iv4;
            int $i$a$-Layout-BoxKt$Box$1$iv2;
            int $i$a$-with-Updater$set$1$iv$iv$iv2;
            Modifier materialized$iv$iv;
            Function1 modifier$iv$iv7;
            String coverUrl;
            Object cover;
            ImageHolder imageHolder;
            void $composer7;
            int $changed$iv$iv$iv7;
            Function0 factory$iv$iv$iv4;
            int $changed$iv$iv7;
            void modifier$iv$iv8;
            int $changed$iv6;
            void modifier$iv222;
            void contentAlignment$iv222;
            void $composer$iv7;
            float other$iv;
            float arg0$iv;
            float arg0$iv2;
            void $composer8;
            void $changed$iv$iv$iv8;
            void $changed$iv$iv8;
            void modifier$iv$iv9;
            void $changed$iv7;
            void modifier$iv6;
            void $composer$iv8;
            void arg0$iv222;
            void arg0$iv3;
            void arg0$iv4;
            void arg0$iv5;
            void arg0$iv6;
            void arg0$iv7;
            void arg0$iv8;
            void arg0$iv9;
            float targetWidth;
            void arg0$iv10;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)567466210, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.screensaver.GothicButterflyBannerCapsule.<anonymous> (EchoScreensaver.kt:318)");
            }
            float f = $this$BoxWithConstraints.getMaxWidth-D9Ej5fM();
            float other$iv2 = 0.94f;
            boolean bl = false;
            int $this$dp$iv = 1140;
            boolean $i$f$getDp = false;
            Comparable comparable = RangesKt.coerceAtMost((Comparable)Dp.box-impl((float)Dp.constructor-impl((float)(arg0$iv10 * other$iv2))), (Comparable)Dp.box-impl((float)Dp.constructor-impl((float)$this$dp$iv)));
            $this$dp$iv = 780;
            $i$f$getDp = false;
            float $i$f$getDp2 = targetWidth = ((Dp)RangesKt.coerceAtLeast((Comparable)comparable, (Comparable)Dp.box-impl((float)Dp.constructor-impl((float)$this$dp$iv)))).unbox-impl();
            float other$iv3 = 0.40820312f;
            $i$f$times-u2uoSUM = false;
            float targetHeight = Dp.constructor-impl((float)(arg0$iv9 * other$iv3));
            other$iv3 = targetWidth;
            float other$iv4 = 0.2607422f;
            $i$f$times-u2uoSUM = false;
            float circleCenterX = Dp.constructor-impl((float)(arg0$iv8 * other$iv4));
            other$iv4 = targetHeight;
            float other$iv5 = 0.5f;
            $i$f$times-u2uoSUM = false;
            float circleCenterY = Dp.constructor-impl((float)(arg0$iv7 * other$iv5));
            other$iv5 = targetWidth;
            float other$iv6 = 0.17773438f;
            $i$f$times-u2uoSUM = false;
            float circleSize = Dp.constructor-impl((float)(arg0$iv6 * other$iv6));
            other$iv6 = targetWidth;
            float other$iv7 = 0.4140625f;
            $i$f$times-u2uoSUM = false;
            float plaqueX = Dp.constructor-impl((float)(arg0$iv5 * other$iv7));
            other$iv7 = targetHeight;
            float other$iv8 = 0.30622008f;
            $i$f$times-u2uoSUM = false;
            float plaqueY = Dp.constructor-impl((float)(arg0$iv4 * other$iv8));
            other$iv8 = targetWidth;
            float other$iv9 = 0.4765625f;
            $i$f$times-u2uoSUM = false;
            float plaqueWidth = Dp.constructor-impl((float)(arg0$iv3 * other$iv9));
            other$iv9 = targetHeight;
            float other$iv10 = 0.39712918f;
            $i$f$times-u2uoSUM = false;
            float plaqueHeight = Dp.constructor-impl((float)(arg0$iv222 * other$iv10));
            Modifier arg0$iv222 = SizeKt.size-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)targetWidth, (float)targetHeight);
            Composer composer = $composer;
            boolean bl2 = false;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv8, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            boolean propagateMinConstraints$iv = false;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv3, (boolean)propagateMinConstraints$iv);
            void var35_47 = modifier$iv6;
            int n = 0x70 & $changed$iv7 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv8, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv8, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv8.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv8, (Modifier)modifier$iv$iv9);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n2 = 6 | 0x380 & $changed$iv$iv8 << 6;
            boolean $i$f$ReusableComposeNode = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv8, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv8.startReusableNode();
            if ($composer$iv8.getInserting()) {
                void factory$iv$iv$iv5;
                $composer$iv8.createNode((Function0)factory$iv$iv$iv5);
            } else {
                $composer$iv8.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl((Composer)$composer$iv8);
            boolean bl3 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)measurePolicy$iv, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)localMap$iv$iv, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl4 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
            boolean bl5 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv2, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n3 = 0xE & $changed$iv$iv$iv8 >> 6;
            void $composer$iv9 = $composer$iv8;
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv9, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv7 >> 6;
            void var54_66 = $composer$iv9;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer8, (int)-1960354604, (String)"C341@14124L2705,418@17774L1272,451@19155L9588,645@28879L784,645@28837L826:EchoScreensaver.kt#rzt5gx");
            float f2 = circleCenterX;
            float f3 = circleSize;
            float other$iv11 = 2.0f;
            boolean bl8 = false;
            arg0$iv2 = Dp.constructor-impl((float)(arg0$iv2 / other$iv11));
            boolean bl9 = false;
            float f4 = Dp.constructor-impl((float)(arg0$iv - other$iv));
            arg0$iv = circleCenterY;
            other$iv = circleSize;
            other$iv = 2.0f;
            bl8 = false;
            arg0$iv2 = Dp.constructor-impl((float)(arg0$iv2 / other$iv));
            $i$f$minus-5rwHm24 = false;
            Modifier arg0$iv32 = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)SizeKt.size-3ABfNKs((Modifier)OffsetKt.offset-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f4, (float)Dp.constructor-impl((float)(arg0$iv - other$iv))), (float)circleSize), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (long)ColorKt.Color((long)4278781454L), null, (int)2, null);
            Alignment other$iv22 = Alignment.Companion.getCenter();
            void $i$f$div-u2uoSUM2 = $composer8;
            int n5 = 48;
            boolean $i$f$Box2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv2 = false;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv222, (boolean)propagateMinConstraints$iv2);
            void var64_99 = modifier$iv222;
            int n6 = 0x70 & $changed$iv6 << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv7, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv7, (Modifier)modifier$iv$iv8);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n7 = 6 | 0x380 & $changed$iv$iv7 << 6;
            boolean $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv7, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv7.startReusableNode();
            if ($composer$iv7.getInserting()) {
                $composer$iv7.createNode(factory$iv$iv$iv4);
            } else {
                $composer$iv7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv7);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)measurePolicy$iv2, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)localMap$iv$iv2, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv2 = $this$Layout_u24lambda_u240$iv$iv2;
            bl16 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv3, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n8 = 0xE & $changed$iv$iv$iv7 >> 6;
            void $composer$iv10 = $composer$iv7;
            bl17 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv10, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n9 = 6 | 0x70 & $changed$iv6 >> 6;
            void var83_118 = $composer$iv10;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2441 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl10 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer7, (int)-1962582419, (String)"C:EchoScreensaver.kt#rzt5gx");
            Object object3 = $currentTrack;
            if (object3 == null || (object3 = (imageHolder = ((Track)object3).getCover())) == null) {
                Album album2;
                EchoMediaItem echoMediaItem2 = $currentTrack;
                object3 = echoMediaItem2 != null && (echoMediaItem2 = (album2 = ((Track)echoMediaItem2).getAlbum())) != null ? ((Album)echoMediaItem2).getCover() : null;
            }
            String string4 = (cover = object3) instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)cover).getRequest().getUrl() : (coverUrl = cover instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)cover).getUri() : null);
            if (coverUrl != null) {
                Object object4;
                void $composer9;
                void $changed$iv$iv$iv9;
                void $changed$iv$iv9;
                void $changed$iv8;
                void $composer$iv11;
                $composer7.startReplaceGroup(-1962273691);
                ComposerKt.sourceInformation((Composer)$composer7, (String)"360@14958L1599");
                cover = RotateKt.rotate((Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)$vinylRotation);
                imageHolder = Alignment.Companion.getCenter();
                void var90_132 = $composer7;
                int n10 = 48;
                boolean $i$f$Box3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv11, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv3 = false;
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv3);
                void var94_143 = modifier$iv;
                int n11 = 0x70 & $changed$iv8 << 3;
                boolean $i$f$Layout3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv11, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv11, (int)0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv11.getCurrentCompositionLocalMap();
                materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv11, (Modifier)modifier$iv$iv7);
                Function0 function03 = ComposeUiNode.Companion.getConstructor();
                int n12 = 6 | 0x380 & $changed$iv$iv9 << 6;
                boolean $i$f$ReusableComposeNode3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv11, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer$iv11.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv11.startReusableNode();
                if ($composer$iv11.getInserting()) {
                    void factory$iv$iv$iv6;
                    $composer$iv11.createNode((Function0)factory$iv$iv$iv6);
                } else {
                    $composer$iv11.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl((Composer)$composer$iv11);
                $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)measurePolicy$iv3, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)localMap$iv$iv3, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                $i$f$set-impl = false;
                Composer $this$set_impl_u24lambda_u240$iv$iv$iv3 = $this$Layout_u24lambda_u240$iv$iv3;
                $i$a$-with-Updater$set$1$iv$iv$iv2 = 0;
                if ($this$set_impl_u24lambda_u240$iv$iv$iv3.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv3.rememberedValue(), (Object)compositeKeyHash$iv$iv3)) {
                    $this$set_impl_u24lambda_u240$iv$iv$iv3.updateRememberedValue((Object)compositeKeyHash$iv$iv3);
                    $this$Layout_u24lambda_u240$iv$iv3.apply((Object)compositeKeyHash$iv$iv3, block$iv$iv$iv3);
                }
                Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv3, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
                int n13 = 0xE & $changed$iv$iv$iv9 >> 6;
                void $composer$iv12 = $composer$iv11;
                $i$a$-Layout-BoxKt$Box$1$iv2 = 0;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv12, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n14 = 6 | 0x70 & $changed$iv8 >> 6;
                void var113_176 = $composer$iv12;
                BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2441_u24lambda_u2438 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl11 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer9, (int)925010497, (String)"C366@15210L269,373@15612L923,373@15570L965:EchoScreensaver.kt#rzt5gx");
                SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)coverUrl, (String)"Album Art", (Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, null, null, (ContentScale)ContentScale.Companion.getCrop(), (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer9, (int)1573296, (int)0, (int)1976);
                Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer9, (int)1969514160, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                void var116_183 = $composer9;
                boolean invalid$iv22 = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv4.rememberedValue();
                boolean bl12 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    Modifier modifier2 = modifier;
                    boolean bl13 = false;
                    modifier = modifier2;
                    value$iv2 = EchoScreensaverKt::GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$41$lambda$38$lambda$37$lambda$36;
                    $this$cache$iv4.updateRememberedValue((Object)value$iv2);
                    object4 = value$iv2;
                } else {
                    object4 = it$iv;
                }
                Function1 function1 = (Function1)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer9);
                CanvasKt.Canvas((Modifier)modifier, (Function1)function1, (Composer)$composer9, (int)54);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer9);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv12);
                $composer$iv11.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv11);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv11);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv11);
                $composer7.endReplaceGroup();
            } else {
                Object object5;
                $composer7.startReplaceGroup(-1960685406);
                ComposerKt.sourceInformation((Composer)$composer7, (String)"395@16716L81,395@16674L123");
                Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer7, (int)352398247, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                contentAlignment$iv = $composer7;
                invalid$iv = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv3.rememberedValue();
                boolean bl14 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    Modifier modifier3 = modifier;
                    boolean bl15 = false;
                    modifier = modifier3;
                    value$iv = EchoScreensaverKt::GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$41$lambda$40$lambda$39;
                    $this$cache$iv3.updateRememberedValue((Object)value$iv);
                    object5 = value$iv;
                } else {
                    object5 = it$iv;
                }
                modifier$iv = (Function1)object5;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer7);
                CanvasKt.Canvas((Modifier)modifier, (Function1)modifier$iv, (Composer)$composer7, (int)54);
                $composer7.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer7);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv10);
            $composer$iv7.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv7);
            if ($frameBitmap != null) {
                $composer8.startReplaceGroup(-1957836785);
                ComposerKt.sourceInformation((Composer)$composer8, (String)"405@17157L247");
                ImageKt.Image-5h-nEew((ImageBitmap)$frameBitmap, (String)"Gothic Butterfly Frame", (Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, (ContentScale)ContentScale.Companion.getFillBounds(), (float)0.0f, null, (int)0, (Composer)$composer8, (int)25008, (int)232);
                $composer8.endReplaceGroup();
            } else {
                $composer8.startReplaceGroup(-1974848314);
                $composer8.endReplaceGroup();
            }
            float modifier$iv222 = circleCenterX;
            float contentAlignment$iv222 = circleSize;
            other$iv = 2.0f;
            $i$f$div-u2uoSUM = false;
            arg0$iv = Dp.constructor-impl((float)(arg0$iv / other$iv));
            $i$f$minus-5rwHm24 = false;
            float f5 = Dp.constructor-impl((float)(arg0$iv - other$iv));
            arg0$iv = circleCenterY;
            other$iv = circleSize;
            other$iv = 2.0f;
            $i$f$div-u2uoSUM = false;
            arg0$iv = Dp.constructor-impl((float)(arg0$iv / other$iv));
            $i$f$minus-5rwHm24 = false;
            Modifier arg0$iv42 = SizeKt.size-3ABfNKs((Modifier)OffsetKt.offset-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)f5, (float)Dp.constructor-impl((float)(arg0$iv - other$iv))), (float)circleSize);
            Alignment other$iv32 = Alignment.Companion.getCenter();
            void $i$f$div-u2uoSUM3 = $composer8;
            $changed$iv6 = 48;
            $i$f$Box2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            propagateMinConstraints$iv = false;
            measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv2, (boolean)propagateMinConstraints$iv);
            modifier$iv$iv8 = modifier$iv5;
            $changed$iv$iv7 = 0x70 & $changed$iv6 << 3;
            $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv8);
            factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv7 = 6 | 0x380 & $changed$iv$iv7 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                $composer$iv.createNode(factory$iv$iv$iv4);
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
            boolean bl16 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv3, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed$iv9 = 0xE & $changed$iv$iv$iv7 >> 6;
            $composer$iv10 = $composer$iv;
            boolean bl17 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv10, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int $changed2 = 6 | 0x70 & $changed$iv6 >> 6;
            $composer7 = $composer$iv10;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2444 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl18 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer7, (int)-480973092, (String)"C428@18234L271,428@18192L313,437@18572L460:EchoScreensaver.kt#rzt5gx");
            Modifier modifier = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer7, (int)123032846, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
            $this$cache$iv3 = $composer7;
            invalid$iv = $composer7.changedInstance((Object)$currentTime) | $composer7.changedInstance((Object)$currentTrack);
            boolean $i$f$cache22 = false;
            Object it$iv22 = $this$cache$iv3.rememberedValue();
            boolean bl19 = false;
            if (invalid$iv || it$iv22 == Composer.Companion.getEmpty()) {
                Modifier it$iv = modifier;
                boolean bl20 = false;
                modifier = it$iv;
                value$iv = arg_0 -> EchoScreensaverKt.GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$44$lambda$43$lambda$42($currentTime, $currentTrack, arg_0);
                $this$cache$iv3.updateRememberedValue((Object)value$iv);
                object2 = value$iv;
            } else {
                object2 = it$iv22;
            }
            modifier$iv$iv7 = (Function1)object2;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer7);
            CanvasKt.Canvas((Modifier)modifier, (Function1)modifier$iv$iv7, (Composer)$composer7, (int)6);
            int $this$dp$iv22 = 14;
            boolean $i$f$getDp3 = false;
            Object[] $this$dp$iv22 = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFBEBL)), Color.box-impl((long)ColorKt.Color((long)4292441862L)), Color.box-impl((long)ColorKt.Color((long)4286067983L))};
            int $this$dp$iv3 = 1;
            $i$f$getDp3 = false;
            BoxKt.Box((Modifier)BorderKt.border-xT4_qwU((Modifier)BackgroundKt.background$default((Modifier)ClipKt.clip((Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22)), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (Brush)Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$this$dp$iv22), (long)0L, (float)0.0f, (int)0, (int)14, null), null, (float)0.0f, (int)6, null), (float)Dp.constructor-impl((float)$this$dp$iv3), (long)ColorKt.Color((long)4294829706L), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (Composer)$composer7, (int)0);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer7);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv10);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            int $this$dp$iv4 = 16;
            boolean $i$f$getDp4 = false;
            float f6 = Dp.constructor-impl((float)$this$dp$iv4);
            $this$dp$iv4 = 10;
            $i$f$getDp4 = false;
            Modifier $this$dp$iv32 = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.size-VpY3zN4((Modifier)OffsetKt.offset-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)plaqueX, (float)plaqueY), (float)plaqueWidth, (float)plaqueHeight), (float)f6, (float)Dp.constructor-impl((float)$this$dp$iv4));
            $composer$iv = $composer8;
            $changed$iv6 = 0;
            $i$f$Box2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv32 = Alignment.Companion.getTopStart();
            propagateMinConstraints$iv = false;
            measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv32, (boolean)propagateMinConstraints$iv);
            modifier$iv$iv8 = modifier$iv;
            $changed$iv$iv7 = 0x70 & $changed$iv6 << 3;
            $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv8);
            factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv7 = 6 | 0x380 & $changed$iv$iv7 << 6;
            $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                $composer$iv.createNode(factory$iv$iv$iv4);
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
            bl16 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv2.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv2.rememberedValue(), (Object)compositeKeyHash$iv$iv2)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv2.updateRememberedValue((Object)compositeKeyHash$iv$iv2);
                $this$Layout_u24lambda_u240$iv$iv2.apply((Object)compositeKeyHash$iv$iv2, block$iv$iv$iv2);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv2, (Object)materialized$iv$iv3, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv9 = 0xE & $changed$iv$iv$iv7 >> 6;
            $composer$iv10 = $composer$iv;
            bl17 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv10, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            $changed2 = 6 | 0x70 & $changed$iv6 >> 6;
            $composer7 = $composer$iv10;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl21 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer7, (int)1152105863, (String)"C457@19419L9310:EchoScreensaver.kt#rzt5gx");
            Modifier $i$f$getDp32 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Arrangement.Vertical invalid$iv2 = (Arrangement.Vertical)Arrangement.INSTANCE.getSpaceBetween();
            void $i$f$cache22 = $composer7;
            int it$iv22 = 54;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv6, (int)(0xE & $changed$iv5 >> 3 | 0x70 & $changed$iv5 >> 3));
            value$iv = modifier$iv4;
            $this$dp$iv3 = 0x70 & $changed$iv5 << 3;
            boolean $i$f$Layout4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv6, (int)0);
            CompositionLocalMap localMap$iv$iv4 = $composer$iv6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier((Composer)$composer$iv6, (Modifier)modifier$iv$iv6);
            materialized$iv$iv = ComposeUiNode.Companion.getConstructor();
            int factory$iv$iv$iv6 = 6 | 0x380 & $changed$iv$iv6 << 6;
            boolean $i$f$ReusableComposeNode4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv6.startReusableNode();
            if ($composer$iv6.getInserting()) {
                void factory$iv$iv$iv7;
                $composer$iv6.createNode((Function0)factory$iv$iv$iv7);
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
            $i$a$-with-Updater$set$1$iv$iv$iv2 = 0xE & $changed$iv$iv$iv6 >> 6;
            void $composer$iv13 = $composer$iv6;
            boolean bl22 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv13, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            $i$a$-Layout-BoxKt$Box$1$iv2 = 6 | 0x70 & $changed$iv5 >> 6;
            void $changed3 = $composer$iv13;
            ColumnScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl23 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer6, (int)244062201, (String)"C462@19653L2004,502@21735L1457,532@23288L300,542@23682L5029:EchoScreensaver.kt#rzt5gx");
            Modifier bl11 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            $this$cache$iv4 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical invalid$iv22 = Alignment.Companion.getCenterVertically();
            void $i$f$cache = $composer6;
            int it$iv = 438;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv2, (Alignment.Vertical)verticalAlignment$iv3, (Composer)$composer$iv5, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
            value$iv2 = modifier$iv3;
            int n15 = 0x70 & $changed$iv4 << 3;
            boolean $i$f$Layout5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv5, (int)0);
            CompositionLocalMap localMap$iv$iv5 = $composer$iv5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier((Composer)$composer$iv5, (Modifier)modifier$iv$iv5);
            Function0 function04 = ComposeUiNode.Companion.getConstructor();
            int n16 = 6 | 0x380 & $changed$iv$iv5 << 6;
            boolean $i$f$ReusableComposeNode5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv5.startReusableNode();
            if ($composer$iv5.getInserting()) {
                $composer$iv5.createNode(factory$iv$iv$iv3);
            } else {
                $composer$iv5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl((Composer)$composer$iv5);
            bl29 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)measurePolicy$iv5, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)localMap$iv$iv5, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            bl30 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv5 = $this$Layout_u24lambda_u240$iv$iv5;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv5.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv5.rememberedValue(), (Object)compositeKeyHash$iv$iv5)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv5.updateRememberedValue((Object)compositeKeyHash$iv$iv5);
                $this$Layout_u24lambda_u240$iv$iv5.apply((Object)compositeKeyHash$iv$iv5, block$iv$iv$iv5);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)materialized$iv$iv5, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n17 = 0xE & $changed$iv$iv$iv5 >> 6;
            void $composer$iv14 = $composer$iv5;
            boolean bl24 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv14, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n18 = 6 | 0x70 & $changed$iv4 >> 6;
            void var141_216 = $composer$iv14;
            RowScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2446 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl25 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-468397959, (String)"C468@19965L865,489@21150L485:EchoScreensaver.kt#rzt5gx");
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            void var145_222 = $composer5;
            int $changed$iv222 = 384;
            boolean $i$f$Row22 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv7 = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv3, (Alignment.Vertical)verticalAlignment$iv22, (Composer)$composer$iv4, (int)(0xE & $changed$iv222 >> 3 | 0x70 & $changed$iv222 >> 3));
            Modifier modifier4 = modifier$iv7;
            int n19 = 0x70 & $changed$iv222 << 3;
            boolean $i$f$Layout222 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv62 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv4, (int)0);
            CompositionLocalMap localMap$iv$iv62 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier((Composer)$composer$iv4, (Modifier)modifier$iv$iv4);
            Function0 function05 = ComposeUiNode.Companion.getConstructor();
            int n20 = 6 | 0x380 & $changed$iv$iv4 << 6;
            int $i$f$ReusableComposeNode62 = 0;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                $composer$iv4.createNode((Function0)factory$iv$iv$iv2);
            } else {
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl((Composer)$composer$iv4);
            function1 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv6, (Object)measurePolicy$iv6, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv6, (Object)localMap$iv$iv62, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv6 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            album3 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv6 = $this$Layout_u24lambda_u240$iv$iv6;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv6.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv6.rememberedValue(), (Object)compositeKeyHash$iv$iv62)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv6.updateRememberedValue((Object)compositeKeyHash$iv$iv62);
                $this$Layout_u24lambda_u240$iv$iv6.apply((Object)compositeKeyHash$iv$iv62, block$iv$iv$iv6);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv6, (Object)materialized$iv$iv6, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n21 = 0xE & $changed$iv$iv$iv42 >> 6;
            void $composer$iv222 = $composer$iv4;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv222, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n22 = 6 | 0x70 & $changed$iv222 >> 6;
            void var170_286 = $composer$iv222;
            RowScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2446_u24lambda_u2445 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl26 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer222, (int)-106610, (String)"C469@20047L260,475@20336L468:EchoScreensaver.kt#rzt5gx");
            long l = ColorKt.Color((long)4294286859L);
            long l2 = TextUnitKt.getSp((int)11);
            int $this$dp$iv5 = 4;
            boolean $i$f$getDp5 = false;
            Modifier modifier5 = PaddingKt.padding-qDBjuR0$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv5), (float)0.0f, (int)11, null);
            TextKt.Text--4IGK_g((String)"\u2726", (Modifier)modifier5, (long)l, (long)l2, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, null, (Composer)$composer222, (int)3510, (int)0, (int)131056);
            l = TextUnitKt.getSp((int)10);
            FontWeight fontWeight = FontWeight.Companion.getBold();
            long l3 = TextUnitKt.getSp((double)1.4);
            long l4 = ColorKt.Color((long)4293247099L);
            TextKt.Text--4IGK_g((String)($isPlaying ? "SPOTIFY \u00b7 HIGH-FIDELITY" : "SPOTIFY \u00b7 AMBIENT"), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)new TextStyle(l4, l, fontWeight, null, null, null, null, l3, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 0xFFFF78, null), (Composer)$composer222, (int)0, (int)0, (int)65534);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer222);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv222);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            String string5 = $currentTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.US));
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"format(...)");
            String string6 = string5.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string6, (String)"toUpperCase(...)");
            String timeStr = string6;
            String string7 = $currentTime.format(DateTimeFormatter.ofPattern("EEE, MMM d", Locale.US));
            Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"format(...)");
            Object[] objectArray = string7.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)objectArray, (String)"toUpperCase(...)");
            Object[] dateStr = objectArray;
            long l5 = TextUnitKt.getSp((double)10.5);
            FontWeight $changed$iv222 = FontWeight.Companion.getMedium();
            long l6 = TextUnitKt.getSp((double)0.8);
            long l7 = Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4292128567L), (float)0.92f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            GenericFontFamily $i$f$Layout222 = FontFamily.Companion.getMonospace();
            TextKt.Text--4IGK_g((String)(timeStr + "  \u00b7  " + (String)dateStr), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)new TextStyle(l7, l5, $changed$iv222, null, null, (FontFamily)$i$f$Layout222, null, l6, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 0xFFFF58, null), (Composer)$composer5, (int)0, (int)0, (int)65534);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv14);
            $composer$iv5.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            modifier$iv3 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            $composer$iv5 = $composer6;
            $changed$iv4 = 6;
            boolean $i$f$Column2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            measurePolicy$iv5 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv2, (Alignment.Horizontal)horizontalAlignment$iv2, (Composer)$composer$iv5, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
            modifier$iv$iv5 = modifier$iv3;
            $changed$iv$iv5 = 0x70 & $changed$iv4 << 3;
            $i$f$Layout5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv5, (int)0);
            localMap$iv$iv5 = $composer$iv5.getCurrentCompositionLocalMap();
            materialized$iv$iv5 = ComposedModifierKt.materializeModifier((Composer)$composer$iv5, (Modifier)modifier$iv$iv5);
            factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv5 = 6 | 0x380 & $changed$iv$iv5 << 6;
            $i$f$ReusableComposeNode5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv5.startReusableNode();
            if ($composer$iv5.getInserting()) {
                $composer$iv5.createNode(factory$iv$iv$iv3);
            } else {
                $composer$iv5.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl((Composer)$composer$iv5);
            bl29 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)measurePolicy$iv5, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)localMap$iv$iv5, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            bl30 = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv5 = $this$Layout_u24lambda_u240$iv$iv5;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv5.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv5.rememberedValue(), (Object)compositeKeyHash$iv$iv5)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv5.updateRememberedValue((Object)compositeKeyHash$iv$iv5);
                $this$Layout_u24lambda_u240$iv$iv5.apply((Object)compositeKeyHash$iv$iv5, block$iv$iv$iv5);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)materialized$iv$iv5, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed$iv10 = 0xE & $changed$iv$iv$iv5 >> 6;
            $composer$iv14 = $composer$iv5;
            $i$a$-Layout-ColumnKt$Column$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv14, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int $changed4 = 6 | 0x70 & $changed$iv4 >> 6;
            $composer5 = $composer$iv14;
            ColumnScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2449 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl27 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-129085829, (String)"C503@21804L618,515@22447L40,519@22719L451:EchoScreensaver.kt#rzt5gx");
            Object object6 = $currentTrack;
            if (object6 == null || (object6 = (verticalAlignment$iv22 = ((Track)object6).getTitle())) == null) {
                object6 = "SpotHub Ambient Sanctum";
            }
            $composer$iv4 = object6;
            int verticalAlignment$iv22 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            long l8 = TextUnitKt.getSp((int)17);
            timeStr = FontWeight.Companion.getBold();
            dateStr = new Color[]{Color.box-impl((long)ColorKt.Color((long)0xFFFFFBEBL)), Color.box-impl((long)ColorKt.Color((long)4294829706L)), Color.box-impl((long)ColorKt.Color((long)4294286859L))};
            measurePolicy$iv6 = Brush.Companion.horizontalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])dateStr), (float)0.0f, (float)0.0f, (int)0, (int)14, null);
            modifier$iv$iv4 = new TextStyle((Brush)measurePolicy$iv6, 0.0f, l8, (FontWeight)timeStr, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 0x1FFFFF2, null);
            TextKt.Text--4IGK_g((String)$composer$iv4, null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)verticalAlignment$iv22, (boolean)false, (int)1, (int)0, null, (TextStyle)modifier$iv$iv4, (Composer)$composer5, (int)0, (int)3120, (int)55294);
            int $this$dp$iv6 = 2;
            boolean $i$f$getDp6 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6)), (Composer)$composer5, (int)6);
            Track track2 = $currentTrack;
            Object object7 = modifier$iv$iv4 = track2 != null ? track2.getArtists() : null;
            if (modifier$iv$iv4 == null) {
                $composer5.startReplaceGroup(-128385417);
                $composer5.endReplaceGroup();
                string3 = null;
            } else {
                Object object8;
                $composer5.startReplaceGroup(-973972790);
                ComposerKt.sourceInformation((Composer)$composer5, (String)"516@22565L11");
                Iterable iterable = (Iterable)modifier$iv$iv4;
                CharSequence charSequence = null;
                CharSequence charSequence2 = null;
                Modifier modifier6 = null;
                int n23 = 0;
                CharSequence charSequence3 = null;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-973972387, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
                timeStr = $composer5;
                boolean invalid$iv3 = false;
                boolean $i$f$cache3 = false;
                Object it$iv3 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv2 = false;
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    CharSequence compositeKeyHash$iv$iv62 = charSequence3;
                    int localMap$iv$iv62 = n23;
                    materialized$iv$iv6 = modifier6;
                    factory$iv$iv$iv2 = charSequence2;
                    CharSequence $changed$iv$iv$iv42 = charSequence;
                    Iterable $i$f$ReusableComposeNode62 = iterable;
                    boolean bl28 = false;
                    Function1 function1 = EchoScreensaverKt::GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$56$lambda$55$lambda$49$lambda$48$lambda$47;
                    iterable = $i$f$ReusableComposeNode62;
                    charSequence = $changed$iv$iv$iv42;
                    charSequence2 = factory$iv$iv$iv2;
                    modifier6 = materialized$iv$iv6;
                    n23 = localMap$iv$iv62;
                    charSequence3 = compositeKeyHash$iv$iv62;
                    Function1 value$iv3 = function1;
                    $this$cache$iv2.updateRememberedValue((Object)value$iv3);
                    object8 = value$iv3;
                } else {
                    object8 = it$iv3;
                }
                block$iv$iv$iv6 = (Function1)object8;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
                String album3 = CollectionsKt.joinToString$default((Iterable)iterable, charSequence, charSequence2, modifier6, (int)n23, charSequence3, (Function1)block$iv$iv$iv6, (int)31, null);
                $composer5.endReplaceGroup();
                string3 = string2 = album3;
            }
            if (string3 == null && ((echoMediaItem = $currentTrack) != null && (echoMediaItem = (album3 = ((Track)echoMediaItem).getAlbum())) != null ? ((Album)echoMediaItem).getTitle() : (string2 = null)) == null) {
                string2 = "Echo High-Fidelity Desktop";
            }
            String artistText = string2;
            int n24 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            l8 = TextUnitKt.getSp((int)12);
            $this$cache$iv2 = FontWeight.Companion.getNormal();
            long l9 = Color.copy-wmQWz5c$default((long)ColorKt.Color((long)4293060848L), (float)0.8f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            modifier$iv$iv4 = new TextStyle(l9, l8, $this$cache$iv2, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 0xFFFFF8, null);
            TextKt.Text--4IGK_g((String)artistText, null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)n24, (boolean)false, (int)1, (int)0, null, (TextStyle)modifier$iv$iv4, (Composer)$composer5, (int)0, (int)3120, (int)55294);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv14);
            $composer$iv5.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            int $this$dp$iv422 = 24;
            boolean $i$f$getDp422 = false;
            EchoScreensaverKt.GothicSpectrumRow($isPlaying, $pulse, $wavePhase, SizeKt.height-3ABfNKs((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)Dp.constructor-impl((float)$this$dp$iv422)), (Composer)$composer6, 3072, 0);
            Modifier $this$dp$iv422 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Arrangement.Horizontal $i$f$getDp422 = (Arrangement.Horizontal)Arrangement.INSTANCE.getSpaceBetween();
            horizontalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            $composer$iv5 = $composer6;
            $changed$iv4 = 438;
            $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            measurePolicy$iv5 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv3, (Composer)$composer$iv5, (int)(0xE & $changed$iv4 >> 3 | 0x70 & $changed$iv4 >> 3));
            modifier$iv$iv5 = modifier$iv;
            $changed$iv$iv5 = 0x70 & $changed$iv4 << 3;
            $i$f$Layout5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv5, (int)0);
            localMap$iv$iv5 = $composer$iv5.getCurrentCompositionLocalMap();
            materialized$iv$iv5 = ComposedModifierKt.materializeModifier((Composer)$composer$iv5, (Modifier)modifier$iv$iv5);
            factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv5 = 6 | 0x380 & $changed$iv$iv5 << 6;
            $i$f$ReusableComposeNode5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv5.startReusableNode();
            if ($composer$iv5.getInserting()) {
                $composer$iv5.createNode(factory$iv$iv$iv3);
            } else {
                $composer$iv5.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl((Composer)$composer$iv5);
            boolean bl29 = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)measurePolicy$iv5, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)localMap$iv$iv5, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            boolean bl30 = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv5 = $this$Layout_u24lambda_u240$iv$iv5;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv5.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv5.rememberedValue(), (Object)compositeKeyHash$iv$iv5)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv5.updateRememberedValue((Object)compositeKeyHash$iv$iv5);
                $this$Layout_u24lambda_u240$iv$iv5.apply((Object)compositeKeyHash$iv$iv5, block$iv$iv$iv5);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv5, (Object)materialized$iv$iv5, (Function2)ComposeUiNode.Companion.getSetModifier());
            $changed$iv10 = 0xE & $changed$iv$iv$iv5 >> 6;
            $composer$iv14 = $composer$iv5;
            bl24 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv14, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            $changed4 = 6 | 0x70 & $changed$iv4 >> 6;
            $composer5 = $composer$iv14;
            RowScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl31 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer5, (int)-200922818, (String)"C548@23993L2563,600@26643L2046:EchoScreensaver.kt#rzt5gx");
            Alignment.Vertical vertical2 = Alignment.Companion.getCenterVertically();
            $this$dp$iv = 4;
            boolean $i$f$getDp522 = false;
            Arrangement.Horizontal $i$f$getDp522 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
            Alignment.Vertical $i$f$Row22 = vertical2;
            $this$cache$iv2 = $composer5;
            int $i$f$cache3 = 432;
            boolean $i$f$Row3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv8 = (Modifier)Modifier.Companion;
            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
            Modifier it$iv3 = modifier$iv8;
            int $i$a$-let-ComposerKt$cache$1$iv2 = 0x70 & $changed$iv3 << 3;
            boolean $i$f$Layout6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv7 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
            CompositionLocalMap localMap$iv$iv7 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv3);
            Function0 $changed$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            $i$f$ReusableComposeNode62 = 6 | 0x380 & $changed$iv$iv3 << 6;
            boolean $i$f$ReusableComposeNode7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                $composer$iv3.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl((Composer)$composer$iv3);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)measurePolicy$iv7, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)localMap$iv$iv7, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv7 = $this$Layout_u24lambda_u240$iv$iv7;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv7.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv7.rememberedValue(), (Object)compositeKeyHash$iv$iv7)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv7.updateRememberedValue((Object)compositeKeyHash$iv$iv7);
                $this$Layout_u24lambda_u240$iv$iv7.apply((Object)compositeKeyHash$iv$iv7, block$iv$iv$iv7);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)materialized$iv$iv7, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $composer$iv222 = 0xE & $changed$iv$iv$iv3 >> 6;
            void $composer$iv15 = $composer$iv3;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv15, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int $composer222 = 6 | 0x70 & $changed$iv3 >> 6;
            $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2446_u24lambda_u2445 = $composer$iv15;
            RowScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454_u24lambda_u2451 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl32 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-1069759959, (String)"C552@24209L540,565@24852L1120,586@26002L528:EchoScreensaver.kt#rzt5gx");
            int $this$dp$iv7 = 28;
            boolean $i$f$getDp7 = false;
            IconButtonKt.IconButton((Function0)$onPrevious, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv7)), (boolean)false, null, null, ComposableSingletons$EchoScreensaverKt.INSTANCE.getLambda$547366796$desktopApp(), (Composer)$composer4, (int)196656, (int)28);
            $this$dp$iv7 = 30;
            $i$f$getDp7 = false;
            Object[] $this$dp$iv52 = new Color[]{Color.box-impl((long)ColorKt.Color((long)4294286859L)), Color.box-impl((long)ColorKt.Color((long)4290007817L))};
            boolean $this$dp$iv722 = true;
            $i$f$getDp7 = false;
            Modifier $this$dp$iv722 = ClickableKt.clickable-XHw0xAI$default((Modifier)BorderKt.border-xT4_qwU((Modifier)BackgroundKt.background$default((Modifier)ClipKt.clip((Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv7)), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (Brush)Brush.Companion.radialGradient-P_Vx-Ks$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$this$dp$iv52), (long)0L, (float)0.0f, (int)0, (int)14, null), null, (float)0.0f, (int)6, null), (float)Dp.constructor-impl((float)((float)$this$dp$iv722)), (long)ColorKt.Color((long)4294829706L), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (boolean)false, null, null, (Function0)$onPlayPause, (int)7, null);
            Alignment $i$f$getDp62 = Alignment.Companion.getCenter();
            void var198_322 = $composer4;
            $this$dp$iv5 = 48;
            boolean $i$f$Box4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv222 = false;
            MeasurePolicy measurePolicy$iv222 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv222);
            void var199_324 = modifier$iv2;
            int n25 = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv222 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv2, (int)0);
            CompositionLocalMap localMap$iv$iv222 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier((Composer)$composer$iv2, (Modifier)modifier$iv$iv2);
            Function0 function06 = ComposeUiNode.Companion.getConstructor();
            int n26 = 6 | 0x380 & $changed$iv$iv2 << 6;
            boolean $i$f$ReusableComposeNode8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                void factory$iv$iv$iv8;
                $composer$iv2.createNode((Function0)factory$iv$iv$iv8);
            } else {
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv8 = Updater.constructor-impl((Composer)$composer$iv2);
            int $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv2 = 0;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv8, (Object)measurePolicy$iv222, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv8, (Object)localMap$iv$iv222, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv8 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv8 = $this$Layout_u24lambda_u240$iv$iv8;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv8.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv8.rememberedValue(), (Object)compositeKeyHash$iv$iv222)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv8.updateRememberedValue((Object)compositeKeyHash$iv$iv222);
                $this$Layout_u24lambda_u240$iv$iv8.apply((Object)compositeKeyHash$iv$iv222, block$iv$iv$iv8);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv8, (Object)materialized$iv$iv8, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n27 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv16 = $composer$iv2;
            $i$a$-Layout-BoxKt$Box$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv16, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n28 = 6 | 0x70 & $changed$iv2 >> 6;
            void var218_357 = $composer$iv16;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454_u24lambda_u2451_u24lambda_u2450 = (BoxScope)BoxScopeInstance.INSTANCE;
            int n29 = 0;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1810412317, (String)"C578@25587L355:EchoScreensaver.kt#rzt5gx");
            ImageVector imageVector = $isPlaying ? PauseKt.getPause((Icons.Filled)Icons.INSTANCE.getDefault()) : PlayArrowKt.getPlayArrow((Icons.Filled)Icons.INSTANCE.getDefault());
            long l10 = ColorKt.Color((long)4280159744L);
            int $this$dp$iv8 = 18;
            boolean $i$f$getDp8 = false;
            Modifier modifier7 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv8));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Play/Pause", (Modifier)modifier7, (long)l10, (Composer)$composer3, (int)3504, (int)0);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv16);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
            $this$dp$iv = 28;
            $i$f$getDp = false;
            IconButtonKt.IconButton((Function0)$onNext, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (boolean)false, null, null, ComposableSingletons$EchoScreensaverKt.INSTANCE.getLambda$-23893707$desktopApp(), (Composer)$composer4, (int)196656, (int)28);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv15);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            vertical2 = Alignment.Companion.getCenterVertically();
            $this$dp$iv62 = 12;
            boolean $i$f$getDp9 = false;
            Modifier $this$dp$iv62 = PaddingKt.padding-qDBjuR0$default((Modifier)RowScope.weight$default((RowScope)$this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (float)Dp.constructor-impl((float)$this$dp$iv62), (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null);
            verticalAlignment$iv = vertical2;
            $composer$iv3 = $composer5;
            $changed$iv3 = 384;
            $i$f$Row3 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
            measurePolicy$iv7 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv22, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
            modifier$iv$iv3 = modifier$iv;
            $changed$iv$iv3 = 0x70 & $changed$iv3 << 3;
            $i$f$Layout6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            compositeKeyHash$iv$iv7 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
            localMap$iv$iv7 = $composer$iv3.getCurrentCompositionLocalMap();
            materialized$iv$iv7 = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv3);
            factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            $changed$iv$iv$iv3 = 6 | 0x380 & $changed$iv$iv3 << 6;
            $i$f$ReusableComposeNode7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
                $composer$iv3.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv3.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl((Composer)$composer$iv3);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)measurePolicy$iv7, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)localMap$iv$iv7, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            block$iv$iv$iv7 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            $this$set_impl_u24lambda_u240$iv$iv$iv7 = $this$Layout_u24lambda_u240$iv$iv7;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv7.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv7.rememberedValue(), (Object)compositeKeyHash$iv$iv7)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv7.updateRememberedValue((Object)compositeKeyHash$iv$iv7);
                $this$Layout_u24lambda_u240$iv$iv7.apply((Object)compositeKeyHash$iv$iv7, block$iv$iv$iv7);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv7, (Object)materialized$iv$iv7, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed$iv11 = 0xE & $changed$iv$iv$iv3 >> 6;
            $composer$iv15 = $composer$iv3;
            $i$a$-Layout-RowKt$Row$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv15, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int $changed5 = 6 | 0x70 & $changed$iv3 >> 6;
            $composer4 = $composer$iv15;
            RowScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454_u24lambda_u2453 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl33 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1776846696, (String)"C609@27189L928,628@28147L39,630@28216L447:EchoScreensaver.kt#rzt5gx");
            String posFormatted = EchoScreensaverKt.formatMs($positionMs);
            String durFormatted = EchoScreensaverKt.formatMs($durationMs);
            float progress = $durationMs > 0L ? RangesKt.coerceIn((float)((float)$positionMs / (float)$durationMs), (float)0.0f, (float)1.0f) : 0.0f;
            $this$dp$iv5 = 4;
            $i$f$getDp5 = false;
            Modifier modifier8 = SizeKt.height-3ABfNKs((Modifier)RowScope.weight$default((RowScope)$this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454_u24lambda_u2453, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null), (float)Dp.constructor-impl((float)$this$dp$iv5));
            $this$dp$iv5 = 2;
            $i$f$getDp5 = false;
            Modifier $this$dp$iv82 = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)modifier8, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv5)))), (long)ColorKt.Color((long)4281870868L), null, (int)2, null);
            void propagateMinConstraints$iv222 = $composer4;
            boolean measurePolicy$iv222 = false;
            boolean $i$f$Box5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
            boolean propagateMinConstraints$iv4 = false;
            MeasurePolicy measurePolicy$iv8 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv4, (boolean)propagateMinConstraints$iv4);
            void compositeKeyHash$iv$iv222 = modifier$iv;
            int localMap$iv$iv222 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv8 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv8 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            $this$Layout_u24lambda_u240$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv2 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode9 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                void factory$iv$iv$iv9;
                $composer$iv.createNode((Function0)factory$iv$iv$iv9);
            } else {
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv9 = Updater.constructor-impl((Composer)$composer$iv);
            $i$a$-ReusableComposeNode-LayoutKt$Layout$1$iv$iv = false;
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv9, (Object)measurePolicy$iv8, (Function2)ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv9, (Object)localMap$iv$iv8, (Function2)ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv9 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            $i$f$set-impl = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv9 = $this$Layout_u24lambda_u240$iv$iv9;
            $i$a$-with-Updater$set$1$iv$iv$iv = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv9.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv9.rememberedValue(), (Object)compositeKeyHash$iv$iv8)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv9.updateRememberedValue((Object)compositeKeyHash$iv$iv8);
                $this$Layout_u24lambda_u240$iv$iv9.apply((Object)compositeKeyHash$iv$iv8, block$iv$iv$iv9);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv9, (Object)materialized$iv$iv9, (Function2)ComposeUiNode.Companion.getSetModifier());
            int $changed6 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv17 = $composer$iv;
            $i$a$-Layout-BoxKt$Box$1$iv = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv17, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            n29 = 6 | 0x70 & $changed$iv >> 6;
            imageVector = $composer$iv17;
            BoxScope $this$GothicButterflyBannerCapsule_u24lambda_u2460_u24lambda_u2459_u24lambda_u2456_u24lambda_u2455_u24lambda_u2454_u24lambda_u2453_u24lambda_u2452 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl34 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-576781129, (String)"C616@27543L544:EchoScreensaver.kt#rzt5gx");
            $this$dp$iv8 = 4;
            $i$f$getDp8 = false;
            Object[] objectArray2 = new Color[]{Color.box-impl((long)ColorKt.Color((long)4292441862L)), Color.box-impl((long)ColorKt.Color((long)4294286859L)), Color.box-impl((long)ColorKt.Color((long)4294956367L))};
            BoxKt.Box((Modifier)BackgroundKt.background$default((Modifier)SizeKt.height-3ABfNKs((Modifier)SizeKt.fillMaxWidth((Modifier)((Modifier)Modifier.Companion), (float)progress), (float)Dp.constructor-impl((float)$this$dp$iv8)), (Brush)Brush.Companion.horizontalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])objectArray2), (float)0.0f, (float)0.0f, (int)0, (int)14, null), null, (float)0.0f, (int)6, null), (Composer)$composer2, (int)0);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv17);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            $this$dp$iv = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer4, (int)6);
            long l11 = TextUnitKt.getSp((int)10);
            FontWeight fontWeight2 = FontWeight.Companion.getMedium();
            long l12 = ColorKt.Color((long)4292128567L);
            GenericFontFamily genericFontFamily = FontFamily.Companion.getMonospace();
            TextKt.Text--4IGK_g((String)(posFormatted + " / " + durFormatted), null, (long)0L, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)new TextStyle(l12, l11, fontWeight2, null, null, (FontFamily)genericFontFamily, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 0xFFFFD8, null), (Composer)$composer4, (int)0, (int)0, (int)65534);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv15);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv14);
            $composer$iv5.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer6);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv13);
            $composer$iv6.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer7);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv10);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
            Modifier modifier9 = SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            ComposerKt.sourceInformationMarkerStart((Composer)$composer8, (int)352862156, (String)"CC(remember):EchoScreensaver.kt#9igjgp");
            contentAlignment$iv32 = $composer8;
            boolean invalid$iv4 = $composer8.changed(circleSize) | $composer8.changed(circleCenterX) | $composer8.changed(circleCenterY) | $composer8.changed($glintPhase);
            boolean $i$f$cache4 = false;
            Object it$iv4 = $this$cache$iv.rememberedValue();
            $i$a$-let-ComposerKt$cache$1$iv = false;
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Modifier modifier10 = modifier9;
                boolean bl35 = false;
                Function1 function1 = arg_0 -> EchoScreensaverKt.GothicButterflyBannerCapsule$lambda$60$lambda$59$lambda$58$lambda$57(circleSize, circleCenterX, circleCenterY, $glintPhase, arg_0);
                modifier9 = modifier10;
                Function1 value$iv4 = function1;
                $this$cache$iv.updateRememberedValue((Object)value$iv4);
                object = value$iv4;
            } else {
                object = it$iv4;
            }
            Function1 function1 = (Function1)object;
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer8);
            CanvasKt.Canvas((Modifier)modifier9, (Function1)function1, (Composer)$composer8, (int)6);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer8);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv9);
            $composer$iv8.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv8);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv8);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Unit GothicButterflyBannerCapsule$lambda$61(LocalDateTime $currentTime, Track $currentTrack, boolean $isPlaying, long $positionMs, long $durationMs, float $wavePhase, float $pulse, float $vinylRotation, float $glintPhase, Function0 $onPlayPause, Function0 $onPrevious, Function0 $onNext, int $$changed, int $$changed1, Composer $composer, int $force) {
        EchoScreensaverKt.GothicButterflyBannerCapsule($currentTime, $currentTrack, $isPlaying, $positionMs, $durationMs, $wavePhase, $pulse, $vinylRotation, $glintPhase, (Function0<Unit>)$onPlayPause, (Function0<Unit>)$onPrevious, (Function0<Unit>)$onNext, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), RecomposeScopeImplKt.updateChangedFlags((int)$$changed1));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit GothicSpectrumRow$lambda$63$lambda$62(float $phase, boolean $isPlaying, float $pulse, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter((Object)$this$Canvas, (String)"$this$Canvas");
        int barCount = 28;
        int $this$dp$iv = 3;
        boolean $i$f$getDp = false;
        float spacing = $this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
        float totalSpacing = (float)(barCount - 1) * spacing;
        long arg0$iv = $this$Canvas.getSize-NH-jbRc();
        boolean bl = false;
        long value$iv$iv = arg0$iv;
        boolean $i$f$unpackFloat1 = false;
        int bits$iv$iv$iv = (int)(value$iv$iv >> 32);
        boolean $i$f$floatFromBits = false;
        int $this$dp$iv2 = 2;
        boolean $i$f$getDp2 = false;
        float barWidth = RangesKt.coerceAtLeast((float)((Float.intBitsToFloat(bits$iv$iv$iv) - totalSpacing) / (float)barCount), (float)$this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv2)));
        long arg0$iv2 = $this$Canvas.getSize-NH-jbRc();
        boolean bl2 = false;
        long value$iv$iv2 = arg0$iv2;
        boolean $i$f$unpackFloat2 = false;
        int bits$iv$iv$iv2 = (int)(value$iv$iv2 & 0xFFFFFFFFL);
        boolean $i$f$floatFromBits222 = false;
        float maxH = Float.intBitsToFloat(bits$iv$iv$iv2);
        for (int i = 0; i < barCount; ++i) {
            void width$iv;
            float x$iv;
            float f;
            float norm = (float)i / (float)barCount;
            float harmonic = RangesKt.coerceAtLeast((float)((float)Math.sin(norm * (float)Math.PI)), (float)0.15f);
            float waveMod = (float)Math.sin(norm * 4.2f + $phase * 2.5f) * 0.25f;
            if ($isPlaying) {
                $this$dp$iv = 3;
                $i$f$getDp = false;
                f = RangesKt.coerceIn((float)((harmonic + waveMod) * $pulse * maxH), (float)$this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)), (float)maxH);
            } else {
                $this$dp$iv = 2;
                $i$f$getDp = false;
                f = RangesKt.coerceAtLeast((float)(maxH * 0.12f * harmonic), (float)$this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)$this$dp$iv)));
            }
            float dynamicHeight = f;
            float x = (float)i * (barWidth + spacing);
            float y = maxH - dynamicHeight;
            Object[] $i$f$floatFromBits222 = new Color[]{Color.box-impl((long)ColorKt.Color((long)4294958963L)), Color.box-impl((long)ColorKt.Color((long)4294286859L)), Color.box-impl((long)ColorKt.Color((long)4290007817L))};
            float $i$f$floatFromBits222 = x;
            float y$iv = y;
            boolean $i$f$Offset = false;
            boolean $i$f$packFloats = false;
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            long l = Offset.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
            x$iv = barWidth;
            float height$iv = dynamicHeight;
            boolean $i$f$Size = false;
            $i$f$packFloats = false;
            v1$iv$iv = Float.floatToRawIntBits((float)width$iv);
            v2$iv$iv = Float.floatToRawIntBits(height$iv);
            long l2 = Size.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
            double $this$dp$iv3 = 1.5;
            boolean $i$f$getDp3 = false;
            y$iv = x$iv = $this$Canvas.toPx-0680j_4(Dp.constructor-impl((float)((float)$this$dp$iv3)));
            boolean $i$f$CornerRadius = false;
            $i$f$packFloats = false;
            v1$iv$iv = Float.floatToRawIntBits(x$iv);
            v2$iv$iv = Float.floatToRawIntBits(y$iv);
            DrawScope.drawRoundRect-ZuiqVtQ$default((DrawScope)$this$Canvas, (Brush)Brush.Companion.verticalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])$i$f$floatFromBits222), (float)y, (float)maxH, (int)0, (int)8, null), (long)l, (long)l2, (long)CornerRadius.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL)), (float)0.0f, null, null, (int)0, (int)240, null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit GothicSpectrumRow$lambda$64(boolean $isPlaying, float $pulse, float $phase, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        EchoScreensaverKt.GothicSpectrumRow($isPlaying, $pulse, $phase, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$EchoScreensaver$lambda$6(MutableState $currentTime$delegate, LocalDateTime localDateTime) {
        EchoScreensaverKt.EchoScreensaver$lambda$6((MutableState<LocalDateTime>)$currentTime$delegate, localDateTime);
    }
}

