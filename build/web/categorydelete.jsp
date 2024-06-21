
<%
    if ((session.getAttribute("_username") == null) || (session.getAttribute("_username") == "")) {
        response.sendRedirect("index.jsp");
    }
%>
<%-- 
    Document   : inde
    Created on : Jul 22, 2012, 1:14:50 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://richfaces.org/a4j" prefix="a4j" %>
<%@taglib uri="http://richfaces.org/rich" prefix="rich" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<f:view>
    <html xmlns="http://www.w3.org/1999/xhtml">
        <head>
<title>BCC</title>


<link rel="stylesheet" href="css/style_welcome.css" type="text/css" media="screen" />
</head>

<body>
   
    <div class="wrapper">
	<!--strat header -->
    <div class="top-bar"></div>
	<div class="header">
    	
    	<div class="header_middle">
        	
            	
                
               
          
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
    
    <div class="clear"></div>
    <span></span>
    <div class="clear"></div>
    <span></span>
    <div class="bodycontent">
    	<div class="content">
            
            <h:form>
                <div class="content-left-next">
                    <div class="sidebar-menu">
                <ul>
                    <li class=""><a href="categoryadd.jsp">Category Add</a></li>
                     <li><a href="categoryupdate.jsp">Category Update</a></li>
                     <li><a href="categorydelete.jsp">Category Delete</a></li>
                </ul>
                </div>
                    </div>
                <div class="content-right">
                
                
                <h:outputText value="#{CategoryBean.msg}" ></h:outputText><br/>
                <h:outputText value="" >Category Name:</h:outputText>
                
                <h:inputText value="#{CategoryBean.catname}" id="catname" /><br/>
                
                
                <h:outputText value="" >Category Description:</h:outputText>
                <h:inputTextarea cols="30" rows="4" value="#{CategoryBean.catdesc}" id="catdesc" /><br/>
            
                <h:commandButton value="Delete" action="#{CategoryBean.delete}" />
            <h:commandButton value="Clear" action="#{CategoryBean.clear}"/>
            </div>
            </h:form>

             


      
        </div>
    	<div class="clear"></div>
    </div>
	
    <div class="clear"></div>
   
    	<div class="clear"></div>
   
  
    
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
	
    </div>
</body>
</html>
</f:view>
