/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author sopa
 */
public class CategoryBean {
    
    String catid;
    String catname;
    String catdesc;
    String msg;
    String newcatname;

    public CategoryBean() {
    }

    public CategoryBean(String catid, String catname, String catdesc, String msg) {
        this.catid = catid;
        this.catname = catname;
        this.catdesc = catdesc;
        this.msg = msg;
    }

    public CategoryBean(String catname, String catdesc, String msg) {
        this.catname = catname;
        this.catdesc = catdesc;
        this.msg = msg;
    }

    public String getNewcatname() {
        return newcatname;
    }

    public void setNewcatname(String newcatname) {
        this.newcatname = newcatname;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatdesc() {
        return catdesc;
    }

    public void setCatdesc(String catdesc) {
        this.catdesc = catdesc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    // get category name from category table in combobox
    public List<SelectItem> getuserName() {
        List<SelectItem> names = new ArrayList<SelectItem>();
        try {
            Connection con = Database.getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select cat_name FROM category ");

            while (rs.next()) {  // found - return fullname
                names.add(new SelectItem(rs.getString("cat_name")));
            }
            for(int i=0; i<names.size(); i++)
               // System.out.println(names.iterator().);
            rs.close();
            con.close();
            return names;
        } catch (Exception ex) {
            return null;
        }
    }
    // category combobox select change statement 
    public String changeItem() {
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM category where cat_name='" + catname + "'");


            while (rs.next()) {

                setCatdesc(rs.getString("cat_desc"));
               // setHidevalue(rs.getInt("image_id"));
            }



        } catch (Exception e) {
            e.getMessage();
        }
//       this.loginname="select";
        return "a";
    }
    public void clear(){
        
    }
    public String insert(){
        try {
            if (!catname.isEmpty()) {
                
                if(!catdesc.isEmpty()){
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM category where cat_name='" + catname + "'");

                int i = 0;
                while (rs.next()) {
                    i = rs.getRow();

                }
                if (i > 0) {
//              customerid, loginname, password, reg_date, email, serialno  
                    msg = "Data Exist";
                } else {
                    //String imgID = uploadBean.upload(uploadedFile, fileName, dbImage, _hidevalue);
                   // System.out.println(imgID);

                    String sql = "INSERT into category (cat_name,cat_desc)values('" + catname + "','" + catdesc + "')";
                    stmt.executeUpdate(sql);
                    msg = "Data inserted";
                }
                rs.close();
                con.close();
                }else{
                    msg="Write About Category";
                }
            }else{
                msg="Write Category Name";
            }
        } catch (SQLException e) {
           msg = e.getMessage();
        }
        
        return null;
    }
    public String update(){
        try {
            
            if(!catname.isEmpty()){
                if(!newcatname.isEmpty()){
            msg = "good";
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM category where cat_name='" + catname + "'");

            int i = 0;
            while (rs.next()) {
                i++;

            }
            if (i > 0) {
//              customerid, loginname, password, reg_date, email, serialno  
               // String imgID = uploadBean.upload(uploadedFile, fileName, dbImage, _hidevalue);
//                System.out.println(imgID);

                String sql = "update catagory set cat_name='" + newcatname + "',cat_desc='" + catdesc + "',image_id='" +msg + "' where cat_name='" + catname + "'";
                stmt.executeUpdate(sql);
                msg = "Data Updated";
            } else {
//                String sql="INSERT into catagory (cat_name,cat_desc)values('"+_catname+"','"+_catdesc+"')";

                msg = "No data available";
            }
            rs.close();
            con.close();
                }else{
                    msg = "Select New Category Name.";
                }
            }else{
                msg = "Select Catagory Name.";
            }
            return msg;

        } catch (Exception e) {

            msg = e.getMessage();
            return msg;

        }
    }
    public String delete(){
        
        
       return null;
    }
   
}
