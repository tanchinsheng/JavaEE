package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;

@SessionScoped
@ManagedBean // or @Named
public class FontSpecifics implements Serializable {
   private int size = 1;
   public int getSize() { return size; }
   public void setSize(int newValue) { size = newValue; }
}