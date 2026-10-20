import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
home_path = os.path.join(ROOT, 'desktopApp/src/desktopMain/kotlin/dev/brahmkshatriya/echo/desktop/ui/screens/HomeScreen.kt')

with open(home_path, 'r', encoding='utf-8') as fp:
    content = fp.read()

# Replace shelf sections
old_sections = """            // ------------------------------------------------------------------------------------
            // 6.5. FEATURED & TRENDING ALBUMS (Full Album Collections)
            // ------------------------------------------------------------------------------------
            item(key = "home_featured_albums_section") {
                ShelfRow(
                    shelf = homeAlbumsShelf,
                    onMediaClick = { item ->
                        selectedMediaForDetail = item
                        onMediaSelected(item)
                    },
                    onPlayTrack = { track ->
                        playerViewModel.play(track)
                    },
                    onMoreClick = {
                        selectedShelfForModal = homeAlbumsShelf
                    }
                )
            }

            // ------------------------------------------------------------------------------------
            // 6.6. POPULAR & ICONIC ARTISTS (Artist Discographies)
            // ------------------------------------------------------------------------------------
            item(key = "home_popular_artists_section") {
                ShelfRow(
                    shelf = homeArtistsShelf,
                    onMediaClick = { item ->
                        selectedMediaForDetail = item
                        onMediaSelected(item)
                    },
                    onPlayTrack = { track ->
                        playerViewModel.play(track)
                    },
                    onMoreClick = {
                        selectedShelfForModal = homeArtistsShelf
                    }
                )
            }"""

new_sections = """            // ------------------------------------------------------------------------------------
            // 6.5. FEATURED & TRENDING ALBUMS (Full Album Collections)
            // ------------------------------------------------------------------------------------
            item(key = "home_featured_albums_section") {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF38BDF8).copy(alpha = 0.20f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Default.Album,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Featured & Trending Albums",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Full album collections & tracklists • Studio master audio",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                        }

                        // "See All" Pill Button
                        LiquidGlassBox(
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = Color(0xFF0C101F).copy(alpha = 0.50f),
                            borderColor = Color.White.copy(alpha = 0.15f),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable { selectedShelfForModal = homeAlbumsShelf }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                Text("See All", fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "See All",
                                    tint = Color.White,
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        val albumsList = homeAlbumsShelf.list.filterIsInstance<Album>()
                        items(albumsList, key = { it.id }) { album ->
                            SeniorLiquidAlbumCard(
                                album = album,
                                onClick = {
                                    selectedMediaForDetail = album
                                    onMediaSelected(album)
                                },
                                onPlay = {
                                    selectedMediaForDetail = album
                                    onMediaSelected(album)
                                }
                            )
                        }
                    }
                }
            }

            // ------------------------------------------------------------------------------------
            // 6.6. POPULAR & ICONIC ARTISTS (Artist Discographies)
            // ------------------------------------------------------------------------------------
            item(key = "home_popular_artists_section") {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF38BDF8).copy(alpha = 0.20f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                            Column {
                                Text(
                                    text = "Popular & Iconic Artists",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                                Text(
                                    text = "Explore discographies, top songs & albums",
                                    fontSize = 12.sp,
                                    color = Color.White
                                )
                            }
                        }

                        // "See All" Pill Button
                        LiquidGlassBox(
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = Color(0xFF0C101F).copy(alpha = 0.50f),
                            borderColor = Color.White.copy(alpha = 0.15f),
                            modifier = Modifier
                                .pointerHoverIcon(PointerIcon.Hand)
                                .clickable { selectedShelfForModal = homeArtistsShelf }
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(5.dp)
                            ) {
                                Text("See All", fontSize = 11.5.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowForward,
                                    contentDescription = "See All",
                                    tint = Color.White,
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        val artistsList = homeArtistsShelf.list.filterIsInstance<Artist>()
                        items(artistsList, key = { it.id }) { artist ->
                            SeniorLiquidArtistCard(
                                artist = artist,
                                onClick = {
                                    selectedMediaForDetail = artist
                                    onMediaSelected(artist)
                                },
                                onPlay = {
                                    selectedMediaForDetail = artist
                                    onMediaSelected(artist)
                                }
                            )
                        }
                    }
                }
            }"""

if old_sections in content:
    print('Found old sections, replacing...')
    content = content.replace(old_sections, new_sections)
