package com.corejsf;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;

@ManagedBean(name="user") // or @Named("user")
@SessionScoped
public class UserBean {
   private String name = "";
   private String password;
   private boolean loggedIn;

   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }
   
   public boolean isLoggedIn() { return loggedIn; }
   
   public String login()  {
      loggedIn = true;
      return "index";
   }
   
   public String logout() {
      loggedIn = false;
      return "login";
   }
   
   public void checkLogin(ComponentSystemEvent event) {      
      if (!loggedIn) {
         FacesContext context = FacesContext.getCurrentInstance();
         ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler)
            context.getApplication().getNavigationHandler();
         handler.performNavigation("login");
      }
   }   
}