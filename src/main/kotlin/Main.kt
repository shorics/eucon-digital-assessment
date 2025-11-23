package wtf.shorics

import wtf.shorics.util.csv.parseRoles
import wtf.shorics.util.csv.parseUsers
import java.nio.file.Paths


fun main() {
    val pathUsers = Paths.get("./users.csv").toAbsolutePath()
    val pathRoles = Paths.get("./roles.csv").toAbsolutePath()

    val users = parseUsers(pathUsers) ?: return

    println(users.size)

    for (user in users)
        println(user?.email)

    val roles = parseRoles(pathRoles) ?: return

    println(roles.size)

    for (role in roles)
        println(role?.permission)
}
