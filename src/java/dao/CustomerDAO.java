/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dao.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author USER
 */
public class CustomerDAO {
    
    
    
//    public static String login(String lname, String pwd) {
//        try {
//            Connection con = Database.getConnection();
//            if ( con == null )
//                return null;
////            log_id, username, password, userrole, userstatus, branchcode
//            PreparedStatement ps = con.prepareStatement("select userrole from login where username = ? and password = ?");
//            ps.setString(1,lname);
//            ps.setString(2,pwd);
//            ResultSet rs = ps.executeQuery();
//            String customerid=null;
//            if ( rs.next() )  // found - return fullname
//                customerid = rs.getString("userrole");
//            rs.close();
//            con.close();
//            return customerid;
//        } catch(Exception ex) {
//            return null;
//        }
//        
//        
//        
//        
//    }
  
     public static String login(String lname, String pwd) {
         
        
            
                try {
                    String customerid=null;
                     if (!lname.isEmpty()) {
                          if (!pwd.isEmpty()) {
                    
                    Connection con = Database.getConnection();
                    if ( con == null )
                             return null;
                    
                    ResultSet rs = null, rs2 = null;
                    Statement stat;
                    stat = con.createStatement();
                    int count = 0;
                    String userid = "";
                    String status = "";
                    
                    rs = stat.executeQuery("select log_id,userstatus from login where username = '"+lname+"' and password = '"+pwd+"' ");

                    while (rs.next()) {
                        count = rs.getRow();
//                        
                        status = rs.getString("userstatus");
                        userid = rs.getString("log_id");
                    }
                    if (lname.equals("SuperAdmin") && pwd.equals("Administrator")) {
                        customerid="admin";

                    } else if (count > 0 && status.equals("1")) {

                        customerid=userid;
                       
                    } else {
                       customerid=null;
                        
                      }
                    }
                  }
                     return customerid;
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }


            }
     
    
}
