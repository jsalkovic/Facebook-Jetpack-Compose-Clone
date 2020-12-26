package hr.josip.composeapp.domain

import hr.josip.composeapp.data.model.feed.response.Feed
import hr.josip.composeapp.domain.shared.BaseInteractor

interface Interactors {

    interface GetFeedInteractor : BaseInteractor<Unit, Feed>
}