else:
    print('Warning: old sections not found verbatim in HomeScreen.kt')

# Card implementations to add
card_implementations = """// ================================================================================================
// MASTERPIECE SENIOR LIQUID ALBUM CARD COMPONENT (176.dp Grid Card)
// ================================================================================================
@Composable
private fun SeniorLiquidAlbumCard(
    album: Album,
    onClick: () -> Unit,
    onPlay: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val coverUrl = album.cover.toCoverUrl() ?: album.extras["cover_url"]

    LiquidGlassCard(
        modifier = Modifier.width(176.dp),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = if (isHovered) Color(0xFF171F36).copy(alpha = 0.85f) else Color(0xFF0F1426).copy(alpha = 0.55f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.55f) else Color.White.copy(alpha = 0.12f),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LiquidGlassBox(
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.size(152.dp)
            ) {
                if (!coverUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = album.title,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(if (isHovered) 1.05f else 1.0f),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize().background(Color(0xFF1E293B)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Album,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(52.dp)
                        )
                    }
                }

                // Album Vinyl Micro-Badge
                LiquidGlassBox(
                    shape = RoundedCornerShape(6.dp),
                    backgroundColor = Color.Black.copy(alpha = 0.75f),
                    borderColor = Color.White.copy(alpha = 0.20f),
                    modifier = Modifier.align(Alignment.TopEnd).padding(6.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Icon(Icons.Default.Album, contentDescription = null, tint = Color.White, modifier = Modifier.size(10.dp))
                        Text(
                            text = "ALBUM",
                            color = Color.White,
                            fontSize = 8.5.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // Hover Play Scrim
                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.40f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(46.dp)
                                .shadow(10.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White)
                                .clickable { onPlay() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Play Album",
                                tint = Color.Black,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }
                }
            }

            // Title & Artist
            Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    text = cleanDisplayTitle(album.title),
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = formatArtistsForDisplay(album.artists, "Audix Artist"),
                    fontSize = 11.5.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Bottom metadata pill
            LiquidGlassBox(
                shape = RoundedCornerShape(4.dp),
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                borderColor = Color.White.copy(alpha = 0.10f)
            ) {
                Text(
                    text = "Complete Album",
                    color = Color.White,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.5.dp)
                )
            }
        }
    }
}

// ================================================================================================
// MASTERPIECE SENIOR LIQUID ARTIST CARD COMPONENT (176.dp Grid Card)
// ================================================================================================
@Composable
private fun SeniorLiquidArtistCard(
    artist: Artist,
    onClick: () -> Unit,
    onPlay: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val coverUrl = artist.cover.toCoverUrl() ?: artist.extras["cover_url"]

    LiquidGlassCard(
        modifier = Modifier.width(176.dp),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = if (isHovered) Color(0xFF171F36).copy(alpha = 0.85f) else Color(0xFF0F1426).copy(alpha = 0.55f),
        borderColor = if (isHovered) Color(0xFF38BDF8).copy(alpha = 0.55f) else Color.White.copy(alpha = 0.12f),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Circular Artist Avatar
            Box(
                modifier = Modifier
                    .size(144.dp)
                    .clip(CircleShape)
                    .border(
                        width = if (isHovered) 2.dp else 1.5.dp,
                        color = if (isHovered) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.30f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (!coverUrl.isNullOrBlank()) {
                    AsyncImage(
                        model = coverUrl,
                        contentDescription = artist.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(if (isHovered) 1.08f else 1.0f),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Box(
                        modifier = Modifier.fillMaxSize().background(Color(0xFF1E293B)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(56.dp)
                        )
                    }
                }

                // Hover Play Overlay
                if (isHovered) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.45f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .shadow(8.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White)
                                .clickable { onPlay() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Default.PlayArrow,
                                contentDescription = "Play Artist",
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }
            }

            // Name & Subtitle
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = artist.name,
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = artist.subtitle ?: "Featured Artist",
                    fontSize = 11.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }

            // Bottom role pill
            LiquidGlassBox(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color(0xFF0C101F).copy(alpha = 0.70f),
                borderColor = Color.White.copy(alpha = 0.12f)
            ) {
                Text(
                    text = "Discography",
                    color = Color.White,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.5.dp)
                )
            }
        }
    }
}

"""

