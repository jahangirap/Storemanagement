/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Database;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import java.sql.*;
/**
 *
 * @author USER
 */
public class SkinBean { 

          private String skin="classic"; 

          public String getSkin() { 

               return skin; 

          } 

          public void setSkin(String skin) { 

               this.skin = skin; 

          } 
 
           public List <SelectItem> getskinChose() {
        List<SelectItem>names=new ArrayList<SelectItem>();
        try {
            Connection con = Database.getConnection();
            
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT bg_color_name from background_color ");
//            cat_id=(select cat_id from catagory where cat_name='"+_catname+"') and
            while ( rs.next() ){  // found - return fullname
                names.add(new SelectItem(rs.getInt("bg_color_name")));
            }
            rs.close();
            con.close();
            return names;
        } catch(Exception ex) {
            return null;
        }
    } 
          
     } 
