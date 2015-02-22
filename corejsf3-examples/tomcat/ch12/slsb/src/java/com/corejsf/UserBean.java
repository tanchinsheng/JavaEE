package com.corejsf;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;

@ManagedBean(name="user") // or @Named("user")
@SessionScoped
public class UserBean implements Serializable {
   private String name;
   private String password;
   private boolean loggedIn;
   private int count;
   private Logger logger = Logger.getLogger("com.corejsf");

   @EJB private CredentialsManager cm;
   
   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }
   
   public int getCount() { return count; }

   public String login() {
      try {
         count = cm.checkCredentials(name, password);
         loggedIn = count > 0;
      } catch (Exception ex) {
         logger.log(Level.SEVERE, "login failed", ex);
         return "internalError";
      }
      if (loggedIn)
         return "loginSuccess";
      else 
         return "loginFailure";
   }

   public String logout() { 
      loggedIn = false;
      return "login";
   }
}
