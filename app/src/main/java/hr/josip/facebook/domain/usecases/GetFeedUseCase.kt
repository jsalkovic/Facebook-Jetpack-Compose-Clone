package hr.josip.facebook.domain.usecases

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.domain.Repositories
import hr.josip.facebook.domain.UseCases
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(private val feedRepository: Repositories.FeedRepository) :
    UseCases.GetFeedUseCase {

    override suspend fun execute(request: Unit): Feed = feedRepository.execute(request)

}