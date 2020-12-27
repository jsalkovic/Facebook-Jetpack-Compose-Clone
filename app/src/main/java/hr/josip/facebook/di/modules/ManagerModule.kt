package hr.josip.facebook.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hr.josip.facebook.shared.manager.user.UserManager
import hr.josip.facebook.shared.manager.user.UserManagerImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class ManagerModule {

    @Binds
    abstract fun bindUserManager(userManagerImpl: UserManagerImpl): UserManager
}