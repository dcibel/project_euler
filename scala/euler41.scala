
def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}


def findLargestPandigitalPrime():Int = {
  var largestPandigitalPrime = -1;
  (1 to 9).foreach { n =>
    val digits = (1 to n).toList;
    val sumOfDigits = digits.reduceLeft(_+_);
    val isDividableBy3 = sumOfDigits % 3 == 0;
    
    // easily eliminate a range of numbers (actually n = 2,3,5,6,7,8,9)
    if (!isDividableBy3) {
      digits.permutations.foreach { orderedDigits =>
        val number = orderedDigits.reduceLeft { (acc,x) => acc * 10 + x};
        if (isPrime(number)) {
          if (number > largestPandigitalPrime) {
            largestPandigitalPrime = number;
          }
        }
      }
    }
  }
  return largestPandigitalPrime;
}

println(findLargestPandigitalPrime());
