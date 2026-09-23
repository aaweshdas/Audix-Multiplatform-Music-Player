/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.compose.runtime.internal.StabilityInferred
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package dev.brahmkshatriya.echo.desktop.utils;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ldev/brahmkshatriya/echo/desktop/utils/DevanagariTransliterator;", "", "<init>", "()V", "vowels", "", "", "", "matras", "consonants", "isDevanagari", "", "text", "transliterate", "desktopApp"})
@StabilityInferred(parameters=0)
@SourceDebugExtension(value={"SMAP\nDevanagariTransliterator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DevanagariTransliterator.kt\ndev/brahmkshatriya/echo/desktop/utils/DevanagariTransliterator\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,121:1\n1088#2,2:122\n1#3:124\n*S KotlinDebug\n*F\n+ 1 DevanagariTransliterator.kt\ndev/brahmkshatriya/echo/desktop/utils/DevanagariTransliterator\n*L\n32#1:122,2\n*E\n"})
public final class DevanagariTransliterator {
    @NotNull
    public static final DevanagariTransliterator INSTANCE = new DevanagariTransliterator();
    @NotNull
    private static final Map<Character, String> vowels;
    @NotNull
    private static final Map<Character, String> matras;
    @NotNull
    private static final Map<Character, String> consonants;
    public static final int $stable;

    private DevanagariTransliterator() {
    }

