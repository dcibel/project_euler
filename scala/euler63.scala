

def isPrime(n:Long):Boolean = {
    if (n <= 1) return false;
    return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

var foundNumbers = List[BigInt]();

(1 to Int.MaxValue).foreach { count =>

    
    println(count)
    val startValue = BigInt(math.floor(math.pow(math.pow(10, count - 1), 1.0 / count)).toInt)

    var number = startValue   //var number = BigInt(1);
    var stop = false;

    while (!stop) {
        
        val pow = number.pow(count);
        //println(number + " pow " + count + " -> " + pow);
        val digitCount = pow.toString.length;

        if (digitCount == count) {
            foundNumbers = foundNumbers :+ pow;

        } else if (digitCount > count) {
            if (number == startValue) {
                println("Matching numbers :" + foundNumbers.length);
                sys.exit()
            }
            stop = true;
        }

        number = number + 1;
    }

}
