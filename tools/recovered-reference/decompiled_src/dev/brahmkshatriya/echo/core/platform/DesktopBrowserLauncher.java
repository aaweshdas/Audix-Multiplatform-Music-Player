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
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CompletableDeferred
 *  kotlinx.coroutines.CompletableDeferredKt
 *  kotlinx.coroutines.CoroutineScope
 *  kotlinx.coroutines.CoroutineScopeKt
 *  kotlinx.coroutines.Dispatchers
 *  kotlinx.coroutines.Job
 *  kotlinx.coroutines.Job$DefaultImpls
 *  kotlinx.coroutines.TimeoutKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.platform;

import dev.brahmkshatriya.echo.core.platform.BrowserLauncher;
import dev.brahmkshatriya.echo.core.platform.DesktopBrowserLauncher;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Ldev/brahmkshatriya/echo/core/platform/DesktopBrowserLauncher;", "Ldev/brahmkshatriya/echo/core/platform/BrowserLauncher;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "open", "", "", "url", "redirectScheme", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openExternal", "", "parseQueryString", "query", "core"})
@SourceDebugExtension(value={"SMAP\nDesktopBrowserLauncher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DesktopBrowserLauncher.kt\ndev/brahmkshatriya/echo/core/platform/DesktopBrowserLauncher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1#2:102\n1193#3,2:103\n1267#3,4:105\n*S KotlinDebug\n*F\n+ 1 DesktopBrowserLauncher.kt\ndev/brahmkshatriya/echo/core/platform/DesktopBrowserLauncher\n*L\n93#1:103,2\n93#1:105,4\n*E\n"})
public final class DesktopBrowserLauncher
implements BrowserLauncher {
    @NotNull
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope((CoroutineContext)((CoroutineContext)Dispatchers.getIO()));

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    @Override
    @Nullable
    public Object open(@NotNull String url, @NotNull String redirectScheme, @NotNull Continuation<? super Map<String, String>> $completion) {
        if (!($completion instanceof open.1)) ** GOTO lbl-1000
        var13_4 = $completion;
        if ((var13_4.label & -2147483648) != 0) {
            var13_4.label -= -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            $continuation = new ContinuationImpl(this, $completion){
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                /* synthetic */ Object result;
                final /* synthetic */ DesktopBrowserLauncher this$0;
                int label;
                {
                    this.this$0 = this$0;
                    super($completion);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object $result) {
                    this.result = $result;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.open(null, null, (Continuation<? super Map<String, String>>)((Continuation)this));
                }
            };
        }
        $result = $continuation.result;
        var14_6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
            case 0: {
                ResultKt.throwOnFailure((Object)$result);
                result = CompletableDeferredKt.CompletableDeferred$default(null, (int)1, null);
                server = new ServerSocket(4747);
                job = BuildersKt.launch$default((CoroutineScope)this.scope, null, null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(server, (CompletableDeferred<Map<String, String>>)result, this, null){
                    int label;
                    final /* synthetic */ ServerSocket $server;
                    final /* synthetic */ CompletableDeferred<Map<String, String>> $result;
                    final /* synthetic */ DesktopBrowserLauncher this$0;
                    {
                        this.$server = $server;
                        this.$result = $result;
                        this.this$0 = $receiver;
                        super(2, $completion);
                    }

                    /*
                     * WARNING - Removed try catching itself - possible behaviour change.
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object $result) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0: {
                                ResultKt.throwOnFailure((Object)$result);
                                try {
                                    Closeable closeable = this.$server;
                                    DesktopBrowserLauncher desktopBrowserLauncher = this.this$0;
                                    CompletableDeferred<Map<String, String>> completableDeferred = this.$result;
                                    Throwable throwable = null;
                                    try {
                                        boolean bl;
                                        ServerSocket s = (ServerSocket)closeable;
                                        boolean bl2 = false;
                                        Socket socket = s.accept();
                                        Closeable closeable2 = socket;
                                        Throwable throwable2 = null;
                                        try {
                                            String[] stringArray;
                                            String requestLine;
                                            String string2;
                                            Socket sock = (Socket)closeable2;
                                            boolean bl3 = false;
                                            InputStream inputStream = sock.getInputStream();
                                            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"getInputStream(...)");
                                            InputStream inputStream2 = inputStream;
                                            Charset charset = Charsets.UTF_8;
                                            Reader reader = new InputStreamReader(inputStream2, charset);
                                            int n = 8192;
                                            BufferedReader reader2 = reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader, n);
                                            String string3 = reader2.readLine();
                                            if (string3 == null) {
                                                string3 = "";
                                            }
                                            if ((string2 = (String)CollectionsKt.getOrNull((List)StringsKt.split$default((CharSequence)(requestLine = string3), (String[])(stringArray = new String[]{" "}), (boolean)false, (int)0, (int)6, null), (int)1)) == null) {
                                                string2 = "";
                                            }
                                            String pathAndQuery = string2;
                                            String query = StringsKt.substringAfter((String)pathAndQuery, (String)"?", (String)"");
                                            Map params = DesktopBrowserLauncher.access$parseQueryString(desktopBrowserLauncher, query);
                                            String body = "<html><body style='font-family:sans-serif;text-align:center;padding:40px'><h2>Authentication successful!</h2><p>You can close this tab and return to Echo.</p></body></html>";
                                            byte[] byArray = body.getBytes(Charsets.UTF_8);
                                            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
                                            String response2 = "HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=utf-8\r\nContent-Length: " + byArray.length + "\r\nConnection: close\r\n\r\n" + body;
                                            OutputStream outputStream = sock.getOutputStream();
                                            byte[] byArray2 = response2.getBytes(Charsets.UTF_8);
                                            Intrinsics.checkNotNullExpressionValue((Object)byArray2, (String)"getBytes(...)");
                                            outputStream.write(byArray2);
                                            sock.getOutputStream().flush();
                                            bl = completableDeferred.complete((Object)params);
                                        }
                                        catch (Throwable throwable3) {
                                            throwable2 = throwable3;
                                            throw throwable3;
                                        }
                                        finally {
                                            CloseableKt.closeFinally((Closeable)closeable2, (Throwable)throwable2);
                                        }
                                        boolean bl4 = bl;
                                        return Unit.INSTANCE;
                                    }
                                    catch (Throwable throwable4) {
                                        throwable = throwable4;
                                        throw throwable4;
                                    }
                                    finally {
                                        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                                    }
                                }
                                catch (Exception e) {
                                    if (this.$result.isCompleted()) return Unit.INSTANCE;
                                    this.$result.completeExceptionally((Throwable)e);
                                }
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
                }), (int)3, null);
                this.openExternal(url);
                $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)url);
                $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)redirectScheme);
                $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)result);
                $continuation.L$3 = server;
                $continuation.L$4 = job;
                $continuation.label = 1;
                v0 = TimeoutKt.withTimeout((long)300000L, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object>((CompletableDeferred<Map<String, String>>)result, null){
                    int label;
                    final /* synthetic */ CompletableDeferred<Map<String, String>> $result;
                    {
                        this.$result = $result;
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
                                Object object2 = this.$result.await((Continuation)this);
                                if (object2 != object) return object2;
                                return object;
                            }
                            case 1: {
                                ResultKt.throwOnFailure((Object)$result);
                                Object object2 = $result;
                                return object2;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                        return (Continuation)new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(CoroutineScope p1, Continuation<? super Map<String, String>> p2) {
                        return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                    }
                }), (Continuation)$continuation);
                ** if (v0 != var14_6) goto lbl27
lbl26:
                // 1 sources

                return var14_6;
lbl27:
                // 1 sources

                ** GOTO lbl38
            }
            case 1: {
                job = (Job)$continuation.L$4;
                server = (ServerSocket)$continuation.L$3;
                result = (CompletableDeferred)$continuation.L$2;
                redirectScheme = (String)$continuation.L$1;
                url = (String)$continuation.L$0;
                try {
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl38:
                    // 2 sources

                    var7_11 = (Map)v0;
                }
                catch (Throwable var8_13) {
                    throw var8_13;
                }
                finally {
                    var8_12 = this;
                    try {
                        $this$open_u24lambda_u240 = var8_12;
                        $i$a$-runCatching-DesktopBrowserLauncher$open$3 = false;
                        server.close();
                        var9_14 = Result.constructor-impl((Object)Unit.INSTANCE);
                    }
                    catch (Throwable $i$a$-runCatching-DesktopBrowserLauncher$open$3) {
                        var9_15 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)$i$a$-runCatching-DesktopBrowserLauncher$open$3));
                    }
                    Job.DefaultImpls.cancel$default((Job)job, null, (int)1, null);
                }
                return var7_11;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override
    public void openExternal(@NotNull String url) {
        Intrinsics.checkNotNullParameter((Object)url, (String)"url");
        DesktopBrowserLauncher desktopBrowserLauncher = this;
        try {
            Object object;
            DesktopBrowserLauncher $this$openExternal_u24lambda_u241 = desktopBrowserLauncher;
            boolean bl = false;
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
                object = Unit.INSTANCE;
            } else {
                String string2 = System.getProperty("os.name");
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getProperty(...)");
                String string3 = string2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toLowerCase(...)");
                String os = string3;
                if (StringsKt.contains$default((CharSequence)os, (CharSequence)"win", (boolean)false, (int)2, null)) {
                    String[] stringArray = new String[]{"cmd", "/c", "start", url};
                    object = Runtime.getRuntime().exec(stringArray);
                } else if (StringsKt.contains$default((CharSequence)os, (CharSequence)"mac", (boolean)false, (int)2, null)) {
                    String[] stringArray = new String[]{"open", url};
                    object = Runtime.getRuntime().exec(stringArray);
                } else {
                    String[] stringArray = new String[]{"xdg-open", url};
                    object = Runtime.getRuntime().exec(stringArray);
                }
            }
            Object object2 = Result.constructor-impl((Object)object);
        }
        catch (Throwable throwable) {
            Object object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
    }

    /*
     * WARNING - void declaration
     */
    private final Map<String, String> parseQueryString(String query) {
        void $this$associateTo$iv$iv;
        if (StringsKt.isBlank((CharSequence)query)) {
            return MapsKt.emptyMap();
        }
        String[] stringArray = new String[]{"&"};
        Iterable $this$associate$iv = StringsKt.split$default((CharSequence)query, (String[])stringArray, (boolean)false, (int)0, (int)6, null);
        boolean $i$f$associate = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)CollectionsKt.collectionSizeOrDefault((Iterable)$this$associate$iv, (int)10)), (int)16);
        Iterable iterable = $this$associate$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateTo = false;
        for (Object element$iv$iv : $this$associateTo$iv$iv) {
            Object object;
            Object object2;
            Map map2 = destination$iv$iv;
            String param = (String)element$iv$iv;
            boolean bl = false;
            int n = 0;
            String[] stringArray2 = new String[]{"="};
            List parts = StringsKt.split$default((CharSequence)param, (String[])stringArray2, (boolean)false, (int)2, (int)2, null);
            List list2 = parts;
            if (n < list2.size()) {
                object2 = list2.get(n);
            } else {
                int it = n;
                boolean bl2 = false;
                object2 = "";
            }
            String key = URLDecoder.decode((String)object2, "UTF-8");
            List list3 = parts;
            int n2 = 1;
            if (n2 < list3.size()) {
                object = list3.get(n2);
            } else {
                int it = n2;
                boolean bl3 = false;
                object = "";
            }
            String value2 = URLDecoder.decode((String)object, "UTF-8");
            Pair pair = TuplesKt.to((Object)key, (Object)value2);
            map2.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    public static final /* synthetic */ Map access$parseQueryString(DesktopBrowserLauncher $this, String query) {
        return $this.parseQueryString(query);
    }
}

