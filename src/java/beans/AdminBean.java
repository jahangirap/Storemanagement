/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.CustomerDAO;
import dao.Database;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 *
 * @author USER
 */
public class AdminBean {
    
    private String _username,_password,_message,customerid;

    public String getMessage() {
        return _message;
    }

    public void setMessage(String _message) {
        this._message = _message;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }
    
    
   
        
      public String login(){
          _message=null;
          String abc=null;
          String message=null;
          int log_id=0;
          String branch=null;
          
            
            try {

                        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                        Connection con = Database.getConnection();
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select * from login where username='" + _username + "'and password='" + _password + "'");
//                        log_id, username, password, userrole, userstatus, branchcode
                        if (rs.next()) {
                            _username = rs.getString("username");
                            _password = rs.getString("password");
                            session.setAttribute("_password", _password);
                            session.setAttribute("_username", _username);
                            setMessage("success");
                        }else{
                            setMessage("Sorry! Invalid Login!");
                        }
                      
                       
                    } catch (Exception e) {
                        _message=e.getMessage();
                    }
           
           
        return _message;
         
          
   
   } 
    
    
    
    
    
    
    
    
    
    
}
