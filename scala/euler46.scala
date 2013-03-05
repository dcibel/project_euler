
def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;  
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}


def completeSquareDoublesSequenceUntil(sequence:List[Long], limit:Long):List[Long] = {
  var newSequence = List[Long]() ::: sequence;
  while(newSequence.last < limit) {
    val nextIndex = newSequence.length + 1L;
    newSequence = newSequence :+ (2L * nextIndex * nextIndex);
  }

  return newSequence.slice(0, newSequence.length - 1);
}

def findGoldbachConjectureCounterExample():Long = {
  var number:Long = 9;
  var squareDoubles = List(2L);
  while(true) {
    if (!isPrime(number)) {
      squareDoubles = completeSquareDoublesSequenceUntil(squareDoubles, number);
      var matchesConjecture = squareDoubles.exists { d =>
        val remainder = number - d;
        isPrime(remainder);
      }
      if (!matchesConjecture) {
        return number;
      }
    }
    number = number + 2;
  }
  return -1;
}

println(findGoldbachConjectureCounterExample());
