package com.corejsf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean; 
   // or import javax.inject.Named;
import javax.enterprise.context.RequestScoped; 
   // or import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

@ManagedBean // or @Named
@RequestScoped
public class CustomerBean {
   @Resource(name="jdbc/mydb")
   private DataSource ds;
   
   public ResultSet getAll() throws SQLException {
      Connection conn = ds.getConnection();
      try {
         Statement stmt = conn.createStatement();        
         ResultSet result = stmt.executeQuery("SELECT * FROM Customers");         
         // return ResultSupport.toResult(result);
         CachedRowSet crs = new com.sun.rowset.CachedRowSetImpl();         
            // or use an implementation from your database vendor
         crs.populate(result);
         return crs;
      } finally {
         conn.close();
      }
   }
}
