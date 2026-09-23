/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.SharedPreferences
 *  androidx.media3.datasource.cache.SimpleCache
 *  androidx.work.ListenableWorker
 *  androidx.work.WorkerParameters
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.koin.android.ext.koin.ModuleExtKt
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
 *  org.koin.core.qualifier.TypeQualifier
 *  org.koin.core.registry.ScopeRegistry
 *  org.koin.core.scope.Scope
 *  org.koin.dsl.DefinitionBindingKt
 *  org.koin.dsl.ModuleDSLKt
 */
package dev.brahmkshatriya.echo.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Playlist;
import dev.brahmkshatriya.echo.di.App;
import dev.brahmkshatriya.echo.download.DownloadWorker;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.DownloadDatabase;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader;
import dev.brahmkshatriya.echo.playback.PlayerService;
import dev.brahmkshatriya.echo.playback.PlayerState;
import dev.brahmkshatriya.echo.ui.common.SnackBarHandler;
import dev.brahmkshatriya.echo.ui.common.UiViewModel;
import dev.brahmkshatriya.echo.ui.download.DownloadViewModel;
import dev.brahmkshatriya.echo.ui.extensions.ExtensionInfoViewModel;
import dev.brahmkshatriya.echo.ui.extensions.ExtensionsViewModel;
import dev.brahmkshatriya.echo.ui.extensions.add.AddViewModel;
import dev.brahmkshatriya.echo.ui.extensions.login.LoginUserListViewModel;
import dev.brahmkshatriya.echo.ui.extensions.login.LoginViewModel;
import dev.brahmkshatriya.echo.ui.feed.FeedViewModel;
import dev.brahmkshatriya.echo.ui.main.search.SearchViewModel;
import dev.brahmkshatriya.echo.ui.media.MediaViewModel;
import dev.brahmkshatriya.echo.ui.player.PlayerViewModel;
import dev.brahmkshatriya.echo.ui.player.more.info.TrackInfoViewModel;
import dev.brahmkshatriya.echo.ui.player.more.lyrics.LyricsViewModel;
import dev.brahmkshatriya.echo.ui.playlist.create.CreatePlaylistViewModel;
import dev.brahmkshatriya.echo.ui.playlist.delete.DeletePlaylistViewModel;
import dev.brahmkshatriya.echo.ui.playlist.edit.EditPlaylistViewModel;
import dev.brahmkshatriya.echo.ui.playlist.save.SaveToPlaylistViewModel;
import dev.brahmkshatriya.echo.utils.ContextUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.koin.android.ext.koin.ModuleExtKt;
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
import org.koin.core.qualifier.TypeQualifier;
import org.koin.core.registry.ScopeRegistry;
import org.koin.core.scope.Scope;
import org.koin.dsl.DefinitionBindingKt;
import org.koin.dsl.ModuleDSLKt;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/brahmkshatriya/echo/di/DI;", "", "<init>", "()V", "baseModule", "Lorg/koin/core/module/Module;", "extensionModule", "downloadModule", "playerModule", "uiModules", "appModule", "getAppModule", "()Lorg/koin/core/module/Module;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nDI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DI.kt\ndev/brahmkshatriya/echo/di/DI\n+ 2 Module.kt\norg/koin/core/module/Module\n+ 3 Module.kt\norg/koin/core/module/ModuleKt\n+ 4 BeanDefinition.kt\norg/koin/core/definition/BeanDefinitionKt\n+ 5 SingleOf.kt\norg/koin/core/module/dsl/SingleOfKt\n+ 6 WorkerOf.kt\norg/koin/androidx/workmanager/dsl/WorkerOfKt\n+ 7 ModuleExt.kt\norg/koin/androidx/workmanager/dsl/ModuleExtKt\n+ 8 Qualifier.kt\norg/koin/core/qualifier/QualifierKt\n+ 9 ViewModelOf.kt\norg/koin/core/module/dsl/ViewModelOfKt\n+ 10 ModuleExt.kt\norg/koin/core/module/dsl/ModuleExtKt\n*L\n1#1,92:1\n105#2,6:93\n111#2,5:121\n105#2,6:130\n111#2,5:158\n105#2,6:167\n111#2,5:195\n105#2,6:204\n111#2,5:232\n105#2,6:241\n111#2,5:269\n153#2,10:282\n163#2,2:308\n105#2,6:316\n111#2,5:344\n105#2,6:349\n111#2,5:377\n105#2,6:386\n111#2,5:414\n153#2,10:428\n163#2,2:454\n153#2,10:465\n163#2,2:491\n153#2,10:502\n163#2,2:528\n153#2,10:539\n163#2,2:565\n153#2,10:576\n163#2,2:602\n153#2,10:613\n163#2,2:639\n153#2,10:650\n163#2,2:676\n153#2,10:687\n163#2,2:713\n153#2,10:724\n163#2,2:750\n153#2,10:761\n163#2,2:787\n153#2,10:798\n163#2,2:824\n153#2,10:835\n163#2,2:861\n153#2,10:872\n163#2,2:898\n153#2,10:909\n163#2,2:935\n153#2,10:946\n163#2,2:972\n153#2,10:983\n163#2,2:1009\n153#2,10:1020\n163#2,2:1046\n196#3,7:99\n203#3:120\n196#3,7:136\n203#3:157\n196#3,7:173\n203#3:194\n196#3,7:210\n203#3:231\n196#3,7:247\n203#3:268\n212#3:292\n213#3:307\n196#3,7:322\n203#3:343\n196#3,7:355\n203#3:376\n196#3,7:392\n203#3:413\n212#3:438\n213#3:453\n212#3:475\n213#3:490\n212#3:512\n213#3:527\n212#3:549\n213#3:564\n212#3:586\n213#3:601\n212#3:623\n213#3:638\n212#3:660\n213#3:675\n212#3:697\n213#3:712\n212#3:734\n213#3:749\n212#3:771\n213#3:786\n212#3:808\n213#3:823\n212#3:845\n213#3:860\n212#3:882\n213#3:897\n212#3:919\n213#3:934\n212#3:956\n213#3:971\n212#3:993\n213#3:1008\n212#3:1030\n213#3:1045\n115#4,14:106\n115#4,14:143\n115#4,14:180\n115#4,14:217\n115#4,14:254\n115#4,14:293\n115#4,14:329\n115#4,14:362\n115#4,14:399\n115#4,14:439\n115#4,14:476\n115#4,14:513\n115#4,14:550\n115#4,14:587\n115#4,14:624\n115#4,14:661\n115#4,14:698\n115#4,14:735\n115#4,14:772\n115#4,14:809\n115#4,14:846\n115#4,14:883\n115#4,14:920\n115#4,14:957\n115#4,14:994\n115#4,14:1031\n55#5,4:126\n55#5,4:163\n47#5,4:200\n63#5,4:237\n55#5,4:312\n47#5,4:382\n56#6,4:274\n32#7,2:278\n36#7:281\n37#7,2:310\n42#8:280\n64#9,4:419\n88#9,4:456\n64#9,4:493\n72#9,4:530\n56#9,4:567\n72#9,4:604\n48#9,4:641\n56#9,4:678\n64#9,4:715\n56#9,4:752\n56#9,4:789\n96#9,4:826\n56#9,4:863\n80#9,4:900\n72#9,4:937\n96#9,4:974\n64#9,4:1011\n33#10,5:423\n33#10,5:460\n33#10,5:497\n33#10,5:534\n33#10,5:571\n33#10,5:608\n33#10,5:645\n33#10,5:682\n33#10,5:719\n33#10,5:756\n33#10,5:793\n33#10,5:830\n33#10,5:867\n33#10,5:904\n33#10,5:941\n33#10,5:978\n33#10,5:1015\n*S KotlinDebug\n*F\n+ 1 DI.kt\ndev/brahmkshatriya/echo/di/DI\n*L\n37#1:93,6\n37#1:121,5\n38#1:130,6\n38#1:158,5\n43#1:167,6\n43#1:195,5\n48#1:204,6\n48#1:232,5\n49#1:241,6\n49#1:269,5\n50#1:282,10\n50#1:308,2\n55#1:316,6\n55#1:344,5\n56#1:349,6\n56#1:377,5\n60#1:386,6\n60#1:414,5\n61#1:428,10\n61#1:454,2\n63#1:465,10\n63#1:491,2\n64#1:502,10\n64#1:528,2\n65#1:539,10\n65#1:565,2\n67#1:576,10\n67#1:602,2\n68#1:613,10\n68#1:639,2\n69#1:650,10\n69#1:676,2\n70#1:687,10\n70#1:713,2\n71#1:724,10\n71#1:750,2\n73#1:761,10\n73#1:787,2\n74#1:798,10\n74#1:824,2\n75#1:835,10\n75#1:861,2\n77#1:872,10\n77#1:898,2\n78#1:909,10\n78#1:935,2\n79#1:946,10\n79#1:972,2\n80#1:983,10\n80#1:1009,2\n82#1:1020,10\n82#1:1046,2\n37#1:99,7\n37#1:120\n38#1:136,7\n38#1:157\n43#1:173,7\n43#1:194\n48#1:210,7\n48#1:231\n49#1:247,7\n49#1:268\n50#1:292\n50#1:307\n55#1:322,7\n55#1:343\n56#1:355,7\n56#1:376\n60#1:392,7\n60#1:413\n61#1:438\n61#1:453\n63#1:475\n63#1:490\n64#1:512\n64#1:527\n65#1:549\n65#1:564\n67#1:586\n67#1:601\n68#1:623\n68#1:638\n69#1:660\n69#1:675\n70#1:697\n70#1:712\n71#1:734\n71#1:749\n73#1:771\n73#1:786\n74#1:808\n74#1:823\n75#1:845\n75#1:860\n77#1:882\n77#1:897\n78#1:919\n78#1:934\n79#1:956\n79#1:971\n80#1:993\n80#1:1008\n82#1:1030\n82#1:1045\n37#1:106,14\n38#1:143,14\n43#1:180,14\n48#1:217,14\n49#1:254,14\n50#1:293,14\n55#1:329,14\n56#1:362,14\n60#1:399,14\n61#1:439,14\n63#1:476,14\n64#1:513,14\n65#1:550,14\n67#1:587,14\n68#1:624,14\n69#1:661,14\n70#1:698,14\n71#1:735,14\n73#1:772,14\n74#1:809,14\n75#1:846,14\n77#1:883,14\n78#1:920,14\n79#1:957,14\n80#1:994,14\n82#1:1031,14\n38#1:126,4\n43#1:163,4\n48#1:200,4\n49#1:237,4\n55#1:312,4\n60#1:382,4\n50#1:274,4\n50#1:278,2\n50#1:281\n50#1:310,2\n50#1:280\n61#1:419,4\n63#1:456,4\n64#1:493,4\n65#1:530,4\n67#1:567,4\n68#1:604,4\n69#1:641,4\n70#1:678,4\n71#1:715,4\n73#1:752,4\n74#1:789,4\n75#1:826,4\n77#1:863,4\n78#1:900,4\n79#1:937,4\n80#1:974,4\n82#1:1011,4\n61#1:423,5\n63#1:460,5\n64#1:497,5\n65#1:534,5\n67#1:571,5\n68#1:608,5\n69#1:645,5\n70#1:682,5\n71#1:719,5\n73#1:756,5\n74#1:793,5\n75#1:830,5\n77#1:867,5\n78#1:904,5\n79#1:941,5\n80#1:978,5\n82#1:1015,5\n*E\n"})
public final class DI {
    @NotNull
    public static final DI INSTANCE = new DI();
    @NotNull
    private static final Module baseModule = ModuleDSLKt.module$default((boolean)false, DI::baseModule$lambda$1, (int)1, null);
    @NotNull
    private static final Module extensionModule = ModuleDSLKt.module$default((boolean)false, DI::extensionModule$lambda$3, (int)1, null);
    @NotNull
    private static final Module downloadModule = ModuleDSLKt.module$default((boolean)false, DI::downloadModule$lambda$7, (int)1, null);
    @NotNull
    private static final Module playerModule = ModuleDSLKt.module$default((boolean)false, DI::playerModule$lambda$10, (int)1, null);
    @NotNull
    private static final Module uiModules = ModuleDSLKt.module$default((boolean)false, DI::uiModules$lambda$29, (int)1, null);
    @NotNull
    private static final Module appModule = ModuleDSLKt.module$default((boolean)false, DI::appModule$lambda$30, (int)1, null);

