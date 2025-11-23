package wtf.shorics.util.csv

import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy
import model.User
import wtf.shorics.model.Role

fun createUserStrategy(): HeaderColumnNameTranslateMappingStrategy<User> {
    val mapping = HashMap<String?, String?>()
    mapping["user_id"] = "id"
    mapping["mail"] = "email"

    val strategy = HeaderColumnNameTranslateMappingStrategy<User>()
    strategy.setType(User::class.java)
    strategy.setColumnMapping(mapping)

    return strategy
}

fun createRoleStrategy(): HeaderColumnNameTranslateMappingStrategy<Role> {
    val mapping = HashMap<String?, String?>()
    mapping["user_id"] = "userId"
    mapping["role"] = "permission"

    val strategy = HeaderColumnNameTranslateMappingStrategy<Role>()
    strategy.setType(Role::class.java)
    strategy.setColumnMapping(mapping)

    return strategy
}