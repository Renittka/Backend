import akka.actor.typed.ActorSystem
import org.slf4j.{Logger, LoggerFactory}

object Main extends App {
  implicit val log: Logger = LoggerFactory.getLogger(getClass)

  var res : Boolean = true
  var pureInput: String = ""

  val system: ActorSystem[CalculatorMain.StartCalculate] = ActorSystem(CalculatorMain(), "calculator")
  log.info("Calculator started \n")

  while (res) {
    var s : String = scala.io.StdIn.readLine()
    pureInput = pureInput.concat(s)
    if (s.contains("=")) {
      pureInput = pureInput.replace("=", "")
      pureInput = pureInput.replace(" ", "")
      res = false
    }
    system ! CalculatorMain.StartCalculate(pureInput)
  }
}