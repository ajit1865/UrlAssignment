import javax.naming.MalformedLinkException

object URLDriver extends App {
  val obj = new URLExtraction("https://www.google.com/home")
  val result = obj match {
    case URLExtraction(protocol, domain, path) => s"Protocol: $protocol\nDomain: $domain\nPath: $path"
    case _ => throw new MalformedLinkException("The URL is malformed")
  }
  println(result)

}
