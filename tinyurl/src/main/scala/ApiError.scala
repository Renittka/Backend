import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, message: String)

object ApiError {
  private def apply(statusCode: StatusCode, message: String): ApiError =
    new ApiError(statusCode, message)

  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, "Something went wrong.")
  val invalidUrl: ApiError = new ApiError(StatusCodes.BadRequest, "Url is not valid.")
  val urlDoesNotExist: ApiError = new ApiError(StatusCodes.NotFound, "Url does not exist.")
}