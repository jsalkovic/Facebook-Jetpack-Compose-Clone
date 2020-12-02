package hr.josip.composeapp.shared.manager.user

import hr.josip.composeapp.data.common.User

interface UserManager {

    fun getCurrentActiveUser(): User
}