package samples

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class MyDateTest {
    @Test
    internal fun should_compare_my_date_objects() {
        assertThat(
                MyDate(2019, 5, 5) < MyDate(2019, 5, 10),
                `is`(true)
        )

        assertThat(
                MyDate(2019, 5, 5) > MyDate(2019, 5, 1),
                `is`(true)
        )
    }

    @Test
    internal fun should_check_if_my_date_is_in_range() {
        assertThat(
                MyDate(2019, 5, 5) in
                        DateRange(
                                MyDate(2019, 5, 1),
                                MyDate(2019, 5, 10)
                        ),
                `is`(true)
        )
        assertThat(
                MyDate(2019, 6, 5) in
                        DateRange(
                                MyDate(2019, 5, 1),
                                MyDate(2019, 5, 10)
                        ),
                `is`(false)
        )
    }
}

