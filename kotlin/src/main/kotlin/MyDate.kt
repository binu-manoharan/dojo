package samples

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        var current = start

        return object: Iterator<MyDate> {
            override fun next(): MyDate {
                val result = current
                current = current.nextDay()
                return result
            }

            override fun hasNext(): Boolean {
                return current <= endInclusive
            }
        }
    }
}

enum class TimeInterval {
    DAY,
    MONTH,
    YEAR
}

fun MyDate.nextDay() = addTimeIntervals(TimeInterval.DAY, 1)

fun MyDate.addTimeIntervals(interval: TimeInterval, number: Int): MyDate {
    val c = Calendar.getInstance()
    c.set(year, month, dayOfMonth)

    when(interval) {
        TimeInterval.DAY -> c.add(Calendar.DAY_OF_MONTH, number)
        TimeInterval.MONTH -> c.add(Calendar.MONTH, number)
        TimeInterval.YEAR -> c.add(Calendar.YEAR, number)
    }
    return MyDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
}