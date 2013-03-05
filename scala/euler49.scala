

def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def digitsFromInt(n:Int):Seq[Int] = {
  return n.toString.map(_.asDigit);
}

def intFromDigits(digits:Seq[Int]):Int ={
  digits.reduceLeft { (acc,x) => acc * 10 + x };
}

def findProblem49SequenceStartingWith(number:Int):Seq[Int] = {
  val permutedNumbers = digitsFromInt(number).permutations.map(intFromDigits(_)).toList;
  val sequence = permutedNumbers.filter(_>=number).filter(isPrime(_));
  if (sequence.length < 3) {
    return Nil;
  }
  sequence.combinations(3).foreach { combination =>
    val sortedCombination = combination.sortWith(_<_);
    val step1 = sortedCombination(1) - sortedCombination(0);
    val step2 = sortedCombination(2) - sortedCombination(1);
    if (step1 == step2) {
      return sortedCombination;
    }
  }
  return Nil;
}

var numbers = (1000 to 9999).toList;

(1488 to 9999).foreach { firstNumber =>
  if (isPrime(firstNumber)) {
    val matchingSequence = findProblem49SequenceStartingWith(firstNumber);
    if (matchingSequence != Nil) {
      println(matchingSequence.mkString);
      sys.exit();
    }
  }
}
