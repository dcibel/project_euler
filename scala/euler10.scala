
def isPrime(n:Long):Boolean = {
  if (n == 1) return true;
  
  (2L to n).forall { x => n % x != 0 };
}


def sumPrimeNumbersUnder(max:Long):Long = {
  val primeNumbers = (2L to max).filter { x => isPrime(x) }
  return primeNumbers.reduceLeft(_+_);
}


println(sumPrimeNumbersUnder(2000000L))
