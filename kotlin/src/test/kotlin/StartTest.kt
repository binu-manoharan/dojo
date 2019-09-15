package samples

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import kotlin.random.Random

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
    internal fun should_return_max_index_of_int_array() {
        val maxIndex: Int? = maxIndexOf(intArrayOf(5, 4, 3))
        assertThat(
                "Max value index should be 0",
                maxIndex,
                `is`(0)
        )

        assertThat(
                maxIndexOf(intArrayOf(4, 5, 3)),
                `is`(1)
        )

        assertThat(
                maxIndexOf(intArrayOf(5)),
                `is`(0)
        )
    }

    @Test
    internal fun should_return_of_the_number_of_run_sequence() {
        val runs: Int = runs(intArrayOf(0, 0, 1, 1, 0)) // 3 runs - 1 run of 0 and then 1 and then 2
        assertThat(
                "There should be three runs",
                runs,
                `is`(3)
        )
    }

    @Test
    internal fun should_return_right_results_for_palindrome_test() {
        assertThat(isPalindrome("test"), `is`(false))
        assertThat(isPalindrome("b"), `is`(true))
        assertThat(isPalindrome("bob"), `is`(true))
        assertThat(isPalindrome("malayalam"), `is`(true))
    }

    @Test
    internal fun should_list_elements_without_a_pair() {
        assertThat(findPairless(intArrayOf(1, 1, 2)), `is`(2))
        assertThat(findPairless(intArrayOf(1, 2, 2)), `is`(1))
        assertThat(findPairless(intArrayOf(2, 2, 2)), `is`(2))
        assertThat(findPairless(intArrayOf(1, 2, 1, 2, 3)), `is`(3))
    }

    @Test
    internal fun should_give_closest_to_zero() {
        assertThat(closestToZero(intArrayOf(1, 5, 10)), `is`(1))
        assertThat(closestToZero(intArrayOf(-1, 5, 10)), `is`(-1))
        assertThat(closestToZero(intArrayOf(-5, 1, 10)), `is`(1))
        assertThat(closestToZero(intArrayOf(42, -5, 12, 21, 5, 24, -5)), `is`(5))
        assertThat(closestToZero(intArrayOf()), `is`(0))
    }

    @Test
    internal fun should_lead_thor_in_the_right_direction() {
        assertThat(getDirectionsForThor(1, 1, 0, 0), contains("SE"))
        assertThat(getDirectionsForThor(1, 0, 0, 0), contains("E"))
        assertThat(getDirectionsForThor(0, 1, 0, 0), contains("S"))
        assertThat(getDirectionsForThor(1, 5, 0, 0), contains("SE", "S", "S", "S", "S"))
        assertThat(getDirectionsForThor(2, 2, 0, 0), contains("SE", "SE"))
        assertThat(getDirectionsForThor(0, 2, 2, 0), contains("SW", "SW"))
        assertThat(getDirectionsForThor(31, 4, 31, 6), contains("N", "N"))
        Random.nextInt(0,3)
    }
}