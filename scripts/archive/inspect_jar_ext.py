import zipfile

with zipfile.ZipFile('tools/recovered-reference/recovered_classes.jar', 'r') as z:
    raw = z.read('dev/brahmkshatriya/echo/core/extensions/JarExtensionRepository.class')

import struct
offset = 8
cp_count = struct.unpack('>H', raw[offset:offset+2])[0]
offset += 2
for i in range(1, cp_count):
    tag = raw[offset]
    offset += 1
    if tag == 1:
        l = struct.unpack('>H', raw[offset:offset+2])[0]
        offset += 2
        s = raw[offset:offset+l].decode('utf-8', errors='replace')
        offset += l
        if 'AppPlatform' in s:
            print(f"Utf8 #{i}: {repr(s)}")
    elif tag in (3, 4):
        offset += 4
    elif tag in (5, 6):
        offset += 8
    elif tag in (7, 8, 16):
        offset += 2
    elif tag in (9, 10, 11, 12, 18):
        offset += 4
    elif tag == 15:
        offset += 3
