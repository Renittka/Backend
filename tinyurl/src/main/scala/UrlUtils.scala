import java.net.URL
import java.util.{Base64, UUID}
import scala.util.hashing.MurmurHash3
import java.net.MalformedURLException

object UrlUtils {

  def encode(inputLink: String): String =
    MurmurHash3.stringHash(inputLink).toString

  def isValidURL(urlStr: String): Boolean = try {
    new URL(urlStr)
    true
  } catch {
    case _: MalformedURLException =>
      false
  }

  def getShortUrlLink(shortUrl: String): String = {
    if (MyServer.port == 7000) "http://localhost:7000/" + shortUrl
    else "https://tinyurlhttp.herokuapp.com/" + shortUrl
  }

  def createUrl(createUrl: CreateUrl): Url = {
    val id = UUID.randomUUID().toString
    Url(
      id = id,
      shortUrl = UrlUtils.encode(id + createUrl.original),
      originalUrl = createUrl.original
    )
  }
}