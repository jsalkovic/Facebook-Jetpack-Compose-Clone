package hr.josip.composeapp.domain.interactors

import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.data.source.FacebookSource
import hr.josip.composeapp.domain.Interactors
import javax.inject.Inject

class GetFeedInteractor @Inject constructor(private val facebookSource: FacebookSource) :
    Interactors.GetFeedInteractor {

    override suspend fun execute(request: Unit): Feed = facebookSource.getFeed()
}