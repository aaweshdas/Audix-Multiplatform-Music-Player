/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions;

import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.core.extensions.ExtensionUtils$getExtensionFlow$;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086@\u00a2\u0006\u0004\b\r\u0010\u000eJW\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0004\b\u0001\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0004\b\u0011\u0010\u000eJY\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\u0005\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0004\b\u0001\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0004\b\u0013\u0010\u000eJ.\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0019JW\u0010\u001a\u001a\u00020\u001b\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0002\u0010\u001cJU\u0010\u001d\u001a\u00020\u001b*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086@\u00a2\u0006\u0002\u0010 J8\u0010!\u001a\u0004\u0018\u0001H\u0015\"\f\b\u0000\u0010\u0015*\u0006\u0012\u0002\b\u00030\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150#0\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@\u00a2\u0006\u0002\u0010$J6\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\"\"\f\b\u0000\u0010\u0015*\u0006\u0012\u0002\b\u00030\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150#0\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a8\u0006&"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/ExtensionUtils;", "", "<init>", "()V", "get", "Lkotlin/Result;", "R", "Ldev/brahmkshatriya/echo/common/Extension;", "block", "Lkotlin/Function2;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "get-0E7RQCE", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAs", "C", "getAs-0E7RQCE", "getIf", "getIf-0E7RQCE", "getOrEmit", "T", "throwableFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runIf", "", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inject", "id", "", "(Ldev/brahmkshatriya/echo/common/Extension;Ljava/lang/String;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtension", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtensionFlow", "core"})
@SourceDebugExtension(value={"SMAP\nExtensionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionUtils.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,83:1\n43#1,4:85\n1#2:84\n49#3:89\n51#3:93\n46#4:90\n51#4:92\n105#5:91\n*S KotlinDebug\n*F\n+ 1 ExtensionUtils.kt\ndev/brahmkshatriya/echo/core/extensions/ExtensionUtils\n*L\n61#1:85,4\n81#1:89\n81#1:93\n81#1:90\n81#1:92\n81#1:91\n*E\n"})
public final class ExtensionUtils {
    @NotNull
    public static final ExtensionUtils INSTANCE = new ExtensionUtils();

