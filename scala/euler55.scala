


def isPalindrome(s:String):Boolean = {
  s.reverse == s;
}

def reverseAndAddCanBringPalindrome(number:BigInt, maxAttempts:Int):Boolean = {
  var candidate:BigInt = number;
  (1 to maxAttempts).foreach { i =>
    candidate = candidate + BigInt(candidate.toString.reverse);
    if (isPalindrome(candidate.toString)) {
      return true;
    }
  }
  return false;
}

def isLychrelNumber(number:Int):Boolean = {
  return !reverseAndAddCanBringPalindrome(number,50);
}

def countLychrelNumbersUnder(limit:Int):Int = {
  val lychrelNumbers = (1 until limit).toArray.filter(isLychrelNumber(_));
  return lychrelNumbers.length;
}


println(countLychrelNumbersUnder(10000));
