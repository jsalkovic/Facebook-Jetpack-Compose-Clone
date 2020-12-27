package hr.josip.facebook.domain.interactors

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.data.source.FacebookSource
import hr.josip.facebook.domain.Interactors
import javax.inject.Inject

class GetFeedInteractor @Inject constructor(private val facebookSource: FacebookSource) :
    Interactors.GetFeedInteractor {

    override suspend fun execute(request: Unit): Feed = facebookSource.getFeed()
}