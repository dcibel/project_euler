


def computeNumberOfPaths(wayToGo:(Int,Int)):Long = {
  if (wayToGo._1 == 0 || wayToGo._2 == 0) {
    return 1;
  }

  return computeNumberOfPaths((wayToGo._1 - 1, wayToGo._2)) + computeNumberOfPaths((wayToGo._1, wayToGo._2 - 1));
}

println(computeNumberOfPaths((20,20)));
