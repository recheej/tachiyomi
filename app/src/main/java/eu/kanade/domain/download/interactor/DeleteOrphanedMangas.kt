package eu.kanade.domain.download.interactor

import eu.kanade.tachiyomi.data.download.DownloadProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import tachiyomi.domain.manga.repository.MangaRepository
import tachiyomi.domain.source.service.SourceManager

class DeleteOrphanedMangas(
    private val mangaRepository: MangaRepository,
    private val downloadProvider: DownloadProvider,
    private val sourceManager: SourceManager,
) {
    suspend fun run() {
        val nonFavoriteMangas = mangaRepository.getNonFavorites()

        return withContext(Dispatchers.IO) {
            for (manga in nonFavoriteMangas) {
                val source = sourceManager.get(manga)
                    ?: error("could not get source for manga name: ${manga.title}")

                val mangaDir = downloadProvider.findMangaDir(manga.title, source)
                mangaDir?.delete()
            }
        }
    }
}
