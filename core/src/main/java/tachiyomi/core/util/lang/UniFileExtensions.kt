package tachiyomi.core.util.lang

import com.hippo.unifile.UniFile

/**
 * Deletes file or directory and all of its children recursively
 *
 * @return Number of files deleted
 */
fun UniFile.deleteRecursively(): Int {
    var deleteCount = 0
    deleteCount += listFiles()?.sumOf { it.deleteRecursively() } ?: 0

    val deleted = delete()
    deleteCount += if (deleted) 1 else 0
    return deleteCount
}
