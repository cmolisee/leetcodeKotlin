# Testing
## Resource
- [Phauer Blog](https://phauer.com/2018/best-practices-unit-testing-kotlin/)

### Test Class Lifecycle
- use `@TestInstance(Lifecycle.PER_CLASS)` to avoid static members
- Instead of annotating every class with `@TestInstance()` you can change the default lifecycle with the `junit-platform.properties` file
  - example `junit.jupiter.testinstance.lifecycle.default = per_class`
- Don’t use `@BeforeAll` because it forces us to use `lateinit` or `nullable types`
- put test method names in backticks
- Use `@Nested` inner classes to group the test methods
### Mocks
- use MockK to create mocks in a convenient and idiomatic way
- create mocks only once and reset them in a `@BeforeEach`
### Data Classes
- create a reference object and compare it directly with the actual object using an equality assertion
- use data classes to carry the test data (input and expected output) in a `@ParameterizedTest`


# Example
- [Testing](#testing)
  - [Resource](#resource)
    - [Test Class Lifecycle](#test-class-lifecycle)
    - [Mocks](#mocks)
    - [Data Classes](#data-classes)
- [Example](#example)
  - [Example 1](#example-1)
  - [Example 2](#example-2)
  - [Example inner class](#example-inner-class)
  - [Example mockk](#example-mockk)
- [Example mockk 2](#example-mockk-2)
  - [Example data class](#example-data-class)
  - [Example parameterized](#example-parameterized)
  - [Example helper functions](#example-helper-functions)
  - [Example test containers](#example-test-containers)

## Example 1
```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoDAOTestJUnit5 {
    private val mongo = startMongoContainer().apply {
        configure()
    }
    private val mongoDAO = MongoDAO(mongo.host, mongo.port)

    @Test
    fun foo() {
        // test mongoDAO
    }
}
```

## Example 2
```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoDAOTestJUnit5Constructor {
    private val mongo: KGenericContainer
    private val mongoDAO: MongoDAO

    init {
        mongo = startMongoContainer().apply {
            configure()
        }
        mongoDAO = MongoDAO(mongo.host, mongo.port)
    }
}
```

## Example inner class
```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DesignControllerTest {
    @Nested
    inner class GetDesigns {
        @Test
        fun `all fields are included`() {}
        @Test
        fun `limit parameter`() {}
        @Test
        fun `filter parameter`() {}
    }
    @Nested
    inner class DeleteDesign {
        @Test
        fun `design is removed from db`() {}
        @Test
        fun `return 404 on invalid id parameter`() {}
        @Test
        fun `return 401 if not authorized`() {}
    }
}
```


## Example mockk
```
val clientMock: UserClient = mockk()
val user = User(id = 1, name = "Ben")
every { clientMock.getUser(any()) } returns user
val daoMock: UserDAO = mockk(relaxed = true)

val scheduler = UserScheduler(clientMock, daoMock)
scheduler.start(1)

verifySequence {
    clientMock.getUser(1)
    daoMock.saveUser(user)
}
```


# Example mockk 2
```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DesignControllerTest {

    private val dao: DesignDAO = mockk()
    private val mapper: DesignMapper = mockk()
    private val controller = DesignController(dao, mapper)

    @BeforeEach
    fun init() {
        clearAllMocks()
    }

    // takes 250 ms
    @RepeatedTest(300)
    fun foo() {
        controller.doSomething()
    }
}
```


## Example data class
```
val actualDesign = client.requestDesign(id = 1)

val expectedDesign = Design(id = 2, userId = 9, name = "Cat")
actualDesign shouldBe expectedDesign
```


## Example parameterized
```
@ParameterizedTest
@MethodSource("validTokenProvider")
fun `parse valid tokens`(data: TestData) {
    parse(data.input) shouldBe data.expected
}

private fun validTokenProvider() = Stream.of(
    TestData(input = "1511443755_2", expected = Token(1511443755, "2")),
    TestData(input = "151175_13521", expected = Token(151175, "13521")),
    TestData(input = "151144375_id", expected = Token(151144375, "id")),
    TestData(input = "15114437599_1", expected = Token(15114437599, "1")),
    TestData(input = null, expected = null)
)

data class TestData(
    val input: String?,
    val expected: Token?
)
```


## Example helper functions
```
fun Int.toInstant(): Instant 
    = Instant.ofEpochSecond(this.toLong())

fun Int.toUUID(): UUID 
    = UUID.fromString("00000000-0000-0000-a000-${this.toString().padStart(11, '0')}")

fun String.toObjectId(): ObjectId 
    = ObjectId(this.padStart(24, '0'))

fun createDesign(
    id: Int = 1,
    name: String = "Cat",
    date: Instant = Instant.ofEpochSecond(1518278198),
    tags: Map<Locale, List<Tag>> = mapOf(
        Locale.US to listOf(Tag(value = "$name in English")),
        Locale.GERMANY to listOf(Tag(value = "$name in German"))
    )
) = Design(
    id = id,
    userId = 9,
    name = name,
    fileName = name,
    dateCreated = date,
    dateModified = date,
    tags = tags
)

// Usage
// only set the properties that are relevant for the current test
val testDesign = createDesign()
val testDesign2 = createDesign(id = 1, name = "Fox") 
val testDesign3 = createDesign(id = 1, name = "Fox", tags = mapOf())
val date1 = 1.toInstant()
val date2 = 2.toInstant()
val date3 = 3.toInstant()
val uuid1 = 1.toUUID()
val uuid2 = 2.toUUID()
```


## Example test containers
```
object MongoContainer {
    val instance by lazy { startMongoContainer() }

    private fun startMongoContainer() = KGenericContainer("mongo:4.0.2").apply {
        withExposedPorts(27017)
        setWaitStrategy(Wait.forListeningPort())
        start()
    }
}

// Usage:
class DesignDAOTest {
    private val container = MongoContainer.instance
    private val dao = DesignDAO(container.host, container.port) // pseudo-code
    @Test
    fun foo() { }
}
```