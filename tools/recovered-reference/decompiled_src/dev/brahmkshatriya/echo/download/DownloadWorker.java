/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  androidx.annotation.OptIn
 *  androidx.core.app.NotificationCompat$Builder
 *  androidx.core.app.NotificationManagerCompat
 *  androidx.media3.common.util.NotificationUtil
 *  androidx.media3.common.util.UnstableApi
 *  androidx.work.CoroutineWorker
 *  androidx.work.ForegroundInfo
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.WorkerParameters
 *  dev.brahmkshatriya.echo.R$drawable
 *  dev.brahmkshatriya.echo.R$plurals
 *  dev.brahmkshatriya.echo.R$string
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.OptIn;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.work.CoroutineWorker;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import dev.brahmkshatriya.echo.MainActivity;
import dev.brahmkshatriya.echo.R;
import dev.brahmkshatriya.echo.download.DownloadWorker;
import dev.brahmkshatriya.echo.download.Downloader;
import dev.brahmkshatriya.echo.download.tasks.TaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/download/DownloadWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "downloader", "Ldev/brahmkshatriya/echo/download/Downloader;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Ldev/brahmkshatriya/echo/download/Downloader;)V", "manager", "Ldev/brahmkshatriya/echo/download/tasks/TaskManager;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotification", "Landroidx/work/ForegroundInfo;", "tracks", "", "removeNotification", "", "Companion", "app_debug"})
public final class DownloadWorker
extends CoroutineWorker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Context context;
    @NotNull
    private final TaskManager manager;
    private static final int NOTIF_ID = 0;
    @NotNull
    private static final String PROGRESS_CHANNEL_ID = "download_progress_channel";

    public DownloadWorker(@NotNull Context context, @NotNull WorkerParameters params, @NotNull Downloader downloader) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)params, (String)"params");
        Intrinsics.checkNotNullParameter((Object)downloader, (String)"downloader");
        super(context, params);
        this.context = context;
        this.manager = downloader.getTaskManager();
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public Object doWork(@NotNull Continuation<? super ListenableWorker.Result> $completion) {
        if (!($completion instanceof doWork.1)) ** GOTO lbl-1000
        var4_2 = $completion;
        if ((var4_2.label & -2147483648) != 0) {
            var4_2.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                /* synthetic */ Object result;
                final /* synthetic */ DownloadWorker this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.doWork((Continuation<? super ListenableWorker.Result>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var5_4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $continuation.label = 1;
                v0 = this.setForeground(this.createNotification(0), (Continuation)$continuation);
                if (v0 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl20
            }
            case 1: {
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl20:
                // 2 sources

                job = BuildersKt.launch$default((CoroutineScope)this.manager.getScope(), null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
                    int label;
                    private /* synthetic */ Object L$0;
                    final /* synthetic */ DownloadWorker this$0;
                    {
                        this.this$0 = $receiver;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - void declaration
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object $result) {
                        CoroutineScope coroutineScope = (CoroutineScope)this.L$0;
                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                void $this$launch;
                                ResultKt.throwOnFailure((Object)$result);
                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$launch);
                                this.label = 1;
                                Object object2 = FlowKt.collectLatest((Flow)((Flow)DownloadWorker.access$getManager$p(this.this$0).getTaskFlow()), (Function2)((Function2)new Function2<List<? extends TaskManager.TaskItem>, Continuation<? super Unit>, Object>(this.this$0, (CoroutineScope)$this$launch, null){
                                    int label;
                                    /* synthetic */ Object L$0;
                                    final /* synthetic */ DownloadWorker this$0;
                                    final /* synthetic */ CoroutineScope $$this$launch;
                                    {
                                        this.this$0 = $receiver;
                                        this.$$this$launch = $$this$launch;
                                        super(2, $completion);
                                    }

                                    /*
                                     * WARNING - void declaration
                                     * Enabled force condition propagation
                                     * Lifted jumps to return sites
                                     */
                                    public final Object invokeSuspend(Object $result) {
                                        List list2 = (List)this.L$0;
                                        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0: {
                                                void it;
                                                ResultKt.throwOnFailure((Object)$result);
                                                if (it.isEmpty()) {
                                                    DownloadWorker.access$removeNotification(this.this$0);
                                                    return Unit.INSTANCE;
                                                }
                                                if (!CoroutineScopeKt.isActive((CoroutineScope)this.$$this$launch)) return Unit.INSTANCE;
                                                this.L$0 = SpillingKt.nullOutSpilledVariable((Object)it);
                                                this.label = 1;
                                                Object object2 = this.this$0.setForeground(DownloadWorker.access$createNotification(this.this$0, it.size()), (Continuation)this);
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

                                    public final Object invoke(List<TaskManager.TaskItem> p1, Continuation<? super Unit> p2) {
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

                    public final Object invoke(CoroutineScope p1, Continuation<? super Unit> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (int)3, null);
                $continuation.L$0 = job;
                $continuation.label = 2;
                v1 = this.manager.awaitCompletion((Continuation<? super Unit>)$continuation);
                if (v1 == var5_4) {
                    return var5_4;
                }
                ** GOTO lbl31
            }
            case 2: {
                job = (Job)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl31:
                // 2 sources

                Job.DefaultImpls.cancel$default((Job)job, null, (int)1, null);
                v2 = ListenableWorker.Result.success();
                Intrinsics.checkNotNullExpressionValue((Object)v2, (String)"success(...)");
                return v2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @OptIn(markerClass={UnstableApi.class})
    private final ForegroundInfo createNotification(int tracks) {
        Object[] objectArray;
        NotificationUtil.createNotificationChannel((Context)this.context, (String)PROGRESS_CHANNEL_ID, (int)R.string.download_progress, (int)0, (int)3);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this.context, PROGRESS_CHANNEL_ID);
        PendingIntent intent = Companion.getMainIntent(this.context);
        Object object = this;
        try {
            DownloadWorker downloadWorker = object;
            boolean bl = false;
            Object[] objectArray2 = new Object[]{tracks};
            objectArray = Result.constructor-impl((Object)downloadWorker.context.getResources().getQuantityString(R.plurals.number_songs, tracks, objectArray2));
        }
        catch (Throwable throwable) {
            objectArray = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object = objectArray;
        String string2 = (String)(Result.isFailure-impl((Object)object) ? null : object);
        if (string2 == null) {
            objectArray = new Object[]{tracks};
            String string3 = this.context.getString(R.string.n_songs, objectArray);
            string2 = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getString(...)");
        }
        String tracksTitle = string2;
        Object[] objectArray3 = new Object[]{tracksTitle};
        return new ForegroundInfo(0, notificationBuilder.setSmallIcon(R.drawable.ic_downloading).setContentTitle((CharSequence)this.context.getString(R.string.downloading_x, objectArray3)).setContentIntent(intent).setProgress(100, 0, true).setOnlyAlertOnce(true).setOngoing(true).build(), Build.VERSION.SDK_INT < 29 ? 0 : 1);
    }

    private final void removeNotification() {
        NotificationManagerCompat.from((Context)this.context).cancel(0);
    }

    public static final /* synthetic */ TaskManager access$getManager$p(DownloadWorker $this) {
        return $this.manager;
    }

    public static final /* synthetic */ void access$removeNotification(DownloadWorker $this) {
        $this.removeNotification();
    }

    public static final /* synthetic */ ForegroundInfo access$createNotification(DownloadWorker $this, int tracks) {
        return $this.createNotification(tracks);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/download/DownloadWorker$Companion;", "", "<init>", "()V", "NOTIF_ID", "", "PROGRESS_CHANNEL_ID", "", "getMainIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final PendingIntent getMainIntent(@NotNull Context context) {
            void $this$getMainIntent_u24lambda_u240\1;
            Intent intent;
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            Intent intent2 = intent = new Intent(context, MainActivity.Companion.getMainActivity(context));
            int n = 0;
            Context context2 = context;
            boolean bl = false;
            $this$getMainIntent_u24lambda_u240\1.putExtra("fromDownload", true);
            Unit unit = Unit.INSTANCE;
            PendingIntent pendingIntent = PendingIntent.getActivity((Context)context2, (int)n, (Intent)intent, (int)0xC000000);
            Intrinsics.checkNotNull((Object)pendingIntent);
            return pendingIntent;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

