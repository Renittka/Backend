import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object Manager {
  final case class Calculate(whom: String, replyTo: ActorRef[Calculated])

  final case class Calculated(whom: String, from: ActorRef[Calculate])

  def apply(): Behavior[Calculate] = Behaviors.receive { (context, message) =>
    context.log.info("Start calculating {}",message.whom)
    message.replyTo ! Calculated(message.whom, context.self)
    Behaviors.same
  }
}