package hr.josip.composeapp.data.common

import hr.josip.composeapp.data.model.feed.response.Story

object Mock {

    fun getStories(): List<Story> {
        val stories = arrayListOf<Story>()
        stories.apply {
            add(
                Story(
                    id = 0,
                    user = User(
                        id = 0,
                        name = "",
                        avatarUrl = ""
                    ), isRead = true
                )
            )
            add(
                Story(
                    id = 1,
                    user = User(
                        id = 1,
                        name = "Android",
                        avatarUrl = "https://download.logo.wine/logo/Android_(operating_system)/Android_(operating_system)-Robot-Logo.wine.png"
                    ), isRead = false
                )
            )
            add(
                Story(
                    id = 2,
                    user = User(
                        id = 2,
                        name = "Studio",
                        avatarUrl = "https://1.bp.blogspot.com/-LgTa-xDiknI/X4EflN56boI/AAAAAAAAPuk/24YyKnqiGkwRS9-_9suPKkfsAwO4wHYEgCLcBGAsYHQ/s0/image9.png"
                    ), isRead = false
                )
            )
            add(
                Story(
                    id = 3,
                    user = User(
                        id = 3,
                        name = "Kotlin",
                        avatarUrl = "https://download.logo.wine/logo/Kotlin_(programming_language)/Kotlin_(programming_language)-Logo.wine.png"
                    ), isRead = false
                )
            )
            add(
                Story(
                    id = 4,
                    user = User(
                        id = 4,
                        name = "Twitter",
                        avatarUrl = "https://download.logo.wine/logo/Twitter/Twitter-Logo.wine.png"
                    ), isRead = false
                )
            )
            add(
                Story(
                    id = 5,
                    user = User(
                        id = 5,
                        name = "LinkedIn",
                        avatarUrl = "https://download.logo.wine/logo/LinkedIn/LinkedIn-Icon-Logo.wine.png"
                    ), isRead = false
                )
            )

        }
        return stories
    }
}

