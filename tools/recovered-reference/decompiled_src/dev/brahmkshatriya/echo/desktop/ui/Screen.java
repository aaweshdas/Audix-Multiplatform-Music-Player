/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.DownloadKt
 *  androidx.compose.material.icons.filled.ExtensionKt
 *  androidx.compose.material.icons.filled.HomeKt
 *  androidx.compose.material.icons.filled.LibraryMusicKt
 *  androidx.compose.material.icons.filled.SearchKt
 *  androidx.compose.material.icons.filled.SettingsKt
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DownloadKt;
import androidx.compose.material.icons.filled.ExtensionKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.LibraryMusicKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material.icons.filled.SettingsKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Ldev/brahmkshatriya/echo/desktop/ui/Screen;", "", "title", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "HOME", "SEARCH", "LIBRARY", "DOWNLOADS", "EXTENSIONS", "SETTINGS", "desktopApp"})
public final class Screen
extends Enum<Screen> {
    @NotNull
    private final String title;
    @NotNull
    private final ImageVector icon;
    public static final /* enum */ Screen HOME = new Screen("Home", HomeKt.getHome((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ Screen SEARCH = new Screen("Search", SearchKt.getSearch((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ Screen LIBRARY = new Screen("Library", LibraryMusicKt.getLibraryMusic((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ Screen DOWNLOADS = new Screen("Downloads", DownloadKt.getDownload((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ Screen EXTENSIONS = new Screen("Extensions", ExtensionKt.getExtension((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ Screen SETTINGS = new Screen("Settings", SettingsKt.getSettings((Icons.Filled)Icons.INSTANCE.getDefault()));
    private static final /* synthetic */ Screen[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private Screen(String title, ImageVector icon) {
        this.title = title;
        this.icon = icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final ImageVector getIcon() {
        return this.icon;
    }

    public static Screen[] values() {
        return (Screen[])$VALUES.clone();
    }

    public static Screen valueOf(String value2) {
        return Enum.valueOf(Screen.class, value2);
    }

    @NotNull
    public static EnumEntries<Screen> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = screenArray = new Screen[]{Screen.HOME, Screen.SEARCH, Screen.LIBRARY, Screen.DOWNLOADS, Screen.EXTENSIONS, Screen.SETTINGS};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

