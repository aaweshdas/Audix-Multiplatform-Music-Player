"""
Audix Desktop - Binary and Asset Injection Script
Injects newly compiled JVM bytecode, high-resolution UI assets, and extension bundles
into the target portable runtime JARs, local development builds, and the standalone ZIP distribution.
"""

import zipfile
import os
import shutil
import sys

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
PROJECT_ROOT = os.path.dirname(SCRIPT_DIR)
os.chdir(PROJECT_ROOT)

compiled_dir = os.path.join(PROJECT_ROOT, r'build\compiled_screens')
target_jar = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar')
ref_jar = os.path.join(PROJECT_ROOT, r'tools\recovered-reference\recovered_classes.jar')

if not os.path.exists(compiled_dir):
    print(f"Error: Compiled classes directory not found at {compiled_dir}")
    print("Please run compile_desktop_app.py first.")
    sys.exit(1)

# Read compiled files
classes_to_update = {}
for root, dirs, files in os.walk(compiled_dir):
    for f in files:
        if f.endswith('.class'):
            full_path = os.path.join(root, f)
            rel_path = os.path.relpath(full_path, compiled_dir).replace('\\', '/')
            with open(full_path, 'rb') as cf:
                classes_to_update[rel_path] = cf.read()

print(f'[1/5] Scanned {len(classes_to_update)} compiled class files.')

# Read background and UI image assets
bg_img_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\audix_bg.jpg')
if os.path.exists(bg_img_path):
    with open(bg_img_path, 'rb') as f:
        img_bytes = f.read()
    classes_to_update['images/audix_bg.jpg'] = img_bytes
    classes_to_update['images/music_notes_bg.jpg'] = img_bytes
    bg_32k_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\audix_bg_32k_master.jpg')
    if os.path.exists(bg_32k_path):
        with open(bg_32k_path, 'rb') as f_32k:
            classes_to_update['images/audix_bg_32k_master.jpg'] = f_32k.read()
    print(f'[2/5] Loaded background image asset ({len(img_bytes)} bytes) and 32K Master asset')

ss_img_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\screensaver_bg.jpg')
if os.path.exists(ss_img_path):
    with open(ss_img_path, 'rb') as f_ss:
        ss_bytes = f_ss.read()
    classes_to_update['images/screensaver_bg.jpg'] = ss_bytes
    print(f'[2/5] Loaded screensaver image asset ({len(ss_bytes)} bytes)')

clock_img_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\cosmic_clock_dial.png')
if os.path.exists(clock_img_path):
    with open(clock_img_path, 'rb') as f_clock:
        clock_bytes = f_clock.read()
    classes_to_update['images/cosmic_clock_dial.png'] = clock_bytes
    print(f'[2/5] Loaded cosmic clock dial asset ({len(clock_bytes)} bytes)')

logo_img_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\audix_logo.png')
if os.path.exists(logo_img_path):
    with open(logo_img_path, 'rb') as f_logo:
        logo_bytes = f_logo.read()
    classes_to_update['images/audix_logo.png'] = logo_bytes
    classes_to_update['images/audix_logo_square.png'] = logo_bytes
    classes_to_update['images/spothub_logo.png'] = logo_bytes
    print(f'[2/5] Loaded logo image assets ({len(logo_bytes)} bytes)')

# Read all background theme images and thumbnails
bg_dir = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\backgrounds')
if os.path.exists(bg_dir):
    for f in os.listdir(bg_dir):
        fp = os.path.join(bg_dir, f)
        if os.path.isfile(fp):
            with open(fp, 'rb') as bg_f:
                classes_to_update[f'images/backgrounds/{f}'] = bg_f.read()
    print(f'[2/5] Loaded background theme assets from {bg_dir}')

# Read all 10 extension JAR assets into classpath resources
ext_dir = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\extensions')
extension_jars = {}
if os.path.exists(ext_dir):
    for ef in os.listdir(ext_dir):
        if ef.endswith('.jar'):
            full_p = os.path.join(ext_dir, ef)
            with open(full_p, 'rb') as f_ext:
                jar_data = f_ext.read()
            classes_to_update[f'extensions/{ef}'] = jar_data
            extension_jars[ef] = jar_data
    print(f'[3/5] Loaded {len(extension_jars)} extension bundles into classpath resources.')

