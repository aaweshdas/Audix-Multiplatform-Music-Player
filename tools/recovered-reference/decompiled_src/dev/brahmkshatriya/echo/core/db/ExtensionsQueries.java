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
 *  app.cash.sqldelight.db.SqlDriver$DefaultImpls
 *  app.cash.sqldelight.db.SqlPreparedStatement
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function10
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
import dev.brahmkshatriya.echo.core.db.Extensions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u00fe\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00e5\u0001\u0010\n\u001a\u00e0\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007J\u00fe\u0001\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00e5\u0001\u0010\n\u001a\u00e0\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007J\u008e\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u00e5\u0001\u0010\n\u001a\u00e0\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\b0\u000bJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007Jb\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fJ$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u001e\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function10;", "", "Lkotlin/ParameterName;", "name", "id", "type", "version", "description", "author", "icon_url", "", "enabled", "path", "import_type", "Ldev/brahmkshatriya/echo/core/db/Extensions;", "selectEnabled", "selectById", "countAll", "upsert", "Lapp/cash/sqldelight/db/QueryResult;", "iconUrl", "importType", "setEnabled", "deleteById", "deleteAll", "SelectByIdQuery", "core"})
public final class ExtensionsQueries
extends TransacterImpl {
    public ExtensionsQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function10<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"extensions"};
        return QueryKt.Query((int)-2114087802, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Extensions.sq", (String)"selectAll", (String)"SELECT extensions.id, extensions.type, extensions.name, extensions.version, extensions.description, extensions.author, extensions.icon_url, extensions.enabled, extensions.path, extensions.import_type FROM extensions", arg_0 -> ExtensionsQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<Extensions> selectAll() {
        return this.selectAll(ExtensionsQueries::selectAll$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectEnabled(@NotNull Function10<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"extensions"};
        return QueryKt.Query((int)1057598374, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Extensions.sq", (String)"selectEnabled", (String)"SELECT extensions.id, extensions.type, extensions.name, extensions.version, extensions.description, extensions.author, extensions.icon_url, extensions.enabled, extensions.path, extensions.import_type FROM extensions WHERE enabled = 1", arg_0 -> ExtensionsQueries.selectEnabled$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<Extensions> selectEnabled() {
        return this.selectEnabled(ExtensionsQueries::selectEnabled$lambda$3);
    }

    @NotNull
    public final <T> Query<T> selectById(@NotNull String id2, @NotNull String type, @NotNull Function10<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new SelectByIdQuery(id2, type, arg_0 -> ExtensionsQueries.selectById$lambda$4(mapper, arg_0));
    }

    @NotNull
    public final Query<Extensions> selectById(@NotNull String id2, @NotNull String type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return this.selectById(id2, type, ExtensionsQueries::selectById$lambda$5);
    }

    @NotNull
    public final Query<Long> countAll() {
        String[] stringArray = new String[]{"extensions"};
        return QueryKt.Query((int)723481713, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Extensions.sq", (String)"countAll", (String)"SELECT COUNT(*) FROM extensions", ExtensionsQueries::countAll$lambda$6);
    }

    @NotNull
    public final QueryResult<Long> upsert(@NotNull String id2, @NotNull String type, @NotNull String name, @NotNull String version, @Nullable String description, @Nullable String author, @Nullable String iconUrl, long enabled, @NotNull String path, @NotNull String importType) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)importType, (String)"importType");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-1883064498), "INSERT OR REPLACE INTO extensions\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 10, arg_0 -> ExtensionsQueries.upsert$lambda$7(id2, type, name, version, description, author, iconUrl, enabled, path, importType, arg_0));
        this.notifyQueries(-1883064498, ExtensionsQueries::upsert$lambda$8);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> setEnabled(long enabled, @NotNull String id2, @NotNull String type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(1908378398), "UPDATE extensions SET enabled = ? WHERE id = ? AND type = ?", 3, arg_0 -> ExtensionsQueries.setEnabled$lambda$9(enabled, id2, type, arg_0));
        this.notifyQueries(1908378398, ExtensionsQueries::setEnabled$lambda$10);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteById(@NotNull String id2, @NotNull String type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-1986593092), "DELETE FROM extensions WHERE id = ? AND type = ?", 2, arg_0 -> ExtensionsQueries.deleteById$lambda$11(id2, type, arg_0));
        this.notifyQueries(-1986593092, ExtensionsQueries::deleteById$lambda$12);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteAll() {
        QueryResult result2 = SqlDriver.DefaultImpls.execute$default((SqlDriver)this.getDriver(), (Integer)-756821641, (String)"DELETE FROM extensions", (int)0, null, (int)8, null);
        this.notifyQueries(-756821641, ExtensionsQueries::deleteAll$lambda$13);
        return result2;
    }

    private static final Object selectAll$lambda$0(Function10 $mapper, SqlCursor cursor) {
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
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        String string9 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string9);
        String string10 = cursor.getString(9);
        Intrinsics.checkNotNull((Object)string10);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l, (Object)string9, (Object)string10);
    }

    private static final Extensions selectAll$lambda$1(String id2, String type, String name, String version, String description, String author, String icon_url, long enabled, String path, String import_type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)import_type, (String)"import_type");
        return new Extensions(id2, type, name, version, description, author, icon_url, enabled, path, import_type);
    }

    private static final Object selectEnabled$lambda$2(Function10 $mapper, SqlCursor cursor) {
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
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        String string9 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string9);
        String string10 = cursor.getString(9);
        Intrinsics.checkNotNull((Object)string10);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l, (Object)string9, (Object)string10);
    }

    private static final Extensions selectEnabled$lambda$3(String id2, String type, String name, String version, String description, String author, String icon_url, long enabled, String path, String import_type) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)import_type, (String)"import_type");
        return new Extensions(id2, type, name, version, description, author, icon_url, enabled, path, import_type);
    }

    private static final Object selectById$lambda$4(Function10 $mapper, SqlCursor cursor) {
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
        Long l = cursor.getLong(7);
        Intrinsics.checkNotNull((Object)l);
        String string9 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string9);
        String string10 = cursor.getString(9);
        Intrinsics.checkNotNull((Object)string10);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)string6, (Object)string7, (Object)string8, (Object)l, (Object)string9, (Object)string10);
    }

    private static final Extensions selectById$lambda$5(String id_, String type_, String name, String version, String description, String author, String icon_url, long enabled, String path, String import_type) {
        Intrinsics.checkNotNullParameter((Object)id_, (String)"id_");
        Intrinsics.checkNotNullParameter((Object)type_, (String)"type_");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)version, (String)"version");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)import_type, (String)"import_type");
        return new Extensions(id_, type_, name, version, description, author, icon_url, enabled, path, import_type);
    }

    private static final long countAll$lambda$6(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Unit upsert$lambda$7(String $id, String $type, String $name, String $version, String $description, String $author, String $iconUrl, long $enabled, String $path, String $importType, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $type);
        $this$execute.bindString(2, $name);
        $this$execute.bindString(3, $version);
        $this$execute.bindString(4, $description);
        $this$execute.bindString(5, $author);
        $this$execute.bindString(6, $iconUrl);
        $this$execute.bindLong(7, Long.valueOf($enabled));
        $this$execute.bindString(8, $path);
        $this$execute.bindString(9, $importType);
        return Unit.INSTANCE;
    }

    private static final Unit upsert$lambda$8(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"extensions");
        return Unit.INSTANCE;
    }

    private static final Unit setEnabled$lambda$9(long $enabled, String $id, String $type, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindLong(0, Long.valueOf($enabled));
        $this$execute.bindString(1, $id);
        $this$execute.bindString(2, $type);
        return Unit.INSTANCE;
    }

    private static final Unit setEnabled$lambda$10(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"extensions");
        return Unit.INSTANCE;
    }

    private static final Unit deleteById$lambda$11(String $id, String $type, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $type);
        return Unit.INSTANCE;
    }

    private static final Unit deleteById$lambda$12(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"extensions");
        return Unit.INSTANCE;
    }

    private static final Unit deleteAll$lambda$13(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"extensions");
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J.\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0015\"\u0004\b\u0001\u0010\u00162\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u00150\bH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries$SelectByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "type", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/ExtensionsQueries;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getId", "()Ljava/lang/String;", "getType", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class SelectByIdQuery<T>
    extends Query<T> {
        @NotNull
        private final String id;
        @NotNull
        private final String type;

        public SelectByIdQuery(@NotNull String id2, @NotNull String type, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.id = id2;
            this.type = type;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"extensions"};
            ExtensionsQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"extensions"};
            ExtensionsQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return ExtensionsQueries.this.getDriver().executeQuery(Integer.valueOf(-1112171123), "SELECT extensions.id, extensions.type, extensions.name, extensions.version, extensions.description, extensions.author, extensions.icon_url, extensions.enabled, extensions.path, extensions.import_type FROM extensions WHERE id = ? AND type = ?", mapper, 2, arg_0 -> SelectByIdQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Extensions.sq:selectById";
        }

        private static final Unit execute$lambda$0(SelectByIdQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.id);
            $this$executeQuery.bindString(1, this$0.type);
            return Unit.INSTANCE;
        }
    }
}

