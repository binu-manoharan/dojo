fun main(args: Array<String>) {
    println(exercise1(1000))
}

fun exercise1(num: Int) = listOf(1..(num - 1)).flatten().filter {isDivisibleByThreeOrFive(it)}.sum()

fun isDivisibleByThreeOrFive(num: Int) = isDivisor(num, 3) || isDivisor(num, 5)

fun isDivisor(num: Int, divisor: Int) = num % divisor == 0