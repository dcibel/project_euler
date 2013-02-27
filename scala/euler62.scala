
def digitsFromLong(n:Long):Seq[Int] = {
  return n.toString.map(_.asDigit);
}

def findSmallestCubeWithNCubicPermutations(n:Int):Long = {
  var cubes = scala.collection.mutable.Map[Seq[Int],Seq[Long]]();

  var i = 0L;
  while (i < Int.MaxValue) {
    val cube:Long = i * i * i;
    val digits = digitsFromLong(cube).sortWith(_<_);
    if (!cubes.contains(digits)) {
      cubes(digits) = List[Long]();
    }
    cubes(digits) = cubes(digits) :+ cube;
    if (cubes(digits).length == n) {
      return cubes(digits).min;
    }

    i = i + 1;
  }

  return 0;
}


println(findSmallestCubeWithNCubicPermutations(5));
