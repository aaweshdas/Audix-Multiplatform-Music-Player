/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.room.Entity
 *  androidx.room.PrimaryKey
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.json.Json
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.download.db.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import dev.brahmkshatriya.echo.common.models.EchoMediaItem;
import dev.brahmkshatriya.echo.utils.Serializer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2={"Ldev/brahmkshatriya/echo/download/db/models/ContextEntity;", "", "id", "", "itemId", "", "data", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getItemId", "()Ljava/lang/String;", "getData", "mediaItem", "Lkotlin/Result;", "Ldev/brahmkshatriya/echo/common/models/EchoMediaItem;", "getMediaItem-d1pmJ48", "()Ljava/lang/Object;", "mediaItem$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@Entity
@SourceDebugExtension(value={"SMAP\nContextEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextEntity.kt\ndev/brahmkshatriya/echo/download/db/models/ContextEntity\n+ 2 Serializer.kt\ndev/brahmkshatriya/echo/utils/Serializer\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,17:1\n13#2,2:18\n15#2,3:21\n222#3:20\n*S KotlinDebug\n*F\n+ 1 ContextEntity.kt\ndev/brahmkshatriya/echo/download/db/models/ContextEntity\n*L\n15#1:18,2\n15#1:21,3\n15#1:20\n*E\n"})
public final class ContextEntity {
    @PrimaryKey(autoGenerate=true)
    private final long id;
    @NotNull
    private final String itemId;
    @NotNull
    private final String data;
    @NotNull
    private final Lazy mediaItem$delegate;

    public ContextEntity(long id2, @NotNull String itemId, @NotNull String data2) {
        Intrinsics.checkNotNullParameter((Object)itemId, (String)"itemId");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        this.id = id2;
        this.itemId = itemId;
        this.data = data2;
        this.mediaItem$delegate = LazyKt.lazy(() -> ContextEntity.mediaItem_delegate$lambda$0(this));
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    @NotNull
    public final Object getMediaItem-d1pmJ48() {
        Lazy lazy = this.mediaItem$delegate;
        return ((Result)lazy.getValue()).unbox-impl();
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.itemId;
    }

    @NotNull
    public final String component3() {
        return this.data;
    }

    @NotNull
    public final ContextEntity copy(long id2, @NotNull String itemId, @NotNull String data2) {
        Intrinsics.checkNotNullParameter((Object)itemId, (String)"itemId");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        return new ContextEntity(id2, itemId, data2);
    }

    public static /* synthetic */ ContextEntity copy$default(ContextEntity contextEntity, long l, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            l = contextEntity.id;
        }
        if ((n & 2) != 0) {
            string2 = contextEntity.itemId;
        }
        if ((n & 4) != 0) {
            string3 = contextEntity.data;
        }
        return contextEntity.copy(l, string2, string3);
    }

    @NotNull
    public String toString() {
        return "ContextEntity(id=" + this.id + ", itemId=" + this.itemId + ", data=" + this.data + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.id);
        result2 = result2 * 31 + this.itemId.hashCode();
        result2 = result2 * 31 + this.data.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContextEntity)) {
            return false;
        }
        ContextEntity contextEntity = (ContextEntity)other;
        if (this.id != contextEntity.id) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.itemId, (Object)contextEntity.itemId)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.data, (Object)contextEntity.data);
    }

    /*
     * WARNING - void declaration
     */
    private static final Result mediaItem_delegate$lambda$0(ContextEntity this$0) {
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
            object2 = Result.constructor-impl((Object)this_\3.decodeFromString((DeserializationStrategy)EchoMediaItem.Companion.serializer(), string4));
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
}

