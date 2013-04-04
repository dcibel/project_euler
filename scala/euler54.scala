import scala.io.Source;

def beats(hand:String, otherHand:String):Boolean = {
  val (score, referenceValue, remainingScore) = computeScore(hand);
  val (otherScore, otherReferenceValue, otherRemainingScore) = computeScore(otherHand);
  if (score > otherScore) {
    return true;
  } else if (score == otherScore) {
    if (referenceValue > otherReferenceValue) {
      return true;
    } else if (referenceValue == otherReferenceValue) {
      if (remainingScore > otherRemainingScore) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  } else {
    return false;
  }

  return false;
}


def computeScore(rawHand:String):(Int,Int, Int) = {
  val hand = parseHand(rawHand);
  val values = hand.map(_._1);
  var score = 0;
  var referenceValue = 0;
  var remainingScore = 0;
  if (values == (values(0) to (values(0) + 5))) {
    if (isFlush(hand)) {
      score = 9;
    } else {
      score = 8;
    }
    referenceValue = values.last;
    remainingScore = 0;
  } else {
    var occurrences = computeOccurrences(values);
    if (occurrences(0)._2 == 4) {
      score = 7;
      referenceValue = occurrences(0)._1;
      remainingScore = occurrences(1)._1;
    } else if ((occurrences(0)._2 == 3) &&
               (occurrences(1)._2 == 2)) {
      score = 6;
      referenceValue = 100 * occurrences(0)._1 + occurrences(1)._1;
      remainingScore = 0;
    } else if (isFlush(hand)) {
      score = 5;
      referenceValue = values.last;
      remainingScore = 0;
    } else if (areConsecutive(values)) {
      score = 4;
      referenceValue = values.last;
      remainingScore = 0;
    } else if (occurrences(0)._2 == 3) {
      score = 3;
      referenceValue = (occurrences(0)._1);
      remainingScore = 100 * occurrences(1)._1 + occurrences(2)._1;
    } else if ((occurrences(0)._2 == 2) &&
               (occurrences(1)._2 == 2)) {
      score = 2;
      referenceValue = 100 * occurrences(0)._1 + occurrences(1)._1;
      remainingScore = occurrences(2)._1;
    } else if (occurrences(0)._2 == 2) {
      score = 1;
      referenceValue = occurrences(0)._1;
      remainingScore = 10000 * occurrences(0)._1 + 100 * occurrences(1)._1 + occurrences(2)._1;
    } else {
      score = 0;
      referenceValue = values.last
      remainingScore = 1000000 * values(4) + 10000 * values(3) + 100 * values(2) + values(1);
    }
  }
    
  return (score, referenceValue, remainingScore);
}

def computeOccurrences(values:Seq[Int]):List[(Int,Int)] = {
  var occurrences = scala.collection.mutable.Map[Int,Int]();
  values.foreach { value =>
    if (!occurrences.contains(value)) {
      occurrences(value) = 0;
    }
    occurrences(value) = occurrences(value) + 1;
  }
  return occurrences.toList.sortWith((x, y) => 100 * x._2 + x._1 > 100 * y._2 + y._1);
}

def areConsecutive(values:Seq[Int]):Boolean = {
  var previousValue = values(0);
  values.slice(1,values.length).foreach { value =>
    if (value - previousValue != 1) {
      return false;
    }
    previousValue = value;
  }
  return true;
}

def isFlush(hand:Seq[(Int,Char)]):Boolean = {
  return hand.slice(1,hand.length).forall(_._2 == hand(0)._2);
}

def parseHand(rawHand:String):Seq[(Int,Char)] = {
  val hand = rawHand.replaceAll(" ", "");
  var parsedHand = List[(Int,Char)]();
  (0 until hand.length by 2).foreach { i =>
    parsedHand = parsedHand :+ (parseValue(hand(i)), hand(i + 1));
  }
  return parsedHand.sortWith((x, y) => x._1 < y._1);
}

def parseValue(char:Char):Int = {
  if (char.asDigit < 10) {
    return char.asDigit;
  }
  return char match {
    case 'T' => 10
    case 'J' => 11
    case 'Q' => 12
    case 'K' => 13
    case 'A' => 14
    case _ => -1
  }
}

def countHandsWonByPlayer1(fileName:String):Int = {
  var count = 0;
  Source.fromFile(fileName).getLines.foreach { turn =>
    var player1Hand = turn.slice(0, turn.length / 2);
    var player2Hand = turn.slice(player1Hand.length + 1, turn.length);
    if (beats(player1Hand, player2Hand)) {
      count = count + 1;
    }
  }
  return count;
}

println(countHandsWonByPlayer1("euler54_input"));
//println(countHandsWonByPlayer1("euler54_test_input"));
