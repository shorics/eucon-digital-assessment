package wtf.shorics

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.dao.DaoManager
import com.j256.ormlite.jdbc.JdbcConnectionSource
import com.j256.ormlite.table.TableUtils
import model.User
import wtf.shorics.model.Role
import wtf.shorics.util.csv.processRole
import wtf.shorics.util.csv.processUser
import wtf.shorics.util.csv.readCsvFile
import java.nio.file.Paths
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


fun main() {
    val scheduler = Executors.newScheduledThreadPool(1)
    scheduler.scheduleAtFixedRate({ runMigration() },0, 1, TimeUnit.DAYS)
}

fun runMigration() {
    val connectionString = "jdbc:h2:mem:auth"
    val username = "sa"
    val password = ""
    val pathUsers = Paths.get("./users.csv").toAbsolutePath()
    val pathRoles = Paths.get("./roles.csv").toAbsolutePath()

    val connectionSource = JdbcConnectionSource(connectionString, username, password)

    val userDao = DaoManager.createDao<Dao<User, Long>, User>(connectionSource, User::class.java)
    TableUtils.dropTable(userDao, true)
    TableUtils.createTable(userDao)

    val roleDao = DaoManager.createDao<Dao<Role, Long>, Role>(connectionSource, Role::class.java)
    TableUtils.dropTable(roleDao, true)
    TableUtils.createTable(roleDao)

    val users = readCsvFile(pathUsers) { line -> processUser(line) }

    for (user in users)
        userDao.create(user)

    val roles = readCsvFile(pathRoles) { line -> processRole(line) }

    for (role in roles)
        roleDao.create(role)
}
