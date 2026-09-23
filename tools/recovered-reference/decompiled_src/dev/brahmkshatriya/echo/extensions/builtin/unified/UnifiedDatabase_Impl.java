/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.InvalidationTracker
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomOpenDelegate
 *  androidx.room.RoomOpenDelegate$ValidationResult
 *  androidx.room.migration.AutoMigrationSpec
 *  androidx.room.migration.Migration
 *  androidx.room.util.DBUtil
 *  androidx.room.util.TableInfo
 *  androidx.room.util.TableInfo$Column
 *  androidx.sqlite.SQLite
 *  androidx.sqlite.SQLiteConnection
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.extensions.builtin.unified;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase;
import dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase_PlaylistDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase_Impl;", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase;", "<init>", "()V", "_unifiedDatabase", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/extensions/builtin/unified/UnifiedDatabase$PlaylistDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "playlistDao", "app_debug"})
public final class UnifiedDatabase_Impl
extends UnifiedDatabase {
    @NotNull
    private final Lazy<UnifiedDatabase.PlaylistDao> _unifiedDatabase = LazyKt.lazy(() -> UnifiedDatabase_Impl._unifiedDatabase$lambda$0(this));

    @NotNull
    protected RoomOpenDelegate createOpenDelegate() {
        RoomOpenDelegate _openDelegate2 = new RoomOpenDelegate(this){
            final /* synthetic */ UnifiedDatabase_Impl this$0;
            {
                this.this$0 = $receiver;
                super(6, "2561ce3bc88addb94ac70607388dbd84", "4ba72cbd818042528a769348803605ca");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS `PlaylistEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `modified` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `cover` TEXT, `listData` TEXT NOT NULL, `actualId` TEXT NOT NULL)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS `PlaylistTrackEntity` (`eid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playlistId` INTEGER NOT NULL, `trackId` TEXT NOT NULL, `extId` TEXT NOT NULL, `data` TEXT NOT NULL)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS `SavedEntity` (`id` TEXT NOT NULL, `extId` TEXT NOT NULL, `data` TEXT NOT NULL, PRIMARY KEY(`id`, `extId`))");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2561ce3bc88addb94ac70607388dbd84')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                SQLite.execSQL((SQLiteConnection)connection, (String)"DROP TABLE IF EXISTS `PlaylistEntity`");
                SQLite.execSQL((SQLiteConnection)connection, (String)"DROP TABLE IF EXISTS `PlaylistTrackEntity`");
                SQLite.execSQL((SQLiteConnection)connection, (String)"DROP TABLE IF EXISTS `SavedEntity`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                UnifiedDatabase_Impl.access$internalInitInvalidationTracker(this.this$0, connection);
            }

            public void onPreMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                DBUtil.dropFtsSyncTriggers((SQLiteConnection)connection);
            }

            public void onPostMigrate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                Map _columnsPlaylistEntity = new LinkedHashMap<K, V>();
                _columnsPlaylistEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsPlaylistEntity.put("modified", new TableInfo.Column("modified", "TEXT", true, 0, null, 1));
                _columnsPlaylistEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
                _columnsPlaylistEntity.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                _columnsPlaylistEntity.put("cover", new TableInfo.Column("cover", "TEXT", false, 0, null, 1));
                _columnsPlaylistEntity.put("listData", new TableInfo.Column("listData", "TEXT", true, 0, null, 1));
                _columnsPlaylistEntity.put("actualId", new TableInfo.Column("actualId", "TEXT", true, 0, null, 1));
                Set _foreignKeysPlaylistEntity = new LinkedHashSet<E>();
                Set _indicesPlaylistEntity = new LinkedHashSet<E>();
                TableInfo _infoPlaylistEntity = new TableInfo("PlaylistEntity", _columnsPlaylistEntity, _foreignKeysPlaylistEntity, _indicesPlaylistEntity);
                TableInfo _existingPlaylistEntity = TableInfo.Companion.read(connection, "PlaylistEntity");
                if (!_infoPlaylistEntity.equals((Object)_existingPlaylistEntity)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PlaylistEntity(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase.PlaylistEntity).\n Expected:\n" + _infoPlaylistEntity + "\n Found:\n" + _existingPlaylistEntity);
                }
                Map _columnsPlaylistTrackEntity = new LinkedHashMap<K, V>();
                _columnsPlaylistTrackEntity.put("eid", new TableInfo.Column("eid", "INTEGER", true, 1, null, 1));
                _columnsPlaylistTrackEntity.put("playlistId", new TableInfo.Column("playlistId", "INTEGER", true, 0, null, 1));
                _columnsPlaylistTrackEntity.put("trackId", new TableInfo.Column("trackId", "TEXT", true, 0, null, 1));
                _columnsPlaylistTrackEntity.put("extId", new TableInfo.Column("extId", "TEXT", true, 0, null, 1));
                _columnsPlaylistTrackEntity.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                Set _foreignKeysPlaylistTrackEntity = new LinkedHashSet<E>();
                Set _indicesPlaylistTrackEntity = new LinkedHashSet<E>();
                TableInfo _infoPlaylistTrackEntity = new TableInfo("PlaylistTrackEntity", _columnsPlaylistTrackEntity, _foreignKeysPlaylistTrackEntity, _indicesPlaylistTrackEntity);
                TableInfo _existingPlaylistTrackEntity = TableInfo.Companion.read(connection, "PlaylistTrackEntity");
                if (!_infoPlaylistTrackEntity.equals((Object)_existingPlaylistTrackEntity)) {
                    return new RoomOpenDelegate.ValidationResult(false, "PlaylistTrackEntity(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase.PlaylistTrackEntity).\n Expected:\n" + _infoPlaylistTrackEntity + "\n Found:\n" + _existingPlaylistTrackEntity);
                }
                Map _columnsSavedEntity = new LinkedHashMap<K, V>();
                _columnsSavedEntity.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsSavedEntity.put("extId", new TableInfo.Column("extId", "TEXT", true, 2, null, 1));
                _columnsSavedEntity.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                Set _foreignKeysSavedEntity = new LinkedHashSet<E>();
                Set _indicesSavedEntity = new LinkedHashSet<E>();
                TableInfo _infoSavedEntity = new TableInfo("SavedEntity", _columnsSavedEntity, _foreignKeysSavedEntity, _indicesSavedEntity);
                TableInfo _existingSavedEntity = TableInfo.Companion.read(connection, "SavedEntity");
                if (!_infoSavedEntity.equals((Object)_existingSavedEntity)) {
                    return new RoomOpenDelegate.ValidationResult(false, "SavedEntity(dev.brahmkshatriya.echo.extensions.builtin.unified.UnifiedDatabase.SavedEntity).\n Expected:\n" + _infoSavedEntity + "\n Found:\n" + _existingSavedEntity);
                }
                return new RoomOpenDelegate.ValidationResult(true, null);
            }
        };
        return _openDelegate2;
    }

    @NotNull
    protected InvalidationTracker createInvalidationTracker() {
        Map _shadowTablesMap = new LinkedHashMap();
        Map _viewTables = new LinkedHashMap();
        String[] stringArray = new String[]{"PlaylistEntity", "PlaylistTrackEntity", "SavedEntity"};
        return new InvalidationTracker((RoomDatabase)this, _shadowTablesMap, _viewTables, stringArray);
    }

    public void clearAllTables() {
        String[] stringArray = new String[]{"PlaylistEntity", "PlaylistTrackEntity", "SavedEntity"};
        super.performClear(false, stringArray);
    }

    @NotNull
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(UnifiedDatabase.PlaylistDao.class), UnifiedDatabase_PlaylistDao_Impl.Companion.getRequiredConverters());
        return _typeConvertersMap;
    }

    @NotNull
    public Set<KClass<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecClasses() {
        Set _autoMigrationSpecsSet = new LinkedHashSet();
        return _autoMigrationSpecsSet;
    }

    @NotNull
    public List<Migration> createAutoMigrations(@NotNull Map<KClass<? extends AutoMigrationSpec>, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, (String)"autoMigrationSpecs");
        List _autoMigrations = new ArrayList();
        return _autoMigrations;
    }

    @Override
    @NotNull
    public UnifiedDatabase.PlaylistDao playlistDao() {
        return (UnifiedDatabase.PlaylistDao)this._unifiedDatabase.getValue();
    }

    private static final UnifiedDatabase_PlaylistDao_Impl _unifiedDatabase$lambda$0(UnifiedDatabase_Impl this$0) {
        return new UnifiedDatabase_PlaylistDao_Impl(this$0);
    }

    public static final /* synthetic */ void access$internalInitInvalidationTracker(UnifiedDatabase_Impl $this, SQLiteConnection connection) {
        $this.internalInitInvalidationTracker(connection);
    }
}

