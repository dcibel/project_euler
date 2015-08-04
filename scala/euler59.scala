
import scala.io.Source;



def getEncryptedMessageChars(fileName:String):Seq[Int] = {

  val fileContent:String = Source.fromFile(fileName).getLines.reduceLeft(_+_);
  val charValues = fileContent.split(",").map { s => s.toInt };

  return charValues;
}

def stringFromCharValues(charValues:Seq[Int]):String = {

    val chars = charValues.map { value => value.toChar };
    return chars.mkString("");
}

def generatedKeyFromPassword(password:String, length:Int):Seq[Int] = {

    return (0 until length).map { value => password(value % password.length).toInt }
}

def decodeCharValues(charValues:Seq[Int], key:Seq[Int]) = {
    (charValues zip key).map(elements => (elements._1 ^ elements._2))
}

def printDecodedMessage(charValues:Seq[Int]) {
    val chars = charValues.map { value => value.toChar }
    println(stringFromCharValues(charValues));
}


val encryptedChars = getEncryptedMessageChars("euler59_test_input.txt");

('a' to 'z').foreach { p1 =>
  ('a' to 'z').foreach { p2 =>
    ('a' to 'z').foreach { p3 =>
        
      val password = p1 + "" + p2 + "" + p3

      val key = generatedKeyFromPassword(password, encryptedChars.length)

      val decodedCharValues = decodeCharValues(encryptedChars, key)

      val decodedMessage = stringFromCharValues(decodedCharValues)


      if (decodedMessage.contains(" the ")) {
        println(decodedMessage);
        println("Sum of ASCII char values: " + decodedCharValues.reduceLeft(_+_));
        sys.exit();
      }
      
    }
  }
}

