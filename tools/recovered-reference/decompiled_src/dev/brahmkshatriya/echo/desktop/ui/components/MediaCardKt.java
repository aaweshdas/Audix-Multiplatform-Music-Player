/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.HoverableKt
 *  androidx.compose.foundation.interaction.HoverInteractionKt
 *  androidx.compose.foundation.interaction.InteractionSource
 *  androidx.compose.foundation.interaction.InteractionSourceKt
 *  androidx.compose.foundation.interaction.MutableInteractionSource
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Vertical
 *  androidx.compose.foundation.layout.BoxKt
 *  androidx.compose.foundation.layout.BoxScope
 *  androidx.compose.foundation.layout.BoxScopeInstance
 *  androidx.compose.foundation.layout.ColumnKt
 *  androidx.compose.foundation.layout.ColumnScope
 *  androidx.compose.foundation.layout.ColumnScopeInstance
 *  androidx.compose.foundation.layout.PaddingKt
 *  androidx.compose.foundation.layout.SizeKt
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.MusicNoteKt
 *  androidx.compose.material.icons.filled.PlayArrowKt
 *  androidx.compose.material3.CardColors
 *  androidx.compose.material3.CardDefaults
 *  androidx.compose.material3.CardElevation
 *  androidx.compose.material3.CardKt
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
 *  androidx.compose.runtime.State
 *  androidx.compose.runtime.Updater
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Horizontal
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
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.MusicNoteKt;
import androidx.compose.material.icons.filled.PlayArrowKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
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
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r\u00b2\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2={"MediaCard", "", "media", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "onClick", "Lkotlin/Function0;", "onPlayClick", "modifier", "Landroidx/compose/ui/Modifier;", "cardWidth", "", "imageHeight", "(Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;IILandroidx/compose/runtime/Composer;II)V", "desktopApp", "isHovered", ""})
@SourceDebugExtension(value={"SMAP\nMediaCard.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaCard.kt\ndev/brahmkshatriya/echo/desktop/ui/components/MediaCardKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 4 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 5 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 10 Box.kt\nandroidx/compose/foundation/layout/BoxKt\n*L\n1#1,144:1\n1247#2,6:145\n1247#2,6:151\n113#3:157\n113#3:158\n113#3:159\n113#3:161\n113#3:199\n113#3:201\n113#3:238\n113#3:239\n113#3:240\n113#3:277\n113#3:286\n85#4:160\n87#5:162\n84#5,9:163\n94#5:290\n79#6,6:172\n86#6,3:187\n89#6,2:196\n79#6,6:211\n86#6,3:226\n89#6,2:235\n79#6,6:250\n86#6,3:265\n89#6,2:274\n93#6:280\n93#6:284\n93#6:289\n347#7,9:178\n356#7:198\n347#7,9:217\n356#7:237\n347#7,9:256\n356#7:276\n357#7,2:278\n357#7,2:282\n357#7,2:287\n4206#8,6:190\n4206#8,6:229\n4206#8,6:268\n52#9:200\n70#10:202\n68#10,8:203\n70#10:241\n68#10,8:242\n77#10:281\n77#10:285\n*S KotlinDebug\n*F\n+ 1 MediaCard.kt\ndev/brahmkshatriya/echo/desktop/ui/components/MediaCardKt\n*L\n53#1:145,6\n56#1:151,6\n66#1:157\n69#1:158\n74#1:159\n76#1:161\n79#1:199\n80#1:201\n95#1:238\n105#1:239\n106#1:240\n116#1:277\n122#1:286\n54#1:160\n76#1:162\n76#1:163,9\n76#1:290\n76#1:172,6\n76#1:187,3\n76#1:196,2\n77#1:211,6\n77#1:226,3\n77#1:235,2\n102#1:250,6\n102#1:265,3\n102#1:274,2\n102#1:280\n77#1:284\n76#1:289\n76#1:178,9\n76#1:198\n77#1:217,9\n77#1:237\n102#1:256,9\n102#1:276\n102#1:278,2\n77#1:282,2\n76#1:287,2\n76#1:190,6\n77#1:229,6\n102#1:268,6\n79#1:200\n77#1:202\n77#1:203,8\n102#1:241\n102#1:242,8\n102#1:281\n77#1:285\n*E\n"})
public final class MediaCardKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void MediaCard(@NotNull EchoMediaItem media, @NotNull Function0<Unit> onClick2, @Nullable Function0<Unit> onPlayClick, @Nullable Modifier modifier, int cardWidth, int imageHeight, @Nullable Composer $composer, int $changed, int n) {
        block30: {
            Intrinsics.checkNotNullParameter((Object)media, (String)"media");
            Intrinsics.checkNotNullParameter(onClick2, (String)"onClick");
            $composer = $composer.startRestartGroup(2098093487);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(MediaCard)P(2,4,5,3)52@2152L39,53@2231L25,55@2277L230,69@2738L174,73@2947L63,74@3017L2619,63@2513L3123:MediaCard.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)media) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onClick2) ? 32 : 16;
            }
            if ((n & 4) != 0) {
                $dirty |= 0x180;
            } else if (($changed & 0x180) == 0) {
                $dirty |= $composer.changedInstance(onPlayClick) ? 256 : 128;
            }
            if ((n & 8) != 0) {
                $dirty |= 0xC00;
            } else if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 2048 : 1024;
            }
            if ((n & 0x10) != 0) {
                $dirty |= 0x6000;
            } else if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changed(cardWidth) ? 16384 : 8192;
            }
            if ((n & 0x20) != 0) {
                $dirty |= 0x30000;
            } else if (($changed & 0x30000) == 0) {
                $dirty |= $composer.changed(imageHeight) ? 131072 : 65536;
            }
            if ($composer.shouldExecute(($dirty & 0x12493) != 74898, $dirty & 1)) {
                float f;
                long l;
                Object object;
                void $this$cache$iv;
                Object object2;
                void $this$cache$iv2;
                if ((n & 4) != 0) {
                    onPlayClick = null;
                }
                if ((n & 8) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if ((n & 0x10) != 0) {
                    cardWidth = 160;
                }
                if ((n & 0x20) != 0) {
                    imageHeight = 160;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)2098093487, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.MediaCard (MediaCard.kt:51)");
                }
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1928186806, (String)"CC(remember):MediaCard.kt#9igjgp");
                Composer composer = $composer;
                boolean invalid$iv22 = false;
                boolean $i$f$cache22 = false;
                Object it$iv = $this$cache$iv2.rememberedValue();
                boolean bl = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl2 = false;
                    MutableInteractionSource value$iv = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableInteractionSource interactionSource = mutableInteractionSource;
                State isHovered$delegate = HoverInteractionKt.collectIsHoveredAsState((InteractionSource)((InteractionSource)interactionSource), (Composer)$composer, (int)6);
                ImageHolder invalid$iv22 = media.getCover();
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1928190997, (String)"CC(remember):MediaCard.kt#9igjgp");
                it$iv = $composer;
                boolean invalid$iv = $composer.changed((Object)invalid$iv22);
                boolean $i$f$cache = false;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl3 = false;
                    ImageHolder c = media.getCover();
                    String value$iv = c instanceof ImageHolder.NetworkRequestImageHolder ? ((ImageHolder.NetworkRequestImageHolder)c).getRequest().getUrl() : (c instanceof ImageHolder.ResourceUriImageHolder ? ((ImageHolder.ResourceUriImageHolder)c).getUri() : null);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv2;
                }
                String $i$f$cache22 = (String)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                String coverUrl = $i$f$cache22;
                int $this$dp$iv = cardWidth;
                boolean $i$f$getDp = false;
                Modifier modifier2 = ClickableKt.clickable-XHw0xAI$default((Modifier)HoverableKt.hoverable$default((Modifier)SizeKt.width-3ABfNKs((Modifier)modifier, (float)Dp.constructor-impl((float)$this$dp$iv)), (MutableInteractionSource)interactionSource, (boolean)false, (int)2, null), (boolean)false, null, null, onClick2, (int)7, null);
                $this$dp$iv = 12;
                $i$f$getDp = false;
                Shape shape = (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv));
                if (MediaCardKt.MediaCard$lambda$1((State<Boolean>)isHovered$delegate)) {
                    $composer.startReplaceGroup(1928208157);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"70@2808L11");
                    $this$dp$iv = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU();
                    $composer.endReplaceGroup();
                    l = $this$dp$iv;
                } else {
                    $composer.startReplaceGroup(1928210550);
                    ComposerKt.sourceInformation((Composer)$composer, (String)"71@2883L11");
                    $this$dp$iv = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurface-0d7_KjU();
                    $composer.endReplaceGroup();
                    l = $this$dp$iv;
                }
                CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(l, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                if (MediaCardKt.MediaCard$lambda$1((State<Boolean>)isHovered$delegate)) {
                    int $this$dp$iv2 = 4;
                    $i$f$getDp = false;
                    f = Dp.constructor-impl((float)$this$dp$iv2);
                } else {
                    boolean $this$dp$iv3 = false;
                    $i$f$getDp = false;
                    f = Dp.constructor-impl((float)((float)$this$dp$iv3));
                }
                CardKt.Card((Modifier)modifier2, (Shape)shape, (CardColors)cardColors, (CardElevation)CardDefaults.INSTANCE.cardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer, CardDefaults.$stable << 18, 62), null, (Function3)((Function3)ComposableLambdaKt.rememberComposableLambda((int)439829793, (boolean)true, (arg_0, arg_1, arg_2) -> MediaCardKt.MediaCard$lambda$7(cardWidth, imageHeight, media, coverUrl, onPlayClick, isHovered$delegate, arg_0, arg_1, arg_2), (Composer)$composer, (int)54)), (Composer)$composer, (int)196608, (int)16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block30;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> MediaCardKt.MediaCard$lambda$8(media, onClick2, onPlayClick, modifier, cardWidth, imageHeight, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean MediaCard$lambda$1(State<Boolean> $isHovered$delegate) {
        void $this$getValue$iv;
        State<Boolean> state = $isHovered$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit MediaCard$lambda$7(int $cardWidth, int $imageHeight, EchoMediaItem $media, String $coverUrl, Function0 $onPlayClick, State $isHovered$delegate, ColumnScope $this$Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter((Object)$this$Card, (String)"$this$Card");
        ComposerKt.sourceInformation((Composer)$composer, (String)"C75@3027L2603:MediaCard.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 0x11) != 16, $changed & 1)) {
            boolean $i$f$getDp;
            int $this$dp$iv;
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void modifier$iv;
            void contentAlignment$iv;
            void $composer$iv22;
            void other$iv;
            void arg0$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void modifier$iv2;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)439829793, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.MediaCard.<anonymous> (MediaCard.kt:75)");
            }
            int $this$dp$iv22 = 10;
            boolean $i$f$getDp2 = false;
            Modifier $this$dp$iv22 = PaddingKt.padding-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv22));
            Composer composer = $composer;
            int $changed$iv2 = 6;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            void var16_18 = modifier$iv2;
            int n = 0x70 & $changed$iv2 << 3;
            boolean $i$f$Layout = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv2);
            Function0 function0 = ComposeUiNode.Companion.getConstructor();
            int n2 = 6 | 0x380 & $changed$iv$iv2 << 6;
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
            int n3 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv3 = $composer$iv;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv2 >> 6;
            void var35_37 = $composer$iv3;
            ColumnScope $this$MediaCard_u24lambda_u247_u24lambda_u246 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-469238215, (String)"C80@3276L11,76@3073L1894,121@4981L29,125@5104L10,123@5024L245:MediaCard.kt#buhtxq");
            int $this$dp$iv32 = $cardWidth;
            boolean $i$f$getDp3 = false;
            float $this$dp$iv32 = Dp.constructor-impl((float)$this$dp$iv32);
            int $this$dp$iv42 = 20;
            boolean $i$f$getDp4 = false;
            float $this$dp$iv42 = Dp.constructor-impl((float)$this$dp$iv42);
            boolean bl6 = false;
            int $this$dp$iv5 = $imageHeight;
            $i$f$getDp = false;
            Modifier modifier = SizeKt.size-VpY3zN4((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)(arg0$iv - other$iv)), (float)Dp.constructor-impl((float)$this$dp$iv5));
            $this$dp$iv5 = 8;
            $i$f$getDp = false;
            Modifier $this$dp$iv52 = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)modifier, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv5)))), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), null, (int)2, null);
            Alignment $i$f$getDp22 = Alignment.Companion.getCenter();
            void var41_54 = $composer3;
            int n5 = 48;
            boolean $i$f$Box = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            boolean propagateMinConstraints$iv22 = false;
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv, (boolean)propagateMinConstraints$iv22);
            void var45_60 = modifier$iv;
            int n6 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv22, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv22.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv22, (Modifier)modifier$iv$iv);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
            int n7 = 6 | 0x380 & $changed$iv$iv << 6;
            boolean $i$f$ReusableComposeNode2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv22, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!($composer$iv22.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv22.startReusableNode();
            if ($composer$iv22.getInserting()) {
                void factory$iv$iv$iv;
                $composer$iv22.createNode((Function0)factory$iv$iv$iv);
            } else {
                $composer$iv22.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv22);
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
            void $composer$iv4 = $composer$iv22;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
            int n9 = 6 | 0x70 & $changed$iv >> 6;
            void var64_80 = $composer$iv4;
            BoxScope $this$MediaCard_u24lambda_u247_u24lambda_u246_u24lambda_u244 = (BoxScope)BoxScopeInstance.INSTANCE;
            boolean bl8 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)578948202, (String)"C:MediaCard.kt#buhtxq");
            if ($coverUrl != null) {
                $composer2.startReplaceGroup(578930500);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"84@3433L249");
                SingletonAsyncImageKt.AsyncImage-10Xjiaw((Object)$coverUrl, (String)$media.getTitle(), (Modifier)SizeKt.fillMaxSize$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), null, null, null, (ContentScale)ContentScale.Companion.getCrop(), (float)0.0f, null, (int)0, (boolean)false, (Composer)$composer2, (int)0x180180, (int)0, (int)1976);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(579223853);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"95@3950L11,91@3728L272");
                $this$dp$iv = 48;
                $i$f$getDp = false;
                IconKt.Icon-ww6aTOc((ImageVector)MusicNoteKt.getMusicNote((Icons.Filled)Icons.INSTANCE.getDefault()), null, (Modifier)SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU(), (Composer)$composer2, (int)432, (int)0);
                $composer2.endReplaceGroup();
            }
            if (MediaCardKt.MediaCard$lambda$1((State<Boolean>)$isHovered$delegate) && $onPlayClick != null) {
                void $composer4;
                void $changed$iv$iv$iv3;
                void $changed$iv$iv3;
                void modifier$iv$iv3;
                void $changed$iv3;
                void modifier$iv3;
                void contentAlignment$iv2;
                void $composer$iv5;
                $composer2.startReplaceGroup(579652614);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"107@4434L11,101@4144L791");
                $this$dp$iv = 8;
                $i$f$getDp = false;
                Modifier modifier2 = PaddingKt.padding-3ABfNKs((Modifier)$this$MediaCard_u24lambda_u247_u24lambda_u246_u24lambda_u244.align((Modifier)Modifier.Companion, Alignment.Companion.getBottomEnd()), (float)Dp.constructor-impl((float)$this$dp$iv));
                $this$dp$iv = 38;
                $i$f$getDp = false;
                Modifier $this$dp$iv6 = ClickableKt.clickable-XHw0xAI$default((Modifier)BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)SizeKt.size-3ABfNKs((Modifier)modifier2, (float)Dp.constructor-impl((float)$this$dp$iv)), (Shape)((Shape)RoundedCornerShapeKt.getCircleShape())), (long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getPrimary-0d7_KjU(), null, (int)2, null), (boolean)false, null, null, (Function0)$onPlayClick, (int)7, null);
                Alignment $i$f$getDp32 = Alignment.Companion.getCenter();
                void var69_87 = $composer2;
                int n10 = 48;
                boolean $i$f$Box2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1042775818, (String)"CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                boolean propagateMinConstraints$iv = false;
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy((Alignment)contentAlignment$iv2, (boolean)propagateMinConstraints$iv);
                void var74_92 = modifier$iv3;
                int n11 = 0x70 & $changed$iv3 << 3;
                boolean $i$f$Layout3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv5, (int)0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier((Composer)$composer$iv5, (Modifier)modifier$iv$iv3);
                Function0 function03 = ComposeUiNode.Companion.getConstructor();
                int n12 = 6 | 0x380 & $changed$iv$iv3 << 6;
                boolean $i$f$ReusableComposeNode3 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)-553112988, (String)"CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!($composer$iv5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv5.startReusableNode();
                if ($composer$iv5.getInserting()) {
                    void factory$iv$iv$iv;
                    $composer$iv5.createNode((Function0)factory$iv$iv$iv);
                } else {
                    $composer$iv5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl((Composer)$composer$iv5);
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
                int n13 = 0xE & $changed$iv$iv$iv3 >> 6;
                void $composer$iv6 = $composer$iv5;
                $i$a$-Layout-BoxKt$Box$1$iv = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)1833054614, (String)"C72@3468L9:Box.kt#2w3rfo");
                int n14 = 6 | 0x70 & $changed$iv3 >> 6;
                void var93_111 = $composer$iv6;
                BoxScope $this$MediaCard_u24lambda_u247_u24lambda_u246_u24lambda_u244_u24lambda_u243 = (BoxScope)BoxScopeInstance.INSTANCE;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1219566831, (String)"C114@4805L11,111@4626L287:MediaCard.kt#buhtxq");
                ImageVector imageVector = PlayArrowKt.getPlayArrow((Icons.Filled)Icons.INSTANCE.getDefault());
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getOnPrimary-0d7_KjU();
                int $this$dp$iv7 = 22;
                boolean $i$f$getDp5 = false;
                Modifier modifier3 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv7));
                IconKt.Icon-ww6aTOc((ImageVector)imageVector, (String)"Play", (Modifier)modifier3, (long)l, (Composer)$composer4, (int)432, (int)0);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                $composer$iv5.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(575536837);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
            $composer$iv22.endNode();
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv22);
            $this$dp$iv = 8;
            $i$f$getDp = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv)), (Composer)$composer3, (int)6);
            String string2 = $media.getTitle();
            TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getBodyMedium();
            FontWeight propagateMinConstraints$iv22 = FontWeight.Companion.getSemiBold();
            int $composer$iv22 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            TextKt.Text--4IGK_g((String)string2, null, (long)0L, (long)0L, null, (FontWeight)propagateMinConstraints$iv22, null, (long)0L, null, null, (long)0L, (int)$composer$iv22, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle, (Composer)$composer3, (int)196608, (int)3120, (int)55262);
            string2 = $media.getSubtitle();
            if (string2 == null) {
                $composer3.startReplaceGroup(-467099031);
                $composer3.endReplaceGroup();
                v2 = null;
            } else {
                $composer3.startReplaceGroup(-467099030);
                ComposerKt.sourceInformation((Composer)$composer3, (String)"*134@5408L10,135@5472L11,132@5328L278");
                String sub = string2;
                boolean bl10 = false;
                TextStyle textStyle2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer3, MaterialTheme.$stable).getBodySmall();
                long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                int n15 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                TextKt.Text--4IGK_g((String)sub, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)n15, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle2, (Composer)$composer3, (int)0, (int)3120, (int)55290);
                $composer3.endReplaceGroup();
                v2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
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
        return Unit.INSTANCE;
    }

    private static final Unit MediaCard$lambda$8(EchoMediaItem $media, Function0 $onClick, Function0 $onPlayClick, Modifier $modifier, int $cardWidth, int $imageHeight, int $$changed, int $$default, Composer $composer, int $force) {
        MediaCardKt.MediaCard($media, (Function0<Unit>)$onClick, (Function0<Unit>)$onPlayClick, $modifier, $cardWidth, $imageHeight, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }
}

