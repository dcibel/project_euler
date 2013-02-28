
def time[A](f: => A) = {
  val s = System.nanoTime
  val ret = f
  println("time: "+(System.nanoTime-s)/1e6+"ms")
  ret
}

def d(n:Int):Int = {
  val digits = (1 to n).mkString;
  return digits(n-1).asDigit;
}

def printEuler40Solution() {
  val ranks = List(1, 10, 100, 1000, 10000, 100000, 1000000)
  val result = ranks.foldLeft(1) { (acc, x) => acc * d(x) };
  println(result);
}

time { printEuler40Solution() };

/*

List(1, 10, 12, 100, 1000, 10000, 100000, 1000000).foreach { x =>
  time { println(x + " -> " + d(x)) };
}
*/


