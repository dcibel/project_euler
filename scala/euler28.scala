

def sumDiagonalsOfNumberSpiralOfSize(maxSize:Int):Int = {
  var sum = 1;
  var lastCorner = 1;
  (3 to maxSize by 2).foreach { size =>
    val corners = (1 to 4).map { x => lastCorner + x * (size - 1) };
    sum = sum + corners.reduce(_+_);
    lastCorner = corners.last;
  }
  return sum;
}



println(sumDiagonalsOfNumberSpiralOfSize(1001));
