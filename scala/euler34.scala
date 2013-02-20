
def factorial(n:Int):Int = if(n==0L) 1 else n * factorial(n-1);


var maximumNumberOfDigits = 2;

var factorial9 = factorial(9);

while((maximumNumberOfDigits * factorial9).toString.length >= maximumNumberOfDigits) {
  maximumNumberOfDigits = maximumNumberOfDigits + 1;
}

val factorials = (0 to 9).map(factorial(_));

val numbers = (10 until math.pow(10, maximumNumberOfDigits).toInt).filter { n =>
  val sumOfFactorials = n.toString.foldLeft(0) { (acc, x) => acc + factorials(x.asDigit) };
  n == sumOfFactorials;
}

println(numbers.reduceLeft(_+_));
