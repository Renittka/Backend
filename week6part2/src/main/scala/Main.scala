import akka.actor.typed.ActorSystem
import org.slf4j.{Logger, LoggerFactory}

object Main extends  App {

  implicit val log: Logger = LoggerFactory.getLogger(getClass)
  val system: ActorSystem[Server.Message] = ActorSystem(Server("localhost", 8080), "BuildJobsServer")
}