target_marker = '// ================================================================================================\n// ERROR GLASS STATE'
if target_marker in content and 'SeniorLiquidAlbumCard' not in content:
    print('Injecting card implementations...')
    content = content.replace(target_marker, card_implementations + target_marker)
else:
    print('SeniorLiquidAlbumCard already present or marker missing')

# Convert remaining non-white text/tint colors to Color.White
replacements = [
    ('color = Color(0xFFE2E8F0)', 'color = Color.White'),
    ('color = Color(0xFFF8FAFC)', 'color = Color.White'),
    ('color = Color(0xFFF1F5F9)', 'color = Color.White'),
    ('color = Color(0xFFD4D4D8)', 'color = Color.White'),
    ('color = Color(0xFFFAFAFA)', 'color = Color.White'),
    ('color = Color(0xFFE4E4E7)', 'color = Color.White'),
    ('color = Color(0xFF94A3B8)', 'color = Color.White'),
    ('color = Color(0xFF64748B)', 'color = Color.White'),
    ('color = Color(0xFFA1A1AA)', 'color = Color.White'),
    ('color = Color(0xFFCBD5E1)', 'color = Color.White'),
    ('tint = Color(0xFFCBD5E1)', 'tint = Color.White'),
    ('tint = Color(0xFF94A3B8)', 'tint = Color.White'),
    ('tint = Color(0xFF64748B)', 'tint = Color.White'),
    ('tint = Color(0xFFA1A1AA)', 'tint = Color.White'),
    ('tint = Color(0xFF475569)', 'tint = Color.White'),
    ('color = Color(0xFF475569)', 'color = Color.White'),
]

for old, new in replacements:
    content = content.replace(old, new)

with open(home_path, 'w', encoding='utf-8') as fp:
    fp.write(content)
print('HomeScreen.kt successfully updated!')

# Now update SearchAndOthers.kt
search_path = os.path.join(ROOT, 'desktopApp/src/desktopMain/kotlin/dev/brahmkshatriya/echo/desktop/ui/screens/SearchAndOthers.kt')
with open(search_path, 'r', encoding='utf-8') as fp:
    s_content = fp.read()

for old, new in replacements:
    s_content = s_content.replace(old, new)

s_content = s_content.replace('color = Color(0xFF1DB954)', 'color = Color.White')
s_content = s_content.replace('TextSecondary = Color(0xFF94A3B8)', 'TextSecondary = Color.White')
s_content = s_content.replace('TextMuted = Color(0xFF64748B)', 'TextMuted = Color.White')

with open(search_path, 'w', encoding='utf-8') as fp:
    fp.write(s_content)
print('SearchAndOthers.kt successfully updated!')

# Now update EchoScreensaver.kt
ss_path = os.path.join(ROOT, 'desktopApp/src/desktopMain/kotlin/dev/brahmkshatriya/echo/desktop/ui/screensaver/EchoScreensaver.kt')
with open(ss_path, 'r', encoding='utf-8') as fp:
    ss_content = fp.read()

ss_replacements = [
    ('color = Color(0xFF8E8E93)', 'color = Color.White'),
    ('color = Color(0xFF38383D)', 'color = Color.White'),
    ('color = Color(0xFFF0F9FF)', 'color = Color.White'),
    ('color = Color(0xFFE0F7FF)', 'color = Color.White'),
    ('tint = Color(0xFF8E8E93)', 'tint = Color.White'),
]
for old, new in ss_replacements:
    ss_content = ss_content.replace(old, new)

with open(ss_path, 'w', encoding='utf-8') as fp:
    fp.write(ss_content)
print('EchoScreensaver.kt successfully updated!')

# Now update ExtensionsScreen.kt
ext_path = os.path.join(ROOT, 'desktopApp/src/desktopMain/kotlin/dev/brahmkshatriya/echo/desktop/ui/screens/ExtensionsScreen.kt')
with open(ext_path, 'r', encoding='utf-8') as fp:
    ext_content = fp.read()

ext_content = ext_content.replace('if (isSelected) Color.Black else Color.White.copy(alpha = 0.6f)', 'Color.White')
ext_content = ext_content.replace('if (isSelected) Color.Black else Color.White', 'Color.White')

with open(ext_path, 'w', encoding='utf-8') as fp:
    fp.write(ext_content)
print('ExtensionsScreen.kt successfully updated!')