    private DI() {
    }

    @NotNull
    public final Module getAppModule() {
        return appModule;
    }

    private static final SharedPreferences baseModule$lambda$1$lambda$0(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return ContextUtils.INSTANCE.getSettings((Context)ModuleExtKt.androidApplication((Scope)$this$single));
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit baseModule$lambda$1(Module $this$module) {
        void $this\1;
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module module = $this$module;
        Function2 function2 = DI::baseModule$lambda$1$lambda$0;
        Qualifier qualifier = null;
        boolean bl = false;
        boolean bl2 = false;
        Qualifier qualifier2 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl3 = false;
        Kind kind = Kind.Singleton;
        List list2 = CollectionsKt.emptyList();
        boolean bl4 = false;
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(SharedPreferences.class), qualifier, function2, kind, list2);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        $this\1.indexPrimaryType((InstanceFactory)singleInstanceFactory);
        if ($this\1.get_createdAtStart()) {
            $this\1.prepareForCreationAtStart(singleInstanceFactory);
        }
        new KoinDefinition((Module)$this\1, (InstanceFactory)singleInstanceFactory);
        Module module2 = $this$module;
        Function1 function1 = null;
        boolean bl5 = false;
        Function2 function22 = (Function2)new Function2<Scope, ParametersHolder, App>(){

            /*
             * WARNING - void declaration
             */
            public final App invoke(Scope $this$single, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                SharedPreferences sharedPreferences = (SharedPreferences)scope.get(Reflection.getOrCreateKotlinClass(SharedPreferences.class), qualifier2, function02);
                Application application = (Application)scope.get(Reflection.getOrCreateKotlinClass(Application.class), qualifier, function0);
                boolean bl4 = false;
                return new App(application, (SharedPreferences)p1\4);
            }
        };
        Qualifier qualifier3 = null;
        boolean bl6 = false;
        boolean bl7 = false;
        Qualifier qualifier4 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl8 = false;
        Kind kind2 = Kind.Singleton;
        List list3 = CollectionsKt.emptyList();
        boolean bl9 = false;
        BeanDefinition beanDefinition2 = new BeanDefinition(qualifier4, Reflection.getOrCreateKotlinClass(App.class), qualifier3, function22, kind2, list3);
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        module2.indexPrimaryType((InstanceFactory)singleInstanceFactory2);
        if (module2.get_createdAtStart()) {
            module2.prepareForCreationAtStart(singleInstanceFactory2);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(module2, (InstanceFactory)singleInstanceFactory2), function1);
        return Unit.INSTANCE;
    }

