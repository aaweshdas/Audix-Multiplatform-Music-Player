/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.russhwolf.settings.Settings
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.settings;

import com.russhwolf.settings.Settings;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u0010\u0014\u001a\u00020\u0007J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0019J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u001cJ\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000fJ\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010!2\u0006\u0010\u0016\u001a\u00020\tJ\u001e\u0010\"\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010!J\u000e\u0010#\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\tJ\u001f\u0010$\u001a\u00020\u00072\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00070&\u00a2\u0006\u0002\b'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006+"}, d2={"Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "", "prefs", "Lcom/russhwolf/settings/Settings;", "<init>", "(Lcom/russhwolf/settings/Settings;)V", "safePutString", "", "fullKey", "", "value", "safeGetString", "default", "_version", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "version", "Lkotlinx/coroutines/flow/StateFlow;", "getVersion", "()Lkotlinx/coroutines/flow/StateFlow;", "notifyChanged", "getString", "key", "putString", "getBoolean", "", "putBoolean", "getInt", "", "putInt", "getLong", "putLong", "getStringSet", "", "putStringSet", "remove", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "toExtensionSettings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "prefix", "core"})
@SourceDebugExtension(value={"SMAP\nEchoSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EchoSettings.kt\ndev/brahmkshatriya/echo/core/settings/EchoSettings\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n1878#2,3:150\n*S KotlinDebug\n*F\n+ 1 EchoSettings.kt\ndev/brahmkshatriya/echo/core/settings/EchoSettings\n*L\n29#1:150,3\n*E\n"})
public final class EchoSettings {
    @NotNull
    private final Settings prefs;
    @NotNull
    private final MutableStateFlow<Long> _version;
    @NotNull
    private final StateFlow<Long> version;

    public EchoSettings(@NotNull Settings prefs) {
        Intrinsics.checkNotNullParameter((Object)prefs, (String)"prefs");
        this.prefs = prefs;
        this._version = StateFlowKt.MutableStateFlow((Object)0L);
        this.version = (StateFlow)this._version;
    }

    /*
     * WARNING - void declaration
     */
    private final void safePutString(String fullKey, String value2) {
        if (value2 == null) {
            Integer count = this.prefs.getIntOrNull(fullKey + "__chunks");
            if (count != null) {
                int n = count;
                for (int i = 0; i < n; ++i) {
                    this.prefs.remove(fullKey + "__c_" + i);
                }
                this.prefs.remove(fullKey + "__chunks");
            }
            this.prefs.remove(fullKey);
            return;
        }
        if (value2.length() > 4000) {
            List chunks = StringsKt.chunked((CharSequence)value2, (int)4000);
            this.prefs.putInt(fullKey + "__chunks", chunks.size());
            Iterable $this$forEachIndexed$iv = chunks;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                void chunk;
                int n;
                if ((n = index$iv++) < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String string2 = (String)item$iv;
                int idx = n;
                boolean bl = false;
                this.prefs.putString(fullKey + "__c_" + idx, (String)chunk);
            }
            this.prefs.remove(fullKey);
        } else {
            Integer oldCount = this.prefs.getIntOrNull(fullKey + "__chunks");
            if (oldCount != null) {
                int n = oldCount;
                for (int i = 0; i < n; ++i) {
                    this.prefs.remove(fullKey + "__c_" + i);
                }
                this.prefs.remove(fullKey + "__chunks");
            }
            this.prefs.putString(fullKey, value2);
        }
    }

    private final String safeGetString(String fullKey, String string2) {
        Integer count = this.prefs.getIntOrNull(fullKey + "__chunks");
        if (count != null && count > 0) {
            StringBuilder sb = new StringBuilder();
            int n = count;
            for (int i = 0; i < n; ++i) {
                String string3 = this.prefs.getStringOrNull(fullKey + "__c_" + i);
                if (string3 == null) {
                    string3 = "";
                }
                String part = string3;
                sb.append(part);
            }
            return sb.toString();
        }
        String string4 = this.prefs.getStringOrNull(fullKey);
        if (string4 == null) {
            string4 = string2;
        }
        return string4;
    }

