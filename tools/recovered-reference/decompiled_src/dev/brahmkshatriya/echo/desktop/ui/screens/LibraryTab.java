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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/desktop/ui/screens/LibraryTab;", "", "title", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "PLAYLISTS", "LIKED_SONGS", "HISTORY", "FOLDERS", "desktopApp"})
public final class LibraryTab
extends Enum<LibraryTab> {
    @NotNull
    private final String title;
    public static final /* enum */ LibraryTab PLAYLISTS = new LibraryTab("Playlists");
    public static final /* enum */ LibraryTab LIKED_SONGS = new LibraryTab("Liked Songs");
    public static final /* enum */ LibraryTab HISTORY = new LibraryTab("History");
    public static final /* enum */ LibraryTab FOLDERS = new LibraryTab("Local & Folders");
    private static final /* synthetic */ LibraryTab[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private LibraryTab(String title) {
        this.title = title;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public static LibraryTab[] values() {
        return (LibraryTab[])$VALUES.clone();
    }

    public static LibraryTab valueOf(String value2) {
        return Enum.valueOf(LibraryTab.class, value2);
    }

    @NotNull
    public static EnumEntries<LibraryTab> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = libraryTabArray = new LibraryTab[]{LibraryTab.PLAYLISTS, LibraryTab.LIKED_SONGS, LibraryTab.HISTORY, LibraryTab.FOLDERS};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

