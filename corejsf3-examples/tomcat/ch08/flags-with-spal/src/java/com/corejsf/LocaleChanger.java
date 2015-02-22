package com.corejsf;

import java.util.Locale;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean // or @Named
@RequestScoped
public class LocaleChanger {
   private String languageCode;
   
   public String changeLocale() {
      FacesContext context = FacesContext.getCurrentInstance();
      context.getViewRoot().setLocale(new Locale(languageCode));
      return null;
   }
   public void setLanguageCode(String newValue) {
      languageCode = newValue;
   }
}
