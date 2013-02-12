

def findRecurringPattern(sequence:Seq[Int]):Seq[Int] = {
  if (sequence.length < 3) {
    return List();
  }

  (0 until sequence.length - 2).foreach { recurringPartStartIndex => 
    val (fixedPart, recurredPart) = sequence.splitAt(recurringPartStartIndex);
    if (recurredPart.length % 2 == 0) {
      val (recurredPart1, recurredPart2) = recurredPart.splitAt(recurredPart.length / 2);
      if (recurredPart1 == recurredPart2) {
        return recurredPart1;
      }
    }
  }
  return List(-1);
}


println(findRecurringPattern(List(1,2,3,2,3)));
