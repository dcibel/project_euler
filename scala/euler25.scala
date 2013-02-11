

def getFibonacciTermWithNDigits(n:Int):Long = {
  if (n == 1L) {
    return 1L;
  }

  var i:Long = 2L;
  var lastFib:BigInt = 1L;
  var nextToLastFib:BigInt = 1L;

  while(lastFib.toString.length < n) {
    i = i + 1;
    val fib:BigInt = lastFib + nextToLastFib;
    nextToLastFib = lastFib;
    lastFib = fib;
  }

  println("(" + lastFib + ")");
  return i;
}

println(getFibonacciTermWithNDigits(1000));
