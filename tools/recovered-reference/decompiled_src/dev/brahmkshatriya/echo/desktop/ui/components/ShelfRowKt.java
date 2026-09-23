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
 *  androidx.compose.material3.ButtonKt
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
 *  androidx.compose.runtime.Updater
 *  androidx.compose.runtime.internal.ComposableLambdaKt
 *  androidx.compose.ui.Alignment
 *  androidx.compose.ui.Alignment$Horizontal
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.unit.Dp
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

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
import androidx.compose.material3.ButtonKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$ShelfRowKt;
import dev.brahmkshatriya.echo.desktop.ui.components.MediaCardKt;
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRowKt$ShelfRow$lambda$16$lambda$11$lambda$10$;
import dev.brahmkshatriya.echo.desktop.ui.components.ShelfRowKt$ShelfRow$lambda$16$lambda$6$lambda$5$;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2={"ShelfRow", "", "shelf", "Ldev/brahmkshatriya/echo/common/models/Shelf;", "onMediaClick", "Lkotlin/Function1;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "onPlayTrack", "Ldev/brahmkshatriya/echo/common/models/Track;", "onMoreClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ldev/brahmkshatriya/echo/common/models/Shelf;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nShelfRow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShelfRow.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ShelfRowKt\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 3 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 4 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 5 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 6 Composer.kt\nandroidx/compose/runtime/Updater\n+ 7 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 8 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 9 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,105:1\n113#2:106\n113#2:144\n113#2:224\n113#2:225\n113#2:232\n113#2:233\n113#2:252\n87#3:107\n84#3,9:108\n87#3:178\n83#3,10:179\n94#3:219\n94#3:256\n79#4,6:117\n86#4,3:132\n89#4,2:141\n79#4,6:151\n86#4,3:166\n89#4,2:175\n79#4,6:189\n86#4,3:204\n89#4,2:213\n93#4:218\n93#4:222\n93#4:255\n347#5,9:123\n356#5:143\n347#5,9:157\n356#5:177\n347#5,9:195\n356#5,3:215\n357#5,2:220\n357#5,2:253\n4206#6,6:135\n4206#6,6:169\n4206#6,6:207\n99#7,6:145\n106#7:223\n1247#8,6:226\n1247#8,6:234\n1247#8,6:240\n1247#8,6:246\n168#9,13:257\n168#9,13:270\n*S KotlinDebug\n*F\n+ 1 ShelfRow.kt\ndev/brahmkshatriya/echo/desktop/ui/components/ShelfRowKt\n*L\n34#1:106\n37#1:144\n67#1:224\n68#1:225\n81#1:232\n82#1:233\n98#1:252\n34#1:107\n34#1:108,9\n41#1:178\n41#1:179,10\n41#1:219\n34#1:256\n34#1:117,6\n34#1:132,3\n34#1:141,2\n36#1:151,6\n36#1:166,3\n36#1:175,2\n41#1:189,6\n41#1:204,3\n41#1:213,2\n41#1:218\n36#1:222\n34#1:255\n34#1:123,9\n34#1:143\n36#1:157,9\n36#1:177\n41#1:195,9\n41#1:215,3\n36#1:220,2\n34#1:253,2\n34#1:135,6\n36#1:169,6\n41#1:207,6\n36#1:145,6\n36#1:223\n69#1:226,6\n83#1:234,6\n96#1:240,6\n97#1:246,6\n70#1:257,13\n84#1:270,13\n*E\n"})
public final class ShelfRowKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void ShelfRow(@NotNull Shelf shelf, @NotNull Function1<? super EchoMediaItem, Unit> onMediaClick, @NotNull Function1<? super Track, Unit> onPlayTrack, @Nullable Function0<Unit> onMoreClick, @Nullable Modifier modifier, @Nullable Composer $composer, int $changed, int n) {
        block47: {
            Intrinsics.checkNotNullParameter((Object)shelf, (String)"shelf");
            Intrinsics.checkNotNullParameter(onMediaClick, (String)"onMediaClick");
            Intrinsics.checkNotNullParameter(onPlayTrack, (String)"onPlayTrack");
            $composer = $composer.startRestartGroup(-610351689);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(ShelfRow)P(4,1,3,2)33@1229L2732:ShelfRow.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)shelf) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onMediaClick) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= $composer.changedInstance(onPlayTrack) ? 256 : 128;
            }
            if ((n & 8) != 0) {
                $dirty |= 0xC00;
            } else if (($changed & 0xC00) == 0) {
                $dirty |= $composer.changedInstance(onMoreClick) ? 2048 : 1024;
            }
            if ((n & 0x10) != 0) {
                $dirty |= 0x6000;
            } else if (($changed & 0x6000) == 0) {
                $dirty |= $composer.changed((Object)modifier) ? 16384 : 8192;
            }
            if ($composer.shouldExecute(($dirty & 0x2493) != 9362, $dirty & 1)) {
                void $composer2;
                void $changed$iv$iv$iv;
                void $changed$iv$iv;
                void modifier$iv$iv;
                void $composer$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv;
                void $changed$iv;
                void verticalAlignment$iv;
                void horizontalArrangement$iv;
                void $composer$iv2;
                void $composer4;
                void $changed$iv$iv$iv3;
                void $changed$iv$iv3;
                void modifier$iv$iv3;
                void modifier$iv2;
                void $composer$iv3;
                if ((n & 8) != 0) {
                    onMoreClick = null;
                }
                if ((n & 0x10) != 0) {
                    modifier = (Modifier)Modifier.Companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-610351689, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.ShelfRow (ShelfRow.kt:32)");
                }
                int $this$dp$iv22 = 12;
                boolean $i$f$getDp = false;
                Modifier $this$dp$iv22 = PaddingKt.padding-VpY3zN4$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)modifier, (float)0.0f, (int)1, null), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv22), (int)1, null);
                Composer composer = $composer;
                int $changed$iv2 = 0;
                boolean $i$f$Column = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void var16_18 = modifier$iv2;
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
                int n4 = 0xE & $changed$iv$iv$iv3 >> 6;
                void $composer$iv4 = $composer$iv3;
                boolean bl4 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n5 = 6 | 0x70 & $changed$iv2 >> 6;
                void var35_37 = $composer$iv4;
                ColumnScope $this$ShelfRow_u24lambda_u2416 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl5 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1439921431, (String)"C35@1332L1014:ShelfRow.kt#buhtxq");
                int $this$dp$iv = 24;
                boolean $i$f$getDp2 = false;
                float f = Dp.constructor-impl((float)$this$dp$iv);
                $this$dp$iv = 4;
                $i$f$getDp2 = false;
                Object object = PaddingKt.padding-VpY3zN4((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                Alignment.Vertical $this$dp$iv3 = Alignment.Companion.getCenterVertically();
                Arrangement.HorizontalOrVertical $i$f$getDp22 = Arrangement.INSTANCE.getSpaceBetween();
                Modifier modifier2 = object;
                Arrangement.Horizontal horizontal = (Arrangement.Horizontal)$i$f$getDp22;
                Alignment.Vertical vertical = $this$dp$iv3;
                void var44_66 = $composer4;
                int n6 = 438;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                void var48_78 = modifier$iv;
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
                void $composer$iv5 = $composer$iv2;
                boolean bl6 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv5, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n10 = 6 | 0x70 & $changed$iv >> 6;
                void var67_97 = $composer$iv5;
                RowScope $this$ShelfRow_u24lambda_u2416_u24lambda_u241 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl7 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-64401095, (String)"C40@1575L556:ShelfRow.kt#buhtxq");
                void var70_100 = $composer3;
                int $changed$iv3 = 0;
                boolean $i$f$Column2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                Modifier modifier$iv3 = (Modifier)Modifier.Companion;
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv2, (Alignment.Horizontal)horizontalAlignment$iv2, (Composer)$composer$iv, (int)(0xE & $changed$iv3 >> 3 | 0x70 & $changed$iv3 >> 3));
                Modifier modifier3 = modifier$iv3;
                int n11 = 0x70 & $changed$iv3 << 3;
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
                void $composer$iv6 = $composer$iv;
                $i$a$-Layout-ColumnKt$Column$1$iv = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv6, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                int n14 = 6 | 0x70 & $changed$iv3 >> 6;
                void var96_126 = $composer$iv6;
                ColumnScope $this$ShelfRow_u24lambda_u2416_u24lambda_u241_u24lambda_u240 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-95508105, (String)"C43@1688L10,41@1600L177:ShelfRow.kt#buhtxq");
                CharSequence charSequence = shelf.getTitle();
                TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleLarge();
                FontWeight fontWeight = FontWeight.Companion.getBold();
                TextKt.Text--4IGK_g((String)charSequence, null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196608, (int)0, (int)65502);
                if (shelf instanceof Shelf.Lists && !((charSequence = (CharSequence)((Shelf.Lists)shelf).getSubtitle()) == null || StringsKt.isBlank((CharSequence)charSequence))) {
                    $composer2.startReplaceGroup(-95260168);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"49@1981L10,50@2049L11,47@1880L219");
                    String string2 = ((Shelf.Lists)shelf).getSubtitle();
                    Intrinsics.checkNotNull((Object)string2);
                    charSequence = string2;
                    textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                    long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    TextKt.Text--4IGK_g((String)charSequence, null, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-97112325);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv6);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                if (onMoreClick != null) {
                    $composer3.startReplaceGroup(-63829301);
                    ComposerKt.sourceInformation((Composer)$composer3, (String)"56@2188L134");
                    ButtonKt.TextButton(onMoreClick, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$ShelfRowKt.INSTANCE.getLambda$-871005463$desktopApp(), (Composer)$composer3, (int)(0x30000000 | 0xE & $dirty >> 9), (int)510);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-65988079);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv5);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                object = shelf;
                if (object instanceof Shelf.Lists.Items) {
                    Object object2;
                    void $this$cache$iv;
                    $composer4.startReplaceGroup(1440948491);
                    ComposerKt.sourceInformation((Composer)$composer4, (String)"68@2621L351,65@2450L522");
                    Modifier modifier4 = null;
                    LazyListState lazyListState = null;
                    $this$dp$iv = 24;
                    $i$f$getDp = false;
                    PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default((float)Dp.constructor-impl((float)$this$dp$iv), (float)0.0f, (int)2, null);
                    boolean bl9 = false;
                    $this$dp$iv = 16;
                    $i$f$getDp = false;
                    Arrangement.Horizontal horizontal2 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv));
                    Alignment.Vertical vertical2 = null;
                    FlingBehavior flingBehavior = null;
                    boolean bl10 = false;
                    OverscrollEffect overscrollEffect = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1847603372, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    void $i$f$getDp3 = $composer4;
                    boolean invalid$iv = $composer.changedInstance((Object)shelf) | ($dirty & 0x70) == 32 | ($dirty & 0x380) == 256;
                    boolean $i$f$cache = false;
                    it$iv = $this$cache$iv.rememberedValue();
                    boolean bl11 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        OverscrollEffect overscrollEffect2 = overscrollEffect;
                        boolean bl12 = bl10;
                        FlingBehavior flingBehavior2 = flingBehavior;
                        Alignment.Vertical vertical3 = vertical2;
                        Arrangement.Horizontal horizontal3 = horizontal2;
                        boolean bl13 = bl9;
                        PaddingValues paddingValues2 = paddingValues;
                        LazyListState lazyListState2 = lazyListState;
                        Modifier modifier5 = modifier4;
                        boolean bl14 = false;
                        Function1 function1 = arg_0 -> ShelfRowKt.ShelfRow$lambda$16$lambda$6$lambda$5(shelf, onMediaClick, onPlayTrack, arg_0);
                        modifier4 = modifier5;
                        lazyListState = lazyListState2;
                        paddingValues = paddingValues2;
                        bl9 = bl13;
                        horizontal2 = horizontal3;
                        vertical2 = vertical3;
                        flingBehavior = flingBehavior2;
                        bl10 = bl12;
                        overscrollEffect = overscrollEffect2;
                        Function1 value$iv = function1;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object2 = value$iv;
                    } else {
                        object2 = it$iv;
                    }
                    Function1 $this$dp$iv4 = (Function1)object2;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    LazyDslKt.LazyRow(modifier4, lazyListState, (PaddingValues)paddingValues, (boolean)bl9, (Arrangement.Horizontal)horizontal2, vertical2, flingBehavior, (boolean)bl10, overscrollEffect, (Function1)$this$dp$iv4, (Composer)$composer4, (int)24960, (int)491);
                    $composer4.endReplaceGroup();
                } else if (object instanceof Shelf.Lists.Tracks) {
                    Object object3;
                    void $this$cache$iv;
                    $composer4.startReplaceGroup(1441534856);
                    ComposerKt.sourceInformation((Composer)$composer4, (String)"82@3213L322,79@3042L493");
                    Modifier modifier6 = null;
                    LazyListState lazyListState = null;
                    int $this$dp$iv5 = 24;
                    boolean $i$f$getDp4 = false;
                    PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default((float)Dp.constructor-impl((float)$this$dp$iv5), (float)0.0f, (int)2, null);
                    boolean bl15 = false;
                    $this$dp$iv5 = 16;
                    $i$f$getDp4 = false;
                    Arrangement.Horizontal horizontal4 = (Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv5));
                    Alignment.Vertical vertical4 = null;
                    FlingBehavior flingBehavior = null;
                    boolean bl16 = false;
                    OverscrollEffect overscrollEffect = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1847622287, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    void $i$f$getDp3 = $composer4;
                    boolean invalid$iv = $composer.changedInstance((Object)shelf) | ($dirty & 0x70) == 32 | ($dirty & 0x380) == 256;
                    boolean $i$f$cache = false;
                    it$iv = $this$cache$iv.rememberedValue();
                    boolean bl17 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        OverscrollEffect overscrollEffect3 = overscrollEffect;
                        boolean bl18 = bl16;
                        FlingBehavior flingBehavior3 = flingBehavior;
                        Alignment.Vertical vertical5 = vertical4;
                        Arrangement.Horizontal horizontal5 = horizontal4;
                        boolean bl19 = bl15;
                        PaddingValues paddingValues3 = paddingValues;
                        LazyListState lazyListState3 = lazyListState;
                        Modifier modifier7 = modifier6;
                        boolean bl20 = false;
                        Function1 function1 = arg_0 -> ShelfRowKt.ShelfRow$lambda$16$lambda$11$lambda$10(shelf, onMediaClick, onPlayTrack, arg_0);
                        modifier6 = modifier7;
                        lazyListState = lazyListState3;
                        paddingValues = paddingValues3;
                        bl15 = bl19;
                        horizontal4 = horizontal5;
                        vertical4 = vertical5;
                        flingBehavior = flingBehavior3;
                        bl16 = bl18;
                        overscrollEffect = overscrollEffect3;
                        Function1 value$iv = function1;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object3 = value$iv;
                    } else {
                        object3 = it$iv;
                    }
                    Function1 $this$dp$iv4 = (Function1)object3;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    LazyDslKt.LazyRow(modifier6, lazyListState, (PaddingValues)paddingValues, (boolean)bl15, (Arrangement.Horizontal)horizontal4, vertical4, flingBehavior, (boolean)bl16, overscrollEffect, (Function1)$this$dp$iv4, (Composer)$composer4, (int)24960, (int)491);
                    $composer4.endReplaceGroup();
                } else if (object instanceof Shelf.Item) {
                    Alignment.Vertical vertical6;
                    Object object4;
                    EchoMediaItem echoMediaItem;
                    $composer4.startReplaceGroup(1442079774);
                    ComposerKt.sourceInformation((Composer)$composer4, (String)"95@3679L29,93@3597L311");
                    EchoMediaItem echoMediaItem2 = ((Shelf.Item)shelf).getMedia();
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1847636906, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    Function0 $this$cache$iv = $composer4;
                    boolean invalid$iv2 = ($dirty & 0x70) == 32 | $composer.changedInstance((Object)shelf);
                    boolean $i$f$cache = false;
                    it$iv = $this$cache$iv.rememberedValue();
                    boolean bl21 = false;
                    if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                        echoMediaItem = echoMediaItem2;
                        boolean bl22 = false;
                        echoMediaItem2 = echoMediaItem;
                        Function0 value$iv = () -> ShelfRowKt.ShelfRow$lambda$16$lambda$13$lambda$12(onMediaClick, shelf);
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object4 = value$iv;
                    } else {
                        object4 = it$iv;
                    }
                    $this$dp$iv3 = (Function0)object4;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    Alignment.Vertical vertical7 = $this$dp$iv3;
                    if (((Shelf.Item)shelf).getMedia() instanceof Track) {
                        Object object5;
                        void $this$cache$iv2;
                        $composer4.startReplaceGroup(1442259884);
                        ComposerKt.sourceInformation((Composer)$composer4, (String)"96@3772L37");
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)1847639890, (String)"CC(remember):ShelfRow.kt#9igjgp");
                        void invalid$iv2 = $composer4;
                        boolean invalid$iv3 = ($dirty & 0x380) == 256 | $composer.changedInstance((Object)shelf);
                        boolean $i$f$cache2 = false;
                        Object it$iv = $this$cache$iv2.rememberedValue();
                        $i$a$-let-ComposerKt$cache$1$iv = false;
                        if (invalid$iv3 || it$iv == Composer.Companion.getEmpty()) {
                            Alignment.Vertical vertical8 = vertical7;
                            echoMediaItem = echoMediaItem2;
                            boolean bl23 = false;
                            Function0 function04 = () -> ShelfRowKt.ShelfRow$lambda$16$lambda$15$lambda$14(onPlayTrack, shelf);
                            echoMediaItem2 = echoMediaItem;
                            vertical7 = vertical8;
                            Function0 value$iv = function04;
                            $this$cache$iv2.updateRememberedValue((Object)value$iv);
                            object5 = value$iv;
                        } else {
                            object5 = it$iv;
                        }
                        $this$cache$iv = (Function0)object5;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                        $this$dp$iv3 = $this$cache$iv;
                        $composer4.endReplaceGroup();
                        vertical6 = $this$dp$iv3;
                    } else {
                        $composer4.startReplaceGroup(1442305360);
                        $composer4.endReplaceGroup();
                        vertical6 = null;
                    }
                    $this$dp$iv = 24;
                    $i$f$getDp = false;
                    MediaCardKt.MediaCard(echoMediaItem2, (Function0<Unit>)vertical7, vertical6, PaddingKt.padding-VpY3zN4$default((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv), (float)0.0f, (int)2, null), 0, 0, (Composer)$composer4, 3072, 48);
                    $composer4.endReplaceGroup();
                } else {
                    $composer4.startReplaceGroup(1442430291);
                    $composer4.endReplaceGroup();
                }
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
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block47;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> ShelfRowKt.ShelfRow$lambda$17(shelf, onMediaClick, onPlayTrack, onMoreClick, modifier, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit ShelfRow$lambda$16$lambda$6$lambda$5(Shelf $shelf, Function1 $onMediaClick, Function1 $onPlayTrack, LazyListScope $this$LazyRow) {
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyRow, (String)"$this$LazyRow");
        LazyListScope lazyListScope = $this$LazyRow;
        List<EchoMediaItem> items$iv = ((Shelf.Lists.Items)$shelf).getList();
        Object key$iv = null;
        Function1 contentType$iv = ShelfRow$lambda$16$lambda$6$lambda$5$$inlined$items$default$1.INSTANCE;
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
        }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $onMediaClick, $onPlayTrack){
            final /* synthetic */ List $items;
            final /* synthetic */ Function1 $onMediaClick$inlined;
            final /* synthetic */ Function1 $onPlayTrack$inlined;
            {
                this.$items = $items;
                this.$onMediaClick$inlined = function1;
                this.$onPlayTrack$inlined = function12;
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
                    Function0 function0;
                    Object object;
                    void var16_19;
                    void $this$cache$iv;
                    void item2;
                    void $composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int n = 0xE & $dirty;
                    Composer composer = $composer;
                    EchoMediaItem echoMediaItem = (EchoMediaItem)this.$items.get(it);
                    LazyItemScope $this$ShelfRow_u24lambda_u2416_u24lambda_u246_u24lambda_u245_u24lambda_u244 = $this$items;
                    boolean bl = false;
                    $composer2.startReplaceGroup(970017056);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"C*72@2786L22,70@2695L237:ShelfRow.kt#buhtxq");
                    void v0 = item2;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1769821748, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    Function0 function02 = $composer2;
                    boolean invalid$iv2 = $composer2.changed((Object)this.$onMediaClick$inlined) | $composer2.changedInstance((Object)item2);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl2 = false;
                    if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                        var16_19 = v0;
                        boolean bl3 = false;
                        v0 = var16_19;
                        Function0 value$iv = (Function0)new Function0<Unit>((Function1<? super EchoMediaItem, Unit>)this.$onMediaClick$inlined, (EchoMediaItem)item2){
                            final /* synthetic */ Function1<EchoMediaItem, Unit> $onMediaClick;
                            final /* synthetic */ EchoMediaItem $item;
                            {
                                this.$onMediaClick = $onMediaClick;
                                this.$item = $item;
                            }

                            public final void invoke() {
                                this.$onMediaClick.invoke((Object)this.$item);
                            }
                        };
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object = value$iv;
                    } else {
                        object = it$iv;
                    }
                    Function0 function03 = (Function0)object;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    Function0 function04 = function03;
                    if (item2 instanceof Track) {
                        Object object2;
                        void $this$cache$iv2;
                        $composer2.startReplaceGroup(970185075);
                        ComposerKt.sourceInformation((Composer)$composer2, (String)"73@2873L21");
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1769818965, (String)"CC(remember):ShelfRow.kt#9igjgp");
                        void invalid$iv2 = $composer2;
                        boolean invalid$iv3 = $composer2.changed((Object)this.$onPlayTrack$inlined) | $composer2.changedInstance((Object)item2);
                        boolean $i$f$cache2 = false;
                        Object it$iv2 = $this$cache$iv2.rememberedValue();
                        $i$a$-let-ComposerKt$cache$1$iv = false;
                        if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                            Function0 function05 = function04;
                            var16_19 = v0;
                            boolean bl4 = false;
                            Function0 function06 = (Function0)new Function0<Unit>((Function1<? super Track, Unit>)this.$onPlayTrack$inlined, (EchoMediaItem)item2){
                                final /* synthetic */ Function1<Track, Unit> $onPlayTrack;
                                final /* synthetic */ EchoMediaItem $item;
                                {
                                    this.$onPlayTrack = $onPlayTrack;
                                    this.$item = $item;
                                }

                                public final void invoke() {
                                    this.$onPlayTrack.invoke((Object)this.$item);
                                }
                            };
                            v0 = var16_19;
                            function04 = function05;
                            Function0 value$iv = function06;
                            $this$cache$iv2.updateRememberedValue((Object)value$iv);
                            object2 = value$iv;
                        } else {
                            object2 = it$iv2;
                        }
                        function02 = (Function0)object2;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        function03 = function02;
                        $composer2.endReplaceGroup();
                        function0 = function03;
                    } else {
                        $composer2.startReplaceGroup(970215175);
                        $composer2.endReplaceGroup();
                        function0 = null;
                    }
                    MediaCardKt.MediaCard((EchoMediaItem)v0, (Function0<Unit>)function04, function0, null, 0, 0, (Composer)$composer2, 0xE & $changed2 >> 3, 56);
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
    private static final Unit ShelfRow$lambda$16$lambda$11$lambda$10(Shelf $shelf, Function1 $onMediaClick, Function1 $onPlayTrack, LazyListScope $this$LazyRow) {
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyRow, (String)"$this$LazyRow");
        LazyListScope lazyListScope = $this$LazyRow;
        List<Track> items$iv = ((Shelf.Lists.Tracks)$shelf).getList();
        Object key$iv = null;
        Function1 contentType$iv = ShelfRow$lambda$16$lambda$11$lambda$10$$inlined$items$default$1.INSTANCE;
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
        }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>(items$iv, $onMediaClick, $onPlayTrack){
            final /* synthetic */ List $items;
            final /* synthetic */ Function1 $onMediaClick$inlined;
            final /* synthetic */ Function1 $onPlayTrack$inlined;
            {
                this.$items = $items;
                this.$onMediaClick$inlined = function1;
                this.$onPlayTrack$inlined = function12;
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
                    Object object2;
                    Function0 value$iv;
                    EchoMediaItem echoMediaItem;
                    void $this$cache$iv;
                    void track2;
                    void $composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    int n = 0xE & $dirty;
                    Composer composer = $composer;
                    Track track3 = (Track)this.$items.get(it);
                    LazyItemScope $this$ShelfRow_u24lambda_u2416_u24lambda_u2411_u24lambda_u2410_u24lambda_u249 = $this$items;
                    boolean bl = false;
                    $composer2.startReplaceGroup(-1126843282);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"C*86@3380L23,87@3447L22,84@3288L207:ShelfRow.kt#buhtxq");
                    EchoMediaItem echoMediaItem2 = (EchoMediaItem)track2;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)379294973, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    void var11_11 = $composer2;
                    boolean invalid$iv = $composer2.changed((Object)this.$onMediaClick$inlined) | $composer2.changedInstance((Object)track2);
                    boolean $i$f$cache = false;
                    Object it$iv = $this$cache$iv.rememberedValue();
                    boolean bl2 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        echoMediaItem = echoMediaItem2;
                        boolean bl3 = false;
                        echoMediaItem2 = echoMediaItem;
                        value$iv = (Function0)new Function0<Unit>((Function1<? super EchoMediaItem, Unit>)this.$onMediaClick$inlined, (Track)track2){
                            final /* synthetic */ Function1<EchoMediaItem, Unit> $onMediaClick;
                            final /* synthetic */ Track $track;
                            {
                                this.$onMediaClick = $onMediaClick;
                                this.$track = $track;
                            }

                            public final void invoke() {
                                this.$onMediaClick.invoke((Object)this.$track);
                            }
                        };
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object2 = value$iv;
                    } else {
                        object2 = it$iv;
                    }
                    Function0 function0 = (Function0)object2;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    Function0 function02 = function0;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)379297116, (String)"CC(remember):ShelfRow.kt#9igjgp");
                    $this$cache$iv = $composer2;
                    invalid$iv = $composer2.changed((Object)this.$onPlayTrack$inlined) | $composer2.changedInstance((Object)track2);
                    $i$f$cache = false;
                    it$iv = $this$cache$iv.rememberedValue();
                    bl2 = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Function0 function03 = function02;
                        echoMediaItem = echoMediaItem2;
                        boolean bl4 = false;
                        Function0 function04 = (Function0)new Function0<Unit>((Function1<? super Track, Unit>)this.$onPlayTrack$inlined, (Track)track2){
                            final /* synthetic */ Function1<Track, Unit> $onPlayTrack;
                            final /* synthetic */ Track $track;
                            {
                                this.$onPlayTrack = $onPlayTrack;
                                this.$track = $track;
                            }

                            public final void invoke() {
                                this.$onPlayTrack.invoke((Object)this.$track);
                            }
                        };
                        echoMediaItem2 = echoMediaItem;
                        function02 = function03;
                        value$iv = function04;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object = value$iv;
                    } else {
                        object = it$iv;
                    }
                    function0 = (Function0)object;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    MediaCardKt.MediaCard(echoMediaItem2, (Function0<Unit>)function02, (Function0<Unit>)function0, null, 0, 0, (Composer)$composer2, 0xE & $changed2 >> 3, 56);
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

    private static final Unit ShelfRow$lambda$16$lambda$13$lambda$12(Function1 $onMediaClick, Shelf $shelf) {
        $onMediaClick.invoke((Object)((Shelf.Item)$shelf).getMedia());
        return Unit.INSTANCE;
    }

    private static final Unit ShelfRow$lambda$16$lambda$15$lambda$14(Function1 $onPlayTrack, Shelf $shelf) {
        EchoMediaItem echoMediaItem = ((Shelf.Item)$shelf).getMedia();
        Intrinsics.checkNotNull((Object)echoMediaItem, (String)"null cannot be cast to non-null type dev.brahmkshatriya.echo.common.models.Track");
        $onPlayTrack.invoke((Object)((Track)echoMediaItem));
        return Unit.INSTANCE;
    }

    private static final Unit ShelfRow$lambda$17(Shelf $shelf, Function1 $onMediaClick, Function1 $onPlayTrack, Function0 $onMoreClick, Modifier $modifier, int $$changed, int $$default, Composer $composer, int $force) {
        ShelfRowKt.ShelfRow($shelf, (Function1<? super EchoMediaItem, Unit>)$onMediaClick, (Function1<? super Track, Unit>)$onPlayTrack, (Function0<Unit>)$onMoreClick, $modifier, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }
}

