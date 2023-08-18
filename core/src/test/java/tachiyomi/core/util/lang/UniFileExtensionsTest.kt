package tachiyomi.core.util.lang

import android.text.TextUtils
import com.hippo.unifile.UniFile
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class UniFileExtensionsTest {
    @Test
    fun testDeleteRecursively(@TempDir tempFile: File) {
        mockkStatic(TextUtils::class)
        // TextUtils.isEmpty() is called when creating UniFile. Let's mock it out
        every { TextUtils.isEmpty(any()) } returns false

        val uniFile = UniFile.fromFile(tempFile)!!

        val directoryOne = uniFile.createDirectory("directoryOne")
        val testFile = directoryOne.createFile("testFile")
        val directoryTwo = directoryOne.createDirectory("directory two")
        uniFile.deleteRecursively()

        assert(!uniFile.exists())
        assert(!testFile.exists())
        assert(!directoryOne.exists())
        assert(!directoryTwo.exists())
    }
}
