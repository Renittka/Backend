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
  def f1(): Unit ={
    val list  = List(1.0, 2.0, 3.0, 4.0)
    SalaryRaiser.greatPromotion(list).foreach(x => print(x + " "))
    SalaryRaiser.hugePromotion(list).foreach(x => print(x + " "))
    SalaryRaiser.smallPromotion(list).foreach(x => print(x + " "))

    SalaryRaiser2.smallPromotion(list)(x => x * 1.1)
  }

  def toInt(s: String): Option[Int] = {
    try{
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  def f2(): Unit ={
//    println(toInt("1").get)
//    println(toInt("z").getOrElse("error"))
    toInt("1") match {
      case Some(x) => println(x)
      case None => println("error")
    }
  }

  def f3(): Unit ={
    val stringA = "1"
    val stringB = "2"
    val stringC = "5"

    val y = for {
      a <- toInt(stringA)
      b <- toInt(stringB)
      c <- toInt(stringC)
    } yield  a + b + c

    y match {
      case Some(x) => println(x)
      case None => println("error")
    }
  }

  f3()
}