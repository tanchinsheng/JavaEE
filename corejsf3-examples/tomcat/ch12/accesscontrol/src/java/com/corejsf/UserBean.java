package com.corejsf;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="user") // or @Named("user")
@SessionScoped
public class UserBean implements Serializable {
   private String name;
   private String role;
   private static Logger logger = Logger.getLogger("com.corejsf");
 
   public String getName() { 
      if (name == null) getUserData(); 
      return name == null ? "" : name; 
   }

   public String getRole() { return role == null ? "" : role; }
   public void setRole(String newValue) { role = newValue; }

   public boolean isInRole() { 
      ExternalContext context 
         = FacesContext.getCurrentInstance().getExternalContext();
      Object requestObject =  context.getRequest();
      if (!(requestObject instanceof HttpServletRequest)) {
         logger.severe("request object has type " + requestObject.getClass());
         return false;
      }
      HttpServletRequest request = (HttpServletRequest) requestObject;
      return request.isUserInRole(role);
   }

   private void getUserData() {
      ExternalContext context 
         = FacesContext.getCurrentInstance().getExternalContext();
      Object requestObject =  context.getRequest();
      if (!(requestObject instanceof HttpServletRequest)) {
         logger.severe("request object has type " + requestObject.getClass());
         return;
      }
      HttpServletRequest request = (HttpServletRequest) requestObject;
      name = request.getRemoteUser();
   }
}