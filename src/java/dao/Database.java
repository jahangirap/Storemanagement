package dao;
import java.sql.*;
//import oracle.jdbc.pool.OracleDataSource;

public class Database {
//   static final String USERNAME="helpdesk";
//   static final String PASSWORD="helpdesk";
   
   public static Connection getConnection() 
   {
       try {
            Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://localhost/storemanagement",
                      "root","");
            return con;
       }
       catch(Exception ex) {
           System.out.println(ex.getMessage());
           return null;
       }
   }
}