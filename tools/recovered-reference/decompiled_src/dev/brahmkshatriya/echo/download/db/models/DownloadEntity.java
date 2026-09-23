/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.Entity
 *  androidx.room.PrimaryKey
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.EnumsKt
 *  kotlinx.serialization.internal.IntSerializer
 *  kotlinx.serialization.internal.LongSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  kotlinx.serialization.internal.StringSerializer
 *  kotlinx.serialization.json.Json
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.download.db.models.DownloadEntity$;
import dev.brahmkshatriya.echo.download.db.models.TaskType;
import dev.brahmkshatriya.echo.ui.common.ExceptionUtils;
import dev.brahmkshatriya.echo.utils.Serializer;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0002ijB\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u00b5\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0017\u0010\u001cJ\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0005H\u00c6\u0003J\t\u0010M\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010#J\u0010\u0010O\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010&J\t\u0010P\u001a\u00020\u0005H\u00c6\u0003J\t\u0010Q\u001a\u00020\fH\u00c6\u0003J\t\u0010R\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010Z\u001a\u00020\u000eH\u00c6\u0003J\u00c0\u0001\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010\\J\u0013\u0010]\u001a\u00020\u000e2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010_\u001a\u00020\tH\u00d6\u0001J\t\u0010`\u001a\u00020\u0005H\u00d6\u0001J%\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0001\u00a2\u0006\u0002\bhR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u0011\u0010\u0016\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010,R!\u00105\u001a\b\u0012\u0004\u0012\u000207068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R!\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0=8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010;\u001a\u0004\b>\u0010?R!\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050=8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bB\u0010?R\u001d\u0010D\u001a\u0004\u0018\u00010E8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010;\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bI\u0010,\u00a8\u0006k"}, d2={"Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "", "id", "", "extensionId", "", "trackId", "contextId", "sortOrder", "", "data", "task", "Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "loaded", "", "folderPath", "streamableId", "indexesData", "toMergeFilesData", "toTagFile", "finalFile", "exceptionFile", "fullyDownloaded", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ldev/brahmkshatriya/echo/download/db/models/TaskType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ldev/brahmkshatriya/echo/download/db/models/TaskType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()J", "getExtensionId", "()Ljava/lang/String;", "getTrackId", "getContextId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "getTask", "()Ldev/brahmkshatriya/echo/download/db/models/TaskType;", "getLoaded", "()Z", "getFolderPath", "getStreamableId", "getIndexesData", "getToMergeFilesData", "getToTagFile", "getFinalFile", "getExceptionFile", "getFullyDownloaded", "track", "Lkotlin/Result;", "Ldev/brahmkshatriya/echo/common/models/Track;", "getTrack-d1pmJ48", "()Ljava/lang/Object;", "track$delegate", "Lkotlin/Lazy;", "indexes", "", "getIndexes", "()Ljava/util/List;", "indexes$delegate", "toMergeFiles", "getToMergeFiles", "toMergeFiles$delegate", "exception", "Ldev/brahmkshatriya/echo/ui/common/ExceptionUtils$Data;", "getException", "()Ldev/brahmkshatriya/echo/ui/common/ExceptionUtils$Data;", "exception$delegate", "isFinal", "isFinal$delegate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ldev/brahmkshatriya/echo/download/db/models/TaskType;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_debug", "$serializer", "Companion", "app_debug"})
@Entity
@SourceDebugExtension(value={"SMAP\nDownloadEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadEntity.kt\ndev/brahmkshatriya/echo/download/db/models/DownloadEntity\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n13#2,2:42\n15#2,3:45\n13#2,2:48\n15#2,3:51\n13#2,2:54\n15#2,3:57\n13#2,2:61\n15#2,3:64\n15#2,3:67\n13#2,2:70\n15#2,3:73\n13#2,2:76\n15#2,3:79\n13#2,2:82\n15#2,3:85\n222#3:44\n222#3:50\n222#3:56\n222#3:63\n222#3:72\n222#3:78\n222#3:84\n1#4:60\n*S KotlinDebug\n*F\n+ 1 DownloadEntity.kt\ndev/brahmkshatriya/echo/download/db/models/DownloadEntity\n*L\n32#1:42,2\n32#1:45,3\n33#1:48,2\n33#1:51,3\n34#1:54,2\n34#1:57,3\n37#1:61,2\n37#1:64,3\n32#1:67,3\n33#1:70,2\n33#1:73,3\n34#1:76,2\n34#1:79,3\n37#1:82,2\n37#1:85,3\n32#1:44\n33#1:50\n34#1:56\n37#1:63\n33#1:72\n34#1:78\n37#1:84\n*E\n"})
public final class DownloadEntity {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @PrimaryKey(autoGenerate=true)
    private final long id;
    @NotNull
    private final String extensionId;
    @NotNull
    private final String trackId;
    @Nullable
    private final Long contextId;
    @Nullable
    private final Integer sortOrder;
    @NotNull
    private final String data;
    @NotNull
    private final TaskType task;
    private final boolean loaded;
    @Nullable
    private final String folderPath;
    @Nullable
    private final String streamableId;
    @Nullable
    private final String indexesData;
    @Nullable
    private final String toMergeFilesData;
    @Nullable
    private final String toTagFile;
    @Nullable
    private final String finalFile;
    @Nullable
    private final String exceptionFile;
    private final boolean fullyDownloaded;
    @NotNull
    private final Lazy track$delegate;
    @NotNull
    private final Lazy indexes$delegate;
    @NotNull
    private final Lazy toMergeFiles$delegate;
    @NotNull
    private final Lazy exception$delegate;
    @NotNull
    private final Lazy isFinal$delegate;
    @JvmField
    @NotNull
    private static final Lazy<KSerializer<Object>>[] $childSerializers;

