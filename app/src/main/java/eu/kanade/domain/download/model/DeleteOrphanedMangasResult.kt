package eu.kanade.domain.download.model

import tachiyomi.domain.manga.model.Manga
import java.lang.Exception

data class DeleteOrphanedMangasResult(
    val deletedMangas: List<Manga>,
    val deletionFailures: List<DeleteOrphanedMangasFailure>,
)

data class DeleteOrphanedMangasFailure(
    val manga: Manga,
    val exception: Exception,
)
