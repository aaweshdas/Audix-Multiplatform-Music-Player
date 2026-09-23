/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  kotlinx.coroutines.flow.SharedFlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import dev.brahmkshatriya.echo.MainActivity;
import dev.brahmkshatriya.echo.common.helpers.WebViewClient;
import dev.brahmkshatriya.echo.common.helpers.WebViewRequest;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.extensions.WebViewClientFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J>\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001aH\u0086@\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\f\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/extensions/WebViewClientFactory;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "requests", "", "", "Ldev/brahmkshatriya/echo/extensions/WebViewClientFactory$Wrapper;", "getRequests", "()Ljava/util/Map;", "responseFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "Lkotlin/Result;", "", "getResponseFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "await", "ext", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "showWebView", "", "reason", "request", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "await-yxL6bBk", "(Ldev/brahmkshatriya/echo/common/models/Metadata;ZLjava/lang/String;Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startWebView", "", "id", "createFor", "Ldev/brahmkshatriya/echo/common/helpers/WebViewClient;", "metadata", "Wrapper", "app_debug"})
public final class WebViewClientFactory {
    @NotNull
    private final Context context;
    @NotNull
    private final Map<Integer, Wrapper> requests;
    @NotNull
    private final MutableSharedFlow<Pair<Wrapper, Result<String>>> responseFlow;

    public WebViewClientFactory(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.context = context;
        this.requests = new LinkedHashMap();
        this.responseFlow = SharedFlowKt.MutableSharedFlow$default((int)0, (int)0, null, (int)7, null);
    }

    @NotNull
    public final Map<Integer, Wrapper> getRequests() {
        return this.requests;
    }

