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
            <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
            <title>BCC</title>
            <meta name="keywords" content="station shop, theme, free template, templatemo, CSS, HTML" />
            <meta name="description" content="Station Shop Theme, free CSS template provided by templatemo.com" />
            <link href="css/my_style.css" rel="stylesheet" type="text/css" />
            <link rel="stylesheet" type="text/css" href="css/style_welcome.css" />
            <link rel="stylesheet" type="text/css" media="all" href="css/jquery.dualSlider.0.2.css" />
                 

            <style type="text/css">
                .pic-normal {
                    width: 120px;
                    border: 2px solid #ACBECE;

                }
                .wrap1 {
                    width:190px;
                    height: 130px;
                    float: left;            
                }
            </style>
        </head>

        <body>
            
            <div id="my_wrapper">
                <div class="header">
                <div id="my_header">
                    
                  
                         <div id="header_top">
                          <div id="my_header_in">
                              
                                  <h1 class="t1">
                       BANGLADESH COMPUTER COUNCIL
                    </h1><br/>
                    <h4 class="t2">STORE MANAGEMENT SYSTEM</h4>
           </div>
                     </div>   
                         </div>
                    <div id="header_right">
                        <h:form>
                            <h:panelGrid width="350px" columns="1" border="0" style="text-align:left"  >
                                <rich:panel style="background-color:#C0C0C0;-moz-border-radius: 8px;
                                            -webkit-border-radius: 8px;
                                            -khtml-border-radius: 8px;
                                            border-radius: 8px;"  >
                                    <h:panelGrid columns="3">

                                        <h:outputText value="User ID:"/>
                                        <h:outputText value="Password:"/>
                                        <font color="red"><h:outputText  value="#{AdminBean.message}"/></font>
                                        <h:outputText value=" "/>
                                        
                                        
                                        <h:inputText id="log"  style="width:125px;"  value="#{AdminBean.username}"   /> 
                                        <h:inputSecret id="pwd"  style="width:125px;"  value="#{AdminBean.password}" />
                                        <h:commandButton value="Go" action="#{AdminBean.login}" style="width:60px" />


                                    </h:panelGrid>

                                    <rich:spacer height="20px"/>
                                    <rich:spacer height="20px"/>
                                    <h:outputLink value="search_email.jsp" style="color:#8fb410;">Forgot Password</h:outputLink>
                                    <font><h:outputText value="Or"/></font>
                                    <h:outputLink value="customer_reg.jsp" style="color:#8fb410;">User Registration</h:outputLink>

                                    <rich:spacer width="100px"/>

                                    <br/>


                                </rich:panel>    
                            </h:panelGrid>
                         </h:form> 
                    </div>

                    <div class="cleaner"></div>
                  
                </div>

               

                

               

            </div> <!-- END of templatemo_wrapper -->

        </body>
    </html>
</f:view>