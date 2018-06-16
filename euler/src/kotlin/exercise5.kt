fun main(args: Array<String>) {
    var values = (1..10).toList().toTypedArray()

    do {
        val smallest = smallestValueGreaterThanOne(values)
        values = values.map { it -> }					       
    	val loop = smallest?
    } while()
    
}

fun smallestValueGreaterThanOne(values: Array<Int>): Int? {
    return values.filter { it > 1 }.min()
}
