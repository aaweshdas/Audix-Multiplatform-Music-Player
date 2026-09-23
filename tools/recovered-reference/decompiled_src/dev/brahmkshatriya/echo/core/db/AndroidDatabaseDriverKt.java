/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.driver.android.AndroidSqliteDriver
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.db;

import android.content.Context;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.android.AndroidSqliteDriver;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2={"createAndroidDriver", "Lapp/cash/sqldelight/db/SqlDriver;", "context", "Landroid/content/Context;", "core"})
public final class AndroidDatabaseDriverKt {
    @NotNull
    public static final SqlDriver createAndroidDriver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return (SqlDriver)new AndroidSqliteDriver(EchoDatabase.Companion.getSchema(), context, "echo.db", null, null, 0, false, null, 248, null);
    }
}

