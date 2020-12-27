package hr.josip.facebook.domain

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.domain.shared.BaseRepository

interface Repositories {

    interface FeedRepository : BaseRepository<Unit, Feed>
}