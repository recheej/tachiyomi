package eu.kanade.domain.download.interactor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import eu.kanade.domain.download.model.DeleteOrphanedMangasFailure
import eu.kanade.domain.download.model.DeleteOrphanedMangasResult
import tachiyomi.domain.manga.model.Manga
import tachiyomi.domain.manga.repository.MangaRepository

class DeleteOrphanedMangas(
    private val mangaRepository: MangaRepository,
    private val downloadProvid
) {
    suspend fun run(): DeleteOrphanedMangasResult {
        val nonFavoriteMangas = mangaRepository.getNonFavorites()

        return withContext(Dispatchers.IO) {
            val successMangas = mutableListOf<Manga>()
            val deletionFailures = mutableListOf<DeleteOrphanedMangasFailure>()

            for(manga in nonFavoriteMangas) {

            }
        }
    }
}