    private ExtensionUtils() {
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <R> Object get-0E7RQCE(@NotNull Extension<?> $this$get_u2d0E7RQCE, @NotNull Function2<? super ExtensionClient, ? super Continuation<? super R>, ? extends Object> block, @NotNull Continuation<? super Result<? extends R>> $completion) {
        if (!($completion instanceof get.1)) ** GOTO lbl-1000
        var11_4 = $completion;
        if ((var11_4.label & -2147483648) != 0) {
            var11_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ ExtensionUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    Object object = this.this$0.get-0E7RQCE(null, null, (Continuation)this);
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return Result.box-impl((Object)object);
                }
            };
        }
        $result = $continuation.result;
        var12_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = $this$get_u2d0E7RQCE;
                $this$get_0E7RQCE_u24lambda_u242 = var4_7;
                $i$a$-runCatching-ExtensionUtils$get$2 = 0;
                var7_12 = $this$get_0E7RQCE_u24lambda_u242;
                $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240 = var7_12;
                $i$a$-runCatching-ExtensionUtils$get$2$1 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get_u2d0E7RQCE);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$get_0E7RQCE_u24lambda_u242);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$get_0E7RQCE_u24lambda_u242_u24lambda_u240);
                $continuation.I$0 = $i$a$-runCatching-ExtensionUtils$get$2;
                $continuation.I$1 = $i$a$-runCatching-ExtensionUtils$get$2$1;
                $continuation.label = 1;
                v0 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getDefault()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super R>, Object>(block, $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240, null){
                    Object L$0;
                    int label;
                    final /* synthetic */ Function2<ExtensionClient, Continuation<? super R>, Object> $block;
                    final /* synthetic */ Extension<?> $this_runCatching;
                    {
                        this.$block = $block;
                        this.$this_runCatching = $receiver;
                        super(2, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object invokeSuspend(Object $result) {
                        var4_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                this.L$0 = var3_3 = this.$block;
                                this.label = 1;
                                v0 = this.$this_runCatching.getInstance().value-IoAF18A((Continuation)this);
                                if (v0 == var4_2) {
                                    return var4_2;
                                }
                                ** GOTO lbl15
                            }
                            case 1: {
                                var3_3 = (Function2<ExtensionClient, Continuation<? super R>, Object>)this.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = ((Result)$result).unbox-impl();
lbl15:
                                // 2 sources

                                var2_4 = v0;
                                ResultKt.throwOnFailure((Object)var2_4);
                                this.L$0 = null;
                                this.label = 2;
                                v1 = var3_3.invoke(var2_4, (Object)this);
                                if (v1 == var4_2) {
                                    return var4_2;
                                }
                                ** GOTO lbl26
                            }
                            case 2: {
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl26:
                                // 2 sources

                                return v1;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(CoroutineScope p1, Continuation<? super R> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), $continuation);
                ** if (v0 != var12_6) goto lbl34
lbl33:
                // 1 sources

                return var12_6;
lbl34:
                // 1 sources

                ** GOTO lbl48
            }
            case 1: {
                $i$a$-runCatching-ExtensionUtils$get$2$1 = $continuation.I$1;
                $i$a$-runCatching-ExtensionUtils$get$2 = $continuation.I$0;
                $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240 = (Extension)$continuation.L$3;
                $this$get_0E7RQCE_u24lambda_u242 = (Extension)$continuation.L$2;
                block = (Function2)$continuation.L$1;
                $this$get_u2d0E7RQCE = (Extension)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl48:
                    // 2 sources

                    $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240 = Result.constructor-impl((Object)v0);
                    {
                        catch (Throwable $i$a$-runCatching-ExtensionUtils$get$2$1) {
                            $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-ExtensionUtils$get$2$1));
                        }
                    }
                    var7_12 = $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240;
                    v1 = Result.exceptionOrNull-impl((Object)var7_12);
                    if (v1 != null) {
                        it = v1;
                        $i$a$-getOrElse-ExtensionUtils$get$2$2 = false;
                        throw it;
                    }
                    var5_8 = Result.constructor-impl((Object)var7_12);
                }
                catch (Throwable var6_11) {
                    var5_8 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var6_11));
                }
                return var5_8;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final /* synthetic */ <C, R> Object getAs-0E7RQCE(Extension<?> $this$getAs_u2d0E7RQCE, Function2<? super C, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super Result<? extends R>> $completion) {
        boolean bl = false;
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<ExtensionClient, Continuation<? super R>, Object>(block, null){
            Object L$1;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Function2<C, Continuation<? super R>, Object> $block;
            {
                this.$block = $block;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object $result) {
                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        void $this$get;
                        ResultKt.throwOnFailure((Object)$result);
                        Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                        Object object2 = $this$get;
                        if (object2 == null) {
                            Intrinsics.reifiedOperationMarker((int)4, (String)"C");
                            String string2 = Reflection.getOrCreateKotlinClass(Object.class).getSimpleName();
                            if (string2 != null) throw new ClientException.NotSupported(string2);
                            string2 = "Unknown";
                            throw new ClientException.NotSupported(string2);
                        }
                        Object client = object2;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                        this.label = 1;
                        Object object3 = this.$block.invoke(client, (Object)((Object)this));
                        if (object3 != object) return object3;
                        return object;
                    }
                    case 1: {
                        Object client = this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        Object object3 = $result;
                        return object3;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend$$forInline(Object $result) {
                void $this$get;
                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                InlineMarker.mark((int)10);
                Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                Object object = $this$get;
                if (object == null) {
                    Intrinsics.reifiedOperationMarker((int)4, (String)"C");
                    String string2 = Reflection.getOrCreateKotlinClass(Object.class).getSimpleName();
                    throw new ClientException.NotSupported(string2 != null ? string2 : "Unknown");
                }
                Object client = object;
                return this.$block.invoke(client, (Object)((Object)this));
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(ExtensionClient p1, Continuation<? super R> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
        InlineMarker.mark((int)0);
        Object object = this.get-0E7RQCE($this$getAs_u2d0E7RQCE, function2, $completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        return ((Result)object).unbox-impl();
    }

    public final /* synthetic */ <C, R> Object getIf-0E7RQCE(Extension<?> $this$getIf_u2d0E7RQCE, Function2<? super C, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super Result<? extends R>> $completion) {
        boolean bl = false;
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<ExtensionClient, Continuation<? super R>, Object>(block, null){
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Function2<C, Continuation<? super R>, Object> $block;
            {
                this.$block = $block;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                Object object;
                block5: {
                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            void $this$get;
                            Object client;
                            ResultKt.throwOnFailure((Object)$result);
                            Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                            Object object3 = client = (Object)$this$get;
                            if (object3 == null) break;
                            Object object4 = object3;
                            Function2<C, Continuation<? super R>, Object> function2 = this.$block;
                            Object it = object4;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it);
                            this.I$0 = n;
                            this.label = 1;
                            object = function2.invoke(it, (Object)((Object)this));
                            if (object == object2) {
                                return object2;
                            }
                            break block5;
                        }
                        case 1: {
                            int n = this.I$0;
                            Object it = this.L$2;
                            Object client = this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            object = $result;
                            break block5;
                        }
                    }
                    object = null;
                }
                return object;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend$$forInline(Object $result) {
                Object object;
                void $this$get;
                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                InlineMarker.mark((int)10);
                Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                Object client = $this$get;
                if (client != null) {
                    Object object2 = client;
                    Function2<C, Continuation<? super R>, Object> function2 = this.$block;
                    Object it = object2;
                    boolean bl = false;
                    InlineMarker.mark((int)3);
                    object = function2.invoke(it, null);
                } else {
                    object = null;
                }
                return object;
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(ExtensionClient p1, Continuation<? super R> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
        InlineMarker.mark((int)0);
        Object object = this.get-0E7RQCE($this$getIf_u2d0E7RQCE, function2, $completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        return ((Result)object).unbox-impl();
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <T> Object getOrEmit(@NotNull Object $this$getOrEmit, @NotNull MutableSharedFlow<Throwable> throwableFlow, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof getOrEmit.1)) ** GOTO lbl-1000
        var8_4 = $completion;
        if ((var8_4.label & -2147483648) != 0) {
            var8_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ ExtensionUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getOrEmit(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = $this$getOrEmit;
                v0 = Result.exceptionOrNull-impl((Object)var4_7);
                if (v0 != null) ** GOTO lbl17
                v1 = var4_7;
                ** GOTO lbl38
lbl17:
                // 1 sources

                it = v0;
                $i$a$-getOrElse-ExtensionUtils$getOrEmit$2 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$getOrEmit);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)throwableFlow);
                $continuation.L$2 = it;
                $continuation.I$0 = $i$a$-getOrElse-ExtensionUtils$getOrEmit$2;
                $continuation.label = 1;
                v2 = throwableFlow.emit((Object)it, $continuation);
                if (v2 == var9_6) {
                    return var9_6;
                }
                ** GOTO lbl35
            }
            case 1: {
                $i$a$-getOrElse-ExtensionUtils$getOrEmit$2 = $continuation.I$0;
                it = (Throwable)$continuation.L$2;
                throwableFlow = (MutableSharedFlow)$continuation.L$1;
                $this$getOrEmit = $continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl35:
                // 2 sources

                it.printStackTrace();
                v1 = null;
lbl38:
                // 2 sources

                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    public final /* synthetic */ <C> Object runIf(Extension<?> $this$runIf, MutableSharedFlow<Throwable> throwableFlow, Function2<? super C, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        void $this$getIf_u2d0E7RQCE$iv;
        void this_$iv;
        boolean $i$f$runIf = false;
        ExtensionUtils extensionUtils = this;
        Extension<?> extension2 = $this$runIf;
        ExtensionUtils extensionUtils2 = this;
        boolean bl = false;
        Intrinsics.needClassReification();
        Function2 function2 = (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>(block, null){
            Object L$1;
            Object L$2;
            int I$0;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ Function2 $block;
            {
                this.$block = $block;
                super(2, $completion);
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend(Object $result) {
                Object object;
                block5: {
                    ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                    Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            void $this$get;
                            Object client;
                            ResultKt.throwOnFailure((Object)$result);
                            Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                            Object object3 = client = (Object)$this$get;
                            if (object3 == null) break;
                            Object object4 = object3;
                            Function2 function2 = this.$block;
                            Object it = object4;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)it);
                            this.I$0 = n;
                            this.label = 1;
                            object = function2.invoke(it, (Object)((Object)this));
                            if (object == object2) {
                                return object2;
                            }
                            break block5;
                        }
                        case 1: {
                            int n = this.I$0;
                            Object it = this.L$2;
                            Object client = this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            object = $result;
                            break block5;
                        }
                    }
                    object = null;
                }
                return object;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /*
             * WARNING - void declaration
             */
            public final Object invokeSuspend$$forInline(Object $result) {
                Object object;
                void $this$get;
                ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                InlineMarker.mark((int)10);
                Intrinsics.reifiedOperationMarker((int)2, (String)"C");
                Object client = $this$get;
                if (client != null) {
                    Object object2 = client;
                    Function2 function2 = this.$block;
                    Object it = object2;
                    boolean bl = false;
                    object = function2.invoke(it, (Object)((Object)this));
                } else {
                    object = null;
                }
                return object;
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        };
        InlineMarker.mark((int)0);
        Object object = this_$iv.get-0E7RQCE((Extension<?>)$this$getIf_u2d0E7RQCE$iv, (Function2)function2, (Continuation)$completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        Object object2 = ((Result)object).unbox-impl();
        InlineMarker.mark((int)0);
        Object object3 = extensionUtils2.getOrEmit(object2, throwableFlow, $completion);
        InlineMarker.mark((int)1);
        return object3;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object inject(@NotNull Extension<?> $this$inject, @NotNull String id, @NotNull MutableSharedFlow<Throwable> throwableFlow, @NotNull Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object> block, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof inject.1)) ** GOTO lbl-1000
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
                Object L$4;
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ ExtensionUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.inject(null, null, null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var6_9 = $this$inject;
                $this$inject_u24lambda_u244 = var6_9;
                $i$a$-runCatching-ExtensionUtils$inject$2 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$inject);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = throwableFlow;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$inject_u24lambda_u244);
                $continuation.I$0 = $i$a$-runCatching-ExtensionUtils$inject$2;
                $continuation.label = 1;
                v0 = $this$inject_u24lambda_u244.getInstance().injectOrRun(id, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>((Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)block, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ Function2<ExtensionClient, Continuation<? super Unit>, Object> $block;
                    {
                        this.$block = $block;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object $result) {
                        ExtensionClient extensionClient = (ExtensionClient)this.L$0;
                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                void $this$injectOrRun;
                                ResultKt.throwOnFailure((Object)$result);
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$injectOrRun);
                                this.label = 1;
                                Object object2 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getDefault()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$block, (ExtensionClient)$this$injectOrRun, null){
                                    int label;
                                    final /* synthetic */ Function2<ExtensionClient, Continuation<? super Unit>, Object> $block;
                                    final /* synthetic */ ExtensionClient $$this$injectOrRun;
                                    {
                                        this.$block = $block;
                                        this.$$this$injectOrRun = $$this$injectOrRun;
                                        super(2, $completion);
                                    }

                                    /*
                                     * Enabled force condition propagation
                                     * Lifted jumps to return sites
                                     */
                                    public final Object invokeSuspend(Object $result) {
                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                this.label = 1;
                                                Object object2 = this.$block.invoke((Object)this.$$this$injectOrRun, (Object)((Object)this));
                                                if (object2 != object) return Unit.INSTANCE;
                                                return object;
                                            }
                                            case 1: {
                                                ResultKt.throwOnFailure((Object)$result);
                                                Object object2 = $result;
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }

                                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                    }

                                    public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                                    }
                                }), (Continuation)((Continuation)this));
                                if (object2 != object) return Unit.INSTANCE;
                                return object;
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                Object object2 = $result;
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

                    public final Object invoke(ExtensionClient p1, Continuation<? super Unit> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }, (Continuation<Unit>)$continuation);
                ** if (v0 != var11_8) goto lbl28
lbl27:
                // 1 sources

                return var11_8;
lbl28:
                // 1 sources

                ** GOTO lbl40
            }
            case 1: {
                $i$a$-runCatching-ExtensionUtils$inject$2 = $continuation.I$0;
                $this$inject_u24lambda_u244 = (Extension)$continuation.L$4;
                block = (Function2)$continuation.L$3;
                throwableFlow = (MutableSharedFlow)$continuation.L$2;
                id = (String)$continuation.L$1;
                $this$inject = (Extension)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl40:
                    // 2 sources

                    $this$inject_u24lambda_u244 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable $i$a$-runCatching-ExtensionUtils$inject$2) {
                    $this$inject_u24lambda_u244 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-ExtensionUtils$inject$2));
                }
                var6_9 = $this$inject_u24lambda_u244;
                v1 = Result.exceptionOrNull-impl((Object)var6_9);
                if (v1 != null) {
                    it = v1;
                    $i$a$-getOrElse-ExtensionUtils$inject$3 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$inject);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)throwableFlow);
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)block);
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)it);
                    $continuation.I$0 = $i$a$-getOrElse-ExtensionUtils$inject$3;
                    $continuation.label = 2;
                    v2 = throwableFlow.emit((Object)it, (Continuation)$continuation);
                    if (v2 == var11_8) {
                        return var11_8;
                    }
                }
                ** GOTO lbl70
            }
            case 2: {
                $i$a$-getOrElse-ExtensionUtils$inject$3 = $continuation.I$0;
                it = (Throwable)$continuation.L$4;
                block = (Function2)$continuation.L$3;
                throwableFlow = (MutableSharedFlow)$continuation.L$2;
                id = (String)$continuation.L$1;
                $this$inject = (Extension)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl70:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <T extends Extension<?>> Object getExtension(@NotNull Flow<? extends List<? extends T>> $this$getExtension, @Nullable String id, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof getExtension.1)) ** GOTO lbl-1000
        var11_4 = $completion;
        if ((var11_4.label & -2147483648) != 0) {
            var11_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                /* synthetic */ Object result;
                final /* synthetic */ ExtensionUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getExtension(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var12_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$getExtension);
                $continuation.L$1 = id;
                $continuation.label = 1;
                v0 = FlowKt.first((Flow)$this$getExtension, (Function2)((Function2)new Function2<List<? extends T>, Continuation<? super Boolean>, Object>(null){
                    int label;
                    /* synthetic */ Object L$0;

                    /*
                     * WARNING - void declaration
                     */
                    public final Object invokeSuspend(Object $result) {
                        List list2 = (List)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                void it;
                                ResultKt.throwOnFailure((Object)$result);
                                return Boxing.boxBoolean((!((Collection)it).isEmpty() ? 1 : 0) != 0);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value2;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(List<? extends T> p1, Continuation<? super Boolean> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), $continuation);
                if (v0 == var12_6) {
                    return var12_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                id = (String)$continuation.L$1;
                $this$getExtension = (Flow)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                list = (List)v0;
                var5_8 = list;
                for (T var7_10 : var5_8) {
                    it = (Extension)var7_10;
                    $i$a$-find-ExtensionUtils$getExtension$2 = false;
                    if (!Intrinsics.areEqual((Object)it.getId(), (Object)id)) continue;
                    v1 = var7_10;
                    ** GOTO lbl33
                }
                v1 = null;
lbl33:
                // 2 sources

                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final <T extends Extension<?>> Flow<T> getExtensionFlow(@NotNull Flow<? extends List<? extends T>> $this$getExtensionFlow, @Nullable String id2) {
        Intrinsics.checkNotNullParameter($this$getExtensionFlow, (String)"<this>");
        Flow<? extends List<? extends T>> $this$map$iv = $this$getExtensionFlow;
        boolean $i$f$map = false;
        Flow<? extends List<? extends T>> $this$unsafeTransform$iv$iv = $this$map$iv;
        boolean $i$f$unsafeTransform = false;
        boolean $i$f$unsafeFlow = false;
        return new Flow<T>($this$unsafeTransform$iv$iv, id2){
            final /* synthetic */ Flow $this_unsafeTransform$inlined;
            final /* synthetic */ String $id$inlined;
            {
                this.$this_unsafeTransform$inlined = flow2;
                this.$id$inlined = string2;
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Continuation continuation = $completion;
                FlowCollector $this$unsafeTransform_u24lambda_u240 = collector;
                boolean bl = false;
                Object object = this.$this_unsafeTransform$inlined.collect(new FlowCollector($this$unsafeTransform_u24lambda_u240, this.$id$inlined){
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ String $id$inlined;
                    {
                        this.$this_unsafeFlow = $receiver;
                        this.$id$inlined = string2;
                    }

                    /*
                     * Unable to fully structure code
                     */
                    public final Object emit(Object value, Continuation $completion) {
                        if (!($completion instanceof getExtensionFlow$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var3_3 = $completion;
                        if ((var3_3.label & -2147483648) != 0) {
                            var3_3.label -= -2147483648;
                        } else lbl-1000:
                        // 2 sources

                        {
                            $continuation = new ContinuationImpl(this, $completion){
                                /* synthetic */ Object result;
                                int label;
                                Object L$0;
                                final /* synthetic */ getExtensionFlow$$inlined$map$1$2 this$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int I$0;
                                {
                                    this.this$0 = this$0;
                                    super($completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    this.result = $result;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (Continuation)this);
                                }
                            };
                        }
                        $result = $continuation.result;
                        var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                var6_6 = $continuation;
                                var7_8 = value;
                                $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list = (List)value;
                                $i$a$-map-ExtensionUtils$getExtensionFlow$1 = false;
                                var14_18 = list;
                                for (T var16_20 : var14_18) {
                                    it = (Extension)var16_20;
                                    $i$a$-find-ExtensionUtils$getExtensionFlow$1$1 = false;
                                    if (!Intrinsics.areEqual((Object)it.getId(), (Object)this.$id$inlined)) continue;
                                    v0 = var16_20;
                                    ** GOTO lbl29
                                }
                                v0 = null;
lbl29:
                                // 2 sources

                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$completion);
                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)value);
                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$map_u24lambda_u245);
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1;
                                $continuation.label = 1;
                                v1 = var10_14.emit(v0, (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl47
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1 = $continuation.I$0;
                                $this$map_u24lambda_u245 = (FlowCollector)$continuation.L$3;
                                value = $continuation.L$2;
                                $completion = $continuation.L$1;
                                value = $continuation.L$0;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl47:
                                // 2 sources

                                return Unit.INSTANCE;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, $completion);
                if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return object;
                }
                return Unit.INSTANCE;
            }
        };
    }
}

