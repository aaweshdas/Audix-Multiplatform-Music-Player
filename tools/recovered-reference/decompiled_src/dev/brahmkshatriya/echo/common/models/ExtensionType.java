/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "", "feature", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFeature", "()Ljava/lang/String;", "MUSIC", "TRACKER", "LYRICS", "MISC", "common"})
public final class ExtensionType
extends Enum<ExtensionType> {
    @NotNull
    private final String feature;
    public static final /* enum */ ExtensionType MUSIC = new ExtensionType("music");
    public static final /* enum */ ExtensionType TRACKER = new ExtensionType("tracker");
    public static final /* enum */ ExtensionType LYRICS = new ExtensionType("lyrics");
    public static final /* enum */ ExtensionType MISC = new ExtensionType("misc");
    private static final /* synthetic */ ExtensionType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private ExtensionType(String feature) {
        this.feature = feature;
    }

    @NotNull
    public final String getFeature() {
        return this.feature;
    }

    public static ExtensionType[] values() {
        return (ExtensionType[])$VALUES.clone();
    }

    public static ExtensionType valueOf(String value2) {
        return Enum.valueOf(ExtensionType.class, value2);
    }

    @NotNull
    public static EnumEntries<ExtensionType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = extensionTypeArray = new ExtensionType[]{ExtensionType.MUSIC, ExtensionType.TRACKER, ExtensionType.LYRICS, ExtensionType.MISC};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

