package hr.josip.facebook.domain.repositories

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.domain.Interactors
import hr.josip.facebook.domain.Repositories
import javax.inject.Inject

class FeedRepository @Inject constructor(private val getFeedInteractor: Interactors.GetFeedInteractor) :
    Repositories.FeedRepository {

    override suspend fun execute(request: Unit): Feed = getFeedInteractor.execute(request)

}