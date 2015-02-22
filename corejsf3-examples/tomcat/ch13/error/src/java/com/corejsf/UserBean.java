package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;

@SessionScoped
@ManagedBean(name="user") // or @Named("user")
public class UserBean implements Serializable {
   private String name;
   private String password;

   public String getName() { return name; }
   public void setName(String newValue) { name = newValue; }

   // Here we purposefully cause a NullPointerException
   public String getPassword() { return password.substring(0); }
   public void setPassword(String newValue) { password = newValue; }
}