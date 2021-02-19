object SalaryRaiser {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

}

object SalaryRaiser2 {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double])(promotionFunction: Double => Double): List[Double] =
    promotion(salaries, promotionFunction)

}

object Main extends App {
  val list  = List(1.0, 2.0, 3.0, 4.0)
  SalaryRaiser.greatPromotion(list).foreach(x => print(x + " "))
  SalaryRaiser.hugePromotion(list).foreach(x => print(x + " "))
  SalaryRaiser.smallPromotion(list).foreach(x => print(x + " "))

  SalaryRaiser2.smallPromotion(list)(x => x * 1.1)
}