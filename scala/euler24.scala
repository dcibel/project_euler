
def factorial(n:Int):Int = if(n==0L) 1 else n * factorial(n-1);

def getNthDigitsLexicographicPermutation(n:Int, sequence:List[Int]):List[Int] = {

  if (sequence.length == 1) {
    return sequence;
  }
  
  val unit:Int = factorial(sequence.length - 1);

  (sequence.length - 1 to 0 by -1).foreach { k =>
    if (k * unit <= n-1 ) {
      val head = sequence(k);
      val tailSequence = sequence.filterNot(_ == head);
      val tailN = n - k * unit;
      return List(head) ::: getNthDigitsLexicographicPermutation(tailN, tailSequence);
    }
  }

  return Nil;
}

println(getNthDigitsLexicographicPermutation(1000000, List(0,1,2,3,4,5,6,7,8,9)).mkString(""));
