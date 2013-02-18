

def countCombinationsOfCoinsToReachAmount(coins:List[Int], amount:Int):Int = {
  if (coins.length == 0) {
    return 0;
  }


  val coin = coins(0);
  if (coins.length == 1) {
    return 1;
  }

  val remainingCoins = coins.slice(1, coins.length);
  var count = 0;

  (0 to amount / coin).foreach { i =>
    count = count + countCombinationsOfCoinsToReachAmount(remainingCoins, amount - i * coin);
  }
  return count;
}



val coins = List(200, 100, 50, 20, 10, 5, 2, 1);
println(countCombinationsOfCoinsToReachAmount(coins, 200));