def update_jar(jar_path):
    temp_jar = jar_path + '.tmp'
    with zipfile.ZipFile(jar_path, 'r') as zin, zipfile.ZipFile(temp_jar, 'w', compression=zipfile.ZIP_DEFLATED) as zout:
        for item in zin.infolist():
            if item.filename in classes_to_update:
                continue
            elif (item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/HomeScreenKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$HomeScreenKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screensaver/EchoScreensaverKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screensaver/ComposableSingletons$EchoScreensaverKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthersKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$SearchAndOthersKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/player/') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionsScreenKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ComposableSingletons$ExtensionsScreenKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/CuratedExtension') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionViewTab') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionCategoryFilter') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/EchoDesktopAppKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/ComposableSingletons$EchoDesktopAppKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/DesktopBackgroundManager') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/BackgroundWallpaper') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/Screen') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/UiZoomManager') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/viewmodel/PlayerViewModel') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/library/') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/download/') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/MainKt') or
                  item.filename.startswith('dev/brahmkshatriya/echo/core/extensions/JarExtensionRepository') or
                  item.filename.startswith('dev/brahmkshatriya/echo/core/platform/VlcAudioPlayer') or
                  item.filename.startswith('dev/brahmkshatriya/echo/core/platform/AudioVisualizerManager') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/EchoTrayPainter') or
                  item.filename.startswith('dev/brahmkshatriya/echo/core/network/') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/theme/') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/components/ShelfRow') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/components/ComposableSingletons$ShelfRow') or
                  item.filename.startswith('dev/brahmkshatriya/echo/desktop/ui/components/MediaCard') or
                  item.filename.startswith('dev/brahmkshatriya/echo/core/extensions/builtin/LocalMusicExtension')):
                continue
            zout.writestr(item, zin.read(item.filename))
        
        for path, data in classes_to_update.items():
            zout.writestr(path, data)
            
    os.replace(temp_jar, jar_path)
    print(f'   Successfully updated: {jar_path}')

target_jars = [
    os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar'),
    os.path.join(PROJECT_ROOT, r'desktopApp\build\compose\binaries\main\app\Audix\app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar'),
    os.path.join(PROJECT_ROOT, r'tools\recovered-reference\recovered_classes.jar')
]

print('[4/5] Injecting into application target JARs...')
for tj in target_jars:
    if os.path.exists(tj):
        update_jar(tj)

# Copy image to resource directories on disk
res_dirs = [
    os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\resources\images'),
    os.path.join(PROJECT_ROOT, r'desktopApp\build\compose\binaries\main\app\Audix\app\resources\images')
]
for rd in res_dirs:
    os.makedirs(rd, exist_ok=True)
    if os.path.exists(bg_img_path):
        shutil.copy2(bg_img_path, os.path.join(rd, 'audix_bg.jpg'))
        shutil.copy2(bg_img_path, os.path.join(rd, 'music_notes_bg.jpg'))
    if os.path.exists(logo_img_path):
        shutil.copy2(logo_img_path, os.path.join(rd, 'audix_logo.png'))
        shutil.copy2(logo_img_path, os.path.join(rd, 'audix_logo_square.png'))
        shutil.copy2(logo_img_path, os.path.join(rd, 'spothub_logo.png'))
    if os.path.exists(clock_img_path):
        shutil.copy2(clock_img_path, os.path.join(rd, 'cosmic_clock_dial.png'))
    bg_src_dir = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\backgrounds')
    if os.path.exists(bg_src_dir):
        bg_dst_dir = os.path.join(rd, 'backgrounds')
        os.makedirs(bg_dst_dir, exist_ok=True)
        for bf in os.listdir(bg_src_dir):
            shutil.copy2(os.path.join(bg_src_dir, bf), os.path.join(bg_dst_dir, bf))

# Copy all extension JARs to portable and app resource directories on disk
ext_res_dirs = [
    os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\resources\extensions'),
    os.path.join(PROJECT_ROOT, r'desktopApp\build\compose\binaries\main\app\Audix\app\resources\extensions')
]
for erd in ext_res_dirs:
    os.makedirs(erd, exist_ok=True)
    for name, data in extension_jars.items():
        with open(os.path.join(erd, name), 'wb') as ef:
            ef.write(data)

# Update desktopApp-desktop JARs with latest extensions
desktopapp_jars = [
    os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\desktopApp-desktop-4130d35d0d637cce842324b8b1d9432.jar'),
    os.path.join(PROJECT_ROOT, r'desktopApp\build\compose\binaries\main\app\Audix\app\desktopApp-desktop-4130d35d0d637cce842324b8b1d9432.jar')
]
for dj in desktopapp_jars:
    if os.path.exists(dj):
        tmp_dj = dj + '.tmp'
        with zipfile.ZipFile(dj, 'r') as zin, zipfile.ZipFile(tmp_dj, 'w', compression=zipfile.ZIP_DEFLATED) as zout:
            for item in zin.infolist():
                if item.filename.startswith('extensions/'):
                    continue
                zout.writestr(item, zin.read(item.filename))
            for name, data in extension_jars.items():
                zout.writestr(f'extensions/{name}', data)
        with open(tmp_dj, 'rb') as f_in:
            d_content = f_in.read()
        with open(dj, 'wb') as f_out:
            f_out.write(d_content)
        try:
            os.remove(tmp_dj)
        except Exception:
            pass
        print(f'   Updated {dj} with all extension bundles.')

