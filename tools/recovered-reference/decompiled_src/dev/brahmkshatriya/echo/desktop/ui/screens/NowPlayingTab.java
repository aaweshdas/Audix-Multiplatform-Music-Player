/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.screens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2={"Ldev/brahmkshatriya/echo/desktop/ui/screens/NowPlayingTab;", "", "title", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "LYRICS", "INFO", "QUEUE", "desktopApp"})
public final class NowPlayingTab
extends Enum<NowPlayingTab> {
    @NotNull
    private final String title;
    public static final /* enum */ NowPlayingTab LYRICS = new NowPlayingTab("Lyrics");
    public static final /* enum */ NowPlayingTab INFO = new NowPlayingTab("Song Info");
    public static final /* enum */ NowPlayingTab QUEUE = new NowPlayingTab("Queue");
    private static final /* synthetic */ NowPlayingTab[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private NowPlayingTab(String title) {
        this.title = title;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public static NowPlayingTab[] values() {
        return (NowPlayingTab[])$VALUES.clone();
    }

    public static NowPlayingTab valueOf(String value2) {
        return Enum.valueOf(NowPlayingTab.class, value2);
    }

    @NotNull
    public static EnumEntries<NowPlayingTab> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = nowPlayingTabArray = new NowPlayingTab[]{NowPlayingTab.LYRICS, NowPlayingTab.INFO, NowPlayingTab.QUEUE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

