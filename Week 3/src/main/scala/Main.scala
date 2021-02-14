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
  f1()
}