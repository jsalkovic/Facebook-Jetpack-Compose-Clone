package hr.josip.facebook.domain

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.domain.shared.BaseUseCase

interface UseCases {

    interface GetFeedUseCase : BaseUseCase<Unit, Feed>
}