package hr.josip.compose

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import hr.josip.facebook.data.common.Mock
import hr.josip.facebook.data.model.feed.response.Post
import hr.josip.facebook.ui.common.Tags
import hr.josip.facebook.ui.feed.Likes
import hr.josip.facebook.ui.main.MainActivity
import hr.josip.facebook.ui.shared.compose.ComposeAppTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.Assert

@ExperimentalCoroutinesApi
class FeedTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun likesTest() {
        var post = Mock.getPosts()[0]
        val expectedLikes = post.likes + 1
        val onLikeClicked: ((Post) -> Unit) = { post = it.copy(likes = it.likes + 1) }

        composeTestRule.setContent {
            ComposeAppTheme {
                Likes(post, onLikeClicked)
            }
        }

        composeTestRule.onNodeWithText(Tags.PostItemLikesIncrease).performClick()

        Assert.assertEquals(post.likes, expectedLikes)
    }
}