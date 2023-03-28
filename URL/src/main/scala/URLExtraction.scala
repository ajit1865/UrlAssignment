import javax.naming.MalformedLinkException

class URLExtraction(val url: String)

/* method URLExtraction is used to extract all section like https://www.google.com/home
* Protocol: https
* Domain: www.google.com
* Path: home
*/
object URLExtraction {
  def unapply(fetchUrl: URLExtraction): Option[(String, String, String)] = {
    val url = fetchUrl.url
    //creating a substring of protocol and strore in protocolIndex
    val protocolIndex: Option[String] = {
      if (url.contains("://")) {
        val protocolIndexBeginning = url.substring(0, url.indexOf(":"))
        Some(protocolIndexBeginning)
      } else None
    }
    //creating a substring of domain and store in Domain
    val domainIndex: Option[String] = {
      if (url.contains("/")) {
        val firstLength = protocolIndex.getOrElse("").length + 3
        val domainIndexBeginning = url.substring(firstLength, url.indexOf("/", firstLength))
        Some(domainIndexBeginning)
      } else None
    }
    //storing path in pathString
    val pathIndex: Int = protocolIndex.getOrElse("").length + domainIndex.getOrElse("").length + 3
    val pathString = url.substring(pathIndex + 1)
    Some(protocolIndex.getOrElse(""), domainIndex.getOrElse(""), pathString)
  }
}
