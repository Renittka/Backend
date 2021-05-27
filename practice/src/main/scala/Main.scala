import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Main extends App{
  var sum: Int = 0

  // 1863 Sum of All Subset XOR Totals
  def subsetXORSum(nums: Array[Int]): Int = {
    recurse(nums, 0, 0)
    sum
  }

  def recurse(nums: Array[Int], idx: Int, xorSum: Int): Unit ={
    sum += xorSum
    var i: Int = 0
    i = idx
    while (i < nums.length) {
      recurse(nums, i + 1, xorSum ^ nums(i))
      i += 1
    }
  }

  // 1480. Running Sum of 1d Array
  def runningSum(nums: Array[Int]): Array[Int] = {
    var sum: Int = 0
    var result: Array[Int] = Array.emptyIntArray
    for (i <- nums){
      sum += i
      result = result.:+(sum)
    }
    result
  }

  // 1108. Defanging an IP Address
  def defangIPaddr(address: String): String = {
    var i: Int = 0
    var result: String = ""
    while (i < address.length){
      if (address(i) == '.'){
        result = result.:+('[')
        result = result.:+('.')
        result = result.:+(']')
      }
      else result = result.:+(address(i))
      i +=1
    }
    result
//    address.replace(".", "[.]")
  }

  //  1672. Richest Customer Wealth
  def maximumWealth(accounts: Array[Array[Int]]): Int = {
    var sum = 0
    var result: Array[Int] = Array.emptyIntArray
    for (i <- accounts) {
      for (j <- i) {
        sum +=j
      }
      result = result.:+(sum)
      sum = 0
    }
    result.max
  // accounts.map(account => account.reduce((a,b) => a + b)).max
  }

  // 1470. Shuffle the Array
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    var arr: Array[Int] = Array.emptyIntArray
    var a: Int = 0
    while (a < n){
      arr = arr.:+(nums(a))
      arr = arr.:+(nums(n+a))
      a += 1
    }
    arr
    // (for (i <- Range(0, 2*n)) yield nums(i / 2 + n * (i % 2))).toArray
  }

  // 1512. Number of Good Pairs
  def numIdenticalPairs(nums: Array[Int]): Int = {
    var count: Int = 0
    for (i <- 1 until nums.length; j <- 0 until i)
      if (nums(i) == nums(j))
        count = count + 1
    count
  }

  // 771. Jewels and Stones
  def numJewelsInStones(jewels: String, stones: String): Int = {
    var count: Int = 0
    for (i <- 0 until stones.length){
      for (j <- jewels.toArray){
        if(j == stones(i)) {
          count += 1
        }
      }
    }
    count
//    stones.count(c => jewels.contains(c))
  }

  // 1603. Design Parking System
  class ParkingSystem(_big: Int, _medium: Int, _small: Int) {
    var count: mutable.Map[Int, Int] = scala.collection.mutable.Map(1 -> _big, 2 -> _medium, 3 -> _small)

    def addCar(carType: Int): Boolean = count(carType) match {
      case 0 => false
      case _ =>
        count.put(carType, count(carType) - 1)
        true
    }
  }

  // 1281. Subtract the Product and Sum of Digits of an Integer
  def subtractProductAndSum(n: Int): Int = {
    var sum: Int = 0
    var product: Int = 1
    for (i <- n.toString){
      sum += i.asDigit
      product *= i.asDigit
    }
    product-sum

  // val list = n.toString.map(_.asDigit)
  // list.product - list.sum
  }

  // 1342. Number of Steps to Reduce a Number to Zero
  def numberOfSteps(num: Int): Int = {
    var count: Int = 0
    var number: Int = num
    while (number != 0 ) {
      if (number%2 == 1) {
        number = number - 1
        count += 1
      }
      else {
        number = number / 2
        count += 1
      }
    }
    count
//    def steps(num: Int, count: Int): Int = {
//      num match {
//        case 0 => count
//        case even if even % 2 == 0 => steps(even / 2, count+1)
//        case odd if odd % 2 == 1 => steps(odd - 1, count+1)
//      }
//    }
//    steps(num, 0)
  }

  // 1528. Shuffle String
  def restoreString(s: String, indices: Array[Int]): String = {
    val result = Array.ofDim[Char](indices.length)
    var count = 0
    for(i <- indices){
      result(i) = s(count)
      count = count + 1
    }
    result.mkString
  }

  // 1720. Decode XORed Array
  def decode(encoded: Array[Int], first: Int): Array[Int] = {
    val result = Array.ofDim[Int](encoded.length + 1)
    result(0) = first
    for (i <- 1 until result.length){
      result(i) = result(i-1) ^ encoded(i-1)
    }
    result
  }

  // 1678. Goal Parser Interpretation
  def interpret(command: String): String = {
//    var result: String = ""
//    for (i <- 0 until command.length) {
//      command(i) match {
//        case 'G' => result += "G"
//        case '(' => {
//          command(i+1) match {
//            case ')' => result += "o"
//            case 'a' => result += "al"
//          }
//        }
//      }
//    }
//    result
    command.replace("()","o").replace("(al)","al")
  }

  // 1389. Create Target Array in the Given Order
  def createTargetArray(nums: Array[Int], index: Array[Int]): Array[Int] = {
    var result: ArrayBuffer[Int] = collection.mutable.ArrayBuffer[Int]()
    for (i <- nums.indices){
      result.insert(index(i), nums(i))
    }
    result.toArray
  }

  // 1773. Count Items Matching a Rule
  def countMatches(items: List[List[String]], ruleKey: String, ruleValue: String): Int = {

//    def helper(items: List[List[String]]): Int = ruleKey match {
//      case "type" => items.map(item => if (item(0) == ruleValue) 1 else 0).sum
//      case "color" => items.map(item => if (item(1) == ruleValue) 1 else 0).sum
//      case "name" => items.map(item => if (item(2) == ruleValue) 1 else 0).sum
//    }
//    helper(items)

    val index = ruleKey match {
      case "type" => 0
      case "color" => 1
      case "name" =>2
    }

    items.count(singleList => singleList(index) == ruleValue)
  }

  // 1221. Split a String in Balanced Strings
  def balancedStringSplit(s: String): Int = {
    var count: Int = 0
    var result: Int = 0
    for (i <- s){
      if (i == 'R'){
        count += 1
      }
      else if (i == 'L') count -= 1
      if (count == 0)
        result += 1
    }
    result
  }

  // 1486. XOR Operation in an Array
  def xorOperation(n: Int, start: Int): Int = {
    var result: Int = 0
    val nums: Array[Int] = Array.ofDim[Int](n)
    for (i <- nums.indices){
      nums(i) = start + 2*i
    }
    for (item <- nums){
      result ^= item
    }
    result
  }

  // 1832. Check if the Sentence Is Pangram
  def checkIfPangram(sentence: String): Boolean = {
    var result: Boolean = false
    val set: mutable.Set[Char] = mutable.Set[Char]()
    for (item <- sentence){
      set.add(item)
    }
    if (set.size == 26)  result = true
    result

    // sentence.distinct.length == 26
  }

  // 938. Range Sum of BST
  // Definition for a binary tree node.
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
    var result: Int = 0
    if( root != null){
      result = (
        if (root.value >= low && root.value <= high) root.value else 0) + (
        if (root.value < high) rangeSumBST(root.right, low, high) else 0) + (
        if (root.value > low) rangeSumBST(root.left, low, high) else 0)
    }
    result
  }

  // 1662. Check If Two String Arrays are Equivalent
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    var result: Boolean = false
    var w1: String = ""
    var w2: String = ""
    for (item <- word1) w1 += item
    for ( item <- word2) w2 += item
    if (w1 == w2) result = true
    result

  // word1.mkString == word2.mkString
  }

  // 1588. Sum of All Odd Length Subarrays
  def sumOddLengthSubarrays(arr: Array[Int]): Int = {
    var result: Int = 0
    for (i <- arr.indices){
      var j = i
      while ( j <  arr.length){
        for (k <- i to j) {
          result += arr(k)
        }
        j += 2
      }
    }
    result
  }

  // tests

  // println(subsetXORSum(Array(5,1,6)))

  // for ( i <- runningSum(Array(1,2,3,4))) println(i)

  // println(defangIPaddr("1.1.1.1"))

  // println(maximumWealth(Array(Array(1,2,3),Array(3,2,1))))

  // for ( i <- shuffle(Array(2,5,1,3,4,7),n = 3)) println(i)

  // println(numIdenticalPairs(Array(1,2,3,1,1,3)))

  // println(numJewelsInStones(jewels = "z", stones = "ZZ"))

  // var parkingSystem  = new ParkingSystem(1, 1, 0)
  // var param_1 = parkingSystem .addCar(1)
  // parkingSystem .addCar(2)
  // parkingSystem .addCar(3)
  // parkingSystem .addCar(1)

  // println(subtractProductAndSum(234))

  // println(numberOfSteps(0))

  // println(restoreString(s = "codeleet", indices = Array(4,5,6,7,0,2,1,3)))

  // for ( i <- decode(encoded = Array(1,2,3), first = 1)) println(i)

  // println(interpret(command = "G()(al)"))

  // for ( i <- createTargetArray(nums = Array(0,1,2,3,4), index = Array(0,1,2,2,1))) println(i)

  // println(countMatches(List(
  // List("ii","iiiiiii","ii"),List("iiiiiii","iiiiiii","ii"),List("ii","iiiiiii","iiiiiii")
  // ), ruleKey = "color", ruleValue = "ii"))

  // println(balancedStringSplit(s = "RLRRLLRLRL"))

  // println(xorOperation(n = 5, start = 0))

  // println(checkIfPangram(sentence = "thequickbrownfoxjumpsoverthelazydog"))

  // var root = new TreeNode
  // root = new TreeNode(10)
  // root.left = new TreeNode(5)
  // root.right = new TreeNode(50)
  // root.left.left = new TreeNode(1)
  // root.right.left = new TreeNode(40)
  // root.right.right = new TreeNode(100)
  // println(rangeSumBST(root, low = 7, high = 15))

  // println(arrayStringsAreEqual(word1 = Array[String]("ab", "c"), word2 = Array[String]("a", "bc")))

  // println(sumOddLengthSubarrays(arr = Array(1,4,2,5,3)))



}
