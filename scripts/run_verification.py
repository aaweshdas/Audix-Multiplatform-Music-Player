import subprocess
import os
import glob
import sys

PROJECT_ROOT = r'S:\All Code\Antigravity\echo-nightly'
os.chdir(PROJECT_ROOT)

java = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\runtime\bin\java.exe')
kotlinc = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-compiler-embeddable\2.2.10\6882d39ef03b18879c1a5d2a83c2212361bed5fe\kotlin-compiler-embeddable-2.2.10.jar'
trove = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.intellij.deps\trove4j\1.0.20181211\216c2e14b070f334479d800987affe4054cd563f\trove4j-1.0.20181211.jar'
compose = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-compose-compiler-plugin-embeddable\2.2.10\fd3cd12d4e9702cfcd731120564af86814cf95b7\kotlin-compose-compiler-plugin-embeddable-2.2.10.jar'
serialization = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-serialization-compiler-plugin-embeddable\2.2.10\8410bb1b4213e690e29954abbba401af599afafc\kotlin-serialization-compiler-plugin-embeddable-2.2.10.jar'

app_jars = [j for j in glob.glob(os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\*.jar'))]
app_cp = ';'.join(app_jars)

out_dir = os.path.join(PROJECT_ROOT, r'build\test_classes')
os.makedirs(out_dir, exist_ok=True)

test_src = os.path.join(PROJECT_ROOT, r'scripts\verify_consecutive_playback_and_features.kt')

stdlib = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-stdlib-2.2.10-ab998b5a8873e5635565578249af83.jar')
coroutines = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlinx-coroutines-core-jvm-1.10.2-16bb58d0777fca3b2efde66862478c.jar')
reflect = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-reflect-2.2.10-c0a969529bcfa182afdfce5f33b6d23.jar')
annotations = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\annotations-23.0.0-8484cd17d040d837983323f760b2c660.jar')

compile_cmd = [
    java,
    '-Xmx1024m',
    '-cp', f'{kotlinc};{trove};{stdlib};{coroutines};{reflect};{annotations}',
    'org.jetbrains.kotlin.cli.jvm.K2JVMCompiler',
    '-no-stdlib',
    '-jvm-target', '17',
    f'-Xplugin={compose}',
    f'-Xplugin={serialization}',
    '-cp', app_cp,
    '-d', out_dir,
    test_src
]

print("Compiling verification script...")
c_res = subprocess.run(compile_cmd, capture_output=True, text=True)
if c_res.returncode != 0:
    print("Compilation failed:")
    print(c_res.stderr)
    print(c_res.stdout)
    sys.exit(1)

print("Compilation succeeded. Running verification...")
vlc_dir = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\runtime\vlc')
env = os.environ.copy()
env['PATH'] = vlc_dir + ';' + env.get('PATH', '')
env['VLC_PLUGIN_PATH'] = os.path.join(vlc_dir, 'plugins')

run_cmd = [
    java,
    '-Xms128m',
    '-Xmx1024m',
    '-XX:+UseG1GC',
    f'-Dcompose.application.resources.dir={os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable\app\resources")}',
    f'-Dskiko.library.path={os.path.join(PROJECT_ROOT, r"release-artifacts\Audix-Windows-Portable\app")}',
    '-Dcompose.application.configure.swing.globals=true',
    '-cp', f'{out_dir};{app_cp}',
    'scripts.Verify_consecutive_playback_and_featuresKt'
]

r_res = subprocess.run(run_cmd, env=env, capture_output=True, text=True)
print(r_res.stdout)
if r_res.stderr:
    print("STDERR:\n", r_res.stderr)
sys.exit(r_res.returncode)
