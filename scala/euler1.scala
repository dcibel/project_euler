

val numbers = 0 until 1000;

val total = numbers.foldLeft(0) { (acc,x) => if (x % 3 == 0 || x % 5 == 0) acc + x else acc };
println(total);
