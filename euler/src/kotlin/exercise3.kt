//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?

fun main(args: Array<String>) {
   println("Exercise 3")
   println(factors(600851475143L))
}

fun factors(num: Long): ArrayList<Long> {
    val fact: ArrayList<Long> = ArrayList<Long>()
    for(i in 2..num) {
        if (isPerfectlyDivisible(num, i)) {
	   fact.add(i)
	   fact.addAll(factors(num/i))
	   return fact 
	}
    }
    
    return fact
}

fun isPerfectlyDivisible(num: Long, divisor: Long) = num % divisor == 0L 
