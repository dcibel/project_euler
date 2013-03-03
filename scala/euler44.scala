
def pentagonalNumber(n:Int):Int = {
  return n * (3 * n - 1) / 2;
}

def completePentagonalSequenceUntil(pentagonalNumbers:List[Int], limit:Int):List[Int] = {
  var newPentagonalNumbers =  List() ::: pentagonalNumbers;
  while(newPentagonalNumbers.last < limit) {
    newPentagonalNumbers = newPentagonalNumbers :+ pentagonalNumber(newPentagonalNumbers.length + 1);
  }
  return newPentagonalNumbers;
}


var matchingNumbers = (-1,-1);
var pentagonalNumbers = List(pentagonalNumber(1));
var allPentagonalNumbers = pentagonalNumbers;

while(matchingNumbers._1 == -1) {
  val nextPentagonalNumber = pentagonalNumber(pentagonalNumbers.length + 1);
  pentagonalNumbers.foreach { x =>
    val difference = nextPentagonalNumber - x;
    val sum = nextPentagonalNumber + x;
    allPentagonalNumbers = completePentagonalSequenceUntil(allPentagonalNumbers, sum);
    if (allPentagonalNumbers.contains(difference) && allPentagonalNumbers.contains(sum)) {
      matchingNumbers = (x, nextPentagonalNumber);
    }
  }
  pentagonalNumbers = pentagonalNumbers :+ nextPentagonalNumber;
}

println(matchingNumbers._2 - matchingNumbers._1);
