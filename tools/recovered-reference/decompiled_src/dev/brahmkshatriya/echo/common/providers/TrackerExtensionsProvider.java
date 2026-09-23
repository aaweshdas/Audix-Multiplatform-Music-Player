/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common.providers;

import dev.brahmkshatriya.echo.common.TrackerExtension;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/providers/TrackerExtensionsProvider;", "", "requiredTrackerExtensions", "", "", "getRequiredTrackerExtensions", "()Ljava/util/List;", "setTrackerExtensions", "", "extensions", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "common"})
public interface TrackerExtensionsProvider {
    @NotNull
    public List<String> getRequiredTrackerExtensions();

    public void setTrackerExtensions(@NotNull List<TrackerExtension> var1);
}

