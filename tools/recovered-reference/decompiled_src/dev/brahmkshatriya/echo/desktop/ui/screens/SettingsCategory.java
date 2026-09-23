/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.material.icons.Icons
 *  androidx.compose.material.icons.Icons$Filled
 *  androidx.compose.material.icons.filled.DownloadKt
 *  androidx.compose.material.icons.filled.ExtensionKt
 *  androidx.compose.material.icons.filled.GraphicEqKt
 *  androidx.compose.material.icons.filled.InfoKt
 *  androidx.compose.material.icons.filled.PaletteKt
 *  androidx.compose.ui.graphics.vector.ImageVector
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.ui.screens;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DownloadKt;
import androidx.compose.material.icons.filled.ExtensionKt;
import androidx.compose.material.icons.filled.GraphicEqKt;
import androidx.compose.material.icons.filled.InfoKt;
import androidx.compose.material.icons.filled.PaletteKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/desktop/ui/screens/SettingsCategory;", "", "title", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getTitle", "()Ljava/lang/String;", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "PLAYBACK", "APPEARANCE", "DOWNLOADS", "EXTENSIONS", "ABOUT", "desktopApp"})
public final class SettingsCategory
extends Enum<SettingsCategory> {
    @NotNull
    private final String title;
    @NotNull
    private final ImageVector icon;
    public static final /* enum */ SettingsCategory PLAYBACK = new SettingsCategory("Playback", GraphicEqKt.getGraphicEq((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ SettingsCategory APPEARANCE = new SettingsCategory("Appearance", PaletteKt.getPalette((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ SettingsCategory DOWNLOADS = new SettingsCategory("Downloads", DownloadKt.getDownload((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ SettingsCategory EXTENSIONS = new SettingsCategory("Extensions", ExtensionKt.getExtension((Icons.Filled)Icons.INSTANCE.getDefault()));
    public static final /* enum */ SettingsCategory ABOUT = new SettingsCategory("About", InfoKt.getInfo((Icons.Filled)Icons.INSTANCE.getDefault()));
    private static final /* synthetic */ SettingsCategory[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private SettingsCategory(String title, ImageVector icon) {
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

    public static SettingsCategory[] values() {
        return (SettingsCategory[])$VALUES.clone();
    }

    public static SettingsCategory valueOf(String value2) {
        return Enum.valueOf(SettingsCategory.class, value2);
    }

    @NotNull
    public static EnumEntries<SettingsCategory> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = settingsCategoryArray = new SettingsCategory[]{SettingsCategory.PLAYBACK, SettingsCategory.APPEARANCE, SettingsCategory.DOWNLOADS, SettingsCategory.EXTENSIONS, SettingsCategory.ABOUT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

