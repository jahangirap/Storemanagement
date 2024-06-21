
<%
    if ((session.getAttribute("_username") == null) || (session.getAttribute("_username") == "")) {
        response.sendRedirect("index.jsp");
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>The financial training institute of malta</title>


<link rel="stylesheet" href="css/style_welcome.css" type="text/css" media="screen" />
</head>

<body>
	<!--strat header -->
    <div class="top-bar"></div>
	<div class="header">
    	
    	<div class="header_middle">
        	<!-- <div class="logo">
           
           <img src="images/logo.png" alt="logo" /> 
            <span class="slogan">financial training institute of malta</span>
            </div>-->
          
            	
                
               
          
        </div>
            
        <div class="clear"></div> 
        
    </div>
      <div class="header-menu">
                	<ul>
                        <li><a href="logout.jsp">LogOut</a></li>
                        <li><a href="accounts.jsp">Accounts</a></li>
                        <li><a href="distribution.jsp">Distribution</a></li>
                        <li><span class="active2 margin3">&nbsp;</span><a href="collectedproducts.jsp">Collected Products</a></li>
                        <li><a href="productadd.jsp">Product</a></li>
                    	<li><a href="category.jsp" >Category</a></li>
                        
                    </ul>
    </div>
    <div class="clear"></div>
    <div class="line_top"></div>
    <!--end header -->
    <!--start banner jquery image -->
   <!-- <div class="banner-image-training">
    	<div class="images"><img src="images/banner.jpg" alt="banner" height="190" width="953" /></div>
    </div>  -->
    <!--end banner jquery image -->
    
    <div class="clear"></div>
    <span></span>
    <div class="clear"></div>
    <span></span>
    <div class="bodycontent">
    	<div class="content">
            <label>Category Name:</label>
       <input name="categoryname" placeholder="category name" id="displayValue" style="position:relative;top:0px;left:0px;width:183px;width:180px\9;width:180px;height:20px; height:21px\9;height:18px;border:1px solid #556;" type="text"/><br/>
            <label>Category Description:</label>
            <textarea cols="10" rows="12"  name="catdesc" placeholder="category desc" style="position:relative;top:0px;left:0px;width:183px;width:180px\9;width:180px;height:20px; height:21px\9;height:18px;border:1px solid #556;" ></textarea><br/>
              </div>
    	<div class="clear"></div>
    </div>
    <div class="clear"></div>
   
    	<div class="clear"></div>
    </div>
    
    
    <div class="footer">
    	<div class="footer-content">
        	<div class="footer-left">
            	<ul>
                	<li> <a href="#" class="separator"><img src="images/f-in.png" alt="f" border="0"  /></a></li>
                   
                    <li><a href="#" class="separator"> <img src="images/saga.png" alt="saga" border="0" /></a></li>
                    <li><a href="#" class="separator"> <img src="images/egul.png" alt="egul" border="0"  /></a></li>
                    <li><a href="#" > <img src="images/bni.png" alt="bni" border="0"  /></a></li>
                </ul>
            </div>
           <div class="footer-right">
            	<div class="right-top">COPYRIGHT &copy; 2014 BASIC ICT LTD<span class="separator">&nbsp;&nbsp;</span>&nbsp;&nbsp;<a href="#">PRIVACY POLICY</a></div>
                <div class="right-bottom"><a href="#">SUPPORT BKIICT</a><span class="separator">&nbsp;&nbsp;</span>&nbsp&nbsp;<a href="#">BCC</a><span class="separator">&nbsp;&nbsp;</span>&nbsp;&nbsp;DESIGNED &amp; DEVELOPED BY MD. JAHANGIR ALAM, AP, BASIC ICT</div>
            </div>
        </div>
    </div>
</body>
</html>
