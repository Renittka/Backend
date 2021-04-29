import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.{Directives, Route}

import scala.concurrent.ExecutionContext

trait  Router {
  def route:Route
}

class MyRouter(calculatorRepository: CalculatorRepository)(implicit system: ActorSystem[_],  ex:ExecutionContext)
  extends Router
    with  Directives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._

  override def route =
    path("calculate") {
      get {
        parameters('eq.as[String]) { equation =>
          complete {
            calculatorRepository.calculate(equation)
          }
        }
      }
  }

}
