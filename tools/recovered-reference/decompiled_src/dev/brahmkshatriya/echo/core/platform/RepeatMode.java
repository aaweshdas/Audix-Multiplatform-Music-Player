/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.platform;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/core/platform/RepeatMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ONE", "ALL", "core"})
public final class RepeatMode
extends Enum<RepeatMode> {
    public static final /* enum */ RepeatMode NONE = new RepeatMode();
    public static final /* enum */ RepeatMode ONE = new RepeatMode();
    public static final /* enum */ RepeatMode ALL = new RepeatMode();
    private static final /* synthetic */ RepeatMode[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static RepeatMode[] values() {
        return (RepeatMode[])$VALUES.clone();
    }

    public static RepeatMode valueOf(String value2) {
        return Enum.valueOf(RepeatMode.class, value2);
    }

    @NotNull
    public static EnumEntries<RepeatMode> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = repeatModeArray = new RepeatMode[]{RepeatMode.NONE, RepeatMode.ONE, RepeatMode.ALL};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

