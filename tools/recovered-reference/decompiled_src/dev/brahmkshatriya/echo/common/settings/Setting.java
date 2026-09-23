/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common.settings;

import dev.brahmkshatriya.echo.common.settings.SettingCategory;
import dev.brahmkshatriya.echo.common.settings.SettingItem;
import dev.brahmkshatriya.echo.common.settings.SettingList;
import dev.brahmkshatriya.echo.common.settings.SettingMultipleChoice;
import dev.brahmkshatriya.echo.common.settings.SettingOnClick;
import dev.brahmkshatriya.echo.common.settings.SettingSlider;
import dev.brahmkshatriya.echo.common.settings.SettingSwitch;
import dev.brahmkshatriya.echo.common.settings.SettingTextInput;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\b\b\t\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/settings/Setting;", "", "title", "", "getTitle", "()Ljava/lang/String;", "key", "getKey", "Ldev/brahmkshatriya/echo/common/settings/SettingCategory;", "Ldev/brahmkshatriya/echo/common/settings/SettingItem;", "Ldev/brahmkshatriya/echo/common/settings/SettingList;", "Ldev/brahmkshatriya/echo/common/settings/SettingMultipleChoice;", "Ldev/brahmkshatriya/echo/common/settings/SettingOnClick;", "Ldev/brahmkshatriya/echo/common/settings/SettingSlider;", "Ldev/brahmkshatriya/echo/common/settings/SettingSwitch;", "Ldev/brahmkshatriya/echo/common/settings/SettingTextInput;", "common"})
public sealed interface Setting
permits SettingCategory, SettingItem, SettingList, SettingMultipleChoice, SettingOnClick, SettingSlider, SettingSwitch, SettingTextInput {
    @NotNull
    public String getTitle();

    @NotNull
    public String getKey();
}

