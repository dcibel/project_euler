

def factorial(n:BigInt):BigInt = if(n==0L) BigInt(1L) else n * factorial(n-1);

def c(n:BigInt,k:BigInt):BigInt = {
  return (factorial(n) / factorial(k) ) / factorial(n - k);
}

def countCBiggerThanWithNUpTo(threshold:Int, maxN:Int):Int = {
  var count = 0;
  (1 to maxN).foreach { n =>
    (1 to n).foreach { k =>
      if (c(n,k) > threshold) {
        count = count + 1;
      }
    }
  }
  return count;
}

println(countCBiggerThanWithNUpTo(1000000, 100));
