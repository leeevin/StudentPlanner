/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentplanner;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class DBaseConn {
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/schedule";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();
      
      
      
      //String sql = "CREATE DATABASE STUDENTS";
      //stmt.executeUpdate(sql);
      //String 
      rs = stmt.executeQuery("SELECT * FROM monday ");
      while (rs.next()) {
                                //JOptionPane.showConfirmDialog(null, "ok");
                                //newStock = rs.getInt("Dquantity");
                                //newPrice = rs.getDouble("Dtotal");
                                JOptionPane.showMessageDialog(null, rs.getString("Time"));
                                JOptionPane.showMessageDialog(null, rs.getString("Subject"));
                            }  
      
      //System.out.println("Database created successfully...");
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){

      e.printStackTrace();
   }finally{

      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
          
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   }
}
