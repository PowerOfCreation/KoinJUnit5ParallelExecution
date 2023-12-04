import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import org.koin.core.component.KoinScopeComponent
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest : KoinScopeComponent {

    companion object {
        private val lock = Any()

        var isKoinSetup = false
    }

    override lateinit var scope: Scope

    private val module = module {
        scope(named(Thread.currentThread().name)) {
            scoped { DatabaseConnector() }
        }
    }

    @BeforeEach
    fun setUp() {
        synchronized(lock) {
            if (isKoinSetup) {
                loadKoinModules(
                    module
                )
            } else {
                isKoinSetup = true
                startKoin {
                    modules(
                        module
                    )
                }
            }

            scope = getKoin().getOrCreateScope(Thread.currentThread().name, named(Thread.currentThread().name))
        }
    }
}
