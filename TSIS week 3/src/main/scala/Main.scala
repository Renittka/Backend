object Solution extends App{
  def kidsWithCandies(candies: Array[Int], extraCandies: Int) = {
    var result = new Array[Boolean](candies.length)
    for ( candy <- candies) {
      if (candy + extraCandies >= candies.max) {
        result = result :+ true
      }
      else
        result = result :+ false
//      println(extraCandies + candies.max)
//      println(candy)
//      println(candies.max)
    }

   for (res <- result) println(res)
  }
  var candies =  Array[Int](2,3,5,1,3)
//  println(kidsWithCandies(candies, extraCandies = 3))
  kidsWithCandies(candies, extraCandies = 3)
}
// : Array[Boolean]