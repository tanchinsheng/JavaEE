package com.corejsf;

import javax.faces.bean.ManagedBean;
   // or import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
   // or import javax.faces.bean.ApplicationScoped;

@Named //@ManagedBean
@ApplicationScoped
public class AutoComplete {
   public String[] getLocations() {
      return new String[] {
          "Arvada", "Colorado Springs", "Baltimore", "Brittany", "Bahamas",
          "Belgrade", "Boulder", "Bayou", "Brighton", "Buffalo", "Denver", "Dixie",
          "Evergreen", "Ft. Collins", "Los Angeles", "Los Lobos", "Las Vegas",
          "Loveland", "Vail"
      };
   }
}