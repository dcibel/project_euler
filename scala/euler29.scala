

def distinctTermsOfProblem29CombinationResultsInRange(range:Range):Int = {
  var combinations:List[(Int,Int)] = List();
  range.foreach { b =>
    range.foreach { a =>
      combinations = combinations :+ (a,b);
    }
  }

  var results = combinations.map { combination => BigInt(combination._1).pow(combination._2) };
  return results.distinct.length;
}

println(distinctTermsOfProblem29CombinationResultsInRange((2 to 100)));
