package wtf.shorics.util.csv

import com.opencsv.CSVReader
import com.opencsv.bean.CsvToBean
import com.opencsv.bean.CsvToBeanBuilder
import model.User
import wtf.shorics.model.Role
import java.nio.file.Files
import java.nio.file.Path

@Throws(Exception::class)
fun parseUsers(filePath: Path): MutableList<User?>? {
    val strategy = createUserStrategy()

    Files.newBufferedReader(filePath).use { reader ->
        CSVReader(reader).use { csvReader ->
            val csvToBean = CsvToBeanBuilder<User>(csvReader)
                .withMappingStrategy(strategy)
                .withType(User::class.java)
                .build()

            return csvToBean.parse()
        }
    }
}

fun parseRoles(filePath: Path): MutableList<Role?>? {
    val strategy = createRoleStrategy()

    Files.newBufferedReader(filePath).use { reader ->
        CSVReader(reader).use { csvReader ->
            val csvToBean = CsvToBeanBuilder<Role>(csvReader)
                .withMappingStrategy(strategy)
                .withType(Role::class.java)
                .build()

            return csvToBean.parse()
        }
    }
}