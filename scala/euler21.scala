
import scala.collection.mutable.Map;

def dividers(number:Int):Seq[Int] = {
  var dividers = Array[Int]();
  (1 to math.sqrt(number).toInt).foreach { x =>
    if (number % x == 0) {
      dividers = dividers :+ x;
      val dividend = number / x;
      if (dividend != number) {
        dividers = dividers :+ dividend
      }
    }
  }
  return dividers;
}

def sumOfDividers(number:Int):Int = {
  dividers(number).reduceLeft(_+_);
}

def sumOfAllAmicableNumbersUnder(number:Int) = {
  var sumOfDividersByNumber = scala.collection.mutable.Map[Int,Int]();

  (1 to number).foreach { x =>
    sumOfDividersByNumber(x) = sumOfDividers(x);
  }
  
  var total = 0;
  (1 to number).foreach { x =>
    val sum = sumOfDividersByNumber(x)
    if (x < sum && sumOfDividersByNumber.contains(sum)) {
      if ((sumOfDividersByNumber(x) == sum) && (sumOfDividersByNumber(sum) == x)) {
        println( x + " and " + sum  + " are amicable number");
        total = total + x + sum;
      }
    }
  }
  total;
}

println(sumOfAllAmicableNumbersUnder(10000));
