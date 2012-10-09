


def wordFromDigit(digit:Int):String = {
  val words = Array("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
  return words(digit - 1);
}

def wordFromNumberForTenToTwenty(number:Int):String = {
  val words = Array("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty");
  return words(number - 10);
}

def wordFromNumberForLowerThanHundred(number:Int):String = {
  val tensWords = Array("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");
  val tensDigit = number / 10;
  val digit = number % 10;
  if (digit % 10 == 0) {
    return tensWords(tensDigit - 2);
  } else {
    return tensWords(tensDigit - 2) + "-" + wordFromDigit(digit);
  }
}

def wordsFromNumberForLowerThanThousand(number:Int):String = {
  val hundredsWord = wordFromDigit(number / 100);
  if ((number % 100) == 0) {
    return hundredsWord + " hundred";
  } else {
    return hundredsWord + " hundred and " + wordsFromNumber(number % 100);
  }
}

def wordsFromNumber(number:Int):String = {
  if (number < 10) {
    return wordFromDigit(number:Int);
  } else if (number <= 20) {
    return wordFromNumberForTenToTwenty(number);
  } else if (number < 100) {
    return wordFromNumberForLowerThanHundred(number);
  } else if (number < 1000) {
      return wordsFromNumberForLowerThanThousand(number);
  } else {
    return "one thousand";
  }
}

def charactersCountFromNumber(number:Int):Int = {
  return wordsFromNumber(number).replaceAll("""\W""", "").length;
}

def printResultForNumber(number:Int) {
  println(wordsFromNumber(number) + " (" + charactersCountFromNumber(number) + ")");
}

val numbers = 1 to 1000;

val total = numbers.foldLeft(0) { (acc,x) => acc + charactersCountFromNumber(x)};
println(total)
