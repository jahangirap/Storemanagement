
<%
    if ((session.getAttribute("_username") == null) || (session.getAttribute("_username") == "")) {
        response.sendRedirect("index.jsp");
    }
%>
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
            <h:form>
            <h:outputText value="#{distributionBean.msg}"/>   <br/>
                    
                

 <h:outputText value="Product Category:"/>
  <rich:comboBox id="cat" value="#{distributionBean.catnames}"  selectFirstOnUpdate="true" defaultLabel="Select Category Name:">
                                                <f:selectItems value="#{distributionBean.catValue}"/>
                                                <a4j:support action="#{distributionBean.loadcat}" reRender="productname,hide" event="onchange" ajaxSingle="true"/>
  </rich:comboBox><br/>
                   
  <h:inputHidden id="hide" value="#{distributionBean.hide}"  />  
     
 <h:outputText value="Products Name:"/> 
 <rich:comboBox id="productname" value="#{distributionBean.productname}"  selectFirstOnUpdate="true" defaultLabel="Select Product Name:">
                                                <f:selectItems value="#{distributionBean.productValue}"/>
                                                <a4j:support action="#{distributionBean.loadqty}" reRender="Qty" event="onchange" ajaxSingle="true"/>
                                               </rich:comboBox><br/>
  
<h:outputText value="Available Product:"/>
<h:inputText id="Qty" value="#{distributionBean.availableQty}">
     <f:convertNumber pattern="0.00"/>
</h:inputText><br/>

<h:outputText value="Distributed Product:"/>
<h:inputText id="distributedQty" value="#{distributionBean.distributedQty}">
    <f:convertNumber pattern="0.00"/>
    <a4j:support event="onkeyup" action="#{distributionBean.differ}" ajaxSingle="true" reRender="remainingQty"/>
</h:inputText><br/>

<h:outputText value="Remaining Product:"/>
<h:inputText id="remainingQty" value="#{distributionBean.remainingQty}">
     <f:convertNumber pattern="0.00"/>
</h:inputText><br/>

                <h:outputText value="Customer ID:"/>
                <h:inputText id="customerid"  value="#{distributionBean.customerid}"/><br/>
                
                <h:outputText value="Customer Name:"/>
                <h:inputText id="customername"  value="#{distributionBean.customername}"/><br/>
                
                <h:outputText value="Room No:"/>
                <h:inputText id="roomno"  value="#{distributionBean.roomno}"/><br/>
                <h:outputText value="Purchase Date:"/>
 <rich:calendar value="#{distributionBean.date}" id="date" datePattern="yyyy-MM-dd"/><br/>
                <h:commandButton value="SAVE" action="#{distributionBean.insert}" />
                </h:form>
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
</f:view>