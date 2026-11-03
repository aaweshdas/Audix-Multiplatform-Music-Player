with open('app/src/main/java/dev/brahmkshatriya/echo/ui/main/HeaderAdapter.kt', 'r', encoding='utf-8') as f:
    content = f.read()

import_stmt = '''import dev.brahmkshatriya.echo.ui.movie.CinemaDetailsBottomSheet
import dev.brahmkshatriya.echo.ui.movie.CinemaStudioBottomSheet
import dev.brahmkshatriya.echo.ui.movie.MoviePlayRepository'''

if 'import dev.brahmkshatriya.echo.ui.movie.CinemaStudioBottomSheet' not in content:
    content = content.replace('import dev.brahmkshatriya.echo.ui.settings.SettingsBottomSheet',
                              f'import dev.brahmkshatriya.echo.ui.settings.SettingsBottomSheet\n{import_stmt}')

click_listeners = '''        binding.accountsCont.setOnClickListener {
            SettingsBottomSheet().show(parentFragmentManager, null)
        }

        binding.btnCinemaStudio.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }

        binding.btnViewAllMovies.setOnClickListener {
            CinemaStudioBottomSheet().show(parentFragmentManager, null)
        }'''

content = content.replace('''        binding.accountsCont.setOnClickListener {
            SettingsBottomSheet().show(parentFragmentManager, null)
        }''', click_listeners)

bind_logic = '''        accountsCont.setLoopedLongClick(all, { all.find { it.second } }) {
            ext ?: return@setLoopedLongClick
            viewModel.setLoginUser(it.first.toEntity(ext.type, ext.id))
        }

        if (rvHeaderMovies.adapter == null) {
            val movies = MoviePlayRepository.getMovies(context)
            rvHeaderMovies.adapter = CinemaStudioBottomSheet.CinemaAdapter(movies) { movie ->
                CinemaDetailsBottomSheet.newInstance(movie).show(fragment.parentFragmentManager, null)
            }
        }'''

content = content.replace('''        accountsCont.setLoopedLongClick(all, { all.find { it.second } }) {
            ext ?: return@setLoopedLongClick
            viewModel.setLoginUser(it.first.toEntity(ext.type, ext.id))
        }''', bind_logic)

with open('app/src/main/java/dev/brahmkshatriya/echo/ui/main/HeaderAdapter.kt', 'w', encoding='utf-8') as f:
    f.write(content)
print("Updated HeaderAdapter.kt successfully")