# Update the current portable zip (Audix-v1.0.3-Windows-Portable.zip)
zip_v103 = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-v1.0.3-Windows-Portable.zip')
zip_v102 = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-v1.0.2-Windows-Portable.zip')
zip_v101 = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-v1.0.1-Windows-Portable.zip')
if not os.path.exists(zip_v103):
    if os.path.exists(zip_v102):
        shutil.copy2(zip_v102, zip_v103)
    elif os.path.exists(zip_v101):
        shutil.copy2(zip_v101, zip_v103)

portable_zips = [zip_v103]
for portable_zip in portable_zips:
    if os.path.exists(portable_zip):
        print(f'[5/5] Updating portable distribution zip: {portable_zip}...')
        zip_temp = portable_zip + '.tmp'
        rel_in_zip = 'Audix-Windows-Portable/app/recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar'
        rel_desktopapp = 'Audix-Windows-Portable/app/desktopApp-desktop-4130d35d0d637cce842324b8b1d9432.jar'
        updated_jar = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\recovered_classes-54e5364f3b10821b1e94dbe7d5dd973.jar')
        desktop_jar_disk = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\app\desktopApp-desktop-4130d35d0d637cce842324b8b1d9432.jar')
        with open(updated_jar, 'rb') as f_jar:
            jar_bytes = f_jar.read()
        desktop_jar_bytes = None
        if os.path.exists(desktop_jar_disk):
            with open(desktop_jar_disk, 'rb') as f_djar:
                desktop_jar_bytes = f_djar.read()
        with open(bg_img_path, 'rb') as f_bg:
            bg_bytes = f_bg.read()
        bat1 = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\Run-Audix.bat')
        bat2 = os.path.join(PROJECT_ROOT, r'release-artifacts\Audix-Windows-Portable\Run-Audix-Debug.bat')
        with open(bat1, 'rb') as f1: bat1_bytes = f1.read()
        with open(bat2, 'rb') as f2: bat2_bytes = f2.read()
        with zipfile.ZipFile(portable_zip, 'r') as zin, zipfile.ZipFile(zip_temp, 'w', compression=zipfile.ZIP_DEFLATED) as zout:
            skip_items = {
                rel_in_zip,
                rel_desktopapp,
                'Audix-Windows-Portable/app/resources/images/audix_bg.jpg',
                'Audix-Windows-Portable/app/resources/images/music_notes_bg.jpg',
                'Audix-Windows-Portable/app/resources/images/cosmic_clock_dial.png',
                'Audix-Windows-Portable/Run-Audix.bat',
                'Audix-Windows-Portable/Run-Audix-Debug.bat'
            }
            for name in extension_jars.keys():
                skip_items.add(f'Audix-Windows-Portable/app/resources/extensions/{name}')

            for item in zin.infolist():
                if item.filename in skip_items:
                    continue
                zout.writestr(item, zin.read(item.filename))

            zout.writestr(rel_in_zip, jar_bytes)
            if desktop_jar_bytes is not None:
                zout.writestr(rel_desktopapp, desktop_jar_bytes)
            zout.writestr('Audix-Windows-Portable/app/resources/images/audix_bg.jpg', bg_bytes)
            zout.writestr('Audix-Windows-Portable/app/resources/images/music_notes_bg.jpg', bg_bytes)
            bg_32k_path = os.path.join(PROJECT_ROOT, r'desktopApp\src\desktopMain\resources\images\audix_bg_32k_master.jpg')
            if os.path.exists(bg_32k_path):
                with open(bg_32k_path, 'rb') as f_32k:
                    zout.writestr('Audix-Windows-Portable/app/resources/images/audix_bg_32k_master.jpg', f_32k.read())
            if os.path.exists(clock_img_path):
                with open(clock_img_path, 'rb') as f_c:
                    zout.writestr('Audix-Windows-Portable/app/resources/images/cosmic_clock_dial.png', f_c.read())
            zout.writestr('Audix-Windows-Portable/Run-Audix.bat', bat1_bytes)
            zout.writestr('Audix-Windows-Portable/Run-Audix-Debug.bat', bat2_bytes)
            for name, data in extension_jars.items():
                zout.writestr(f'Audix-Windows-Portable/app/resources/extensions/{name}', data)

        with open(zip_temp, 'rb') as f_in:
            content = f_in.read()
        with open(portable_zip, 'wb') as f_out:
            f_out.write(content)
        try:
            os.remove(zip_temp)
        except Exception:
            pass
        print(f'   Updated {portable_zip} successfully with all {len(extension_jars)} extensions.')

print("Injection complete!")
