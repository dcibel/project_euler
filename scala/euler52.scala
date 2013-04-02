


def digitsFromInt(n:Int):List[Int] = {
  var digits = n.toString.map(_.asDigit).toList;
  return digits;
}

def hasPermutedMultiples(n:Int, times:Int):Boolean = {
    var sortedDigits = digitsFromInt(n).sorted;
    return (times to 2 by -1).forall { t =>
      var multipleSortedDigits = digitsFromInt(n * t).sorted;
      multipleSortedDigits == sortedDigits;
    }
}

def findFirstPermutedMultiple(times:Int):Int = {
  (1 to Int.MaxValue).foreach { n =>
    if (hasPermutedMultiples(n, times)) {
      return n;
    }
  }
  return -1;
}

println(findFirstPermutedMultiple(6));
