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
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

/**
 *
 * @author bcc
 */
public class CollectedProductBean {
    
private String  vendorname;
private Date date=new Date();
private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
private Integer productNum;
private Double price;
private Double total;
private String calanno;
private String productname;
private String catname;
private String msg;
 @PostConstruct
      public void init(){
        this.setProductNum(0);
        this.setPrice(0.0);
        this.setTotal(0.0);
      }

   
//<h:inputText value="#{bean.minData}" binding="#{bean.inputComponent}"></h:inputText>

    public String getCalanno() {
        return calanno;
    }

    public void setCalanno(String calanno) {
        this.calanno = calanno;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }
    
  
   
    public void totalamount(){
        int q = this.getProductNum();
        System.out.println(q);
        Double p = this.getPrice();
        System.out.println(p);
        Double qp = (q*p);
        System.out.println("QP "+qp);
        this.setTotal(qp);
        
    }
   public void clear(){
        this.setProductNum(0);
        this.setPrice(0.0);
        this.setTotal(0.0);
        this.setVendorname(null);
        this.setCalanno(null);
        this.setCatname(null);
        this.setProductname(null);
       
        
    }
    public void insert(){
        try {
            Connection con = Database.getConnection();
            Statement stmt=con.createStatement();
             if(!vendorname.isEmpty()){
                ProductBean pb = new ProductBean();
                String sql="INSERT into collected_products (vendor_name, cat_id, prod_id, prod_number, price, total_amount, date_of_purchase, calan_no)values('"+vendorname+"',(select cat_id from category where cat_name='"+catname+"'),(select prod_id from product where prod_name='"+productname+"'),'"+productNum+"','"+price+"','"+total+"','"+formatter.format(this.getDate()) +"','"+calanno+"')";
                 System.out.println(sql);
                stmt.executeUpdate(sql);
                msg="Data inserted";
                    
                }else{
                 msg="Write Vendor Name";
             }
            con.close();
            clear();
        } catch (SQLException e) {
           msg= e.getMessage();
        }
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
