import org.junit.jupiter.api.Test
import org.koin.core.component.inject
import kotlin.test.assertEquals

class Test1 : BaseTest() {
    @Test
    fun myTest() {
        val databaseConnector: DatabaseConnector by inject()

        assertEquals(1, databaseConnector.getValue())

        databaseConnector.setValue(2)

        assertEquals(2, databaseConnector.getValue())
    }
}
