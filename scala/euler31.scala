

def findCombinationsOfCoinsToReachAmount(coins:List[Int], amount:Int):List[List[Int]] = {
  if (coins.length == 0) {
    return List[List[Int]]();
  }


  val coin = coins(0);
  if (coins.length == 1) {
    return List(List(amount / coin));
  }

  val remainingCoins = coins.slice(1, coins.length);
  var combinations = List[List[Int]]();

  (0 to amount / coin).foreach { i =>
    findCombinationsOfCoinsToReachAmount(remainingCoins, amount - i * coin).foreach { subcombination =>
      val combination = (i :: subcombination);
      combinations = combinations :+ combination;
    }
  }
  return combinations;
}



val coins = List(200, 100, 50, 20, 10, 5, 2, 1);
println(findCombinationsOfCoinsToReachAmount(coins, 200).length);
