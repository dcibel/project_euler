
scala.collection.mutable.Map


def computeNextValue(value:Long):Long = {
  if (value % 2 == 0) {
    return value / 2;
  } else {
    return 3 * value + 1;
  }
}

def computeSequenceLengthFrom(startValue:Long, cache:scala.collection.mutable.Map[Long,Int]):Int = {
  var value:Long = startValue;
  var length:Int = 1;
  while(value > 1) {
    value = computeNextValue(value);

    if (cache.contains(value)) {
      length = length + cache(value);
      cache(startValue) = length;
      return length;
    }

    length = length + 1;
  }
  cache(startValue) = length;
  return length;
}

println("Starting number with longest sequence under 1000000");
var cache:scala.collection.mutable.Map[Long,Int] =  scala.collection.mutable.Map[Long,Int]();
var max:Int = 0;
var startingValueForMax:Long = -1;
(1 to 1000000).foreach { value =>
  val length = computeSequenceLengthFrom(value, cache);
  if (length > max) {
    startingValueForMax = value;
    max = length;
  }
}
println(startingValueForMax.toString + " (length: " + max.toString + ")");
