
def isPrime(n:Long):Boolean = {
  if (n <= 1) return false;
  return (2L to math.sqrt(n).toLong).forall { x => n % x != 0L };
}

def digitsFromInt(n:Int):List[Int] = {
  var digits = n.toString.map(_.asDigit).toList;
  return digits;
}

def intFromDigits(digits:Seq[Int]):Int ={
  digits.reduceLeft { (acc,x) => acc * 10 + x };
}

def familyOfPrimes(prime:Int, count:Int):Seq[Int] = {
  val digits = digitsFromInt(prime);

  digits.foreach { replacedDigit =>
    var start = 0;
    if (digits.indexOf(replacedDigit) == 0) {
      start = 1;
    }
    val generatedNumbers = (start to 9).map { replacementDigit =>
      var generatedNumberDigits = digits.map { digit =>
        if (digit == replacedDigit) {
          replacementDigit
        } else {
          digit;
        }
      }
      intFromDigits(generatedNumberDigits);
    }
    val generatedPrimes = generatedNumbers.filter(isPrime(_));
    if (generatedPrimes.length == count) {
      return generatedPrimes;
    }
  }
  return Nil;
}


def smallestPrimeThatIsPartOfPrimeFamilyOf(count:Int):Int = {
  var prime = 1;
  var family:Seq[Int] = Nil;
  while (family == Nil) {
    do {
      prime = prime + 1;
    } while (!isPrime(prime))

    family = familyOfPrimes(prime, count);
  }
  println(family);
  return prime;
}

println(smallestPrimeThatIsPartOfPrimeFamilyOf(8));
