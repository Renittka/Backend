import java.io.{FileNotFoundException, IOException}
import scala.io.StdIn.readLine

object Hello extends App {
  // type inference
  def ex0(): Unit ={
    val a = 1
    val b = "a string"
    // val c = new Person("Regina")

    // val a: Int = 1
    // val b: String = "a string"
    // val c: Person = new Person("Regina")
  }

  // Hello
  def ex1(): Unit ={
    // types of variables
    val x =  1 // immutable
    var y = 1 // mutable
    y = y + 1

    println(x)
    println(y)
    println("Hello, world")
  }

  // Int type of method
  def ex2(a:Int, b:Int): Int ={
    a + b
  }

  //  ternary operator
  def ex3(a:Int, b:Int): Int ={
    val x = if (a < b) a else b
    x
  }

  // match expressions
  def ex4(i:Int): String ={
    //  val result = i match {
    //    case 1 => "one"
    //    case 2 => "two"
    //    case _ => "not 1 or 2"
    //  }
    //  result

    // alternative way
    i match {
      case 1 => "one"
      case 2 => "two"
      case _ => "not 1 or 2"
    }
  }

  // yield create for-expressions that yield a result
  def ex5(): Unit ={
    val x = for (i <- 1 to 5) yield i * 2
    println(x)
  }

  // boolean match expression
  def ex6(bool: Boolean): String ={
    val booleanAsString = bool match {
      case true => "true"
      case false => "false"
    }
    booleanAsString
  }

  // matching different types
  def getClassAsString(x: Any):String = x match {
    case s: String => s + " is a String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: List[_] => "List"
    //case p: Person => "Person"
    case _ => "Unknown"
  }

  // try/catch exceptions
  def ex7(): Unit ={
    try {
      //writeToFile(text)
    } catch {
      case fnfe: FileNotFoundException => println(fnfe)
      case ioe: IOException => println(ioe)
    }
  }

  // for loops
  def ex8(): Unit ={
    for (arg <- args) println(arg)

    // "x to y" syntax
    for (i <- 0 to 5) println(i)

    // "x to y by" syntax
    for (i <- 0 to 10 by 2) println(i)
  }

  // yield and list of strings
  def ex9(): Unit ={
    val fruits = List("apple", "banana", "lime", "orange")
    val fruitLengths = for {
      f <- fruits
      if f.length > 4
    } yield f.length
    print(fruitLengths)
  }
  def ex10(): Unit ={
    var x = 1
    var y = 2
    // while loop
    while(x<10) {
      print(x + " ")
      x = x + 1
    }

    // do-while
    do {
      print(y + " ")
      y = y + 1
    }
    while(y<10)
  }

  // Scala class
  class Person(var firstName: String, var lastName: String) {
    def printFullName(): Unit = println(s"$firstName $lastName")
  }

  // complicated example
  //  class Pizza (
  //                var crustSize: CrustSize,
  //                var crustType: CrustType,
  //                val toppings: ArrayBuffer[Topping]
  //              ) {
  //    def addTopping(t: Topping): Unit = toppings += t
  //    def removeTopping(t: Topping): Unit = toppings -= t
  //    def removeAllToppings(): Unit = toppings.clear()
  //  }

  // Class usage
  val p = new Person("Julia", "Kern")
  println(p.firstName)
  p.lastName = "Manes"
  p.printFullName()

  // Scala methods
  def sum(a: Int, b: Int): Int = a + b
  def concatenate(s1: String, s2: String): String = s1 + s2

  val x = sum(1,2)
  val y = concatenate("foo", "bar")
  println(x, y)

  // Traits
  trait Speaker {
    def speak(): String // has no body, so it's abstract
  }

  trait TailWagger {
    def startTail(): Unit = println("tail is wagging")
    def stopTail(): Unit = println("tail is stopped")
  }

  trait Runner {
    def startRunning(): Unit = println("I'm running")
    def stopRunning(): Unit = println("Stopped running")
  }

  class Dog(name: String) extends Speaker with TailWagger with Runner {
    def speak(): String = "Woof!"
  }

  class Cat(name: String) extends Speaker with TailWagger with Runner {
    def speak(): String = "Meow"
    override def startRunning(): Unit = println("Yeah ... I don't run")
    override def stopRunning(): Unit = println("No need to stop")
  }

  val dog = new Dog("Reks")
  val cat = new Cat("Catty")

  println(dog.speak())
  println(cat.speak())

  dog.startRunning()
  cat.startRunning()

  val nums = List.range(0, 10)
  val nums1 = (1 to 10 by 2).toList
  val letters = ('a' to 'f').toList
  val letters1 = ('a' to 'f' by 2).toList

  // foreach method
  val names = List("joel", "ed", "chris", "maurice")
  names.foreach(println)
  // filter method
  nums.filter(_ < 4).foreach(println)
  // map method
  val doubles = nums.map(_ * 2)
  val capNames = names.map(_.capitalize)
  val lessThanFive = nums.map(_ < 5)
  // foldLeft method
  nums.foldLeft(0)(_ + _)
  nums.foldLeft(1)(_ * _)

  // Tuples
  class Person1(var name: String)
  val t = (11, "Eleven", new Person1("Eleven"))
  t._1
  t._2
  t._3
  val (num, string, person) = (11, "Eleven", new Person1("Eleven"))

  //Alternative way of output
  val firstName = "John"
  val mi = 'C'
  val lastName = "Doe"
  println(s"Name: $firstName $mi $lastName")

  // Reading input
  print("Enter your first name: ")
  val firstName1 = readLine()
  print("Enter your last name: ")
  val lastName1 = readLine()

  println(s"Your name is $firstName1 $lastName1")

  // Map and Foreach
  val ratings = Map(
    "Lady in the Water"  -> 3.0,
    "Snakes on a Plane"  -> 4.0,
    "You, Me and Dupree" -> 3.5
  )
  for ((name,rating) <- ratings) println(s"Movie: $name, Rating: $rating")
  ratings.foreach {
    case(movie, rating) => println(s"key: $movie, value: $rating")
  }
  val names2 = List("adam", "david", "frank")
  val names3 = List("_adam", "_david", "_frank")
  val ucNames = for (name <- names2) yield name.capitalize
  val capNames1 = for (name <- names3) yield {
    val nameWithoutUnderscore = name.drop(1)
    val capName = nameWithoutUnderscore.capitalize
    capName
  }
  // shorter version
  val capNames2 = for (name <- names) yield name.drop(1).capitalize

  // match
  val i = readLine()
  val monthName = i match {
    case 1  => "January"
    case 2  => "February"
    case 3  => "March"
    case 4  => "April"
    case 5  => "May"
    case 6  => "June"
    case 7  => "July"
    case 8  => "August"
    case 9  => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _  => "Invalid month"
  }

  def convertBooleanToStringMessage(bool: Boolean): String = bool match {
    case true => "you said true"
    case false => "you said false"
  }

  val evenOrOdd = i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
    case _ => println("some other number")
  }

  try {
    // your scala code here
  }
  catch {
//    case foo: FooException => handleFooException(foo)
//    case bar: BarException => handleBarException(bar)
    case _: Throwable => println("Got some other kind of Throwable exception")
  } finally {
    // your scala code here, such as closing a database connection
    // or file handle
  }
}