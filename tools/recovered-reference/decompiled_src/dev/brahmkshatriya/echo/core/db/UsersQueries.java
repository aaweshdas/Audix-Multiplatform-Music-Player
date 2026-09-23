/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.Query
 *  app.cash.sqldelight.Query$Listener
 *  app.cash.sqldelight.QueryKt
 *  app.cash.sqldelight.TransacterImpl
 *  app.cash.sqldelight.db.QueryResult
 *  app.cash.sqldelight.db.SqlCursor
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function8
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.core.db;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.QueryKt;
import app.cash.sqldelight.TransacterImpl;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import dev.brahmkshatriya.echo.core.db.Users;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003&'(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u00e2\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u00b9\u0001\u0010\r\u001a\u00b4\u0001\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000eJ\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u00e2\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u00b9\u0001\u0010\r\u001a\u00b4\u0001\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000eJ\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u00ea\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u00b9\u0001\u0010\r\u001a\u00b4\u0001\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000eJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u00d2\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00b9\u0001\u0010\r\u001a\u00b4\u0001\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000eJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007JP\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0017J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ$\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170\u001e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006)"}, d2={"Ldev/brahmkshatriya/echo/core/db/UsersQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAllForExtension", "Lapp/cash/sqldelight/Query;", "T", "", "extId", "", "extType", "mapper", "Lkotlin/Function8;", "Lkotlin/ParameterName;", "name", "id", "extension_id", "extension_type", "cover", "subtitle", "extras", "", "is_current", "Ldev/brahmkshatriya/echo/core/db/Users;", "getCurrentUser", "getUserById", "getAllCurrentUsers", "upsertUser", "Lapp/cash/sqldelight/db/QueryResult;", "extensionId", "extensionType", "isCurrent", "clearCurrentUser", "setCurrentUser", "deleteUser", "deleteAllForExtension", "SelectAllForExtensionQuery", "GetCurrentUserQuery", "GetUserByIdQuery", "core"})
public final class UsersQueries
extends TransacterImpl {
    public UsersQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAllForExtension(@NotNull String extId, @NotNull String extType, @NotNull Function8<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new SelectAllForExtensionQuery(extId, extType, arg_0 -> UsersQueries.selectAllForExtension$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<Users> selectAllForExtension(@NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        return this.selectAllForExtension(extId, extType, UsersQueries::selectAllForExtension$lambda$1);
    }

    @NotNull
    public final <T> Query<T> getCurrentUser(@NotNull String extId, @NotNull String extType, @NotNull Function8<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new GetCurrentUserQuery(extId, extType, arg_0 -> UsersQueries.getCurrentUser$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<Users> getCurrentUser(@NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        return this.getCurrentUser(extId, extType, UsersQueries::getCurrentUser$lambda$3);
    }

    @NotNull
    public final <T> Query<T> getUserById(@NotNull String id2, @NotNull String extId, @NotNull String extType, @NotNull Function8<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new GetUserByIdQuery(id2, extId, extType, arg_0 -> UsersQueries.getUserById$lambda$4(mapper, arg_0));
    }

    @NotNull
    public final Query<Users> getUserById(@NotNull String id2, @NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        return this.getUserById(id2, extId, extType, UsersQueries::getUserById$lambda$5);
    }

    @NotNull
    public final <T> Query<T> getAllCurrentUsers(@NotNull Function8<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"users"};
        return QueryKt.Query((int)133511123, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Users.sq", (String)"getAllCurrentUsers", (String)"SELECT users.id, users.extension_id, users.extension_type, users.name, users.cover, users.subtitle, users.extras, users.is_current FROM users WHERE is_current = 1", arg_0 -> UsersQueries.getAllCurrentUsers$lambda$6(mapper, arg_0));
    }

    @NotNull
    public final Query<Users> getAllCurrentUsers() {
        return this.getAllCurrentUsers(UsersQueries::getAllCurrentUsers$lambda$7);
    }

    @NotNull
    public final QueryResult<Long> upsertUser(@NotNull String id2, @NotNull String extensionId, @NotNull String extensionType, @NotNull String name, @Nullable String cover, @Nullable String subtitle2, @NotNull String extras, long isCurrent) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)extensionType, (String)"extensionType");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(934260819), "INSERT OR REPLACE INTO users\nVALUES (?, ?, ?, ?, ?, ?, ?, ?)", 8, arg_0 -> UsersQueries.upsertUser$lambda$8(id2, extensionId, extensionType, name, cover, subtitle2, extras, isCurrent, arg_0));
        this.notifyQueries(934260819, UsersQueries::upsertUser$lambda$9);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> clearCurrentUser(@NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(1578524752), "UPDATE users SET is_current = 0\nWHERE extension_id = ? AND extension_type = ?", 2, arg_0 -> UsersQueries.clearCurrentUser$lambda$10(extId, extType, arg_0));
        this.notifyQueries(1578524752, UsersQueries::clearCurrentUser$lambda$11);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> setCurrentUser(@NotNull String id2, @NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(1589433691), "UPDATE users SET is_current = 1\nWHERE id = ? AND extension_id = ? AND extension_type = ?", 3, arg_0 -> UsersQueries.setCurrentUser$lambda$12(id2, extId, extType, arg_0));
        this.notifyQueries(1589433691, UsersQueries::setCurrentUser$lambda$13);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteUser(@NotNull String id2, @NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-884179249), "DELETE FROM users WHERE id = ? AND extension_id = ? AND extension_type = ?", 3, arg_0 -> UsersQueries.deleteUser$lambda$14(id2, extId, extType, arg_0));
        this.notifyQueries(-884179249, UsersQueries::deleteUser$lambda$15);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteAllForExtension(@NotNull String extId, @NotNull String extType) {
        Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
        Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-1058895821), "DELETE FROM users WHERE extension_id = ? AND extension_type = ?", 2, arg_0 -> UsersQueries.deleteAllForExtension$lambda$16(extId, extType, arg_0));
        this.notifyQueries(-1058895821, UsersQueries::deleteAllForExtension$lambda$17);
        return result2;
    }

    private static final Object selectAllForExtension$lambda$0(Function8 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        String string6 = cursor.getString(4);
        String string7 = cursor.getString(5);
        String string8 = cursor.getString(6);
        Intrinsics.checkNotNull((Object)string8);
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l);
    }

    private static final Users selectAllForExtension$lambda$1(String id2, String extension_id, String extension_type, String name, String cover, String subtitle2, String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        return new Users(id2, extension_id, extension_type, name, cover, subtitle2, extras, is_current);
    }

    private static final Object getCurrentUser$lambda$2(Function8 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        String string6 = cursor.getString(4);
        String string7 = cursor.getString(5);
        String string8 = cursor.getString(6);
        Intrinsics.checkNotNull((Object)string8);
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l);
    }

    private static final Users getCurrentUser$lambda$3(String id2, String extension_id, String extension_type, String name, String cover, String subtitle2, String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        return new Users(id2, extension_id, extension_type, name, cover, subtitle2, extras, is_current);
    }

    private static final Object getUserById$lambda$4(Function8 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        String string6 = cursor.getString(4);
        String string7 = cursor.getString(5);
        String string8 = cursor.getString(6);
        Intrinsics.checkNotNull((Object)string8);
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l);
    }

    private static final Users getUserById$lambda$5(String id_, String extension_id, String extension_type, String name, String cover, String subtitle2, String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id_, (String)"id_");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        return new Users(id_, extension_id, extension_type, name, cover, subtitle2, extras, is_current);
    }

    private static final Object getAllCurrentUsers$lambda$6(Function8 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        String string6 = cursor.getString(4);
        String string7 = cursor.getString(5);
        String string8 = cursor.getString(6);
        Intrinsics.checkNotNull((Object)string8);
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l);
    }

    private static final Users getAllCurrentUsers$lambda$7(String id2, String extension_id, String extension_type, String name, String cover, String subtitle2, String extras, long is_current) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)extension_type, (String)"extension_type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)extras, (String)"extras");
        return new Users(id2, extension_id, extension_type, name, cover, subtitle2, extras, is_current);
    }

    private static final Unit upsertUser$lambda$8(String $id, String $extensionId, String $extensionType, String $name, String $cover, String $subtitle, String $extras, long $isCurrent, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $extensionId);
        $this$execute.bindString(2, $extensionType);
        $this$execute.bindString(3, $name);
        $this$execute.bindString(4, $cover);
        $this$execute.bindString(5, $subtitle);
        $this$execute.bindString(6, $extras);
        $this$execute.bindLong(7, Long.valueOf($isCurrent));
        return Unit.INSTANCE;
    }

    private static final Unit upsertUser$lambda$9(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"users");
        return Unit.INSTANCE;
    }

    private static final Unit clearCurrentUser$lambda$10(String $extId, String $extType, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $extId);
        $this$execute.bindString(1, $extType);
        return Unit.INSTANCE;
    }

    private static final Unit clearCurrentUser$lambda$11(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"users");
        return Unit.INSTANCE;
    }

    private static final Unit setCurrentUser$lambda$12(String $id, String $extId, String $extType, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $extId);
        $this$execute.bindString(2, $extType);
        return Unit.INSTANCE;
    }

    private static final Unit setCurrentUser$lambda$13(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"users");
        return Unit.INSTANCE;
    }

    private static final Unit deleteUser$lambda$14(String $id, String $extId, String $extType, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $extId);
        $this$execute.bindString(2, $extType);
        return Unit.INSTANCE;
    }

    private static final Unit deleteUser$lambda$15(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"users");
        return Unit.INSTANCE;
    }

    private static final Unit deleteAllForExtension$lambda$16(String $extId, String $extType, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $extId);
        $this$execute.bindString(1, $extType);
        return Unit.INSTANCE;
    }

    private static final Unit deleteAllForExtension$lambda$17(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"users");
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0001\u0010\u00162\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00150\bH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/core/db/UsersQueries$GetCurrentUserQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "extId", "", "extType", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/UsersQueries;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getExtId", "()Ljava/lang/String;", "getExtType", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class GetCurrentUserQuery<T>
    extends Query<T> {
        @NotNull
        private final String extId;
        @NotNull
        private final String extType;

        public GetCurrentUserQuery(@NotNull String extId, @NotNull String extType, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.extId = extId;
            this.extType = extType;
        }

        @NotNull
        public final String getExtId() {
            return this.extId;
        }

        @NotNull
        public final String getExtType() {
            return this.extType;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return UsersQueries.this.getDriver().executeQuery(Integer.valueOf(-933797401), "SELECT users.id, users.extension_id, users.extension_type, users.name, users.cover, users.subtitle, users.extras, users.is_current FROM users\nWHERE extension_id = ? AND extension_type = ? AND is_current = 1\nLIMIT 1", mapper, 2, arg_0 -> GetCurrentUserQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Users.sq:getCurrentUser";
        }

        private static final Unit execute$lambda$0(GetCurrentUserQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.extId);
            $this$executeQuery.bindString(1, this$0.extType);
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u00182\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00170\tH\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u001a"}, d2={"Ldev/brahmkshatriya/echo/core/db/UsersQueries$GetUserByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "extId", "extType", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/UsersQueries;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getId", "()Ljava/lang/String;", "getExtId", "getExtType", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class GetUserByIdQuery<T>
    extends Query<T> {
        @NotNull
        private final String id;
        @NotNull
        private final String extId;
        @NotNull
        private final String extType;

        public GetUserByIdQuery(@NotNull String id2, @NotNull String extId, @NotNull String extType, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.id = id2;
            this.extId = extId;
            this.extType = extType;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getExtId() {
            return this.extId;
        }

        @NotNull
        public final String getExtType() {
            return this.extType;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return UsersQueries.this.getDriver().executeQuery(Integer.valueOf(1302236186), "SELECT users.id, users.extension_id, users.extension_type, users.name, users.cover, users.subtitle, users.extras, users.is_current FROM users WHERE id = ? AND extension_id = ? AND extension_type = ?", mapper, 3, arg_0 -> GetUserByIdQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Users.sq:getUserById";
        }

        private static final Unit execute$lambda$0(GetUserByIdQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.id);
            $this$executeQuery.bindString(1, this$0.extId);
            $this$executeQuery.bindString(2, this$0.extType);
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0001\u0010\u00162\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00150\bH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/core/db/UsersQueries$SelectAllForExtensionQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "extId", "", "extType", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/UsersQueries;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getExtId", "()Ljava/lang/String;", "getExtType", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class SelectAllForExtensionQuery<T>
    extends Query<T> {
        @NotNull
        private final String extId;
        @NotNull
        private final String extType;

        public SelectAllForExtensionQuery(@NotNull String extId, @NotNull String extType, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)extId, (String)"extId");
            Intrinsics.checkNotNullParameter((Object)extType, (String)"extType");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.extId = extId;
            this.extType = extType;
        }

        @NotNull
        public final String getExtId() {
            return this.extId;
        }

        @NotNull
        public final String getExtType() {
            return this.extType;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"users"};
            UsersQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return UsersQueries.this.getDriver().executeQuery(Integer.valueOf(1511861442), "SELECT users.id, users.extension_id, users.extension_type, users.name, users.cover, users.subtitle, users.extras, users.is_current FROM users WHERE extension_id = ? AND extension_type = ?", mapper, 2, arg_0 -> SelectAllForExtensionQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Users.sq:selectAllForExtension";
        }

        private static final Unit execute$lambda$0(SelectAllForExtensionQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.extId);
            $this$executeQuery.bindString(1, this$0.extType);
            return Unit.INSTANCE;
        }
    }
}

