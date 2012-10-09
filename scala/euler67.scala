import scala.io.Source;


def findBiggestPathScore(fileName:String):Long = {
  val lines = Source.fromFile(fileName).getLines.foldLeft(Array[Array[Long]]()) {  (valueLines, line) =>
    valueLines :+ line.split(" ").map { s => s.toLong };
  }
  var currentScores:IndexedSeq[Long] = lines(lines.length - 1);
  for(i <- lines.length - 2 to 0 by -1) {
    val line = lines(i);
    currentScores = (0 until line.length).map { (j) =>
      line(j) + scala.math.max(currentScores(j), currentScores(j + 1));
    }
  }
  return currentScores(0);
}

println(findBiggestPathScore("euler67_input"));
