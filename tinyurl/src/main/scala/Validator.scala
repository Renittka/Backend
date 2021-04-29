trait Validator[T] {
  def validate(t: T): Option[ApiError]
}

object CreateShortUrlValidator extends Validator[CreateUrl] {
  def validate(createUrl: CreateUrl): Option[ApiError] = {
    if (UrlUtils.isValidURL(createUrl.original)) None
    else Some(ApiError.invalidUrl)
  }
}