


def isPrime(n:Long):Boolean = {
  if (n == 1) return true;
  
  (2L until n).forall { x => n % x != 0 };
}

val number:Long = 600851475143L
//val number:Long = 13195L

val primes = (1L to math.sqrt(number).toLong).filter { x => (number % x == 0) && isPrime(x)}

println(primes.last)
