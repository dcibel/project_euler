


def integerRightTrianglesWithPerimeter(p:Int):Seq[(Int,Int,Int)] = {
  var triangles = List[(Int,Int,Int)]();
  (2 to p / 2).foreach { c =>
    (1 to (p - c) / 2).foreach { a =>
      val b = p - a - c;
      if (a*a + b*b == c*c) {
        triangles = triangles :+ (a,b,c);
      }
    }
  }

  return triangles;
}

def findPerimeterWithMaximumNumberOfIntegerRightTrianglesUntil(maxP:Int):Int = {
  var maxCount = 0;
  var foundP = 0;
  (3 to  maxP).foreach { p =>
    val count = integerRightTrianglesWithPerimeter(p).length;
    if (count > maxCount) {
      maxCount = count;
      foundP = p;
    }
  }
  return foundP;
}

println(findPerimeterWithMaximumNumberOfIntegerRightTrianglesUntil(1000));
