


var products = Set[Int]()

List(1,2,3,4,5,6,7,8,9).permutations.foreach { digits =>
  (1 until digits.length - 1).foreach { firstFactorLimit =>
    val firstFactor = digits.slice(0, firstFactorLimit).foldLeft(0) { (acc,x) => 10 * acc + x };

    (firstFactorLimit + 1 until digits.length).foreach { secondFactorLimit =>

      val secondFactor = digits.slice(firstFactorLimit, secondFactorLimit).foldLeft(0) { (acc,x) => 10 * acc + x };
      val expectedProduct = digits.slice(secondFactorLimit, digits.length).foldLeft(0) { (acc,x) => 10 * acc + x };
      
      val product = firstFactor * secondFactor 
      if (product == expectedProduct) {
        products = products + product;
      }
    }
  }
}


println(products.reduceLeft(_+_) );
