/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.ui.geometry.Size
 *  androidx.compose.ui.graphics.ColorKt
 *  androidx.compose.ui.graphics.drawscope.DrawScope
 *  androidx.compose.ui.graphics.painter.Painter
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0014R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/desktop/EchoTrayPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "<init>", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nMain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Main.kt\ndev/brahmkshatriya/echo/desktop/EchoTrayPainter\n+ 2 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n+ 3 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n*L\n1#1,155:1\n33#2:156\n53#3,3:157\n*S KotlinDebug\n*F\n+ 1 Main.kt\ndev/brahmkshatriya/echo/desktop/EchoTrayPainter\n*L\n38#1:156\n38#1:157,3\n*E\n"})
final class EchoTrayPainter
extends Painter {
    @NotNull
    public static final EchoTrayPainter INSTANCE;
    private static final long intrinsicSize;

    private EchoTrayPainter() {
    }

    public long getIntrinsicSize-NH-jbRc() {
        return intrinsicSize;
    }

    protected void onDraw(@NotNull DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter((Object)$this$onDraw, (String)"<this>");
        DrawScope.drawCircle-VaOC9Bg$default((DrawScope)$this$onDraw, (long)ColorKt.Color((long)4284960932L), (float)(Size.getMinDimension-impl((long)$this$onDraw.getSize-NH-jbRc()) / 2.0f), (long)0L, (float)0.0f, null, null, (int)0, (int)124, null);
    }

    /*
     * WARNING - void declaration
     */
    static {
        void width$iv;
        INSTANCE = new EchoTrayPainter();
        float f = 32.0f;
        float height$iv = 32.0f;
        boolean $i$f$Size = false;
        boolean $i$f$packFloats = false;
        long v1$iv$iv = Float.floatToRawIntBits((float)width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        intrinsicSize = Size.constructor-impl((long)(v1$iv$iv << 32 | v2$iv$iv & 0xFFFFFFFFL));
    }
}

