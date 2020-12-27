package hr.josip.facebook.shared.manager.user

import hr.josip.facebook.data.common.User

interface UserManager {

    fun getCurrentActiveUser(): User
}