

def getFibonacciTermWithNDigits(n:Int):Long = {
  if (n == 1L) {
    return 1L;
  }

  var i:Long = 2L;
  var lastFib:BigInt = 1L;
  var nextToLastFib:BigInt = 1L;

  val threshold:BigInt = BigInt(10).pow(n-1);

  while(lastFib < threshold) {
    i = i + 1;
    val fib:BigInt = lastFib + nextToLastFib;
    nextToLastFib = lastFib;
    lastFib = fib;
  }

  println("(" + lastFib + ")");
  return i;
}

println(getFibonacciTermWithNDigits(1000));
