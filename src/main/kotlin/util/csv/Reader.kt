package wtf.shorics.util.csv

import com.opencsv.CSVReaderHeaderAware
import java.nio.file.Files
import java.nio.file.Path

@Throws(Exception::class)
fun <T>readCsvFile(filePath: Path, entityProcessor: (line: Array<String?>?) -> T): List<T> {
    val list = ArrayList<T>()

    Files.newBufferedReader(filePath).use { reader ->
        CSVReaderHeaderAware(reader).use { csvReader ->
            var line: Array<String?>?

            while (null != (csvReader.readNext().also { line = it })) {
                val entity = entityProcessor(line)
                list.add(entity)
            }
        }
    }

    return list
}