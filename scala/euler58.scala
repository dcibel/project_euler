
def time[A](f: => A) = {
  val s = System.nanoTime
  val ret = f
  println("time: "+(System.nanoTime-s)/1e6+"ms")
  ret
}


def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def findSpiralSideLengthWithPrimeRatioInDiagonalsUnder(ratioBound:Double):Int = {
  var numbersCount = 1;
  var primesCount = 0.0;
  var currentNumber = 1;
  var sideLength = 1;
  var ratio = 1.0;

  while (ratio > ratioBound) {
    sideLength = sideLength + 2;
    (1 to 4).foreach { side =>
      currentNumber = currentNumber + sideLength - 1;
      if (isPrime(currentNumber)) {
        primesCount = primesCount + 1;
      }
      numbersCount = numbersCount + 1;
    }

    ratio = primesCount.toDouble / numbersCount;
  }
  return sideLength
}

time {
  println(findSpiralSideLengthWithPrimeRatioInDiagonalsUnder(0.10));
}
