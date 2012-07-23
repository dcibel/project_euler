
import scala.collection.mutable.Map;

def computeNumberOfPaths(wayToGo:(Int,Int), cache:scala.collection.mutable.Map[(Int,Int),Long]):Long = {
  if (wayToGo._1 == 0 || wayToGo._2 == 0) {
    return 1;
  }

  if (cache.contains(wayToGo)) {
    return cache(wayToGo);
  }

  val count = computeNumberOfPaths((wayToGo._1 - 1, wayToGo._2),cache) + computeNumberOfPaths((wayToGo._1, wayToGo._2 - 1),cache);

  cache(wayToGo) = count;

  return count;
}


var cache = scala.collection.mutable.Map[(Int,Int),Long]()
println(computeNumberOfPaths((20,20), cache));
