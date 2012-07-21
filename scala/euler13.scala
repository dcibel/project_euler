
import scala.io.Source;

def sumLinesAndReturn10FirstDigits(fileName:String):String = {
  val numbers = Source.fromFile(fileName).getLines.map { line => BigInt(line) };
  val sum:BigInt = numbers.reduceLeft(_+_);
  return sum.toString().substring(0,10);
}

println(sumLinesAndReturn10FirstDigits("euler13_input"));
