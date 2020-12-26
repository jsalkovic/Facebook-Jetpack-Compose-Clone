package hr.josip.composeapp.data.common

import hr.josip.composeapp.data.model.feed.response.Post
import hr.josip.composeapp.data.model.feed.response.Story
import hr.josip.composeapp.data.model.feed.response.StoryState
import hr.josip.composeapp.shared.manager.user.UserManager

object Mock {

    fun getStories(userManager: UserManager): List<Story> = arrayListOf<Story>().apply {
        add(
            Story(
                id = 0,
                user = userManager.getCurrentActiveUser(), storyState = StoryState.READ
            )
        )
        add(
            Story(
                id = 1,
                user = User(
                    id = 1,
                    name = "Android",
                    avatarUrl = "https://download.logo.wine/logo/Android_(operating_system)/Android_(operating_system)-Robot-Logo.wine.png",
                ), storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 2,
                user = User(
                    id = 2,
                    name = "Studio",
                    avatarUrl = "https://1.bp.blogspot.com/-LgTa-xDiknI/X4EflN56boI/AAAAAAAAPuk/24YyKnqiGkwRS9-_9suPKkfsAwO4wHYEgCLcBGAsYHQ/s0/image9.png"
                ), storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 3,
                user = User(
                    id = 3,
                    name = "Kotlin",
                    avatarUrl = "https://download.logo.wine/logo/Kotlin_(programming_language)/Kotlin_(programming_language)-Logo.wine.png"
                ), storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 4,
                user = User(
                    id = 4,
                    name = "Twitter",
                    avatarUrl = "https://download.logo.wine/logo/Twitter/Twitter-Logo.wine.png"
                ), storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 5,
                user = User(
                    id = 5,
                    name = "LinkedIn",
                    avatarUrl = "https://download.logo.wine/logo/LinkedIn/LinkedIn-Icon-Logo.wine.png"
                ), storyState = StoryState.UNREAD
            )
        )
    }

    fun getPosts(): List<Post> = arrayListOf<Post>().apply {
        add(
            Post(
                id = 0,
                user = User(
                    id = 1,
                    name = "Android",
                    avatarUrl = "https://download.logo.wine/logo/Android_(operating_system)/Android_(operating_system)-Robot-Logo.wine.png",
                    isOnline = true
                ),
                text = "Meet Jetpack Compose, our new UI toolkit, now in alpha! See how ...\n" +
                    "\n" +
                    "✏️ It's written entirely in @Kotlin\n" +
                    "\uD83D\uDDA5️ Is unbundled from OS\n" +
                    "\uD83D\uDC68\u200D\uD83D\uDCBB Embraces a declarative programming model\n" +
                    "\uD83D\uDE0E And more!\n" +
                    "\n" +
                    "Learn more → goo.gle/2YA7heU",
                imageUrl = "https://on.notist.cloud/slides/deck3159/large-0.jpg"
            )
        )
        add(
            Post(
                id = 0,
                user = User(
                    id = 1,
                    name = "Android",
                    avatarUrl = "https://download.logo.wine/logo/Android_(operating_system)/Android_(operating_system)-Robot-Logo.wine.png",
                    isOnline = false
                ),
                text = "Meet Jetpack Compose, our new UI toolkit, now in alpha! See how ...\n" +
                    "\n" +
                    "✏️ It's written entirely in @Kotlin\n" +
                    "\uD83D\uDDA5️ Is unbundled from OS\n" +
                    "\uD83D\uDC68\u200D\uD83D\uDCBB Embraces a declarative programming model\n" +
                    "\uD83D\uDE0E And more!\n" +
                    "\n" +
                    "Learn more → goo.gle/2YA7heU",
                imageUrl = "https://on.notist.cloud/slides/deck3159/large-0.jpg"
            )
        )
    }
}

