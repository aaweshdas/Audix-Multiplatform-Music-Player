/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.brahmkshatriya.echo.common.clients;

import dev.brahmkshatriya.echo.common.helpers.WebViewRequest;
import dev.brahmkshatriya.echo.common.models.User;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0007\u0082\u0001\u0002\f\r\u00a8\u0006\u000e\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient;", "", "setLoginUser", "", "user", "Ldev/brahmkshatriya/echo/common/models/User;", "getCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WebView", "CustomInput", "Form", "InputField", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$CustomInput;", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$WebView;", "common"})
public sealed interface LoginClient {
    public void setLoginUser(@Nullable User var1);

    @Nullable
    public Object getCurrentUser(@NotNull Continuation<? super User> var1);

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fH\u00a6@\u00a2\u0006\u0002\u0010\rR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient$CustomInput;", "Ldev/brahmkshatriya/echo/common/clients/LoginClient;", "forms", "", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$Form;", "getForms", "()Ljava/util/List;", "onLogin", "Ldev/brahmkshatriya/echo/common/models/User;", "key", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common"})
    public static non-sealed interface CustomInput
    extends LoginClient {
        @NotNull
        public List<Form> getForms();

        @Nullable
        public Object onLogin(@NotNull String var1, @NotNull Map<String, String> var2, @NotNull Continuation<? super List<User>> var3);
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001e"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient$Form;", "", "key", "", "label", "icon", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;", "inputFields", "", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getIcon", "()Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;", "getInputFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "common"})
    public static final class Form {
        @NotNull
        private final String key;
        @NotNull
        private final String label;
        @NotNull
        private final InputField.Type icon;
        @NotNull
        private final List<InputField> inputFields;

        public Form(@NotNull String key, @NotNull String label, @NotNull InputField.Type icon, @NotNull List<InputField> inputFields) {
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            Intrinsics.checkNotNullParameter((Object)((Object)icon), (String)"icon");
            Intrinsics.checkNotNullParameter(inputFields, (String)"inputFields");
            this.key = key;
            this.label = label;
            this.icon = icon;
            this.inputFields = inputFields;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final InputField.Type getIcon() {
            return this.icon;
        }

        @NotNull
        public final List<InputField> getInputFields() {
            return this.inputFields;
        }

        @NotNull
        public final String component1() {
            return this.key;
        }

        @NotNull
        public final String component2() {
            return this.label;
        }

        @NotNull
        public final InputField.Type component3() {
            return this.icon;
        }

        @NotNull
        public final List<InputField> component4() {
            return this.inputFields;
        }

        @NotNull
        public final Form copy(@NotNull String key, @NotNull String label, @NotNull InputField.Type icon, @NotNull List<InputField> inputFields) {
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            Intrinsics.checkNotNullParameter((Object)((Object)icon), (String)"icon");
            Intrinsics.checkNotNullParameter(inputFields, (String)"inputFields");
            return new Form(key, label, icon, inputFields);
        }

        public static /* synthetic */ Form copy$default(Form form, String string2, String string3, InputField.Type type, List list2, int n, Object object) {
            if ((n & 1) != 0) {
                string2 = form.key;
            }
            if ((n & 2) != 0) {
                string3 = form.label;
            }
            if ((n & 4) != 0) {
                type = form.icon;
            }
            if ((n & 8) != 0) {
                list2 = form.inputFields;
            }
            return form.copy(string2, string3, type, list2);
        }

        @NotNull
        public String toString() {
            return "Form(key=" + this.key + ", label=" + this.label + ", icon=" + this.icon + ", inputFields=" + this.inputFields + ")";
        }

        public int hashCode() {
            int result2 = this.key.hashCode();
            result2 = result2 * 31 + this.label.hashCode();
            result2 = result2 * 31 + this.icon.hashCode();
            result2 = result2 * 31 + ((Object)this.inputFields).hashCode();
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Form)) {
                return false;
            }
            Form form = (Form)other;
            if (!Intrinsics.areEqual((Object)this.key, (Object)form.key)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.label, (Object)form.label)) {
                return false;
            }
            if (this.icon != form.icon) {
                return false;
            }
            return Intrinsics.areEqual(this.inputFields, form.inputFields);
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u00c6\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField;", "", "type", "Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;", "key", "", "label", "isRequired", "", "regex", "Lkotlin/text/Regex;", "<init>", "(Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;Ljava/lang/String;Ljava/lang/String;ZLkotlin/text/Regex;)V", "getType", "()Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;", "getKey", "()Ljava/lang/String;", "getLabel", "()Z", "getRegex", "()Lkotlin/text/Regex;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "Type", "common"})
    public static final class InputField {
        @NotNull
        private final Type type;
        @NotNull
        private final String key;
        @NotNull
        private final String label;
        private final boolean isRequired;
        @Nullable
        private final Regex regex;

        public InputField(@NotNull Type type, @NotNull String key, @NotNull String label, boolean isRequired, @Nullable Regex regex) {
            Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            this.type = type;
            this.key = key;
            this.label = label;
            this.isRequired = isRequired;
            this.regex = regex;
        }

        public /* synthetic */ InputField(Type type, String string2, String string3, boolean bl, Regex regex, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 0x10) != 0) {
                regex = null;
            }
            this(type, string2, string3, bl, regex);
        }

        @NotNull
        public final Type getType() {
            return this.type;
        }

        @NotNull
        public final String getKey() {
            return this.key;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public final boolean isRequired() {
            return this.isRequired;
        }

        @Nullable
        public final Regex getRegex() {
            return this.regex;
        }

        @NotNull
        public final Type component1() {
            return this.type;
        }

        @NotNull
        public final String component2() {
            return this.key;
        }

        @NotNull
        public final String component3() {
            return this.label;
        }

        public final boolean component4() {
            return this.isRequired;
        }

        @Nullable
        public final Regex component5() {
            return this.regex;
        }

        @NotNull
        public final InputField copy(@NotNull Type type, @NotNull String key, @NotNull String label, boolean isRequired, @Nullable Regex regex) {
            Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
            Intrinsics.checkNotNullParameter((Object)key, (String)"key");
            Intrinsics.checkNotNullParameter((Object)label, (String)"label");
            return new InputField(type, key, label, isRequired, regex);
        }

        public static /* synthetic */ InputField copy$default(InputField inputField, Type type, String string2, String string3, boolean bl, Regex regex, int n, Object object) {
            if ((n & 1) != 0) {
                type = inputField.type;
            }
            if ((n & 2) != 0) {
                string2 = inputField.key;
            }
            if ((n & 4) != 0) {
                string3 = inputField.label;
            }
            if ((n & 8) != 0) {
                bl = inputField.isRequired;
            }
            if ((n & 0x10) != 0) {
                regex = inputField.regex;
            }
            return inputField.copy(type, string2, string3, bl, regex);
        }

        @NotNull
        public String toString() {
            return "InputField(type=" + this.type + ", key=" + this.key + ", label=" + this.label + ", isRequired=" + this.isRequired + ", regex=" + this.regex + ")";
        }

        public int hashCode() {
            int result2 = this.type.hashCode();
            result2 = result2 * 31 + this.key.hashCode();
            result2 = result2 * 31 + this.label.hashCode();
            result2 = result2 * 31 + Boolean.hashCode(this.isRequired);
            result2 = result2 * 31 + (this.regex == null ? 0 : this.regex.hashCode());
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputField)) {
                return false;
            }
            InputField inputField = (InputField)other;
            if (this.type != inputField.type) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.key, (Object)inputField.key)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.label, (Object)inputField.label)) {
                return false;
            }
            if (this.isRequired != inputField.isRequired) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.regex, (Object)inputField.regex);
        }

        @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient$InputField$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Email", "Username", "Password", "Number", "Url", "Misc", "common"})
        public static final class Type
        extends Enum<Type> {
            public static final /* enum */ Type Email = new Type();
            public static final /* enum */ Type Username = new Type();
            public static final /* enum */ Type Password = new Type();
            public static final /* enum */ Type Number = new Type();
            public static final /* enum */ Type Url = new Type();
            public static final /* enum */ Type Misc = new Type();
            private static final /* synthetic */ Type[] $VALUES;
            private static final /* synthetic */ EnumEntries $ENTRIES;

            public static Type[] values() {
                return (Type[])$VALUES.clone();
            }

            public static Type valueOf(String value2) {
                return Enum.valueOf(Type.class, value2);
            }

            @NotNull
            public static EnumEntries<Type> getEntries() {
                return $ENTRIES;
            }

            static {
                $VALUES = typeArray = new Type[]{Type.Email, Type.Username, Type.Password, Type.Number, Type.Url, Type.Misc};
                $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
            }
        }
    }

    @Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b\u00c0\u0006\u0003"}, d2={"Ldev/brahmkshatriya/echo/common/clients/LoginClient$WebView;", "Ldev/brahmkshatriya/echo/common/clients/LoginClient;", "webViewRequest", "Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "", "Ldev/brahmkshatriya/echo/common/models/User;", "getWebViewRequest", "()Ldev/brahmkshatriya/echo/common/helpers/WebViewRequest;", "common"})
    public static non-sealed interface WebView
    extends LoginClient {
        @NotNull
        public WebViewRequest<List<User>> getWebViewRequest();
    }
}

