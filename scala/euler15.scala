


def computeNumberOfPaths(wayToGo:(Int,Int)):Int = {
  println(wayToGo);
  if (wayToGo._1 == 0 || wayToGo._2 == 0) {
    return 1;
  }
  var count = 0;
  if (wayToGo._1 >= 1) {
    count = computeNumberOfPaths((wayToGo._1 - 1, wayToGo._2));
  }
  if (wayToGo._2 >= 1) {
    count = computeNumberOfPaths((wayToGo._1, wayToGo._2 - 1));
  }
  return count;
}

println(computeNumberOfPaths((2,2)));