    private static final Unit extensionModule$lambda$3(Module $this$module) {
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module[] moduleArray = new Module[]{baseModule};
        $this$module.includes(moduleArray);
        Module module = $this$module;
        Function1 function1 = null;
        boolean bl = false;
        Function2 function2 = (Function2)new Function2<Scope, ParametersHolder, ExtensionLoader>(){

            /*
             * WARNING - void declaration
             */
            public final ExtensionLoader invoke(Scope $this$single, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                SimpleCache simpleCache = (SimpleCache)scope.get(Reflection.getOrCreateKotlinClass(SimpleCache.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl4 = false;
                return new ExtensionLoader(app, (SimpleCache)p1\4);
            }
        };
        Qualifier qualifier = null;
        boolean bl2 = false;
        boolean bl3 = false;
        Qualifier qualifier2 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl4 = false;
        Kind kind = Kind.Singleton;
        List list2 = CollectionsKt.emptyList();
        boolean bl5 = false;
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function2, kind, list2);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        module.indexPrimaryType((InstanceFactory)singleInstanceFactory);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(module, (InstanceFactory)singleInstanceFactory), function1);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit downloadModule$lambda$7(Module $this$module) {
        void this_\13;
        void $this$worker_u24default\10;
        void $this$singleOf_u24default\1;
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module module = new Module[]{extensionModule};
        $this$module.includes((Module[])module);
        module = $this$module;
        DownloadDatabase.Companion companion = DownloadDatabase.Companion;
        Function1 function1 = null;
        boolean bl = false;
        Function2 function2 = (Function2)new Function2<Scope, ParametersHolder, DownloadDatabase>(companion){
            final /* synthetic */ DownloadDatabase.Companion $receiver$inlined;
            {
                this.$receiver$inlined = companion;
            }

            public final DownloadDatabase invoke(Scope $this$single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Application application = (Application)scope.get(Reflection.getOrCreateKotlinClass(Application.class), qualifier, function0);
                boolean bl3 = false;
                return this.$receiver$inlined.create(application);
            }
        };
        Qualifier qualifier = null;
        boolean bl2 = false;
        boolean bl3 = false;
        Qualifier qualifier2 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl4 = false;
        Kind kind = Kind.Singleton;
        List list2 = CollectionsKt.emptyList();
        boolean bl5 = false;
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(DownloadDatabase.class), qualifier, function2, kind, list2);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        $this$singleOf_u24default\1.indexPrimaryType((InstanceFactory)singleInstanceFactory);
        if ($this$singleOf_u24default\1.get_createdAtStart()) {
            $this$singleOf_u24default\1.prepareForCreationAtStart(singleInstanceFactory);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)$this$singleOf_u24default\1, (InstanceFactory)singleInstanceFactory), function1);
        Module module2 = $this$module;
        Function1 function12 = null;
        boolean bl6 = false;
        Function2 function22 = (Function2)new Function2<Scope, ParametersHolder, Downloader>(){

            /*
             * WARNING - void declaration
             */
            public final Downloader invoke(Scope $this$single, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                DownloadDatabase downloadDatabase = (DownloadDatabase)((Object)scope.get(Reflection.getOrCreateKotlinClass(DownloadDatabase.class), qualifier3, function03));
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl5 = false;
                return new Downloader(app, (ExtensionLoader)p1\5, (DownloadDatabase)p2\5);
            }
        };
        Qualifier qualifier3 = null;
        boolean bl7 = false;
        boolean bl8 = false;
        Qualifier qualifier4 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl9 = false;
        Kind kind2 = Kind.Singleton;
        List list3 = CollectionsKt.emptyList();
        boolean bl10 = false;
        BeanDefinition beanDefinition2 = new BeanDefinition(qualifier4, Reflection.getOrCreateKotlinClass(Downloader.class), qualifier3, function22, kind2, list3);
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        module2.indexPrimaryType((InstanceFactory)singleInstanceFactory2);
        if (module2.get_createdAtStart()) {
            module2.prepareForCreationAtStart(singleInstanceFactory2);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(module2, (InstanceFactory)singleInstanceFactory2), function12);
        Module module3 = $this$module;
        Function1 function13 = null;
        boolean bl11 = false;
        function22 = module3;
        Function2 function23 = (Function2)new Function2<Scope, ParametersHolder, DownloadWorker>(){

            /*
             * WARNING - void declaration
             */
            public final DownloadWorker invoke(Scope $this$worker, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$worker, (String)"$this$worker");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$worker;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Downloader downloader = (Downloader)scope.get(Reflection.getOrCreateKotlinClass(Downloader.class), qualifier3, function03);
                WorkerParameters workerParameters = (WorkerParameters)scope.get(Reflection.getOrCreateKotlinClass(WorkerParameters.class), qualifier2, function02);
                Context context = (Context)scope.get(Reflection.getOrCreateKotlinClass(Context.class), qualifier, function0);
                boolean bl5 = false;
                return (ListenableWorker)new DownloadWorker(context, (WorkerParameters)p1\5, (Downloader)p2\5);
            }
        };
        boolean bl12 = false;
        Qualifier qualifier5 = (Qualifier)new TypeQualifier(Reflection.getOrCreateKotlinClass(DownloadWorker.class));
        boolean bl13 = false;
        void this_\12 = $this$worker_u24default\10;
        boolean bl14 = false;
        kind2 = this_\12;
        Qualifier qualifier6 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl15 = false;
        boolean bl16 = false;
        Kind kind3 = Kind.Factory;
        List list4 = CollectionsKt.emptyList();
        boolean bl17 = false;
        BeanDefinition beanDefinition3 = new BeanDefinition(qualifier6, Reflection.getOrCreateKotlinClass(DownloadWorker.class), qualifier5, function23, kind3, list4);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition3);
        this_\13.indexPrimaryType((InstanceFactory)factoryInstanceFactory);
        KoinDefinition koinDefinition = new KoinDefinition((Module)this_\13, (InstanceFactory)factoryInstanceFactory);
        DefinitionBindingKt.bind((KoinDefinition)koinDefinition, (KClass)Reflection.getOrCreateKotlinClass(ListenableWorker.class));
        OptionDSLKt.onOptions((KoinDefinition)koinDefinition, function13);
        return Unit.INSTANCE;
    }

    private static final PlayerState playerModule$lambda$10$lambda$9(Scope $this$single, ParametersHolder it) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new PlayerState(null, null, null, 7, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit playerModule$lambda$10(Module $this$module) {
        void $this\5;
        Module module;
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module module2 = new Module[]{extensionModule};
        $this$module.includes((Module[])module2);
        module2 = $this$module;
        PlayerService.Companion companion = PlayerService.Companion;
        Function1 function1 = null;
        boolean bl = false;
        Function2 function2 = (Function2)new Function2<Scope, ParametersHolder, SimpleCache>(companion){
            final /* synthetic */ PlayerService.Companion $receiver$inlined;
            {
                this.$receiver$inlined = companion;
            }

            /*
             * WARNING - void declaration
             */
            public final SimpleCache invoke(Scope $this$single, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                SharedPreferences sharedPreferences = (SharedPreferences)scope.get(Reflection.getOrCreateKotlinClass(SharedPreferences.class), qualifier2, function02);
                Application application = (Application)scope.get(Reflection.getOrCreateKotlinClass(Application.class), qualifier, function0);
                boolean bl4 = false;
                return this.$receiver$inlined.getCache(application, (SharedPreferences)p1\4);
            }
        };
        Qualifier qualifier = null;
        boolean bl2 = false;
        boolean bl3 = false;
        Qualifier qualifier2 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl4 = false;
        Kind kind = Kind.Singleton;
        List list2 = CollectionsKt.emptyList();
        boolean bl5 = false;
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(SimpleCache.class), qualifier, function2, kind, list2);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        module.indexPrimaryType((InstanceFactory)singleInstanceFactory);
        if (module.get_createdAtStart()) {
            module.prepareForCreationAtStart(singleInstanceFactory);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(module, (InstanceFactory)singleInstanceFactory), function1);
        module = $this$module;
        Function2 function22 = DI::playerModule$lambda$10$lambda$9;
        Qualifier qualifier3 = null;
        boolean bl6 = false;
        boolean bl7 = false;
        Qualifier qualifier4 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl8 = false;
        Kind kind2 = Kind.Singleton;
        List list3 = CollectionsKt.emptyList();
        boolean bl9 = false;
        BeanDefinition beanDefinition2 = new BeanDefinition(qualifier4, Reflection.getOrCreateKotlinClass(PlayerState.class), qualifier3, function22, kind2, list3);
        SingleInstanceFactory singleInstanceFactory2 = new SingleInstanceFactory(beanDefinition2);
        $this\5.indexPrimaryType((InstanceFactory)singleInstanceFactory2);
        if ($this\5.get_createdAtStart()) {
            $this\5.prepareForCreationAtStart(singleInstanceFactory2);
        }
        new KoinDefinition((Module)$this\5, (InstanceFactory)singleInstanceFactory2);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit uiModules$lambda$29(Module $this$module) {
        void this_\104;
        void $this$viewModel_u24default\102;
        void this_\98;
        Module module;
        void this_\92;
        Module module2;
        void this_\86;
        Module module3;
        void this_\80;
        Module module4;
        void this_\74;
        Module module5;
        void this_\68;
        Module module6;
        void this_\62;
        Module module7;
        void this_\56;
        Module module8;
        void this_\50;
        Module module9;
        void this_\44;
        Module module10;
        void this_\38;
        Module module11;
        void this_\32;
        Module module12;
        void this_\26;
        Module module13;
        void this_\20;
        Module module14;
        void this_\14;
        Module module15;
        void this_\8;
        Module module16;
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module module17 = $this$module;
        Function1 function1 = null;
        boolean bl = false;
        Function2 function2 = (Function2)new Function2<Scope, ParametersHolder, SnackBarHandler>(){

            public final SnackBarHandler invoke(Scope $this$single, ParametersHolder it) {
                Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$single;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl3 = false;
                return new SnackBarHandler(app);
            }
        };
        Qualifier qualifier = null;
        boolean bl2 = false;
        boolean bl3 = false;
        Qualifier qualifier2 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl4 = false;
        Kind kind = Kind.Singleton;
        List list2 = CollectionsKt.emptyList();
        boolean bl5 = false;
        BeanDefinition beanDefinition = new BeanDefinition(qualifier2, Reflection.getOrCreateKotlinClass(SnackBarHandler.class), qualifier, function2, kind, list2);
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        module17.indexPrimaryType((InstanceFactory)singleInstanceFactory);
        if (module17.get_createdAtStart()) {
            module17.prepareForCreationAtStart(singleInstanceFactory);
        }
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition(module17, (InstanceFactory)singleInstanceFactory), function1);
        Module module18 = $this$module;
        Function1 function12 = null;
        boolean bl6 = false;
        function2 = module18;
        Function2 function22 = (Function2)new Function2<Scope, ParametersHolder, UiViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final UiViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                PlayerState playerState = (PlayerState)scope.get(Reflection.getOrCreateKotlinClass(PlayerState.class), qualifier3, function03);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                Context context = (Context)scope.get(Reflection.getOrCreateKotlinClass(Context.class), qualifier, function0);
                boolean bl5 = false;
                return new UiViewModel(context, (ExtensionLoader)p1\5, (PlayerState)p2\5);
            }
        };
        Qualifier qualifier3 = null;
        boolean bl7 = false;
        void this_\7 = module16;
        boolean bl8 = false;
        kind = this_\7;
        Qualifier qualifier4 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl9 = false;
        boolean bl10 = false;
        Kind kind2 = Kind.Factory;
        List list3 = CollectionsKt.emptyList();
        boolean bl11 = false;
        BeanDefinition beanDefinition2 = new BeanDefinition(qualifier4, Reflection.getOrCreateKotlinClass(UiViewModel.class), qualifier3, function22, kind2, list3);
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(beanDefinition2);
        this_\8.indexPrimaryType((InstanceFactory)factoryInstanceFactory);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\8, (InstanceFactory)factoryInstanceFactory), function12);
        Module module19 = $this$module;
        Function1 function13 = null;
        boolean bl12 = false;
        module16 = module19;
        Function2 function23 = (Function2)new Function2<Scope, ParametersHolder, PlayerViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final PlayerViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p5\8;
                void p4\8;
                void p3\8;
                void p2\8;
                void p1\8;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                Qualifier qualifier5 = null;
                Function0 function05 = null;
                boolean bl6 = false;
                Qualifier qualifier6 = null;
                Function0 function06 = null;
                boolean bl7 = false;
                Downloader downloader = (Downloader)scope.get(Reflection.getOrCreateKotlinClass(Downloader.class), qualifier6, function06);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier5, function05);
                SimpleCache simpleCache = (SimpleCache)scope.get(Reflection.getOrCreateKotlinClass(SimpleCache.class), qualifier4, function04);
                SharedPreferences sharedPreferences = (SharedPreferences)scope.get(Reflection.getOrCreateKotlinClass(SharedPreferences.class), qualifier3, function03);
                PlayerState playerState = (PlayerState)scope.get(Reflection.getOrCreateKotlinClass(PlayerState.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl8 = false;
                return new PlayerViewModel(app, (PlayerState)p1\8, (SharedPreferences)p2\8, (SimpleCache)p3\8, (ExtensionLoader)p4\8, (Downloader)p5\8);
            }
        };
        Qualifier qualifier5 = null;
        boolean bl13 = false;
        void this_\13 = module15;
        boolean bl14 = false;
        this_\8 = this_\13;
        Qualifier qualifier6 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl15 = false;
        boolean bl16 = false;
        Kind kind3 = Kind.Factory;
        List list4 = CollectionsKt.emptyList();
        boolean bl17 = false;
        BeanDefinition beanDefinition3 = new BeanDefinition(qualifier6, Reflection.getOrCreateKotlinClass(PlayerViewModel.class), qualifier5, function23, kind3, list4);
        FactoryInstanceFactory factoryInstanceFactory2 = new FactoryInstanceFactory(beanDefinition3);
        this_\14.indexPrimaryType((InstanceFactory)factoryInstanceFactory2);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\14, (InstanceFactory)factoryInstanceFactory2), function13);
        Module module20 = $this$module;
        Function1 function14 = null;
        boolean bl18 = false;
        module15 = module20;
        Function2 function24 = (Function2)new Function2<Scope, ParametersHolder, LyricsViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final LyricsViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                PlayerState playerState = (PlayerState)scope.get(Reflection.getOrCreateKotlinClass(PlayerState.class), qualifier3, function03);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl5 = false;
                return new LyricsViewModel(app, (ExtensionLoader)p1\5, (PlayerState)p2\5);
            }
        };
        Qualifier qualifier7 = null;
        boolean bl19 = false;
        void this_\19 = module14;
        boolean bl20 = false;
        this_\14 = this_\19;
        Qualifier qualifier8 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl21 = false;
        boolean bl22 = false;
        Kind kind4 = Kind.Factory;
        List list5 = CollectionsKt.emptyList();
        boolean bl23 = false;
        BeanDefinition beanDefinition4 = new BeanDefinition(qualifier8, Reflection.getOrCreateKotlinClass(LyricsViewModel.class), qualifier7, function24, kind4, list5);
        FactoryInstanceFactory factoryInstanceFactory3 = new FactoryInstanceFactory(beanDefinition4);
        this_\20.indexPrimaryType((InstanceFactory)factoryInstanceFactory3);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\20, (InstanceFactory)factoryInstanceFactory3), function14);
        Module module21 = $this$module;
        Function1 function15 = null;
        boolean bl24 = false;
        module14 = module21;
        Function2 function25 = (Function2)new Function2<Scope, ParametersHolder, TrackInfoViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final TrackInfoViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p3\6;
                void p2\6;
                void p1\6;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                Downloader downloader = (Downloader)scope.get(Reflection.getOrCreateKotlinClass(Downloader.class), qualifier4, function04);
                PlayerState playerState = (PlayerState)scope.get(Reflection.getOrCreateKotlinClass(PlayerState.class), qualifier3, function03);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl6 = false;
                return new TrackInfoViewModel(app, (ExtensionLoader)p1\6, (PlayerState)p2\6, (Downloader)p3\6);
            }
        };
        Qualifier qualifier9 = null;
        boolean bl25 = false;
        void this_\25 = module13;
        boolean bl26 = false;
        this_\20 = this_\25;
        Qualifier qualifier10 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl27 = false;
        boolean bl28 = false;
        Kind kind5 = Kind.Factory;
        List list6 = CollectionsKt.emptyList();
        boolean bl29 = false;
        BeanDefinition beanDefinition5 = new BeanDefinition(qualifier10, Reflection.getOrCreateKotlinClass(TrackInfoViewModel.class), qualifier9, function25, kind5, list6);
        FactoryInstanceFactory factoryInstanceFactory4 = new FactoryInstanceFactory(beanDefinition5);
        this_\26.indexPrimaryType((InstanceFactory)factoryInstanceFactory4);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\26, (InstanceFactory)factoryInstanceFactory4), function15);
        Module module22 = $this$module;
        Function1 function16 = null;
        boolean bl30 = false;
        module13 = module22;
        Function2 function26 = (Function2)new Function2<Scope, ParametersHolder, ExtensionsViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final ExtensionsViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier2, function02);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl4 = false;
                return new ExtensionsViewModel(extensionLoader, (App)p1\4);
            }
        };
        Qualifier qualifier11 = null;
        boolean bl31 = false;
        void this_\31 = module12;
        boolean bl32 = false;
        this_\26 = this_\31;
        Qualifier qualifier12 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl33 = false;
        boolean bl34 = false;
        Kind kind6 = Kind.Factory;
        List list7 = CollectionsKt.emptyList();
        boolean bl35 = false;
        BeanDefinition beanDefinition6 = new BeanDefinition(qualifier12, Reflection.getOrCreateKotlinClass(ExtensionsViewModel.class), qualifier11, function26, kind6, list7);
        FactoryInstanceFactory factoryInstanceFactory5 = new FactoryInstanceFactory(beanDefinition6);
        this_\32.indexPrimaryType((InstanceFactory)factoryInstanceFactory5);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\32, (InstanceFactory)factoryInstanceFactory5), function16);
        Module module23 = $this$module;
        Function1 function17 = null;
        boolean bl36 = false;
        module12 = module23;
        Function2 function27 = (Function2)new Function2<Scope, ParametersHolder, ExtensionInfoViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final ExtensionInfoViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p3\6;
                void p2\6;
                void p1\6;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier4, function04);
                ExtensionType extensionType = (ExtensionType)((Object)scope.get(Reflection.getOrCreateKotlinClass(ExtensionType.class), qualifier3, function03));
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl6 = false;
                return new ExtensionInfoViewModel(app, (ExtensionLoader)p1\6, (ExtensionType)p2\6, (String)p3\6);
            }
        };
        Qualifier qualifier13 = null;
        boolean bl37 = false;
        void this_\37 = module11;
        boolean bl38 = false;
        this_\32 = this_\37;
        Qualifier qualifier14 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl39 = false;
        boolean bl40 = false;
        Kind kind7 = Kind.Factory;
        List list8 = CollectionsKt.emptyList();
        boolean bl41 = false;
        BeanDefinition beanDefinition7 = new BeanDefinition(qualifier14, Reflection.getOrCreateKotlinClass(ExtensionInfoViewModel.class), qualifier13, function27, kind7, list8);
        FactoryInstanceFactory factoryInstanceFactory6 = new FactoryInstanceFactory(beanDefinition7);
        this_\38.indexPrimaryType((InstanceFactory)factoryInstanceFactory6);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\38, (InstanceFactory)factoryInstanceFactory6), function17);
        Module module24 = $this$module;
        Function1 function18 = null;
        boolean bl42 = false;
        module11 = module24;
        Function2 function28 = (Function2)new Function2<Scope, ParametersHolder, LoginUserListViewModel>(){

            public final LoginUserListViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl3 = false;
                return new LoginUserListViewModel(extensionLoader);
            }
        };
        Qualifier qualifier15 = null;
        boolean bl43 = false;
        void this_\43 = module10;
        boolean bl44 = false;
        this_\38 = this_\43;
        Qualifier qualifier16 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl45 = false;
        boolean bl46 = false;
        Kind kind8 = Kind.Factory;
        List list9 = CollectionsKt.emptyList();
        boolean bl47 = false;
        BeanDefinition beanDefinition8 = new BeanDefinition(qualifier16, Reflection.getOrCreateKotlinClass(LoginUserListViewModel.class), qualifier15, function28, kind8, list9);
        FactoryInstanceFactory factoryInstanceFactory7 = new FactoryInstanceFactory(beanDefinition8);
        this_\44.indexPrimaryType((InstanceFactory)factoryInstanceFactory7);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\44, (InstanceFactory)factoryInstanceFactory7), function18);
        Module module25 = $this$module;
        Function1 function19 = null;
        boolean bl48 = false;
        module10 = module25;
        Function2 function29 = (Function2)new Function2<Scope, ParametersHolder, AddViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final AddViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl4 = false;
                return new AddViewModel(app, (ExtensionLoader)p1\4);
            }
        };
        Qualifier qualifier17 = null;
        boolean bl49 = false;
        void this_\49 = module9;
        boolean bl50 = false;
        this_\44 = this_\49;
        Qualifier qualifier18 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl51 = false;
        boolean bl52 = false;
        Kind kind9 = Kind.Factory;
        List list10 = CollectionsKt.emptyList();
        boolean bl53 = false;
        BeanDefinition beanDefinition9 = new BeanDefinition(qualifier18, Reflection.getOrCreateKotlinClass(AddViewModel.class), qualifier17, function29, kind9, list10);
        FactoryInstanceFactory factoryInstanceFactory8 = new FactoryInstanceFactory(beanDefinition9);
        this_\50.indexPrimaryType((InstanceFactory)factoryInstanceFactory8);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\50, (InstanceFactory)factoryInstanceFactory8), function19);
        Module module26 = $this$module;
        Function1 function110 = null;
        boolean bl54 = false;
        module9 = module26;
        Function2 function210 = (Function2)new Function2<Scope, ParametersHolder, LoginViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final LoginViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier3, function03);
                ExtensionType extensionType = (ExtensionType)((Object)scope.get(Reflection.getOrCreateKotlinClass(ExtensionType.class), qualifier2, function02));
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl5 = false;
                return new LoginViewModel(extensionLoader, (ExtensionType)p1\5, (String)p2\5);
            }
        };
        Qualifier qualifier19 = null;
        boolean bl55 = false;
        void this_\55 = module8;
        boolean bl56 = false;
        this_\50 = this_\55;
        Qualifier qualifier20 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl57 = false;
        boolean bl58 = false;
        Kind kind10 = Kind.Factory;
        List list11 = CollectionsKt.emptyList();
        boolean bl59 = false;
        BeanDefinition beanDefinition10 = new BeanDefinition(qualifier20, Reflection.getOrCreateKotlinClass(LoginViewModel.class), qualifier19, function210, kind10, list11);
        FactoryInstanceFactory factoryInstanceFactory9 = new FactoryInstanceFactory(beanDefinition10);
        this_\56.indexPrimaryType((InstanceFactory)factoryInstanceFactory9);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\56, (InstanceFactory)factoryInstanceFactory9), function110);
        Module module27 = $this$module;
        Function1 function111 = null;
        boolean bl60 = false;
        module8 = module27;
        Function2 function211 = (Function2)new Function2<Scope, ParametersHolder, FeedViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final FeedViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl4 = false;
                return new FeedViewModel(app, (ExtensionLoader)p1\4);
            }
        };
        Qualifier qualifier21 = null;
        boolean bl61 = false;
        void this_\61 = module7;
        boolean bl62 = false;
        this_\56 = this_\61;
        Qualifier qualifier22 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl63 = false;
        boolean bl64 = false;
        Kind kind11 = Kind.Factory;
        List list12 = CollectionsKt.emptyList();
        boolean bl65 = false;
        BeanDefinition beanDefinition11 = new BeanDefinition(qualifier22, Reflection.getOrCreateKotlinClass(FeedViewModel.class), qualifier21, function211, kind11, list12);
        FactoryInstanceFactory factoryInstanceFactory10 = new FactoryInstanceFactory(beanDefinition11);
        this_\62.indexPrimaryType((InstanceFactory)factoryInstanceFactory10);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\62, (InstanceFactory)factoryInstanceFactory10), function111);
        Module module28 = $this$module;
        Function1 function112 = null;
        boolean bl66 = false;
        module7 = module28;
        Function2 function212 = (Function2)new Function2<Scope, ParametersHolder, SearchViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final SearchViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl4 = false;
                return new SearchViewModel(app, (ExtensionLoader)p1\4);
            }
        };
        Qualifier qualifier23 = null;
        boolean bl67 = false;
        void this_\67 = module6;
        boolean bl68 = false;
        this_\62 = this_\67;
        Qualifier qualifier24 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl69 = false;
        boolean bl70 = false;
        Kind kind12 = Kind.Factory;
        List list13 = CollectionsKt.emptyList();
        boolean bl71 = false;
        BeanDefinition beanDefinition12 = new BeanDefinition(qualifier24, Reflection.getOrCreateKotlinClass(SearchViewModel.class), qualifier23, function212, kind12, list13);
        FactoryInstanceFactory factoryInstanceFactory11 = new FactoryInstanceFactory(beanDefinition12);
        this_\68.indexPrimaryType((InstanceFactory)factoryInstanceFactory11);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\68, (InstanceFactory)factoryInstanceFactory11), function112);
        Module module29 = $this$module;
        Function1 function113 = null;
        boolean bl72 = false;
        module6 = module29;
        Function2 function213 = (Function2)new Function2<Scope, ParametersHolder, MediaViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final MediaViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p6\9;
                void p5\9;
                void p4\9;
                void p3\9;
                void p2\9;
                void p1\9;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                Qualifier qualifier5 = null;
                Function0 function05 = null;
                boolean bl6 = false;
                Qualifier qualifier6 = null;
                Function0 function06 = null;
                boolean bl7 = false;
                Qualifier qualifier7 = null;
                Function0 function07 = null;
                boolean bl8 = false;
                boolean bl9 = (Boolean)scope.get(Reflection.getOrCreateKotlinClass(Boolean.class), qualifier7, function07);
                EchoMediaItem echoMediaItem = (EchoMediaItem)scope.get(Reflection.getOrCreateKotlinClass(EchoMediaItem.class), qualifier6, function06);
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier5, function05);
                boolean bl10 = (Boolean)scope.get(Reflection.getOrCreateKotlinClass(Boolean.class), qualifier4, function04);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier3, function03);
                Downloader downloader = (Downloader)scope.get(Reflection.getOrCreateKotlinClass(Downloader.class), qualifier2, function02);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl11 = false;
                return new MediaViewModel(extensionLoader, (Downloader)p1\9, (App)p2\9, (boolean)p3\9, (String)p4\9, (EchoMediaItem)p5\9, (boolean)p6\9);
            }
        };
        Qualifier qualifier25 = null;
        boolean bl73 = false;
        void this_\73 = module5;
        boolean bl74 = false;
        this_\68 = this_\73;
        Qualifier qualifier26 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl75 = false;
        boolean bl76 = false;
        Kind kind13 = Kind.Factory;
        List list14 = CollectionsKt.emptyList();
        boolean bl77 = false;
        BeanDefinition beanDefinition13 = new BeanDefinition(qualifier26, Reflection.getOrCreateKotlinClass(MediaViewModel.class), qualifier25, function213, kind13, list14);
        FactoryInstanceFactory factoryInstanceFactory12 = new FactoryInstanceFactory(beanDefinition13);
        this_\74.indexPrimaryType((InstanceFactory)factoryInstanceFactory12);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\74, (InstanceFactory)factoryInstanceFactory12), function113);
        Module module30 = $this$module;
        Function1 function114 = null;
        boolean bl78 = false;
        module5 = module30;
        Function2 function214 = (Function2)new Function2<Scope, ParametersHolder, CreatePlaylistViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final CreatePlaylistViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p1\4;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl4 = false;
                return new CreatePlaylistViewModel(app, (ExtensionLoader)p1\4);
            }
        };
        Qualifier qualifier27 = null;
        boolean bl79 = false;
        void this_\79 = module4;
        boolean bl80 = false;
        this_\74 = this_\79;
        Qualifier qualifier28 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl81 = false;
        boolean bl82 = false;
        Kind kind14 = Kind.Factory;
        List list15 = CollectionsKt.emptyList();
        boolean bl83 = false;
        BeanDefinition beanDefinition14 = new BeanDefinition(qualifier28, Reflection.getOrCreateKotlinClass(CreatePlaylistViewModel.class), qualifier27, function214, kind14, list15);
        FactoryInstanceFactory factoryInstanceFactory13 = new FactoryInstanceFactory(beanDefinition14);
        this_\80.indexPrimaryType((InstanceFactory)factoryInstanceFactory13);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\80, (InstanceFactory)factoryInstanceFactory13), function114);
        Module module31 = $this$module;
        Function1 function115 = null;
        boolean bl84 = false;
        module4 = module31;
        Function2 function215 = (Function2)new Function2<Scope, ParametersHolder, DeletePlaylistViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final DeletePlaylistViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p4\7;
                void p3\7;
                void p2\7;
                void p1\7;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                Qualifier qualifier5 = null;
                Function0 function05 = null;
                boolean bl6 = false;
                boolean bl7 = (Boolean)scope.get(Reflection.getOrCreateKotlinClass(Boolean.class), qualifier5, function05);
                Playlist playlist = (Playlist)scope.get(Reflection.getOrCreateKotlinClass(Playlist.class), qualifier4, function04);
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier3, function03);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier2, function02);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl8 = false;
                return new DeletePlaylistViewModel(extensionLoader, (App)p1\7, (String)p2\7, (Playlist)p3\7, (boolean)p4\7);
            }
        };
        Qualifier qualifier29 = null;
        boolean bl85 = false;
        void this_\85 = module3;
        boolean bl86 = false;
        this_\80 = this_\85;
        Qualifier qualifier30 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl87 = false;
        boolean bl88 = false;
        Kind kind15 = Kind.Factory;
        List list16 = CollectionsKt.emptyList();
        boolean bl89 = false;
        BeanDefinition beanDefinition15 = new BeanDefinition(qualifier30, Reflection.getOrCreateKotlinClass(DeletePlaylistViewModel.class), qualifier29, function215, kind15, list16);
        FactoryInstanceFactory factoryInstanceFactory14 = new FactoryInstanceFactory(beanDefinition15);
        this_\86.indexPrimaryType((InstanceFactory)factoryInstanceFactory14);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\86, (InstanceFactory)factoryInstanceFactory14), function115);
        Module module32 = $this$module;
        Function1 function116 = null;
        boolean bl90 = false;
        module3 = module32;
        Function2 function216 = (Function2)new Function2<Scope, ParametersHolder, SaveToPlaylistViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final SaveToPlaylistViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p3\6;
                void p2\6;
                void p1\6;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier4, function04);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier3, function03);
                EchoMediaItem echoMediaItem = (EchoMediaItem)scope.get(Reflection.getOrCreateKotlinClass(EchoMediaItem.class), qualifier2, function02);
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier, function0);
                boolean bl6 = false;
                return new SaveToPlaylistViewModel(string2, (EchoMediaItem)p1\6, (App)p2\6, (ExtensionLoader)p3\6);
            }
        };
        Qualifier qualifier31 = null;
        boolean bl91 = false;
        void this_\91 = module2;
        boolean bl92 = false;
        this_\86 = this_\91;
        Qualifier qualifier32 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl93 = false;
        boolean bl94 = false;
        Kind kind16 = Kind.Factory;
        List list17 = CollectionsKt.emptyList();
        boolean bl95 = false;
        BeanDefinition beanDefinition16 = new BeanDefinition(qualifier32, Reflection.getOrCreateKotlinClass(SaveToPlaylistViewModel.class), qualifier31, function216, kind16, list17);
        FactoryInstanceFactory factoryInstanceFactory15 = new FactoryInstanceFactory(beanDefinition16);
        this_\92.indexPrimaryType((InstanceFactory)factoryInstanceFactory15);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\92, (InstanceFactory)factoryInstanceFactory15), function116);
        Module module33 = $this$module;
        Function1 function117 = null;
        boolean bl96 = false;
        module2 = module33;
        Function2 function217 = (Function2)new Function2<Scope, ParametersHolder, EditPlaylistViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final EditPlaylistViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p6\9;
                void p5\9;
                void p4\9;
                void p3\9;
                void p2\9;
                void p1\9;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Qualifier qualifier4 = null;
                Function0 function04 = null;
                boolean bl5 = false;
                Qualifier qualifier5 = null;
                Function0 function05 = null;
                boolean bl6 = false;
                Qualifier qualifier6 = null;
                Function0 function06 = null;
                boolean bl7 = false;
                Qualifier qualifier7 = null;
                Function0 function07 = null;
                boolean bl8 = false;
                int n = ((Number)scope.get(Reflection.getOrCreateKotlinClass(Integer.class), qualifier7, function07)).intValue();
                String string2 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier6, function06);
                boolean bl9 = (Boolean)scope.get(Reflection.getOrCreateKotlinClass(Boolean.class), qualifier5, function05);
                Playlist playlist = (Playlist)scope.get(Reflection.getOrCreateKotlinClass(Playlist.class), qualifier4, function04);
                String string3 = (String)scope.get(Reflection.getOrCreateKotlinClass(String.class), qualifier3, function03);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier2, function02);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier, function0);
                boolean bl10 = false;
                return new EditPlaylistViewModel(extensionLoader, (App)p1\9, (String)p2\9, (Playlist)p3\9, (boolean)p4\9, (String)p5\9, (int)p6\9);
            }
        };
        Qualifier qualifier33 = null;
        boolean bl97 = false;
        void this_\97 = module;
        boolean bl98 = false;
        this_\92 = this_\97;
        Qualifier qualifier34 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl99 = false;
        boolean bl100 = false;
        Kind kind17 = Kind.Factory;
        List list18 = CollectionsKt.emptyList();
        boolean bl101 = false;
        BeanDefinition beanDefinition17 = new BeanDefinition(qualifier34, Reflection.getOrCreateKotlinClass(EditPlaylistViewModel.class), qualifier33, function217, kind17, list18);
        FactoryInstanceFactory factoryInstanceFactory16 = new FactoryInstanceFactory(beanDefinition17);
        this_\98.indexPrimaryType((InstanceFactory)factoryInstanceFactory16);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\98, (InstanceFactory)factoryInstanceFactory16), function117);
        Module module34 = $this$module;
        Function1 function118 = null;
        boolean bl102 = false;
        module = module34;
        Function2 function218 = (Function2)new Function2<Scope, ParametersHolder, DownloadViewModel>(){

            /*
             * WARNING - void declaration
             */
            public final DownloadViewModel invoke(Scope $this$viewModel, ParametersHolder it) {
                void p2\5;
                void p1\5;
                Intrinsics.checkNotNullParameter((Object)$this$viewModel, (String)"$this$viewModel");
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                Scope scope = $this$viewModel;
                boolean bl = false;
                Qualifier qualifier = null;
                Function0 function0 = null;
                boolean bl2 = false;
                Qualifier qualifier2 = null;
                Function0 function02 = null;
                boolean bl3 = false;
                Qualifier qualifier3 = null;
                Function0 function03 = null;
                boolean bl4 = false;
                Downloader downloader = (Downloader)scope.get(Reflection.getOrCreateKotlinClass(Downloader.class), qualifier3, function03);
                ExtensionLoader extensionLoader = (ExtensionLoader)scope.get(Reflection.getOrCreateKotlinClass(ExtensionLoader.class), qualifier2, function02);
                App app = (App)scope.get(Reflection.getOrCreateKotlinClass(App.class), qualifier, function0);
                boolean bl5 = false;
                return new DownloadViewModel(app, (ExtensionLoader)p1\5, (Downloader)p2\5);
            }
        };
        Qualifier qualifier35 = null;
        boolean bl103 = false;
        void this_\103 = $this$viewModel_u24default\102;
        boolean bl104 = false;
        this_\98 = this_\103;
        Qualifier qualifier36 = (Qualifier)ScopeRegistry.Companion.getRootScopeQualifier();
        boolean bl105 = false;
        boolean bl106 = false;
        Kind kind18 = Kind.Factory;
        List list19 = CollectionsKt.emptyList();
        boolean bl107 = false;
        BeanDefinition beanDefinition18 = new BeanDefinition(qualifier36, Reflection.getOrCreateKotlinClass(DownloadViewModel.class), qualifier35, function218, kind18, list19);
        FactoryInstanceFactory factoryInstanceFactory17 = new FactoryInstanceFactory(beanDefinition18);
        this_\104.indexPrimaryType((InstanceFactory)factoryInstanceFactory17);
        OptionDSLKt.onOptions((KoinDefinition)new KoinDefinition((Module)this_\104, (InstanceFactory)factoryInstanceFactory17), function118);
        return Unit.INSTANCE;
    }

    private static final Unit appModule$lambda$30(Module $this$module) {
        Intrinsics.checkNotNullParameter((Object)$this$module, (String)"$this$module");
        Module[] moduleArray = new Module[]{baseModule};
        $this$module.includes(moduleArray);
        moduleArray = new Module[]{extensionModule};
        $this$module.includes(moduleArray);
        moduleArray = new Module[]{playerModule};
        $this$module.includes(moduleArray);
        moduleArray = new Module[]{downloadModule};
        $this$module.includes(moduleArray);
        moduleArray = new Module[]{uiModules};
        $this$module.includes(moduleArray);
        return Unit.INSTANCE;
    }
}

