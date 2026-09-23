/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  androidx.annotation.OptIn
 *  androidx.core.app.NotificationCompat$BigPictureStyle
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationCompat$Style
 *  androidx.core.app.NotificationManagerCompat
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableKt
 *  androidx.media3.common.util.NotificationUtil
 *  androidx.media3.common.util.UnstableApi
 *  dev.brahmkshatriya.echo.R$drawable
 *  dev.brahmkshatriya.echo.R$string
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.MutableStateFlow
 *  kotlinx.coroutines.flow.StateFlowKt
 *  kotlinx.serialization.SerializationStrategy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.tasks;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.OptIn;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.UnstableApi;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.clients.DownloadClient;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.ClientException;
import dev.brahmkshatriya.echo.common.models.DownloadContext;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.common.models.Progress;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.download.DownloadWorker;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.db.DownloadDao;
import dev.brahmkshatriya.echo.download.db.models.ContextEntity;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.download.exceptions.DownloadException;
import dev.brahmkshatriya.echo.download.tasks.BaseTask;
import dev.brahmkshatriya.echo.extensions.ExtensionUtils;
import dev.brahmkshatriya.echo.ui.common.ExceptionUtils;
import dev.brahmkshatriya.echo.utils.CoroutineUtils;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.SerializationStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 :2\u00020\u0001:\u0001:B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ=\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2'\u0010 \u001a#\b\u0001\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0#\u0012\u0006\u0012\u0004\u0018\u00010\u00010!\u00a2\u0006\u0002\b$H\u0086@\u00a2\u0006\u0002\u0010%J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0086@\u00a2\u0006\u0004\b-\u0010.J\u000e\u0010/\u001a\u000200H\u0086@\u00a2\u0006\u0002\u0010.J\u000e\u00101\u001a\u000202H\u0086@\u00a2\u0006\u0002\u0010.J\u0016\u00103\u001a\u00020,2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u00104J\"\u00105\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010&\u001a\u00020'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u00a8\u0006;"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/BaseTask;", "", "context", "Landroid/content/Context;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "trackId", "", "<init>", "(Landroid/content/Context;Ldev/brahmkshatriya/echo/download/Downloader;J)V", "getDownloader", "()Ldev/brahmkshatriya/echo/download/Downloader;", "getTrackId", "()J", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getType", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "progressFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "getProgressFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "throttledProgressFlow", "Lkotlinx/coroutines/flow/Flow;", "getThrottledProgressFlow", "()Lkotlinx/coroutines/flow/Flow;", "running", "", "getRunning", "withDownloadExtension", "T", "block", "Lkotlin/Function2;", "Ldev/brahmkshatriya/echo/common/clients/DownloadClient;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dao", "Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "getDao", "()Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "doWork", "Lkotlin/Result;", "", "doWork-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownload", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "getDownloadContext", "Ldev/brahmkshatriya/echo/common/models/DownloadContext;", "work", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCompleteNotification", "title", "", "drawable", "Landroid/graphics/drawable/Drawable;", "Companion", "app_debug"})
@SourceDebugExtension(value={"SMAP\nBaseTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTask.kt\ndev/brahmkshatriya/echo/download/tasks/BaseTask\n+ 2 ExtensionUtils.kt\ndev/brahmkshatriya/echo/extensions/ExtensionUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n33#2,5:118\n1#3:123\n*S KotlinDebug\n*F\n+ 1 BaseTask.kt\ndev/brahmkshatriya/echo/download/tasks/BaseTask\n*L\n42#1:118,5\n*E\n"})
public abstract class BaseTask {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Context context;
    @NotNull
    private final Downloader downloader;
    private final long trackId;
    @NotNull
    private final MutableStateFlow<Progress> progressFlow;
    @NotNull
    private final Flow<Progress> throttledProgressFlow;
    @NotNull
    private final MutableStateFlow<Boolean> running;
    @NotNull
    private final DownloadDao dao;
    @NotNull
    private static final String DOWNLOAD_CHANNEL_ID = "download_channel";

