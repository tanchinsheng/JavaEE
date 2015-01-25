package de.vogella.jersey.first;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;


// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET
// annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME
// types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

// Sets the path to base URL + /hello
@Path("/helloxml")
public class HelloXML {


  // This method is called if XML is request
//  @GET
//  @Produces(MediaType.TEXT_XML)
//  public String sayXMLHello() {
//    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
//  }

    @GET
    @Produces(MediaType.TEXT_XML)
    public StreamingOutput get() {
      return new StreamingOutput() {
        public void write(OutputStream output) throws IOException, WebApplicationException {
          final String data = "<?xml version=\"1.0\"?>" + "<hello> Hello YangJun" + "</hello>";
          output.write(data.getBytes());
        }
      };
    }

  
}
