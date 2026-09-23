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
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.RowKt
 *  androidx.compose.foundation.layout.RowScope
 *  androidx.compose.foundation.layout.RowScopeInstance
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.runtime.Applier
 *  androidx.compose.runtime.Composable
 *  androidx.compose.runtime.ComposableTarget
 *  androidx.compose.runtime.ComposablesKt
 *  androidx.compose.runtime.Composer
 *  androidx.compose.runtime.ComposerKt
 *  androidx.compose.runtime.CompositionLocalMap
 *  androidx.compose.runtime.RecomposeScopeImplKt
 *  androidx.compose.runtime.ScopeUpdateScope
 *  androidx.compose.runtime.State
 *  androidx.compose.runtime.Updater
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.draw.ClipKt
 *  androidx.compose.ui.graphics.Brush
 *  androidx.compose.ui.graphics.Brush$Companion
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f\u00b2\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0012\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0013\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002\u00b2\u0006\n\u0010\u0015\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2={"SoundVisualizerBars", "", "isPlaying", "", "modifier", "Landroidx/compose/ui/Modifier;", "barCount", "", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "barWidth", "barColor", "Landroidx/compose/ui/graphics/Color;", "SoundVisualizerBars-2cEk1AI", "(ZLandroidx/compose/ui/Modifier;IFFJLandroidx/compose/runtime/Composer;II)V", "desktopApp", "anim1", "", "anim2", "anim3", "anim4", "anim5"})
@SourceDebugExtension(value={"SMAP\nSoundVisualizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundVisualizer.kt\ndev/brahmkshatriya/echo/desktop/ui/components/SoundVisualizerKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 8 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n*L\n1#1,91:1\n113#2:92\n113#2:93\n113#2:94\n113#2:129\n113#2:130\n99#3,6:95\n106#3:134\n79#4,6:101\n86#4,3:116\n89#4,2:125\n93#4:133\n347#5,9:107\n356#5:127\n357#5,2:131\n4206#6,6:119\n66#7:128\n85#8:135\n85#8:136\n85#8:137\n85#8:138\n85#8:139\n*S KotlinDebug\n*F\n+ 1 SoundVisualizer.kt\ndev/brahmkshatriya/echo/desktop/ui/components/SoundVisualizerKt\n*L\n32#1:92\n33#1:93\n68#1:94\n77#1:129\n78#1:130\n66#1:95,6\n66#1:134\n66#1:101,6\n66#1:116,3\n66#1:125,2\n66#1:133\n66#1:107,9\n66#1:127\n66#1:131,2\n66#1:119,6\n73#1:128\n38#1:135\n43#1:136\n48#1:137\n53#1:138\n58#1:139\n*E\n"})
public final class SoundVisualizerKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void SoundVisualizerBars-2cEk1AI(boolean isPlaying2, @Nullable Modifier modifier, int barCount, float maxHeight, float barWidth, long barColor, @Nullable Composer $composer, int $changed, int n) {
        block31: {
            $composer = $composer.startRestartGroup(1602310169);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(SoundVisualizerBars)P(3,5,1,4:c#ui.unit.Dp,2:c#ui.unit.Dp,0:c#ui.graphics.Color)35@1383L28,37@1441L207,42@1677L208,47@1914L206,52@2149L209,57@2387L207,65@2663L836:SoundVisualizer.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(isPlaying2) ? 4 : 2;
            }
            if ((n & 2) != 0) {
                $dirty |= 0x30;
            } else if (($changed & 0x30) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 32 : 16;
            }
            if ((n & 4) != 0) {
                $dirty |= 0x180;
            } else if (($changed & 0x180) == 0) {
                $dirty |= $composer.changed(barCount) ? 256 : 128;
            }
            if ((n & 8) != 0) {
                $dirty |= 0xC00;
            } else if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed(maxHeight) ? 2048 : 1024;
            }
            if ((n & 0x10) != 0) {
                $dirty |= 0x6000;
            } else if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changed(barWidth) ? 16384 : 8192;
            }
            if (($changed & 0x30000) == 0) {
                $dirty |= (n & 0x20) == 0 && $composer.changed(barColor) ? 131072 : 65536;
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
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"33@1338L11");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    boolean $i$f$getDp;
                    int $this$dp$iv;
                    if ((n & 2) != 0) {
                        modifier = (Modifier)Modifier.Companion;
                    }
                    if ((n & 4) != 0) {
                        barCount = 5;
                    }
                    if ((n & 8) != 0) {
                        $this$dp$iv = 16;
                        $i$f$getDp = false;
                        maxHeight = Dp.constructor-impl((float)$this$dp$iv);
                    }
                    if ((n & 0x10) != 0) {
                        $this$dp$iv = 3;
                        $i$f$getDp = false;
                        barWidth = Dp.constructor-impl((float)$this$dp$iv);
                    }
                    if ((n & 0x20) != 0) {
                        barColor = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        $dirty &= 0xFFF8FFFF;
                    }
                } else {
                    $composer.skipToGroupEnd();
                    if ((n & 0x20) != 0) {
                        $dirty &= 0xFFF8FFFF;
                    }
                }
                $composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)1602310169, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.SoundVisualizerBars (SoundVisualizer.kt:34)");
                }
                InfiniteTransition transition = InfiniteTransitionKt.rememberInfiniteTransition(null, (Composer)$composer, (int)0, (int)1);
                State anim1$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)transition, (float)0.2f, (float)(isPlaying2 ? 0.95f : 0.2f), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)420, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State anim2$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)transition, (float)0.15f, (float)(isPlaying2 ? 0.8f : 0.15f), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)310, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State anim3$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)transition, (float)0.3f, (float)(isPlaying2 ? 1.0f : 0.3f), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)560, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State anim4$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)transition, (float)0.25f, (float)(isPlaying2 ? 0.75f : 0.25f), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)380, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                State anim5$delegate = InfiniteTransitionKt.animateFloat((InfiniteTransition)transition, (float)0.1f, (float)(isPlaying2 ? 0.85f : 0.1f), (InfiniteRepeatableSpec)AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)((DurationBasedAnimationSpec)AnimationSpecKt.tween$default((int)490, (int)0, (Easing)EasingKt.getFastOutSlowInEasing(), (int)2, null)), (RepeatMode)RepeatMode.Reverse, (long)0L, (int)4, null), null, (Composer)$composer, (int)(0x30 | InfiniteTransition.$stable | InfiniteRepeatableSpec.$stable << 9), (int)8);
                Float[] floatArray = new Float[]{Float.valueOf(SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$0((State<Float>)anim1$delegate)), Float.valueOf(SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$1((State<Float>)anim2$delegate)), Float.valueOf(SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$2((State<Float>)anim3$delegate)), Float.valueOf(SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$3((State<Float>)anim4$delegate)), Float.valueOf(SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$4((State<Float>)anim5$delegate))};
                List fractions = CollectionsKt.listOf((Object[])floatArray);
                floatArray = modifier;
                int $this$dp$iv22 = 2;
                boolean $i$f$getDp22 = false;
                Arrangement.Horizontal $this$dp$iv22 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv22));
                Alignment.Vertical $i$f$getDp22 = Alignment.Companion.getBottom();
                Composer composer = $composer;
                int n2 = 0x1B0 | 0xE & $dirty >> 3;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var25_28 = modifier$iv;
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
                void var44_47 = $composer$iv2;
                RowScope $this$SoundVisualizerBars_2cEk1AI_u24lambda_u245 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-2069601821, (String)"C:SoundVisualizer.kt#buhtxq");
                $composer2.startReplaceGroup(1180164640);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"*73@2983L500");
                for (int i = 0; i < barCount; ++i) {
                    void arg0$iv;
                    float fraction = isPlaying2 ? ((Number)fractions.get(i % fractions.size())).floatValue() : 0.2f;
                    float f = maxHeight;
                    float other$iv = fraction;
                    boolean bl6 = false;
                    float h = Dp.constructor-impl((float)(arg0$iv * other$iv));
                    int $this$dp$iv = 3;
                    boolean $i$f$getDp = false;
                    Modifier modifier2 = SizeKt.height-3ABfNKs((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)barWidth), (float)((Dp)RangesKt.coerceAtLeast((Comparable)Dp.box-impl((float)h), (Comparable)Dp.box-impl((float)Dp.constructor-impl((float)$this$dp$iv)))).unbox-impl());
                    $this$dp$iv = 2;
                    $i$f$getDp = false;
                    Object[] objectArray = new Color[]{Color.box-impl((long)barColor), Color.box-impl((long)Color.copy-wmQWz5c$default((long)barColor, (float)0.6f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null))};
                    BoxKt.Box((Modifier)BackgroundKt.background$default((Modifier)ClipKt.clip((Modifier)modifier2, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv)))), (Brush)Brush.Companion.verticalGradient-8A-3gB4$default((Brush.Companion)Brush.Companion, (List)CollectionsKt.listOf((Object[])objectArray), (float)0.0f, (float)0.0f, (int)0, (int)14, null), null, (float)0.0f, (int)6, null), (Composer)$composer2, (int)0);
                }
                $composer2.endReplaceGroup();
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
            if (scopeUpdateScope == null) break block31;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> SoundVisualizerKt.SoundVisualizerBars_2cEk1AI$lambda$6(isPlaying2, (Modifier)modifier, barCount, maxHeight, barWidth, barColor, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final float SoundVisualizerBars_2cEk1AI$lambda$0(State<Float> $anim1$delegate) {
        void $this$getValue$iv;
        State<Float> state = $anim1$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float SoundVisualizerBars_2cEk1AI$lambda$1(State<Float> $anim2$delegate) {
        void $this$getValue$iv;
        State<Float> state = $anim2$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float SoundVisualizerBars_2cEk1AI$lambda$2(State<Float> $anim3$delegate) {
        void $this$getValue$iv;
        State<Float> state = $anim3$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float SoundVisualizerBars_2cEk1AI$lambda$3(State<Float> $anim4$delegate) {
        void $this$getValue$iv;
        State<Float> state = $anim4$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final float SoundVisualizerBars_2cEk1AI$lambda$4(State<Float> $anim5$delegate) {
        void $this$getValue$iv;
        State<Float> state = $anim5$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return ((Number)$this$getValue$iv.getValue()).floatValue();
    }

    private static final Unit SoundVisualizerBars_2cEk1AI$lambda$6(boolean $isPlaying, Modifier $modifier, int $barCount, float $maxHeight, float $barWidth, long $barColor, int $$changed, int $$default, Composer $composer, int $force) {
        SoundVisualizerKt.SoundVisualizerBars-2cEk1AI($isPlaying, $modifier, $barCount, $maxHeight, $barWidth, $barColor, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }
}

