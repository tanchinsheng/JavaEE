package com.corejsf;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name="form") // or @Named("form")
@SessionScoped
public class RegisterForm implements Serializable {
   private String streetAddress;
   private String city;
   private String state;
   private String country;

   private static final Locale[] countries = { Locale.US, Locale.CANADA };
   public Locale[] getCountries() { return countries; }
   
   public void setStreetAddress(String newValue) { streetAddress = newValue; }
   public String getStreetAddress() { return streetAddress; }

   public void setCity(String newValue) { city = newValue; }
   public String getCity() { return city; }

   public void setState(String newValue) { state = newValue; }
   public String getState() { return state; }

   public void setCountry(String newValue) { country = newValue; }
   public String getCountry() { return country; }

   public void countryChanged(ValueChangeEvent event) {
      for (Locale loc : countries)
         if (loc.getCountry().equals(event.getNewValue()))
            FacesContext.getCurrentInstance().getViewRoot().setLocale(loc);
   }
}
