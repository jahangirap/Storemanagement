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
public class DistributionBean {
    String catnames;
    String hide;
    String productname;
    int availableQty;
    int distributedQty;
    int remainingQty;
    String customerid;
    String customername;
    String roomno;
    String msg;
    Date date=new Date();
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public String getHide() {
        return hide;
    }

    public void setHide(String hide) {
        this.hide = hide;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDistributedQty() {
        return distributedQty;
    }

    public void setDistributedQty(int distributedQty) {
        this.distributedQty = distributedQty;
    }

    public int getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(int remainingQty) {
        this.remainingQty = remainingQty;
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

    public String getCatnames() {
        return catnames;
    }

    public void setCatnames(String catnames) {
        this.catnames = catnames;
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
   /* public void clear(){
        //this.setAvailableQty(0);
        this.setCatname(null);
        this.setCustomerid(null);
        this.setCustomername(null);
        this.setDate(date);
        this.setRoomno(null);
        this.setProductname(null);
    }*/
    
    public void differ(){
        int a=this.getAvailableQty();
        System.out.println(a);
        int d=this.getDistributedQty();
        System.out.println(d);
        int r= (a-d);
        System.out.println(r);
        this.setRemainingQty(r);
    }
    public void insert(){
        try {
            //customer_id, cat_id, prod_id, customer_name, cust_Id, room_no, distribute_date, dist_prod_num
            Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
             if(!customername.isEmpty()){
                ProductBean pb = new ProductBean();
                String sql="INSERT into customer (cat_id, prod_id, customer_name, cust_Id, room_no, distribute_date, dist_prod_num)values((select cat_id from category where cat_name='"+catnames+"'),(select prod_id from product where prod_name='"+productname+"'),'"+customername+"','"+customerid+"','"+roomno+"','"+formatter.format(this.getDate())+"','"+distributedQty+"')";
                 System.out.println(sql);
                stmt.executeUpdate(sql);
                msg="Data inserted";
                    
                }else{
                 msg="Write Vendor Name";
             }
            con.close();
           // clear();
        } catch (SQLException e) {
            msg=e.getMessage();
        }
    }
    
    
    //product list in combo
    public List <SelectItem> getproductValue() {
        List<SelectItem>names=new ArrayList<SelectItem> ();
        try {
            Connection con = Database.getConnection();
            System.out.println(catnames);
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT prod_name from product where cat_id=(select cat_id from category where cat_name='"+catnames+"')");
            
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
    public void loadqty(){
        try {
            
            System.out.println("Hello");
            System.out.println("C1"+hide);
            System.out.println("P"+productname);
           Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
            int counter1=0;
            int counter2=0;
            String sql1="SELECT SUM(prod_number) as prod_number FROM collected_products WHERE cat_id=(SELECT cat_id FROM category WHERE cat_name='"+catnames+"') AND prod_id=(SELECT prod_id FROM product WHERE prod_name='"+productname+"');";
            ResultSet rs=stmt.executeQuery(sql1);
              System.out.println(sql1);
               
            while ( rs.next() ){
                counter1+=rs.getInt("prod_number");
            }
            System.out.println("c1"+counter1);
            String sql2="SELECT SUM(dist_prod_num) as dist_prod_num FROM customer WHERE cat_id=(SELECT cat_id FROM category WHERE cat_name='"+catnames+"') AND prod_id=(SELECT prod_id FROM product WHERE prod_name='"+productname+"');";
          ResultSet rsnext=stmt.executeQuery(sql2);
              System.out.println(sql2);
               
            while ( rsnext.next() ){
                counter2+=rsnext.getInt("dist_prod_num");
            }
            System.out.println("c2"+counter2);
           this.setAvailableQty((counter1-counter2));
           
       } catch (SQLException e) {
          msg=e.getMessage();
       }
//       this.loginname="select";
       
    }
   
   
   
   public List <SelectItem> getchangeItem() {
        List<SelectItem>names=new ArrayList<SelectItem>();
        try {
            Connection con = Database.getConnection();
            this.setHide(catnames);
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT prod_name from product where cat_id=(select cat_id from category where cat_name='"+catnames+"')");
            
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
