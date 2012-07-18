

def computeTriangleNumber(n:Int):Int = {
  return (1 to n).reduceLeft(_+_);
}

def dividers(number:Int):Seq[Int] = {
  return (1 to number).filter { x => number % x == 0 };
}


def findTriangleNumberWithAtLeastNDividers(n:Int):Int = {
  var dividersCount:Int = 0;
  var triangleNumber:Int = 0;
  var i:Int = 1;
  while(dividersCount < n) {
    triangleNumber = computeTriangleNumber(i);
    dividersCount = dividers(triangleNumber).length;
    i = i + 1;
  }
  return triangleNumber;
}

println(findTriangleNumberWithAtLeastNDividers(500));
