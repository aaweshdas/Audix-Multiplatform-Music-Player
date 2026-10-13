import struct
import zipfile

def modify_class():
    with zipfile.ZipFile('tools/recovered-reference/recovered_classes.jar', 'r') as z:
        raw = bytearray(z.read('dev/brahmkshatriya/echo/core/extensions/JarExtensionRepository.class'))

    magic, minor, major = struct.unpack('>IHH', raw[:8])
    assert magic == 0xCAFEBABE

    offset = 8
    cp_count = struct.unpack('>H', raw[offset:offset+2])[0]
    offset += 2

    # Parse constant pool
    cp = [None] * cp_count
    i = 1
    while i < cp_count:
        tag = raw[offset]
        start = offset
        offset += 1
        if tag == 1: # Utf8
            l = struct.unpack('>H', raw[offset:offset+2])[0]
            offset += 2 + l
            cp[i] = ('Utf8', raw[start+3:offset].decode('utf-8', errors='replace'))
        elif tag in (3, 4):
            offset += 4
            cp[i] = (tag,)
        elif tag in (5, 6):
            offset += 8
            cp[i] = (tag,)
            i += 1
        elif tag in (7, 8, 16):
            offset += 2
            cp[i] = (tag,)
        elif tag in (9, 10, 11, 12, 18):
            offset += 4
            cp[i] = (tag,)
        elif tag == 15:
            offset += 3
            cp[i] = (tag,)
        else:
            raise ValueError(f"Unknown tag {tag} at cp index {i}")
        i += 1

    cp_end_offset = offset
    print(f"Original CP count: {cp_count}, CP bytes end at: {cp_end_offset}")

    # Verify Utf8 #7 is '<init>', Utf8 #941 is 'Code', Methodref #90 exists
    assert cp[7][1] == '<init>', f"Expected #7 to be <init>, got {cp[7]}"
    assert cp[941][1] == 'Code', f"Expected #941 to be Code, got {cp[941]}"
    print("Found <init> at #7 and Code at #941")

    # We will add new Utf8 at index cp_count
    new_desc = b'(Ldev/brahmkshatriya/echo/core/platform/AppPlatform;)V'
    new_desc_idx = cp_count
    new_cp_entry = bytearray([1]) + struct.pack('>H', len(new_desc)) + new_desc

    # Parse rest of class
    # access_flags (2), this_class (2), super_class (2), interfaces_count (2)
    offset = cp_end_offset
    access_flags, this_class, super_class, interfaces_count = struct.unpack('>HHHH', raw[offset:offset+8])
    offset += 8 + interfaces_count * 2

    # fields
    fields_count = struct.unpack('>H', raw[offset:offset+2])[0]
    offset += 2
    for _ in range(fields_count):
        # f_access(2), f_name(2), f_desc(2), f_attr_count(2)
        f_attr_count = struct.unpack('>H', raw[offset+6:offset+8])[0]
        offset += 8
        for _ in range(f_attr_count):
            attr_len = struct.unpack('>I', raw[offset+2:offset+6])[0]
            offset += 6 + attr_len

    methods_count_offset = offset
    methods_count = struct.unpack('>H', raw[offset:offset+2])[0]
    offset += 2
    print(f"Original methods count: {methods_count}")

    for _ in range(methods_count):
        m_attr_count = struct.unpack('>H', raw[offset+6:offset+8])[0]
        offset += 8
        for _ in range(m_attr_count):
            attr_len = struct.unpack('>I', raw[offset+2:offset+6])[0]
            offset += 6 + attr_len

    methods_end_offset = offset
    print(f"Methods end at offset: {methods_end_offset}, total class len: {len(raw)}")

    # Construct new method:
    # access_flags: ACC_PUBLIC = 0x0001
    # name_index: 7 (<init>)
    # descriptor_index: new_desc_idx
    # attributes_count: 1
    #   attribute_name_index: 941 (Code)
    #   attribute_length: 19
    #   max_stack: 3
    #   max_locals: 2
    #   code_length: 7
    #   code: aload_0 (0x2a), aload_1 (0x2b), aconst_null (0x01), invokespecial #90 (0xb7 0x00 0x5a), return (0xb1)
    #   exception_table_length: 0
    #   attributes_count: 0
    code_bytes = bytes([
        0x2a,       # aload_0
        0x2b,       # aload_1
        0x01,       # aconst_null
        0xb7, 0x00, 0x5a, # invokespecial #90
        0xb1        # return
    ])
    code_attr_body = struct.pack('>HHI', 3, 2, len(code_bytes)) + code_bytes + struct.pack('>HH', 0, 0)
    assert len(code_attr_body) == 19

    code_attr = struct.pack('>HI', 941, len(code_attr_body)) + code_attr_body
    new_method = struct.pack('>HHHH', 0x0001, 7, new_desc_idx, 1) + code_attr

    # Now assemble the new class bytearray:
    # 1. header (0..8)
    # 2. updated cp_count (cp_count + 1)
    # 3. original cp entries (10..cp_end_offset)
    # 4. new cp entry
    # 5. header after cp up to methods_count (cp_end_offset..methods_count_offset)
    # 6. updated methods_count (methods_count + 1)
    # 7. original methods (methods_count_offset+2..methods_end_offset)
    # 8. new method
    # 9. class attributes (methods_end_offset..end)

    new_raw = bytearray()
    new_raw.extend(raw[:8])
    new_raw.extend(struct.pack('>H', cp_count + 1))
    new_raw.extend(raw[10:cp_end_offset])
    new_raw.extend(new_cp_entry)
    new_raw.extend(raw[cp_end_offset:methods_count_offset])
    new_raw.extend(struct.pack('>H', methods_count + 1))
    new_raw.extend(raw[methods_count_offset+2:methods_end_offset])
    new_raw.extend(new_method)
    new_raw.extend(raw[methods_end_offset:])

    print(f"New class len: {len(new_raw)}")

    with open('scripts/JarExtensionRepository.class', 'wb') as f:
        f.write(new_raw)

    print("Wrote scripts/JarExtensionRepository.class")

if __name__ == '__main__':
    modify_class()
