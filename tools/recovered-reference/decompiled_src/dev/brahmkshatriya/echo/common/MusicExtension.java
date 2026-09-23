/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common;

import dev.brahmkshatriya.echo.common.Extension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.models.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u00c6\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Ldev/brahmkshatriya/echo/common/MusicExtension;", "Ldev/brahmkshatriya/echo/common/Extension;", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "instance", "Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "<init>", "(Ldev/brahmkshatriya/echo/common/models/Metadata;Ldev/brahmkshatriya/echo/common/helpers/Injectable;)V", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "getInstance", "()Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "common"})
public final class MusicExtension
extends Extension<ExtensionClient> {
    @NotNull
    private final Metadata metadata;
    @NotNull
    private final Injectable<ExtensionClient> instance;

    public MusicExtension(@NotNull Metadata metadata2, @NotNull Injectable<ExtensionClient> instance) {
        Intrinsics.checkNotNullParameter((Object)metadata2, (String)"metadata");
        Intrinsics.checkNotNullParameter(instance, (String)"instance");
        super(metadata2, instance, null);
        this.metadata = metadata2;
        this.instance = instance;
    }

    @Override
    @NotNull
    public Metadata getMetadata() {
        return this.metadata;
    }

    @Override
    @NotNull
    public Injectable<ExtensionClient> getInstance() {
        return this.instance;
    }

    @NotNull
    public final Metadata component1() {
        return this.metadata;
    }

    @NotNull
    public final Injectable<ExtensionClient> component2() {
        return this.instance;
    }

    @NotNull
    public final MusicExtension copy(@NotNull Metadata metadata2, @NotNull Injectable<ExtensionClient> instance) {
        Intrinsics.checkNotNullParameter((Object)metadata2, (String)"metadata");
        Intrinsics.checkNotNullParameter(instance, (String)"instance");
        return new MusicExtension(metadata2, instance);
    }

    public static /* synthetic */ MusicExtension copy$default(MusicExtension musicExtension, Metadata metadata2, Injectable injectable, int n, Object object) {
        if ((n & 1) != 0) {
            metadata2 = musicExtension.metadata;
        }
        if ((n & 2) != 0) {
            injectable = musicExtension.instance;
        }
        return musicExtension.copy(metadata2, injectable);
    }

    @NotNull
    public String toString() {
        return "MusicExtension(metadata=" + this.metadata + ", instance=" + this.instance + ")";
    }

    public int hashCode() {
        int result2 = this.metadata.hashCode();
        result2 = result2 * 31 + this.instance.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicExtension)) {
            return false;
        }
        MusicExtension musicExtension = (MusicExtension)other;
        if (!Intrinsics.areEqual((Object)this.metadata, (Object)musicExtension.metadata)) {
            return false;
        }
        return Intrinsics.areEqual(this.instance, musicExtension.instance);
    }
}

