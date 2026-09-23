/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.russhwolf.settings.PreferencesSettings
 *  com.russhwolf.settings.Settings
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.SupervisorKt
 *  org.jetbrains.annotations.NotNull
 *  org.koin.core.definition.BeanDefinition
 *  org.koin.core.definition.Kind
 *  org.koin.core.definition.KoinDefinition
 *  org.koin.core.instance.FactoryInstanceFactory
 *  org.koin.core.instance.InstanceFactory
 *  org.koin.core.instance.SingleInstanceFactory
 *  org.koin.core.module.Module
 *  org.koin.core.module.dsl.OptionDSLKt
 *  org.koin.core.parameter.ParametersHolder
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.registry.ScopeRegistry
 *  org.koin.core.scope.Scope
 *  org.koin.dsl.ModuleDSLKt
 */
package dev.brahmkshatriya.echo.desktop.di;

import com.russhwolf.settings.PreferencesSettings;
import com.russhwolf.settings.Settings;
import dev.brahmkshatriya.echo.core.db.DatabaseFactoryKt;
import dev.brahmkshatriya.echo.core.db.DesktopDatabaseDriverKt;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import dev.brahmkshatriya.echo.core.extensions.ExtensionManager;
import dev.brahmkshatriya.echo.core.extensions.ExtensionRepository;
import dev.brahmkshatriya.echo.core.extensions.JarExtensionRepository;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.platform.AudioPlayer;
import dev.brahmkshatriya.echo.core.platform.BrowserLauncher;
import dev.brahmkshatriya.echo.core.platform.DesktopAppPlatform;
import dev.brahmkshatriya.echo.core.platform.DesktopBrowserLauncher;
import dev.brahmkshatriya.echo.core.platform.DesktopDownloadScheduler;
import dev.brahmkshatriya.echo.core.platform.DownloadScheduler;
import dev.brahmkshatriya.echo.core.platform.VlcAudioPlayer;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import dev.brahmkshatriya.echo.desktop.platform.WindowsMediaKeys;
import dev.brahmkshatriya.echo.desktop.viewmodel.DownloadsViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.ExtensionsViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.HomeViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.LibraryViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.MediaViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.PlayerViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.SearchViewModel;
import dev.brahmkshatriya.echo.desktop.viewmodel.SettingsViewModel;
import java.util.List;
import java.util.prefs.Preferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.definition.KoinDefinition;
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.module.dsl.OptionDSLKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.ModuleDSLKt;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"desktopModule", "Lorg/koin/core/module/Module;", "getDesktopModule", "()Lorg/koin/core/module/Module;", "desktopApp"})
@SourceDebugExtension(value={"SMAP\nDesktopModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopModule.kt\ndev/brahmkshatriya/echo/desktop/di/DesktopModuleKt\n+ 2 Scope.kt\norg/koin/core/scope/Scope\n+ 3 Module.kt\norg/koin/core/module/Module\n+ 4 Module.kt\norg/koin/core/module/ModuleKt\n+ 5 BeanDefinition.kt\norg/koin/core/definition/BeanDefinitionKt\n+ 6 SingleOf.kt\norg/koin/core/module/dsl/SingleOfKt\n+ 7 FactoryOf.kt\norg/koin/core/module/dsl/FactoryOfKt\n*L\n1#1,71:1\n138#2,5:72\n138#2,5:77\n138#2,5:82\n138#2,5:87\n105#3,6:92\n111#3,5:120\n105#3,6:125\n111#3,5:153\n105#3,6:158\n111#3,5:186\n105#3,6:191\n111#3,5:219\n105#3,6:224\n111#3,5:252\n105#3,6:257\n111#3,5:285\n105#3,6:290\n111#3,5:318\n105#3,6:323\n111#3,5:351\n105#3,6:356\n111#3,5:384\n105#3,6:393\n111#3,5:421\n149#3,14:430\n163#3,2:460\n149#3,14:466\n163#3,2:496\n149#3,14:502\n163#3,2:532\n149#3,14:538\n163#3,2:568\n149#3,14:574\n163#3,2:604\n149#3,14:610\n163#3,2:640\n149#3,14:646\n163#3,2:676\n149#3,14:682\n163#3,2:712\n196#4,7:98\n203#4:119\n196#4,7:131\n203#4:152\n196#4,7:164\n203#4:185\n196#4,7:197\n203#4:218\n196#4,7:230\n203#4:251\n196#4,7:263\n203#4:284\n196#4,7:296\n203#4:317\n196#4,7:329\n203#4:350\n196#4,7:362\n203#4:383\n196#4,7:399\n203#4:420\n212#4:444\n213#4:459\n212#4:480\n213#4:495\n212#4:516\n213#4:531\n212#4:552\n213#4:567\n212#4:588\n213#4:603\n212#4:624\n213#4:639\n212#4:660\n213#4:675\n212#4:696\n213#4:711\n115#5,14:105\n115#5,14:138\n115#5,14:171\n115#5,14:204\n115#5,14:237\n115#5,14:270\n115#5,14:303\n115#5,14:336\n115#5,14:369\n115#5,14:406\n115#5,14:445\n115#5,14:481\n115#5,14:517\n115#5,14:553\n115#5,14:589\n115#5,14:625\n115#5,14:661\n115#5,14:697\n55#6,4:389\n55#7,4:426\n55#7,4:462\n55#7,4:498\n63#7,4:534\n63#7,4:570\n47#7,4:606\n47#7,4:642\n55#7,4:678\n*S KotlinDebug\n*F\n+ 1 DesktopModule.kt\ndev/brahmkshatriya/echo/desktop/di/DesktopModuleKt\n*L\n41#1:72,5\n43#1:77,5\n44#1:82,5\n53#1:87,5\n36#1:92,6\n36#1:120,5\n39#1:125,6\n39#1:153,5\n40#1:158,6\n40#1:186,5\n41#1:191,6\n41#1:219,5\n42#1:224,6\n42#1:252,5\n43#1:257,6\n43#1:285,5\n44#1:290,6\n44#1:318,5\n47#1:323,6\n47#1:351,5\n52#1:356,6\n52#1:384,5\n59#1:393,6\n59#1:421,5\n62#1:430,14\n62#1:460,2\n63#1:466,14\n63#1:496,2\n64#1:502,14\n64#1:532,2\n65#1:538,14\n65#1:568,2\n66#1:574,14\n66#1:604,2\n67#1:610,14\n67#1:640,2\n68#1:646,14\n68#1:676,2\n69#1:682,14\n69#1:712,2\n36#1:98,7\n36#1:119\n39#1:131,7\n39#1:152\n40#1:164,7\n40#1:185\n41#1:197,7\n41#1:218\n42#1:230,7\n42#1:251\n43#1:263,7\n43#1:284\n44#1:296,7\n44#1:317\n47#1:329,7\n47#1:350\n52#1:362,7\n52#1:383\n59#1:399,7\n59#1:420\n62#1:444\n62#1:459\n63#1:480\n63#1:495\n64#1:516\n64#1:531\n65#1:552\n65#1:567\n66#1:588\n66#1:603\n67#1:624\n67#1:639\n68#1:660\n68#1:675\n69#1:696\n69#1:711\n36#1:105,14\n39#1:138,14\n40#1:171,14\n41#1:204,14\n42#1:237,14\n43#1:270,14\n44#1:303,14\n47#1:336,14\n52#1:369,14\n59#1:406,14\n62#1:445,14\n63#1:481,14\n64#1:517,14\n65#1:553,14\n66#1:589,14\n67#1:625,14\n68#1:661,14\n69#1:697,14\n59#1:389,4\n62#1:426,4\n63#1:462,4\n64#1:498,4\n65#1:534,4\n66#1:570,4\n67#1:606,4\n68#1:642,4\n69#1:678,4\n*E\n"})
public final class DesktopModuleKt {
    @NotNull
    private static final Module desktopModule = ModuleDSLKt.module$default((boolean)false, DesktopModuleKt::desktopModule$lambda$17, (int)1, null);

