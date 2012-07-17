
def euler6ForNumbers(numbers:Iterable[Long]):Long= {
  val sumOfSquares = numbers.foldLeft(0.0) { (acc,x) => acc + math.pow(x,2) };
  val squareOfSum = math.pow(numbers.reduceLeft(_+_),2);

  return (squareOfSum - sumOfSquares).toLong;
}


println(euler6ForNumbers((1L to 100L)))
