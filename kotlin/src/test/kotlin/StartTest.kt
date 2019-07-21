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
}