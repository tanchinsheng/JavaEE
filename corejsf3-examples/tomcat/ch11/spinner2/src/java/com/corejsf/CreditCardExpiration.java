package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@SessionScoped
@ManagedBean(name="cardExpirationDate") // or @Named("cardExpirationDate")
public class CreditCardExpiration implements Serializable {
   private int month = 1;
   private int year = 2010;
   private int changes = 0; // to demonstrate the value change listener

   public int getMonth() { return month; }
   public void setMonth(int newValue) { month = newValue; }

   public int getYear() { return year; }
   public void setYear(int newValue) { year = newValue; }

   public int getChanges() { return changes; }
   
   public void changeListener(ValueChangeEvent e) {
      // we convert to strings because oldValue is a String, newValue is an Integer
      if (!e.getNewValue().toString().equals(e.getOldValue()))
         changes++;
   }
   
   public void incrementYear(ActionEvent event) { year++; month = 1; }
   public void decrementYear(ActionEvent event) { year--; month = 12; }
}