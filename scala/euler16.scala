
println( BigInt(2).pow(1000).toString.foldLeft(0) { (acc,d) => acc + d.asDigit } )
