package me.arkadzi.imho

import me.arkadzi.imho.data.local.RamStorage
import me.arkadzi.imho.domain.model.Post
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RamStorageTest {
    private lateinit var storage: RamStorage

    companion object {
        val post = Post(1, 1, "3", "4")
        val post2 = Post(1, 2, "3", "4")
    }

    @Before
    fun setUp() {
        storage = RamStorage()
    }

    @Test
    fun whenNoCacheEmptyListReturned() {
        val queryPosts = storage.queryPosts()
        assertEquals(queryPosts.size, 0)
    }

    @Test
    fun whenAddDataCanQuerySameData() {
        val posts = listOf(post)
        storage.savePosts(posts)
        val queryPosts = storage.queryPosts()
        assertEquals(queryPosts.size, posts.size)
        assertEquals(queryPosts[0], post)
    }

    @Test
    fun whenExternalListModifiedInternalStaysImmutable() {
        val posts = mutableListOf(post)
        storage.savePosts(posts)
        posts += post2
        val queryPosts = storage.queryPosts()
        assertEquals(queryPosts.size, 1)
    }
}
