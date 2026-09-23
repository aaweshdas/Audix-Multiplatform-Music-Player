/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.settings;

import dev.brahmkshatriya.echo.common.settings.Setting;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J$\u0010\u0017\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012JN\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u001e\b\u0002\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR)\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2={"Ldev/brahmkshatriya/echo/common/settings/SettingOnClick;", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "title", "", "key", "summary", "onClick", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getTitle", "()Ljava/lang/String;", "getKey", "getSummary", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ldev/brahmkshatriya/echo/common/settings/SettingOnClick;", "equals", "", "other", "hashCode", "", "toString", "common"})
public final class SettingOnClick
implements Setting {
    @NotNull
    private final String title;
    @NotNull
    private final String key;
    @Nullable
    private final String summary;
    @NotNull
    private final Function1<Continuation<? super Unit>, Object> onClick;

    public SettingOnClick(@NotNull String title, @NotNull String key, @Nullable String summary, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onClick2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(onClick2, (String)"onClick");
        this.title = title;
        this.key = key;
        this.summary = summary;
        this.onClick = onClick2;
    }

    public /* synthetic */ SettingOnClick(String string2, String string3, String string4, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            string4 = null;
        }
        this(string2, string3, string4, (Function1<? super Continuation<? super Unit>, ? extends Object>)function1);
    }

    @Override
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override
    @NotNull
    public String getKey() {
        return this.key;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @NotNull
    public final Function1<Continuation<? super Unit>, Object> getOnClick() {
        return this.onClick;
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.key;
    }

    @Nullable
    public final String component3() {
        return this.summary;
    }

    @NotNull
    public final Function1<Continuation<? super Unit>, Object> component4() {
        return this.onClick;
    }

    @NotNull
    public final SettingOnClick copy(@NotNull String title, @NotNull String key, @Nullable String summary, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> onClick2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Intrinsics.checkNotNullParameter(onClick2, (String)"onClick");
        return new SettingOnClick(title, key, summary, onClick2);
    }

    public static /* synthetic */ SettingOnClick copy$default(SettingOnClick settingOnClick, String string2, String string3, String string4, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = settingOnClick.title;
        }
        if ((n & 2) != 0) {
            string3 = settingOnClick.key;
        }
        if ((n & 4) != 0) {
            string4 = settingOnClick.summary;
        }
        if ((n & 8) != 0) {
            function1 = settingOnClick.onClick;
        }
        return settingOnClick.copy(string2, string3, string4, function1);
    }

    @NotNull
    public String toString() {
        return "SettingOnClick(title=" + this.title + ", key=" + this.key + ", summary=" + this.summary + ", onClick=" + this.onClick + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + this.key.hashCode();
        result2 = result2 * 31 + (this.summary == null ? 0 : this.summary.hashCode());
        result2 = result2 * 31 + this.onClick.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingOnClick)) {
            return false;
        }
        SettingOnClick settingOnClick = (SettingOnClick)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)settingOnClick.title)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.key, (Object)settingOnClick.key)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.summary, (Object)settingOnClick.summary)) {
            return false;
        }
        return Intrinsics.areEqual(this.onClick, settingOnClick.onClick);
    }
}

