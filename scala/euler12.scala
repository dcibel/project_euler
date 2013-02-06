

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

def findTriangleNumberWithAtLeastNDividers(n:Int):Int = {
  var dividersCount:Int = 0;
  var triangleNumber:Int = 0;
  var i:Int = 1;

  while(dividersCount < n) {
    triangleNumber = triangleNumber + i;
    dividersCount = dividers(triangleNumber).length;
    i = i + 1;
  }
  return triangleNumber;
}

println(findTriangleNumberWithAtLeastNDividers(500));
