package com.corejsf;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

@ManagedBean // or @Named
@RequestScoped
public class Planets {
   public String[] getNames() { 
      return new String[] { 
         "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", 
         "Uranus", "Neptune", "Pluto" 
      }; 
   }
   
   public double[] getValues() { 
      return new double[] { 
         3100, 7500, 8000, 4200, 88000, 71000, 32000, 30600, 1430 
      }; 
   }      
}
