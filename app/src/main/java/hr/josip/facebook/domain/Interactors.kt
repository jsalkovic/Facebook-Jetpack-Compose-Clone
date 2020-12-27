package hr.josip.facebook.domain

import hr.josip.facebook.data.model.feed.response.Feed
import hr.josip.facebook.domain.shared.BaseInteractor

interface Interactors {

    interface GetFeedInteractor : BaseInteractor<Unit, Feed>
}