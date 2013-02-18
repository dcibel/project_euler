


def sumOfDigitsWithPower(number:Int, power:Int):Int = {
  return number.toString.map{ _.asDigit }.foldLeft(0) { (acc,x) => acc + math.pow(x, power).toInt }
}

def sumOfValidNumbersInRangeWithPower(range:Range, power:Int):Int = {
  range.filter { (x) => x == sumOfDigitsWithPower(x, power) }.reduceLeft(_+_);
}

def findRelevantLimitForSumOfDigitPowersOf(power:Int):Int = {
  var limit:Int = 9;
  (1 until power).foreach { x =>
    limit = 10 * limit + 9;
  }
  while(sumOfDigitsWithPower(limit, power).toString().length == limit.toString.length) {
    limit = 10 * limit + 9;
  }
  return 10 * limit + 9;
}

println(sumOfValidNumbersInRangeWithPower((10 to findRelevantLimitForSumOfDigitPowersOf(5)), 5));