    public BaseTask(@NotNull Context context, @NotNull Downloader downloader, long trackId) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        this.context = context;
        this.downloader = downloader;
        this.trackId = trackId;
        this.progressFlow = StateFlowKt.MutableStateFlow((Object)new Progress(0L, 0L, 0L, 7, null));
        this.throttledProgressFlow = CoroutineUtils.INSTANCE.throttleLatest((Flow)this.progressFlow, 500L);
        this.running = StateFlowKt.MutableStateFlow((Object)false);
        this.dao = this.downloader.getDao();
    }

    @NotNull
    public final Downloader getDownloader() {
        return this.downloader;
    }

    public long getTrackId() {
        return this.trackId;
    }

    @NotNull
    public abstract TaskType getType();

    @NotNull
    public final MutableStateFlow<Progress> getProgressFlow() {
        return this.progressFlow;
    }

    @NotNull
    public final Flow<Progress> getThrottledProgressFlow() {
        return this.throttledProgressFlow;
    }

    @NotNull
    public final MutableStateFlow<Boolean> getRunning() {
        return this.running;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final <T> Object withDownloadExtension(@NotNull Function2<? super DownloadClient, ? super Continuation<? super T>, ? extends Object> block, @NotNull Continuation<? super T> $completion) {
        if (!($completion instanceof withDownloadExtension.1)) ** GOTO lbl-1000
        var7_3 = $completion;
        if ((var7_3.label & -2147483648) != 0) {
            var7_3.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                int I$0;
                /* synthetic */ Object result;
                final /* synthetic */ BaseTask this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.withDownloadExtension(null, (Continuation)this);
                }
            };
        }
        $result = $continuation.result;
        var8_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                var3_6 = ExtensionUtils.INSTANCE;
                $continuation.L$0 = block;
                $continuation.L$1 = var3_6;
                $continuation.label = 1;
                v0 = this.downloader.downloadExtension((Continuation<? super MiscExtension>)$continuation);
                if (v0 == var8_5) {
                    return var8_5;
                }
                ** GOTO lbl25
            }
            case 1: {
                var3_6 = (ExtensionUtils)$continuation.L$1;
                block = (Function2)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl25:
                // 2 sources

                $this$getAs_u2d0E7RQCE\1 = (Extension)v0;
                $i$f$getAs-0E7RQCE\1\42 = 0;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)block);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)this_\1);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$getAs_u2d0E7RQCE\1);
                $continuation.I$0 = $i$f$getAs-0E7RQCE\1\42;
                $continuation.label = 2;
                v1 = this_\1.get-0E7RQCE($this$getAs_u2d0E7RQCE\1, (Function2)new Function2<ExtensionClient, Continuation<? super T>, Object>(null, block){
                    Object L$1;
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ Function2 $block$inlined;
                    Object L$2;
                    Object L$3;
                    int I$0;
                    {
                        this.$block$inlined = function2;
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
                                void $completion\1;
                                DownloadClient downloadClient;
                                void $this$get;
                                ResultKt.throwOnFailure((Object)$result);
                                Object v0 = $this$get;
                                if (!(v0 instanceof DownloadClient)) {
                                    v0 = null;
                                }
                                if ((downloadClient = (DownloadClient)v0) == null) {
                                    String string2 = Reflection.getOrCreateKotlinClass(DownloadClient.class).getSimpleName();
                                    throw new ClientException.NotSupported(string2 != null ? string2 : "Unknown Class");
                                }
                                DownloadClient client = downloadClient;
                                Continuation continuation = (Continuation)this;
                                DownloadClient downloadClient2 = client;
                                int n = 0;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$get);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)client);
                                this.L$2 = SpillingKt.nullOutSpilledVariable((Object)$completion\1);
                                this.L$3 = SpillingKt.nullOutSpilledVariable((Object)downloadClient2);
                                this.I$0 = n;
                                this.label = 1;
                                InlineMarker.mark((int)6);
                                Object object2 = this.$block$inlined.invoke((Object)downloadClient2, (Object)((Object)this));
                                InlineMarker.mark((int)7);
                                Object object3 = object2;
                                if (object2 != object) return object3;
                                return object;
                            }
                            case 1: {
                                int n = this.I$0;
                                DownloadClient downloadClient = (DownloadClient)this.L$3;
                                Continuation continuation = (Continuation)this.L$2;
                                DownloadClient client = (DownloadClient)this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                Object object3 = $result;
                                return object3;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value2;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(ExtensionClient p1, Continuation<? super T> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }, $continuation);
                if (v1 == var8_5) {
                    return var8_5;
                }
                ** GOTO lbl44
            }
            case 2: {
                $i$f$getAs-0E7RQCE\1\42 = $continuation.I$0;
                $this$getAs_u2d0E7RQCE\1 = (Extension)$continuation.L$2;
                this_\1 = (ExtensionUtils)$continuation.L$1;
                block = (Function2)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = ((Result)$result).unbox-impl();
lbl44:
                // 2 sources

                var3_6 = v1;
                ResultKt.throwOnFailure((Object)var3_6);
                return var3_6;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @NotNull
    public final DownloadDao getDao() {
        return this.dao;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object doWork-IoAF18A(@NotNull Continuation<? super Result<Unit>> $completion) {
        if (!($completion instanceof doWork.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ BaseTask this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    Object object = this.this$0.doWork-IoAF18A((Continuation<? super Result<Unit>>)((Continuation)this));
                    if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return object;
                    }
                    return Result.box-impl((Object)object);
                }
            };
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object>(this, null){
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    int I$0;
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ BaseTask this$0;
                    {
                        this.this$0 = $receiver;
                        super(2, $completion);
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object invokeSuspend(Object $result) {
                        var2_2 = (CoroutineScope)this.L$0;
                        var14_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                this.this$0.getRunning().setValue((Object)Boxing.boxBoolean((boolean)true));
                                var4_4 = $this$withContext;
                                var5_6 = this.this$0;
                                $this$invokeSuspend_u24lambda_u240\1 /* !! */  = var4_4;
                                $i$a$-runCatching-BaseTask$doWork$2$result$1\1\48\0 = 0;
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$withContext);
                                this.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$invokeSuspend_u24lambda_u240\1 /* !! */ );
                                this.I$0 = $i$a$-runCatching-BaseTask$doWork$2$result$1\1\48\0;
                                this.label = 1;
                                v0 = var5_6.work(var5_6.getTrackId(), (Continuation<? super Unit>)this);
                                ** if (v0 != var14_3) goto lbl21
lbl20:
                                // 1 sources

                                return var14_3;
lbl21:
                                // 1 sources

                                ** GOTO lbl29
                            }
                            case 1: {
                                $i$a$-runCatching-BaseTask$doWork$2$result$1\1\48\0 = this.I$0;
                                $this$invokeSuspend_u24lambda_u240\1 /* !! */  = (CoroutineScope)this.L$1;
                                try {
                                    ResultKt.throwOnFailure((Object)$result);
                                    v0 = $result;
lbl29:
                                    // 2 sources

                                    $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)Unit.INSTANCE);
                                }
                                catch (Throwable $i$a$-runCatching-BaseTask$doWork$2$result$1\1\48\0) {
                                    $this$invokeSuspend_u24lambda_u240\1 /* !! */  = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-BaseTask$doWork$2$result$1\1\48\0));
                                }
                                result = $this$invokeSuspend_u24lambda_u240\1 /* !! */ ;
                                throwable = Result.exceptionOrNull-impl((Object)result);
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$withContext);
                                this.L$1 = result;
                                this.L$2 = throwable;
                                this.label = 2;
                                v1 = this.this$0.getDao().getDownloadEntity(this.this$0.getTrackId(), (Continuation<? super DownloadEntity>)((Continuation)this));
                                if (v1 == var14_3) {
                                    return var14_3;
                                }
                                ** GOTO lbl49
                            }
                            case 2: {
                                throwable = (Throwable)this.L$2;
                                result = this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v1 = $result;
lbl49:
                                // 2 sources

                                download = (DownloadEntity)v1;
                                if (throwable != null && download != null) {
                                    exception = new DownloadException(this.this$0.getType(), download, throwable);
                                    exceptionFile = FilesKt.resolve((File)BaseTask.Companion.exceptionDir(BaseTask.access$getContext$p(this.this$0)), (String)(this.this$0.getTrackId() + ".json"));
                                    var8_15 = Serializer.INSTANCE;
                                    $this$toJson\2 = ExceptionUtils.INSTANCE.toData(exception, BaseTask.access$getContext$p(this.this$0));
                                    $i$f$toJson\2\54 = false;
                                    var11_18 = this_\2.getJson();
                                    value\3 = $this$toJson\2;
                                    $i$f$encodeToString\3\119 = false;
                                    this_\3.getSerializersModule();
                                    FilesKt.writeText$default((File)exceptionFile, (String)this_\3.encodeToString((SerializationStrategy)ExceptionUtils.Data.Companion.serializer(), (Object)value\3), null, (int)2, null);
                                    this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$withContext);
                                    this.L$1 = result;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable((Object)throwable);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable((Object)download);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable((Object)exception);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable((Object)exceptionFile);
                                    this.label = 3;
                                    v2 = this.this$0.getDao().insertDownloadEntity(DownloadEntity.copy$default(download, 0L, null, null, null, null, null, null, false, null, null, null, null, null, null, exceptionFile.getAbsolutePath(), false, 49151, null), (Continuation<? super Long>)((Continuation)this));
                                    if (v2 == var14_3) {
                                        return var14_3;
                                    }
                                }
                                ** GOTO lbl82
                            }
                            case 3: {
                                exceptionFile = (File)this.L$5;
                                exception = (DownloadException)this.L$4;
                                download = (DownloadEntity)this.L$3;
                                throwable = (Throwable)this.L$2;
                                result = this.L$1;
                                ResultKt.throwOnFailure((Object)$result);
                                v2 = $result;
lbl82:
                                // 2 sources

                                this.this$0.getRunning().setValue((Object)Boxing.boxBoolean((boolean)false));
                                return Result.box-impl((Object)result);
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        var var3_3 = new /* invalid duplicate definition of identical inner class */;
                        var3_3.L$0 = value2;
                        return (Continuation)var3_3;
                    }

                    public final Object invoke(CoroutineScope p1, Continuation<? super Result<Unit>> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (Continuation)$continuation);
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

                return ((Result)v0).unbox-impl();
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getDownload(@NotNull Continuation<? super DownloadEntity> $completion) {
        if (!($completion instanceof getDownload.1)) ** GOTO lbl-1000
        var3_2 = $completion;
        if ((var3_2.label & -2147483648) != 0) {
            var3_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                /* synthetic */ Object result;
                final /* synthetic */ BaseTask this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.getDownload((Continuation<? super DownloadEntity>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var4_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = this.dao.getDownloadEntity(this.getTrackId(), (Continuation<? super DownloadEntity>)$continuation);
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

                Intrinsics.checkNotNull((Object)v0);
                return v0;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object getDownloadContext(@NotNull Continuation<? super DownloadContext> $completion) {
        block11: {
            if (!($completion instanceof getDownloadContext.1)) ** GOTO lbl-1000
            var12_2 = $completion;
            if ((var12_2.label & -2147483648) != 0) {
                var12_2.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    int I$0;
                    int I$1;
                    long J$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ BaseTask this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.getDownloadContext((Continuation<? super DownloadContext>)((Continuation)this));
                    }
                };
            }
            $result = $continuation.result;
            var13_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $this$getDownloadContext_u24lambda_u242\1 = this;
                    $i$a$-run-BaseTask$getDownloadContext$2\1\63\0 = 0;
                    $continuation.L$0 = $this$getDownloadContext_u24lambda_u242\1;
                    $continuation.I$0 = $i$a$-run-BaseTask$getDownloadContext$2\1\63\0;
                    $continuation.label = 1;
                    v0 = $this$getDownloadContext_u24lambda_u242\1.getDownload((Continuation<? super DownloadEntity>)$continuation);
                    if (v0 == var13_4) {
                        return var13_4;
                    }
                    ** GOTO lbl26
                }
                case 1: {
                    $i$a$-run-BaseTask$getDownloadContext$2\1\63\0 = $continuation.I$0;
                    $this$getDownloadContext_u24lambda_u242\1 = (BaseTask)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl26:
                    // 2 sources

                    download\1 = (DownloadEntity)v0;
                    v1 = download\1.getContextId();
                    if (v1 == null) break;
                    it\2 = ((Number)v1).longValue();
                    $i$a$-let-BaseTask$getDownloadContext$2$contextEntity$1\2\65\1 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$getDownloadContext_u24lambda_u242\1);
                    $continuation.L$1 = download\1;
                    $continuation.I$0 = $i$a$-run-BaseTask$getDownloadContext$2\1\63\0;
                    $continuation.J$0 = it\2;
                    $continuation.I$1 = $i$a$-let-BaseTask$getDownloadContext$2$contextEntity$1\2\65\1;
                    $continuation.label = 2;
                    v2 = $this$getDownloadContext_u24lambda_u242\1.dao.getContextEntity(Boxing.boxLong((long)it\2), (Continuation<? super ContextEntity>)$continuation);
                    if (v2 == var13_4) {
                        return var13_4;
                    }
                    ** GOTO lbl49
                }
                case 2: {
                    $i$a$-let-BaseTask$getDownloadContext$2$contextEntity$1\2\65\1 = $continuation.I$1;
                    it\2 = $continuation.J$0;
                    $i$a$-run-BaseTask$getDownloadContext$2\1\63\0 = $continuation.I$0;
                    download\1 = (DownloadEntity)$continuation.L$1;
                    $this$getDownloadContext_u24lambda_u242\1 = (BaseTask)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v2 = $result;
lbl49:
                    // 2 sources

                    v3 = (ContextEntity)v2;
                    break block11;
                }
            }
            v3 = null;
        }
        contextEntity\1 = v3;
        v4 = download\1.getExtensionId();
        var5_13 = download\1.getTrack-d1pmJ48();
        ResultKt.throwOnFailure((Object)var5_13);
        v5 = (Track)var5_13;
        v6 = download\1.getSortOrder();
        v7 = contextEntity\1;
        if (v7 != null) {
            var6_14 = v7.getMediaItem-d1pmJ48();
            ResultKt.throwOnFailure((Object)var6_14);
            v8 = (EchoMediaItem)var6_14;
        } else {
            v8 = null;
        }
        return new DownloadContext(v4, v5, v6, v8);
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public abstract Object work(long var1, @NotNull Continuation<? super Unit> var3);

    @OptIn(markerClass={UnstableApi.class})
    public final void createCompleteNotification(@NotNull Context context, @NotNull String title, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        NotificationUtil.createNotificationChannel((Context)context, (String)DOWNLOAD_CHANNEL_ID, (int)R.string.download_complete, (int)0, (int)3);
        Drawable drawable3 = drawable2;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, DOWNLOAD_CHANNEL_ID).setSmallIcon(R.drawable.ic_downloading).setContentTitle((CharSequence)context.getString(R.string.download_complete)).setContentText((CharSequence)title).setStyle((NotificationCompat.Style)new NotificationCompat.BigPictureStyle().bigLargeIcon(drawable3 != null ? DrawableKt.toBitmap$default((Drawable)drawable3, (int)0, (int)0, null, (int)7, null) : null)).setContentIntent(DownloadWorker.Companion.getMainIntent(context)).setAutoCancel(true);
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"setAutoCancel(...)");
        NotificationCompat.Builder notificationBuilder = builder;
        if (ContextCompat.checkSelfPermission((Context)context, (String)"android.permission.POST_NOTIFICATIONS") != 0) {
            return;
        }
        NotificationManagerCompat.from((Context)context).notify(title.hashCode(), notificationBuilder.build());
    }

    public static final /* synthetic */ Context access$getContext$p(BaseTask $this) {
        return $this.context;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\n\u0010\u000b\u001a\u00020\f*\u00020\u0006R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Ldev/brahmkshatriya/echo/download/tasks/BaseTask$Companion;", "", "<init>", "()V", "getTitle", "", "Landroid/content/Context;", "type", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "title", "DOWNLOAD_CHANNEL_ID", "exceptionDir", "Ljava/io/File;", "app_debug"})
    @SourceDebugExtension(value={"SMAP\nBaseTask.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseTask.kt\ndev/brahmkshatriya/echo/download/tasks/BaseTask$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getTitle(@NotNull Context $this$getTitle, @NotNull TaskType type, @NotNull String title) {
            Intrinsics.checkNotNullParameter((Object)$this$getTitle, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
            Intrinsics.checkNotNullParameter((Object)title, (String)"title");
            String string2 = switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1 -> {
                    Object[] var5_4 = new Object[]{title};
                    yield $this$getTitle.getString(R.string.loading_x, var5_4);
                }
                case 2 -> {
                    Object[] var5_4 = new Object[]{title};
                    yield $this$getTitle.getString(R.string.downloading_x, var5_4);
                }
                case 3 -> {
                    Object[] var5_4 = new Object[]{title};
                    yield $this$getTitle.getString(R.string.merging_x, var5_4);
                }
                case 4 -> {
                    Object[] var5_4 = new Object[]{title};
                    yield $this$getTitle.getString(R.string.tagging_x, var5_4);
                }
                case 5 -> {
                    Object[] var5_4 = new Object[]{title};
                    yield $this$getTitle.getString(R.string.saving_x, var5_4);
                }
                default -> throw new NoWhenBranchMatchedException();
            };
            Intrinsics.checkNotNull((Object)string2);
            return string2;
        }

        @NotNull
        public final File exceptionDir(@NotNull Context $this$exceptionDir) {
            File file2;
            Intrinsics.checkNotNullParameter((Object)$this$exceptionDir, (String)"<this>");
            File file3 = file2 = new File($this$exceptionDir.getFilesDir(), "download_exceptions");
            boolean bl = false;
            file3.mkdirs();
            return file2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[TaskType.values().length];
                try {
                    nArray[TaskType.Loading.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[TaskType.Downloading.ordinal()] = 2;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[TaskType.Merging.ordinal()] = 3;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[TaskType.Tagging.ordinal()] = 4;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                try {
                    nArray[TaskType.Saving.ordinal()] = 5;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

