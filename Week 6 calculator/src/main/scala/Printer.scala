import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object Printer {
  def apply(): Behavior[Manager.Calculated] = {
    Behaviors.receive { (context, message) =>
      val result = new Brain run (message.whom)
      context.log.info(result)
      Behaviors.same
    }
  }
}
