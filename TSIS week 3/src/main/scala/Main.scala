import java.util

object Solution extends App{
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    var result = Array.emptyBooleanArray
    for ( candy <- candies) {
      if ((candy + extraCandies) >= candies.max) result = result.:+(true)
      else result = result.:+(false)
    }
    result

//    val max = candies.max
//      candies.map { candy =>
//        candy + extraCandies >= max
//    }
  }
  //Definition for singly-linked list.
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  def getDecimalValue(head: ListNode): Int = {
    while (head.next != null) {
  }
  var candies =  Array[Int](2,3,5,1,3)
  kidsWithCandies(candies, extraCandies = 3)

//  getDecimalValue(1)
}
