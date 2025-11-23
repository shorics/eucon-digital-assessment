package wtf.shorics.util.csv

import model.User
import wtf.shorics.model.Role

fun processUser(line: Array<String?>?): User {
    val id = line?.get(0)?.toLong()
    val email = line?.get(1)
    val user = User(id, email)

    return user
}

fun processRole(line: Array<String?>?): Role {
    val userId = line?.get(0)?.toLong()
    val permission = line?.get(1)
    val role = Role(
        null,
        user = User(userId, null),
        permission = permission
    )

    return role
}