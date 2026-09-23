/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentCallbacks
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Bundle
 *  android.view.View
 *  androidx.activity.ComponentActivity
 *  androidx.activity.EdgeToEdge
 *  androidx.activity.SystemBarStyle
 *  androidx.activity.SystemBarStyle$Companion
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.core.content.ContextCompat
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentContainerView
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransaction
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.ViewModelStore
 *  androidx.lifecycle.viewmodel.CreationExtras
 *  com.google.android.material.color.DynamicColors
 *  com.google.android.material.color.DynamicColorsOptions
 *  com.google.android.material.color.DynamicColorsOptions$Builder
 *  com.google.android.material.navigation.NavigationBarView
 *  dev.brahmkshatriya.echo.R$color
 *  dev.brahmkshatriya.echo.R$id
 *  dev.brahmkshatriya.echo.R$style
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.koin.android.ext.android.AndroidKoinScopeExtKt
 *  org.koin.core.qualifier.Qualifier
 *  org.koin.core.scope.Scope
 *  org.koin.viewmodel.GetViewModelKt
 */
package dev.brahmkshatriya.echo;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.color.DynamicColors;
import com.google.android.material.color.DynamicColorsOptions;
import com.google.android.material.navigation.NavigationBarView;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.databinding.ActivityMainBinding;
import dev.brahmkshatriya.echo.extensions.ExtensionLoader;
import dev.brahmkshatriya.echo.ui.common.ExceptionUtils;
import dev.brahmkshatriya.echo.ui.common.FragmentUtils;
import dev.brahmkshatriya.echo.ui.common.SnackBarHandler;
import dev.brahmkshatriya.echo.ui.common.UiViewModel;
import dev.brahmkshatriya.echo.ui.extensions.ExtensionsViewModel;
import dev.brahmkshatriya.echo.ui.main.MainFragment;
import dev.brahmkshatriya.echo.ui.player.PlayerColors;
import dev.brahmkshatriya.echo.ui.player.PlayerFragment;
import dev.brahmkshatriya.echo.utils.ContextUtils;
import dev.brahmkshatriya.echo.utils.PermsUtils;
import dev.brahmkshatriya.echo.utils.ui.UiUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.viewmodel.GetViewModelKt;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2={"Ldev/brahmkshatriya/echo/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Ldev/brahmkshatriya/echo/databinding/ActivityMainBinding;", "getBinding", "()Ldev/brahmkshatriya/echo/databinding/ActivityMainBinding;", "binding$delegate", "Lkotlin/Lazy;", "uiViewModel", "Ldev/brahmkshatriya/echo/ui/common/UiViewModel;", "getUiViewModel", "()Ldev/brahmkshatriya/echo/ui/common/UiViewModel;", "uiViewModel$delegate", "extensionLoader", "Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "getExtensionLoader", "()Ldev/brahmkshatriya/echo/extensions/ExtensionLoader;", "extensionLoader$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Back", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ndev/brahmkshatriya/echo/MainActivity\n+ 2 ActivityVM.kt\norg/koin/androidx/viewmodel/ext/android/ActivityVMKt\n+ 3 ComponentCallbackExt.kt\norg/koin/android/ext/android/ComponentCallbackExtKt\n+ 4 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 5 FragmentTransaction.kt\nandroidx/fragment/app/FragmentTransactionKt\n*L\n1#1,117:1\n40#2,7:118\n40#3,5:125\n28#4,6:130\n34#4,6:146\n39#5,5:136\n39#5,5:141\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ndev/brahmkshatriya/echo/MainActivity\n*L\n39#1:118,7\n40#1:125,5\n62#1:130,6\n62#1:146,6\n64#1:136,5\n65#1:141,5\n*E\n"})
public class MainActivity
extends AppCompatActivity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Lazy binding$delegate = LazyKt.lazy(() -> MainActivity.binding_delegate$lambda$0(this));
    @NotNull
    private final Lazy uiViewModel$delegate;
    @NotNull
    private final Lazy extensionLoader$delegate;
    @NotNull
    public static final String THEME_KEY = "theme";
    @NotNull
    public static final String AMOLED_KEY = "amoled";
    @NotNull
    public static final String BIG_COVER = "big_cover";
    @NotNull
    public static final String CUSTOM_THEME_KEY = "custom_theme";
    @NotNull
    public static final String COLOR_KEY = "color";
    @NotNull
    public static final String BACK_ANIM = "back_anim";

    public MainActivity() {
        ComponentActivity componentActivity = (ComponentActivity)this;
        Qualifier qualifier = null;
        Function0 function0 = null;
        Function0 function02 = null;
        boolean bl = false;
        this.uiViewModel$delegate = LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.NONE, (Function0)((Function0)new Function0<UiViewModel>(componentActivity, qualifier, function0, function02){
            final /* synthetic */ ComponentActivity $this_viewModel;
            final /* synthetic */ Qualifier $qualifier;
            final /* synthetic */ Function0 $extrasProducer;
            final /* synthetic */ Function0 $parameters;
            {
                this.$this_viewModel = $receiver;
                this.$qualifier = $qualifier;
                this.$extrasProducer = $extrasProducer;
                this.$parameters = $parameters;
            }

            /*
             * WARNING - void declaration
             */
            public final UiViewModel invoke() {
                void qualifier\1;
                void extrasProducer\1;
                void $this$getViewModel\1;
                ComponentActivity componentActivity = this.$this_viewModel;
                Qualifier qualifier = this.$qualifier;
                Function0 function0 = this.$extrasProducer;
                Function0 function02 = this.$parameters;
                boolean bl = false;
                ViewModelStore viewModelStore = $this$getViewModel\1.getViewModelStore();
                CreationExtras creationExtras = extrasProducer\1;
                if (creationExtras == null || (creationExtras = (CreationExtras)creationExtras.invoke()) == null) {
                    creationExtras = $this$getViewModel\1.getDefaultViewModelCreationExtras();
                }
                CreationExtras creationExtras2 = creationExtras;
                Scope scope = AndroidKoinScopeExtKt.getKoinScope((ComponentCallbacks)((ComponentCallbacks)$this$getViewModel\1));
                return GetViewModelKt.resolveViewModel$default((KClass)Reflection.getOrCreateKotlinClass(UiViewModel.class), (ViewModelStore)viewModelStore, null, (CreationExtras)creationExtras2, (Qualifier)qualifier\1, (Scope)scope, (Function0)function02, (int)4, null);
            }
        }));
        ComponentCallbacks componentCallbacks = (ComponentCallbacks)this;
        Qualifier qualifier2 = null;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        Function0 function03 = null;
        boolean bl2 = false;
        this.extensionLoader$delegate = LazyKt.lazy((LazyThreadSafetyMode)lazyThreadSafetyMode, (Function0)((Function0)new Function0<ExtensionLoader>(componentCallbacks, qualifier2, function03){
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
    public final ActivityMainBinding getBinding() {
        Lazy lazy = this.binding$delegate;
        return (ActivityMainBinding)lazy.getValue();
    }

    private final UiViewModel getUiViewModel() {
        Lazy lazy = this.uiViewModel$delegate;
        return (UiViewModel)((Object)lazy.getValue());
    }

    private final ExtensionLoader getExtensionLoader() {
        Lazy lazy = this.extensionLoader$delegate;
        return (ExtensionLoader)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentTransaction fragmentTransaction;
        super.onCreate(savedInstanceState);
        this.setTheme(Companion.getAppTheme((Context)this));
        DynamicColors.applyToActivityIfAvailable((Activity)((Activity)this), (DynamicColorsOptions)Companion.applyUiChanges((Context)this, this.getUiViewModel()));
        this.setContentView((View)this.getBinding().getRoot());
        EdgeToEdge.enable((ComponentActivity)((ComponentActivity)this), (SystemBarStyle)SystemBarStyle.Companion.auto$default((SystemBarStyle.Companion)SystemBarStyle.Companion, (int)0, (int)0, null, (int)4, null), (SystemBarStyle)(UiUtils.INSTANCE.isNightMode((Context)this) ? SystemBarStyle.Companion.dark(0) : SystemBarStyle.Companion.light(0, 0)));
        UiViewModel uiViewModel = this.getUiViewModel();
        CoordinatorLayout coordinatorLayout = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue((Object)coordinatorLayout, (String)"getRoot(...)");
        View view = (View)coordinatorLayout;
        View view2 = this.getBinding().navView;
        Intrinsics.checkNotNull((Object)view2, (String)"null cannot be cast to non-null type com.google.android.material.navigation.NavigationBarView");
        UiViewModel.Companion.setupNavBarAndInsets(this, uiViewModel, view, (NavigationBarView)view2);
        LifecycleOwner lifecycleOwner = (LifecycleOwner)this;
        UiViewModel uiViewModel2 = this.getUiViewModel();
        FragmentContainerView fragmentContainerView = this.getBinding().playerFragmentContainer;
        Intrinsics.checkNotNullExpressionValue((Object)fragmentContainerView, (String)"playerFragmentContainer");
        UiViewModel.Companion.setupPlayerBehavior(lifecycleOwner, uiViewModel2, (View)fragmentContainerView);
        UiViewModel uiViewModel3 = this.getUiViewModel();
        CoordinatorLayout coordinatorLayout2 = this.getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue((Object)coordinatorLayout2, (String)"getRoot(...)");
        ExceptionUtils.INSTANCE.setupExceptionHandler(this, SnackBarHandler.Companion.setupSnackBar(this, uiViewModel3, (View)coordinatorLayout2));
        PermsUtils.INSTANCE.checkAppPermissions((ComponentActivity)this, (Function1<? super Continuation<? super Unit>, ? extends Object>)((Function1)new Function1<Continuation<? super Unit>, Object>(this, null){
            int label;
            final /* synthetic */ MainActivity this$0;
            {
                this.this$0 = $receiver;
                super(1, $completion);
            }

            public final Object invokeSuspend(Object $result) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        MainActivity.access$getExtensionLoader(this.this$0).setPermGranted();
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Continuation<?> $completion) {
                return (Continuation)new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(Continuation<? super Unit> p1) {
                return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
            }
        }));
        ExtensionsViewModel.Companion.configureExtensionsUpdater((FragmentActivity)this);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue((Object)fragmentManager, (String)"getSupportFragmentManager(...)");
        FragmentManager fragmentManager2 = fragmentManager;
        boolean bl = false;
        boolean bl2 = false;
        FragmentTransaction fragmentTransaction2 = fragmentTransaction = fragmentManager2.beginTransaction();
        boolean bl3 = false;
        if (savedInstanceState == null) {
            void containerViewId\4;
            void $this$add_u24default\4;
            int n;
            FragmentTransaction fragmentTransaction3;
            FragmentTransaction fragmentTransaction4 = fragmentTransaction2;
            int n2 = R.id.navHostFragment;
            String string2 = "main";
            Bundle bundle = null;
            boolean bl4 = false;
            fragmentTransaction3.add(n, MainFragment.class, bundle, string2);
            fragmentTransaction3 = fragmentTransaction2;
            n = R.id.playerFragmentContainer;
            String string3 = "player";
            Bundle bundle2 = null;
            boolean bl5 = false;
            $this$add_u24default\4.add((int)containerViewId\4, PlayerFragment.class, bundle2, string3);
        }
        fragmentTransaction.commit();
        FragmentUtils.INSTANCE.setupIntents(this, this.getUiViewModel());
    }

    private static final ActivityMainBinding binding_delegate$lambda$0(MainActivity this$0) {
        return ActivityMainBinding.inflate(this$0.getLayoutInflater());
    }

    public static final /* synthetic */ ExtensionLoader access$getExtensionLoader(MainActivity $this) {
        return $this.getExtensionLoader();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Ldev/brahmkshatriya/echo/MainActivity$Back;", "Ldev/brahmkshatriya/echo/MainActivity;", "<init>", "()V", "app_debug"})
    public static final class Back
    extends MainActivity {
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\n\u001a\u00020\u000b*\u00020\fJ\n\u0010\r\u001a\u00020\u000b*\u00020\fJ\n\u0010\u000e\u001a\u00020\u000f*\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017*\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2={"Ldev/brahmkshatriya/echo/MainActivity$Companion;", "", "<init>", "()V", "THEME_KEY", "", "AMOLED_KEY", "BIG_COVER", "CUSTOM_THEME_KEY", "COLOR_KEY", "getAppTheme", "", "Landroid/content/Context;", "defaultColor", "isAmoled", "", "applyUiChanges", "Lcom/google/android/material/color/DynamicColorsOptions;", "context", "uiViewModel", "Ldev/brahmkshatriya/echo/ui/common/UiViewModel;", "BACK_ANIM", "getMainActivity", "Ljava/lang/Class;", "Ldev/brahmkshatriya/echo/MainActivity;", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ndev/brahmkshatriya/echo/MainActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public final int getAppTheme(@NotNull Context $this$getAppTheme) {
            Intrinsics.checkNotNullParameter((Object)$this$getAppTheme, (String)"<this>");
            SharedPreferences settings = ContextUtils.INSTANCE.getSettings($this$getAppTheme);
            boolean bigCover = settings.getBoolean(MainActivity.BIG_COVER, false);
            boolean amoled = settings.getBoolean(MainActivity.AMOLED_KEY, false);
            return amoled && bigCover ? R.style.AmoledBigCover : (amoled ? R.style.Amoled : (bigCover ? R.style.BigCover : R.style.Default));
        }

        public final int defaultColor(@NotNull Context $this$defaultColor) {
            Intrinsics.checkNotNullParameter((Object)$this$defaultColor, (String)"<this>");
            return ContextCompat.getColor((Context)$this$defaultColor, (int)R.color.app_color);
        }

        public final boolean isAmoled(@NotNull Context $this$isAmoled) {
            Intrinsics.checkNotNullParameter((Object)$this$isAmoled, (String)"<this>");
            return ContextUtils.INSTANCE.getSettings($this$isAmoled).getBoolean(MainActivity.AMOLED_KEY, false);
        }

        /*
         * Unable to fully structure code
         */
        @NotNull
        public final DynamicColorsOptions applyUiChanges(@NotNull Context context, @NotNull UiViewModel uiViewModel) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intrinsics.checkNotNullParameter((Object)uiViewModel, (String)"uiViewModel");
            settings = ContextUtils.INSTANCE.getSettings(context);
            var5_4 = settings.getString("theme", "system");
            if (var5_4 == null) ** GOTO lbl-1000
            tmp = -1;
            switch (var5_4.hashCode()) {
                case 102970646: {
                    if (var5_4.equals("light")) {
                        tmp = 1;
                    }
                    break;
                }
                case 3075958: {
                    if (var5_4.equals("dark")) {
                        tmp = 2;
                    }
                    break;
                }
            }
            switch (tmp) {
                case 1: {
                    v0 = 1;
                    break;
                }
                case 2: {
                    v0 = 2;
                    break;
                }
                default: lbl-1000:
                // 2 sources

                {
                    v0 = -1;
                }
            }
            mode = v0;
            AppCompatDelegate.setDefaultNightMode((int)mode);
            custom = settings.getBoolean("custom_theme", true);
            color = custom != false ? Integer.valueOf(settings.getInt("color", this.defaultColor(context))) : null;
            playerColor = settings.getBoolean("player_app_color", false);
            v1 = (PlayerColors)uiViewModel.getPlayerColors().getValue();
            if (v1 != null) {
                var10_9 = v1.getAccent();
                it\1 = ((Number)var10_9).intValue();
                $i$a$-takeIf-MainActivity$Companion$applyUiChanges$customColor$1\1\106\0 = false;
                v2 = playerColor ? var10_9 : null;
            } else {
                v2 = null;
            }
            customColor = v2;
            builder = new DynamicColorsOptions.Builder();
            v3 = customColor;
            if (v3 == null) {
                v3 = color;
            }
            if (v3 != null) {
                it\2 = ((Number)v3).intValue();
                $i$a$-let-MainActivity$Companion$applyUiChanges$1\2\109\0 = false;
                builder.setContentBasedSource(it\2);
            }
            v4 = builder.build();
            Intrinsics.checkNotNullExpressionValue((Object)v4, (String)"build(...)");
            return v4;
        }

        @NotNull
        public final Class<? extends MainActivity> getMainActivity(@NotNull Context $this$getMainActivity) {
            Intrinsics.checkNotNullParameter((Object)$this$getMainActivity, (String)"<this>");
            return ContextUtils.INSTANCE.getSettings($this$getMainActivity).getBoolean(MainActivity.BACK_ANIM, false) ? Back.class : MainActivity.class;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

