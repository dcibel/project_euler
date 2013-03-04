
var primes = List(2L);

def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def completePrimesUntil(limit:Long) {
  while(primes.last < limit) {
    var nextCandidate = primes.last + 1L;
    while( !isPrime(nextCandidate)) {
      nextCandidate = nextCandidate + 1L;
    }
    primes = primes :+ nextCandidate;
  }
}

def primeFactorsFor(number:Long):List[Long] = {
  var factors = List[Long]();
  var remainder = number;
  completePrimesUntil(number);
  primes.foreach { x =>
    var count = 0L;
    while(remainder % x == 0) {
      count = count + 1;
      remainder = remainder / x;
    }
    factors = factors :+ count;
    if (remainder == 1) {
      return factors;
    }
  }
  return factors;
}

def hasNPrimeFactors(number:Long, n:Int):Boolean = {
  var count = 0;
  var remainder = number;
  completePrimesUntil(number);
  primes.foreach { x =>
    if (x != number) {
      if (remainder % x == 0) {
        count = count + 1;
      }
      if (count > n) {
        return false;
      }
    }
  }
  return count == n;
}


def findNConsecutiveNumbersThatHaveNDistinctPrimeFactors(n:Int):List[Long] = {
  var consecutiveNumbers = List[Long]();
  var number = 2L;
  while(consecutiveNumbers.length < n) {
    //val factors = primeFactorsFor(number);
    //if (factors.filter(x => x > 0).length == n) {
    if (hasNPrimeFactors(number, n)) {
      consecutiveNumbers = consecutiveNumbers :+ number;
    } else {
      consecutiveNumbers = List[Long]()
    }
    number = number + 1;
  }
  return consecutiveNumbers;
}

val matchingNumbers = findNConsecutiveNumbersThatHaveNDistinctPrimeFactors(4);
println(matchingNumbers(0));
