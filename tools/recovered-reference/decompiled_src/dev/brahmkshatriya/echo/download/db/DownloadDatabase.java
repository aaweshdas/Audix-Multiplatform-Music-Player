/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  androidx.room.Database
 *  androidx.room.Room
 *  androidx.room.RoomDatabase
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.download.db;

import android.app.Application;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dev.brahmkshatriya.echo.download.db.DownloadDao;
import dev.brahmkshatriya.echo.download.db.models.ContextEntity;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "downloadDao", "Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "Companion", "app_debug"})
@Database(entities={ContextEntity.class, DownloadEntity.class}, version=8, exportSchema=false)
public abstract class DownloadDatabase
extends RoomDatabase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String DATABASE_NAME = "download-db";

    @NotNull
    public abstract DownloadDao downloadDao();

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDatabase$Companion;", "", "<init>", "()V", "DATABASE_NAME", "", "create", "Ldev/brahmkshatriya/echo/download/db/DownloadDatabase;", "app", "Landroid/app/Application;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DownloadDatabase create(@NotNull Application app) {
            Intrinsics.checkNotNullParameter((Object)app, (String)"app");
            return (DownloadDatabase)Room.databaseBuilder((Context)((Context)app), DownloadDatabase.class, (String)DownloadDatabase.DATABASE_NAME).fallbackToDestructiveMigration(true).build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

