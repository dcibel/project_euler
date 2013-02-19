

def reduceFraction(fraction:(Int,Int)):(Int,Int) = {
  (2 to fraction._2).foreach { n =>
    if ((fraction._2 % n == 0) && (fraction._1 % n == 0)) {
      return reduceFraction(fraction._1 / n, fraction._2 / n);
    }
  }
  return fraction;
}

def findProblem33NonTrivialCancellingFractions():List[(Int,Int)] = {
  //(1 to 99).foreach { numerator =>
  //  (x + 1 to 99) { denominator =>
  //    val cancelledFraction = findCancelledFraction(numerator, denominator)
  //  }
  //}

  var cancelingFractions = List[(Int,Int)]();
  (1 to 8).foreach { numerator =>
    (numerator + 1 to 9).foreach { denominator =>
      val fraction:(Int, Int) = (numerator, denominator);
      (1 to 9).foreach { cancelledDigit =>
        val fraction1 = (cancelledDigit * 10 + numerator, cancelledDigit * 10 + denominator);
        val fraction2 = (cancelledDigit + numerator * 10, cancelledDigit + 10 * denominator);
        val fraction3 = (cancelledDigit + numerator * 10, cancelledDigit * 10 + denominator);
        val fraction4 = (cancelledDigit * 10 + numerator, cancelledDigit + 10 * denominator);
        val candidates:List[(Int,Int)] = List(fraction1, fraction2, fraction3, fraction4);
        
        candidates.foreach { candidate =>
          if (fraction._1 * candidate._2 == fraction._2 * candidate._1) {
            cancelingFractions = cancelingFractions :+ fraction;
            println(fraction._1 + " / " + fraction._2 + " = " + candidate._1 + " / " + candidate._2);
          }
        }
      }
    }
  }

  return cancelingFractions;
}


val productFraction = findProblem33NonTrivialCancellingFractions().foldLeft((1,1)) { (acc, x) =>
  (acc._1 * x._1, acc._2 * x._2);
}

println(reduceFraction(productFraction)._2);
