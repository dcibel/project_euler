
import scala.io.Source;


def forEachNConsecutiveItemsInDirection(array:Array[Array[Int]], length:Int, direction:(Int,Int))(callback : (Seq[Int] => Unit)) {
  val dimensions = (array.length, array(0).length);
  
  val minX = if (direction._2 >= 0) 0 else (math.abs(direction._2 * length) - 1);
  val minY = if (direction._1 >= 0) 0 else (math.abs(direction._1 * length) - 1);
  val maxX = if (direction._2 > 0) dimensions._2 - direction._2 * length else dimensions._2 - 1;
  val maxY = if (direction._1 > 0) dimensions._1 - direction._1 * length else dimensions._1 - 1;
  
  (minX to maxX).foreach { startX =>
    (minY to maxY).foreach { startY =>
      val stepX:Int = (length * direction._2) / length
      val stepY:Int = (length * direction._1) / length

      val items = (0 until length).map { i =>
        array(startY + i * stepY)(startX + i * stepX)
      }
        
      callback(items);
    }
  }

}

def findBiggestProductOfNItemsInFile(fileName:String, length:Int):Long = {

  val array = Source.fromFile(fileName).getLines.foldLeft(Array[Array[Int]]()) {  (valueLines, line) =>
    valueLines :+ line.split(" ").map { s => s.toInt };
  }

  var max:Long = 0L;

  forEachNConsecutiveItemsInDirection(array, length, (1,0)) { items =>
    max = math.max(max, items.reduceLeft(_*_));
  };

  forEachNConsecutiveItemsInDirection(array, length, (0,1)) { items =>
    max = math.max(max, items.reduceLeft(_*_));
  };

  forEachNConsecutiveItemsInDirection(array, length, (1,1)) { items =>
    max = math.max(max, items.reduceLeft(_*_));
  };

  forEachNConsecutiveItemsInDirection(array, length, (1,-1)) { items =>
    max = math.max(max, items.reduceLeft(_*_));
  };

  return max;
}

println(findBiggestProductOfNItemsInFile("euler11_input", 4));
