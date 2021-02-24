object Solution extends App {
  // Task 1
  def maxProduct(nums: Array[Int]): Int = {
    val sorted = nums.sorted
    val max = sorted(nums.length-1)
    val secondMax = sorted(nums.length-2)

    (max-1) * (secondMax-1)
  }

  // Task 2
  def average(salary: Array[Int]): Double = {
    (salary.sum - salary.min - salary.max) / (salary.length - 2d)
  }

  // Task 3
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    val result: String = " "

    result
  }

  // Task 4
  def findPairs(nums: Array[Int], k: Int): Int = {
    val result: Int = 0
    result
  }

//  println(maxProduct(Array(3,4,5,2)))
//  println(average(Array(4000,3000,1000,2000)))
  println(dayOfTheWeek(day = 31, month = 8, year = 2019))
//  println(findPairs(Array(3,1,4,1,5), k = 2))
}