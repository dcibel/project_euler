
def isPrime(n:Long):Boolean = {
  if (n == 1) return true;
  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}


def sumPrimeNumbersUnder(max:Long):Long = {
  val primeNumbersFrom3 = (3L to max by 2L).filter { x => isPrime(x) }
  return 2L + primeNumbersFrom3.reduceLeft(_+_);
}

println(sumPrimeNumbersUnder(2000000L))
