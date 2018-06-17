fun main(args: Array<String>) {
    var values = (1..20).toList().toTypedArray()
    val lcm = findLCM(values)
    println(product(lcm))
    println(findLCM3(ArrayList((1..20).toList())))
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

fun findLCM2(values: ArrayList<Int>): Int {
    val smallestNon1 = smallestValueGreaterThanOne1(values)
    if (smallestNon1 == null) {
        return 1
    } else {
      	val newValues = values.map {funkyDivide(it, smallestNon1)}
        return smallestNon1 * findLCM2(ArrayList(newValues))
    }
}

fun findLCM3(values: ArrayList<Int>): Int {
    val smallestNo1 = smallestValueGreaterThanOne1(values)
    when (smallestNo1) {
        null -> return 1
        else -> {
            val newValues = values.map {funkyDivide(it, smallestNo1)}
            return smallestNo1 * findLCM2(ArrayList(newValues))       
        }
    }
}    

fun funkyDivide(num: Int, divisor: Int): Int {
    return if ((num % divisor) == 0) num / divisor else num 
}

fun product(numbers: ArrayList<Int>): Int = numbers.reduce {total, next -> total * next }

fun smallestValueGreaterThanOne(values: Array<Int>): Int? {
    return values.filter { it > 1 }.min()
}

fun smallestValueGreaterThanOne1(values: ArrayList<Int>): Int? {
    return values.filter { it > 1 }.min()
}
