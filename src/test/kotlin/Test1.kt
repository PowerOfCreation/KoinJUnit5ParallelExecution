import org.junit.jupiter.api.Test
import org.koin.test.inject
import kotlin.test.assertEquals

class Test1 : BaseTest() {
    @Test
    fun myTest() {
        val databaseConnector: DatabaseConnector by inject()

        assertEquals(1, databaseConnector.getValue())
    }
}
