def isInteger(x:Double):Boolean = {
  return math.floor(x) == x;
}

def quadraticEquationHasPositiveIntegerSolution(a:Long, b:Long, c:Long):Boolean = {
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

def isTriangleNumber(x:Long):Boolean = {
  return quadraticEquationHasPositiveIntegerSolution(1, 1, -2 * x);
}

def isPentagonalNumber(x:Long):Boolean = {
  return quadraticEquationHasPositiveIntegerSolution(3, -1, -2 * x);
}

def findNextTriangleNumberFrom(i:Long):Long = {
  var n = i + 1L;
  while(true) {
    val hexagonalNumber = n * ( 2 * n - 1);
    if (isTriangleNumber(hexagonalNumber) &&
        isPentagonalNumber(hexagonalNumber)) {
      return hexagonalNumber;
    }
    n = n + 1;
  }
  return -1;
}

println(findNextTriangleNumberFrom(143L));
