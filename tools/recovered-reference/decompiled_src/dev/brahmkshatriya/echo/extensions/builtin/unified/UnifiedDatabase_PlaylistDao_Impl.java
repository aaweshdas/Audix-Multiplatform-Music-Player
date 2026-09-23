/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.EntityDeleteOrUpdateAdapter
 *  androidx.room.EntityInsertAdapter
 *  androidx.room.RoomDatabase
 *  androidx.room.util.DBUtil
 *  androidx.room.util.SQLiteStatementUtil
 *  androidx.sqlite.SQLiteConnection
 *  androidx.sqlite.SQLiteStatement
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.extensions.builtin.unified;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 H\u0096@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010$J\u0018\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010%\u001a\u00020&H\u0096@\u00a2\u0006\u0002\u0010'J\u0018\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010)\u001a\u00020&H\u0096@\u00a2\u0006\u0002\u0010'J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0 2\u0006\u0010+\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010$J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0 H\u0096@\u00a2\u0006\u0002\u0010!J\u001e\u0010-\u001a\u00020.2\u0006\u0010#\u001a\u00020&2\u0006\u0010/\u001a\u00020&H\u0096@\u00a2\u0006\u0002\u00100J\u001a\u00101\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u00010\u0012H\u0096@\u00a2\u0006\u0002\u00103J\u0018\u00104\u001a\u0004\u0018\u00010\n2\u0006\u00102\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010$J\u0016\u00105\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase_PlaylistDao_Impl;", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistDao;", "__db", "Landroidx/room/RoomDatabase;", "<init>", "(Landroidx/room/RoomDatabase;)V", "__insertAdapterOfPlaylistEntity", "Landroidx/room/EntityInsertAdapter;", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;", "__insertAdapterOfPlaylistTrackEntity", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;", "__insertAdapterOfSavedEntity", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;", "__deleteAdapterOfPlaylistEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfPlaylistTrackEntity", "__deleteAdapterOfSavedEntity", "insertPlaylist", "", "playlist", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPlaylistTrack", "playlistTrack", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistTrackEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSaved", "saved", "(Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$SavedEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePlaylist", "", "deletePlaylistTrack", "deleteSaved", "getPlaylists", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylist", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlaylistByActualId", "actualId", "getTracks", "playlistId", "getSaved", "isSaved", "", "extId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrack", "eid", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAfterTrack", "deleteAllTracks", "Companion", "app_debug"})
public final class UnifiedDatabase_PlaylistDao_Impl
implements UnifiedDatabase.PlaylistDao {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final RoomDatabase __db;
    @NotNull
    private final EntityInsertAdapter<UnifiedDatabase.PlaylistEntity> __insertAdapterOfPlaylistEntity;
    @NotNull
    private final EntityInsertAdapter<UnifiedDatabase.PlaylistTrackEntity> __insertAdapterOfPlaylistTrackEntity;
    @NotNull
    private final EntityInsertAdapter<UnifiedDatabase.SavedEntity> __insertAdapterOfSavedEntity;
    @NotNull
    private final EntityDeleteOrUpdateAdapter<UnifiedDatabase.PlaylistEntity> __deleteAdapterOfPlaylistEntity;
    @NotNull
    private final EntityDeleteOrUpdateAdapter<UnifiedDatabase.PlaylistTrackEntity> __deleteAdapterOfPlaylistTrackEntity;
    @NotNull
    private final EntityDeleteOrUpdateAdapter<UnifiedDatabase.SavedEntity> __deleteAdapterOfSavedEntity;

    public UnifiedDatabase_PlaylistDao_Impl(@NotNull RoomDatabase __db) {
        Intrinsics.checkNotNullParameter((Object)__db, (String)"__db");
        this.__db = __db;
        this.__insertAdapterOfPlaylistEntity = (EntityInsertAdapter)new EntityInsertAdapter<UnifiedDatabase.PlaylistEntity>(){

            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlaylistEntity` (`id`,`modified`,`name`,`description`,`cover`,`listData`,`actualId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.PlaylistEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
                statement.bindText(2, entity.getModified());
                statement.bindText(3, entity.getName());
                statement.bindText(4, entity.getDescription());
                String _tmpCover = entity.getCover();
                if (_tmpCover == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindText(5, _tmpCover);
                }
                statement.bindText(6, entity.getListData());
                statement.bindText(7, entity.getActualId());
            }
        };
        this.__insertAdapterOfPlaylistTrackEntity = (EntityInsertAdapter)new EntityInsertAdapter<UnifiedDatabase.PlaylistTrackEntity>(){

            protected String createQuery() {
                return "INSERT OR REPLACE INTO `PlaylistTrackEntity` (`eid`,`playlistId`,`trackId`,`extId`,`data`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.PlaylistTrackEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getEid());
                statement.bindLong(2, entity.getPlaylistId());
                statement.bindText(3, entity.getTrackId());
                statement.bindText(4, entity.getExtId());
                statement.bindText(5, entity.getData());
            }
        };
        this.__insertAdapterOfSavedEntity = (EntityInsertAdapter)new EntityInsertAdapter<UnifiedDatabase.SavedEntity>(){

            protected String createQuery() {
                return "INSERT OR REPLACE INTO `SavedEntity` (`id`,`extId`,`data`) VALUES (?,?,?)";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.SavedEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindText(1, entity.getId());
                statement.bindText(2, entity.getExtId());
                statement.bindText(3, entity.getData());
            }
        };
        this.__deleteAdapterOfPlaylistEntity = (EntityDeleteOrUpdateAdapter)new EntityDeleteOrUpdateAdapter<UnifiedDatabase.PlaylistEntity>(){

            protected String createQuery() {
                return "DELETE FROM `PlaylistEntity` WHERE `id` = ?";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.PlaylistEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getId());
            }
        };
        this.__deleteAdapterOfPlaylistTrackEntity = (EntityDeleteOrUpdateAdapter)new EntityDeleteOrUpdateAdapter<UnifiedDatabase.PlaylistTrackEntity>(){

            protected String createQuery() {
                return "DELETE FROM `PlaylistTrackEntity` WHERE `eid` = ?";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.PlaylistTrackEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindLong(1, entity.getEid());
            }
        };
        this.__deleteAdapterOfSavedEntity = (EntityDeleteOrUpdateAdapter)new EntityDeleteOrUpdateAdapter<UnifiedDatabase.SavedEntity>(){

            protected String createQuery() {
                return "DELETE FROM `SavedEntity` WHERE `id` = ? AND `extId` = ?";
            }

            protected void bind(SQLiteStatement statement, UnifiedDatabase.SavedEntity entity) {
                Intrinsics.checkNotNullParameter((Object)statement, (String)"statement");
                Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
                statement.bindText(1, entity.getId());
                statement.bindText(2, entity.getExtId());
            }
        };
    }

    @Override
    @Nullable
    public Object insertPlaylist(@NotNull UnifiedDatabase.PlaylistEntity playlist, @NotNull Continuation<? super Long> $completion) {
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.insertPlaylist$lambda$0(this, playlist, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object insertPlaylistTrack(@NotNull UnifiedDatabase.PlaylistTrackEntity playlistTrack, @NotNull Continuation<? super Long> $completion) {
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.insertPlaylistTrack$lambda$1(this, playlistTrack, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object insertSaved(@NotNull UnifiedDatabase.SavedEntity saved, @NotNull Continuation<? super Long> $completion) {
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.insertSaved$lambda$2(this, saved, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object deletePlaylist(@NotNull UnifiedDatabase.PlaylistEntity playlist, @NotNull Continuation<? super Unit> $completion) {
        Object object = DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.deletePlaylist$lambda$3(this, playlist, arg_0), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object deletePlaylistTrack(@NotNull UnifiedDatabase.PlaylistTrackEntity playlistTrack, @NotNull Continuation<? super Unit> $completion) {
        Object object = DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.deletePlaylistTrack$lambda$4(this, playlistTrack, arg_0), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object deleteSaved(@NotNull UnifiedDatabase.SavedEntity saved, @NotNull Continuation<? super Unit> $completion) {
        Object object = DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.deleteSaved$lambda$5(this, saved, arg_0), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    @Override
    @Nullable
    public Object getPlaylists(@NotNull Continuation<? super List<UnifiedDatabase.PlaylistEntity>> $completion) {
        String _sql = "SELECT * FROM PlaylistEntity";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getPlaylists$lambda$6(_sql, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getPlaylist(long id2, @NotNull Continuation<? super UnifiedDatabase.PlaylistEntity> $completion) {
        String _sql = "SELECT * FROM PlaylistEntity WHERE id = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getPlaylist$lambda$7(_sql, id2, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getPlaylist(@NotNull String name, @NotNull Continuation<? super UnifiedDatabase.PlaylistEntity> $completion) {
        String _sql = "SELECT * FROM PlaylistEntity WHERE name = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getPlaylist$lambda$8(_sql, name, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getPlaylistByActualId(@NotNull String actualId, @NotNull Continuation<? super UnifiedDatabase.PlaylistEntity> $completion) {
        String _sql = "SELECT * FROM PlaylistEntity WHERE actualId = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getPlaylistByActualId$lambda$9(_sql, actualId, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getTracks(long playlistId, @NotNull Continuation<? super List<UnifiedDatabase.PlaylistTrackEntity>> $completion) {
        String _sql = "SELECT * FROM PlaylistTrackEntity WHERE playlistId = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getTracks$lambda$10(_sql, playlistId, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getSaved(@NotNull Continuation<? super List<UnifiedDatabase.SavedEntity>> $completion) {
        String _sql = "SELECT * FROM SavedEntity";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getSaved$lambda$11(_sql, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object isSaved(@NotNull String id2, @NotNull String extId, @NotNull Continuation<? super Boolean> $completion) {
        String _sql = "SELECT EXISTS(SELECT 1 FROM SavedEntity WHERE id = ? AND extId = ?)";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.isSaved$lambda$12(_sql, id2, extId, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getTrack(@Nullable Long eid, @NotNull Continuation<? super UnifiedDatabase.PlaylistTrackEntity> $completion) {
        String _sql = "SELECT * FROM PlaylistTrackEntity WHERE eid = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getTrack$lambda$13(_sql, eid, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object getAfterTrack(long eid, @NotNull Continuation<? super UnifiedDatabase.PlaylistTrackEntity> $completion) {
        String _sql = "SELECT * FROM PlaylistTrackEntity WHERE \"after\" = ?";
        return DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)true, (boolean)false, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.getAfterTrack$lambda$14(_sql, eid, arg_0), $completion);
    }

    @Override
    @Nullable
    public Object deleteAllTracks(long playlistId, @NotNull Continuation<? super Unit> $completion) {
        String _sql = "DELETE FROM PlaylistTrackEntity WHERE playlistId = ?";
        Object object = DBUtil.performSuspending((RoomDatabase)this.__db, (boolean)false, (boolean)true, arg_0 -> UnifiedDatabase_PlaylistDao_Impl.deleteAllTracks$lambda$15(_sql, playlistId, arg_0), $completion);
        if (object == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return object;
        }
        return Unit.INSTANCE;
    }

    private static final long insertPlaylist$lambda$0(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.PlaylistEntity $playlist, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        long _result = this$0.__insertAdapterOfPlaylistEntity.insertAndReturnId(_connection, (Object)$playlist);
        return _result;
    }

    private static final long insertPlaylistTrack$lambda$1(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.PlaylistTrackEntity $playlistTrack, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        long _result = this$0.__insertAdapterOfPlaylistTrackEntity.insertAndReturnId(_connection, (Object)$playlistTrack);
        return _result;
    }

    private static final long insertSaved$lambda$2(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.SavedEntity $saved, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        long _result = this$0.__insertAdapterOfSavedEntity.insertAndReturnId(_connection, (Object)$saved);
        return _result;
    }

    private static final Unit deletePlaylist$lambda$3(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.PlaylistEntity $playlist, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        this$0.__deleteAdapterOfPlaylistEntity.handle(_connection, (Object)$playlist);
        return Unit.INSTANCE;
    }

    private static final Unit deletePlaylistTrack$lambda$4(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.PlaylistTrackEntity $playlistTrack, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        this$0.__deleteAdapterOfPlaylistTrackEntity.handle(_connection, (Object)$playlistTrack);
        return Unit.INSTANCE;
    }

    private static final Unit deleteSaved$lambda$5(UnifiedDatabase_PlaylistDao_Impl this$0, UnifiedDatabase.SavedEntity $saved, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        this$0.__deleteAdapterOfSavedEntity.handle(_connection, (Object)$saved);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getPlaylists$lambda$6(String $_sql, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfModified = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"modified");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"description");
            int _columnIndexOfCover = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"cover");
            int _columnIndexOfListData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"listData");
            int _columnIndexOfActualId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"actualId");
            List _result = new ArrayList();
            while (_stmt.step()) {
                UnifiedDatabase.PlaylistEntity _item = null;
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpModified = null;
                _tmpModified = _stmt.getText(_columnIndexOfModified);
                String _tmpName = null;
                _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpDescription = null;
                _tmpDescription = _stmt.getText(_columnIndexOfDescription);
                String _tmpCover = null;
                _tmpCover = _stmt.isNull(_columnIndexOfCover) ? null : _stmt.getText(_columnIndexOfCover);
                String _tmpListData = null;
                _tmpListData = _stmt.getText(_columnIndexOfListData);
                String _tmpActualId = null;
                _tmpActualId = _stmt.getText(_columnIndexOfActualId);
                _item = new UnifiedDatabase.PlaylistEntity(_tmpId, _tmpModified, _tmpName, _tmpDescription, _tmpCover, _tmpListData, _tmpActualId);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final UnifiedDatabase.PlaylistEntity getPlaylist$lambda$7(String $_sql, long $id, SQLiteConnection _connection) {
        UnifiedDatabase.PlaylistEntity playlistEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindLong(_argIndex, $id);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfModified = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"modified");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"description");
            int _columnIndexOfCover = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"cover");
            int _columnIndexOfListData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"listData");
            int _columnIndexOfActualId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"actualId");
            UnifiedDatabase.PlaylistEntity _result = null;
            if (!_stmt.step()) {
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase.PlaylistEntity>.".toString());
            }
            long _tmpId = 0L;
            _tmpId = _stmt.getLong(_columnIndexOfId);
            String _tmpModified = null;
            _tmpModified = _stmt.getText(_columnIndexOfModified);
            String _tmpName = null;
            _tmpName = _stmt.getText(_columnIndexOfName);
            String _tmpDescription = null;
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
            String _tmpCover = null;
            _tmpCover = _stmt.isNull(_columnIndexOfCover) ? null : _stmt.getText(_columnIndexOfCover);
            String _tmpListData = null;
            _tmpListData = _stmt.getText(_columnIndexOfListData);
            String _tmpActualId = null;
            _tmpActualId = _stmt.getText(_columnIndexOfActualId);
            _result = new UnifiedDatabase.PlaylistEntity(_tmpId, _tmpModified, _tmpName, _tmpDescription, _tmpCover, _tmpListData, _tmpActualId);
            playlistEntity = _result;
        }
        return playlistEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final UnifiedDatabase.PlaylistEntity getPlaylist$lambda$8(String $_sql, String $name, SQLiteConnection _connection) {
        UnifiedDatabase.PlaylistEntity playlistEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindText(_argIndex, $name);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfModified = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"modified");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"description");
            int _columnIndexOfCover = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"cover");
            int _columnIndexOfListData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"listData");
            int _columnIndexOfActualId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"actualId");
            UnifiedDatabase.PlaylistEntity _result = null;
            if (_stmt.step()) {
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpModified = null;
                _tmpModified = _stmt.getText(_columnIndexOfModified);
                String _tmpName = null;
                _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpDescription = null;
                _tmpDescription = _stmt.getText(_columnIndexOfDescription);
                String _tmpCover = null;
                _tmpCover = _stmt.isNull(_columnIndexOfCover) ? null : _stmt.getText(_columnIndexOfCover);
                String _tmpListData = null;
                _tmpListData = _stmt.getText(_columnIndexOfListData);
                String _tmpActualId = null;
                _tmpActualId = _stmt.getText(_columnIndexOfActualId);
                _result = new UnifiedDatabase.PlaylistEntity(_tmpId, _tmpModified, _tmpName, _tmpDescription, _tmpCover, _tmpListData, _tmpActualId);
            } else {
                _result = null;
            }
            playlistEntity = _result;
        }
        return playlistEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final UnifiedDatabase.PlaylistEntity getPlaylistByActualId$lambda$9(String $_sql, String $actualId, SQLiteConnection _connection) {
        UnifiedDatabase.PlaylistEntity playlistEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindText(_argIndex, $actualId);
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfModified = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"modified");
            int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"name");
            int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"description");
            int _columnIndexOfCover = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"cover");
            int _columnIndexOfListData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"listData");
            int _columnIndexOfActualId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"actualId");
            UnifiedDatabase.PlaylistEntity _result = null;
            if (_stmt.step()) {
                long _tmpId = 0L;
                _tmpId = _stmt.getLong(_columnIndexOfId);
                String _tmpModified = null;
                _tmpModified = _stmt.getText(_columnIndexOfModified);
                String _tmpName = null;
                _tmpName = _stmt.getText(_columnIndexOfName);
                String _tmpDescription = null;
                _tmpDescription = _stmt.getText(_columnIndexOfDescription);
                String _tmpCover = null;
                _tmpCover = _stmt.isNull(_columnIndexOfCover) ? null : _stmt.getText(_columnIndexOfCover);
                String _tmpListData = null;
                _tmpListData = _stmt.getText(_columnIndexOfListData);
                String _tmpActualId = null;
                _tmpActualId = _stmt.getText(_columnIndexOfActualId);
                _result = new UnifiedDatabase.PlaylistEntity(_tmpId, _tmpModified, _tmpName, _tmpDescription, _tmpCover, _tmpListData, _tmpActualId);
            } else {
                _result = null;
            }
            playlistEntity = _result;
        }
        return playlistEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getTracks$lambda$10(String $_sql, long $playlistId, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindLong(_argIndex, $playlistId);
            int _columnIndexOfEid = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"eid");
            int _columnIndexOfPlaylistId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"playlistId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfExtId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            List _result = new ArrayList();
            while (_stmt.step()) {
                UnifiedDatabase.PlaylistTrackEntity _item = null;
                long _tmpEid = 0L;
                _tmpEid = _stmt.getLong(_columnIndexOfEid);
                long _tmpPlaylistId = 0L;
                _tmpPlaylistId = _stmt.getLong(_columnIndexOfPlaylistId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                String _tmpExtId = null;
                _tmpExtId = _stmt.getText(_columnIndexOfExtId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _item = new UnifiedDatabase.PlaylistTrackEntity(_tmpEid, _tmpPlaylistId, _tmpTrackId, _tmpExtId, _tmpData);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final List getSaved$lambda$11(String $_sql, SQLiteConnection _connection) {
        List list2;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"id");
            int _columnIndexOfExtId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            List _result = new ArrayList();
            while (_stmt.step()) {
                UnifiedDatabase.SavedEntity _item = null;
                String _tmpId = null;
                _tmpId = _stmt.getText(_columnIndexOfId);
                String _tmpExtId = null;
                _tmpExtId = _stmt.getText(_columnIndexOfExtId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _item = new UnifiedDatabase.SavedEntity(_tmpId, _tmpExtId, _tmpData);
                _result.add(_item);
            }
            list2 = _result;
        }
        return list2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final boolean isSaved$lambda$12(String $_sql, String $id, String $extId, SQLiteConnection _connection) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindText(_argIndex, $id);
            _argIndex = 2;
            _stmt.bindText(_argIndex, $extId);
            boolean _result = false;
            if (_stmt.step()) {
                int _tmp = 0;
                _tmp = (int)_stmt.getLong(0);
                _result = _tmp != 0;
            } else {
                _result = false;
            }
            bl = _result;
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final UnifiedDatabase.PlaylistTrackEntity getTrack$lambda$13(String $_sql, Long $eid, SQLiteConnection _connection) {
        UnifiedDatabase.PlaylistTrackEntity playlistTrackEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            if ($eid == null) {
                _stmt.bindNull(_argIndex);
            } else {
                _stmt.bindLong(_argIndex, $eid.longValue());
            }
            int _columnIndexOfEid = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"eid");
            int _columnIndexOfPlaylistId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"playlistId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfExtId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            UnifiedDatabase.PlaylistTrackEntity _result = null;
            if (_stmt.step()) {
                long _tmpEid = 0L;
                _tmpEid = _stmt.getLong(_columnIndexOfEid);
                long _tmpPlaylistId = 0L;
                _tmpPlaylistId = _stmt.getLong(_columnIndexOfPlaylistId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                String _tmpExtId = null;
                _tmpExtId = _stmt.getText(_columnIndexOfExtId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _result = new UnifiedDatabase.PlaylistTrackEntity(_tmpEid, _tmpPlaylistId, _tmpTrackId, _tmpExtId, _tmpData);
            } else {
                _result = null;
            }
            playlistTrackEntity = _result;
        }
        return playlistTrackEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final UnifiedDatabase.PlaylistTrackEntity getAfterTrack$lambda$14(String $_sql, long $eid, SQLiteConnection _connection) {
        UnifiedDatabase.PlaylistTrackEntity playlistTrackEntity;
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindLong(_argIndex, $eid);
            int _columnIndexOfEid = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"eid");
            int _columnIndexOfPlaylistId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"playlistId");
            int _columnIndexOfTrackId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"trackId");
            int _columnIndexOfExtId = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"extId");
            int _columnIndexOfData = SQLiteStatementUtil.getColumnIndexOrThrow((SQLiteStatement)_stmt, (String)"data");
            UnifiedDatabase.PlaylistTrackEntity _result = null;
            if (_stmt.step()) {
                long _tmpEid = 0L;
                _tmpEid = _stmt.getLong(_columnIndexOfEid);
                long _tmpPlaylistId = 0L;
                _tmpPlaylistId = _stmt.getLong(_columnIndexOfPlaylistId);
                String _tmpTrackId = null;
                _tmpTrackId = _stmt.getText(_columnIndexOfTrackId);
                String _tmpExtId = null;
                _tmpExtId = _stmt.getText(_columnIndexOfExtId);
                String _tmpData = null;
                _tmpData = _stmt.getText(_columnIndexOfData);
                _result = new UnifiedDatabase.PlaylistTrackEntity(_tmpEid, _tmpPlaylistId, _tmpTrackId, _tmpExtId, _tmpData);
            } else {
                _result = null;
            }
            playlistTrackEntity = _result;
        }
        return playlistTrackEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final Unit deleteAllTracks$lambda$15(String $_sql, long $playlistId, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter((Object)_connection, (String)"_connection");
        try (SQLiteStatement _stmt = _connection.prepare($_sql);){
            int _argIndex = 1;
            _stmt.bindLong(_argIndex, $playlistId);
            _stmt.step();
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase_PlaylistDao_Impl$Companion;", "", "<init>", "()V", "getRequiredConverters", "", "Lkotlin/reflect/KClass;", "app_debug"})
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
}

