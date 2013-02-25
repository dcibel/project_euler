

def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def digitsFromInt(n:Int):Seq[Int] = {
  return n.toString.map(_.asDigit);
}

def intFromDigits(digits:Seq[Int]):Int ={
  digits.reduceLeft { (acc,x) => acc * 10 + x };
}


def isReciprocalPrime(n:Int):Boolean = {
  val digits = digitsFromInt(n);
  if (!isPrime(n)) {
    return false;
  }
  (1 until digits.length).forall { i =>
    val leftSubDigits = digits.slice(0, digits.length - i);
    val rightSubDigits = digits.slice(i, digits.length);
    isPrime(intFromDigits(leftSubDigits)) && isPrime(intFromDigits(rightSubDigits));
  }
}


var reciprocalPrimes = List[Int]();
var n:Int = 10;
while(reciprocalPrimes.length < 11) {
  n = n + 1;
  if (isReciprocalPrime(n)) {
    reciprocalPrimes = reciprocalPrimes :+ n
  }
}
println(reciprocalPrimes.reduceLeft(_+_));
