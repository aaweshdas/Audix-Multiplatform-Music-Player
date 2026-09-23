/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.foundation.BackgroundKt
 *  androidx.compose.foundation.ClickableKt
 *  androidx.compose.foundation.OverscrollEffect
 *  androidx.compose.foundation.gestures.FlingBehavior
 *  androidx.compose.foundation.layout.Arrangement
 *  androidx.compose.foundation.layout.Arrangement$Horizontal
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
 *  androidx.compose.foundation.layout.SpacerKt
 *  androidx.compose.foundation.lazy.LazyDslKt
 *  androidx.compose.foundation.lazy.LazyItemScope
 *  androidx.compose.foundation.lazy.LazyListScope
 *  androidx.compose.foundation.lazy.LazyListState
 *  androidx.compose.foundation.shape.RoundedCornerShapeKt
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.CheckKt
 *  androidx.compose.material.icons.filled.PlaylistAddKt
 *  androidx.compose.material.icons.filled.QueueMusicKt
 *  androidx.compose.material3.AlertDialog_skikoKt
 *  androidx.compose.material3.ButtonKt
 *  androidx.compose.material3.DividerKt
 *  androidx.compose.material3.IconKt
 *  androidx.compose.material3.MaterialTheme
 *  androidx.compose.material3.OutlinedTextFieldKt
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
 *  androidx.compose.ui.Alignment$Vertical
 *  androidx.compose.ui.ComposedModifierKt
 *  androidx.compose.ui.Modifier
 *  androidx.compose.ui.draw.ClipKt
 *  androidx.compose.ui.graphics.Color
 *  androidx.compose.ui.graphics.ColorKt
 *  androidx.compose.ui.graphics.Shape
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  androidx.compose.ui.layout.MeasurePolicy
 *  androidx.compose.ui.node.ComposeUiNode
 *  androidx.compose.ui.semantics.Role
 *  androidx.compose.ui.text.TextStyle
 *  androidx.compose.ui.text.font.FontWeight
 *  androidx.compose.ui.text.style.TextOverflow
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
 *  kotlin.reflect.KClass
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.koin.compose.KoinApplicationKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 */
package dev.brahmkshatriya.echo.desktop.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material.icons.filled.PlaylistAddKt;
import androidx.compose.material.icons.filled.QueueMusicKt;
import androidx.compose.material3.AlertDialog_skikoKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.desktop.library.DesktopLibraryManager;
import dev.brahmkshatriya.echo.desktop.library.StoredTrack;
import dev.brahmkshatriya.echo.desktop.library.UserPlaylist;
import dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialogKt$AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33$;
import dev.brahmkshatriya.echo.desktop.ui.components.ComposableSingletons$AddToPlaylistDialogKt;
import java.util.Collection;
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
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.compose.KoinApplicationKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t\u00b2\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u008a\u0084\u0002\u00b2\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002\u00b2\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002\u00b2\u0006\n\u0010\u0011\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2={"AddToPlaylistDialog", "", "track", "Ldev/brahmkshatriya/echo/common/models/Track;", "onDismiss", "Lkotlin/Function0;", "libraryManager", "Ldev/brahmkshatriya/echo/desktop/library/DesktopLibraryManager;", "(Ldev/brahmkshatriya/echo/common/models/Track;Lkotlin/jvm/functions/Function0;Ldev/brahmkshatriya/echo/desktop/library/DesktopLibraryManager;Landroidx/compose/runtime/Composer;II)V", "desktopApp", "playlists", "", "Ldev/brahmkshatriya/echo/desktop/library/UserPlaylist;", "isCreatingNew", "", "newTitle", "", "newDescription"})
@SourceDebugExtension(value={"SMAP\nAddToPlaylistDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AddToPlaylistDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/AddToPlaylistDialogKt\n+ 2 Inject.kt\norg/koin/compose/InjectKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n+ 4 SnapshotState.kt\nandroidx/compose/runtime/SnapshotStateKt__SnapshotStateKt\n+ 5 Row.kt\nandroidx/compose/foundation/layout/RowKt\n+ 6 Layout.kt\nandroidx/compose/ui/layout/LayoutKt\n+ 7 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 8 Composer.kt\nandroidx/compose/runtime/Updater\n+ 9 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 10 Column.kt\nandroidx/compose/foundation/layout/ColumnKt\n+ 11 LazyDsl.kt\nandroidx/compose/foundation/lazy/LazyDslKt\n*L\n1#1,245:1\n88#2,4:246\n92#2:253\n1247#3,3:250\n1250#3,3:254\n1247#3,6:257\n1247#3,6:263\n1247#3,6:269\n1247#3,6:423\n1247#3,6:430\n1247#3,6:473\n1247#3,6:480\n1247#3,6:490\n1247#3,6:501\n85#4:275\n85#4:276\n113#4,2:277\n85#4:279\n113#4,2:280\n85#4:282\n113#4,2:283\n99#5:285\n95#5,10:286\n106#5:370\n99#5:437\n97#5,8:438\n106#5:489\n79#6,6:296\n86#6,3:311\n89#6,2:320\n79#6,6:336\n86#6,3:351\n89#6,2:360\n93#6:365\n93#6:369\n79#6,6:394\n86#6,3:409\n89#6,2:418\n79#6,6:446\n86#6,3:461\n89#6,2:470\n93#6:488\n93#6:509\n347#7,9:302\n356#7:322\n347#7,9:342\n356#7,3:362\n357#7,2:367\n347#7,9:400\n356#7:420\n347#7,9:452\n356#7:472\n357#7,2:486\n357#7,2:507\n4206#8,6:314\n4206#8,6:354\n4206#8,6:412\n4206#8,6:464\n113#9:323\n113#9:324\n113#9:421\n113#9:422\n113#9:429\n113#9:436\n113#9:479\n113#9:496\n113#9:497\n113#9:498\n113#9:499\n113#9:500\n87#10:325\n83#10,10:326\n94#10:366\n87#10:384\n84#10,9:385\n94#10:510\n168#11,13:371\n*S KotlinDebug\n*F\n+ 1 AddToPlaylistDialog.kt\ndev/brahmkshatriya/echo/desktop/ui/components/AddToPlaylistDialogKt\n*L\n56#1:246,4\n56#1:253\n56#1:250,3\n56#1:254,3\n59#1:257,6\n60#1:263,6\n61#1:269,6\n104#1:423,6\n113#1:430,6\n124#1:473,6\n129#1:480,6\n143#1:490,6\n165#1:501,6\n58#1:275\n59#1:276\n59#1:277,2\n60#1:279\n60#1:280,2\n61#1:282\n61#1:283,2\n66#1:285\n66#1:286,10\n66#1:370\n120#1:437\n120#1:438,8\n120#1:489\n66#1:296,6\n66#1:311,3\n66#1:320,2\n74#1:336,6\n74#1:351,3\n74#1:360,2\n74#1:365\n66#1:369\n91#1:394,6\n91#1:409,3\n91#1:418,2\n120#1:446,6\n120#1:461,3\n120#1:470,2\n120#1:488\n91#1:509\n66#1:302,9\n66#1:322\n74#1:342,9\n74#1:362,3\n66#1:367,2\n91#1:400,9\n91#1:420\n120#1:452,9\n120#1:472\n120#1:486,2\n91#1:507,2\n66#1:314,6\n74#1:354,6\n91#1:412,6\n120#1:464,6\n71#1:323\n73#1:324\n93#1:421\n101#1:422\n110#1:429\n119#1:436\n127#1:479\n145#1:496\n152#1:497\n159#1:498\n163#1:499\n164#1:500\n74#1:325\n74#1:326,10\n74#1:366\n91#1:384\n91#1:385,9\n91#1:510\n166#1:371,13\n*E\n"})
public final class AddToPlaylistDialogKt {
    /*
     * WARNING - void declaration
     */
    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    public static final void AddToPlaylistDialog(@NotNull Track track2, @NotNull Function0<Unit> onDismiss, @Nullable DesktopLibraryManager libraryManager, @Nullable Composer $composer, int $changed, int n) {
        block19: {
            Intrinsics.checkNotNullParameter((Object)track2, (String)"track");
            Intrinsics.checkNotNullParameter(onDismiss, (String)"onDismiss");
            $composer = $composer.startRestartGroup(-65197099);
            ComposerKt.sourceInformation((Composer)$composer, (String)"C(AddToPlaylistDialog)P(2,1)57@2494L16,58@2536L34,59@2591L31,60@2649L31,235@11585L161,64@2753L979,89@3749L7810,62@2686L9066:AddToPlaylistDialog.kt#buhtxq");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changedInstance((Object)track2) ? 4 : 2;
            }
            if (($changed & 0x30) == 0) {
                $dirty |= $composer.changedInstance(onDismiss) ? 32 : 16;
            }
            if (($changed & 0x180) == 0) {
                $dirty |= (n & 4) == 0 && $composer.changedInstance((Object)libraryManager) ? 256 : 128;
            }
            if ($composer.shouldExecute(($dirty & 0x93) != 146, $dirty & 1)) {
                Object object;
                void $this$cache$iv;
                Object object2;
                void $this$cache$iv2;
                Object object3;
                MutableState $this$cache$iv3;
                MutableState $composer$iv;
                $composer.startDefaults();
                ComposerKt.sourceInformation((Composer)$composer, (String)"55@2431L12");
                if (($changed & 1) == 0 || $composer.getDefaultsInvalid()) {
                    if ((n & 4) != 0) {
                        Object object4;
                        void $this$cache$iv$iv;
                        Composer composer = $composer;
                        boolean $changed$iv = false;
                        boolean $i$f$koinInject = false;
                        $composer$iv.startReplaceGroup(-1168520582);
                        Qualifier qualifier$iv = null;
                        Scope scope$iv = KoinApplicationKt.currentKoinScope((Composer)$composer$iv, (int)0);
                        $composer$iv.startReplaceGroup(-1633490746);
                        void var12_14 = $composer$iv;
                        boolean invalid$iv$iv = $composer$iv.changed(qualifier$iv) | $composer$iv.changed((Object)scope$iv);
                        boolean $i$f$cache = false;
                        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                        boolean bl = false;
                        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                            boolean bl2 = false;
                            Object value$iv$iv = Scope.get$default((Scope)scope$iv, (KClass)Reflection.getOrCreateKotlinClass(DesktopLibraryManager.class), qualifier$iv, null, (int)4, null);
                            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            object4 = value$iv$iv;
                        } else {
                            object4 = it$iv$iv;
                        }
                        Object object5 = object4;
                        $composer$iv.endReplaceGroup();
                        Object object6 = object5;
                        $composer$iv.endReplaceGroup();
                        libraryManager = (DesktopLibraryManager)object6;
                        $dirty &= 0xFFFFFC7F;
                    }
                } else {
                    $composer.skipToGroupEnd();
                    if ((n & 4) != 0) {
                        $dirty &= 0xFFFFFC7F;
                    }
                }
                $composer.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart((int)-65197099, (int)$dirty, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialog (AddToPlaylistDialog.kt:56)");
                }
                State playlists$delegate = SnapshotStateKt.collectAsState(libraryManager.getPlaylists(), null, (Composer)$composer, (int)0, (int)1);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1770104727, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                Composer $changed$iv = $composer;
                boolean invalid$iv22 = false;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv3.rememberedValue();
                boolean bl = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl3 = false;
                    MutableState value$iv = SnapshotStateKt.mutableStateOf$default((Object)false, null, (int)2, null);
                    $this$cache$iv3.updateRememberedValue((Object)value$iv);
                    object3 = value$iv;
                } else {
                    object3 = it$iv;
                }
                $composer$iv = (MutableState)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableState isCreatingNew$delegate = $composer$iv;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1770106484, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                Composer invalid$iv22 = $composer;
                boolean invalid$iv32 = false;
                boolean $i$f$cache2 = false;
                Object it$iv2 = $this$cache$iv2.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl4 = false;
                    MutableState value$iv = SnapshotStateKt.mutableStateOf$default((Object)"", null, (int)2, null);
                    $this$cache$iv2.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv2;
                }
                $this$cache$iv3 = (MutableState)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableState newTitle$delegate = $this$cache$iv3;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer, (int)1770108340, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                Composer invalid$iv32 = $composer;
                boolean invalid$iv = false;
                boolean $i$f$cache3 = false;
                Object it$iv3 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    boolean bl5 = false;
                    MutableState value$iv = SnapshotStateKt.mutableStateOf$default((Object)"", null, (int)2, null);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv3;
                }
                MutableState mutableState = (MutableState)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer);
                MutableState newDescription$delegate = mutableState;
                AlertDialog_skikoKt.AlertDialog-Oix01E0(onDismiss, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-1706538979, (boolean)true, (arg_0, arg_1) -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$10(onDismiss, isCreatingNew$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), null, null, null, (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-709425375, (boolean)true, (arg_0, arg_1) -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$13(track2, arg_0, arg_1), (Composer)$composer, (int)54)), (Function2)((Function2)ComposableLambdaKt.rememberComposableLambda((int)-460146974, (boolean)true, (arg_0, arg_1) -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36(playlists$delegate, track2, libraryManager, onDismiss, isCreatingNew$delegate, newTitle$delegate, newDescription$delegate, arg_0, arg_1), (Composer)$composer, (int)54)), null, (long)0L, (long)0L, (long)0L, (long)0L, (float)0.0f, null, (Composer)$composer, (int)(0x1B0030 | 0xE & $dirty >> 3), (int)0, (int)16284);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer.skipToGroupEnd();
            }
            ScopeUpdateScope scopeUpdateScope = $composer.endRestartGroup();
            if (scopeUpdateScope == null) break block19;
            scopeUpdateScope.updateScope((arg_0, arg_1) -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$37(track2, onDismiss, libraryManager, $changed, n, arg_0, arg_1));
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final List<UserPlaylist> AddToPlaylistDialog$lambda$0(State<? extends List<UserPlaylist>> $playlists$delegate) {
        void $this$getValue$iv;
        State<? extends List<UserPlaylist>> state = $playlists$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (List)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final boolean AddToPlaylistDialog$lambda$2(MutableState<Boolean> $isCreatingNew$delegate) {
        void $this$getValue$iv;
        State state = (State)$isCreatingNew$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (Boolean)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void AddToPlaylistDialog$lambda$3(MutableState<Boolean> $isCreatingNew$delegate, boolean bl) {
        void $this$setValue$iv;
        MutableState<Boolean> mutableState = $isCreatingNew$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        Boolean value$iv = bl;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    /*
     * WARNING - void declaration
     */
    private static final String AddToPlaylistDialog$lambda$5(MutableState<String> $newTitle$delegate) {
        void $this$getValue$iv;
        State state = (State)$newTitle$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void AddToPlaylistDialog$lambda$6(MutableState<String> $newTitle$delegate, String string2) {
        void $this$setValue$iv;
        MutableState<String> mutableState = $newTitle$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        String value$iv = string2;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    /*
     * WARNING - void declaration
     */
    private static final String AddToPlaylistDialog$lambda$8(MutableState<String> $newDescription$delegate) {
        void $this$getValue$iv;
        State state = (State)$newDescription$delegate;
        Object var2_2 = null;
        Object property$iv = null;
        boolean $i$f$getValue = false;
        return (String)$this$getValue$iv.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private static final void AddToPlaylistDialog$lambda$9(MutableState<String> $newDescription$delegate, String string2) {
        void $this$setValue$iv;
        MutableState<String> mutableState = $newDescription$delegate;
        Object var3_3 = null;
        Object var4_4 = null;
        String value$iv = string2;
        boolean $i$f$setValue = false;
        $this$setValue$iv.setValue((Object)value$iv);
    }

    @Composable
    @ComposableTarget(applier="androidx.compose.ui.UiComposable")
    private static final Unit AddToPlaylistDialog$lambda$10(Function0 $onDismiss, MutableState $isCreatingNew$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C:AddToPlaylistDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-1706538979, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialog.<anonymous> (AddToPlaylistDialog.kt:236)");
            }
            if (!AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$2((MutableState<Boolean>)$isCreatingNew$delegate)) {
                $composer.startReplaceGroup(25196720);
                ComposerKt.sourceInformation((Composer)$composer, (String)"237@11637L85");
                ButtonKt.TextButton((Function0)$onDismiss, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$1773814133$desktopApp(), (Composer)$composer, (int)0x30000000, (int)510);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(13666053);
                $composer.endReplaceGroup();
            }
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
    private static final Unit AddToPlaylistDialog$lambda$13(Track $track, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C65@2767L955:AddToPlaylistDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void $changed$iv;
            void $composer$iv;
            void $composer3;
            void $changed$iv$iv$iv2;
            void $changed$iv$iv2;
            void modifier$iv$iv2;
            void verticalAlignment$iv;
            void $composer$iv2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-709425375, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialog.<anonymous> (AddToPlaylistDialog.kt:65)");
            }
            Alignment.Vertical vertical = Alignment.Companion.getCenterVertically();
            Composer composer = $composer;
            int $changed$iv2 = 384;
            boolean $i$f$Row = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            Modifier modifier$iv = (Modifier)Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
            Modifier modifier = modifier$iv;
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
            int n3 = 0xE & $changed$iv$iv$iv2 >> 6;
            void $composer$iv3 = $composer$iv2;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv2 >> 6;
            void var29_29 = $composer$iv3;
            RowScope $this$AddToPlaylistDialog_u24lambda_u2413_u24lambda_u2412 = (RowScope)RowScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-977307753, (String)"C69@2978L11,66@2837L231,72@3085L29,73@3131L577:AddToPlaylistDialog.kt#buhtxq");
            ImageVector imageVector = PlaylistAddKt.getPlaylistAdd((Icons.Filled)Icons.INSTANCE.getDefault());
            long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int $this$dp$iv = 28;
            boolean $i$f$getDp = false;
            Modifier modifier2 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv));
            IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier2, (long)l, (Composer)$composer3, (int)432, (int)0);
            int $this$dp$iv2 = 10;
            boolean $i$f$getDp2 = false;
            SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv2)), (Composer)$composer3, (int)6);
            modifier2 = $composer3;
            $this$dp$iv = 0;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier modifier$iv2 = (Modifier)Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            Modifier modifier3 = modifier$iv2;
            int n5 = 0x70 & $changed$iv << 3;
            boolean $i$f$Layout2 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
            CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
            Function0 function02 = ComposeUiNode.Companion.getConstructor();
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
            boolean bl6 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n8 = 6 | 0x70 & $changed$iv >> 6;
            void var60_62 = $composer$iv4;
            ColumnScope $this$AddToPlaylistDialog_u24lambda_u2413_u24lambda_u2412_u24lambda_u2411 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl7 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-286860778, (String)"C76@3262L10,74@3160L199,81@3476L10,82@3544L11,79@3380L310:AddToPlaylistDialog.kt#buhtxq");
            Object object = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleLarge();
            FontWeight fontWeight = FontWeight.Companion.getBold();
            TextKt.Text--4IGK_g((String)"Add to Playlist", null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)object, (Composer)$composer2, (int)196614, (int)0, (int)65502);
            object = $track.getTitle();
            fontWeight = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
            long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
            int n9 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
            TextKt.Text--4IGK_g((String)object, null, (long)l2, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)n9, (boolean)false, (int)1, (int)0, null, (TextStyle)fontWeight, (Composer)$composer2, (int)0, (int)3120, (int)55290);
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
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$15$lambda$14(MutableState $newTitle$delegate, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$6((MutableState<String>)$newTitle$delegate, it);
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$17$lambda$16(MutableState $newDescription$delegate, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$9((MutableState<String>)$newDescription$delegate, it);
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$22$lambda$19$lambda$18(MutableState $isCreatingNew$delegate) {
        AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$3((MutableState<Boolean>)$isCreatingNew$delegate, false);
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$22$lambda$21$lambda$20(DesktopLibraryManager $libraryManager, Track $track, Function0 $onDismiss, MutableState $newTitle$delegate, MutableState $newDescription$delegate) {
        if (!StringsKt.isBlank((CharSequence)AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$5((MutableState<String>)$newTitle$delegate))) {
            UserPlaylist pl = $libraryManager.createPlaylist(((Object)StringsKt.trim((CharSequence)AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$5((MutableState<String>)$newTitle$delegate))).toString(), ((Object)StringsKt.trim((CharSequence)AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$8((MutableState<String>)$newDescription$delegate))).toString());
            $libraryManager.addTrackToPlaylist(pl.getId(), $track);
            $onDismiss.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$24$lambda$23(MutableState $isCreatingNew$delegate) {
        AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$3((MutableState<Boolean>)$isCreatingNew$delegate, true);
        return Unit.INSTANCE;
    }

    private static final Object AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33$lambda$25(UserPlaylist it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.getId();
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33(State $playlists$delegate, DesktopLibraryManager $libraryManager, Track $track, Function0 $onDismiss, LazyListScope $this$LazyColumn) {
        void items$iv;
        void $this$items_u24default$iv;
        Intrinsics.checkNotNullParameter((Object)$this$LazyColumn, (String)"$this$LazyColumn");
        LazyListScope lazyListScope = $this$LazyColumn;
        List<UserPlaylist> list2 = AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$0((State<? extends List<UserPlaylist>>)$playlists$delegate);
        Function1 key$iv = AddToPlaylistDialogKt::AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33$lambda$25;
        Function1 contentType$iv = AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33$$inlined$items$default$1.INSTANCE;
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
        }, (Function4)ComposableLambdaKt.composableLambdaInstance((int)802480018, (boolean)true, (Object)new Function4<LazyItemScope, Integer, Composer, Integer, Unit>((List)items$iv, $libraryManager, $track, $onDismiss){
            final /* synthetic */ List $items;
            final /* synthetic */ DesktopLibraryManager $libraryManager$inlined;
            final /* synthetic */ Track $track$inlined;
            final /* synthetic */ Function0 $onDismiss$inlined;
            {
                this.$items = $items;
                this.$libraryManager$inlined = desktopLibraryManager;
                this.$track$inlined = track2;
                this.$onDismiss$inlined = function0;
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
                    void $composer2;
                    int $changed$iv$iv$iv;
                    Function0 factory$iv$iv$iv;
                    int $changed$iv$iv;
                    Modifier modifier$iv$iv;
                    Modifier modifier$iv;
                    void $composer$iv;
                    long l;
                    void $composer3;
                    void $changed$iv$iv$iv2;
                    void $changed$iv$iv2;
                    void modifier$iv$iv2;
                    void modifier$iv2;
                    void $changed$iv;
                    void verticalAlignment$iv;
                    void $composer$iv2;
                    Object object;
                    Function0 value$iv;
                    void $this$cache$iv;
                    boolean bl;
                    void pl;
                    void $composer4;
                    block29: {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart((int)802480018, (int)$dirty, (int)-1, (String)"androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                        }
                        int n = 0xE & $dirty;
                        Composer composer = $composer;
                        UserPlaylist userPlaylist = (UserPlaylist)this.$items.get(it);
                        LazyItemScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432 = $this$items;
                        boolean bl2 = false;
                        $composer4.startReplaceGroup(-1642655272);
                        ComposerKt.sourceInformation((Composer)$composer4, (String)"C*171@7809L11,172@7907L312,167@7553L3886:AddToPlaylistDialog.kt#buhtxq");
                        Iterable $this$any$iv = pl.getTracks();
                        boolean $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl = false;
                        } else {
                            for (T element$iv : $this$any$iv) {
                                StoredTrack it2 = (StoredTrack)element$iv;
                                boolean bl3 = false;
                                if (!Intrinsics.areEqual((Object)it2.getId(), (Object)this.$track$inlined.getId())) continue;
                                bl = true;
                                break block29;
                            }
                            bl = false;
                        }
                    }
                    boolean isAlreadyAdded = bl;
                    int $this$dp$iv22 = 10;
                    boolean $i$f$getDp22 = false;
                    Modifier modifier = BackgroundKt.background-bw27NRU$default((Modifier)ClipKt.clip((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv22)))), (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer4, MaterialTheme.$stable).getSurfaceVariant-0d7_KjU(), (float)0.5f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), null, (int)2, null);
                    boolean bl4 = false;
                    String string2 = null;
                    Role role = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer4, (int)-1299904356, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                    void $i$f$getDp22 = $composer4;
                    boolean invalid$iv22 = $composer4.changed(isAlreadyAdded) | $composer4.changedInstance((Object)this.$libraryManager$inlined) | $composer4.changedInstance((Object)pl) | $composer4.changedInstance((Object)this.$track$inlined) | $composer4.changed((Object)this.$onDismiss$inlined);
                    boolean $i$f$cache22 = false;
                    Object it$iv22 = $this$cache$iv.rememberedValue();
                    boolean bl5 = false;
                    if (invalid$iv22 || it$iv22 == Composer.Companion.getEmpty()) {
                        Role role2 = role;
                        String string3 = string2;
                        boolean bl6 = bl4;
                        Modifier modifier2 = modifier;
                        boolean bl7 = false;
                        Function0 function0 = (Function0)new Function0<Unit>(isAlreadyAdded, this.$libraryManager$inlined, (UserPlaylist)pl, this.$track$inlined, (Function0<Unit>)this.$onDismiss$inlined){
                            final /* synthetic */ boolean $isAlreadyAdded;
                            final /* synthetic */ DesktopLibraryManager $libraryManager;
                            final /* synthetic */ UserPlaylist $pl;
                            final /* synthetic */ Track $track;
                            final /* synthetic */ Function0<Unit> $onDismiss;
                            {
                                this.$isAlreadyAdded = $isAlreadyAdded;
                                this.$libraryManager = $libraryManager;
                                this.$pl = $pl;
                                this.$track = $track;
                                this.$onDismiss = $onDismiss;
                            }

                            public final void invoke() {
                                if (!this.$isAlreadyAdded) {
                                    this.$libraryManager.addTrackToPlaylist(this.$pl.getId(), this.$track);
                                    this.$onDismiss.invoke();
                                }
                            }
                        };
                        modifier = modifier2;
                        bl4 = bl6;
                        string2 = string3;
                        role = role2;
                        value$iv = function0;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object = value$iv;
                    } else {
                        object = it$iv22;
                    }
                    Function0 $this$dp$iv22 = (Function0)object;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer4);
                    int $this$dp$iv = 14;
                    boolean $i$f$getDp = false;
                    float f = Dp.constructor-impl((float)$this$dp$iv);
                    $this$dp$iv = 10;
                    $i$f$getDp = false;
                    Modifier $this$dp$iv3 = PaddingKt.padding-VpY3zN4((Modifier)ClickableKt.clickable-XHw0xAI$default((Modifier)modifier, (boolean)bl4, string2, role, (Function0)$this$dp$iv22, (int)7, null), (float)f, (float)Dp.constructor-impl((float)$this$dp$iv));
                    Alignment.Vertical invalid$iv22 = Alignment.Companion.getCenterVertically();
                    void $i$f$cache22 = $composer4;
                    int it$iv22 = 384;
                    boolean $i$f$Row = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv2, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
                    value$iv = modifier$iv2;
                    int n = 0x70 & $changed$iv << 3;
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
                    void $composer$iv3 = $composer$iv2;
                    boolean bl11 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                    int n4 = 6 | 0x70 & $changed$iv >> 6;
                    void var43_56 = $composer$iv3;
                    RowScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432_u24lambda_u2431 = (RowScope)RowScopeInstance.INSTANCE;
                    boolean bl12 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-644437403, (String)"C181@8463L373,187@8873L29,188@8939L868:AddToPlaylistDialog.kt#buhtxq");
                    ImageVector imageVector = QueueMusicKt.getQueueMusic((Icons.Filled)Icons.INSTANCE.getDefault());
                    if (isAlreadyAdded) {
                        $composer3.startReplaceGroup(1503236017);
                        $composer3.endReplaceGroup();
                        l = ColorKt.Color((long)4283215696L);
                    } else {
                        $composer3.startReplaceGroup(1503237575);
                        ComposerKt.sourceInformation((Composer)$composer3, (String)"184@8706L11");
                        long l2 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer3, MaterialTheme.$stable).getPrimary-0d7_KjU();
                        $composer3.endReplaceGroup();
                        l = l2;
                    }
                    long l3 = l;
                    int $this$dp$iv4 = 24;
                    boolean $i$f$getDp3 = false;
                    Modifier modifier3 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv4));
                    IconKt.Icon-ww6aTOc((ImageVector)imageVector, null, (Modifier)modifier3, (long)l3, (Composer)$composer3, (int)432, (int)0);
                    int $this$dp$iv422 = 12;
                    boolean $i$f$getDp4 = false;
                    SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv422)), (Composer)$composer3, (int)6);
                    Modifier $this$dp$iv422 = RowScope.weight$default((RowScope)$this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432_u24lambda_u2431, (Modifier)((Modifier)Modifier.Companion), (float)1.0f, (boolean)false, (int)2, null);
                    modifier3 = $composer3;
                    int $changed$iv2 = 0;
                    boolean $i$f$Column = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                    void var57_75 = modifier$iv;
                    int n5 = 0x70 & $changed$iv2 << 3;
                    boolean $i$f$Layout2 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv, (int)0);
                    CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv, (Modifier)modifier$iv$iv);
                    Function0 function02 = ComposeUiNode.Companion.getConstructor();
                    int n6 = 6 | 0x380 & $changed$iv$iv << 6;
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
                    int n7 = 0xE & $changed$iv$iv$iv >> 6;
                    void $composer$iv4 = $composer$iv;
                    boolean bl13 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
                    int n8 = 6 | 0x70 & $changed$iv2 >> 6;
                    void var76_94 = $composer$iv4;
                    ColumnScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432_u24lambda_u2431_u24lambda_u2428 = (ColumnScope)ColumnScopeInstance.INSTANCE;
                    boolean bl14 = false;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1017351135, (String)"C191@9142L10,189@9009L410,198@9611L10,199@9699L11,196@9460L309:AddToPlaylistDialog.kt#buhtxq");
                    Object object2 = pl.getTitle();
                    TextStyle textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
                    FontWeight fontWeight = FontWeight.Companion.getSemiBold();
                    int n9 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    TextKt.Text--4IGK_g((String)object2, null, (long)0L, (long)0L, null, (FontWeight)fontWeight, null, (long)0L, null, null, (long)0L, (int)n9, (boolean)false, (int)1, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)196608, (int)3120, (int)55262);
                    object2 = pl.getTracks().size() + " tracks";
                    textStyle = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodySmall();
                    long l4 = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    TextKt.Text--4IGK_g((String)object2, null, (long)l4, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle, (Composer)$composer2, (int)0, (int)0, (int)65530);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                    $composer$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                    if (isAlreadyAdded) {
                        void verticalAlignment$iv2;
                        $composer3.startReplaceGroup(-643106450);
                        ComposerKt.sourceInformation((Composer)$composer3, (String)"203@9906L964");
                        horizontalAlignment$iv = Alignment.Companion.getCenterVertically();
                        $composer$iv = $composer3;
                        $changed$iv2 = 384;
                        boolean $i$f$Row2 = false;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                        modifier$iv = (Modifier)Modifier.Companion;
                        horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv2, (Composer)$composer$iv, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                        modifier$iv$iv = modifier$iv;
                        $changed$iv$iv = 0x70 & $changed$iv2 << 3;
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
                        $i$a$-Layout-RowKt$Row$1$iv = false;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                        int $changed2 = 6 | 0x70 & $changed$iv2 >> 6;
                        $composer2 = $composer$iv4;
                        RowScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2434_u24lambda_u2433_u24lambda_u2432_u24lambda_u2431_u24lambda_u2429 = (RowScope)RowScopeInstance.INSTANCE;
                        boolean bl15 = false;
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)1686691242, (String)"C204@10004L352,210@10401L28,213@10607L10,211@10474L354:AddToPlaylistDialog.kt#buhtxq");
                        object2 = CheckKt.getCheck((Icons.Filled)Icons.INSTANCE.getDefault());
                        long l5 = ColorKt.Color((long)4283215696L);
                        int $this$dp$iv5 = 18;
                        boolean $i$f$getDp5 = false;
                        Modifier modifier4 = SizeKt.size-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv5));
                        IconKt.Icon-ww6aTOc((ImageVector)object2, (String)"Added", (Modifier)modifier4, (long)l5, (Composer)$composer2, (int)3504, (int)0);
                        int $this$dp$iv6 = 4;
                        boolean $i$f$getDp6 = false;
                        SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6)), (Composer)$composer2, (int)6);
                        TextStyle textStyle2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getLabelMedium();
                        l5 = ColorKt.Color((long)4283215696L);
                        modifier4 = FontWeight.Companion.getBold();
                        TextKt.Text--4IGK_g((String)"Added", null, (long)l5, (long)0L, null, (FontWeight)modifier4, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)textStyle2, (Composer)$composer2, (int)196998, (int)0, (int)65498);
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv);
                        $composer3.endReplaceGroup();
                    } else {
                        Object object3;
                        void $this$cache$iv2;
                        $composer3.startReplaceGroup(-642081993);
                        ComposerKt.sourceInformation((Composer)$composer3, (String)"220@11022L203,219@10956L411");
                        ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)1503311499, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                        horizontalArrangement$iv = $composer3;
                        boolean invalid$iv = $composer3.changedInstance((Object)this.$libraryManager$inlined) | $composer3.changedInstance((Object)pl) | $composer3.changedInstance((Object)this.$track$inlined) | $composer3.changed((Object)this.$onDismiss$inlined);
                        boolean $i$f$cache = false;
                        Object it$iv = $this$cache$iv2.rememberedValue();
                        $i$a$-let-ComposerKt$cache$1$iv = false;
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            boolean bl16 = false;
                            Function0 value$iv2 = (Function0)new Function0<Unit>(this.$libraryManager$inlined, (UserPlaylist)pl, this.$track$inlined, (Function0<Unit>)this.$onDismiss$inlined){
                                final /* synthetic */ DesktopLibraryManager $libraryManager;
                                final /* synthetic */ UserPlaylist $pl;
                                final /* synthetic */ Track $track;
                                final /* synthetic */ Function0<Unit> $onDismiss;
                                {
                                    this.$libraryManager = $libraryManager;
                                    this.$pl = $pl;
                                    this.$track = $track;
                                    this.$onDismiss = $onDismiss;
                                }

                                public final void invoke() {
                                    this.$libraryManager.addTrackToPlaylist(this.$pl.getId(), this.$track);
                                    this.$onDismiss.invoke();
                                }
                            };
                            $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                            object3 = value$iv2;
                        } else {
                            object3 = it$iv;
                        }
                        Function0 function03 = (Function0)object3;
                        ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                        ButtonKt.TextButton((Function0)function03, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-1465736481$desktopApp(), (Composer)$composer3, (int)0x30000000, (int)510);
                        $composer3.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv2);
                    $composer4.endReplaceGroup();
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
    private static final Unit AddToPlaylistDialog$lambda$36(State $playlists$delegate, Track $track, DesktopLibraryManager $libraryManager, Function0 $onDismiss, MutableState $isCreatingNew$delegate, MutableState $newTitle$delegate, MutableState $newDescription$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation((Composer)$composer, (String)"C90@3763L7786:AddToPlaylistDialog.kt#buhtxq");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            void $composer2;
            void $changed$iv$iv$iv;
            void $changed$iv$iv;
            void modifier$iv$iv;
            void modifier$iv;
            void $composer$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart((int)-460146974, (int)$changed, (int)-1, (String)"dev.brahmkshatriya.echo.desktop.ui.components.AddToPlaylistDialog.<anonymous> (AddToPlaylistDialog.kt:90)");
            }
            Modifier modifier = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
            Composer composer = $composer;
            int $changed$iv = 6;
            boolean $i$f$Column = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv, (int)1341605231, (String)"CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy((Arrangement.Vertical)verticalArrangement$iv, (Alignment.Horizontal)horizontalAlignment$iv, (Composer)$composer$iv, (int)(0xE & $changed$iv >> 3 | 0x70 & $changed$iv >> 3));
            void var16_16 = modifier$iv;
            int n = 0x70 & $changed$iv << 3;
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
            boolean bl2 = false;
            Composer $this$set_impl_u24lambda_u240$iv$iv$iv = $this$Layout_u24lambda_u240$iv$iv;
            boolean bl3 = false;
            if ($this$set_impl_u24lambda_u240$iv$iv$iv.getInserting() || !Intrinsics.areEqual((Object)$this$set_impl_u24lambda_u240$iv$iv$iv.rememberedValue(), (Object)compositeKeyHash$iv$iv)) {
                $this$set_impl_u24lambda_u240$iv$iv$iv.updateRememberedValue((Object)compositeKeyHash$iv$iv);
                $this$Layout_u24lambda_u240$iv$iv.apply((Object)compositeKeyHash$iv$iv, block$iv$iv$iv);
            }
            Updater.set-impl((Composer)$this$Layout_u24lambda_u240$iv$iv, (Object)materialized$iv$iv, (Function2)ComposeUiNode.Companion.getSetModifier());
            int n3 = 0xE & $changed$iv$iv$iv >> 6;
            void $composer$iv2 = $composer$iv;
            boolean bl4 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv2, (int)2093002350, (String)"C89@4556L9:Column.kt#2w3rfo");
            int n4 = 6 | 0x70 & $changed$iv >> 6;
            void var35_35 = $composer$iv2;
            ColumnScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435 = (ColumnScope)ColumnScopeInstance.INSTANCE;
            boolean bl5 = false;
            ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1557643135, (String)"C91@3853L11,91@3813L86,92@3916L30:AddToPlaylistDialog.kt#buhtxq");
            DividerKt.HorizontalDivider-9IZ8Weo(null, (float)0.0f, (long)Color.copy-wmQWz5c$default((long)MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOutlineVariant-0d7_KjU(), (float)0.3f, (float)0.0f, (float)0.0f, (float)0.0f, (int)14, null), (Composer)$composer2, (int)0, (int)3);
            int $this$dp$iv2 = 12;
            boolean $i$f$getDp2 = false;
            SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv2)), (Composer)$composer2, (int)6);
            if (AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$2((MutableState<Boolean>)$isCreatingNew$delegate)) {
                Object object;
                Object object2;
                Function0 value$iv;
                void $this$cache$iv;
                void $composer3;
                void $changed$iv$iv$iv2;
                void $changed$iv$iv2;
                void modifier$iv$iv2;
                void modifier$iv2;
                void $changed$iv2;
                void horizontalArrangement$iv;
                void $composer$iv3;
                Object object3;
                int n5;
                Object object4;
                Function1 value$iv2;
                String string2;
                void $this$cache$iv2;
                $composer2.startReplaceGroup(-1557645244);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"97@4104L10,95@4005L201,100@4227L29,103@4378L17,101@4277L386,109@4684L29,112@4841L23,110@4734L397,118@5152L30,119@5203L976");
                TextStyle $this$dp$iv2 = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getTitleMedium();
                FontWeight $i$f$getDp2 = FontWeight.Companion.getSemiBold();
                TextKt.Text--4IGK_g((String)"Create New Playlist", null, (long)0L, (long)0L, null, (FontWeight)$i$f$getDp2, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv2, (Composer)$composer2, (int)196614, (int)0, (int)65502);
                int $this$dp$iv32 = 8;
                boolean $i$f$getDp32 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv32)), (Composer)$composer2, (int)6);
                String $this$dp$iv32 = AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$5((MutableState<String>)$newTitle$delegate);
                Modifier $i$f$getDp32 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                String string3 = $this$dp$iv32;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1297162167, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                void var40_61 = $composer2;
                int invalid$iv = 0;
                boolean $i$f$cache = false;
                Object it$iv = $this$cache$iv2.rememberedValue();
                boolean bl6 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    string2 = string3;
                    boolean bl7 = false;
                    string3 = string2;
                    value$iv2 = arg_0 -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$15$lambda$14($newTitle$delegate, arg_0);
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object4 = value$iv2;
                } else {
                    object4 = it$iv;
                }
                Function1 function1 = (Function1)object4;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                OutlinedTextFieldKt.OutlinedTextField((String)string3, (Function1)function1, (Modifier)$i$f$getDp32, (boolean)false, (boolean)false, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$575305421$desktopApp(), ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$1776446764$desktopApp(), null, null, null, null, null, (boolean)false, null, null, null, (boolean)true, (int)0, (int)0, null, null, null, (Composer)$composer2, (int)14156208, (int)0xC00000, (int)0, (int)8257336);
                int $this$dp$iv42 = 8;
                boolean $i$f$getDp42 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv42)), (Composer)$composer2, (int)6);
                String $this$dp$iv42 = AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$8((MutableState<String>)$newDescription$delegate);
                Modifier $i$f$getDp42 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                String string4 = $this$dp$iv42;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1297147345, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                $this$cache$iv2 = $composer2;
                invalid$iv = 0;
                $i$f$cache = false;
                it$iv = $this$cache$iv2.rememberedValue();
                bl6 = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    string2 = string4;
                    n5 = 0;
                    string4 = string2;
                    value$iv2 = arg_0 -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$17$lambda$16($newDescription$delegate, arg_0);
                    $this$cache$iv2.updateRememberedValue((Object)value$iv2);
                    object3 = value$iv2;
                } else {
                    object3 = it$iv;
                }
                function1 = (Function1)object3;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                OutlinedTextFieldKt.OutlinedTextField((String)string4, (Function1)function1, (Modifier)$i$f$getDp42, (boolean)false, (boolean)false, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-937481404$desktopApp(), ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-1986853405$desktopApp(), null, null, null, null, null, (boolean)false, null, null, null, (boolean)false, (int)2, (int)0, null, null, null, (Composer)$composer2, (int)14156208, (int)0x6000000, (int)0, (int)8126264);
                int $this$dp$iv52 = 12;
                boolean $i$f$getDp52 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv52)), (Composer)$composer2, (int)6);
                Modifier $this$dp$iv52 = SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null);
                Arrangement.Horizontal $i$f$getDp52 = Arrangement.INSTANCE.getEnd();
                $this$cache$iv2 = $composer2;
                invalid$iv = 54;
                boolean $i$f$Row = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)844473419, (String)"CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy((Arrangement.Horizontal)horizontalArrangement$iv, (Alignment.Vertical)verticalAlignment$iv, (Composer)$composer$iv3, (int)(0xE & $changed$iv2 >> 3 | 0x70 & $changed$iv2 >> 3));
                void $i$a$-let-ComposerKt$cache$1$iv2 = modifier$iv2;
                n5 = 0x70 & $changed$iv2 << 3;
                boolean $i$f$Layout2 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv3, (int)-1159599143, (String)"CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash((Composer)$composer$iv3, (int)0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier((Composer)$composer$iv3, (Modifier)modifier$iv$iv2);
                Function0 function02 = ComposeUiNode.Companion.getConstructor();
                int n6 = 6 | 0x380 & $changed$iv$iv2 << 6;
                boolean $i$f$ReusableComposeNode2 = false;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl((Composer)$composer$iv3);
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
                int n7 = 0xE & $changed$iv$iv$iv2 >> 6;
                void $composer$iv4 = $composer$iv3;
                boolean bl8 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer$iv4, (int)1456264949, (String)"C101@5232L9:Row.kt#2w3rfo");
                int n8 = 6 | 0x70 & $changed$iv2 >> 6;
                void var65_97 = $composer$iv4;
                RowScope $this$AddToPlaylistDialog_u24lambda_u2436_u24lambda_u2435_u24lambda_u2422 = (RowScope)RowScopeInstance.INSTANCE;
                boolean bl9 = false;
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-1463905053, (String)"C123@5401L25,123@5380L116,126@5521L28,128@5620L373,127@5574L583:AddToPlaylistDialog.kt#buhtxq");
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-324317488, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                void var68_100 = $composer3;
                boolean invalid$iv2 = false;
                boolean $i$f$cache2 = false;
                Object it$iv2 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl10 = false;
                    value$iv = () -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$22$lambda$19$lambda$18($isCreatingNew$delegate);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object2 = value$iv;
                } else {
                    object2 = it$iv2;
                }
                Function0 function03 = (Function0)object2;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ButtonKt.TextButton((Function0)function03, null, (boolean)false, null, null, null, null, null, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-1459476652$desktopApp(), (Composer)$composer3, (int)0x30000006, (int)510);
                int $this$dp$iv6 = 8;
                boolean $i$f$getDp222 = false;
                SpacerKt.Spacer((Modifier)SizeKt.width-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv6)), (Composer)$composer3, (int)6);
                ComposerKt.sourceInformationMarkerStart((Composer)$composer3, (int)-324310132, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                void $i$f$getDp222 = $composer3;
                invalid$iv2 = $composer3.changedInstance((Object)$libraryManager) | $composer3.changedInstance((Object)$track) | $composer3.changed((Object)$onDismiss);
                $i$f$cache2 = false;
                it$iv2 = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    boolean bl11 = false;
                    value$iv = () -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$22$lambda$21$lambda$20($libraryManager, $track, $onDismiss, $newTitle$delegate, $newDescription$delegate);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv2;
                }
                Function0 function04 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ButtonKt.Button((Function0)function04, null, (!StringsKt.isBlank((CharSequence)AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$5((MutableState<String>)$newTitle$delegate)) ? 1 : 0) != 0, null, null, null, null, null, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-121783673$desktopApp(), (Composer)$composer3, (int)0x30000000, (int)506);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv4);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer$iv3);
                $composer2.endReplaceGroup();
            } else {
                Object object;
                Function0 value$iv;
                void $this$cache$iv;
                $composer2.startReplaceGroup(-1555346346);
                ComposerKt.sourceInformation((Composer)$composer2, (String)"142@6275L24,141@6225L412,151@6659L30");
                ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1297101456, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                void horizontalArrangement$iv = $composer2;
                boolean invalid$iv = false;
                boolean $i$f$cache3 = false;
                Object it$iv = $this$cache$iv.rememberedValue();
                $i$a$-let-ComposerKt$cache$1$iv = false;
                if (it$iv == Composer.Companion.getEmpty()) {
                    boolean bl12 = false;
                    value$iv = () -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$24$lambda$23($isCreatingNew$delegate);
                    $this$cache$iv.updateRememberedValue((Object)value$iv);
                    object = value$iv;
                } else {
                    object = it$iv;
                }
                Function0 modifier$iv2 = (Function0)object;
                ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                int $this$dp$iv2 = 12;
                boolean $i$f$getDp6 = false;
                ButtonKt.OutlinedButton((Function0)modifier$iv2, (Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (boolean)false, (Shape)((Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4((float)Dp.constructor-impl((float)$this$dp$iv2))), null, null, null, null, null, ComposableSingletons$AddToPlaylistDialogKt.INSTANCE.getLambda$-151362706$desktopApp(), (Composer)$composer2, (int)0x30000036, (int)500);
                $this$dp$iv2 = 12;
                $i$f$getDp6 = false;
                SpacerKt.Spacer((Modifier)SizeKt.height-3ABfNKs((Modifier)((Modifier)Modifier.Companion), (float)Dp.constructor-impl((float)$this$dp$iv2)), (Composer)$composer2, (int)6);
                if (AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$0((State<? extends List<UserPlaylist>>)$playlists$delegate).isEmpty()) {
                    $composer2.startReplaceGroup(-1554970812);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"156@6902L10,157@6975L11,154@6762L342");
                    $this$dp$iv = MaterialTheme.INSTANCE.getTypography((Composer)$composer2, MaterialTheme.$stable).getBodyMedium();
                    long l = MaterialTheme.INSTANCE.getColorScheme((Composer)$composer2, MaterialTheme.$stable).getOnSurfaceVariant-0d7_KjU();
                    int $this$dp$iv7 = 16;
                    boolean $i$f$getDp3 = false;
                    Modifier $i$f$cache3 = PaddingKt.padding-VpY3zN4$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv7), (int)1, null);
                    TextKt.Text--4IGK_g((String)"No playlists created yet. Click above to create one!", (Modifier)$i$f$cache3, (long)l, (long)0L, null, null, null, (long)0L, null, null, (long)0L, (int)0, (boolean)false, (int)0, (int)0, null, (TextStyle)$this$dp$iv, (Composer)$composer2, (int)54, (int)0, (int)65528);
                    $composer2.endReplaceGroup();
                } else {
                    Object object5;
                    $composer2.startReplaceGroup(-1554454135);
                    ComposerKt.sourceInformation((Composer)$composer2, (String)"164@7360L4135,161@7158L4337");
                    $this$dp$iv2 = 280;
                    $i$f$getDp6 = false;
                    Modifier modifier2 = SizeKt.heightIn-VpY3zN4$default((Modifier)SizeKt.fillMaxWidth$default((Modifier)((Modifier)Modifier.Companion), (float)0.0f, (int)1, null), (float)0.0f, (float)Dp.constructor-impl((float)$this$dp$iv2), (int)1, null);
                    LazyListState lazyListState = null;
                    PaddingValues paddingValues = null;
                    boolean bl13 = false;
                    $this$dp$iv2 = 8;
                    $i$f$getDp6 = false;
                    Arrangement.Vertical vertical = (Arrangement.Vertical)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)$this$dp$iv2));
                    Alignment.Horizontal horizontal = null;
                    FlingBehavior flingBehavior = null;
                    boolean bl14 = false;
                    OverscrollEffect overscrollEffect = null;
                    ComposerKt.sourceInformationMarkerStart((Composer)$composer2, (int)-1297062625, (String)"CC(remember):AddToPlaylistDialog.kt#9igjgp");
                    void $i$f$getDp4 = $composer2;
                    invalid$iv = $composer2.changed((Object)$playlists$delegate) | $composer2.changedInstance((Object)$track) | $composer2.changedInstance((Object)$libraryManager) | $composer2.changed((Object)$onDismiss);
                    $i$f$cache3 = false;
                    it$iv = $this$cache$iv.rememberedValue();
                    $i$a$-let-ComposerKt$cache$1$iv = false;
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        OverscrollEffect overscrollEffect2 = overscrollEffect;
                        boolean bl15 = bl14;
                        FlingBehavior flingBehavior2 = flingBehavior;
                        Alignment.Horizontal horizontal2 = horizontal;
                        Arrangement.Vertical vertical2 = vertical;
                        boolean bl16 = bl13;
                        PaddingValues paddingValues2 = paddingValues;
                        LazyListState lazyListState2 = lazyListState;
                        Modifier modifier3 = modifier2;
                        boolean bl17 = false;
                        Function1 function1 = arg_0 -> AddToPlaylistDialogKt.AddToPlaylistDialog$lambda$36$lambda$35$lambda$34$lambda$33($playlists$delegate, $libraryManager, $track, $onDismiss, arg_0);
                        modifier2 = modifier3;
                        lazyListState = lazyListState2;
                        paddingValues = paddingValues2;
                        bl13 = bl16;
                        vertical = vertical2;
                        horizontal = horizontal2;
                        flingBehavior = flingBehavior2;
                        bl14 = bl15;
                        overscrollEffect = overscrollEffect2;
                        value$iv = function1;
                        $this$cache$iv.updateRememberedValue((Object)value$iv);
                        object5 = value$iv;
                    } else {
                        object5 = it$iv;
                    }
                    Function1 function1 = (Function1)object5;
                    ComposerKt.sourceInformationMarkerEnd((Composer)$composer2);
                    LazyDslKt.LazyColumn((Modifier)modifier2, lazyListState, paddingValues, (boolean)bl13, (Arrangement.Vertical)vertical, horizontal, flingBehavior, (boolean)bl14, overscrollEffect, (Function1)function1, (Composer)$composer2, (int)24582, (int)494);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
            }
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
        return Unit.INSTANCE;
    }

    private static final Unit AddToPlaylistDialog$lambda$37(Track $track, Function0 $onDismiss, DesktopLibraryManager $libraryManager, int $$changed, int $$default, Composer $composer, int $force) {
        AddToPlaylistDialogKt.AddToPlaylistDialog($track, (Function0<Unit>)$onDismiss, $libraryManager, $composer, RecomposeScopeImplKt.updateChangedFlags((int)($$changed | 1)), $$default);
        return Unit.INSTANCE;
    }
}

