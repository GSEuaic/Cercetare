/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;  
@Path("/goodbye")  
public class Goodbye {  
  // This method is called if HTML and XML is not requested  
  @GET  
  @Produces(MediaType.TEXT_PLAIN)  
  public String sayPlainTextHello() {  
    return "Hello Jersey Plain";  
  }  
  // This method is called if XML is requested  
  @GET  
  @Produces(MediaType.TEXT_XML)  
  public String sayXMLHello() {  
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";  
  }  
  
  // This method is called if HTML is requested  
  @GET  
  @Produces(MediaType.TEXT_HTML)  
  public String sayHtmlHello() {  
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"  
        + "<body><h1>" + "Goodbye" + "</h1></body>" + "</html> ";  
  }  
}    
