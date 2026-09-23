/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  androidx.activity.ComponentActivity
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
 *  androidx.core.content.FileProvider
 *  androidx.fragment.app.FragmentActivity
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugProbesKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuationImpl
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.flow.MutableSharedFlow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import dev.brahmkshatriya.echo.extensions.InstallationUtils;
import dev.brahmkshatriya.echo.extensions.repo.ExtensionParser;
import dev.brahmkshatriya.echo.extensions.repo.FileRepository;
import dev.brahmkshatriya.echo.utils.ContextUtils;
import dev.brahmkshatriya.echo.utils.PermsUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nJ6\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u00020\t*\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\t*\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0016J&\u0010\u001c\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010\"\u00a8\u0006#"}, d2={"Ldev/brahmkshatriya/echo/extensions/InstallationUtils;", "", "<init>", "()V", "installApp", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "file", "Ljava/io/File;", "(Landroidx/fragment/app/FragmentActivity;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "installFile", "context", "Landroid/content/Context;", "fileIgnoreFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "id", "", "tempFile", "(Landroid/content/Context;Lkotlinx/coroutines/flow/MutableSharedFlow;Ljava/lang/String;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openFileSelector", "fileType", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTempFile", "uri", "Landroid/net/Uri;", "uninstallApp", "path", "uninstallFile", "(Lkotlinx/coroutines/flow/MutableSharedFlow;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForResult", "Landroidx/activity/result/ActivityResult;", "intent", "Landroid/content/Intent;", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@SourceDebugExtension(value={"SMAP\nInstallationUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InstallationUtils.kt\ndev/brahmkshatriya/echo/extensions/InstallationUtils\n+ 2 Uri.kt\nandroidx/core/net/UriKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,114:1\n29#2:115\n426#3,11:116\n*S KotlinDebug\n*F\n+ 1 InstallationUtils.kt\ndev/brahmkshatriya/echo/extensions/InstallationUtils\n*L\n84#1:115\n108#1:116,11\n*E\n"})
public final class InstallationUtils {
    @NotNull
    public static final InstallationUtils INSTANCE = new InstallationUtils();

    private InstallationUtils() {
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object installApp(@NotNull FragmentActivity activity, @NotNull File file, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof installApp.1)) ** GOTO lbl-1000
        var10_4 = $completion;
        if ((var10_4.label & -2147483648) != 0) {
            var10_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                final /* synthetic */ InstallationUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.installApp(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var11_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                contentUri = FileProvider.getUriForFile((Context)((Context)activity), (String)(activity.getPackageName() + ".provider"), (File)file);
                $this$installApp_u24lambda_u240\1 = var6_9 = new Intent("android.intent.action.VIEW");
                $i$a$-apply-InstallationUtils$installApp$installIntent$1\1\28\0 = false;
                $this$installApp_u24lambda_u240\1.addFlags(1);
                $this$installApp_u24lambda_u240\1.addFlags(0x4000000);
                $this$installApp_u24lambda_u240\1.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                $this$installApp_u24lambda_u240\1.putExtra("android.intent.extra.RETURN_RESULT", true);
                $this$installApp_u24lambda_u240\1.setData(contentUri);
                installIntent = var6_9;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)activity);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)file);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)contentUri);
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)installIntent);
                $continuation.label = 1;
                v0 = this.waitForResult(activity, installIntent, (Continuation<? super ActivityResult>)$continuation);
                if (v0 == var11_6) {
                    return var11_6;
                }
                ** GOTO lbl43
            }
            case 1: {
                installIntent = (Intent)$continuation.L$3;
                contentUri = (Uri)$continuation.L$2;
                file = (File)$continuation.L$1;
                activity = (FragmentActivity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl43:
                // 2 sources

                if ((it = (ActivityResult)v0).getResultCode() == -1) {
                    return Unit.INSTANCE;
                }
                v1 = it.getData();
                result = v1 != null && (v1 = v1.getExtras()) != null ? Boxing.boxInt((int)v1.getInt("android.intent.extra.INSTALL_RESULT")) : null;
                throw new Exception("Please uninstall the existing extension first. Error Code: " + result);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object installFile(@NotNull Context context, @NotNull MutableSharedFlow<File> fileIgnoreFlow, @NotNull String id2, @NotNull File tempFile, @NotNull Continuation<? super Unit> $completion) {
        File dir = FileRepository.Companion.getExtensionsFileDir(context);
        File newFile = new File(dir, id2 + ".apk");
        dir.setWritable(true);
        newFile.setWritable(true);
        if (newFile.exists() && !newFile.delete()) {
            throw new IllegalStateException("Failed to delete existing file: " + newFile);
        }
        tempFile.renameTo(newFile);
        newFile.setWritable(false);
        dir.setReadOnly();
        Object object = fileIgnoreFlow.emit(null, $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    /*
     * Unable to fully structure code
     */
    @Nullable
    public final Object openFileSelector(@NotNull FragmentActivity $this$openFileSelector, @NotNull String fileType, @NotNull Continuation<? super File> $completion) {
        if (!($completion instanceof openFileSelector.1)) ** GOTO lbl-1000
        var9_4 = $completion;
        if ((var9_4.label & -2147483648) != 0) {
            var9_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                /* synthetic */ Object result;
                final /* synthetic */ InstallationUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.openFileSelector(null, null, (Continuation<? super File>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var10_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                $this$openFileSelector_u24lambda_u241\1 = var5_7 = new Intent("android.intent.action.GET_CONTENT");
                $i$a$-apply-InstallationUtils$openFileSelector$intent$1\1\60\0 = false;
                $this$openFileSelector_u24lambda_u241\1.setType(fileType);
                $this$openFileSelector_u24lambda_u241\1.addCategory("android.intent.category.OPENABLE");
                intent = var5_7;
                $continuation.L$0 = $this$openFileSelector;
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)fileType);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)intent);
                $continuation.label = 1;
                v0 = this.waitForResult($this$openFileSelector, intent, (Continuation<? super ActivityResult>)$continuation);
                if (v0 == var10_6) {
                    return var10_6;
                }
                ** GOTO lbl34
            }
            case 1: {
                intent = (Intent)$continuation.L$2;
                fileType = (String)$continuation.L$1;
                $this$openFileSelector = (FragmentActivity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v0 = $result;
lbl34:
                // 2 sources

                if ((v1 = (result = (ActivityResult)v0).getData()) == null || (v1 = v1.getData()) == null) {
                    throw new IllegalStateException("No file selected");
                }
                uri = v1;
                return this.getTempFile((Context)$this$openFileSelector, (Uri)uri);
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static /* synthetic */ Object openFileSelector$default(InstallationUtils installationUtils, FragmentActivity fragmentActivity, String string2, Continuation continuation, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "application/octet-stream";
        }
        return installationUtils.openFileSelector(fragmentActivity, string2, (Continuation<? super File>)continuation);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NotNull
    public final File getTempFile(@NotNull Context $this$getTempFile, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter((Object)$this$getTempFile, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)uri, (String)"uri");
        InputStream inputStream = $this$getTempFile.getContentResolver().openInputStream(uri);
        Intrinsics.checkNotNull((Object)inputStream);
        InputStream stream = inputStream;
        File tempFile = ContextUtils.INSTANCE.getTempFile($this$getTempFile, "dat");
        Closeable closeable = new FileOutputStream(tempFile);
        Throwable throwable = null;
        try {
            FileOutputStream fileOutputStream = (FileOutputStream)closeable;
            boolean bl = false;
            long l = ByteStreamsKt.copyTo$default((InputStream)stream, (OutputStream)fileOutputStream, (int)0, (int)2, null);
        }
        catch (Throwable throwable2) {
            throwable = throwable2;
            throw throwable2;
        }
        finally {
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        }
        return tempFile;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Nullable
    public final Object uninstallApp(@NotNull FragmentActivity activity, @NotNull String path, @NotNull Continuation<? super Unit> $completion) {
        if (!($completion instanceof uninstallApp.1)) ** GOTO lbl-1000
        var12_4 = $completion;
        if ((var12_4.label & -2147483648) != 0) {
            var12_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                /* synthetic */ Object result;
                final /* synthetic */ InstallationUtils this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.uninstallApp(null, null, (Continuation<? super Unit>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var13_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                v0 /* !! */  = activity.getPackageManager().getPackageArchiveInfo(path, ExtensionParser.Companion.getPACKAGE_FLAGS());
                if (v0 /* !! */  == null || (v0 /* !! */  = v0 /* !! */ .packageName) == null) {
                    throw new IllegalStateException("Invalid APK path or package name not found");
                }
                packageName /* !! */  = v0 /* !! */ ;
                activity.getPackageManager().getPackageInfo((String)packageName /* !! */ , 0);
                $this$uninstallApp_u24lambda_u243\1 = var6_9 = new Intent("android.intent.action.DELETE");
                $i$a$-apply-InstallationUtils$uninstallApp$intent$1\1\83\0 = false;
                $this$toUri\2 = "package:" + (String)packageName /* !! */ ;
                $i$f$toUri\2\84 = false;
                $this$uninstallApp_u24lambda_u243\1.setData(Uri.parse((String)$this$toUri\2));
                $this$uninstallApp_u24lambda_u243\1.putExtra("android.intent.extra.RETURN_RESULT", true);
                intent = var6_9;
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)activity);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)path);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)packageName /* !! */ );
                $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)intent);
                $continuation.label = 1;
                v1 = this.waitForResult(activity, intent, (Continuation<? super ActivityResult>)$continuation);
                if (v1 == var13_6) {
                    return var13_6;
                }
                ** GOTO lbl44
            }
            case 1: {
                intent = (Intent)$continuation.L$3;
                packageName = (String)$continuation.L$2;
                path = (String)$continuation.L$1;
                activity = (FragmentActivity)$continuation.L$0;
                ResultKt.throwOnFailure((Object)$result);
                v1 = $result;
lbl44:
                // 2 sources

                if ((result = (ActivityResult)v1).getResultCode() != -1) {
                    v2 = result.getData();
                    errorCode = v2 != null && (v2 = v2.getExtras()) != null ? Boxing.boxInt((int)v2.getInt("android.intent.extra.INSTALL_RESULT")) : null;
                    throw new Exception("Failed to uninstall extension: " + errorCode);
                }
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object uninstallFile(@NotNull MutableSharedFlow<File> fileIgnoreFlow, @NotNull String path, @NotNull Continuation<? super Unit> $completion) {
        Object object = BuildersKt.withContext((CoroutineContext)((CoroutineContext)Dispatchers.getIO()), (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(path, fileIgnoreFlow, null){
            Object L$0;
            int label;
            final /* synthetic */ String $path;
            final /* synthetic */ MutableSharedFlow<File> $fileIgnoreFlow;
            {
                this.$path = $path;
                this.$fileIgnoreFlow = $fileIgnoreFlow;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var3_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        file = new File(this.$path);
                        this.L$0 = file;
                        this.label = 1;
                        v0 = this.$fileIgnoreFlow.emit((Object)file, (Continuation)this);
                        if (v0 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        file = (File)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl16:
                        // 2 sources

                        v1 = file.getParentFile();
                        Intrinsics.checkNotNull((Object)v1);
                        v1.setWritable(true);
                        file.setWritable(true);
                        if (file.exists() && !file.delete()) {
                            throw new IllegalStateException("Failed to delete file: " + file);
                        }
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)file);
                        this.label = 2;
                        v2 = this.$fileIgnoreFlow.emit(null, (Continuation)this);
                        if (v2 == var3_2) {
                            return var3_2;
                        }
                        ** GOTO lbl34
                    }
                    case 2: {
                        file = (File)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl34:
                        // 2 sources

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
        }), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private final Object waitForResult(FragmentActivity $this$waitForResult, Intent intent, Continuation<? super ActivityResult> $completion) {
        boolean bl = false;
        Continuation<? super ActivityResult> continuation = $completion;
        boolean bl2 = false;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = (CancellableContinuation)cancellableContinuationImpl;
        boolean bl3 = false;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        ActivityResultLauncher activityResultLauncher = PermsUtils.INSTANCE.registerActivityResultLauncher((ComponentActivity)$this$waitForResult, (ActivityResultContract)startActivityForResult, (Function1)new Function1<ActivityResult, Unit>((CancellableContinuation<? super ActivityResult>)cancellableContinuation){
            final /* synthetic */ CancellableContinuation<ActivityResult> $cont;
            {
                this.$cont = $cont;
            }

            public final void invoke(ActivityResult it) {
                Intrinsics.checkNotNullParameter((Object)it, (String)"it");
                ((Continuation)this.$cont).resumeWith(Result.constructor-impl((Object)it));
            }
        });
        cancellableContinuation.invokeOnCancellation((Function1)new Function1<Throwable, Unit>(activityResultLauncher){
            final /* synthetic */ ActivityResultLauncher<Intent> $launcher;
            {
                this.$launcher = $launcher;
            }

            public final void invoke(Throwable it) {
                this.$launcher.unregister();
            }
        });
        activityResultLauncher.launch((Object)intent);
        Object object = cancellableContinuationImpl.getResult();
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return object;
    }

    public static final /* synthetic */ Object access$waitForResult(InstallationUtils $this, FragmentActivity $receiver, Intent intent, Continuation $completion) {
        return $this.waitForResult($receiver, intent, (Continuation<? super ActivityResult>)$completion);
    }
}

