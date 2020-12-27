package hr.josip.facebook.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hr.josip.facebook.domain.Interactors
import hr.josip.facebook.domain.interactors.GetFeedInteractor

@Module
@InstallIn(ActivityComponent::class)
abstract class InteractorsModule {

    @Binds
    abstract fun bindFeedInteractor(feedInteractor: GetFeedInteractor): Interactors.GetFeedInteractor
}