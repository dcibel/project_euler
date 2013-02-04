
def factorial(n:BigInt):BigInt = if(n==0L) 1L else n * factorial(n-1);

def sumOfFactorialDigits(n:BigInt):Int = {
  return factorial(n).toString().foldLeft(0) { (acc,x) => acc + x.asDigit };
}

println(sumOfFactorialDigits(100L));
