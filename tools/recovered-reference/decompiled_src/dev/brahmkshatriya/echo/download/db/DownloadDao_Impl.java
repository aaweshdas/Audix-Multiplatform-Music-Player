/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityDeleteOrUpdateAdapter
 *  androidx.room.EntityInsertAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.coroutines.FlowUtil
 *  androidx.room.util.DBUtil
 *  androidx.room.util.SQLiteStatementUtil
 *  androidx.sqlite.SQLiteConnection
 *  androidx.sqlite.SQLiteStatement
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  kotlinx.coroutines.flow.Flow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.db;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import dev.brahmkshatriya.echo.download.db.DownloadDao;
import dev.brahmkshatriya.echo.download.db.models.ContextEntity;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0 0\u001fH\u0016J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 0\u001fH\u0016J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0 2\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDao_Impl;", "Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfContextEntity", "Landroidx/room/EntityInsertAdapter;", "Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "__insertAdapterOfDownloadEntity", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "__deleteAdapterOfDownloadEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfContextEntity", "insertContextEntity", "", "context", "(Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDownloadEntity", "download", "(Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDownloadEntity", "", "deleteContextEntity", "getDownloadEntity", "trackId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContextEntity", "contextId", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getContextFlow", "getDownloadsForContext", "id", "(Ljava/lang/Long;)Ljava/util/List;", "__TaskType_enumToString", "", "_value", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "__TaskType_stringToEnum", "Companion", "app_debug"})
public final class DownloadDao_Impl
implements DownloadDao {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final RoomDatabase __db;
    @NotNull
    private final EntityInsertAdapter<ContextEntity> __insertAdapterOfContextEntity;
    @NotNull
    private final EntityInsertAdapter<DownloadEntity> __insertAdapterOfDownloadEntity;
    @NotNull
    private final EntityDeleteOrUpdateAdapter<DownloadEntity> __deleteAdapterOfDownloadEntity;
    @NotNull
    private final EntityDeleteOrUpdateAdapter<ContextEntity> __deleteAdapterOfContextEntity;

    public DownloadDao_Impl(@NotNull RoomDatabase __db) {
        Intrinsics.checkNotNullParameter((Object)__db, (String)"__db");
        this.__db = __db;
        this.__insertAdapterOfContextEntity = (EntityInsertAdapter)new EntityInsertAdapter<ContextEntity>(){

            protected String createQuery() {
                return "INSERT OR REPLACE INTO `ContextEntity` (`id`,`itemId`,`data`) VALUES (nullif(?, 0),?,?)";
            }

            protected void bind(SQLiteStatement statement, ContextEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getItemId());
                statement.bindText(3, entity.getData());
            }
        };
        this.__insertAdapterOfDownloadEntity = (EntityInsertAdapter)new EntityInsertAdapter<DownloadEntity>(){

            protected String createQuery() {
                return "INSERT OR REPLACE INTO `DownloadEntity` (`id`,`extensionId`,`trackId`,`contextId`,`sortOrder`,`data`,`task`,`loaded`,`folderPath`,`streamableId`,`indexesData`,`toMergeFilesData`,`toTagFile`,`finalFile`,`exceptionFile`,`fullyDownloaded`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            protected void bind(SQLiteStatement statement, DownloadEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getExtensionId());
                statement.bindText(3, entity.getTrackId());
                Long _tmpContextId = entity.getContextId();
                if (_tmpContextId == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindLong(4, _tmpContextId.longValue());
                }
                Integer _tmpSortOrder = entity.getSortOrder();
                if (_tmpSortOrder == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, (long)_tmpSortOrder.intValue());
                }
                statement.bindText(6, entity.getData());
                statement.bindText(7, this.__TaskType_enumToString(entity.getTask()));
                int _tmp = entity.getLoaded() ? 1 : 0;
                statement.bindLong(8, (long)_tmp);
                String _tmpFolderPath = entity.getFolderPath();
                if (_tmpFolderPath == null) {
                    statement.bindNull(9);
                } else {
                    statement.bindText(9, _tmpFolderPath);
                }
                String _tmpStreamableId = entity.getStreamableId();
                if (_tmpStreamableId == null) {
                    statement.bindNull(10);
                } else {
                    statement.bindText(10, _tmpStreamableId);
                }
                String _tmpIndexesData = entity.getIndexesData();
                if (_tmpIndexesData == null) {
                    statement.bindNull(11);
                } else {
                    statement.bindText(11, _tmpIndexesData);
                }
                String _tmpToMergeFilesData = entity.getToMergeFilesData();
                if (_tmpToMergeFilesData == null) {
                    statement.bindNull(12);
                } else {
                    statement.bindText(12, _tmpToMergeFilesData);
                }
                String _tmpToTagFile = entity.getToTagFile();
                if (_tmpToTagFile == null) {
                    statement.bindNull(13);
                } else {
                    statement.bindText(13, _tmpToTagFile);
                }
                String _tmpFinalFile = entity.getFinalFile();
                if (_tmpFinalFile == null) {
                    statement.bindNull(14);
                } else {
                    statement.bindText(14, _tmpFinalFile);
                }
                String _tmpExceptionFile = entity.getExceptionFile();
                if (_tmpExceptionFile == null) {
                    statement.bindNull(15);
                } else {
                    statement.bindText(15, _tmpExceptionFile);
                }
                int _tmp_1 = entity.getFullyDownloaded() ? 1 : 0;
                statement.bindLong(16, (long)_tmp_1);
            }
        };
        this.__deleteAdapterOfDownloadEntity = (EntityDeleteOrUpdateAdapter)new EntityDeleteOrUpdateAdapter<DownloadEntity>(){

            protected String createQuery() {
                return "DELETE FROM `DownloadEntity` WHERE `id` = ?";
            }

            protected void bind(SQLiteStatement statement, DownloadEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
            }
        };
        this.__deleteAdapterOfContextEntity = (EntityDeleteOrUpdateAdapter)new EntityDeleteOrUpdateAdapter<ContextEntity>(){

            protected String createQuery() {
                return "DELETE FROM `ContextEntity` WHERE `id` = ?";
            }

            protected void bind(SQLiteStatement statement, ContextEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
            }
        };
    }

    @Override
    @Nullable
    public Object insertContextEntity(@NotNull ContextEntity context, @NotNull Continuation<? super Long> $completion) {
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> DownloadDao_Impl.insertContextEntity$lambda$0(this, context, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object insertDownloadEntity(@NotNull DownloadEntity download2, @NotNull Continuation<? super Long> $completion) {
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> DownloadDao_Impl.insertDownloadEntity$lambda$1(this, download2, arg_0), $completion);
    }

    @Override
    public void deleteDownloadEntity(@NotNull DownloadEntity download2) {
        Intrinsics.checkNotNullParameter((Object)download2, (String)"download");
        DBUtil.performBlocking((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> DownloadDao_Impl.deleteDownloadEntity$lambda$2(this, download2, arg_0));
    }

    @Override
    public void deleteContextEntity(@NotNull ContextEntity context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        DBUtil.performBlocking((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> DownloadDao_Impl.deleteContextEntity$lambda$3(this, context, arg_0));
    }

    @Override
    @Nullable
    public Object getDownloadEntity(long trackId, @NotNull Continuation<? super DownloadEntity> $completion) {
        String _sql = "SELECT * FROM DownloadEntity WHERE id = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> DownloadDao_Impl.getDownloadEntity$lambda$4(_sql, trackId, this, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getContextEntity(@Nullable Long contextId, @NotNull Continuation<? super ContextEntity> $completion) {
        String _sql = "SELECT * FROM ContextEntity WHERE id = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> DownloadDao_Impl.getContextEntity$lambda$5(_sql, contextId, arg_0), $completion);
    }

    @Override
    @NotNull
    public Flow<List<DownloadEntity>> getDownloadsFlow() {
        String _sql = "SELECT * FROM DownloadEntity";
        String[] stringArray = new String[]{"DownloadEntity"};
        return FlowUtil.createFlow((RoomDatabase)this.__db, (boolean)false, (String[])stringArray, arg_0 -> DownloadDao_Impl.getDownloadsFlow$lambda$6(_sql, this, arg_0));
    }

    @Override
    @NotNull
    public Flow<List<ContextEntity>> getContextFlow() {
        String _sql = "SELECT * FROM ContextEntity";
        String[] stringArray = new String[]{"ContextEntity"};
        return FlowUtil.createFlow((RoomDatabase)this.__db, (boolean)false, (String[])stringArray, arg_0 -> DownloadDao_Impl.getContextFlow$lambda$7(_sql, arg_0));
    }

    @Override
    @NotNull
    public List<DownloadEntity> getDownloadsForContext(@Nullable Long id2) {
        String _sql = "SELECT * FROM DownloadEntity WHERE contextId = ?";
        return (List)DBUtil.performBlocking((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> DownloadDao_Impl.getDownloadsForContext$lambda$8(_sql, id2, this, arg_0));
    }

    private final String __TaskType_enumToString(TaskType _value) {
        return switch (WhenMappings.$EnumSwitchMapping$0[_value.ordinal()]) {
            case 1 -> "Loading";
            case 2 -> "Downloading";
            case 3 -> "Merging";
            case 4 -> "Tagging";
            case 5 -> "Saving";
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    private final TaskType __TaskType_stringToEnum(String _value) {
        return switch (_value) {
            case "Loading" -> TaskType.Loading;
            case "Downloading" -> TaskType.Downloading;
            case "Merging" -> TaskType.Merging;
            case "Tagging" -> TaskType.Tagging;
            case "Saving" -> TaskType.Saving;
            default -> throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
        };
    }

    private static final long insertContextEntity$lambda$0(DownloadDao_Impl this$0, ContextEntity $context, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        long _result = this$0.__insertAdapterOfContextEntity.insertAndReturnId(_connection, (Object)$context);
        return _result;
    }

    private static final long insertDownloadEntity$lambda$1(DownloadDao_Impl this$0, DownloadEntity $download, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        long _result = this$0.__insertAdapterOfDownloadEntity.insertAndReturnId(_connection, (Object)$download);
        return _result;
    }

    private static final Unit deleteDownloadEntity$lambda$2(DownloadDao_Impl this$0, DownloadEntity $download, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        this$0.__deleteAdapterOfDownloadEntity.handle(_connection, (Object)$download);
        return Unit.INSTANCE;
    }

    private static final Unit deleteContextEntity$lambda$3(DownloadDao_Impl this$0, ContextEntity $context, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        this$0.__deleteAdapterOfContextEntity.handle(_connection, (Object)$context);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final DownloadEntity getDownloadEntity$lambda$4(String $_sql, long $trackId, DownloadDao_Impl this$0, SQLiteConnection _connection) {
        DownloadEntity downloadEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindLong(_argIndex, $trackId);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfExtensionId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extensionId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfContextId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"contextId");
            int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"sortOrder");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            int _columnIndexOfTask = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"task");
            int _columnIndexOfLoaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"loaded");
            int _columnIndexOfFolderPath = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"folderPath");
            int _columnIndexOfStreamableId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"streamableId");
            int _columnIndexOfIndexesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"indexesData");
            int _columnIndexOfToMergeFilesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toMergeFilesData");
            int _columnIndexOfToTagFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toTagFile");
            int _columnIndexOfFinalFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"finalFile");
            int _columnIndexOfExceptionFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"exceptionFile");
            int _columnIndexOfFullyDownloaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"fullyDownloaded");
            DownloadEntity _result = null;
            if (_stmt.step()) {
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpExtensionId = null;
                _tmpExtensionId = _stmt.getText(_columnIndexOfExtensionId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                Long _tmpContextId = null;
                _tmpContextId = _stmt.isNull(_columnIndexOfContextId) ? null : Long.valueOf(_stmt.getLong(_columnIndexOfContextId));
                Integer _tmpSortOrder = null;
                _tmpSortOrder = _stmt.isNull(_columnIndexOfSortOrder) ? null : Integer.valueOf((int)_stmt.getLong(_columnIndexOfSortOrder));
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                TaskType _tmpTask = null;
                _tmpTask = this$0.__TaskType_stringToEnum(_stmt.getText(_columnIndexOfTask));
                boolean _tmpLoaded = false;
                int _tmp = 0;
                _tmp = (int)_stmt.getLong(_columnIndexOfLoaded);
                _tmpLoaded = _tmp != 0;
                String _tmpFolderPath = null;
                _tmpFolderPath = _stmt.isNull(_columnIndexOfFolderPath) ? null : _stmt.getText(_columnIndexOfFolderPath);
                String _tmpStreamableId = null;
                _tmpStreamableId = _stmt.isNull(_columnIndexOfStreamableId) ? null : _stmt.getText(_columnIndexOfStreamableId);
                String _tmpIndexesData = null;
                _tmpIndexesData = _stmt.isNull(_columnIndexOfIndexesData) ? null : _stmt.getText(_columnIndexOfIndexesData);
                String _tmpToMergeFilesData = null;
                _tmpToMergeFilesData = _stmt.isNull(_columnIndexOfToMergeFilesData) ? null : _stmt.getText(_columnIndexOfToMergeFilesData);
                String _tmpToTagFile = null;
                _tmpToTagFile = _stmt.isNull(_columnIndexOfToTagFile) ? null : _stmt.getText(_columnIndexOfToTagFile);
                String _tmpFinalFile = null;
                _tmpFinalFile = _stmt.isNull(_columnIndexOfFinalFile) ? null : _stmt.getText(_columnIndexOfFinalFile);
                String _tmpExceptionFile = null;
                _tmpExceptionFile = _stmt.isNull(_columnIndexOfExceptionFile) ? null : _stmt.getText(_columnIndexOfExceptionFile);
                boolean _tmpFullyDownloaded = false;
                int _tmp_1 = 0;
                _tmp_1 = (int)_stmt.getLong(_columnIndexOfFullyDownloaded);
                _tmpFullyDownloaded = _tmp_1 != 0;
                _result = new DownloadEntity(_tmpId, _tmpExtensionId, _tmpTrackId, _tmpContextId, _tmpSortOrder, _tmpData, _tmpTask, _tmpLoaded, _tmpFolderPath, _tmpStreamableId, _tmpIndexesData, _tmpToMergeFilesData, _tmpToTagFile, _tmpFinalFile, _tmpExceptionFile, _tmpFullyDownloaded);
            } else {
                _result = null;
            }
            downloadEntity = _result;
        }
        return downloadEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final ContextEntity getContextEntity$lambda$5(String $_sql, Long $contextId, SQLiteConnection _connection) {
        ContextEntity contextEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            if ($contextId == null) {
                _stmt.bindNull(_argIndex);
            } else {
                _stmt.bindLong(_argIndex, $contextId.longValue());
            }
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfItemId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"itemId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            ContextEntity _result = null;
            if (_stmt.step()) {
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpItemId = null;
                _tmpItemId = _stmt.getText(_columnIndexOfItemId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _result = new ContextEntity(_tmpId, _tmpItemId, _tmpData);
            } else {
                _result = null;
            }
            contextEntity = _result;
        }
        return contextEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getDownloadsFlow$lambda$6(String $_sql, DownloadDao_Impl this$0, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfExtensionId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extensionId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfContextId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"contextId");
            int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"sortOrder");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            int _columnIndexOfTask = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"task");
            int _columnIndexOfLoaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"loaded");
            int _columnIndexOfFolderPath = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"folderPath");
            int _columnIndexOfStreamableId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"streamableId");
            int _columnIndexOfIndexesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"indexesData");
            int _columnIndexOfToMergeFilesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toMergeFilesData");
            int _columnIndexOfToTagFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toTagFile");
            int _columnIndexOfFinalFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"finalFile");
            int _columnIndexOfExceptionFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"exceptionFile");
            int _columnIndexOfFullyDownloaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"fullyDownloaded");
            List _result = new ArrayList();
            while (_stmt.step()) {
                DownloadEntity _item = null;
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpExtensionId = null;
                _tmpExtensionId = _stmt.getText(_columnIndexOfExtensionId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                Long _tmpContextId = null;
                _tmpContextId = _stmt.isNull(_columnIndexOfContextId) ? null : Long.valueOf(_stmt.getLong(_columnIndexOfContextId));
                Integer _tmpSortOrder = null;
                _tmpSortOrder = _stmt.isNull(_columnIndexOfSortOrder) ? null : Integer.valueOf((int)_stmt.getLong(_columnIndexOfSortOrder));
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                TaskType _tmpTask = null;
                _tmpTask = this$0.__TaskType_stringToEnum(_stmt.getText(_columnIndexOfTask));
                boolean _tmpLoaded = false;
                int _tmp = 0;
                _tmp = (int)_stmt.getLong(_columnIndexOfLoaded);
                _tmpLoaded = _tmp != 0;
                String _tmpFolderPath = null;
                _tmpFolderPath = _stmt.isNull(_columnIndexOfFolderPath) ? null : _stmt.getText(_columnIndexOfFolderPath);
                String _tmpStreamableId = null;
                _tmpStreamableId = _stmt.isNull(_columnIndexOfStreamableId) ? null : _stmt.getText(_columnIndexOfStreamableId);
                String _tmpIndexesData = null;
                _tmpIndexesData = _stmt.isNull(_columnIndexOfIndexesData) ? null : _stmt.getText(_columnIndexOfIndexesData);
                String _tmpToMergeFilesData = null;
                _tmpToMergeFilesData = _stmt.isNull(_columnIndexOfToMergeFilesData) ? null : _stmt.getText(_columnIndexOfToMergeFilesData);
                String _tmpToTagFile = null;
                _tmpToTagFile = _stmt.isNull(_columnIndexOfToTagFile) ? null : _stmt.getText(_columnIndexOfToTagFile);
                String _tmpFinalFile = null;
                _tmpFinalFile = _stmt.isNull(_columnIndexOfFinalFile) ? null : _stmt.getText(_columnIndexOfFinalFile);
                String _tmpExceptionFile = null;
                _tmpExceptionFile = _stmt.isNull(_columnIndexOfExceptionFile) ? null : _stmt.getText(_columnIndexOfExceptionFile);
                boolean _tmpFullyDownloaded = false;
                int _tmp_1 = 0;
                _tmp_1 = (int)_stmt.getLong(_columnIndexOfFullyDownloaded);
                _tmpFullyDownloaded = _tmp_1 != 0;
                _item = new DownloadEntity(_tmpId, _tmpExtensionId, _tmpTrackId, _tmpContextId, _tmpSortOrder, _tmpData, _tmpTask, _tmpLoaded, _tmpFolderPath, _tmpStreamableId, _tmpIndexesData, _tmpToMergeFilesData, _tmpToTagFile, _tmpFinalFile, _tmpExceptionFile, _tmpFullyDownloaded);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getContextFlow$lambda$7(String $_sql, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfItemId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"itemId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            List _result = new ArrayList();
            while (_stmt.step()) {
                ContextEntity _item = null;
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpItemId = null;
                _tmpItemId = _stmt.getText(_columnIndexOfItemId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _item = new ContextEntity(_tmpId, _tmpItemId, _tmpData);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getDownloadsForContext$lambda$8(String $_sql, Long $id, DownloadDao_Impl this$0, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            if ($id == null) {
                _stmt.bindNull(_argIndex);
            } else {
                _stmt.bindLong(_argIndex, $id.longValue());
            }
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfExtensionId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extensionId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfContextId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"contextId");
            int _columnIndexOfSortOrder = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"sortOrder");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            int _columnIndexOfTask = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"task");
            int _columnIndexOfLoaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"loaded");
            int _columnIndexOfFolderPath = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"folderPath");
            int _columnIndexOfStreamableId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"streamableId");
            int _columnIndexOfIndexesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"indexesData");
            int _columnIndexOfToMergeFilesData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toMergeFilesData");
            int _columnIndexOfToTagFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"toTagFile");
            int _columnIndexOfFinalFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"finalFile");
            int _columnIndexOfExceptionFile = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"exceptionFile");
            int _columnIndexOfFullyDownloaded = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"fullyDownloaded");
            List _result = new ArrayList();
            while (_stmt.step()) {
                DownloadEntity _item = null;
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpExtensionId = null;
                _tmpExtensionId = _stmt.getText(_columnIndexOfExtensionId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                Long _tmpContextId = null;
                _tmpContextId = _stmt.isNull(_columnIndexOfContextId) ? null : Long.valueOf(_stmt.getLong(_columnIndexOfContextId));
                Integer _tmpSortOrder = null;
                _tmpSortOrder = _stmt.isNull(_columnIndexOfSortOrder) ? null : Integer.valueOf((int)_stmt.getLong(_columnIndexOfSortOrder));
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                TaskType _tmpTask = null;
                _tmpTask = this$0.__TaskType_stringToEnum(_stmt.getText(_columnIndexOfTask));
                boolean _tmpLoaded = false;
                int _tmp = 0;
                _tmp = (int)_stmt.getLong(_columnIndexOfLoaded);
                _tmpLoaded = _tmp != 0;
                String _tmpFolderPath = null;
                _tmpFolderPath = _stmt.isNull(_columnIndexOfFolderPath) ? null : _stmt.getText(_columnIndexOfFolderPath);
                String _tmpStreamableId = null;
                _tmpStreamableId = _stmt.isNull(_columnIndexOfStreamableId) ? null : _stmt.getText(_columnIndexOfStreamableId);
                String _tmpIndexesData = null;
                _tmpIndexesData = _stmt.isNull(_columnIndexOfIndexesData) ? null : _stmt.getText(_columnIndexOfIndexesData);
                String _tmpToMergeFilesData = null;
                _tmpToMergeFilesData = _stmt.isNull(_columnIndexOfToMergeFilesData) ? null : _stmt.getText(_columnIndexOfToMergeFilesData);
                String _tmpToTagFile = null;
                _tmpToTagFile = _stmt.isNull(_columnIndexOfToTagFile) ? null : _stmt.getText(_columnIndexOfToTagFile);
                String _tmpFinalFile = null;
                _tmpFinalFile = _stmt.isNull(_columnIndexOfFinalFile) ? null : _stmt.getText(_columnIndexOfFinalFile);
                String _tmpExceptionFile = null;
                _tmpExceptionFile = _stmt.isNull(_columnIndexOfExceptionFile) ? null : _stmt.getText(_columnIndexOfExceptionFile);
                boolean _tmpFullyDownloaded = false;
                int _tmp_1 = 0;
                _tmp_1 = (int)_stmt.getLong(_columnIndexOfFullyDownloaded);
                _tmpFullyDownloaded = _tmp_1 != 0;
                _item = new DownloadEntity(_tmpId, _tmpExtensionId, _tmpTrackId, _tmpContextId, _tmpSortOrder, _tmpData, _tmpTask, _tmpLoaded, _tmpFolderPath, _tmpStreamableId, _tmpIndexesData, _tmpToMergeFilesData, _tmpToTagFile, _tmpFinalFile, _tmpExceptionFile, _tmpFullyDownloaded);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<KClass<?>> getRequiredConverters() {
            return CollectionsKt.emptyList();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[TaskType.values().length];
            try {
                nArray[TaskType.Loading.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TaskType.Downloading.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TaskType.Merging.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TaskType.Tagging.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[TaskType.Saving.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

