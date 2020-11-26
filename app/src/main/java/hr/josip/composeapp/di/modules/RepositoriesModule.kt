package hr.josip.composeapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hr.josip.composeapp.domain.Repositories
import hr.josip.composeapp.domain.repositories.FeedRepository

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindFeedRepository(feedRepository: FeedRepository): Repositories.FeedRepository

}