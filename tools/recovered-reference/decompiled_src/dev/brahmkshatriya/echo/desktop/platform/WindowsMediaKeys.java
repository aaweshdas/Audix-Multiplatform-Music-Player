/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  com.sun.jna.platform.win32.User32
 *  com.sun.jna.platform.win32.WinUser$MSG
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinUser;
import dev.brahmkshatriya.echo.core.platform.AudioPlayer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/desktop/platform/WindowsMediaKeys;", "", "player", "Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AudioPlayer;Lkotlinx/coroutines/CoroutineScope;)V", "hookJob", "Lkotlinx/coroutines/Job;", "start", "", "stop", "Companion", "desktopApp"})
@StabilityInferred(parameters=0)
public final class WindowsMediaKeys {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AudioPlayer player;
    @NotNull
    private final CoroutineScope scope;
    @Nullable
    private Job hookJob;
    public static final int $stable = 8;
    public static final int HOTKEY_PLAY_PAUSE = 1001;
    public static final int HOTKEY_NEXT = 1002;
    public static final int HOTKEY_PREV = 1003;
    public static final int HOTKEY_STOP = 1004;
    public static final int VK_MEDIA_NEXT_TRACK = 176;
    public static final int VK_MEDIA_PREV_TRACK = 177;
    public static final int VK_MEDIA_STOP = 178;
    public static final int VK_MEDIA_PLAY_PAUSE = 179;

    public WindowsMediaKeys(@NotNull AudioPlayer player, @NotNull CoroutineScope scope) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)scope, (String)"scope");
        this.player = player;
        this.scope = scope;
    }

    public /* synthetic */ WindowsMediaKeys(AudioPlayer audioPlayer, CoroutineScope coroutineScope, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            coroutineScope = CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getDefault()));
        }
        this(audioPlayer, coroutineScope);
    }

    public final void start() {
        String string2 = System.getProperty("os.name");
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getProperty(...)");
        String string3 = string2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
        String os = string3;
        if (!StringsKt.contains$default((CharSequence)os, (CharSequence)"win", (boolean)false, (int)2, null)) {
            return;
        }
        this.hookJob = BuildersKt.launch$default((CoroutineScope)this.scope, (CoroutineContext)((CoroutineContext)Dispatchers.getIO()), null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ WindowsMediaKeys this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$launch;
                        ResultKt.throwOnFailure((Object)$result);
                        void var3_3 = $this$launch;
                        WindowsMediaKeys windowsMediaKeys = this.this$0;
                        try {
                            void $this$invokeSuspend_u24lambda_u240 = var3_3;
                            boolean bl = false;
                            User32 user32 = User32.INSTANCE;
                            user32.RegisterHotKey(null, 1001, 0, 179);
                            user32.RegisterHotKey(null, 1002, 0, 176);
                            user32.RegisterHotKey(null, 1003, 0, 177);
                            user32.RegisterHotKey(null, 1004, 0, 178);
                            WinUser.MSG msg = new WinUser.MSG();
                            try {
                                while (user32.GetMessage(msg, null, 0, 0) != 0) {
                                    if (msg.message != 786) continue;
                                    switch (msg.wParam.intValue()) {
                                        case 1001: {
                                            WindowsMediaKeys.access$getPlayer$p(windowsMediaKeys).togglePlayPause();
                                            break;
                                        }
                                        case 1002: {
                                            WindowsMediaKeys.access$getPlayer$p(windowsMediaKeys).skipNext();
                                            break;
                                        }
                                        case 1003: {
                                            WindowsMediaKeys.access$getPlayer$p(windowsMediaKeys).skipPrevious();
                                            break;
                                        }
                                        case 1004: {
                                            WindowsMediaKeys.access$getPlayer$p(windowsMediaKeys).stop();
                                        }
                                    }
                                }
                            }
                            finally {
                                user32.UnregisterHotKey(null, 1001);
                                user32.UnregisterHotKey(null, 1002);
                                user32.UnregisterHotKey(null, 1003);
                                user32.UnregisterHotKey(null, 1004);
                            }
                            Object object = Result.constructor-impl((Object)Unit.INSTANCE);
                        }
                        catch (Throwable throwable) {
                            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                        }
                        return Unit.INSTANCE;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }), (int)2, null);
    }

    public final void stop() {
        block0: {
            Job job2 = this.hookJob;
            if (job2 == null) break block0;
            Job.DefaultImpls.cancel$default((Job)job2, null, (int)1, null);
        }
    }

    public static final /* synthetic */ AudioPlayer access$getPlayer$p(WindowsMediaKeys $this) {
        return $this.player;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/brahmkshatriya/echo/desktop/platform/WindowsMediaKeys$Companion;", "", "<init>", "()V", "HOTKEY_PLAY_PAUSE", "", "HOTKEY_NEXT", "HOTKEY_PREV", "HOTKEY_STOP", "VK_MEDIA_NEXT_TRACK", "VK_MEDIA_PREV_TRACK", "VK_MEDIA_STOP", "VK_MEDIA_PLAY_PAUSE", "desktopApp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

