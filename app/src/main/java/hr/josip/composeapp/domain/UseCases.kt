package hr.josip.composeapp.domain

import hr.josip.composeapp.data.model.feed.response.FeedModel
import hr.josip.composeapp.domain.shared.BaseUseCase

interface UseCases {

    interface GetFeedUseCase : BaseUseCase<Unit, FeedModel>
}