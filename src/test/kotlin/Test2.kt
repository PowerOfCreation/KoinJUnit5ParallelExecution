import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test2 : BaseTest() {
    @Test
    fun myTest() {
        val databaseConnector: DatabaseConnector = scope?.get<DatabaseConnector>() ?: return

        assertEquals(1, databaseConnector.getValue())

        databaseConnector.setValue(4)

        assertEquals(4, databaseConnector.getValue())
    }
}
