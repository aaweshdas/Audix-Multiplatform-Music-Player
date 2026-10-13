"""
Audix Desktop - Extension Compilation & Packaging Script
Compiles source-backed music extensions (YouTube Music, JioSaavn, Spotify, SoundCloud, Radio Browser)
and packages them along with companion extensions (LRCLIB, Genius, Musixmatch, Last.fm, Discord RPC)
into signed/manifested extension JARs distributed to AppData and application runtime resources.
"""

import subprocess
import os
import glob
import shutil
import zipfile
import json
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

java = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\runtime\bin\java.exe')
kotlinc = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-compiler-embeddable\2.2.10\6882d39ef03b18879c1a5d2a83c2212361bed5fe\kotlin-compiler-embeddable-2.2.10.jar'
serialization = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.kotlin\kotlin-serialization-compiler-plugin-embeddable\2.2.10\8410bb1b4213e690e29954abbba401af599afafc\kotlin-serialization-compiler-plugin-embeddable-2.2.10.jar'
trove = r'C:\Users\dasab\.gradle\caches\modules-2\files-2.1\org.jetbrains.intellij.deps\trove4j\1.0.20181211\216c2e14b070f334479d800987affe4054cd563f\trove4j-1.0.20181211.jar'
stdlib = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-stdlib-2.2.10-ab998b5a8873e5635565578249af83.jar')
coroutines = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlinx-coroutines-core-jvm-1.10.2-16bb58d0777fca3b2efde66862478c.jar')
reflect = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\kotlin-reflect-2.2.10-c0a969529bcfa182afdfce5f33b6d23.jar')
annotations = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\annotations-23.0.0-8484cd17d040d837983323f760b2c660.jar')

