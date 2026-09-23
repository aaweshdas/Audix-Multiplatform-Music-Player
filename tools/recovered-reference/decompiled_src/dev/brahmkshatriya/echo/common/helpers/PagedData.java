/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.sync.Mutex
 *  kotlinx.coroutines.sync.MutexKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.helpers;

import dev.brahmkshatriya.echo.common.helpers.Page;
import dev.brahmkshatriya.echo.common.helpers.PagedData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0005\u001b\u001c\u001d\u001e\u001fB\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&JS\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0000\"\b\b\u0001\u0010\u0015*\u00020\u000224\u0010\u0016\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0018\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\b0\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0017H&\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0001\u0004 !\"#\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "T", "", "<init>", "()V", "clear", "", "loadAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAllInternal", "loadListInternal", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "continuation", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "loadPage", "invalidate", "map", "R", "block", "Lkotlin/Function2;", "Lkotlin/Result;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "Single", "Continuous", "Concat", "Suspend", "Companion", "Ldev/brahmkshatriya/echo/common/helpers/PagedData$Concat;", "Ldev/brahmkshatriya/echo/common/helpers/PagedData$Continuous;", "Ldev/brahmkshatriya/echo/common/helpers/PagedData$Single;", "Ldev/brahmkshatriya/echo/common/helpers/PagedData$Suspend;", "common"})
@SourceDebugExtension(value={"SMAP\nPagedData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,261:1\n116#2,11:262\n116#2,11:273\n*S KotlinDebug\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData\n*L\n45#1:262,11\n53#1:273,11\n*E\n"})
public abstract sealed class PagedData<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Mutex mutex = MutexKt.Mutex$default((boolean)false, (int)1, null);

    private PagedData() {
    }

    public abstract void clear();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object loadAll(@NotNull Continuation<? super List<? extends T>> $completion) {
        if (!($completion instanceof loadAll.1)) ** GOTO lbl-1000
        var8_2 = $completion;
        if ((var8_2.label & -2147483648) != 0) {
            var8_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ PagedData<T> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadAll((Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$withLock_u24default$iv = this.mutex;
                owner$iv = null;
                $i$f$withLock = 0;
                $continuation.L$0 = $this$withLock_u24default$iv;
                $continuation.I$0 = $i$f$withLock;
                $continuation.label = 1;
                v0 = $this$withLock_u24default$iv.lock(owner$iv, (Continuation)$continuation);
                if (v0 == var9_4) {
                    return var9_4;
                }
                ** GOTO lbl29
            }
            case 1: {
                $i$f$withLock = $continuation.I$0;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl29:
                // 3 sources

                $i$a$-withLock$default-PagedData$loadAll$2 = 0;
                $continuation.L$0 = $this$withLock_u24default$iv;
                $continuation.I$0 = $i$f$withLock;
                $continuation.I$1 = $i$a$-withLock$default-PagedData$loadAll$2;
                $continuation.label = 2;
                v1 = this.loadAllInternal((Continuation<? super List<? extends T>>)$continuation);
                ** if (v1 != var9_4) goto lbl38
lbl37:
                // 1 sources

                return var9_4;
lbl38:
                // 1 sources

                ** GOTO lbl48
            }
            case 2: {
                $i$a$-withLock$default-PagedData$loadAll$2 = $continuation.I$1;
                $i$f$withLock = $continuation.I$0;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl48:
                    // 2 sources

                    var6_12 = (List)v1;
                }
                catch (Throwable var5_11) {
                    throw var5_11;
                }
                finally {
                    $this$withLock_u24default$iv.unlock(owner$iv);
                }
                return var6_12;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public abstract Object loadAllInternal(@NotNull Continuation<? super List<? extends T>> var1);

    @Nullable
    public abstract Object loadListInternal(@Nullable String var1, @NotNull Continuation<? super Page<T>> var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Nullable
    public final Object loadPage(@Nullable String continuation, @NotNull Continuation<? super Page<T>> $completion) {
        if (!($completion instanceof loadPage.1)) ** GOTO lbl-1000
        var10_3 = $completion;
        if ((var10_3.label & -2147483648) != 0) {
            var10_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                int I$0;
                int I$1;
                /* synthetic */ Object result;
                final /* synthetic */ PagedData<T> this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.loadPage(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var11_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$withLock_u24default$iv = this.mutex;
                owner$iv = null;
                $i$f$withLock = 0;
                $continuation.L$0 = continuation;
                $continuation.L$1 = $this$withLock_u24default$iv;
                $continuation.I$0 = $i$f$withLock;
                $continuation.label = 1;
                v0 = $this$withLock_u24default$iv.lock(owner$iv, (Continuation)$continuation);
                if (v0 == var11_5) {
                    return var11_5;
                }
                ** GOTO lbl31
            }
            case 1: {
                $i$f$withLock = $continuation.I$0;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex)$continuation.L$1;
                continuation = (String)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl31:
                // 3 sources

                $i$a$-withLock$default-PagedData$loadPage$2 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                $continuation.L$1 = $this$withLock_u24default$iv;
                $continuation.I$0 = $i$f$withLock;
                $continuation.I$1 = $i$a$-withLock$default-PagedData$loadPage$2;
                $continuation.label = 2;
                v1 = this.loadListInternal(continuation, (Continuation<? super Page<T>>)$continuation);
                ** if (v1 != var11_5) goto lbl41
lbl40:
                // 1 sources

                return var11_5;
lbl41:
                // 1 sources

                ** GOTO lbl52
            }
            case 2: {
                $i$a$-withLock$default-PagedData$loadPage$2 = $continuation.I$1;
                $i$f$withLock = $continuation.I$0;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex)$continuation.L$1;
                continuation = (String)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl52:
                    // 2 sources

                    var7_12 = (Page)v1;
                }
                catch (Throwable var8_13) {
                    throw var8_13;
                }
                finally {
                    $this$withLock_u24default$iv.unlock(owner$iv);
                }
                return var7_12;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public abstract void invalidate(@Nullable String var1);

    @NotNull
    public abstract <R> PagedData<R> map(@NotNull Function2<? super Result<? extends List<? extends T>>, ? super Continuation<? super List<? extends R>>, ? extends Object> var1);

    public /* synthetic */ PagedData(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0001\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData$Companion;", "", "<init>", "()V", "empty", "Ldev/brahmkshatriya/echo/common/helpers/PagedData$Single;", "T", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T> Single<T> empty() {
            return new Single((Function1)new Function1<Continuation<? super List<? extends T>>, Object>(null){
                int label;

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            return CollectionsKt.emptyList();
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Continuation<? super List<? extends T>> p1) {
                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\u0012\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0005\"\b\u0012\u0004\u0012\u00028\u00010\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0096@\u00a2\u0006\u0002\u0010\rJS\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0003\"\b\b\u0002\u0010\u000f*\u00020\u000224\u0010\u0010\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f0\u0012\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\f0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0011H\u0016\u00a2\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096@\u00a2\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u001e\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006!"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData$Concat;", "T", "", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "sources", "", "<init>", "([Ldev/brahmkshatriya/echo/common/helpers/PagedData;)V", "[Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "clear", "", "loadAllInternal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "R", "block", "Lkotlin/Function2;", "Lkotlin/Result;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "splitContinuation", "Lkotlin/Pair;", "", "", "continuation", "combine", "index", "token", "loadListInternal", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "common"})
    @SourceDebugExtension(value={"SMAP\nPagedData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Concat\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,261:1\n1#2:262\n13472#3,2:263\n10135#3:265\n10557#3,5:266\n11228#3:271\n11563#3,3:272\n37#4:275\n36#4,3:276\n*S KotlinDebug\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Concat\n*L\n195#1:263,2\n196#1:265\n196#1:266,5\n199#1:271\n199#1:272,3\n199#1:275\n199#1:276,3\n*E\n"})
    public static final class Concat<T>
    extends PagedData<T> {
        @NotNull
        private final PagedData<T>[] sources;

        public Concat(PagedData<T> ... sources2) {
            Intrinsics.checkNotNullParameter(sources2, (String)"sources");
            super(null);
            this.sources = sources2;
            if (!(!(this.sources.length == 0))) {
                boolean bl = false;
                String string2 = "Concat must have at least one source";
                throw new IllegalArgumentException(string2.toString());
            }
        }

        @Override
        public void clear() {
            PagedData<T>[] $this$forEach$iv = this.sources;
            boolean $i$f$forEach = false;
            int n = $this$forEach$iv.length;
            for (int i = 0; i < n; ++i) {
                PagedData<T> element$iv;
                PagedData<T> it = element$iv = $this$forEach$iv[i];
                boolean bl = false;
                it.clear();
            }
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadAllInternal(@NotNull Continuation<? super List<? extends T>> $completion) {
            if (!($completion instanceof loadAllInternal.1)) ** GOTO lbl-1000
            var13_2 = $completion;
            if ((var13_2.label & -2147483648) != 0) {
                var13_2.label -= -2147483648;
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
                    int I$1;
                    int I$2;
                    int I$3;
                    int I$4;
                    /* synthetic */ Object result;
                    final /* synthetic */ Concat<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadAllInternal((Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var14_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $this$flatMap$iv = this.sources;
                    $i$f$flatMap = 0;
                    var4_7 = $this$flatMap$iv;
                    destination$iv$iv = new ArrayList<E>();
                    $i$f$flatMapTo = 0;
                    var7_10 = 0;
                    var8_11 = $this$flatMapTo$iv$iv.length;
lbl19:
                    // 2 sources

                    while (var7_10 < var8_11) {
                        it = element$iv$iv = $this$flatMapTo$iv$iv[var7_10];
                        $i$a$-flatMap-PagedData$Concat$loadAllInternal$2 = 0;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable($this$flatMap$iv);
                        $continuation.L$1 = $this$flatMapTo$iv$iv;
                        $continuation.L$2 = destination$iv$iv;
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)element$iv$iv);
                        $continuation.L$4 = SpillingKt.nullOutSpilledVariable((Object)it);
                        $continuation.I$0 = $i$f$flatMap;
                        $continuation.I$1 = $i$f$flatMapTo;
                        $continuation.I$2 = var7_10;
                        $continuation.I$3 = var8_11;
                        $continuation.I$4 = $i$a$-flatMap-PagedData$Concat$loadAllInternal$2;
                        $continuation.label = 1;
                        v0 = it.loadAll($continuation);
                        if (v0 == var14_4) {
                            return var14_4;
                        }
                        ** GOTO lbl51
                    }
                    break;
                }
                case 1: {
                    $i$a$-flatMap-PagedData$Concat$loadAllInternal$2 = $continuation.I$4;
                    var8_11 = $continuation.I$3;
                    var7_10 = $continuation.I$2;
                    $i$f$flatMapTo = $continuation.I$1;
                    $i$f$flatMap = $continuation.I$0;
                    it = (PagedData)$continuation.L$4;
                    element$iv$iv = (PagedData)$continuation.L$3;
                    destination$iv$iv = (Collection)$continuation.L$2;
                    $this$flatMapTo$iv$iv = (PagedData[])$continuation.L$1;
                    $this$flatMap$iv = (PagedData[])$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl51:
                    // 2 sources

                    list$iv$iv = (Iterable)v0;
                    CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
                    ++var7_10;
                    ** GOTO lbl19
                }
            }
            return (List)destination$iv$iv;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        public <R> PagedData<R> map(@NotNull Function2<? super Result<? extends List<? extends T>>, ? super Continuation<? super List<? extends R>>, ? extends Object> block) {
            void $this$mapTo$iv$iv;
            Intrinsics.checkNotNullParameter(block, (String)"block");
            PagedData<T>[] $this$map$iv = this.sources;
            boolean $i$f$map = false;
            PagedData<T>[] pagedDataArray = $this$map$iv;
            Collection destination$iv$iv = new ArrayList($this$map$iv.length);
            boolean $i$f$mapTo = false;
            int n = ((void)$this$mapTo$iv$iv).length;
            for (int i = 0; i < n; ++i) {
                void it;
                void item$iv$iv;
                void var11_10 = item$iv$iv = $this$mapTo$iv$iv[i];
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(it.map(block));
            }
            Collection $this$toTypedArray$iv = (List)destination$iv$iv;
            boolean $i$f$toTypedArray = false;
            Collection thisCollection$iv = $this$toTypedArray$iv;
            PagedData[] pagedDataArray2 = thisCollection$iv.toArray(new PagedData[0]);
            PagedData[] pagedDataArray3 = Arrays.copyOf(pagedDataArray2, pagedDataArray2.length);
            return new Concat<T>(pagedDataArray3);
        }

        private final Pair<Integer, String> splitContinuation(String continuation) {
            if (continuation == null) {
                return TuplesKt.to((Object)0, null);
            }
            Integer n = StringsKt.toIntOrNull((String)StringsKt.substringBefore$default((String)continuation, (String)"_", null, (int)2, null));
            int index = n != null ? n : -1;
            String token = StringsKt.substringAfter$default((String)continuation, (String)"_", null, (int)2, null);
            return TuplesKt.to((Object)index, (Object)token);
        }

        private final String combine(int index, String token) {
            String string2 = token;
            if (string2 == null) {
                string2 = "";
            }
            return index + "_" + string2;
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadListInternal(@Nullable String continuation, @NotNull Continuation<? super Page<T>> $completion) {
            if (!($completion instanceof loadListInternal.1)) ** GOTO lbl-1000
            var9_3 = $completion;
            if ((var9_3.label & -2147483648) != 0) {
                var9_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int I$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Concat<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadListInternal(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var10_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    var3_6 = this.splitContinuation(continuation);
                    index = ((Number)var3_6.component1()).intValue();
                    token = (String)var3_6.component2();
                    v0 = (PagedData)ArraysKt.getOrNull((Object[])this.sources, (int)index);
                    if (v0 == null) {
                        return new Page<T>(CollectionsKt.emptyList(), null);
                    }
                    source = v0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)token);
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)source);
                    $continuation.I$0 = index;
                    $continuation.label = 1;
                    v1 = source.loadPage(token, $continuation);
                    if (v1 == var10_5) {
                        return var10_5;
                    }
                    ** GOTO lbl35
                }
                case 1: {
                    index = $continuation.I$0;
                    source = (PagedData)$continuation.L$2;
                    token = (String)$continuation.L$1;
                    continuation = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl35:
                    // 2 sources

                    return (page = (Page)v1).getContinuation() != null ? new Page<T>(page.getData(), this.combine(index, page.getContinuation())) : new Page<T>(page.getData(), this.combine(index + 1, null));
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void invalidate(@Nullable String continuation) {
            block0: {
                PagedData source;
                Pair<Integer, String> pair = this.splitContinuation(continuation);
                int index = ((Number)pair.component1()).intValue();
                String token = (String)pair.component2();
                PagedData pagedData2 = source = (PagedData)ArraysKt.getOrNull((Object[])this.sources, (int)index);
                if (pagedData2 == null) break block0;
                pagedData2.invalidate(token);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BB\u00129\u0010\u0004\u001a5\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0019H\u0096@\u00a2\u0006\u0002\u0010\u001aJS\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0003\"\b\b\u0002\u0010\u001c*\u00020\u000224\u0010\u001d\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00190\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u00190\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016\u00a2\u0006\u0002\u0010\u001fRF\u0010\u0004\u001a5\b\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData$Continuous;", "T", "", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "load", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "continuation", "Lkotlin/coroutines/Continuation;", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getLoad", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "itemMap", "", "loadListInternal", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "", "clear", "loadAllInternal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "R", "block", "Lkotlin/Result;", "(Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "common"})
    @SourceDebugExtension(value={"SMAP\nPagedData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Continuous\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,261:1\n382#2,7:262\n*S KotlinDebug\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Continuous\n*L\n138#1:262,7\n*E\n"})
    public static final class Continuous<T>
    extends PagedData<T> {
        @NotNull
        private final Function2<String, Continuation<? super Page<T>>, Object> load;
        @NotNull
        private final Map<String, Page<T>> itemMap;

        public Continuous(@NotNull Function2<? super String, ? super Continuation<? super Page<T>>, ? extends Object> load2) {
            Intrinsics.checkNotNullParameter(load2, (String)"load");
            super(null);
            this.load = load2;
            this.itemMap = new LinkedHashMap();
        }

        @NotNull
        public final Function2<String, Continuation<? super Page<T>>, Object> getLoad() {
            return this.load;
        }

        /*
         * Unable to fully structure code
         * Could not resolve type clashes
         */
        @Override
        @Nullable
        public Object loadListInternal(@Nullable String continuation, @NotNull Continuation<? super Page<T>> $completion) {
            block7: {
                if (!($completion instanceof loadListInternal.1)) ** GOTO lbl-1000
                var14_3 = $completion;
                if ((var14_3.label & -2147483648) != 0) {
                    var14_3.label -= -2147483648;
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
                        final /* synthetic */ Continuous<T> this$0;
                        int label;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.loadListInternal(null, (Continuation)this);
                        }
                    };
                }
                $result = $continuation.result;
                var15_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        var4_6 = this.itemMap;
                        key$iv = continuation;
                        $i$f$getOrPut = 0;
                        value$iv = $this$getOrPut$iv.get(key$iv);
                        if (value$iv != null) break;
                        $i$a$-getOrPut-PagedData$Continuous$loadListInternal$page$1 = 0;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                        $continuation.L$1 = $this$getOrPut$iv;
                        $continuation.L$2 = key$iv;
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable(value$iv);
                        $continuation.I$0 = $i$f$getOrPut;
                        $continuation.I$1 = $i$a$-getOrPut-PagedData$Continuous$loadListInternal$page$1;
                        $continuation.label = 1;
                        v0 = this.load.invoke((Object)continuation, (Object)$continuation);
                        if (v0 == var15_5) {
                            return var15_5;
                        }
                        ** GOTO lbl38
                    }
                    case 1: {
                        $i$a$-getOrPut-PagedData$Continuous$loadListInternal$page$1 = $continuation.I$1;
                        $i$f$getOrPut = $continuation.I$0;
                        value$iv = $continuation.L$3;
                        key$iv = (String)$continuation.L$2;
                        $this$getOrPut$iv = (Map)$continuation.L$1;
                        continuation = (String)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl38:
                        // 2 sources

                        var9_14 = (Page)v0;
                        data = var9_14.component1();
                        cont = var9_14.component2();
                        answer$iv = new Page<T>(data, cont);
                        $this$getOrPut$iv.put(key$iv, answer$iv);
                        v1 /* !! */  = answer$iv;
                        break block7;
                    }
                }
                v1 /* !! */  = value$iv;
            }
            page = (Page)v1 /* !! */ ;
            return page;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void invalidate(@Nullable String continuation) {
            this.itemMap.remove(continuation);
        }

        @Override
        public void clear() {
            this.itemMap.clear();
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadAllInternal(@NotNull Continuation<? super List<? extends T>> $completion) {
            if (!($completion instanceof loadAllInternal.1)) ** GOTO lbl-1000
            var9_2 = $completion;
            if ((var9_2.label & -2147483648) != 0) {
                var9_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    /* synthetic */ Object result;
                    final /* synthetic */ Continuous<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadAllInternal((Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var10_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    list = new ArrayList<E>();
                    $continuation.L$0 = list;
                    $continuation.label = 1;
                    v0 = this.loadListInternal(null, (Continuation<? super Page<T>>)$continuation);
                    if (v0 == var10_4) {
                        return var10_4;
                    }
                    ** GOTO lbl23
                }
                case 1: {
                    list = (List)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl23:
                    // 2 sources

                    var3_6 = (Page)v0;
                    data = var3_6.component1();
                    continuation = var3_6.component2();
                    list.addAll(data);
                    cont = continuation;
lbl29:
                    // 2 sources

                    while (cont != null) {
                        $continuation.L$0 = list;
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)data);
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)cont);
                        $continuation.label = 2;
                        v1 = this.loadListInternal(cont, (Continuation<? super Page<T>>)$continuation);
                        if (v1 == var10_4) {
                            return var10_4;
                        }
                        ** GOTO lbl47
                    }
                    break;
                }
                case 2: {
                    cont = (String)$continuation.L$3;
                    continuation = (String)$continuation.L$2;
                    data = (List)$continuation.L$1;
                    list = (List)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl47:
                    // 2 sources

                    page = (Page)v1;
                    list.addAll((Collection)page.getData());
                    cont = page.getContinuation();
                    ** GOTO lbl29
                }
            }
            return list;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        @NotNull
        public <R> PagedData<R> map(@NotNull Function2<? super Result<? extends List<? extends T>>, ? super Continuation<? super List<? extends R>>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return new Continuous<T>((Function2)new Function2<String, Continuation<? super Page<R>>, Object>(this, block, null){
                Object L$1;
                int I$0;
                int label;
                /* synthetic */ Object L$0;
                final /* synthetic */ Continuous<T> this$0;
                final /* synthetic */ Function2<Result<? extends List<? extends T>>, Continuation<? super List<? extends R>>, Object> $block;
                {
                    this.this$0 = $receiver;
                    this.$block = $block;
                    super(2, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var2_2 = (String)this.L$0;
                    var10_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            var4_4 = this.this$0;
                            $this$invokeSuspend_u24lambda_u240 = var4_4;
                            $i$a$-runCatching-PagedData$Continuous$map$1$result$1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                            this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240);
                            this.I$0 = $i$a$-runCatching-PagedData$Continuous$map$1$result$1;
                            this.label = 1;
                            v0 = $this$invokeSuspend_u24lambda_u240.getLoad().invoke((Object)continuation, (Object)this);
                            ** if (v0 != var10_3) goto lbl19
lbl18:
                            // 1 sources

                            return var10_3;
lbl19:
                            // 1 sources

                            ** GOTO lbl27
                        }
                        case 1: {
                            $i$a$-runCatching-PagedData$Continuous$map$1$result$1 = this.I$0;
                            $this$invokeSuspend_u24lambda_u240 = (Continuous<T>)this.L$1;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl27:
                                // 2 sources

                                $this$invokeSuspend_u24lambda_u240 = Result.constructor-impl((Object)((Page)v0));
                            }
                            catch (Throwable $i$a$-runCatching-PagedData$Continuous$map$1$result$1) {
                                $this$invokeSuspend_u24lambda_u240 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-PagedData$Continuous$map$1$result$1));
                            }
                            result = $this$invokeSuspend_u24lambda_u240;
                            v1 = this.$block;
                            var4_4 = result;
                            if (Result.isSuccess-impl((Object)var4_4)) {
                                $this$invokeSuspend_u24lambda_u240 = (Page)var4_4;
                                var7_9 = v1;
                                $i$a$-map-PagedData$Continuous$map$1$1 = false;
                                v1 = var7_9;
                                v2 = Result.constructor-impl(it.getData());
                            } else {
                                v2 = Result.constructor-impl((Object)var4_4);
                            }
                            this.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                            this.L$1 = result;
                            this.label = 2;
                            v3 = v1.invoke((Object)Result.box-impl((Object)v2), (Object)this);
                            if (v3 == var10_3) {
                                return var10_3;
                            }
                            ** GOTO lbl55
                        }
                        case 2: {
                            result = this.L$1;
                            ResultKt.throwOnFailure((Object)$result);
                            v3 = $result;
lbl55:
                            // 2 sources

                            v4 = (Page)(Result.isFailure-impl((Object)result) != false ? null : result);
                            var8_10 = v4 != null ? v4.getContinuation() : null;
                            var9_11 = (List)v3;
                            return new Page<T>(var9_11, var8_10);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                    var var3_3 = new /* invalid duplicate definition of identical inner class */;
                    var3_3.L$0 = value2;
                    return (Continuation)var3_3;
                }

                public final Object invoke(String p1, Continuation<? super Page<R>> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0082@\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096@\u00a2\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016JS\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0003\"\b\b\u0002\u0010\u001f*\u00020\u000224\u0010 \u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\"\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020!H\u0016\u00a2\u0006\u0002\u0010#R/\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData$Single;", "T", "", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "load", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getLoad", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "loaded", "", "items", "", "getItems", "()Ljava/util/List;", "loadList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", "loadAllInternal", "loadListInternal", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "continuation", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "map", "R", "block", "Lkotlin/Function2;", "Lkotlin/Result;", "(Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "common"})
    public static final class Single<T>
    extends PagedData<T> {
        @NotNull
        private final Function1<Continuation<? super List<? extends T>>, Object> load;
        private boolean loaded;
        @NotNull
        private final List<T> items;

        public Single(@NotNull Function1<? super Continuation<? super List<? extends T>>, ? extends Object> load2) {
            Intrinsics.checkNotNullParameter(load2, (String)"load");
            super(null);
            this.load = load2;
            this.items = new ArrayList();
        }

        @NotNull
        public final Function1<Continuation<? super List<? extends T>>, Object> getLoad() {
            return this.load;
        }

        @NotNull
        public final List<T> getItems() {
            return this.items;
        }

        /*
         * Unable to fully structure code
         */
        private final Object loadList(Continuation<? super List<? extends T>> $completion) {
            if (!($completion instanceof loadList.1)) ** GOTO lbl-1000
            var4_2 = $completion;
            if ((var4_2.label & -2147483648) != 0) {
                var4_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Single<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return Single.access$loadList(this.this$0, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    if (this.loaded) {
                        return this.items;
                    }
                    $continuation.L$0 = var2_5 = this.items;
                    $continuation.label = 1;
                    v0 = this.load.invoke((Object)$continuation);
                    if (v0 == var5_4) {
                        return var5_4;
                    }
                    ** GOTO lbl24
                }
                case 1: {
                    var2_5 = (List<T>)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl24:
                    // 2 sources

                    var2_5.addAll((Collection)v0);
                    this.loaded = true;
                    return this.items;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void clear() {
            this.items.clear();
            this.loaded = false;
        }

        @Override
        @Nullable
        public Object loadAllInternal(@NotNull Continuation<? super List<? extends T>> $completion) {
            return this.loadList($completion);
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadListInternal(@Nullable String continuation, @NotNull Continuation<? super Page<T>> $completion) {
            if (!($completion instanceof loadListInternal.1)) ** GOTO lbl-1000
            var4_3 = $completion;
            if ((var4_3.label & -2147483648) != 0) {
                var4_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Single<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadListInternal(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                    $continuation.label = 1;
                    v0 = this.loadList((Continuation<? super List<? extends T>>)$continuation);
                    if (v0 == var7_5) {
                        return var7_5;
                    }
                    ** GOTO lbl22
                }
                case 1: {
                    continuation = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl22:
                    // 2 sources

                    var5_6 = null;
                    var6_7 = (List)v0;
                    return new Page<T>(var6_7, var5_6);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void invalidate(@Nullable String continuation) {
            this.clear();
        }

        @Override
        @NotNull
        public <R> PagedData<R> map(@NotNull Function2<? super Result<? extends List<? extends T>>, ? super Continuation<? super List<? extends R>>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return new Single<T>((Function1)new Function1<Continuation<? super List<? extends R>>, Object>(block, this, null){
                Object L$0;
                Object L$1;
                int I$0;
                int label;
                final /* synthetic */ Function2<Result<? extends List<? extends T>>, Continuation<? super List<? extends R>>, Object> $block;
                final /* synthetic */ Single<T> this$0;
                {
                    this.$block = $block;
                    this.this$0 = $receiver;
                    super(1, $completion);
                }

                /*
                 * Unable to fully structure code
                 */
                public final Object invokeSuspend(Object $result) {
                    var6_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            var2_3 = this.this$0;
                            var5_4 = this.$block;
                            $this$invokeSuspend_u24lambda_u240 = var2_3;
                            $i$a$-runCatching-PagedData$Single$map$1$1 = 0;
                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240);
                            this.L$1 = var5_4;
                            this.I$0 = $i$a$-runCatching-PagedData$Single$map$1$1;
                            this.label = 1;
                            v0 = $this$invokeSuspend_u24lambda_u240.getLoad().invoke((Object)this);
                            ** if (v0 != var6_2) goto lbl19
lbl18:
                            // 1 sources

                            return var6_2;
lbl19:
                            // 1 sources

                            ** GOTO lbl28
                        }
                        case 1: {
                            $i$a$-runCatching-PagedData$Single$map$1$1 = this.I$0;
                            var5_4 = (Function2<Result<? extends List<? extends T>>, Continuation<? super List<? extends R>>, Object>)this.L$1;
                            $this$invokeSuspend_u24lambda_u240 = (Single<T>)this.L$0;
                            try {
                                ResultKt.throwOnFailure((Object)$result);
                                v0 = $result;
lbl28:
                                // 2 sources

                                var3_5 = Result.constructor-impl((Object)((List)v0));
                            }
                            catch (Throwable var4_8) {
                                var3_5 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var4_8));
                            }
                            this.L$0 = null;
                            this.L$1 = null;
                            this.label = 2;
                            v1 = var5_4.invoke((Object)Result.box-impl((Object)var3_5), (Object)this);
                            if (v1 == var6_2) {
                                return var6_2;
                            }
                            ** GOTO lbl43
                        }
                        case 2: {
                            ResultKt.throwOnFailure((Object)$result);
                            v1 = $result;
lbl43:
                            // 2 sources

                            return v1;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Continuation<? super List<? extends R>> p1) {
                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        public static final /* synthetic */ Object access$loadList(Single $this, Continuation $completion) {
            return $this.loadList($completion);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0082@\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0096@\u00a2\u0006\u0002\u0010\u000eJS\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0003\"\b\b\u0002\u0010\u0014*\u00020\u000224\u0010\u0015\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00120\u0017\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00120\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0016H\u0016\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R,\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/PagedData$Suspend;", "T", "", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "getter", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "_data", "data", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "", "loadAllInternal", "", "map", "R", "block", "Lkotlin/Function2;", "Lkotlin/Result;", "(Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "loadListInternal", "Ldev/brahmkshatriya/echo/common/helpers/Page;", "continuation", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "common"})
    @SourceDebugExtension(value={"SMAP\nPagedData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Suspend\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n116#2,11:262\n1#3:273\n*S KotlinDebug\n*F\n+ 1 PagedData.kt\ndev/brahmkshatriya/echo/common/helpers/PagedData$Suspend\n*L\n234#1:262,11\n*E\n"})
    public static final class Suspend<T>
    extends PagedData<T> {
        @NotNull
        private final Function1<Continuation<? super PagedData<T>>, Object> getter;
        @NotNull
        private final Mutex mutex;
        @Nullable
        private PagedData<T> _data;

        public Suspend(@NotNull Function1<? super Continuation<? super PagedData<T>>, ? extends Object> getter) {
            Intrinsics.checkNotNullParameter(getter, (String)"getter");
            super(null);
            this.getter = getter;
            this.mutex = MutexKt.Mutex$default((boolean)false, (int)1, null);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         * Unable to fully structure code
         */
        private final Object data(Continuation<? super PagedData<T>> $completion) {
            if (!($completion instanceof data.1)) ** GOTO lbl-1000
            var8_2 = $completion;
            if ((var8_2.label & -2147483648) != 0) {
                var8_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    int I$0;
                    int I$1;
                    /* synthetic */ Object result;
                    final /* synthetic */ Suspend<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return Suspend.access$data(this.this$0, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var9_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = this._data;
                    if (v0 != null) ** GOTO lbl61
                    $this$withLock_u24default$iv = this.mutex;
                    owner$iv = null;
                    $i$f$withLock = 0;
                    $continuation.L$0 = $this$withLock_u24default$iv;
                    $continuation.I$0 = $i$f$withLock;
                    $continuation.label = 1;
                    v1 = $this$withLock_u24default$iv.lock(owner$iv, (Continuation)$continuation);
                    if (v1 == var9_4) {
                        return var9_4;
                    }
                    ** GOTO lbl31
                }
                case 1: {
                    $i$f$withLock = $continuation.I$0;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl31:
                    // 3 sources

                    $i$a$-withLock$default-PagedData$Suspend$data$2 = 0;
                    $continuation.L$0 = $this$withLock_u24default$iv;
                    $continuation.I$0 = $i$f$withLock;
                    $continuation.I$1 = $i$a$-withLock$default-PagedData$Suspend$data$2;
                    $continuation.label = 2;
                    v2 = this.getter.invoke((Object)$continuation);
                    ** if (v2 != var9_4) goto lbl40
lbl39:
                    // 1 sources

                    return var9_4;
lbl40:
                    // 1 sources

                    ** GOTO lbl50
                }
                case 2: {
                    $i$a$-withLock$default-PagedData$Suspend$data$2 = $continuation.I$1;
                    $i$f$withLock = $continuation.I$0;
                    owner$iv = null;
                    $this$withLock_u24default$iv = (Mutex)$continuation.L$0;
                    try {
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl50:
                        // 2 sources

                        var6_11 = (PagedData)v2;
                    }
                    catch (Throwable var5_10) {
                        throw var5_10;
                    }
                    finally {
                        $this$withLock_u24default$iv.unlock(owner$iv);
                    }
                    it = var2_5 = var6_11;
                    $i$a$-also-PagedData$Suspend$data$3 = false;
                    this._data = it;
                    v0 = var2_5;
lbl61:
                    // 2 sources

                    return v0;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void clear() {
            block0: {
                PagedData<T> pagedData2 = this._data;
                if (pagedData2 == null) break block0;
                pagedData2.clear();
            }
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadAllInternal(@NotNull Continuation<? super List<? extends T>> $completion) {
            if (!($completion instanceof loadAllInternal.1)) ** GOTO lbl-1000
            var3_2 = $completion;
            if ((var3_2.label & -2147483648) != 0) {
                var3_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    /* synthetic */ Object result;
                    final /* synthetic */ Suspend<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadAllInternal((Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.label = 1;
                    v0 = this.data((Continuation<? super PagedData<T>>)$continuation);
                    if (v0 == var4_4) {
                        return var4_4;
                    }
                    ** GOTO lbl20
                }
                case 1: {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl20:
                    // 2 sources

                    $continuation.label = 2;
                    v1 = ((PagedData)v0).loadAll($continuation);
                    if (v1 == var4_4) {
                        return var4_4;
                    }
                    ** GOTO lbl28
                }
                case 2: {
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl28:
                    // 2 sources

                    return v1;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        @NotNull
        public <R> PagedData<R> map(@NotNull Function2<? super Result<? extends List<? extends T>>, ? super Continuation<? super List<? extends R>>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, (String)"block");
            return new Suspend<T>((Function1)new Function1<Continuation<? super PagedData<R>>, Object>(this, block, null){
                int label;
                final /* synthetic */ Suspend<T> this$0;
                final /* synthetic */ Function2<Result<? extends List<? extends T>>, Continuation<? super List<? extends R>>, Object> $block;
                {
                    this.this$0 = $receiver;
                    this.$block = $block;
                    super(1, $completion);
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
                            Object object2 = Suspend.access$data(this.this$0, (Continuation)this);
                            if (object2 != object) return ((PagedData)object2).map(this.$block);
                            return object;
                        }
                        case 1: {
                            ResultKt.throwOnFailure((Object)$result);
                            Object object2 = $result;
                            return ((PagedData)object2).map(this.$block);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Continuation<? super PagedData<R>> p1) {
                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        /*
         * Unable to fully structure code
         */
        @Override
        @Nullable
        public Object loadListInternal(@Nullable String continuation, @NotNull Continuation<? super Page<T>> $completion) {
            if (!($completion instanceof loadListInternal.1)) ** GOTO lbl-1000
            var4_3 = $completion;
            if ((var4_3.label & -2147483648) != 0) {
                var4_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Suspend<T> this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.loadListInternal(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var5_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $continuation.L$0 = continuation;
                    $continuation.label = 1;
                    v0 = this.data((Continuation<? super PagedData<T>>)$continuation);
                    if (v0 == var5_5) {
                        return var5_5;
                    }
                    ** GOTO lbl22
                }
                case 1: {
                    continuation = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl22:
                    // 2 sources

                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)continuation);
                    $continuation.label = 2;
                    v1 = ((PagedData)v0).loadPage(continuation, $continuation);
                    if (v1 == var5_5) {
                        return var5_5;
                    }
                    ** GOTO lbl32
                }
                case 2: {
                    continuation = (String)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v1 = $result;
lbl32:
                    // 2 sources

                    return v1;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override
        public void invalidate(@Nullable String continuation) {
            block0: {
                PagedData<T> pagedData2 = this._data;
                if (pagedData2 == null) break block0;
                pagedData2.invalidate(continuation);
            }
        }

        public static final /* synthetic */ Object access$data(Suspend $this, Continuation $completion) {
            return $this.data($completion);
        }
    }
}

