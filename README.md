# Run with parallel (error)

./gradlew test

# Run without parallel (works)

Open src/test/resources/junit-platform.properties and change junit.jupiter.execution.parallel.enabled to false.

./gradlew test
