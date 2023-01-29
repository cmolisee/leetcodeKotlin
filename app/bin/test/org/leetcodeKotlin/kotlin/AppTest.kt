package org.leetcodeKotlin.kotlin

import kotlin.test.Test
import kotlin.test.assertNotNull

class AppTest {
    private val classUnderTest = App()

    @Test fun `App has greeting`() {
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }
}

// val actualDesign = client.requestDesign(id = 1)

// val expectedDesign = Design(id = 2, userId = 9, name = "Cat")
// actualDesign shouldBe expectedDesign

// val actualDesigns = client.getAllDesigns()

// actualDesigns.shouldContainExactly(
//     Design(id = 1, userId = 9, name = "Cat"),
//     Design(id = 2, userId = 4, name = "Dog")
// )

// @ParameterizedTest
// @MethodSource("validTokenProvider")
// fun `parse valid tokens`(data: TestData) {
//     parse(data.input) shouldBe data.expected
// }

// private fun validTokenProvider() = Stream.of(
//     TestData(input = "1511443755_2", expected = Token(1511443755, "2")),
//     TestData(input = "151175_13521", expected = Token(151175, "13521")),
//     TestData(input = "151144375_id", expected = Token(151144375, "id")),
//     TestData(input = "15114437599_1", expected = Token(15114437599, "1")),
//     TestData(input = null, expected = null)
// )

// fun Int.toInstant(): Instant 
//     = Instant.ofEpochSecond(this.toLong())

// fun Int.toUUID(): UUID 
//     = UUID.fromString("00000000-0000-0000-a000-${this.toString().padStart(11, '0')}")

// fun String.toObjectId(): ObjectId 
//     = ObjectId(this.padStart(24, '0'))
//     val date1 = 1.toInstant()
//     val date2 = 2.toInstant()
//     val date3 = 3.toInstant()
//     val uuid1 = 1.toUUID()
//     val uuid2 = 2.toUUID()

// data class TestData(
//     val input: String?,
//     val expected: Token?
// )

// class DesignControllerTest {
//     @Nested
//     inner class GetDesigns {
//         @Test
//         fun `all fields are included`() {}
//         @Test
//         fun `limit parameter`() {}
//         @Test
//         fun `filter parameter`() {}
//     }
// }

// mocks using Mockk
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// class DesignControllerTest {

//     private val dao: DesignDAO = mockk()
//     private val mapper: DesignMapper = mockk()
//     private val controller = DesignController(dao, mapper)

//     @BeforeEach
//     fun init() {
//         clearAllMocks()
//     }

//     // takes 250 ms
//     @RepeatedTest(300)
//     fun foo() {
//         controller.doSomething()
//     }
// }