/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.LazyThreadSafetyMode
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.SpillingKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.KSerializer
 *  kotlinx.serialization.Serializable
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.descriptors.SerialDescriptor
 *  kotlinx.serialization.encoding.CompositeEncoder
 *  kotlinx.serialization.internal.ArrayListSerializer
 *  kotlinx.serialization.internal.PluginExceptionsKt
 *  kotlinx.serialization.internal.SerializationConstructorMarker
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.models;

import dev.brahmkshatriya.echo.common.helpers.PagedData;
import dev.brahmkshatriya.echo.common.models.Feed;
import dev.brahmkshatriya.echo.common.models.Feed$Buttons$;
import dev.brahmkshatriya.echo.common.models.ImageHolder;
import dev.brahmkshatriya.echo.common.models.Tab;
import dev.brahmkshatriya.echo.common.models.Track;
import dev.brahmkshatriya.echo.common.models.Track$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u0000  *\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0003\u001e\u001f BA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012*\u0010\u0006\u001a&\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00c6\u0003J2\u0010\u0014\u001a&\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u000fJR\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042,\b\u0002\u0010\u0006\u001a&\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR7\u0010\u0006\u001a&\b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r\u00a8\u0006!"}, d2={"Ldev/brahmkshatriya/echo/common/models/Feed;", "T", "", "tabs", "", "Ldev/brahmkshatriya/echo/common/models/Tab;", "getPagedData", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Ldev/brahmkshatriya/echo/common/models/Feed$Data;", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getTabs", "()Ljava/util/List;", "getGetPagedData", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "notSortTabs", "getNotSortTabs", "component1", "component2", "copy", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ldev/brahmkshatriya/echo/common/models/Feed;", "equals", "", "other", "hashCode", "", "toString", "", "Data", "Buttons", "Companion", "common"})
@SourceDebugExtension(value={"SMAP\nFeed.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Feed.kt\ndev/brahmkshatriya/echo/common/models/Feed\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n827#2:159\n855#2,2:160\n*S KotlinDebug\n*F\n+ 1 Feed.kt\ndev/brahmkshatriya/echo/common/models/Feed\n*L\n72#1:159\n72#1:160,2\n*E\n"})
public final class Feed<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Tab> tabs;
    @NotNull
    private final Function2<Tab, Continuation<? super Data<T>>, Object> getPagedData;
    @NotNull
    private final List<Tab> notSortTabs;

    /*
     * WARNING - void declaration
     */
    public Feed(@NotNull List<Tab> tabs, @NotNull Function2<? super Tab, ? super Continuation<? super Data<T>>, ? extends Object> getPagedData) {
        void $this$filterNotTo$iv$iv;
        void $this$filterNot$iv;
        Intrinsics.checkNotNullParameter(tabs, (String)"tabs");
        Intrinsics.checkNotNullParameter(getPagedData, (String)"getPagedData");
        this.tabs = tabs;
        this.getPagedData = getPagedData;
        Iterable iterable = this.tabs;
        Feed feed2 = this;
        boolean $i$f$filterNot = false;
        void var5_6 = $this$filterNot$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterNotTo = false;
        for (Object element$iv$iv : $this$filterNotTo$iv$iv) {
            Tab it = (Tab)element$iv$iv;
            boolean bl = false;
            if (it.isSort()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        feed2.notSortTabs = (List)destination$iv$iv;
    }

    @NotNull
    public final List<Tab> getTabs() {
        return this.tabs;
    }

    @NotNull
    public final Function2<Tab, Continuation<? super Data<T>>, Object> getGetPagedData() {
        return this.getPagedData;
    }

    @NotNull
    public final List<Tab> getNotSortTabs() {
        return this.notSortTabs;
    }

    @NotNull
    public final List<Tab> component1() {
        return this.tabs;
    }

    @NotNull
    public final Function2<Tab, Continuation<? super Data<T>>, Object> component2() {
        return this.getPagedData;
    }

    @NotNull
    public final Feed<T> copy(@NotNull List<Tab> tabs, @NotNull Function2<? super Tab, ? super Continuation<? super Data<T>>, ? extends Object> getPagedData) {
        Intrinsics.checkNotNullParameter(tabs, (String)"tabs");
        Intrinsics.checkNotNullParameter(getPagedData, (String)"getPagedData");
        return new Feed<T>(tabs, getPagedData);
    }

    public static /* synthetic */ Feed copy$default(Feed feed2, List list2, Function2 function2, int n, Object object) {
        if ((n & 1) != 0) {
            list2 = feed2.tabs;
        }
        if ((n & 2) != 0) {
            function2 = feed2.getPagedData;
        }
        return feed2.copy(list2, function2);
    }

    @NotNull
    public String toString() {
        return "Feed(tabs=" + this.tabs + ", getPagedData=" + this.getPagedData + ")";
    }

    public int hashCode() {
        int result2 = ((Object)this.tabs).hashCode();
        result2 = result2 * 31 + this.getPagedData.hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Feed)) {
            return false;
        }
        Feed feed2 = (Feed)other;
        if (!Intrinsics.areEqual(this.tabs, feed2.tabs)) {
            return false;
        }
        return Intrinsics.areEqual(this.getPagedData, feed2.getPagedData);
    }

    @Serializable
    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J9\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\fH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001\u00a2\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006*"}, d2={"Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "", "showSearch", "", "showSort", "showPlayAndShuffle", "customTrackList", "", "Ldev/brahmkshatriya/echo/common/models/Track;", "<init>", "(ZZZLjava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZZZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowSearch", "()Z", "getShowSort", "getShowPlayAndShuffle", "getCustomTrackList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Companion", "$serializer", "common"})
    public static final class Buttons {
        @NotNull
        public static final Companion Companion = new Companion(null);
        private final boolean showSearch;
        private final boolean showSort;
        private final boolean showPlayAndShuffle;
        @Nullable
        private final List<Track> customTrackList;
        @JvmField
        @NotNull
        private static final Lazy<KSerializer<Object>>[] $childSerializers;
        @NotNull
        private static final Buttons EMPTY;

        public Buttons(boolean showSearch, boolean showSort, boolean showPlayAndShuffle, @Nullable List<Track> customTrackList) {
            this.showSearch = showSearch;
            this.showSort = showSort;
            this.showPlayAndShuffle = showPlayAndShuffle;
            this.customTrackList = customTrackList;
        }

        public /* synthetic */ Buttons(boolean bl, boolean bl2, boolean bl3, List list2, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 1) != 0) {
                bl = true;
            }
            if ((n & 2) != 0) {
                bl2 = true;
            }
            if ((n & 4) != 0) {
                bl3 = false;
            }
            if ((n & 8) != 0) {
                list2 = null;
            }
            this(bl, bl2, bl3, list2);
        }

        public final boolean getShowSearch() {
            return this.showSearch;
        }

        public final boolean getShowSort() {
            return this.showSort;
        }

        public final boolean getShowPlayAndShuffle() {
            return this.showPlayAndShuffle;
        }

        @Nullable
        public final List<Track> getCustomTrackList() {
            return this.customTrackList;
        }

        public final boolean component1() {
            return this.showSearch;
        }

        public final boolean component2() {
            return this.showSort;
        }

        public final boolean component3() {
            return this.showPlayAndShuffle;
        }

        @Nullable
        public final List<Track> component4() {
            return this.customTrackList;
        }

        @NotNull
        public final Buttons copy(boolean showSearch, boolean showSort, boolean showPlayAndShuffle, @Nullable List<Track> customTrackList) {
            return new Buttons(showSearch, showSort, showPlayAndShuffle, customTrackList);
        }

        public static /* synthetic */ Buttons copy$default(Buttons buttons2, boolean bl, boolean bl2, boolean bl3, List list2, int n, Object object) {
            if ((n & 1) != 0) {
                bl = buttons2.showSearch;
            }
            if ((n & 2) != 0) {
                bl2 = buttons2.showSort;
            }
            if ((n & 4) != 0) {
                bl3 = buttons2.showPlayAndShuffle;
            }
            if ((n & 8) != 0) {
                list2 = buttons2.customTrackList;
            }
            return buttons2.copy(bl, bl2, bl3, list2);
        }

        @NotNull
        public String toString() {
            return "Buttons(showSearch=" + this.showSearch + ", showSort=" + this.showSort + ", showPlayAndShuffle=" + this.showPlayAndShuffle + ", customTrackList=" + this.customTrackList + ")";
        }

        public int hashCode() {
            int result2 = Boolean.hashCode(this.showSearch);
            result2 = result2 * 31 + Boolean.hashCode(this.showSort);
            result2 = result2 * 31 + Boolean.hashCode(this.showPlayAndShuffle);
            result2 = result2 * 31 + (this.customTrackList == null ? 0 : ((Object)this.customTrackList).hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Buttons)) {
                return false;
            }
            Buttons buttons2 = (Buttons)other;
            if (this.showSearch != buttons2.showSearch) {
                return false;
            }
            if (this.showSort != buttons2.showSort) {
                return false;
            }
            if (this.showPlayAndShuffle != buttons2.showPlayAndShuffle) {
                return false;
            }
            return Intrinsics.areEqual(this.customTrackList, buttons2.customTrackList);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$common(Buttons self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArray = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) ? true : !self.showSearch) {
                output.encodeBooleanElement(serialDesc, 0, self.showSearch);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) ? true : !self.showSort) {
                output.encodeBooleanElement(serialDesc, 1, self.showSort);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) ? true : self.showPlayAndShuffle) {
                output.encodeBooleanElement(serialDesc, 2, self.showPlayAndShuffle);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) ? true : self.customTrackList != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy)lazyArray[3].getValue(), self.customTrackList);
            }
        }

        public /* synthetic */ Buttons(int seen0, boolean showSearch, boolean showSort, boolean showPlayAndShuffle, List customTrackList, SerializationConstructorMarker serializationConstructorMarker) {
            if ((0 & seen0) != 0) {
                PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)0, (SerialDescriptor)Buttons$$serializer.INSTANCE.getDescriptor());
            }
            this.showSearch = (seen0 & 1) == 0 ? true : showSearch;
            this.showSort = (seen0 & 2) == 0 ? true : showSort;
            this.showPlayAndShuffle = (seen0 & 4) == 0 ? false : showPlayAndShuffle;
            this.customTrackList = (seen0 & 8) == 0 ? null : customTrackList;
        }

        public Buttons() {
            this(false, false, false, null, 15, null);
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        static {
            Lazy[] lazyArray = new Lazy[]{null, null, null, LazyKt.lazy((LazyThreadSafetyMode)LazyThreadSafetyMode.PUBLICATION, () -> (KSerializer)new ArrayListSerializer((KSerializer)Track$.serializer.INSTANCE))};
            $childSerializers = lazyArray;
            EMPTY = new Buttons(false, false, false, null);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/common/models/Feed$Buttons$Companion;", "", "<init>", "()V", "EMPTY", "Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "getEMPTY", "()Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "serializer", "Lkotlinx/serialization/KSerializer;", "common"})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final Buttons getEMPTY() {
                return EMPTY;
            }

            @NotNull
            public final KSerializer<Buttons> serializer() {
                return (KSerializer)Buttons$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ8\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ8\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ8\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\r\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\rH\u0086@\u00a2\u0006\u0002\u0010\u0010J(\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0007\"\b\b\u0001\u0010\u0006*\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00060\rH\u0086@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2={"Ldev/brahmkshatriya/echo/common/models/Feed$Companion;", "", "<init>", "()V", "toFeedData", "Ldev/brahmkshatriya/echo/common/models/Feed$Data;", "T", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "buttons", "Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "background", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "toFeed", "Ldev/brahmkshatriya/echo/common/models/Feed;", "", "loadAll", "(Ldev/brahmkshatriya/echo/common/models/Feed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pagedDataOfFirst", "common"})
    @SourceDebugExtension(value={"SMAP\nFeed.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Feed.kt\ndev/brahmkshatriya/echo/common/models/Feed$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,158:1\n1374#2:159\n1460#2,5:160\n*S KotlinDebug\n*F\n+ 1 Feed.kt\ndev/brahmkshatriya/echo/common/models/Feed$Companion\n*L\n148#1:159\n148#1:160,5\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T> Data<T> toFeedData(@NotNull PagedData<T> $this$toFeedData, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter($this$toFeedData, (String)"<this>");
            return new Data<T>($this$toFeedData, buttons2, background2);
        }

        public static /* synthetic */ Data toFeedData$default(Companion companion, PagedData pagedData2, Buttons buttons2, ImageHolder imageHolder, int n, Object object) {
            if ((n & 1) != 0) {
                buttons2 = null;
            }
            if ((n & 2) != 0) {
                imageHolder = null;
            }
            return companion.toFeedData(pagedData2, buttons2, imageHolder);
        }

        @NotNull
        public final <T> Feed<T> toFeed(@NotNull PagedData<T> $this$toFeed, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter($this$toFeed, (String)"<this>");
            return new Feed(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Data<T>>, Object>($this$toFeed, buttons2, background2, null){
                int label;
                final /* synthetic */ PagedData<T> $this_toFeed;
                final /* synthetic */ Buttons $buttons;
                final /* synthetic */ ImageHolder $background;
                {
                    this.$this_toFeed = $receiver;
                    this.$buttons = $buttons;
                    this.$background = $background;
                    super(2, $completion);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            return Feed.Companion.toFeedData(this.$this_toFeed, this.$buttons, this.$background);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Tab p1, Continuation<? super Data<T>> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        public static /* synthetic */ Feed toFeed$default(Companion companion, PagedData pagedData2, Buttons buttons2, ImageHolder imageHolder, int n, Object object) {
            if ((n & 1) != 0) {
                buttons2 = null;
            }
            if ((n & 2) != 0) {
                imageHolder = null;
            }
            return companion.toFeed(pagedData2, buttons2, imageHolder);
        }

        @NotNull
        public final <T> Data<T> toFeedData(@NotNull List<? extends T> $this$toFeedData, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter($this$toFeedData, (String)"<this>");
            return new Data(new PagedData.Single((Function1)new Function1<Continuation<? super List<? extends T>>, Object>($this$toFeedData, null){
                int label;
                final /* synthetic */ List<T> $this_toFeedData;
                {
                    this.$this_toFeedData = $receiver;
                    super(1, $completion);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            return this.$this_toFeedData;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Continuation<? super List<? extends T>> p1) {
                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                }
            }), buttons2, background2);
        }

        public static /* synthetic */ Data toFeedData$default(Companion companion, List list2, Buttons buttons2, ImageHolder imageHolder, int n, Object object) {
            if ((n & 1) != 0) {
                buttons2 = null;
            }
            if ((n & 2) != 0) {
                imageHolder = null;
            }
            return companion.toFeedData(list2, buttons2, imageHolder);
        }

        @NotNull
        public final <T> Feed<T> toFeed(@NotNull List<? extends T> $this$toFeed, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter($this$toFeed, (String)"<this>");
            return new Feed(CollectionsKt.emptyList(), (Function2)new Function2<Tab, Continuation<? super Data<T>>, Object>(buttons2, background2, $this$toFeed, null){
                int label;
                final /* synthetic */ Buttons $buttons;
                final /* synthetic */ ImageHolder $background;
                final /* synthetic */ List<T> $this_toFeed;
                {
                    this.$buttons = $buttons;
                    this.$background = $background;
                    this.$this_toFeed = $receiver;
                    super(2, $completion);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0: {
                            ResultKt.throwOnFailure((Object)$result);
                            return Feed.Companion.toFeedData(new PagedData.Single<T>((Function1)new Function1<Continuation<? super List<? extends T>>, Object>(this.$this_toFeed, null){
                                int label;
                                final /* synthetic */ List<T> $this_toFeed;
                                {
                                    this.$this_toFeed = $receiver;
                                    super(1, $completion);
                                }

                                public final Object invokeSuspend(Object $result) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0: {
                                            ResultKt.throwOnFailure((Object)$result);
                                            return this.$this_toFeed;
                                        }
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }

                                public final Continuation<Unit> create(Continuation<?> $completion) {
                                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                                }

                                public final Object invoke(Continuation<? super List<? extends T>> p1) {
                                    return (this.create(p1)).invokeSuspend(Unit.INSTANCE);
                                }
                            }), this.$buttons, this.$background);
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Continuation<Unit> create(Object value2, Continuation<?> $completion) {
                    return (Continuation)new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(Tab p1, Continuation<? super Data<T>> p2) {
                    return (this.create(p1, p2)).invokeSuspend(Unit.INSTANCE);
                }
            });
        }

        public static /* synthetic */ Feed toFeed$default(Companion companion, List list2, Buttons buttons2, ImageHolder imageHolder, int n, Object object) {
            if ((n & 1) != 0) {
                buttons2 = null;
            }
            if ((n & 2) != 0) {
                imageHolder = null;
            }
            return companion.toFeed(list2, buttons2, imageHolder);
        }

        /*
         * Unable to fully structure code
         */
        @Nullable
        public final <T> Object loadAll(@NotNull Feed<T> $this$loadAll, @NotNull Continuation<? super List<? extends T>> $completion) {
            block14: {
                if (!($completion instanceof loadAll.1)) ** GOTO lbl-1000
                var15_3 = $completion;
                if ((var15_3.label & -2147483648) != 0) {
                    var15_3.label -= -2147483648;
                } else lbl-1000:
                // 2 sources

                {
                    $continuation = new ContinuationImpl(this, $completion){
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
                        int I$0;
                        int I$1;
                        int I$2;
                        int I$3;
                        /* synthetic */ Object result;
                        final /* synthetic */ Companion this$0;
                        int label;
                        {
                            this.this$0 = this$0;
                            super($completion);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object $result) {
                            this.result = $result;
                            this.label |= Integer.MIN_VALUE;
                            return this.this$0.loadAll(null, (Continuation)this);
                        }
                    };
                }
                $result = $continuation.result;
                var16_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0: {
                        ResultKt.throwOnFailure((Object)$result);
                        $this$loadAll_u24lambda_u241 = $this$loadAll;
                        $i$a$-run-Feed$Companion$loadAll$2 = 0;
                        if (!$this$loadAll_u24lambda_u241.getTabs().isEmpty()) break;
                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll_u24lambda_u241);
                        $continuation.I$0 = $i$a$-run-Feed$Companion$loadAll$2;
                        $continuation.label = 1;
                        v0 = Feed.Companion.pagedDataOfFirst($this$loadAll_u24lambda_u241, (Continuation<? super PagedData<T>>)$continuation);
                        if (v0 == var16_5) {
                            return var16_5;
                        }
                        ** GOTO lbl29
                    }
                    case 1: {
                        $i$a$-run-Feed$Companion$loadAll$2 = $continuation.I$0;
                        $this$loadAll_u24lambda_u241 = (Feed)$continuation.L$1;
                        $this$loadAll = (Feed)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v0 = $result;
lbl29:
                        // 2 sources

                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll);
                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll_u24lambda_u241);
                        $continuation.I$0 = $i$a$-run-Feed$Companion$loadAll$2;
                        $continuation.label = 2;
                        v1 = ((PagedData)v0).loadAll($continuation);
                        if (v1 == var16_5) {
                            return var16_5;
                        }
                        ** GOTO lbl43
                    }
                    case 2: {
                        $i$a$-run-Feed$Companion$loadAll$2 = $continuation.I$0;
                        $this$loadAll_u24lambda_u241 = (Feed)$continuation.L$1;
                        $this$loadAll = (Feed)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v1 = $result;
lbl43:
                        // 2 sources

                        v2 = (List)v1;
                        break block14;
                    }
                }
                $this$flatMap$iv = $this$loadAll_u24lambda_u241.getNotSortTabs();
                $i$f$flatMap = 0;
                var7_12 = $this$flatMap$iv;
                destination$iv$iv = new ArrayList<E>();
                $i$f$flatMapTo = 0;
                var10_15 = $this$flatMapTo$iv$iv.iterator();
lbl51:
                // 2 sources

                while (var10_15.hasNext()) {
                    element$iv$iv = var10_15.next();
                    it = (Tab)element$iv$iv;
                    $i$a$-flatMap-Feed$Companion$loadAll$2$1 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll);
                    $continuation.L$1 = $this$loadAll_u24lambda_u241;
                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMap$iv);
                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMapTo$iv$iv);
                    $continuation.L$4 = destination$iv$iv;
                    $continuation.L$5 = var10_15;
                    $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)element$iv$iv);
                    $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)it);
                    $continuation.I$0 = $i$a$-run-Feed$Companion$loadAll$2;
                    $continuation.I$1 = $i$f$flatMap;
                    $continuation.I$2 = $i$f$flatMapTo;
                    $continuation.I$3 = $i$a$-flatMap-Feed$Companion$loadAll$2$1;
                    $continuation.label = 3;
                    v3 = $this$loadAll_u24lambda_u241.getGetPagedData().invoke((Object)it, $continuation);
                    if (v3 == var16_5) {
                        return var16_5;
                    }
                    ** GOTO lbl88
                }
                {
                    break;
                    case 3: {
                        $i$a$-flatMap-Feed$Companion$loadAll$2$1 = $continuation.I$3;
                        $i$f$flatMapTo = $continuation.I$2;
                        $i$f$flatMap = $continuation.I$1;
                        $i$a$-run-Feed$Companion$loadAll$2 = $continuation.I$0;
                        it = (Tab)$continuation.L$7;
                        element$iv$iv = $continuation.L$6;
                        var10_15 = (Iterator<T>)$continuation.L$5;
                        destination$iv$iv = (Collection)$continuation.L$4;
                        $this$flatMapTo$iv$iv = (Iterable)$continuation.L$3;
                        $this$flatMap$iv = (Iterable)$continuation.L$2;
                        $this$loadAll_u24lambda_u241 = (Feed)$continuation.L$1;
                        $this$loadAll = (Feed)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v3 = $result;
lbl88:
                        // 2 sources

                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$loadAll);
                        $continuation.L$1 = $this$loadAll_u24lambda_u241;
                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMap$iv);
                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable((Object)$this$flatMapTo$iv$iv);
                        $continuation.L$4 = destination$iv$iv;
                        $continuation.L$5 = var10_15;
                        $continuation.L$6 = SpillingKt.nullOutSpilledVariable((Object)element$iv$iv);
                        $continuation.L$7 = SpillingKt.nullOutSpilledVariable((Object)it);
                        $continuation.I$0 = $i$a$-run-Feed$Companion$loadAll$2;
                        $continuation.I$1 = $i$f$flatMap;
                        $continuation.I$2 = $i$f$flatMapTo;
                        $continuation.I$3 = $i$a$-flatMap-Feed$Companion$loadAll$2$1;
                        $continuation.label = 4;
                        v4 = ((Data)v3).getPagedData().loadAll($continuation);
                        if (v4 == var16_5) {
                            return var16_5;
                        }
                        ** GOTO lbl120
                    }
                    case 4: {
                        $i$a$-flatMap-Feed$Companion$loadAll$2$1 = $continuation.I$3;
                        $i$f$flatMapTo = $continuation.I$2;
                        $i$f$flatMap = $continuation.I$1;
                        $i$a$-run-Feed$Companion$loadAll$2 = $continuation.I$0;
                        it = (Tab)$continuation.L$7;
                        element$iv$iv = $continuation.L$6;
                        var10_15 = (Iterator)$continuation.L$5;
                        destination$iv$iv = (Collection)$continuation.L$4;
                        $this$flatMapTo$iv$iv = (Iterable)$continuation.L$3;
                        $this$flatMap$iv = (Iterable)$continuation.L$2;
                        $this$loadAll_u24lambda_u241 = (Feed)$continuation.L$1;
                        $this$loadAll = (Feed)$continuation.L$0;
                        ResultKt.throwOnFailure((Object)$result);
                        v4 = $result;
lbl120:
                        // 2 sources

                        list$iv$iv = (Iterable)v4;
                        CollectionsKt.addAll((Collection)destination$iv$iv, (Iterable)list$iv$iv);
                        ** GOTO lbl51
                    }
                }
                v2 = (List)destination$iv$iv;
            }
            return v2;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /*
         * Unable to fully structure code
         */
        @Nullable
        public final <T> Object pagedDataOfFirst(@NotNull Feed<T> $this$pagedDataOfFirst, @NotNull Continuation<? super PagedData<T>> $completion) {
            if (!($completion instanceof pagedDataOfFirst.1)) ** GOTO lbl-1000
            var6_3 = $completion;
            if ((var6_3.label & -2147483648) != 0) {
                var6_3.label -= -2147483648;
            } else lbl-1000:
            // 2 sources

            {
                $continuation = new ContinuationImpl(this, $completion){
                    Object L$0;
                    Object L$1;
                    int I$0;
                    /* synthetic */ Object result;
                    final /* synthetic */ Companion this$0;
                    int label;
                    {
                        this.this$0 = this$0;
                        super($completion);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object $result) {
                        this.result = $result;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.pagedDataOfFirst(null, (Continuation)this);
                    }
                };
            }
            $result = $continuation.result;
            var7_5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch ($continuation.label) {
                case 0: {
                    ResultKt.throwOnFailure((Object)$result);
                    $this$pagedDataOfFirst_u24lambda_u242 = $this$pagedDataOfFirst;
                    $i$a$-run-Feed$Companion$pagedDataOfFirst$2 = 0;
                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable((Object)$this$pagedDataOfFirst);
                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable((Object)$this$pagedDataOfFirst_u24lambda_u242);
                    $continuation.I$0 = $i$a$-run-Feed$Companion$pagedDataOfFirst$2;
                    $continuation.label = 1;
                    v0 = $this$pagedDataOfFirst_u24lambda_u242.getGetPagedData().invoke(CollectionsKt.firstOrNull($this$pagedDataOfFirst_u24lambda_u242.getNotSortTabs()), $continuation);
                    if (v0 == var7_5) {
                        return var7_5;
                    }
                    ** GOTO lbl29
                }
                case 1: {
                    $i$a$-run-Feed$Companion$pagedDataOfFirst$2 = $continuation.I$0;
                    $this$pagedDataOfFirst_u24lambda_u242 = (Feed)$continuation.L$1;
                    $this$pagedDataOfFirst = (Feed)$continuation.L$0;
                    ResultKt.throwOnFailure((Object)$result);
                    v0 = $result;
lbl29:
                    // 2 sources

                    return ((Data)v0).getPagedData();
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0002B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u00c6\u0003J7\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2={"Ldev/brahmkshatriya/echo/common/models/Feed$Data;", "T", "", "pagedData", "Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "buttons", "Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "background", "Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "<init>", "(Ldev/brahmkshatriya/echo/common/helpers/PagedData;Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;Ldev/brahmkshatriya/echo/common/models/ImageHolder;)V", "getPagedData", "()Ldev/brahmkshatriya/echo/common/helpers/PagedData;", "getButtons", "()Ldev/brahmkshatriya/echo/common/models/Feed$Buttons;", "getBackground", "()Ldev/brahmkshatriya/echo/common/models/ImageHolder;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common"})
    public static final class Data<T> {
        @NotNull
        private final PagedData<T> pagedData;
        @Nullable
        private final Buttons buttons;
        @Nullable
        private final ImageHolder background;

        public Data(@NotNull PagedData<T> pagedData2, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter(pagedData2, (String)"pagedData");
            this.pagedData = pagedData2;
            this.buttons = buttons2;
            this.background = background2;
        }

        public /* synthetic */ Data(PagedData pagedData2, Buttons buttons2, ImageHolder imageHolder, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                buttons2 = null;
            }
            if ((n & 4) != 0) {
                imageHolder = null;
            }
            this(pagedData2, buttons2, imageHolder);
        }

        @NotNull
        public final PagedData<T> getPagedData() {
            return this.pagedData;
        }

        @Nullable
        public final Buttons getButtons() {
            return this.buttons;
        }

        @Nullable
        public final ImageHolder getBackground() {
            return this.background;
        }

        @NotNull
        public final PagedData<T> component1() {
            return this.pagedData;
        }

        @Nullable
        public final Buttons component2() {
            return this.buttons;
        }

        @Nullable
        public final ImageHolder component3() {
            return this.background;
        }

        @NotNull
        public final Data<T> copy(@NotNull PagedData<T> pagedData2, @Nullable Buttons buttons2, @Nullable ImageHolder background2) {
            Intrinsics.checkNotNullParameter(pagedData2, (String)"pagedData");
            return new Data<T>(pagedData2, buttons2, background2);
        }

        public static /* synthetic */ Data copy$default(Data data2, PagedData pagedData2, Buttons buttons2, ImageHolder imageHolder, int n, Object object) {
            if ((n & 1) != 0) {
                pagedData2 = data2.pagedData;
            }
            if ((n & 2) != 0) {
                buttons2 = data2.buttons;
            }
            if ((n & 4) != 0) {
                imageHolder = data2.background;
            }
            return data2.copy(pagedData2, buttons2, imageHolder);
        }

        @NotNull
        public String toString() {
            return "Data(pagedData=" + this.pagedData + ", buttons=" + this.buttons + ", background=" + this.background + ")";
        }

        public int hashCode() {
            int result2 = this.pagedData.hashCode();
            result2 = result2 * 31 + (this.buttons == null ? 0 : this.buttons.hashCode());
            result2 = result2 * 31 + (this.background == null ? 0 : this.background.hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data2 = (Data)other;
            if (!Intrinsics.areEqual(this.pagedData, data2.pagedData)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.buttons, (Object)data2.buttons)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.background, (Object)data2.background);
        }
    }
}

