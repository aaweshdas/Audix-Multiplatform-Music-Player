/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.models.Progress$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001\u00a2\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006%"}, d2={"Ldev/brahmkshatriya/echo/common/models/Progress;", "", "size", "", "progress", "speed", "<init>", "(JJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSize", "()J", "getProgress", "getSpeed", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "$serializer", "Companion", "common"})
public final class Progress {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long size;
    private final long progress;
    private final long speed;

    public Progress(long size, long progress, long speed) {
        this.size = size;
        this.progress = progress;
        this.speed = speed;
    }

    public /* synthetic */ Progress(long l, long l2, long l3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            l = 0L;
        }
        if ((n & 2) != 0) {
            l2 = 0L;
        }
        if ((n & 4) != 0) {
            l3 = 0L;
        }
        this(l, l2, l3);
    }

    public final long getSize() {
        return this.size;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final long getSpeed() {
        return this.speed;
    }

    public final long component1() {
        return this.size;
    }

    public final long component2() {
        return this.progress;
    }

    public final long component3() {
        return this.speed;
    }

    @NotNull
    public final Progress copy(long size, long progress, long speed) {
        return new Progress(size, progress, speed);
    }

    public static /* synthetic */ Progress copy$default(Progress progress, long l, long l2, long l3, int n, Object object) {
        if ((n & 1) != 0) {
            l = progress.size;
        }
        if ((n & 2) != 0) {
            l2 = progress.progress;
        }
        if ((n & 4) != 0) {
            l3 = progress.speed;
        }
        return progress.copy(l, l2, l3);
    }

    @NotNull
    public String toString() {
        return "Progress(size=" + this.size + ", progress=" + this.progress + ", speed=" + this.speed + ")";
    }

    public int hashCode() {
        int result2 = Long.hashCode(this.size);
        result2 = result2 * 31 + Long.hashCode(this.progress);
        result2 = result2 * 31 + Long.hashCode(this.speed);
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Progress)) {
            return false;
        }
        Progress progress = (Progress)other;
        if (this.size != progress.size) {
            return false;
        }
        if (this.progress != progress.progress) {
            return false;
        }
        return this.speed == progress.speed;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Progress self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : self.size != 0L) {
            output.encodeLongElement(serialDesc, 0, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : self.progress != 0L) {
            output.encodeLongElement(serialDesc, 1, self.progress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.speed != 0L) {
            output.encodeLongElement(serialDesc, 2, self.speed);
        }
    }

    public /* synthetic */ Progress(int seen0, long size, long progress, long speed, SerializationConstructorMarker serializationConstructorMarker) {
        if ((0 & seen0) != 0) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.size = (seen0 & 1) == 0 ? 0L : size;
        this.progress = (seen0 & 2) == 0 ? 0L : progress;
        this.speed = (seen0 & 4) == 0 ? 0L : speed;
    }

    public Progress() {
        this(0L, 0L, 0L, 7, null);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2={"Ldev/brahmkshatriya/echo/common/models/Progress$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldev/brahmkshatriya/echo/common/models/Progress;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KSerializer<Progress> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

