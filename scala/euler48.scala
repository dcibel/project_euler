

val result = (1 to 1000).foldLeft(BigInt(0)) { (acc,x) => acc + BigInt(x).pow(x) };
val resultString = result.toString;

println(resultString.slice(resultString.length - 10, resultString.length));
