
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
    var count = 0
    var h = head
    def rec(head: ListNode): Unit ={

    }
    while (head.next != null) {
      count += 1
      h = h.next
    }
  }

  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    var result = Array(0, 1, 2)
    result
  }

  def repeatedNTimes(A: Array[Int]): Int = {
    var a = 0
    a
  }

  var candies =  Array[Int](2,3,5,1,3)
  kidsWithCandies(candies, extraCandies = 3)

  var h1 = new ListNode(1)
  var h2 = new ListNode(0, h1)
  var h3 = new ListNode(0, h2)
  var h4 = new ListNode(1, h3)
  var h5 = new ListNode(0, h4)
  var h6 = new ListNode(0, h5)
  var h7 = new ListNode(1, h6)
  var h8 = new ListNode(1, h7)
  var h9 = new ListNode(1, h8)
  var h10 = new ListNode(0, h9)
  var h11 = new ListNode(0, h10)
  var h12 = new ListNode(0, h11)
  var h13 = new ListNode(0, h12)
  var h14 = new ListNode(0, h13)
  var h15 = new ListNode(0, h14)

  //1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
  getDecimalValue(h15)
}
