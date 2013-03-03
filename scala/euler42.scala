import scala.io.Source;

def isInteger(x:Double):Boolean = {
  return math.floor(x) == x;
}

def quadraticEquationHasPositiveIntegerSolution(a:Int, b:Int, c:Int):Boolean = {
  val delta = b * b - 4 * a * c;
  if (delta < 0) {
    return false;
  }
  val deltaSqrt = math.sqrt(delta);
  if (!isInteger(deltaSqrt)) {
    return false;
  }
  val x1 = (-b - math.sqrt(delta)) / ( 2 * a);
  if (x1 > 0 && isInteger(x1)) {
    return true;
  }
  val x2 = (-b + math.sqrt(delta)) / ( 2 * a);
  if (x2 > 0 && isInteger(x2)) {
    return true;
  }

  return false;
}

def isTriangleNumber(x:Int):Boolean = {
  // t(n) = 1/2 * n * (n + 1)
  // 2*t(n) = n * (n + 1)
  // n*n + n - 2*t(n) = 0
  // n*n + n - 2*x = 0
  return quadraticEquationHasPositiveIntegerSolution(1, 1, -2 * x);
}

def isTriangleWord(word:String):Boolean = {
  val score = word.foldLeft(0) { (acc,x) => acc + (x - 'A' + 1)};
  return isTriangleNumber(score);
}

def countTriangleWordsInFile(fileName:String):Int = {
  val fileContent:String = Source.fromFile(fileName).getLines.reduceLeft(_+_);
  val names = fileContent.split(",").map { s => s.substring(1, s.length - 1) }

  return names.filter(isTriangleWord(_)).length
}

//println(isTriangleWord("SKY"));
println(countTriangleWordsInFile("euler42_input"));
