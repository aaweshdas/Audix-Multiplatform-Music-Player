/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.core.os.LocaleListCompat
 *  coil3.ImageLoader
 *  coil3.ImageLoader$Builder
 *  coil3.SingletonImageLoader$Factory
 *  coil3.disk.DiskCache
 *  coil3.disk.DiskCache$Builder
 *  coil3.disk.DiskCacheKt
 *  coil3.memory.MemoryCache
 *  coil3.memory.MemoryCache$Builder
 *  coil3.request.ImageRequestsKt
 *  coil3.request.ImageRequests_androidKt
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.koin.android.ext.android.AndroidKoinScopeExtKt
 *  org.koin.android.ext.koin.KoinExtKt
 *  org.koin.androidx.workmanager.koin.KoinApplicationExtKt
 *  org.koin.androix.startup.KoinStartup
 *  org.koin.core.KoinApplication
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 *  org.koin.dsl.KoinConfiguration
 *  org.koin.dsl.KoinConfigurationKt
 */
package dev.brahmkshatriya.echo;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import coil3.disk.DiskCache;
import coil3.disk.DiskCacheKt;
import coil3.memory.MemoryCache;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import dev.brahmkshatriya.echo.di.DI;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader;
import dev.brahmkshatriya.echo.utils.AppShortcuts;
import dev.brahmkshatriya.echo.utils.CoroutineUtils;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.androidx.workmanager.koin.KoinApplicationExtKt;
import org.koin.androix.startup.KoinStartup;
import org.koin.core.KoinApplication;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.dsl.KoinConfiguration;
import org.koin.dsl.KoinConfigurationKt;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/MainApplication;", "Landroid/app/Application;", "Lorg/koin/androix/startup/KoinStartup;", "Lcoil3/SingletonImageLoader$Factory;", "<init>", "()V", "onKoinStartup", "Lorg/koin/dsl/KoinConfiguration;", "settings", "Landroid/content/SharedPreferences;", "getSettings", "()Landroid/content/SharedPreferences;", "settings$delegate", "Lkotlin/Lazy;", "extensionLoader", "Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "getExtensionLoader", "()Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "extensionLoader$delegate", "onCreate", "", "newImageLoader", "Lcoil3/ImageLoader;", "context", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "getPackageName", "", "spoofedPackageName", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nMainApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainApplication.kt\ndev/brahmkshatriya/echo/MainApplication\n+ 2 ComponentCallbackExt.kt\norg/koin/android/ext/android/ComponentCallbackExtKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,149:1\n40#2,5:150\n40#2,5:155\n12637#3:160\n12638#3:164\n1761#4,3:161\n*S KotlinDebug\n*F\n+ 1 MainApplication.kt\ndev/brahmkshatriya/echo/MainApplication\n*L\n40#1:150,5\n41#1:155,5\n71#1:160\n71#1:164\n73#1:161,3\n*E\n"})
public final class MainApplication
extends Application
implements KoinStartup,
SingletonImageLoader.Factory {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Lazy settings$delegate;
    @NotNull
    private final Lazy extensionLoader$delegate;
    @NotNull
    private static final String CHROME_PACKAGE = "com.android.chrome";
    @NotNull
    private static final String SYSTEM_SETTINGS_PACKAGE = "com.android.settings";
    @NotNull
    private static final String CLASS_NAME = "org.chromium.base.BuildInfo";
    @NotNull
    private static final Set<String> FUNCTION_SET;
    @NotNull
    private static final Map<String, String> languages;

    public MainApplication() {
        ComponentCallbacks componentCallbacks = (ComponentCallbacks)this;
        Qualifier qualifier = null;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Function0 function0 = null;
        boolean bl = false;
        this.settings$delegate = LazyKt.lazy((LazyThreadSafetyMode)lazyThreadSafetyMode, (Function0)((Function0)new Function0<SharedPreferences>(componentCallbacks, qualifier, function0){
            final /* synthetic */ ComponentCallbacks $this_inject;
            final /* synthetic */ Qualifier $qualifier;
            final /* synthetic */ Function0 $parameters;
            {
                this.$this_inject = $receiver;
                this.$qualifier = $qualifier;
                this.$parameters = $parameters;
            }

            /*
             * WARNING - void declaration
             */
            public final SharedPreferences invoke() {
                void qualifier\1;
                void $this$get\1;
                ComponentCallbacks componentCallbacks = this.$this_inject;
                Qualifier qualifier = this.$qualifier;
                Function0 function0 = this.$parameters;
                boolean bl = false;
                Scope scope = AndroidKoinScopeExtKt.getKoinScope((ComponentCallbacks)$this$get\1);
                boolean bl2 = false;
                return scope.get(Reflection.getOrCreateKotlinClass(SharedPreferences.class), (Qualifier)qualifier\1, function0);
            }
        }));
        ComponentCallbacks componentCallbacks2 = (ComponentCallbacks)this;
        Qualifier qualifier2 = null;
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        Function0 function02 = null;
        boolean bl2 = false;
        this.extensionLoader$delegate = LazyKt.lazy((LazyThreadSafetyMode)lazyThreadSafetyMode2, (Function0)((Function0)new Function0<ExtensionLoader>(componentCallbacks2, qualifier2, function02){
            final /* synthetic */ ComponentCallbacks $this_inject;
            final /* synthetic */ Qualifier $qualifier;
            final /* synthetic */ Function0 $parameters;
            {
                this.$this_inject = $receiver;
                this.$qualifier = $qualifier;
                this.$parameters = $parameters;
            }

            /*
             * WARNING - void declaration
             */
            public final ExtensionLoader invoke() {
                void qualifier\1;
                void $this$get\1;
                ComponentCallbacks componentCallbacks = this.$this_inject;
                Qualifier qualifier = this.$qualifier;
                Function0 function0 = this.$parameters;
                boolean bl = false;
                Scope scope = AndroidKoinScopeExtKt.getKoinScope((ComponentCallbacks)$this$get\1);
                boolean bl2 = false;
                return scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), (Qualifier)qualifier\1, function0);
            }
        }));
    }

    @NotNull
    public KoinConfiguration onKoinStartup() {
        return KoinConfigurationKt.koinConfiguration(arg_0 -> MainApplication.onKoinStartup$lambda$0(this, arg_0));
    }

    private final SharedPreferences getSettings() {
        Lazy lazy = this.settings$delegate;
        return (SharedPreferences)lazy.getValue();
    }

    private final ExtensionLoader getExtensionLoader() {
        Lazy lazy = this.extensionLoader$delegate;
        return (ExtensionLoader)lazy.getValue();
    }

    public void onCreate() {
        super.onCreate();
        CoroutineUtils.INSTANCE.setDebug();
        Companion.applyLocale(this.getSettings());
        AppShortcuts.INSTANCE.configureAppShortcuts(this.getExtensionLoader());
    }

    @NotNull
    public ImageLoader newImageLoader(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return ImageRequestsKt.crossfade((ImageLoader.Builder)ImageRequests_androidKt.allowHardware((ImageLoader.Builder)new ImageLoader.Builder(context).memoryCache(() -> MainApplication.newImageLoader$lambda$1(context)).diskCache(() -> MainApplication.newImageLoader$lambda$2(this)), (boolean)false), (boolean)true).build();
    }

    /*
     * Unable to fully structure code
     */
    @NotNull
    public String getPackageName() {
        block11: {
            if (Build.VERSION.SDK_INT < 26) break block11;
            var1_1 = this;
            try {
                block10: {
                    $this$getPackageName_u24lambda_u245\1 = var1_1;
                    $i$a$-runCatching-MainApplication$getPackageName$1\1\69\0 = false;
                    stackTrace\1 = Looper.getMainLooper().getThread().getStackTrace();
                    Intrinsics.checkNotNull((Object)stackTrace\1);
                    $this$any\2 = stackTrace\1;
                    $i$f$any\2\71 = false;
                    var8_10 = $this$any\2.length;
                    for (var7_9 = 0; var7_9 < var8_10; ++var7_9) {
                        block9: {
                            trace\3 = element\2 = $this$any\2[var7_9];
                            $i$a$-any-MainApplication$getPackageName$1$isChromiumCall$1\3\160\1 = false;
                            if (!StringsKt.equals((String)trace\3.getClassName(), (String)"org.chromium.base.BuildInfo", (boolean)true)) ** GOTO lbl-1000
                            $this$any\4 = MainApplication.FUNCTION_SET;
                            $i$f$any\4\73 = false;
                            if ($this$any\4 instanceof Collection && ((Collection)$this$any\4).isEmpty()) {
                                v0 = false;
                            } else {
                                for (T element\4 : $this$any\4) {
                                    it\5 = (String)element\4;
                                    $i$a$-any-MainApplication$getPackageName$1$isChromiumCall$1$1\5\162\3 = false;
                                    if (!StringsKt.equals((String)trace\3.getMethodName(), (String)it\5, (boolean)true)) continue;
                                    v0 = true;
                                    break block9;
                                }
                                v0 = false;
                            }
                        }
                        if (v0) {
                            v1 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v1 = false;
                        }
                        if (!v1) continue;
                        v2 = true;
                        break block10;
                    }
                    v2 = isChromiumCall\1 = false;
                }
                if (isChromiumCall\1) {
                    v3 = $this$getPackageName_u24lambda_u245\1.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"getApplicationContext(...)");
                    return $this$getPackageName_u24lambda_u245\1.spoofedPackageName(v3);
                }
                var2_2 = Result.constructor-impl((Object)Unit.INSTANCE);
            }
            catch (Throwable var3_5) {
                var2_3 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var3_5));
            }
        }
        v4 = super.getPackageName();
        Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"getPackageName(...)");
        return v4;
    }

    private final String spoofedPackageName(Context context) {
        Object object;
        Object object2;
        MainApplication mainApplication = this;
        try {
            object2 = mainApplication;
            boolean bl = false;
            context.getPackageManager().getPackageInfo(CHROME_PACKAGE, 128);
            object2 = Result.constructor-impl((Object)CHROME_PACKAGE);
        }
        catch (Throwable bl) {
            object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
        }
        mainApplication = object2;
        Throwable throwable = Result.exceptionOrNull-impl((Object)((Object)mainApplication));
        if (throwable == null) {
            object = mainApplication;
        } else {
            Throwable throwable2 = throwable;
            boolean bl = false;
            object = SYSTEM_SETTINGS_PACKAGE;
        }
        return (String)object;
    }

    private static final Unit onKoinStartup$lambda$0(MainApplication this$0, KoinApplication $this$koinConfiguration) {
        Intrinsics.checkNotNullParameter((Object)$this$koinConfiguration, (String)"$this$koinConfiguration");
        KoinExtKt.androidContext((KoinApplication)$this$koinConfiguration, (Context)((Context)this$0));
        $this$koinConfiguration.modules(DI.INSTANCE.getAppModule());
        KoinApplicationExtKt.workManagerFactory((KoinApplication)$this$koinConfiguration);
        return Unit.INSTANCE;
    }

    private static final MemoryCache newImageLoader$lambda$1(Context $context) {
        return new MemoryCache.Builder().maxSizePercent($context, 0.25).build();
    }

    private static final DiskCache newImageLoader$lambda$2(MainApplication this$0) {
        DiskCache.Builder builder = new DiskCache.Builder();
        File file2 = this$0.getCacheDir();
        Intrinsics.checkNotNullExpressionValue((Object)file2, (String)"getCacheDir(...)");
        return DiskCacheKt.directory((DiskCache.Builder)builder, (File)FilesKt.resolve((File)file2, (String)"image-cache")).maxSizeBytes(0x6400000L).build();
    }

    static {
        Object[] objectArray = new String[]{"getAll", "getPackageName", "<init>"};
        FUNCTION_SET = SetsKt.setOf((Object[])objectArray);
        objectArray = new Pair[]{TuplesKt.to((Object)"ar", (Object)"\u0627\u0644\u0639\u0631\u0628\u064a\u0629"), TuplesKt.to((Object)"as", (Object)"Assamese"), TuplesKt.to((Object)"be", (Object)"\u0411\u0435\u043b\u0430\u0440\u0443\u0441\u043a\u0430\u044f"), TuplesKt.to((Object)"bn", (Object)"\u09ac\u09be\u0982\u09b2\u09be"), TuplesKt.to((Object)"ca", (Object)"Catal\u00e0"), TuplesKt.to((Object)"de", (Object)"Deutsch"), TuplesKt.to((Object)"es", (Object)"Espa\u00f1ol"), TuplesKt.to((Object)"fa", (Object)"\u0641\u0627\u0631\u0633\u06cc"), TuplesKt.to((Object)"fr", (Object)"Fran\u00e7ais"), TuplesKt.to((Object)"en", (Object)"English"), TuplesKt.to((Object)"hi", (Object)"\u0939\u093f\u0928\u094d\u0926\u0940"), TuplesKt.to((Object)"hng", (Object)"Hinglish"), TuplesKt.to((Object)"hu", (Object)"Magyar"), TuplesKt.to((Object)"in", (Object)"Bahasa Indonesia"), TuplesKt.to((Object)"it", (Object)"Italiano"), TuplesKt.to((Object)"iw", (Object)"\u05e2\u05d1\u05e8\u05d9\u05ea"), TuplesKt.to((Object)"ja", (Object)"\u65e5\u672c\u8a9e"), TuplesKt.to((Object)"ko", (Object)"\ud55c\uad6d\uc5b4"), TuplesKt.to((Object)"lv", (Object)"Latviski"), TuplesKt.to((Object)"ms", (Object)"Bahasa Melayu"), TuplesKt.to((Object)"pl", (Object)"Polski"), TuplesKt.to((Object)"pt", (Object)"Portugu\u00eas"), TuplesKt.to((Object)"pt-rBR", (Object)"Portugu\u00eas (Brasil)"), TuplesKt.to((Object)"ru", (Object)"\u0420\u0443\u0441\u0441\u043a\u0438\u0439"), TuplesKt.to((Object)"sa", (Object)"\u0938\u0902\u0938\u094d\u0915\u0943\u0924\u092e\u094d"), TuplesKt.to((Object)"si", (Object)"\u0dc3\u0dd2\u0d82\u0dc4\u0dbd"), TuplesKt.to((Object)"sk", (Object)"Sloven\u010dina"), TuplesKt.to((Object)"sr", (Object)"\u0421\u0440\u043f\u0441\u043a\u0438"), TuplesKt.to((Object)"ta", (Object)"\u0ba4\u0bae\u0bbf\u0bb4\u0bcd"), TuplesKt.to((Object)"th", (Object)"\u0e44\u0e17\u0e22"), TuplesKt.to((Object)"tl", (Object)"Filipino"), TuplesKt.to((Object)"tr", (Object)"T\u00fcrk\u00e7e"), TuplesKt.to((Object)"uk", (Object)"\u0423\u043a\u0440\u0430\u0457\u043d\u0441\u044c\u043a\u0430"), TuplesKt.to((Object)"vi", (Object)"Ti\u1ebfng Vi\u1ec7t"), TuplesKt.to((Object)"zh-rCN", (Object)"\u4e2d\u6587 (\u7b80\u4f53)"), TuplesKt.to((Object)"zh-rTW", (Object)"\u4e2d\u6587 (\u7e41\u9ad4)")};
        languages = MapsKt.mapOf((Pair[])objectArray);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Ldev/brahmkshatriya/echo/MainApplication$Companion;", "", "<init>", "()V", "CHROME_PACKAGE", "", "SYSTEM_SETTINGS_PACKAGE", "CLASS_NAME", "FUNCTION_SET", "", "getCurrentLanguage", "sharedPref", "Landroid/content/SharedPreferences;", "setCurrentLanguage", "", "locale", "applyLocale", "languages", "", "getLanguages", "()Ljava/util/Map;", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nMainApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainApplication.kt\ndev/brahmkshatriya/echo/MainApplication$Companion\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,149:1\n40#2,13:150\n*S KotlinDebug\n*F\n+ 1 MainApplication.kt\ndev/brahmkshatriya/echo/MainApplication$Companion\n*L\n99#1:150,13\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getCurrentLanguage(@NotNull SharedPreferences sharedPref) {
            Intrinsics.checkNotNullParameter((Object)sharedPref, (String)"sharedPref");
            String string2 = sharedPref.getString("language", null);
            if (string2 == null) {
                string2 = "system";
            }
            return string2;
        }

        public final void setCurrentLanguage(@NotNull SharedPreferences sharedPref, @Nullable String locale) {
            SharedPreferences.Editor editor;
            Intrinsics.checkNotNullParameter((Object)sharedPref, (String)"sharedPref");
            SharedPreferences sharedPreferences = sharedPref;
            boolean bl = false;
            boolean bl2 = false;
            SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
            boolean bl3 = false;
            editor2.putString("language", locale);
            editor.apply();
            this.applyLocale(sharedPref);
        }

        public final void applyLocale(@NotNull SharedPreferences sharedPref) {
            String value2;
            Intrinsics.checkNotNullParameter((Object)sharedPref, (String)"sharedPref");
            String string2 = sharedPref.getString("language", null);
            if (string2 == null) {
                string2 = "system";
            }
            LocaleListCompat localeListCompat = Intrinsics.areEqual((Object)(value2 = string2), (Object)"system") ? LocaleListCompat.getEmptyLocaleList() : LocaleListCompat.forLanguageTags((String)value2);
            Intrinsics.checkNotNull((Object)localeListCompat);
            LocaleListCompat locale = localeListCompat;
            AppCompatDelegate.setApplicationLocales((LocaleListCompat)locale);
        }

        @NotNull
        public final Map<String, String> getLanguages() {
            return languages;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

