package hr.josip.facebook.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import hr.josip.facebook.data.source.FacebookSource
import hr.josip.facebook.data.source.FacebookSourceImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class SourceModule {

    @Binds
    abstract fun bindFacebookSource(facebookSourceImpl: FacebookSourceImpl): FacebookSource
}