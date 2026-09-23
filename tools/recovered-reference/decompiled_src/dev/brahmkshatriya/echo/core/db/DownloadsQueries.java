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
 *  kotlin.jvm.functions.Function9
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
import dev.brahmkshatriya.echo.core.db.Downloads;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0003*+,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u00e5\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u00cc\u0001\u0010\n\u001a\u00c7\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\b0\u000bJ\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0007J\u00ed\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\u000f\u001a\u00020\f2\u00cc\u0001\u0010\n\u001a\u00c7\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\b0\u000bJ\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u000f\u001a\u00020\fJ\u00ed\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\u0012\u001a\u00020\f2\u00cc\u0001\u0010\n\u001a\u00c7\u0001\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\b0\u000bJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\u0012\u001a\u00020\fJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0012\u001a\u00020\fJV\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fJ.\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\fJ\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f2\u0006\u0010\u000f\u001a\u00020\fJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u001f\u00a8\u0006-"}, d2={"Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;", "Lapp/cash/sqldelight/TransacterImpl;", "driver", "Lapp/cash/sqldelight/db/SqlDriver;", "<init>", "(Lapp/cash/sqldelight/db/SqlDriver;)V", "selectAll", "Lapp/cash/sqldelight/Query;", "T", "", "mapper", "Lkotlin/Function9;", "", "Lkotlin/ParameterName;", "name", "id", "track_id", "extension_id", "status", "", "progress", "file_path", "", "created_at", "track_json", "context_json", "Ldev/brahmkshatriya/echo/core/db/Downloads;", "selectById", "selectByStatus", "countByStatus", "insert", "Lapp/cash/sqldelight/db/QueryResult;", "trackId", "extensionId", "filePath", "createdAt", "trackJson", "contextJson", "updateStatus", "updateProgress", "deleteById", "deleteCompleted", "SelectByIdQuery", "SelectByStatusQuery", "CountByStatusQuery", "core"})
public final class DownloadsQueries
extends TransacterImpl {
    public DownloadsQueries(@NotNull SqlDriver driver) {
        Intrinsics.checkNotNullParameter((Object)driver, (String)"driver");
        super(driver);
    }

    @NotNull
    public final <T> Query<T> selectAll(@NotNull Function9<? super String, ? super String, ? super String, ? super String, ? super Double, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        String[] stringArray = new String[]{"downloads"};
        return QueryKt.Query((int)369963177, (String[])stringArray, (SqlDriver)this.getDriver(), (String)"Downloads.sq", (String)"selectAll", (String)"SELECT downloads.id, downloads.track_id, downloads.extension_id, downloads.status, downloads.progress, downloads.file_path, downloads.created_at, downloads.track_json, downloads.context_json FROM downloads ORDER BY created_at DESC", arg_0 -> DownloadsQueries.selectAll$lambda$0(mapper, arg_0));
    }

    @NotNull
    public final Query<Downloads> selectAll() {
        return this.selectAll(DownloadsQueries::selectAll$lambda$1);
    }

    @NotNull
    public final <T> Query<T> selectById(@NotNull String id2, @NotNull Function9<? super String, ? super String, ? super String, ? super String, ? super Double, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new SelectByIdQuery(id2, arg_0 -> DownloadsQueries.selectById$lambda$2(mapper, arg_0));
    }

    @NotNull
    public final Query<Downloads> selectById(@NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        return this.selectById(id2, DownloadsQueries::selectById$lambda$3);
    }

    @NotNull
    public final <T> Query<T> selectByStatus(@NotNull String status, @NotNull Function9<? super String, ? super String, ? super String, ? super String, ? super Double, ? super String, ? super Long, ? super String, ? super String, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
        return new SelectByStatusQuery(status, arg_0 -> DownloadsQueries.selectByStatus$lambda$4(mapper, arg_0));
    }

    @NotNull
    public final Query<Downloads> selectByStatus(@NotNull String status) {
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        return this.selectByStatus(status, DownloadsQueries::selectByStatus$lambda$5);
    }

    @NotNull
    public final Query<Long> countByStatus(@NotNull String status) {
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        return new CountByStatusQuery(status, DownloadsQueries::countByStatus$lambda$6);
    }

    @NotNull
    public final QueryResult<Long> insert(@NotNull String id2, @NotNull String trackId, @NotNull String extensionId, @NotNull String status, double progress, @Nullable String filePath, long createdAt, @NotNull String trackJson, @NotNull String contextJson) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)trackJson, (String)"trackJson");
        Intrinsics.checkNotNullParameter((Object)contextJson, (String)"contextJson");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-1088426091), "INSERT INTO downloads\nVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 9, arg_0 -> DownloadsQueries.insert$lambda$7(id2, trackId, extensionId, status, progress, filePath, createdAt, trackJson, contextJson, arg_0));
        this.notifyQueries(-1088426091, DownloadsQueries::insert$lambda$8);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> updateStatus(@NotNull String status, double progress, @Nullable String filePath, @NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(-1771662857), "UPDATE downloads\nSET status = ?, progress = ?, file_path = ?\nWHERE id = ?", 4, arg_0 -> DownloadsQueries.updateStatus$lambda$9(status, progress, filePath, id2, arg_0));
        this.notifyQueries(-1771662857, DownloadsQueries::updateStatus$lambda$10);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> updateProgress(double progress, @NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(214243058), "UPDATE downloads SET progress = ? WHERE id = ?", 2, arg_0 -> DownloadsQueries.updateProgress$lambda$11(progress, id2, arg_0));
        this.notifyQueries(214243058, DownloadsQueries::updateProgress$lambda$12);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteById(@NotNull String id2) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        QueryResult result2 = this.getDriver().execute(Integer.valueOf(2004543225), "DELETE FROM downloads WHERE id = ?", 1, arg_0 -> DownloadsQueries.deleteById$lambda$13(id2, arg_0));
        this.notifyQueries(2004543225, DownloadsQueries::deleteById$lambda$14);
        return result2;
    }

    @NotNull
    public final QueryResult<Long> deleteCompleted() {
        QueryResult result2 = SqlDriver.DefaultImpls.execute$default((SqlDriver)this.getDriver(), (Integer)1488997252, (String)"DELETE FROM downloads WHERE status = 'COMPLETED'", (int)0, null, (int)8, null);
        this.notifyQueries(1488997252, DownloadsQueries::deleteCompleted$lambda$15);
        return result2;
    }

    private static final Object selectAll$lambda$0(Function9 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        Double d = cursor.getDouble(4);
        Intrinsics.checkNotNull((Object)d);
        String string6 = cursor.getString(5);
        Long l = cursor.getLong(6);
        Intrinsics.checkNotNull((Object)l);
        String string7 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string7);
        String string8 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string8);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)d, (Object)string6, (Object)l, (Object)string7, (Object)string8);
    }

    private static final Downloads selectAll$lambda$1(String id2, String track_id, String extension_id, String status, double progress, String file_path, long created_at, String track_json, String context_json) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track_id, (String)"track_id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)track_json, (String)"track_json");
        Intrinsics.checkNotNullParameter((Object)context_json, (String)"context_json");
        return new Downloads(id2, track_id, extension_id, status, progress, file_path, created_at, track_json, context_json);
    }

    private static final Object selectById$lambda$2(Function9 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        Double d = cursor.getDouble(4);
        Intrinsics.checkNotNull((Object)d);
        String string6 = cursor.getString(5);
        Long l = cursor.getLong(6);
        Intrinsics.checkNotNull((Object)l);
        String string7 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string7);
        String string8 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string8);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)d, (Object)string6, (Object)l, (Object)string7, (Object)string8);
    }

    private static final Downloads selectById$lambda$3(String id_, String track_id, String extension_id, String status, double progress, String file_path, long created_at, String track_json, String context_json) {
        Intrinsics.checkNotNullParameter((Object)id_, (String)"id_");
        Intrinsics.checkNotNullParameter((Object)track_id, (String)"track_id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)status, (String)"status");
        Intrinsics.checkNotNullParameter((Object)track_json, (String)"track_json");
        Intrinsics.checkNotNullParameter((Object)context_json, (String)"context_json");
        return new Downloads(id_, track_id, extension_id, status, progress, file_path, created_at, track_json, context_json);
    }

    private static final Object selectByStatus$lambda$4(Function9 $mapper, SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        String string2 = cursor.getString(0);
        Intrinsics.checkNotNull((Object)string2);
        String string3 = cursor.getString(1);
        Intrinsics.checkNotNull((Object)string3);
        String string4 = cursor.getString(2);
        Intrinsics.checkNotNull((Object)string4);
        String string5 = cursor.getString(3);
        Intrinsics.checkNotNull((Object)string5);
        Double d = cursor.getDouble(4);
        Intrinsics.checkNotNull((Object)d);
        String string6 = cursor.getString(5);
        Long l = cursor.getLong(6);
        Intrinsics.checkNotNull((Object)l);
        String string7 = cursor.getString(7);
        Intrinsics.checkNotNull((Object)string7);
        String string8 = cursor.getString(8);
        Intrinsics.checkNotNull((Object)string8);
        return $mapper.invoke((Object)string2, (Object)string3, (Object)string4, (Object)string5, (Object)d, (Object)string6, (Object)l, (Object)string7, (Object)string8);
    }

    private static final Downloads selectByStatus$lambda$5(String id2, String track_id, String extension_id, String status_, double progress, String file_path, long created_at, String track_json, String context_json) {
        Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
        Intrinsics.checkNotNullParameter((Object)track_id, (String)"track_id");
        Intrinsics.checkNotNullParameter((Object)extension_id, (String)"extension_id");
        Intrinsics.checkNotNullParameter((Object)status_, (String)"status_");
        Intrinsics.checkNotNullParameter((Object)track_json, (String)"track_json");
        Intrinsics.checkNotNullParameter((Object)context_json, (String)"context_json");
        return new Downloads(id2, track_id, extension_id, status_, progress, file_path, created_at, track_json, context_json);
    }

    private static final long countByStatus$lambda$6(SqlCursor cursor) {
        Intrinsics.checkNotNullParameter((Object)cursor, (String)"cursor");
        Long l = cursor.getLong(0);
        Intrinsics.checkNotNull((Object)l);
        return l;
    }

    private static final Unit insert$lambda$7(String $id, String $trackId, String $extensionId, String $status, double $progress, String $filePath, long $createdAt, String $trackJson, String $contextJson, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        $this$execute.bindString(1, $trackId);
        $this$execute.bindString(2, $extensionId);
        $this$execute.bindString(3, $status);
        $this$execute.bindDouble(4, Double.valueOf($progress));
        $this$execute.bindString(5, $filePath);
        $this$execute.bindLong(6, Long.valueOf($createdAt));
        $this$execute.bindString(7, $trackJson);
        $this$execute.bindString(8, $contextJson);
        return Unit.INSTANCE;
    }

    private static final Unit insert$lambda$8(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"downloads");
        return Unit.INSTANCE;
    }

    private static final Unit updateStatus$lambda$9(String $status, double $progress, String $filePath, String $id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $status);
        $this$execute.bindDouble(1, Double.valueOf($progress));
        $this$execute.bindString(2, $filePath);
        $this$execute.bindString(3, $id);
        return Unit.INSTANCE;
    }

    private static final Unit updateStatus$lambda$10(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"downloads");
        return Unit.INSTANCE;
    }

    private static final Unit updateProgress$lambda$11(double $progress, String $id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindDouble(0, Double.valueOf($progress));
        $this$execute.bindString(1, $id);
        return Unit.INSTANCE;
    }

    private static final Unit updateProgress$lambda$12(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"downloads");
        return Unit.INSTANCE;
    }

    private static final Unit deleteById$lambda$13(String $id, SqlPreparedStatement $this$execute) {
        Intrinsics.checkNotNullParameter((Object)$this$execute, (String)"$this$execute");
        $this$execute.bindString(0, $id);
        return Unit.INSTANCE;
    }

    private static final Unit deleteById$lambda$14(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"downloads");
        return Unit.INSTANCE;
    }

    private static final Unit deleteCompleted$lambda$15(Function1 emit2) {
        Intrinsics.checkNotNullParameter((Object)emit2, (String)"emit");
        emit2.invoke((Object)"downloads");
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0001\u0010\u00142\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00130\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/core/db/DownloadsQueries$CountByStatusQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "status", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getStatus", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class CountByStatusQuery<T>
    extends Query<T> {
        @NotNull
        private final String status;

        public CountByStatusQuery(@NotNull String status, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)status, (String)"status");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.status = status;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return DownloadsQueries.this.getDriver().executeQuery(Integer.valueOf(595920124), "SELECT COUNT(*) FROM downloads WHERE status = ?", mapper, 1, arg_0 -> CountByStatusQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Downloads.sq:countByStatus";
        }

        private static final Unit execute$lambda$0(CountByStatusQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.status);
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0001\u0010\u00142\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00130\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/core/db/DownloadsQueries$SelectByIdQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "id", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getId", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class SelectByIdQuery<T>
    extends Query<T> {
        @NotNull
        private final String id;

        public SelectByIdQuery(@NotNull String id2, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)id2, (String)"id");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.id = id2;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return DownloadsQueries.this.getDriver().executeQuery(Integer.valueOf(-1416002102), "SELECT downloads.id, downloads.track_id, downloads.extension_id, downloads.status, downloads.progress, downloads.file_path, downloads.created_at, downloads.track_json, downloads.context_json FROM downloads WHERE id = ?", mapper, 1, arg_0 -> SelectByIdQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Downloads.sq:selectById";
        }

        private static final Unit execute$lambda$0(SelectByIdQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.id);
            return Unit.INSTANCE;
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0001\u0010\u00142\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00130\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2={"Ldev/brahmkshatriya/echo/core/db/DownloadsQueries$SelectByStatusQuery;", "T", "", "Lapp/cash/sqldelight/Query;", "status", "", "mapper", "Lkotlin/Function1;", "Lapp/cash/sqldelight/db/SqlCursor;", "<init>", "(Ldev/brahmkshatriya/echo/core/db/DownloadsQueries;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getStatus", "()Ljava/lang/String;", "addListener", "", "listener", "Lapp/cash/sqldelight/Query$Listener;", "removeListener", "execute", "Lapp/cash/sqldelight/db/QueryResult;", "R", "toString", "core"})
    private final class SelectByStatusQuery<T>
    extends Query<T> {
        @NotNull
        private final String status;

        public SelectByStatusQuery(@NotNull String status, Function1<? super SqlCursor, ? extends T> mapper) {
            Intrinsics.checkNotNullParameter((Object)status, (String)"status");
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            super(mapper);
            this.status = status;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        public void addListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().addListener(stringArray, listener2);
        }

        public void removeListener(@NotNull Query.Listener listener2) {
            Intrinsics.checkNotNullParameter((Object)listener2, (String)"listener");
            String[] stringArray = new String[]{"downloads"};
            DownloadsQueries.this.getDriver().removeListener(stringArray, listener2);
        }

        @NotNull
        public <R> QueryResult<R> execute(@NotNull Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
            Intrinsics.checkNotNullParameter(mapper, (String)"mapper");
            return DownloadsQueries.this.getDriver().executeQuery(Integer.valueOf(-1500686047), "SELECT downloads.id, downloads.track_id, downloads.extension_id, downloads.status, downloads.progress, downloads.file_path, downloads.created_at, downloads.track_json, downloads.context_json FROM downloads WHERE status = ? ORDER BY created_at ASC", mapper, 1, arg_0 -> SelectByStatusQuery.execute$lambda$0(this, arg_0));
        }

        @NotNull
        public String toString() {
            return "Downloads.sq:selectByStatus";
        }

        private static final Unit execute$lambda$0(SelectByStatusQuery this$0, SqlPreparedStatement $this$executeQuery) {
            Intrinsics.checkNotNullParameter((Object)$this$executeQuery, (String)"$this$executeQuery");
            $this$executeQuery.bindString(0, this$0.status);
            return Unit.INSTANCE;
        }
    }
}

