object Solution extends App{
  // 1
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

  // 2
  def getDecimalValue(head: ListNode): Int = {
    def rec(next: ListNode, current: Int): Int ={
      val result = (current << 1) + next.x
//      println("current " + current)
//      println("next " + next.x)
//      println("result " + result)
      if (next.next == null) result
      else rec(next.next, result)
    }

    rec(head, 0)
    }
  //Definition for singly-linked list.
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  // 3
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    val sorted = nums.sorted
    nums.map(n => sorted.count(_ < n))
  }

  // 4
  def repeatedNTimes(A: Array[Int]): Int = {
    def find(unique: Set[Int], remain: Array[Int]): Int =
      if (unique.contains(remain.head)) remain.head
      else find(unique + remain.head, remain.tail)

    find(Set.empty, A)
  }

  // 5
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    var result = Array.emptyIntArray
    var i = 0
    while (i != nums.length) {
      var times = nums(i)
      val value = nums(i+1)

      while (times != 0){
        times -= 1
        result = result.:+(value)
      }

      i += 2
    }

    result
  }

  // 6
  def sumZero(n: Int): Array[Int] = {
    if (n == 1) return Array(0)
    val res = Array.ofDim[Int](n)

    for (i <- 0 until n) {
      res(i) =
        if (i % 2 == 0)
          (i / 2) + 1
        else
          -((i / 2) + 1)
    }
    if (n % 2 == 1)
      res(n - 1) = 0
    res
  }

  // 7
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val weak = Array.ofDim[Int](mat.size)

    for (column <- 0 until mat(0).size; row <- 0 until mat.size) {
      weak(row) += mat(row)(column)
    }

    weak.zipWithIndex.sortBy(c => c._1).take(k).unzip._2
  }

  // 9
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val s3 = nums1.intersect(nums2)
    s3.distinct
  }

  // 10
  def buildArray(target: Array[Int], n: Int): List[String] = {
    val numbers = List.range(1,n+1);
    var result = List[String]()
    var i = 0;
    var j = 0;
    while (i < target.length) {
      if (target(i) == numbers(j)) {
        result :+= "Push"
        i += 1
        j += 1
      } else {
        result :+= "Push"
        result :+= "Pop"
        j+=1
      }
    }
    result
  }

  // Task 1
  //for ( i <-  kidsWithCandies(Array[Int](2,3,5,1,3), extraCandies = 3)) println(i)

  // Task 2
  //  var h1 = new ListNode(1)
  //  var h2 = new ListNode(0, h1)
  //  var h3 = new ListNode(1, h2)
  //  println(getDecimalValue(h3))

  // Task 3
  //  for ( i <- smallerNumbersThanCurrent(Array(8,1,2,2,3))) println(i)

  // Task 4
  //  println(repeatedNTimes(Array(1,2,3,3)))

  // Task 5
  //  for ( i <- decompressRLElist(Array(1,2,3,4))) println(i)

  // Task 6
  //  for ( i <-  sumZero(3)) println(i)

  // Task 7
  val matrix = Array[Array[Int]]( Array(1,1,0,0,0), Array(1,1,1,1,0), Array(1,0,0,0,0), Array(1,1,0,0,0), Array(1,1,1,1,1))
  //  for ( i <- kWeakestRows( matrix, 3)) println(i)

  // Task 8

  // Task 9
  //  for ( i <- intersection(Array(1,2,2,1), Array(2,2))) println(i)

  // Task 10
  //  for ( i <- buildArray(Array(1,3), 3)) println(i)
}
