with open('app/src/main/java/dev/brahmkshatriya/echo/ui/main/HeaderAdapter.kt', 'r', encoding='utf-8') as f:
    c = f.read()

target = '''        binding.btnCinemaStudio.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }

        binding.btnViewAllMovies.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }'''

replacement = '''        binding.btnCinemaStudio.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }

        binding.btnInstantMix.setOnClickListener {
            dev.brahmkshatriya.echo.ui.ai.AiStudioBottomSheet().show(parentFragmentManager, null)
        }

        binding.btnViewAllMovies.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }'''

if target in c:
    c = c.replace(target, replacement)
elif target.replace('\n', '\r\n') in c:
    c = c.replace(target.replace('\n', '\r\n'), replacement.replace('\n', '\r\n'))

with open('app/src/main/java/dev/brahmkshatriya/echo/ui/main/HeaderAdapter.kt', 'w', encoding='utf-8') as f:
    f.write(c)
print("Updated HeaderAdapter with Instant Mix")
