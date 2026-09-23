/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.test.AssertionsKt
 *  kotlinx.coroutines.BuildersKt
 *  kotlinx.coroutines.CoroutineScope
 *  org.jetbrains.annotations.NotNull
 *  org.junit.Test
 */
package dev.brahmkshatriya.echo.core;

import dev.brahmkshatriya.echo.common.helpers.Page;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Shelf;
import dev.brahmkshatriya.echo.core.extensions.builtin.SpotifyExtension;
import dev.brahmkshatriya.echo.core.platform.DesktopAppPlatform;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.test.AssertionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\t\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/core/SpotifyExtensionTest;", "", "<init>", "()V", "platform", "Ldev/brahmkshatriya/echo/core/platform/DesktopAppPlatform;", "testMetadata", "", "testHomeFeed", "testSearchFeed", "core_test"})
public final class SpotifyExtensionTest {
    @NotNull
    private final DesktopAppPlatform platform = new DesktopAppPlatform();

    @Test
    public final void testMetadata() {
        AssertionsKt.assertEquals$default((Object)"spotify", (Object)"spotify", null, (int)4, null);
        AssertionsKt.assertEquals$default((Object)"Spotify", (Object)SpotifyExtension.Companion.getMETADATA().getName(), null, (int)4, null);
        AssertionsKt.assertTrue$default((boolean)SpotifyExtension.Companion.getMETADATA().isEnabled(), null, (int)2, null);
    }

    @Test
    public final void testHomeFeed() {
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ SpotifyExtensionTest this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var8_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        extension = new SpotifyExtension(SpotifyExtensionTest.access$getPlatform$p(this.this$0), null, 2, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.label = 1;
                        v0 = extension.loadHomeFeed((Continuation<? super Feed<Shelf>>)((Continuation)this));
                        if (v0 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl16:
                        // 2 sources

                        feed = (Feed)v0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.label = 2;
                        v1 = feed.getGetPagedData().invoke(null, (Object)this);
                        if (v1 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl29
                    }
                    case 2: {
                        feed = (Feed)this.L$1;
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl29:
                        // 2 sources

                        data = (Feed.Data)v1;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)data);
                        this.label = 3;
                        v2 = data.getPagedData().loadPage(null, (Continuation)this);
                        if (v2 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl44
                    }
                    case 3: {
                        data = (Feed.Data)this.L$2;
                        feed = (Feed)this.L$1;
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl44:
                        // 2 sources

                        AssertionsKt.assertTrue((boolean)(((Collection)(page = (Page)v2).getData()).isEmpty() == false), (String)"Home feed shelves should not be empty");
                        System.out.println((Object)("Loaded " + page.getData().size() + " shelves from Spotify Home Feed:"));
                        for (Shelf shelf : page.getData()) {
                            System.out.println((Object)(" - Shelf: " + shelf.getTitle() + " (" + shelf.getId() + ")"));
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
        }), (int)1, null);
    }

    @Test
    public final void testSearchFeed() {
        BuildersKt.runBlocking$default(null, (Function2)((Function2)new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, null){
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ SpotifyExtensionTest this$0;
            {
                this.this$0 = $receiver;
                super(2, $completion);
            }

            /*
             * Unable to fully structure code
             */
            public final Object invokeSuspend(Object $result) {
                var8_2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        extension = new SpotifyExtension(SpotifyExtensionTest.access$getPlatform$p(this.this$0), null, 2, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.label = 1;
                        v0 = extension.loadSearchFeed("Eminem", (Continuation<? super Feed<Shelf>>)((Continuation)this));
                        if (v0 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl16
                    }
                    case 1: {
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl16:
                        // 2 sources

                        feed = (Feed)v0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.label = 2;
                        v1 = feed.getGetPagedData().invoke(null, (Object)this);
                        if (v1 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl29
                    }
                    case 2: {
                        feed = (Feed)this.L$1;
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl29:
                        // 2 sources

                        data = (Feed.Data)v1;
                        this.L$0 = SpillingKt.nullOutSpilledVariable((Object)extension);
                        this.L$1 = SpillingKt.nullOutSpilledVariable((Object)feed);
                        this.L$2 = SpillingKt.nullOutSpilledVariable((Object)data);
                        this.label = 3;
                        v2 = data.getPagedData().loadPage(null, (Continuation)this);
                        if (v2 == var8_2) {
                            return var8_2;
                        }
                        ** GOTO lbl44
                    }
                    case 3: {
                        data = (Feed.Data)this.L$2;
                        feed = (Feed)this.L$1;
                        extension = (SpotifyExtension)this.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v2 = $result;
lbl44:
                        // 2 sources

                        AssertionsKt.assertTrue((boolean)(((Collection)(page = (Page)v2).getData()).isEmpty() == false), (String)"Search feed shelves should not be empty");
                        System.out.println((Object)("Loaded " + page.getData().size() + " shelves from Spotify Search Feed:"));
                        for (Shelf shelf : page.getData()) {
                            System.out.println((Object)(" - Shelf: " + shelf.getTitle() + " (" + shelf.getId() + ")"));
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
        }), (int)1, null);
    }

    public static final /* synthetic */ DesktopAppPlatform access$getPlatform$p(SpotifyExtensionTest $this) {
        return $this.platform;
    }
}

