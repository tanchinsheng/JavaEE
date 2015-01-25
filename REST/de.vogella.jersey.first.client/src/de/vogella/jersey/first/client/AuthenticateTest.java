package de.vogella.jersey.first.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;
import org.jboss.resteasy.client.core.executors.ApacheHttpClientExecutor;

public class AuthenticateTest {

  public static void main(String[] args) {

    HttpClient client = new HttpClient();
    
    // pass our credentials to HttpClient, they will only be used for
    // authenticating to servers with realm "realm" on the host
    // "www.verisign.com", to authenticate against an arbitrary realm 
    // or host change the appropriate argument to null.
    client.getState().setCredentials(
            new AuthScope("10.80.108.154", 443, "realm"),
            new UsernamePasswordCredentials("username", "password")
            );
    
    // create a GET method that reads a file over HTTPS, 
    // we're assuming that this file requires basic 
    // authentication using the realm above.
    GetMethod get = new GetMethod(
            "http://10.80.108.154:10080/de.vogella.jersey.first/rest/secured");
    
    // Tell the GET method to automatically handle authentication. The
    // method will use any appropriate credentials to handle basic
    // authentication requests.  Setting this value to false will cause
    // any request for authentication to return with a status of 401.
    // It will then be up to the client to handle the authentication.
    get.setDoAuthentication( true );
    
    try {
        // execute the GET
        int status = client.executeMethod( get );
        
        // print the status and response
        System.out.println(status + "\n" + 
                get.getResponseBodyAsString());
        
    } finally {
        // release any connection resources used by the method
        get.releaseConnection();
    }
}
}