    public DownloadEntity(long id2, @NotNull String extensionId, @NotNull String trackId, @Nullable Long contextId, @Nullable Integer sortOrder, @NotNull String data2, @NotNull TaskType task, boolean loaded, @Nullable String folderPath, @Nullable String streamableId, @Nullable String indexesData, @Nullable String toMergeFilesData, @Nullable String toTagFile, @Nullable String finalFile, @Nullable String exceptionFile, boolean fullyDownloaded) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)((Object)task), (String)"task");
        this.id = id2;
        this.extensionId = extensionId;
        this.trackId = trackId;
        this.contextId = contextId;
        this.sortOrder = sortOrder;
        this.data = data2;
        this.task = task;
        this.loaded = loaded;
        this.folderPath = folderPath;
        this.streamableId = streamableId;
        this.indexesData = indexesData;
        this.toMergeFilesData = toMergeFilesData;
        this.toTagFile = toTagFile;
        this.finalFile = finalFile;
        this.exceptionFile = exceptionFile;
        this.fullyDownloaded = fullyDownloaded;
        this.track$delegate = LazyKt.lazy(() -> DownloadEntity.track_delegate$lambda$0(this));
        this.indexes$delegate = LazyKt.lazy(() -> DownloadEntity.indexes_delegate$lambda$1(this));
        this.toMergeFiles$delegate = LazyKt.lazy(() -> DownloadEntity.toMergeFiles_delegate$lambda$2(this));
        this.exception$delegate = LazyKt.lazy(() -> DownloadEntity.exception_delegate$lambda$5(this));
        this.isFinal$delegate = LazyKt.lazy(() -> DownloadEntity.isFinal_delegate$lambda$6(this));
    }

    public /* synthetic */ DownloadEntity(long l, String string2, String string3, Long l2, Integer n, String string4, TaskType taskType, boolean bl, String string5, String string6, String string7, String string8, String string9, String string10, String string11, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 0x10) != 0) {
            n = null;
        }
        if ((n2 & 0x80) != 0) {
            bl = false;
        }
        if ((n2 & 0x100) != 0) {
            string5 = null;
        }
        if ((n2 & 0x200) != 0) {
            string6 = null;
        }
        if ((n2 & 0x400) != 0) {
            string7 = null;
        }
        if ((n2 & 0x800) != 0) {
            string8 = null;
        }
        if ((n2 & 0x1000) != 0) {
            string9 = null;
        }
        if ((n2 & 0x2000) != 0) {
            string10 = null;
        }
        if ((n2 & 0x4000) != 0) {
            string11 = null;
        }
        if ((n2 & 0x8000) != 0) {
            bl2 = false;
        }
        this(l, string2, string3, l2, n, string4, taskType, bl, string5, string6, string7, string8, string9, string10, string11, bl2);
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getExtensionId() {
        return this.extensionId;
    }

    @NotNull
    public final String getTrackId() {
        return this.trackId;
    }

    @Nullable
    public final Long getContextId() {
        return this.contextId;
    }

    @Nullable
    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final TaskType getTask() {
        return this.task;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    @Nullable
    public final String getFolderPath() {
        return this.folderPath;
    }

    @Nullable
    public final String getStreamableId() {
        return this.streamableId;
    }

    @Nullable
    public final String getIndexesData() {
        return this.indexesData;
    }

    @Nullable
    public final String getToMergeFilesData() {
        return this.toMergeFilesData;
    }

    @Nullable
    public final String getToTagFile() {
        return this.toTagFile;
    }

    @Nullable
    public final String getFinalFile() {
        return this.finalFile;
    }

    @Nullable
    public final String getExceptionFile() {
        return this.exceptionFile;
    }

    public final boolean getFullyDownloaded() {
        return this.fullyDownloaded;
    }

    @NotNull
    public final Object getTrack-d1pmJ48() {
        Lazy lazy = this.track$delegate;
        return ((Result)lazy.getValue()).unbox-impl();
    }

    @NotNull
    public final List<Integer> getIndexes() {
        Lazy lazy = this.indexes$delegate;
        return (List)lazy.getValue();
    }

    @NotNull
    public final List<String> getToMergeFiles() {
        Lazy lazy = this.toMergeFiles$delegate;
        return (List)lazy.getValue();
    }

    @Nullable
    public final ExceptionUtils.Data getException() {
        Lazy lazy = this.exception$delegate;
        return (ExceptionUtils.Data)lazy.getValue();
    }

    public final boolean isFinal() {
        Lazy lazy = this.isFinal$delegate;
        return (Boolean)lazy.getValue();
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.extensionId;
    }

    @NotNull
    public final String component3() {
        return this.trackId;
    }

    @Nullable
    public final Long component4() {
        return this.contextId;
    }

    @Nullable
    public final Integer component5() {
        return this.sortOrder;
    }

    @NotNull
    public final String component6() {
        return this.data;
    }

    @NotNull
    public final TaskType component7() {
        return this.task;
    }

    public final boolean component8() {
        return this.loaded;
    }

    @Nullable
    public final String component9() {
        return this.folderPath;
    }

    @Nullable
    public final String component10() {
        return this.streamableId;
    }

    @Nullable
    public final String component11() {
        return this.indexesData;
    }

    @Nullable
    public final String component12() {
        return this.toMergeFilesData;
    }

    @Nullable
    public final String component13() {
        return this.toTagFile;
    }

    @Nullable
    public final String component14() {
        return this.finalFile;
    }

    @Nullable
    public final String component15() {
        return this.exceptionFile;
    }

    public final boolean component16() {
        return this.fullyDownloaded;
    }

    @NotNull
    public final DownloadEntity copy(long id2, @NotNull String extensionId, @NotNull String trackId, @Nullable Long contextId, @Nullable Integer sortOrder, @NotNull String data2, @NotNull TaskType task, boolean loaded, @Nullable String folderPath, @Nullable String streamableId, @Nullable String indexesData, @Nullable String toMergeFilesData, @Nullable String toTagFile, @Nullable String finalFile, @Nullable String exceptionFile, boolean fullyDownloaded) {
        Intrinsics.checkNotNullParameter((Object)extensionId, (String)"extensionId");
        Intrinsics.checkNotNullParameter((Object)trackId, (String)"trackId");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)((Object)task), (String)"task");
        return new DownloadEntity(id2, extensionId, trackId, contextId, sortOrder, data2, task, loaded, folderPath, streamableId, indexesData, toMergeFilesData, toTagFile, finalFile, exceptionFile, fullyDownloaded);
    }

    public static /* synthetic */ DownloadEntity copy$default(DownloadEntity downloadEntity, long l, String string2, String string3, Long l2, Integer n, String string4, TaskType taskType, boolean bl, String string5, String string6, String string7, String string8, String string9, String string10, String string11, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l = downloadEntity.id;
        }
        if ((n2 & 2) != 0) {
            string2 = downloadEntity.extensionId;
        }
        if ((n2 & 4) != 0) {
            string3 = downloadEntity.trackId;
        }
        if ((n2 & 8) != 0) {
            l2 = downloadEntity.contextId;
        }
        if ((n2 & 0x10) != 0) {
            n = downloadEntity.sortOrder;
        }
        if ((n2 & 0x20) != 0) {
            string4 = downloadEntity.data;
        }
        if ((n2 & 0x40) != 0) {
            taskType = downloadEntity.task;
        }
        if ((n2 & 0x80) != 0) {
            bl = downloadEntity.loaded;
        }
        if ((n2 & 0x100) != 0) {
            string5 = downloadEntity.folderPath;
        }
        if ((n2 & 0x200) != 0) {
            string6 = downloadEntity.streamableId;
        }
        if ((n2 & 0x400) != 0) {
            string7 = downloadEntity.indexesData;
        }
        if ((n2 & 0x800) != 0) {
            string8 = downloadEntity.toMergeFilesData;
        }
        if ((n2 & 0x1000) != 0) {
            string9 = downloadEntity.toTagFile;
        }
        if ((n2 & 0x2000) != 0) {
            string10 = downloadEntity.finalFile;
        }
        if ((n2 & 0x4000) != 0) {
            string11 = downloadEntity.exceptionFile;
        }
        if ((n2 & 0x8000) != 0) {
            bl2 = downloadEntity.fullyDownloaded;
        }
        return downloadEntity.copy(l, string2, string3, l2, n, string4, taskType, bl, string5, string6, string7, string8, string9, string10, string11, bl2);
    }

    @NotNull
    public String toString() {
        return "DownloadEntity(id=" + this.id + ", extensionId=" + this.extensionId + ", trackId=" + this.trackId + ", contextId=" + this.contextId + ", sortOrder=" + this.sortOrder + ", data=" + this.data + ", task=" + this.task + ", loaded=" + this.loaded + ", folderPath=" + this.folderPath + ", streamableId=" + this.streamableId + ", indexesData=" + this.indexesData + ", toMergeFilesData=" + this.toMergeFilesData + ", toTagFile=" + this.toTagFile + ", finalFile=" + this.finalFile + ", exceptionFile=" + this.exceptionFile + ", fullyDownloaded=" + this.fullyDownloaded + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.id);
        result2 = result2 * 31 + this.extensionId.hashCode();
        result2 = result2 * 31 + this.trackId.hashCode();
        result2 = result2 * 31 + (this.contextId == null ? 0 : ((Object)this.contextId).hashCode());
        result2 = result2 * 31 + (this.sortOrder == null ? 0 : ((Object)this.sortOrder).hashCode());
        result2 = result2 * 31 + this.data.hashCode();
        result2 = result2 * 31 + this.task.hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.loaded);
        result2 = result2 * 31 + (this.folderPath == null ? 0 : this.folderPath.hashCode());
        result2 = result2 * 31 + (this.streamableId == null ? 0 : this.streamableId.hashCode());
        result2 = result2 * 31 + (this.indexesData == null ? 0 : this.indexesData.hashCode());
        result2 = result2 * 31 + (this.toMergeFilesData == null ? 0 : this.toMergeFilesData.hashCode());
        result2 = result2 * 31 + (this.toTagFile == null ? 0 : this.toTagFile.hashCode());
        result2 = result2 * 31 + (this.finalFile == null ? 0 : this.finalFile.hashCode());
        result2 = result2 * 31 + (this.exceptionFile == null ? 0 : this.exceptionFile.hashCode());
        result2 = result2 * 31 + Boolean.hashCode(this.fullyDownloaded);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadEntity)) {
            return false;
        }
        DownloadEntity downloadEntity = (DownloadEntity)other;
        if (this.id != downloadEntity.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.extensionId, (Object)downloadEntity.extensionId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.trackId, (Object)downloadEntity.trackId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.contextId, (Object)downloadEntity.contextId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.sortOrder, (Object)downloadEntity.sortOrder)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.data, (Object)downloadEntity.data)) {
            return false;
        }
        if (this.task != downloadEntity.task) {
            return false;
        }
        if (this.loaded != downloadEntity.loaded) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.folderPath, (Object)downloadEntity.folderPath)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.streamableId, (Object)downloadEntity.streamableId)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.indexesData, (Object)downloadEntity.indexesData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.toMergeFilesData, (Object)downloadEntity.toMergeFilesData)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.toTagFile, (Object)downloadEntity.toTagFile)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.finalFile, (Object)downloadEntity.finalFile)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.exceptionFile, (Object)downloadEntity.exceptionFile)) {
            return false;
        }
        return this.fullyDownloaded == downloadEntity.fullyDownloaded;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_debug(DownloadEntity self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.extensionId);
        output.encodeStringElement(serialDesc, 2, self.trackId);
        output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)LongSerializer.INSTANCE, (Object)self.contextId);
        if (output.shouldEncodeElementDefault(serialDesc, 4) ? true : self.sortOrder != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy)IntSerializer.INSTANCE, (Object)self.sortOrder);
        }
        output.encodeStringElement(serialDesc, 5, self.data);
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy)lazyArray[6].getValue(), (Object)self.task);
        if (output.shouldEncodeElementDefault(serialDesc, 7) ? true : self.loaded) {
            output.encodeBooleanElement(serialDesc, 7, self.loaded);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) ? true : self.folderPath != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.folderPath);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) ? true : self.streamableId != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.streamableId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) ? true : self.indexesData != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.indexesData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) ? true : self.toMergeFilesData != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.toMergeFilesData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) ? true : self.toTagFile != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.toTagFile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) ? true : self.finalFile != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.finalFile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) ? true : self.exceptionFile != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, (SerializationStrategy)StringSerializer.INSTANCE, (Object)self.exceptionFile);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) ? true : self.fullyDownloaded) {
            output.encodeBooleanElement(serialDesc, 15, self.fullyDownloaded);
        }
    }

    public /* synthetic */ DownloadEntity(int seen0, long id2, String extensionId, String trackId, Long contextId, Integer sortOrder, String data2, TaskType task, boolean loaded, String folderPath, String streamableId, String indexesData, String toMergeFilesData, String toTagFile, String finalFile, String exceptionFile, boolean fullyDownloaded, SerializationConstructorMarker serializationConstructorMarker) {
        if (111 != (0x6F & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)111, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.id = id2;
        this.extensionId = extensionId;
        this.trackId = trackId;
        this.contextId = contextId;
        this.sortOrder = (seen0 & 0x10) == 0 ? null : sortOrder;
        this.data = data2;
        this.task = task;
        this.loaded = (seen0 & 0x80) == 0 ? false : loaded;
        this.folderPath = (seen0 & 0x100) == 0 ? null : folderPath;
        this.streamableId = (seen0 & 0x200) == 0 ? null : streamableId;
        this.indexesData = (seen0 & 0x400) == 0 ? null : indexesData;
        this.toMergeFilesData = (seen0 & 0x800) == 0 ? null : toMergeFilesData;
        this.toTagFile = (seen0 & 0x1000) == 0 ? null : toTagFile;
        this.finalFile = (seen0 & 0x2000) == 0 ? null : finalFile;
        this.exceptionFile = (seen0 & 0x4000) == 0 ? null : exceptionFile;
        this.fullyDownloaded = (seen0 & 0x8000) == 0 ? false : fullyDownloaded;
        this.track$delegate = LazyKt.lazy(() -> DownloadEntity._init_$lambda$7(this));
        this.indexes$delegate = LazyKt.lazy(() -> DownloadEntity._init_$lambda$8(this));
        this.toMergeFiles$delegate = LazyKt.lazy(() -> DownloadEntity._init_$lambda$9(this));
        this.exception$delegate = LazyKt.lazy(() -> DownloadEntity._init_$lambda$12(this));
        this.isFinal$delegate = LazyKt.lazy(() -> DownloadEntity._init_$lambda$13(this));
    }

    /*
     * WARNING - void declaration
     */
    private static final Result track_delegate$lambda$0(DownloadEntity this$0) {
        Object object;
        Object object2;
        Serializer serializer2 = Serializer.INSTANCE;
        String string2 = this$0.data;
        boolean bl = false;
        Object object3 = string2;
        try {
            void this_\3;
            String string3 = object3;
            boolean bl2 = false;
            Json json = Serializer.INSTANCE.getJson();
            String string4 = string3;
            boolean bl3 = false;
            this_\3.getSerializersModule();
            object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)Track.Companion.serializer(), string4));
        }
        catch (Throwable throwable) {
            object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object3 = object2;
        object2 = Result.exceptionOrNull-impl((Object)object3);
        if (object2 == null) {
            object = object3;
        } else {
            Object object4 = object3;
            try {
                Object object5 = object2;
                boolean bl4 = false;
                throw new Serializer.DecodingException(string2, (Throwable)object5);
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
        }
        return Result.box-impl((Object)object);
    }

    /*
     * WARNING - void declaration
     */
    private static final List indexes_delegate$lambda$1(DownloadEntity this$0) {
        List list2;
        List list3;
        String string2 = this$0.indexesData;
        if (string2 != null) {
            Object object;
            Object object2;
            Serializer serializer2 = Serializer.INSTANCE;
            String string3 = string2;
            boolean bl = false;
            Object object3 = string3;
            try {
                void this_\3;
                String string4 = object3;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string5 = string4;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)new ArrayListSerializer((KSerializer)IntSerializer.INSTANCE), string5));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object3 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object3);
            if (object2 == null) {
                object = object3;
            } else {
                Object object4 = object3;
                try {
                    Object object5 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string3, (Throwable)object5);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            Object object6 = object;
            list3 = (List)(Result.isFailure-impl((Object)object6) ? null : object6);
        } else {
            list3 = list2 = null;
        }
        if (list3 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return list2;
    }

    /*
     * WARNING - void declaration
     */
    private static final List toMergeFiles_delegate$lambda$2(DownloadEntity this$0) {
        List list2;
        List list3;
        String string2 = this$0.toMergeFilesData;
        if (string2 != null) {
            Object object;
            Object object2;
            Serializer serializer2 = Serializer.INSTANCE;
            String string3 = string2;
            boolean bl = false;
            Object object3 = string3;
            try {
                void this_\3;
                String string4 = object3;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string5 = string4;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), string5));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object3 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object3);
            if (object2 == null) {
                object = object3;
            } else {
                Object object4 = object3;
                try {
                    Object object5 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string3, (Throwable)object5);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            Object object6 = object;
            list3 = (List)(Result.isFailure-impl((Object)object6) ? null : object6);
        } else {
            list3 = list2 = null;
        }
        if (list3 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return list2;
    }

    /*
     * Unable to fully structure code
     */
    private static final ExceptionUtils.Data exception_delegate$lambda$5(DownloadEntity this$0) {
        var1_1 = this$0;
        try {
            $this$exception_delegate_u24lambda_u245_u24lambda_u244\1 = var1_1;
            $i$a$-runCatching-DownloadEntity$exception$2$1\1\36\0 = false;
            var4_5 = $this$exception_delegate_u24lambda_u245_u24lambda_u244\1.exceptionFile;
            if (var4_5 == null) ** GOTO lbl-1000
            it\2 = var4_5;
            $i$a$-let-DownloadEntity$exception$2$1$1\2\37\1 = false;
            var7_9 = FilesKt.readText$default((File)new File(it\2), null, (int)1, null);
            if (var7_9 != null) {
                $i$a$-let-DownloadEntity$exception$2$1$1\2\37\1 = Serializer.INSTANCE;
                $this$toData_u2dIoAF18A\3 = var7_9;
                $i$f$toData-IoAF18A\3\37 = false;
                var10_12 = $this$toData_u2dIoAF18A\3;
                try {
                    $this$toData_IoAF18A_u24lambda_u241\4 = var10_12;
                    $i$a$-runCatching-Serializer$toData$1\4\61\3 = false;
                    var13_17 = Serializer.INSTANCE.getJson();
                    string\5 = $this$toData_IoAF18A_u24lambda_u241\4;
                    $i$f$decodeFromString\5\62 = false;
                    this_\5.getSerializersModule();
                    var11_13 = Result.constructor-impl((Object)this_\5.decodeFromString((DeserializationStrategy)ExceptionUtils.Data.Companion.serializer(), string\5));
                }
                catch (Throwable var12_15) {
                    var11_13 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var12_15));
                }
                var10_12 = var11_13;
                var11_13 = Result.exceptionOrNull-impl((Object)var10_12);
                if (var11_13 == null) {
                    v0 = var10_12;
                } else {
                    var12_16 = var10_12;
                    try {
                        it\6 = var11_13;
                        $i$a$-recoverCatching-Serializer$toData$2\6\64\3 = false;
                        throw new Serializer.DecodingException($this$toData_u2dIoAF18A\3, (Throwable)it\6);
                    }
                    catch (Throwable var14_20) {
                        v0 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var14_20));
                    }
                }
                var6_8 = v0;
                ResultKt.throwOnFailure((Object)var6_8);
                v1 = (ExceptionUtils.Data)var6_8;
            } else lbl-1000:
            // 2 sources

            {
                v1 = null;
            }
            var2_2 = Result.constructor-impl(v1);
        }
        catch (Throwable var3_4) {
            var2_2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var3_4));
        }
        var1_1 = var2_2;
        return (ExceptionUtils.Data)(Result.isFailure-impl((Object)var1_1) != false ? null : var1_1);
    }

    private static final boolean isFinal_delegate$lambda$6(DownloadEntity this$0) {
        return this$0.finalFile != null || this$0.exceptionFile != null;
    }

    /*
     * WARNING - void declaration
     */
    private static final Result _init_$lambda$7(DownloadEntity this$0) {
        Object object;
        Object object2;
        Serializer serializer2 = Serializer.INSTANCE;
        String string2 = this$0.data;
        boolean bl = false;
        Object object3 = string2;
        try {
            void this_\3;
            String string3 = object3;
            boolean bl2 = false;
            Json json = Serializer.INSTANCE.getJson();
            String string4 = string3;
            boolean bl3 = false;
            this_\3.getSerializersModule();
            object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)Track.Companion.serializer(), string4));
        }
        catch (Throwable throwable) {
            object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        object3 = object2;
        object2 = Result.exceptionOrNull-impl((Object)object3);
        if (object2 == null) {
            object = object3;
        } else {
            Object object4 = object3;
            try {
                Object object5 = object2;
                boolean bl4 = false;
                throw new Serializer.DecodingException(string2, (Throwable)object5);
            }
            catch (Throwable throwable) {
                object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
        }
        return Result.box-impl((Object)object);
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$8(DownloadEntity this$0) {
        List list2;
        List list3;
        String string2 = this$0.indexesData;
        if (string2 != null) {
            Object object;
            Object object2;
            Serializer serializer2 = Serializer.INSTANCE;
            String string3 = string2;
            boolean bl = false;
            Object object3 = string3;
            try {
                void this_\3;
                String string4 = object3;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string5 = string4;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)new ArrayListSerializer((KSerializer)IntSerializer.INSTANCE), string5));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object3 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object3);
            if (object2 == null) {
                object = object3;
            } else {
                Object object4 = object3;
                try {
                    Object object5 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string3, (Throwable)object5);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            Object object6 = object;
            list3 = (List)(Result.isFailure-impl((Object)object6) ? null : object6);
        } else {
            list3 = list2 = null;
        }
        if (list3 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return list2;
    }

    /*
     * WARNING - void declaration
     */
    private static final List _init_$lambda$9(DownloadEntity this$0) {
        List list2;
        List list3;
        String string2 = this$0.toMergeFilesData;
        if (string2 != null) {
            Object object;
            Object object2;
            Serializer serializer2 = Serializer.INSTANCE;
            String string3 = string2;
            boolean bl = false;
            Object object3 = string3;
            try {
                void this_\3;
                String string4 = object3;
                boolean bl2 = false;
                Json json = Serializer.INSTANCE.getJson();
                String string5 = string4;
                boolean bl3 = false;
                this_\3.getSerializersModule();
                object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)new ArrayListSerializer((KSerializer)StringSerializer.INSTANCE), string5));
            }
            catch (Throwable throwable) {
                object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
            }
            object3 = object2;
            object2 = Result.exceptionOrNull-impl((Object)object3);
            if (object2 == null) {
                object = object3;
            } else {
                Object object4 = object3;
                try {
                    Object object5 = object2;
                    boolean bl4 = false;
                    throw new Serializer.DecodingException(string3, (Throwable)object5);
                }
                catch (Throwable throwable) {
                    object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
                }
            }
            Object object6 = object;
            list3 = (List)(Result.isFailure-impl((Object)object6) ? null : object6);
        } else {
            list3 = list2 = null;
        }
        if (list3 == null) {
            list2 = CollectionsKt.emptyList();
        }
        return list2;
    }

    /*
     * Unable to fully structure code
     */
    private static final ExceptionUtils.Data _init_$lambda$12(DownloadEntity this$0) {
        var1_1 = this$0;
        try {
            $this$_init__u24lambda_u2412_u24lambda_u2411\1 = var1_1;
            $i$a$-runCatching-DownloadEntity$exception$2$1\1\36\0 = false;
            var4_5 = $this$_init__u24lambda_u2412_u24lambda_u2411\1.exceptionFile;
            if (var4_5 == null) ** GOTO lbl-1000
            it\2 = var4_5;
            $i$a$-let-DownloadEntity$exception$2$1$1\2\37\1 = false;
            var7_9 = FilesKt.readText$default((File)new File(it\2), null, (int)1, null);
            if (var7_9 != null) {
                $i$a$-let-DownloadEntity$exception$2$1$1\2\37\1 = Serializer.INSTANCE;
                $this$toData_u2dIoAF18A\3 = var7_9;
                $i$f$toData-IoAF18A\3\37 = false;
                var10_12 = $this$toData_u2dIoAF18A\3;
                try {
                    $this$toData_IoAF18A_u24lambda_u241\4 = var10_12;
                    $i$a$-runCatching-Serializer$toData$1\4\82\3 = false;
                    var13_17 = Serializer.INSTANCE.getJson();
                    string\5 = $this$toData_IoAF18A_u24lambda_u241\4;
                    $i$f$decodeFromString\5\83 = false;
                    this_\5.getSerializersModule();
                    var11_13 = Result.constructor-impl((Object)this_\5.decodeFromString((DeserializationStrategy)ExceptionUtils.Data.Companion.serializer(), string\5));
                }
                catch (Throwable var12_15) {
                    var11_13 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var12_15));
                }
                var10_12 = var11_13;
                var11_13 = Result.exceptionOrNull-impl((Object)var10_12);
                if (var11_13 == null) {
                    v0 = var10_12;
                } else {
                    var12_16 = var10_12;
                    try {
                        it\6 = var11_13;
                        $i$a$-recoverCatching-Serializer$toData$2\6\85\3 = false;
                        throw new Serializer.DecodingException($this$toData_u2dIoAF18A\3, (Throwable)it\6);
                    }
                    catch (Throwable var14_20) {
                        v0 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var14_20));
                    }
                }
                var6_8 = v0;
                ResultKt.throwOnFailure((Object)var6_8);
                v1 = (ExceptionUtils.Data)var6_8;
            } else lbl-1000:
            // 2 sources

            {
                v1 = null;
            }
            var2_2 = Result.constructor-impl(v1);
        }
        catch (Throwable var3_4) {
            var2_2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)var3_4));
        }
        var1_1 = var2_2;
        return (ExceptionUtils.Data)(Result.isFailure-impl((Object)var1_1) != false ? null : var1_1);
    }

    private static final boolean _init_$lambda$13(DownloadEntity this$0) {
        return this$0.finalFile != null || this$0.exceptionFile != null;
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    static {
        Lazy[] lazyArray = new Lazy[]{null, null, null, null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> EnumsKt.createSimpleEnumSerializer((String)"dev.brahmkshatriya.echo.download.db.models.TaskType", (Enum[])TaskType.values())), null, null, null, null, null, null, null, null, null};
        $childSerializers = lazyArray;
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/download/db/models/DownloadEntity;", "app_debug"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<DownloadEntity> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

