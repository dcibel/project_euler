


def computePolygonalNumber(n:Int, k:Int):Int = {

    if ((k % 2) == 0) {
        return n * ((k / 2 - 1) * n + 2 - k / 2);

    } else {
        return n * ((k - 2) * n + (4 -k)) / 2;
    }

    return 0;

}

def generate4DigitsPolygonalNumbers(k:Int):Seq[Int] = {

    var numbers:Seq[Int] = List();

    (0 to 1000).foreach { i =>

        val n1 = computePolygonalNumber(i, k);

        if (n1 > 1000 && n1 < 9999) {
            numbers = numbers :+ n1;
        }
    }

    return numbers;
}

def isCyclicNumberList(numbers:Seq[Int]):Boolean = {

    var previousNumber = numbers(numbers.length - 1);

    numbers.foreach { number =>
        if (number / 100 != (previousNumber % 100)) {
            return false;
        }

        previousNumber = number;

    }

    return true;
}

def isChainNumberList(numbers:Seq[Int]):Boolean = {

    var previousNumber = numbers(0)

    (1 to (numbers.length - 1)).foreach { i =>

        val number = numbers(i);

        if (number / 100 != (previousNumber % 100)) {
            return false;
        }
        previousNumber = number;
    }

    return true;

}

def isChainableNumberSet(numbers:Seq[Int]):Boolean = {

    numbers.permutations.foreach { permutation =>
        if (isChainNumberList(permutation)) {
            return true;
        }
    }
    return false;
}


(3 to 8).foreach { k =>

    println((1 to 5).map(i => computePolygonalNumber(i, k)).mkString(","))

}

/*(0 to 99).foreach { a =>

    var set:Seq[Int] = List[Int]();

    (0 to 99).foreach { b =>
        val n1 = a * 100 + b;

        set = set :+ n1;
*/

var triangles = generate4DigitsPolygonalNumbers(3);
var squares = generate4DigitsPolygonalNumbers(4);
var pentagones = generate4DigitsPolygonalNumbers(5);
var hexagones = generate4DigitsPolygonalNumbers(6);
var heptagones = generate4DigitsPolygonalNumbers(7);
var octogones = generate4DigitsPolygonalNumbers(8);

println(triangles.mkString(","));
println(squares.mkString(","));
println(pentagones.mkString(","));
println(hexagones.mkString(","));
println(heptagones.mkString(","));
println(octogones.mkString(","));


val sequencePermutations = List(triangles, squares, pentagones, hexagones, heptagones, octogones).permutations

sequencePermutations.foreach { permutation =>

    permutation(0).foreach { a =>
        permutation(1).foreach { b =>

            if (b / 100 == (a % 100)) {
            permutation(2).foreach { c =>

                if (c / 100 == (b % 100)) {
                permutation(3).foreach { d =>

                    if (d / 100 == (c % 100)) {
                    permutation(4).foreach { e =>

                        if (e / 100 == (d % 100)) {
                        permutation(5).foreach { f =>

                            if (f / 100 == (e % 100)) {
                                val set = List(a,b,c,d,e,f);

                                if (set.distinct.length == set.length) {
                                    println(set.mkString(","));
                                    println(set.reduceLeft(_+_));
                                    sys.exit()
                                }
                            }
                        }
                        }
                    }
                    }
                }
                }
            }
            }
        }
    }
}

/*
triangles.foreach { triangle =>

    squares.foreach { square =>

        if ( square / 100 == (triangle % 100)) {

        pentagones.foreach { pentagon =>

            if ( pentagon / 100 == (square % 100)) {

            hexagones.foreach { hexagon =>

                if ( hexagon / 100 == (pentagon % 100)) {

                heptagones.foreach { heptagon =>

                    val partialSet = List(triangle, square, pentagon, hexagon, heptagon)

                    if (isChainableNumberSet(partialSet)) {

                        println("c");

                        octogones.foreach { octogon => 

                            val set = partialSet :+ octogon;


                            if (set.distinct.length == set.length) {
                                //set.permutations.foreach { permutedSet =>
                                println(set.mkString(","));

                                    //if (isCyclicNumberList(permutedSet)) {
                                    if (isCyclicNumberList(set)) {
                                        println(set.mkString(","));
                                        //println(permutedSet.mkString(","));
                                    }
                                //}
                            }
                        }
                    }
                }
                }
            }
            }
        }
        }
    }
}
*/
