fun main(args: Array<String>) {
    var values = (1..20).toList().toTypedArray()
    val lcm = findLCM(values)
    println(product(lcm))
}

fun findLCM(values1: Array<Int>): ArrayList<Int> {
    var values = values1
    var lcm: ArrayList<Int> = ArrayList<Int>()
    do {
        val smallest = smallestValueGreaterThanOne(values)
	val nullSafeSmallest = smallest ?: 1

	lcm.add(nullSafeSmallest)
	
        values = values.map {
	    x -> if (x % nullSafeSmallest == 0) x / nullSafeSmallest else x
	}.toTypedArray()
    	
    } while(nullSafeSmallest != 1)

    return lcm
}

//fun findLCM2(values: Array<Int>


fun product(numbers: ArrayList<Int>): Int = numbers.reduce {total, next -> total * next }

fun smallestValueGreaterThanOne(values: Array<Int>): Int? {
    return values.filter { it > 1 }.min()
}

fun smallestValueGreaterThanOne1(values: ArrayList<Int>): Int? {
    return values.filter { it > 1 }.min()
}
