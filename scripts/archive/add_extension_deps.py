with open('app/build.gradle.kts', 'r', encoding='utf-8') as f:
    content = f.read()

target = '    implementation(project(":common"))\n    // implementation(project(":core"))'
replacement = '''    implementation(project(":common"))
    implementation(project(":extensions:spotify"))
    implementation(project(":extensions:saavn"))
    implementation(project(":extensions:youtube"))
    implementation(project(":extensions:soundcloud"))
    implementation(project(":extensions:radiobrowser"))
    implementation(project(":extensions:genius"))
    implementation(project(":extensions:lrclib"))
    implementation(project(":extensions:musixmatch"))
    implementation(project(":extensions:lastfm"))
    // implementation(project(":core"))'''

if target in content:
    content = content.replace(target, replacement)
    print("Replaced with LF")
elif target.replace('\n', '\r\n') in content:
    content = content.replace(target.replace('\n', '\r\n'), replacement.replace('\n', '\r\n'))
    print("Replaced with CRLF")
else:
    print("Not found!")

with open('app/build.gradle.kts', 'w', encoding='utf-8') as f:
    f.write(content)
print("Done!")
