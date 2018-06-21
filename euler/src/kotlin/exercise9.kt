fun main(args: Array<String>) {
	for(a in 1..1000) {
		for(b in 1..1000) {
			for(c in 1..1000) {
				if (a < b && b < c && a + b + c == 1000) {
					if (pow2(a) + pow2(b) == pow2(c)) {
						println(a.toString() + " " + b.toString() + " " + c.toString())
						println("product = " +  (a * b * c).toString()) 
					}
				}
			}
		}
	}
}

fun pow2(num: Int) = Math.pow(num.toDouble(), 2.toDouble()).toInt()
