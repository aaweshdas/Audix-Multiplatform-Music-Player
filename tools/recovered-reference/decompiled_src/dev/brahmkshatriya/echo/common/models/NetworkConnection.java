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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/NetworkConnection;", "", "<init>", "(Ljava/lang/String;I)V", "NotConnected", "Metered", "Unmetered", "common"})
public final class NetworkConnection
extends Enum<NetworkConnection> {
    public static final /* enum */ NetworkConnection NotConnected = new NetworkConnection();
    public static final /* enum */ NetworkConnection Metered = new NetworkConnection();
    public static final /* enum */ NetworkConnection Unmetered = new NetworkConnection();
    private static final /* synthetic */ NetworkConnection[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static NetworkConnection[] values() {
        return (NetworkConnection[])$VALUES.clone();
    }

    public static NetworkConnection valueOf(String value2) {
        return Enum.valueOf(NetworkConnection.class, value2);
    }

    @NotNull
    public static EnumEntries<NetworkConnection> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = networkConnectionArray = new NetworkConnection[]{NetworkConnection.NotConnected, NetworkConnection.Metered, NetworkConnection.Unmetered};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