    @NotNull
    public final MutableSharedFlow<Pair<Wrapper, Result<String>>> getResponseFlow() {
        return this.responseFlow;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object await-yxL6bBk(@NotNull Metadata ext, boolean showWebView, @NotNull String reason, @NotNull WebViewRequest<String> request, @NotNull Continuation<? super Result<String>> $completion) {
        if (!($completion instanceof await.1)) ** GOTO lbl-1000
        var10_6 = $completion;
        if ((var10_6.label & -2147483648) != 0) {
            var10_6.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                boolean Z$0;
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ WebViewClientFactory this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    Object object = this.this$0.await-yxL6bBk(null, false, null, null, (Continuation<? super Result<String>>)((Continuation)this));
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return Result.box-impl((Object)object);
                }
            };
        }
        $result = $continuation.result;
        var11_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                wrapper = new Wrapper(ext, showWebView != false, reason, request);
                id = wrapper.hashCode();
                this.requests.put(Boxing.boxInt((int)id), wrapper);
                this.startWebView(id);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)ext);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)reason);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)request);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)wrapper);
                $continuation.Z$0 = showWebView;
                $continuation.I$0 = id;
                $continuation.label = 1;
                v0 = FlowKt.first((Flow)((Flow)this.responseFlow), (Function2)((Function2)new Function2<Pair<? extends Wrapper, ? extends Result<? extends String>>, Continuation<? super Boolean>, Object>(wrapper, null){
                    int label;
                    /* synthetic */ Object L$0;
                    final /* synthetic */ Wrapper $wrapper;
                    {
                        this.$wrapper = $wrapper;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - void declaration
                     */
                    public final Object invokeSuspend(Object $result) {
                        Pair pair = (Pair)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                void it;
                                ResultKt.throwOnFailure((Object)$result);
                                return Boxing.boxBoolean((Intrinsics.areEqual((Object)it.getFirst(), (Object)this.$wrapper) && it.getSecond() != null ? 1 : 0) != 0);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value2;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(Pair<Wrapper, Result<String>> p1, Continuation<? super Boolean> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (Continuation)$continuation);
                if (v0 == var11_8) {
                    return var11_8;
                }
                ** GOTO lbl37
            }
            case 1: {
                id = $continuation.I$0;
                showWebView = $continuation.Z$0;
                wrapper = (Wrapper)$continuation.L$3;
                request = (WebViewRequest)$continuation.L$2;
                reason = (String)$continuation.L$1;
                ext = (Metadata)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl37:
                // 2 sources

                v1 = ((Pair)v0).getSecond();
                Intrinsics.checkNotNull((Object)v1);
                res = ((Result)v1).unbox-impl();
                this.requests.remove(Boxing.boxInt((int)id));
                return res;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    private final void startWebView(int id2) {
        void $this$startWebView_u24lambda_u240\1;
        Intent intent;
        Intent intent2 = intent = new Intent(this.context, MainActivity.Companion.getMainActivity(this.context));
        int n = 0;
        Context context = this.context;
        boolean bl = false;
        $this$startWebView_u24lambda_u240\1.putExtra("webViewRequest", id2);
        Unit unit = Unit.INSTANCE;
        PendingIntent.getActivity((Context)context, (int)n, (Intent)intent, (int)0xC000000).send();
    }

    @NotNull
    public final WebViewClient createFor(@NotNull Metadata metadata2) {
        Intrinsics.checkNotNullParameter((Object)metadata2, (String)"metadata");
        return new WebViewClient(this, metadata2){
            final /* synthetic */ WebViewClientFactory this$0;
            final /* synthetic */ Metadata $metadata;
            {
                this.this$0 = $receiver;
                this.$metadata = $metadata;
            }

            /*
             * Unable to fully structure code
             */
            public Object await-BWLJW6A(boolean showWebView, String reason, WebViewRequest<String> request, Continuation<? super Result<String>> $completion) {
                if (!($completion instanceof createFor.await.1)) ** GOTO lbl-1000
                var6_5 = $completion;
                if ((var6_5.label & -2147483648) != 0) {
                    var6_5.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, $completion){
                        boolean Z$0;
                        Object L$0;
                        Object L$1;
                        /* synthetic */ Object result;
                        final /* synthetic */ createFor.1 this$0;
                        int label;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        public final Object invokeSuspend(Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            Object object = this.this$0.await-BWLJW6A(false, null, null, (Continuation<? super Result<String>>)((Continuation)this));
                            if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return object;
                            }
                            return Result.box-impl((Object)object);
                        }
                    };
                }
                $result = $continuation.result;
                var7_7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)reason);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)request);
                        $continuation.Z$0 = showWebView;
                        $continuation.label = 1;
                        v0 = this.this$0.await-yxL6bBk(this.$metadata, showWebView != false, reason, request, (Continuation<? super Result<String>>)$continuation);
                        if (v0 == var7_7) {
                            return var7_7;
                        }
                        ** GOTO lbl26
                    }
                    case 1: {
                        showWebView = $continuation.Z$0;
                        request = (WebViewRequest)$continuation.L$1;
                        reason = (String)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = ((Result)$result).unbox-impl();
lbl26:
                        // 2 sources

                        return v0;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        };
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u00c6\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/extensions/WebViewClientFactory$Wrapper;", "", "extension", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "showWebView", "", "reason", "", "request", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "<init>", "(Ldev/brahmkshatriya/echo/common/models/Metadata;ZLjava/lang/String;Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;)V", "getExtension", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "getShowWebView", "()Z", "getReason", "()Ljava/lang/String;", "getRequest", "()Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class Wrapper {
        @NotNull
        private final Metadata extension;
        private final boolean showWebView;
        @NotNull
        private final String reason;
        @NotNull
        private final WebViewRequest<String> request;

        public Wrapper(@NotNull Metadata extension2, boolean showWebView, @NotNull String reason, @NotNull WebViewRequest<String> request) {
            Intrinsics.checkNotNullParameter((Object)extension2, (String)"extension");
            Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
            Intrinsics.checkNotNullParameter(request, (String)"request");
            this.extension = extension2;
            this.showWebView = showWebView;
            this.reason = reason;
            this.request = request;
        }

        @NotNull
        public final Metadata getExtension() {
            return this.extension;
        }

        public final boolean getShowWebView() {
            return this.showWebView;
        }

        @NotNull
        public final String getReason() {
            return this.reason;
        }

        @NotNull
        public final WebViewRequest<String> getRequest() {
            return this.request;
        }

        @NotNull
        public final Metadata component1() {
            return this.extension;
        }

        public final boolean component2() {
            return this.showWebView;
        }

        @NotNull
        public final String component3() {
            return this.reason;
        }

        @NotNull
        public final WebViewRequest<String> component4() {
            return this.request;
        }

        @NotNull
        public final Wrapper copy(@NotNull Metadata extension2, boolean showWebView, @NotNull String reason, @NotNull WebViewRequest<String> request) {
            Intrinsics.checkNotNullParameter((Object)extension2, (String)"extension");
            Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
            Intrinsics.checkNotNullParameter(request, (String)"request");
            return new Wrapper(extension2, showWebView, reason, request);
        }

        public static /* synthetic */ Wrapper copy$default(Wrapper wrapper, Metadata metadata2, boolean bl, String string2, WebViewRequest webViewRequest2, int n, Object object) {
            if ((n & 1) != 0) {
                metadata2 = wrapper.extension;
            }
            if ((n & 2) != 0) {
                bl = wrapper.showWebView;
            }
            if ((n & 4) != 0) {
                string2 = wrapper.reason;
            }
            if ((n & 8) != 0) {
                webViewRequest2 = wrapper.request;
            }
            return wrapper.copy(metadata2, bl, string2, webViewRequest2);
        }

        @NotNull
        public String toString() {
            return "Wrapper(extension=" + this.extension + ", showWebView=" + this.showWebView + ", reason=" + this.reason + ", request=" + this.request + ")";
        }

        public int hashCode() {
            int result2 = this.extension.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.showWebView);
            result2 = result2 * 31 + this.reason.hashCode();
            result2 = result2 * 31 + this.request.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper)other;
            if (!Intrinsics.areEqual((Object)this.extension, (Object)wrapper.extension)) {
                return false;
            }
            if (this.showWebView != wrapper.showWebView) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.reason, (Object)wrapper.reason)) {
                return false;
            }
            return Intrinsics.areEqual(this.request, wrapper.request);
        }
    }
}

