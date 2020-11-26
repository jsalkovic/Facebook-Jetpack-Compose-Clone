package hr.josip.composeapp.domain.repositories

import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.domain.Interactors
import hr.josip.composeapp.domain.Repositories
import javax.inject.Inject

class FeedRepository @Inject constructor(private val getFeedInteractor: Interactors.GetFeedInteractor) :
    Repositories.FeedRepository {

    override suspend fun execute(request: Unit): Feed = getFeedInteractor.execute(request)

}