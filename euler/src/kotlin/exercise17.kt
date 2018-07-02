import lib.*
import java.math.BigInteger

fun main(args: Array<String>) {
	(1..1000).map { println(numToStr(it)) }
	println((1..1000).map { numToStr(it) }.fold (0) { acc, i -> acc + i.length })
}

fun numToStr(num: Int): String {
	when (num) {
		1 -> return "one"
		2 -> return "two"
		3 -> return "three"
		4 -> return "four"
		5 -> return "five"
		6 -> return "six"
		7 -> return "seven"
		8 -> return "eight"
		9 -> return "nine"
		10 -> return "ten"
		11 -> return "eleven"
		12 -> return "twelve"
		13 -> return "thirteen"
		14 -> return "fourteen"
		15 -> return "fifteen"
		16 -> return "sixteen"
		17 -> return "seventeen"
		18 -> return "eighteen"
		19 -> return "nineteen"
		20 -> return "twenty"
		30 -> return "thirty"
		40 -> return "forty"
		50 -> return "fifty"
		60 -> return "sixty"
		70 -> return "seventy"
		80 -> return "eighty"
		90 -> return "ninety"
		100 -> return "onehundred"
		1000 -> return "onethousand"
		in 21..29 -> return numToStr10(num, 20)
		in 31..39 -> return numToStr10(num, 30) 
		in 41..49 -> return numToStr10(num, 40) 
		in 51..59 -> return numToStr10(num, 50) 
		in 61..69 -> return numToStr10(num, 60) 
		in 71..79 -> return numToStr10(num, 70) 
		in 81..89 -> return numToStr10(num, 80) 
		in 91..99 -> return numToStr10(num, 90)
		in 101..999 -> return numToStr100(num)
		else -> {
			return "uh oh"
		}
	}
}

fun numToStr100(num: Int): String {
	val mod100 = num % 100
	
	if (mod100 == 0) {
		return numToStr(num / 100) + "hundred"
	} else {
		return numToStr(num / 100 * 100) + "and" + numToStr(mod100)
	}
}

fun numToStr10(num: Int, tenth: Int): String {
	return  numToStr(tenth) + numToStr(num - tenth)
}
