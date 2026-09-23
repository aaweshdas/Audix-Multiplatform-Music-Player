/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
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
package dev.brahmkshatriya.echo.extensions;

import android.content.Context;
import android.content.SharedPreferences;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.common.settings.Settings;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils$getExtensionFlow$;
import dev.brahmkshatriya.echo.extensions.exceptions.AppException;
import dev.brahmkshatriya.echo.extensions.exceptions.ExtensionNotFoundException;
import dev.brahmkshatriya.echo.utils.ContextUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086@\u00a2\u0006\u0004\b\r\u0010\u000eJW\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0004\b\u0001\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0004\b\u0011\u0010\u000eJY\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\u0005\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0004\b\u0001\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0004\b\u0013\u0010\u000eJ.\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0019JW\u0010\u001a\u001a\u00020\u001b\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0002\u0010\u001cJ_\u0010\u0012\u001a\u0004\u0018\u0001H\u0006\"\u0006\b\u0000\u0010\u0010\u0018\u0001\"\u0004\b\u0001\u0010\u0006*\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172)\b\u0004\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086H\u00a2\u0006\u0002\u0010\u001cJU\u0010\u001d\u001a\u00020\u001b*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u00a2\u0006\u0002\b\fH\u0086@\u00a2\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"\"\u0006\b\u0000\u0010\u0015\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0007H\u0086H\u00a2\u0006\u0002\u0010#J8\u0010$\u001a\u0004\u0018\u0001H\u0015\"\f\b\u0000\u0010\u0015*\u0006\u0012\u0002\b\u00030\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150&0%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@\u00a2\u0006\u0002\u0010'J6\u0010(\u001a\u0002H\u0015\"\f\b\u0000\u0010\u0015*\u0006\u0012\u0002\b\u00030\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150&0%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@\u00a2\u0006\u0002\u0010'J6\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150%\"\f\b\u0000\u0010\u0015*\u0006\u0012\u0002\b\u00030\u0007*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150&0%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001fJ\u0012\u0010-\u001a\u00020.*\u00020\u001f2\u0006\u0010/\u001a\u000200J\u0012\u0010-\u001a\u00020.*\u0002012\u0006\u0010/\u001a\u000200J\u0016\u0010-\u001a\u00020.*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010/\u001a\u000200J\u0016\u00102\u001a\u0002032\u0006\u0010/\u001a\u0002002\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u0002032\u0006\u0010/\u001a\u000200J\u000e\u00106\u001a\u0002032\u0006\u0010-\u001a\u00020.J\u0012\u00107\u001a\u00020\u001b*\u00020.2\u0006\u00108\u001a\u00020.\u00a8\u00069"}, d2={"Ldev/brahmkshatriya/echo/extensions/ExtensionUtils;", "", "<init>", "()V", "get", "Lkotlin/Result;", "R", "Ldev/brahmkshatriya/echo/common/Extension;", "block", "Lkotlin/Function2;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "get-0E7RQCE", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAs", "C", "getAs-0E7RQCE", "getIf", "getIf-0E7RQCE", "getOrThrow", "T", "throwableFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runIf", "", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inject", "id", "", "(Ldev/brahmkshatriya/echo/common/Extension;Ljava/lang/String;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClient", "", "(Ldev/brahmkshatriya/echo/common/Extension;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtension", "Lkotlinx/coroutines/flow/Flow;", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExtensionOrThrow", "getExtensionFlow", "extensionPrefId", "extensionType", "extensionId", "prefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getSettings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "metadata", "getGlobalSettings", "toSettings", "copyTo", "dest", "app_debug"})
@SourceDebugExtension(value={"SMAP\nExtensionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 6 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,145:1\n41#1,4:147\n41#1,4:151\n1#2:146\n49#3:155\n51#3:159\n46#4:156\n51#4:158\n105#5:157\n40#6,7:160\n47#6,6:169\n1869#7,2:167\n*S KotlinDebug\n*F\n+ 1 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n*L\n57#1:147,4\n62#1:151,4\n85#1:155\n85#1:159\n85#1:156\n85#1:158\n85#1:157\n130#1:160,7\n130#1:169,6\n131#1:167,2\n*E\n"})
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
                $this$get_0E7RQCE_u24lambda_u242\1 = var4_7;
                $i$a$-runCatching-ExtensionUtils$get$2\1\25\0 = 0;
                var7_12 = $this$get_0E7RQCE_u24lambda_u242\1;
                $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2 = var7_12;
                $i$a$-runCatching-ExtensionUtils$get$2$1\2\26\1 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get_u2d0E7RQCE);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.L$2 = $this$get_0E7RQCE_u24lambda_u242\1;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2);
                $continuation.I$0 = $i$a$-runCatching-ExtensionUtils$get$2\1\25\0;
                $continuation.I$1 = $i$a$-runCatching-ExtensionUtils$get$2$1\2\26\1;
                $continuation.label = 1;
                v0 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super R>, Object>(block, $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2, null){
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
                $i$a$-runCatching-ExtensionUtils$get$2$1\2\26\1 = $continuation.I$1;
                $i$a$-runCatching-ExtensionUtils$get$2\1\25\0 = $continuation.I$0;
                $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2 = (Extension)$continuation.L$3;
                $this$get_0E7RQCE_u24lambda_u242\1 = (Extension)$continuation.L$2;
                block = (Function2)$continuation.L$1;
                $this$get_u2d0E7RQCE = (Extension)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl48:
                    // 2 sources

                    $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2 = Result.constructor-impl((Object)v0);
                    {
                        catch (Throwable $i$a$-runCatching-ExtensionUtils$get$2$1\2\26\1) {
                            $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-ExtensionUtils$get$2$1\2\26\1));
                        }
                    }
                    var7_12 = $this$get_0E7RQCE_u24lambda_u242_u24lambda_u240\2;
                    v1 = Result.exceptionOrNull-impl((Object)var7_12);
                    if (v1 != null) {
                        it\3 = v1;
                        $i$a$-getOrElse-ExtensionUtils$get$2$2\3\28\1 = false;
                        throw AppException.Companion.toAppException(it\3, $this$get_0E7RQCE_u24lambda_u242\1);
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
                            string2 = "Unknown Class";
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
                    throw new ClientException.NotSupported(string2 != null ? string2 : "Unknown Class");
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
                            Object object5 = object4;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)object5);
                            this.I$0 = n;
                            this.label = 1;
                            object = function2.invoke(object5, (Object)((Object)this));
                            if (object == object2) {
                                return object2;
                            }
                            break block5;
                        }
                        case 1: {
                            int n = this.I$0;
                            Object object6 = this.L$2;
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
                    Object object3 = object2;
                    boolean bl = false;
                    InlineMarker.mark((int)3);
                    object = function2.invoke(object3, null);
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
    public final <T> Object getOrThrow(@NotNull Object $this$getOrThrow, @NotNull MutableSharedFlow<Throwable> throwableFlow, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof getOrThrow.1)) ** GOTO lbl-1000
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
                    return this.this$0.getOrThrow(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var4_7 = $this$getOrThrow;
                v0 = Result.exceptionOrNull-impl((Object)var4_7);
                if (v0 != null) ** GOTO lbl17
                v1 = var4_7;
                ** GOTO lbl38
lbl17:
                // 1 sources

                it\1 = v0;
                $i$a$-getOrElse-ExtensionUtils$getOrThrow$2\1\48\0 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$getOrThrow);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)throwableFlow);
                $continuation.L$2 = it\1;
                $continuation.I$0 = $i$a$-getOrElse-ExtensionUtils$getOrThrow$2\1\48\0;
                $continuation.label = 1;
                v2 = throwableFlow.emit((Object)it\1, $continuation);
                if (v2 == var9_6) {
                    return var9_6;
                }
                ** GOTO lbl35
            }
            case 1: {
                $i$a$-getOrElse-ExtensionUtils$getOrThrow$2\1\48\0 = $continuation.I$0;
                it\1 = (Throwable)$continuation.L$2;
                throwableFlow = (MutableSharedFlow)$continuation.L$1;
                $this$getOrThrow = $continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v2 = $result;
lbl35:
                // 2 sources

                it\1.printStackTrace();
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
        void $this$getIf_u2d0E7RQCE\1;
        void this_\1;
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
                            Object object5 = object4;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)object5);
                            this.I$0 = n;
                            this.label = 1;
                            object = function2.invoke(object5, (Object)((Object)this));
                            if (object == object2) {
                                return object2;
                            }
                            break block5;
                        }
                        case 1: {
                            int n = this.I$0;
                            Object object6 = this.L$2;
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
                    Object object3 = object2;
                    boolean bl = false;
                    object = function2.invoke(object3, (Object)((Object)this));
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
        Object object = this_\1.get-0E7RQCE((Extension<?>)$this$getIf_u2d0E7RQCE\1, (Function2)function2, (Continuation)$completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        Object object2 = ((Result)object).unbox-impl();
        InlineMarker.mark((int)0);
        Object object3 = extensionUtils2.getOrThrow(object2, throwableFlow, $completion);
        InlineMarker.mark((int)1);
        return object3;
    }

    /*
     * WARNING - void declaration
     */
    public final /* synthetic */ <C, R> Object getIf(Extension<?> $this$getIf, MutableSharedFlow<Throwable> throwableFlow, Function2<? super C, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        void $this$getIf_u2d0E7RQCE\1;
        void this_\1;
        boolean $i$f$getIf = false;
        ExtensionUtils extensionUtils = this;
        Extension<?> extension2 = $this$getIf;
        ExtensionUtils extensionUtils2 = this;
        boolean bl = false;
        Intrinsics.needClassReification();
        Function2 function2 = new Function2<ExtensionClient, Continuation<? super R>, Object>(block, null){
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
                            Object object5 = object4;
                            int n = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                            this.L$2 = SpillingKt.nullOutSpilledVariable((Object)object5);
                            this.I$0 = n;
                            this.label = 1;
                            object = function2.invoke(object5, (Object)((Object)this));
                            if (object == object2) {
                                return object2;
                            }
                            break block5;
                        }
                        case 1: {
                            int n = this.I$0;
                            Object object6 = this.L$2;
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
                    Object object3 = object2;
                    boolean bl = false;
                    object = function2.invoke(object3, (Object)((Object)this));
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
        Object object = this_\1.get-0E7RQCE((Extension<?>)$this$getIf_u2d0E7RQCE\1, (Function2<? super ExtensionClient, ? super Continuation<? super R>, ? extends Object>)function2, (Continuation<? super Result<? extends R>>)$completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        Object object2 = ((Result)object).unbox-impl();
        InlineMarker.mark((int)0);
        Object object3 = extensionUtils2.getOrThrow(object2, throwableFlow, $completion);
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
                $this$inject_u24lambda_u244\1 = var6_9;
                $i$a$-runCatching-ExtensionUtils$inject$2\1\68\0 = 0;
                $continuation.L$0 = $this$inject;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$2 = throwableFlow;
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)$this$inject_u24lambda_u244\1);
                $continuation.I$0 = $i$a$-runCatching-ExtensionUtils$inject$2\1\68\0;
                $continuation.label = 1;
                v0 = $this$inject_u24lambda_u244\1.getInstance().injectOrRun(id, (Function2)new Function2<ExtensionClient, Continuation<? super Unit>, Object>((Function2<? super ExtensionClient, ? super Continuation<? super Unit>, ? extends Object>)block, null){
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
                                Object object2 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this.$block, (ExtensionClient)$this$injectOrRun, null){
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
                $i$a$-runCatching-ExtensionUtils$inject$2\1\68\0 = $continuation.I$0;
                $this$inject_u24lambda_u244\1 = (Extension)$continuation.L$4;
                block = (Function2)$continuation.L$3;
                throwableFlow = (MutableSharedFlow)$continuation.L$2;
                id = (String)$continuation.L$1;
                $this$inject = (Extension)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl40:
                    // 2 sources

                    $this$inject_u24lambda_u244\1 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable $i$a$-runCatching-ExtensionUtils$inject$2\1\68\0) {
                    $this$inject_u24lambda_u244\1 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-ExtensionUtils$inject$2\1\68\0));
                }
                var6_9 = $this$inject_u24lambda_u244\1;
                v1 = Result.exceptionOrNull-impl((Object)var6_9);
                if (v1 != null) {
                    it\2 = v1;
                    $i$a$-getOrElse-ExtensionUtils$inject$3\2\70\0 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$inject);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)id);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)throwableFlow);
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)block);
                    $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)it\2);
                    $continuation.I$0 = $i$a$-getOrElse-ExtensionUtils$inject$3\2\70\0;
                    $continuation.label = 2;
                    v2 = throwableFlow.emit((Object)AppException.Companion.toAppException(it\2, $this$inject), (Continuation)$continuation);
                    if (v2 == var11_8) {
                        return var11_8;
                    }
                }
                ** GOTO lbl70
            }
            case 2: {
                $i$a$-getOrElse-ExtensionUtils$inject$3\2\70\0 = $continuation.I$0;
                it\2 = (Throwable)$continuation.L$4;
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

    public final /* synthetic */ <T> Object isClient(Extension<?> $this$isClient, Continuation<? super Boolean> $completion) {
        boolean $i$f$isClient = false;
        Injectable<?> injectable = $this$isClient.getInstance();
        InlineMarker.mark((int)0);
        Object object = injectable.value-IoAF18A($completion);
        InlineMarker.mark((int)1);
        InlineMarker.mark((int)8);
        InlineMarker.mark((int)9);
        Object object2 = ((Result)object).unbox-impl();
        Object object3 = Result.isFailure-impl((Object)object2) ? null : object2;
        Intrinsics.reifiedOperationMarker((int)3, (String)"T");
        return object3 instanceof Object;
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
                    it\2 = (Extension)var7_10;
                    $i$a$-find-ExtensionUtils$getExtension$2\2\78\0 = false;
                    if (!Intrinsics.areEqual((Object)it\2.getId(), (Object)id)) continue;
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

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <T extends Extension<?>> Object getExtensionOrThrow(@NotNull Flow<? extends List<? extends T>> $this$getExtensionOrThrow, @Nullable String id, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof getExtensionOrThrow.1)) ** GOTO lbl-1000
        var5_4 = $completion;
        if ((var5_4.label & -2147483648) != 0) {
            var5_4.label -= -2147483648;
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
                    return this.this$0.getExtensionOrThrow(null, null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var6_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$getExtensionOrThrow);
                $continuation.L$1 = id;
                $continuation.label = 1;
                v0 = this.getExtension((Flow<? extends List<? extends T>>)$this$getExtensionOrThrow, id, (Continuation<? super T>)$continuation);
                if (v0 == var6_6) {
                    return var6_6;
                }
                ** GOTO lbl24
            }
            case 1: {
                id = (String)$continuation.L$1;
                $this$getExtensionOrThrow = (Flow)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl24:
                // 2 sources

                v1 = (Extension)v0;
                if (v1 == null) {
                    throw new ExtensionNotFoundException(id);
                }
                return v1;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final <T extends Extension<?>> Flow<T> getExtensionFlow(@NotNull Flow<? extends List<? extends T>> $this$getExtensionFlow, @Nullable String id2) {
        Intrinsics.checkNotNullParameter($this$getExtensionFlow, (String)"<this>");
        Flow<? extends List<? extends T>> flow2 = $this$getExtensionFlow;
        boolean bl = false;
        Flow<? extends List<? extends T>> flow3 = flow2;
        boolean bl2 = false;
        boolean bl3 = false;
        return new Flow<T>(flow3, id2){
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
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = 0;
                                var10_14 = $this$map_u24lambda_u245;
                                var11_15 = (Continuation)$continuation;
                                list\1 = (List)value;
                                $i$a$-map-ExtensionUtils$getExtensionFlow$1\1\50\0 = false;
                                var14_18 = list\1;
                                for (T var16_20 : var14_18) {
                                    it\2 = (Extension)var16_20;
                                    $i$a$-find-ExtensionUtils$getExtensionFlow$1$1\2\51\1 = false;
                                    if (!Intrinsics.areEqual((Object)it\2.getId(), (Object)this.$id$inlined)) continue;
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
                                $continuation.I$0 = $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0;
                                $continuation.label = 1;
                                v1 = var10_14.emit(v0, (Continuation)$continuation);
                                if (v1 == var5_5) {
                                    return var5_5;
                                }
                                ** GOTO lbl47
                            }
                            case 1: {
                                $i$a$-unsafeTransform-FlowKt__TransformKt$map$1\1\49\0 = $continuation.I$0;
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

    @NotNull
    public final String extensionPrefId(@NotNull String extensionType, @NotNull String extensionId) {
        Intrinsics.checkNotNullParameter((Object)extensionType, (String)"extensionType");
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        return extensionType + "-" + extensionId;
    }

    @NotNull
    public final SharedPreferences prefs(@NotNull String $this$prefs, @NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)$this$prefs, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        SharedPreferences sharedPreferences = context.getSharedPreferences($this$prefs, 0);
        Intrinsics.checkNotNull((Object)sharedPreferences);
        return sharedPreferences;
    }

    @NotNull
    public final SharedPreferences prefs(@NotNull Metadata $this$prefs, @NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)$this$prefs, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return this.prefs(this.extensionPrefId($this$prefs.getType().name(), $this$prefs.getId()), context);
    }

    @NotNull
    public final SharedPreferences prefs(@NotNull Extension<?> $this$prefs, @NotNull Context context) {
        Intrinsics.checkNotNullParameter($this$prefs, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return this.prefs($this$prefs.getMetadata(), context);
    }

    @NotNull
    public final Settings getSettings(@NotNull Context context, @NotNull Metadata metadata2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)metadata2, (String)"metadata");
        return this.toSettings(this.prefs(metadata2, context));
    }

    @NotNull
    public final Settings getGlobalSettings(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return this.toSettings(ContextUtils.INSTANCE.getSettings(context));
    }

    @NotNull
    public final Settings toSettings(@NotNull SharedPreferences prefs) {
        Intrinsics.checkNotNullParameter((Object)prefs, (String)"prefs");
        return new Settings(prefs){
            final /* synthetic */ SharedPreferences $prefs;
            {
                this.$prefs = $prefs;
            }

            public String getString(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return this.$prefs.getString(key, null);
            }

            public void putString(String key, String value2) {
                SharedPreferences.Editor editor;
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                SharedPreferences sharedPreferences = this.$prefs;
                boolean bl = false;
                boolean bl2 = false;
                SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
                boolean bl3 = false;
                editor2.putString(key, value2);
                editor.apply();
            }

            public Integer getInt(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return this.$prefs.contains(key) ? Integer.valueOf(this.$prefs.getInt(key, 0)) : null;
            }

            public void putInt(String key, Integer value2) {
                SharedPreferences.Editor editor;
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                SharedPreferences sharedPreferences = this.$prefs;
                boolean bl = false;
                boolean bl2 = false;
                SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
                boolean bl3 = false;
                SharedPreferences.Editor editor3 = value2 != null ? editor2.putInt(key, value2.intValue()) : editor2.remove(key);
                editor.apply();
            }

            public Boolean getBoolean(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return this.$prefs.contains(key) ? Boolean.valueOf(this.$prefs.getBoolean(key, false)) : null;
            }

            public void putBoolean(String key, Boolean value2) {
                SharedPreferences.Editor editor;
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                SharedPreferences sharedPreferences = this.$prefs;
                boolean bl = false;
                boolean bl2 = false;
                SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
                boolean bl3 = false;
                SharedPreferences.Editor editor3 = value2 != null ? editor2.putBoolean(key, value2.booleanValue()) : editor2.remove(key);
                editor.apply();
            }

            public Set<String> getStringSet(String key) {
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                return this.$prefs.getStringSet(key, null);
            }

            public void putStringSet(String key, Set<String> value2) {
                SharedPreferences.Editor editor;
                Intrinsics.checkNotNullParameter((Object)key, (String)"key");
                SharedPreferences sharedPreferences = this.$prefs;
                boolean bl = false;
                boolean bl2 = false;
                SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
                boolean bl3 = false;
                editor2.putStringSet(key, value2);
                editor.apply();
            }
        };
    }

    public final void copyTo(@NotNull SharedPreferences $this$copyTo, @NotNull SharedPreferences dest) {
        SharedPreferences.Editor editor;
        Intrinsics.checkNotNullParameter((Object)$this$copyTo, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)dest, (String)"dest");
        SharedPreferences sharedPreferences = dest;
        boolean bl = false;
        boolean bl2 = false;
        SharedPreferences.Editor editor2 = editor = sharedPreferences.edit();
        boolean bl3 = false;
        Iterable iterable = $this$copyTo.getAll().entrySet();
        boolean bl4 = false;
        for (Object t : iterable) {
            Object object;
            Object v;
            Map.Entry entry = (Map.Entry)t;
            boolean bl5 = false;
            if (entry.getValue() == null) continue;
            String string2 = (String)entry.getKey();
            Object v2 = v;
            if (v2 instanceof String) {
                object = editor2.putString(string2, (String)v);
                continue;
            }
            if (v2 instanceof Set) {
                Object v3 = v;
                Intrinsics.checkNotNull(v3, (String)"null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
                object = editor2.putStringSet(string2, (Set)v3);
                continue;
            }
            object = v2 instanceof Integer ? editor2.putInt(string2, ((Number)v).intValue()) : (v2 instanceof Long ? editor2.putLong(string2, ((Number)v).longValue()) : (v2 instanceof Float ? editor2.putFloat(string2, ((Number)v).floatValue()) : (v2 instanceof Boolean ? editor2.putBoolean(string2, ((Boolean)v).booleanValue()) : Unit.INSTANCE)));
        }
        editor.apply();
    }
}

