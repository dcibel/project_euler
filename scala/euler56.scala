

def digitsFromBigInt(n:BigInt):Seq[Int] = {
  return n.toString.map(_.asDigit);
}

var maxSum = 0;
(100 to 1 by -1).foreach { b =>
  (1 to 100).foreach { a =>
    val number = BigInt(a).pow(b);
    val sum = digitsFromBigInt(number).reduceLeft(_+_);
    maxSum = math.max(sum, maxSum);
  }
  if (maxSum > 9 * (2 * b)) {
    println(maxSum);
    sys.exit();
  }
}
println(maxSum);
