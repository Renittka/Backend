import scala.collection.mutable.ArrayBuffer

object Main extends App {
  class Person(var firstName: String, var lastName: String){
    // 'public' access by default
    var age = 20
    // class fields
    private val HOME = System.getProperty("user.home")
    //methods
    def printHome(): Unit = println(s"HOME = $HOME")
    def printFullName() = println(this)
    override def toString: String = s"$firstName $lastName is $age years old"
  }

  def f1(): Unit ={
    val x = new Person("A", "B")
    println(x)
    x.printHome()
    x.printFullName()
  }

  val DefaultCrustSize = 12
  val DefaultCrustType = "THIN"

  // primary constructor
  class PizzaConstructor(var crustSize: Int, var crustType: String){

    // one-arg auxiliary constructor
    def this(crustSize: Int) = {
      this(crustSize, DefaultCrustType)
    }

    // one-arg auxiliary constructor
    def this(crustType: String) = {
      this(DefaultCrustSize, crustType)
    }

    // zero-arg auxiliary constructor
    def this() = {
      this(DefaultCrustSize, DefaultCrustType)
    }

    override def toString: String = s"A $crustSize inch pizza with a $crustType crust"
  }

  val p1 = new PizzaConstructor(DefaultCrustSize, DefaultCrustType)
  val p2 = new PizzaConstructor(DefaultCrustSize)
  val p3 = new PizzaConstructor(DefaultCrustType)
  val p4 = new PizzaConstructor

  class Socket(var timeout: Int = 2000, var linger: Int = 3000){
    override def toString: String = s"timeout: $timeout, linger: $linger"
  }

  def add(a: Int, b: Int, c: Int): Int = a + b + c

  def addThenDouble(a: Int, b: Int): Int = {
    val sum = a + b
    val doubled = sum * 2
    doubled
  }
  def f2(): Unit = {
    trait Drawable{
      def draw(): Unit ={
        println("drawing")
      }
    }

    class Rectangle(x: Int) extends Drawable {
      def doIt(): Unit ={
        println(x)
      }
    }

    class Circle(x: Int) extends Drawable {
      def doIt(): Unit ={
        println(x)
      }
    }

    def Generate(x: Drawable) = {

    }

    val y = new Rectangle(12)
    y.doIt()
    y.draw()
  }
  def PizzaCase(): Unit ={
    sealed trait Topping
    case object Cheese extends Topping
    case object Pepperoni extends Topping
    case object Sausage extends Topping
    case object Mushrooms extends Topping
    case object Onions extends Topping

    sealed trait CrustSize
    case object SmallCrustSize extends CrustSize
    case object MediumCrustSize extends CrustSize
    case object LargeCrustSize extends CrustSize

    sealed trait CrustType
    case object RegularCrustType extends CrustType
    case object ThinCrustType extends CrustType
    case object ThickCrustType extends CrustType

    class Pizza(
               var crustSize: CrustSize = MediumCrustSize,
               var crustType: CrustType = RegularCrustType
               ){
      // ArrayBuffer is a mutable sequence (list)
      val toppings = ArrayBuffer[Topping]()

      def addTopping(t: Topping): Unit ={
        toppings += t
      }
      def removeTopping(t: Topping) = toppings += t
      def removeAllToppings() = toppings.clear()

      override def toString: String = {
        s"""
           |Crust Size: $crustSize
           |Crust Type: $crustType
           |Toppings: $toppings
           """.stripMargin
      }
    }
  }

  val s = new Socket(timeout=5000, linger=3500)
  f1()
  f2()
}