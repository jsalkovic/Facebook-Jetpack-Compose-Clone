package hr.josip.composeapp.domain.usecases

import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.domain.Repositories
import hr.josip.composeapp.domain.UseCases
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(private val feedRepository: Repositories.FeedRepository) :
    UseCases.GetFeedUseCase {

    override suspend fun execute(request: Unit): Feed = feedRepository.execute(request)

}