package com.corejsf;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;

@ManagedBean(name="tz") // or @Named("tz")
@RequestScoped
public class TimeZoneBean {
   private String[] data = java.util.TimeZone.getAvailableIDs();
   public String[] getData() { return data; }
}
