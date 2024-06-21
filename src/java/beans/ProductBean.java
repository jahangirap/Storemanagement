/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author sopa
 */
public class ProductBean {
    
    String catname;
    String productname;
    String productid;
    String productdesc;
    String msg;

    

    public ProductBean() {
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
  
    //product list in combo
    public List <SelectItem> getproductValue() {
        List<SelectItem>names=new ArrayList<SelectItem>();
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
     setProductdesc(null);
       getchangeItem();
       
   }
   
   public String changeItem(){
       try {
           System.out.println(catname);
           Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("SELECT prod_desc FROM product where prod_name='"+productname+"'");
              
               
            while ( rs.next() ){
                
               setProductdesc(rs.getString("prod_desc"));
            }
          
           
           
       } catch (Exception e) {
           e.getMessage();
       }
//       this.loginname="select";
       return "a";
   }  
   public void clear(){
       catname=null;
       msg=null;
       productname=null;
       productid=null;
       productdesc=null;
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
   public String insert(){
        
        try {
            if(!productname.isEmpty()){
                if(!productdesc.isEmpty()){
            Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("SELECT * FROM product where prod_name='"+productname+"' and cat_id = (select cat_id from category where cat_name='"+catname+"')");
              
               int i=0;
            while( rs.next() ){
                i++;
               
            }
            if(i>0){
//              customerid, loginname, password, reg_date, email, serialno  
                msg="Data Exist";
            }
            else{
                String sql="INSERT into product (prod_name,prod_desc,cat_id)values('"+productname+"','"+productdesc+"',(select cat_id from category where cat_name='"+catname+"'))";
                stmt.executeUpdate(sql);
                msg="Data inserted";
            }
            rs.close();
            con.close();
                }else{
                    msg="Select Subcategory Desc.";
                }
            }else{
                msg="Select SubCategory Name.";
            }
            return msg;
            
        } catch (Exception e) {
            
            msg=e.getMessage();
            return msg;
            
        }
    }
}
