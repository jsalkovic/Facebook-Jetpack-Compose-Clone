package hr.josip.facebook.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import hr.josip.facebook.shared.manager.user.UserManager
import hr.josip.facebook.shared.manager.user.UserManagerImpl

@Module
@InstallIn(ActivityComponent::class, ViewModelComponent::class)
abstract class ManagerModule {

    @Binds
    abstract fun bindUserManager(userManagerImpl: UserManagerImpl): UserManager
}