/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.desktop.viewmodel;

import androidx.compose.runtime.internal.StabilityInferred;
import dev.brahmkshatriya.echo.common.models.Lyrics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b\u00a8\u0006\f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "", "Initial", "Loading", "Timed", "Simple", "Empty", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Empty;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Initial;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Loading;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Simple;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Timed;", "desktopApp"})
public sealed interface LyricsUiState {

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Empty;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "desktopApp"})
    @StabilityInferred(parameters=1)
    public static final class Empty
    implements LyricsUiState {
        @NotNull
        private final String message;
        public static final int $stable;

        public Empty(@NotNull String message2) {
            Intrinsics.checkNotNullParameter((Object)message2, (String)"message");
            this.message = message2;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String component1() {
            return this.message;
        }

        @NotNull
        public final Empty copy(@NotNull String message2) {
            Intrinsics.checkNotNullParameter((Object)message2, (String)"message");
            return new Empty(message2);
        }

        public static /* synthetic */ Empty copy$default(Empty empty2, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = empty2.message;
            }
            return empty2.copy(string2);
        }

        @NotNull
        public String toString() {
            return "Empty(message=" + this.message + ")";
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Empty)) {
                return false;
            }
            Empty empty2 = (Empty)other;
            return Intrinsics.areEqual((Object)this.message, (Object)empty2.message);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Initial;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "desktopApp"})
    @StabilityInferred(parameters=1)
    public static final class Initial
    implements LyricsUiState {
        @NotNull
        public static final Initial INSTANCE = new Initial();
        public static final int $stable;

        private Initial() {
        }

        @NotNull
        public String toString() {
            return "Initial";
        }

        public int hashCode() {
            return -1253489485;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Initial)) {
                return false;
            }
            Initial cfr_ignored_0 = (Initial)other;
            return true;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c7\n\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\b\u001a\u00020\tH\u00d6\u0001J\t\u0010\n\u001a\u00020\u000bH\u00d6\u0001\u00a8\u0006\f"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Loading;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "desktopApp"})
    @StabilityInferred(parameters=1)
    public static final class Loading
    implements LyricsUiState {
        @NotNull
        public static final Loading INSTANCE = new Loading();
        public static final int $stable;

        private Loading() {
        }

        @NotNull
        public String toString() {
            return "Loading";
        }

        public int hashCode() {
            return 1429786283;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Loading)) {
                return false;
            }
            Loading cfr_ignored_0 = (Loading)other;
            return true;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Simple;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "text", "", "sourceName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getSourceName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "desktopApp"})
    @StabilityInferred(parameters=1)
    public static final class Simple
    implements LyricsUiState {
        @NotNull
        private final String text;
        @NotNull
        private final String sourceName;
        public static final int $stable;

        public Simple(@NotNull String text, @NotNull String sourceName) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            Intrinsics.checkNotNullParameter((Object)sourceName, (String)"sourceName");
            this.text = text;
            this.sourceName = sourceName;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final String component2() {
            return this.sourceName;
        }

        @NotNull
        public final Simple copy(@NotNull String text, @NotNull String sourceName) {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            Intrinsics.checkNotNullParameter((Object)sourceName, (String)"sourceName");
            return new Simple(text, sourceName);
        }

        public static /* synthetic */ Simple copy$default(Simple simple, String string2, String string3, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = simple.text;
            }
            if ((n & 2) != 0) {
                string3 = simple.sourceName;
            }
            return simple.copy(string2, string3);
        }

        @NotNull
        public String toString() {
            return "Simple(text=" + this.text + ", sourceName=" + this.sourceName + ")";
        }

        public int hashCode() {
            int result2 = this.text.hashCode();
            result2 = result2 * 31 + this.sourceName.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Simple)) {
                return false;
            }
            Simple simple = (Simple)other;
            if (!Intrinsics.areEqual((Object)this.text, (Object)simple.text)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.sourceName, (Object)simple.sourceName);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState$Timed;", "Ldev/brahmkshatriya/echo/desktop/viewmodel/LyricsUiState;", "items", "", "Ldev/brahmkshatriya/echo/common/models/Lyrics$Item;", "sourceName", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getSourceName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "desktopApp"})
    @StabilityInferred(parameters=0)
    public static final class Timed
    implements LyricsUiState {
        @NotNull
        private final List<Lyrics.Item> items;
        @NotNull
        private final String sourceName;
        public static final int $stable = 8;

        public Timed(@NotNull List<Lyrics.Item> items2, @NotNull String sourceName) {
            Intrinsics.checkNotNullParameter(items2, (String)"items");
            Intrinsics.checkNotNullParameter((Object)sourceName, (String)"sourceName");
            this.items = items2;
            this.sourceName = sourceName;
        }

        @NotNull
        public final List<Lyrics.Item> getItems() {
            return this.items;
        }

        @NotNull
        public final String getSourceName() {
            return this.sourceName;
        }

        @NotNull
        public final List<Lyrics.Item> component1() {
            return this.items;
        }

        @NotNull
        public final String component2() {
            return this.sourceName;
        }

        @NotNull
        public final Timed copy(@NotNull List<Lyrics.Item> items2, @NotNull String sourceName) {
            Intrinsics.checkNotNullParameter(items2, (String)"items");
            Intrinsics.checkNotNullParameter((Object)sourceName, (String)"sourceName");
            return new Timed(items2, sourceName);
        }

        public static /* synthetic */ Timed copy$default(Timed timed, List list2, String string2, int n, Object object) {
            if ((n & 1) != 0) {
                list2 = timed.items;
            }
            if ((n & 2) != 0) {
                string2 = timed.sourceName;
            }
            return timed.copy(list2, string2);
        }

        @NotNull
        public String toString() {
            return "Timed(items=" + this.items + ", sourceName=" + this.sourceName + ")";
        }

        public int hashCode() {
            int result2 = ((Object)this.items).hashCode();
            result2 = result2 * 31 + this.sourceName.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Timed)) {
                return false;
            }
            Timed timed = (Timed)other;
            if (!Intrinsics.areEqual(this.items, timed.items)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.sourceName, (Object)timed.sourceName);
        }
    }
}

