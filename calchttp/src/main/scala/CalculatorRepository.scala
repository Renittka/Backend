import scala.concurrent.ExecutionContext

trait CalcRepository {
  def calculate(equation: String): String
}

class CalculatorRepository(implicit ec: ExecutionContext) extends CalcRepository {
  override def calculate(equation: String): String = Calculator.calculate(equation)
}