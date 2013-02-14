

def isPrime(n:Long):Boolean = {
  if (n <= 0) return false;
  if (n == 1) return true;
  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def numberOfConsecutivePrimesWith(a:Int,b:Int):Int = {
  var n:Int = 0;
  var value:Int = 0;

  do {
    value = n * n + a * n + b;
    n = n + 1;
  } while(isPrime(value));

  return n;
}


def findABCoupleWithMaximumNumberOfConsecutivePrimesWithBounds(min:Int, max:Int):(Int,Int) = {
  var maxCouple = (min,min);
  var maxConsecutivePrimesLength = 0;
  (min to max).foreach { a =>
    (min to max).foreach { b =>
      println(a + "," + b);
      val count = numberOfConsecutivePrimesWith(a,b);
      if (count > maxConsecutivePrimesLength) {
        maxCouple = (a,b);
        maxConsecutivePrimesLength = count;
      }
    }
  }
  return maxCouple;
}


val (a,b) = findABCoupleWithMaximumNumberOfConsecutivePrimesWithBounds(-999, 999);

println(a + " * " + b + " = " + (a * b));
