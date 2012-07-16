


def isPythagoreanTriplet(a:Int, b:Int, c:Int):Boolean = {
  if (a < b && b < c) {
    return math.pow(a,2) + math.pow(b,2) == math.pow(c,2);
  }
  return false;
}

def findPythagoreanTripetWhichSumIs(sum:Int):List[Int] = {
  (1 to sum - 2).foreach { a =>
    (a + 1 to sum - 1).foreach { b =>
      val c = sum - a - b;
      if (isPythagoreanTriplet(a,b,c)) {
        return List(a,b,c);
      }
    }
  }
  return List();
}


val triplet = findPythagoreanTripetWhichSumIs(1000);

println(triplet);
println(triplet.reduceLeft(_*_));
