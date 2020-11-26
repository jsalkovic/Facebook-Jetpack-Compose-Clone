package hr.josip.composeapp.data.source

import hr.josip.composeapp.data.common.User
import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.data.model.feed.response.Story
import javax.inject.Inject

class FacebookSourceImpl @Inject constructor(): FacebookSource {

    override fun getFeed(): Feed = Feed(stories = getStories)

    private val getStories: List<Story> = listOf(
        Story(
            user = User(
                "Josip",
                "Šalković",
                "https://scontent.fzag4-1.fna.fbcdn.net/v/t1.0-9/33527158_1008398122653200_5486756463634284544_o.jpg?_nc_cat=111&ccb=2&_nc_sid=09cbfe&_nc_ohc=Afn4EALhRqQAX8k_fML&_nc_ht=scontent.fzag4-1.fna&oh=b455ce2be6cf15c0c24a7317f199096f&oe=5FE49B03"
            ), isRead = false
        )
    )
}