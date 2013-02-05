

import scala.io.Source;

def scoreForChar(char:Char):Long = {
  char.toInt - 'A'.toInt + 1L;
}

def scoreForName(name:String):Long = {
  name.foldLeft(0L) { (acc,char) => acc + scoreForChar(char) }
}

def scoreForFile(fileName:String):Long = {
  val fileContent:String = Source.fromFile(fileName).getLines.reduceLeft(_+_);
  val names = fileContent.split(",").sorted.map { s => s.substring(1, s.length - 1) }

  val nameScores = names.map { name => scoreForName(name) };
  val indices = (1 to nameScores.length).toArray;

  (indices zip nameScores).foldLeft(0L) { (acc,values) => acc + values._1 * values._2 };
}

println(scoreForFile("euler22_input"));
