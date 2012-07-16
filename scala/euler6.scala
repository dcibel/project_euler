
def isPrime(n:Long):Boolean = {
  if (n == 1) return true;
  
  (2L until n).forall { x => n % x != 0 };
}


def nthPrimeNumber(n:Int):Long = {
  var primeCount = 0;
  var number:Long = 2;

  while (true) {
    if (isPrime(number)) {
      primeCount = primeCount + 1;
      if (primeCount == n) {
        return number;
      }
    }
    number = number + 1;
  }

  return -1;

}

println(nthPrimeNumber(10001))
