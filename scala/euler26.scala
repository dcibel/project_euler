


def divide(number:Int, dividor:Int):(Int,Int) = {
  (number / dividor, number % dividor)
}

def unitFractionCycle(dividor:Int):Seq[Int] = {
  var decimals = List[Int]();
  var remainders = List[Int]();

  var dividend:Int = 10;

  while(dividend > 0 ) {
    if (dividor > dividend) {
      dividend = dividend * 10;
      decimals = decimals :+ 0;
    } else {
      val (quotient, remainder) = divide(dividend, dividor);
    
      val remainderIndex = remainders.indexOf(remainder);

      if (remainderIndex > - 1) {
        val (fixPart:Seq[Int], recurringPart:Seq[Int]) = decimals.splitAt(remainderIndex - 1);
        return recurringPart;
      }

      decimals = decimals :+ quotient;
      remainders = remainders :+ remainder;
      dividend = remainder * 10;
    }
  }

  return List();
}

def findUnitFractionWithLongestRecurringCycleUntil(limit:Int):Int = {
  var nWithMaxCycle:Int = -1;
  var maxLength:Int = -1;
  (2 until limit).foreach { n =>
    val cycleLength = unitFractionCycle(n).length;
    if (cycleLength > maxLength) {
      maxLength = cycleLength;
      nWithMaxCycle = n;
    }
  }
  return nWithMaxCycle;
}


val n = findUnitFractionWithLongestRecurringCycleUntil(1000)
println("1/" + n + "  -->  " + unitFractionCycle(n).mkString);

