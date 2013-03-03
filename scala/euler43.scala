

def digitsFromInt(n:Int, length:Int):List[Int] = {
  var digits = n.toString.map(_.asDigit).toList;
  while(digits.length < length) {
    digits = 0 :: digits;
  }
  return digits;
}

def intFromDigits(digits:Seq[Int]):Int ={
  digits.reduceLeft { (acc,x) => acc * 10 + x };
}

def longFromDigits(digits:Seq[Int]):Long ={
  digits.foldLeft(0L) { (acc,x) => acc * 10 + x.toLong };
}

def addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits:List[List[Int]], dividor:Int):List[List[Int]] = {
  var newNumbers = List[List[Int]]();
  numbersAsDigits.foreach { digits =>
    val availableDigits = (0 to 9).toSet -- digits;
    availableDigits.foreach { n =>
      val number = intFromDigits(n :: digits.slice(0,2));
      if (number % dividor == 0) {
        newNumbers = newNumbers :+ (n :: digits);
      }
    }
  }

  return newNumbers;
}

var numbersAsDigits = (17 until 1000 by 17).toList.map(digitsFromInt(_,3).toList).filter { digits =>
  digits.toSet.size == 3;
}

numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 13);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 11);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 7);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 5);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 3);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 2);
numbersAsDigits = addDigitSoThatNumbersCanBe0to9PandigitalAndIsDividableBy(numbersAsDigits, 1);

println(numbersAsDigits.map(longFromDigits(_)).reduceLeft(_+_));
