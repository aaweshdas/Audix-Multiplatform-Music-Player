/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.test;

import dev.brahmkshatriya.echo.common.clients.TrackerMarkClient;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.ImportType;
import dev.brahmkshatriya.echo.common.models.Metadata;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.TrackDetails;
import dev.brahmkshatriya.echo.common.settings.Setting;
import dev.brahmkshatriya.echo.common.settings.Settings;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ \u0010\u0013\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/TrackerTestExtension;", "Ldev/brahmkshatriya/echo/common/clients/TrackerMarkClient;", "<init>", "()V", "getSettingItems", "", "Ldev/brahmkshatriya/echo/common/settings/Setting;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSettings", "", "settings", "Ldev/brahmkshatriya/echo/common/settings/Settings;", "onTrackChanged", "details", "Ldev/brahmkshatriya/echo/common/models/TrackDetails;", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMarkAsPlayedDuration", "", "onMarkAsPlayed", "onPlayingStateChanged", "isPlaying", "", "(Ldev/brahmkshatriya/echo/common/models/TrackDetails;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class TrackerTestExtension
implements TrackerMarkClient {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Metadata metadata = new Metadata("TrackerTestExtension", "", ImportType.BuiltIn, ExtensionType.TRACKER, "test", "Tracker Test Extension", "1.0.0", "Test extension for offline testing", "Test", null, null, null, null, null, false, 32256, null);

    @Override
    @Nullable
    public Object getSettingItems(@NotNull Continuation<? super List<? extends Setting>> $completion) {
        return CollectionsKt.emptyList();
    }

    @Override
    public void setSettings(@NotNull Settings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
    }

    @Override
    @Nullable
    public Object onTrackChanged(@Nullable TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        Object object = details;
        System.out.println((Object)("onTrackChanged " + (object != null && (object = ((TrackDetails)object).getTrack()) != null ? ((Track)object).getId() : null)));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object getMarkAsPlayedDuration(@NotNull TrackDetails details, @NotNull Continuation<? super Long> $completion) {
        Long l = details.getTotalDuration();
        return l != null ? Boxing.boxLong((long)(l / (long)3)) : null;
    }

    @Override
    @Nullable
    public Object onMarkAsPlayed(@NotNull TrackDetails details, @NotNull Continuation<? super Unit> $completion) {
        System.out.println((Object)("onMarkAsPlayed: " + details.getTrack().getId()));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onPlayingStateChanged(@Nullable TrackDetails details, boolean isPlaying2, @NotNull Continuation<? super Unit> $completion) {
        Object object = details;
        System.out.println((Object)("onPlayingStateChanged " + isPlaying2 + ": " + (object != null && (object = ((TrackDetails)object).getTrack()) != null ? ((Track)object).getId() : null)));
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object onExtensionSelected(@NotNull Continuation<? super Unit> $completion) {
        return TrackerMarkClient.super.onExtensionSelected($completion);
    }

    @Override
    @Nullable
    public Object onInitialize(@NotNull Continuation<? super Unit> $completion) {
        return TrackerMarkClient.super.onInitialize($completion);
    }

    @kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/test/TrackerTestExtension$Companion;", "", "<init>", "()V", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Metadata getMetadata() {
            return metadata;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

