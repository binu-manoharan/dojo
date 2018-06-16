fun main(args: Array<String>) {
    val acc: ArrayList<Int> = ArrayList<Int>()
    fib(0, 1, 4000000, acc)
    println(acc.filter {it % 2 == 0}.sum())

    val acc2 = fib2(0, 1, { x -> x < 4000000})
    println(acc2.filter {it % 2 == 0}.sum())
}

fun fib2(num1: Int, num2: Int, predicate: (a: Int) -> Boolean): ArrayList<Int> {
    val acc: ArrayList<Int> = ArrayList<Int>()
    
    if(predicate(num1)) {
        acc.add(num1)	
	val otherValues = fib2(num2, num1 + num2, predicate)
	acc.addAll(otherValues)
	return acc
    }
    return acc
}

tailrec fun fib(num1: Int, num2: Int, n: Int, acc: ArrayList<Int>): Int {
    if (num1 < n) {
        acc.add(num1)
        return fib(num2, num1 + num2, n, acc)
    } else { return 0 }
}

fun fibonacci(limit: Int) {
    var a = 0
    var b = 1


    for (i in 1..limit) {
	println(a)

	val btmp = b
        b = sum(a, b)
	a = btmp
    }
}

fun sum(num1: Int, num2: Int) = num1 + num2