import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test3 : BaseTest() {
    @Test
    fun myTest() {
        val databaseConnector: DatabaseConnector = scope?.get<DatabaseConnector>() ?: return

        assertEquals(1, databaseConnector.getValue())

        databaseConnector.setValue(3)

        assertEquals(3, databaseConnector.getValue())
    }
}
