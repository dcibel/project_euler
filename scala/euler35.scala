
def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def isCircularPrime(n:Long):Boolean = {
  var digits = n.toString.map { x => x.asDigit };
  (0 until digits.length).foreach { x =>
    digits = digits.slice(1, digits.length) :+ digits(0);
    if (!isPrime(digits.reduceLeft { (acc, y) => acc * 10 + y}) ) {
      return false;
    }
  }
  return true;
}

def listCircularPrimesUnder(upperBound:Int):Seq[Int] = {
  return (2 to upperBound).filter(isCircularPrime(_));
}

println(listCircularPrimesUnder(1000000).length);
