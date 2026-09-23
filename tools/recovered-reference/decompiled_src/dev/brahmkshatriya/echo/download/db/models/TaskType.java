/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.download.db.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Downloading", "Merging", "Tagging", "Saving", "app_debug"})
public final class TaskType
extends Enum<TaskType> {
    public static final /* enum */ TaskType Loading = new TaskType();
    public static final /* enum */ TaskType Downloading = new TaskType();
    public static final /* enum */ TaskType Merging = new TaskType();
    public static final /* enum */ TaskType Tagging = new TaskType();
    public static final /* enum */ TaskType Saving = new TaskType();
    private static final /* synthetic */ TaskType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static TaskType[] values() {
        return (TaskType[])$VALUES.clone();
    }

    public static TaskType valueOf(String value2) {
        return Enum.valueOf(TaskType.class, value2);
    }

    @NotNull
    public static EnumEntries<TaskType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = taskTypeArray = new TaskType[]{TaskType.Loading, TaskType.Downloading, TaskType.Merging, TaskType.Tagging, TaskType.Saving};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