    public final boolean isDevanagari(@NotNull String text) {
        boolean bl;
        block1: {
            Intrinsics.checkNotNullParameter((Object)text, (String)"text");
            CharSequence $this$any$iv = text;
            boolean $i$f$any = false;
            for (int i = 0; i < $this$any$iv.length(); ++i) {
                char element$iv;
                char it = element$iv = $this$any$iv.charAt(i);
                boolean bl2 = false;
                boolean bl3 = '\u0900' <= it ? it < '\u0980' : false;
                if (!bl3) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    @NotNull
    public final String transliterate(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        if (!this.isDevanagari(text)) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = text.length();
        while (i < len) {
            char c;
            block28: {
                block29: {
                    block30: {
                        c = text.charAt(i);
                        if (i + 1 < len && text.charAt(i + 1) == '\u093c') {
                            String string2;
                            switch (c) {
                                case '\u091c': {
                                    string2 = "z";
                                    break;
                                }
                                case '\u092b': {
                                    string2 = "f";
                                    break;
                                }
                                case '\u0921': {
                                    string2 = "r";
                                    break;
                                }
                                case '\u0922': {
                                    string2 = "rh";
                                    break;
                                }
                                case '\u0915': {
                                    string2 = "q";
                                    break;
                                }
                                case '\u0916': {
                                    string2 = "kh";
                                    break;
                                }
                                case '\u0917': {
                                    string2 = "gh";
                                    break;
                                }
                                default: {
                                    string2 = consonants.get(Character.valueOf(c));
                                    if (string2 != null) break;
                                    string2 = String.valueOf(c);
                                }
                            }
                            String roman = string2;
                            sb.append(roman);
                            if ((i += 2) < len && text.charAt(i) == '\u094d') {
                                ++i;
                                continue;
                            }
                            if (i < len && matras.containsKey(Character.valueOf(text.charAt(i)))) {
                                sb.append(matras.get(Character.valueOf(text.charAt(i))));
                                ++i;
                                continue;
                            }
                            if (i >= len) continue;
                            char c2 = text.charAt(i);
                            if (!('\u0915' <= c2 ? c2 < '\u093a' : false)) {
                                c2 = text.charAt(i);
                                boolean bl = '\u0958' <= c2 ? c2 < '\u0960' : false;
                                if (!bl) continue;
                            }
                            sb.append("a");
                            continue;
                        }
                        if (vowels.containsKey(Character.valueOf(c))) {
                            sb.append(vowels.get(Character.valueOf(c)));
                            ++i;
                            continue;
                        }
                        if (!consonants.containsKey(Character.valueOf(c))) break block28;
                        sb.append(consonants.get(Character.valueOf(c)));
                        int nextIdx = i + 1;
                        if (nextIdx >= len) break block29;
                        char next2 = text.charAt(nextIdx);
                        if (next2 == '\u094d') {
                            i += 2;
                            continue;
                        }
                        if (matras.containsKey(Character.valueOf(next2))) {
                            sb.append(matras.get(Character.valueOf(next2)));
                            i += 2;
                            continue;
                        }
                        if ('\u0915' <= next2 ? next2 < '\u093a' : false) break block30;
                        boolean bl = '\u0958' <= next2 ? next2 < '\u0960' : false;
                        if (!bl) break block29;
                    }
                    sb.append("a");
                    ++i;
                    continue;
                }
                ++i;
                continue;
            }
            switch (c) {
                case '\u0901': 
                case '\u0902': {
                    Object object = sb.append("n");
                    break;
                }
                case '\u0903': {
                    Object object = sb.append("h");
                    break;
                }
                case '\u094d': {
                    Object object = Unit.INSTANCE;
                    break;
                }
                case '\u0964': {
                    Object object = sb.append(".");
                    break;
                }
                case '\u0965': {
                    Object object = sb.append(".");
                    break;
                }
                default: {
                    Object object = sb.append(c);
                }
            }
            ++i;
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"toString(...)");
        return CollectionsKt.joinToString$default((Iterable)StringsKt.lines((CharSequence)string3), (CharSequence)"\n", null, null, (int)0, null, DevanagariTransliterator::transliterate$lambda$2, (int)30, null);
    }

    /*
     * WARNING - void declaration
     */
    private static final CharSequence transliterate$lambda$2(String line) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter((Object)line, (String)"line");
        String trimmed = ((Object)StringsKt.trimEnd((CharSequence)line)).toString();
        if (((CharSequence)trimmed).length() == 0) {
            charSequence = "";
        } else {
            String string2;
            String string3 = trimmed;
            if (((CharSequence)string3).length() > 0) {
                void it;
                char c = string3.charAt(0);
                StringBuilder stringBuilder = new StringBuilder();
                boolean bl = false;
                StringBuilder stringBuilder2 = stringBuilder.append((Object)(Character.isLowerCase((char)it) ? CharsKt.titlecase((char)it) : String.valueOf((char)it)));
                String string4 = string3;
                int n = 1;
                String string5 = string4.substring(n);
                Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"substring(...)");
                string2 = stringBuilder2.append(string5).toString();
            } else {
                string2 = string3;
            }
            charSequence = string2;
        }
        return charSequence;
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Character.valueOf('\u0905'), (Object)"a"), TuplesKt.to((Object)Character.valueOf('\u0906'), (Object)"aa"), TuplesKt.to((Object)Character.valueOf('\u0907'), (Object)"i"), TuplesKt.to((Object)Character.valueOf('\u0908'), (Object)"ee"), TuplesKt.to((Object)Character.valueOf('\u0909'), (Object)"u"), TuplesKt.to((Object)Character.valueOf('\u090a'), (Object)"oo"), TuplesKt.to((Object)Character.valueOf('\u090b'), (Object)"ri"), TuplesKt.to((Object)Character.valueOf('\u090f'), (Object)"e"), TuplesKt.to((Object)Character.valueOf('\u0910'), (Object)"ai"), TuplesKt.to((Object)Character.valueOf('\u0913'), (Object)"o"), TuplesKt.to((Object)Character.valueOf('\u0914'), (Object)"au")};
        vowels = MapsKt.mapOf((Pair[])pairArray);
        pairArray = new Pair[]{TuplesKt.to((Object)Character.valueOf('\u093e'), (Object)"aa"), TuplesKt.to((Object)Character.valueOf('\u093f'), (Object)"i"), TuplesKt.to((Object)Character.valueOf('\u0940'), (Object)"ee"), TuplesKt.to((Object)Character.valueOf('\u0941'), (Object)"u"), TuplesKt.to((Object)Character.valueOf('\u0942'), (Object)"oo"), TuplesKt.to((Object)Character.valueOf('\u0943'), (Object)"ri"), TuplesKt.to((Object)Character.valueOf('\u0947'), (Object)"e"), TuplesKt.to((Object)Character.valueOf('\u0948'), (Object)"ai"), TuplesKt.to((Object)Character.valueOf('\u094b'), (Object)"o"), TuplesKt.to((Object)Character.valueOf('\u094c'), (Object)"au")};
        matras = MapsKt.mapOf((Pair[])pairArray);
        pairArray = new Pair[]{TuplesKt.to((Object)Character.valueOf('\u0915'), (Object)"k"), TuplesKt.to((Object)Character.valueOf('\u0916'), (Object)"kh"), TuplesKt.to((Object)Character.valueOf('\u0917'), (Object)"g"), TuplesKt.to((Object)Character.valueOf('\u0918'), (Object)"gh"), TuplesKt.to((Object)Character.valueOf('\u0919'), (Object)"ng"), TuplesKt.to((Object)Character.valueOf('\u091a'), (Object)"ch"), TuplesKt.to((Object)Character.valueOf('\u091b'), (Object)"chh"), TuplesKt.to((Object)Character.valueOf('\u091c'), (Object)"j"), TuplesKt.to((Object)Character.valueOf('\u091d'), (Object)"jh"), TuplesKt.to((Object)Character.valueOf('\u091e'), (Object)"ny"), TuplesKt.to((Object)Character.valueOf('\u091f'), (Object)"t"), TuplesKt.to((Object)Character.valueOf('\u0920'), (Object)"th"), TuplesKt.to((Object)Character.valueOf('\u0921'), (Object)"d"), TuplesKt.to((Object)Character.valueOf('\u0922'), (Object)"dh"), TuplesKt.to((Object)Character.valueOf('\u0923'), (Object)"n"), TuplesKt.to((Object)Character.valueOf('\u0924'), (Object)"t"), TuplesKt.to((Object)Character.valueOf('\u0925'), (Object)"th"), TuplesKt.to((Object)Character.valueOf('\u0926'), (Object)"d"), TuplesKt.to((Object)Character.valueOf('\u0927'), (Object)"dh"), TuplesKt.to((Object)Character.valueOf('\u0928'), (Object)"n"), TuplesKt.to((Object)Character.valueOf('\u092a'), (Object)"p"), TuplesKt.to((Object)Character.valueOf('\u092b'), (Object)"ph"), TuplesKt.to((Object)Character.valueOf('\u092c'), (Object)"b"), TuplesKt.to((Object)Character.valueOf('\u092d'), (Object)"bh"), TuplesKt.to((Object)Character.valueOf('\u092e'), (Object)"m"), TuplesKt.to((Object)Character.valueOf('\u092f'), (Object)"y"), TuplesKt.to((Object)Character.valueOf('\u0930'), (Object)"r"), TuplesKt.to((Object)Character.valueOf('\u0932'), (Object)"l"), TuplesKt.to((Object)Character.valueOf('\u0935'), (Object)"v"), TuplesKt.to((Object)Character.valueOf('\u0936'), (Object)"sh"), TuplesKt.to((Object)Character.valueOf('\u0937'), (Object)"sh"), TuplesKt.to((Object)Character.valueOf('\u0938'), (Object)"s"), TuplesKt.to((Object)Character.valueOf('\u0939'), (Object)"h"), TuplesKt.to((Object)Character.valueOf('\u0958'), (Object)"q"), TuplesKt.to((Object)Character.valueOf('\u0959'), (Object)"kh"), TuplesKt.to((Object)Character.valueOf('\u095a'), (Object)"gh"), TuplesKt.to((Object)Character.valueOf('\u095b'), (Object)"z"), TuplesKt.to((Object)Character.valueOf('\u095c'), (Object)"r"), TuplesKt.to((Object)Character.valueOf('\u095d'), (Object)"rh"), TuplesKt.to((Object)Character.valueOf('\u095e'), (Object)"f")};
        consonants = MapsKt.mapOf((Pair[])pairArray);
        $stable = 8;
    }
}

