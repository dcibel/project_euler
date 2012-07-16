


def isPalindrome(s:String):Boolean = {
  s.reverse == s
}

def findBiggestPalindromeInRange(min:Int, max:Int) {
  var maxPalindrome = 0;
  (max to min by -1).foreach { x =>
    (x to min by -1).foreach { y =>
      val product = x * y
      if (isPalindrome(product.toString)) {
        maxPalindrome = math.max(product, maxPalindrome)
      }
    }
  }
  println(maxPalindrome);
}

findBiggestPalindromeInRange(100, 999);
