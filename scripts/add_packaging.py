with open('app/build.gradle.kts', 'r', encoding='utf-8') as f:
    c = f.read()

target = '''    androidResources {
        @Suppress("UnstableApiUsage")
        generateLocaleConfig = true
    }
}'''

replacement = '''    androidResources {
        @Suppress("UnstableApiUsage")
        generateLocaleConfig = true
    }

    packaging {
        resources {
            excludes += "META-INF/echo-extension.json"
            excludes += "META-INF/*.version"
        }
    }
}'''

if target in c:
    c = c.replace(target, replacement)
elif target.replace('\n', '\r\n') in c:
    c = c.replace(target.replace('\n', '\r\n'), replacement.replace('\n', '\r\n'))

with open('app/build.gradle.kts', 'w', encoding='utf-8') as f:
    f.write(c)
print("Added packaging block to app/build.gradle.kts")
