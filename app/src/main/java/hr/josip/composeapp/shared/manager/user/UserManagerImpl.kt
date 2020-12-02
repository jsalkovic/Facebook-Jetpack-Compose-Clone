package hr.josip.composeapp.shared.manager.user

import hr.josip.composeapp.data.common.User
import javax.inject.Inject

class UserManagerImpl @Inject constructor() : UserManager {

    override fun getCurrentActiveUser(): User = User(
        10,
        "Josip Šalković",
        "https://scontent.fzag4-1.fna.fbcdn.net/v/t1.0-9/33527158_1008398122653200_5486756463634284544_o.jpg?_nc_cat=111&ccb=2&_nc_sid=09cbfe&_nc_ohc=LcBAIA7X9L4AX8mDd1u&_nc_ht=scontent.fzag4-1.fna&oh=82a1576ecb137748c67839732d5695f2&oe=5FEC8403",
        true
    )
}