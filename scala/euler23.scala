

def dividers(number:Int):Seq[Int] = {
  var dividers = Array[Int]();
  (1 to math.sqrt(number).toInt).foreach { x =>
    if (number % x == 0) {
      dividers = dividers :+ x;
      val dividend = number / x;
      if ((dividend != number)  && (dividend != x)) {
        dividers = dividers :+ dividend
      }
    }
  }
  return dividers;
}


def isAbundant(number:Int):Boolean = {
  return dividers(number).reduceLeft(_+_) > number;
}

def numberCanBeWrittenAsTheSumOfTwoNumbersInSeq(x:Int, numbers:Seq[Int]):Boolean = {
  numbers.foreach { y =>
    numbers.filter(_ >= y).foreach { z =>
      if (x == y + z) {
        return true;
      }
    }
  }
  return false;
}


def sumOfIntegersThatCannotBeWrittenAsTheSumOfTwoAbundantNumbersUnder(limit:Int):Int = {
  val abundantNumbers = (1 to limit).filter(isAbundant);

  var sum = 0;
  (1 to limit).foreach { x =>
    val lowerAbundantNumbers = abundantNumbers.filter(_ < x);

    if (!numberCanBeWrittenAsTheSumOfTwoNumbersInSeq(x, lowerAbundantNumbers)) {
      sum = sum + x;
    }
  }

  return sum;
}

println(sumOfIntegersThatCannotBeWrittenAsTheSumOfTwoAbundantNumbersUnder(28123));
