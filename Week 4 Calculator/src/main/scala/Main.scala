import sun.misc.Signal

sealed abstract class Expression

final case class Literal(v: Double) extends Expression

final case class Ref(name: String) extends Expression

final case class Plus(a: Expression, b: Expression) extends Expression

final case class Minus(a: Expression, b: Expression) extends Expression

final case class Times(a: Expression, b: Expression) extends Expression

final case class Divide(a: Expression, b: Expression) extends Expression

//object Calculator {
//  def computeValues(namedExpressions: Map[String, Signal[Expr]]): Map[String, Signal[Double]] = {
//    namedExpressions map {
//      case (name, expr) => name -> Signal(eval(expr(), namedExpressions))
//    }
//  }

  def eval(expr: Expression, references: Map[String, Signal[Expression]]): Double = {
    expr match {
      case Literal(v) => v
      case Plus(a, b) => eval(a, references) + eval(b, references)
      case Minus(a, b) => eval(a, references) - eval(b, references)
      case Times(a, b) => eval(a, references) * eval(b, references)
      case Divide(a, b) => eval(a, references) / eval(b, references)
    }
  }
class Calculator {
  def plus(a: Int, b: Int): Int = a+b

  def minus(a: Int, b: Int): Int = a-b

  def multiply(a: Int, b: Int): Long = a*b

  def divide(a: Int, b: Int): Int = {
    require(b != 0, "denominator can not be 0")
    a/b
  }
}
object Solution extends App {
  val calc = new Calculator
//  val input = scala.io.StdIn.readLine()
  val a = scala.io.StdIn.readLine()
  val b = scala.io.StdIn.readLine()
  val result = calc.minus(a.toInt,b.toInt)
  println("Result is " + result)
}