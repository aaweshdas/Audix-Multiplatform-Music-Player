/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.common;

import dev.brahmkshatriya.echo.common.LyricsExtension;
import dev.brahmkshatriya.echo.common.MiscExtension;
import dev.brahmkshatriya.echo.common.MusicExtension;
import dev.brahmkshatriya.echo.common.TrackerExtension;
import dev.brahmkshatriya.echo.common.clients.ExtensionClient;
import dev.brahmkshatriya.echo.common.helpers.Injectable;
import dev.brahmkshatriya.echo.common.models.ExtensionType;
import dev.brahmkshatriya.echo.common.models.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@kotlin.Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011\u0082\u0001\u0004\u001d\u001e\u001f \u00a8\u0006!"}, d2={"Ldev/brahmkshatriya/echo/common/Extension;", "T", "Ldev/brahmkshatriya/echo/common/clients/ExtensionClient;", "", "metadata", "Ldev/brahmkshatriya/echo/common/models/Metadata;", "instance", "Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "<init>", "(Ldev/brahmkshatriya/echo/common/models/Metadata;Ldev/brahmkshatriya/echo/common/helpers/Injectable;)V", "getMetadata", "()Ldev/brahmkshatriya/echo/common/models/Metadata;", "getInstance", "()Ldev/brahmkshatriya/echo/common/helpers/Injectable;", "id", "", "getId", "()Ljava/lang/String;", "type", "Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "getType", "()Ldev/brahmkshatriya/echo/common/models/ExtensionType;", "isEnabled", "", "()Z", "name", "getName", "version", "getVersion", "Ldev/brahmkshatriya/echo/common/LyricsExtension;", "Ldev/brahmkshatriya/echo/common/MiscExtension;", "Ldev/brahmkshatriya/echo/common/MusicExtension;", "Ldev/brahmkshatriya/echo/common/TrackerExtension;", "common"})
public abstract sealed class Extension<T extends ExtensionClient>
permits LyricsExtension, MiscExtension, MusicExtension, TrackerExtension {
    @NotNull
    private final Metadata metadata;
    @NotNull
    private final Injectable<T> instance;

    private Extension(Metadata metadata2, Injectable<T> instance) {
        this.metadata = metadata2;
        this.instance = instance;
    }

    @NotNull
    public Metadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public Injectable<T> getInstance() {
        return this.instance;
    }

    @NotNull
    public final String getId() {
        return this.getMetadata().getId();
    }

    @NotNull
    public final ExtensionType getType() {
        return this.getMetadata().getType();
    }

    public final boolean isEnabled() {
        return this.getMetadata().isEnabled();
    }

    @NotNull
    public final String getName() {
        return this.getMetadata().getName();
    }

    @NotNull
    public final String getVersion() {
        return this.getMetadata().getVersion();
    }

    public /* synthetic */ Extension(Metadata metadata2, Injectable instance, DefaultConstructorMarker $constructor_marker) {
        this(metadata2, instance);
    }
}

