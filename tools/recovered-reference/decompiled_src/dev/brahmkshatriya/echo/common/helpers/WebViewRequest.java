/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.text.Regex
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.helpers;

import dev.brahmkshatriya.echo.common.models.NetworkRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0013\u0014\u0015R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0001\u0003\u0016\u0017\u0018\u00a8\u0006\u0019\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "T", "", "initialUrl", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "getInitialUrl", "()Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "stopUrlRegex", "Lkotlin/text/Regex;", "getStopUrlRegex", "()Lkotlin/text/Regex;", "maxTimeout", "", "getMaxTimeout", "()J", "dontCache", "", "getDontCache", "()Z", "Headers", "Cookie", "Evaluate", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Cookie;", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Evaluate;", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Headers;", "common"})
public sealed interface WebViewRequest<T> {
    @NotNull
    public NetworkRequest getInitialUrl();

    @NotNull
    public Regex getStopUrlRegex();

    default public long getMaxTimeout() {
        return 15000L;
    }

    default public boolean getDontCache() {
        return false;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J \u0010\u0003\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Cookie;", "T", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "onStop", "url", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "cookie", "", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    public static interface Cookie<T>
    extends WebViewRequest<T> {
        @Nullable
        public Object onStop(@NotNull NetworkRequest var1, @NotNull String var2, @NotNull Continuation<? super T> var3);

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Deprecated
            public static <T> long getMaxTimeout(@NotNull Cookie<T> $this) {
                return ((Cookie)$this).getMaxTimeout();
            }

            @Deprecated
            public static <T> boolean getDontCache(@NotNull Cookie<T> $this) {
                return ((Cookie)$this).getDontCache();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> long getMaxTimeout(@NotNull WebViewRequest<T> $this) {
            return ((WebViewRequest)$this).getMaxTimeout();
        }

        @Deprecated
        public static <T> boolean getDontCache(@NotNull WebViewRequest<T> $this) {
            return ((WebViewRequest)$this).getDontCache();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\"\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u00a6@\u00a2\u0006\u0002\u0010\rR\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000e\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Evaluate;", "T", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "javascriptToEvaluate", "", "getJavascriptToEvaluate", "()Ljava/lang/String;", "javascriptToEvaluateOnPageStart", "getJavascriptToEvaluateOnPageStart", "onStop", "url", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "data", "(Ldev/brahmkshatriya/echo/common/models/NetworkRequest;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    public static interface Evaluate<T>
    extends WebViewRequest<T> {
        @NotNull
        public String getJavascriptToEvaluate();

        @Nullable
        public String getJavascriptToEvaluateOnPageStart();

        @Nullable
        public Object onStop(@NotNull NetworkRequest var1, @Nullable String var2, @NotNull Continuation<? super T> var3);

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Deprecated
            public static <T> long getMaxTimeout(@NotNull Evaluate<T> $this) {
                return ((Evaluate)$this).getMaxTimeout();
            }

            @Deprecated
            public static <T> boolean getDontCache(@NotNull Evaluate<T> $this) {
                return ((Evaluate)$this).getDontCache();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00a6@\u00a2\u0006\u0002\u0010\u000bR\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest$Headers;", "T", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "interceptUrlRegex", "Lkotlin/text/Regex;", "getInterceptUrlRegex", "()Lkotlin/text/Regex;", "onStop", "requests", "", "Ldev/brahmkshatriya/echo/common/models/NetworkRequest;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    public static interface Headers<T>
    extends WebViewRequest<T> {
        @NotNull
        public Regex getInterceptUrlRegex();

        @Nullable
        public Object onStop(@NotNull List<NetworkRequest> var1, @NotNull Continuation<? super T> var2);

        @Metadata(mv={2, 2, 0}, k=3, xi=48)
        public static final class DefaultImpls {
            @Deprecated
            public static <T> long getMaxTimeout(@NotNull Headers<T> $this) {
                return ((Headers)$this).getMaxTimeout();
            }

            @Deprecated
            public static <T> boolean getDontCache(@NotNull Headers<T> $this) {
                return ((Headers)$this).getDontCache();
            }
        }
    }
}

