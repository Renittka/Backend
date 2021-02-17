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
    def rec(next: ListNode, current: Int): Int ={
      val result = (current << 1) + next.x
      if (next.next == null) result
      else rec(next.next, result)
    }

    rec(head, 0)

    }

  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    nums.map(n => sorted.count(_ < n))
  }

  def repeatedNTimes(A: Array[Int]): Int = {
    val sort = A.sorted
    var c = 0
    for (s <- sort){

    }
    c
  }

  // Task 1
  var candies =  Array[Int](2,3,5,1,3)
//  kidsWithCandies(candies, extraCandies = 3)

  // Task 2
  var h1 = new ListNode(1)
  var h2 = new ListNode(0, h1)
  var h3 = new ListNode(1, h2)
//  println(getDecimalValue(h3))

  // Task 3
  var input = Array(8,1,2,2,3)
  for ( i <- smallerNumbersThanCurrent(input)){
    println(i)
  }

  // Task 4
  var a = Array(1,2,3,3)
  println(repeatedNTimes(a))
}
