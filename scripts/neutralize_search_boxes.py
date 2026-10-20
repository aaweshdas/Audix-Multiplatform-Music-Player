import re

path = 'desktopApp/src/desktopMain/kotlin/dev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthers.kt'

with open(path, 'r', encoding='utf-8') as f:
    content = f.read()

# 1. Hovered cards: 0xFF1B233A / 0xFF0C101F
content = content.replace(
    'backgroundColor = if (isHovered) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.65f),',
    'backgroundColor = if (isHovered) Color.White.copy(alpha = 0.12f) else Color(0xFF0A0C10).copy(alpha = 0.30f),'
)

# 2. Track active cards: 0xFF1B233A / 0xFF0C101F
content = content.replace(
    'backgroundColor = if (isTrackActive) Color(0xFF1B233A).copy(alpha = 0.85f) else Color(0xFF0C101F).copy(alpha = 0.60f),',
    'backgroundColor = if (isTrackActive) Color.White.copy(alpha = 0.18f) else Color(0xFF0A0C10).copy(alpha = 0.30f),'
)

# 3. Cyan hover border on those cards
content = content.replace(
    'borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),',
    'borderColor = if (isHovered) Color.White.copy(alpha = 0.45f) else Color.White.copy(alpha = 0.12f),'
)

# 4. Taste Engine pill border
content = content.replace(
    'borderColor = Color(0xFF38BDF8).copy(alpha = 0.35f)',
    'borderColor = Color.White.copy(alpha = 0.20f)'
)

# 5. Direct Color(0xFF0C101F) backgrounds
content = re.sub(r'Color\(0xFF0C101F\)\.copy\(alpha\s*=\s*0\.[0-9]+f\)', 'Color(0xFF0A0C10).copy(alpha = 0.30f)', content)

# 6. Specific modal/dialog backgrounds
content = content.replace('Color(0xFF13172A).copy(alpha = 0.65f)', 'Color(0xFF0A0C10).copy(alpha = 0.40f)')
content = content.replace('Color(0xF50B1120)', 'Color(0xFF0A0C10).copy(alpha = 0.65f)')
content = content.replace('Color(0xF70A0F1D)', 'Color(0xFF0A0C10).copy(alpha = 0.65f)')
content = content.replace('Color(0xFF141B30).copy(alpha = 0.80f)', 'Color(0xFF0A0C10).copy(alpha = 0.35f)')

with open(path, 'w', encoding='utf-8') as f:
    f.write(content)

print("SearchAndOthers.kt successfully neutralized to liquid glass!")
