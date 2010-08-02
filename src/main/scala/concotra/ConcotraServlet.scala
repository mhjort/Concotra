package concotra
 
import org.scalatra._
 
class ConcotraServlet extends ScalatraServlet with UrlSupport {
 
 before {
   contentType = "text/html"
 }
 
 get("/") {
   <html>
     <head>
       <title>Concordion demo</title>
     </head>
     <body>
       <h1>Hello MarkusTiina</h1>
     </body>
   </html>
 }
 
 protected def contextPath = request.getContextPath
}
