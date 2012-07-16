
import scala.collection.mutable.Queue

def findBiggest5DigitsSuiteProductInFile(fileName:String):Number = {

  val digits:String = scala.io.Source.fromFile(fileName).getLines.reduceLeft(_+_);
  
  var max:Int = 0;
  var lastFiveDigits = Queue[Int]();

  digits.foreach { x =>
    val number:Int = x.asDigit;

    lastFiveDigits.enqueue(number);

    if (lastFiveDigits.length > 5) {
      lastFiveDigits.dequeue()
    }

    if (lastFiveDigits.length == 5) {
      val product = lastFiveDigits.reduceLeft(_*_);

      max = math.max(max, product);
    }
  }

  return max;
}

val max = findBiggest5DigitsSuiteProductInFile("euler8_input");

println(max)
