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
package dev.brahmkshatriya.echo.download.db;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import dev.brahmkshatriya.echo.download.db.DownloadDao;
import dev.brahmkshatriya.echo.download.db.DownloadDao_Impl;
import dev.brahmkshatriya.echo.download.db.DownloadDatabase;
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

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00100\u000eH\u0014J\u0016\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f0\u0012H\u0016J*\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00102\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f\u0012\u0004\u0012\u00020\u00130\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDatabase_Impl;", "Ldev/brahmkshatriya/echo/download/db/DownloadDatabase;", "<init>", "()V", "_downloadDao", "Lkotlin/Lazy;", "Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "createOpenDelegate", "Landroidx/room/RoomOpenDelegate;", "createInvalidationTracker", "Landroidx/room/InvalidationTracker;", "clearAllTables", "", "getRequiredTypeConverterClasses", "", "Lkotlin/reflect/KClass;", "", "getRequiredAutoMigrationSpecClasses", "", "Landroidx/room/migration/AutoMigrationSpec;", "createAutoMigrations", "Landroidx/room/migration/Migration;", "autoMigrationSpecs", "downloadDao", "app_debug"})
public final class DownloadDatabase_Impl
extends DownloadDatabase {
    @NotNull
    private final Lazy<DownloadDao> _downloadDao = LazyKt.lazy(() -> DownloadDatabase_Impl._downloadDao$lambda$0(this));

    @NotNull
    protected RoomOpenDelegate createOpenDelegate() {
        RoomOpenDelegate _openDelegate2 = new RoomOpenDelegate(this){
            final /* synthetic */ DownloadDatabase_Impl this$0;
            {
                this.this$0 = $receiver;
                super(8, "7ba4bfd0dd6844f39aa29c8a6cc763a6", "f0a0cf9c2435be15e7e13a26574903d9");
            }

            public void createAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS `ContextEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `itemId` TEXT NOT NULL, `data` TEXT NOT NULL)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS `DownloadEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `extensionId` TEXT NOT NULL, `trackId` TEXT NOT NULL, `contextId` INTEGER, `sortOrder` INTEGER, `data` TEXT NOT NULL, `task` TEXT NOT NULL, `loaded` INTEGER NOT NULL, `folderPath` TEXT, `streamableId` TEXT, `indexesData` TEXT, `toMergeFilesData` TEXT, `toTagFile` TEXT, `finalFile` TEXT, `exceptionFile` TEXT, `fullyDownloaded` INTEGER NOT NULL)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                SQLite.execSQL((SQLiteConnection)connection, (String)"INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7ba4bfd0dd6844f39aa29c8a6cc763a6')");
            }

            public void dropAllTables(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                SQLite.execSQL((SQLiteConnection)connection, (String)"DROP TABLE IF EXISTS `ContextEntity`");
                SQLite.execSQL((SQLiteConnection)connection, (String)"DROP TABLE IF EXISTS `DownloadEntity`");
            }

            public void onCreate(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
            }

            public void onOpen(SQLiteConnection connection) {
                Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
                DownloadDatabase_Impl.access$internalInitInvalidationTracker(this.this$0, connection);
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
                Map _columnsContextEntity = new LinkedHashMap<K, V>();
                _columnsContextEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsContextEntity.put("itemId", new TableInfo.Column("itemId", "TEXT", true, 0, null, 1));
                _columnsContextEntity.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                Set _foreignKeysContextEntity = new LinkedHashSet<E>();
                Set _indicesContextEntity = new LinkedHashSet<E>();
                TableInfo _infoContextEntity = new TableInfo("ContextEntity", _columnsContextEntity, _foreignKeysContextEntity, _indicesContextEntity);
                TableInfo _existingContextEntity = TableInfo.Companion.read(connection, "ContextEntity");
                if (!_infoContextEntity.equals((Object)_existingContextEntity)) {
                    return new RoomOpenDelegate.ValidationResult(false, "ContextEntity(dev.brahmkshatriya.echo.download.db.models.ContextEntity).\n Expected:\n" + _infoContextEntity + "\n Found:\n" + _existingContextEntity);
                }
                Map _columnsDownloadEntity = new LinkedHashMap<K, V>();
                _columnsDownloadEntity.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                _columnsDownloadEntity.put("extensionId", new TableInfo.Column("extensionId", "TEXT", true, 0, null, 1));
                _columnsDownloadEntity.put("trackId", new TableInfo.Column("trackId", "TEXT", true, 0, null, 1));
                _columnsDownloadEntity.put("contextId", new TableInfo.Column("contextId", "INTEGER", false, 0, null, 1));
                _columnsDownloadEntity.put("sortOrder", new TableInfo.Column("sortOrder", "INTEGER", false, 0, null, 1));
                _columnsDownloadEntity.put("data", new TableInfo.Column("data", "TEXT", true, 0, null, 1));
                _columnsDownloadEntity.put("task", new TableInfo.Column("task", "TEXT", true, 0, null, 1));
                _columnsDownloadEntity.put("loaded", new TableInfo.Column("loaded", "INTEGER", true, 0, null, 1));
                _columnsDownloadEntity.put("folderPath", new TableInfo.Column("folderPath", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("streamableId", new TableInfo.Column("streamableId", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("indexesData", new TableInfo.Column("indexesData", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("toMergeFilesData", new TableInfo.Column("toMergeFilesData", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("toTagFile", new TableInfo.Column("toTagFile", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("finalFile", new TableInfo.Column("finalFile", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("exceptionFile", new TableInfo.Column("exceptionFile", "TEXT", false, 0, null, 1));
                _columnsDownloadEntity.put("fullyDownloaded", new TableInfo.Column("fullyDownloaded", "INTEGER", true, 0, null, 1));
                Set _foreignKeysDownloadEntity = new LinkedHashSet<E>();
                Set _indicesDownloadEntity = new LinkedHashSet<E>();
                TableInfo _infoDownloadEntity = new TableInfo("DownloadEntity", _columnsDownloadEntity, _foreignKeysDownloadEntity, _indicesDownloadEntity);
                TableInfo _existingDownloadEntity = TableInfo.Companion.read(connection, "DownloadEntity");
                if (!_infoDownloadEntity.equals((Object)_existingDownloadEntity)) {
                    return new RoomOpenDelegate.ValidationResult(false, "DownloadEntity(dev.brahmkshatriya.echo.download.db.models.DownloadEntity).\n Expected:\n" + _infoDownloadEntity + "\n Found:\n" + _existingDownloadEntity);
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
        String[] stringArray = new String[]{"ContextEntity", "DownloadEntity"};
        return new InvalidationTracker((RoomDatabase)this, _shadowTablesMap, _viewTables, stringArray);
    }

    public void clearAllTables() {
        String[] stringArray = new String[]{"ContextEntity", "DownloadEntity"};
        super.performClear(false, stringArray);
    }

    @NotNull
    protected Map<KClass<?>, List<KClass<?>>> getRequiredTypeConverterClasses() {
        Map _typeConvertersMap = new LinkedHashMap();
        _typeConvertersMap.put(Reflection.getOrCreateKotlinClass(DownloadDao.class), DownloadDao_Impl.Companion.getRequiredConverters());
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
    public DownloadDao downloadDao() {
        return (DownloadDao)this._downloadDao.getValue();
    }

    private static final DownloadDao_Impl _downloadDao$lambda$0(DownloadDatabase_Impl this$0) {
        return new DownloadDao_Impl(this$0);
    }

    public static final /* synthetic */ void access$internalInitInvalidationTracker(DownloadDatabase_Impl $this, SQLiteConnection connection) {
        $this.internalInitInvalidationTracker(connection);
    }
}

