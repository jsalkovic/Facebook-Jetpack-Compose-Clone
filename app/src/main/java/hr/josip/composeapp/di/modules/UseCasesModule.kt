package hr.josip.composeapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hr.josip.composeapp.domain.UseCases
import hr.josip.composeapp.domain.usecases.GetFeedUseCase

@Module
@InstallIn(ActivityComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindFeedUseCase(getFeedUseCase: GetFeedUseCase): UseCases.GetFeedUseCase
}