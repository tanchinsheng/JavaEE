package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.bean.ManagedBean;
   // or import javax.enterprise.context.SessionScoped;

@ManagedBean(name="user") // or @Named("user")
@SessionScoped
public class UserBean implements Serializable {
   private String name = "";
   private String password;

   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   public String getPassword() { return password; }
   public void setPassword(String newValue) { password = newValue; }
   
   public void validateName(FacesContext fc, UIComponent c, Object value) {
	   try {
		   Thread.sleep(200);
	   } catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	
	   if (((String) value).contains("_"))
	      throw new ValidatorException(
	         new FacesMessage("Name cannot contain underscores"));
   }
}