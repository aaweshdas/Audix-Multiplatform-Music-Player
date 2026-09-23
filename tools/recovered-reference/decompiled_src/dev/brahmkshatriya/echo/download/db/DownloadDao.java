/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.Dao
 *  androidx.room.Delete
 *  androidx.room.Insert
 *  androidx.room.Query
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlinx.coroutines.flow.Flow
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import dev.brahmkshatriya.echo.download.db.models.ContextEntity;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u0012H'J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0012H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H'\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/download/db/DownloadDao;", "", "insertContextEntity", "", "context", "Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "(Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDownloadEntity", "download", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "(Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadEntity", "trackId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContextEntity", "contextId", "(Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getContextFlow", "deleteDownloadEntity", "", "deleteContextEntity", "getDownloadsForContext", "id", "(Ljava/lang/Long;)Ljava/util/List;", "app_debug"})
@Dao
public interface DownloadDao {
    @Insert(onConflict=1)
    @Nullable
    public Object insertContextEntity(@NotNull ContextEntity var1, @NotNull Continuation<? super Long> var2);

    @Insert(onConflict=1)
    @Nullable
    public Object insertDownloadEntity(@NotNull DownloadEntity var1, @NotNull Continuation<? super Long> var2);

    @Query(value="SELECT * FROM DownloadEntity WHERE id = :trackId")
    @Nullable
    public Object getDownloadEntity(long var1, @NotNull Continuation<? super DownloadEntity> var3);

    @Query(value="SELECT * FROM ContextEntity WHERE id = :contextId")
    @Nullable
    public Object getContextEntity(@Nullable Long var1, @NotNull Continuation<? super ContextEntity> var2);

    @Query(value="SELECT * FROM DownloadEntity")
    @NotNull
    public Flow<List<DownloadEntity>> getDownloadsFlow();

    @Query(value="SELECT * FROM ContextEntity")
    @NotNull
    public Flow<List<ContextEntity>> getContextFlow();

    @Delete
    public void deleteDownloadEntity(@NotNull DownloadEntity var1);

    @Delete
    public void deleteContextEntity(@NotNull ContextEntity var1);

    @Query(value="SELECT * FROM DownloadEntity WHERE contextId = :id")
    @NotNull
    public List<DownloadEntity> getDownloadsForContext(@Nullable Long var1);
}

