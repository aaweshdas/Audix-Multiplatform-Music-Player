/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuationImpl
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Response
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.helpers;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b:\u0001\u0016B\u001d\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0096\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "call", "Lokhttp3/Call;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lokhttp3/Response;", "<init>", "(Lokhttp3/Call;Lkotlinx/coroutines/CancellableContinuation;)V", "onResponse", "response", "onFailure", "e", "Ljava/io/IOException;", "invoke", "Companion", "common"})
public final class ContinuationCallback
implements Callback,
Function1<Throwable, Unit> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Call call;
    @NotNull
    private final CancellableContinuation<Response> continuation;

    public ContinuationCallback(@NotNull Call call, @NotNull CancellableContinuation<? super Response> continuation) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter(continuation, (String)"continuation");
        this.call = call;
        this.continuation = continuation;
    }

    public void onResponse(@NotNull Call call, @NotNull Response response2) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response2, (String)"response");
        ((Continuation)this.continuation).resumeWith(Result.constructor-impl((Object)response2));
    }

    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)e, (String)"e");
        if (!call.isCanceled()) {
            ((Continuation)this.continuation).resumeWith(Result.constructor-impl((Object)ResultKt.createFailure((Throwable)e)));
        }
    }

    public void invoke(@Nullable Throwable cause) {
        try {
            this.call.cancel();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0086H\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ContinuationCallback$Companion;", "", "<init>", "()V", "await", "Lokhttp3/Response;", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    @SourceDebugExtension(value={"SMAP\nContinuationCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContinuationCallback.kt\ndev/brahmkshatriya/echo/common/helpers/ContinuationCallback$Companion\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,47:1\n426#2,11:48\n*S KotlinDebug\n*F\n+ 1 ContinuationCallback.kt\ndev/brahmkshatriya/echo/common/helpers/ContinuationCallback$Companion\n*L\n40#1:48,11\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final Object await(@NotNull Call $this$await, @NotNull Continuation<? super Response> $completion) {
            boolean $i$f$await = false;
            boolean $i$f$suspendCancellableCoroutine = false;
            Continuation<? super Response> uCont$iv = $completion;
            boolean bl = false;
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
            cancellable$iv.initCancellability();
            CancellableContinuation continuation = (CancellableContinuation)cancellable$iv;
            boolean bl2 = false;
            ContinuationCallback callback2 = new ContinuationCallback($this$await, (CancellableContinuation<? super Response>)continuation);
            $this$await.enqueue((Callback)callback2);
            continuation.invokeOnCancellation((Function1)callback2);
            Object object = cancellable$iv.getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return object;
        }

        private final Object await$$forInline(Call $this$await, Continuation<? super Response> $completion) {
            boolean $i$f$await = false;
            boolean $i$f$suspendCancellableCoroutine = false;
            InlineMarker.mark((int)0);
            Continuation<? super Response> uCont$iv = $completion;
            boolean bl = false;
            CancellableContinuationImpl cancellable$iv = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
            cancellable$iv.initCancellability();
            CancellableContinuation continuation = (CancellableContinuation)cancellable$iv;
            boolean bl2 = false;
            ContinuationCallback callback2 = new ContinuationCallback($this$await, (CancellableContinuation<? super Response>)continuation);
            $this$await.enqueue((Callback)callback2);
            continuation.invokeOnCancellation((Function1)callback2);
            Object object = cancellable$iv.getResult();
            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            InlineMarker.mark((int)1);
            return object;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