app_jars = glob.glob(os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\*.jar'))
app_cp = ';'.join(app_jars)

app_resources_ext = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\resources\extensions')
appdata_ext = os.path.expandvars(r'%APPDATA%\Echo\extensions')
os.makedirs(app_resources_ext, exist_ok=True)
os.makedirs(appdata_ext, exist_ok=True)

extensions = [
    {
        'id': 'youtube_music',
        'name': 'YouTube Music',
        'class': 'dev.brahmkshatriya.echo.extension.YoutubeExtension',
        'type': 'MUSIC',
        'version': '1.0.0',
        'desc': 'Stream millions of songs and official tracks from YouTube Music with adaptive bitrates.',
        'jar': 'youtube.jar',
        'source': os.path.join(PROJECT_ROOT, r'extensions\youtube\src\main\kotlin\dev\brahmkshatriya\echo\extension\YoutubeExtension.kt'),
        'classes_dir': os.path.join(PROJECT_ROOT, r'build\compiled_extensions\youtube')
    },
    {
        'id': 'saavn_music',
        'name': 'JioSaavn',
        'class': 'dev.brahmkshatriya.echo.extension.SaavnExtension',
        'type': 'MUSIC',
        'version': '1.0.0',
        'desc': 'Stream millions of Bollywood, English, and Regional hits in crystal-clear 320kbps audio.',
        'jar': 'saavn.jar',
        'source': os.path.join(PROJECT_ROOT, r'extensions\saavn\src\main\kotlin\dev\brahmkshatriya\echo\extension\SaavnExtension.kt'),
        'classes_dir': os.path.join(PROJECT_ROOT, r'build\compiled_extensions\saavn')
    },
    {
        'id': 'spotify_music',
        'name': 'Spotify',
        'class': 'dev.brahmkshatriya.echo.extension.SpotifyExtension',
        'type': 'MUSIC',
        'version': '1.0.0',
        'desc': "Browse Spotify Top Charts, Today's Top Hits, Viral 50, and stream high-fidelity tracks.",
        'jar': 'spotify.jar',
        'source': os.path.join(PROJECT_ROOT, r'extensions\spotify\src\main\kotlin\dev\brahmkshatriya\echo\extension\SpotifyExtension.kt'),
        'classes_dir': os.path.join(PROJECT_ROOT, r'build\compiled_extensions\spotify')
    },
    {
        'id': 'soundcloud',
        'name': 'SoundCloud',
        'class': 'dev.brahmkshatriya.echo.extension.SoundcloudExtension',
        'type': 'MUSIC',
        'version': '1.0.0',
        'desc': 'Stream trending tracks, independent artists, podcasts, and remixes from SoundCloud.',
        'jar': 'soundcloud.jar',
        'source': os.path.join(PROJECT_ROOT, r'extensions\soundcloud\src\main\kotlin\dev\brahmkshatriya\echo\extension\SoundcloudExtension.kt'),
        'classes_dir': os.path.join(PROJECT_ROOT, r'build\compiled_extensions\soundcloud')
    },
    {
        'id': 'radio_browser',
        'name': 'Radio Browser',
        'class': 'dev.brahmkshatriya.echo.extension.RadioBrowserExtension',
        'type': 'MUSIC',
        'version': '1.0.0',
        'desc': 'Free live radio stations, music channels, genres, and top hits worldwide.',
        'jar': 'radiobrowser.jar',
        'source': os.path.join(PROJECT_ROOT, r'extensions\radiobrowser\src\main\kotlin\dev\brahmkshatriya\echo\extension\RadioBrowserExtension.kt'),
        'classes_dir': os.path.join(PROJECT_ROOT, r'build\compiled_extensions\radiobrowser')
    }
]

print("=== 1. COMPILING MUSIC EXTENSIONS ===")
for ext in extensions:
    out_dir = ext['classes_dir']
    if os.path.exists(out_dir):
        shutil.rmtree(out_dir)
    os.makedirs(out_dir, exist_ok=True)

    print(f"Compiling {ext['name']} ({ext['jar']})...")
    cmd = [
        java,
        '-Dfile.encoding=UTF-8',
        '-cp', f'{kotlinc};{trove};{stdlib};{coroutines};{reflect};{annotations}',
        'org.jetbrains.kotlin.cli.jvm.K2JVMCompiler',
        '-no-stdlib',
        '-jvm-target', '17',
        f'-Xplugin={serialization}',
        '-cp', app_cp,
        '-d', out_dir,
        ext['source']
    ]
    res = subprocess.run(cmd, capture_output=True, text=True)
    if res.returncode != 0:
        print(f"FAILED to compile {ext['name']}:")
        print(res.stderr)
        print(res.stdout)
        sys.exit(1)
    else:
        print(f"  -> Compiled successfully: {ext['name']}")

print("\n=== 2. PACKAGING JAR ARTIFACTS ===")
for ext in extensions:
    jar_path = os.path.join(app_resources_ext, ext['jar'])
    print(f"Packaging {ext['jar']} ({ext['name']})...")

    manifest_mf = (
        "Manifest-Version: 1.0\r\n"
        f"Extension-Id: {ext['id']}\r\n"
        f"Extension-Name: {ext['name']}\r\n"
        f"Extension-Class: {ext['class']}\r\n"
        f"Extension-Type: {ext['type']}\r\n"
        f"Extension-Version-Name: {ext['version']}\r\n"
        f"Extension-Description: {ext['desc']}\r\n"
        "Extension-Author: Audix\r\n"
        "\r\n"
    )

    echo_json = {
        "id": ext['id'],
        "name": ext['name'],
        "className": ext['class'],
        "version": ext['version'],
        "type": ext['type'],
        "description": ext['desc'],
        "author": "Audix"
    }

    with zipfile.ZipFile(jar_path, 'w', compression=zipfile.ZIP_DEFLATED) as z:
        z.writestr("META-INF/MANIFEST.MF", manifest_mf)
        z.writestr("META-INF/echo-extension.json", json.dumps(echo_json, indent=2))

        classes_dir = ext['classes_dir']
        for root, dirs, files in os.walk(classes_dir):
            for file in files:
                full_path = os.path.join(root, file)
                rel_path = os.path.relpath(full_path, classes_dir)
                z.write(full_path, rel_path.replace('\\', '/'))

    size = os.path.getsize(jar_path)
    print(f"  -> Created {jar_path} ({size} bytes)")

    # Deploy to AppData
    appdata_jar = os.path.join(appdata_ext, ext['jar'])
    shutil.copy2(jar_path, appdata_jar)
    print(f"  -> Deployed to {appdata_jar}")

    # Deploy to desktopApp src resources
    desktop_src_ext = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\extensions')
    if os.path.exists(desktop_src_ext):
        shutil.copy2(jar_path, os.path.join(desktop_src_ext, ext['jar']))

    # Deploy to desktopApp binaries resources
    desktop_bin_ext = os.path.join(PROJECT_ROOT, r'desktopApp\build\compose\binaries\main\app\Audix\app\resources\extensions')
    if os.path.exists(desktop_bin_ext):
        shutil.copy2(jar_path, os.path.join(desktop_bin_ext, ext['jar']))

# Synchronize companion extensions
companion_jars = ['lrclib.jar', 'genius.jar', 'musixmatch.jar', 'lastfm.jar', 'discordrpc.jar']
print("\n=== 3. SYNCHRONIZING COMPANION EXTENSIONS ===")
for cj in companion_jars:
    src = os.path.join(app_resources_ext, cj)
    dst = os.path.join(appdata_ext, cj)
    if os.path.exists(src):
        shutil.copy2(src, dst)
        print(f"Synchronized {cj} ({os.path.getsize(dst)} bytes) to AppData")

print("\n=== 4. SUMMARY OF ALL EXTENSIONS IN APPDATA ===")
all_appdata_jars = sorted(glob.glob(os.path.join(appdata_ext, '*.jar')))
for j in all_appdata_jars:
    print(f"  * {os.path.basename(j)} ({os.path.getsize(j)} bytes)")

print("\nAll extensions compiled and packaged successfully!")
