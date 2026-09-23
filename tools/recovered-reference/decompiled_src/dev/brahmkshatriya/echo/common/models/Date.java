/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
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

import dev.brahmkshatriya.echo.common.models.Date$;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00000\u0001:\u000267B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0004\u0010\nB#\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0004\u0010\u000eJ\u0011\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0000H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010%\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0007H\u00d6\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001\u00a2\u0006\u0002\b5R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\u001f\u0010 R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b\"\u0010 \u00a8\u00068"}, d2={"Ldev/brahmkshatriya/echo/common/models/Date;", "", "epochTimeMs", "", "<init>", "(J)V", "year", "", "month", "day", "(ILjava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEpochTimeMs", "()J", "calendar", "Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "calendar$delegate", "Lkotlin/Lazy;", "date", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", "date$delegate", "getYear", "()I", "year$delegate", "getMonth", "()Ljava/lang/Integer;", "month$delegate", "getDay", "day$delegate", "compareTo", "other", "toString", "", "component1", "copy", "equals", "", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$common", "Companion", "$serializer", "common"})
public final class Date
implements Comparable<Date> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long epochTimeMs;
    @NotNull
    private final Lazy calendar$delegate;
    @NotNull
    private final Lazy date$delegate;
    @NotNull
    private final Lazy year$delegate;
    @NotNull
    private final Lazy month$delegate;
    @NotNull
    private final Lazy day$delegate;

    public Date(long epochTimeMs) {
        this.epochTimeMs = epochTimeMs;
        this.calendar$delegate = LazyKt.lazy(() -> Date.calendar_delegate$lambda$1(this));
        this.date$delegate = LazyKt.lazy(() -> Date.date_delegate$lambda$2(this));
        this.year$delegate = LazyKt.lazy(() -> Date.year_delegate$lambda$4(this));
        this.month$delegate = LazyKt.lazy(() -> Date.month_delegate$lambda$5(this));
        this.day$delegate = LazyKt.lazy(() -> Date.day_delegate$lambda$6(this));
    }

    public final long getEpochTimeMs() {
        return this.epochTimeMs;
    }

    @NotNull
    public final Calendar getCalendar() {
        Lazy lazy = this.calendar$delegate;
        return (Calendar)lazy.getValue();
    }

    @NotNull
    public final java.util.Date getDate() {
        Lazy lazy = this.date$delegate;
        return (java.util.Date)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    public Date(int year, @Nullable Integer month, @Nullable Integer day) {
        void $this$_init__u24lambda_u243;
        Calendar calendar;
        Calendar calendar2 = calendar = Calendar.getInstance();
        Date date = this;
        boolean bl = false;
        Integer n = month;
        Integer n2 = day;
        $this$_init__u24lambda_u243.set(year, (n != null ? n : 1) - 1, n2 != null ? n2 : 1);
        date(calendar.getTimeInMillis());
    }

    public /* synthetic */ Date(int n, Integer n2, Integer n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n4 & 2) != 0) {
            n2 = null;
        }
        if ((n4 & 4) != 0) {
            n3 = null;
        }
        this(n, n2, n3);
    }

    public final int getYear() {
        Lazy lazy = this.year$delegate;
        return ((Number)lazy.getValue()).intValue();
    }

    @Nullable
    public final Integer getMonth() {
        Lazy lazy = this.month$delegate;
        return (Integer)lazy.getValue();
    }

    @Nullable
    public final Integer getDay() {
        Lazy lazy = this.day$delegate;
        return (Integer)lazy.getValue();
    }

    @Override
    public int compareTo(@NotNull Date other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return this.getDate().compareTo(other.getDate());
    }

    @NotNull
    public String toString() {
        String string2;
        if (this.getMonth() == null || this.getDay() == null) {
            string2 = String.valueOf(this.getYear());
        } else {
            String string3 = DateFormat.getDateInstance(3, Locale.getDefault()).format(this.getDate());
            string2 = string3;
            Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"format(...)");
        }
        return string2;
    }

    public final long component1() {
        return this.epochTimeMs;
    }

    @NotNull
    public final Date copy(long epochTimeMs) {
        return new Date(epochTimeMs);
    }

    public static /* synthetic */ Date copy$default(Date date, long l, int n, Object object) {
        if ((n & 1) != 0) {
            l = date.epochTimeMs;
        }
        return date.copy(l);
    }

    public int hashCode() {
        return Long.hashCode(this.epochTimeMs);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Date)) {
            return false;
        }
        Date date = (Date)other;
        return this.epochTimeMs == date.epochTimeMs;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$common(Date self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.epochTimeMs);
    }

    public /* synthetic */ Date(int seen0, long epochTimeMs, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (1 & seen0)) {
            PluginExceptionsKt.throwMissingFieldException((int)seen0, (int)1, (SerialDescriptor)$serializer.INSTANCE.getDescriptor());
        }
        this.epochTimeMs = epochTimeMs;
        this.calendar$delegate = LazyKt.lazy(() -> Date._init_$lambda$8(this));
        this.date$delegate = LazyKt.lazy(() -> Date._init_$lambda$9(this));
        this.year$delegate = LazyKt.lazy(() -> Date._init_$lambda$10(this));
        this.month$delegate = LazyKt.lazy(() -> Date._init_$lambda$11(this));
        this.day$delegate = LazyKt.lazy(() -> Date._init_$lambda$12(this));
    }

    private static final Calendar calendar_delegate$lambda$1(Date this$0) {
        Calendar calendar;
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics.checkNotNull((Object)calendar2);
        Calendar $this$calendar_delegate_u24lambda_u241_u24lambda_u240 = calendar = calendar2;
        boolean bl = false;
        $this$calendar_delegate_u24lambda_u241_u24lambda_u240.setTimeInMillis(this$0.epochTimeMs);
        return calendar;
    }

    private static final java.util.Date date_delegate$lambda$2(Date this$0) {
        java.util.Date date = this$0.getCalendar().getTime();
        Intrinsics.checkNotNull((Object)date);
        return date;
    }

    private static final int year_delegate$lambda$4(Date this$0) {
        return this$0.getCalendar().get(1);
    }

    private static final Integer month_delegate$lambda$5(Date this$0) {
        boolean isFirstDayOfYear = this$0.getCalendar().get(2) == 0 && this$0.getCalendar().get(5) == 1;
        return !isFirstDayOfYear ? Integer.valueOf(this$0.getCalendar().get(2) + 1) : null;
    }

    private static final Integer day_delegate$lambda$6(Date this$0) {
        return this$0.getCalendar().get(5) == 1 ? null : Integer.valueOf(this$0.getCalendar().get(5));
    }

    private static final Calendar _init_$lambda$8(Date this$0) {
        Calendar calendar;
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics.checkNotNull((Object)calendar2);
        Calendar $this$_init__u24lambda_u248_u24lambda_u247 = calendar = calendar2;
        boolean bl = false;
        $this$_init__u24lambda_u248_u24lambda_u247.setTimeInMillis(this$0.epochTimeMs);
        return calendar;
    }

    private static final java.util.Date _init_$lambda$9(Date this$0) {
        java.util.Date date = this$0.getCalendar().getTime();
        Intrinsics.checkNotNull((Object)date);
        return date;
    }

    private static final int _init_$lambda$10(Date this$0) {
        return this$0.getCalendar().get(1);
    }

    private static final Integer _init_$lambda$11(Date this$0) {
        boolean isFirstDayOfYear = this$0.getCalendar().get(2) == 0 && this$0.getCalendar().get(5) == 1;
        return !isFirstDayOfYear ? Integer.valueOf(this$0.getCalendar().get(2) + 1) : null;
    }

    private static final Integer _init_$lambda$12(Date this$0) {
        return this$0.getCalendar().get(5) == 1 ? null : Integer.valueOf(this$0.getCalendar().get(5));
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a8\u0006\t"}, d2={"Ldev/brahmkshatriya/echo/common/models/Date$Companion;", "", "<init>", "()V", "toYearDate", "Ldev/brahmkshatriya/echo/common/models/Date;", "", "serializer", "Lkotlinx/serialization/KSerializer;", "common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Date toYearDate(int $this$toYearDate) {
            return new Date($this$toYearDate, null, null, 6, null);
        }

        @NotNull
        public final KSerializer<Date> serializer() {
            return (KSerializer)$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

