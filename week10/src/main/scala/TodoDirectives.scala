import scala.concurrent.Future
import scala.util.{Failure, Success}

import akka.http.scaladsl.server.{Directive1, Directives}

trait TodoDirectives extends Directives {

  import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
  import io.circe.generic.auto._

  def handleThrowable[T](f: Future[T])(e: Throwable => ApiError): Directive1[T] = onComplete(f) flatMap {
    case Success(t) =>
      provide(t)
    case Failure(error) =>
      val apiError = e(error)
      complete(apiError.statusCode, apiError.message)
  }


  def handle[T](f: Future[T]): Directive1[T] = onComplete(f) flatMap {
    case Success(t) =>
      provide(t)
    case Failure(error) =>
      val apiError = error match {
        case a: TodoRepository.TitleAlreadyExists => ApiError.duplicateTitleField
        case b: TodoRepository.TodoNotFound => ApiError.toDoNotFound
        case _ => ApiError.generic
      }
      complete(apiError.statusCode, apiError.message)
  }

  def handleWithGeneric[T](f: Future[T]): Directive1[T] =
    handleThrowable[T](f)(_ => ApiError.generic)
}