/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Path
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0002\u00a8\u0006\u0004"}, d2={"div", "Lokio/Path;", "child", "", "core"})
public final class AppPlatformKt {
    @NotNull
    public static final Path div(@NotNull Path $this$div, @NotNull String child) {
        Intrinsics.checkNotNullParameter((Object)$this$div, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)child, (String)"child");
        return $this$div.resolve(child);
    }
}

