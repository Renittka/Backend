
import org.slf4j.{Logger, LoggerFactory}
import scala.collection.mutable
import scala.collection.mutable.Set
import scala.collection.mutable.ArrayBuffer

object Main extends App{
  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  // 242. Valid Anagram
  def isAnagram(s: String, t: String): Boolean = {
    val result: Boolean = s.sorted.equals(t.sorted) // two sorted strings compares
    result
  }

  // 897. Increasing Order Search Tree
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def increasingBST(root: TreeNode): TreeNode = {
    var nodes = Array[Int]() // array of nodes

    def traverse(node: TreeNode): Unit = { // traverse the graph
      if (node == null) {}
      else { // if node is not null
        traverse(node.left) // traverse with left side of node
        nodes:+= node.value // adds the value to array
        traverse(node.right) // traverse with right side of node
      }
    }

    traverse(root) // start traverse from root

    val result = new TreeNode(nodes(0)) // new root node
    var nodeRes = result // temporary node

    for (node <- nodes.slice(1, nodes.length)) { // creates new tree with only right side
      nodeRes.right = new TreeNode(node) // create new node to right
      nodeRes = nodeRes.right // remembers right node
    }

    result // return the new tree node
  }

  // 559. Maximum Depth of N-ary Tree
  // Definition for a Node.
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

  def maxDepth(root: Node): Int = {
    var result: Int = 0 // var for result
    if (root == null) return 0 // if root is null stops
    else
      for (i <- root.children) { // loops through all nodes
        result = Math.max(maxDepth(i),result) // choose max depth traversing through
      }                                       // nodes
    result + 1 // returns the result + 1 as it counts from 0
  }

  // 104. Maximum Depth of Binary Tree
  def maxDepth(root: TreeNode): Int = {
    var result: Int = 0 // var for result
    if (root == null) return 0 // if root is null, it stops

    val left = maxDepth(root.left) // count the max depth of left side
    val right = maxDepth(root.right) // count the max depth of right side

    result = Math.max(left, right) + 1 // the result is max of two depths
    result                             // counts from 0, so + 1
  }

  // 1370. Increasing Decreasing String
  def sortString(s: String): String = {
    val nums = new Array[Int](26) // array for counting
    val result = new StringBuilder // for result
    for (c <- s) {
      nums(c - 'a') += 1 // add number of char to nums array
    }

    def addChar(i: Int): Unit ={
      if (nums(i) != 0) { // check if nums is empty
        result.append((i + 'a').toChar) // adds to result the char
        nums(i) -= 1 // decreases nums by 1 according to i
      }
    }

    while (result.length < s.length) { // add chars while  result length < s length
      for (i <- 0 until 26) addChar(i) // add char in ascending order
      for (i <- 25 to 0 by -1) addChar(i) // add char in descending order
    }

    result.toString // return the result in String format
  }

  // 1502. Can Make Arithmetic Progression From Sequence
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    val sortedArr: Array[Int] = arr.sorted  // sort the given array
    var count: Int = 0  // var for counting the difference
    var countArr: Array[Int] = Array.emptyIntArray // array of counts

    // counts the difference between items of sorted array and puts into the countArr
    for (i <- 0 until sortedArr.length -1){
      count = sortedArr(i+1) - sortedArr(i)
      countArr = countArr.:+(count)
    }

    // if the length of array of distinct elements equals to 1, it is true, else 0 false
    countArr.distinct.length == 1
  }

  // 1710. Maximum Units on a Truck
  def maximumUnits(boxTypes: Array[Array[Int]], truckSize: Int): Int = {
    var result: Int = 0
//    val sortedArr = boxTypes.sorted()
//    var truckS = truckSize
//    var num: Int = 0
//
//    for(item <- sortedArr) {
//      num = Math.min(item(0), truckSize)
//      result += num*item(1)
//
//      if(truckS < num){}
//      truckS -= num
//    }
    result
  }

  // 349. Intersection of Two Arrays
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val result = nums1.intersect(nums2) // intersect between two arrays
    result.distinct // returns only distinct items of intersection
  }

  // 1640. Check Array Formation Through Concatenation
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    val map = mutable.HashMap[Int, Array[Int]]() // map for storing pieces
    var i: Int = 0 // counter

    for (item <- pieces) { // items of pieces puts into the map
      map.put(item(0), item)
    }

    //iterate all the elements in arr
    while (i < arr.length) { // while counter is less than arr length
      val item = arr(i) // item of array arr
      if (map.contains(item)) { // check if item exists in map
        val mapItem = map.get(item) // item of map
        for (value <- mapItem) {
          if (arr(i) == value(i)) i += 1 //if item of arr is equal to item of map else false
          else return false
        }
      }
      else return false
    }
    true
  }

  // 976. Largest Perimeter Triangle
  def largestPerimeter(nums: Array[Int]): Int = {
    var result: Int = 0 // var for result
    val numsSorted: Array[Int] = nums.sorted // sort the array
    val end = numsSorted.length  // length of sorted nums

    for (i <- end-1 to 2  by -1) { // loop through the sorted array
      val a = numsSorted(i - 2)
      val b = numsSorted(i - 1)
      val c = numsSorted(i)
      if (c < a + b) result = Math.max(result, a + b + c) // check a,b,c forms triangle,count max perimeter
    }
    result
  }

  // test
//  println(isAnagram(s = "a", t = "ab"))

//  var root = new TreeNode
//  root = new TreeNode(5)
//  root.left = new TreeNode(3)
//  root.right = new TreeNode(6)
//  root.left.left = new TreeNode(2)
//  root.left.right = new TreeNode(4)
//  root.right.right = new TreeNode(8)
//  root.left.left.left = new TreeNode(1)
//  root.right.right.left = new TreeNode(7)
//  root.right.right.right = new TreeNode(9)
//  println(increasingBST(root))

//  var r1 = new Node(1)
//  var r2 = new Node(3)
//  var r3 = new Node(2)
//  var r4 = new Node(4)
//  var r5 = new Node(5)
//  var r6 = new Node(6)
//  r1.children = List[Node](r2, r3, r4)
//  r2.children = List[Node](r5, r6)
//  println(maxDepth(r1))

//  var root1 = new TreeNode
//  root1 = new TreeNode(3)
//  root1.left = new TreeNode(9)
//  root1.right = new TreeNode(20)
//  root1.right.left = new TreeNode(15)
//  root1.right.right = new TreeNode(7)
//  println(maxDepth(root1))

//  println(sortString(s = "rat"))

//  println(canMakeArithmeticProgression(arr = Array(3,5,1)))

//  println(maximumUnits(boxTypes = Array(Array(1,3),Array(2,2),Array(3,1)), truckSize = 4))

//  for ( i <- intersection(nums1 = Array(1,2,2,1), nums2 = Array(2,2))) println(i)

//  println(canFormArray(arr = Array(15,88), pieces = Array(Array(85),Array(15))))

//  println(largestPerimeter(nums = Array(3,2,3,4)))

}
