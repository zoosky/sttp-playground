import sttp.client._
import sttp.model.{Method, StatusCode, _}

object Main extends App {

  println("Hello, World!")

  val query = "http language:scala"
  val sort: Option[String] = None

// the `query` parameter is automatically url-encoded
// `sort` is removed, as the value is not defined
  val request = basicRequest.get(
    uri"https://www.nic.ch/"
  )

  implicit val backend = HttpURLConnectionBackend()
  val response = request.send()

// response.header(...): Option[String]
  println(response.header("Content-Length"))
  if (response.code == StatusCode.Ok) println("Ok!")
  println(response.code)

// response.body: by default read into an Either[String, String]
// to indicate failure or success
  //  println(response.body)
}
