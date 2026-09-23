/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.sync.Mutex
 *  kotlinx.coroutines.sync.MutexKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.helpers;

import dev.brahmkshatriya.echo.common.helpers.Injectable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BD\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012-\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\u0002\b\n0\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086@\u00a2\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001b2'\u0010\u001e\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\u0002\b\nH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0000\"\u0004\b\u0001\u0010!R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R5\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\u0002\b\n0\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0014\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R;\u0010\u0019\u001a/\u0012\u0004\u0012\u00020\u001b\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\u0002\b\n0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "T", "", "getter", "Lkotlin/Function0;", "injections", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/util/List;)V", "data", "Lkotlin/Lazy;", "Lkotlin/Result;", "getData", "()Lkotlin/Lazy;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "value", "getValue", "()Ljava/lang/Object;", "value-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectionsMap", "", "", "injectOrRun", "id", "block", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "casted", "R", "common"})
@SourceDebugExtension(value={"SMAP\nInjectable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Injectable.kt\ndev/brahmkshatriya/echo/common/helpers/Injectable\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n116#2,8:42\n125#2,2:54\n116#2,11:56\n1869#3,2:50\n1869#3,2:52\n1#4:67\n*S KotlinDebug\n*F\n+ 1 Injectable.kt\ndev/brahmkshatriya/echo/common/helpers/Injectable\n*L\n18#1:42,8\n18#1:54,2\n31#1:56,11\n20#1:50,2\n22#1:52,2\n*E\n"})
public final class Injectable<T> {
    @NotNull
    private final Function0<T> getter;
    @NotNull
    private List<? extends Function2<? super T, ? super Continuation<? super Unit>, ? extends Object>> injections;
    @NotNull
    private final Lazy<Result<T>> data;
    @NotNull
    private final Mutex mutex;
    @NotNull
    private final Map<String, Function2<T, Continuation<? super Unit>, Object>> injectionsMap;

    public Injectable(@NotNull Function0<? extends T> getter, @NotNull List<? extends Function2<? super T, ? super Continuation<? super Unit>, ? extends Object>> injections) {
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        Intrinsics.checkNotNullParameter(injections, (String)"injections");
        this.getter = getter;
        this.injections = injections;
        this.data = LazyKt.lazy(() -> Injectable.data$lambda$1(this));
        this.mutex = MutexKt.Mutex$default((boolean)false, (int)1, null);
        this.injectionsMap = new LinkedHashMap();
    }

    @NotNull
    public final Lazy<Result<T>> getData() {
        return this.data;
    }

    @Nullable
    public final T getValue() {
        Object object = ((Result)this.data.getValue()).unbox-impl();
        return (T)(Result.isFailure-impl((Object)object) ? null : object);
    }

    /*
     * Exception decompiling
     */
    @Nullable
    public final Object value-IoAF18A(@NotNull Continuation<? super Result<? extends T>> $completion) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK], 1[TRYBLOCK]], but top level block is 14[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object injectOrRun(@NotNull String id, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> block, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof injectOrRun.1)) ** GOTO lbl-1000
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
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ Injectable<T> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.injectOrRun(null, null, (Continuation<Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var12_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                if (!this.data.isInitialized()) break;
                var4_7 = ((Result)this.data.getValue()).unbox-impl();
                ResultKt.throwOnFailure((Object)var4_7);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)id);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.label = 1;
                v0 = block.invoke(var4_7, (Object)$continuation);
                if (v0 == var12_6) {
                    return var12_6;
                }
                ** GOTO lbl27
            }
            case 1: {
                block = (Function2)$continuation.L$1;
                id = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl27:
                // 2 sources

                return Unit.INSTANCE;
            }
        }
        $this$withLock_u24default$iv = this.mutex;
        owner$iv = null;
        $i$f$withLock = 0;
        $continuation.L$0 = id;
        $continuation.L$1 = block;
        $continuation.L$2 = $this$withLock_u24default$iv;
        $continuation.I$0 = $i$f$withLock;
        $continuation.label = 2;
        v1 = $this$withLock_u24default$iv.lock(owner$iv, (Continuation)$continuation);
        if (v1 == var12_6) {
            return var12_6;
        }
        ** GOTO lbl48
        {
            case 2: {
                $i$f$withLock = $continuation.I$0;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex)$continuation.L$2;
                block = (Function2)$continuation.L$1;
                id = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl48:
                // 2 sources

                try {
                    $i$a$-withLock$default-Injectable$injectOrRun$2 = false;
                    this.injectionsMap.put(id, block);
                    var8_13 = Unit.INSTANCE;
                }
                finally {
                    $this$withLock_u24default$iv.unlock(owner$iv);
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final <R> Injectable<R> casted() {
        void var1_1;
        Injectable $this$casted_u24lambda_u247 = this;
        boolean bl = false;
        $this$casted_u24lambda_u247.injections = CollectionsKt.plus((Collection)$this$casted_u24lambda_u247.injections, (Iterable)CollectionsKt.listOf((Object)new Function2<T, Continuation<? super Unit>, Object>(null){
            int label;
            private /* synthetic */ Object L$0;

            public final Object invokeSuspend(Object $result) {
                Object object = this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
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

            public final Object invoke(T p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }
        }));
        Intrinsics.checkNotNull((Object)$this$casted_u24lambda_u247, (String)"null cannot be cast to non-null type dev.brahmkshatriya.echo.common.helpers.Injectable<R of dev.brahmkshatriya.echo.common.helpers.Injectable.casted>");
        return var1_1;
    }

    private static final Result data$lambda$1(Injectable this$0) {
        Object object;
        Injectable injectable = this$0;
        try {
            Injectable $this$data_u24lambda_u241_u24lambda_u240 = injectable;
            boolean bl = false;
            object = Result.constructor-impl((Object)$this$data_u24lambda_u241_u24lambda_u240.getter.invoke());
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        return Result.box-impl((Object)object);
    }
}