    @NotNull
    public static final Module getDesktopModule() {
        return desktopModule;
    }

    private static final CoroutineScope desktopModule$lambda$17$lambda$0(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return CoroutineScopeKt.CoroutineScope((CoroutineContext)Dispatchers.getMain().plus((CoroutineContext)SupervisorKt.SupervisorJob$default(null, (int)1, null)));
    }

    private static final AppPlatform desktopModule$lambda$17$lambda$1(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new DesktopAppPlatform();
    }

    private static final AudioPlayer desktopModule$lambda$17$lambda$2(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new VlcAudioPlayer();
    }

    private static final DownloadScheduler desktopModule$lambda$17$lambda$3(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Scope $this$iv = $this$single;
        Qualifier qualifier$iv = null;
        Function0 parameters$iv = null;
        boolean $i$f$get = false;
        return new DesktopDownloadScheduler((CoroutineScope)$this$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv, parameters$iv));
    }

    private static final BrowserLauncher desktopModule$lambda$17$lambda$4(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new DesktopBrowserLauncher();
    }

    private static final ExtensionRepository desktopModule$lambda$17$lambda$5(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Scope $this$iv = $this$single;
        Qualifier qualifier$iv = null;
        Function0 parameters$iv = null;
        boolean $i$f$get = false;
        return new JarExtensionRepository((AppPlatform)$this$iv.get(Reflection.getOrCreateKotlinClass(AppPlatform.class), qualifier$iv, parameters$iv));
    }

    private static final WindowsMediaKeys desktopModule$lambda$17$lambda$6(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Scope $this$iv = $this$single;
        Qualifier qualifier$iv = null;
        Function0 parameters$iv = null;
        boolean $i$f$get = false;
        return new WindowsMediaKeys((AudioPlayer)$this$iv.get(Reflection.getOrCreateKotlinClass(AudioPlayer.class), qualifier$iv, parameters$iv), null, 2, null);
    }

    private static final EchoSettings desktopModule$lambda$17$lambda$7(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Preferences preferences = Preferences.userRoot().node("dev/brahmkshatriya/echo");
        Intrinsics.checkNotNullExpressionValue((Object)preferences, (String)"node(...)");
        return new EchoSettings((Settings)new PreferencesSettings(preferences));
    }

    private static final EchoDatabase desktopModule$lambda$17$lambda$8(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Scope $this$iv = $this$single;
        Qualifier qualifier$iv = null;
        Function0 parameters$iv = null;
        boolean $i$f$get = false;
        AppPlatform platform = (AppPlatform)$this$iv.get(Reflection.getOrCreateKotlinClass(AppPlatform.class), qualifier$iv, parameters$iv);
        platform.getDataDir().toFile().mkdirs();
        return DatabaseFactoryKt.createEchoDatabase(DesktopDatabaseDriverKt.createDesktopDriver(platform.getDataDir()));
    }

    private static final Unit desktopModule$lambda$17(Module $this$module) {
        Module this_$iv$iv$iv;
        Module $this$iv;
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module module = $this$module;
        Function2 definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$0;
        Qualifier qualifier$iv = null;
        boolean createdAtStart$iv = false;
        boolean $i$f$single = false;
        Qualifier scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean $i$f$_singleInstanceFactory = false;
        Kind kind$iv$iv$iv = Kind.Singleton;
        List secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        boolean $i$f$_createDefinition = false;
        BeanDefinition def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        SingleInstanceFactory factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$1;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(AppPlatform.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$2;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(AudioPlayer.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$3;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(DownloadScheduler.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$4;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(BrowserLauncher.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$5;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(ExtensionRepository.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$6;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(WindowsMediaKeys.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$7;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(EchoSettings.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        $this$iv = $this$module;
        definition$iv = DesktopModuleKt::desktopModule$lambda$17$lambda$8;
        qualifier$iv = null;
        createdAtStart$iv = false;
        $i$f$single = false;
        scopeQualifier$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$_singleInstanceFactory = false;
        kind$iv$iv$iv = Kind.Singleton;
        secondaryTypes$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition = false;
        def$iv$iv = new BeanDefinition(scopeQualifier$iv$iv, Reflection.getOrCreateKotlinClass(EchoDatabase.class), qualifier$iv, definition$iv, kind$iv$iv$iv, secondaryTypes$iv$iv$iv);
        factory$iv = new SingleInstanceFactory(def$iv$iv);
        $this$iv.indexPrimaryType((InstanceFactory)factory$iv);
        if ($this$iv.get_createdAtStart()) {
            $this$iv.prepareForCreationAtStart(factory$iv);
        }
        new KoinDefinition($this$iv, (InstanceFactory)factory$iv);
        Module $this$singleOf_u24default$iv = $this$module;
        Function1 options$iv = null;
        boolean $i$f$singleOf = false;
        Function2 definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, ExtensionManager>(){

            /*
             * WARNING - void declaration
             */
            public final ExtensionManager invoke(Scope $this$single, ParametersHolder it) {
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$single;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionRepository.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                EchoSettings echoSettings = (EchoSettings)$this$new$iv.get(Reflection.getOrCreateKotlinClass(EchoSettings.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionRepository p0 = (ExtensionRepository)object;
                boolean bl = false;
                return new ExtensionManager(p0, (EchoSettings)p1);
            }
        };
        Qualifier qualifier$iv$iv = null;
        boolean createdAtStart$iv$iv = false;
        boolean $i$f$single22 = false;
        Qualifier scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean $i$f$_singleInstanceFactory2 = false;
        Kind kind$iv$iv$iv$iv = Kind.Singleton;
        List secondaryTypes$iv$iv$iv$iv = CollectionsKt.emptyList();
        boolean $i$f$_createDefinition2 = false;
        BeanDefinition def$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv);
        SingleInstanceFactory factory$iv$iv = new SingleInstanceFactory(def$iv$iv$iv);
        $this$singleOf_u24default$iv.indexPrimaryType((InstanceFactory)factory$iv$iv);
        if ($this$singleOf_u24default$iv.get_createdAtStart()) {
            $this$singleOf_u24default$iv.prepareForCreationAtStart(factory$iv$iv);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition($this$singleOf_u24default$iv, (InstanceFactory)factory$iv$iv), options$iv);
        Module $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        boolean $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, HomeViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final HomeViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionManager p0 = (ExtensionManager)object;
                boolean bl = false;
                return new HomeViewModel(p0, (CoroutineScope)p1);
            }
        };
        qualifier$iv$iv = null;
        boolean $i$f$factory = false;
        Module $i$f$single22 = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean $i$f$factory2 = false;
        boolean $i$f$_factoryInstanceFactory = false;
        Kind kind$iv$iv$iv$iv$iv = Kind.Factory;
        List secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        boolean $i$f$_createDefinition3 = false;
        BeanDefinition def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(HomeViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        FactoryInstanceFactory factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, SearchViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final SearchViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionManager p0 = (ExtensionManager)object;
                boolean bl = false;
                return new SearchViewModel(p0, (CoroutineScope)p1);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(SearchViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, LibraryViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final LibraryViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionManager p0 = (ExtensionManager)object;
                boolean bl = false;
                return new LibraryViewModel(p0, (CoroutineScope)p1);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, PlayerViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final PlayerViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p2;
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(AudioPlayer.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                Object object2 = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionManager extensionManager = (ExtensionManager)object2;
                AudioPlayer p0 = (AudioPlayer)object;
                boolean bl = false;
                return new PlayerViewModel(p0, (ExtensionManager)p1, (CoroutineScope)p2);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, ExtensionsViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final ExtensionsViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p2;
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                Object object2 = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionRepository.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionRepository extensionRepository = (ExtensionRepository)object2;
                ExtensionManager p0 = (ExtensionManager)object;
                boolean bl = false;
                return new ExtensionsViewModel(p0, (ExtensionRepository)p1, (CoroutineScope)p2);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(ExtensionsViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, DownloadsViewModel>(){

            public final DownloadsViewModel invoke(Scope $this$factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                CoroutineScope p0 = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                boolean bl = false;
                return new DownloadsViewModel(p0);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(DownloadsViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, SettingsViewModel>(){

            public final SettingsViewModel invoke(Scope $this$factory, ParametersHolder it) {
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                CoroutineScope p0 = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                boolean bl = false;
                return new SettingsViewModel(p0);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(SettingsViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        $this$factoryOf_u24default$iv = $this$module;
        options$iv = null;
        $i$f$factoryOf = false;
        definition$iv$iv = (Function2)new Function2<Scope, ParametersHolder, MediaViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final MediaViewModel invoke(Scope $this$factory, ParametersHolder it) {
                void p1;
                Intrinsics.checkNotNullParameter((Object)$this$factory, (String)"$this$factory");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope $this$new$iv = $this$factory;
                boolean $i$f$new = false;
                Qualifier qualifier$iv$iv = null;
                Function0 parameters$iv$iv = null;
                boolean $i$f$get = false;
                Object object = $this$new$iv.get(Reflection.getOrCreateKotlinClass(ExtensionManager.class), qualifier$iv$iv, parameters$iv$iv);
                qualifier$iv$iv = null;
                parameters$iv$iv = null;
                $i$f$get = false;
                CoroutineScope coroutineScope = (CoroutineScope)$this$new$iv.get(Reflection.getOrCreateKotlinClass(CoroutineScope.class), qualifier$iv$iv, parameters$iv$iv);
                ExtensionManager p0 = (ExtensionManager)object;
                boolean bl = false;
                return new MediaViewModel(p0, (CoroutineScope)p1);
            }
        };
        qualifier$iv$iv = null;
        $i$f$factory = false;
        this_$iv$iv$iv = $this$factoryOf_u24default$iv;
        scopeQualifier$iv$iv$iv = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        $i$f$factory2 = false;
        $i$f$_factoryInstanceFactory = false;
        kind$iv$iv$iv$iv$iv = Kind.Factory;
        secondaryTypes$iv$iv$iv$iv$iv = CollectionsKt.emptyList();
        $i$f$_createDefinition3 = false;
        def$iv$iv$iv$iv = new BeanDefinition(scopeQualifier$iv$iv$iv, Reflection.getOrCreateKotlinClass(MediaViewModel.class), qualifier$iv$iv, definition$iv$iv, kind$iv$iv$iv$iv$iv, secondaryTypes$iv$iv$iv$iv$iv);
        factory$iv$iv$iv = new FactoryInstanceFactory(def$iv$iv$iv$iv);
        this_$iv$iv$iv.indexPrimaryType((InstanceFactory)factory$iv$iv$iv);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(this_$iv$iv$iv, (InstanceFactory)factory$iv$iv$iv), options$iv);
        return Unit.INSTANCE;
    }
}

