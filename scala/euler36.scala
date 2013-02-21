


def isPalindrome(string:String):Boolean = {
  val chars = string.map(_.asDigit);
  (0 to chars.length / 2).foreach { i =>
    val leftChar = chars(i);
    val rightChar = chars(chars.length - 1 - i);
    if (leftChar != rightChar) {
      return false;
    }
  }
  return true;
}

def isDoubleBasePalindrome(n:Int):Boolean = {
  return isPalindrome(n.toString) && isPalindrome(n.toBinaryString);
}

println((1 to 1000000).filter(isDoubleBasePalindrome(_)).reduceLeft(_+_));
