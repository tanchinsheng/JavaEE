package com.corejsf;

import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean // or @Named
@RequestScoped
public class LocaleChanger {
   public void changeLocale(ActionEvent event) {
      UIComponent component = event.getComponent();
      String languageCode = getLanguageCode(component);
      FacesContext.getCurrentInstance()
         .getViewRoot().setLocale(new Locale(languageCode));
   }
   private String getLanguageCode(UIComponent component) {
      Map<String, Object> attrs = component.getAttributes();
      return (String) attrs.get("languageCode");
   }
}
