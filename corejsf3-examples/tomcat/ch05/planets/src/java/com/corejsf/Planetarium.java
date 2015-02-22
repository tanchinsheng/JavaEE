package com.corejsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

@ManagedBean // or @Named
@RequestScoped
public class Planetarium implements Serializable {
  private String selectedPlanet;
  
  public String getSelectedPlanet() { return selectedPlanet; }
  
  public String changePlanet(String newValue) {
     selectedPlanet = newValue;
     return selectedPlanet;
  }
}
