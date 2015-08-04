
/*
On notera que, à chaque étape :

- le numérateur est : 2 * le numérateur n-1  +  1 * le numérateur n-2
- le dénomiateur est : numérateur n-1  +  dénominateur n-1
*/


def countFractionsWithMoreDigitsInNumerator(expansionCount:Int):Int = {
    if (expansionCount < 3) {
        return 0;
    }
    var previousPreviousNumerator:BigInt = 3;
    var previousPreviousDenominator:BigInt = 2;
    var previousNumerator:BigInt = 7;
    var previousDenominator:BigInt = 5;
    var count = 0;
    (3 to expansionCount).foreach { i =>
        val numerator:BigInt = 2 * previousNumerator + previousPreviousNumerator;
        val denominator:BigInt = previousNumerator + previousDenominator;

        previousPreviousNumerator = previousNumerator;
        previousPreviousDenominator = previousDenominator;
        previousNumerator = numerator;
        previousDenominator = denominator;

        if (numerator.toString.length > denominator.toString.length) {
            count = count + 1;
        }
    }
    return count;
}


println(countFractionsWithMoreDigitsInNumerator(1000));
