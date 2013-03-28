/*
def sqrt(number : BigInt) = {
  def next(n : BigInt, i : BigInt) : BigInt = (n + i/n) >> 1

  val one = BigInt(1)

  var n = one
  var n1 = next(n, number)
        
  while ((n1 - n).abs > one) {
    n = n1
    n1 = next(n, number)
  }
         
  while (n1 * n1 > number) {
    n1 -= one
  }
         
  n1
}
*/

def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}


def primeSumOfTheMostConsectivePrimes(limit:Long):Long = {
  val primes = (2L to limit).filter(isPrime(_));

  val sumByPrimeIndex = scala.collection.mutable.Map[Long,Long]();
  (0 to primes.length - 1).foreach { i =>
    sumByPrimeIndex(i) = primes(i);
  }

  val biggestSumByLength = scala.collection.mutable.Map[Int,Long]();
  var length = 2;
  var maxForLength = 2L;

  while (length < primes.length) {
    maxForLength = 0;
    (0 to primes.length - length).foreach { i =>
      val sum = sumByPrimeIndex(i) + primes(i + length - 1);
      sumByPrimeIndex(i) = sum;
      if (sum > maxForLength && sum < limit && isPrime(sum)) {
        maxForLength = sum;
      }
    }
    if (maxForLength > 0) {
      biggestSumByLength(length) = maxForLength;
    }
    length = length + 1;
  }
  
  println(biggestSumByLength.keys.max);
  return biggestSumByLength(biggestSumByLength.keys.max);
}


def time[A](f: => A) = {
  val s = System.nanoTime
  val ret = f
  println("time: "+(System.nanoTime-s)/1e6+"ms")
  ret
}

time {
  println(primeSumOfTheMostConsectivePrimes(1000000));
}
