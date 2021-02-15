import scala.collection.mutable.ArrayBuffer

object Main extends App {
  def f1(): Unit ={
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

    val x = new Person("A", "B")
    println(x)
    x.printHome()
    x.printFullName()
  }

  def pizzaConstructor(): Unit ={
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
  }

  def paramExample(): Unit ={
    class Socket(var timeout: Int = 2000, var linger: Int = 3000){
      override def toString: String = s"timeout: $timeout, linger: $linger"
    }

    def add(a: Int, b: Int, c: Int): Int = a + b + c

    def addThenDouble(a: Int, b: Int): Int = {
      val sum = a + b
      val doubled = sum * 2
      doubled
    }

    val s = new Socket(timeout=5000, linger=3500)
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

  def pizzaCase(): Unit ={
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
    // a little "driver" app
      val p = new Pizza
      p.addTopping(Cheese)
      p.addTopping(Pepperoni)
      println(p)

  }

  def animalCase(): Unit ={
    trait Speaker{
      def speak(): String
    }

    trait TailWagger {
      def startTail(): Unit = println("tail is wagging")
      def stopTail(): Unit= println("tail is stopped")
    }

    trait Runner {
      def startRunning(): Unit = println("I'm running")
      def stopRunning(): Unit = println("Stopped running")
    }

    class Dog extends Speaker with TailWagger with Runner {
      def speak(): String = "Woof!"

      // TailWagger
      override def startTail(): Unit = println("tail is wagging")
      override def stopTail(): Unit = println("tail is stopped")

      //  Runner
      override def startRunning(): Unit = println("I'm running")
      override def stopRunning(): Unit = println("Stopped running")
    }

    class Cat extends Speaker with TailWagger with Runner {
      override def speak(): String = "Meow"

      override def startRunning(): Unit = println("Yeah ... I don't run")
      override def stopRunning(): Unit = println("No need to stop")
    }

    //Mixing traits in on the fly
    class Crocodile(name: String)
    val c = new Crocodile("Fido") with TailWagger with Runner
  }

  def abstractCase(): Unit ={
    abstract class Pet(name: String){
      def speak(): Unit  = println(s"My name is $name")
      def comeToMaster(): Unit = println("Here I come, Master!")
    }

    class Dog(name: String) extends Pet(name){
      override def speak(): Unit = println("Woof")
      override def comeToMaster(): Unit = println("Here I come!")
    }

    class Cat(name: String) extends Pet(name)

    val d = new Dog("Fido")
    val c = new Cat("Catty")
    d.speak()
    c.speak()
  }

  def f3(): Unit ={
    case class Student(name: String, year: Int)
    val s = Student("A", 2021)
    println(s)
  }

  def caseClass(): Unit ={
    trait Person {
      def name: String
    }
    case class Student(name: String, year: Int) extends Person
    case class Teacher(name: String, speciality: String) extends Person

    def getPrintableString(p:Person): String = p match {
      case Student(name, year) =>
        s"$name is a student in Year $year."
      case Teacher(name, whatTheyTeach) =>
        s"$name teaches $whatTheyTeach"
    }

    val s = Student("Al", 1)
    val t = Teacher("Bob Donnan", "Mathematics")
    val c = s.copy(name = "Bl")

    println(getPrintableString(s))
    println(getPrintableString(t))
    println(getPrintableString(c))

    println(s == c)
  }

  def f4(): Unit ={
    class PersonX(var name: String, var relation: String)
    case class Person(name: String, relation: String)

    val christina1 = Person("Christina", "niece")
    val christina2 = Person("Christina", "niece")

    val xchristina1 = new PersonX("Christina", "niece")
    val xchristina2 = new PersonX("Christina", "niece")

    println(christina1 == christina2)
    println(xchristina1 == xchristina2)
  }

  def f5(): Unit ={
    object PizzaUtils {
      def doIt(): Unit ={
        println("did it!")
      }
    }
  }

  def caseObjects(): Unit ={
    case class StartSpeakingMessage(textToSpeak: String)
    case object StopSpeakingMessage
    case object PauseSpeakingMessage
    case object ResumeSpeakingMessage
    class Speak extends Actor {
      def receive = {
        case StartSpeakingMessage(textToSpeak) =>
        // code to speak the text
        case StopSpeakingMessage =>
        // code to stop speaking
        case PauseSpeakingMessage =>
        // code to pause speaking
        case ResumeSpeakingMessage =>
        // code to resume speaking
      }
    }
  }
}