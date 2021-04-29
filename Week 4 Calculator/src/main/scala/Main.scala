import scala.collection.mutable

object Operation extends Enumeration {
  type Operation = Value
  val PLUS, MINUS, DIVIDE, MULTIPLY, POWER = Value

  def getOperation(operation :Char): Operation = {
    operation match {
      case '+' => PLUS
      case '-' => MINUS
      case '/' => DIVIDE
      case '*' => MULTIPLY
      case '^' => POWER
    }
  }
}

import Operation._

class Calculator {
  object Error {
    val error = "Invalid operation"
  }

  var digits: mutable.Stack[BigDecimal] = mutable.Stack()
  var operations: mutable.Stack[Operation] = mutable.Stack()

  var x = 0
  var oneOperation = false

  def run(input: String): String = {
    for (char <- input) {
      char match {
        case a
          if char.isDigit =>
          x = x * 10 + a.asDigit
          oneOperation = false

        case _ =>
          digits.push(x)
          x = 0
          if (oneOperation) {
            return Error.error
          }

          val newOperation = Operation.getOperation(char)

          while (operations.nonEmpty) {
            calculation()
          }

          operations.push(newOperation)
          oneOperation = true
      }
    }

    if (x > 0 | input(input.length - 1) == '0') digits.push(x)

    while (operations.nonEmpty & digits.length > 1) {
      calculation()
    }

    if (operations.nonEmpty) return Error.error
    digits.top.setScale(2, BigDecimal.RoundingMode.HALF_UP).toString()
  }

  def power(a: BigDecimal, b: BigDecimal): BigDecimal ={
    var res = BigDecimal(1)
    for (i <- 0 until a.toInt){
      res = res*b
    }
    res
  }

  def calculate(a: BigDecimal, b: BigDecimal, operation:  Operation): BigDecimal = {
    operation match {
      case PLUS => a + b
      case MINUS => b - a
      case MULTIPLY => a * b
      case DIVIDE => b / a
      case POWER => power(a,b)
    }
  }

  def calculation(): Unit ={
    val operation = operations.top
    operations.pop

    val firstDigit = digits.top
    digits.pop

    val secondDigit = digits.top
    digits.pop

    digits.push(calculate(a = firstDigit, b = secondDigit, operation))
  }
}

object Solution extends App {
  var res : Boolean = true
  var pureInput: String = ""

  while (res) {
    val input: String = scala.io.StdIn.readLine()

    pureInput = pureInput.concat(input)
    pureInput = pureInput.replace("=", "")
    pureInput = pureInput.replace(" ", "")
    res = false
  }
  val calculator = new Calculator
  println(calculator.run(pureInput))
}
