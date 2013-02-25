

def digitsFromInt(n:Int):Seq[Int] = {
  return n.toString.map(_.asDigit);
}

def intFromDigits(digits:Seq[Int]):Int ={
  digits.reduceLeft { (acc,x) => acc * 10 + x };
}


def isConcatenatedProductOf(n:Int, dividor:Int, vector:List[Int]):Boolean = {
  return n.toString == vector.map(_ * dividor).mkString;
}

def isConcatenatedProduct(n:Int):Boolean = {
  val digits = digitsFromInt(n);
  (1 to digits.length - 1).foreach { dividorLimit =>
    val dividor = intFromDigits(digits.slice(0, dividorLimit));
    
    var vector = List(2);
    var result = 0;
    (2 to 9).foreach { i =>
      val vector = (1 to i).toList;
      if (isConcatenatedProductOf(n, dividor, vector)) {
        return true;
      }
    }
  }
  return false;
}

//println(isConcatenatedProductOf(918273645, 9, List(1,2,3,4,5)));
//println(isConcatenatedProduct(918273645));
//println(isConcatenatedProduct(192384576));

def findProblem38Solution():Int = {
  var ninePandigitalNumbers = List(1,2,3,4,5,6,7,8,9).permutations.map(intFromDigits(_)).toList.sortWith(_>_);

  ninePandigitalNumbers.foreach { n =>
    if (isConcatenatedProduct(n)) {
      return n;
    }
  }
  return 0;
}

println(findProblem38Solution());
