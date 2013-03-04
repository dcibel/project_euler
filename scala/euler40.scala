
def time[A](f: => A) = {
  val s = System.nanoTime
  val ret = f
  println("time: "+(System.nanoTime-s)/1e6+"ms")
  ret
}

def simpleD(n:Int):Int = {
  val digits = (1 to n).mkString;
  return digits(n-1).asDigit;
}

def fastD(n:Int):Int = {
  if (n < 10) {
    return n;
  }

  var powerOfTen = 2;
  var offset = 10;
  while(true) {
    val previousNumbersCount = (1 until powerOfTen).foldLeft(0) { (acc,x) => acc + math.pow(10,x).toInt } ;
    val upperBound = powerOfTen * math.pow(10, powerOfTen).toInt - previousNumbersCount;
    if (n < upperBound) {
      val number = math.pow(10, powerOfTen - 1).toInt + ((n - offset) / powerOfTen);
      
      return (number.toString()((n - offset) % powerOfTen)).asDigit
    }
    offset = upperBound;
    powerOfTen = powerOfTen + 1; 
  }

  return -1
}

val ranks = List(1, 10, 100, 1000, 10000, 100000, 1000000)

def printEuler40Solution() {
  val result = ranks.foldLeft(1) { (acc, x) => acc * simpleD(x) };
  println(result);
}

def printFastEuler40Solution() {
  val result = ranks.foldLeft(1) { (acc, x) => acc * fastD(x) };
  println(result);
}

println("\nEasy solution");
time { printEuler40Solution() };

println("\nFast solution");
time { printFastEuler40Solution() };
