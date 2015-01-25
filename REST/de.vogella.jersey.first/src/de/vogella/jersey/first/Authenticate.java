package de.vogella.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;

@Path("/secured")
public class Authenticate
{
   @GET
   public String get(@Context SecurityContext ctx)
   {
      System.out.println("********* IN SECURE CLIENT");
      if (!ctx.isUserInRole("admin"))
      {
         System.out.println("NOT IN ROLE!!!!");
         throw new WebApplicationException(401);
      }
      return "hello";
   }

   @GET
   @Path("/authorized")
   @RolesAllowed("admin")
   public String getAuthorized()
   {
      return "authorized";
   }

   @GET
   @Path("/deny")
   @DenyAll
   public String deny()
   {
      return "SHOULD NOT BE REACHED";
   }
}