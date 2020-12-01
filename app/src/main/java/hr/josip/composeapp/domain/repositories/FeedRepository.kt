package hr.josip.composeapp.domain.repositories

import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.domain.Interactors
import hr.josip.composeapp.domain.Repositories
import javax.inject.Inject

class FeedRepository @Inject constructor(private val getFeedInteractor: Interactors.GetFeedInteractor) :
    Repositories.FeedRepository {

    override suspend fun execute(request: Unit): FeedModel = getFeedInteractor.execute(request)

}