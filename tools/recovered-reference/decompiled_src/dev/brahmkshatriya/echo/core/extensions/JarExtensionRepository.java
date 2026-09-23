/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.io.FilesKt
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.coroutines.DelayKt
 *  kotlinx.coroutines.flow.Flow
 *  kotlinx.coroutines.flow.FlowCollector
 *  kotlinx.coroutines.flow.FlowKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonBuilder
 *  kotlinx.serialization.json.JsonKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.extensions;

import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.core.extensions.ExtensionInstallSource;
import dev.brahmkshatriya.echo.core.extensions.ExtensionRepository;
import dev.brahmkshatriya.echo.core.extensions.JarExtensionRepository$ExtensionManifest$;
import dev.brahmkshatriya.echo.core.extensions.builtin.LocalMusicExtension;
import dev.brahmkshatriya.echo.core.platform.AppPlatform;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.invoke.LambdaMetafactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000256B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002J9\u0010\u001a\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00130\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002\u00a2\u0006\u0002\u0010\u001eJ/\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00132\u0006\u0010 \u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000eH\u0002J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010%\u001a\u00020&H\u0096@\u00a2\u0006\u0004\b'\u0010(J&\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0096@\u00a2\u0006\u0004\b-\u0010.J\u001e\u0010/\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000e2\u0006\u00100\u001a\u000201H\u0096@\u00a2\u0006\u0002\u00102J\u000e\u00103\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R8\u0010\u0010\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00140\u00130\u00120\u0011X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00067"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository;", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionRepository;", "platform", "Ldev/brahmkshatriya/echo/core/platform/AppPlatform;", "settings", "Ldev/brahmkshatriya/echo/core/settings/EchoSettings;", "<init>", "(Ldev/brahmkshatriya/echo/core/platform/AppPlatform;Ldev/brahmkshatriya/echo/core/settings/EchoSettings;)V", "json", "Lkotlinx/serialization/json/Json;", "unpackBundledExtensions", "", "jarCache", "", "", "Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$CachedJar;", "flow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Result;", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "scanExtensions", "jarFiles", "", "Ljava/io/File;", "([Ljava/io/File;)Ljava/util/List;", "loadJar", "jarPath", "loadJar-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "parseExtensionMetadata", "install", "source", "Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;", "install-gIAlu-s", "(Ldev/brahmkshatriya/echo/core/extensions/ExtensionInstallSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uninstall", "id", "type", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "uninstall-0E7RQCE", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/ExtensionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnabled", "enabled", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CachedJar", "ExtensionManifest", "core"})
@SourceDebugExtension(value={"SMAP\nJarExtensionRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JarExtensionRepository.kt\ndev/brahmkshatriya/echo/core/extensions/JarExtensionRepository\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,264:1\n1#2:265\n11228#3:266\n11563#3,3:267\n11228#3:270\n11563#3,3:271\n13472#3,2:275\n222#4:274\n*S KotlinDebug\n*F\n+ 1 JarExtensionRepository.kt\ndev/brahmkshatriya/echo/core/extensions/JarExtensionRepository\n*L\n93#1:266\n93#1:267,3\n96#1:270\n96#1:271,3\n232#1:275,2\n145#1:274\n*E\n"})
public final class JarExtensionRepository
implements ExtensionRepository {
    @NotNull
    private final AppPlatform platform;
    @Nullable
    private final EchoSettings settings;
    @NotNull
    private final Json json;
    @NotNull
    private final Map<String, CachedJar> jarCache;
    @NotNull
    private final Flow<List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Lazy<ExtensionClient>>>>> flow;

    public JarExtensionRepository(@NotNull AppPlatform platform, @Nullable EchoSettings settings) {
        Intrinsics.checkNotNullParameter((Object)platform, (String)"platform");
        this.platform = platform;
        this.settings = settings;
        this.json = JsonKt.Json$default(null, JarExtensionRepository::json$lambda$0, (int)1, null);
        this.unpackBundledExtensions();
        this.jarCache = new LinkedHashMap();
        this.flow = FlowKt.flow((Function2)((Function2)new Function2<FlowCollector<? super List<? extends Result<? extends Pair<? extends dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>>, Continuation<? super Unit>, Object>(this, null){
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;
            private /* synthetic */ Object L$0;
            final /* synthetic */ JarExtensionRepository this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var2_2 = (FlowCollector)this.L$0;
                var10_3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        localBuiltin = Result.constructor-impl((Object)TuplesKt.to((Object)LocalMusicExtension.Companion.getMETADATA(), (Object)LazyKt.lazy((Function0)(Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, invokeSuspend$lambda$0(dev.brahmkshatriya.echo.core.extensions.JarExtensionRepository ), ()Ldev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension;)((JarExtensionRepository)this.this$0))));
                        lastFingerprint = "";
lbl10:
                        // 2 sources

                        while (true) {
                            it = var6_7 = JarExtensionRepository.access$getPlatform$p(this.this$0).getExtensionsDir().toFile();
                            $i$a$-also-JarExtensionRepository$flow$1$extensionsDir$1 = false;
                            it.mkdirs();
                            extensionsDir = var6_7;
                            v0 = extensionsDir.listFiles((FileFilter)LambdaMetafactory.metafactory(null, null, null, (Ljava/io/File;)Z, invokeSuspend$lambda$2(java.io.File ), (Ljava/io/File;)Z)());
                            if (v0 == null) {
                                v0 = new File[]{};
                            }
                            $this$sortedBy$iv = jarFiles = v0;
                            $i$f$sortedBy = false;
                            currentFingerprint = CollectionsKt.joinToString$default((Iterable)ArraysKt.sortedWith((Object[])$this$sortedBy$iv, (Comparator)new Comparator(){

                                public final int compare(T a, T b) {
                                    File it = (File)a;
                                    boolean bl = false;
                                    Comparable comparable = (Comparable)((Object)it.getAbsolutePath());
                                    it = (File)b;
                                    Comparable comparable2 = comparable;
                                    bl = false;
                                    return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)((Comparable)((Object)it.getAbsolutePath())));
                                }
                            }), (CharSequence)";", null, null, (int)0, null, (Function1)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, invokeSuspend$lambda$4(java.io.File ), (Ljava/io/File;)Ljava/lang/CharSequence;)(), (int)30, null);
                            if (!Intrinsics.areEqual((Object)currentFingerprint, (Object)lastFingerprint)) {
                                lastFingerprint = currentFingerprint;
                                scanned = JarExtensionRepository.access$scanExtensions(this.this$0, (File[])jarFiles);
                                System.out.println((Object)("[Echo JarExtensionRepository] Extensions list changed. Emitting " + scanned.size() + " JAR extension(s) + local music."));
                                this.L$0 = $this$flow;
                                this.L$1 = localBuiltin;
                                this.L$2 = lastFingerprint;
                                this.L$3 = SpillingKt.nullOutSpilledVariable((Object)extensionsDir);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object)jarFiles);
                                this.L$5 = SpillingKt.nullOutSpilledVariable((Object)currentFingerprint);
                                this.L$6 = SpillingKt.nullOutSpilledVariable((Object)scanned);
                                this.label = 1;
                                v1 = $this$flow.emit((Object)CollectionsKt.plus((Collection)scanned, (Iterable)CollectionsKt.listOf((Object)Result.box-impl((Object)localBuiltin))), (Continuation)this);
                                if (v1 == var10_3) {
                                    return var10_3;
                                }
                            }
                            ** GOTO lbl47
                            break;
                        }
                    }
                    case 1: {
                        scanned = (List)this.L$6;
                        currentFingerprint = (String)this.L$5;
                        jarFiles = (File[])this.L$4;
                        extensionsDir = (File)this.L$3;
                        lastFingerprint = (String)this.L$2;
                        localBuiltin = this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl47:
                        // 2 sources

                        this.L$0 = $this$flow;
                        this.L$1 = localBuiltin;
                        this.L$2 = lastFingerprint;
                        this.L$3 = SpillingKt.nullOutSpilledVariable((Object)extensionsDir);
                        this.L$4 = SpillingKt.nullOutSpilledVariable((Object)jarFiles);
                        this.L$5 = SpillingKt.nullOutSpilledVariable((Object)currentFingerprint);
                        this.L$6 = null;
                        this.label = 2;
                        v2 = DelayKt.delay((long)3000L, (Continuation)((Continuation)this));
                        if (v2 == var10_3) {
                            return var10_3;
                        }
                        ** GOTO lbl67
                    }
                    case 2: {
                        currentFingerprint = (String)this.L$5;
                        jarFiles = (File[])this.L$4;
                        extensionsDir = (File)this.L$3;
                        lastFingerprint = (String)this.L$2;
                        localBuiltin = this.L$1;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl67:
                        // 2 sources

                        ** continue;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                var var3_3 = new /* invalid duplicate definition of identical inner class */;
                var3_3.L$0 = value2;
                return (Continuation)var3_3;
            }

            public final Object invoke(FlowCollector<? super List<? extends Result<? extends Pair<dev.brahmkshatriya.echo.common.models.Metadata, ? extends Lazy<? extends ExtensionClient>>>>> p1, Continuation<? super Unit> p2) {
                return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
            }

            private static final LocalMusicExtension invokeSuspend$lambda$0(JarExtensionRepository this$0) {
                return new LocalMusicExtension(JarExtensionRepository.access$getPlatform$p(this$0), JarExtensionRepository.access$getSettings$p(this$0));
            }

            private static final boolean invokeSuspend$lambda$2(File f) {
                Intrinsics.checkNotNull((Object)f);
                return StringsKt.equals((String)FilesKt.getExtension((File)f), (String)"jar", (boolean)true);
            }

            private static final CharSequence invokeSuspend$lambda$4(File it) {
                return it.getAbsolutePath() + ":" + it.lastModified();
            }
        }));
    }

    public /* synthetic */ JarExtensionRepository(AppPlatform appPlatform, EchoSettings echoSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            echoSettings = null;
        }
        this(appPlatform, echoSettings);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void unpackBundledExtensions() {
        try {
            File file2;
            File it = file2 = this.platform.getExtensionsDir().toFile();
            boolean bl = false;
            it.mkdirs();
            File destDir = file2;
            String[] stringArray = new String[]{"youtube.jar", "saavn.jar", "soundcloud.jar", "radiobrowser.jar", "lrclib.jar", "genius.jar", "musixmatch.jar", "discordrpc.jar", "lastfm.jar"};
            List bundled = CollectionsKt.listOf((Object[])stringArray);
            for (String name : bundled) {
                InputStream stream;
                File file3 = new File(destDir, name);
                if (file3.exists() && file3.length() != 0L) continue;
                InputStream inputStream = this.getClass().getResourceAsStream("/extensions/" + name);
                if (inputStream == null && (inputStream = this.getClass().getResourceAsStream("extensions/" + name)) == null) {
                    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                    inputStream = classLoader != null ? classLoader.getResourceAsStream("extensions/" + name) : null;
                    if (inputStream == null) {
                        inputStream = ClassLoader.getSystemResourceAsStream("extensions/" + name);
                    }
                }
                if ((stream = inputStream) == null) continue;
                Closeable closeable = stream;
                Throwable throwable = null;
                try {
                    long l;
                    InputStream input = (InputStream)closeable;
                    boolean bl2 = false;
                    Closeable closeable2 = new FileOutputStream(file3);
                    Throwable throwable2 = null;
                    try {
                        FileOutputStream output = (FileOutputStream)closeable2;
                        boolean bl3 = false;
                        l = ByteStreamsKt.copyTo$default((InputStream)input, (OutputStream)output, (int)0, (int)2, null);
                    }
                    catch (Throwable throwable3) {
                        throwable2 = throwable3;
                        throw throwable3;
                    }
                    finally {
                        CloseableKt.closeFinally((Closeable)closeable2, (Throwable)throwable2);
                    }
                    long l2 = l;
                }
                catch (Throwable throwable4) {
                    throwable = throwable4;
                    throw throwable4;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                }
                System.out.println((Object)("[Echo JarExtensionRepository] Unpacked bundled extension " + name + " to " + file3.getAbsolutePath()));
            }
        }
        catch (Exception e) {
            System.err.println("[Echo JarExtensionRepository] Error unpacking bundled extensions: " + e.getMessage());
        }
    }

    @Override
    @NotNull
    public Flow<List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Lazy<ExtensionClient>>>>> getFlow() {
        return this.flow;
    }

    /*
     * WARNING - void declaration
     */
    private final List<Result<Pair<dev.brahmkshatriya.echo.common.models.Metadata, Lazy<ExtensionClient>>>> scanExtensions(File[] jarFiles) {
        File it;
        Collection collection;
        File[] $this$mapTo$iv$iv;
        File[] $this$map$iv = jarFiles;
        boolean $i$f$map = false;
        File[] fileArray = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        for (File item$iv$iv : $this$mapTo$iv$iv) {
            void var11_10 = item$iv$iv;
            collection = destination$iv$iv;
            boolean bl = false;
            collection.add(it.getAbsolutePath());
        }
        Set currentPaths = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
        this.jarCache.keySet().retainAll(currentPaths);
        $this$map$iv = jarFiles;
        $i$f$map = false;
        $this$mapTo$iv$iv = $this$map$iv;
        destination$iv$iv = new ArrayList($this$map$iv.length);
        $i$f$mapTo = false;
        int n = $this$mapTo$iv$iv.length;
        for (int i = 0; i < n; ++i) {
            Object object;
            void jar;
            File item$iv$iv;
            it = item$iv$iv = $this$mapTo$iv$iv[i];
            collection = destination$iv$iv;
            boolean bl = false;
            CachedJar cached = this.jarCache.get(jar.getAbsolutePath());
            if (cached != null && cached.getLastModified() == jar.lastModified()) {
                object = cached.getResult-d1pmJ48();
            } else {
                String string2 = jar.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getAbsolutePath(...)");
                Object res2 = this.loadJar-IoAF18A(string2);
                this.jarCache.put(jar.getAbsolutePath(), new CachedJar(jar.lastModified(), res2));
                object = res2;
            }
            collection.add(Result.box-impl((Object)object));
        }
        return (List)destination$iv$iv;
    }

    private final Object loadJar-IoAF18A(String jarPath) {
        Object object;
        block2: {
            Object object2;
            object = this;
            try {
                JarExtensionRepository $this$loadJar_IoAF18A_u24lambda_u247 = object;
                boolean bl = false;
                dev.brahmkshatriya.echo.common.models.Metadata metadata2 = $this$loadJar_IoAF18A_u24lambda_u247.parseExtensionMetadata(jarPath);
                System.out.println((Object)("[Echo] Discovered JAR extension: " + metadata2.getName() + " (" + metadata2.getId() + ") at " + jarPath));
                Lazy lazyClient = LazyKt.lazy(() -> JarExtensionRepository.loadJar_IoAF18A$lambda$7$lambda$6(jarPath, $this$loadJar_IoAF18A_u24lambda_u247, metadata2));
                object2 = Result.constructor-impl((Object)TuplesKt.to((Object)metadata2, (Object)lazyClient));
            }
            catch (Throwable bl) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            object = object2;
            Throwable throwable = Result.exceptionOrNull-impl((Object)object);
            if (throwable == null) break block2;
            Object e = object2 = throwable;
            boolean bl = false;
            System.err.println("[Echo] Failed to parse JAR extension at " + jarPath + ": " + ((Throwable)e).getMessage());
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private final dev.brahmkshatriya.echo.common.models.Metadata parseExtensionMetadata(String jarPath) {
        Object object;
        String string2;
        String description;
        String string3;
        String version;
        String string4;
        String name;
        String string5;
        String id2;
        File file2 = new File(jarPath);
        if (StringsKt.equals((String)FilesKt.getExtension((File)file2), (String)"apk", (boolean)true) || StringsKt.equals((String)FilesKt.getExtension((File)file2), (String)"eapk", (boolean)true)) {
            throw new IllegalStateException(("Cannot load Android APK '" + file2.getName() + "'. Echo Desktop requires JVM JAR extensions (.jar).").toString());
        }
        JarFile jarFile = new JarFile(jarPath);
        JarEntry jsonEntry = jarFile.getJarEntry("META-INF/echo-extension.json");
        if (jsonEntry != null) {
            String string6;
            void this_$iv;
            InputStream inputStream = jarFile.getInputStream(jsonEntry);
            Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"getInputStream(...)");
            InputStream inputStream2 = inputStream;
            Charset charset = Charsets.UTF_8;
            Reader reader = new InputStreamReader(inputStream2, charset);
            int n = 8192;
            String jsonStr = TextStreamsKt.readText((Reader)(reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader, n)));
            jarFile.close();
            charset = this.json;
            String string$iv = jsonStr;
            boolean $i$f$decodeFromString = false;
            this_$iv.getSerializersModule();
            ExtensionManifest dto = (ExtensionManifest)this_$iv.decodeFromString((DeserializationStrategy)ExtensionManifest.Companion.serializer(), string$iv);
            Object fullClassName = StringsKt.contains$default((CharSequence)dto.getClassName(), (char)'.', (boolean)false, (int)2, null) ? dto.getClassName() : "dev.brahmkshatriya.echo.extension." + dto.getClassName();
            EchoSettings echoSettings = this.settings;
            boolean isEnabled = echoSettings != null ? echoSettings.getBoolean("ext_enabled_" + dto.getId(), true) : true;
            String string7 = dto.getType().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue((Object)string7, (String)"toUpperCase(...)");
            ExtensionType extensionType = ExtensionType.valueOf(string7);
            String string8 = dto.getId();
            String string9 = dto.getName();
            String string10 = dto.getVersion();
            String string11 = dto.getDescription();
            if (string11 == null) {
                string11 = "";
            }
            if ((string6 = dto.getAuthor()) == null) {
                string6 = "Unknown";
            }
            return new dev.brahmkshatriya.echo.common.models.Metadata((String)fullClassName, jarPath, ImportType.File, extensionType, string8, string9, string10, string11, string6, dto.getAuthorUrl(), null, dto.getRepoUrl(), dto.getUpdateUrl(), null, isEnabled, 9216, null);
        }
        Manifest manifest = jarFile.getManifest();
        if (manifest == null) {
            JarExtensionRepository $this$parseExtensionMetadata_u24lambda_u249 = this;
            boolean bl = false;
            jarFile.close();
            throw new IllegalStateException(("Neither META-INF/echo-extension.json nor MANIFEST.MF found in " + file2.getName()).toString());
        }
        Manifest manifest2 = manifest;
        Attributes attrs = manifest2.getMainAttributes();
        String string12 = attrs.getValue("Extension-Class");
        if (string12 == null) {
            JarExtensionRepository $this$parseExtensionMetadata_u24lambda_u2410 = this;
            boolean bl = false;
            jarFile.close();
            throw new IllegalStateException(("Missing Extension-Class attribute in MANIFEST.MF of " + file2.getName()).toString());
        }
        String rawClass = string12;
        Object fullClassName = StringsKt.contains$default((CharSequence)rawClass, (char)'.', (boolean)false, (int)2, null) ? rawClass : "dev.brahmkshatriya.echo.extension." + rawClass;
        String string13 = attrs.getValue("Extension-Id");
        if (string13 == null) {
            string13 = id2 = FilesKt.getNameWithoutExtension((File)file2);
        }
        if ((string5 = attrs.getValue("Extension-Name")) == null) {
            string5 = name = id2;
        }
        if ((string4 = attrs.getValue("Extension-Type")) == null) {
            string4 = "MUSIC";
        }
        String string14 = string4.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string14, (String)"toUpperCase(...)");
        String typeStr = string14;
        String string15 = attrs.getValue("Extension-Version-Name");
        if (string15 == null && (string15 = attrs.getValue("Extension-Version-Code")) == null) {
            string15 = version = "1.0.0";
        }
        if ((string3 = attrs.getValue("Extension-Description")) == null) {
            string3 = description = "";
        }
        if ((string2 = attrs.getValue("Extension-Author")) == null) {
            string2 = "Echo Community";
        }
        String author = string2;
        String authorUrl = attrs.getValue("Extension-Author-Url");
        String repoUrl = attrs.getValue("Extension-Repo-Url");
        String updateUrl = attrs.getValue("Extension-Update-Url");
        jarFile.close();
        Object object2 = this;
        try {
            JarExtensionRepository $this$parseExtensionMetadata_u24lambda_u2411 = object2;
            boolean bl = false;
            object = Result.constructor-impl((Object)((Object)ExtensionType.valueOf(typeStr)));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object2 = object;
        object = ExtensionType.MUSIC;
        ExtensionType type = (ExtensionType)((Object)(Result.isFailure-impl((Object)object2) ? object : object2));
        EchoSettings echoSettings = this.settings;
        boolean isEnabled = echoSettings != null ? echoSettings.getBoolean("ext_enabled_" + id2, true) : true;
        return new dev.brahmkshatriya.echo.common.models.Metadata((String)fullClassName, jarPath, ImportType.File, type, id2, name, version, description, author, authorUrl, null, repoUrl, updateUrl, null, isEnabled, 9216, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    @Nullable
    public Object install-gIAlu-s(@NotNull ExtensionInstallSource source, @NotNull Continuation<? super Result<dev.brahmkshatriya.echo.common.models.Metadata>> $completion) {
        Object object;
        JarExtensionRepository jarExtensionRepository = this;
        try {
            dev.brahmkshatriya.echo.common.models.Metadata metadata2;
            JarExtensionRepository $this$install_gIAlu_s_u24lambda_u2416 = jarExtensionRepository;
            boolean bl = false;
            Object object2 = $this$install_gIAlu_s_u24lambda_u2416.platform.getExtensionsDir().toFile();
            File it = object2;
            boolean bl2 = false;
            it.mkdirs();
            File destDir = object2;
            object2 = source;
            if (object2 instanceof ExtensionInstallSource.LocalFile) {
                File src = new File(((ExtensionInstallSource.LocalFile)source).getPath());
                if (StringsKt.equals((String)FilesKt.getExtension((File)src), (String)"apk", (boolean)true) || StringsKt.equals((String)FilesKt.getExtension((File)src), (String)"eapk", (boolean)true)) {
                    throw new IllegalStateException(("Cannot install '" + src.getName() + "'. Android APK/EAPK files run Dalvik bytecode (.dex). Echo Desktop requires Kotlin JVM .jar extensions. Please use or compile the .jar release of this extension.").toString());
                }
                File dest = new File(destDir, src.getName());
                FilesKt.copyTo$default((File)src, (File)dest, (boolean)true, (int)0, (int)4, null);
                String string2 = dest.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getAbsolutePath(...)");
                metadata2 = $this$install_gIAlu_s_u24lambda_u2416.parseExtensionMetadata(string2);
            } else if (object2 instanceof ExtensionInstallSource.RemoteUrl) {
                URL url = new URL(((ExtensionInstallSource.RemoteUrl)source).getUrl());
                String string3 = url.getFile();
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"getFile(...)");
                String it2 = StringsKt.substringAfterLast$default((String)string3, (char)'/', null, (int)2, null);
                boolean bl3 = false;
                Object fileName = StringsKt.endsWith$default((String)it2, (String)".jar", (boolean)false, (int)2, null) ? it2 : it2 + ".jar";
                File dest = new File(destDir, (String)fileName);
                Closeable closeable = url.openStream();
                Throwable throwable = null;
                try {
                    long l;
                    InputStream input = (InputStream)closeable;
                    boolean bl4 = false;
                    Closeable closeable2 = new FileOutputStream(dest);
                    Throwable throwable2 = null;
                    try {
                        FileOutputStream output = (FileOutputStream)closeable2;
                        boolean bl5 = false;
                        Intrinsics.checkNotNull((Object)input);
                        l = ByteStreamsKt.copyTo$default((InputStream)input, (OutputStream)output, (int)0, (int)2, null);
                    }
                    catch (Throwable throwable3) {
                        throwable2 = throwable3;
                        throw throwable3;
                    }
                    finally {
                        CloseableKt.closeFinally((Closeable)closeable2, (Throwable)throwable2);
                    }
                    long l2 = l;
                }
                catch (Throwable throwable4) {
                    throwable = throwable4;
                    throw throwable4;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
                }
                String string4 = dest.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"getAbsolutePath(...)");
                metadata2 = $this$install_gIAlu_s_u24lambda_u2416.parseExtensionMetadata(string4);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            object = Result.constructor-impl((Object)metadata2);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        return object;
    }

    @Override
    @Nullable
    public Object uninstall-0E7RQCE(@NotNull String id2, @NotNull ExtensionType type, @NotNull Continuation<? super Result<Unit>> $completion) {
        Object object;
        JarExtensionRepository jarExtensionRepository = this;
        try {
            JarExtensionRepository $this$uninstall_0E7RQCE_u24lambda_u2420 = jarExtensionRepository;
            boolean bl = false;
            File extensionsDir = $this$uninstall_0E7RQCE_u24lambda_u2420.platform.getExtensionsDir().toFile();
            File[] fileArray = extensionsDir.listFiles(JarExtensionRepository::uninstall_0E7RQCE$lambda$20$lambda$17);
            if (fileArray != null) {
                File[] $this$forEach$iv = fileArray;
                boolean $i$f$forEach = false;
                int n = $this$forEach$iv.length;
                for (int i = 0; i < n; ++i) {
                    Object object2;
                    File element$iv;
                    File jar = element$iv = $this$forEach$iv[i];
                    boolean bl2 = false;
                    JarExtensionRepository jarExtensionRepository2 = $this$uninstall_0E7RQCE_u24lambda_u2420;
                    try {
                        JarExtensionRepository $this$uninstall_0E7RQCE_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418 = jarExtensionRepository2;
                        boolean bl3 = false;
                        String string2 = jar.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"getAbsolutePath(...)");
                        dev.brahmkshatriya.echo.common.models.Metadata meta = $this$uninstall_0E7RQCE_u24lambda_u2420_u24lambda_u2419_u24lambda_u2418.parseExtensionMetadata(string2);
                        if (Intrinsics.areEqual((Object)meta.getId(), (Object)id2) && meta.getType() == type) {
                            jar.delete();
                        }
                        object2 = Result.constructor-impl((Object)Unit.INSTANCE);
                        continue;
                    }
                    catch (Throwable throwable) {
                        object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                    }
                }
            }
            object = Result.constructor-impl((Object)Unit.INSTANCE);
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        return object;
    }

    @Override
    @Nullable
    public Object setEnabled(@NotNull String id2, boolean enabled, @NotNull Continuation<? super Unit> $completion) {
        EchoSettings echoSettings = this.settings;
        if (echoSettings != null) {
            echoSettings.putBoolean("ext_enabled_" + id2, enabled);
        }
        this.jarCache.clear();
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object reload(@NotNull Continuation<? super Unit> $completion) {
        this.jarCache.clear();
        return Unit.INSTANCE;
    }

    private static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter((Object)$this$Json, (String)"$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }

    private static final ExtensionClient loadJar_IoAF18A$lambda$7$lambda$6(String $jarPath, JarExtensionRepository $this_runCatching, dev.brahmkshatriya.echo.common.models.Metadata $metadata) {
        ExtensionClient extensionClient;
        try {
            URL[] uRLArray = new URL[]{new File($jarPath).toURI().toURL()};
            URLClassLoader loader = new URLClassLoader(uRLArray, $this_runCatching.getClass().getClassLoader());
            System.out.println((Object)("[Echo] Loading extension class: " + $metadata.getClassName()));
            Class<?> clazz = loader.loadClass($metadata.getClassName());
            Object obj = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type dev.brahmkshatriya.echo.common.clients.ExtensionClient");
            ExtensionClient instance = (ExtensionClient)obj;
            System.out.println((Object)("[Echo] Successfully instantiated extension: " + $metadata.getName()));
            extensionClient = instance;
        }
        catch (Throwable t) {
            System.err.println("[Echo] Error instantiating extension " + $metadata.getName() + ": " + t.getMessage());
            t.printStackTrace();
            throw t;
        }
        return extensionClient;
    }

    private static final boolean uninstall_0E7RQCE$lambda$20$lambda$17(File f) {
        Intrinsics.checkNotNull((Object)f);
        return Intrinsics.areEqual((Object)FilesKt.getExtension((File)f), (Object)"jar");
    }

    public static final /* synthetic */ AppPlatform access$getPlatform$p(JarExtensionRepository $this) {
        return $this.platform;
    }

    public static final /* synthetic */ List access$scanExtensions(JarExtensionRepository $this, File[] jarFiles) {
        return $this.scanExtensions(jarFiles);
    }

    public static final /* synthetic */ EchoSettings access$getSettings$p(JarExtensionRepository $this) {
        return $this.settings;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J(\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u000fJ:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$CachedJar;", "", "lastModified", "", "result", "Lkotlin/Result;", "Lkotlin/Pair;", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "<init>", "(JLjava/lang/Object;)V", "getLastModified", "()J", "getResult-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-d1pmJ48", "copy", "(JLjava/lang/Object;)Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$CachedJar;", "equals", "", "other", "hashCode", "", "toString", "", "core"})
    private static final class CachedJar {
        private final long lastModified;
        @NotNull
        private final Object result;

        public CachedJar(long lastModified, @NotNull Object result2) {
            this.lastModified = lastModified;
            this.result = result2;
        }

        public final long getLastModified() {
            return this.lastModified;
        }

        @NotNull
        public final Object getResult-d1pmJ48() {
            return this.result;
        }

        public final long component1() {
            return this.lastModified;
        }

        @NotNull
        public final Object component2-d1pmJ48() {
            return this.result;
        }

        @NotNull
        public final CachedJar copy(long lastModified, @NotNull Object result2) {
            return new CachedJar(lastModified, result2);
        }

        public static /* synthetic */ CachedJar copy$default(CachedJar cachedJar, long l, Result result2, int n, Object object) {
            if ((n & 1) != 0) {
                l = cachedJar.lastModified;
            }
            if ((n & 2) != 0) {
                result2 = Result.box-impl((Object)cachedJar.result);
            }
            return cachedJar.copy(l, result2.unbox-impl());
        }

        @NotNull
        public String toString() {
            return "CachedJar(lastModified=" + this.lastModified + ", result=" + Result.toString-impl((Object)this.result) + ")";
        }

        public int hashCode() {
            int result2 = Long.hashCode(this.lastModified);
            result2 = result2 * 31 + Result.hashCode-impl((Object)this.result);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedJar)) {
                return false;
            }
            CachedJar cachedJar = (CachedJar)other;
            if (this.lastModified != cachedJar.lastModified) {
                return false;
            }
            return Result.equals-impl0((Object)this.result, (Object)cachedJar.result);
        }
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0083\b\u0018\u0000 82\u00020\u0001:\u000278Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\r\u0010\u000eB\u007f\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\r\u0010\u0013J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0010H\u00d6\u0001J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001\u00a2\u0006\u0002\b6R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015\u00a8\u00069"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$ExtensionManifest;", "", "id", "", "className", "name", "version", "type", "description", "author", "authorUrl", "repoUrl", "updateUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getClassName", "getName", "getVersion", "getType", "getDescription", "getAuthor", "getAuthorUrl", "getRepoUrl", "getUpdateUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core", "$serializer", "Companion", "core"})
    private static final class ExtensionManifest {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String id;
        @NotNull
        private final String className;
        @NotNull
        private final String name;
        @NotNull
        private final String version;
        @NotNull
        private final String type;
        @Nullable
        private final String description;
        @Nullable
        private final String author;
        @Nullable
        private final String authorUrl;
        @Nullable
        private final String repoUrl;
        @Nullable
        private final String updateUrl;

        public ExtensionManifest(@NotNull String id2, @NotNull String className, @NotNull String name, @NotNull String version, @NotNull String type, @Nullable String description, @Nullable String author, @Nullable String authorUrl, @Nullable String repoUrl, @Nullable String updateUrl) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)className, (String)"className");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)version, (String)"version");
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            this.id = id2;
            this.className = className;
            this.name = name;
            this.version = version;
            this.type = type;
            this.description = description;
            this.author = author;
            this.authorUrl = authorUrl;
            this.repoUrl = repoUrl;
            this.updateUrl = updateUrl;
        }

        public /* synthetic */ ExtensionManifest(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x20) != 0) {
                string7 = null;
            }
            if ((n & 0x40) != 0) {
                string8 = null;
            }
            if ((n & 0x80) != 0) {
                string9 = null;
            }
            if ((n & 0x100) != 0) {
                string10 = null;
            }
            if ((n & 0x200) != 0) {
                string11 = null;
            }
            this(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getClassName() {
            return this.className;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getVersion() {
            return this.version;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getAuthor() {
            return this.author;
        }

        @Nullable
        public final String getAuthorUrl() {
            return this.authorUrl;
        }

        @Nullable
        public final String getRepoUrl() {
            return this.repoUrl;
        }

        @Nullable
        public final String getUpdateUrl() {
            return this.updateUrl;
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @NotNull
        public final String component2() {
            return this.className;
        }

        @NotNull
        public final String component3() {
            return this.name;
        }

        @NotNull
        public final String component4() {
            return this.version;
        }

        @NotNull
        public final String component5() {
            return this.type;
        }

        @Nullable
        public final String component6() {
            return this.description;
        }

        @Nullable
        public final String component7() {
            return this.author;
        }

        @Nullable
        public final String component8() {
            return this.authorUrl;
        }

        @Nullable
        public final String component9() {
            return this.repoUrl;
        }

        @Nullable
        public final String component10() {
            return this.updateUrl;
        }

        @NotNull
        public final ExtensionManifest copy(@NotNull String id2, @NotNull String className, @NotNull String name, @NotNull String version, @NotNull String type, @Nullable String description, @Nullable String author, @Nullable String authorUrl, @Nullable String repoUrl, @Nullable String updateUrl) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)className, (String)"className");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)version, (String)"version");
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            return new ExtensionManifest(id2, className, name, version, type, description, author, authorUrl, repoUrl, updateUrl);
        }

        public static /* synthetic */ ExtensionManifest copy$default(ExtensionManifest extensionManifest, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = extensionManifest.id;
            }
            if ((n & 2) != 0) {
                string3 = extensionManifest.className;
            }
            if ((n & 4) != 0) {
                string4 = extensionManifest.name;
            }
            if ((n & 8) != 0) {
                string5 = extensionManifest.version;
            }
            if ((n & 0x10) != 0) {
                string6 = extensionManifest.type;
            }
            if ((n & 0x20) != 0) {
                string7 = extensionManifest.description;
            }
            if ((n & 0x40) != 0) {
                string8 = extensionManifest.author;
            }
            if ((n & 0x80) != 0) {
                string9 = extensionManifest.authorUrl;
            }
            if ((n & 0x100) != 0) {
                string10 = extensionManifest.repoUrl;
            }
            if ((n & 0x200) != 0) {
                string11 = extensionManifest.updateUrl;
            }
            return extensionManifest.copy(string2, string3, string4, string5, string6, string7, string8, string9, string10, string11);
        }

        @NotNull
        public String toString() {
            return "ExtensionManifest(id=" + this.id + ", className=" + this.className + ", name=" + this.name + ", version=" + this.version + ", type=" + this.type + ", description=" + this.description + ", author=" + this.author + ", authorUrl=" + this.authorUrl + ", repoUrl=" + this.repoUrl + ", updateUrl=" + this.updateUrl + ")";
        }

        public int hashCode() {
            int result2 = this.id.hashCode();
            result2 = result2 * 31 + this.className.hashCode();
            result2 = result2 * 31 + this.name.hashCode();
            result2 = result2 * 31 + this.version.hashCode();
            result2 = result2 * 31 + this.type.hashCode();
            result2 = result2 * 31 + (this.description == null ? 0 : this.description.hashCode());
            result2 = result2 * 31 + (this.author == null ? 0 : this.author.hashCode());
            result2 = result2 * 31 + (this.authorUrl == null ? 0 : this.authorUrl.hashCode());
            result2 = result2 * 31 + (this.repoUrl == null ? 0 : this.repoUrl.hashCode());
            result2 = result2 * 31 + (this.updateUrl == null ? 0 : this.updateUrl.hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExtensionManifest)) {
                return false;
            }
            ExtensionManifest extensionManifest = (ExtensionManifest)other;
            if (!Intrinsics.areEqual((Object)this.id, (Object)extensionManifest.id)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.className, (Object)extensionManifest.className)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.name, (Object)extensionManifest.name)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.version, (Object)extensionManifest.version)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.type, (Object)extensionManifest.type)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.description, (Object)extensionManifest.description)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.author, (Object)extensionManifest.author)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.authorUrl, (Object)extensionManifest.authorUrl)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.repoUrl, (Object)extensionManifest.repoUrl)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.updateUrl, (Object)extensionManifest.updateUrl);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core(ExtensionManifest self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.className);
            output.encodeStringElement(serialDesc, 2, self.name);
            output.encodeStringElement(serialDesc, 3, self.version);
            output.encodeStringElement(serialDesc, 4, self.type);
            if (output.shouldEncodeElementDefault(serialDesc, 5) ? true : self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.description);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) ? true : self.author != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.author);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.authorUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.authorUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.repoUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.repoUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.updateUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.updateUrl);
            }
        }

        public /* synthetic */ ExtensionManifest(int seen0, String id2, String className, String name, String version, String type, String description, String author, String authorUrl, String repoUrl, String updateUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (0x1F & seen0)) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)31, (SerialDescriptor)ExtensionManifest$$serializer.INSTANCE.getDescriptor());
            }
            this.id = id2;
            this.className = className;
            this.name = name;
            this.version = version;
            this.type = type;
            this.description = (seen0 & 0x20) == 0 ? null : description;
            this.author = (seen0 & 0x40) == 0 ? null : author;
            this.authorUrl = (seen0 & 0x80) == 0 ? null : authorUrl;
            this.repoUrl = (seen0 & 0x100) == 0 ? null : repoUrl;
            this.updateUrl = (seen0 & 0x200) == 0 ? null : updateUrl;
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$ExtensionManifest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/core/extensions/JarExtensionRepository$ExtensionManifest;", "core"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final KSerializer<ExtensionManifest> serializer() {
                return (KSerializer)ExtensionManifest$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }
}

