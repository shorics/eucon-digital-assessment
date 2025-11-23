package wtf.shorics

import jakarta.persistence.Persistence
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
    val pathUsers = Paths.get("./users.csv").toAbsolutePath()
    val pathRoles = Paths.get("./roles.csv").toAbsolutePath()

    val emf = Persistence.createEntityManagerFactory("main")
    val em = emf.createEntityManager()

    val users = readCsvFile(pathUsers) { line -> processUser(line) }

    em.transaction.begin();
    for (user in users)
        em.merge(user);
    em.transaction.commit();

    val roles = readCsvFile(pathRoles) { line -> processRole(line) }

    em.transaction.begin();
    for (role in roles)
        em.persist(role);
    em.transaction.commit();
}
