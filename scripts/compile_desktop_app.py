"""
Audix Desktop - Application Compiler Script
Compiles Kotlin/Compose Multiplatform sources for the Audix Desktop application,
linking against the bundled runtime libraries and generating clean JVM bytecode.
"""

import subprocess
import os
import glob
import shutil
import zipfile
import sys

# Determine project root directory
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

java = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\runtime\bin\java.exe')
kotlinc = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-compiler-embeddable\2.2.10\6882d39ef03b18879c1a5d2a83c2212361bed5fe\kotlin-compiler-embeddable-2.2.10.jar'
compose = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-compose-compiler-plugin-embeddable\2.2.10\fd3cd12d4e9702cfcd731120564af86814cf95b7\kotlin-compose-compiler-plugin-embeddable-2.2.10.jar'
serialization = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-serialization-compiler-plugin-embeddable\2.2.10\8410bb1b4213e690e29954abbba401af599afafc\kotlin-serialization-compiler-plugin-embeddable-2.2.10.jar'
trove = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.intellij.deps\trove4j\1.0.20181211\216c2e14b070f334479d800987affe4054cd563f\trove4j-1.0.20181211.jar'

out_dir = os.path.join(PROJECT_ROOT, r'build\compiled_screens')
if os.path.exists(out_dir):
    try:
        shutil.rmtree(out_dir)
    except Exception as e:
        print(f"Notice: could not clear {out_dir}: {e}")
os.makedirs(out_dir, exist_ok=True)

# Clean up any stale reference jars from previous runs
for old_jar in glob.glob(os.path.join(PROJECT_ROOT, r'build\clean_ref_for_compile*.jar')):
    try:
        os.remove(old_jar)
    except Exception:
        pass

# Prepare clean reference jar without modified classes to avoid compilation/classpath duplicates
clean_ref_jar = os.path.join(PROJECT_ROOT, f'build\\clean_ref_for_compile_{os.getpid()}.jar')
target_jar = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar')

with zipfile.ZipFile(target_jar, 'r') as zin, zipfile.ZipFile(clean_ref_jar, 'w', compression=zipfile.ZIP_DEFLATED) as zout:
    for item in zin.infolist():
        if (not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/player/') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/HomeScreenKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$HomeScreenKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screensaver/EchoScreensaverKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screensaver/ComposableSingletons$EchoScreensaverKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthersKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$SearchAndOthersKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionsScreenKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/CuratedExtension') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionViewTab') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionCategoryFilter') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/EchoDesktopAppKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/ComposableSingletons$EchoDesktopAppKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/Screen') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/UiZoomManager') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/library/') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/download/') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/MainKt') and
            not item.filename.startswith('dev/brahmkshatriya/echo/core/extensions/JarExtensionRepository') and
            not item.filename.startswith('dev/brahmkshatriya/echo/desktop/EchoTrayPainter') and
            not item.filename.startswith('dev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension')):
            zout.writestr(item, zin.read(item.filename))

app_jars = [j for j in glob.glob(os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\*.jar')) if not os.path.basename(j).startswith('recovered_classes')]
app_jars.append(clean_ref_jar)
app_cp = ';'.join(app_jars)

source_files = [
    os.path.join(PROJECT_ROOT, r'core\src\desktopMain\kotlin\dev\brahmkshatriya\echo\core\platform\VlcAudioPlayer.kt'),
    os.path.join(PROJECT_ROOT, r'core\src\desktopMain\kotlin\dev\brahmkshatriya\echo\core\extensions\JarExtensionRepository.kt'),
    os.path.join(PROJECT_ROOT, r'core\src\desktopMain\kotlin\dev\brahmkshatriya\echo\core\extensions\builtin\LocalMusicExtension.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\library\DesktopLibraryManager.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\download\DesktopDownloadManager.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\Main.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\viewmodel\PlayerViewModel.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\player\MiniPlayer.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\HomeScreen.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screensaver\EchoScreensaver.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\SearchAndOthers.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\screens\ExtensionsScreen.kt'),
    os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\kotlin\dev\brahmkshatriya\echo\desktop\ui\EchoDesktopApp.kt')
]

stdlib = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-stdlib-2.2.10-ab998b5a8873e5635565578249af83.jar')
coroutines = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlinx-coroutines-core-jvm-1.10.2-16bb58d0777fca3b2efde66862478c.jar')
reflect = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-reflect-2.2.10-c0a969529bcfa182afdfce5f33b6d23.jar')
annotations = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\annotations-23.0.0-8484cd17d040d837983323f760b2c660.jar')

cmd = [
    java,
    '-Xmx2048m',
    '-Dfile.encoding=UTF-8',
    '-cp', f'{kotlinc};{trove};{stdlib};{coroutines};{reflect};{annotations}',
    'org.jetbrains.kotlin.cli.jvm.K2JVMCompiler',
    '-no-stdlib',
    '-jvm-target', '17',
    f'-Xplugin={compose}',
    f'-Xplugin={serialization}',
    '-cp', app_cp,
    '-d', out_dir
] + source_files

print('[1/2] Compiling Kotlin Compose Multiplatform desktop sources...')
try:
    res = subprocess.run(cmd, capture_output=True, text=True)
    if res.stdout:
        print('STDOUT:\n', res.stdout[:2000])
    if res.stderr:
        print('STDERR:\n', res.stderr)
    print(f'[2/2] Compilation finished with exit code {res.returncode}')
    if res.returncode != 0:
        sys.exit(res.returncode)
finally:
    if os.path.exists(clean_ref_jar):
        try:
            os.remove(clean_ref_jar)
        except Exception:
            pass
