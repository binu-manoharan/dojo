package samples

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class StartTest {
    @Test
    internal fun should_return_1() {
        val one: String = greetingMessage()
        assertThat(
                "Set up test function returns 1",
                one,
                `is`("hello world!")
        )
    }

    @Test
    internal fun should_return_1_as_max_index_of_int_array() {
        val maxIndex: Int? = maxIndexOf(intArrayOf(5, 4, 3))
        assertThat(
                "Max value index should be 0",
                maxIndex,
                `is`(0)
        )
    }
}