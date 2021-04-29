import akka.actor.typed.ActorSystem
import akka.http.scaladsl.model.{StatusCodes, Uri}
import akka.http.scaladsl.server.{Directives, Route}
import scala.concurrent.ExecutionContext

trait  Router {
  def route:Route
}

class MyRouter(urlRepository: UrlRepository)(implicit system: ActorSystem[_],  ex:ExecutionContext)
  extends Router
    with  Directives
    with ErrorDirectives
    with ValidatorDirectives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  override def route: Route  = concat(
    path("url") {
      get {
        handleWithGeneric(urlRepository.getAll()) { urls =>
          complete(urls)
        }
      } ~
        post {
          entity(as[CreateUrl]) { createShortUrl => {
            validateWith(CreateShortUrlValidator)(createShortUrl) {
              handle(urlRepository.save(createShortUrl)) { url => complete(url) }
            }
          }
          }
        }
    },
    path(Segment) { url =>
      get {
        handleWithGeneric(urlRepository.get(url)) { url2 =>
          val uri = Uri.apply(url2)
          redirect(uri, StatusCodes.PermanentRedirect)
        }
      }
    }
  )
}