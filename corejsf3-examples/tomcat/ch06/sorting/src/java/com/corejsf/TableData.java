package com.corejsf;

import java.io.Serializable;
import java.util.Comparator;

import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.faces.bean.SessionScoped; 
   // or import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ArrayDataModel;

@ManagedBean // or @Named
@SessionScoped
public class TableData implements Serializable {
   private SortFilterModel<Name> filterModel;
   private static final Name[] names = {
      new Name("Anna", "Keeney"),
      new Name("John", "Wilson"),
      new Name("Mariko", "Randor"),
      new Name("William", "Dupont"),
   };

   public TableData() {
      filterModel = new SortFilterModel<Name>(new ArrayDataModel<Name>(names));
   }
   public DataModel<Name> getNames() {
      return filterModel;
   }

   public String sortByFirst() {
      filterModel.sortBy(new Comparator<Name>() {
         public int compare(Name n1, Name n2) {
            return n1.getFirst().compareTo(n2.getFirst());
         }  
      });
      return null;
   }
   
   public String sortByLast() {
      filterModel.sortBy(new Comparator<Name>() {
         public int compare(Name n1, Name n2) {
            return n1.getLast().compareTo(n2.getLast());
         }  
      });
      return null;
   }
}