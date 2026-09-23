/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0003\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ClientException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "LoginRequired", "Unauthorized", "NotSupported", "Ldev/brahmkshatriya/echo/common/helpers/ClientException$LoginRequired;", "Ldev/brahmkshatriya/echo/common/helpers/ClientException$NotSupported;", "common"})
public abstract sealed class ClientException
extends Exception {
    private ClientException() {
    }

    public /* synthetic */ ClientException(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ClientException$LoginRequired;", "Ldev/brahmkshatriya/echo/common/helpers/ClientException;", "<init>", "()V", "common"})
    public static non-sealed class LoginRequired
    extends ClientException {
        public LoginRequired() {
            super((DefaultConstructorMarker)null);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ClientException$NotSupported;", "Ldev/brahmkshatriya/echo/common/helpers/ClientException;", "operation", "", "<init>", "(Ljava/lang/String;)V", "getOperation", "()Ljava/lang/String;", "common"})
    public static final class NotSupported
    extends ClientException {
        @NotNull
        private final String operation;

        public NotSupported(@NotNull String operation) {
            Intrinsics.checkNotNullParameter((Object)operation, (String)"operation");
            super((DefaultConstructorMarker)null);
            this.operation = operation;
        }

        @NotNull
        public final String getOperation() {
            return this.operation;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/common/helpers/ClientException$Unauthorized;", "Ldev/brahmkshatriya/echo/common/helpers/ClientException$LoginRequired;", "userId", "", "<init>", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "common"})
    public static final class Unauthorized
    extends LoginRequired {
        @NotNull
        private final String userId;

        public Unauthorized(@NotNull String userId) {
            Intrinsics.checkNotNullParameter((Object)userId, (String)"userId");
            this.userId = userId;
        }

        @NotNull
        public final String getUserId() {
            return this.userId;
        }
    }
}

