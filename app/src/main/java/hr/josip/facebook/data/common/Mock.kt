package hr.josip.facebook.data.common

import hr.josip.facebook.data.model.feed.response.Post
import hr.josip.facebook.data.model.feed.response.Story
import hr.josip.facebook.data.model.feed.response.StoryState
import hr.josip.facebook.shared.manager.user.UserManager

object Mock {

    fun getStories(userManager: UserManager): List<Story> = arrayListOf<Story>().apply {
        add(
            Story(
                id = 0,
                user = userManager.getCurrentActiveUser(),
                storyState = StoryState.READ
            )
        )
        add(
            Story(
                id = 1,
                user = getUsers()[0],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 2,
                user = getUsers()[1],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 3,
                user = getUsers()[2],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 4,
                user = getUsers()[3],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 5,
                user = getUsers()[4],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 6,
                user = getUsers()[5],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 7,
                user = getUsers()[6],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 8,
                user = getUsers()[7],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 9,
                user = getUsers()[8],
                storyState = StoryState.UNREAD
            )
        )
        add(
            Story(
                id = 10,
                user = getUsers()[9],
                storyState = StoryState.UNREAD
            )
        )
    }

    fun getPosts(): List<Post> = arrayListOf<Post>().apply {
        add(
            Post(
                id = 0,
                user = getUsers()[0],
                text = "\uD83D\uDCAA Back to training!  \n" +
                    "\uD83D\uDCCD Tito Vilanova pitch\n" +
                    "\uD83D\uDC64 Leo Messi is expected to rejoin training after #BarçaEibar",
                imageUrl = "https://pbs.twimg.com/media/EqPevFZXAAAQ4YS?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 1,
                user = getUsers()[1],
                text = "Round of 16 draw ✔️\n" +
                    "Which tie are you most excited for? \uD83E\uDD29\n" +
                    "#UCLdraw | #UCL ",
                imageUrl = "https://pbs.twimg.com/media/EpMc4q5XMAEXkJ5?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 2,
                user = getUsers()[2],
                text = "⚽⚒️\uD83D\uDD19 The players return to training at #RMCity at 16:30 CET today!\n" +
                    "#HalaMadrid",
                imageUrl = "https://pbs.twimg.com/media/EqO9E_bW4AENZmC?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 3,
                user = getUsers()[3],
                text = "Next up, @WBA (H) \uD83D\uDCAA\n" +
                    "UP THE REDS \uD83D\uDD34",
                imageUrl = "https://pbs.twimg.com/media/Ep2pgkmXYAAq_3m?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 4,
                user = getUsers()[4],
                text = "\uD83E\uDD4A Coming up on Boxing Day...\n" +
                    "#LEIMUN \uD83D\uDD1C",
                imageUrl = "https://pbs.twimg.com/media/EqGSPLOW4AAmLKO?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 5,
                user = getUsers()[5],
                text = "\uD83D\uDD1A⚽️ The Parisians finish 2020 in style with a big victory! \uD83D\uDC4F❤️\uD83D\uDC99\n" +
                    "@PSG_English 4⃣-0⃣ @RCSA",
                imageUrl = "https://pbs.twimg.com/media/Ep9CRlIXYAYnPxp?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 6,
                user = getUsers()[6],
                text = "\uD83E\uDDE4 Best European goalkeeper in 2020 is ________!",
            )
        )
        add(
            Post(
                id = 7,
                user = getUsers()[7],
                text = "The games keep coming! \uD83D\uDCAA\n" +
                    "\uD83D\uDD37 #ManCity | https://t.co/axa0klUGiM",
                imageUrl = "https://pbs.twimg.com/media/EqPIBW_XEAAG4IB?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 8,
                user = getUsers()[8],
                text = "\uD835\uDD46\uD835\uDD4Cℝ \uD83D\uDD1D \uD835\uDFDA\uD835\uDFD8 \uD835\uDD3E\uD835\uDD46\uD835\uDD38\uD835\uDD43\uD835\uDD4A \uD835\uDD46\uD835\uDD3D \uD835\uDFDA⚽️\uD835\uDFDA⚽️!\n" +
                    "⏯ juve.it/rwtL30rq23h\n" +
                    "\uD83E\uDD14 Your favourite strike of the year? \uD83D\uDC47",
                imageUrl = "https://pbs.twimg.com/media/EqPhYSUW4AAPKd5?format=jpg&name=large"
            )
        )
        add(
            Post(
                id = 9,
                user = getUsers()[9],
                text = "\uD83D\uDD25 Round of 32 draw! \uD83D\uDD25\n" +
                    "Which game are you most looking forward to? \uD83E\uDD14\n" +
                    "#UELdraw",
                imageUrl = "https://pbs.twimg.com/media/EpMsPpvWEAAGxNA?format=jpg&name=large"
            )
        )
    }

    private fun getUsers(): List<User> = arrayListOf<User>().apply {
        add(
            User(
                id = 1,
                name = "FC Barcelona",
                avatarUrl = "https://pbs.twimg.com/profile_images/1333096463916797954/7bzarkH2_400x400.jpg",
                isOnline = true
            )
        )
        add(
            User(
                id = 2,
                name = "UEFA Champions League",
                avatarUrl = "https://pbs.twimg.com/profile_images/1073607078109949957/74oimLX4_400x400.jpg",
                isOnline = false
            )
        )
        add(
            User(
                id = 3,
                name = "Real Madrid",
                avatarUrl = "https://pbs.twimg.com/profile_images/1284197749030887429/7n6w-Urk_400x400.jpg",
                isOnline = true
            )
        )
        add(
            User(
                id = 4,
                name = "Liverpool FC",
                avatarUrl = "https://pbs.twimg.com/profile_images/1338403510463983616/OKTADee9_400x400.png",
                isOnline = false
            )
        )
        add(
            User(
                id = 5,
                name = "Manchester United",
                avatarUrl = "https://pbs.twimg.com/profile_images/1338414846879166467/9arznr7Y_400x400.jpg",
                isOnline = true
            )
        )
        add(
            User(
                id = 6,
                name = "PSG",
                avatarUrl = "https://pbs.twimg.com/profile_images/1209045250146263042/8CWGSrm9_400x400.jpg",
                isOnline = false
            )
        )
        add(
            User(
                id = 7,
                name = "UEFA EURO 2020",
                avatarUrl = "https://pbs.twimg.com/profile_images/1335918719382511617/SeNcnviO_400x400.jpg",
                isOnline = true
            )
        )
        add(
            User(
                id = 8,
                name = "Manchester City",
                avatarUrl = "https://pbs.twimg.com/profile_images/1339132670169804801/SeYDEWVq_400x400.jpg",
                isOnline = false
            )
        )
        add(
            User(
                id = 9,
                name = "Juventus FC",
                avatarUrl = "https://pbs.twimg.com/profile_images/1278088542619648003/ZUXZa8hJ_400x400.jpg",
                isOnline = true
            )
        )
        add(
            User(
                id = 10,
                name = "UEFA Europa League",
                avatarUrl = "https://pbs.twimg.com/profile_images/1006162739004366848/TtG0BRfT_400x400.jpg",
                isOnline = false
            )
        )
    }
}