    static /* synthetic */ String safeGetString$default(EchoSettings echoSettings, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = null;
        }
        return echoSettings.safeGetString(string2, string3);
    }

    @NotNull
    public final StateFlow<Long> getVersion() {
        return this.version;
    }

    public final void notifyChanged() {
        MutableStateFlow<Long> mutableStateFlow = this._version;
        long l = ((Number)mutableStateFlow.getValue()).longValue();
        mutableStateFlow.setValue((Object)(l + 1L));
    }

    @Nullable
    public final String getString(@NotNull String key, @Nullable String string2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        return this.safeGetString(key, string2);
    }

    public static /* synthetic */ String getString$default(EchoSettings echoSettings, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string3 = null;
        }
        return echoSettings.getString(string2, string3);
    }

    public final void putString(@NotNull String key, @Nullable String value2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.safePutString(key, value2);
        this.notifyChanged();
    }

    public final boolean getBoolean(@NotNull String key, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Boolean bl2 = this.prefs.getBooleanOrNull(key);
        return bl2 != null ? bl2 : bl;
    }

    public static /* synthetic */ boolean getBoolean$default(EchoSettings echoSettings, String string2, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return echoSettings.getBoolean(string2, bl);
    }

    public final void putBoolean(@NotNull String key, boolean value2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.prefs.putBoolean(key, value2);
        this.notifyChanged();
    }

    public final int getInt(@NotNull String key, int n) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Integer n2 = this.prefs.getIntOrNull(key);
        return n2 != null ? n2 : n;
    }

    public static /* synthetic */ int getInt$default(EchoSettings echoSettings, String string2, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        return echoSettings.getInt(string2, n);
    }

    public final void putInt(@NotNull String key, int value2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.prefs.putInt(key, value2);
        this.notifyChanged();
    }

    public final long getLong(@NotNull String key, long l) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        Long l2 = this.prefs.getLongOrNull(key);
        return l2 != null ? l2 : l;
    }

    public static /* synthetic */ long getLong$default(EchoSettings echoSettings, String string2, long l, int n, Object object) {
        if ((n & 2) != 0) {
            l = 0L;
        }
        return echoSettings.getLong(string2, l);
    }

    public final void putLong(@NotNull String key, long value2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.prefs.putLong(key, value2);
        this.notifyChanged();
    }

    @Nullable
    public final Set<String> getStringSet(@NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        String string2 = EchoSettings.safeGetString$default(this, key, null, 2, null);
        if (string2 == null) {
            return null;
        }
        String raw = string2;
        if (((CharSequence)raw).length() == 0) {
            return SetsKt.emptySet();
        }
        String[] stringArray = new String[]{"|||"};
        return CollectionsKt.toSet((Iterable)StringsKt.split$default((CharSequence)raw, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
    }

    public final void putStringSet(@NotNull String key, @Nullable Set<String> value2) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        if (value2 == null) {
            this.safePutString(key, null);
        } else {
            this.safePutString(key, CollectionsKt.joinToString$default((Iterable)value2, (CharSequence)"|||", null, null, (int)0, null, null, (int)62, null));
        }
        this.notifyChanged();
    }

    public final void remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter((Object)key, (String)"key");
        this.safePutString(key, null);
        this.notifyChanged();
    }

    public final void edit(@NotNull Function1<? super EchoSettings, Unit> block) {
        Intrinsics.checkNotNullParameter(block, (String)"block");
        block.invoke((Object)this);
    }

    @NotNull
    public final dev.brahmkshatriya.echo.common.settings.Settings toExtensionSettings(@NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        return new dev.brahmkshatriya.echo.common.settings.Settings(this, prefix){
            final /* synthetic */ EchoSettings this$0;
            final /* synthetic */ String $prefix;
            {
                this.this$0 = $receiver;
                this.$prefix = $prefix;
            }

            public String getString(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return EchoSettings.safeGetString$default(this.this$0, this.$prefix + key, null, 2, null);
            }

            public void putString(String key, String value2) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                EchoSettings.access$safePutString(this.this$0, this.$prefix + key, value2);
            }

            public Integer getInt(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return EchoSettings.access$getPrefs$p(this.this$0).getIntOrNull(this.$prefix + key);
            }

            public void putInt(String key, Integer value2) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                if (value2 == null) {
                    EchoSettings.access$getPrefs$p(this.this$0).remove(this.$prefix + key);
                } else {
                    EchoSettings.access$getPrefs$p(this.this$0).putInt(this.$prefix + key, value2.intValue());
                }
            }

            public Boolean getBoolean(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return EchoSettings.access$getPrefs$p(this.this$0).getBooleanOrNull(this.$prefix + key);
            }

            public void putBoolean(String key, Boolean value2) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                if (value2 == null) {
                    EchoSettings.access$getPrefs$p(this.this$0).remove(this.$prefix + key);
                } else {
                    EchoSettings.access$getPrefs$p(this.this$0).putBoolean(this.$prefix + key, value2.booleanValue());
                }
            }

            public Set<String> getStringSet(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                String string2 = EchoSettings.safeGetString$default(this.this$0, this.$prefix + key, null, 2, null);
                if (string2 == null) {
                    return null;
                }
                String raw = string2;
                if (((CharSequence)raw).length() == 0) {
                    return SetsKt.emptySet();
                }
                String[] stringArray = new String[]{"|||"};
                return CollectionsKt.toSet((Iterable)StringsKt.split$default((CharSequence)raw, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
            }

            public void putStringSet(String key, Set<String> value2) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                if (value2 == null) {
                    EchoSettings.access$safePutString(this.this$0, this.$prefix + key, null);
                } else {
                    EchoSettings.access$safePutString(this.this$0, this.$prefix + key, CollectionsKt.joinToString$default((Iterable)value2, (CharSequence)"|||", null, null, (int)0, null, null, (int)62, null));
                }
            }
        };
    }

    public static final /* synthetic */ void access$safePutString(EchoSettings $this, String fullKey, String value2) {
        $this.safePutString(fullKey, value2);
    }

    public static final /* synthetic */ Settings access$getPrefs$p(EchoSettings $this) {
        return $this.prefs;
    }
}

