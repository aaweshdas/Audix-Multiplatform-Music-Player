/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.db.AfterVersion
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
 *  app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteSchemaKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Path
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.db;

import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver;
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteSchemaKt;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import java.io.File;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2={"createDesktopDriver", "Lapp/cash/sqldelight/db/SqlDriver;", "dataDir", "Lokio/Path;", "core"})
public final class DesktopDatabaseDriverKt {
    @NotNull
    public static final SqlDriver createDesktopDriver(@NotNull Path dataDir) {
        Intrinsics.checkNotNullParameter((Object)dataDir, (String)"dataDir");
        File dbFile = Path.resolve$default((Path)dataDir, (String)"echo.db", (boolean)false, (int)2, null).toFile();
        File file2 = dbFile.getParentFile();
        if (file2 != null) {
            file2.mkdirs();
        }
        JdbcSqliteDriver driver = JdbcSqliteSchemaKt.JdbcSqliteDriver$default((String)("jdbc:sqlite:" + dbFile.getAbsolutePath()), (Properties)new Properties(), EchoDatabase.Companion.getSchema(), (boolean)false, (AfterVersion[])new AfterVersion[0], (int)8, null);
        return (SqlDriver)driver;
    }
}

