

def isPrime(n:Long):Boolean = {
  if (n == 1) return true;
  
  (2L until n).forall { x => n % x != 0 };
}

def findSmallestPostiveNumberEvenlyDivisibleByNumbers(dividers:Iterable[Long]):Long = {
  val primeDividers = dividers.filter(isPrime);

  val step:Long = primeDividers.reduceLeft(_*_);
  val max:Long = dividers.reduceLeft(_*_);

  var number = step;
  while(number < max) {
    if (dividers.forall { divider => number % divider == 0 }) {
      return number;
    }
    number += step;
  }
  return -1;
}

val result = findSmallestPostiveNumberEvenlyDivisibleByNumbers((1L to 20L));

println(result);
