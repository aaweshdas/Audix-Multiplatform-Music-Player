/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/common/models/Message;", "", "message", "", "action", "Ldev/brahmkshatriya/echo/common/models/Message$Action;", "<init>", "(Ljava/lang/String;Ldev/brahmkshatriya/echo/common/models/Message$Action;)V", "getMessage", "()Ljava/lang/String;", "getAction", "()Ldev/brahmkshatriya/echo/common/models/Message$Action;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Action", "common"})
public final class Message {
    @NotNull
    private final String message;
    @Nullable
    private final Action action;

    public Message(@NotNull String message2, @Nullable Action action) {
        Intrinsics.checkNotNullParameter((Object)message2, (String)"message");
        this.message = message2;
        this.action = action;
    }

    public /* synthetic */ Message(String string2, Action action, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            action = null;
        }
        this(string2, action);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final Action component2() {
        return this.action;
    }

    @NotNull
    public final Message copy(@NotNull String message2, @Nullable Action action) {
        Intrinsics.checkNotNullParameter((Object)message2, (String)"message");
        return new Message(message2, action);
    }

    public static /* synthetic */ Message copy$default(Message message2, String string2, Action action, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = message2.message;
        }
        if ((n & 2) != 0) {
            action = message2.action;
        }
        return message2.copy(string2, action);
    }

    @NotNull
    public String toString() {
        return "Message(message=" + this.message + ", action=" + this.action + ")";
    }

    public int hashCode() {
        int result2 = this.message.hashCode();
        result2 = result2 * 31 + (this.action == null ? 0 : this.action.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message message2 = (Message)other;
        if (!Intrinsics.areEqual((Object)this.message, (Object)message2.message)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.action, (Object)message2.action);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/common/models/Message$Action;", "", "name", "", "handler", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getName", "()Ljava/lang/String;", "getHandler", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common"})
    public static final class Action {
        @NotNull
        private final String name;
        @NotNull
        private final Function0<Unit> handler;

        public Action(@NotNull String name, @NotNull Function0<Unit> handler2) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter(handler2, (String)"handler");
            this.name = name;
            this.handler = handler2;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final Function0<Unit> getHandler() {
            return this.handler;
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @NotNull
        public final Function0<Unit> component2() {
            return this.handler;
        }

        @NotNull
        public final Action copy(@NotNull String name, @NotNull Function0<Unit> handler2) {
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter(handler2, (String)"handler");
            return new Action(name, handler2);
        }

        public static /* synthetic */ Action copy$default(Action action, String string2, Function0 function0, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = action.name;
            }
            if ((n & 2) != 0) {
                function0 = action.handler;
            }
            return action.copy(string2, function0);
        }

        @NotNull
        public String toString() {
            return "Action(name=" + this.name + ", handler=" + this.handler + ")";
        }

        public int hashCode() {
            int result2 = this.name.hashCode();
            result2 = result2 * 31 + this.handler.hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Action)) {
                return false;
            }
            Action action = (Action)other;
            if (!Intrinsics.areEqual((Object)this.name, (Object)action.name)) {
                return false;
            }
            return Intrinsics.areEqual(this.handler, action.handler);
        }
    }
}

