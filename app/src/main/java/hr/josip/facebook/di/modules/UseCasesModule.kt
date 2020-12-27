package hr.josip.facebook.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hr.josip.facebook.domain.UseCases
import hr.josip.facebook.domain.usecases.GetFeedUseCase

@Module
@InstallIn(ActivityComponent::class)
abstract class UseCasesModule {

    @Binds
    abstract fun bindFeedUseCase(getFeedUseCase: GetFeedUseCase): UseCases.GetFeedUseCase
}