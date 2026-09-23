/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Transacter
 *  app.cash.sqldelight.db.QueryResult$Value
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlSchema
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.core.db;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlSchema;
import dev.brahmkshatriya.echo.core.db.DownloadsQueries;
import dev.brahmkshatriya.echo.core.db.ExtensionsQueries;
import dev.brahmkshatriya.echo.core.db.UsersQueries;
import dev.brahmkshatriya.echo.core.db.core.EchoDatabaseImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000f\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/core/db/EchoDatabase;", "Lapp/cash/sqldelight/Transacter;", "downloadsQueries", "Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;", "getDownloadsQueries", "()Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;", "extensionsQueries", "Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;", "getExtensionsQueries", "()Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;", "usersQueries", "Ldev/brahmkshatriya/echo/core/db/UsersQueries;", "getUsersQueries", "()Ldev/brahmkshatriya/echo/core/db/UsersQueries;", "Companion", "core"})
public interface EchoDatabase
extends Transacter {
    @NotNull
    public static final Companion Companion = dev.brahmkshatriya.echo.core.db.EchoDatabase$Companion.$$INSTANCE;

    @NotNull
    public DownloadsQueries getDownloadsQueries();

    @NotNull
    public ExtensionsQueries getExtensionsQueries();

    @NotNull
    public UsersQueries getUsersQueries();

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086\u0002R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/core/db/EchoDatabase$Companion;", "", "<init>", "()V", "Schema", "Lapp/cash/sqldelight/db/SqlSchema;", "Lapp/cash/sqldelight/db/QueryResult$Value;", "", "getSchema", "()Lapp/cash/sqldelight/db/SqlSchema;", "invoke", "Ldev/brahmkshatriya/echo/core/db/EchoDatabase;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "core"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        @NotNull
        public final SqlSchema<QueryResult.Value<Unit>> getSchema() {
            return EchoDatabaseImplKt.getSchema((KClass<EchoDatabase>)Reflection.getOrCreateKotlinClass(EchoDatabase.class));
        }

        @NotNull
        public final EchoDatabase invoke(@NotNull SqlDriver driver) {
            Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
            return EchoDatabaseImplKt.newInstance((KClass<EchoDatabase>)Reflection.getOrCreateKotlinClass(EchoDatabase.class), driver);
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

