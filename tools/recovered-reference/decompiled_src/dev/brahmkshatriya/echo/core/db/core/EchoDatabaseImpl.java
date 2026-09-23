/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.AfterVersion
 *  app.cash.sqldelight.db.QueryResult
 *  app.cash.sqldelight.db.QueryResult$Value
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlDriver$DefaultImpls
 *  app.cash.sqldelight.db.SqlSchema
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.db.core;

import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import dev.brahmkshatriya.echo.core.db.DownloadsQueries;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import dev.brahmkshatriya.echo.core.db.ExtensionsQueries;
import dev.brahmkshatriya.echo.core.db.UsersQueries;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2={"Ldev/brahmkshatriya/echo/core/db/core/EchoDatabaseImpl;", "Lapp/cash/sqldelight/TransacterImpl;", "Ldev/brahmkshatriya/echo/core/db/EchoDatabase;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "downloadsQueries", "Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;", "getDownloadsQueries", "()Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;", "extensionsQueries", "Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;", "getExtensionsQueries", "()Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;", "usersQueries", "Ldev/brahmkshatriya/echo/core/db/UsersQueries;", "getUsersQueries", "()Ldev/brahmkshatriya/echo/core/db/UsersQueries;", "Schema", "core"})
final class EchoDatabaseImpl
extends TransacterImpl
implements EchoDatabase {
    @NotNull
    private final DownloadsQueries downloadsQueries;
    @NotNull
    private final ExtensionsQueries extensionsQueries;
    @NotNull
    private final UsersQueries usersQueries;

    public EchoDatabaseImpl(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
        this.downloadsQueries = new DownloadsQueries(driver);
        this.extensionsQueries = new ExtensionsQueries(driver);
        this.usersQueries = new UsersQueries(driver);
    }

    @Override
    @NotNull
    public DownloadsQueries getDownloadsQueries() {
        return this.downloadsQueries;
    }

    @Override
    @NotNull
    public ExtensionsQueries getExtensionsQueries() {
        return this.extensionsQueries;
    }

    @Override
    @NotNull
    public UsersQueries getUsersQueries() {
        return this.usersQueries;
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJA\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2={"Ldev/brahmkshatriya/echo/core/db/core/EchoDatabaseImpl$Schema;", "Lapp/cash/sqldelight/db/SqlSchema;", "Lapp/cash/sqldelight/db/QueryResult$Value;", "", "<init>", "()V", "version", "", "getVersion", "()J", "create", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "create-0iQ1-z0", "(Lapp/cash/sqldelight/db/SqlDriver;)Ljava/lang/Object;", "migrate", "oldVersion", "newVersion", "callbacks", "", "Lapp/cash/sqldelight/db/AfterVersion;", "migrate-zeHU3Mk", "(Lapp/cash/sqldelight/db/SqlDriver;JJ[Lapp/cash/sqldelight/db/AfterVersion;)Ljava/lang/Object;", "core"})
    public static final class Schema
    implements SqlSchema<QueryResult.Value<Unit>> {
        @NotNull
        public static final Schema INSTANCE = new Schema();

        private Schema() {
        }

        public long getVersion() {
            return 1L;
        }

        @NotNull
        public Object create-0iQ1-z0(@NotNull SqlDriver driver) {
            Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
            SqlDriver.DefaultImpls.execute$default((SqlDriver)driver, null, (String)"CREATE TABLE IF NOT EXISTS downloads (\n    id TEXT PRIMARY KEY,\n    track_id TEXT NOT NULL,\n    extension_id TEXT NOT NULL,\n    status TEXT NOT NULL DEFAULT 'PENDING',\n    progress REAL NOT NULL DEFAULT 0.0,\n    file_path TEXT,\n    created_at INTEGER NOT NULL,\n    track_json TEXT NOT NULL,\n    context_json TEXT NOT NULL DEFAULT '{}'\n)", (int)0, null, (int)8, null);
            SqlDriver.DefaultImpls.execute$default((SqlDriver)driver, null, (String)"CREATE TABLE IF NOT EXISTS extensions (\n    id TEXT NOT NULL,\n    type TEXT NOT NULL,\n    name TEXT NOT NULL,\n    version TEXT NOT NULL,\n    description TEXT,\n    author TEXT,\n    icon_url TEXT,\n    enabled INTEGER NOT NULL DEFAULT 1,\n    path TEXT NOT NULL,\n    import_type TEXT NOT NULL DEFAULT 'local',\n    PRIMARY KEY (id, type)\n)", (int)0, null, (int)8, null);
            SqlDriver.DefaultImpls.execute$default((SqlDriver)driver, null, (String)"CREATE TABLE IF NOT EXISTS users (\n    id TEXT NOT NULL,\n    extension_id TEXT NOT NULL,\n    extension_type TEXT NOT NULL,\n    name TEXT NOT NULL,\n    cover TEXT,\n    subtitle TEXT,\n    extras TEXT NOT NULL DEFAULT '{}',\n    is_current INTEGER NOT NULL DEFAULT 0,\n    PRIMARY KEY (id, extension_id, extension_type)\n)", (int)0, null, (int)8, null);
            return QueryResult.Companion.getUnit-mlR-ZEE();
        }

        @NotNull
        public Object migrate-zeHU3Mk(@NotNull SqlDriver driver, long oldVersion, long newVersion, AfterVersion ... callbacks) {
            Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
            Intrinsics.checkNotNullParameter((Object)callbacks, (String)"callbacks");
            return QueryResult.Companion.getUnit-mlR-ZEE();
        }
    }
}

