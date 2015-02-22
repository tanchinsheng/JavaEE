package com.corejsf;

import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean // or @Named
@RequestScoped
public class LocaleChanger {
   public String changeLocale() {
      FacesContext context = FacesContext.getCurrentInstance();
      String languageCode = getLanguageCode(context);
      context.getViewRoot().setLocale(new Locale(languageCode));
      return null;
   }
   private String getLanguageCode(FacesContext context) {
      Map<String, String> params = context.getExternalContext().
         getRequestParameterMap();
      return params.get("languageCode");
   }
}
