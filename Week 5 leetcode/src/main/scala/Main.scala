import scala.collection.immutable.HashSet

object Solution extends App {

  // Task 1
  def maxProduct(nums: Array[Int]): Int = {

    def sort(nums: Array[Int]): Array[Int] ={
      var sorted = false
      var temp = 0

      while (!sorted) {
        sorted = true
        var i = 0

        while ( i < nums.length - 1) {
          if (nums(i) > nums(i + 1)) {
            temp = nums(i)
            nums(i) = nums(i + 1)
            nums(i + 1) = temp
            sorted = false
          }

          i += 1
        }
      }
      nums
    }

    def resMax(max: Int, secondMax: Int): Int ={
      (max-1) * (secondMax-1)
    }

    val sortedNums = sort(nums)
    resMax(sortedNums(nums.length-1), sortedNums(nums.length-2))
  }

  // Task 2
  def average(salary: Array[Int]): Double = {
    var sum = 0
    for (s <- salary) sum += s
    (sum - salary.min - salary.max) / (salary.length - 2d)
  }

  // Task 3
  def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
    val week = List[String]("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
    var days: Int = 4

    def isLeapYear(year: Int): Boolean ={
      if ((year%400 == 0) | (year%4 == 0 && year%100 != 0)) true
      else false
    }

    def daysOfYear(year: Int): Int = {
      var countDays: Int = 0
      if (isLeapYear(year)) countDays = 366
      else countDays = 365
      countDays
    }

    def daysOfMonth(year: Int, month: Int): Int = {
      var daysMonth = 30
      if (month == 1 | month == 3 | month == 5 | month == 7 | month == 8 | month == 10 | month == 12)  daysMonth = 31
      else if (month == 2) {
        if (isLeapYear(year)) daysMonth = 29
        else daysMonth = 28
      }
      daysMonth
    }

    for (i <- 1971 until year) {
      days += daysOfYear(i);
    }

    for (i <- 1 until month) {
      days += daysOfMonth(year, i);
    }

    days += day

    week(days % 7)
  }

  // Task 4
  def findPairs(nums: Array[Int], k: Int): Int = {
    var seenSet = new HashSet[Int]()
    var pairsSet = new HashSet[(Int,Int)]()
    for(num <- nums){
      if(seenSet.contains(num + k)){
        if(!pairsSet.contains(num, num + k))
          pairsSet += ((num + k, num))
      }
      if(seenSet.contains(num-k)){
        if(!pairsSet.contains(num, num - k))
          pairsSet += ((num - k,num))
      }
      seenSet += num
    }
    pairsSet.size
  }

//  println(maxProduct(Array(3,4,5,2)))
  println(average(Array(4000,3000,1000,2000)))
//  println(dayOfTheWeek(day = 31, month = 8, year = 2019))
//  println(findPairs(Array(3,1,4,1,5), k = 2))
}