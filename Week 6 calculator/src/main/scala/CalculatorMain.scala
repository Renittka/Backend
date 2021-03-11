import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object CalculatorMain {
  final case class StartCalculate(name: String)

  def apply(): Behavior[StartCalculate] =
    Behaviors.setup { context =>
      val starter = context.spawn(Manager(), "start")

      Behaviors.receiveMessage { message =>
        val replyTo = context.spawn(Printer(), message.name)
        starter ! Manager.Calculate(message.name, replyTo)
        Behaviors.same
      }
    }
}
