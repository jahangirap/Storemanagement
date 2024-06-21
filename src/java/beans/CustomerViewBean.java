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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author bcc
 */
public class CustomerViewBean {
    
    String catname;
    String productname;
    int availableQty;
    String customerid;
    String customername;
    String roomno;
    String msg;
    Date date=new Date();
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }
    public void clear(){
        this.setAvailableQty(0);
        this.setCatname(null);
        this.setCustomerid(null);
        this.setCustomername(null);
        this.setDate(date);
        this.setRoomno(null);
        this.setProductname(null);
    }
    public void insert(){
        try {
            Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
             if(!customername.isEmpty()){
                ProductBean pb = new ProductBean();
                String sql="INSERT into customer (cat_id, prod_id, customer_name, cust_Id, room_no,distribute_date)values((select cat_id from category where cat_name='"+catname+"'),(select prod_id from product where prod_name='"+productname+"'),'"+customername+"','"+customerid+"','"+roomno+"','"+formatter.format(this.getDate())+"')";
                 System.out.println(sql);
                stmt.executeUpdate(sql);
                msg="Data inserted";
                    
                }else{
                 msg="Write Vendor Name";
             }
            con.close();
            clear();
        } catch (SQLException e) {
            msg=e.getMessage();
        }
    }
    
    
    //product list in combo
    public List <SelectItem> getproductValue() {
        List<SelectItem>names=new ArrayList<SelectItem> ();
        try {
            Connection con = Database.getConnection();
            System.out.println(catname);
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT prod_name from product where cat_id=(select cat_id from category where cat_name='"+catname+"')");
            
            while ( rs.next() ){  // found - return fullname
                names.add(new SelectItem(rs.getString("prod_name")));
            }
            rs.close();
            con.close();
            return names;
        } catch(Exception ex) {
            return null;
        }
    } 
    
   
   
   
   public List <SelectItem> getchangeItem() {
        List<SelectItem>names=new ArrayList<SelectItem>();
        try {
            Connection con = Database.getConnection();
            
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT prod_name from product where cat_id=(select cat_id from category where cat_name='"+catname+"')");
            
            while ( rs.next() ){  // found - return fullname
                names.add(new SelectItem(rs.getString("prod_name")));
            }
            rs.close();
            con.close();
            return names;
        } catch(Exception ex) {
            return null;
        }
    }  
   public void loadcat(){
    // setProductdesc(null);
       getchangeItem();
       
   }
   // get category name from category table in combobox
    public List<SelectItem> getcatValue() {
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
}
