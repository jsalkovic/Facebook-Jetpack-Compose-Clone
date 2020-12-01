package hr.josip.composeapp.domain

import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.domain.shared.BaseRepository

interface Repositories {

    interface FeedRepository : BaseRepository<Unit, FeedModel>
}