/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  app.cash.sqldelight.db.SqlDriver
 *  app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
 *  com.russhwolf.settings.PreferencesSettings
 *  com.russhwolf.settings.Settings
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.test.AssertionsKt
 *  kotlin.text.StringsKt
 *  org.junit.Test
 */
package dev.brahmkshatriya.echo.core;

import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver;
import com.russhwolf.settings.PreferencesSettings;
import com.russhwolf.settings.Settings;
import dev.brahmkshatriya.echo.core.db.DatabaseFactoryKt;
import dev.brahmkshatriya.echo.core.db.EchoDatabase;
import dev.brahmkshatriya.echo.core.db.Extensions;
import dev.brahmkshatriya.echo.core.platform.DesktopAppPlatform;
import dev.brahmkshatriya.echo.core.settings.EchoSettings;
import java.util.List;
import java.util.prefs.Preferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.test.AssertionsKt;
import kotlin.text.StringsKt;
import org.junit.Test;

@Metadata(mv={2, 2, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007\u00a8\u0006\b"}, d2={"Ldev/brahmkshatriya/echo/core/CoreDesktopTest;", "", "<init>", "()V", "testPlatformPaths", "", "testEchoSettings", "testDatabaseCreationAndQueries", "core_test"})
public final class CoreDesktopTest {
    @Test
    public final void testPlatformPaths() {
        DesktopAppPlatform platform = new DesktopAppPlatform();
        AssertionsKt.assertNotNull$default((Object)platform.getDataDir(), null, (int)2, null);
        AssertionsKt.assertNotNull$default((Object)platform.getCacheDir(), null, (int)2, null);
        AssertionsKt.assertNotNull$default((Object)platform.getDownloadsDir(), null, (int)2, null);
        AssertionsKt.assertNotNull$default((Object)platform.getExtensionsDir(), null, (int)2, null);
        AssertionsKt.assertTrue$default((boolean)StringsKt.contains((CharSequence)platform.getDataDir().name(), (CharSequence)"Echo", (boolean)true), null, (int)2, null);
    }

    @Test
    public final void testEchoSettings() {
        Preferences prefs = Preferences.userRoot().node("echo_test_settings");
        Intrinsics.checkNotNull((Object)prefs);
        EchoSettings settings = new EchoSettings((Settings)new PreferencesSettings(prefs));
        settings.putString("test_key", "test_value");
        AssertionsKt.assertEquals$default((Object)"test_value", (Object)EchoSettings.getString$default(settings, "test_key", null, 2, null), null, (int)4, null);
        settings.putBoolean("flag", true);
        AssertionsKt.assertEquals$default((Object)true, (Object)EchoSettings.getBoolean$default(settings, "flag", false, 2, null), null, (int)4, null);
        settings.putInt("count", 42);
        AssertionsKt.assertEquals$default((Object)42, (Object)EchoSettings.getInt$default(settings, "count", 0, 2, null), null, (int)4, null);
        settings.remove("test_key");
        AssertionsKt.assertEquals$default(null, (Object)EchoSettings.getString$default(settings, "test_key", null, 2, null), null, (int)4, null);
        prefs.removeNode();
    }

    @Test
    public final void testDatabaseCreationAndQueries() {
        JdbcSqliteDriver driver = new JdbcSqliteDriver("jdbc:sqlite:", null, 2, null);
        EchoDatabase.Companion.getSchema().create((SqlDriver)driver);
        EchoDatabase database = DatabaseFactoryKt.createEchoDatabase((SqlDriver)driver);
        database.getExtensionsQueries().upsert("ext.test", "MUSIC", "Test Extension", "1.0.0", "Test Description", "Echo", null, 1L, "C:/test/test.jar", "FILE");
        List list2 = database.getExtensionsQueries().selectAll().executeAsList();
        AssertionsKt.assertEquals$default((Object)1, (Object)list2.size(), null, (int)4, null);
        AssertionsKt.assertEquals$default((Object)"Test Extension", (Object)((Extensions)list2.get(0)).getName(), null, (int)4, null);
        AssertionsKt.assertEquals$default((Object)"MUSIC", (Object)((Extensions)list2.get(0)).getType(), null, (int)4, null);
        AssertionsKt.assertEquals$default((Object)1L, (Object)((Extensions)list2.get(0)).getEnabled(), null, (int)4, null);
        database.getExtensionsQueries().setEnabled(0L, "ext.test", "MUSIC");
        List enabled = database.getExtensionsQueries().selectEnabled().executeAsList();
        AssertionsKt.assertEquals$default((Object)0, (Object)enabled.size(), null, (int)4, null);
    }
}

