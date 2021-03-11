object Operation extends Enumeration {
  type Operation = Value
  val PLUS, MINUS, DIVIDE, MULTIPLY = Value

  def getOperation(operation :Char): Operation = {
    operation match {
      case '+' => PLUS
      case '-' => MINUS
      case '/' => DIVIDE
      case '*' => MULTIPLY
    }
  }
}
