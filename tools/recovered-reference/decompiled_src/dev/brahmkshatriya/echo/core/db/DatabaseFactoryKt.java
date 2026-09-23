/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.db.SqlDriver
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.db;

import app.cash.sqldelight.db.SqlDriver;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2={"createEchoDatabase", "Ldev/brahmkshatriya/echo/core/db/EchoDatabase;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "core"})
public final class DatabaseFactoryKt {
    @NotNull
    public static final EchoDatabase createEchoDatabase(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        return EchoDatabase.Companion.invoke(driver);
    }
}

